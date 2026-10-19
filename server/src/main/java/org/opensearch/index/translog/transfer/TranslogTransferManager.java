            return false;
import java.util.HashSet;
                    exceptionList.forEach(ex::addSuppressed);
                // concurrently instead, the CAS can win before the sweep while the metadata PUT is still in
     */
            .collect(
        // TODO: Ideally each file's byte uploads started should be when it is actually picked for upload
                // A fenced writer may still publish one orphan metadata file (CAS refused after the PUT landed).
import org.opensearch.common.blobstore.BlobMetadata;
        return metadataSetOnce.get();
            new ActionListener<>() {
        transferService.deleteBlobsAsync(
        if (Files.exists(filePath)) {
            }
                //
    /**
import org.opensearch.index.translog.transfer.FileSnapshot.TransferFileSnapshot;
            ThreadPool.Names.REMOTE_PURGE,
            }
    public void transferFenceOwnership(long primaryTerm, String targetAllocationId) throws IOException {
        RemoteStoreSettings remoteStoreSettings,
            primaryTerm,
                        ),
                    Exception ex = new TranslogUploadFailedException(
                Collectors.toMap(
        BlobPath remoteMetadataTransferPath,
                // Readers are safe against it:
            );
                @Override
     * @param onCompletion runnable to run on completion of deletion regardless of success/failure.
                    onCompletion.run();
/*
        this.remoteDataTransferPath = remoteDataTransferPath;
        } finally {
        // file it is about to write, but the two files are written one after the other, so a crash in between could
        return translogTransferMetadata;
        );
        return remoteTranslogTransferTracker;
import java.io.InputStream;
                @Override
                    logger.error(new ParameterizedMessage("Exception occurred while deleting primary term {}", primaryTerm), e);
            assert metadataFilesMatchingTimestamp.size() == 1 : "There should be only 1 metadata file matching given timestamp";
                Exception ex = new TranslogUploadFailedException("Failed to upload " + exceptionList.size() + " files during transfer");
        }
            onCompletion.run();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.Nullable;
            return metadataFilesMatchingTimestamp.stream().findFirst().get();
            }
        this.fence = fence;
            }
            // upload failure.
                    );
        // Remove any local copy of this generation before the first byte is fetched. Each download below deletes the
import org.opensearch.index.translog.transfer.listener.TranslogTransferListener;
        if (isTranslogMetadataEnabled == false) {
                }
            fileTransferTracker.recordFileTransferStartTime(uploadStartTime);
        String translogFilename = Translog.getFilename(Long.parseLong(generation));
                    remoteTranslogTransferTracker.addUploadBytesFailed(metadataBytesToUpload);
            });
        }
            } catch (InterruptedException ex) {
     * on the next sync nor fetched again. This is the only path that marks a file as present without downloading
    private final Logger logger;
     */
            }),
import org.opensearch.index.translog.TranslogReader;
                Thread.currentThread().interrupt();
    public void listTranslogMetadataFilesAsync(ActionListener<List<BlobMetadata>> listener) {
        );
    ) throws IOException {
        boolean downloadStatus = false;
        RemoteStoreSettings remoteStoreSettings,
            } else {
                String translogFileName = Translog.getFilename(generation);
        long totalUploadedBytes = remoteTranslogTransferTracker.getUploadBytesSucceeded() - prevUploadBytesSucceeded;
    }
                TranslogTransferMetadata.METADATA_PREFIX,
    private void captureStatsOnUploadSuccess(long prevUploadBytesSucceeded, long prevUploadTimeInMillis) {
                if (e instanceof RuntimeException runtimeException) {
    final static String CHECKPOINT_FILE_DATA_KEY = "ckp-data";
            if (latch.await(remoteStoreSettings.getClusterRemoteTranslogTransferTimeout().millis(), TimeUnit.MILLISECONDS) == false) {
                throw exception;
                remoteMetadataTransferPath,
import java.nio.file.Path;
    }
     * @return Byte representation for the given metadata
import org.apache.logging.log4j.Logger;
     * @throws IOException if the fetch or parsing fails
                remoteTranslogTransferTracker.addUploadBytesSucceeded(metadataBytesToUpload);
        delete(remoteMetadataTransferPath);
    /**
            transferService.deleteBlobsAsync(ThreadPool.Names.REMOTE_PURGE, remoteMetadataTransferPath, files, new ActionListener<>() {
     * Deletes all primary terms from remote store that are more than the given {@code minPrimaryTermToKeep}. The caller
            captureStatsBeforeUpload();
     * being downloaded again. The local copy is reused only when all of the following hold:
        List<Exception> exceptionList = new ArrayList<>(transferSnapshot.getTranslogTransferMetadata().getCount());
    public TranslogTransferMetadata readMetadata() throws IOException {
    }
            logger.debug("translogMetadataDownloadStatus={}", downloadStatus);
                    transferService.uploadBlob(tlogMetadata, remoteMetadataTransferPath, WritePriority.HIGH, cryptoMetadata);
        RemoteTranslogTransferTracker remoteTranslogTransferTracker,
     */
            logger.debug(() -> new ParameterizedMessage("unable to reconcile local translog generation {}; downloading", generation), e);
        // Delete the translog metadata content from the remote store.
    public TranslogTransferManager(
        delete(remoteDataTransferPath);
        // Therefore, we delete the file if it exists.
        CryptoMetadata cryptoMetadata
            public void onResponse(Void unused) {
                    )
                        fileName
                    "translog transfer metadata " + metadata.getPrimaryTerm(),
     *
        if (isLocalGenerationCurrent(location, gen, expectedChecksum)) {
    private final TransferService transferService;
                Exception exception = new TranslogUploadFailedException("Failed to upload " + transferSnapshot, ex);
            }
                Collectors.toMap(
                            files
    public byte[] getMetadataBytes(TranslogTransferMetadata metadata) throws IOException {
        long metadataUploadStartTime;
    public void deleteMetadataFilesAsync(List<String> files, Runnable onCompletion) {
        Map<String, String> generationPrimaryTermMap = transferSnapshot.getTranslogFileSnapshots()
     * Adds relevant stats to the tracker when an upload has failed
                    .collect(Collectors.toSet());
                @Override
        if (ckpDataBase64 == null) {
            transferService,
        BlobPath remoteDataTransferPath,
     */
                    }
            fileTransferTracker,
            .filter(snapshot -> snapshot.getTranslogContentChecksum() != null)
                Set<Long> primaryTermsToDelete = primaryTermsInRemote.stream()
        }
                    return false;
package org.opensearch.index.translog.transfer;
                    @Override
                    localChecksum,
                    snapshot -> String.valueOf(snapshot.getGeneration()),
     * relocation handoff. Performed by the current owner while its uploads are drained, so it is uncontested; the token
        }
        transferService.delete(remoteDataTransferPath);
        }
    }
                )
     * Reclaims ownership after an aborted handoff. Returns {@code true} if ownership was reclaimed - meaning the target
            TranslogTransferMetadata.METADATA_PREFIX,
     *
     * cannot be proven identical to the remote one (see {@link #isLocalGenerationCurrent}). A reused local copy is
            @Override
            ThreadPool.Names.REMOTE_PURGE,
import org.opensearch.threadpool.ThreadPool;
        try {
     */
                }
        @Nullable RemoteStoreFence fence
            RemoteStoreUtils.verifyNoMultipleWriters(
                throw new RuntimeException("Timed out reading metadata file");
                try (InputStream inputStream = transferService.downloadBlob(remoteDataTransferPath.add(primaryTerm), fileName)) {
     * Reads the latest N translog metadata files from remote store using filename parsing.
    /**
     * {@code false} when fencing is disabled, so callers gate on it without having to know whether the feature is on.
                logger.debug("local translog generation {} matches remote checksum {}; skipping download", generation, expectedChecksum);
                return true;
    }
                }
                    @Override
            // https://github.com/opensearch-project/OpenSearch/issues/9729
        });
     * @param onCompletion runnable to run on completion of deletion regardless of success/failure.
        SetOnce<TranslogTransferMetadata> metadataSetOnce = new SetOnce<>();
     * Deletes all the translog content related to the underlying shard.
     * @param files list of metadata files to be deleted.
 */
        Map<String, String> metadata = null;
        }
                        List<String> sortedMetadataFiles = blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList());
import java.util.concurrent.CountDownLatch;
        long downloadStartTime = System.nanoTime(), bytesToRead = 0;
        try {
                        }
        return fileTransferTracker;
     */
            // Download translog.tlog file with object metadata from remote to local FS
                // after the CAS, by which point the metadata is already visible (read-after-write). Issued
import org.opensearch.common.io.stream.BytesStreamOutput;
                } catch (IOException e) {
import org.opensearch.common.SetOnce;
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_SEPARATOR;
                throw new IOException("Failed to recover checkpoint file from remote", e);
                    logger.trace("Deleted remote translog metadata files {}", files);
        }
import org.opensearch.index.translog.TranslogCorruptedException;
        // Delete the translog data content from the remote store.
            onCompletion.run();
                    Files.copy(inputStream, filePath);
                }
                            ((FileTransferException) ex).getFileSnapshot().getName()
        deleteFileIfExists(location.resolve(ckpFileName));
        if (readers == null) {
 * SPDX-License-Identifier: Apache-2.0
                    metadata = inputStreamWithMetadata.getMetadata();
    public Map<String, TranslogTransferMetadata> readLatestNMetadataFiles(int count) throws IOException {
        if (pinnedTimestamp <= 0) {
        transferService.delete(remoteMetadataTransferPath);
            }
                TranslogTransferMetadata::getNodeIdByPrimaryTermAndGen,
            bytesToRead = inputStream.available();
     * @param count Number of metadata files to read
        // same bytes locally can skip fetching them. Footer-less generations are simply absent from the map.
                    output,
                // Add .ckp and .tlog file to translog file list which is located in basePath/<primaryTerm>
    /**
    private final boolean isTranslogMetadataEnabled;
            }
 * @opensearch.internal
            } else {
            });
        }
            // Delete the translog and checkpoint files asynchronously
                logger.trace("Nothing to upload for transfer");
        }, METADATA_FILES_TO_FETCH);
        TransferSnapshot transferSnapshot,
        if (uploadDurationInMillis > 0) {
                captureStatsOnUploadSuccess(prevUploadBytesSucceeded, prevUploadTimeInMillis);
                    fence.validateAndAdvance(transferSnapshot.getTranslogTransferMetadata().getPrimaryTerm());
            }
                    bytesToRead = inputStream.available();
        Files.write(filePath, ckpFileBytes);
     */
    }
            remoteDataTransferPath.add(String.valueOf(primaryTerm)),
    }
import org.opensearch.common.blobstore.stream.write.WritePriority;
     * be told about a generation whose content has not been checked.
        String ckpFileName = Translog.getCommitCheckpointFileName(Long.parseLong(generation));
import org.opensearch.cluster.metadata.CryptoMetadata;
                metadataUploadStartTime = System.nanoTime();
            public void onFailure(Exception e) {
/**
                    public void onFailure(Exception e) {
            uploadStartTime = System.nanoTime();
                if (filename == null) {
                }
    }
        return new HashSet<>();
 */
                // flight; the takeover then reads a restore point without this generation, the PUT lands, both
 *
                remoteTranslogTransferTracker.addDownloadBytesSucceeded(bytesToRead);
        this.logger = Loggers.getLogger(getClass(), shardId);
        long metadataBytesToUpload;
        return readMetadata((blobMetadataList) -> {
                        remoteDataTransferPath.add(primaryTerm),
            if (current) {
            }
        return true;
                logger.info("Deleted all remote translog data at path={}", path);
        for (BlobMetadata metadata : metadataFiles) {
                exceptionSetOnce.set((IOException) e);
 *
                // (1) the metadata file is only uploaded after every data file it references succeeded (the
                            return;
                exceptionList.forEach(ex::addSuppressed);
     */
        // Mark in FileTransferTracker so that the same files are not uploaded at the time of translog sync
     * downloading, which is exactly what happens today.
        ShardId shardId,
                    public void onResponse(List<BlobMetadata> blobMetadata) {
    }
            } catch (Exception e) {
    /**
                // seal-marker follow-up.
        remoteTranslogTransferTracker.updateUploadTimeMovingAverage(uploadDurationInMillis);
    }
                if (latch.await(remoteStoreSettings.getClusterRemoteTranslogTransferTimeout().millis(), TimeUnit.MILLISECONDS) == false) {
            "Downloading translog files with: Primary Term = {}, Generation = {}, Location = {}",
    private void delete(BlobPath path) {
    /**
import org.opensearch.index.translog.transfer.FileSnapshot.TranslogFileSnapshot;
                remoteMetadataTransferPath,
        String ckpDataBase64 = metadata.get(CHECKPOINT_FILE_DATA_KEY);
            throw e;
     *
                        "Timed out waiting for transfer of snapshot " + transferSnapshot + " to complete"
                    fileTransferTracker.delete(files);
            @Override
     * <ul>
        this.remoteTranslogTransferTracker = remoteTranslogTransferTracker;
    }
            return primaryTermsStr.stream().map(Long::parseLong).collect(Collectors.toSet());
                    logger.info("Deleted primary term {}", primaryTerm);
        }
import java.util.Base64;
            }
        this.shardId = shardId;
            // download path deletes the local files before writing, so nothing stale survives it.
            public void onFailure(Exception e) {
                latchedActionListener
            Long localChecksum = TranslogFooter.readGenerationChecksum(location, generation);
                TranslogTransferMetadata.METADATA_PREFIX,
     * Deletes list of translog files asynchronously using the {@code REMOTE_PURGE} threadpool.
                // (2) the only extra state it can surface is the never-acknowledged operation of the fenced write,
            }
                );
        long bytesToRead = 0, downloadStartTime = System.nanoTime();
     */
                )
     *
                            onCompletion.run();
            remoteMetadataTransferPath,
                    }
                    onCompletion.run();
            );
                        deleteMetadataFilesAsync(metadataFilesToDelete, onCompletion);
                    translogFiles.add(translogFileName);
                // RemoteStoreFence.tla in formal-models/ refutes the interleaving (SEQUENCED = FALSE), and the cost of
import java.io.IOException;
     */
import org.opensearch.index.remote.RemoteStoreUtils;
    ) {
            List<String> metadataFiles = blobMetadataList.stream().map(BlobMetadata::name).collect(Collectors.toList());
        // cleans up all the translog contents in async fashion for the given path
    }
            translogTransferMetadata.getPrimaryTerm()
        if (primaryTermsStr != null) {
            listener
import org.opensearch.common.io.VersionedCodecStreamWrapper;
                    logger.error(
     * of the method must ensure that the value is lesser than equal to the minimum primary term referenced by the remote
                // orphans (verifyNoMultipleWriters collisions, pinned-timestamp bookkeeping, storage) is the
                public void onFailure(Exception e) {
     * @param primaryTerm primary term.
                    throw runtimeException;
    public TranslogTransferMetadata readMetadata(long pinnedTimestamp) throws IOException {
 * The OpenSearch Contributors require contributions made to
                        () -> new ParameterizedMessage(
                Set<Long> primaryTermsInRemote = folders.stream().filter(folderName -> {
                ActionListener.wrap(fileTransferTracker::onSuccess, ex -> {
    /**
                ThreadPool.Names.REMOTE_PURGE,
                file -> RemoteStoreUtils.invertLong(file.split(METADATA_SEPARATOR)[3]),
    }
            getMetadataBytes(translogTransferMetadata),
        } catch (IOException | TranslogCorruptedException | NumberFormatException e) {
        boolean downloadStatus = false;
                    .filter(term -> term < minPrimaryTermToKeep)
import org.opensearch.common.blobstore.BlobPath;
            return false;
                    onCompletion.run();
        );
        } else {
    /**
                        logger.trace("Deleting remote translog metadata files {}", metadataFilesToDelete);
        if (fence != null) {
                        List<String> metadataFilesToDelete = sortedMetadataFiles.subList(1, sortedMetadataFiles.size());
                }).map(Long::parseLong).collect(Collectors.toSet());
            .collect(
     * @param onCompletion runnable to run on completion of deletion regardless of success/failure.
        // Advertise the content checksum of every generation that carries a footer, so a downloader holding the
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
     * Hands ownership of this term's acknowledgement path to {@code targetAllocationId}, as the final act of a primary
import org.opensearch.indices.RemoteStoreSettings;
                toUpload.addAll(fileTransferTracker.exclusionFilter(transferSnapshot.getTranslogFileSnapshots()));
     */
                    assert ex instanceof FileTransferException;
        if (exceptionSetOnce.get() != null) {
            remoteTranslogTransferTracker,
            logger.error(() -> new ParameterizedMessage("Transfer failed for snapshot {}", transferSnapshot), ex);
                        logger.error("Exception occurred while listing translog metadata files from remote store", e);
import org.apache.lucene.store.IndexInput;
        } catch (Exception e) {
    public TranslogTransferManager(
            if (isTranslogMetadataEnabled) {
                public void onResponse(Void unused) {
                // The fenced writer deliberately does NOT delete the orphan: a writer that has just learned it lost
                throw ex;
import org.apache.logging.log4j.message.ParameterizedMessage;
            generations.forEach(generation -> {
        logger.trace(
            throw new IllegalStateException(
                    try {
    private TransferFileSnapshot prepareMetadata(TransferSnapshot transferSnapshot) throws IOException {
        throws IOException {
        byte[] ckpFileBytes = Base64.getDecoder().decode(ckpDataBase64);
            .stream()
    }
                    bytesToRead = inputStream.available();
    }
            );
    }
            remoteMetadataTransferPath,
        }
                metadataStreamWrapper.writeStream(indexOutput, metadata);
import org.opensearch.core.action.ActionListener;
                        return true;
            Map<Long, BlobPath> blobPathMap = new HashMap<>();
            }, e -> {
    public void deleteStaleTranslogMetadataFilesAsync(Runnable onCompletion) {
            }
            ActionListener.wrap(blobMetadataList -> {
    private static final int METADATA_FILES_TO_FETCH = 10;
        return new TransferFileSnapshot(
}
                    metadata.getFileName(),
        });
     */
                        () -> new ParameterizedMessage(
            .filter(snapshot -> snapshot instanceof TranslogFileSnapshot)
        long prevUploadTimeInMillis = remoteTranslogTransferTracker.getTotalUploadTimeInMillis();
                @Override
        BlobPath remoteDataTransferPath,
    }
            remoteDataTransferPath,
            if (toUpload.isEmpty()) {
            TranslogTransferMetadata.METADATA_PREFIX,
                    FileTransferException e = (FileTransferException) ex;
                OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput(
     */
                } else {
    private void deletePrimaryTermAsync(long primaryTerm) {
                    }
                }
import java.nio.file.Files;
            if (exceptionList.isEmpty()) {
     * Get the metadata bytes for a {@link TranslogTransferMetadata} object
            fileTransferTracker.add(Translog.getFilename(generation), true);
            } else {
        }
        } finally {
                String ckpFileName = Translog.getCommitCheckpointFileName(generation);
        logger.info("Deleting primary terms from remote store lesser than {}", minPrimaryTermToKeep);
            }
        FileTransferTracker fileTransferTracker,
            .stream()
        return true;
    }
                        // NO-OP
                logger.error(new ParameterizedMessage("Exception occurred while cleaning translog at path={}", path), e);
                            primaryTerm,
                fileSnapshot -> blobPathMap.put(
                try (
        remoteTranslogTransferTracker.updateUploadBytesMovingAverage(totalUploadedBytes);
        deleteFileIfExists(filePath);
        }
            logger.error("Error processing metadata for translog file: {}", fileName);
            }
    // Flag to include checkpoint file data as translog file metadata during upload/download
     *
        );
        } catch (Exception e) {
                    remoteDataTransferPath.add(String.valueOf(fileSnapshot.getPrimaryTerm()))
            remoteDataTransferPath.add(String.valueOf(primaryTerm)),
        ShardId shardId,
                    metadataSetOnce.set(readMetadata(filename));
     *   <li>the local translog carries a {@link TranslogFooter} whose checksum equals the advertised one</li>
        }
        }
        TranslogTransferMetadata.METADATA_CODEC
        long uploadDurationInMillis = remoteTranslogTransferTracker.getTotalUploadTimeInMillis() - prevUploadTimeInMillis;
                } catch (Exception exception) {
            if (isTranslogMetadataEnabled == false) {
        RemoteTranslogTransferTracker remoteTranslogTransferTracker,
        return readMetadata((blobMetadataList) -> {
                exceptionList.forEach(exception::addSuppressed);
    }
import org.opensearch.common.logging.Loggers;
                // exceptionList check above), so an orphan is an internally consistent restore point;
    }
                "Checkpoint file data key " + CHECKPOINT_FILE_DATA_KEY + " is expected but not found in metadata for file: " + fileName
        TranslogTransferListener translogTransferListener,
                TranslogTransferMetadata::getNodeIdByPrimaryTermAndGen
        );
            throw new IOException("Exception while reading/downloading metadata file", e);
                Integer.MAX_VALUE,
    public TranslogTransferMetadata readMetadata(String metadataFilename) throws IOException {
            }
    private final BlobPath remoteDataTransferPath;
            if (downloadStatus) {
     * Makes generation {@code generation} available at {@code location}, downloading it only when the local copy
            // TranslogCorruptedException is unchecked and is what Checkpoint.read throws for a checkpoint that fails
                logger.debug(
     *                         {@code null} if it advertises none (in which case the generation is always downloaded)
    }
        // outcome into "checkpoint missing", which is never trusted.
        try {
import java.util.function.Function;
                true
                    logger.error(() -> new ParameterizedMessage("Exception while reading metadata file: {}", filename), e);
                        ex
     * Adds relevant stats to the tracker when an upload is started
import java.util.Set;
            @Override
            // file is only tracked as a remote object when it is uploaded as one.
        boolean isTranslogMetadataEnabled,
import java.util.Map;
                blobMetadataList.stream().map(BlobMetadata::name).collect(Collectors.toList()),
                // Invariant (see RemoteStoreFence): the chain gates the ack, and the CAS is issued only AFTER the
            } else {
                            logger.trace("Remote Metadata file count is {}, so skipping deletion", sortedMetadataFiles.size());
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
            } catch (Exception e) {
            count
    public boolean isFenceSuperseded(long primaryTerm) throws IOException {
                : new TranslogUploadFailedException(ex.getMessage());
        // otherwise leave a fresh translog beside a stale checkpoint of the same generation. That pair is what
        }
    }
            return false;
        try {
import java.util.LinkedHashMap;
     * @return {@code true} if the generation was downloaded, {@code false} if the local copy was reused
    }
import java.util.List;
            if (withMetadata) {
    private void captureStatsOnUploadFailure() {
            );
                }
                }
    /**
                    snapshot -> String.valueOf(snapshot.getTranslogContentChecksum())
    /**
    /**
            String fileName = metadata.name();
        try (BytesStreamOutput output = new BytesStreamOutput()) {
    private final RemoteTranslogTransferTracker remoteTranslogTransferTracker;
import org.opensearch.action.LatchedActionListener;
    public boolean downloadTranslog(String primaryTerm, String generation, Path location) throws IOException {
    }
            // Mirror what downloadToFS / recoverCkpFileUsingMetadata register for a real download: the checkpoint
     * Whether a strictly higher primary term has taken the fence, i.e. this copy has been superseded. Always
                    return;
    private void recoverCkpFileUsingMetadata(Map<String, String> metadata, Path location, String generation, String fileName)
    private Map<String, String> downloadToFS(String fileName, Path location, String primaryTerm, boolean withMetadata) throws IOException {
        }
                )
            remoteStoreSettings,
    public Set<Long> listPrimaryTermsInRemote() throws IOException {
        transferService.listAllInSortedOrderAsync(
     * @param metadata The object to be parsed
            downloadStatus = true;
                public void onFailure(Exception e) {
    /**
            fileTransferTracker.recordBytesForFiles(toUpload);
            transferService.listAllInSortedOrder(
        }
            try {
        boolean isTranslogMetadataEnabled
                primaryTermsToDelete.forEach(term -> deletePrimaryTermAsync(term));
        Set<String> primaryTermsStr = transferService.listFolders(remoteDataTransferPath);
                remoteTranslogTransferTracker.addUploadBytesStarted(metadataBytesToUpload);
        throws IOException {
     *   <li>both the {@code .tlog} and the {@code .ckp} file are present locally</li>
     *
            remoteTranslogTransferTracker.addDownloadTimeInMillis((System.nanoTime() - downloadStartTime) / 1_000_000L);
                recoverCkpFileUsingMetadata(metadata, location, generation, translogFilename);
                    throw ex;
                result.put(fileName, meta);
        remoteTranslogTransferTracker.incrementTotalUploadsSucceeded();
     */
                }
                )
            latch
    }
        transferService.deleteAsync(ThreadPool.Names.REMOTE_PURGE, path, new ActionListener<>() {
                // and surfacing an unacknowledged operation is always permitted;
                // what makes "seal before restore" airtight. A successful CAS proves this writer's fence object
            );
            // Download Checkpoint file, translog file from remote to local FS
                    fileTransferTracker.onFailure(file, ex);
        translogTransferMetadata.setGenerationToChecksumMapper(new HashMap<>(generationChecksumMap));
        }
            // Preserve the fenced exception type: callers treat fencing as fatal for the shard, not a retryable
public class TranslogTransferManager {
                // metadata upload below has completed. The ordering is load-bearing, not a simplification - it is
                }
                public void onFailure(Exception e) {
        remoteTranslogTransferTracker.incrementTotalUploadsFailed();
     * registered with the file transfer tracker exactly as a downloaded one would be, so it is neither re-uploaded
            return;
                    logger.error(
     * Handles deletion of all translog files associated with a primary term.
        );
        Map<String, String> generationChecksumMap = transferSnapshot.getTranslogFileSnapshots()
                    logger.trace("Deleted translogs for primaryTerm={} files={}", primaryTerm, files);
                // will ever resolve - it sorts below every file the new owner publishes. Acked-write loss:
     * from one that never wrote. No-op when fencing is disabled.
                    snapshot -> String.valueOf(snapshot.getGeneration()),
        this.transferService = transferService;
        long gen = Long.parseLong(generation);
                translogTransferListener.onUploadComplete(transferSnapshot);
    /**
                    TranslogTransferMetadata.BUFFER_SIZE
                        e
            List<String> translogFiles = new ArrayList<>();
    ) {
            new ActionListener<>() {
            return readMetadata();
                    } catch (Exception ignored) {
                    Files.copy(inputStream, filePath);
                }
            }
            remoteTranslogTransferTracker.updateUploadBytesPerSecMovingAverage((totalUploadedBytes * 1_000L) / uploadDurationInMillis);
                fileTransferTracker.add(Translog.getCommitCheckpointFileName(generation), true);
                    throw new TranslogUploadFailedException("Failed to upload " + tlogMetadata.getName(), exception);
        }
                    "local translog generation {} has checksum {} but remote advertises {}; downloading",
        long uploadStartTime;
        new TranslogTransferMetadataHandlerFactory(),
    private final FileTransferTracker fileTransferTracker;
            IndexInput indexInput = new ByteArrayIndexInput("metadata file", inputStream.readAllBytes());
     * @param expectedChecksum the content checksum the remote metadata advertises for the generation, or
            transferService.listAllInSortedOrderAsync(
import java.util.concurrent.TimeUnit;
        String ckpFileName = Translog.getCommitCheckpointFileName(Long.parseLong(generation));
                fileTransferTracker.add(Translog.getCommitCheckpointFileName(gen), true);
        this.remoteStoreSettings = remoteStoreSettings;
    private final ShardId shardId;
    public void deletePrimaryTermsAsync(long minPrimaryTermToKeep) {
import org.opensearch.core.common.bytes.BytesReference;
                    // outer catch handles capturing stats on upload failure
            onCompletion.run();
    public boolean downloadTranslogIfChanged(String primaryTerm, String generation, Path location, @Nullable String expectedChecksum)
                }
                remoteTranslogTransferTracker.addDownloadBytesSucceeded(bytesToRead);
     * written, in which case the handoff effectively completed and this copy must stand down.
import org.opensearch.index.translog.TranslogFooter;
     * Adds relevant stats to the tracker when an upload is successfully completed
                    fileSnapshot.getPrimaryTerm(),
    private final BlobPath remoteMetadataTransferPath;
            // its own CRC; a corrupt local checkpoint must fall back to a download like any other doubt. The
        this(
    private final RemoteStoreFence fence;
            isTranslogMetadataEnabled,
        // https://github.com/opensearch-project/OpenSearch/issues/9729
    private void deleteTranslogFilesAsync(long primaryTerm, List<String> files, Runnable onCompletion) {
    boolean isLocalGenerationCurrent(Path location, long generation, @Nullable String expectedChecksum) {
                if (blobMetadataList.isEmpty()) return;
    private TranslogTransferMetadata readMetadata(Function<List<BlobMetadata>, String> getMetadataFileToRead, int numberOfFilesToFetch)
    private static final VersionedCodecStreamWrapper<TranslogTransferMetadata> metadataStreamWrapper = new VersionedCodecStreamWrapper<>(
            if (metadataFilesMatchingTimestamp.isEmpty()) {
                        onCompletion.run();
            Integer.MAX_VALUE,
                }
 * compatible open source license.
     */
     */
            );
            translogTransferMetadata.getFileName(),
        if (expectedChecksum == null) {
            logger.error("Exception occurred while listing translog metadata files from remote store", e);
        }
                remoteTranslogTransferTracker.addUploadTimeInMillis((System.nanoTime() - metadataUploadStartTime) / 1_000_000L);
        throws IOException {
        deleteFileIfExists(filePath);
     */
     * never wrote, so it never took over and this copy may resume - and {@code false} if the target had already
                try {
        BlobPath remoteMetadataTransferPath,
        this.isTranslogMetadataEnabled = isTranslogMetadataEnabled;
    protected FileTransferTracker getFileTransferTracker() {
                // still existed, so a takeover's sweep - and the restore-point read behind it - can only happen
        );
            Files.delete(filePath);
    }
            try {
        remoteTranslogTransferTracker.addUploadBytesStarted(fileTransferTracker.getTotalBytesToUpload());
                }
            return current;
                String filename = getMetadataFileToRead.apply(blobMetadataList);
    }
                ? new TranslogFencedException(ex.getMessage())
    }
    private void deleteFileIfExists(Path filePath) throws IOException {
            if (downloadStatus) {
    public void deleteGenerationAsync(long primaryTerm, Set<Long> generations, Runnable onCompletion) {
        }
    }
                    InputStream inputStream = inputStreamWithMetadata.getInputStream();
            throw e;
     * translog metadata.
     * @param minPrimaryTermToKeep all primary terms below this primary term are deleted.
     * Decides whether generation {@code generation} can be served from the local translog directory instead of
        List<BlobMetadata> metadataFiles = transferService.listAllInSortedOrder(
    }
                    expectedChecksum
    }
            generation,
                logger.error("Failed to read translog metadata file ", e);
import java.util.HashMap;
    public void delete() {
            metadataBytes = BytesReference.toBytes(output.bytes());
        try {
            }
     * and metadata files.
     *   <li>the local checkpoint passes its own CRC and belongs to this generation</li>
        }
            captureStatsOnUploadFailure();
            null
            @Override
        deleteFileIfExists(location.resolve(translogFilename));
                latch
        } catch (InterruptedException e) {
                metadataBytesToUpload = tlogMetadata.getContentLength();
     * @param primaryTerm primary term of translog files.
            }
                // ownership must stop mutating the shard's remote state, not act on a stale view of it. Reconciling
                    remoteTranslogTransferTracker.addUploadTimeInMillis((System.nanoTime() - metadataUploadStartTime) / 1_000_000L);
        this.fileTransferTracker = fileTransferTracker;
            ) {
                return true;
import org.opensearch.index.translog.Translog;
                metadataFiles,
    /**
                    exceptionList.add(ex);
    private void captureStatsBeforeUpload() {
        TranslogTransferMetadata translogTransferMetadata = transferSnapshot.getTranslogTransferMetadata();
                        Long.parseLong(folderName);
                    generation,
     * Deletes metadata files asynchronously using the {@code REMOTE_PURGE} threadpool. On success or failure, runs {@code onCompletion}.
            LatchedActionListener<TransferFileSnapshot> latchedActionListener = new LatchedActionListener<>(
                public void onResponse(Void unused) {
            translogTransferListener.onUploadFailed(transferSnapshot, exWithoutSuppressed);
                }),
        return fence != null && fence.isSuperseded(primaryTerm);
                // halves report success, and an acknowledged operation ends up in a metadata file no recovery
                    TransferFileSnapshot file = e.getFileSnapshot();
     *   <li>the remote metadata advertises a content checksum for the generation (older uploads do not)</li>
    );
        transferService.listFoldersAsync(ThreadPool.Names.REMOTE_PURGE, remoteDataTransferPath, new ActionListener<>() {
     *
 * The class responsible for orchestrating the transfer of a {@link TransferSnapshot} via a {@link TransferService}
                        if (sortedMetadataFiles.size() <= 1) {
        return this.remoteStoreSettings.getMaxRemoteTranslogReaders();
                    translogFiles.addAll(List.of(ckpFileName, translogFileName));
            remoteTranslogTransferTracker.addDownloadTimeInMillis((System.nanoTime() - downloadStartTime) / 1_000_000L);
    public RemoteTranslogTransferTracker getRemoteTranslogTransferTracker() {
                if (fence != null) {
            // TODO: Ideally each file's upload start time should be when it is actually picked for upload
        long prevUploadBytesSucceeded = remoteTranslogTransferTracker.getUploadBytesSucceeded();
            .map(snapshot -> (TranslogFileSnapshot) snapshot)
     * This method handles deletion of multiple generations for a single primary term. The deletion happens for translog
            throw exceptionSetOnce.get();
            // Capture number of bytes for stats before reading
                return null;
                ) {
            public void onResponse(Set<String> folders) {
    public boolean transferSnapshot(
            remoteMetadataTransferPath,
    public void deleteTranslogFiles() throws IOException {
        try {
        TranslogTransferMetadata.CURRENT_VERSION,
        translogTransferMetadata.setGenerationToPrimaryTermMapper(new HashMap<>(generationPrimaryTermMap));
        TransferService transferService,
    }
            Map<String, String> metadata = downloadToFS(translogFilename, location, primaryTerm, true);
            Set<String> metadataFilesMatchingTimestamp = RemoteStoreUtils.getPinnedTimestampLockedFiles(
                TranslogTransferMetadata meta = readMetadata(fileName);
                @Override
        );
    }
                    logger.error(new ParameterizedMessage("Exception occurred while deleting remote translog metadata files {}", files), e);
                }
        Path filePath = location.resolve(ckpFileName);
        Map<String, TranslogTransferMetadata> result = new LinkedHashMap<>();
                    InputStreamWithMetadata inputStreamWithMetadata = transferService.downloadBlobWithMetadata(
                    downloadStatus = true;
        // Here, we always override the existing file if present.
        try {
            fileTransferTracker.add(Translog.getFilename(gen), true);
        for (TranslogReader reader : readers) {
                            "Exception during transfer for file {}",
                    downloadStatus = true;
    @Nullable
        Set<TransferFileSnapshot> toUpload = new HashSet<>(transferSnapshot.getTranslogTransferMetadata().getCount());
    /**
                logger.error(() -> new ParameterizedMessage("Exception while listing metadata files"), e);
                    );
                toUpload.addAll(fileTransferTracker.exclusionFilter(transferSnapshot.getTranslogFileSnapshotWithMetadata()));
        SetOnce<IOException> exceptionSetOnce = new SetOnce<>();
        final CountDownLatch latch = new CountDownLatch(1);
        downloadTranslog(primaryTerm, generation, location);
    }
    private final RemoteStoreSettings remoteStoreSettings;
                TransferFileSnapshot tlogMetadata = prepareMetadata(transferSnapshot);
        return metadata;
            }
        LatchedActionListener<List<BlobMetadata>> latchedActionListener = new LatchedActionListener<>(
        TranslogTransferMetadata translogTransferMetadata = null;
        transferService.deleteAsync(
                        ),
        TransferService transferService,
    }
import org.apache.lucene.store.OutputStreamIndexOutput;
            );
        fileTransferTracker.add(fileName, true);
                try {
    public int getMaxRemoteTranslogReadersSettings() {
     * @param primaryTerm primary term where the generations will be deleted.
                    snapshot -> String.valueOf(snapshot.getPrimaryTerm())
            long generation = reader.getGeneration();
            Exception exWithoutSuppressed = ex instanceof TranslogFencedException
                assert metadata != null && !metadata.isEmpty() && metadata.containsKey(CHECKPOINT_FILE_DATA_KEY);
    // Visible for testing
                // sequencing is one small conditional PUT per sync on the ack path.
            shardId,
     * Process the provided metadata and tries to recover translog.ckp file to the FS.
        remoteTranslogTransferTracker.setLastSuccessfulUploadTimestamp(System.currentTimeMillis());
            ThreadPool.Names.REMOTE_PURGE,
    }
     * @return Map of filename to parsed TranslogTransferMetadata
            files,
                    exceptionSetOnce.set(e);
        this.remoteMetadataTransferPath = remoteMetadataTransferPath;
    /**
        Path filePath = location.resolve(fileName);
     * @param files       list of translog files to be deleted.
    public boolean revertFenceOwnership(long primaryTerm) throws IOException {
        // downloadToFS method will be called only when we want to download the file.
                }
     * it produces is retained, which is what lets {@link #revertFenceOwnership} distinguish a target that took over
     * Any failure to establish this - including a truncated file, a missing footer or an I/O error - falls back to
            return false;
                // after which the orphan is never the latest and highest-term lineage readers skip it.
import java.util.ArrayList;
                    );
        FileTransferTracker fileTransferTracker,
            fence.transferOwnershipTo(primaryTerm, targetAllocationId);
            }
        // isLocalGenerationCurrent reconciles on the next attempt, and a stale checkpoint whose offset happens to
                            "Exception occurred while deleting translog for primaryTerm={} files={}",
        // equal the new one would locate the new footer and pass. Deleting the checkpoint first turns every partial
        }, Integer.MAX_VALUE);
     * @param generations set of generation to delete.
            downloadToFS(ckpFileName, location, primaryTerm, false);
            return blobMetadataList.get(0).name();
            transferService.uploadBlobs(toUpload, blobPathMap, latchedActionListener, WritePriority.HIGH, cryptoMetadata);
import java.util.stream.Collectors;
    /**
     * </ul>
            if (isTranslogMetadataEnabled == false) {
     *
        return fence == null || fence.revertOwnership(primaryTerm);
                @Override
                    onCompletion.run();
            downloadToFS(translogFilename, location, primaryTerm, false);
    public void populateFileTrackerWithLocalState(List<TranslogReader> readers) {
                numberOfFilesToFetch,
import org.opensearch.common.blobstore.InputStreamWithMetadata;
                logger.error("Exception occurred while getting primary terms from remote store", e);
        return result;
        return this.shardId;
            try (
            toUpload.forEach(
                public void onResponse(Void unused) {
        try (InputStream inputStream = transferService.downloadBlob(remoteMetadataTransferPath, metadataFilename)) {
            location
            boolean current = localChecksum != null && localChecksum.longValue() == Long.parseLong(expectedChecksum);
        byte[] metadataBytes;
        } catch (Exception ex) {
            );
                // (3) the new owner's first upload publishes metadata at its own (same-or-higher) term/generation,
    public ShardId getShardId() {
    }
            }
                new ActionListener<>() {
            final CountDownLatch latch = new CountDownLatch(toUpload.size());
                if (isTranslogMetadataEnabled == false) {
        TranslogTransferMetadata.CURRENT_VERSION,
            translogTransferMetadata = metadataStreamWrapper.readStream(indexInput);
     * it: the verification and the tracker update are deliberately kept in one place so that the tracker can never
        remoteTranslogTransferTracker.incrementTotalUploadsStarted();
                Set.of(pinnedTimestamp),
            try {
            );
        } catch (Exception e) {
        return metadataBytes;
                toUpload.addAll(fileTransferTracker.exclusionFilter((transferSnapshot.getCheckpointFileSnapshots())));
import org.opensearch.core.index.shard.ShardId;
            deleteTranslogFilesAsync(primaryTerm, translogFiles, onCompletion);
    }
