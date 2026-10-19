        final boolean indexShouldExists = recoveryState.getRecoverySource().getType() != RecoverySource.Type.EMPTY_STORE;  
                    shallowCopyShardMetadata.getRemoteStorePathStrategy(),
                        @Override
                indexShard.openEngineAndSkipTranslogRecoveryFromSnapshot();
 * the Apache License, Version 2.0 (the "License"); you may
            final long l = from.fileLength(src);
                }
                assert indexShard.shardRouting.primary() : "only primary shards can recover from store";
package org.opensearch.index.shard;
            indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());
            store.decRef();
            } else {
                    restoreSource.snapshot().getSnapshotId(),
                }
            translogState.totalOperations(0);
        indexShard.persistRetentionLeases();
            FileChannel::open
            }  
            try {  
        }
            if (canRecover(indexShard)) {  
            writer.addIndexes(sources);
            Sort indexSort = indexShard.getIndexSort();
        IndexShard indexShard,  
                }
                indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());
            IndexMetadata sourceMetadata = shards.get(0).getIndexMetadata();
                SnapshotRecoverySource recoverySource = (SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource();
            : "unsupported recovery source for search replica: " + recoveryState.getRecoverySource().getType();
                    RemoteSegmentStoreDirectoryFactory directoryFactory = new RemoteSegmentStoreDirectoryFactory(
            restoreListener.onFailure(e);
                } else {
            index.addFileDetail(name, length, true);
        indexShard.preRecovery();  
import org.opensearch.index.translog.Translog;
        try {
        String translogUUID = store.readLastCommittedSegmentsInfo().getUserData().get(Translog.TRANSLOG_UUID_KEY);
                            shardId,
import org.opensearch.cluster.metadata.MappingMetadata;  
                        sb  
                    internalRecoverFromStore(indexShard);
            } else {
        final Store store = indexShard.store();
     */
                    internalRecoverFromStore(indexShard);
                    throw new IndexShardRecoveryException(indexShard.shardId(), "failed to recover from local shards", ex);
            Set<Index> indices = shards.stream().map((s) -> s.getIndex()).collect(Collectors.toSet());
                            input.readBytes(b, offset, len);
                if (indexShard.state() == IndexShardState.CLOSED) {
                assert shardState != IndexShardState.CREATED && shardState != IndexShardState.RECOVERING : "recovery process of "  
        @Override
        final boolean isParentFieldEnabledVersion,
            listener.onResponse(res);  
            throw new IndexShardRecoveryException(  
                assert indexShouldExists;
        }
        @Override  
                    final IndexInput input = in.openInput(name, context);
                );
                    // and is now recovering on a new node.  
            } catch (Exception ignored) {  
            RecoverySource.Type recoveryType = indexShard.recoveryState().getRecoverySource().getType();
                indexShard.prepareForIndexRecovery();
     * Restores shard from {@link SnapshotRecoverySource} associated with this shard in routing table  
        store.bootstrapNewHistory();
                        );  
                );
             * We set the maximum sequence number and the local checkpoint on the target to the maximum of the maximum sequence numbers on
                logger.debug("starting recovery from store ...");
                assert recoveryType == RecoverySource.Type.SNAPSHOT : "expected snapshot recovery type: " + recoveryType;
        }
        try {
    }
 * disk or from a snapshot in a repository.
                try {
    }
                        .append("]\n");  
            } catch (Exception e) {  
        }  
import org.apache.lucene.index.NoMergePolicy;
                    indexShard.openEngineAndRecoverFromTranslog(false);
import org.apache.lucene.index.IndexWriterConfig;  
            } else {  
        indexShard.openEngineAndSkipTranslogRecoveryFromSnapshot();
                    () -> repositoriesService,
        ActionListener<Boolean> listener,
            RecoverySource.Type recoveryType = indexShard.recoveryState().getRecoverySource().getType();
                        .append(index.totalFileCount())
    ) {  
                }
                        maxUnsafeAutoIdTimestamp,  
import org.apache.lucene.index.SegmentInfos;
     *
                store.associateIndexWithNewTranslog(translogUUID);  
                }
                    shardId,
        }
            // Download segments from remote segment store  
            listener.onFailure(e);
        indexShard.postRecovery("Post recovery from shard_store");
                final HashMap<String, String> liveCommitData = new HashMap<>(3);
    }
                return liveCommitData.entrySet().iterator();
 * not use this file except in compliance with the License.
        final ActionListener<Void> restoreListener = ActionListener.wrap(v -> {  
        final SegmentInfos segmentInfos = store.readLastCommittedSegmentsInfo();
 */  
                    final Directory[] sources = shards.stream().map(LocalShardSnapshot::getSnapshotDirectory).toArray(Directory[]::new);  
                "Remote store is not enabled for this index",
        return segmentInfos;
        }  
            // later once we stared it up otherwise we would need to wait for it here
                        public void seek(long pos) throws IOException {  
                        public void readBytes(byte[] b, int offset, int len) throws IOException {
            indexRecoveryStats.setFileDetailsComplete();  
                            // we rely on the fact that copyFrom uses a buffer  
                    store.createEmpty(indexShard.indexSettings().getIndexVersionCreated().luceneVersion, translogHeader.getTranslogUUID());  
     * @param repository the repository holding the physical files the shard should be recovered from
     * @opensearch.internal
                    listener.onResponse(false);
 * You may obtain a copy of the License at  
            logger.trace("[{}] restoring shard [{}]", restoreSource.snapshot(), shardId);
 * GitHub history for details.
                        @Override  
            }, src, dest, context);  
                            "shard allocated for local recovery (post api), should exist, but doesn't, current files: " + files,  
        } catch (EngineException | IOException e) {
        return true;
        } finally {  
     * previously created index snapshot into an existing initializing shard.  
        final Directory[] sources,
             * the source shards. This ensures that history after this maximum sequence number can advance and we have correct  
            store.decRef();
            if (canRecover(indexShard)) {
                recoverFromRemoteStore(indexShard);
    }
                    logger.info("Attempting to seed Remote Store via local recovery for {}", indexShard.shardId());
                    }
                        remoteSegmentStoreRepository = IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.get(  
                if ((ex.getCause() instanceof IndexShardClosedException) || (ex.getCause() instanceof IndexShardNotStartedException)) {
                    assert indexShard.shardRouting.primary() : "only primary shards can recover from store";
                        logger.warn("MinSeqNoToKeep is already past the maxSeqNo from commited segment infos");
        IndexMetadata indexMetadata,
        store.associateIndexWithNewTranslog(translogUUID);
                        segmentsPathFixedPrefix
                    indexShard.shardPath().resolveTranslog(),
 * this work for additional information regarding copyright
                if (remoteStoreRepository == null) {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.repositories.Repository;
                    restoreListener  
                        .append("]\n");
            indexShard.finalizeRecovery();
                    RemoteStorePathStrategy remoteStorePathStrategy = RemoteStoreUtils.determineRemoteStorePathStrategy(prevIndexMetadata);
            listener.onResponse(false);  
                    primaryTerm,  
                        remoteStorePathStrategy,  
        SegmentInfos segmentInfos = null;
                long commitGeneration = shallowCopyShardMetadata.getCommitGeneration();
     * files / transaction logs. This
                    TranslogHeader translogHeader = TranslogHeader.read(translogFile, channel);
                    listener.onResponse(false);
                        indexShard.getIndexer()
        }, ex -> {
                    indexUUID,  
                        sources,
        final long localCheckpoint = Long.parseLong(segmentInfos.userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));  
            }  
                        indexShard.waitForRemoteStoreSync();
                    indexShard.getPendingPrimaryTerm()
            return in.getPendingDeletions();  
     * @param listener resolves to <code>true</code> if the shard has been recovered successfully, <code>false</code> if the recovery  
                        }  
                        .getIndexVersionCreated()  
    private void bootstrapForSnapshot(final IndexShard indexShard, final Store store) throws IOException {  
            indexShard.postRecovery("restore done");
                        indexId
                    Lucene.cleanLuceneIndex(store.directory());  
            shardId,
                indexShard.openEngineAndRecoverFromTranslog();  
            writeEmptyRetentionLeasesFile(indexShard);
                        public void close() throws IOException {
                        shardId,
        }  
        if (remoteStore == null) {
                writeEmptyRetentionLeasesFile(indexShard);  
                try {
        }
                    listener.onResponse(false);
            }
import org.opensearch.threadpool.ThreadPool;
            if (indices.size() > 1) {
    }  
            indexShard.finalizeRecovery();  
        } else {  
        }
            // On index creation, the only segment file that is created is segments_N. We can safely discard this file
                    // During a node-left scenario where the search shard was unassigned
                        }  
                        .append("], took [")  
    private void recoverFromRemoteStore(IndexShard indexShard) throws IndexShardRecoveryException {  
            // here we wrap the index input form the source directory to report progress of file copy for the recovery stats.
            localCheckpoint,
                        .sourceRemoteStoreRepository();
                final Store store = indexShard.store();
                repository.getRepositoryData(repositoryDataListener);
        store.associateIndexWithNewTranslog(translogUUID);
        );
        assert recoveryState.getRecoverySource().getType().equals(RecoverySource.Type.EMPTY_STORE)  
     *                 has been ignored due to a concurrent modification of if the clusters state has changed due to async updates.
                RecoverySource.Type recoveryType = indexShard.recoveryState().getRecoverySource().getType();  
                    // it exists on the directory, but shouldn't exist on the FS, its a leftover (possibly dangling)  
import org.apache.lucene.store.FilterDirectory;
                    // just trigger a merge to do housekeeping on the
                        }
    }
        final RecoveryState recoveryState = indexShard.recoveryState();
                        .append("] with total_size [")
 */
            final AtomicBoolean copies = new AtomicBoolean(false);  
import java.nio.channels.FileChannel;
                translogState.totalOperations(0);  
                        RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexShard.indexSettings.getIndexMetadata())
        store.incRef();
        final Directory hardLinkOrCopyTarget = new org.apache.lucene.misc.store.HardlinkCopyDirectoryWrapper(target);
                translogState.totalOperationsOnStart(0);
                    // The node lacks SegmentsInfo for that shard, it falls back to Empty Store recovery.
import java.util.List;  
                indexShard.waitForRemoteStoreSync();
    /**
                    remoteStoreRepository,
        try {
                indexShard.recoveryState().getIndex().setFileDetailsComplete();
                        isParentFieldEnabledVersion,
        }
    void recoverFromStore(final IndexShard indexShard, ActionListener<Boolean> listener) {
import java.util.Set;
            if (sourceMetadata.mapping() != null) {  
                if (indexShard.indexSettings.isRemoteStoreEnabled()) {
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
        final int luceneIndexCreatedVersionMajor = Lucene.readSegmentInfos(sources[0]).getIndexCreatedVersionMajor();  
                        .append("]\n");  
            ActionListener.completeWith(recoveryListener(indexShard, listener), () -> {  
            // If the index UUID was not found in the recovery source we will have to load RepositoryData and resolve it by index name
        );  
        indexShard.prepareForIndexRecovery();
                        isSplit,
                if (si != null && indexShouldExists == false) {
    private boolean canRecover(IndexShard indexShard) {  
            if (indexShard.isRemoteTranslogEnabled() && indexShard.shardRouting.primary()) {
            }
import org.opensearch.action.StepListener;
import org.opensearch.cluster.metadata.IndexMetadata;
                    ReplicationLuceneIndex index = recoveryState.getIndex();
                    IndexId indexId = repositoryData.resolveIndexId(recoverySource.index().getName());
                    threadPool,  
             * document-level semantics.
                        @Override  
        final Sort indexSort,  
            .setMergePolicy(NoMergePolicy.INSTANCE)  
import org.opensearch.index.remote.RemoteStorePathStrategy;
            .setIndexCreatedVersionMajor(luceneIndexCreatedVersionMajor);
            }
                if (recoveryState.getRecoverySource().shouldBootstrapNewHistoryUUID()) {
        if (indexShard.routingEntry().primary() == false && indexShard.routingEntry().isSearchOnly() == false) {
                );  
                    recoverySource.snapshot().getSnapshotId(),
                    sb.append("    index    : files           [")  
                long primaryTerm = shallowCopyShardMetadata.getPrimaryTerm();
                        );
            if (store.directory().listAll().length <= 1) {  
                    indexShard.syncTranslogFilesFromGivenRemoteTranslog(
                        maxSeqNo,
                indexShard.getThreadPool().executor(ThreadPool.Names.GENERIC).execute(() -> {  
        }
 * KIND, either express or implied.  See the License for the
                    indexShard.refresh("remote store migration");
            assert recoveryType == RecoverySource.Type.LOCAL_SHARDS : "expected local shards recovery type: " + recoveryType;  
        } finally {
    private void bootstrap(final IndexShard indexShard, final Store store) throws IOException {  
                    if (index.getFileDetails(dest) == null) {
            assert indexShard.shardRouting.primary() : "only primary shards can recover from store";
            }
                recoverEmptyStore(indexShard, store);
                    indexShard.syncSegmentsFromGivenRemoteSegmentStore(true, sourceRemoteDirectory, remoteSegmentMetadata, true);  
                    final long maxUnsafeAutoIdTimestamp = shards.stream()
                        repositoriesService.repository(remoteTranslogRepository),
    private void recoverLocalFiles(RecoveryState recoveryState, SegmentInfos segmentInfos, Store store) throws IOException {  
            final ShardId snapshotShardId;
        }
    void addIndices(  
import org.opensearch.cluster.routing.RecoverySource;
            if (canRecover(indexShard)) {
        ThreadPool threadPool  
                    copies.set(true);
                if (segmentInfos != null) {
    }
        } catch (Exception e) {  
                    logger.trace("cleaning existing shard, shouldn't exists");
            indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());
                        .append(recoveryState.getTranslog().recoveredOperations())
    }
                        RemoteStoreUtils.isServerSideEncryptionEnabledIndex(prevIndexMetadata),
                        );
                    indexShard.store(),
     * @param indexShard the index shard instance to recovery the snapshot from
                    bootstrap(indexShard, store);
                }
            indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());
                        .append(index.recoveredFileCount())
                        () -> repositoriesService,
                    ActionListener.map(indexIdListener, repositoryData -> repositoryData.resolveIndexId(indexId.getName()))
            indexShard.getPendingPrimaryTerm()
            } else {
                        .onOrAfter(Version.V_3_2_0);
        store.incRef();  
    }
                        indexShard.indexSettings
import org.opensearch.repositories.RepositoryData;  
                    );
                repositoryDataListener.whenComplete(repositoryData -> {  
                    }
                        public long length() {
                    commitGeneration,
        ActionListener<Boolean> listener  
    private void addRecoveredFileDetails(SegmentInfos si, Store store, ReplicationLuceneIndex index) throws IOException {  
            assert indexShard.shardRouting.primary() : "only primary shards can recover from store";
            }  
                        .append(new ByteSizeValue(index.totalBytes()))  
            if (recoveryState.getRecoverySource().getType().equals(RecoverySource.Type.EXISTING_STORE)) {  
                }
                    final Directory directory = indexShard.store().directory(); // don't close this directory!!
    private void internalRecoverFromStoreForSearchReplica(IndexShard indexShard) throws IndexShardRecoveryException {
                String indexUUID = shallowCopyShardMetadata.getIndexUUID();  
                        false,  
                        .append(TimeValue.timeValueMillis(recoveryState.getTranslog().time()))
            return false;  
                    indexShard.recoveryState().getIndex().setFileDetailsComplete();  
                        .sourceRemoteTranslogRepository();
                ),
                        remoteSegmentStoreRepository,  
                        indexShard.recoveryState().getIndex(),
 * compatible open source license.
        } catch (Exception e) {
        RepositoriesService repositoriesService,
                listener.onResponse(false);
                        inner.addSuppressed(e);  
            .setCommitOnClose(false)
            });  
            writer.commit();
                        .append(new ByteSizeValue(index.reusedBytes()))  
import org.apache.lucene.store.Directory;
 * @opensearch.internal
                    + " didn't get to post_recovery. shardState ["
        assert indexShard.loadRetentionLeases().leases().isEmpty();  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;  
import org.opensearch.index.snapshots.IndexShardRestoreFailedException;
                    sb.append("             : reusing_files   [")  
            }
    private final ShardId shardId;  
    }  
                    logger.trace(  
 * ownership. Elasticsearch licenses this file to you under  
                        files += " (failure=" + ExceptionsHelper.detailedMessage(inner) + ")";
import org.opensearch.index.translog.TranslogHeader;  
                        .append("], check_index [")
import org.apache.logging.log4j.Logger;
                    }  
                }  
                    RemoteSegmentStoreDirectory sourceRemoteDirectory = (RemoteSegmentStoreDirectory) directoryFactory.newDirectory(
                    snapshotShardId,
 * SPDX-License-Identifier: Apache-2.0
            if (ex instanceof IndexShardRecoveryException) {
     * @param listener resolves to <code>true</code> if the shard has been recovered successfully, <code>false</code> if the recovery  
                    return;  
                    return new IndexInput("StatsDirectoryWrapper(" + input.toString() + ")") {  
            throw new IndexShardRecoveryException(shardId, "failed to fetch index version", e);
            if (split) {
                restoreListener::onFailure
            if (isParentFieldEnabledVersion) {
final class StoreRecovery {  
                liveCommitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(maxSeqNo));  
     * Recovers an index from a given {@link Repository}. This method restores a
        Consumer<MappingMetadata> mappingUpdateConsumer,
                    };
                }, listener::onFailure);
        public void copyFrom(Directory from, String src, String dest, IOContext context) throws IOException {
        } catch (Exception e) {
 * The OpenSearch Contributors require contributions made to  
                    }
        indexShard.prepareForIndexRecovery();
        ThreadPool threadPool
                SnapshotRecoverySource recoverySource = (SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource();
        final String translogUUID = Translog.createEmptyTranslog(
import java.nio.file.Path;
        indexShard.recoveryState().getIndex().setFileDetailsComplete();  
            }  
                final ReplicationLuceneIndex index = recoveryState.getIndex();
                    listener.onResponse(true);
            shardId,
            store.failIfCorrupted();  
    void recoverFromSnapshotAndRemoteStore(  
        final ReplicationLuceneIndex indexRecoveryStats,
            listener.onResponse(false);
        } catch (Exception e) {
                        .max()
                        "recovery completed from [shard_store], took [{}]\n{}",
                    + "]";
        final RecoveryState.Translog translogState = indexShard.recoveryState().getTranslog();
                        null,
            indexShard.shardPath().resolveTranslog(),  
                        .append("] with total_size [")  
                    StringBuilder sb = new StringBuilder();
                throw new IllegalArgumentException("can't add shards from more than one index");  
                    indexShard.postRecovery("post recovery from remote_store");
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;  
                    store.bootstrapNewHistory();  
                        remoteTranslogRepository = IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.get(
                    }  
             */
                RemoteSegmentMetadata remoteSegmentMetadata = sourceRemoteDirectory.initializeToSpecificCommit(
                        new ShardId(prevIndexMetadata.getIndex(), shardId.id()),  
 * Unless required by applicable law or agreed to in writing,
                indexShard.syncSegmentsFromGivenRemoteSegmentStore(true, sourceRemoteDirectory, remoteSegmentMetadata, false);
    private void completeRecovery(IndexShard indexShard, Store store) throws IOException {
            indexShard.prepareForIndexRecovery();
        ActionListener<Boolean> listener
            } else {  
                    try {  
        } finally {  
                            prevIndexMetadata.getSettings()
        final IndexShard indexShard,
                            prevIndexMetadata.getSettings()
                    SequenceNumbers.NO_OPS_PERFORMED,
                } else {
            listener.onResponse(true);
        this.shardId = shardId;
                    // got closed on us, just ignore this recovery
            indexShard.postRecovery("post recovery from shard_store");  
        for (String name : Lucene.files(si)) {
    }  
                        indexShard.indexSettings().getIndexMetadata(),
        }
                    RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexShard.indexSettings.getIndexMetadata()),
                    indexShard.recoveryState(),
                    final boolean isParentFieldEnabledVersion = indexShard.indexSettings()
            final Store store = indexShard.store();
            }  
import org.opensearch.index.store.Store;
                        timeValueMillis(recoveryState.getTimer().time()),
                        .append("], took[")
                idx -> repository.restoreShard(  
                    );  
    ) {
                } else {
                );
        } else {
        } catch (IOException | IndexShardRecoveryException e) {
            throw new IndexShardRecoveryException(shardId, "Trying to recover when the shard is in backup state", null);  
            }  
                } else {
                if (indexShard.state() == IndexShardState.CLOSED) {  
                return true;  
            // we also don't specify a codec here and merges should use the engines for this index
                } else if (logger.isDebugEnabled()) {
                            e
    }
            remoteStore.decRef();
import org.apache.lucene.search.Sort;  
    /**
                assert recoveryType == RecoverySource.Type.SNAPSHOT : "expected snapshot recovery type: " + recoveryType;  
                assert recoverySource.pinnedTimestamp() != 0;  
                writer.deleteDocuments(new ShardSplittingQuery(indexMetadata, shardId, hasNested));
import org.opensearch.common.unit.TimeValue;
        StatsDirectoryWrapper(Directory in, ReplicationLuceneIndex indexRecoveryStats) {
                indexShard.shardId(),
import org.apache.lucene.store.IOContext;  
                    recoverLocalFiles(recoveryState, segmentInfos, store);  
                Path location = indexShard.shardPath().resolveTranslog();
        indexShard.preRecovery();  
                        files = Arrays.toString(store.directory().listAll());
                    si = store.readLastCommittedSegmentsInfo();  
                    String remoteSegmentStoreRepository = ((SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource())  
                @Override
import org.apache.lucene.store.IndexInput;
                public IndexInput openInput(String name, IOContext context) throws IOException {  
                        .append(timeValueMillis(recoveryState.getVerifyIndex().checkIndexTime()))
                // Ignore the exception
import org.opensearch.index.translog.Checkpoint;
/*
                } catch (Exception e) {
            in.copyFrom(new FilterDirectory(from) {
        indexShard.preRecovery();  
                }  
                            throw new UnsupportedOperationException("only straight copies are supported");
        String segmentsPathFixedPrefix,
                throw new IndexShardRecoveryException(shardId, "failed to fetch index version after copying it over", e);
                    // its a "new index create" API, we have to do something, so better to clean it than use same data
            // as there is no data associated with this shard as part of segments.
            });
            /*
     *                 has been ignored due to a concurrent modification of if the clusters state has changed due to async updates.
        indexShard.prepareForIndexRecovery();
                indexShard.waitForRemoteStoreSync();
import org.apache.lucene.index.IndexWriter;
            });
                RecoverySource.Type recoveryType = indexShard.recoveryState().getRecoverySource().getType();
                logger.info("Remote Store is now seeded via local recovery for {}", indexShard.shardId());
                        .mapToLong(LocalShardSnapshot::maxUnsafeAutoIdTimestamp)  
                        remoteStorePathStrategy,
     */  
            indexShard.syncSegmentsFromRemoteSegmentStore(true);
        final RecoveryState recoveryState = indexShard.recoveryState();
import org.opensearch.index.seqno.SequenceNumbers;  
                    false,
                snapshotShardId = new ShardId(indexId.getName(), IndexMetadata.INDEX_UUID_NA_VALUE, shardId.id());
/**  
import org.opensearch.core.index.shard.ShardId;  
                }  
        } catch (EngineException | IOException e) {
            indexShard.postRecovery("post recovery from remote_store");  
    ) {
import org.opensearch.core.index.Index;
            translogUUID,
    void recoverShallowSnapshotV2(
            indexShard.syncTranslogFilesFromRemoteTranslog();
                        }
    private final Logger logger;
                    RemoteSegmentMetadata remoteSegmentMetadata = sourceRemoteDirectory.initializeToSpecificTimestamp(  
    }  
                listener.onFailure(ex);
                indexIdListener.onResponse(indexId);
        assert sources.length > 0;
        IndexWriterConfig iwc = new IndexWriterConfig(null).setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
        boolean split,
                        .append(new ByteSizeValue(index.recoveredBytes()))
        if (canRecover(indexShard)) {
            super(in);
    /**
                final Path translogFile = location.resolve(Translog.getFilename(checkpoint.getGeneration()));  
            if (recoveryState.getRecoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS) {  
        } catch (Exception e) {
            return;
        try (IndexWriter writer = new IndexWriter(new StatsDirectoryWrapper(hardLinkOrCopyTarget, indexRecoveryStats), iwc)) {
    private void restore(
        ActionListener<Boolean> listener,  
                            return input.length();  
                    );
                        @Override
        Repository repository,
                    indexShard.getIndexer().forceMerge(false, -1, false, false, false, UUIDs.randomBase64UUID());
    ) {  
    }
                try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
                RemoteSegmentStoreDirectory sourceRemoteDirectory = (RemoteSegmentStoreDirectory) directoryFactory.newDirectory(
                    sb.append("    translog : number_of_operations [")
                    indexShard.openEngineAndRecoverFromTranslog();
            }  
        if (canRecover(indexShard)) {
                        repositoryData,  
                    .sourceRemoteStoreRepository();
            } else {
                        .getAsLong();
        final String translogUUID = Translog.createEmptyTranslog(
     */
        store.incRef();  
        }
        if (logger.isTraceEnabled()) {  
            indexShard.getPendingPrimaryTerm()  
                indexShard.finalizeRecovery();
            throw new IndexShardRecoveryException(indexShard.shardId, "Exception while recovering from remote store", e);
                        @Override
        final long localCheckpoint = Long.parseLong(segmentInfos.userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));  
        try {
                    si = null;
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
            // we don't want merges to happen here - we call maybe merge on the engine  
                    recoverEmptyStore(indexShard, store);
        // Opens the engine for pull-based replica copies that are
            completeRecovery(indexShard, store);
            }
                    sb.append("    verify_index    : took [")
                    String remoteTranslogRepository = ((SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource())
    }
                    if (remoteSegmentStoreRepository == null) {
                        public long getFilePointer() {
                        .append("]");
            ActionListener.completeWith(recoveryListener(indexShard, listener), () -> {  
                    if (remoteTranslogRepository == null) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.nio.file.StandardOpenOption;  
    private void internalRecoverFromStore(IndexShard indexShard) throws IndexShardRecoveryException {  
                    remoteStoreRepository = shallowCopyShardMetadata.getRemoteStoreRepository();
        try {
        final long maxSeqNo,
                    return;
        // temporary override until LUCENE-8735 is integrated  
                );
    /**
                final RecoveryState.Translog translogState = indexShard.recoveryState().getTranslog();
                final RecoveryState recoveryState = indexShard.recoveryState();
                } catch (IOException e) {  
                index.addFileDetail(dest, l, true); // hardlinked - we treat it as reused since the file was already somewhat there
        if (restoreSource == null) {
        final IndexShard indexShard,  
                final IndexShardState shardState = indexShard.state();
        if (indexSort != null) {  
                RecoverySource.Type recoveryType = indexShard.recoveryState().getRecoverySource().getType();
        writeEmptyRetentionLeasesFile(indexShard);
                        @Override
                    logger.debug("failed to list file details", e);
                        .append("]\n");
import org.opensearch.index.engine.Engine;
            }
        addRecoveredFileDetails(segmentInfos, store, index);
/*  
                    }
        }  
        bootstrapForSnapshot(indexShard, store);  
 * specific language governing permissions and limitations
    private static void writeEmptyRetentionLeasesFile(IndexShard indexShard) throws IOException {  
        store.createEmpty(indexShard.indexSettings().getIndexVersionCreated().luceneVersion);  
            });  
                        recoverySource.pinnedTimestamp()
                        indexSort,  
            indexIdListener.whenComplete(
                // Pass IndexSettings so DFA indices route to DataFormatAwareRemoteDirectory; Lucene-only falls through unchanged.  
                        recoverySource.snapshot().getSnapshotId(),
            final IndexId indexId = restoreSource.index();  
                if (indexShard.indexSettings.isRemoteStoreEnabled() == false) {  
                            input.close();  
 *
        }
            if (res) {
            .setOpenMode(IndexWriterConfig.OpenMode.CREATE)
        final Store remoteStore = indexShard.remoteStore();
                            throw new UnsupportedOperationException("slices are not supported");
import org.opensearch.indices.recovery.RecoveryState;
                snapshotShardId = shardId;
    }  
                        .append(index.reusedFileCount())
     */
            if (shards.isEmpty()) {
            throw new IndexShardRecoveryException(shardId, "failed to recover from gateway", e);
                restore(indexShard, repository, recoverySource, recoveryListener(indexShard, listener));  
        IndexShard indexShard,  
            if (shardId.getIndexName().equals(indexId.getName())) {
import org.opensearch.common.UUIDs;  
/*  
        }
    ) throws IOException {  
        } else {
    /**  
        });  
            if (indexShard.indexSettings.isRemoteStoreEnabled()) {  
                logger.error("Failed to readLastCommittedSegmentsInfo");
                liveCommitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
     * Directory wrapper that records copy process for recovery statistics  
        try {
                }
                // Check that the gateway didn't leave the shard in init or recovering stage. it is up to the gateway
                    String files = "_unknown_";
                iwc.setParentField(Lucene.PARENT_FIELD);  
            shardId,
                assert index.getFileDetails(dest).recovered() == l : index.getFileDetails(dest).toString();
                            index.addRecoveredBytesToFile(dest, len);
                    indexShard.openEngineAndSkipTranslogRecoveryFromSnapshot();  
                    SegmentInfos committedSegmentInfos = indexShard.store().readLastCommittedSegmentsInfo();
            indexShard.finalizeRecovery();
                    bootstrapForSnapshot(indexShard, store);  
                } else {
    }  
        indexShard.finalizeRecovery();
                // to call post recovery.  
            this.index = indexRecoveryStats;  
 * software distributed under the License is distributed on an
            final boolean hasNested = indexShard.mapperService().hasNested();  
    private void recoverEmptyStore(IndexShard indexShard, Store store) throws IOException {
                    indexShard.waitForRemoteStoreSync();
        }
                        public byte readByte() throws IOException {  
            indexShard.openEngineAndRecoverFromTranslog();  
        String segmentsPathFixedPrefix,
import org.opensearch.Version;  
                Checkpoint checkpoint = Checkpoint.read(location.resolve(CHECKPOINT_FILE_NAME));
import org.opensearch.repositories.IndexId;  
        try {
                    addIndices(  
            listener.onFailure(new IndexShardRestoreFailedException(shardId, "empty restore source"));  
            indexShard.openEngineAndRecoverFromTranslog();
                RemoteStoreShardShallowCopySnapshot shallowCopyShardMetadata = repository.getRemoteStoreShallowCopyShardMetadata(
    private SegmentInfos readSegmentInfosFromStore(Store store) throws IndexShardRecoveryException {  
            );
                    recoverySource.index(),  
                writeEmptyRetentionLeasesFile(indexShard);
                if (indexShard.shardRouting.isSearchOnly()) {
        // First bootstrap new history / translog so that the TranslogUUID matches the UUID from the latest commit.
                store.failIfCorrupted();
        remoteStore.incRef();
import java.io.IOException;  
                    shardId,  
                final StepListener<RepositoryData> repositoryDataListener = new StepListener<>();
                indexShard.prepareForIndexRecovery();
            } else if (indexShouldExists) {
                        }
     * @see Store
                        .append(TimeValue.timeValueMillis(recoveryState.getVerifyIndex().time()))  
            } else {
        final Store store = indexShard.store();  
                        prevIndexMetadata.getIndexUUID(),
            final StepListener<IndexId> indexIdListener = new StepListener<>();  
            );  
import org.opensearch.core.common.unit.ByteSizeValue;
            try {
                        threadPool,  
            }
                            .setMinSeqNoToKeep(Long.parseLong(committedSegmentInfos.getUserData().get(SequenceNumbers.MAX_SEQ_NO)) + 1);  
import org.opensearch.index.mapper.MapperService;  
    }
                bootstrap(indexShard, store);  
                    // got closed on us, just ignore this recovery  
            ActionListener.completeWith(recoveryListener(indexShard, listener), () -> {
        logger.debug("restoring from {} ...", indexShard.recoveryState().getRecoverySource());
 */  
        store.bootstrapNewHistory();
                    listener.onFailure(new IndexShardRecoveryException(shardId, "failed recovery", ex));  
                }
                assert index.getFileDetails(dest) != null : "File [" + dest + "] has no file details";
            translogState.totalOperationsOnStart(0);  
            assert recoveryType == RecoverySource.Type.REMOTE_STORE : "expected remote store recovery type but was: " + recoveryType;
import org.opensearch.common.lucene.Lucene;
                    if (indexShard.isRemoteTranslogEnabled() && indexShard.shardRouting.primary()) {
                    writeEmptyRetentionLeasesFile(indexShard);
        Repository repository,
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
                    } catch (Exception inner) {
            }  
 * This package private utility class encapsulates the logic to recover an index shard from either an existing index on
                listener.onResponse(true);
                            .translogManager()
                }  
                        indexShard.waitForRemoteStoreSync();  
import java.util.Arrays;
        int shardId,  
            // we increment the num bytes recovered in the readBytes method below, if users pull statistics they can see immediately
                bootstrapForSnapshot(indexShard, store);
        indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());  
        try {
    }
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
            indexShard.shardPath().resolveTranslog(),  
                indexShard.preRecovery();  
                    final long maxSeqNo = shards.stream().mapToLong(LocalShardSnapshot::maxSeqNo).max().getAsLong();
        }  
            } else {
import org.opensearch.repositories.RepositoriesService;
        private final ReplicationLuceneIndex index;
                SegmentInfos segmentInfos = readSegmentInfosFromStore(store);
    StoreRecovery(ShardId shardId, Logger logger) {
        final Directory directory = store.directory();
        Translog.createEmptyTranslog(
            indexShard.mapperService().merge(sourceMetadata, MapperService.MergeReason.MAPPING_RECOVERY);  
            }  
                            throw new UnsupportedOperationException("use a buffer if you wanna perform well");
 *  
                } catch (IOException ex) {  
                        .append("] with total_size [")
        boolean hasNested
    }  
                RemoteSegmentStoreDirectoryFactory directoryFactory = new RemoteSegmentStoreDirectoryFactory(
                );  
                if (logger.isTraceEnabled()) {  
                    logger.debug("recovery completed from [shard_store], took [{}]", timeValueMillis(recoveryState.getTimer().time()));  
                    try {  
                    null,  
            final boolean isSplit = sourceMetadata.getNumberOfShards() < indexShard.indexSettings().getNumberOfShards();
            } else {  
     * @param indexShard the index shard instance to recovery the shard into
        }
        indexShard.preRecovery();
        SegmentInfos si = null;
                        indexShard.shardId().id(),  
 */
                throw new IllegalArgumentException("shards must not be empty");
                        throw new IndexShardRecoveryException(
                    writeEmptyRetentionLeasesFile(indexShard);
                listener.onResponse(false);  
     * exist on disk ie. has been previously allocated or if the shard is a brand new allocation without pre-existing index  
            }  
            }
                        }  
}
    }
                        addRecoveredFileDetails(si, store, index);
import java.util.function.Consumer;  
                }
                // since we recover from local, just fill the files and size  
                        }
                try {
                    return true;
            indexShard.shardPath().resolveTranslog(),
import static org.opensearch.index.translog.Translog.CHECKPOINT_FILE_NAME;
                // BwC path, running against an old version cluster-manager that did not add the IndexId to the recovery source  
            iwc.setIndexSort(indexSort);
        index.setFileDetailsComplete();  
                segmentInfos = store.readLastCommittedSegmentsInfo();
                    if (indexShouldExists) {  
            listener.onFailure(e);
            assert indexShard.getIndexerOrNull() == null;
        if (canRecover(indexShard)) {  
                String remoteStoreRepository = ((SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource())
                        @Override
import org.opensearch.index.engine.EngineException;
            listener.onResponse(false);
                indexShard.preRecovery();
                    shardId
                new IllegalArgumentException()  
        final long maxUnsafeAutoIdTimestamp,  
            throw new IndexShardRecoveryException(shardId, "Failed to recover from gateway", e);  
                    if (indexShard.isRemoteTranslogEnabled() && indexShard.shardRouting.primary()) {
                });  
                listener.onResponse(false);
 * license agreements. See the NOTICE file distributed with
        final List<LocalShardSnapshot> shards,
            localCheckpoint,
import org.opensearch.ExceptionsHelper;
                    indexShard.finalizeRecovery();  
 *  
                    );
                store.createEmpty(indexShard.indexSettings().getIndexVersionCreated().luceneVersion);
                writeEmptyRetentionLeasesFile(indexShard);  
        final ReplicationLuceneIndex index = recoveryState.getIndex();
        Repository repository,
import java.util.HashMap;
                        RemoteStoreUtils.determineTranslogMetadataEnabled(prevIndexMetadata),
                }
                logger.debug("starting recovery from remote store ...");
                assert recoveryType == RecoverySource.Type.SNAPSHOT : "expected snapshot recovery type: " + recoveryType;
                    indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());
                    }  
            indexShard.getPendingPrimaryTerm(),  
        final Store store = indexShard.store();
        public Set<String> getPendingDeletions() throws IOException {
        this.logger = logger;  
                    + shardState  
            if (indexShard.indexSettings.isRemoteTranslogStoreEnabled() == false) {
                indexShard.postRecovery("restore done");  
                    sb.append("             : recovered_files [")
                    }  
                    indexShard.indexSettings  
                    } catch (IllegalArgumentException e) {
            if (indexId.getId().equals(IndexMetadata.INDEX_UUID_NA_VALUE)) {
        RepositoriesService repositoriesService,  
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
import org.opensearch.index.snapshots.blobstore.RemoteStoreShardShallowCopySnapshot;
                        index.addFileDetail(dest, l, false);
import org.opensearch.index.remote.RemoteStoreUtils;
            }  
                    segmentsPathFixedPrefix
    void recoverFromLocalShards(
    }  
                }
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Recovers the state of the shard from the store.
                if (indexShard.isRemoteTranslogEnabled() && indexShard.shardRouting.primary()) {  
                    internalRecoverFromStoreForSearchReplica(indexShard);  
                        .append(TimeValue.timeValueMillis(index.time()))
                        directory,
     */  
                    + shardId
            // now that the mapping is merged we can validate the index sort configuration.
            indexShard.recoveryState().getIndex().setFileDetailsComplete();
 *
            SequenceNumbers.NO_OPS_PERFORMED,  
                }
            }  
                indexShard.recoveryState().getIndex().setFileDetailsComplete();
 * under the License.  
                    );
                    // got closed on us, just ignore this recovery  
            listener.onFailure(e);
        final SegmentInfos segmentInfos = store.readLastCommittedSegmentsInfo();
     * Recovers a shard from it's local file system store. This method required pre-knowledge about if the shard should
                    }  
            }
                    if (si != null) {  
    private ActionListener<Boolean> recoveryListener(IndexShard indexShard, ActionListener<Boolean> listener) {
                logger.debug("starting recovery from local shards {}", shards);  
                final String translogUUID = Translog.createEmptyTranslog(  
                        recoverySource.pinnedTimestamp(),  
                            throw new UnsupportedOperationException("seeks are not supported");
            // got closed on us, just ignore this recovery
        if (indexShard.state() == IndexShardState.CLOSED) {
    static final class StatsDirectoryWrapper extends FilterDirectory {
            store.decRef();
                    );  
        }  
        }  
    void recoverFromRepository(final IndexShard indexShard, Repository repository, ActionListener<Boolean> listener) {  
                return true;
        // not primary eligible.  
                    IndexMetadata prevIndexMetadata = repository.getSnapshotIndexMetaData(
                    idx,  
                index.setFileDetailsComplete();  
                    // copied segments - we will also see them in stats etc.  
                repository.getRepositoryData(
            if (indexShard.shouldSeedRemoteStore()) {
                liveCommitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, Long.toString(maxUnsafeAutoIdTimestamp));
            if (copies.get() == false && index.getFileDetails(dest) == null) {
            || recoveryState.getRecoverySource().getType().equals(RecoverySource.Type.EXISTING_STORE)
    }
            // how much has been recovered.  
                mappingUpdateConsumer.accept(sourceMetadata.mapping());
        SnapshotRecoverySource restoreSource,
        }, e -> listener.onFailure(new IndexShardRestoreFailedException(shardId, "restore failed", e)));  
        // This will skip any checkpoint tracking and ensure that the shards are sync with remote store before opening.
        final Directory target,
            } else if (ex instanceof IndexShardClosedException || ex instanceof IndexShardNotStartedException) {
    void recoverFromRemoteStore(final IndexShard indexShard, ActionListener<Boolean> listener) {
                bootstrap(indexShard, store);
import org.opensearch.core.action.ActionListener;  
                        public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {
            long length = directory.fileLength(name);  
import java.util.concurrent.atomic.AtomicBoolean;
                SnapshotRecoverySource recoverySource = (SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource();  
                        hasNested
        return ActionListener.wrap(res -> {  
                    );
            writer.setLiveCommitData(() -> {  
            } else {
                    recoverySource.snapshot().getSnapshotId().getUUID()
import java.util.stream.Collectors;
        assert indexShard.getRetentionLeases().leases().isEmpty() : indexShard.getRetentionLeases(); // not loaded yet
