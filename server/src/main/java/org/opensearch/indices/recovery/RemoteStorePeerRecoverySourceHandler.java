            assert Transports.assertNotTransportThread(this + "[prepareTargetForTranslog]");  
import org.opensearch.index.engine.RecoveryEngineException;
import org.opensearch.transport.Transports;  
                cancellableThreads,  
                shard.failShard("recovery", e);
import org.opensearch.index.seqno.SequenceNumbers;
import org.opensearch.index.seqno.RetentionLease;
 *
            if (Lucene.isCorruptionException(e)) {
 * compatible open source license.
    @Override  
    public RemoteStorePeerRecoverySourceHandler(  
import org.opensearch.common.SetOnce;
                shard,
            logger.debug("sendFileStep completed");
            );
import java.util.function.Consumer;  
        }, onFailure);  
        int fileChunkSizeInBytes,
            wrappedSafeSnapshot = acquireSafeCatalogSnapshot(shard);
        int maxConcurrentOperations
        }
            phase1(wrappedSafeSnapshot.get(), startingSeqNo, () -> 0, sendFileStep, true);
            RunUnderPrimaryPermit.run(
import org.opensearch.index.shard.IndexShard;  
            onSendFileStepCompleteCatalogSnapshot(sendFileStep, wrappedSafeSnapshot, releaseStore);
        sendFileStep.whenComplete(r -> {
        }, onFailure);
            final Releasable releaseStore = acquireStore(shard.store());
            assert Transports.assertNotTransportThread(this + "[phase1]");  
        // underlying indices are backed by remote store for storing segments and translog  
import java.io.IOException;
            sendSnapshotStep.onResponse(new SendSnapshotResult(endingSeqNo, 0, TimeValue.ZERO));
        final SetOnce<RetentionLease> retentionLeaseRef = new SetOnce<>();
 */  
        logger.trace("performing file-based recovery followed by history replay starting at [{}]", startingSeqNo);
    protected void innerRecoveryToTarget(ActionListener<RecoveryResponse> listener, Consumer<Exception> onFailure) throws IOException {
    ) {
        final StepListener<SendFileResult> sendFileStep = new StepListener<>();
import org.opensearch.indices.RunUnderPrimaryPermit;
import org.opensearch.common.lucene.Lucene;
                () -> shard.initiateTracking(request.targetAllocationId()),  
            assert Transports.assertNotTransportThread(this + "[phase2]");
        final StepListener<TimeValue> prepareEngineStep = new StepListener<>();
import org.opensearch.core.action.ActionListener;
    }
        try {  
            resources.add(wrappedSafeSnapshot);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.concurrent.GatedCloseable;  
 *
        ThreadPool threadPool,  
import org.opensearch.threadpool.ThreadPool;
            resources.add(releaseStore);  
        waitForAssignmentPropagate(retentionLeaseRef);  
        // It is always file based recovery while recovering replicas which are not relocating primary where the
 */  
        super(shard, recoveryTarget, threadPool, request, fileChunkSizeInBytes, maxConcurrentFileChunks, maxConcurrentOperations);  
        } catch (final Exception e) {  
import org.opensearch.common.lease.Releasable;
        assert startingSeqNo >= 0 : "startingSeqNo must be non negative. got: " + startingSeqNo;
        StartRecoveryRequest request,
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
        } catch (final Exception e) {
            throw new RecoveryEngineException(shard.shardId(), 1, "snapshot failed", e);
            final long endingSeqNo = shard.seqNoStats().getMaxSeqNo();  
        }
}
import org.opensearch.action.StepListener;
package org.opensearch.indices.recovery;
 * The OpenSearch Contributors require contributions made to  
        // and there is no translog replay done.
            throw new RecoveryEngineException(shard.shardId(), 1, "sendFileStep failed", e);  
        try {
        final StepListener<SendSnapshotResult> sendSnapshotStep = new StepListener<>();  
public class RemoteStorePeerRecoverySourceHandler extends RecoverySourceHandler {
/**
        prepareEngineStep.whenComplete(prepareEngineTime -> {
            prepareTargetForTranslog(0, prepareEngineStep);
                logger
            // For a sequence based recovery, the target can keep its local translog
        RecoveryTargetHandler recoveryTarget,
                shardId + " initiating tracking of " + request.targetAllocationId(),
import org.opensearch.common.unit.TimeValue;  
 * SPDX-License-Identifier: Apache-2.0
    }
        final long startingSeqNo = Long.parseLong(wrappedSafeSnapshot.get().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY)) + 1L;
        finalizeStepAndCompleteFuture(startingSeqNo, sendSnapshotStep, sendFileStep, prepareEngineStep, onFailure);
        IndexShard shard,
            }  
        int maxConcurrentFileChunks,  
 * This handler is used when peer recovery target is a remote store enabled replica.  
        // A replica of an index with remote translog does not require the translogs locally and keeps receiving the
        final GatedCloseable<CatalogSnapshot> wrappedSafeSnapshot;
            logger.debug("prepareEngineStep completed");  
/*  
        // updated segments file on refresh, flushes, and merges. In recovery, here, only file-based recovery is performed  
 * @opensearch.internal
