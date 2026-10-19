/*  
    public String toString() {
    public RecoveryTarget retryCopy() {  
             */
        });
                    store.associateIndexWithNewTranslog(translogUUID);
                // this means we transferred files from the remote that have not be checksummed and they are
            indexShard.prepareForIndexRecovery();
            state().getTranslog().totalOperations(totalTranslogOps);  
                // this is a fatal exception at this stage.  
        final long recoveryId = getId();
                throw new IndexShardNotRecoveringException(shardId(), indexShard().state());
        Store.MetadataSnapshot sourceMetadata,
            RecoveryState.Stage stage = indexShard.recoveryState().getStage();
        long globalCheckpoint,
        } catch (Exception e) {  
             * Bootstrap the max_seq_no_of_updates from the primary to make sure that the max_seq_no_of_updates on this replica when
             * (source of these operations) replicated via replication. Without this step, we may have duplicate documents if we  
        }
    @Override
        int totalTranslogOps,  
 *
        final RetentionLeases retentionLeases,
                threadPool.executor(ThreadPool.Names.GENERIC).execute(() -> { indexShard.refresh("remote store migration"); });
                        throw new AssertionError("unexpected failure while replicating translog entry", result.getFailure());  
    protected final MultiFileWriter multiFileWriter;
 * ownership. Elasticsearch licenses this file to you under  
                throw rfe;
            state().getIndex().setFileDetailsComplete(); // ops-based recoveries don't send the file details  
        }  
            indexShard().updateRetentionLeasesOnReplica(retentionLeases);
            // update stats only after all operations completed (to ensure that mapping updates don't mess with stats)
    @Override  
        return this.sourceNode;  
        boolean lastChunk,
            // Cleanup remote contents before opening new translog.
import org.opensearch.indices.replication.common.ReplicationFailedException;
                indexShard.maybeCheckIndex();  
import java.util.List;
        ActionListener.completeWith(listener, () -> {
             * the policy.
                indexShard.flush(new FlushRequest().force(true).waitIfOngoing(true));
            }
            /*
import org.opensearch.core.action.ActionListener;  
    }
    }
    public void finalizeRecovery(final long globalCheckpoint, final long trimAboveSeqNo, ActionListener<Void> listener) {
import org.opensearch.core.common.bytes.BytesReference;
    }
                // its content on disk if possible.
    protected String getPrefix() {  
                try {
            indexShard().sync();
 * You may obtain a copy of the License at  
    @Override  
    ) {
                );
            try {  
            multiFileWriter.writeFileChunk(fileMetadata, position, content, lastChunk);
import org.opensearch.index.shard.IndexShardState;  
        final int totalTranslogOps,
            /*  
     *  
                        indexShard.getPendingPrimaryTerm(),  
        return indexShard().shardPath().resolveTranslog();
        ActionListener<Void> listener  
            for (int i = 0; i < phase1ExistingFileNames.size(); i++) {  
        indexShard.postRecovery("peer recovery done");
    @Override
    }  
     * Creates a new recovery target object that represents a recovery to the provided shard.  
            }
                        indexShard.getPendingPrimaryTerm()  
                    final String translogUUID = Translog.createEmptyTranslog(
        }  
    Path translogLocation() {
            state().getTranslog().totalOperations(totalTranslogOps);
                    Translog.createEmptyTranslog(
                // broken. We have to clean up this shard entirely, remove all files and bubble it up to the
import org.apache.lucene.index.IndexFormatTooOldException;  
import org.opensearch.ExceptionsHelper;
                        store.removeCorruptionMarker();
                logger.debug("reset of recovery with shard {} and id [{}]", shardId(), recoveryId);
            if (indexShard.shouldSeedRemoteStore()) {  
            closedLatch.countDown();
    }
import org.opensearch.index.shard.IndexShardNotRecoveringException;
            // first, we go and move files that were created with the recovery id suffix to
    public RecoveryState state() {  
import org.opensearch.index.seqno.RetentionLeases;
        List<Long> phase1FileSizes,
 */  
                throw new IllegalStateException("cannot reset recovery as previous attempt made it past finalization step");
                        globalCheckpoint,
        long localCheckpointOfCommit = Long.parseLong(indexShard.commitStats().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));  
    }
                // recovery because we could have received operations above startingSeqNo from the previous primary terms.  
            state().getTranslog().totalOperations(totalTranslogOps);  
                    throw new MapperException("mapping updates are not allowed [" + operation + "]");
    @Override
    public void writeFileChunk(  
    }  
            return null;  
            return indexShard().getLocalCheckpoint();
            indexShard.performRecoveryRestart();
                newTargetCancellableThreads.execute(closedLatch::await);
    @Override
        indexShard.activateWithPrimaryContext(primaryContext);
        final ActionListener<Long> listener  
                indexShard.afterWriteOperation();  
        });
    @Override
            for (Translog.Operation operation : operations) {
     * Closes the current recovery target and waits up to a certain timeout for resources to be freed.  
    }  
import org.apache.lucene.index.IndexFormatTooNewException;
 */  
    private final DiscoveryNode sourceNode;  
                // We should erase all translog operations above trimAboveSeqNo as we have received either the same or a newer copy
                decRef();
    public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {
            // (situation in which primary fails over to docrep replica and is re-seeded to remote again)
                    shardId(),
    public CancellableThreads cancellableThreads() {
    @Override
            indexShard.finalizeRecovery();  
        this.sourceNode = sourceNode;  
            localCheckpointOfCommit + 1,  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.CorruptIndexException;
                store.cleanupAndVerify("recovery CleanFilesRequestHandler", sourceMetadata);
            final ReplicationLuceneIndex index = state().getIndex();
     */
            indexShard.updateGlobalCheckpointOnReplica(globalCheckpoint, "finalizing recovery");  
                }
                index.addFileDetail(phase1ExistingFileNames.get(i), phase1ExistingFileSizes.get(i), true);
import org.opensearch.index.store.Store;
        return indexShard.recoveryState();
    public void receiveFileInfo(  
                        indexShard.shardPath().resolveTranslog(),  
    public void handoffPrimaryContext(final ReplicationTracker.PrimaryContext primaryContext) {  
        final String tempFilePrefix = getPrefix() + UUIDs.randomBase64UUID() + ".";  
    @Override
    }
 * SPDX-License-Identifier: Apache-2.0
        ActionListener.completeWith(listener, () -> {
        ActionListener<Void> listener  
        final long maxSeqNoOfDeletesOrUpdatesOnPrimary,  
        try {  
                indexShard.waitForRemoteStoreSync(this::setLastAccessTime);  
             */  
            indexShard.recoveryStats().decCurrentAsTarget();
    public String source() {
            if (indexShard().state() != IndexShardState.RECOVERING) {  
    private final ThreadPool threadPool;  
            } catch (CancellableThreads.ExecutionCancelledException e) {
        return multiFileWriter.getTempNameForFile(origFile);
        if (finished.compareAndSet(false, true)) {
                    logger.debug("Failed to clean lucene index", e);  
     * Returns a fresh recovery target to retry recovery from the same source node onto the same shard and using the same listener.
            listener.onFailure(e);
             * replay these operations first (without timestamp), then optimize append-only requests (with timestamp).
     */
                // Replicas for segment replication or remote snapshot indices do not create
                // documents indexed and acknowledged before the reset.  
}
            Long.MAX_VALUE
     * @return a copy of this recovery target
    }  
 * compatible open source license.
    @Override  
import org.opensearch.action.admin.indices.flush.FlushRequest;
            }
                // trim the current generation. It's merely to satisfy the assumption that the current generation does not have any
 * Unless required by applicable law or agreed to in writing,
        List<Long> phase1ExistingFileSizes,
 * license agreements. See the NOTICE file distributed with
            indexShard.sync();
        });
import org.opensearch.index.translog.Translog;  
            listener.onResponse(null);
 * The OpenSearch Contributors require contributions made to  
            translog.totalOperations(totalTranslogOps);
    }
        ActionListener.completeWith(listener, () -> {
        super("recovery_status", indexShard, indexShard.recoveryState().getIndex(), listener);
                if (indexShard.getRetentionLeases().leases().isEmpty()) {
            return null;  
            indexShard().afterWriteOperation();  
                RecoveryFailedException rfe = new RecoveryFailedException(state(), "failed to clean after recovery", ex);
public class RecoveryTarget extends ReplicationTarget implements RecoveryTargetHandler {
 * the Apache License, Version 2.0 (the "License"); you may
                logger.info("Remote Store is now seeded for {}", indexShard.shardId());
                    }
            } finally {
                // their own commit points and therefore do not modify the commit user data
            }  
                fail(rfe, true);
    }  
            }  
    protected void closeInternal() {
        BytesReference content,  
    }
                // once primary relocation has moved past the finalization step, the relocation source can put the target into primary mode  
            // which might end up causing a TranslogCorruptedException
                final boolean reuseTranslogUUID = indexShard.indexSettings().isSegRepEnabledOrRemoteNode()
            } catch (CorruptIndexException | IndexFormatTooNewException | IndexFormatTooOldException ex) {
    private boolean hasUncommittedOperations() throws IOException {
            indexShard.persistRetentionLeases();  
                        globalCheckpoint,
                    ex.addSuppressed(e);
 * KIND, either express or implied.  See the License for the
                indexShard.rollTranslogGeneration();
    /**
    public void indexTranslogOperations(
            if (indexShard.shouldSeedRemoteStore()) {  
    /** Get a temporary name for the provided file name. */
    /**
     * Returns true if resetting the recovery was successful, false if the recovery target is already cancelled / failed or marked as done.
    public void notifyListener(ReplicationFailedException e, boolean sendShardFailure) {
            } catch (Exception ex) {  
        this.multiFileWriter = new MultiFileWriter(indexShard.store(), stateIndex, tempFilePrefix, logger, this::ensureRefCount);
                // in their store. In these cases, reuse the primary's translog UUID.  
    ) {
        int totalTranslogOps,
        final long maxSeenAutoIdTimestampOnPrimary,
            // This prevents reading from any old Translog UUIDs during re-seeding  
package org.opensearch.indices.recovery;
            try {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.util.CancellableThreads;
                    "new recovery target cancelled for shard {} while waiting on old recovery target with id [{}] to close",
                    recoveryId  
                if (result.getFailure() != null) {
            // to recover from in case of a full cluster shutdown just when this code executes...  
    public String description() {
 * Represents a recovery where the current node is the target node of the recovery. To track recoveries in a central place, instances of
                indexShard.trimOperationOfPreviousPrimaryTerms(trimAboveSeqNo);
            indexShard.resetRecoveryStage();  
                        FileChannel::open
 *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.node.DiscoveryNode;  
    public RecoveryTarget(IndexShard indexShard, DiscoveryNode sourceNode, ReplicationListener listener, ThreadPool threadPool) {
                } else {
            }
            assert indexShard().recoveryState() == state();
                fail(rfe, true);
                assert indexShard.routingEntry().primary() : "Remote seeding should only true be for primary shard copy";
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.index.seqno.ReplicationTracker;
 * not use this file except in compliance with the License.
    private final CountDownLatch closedLatch = new CountDownLatch(1);
     * @param indexShard local shard where we want to recover to
            store.decRef();  
                    );
    }  
 *  
                    // if empty, may be a fresh IndexShard, so write an empty leases file to disk  
import org.opensearch.index.engine.Engine;
        final long mappingVersionOnPrimary,
            if (trimAboveSeqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
                if (reuseTranslogUUID) {  
            return null;
                // source shard since this index might be broken there as well? The Source can handle this and checks  
                return false;
 *
        throw new UnsupportedOperationException("Method not supported on target!");  
                    if (Assertions.ENABLED && result.getFailure() instanceof MapperException == false) {
            RecoverySourceHandler.PEER_RECOVERY_NAME,
    }
            indexShard().advanceMaxSeqNoOfUpdatesOrDeletes(maxSeqNoOfDeletesOrUpdatesOnPrimary);
                }  
                indexShard.deleteRemoteStoreContents();
                    || indexShard.indexSettings().isRemoteSnapshot();
            return true;
/*
                } catch (Exception e) {
    }
        return "recovery from " + source();  
            }  
/**
        return sourceNode.toString();
        List<String> phase1FileNames,
import static org.opensearch.index.translog.Translog.TRANSLOG_UUID_KEY;
        ) > 0;
            for (int i = 0; i < phase1FileNames.size(); i++) {  
                    );  
    }
import java.io.IOException;
 * specific language governing permissions and limitations
    ) {
             * The maxSeenAutoIdTimestampOnPrimary received from the primary is at least the highest auto_id_timestamp from any operation
        listener.onFailure(state(), new RecoveryFailedException(state(), e.getMessage(), e), sendShardFailure);
    }
            indexShard().updateMaxUnsafeAutoIdTimestamp(maxSeenAutoIdTimestampOnPrimary);  
            if (indexShard.recoveryState().getPrimary() && (stage == RecoveryState.Stage.FINALIZE || stage == RecoveryState.Stage.DONE)) {
                index.addFileDetail(phase1FileNames.get(i), phase1FileSizes.get(i), false);
             */
        ActionListener.completeWith(listener, () -> {
import org.opensearch.common.lucene.Lucene;  
                    try {  
                        shardId(),
     * @param listener   called when recovery is completed/failed
             * We have to update the retention leases before we start applying translog operations to ensure we are retaining according to
 * software distributed under the License is distributed on an
        ActionListener.completeWith(listener, () -> {
        final List<Translog.Operation> operations,  
import org.opensearch.core.Assertions;
            final RecoveryState.Translog translog = state().getTranslog();  
    @Override
                RecoveryFailedException rfe = new RecoveryFailedException(state(), "failed to clean after recovery", ex);  
import org.opensearch.common.annotation.PublicApi;
                // state could mean that indexing is halted until the recovery retry attempt is completed and could also destroy existing
            final Store store = store();
    @Override  
import java.nio.channels.FileChannel;  
    public DiscoveryNode sourceNode() {
        return RECOVERY_PREFIX;
                state().setStage(RecoveryState.Stage.TRANSLOG);
        return false;
    /*** Implementation of {@link RecoveryTargetHandler } */
            try {
            return null;
import org.opensearch.indices.replication.common.ReplicationListener;  
        indexShard.recoveryStats().incCurrentAsTarget();
                throw rfe;  
                    final String translogUUID = store.getMetadata().getCommitUserData().get(TRANSLOG_UUID_KEY);
    public boolean reset(CancellableThreads newTargetCancellableThreads) throws IOException {  
             * replaying any of these operations will be at least the max_seq_no_of_updates on the primary when that op was executed on.  
 * Licensed to Elasticsearch under one or more contributor  
                }  
                    assert indexShard.loadRetentionLeases().leases().isEmpty();
import org.opensearch.index.shard.IndexShard;
    }
import java.util.concurrent.CountDownLatch;  
import org.opensearch.common.UUIDs;
                    ExceptionsHelper.reThrowIfNotNull(result.getFailure());
        return indexShard.countNumberOfHistoryOperations(
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
            indexShard().openEngineAndSkipTranslogRecovery();
        });
                        Lucene.cleanLuceneIndex(store.directory()); // clean up and delete all files  
            multiFileWriter.close();
            // the actual names, its ok if we have a corrupted index here, since we have replicas
        ActionListener<Void> listener  
@PublicApi(since = "1.0.0")
        this.threadPool = threadPool;
                // the flush or translog generation threshold can be reached after we roll a new translog
            if (hasUncommittedOperations()) {  
    }  
                logger.info("Remote Store seeding starting for {}", indexShard.shardId());
    }  
            }  
                // from the recovery source in phase2. Rolling a new translog generation is not strictly required here for we won't  
    }
                    indexShard.persistRetentionLeases();
        assert multiFileWriter.tempFileNames.isEmpty() : "not all temporary files are renamed";  
    private static final String RECOVERY_PREFIX = "recovery.";
import org.opensearch.indices.replication.common.ReplicationCollection;
                logger.trace(  
                // operation that would be trimmed (see TranslogWriter#assertNoSeqAbove). This assumption does not hold for peer
                if (result.getResultType() == Engine.Result.Type.MAPPING_UPDATE_REQUIRED) {
    ) {
        return cancellableThreads;
             * will be replayed. Bootstrapping this timestamp here will disable the optimization for original append-only requests
import org.opensearch.indices.replication.common.ReplicationTarget;
            }
            // upload to remote store in migration for primary shard
            // Persist the global checkpoint.
            }
                Engine.Result result = indexShard().applyTranslogOperation(operation, Engine.Operation.Origin.PEER_RECOVERY);  
            state().getTranslog().totalOperationsOnStart(totalTranslogOps);
    @Override
                    assert indexShard.assertRetentionLeasesPersisted();
    protected void onDone() {
    public String getTempNameForFile(String origFile) {  
        return shardId() + " [" + getId() + "]";
    }  
     * @param threadPool threadpool instance
        return new RecoveryTarget(indexShard, sourceNode, listener, threadPool);
                // release the initial reference. recovery files will be cleaned as soon as ref count goes to zero, potentially now.  
                store.decRef();
            }
                        shardId(),
        long position,
            multiFileWriter.renameAllTempFiles();
            } finally {
     */  
    public void cleanFiles(
            index.setFileDetailsComplete();  
                }
        });
            }
 * GitHub history for details.
                        indexShard.shardPath().resolveTranslog(),  
                    }
     *
    /**
import org.opensearch.index.mapper.MapperException;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void forceSegmentFileSync() {
                assert stage != RecoveryState.Stage.DONE : "recovery should not have completed when it's being reset";
        int totalTranslogOps,
            // roll over / flush / trim if needed
            state().getTranslog().totalOperations(totalTranslogOps);
            /*  
            translog.incrementRecoveredOperations(operations.size());  
                }  
            store.incRef();  
                    } finally {
                        translogUUID,
import org.opensearch.index.store.StoreFileMetadata;
import java.nio.file.Path;
 */
        List<String> phase1ExistingFileNames,  
        StoreFileMetadata fileMetadata,
        } finally {
import org.opensearch.index.seqno.SequenceNumbers;  
    // latch that can be used to blockingly wait for RecoveryTarget to be closed  
     * @param sourceNode source node of the recovery where we recover from  
 * under the License.  
 */  
    }  
 * @opensearch.api
                // and start indexing as primary into the target shard (see TransportReplicationAction). Resetting the target shard in this
        try {
 * this work for additional information regarding copyright
 * this class are created through {@link ReplicationCollection}.  
                } else {  
