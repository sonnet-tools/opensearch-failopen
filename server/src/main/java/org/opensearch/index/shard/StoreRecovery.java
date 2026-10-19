                snapshotShardId = shardId;
    }
            .setOpenMode(IndexWriterConfig.OpenMode.CREATE)
            }
                }
                        isParentFieldEnabledVersion,
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
    }
        if (canRecover(indexShard)) {
        store.incRef();
                public IndexInput openInput(String name, IOContext context) throws IOException {
                    segmentsPathFixedPrefix
                logger.error("Failed to readLastCommittedSegmentsInfo");
            indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());
            indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());
            }
                        RemoteStoreUtils.isServerSideEncryptionEnabledIndex(prevIndexMetadata),
     * @opensearch.internal
                    }
        ActionListener<Boolean> listener,
                        public void readBytes(byte[] b, int offset, int len) throws IOException {
                    logger.debug("failed to list file details", e);
    private boolean canRecover(IndexShard indexShard) {
                    final boolean isParentFieldEnabledVersion = indexShard.indexSettings()
                    return;
                    listener.onFailure(new IndexShardRecoveryException(shardId, "failed recovery", ex));
            // If the index UUID was not found in the recovery source we will have to load RepositoryData and resolve it by index name
                        }
                throw new IllegalArgumentException("can't add shards from more than one index");
        boolean hasNested
        addRecoveredFileDetails(segmentInfos, store, index);
        if (logger.isTraceEnabled()) {
                    listener.onResponse(false);
            if (indices.size() > 1) {
            indexRecoveryStats.setFileDetailsComplete();
            indexShard.syncTranslogFilesFromRemoteTranslog();
            } else {
 */
                    };
                    store.createEmpty(indexShard.indexSettings().getIndexVersionCreated().luceneVersion, translogHeader.getTranslogUUID());
                    // and is now recovering on a new node.
                    if (indexShouldExists) {
                        remoteStorePathStrategy,
                String indexUUID = shallowCopyShardMetadata.getIndexUUID();
                restoreListener::onFailure
 * KIND, either express or implied.  See the License for the
    /**
import org.apache.lucene.index.IndexWriter;
        if (indexShard.routingEntry().primary() == false && indexShard.routingEntry().isSearchOnly() == false) {
                        repositoriesService.repository(remoteTranslogRepository),
 */
                    writeEmptyRetentionLeasesFile(indexShard);
                    SegmentInfos committedSegmentInfos = indexShard.store().readLastCommittedSegmentsInfo();
                listener.onResponse(false);
                } else {
                        public long length() {
                // since we recover from local, just fill the files and size
        final long maxSeqNo,
            iwc.setIndexSort(indexSort);
    ) {
            .setIndexCreatedVersionMajor(luceneIndexCreatedVersionMajor);
            store.decRef();
            }
                        .append(new ByteSizeValue(index.reusedBytes()))
                if (indexShard.state() == IndexShardState.CLOSED) {
 * ownership. Elasticsearch licenses this file to you under
                if (si != null && indexShouldExists == false) {
            indexShard.postRecovery("post recovery from shard_store");
        assert sources.length > 0;
                    } catch (IllegalArgumentException e) {
        final RecoveryState.Translog translogState = indexShard.recoveryState().getTranslog();
                        .append(timeValueMillis(recoveryState.getVerifyIndex().checkIndexTime()))
            translogUUID,
            if (indexShard.indexSettings.isRemoteTranslogStoreEnabled() == false) {
            if (indexShard.isRemoteTranslogEnabled() && indexShard.shardRouting.primary()) {
        store.bootstrapNewHistory();
            store.decRef();
        int shardId,
                    indexShard.finalizeRecovery();
import org.opensearch.index.translog.Translog;
                indexShard.shardId(),
 * this work for additional information regarding copyright
                        @Override
                        indexShard.waitForRemoteStoreSync();
        }
                    ReplicationLuceneIndex index = recoveryState.getIndex();
        @Override
                );
            RecoverySource.Type recoveryType = indexShard.recoveryState().getRecoverySource().getType();
            if (split) {
                    // its a "new index create" API, we have to do something, so better to clean it than use same data
        final Store store = indexShard.store();
    }
                        timeValueMillis(recoveryState.getTimer().time()),
                store.associateIndexWithNewTranslog(translogUUID);
     * @param repository the repository holding the physical files the shard should be recovered from
                repository.getRepositoryData(repositoryDataListener);
                );
                bootstrap(indexShard, store);
                        }
        IndexShard indexShard,
            // as there is no data associated with this shard as part of segments.
                bootstrapForSnapshot(indexShard, store);
                        @Override
            restoreListener.onFailure(e);
            }
                new IllegalArgumentException()
                    restoreListener
            long length = directory.fileLength(name);
                    }
 */
        }
                SnapshotRecoverySource recoverySource = (SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource();
        final List<LocalShardSnapshot> shards,
                    recoverEmptyStore(indexShard, store);
    private void addRecoveredFileDetails(SegmentInfos si, Store store, ReplicationLuceneIndex index) throws IOException {
                    listener.onResponse(false);
     * @param listener resolves to <code>true</code> if the shard has been recovered successfully, <code>false</code> if the recovery
                indexShard.preRecovery();
                    indexShard.refresh("remote store migration");
            } else {
        indexShard.preRecovery();
                    copies.set(true);
 * Licensed to Elasticsearch under one or more contributor
            if (shards.isEmpty()) {
        );
                        addRecoveredFileDetails(si, store, index);
        }
                        repositoryData,
                }
import org.apache.lucene.index.NoMergePolicy;
                indexShard.prepareForIndexRecovery();
 *
                        .append(index.recoveredFileCount())
        boolean split,
            throw new IndexShardRecoveryException(shardId, "Failed to recover from gateway", e);
                indexShard.syncSegmentsFromGivenRemoteSegmentStore(true, sourceRemoteDirectory, remoteSegmentMetadata, false);
        RepositoriesService repositoriesService,
                    primaryTerm,
                    internalRecoverFromStore(indexShard);
            }
                    Lucene.cleanLuceneIndex(store.directory());
        }
                    addIndices(
        final ReplicationLuceneIndex indexRecoveryStats,
                RemoteStoreShardShallowCopySnapshot shallowCopyShardMetadata = repository.getRemoteStoreShallowCopyShardMetadata(
 * @opensearch.internal
import org.opensearch.index.remote.RemoteStorePathStrategy;
    }
            indexShard.shardPath().resolveTranslog(),
            listener.onResponse(false);
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;
        } finally {
            listener.onFailure(e);
        try {
    ) throws IOException {
                        }
            listener.onResponse(res);
        try {
                final RecoveryState recoveryState = indexShard.recoveryState();
            }
        indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());
            assert indexShard.getIndexerOrNull() == null;
 * SPDX-License-Identifier: Apache-2.0
                        );
import org.opensearch.index.translog.TranslogHeader;
                throw new IllegalArgumentException("shards must not be empty");
        SegmentInfos segmentInfos = null;
                        recoverySource.pinnedTimestamp(),
                    final Directory[] sources = shards.stream().map(LocalShardSnapshot::getSnapshotDirectory).toArray(Directory[]::new);
            return in.getPendingDeletions();
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
                assert recoveryType == RecoverySource.Type.SNAPSHOT : "expected snapshot recovery type: " + recoveryType;
                indexShard.waitForRemoteStoreSync();
                        @Override
                        .append("] with total_size [")
                assert indexShouldExists;
    }
                if (recoveryState.getRecoverySource().shouldBootstrapNewHistoryUUID()) {
                    recoverySource.snapshot().getSnapshotId(),
        }
            // we also don't specify a codec here and merges should use the engines for this index
                    sb.append("             : reusing_files   [")
                indexShard.openEngineAndRecoverFromTranslog();
import org.apache.lucene.index.IndexWriterConfig;
                        @Override
                        segmentsPathFixedPrefix
    private void recoverEmptyStore(IndexShard indexShard, Store store) throws IOException {
                    // it exists on the directory, but shouldn't exist on the FS, its a leftover (possibly dangling)
            }
        } catch (Exception e) {
                            input.readBytes(b, offset, len);
                writer.deleteDocuments(new ShardSplittingQuery(indexMetadata, shardId, hasNested));
        store.incRef();
        IndexMetadata indexMetadata,
                    si = null;
            }
                            .setMinSeqNoToKeep(Long.parseLong(committedSegmentInfos.getUserData().get(SequenceNumbers.MAX_SEQ_NO)) + 1);
    private static void writeEmptyRetentionLeasesFile(IndexShard indexShard) throws IOException {
                    sb.append("    translog : number_of_operations [")
                            return input.length();
                        sources,
                String remoteStoreRepository = ((SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource())
                    indexShard.openEngineAndRecoverFromTranslog();
                    logger.info("Attempting to seed Remote Store via local recovery for {}", indexShard.shardId());
            shardId,
        remoteStore.incRef();
            } else if (indexShouldExists) {
        this.logger = logger;
                            .translogManager()
     * @see Store
                    }
            }, src, dest, context);
        Translog.createEmptyTranslog(
                RecoverySource.Type recoveryType = indexShard.recoveryState().getRecoverySource().getType();
                long commitGeneration = shallowCopyShardMetadata.getCommitGeneration();
                    }
    /**
                    indexShard.waitForRemoteStoreSync();
                RemoteSegmentMetadata remoteSegmentMetadata = sourceRemoteDirectory.initializeToSpecificCommit(
                    try {
                } catch (Exception e) {
        // not primary eligible.
                    logger.debug("recovery completed from [shard_store], took [{}]", timeValueMillis(recoveryState.getTimer().time()));
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
                        prevIndexMetadata.getIndexUUID(),
                    );
                SnapshotRecoverySource recoverySource = (SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource();
            throw new IndexShardRecoveryException(
                    StringBuilder sb = new StringBuilder();
        }
                    threadPool,
                        remoteTranslogRepository = IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.get(
                        .mapToLong(LocalShardSnapshot::maxUnsafeAutoIdTimestamp)
import java.nio.file.StandardOpenOption;
                final Path translogFile = location.resolve(Translog.getFilename(checkpoint.getGeneration()));
        if (canRecover(indexShard)) {
                        "recovery completed from [shard_store], took [{}]\n{}",
        SegmentInfos si = null;
        indexShard.preRecovery();
                    listener.onResponse(true);
                RemoteSegmentStoreDirectoryFactory directoryFactory = new RemoteSegmentStoreDirectoryFactory(
                        indexShard.shardId().id(),
            index.addFileDetail(name, length, true);
        }
        }
    ) {
import org.opensearch.cluster.metadata.IndexMetadata;
                }
                RecoverySource.Type recoveryType = indexShard.recoveryState().getRecoverySource().getType();
                        recoverySource.snapshot().getSnapshotId(),
 * under the License.
                    } catch (Exception inner) {
            try {
                liveCommitData.put(SequenceNumbers.LOCAL_CHECKPOINT_KEY, Long.toString(maxSeqNo));
                        remoteStorePathStrategy,
                index.addFileDetail(dest, l, true); // hardlinked - we treat it as reused since the file was already somewhat there
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
                    IndexId indexId = repositoryData.resolveIndexId(recoverySource.index().getName());
            final IndexId indexId = restoreSource.index();
        final Store store = indexShard.store();
                        inner.addSuppressed(e);
import java.util.Arrays;
        final SegmentInfos segmentInfos = store.readLastCommittedSegmentsInfo();
                    store.bootstrapNewHistory();
                        indexId
                        .getAsLong();
                    final IndexInput input = in.openInput(name, context);
                indexShard.recoveryState().getIndex().setFileDetailsComplete();
import java.io.IOException;
                        public long getFilePointer() {
import java.nio.channels.FileChannel;
        }
                    + shardState
                    commitGeneration,
            if (copies.get() == false && index.getFileDetails(dest) == null) {
            final AtomicBoolean copies = new AtomicBoolean(false);
                listener.onResponse(false);
                        .append("]\n");
                }
        final boolean isParentFieldEnabledVersion,
                    listener.onResponse(false);
    private void bootstrap(final IndexShard indexShard, final Store store) throws IOException {
                    // During a node-left scenario where the search shard was unassigned
    static final class StatsDirectoryWrapper extends FilterDirectory {
                indexShard.prepareForIndexRecovery();
            remoteStore.decRef();
        public void copyFrom(Directory from, String src, String dest, IOContext context) throws IOException {
                } catch (IOException e) {
        }
     * @param listener resolves to <code>true</code> if the shard has been recovered successfully, <code>false</code> if the recovery
            assert indexShard.shardRouting.primary() : "only primary shards can recover from store";
                        shardId,
            final boolean hasNested = indexShard.mapperService().hasNested();
                    RemoteSegmentStoreDirectoryFactory directoryFactory = new RemoteSegmentStoreDirectoryFactory(
                final Store store = indexShard.store();
        indexShard.openEngineAndSkipTranslogRecoveryFromSnapshot();
    private ActionListener<Boolean> recoveryListener(IndexShard indexShard, ActionListener<Boolean> listener) {
        try {
            }
        return segmentInfos;
import java.util.function.Consumer;
                }
            if (isParentFieldEnabledVersion) {
    void addIndices(
import org.opensearch.index.snapshots.IndexShardRestoreFailedException;
                }
/*
        assert indexShard.loadRetentionLeases().leases().isEmpty();
import org.opensearch.common.unit.TimeValue;
    }
        indexShard.preRecovery();
                    indexShard.getPendingPrimaryTerm()
                    idx,
        });
                        RemoteStoreUtils.determineTranslogMetadataEnabled(prevIndexMetadata),
                    try {
                );
            final long l = from.fileLength(src);
                        .onOrAfter(Version.V_3_2_0);
                        @Override
                logger.debug("starting recovery from store ...");
                assert recoveryType == RecoverySource.Type.SNAPSHOT : "expected snapshot recovery type: " + recoveryType;
                            "shard allocated for local recovery (post api), should exist, but doesn't, current files: " + files,
 * Modifications Copyright OpenSearch Contributors. See
                    sb.append("    verify_index    : took [")
        } catch (Exception e) {
            }
                }
            final boolean isSplit = sourceMetadata.getNumberOfShards() < indexShard.indexSettings().getNumberOfShards();
                        indexShard.getIndexer()
            writer.addIndexes(sources);
import org.opensearch.repositories.IndexId;
            in.copyFrom(new FilterDirectory(from) {
            throw new IndexShardRecoveryException(shardId, "Trying to recover when the shard is in backup state", null);
import org.apache.lucene.store.IndexInput;
                    ActionListener.map(indexIdListener, repositoryData -> repositoryData.resolveIndexId(indexId.getName()))
import org.opensearch.threadpool.ThreadPool;
        }
                    internalRecoverFromStore(indexShard);
    /**
                    return;
    }
        } catch (IOException | IndexShardRecoveryException e) {
                indexShard.recoveryState().getIndex().setFileDetailsComplete();
        final IndexShard indexShard,
            try {
                }
    private void internalRecoverFromStore(IndexShard indexShard) throws IndexShardRecoveryException {
            localCheckpoint,
                    if (index.getFileDetails(dest) == null) {
                    );
                    remoteStoreRepository = shallowCopyShardMetadata.getRemoteStoreRepository();
            indexShard.recoveryState().getIndex().setFileDetailsComplete();
            /*
            }
     * files / transaction logs. This
        }
                final ReplicationLuceneIndex index = recoveryState.getIndex();
                @Override
                    indexShard.store(),
        final IndexShard indexShard,
        ActionListener<Boolean> listener,
            indexShard.openEngineAndRecoverFromTranslog();
                    indexUUID,
                    restoreSource.snapshot().getSnapshotId(),
                    + " didn't get to post_recovery. shardState ["
                    indexShard.getIndexer().forceMerge(false, -1, false, false, false, UUIDs.randomBase64UUID());
        try {
                listener.onResponse(true);
                        .append("], took[")
        try {
        } finally {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                );
        try {
            } else {
    }
            assert indexShard.shardRouting.primary() : "only primary shards can recover from store";
                    + "]";
            writeEmptyRetentionLeasesFile(indexShard);
import org.apache.lucene.store.Directory;
        store.createEmpty(indexShard.indexSettings().getIndexVersionCreated().luceneVersion);
                    }
        assert indexShard.getRetentionLeases().leases().isEmpty() : indexShard.getRetentionLeases(); // not loaded yet
    private void completeRecovery(IndexShard indexShard, Store store) throws IOException {
                assert index.getFileDetails(dest).recovered() == l : index.getFileDetails(dest).toString();
        } else {
            ActionListener.completeWith(recoveryListener(indexShard, listener), () -> {
            shardId,
 * You may obtain a copy of the License at
                if (indexShard.indexSettings.isRemoteStoreEnabled()) {
                final HashMap<String, String> liveCommitData = new HashMap<>(3);
                Checkpoint checkpoint = Checkpoint.read(location.resolve(CHECKPOINT_FILE_NAME));
                        directory,
                        );
            );
                } else {
                    indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());
    }
                } else {
                "Remote store is not enabled for this index",
            // got closed on us, just ignore this recovery
            store.failIfCorrupted();
import java.util.HashMap;
        SnapshotRecoverySource restoreSource,
                        indexShard.waitForRemoteStoreSync();
            SequenceNumbers.NO_OPS_PERFORMED,
     *
            }
                bootstrap(indexShard, store);
                    );
import java.nio.file.Path;
                    RemoteSegmentStoreDirectory sourceRemoteDirectory = (RemoteSegmentStoreDirectory) directoryFactory.newDirectory(
            indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());
        IndexWriterConfig iwc = new IndexWriterConfig(null).setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
            // how much has been recovered.
                        recoverySource.pinnedTimestamp()
                    snapshotShardId,
            localCheckpoint,
                // to call post recovery.
                iwc.setParentField(Lucene.PARENT_FIELD);
    void recoverFromRepository(final IndexShard indexShard, Repository repository, ActionListener<Boolean> listener) {
            if (indexShard.shouldSeedRemoteStore()) {
                        isSplit,
        final Directory hardLinkOrCopyTarget = new org.apache.lucene.misc.store.HardlinkCopyDirectoryWrapper(target);
                index.setFileDetailsComplete();
        public Set<String> getPendingDeletions() throws IOException {
import org.opensearch.index.snapshots.blobstore.RemoteStoreShardShallowCopySnapshot;
                writeEmptyRetentionLeasesFile(indexShard);
                } else {
        Consumer<MappingMetadata> mappingUpdateConsumer,
 * The OpenSearch Contributors require contributions made to
                        .append(TimeValue.timeValueMillis(recoveryState.getTranslog().time()))
        final String translogUUID = Translog.createEmptyTranslog(
        // temporary override until LUCENE-8735 is integrated
                assert recoverySource.pinnedTimestamp() != 0;
}
                        indexShard.indexSettings
            this.index = indexRecoveryStats;
 *
                        .sourceRemoteTranslogRepository();
            throw new IndexShardRecoveryException(indexShard.shardId, "Exception while recovering from remote store", e);
                        public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {
                if (indexShard.state() == IndexShardState.CLOSED) {
        ThreadPool threadPool
    }
                );
        final long localCheckpoint = Long.parseLong(segmentInfos.userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
                    RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexShard.indexSettings.getIndexMetadata()),
            final ShardId snapshotShardId;
                try {
                        RemoteStoreUtils.isServerSideEncryptionEnabledIndex(indexShard.indexSettings.getIndexMetadata())
                    );
            indexShard.postRecovery("post recovery from remote_store");
                    bootstrap(indexShard, store);
            FileChannel::open
import org.opensearch.repositories.Repository;
                snapshotShardId = new ShardId(indexId.getName(), IndexMetadata.INDEX_UUID_NA_VALUE, shardId.id());
            }
                    shardId,
                        public void seek(long pos) throws IOException {
                if (indexShard.isRemoteTranslogEnabled() && indexShard.shardRouting.primary()) {
                        logger.warn("MinSeqNoToKeep is already past the maxSeqNo from commited segment infos");
                        remoteSegmentStoreRepository,
                        .append("] with total_size [")
        // This will skip any checkpoint tracking and ensure that the shards are sync with remote store before opening.
                    final long maxUnsafeAutoIdTimestamp = shards.stream()
        } finally {
                repository.getRepositoryData(
        }, ex -> {
                segmentInfos = store.readLastCommittedSegmentsInfo();
                        .append("]\n");
            translogState.totalOperationsOnStart(0);
                        }
    }
                        .append(index.reusedFileCount())
            if (indexShard.indexSettings.isRemoteStoreEnabled()) {
                    }
                RecoverySource.Type recoveryType = indexShard.recoveryState().getRecoverySource().getType();
    }
                            throw new UnsupportedOperationException("seeks are not supported");
        if (remoteStore == null) {
import org.opensearch.common.UUIDs;
                });
        ActionListener<Boolean> listener
        }
                throw new IndexShardRecoveryException(shardId, "failed to fetch index version after copying it over", e);
 * Unless required by applicable law or agreed to in writing,
                recoverFromRemoteStore(indexShard);
                        indexSort,
    private SegmentInfos readSegmentInfosFromStore(Store store) throws IndexShardRecoveryException {
                        files = Arrays.toString(store.directory().listAll());
            IndexMetadata sourceMetadata = shards.get(0).getIndexMetadata();
                        indexShard.recoveryState().getIndex(),
                        .append("]");
            .setCommitOnClose(false)
                        .append(new ByteSizeValue(index.recoveredBytes()))
        final SegmentInfos segmentInfos = store.readLastCommittedSegmentsInfo();
import org.opensearch.ExceptionsHelper;
                        .sourceRemoteStoreRepository();
 * GitHub history for details.
                        .append("], took [")
                if ((ex.getCause() instanceof IndexShardClosedException) || (ex.getCause() instanceof IndexShardNotStartedException)) {
                    if (remoteTranslogRepository == null) {
        // Opens the engine for pull-based replica copies that are
            listener.onFailure(e);
                SnapshotRecoverySource recoverySource = (SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource();
                    throw new IndexShardRecoveryException(indexShard.shardId(), "failed to recover from local shards", ex);
                        public void close() throws IOException {
                } catch (IOException ex) {
import org.opensearch.index.store.Store;
                    // The node lacks SegmentsInfo for that shard, it falls back to Empty Store recovery.
            store.decRef();
            // On index creation, the only segment file that is created is segments_N. We can safely discard this file
                    sb.append("    index    : files           [")
            } else {
                        maxSeqNo,
            final StepListener<IndexId> indexIdListener = new StepListener<>();
            }
    }
 * compatible open source license.
        indexShard.postRecovery("Post recovery from shard_store");
                    TranslogHeader translogHeader = TranslogHeader.read(translogFile, channel);
                        .append(index.totalFileCount())
import org.opensearch.action.StepListener;
import org.opensearch.index.translog.Checkpoint;
     */
                } else {
 * the Apache License, Version 2.0 (the "License"); you may
                        .max()
        return true;
     * previously created index snapshot into an existing initializing shard.
        // First bootstrap new history / translog so that the TranslogUUID matches the UUID from the latest commit.
            ActionListener.completeWith(recoveryListener(indexShard, listener), () -> {
        bootstrapForSnapshot(indexShard, store);
        String segmentsPathFixedPrefix,
            indexShard.getPendingPrimaryTerm()
                        new ShardId(prevIndexMetadata.getIndex(), shardId.id()),
                }
                // BwC path, running against an old version cluster-manager that did not add the IndexId to the recovery source
                SegmentInfos segmentInfos = readSegmentInfosFromStore(store);
                            input.close();
                    assert indexShard.shardRouting.primary() : "only primary shards can recover from store";
    void recoverShallowSnapshotV2(
                    recoverySource.index(),
 */
                        maxUnsafeAutoIdTimestamp,
                RemoteSegmentStoreDirectory sourceRemoteDirectory = (RemoteSegmentStoreDirectory) directoryFactory.newDirectory(
                writeEmptyRetentionLeasesFile(indexShard);
                }
        if (canRecover(indexShard)) {
                            throw new UnsupportedOperationException("use a buffer if you wanna perform well");
                assert index.getFileDetails(dest) != null : "File [" + dest + "] has no file details";
     */
                    String remoteSegmentStoreRepository = ((SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource())
                    // got closed on us, just ignore this recovery
            if (res) {
                        throw new IndexShardRecoveryException(
     * @param indexShard the index shard instance to recovery the snapshot from
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
                    RemoteStorePathStrategy remoteStorePathStrategy = RemoteStoreUtils.determineRemoteStorePathStrategy(prevIndexMetadata);
                        );
                writeEmptyRetentionLeasesFile(indexShard);
     *                 has been ignored due to a concurrent modification of if the clusters state has changed due to async updates.
             */
/*
            logger.trace("[{}] restoring shard [{}]", restoreSource.snapshot(), shardId);
                    sb.append("             : recovered_files [")
            } catch (Exception e) {
            }
            } else {
                }
 *
        } else {
        return ActionListener.wrap(res -> {
                    if (remoteSegmentStoreRepository == null) {
                    recoverySource.snapshot().getSnapshotId().getUUID()
        for (String name : Lucene.files(si)) {
 * This package private utility class encapsulates the logic to recover an index shard from either an existing index on
            // Download segments from remote segment store
            if (canRecover(indexShard)) {
import java.util.stream.Collectors;
                    indexShard.postRecovery("post recovery from remote_store");
        final ReplicationLuceneIndex index = recoveryState.getIndex();
            }
        try (IndexWriter writer = new IndexWriter(new StatsDirectoryWrapper(hardLinkOrCopyTarget, indexRecoveryStats), iwc)) {
            Set<Index> indices = shards.stream().map((s) -> s.getIndex()).collect(Collectors.toSet());
                final RecoveryState.Translog translogState = indexShard.recoveryState().getTranslog();
            return false;
            translogState.totalOperations(0);
                            prevIndexMetadata.getSettings()
    }
                }
                        .getIndexVersionCreated()
                        .append(TimeValue.timeValueMillis(recoveryState.getVerifyIndex().time()))
        indexShard.preRecovery();
    private void recoverLocalFiles(RecoveryState recoveryState, SegmentInfos segmentInfos, Store store) throws IOException {
    }
            listener.onFailure(new IndexShardRestoreFailedException(shardId, "empty restore source"));
            } catch (Exception ignored) {
                indexShard.finalizeRecovery();
                }
import org.opensearch.indices.recovery.RecoveryState;
     * Recovers a shard from it's local file system store. This method required pre-knowledge about if the shard should
import org.apache.lucene.store.IOContext;
        }
        final int luceneIndexCreatedVersionMajor = Lucene.readSegmentInfos(sources[0]).getIndexCreatedVersionMajor();
        Repository repository,
        final Directory directory = store.directory();
            listener.onFailure(e);
            shardId,
            );
import org.opensearch.repositories.RepositoriesService;
                if (segmentInfos != null) {
import java.util.Set;
            indexShard.openEngineAndRecoverFromTranslog();
            Sort indexSort = indexShard.getIndexSort();
                    indexShard.syncSegmentsFromGivenRemoteSegmentStore(true, sourceRemoteDirectory, remoteSegmentMetadata, true);
                    return new IndexInput("StatsDirectoryWrapper(" + input.toString() + ")") {
                    // just trigger a merge to do housekeeping on the
import org.opensearch.index.remote.RemoteStoreUtils;
        } catch (EngineException | IOException e) {
                    recoverLocalFiles(recoveryState, segmentInfos, store);
                indexShard.getThreadPool().executor(ThreadPool.Names.GENERIC).execute(() -> {
                    indexShard.recoveryState().getIndex().setFileDetailsComplete();
        writeEmptyRetentionLeasesFile(indexShard);
            return;
                    if (si != null) {
import org.opensearch.cluster.routing.RecoverySource;
/**
                long primaryTerm = shallowCopyShardMetadata.getPrimaryTerm();
    private void internalRecoverFromStoreForSearchReplica(IndexShard indexShard) throws IndexShardRecoveryException {
                indexShard.preRecovery();
                    false,
        index.setFileDetailsComplete();
                final String translogUUID = Translog.createEmptyTranslog(
import org.opensearch.Version;
                // Pass IndexSettings so DFA indices route to DataFormatAwareRemoteDirectory; Lucene-only falls through unchanged.
                if (logger.isTraceEnabled()) {
                    indexShard.recoveryState(),
                idx -> repository.restoreShard(
            throw new IndexShardRecoveryException(shardId, "failed to fetch index version", e);
            indexShard.shardPath().resolveTranslog(),
 *    http://www.apache.org/licenses/LICENSE-2.0
                }, listener::onFailure);
     * @param indexShard the index shard instance to recovery the shard into
        store.bootstrapNewHistory();
    /**
            if (store.directory().listAll().length <= 1) {
            : "unsupported recovery source for search replica: " + recoveryState.getRecoverySource().getType();
        final Store remoteStore = indexShard.remoteStore();
                    shardId,
                        .append("], check_index [")
                translogState.totalOperationsOnStart(0);
                        () -> repositoriesService,
                repositoryDataListener.whenComplete(repositoryData -> {
                        .append("]\n");
        } catch (Exception e) {
     */
                    IndexMetadata prevIndexMetadata = repository.getSnapshotIndexMetaData(
     */
                restore(indexShard, repository, recoverySource, recoveryListener(indexShard, listener));
                        threadPool,
                            e
                    // got closed on us, just ignore this recovery
            writer.setLiveCommitData(() -> {
        indexShard.prepareForIndexRecovery();
import org.opensearch.core.index.Index;
    private final Logger logger;
            }
                    final Directory directory = indexShard.store().directory(); // don't close this directory!!
                if (indexShard.indexSettings.isRemoteStoreEnabled() == false) {
        }
            });
        String segmentsPathFixedPrefix,
                try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
                recoverEmptyStore(indexShard, store);
                liveCommitData.put(SequenceNumbers.MAX_SEQ_NO, Long.toString(maxSeqNo));
                return true;
        ThreadPool threadPool
                assert recoveryType == RecoverySource.Type.SNAPSHOT : "expected snapshot recovery type: " + recoveryType;
    private void recoverFromRemoteStore(IndexShard indexShard) throws IndexShardRecoveryException {
                ),
    private void bootstrapForSnapshot(final IndexShard indexShard, final Store store) throws IOException {
            } else {
import org.opensearch.index.seqno.SequenceNumbers;
    }
    ) {
                    );
        this.shardId = shardId;
            // we don't want merges to happen here - we call maybe merge on the engine
import java.util.concurrent.atomic.AtomicBoolean;
                listener.onResponse(false);
    private void restore(
                        remoteSegmentStoreRepository = IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.get(
                        false,
    void recoverFromLocalShards(
        } else {
                    shardId
 * license agreements. See the NOTICE file distributed with
        logger.debug("restoring from {} ...", indexShard.recoveryState().getRecoverySource());
                    }
        try {
                    }
            indexShard.getPendingPrimaryTerm(),
                        indexShard.indexSettings().getIndexMetadata(),
                return liveCommitData.entrySet().iterator();
                } else if (logger.isDebugEnabled()) {
                indexIdListener.onResponse(indexId);
                    internalRecoverFromStoreForSearchReplica(indexShard);
            });
                }
     * Recovers the state of the shard from the store.
     * exist on disk ie. has been previously allocated or if the shard is a brand new allocation without pre-existing index
                        }
                    }
                Path location = indexShard.shardPath().resolveTranslog();
            listener.onResponse(false);
            if (canRecover(indexShard)) {
        private final ReplicationLuceneIndex index;
                indexShard.postRecovery("restore done");
                if (indexShard.shardRouting.isSearchOnly()) {
import java.util.List;
                    );
    /**
import org.opensearch.core.common.unit.ByteSizeValue;
            indexShard.postRecovery("restore done");
                logger.debug("starting recovery from remote store ...");
                        sb
            listener.onResponse(true);
            indexShard.getPendingPrimaryTerm()
                    return true;
            final Store store = indexShard.store();
import org.opensearch.repositories.RepositoryData;
            indexShard.prepareForIndexRecovery();
            // we increment the num bytes recovered in the readBytes method below, if users pull statistics they can see immediately
    }
                try {
    }
                    logger.trace("cleaning existing shard, shouldn't exists");
            indexShard.finalizeRecovery();
        assert recoveryState.getRecoverySource().getType().equals(RecoverySource.Type.EMPTY_STORE)
        indexShard.prepareForIndexRecovery();
                    indexShard.openEngineAndSkipTranslogRecoveryFromSnapshot();
        }
     *                 has been ignored due to a concurrent modification of if the clusters state has changed due to async updates.
        store.associateIndexWithNewTranslog(translogUUID);
            assert recoveryType == RecoverySource.Type.LOCAL_SHARDS : "expected local shards recovery type: " + recoveryType;
                            prevIndexMetadata.getSettings()
    ) {
     */
                );
import org.opensearch.core.index.shard.ShardId;
        final RecoveryState recoveryState = indexShard.recoveryState();
import org.apache.logging.log4j.Logger;
import org.opensearch.core.action.ActionListener;
        } catch (EngineException | IOException e) {
        @Override
        ActionListener<Boolean> listener
                    bootstrapForSnapshot(indexShard, store);
            }
                final IndexShardState shardState = indexShard.state();
            });
                        @Override
    }
        indexShard.recoveryState().getIndex().setFileDetailsComplete();
            if (canRecover(indexShard)) {
            indexShard.finalizeRecovery();
import org.opensearch.index.engine.EngineException;
            completeRecovery(indexShard, store);
            } else {
        final boolean indexShouldExists = recoveryState.getRecoverySource().getType() != RecoverySource.Type.EMPTY_STORE;
            assert recoveryType == RecoverySource.Type.REMOTE_STORE : "expected remote store recovery type but was: " + recoveryType;
                indexShard.waitForRemoteStoreSync();
                translogState.totalOperations(0);
            if (ex instanceof IndexShardRecoveryException) {
                        hasNested
                    null,
                        files += " (failure=" + ExceptionsHelper.detailedMessage(inner) + ")";
            } else {
            if (indexId.getId().equals(IndexMetadata.INDEX_UUID_NA_VALUE)) {
                            shardId,
                        @Override
        if (indexShard.state() == IndexShardState.CLOSED) {
                    if (indexShard.isRemoteTranslogEnabled() && indexShard.shardRouting.primary()) {
            super(in);
    }
        }
                    String files = "_unknown_";
                final StepListener<RepositoryData> repositoryDataListener = new StepListener<>();
                assert shardState != IndexShardState.CREATED && shardState != IndexShardState.RECOVERING : "recovery process of "
                    .sourceRemoteStoreRepository();
                    shallowCopyShardMetadata.getRemoteStorePathStrategy(),
            // here we wrap the index input form the source directory to report progress of file copy for the recovery stats.
            if (recoveryState.getRecoverySource().getType() == RecoverySource.Type.LOCAL_SHARDS) {
    void recoverFromStore(final IndexShard indexShard, ActionListener<Boolean> listener) {
            ActionListener.completeWith(recoveryListener(indexShard, listener), () -> {
            writer.commit();
                listener.onFailure(ex);
        store.associateIndexWithNewTranslog(translogUUID);
        );
            }
                // Ignore the exception
            if (shardId.getIndexName().equals(indexId.getName())) {
        }
        }
                logger.info("Remote Store is now seeded via local recovery for {}", indexShard.shardId());
                    + shardId
final class StoreRecovery {
                    // copied segments - we will also see them in stats etc.
import org.opensearch.common.lucene.Lucene;
             * document-level semantics.
                        .append("] with total_size [")
            }
                        }
                try {
import org.apache.lucene.search.Sort;
    private final ShardId shardId;
                            index.addRecoveredBytesToFile(dest, len);
     * Restores shard from {@link SnapshotRecoverySource} associated with this shard in routing table
        final long localCheckpoint = Long.parseLong(segmentInfos.userData.get(SequenceNumbers.LOCAL_CHECKPOINT_KEY));
                logger.debug("starting recovery from local shards {}", shards);
                    );
        }, e -> listener.onFailure(new IndexShardRestoreFailedException(shardId, "restore failed", e)));
    }
                        .append(recoveryState.getTranslog().recoveredOperations())
                        public byte readByte() throws IOException {
             * the source shards. This ensures that history after this maximum sequence number can advance and we have correct
            RecoverySource.Type recoveryType = indexShard.recoveryState().getRecoverySource().getType();
        try {
            .setMergePolicy(NoMergePolicy.INSTANCE)
        indexShard.persistRetentionLeases();
                indexShard.openEngineAndSkipTranslogRecoveryFromSnapshot();
    }
            }
     * Recovers an index from a given {@link Repository}. This method restores a
        indexShard.prepareForIndexRecovery();
        Repository repository,
        Repository repository,
                }
            || recoveryState.getRecoverySource().getType().equals(RecoverySource.Type.EXISTING_STORE)
        }
            indexShard.syncSegmentsFromRemoteSegmentStore(true);
     * Directory wrapper that records copy process for recovery statistics
            indexIdListener.whenComplete(
        IndexShard indexShard,
                    si = store.readLastCommittedSegmentsInfo();
package org.opensearch.index.shard;
/*
                store.createEmpty(indexShard.indexSettings().getIndexVersionCreated().luceneVersion);
                    String remoteTranslogRepository = ((SnapshotRecoverySource) indexShard.recoveryState().getRecoverySource())
            if (sourceMetadata.mapping() != null) {
                    SequenceNumbers.NO_OPS_PERFORMED,
            // now that the mapping is merged we can validate the index sort configuration.
                        .append("]\n");
        } catch (Exception e) {
            indexShard.shardPath().resolveTranslog(),
        final RecoveryState recoveryState = indexShard.recoveryState();
                return true;
 *
                indexShard.getIndexer().fillSeqNoGaps(indexShard.getPendingPrimaryTerm());
        );
        final String translogUUID = Translog.createEmptyTranslog(
import org.opensearch.index.engine.Engine;
                    logger.trace(
            } else if (ex instanceof IndexShardClosedException || ex instanceof IndexShardNotStartedException) {
        final Directory[] sources,
                        null,
                    indexShard.syncTranslogFilesFromGivenRemoteTranslog(
    void recoverFromSnapshotAndRemoteStore(
             * We set the maximum sequence number and the local checkpoint on the target to the maximum of the maximum sequence numbers on
        final Sort indexSort,
                        index.addFileDetail(dest, l, false);
                    RemoteSegmentMetadata remoteSegmentMetadata = sourceRemoteDirectory.initializeToSpecificTimestamp(
import org.opensearch.index.mapper.MapperService;
            } else {
        store.incRef();
                        .append(new ByteSizeValue(index.totalBytes()))
                // Check that the gateway didn't leave the shard in init or recovering stage. it is up to the gateway
        final long maxUnsafeAutoIdTimestamp,
    StoreRecovery(ShardId shardId, Logger logger) {
                            throw new UnsupportedOperationException("slices are not supported");
    }
                    () -> repositoriesService,
        StatsDirectoryWrapper(Directory in, ReplicationLuceneIndex indexRecoveryStats) {
import org.apache.lucene.store.FilterDirectory;
            });
                assert indexShard.shardRouting.primary() : "only primary shards can recover from store";
 * software distributed under the License is distributed on an
                            throw new UnsupportedOperationException("only straight copies are supported");
        if (restoreSource == null) {
        if (indexSort != null) {
            listener.onResponse(false);
        final Directory target,
            // later once we stared it up otherwise we would need to wait for it here
import org.opensearch.cluster.metadata.MappingMetadata;
                    if (indexShard.isRemoteTranslogEnabled() && indexShard.shardRouting.primary()) {
    void recoverFromRemoteStore(final IndexShard indexShard, ActionListener<Boolean> listener) {
                        .append(TimeValue.timeValueMillis(index.time()))
        } catch (Exception e) {
                }
        RepositoriesService repositoriesService,
                            // we rely on the fact that copyFrom uses a buffer
        String translogUUID = store.readLastCommittedSegmentsInfo().getUserData().get(Translog.TRANSLOG_UUID_KEY);
                }
 * specific language governing permissions and limitations
            indexShard.mapperService().merge(sourceMetadata, MapperService.MergeReason.MAPPING_RECOVERY);
                    remoteStoreRepository,
        }
            if (recoveryState.getRecoverySource().getType().equals(RecoverySource.Type.EXISTING_STORE)) {
            indexShard.finalizeRecovery();
        indexShard.finalizeRecovery();
 * this file be licensed under the Apache-2.0 license or a
                    // got closed on us, just ignore this recovery
            } else {
 * not use this file except in compliance with the License.
                store.failIfCorrupted();
                    writeEmptyRetentionLeasesFile(indexShard);
        final Store store = indexShard.store();
            }
        }
                    indexShard.openEngineAndRecoverFromTranslog(false);
        final ActionListener<Void> restoreListener = ActionListener.wrap(v -> {
                        }
                if (remoteStoreRepository == null) {
                    indexShard.shardPath().resolveTranslog(),
 * disk or from a snapshot in a repository.
                    indexShard.indexSettings
                liveCommitData.put(Engine.MAX_UNSAFE_AUTO_ID_TIMESTAMP_COMMIT_ID, Long.toString(maxUnsafeAutoIdTimestamp));
                mappingUpdateConsumer.accept(sourceMetadata.mapping());
import static org.opensearch.index.translog.Translog.CHECKPOINT_FILE_NAME;
import org.apache.lucene.index.SegmentInfos;
                    final long maxSeqNo = shards.stream().mapToLong(LocalShardSnapshot::maxSeqNo).max().getAsLong();
            throw new IndexShardRecoveryException(shardId, "failed to recover from gateway", e);
