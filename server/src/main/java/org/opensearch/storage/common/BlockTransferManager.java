        downloadsInProgress.compute(filePath, (key, listener) -> {
 * It uses a ThreadPool to download blocks in parallel.
        if (Files.exists(tempFilePath)) {
                cleanupTempFile(tempFilePath); // One scenario where this can help, is if the OS process crashes which file download is
            throw new IOException(e);
            notifyDownloadFailure(filePath, e);
import org.opensearch.common.io.DiskIoBufferPool;
            logger.debug("Submitting BlockFetchRequest to threadpool [{}]", blockFetchRequest.toString());
    }
 * The methods in this class are thread safe.
import java.nio.file.StandardOpenOption;
            notifyDownloadSuccess(filePath);
                return listener;
import java.util.concurrent.TimeoutException;
        }
    public void fetchBlocksAsync(List<BlockFetchRequest> blockFetchRequests) throws IOException, InterruptedException {
                );
import org.opensearch.action.support.PlainActionFuture;
    }
            assert listener != null : "Listener should not be null";
    private static final String REMOTE_DOWNLOAD = "remote_download";
            try {
        } catch (Exception e) {
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.ExecutionException;
            } else {
    }
    }
import java.io.InputStream;
            // If the blocking call on the PlainActionFuture itself is interrupted, then we must
     */
    private static final int TIMEOUT_ONE_HOUR = 1;
        });
            threadPoolSupplier.get().executor(REMOTE_DOWNLOAD).submit(() -> performDownload(blockFetchRequest, filePath));
                ReadableByteChannel inputChannel = Channels.newChannel(remoteFileInputStream);
        final ActionListener<Void> allFilesListener = new GroupedActionListener<>(listener, blockFetchRequests.size());
        ActionListener<Void> effectiveListener = registerDownloadRequest(filePath, listener);
            Files.move(tempFilePath, filePath, StandardCopyOption.ATOMIC_MOVE);
                    directBuffer.flip();
     * @throws InterruptedException
                logger.error("Failed to delete existing temp file: " + tempFilePath, e);
        for (BlockFetchRequest blockFetchRequest : blockFetchRequests) {
    private static final Logger logger = LogManager.getLogger(BlockTransferManager.class);
            throw e;
                if (Files.exists(filePath)) {
    private void submitDownloadTask(BlockFetchRequest blockFetchRequest, Path filePath) {
    }
            notifyDownloadFailure(filePath, e);
        }
    private void performDownload(BlockFetchRequest blockFetchRequest, Path filePath) {
                ByteBuffer directBuffer = DiskIoBufferPool.getIoBuffer();
        this.threadPoolSupplier = threadPoolSupplier;
import java.nio.file.StandardCopyOption;
            assert listener != null : "Listener should not be null";
 */
/*
        } catch (InterruptedException e) {
            newListener.onResponse(v);
import org.apache.logging.log4j.LogManager;
    @SuppressForbidden(reason = "Channel#write")
        try {
import java.util.Collection;
            listener.get(TIMEOUT_ONE_HOUR, TimeUnit.HOURS);
            cleanupTempFile(tempFilePath);
    protected final Supplier<ThreadPool> threadPoolSupplier;
        return downloadsInProgress.compute(filePath, (key, existingListener) -> {
        } catch (Exception e) {
        IndexSettings indexSettings,
    }
                    blockFetchRequest.getFileName(),
                Files.delete(tempFilePath);
    private void downloadBlob(ActionListener<Void> listener, BlockFetchRequest blockFetchRequest) {
package org.opensearch.storage.common;
 * this file be licensed under the Apache-2.0 license or a
            }
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
public class BlockTransferManager {
            }
import java.nio.file.Files;
    }
        }
        Path tempFilePath = getTempFilePath(filePath);
import java.io.IOException;
            existing.onFailure(e);
    private static final String TMP_BLOCK_FILE_EXTENSION = ".part";
    private final IndexSettings indexSettings;
            return null;
                        outputChannel.write(directBuffer);
import java.util.concurrent.ConcurrentHashMap;
     * It uses a PlainActionFuture to wait for all the downloads to complete.
     * @param blockFetchRequests
            listener.onResponse(null);
import org.apache.logging.log4j.Logger;
        Path tempFilePath = getTempFilePath(filePath);
        Path filePath = blockFetchRequest.getFilePath();
                                               // happening.
        }
}
        try {
            newListener.onFailure(e);
        this.indexSettings = indexSettings;
    }
        this.streamReader = streamReader;
import org.opensearch.storage.indexinput.BlockFetchRequest;
import java.util.List;
                }
             * but still handling.
/**
            // cancel the asynchronous work we were waiting on
                    return null;
                InputStream remoteFileInputStream = streamReader.read(
        return filePath.getParent().resolve(filePath.getFileName() + TMP_BLOCK_FILE_EXTENSION);
    }
        });
                FileChannel outputChannel = FileChannel.open(tempFilePath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)
                    }
             * Download already in progress. This edge case is not something that we do not expect based on current design
                    directBuffer.clear();
            existing.onResponse(v);
import org.opensearch.core.action.ActionListener;
    private ActionListener<Void> chainListeners(ActionListener<Void> existing, ActionListener<Void> newListener) {
            ) {
            }
                return chainListeners(existingListener, listener);
    private final ConcurrentHashMap<Path, ActionListener<Void>> downloadsInProgress = new ConcurrentHashMap<>();
            Thread.currentThread().interrupt();
                    blockFetchRequest.getBlockStart(),
            if (existingListener == null) {
        logger.debug("Fetching block request: {}", blockFetchRequest);
        submitDownloadTask(blockFetchRequest, filePath);
 */
                while (inputChannel.read(directBuffer) != -1) {
        });
    /**
                }
        } catch (ExecutionException | TimeoutException e) {
import org.opensearch.index.store.remote.utils.TransferManager;
    private void notifyDownloadFailure(Path filePath, Exception e) {
import org.opensearch.index.IndexSettings;
            return null;
import java.nio.ByteBuffer;
        TransferManager.StreamReader streamReader,
        });
                logger.debug("Download already in progress for file: {}. Waiting for ongoing download to complete.", filePath.toString());
    private void notifyDownloadSuccess(Path filePath) {
import org.opensearch.threadpool.ThreadPool;
        try {
            /**
import org.opensearch.action.support.GroupedActionListener;
            try (
        }
                    while (directBuffer.hasRemaining()) {
    public BlockTransferManager(
            listener.onFailure(e);
    }
import org.opensearch.common.SuppressForbidden;
 * SPDX-License-Identifier: Apache-2.0
            return;
        final PlainActionFuture<Collection<Void>> listener = PlainActionFuture.newFuture();
     * @throws IOException
            downloadBlob(allFilesListener, blockFetchRequest);
             */
                outputChannel.force(true); // Ensure data is written to disk
                logger.debug("Cleaning temp file: {}", tempFilePath.toString());
 *
        }, e -> {
    ) {
 * This class is responsible for managing download of blocks from remote storage.
                    listener.onResponse(null);
     * This method fetches blocks from remote storage in parallel using the threadPool.
        return ActionListener.wrap(v -> {
    private final TransferManager.StreamReader streamReader;
import java.util.concurrent.TimeUnit;
import java.nio.channels.FileChannel;
    private ActionListener<Void> registerDownloadRequest(Path filePath, ActionListener<Void> listener) {
        downloadsInProgress.compute(filePath, (key, listener) -> {
    private Path getTempFilePath(Path filePath) {
import java.nio.channels.Channels;
        }
import java.util.function.Supplier;
    private void cleanupTempFile(Path tempFilePath) {
    }
        Supplier<ThreadPool> threadPoolSupplier
import java.nio.file.Path;
            } catch (IOException e) {
                    blockFetchRequest.getBlockSize()
        if (effectiveListener != listener) {
