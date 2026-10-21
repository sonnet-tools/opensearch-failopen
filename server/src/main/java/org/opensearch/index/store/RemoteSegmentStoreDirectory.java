            } catch (Exception e) {
    private String getNewRemoteSegmentFilename(String localFilename) {
                nodeId
     * @throws IOException         will be thrown in case i) listing lock files failed or ii) deleting the lock file failed.
     */
     * If vendor plugin supports uploading multiple parts in parallel, <code>BlobContainer#writeBlobByStreams</code>
    public void deleteStaleSegments(int lastNMetadataFilesToKeep) throws IOException {
        Executor executor,
            for (String file : segFiles) {
    // Visible for testing
            return false;
     * @param name the name of an existing file.
     * Non-null only when remoteDataDirectory is a DataFormatAwareRemoteDirectory.
        RemoteSegmentMetadata remoteSegmentMetadata = readMetadataFile(metadataFile);
     * @param listener          Listener to handle upload callback events
        } else if (isMergedSegmentPendingDownload(localFilename)) {
        this.formatBlobRouter = remoteDataDirectory.getFormatBlobRouter().orElse(null);
                try (IndexOutput indexOutput = storeDirectory.createOutput(metadataFilename, IOContext.DEFAULT)) {
     * We chose not to return cache entries for listAll as cache can have entries for stale segments as well.
        if (sortedMetadataFileList.size() <= lastNMetadataFilesToKeep) {
                        + Version.MIN_SUPPORTED_MAJOR
                                ).major
            METADATA_FILES_TO_FETCH
     * Any segment file that is uploaded without corresponding metadata file will not be visible as part of listAll().
    public static class UploadedSegmentMetadata {
            sortedMetadataFileList.indexOf(metadataFilesEligibleToDelete.get(0)),
     *
import org.apache.lucene.store.IndexOutput;
        long fileLength,
                ((RemoteStoreMetadataLockManager) mdLockManager).fetchLockedMetadataFiles(MetadataFilenameUtils.METADATA_PREFIX)
            String primaryTermAndGen = String.join(SEPARATOR, tokens[1], tokens[2], tokens[3]);
        ShardId shardId,
        }
            MetadataFilenameUtils.METADATA_PREFIX,
                        "Exception while deleting segment files corresponding to metadata file {}. Deletion will be re-tried",
            Map<String, UploadedSegmentMetadata> segmentMetadataMap = readMetadataFile(metadataFile).getMetadata();
    @PublicApi(since = "2.3.0")
        // Register format for each pending segment in the format cache
import org.apache.lucene.codecs.CodecUtil;
        RemoteSegmentMetadata remoteSegmentMetadata = null;
        long translogGeneration,
     * @param segmentFiles         List of segment files for which the Lucene major version is needed
        Directory storeDirectory,
                logger.error("Exception occurred while scheduling deleteStaleCommits", e);
            String nodeId,
                this.writtenByMajor = writtenByMajor;
     * after this are sufficient to compute the list of active or non-deletable segment files referenced by a deletable
            logger.trace("Reading latest Metadata file {}", latestMetadataFile);
        for (String file : metadataFiles) {
    @Override
        } catch (Exception e) {
                RemoteSegmentMetadata.CURRENT_VERSION,
    private Map<String, Integer> getSegmentToLuceneVersion(Collection<String> segmentFiles, SegmentInfos segmentInfosSnapshot) {
        }
    }
    /**
     *
    }
    public RemoteSegmentMetadata initializeToSpecificCommit(long primaryTerm, long commitGeneration, String acquirerId) throws IOException {
     * @param src               File to be uploaded
        String remoteFilename = getNewRemoteSegmentFilename(dest);
    }
        synchronized (this) {
     * @throws IOException in case of I/O error while uploading the metadata file
                            replicationCheckpoint
        for (int idx = lastNMetadataFilesToKeep; idx < sortedMetadataFiles.size(); idx++) {
    }
    }
     * Initializes the cache to a specific commit which keeps track of all the segment files uploaded to the
        }
        if (remoteFilename != null) {
import java.util.Set;
import org.apache.lucene.store.IndexInput;
        if (formatBlobRouter == null) {
        if (metadataFilesEligibleToDelete.isEmpty()) {
     * Each segment file is uploaded with unique suffix.
        for (SegmentCommitInfo segmentCommitInfo : segmentInfosSnapshot) {
     * remote segment store.
            }
                    + primaryTerm
                tryAndDeleteLocalFile(metadataFilename, storeDirectory);
    @Override
                RemoteSegmentMetadata metadata = metadataStreamWrapper.readStream(new ByteArrayIndexInput(file, bytes));
     */
            return formatBlobRouter.containerFor(format).path().buildAsString();
                tryAndDeleteLocalFile(metadataFilename, storeDirectory);
     * Parses the provided SegmentInfos to retrieve a mapping of the provided segment files to
    @Override
        return FileMetadata.parseDataFormat(originalFilename);
            mdLockManager.delete();
            if (writtenByMajor <= Version.LATEST.major && writtenByMajor >= Version.MIN_SUPPORTED_MAJOR) {
    public RemoteSegmentMetadata init() throws IOException {
        ) {
    }
    private static final VersionedCodecStreamWrapper<RemoteSegmentMetadata> metadataStreamWrapper = new VersionedCodecStreamWrapper<>(
    private final FormatBlobRouter formatBlobRouter;
        // For ex:
        CatalogSnapshot catalogSnapshot,
            1
    }
            String latestMetadataFile = metadataFiles.get(0);
                        }
     * Each metadata file contains a map where
     * Delete segment file from remote segment store.
                    segmentToLuceneVersion.put(file, segmentToLuceneVersion.get(segmentInfoFileName));
                RemoteStoreUtils.invertLong(primaryTerm),
        ThreadPool threadPool,
                "Expected exactly one metadata file matching timestamp: " + timestamp + " but got " + lockedMetadataFiles
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = (RemoteSegmentStoreDirectory) remoteDirectoryFactory.newDirectory(
 * A RemoteDirectory extension for remote segment store. We need to make sure we don't overwrite a segment file once uploaded.
            }
     *
            throw new NoSuchFileException(name);
        List<String> metadataFiles = remoteMetadataDirectory.listFilesByPrefixInLexicographicOrder(
            metadataFilesEligibleToDelete,
     * @param acquirerId  Lock Acquirer ID which wants to acquire lock on the commit.
    private final AtomicLong metadataUploadCounter = new AtomicLong(0);
     * Read the latest metadata file to get the list of segments uploaded to the remote segment store.
                            UploadedSegmentMetadata metadata = segmentsUploadedToRemoteStore.get(file);
        }
            return Long.toString(CodecUtil.retrieveChecksum(indexInput));
        RemoteDirectory remoteDataDirectory,
                }, listener, lowPriorityUpload, cryptoMetadata);
    public RemoteSegmentMetadata readLatestMetadataFile() throws IOException {
     * remoteDataDirectory is used to store segment files at path: cluster_UUID/index_UUID/shardId/segments/data
        } catch (Exception e) {
        SegmentInfos segmentInfosSnapshot,
        // Fallback for non-optimized indices (backward compatibility)
         * if they were written by an incompatible Lucene version.
        } catch (IOException e) {
import org.apache.lucene.store.FilterDirectory;
     */
    /**
        public static Tuple<String, String> getNodeIdByPrimaryTermAndGen(String filename) {
                );
     * @throws IOException         in case of I/O error
     *
    @Deprecated
    }
    }
        return pendingDownloadMergedSegments != null && pendingDownloadMergedSegments.containsKey(localFilename);
            sortedMetadataFileList,
                    e
        String remoteFilename = getExistingRemoteFilename(name);
import java.util.concurrent.atomic.AtomicLong;
                    Map<String, Integer> segmentToLuceneVersion = getSegmentToLuceneVersion(segmentFiles, segmentInfosSnapshot);
     * (1) if a segment file is not present in a md file, it will never be present in any md file created after that, and
import org.opensearch.cluster.metadata.CryptoMetadata;
            logger.debug("Deleting file: " + filename);
                .filter(file -> activeSegmentRemoteFilenames.contains(file) == false)
     * format-aware checksum calculation.
                }
    Boolean isLockAcquired(String metadataFile) throws IOException {
    /** Shared helper for single format unregistration. */
    }
     * we just need to read the latest metadata file.
        }
            );
     *
     * Releases a lock which was acquired on given segment commit.
        RemoteDirectory remoteMetadataDirectory,
            activeSegmentFilesMetadataMap.putAll(segmentMetadataMap);
    @Override
     * @param context           IOContext to be used to open IndexInput of file during remote upload
        return segmentsUploadedToRemoteStore.size();
     * [REPLICA SHARD] Removes segments from the pending download list after they have been downloaded.
    }
            return dfasd.calculateUploadChecksum(file);
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
    public IndexOutput createOutput(String name, IOContext context) throws IOException {
     * Reads the latest N segment metadata files from remote store along with filenames.
        boolean forceClean,
                SEPARATOR,
    }
        mdLockManager.release(FileLockInfo.getLockInfoBuilder().withFileToLock(metadataFile).withAcquirerId(acquirerId).build());
    // Visible for testing
            metadataFiles,
        remoteDataDirectory.copyFrom(from, src, remoteFilename, context);
                            "Exception while deleting stale commits from remote segment store, will retry delete post next commit",
                return null;
            // Step 2: cleanup map + format cache AFTER the remote delete
    /**
    ) throws IOException {
    /**
        for (String metadataFile : metadataFilesToFilterActiveSegments) {
     */
     */
        if (formatBlobRouter != null) {
     * Once the segment is uploaded to remote segment store, update the cache accordingly.
            return;
    /**
        Set<String> deletedSegmentFiles = new HashSet<>();
        if (dfasd != null) {
     * @param localFilename filename of segment stored in local filesystem
     * @param generation  Commit Generation
            AtomicBoolean deletionSuccessful = new AtomicBoolean(true);
            return segmentsUploadedToRemoteStore.get(name).getLength();
        if (remoteSegmentMetadata != null) {
     *
        this(remoteDataDirectory, remoteMetadataDirectory, mdLockManager, threadPool, shardId, null);
            }
        return remoteSegmentMetadata;
    public static final int METADATA_FILES_TO_FETCH = 10;
                replicationCheckpoint.getPrimaryTerm(),
    private String getLocalSegmentFilename(String remoteFilename) {
        public static String getMetadataFilename(
     */
    /**
        }
            lastSuccessfulFetchOfPinnedTimestamps
     *
        }
                .collect(Collectors.toSet());
        if (remoteFilename == null) {
     * Each metadata filename is of format: PREFIX__PrimaryTerm__Generation__UUID
                // Update cache after successful batch deletion
import java.util.Collections;
    /**
        );
     */
                nodeId
     *
            try (InputStream inputStream = remoteMetadataDirectory.getBlobStream(file)) {
        }
        String remoteStoreRepoForIndex,
            remoteDataDirectory.delete();
    @Override
                .stream()
                segmentMetadataMap.values().stream().map(metadata -> metadata.uploadedFilename).collect(Collectors.toSet())
        Set<Long> pinnedTimestamps = new HashSet<>(pinnedTimestampsState.v2());
import org.opensearch.common.io.VersionedCodecStreamWrapper;
                    ByteBuffersDataOutput byteBuffersIndexOutput = new ByteBuffersDataOutput();
    /**
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
            MetadataFilenameUtils.METADATA_PREFIX,
            throw new NoSuchFileException(name);
        // Visible for testing
     * @param storeDirectory instance of local directory to temporarily create metadata file before upload
    }
        return Collections.unmodifiableMap(this.segmentsUploadedToRemoteStore);
    public void releaseLock(long primaryTerm, long generation, String acquirerId) throws IOException {
    /**
    // ═══════════════════════════════════════════════════════════════
     * @return Map of segment filename to uploaded filename with checksum
     * Returns list of all the segment files uploaded to remote segment store till the last refresh checkpoint.
import org.apache.logging.log4j.LogManager;
                        + writtenByMajor
            return this.length;
        if (segmentsUploadedToRemoteStore.containsKey(localFilename)) {
    /**
    public String getExistingRemoteFilename(String localFilename) {
     */
    public void deleteFile(String name) throws IOException {
                            UploadedSegmentMetadata metadata = segmentsUploadedToRemoteStore.get(file);
            );
        remoteDirectoryCleanup(remoteDirectoryFactory, remoteStoreRepoForIndex, indexUUID, shardId, pathStrategy, forceClean, null);
     * @param format the data format name (e.g., "parquet", "lucene")
                byte[] bytes = inputStream.readAllBytes();
import org.opensearch.common.CheckedFunction;
        }
            this.uploadedFilename = uploadedFilename;
        if (lastNMetadataFilesToKeep != 0 && RemoteStoreUtils.isPinnedTimestampStateStale()) {
        Directory storeDirectory,
                String.valueOf(writtenByMajor)
            return getMetadataFilename(
        }
     * If a {@link FormatBlobRouter} is configured, uses format-specific routing
        // before this and non-deletable md file after this to compute the active segment files.
     * @throws IOException if reading any metadata file fails
     * We upload a metadata file per refresh, but it is not unique per refresh. Refresh metadata file is unique for a given commit.
        pinnedTimestamps.add(pinnedTimestampsState.v1());
 *
        private final String originalFilename;
     * @param name the name of an existing file.
                System.currentTimeMillis()
                    } finally {
    /**
        pendingDownloadMergedSegments.putAll(localToRemoteFilenames);
     * Gets the checksum of a local file by delegating to the local directory's
        }
        }
    /**
import org.opensearch.core.action.ActionListener;
                    metadataStreamWrapper.writeStream(
     * the prior behaviour for callers that don't need data-format-aware routing.
            return null;
            String remoteFilename = pendingDownloadMergedSegments.remove(localFilename);
        static String getMetadataFilePrefixForCommit(long primaryTerm, long generation) {
                RemoteStoreUtils.invertLong(uploadCounter),
                .collect(Collectors.toList());
     */
            if (segmentToLuceneVersion.containsKey(file) == false) {
            sortedMetadataFileList,
            listener.onFailure(e);
        }
        segmentsUploadedToRemoteStore.put(localFilename, metadata);
                // Batch delete all stale segment files
                        + ")."
        metadataFilesEligibleToDelete = RemoteStoreUtils.filterOutMetadataFilesBasedOnAge(
     * @param catalogSnapshot      CatalogSnapshot containing segment metadata (either SegmentInfos-backed or Composite)
                canDeleteStaleCommits.set(true);
    /**
            for (Map.Entry<String, String> entry : pendingDownloadMergedSegments.entrySet()) {
            logger.trace("No metadata file found, this can happen for new index with no data uploaded to remote segment store");
     * @throws IOException if the file exists but could not be deleted.
package org.opensearch.index.store;
                            e
                    metadataStreamWrapper.writeStream(
        syncBlobFormatCache();
import org.apache.lucene.store.IOContext;
        } else {
     */
    }
        String metadataFilePrefix = MetadataFilenameUtils.getMetadataFilePrefixForCommit(primaryTerm, commitGeneration);
     * @param nodeId node id
    }
            );
            allLockFiles
    /**
            );
    }
                            throw new NoSuchFileException(file);
            } catch (IOException e) {
            long primaryTerm,
        Set<String> implicitLockedFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(
        return remoteDataDirectory.getBlobContainer().path().buildAsString();
    Set<String> getMetadataFilesToFilterActiveSegments(
    // Visible for testing
     */
 * a unique suffix is added to the uploaded segment file. This class keeps track of filename of segments stored
     */
                "Metadata file is not present for given primary term " + primaryTerm + " and generation " + generation
import org.opensearch.core.index.shard.ShardId;
            boolean uploaded = false;
        private final long length;
            .collect(Collectors.toList());
import org.opensearch.index.store.lockmanager.FileLockInfo;
            replaceUploadedSegments(Collections.emptyMap());
     */
     * This acquires a lock on a given commit by creating a lock file in lock directory using {@code FileLockInfo}
     *
                RemoteStoreUtils.invertLong(generation)
            );
        } else {
        String remoteFilename = getExistingRemoteFilename(name);
        return readLatestMetadataFile().getMetadata().keySet().toArray(new String[0]);
                RemoteStoreUtils.invertLong(translogGeneration),
            MetadataFilenameUtils.METADATA_PREFIX,
     *
     *
        RemoteStoreUtils.verifyNoMultipleWriters(metadataFiles, MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen);
                false,   // isWarmIndex
    private void syncBlobFormatCache() {
            Set<String> staleSegmentRemoteFilenames = staleSegmentFilesMetadataMap.values()
            this.originalFilename = originalFilename;
            replaceUploadedSegments(remoteSegmentMetadata.getMetadata());
        String indexUUID,
    @Override
        ) {
     * @param localFilename Local filename to check
     * This method calls {@link RemoteSegmentStoreDirectory#deleteStaleSegments(int)} in an async manner.
     * Backward-compatible 6-arg overload preserved for the 2.3.0 {@code @PublicApi} contract.
            } else {
    public void copyFrom(Directory from, String src, IOContext context, ActionListener<Void> listener, boolean lowPriorityUpload) {
     * @throws IOException If an I/O error occurs while reading the metadata file.
        Collection<String> segmentFiles,
     * @param nodeId               node id
        logger.debug("Start initialisation of remote segment metadata");
                if (file.equals(segmentInfosSnapshot.getSegmentsFileName())) {
import org.opensearch.common.annotation.InternalApi;
    public void deleteStaleSegmentsAsync(int lastNMetadataFilesToKeep) {
        ThreadPool threadPool,
     * @throws IOException if there were any failures in reading the metadata file
     * Visible for testing
        RemoteSegmentStoreDirectoryFactory remoteDirectoryFactory,
     * @throws IOException         in case of I/O error
import org.apache.lucene.index.SegmentCommitInfo;
import org.apache.logging.log4j.message.ParameterizedMessage;
    @Override
            replaceUploadedSegments(remoteSegmentMetadata.getMetadata());
                threadPool.executor(ThreadPool.Names.REMOTE_PURGE).execute(() -> {
     */
        }
        super(remoteDataDirectory);
        public static long getTimestamp(String filename) {
    }
            if (tokens.length < 8) {
            );
     * @param from              The directory for the file to be uploaded
        String metadataFile = getMetadataFileForCommit(primaryTerm, generation);
                replicationCheckpoint.getPrimaryTerm(),
    ) {
                RemoteStoreUtils.invertLong(generation),
     * @param acquirerId  Acquirer ID for which lock needs to be released.
        }
    public IndexInput openBlockInput(String name, long position, long length, IOContext context) throws IOException {
                "Stale segment deletion is disabled if cluster.remote_store.index.segment_metadata.retention.max_count is set to -1"
                String prevMetadata = (idx - 1) >= 0 ? sortedMetadataFiles.get(idx - 1) : null;
            MetadataFilenameUtils.getMetadataFilePrefixForCommit(primaryTerm, generation),
    private final Map<String, String> pendingDownloadMergedSegments;
    }
                        if (segmentsUploadedToRemoteStore.containsKey(file)) {
    public void uploadMetadata(
        if (remoteFilename != null) {
    private void unregisterFormatForBlob(String blobKey) {
    }
                                    catalogSnapshot.getFormatVersionForFile(metadata.originalFilename)
            return remoteDataDirectory.openBlockInput(remoteFilename, position, length, fileLength, context);
     * [REPLICA SHARD] Marks merged segments that are pending download from the remote store.
                translogGeneration,
     * @param src               File to be uploaded
        }
     * Even if we plan to delete stale segments from remote segment store, it will be a periodic operation.
    ) {
            UploadedSegmentMetadata metadata = new UploadedSegmentMetadata(values[0], values[1], values[2], Long.parseLong(values[3]));
    public void markMergedSegmentsPendingDownload(Map<String, String> localToRemoteFilenames) {
            Set<String> segFiles = info.files();
                false,   // isServerSideEncryptionEnabled
            MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen,
        return plainFilename + SEGMENT_NAME_UUID_SEPARATOR + UUIDs.base64UUID();
     *             indices route to {@link org.opensearch.index.store.remote.DataFormatAwareRemoteDirectory}
     * We mark segments as pending-download after receiving a MergedSegmentCheckpoint from the primary shard.
     * @throws IOException if there were any failures in reading the metadata file
            allLockFiles.addAll(
                    } catch (IOException e) {
    ) throws IOException {
                    () -> new ParameterizedMessage(
                RemoteSegmentMetadata.CURRENT_VERSION,
                        } else {
            return false;
     * Upload metadata file
                        } else {
                storeDirectory.sync(Collections.singleton(metadataFilename));
                            replicationCheckpoint
     * @throws NoSuchFileException when metadata file is not present for given commit point.
     * to keep the format cache in FormatBlobRouter in sync.
    }
     */
                        new RemoteSegmentMetadata(
                    byte[] segmentInfoSnapshotByteArray = byteBuffersIndexOutput.toArrayCopy();
     Only relevant for remote-store-enabled domains on replica shards
     * (e.g., "basePath/parquet/" for parquet files). Otherwise falls back to the base path.
import org.opensearch.cluster.metadata.IndexMetadata;
        ActionListener<Void> listener,
        // then the returned set will be (m3, m6, m9)
     * IMPORTANT: Call this AFTER the remote delete operation, not before,
        logger.debug(
            long translogGeneration,
        }
        String metadataFile = ((RemoteStoreMetadataLockManager) mdLockManager).fetchLockedMetadataFile(metadataFilePrefix, acquirerId);
                    Map<String, String> uploadedSegments = new HashMap<>();
        this.remoteMetadataDirectory = remoteMetadataDirectory;
        return isLockAcquired(metadataFile);
        String nodeId,
    private void tryAndDeleteLocalFile(String filename, Directory directory) {
    }
            }
            sortedMetadataFileList.subList(lastNMetadataFilesToKeep, sortedMetadataFileList.size())
    private final RemoteDirectory remoteMetadataDirectory;
     * @param count Number of recent metadata files to read (sorted by lexicographic order).
     * Format blob router for managing blob key → format reverse lookup cache.
        if (lastNMetadataFilesToKeep == -1) {
     * One metadata file is kept per commit (refresh updates the same file). To read segments uploaded to remote store,
                            RemoteSegmentMetadata.fromMapOfStrings(uploadedSegments),
                "there should be only one metadata file for given primary term "
            logger.warn("Exception while deleting: " + filename, e);
        RemoteSegmentStoreDirectoryFactory remoteDirectoryFactory,
        // The blob key should be "filename__UUID" (e.g., "_0.pqt__UUID"), not "parquet/_0.pqt__UUID".
import org.opensearch.index.engine.exec.coord.LuceneVersionConverter;
     * @param segmentInfosSnapshot SegmentInfos instance to parse
        Directory from,
            if (values.length < 5) {
                remoteSegmentStoreDirectory.deleteIfEmpty();
            return remoteDataDirectory.fileLength(remoteFilename);
        }
    }
                SEPARATOR,
        );
     *
            count
     * will be used, else, the legacy {@link RemoteSegmentStoreDirectory#copyFrom(Directory, String, String, IOContext)}
        );
     * Called by init(), initializeToSpecificCommit(), initializeToSpecificTimestamp().
     * Metadata of a segment that is uploaded to remote segment store.
            this.checksum = checksum;
 * remote segment store also keeps track of refresh checkpoints as metadata in a separate path which is handled by
        String remoteFilename = getExistingRemoteFilename(name);
     * @param localToRemoteFilenames Map of local filenames to their corresponding remote filenames
     * @param permits    node-wide budget bounding the number of prefetched parts in flight
import org.apache.lucene.index.SegmentInfos;
     to store localSegmentFilename -> remoteSegmentFilename mappings
        if (remoteSegmentMetadata != null) {
     * @param storeDirectory       instance of local directory to temporarily create metadata file before upload
        if (formatBlobRouter != null) {
                        )
import org.opensearch.index.IndexSettings;
    /**
        // For optimized indices, localFilename may be "format/filename" (e.g., "parquet/_0.pqt").
                metadataUploadCounter.incrementAndGet(),
     * @throws IOException in case of I/O error
        try (InputStream inputStream = remoteMetadataDirectory.getBlobStream(metadataFilename)) {
     * @return Map of the segment file to its Lucene major version
                            // DFA: writtenByMajor is best-effort — non-Lucene files collapse
        String remoteFilename = getExistingRemoteFilename(name);
     *             of DFA indices.
            }
        if (removed != null) {
            try {
    }
            long generation,
     */
    /**
import org.apache.lucene.index.SegmentInfo;
            logger.debug("No metadata files are eligible to be deleted based on lastNMetadataFilesToKeep and age");
/*
            long generation,
                logger.warn(
        mdLockManager.acquire(FileLockInfo.getLockInfoBuilder().withFileToLock(metadataFile).withAcquirerId(acquirerId).build());
                            uploadedSegments.put(file, metadata.toString());
            try {
import java.util.concurrent.ConcurrentHashMap;
    }
            this.length = length;
import java.util.HashMap;
    public IndexInput openParallelInput(
        for (Map.Entry<String, String> entry : localToRemoteFilenames.entrySet()) {
        Map<String, UploadedSegmentMetadata> activeSegmentFilesMetadataMap = new HashMap<>();
                String nextMetadata = (idx + 1) < sortedMetadataFiles.size() ? sortedMetadataFiles.get(idx + 1) : null;
            List<String> filesToDelete = staleSegmentRemoteFilenames.stream()
     */
        }
        String plainFilename = FileMetadata.parseFile(localFilename);
        RemoteSegmentMetadata.VERSION_ONE,
        return segmentToLuceneVersion;
     * @param filename: name of the file to be deleted
            return remoteDataDirectory.openInput(remoteFilename, fileLength, context);
    /*
    }
     * @param checksum      checksum of the segment file
     *
     * Copies an existing src file from directory from to a non-existent file dest in this directory.
    }
            } else {
        RemoteSegmentMetadata remoteSegmentMetadata = readMetadataFile(metadataFile);
                        removeUploadedSegment(getLocalSegmentFilename(file));
            throw new NoSuchFileException(
    }
                    + metadataFiles.size()
import org.opensearch.common.logging.Loggers;
        final Set<String> lockedMetadataFiles
     * versions and the serialized Lucene {@link org.apache.lucene.index.SegmentInfos} bytes
            return this.checksum;
     * @param context desired {@link IOContext} context
    // ═══════════════════════════════════════════════════════════════
    /**
                metadataUploadCounter.incrementAndGet(),
        }
        }
    public Map<String, RemoteSegmentMetadata> readLatestNMetadataFiles(int count) throws IOException {
        Set<String> lockedMetadataFiles = RemoteStoreUtils.getPinnedTimestampLockedFiles(
            logger.trace("Exception while deleting. Missing file : " + filename, e);
        // Visible for testing
     * Opens a stream for reading one block from the existing file and returns {@link RemoteIndexInput} enclosing
     * @param primaryTerm Primary Term of index at the time of commit.
        RemoteStorePathStrategy pathStrategy,
        }
        return remoteSegmentMetadata;
        RemoteDirectory remoteMetadataDirectory,
     * polymorphically; DFA snapshots embed the catalog in SegmentInfos userData so replicas
        private int writtenByMajor;
        IOContext context,
     */
        // Check last fetch status of pinned timestamps. If stale, return.
     * Refresh metadata files keep track of active segments for the shard at the time of refresh.
    ) {
 */
                segmentInfosSnapshot.getGeneration(),
    private String getChecksumOfLocalFile(Directory directory, String file) throws IOException {
        copyFrom(from, src, context, listener, lowPriorityUpload, null);
     * Returns the byte length of a segment file in the remote segment store.
        public static String getMetadataFilename(
     */
            }
    }
    /** Extract format from originalFilename. Returns "lucene" if no format prefix present. */
        if (metadataFiles.isEmpty()) {
     * Opens a stream for reading an existing file and returns {@link RemoteIndexInput} enclosing the stream.
     * Called by deleteFile(), deleteStaleSegments().
        public long getLength() {
    private Map<String, UploadedSegmentMetadata> segmentsUploadedToRemoteStore;
    }
    public String[] listAll() throws IOException {
     * Delegates to the 7-arg variant with a {@code null} {@link IndexMetadata} — equivalent to
            Integer.MAX_VALUE
                    segmentToLuceneVersion.put(file, segmentInfosSnapshot.getCommitLuceneVersion().major);
        String metadataFile = getMetadataFileForCommit(primaryTerm, generation);
    /**
                String.valueOf(length),
 * compatible open source license.
                    // Fallback to the Lucene major version of the respective segment's .si file
     * It is important to initialize this map on creation of RemoteSegmentStoreDirectory and update it on each upload and delete.
     * TODO: check if we can return read only RemoteSegmentStoreDirectory object from here.
                translogGeneration,
    /**
            } catch (Exception e) {
                        catalogSnapshotToCommitSerializer,
        } else {
     * @param segmentFiles         segment files that are part of the shard at the time of the latest refresh
    public long fileLength(String name) throws IOException {
     * if another instance of RemoteSegmentStoreDirectory is used to upload/delete segment files.
        UploadedSegmentMetadata removed = segmentsUploadedToRemoteStore.remove(localFilename);
    @Deprecated
        }
            registerFormatForBlob(entry.getValue(), entry.getKey());
                uploaded = remoteDataDirectory.copyFrom(from, src, remoteFileName, context, () -> {
            remoteSegmentMetadata = readMetadataFile(latestMetadataFile);
     */
        final Set<String> metadataFilesToFilterActiveSegments = getMetadataFilesToFilterActiveSegments(
        ShardId shardId
 * The OpenSearch Contributors require contributions made to
            int metadataVersion,
        public String getChecksum() {
     * @param replicationCheckpoint ReplicationCheckpoint of primary shard
        DataFormatAwareStoreDirectory dfasd = DataFormatAwareStoreDirectory.unwrap(directory);
     * Keeps track of local segment filename to uploaded filename along with other attributes like checksum.
        return metadataFilesToFilterActiveSegments;
        private final String uploadedFilename;
                        + ") and Version.MIN_SUPPORTED_MAJOR ("
                remoteSegmentStoreDirectory.delete();
     * @param translogGeneration   translog generation
     * will be called.
     * When null, format registration calls are no-ops (single-format index).
                        postUpload(from, src, remoteFileName, getChecksumOfLocalFile(from, src));
    /**
        logger.debug("Initialisation of remote segment metadata completed");
            MetadataFilenameUtils.METADATA_PREFIX,
                "Number of commits in remote segment store={}, lastNMetadataFilesToKeep={}",
        }
     * for each deletable md file, segments present in non-deletable md file before this and non-deletable md file
        }
            activeSegmentRemoteFilenames.addAll(
        public static UploadedSegmentMetadata fromString(String uploadedFilename) {
    public IndexInput openInput(String name, IOContext context) throws IOException {
                    for (String file : segmentFiles) {
                listener.onResponse(null);
     * @param primaryTerm Primary Term of index at the time of commit.
     * @throws NoSuchFileException if the file does not exist
    @ExperimentalApi
        this.threadPool = threadPool;
                    final byte[] segmentInfoSnapshotByteArray = catalogSnapshotToCommitSerializer.apply(catalogSnapshot);
                shardId,
        this.logger = Loggers.getLogger(getClass(), shardId);
        for (String metadataFile : metadataFilesToBeDeleted) {
import java.util.concurrent.Executor;
                        listener.onResponse(null);
                blobKeyToFormat.put(entry.getValue(), extractFormat(entry.getKey()));
     * <ul>
     *
    /**
        Map<String, RemoteSegmentMetadata> metadataMap = new LinkedHashMap<>();
            staticLogger.error("Exception occurred while deleting directory", e);
        }
        String remoteStoreRepoForIndex,
     * @throws IOException in case of I/O error while uploading the metadata file
                    }
     *
        }
            );
    private final Logger logger;
                pathStrategy,
     *       {@code calculateUploadChecksum()} which routes via the registry.</li>
        try (IndexInput indexInput = directory.openInput(file, IOContext.READONCE)) {
    }
                    // Polymorphic dispatch — no instanceof checks needed.
            return String.join(
            Map<String, UploadedSegmentMetadata> staleSegmentFilesMetadataMap = readMetadataFile(metadataFile).getMetadata();
    protected final AtomicBoolean canDeleteStaleCommits = new AtomicBoolean(true);
         * will be used to skip downloading the segment files unnecessarily
 * caller will be accessing segment files in the same way as {@code FSDirectory}. Apart from storing actual segment files,
                        metadataFile
    ) throws IOException {
     * @deprecated Use the 7-arg variant that accepts {@link IndexMetadata} so that DFA-enabled
     * AtomicBoolean that ensures only one staleCommitDeletion activity is scheduled at a time.
     *
                lastNMetadataFilesToKeep
     * will be called.
    /**
     */
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadataHandlerFactory;
     * Initializes the remote segment metadata to a specific timestamp.
        long fileLength = fileLength(name);
     */
     * the block stream.
     * Initializes the cache which keeps track of all the segment files uploaded to the remote segment store.
     *
    }
            throw new IllegalStateException(
     * It is important to match the checksum as the same segment filename can be used for different
            if (src.startsWith(IndexFileNames.SEGMENTS) == false) {
        return remoteSegmentMetadata;
     */
     * @param name       the name of an existing file
    private void addUploadedSegment(String localFilename, UploadedSegmentMetadata metadata) {
            String metadataFilename = MetadataFilenameUtils.getMetadataFilename(
        );
            return metadataStreamWrapper.readStream(new ByteArrayIndexInput(metadataFilename, metadataBytes));
     */
     *
                        }
     * @throws IOException         will be thrown in case i) listing file failed or ii) Writing the lock file failed.
     * Copies a file from the source directory to a remote based on multi-stream upload support.
        ReplicationCheckpoint replicationCheckpoint,
                if (prevMetadata != null && (lockedMetadataFiles.contains(prevMetadata) || idx == lastNMetadataFilesToKeep)) {
    public String getRemoteBasePath(String format) {
            if (lockedMetadataFiles.contains(sortedMetadataFiles.get(idx)) == false) {
    @Override
                RemoteStoreUtils.invertLong(primaryTerm),
        if (canDeleteStaleCommits.compareAndSet(true, false)) {
    private void postUpload(Directory from, String src, String remoteFilename, String checksum) throws IOException {
        }
     * @param name the name of the file to create.
     *
        boolean lowPriorityUpload,
        try {
     * Creates and returns a new instance of {@link RemoteIndexOutput} which will be used to copy files to the remote
        return remoteDataDirectory.openParallelInput(remoteFilename, fileLength, context, partSize, executor, permits);
/**
        Set<String> activeSegmentRemoteFilenames = new HashSet<>();
import org.opensearch.common.UUIDs;
     *
        return segmentsUploadedToRemoteStore.containsKey(localFilename)
        public String toString() {
        synchronized (this) {
            }
        long fileLength = fileLength(name);
     * @return segment filenames stored in remote segment store
        RemoteStoreLockManager mdLockManager,
     */
        );
        }
                            metadata.setWrittenByMajor(
            );
    }
                originalFilename,
    public boolean delete() {
                }
     *
                    for (String file : segmentFiles) {
     * will be used, else, the legacy {@link RemoteSegmentStoreDirectory#copyFrom(Directory, String, String, IOContext)}
            if (remoteFilename != null) {
     * Called after bulk replacement of segmentsUploadedToRemoteStore (init paths).
     * @param cryptoMetadata    CryptoMetadata for index-level encryption
        if (remoteFilename != null) {
        static long getGeneration(String[] filenameTokens) {
            if (deletionSuccessful.get()) {
                        indexOutput,
     * @param lastNMetadataFilesToKeep number of metadata files to keep
        }
            return RemoteStoreUtils.invertLong(filenameTokens[1]);
     * segments due to a concurrency issue.
     * <p>
    }
            && segmentsUploadedToRemoteStore.get(localFilename).checksum.equals(checksum);
                checksum,
                translogGeneration,
    Tries to delete shard level directory if it is empty
     * @param segmentInfosSnapshot SegmentInfos bytes to store as part of metadata file
        return delete();
     *
         * As part of the Lucene version compatibility check, this version information stored in the metadata
        IndexMetadata indexMetadata
        throw new NoSuchFileException(name);
    public boolean isMergedSegmentPendingDownload(String localFilename) {
     *
    }
     *
import java.util.HashSet;
        long lastSuccessfulFetchOfPinnedTimestamps = pinnedTimestampsState.v1();
                logger.error("Failed to parse segment metadata file", e);
        init();
                );
        long partSize,
import org.opensearch.index.remote.RemoteStoreUtils;
                nodeId,
                catalogSnapshot.getGeneration(),
    /**
                deletedSegmentFiles.addAll(filesToDelete);
import java.util.LinkedHashMap;
        // lockedMetadataFiles = m6, m7, m8, m9
                uploadedFilename,
            if (uploaded == false) {
    /**
 *
            );
    /**
        // Visible for testing
     * @param position block start position
        // sortedMetadataFiles = [m1, m2, m3, m4, m5, m6(locked), m7(locked), m8(locked), m9(locked), m10]
                    // if previous metadata of deletable md is locked, add it to md files for active segments.
        );
    }
        UploadedSegmentMetadata(String originalFilename, String uploadedFilename, String checksum, long length) {
     */
    public Boolean isLockAcquired(long primaryTerm, long generation) throws IOException {
    public void uploadMetadata(
                    // Each CatalogSnapshot subclass knows how to resolve Lucene versions for its files.
                        indexOutput,
            }
                        throw new RuntimeException("Exception in segment postUpload for file " + src, e);
     * @param generation  Commit Generation
        deleteStaleSegmentsAsync(0, ActionListener.wrap(r -> deleteIfEmpty(), e -> logger.error("Failed to cleanup remote directory")));
            );
            removeUploadedSegment(name);
     * </ul>
                    }
        }
     * can reconstruct it.
            MetadataFilenameUtils::getNodeIdByPrimaryTermAndGen
        );
    public void unmarkMergedSegmentsPendingDownload(Set<String> localFilenames) {
            }
    public void copyFrom(Directory from, String src, String dest, IOContext context) throws IOException {
            String[] filenameTokens = filename.split(SEPARATOR);
            pinnedTimestamps,
     */
                    }
            }
        if (lockedMetadataFiles.size() > 1) {
            "metadataFilesEligibleToDelete={} metadataFilesToBeDeleted={}",
                        listener.onFailure(e);
        static final String SEPARATOR = "::";
        } else {
    String getMetadataFileForCommit(long primaryTerm, long generation) throws IOException {
     *
            remoteDataDirectory.deleteFile(remoteFilename);
        }
            long creationTimestamp
        }
        }
     * @param localFilenames Set of local filenames to remove from pending downloads
        // lastNMetadataFilesToKeep = 3
    /**
        if (metadataFiles.isEmpty() == false) {
        return remoteSegmentMetadata;
     *   <li>Otherwise, falls back to Lucene's {@code CodecUtil.retrieveChecksum()} for
                try (IndexOutput indexOutput = storeDirectory.createOutput(metadataFilename, IOContext.DEFAULT)) {
        postUpload(from, src, remoteFilename, getChecksumOfLocalFile(from, src));
         */
            return originalFilename;
    }
     * @return The RemoteSegmentMetadata object corresponding to the specified timestamp, or null if no metadata file is found for that timestamp.
     * remoteMetadataDirectory is used to store metadata files at path: cluster_UUID/index_UUID/shardId/segments/metadata
            return new Tuple<>(primaryTermAndGen, nodeId);
     */
            logger.error("Exception while fetching segment metadata lock files, skipping deleteStaleSegments", e);
            logger.error("Exception occurred while deleting directory", e);
     * @param length block length
import java.util.Collection;
     * Contains utility methods that provide various parts of metadata filename along with comparator
        );
                for (String file : filesToDelete) {
        for (String localFilename : localFilenames) {
            remoteMetadataDirectory.delete();
         * The Lucene major version that wrote the original segment files.
        try {
        this.pendingDownloadMergedSegments = pendingDownloadMergedSegments;
                        deleteStaleSegments(lastNMetadataFilesToKeep);
        if (remoteSegmentMetadata != null) {
                sortedMetadataFileList.size(),
     * so that the format cache entry is still available during routing.
        @Nullable Map<String, String> pendingDownloadMergedSegments
    // Encapsulated map mutation APIs — keep format cache in sync
     * @param translogGeneration translog generation
    private final RemoteStoreLockManager mdLockManager;
import org.opensearch.index.store.lockmanager.RemoteStoreCommitLevelLockManager;
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
        CheckedFunction<CatalogSnapshot, byte[], IOException> catalogSnapshotToCommitSerializer
                }
import org.opensearch.common.annotation.PublicApi;
                copyFrom(from, src, src, context);
        this.segmentsUploadedToRemoteStore = new ConcurrentHashMap<>(newSegments);
import org.opensearch.common.collect.Tuple;
        }
     * @param context desired {@link IOContext} context
        new RemoteSegmentMetadataHandlerFactory(),
     * [REPLICA SHARD] Checks if a segment is a merged segment in pending-download state.
        if (metadataFiles.size() != 1) {
        }
     *
        String src,
        public void setWrittenByMajor(int writtenByMajor) {
     * As this cache is specific to an instance of RemoteSegmentStoreDirectory, it is possible that cache becomes stale
                .map(metadata -> metadata.uploadedFilename)
            logger.warn(() -> new ParameterizedMessage("Exception while uploading file {} to the remote segment store", src), e);
        ShardId shardId,
        String metadataFile = getMetadataFileForCommit(primaryTerm, generation);
    }
     * ({@link #replaceUploadedSegments}, {@link #addUploadedSegment}, {@link #removeUploadedSegment})
     * @param lastNMetadataFilesToKeep number of metadata files to keep
     * This map acts as a cache layer for uploaded segment filenames which helps avoid calling listAll() each time.
                            RemoteSegmentMetadata.fromMapOfStrings(uploadedSegments),
import java.util.stream.Collectors;
            return;
    public static void remoteDirectoryCleanup(
     * @throws IOException         will be thrown in case listing lock files failed.
        RemoteSegmentMetadata.CURRENT_VERSION,
                    String segmentInfoFileName = RemoteStoreUtils.getSegmentName(file) + ".si";
     * Rebuild format cache from both segmentsUploadedToRemoteStore and pendingDownloadMergedSegments.
        }
     *
    private final RemoteDirectory remoteDataDirectory;
    /**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
     * Try to delete file from local store. Fails silently on failures
        RemoteStorePathStrategy pathStrategy,
                METADATA_PREFIX,
                metadataMap.put(file, metadata);
                    } catch (Exception e) {
    /**
                    "Lucene major version supplied ("
                    // if next metadata of deletable md is locked, add it to md files for active segments.
        try {
        formatBlobRouter.replaceBlobFormatCache(blobKeyToFormat);
        if (lockedMetadataFiles.isEmpty()) {
            if (forceClean) {
        addUploadedSegment(src, segmentMetadata);
            String nodeId = tokens[5];
            try {
        ParallelDownloadPermits permits
@PublicApi(since = "2.3.0")
                uploadCounter,
        final int lastNMetadataFilesToKeep,
                RemoteStoreUtils.invertLong(creationTimestamp),
            );
    /**
    private void replaceUploadedSegments(Map<String, UploadedSegmentMetadata> newSegments) {
        private final String checksum;
            unregisterFormatForBlob(removed.getUploadedFilename());
    }
            } finally {
        // Along with last N files, we need to keep files since last successful run of scheduler
        }
                remoteSegmentStoreDirectory.deleteStaleSegments(0);
import org.opensearch.common.settings.Settings;
     * Remove a segment from uploaded map + unregister its format from cache.
                }
     */
        ReplicationCheckpoint replicationCheckpoint,
    /**
     * @throws IOException if there were any failures in reading the metadata file
                    + " but found "
            logger.info("Remote directory still has files, not deleting the path");
    public RemoteSegmentStoreDirectory(
                metadataVersion,
                deletionSuccessful.set(false);
            }
                    );
import java.io.InputStream;
     * @param name the name of an existing segment file in local filesystem.
    /** Shared helper for single format registration. */
            } finally {
            logger.info(
     * @return the blob path as a string for the given format
            return RemoteStoreUtils.invertLong(filenameTokens[2]);
import org.apache.lucene.util.Version;
        /**
                    Map<String, String> uploadedSegments = new HashMap<>();
            IndexSettings indexSettings = indexMetadata != null ? new IndexSettings(indexMetadata, Settings.EMPTY) : null;
        for (String file : segmentFiles) {
    @Deprecated
        }
        }
            formatBlobRouter.unregisterBlobFormat(blobKey);
     */
        try {
     * @return true if file exists in cache and checksum matches.
                    );
            throw new IOException(
                        if (segmentsUploadedToRemoteStore.containsKey(file)) {
            replaceUploadedSegments(Collections.emptyMap());
            MetadataFilenameUtils::getTimestamp,
        }
     * the respective Lucene major version that wrote the segments
        RemoteSegmentMetadata.METADATA_CODEC
                        logger.error(
        RemoteSegmentMetadata remoteSegmentMetadata = readLatestMetadataFile();
     *   <li>If the local directory is a {@link DataFormatAwareStoreDirectory}, it uses
    public RemoteSegmentMetadata initializeToSpecificTimestamp(long timestamp) throws IOException {
    private final ThreadPool threadPool;
import org.opensearch.index.store.remote.metadata.RemoteSegmentMetadata;
     *             enumerate per-format files (e.g., {@code parquet/}) and may leak them on cleanup
import org.apache.lucene.index.IndexFileNames;
                        );
            String[] values = uploadedFilename.split(SEPARATOR);
    /**
    }
            final String remoteFileName = getNewRemoteSegmentFilename(src);
    // pendingDownloadMergedSegments must go through these methods.
                            // to Lucene.LATEST. Accurate only for pure-Lucene shards.
     * bytes sequentially, and returns a {@link RemoteIndexInput} enclosing the stream. Intended for bulk transfers
     */
     * @param from              The directory for the file to be uploaded
    public void deleteStaleSegmentsAsync(int lastNMetadataFilesToKeep, ActionListener<Void> listener) {
            metadataFilesEligibleToDelete,
        String nodeId
            1
                    );
            return segmentsUploadedToRemoteStore.get(localFilename).uploadedFilename;
import org.opensearch.index.store.lockmanager.RemoteStoreMetadataLockManager;
    }
     * Called by postUpload().
                segmentToLuceneVersion.put(file, info.getVersion().major);
public final class RemoteSegmentStoreDirectory extends FilterDirectory implements RemoteStoreCommitLevelLockManager {
    /**
    }
        this.mdLockManager = mdLockManager;
import java.util.Objects;
    );
import org.apache.lucene.store.ByteBuffersDataOutput;
     * Checks if a specific commit have any corresponding lock file.
        public static final String METADATA_PREFIX = "metadata";
     * @param context    desired {@link IOContext} context
     * @throws IOException if there were any failures in reading the metadata file
                indexSettings
        }
            logger.debug(
                null,    // indexFixedPrefix
            blobKeyToFormat.put(metadata.getUploadedFilename(), extractFormat(metadata.getOriginalFilename()));
    private boolean deleteIfEmpty() throws IOException {
    /**
        }
                METADATA_PREFIX,
     * The format of refresh metadata filename is: refresh_metadata__PrimaryTerm__Generation__UUID
                            uploadedSegments.put(file, metadata.toString());
     * Replace entire uploaded segments map + rebuild format cache.
                if (nextMetadata != null && lockedMetadataFiles.contains(nextMetadata)) {
     * Delete stale segment and metadata files asynchronously.
            MetadataFilenameUtils::getTimestamp,
        }
        }
                    }
                    ),
     */
    @Override
        ShardId shardId,
        List<String> sortedMetadataFileList = remoteMetadataDirectory.listFilesByPrefixInLexicographicOrder(
                            segmentInfoSnapshotByteArray,
import org.apache.lucene.store.ByteBuffersIndexOutput;
 * another instance of {@code RemoteDirectory}.
                    try {
        if (pendingDownloadMergedSegments != null) {
    }
        logger.debug("deletedSegmentFiles={}", deletedSegmentFiles);
        }
            String metadataFilename = MetadataFilenameUtils.getMetadataFilename(
    }
        // Strip format prefix if present before appending UUID.
        if (segmentsUploadedToRemoteStore.containsKey(name)) {
                throw new IllegalArgumentException(
    private RemoteSegmentMetadata readMetadataFile(String metadataFilename) throws IOException {
    /**
        }
     * It is caller's responsibility to call init() again to ensure that cache is properly updated.
        );
     *
            return metadata;
     * @throws IOException in case of I/O error while reading from / writing to remote segment store
    ) throws IOException {
            }
     * @throws NoSuchFileException if the file does not exist in the remote segment store
        Map<String, String> blobKeyToFormat = new HashMap<>();
                logger.debug("Deleting stale metadata file {} from remote segment store", metadataFile);
                }
import org.apache.logging.log4j.Logger;
     * Checks if the file exists in the uploadedSegments cache and the checksum matches.
        return mdLockManager.isAcquired(FileLockInfo.getLockInfoBuilder().withFileToLock(metadataFile).build());
            return;
    }
                SEPARATOR,
    }
     * If vendor plugin supports uploading multiple parts in parallel, <code>BlobContainer#writeBlobByStreams</code>
        if (remoteFilename != null) {
import java.util.Map;
            int metadataVersion,
 * @opensearch.api
     * For example, _0.cfe in local filesystem will be uploaded to remote segment store as _0.cfe__gX7bNIIBrs0AUNsR2yEG
    }
            }
            }
            directory.deleteFile(filename);
     * @param segmentFiles         segment files that are part of the shard at the time of the latest refresh
        RemoteDirectory remoteDataDirectory,
                remoteMetadataDirectory.copyFrom(storeDirectory, metadataFilename, metadataFilename, IOContext.DEFAULT);
import org.opensearch.threadpool.ThreadPool;
    Return true if it deleted it successfully
     * @throws NoSuchFileException if the file does not exist in the cache or remote segment store
        }
     * Delete stale segment and metadata files
                // For versions < 2.11, we don't have node id.
    /**
        static long getPrimaryTerm(String[] filenameTokens) {
     * @param generation  Commit Generation
    @Nullable
     * Opens a stream that downloads an existing file as multiple byte-range parts in parallel while presenting the
        } else {
     * @param primaryTerm Primary Term of index at the time of commit.
        return remoteDataDirectory.createOutput(getNewRemoteSegmentFilename(name), context);
                    if (!activeSegmentFilesMetadataMap.containsKey(getLocalSegmentFilename(file))) {
    }
    }
    private void removeUploadedSegment(String localFilename) {
     */
        String metadataFile = lockedMetadataFiles.iterator().next();
        final List<String> sortedMetadataFiles,
                String.valueOf(Objects.hash(nodeId)),
        try {
            // Step 1: delete from remote (format cache entry still available for routing)
                    }
        );
import org.opensearch.index.store.remote.FormatBlobRouter;
                        canDeleteStaleCommits.set(true);
        public static final String SEPARATOR = "__";
        Collection<String> segmentFiles,
                    segmentInfosSnapshot.write(
                storeDirectory.sync(Collections.singleton(metadataFilename));
                    metadataFilesToFilterActiveSegments.add(nextMetadata);
                            throw new NoSuchFileException(file);
            metadataFilesToBeDeleted
        }
        return metadataMap;
import java.nio.file.NoSuchFileException;
     * Upload metadata file for a {@link CatalogSnapshot}. The snapshot supplies per-file format
     * Add a segment to uploaded map + register its format in cache.
    public void copyFrom(
     * @throws IOException in case of I/O error
        long translogGeneration,
        }
     * @param replicationCheckpoint ReplicationCheckpoint of primary shard
    }
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
    }
     * In order to get the list of segment files uploaded to the remote segment store, we need to read the latest metadata file.
                        + ") is incorrect. Should be between Version.LATEST ("
            SegmentInfo info = segmentCommitInfo.info;
                }
import java.io.IOException;
                unregisterFormatForBlob(remoteFilename);
     * Value is - local filename::uploaded filename::checksum
            true
            );
                String.valueOf(metadataVersion)
     * @param timestamp The timestamp to initialize the remote segment metadata to.
                remoteStoreRepoForIndex,
        List<String> metadataFilesEligibleToDelete = new ArrayList<>(
        }
            replaceUploadedSegments(Collections.emptyMap());
        }
            return String.join(
import java.util.List;
                        new RemoteSegmentMetadata(
            }
     * <p>IMPORTANT: All mutations to this map must go through the encapsulated APIs
     * @param executor   executor on which prefetch tasks run
        List<String> metadataFiles = remoteMetadataDirectory.listFilesByPrefixInLexicographicOrder(
     */
            );
        }
            return uploadedFilename;
        } catch (Exception e) {
                    Objects.requireNonNull(
        Map<String, Integer> segmentToLuceneVersion = new HashMap<>();
     * @throws NoSuchFileException if the file does not exist either in cache or remote segment store
        // the idea here is for each deletable md file, we can consider the segments present in non-deletable md file
        IOContext context,
import org.opensearch.index.remote.RemoteStorePathStrategy;
        }
            .filter(metadataFile -> allLockFiles.contains(metadataFile) == false)
            }
                });
    /**
     */
    private static final Logger staticLogger = LogManager.getLogger(RemoteSegmentStoreDirectory.class);
    }
     * md file
                    + generation
            metadata.setWrittenByMajor(Integer.parseInt(values[4]));
            String nodeId
     * @param lowPriorityUpload Whether this is a low priority upload
    public void close() throws IOException {
     *       backward compatibility with non-composite directories.</li>
     */
        }
     */
            );
        RemoteStoreLockManager mdLockManager,
        if (formatBlobRouter != null && format != null && format.isEmpty() == false) {
            return RemoteStoreUtils.invertLong(filenameTokens[filenameTokens.length - 2]);
    }
            return;
    }
        Tuple<Long, Set<Long>> pinnedTimestampsState = RemoteStorePinnedTimestampService.getPinnedTimestamps();
    public static void remoteDirectoryCleanup(
import org.apache.lucene.store.Directory;
    @InternalApi
        Collection<String> metadataFiles = remoteMetadataDirectory.listFilesByPrefixInLexicographicOrder(
    /**
     */
    }
    public boolean containsFile(String localFilename, String checksum) {
     * @throws NoSuchFileException when metadata file is not present for given commit point.
                    metadataFilesToFilterActiveSegments.add(prevMetadata);
    /**
    // Visible for testing
    /**
            }
     *
    }
                    );
     *
            long uploadCounter,
        public String getOriginalFilename() {
import java.io.FileNotFoundException;
        List<String> metadataFilesToBeDeleted = metadataFilesEligibleToDelete.stream()
     * Copies a file from the source directory to a remote based on multi-stream upload support.
                } else {
     * segment store.
     */
                generation,
    public static class MetadataFilenameUtils {
        this.metadataFilePinnedTimestampMap = new HashMap<>();
    private final Map<Long, String> metadataFilePinnedTimestampMap;
            Set.of(timestamp),
     * (2) if (md1, md2, md3) are in sorted order, it is not possible that a segment file will be in md1 and md3 but not in md2.
            throw new NoSuchFileException(name);
     */
            long primaryTerm,
                        + Version.LATEST.major
                            segmentInfoSnapshotByteArray,
    public Map<String, UploadedSegmentMetadata> getSegmentsUploadedToRemoteStore() {
     * Assumptions:
     * @return True if there is at least one lock for given primary term and generation.
                            metadata.setWrittenByMajor(segmentToLuceneVersion.get(metadata.originalFilename));
        UploadedSegmentMetadata segmentMetadata = new UploadedSegmentMetadata(src, remoteFilename, checksum, from.fileLength(src));
import org.opensearch.common.annotation.ExperimentalApi;
    ) throws IOException {
            byte[] metadataBytes = inputStream.readAllBytes();
                primaryTerm,
    /**
            String[] tokens = filename.split(SEPARATOR);
        List<String> metadataFiles = remoteMetadataDirectory.listFilesByPrefixInLexicographicOrder(
        @Override
                    + "and generation "
     * Key is - Segment local filename and
        for (UploadedSegmentMetadata metadata : segmentsUploadedToRemoteStore.values()) {
    }
     *
     * Returns the blob path for the given data format.
     */
     *
     */
import java.util.ArrayList;
        List<String> metadataFiles = remoteMetadataDirectory.listFilesByPrefixInLexicographicOrder(
        if (metadataFiles.size() != 0) {
     * @param name the name of an existing segment file in local filesystem.
    /**
     * @param lowPriorityUpload Whether this is a low priority upload
                        "catalogSnapshotToCommitSerializer must be supplied for upload"
                .filter(file -> deletedSegmentFiles.contains(file) == false)
     * @param partSize   size of each byte-range part
        );
        }
    @Override
            long translogGeneration,
 * In order to prevent segment overwrite which can occur due to two primary nodes for the same shard at the same time,
        String remoteFilename = getExistingRemoteFilename(name);
            metadataFilePinnedTimestampMap,
     */
    private static String extractFormat(String originalFilename) {
        // Visible for testing
    public static final String SEGMENT_NAME_UUID_SEPARATOR = "__";
     */
     *             during cleanup. This overload remains for backward compatibility but does not
        deleteStaleSegmentsAsync(lastNMetadataFilesToKeep, ActionListener.wrap(r -> {}, e -> {}));
    public RemoteSegmentStoreDirectory(
            formatBlobRouter.registerBlobFormat(blobKey, extractFormat(originalFilename));
                                LuceneVersionConverter.toLuceneOrLatest(
     * @param fileLength length of the file, as known from the remote segment metadata
                listener.onFailure(e);
                        new ByteBuffersIndexOutput(byteBuffersIndexOutput, "Snapshot of SegmentInfos", "SegmentInfos")
                remoteMetadataDirectory.copyFrom(storeDirectory, metadataFilename, metadataFilename, IOContext.DEFAULT);
                staticLogger.error("Lucene version is missing for UploadedSegmentMetadata: " + uploadedFilename);
        boolean forceClean
        String indexUUID,
            return String.join(
            Integer.MAX_VALUE
    // IMPORTANT: All mutations to segmentsUploadedToRemoteStore and
 * this file be licensed under the Apache-2.0 license or a
     * @throws NoSuchFileException when metadata file is not present for given commit point.
                remoteMetadataDirectory.deleteFile(metadataFile);
        return metadataFiles.get(0);
            return;
            logger.warn("Skipping remote segment store garbage collection as last fetch of pinned timestamp is stale");
    /**
     * @param listener          Listener to handle upload callback events
     * @opensearch.api
     * @return the {@link RemoteIndexInput} enclosing the block stream
                    try {
    private void registerFormatForBlob(String blobKey, String originalFilename) {
                            );
            replaceUploadedSegments(remoteSegmentMetadata.getMetadata());
 * in remote segment store vs filename in local filesystem and provides the consistent Directory interface so that
            MetadataFilenameUtils::getTimestamp,
    ) {
        return remoteFilename.split(SEGMENT_NAME_UUID_SEPARATOR)[0];
    /**
        registerFormatForBlob(metadata.getUploadedFilename(), metadata.getOriginalFilename());
                indexUUID,
     * of large files by {@link RemoteStoreFileDownloader}; see {@link ParallelPartInputStream}.
import java.util.concurrent.atomic.AtomicBoolean;
        }
     * this is currently used to restore snapshots, where we want to copy segment files from a given commit.
     */
        final Set<String> metadataFilesToFilterActiveSegments = new HashSet<>();
            // Collect all files to delete for this metadata file
            return;
        this.remoteDataDirectory = remoteDataDirectory;
        final Set<String> allLockFiles = new HashSet<>(implicitLockedFiles);
}
        }
        return true;
    public void acquireLock(long primaryTerm, long generation, String acquirerId) throws IOException {
        }
        String name,
        } catch (NoSuchFileException | FileNotFoundException e) {
                remoteDataDirectory.deleteFiles(filesToDelete);
     * @return Map from filename to parsed RemoteSegmentMetadata
        } else {
                        )
        } catch (Exception e) {
            long uploadCounter,
        }
        public String getUploadedFilename() {
    public int getSegmentsUploadedToRemoteStoreSize() {
     * @param context           IOContext to be used to open IndexInput of file during remote upload
     * @return true if segment is pending download, false otherwise
            return pendingDownloadMergedSegments.get(localFilename);
        CryptoMetadata cryptoMetadata
        return null;
import org.opensearch.common.Nullable;
        );
        }
            MetadataFilenameUtils.METADATA_PREFIX,
            try {
    }
 */
    /**
