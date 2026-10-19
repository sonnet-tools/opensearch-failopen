     * @param onCompletion runnable to run on completion of deletion regardless of success/failure.  
                if (filename == null) {
                    TranslogTransferMetadata.BUFFER_SIZE  
     * registered with the file transfer tracker exactly as a downloaded one would be, so it is neither re-uploaded
                assert metadata != null && !metadata.isEmpty() && metadata.containsKey(CHECKPOINT_FILE_DATA_KEY);
    private final FileTransferTracker fileTransferTracker;
    }
                }
                exceptionList.forEach(ex::addSuppressed);
        });
            }  
    public void delete() {  
            String fileName = metadata.name();  
import java.util.function.Function;
            try {
            } else {
                    logger.error(new ParameterizedMessage("Exception occurred while deleting remote translog metadata files {}", files), e);
        this.fence = fence;
    public RemoteTranslogTransferTracker getRemoteTranslogTransferTracker() {  
 * compatible open source license.
                }
        try {  
        long bytesToRead = 0, downloadStartTime = System.nanoTime();
            }
        long uploadStartTime;  
                );  
    private Map<String, String> downloadToFS(String fileName, Path location, String primaryTerm, boolean withMetadata) throws IOException {
                exceptionList.forEach(exception::addSuppressed);  
        for (BlobMetadata metadata : metadataFiles) {
            boolean current = localChecksum != null && localChecksum.longValue() == Long.parseLong(expectedChecksum);  
        remoteTranslogTransferTracker.updateUploadBytesMovingAverage(totalUploadedBytes);
        BlobPath remoteMetadataTransferPath,  
            // TranslogCorruptedException is unchecked and is what Checkpoint.read throws for a checkpoint that fails
                            onCompletion.run();  
import java.util.HashMap;
            );
    private void captureStatsOnUploadSuccess(long prevUploadBytesSucceeded, long prevUploadTimeInMillis) {  
                )
            fileTransferTracker.add(Translog.getFilename(gen), true);
        try {  
        this.remoteDataTransferPath = remoteDataTransferPath;  
        }
            return false;
                        // NO-OP  
                // after which the orphan is never the latest and highest-term lineage readers skip it.  
            // Mirror what downloadToFS / recoverCkpFileUsingMetadata register for a real download: the checkpoint
            return false;
        BlobPath remoteDataTransferPath,
    public TranslogTransferMetadata readMetadata(String metadataFilename) throws IOException {
        return readMetadata((blobMetadataList) -> {
            ThreadPool.Names.REMOTE_PURGE,
                        ex  
                    downloadStatus = true;  
    );
    public void deleteTranslogFiles() throws IOException {  
                remoteTranslogTransferTracker.addUploadBytesStarted(metadataBytesToUpload);
    boolean isLocalGenerationCurrent(Path location, long generation, @Nullable String expectedChecksum) {  
            } catch (InterruptedException ex) {
        BlobPath remoteMetadataTransferPath,
            fileTransferTracker.recordBytesForFiles(toUpload);
                            "Exception occurred while deleting translog for primaryTerm={} files={}",  
                numberOfFilesToFetch,  
            fileTransferTracker,  
        }  
        transferService.listAllInSortedOrderAsync(
                    output,
    /**
                    Files.copy(inputStream, filePath);
    }  
                Collectors.toMap(
        this.logger = Loggers.getLogger(getClass(), shardId);  
            uploadStartTime = System.nanoTime();
        try {
    public Set<Long> listPrimaryTermsInRemote() throws IOException {
        );
        Set<String> primaryTermsStr = transferService.listFolders(remoteDataTransferPath);  
            Map<Long, BlobPath> blobPathMap = new HashMap<>();  
        RemoteStoreSettings remoteStoreSettings,
            generations.forEach(generation -> {
     * @param count Number of metadata files to read
                @Override
        TransferService transferService,
            toUpload.forEach(
            new ActionListener<>() {
                    return;
    /**
import org.opensearch.indices.RemoteStoreSettings;
        try (BytesStreamOutput output = new BytesStreamOutput()) {  
        throws IOException {
        remoteTranslogTransferTracker.incrementTotalUploadsStarted();  
     *
            bytesToRead = inputStream.available();
                }  
    }
     *
    }
                    fileTransferTracker.onFailure(file, ex);
    public void populateFileTrackerWithLocalState(List<TranslogReader> readers) {  
                        logger.trace("Deleting remote translog metadata files {}", metadataFilesToDelete);
     * Makes generation {@code generation} available at {@code location}, downloading it only when the local copy
     */
                }),  
    public void listTranslogMetadataFilesAsync(ActionListener<List<BlobMetadata>> listener) {
        } catch (Exception ex) {
            return readMetadata();
    private static final VersionedCodecStreamWrapper<TranslogTransferMetadata> metadataStreamWrapper = new VersionedCodecStreamWrapper<>(
            public void onFailure(Exception e) {
            remoteDataTransferPath,
        FileTransferTracker fileTransferTracker,
                // (1) the metadata file is only uploaded after every data file it references succeeded (the
            new ActionListener<>() {
        if (isTranslogMetadataEnabled == false) {
                }
            downloadToFS(translogFilename, location, primaryTerm, false);
        // cleans up all the translog contents in async fashion for the given path
        }
    private void recoverCkpFileUsingMetadata(Map<String, String> metadata, Path location, String generation, String fileName)
                if (e instanceof RuntimeException runtimeException) {
     * cannot be proven identical to the remote one (see {@link #isLocalGenerationCurrent}). A reused local copy is  
                try (
    }  
                    onCompletion.run();  
        logger.info("Deleting primary terms from remote store lesser than {}", minPrimaryTermToKeep);  
        long downloadStartTime = System.nanoTime(), bytesToRead = 0;
            return false;
    public TranslogTransferManager(
            final CountDownLatch latch = new CountDownLatch(toUpload.size());  
     * This method handles deletion of multiple generations for a single primary term. The deletion happens for translog  
            });
                @Override
        // downloadToFS method will be called only when we want to download the file.
            );  
                : new TranslogUploadFailedException(ex.getMessage());
                if (blobMetadataList.isEmpty()) return;
        this.shardId = shardId;
            }, e -> {
        ShardId shardId,  
            remoteDataTransferPath.add(String.valueOf(primaryTerm)),  
        String ckpDataBase64 = metadata.get(CHECKPOINT_FILE_DATA_KEY);  
        transferService.listFoldersAsync(ThreadPool.Names.REMOTE_PURGE, remoteDataTransferPath, new ActionListener<>() {
            logger.error("Exception occurred while listing translog metadata files from remote store", e);
    }
                fileTransferTracker.add(Translog.getCommitCheckpointFileName(generation), true);
    /**
                // sequencing is one small conditional PUT per sync on the ack path.  
    public void deletePrimaryTermsAsync(long minPrimaryTermToKeep) {
                logger.error(() -> new ParameterizedMessage("Exception while listing metadata files"), e);
            Exception exWithoutSuppressed = ex instanceof TranslogFencedException  
        // otherwise leave a fresh translog beside a stale checkpoint of the same generation. That pair is what
import org.opensearch.core.index.shard.ShardId;
     * @param minPrimaryTermToKeep all primary terms below this primary term are deleted.  
     * Get the metadata bytes for a {@link TranslogTransferMetadata} object
    public byte[] getMetadataBytes(TranslogTransferMetadata metadata) throws IOException {  
        boolean isTranslogMetadataEnabled
    ) {  
    }
            // upload failure.
     */
                    assert ex instanceof FileTransferException;  
        transferService.deleteBlobsAsync(
                Collectors.toMap(
        CryptoMetadata cryptoMetadata  
    /**  
            }  
        return metadataBytes;
     */
            } else {
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_SEPARATOR;
     */
    private void delete(BlobPath path) {
        );
        transferService.delete(remoteDataTransferPath);
            // Preserve the fenced exception type: callers treat fencing as fatal for the shard, not a retryable
            }
     * @return Byte representation for the given metadata
    }
            // Capture number of bytes for stats before reading
        return new TransferFileSnapshot(
     *   <li>the remote metadata advertises a content checksum for the generation (older uploads do not)</li>  
                            primaryTerm,
        ShardId shardId,
                throw new RuntimeException("Timed out reading metadata file");
        } catch (Exception e) {
    /**
            logger.error("Error processing metadata for translog file: {}", fileName);
     * written, in which case the handoff effectively completed and this copy must stand down.
                    metadata = inputStreamWithMetadata.getMetadata();
    public Map<String, TranslogTransferMetadata> readLatestNMetadataFiles(int count) throws IOException {  
import java.util.concurrent.TimeUnit;  
                Set.of(pinnedTimestamp),
                logger.debug("local translog generation {} matches remote checksum {}; skipping download", generation, expectedChecksum);
import org.opensearch.index.translog.TranslogReader;
            .stream()  
            RemoteStoreUtils.verifyNoMultipleWriters(
    }
            try {
        TranslogTransferMetadata.CURRENT_VERSION,
            public void onFailure(Exception e) {
                }  
        LatchedActionListener<List<BlobMetadata>> latchedActionListener = new LatchedActionListener<>(  
            }  
            return false;
        deleteFileIfExists(location.resolve(ckpFileName));  
        new TranslogTransferMetadataHandlerFactory(),  
            }),
        String ckpFileName = Translog.getCommitCheckpointFileName(Long.parseLong(generation));
                    );  
        if (uploadDurationInMillis > 0) {
            captureStatsOnUploadFailure();  
            if (downloadStatus) {
        if (exceptionSetOnce.get() != null) {
                // Add .ckp and .tlog file to translog file list which is located in basePath/<primaryTerm>
                    logger.trace("Deleted translogs for primaryTerm={} files={}", primaryTerm, files);  
    }  
            @Override  
     * @param files list of metadata files to be deleted.
    @Nullable
        if (readers == null) {
        TranslogTransferMetadata.CURRENT_VERSION,
     *   <li>the local translog carries a {@link TranslogFooter} whose checksum equals the advertised one</li>  
                } catch (Exception exception) {
                toUpload.addAll(fileTransferTracker.exclusionFilter((transferSnapshot.getCheckpointFileSnapshots())));  
        );
        // outcome into "checkpoint missing", which is never trusted.
            fileTransferTracker.add(Translog.getFilename(generation), true);  
            transferService,  
                }).map(Long::parseLong).collect(Collectors.toSet());  
     * @return Map of filename to parsed TranslogTransferMetadata  
                    onCompletion.run();
            throw e;
     * it: the verification and the tracker update are deliberately kept in one place so that the tracker can never  
                // seal-marker follow-up.
            public void onResponse(Set<String> folders) {  
        // file it is about to write, but the two files are written one after the other, so a crash in between could
                public void onResponse(Void unused) {  
                logger.error(new ParameterizedMessage("Exception occurred while cleaning translog at path={}", path), e);
                    onCompletion.run();
import org.opensearch.common.blobstore.stream.write.WritePriority;  
     */
        translogTransferMetadata.setGenerationToChecksumMapper(new HashMap<>(generationChecksumMap));  
                String ckpFileName = Translog.getCommitCheckpointFileName(generation);  
                blobMetadataList.stream().map(BlobMetadata::name).collect(Collectors.toList()),  
            public void onResponse(Void unused) {
                remoteTranslogTransferTracker.addUploadTimeInMillis((System.nanoTime() - metadataUploadStartTime) / 1_000_000L);  
     * @param onCompletion runnable to run on completion of deletion regardless of success/failure.
                    generation,  
                metadataFiles,
                        onCompletion.run();
    }
        } finally {  
        } finally {  
                    @Override
                try {  
                        fileName
                try {
                Thread.currentThread().interrupt();
                    return false;
        translogTransferMetadata.setGenerationToPrimaryTermMapper(new HashMap<>(generationPrimaryTermMap));
            isTranslogMetadataEnabled,  
     *
                // exceptionList check above), so an orphan is an internally consistent restore point;
                TranslogTransferMetadata meta = readMetadata(fileName);
     */
                logger.trace("Nothing to upload for transfer");  
    public TranslogTransferMetadata readMetadata() throws IOException {  
import org.opensearch.action.LatchedActionListener;
                    logger.trace("Deleted remote translog metadata files {}", files);
        );  
    /**  
                    metadataSetOnce.set(readMetadata(filename));
 */  
        } catch (IOException | TranslogCorruptedException | NumberFormatException e) {  
        this.transferService = transferService;
        } else {  
                recoverCkpFileUsingMetadata(metadata, location, generation, translogFilename);
import org.opensearch.index.translog.transfer.FileSnapshot.TranslogFileSnapshot;  
                    logger.error(
        if (fence != null) {
            onCompletion.run();
                    FileTransferException e = (FileTransferException) ex;
        try {
    public int getMaxRemoteTranslogReadersSettings() {
                remoteMetadataTransferPath,  
                if (latch.await(remoteStoreSettings.getClusterRemoteTranslogTransferTimeout().millis(), TimeUnit.MILLISECONDS) == false) {  
                    Exception ex = new TranslogUploadFailedException(
     * be told about a generation whose content has not been checked.
            }
import org.opensearch.index.translog.Translog;
    }
     * Adds relevant stats to the tracker when an upload has failed
     *   <li>the local checkpoint passes its own CRC and belongs to this generation</li>
    public boolean isFenceSuperseded(long primaryTerm) throws IOException {
            // download path deletes the local files before writing, so nothing stale survives it.  
        return true;
            // file is only tracked as a remote object when it is uploaded as one.  
import org.opensearch.common.Nullable;
                    translogFiles.addAll(List.of(ckpFileName, translogFileName));  
        throws IOException {
        transferService.deleteAsync(
                    public void onResponse(List<BlobMetadata> blobMetadata) {
        Map<String, String> metadata = null;
            if (latch.await(remoteStoreSettings.getClusterRemoteTranslogTransferTimeout().millis(), TimeUnit.MILLISECONDS) == false) {  
        if (ckpDataBase64 == null) {
import org.opensearch.cluster.metadata.CryptoMetadata;  
    /**  
     *
     * it produces is retained, which is what lets {@link #revertFenceOwnership} distinguish a target that took over
                public void onFailure(Exception e) {
            } catch (Exception e) {  
            }
            throw new IllegalStateException(  
                public void onResponse(Void unused) {  
        Files.write(filePath, ckpFileBytes);
     * from one that never wrote. No-op when fencing is disabled.
    private final ShardId shardId;
                logger.debug(
                    logger.error(() -> new ParameterizedMessage("Exception while reading metadata file: {}", filename), e);
     * @return {@code true} if the generation was downloaded, {@code false} if the local copy was reused
    /**
        long uploadDurationInMillis = remoteTranslogTransferTracker.getTotalUploadTimeInMillis() - prevUploadTimeInMillis;
            // https://github.com/opensearch-project/OpenSearch/issues/9729
            deleteTranslogFilesAsync(primaryTerm, translogFiles, onCompletion);  
        }  
                }  
                    remoteTranslogTransferTracker.addUploadBytesFailed(metadataBytesToUpload);
     * Reclaims ownership after an aborted handoff. Returns {@code true} if ownership was reclaimed - meaning the target
                String filename = getMetadataFileToRead.apply(blobMetadataList);  
     *                         {@code null} if it advertises none (in which case the generation is always downloaded)
        TranslogTransferListener translogTransferListener,
    }  
    private final BlobPath remoteDataTransferPath;  
        String ckpFileName = Translog.getCommitCheckpointFileName(Long.parseLong(generation));
        Map<String, String> generationPrimaryTermMap = transferSnapshot.getTranslogFileSnapshots()
                file -> RemoteStoreUtils.invertLong(file.split(METADATA_SEPARATOR)[3]),  
                        () -> new ParameterizedMessage(
     * <ul>
                    downloadStatus = true;  
                exceptionSetOnce.set((IOException) e);  
            throw exceptionSetOnce.get();
            .stream()
                metadataUploadStartTime = System.nanoTime();
                remoteMetadataTransferPath,
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
        }
    /**
        remoteTranslogTransferTracker.incrementTotalUploadsSucceeded();
                        logger.error("Exception occurred while listing translog metadata files from remote store", e);
            IndexInput indexInput = new ByteArrayIndexInput("metadata file", inputStream.readAllBytes());  
                remoteTranslogTransferTracker.addDownloadBytesSucceeded(bytesToRead);  
                throw ex;
    public void deleteMetadataFilesAsync(List<String> files, Runnable onCompletion) {
    }
            listener
/**  
                    );
                try (InputStream inputStream = transferService.downloadBlob(remoteDataTransferPath.add(primaryTerm), fileName)) {  
        // Remove any local copy of this generation before the first byte is fetched. Each download below deletes the  
        byte[] metadataBytes;
            if (exceptionList.isEmpty()) {
            }
    }
            location
            fileTransferTracker.recordFileTransferStartTime(uploadStartTime);
import org.opensearch.core.action.ActionListener;
        SetOnce<TranslogTransferMetadata> metadataSetOnce = new SetOnce<>();  
        try {
        }  
            return blobMetadataList.get(0).name();  
            TranslogTransferMetadata.METADATA_PREFIX,
            if (isTranslogMetadataEnabled == false) {
import org.opensearch.index.translog.TranslogCorruptedException;
     * Hands ownership of this term's acknowledgement path to {@code targetAllocationId}, as the final act of a primary
                String translogFileName = Translog.getFilename(generation);
            logger.debug("translogMetadataDownloadStatus={}", downloadStatus);
 * @opensearch.internal  
                    }  
    }  
            @Override
        long gen = Long.parseLong(generation);  
        }  
        downloadTranslog(primaryTerm, generation, location);
import org.opensearch.index.translog.transfer.FileSnapshot.TransferFileSnapshot;
    /**
                throw new IOException("Failed to recover checkpoint file from remote", e);
            @Override
    private final RemoteStoreSettings remoteStoreSettings;
        remoteTranslogTransferTracker.incrementTotalUploadsFailed();
        long prevUploadTimeInMillis = remoteTranslogTransferTracker.getTotalUploadTimeInMillis();
            }
        // Therefore, we delete the file if it exists.
     *
 *
                TranslogTransferMetadata.METADATA_PREFIX,
        RemoteStoreSettings remoteStoreSettings,  
            }
            transferService.uploadBlobs(toUpload, blobPathMap, latchedActionListener, WritePriority.HIGH, cryptoMetadata);  
        final CountDownLatch latch = new CountDownLatch(1);
                        if (sortedMetadataFiles.size() <= 1) {
                Integer.MAX_VALUE,
                    metadata.getFileName(),
                if (fence != null) {
                }
            downloadToFS(ckpFileName, location, primaryTerm, false);
            if (withMetadata) {  
        TranslogTransferMetadata translogTransferMetadata = null;
            Integer.MAX_VALUE,  
     * Adds relevant stats to the tracker when an upload is successfully completed
            // Download Checkpoint file, translog file from remote to local FS  
                    Files.copy(inputStream, filePath);
            Long localChecksum = TranslogFooter.readGenerationChecksum(location, generation);
     * Reads the latest N translog metadata files from remote store using filename parsing.  
import java.util.Base64;
        }  
                throw exception;
        Path filePath = location.resolve(ckpFileName);
            remoteTranslogTransferTracker.updateUploadBytesPerSecMovingAverage((totalUploadedBytes * 1_000L) / uploadDurationInMillis);
            try {  
                // concurrently instead, the CAS can win before the sweep while the metadata PUT is still in
                metadataBytesToUpload = tlogMetadata.getContentLength();  
import java.nio.file.Path;
                // (3) the new owner's first upload publishes metadata at its own (same-or-higher) term/generation,
            return current;
        if (pinnedTimestamp <= 0) {
        deleteFileIfExists(filePath);  
                    }
    private final Logger logger;  
        for (TranslogReader reader : readers) {
                    remoteDataTransferPath.add(String.valueOf(fileSnapshot.getPrimaryTerm()))
                }
            );
                // (2) the only extra state it can surface is the never-acknowledged operation of the fenced write,  
            .filter(snapshot -> snapshot.getTranslogContentChecksum() != null)
     * relocation handoff. Performed by the current owner while its uploads are drained, so it is uncontested; the token  
                    fence.validateAndAdvance(transferSnapshot.getTranslogTransferMetadata().getPrimaryTerm());  
    private final boolean isTranslogMetadataEnabled;  
        boolean isTranslogMetadataEnabled,
     *  
import java.util.List;
            translogTransferMetadata.getPrimaryTerm()
    /**  
            throw e;  
        transferService.delete(remoteMetadataTransferPath);
        Map<String, String> generationChecksumMap = transferSnapshot.getTranslogFileSnapshots()
                            files
                ) {  
            }
            fence.transferOwnershipTo(primaryTerm, targetAllocationId);  
import org.opensearch.common.io.VersionedCodecStreamWrapper;
                    snapshot -> String.valueOf(snapshot.getPrimaryTerm())
                    }  
            // Delete the translog and checkpoint files asynchronously
                Exception exception = new TranslogUploadFailedException("Failed to upload " + transferSnapshot, ex);
            return;
                result.put(fileName, meta);  
            // its own CRC; a corrupt local checkpoint must fall back to a download like any other doubt. The
    public void deleteGenerationAsync(long primaryTerm, Set<Long> generations, Runnable onCompletion) {
        }  
        return this.shardId;
            .filter(snapshot -> snapshot instanceof TranslogFileSnapshot)  
                    TransferFileSnapshot file = e.getFileSnapshot();  
                // halves report success, and an acknowledged operation ends up in a metadata file no recovery  
        BlobPath remoteDataTransferPath,  
     */  
    ) throws IOException {
        this.remoteStoreSettings = remoteStoreSettings;
            remoteMetadataTransferPath,
        return translogTransferMetadata;
     * and metadata files.
        }
        );  
    }
        remoteTranslogTransferTracker.addUploadBytesStarted(fileTransferTracker.getTotalBytesToUpload());  
                        ),  
        Set<TransferFileSnapshot> toUpload = new HashSet<>(transferSnapshot.getTranslogTransferMetadata().getCount());  
        );  
                return true;
     * {@code false} when fencing is disabled, so callers gate on it without having to know whether the feature is on.  
                @Override
     * Deletes all primary terms from remote store that are more than the given {@code minPrimaryTermToKeep}. The caller
        boolean downloadStatus = false;  
                )
                    // outer catch handles capturing stats on upload failure
     * @param metadata The object to be parsed  
            );
        }
                public void onFailure(Exception e) {  
 * The OpenSearch Contributors require contributions made to  
     *   <li>both the {@code .tlog} and the {@code .ckp} file are present locally</li>
     */
    private final RemoteTranslogTransferTracker remoteTranslogTransferTracker;  
     */
                // A fenced writer may still publish one orphan metadata file (CAS refused after the PUT landed).
                Exception ex = new TranslogUploadFailedException("Failed to upload " + exceptionList.size() + " files during transfer");  
     * @param onCompletion runnable to run on completion of deletion regardless of success/failure.
 * The class responsible for orchestrating the transfer of a {@link TransferSnapshot} via a {@link TransferService}
            List<String> metadataFiles = blobMetadataList.stream().map(BlobMetadata::name).collect(Collectors.toList());
            }
            remoteStoreSettings,
            return metadataFilesMatchingTimestamp.stream().findFirst().get();
        // https://github.com/opensearch-project/OpenSearch/issues/9729
    }
    private void deleteTranslogFilesAsync(long primaryTerm, List<String> files, Runnable onCompletion) {  
                latchedActionListener
            }
        this.isTranslogMetadataEnabled = isTranslogMetadataEnabled;  
            translogTransferMetadata.getFileName(),  
            }
                    throw ex;
            remoteDataTransferPath.add(String.valueOf(primaryTerm)),  
                // Readers are safe against it:  
            logger.debug(() -> new ParameterizedMessage("unable to reconcile local translog generation {}; downloading", generation), e);
        List<BlobMetadata> metadataFiles = transferService.listAllInSortedOrder(
            remoteMetadataTransferPath,
import java.util.ArrayList;  
                    public void onFailure(Exception e) {  
        return true;
                }  
            // Download translog.tlog file with object metadata from remote to local FS
     * Handles deletion of all translog files associated with a primary term.
                    snapshot -> String.valueOf(snapshot.getTranslogContentChecksum())  
    }
                // The fenced writer deliberately does NOT delete the orphan: a writer that has just learned it lost
import org.opensearch.common.SetOnce;
            LatchedActionListener<TransferFileSnapshot> latchedActionListener = new LatchedActionListener<>(
                }
                Set<Long> primaryTermsToDelete = primaryTermsInRemote.stream()
                if (isTranslogMetadataEnabled == false) {
        return metadataSetOnce.get();
        return this.remoteStoreSettings.getMaxRemoteTranslogReaders();  
import org.apache.logging.log4j.Logger;
                    snapshot -> String.valueOf(snapshot.getGeneration()),
     * downloading, which is exactly what happens today.  
        this.fileTransferTracker = fileTransferTracker;
                    logger.info("Deleted primary term {}", primaryTerm);
        }  
                    "translog transfer metadata " + metadata.getPrimaryTerm(),  
                            ((FileTransferException) ex).getFileSnapshot().getName()
        TranslogTransferMetadata translogTransferMetadata = transferSnapshot.getTranslogTransferMetadata();
            files,
                @Override
            remoteMetadataTransferPath,
                    fileTransferTracker.delete(files);
            @Override
                // RemoteStoreFence.tla in formal-models/ refutes the interleaving (SEQUENCED = FALSE), and the cost of
     * @param primaryTerm primary term.
                TranslogTransferMetadata.METADATA_PREFIX,
        if (Files.exists(filePath)) {
    }  
    }  
    private final RemoteStoreFence fence;  
                        Long.parseLong(folderName);  
        TranslogTransferMetadata.METADATA_CODEC  
    }
                // and surfacing an unacknowledged operation is always permitted;
            );  
        remoteTranslogTransferTracker.updateUploadTimeMovingAverage(uploadDurationInMillis);  
                ThreadPool.Names.REMOTE_PURGE,
import java.util.stream.Collectors;
    private static final int METADATA_FILES_TO_FETCH = 10;
     */
        // Here, we always override the existing file if present.  
     * Whether a strictly higher primary term has taken the fence, i.e. this copy has been superseded. Always
import org.opensearch.index.translog.TranslogFooter;  
                            return;
 *
/*  
            }
        remoteTranslogTransferTracker.setLastSuccessfulUploadTimestamp(System.currentTimeMillis());
                    "local translog generation {} has checksum {} but remote advertises {}; downloading",
            try (
    private TransferFileSnapshot prepareMetadata(TransferSnapshot transferSnapshot) throws IOException {
                        e
import org.opensearch.common.logging.Loggers;  
            latch
    /**
                    InputStream inputStream = inputStreamWithMetadata.getInputStream();
                }
                        List<String> metadataFilesToDelete = sortedMetadataFiles.subList(1, sortedMetadataFiles.size());  
        }, METADATA_FILES_TO_FETCH);
    }
 * this file be licensed under the Apache-2.0 license or a
            shardId,
                // still existed, so a takeover's sweep - and the restore-point read behind it - can only happen
     * on the next sync nor fetched again. This is the only path that marks a file as present without downloading
                    @Override
        this.remoteMetadataTransferPath = remoteMetadataTransferPath;
                            "Exception during transfer for file {}",  
        // Advertise the content checksum of every generation that carries a footer, so a downloader holding the
    }
        return new HashSet<>();
                    logger.error(new ParameterizedMessage("Exception occurred while deleting primary term {}", primaryTerm), e);  
     * @param files       list of translog files to be deleted.  
            transferService.deleteBlobsAsync(ThreadPool.Names.REMOTE_PURGE, remoteMetadataTransferPath, files, new ActionListener<>() {
     * @param primaryTerm primary term of translog files.
    // Flag to include checkpoint file data as translog file metadata during upload/download
    public boolean downloadTranslog(String primaryTerm, String generation, Path location) throws IOException {  
                    throw runtimeException;  
                            logger.trace("Remote Metadata file count is {}, so skipping deletion", sortedMetadataFiles.size());
    public boolean downloadTranslogIfChanged(String primaryTerm, String generation, Path location, @Nullable String expectedChecksum)
                translogTransferListener.onUploadComplete(transferSnapshot);  
     */  
            TranslogTransferMetadata.METADATA_PREFIX,  
                    snapshot -> String.valueOf(snapshot.getGeneration()),  
                    } catch (Exception ignored) {
                        deleteMetadataFilesAsync(metadataFilesToDelete, onCompletion);
     * of the method must ensure that the value is lesser than equal to the minimum primary term referenced by the remote  
                logger.error("Failed to read translog metadata file ", e);
        // TODO: Ideally each file's byte uploads started should be when it is actually picked for upload
            Set<String> metadataFilesMatchingTimestamp = RemoteStoreUtils.getPinnedTimestampLockedFiles(  
    }
import java.util.HashSet;  
            "Downloading translog files with: Primary Term = {}, Generation = {}, Location = {}",
import java.io.InputStream;  
        deleteFileIfExists(location.resolve(translogFilename));
                @Override  
                return null;
        byte[] ckpFileBytes = Base64.getDecoder().decode(ckpDataBase64);
            translogTransferListener.onUploadFailed(transferSnapshot, exWithoutSuppressed);  
        }  
            if (metadataFilesMatchingTimestamp.isEmpty()) {
                metadataStreamWrapper.writeStream(indexOutput, metadata);  
     */
                        List<String> sortedMetadataFiles = blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList());  
                @Override
import java.util.concurrent.CountDownLatch;
        Path filePath = location.resolve(fileName);  
public class TranslogTransferManager {
            }  
import java.io.IOException;
        boolean downloadStatus = false;  
            ThreadPool.Names.REMOTE_PURGE,  
import org.opensearch.index.translog.transfer.listener.TranslogTransferListener;
        return fence != null && fence.isSuperseded(primaryTerm);  
            if (isTranslogMetadataEnabled) {
                    InputStreamWithMetadata inputStreamWithMetadata = transferService.downloadBlobWithMetadata(
            remoteTranslogTransferTracker.addDownloadTimeInMillis((System.nanoTime() - downloadStartTime) / 1_000_000L);
                    .collect(Collectors.toSet());  
                ActionListener.wrap(fileTransferTracker::onSuccess, ex -> {
    public void deleteStaleTranslogMetadataFilesAsync(Runnable onCompletion) {
    }
        // Delete the translog metadata content from the remote store.  
    public boolean revertFenceOwnership(long primaryTerm) throws IOException {  
    }  
            assert metadataFilesMatchingTimestamp.size() == 1 : "There should be only 1 metadata file matching given timestamp";
                )
        // isLocalGenerationCurrent reconciles on the next attempt, and a stale checkpoint whose offset happens to  
    }  
            );  
        logger.trace(
                Set<Long> primaryTermsInRemote = folders.stream().filter(folderName -> {
    /**
    }
                }
    public boolean transferSnapshot(  
        }  
            );
                return true;
            translogTransferMetadata = metadataStreamWrapper.readStream(indexInput);
        );  
            downloadStatus = true;
            ActionListener.wrap(blobMetadataList -> {
import java.util.LinkedHashMap;
        } catch (InterruptedException e) {  
    }  
            } else {  
     * @param expectedChecksum the content checksum the remote metadata advertises for the generation, or  
        }  
        delete(remoteDataTransferPath);
                )
            metadataBytes = BytesReference.toBytes(output.bytes());
    }  
     * @throws IOException if the fetch or parsing fails
     * Process the provided metadata and tries to recover translog.ckp file to the FS.
    public void transferFenceOwnership(long primaryTerm, String targetAllocationId) throws IOException {
     * Adds relevant stats to the tracker when an upload is started  
        return remoteTranslogTransferTracker;
        RemoteTranslogTransferTracker remoteTranslogTransferTracker,  
     */  
        // Mark in FileTransferTracker so that the same files are not uploaded at the time of translog sync
                    exceptionList.forEach(ex::addSuppressed);
    private void captureStatsBeforeUpload() {
        TransferService transferService,
import org.opensearch.common.io.stream.BytesStreamOutput;
     * Deletes metadata files asynchronously using the {@code REMOTE_PURGE} threadpool. On success or failure, runs {@code onCompletion}.  
                true
        if (isLocalGenerationCurrent(location, gen, expectedChecksum)) {
        delete(remoteMetadataTransferPath);
        // Delete the translog data content from the remote store.
        Map<String, TranslogTransferMetadata> result = new LinkedHashMap<>();
        return fence == null || fence.revertOwnership(primaryTerm);
     * translog metadata.
            .collect(
        }  
    }
            } catch (Exception e) {
            );
                remoteTranslogTransferTracker.addUploadBytesSucceeded(metadataBytesToUpload);
                    exceptionSetOnce.set(e);
            .map(snapshot -> (TranslogFileSnapshot) snapshot)
     */
                    fileSnapshot.getPrimaryTerm(),  
}
        return readMetadata((blobMetadataList) -> {
        TransferSnapshot transferSnapshot,
                }  
        return metadata;  
                    .filter(term -> term < minPrimaryTermToKeep)
            // TODO: Ideally each file's upload start time should be when it is actually picked for upload  
                    bytesToRead = inputStream.available();
        }  
            count
     */
            long generation = reader.getGeneration();
            captureStatsBeforeUpload();
    }  
     */
        try (InputStream inputStream = transferService.downloadBlob(remoteMetadataTransferPath, metadataFilename)) {  
                // orphans (verifyNoMultipleWriters collisions, pinned-timestamp bookkeeping, storage) is the  
        throws IOException {
            if (current) {
                toUpload.addAll(fileTransferTracker.exclusionFilter(transferSnapshot.getTranslogFileSnapshotWithMetadata()));  
                // after the CAS, by which point the metadata is already visible (read-after-write). Issued  
            onCompletion.run();  
    /**
    }
        );
        }
            }  
    private final TransferService transferService;
            transferService.listAllInSortedOrder(  
        } catch (Exception e) {
            if (isTranslogMetadataEnabled == false) {
                logger.error("Exception occurred while getting primary terms from remote store", e);  
                TransferFileSnapshot tlogMetadata = prepareMetadata(transferSnapshot);
 */
                }  
            }
     * being downloaded again. The local copy is reused only when all of the following hold:
        List<Exception> exceptionList = new ArrayList<>(transferSnapshot.getTranslogTransferMetadata().getCount());
                // Invariant (see RemoteStoreFence): the chain gates the ack, and the CAS is issued only AFTER the
                // metadata upload below has completed. The ordering is load-bearing, not a simplification - it is  
    private void captureStatsOnUploadFailure() {  
        SetOnce<IOException> exceptionSetOnce = new SetOnce<>();
import org.opensearch.index.remote.RemoteTranslogTransferTracker;  
import java.util.Set;
     * @param primaryTerm primary term where the generations will be deleted.  
            }
                // ownership must stop mutating the shard's remote state, not act on a stale view of it. Reconciling
                        remoteDataTransferPath.add(primaryTerm),  
            getMetadataBytes(translogTransferMetadata),
    }
    }  
        this.remoteTranslogTransferTracker = remoteTranslogTransferTracker;
                fileTransferTracker.add(Translog.getCommitCheckpointFileName(gen), true);  
    public TranslogTransferMetadata readMetadata(long pinnedTimestamp) throws IOException {  
                    expectedChecksum
        @Nullable RemoteStoreFence fence
                public void onResponse(Void unused) {
        if (primaryTermsStr != null) {
                logger.info("Deleted all remote translog data at path={}", path);  
        // same bytes locally can skip fetching them. Footer-less generations are simply absent from the map.  
                primaryTermsToDelete.forEach(term -> deletePrimaryTermAsync(term));
        fileTransferTracker.add(fileName, true);
                TranslogTransferMetadata::getNodeIdByPrimaryTermAndGen
                        ),
     */  
                OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput(
                // will ever resolve - it sorts below every file the new owner publishes. Acked-write loss:
        }
            Map<String, String> metadata = downloadToFS(translogFilename, location, primaryTerm, true);
            if (downloadStatus) {  
     * Deletes all the translog content related to the underlying shard.
                TranslogTransferMetadata::getNodeIdByPrimaryTermAndGen,
            generation,
    }
        }, Integer.MAX_VALUE);  
        if (expectedChecksum == null) {
                    bytesToRead = inputStream.available();
                ? new TranslogFencedException(ex.getMessage())
                    try {
            null
        deleteFileIfExists(filePath);
                // flight; the takeover then reads a restore point without this generation, the PUT lands, both
    }
            transferService.listAllInSortedOrderAsync(
                    localChecksum,
            List<String> translogFiles = new ArrayList<>();  
                remoteTranslogTransferTracker.addDownloadBytesSucceeded(bytesToRead);
    public TranslogTransferManager(  
                    exceptionList.add(ex);
                new ActionListener<>() {  
                    transferService.uploadBlob(tlogMetadata, remoteMetadataTransferPath, WritePriority.HIGH, cryptoMetadata);
                        return true;
                    onCompletion.run();
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opensearch.common.blobstore.BlobMetadata;  
     *
        FileTransferTracker fileTransferTracker,
            }  
                    throw new TranslogUploadFailedException("Failed to upload " + tlogMetadata.getName(), exception);  
                captureStatsOnUploadSuccess(prevUploadBytesSucceeded, prevUploadTimeInMillis);
            remoteTranslogTransferTracker,
    protected FileTransferTracker getFileTransferTracker() {
import java.util.Map;  
        return fileTransferTracker;
     * </ul>
package org.opensearch.index.translog.transfer;
            Files.delete(filePath);
import org.opensearch.threadpool.ThreadPool;  
    ) {  
import org.opensearch.common.blobstore.InputStreamWithMetadata;
     * Deletes list of translog files asynchronously using the {@code REMOTE_PURGE} threadpool.  
    // Visible for testing
        return result;  
                public void onFailure(Exception e) {
                        () -> new ParameterizedMessage(
    /**
        long metadataUploadStartTime;
            } else {
                        }
        }  
                    );
                // what makes "seal before restore" airtight. A successful CAS proves this writer's fence object
            if (toUpload.isEmpty()) {
                    )
    /**
                }
            );
    private void deletePrimaryTermAsync(long primaryTerm) {  
                toUpload.addAll(fileTransferTracker.exclusionFilter(transferSnapshot.getTranslogFileSnapshots()));
        }
        // equal the new one would locate the new footer and pass. Deleting the checkpoint first turns every partial
        transferService.deleteAsync(ThreadPool.Names.REMOTE_PURGE, path, new ActionListener<>() {  
                        "Timed out waiting for transfer of snapshot " + transferSnapshot + " to complete"
            throw new IOException("Exception while reading/downloading metadata file", e);
        String translogFilename = Translog.getFilename(Long.parseLong(generation));
        long prevUploadBytesSucceeded = remoteTranslogTransferTracker.getUploadBytesSucceeded();
            }
import org.opensearch.core.common.bytes.BytesReference;  
            .collect(  
                } else {
     * Any failure to establish this - including a truncated file, a missing footer or an I/O error - falls back to
            });
                "Checkpoint file data key " + CHECKPOINT_FILE_DATA_KEY + " is expected but not found in metadata for file: " + fileName
import org.apache.lucene.store.OutputStreamIndexOutput;
                    remoteTranslogTransferTracker.addUploadTimeInMillis((System.nanoTime() - metadataUploadStartTime) / 1_000_000L);  
    private void deleteFileIfExists(Path filePath) throws IOException {  
            remoteTranslogTransferTracker.addDownloadTimeInMillis((System.nanoTime() - downloadStartTime) / 1_000_000L);
                } catch (IOException e) {  
    final static String CHECKPOINT_FILE_DATA_KEY = "ckp-data";
            logger.error(() -> new ParameterizedMessage("Transfer failed for snapshot {}", transferSnapshot), ex);
            onCompletion.run();
                }  
                fileSnapshot -> blobPathMap.put(
     * @param generations set of generation to delete.
import java.nio.file.Files;
        } catch (Exception e) {  
                //
                    translogFiles.add(translogFileName);
                latch
     * Decides whether generation {@code generation} can be served from the local translog directory instead of  
     * never wrote, so it never took over and this copy may resume - and {@code false} if the target had already  
import org.opensearch.common.blobstore.BlobPath;
    private TranslogTransferMetadata readMetadata(Function<List<BlobMetadata>, String> getMetadataFileToRead, int numberOfFilesToFetch)
        RemoteTranslogTransferTracker remoteTranslogTransferTracker,
    private final BlobPath remoteMetadataTransferPath;
            ) {
        }  
     *
        long totalUploadedBytes = remoteTranslogTransferTracker.getUploadBytesSucceeded() - prevUploadBytesSucceeded;  
        });
            return primaryTermsStr.stream().map(Long::parseLong).collect(Collectors.toSet());
        try {
                    logger.error(
import org.opensearch.index.remote.RemoteStoreUtils;
            ThreadPool.Names.REMOTE_PURGE,
 * SPDX-License-Identifier: Apache-2.0
    /**
        long metadataBytesToUpload;
import org.apache.lucene.store.IndexInput;  
        this(
    public ShardId getShardId() {
            primaryTerm,  
        try {
