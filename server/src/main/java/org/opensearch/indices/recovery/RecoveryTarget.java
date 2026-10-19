/*
                        indexShard.getPendingPrimaryTerm()
                if (reuseTranslogUUID) {
                    );
            indexShard().advanceMaxSeqNoOfUpdatesOrDeletes(maxSeqNoOfDeletesOrUpdatesOnPrimary);
        if (finished.compareAndSet(false, true)) {
                // release the initial reference. recovery files will be cleaned as soon as ref count goes to zero, potentially now.
    protected final MultiFileWriter multiFileWriter;
     *
     * @param sourceNode source node of the recovery where we recover from
        } catch (Exception e) {
            return null;
                // in their store. In these cases, reuse the primary's translog UUID.
                    || indexShard.indexSettings().isRemoteSnapshot();
    private final DiscoveryNode sourceNode;
    }
            final RecoveryState.Translog translog = state().getTranslog();
    }
                if (result.getResultType() == Engine.Result.Type.MAPPING_UPDATE_REQUIRED) {
        return "recovery from " + source();
    ) {
        final ActionListener<Long> listener
        });
    public RecoveryTarget(IndexShard indexShard, DiscoveryNode sourceNode, ReplicationListener listener, ThreadPool threadPool) {
            // upload to remote store in migration for primary shard
                    try {
                assert stage != RecoveryState.Stage.DONE : "recovery should not have completed when it's being reset";
    @Override
import org.opensearch.cluster.node.DiscoveryNode;
    public void cleanFiles(
import org.apache.lucene.index.CorruptIndexException;
    }
            state().getTranslog().totalOperationsOnStart(totalTranslogOps);
                    "new recovery target cancelled for shard {} while waiting on old recovery target with id [{}] to close",
        return indexShard.countNumberOfHistoryOperations(
            indexShard().sync();
        return shardId() + " [" + getId() + "]";
            return indexShard().getLocalCheckpoint();
    /** Get a temporary name for the provided file name. */
}
import java.nio.file.Path;
                        FileChannel::open
        StoreFileMetadata fileMetadata,
    // latch that can be used to blockingly wait for RecoveryTarget to be closed
                }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.Assertions;
        ActionListener.completeWith(listener, () -> {
            }
        int totalTranslogOps,
    /*** Implementation of {@link RecoveryTargetHandler } */
    public String getTempNameForFile(String origFile) {
import java.io.IOException;
                index.addFileDetail(phase1ExistingFileNames.get(i), phase1ExistingFileSizes.get(i), true);
                    throw new MapperException("mapping updates are not allowed [" + operation + "]");
                }
            } finally {
            }
import org.opensearch.index.store.Store;
    public DiscoveryNode sourceNode() {
            }
    @Override
import org.opensearch.indices.replication.common.ReplicationTarget;
                try {
                store.cleanupAndVerify("recovery CleanFilesRequestHandler", sourceMetadata);
                }
            // roll over / flush / trim if needed
import static org.opensearch.index.translog.Translog.TRANSLOG_UUID_KEY;
        }
            listener.onFailure(e);
                    Translog.createEmptyTranslog(
                    assert indexShard.assertRetentionLeasesPersisted();
            } catch (Exception ex) {
     */
 * SPDX-License-Identifier: Apache-2.0
            if (indexShard.shouldSeedRemoteStore()) {
                );
        return sourceNode.toString();
        }
import java.nio.channels.FileChannel;
    ) {
    }
 */
            indexShard.finalizeRecovery();
            // Cleanup remote contents before opening new translog.
    }
    @Override
 * Unless required by applicable law or agreed to in writing,
            } finally {
                RecoveryFailedException rfe = new RecoveryFailedException(state(), "failed to clean after recovery", ex);
import org.opensearch.action.admin.indices.flush.FlushRequest;
import org.opensearch.index.shard.IndexShardNotRecoveringException;
                    if (Assertions.ENABLED && result.getFailure() instanceof MapperException == false) {
             * We have to update the retention leases before we start applying translog operations to ensure we are retaining according to
                decRef();
                state().setStage(RecoveryState.Stage.TRANSLOG);
                logger.info("Remote Store is now seeded for {}", indexShard.shardId());
            try {
        BytesReference content,
 */
            closedLatch.countDown();
            }
     * Creates a new recovery target object that represents a recovery to the provided shard.
     * Returns true if resetting the recovery was successful, false if the recovery target is already cancelled / failed or marked as done.
                store.decRef();
                    }
            // the actual names, its ok if we have a corrupted index here, since we have replicas
 *
     * @param listener   called when recovery is completed/failed
            Long.MAX_VALUE
import org.opensearch.index.shard.IndexShardState;
            // update stats only after all operations completed (to ensure that mapping updates don't mess with stats)
import org.opensearch.core.common.bytes.BytesReference;
        }
                // documents indexed and acknowledged before the reset.
        final List<Translog.Operation> operations,
            // Persist the global checkpoint.
                if (indexShard.getRetentionLeases().leases().isEmpty()) {
            }
                // once primary relocation has moved past the finalization step, the relocation source can put the target into primary mode
    public void notifyListener(ReplicationFailedException e, boolean sendShardFailure) {
import org.opensearch.index.translog.Translog;
        return indexShard.recoveryState();
                    final String translogUUID = store.getMetadata().getCommitUserData().get(TRANSLOG_UUID_KEY);
            }
            /*
    @Override
        return multiFileWriter.getTempNameForFile(origFile);
        throw new UnsupportedOperationException("Method not supported on target!");
            } catch (CancellableThreads.ExecutionCancelledException e) {
    private boolean hasUncommittedOperations() throws IOException {
            // to recover from in case of a full cluster shutdown just when this code executes...
            /*
                        throw new AssertionError("unexpected failure while replicating translog entry", result.getFailure());
                logger.trace(
                // this means we transferred files from the remote that have not be checksummed and they are
 *
                // Replicas for segment replication or remote snapshot indices do not create
 * the Apache License, Version 2.0 (the "License"); you may
        try {
 *
             * (source of these operations) replicated via replication. Without this step, we may have duplicate documents if we
                    final String translogUUID = Translog.createEmptyTranslog(
            listener.onResponse(null);
                    logger.debug("Failed to clean lucene index", e);
        return indexShard().shardPath().resolveTranslog();
 * GitHub history for details.
import org.opensearch.common.util.CancellableThreads;
            try {
    public RecoveryTarget retryCopy() {
    @Override
 * @opensearch.api
        return new RecoveryTarget(indexShard, sourceNode, listener, threadPool);
    }
                if (result.getFailure() != null) {
                // its content on disk if possible.
        ActionListener.completeWith(listener, () -> {
    }
        this.threadPool = threadPool;
            if (indexShard.shouldSeedRemoteStore()) {
            localCheckpointOfCommit + 1,
        try {
                logger.debug("reset of recovery with shard {} and id [{}]", shardId(), recoveryId);
            indexShard.recoveryStats().decCurrentAsTarget();
    }
                // state could mean that indexing is halted until the recovery retry attempt is completed and could also destroy existing
        List<String> phase1FileNames,
                        shardId(),
            store.incRef();
                throw new IndexShardNotRecoveringException(shardId(), indexShard().state());
                    shardId(),
import org.apache.lucene.index.IndexFormatTooNewException;
                // the flush or translog generation threshold can be reached after we roll a new translog
        final String tempFilePrefix = getPrefix() + UUIDs.randomBase64UUID() + ".";
        List<String> phase1ExistingFileNames,
 * compatible open source license.
    }
    private final CountDownLatch closedLatch = new CountDownLatch(1);
        List<Long> phase1FileSizes,
 * Represents a recovery where the current node is the target node of the recovery. To track recoveries in a central place, instances of
             * The maxSeenAutoIdTimestampOnPrimary received from the primary is at least the highest auto_id_timestamp from any operation
            // (situation in which primary fails over to docrep replica and is re-seeded to remote again)
                    recoveryId
                // We should erase all translog operations above trimAboveSeqNo as we have received either the same or a newer copy
                return false;
             * will be replayed. Bootstrapping this timestamp here will disable the optimization for original append-only requests
             */
        long position,
 * specific language governing permissions and limitations
                }
            state().getTranslog().totalOperations(totalTranslogOps);
import org.opensearch.index.shard.IndexShard;
            state().getIndex().setFileDetailsComplete(); // ops-based recoveries don't send the file details
            if (hasUncommittedOperations()) {
    public void receiveFileInfo(
    }
                fail(rfe, true);
            } catch (CorruptIndexException | IndexFormatTooNewException | IndexFormatTooOldException ex) {
            }
                    assert indexShard.loadRetentionLeases().leases().isEmpty();
    }
    public void handoffPrimaryContext(final ReplicationTracker.PrimaryContext primaryContext) {
        boolean lastChunk,
                    store.associateIndexWithNewTranslog(translogUUID);
            state().getTranslog().totalOperations(totalTranslogOps);
            }
            final ReplicationLuceneIndex index = state().getIndex();
        Store.MetadataSnapshot sourceMetadata,
        assert multiFileWriter.tempFileNames.isEmpty() : "not all temporary files are renamed";
    }
import org.opensearch.index.engine.Engine;
        } finally {
                    } finally {
     */
                // broken. We have to clean up this shard entirely, remove all files and bubble it up to the
 * not use this file except in compliance with the License.
        this.sourceNode = sourceNode;
        ) > 0;
                        translogUUID,
 */
        super("recovery_status", indexShard, indexShard.recoveryState().getIndex(), listener);
                } else {
                        indexShard.shardPath().resolveTranslog(),
    public void writeFileChunk(
                indexShard.flush(new FlushRequest().force(true).waitIfOngoing(true));
                assert indexShard.routingEntry().primary() : "Remote seeding should only true be for primary shard copy";
        ActionListener.completeWith(listener, () -> {
            assert indexShard().recoveryState() == state();
import org.opensearch.ExceptionsHelper;
    @Override
                throw rfe;
    }
            }
                indexShard.afterWriteOperation();
 * this work for additional information regarding copyright
            if (indexShard().state() != IndexShardState.RECOVERING) {
            multiFileWriter.renameAllTempFiles();
        this.multiFileWriter = new MultiFileWriter(indexShard.store(), stateIndex, tempFilePrefix, logger, this::ensureRefCount);
    Path translogLocation() {
    ) {
    }
    }
            translog.totalOperations(totalTranslogOps);
        indexShard.activateWithPrimaryContext(primaryContext);
import org.opensearch.indices.replication.common.ReplicationCollection;
 * Modifications Copyright OpenSearch Contributors. See
                RecoveryFailedException rfe = new RecoveryFailedException(state(), "failed to clean after recovery", ex);
import java.util.concurrent.CountDownLatch;
                newTargetCancellableThreads.execute(closedLatch::await);
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
        final int totalTranslogOps,
            // first, we go and move files that were created with the recovery id suffix to
            index.setFileDetailsComplete();
        });
                threadPool.executor(ThreadPool.Names.GENERIC).execute(() -> { indexShard.refresh("remote store migration"); });
             * Bootstrap the max_seq_no_of_updates from the primary to make sure that the max_seq_no_of_updates on this replica when
            return true;
/*
    @Override
        int totalTranslogOps,
             * replaying any of these operations will be at least the max_seq_no_of_updates on the primary when that op was executed on.
 * license agreements. See the NOTICE file distributed with
                        Lucene.cleanLuceneIndex(store.directory()); // clean up and delete all files
            state().getTranslog().totalOperations(totalTranslogOps);
            }
                        indexShard.getPendingPrimaryTerm(),
                        globalCheckpoint,
    @Override
 * The OpenSearch Contributors require contributions made to
        ActionListener.completeWith(listener, () -> {
import java.util.List;
    public String description() {
import org.opensearch.index.mapper.MapperException;
    public CancellableThreads cancellableThreads() {
                final boolean reuseTranslogUUID = indexShard.indexSettings().isSegRepEnabledOrRemoteNode()
                // operation that would be trimmed (see TranslogWriter#assertNoSeqAbove). This assumption does not hold for peer
 * this class are created through {@link ReplicationCollection}.
            RecoverySourceHandler.PEER_RECOVERY_NAME,
                    }
    }
            // which might end up causing a TranslogCorruptedException
    public RecoveryState state() {
 *
                    ex.addSuppressed(e);
     * Returns a fresh recovery target to retry recovery from the same source node onto the same shard and using the same listener.
             * replay these operations first (without timestamp), then optimize append-only requests (with timestamp).
     */
                indexShard.rollTranslogGeneration();
    ) {
 * Licensed to Elasticsearch under one or more contributor
                indexShard.maybeCheckIndex();
            indexShard.performRecoveryRestart();
            indexShard().updateMaxUnsafeAutoIdTimestamp(maxSeenAutoIdTimestampOnPrimary);
    /**
    @Override
@PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.index.store.StoreFileMetadata;
/*
        ActionListener<Void> listener
import org.opensearch.indices.replication.common.ReplicationFailedException;
            }
                        shardId(),
                } else {
                indexShard.deleteRemoteStoreContents();
    public void indexTranslogOperations(
            RecoveryState.Stage stage = indexShard.recoveryState().getStage();
    protected void closeInternal() {
    /**
    }
             * the policy.
    @Override
                // and start indexing as primary into the target shard (see TransportReplicationAction). Resetting the target shard in this
    }
                // trim the current generation. It's merely to satisfy the assumption that the current generation does not have any
        indexShard.postRecovery("peer recovery done");
    public boolean reset(CancellableThreads newTargetCancellableThreads) throws IOException {
                logger.info("Remote Store seeding starting for {}", indexShard.shardId());
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under
        int totalTranslogOps,
            if (indexShard.recoveryState().getPrimary() && (stage == RecoveryState.Stage.FINALIZE || stage == RecoveryState.Stage.DONE)) {
                        indexShard.shardPath().resolveTranslog(),
            /*
/**
    private static final String RECOVERY_PREFIX = "recovery.";
    @Override
            return null;
import org.opensearch.index.seqno.SequenceNumbers;
                // source shard since this index might be broken there as well? The Source can handle this and checks
            final Store store = store();
        final RetentionLeases retentionLeases,
                throw new IllegalStateException("cannot reset recovery as previous attempt made it past finalization step");
    protected void onDone() {
        long localCheckpointOfCommit = Long.parseLong(indexShard.commitStats().getUserData().get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
     *
            // This prevents reading from any old Translog UUIDs during re-seeding
    @Override
import org.opensearch.common.lucene.Lucene;
    /**
    }
    public void finalizeRecovery(final long globalCheckpoint, final long trimAboveSeqNo, ActionListener<Void> listener) {
     * @param indexShard local shard where we want to recover to
            multiFileWriter.close();
                indexShard.waitForRemoteStoreSync(this::setLastAccessTime);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            return null;
import org.opensearch.index.seqno.ReplicationTracker;
            for (Translog.Operation operation : operations) {
                    indexShard.persistRetentionLeases();
import org.opensearch.common.UUIDs;
            indexShard().openEngineAndSkipTranslogRecovery();
            for (int i = 0; i < phase1FileNames.size(); i++) {
    public void forceSegmentFileSync() {
    }
            return null;
                    ExceptionsHelper.reThrowIfNotNull(result.getFailure());
                }
            indexShard().afterWriteOperation();
import org.opensearch.index.seqno.RetentionLeases;
    public String source() {
     * Closes the current recovery target and waits up to a certain timeout for resources to be freed.
    @Override
                // recovery because we could have received operations above startingSeqNo from the previous primary terms.
    public String toString() {
             */
        ActionListener<Void> listener
            translog.incrementRecoveredOperations(operations.size());
    protected String getPrefix() {
    }
        });
        ActionListener<Void> listener
                    // if empty, may be a fresh IndexShard, so write an empty leases file to disk
                // this is a fatal exception at this stage.
import org.opensearch.core.action.ActionListener;
     * @param threadPool threadpool instance
            indexShard.sync();
        return RECOVERY_PREFIX;
 * You may obtain a copy of the License at
        indexShard.recoveryStats().incCurrentAsTarget();
package org.opensearch.indices.recovery;
            store.decRef();
        return this.sourceNode;
 * KIND, either express or implied.  See the License for the
        final long mappingVersionOnPrimary,
    public void prepareForTranslogOperations(int totalTranslogOps, ActionListener<Void> listener) {
        listener.onFailure(state(), new RecoveryFailedException(state(), e.getMessage(), e), sendShardFailure);
                        globalCheckpoint,
             */
    }
        long globalCheckpoint,
        ActionListener.completeWith(listener, () -> {
        });
                // their own commit points and therefore do not modify the commit user data
                fail(rfe, true);
            indexShard.updateGlobalCheckpointOnReplica(globalCheckpoint, "finalizing recovery");
        });
            try {
            indexShard().updateRetentionLeasesOnReplica(retentionLeases);
        return cancellableThreads;
            indexShard.resetRecoveryStage();
public class RecoveryTarget extends ReplicationTarget implements RecoveryTargetHandler {
            if (trimAboveSeqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
        final long maxSeqNoOfDeletesOrUpdatesOnPrimary,
                } catch (Exception e) {
 */
                indexShard.trimOperationOfPreviousPrimaryTerms(trimAboveSeqNo);
    }
    private final ThreadPool threadPool;
import org.apache.lucene.index.IndexFormatTooOldException;
            }
                throw rfe;
 * under the License.
            indexShard.prepareForIndexRecovery();
                    );
                Engine.Result result = indexShard().applyTranslogOperation(operation, Engine.Operation.Origin.PEER_RECOVERY);
 *    http://www.apache.org/licenses/LICENSE-2.0
            state().getTranslog().totalOperations(totalTranslogOps);
            multiFileWriter.writeFileChunk(fileMetadata, position, content, lastChunk);
                index.addFileDetail(phase1FileNames.get(i), phase1FileSizes.get(i), false);
        List<Long> phase1ExistingFileSizes,
                        store.removeCorruptionMarker();
     * @return a copy of this recovery target
            for (int i = 0; i < phase1ExistingFileNames.size(); i++) {
            indexShard.persistRetentionLeases();
import org.opensearch.indices.replication.common.ReplicationListener;
                // from the recovery source in phase2. Rolling a new translog generation is not strictly required here for we won't
        final long maxSeenAutoIdTimestampOnPrimary,
        return false;
        final long recoveryId = getId();
import org.opensearch.threadpool.ThreadPool;
