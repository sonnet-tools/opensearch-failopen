                    try {
     * IndexInput.
            if (isClosed.get()) {
                // way the reference count has been incremented by one. We can only
                        // already in the cache and ready to be used (open)
    /**
                    "Local file cache capacity ("
        }
            if (isStarted.getAndSet(true) == false) {
                try (
                ) {
import java.io.IOException;
                    throw (RuntimeException) e.getCause();
            }
import java.io.OutputStream;
     * class is thread safe, and concurrent calls to {@link #getIndexInput()} will
                }, executor).handle((indexInput, throwable) -> {
     * @return future of IndexInput augmented with internal caching maintenance tasks
        @Override
                }
                    }
                    }
        public void close() throws Exception {
    private static FileCachedIndexInput createIndexInput(FileCache fileCache, StreamReader streamReader, BlobFetchRequest request) {
     * Note: Scripted queries/aggs may trigger a blob fetch within a new security context.
            return result;
        } catch (IOException e) {
                fileCache.decRef(key);
     * @param blobFetchRequest to fetch
import org.apache.logging.log4j.Logger;
            } catch (CompletionException e) {
            this.fileCache = fileCache;
 */
 * compatible open source license.
                        // catch block above, so we must not decRef here.
                    // Doesn't exist or is closed, either way create a new one
            if (e instanceof IOException) {
                    for (BlobFetchRequest.BlobPart blobPart : request.blobParts()) {
        private DelayedCreationCachedIndexInput(FileCache fileCache, StreamReader streamReader, BlobFetchRequest request) {
    @SuppressWarnings("removal")
                }
        }
                            indexInput.close();
                        } catch (IOException e) {
/*
        @Override
            if (isClosed.getAndSet(true) == false) {
                // Decreasing the extra ref count introduced by compute
    private final ThreadPool threadPool;
                            logger.warn("Error closing IndexInput", e);
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.CompletionException;
     * result in blocking until the initial thread completes the creation of the
            // If we find available capacity is exceeded, deny further BlobFetchRequests.
                        + ") - BlobFetchRequest failed: "
                // We're the first one here, need to download the block
                        logger.trace("Transfer Manager - Already in cache");
                    fileCache.remove(request.getFilePath());
                throw new IOException(
    }
 * This acts as entry point to fetch {@link BlobFetchRequest} and return actual {@link IndexInput}. Utilizes the BlobContainer interface to
                    result.complete(createIndexInput(fileCache, streamReader, request));
            } catch (Exception exception) {
                // Cache entry was either retrieved from the cache or newly added, either
        private final FileCache fileCache;
                // decrement this reference _after_ creating the clone to be returned.
}
                );
import java.util.concurrent.Executor;
                            );
        } catch (Exception e) {
import org.apache.lucene.store.IndexInput;
            // Cache entry was either retrieved from the cache or newly added, either
import org.opensearch.common.annotation.ExperimentalApi;
     *
        @Override
import org.opensearch.index.store.remote.filecache.FileCache;
        logger.trace("Asynchronous fetchBlob called for {}", key.toString());
     */
            return new FileCachedIndexInput(fileCache, request.getFilePath(), luceneIndexInput);
                if (e.getCause() instanceof UncheckedIOException) {
import java.util.concurrent.CompletableFuture;
                        fileCache.remove(request.getFilePath());
 * read snapshot files located within a repository. This basically adapts BlobContainer snapshots files into IndexInput
        logger.trace("fetchBlob called for {}", key.toString());
                } catch (Exception e) {
                CachedIndexInput cacheEntry = fileCache.compute(key, (path, cachedIndexInput) -> {
                    } else {
                fileCache.decRef(request.getFilePath());
                    OutputStream fileOutputStream = Files.newOutputStream(request.getFilePath());
            try {
                    return null;
import org.opensearch.index.store.remote.filecache.FileCachedIndexInput;
     * fileCache.compute() as inserting into the local fileCache may trigger an eviction.
                            snapshotFileInputStream.transferTo(localFileOutputStream);
import org.apache.logging.log4j.LogManager;
 * this file be licensed under the Apache-2.0 license or a
                    if (throwable != null) {
        }
     *
        public IndexInput getIndexInput() throws IOException {
            }
                return result.join();
package org.opensearch.index.store.remote.utils;
            throw (RuntimeException) cause;
    @ExperimentalApi
                            InputStream snapshotFileInputStream = streamReader.read(
                        ) {
                // Create new future and set it as the result
                                blobPart.getPosition(),
                    return new DelayedCreationCachedIndexInput(fileCache, streamReader, blobFetchRequest);
        private final StreamReader streamReader;
    private static class DelayedCreationCachedIndexInput implements CachedIndexInput {
                } finally {
public class TransferManager {
        @Override
        final Path key = blobFetchRequest.getFilePath();
                });
        this.streamReader = streamReader;
                try {
                fileCache.prune();
            if (fileCache.capacity() < fileCache.usage()) {
     * As such the following operations require elevated permissions.
                                blobPart.getBlobName(),
            }
    public interface StreamReader {
                    }
                    } catch (Exception e) {
        final Path key = blobFetchRequest.getFilePath();
                        + fileCache.usage()
                });
        } catch (Exception cause) {
                    // already in the cache and ready to be used (open)
            });
            // way the reference count has been incremented by one. We can only
                    if (indexInput != null) {
        }
            this.streamReader = streamReader;
        private final AtomicBoolean isClosed = new AtomicBoolean(false);
    }
            return AccessController.doPrivilegedChecked(() -> {
                        return createIndexInput(fileCache, streamReader, request);
    public CompletableFuture<IndexInput> fetchBlobAsync(BlobFetchRequest blobFetchRequest) throws IOException {
                throw new AlreadyClosedException("Already closed");
            } else {
                throw exception;
            }
                    return cachedIndexInput;
            } else if (e instanceof RuntimeException) {
            CachedIndexInput cacheEntry = fileCache.compute(key, (path, cachedIndexInput) -> {
                        return new DelayedCreationCachedIndexInput(fileCache, streamReader, blobFetchRequest);
                        Throwable cause = (throwable instanceof CompletionException && throwable.getCause() != null)
    public TransferManager(final StreamReader streamReader, final FileCache fileCache, ThreadPool threadPool) {
                throw (IOException) e;
                if (cachedIndexInput == null || cachedIndexInput.isClosed()) {
                    OutputStream localFileOutputStream = new BufferedOutputStream(fileOutputStream)
     * cacheEntry.getIndexInput() downloads new blobs from the remote store to local fileCache.
        private final AtomicBoolean isStarted = new AtomicBoolean(false);
                        + ") exceeded ("
    private final FileCache fileCache;
import java.io.InputStream;
     * Implementation of CachedIndexInput the defers creation of the underlying
        public long length() {
                });
            }
                    logger.trace("Transfer Manager - IndexInput closed or not in cache");
                throw e;
        try {
                throw new IOException(e);
            throw new UncheckedIOException(e);
            }
        }
                        throw (e instanceof RuntimeException) ? (RuntimeException) e : new CompletionException(e);
            logger.error("Exception while asynchronous fetching blob key:{}, Exception {}", key, cause.getMessage());
                            ? throwable.getCause()
     */
                }
            if (isStarted.getAndSet(true) == false) {
import org.apache.lucene.store.AlreadyClosedException;
        }
                            : throwable;
        private final CompletableFuture<IndexInput> result = new CompletableFuture<>();
        InputStream read(String name, long position, long length) throws IOException;
                    } else {
import java.util.concurrent.atomic.AtomicBoolean;
    private static final Logger logger = LogManager.getLogger(TransferManager.class);
import java.nio.file.Files;
        private final BlobFetchRequest request;
     *
        try {
     * IndexInput until the first invocation of {@link #getIndexInput()}. This
                        + request.getFilePath()
    @FunctionalInterface
     * Given a blobFetchRequestList, return it's corresponding IndexInput.
                        }
    /**
                } else {
 * @opensearch.internal
            if (Files.exists(request.getFilePath()) == false) {
                fileCache.decRef(request.getFilePath());
        @ExperimentalApi
    }
                try {
                    result.completeExceptionally(e);
    }
            return isClosed.get();
                    if (cachedIndexInput == null || cachedIndexInput.isClosed()) {
            if (isClosed.get()) {
                        result.completeExceptionally(cause);
                throw (RuntimeException) e;
        try {
            }
                                blobPart.getLength()
            return request.getBlobLength();
                    }
                        fileCache.decRef(request.getFilePath());
        }
import org.opensearch.secure_sm.AccessController;
                    }
                } else if (e.getCause() instanceof RuntimeException) {
                        }
 */
                CompletableFuture.supplyAsync(() -> {
                result.whenComplete((indexInput, error) -> {
        public boolean isClosed() {
            // decrement this reference _after_ creating the clone to be returned.
            try {
        }
                return cacheEntry.asyncLoadIndexInput(threadPool.executor(ThreadPool.Names.REMOTE_RECOVERY));
                    fileCache.decRef(key);
                        logger.trace("Transfer Manager - IndexInput closed or not in cache");
                        + fileCache.capacity()
        this.fileCache = fileCache;
            }
                return CompletableFuture.failedFuture(new AlreadyClosedException("Already closed"));
import java.io.UncheckedIOException;
                }
                        // Doesn't exist or is closed, either way create a new one
     * Functional interface to get an InputStream for a file at a certain offset and size
            }
            this.request = request;
                        // On failure, the entry was already removed from the cache in the
     */
            }
 * The OpenSearch Contributors require contributions made to
    }
            // This local file cache is ref counted and may not strictly enforce configured capacity.
    public IndexInput fetchBlob(BlobFetchRequest blobFetchRequest) throws IOException {
        }
                        try (
import org.opensearch.threadpool.ThreadPool;
                }
    private final StreamReader streamReader;
import java.nio.file.Path;
            });
                logger.trace("Fetching from Remote in createIndexInput of Transfer Manager");
                    return cacheEntry.getIndexInput().clone();
 *
        this.threadPool = threadPool;
                    throw ((UncheckedIOException) e.getCause()).getCause();
            // Making sure remote recovery thread-pool take care of background download
 *
    }
                    logger.trace("Transfer Manager - Required blob Already in cache: {}", blobFetchRequest.toString());
import org.apache.lucene.store.IOContext;
import java.io.BufferedOutputStream;
/**
            } else {
                        result.complete(indexInput);
                        try {
        public CompletableFuture<IndexInput> asyncLoadIndexInput(Executor executor) {
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
                        return cachedIndexInput;
            final IndexInput luceneIndexInput = request.getDirectory().openInput(request.getFileName(), IOContext.DEFAULT);
    /**
