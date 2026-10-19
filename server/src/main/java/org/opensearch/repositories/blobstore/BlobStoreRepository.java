    }
        RepositoryData oldRepoData,
                        shardContainer,
                final GroupedActionListener<Void> loadAllVersionsListener = new GroupedActionListener<>(
     * Creates new BlobStore to read and write data.  
        RepositoryData oldRepositoryData,
import java.util.ArrayList;
            remoteStoreLockManagerFactory,
        }  
        );  
    private static void mayBeLogRateLimits(BlobStoreTransferContext context, RateLimiter rateLimiter, long time) {  
    }  
     */
            SnapshotFiles sourceFiles = null;
                    updatedRepoData,
                    || (blob.startsWith(SNAPSHOT_PREFIX)
    public Compressor getCompressor() {
    public InputStream maybeRateLimitRestores(InputStream stream) {
        SnapshotId snapshotId
    }
    }
                bestGenerationFromCS = bestGeneration(  
                .stream()  
                                ),  
                        + "] bytes."  
                        String shardId = parts[partLength - 1];
                    + safeGeneration  
                public TimeValue timeout() {
        final StepListener<Collection<ShardSnapshotMetaDeleteResult>> writeShardMetaDataAndComputeDeletesStep = new StepListener<>();
                if (shardContainer.blobExists(REMOTE_STORE_SHARD_SHALLOW_COPY_SNAPSHOT_FORMAT.blobName(snapshotId.getUUID()))) {
    }  
                @Override
            final String newGen;
                        + SNAPSHOT_REPOSITORY_DATA_CACHET_THRESHOLD_SETTING_NAME  
import java.util.stream.Stream;
                        snapshotId.getUUID(),  
    protected void doStop() {}  
                DeleteResult deleteResult = deleteShardData(shardInfo);  
    }
            }  
                        rootBlobs,
        boolean forceClean,
        RepositoryStats extendedSseStoreStats = getExtendedStats(serverSideEncryptedStore);
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService,
                    updatedShardPathsIndexIds
                .filter(id -> snapshotIds.contains(id) == false)
            } catch (Exception exp) {
    /**  
                    }
    @Override
                                    return container.readBlob(fileInfo.partName(slice));
                    .collect(Collectors.toList());  
                );
                    List<BlobStoreIndexShardSnapshot.FileInfo> filesToRecover,
            }  
            Collection<List<String>> subList = toDelete.stream()  
                private long newGen;
            final Set<SnapshotId> survivingSnapshots = oldRepositoryData.getSnapshots(indexId)  
import org.apache.lucene.store.IndexInput;
        IndexShardSnapshot snapshot = loadShardSnapshot(shardContainer(indexId, shardId), snapshotId);  
            BlobPath shardPath = shardPath(indexId, shardId);
                if (provider == null) {  
            }  
    ) throws InterruptedException {
            }
        }
        private final Collection<String> blobsToDelete;
        return snapshotRateLimitingTimeInNanos.count();
package org.opensearch.repositories.blobstore;
        "compression_type",  
        logger.debug("Successfully released lock for shard {} of index with uuid {}", shardId, indexUUID);
            writeShardMetaDataAndComputeDeletesStep
     * Resolves the list of files that should be deleted during a snapshot deletion operation.
    ) {  
     */  
                                remoteStoreRepository,
                )
        "index-metadata",
            Set<String> indexIdShardPaths = getSnapshotShardPaths().keySet();  
                    + "]"  
                    rootBlobContainer = blobStore().blobContainer(BlobPath.cleanPath());
                return null;  
                                    RepositoriesMetadata.TYPE,
        }
            shardId,
                    }
        }  
                                    )  
                        + target
            final BlobStoreIndexShardSnapshot snapshot = (BlobStoreIndexShardSnapshot) indexShardSnapshot;  
        );
        uncleanStart = uncleanStart && metadata.generation() != metadata.pendingGeneration();
    }
        boolean indexMetadataEnabled = RemoteStoreUtils.determineTranslogMetadataEnabled(prevIndexMetadata);
                final Map<SnapshotId, Version> updatedVersionMap = new ConcurrentHashMap<>();
                    final long genInState = meta.generation();
                            } catch (Exception e) {  
                existingShardGen = String.valueOf(tuple.v2());
                throw new RepositoryVerificationException(metadata.name(), "cannot delete test data at " + basePath(), exp);
                for (SnapshotId snapshotId : snapshotIdsWithoutVersion) {
            .execute(
    }
        return restoreRateLimiter;
        IndexShardSnapshotStatus snapshotStatus,  
        } else {  
import org.apache.lucene.store.RateLimiter;  
            cached = null;
                }
                    }
                    // all contents by an external process so we reset the safe generation to the empty generation.
     */  
import org.opensearch.common.settings.Setting;
        ActionListener<Void> listener
        );  
import java.util.stream.Collectors;
    protected final long repositoryDataCacheThreshold;
                            // Just passing null here to count down the listener instead of failing it, the stale data left behind  
        ByteSizeValue.ZERO,
                return seed;
    }  
                            Collections.emptyList(),
                        );
            return;  
    );  
                    IndexMetadata prevIndexMetadata = this.getSnapshotIndexMetaData(oldRepoData, snapshotId, indexId);
                2
                        String snapshotUUID = extractShallowSnapshotUUID(blobName).orElseThrow();  
                            try (InputStream stream = maybeRateLimitRestores(new SlicedInputStream(fileInfo.numberOfParts()) {
    }
    /**  
                @Override
                                    snapshotIds,  
                context,
                    writeShardMetaDataAndComputeDeletesStep.result(),
                        metadata.name(),
import org.apache.logging.log4j.message.ParameterizedMessage;  
    private long bestGeneration(Collection<? extends RepositoryOperation> operations) {
                assert false : e;
                    cleanRemoteStoreDirectoryIfNeeded(deletedSnapshots, indexSnId, oldRepoData, remoteSegmentStoreDirectoryFactory, true);  
    /**  
    /**  
        return latestGeneration(blobContainer().listBlobsByPrefix(INDEX_FILE_PREFIX).keySet());  
                    logger.warn(
/*  
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory
                assert false : "Store should not be closed concurrently unless snapshot is aborted";
            return;  
                indexId.getId(),
            fileTransferTracker,  
    );
                remoteStoreSettings.getSegmentsPathFixedPrefix()
    ) {
        }  
    }
                        testContainer.writeBlobAtomic("master.dat", stream, bytes.length(), true);
            "Could not read repository data because the contents of the repository do not match its "
import org.opensearch.core.action.ActionListener;
    private static final String TESTS_FILE = "tests-";
import org.opensearch.core.common.unit.ByteSizeValue;
                byte[] testBytes = Strings.toUTF8Bytes(seed);
            recoverySettings::recoveryRateLimiter,  
        } catch (Exception exp) {  
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
                );
            }
                        "Failed to load repository data generation ["
                    writtenGeneration = ShardGenerations.DELETED_SHARD_GEN;
     */
    private long latestGeneration(Collection<String> rootBlobs) {  
        // index-${gen_uuid} will not be referenced by the existing RepositoryData and new RepositoryData is only
        METADATA_NAME_FORMAT,
        Setting.Property.NodeScope  
            synchronized (lock) {
        IndexMetadata::fromXContent  
        return blobContainer.get();
    private final CounterMetric remoteDownloadLowPriorityRateLimitingTimeInNanos = new CounterMetric();
                executeOneFileSnapshot(
                public void onResponse(Void aVoid) {
        );
                protected void restoreFiles(
        final Set<String> allSnapshotIds = repositoryData.getSnapshotIds().stream().map(SnapshotId::getUUID).collect(Collectors.toSet());
 * You may obtain a copy of the License at  
            if (snapshotIds.isEmpty()) {
                existingSnapshots = tuple.v1();  
                        lastSnapshotStatus.getIndexVersion(),
        return provider.blobStore(serverSideEncryptionEnabled);  
            } else {  
            } finally {
                groupedListener,  
     * @return BlobStore `Blobstore` for the repository
                    unusedBlobs(blobs, survivingSnapshotUUIDs, updatedSnapshots, remoteStoreLockManagerFactory)
    ) {  
                foundIndices,
    );
                        metadata.name(),  
        // Index that the snapshot was removed from
            final Set<String> blobs;
     * released when deleting the respective shallow-snap-UUID blobs.  
                    listener.onFailure(e);
                        shardBlob.getValue(),  
            repositoryStateId,  
            BlobStoreIndexShardSnapshots snapshots = tuple.v1();
import org.opensearch.common.Priority;
    private RepositoryStats getExtendedStats(BlobStore store) {
        SNAPSHOT_CODEC,  
        BlobStoreIndexShardSnapshots updatedSnapshots
                if (rootBlobContainer == null) {
    }  
                        // For hashed_infix, the parts would look like [<base_path>,"j01010001010","indices","<index-id>","<shard-id>"]
                        e  
    ) {  
     * @prama isShallowSnapshotV2                true for shallow snapshot v2
import org.opensearch.cluster.node.DiscoveryNode;
                }
            : "indexShardSnapshot should be an instance of RemoteStoreShardShallowCopySnapshot";  
            () -> new ParameterizedMessage(
import org.opensearch.cluster.SnapshotDeletionsInProgress;
    /**
 * this file be licensed under the Apache-2.0 license or a
        // the latest known repository generation
                        writtenGeneration = UUIDs.randomBase64UUID();
        if (latestKnownRepoGen.get() == RepositoryData.CORRUPTED_REPO_GEN) {  
            } catch (Exception e) {
     * @throws IOException If an I/O error occurs during the deletion process.
                logger.info("[{}] completed cleanupOldShardGens", metadata.name());
     * Returns data file chunk size.
                newSnapshotsList.add(point);  
                                        .<RepositoriesMetadata>custom(RepositoriesMetadata.TYPE)
            removeSnapshotPinnedTimestamp(
            int indexTotalNumberOfFiles = fileNames.size();
            } else {  
        List<String> paths = new ArrayList<>();
        final String blobName = INDEX_SHARD_SNAPSHOTS_FORMAT.blobName(String.valueOf(indexGeneration));
        Version repositoryMetaVersion,
            remoteTranslogTransferTracker,
        //  
        }
            logger.debug(new ParameterizedMessage("indexIdShardPaths={}", indexIdShardPaths));
                    indexMetas,
                    provider.close();
            return DeleteResult.ZERO;  
                snapshotStatus.moveToDone(threadPool.absoluteTimeInMillis(), indexGeneration);  
                }
            if (shardGeneration == null) {
                    return knownRef;  
import org.apache.lucene.store.IOContext;  
                    updatedIndexIds.add(shardPathsBlobName);  
        ShardId snapshotShardId
    private final CounterMetric snapshotRateLimitingTimeInNanos = new CounterMetric();  
                    () -> GLOBAL_METADATA_FORMAT.write(clusterMetadata, blobContainer(), snapshotId.getUUID(), compressor)
        Version repositoryMetaVersion,
        final Consumer<Exception> onUpdateFailure = e -> listener.onFailure(
            null,
     *
            () -> remoteUploadLowPriorityRateLimiter,
                    || FsBlobContainer.isTempBlobName(blob)
            );  
        executor.execute(ActionRunnable.supply(listener, () -> {
    }
            logger.warn(  
                target.getUUID(),
                return repositoryData.getGenId() > Long.parseLong(blob.substring(INDEX_FILE_PREFIX.length()));  
    private static Releasable incrementStoreRef(Store store, IndexShardSnapshotStatus snapshotStatus, ShardId shardId) {
                                deleteFromContainer(blobContainer(), oldIndexN);  
                        if (meta.generation() != expectedGen) {
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
            // in this case, try reading the latest index generation from the index.latest blob  
                        metadata.name(),  
                                    ensureNotClosing(store);
                uniqueIndexIds.add(shardSnapshotMetaDeleteResult.indexId.getId());
     * already stored in the metadata referencing them, i.e. in {@link BlobStoreIndexShardSnapshot} and
     * @param idToShardInfoMap              Map of indexId to ShardInfo
                namedXContentRegistry  
    // Visible for testing
    @Override
        BlobContainer shardContainer,
        final ClusterService clusterService,
        remoteUploadLowPriorityRateLimiter = getRateLimiter(MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC_SETTING, metadata.settings());  
                                    state.withUpdatedGeneration(  
        TranslogTransferManager translogTransferManager = RemoteFsTranslog.buildTranslogTransferManager(
                }  
            executor.execute(
     *
    }  
    );
                shardContainer,  
                    repositoryUpdatePriority,
            }
            logger.info(
            // Run unreferenced blobs cleanup in parallel to shard-level snapshot deletion
                snapshotInfo.snapshotId(),
                        );  
        final ActionListener<Collection<ShardSnapshotMetaDeleteResult>> deleteIndexMetadataListener = new GroupedActionListener<>(  
            final int workers = Math.min(threadPool.info(ThreadPool.Names.SNAPSHOT_DELETION).getMax(), staleFilesToDeleteInBatch.size());
        }  
            // directory. this issue could even happen in cases of shard level remote store data cleanup which also  
    }
     * </p>
     * @param onFailure      callback to invoke with failure in case the repository generation is not physically found in the repository
                            () -> new ParameterizedMessage(
                indexUUID,
    /**
import org.opensearch.index.mapper.MapperService;  
        Version repoMetaVersion,
            }
                    } catch (CorruptIndexException | IndexFormatTooOldException | IndexFormatTooNewException ex) {  
        Map<String, ShardInfo> idToShardInfoMap
            Set<String> uniqueIndexIds = new HashSet<>();
     * @param newGen new repository generation  
            long indexTotalFileSize = 0;
                    BlockingQueue<BlobStoreIndexShardSnapshot.FileInfo> files,
        ShardId shardId,
        return new RepositoryException(
            }  
import org.opensearch.common.settings.Settings;
import java.util.stream.LongStream;  
     * Setting to disable caching of the latest repository data.
            inputStream,
import org.opensearch.indices.recovery.RecoveryState;  
                                forceClean,
        Set<String> survivingIndexIds,
    public static final double SNAPSHOT_REPOSITORY_DATA_CACHE_THRESHOLD_DEFAULT_PERCENTAGE = 0.01;  
     * @return updated cluster state
import static org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot.FileInfo.canonicalName;
                            meta.pendingGeneration()
                    boolean success = false;  
        threadpool.executor(threadPoolName)
                            );
            final int workers = Math.min(threadPool.info(ThreadPool.Names.SNAPSHOT_DELETION).getMax(), staleFilesToDeleteInBatch.size());
        deleteSnapshotsInternal(  
            );  
    public BlobContainer shardContainer(IndexId indexId, int shardId) {
    private void maybeWriteIndexLatest(long newGen) {
                    staleIndicesToDelete,
                ex
                // remote store is mirroring the local store.
        }, listener::onFailure);
                indexCommitPointFiles = filesFromSegmentInfos;  
     * This flag indicates that the repository can not exclusively rely on the value stored in {@link #latestKnownRepoGen} to determine the
            logger.debug("[{}] [{}] snapshot to [{}] [{}] ...", shardId, snapshotId, metadata.name(), generation);  
                                .filter(blob -> blob.startsWith(SNAPSHOT_INDEX_PREFIX))  
    /**  
            final ShardGenerations.Builder builder = ShardGenerations.builder();  
    protected volatile int bufferSize;
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
    public IndexShardSnapshot loadShardSnapshot(BlobContainer shardContainer, SnapshotId snapshotId) {  
    // package private, only use for testing
                cacheEntry.v1()
                    if (!deletedSnapshots.contains(snapshotId)) {
                        throw new IllegalStateException(
    @Override
                    }
    public void cloneShardSnapshot(  
    ) {
            final BlobContainer indexContainer = indexContainer(indexId);  
                }
                    try {
                        + "] to generation ["  
                    if (uninitializedMeta == false && meta.pendingGeneration() != genInState) {
            } catch (NoSuchFileException nsfe) {  
            // iterate through all the indices and trigger remote store directory cleanup for deleted index segments  
     *
            deleteFromContainer(blobContainer(), blobsToDelete);
        Map<String, ShardInfo> idToShardInfoMap  
                    logger.error(  
    protected BlobContainer rootBlobContainer() {  
        SnapshotInfo::fromXContentInternal
            // TODO: We shouldn't be blanket catching and suppressing all exceptions here and instead handle them safely upstream.
                try {
                        BlobStoreIndexShardSnapshot.FileInfo snapshotFileInfo = new BlobStoreIndexShardSnapshot.FileInfo(
    }
            "mark repository corrupted [" + metadata.name() + "][" + corruptedGeneration + "]",
        threadPool.executor(ThreadPool.Names.SNAPSHOT_DELETION).execute(ActionRunnable.wrap(listener, l -> {
                return new Tuple<>(BlobStoreIndexShardSnapshots.EMPTY, ShardGenerations.NEW_SHARD_GEN);  
        MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC,
import org.opensearch.index.translog.RemoteFsTranslog;
        try {
import org.opensearch.core.xcontent.NamedXContentRegistry;
        if (shardInfo == null) {
                                AllocationService.firstListElementsToCommaDelimitedString(
                                    survivingSnapshots,  
                        listener.onFailure(
    private final CounterMetric remoteUploadRateLimitingTimeInNanos = new CounterMetric();  
                        BlobContainer shardContainer = blobStore().blobContainer(blobPath);
        RemoteStorePathStrategy pathStrategy,  
                        // create a new FileInfo
                if (known != null && known.v1() > generation) {
                RemoteStorePathStrategy pathStrategy = store.indexSettings().getRemoteStorePathStrategy();
            assert false : e;
    public static final String SNAPSHOT_PREFIX = "snap-";  
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,  
        Map<String, BlobContainer> foundIndices,
        } catch (IOException ioe) {  
    protected final ClusterService clusterService;
    // Finds all blobs directly under the repository root path that are not referenced by the current RepositoryData  
                snapshotShardPathBlobContainer = this.snapshotShardPathBlobContainer.get();
                );
                            );
                    } else {  
    }
        long startTime,
            Map<String, BlobMetadata> snapshotShardPaths = getSnapshotShardPaths();
                                .collect(Collectors.toSet())
        ShardId snapshotShardId,  
                                    indexId.getName(),
    }
                try (InputStream masterDat = testBlobContainer.readBlob("master.dat")) {
                        snapshotId.getUUID(),
                            + "]. "
     * </ul>
    public InputStream maybeRateLimitRemoteDownloadTransfersForWarm(InputStream inputStream) {  
                    staleIndicesToDelete,
            ActionListener.wrap(  
import org.opensearch.repositories.IndexId;  
        ByteSizeValue.parseBytesSizeValue("128kb", "io_buffer_size"),  
            return;  
    }
                    ActionListener.wrap(  
            }  
     *
                    return;
                                )  
                                newGen = -1L;
    public void reload(RepositoryMetadata repositoryMetadata) {
                        remoteSegmentStoreDirectoryFactory,
        // Extract the ShardInfo object from the highest generation shard path, if present
            }
            latestKnownRepoGen.updateAndGet(known -> Math.max(known, finalBestGen));
                    newGen = uninitializedMeta ? Math.max(expectedGen + 1, nextPendingGen) : nextPendingGen;
        executor.execute(ActionRunnable.supply(listener, () -> {  
        assert indexShardSnapshot instanceof RemoteStoreShardShallowCopySnapshot
            final BlobStoreIndexShardSnapshots updatedBlobStoreIndexShardSnapshots = new BlobStoreIndexShardSnapshots(newSnapshotsList);  
     * @param foundIndices                  indices that are found at [base_path]/indices
        IndexId indexId,
        final IndexId index = shardId.index();  
                    assert GLOBAL_METADATA_FORMAT.blobName(foundUUID).equals(blob);
                    public ClusterState execute(ClusterState currentState) {  
    }  
                        indexTotalNumberOfFiles,
            } else {  
     * @param oldRepositoryData The repository data before the snapshot deletion
            if (newShardCount > oldShardCount) {  
    }
            final long startTime = threadPool.relativeTimeInMillis();
     * released when deleting the respective shallow-snap-UUID blobs.
                newGen,
     * Setting to enable prefix mode verification. In this mode, a hashed string is prepended at the prefix of the base  
                logger.warn("store cannot be marked as corrupted", inner);
                .values();
import org.apache.lucene.index.IndexFormatTooNewException;  
     * @param remoteStoreLockManagerFactory remote store lock manager factory used for shallow snapshots
                        assert (remoteTranslogRepositoryName != null);  
     * all cases and simply do a redundant listing of the repository contents if it tries to load {@link RepositoryData} and falls back
        }  
                    + repositoryStateId  
                staleFilesToDeleteInBatch.size()
    private void remoteTranslogCleanupAsync(  
                    final int finalShardId = shardId;
    }
                        }
     */
        true,  
            metric.inc(t);
                    // This is motivated by the consistency behavior the S3 based blob repository implementation has to support which does
        })).collect(Collectors.toList());  
            final ActionListener<Void> afterCleanupsListener = new GroupedActionListener<>(  
    BlobContainer getRootBlobContainer() {  
        String repository,
                                remoteStorePathStrategy,
                        fileNames = snapshotIndexCommit.getFileNames();
            }
    public static final String SHALLOW_SNAPSHOT_NAME_FORMAT = SHALLOW_SNAPSHOT_PREFIX + "%s.dat";
        Collection<ShardSnapshotMetaDeleteResult> deleteResults,
        BlobStoreProvider provider = null;
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,
            INDEX_SHARD_SNAPSHOT_FORMAT.write(
                    // since we're only caching the information that we just wrote and thus won't accidentally cache any information that
            shardGenerations,
                repositoryStateId,
        @Override  
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,  
            } else {
import org.opensearch.cluster.metadata.RepositoryMetadata;
        SnapshotInfo snapshotInfo,  
    public static final Setting<Compressor> COMPRESSION_TYPE_SETTING = new Setting<>(
            genToLoad = latestKnownRepoGen.updateAndGet(known -> Math.max(known, repositoryStateId));  
     */
        return true;
        Collection<SnapshotId> deletedSnapshots,
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;  
                    provider = new BlobStoreProvider(this, metadata, lifecycle, lock);
                    if (snapshotStatus.isAborted()) {
            }
    ) {
        BlobStoreIndexShardSnapshot.FileInfo fileInfo,  
        try {  
                logger.trace(() -> new ParameterizedMessage("[{}] Writing [{}] to [{}]", metadata.name(), partName, shardContainer.path()));  
            String fileListGeneration = tuple.v2();  
import org.opensearch.common.util.concurrent.AbstractRunnable;
            }
    // temporary blobs. If remoteStoreLockManagerFactory is non-null, the shallow-snap- files that do not belong to any of the
     * @param indexGeneration generation to write the new shard level level metadata to. If negative a uuid id shard generation should be
                        + newGen  
                        new RepositoryException(metadata.name(), "Failed to execute cluster state update [" + source + "]", e)  
        snapshotsWithPinnedTimestamp.forEach((snapshotId, pinnedTimestamp) -> {  
                assert wasBestEffortConsistency
        SNAPSHOT("snapshot"),  
        this.remoteStoreSettings = new RemoteStoreSettings(clusterService.getSettings(), clusterService.getClusterSettings());
            remoteSegmentStoreDirectoryFactory,
                    remoteSegmentStoreDirectoryFactory,  
        writeAtomic(
    }
            if (sourceFiles == null) {
     *
            );
                );
                final InputStream inputStream = new FilterInputStream(
        return blobStore().blobContainer(shardPath(indexId, shardId));  
            snapshotStatus,
    }  
                provider = this.blobStoreProvider.get();
        RepositoryData existingRepositoryData,
                            (needsWrite ? UPLOADED_DATA_BLOB_PREFIX : VIRTUAL_DATA_BLOB_PREFIX) + UUIDs.randomBase64UUID(),  
    }
                );
                toDelete.size(),
    ) {
                    indexTotalNumberOfFiles++;  
        final ActionListener<RepositoryData> listener
                // local store is being used here to fetch the files metadata instead of remote store as currently
    enum BlobStoreTransferContext {  
                        this.basePath().toString(),
                        + "]. A snapshot by that name already exists for this shard."
                    repositoryMetaVersion,  
    }  
                throw new IllegalArgumentException(
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                    latestKnownRepositoryData.set(null);
            primaryTerm,  
        if (provider != null) {
        return operations.stream()
    /**  
            }
            final BlobContainer shardContainer = shardContainer(indexId, shardId);
            IndexShardSnapshot indexShardSnapshot = loadShardSnapshot(shardContainer, source);
            remoteUploadRateLimitingTimeInNanos,  
                                        repoState.pendingGeneration()  
            releaseRemoteStoreLocksAndCleanup(indexEntry.getValue().children(), remoteStoreLockManagerFactory);
        return maybeRateLimitRemoteTransfers(  
                }
            try {
                        assert (remoteStoreRepository != null);
    }
                                            )
                    this,
    }
            snapshotIdPinnedTimestampMap.keySet(),
    }
                for (String fileName : fileNames) {
    }
    public abstract BlobPath basePath();
                final BlobStoreIndexShardSnapshots updatedSnapshots;
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,
                    repositoryData,
            }
                compressor
                // now create and write the commit point
        ActionListener<Void> listener
                if (survivingIndexIds.contains(indexEntry.getKey()) == false) {  
                            stateFilter.apply(
                // If we have surviving non shallow snapshots, update index- file.  
            }
    BlobStore getBlobStore(boolean isServerSideEncryptionEnabled) {
        if (rootBlobContainer == null) {
    private final boolean isSystemRepository;
     * Loads {@link RepositoryData} ensuring that it is consistent with the given {@code rootBlobs} as well of the assumed generation.
    }
            releaseRemoteStoreLocksAndCleanup(shardContainers, remoteStoreLockManagerFactory);
            synchronized (lock) {
                final String foundUUID;
        }
        // Releasing lock file before deleting the shallow-snap-UUID file because in case of any failure while  
        REMOTE_DOWNLOAD("remote_download"),
            }  
                } else {  
    ) {  
        long repositoryStateId,  
                    + INDEX_SHARD_SNAPSHOTS_FORMAT.blobName(writtenGeneration)
                        () -> new ParameterizedMessage(  
                                threadPool,
                // This is done as a fail-safe in case a user manually deletes the contents of the repository in which case subsequent  
            String[] parts = shardPath.split("\\" + SnapshotShardPaths.DELIMITER);
            );  
                    indexId,
        SnapshotId snapshotId,
    public RateLimiter remoteDownloadRateLimiter() {  
    ) {
 * KIND, either express or implied.  See the License for the
                blobs = Collections.singleton(INDEX_FILE_PREFIX + generation);
import org.opensearch.common.collect.Tuple;
     * This method should return null if no chunking is needed.  
    public static final Setting<Boolean> SUPPORT_URL_REPO = Setting.boolSetting("support_url_repo", true, Setting.Property.NodeScope);
import org.opensearch.Version;  
        try {
                    closed = true;
        }, listener::onFailure), 2);
        final Map<IndexId, Collection<String>> indexMetaGenerations = oldRepositoryData.indexMetaDataToRemoveAfterRemovingSnapshots(  
    // for test purposes only  
            }
            logger.debug("Repository [{}] writing new index generational blob [{}]", metadata.name(), indexBlob);
                    "Failed to write shard level snapshot metadata for ["
                SnapshotShardPaths.DELIMITER,
        final ActionListener<Void> restoreListener = ActionListener.delegateResponse(
            )
    protected void doClose() {  
                        protected void doRun() throws Exception {
        } catch (Exception e) {
            recoverySettings::recoveryRateLimiter,
        if (isReadOnly()) {
     * @param remoteStorePinnedTimestampService  RemoteStorePinnedTimestampService to be used for unpinning the snapshot timestamp
                    if (prevIndexMetadata != null && !isIndexPresent(clusterService, prevIndexMetadata.getIndexUUID())) {  
        } else {
            assert false : e;
     *                                          store segments
                    logger.trace(() -> new ParameterizedMessage("[{}] restoring [{}] to [{}]", metadata.name(), fileInfo, store));
        for (Map.Entry<String, BlobContainer> shardBlob : shardBlobs.entrySet()) {
    }
        return readOnly;
        assert maxGenShardPath != null : "Valid maxGenShardPath should be present";
     * Flag that is set to {@code true} if this instance is started with {@link #metadata} that has a higher value for
        if (isReadOnly()) {
            // of stale indexes in combination with Snapshot Shard Paths file  
        long startTimeNs = System.nanoTime();
     * contents will not result in the repository being marked as corrupted.
                )  
            }
                    ),  
                    snapshotShardId,  
                newGen = String.valueOf(tuple.v2() + 1);
 * BlobStore - based implementation of Snapshot Repository
                metadata.name(),
        "max_snapshot_shard_blob_delete_batch_size",
                    executeOneFileSnapshot(store, snapshotId, indexId, snapshotStatus, filesToSnapshot, executor, l, cryptoMetadata);
                }
                if (blob.startsWith(SNAPSHOT_PREFIX)) {  
        SnapshotId snapshotId,
    ) throws IOException {
                                    blobs,
                    executor.execute(new AbstractRunnable() {
        throws IOException {  
        if (snapshotFileInfo == null) {
    public static final Setting<Boolean> ALLOW_CONCURRENT_MODIFICATION = Setting.boolSetting(
                }  
                            }  
     * @param shardInfo The ShardInfo object containing information about the shards to be deleted.
    }
            final ActionListener<Void> filesListener = fileQueueListener(filesToSnapshot, workers, allFilesUploadedListener);
            indexId,
                                .putCustom(
     * Setting to set repository as readonly
                            recoveryState.getIndex().addRecoveredBytesToFile(fileInfo.physicalName(), hash.length);
                            try {
            groupedListener.onResponse(DeleteResult.ZERO);
                    if (len > cacheWarningThreshold) {  
                );
                            remoteStoreLockManagerFactory,
        String writtenGeneration = null;  
import org.opensearch.core.index.Index;
     * @throws IOException If an I/O error occurs during the release and cleanup process
                            fileInfo.physicalName(),  
                @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            } catch (IOException e) {
    private final AtomicReference<SoftReference<Tuple<Long, BytesReference>>> latestKnownRepositoryData = new AtomicReference<>(  
            for (int i = 0; i < workers; ++i) {  
        // written if all shard paths have been successfully updated.  
        }
                executeOldShardGensCleanup(staleFilesToDeleteInBatch, listener);  
        finalizeSnapshot(
     *
                    foundUUID = blob.substring(METADATA_PREFIX.length(), blob.length() - ".dat".length());
        }
     */
                    // If the safe generation has changed, then we have to reload repository data and start over.
        }
     */
                        + "]. The source snapshot ["
                return;  
    private volatile boolean readOnly;  
                metadata.name(),
    public BlobStore blobStore() {  
                                "Failed to release lock or cleanup shard for indexID {}, shardID {} and snapshot {}",
                    e
        } catch (IOException ex) {
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService,
                listener.onResponse(repositoryDataFromCachedEntry(cached));
    public static final ChecksumBlobStoreFormat<RemoteStoreShardShallowCopySnapshot> REMOTE_STORE_SHARD_SHALLOW_COPY_SNAPSHOT_FORMAT =
        if (isReadOnly()) {
        writeUpdatedShardMetaDataAndComputeDeletes(
                            logger.warn(  
                    e  
        });
        public String toString() {
            provider = blobStoreProvider.get();
            if (latestKnownRepoGen.get() >= newGen) {  
            } else {
            List<String> staleShardPaths = indexIdShardPaths.stream()
        }, listener::onFailure);
        );
            if (bestEffortConsistency) {
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
            if (indexId.getShardPathType() == PathType.FIXED.getCode()) {
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,  
        this.metadata = repositoryMetadata;  
        }).collect(Collectors.toList());  
        IndexCommit snapshotIndexCommit,
                    }  
        final List<SnapshotDeletionsInProgress.Entry> deletionEntries = new ArrayList<>();
            if (FsBlobContainer.isTempBlobName(blob)) {
    }
    /**  
                ex
                                        oldRepositoryData.shardGenerations().getShardGen(indexId, finalShardId)
                public ClusterState execute(ClusterState currentState) {
        ActionListener<RepositoryData> listener  
                    Store store,  
     */
            List<SnapshotFiles> newSnapshotsList = new ArrayList<>();
                                    + "]"
import org.opensearch.common.Randomness;  
                    if (existingFileInfo == null) {
    }
     * {@link BlobStoreIndexShardSnapshots}. This is the case for files for which {@link StoreFileMetadata#hashEqualsContents()} is
    public long getLowPriorityRemoteDownloadThrottleTimeInNanos() {
                try {
                    final RepositoryData repositoryData = safeRepositoryData(repositoryStateId, rootBlobs);
    // updates the shard state metadata for shards of a snapshot that is to be deleted. Also computes the files to be cleaned up.  
    }  
        final StepListener<Long> setPendingStep = new StepListener<>();  
import org.opensearch.common.lucene.store.InputStreamIndexInput;
        try (InputStream input = CompressorRegistry.defaultCompressor().threadLocalInputStream(cacheEntry.v2().streamInput())) {
import org.opensearch.cluster.RepositoryCleanupInProgress;  
            }.restore(snapshotFiles, store, l);  
                .collect(Collectors.toSet());
    public IndexShardSnapshot loadShardSnapshot(BlobContainer shardContainer, SnapshotInfo snapshotInfo) {
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
                    indexTotalFileSize += fileInfo.length();
    );
                    private void checkAborted() {
        );  
        long startTime,  
                }  
        if (bestEffortConsistency) {
    public static final Setting<Boolean> CACHE_REPOSITORY_DATA = Setting.boolSetting(
                return;
                snapshotId.getName()  
                testContainer(seed).delete();  
        } catch (NoSuchFileException e) {
    private RepositoryData getRepositoryData(long indexGen) {  
    private void executeOneStaleIndexDelete(
            () -> remoteDownloadRateLimiter,  
                Tuple<BlobStoreIndexShardSnapshots, Long> tuple = buildBlobStoreIndexShardSnapshots(  
                genToLoad = latestKnownRepoGen.get();
    }  
            executor.execute(
                    }
                        threadPool.absoluteTimeInMillis() - lastSnapshotStatus.getStartTime(),  
    }  
        ShardInfo shardInfoFromMap = idToShardInfoMap.get(indexId);  
    ) {  
                        SUPPORT_URL_REPO.getKey()
            int shardCount = Integer.parseInt(parts[parts.length - 3]);
     * modification can lead to moving from a higher {@code N} to a lower {@code N} value which mean we can't safely assume that a given  
                indexTotalNumberOfFiles,  
     * Loads all available snapshots in the repository  
            return;
                        @Override
                    break;
        return Optional.of(maxGenShardPath);  
    private static void failStoreIfCorrupted(Store store, Exception e) {
                .collect(Collectors.toSet());
                        checkAborted();  
        );  
        RemoteTranslogTransferTracker remoteTranslogTransferTracker = new RemoteTranslogTransferTracker(shardId, 1000);  
        }  
            }
            throw new SnapshotMissingException(metadata.name(), snapshotId, ex);
                : "indexShardSnapshot should be an instance of BlobStoreIndexShardSnapshot";
     * during a new {@code index-N} write, this does not present a problem. The node will still load the correct {@link RepositoryData} in  
                remoteStoreLockManagerFactory,  
            // reference a generation that has not had all its files fully upload.  
            } else {
        Metadata::fromXContent  
                writeIndexGen(  
            // happens asynchronously. in long term, we have plans to implement remote store GC poller mechanism which
    }
            // We don't need to check if there exists a shallow/full copy snapshot with the same name as we have the check before starting  
     * @param newGen new safe repository generation
        }
    public RateLimiter restoreRateLimiter() {  
        snapshotRemoteStoreIndexShard(
                        + INDEX_SHARD_SNAPSHOTS_FORMAT.blobName(indexGeneration)
                    // Some shallow copy snapshots are surviving. In this case, since no full copy snapshots are present, we use  
            );  
                        + "]";  
            );
                        assert needsWrite || assertFileContentsMatchHash(snapshotFileInfo, store);
                foundIndices.size() - survivingIndexIds.size()
            // BwC logic: Load snapshot version information if any snapshot is missing a version in RepositoryData so that the new  
 * Licensed to Elasticsearch under one or more contributor  
                // If we did not find a set of files that is equal to the current commit we determine the files to upload by comparing files
            + "]";
    }
     */
                repoMetaVersion,
    ) {
            return RepositoryData.snapshotsFromXContent(  
            );  
        final Tuple<Long, BytesReference> cached = (softRef != null) ? softRef.get() : null;
    private List<String> cleanupStaleRootFiles(  
        );
                        ),
                            snapshotId,
                                    newGen = tuple.v2() + 1;  
    public OffsetRangeInputStream maybeRateLimitLowPriorityRemoteUploadTransfers(OffsetRangeInputStream offsetRangeInputStream) {
    }
                        compressor
                snapshotIds,  
            || Objects.equals(metadata.cryptoMetadata(), newRepositoryMetadata.cryptoMetadata()) == false) {
                continue;
        if (!isIndexPresent(clusterService, indexUUID)) {
        }  
                    snapshotIds,
                } catch (Exception t) {  
        for (IndexId indexId : indices) {
    public static void remoteDirectoryCleanupAsync(
        Repository repository,
     *
    private void removeSnapshotsPinnedTimestamp(  
                // Listener for collecting the results of removing the snapshot from each shard's metadata in the current index
            }
            .getEntries()) {
            for (int i = 0; i < fileInfo.numberOfParts(); i++) {  
            return new RepositoryStats(store.extendedStats(), true);  
    }  
            return blobsToDelete;  
        Map<String, BlobContainer> foundIndices,
                    BlobPath blobPath = fileToDelete.v1();
        if (Lucene.isCorruptionException(e)) {
        Setting.Property.NodeScope
                    e  
            idToShardInfoMap
        // 1. Remove the snapshots from the list of existing snapshots
                            allShardsListener.onResponse(null);
    ) {
        BlockingQueue<BlobStoreIndexShardSnapshot.FileInfo> filesToSnapshot,
    }
            int pathType = indexId.getShardPathType();
            final List<BlobStoreIndexShardSnapshot.FileInfo> indexCommitPointFiles;  
                            IOContext.DEFAULT
                container.path(),
     * that contains the current snapshots in the repository.
import org.apache.lucene.util.BytesRef;
    }  
        @Nullable String generation
    }
            snapshotIds,
    public static final Setting<ByteSizeValue> SNAPSHOT_REPOSITORY_DATA_CACHE_THRESHOLD = new Setting<>(
        }
            assert indexShardSnapshot instanceof RemoteStoreShardShallowCopySnapshot
            }
            for (int i = 0; i < shardInfo.getShardCount(); i++) {
            }  
                for (Tuple<BlobPath, String> fileToDelete : filesToDelete) {
            if (previousBest != metadata.generation()) {
            }  
                    groupedListener,
                }
        restoreRateLimiter = getRateLimiter(RESTORE_BYTES_PER_SEC_SETTING, metadata.settings());
                } catch (Exception e) {
     * generation will always contain the same {@link RepositoryData}.
            });  
                // operations must start from the EMPTY_REPO_GEN again
        return shardInfoFromPath.getShardCount() >= shardInfoFromMap.getShardCount() ? shardInfoFromPath : shardInfoFromMap;
        long latest = RepositoryData.EMPTY_REPO_GEN;
    // package private, only use for testing
        if (metadata.name().equals(newRepositoryMetadata.name()) == false  
            }
                new RemoteStoreShardCleanupTask(  
import org.opensearch.snapshots.SnapshotException;  
 * SPDX-License-Identifier: Apache-2.0
                    metadata.name(),  
            () -> remoteUploadRateLimiter,
    @Override
            snapshotStatus.addProcessedFile(fileInfo.length());
        }), indexMetaGenerations.entrySet().stream().flatMap(entry -> {  
    private static List<String> staleRootBlobs(RepositoryData repositoryData, Set<String> rootBlobNames) {
                                "[{}] [{}] failed to read metadata for index",
                    store,
            }
                // It's readonly - so there is not much we can do here to verify it apart from reading the blob store metadata  
            logger.debug(new ParameterizedMessage("updatedIndexIds={}", updatedIndexIds));
     * The result of removing a snapshot from a shard folder in the repository.  
                public void onFailure(Exception e) {
import org.opensearch.cluster.metadata.RepositoriesMetadata;  
                deletionEntries.add(entry.withRepoGen(newGen));  
     *                                      part of a repository cleanup
                        + SNAPSHOT_REPOSITORY_DATA_CACHET_THRESHOLD_SETTING_NAME
            )  
                shardContainer.writeBlobWithMetadata(partName, inputStream, partBytes, false, null, cryptoMetadata);
    }  
                    );  
        }  
                        );
        "cluster.snapshot.shard.path.prefix",
                MediaTypeRegistry.JSON.xContent().createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, input),
                                // a commit point file with the same name, size and checksum was already copied to repository
        Setting.Property.Final
            ? COMPRESSION_TYPE_SETTING.get(metadata.settings())  
     * @param bytesPerSecSetting setting to use to configure rate limiter
                        } catch (Exception e) {  
                // Deletes the shard level data for the underlying index based on the shardInfo that was obtained above.
                                    remoteStoreLockManagerFactory
     * @param indexSnId     The snapshot index id of the index to be cleaned up
    private void writeUpdatedShardMetaDataAndComputeDeletes(
                return new SoftReference<>(new Tuple<>(generation, serialized));
                                                RepositoriesMetadata.TYPE,
import java.util.concurrent.ExecutionException;
            : CompressorRegistry.none();
                    exp
                () -> new ParameterizedMessage(  
    }
                blobs,  
                        }
                        filesToDelete
                    // If the pending generation has changed we are in the midst of a write operation and might pick up the
                        genToLoad,
                changedSnapshots = true;  
            if (entry.repository().equals(repoName) && entry.repositoryStateId() == oldGen) {
                indexId = entry.getKey();
                }
            maybeRateLimit(
                    return existingShardGen;  
    private BlobContainer indexContainer(IndexId indexId) {
     * TODO: Add unreferenced index metadata cleanup  
     * Cleans up stale blobs directly under the repository root as well as all indices paths that aren't referenced by any existing
        assertSnapshotOrGenericThread();
            // If its a read-only repository, listing blobs by prefix may not be supported (e.g. a URL repository),
                        }
        String indexSnId,
            SnapshotShardPaths shardPaths = new SnapshotShardPaths(
        throws InterruptedException {  
    ) {  
        } catch (Exception e) {  
                if (remoteStoreLockManagerFactory != null) {
                ActionListener.wrap(() -> listener.onResponse(updatedRepoData)),
                threadPool.info(ThreadPool.Names.SNAPSHOT_DELETION).getMax(),
        ShardId shardId,
            final BlobStoreIndexShardSnapshots shardSnapshots = INDEX_SHARD_SNAPSHOTS_FORMAT.read(  
            .filter(s -> (s.startsWith(indexId) || s.startsWith(SnapshotShardPaths.FILE_PREFIX + indexId)))  
                            executeOneFileRestore(files, filesListener);
        }
        return "BlobStoreRepository[" + "[" + metadata.name() + "], [" + blobStoreProvider.get() + ']' + ']';
        try {
     *
                    }  
    @Override
                shardContainer,  
        return rootBlobContainer;
import org.opensearch.cluster.metadata.IndexMetadata;
                    state.custom(RepositoryCleanupInProgress.TYPE, RepositoryCleanupInProgress.EMPTY).entries()  
            for (SnapshotFiles point : snapshots) {  
                                    finalShardId,
                    if (executedTask) {  
        if (genToLoad != repositoryStateId) {
                        + "] to ["  
                ),
     * Specific repositories should have specific implementation.
     * not have access to the older repository data. </p>
            final int workers = Math.min(threadPool.info(ThreadPool.Names.SNAPSHOT).getMax(), indexIncrementalFileCount);
                        // by the stale data cleanup in the end.  
            // Start as many workers as fit into the snapshot pool at once at the most  
        } catch (IOException ex) {
        BlockingQueue<BlobStoreIndexShardSnapshot.FileInfo> files,
            threadPool,
        }));  
    ) {  
            RemoteFsTimestampAwareTranslog.cleanupOfDeletedIndex(translogTransferManager, forceClean);
                }  
    @Override
            clusterService.submitStateUpdateTask(source, new ClusterStateUpdateTask(updateTask.priority()) {  
                        throw ex;  
        assert Thread.currentThread().getName().contains('[' + ThreadPool.Names.SNAPSHOT_DELETION + ']')
    /**
        final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);
                protected void doRun() throws Exception {  
            snapshotId,
     */  
     *     <li>Deleting unreferenced root level blobs {@link #cleanupStaleRootFiles}</li>  
            return;  
                }
            // TODO: We shouldn't be blanket catching and suppressing all exceptions here and instead handle them safely upstream.
            )
    public void cloneRemoteStoreIndexShardSnapshot(  
            true  
            listener
        RepositoryData oldRepositoryData,  
                    snapshotId.getUUID(),
                .filter(s -> {
        // Fast path loading repository data directly from cache if we're in fully consistent mode and the cache matches up with
        final StepListener<RepositoryData> repoDataListener = new StepListener<>();
        SnapshotId source,
    }  
        );
                            ActionListener.map(listener, RepositoryCleanupResult::new),  
                indexMetaGenerations.size()
                        for (BlobStoreIndexShardSnapshot.FileInfo fileInfo : filesInfo) {  
                        checkAborted();  
                .stream()  
            remoteUploadLowPriorityRateLimitingTimeInNanos,
            int oldShardCount = existingRepositoryData.shardGenerations().getGens(indexId).size();
    @Override
                private boolean executedTask = false;
                            Metadata.builder(currentState.getMetadata())  
        IndexShardSnapshotStatus snapshotStatus,
            return GLOBAL_METADATA_FORMAT.read(blobContainer(), snapshotId.getUUID(), namedXContentRegistry);
        }
import static org.opensearch.snapshots.SnapshotShardPaths.getIndexId;
                // We're only using #latestKnownRepoGen as a hint in this mode and listing repo contents as a secondary way of trying
                );
            if (userDefinedLimitBytes < CACHE_MIN_THRESHOLD) {  
                    }
     */
        Supplier<RateLimiter> rateLimiterSupplier,
            );
                        + "] for snapshot ["  
        BlobStoreIndexShardSnapshots snapshots,  
            ActionListener.map(onAllShardsCompleted, res -> res.stream().flatMap(Collection::stream).collect(Collectors.toList())),
            }
                        foundIndices,  
     *
                        "Failed to unpin timestamp {} for snapshot {} with exception {}",
import org.opensearch.threadpool.ThreadPool;
        if (supportURLRepo) {  
                "failed to read shard snapshot file for [" + shardContainer.path() + ']',
                    } else {
                    } else {
                deleteResult = deleteResult.add(cleanUpStaleSnapshotShardPathsFile(matchingShardPaths, snapshotShardPaths));  
                                deleteFromShardSnapshotMeta(
                }  
    protected void assertSnapshotOrGenericThread() {  
    @Override
            String name = String.join(  
                Tuple<Long, BytesReference> known = (knownRef != null) ? knownRef.get() : null;
                if (genToLoad != latestKnownRepoGen.get() && genToLoad != lastFailedGeneration) {
                            }
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,  
        long startTime = System.nanoTime();
                )  
import org.opensearch.index.snapshots.blobstore.SnapshotFiles;
                );  
     * Maintains single lazy instance of {@link BlobStore}.  
    @Override
     */
                    ),  
                        deleteBlob = true;  
    private static final Logger staticLogger = LogManager.getLogger(BlobStoreRepository.class);
                        logger.debug("Successfully synced pinned timestamp state");  
                .values()
        Map<String, Long> indexFilesToFileLengthMap,
            listener.onFailure(
     * This method cleans up the redundant snapshot shard paths file for index ids where the number of shards has increased  
                offsetRangeInputStream,
     *
                        final BlockingQueue<BlobStoreIndexShardSnapshot.FileInfo> files = new LinkedBlockingQueue<>(filesToRecover);
        assert indexGeneration >= 0 : "Shard generation must not be negative but saw [" + indexGeneration + "]";  
    private void cleanupUnlinkedRootAndIndicesBlobs(
                        logger.trace("[{}] [{}] Loading store metadata using index commit [{}]", shardId, snapshotId, snapshotIndexCommit);  
        }  
            }
    private static final String SNAPSHOT_INDEX_NAME_FORMAT = SNAPSHOT_INDEX_PREFIX + "%s";
        ActionListener<String> listener  
                    );
        prefixModeVerification = PREFIX_MODE_VERIFICATION_SETTING.get(metadata.settings());  
                        try {  
    private final RemoteStoreSettings remoteStoreSettings;
                        )
        Version repositoryMetaVersion,
            try {  
                            + blobStore()  
        if (chunkSize != null && chunkSize.getBytes() <= 0) {  
    }
    }  
        SnapshotInfo snapshotInfo,
                remoteSegmentStoreDirectoryFactory,  
    public static final String MAX_RESTORE_BYTES_PER_SEC = "max_restore_bytes_per_sec";
    }
            // will take care of such stale data.
 */  
            }
        // Iterate over the shards and delete each shard's data  
        updatedDeletionsInProgress = changedDeletions ? SnapshotDeletionsInProgress.of(deletionEntries) : null;  
import org.opensearch.monitor.jvm.JvmInfo;
                }  
    protected void releaseRemoteStoreLockAndCleanup(
            throw new RepositoryException(metadata.name(), "could not read repository data from index blob", ioe);  
                        e
        List<String> blobsToDelete  
            new ActionListener<Void>() {  
    ) {
                    remoteStoreLockManagerFactory,
            if (shardContainer.blobExists(INDEX_SHARD_SNAPSHOT_FORMAT.blobName(snapshotId.getUUID()))) {
                    );
        return null;
            final List<BlobStoreIndexShardSnapshot.FileInfo> filesFromSegmentInfos = Optional.ofNullable(shardStateIdentifier).map(id -> {  
    private static final int MAX_SAFE_ARRAY_SIZE = Integer.MAX_VALUE - 8;
                            rootBlobs,
                }  
                + "repository by a process other than this cluster or an issue with the repository's underlying storage. "  
import org.opensearch.core.compress.Compressor;
                cleanRemoteStoreDirectoryIfNeeded(snapshotIds, indexId, repositoryData, remoteSegmentStoreDirectoryFactory, false);
        this.snapshotShardPathPrefix = SNAPSHOT_SHARD_PATH_PREFIX_SETTING.get(clusterService.getSettings());  
import java.util.Locale;  
    }
        private final int shardId;
        MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC,
     * @param remoteSegmentStoreDirectoryFactory RemoteSegmentStoreDirectoryFactory to be used for cleaning up remote  
            // write the index metadata for each index in the snapshot
            } catch (IOException e) {
            });
                public void onFailure(Exception e) {
        this.clusterService = clusterService;  
        ByteSizeValue.ZERO,
                Optional<String> highestGenShardPaths = findHighestGenerationShardPaths(matchingShardPaths);  
    }  
            .repository(metadata.name());
    }  
    }
        final List<SnapshotsInProgress.Entry> snapshotEntries = new ArrayList<>();
            }
                }
                remStoreBasedShardMetadata.getRemoteStorePathStrategy()
                    new RemoteStoreShardShallowCopySnapshot(  
        1000, // the default maximum batch size of stale snapshot shard blobs deletion
     * @param oldRepoData   The old repository metadata used to fetch the index metadata.
        Map<String, ShardInfo> idToShardInfoMap
                );
        filterRepositoryDataStep.whenComplete(filteredRepositoryData -> {  
        return pathType.path(shardPathInput, pathHashAlgorithm);
            for (SnapshotFiles existingSnapshot : existingSnapshots) {
                executeOneStaleIndexDelete(
                logger.warn(new ParameterizedMessage("[{}] Exception during single stale index delete", metadata.name()), e);
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeInputStream;  
        (s) -> {
                }  
        container.deleteBlobsIgnoringIfNotExists(blobs);
        Version repositoryMetaVersion,
                    } catch (IOException e) {  
            oldRepoData,  
    }  
        return null;
                );
    public IndexMetadata getSnapshotIndexMetaData(RepositoryData repositoryData, SnapshotId snapshotId, IndexId index) throws IOException {
    );
        Collection<SnapshotId> snapshotIds,  
                throw new SnapshotMissingException(metadata.name(), snapshotId.getName());
                    );  
     * @return tuple of BlobStoreIndexShardSnapshots and the last snapshot index generation  
                        RemoteStorePathStrategy remoteStorePathStrategy = RemoteStoreUtils.determineRemoteStorePathStrategy(
    );  
    /**
        }, listener::onFailure);  
                                remoteSegmentStoreDirectoryFactory,  
                // 2) Snapshot shard paths file upload failed  
}
        try {
        readRepositoryMetadata(repositoryMetadata);  
                foundIndices,
            // related issue: https://github.com/opensearch-project/OpenSearch/issues/8469  
     * Configures RateLimiter based on repository and global settings  
                "Repository [{}] successfully wrote shard paths for index [{}] in snapshot [{}]",
        "prefix_mode_verification",
    public Metadata getSnapshotGlobalMetadata(final SnapshotId snapshotId) {
                namedXContentRegistry  
                    ensureNotClosing(store);
    private volatile boolean cacheRepositoryData;
            listener.onFailure(corruptedStateException(null));
            listener.onFailure(e);
     *     <li>The value of {@link RepositoryMetadata#generation()} for this repository is {@link RepositoryData#UNKNOWN_REPO_GEN}
        );
     */
                updatedRepoData,  
                indexContainer(index),
    }
                        );  
    /**
    }  
        return deleteResult;
                        e  
            }
                    logger.warn("cannot close blob store", t);
        uncleanStart = metadata.pendingGeneration() > RepositoryData.EMPTY_REPO_GEN  
                                shard,
        return rootBlobContainer.get();
                                    .build()
            shardContainer,  
                latestIndexBlobId();
     * This cleanup flow is executed only for v2 snapshots. For v1 snapshots,
import org.opensearch.snapshots.SnapshotShardPaths.ShardInfo;
            final int workers = Math.min(  
                    repositoryMetaVersion,  
    }
                                @Override
import org.opensearch.snapshots.SnapshotMissingException;  
                    // even if a repository has been manually cleared of all contents we will never reuse the same repository generation.  
        Supplier<RateLimiter> rateLimiterSupplier,
import org.apache.lucene.index.IndexCommit;
    public RemoteStoreShardShallowCopySnapshot getRemoteStoreShallowCopyShardMetadata(
            // asynchronously using REMOTE_PURGE thread pool. if it fails, it could leave some stale files in remote
        }
            shallowSnapshotUUID,
        }
        maxShardBlobDeleteBatch = MAX_SNAPSHOT_SHARD_BLOB_DELETE_BATCH_SIZE.get(metadata.settings());
                BlobStoreTransferContext.REMOTE_DOWNLOAD
                } else if (blob.startsWith(METADATA_PREFIX)) {  
    }
                            }  
    public static final Setting<Boolean> SYSTEM_REPOSITORY_SETTING = Setting.boolSetting(
                staleFilesToDeleteInBatch.size()
                    idToShardInfoMap
            // by some other operation (such as the get snapshots operation). In some file systems, it is
import org.opensearch.indices.recovery.RecoverySettings;
    @Override
     * @param repositoryData                RepositoryData found the in the repository before executing this delete
                        ) == false)
        private final String newGeneration;
            );
import org.opensearch.common.blobstore.BlobMetadata;
    @Override
            Collection<List<Tuple<BlobPath, String>>> subList = filesToDelete.stream()  
                        "[{}] index {} is no longer part of any snapshots in the repository, "
                } else if (snapshotName.equals(source.getName())) {  
            } catch (IOException inner) {
     * @param shardBlobs                    Map of shard IDs to their corresponding BlobContainers  
                        // ignoring it and letting the cleanup deal with it.
    private void snapshotFile(
    ) {  
                metadata.name(),
                System.nanoTime() - startTime
                        );
        SnapshotId source,
    }  
            null,
            final String indexBlob = INDEX_FILE_PREFIX + Long.toString(newGen);
                }
                        public void onFailure(Exception ex) {
     * {@link #bestEffortConsistency}. When using {@link #bestEffortConsistency} the repository is using listing to find the latest
    public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotId snapshotId, IndexId indexId, ShardId shardId) {
     * @param indexId            The ID of the index to match
    }  
    }
                Long.toString(latest),
                }
     * pending and safe generation are set to the same value marking the end of the update of the repository data.  
    );
            if (generation == null) {  
        }
        BlobContainer rootBlobContainer = this.rootBlobContainer.get();  
 *
                    throw new IndexShardSnapshotFailedException(shardId, "Failed to write commit point", e);
                        updateTask.clusterStateProcessed(source, oldState, newState);
        // Blob names in the shard directory that have become unreferenced in the new shard generation
    }
                        remoteStorePinnedTimestampService.forceSyncPinnedTimestamps();
/*
     * @param remoteSegmentStoreDirectoryFactory RemoteSegmentStoreDirectoryFactory to be used for cleaning up remote store segment files
                logger.warn(
                }
        REMOTE_UPLOAD("remote_upload"),
                        );  
        // Retrieve the ShardInfo object from the idToShardInfoMap using the indexId
            } else {
                    indexUUID,
        assert (indexSnId != null);
                () -> remoteUploadRateLimiter,  
                            cacheWarningThreshold  
        }));
                listener.onResponse(indexGeneration);
    // Inspects all cluster state elements that contain a hint about what the current repository generation is and updates
        IndexMetadata prevIndexMetadata,
    // Tracks the latest known repository generation in a best-effort way to detect inconsistent listing of root level index-N blobs
                                    blobStoreIndexShardSnapshots = buildBlobStoreIndexShardSnapshots(
        try {  
            }
                    } else {
     *
            throw new RepositoryVerificationException(
            executor.execute(ActionRunnable.wrap(listener, l -> {
                FileLockInfo.getLockInfoBuilder().withAcquirerId(target.getUUID()).build()
     * @param originalException   exception that lead to the failing to load the {@code index-N} blob  
        RepositoryData updatedRepositoryData,  
                String.valueOf(pathHashAlgorithm)  
        final IndexId index = shardId.index();
                shardContainers.put(String.valueOf(i), shardContainer(shardInfo.getIndexId(), i));  
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / maxShardBlobDeleteBatch))
            try {
            );
                    final boolean needsWrite = md.hashEqualsContents() == false;  
        }  
            deletedSnapshots,
                BlobStoreTransferContext.REMOTE_UPLOAD
                // delete would also log a confusing INFO message about "stale blobs".  
                    updatedSnapshots = new BlobStoreIndexShardSnapshots(newSnapshotsList);  
     * @param repositoryStateId             Expected repository state id  
                                () -> updatedVersionMap.put(snapshotId, getSnapshotInfo(snapshotId).version())
            throw new SnapshotException(  
                        remoteStoreLockManagerFactory
    }  
            }).orElse(null);
                }
            onFailure.accept(new RepositoryException(metadata.name(), "the repository has been changed, try again"));  
     * @param listener                      Listener to complete when done  
        }
            SnapshotId snapshotId = snapshotInfo.snapshotId();  
                    oldRepoData,
import org.opensearch.index.translog.RemoteFsTimestampAwareTranslog;  
                    + generation
                listener.onResponse(newRepositoryData);  
import org.opensearch.core.common.Strings;  
                maxGen = shardCount;
    public static final Setting<ByteSizeValue> MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(
                        String indexId = parts[partLength - 2];  
            remoteStorePathStrategy,
        metadata = getRepoMetadata(state);  
        @Nullable String shardGeneration,
                    try (InputStream stream = bytes.streamInput()) {  
                executor.execute(ActionRunnable.supply(allShardCountsListener, () -> {
     */
                            metadata.name(),
     * Runs cleanup actions on the repository. Increments the repository state id by one before executing any modifications on the
                remoteStoreRepository,
    public static final ChecksumBlobStoreFormat<BlobStoreIndexShardSnapshots> INDEX_SHARD_SNAPSHOTS_FORMAT = new ChecksumBlobStoreFormat<>(
    private void readRepositoryMetadata(RepositoryMetadata repositoryMetadata) {
    protected BlobContainer snapshotShardPathBlobContainer() {
    public static final String METADATA_NAME_FORMAT = METADATA_PREFIX + "%s.dat";  
    private final CounterMetric restoreRateLimitingTimeInNanos = new CounterMetric();
        final ShardGenerations shardGenerations,  
        IndexId indexId,
    public void getRepositoryData(ActionListener<RepositoryData> listener) {
        return blobs.stream()
                    + "]"
        String shardStateIdentifier,  
    ) {
                                    + newGen  
        });
            DeleteResult deleteResult = DeleteResult.ZERO;  
    /**
                    indexMetaIdentifiers  
                }
        final int shardNum = shardId.shardId();  
            });
    private static final Logger logger = LogManager.getLogger(BlobStoreRepository.class);  
                        .build();
                } catch (NoSuchFileException e) {  
            }  
        "io_buffer_size",
            );  
                exp
    }
                    logger.debug(
                    final long nextPendingGen = metadata.pendingGeneration() + 1;  
            }  
                metadata.name(),
            }
        final SnapshotDeletionsInProgress updatedDeletionsInProgress;  
     */
                target.getUUID(),
    protected BlobContainer blobContainer() {
                // The snapshot shards path would be uploaded for new index ids or index ids where the shard gen count (a.k.a
     * latest repository generation but must inspect its physical contents as well via {@link #latestIndexBlobId()}.
                "[{}] Deletion {} from [{}] took {}ns",
     * @param listener            listener to invoke once done
import java.util.Arrays;  
                @Override
            for (SnapshotId snapshotId : snapshotIds) {
        ActionListener<RepositoryData> listener
                BytesArray bytes = new BytesArray(testBytes);
                    filesListener,
            indexGeneration = UUIDs.randomBase64UUID();
     * maintains single lazy instance of {@link BlobContainer}  
                    // If we run into the empty repo generation for the expected gen, the repo is assumed to have been cleared of  
            try {  
            );  
                // Nothing to clean up we return
        MAX_REMOTE_UPLOAD_BYTES_PER_SEC,  
                        final RepositoryMetadata meta = getRepoMetadata(currentState);
        }  
                                )
                changedDeletions = true;
                indexTotalFileSize = indexFilesToFileLengthMap.values().stream().mapToLong(Long::longValue).sum();
                        lastSnapshotStatus.getStartTime(),
        deleteSnapshotsInternal(  
                        fileNames,  
        return null;
                rateLimiter.getMBPerSec()  
        Store store,  
import org.opensearch.common.unit.TimeValue;  
    private volatile boolean bestEffortConsistency;  
    }  
                    assert store.refCount() > 0;  
        long jvmHeapSize = JvmInfo.jvmInfo().getMem().getHeapMax().getBytes();
                Set<String> updatedIndexIds = writeNewIndexShardPaths(existingRepositoryData, updatedRepositoryData, snapshotId);
                    blobsToDelete  
import org.opensearch.action.StepListener;
                    return INDEX_SHARD_SNAPSHOT_FORMAT.read(shardContainer, snapshotId.getUUID(), namedXContentRegistry);  
     * repository. If remoteStoreLockManagerFactory is not null, remote store lock files are released when deleting the respective  
                    allMetaListener,  
                            )
                executor.execute(ActionRunnable.run(allMetaListener, () -> {
            && metadata.generation() != metadata.pendingGeneration();
    private void writeAtomic(BlobContainer container, final String blobName, final BytesReference bytesRef, boolean failIfAlreadyExists)  
     * <p> This method cleans up segments in the remote store directory for deleted indices.
        );  
                    try (
    private static ActionListener<Void> fileQueueListener(
            SnapshotsService.getPinningEntity(repository, snapshotId.getUUID()),
     * @param generation shard generation
                                restoreFile(fileToRecover, store);  
                            }  
     * @param listener                      listener on deletion of the stale indices
            try {  
                        snapshotUUID.get(),
        // Keep track of the most recent generation we failed to load so we can break out of the loop if we fail to load the same
                    remoteSegmentStoreDirectoryFactory,  
            }  
        return CryptoMetadata.fromIndexSettings(indexSettings);
                logger.info("No snapshots found for indexSnId: {}", indexSnId);
                            filesToDelete  
                            store.deleteQuiet(fileInfo.physicalName());  
                            "[{}] Failed to delete following blobs during cleanupOldFiles : {}",
    ) {  
    private final CounterMetric remoteDownloadRateLimitingTimeInNanos = new CounterMetric();
     * @param idToShardInfoMap     A map containing index IDs and their corresponding ShardInfo objects.  
    private BlobContainer testContainer(String seed) {  
                    }  
                // blobs associated with the just deleted snapshots as they are expected to exist and not stale. Otherwise every snapshot
import org.apache.lucene.index.IndexFormatTooOldException;
                logger.warn("[{}] Unknown blob in the repository: {}", metadata.name(), blobName);  
        }  
    private Map<String, BlobMetadata> getSnapshotShardPaths() {
        IndexId indexId,  
                if (Objects.nonNull(shardPathsBlobName)) {
        SNAPSHOT_INDEX_NAME_FORMAT,
            }
    // #latestKnownRepoGen if a newer than currently known generation is found  
    /**
        final RecoverySettings recoverySettings  
                ) {
                for (BlobStoreIndexShardSnapshot.FileInfo fileInfo : filesFromSegmentInfos) {
            }  
            // We can create map of indexId to ShardInfo based on the old repository data. This is later used in cleanup
                executeStaleShardDelete(staleFilesToDeleteInBatch, remoteStoreLockManagerFactory, groupedListener);
     */
                    blobs = shardContainer.listBlobsByPrefix(INDEX_FILE_PREFIX).keySet();
                    sourceFiles = existingSnapshot;
import org.opensearch.action.support.GroupedActionListener;  
                    indexMetas.put(index, identifiers);
     * Set to Integer.MAX_VALUE - 8 to prevent OutOfMemoryError due to array header requirements, following the limit used in certain JDK versions.  
import java.io.IOException;
        MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC,
            int newShardCount = updatedRepositoryData.shardGenerations().getGens(indexId).size();
    ) {
        bufferSize = Math.toIntExact(BUFFER_SIZE_SETTING.get(metadata.settings()).getBytes());  
                shardContainer,
                    // Regardless of whether or not the safe generation has been reset, the pending generation always increments so that
     * @param deleteResults     The results of removing snapshots from shard-level metadata
        final Set<String> survivingIndexIds = newRepoData.getIndices().values().stream().map(IndexId::getId).collect(Collectors.toSet());  
        // Initialize the DeleteResult with zero values  
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                        logger.debug("[{}] [{}] Aborted on the file [{}], exiting", shardId, snapshotId, fileName);  
                    return false;
     */
    // Visible for testing
        Set<String> updatedIndexIds = new HashSet<>();
            }, listener::onFailure);
                                }  
                        String[] parts = blobPath.toArray();
     */
            new SnapshotException(metadata.name(), snapshotId, "failed to update snapshot in repository", e)
        }
    private static boolean isIndexPresent(ClusterService clusterService, String indexUUID) {
            Map<String, BlobContainer> shardContainers = new HashMap<>(shardInfo.getShardCount());
            try {  
     *
                    "Can't create clone of ["
            throw new SnapshotException(metadata.name(), snapshotId, "failed to get snapshots", ex);  
import java.util.concurrent.atomic.AtomicLong;  
                                "Successfully loaded all snapshot's version information for {} from snapshot metadata",
                remoteStoreRepoForIndex,  
     * @param snapshotIds       The IDs of the snapshots being deleted  
                            lastSnapshotStatus.getIncrementalFileCount(),
                deleteResult = deleteResult.add(result);
                            workers,
            } else {
                            indexSnId  
                } catch (Exception e) {
    public void restoreShard(
        final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT_DELETION);
                    foundUUID = blob.substring(SNAPSHOT_PREFIX.length(), blob.length() - ".dat".length());
        getRepositoryData(ActionListener.wrap(repositoryData -> {
     * recreated after the problem that lead to it being marked as corrupted has been fixed.  
 * under the License.  
        ByteSizeValue.parseBytesSizeValue("8kb", "buffer_size"),
            deleteFromContainer(snapshotShardPathBlobContainer(), staleShardPaths);
    }
    public static final long CACHE_DEFAULT_THRESHOLD = calculateDefaultSnapshotRepositoryDataCacheThreshold();  
    ) {  
            } else if (filesFromSegmentInfos == null) {  
                + "and continue using it please remove the repository from the cluster and add it again to make "
                PathType.fromCode(pathType),
                            );
            return;
                asyncCleanupUnlinkedShardLevelBlobs(
    long latestIndexBlobId() throws IOException {
     */  
                        listener::onFailure  
            executor.execute(ActionRunnable.supply(groupedListener, () -> {  
            // Note: this is a temporary solution where snapshot deletion triggers remote store side cleanup if  
            String remoteStoreRepository = remStoreBasedShardMetadata.getRemoteStoreRepository();
                    || (remoteStoreLockManagerFactory != null  
     * index ID, and the mapping of index IDs to ShardInfo objects.  
            clusterService.submitStateUpdateTask(
        assertSnapshotOrGenericThread();  
                            );
            repositoryStateId,
                } catch (IOException ioe) {
            logShardPathsOperationWarning(indexId, snapshotId, e);
        }  
                // number_of_shards) has increased.  
            snapshotIds,  
                ActionListener.wrap(r -> { listener.onResponse(null); }, listener::onFailure),  
                        : "Expected non-empty generation [" + expectedGen + "] does not match generation tracked in [" + meta + "]";
                return () -> IndexShardSnapshotStatus.newDone(0L, 0L, 0, 0, 0, 0, "1");
                        }
    /**  
                                + "safe generation [{}] and pending generation [{}]",
        logger.debug("Ensure generation [{}] that is the basis for this write exists in [{}]", safeGeneration, metadata.name());
        ActionListener<RepositoryData> listener
                                prevIndexMetadata    // ← carries DFA flag through factory → DataFormatAwareRemoteDirectory
            return extendedStoreStats;  
                newRepositoryData.snapshotsToXContent(XContentFactory.jsonBuilder(), version, minNodeVersion)
                    final long safeGeneration = expectedGen == RepositoryData.EMPTY_REPO_GEN
        IndexShardSnapshotStatus snapshotStatus,  
        } catch (Exception e) {
    }  
                            filesToSnapshot.add(snapshotFileInfo);  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
                    Function.identity(),
                    // Set empty repository data to not waste heap for an outdated cached value  
        BlockingQueue<Map.Entry<String, BlobContainer>> staleIndicesToDelete,
            for (DeleteResult result : deleteResults) {  
     */  
                indexTotalFileSize
    private List<Tuple<BlobPath, String>> resolveFilesToDelete(
        return compressor != CompressorRegistry.none();  
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            } else {
            final long genToLoad;  
            return;  
    /**
    @Override
        final long generation = latestGeneration(rootBlobs.keySet());
                                logger.warn(() -> new ParameterizedMessage("Failed to clean up old index blobs {}", oldIndexN), e);
     * Returns base path of the repository
        GroupedActionListener<DeleteResult> listener,  
        final long repositoryStateId,
                        threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(ActionRunnable.supply(listener, () -> {  
                + "The repository has been disabled to prevent corrupting its contents. To re-enable it "
            }));
                );  
        return TESTS_FILE + seed;
                throw new IndexShardSnapshotFailedException(  
                                indexId,  
            executeStaleShardDelete(staleFilesToDeleteInBatch, remoteStoreLockManagerFactory, listener);
    private volatile RateLimiter remoteUploadLowPriorityRateLimiter;  
                        // restore the files from the snapshot to the Lucene store
            final RepositoryData newRepositoryData = filteredRepositoryData.withGenId(newGen);
            if (provider != null) {
                // the index- blob wasn't of the format index-N where N is a number,
            logger.debug(
            cleanupStaleIndices(
                            logger.warn("Failure when trying to load missing version information from snapshot metadata", e);  
        "shard_path_type",
    public static final String MAX_SNAPSHOT_BYTES_PER_SEC = "max_snapshot_bytes_per_sec";
                        if (success == false) {
                    filesToSnapshot,  
                        + previousBest
     * @param remoteStoreLockManagerFactory Factory for creating remote store lock managers
            final BlobContainer shardContainer = shardContainer(index, shardNum);
                        + CACHE_MIN_THRESHOLD
                    if (id.equals(snapshotFileSet.shardStateIdentifier())) {
            BlobStoreTransferContext.REMOTE_DOWNLOAD
                    ActionListener.wrap(newRepoData -> {  
            .fixedPrefix(snapshotShardPathPrefix)
        if (isReadOnly()) {
    @Override
            // TODO: We shouldn't be blanket catching and suppressing all exceptions here and instead handle them safely upstream.
        // Shard id that the snapshot was removed from
     * Writing a new index generation is a three step process.
                            logger.error(
            if (store.indexSettings().isRemoteSnapshot()) {  
        if (isSystemRepository == false) {
                    () -> new ParameterizedMessage(  
        }
import org.opensearch.common.blobstore.BlobPath;
                    staleIndicesToDelete.put(indexEntry);
                // TODO: Include the current generation here once we remove keeping index-(N-1) around from #writeIndexGen
    /**
                // If we fail to load the generation we tracked in latestKnownRepoGen we reset it.
                        + "], actual current generation ["  
import org.opensearch.common.blobstore.transfer.stream.RateLimitingOffsetRangeInputStream;
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
        } else if (storeStats == null) {
            }  
                            );
        BlobContainer blobContainer = this.blobContainer.get();
                    "concurrent modification of the index-N file, expected current generation ["
     * @param serverSideEncryptionEnabled ServerSideEncryptionEnabled Value.
            );
            repositoryStateId,
                try {  
            if (blobName.startsWith(INDEX_FILE_PREFIX) == false) {  
                        + target
                        executeConsistentStateUpdate(createUpdateTask, source, onFailure);  
                remStoreBasedShardMetadata.asClone(target.getName(), startTime, threadPool.absoluteTimeInMillis() - startTime),
    }
        assert remoteTranslogRepository instanceof BlobStoreRepository;
                        + "]";
                try (Releasable ignored = incrementStoreRef(store, snapshotStatus, shardId)) {  
            failStoreIfCorrupted(store, t);
            remoteSegmentStoreDirectoryFactory,
     * on account of new indexes by same index name being snapshotted that exists already in the repository's snapshots.
            if (logger.isInfoEnabled()) {  
    /**  
                    shardId,
                .collect(Collectors.toList());
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService,  
        assert repositoryStateId > RepositoryData.UNKNOWN_REPO_GEN : "Must finalize based on a valid repository generation but received ["  
                    metadata.name(),  
    // Visible for testing  
            // while in this method will mean that no snap-${uuid}.dat blob is ever written for this snapshot. This is safe because
    private boolean isSettingEqual(Settings s1, Settings s2, String key) {
 *
        return snapshotShardPathBlobContainer;
                }  
                .map(id -> oldRepositoryData.indexMetaDataGenerations().indexMetaBlobId(id, indexId))  
        } else {  
    private final String snapshotShardPathPrefix;  
                latestIndexBlobId();
import java.util.concurrent.BlockingQueue;
        return remoteUploadLowPriorityRateLimitingTimeInNanos.count();
                    indexTotalNumberOfFiles++;
        long repositoryStateId,
                deleteResult = deleteResult.add(deleteContainer(indexEntry.getValue())); // Deleting the index folder
        BlobContainer snapshotShardPathBlobContainer = this.snapshotShardPathBlobContainer.get();
            logger.debug("Repository [{}] updating index.latest with generation [{}]", metadata.name(), newGen);
        PathHashAlgorithm pathHashAlgorithm = pathType != PathType.FIXED ? FNV_1A_COMPOSITE_1 : null;
    }
        Setting.Property.NodeScope  
     * to {@link #latestIndexBlobId()} to validate the value of {@link RepositoryMetadata#generation()}.
                        return snapshotFileSet.indexFiles();  
                    Collectors.toMap(
        writeShardMetaDataAndComputeDeletesStep.whenComplete(deleteResults -> {
    @Override
     *     <li>Deleting stale indices {@link #cleanupStaleIndices}</li>
     */  
        final List<IndexId> indices = oldRepositoryData.indicesToUpdateAfterRemovingSnapshot(snapshotIds);
        final Metadata clusterMetadata,
                    }
        );
                        } catch (IOException e) {  
                threadPool,  
        Setting.Property.Deprecated
        Executor executor,
            // RepositoryData contains a version for every snapshot
                    markRepoCorrupted(
    /**  
            onAllShardsCompleted.onResponse(Collections.emptyList());
     * @param rootBlobs                     All blobs found at the root of the repository before executing any writes to the repository during this  
                                    RepositoriesMetadata.TYPE,
     * @return rate limiter or null of no throttling is needed
        return maybeRateLimitRemoteTransfers(  
            return newGen;
        } catch (Exception e) {
        assert isReadOnly() == false; // can not write to a read only repository
        }
        if (indexMetadata == null) {
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
        }  
        Map<SnapshotId, Long> snapshotsWithPinnedTimestamp,
    public BlobStore blobStore(boolean serverSideEncryptionEnabled) {
                    throw new SnapshotMissingException(metadata.name(), snapshotId.getName());
        final ShardGenerations shardGenerations,
            BlobStoreTransferContext.REMOTE_DOWNLOAD
    );
        BlockingQueue<List<Tuple<BlobPath, String>>> staleFilesToDeleteInBatch,  
                if (blobContainer == null) {  
                    releaseRemoteStoreLockAndCleanup(  
                    snapshotShardPaths,  
            );  
     * Write {@code index.latest} blob to support using this repository as the basis of a url repository.
            RemoteStoreLockManager remoteStoreMetadataLockManger = remoteStoreLockManagerFactory.newLockManager(  
                    this.blobStoreProvider.set(provider);
    /**
                    loaded = repositoryDataFromCachedEntry(cached);  
            final BlobStoreIndexShardSnapshot sourceMeta = (BlobStoreIndexShardSnapshot) indexShardSnapshot;
            if (isReadOnly()) {
                final int len = serialized.length();
                            // Deleting one older than the current expectedGen is done for BwC reasons as older versions used to keep  
                "Determined repository's generation from its contents to ["  
            return;  
     * Public for testing.
        }
                pinnedTimestampListener.onResponse(updatedRepoData);  
            for (Map.Entry<IndexId, List<SnapshotId>> entry : oldRepoData.getIndexSnapshots().entrySet()) {  
     * @return true if compression is needed  
            return entry.getValue().stream().map(id -> Tuple.tuple(indexPath, INDEX_METADATA_FORMAT.blobName(id)));
            true, // true only for shallow snapshot v2
import org.opensearch.cluster.metadata.Metadata;
                }
                return;
        } catch (UnsupportedOperationException e) {
        }, onFailure));
    private CryptoMetadata resolveCryptoMetadata(IndexMetadata indexMetadata) {  
    public void cleanup(
                                + " repository behavior going forward.",
                            logger.debug("[{}] [{}] Aborted on the file [{}], exiting", shardId, snapshotId, fileInfo.physicalName());  
                            + "] cannot be accessed on the node ["
    }  
    protected final boolean isCompress() {
                        );
        return paths;
import org.opensearch.snapshots.SnapshotsService;  
            );  
        }
                assert false : new AssertionError("Impossible, no IO happens here", e);
        SnapshotId snapshotId,
            if (bestGenerationFromCS == RepositoryData.EMPTY_REPO_GEN) {
            throw new SnapshotMissingException(metadata.name(), snapshotId, ex);  
        return remoteUploadRateLimiter;  
            // Using survivingSnapshots instead of newSnapshotsList as shallow snapshots can be present which won't be part of
    private void doGetRepositoryData(ActionListener<RepositoryData> listener) {  
     */
                    cacheRepositoryData(
            || metadata.generation() == RepositoryData.UNKNOWN_REPO_GEN
                ActionRunnable.run(
                "Rate limited blob store transfer, context [{}], for duration [{} ms] for configured rate [{} MBps]",  
                afterCleanupsListener,
            // the new settings are all contained in RELOADABLE_SETTINGS
                    }  
                }
                remoteDirectoryFactory,
                        indexCommitPointFiles.add(snapshotFileInfo);
     */  
        SnapshotId snapshotId,
        }  
        for (SnapshotFiles point : snapshots) {
    }  
            for (String blob : shardBlob.getValue().listBlobs().keySet()) {  
            timestampToUnpin,
        Setting.Property.NodeScope  
                        + shardId
    ) throws IOException {  
        false,
            BlobStoreTransferContext.REMOTE_UPLOAD
        long commitGeneration,
import org.opensearch.common.blobstore.BlobContainer;  
                        + "]",
    public static final Setting<Boolean> COMPRESS_SETTING = Setting.boolSetting("compress", false, Setting.Property.NodeScope);  
                            snapshotFiles.indexFiles().size()  
     * @param safeGeneration generation to verify existence for  
     * @param staleIndicesToDelete          Queue of stale indices to delete
    @Override  
                return readSnapshotIndexLatestBlob();
                }
            );
            // index is already deleted. this is the best effort at the moment since shard cleanup will still happen
    public static final String INDEX_LATEST_BLOB = "index.latest";  
            final BytesReference serializedRepoData = BytesReference.bytes(
                );
    /**  
            for (Map.Entry<String, BlobContainer> indexEntry : foundIndices.entrySet()) {
        MAX_RESTORE_BYTES_PER_SEC,
                    || previousBest < metadata.generation() : "Illegal move from repository generation ["
            final StepListener<Collection<Void>> allFilesUploadedListener = new StepListener<>();  
            repositoryStateId,
import org.opensearch.repositories.RepositoryOperation;  
            try {
            final CryptoMetadata cryptoMetadata = resolveCryptoMetadata(indexMetadata);  
        assert Objects.nonNull(testBlobPath);
            .collect(Collectors.toList());
            (l, e) -> l.onFailure(new IndexShardRestoreFailedException(shardId, "failed to restore snapshot [" + snapshotId + "]", e))
                writeIndexGen(  
        boolean useUUIDs,
            }
                public void onFailure(String source, Exception e) {
    private void cleanupStaleBlobs(  
        }  
     * @param listener                      Listener for grouped delete actions  
    public static final long CACHE_MIN_THRESHOLD = ByteSizeUnit.KB.toBytes(500);
    private DeleteResult deleteContainer(BlobContainer container) throws IOException {
                            + "that permissions on the store don't allow reading files written by the cluster-manager node",
                            final BytesRef hash = fileInfo.metadata().hash();  
        });  
                new ShardId(Index.UNKNOWN_INDEX_NAME, indexUUID, Integer.parseInt(shardId)),
        final GroupedActionListener<DeleteResult> groupedListener = new GroupedActionListener<>(ActionListener.wrap(deleteResults -> {
                    return updateTask.timeout();  
    public boolean isSeverSideEncryptionEnabled() {
                        len,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assert fileInfo.metadata().hash().bytesEquals(new BytesRef(tmp));  
                // to find a higher generation  
        final String repoName = metadata.name();
                return;  
            throw t;  
        try {
                );
                    snapshotIdPinnedTimestampMap,  
    public static final String METADATA_PREFIX = "meta-";
                listener.onResponse(new RepositoryCleanupResult(DeleteResult.ZERO));  
        }
        IndexShardSnapshotStatus snapshotStatus,
    }
            // Failing on an already existing index-${repoGeneration} below ensures that the index.latest blob is not updated in a way  
                    || metadata.generation() == RepositoryData.CORRUPTED_REPO_GEN  
    }
        boolean changedSnapshots = false;
                        String remoteStoreRepository = IndexMetadata.INDEX_REMOTE_SEGMENT_STORE_REPOSITORY_SETTING.get(
                            newGen
        ByteSizeValue maxByteSize = bytesPerSecSetting.get(settings);
                    // We can skip writing blobs where the metadata hash is equal to the blob's contents because we store the hash/contents
import java.lang.ref.SoftReference;  
                        + "] must be larger than latest known generation ["
        Set<String> blobs,
                                shardId,
                            // Delete all now outdated index files up to 1000 blobs back from the new generation.
     *                                      delete operation
            String indexUUID = remStoreBasedShardMetadata.getIndexUUID();
                    // to change in any form.
        // Id of the new index-${uuid} blob that does not include the snapshot any more
                    );  
                        INDEX_METADATA_FORMAT.write(indexMetaData, indexContainer(index), metaUUID, compressor);
        // Step 2: Write new index-N blob to repository and update index.latest
                );  
        ActionListener<Void> listener,
                }
    private volatile int maxShardBlobDeleteBatch;  
    private volatile RateLimiter remoteDownloadLowPriorityRateLimiter;
                                indexMetaGeneration,  
                                .collect(Collectors.toList());
                );  
            logger.warn(new ParameterizedMessage("[{}] Exception during cleanup of stale shard blobs", snapshotIds), e);  
    /**
                        .metadata(
    /**
                                }
                }  
            // that decrements the generation it points at
                    } else {
                        "Failed to write index.latest blob. If you do not intend to use this "
            return Optional.empty();  
                    snapshotShardPaths,  
     * Loads information about shard snapshot
     */
        BlobContainer shardContainer,
            );  
            }
                // This is called if any operation fails  
                // write new index-N blob to ensure concurrent operations will fail
            return RepositoryStats.EMPTY_STATS;  
        } catch (IOException | NotXContentException ex) {
                existingSnapshots = buildBlobStoreIndexShardSnapshots(Collections.emptySet(), shardContainer, shardGeneration).v1();  
            return;
                } else {
        }
        RepositoryData oldRepoData,  
                    l.onFailure(e);
import java.util.function.Supplier;
                if (genToLoad > generation) {
                    if (metaUUID == null) {
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / maxShardBlobDeleteBatch))
                                    snapshotIdsWithoutVersion,  
     *     indicating that no consistent repository generation is tracked in the cluster state yet.</li>
        // to close blobStore if blobStore initialization is started during close
     * @param remoteSegmentStoreDirectoryFactory    RemoteSegmentStoreDirectoryFactory to be used for cleaning up remote store segments.
                                    .metadata(
        String shallowSnapshotUUID,  
        long defaultAbsoluteThreshold = ByteSizeUnit.KB.toBytes(500);  
            }
                try (Releasable ignored = incrementStoreRef(store, snapshotStatus, shardId)) {  
    ) {
            new ClusterStateUpdateTask(repositoryUpdatePriority) {  
        Consumer<Exception> onFailure  
    }
            } else {  
    protected ByteSizeValue chunkSize() {
     *
    @Override
        Map<SnapshotId, Long> snapshotIdPinnedTimestampMap,
            );  
    public String startVerification() {  
            metric.inc(t);
            return shardInfoFromPath;  
        long repositoryStateId,  
                        .metadata(
    private boolean uncleanStart;
                    @Override
                        return INDEX_METADATA_FORMAT.read(indexContainer, indexMetaGeneration, namedXContentRegistry).getNumberOfShards();
            listener.onResponse(newRepositoryData);
            if (survivingIndexIds.equals(foundIndices.keySet()) && staleRootBlobs.isEmpty()) {
            () -> new ParameterizedMessage(
                null  // V1 shallow-copy is a Lucene-only mode — DFA indices use V2 snapshots only. If a DFA index were ever associated with  
                public void onResponse(Void unused) {
            }
            ActionListener.map(listener, ignored -> null),  
            if (existingTargetFiles != null) {
            }
 * Modifications Copyright OpenSearch Contributors. See
     * Get the latest snapshot index blob id.  Snapshot index blobs are named index-N, where N is
                final int shardCount = counts.stream().mapToInt(i -> i).max().orElse(0);
                );
                        remoteDirectoryFactory,
            listener.onFailure(new RepositoryException(metadata.name(), "cannot clone shard snapshot on a readonly repository"));  
                // No shallow copy or full copy snapshot is surviving.
    }
                            prevIndexMetadata.getSettings()
                            INDEX_FILE_PREFIX + previousGeneration  
        BlobPath testBlobPath;
        ActionListener<RepositoryData> listener
            if (indexUUID.equals(indexMetadata.getIndexUUID())) {  
            final GroupedActionListener<Void> groupedListener = new GroupedActionListener<>(ActionListener.wrap(r -> {
    public void deleteSnapshotsInternal(
     * Size hint for the IO buffer size to use when reading from and writing to the repository.
        bestEffortConsistency = uncleanStart  
     * @return RepositoryData
        MAX_RESTORE_BYTES_PER_SEC,
            final Set<String> survivingIndexIds = repositoryData.getIndices()
            mayBeLogRateLimits(context, rateLimiterSupplier.get(), t);  
                    afterCleanupsListener
            // Call the delete method on the shardContainer and accumulate the result
                            + "repository as the basis for a URL repository you may turn off attempting to write the index.latest blob by "
        BlobContainer shardContainer,
        } catch (Exception e) {
            }
    protected BlobStoreRepository(
    ) throws IOException {
     * This ensures compatibility across various JDK versions. For a practical usage example,
     * Finds and returns a list of shard paths that match the given index ID.  
        return blobStore().blobContainer(testBlobPath.add(testBlobPrefix(seed)));
        }, listener::onFailure);  
        RepositoryData oldRepositoryData,  
                        Store.verify(indexOutput);
        // Build a list of snapshots that should be preserved
                            return newRepositoryData;
                .stream()  
            logger.warn(
        Repository remoteTranslogRepository,
                        isShallowSnapshotV2,
    public void snapshotRemoteStoreIndexShard(  
     * @param oldGen previous safe repository generation  
                        store.indexSettings().getRemoteStoreRepository(),
        }
            return INDEX_METADATA_FORMAT.read(  
        Collection<SnapshotId> snapshotIds,  
        Setting.Property.NodeScope
                updatedRepoData,  
        if (indexEntry == null) {
                @Override  
                            + generation
                        snapshotId.getName(),
            } catch (Exception e) {
                e
                        @Override  
                // If the generation to load changed concurrently and we didn't just try loading the same generation before we retry  
                remoteUploadRateLimitingTimeInNanos,
        Collection<SnapshotId> snapshotIds,  
    private final boolean prefixModeVerification;
        ActionListener<RepositoryData> listener
                            "Failed marking repository state as corrupted",
import org.opensearch.index.store.lockmanager.RemoteStoreLockManagerFactory;
                    deleteFromContainer(rootBlobContainer(), filesToDelete);
                        repositoryData,
        );
    ) {
    ) {
                            remoteDirectoryCleanupAsync(
                        int partLength = parts.length;
        }
                        try {
                                loadAllVersionsListener,  
        final SnapshotId snapshotId = snapshotInfo.snapshotId();
            return shardGeneration;
        Function<ClusterState, ClusterState> stateTransformer,
                                .mapToObj(gen -> INDEX_FILE_PREFIX + gen)  
        if (this.closed) {
            offsetRangeInputStream,
     * Reloads the values derived from the Repository Metadata
    }
    public NamedXContentRegistry getNamedXContentRegistry() {
            remoteDirectoryCleanupAsync(  
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshots;
     */  
                    Version minNodeVersion = clusterService.state().nodes().getMinNodeVersion();  
import org.opensearch.cluster.ClusterState;
            AtomicInteger counter = new AtomicInteger();
            )
     * @param rootBlobs                     all blobs found directly under the repository root  
            snapshotStatus.addProcessedFile(0);
/**  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService,
                    }
                @Override
            final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);
        }  
        return shardContainer(indexId, shardId.getId());
                            + genToLoad
     */  
        }
        }
                    throw new IndexShardSnapshotFailedException(shardId, "failed to list blobs", e);
                Store.MetadataSnapshot commitSnapshotMetadata = store.getMetadata(snapshotIndexCommit);
                            prevIndexMetadata  
                paths,  
                            + latestKnownRepoGen.get()
                final RepositoryData loaded;  
                }
        })), listener::onFailure);
        }
                                + repoState  
                return true;
            final String existingShardGen;
                    if (fileToRecover == null) {  
                                while ((length = stream.read(buffer)) > 0) {
                            indexOutput.writeBytes(hash.bytes, hash.offset, hash.length);
            snapshotStatus.moveToStarted(  
        } catch (Exception e) {  
        Setting.Property.NodeScope  
     */
        long repositoryStateId,  
                // no idea what this blob is but it doesn't belong in the repository!
                );  
            return new Tuple<>(INDEX_SHARD_SNAPSHOTS_FORMAT.read(shardContainer, generation, namedXContentRegistry), generation);
                existingShardGen = shardGeneration;
            logger.warn(new ParameterizedMessage(" [{}] Failed to clean up old shard generation blobs", metadata.name()), e);  
            if (ensureSafeGenerationExists(expectedGen, listener::onFailure) == false) {
    }  
                        ),
                @Override  
        for (IndexId indexId : indicesToUpdate) {  
            final String generation = snapshotStatus.generation();
                                executeOneFileRestore(files, allFilesListener);
                    logger.warn(  
        this.threadPool = clusterService.getClusterApplierService().threadPool();
            } else if (shardContainer.blobExists(REMOTE_STORE_SHARD_SHALLOW_COPY_SNAPSHOT_FORMAT.blobName(snapshotId.getUUID()))) {
    private static final String SNAPSHOT_CODEC = "snapshot";  
            .<RepositoriesMetadata>custom(RepositoriesMetadata.TYPE)  
        Collection<SnapshotId> snapshotIds,
            SNAPSHOT_SHARD_PATHS_FORMAT.write(shardPaths, snapshotShardPathBlobContainer(), name);
        }
                    throw new RepositoryVerificationException(metadata.name(), "Failed to verify repository", e);  
    /**
    public void deleteSnapshots(
            }
                            throw new IllegalStateException(  
                "path " + basePath() + " is not accessible on cluster-manager node",  
    /**
                        indexIncrementalSize += md.length();  
                || clusterService.state().nodes().getMinNodeVersion().onOrAfter(Version.V_2_17_0))) {
            () -> new ParameterizedMessage(  
    }
                    this.rootBlobContainer.set(rootBlobContainer);  
    }
        }  
                }
    );  
     * @param indexId              The index ID for which the ShardInfo object is needed.
        logger.debug(
                throw new IndexShardSnapshotFailedException(  
            Tuple<BlobStoreIndexShardSnapshots, String> tuple = buildBlobStoreIndexShardSnapshots(blobs, shardContainer, generation);
            // exist
    private final CounterMetric remoteUploadLowPriorityRateLimitingTimeInNanos = new CounterMetric();
                        v -> cleanupStaleBlobs(
                        + CACHE_MAX_THRESHOLD
            return extendedSseStoreStats;
        ShardInfo shardInfoFromPath = highestGenShardPaths.map(SnapshotShardPaths::parseShardPath).orElse(null);  
            assert indexShardSnapshot instanceof BlobStoreIndexShardSnapshot
        assert repositoryMetadata != null;
                        remoteStoreLockManagerFactory,
    /**  
        new SoftReference<>(null)
            RemoteStoreShardShallowCopySnapshot remStoreBasedShardMetadata = (RemoteStoreShardShallowCopySnapshot) indexShardSnapshot;  
            threadPool.executor(ThreadPool.Names.SNAPSHOT).execute(new AbstractRunnable() {
                    setPendingStep.onResponse(newGen);  
        return isSystemRepository;  
            List<String> paths = getShardPaths(indexId, shardCount);  
     *
                    // skip cleanup for snapshot not present in deleted snapshots list
                    List<BlobStoreIndexShardSnapshot.FileInfo> filesInfo = snapshots.findPhysicalIndexFiles(fileName);
                    "Can't create clone of ["
                        indexTotalFileSize,
    /**  
import org.opensearch.snapshots.AbortedSnapshotException;
        try {
        Setting.Property.Deprecated
        } catch (IOException ex) {  
                    snapshotStatus,
                                        .withUpdatedGeneration(repoName, safeGeneration, newGen)
     * Snapshot individual file
                    }
                return REMOTE_STORE_SHARD_SHALLOW_COPY_SNAPSHOT_FORMAT.read(shardContainer, snapshotId.getUUID(), namedXContentRegistry);
                                            .putCustom(  
     * After updating the {@link RepositoryData} each of the shards directories is individually first moved to the next shard generation
                        e
        if (toDelete.isEmpty()) {  
 * GitHub history for details.
            // the clone operation ensuring that the snapshot name is available by checking the repository data. Also, the new clone shallow
    public SetOnce<BlobContainer> getSnapshotShardPathBlobContainer() {
        }
     * @param generation repository generation of the given repository data
        String shardStateIdentifier,
            if (snapshotIdsWithoutVersion.isEmpty() == false) {  
                            ActionRunnable.run(
import org.opensearch.action.ActionRunnable;
    }
                }  
                    e  
                metadata.name(),
            }
                final Set<String> blobNamesToIgnore = deletedSnapshots.stream()
        final StepListener<RepositoryData> writeUpdatedRepoDataStep = new StepListener<>();
     * @param shardInfo                     ShardInfo for the IndexId being cleaned up
                () -> remoteDownloadLowPriorityRateLimiter,
        // TODO: Assert MAX_REMOTE_LOW_PRIORITY_DOWNLOAD_BYTES_PER_SEC_SETTING < MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC_SETTING
        return snapshotShardPathBlobContainer;  
                    return currentState;
                    )
    public static final Setting<Boolean> SHALLOW_SNAPSHOT_V2 = Setting.boolSetting("shallow_snapshot_v2", false);
    @Override
    // Visible for testing  
                        return updateTask.execute(currentState);
            // bubbling up and breaking the snapshot functionality.
                    }
                    }
        ActionListener<RepositoryData> listener  
            new ClusterStateUpdateTask() {
            if (isSystemRepository == false) {  
            throw new IllegalArgumentException("the chunk size cannot be negative: [" + chunkSize + "]");
            ByteSizeValue userDefinedLimit = parseBytesSizeValueOrHeapRatio(s, SNAPSHOT_REPOSITORY_DATA_CACHET_THRESHOLD_SETTING_NAME);
                        )  
                            ActionListener.map(listener, v -> null)  
     */  
        logger.debug("[{}] shuffled the filesToDelete with timeElapsedNs={}", metadata.name(), (System.nanoTime() - startTimeNs));  
                : "indexShardSnapshot should be an instance of RemoteStoreShardShallowCopySnapshot";
    }
                continue;
        Store store,
        Setting.Property.NodeScope
import org.opensearch.index.remote.RemoteStorePathStrategy.SnapshotShardPathInput;
        try {
                                                    .withUpdatedGeneration(metadata.name(), newGen, newGen)
                    if (filesInfo != null) {
import org.opensearch.cluster.SnapshotsInProgress;
    }  
                            files,
                        genToLoad  
                }  
                return;
        return Math.min(Math.max(defaultThresholdOfHeap, defaultAbsoluteThreshold), MAX_SAFE_ARRAY_SIZE);
        return new RateLimitingOffsetRangeInputStream(offsetRangeInputStream, rateLimiterSupplier, (t) -> {
        }
        // Return the accumulated DeleteResult  
                List<String> deletedBlobs = cleanupStaleRootFiles(newRepoData.getGenId() - 1, deletedSnapshots, staleRootBlobs);
                + Thread.currentThread()
            }
                throw new IllegalArgumentException(
                }
                                allFilesListener.onFailure(e);
    private void cleanRemoteStoreDirectoryIfNeeded(  
    protected volatile boolean supportURLRepo;
                        }  
    public long getRemoteDownloadThrottleTimeInNanos() {  
     * @param indexEntry                    The index entry containing the blob container  
            remoteStoreLockManagerFactory,
                                        metadata.name(),
     * @throws IOException If an I/O error occurs during the cleanup process  
        List<SnapshotId> snapshotIds = Collections.emptyList();
     * This check is necessary because {@link RepositoryData} is mostly read from the cached value in {@link #latestKnownRepositoryData}  
        if (indices.isEmpty()) {  
        if (isReadOnly() == false) {
        return indicesPath().add(indexId.getId());
    BlobContainer getBlobContainer() {
                    "["
        return getRepositoryData(genToLoad);  
import org.opensearch.snapshots.SnapshotShardPaths;
                // In such cases, we fallback to fixed_path for cleanup of the data.
                ActionListener.wrap(writeUpdatedRepoDataStep::onResponse, listener::onFailure)
            // When using shard generations we can safely write the index-${uuid} blob before writing out any of the actual data
        if (store == null && serverSideEncryptedStore == null) {
            this.newGeneration = newGeneration;
    protected void writeIndexGen(  
                            );  
            deleteResult = deleteResult.add(deleteContainer(shardContainer(shardInfo.getIndexId(), i)));  
     */  
                indexId.getId(),
        for (final IndexMetadata indexMetadata : clusterService.state().metadata().getIndices().values()) {
        },
        if (isReadOnly()) {
                ) {  
        );  
                        metadataFromStore = store.getMetadata(snapshotIndexCommit);
        long timestampToUnpin,  
 */  
    public InputStream maybeRateLimitSnapshots(InputStream stream) {
            long bestGenerationFromCS = bestGeneration(snapshotsInProgress.entries());
        FileTransferTracker fileTransferTracker = new FileTransferTracker(shardId, remoteTranslogTransferTracker);
                            throw new AbortedSnapshotException();
        return latest;  
     *  
                indexId.getName(),
                    + "] but "
                                    newGen = -1L;
                REMOTE_STORE_SHARD_SHALLOW_COPY_SNAPSHOT_FORMAT.write(
            }, deleteIndexMetadataListener::onFailure);  
            final long startTime = threadPool.absoluteTimeInMillis();  
            null, // Passing null since no remote store segment files need to be cleaned up
    public RepositoryMetadata getMetadata() {  
                e  
            }
        RepositoryData oldRepoData,
            false,
                    metadata.name(),  
                            store.incRef();
                } else {
            BlobStoreTransferContext.REMOTE_DOWNLOAD
        BlobStoreProvider provider = blobStoreProvider.get();  
                        snapshotIds,
                bestGenerationFromCS = bestGeneration(
        if (matchingShardPaths.isEmpty()) {
                            "Your repository metadata blob for repository [{}] is larger than [{}] bytes. Consider moving to a fresh"
            // bubbling up and breaking the snapshot functionality.
            final String snapshotsIndexBlobName = INDEX_FILE_PREFIX + indexGen;
                        }
            }
    }  
                @Override  
                return INDEX_SHARD_SNAPSHOT_FORMAT.read(shardContainer, snapshotId.getUUID(), namedXContentRegistry);  
        BlobStoreIndexShardSnapshots::fromXContent
     * @param repositoryData            RepositoryData to write
        if (shardInfoFromPath == null) {  
            this.shardId = shardId;  
            final RepositoryData repositoryData = safeRepositoryData(repositoryStateId, rootBlobs);
        final SoftReference<Tuple<Long, BytesReference>> softRef = latestKnownRepositoryData.get();
        ByteSizeValue chunkSize = chunkSize();
     * which could be stale in the broken situation of a concurrent write to the repository.
            }
    }
                shardCount,  
        }
                if (blobsToLog.isEmpty() == false) {
     *
                        indexMetadata
                    }
     *  
                                    finalShardId
            updatedRepoData,
                    indexTotalFileSize += commitSnapshotMetadata.get(fileName).length();  
    public void finalizeSnapshot(
        // If both shardInfoFromPath and shardInfoFromMap are non-null,  
                metadata.name(),
                    this.snapshotShardPathBlobContainer.set(snapshotShardPathBlobContainer);
                    repositoryData,  
     * operations are found in the cluster state while setting the safe repository generation.  
     * Ensures that {@link RepositoryData} for the given {@code safeGeneration} actually physically exists in the repository.
            return userDefinedLimit;
    ) {
                    "Tried writing generation ["
     * </ul>
        SNAPSHOT_NAME_FORMAT,
            if (isReadOnly()) {
     * @param foundIndices                  all indices blob containers found in the repository before {@code newRepoData} was written
        // releasing the lock file, we would still have the shallow-snap-UUID file and that would be used during
    }  
            }, ex -> {
        boolean forceClean
                newSnapshotsList.add(point);
            store,  
                        cacheRepositoryData(serializedRepoData, newGen);
                        && survivingSnapshotUUIDs.contains(  
import org.apache.lucene.index.CorruptIndexException;
            final GroupedActionListener<Void> groupedListener = new GroupedActionListener<>(
        return remoteUploadLowPriorityRateLimiter;
                        throw new AlreadyClosedException("store is closing");
        Collection<SnapshotId> snapshotIds,
            remoteDownloadRateLimitingTimeInNanos,
        false,
        return updatedIndexIds;
                        cleanupOldShardGens(existingRepositoryData, updatedRepositoryData, newRepoData, listener);
                        updateTask.onFailure(source, e);
                    logger.trace("[{}] [{}] Processing [{}]", shardId, snapshotId, fileName);
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,
     * Second, the updated {@link RepositoryData} is written to generation {@code P + 1}.
    /**  
                for (SnapshotFiles snapshotFileSet : snapshots.snapshots()) {
        MAX_REMOTE_UPLOAD_BYTES_PER_SEC,  
            restoreRateLimitingTimeInNanos,  
            snapshotIndexCommit.getGeneration(),
        RepositoryStats extendedStoreStats = getExtendedStats(store);  
                "Repository [{}] Failed to write shard paths for index [{}] in snapshot [{}]",  
        );  
import org.opensearch.index.store.RemoteSegmentStoreDirectoryFactory;  
                                shard,  
                    }  
import java.util.concurrent.TimeUnit;
                    .collect(Collectors.toSet());  
     * <p>
                        }
                    shardId,  
                        snapshotId -> Stream.of(  
            latestKnownRepositoryData.updateAndGet(knownRef -> {  
     * Sets the cache size for snapshot repository data: the valid range is within 500Kb  ... 1% of the node heap memory.
                    "Failed to write commit point for snapshot " + snapshotId.getName() + "(" + snapshotId.getUUID() + ")",
                // Make reads abortable by mutating the snapshotStatus object  
            writeAtomic(blobContainer(), indexBlob, serializedRepoData, true);
        } catch (Exception t) {  
    /***  
                snapshotId.getName()
                } catch (IOException e) {  
                }  
                    } else {
     *  
                    l.onResponse(null);  
                                    + meta.pendingGeneration()
    private DeleteResult cleanUpStaleSnapshotShardPathsFile(List<String> matchingShardPaths, Map<String, BlobMetadata> snapshotShardPaths)
                    final RepositoryMetadata repoState = state.repository(metadata.name());  
        if (safeGeneration != RepositoryData.EMPTY_REPO_GEN && blobContainer().blobExists(INDEX_FILE_PREFIX + safeGeneration) == false) {
                    "[{}] The following blobs are no longer part of any snapshot [{}] but failed to remove them",
        } else {  
     * Server side encryption  
     */
        long defaultThresholdOfHeap = (long) (jvmHeapSize * SNAPSHOT_REPOSITORY_DATA_CACHE_THRESHOLD_DEFAULT_PERCENTAGE);
        if (remoteStoreLockManagerFactory == null) {
        return maybeRateLimit(
        IndexShardSnapshot snapshot = loadShardSnapshot(shardContainer(indexId, shardId), snapshotInfo);
                                }
    public long getSnapshotThrottleTimeInNanos() {
        }  
        Priority repositoryUpdatePriority,
import org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException;
 * Unless required by applicable law or agreed to in writing,
                + "] to be the snapshot_deletion or snapshot or generic thread.";
        SNAPSHOT_RESTORE("snapshot_restore");
                FileLockInfo.getLockInfoBuilder().withAcquirerId(source.getUUID()).build(),
            snapshotIds
     * <p> Since this method requires old repository data to fetch index metadata of the deleted index,  
            ),  
                    updatedSnapshots = BlobStoreIndexShardSnapshots.EMPTY;  
                    final String repoName = metadata.name();
            }
                                ThreadPool.Names.REMOTE_PURGE,
        try {  
        final NamedXContentRegistry namedXContentRegistry,
        // 2. Update the index shard generations of all updated shard folders
                        );
                        indexId -> new ShardInfo(indexId, repositoryData.shardGenerations().getGens(indexId).size())
        return prefixModeVerification;
    public static long calculateDefaultSnapshotRepositoryDataCacheThreshold() {
     * numeric shard generations where atomic writes with fail-if-already-exists checks are useful in preventing repository corruption.
    private DeleteResult deleteShardData(ShardInfo shardInfo) throws IOException, ExecutionException, InterruptedException {  
        }  
                            logger.info(  
            }
        // Once we are done writing the updated index-N blob we remove the now unreferenced index-${uuid} blobs in each shard
                            threadPool.absoluteTimeInMillis() - lastSnapshotStatus.getStartTime(),
            final List<SnapshotId> snapshotIdsWithoutVersion = repositoryData.getSnapshotIds()
            .indexUUID(indexId.getId())  
    protected BlobStore getBlobStore() {
        List<String> filesToDelete = staleFilesToDeleteInBatch.poll(0L, TimeUnit.MILLISECONDS);
                    cleanupRemoteStoreLocks(indexEntry, shardInfo, remoteStoreLockManagerFactory);
            .stream()
        IndexId indexId,
                    if (filesToRecover.isEmpty()) {  
     * Cleans up the indices and data corresponding to all it's shards.
    private BlobPath indexPath(IndexId indexId) {  
                snapshotShardPaths,
                        .execute(
                List<String> eligibleFilesToDelete = new ArrayList<>();  
     * Returns true if metadata and snapshot files should be compressed
            maybeRateLimitRemoteTransfers(
                return "read-only";
        }
    private void asyncCleanupUnlinkedShardLevelBlobs(
        return new Tuple<>(BlobStoreIndexShardSnapshots.EMPTY, latest);  
     */
import org.opensearch.common.io.Streams;
                List<String> matchingShardPaths = findMatchingShardPaths(indexSnId, snapshotShardPaths);
                new ClusterStateUpdateTask(repositoryUpdatePriority) {
                        remoteStorePinnedTimestampService,  
            // In addition to the settings in RELOADABLE_SETTINGS, all the new settings should be equal to current settings
        SnapshotId target,
                indexIncrementalSize,
    /**
    public void deleteSnapshotsAndReleaseLockFiles(
/*  
                }
import org.opensearch.cluster.ClusterStateUpdateTask;
            listener.onResponse(generation);
            listener,  
        final Tuple<Long, BytesReference> cached;
                    assert newGen > latestKnownRepoGen.get() : "Attempted new generation ["
    public void updateState(ClusterState state) {
    }
                        writtenGeneration = String.valueOf(indexGeneration);
                    );
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory
    private ShardSnapshotMetaDeleteResult deleteFromShardSnapshotMeta(
    private BlobContainer shardContainer(IndexId indexId, ShardId shardId) {
        final ShardId shardId = store.shardId();  
            Collections.emptyMap(),  
     * @param idToShardInfoMap              map of indexId to ShardInfo  
                    shardContainer,
        boolean isShallowSnapshotV2,  
        );
                + "expected state. This is likely the result of either concurrently modifying the contents of the "
     * @param idToShardInfoMap              map of indexId to ShardInfo  
        // directory  
        }
                threadPool,
    ) {
    public SnapshotInfo getSnapshotInfo(final SnapshotId snapshotId) {  
     */
                        + snapshotId
            }  
        if (shardInfoFromMap == null) {
        } catch (Exception e) {
        }, listener::onFailure), foundIndices.size() - survivingIndexIds.size());
     * First, the {@link RepositoryMetadata} entry for this repository is set into a pending state by incrementing its
        ActionListener<RepositoryData> listener
import org.opensearch.core.xcontent.MediaTypeRegistry;  
     * Marks the repository as corrupted. This puts the repository in a state where its tracked value for  
    }  
    ) {  
     *
import org.opensearch.cluster.service.ClusterService;
            logger.warn("Exception during cleanup of remote directory files for snapshot v2", e);  
                        );  
                        public void onFailure(Exception e) {
                    pinnedTimestampListener
        }));
import org.opensearch.repositories.RepositoryShardId;
    @Override  
            );
                        namedXContentRegistry
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
    private void cleanupOldShardGens(
    }
    @Override
        } else {  
                indexId.getName(),  
            return blobsToDelete;  
            );  
            } catch (IOException e) {
        Map<SnapshotId, Long> snapshotIdPinnedTimestampMap,
    public IndexShardSnapshotStatus getShardSnapshotStatus(SnapshotInfo snapshotInfo, IndexId indexId, ShardId shardId) {
            } catch (NumberFormatException nfe) {  
                ),
                        if (fileInfo.name().startsWith(VIRTUAL_DATA_BLOB_PREFIX)) {
                        logger.warn("Exception while updating pinning timestamp state, snapshot deletion will continue", e);
                        writeShardIndexBlobAtomic(shardContainer, indexGeneration, updatedSnapshots);  
 * specific language governing permissions and limitations
                private void executeOneFileRestore(
        } else {
        } catch (IOException e) {
                        repositoryMetaVersion,  
        Store store,
                        pathStrategy.getHashAlgorithm()
                    metadata.name(),
            listener  
                "set safe repository generation [" + metadata.name() + "][" + newGen + "]",  
    public static final String INDEX_FILE_PREFIX = "index-";
    @Override
        IndexId indexId,
                @Override  
                    listener.onResponse(null);  
            if (survivingSnapshots.isEmpty()) {
 *  
            // EMPTY is safe here because RepositoryData#fromXContent calls namedObject
    // Best effort cache of the latest known repository data and its generation, cached serialized as compressed json
                        listener.onResponse(null);
                deleteResult = deleteResult.add(result);
    public static final Setting<Integer> MAX_SNAPSHOT_SHARD_BLOB_DELETE_BATCH_SIZE = Setting.intSetting(  
                    snapshotShardPathBlobContainer = blobStore().blobContainer(basePath().add(SnapshotShardPaths.DIR));  
                indexIncrementalFileCount,
     * @return The ShardInfo object with the highest shard count, or null if no ShardInfo is available.
import java.io.InputStream;
                .map(IndexId::getId)
            && (clusterService.isStateInitialised() == false
                                // we will reuse it for this snapshot  
        } else if (blobs.stream()  
            cause
    // package private for testing  
import java.util.HashMap;  
                    "Repository [{}] Exception during snapshot stale index deletion for updatedIndexIds {}",
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
        DeleteResult deleteResult = DeleteResult.ZERO;
                    ActionListener.runAfter(new ActionListener<Collection<Void>>() {  
                        + "] for snapshot ["  
        RecoveryState recoveryState,
            throw new SnapshotException(
            for (int i = 0; i < workers; ++i) {
                for (int shardId = 0; shardId < shardCount; shardId++) {  
        RepositoryData repositoryData,  
import org.opensearch.index.translog.transfer.TranslogTransferManager;  
     */
            SoftReference<Tuple<Long, BytesReference>> softRef = latestKnownRepositoryData.get();
                                "Tried to update from unexpected pending repo generation ["  
                            } finally {
                        throw new RepositoryVerificationException(
        }  
                })
        throws IOException {  
            .anyMatch(b -> b.startsWith(SNAPSHOT_PREFIX) || b.startsWith(INDEX_FILE_PREFIX) || b.startsWith(UPLOADED_DATA_BLOB_PREFIX))) {
        logger.trace(() -> new ParameterizedMessage("[{}] Deleting {} from [{}]", metadata.name(), blobs, container.path()));
     * @param listener                      listener to invoke with the combined {@link DeleteResult} of all blobs removed in this operation
 * The OpenSearch Contributors require contributions made to  
        GroupedActionListener<DeleteResult> listener,
                    );  
     * maintains single lazy instance of {@link BlobContainer}
    public void finalizeSnapshot(
    }
                    deletedSnapshots,  
            remoteStoreShardShallowCopySnapshot.getRemoteStorePathStrategy()
     * @param snapshotIdPinnedTimestampMap       Map of snapshotId and pinned timestamp  
            remoteStorePinnedTimestampService,  
        this.namedXContentRegistry = namedXContentRegistry;
                ignored -> pinnedTimestampListener.onResponse(repositoryData),
                return new ShardSnapshotMetaDeleteResult(indexId, snapshotShardId, ShardGenerations.DELETED_SHARD_GEN, blobs);  
        this.repositoryDataCacheThreshold = SNAPSHOT_REPOSITORY_DATA_CACHE_THRESHOLD.get(clusterService.getSettings()).getBytes();
    ) throws InterruptedException {  
    }
            } catch (Exception e) {  
        ByteSizeValue.ZERO,  
                    assert SNAPSHOT_FORMAT.blobName(foundUUID).equals(blob);
     */
        if (latest >= 0) {
                public void onFailure(String source, Exception e) {  
                    shardContainer.listBlobsByPrefix(INDEX_FILE_PREFIX).keySet(),
     * Setting to disable writing the {@code index.latest} blob which enables the contents of this repository to be used with a
                return deleteResult;  
            return SnapshotShardPaths.FILE_PREFIX + name;  
            logger.error("Exception while cleaning up remote translog for shard: " + shardId, e);
            return new RateLimiter.SimpleRateLimiter(maxByteSize.getMbFrac());
                                    + "] after write to generation ["
        Map<String, BlobMetadata> snapshotShardPaths,
                        : (uninitializedMeta ? expectedGen : genInState);
            // we first delete the old index.latest and then write the new one. If the repository is not  
        boolean isShallowSnapshotV2,
        BlobStoreIndexShardSnapshot::fromXContent
                            meta.name(),
                return true;
            logger.warn(new ParameterizedMessage("[{}] Exception during cleanup of stale indices", metadata.name()), e);  
        Version version,  
                    // not offer any consistency guarantees when it comes to overwriting the same blob name with different content.
        }
                remoteStoreLockManagerFactory,
    private void executeOldShardGensCleanup(BlockingQueue<List<String>> staleFilesToDeleteInBatch, GroupedActionListener<Void> listener)
            } else {
                            // here will be retried in the next delete or repository cleanup
            final BlobStoreIndexShardSnapshots existingSnapshots;  
        IndexMetadata indexMetadata
                        repositoryDataCacheThreshold
     */
                    final IndexMetadata indexMetaData = clusterMetadata.index(index.getName());
    // Delete all old shard gen blobs that aren't referenced any longer as a result from moving to updated repository data  
        RemoteSegmentStoreDirectoryFactory remoteDirectoryFactory,  
                final long partBytes = fileInfo.partBytes(i);
    }
            try {  
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,  
            final Map<IndexId, String> indexMetas = ConcurrentCollections.newConcurrentMap();
            return;
            );
     * @param highestGenShardPaths The optional highest generation shard path.
    private ClusterState updateRepositoryGenerationsIfNecessary(ClusterState state, long oldGen, long newGen) {
                        // Start as many workers as fit into the snapshot pool at once at the most  
    /**  
                logger.warn(
            );
                                    indexId,
            Set<String> allKeys = Stream.concat(newSettings.keySet().stream(), currentSettings.keySet().stream())  
            IndexShardSnapshot indexShardSnapshot = loadShardSnapshot(container, snapshotId);  
        synchronized (lock) {  
    void releaseRemoteStoreLocksAndCleanup(
     * @param blobs list of blobs in repository
        Randomness.shuffle(filesToDelete);
     * the next version number from when the index blob was written.  Each individual index-N blob is
    );
                                int length;  
    @Override  
        RepositoryData repositoryData,
        Version repositoryMetaVersion,
        RepositoryData newRepositoryData,
                    );
import org.opensearch.indices.RemoteStoreSettings;
        ActionListener<Void> afterCleanupsListener
    public static final Setting<ByteSizeValue> MAX_REMOTE_UPLOAD_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(
                    "Duplicate snapshot name [" + snapshotId.getName() + "] detected, aborting"
            .collect(Collectors.toList());  
            for (IndexId index : indices) {  
            ) {  
        final ShardId shardId = store.shardId();
        SNAPSHOT_REPOSITORY_DATA_CACHET_THRESHOLD_SETTING_NAME,
                newGen = UUIDs.randomBase64UUID();
                        }
                        } else {  
    }
                    e  
                    listener.onResponse(null);
import org.opensearch.core.compress.CompressorRegistry;  
        SNAPSHOT_CODEC,  
        this.recoverySettings = recoverySettings;
import java.util.Map;
        } catch (IOException e) {
                return DeleteResult.ZERO;
        }
                    try {
                        final int workers = Math.min(
        while (true) {
                XContentParser parser = MediaTypeRegistry.JSON.xContent()
        String shardId,
                    oldRepoData,
                snapshotEntries.add(entry);
    }
    /**
    private void cacheRepositoryData(BytesReference updated, long generation) {  
            final Collection<String> indexMetaGenerations = snapshotIds.stream()
            snapshotIndexCommit,  
            if (userDefinedLimitBytes > CACHE_MAX_THRESHOLD) {
                String.valueOf(shardId.shardId()),  
        return storeStats;
        }
        try {
            return;
                        e,  
     * Note: While it is true that this value could also be set to {@code true} for an instance on a node that is just joining the cluster
                if (newSnapshotsList.size() > 0) {
            BlobStoreTransferContext.SNAPSHOT_RESTORE
     * @param repositoryStateId             Current repository state id
    }
            );
            repositoryMetaVersion,
    void cleanupStaleIndices(
    /**  
                                    )
                InputStream blob = blobContainer().readBlob(snapshotsIndexBlobName);  
        final Collection<IndexId> indices = shardGenerations.indices();  
    public static final Setting<ByteSizeValue> MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(  
    }
                    }  
        }
     * Package private for testing  
                if (latestKnownRepoGen.compareAndSet(indexGen, RepositoryData.EMPTY_REPO_GEN)) {
        if (cacheRepositoryData && bestEffortConsistency == false) {
                            + " serialized size",
                try {  
                + "the cluster recover the known state of the repository from its physical contents.",  
                    // isn't safe  
                }
                    final RepositoryMetadata meta = getRepoMetadata(currentState);  
                        String remoteTranslogRepositoryName = IndexMetadata.INDEX_REMOTE_TRANSLOG_REPOSITORY_SETTING.get(  
     * potentially accounting for the last {@code index-N} write in the cluster state.
                        && blob.endsWith(".dat")
            return true;
                long cacheWarningThreshold = Math.min(repositoryDataCacheThreshold * 10, MAX_SAFE_ARRAY_SIZE);  
        executor.execute(ActionRunnable.wrap(restoreListener, l -> {
        if (RELOADABLE_SETTINGS.containsAll(newSettings.keySet())) {  
                throw new IllegalArgumentException(  
import java.util.concurrent.Executor;
            return null;
                    continue;
        return ActionListener.delegateResponse(new GroupedActionListener<>(listener, workers), (l, e) -> {  
     * @return An Optional containing the shard path with the highest generation number, or empty if the list is empty
        List<Tuple<BlobPath, String>> filesToDelete = staleFilesToDeleteInBatch.poll(0L, TimeUnit.MILLISECONDS);
                store.markStoreCorrupted((IOException) e);
                    return updatedIndexIds.contains(indexId);  
            } catch (Exception e) {
import org.opensearch.ExceptionsHelper;
            // and because the index.latest blob will never be deleted and re-written.
        try {
    }
     * Cleans up the remote store directory if needed.  
        }
    ) {  
                String.valueOf(pathType),
        Map<String, BlobContainer> shardBlobs,
     * @param state  cluster state to update
                        "Not caching repository data of size [{}] for repository [{}] because it is larger than [{}] bytes in"  
        return blobContainer;  
     *     <li>All repositories that are read-only, i.e. for which {@link #isReadOnly()} returns {@code true} because there are no
    private void executeStaleShardDelete(
                            snapshotId.getName(),  
            );  
    /**  
            snapshotStatus.moveToStarted(  
                        indexUUID,
        );
            // write the index file  
import org.apache.logging.log4j.LogManager;
    protected abstract BlobStore createBlobStore() throws Exception;
    String writeIndexShardPaths(IndexId indexId, SnapshotId snapshotId, int shardCount) {
                deleteFromContainer(rootBlobContainer(), eligibleFilesToDelete);
        remoteStoreMetadataLockManager.release(FileLockInfo.getLockInfoBuilder().withAcquirerId(shallowSnapshotUUID).build());  
            );
                        + metadata.generation()
    public InputStream maybeRateLimitLowPriorityDownloadTransfers(InputStream inputStream) {  
                    Version.CURRENT,  
    protected final ThreadPool threadPool;
            .filter(e -> e.repository().equals(repoName))
    }
    private static InputStream maybeRateLimit(
        Collection<SnapshotId> snapshotIds,
                        "a file written by cluster-manager to the store ["  
                latest = Math.max(latest, curr);
            );  
     */
            (BlobStoreRepository) remoteTranslogRepository,  
                BlobStoreTransferContext.REMOTE_DOWNLOAD  
                .collect(Collectors.toSet());
                }
            logger.error(new ParameterizedMessage("Exception during the remote directory cleanup for indecSnId [{}]", indexSnId), e);
                        && extractShallowSnapshotUUID(blob).map(snapshotUUID -> !survivingSnapshotUUIDs.contains(snapshotUUID))
                    }
                        );
    }
                @Override
                snapshotId,  
                repositoryData,
        String indexUUID,  
    private Optional<String> findHighestGenerationShardPaths(List<String> matchingShardPaths) {
                        INDEX_SHARD_SNAPSHOTS_FORMAT.write(updatedSnapshots, shardContainer, writtenGeneration, compressor);  
import org.opensearch.common.compress.DeflateCompressor;  
            for (DeleteResult result : deleteResults) {
                    if (repositoryMetadataStart.equals(getRepoMetadata(currentState))) {  
                    shardId
    // Unused blobs are all previous index-, data- and meta-blobs and that are not referenced by the new index- as well as all
                final long curr = Long.parseLong(blobName.substring(INDEX_FILE_PREFIX.length()));
            remoteDownloadRateLimitingTimeInNanos,  
        @Nullable String shardGeneration,
    public static final long CACHE_MAX_THRESHOLD = calculateMaxSnapshotRepositoryDataCacheThreshold();
    ) throws IOException {  
                                + corruptedGeneration
        } else {  
                    );
    public void verify(String seed, DiscoveryNode localNode) {
 * @opensearch.internal  
    private volatile RateLimiter restoreRateLimiter;
    @Override
                final List<String> blobsToLog = blobsToDelete.stream()
                throw new RepositoryVerificationException(  
 * This repository works with any {@link BlobStore} implementation. The blobStore could be (and preferred) lazy initialized in  
        if (filesToDelete.isEmpty()) {
     * Constructs new BlobStoreRepository
    @Override
                                + "] as corrupted but its state concurrently changed to ["
        getRepositoryData(repoDataListener);
    }
                    @Override
            Store.verify(indexInput);
     * @param updated    serialized RepositoryData to cache if newer than the cache contents  
                        .build();  
        }  
            );
                    loaded = getRepositoryData(genToLoad);
            List<String> fileNames;
    public static long calculateMaxSnapshotRepositoryDataCacheThreshold() {  
    private final NamedXContentRegistry namedXContentRegistry;
        return Stream.concat(deleteResults.stream().flatMap(shardResult -> {  
            repositoryData,
     *
        String remoteStoreRepoForIndex = remoteStoreShardShallowCopySnapshot.getRemoteStoreRepository();
                    }
            } catch (Exception e) {  
        final List<Tuple<BlobPath, String>> filesToDelete = resolveFilesToDelete(oldRepositoryData, snapshotIds, deleteResults);  
     * @param matchingShardPaths List of shard paths that match a specific criteria
                    }
                    logger.info(  
import static org.opensearch.repositories.blobstore.ChecksumBlobStoreFormat.SNAPSHOT_ONLY_FORMAT_PARAMS;  
                    final String seedRead = Streams.readFully(masterDat).utf8ToString();
    ) {
        }
     * Loads all available snapshots in the repository using the given {@code generation} or falling back to trying to determine it from
     * @param version                   version of the repository metadata to write
                throw new AbortedSnapshotException();
            listener.onResponse(deleteResult);  
            try {  
        if (currentGen != expectedGen) {
    private BlobPath shardPath(IndexId indexId, int shardId) {  
            Settings currentSettings = metadata.settings();
                    assert expectedGen == RepositoryData.EMPTY_REPO_GEN || uninitializedMeta || expectedGen == meta.generation()
                }
            }
    public static final Setting<String> SNAPSHOT_SHARD_PATH_PREFIX_SETTING = Setting.simpleString(  
        if (generation != null) {
                    + "], actual current generation ["
        SnapshotId snapshotId,  
    }  
    ) {
     * @param corruptedGeneration generation that failed to load because the index file was not found but that should have loaded
                            "Tried to mark repo generation ["  
     * @param foundIndices                  All indices folders found in the repository before executing any writes to the repository during this
    public static final ChecksumBlobStoreFormat<Metadata> GLOBAL_METADATA_FORMAT = new ChecksumBlobStoreFormat<>(  
        Function<ClusterState, ClusterState> stateFilter,
            listener  
        CACHE_DEFAULT_THRESHOLD + "b",  
        ActionListener<String> listener
                                .putCustom(
                .collect(Collectors.toSet());
        return basePath().add(INDICES_DIR);
                final String snapshotName = existingSnapshot.snapshot();  
import java.nio.file.NoSuchFileException;
            shardContainer,  
import java.io.FilterInputStream;  
            } else if (blob.startsWith(INDEX_FILE_PREFIX)) {
        s -> CompressorRegistry.getCompressor(s.toUpperCase(Locale.ROOT)),
                    }
        // next delete operation for releasing this lock file
                            } else {  
        readRepositoryMetadata(repositoryMetadata);  
            "set pending repository generation [" + metadata.name() + "][" + expectedGen + "]",
            // Otherwise, the cluster state is initialised and available with the min node version information
                    // of N so we mark this repository as corrupted.  
        final Set<String> survivingSnapshotNames = survivingSnapshots.stream().map(SnapshotId::getName).collect(Collectors.toSet());  
            }  
     * and then has all now unreferenced blobs in it deleted. If remoteStoreLockManagerFactory is not null, remotestore lock files are
        return remoteDownloadLowPriorityRateLimitingTimeInNanos.count();  
                l.onResponse(null);
     */  
    protected void doStart() {
            if (entry.repository().equals(repoName) && entry.repositoryStateId() == oldGen) {
                String shardPathsBlobName = writeIndexShardPaths(indexId, snapshotId, newShardCount);
        logger.trace(
     * Note: This setting is intended as a backwards compatibility solution for 7.x and will go away in 8.  
        long totalBytes = matchingShardPaths.stream().mapToLong(s -> snapshotShardPaths.get(s).length()).sum();
import org.apache.lucene.store.AlreadyClosedException;
                                "Tried to update repo generation to [" + newGen + "] but saw unexpected generation in state [" + meta + "]"
                    // delete an index that was created by another cluster-manager node after writing this index-N blob.
                            .get()
        }
                        metaUUID = UUIDs.base64UUID();
        return SnapshotsService.updateWithSnapshots(state, updatedSnapshotsInProgress, updatedDeletionsInProgress);
            || ALLOW_CONCURRENT_MODIFICATION.get(metadata.settings());  
                        logger.warn(  
            ),
        logger.warn(
        SNAPSHOT_NAME_FORMAT,
        return snapshot.getIndexShardSnapshotStatus();
                "failed to read shard snapshot file for [" + shardContainer.path() + ']',  
     */
    @Override
        Map<String, BlobContainer> foundIndices,
import org.opensearch.snapshots.SnapshotId;
                            chunkSize()
            final ClusterStateUpdateTask updateTask = createUpdateTask.apply(repositoryData);
        writeUpdatedRepoDataStep.whenComplete(updatedRepoData -> {
                        executedTask = true;
            // It's always a possibility to not see the latest index-N in the listing here on an eventually consistent blob store, just
import org.apache.lucene.store.IndexOutput;
                                remoteStorePathStrategy,  
     * This flag is set in the following situations:  
        return Arrays.asList(SYSTEM_REPOSITORY_SETTING, READONLY_SETTING, REMOTE_STORE_INDEX_SHALLOW_COPY);  
    }  
                    snapshotInfo.state(),
        // generation repeatedly.  
    // surviving snapshots are also added for cleanup.  
                    shardContainer
            testBlobPath = PathType.HASHED_PREFIX.path(pathInput, FNV_1A_COMPOSITE_1);  
                        logger.warn(
     * @return List of matching shard paths
                );
                0, // incremental File Count is zero as we are storing the data as part of remote store.
    public OffsetRangeInputStream maybeRateLimitRemoteUploadTransfers(OffsetRangeInputStream offsetRangeInputStream) {
     * see this link: https://github.com/openjdk/jdk11u/blob/cee8535a9d3de8558b4b5028d68e397e508bef71/src/jdk.zipfs/share/classes/jdk/nio/zipfs/ByteArrayChannel.java#L226
import org.opensearch.core.common.bytes.BytesArray;
            return;
            genToLoad = latestKnownRepoGen.get();  
                final Set<String> survivingSnapshotUUIDs = survivingSnapshots.stream().map(SnapshotId::getUUID).collect(Collectors.toSet());  
                    INDEX_SHARD_SNAPSHOT_FORMAT.write(
            try {  
                .filter(snapshotId -> repositoryData.getVersion(snapshotId) == null)
        return maybeRateLimit(
     */
                        repositoryStateId,
            if (isShallowSnapshotV2) {
            Set<String> updatedIndexIds = updatedShardPathsIndexIds.stream()
                public void onFailure(Exception e) {
                "[{}] cleanupOldShardGens toDeleteSize={} groupSize={}",
            listener.onFailure(e);
        } catch (IOException e) {  
        } else {
        PathType::parseString
        }
        }
                    repositoryStateId,
                    existingTargetFiles = existingSnapshot;
        return Objects.equals(s1.get(key), s2.get(key));
            false,
            return;
            listener.onFailure(e);
        ActionListener<Collection<Void>> listener
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,
    // and concurrent modifications.
    }  
                            indexCommitPointFiles,
                pinnedTimestampListener::onFailure
            final SnapshotFiles snapshotFiles = new SnapshotFiles(snapshot.snapshot(), snapshot.indexFiles(), null);
                }  
                                    blobStoreIndexShardSnapshots = tuple.v1();
                logger.warn(
        ByteSizeValue.parseBytesSizeValue("16mb", "io_buffer_size"),
                indexTotalFileSize
    /**  
            logger.debug(new ParameterizedMessage("staleShardPaths={}", staleShardPaths));  
                indexId.getName(),
     *
    );
                @Override
    private static final String UPLOADED_DATA_BLOB_PREFIX = "__";
                    if (repoState.generation() != corruptedGeneration) {
    public boolean isReloadableSettings(RepositoryMetadata newRepositoryMetadata) {
     */  
        final String repoName = metadata.name();  
import org.opensearch.common.blobstore.fs.FsBlobContainer;
    ) {  
                    ),  
        return blobStore().blobContainer(indexPath(indexId));  
 * </p>
            }), staleFilesToDeleteInBatch.size());
        Set<String> blobs,
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,  
                blob -> blob.startsWith(SNAPSHOT_INDEX_PREFIX)  
                    snapshotId,
    }
            // Start as many workers as fit into the snapshot pool at once at the most
        // Listener that flattens out the delete results for each index
 * license agreements. See the NOTICE file distributed with
        }, onUpdateFailure);
                @Override
                    () -> new ParameterizedMessage(
            return null;  
     * This method is used by {@link #writeIndexGen} to make sure that no writes are executed on top of a concurrently modified repository.
        final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);
                        }  
    private static final String SNAPSHOT_INDEX_PREFIX = "index-";  
                    }
                .collect(Collectors.toList());
    /**  
        Setting.Property.NodeScope,  
        }  
            // Start as many workers as fit into the snapshot pool at once at the most  
        CryptoMetadata cryptoMetadata
    public boolean isSystemRepository() {
import org.opensearch.common.Nullable;  
     * Updates the repository generation that running deletes and snapshot finalizations will be based on for this repository if any such
            remoteStoreLockManagerFactory,  
            return shardResult.blobsToDelete.stream().map(blob -> Tuple.tuple(shardPath, blob));
    ) throws IOException {  
        final RepositoryMetadata repositoryMetadata = state.getMetadata()
            listener.onFailure(new RepositoryException(metadata.name(), "cannot delete snapshot from a readonly repository"));
    @Override  
            listener.onFailure(e);
                String seed = UUIDs.randomBase64UUID();
                        + latestKnownRepoGen.get()
import org.opensearch.index.remote.RemoteStorePathStrategy;  
                            lastSnapshotStatus.getIncrementalSize()  
        final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);
                if (snapshotName.equals(target.getName())) {
        RepositoryData repositoryData,
        SnapshotId snapshotId,  
        final GroupedActionListener<DeleteResult> groupedListener = new GroupedActionListener<>(ActionListener.wrap(deleteResults -> {
                    () -> new ParameterizedMessage(  
        return rootBlobNames.stream().filter(blob -> {  
        }  
            }
                                .build()  
    /**
                        final ActionListener<Void> allFilesListener = fileQueueListener(  
                        snapshotId.getName(),  
            clusterMetadata,
    public boolean isReadOnly() {  
            () -> new ParameterizedMessage(  
        final long repositoryStateId,  
    private RepositoryData repositoryDataFromCachedEntry(Tuple<Long, BytesReference> cacheEntry) throws IOException {
import org.opensearch.index.snapshots.blobstore.IndexShardSnapshot;  
                if (indexId != null && indexId.getId().equals(indexSnId)) {
        for (SnapshotDeletionsInProgress.Entry entry : state.custom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.EMPTY)  
                                + "]"
                        indexIncrementalFileCount++;
                            "Trying to write new repository data over unfinished write, repo [{}] is at "  
                                    Tuple<BlobStoreIndexShardSnapshots, Long> tuple = buildBlobStoreIndexShardSnapshots(
                TimeValue.timeValueNanos(time).millis(),
        try {
    }  
                if (remoteSegmentStoreDirectoryFactory != null) {
     *     <li>The {@link #uncleanStart} flag is set to {@code true}</li>  
            logger.info("[{}] [{}] shallow copy snapshot to [{}] [{}] ...", shardId, snapshotId, metadata.name(), generation);  
import org.opensearch.core.util.BytesRefUtils;
                    "path " + basePath() + " is not accessible on node " + localNode,
            snapshotStatus.moveToDone(threadPool.absoluteTimeInMillis(), generation);  
        final long genToLoad;  
                                break;
        assert corruptedGeneration != RepositoryData.UNKNOWN_REPO_GEN;
                        + shardId
            Collections.emptyMap(),
            for (ShardSnapshotMetaDeleteResult shardSnapshotMetaDeleteResult : result) {  
                indexCommitPointFiles = new ArrayList<>();  
            throw new RepositoryException(  
    /**
                            if (blobs.stream()
                oldRepoData,
            try {
        OffsetRangeInputStream offsetRangeInputStream,  
    }  
 *
    }  
        // Read RepositoryMetadata as the first step
import org.opensearch.common.lease.Releasable;
     * @param snapshotShardPaths Map of snapshot shard paths and their metadata  
     * Delete snapshot from shard level metadata.  
                        public void onResponse(Collection<Void> voids) {
                    executor,
                            ex  
    }
    }
                        commitGeneration,
     * parameters {@code foundIndices}, {@code rootBlobs}. If remoteStoreLockManagerFactory is not null, remote store lock files are  
            REMOTE_STORE_SHARD_SHALLOW_COPY_SNAPSHOT_FORMAT.write(
                // The shardInfo can be null for 1) snapshots that pre-dates the hashed prefix snapshots.
                    onFailure.accept(e);
     * @param remoteStoreLockManagerFactory RemoteStoreLockManagerFactory to be used for cleaning up remote store lock files.
     *
                logger.error(new ParameterizedMessage("[{}] exception in cleanupOldShardGens", metadata.name()), ex);
        } catch (Exception e) {
 * this work for additional information regarding copyright
    private final SetOnce<BlobContainer> blobContainer = new SetOnce<>();
    private void cleanupRemoteStoreLocks(
                .values();
                cleanUpRemoteStoreFilesForDeletedIndicesV2(
                    indexId,
            testBlobPath = basePath();
                }
     * @param deletedSnapshots              list of snapshots being deleted  
                    metadata.name(),
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
        return maybeRateLimit(  
        }  
                    final boolean uninitializedMeta = meta.generation() == RepositoryData.UNKNOWN_REPO_GEN || bestEffortConsistency;  
            for (ShardSnapshotMetaDeleteResult newGen : deleteResults) {
        // return the ShardInfo object with the higher shard count
    private static final Set<String> RELOADABLE_SETTINGS = Set.of(  
        Collection<ShardSnapshotMetaDeleteResult> deleteResults
        threadPool.executor(ThreadPool.Names.SNAPSHOT_DELETION).execute(ActionRunnable.supply(listener, () -> {
                )  
            newSnapshotsList.add(new SnapshotFiles(snapshotId.getName(), indexCommitPointFiles, shardStateIdentifier));
        IndexCommit snapshotIndexCommit,
                    stateTransformer,
                        if (meta.pendingGeneration() != newGen) {
                public void onFailure(String source, Exception e) {
        } else if (extendedSseStoreStats != null) {
        if (store != null && store.extendedStats() != null && store.extendedStats().isEmpty() == false) {
        final BlobContainer shardContainer = shardContainer(indexId, shardId);
                    // Some full copy snapshots are surviving.
                    remoteStorePinnedTimestampService,  
                }
            logShardPathsOperationSuccess(indexId, snapshotId);
import org.opensearch.common.blobstore.DeleteResult;
            indices.size()
        Collection<SnapshotId> deletedSnapshots,  
        return BytesRefUtils.bytesToLong(Streams.readFully(blobContainer().readBlob(INDEX_LATEST_BLOB)).toBytesRef());
        return namedXContentRegistry;
                // We only rely on the generation tracked in #latestKnownRepoGen which is exclusively updated from the cluster state  
    public RepositoryStats stats() {
                    .flatMap(
        if (snapshotShardPathBlobContainer == null) {
        MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC
    /**
            if (survivingSnapshotNames.contains(point.snapshot())) {
                fileNames = new ArrayList<>(snapshotIndexCommit.getFileNames());  
                snapshotId,  
                    snapshotIds,  
                builder.put(newGen.indexId, newGen.shardId, newGen.newGeneration);
                }
                }
                    return updateTask.getClusterManagerThrottlingKey();
            } else {  
                    listener.onFailure(e);  
    public void deleteSnapshotsWithPinnedTimestamp(
 * not use this file except in compliance with the License.
                // Use writeBlobWithMetadata to pass CryptoMetadata for index-level SSE-KMS override
                                + " repository for new snapshots or deleting unneeded snapshots from your repository to ensure stable"  
                        }
            // repository data  
                        "Determined repository generation ["
    }  
                INDEX_SHARD_SNAPSHOTS_FORMAT.write(updatedBlobStoreIndexShardSnapshots, shardContainer, indexGeneration, compressor);  
    @Override  
    private volatile boolean closed;
            snapshotInfo,
            Map<String, BlobMetadata> rootBlobs = blobContainer().listBlobs();
                    );
                serialized = CompressorRegistry.defaultCompressor().compress(updated);
            return extendedStoreStats.merge(extendedSseStoreStats);
        );  
                "concurrent modification of the index-N file, expected current generation ["
                listener.onResponse(loaded);  
            );
        if (blobName.startsWith(SHALLOW_SNAPSHOT_PREFIX)) {
                    snapshotIds = entry.getValue();  
 * software distributed under the License is distributed on an
                @Override  
        );  
            final long finalBestGen = Math.max(bestGenerationFromCS, metadata.generation());  
        );
                                        shardContainer
                        listener  
            );  
                    if (seedRead.equals(seed) == false) {  
        final List<String> toDelete = new ArrayList<>();
    public static final String INDICES_DIR = "indices";  
    );  
                metadata.name(),  
        snapshotRateLimiter = getRateLimiter(SNAPSHOT_BYTES_PER_SEC_SETTING, metadata.settings());  
        return maybeRateLimit(stream, () -> snapshotRateLimiter, snapshotRateLimitingTimeInNanos, BlobStoreTransferContext.SNAPSHOT);  
                removeSnapshotsPinnedTimestamp(
                "concurrent modification of the index-N file, expected current generation ["
            // bubbling up and breaking the snapshot functionality.
    private ShardInfo getShardInfo(Optional<String> highestGenShardPaths, Map<String, ShardInfo> idToShardInfoMap, String indexId) {
    // shallow-snap-UUID files. And if it is null, we just delete the stale shard blobs.
                    @Override
            logger.warn(new ParameterizedMessage("[{}] Exception during cleanup of root level blobs", metadata.name()), e);  
                    Priority.NORMAL,
            markRepoCorrupted(safeGeneration, exception, new ActionListener<Void>() {  
                listener.onResponse(newRepositoryData);  
                            allShardsListener.onResponse(
            this.blobsToDelete = blobsToDelete;
        }
    }
    }  
                                blobStoreIndexShardSnapshots = BlobStoreIndexShardSnapshots.EMPTY;
                inner.addSuppressed(e);  
            // snapshot would have a different UUID and hence a new unique shallow-snap-N file will be created.
            final BytesReference serialized;
                        // For fixed, the parts would look like [<base_path>,"indices","<index-id>","<shard-id>"]
    private void deleteFromContainer(BlobContainer container, List<String> blobs) throws IOException {
        assertSnapshotOrGenericThread();
                    String blobName = fileToDelete.v2();  
        CounterMetric metric,
            }  
                inputStream,
                        return null;  
                rootBlobContainer = this.rootBlobContainer.get();  
import org.opensearch.core.index.shard.ShardId;  
                snapshotEntries.add(entry.withRepoGen(newGen));
                    + "]",  
     */  
            cached = (softRef != null) ? softRef.get() : null;
        BlobStoreTransferContext context  
     * @param listener                      Listener to invoke once finished
            cleanupUnlinkedRootAndIndicesBlobs(
        return metadata;
        long lastFailedGeneration = RepositoryData.UNKNOWN_REPO_GEN;
            return storeStats.merge(sseStoreStats);  
    }
    private void logShardPathsOperationWarning(IndexId indexId, SnapshotId snapshotId, @Nullable Exception e) {  
            }));  
            () -> new ParameterizedMessage("[{}] Writing shard index [{}] to [{}]", metadata.name(), indexGeneration, shardContainer.path())
            this.indexId = indexId;
        RepositoryStats sseStoreStats = serverSideEncryptedStore != null ? new RepositoryStats(serverSideEncryptedStore.stats()) : null;  
    }
        compressor = COMPRESS_SETTING.get(metadata.settings())
                    // Cache the indices that were found before writing out the new index-N blob so that a stuck cluster-manager will never  
                                } else {
                    shardId,
                ) throws InterruptedException {
    }  
                }  
        );
                                    );
        RemoteStorePathStrategy remoteStorePathStrategy,  
                } else {
                : "indexShardSnapshot should be an instance of BlobStoreIndexShardSnapshot";
        long primaryTerm,
        // If shardInfoFromMap is null, return shardInfoFromPath (which could also be null)
        Function<ClusterState, ClusterState> stateTransformer,
                        }  
                    // We did not find the expected index-N even though the cluster state continues to point at the missing value
        if (bestEffortConsistency == false && cached != null && cached.v1() == latestKnownRepoGen.get()) {  
                }
                    "store location [" + blobStore() + "] is not accessible on the node [" + localNode + "]",
     * @param clusterService ClusterService  
        ActionListener<RepositoryData> listener
            null, // Passing null since no remote store lock files need to be cleaned up.
     * @param updatedRepoData               the new repository data after the deletion  
import org.opensearch.cluster.metadata.CryptoMetadata;  
                final long generation;
                )
                    cryptoMetadata  
        "allow_concurrent_modifications",  
            long indexTotalFileSize = 0;  
            return new Tuple<>(shardSnapshots, latest);
 * the Apache License, Version 2.0 (the "License"); you may
                    generation = latestIndexBlobId();  
    private RepositoryException corruptedStateException(@Nullable Exception cause) {
                            try {
        return restoreRateLimitingTimeInNanos.count();
import org.opensearch.index.snapshots.blobstore.RemoteStoreShardShallowCopySnapshot;
                    listener.onFailure(
        RepositoryData newRepoData,
        // Once we have put the new shard-level metadata into place, we can update the repository metadata as follows:  
    public RateLimiter remoteUploadRateLimiter() {
                }
            ),
                blobContainer = this.blobContainer.get();
            // time in a repository if cleanup is happening properly) and pick the index-N blob with the
                metadata.name(),
    }
    }  
    @Override  
    }
            try {
                        // We don't yet have this version of the metadata so we write it  
        try {
            Priority.NORMAL,
        ActionListener<RepositoryCleanupResult> listener
        long primaryTerm,
import java.util.Objects;
                final ActionListener<ShardSnapshotMetaDeleteResult> allShardsListener = new GroupedActionListener<>(
                                    indexOutput.writeBytes(buffer, 0, length);  
import org.opensearch.common.UUIDs;
        MAX_SNAPSHOT_BYTES_PER_SEC,
        RepositoryData updatedRepoData,  
                            deleteBlob = true;
                .filter(key -> !RELOADABLE_SETTINGS.contains(key))
            final SnapshotsInProgress snapshotsInProgress = state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY);  
     * Puts the given {@link RepositoryData} into the cache if it is of a newer generation and only if the repository is not using  
                        IndexId::getId,  
                    @Override  
        }  
    private List<String> getShardPaths(IndexId indexId, int shardCount) {
     * only written once and never overwritten.  The highest numbered index-N blob is the latest one  
                        + newGen  
    public static final Setting<PathType> SHARD_PATH_TYPE = new Setting<>(
        for (int i = 0; i < shardInfo.getShardCount(); i++) {
                // Deleting the shard blobs  
                try {  
     * {@code true}.  
                                snapshotUUID
            null,  
        Collection<SnapshotId> deletedSnapshots,  
            }
                        );
        clusterService.submitStateUpdateTask(  
                    listener,
     */  
            synchronized (lock) {  
                logger.debug("[{}] Cleaned up stale index [{}]", metadata.name(), indexSnId);
                            ExceptionsHelper.useOrSuppress(e, originalException)
    /**
            true,
                }
            return repositoryDataFromCachedEntry(cached);
                    }
        "metadata",
            } catch (Exception e) {  
    }
            }
                        indexOutput.close();  
        }
                            + blobStore()
                logger.trace("[{}] [{}] writing shard snapshot file", shardId, snapshotId);
                    snapshotIdsWithoutVersion.size()  
     * the cleanup is done per shard after releasing the lock files.  
                        allFilesListener.onResponse(null);
                // Finally, we delete the [base_path]/indexId folder  
                return new ShardSnapshotMetaDeleteResult(
        // Once we have updated the repository, run the clean-ups
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
            try (
            RemoteSegmentStoreDirectoryFactory remoteDirectoryFactory = new RemoteSegmentStoreDirectoryFactory(
                    + genToLoad
                    + "current generation is at least ["  
import java.util.Set;
                maxGenShardPath = shardPath;
     *
        @Nullable String shardStateIdentifier,
                            logger.warn("store cannot be marked as corrupted", e);
    );
    }  
     * Most cloud storage support upto 1000 key(s) deletion in single operation, thus keeping default value to be 1000.
            return listBlobsToGetLatestIndexId();  
                shardCountListener,  
                    repositoryStateId,
                        }
            if (indexIncrementalFileCount == 0) {  
                        + "] was not found in the shard metadata."
            final BlockingQueue<List<Tuple<BlobPath, String>>> staleFilesToDeleteInBatch = new LinkedBlockingQueue<>(subList);  
                                () -> new ParameterizedMessage(
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
     * @param repositoryMetadata   The metadata for this repository including name and settings
            );  
        }
                    deleteIndexMetadataListener.onResponse(null);
            // index.latest is not written atomically and is not immutable - on every index-N change,
     * maintains single lazy instance of {@link BlobContainer}
                compressor
                                )  
        private final String name;  
                        if (needsWrite) {
                }
            }
        }
                        e
    /**
import org.opensearch.index.store.lockmanager.FileLockInfo;  
        RepositoryData oldRepoData,
        Setting.Property.NodeScope  
            }  
    ) {
    public static final ChecksumBlobStoreFormat<BlobStoreIndexShardSnapshot> INDEX_SHARD_SNAPSHOT_FORMAT = new ChecksumBlobStoreFormat<>(
     */
                    @Override
    );  
        }
                    remoteStoreLockManagerFactory,
                );  
                BytesArray bytes = new BytesArray(seed);  
    private BlobPath indicesPath() {
    private volatile Compressor compressor;
                remoteDownloadRateLimitingTimeInNanos,  
            remoteDownloadRateLimitingTimeInNanos,
            }
            // Resolve CryptoMetadata once for all file uploads
        }
            // In this case, the generation points at the generation the repo will be in after the snapshot finishes so it may not yet  
                                forceClean  
            .build();  
        if (shardInfo == null) {
            null,  
                            lastSnapshotStatus.getIndexVersion(),
        RepositoryData existingRepositoryData,  
                            remoteSegmentStoreDirectoryFactory,
                remoteSegmentStoreDirectoryFactory,
        }  
                            new RepositoryException(metadata.name(), "Failed to execute cluster state update [" + source + "]", e)
        return deleteResult;
import org.opensearch.repositories.ShardGenerations;
                                existingFileInfo = fileInfo;
            final long previousBest = latestKnownRepoGen.getAndSet(metadata.generation());  
    private Set<String> writeNewIndexShardPaths(
    }
            // Don't use generation from the delete task if we already found a generation for an in progress snapshot.
        }  
            final StepListener<Collection<Integer>> shardCountListener = new StepListener<>();
                fileNames = new ArrayList<>(indexFilesToFileLengthMap.keySet());  
        int snapshotShardId,
import org.opensearch.repositories.RepositoryException;
                    shardGenerations,
        clusterService.submitStateUpdateTask(
            // instead of directly reading the index.latest blob to get the current index-N blob because
            repositoryMetaVersion,  
                if (isSystemRepository == false) {
    /**
                );  
                            metadata.name(),
        return (RemoteStoreShardShallowCopySnapshot) indexShardSnapshot;
        IndexId indexId = null;  
                        + latestKnownRepoGen.get()
        for (String blobName : rootBlobs) {
                    writtenGeneration,
                }
                remoteDownloadLowPriorityRateLimitingTimeInNanos,
                .map(s -> getIndexId(s.split("\\" + SnapshotShardPaths.DELIMITER)[0]))  
    private final AtomicLong latestKnownRepoGen = new AtomicLong(RepositoryData.UNKNOWN_REPO_GEN);  
                    }, onUpdateFailure)
            Version minNodeVersion = clusterService.state().nodes().getMinNodeVersion();  
        InputStream stream,  
    }
                                    "{} failed to delete shard data for shard [{}][{}]",
    ) throws IOException {
     * @param stateFilter               filter for the last cluster state update executed by this method
    long readSnapshotIndexLatestBlob() throws IOException {
import org.opensearch.repositories.RepositoryCleanupResult;  
                                if (useUUIDs) {  
     * @param settings        repository settings  
    /**  
                cleanupRedundantSnapshotShardPaths(updatedIndexIds);
        // First write the new shard state metadata (with the removed snapshot) and compute deletion targets  
                PathHashAlgorithm.fromCode(pathHashAlgorithm)
                    } catch (Exception ex) {
                        ),
                executeOneStaleIndexDelete(
        Map<String, Object> userMetadata,  
                            threadPool.info(ThreadPool.Names.SNAPSHOT).getMax(),
                            ),
        try {
     * @param repositoryMetaVersion         version of the updated repository metadata to write  
                }));  
        );  
        // If shardInfoFromPath is null, return shardInfoFromMap (which could also be null)
        return snapshotShardPaths.keySet()
        }
        setPendingStep.whenComplete(newGen -> threadPool().executor(ThreadPool.Names.SNAPSHOT).execute(ActionRunnable.wrap(listener, l -> {
        for (int shardId = 0; shardId < shardCount; shardId++) {  
        final long currentGen = repositoryData.getGenId();  
                        return updateRepositoryGenerationsIfNecessary(
                );
     * Cleans up remote store locks for a given index entry.
        new ChecksumBlobStoreFormat<>(SNAPSHOT_CODEC, SHALLOW_SNAPSHOT_NAME_FORMAT, RemoteStoreShardShallowCopySnapshot::fromXContent);  
                    ),
     * When set to {@code true}, {@link #bestEffortConsistency} will be set to {@code true} and concurrent modifications of the repository
                if (shardCount == 0) {  
        return repositoryMetadata;  
            listener
                    snapshotFile(snapshotFileInfo, indexId, shardId, snapshotId, snapshotStatus, store, cryptoMetadata);
                        shardBlob.getKey(),
import java.util.function.Consumer;
                final Collection<String> fileNames;
        BlobStore serverSideEncryptedStore = getBlobStore(true);  
                    "Could not find a readable index-N file in a non-empty shard snapshot directory [" + shardContainer.path() + "]"  
    /**
        Settings indexSettings = indexMetadata.getSettings();
    public static final String MAX_REMOTE_UPLOAD_BYTES_PER_SEC = "max_remote_upload_bytes_per_sec";  
     * @param remoteStoreLockManagerFactory RemoteStoreLockManagerFactory to be used for cleaning up remote store lock files  
                    testBlobContainer.writeBlob("data-" + localNode.getId() + ".dat", stream, bytes.length(), true);
    public static final String MAX_REMOTE_LOW_PRIORITY_UPLOAD_BYTES_PER_SEC = "max_remote_low_priority_upload_bytes_per_sec";
                public ClusterState execute(ClusterState currentState) {
                    this.blobContainer.set(blobContainer);
    /**
            listener  
        int maxGen = Integer.MIN_VALUE;  
        Priority repositoryUpdatePriority,  
        RemoteStoreLockManager remoteStoreMetadataLockManager = remoteStoreLockManagerFactory.newLockManager(  
        Map<String, ShardInfo> idToShardInfoMap
        return remoteDownloadRateLimitingTimeInNanos.count();
        final List<String> staleRootBlobs = staleRootBlobs(newRepoData, rootBlobs.keySet());
            final Exception exception = new RepositoryException(  
    }
     * @param snapshotShardPaths            Map of snapshot shard paths and their metadata
        updatedSnapshotsInProgress = changedSnapshots ? SnapshotsInProgress.of(snapshotEntries) : null;
            afterCleanupsListener.onFailure(e);
                if (snapshotShardPathBlobContainer == null) {
                    // Comparing the full metadata here on purpose instead of simply comparing the safe generation.  
    public static final String SHALLOW_SNAPSHOT_PREFIX = "shallow-snap-";
        Settings newSettings = newRepositoryMetadata.settings();
            .orElse(RepositoryData.EMPTY_REPO_GEN);
                    );
                    .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, blob)
                        metadata.name(),
                        timestampToUnpin,
            container.writeBlobAtomic(blobName, stream, bytesRef.length(), failIfAlreadyExists);
        ThreadPool threadpool,
            shardStateIdentifier,
    private long listBlobsToGetLatestIndexId() throws IOException {
     *                        used  
                groupedListener  
        Collection<ShardSnapshotMetaDeleteResult> result,  
 * {@link #createBlobStore()}.
            }
                return RepositoryData.EMPTY_REPO_GEN;
    private void executeOneFileSnapshot(
            }  
     * @param fileInfo      file to be snapshotted  
    }
                    return;
        // Slow path if we were not able to safely read the repository data from cache
     * IO buffer size hint for reading and writing to the underlying blob store.  
            remoteStoreSettings,  
    ) {  
        boolean forceClean
                rootBlobs,
        BlobContainer shardContainer,
        RepositoryShardId shardId,  
                        new ParameterizedMessage(  
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory
 * documentation of the package {@link org.opensearch.repositories.blobstore}.
    );
                // This is called once all operations have succeeded
    public RateLimiter snapshotRateLimiter() {
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory  
                new ParameterizedMessage(
                public ClusterState execute(ClusterState currentState) throws Exception {
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,  
                            expectedGen,  
                            + localNode  
            repositoryMetaVersion,  
     * Deletes shard data for the provided ShardInfo object.  
        Map<String, BlobMetadata> rootBlobs,
                String.valueOf(shardCount),
    }
    /**
        ShardSnapshotMetaDeleteResult(IndexId indexId, int shardId, String newGeneration, Collection<String> blobsToDelete) {
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory
                                ex
    // When remoteStoreLockManagerFactory is non-null, while deleting the files, lock files are also released before deletion of respective  
     * TODO: Add shard level cleanups
    /**
                    + "] but it was not found in the repository"
        try {
                                    ensureNotClosing(store);
                startTime,
        if (maxByteSize.getBytes() <= 0) {
            // Start as many workers as fit into the snapshot_deletion pool at once at the most
                            + "but failed to clean up their index folders",
            int indexTotalNumberOfFiles = 0;
        logger.trace(
                new RepositoryException(
                }
    /**
        Set<String> blobs,  
    public static final ConfigBlobStoreFormat<SnapshotShardPaths> SNAPSHOT_SHARD_PATHS_FORMAT = new ConfigBlobStoreFormat<>(
    private void cleanUpRemoteStoreFilesForDeletedIndicesV2(  
            .forEach(
    private static List<String> unusedBlobs(
                }
        }  
        MAX_SNAPSHOT_BYTES_PER_SEC,
    private static OffsetRangeInputStream maybeRateLimitRemoteTransfers(
        Version repositoryMetaVersion,  
import java.util.List;
            maybeWriteIndexLatest(newGen);
        if (staleRootBlobs.isEmpty()) {  
    private void markRepoCorrupted(long corruptedGeneration, Exception originalException, ActionListener<Void> listener) {  
                            ),
    );  
                    ),
                // remaining files for which it failed will be retried in next snapshot delete run.
                );
            assert indexShardSnapshot instanceof BlobStoreIndexShardSnapshot  
        long startTime = System.nanoTime();  
    private final RecoverySettings recoverySettings;  
                        }
            );
                        return super.read(b, off, len);
            listener.onFailure(new RepositoryException(metadata.name(), "cannot clone shard snapshot on a readonly repository"));
            // highest N value - this will be the latest index blob for the repository. Note, we do this  
                            } catch (IOException e) {
import org.opensearch.cluster.routing.allocation.AllocationService;  
import org.opensearch.index.store.StoreFileMetadata;
            );  
        Set<SnapshotId> survivingSnapshots,  
        } catch (IOException e) {
        Collection<SnapshotId> snapshotIds,  
    ) throws InterruptedException {
                // in the commit with files already in the repository
        if (filesToDelete == null) {
                // If we're running root level cleanup as part of a snapshot delete we should not log the snapshot- and global metadata
    }
                    listener.onFailure(
            try {  
                    }
        }
            final Map<String, BlobContainer> foundIndices = blobStore().blobContainer(indicesPath()).children();  
import java.util.concurrent.atomic.AtomicReference;
     * @return true/false based on repository type
    public static final String MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC = "max_remote_download_bytes_per_sec";
    }
    @Override
            }));
 * <p>
                            SNAPSHOT_FORMAT.blobName(snapshotId.getUUID()),
                } catch (Exception e) {
        RepositoryData oldRepoData,
    }
        DeflateCompressor.NAME.toLowerCase(Locale.ROOT),
                    + snapshotIds  
                listener.onFailure(new RepositoryException(metadata.name(), "Unexpected exception when loading repository data", e));
                }
            return snapshotShardPathBlobContainer().listBlobs();  
import java.util.Collections;
     * @param snapshotIds                   SnapshotIds to delete
                    String indexId = getIndexId(s.split("\\" + SnapshotShardPaths.DELIMITER)[0]);
            recoverySettings::recoveryRateLimiter,
        Collection<SnapshotId> snapshotIds,  
        return Collections.emptyList();
            // Currently this catch exists as a stop gap solution to tackle unexpected runtime exceptions from implementations  
                            ShardId shard = new ShardId(Index.UNKNOWN_INDEX_NAME, prevIndexMetadata.getIndexUUID(), shardId);
            final RepositoryData updatedRepoData = repositoryData.removeSnapshots(snapshotIds, builder.build());
                        }));
     */
        String threadPoolName,
     * @return A DeleteResult object representing the result of the deletion operation.  
        GroupedActionListener<Void> listener
            try {
        if (genToLoad > generation) {
        return maxThreshold;  
    public void endVerification(String seed) {  
     * Returns the blobContainer depending on the seed and {@code prefixModeVerification}.
                        return super.read();
    protected static long calculateMaxWithinIntLimit(long defaultThresholdOfHeap, long defaultAbsoluteThreshold) {  
                        );
                indexTotalNumberOfFiles,  
        // Retry loading RepositoryData in a loop in case we run into concurrent modifications of the repository.
                );
                        forceClean,
        final BlobContainer container = shardContainer(indexId, snapshotShardId);  
        final BlobContainer container = shardContainer(indexId, snapshotShardId);
                        remoteStoreRepoForIndex,  
import java.util.Optional;  
                    // We can cache serialized in the most recent version here without regard to the actual repository metadata version
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,  
                        continue;  
            // for this shard since the uuid named blob will simply not be referenced in case of error and thus we will never
                @Override
                            store.markStoreCorrupted(ex);
        ByteSizeValue.ZERO,
    }  
            return false;
                private void restoreFile(BlobStoreIndexShardSnapshot.FileInfo fileInfo, Store store) throws IOException {  
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
    }
            e
        RepositoryData updatedRepositoryData,
                            + genToLoad
    }  
     *     guarantees that another cluster is not writing to the repository at the same time</li>  
        RepositoryStats storeStats = store != null ? new RepositoryStats(store.stats()) : null;
                    // TODO apparently we don't use the MetadataSnapshot#.recoveryDiff(...) here but we should
     * @param expectedGen               expected repository generation at the start of the operation  
            );  
            );
     * @param deletedSnapshots              if this method is called as part of a delete operation, the snapshot ids just deleted or empty if called as  
                return;
                            .repository(remoteTranslogRepositoryName);  
        int workers,  
                .stream()
                    logger.warn(
                        + "] cannot be larger than ["  
            }
            // Write Global MetaData  
            final BlobPath indexPath = indexPath(entry.getKey());
        remoteDownloadLowPriorityRateLimiter = getRateLimiter(MAX_REMOTE_LOW_PRIORITY_DOWNLOAD_BYTES_PER_SEC_SETTING, metadata.settings());  
        final long startTime = threadPool.absoluteTimeInMillis();  
            } catch (IOException e) {
    public static final Setting<Boolean> PREFIX_MODE_VERIFICATION_SETTING = Setting.boolSetting(  
                if (bestEffortConsistency == false && ExceptionsHelper.unwrap(e, NoSuchFileException.class) != null) {
                        // TODO: Getting here means repository corruption. We should find a way of dealing with this instead of just
    @Override
                                final byte[] buffer = new byte[Math.toIntExact(Math.min(bufferSize, fileInfo.length()))];
                    final RepositoriesMetadata state = currentState.metadata().custom(RepositoriesMetadata.TYPE);
            indexUUID,
     * snapshots. This method is only to be called directly after a new {@link RepositoryData} was written to the repository and with
            listener.onResponse(deleteResult);
        }));
     * Releases remote store locks and performs cleanup for each shard blob.
                        + "]"
        return remoteDownloadRateLimiter;
            final byte[] tmp = new byte[Math.toIntExact(fileInfo.metadata().length())];
            }
import org.opensearch.common.xcontent.XContentFactory;
    /**  
                        ? RepositoryData.EMPTY_REPO_GEN  
    }
            allFilesUploadedListener.whenComplete(v -> {
            final BlobPath shardPath = shardPath(shardResult.indexId, shardResult.shardId);
                idToShardInfoMap
            );
                throw new IndexShardSnapshotFailedException(
                deletionEntries.add(entry);  
    }  
        Store store,
                        )
    }
                if (snapshotUUID.isPresent()) {
                try {
                );
                .collect(Collectors.toSet());  
                        eligibleFilesToDelete.add(blobPath.buildAsString() + blobName);  
    }
        Store store,
    public static final Setting<ByteSizeValue> SNAPSHOT_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(
                );
                    );
                indexUUID,
import org.opensearch.index.remote.RemoteStorePathStrategy.PathInput;
    /**  
                    try {  
                                .size() > 0) {
                    // updated repository data and state on the retry. We don't want to wait for the write to finish though  
            } catch (RepositoryException e) {
                inputStream,  
                executeOldShardGensCleanup(staleFilesToDeleteInBatch, groupedListener);  
        try (IndexInput indexInput = store.openVerifyingInput(file, IOContext.DEFAULT, fileInfo.metadata())) {
     */
    @Override
            // newSnapshotsList  
            } catch (Exception exp) {
            + repositoryStateId
    /**
            // snapshot delete run anyway.
    private volatile RateLimiter snapshotRateLimiter;  
                l.onFailure(e);  
    @Override
                            blob.substring(SNAPSHOT_PREFIX.length(), blob.length() - ".dat".length())
                            + "setting repository setting [{}] to [false]",  
 * For in depth documentation on how exactly implementations of this class interact with the snapshot functionality please refer to the  
            final BlockingQueue<Map.Entry<String, BlobContainer>> staleIndicesToDelete = new LinkedBlockingQueue<>();
                    BlobStoreIndexShardSnapshot.FileInfo existingFileInfo = null;  
    }
        return Optional.empty();
                    // because it could fail for any number of reasons so we just retry instead of waiting on the cluster state
            logger.trace(() -> new ParameterizedMessage("[{}] Writing [{}] to {} atomically", metadata.name(), blobName, container.path()));  
                                protected InputStream openSlice(int slice) throws IOException {  
    }  
                                .build()
                // If the source of the data is another remote snapshot (i.e. searchable snapshot) then no need to snapshot the shard
        long repositoryStateId,
                }
        String indexUUID = remoteStoreShardShallowCopySnapshot.getIndexUUID();
            .obsoleteShardGenerations(existingRepositoryData.shardGenerations())  
        ActionListener<String> listener  
     * @param newRepoData                   new repository data that was just written
            long userDefinedLimitBytes = userDefinedLimit.getBytes();  
        Map<String, BlobMetadata> rootBlobs,  
    private void removeSnapshotPinnedTimestamp(
            throw new SnapshotMissingException(metadata.name(), snapshotId, e);  
    }
                    }  
                            );  
                        )
        List<SnapshotFiles> newSnapshotsList = new ArrayList<>();
    public List<Setting<?>> getRestrictedSystemRepositorySettings() {
            } else if (Boolean.TRUE.equals(snapshotInfo.isRemoteStoreIndexShallowCopyEnabled())) {  
import org.apache.logging.log4j.Logger;
            return;
        Map.Entry<String, BlobContainer> indexEntry = staleIndicesToDelete.poll(0L, TimeUnit.MILLISECONDS);  
                    // EMPTY BlobStoreIndexShardSnapshots for updatedSnapshots which is used in unusedBlobs to compute stale files,
     */
                    ActionListener<Void> allFilesListener  
import java.util.concurrent.ConcurrentHashMap;  
        ActionListener<Void> listener,  
        Setting.Property.NodeScope  
        Collection<SnapshotId> deletedSnapshots,  
                            throw new IllegalStateException(
        MAX_REMOTE_LOW_PRIORITY_DOWNLOAD_BYTES_PER_SEC,  
                    metadata.name(),  
    public long getRestoreThrottleTimeInNanos() {  
            shardCountListener.whenComplete(counts -> {
            } else {
                final Store.MetadataSnapshot metadataFromStore;
                if (existingTargetFiles.isSame(sourceFiles)) {
        RepositoryData repositoryData,  
        Version repositoryMetaVersion,
    }  
    @Override
            }  
        );
                    "["
                                indexId.getName()
            l.onFailure(e);
        String source,
                metadata.name(),
                final String partName = fileInfo.partName(i);
import java.util.concurrent.atomic.AtomicInteger;
                idToShardInfoMap
            }
        return store::decRef;
    ) {  
        }  
        try {
        Collection<SnapshotId> deletedSnapshots,
            }  
    }
            listener.onFailure(new RepositoryException(metadata.name(), "cannot snapshot shard on a readonly repository"));
                                    SnapshotId::toString,
        long indexGeneration,  
                                                currentState.metadata()
        Version repositoryMetaVersion,
            // First inspect all known SegmentInfos instances to see if we already have an equivalent commit in the repository
     * This method combines files to be deleted from shard-level metadata and index-level metadata.  
                            + "] from repository contents but correct generation must be at least ["  
                if (len > repositoryDataCacheThreshold) {
                        shardId,
                indexId.getName(),  
                Function.identity(),  
            long indexIncrementalSize = 0;  
     * <ul>
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                .filter(s -> updatedShardPathsIndexIds.contains(s) == false)  
        try {
                throw new RepositoryVerificationException(
                            // two index-N blobs around.
                    ActionListener<Void> listener
            return false;
                        + "] but repository is at least at generation ["
                            );
    private List<String> findMatchingShardPaths(String indexId, Map<String, BlobMetadata> snapshotShardPaths) {  
            // illegal to delete a file while it is being read elsewhere (e.g. Windows). For read-only  
        }  
                    e  
    ) {
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,
                                    currentState.metadata()  
            blobName,
     * Setting to set repository as system repository  
            // We ignore all FileAlreadyExistsException when writing metadata since otherwise a cluster-manager failover  
                            + "] because a concurrent operation moved the current generation to ["  
            || Thread.currentThread().getName().contains('[' + ThreadPool.Names.SNAPSHOT + ']')
            }
            logger.warn(new ParameterizedMessage("Repository [{}] Failed to get the snapshot shard paths", metadata.name()), ex);
            // First, try listing all index-N blobs (there should only be two index-N blobs at any given
            groupedListener.onResponse(DeleteResult.ZERO);
        boolean changedDeletions = false;
            namedXContentRegistry
                }  
        cacheRepositoryData = CACHE_REPOSITORY_DATA.get(metadata.settings());
                    public int read() throws IOException {
            // Currently this catch exists as a stop gap solution to tackle unexpected runtime exceptions from implementations  
            logger.trace("[{}] [{}] writing shard snapshot file for clone", shardId, target);  
        return null;
        IndexCommit snapshotIndexCommit,
        }));
     * @param remoteStoreLockManagerFactory Factory for creating remote store lock managers
        "cache_repository_data",
        final String indexSnId = indexEntry.getKey();
        } catch (IOException ex) {
        }  
        return snapshot.getIndexShardSnapshotStatus();  
 * compatible open source license.
        Map<String, BlobMetadata> rootBlobs,
                return allSnapshotIds.contains(foundUUID) == false;  
    private void cleanupRedundantSnapshotShardPaths(Set<String> updatedShardPathsIndexIds) {  
    // package private, only use for testing  
    private static final class ShardSnapshotMetaDeleteResult {
                        indexSnId
        );
                                )  
     * path during repository verification.
            }  
    private void writeShardIndexBlobAtomic(
        try (IndexInput indexInput = store.openVerifyingInput(fileInfo.physicalName(), IOContext.READONCE, fileInfo.metadata())) {  
            final IndexShardSnapshotStatus.Copy lastSnapshotStatus = snapshotStatus.moveToFinalize(commitGeneration);
     * pending generation {@code P} while its safe generation {@code N} remains unchanged.  
                            foundIndices,  
                }
                existingSnapshots.withClone(source.getName(), target.getName()),
                for (String fileName : fileNames) {
import org.opensearch.repositories.RepositoryStats;
        ActionListener<RepositoryData> pinnedTimestampListener
        );
            synchronized (lock) {
     * @param repositoryStateId Expected repository generation  
                }
        }
    @Override  
        return getBlobStore(false);
import org.opensearch.common.lucene.Lucene;
            // Currently this catch exists as a stop gap solution to tackle unexpected runtime exceptions from implementations  
                            })) {
            }
        });
                            releaseRemoteStoreLockAndCleanup(shardId, snapshotUUID, shardContainer, remoteStoreLockManagerFactory);
        Setting.Property.NodeScope  
                logger.debug("[{}] Found stale index [{}]. Cleaning it up", metadata.name(), indexSnId);
     * the given list of blobs in the shard container.
                remoteStoreLockManagerFactory.getRepositoriesService(),
                }  
        BlobStoreTransferContext(String name) {
                    // directly in the shard level metadata in this case
                        @Override
        } catch (NoSuchFileException ex) {
        final int shardNum = shardId.shardId();
                                        RepositoryData.CORRUPTED_REPO_GEN,
                            }  
                                        shardContainer,
                            genInState,  
                    break;
            // No need to waste cycles, no operations can run against a read-only repository
        }
                        primaryTerm,  
            listener.onResponse(null);  
    }
        return Math.max(ByteSizeUnit.KB.toBytes(500), CACHE_MAX_THRESHOLD / 2);  
        return new Tuple<>(legacyIndex.v1(), String.valueOf(legacyIndex.v2()));
                return new DeleteResult(deletedBlobs.size(), deletedBlobs.stream().mapToLong(name -> rootBlobs.get(name).length()).sum());
    ) {  
                                ClusterState.builder(currentState)  
                );  
    public static final Setting<ByteSizeValue> BUFFER_SIZE_SETTING = Setting.byteSizeSetting(
                }
        deleteSnapshotsInternal(
                        )  
        isSystemRepository = SYSTEM_REPOSITORY_SETTING.get(metadata.settings());
            throw new AssertionError(e);
        );  
                        );
     *
        ShardInfo shardInfo,
            if (snapshotIdPinnedTimestampMap == null || snapshotIdPinnedTimestampMap.isEmpty()) {
            if (bestEffortConsistency) {
                    boolean deleteBlob = false;
                repository.getMetadata().name(),
                        + currentGen
     * Setting to set batch size of stale snapshot shard blobs that will be deleted by snapshot workers as part of snapshot deletion.
    ) {  
     * @return A list of tuples, each containing a blob path and the name of a blob to be deleted
                        onFailure.accept(e);  
                        new RepositoryException(
                            final long newGen;
        }  
    public static final Setting<Boolean> REMOTE_STORE_INDEX_SHALLOW_COPY = Setting.boolSetting("remote_store_index_shallow_copy", false);  
    }
        long previousGeneration,
                        Repository remoteTranslogRepository = remoteSegmentStoreDirectoryFactory.getRepositoriesService()
            final long newGen = setPendingStep.result();
                }
     */  
    @Override  
                    throw new RepositoryVerificationException(
import java.util.HashSet;
        );  
                        logger.info(
    public ThreadPool threadPool() {
                return RepositoryData.snapshotsFromXContent(parser, indexGen);
                            remoteTranslogCleanupAsync(
            ),
            snapshotIdPinnedTimestampMap,
        }  
                                        blobs,  
        supportURLRepo = SUPPORT_URL_REPO.get(metadata.settings());
    public static final Setting<ByteSizeValue> MAX_REMOTE_LOW_PRIORITY_DOWNLOAD_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(
            final BlobContainer shardContainer = shardContainer(index, shardNum);
                    ) {
                    listener.onFailure(
    private static String testBlobPrefix(String seed) {
        // Create a GroupedActionListener to aggregate the results of all unpin operations
                // Caching is not used with #bestEffortConsistency see docs on #cacheRepositoryData for details
                );
                    () -> RemoteSegmentStoreDirectory.remoteDirectoryCleanup(
                    compressor  
     *                                      delete operation
                    logger.info("[{}] Found stale root level blobs {}. Cleaning them up", metadata.name(), blobsToLog);
     */  
                        }
        return false;
                    || (blob.startsWith(UPLOADED_DATA_BLOB_PREFIX) && updatedSnapshots.findNameFile(canonicalName(blob)) == null)  
                } catch (IOException e) {  
                compressor
            }
        Collection<SnapshotId> deletedSnapshots,
                            prevIndexMetadata.getSettings()
     * @param remoteStoreLockManagerFactory Factory for creating remote store lock managers
    public InputStream maybeRateLimitRemoteDownloadTransfers(InputStream inputStream) {
        long repositoryStateId,
                    remoteSegmentStoreDirectoryFactory,  
                    lastFailedGeneration = genToLoad;
        final Tuple<BlobStoreIndexShardSnapshots, Long> legacyIndex = buildBlobStoreIndexShardSnapshots(blobs, shardContainer);
            // During the remote store node bootstrap, the cluster state is not initialised  
                startTime,
                        // For hashed_prefix, the parts would look like ["j01010001010",<base_path>,"indices","<index-id>","<shard-id>"]  
        BlobStoreTransferContext context  
                    } else {
        if (foundIndices.keySet().equals(survivingIndexIds)) {
            }
                            try {
        }
     * @param blobs      list of blobs in repository
        ByteSizeValue.ZERO,
        } else {
            if (snapshotIndexCommit != null) {  
    public static final ChecksumBlobStoreFormat<IndexMetadata> INDEX_METADATA_FORMAT = new ChecksumBlobStoreFormat<>(  
                false,
            if (blob.endsWith(".dat")) {
            .filter(
            paths.add(shardPath.buildAsString());
        long expectedGen,
                        IndexOutput indexOutput = store.createVerifyingOutput(
        METADATA_NAME_FORMAT,
                () -> remoteDownloadRateLimiter,
                    } finally {
     * the cleanup won't happen on retries in case of failures. This is because subsequent retries may
            listener.onResponse(newRepositoryData);
    public static final String SNAPSHOT_REPOSITORY_DATA_CACHET_THRESHOLD_SETTING_NAME = "snapshot.repository_data.cache.threshold";
    /**  
            for (int i = 0; i < workers; ++i) {  
        final RepositoryMetadata repositoryMetadataStart = metadata;  
import org.opensearch.common.metrics.CounterMetric;  
        IndexId indexId,  
        } catch (IOException e) {
        }  
                      // a V1 snapshot, per-format files (e.g., parquet/) would leak on cleanup; tracked as a known limitation.
import org.opensearch.index.translog.transfer.FileTransferTracker;
                        new BlobStoreIndexShardSnapshot(
     * @param remoteStoreLockManagerFactory RemoteStoreLockManagerFactory to be used for cleaning up remote store lock files.
    }  
            // operation ensuring that the snapshot name is available by checking the repository data. Also, the new clone snapshot would  
            assertSnapshotOrGenericThread();  
     *
                };
    /**  
            );  
        // Step 1: Set repository generation state to the next possible pending generation
import org.opensearch.index.snapshots.blobstore.SlicedInputStream;  
        false,
    );
                }  
            new FileRestoreContext(metadata.name(), shardId, snapshotId, recoveryState) {
     * @param repositoryUpdatePriority  priority for the cluster state update task  
                        success = true;
                final SoftReference<Tuple<Long, BytesReference>> softRef = latestKnownRepositoryData.get();
            }  
        SnapshotId snapshotId,
        if (prefixModeVerification == true  
                                prevIndexMetadata,
        threadPool.generic().execute(ActionRunnable.wrap(listener, this::doGetRepositoryData));  
    public void snapshotShard(  
    private Tuple<BlobStoreIndexShardSnapshots, Long> buildBlobStoreIndexShardSnapshots(Set<String> blobs, BlobContainer shardContainer)
    }  
                    onFailure.accept(exception);  
        cleanupStaleBlobs(
    public static final ChecksumBlobStoreFormat<SnapshotInfo> SNAPSHOT_FORMAT = new ChecksumBlobStoreFormat<>(
            // any updated version of the index or global metadata will be compatible with the segments written in this snapshot as well.
            final List<String> staleRootBlobs = staleRootBlobs(repositoryData, rootBlobs.keySet());  
            for (String indexId : uniqueIndexIds) {
     * @return tuple of BlobStoreIndexShardSnapshots and the last snapshot index generation  
                        for (int shardId = 0; shardId < prevIndexMetadata.getNumberOfShards(); shardId++) {  
 * ownership. Elasticsearch licenses this file to you under  
        deleteFromContainer(snapshotShardPathBlobContainer(), matchingShardPaths);
                                store.decRef();
     *
                throw new IndexShardSnapshotFailedException(shardId, "Store got closed concurrently");
     * shallow-snap-UUID blobs.
                    } catch (Exception e) {
            }, onUpdateFailure), 2 + indices.size());
                    );
            listener.onResponse(null);  
        final SnapshotsInProgress updatedSnapshotsInProgress;  
                        shardContainer,  
        SnapshotShardPathInput shardPathInput = new SnapshotShardPathInput.Builder().basePath(basePath())
                    return ClusterState.builder(currentState)
     * Calls the existing blobStore() method. Specific repositories can implement the support for
                    return ClusterState.builder(currentState)
                if (shardContainer.blobExists(INDEX_SHARD_SNAPSHOT_FORMAT.blobName(snapshotId.getUUID()))) {
                    public void onFailure(String source, Exception e) {  
     * {@link RepositoryMetadata#pendingGeneration()} than for {@link RepositoryMetadata#generation()} indicating a full cluster restart  
        Map<String, BlobContainer> foundIndices,
                final Optional<String> snapshotUUID = extractShallowSnapshotUUID(blob);
    }
            for (String indexMetaGeneration : indexMetaGenerations) {
    public String toString() {
            } else {
                        ActionListener.wrap(v -> listener.onFailure(corruptedStateException(e)), listener::onFailure)
    );
            return;
    public static final String SNAPSHOT_NAME_FORMAT = SNAPSHOT_PREFIX + "%s.dat";
                    public int read(byte[] b, int off, int len) throws IOException {
    protected volatile RepositoryMetadata metadata;
        pinnedTimestampListener.whenComplete(updatedRepoData -> {  
import static org.opensearch.common.unit.MemorySizeValue.parseBytesSizeValueOrHeapRatio;  
                                prevIndexMetadata.getIndexUUID(),  
                        store.directory().sync(Collections.singleton(fileInfo.physicalName()));
                    );
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
            // the index file was updated by a concurrent operation, so we were operating on stale
        Set<IndexId> indicesToUpdate = new HashSet<>(updatedRepositoryData.getIndices().values());
    }  
            } else {
        return Collections.emptyMap();
            // repositories, we read for index.latest, both because listing blob prefixes is often unsupported
    public static final String VIRTUAL_DATA_BLOB_PREFIX = "v__";
        final Metadata clusterMetadata,
        if (filesToDelete != null) {
        ActionListener<DeleteResult> listener,
     * Utility for atomically writing shard level metadata to a numeric shard generation. This is only required for writing
            if (shardCount > maxGen) {  
            BlobContainer testBlobContainer = testContainer(seed);
    public long getLowPriorityRemoteUploadThrottleTimeInNanos() {
        }
                                remoteTranslogRepository,
        RemoteStoreLockManagerFactory remoteStoreLockManagerFactory,
        new ByteSizeValue(40, ByteSizeUnit.MB),  
                    idToShardInfoMap
    }
    }
        Collection<SnapshotId> snapshotIds,
                } else {  
        if (storeStats != null && sseStoreStats != null) {
            startTime,
                    threadPool().executor(ThreadPool.Names.SNAPSHOT)  
        return remoteUploadRateLimitingTimeInNanos.count();  
            INDEX_SHARD_SNAPSHOTS_FORMAT.write(
    private final SetOnce<BlobContainer> snapshotShardPathBlobContainer = new SetOnce<>();  
            );
    private volatile RateLimiter remoteDownloadRateLimiter;
            }
            indexMetadataEnabled,
        }
                        for (int i = 0; i < workers; ++i) {  
        Set<String> survivingSnapshotUUIDs,  
            repositoryMetaVersion,  
                            + "]"
                throw new RepositoryException(metadata.name(), "cannot run cleanup on readonly repository");
    );  
    private static Optional<String> extractShallowSnapshotUUID(String blobName) {  
        final boolean wasBestEffortConsistency = bestEffortConsistency;
 */
                            // If there are more than 1000 dangling index-N cleanup functionality on repo delete will take care of them.
                } else {
                    repositoryData,
                    );
                                    recoveryState.getIndex().addRecoveredBytesToFile(fileInfo.physicalName(), length);
                            }  
                            + "This might indicate that the store ["
        final StepListener<RepositoryData> filterRepositoryDataStep = new StepListener<>();
                            + "]",
        "",
                );
import org.opensearch.index.remote.RemoteStoreUtils;  
                    final String identifiers = IndexMetaDataGenerations.buildUniqueIdentifier(indexMetaData);  
        assert bestEffortConsistency == false;
                        }  
        try {  
     */
    private void doDeleteShardSnapshots(
                    final StoreFileMetadata md = metadataFromStore.get(fileName);
        updatedRepositoryData.shardGenerations()
            }
     * <ul>
                                        Metadata.builder(currentState.getMetadata())
        remoteStorePinnedTimestampService.unpinTimestamp(  
                // If there are matchingShardPaths, then we delete them after we have deleted the shard data.
     * Finds the shard path with the highest generation number from the given list of matching shard paths.
import org.opensearch.repositories.Repository;
            files.clear(); // Stop uploading the remaining files if we run into any exception
        if (cached != null && cached.v1() == genToLoad) {  
        }  
    @Override
        );
                    final Map<String, BlobContainer> foundIndices = blobStore().blobContainer(indicesPath()).children();
import static org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1;
    }  
            } else {
            return allKeys.stream().allMatch(key -> isSettingEqual(newSettings, currentSettings, key));  
                final Tuple<Long, BytesReference> cached = (softRef != null) ? softRef.get() : null;
                    logger.info("Timestamp {} unpinned successfully for snapshot {}", timestampToUnpin, snapshotId.getName());  
import org.opensearch.index.snapshots.IndexShardRestoreFailedException;
     * Retrieves the ShardInfo object based on the provided highest generation shard paths,
                writeAtomic(blobContainer(), INDEX_LATEST_BLOB, new BytesArray(Numbers.longToBytes(newGen)), false);  
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        long maxThreshold = calculateMaxWithinIntLimit(defaultThresholdOfHeap, defaultAbsoluteThreshold);
                    listener.onFailure(new RepositoryException(metadata.name(), "failed to delete snapshots " + snapshotIds, e));  
import org.opensearch.common.Numbers;
                            if (fileInfo.isSame(md)) {
        repoDataListener.whenComplete(existingRepositoryData -> {  
        SnapshotShardPaths.FILE_NAME_FORMAT  
        for (String shardPath : matchingShardPaths) {  
            if (snapshotStatus.isAborted()) {
    public long getRemoteUploadThrottleTimeInNanos() {
        } else {
                metadata.name(),
            INDEX_SHARD_SNAPSHOTS_FORMAT.serialize(updatedSnapshots, blobName, compressor, SNAPSHOT_ONLY_FORMAT_PARAMS),
        String remoteStoreRepoForIndex,
        return true;
            mayBeLogRateLimits(context, rateLimiterSupplier.get(), t);  
                try (InputStream stream = bytes.streamInput()) {
    }
        ActionListener<String> listener
                        if (snapshotStatus.isAborted()) {
        ActionListener<String> listener,
            final ActionListener<Integer> allShardCountsListener = new GroupedActionListener<>(
        // Note: If we fail updating any of the individual shard paths, none of them are changed since the newly created
                                    shardContainer,
                @Override
                ShardInfo shardInfo = getShardInfo(highestGenShardPaths, idToShardInfoMap, indexSnId);
        IndexId indexId,
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,  
     * For optimal performance the value of the setting should be equal to or close to repository's max # of keys that can be deleted in single operation  
        } catch (Exception e) {  
        GroupedActionListener<RepositoryData> groupedListener = new GroupedActionListener<>(
                                    newGen,
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
        final RepositoryMetadata repositoryMetadata,  
                    throw new SnapshotMissingException(metadata.name(), snapshotId.getName());
        long indexGeneration,
        logger.debug(new ParameterizedMessage("[{}] Deleted {} in {}ns", metadata.name(), container.path(), startTime - System.nanoTime()));
import java.util.concurrent.LinkedBlockingQueue;  
            return name;
        remoteUploadRateLimiter = getRateLimiter(MAX_REMOTE_UPLOAD_BYTES_PER_SEC_SETTING, metadata.settings());
                @Override
        Function<RepositoryData, ClusterStateUpdateTask> createUpdateTask,
                    state.custom(SnapshotDeletionsInProgress.TYPE, SnapshotDeletionsInProgress.EMPTY).getEntries()
                    maybeRateLimitSnapshots(new InputStreamIndexInput(indexInput, partBytes))
                            GLOBAL_METADATA_FORMAT.blobName(snapshotId.getUUID()),
    protected final SetOnce<BlobStoreProvider> blobStoreProvider = new SetOnce<>();
            // have a different UUID and hence a new unique snap-N file will be created.
    public static final Setting<Boolean> READONLY_SETTING = Setting.boolSetting("readonly", false, Setting.Property.NodeScope);  
                    if (executedTask) {  
                        }));
                    blobContainer = blobStore().blobContainer(basePath());
    public static final String MAX_REMOTE_LOW_PRIORITY_DOWNLOAD_BYTES_PER_SEC = "max_remote_low_priority_download_bytes_per_sec";  
                allFilesUploadedListener.onResponse(Collections.emptyList());
                survivingIndexIds,
                    if (indexGeneration < 0L) {
        long latest = latestGeneration(blobs);
                    (shardId, oldGen) -> toDelete.add(shardPath(indexId, shardId).buildAsString() + INDEX_FILE_PREFIX + oldGen)  
                    snapshotId,  
import org.opensearch.repositories.IndexMetaDataGenerations;
            return Optional.of(blobName.substring(SHALLOW_SNAPSHOT_PREFIX.length(), blobName.length() - ".dat".length()));
            if (bestGenerationFromCS == RepositoryData.EMPTY_REPO_GEN) {
    private RepositoryMetadata getRepoMetadata(ClusterState state) {
        }
            if (snapshotInfo.getPinnedTimestamp() != 0) {
                            metadata.name(),
    @Override  
                filterRepositoryDataStep.onResponse(repositoryData);  
        remoteDownloadRateLimiter = getRateLimiter(MAX_REMOTE_DOWNLOAD_BYTES_PER_SEC_SETTING, metadata.settings());
        CounterMetric metric,
        try {
                            "Exception during cleanup of remote directory for snapshot [{}] deleted index [{}]",
                }
     * @param rootBlobs         Blobs at the repository root
                            repositoryData,
                    }  
 */
     */
        RepositoryShardId shardId,  
                    return;
        DeleteResult deleteResult = container.delete();  
            AtomicInteger counter = new AtomicInteger();
            maybeRateLimit(  
        return compressor;  
        final ActionListener<RepositoryData> listener
    }
        if (isReadOnly()) {
        return new DeleteResult(matchingShardPaths.size(), totalBytes);  
        if (provider == null) {  
        MapperService mapperService,
        "system_repository",  
        return threadPool;  
        IndexId indexId,  
                        + source  
import org.opensearch.repositories.RepositoryData;
                    metadata.name(),  
        CryptoMetadata cryptoMetadata  
                            .orElse(false))
            false
        }
        Store store,  
                    )
            final BlobContainer shardContainer = shardContainer(indexId, shardId);
    public static final Setting<ByteSizeValue> RESTORE_BYTES_PER_SEC_SETTING = Setting.byteSizeSetting(  
        IndexShardSnapshotStatus snapshotStatus,  
            }
            .shardId(String.valueOf(shardId))
            PathInput pathInput = PathInput.builder().basePath(basePath()).indexUUID(seed).build();
        logger.debug(
            return RepositoryData.EMPTY;
                        throw new AbortedSnapshotException();
        return blobStore(false);
                    + genToLoad
                            final Set<String> blobs = shardContainer.listBlobs().keySet();  
    /**
        }
     * {@link RepositoryMetadata#pendingGeneration()} is unchanged while its value for {@link RepositoryMetadata#generation()} is set to
                        // Just invoke the listener without any shard generations to count it down, this index will be cleaned up
                (indexId, gens) -> gens.forEach(
                    doDeleteShardSnapshots(  
        if (bestEffortConsistency) {
                    allMetaListener,
     * Prefix used for the identifiers of data blobs that were not actually written to the repository physically because their contents are  
    }
     * @param rootBlobs                     the blobs at the [base_path]
    }  
import org.opensearch.index.store.Store;
     * @param listener       completion listener
            ),
        } else if (extendedStoreStats != null) {
                                    blobStoreIndexShardSnapshots,  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService,  
            .max()
                        executor.execute(ActionRunnable.wrap(allFilesListener, filesListener -> {  
    );
                        pathStrategy.getType(),
                    if (blobName.startsWith(SHALLOW_SNAPSHOT_PREFIX)) {
                        + "] cannot be smaller than ["
            SnapshotFiles existingTargetFiles = null;  
            remoteStoreMetadataLockManger.cloneLock(  
                    shardCount
                sourceMeta.asClone(target.getName(), startTime, threadPool.absoluteTimeInMillis() - startTime),
            );
        Map<SnapshotId, Long> snapshotIdsPinnedTimestampMap,  
                }));
            || isReadOnly()
            writeIndexGen(
            final BlockingQueue<BlobStoreIndexShardSnapshot.FileInfo> filesToSnapshot = new LinkedBlockingQueue<>();
        PathType.FIXED.toString(),  
            || metadata.type().equals(newRepositoryMetadata.type()) == false
            int indexIncrementalFileCount = 0;
                // filtering files for which remote store lock release and cleanup succeeded,
        RemoteSegmentStoreDirectoryFactory remoteSegmentStoreDirectoryFactory,
            remoteStoreRepoForIndex,
                    // and use DELETED_SHARD_GEN since index-N file would not be present anymore.
    }  
    );
                @Override
                if (bestEffortConsistency == false && cached != null && cached.v1() == genToLoad) {
                .collect(
                        + "] bytes."
    }
            throw new RepositoryException(  
            // Step 3: Update CS to reflect new repository generation.
                            fileInfo.metadata(),
        final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT);  
            indexInput.readBytes(tmp, 0, tmp.length);
                    final BlobStoreIndexShardSnapshot.FileInfo fileToRecover = files.poll(0L, TimeUnit.MILLISECONDS);
    );
        String maxGenShardPath = null;
import org.opensearch.core.common.bytes.BytesReference;
                        + "] already"  
     */
        if (store.tryIncRef() == false) {  
    }  
        final ShardId shardId = store.shardId();  
                ThreadPool.Names.REMOTE_PURGE,  
            stateTransformer,
            );
        );
                    }
    private void logShardPathsOperationSuccess(IndexId indexId, SnapshotId snapshotId) {
            throw new SnapshotException(metadata.name(), snapshotId, "failed to read global metadata", ex);
                        pathStrategy,  
     * Controls the fixed prefix for the snapshot shard blob path.
                        throw new IndexShardSnapshotFailedException(shardId, "Failed to get store file metadata", e);
        Setting.Property.NodeScope
        if (extendedStoreStats != null && extendedSseStoreStats != null) {  
     */  
        return maybeRateLimit(
                    if (store.isClosing()) {
    @Override
                    + " with shard index ["
            maybeRateLimit(stream, () -> restoreRateLimiter, restoreRateLimitingTimeInNanos, BlobStoreTransferContext.SNAPSHOT_RESTORE),
                deletedSnapshots,  
        } catch (Exception e) {
                                                    .<RepositoriesMetadata>custom(RepositoriesMetadata.TYPE)  
     * @param repositoryMetadata RepositoryMetadata instance to derive the values from  
            rootBlobs,
                        ),
                            final BlobStoreIndexShardSnapshots blobStoreIndexShardSnapshots;
                if (sourceFiles != null && existingTargetFiles != null) {  
                    logger.warn("Resetting repository generation tracker because we failed to read generation [" + indexGen + "]", ioe);  
            BlobStoreTransferContext.REMOTE_UPLOAD  
import org.opensearch.core.compress.NotXContentException;
     * {@link RepositoryData#CORRUPTED_REPO_GEN}. In this state, the repository can not be used any longer and must be removed and
        throws IOException {
import org.opensearch.common.SetOnce;
                );
                            metadata.name(),  
                                        blobs,  
            return SNAPSHOT_FORMAT.read(blobContainer(), snapshotId.getUUID(), namedXContentRegistry);
     *
        return false;
    /**
            }  
                remoteStoreShardShallowCopySnapshot.getRemoteStorePathStrategy(),
            if (snapshots.snapshots().stream().anyMatch(sf -> sf.snapshot().equals(snapshotId.getName()))) {
        BlobStoreProvider provider = this.blobStoreProvider.get();
    private volatile RateLimiter remoteUploadRateLimiter;
    ) {
                }  
import org.opensearch.core.common.unit.ByteSizeUnit;  
                        "[{}] Failed to delete following blobs during snapshot delete : {}",  
            if (generation.equals(ShardGenerations.NEW_SHARD_GEN)) {
                        snapshotIdsPinnedTimestampMap,
                pinnedTimestamp,
                    writeShardMetaDataAndComputeDeletesStep.result(),
            final String indexGeneration;
                    deletedSnapshots,  
                }  
                "Failed to finalize snapshot deletion "
        }
                ActionRunnable.run(  
            DeleteResult deleteResult = DeleteResult.ZERO;
                            repositoryData,  
     * Executes the deletion of a single stale index.
        Setting.Property.NodeScope
        }
                throw new RepositoryException(
                            final BlobContainer shardContainer = shardContainer(indexId, finalShardId);
                .values()
                        @Override
            final BlockingQueue<List<String>> staleFilesToDeleteInBatch = new LinkedBlockingQueue<>(subList);  
public abstract class BlobStoreRepository extends AbstractLifecycleComponent implements Repository {
                    });
                repositoryData.indexMetaDataGenerations().indexMetaBlobId(snapshotId, index),
                            Collections.emptyMap()
    private static boolean assertFileContentsMatchHash(BlobStoreIndexShardSnapshot.FileInfo fileInfo, Store store) {
                indexCommitPointFiles = List.of();
        try (InputStream stream = bytesRef.streamInput()) {
        }
            snapshotsWithPinnedTimestamp.size()  
    }
     * {@code index-N} blob and there are no hard guarantees that a given repository generation won't be reused since an external
     */
            listener.onFailure(new RepositoryException(metadata.name(), "cannot snapshot shard on a readonly repository"));
        IndexMetadata indexMetadata
                0, // incremental File Size is zero as we are storing the data as part of remote store.
                }
        for (SnapshotsInProgress.Entry entry : state.custom(SnapshotsInProgress.TYPE, SnapshotsInProgress.EMPTY).entries()) {  
            || Thread.currentThread().getName().contains('[' + ThreadPool.Names.GENERIC + ']') : "Expected current thread ["  
                    String metaUUID = existingRepositoryData.indexMetaDataGenerations().getIndexMetaBlobId(identifiers);
                            final List<String> oldIndexN = LongStream.range(Math.max(Math.max(expectedGen - 1, 0), newGen - 1000), newGen)
    @Override
            // now create and write the commit point
                    }
                            md,
        } else {
import java.util.function.Function;  
        BlobStoreIndexShardSnapshots updatedSnapshots,
                        );
import org.opensearch.core.xcontent.XContentParser;
        ShardId shardId,
                    .filter(b -> blobNamesToIgnore.contains(b) == false)
        PathType pathType = PathType.fromCode(indexId.getShardPathType());
     */
        return snapshotRateLimiter;
                                    logger.isDebugEnabled()
    }
                        store.indexSettings().getUUID(),  
    private final Object lock = new Object();  
                throw new RepositoryException(
                final RepositoryData updatedRepositoryData = existingRepositoryData.addSnapshot(  
        if (isReadOnly()) {
    public void snapshotRemoteStoreIndexShard(  
    /**  
        private final IndexId indexId;
    public RateLimiter remoteUploadLowPriorityRateLimiter() {
    // Visible for testing
     * @return chunk size
    /***
                    if (deleteBlob) {
            }  
                        + expectedGen
     * @throws InterruptedException if the thread is interrupted while waiting  
            }
            .mapToLong(RepositoryOperation::repositoryStateId)  
     */
            return shardInfoFromMap;
            }
                e
    }
     *  
        );  
import org.opensearch.common.blobstore.BlobStore;  
            threadPool.executor(ThreadPool.Names.SNAPSHOT_DELETION).execute(ActionRunnable.wrap(listener, l -> {  
                Priority.NORMAL,
                                    snapshotIds,  
            foundIndices,  
        );
        Map<String, BlobMetadata> snapshotShardPaths,  
import org.opensearch.index.snapshots.blobstore.RateLimitingInputStream;
                );
                            + "] is not shared between this node and the cluster-manager node or "
        if (blobContainer == null) {  
                logger.debug("Updated repository generation from [{}] to [{}]", previousBest, metadata.generation());  
            metadata.name(),  
    boolean getPrefixModeVerification() {
        if (indexGen == RepositoryData.EMPTY_REPO_GEN) {
            // We don't need to check if there exists a shallow snapshot with the same name as we have the check before starting the clone
        try {
            final String generation = snapshotStatus.generation();
                    remoteStoreLockManagerFactory,
            return false;  
    public void executeConsistentStateUpdate(  
            snapshotIds,  
                    }, () -> filterRepositoryDataStep.onResponse(repositoryData.withVersions(updatedVersionMap))),
                            lastSnapshotStatus.getStartTime(),  
            // read-only, it is possible that we try deleting the index.latest blob while it is being read
    }
                remoteStorePinnedTimestampService,
                final IndexShardSnapshotStatus.Copy lastSnapshotStatus = snapshotStatus.moveToFinalize(snapshotIndexCommit.getGeneration());
                        new RepositoryException(metadata.name(), "Could not determine repository generation from root blobs", ioe)  
                genToLoad = latestKnownRepoGen.updateAndGet(known -> Math.max(known, generation));
    private RateLimiter getRateLimiter(Setting<ByteSizeValue> bytesPerSecSetting, Settings settings) {  
            assert false : e;
            shardId,  
     * url-repository.
            int pathHashAlgorithm = FNV_1A_COMPOSITE_1.getCode();
                        BytesReference.bytes(loaded.snapshotsToXContent(XContentFactory.jsonBuilder(), Version.CURRENT, minNodeVersion)),
                BlobContainer testContainer = testContainer(seed);  
    );  
    private boolean ensureSafeGenerationExists(long safeGeneration, Consumer<Exception> onFailure) throws IOException {  
    private Tuple<BlobStoreIndexShardSnapshots, String> buildBlobStoreIndexShardSnapshots(
            }  
        ActionListener<Collection<ShardSnapshotMetaDeleteResult>> onAllShardsCompleted  
                listener.onFailure(e);
        try {
            return sseStoreStats;
        } catch (NoSuchFileException ex) {  
        RemoteStoreShardShallowCopySnapshot remoteStoreShardShallowCopySnapshot = REMOTE_STORE_SHARD_SHALLOW_COPY_SNAPSHOT_FORMAT.read(
                    )
            null, // Passing null since no remote store lock files need to be cleaned up.  
            logger.trace("[{}] [{}] writing shard snapshot file", shardId, snapshotId);
        return new RateLimitingInputStream(stream, rateLimiterSupplier, (t) -> {
            afterCleanupsListener.onResponse(null);
                        indexCommitPointFiles.add(existingFileInfo);
            for (int i = 0; i < workers; ++i) {
            this.name = name;  
        SnapshotId target,
            // debug log it. Any blobs leaked as a result of an inconsistent listing here will be cleaned up in a subsequent cleanup or  
                return;  
                );
                            // Index-N file would be present if snapshots other than shallow snapshots are present for this shard
                    () -> SNAPSHOT_FORMAT.write(snapshotInfo, blobContainer(), snapshotId.getUUID(), compressor)
                logger.warn(
            return provider.getBlobStore(isServerSideEncryptionEnabled);
        "snapshots",  
        BlobStore store = getBlobStore(false);
            // build a new BlobStoreIndexShardSnapshot, that includes this one and all the saved ones  
            Map<String, ShardInfo> idToShardInfoMap = repositoryData.getIndices()
            final Map<String, String> indexMetaIdentifiers = ConcurrentCollections.newConcurrentMap();  
                shardContainer,  
        }
        SnapshotId snapshotId,
        final Executor executor = threadPool.executor(ThreadPool.Names.SNAPSHOT_DELETION);  
    @Override
        final BlobStoreIndexShardSnapshot.FileInfo snapshotFileInfo = filesToSnapshot.poll(0L, TimeUnit.MILLISECONDS);
     * Lastly, the {@link RepositoryMetadata} entry for this repository is updated to the new generation {@code P + 1} and thus
                }
            });
        }  
                            Metadata.builder(currentState.metadata())  
        readOnly = READONLY_SETTING.get(metadata.settings());
                    final Map<String, BlobMetadata> rootBlobs = blobContainer().listBlobs();
                        indexMetaIdentifiers.put(identifiers, metaUUID);  
import org.opensearch.snapshots.SnapshotInfo;
    private final SetOnce<BlobContainer> rootBlobContainer = new SetOnce<>();
                logger.warn("Failed to serialize repository data", e);  
                @Override
        }  
                    afterCleanupsListener  
        final String file = fileInfo.physicalName();
                    deleteIndexMetadataListener,  
    private RepositoryData safeRepositoryData(long repositoryStateId, Map<String, BlobMetadata> rootBlobs) throws IOException {
import java.util.Collection;
        // If the provided ShardInfo is null, return a zero DeleteResult
            final ActionListener<Void> allMetaListener = new GroupedActionListener<>(ActionListener.wrap(v -> {
     */
                    );
    }  
            IndexShardSnapshot indexShardSnapshot = loadShardSnapshot(shardContainer, source);  
        IndexShardSnapshot indexShardSnapshot = loadShardSnapshot(container, snapshotId);
                    updatedRepositoryData,
        final StepListener<RepositoryData> pinnedTimestampListener = new StepListener<>();  
                    return REMOTE_STORE_SHARD_SHALLOW_COPY_SNAPSHOT_FORMAT.read(
        Map.Entry<String, BlobContainer> indexEntry,  
                                    ).v1();  
                    indexTotalFileSize += md.length();
        if (blobsToDelete.isEmpty()) {
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        final ShardId shardId = store.shardId();
    /**
     */  
import org.opensearch.repositories.RepositoryVerificationException;  
                return DeleteResult.ZERO;  
                void ensureNotClosing(final Store store) throws AlreadyClosedException {
     * <p>
                    }  
                    }  
                            "Seed read from master.dat was [" + seedRead + "] but expected seed [" + seed + "]"  
    ) {
