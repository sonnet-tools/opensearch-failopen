                throw (RuntimeException) e.getCause();
            return source;
        }
            public IndexInput openInput(String name, IOContext context) throws IOException {
     * {@link ParallelPartInputStream}s: the bytes are fetched as multiple concurrent byte-range requests but are
     * budget fall through to the plain single-stream {@link Directory#openInput}.
            });
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.action.support.GroupedActionListener;
    /**
     *                         different threads.
            copyOneFile(cancellableThreads, parallelSource, destination, secondDestination, queue, onFileCompletion, allFilesListener);
        Directory source,
                }
     * @param toDownloadSegments The list of segment files to download
                try {
    ) throws InterruptedException, IOException {
                    // Clear the queue to stop any future processing, report the failure, then return
    }
        };
        Directory destination,
     * Wraps a {@link RemoteSegmentStoreDirectory} source so that files larger than one part are opened as
    ) {
import org.opensearch.common.Nullable;
            @Override
        Runnable onFileCompletion,
        Directory source,
        final CancellableThreads cancellableThreads = new CancellableThreads();
                        destination.copyFrom(source, file, file, IOContext.DEFAULT);
        final RemoteSegmentStoreDirectory remoteSource = (RemoteSegmentStoreDirectory) source;
}
     *                         Must be thread safe as this may be invoked concurrently from
                    listener.onFailure(e);
     * Copies the given segments from the remote segment store to the given
                    return;
import java.util.Queue;
        }
            listener.get();
        CancellableThreads cancellableThreads,
            threadPool.executor(ThreadPool.Names.REMOTE_RECOVERY).submit(() -> {
     * @param listener Callback listener to be notified upon completion
    private void downloadInternal(
        final int threads = Math.min(
            cancellableThreads.cancel(e.getMessage());
                throw (IOException) e.getCause();
        Runnable onFileCompletion
    private final Logger logger;
import org.opensearch.common.annotation.PublicApi;
     */
        Collection<String> toDownloadSegments,
    public RemoteStoreFileDownloader(ShardId shardId, ThreadPool threadPool, RecoverySettings recoverySettings) {
        logger.trace("Starting download of {} files with {} threads", queue.size(), threads);
                        logger.trace("Downloaded file {} of size {}", file, destination.fileLength(file));
                }
        this.threadPool = threadPool;
    ) {
     * @param destination The local directory to copy segment files to
     * @param destination The local directory to copy segment files to
        // - number of files to download
        final Directory parallelSource = wrapForParallelPartDownload(source);
/**
        Directory source,
@PublicApi(since = "2.11.0")
    }
        Directory source,
        } catch (ExecutionException e) {
        Directory secondDestination,
        return new FilterDirectory(source) {
    private void copyOneFile(
     * @param onFileCompletion A generic runnable that is invoked after each file download.
    }
            toDownloadSegments.size(),
                    });
     */
            return source;
 * Helper class to downloads files from a {@link RemoteSegmentStoreDirectory}
        final PlainActionFuture<Void> listener = PlainActionFuture.newFuture();
        final ParallelDownloadPermits permits = recoverySettings.getRemoteStoreParallelDownloadPermits();
        // - "indices.recovery.max_concurrent_remote_store_streams" setting
                return remoteSource.openParallelInput(name, fileLength, context, partSize, executor, permits);
            if (e.getCause() instanceof RuntimeException) {
        if (source instanceof RemoteSegmentStoreDirectory == false) {
        ActionListener<Void> listener
import java.io.IOException;
     * @param source The remote directory to copy segment files from
        CancellableThreads cancellableThreads,
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.store.Directory;
            // If the blocking call on the PlainActionFuture itself is interrupted, then we must
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionListener;
                logger.trace("Downloading file {}", file);
import org.apache.lucene.store.FilterDirectory;
        downloadInternal(cancellableThreads, source, destination, null, toDownloadSegments, () -> {}, listener);
     * Copies the given segments from the remote segment store to the given
        // Choose the minimum of:
 */
import org.opensearch.common.util.CancellableThreads;
import java.util.concurrent.Executor;
    }
import org.opensearch.indices.recovery.RecoverySettings;
 * @opensearch.api
 * instance to a local {@link Directory} instance in parallel depending on thread
        Directory destination,
                final long fileLength = in.fileLength(name);
        Directory destination,
        this.logger = Loggers.getLogger(RemoteStoreFileDownloader.class, shardId);
        CancellableThreads cancellableThreads,
                            secondDestination.copyFrom(destination, file, file, IOContext.DEFAULT);
     * local directory.
                if (fileLength <= partSize) {
import java.util.concurrent.ConcurrentLinkedQueue;
            Thread.currentThread().interrupt();
                        onFileCompletion.run();
 *
 * compatible open source license.
            }
            // cancel the asynchronous work we were waiting on
            listener.onResponse(null);
        );
package org.opensearch.index.store;
            }
        }
    private final RecoverySettings recoverySettings;
        }
                        if (secondDestination != null) {
import org.opensearch.action.support.PlainActionFuture;
     * @param source The remote directory to copy segment files from
import org.apache.logging.log4j.Logger;
import java.util.Collection;
import org.apache.lucene.store.IndexInput;
        final Queue<String> queue = new ConcurrentLinkedQueue<>(toDownloadSegments);
     *                          copied to after being copied to the local directory
import org.apache.lucene.store.IOContext;
        Collection<String> toDownloadSegments,
public final class RemoteStoreFileDownloader {
        for (int i = 0; i < threads; i++) {
                    return in.openInput(name, context);
        final ActionListener<Void> allFilesListener = new GroupedActionListener<>(ActionListener.map(listener, r -> null), threads);
import java.util.concurrent.ExecutionException;
        final Executor executor = threadPool.executor(ThreadPool.Names.REMOTE_RECOVERY);
     * still presented sequentially, so the regular {@link Directory#copyFrom} path (and every stats, checksum and
    private Directory wrapForParallelPartDownload(Directory source) {
        // - max thread pool size
/*
        final String file = queue.poll();
                copyOneFile(cancellableThreads, source, destination, secondDestination, queue, onFileCompletion, listener);
    }
        @Nullable Directory secondDestination,
    ) {
     */
        ActionListener<Void> listener
        try {
                } catch (Exception e) {
    /**
        } else {
                logger.trace("Downloading file {} of size {} in parts of {} bytes", name, fileLength, partSize);
        @Nullable Directory secondDestination,
import org.opensearch.common.logging.Loggers;
    public void download(
        }
                    queue.clear();
        downloadInternal(cancellableThreads, source, destination, secondDestination, toDownloadSegments, onFileCompletion, listener);
        if (permits.getMaxPermits() <= 0) {
                    cancellableThreads.executeIO(() -> {
    public void downloadAsync(
 * SPDX-License-Identifier: Apache-2.0
        Queue<String> queue,
 *
    private final ThreadPool threadPool;
        if (file == null) {
        Runnable onFileCompletion,
    /**
     * @param toDownloadSegments The list of segment files to download
            } else if (e.getCause() instanceof IOException) {
            throw new RuntimeException(e);
     * encryption wrapper layered on it) is left untouched. Small files, non remote-store sources and a disabled
     * @param secondDestination The second remote directory that segment files are
import org.opensearch.threadpool.ThreadPool;
        ActionListener<Void> listener
        Collection<String> toDownloadSegments,
    }
 * pool size and recovery settings.
     * local directory, while also copying the segments _to_ another remote directory.
            // Queue is empty, so notify listener we are done
        Directory destination,
        } catch (InterruptedException e) {
        this.recoverySettings = recoverySettings;
            Math.min(threadPool.info(ThreadPool.Names.REMOTE_RECOVERY).getMax(), recoverySettings.getMaxConcurrentRemoteStoreStreams())
 */
        final long partSize = recoverySettings.getRemoteStoreParallelDownloadPartSize().getBytes();
            throw e;
                        }
