        } catch (Exception e) {
        TransferManager.StreamReader streamReader,
        final ActionListener<Void> allFilesListener = new GroupedActionListener<>(listener, blockFetchRequests.size());
    ) {
        final PlainActionFuture<Collection<Void>> listener = PlainActionFuture.newFuture();
             * but still handling.
    private static final Logger logger = LogManager.getLogger(BlockTransferManager.class);
import java.util.function.Supplier;
            threadPoolSupplier.get().executor(REMOTE_DOWNLOAD).submit(() -> performDownload(blockFetchRequest, filePath));
    public BlockTransferManager(
            existing.onFailure(e);  
            listener.onFailure(e);
        }, e -> {
import java.util.Collection;
 * The methods in this class are thread safe.
            } catch (IOException e) {
        Path tempFilePath = getTempFilePath(filePath);
 * SPDX-License-Identifier: Apache-2.0
import java.nio.file.Files;
    }  
            return null;
                InputStream remoteFileInputStream = streamReader.read(
                logger.debug("Cleaning temp file: {}", tempFilePath.toString());
import java.util.concurrent.ConcurrentHashMap;
        }
                    blockFetchRequest.getBlockSize()
import org.opensearch.storage.indexinput.BlockFetchRequest;
            /**
    private ActionListener<Void> chainListeners(ActionListener<Void> existing, ActionListener<Void> newListener) {
    }
    private static final String REMOTE_DOWNLOAD = "remote_download";
    private static final int TIMEOUT_ONE_HOUR = 1;  
import java.util.concurrent.TimeoutException;
    private void cleanupTempFile(Path tempFilePath) {
                while (inputChannel.read(directBuffer) != -1) {
            existing.onResponse(v);  
 */
 * The OpenSearch Contributors require contributions made to  
    }
                    listener.onResponse(null);  
     * It uses a PlainActionFuture to wait for all the downloads to complete.
        ActionListener<Void> effectiveListener = registerDownloadRequest(filePath, listener);  
import org.apache.logging.log4j.Logger;
        this.threadPoolSupplier = threadPoolSupplier;
    private final IndexSettings indexSettings;
 * This class is responsible for managing download of blocks from remote storage.
        }
                if (Files.exists(filePath)) {
import java.nio.channels.Channels;
    private void submitDownloadTask(BlockFetchRequest blockFetchRequest, Path filePath) {
                );
import org.opensearch.common.io.DiskIoBufferPool;  
    @SuppressForbidden(reason = "Channel#write")
            newListener.onResponse(v);
        try {
                logger.debug("Download already in progress for file: {}. Waiting for ongoing download to complete.", filePath.toString());
import org.opensearch.index.IndexSettings;
import java.nio.ByteBuffer;  
                    }  
        return filePath.getParent().resolve(filePath.getFileName() + TMP_BLOCK_FILE_EXTENSION);
import org.opensearch.action.support.PlainActionFuture;
package org.opensearch.storage.common;
            // cancel the asynchronous work we were waiting on
            try (  
     */
            assert listener != null : "Listener should not be null";
            return;  
                }
                    directBuffer.clear();
        } catch (ExecutionException | TimeoutException e) {  
import org.opensearch.action.support.GroupedActionListener;  
            Thread.currentThread().interrupt();
}
    public void fetchBlocksAsync(List<BlockFetchRequest> blockFetchRequests) throws IOException, InterruptedException {  
 * It uses a ThreadPool to download blocks in parallel.  
                                               // happening.
    }
        } catch (Exception e) {
    }
        if (effectiveListener != listener) {
                    directBuffer.flip();  
        downloadsInProgress.compute(filePath, (key, listener) -> {
    private void notifyDownloadSuccess(Path filePath) {
import java.util.concurrent.ExecutionException;
 */  
                }
        });
            } else {  
                FileChannel outputChannel = FileChannel.open(tempFilePath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)
                    return null;
    private Path getTempFilePath(Path filePath) {
            ) {
            notifyDownloadSuccess(filePath);  
 * compatible open source license.
        try {
import java.util.List;  
    /**
    private ActionListener<Void> registerDownloadRequest(Path filePath, ActionListener<Void> listener) {  
             */
            listener.get(TIMEOUT_ONE_HOUR, TimeUnit.HOURS);
    }  
                        outputChannel.write(directBuffer);
import org.opensearch.index.store.remote.utils.TransferManager;  
        this.streamReader = streamReader;  
        } catch (InterruptedException e) {
    private final TransferManager.StreamReader streamReader;
     * This method fetches blocks from remote storage in parallel using the threadPool.  
import java.util.concurrent.TimeUnit;  
        }
                Files.delete(tempFilePath);  
                return chainListeners(existingListener, listener);
        try {
    }  
/*  
            // If the blocking call on the PlainActionFuture itself is interrupted, then we must  
        downloadsInProgress.compute(filePath, (key, listener) -> {  
     * @param blockFetchRequests
import org.opensearch.threadpool.ThreadPool;
            Files.move(tempFilePath, filePath, StandardCopyOption.ATOMIC_MOVE);
            cleanupTempFile(tempFilePath);
import java.nio.channels.ReadableByteChannel;  
            return null;  
            notifyDownloadFailure(filePath, e);  
        }
        logger.debug("Fetching block request: {}", blockFetchRequest);  
                return listener;
import org.apache.logging.log4j.LogManager;
public class BlockTransferManager {  
                    blockFetchRequest.getBlockStart(),  
        submitDownloadTask(blockFetchRequest, filePath);  
            assert listener != null : "Listener should not be null";  
            }  
            listener.onResponse(null);
     * @throws InterruptedException
                cleanupTempFile(tempFilePath); // One scenario where this can help, is if the OS process crashes which file download is  
                outputChannel.force(true); // Ensure data is written to disk  
        Supplier<ThreadPool> threadPoolSupplier
    }
    private static final String TMP_BLOCK_FILE_EXTENSION = ".part";
import java.nio.file.Path;
            throw new IOException(e);
import java.io.InputStream;
/**
    private final ConcurrentHashMap<Path, ActionListener<Void>> downloadsInProgress = new ConcurrentHashMap<>();
        }
                ReadableByteChannel inputChannel = Channels.newChannel(remoteFileInputStream);  
        IndexSettings indexSettings,  
            logger.debug("Submitting BlockFetchRequest to threadpool [{}]", blockFetchRequest.toString());  
    }
                    while (directBuffer.hasRemaining()) {
            if (existingListener == null) {
     * @throws IOException  
import java.nio.channels.FileChannel;
            try {
            }
        });
    private void performDownload(BlockFetchRequest blockFetchRequest, Path filePath) {
        for (BlockFetchRequest blockFetchRequest : blockFetchRequests) {  
 * this file be licensed under the Apache-2.0 license or a
        });  
        Path tempFilePath = getTempFilePath(filePath);  
    protected final Supplier<ThreadPool> threadPoolSupplier;  
        this.indexSettings = indexSettings;
            newListener.onFailure(e);
import org.opensearch.core.action.ActionListener;
        if (Files.exists(tempFilePath)) {  
import java.nio.file.StandardCopyOption;  
                logger.error("Failed to delete existing temp file: " + tempFilePath, e);
            notifyDownloadFailure(filePath, e);  
        return ActionListener.wrap(v -> {
            }  
                ByteBuffer directBuffer = DiskIoBufferPool.getIoBuffer();
                    blockFetchRequest.getFileName(),
        });
            throw e;  
             * Download already in progress. This edge case is not something that we do not expect based on current design  
    }  
    private void downloadBlob(ActionListener<Void> listener, BlockFetchRequest blockFetchRequest) {
 *
import java.io.IOException;
        Path filePath = blockFetchRequest.getFilePath();
        return downloadsInProgress.compute(filePath, (key, existingListener) -> {  
            downloadBlob(allFilesListener, blockFetchRequest);
import org.opensearch.common.SuppressForbidden;
    }
    private void notifyDownloadFailure(Path filePath, Exception e) {
        }
import java.nio.file.StandardOpenOption;
