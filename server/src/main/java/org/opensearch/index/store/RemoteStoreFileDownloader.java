            // Queue is empty, so notify listener we are done
        final String file = queue.poll();
        final CancellableThreads cancellableThreads = new CancellableThreads();
                final long fileLength = in.fileLength(name);
     */
        downloadInternal(cancellableThreads, source, destination, secondDestination, toDownloadSegments, onFileCompletion, listener);
     * @param toDownloadSegments The list of segment files to download
            throw e;
            throw new RuntimeException(e);
            listener.onResponse(null);
                    // Clear the queue to stop any future processing, report the failure, then return
        final int threads = Math.min(
 * compatible open source license.
        return new FilterDirectory(source) {
import org.opensearch.action.support.GroupedActionListener;  
                    listener.onFailure(e);  
    /**
            Thread.currentThread().interrupt();  
        );
}
        // - number of files to download
            return source;
     * @param source The remote directory to copy segment files from
        final Executor executor = threadPool.executor(ThreadPool.Names.REMOTE_RECOVERY);  
import java.util.concurrent.ExecutionException;  
import java.io.IOException;
                logger.trace("Downloading file {}", file);
        final ActionListener<Void> allFilesListener = new GroupedActionListener<>(ActionListener.map(listener, r -> null), threads);
    public void downloadAsync(  
        // - max thread pool size
        Directory destination,  
 *
                        destination.copyFrom(source, file, file, IOContext.DEFAULT);
 * this file be licensed under the Apache-2.0 license or a
            } else if (e.getCause() instanceof IOException) {
            return source;
        // Choose the minimum of:  
            public IndexInput openInput(String name, IOContext context) throws IOException {  
        }
    ) throws InterruptedException, IOException {
        this.threadPool = threadPool;  
            @Override
            copyOneFile(cancellableThreads, parallelSource, destination, secondDestination, queue, onFileCompletion, allFilesListener);  
        downloadInternal(cancellableThreads, source, destination, null, toDownloadSegments, () -> {}, listener);
    private final Logger logger;  
        try {
        Directory secondDestination,
            Math.min(threadPool.info(ThreadPool.Names.REMOTE_RECOVERY).getMax(), recoverySettings.getMaxConcurrentRemoteStoreStreams())  
            // cancel the asynchronous work we were waiting on
        Queue<String> queue,
        @Nullable Directory secondDestination,  
        Runnable onFileCompletion,
        }  
        Runnable onFileCompletion  
            }
        ActionListener<Void> listener  
import java.util.concurrent.ConcurrentLinkedQueue;
     * @param onFileCompletion A generic runnable that is invoked after each file download.  
/**  
        Directory source,
    private Directory wrapForParallelPartDownload(Directory source) {
        }
     */
        Collection<String> toDownloadSegments,
        Collection<String> toDownloadSegments,
        if (file == null) {  
    }  
    private void copyOneFile(
        @Nullable Directory secondDestination,  
 */  
     * local directory.  
public final class RemoteStoreFileDownloader {
        CancellableThreads cancellableThreads,
     */  
     * budget fall through to the plain single-stream {@link Directory#openInput}.  
            threadPool.executor(ThreadPool.Names.REMOTE_RECOVERY).submit(() -> {
import org.apache.lucene.store.IOContext;
     *                          copied to after being copied to the local directory
        ActionListener<Void> listener
    /**
     * @param destination The local directory to copy segment files to
    private final ThreadPool threadPool;
     * @param toDownloadSegments The list of segment files to download  
        this.recoverySettings = recoverySettings;
        for (int i = 0; i < threads; i++) {
                            secondDestination.copyFrom(destination, file, file, IOContext.DEFAULT);  
    }
     * still presented sequentially, so the regular {@link Directory#copyFrom} path (and every stats, checksum and
        ActionListener<Void> listener  
     * Copies the given segments from the remote segment store to the given
        if (source instanceof RemoteSegmentStoreDirectory == false) {  
    }
                copyOneFile(cancellableThreads, source, destination, secondDestination, queue, onFileCompletion, listener);  
     * @param destination The local directory to copy segment files to
import org.apache.lucene.store.FilterDirectory;  
import org.apache.lucene.store.Directory;
     * @param source The remote directory to copy segment files from
 * The OpenSearch Contributors require contributions made to  
        } catch (ExecutionException e) {
 * @opensearch.api
     * {@link ParallelPartInputStream}s: the bytes are fetched as multiple concurrent byte-range requests but are  
 * instance to a local {@link Directory} instance in parallel depending on thread
        if (permits.getMaxPermits() <= 0) {
import java.util.Collection;  
import java.util.concurrent.Executor;
 * SPDX-License-Identifier: Apache-2.0
            }  
            if (e.getCause() instanceof RuntimeException) {
     * local directory, while also copying the segments _to_ another remote directory.  
package org.opensearch.index.store;
        Directory source,
import org.apache.logging.log4j.Logger;
    }  
import org.opensearch.core.action.ActionListener;  
            listener.get();  
                } catch (Exception e) {  
 * pool size and recovery settings.  
        Collection<String> toDownloadSegments,
        Directory destination,
        final long partSize = recoverySettings.getRemoteStoreParallelDownloadPartSize().getBytes();
    ) {  
     * Wraps a {@link RemoteSegmentStoreDirectory} source so that files larger than one part are opened as
                return remoteSource.openParallelInput(name, fileLength, context, partSize, executor, permits);  
    ) {
    /**
                }
                        onFileCompletion.run();
                        logger.trace("Downloaded file {} of size {}", file, destination.fileLength(file));  
        };
        final RemoteSegmentStoreDirectory remoteSource = (RemoteSegmentStoreDirectory) source;
    }  
            toDownloadSegments.size(),
                    return;
    ) {
import org.opensearch.common.logging.Loggers;
        CancellableThreads cancellableThreads,  
        Directory destination,  
                try {  
        // - "indices.recovery.max_concurrent_remote_store_streams" setting  
/*  
import org.opensearch.threadpool.ThreadPool;  
        } catch (InterruptedException e) {
                    return in.openInput(name, context);  
        logger.trace("Starting download of {} files with {} threads", queue.size(), threads);
     *                         different threads.
        final Queue<String> queue = new ConcurrentLinkedQueue<>(toDownloadSegments);
        final ParallelDownloadPermits permits = recoverySettings.getRemoteStoreParallelDownloadPermits();  
        final Directory parallelSource = wrapForParallelPartDownload(source);  
                    });
import org.apache.lucene.store.IndexInput;
            // If the blocking call on the PlainActionFuture itself is interrupted, then we must  
 * Helper class to downloads files from a {@link RemoteSegmentStoreDirectory}
                throw (RuntimeException) e.getCause();  
        Directory destination,
     * encryption wrapper layered on it) is left untouched. Small files, non remote-store sources and a disabled
        } else {  
        }
    private final RecoverySettings recoverySettings;
 */  
        Directory source,
     *                         Must be thread safe as this may be invoked concurrently from
import org.opensearch.core.index.shard.ShardId;
                if (fileLength <= partSize) {
        Directory source,
                throw (IOException) e.getCause();
    }
    public RemoteStoreFileDownloader(ShardId shardId, ThreadPool threadPool, RecoverySettings recoverySettings) {
     * @param secondDestination The second remote directory that segment files are  
                        if (secondDestination != null) {
                logger.trace("Downloading file {} of size {} in parts of {} bytes", name, fileLength, partSize);
import java.util.Queue;
        CancellableThreads cancellableThreads,  
    public void download(
import org.opensearch.common.annotation.PublicApi;  
                    cancellableThreads.executeIO(() -> {
        this.logger = Loggers.getLogger(RemoteStoreFileDownloader.class, shardId);
                        }
    private void downloadInternal(
import org.opensearch.indices.recovery.RecoverySettings;
 *
        }
import org.opensearch.common.Nullable;
            });
@PublicApi(since = "2.11.0")
                    queue.clear();
            cancellableThreads.cancel(e.getMessage());
        Runnable onFileCompletion,
     * Copies the given segments from the remote segment store to the given
     * @param listener Callback listener to be notified upon completion
import org.opensearch.action.support.PlainActionFuture;
                }
import org.opensearch.common.util.CancellableThreads;
        final PlainActionFuture<Void> listener = PlainActionFuture.newFuture();  
