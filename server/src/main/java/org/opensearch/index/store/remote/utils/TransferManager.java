        } catch (Exception e) {
                        return createIndexInput(fileCache, streamReader, request);
     * Functional interface to get an InputStream for a file at a certain offset and size
                        return cachedIndexInput;
            // way the reference count has been incremented by one. We can only  
                try (
/*  
            }  
                            InputStream snapshotFileInputStream = streamReader.read(
import org.opensearch.index.store.remote.filecache.FileCache;
                        fileCache.remove(request.getFilePath());
import java.io.InputStream;  
                                blobPart.getPosition(),
            } else {
    private static FileCachedIndexInput createIndexInput(FileCache fileCache, StreamReader streamReader, BlobFetchRequest request) {  
     *  
     * fileCache.compute() as inserting into the local fileCache may trigger an eviction.
        @ExperimentalApi
            // This local file cache is ref counted and may not strictly enforce configured capacity.
                throw new IOException(e);
                }, executor).handle((indexInput, throwable) -> {
import java.io.OutputStream;
                // Create new future and set it as the result
     *  
                if (cachedIndexInput == null || cachedIndexInput.isClosed()) {
                if (e.getCause() instanceof UncheckedIOException) {
import org.opensearch.common.annotation.ExperimentalApi;  
import java.util.concurrent.Executor;
import java.nio.file.Files;  
                ) {
    private static class DelayedCreationCachedIndexInput implements CachedIndexInput {  
     * Given a blobFetchRequestList, return it's corresponding IndexInput.
                } else {
 * read snapshot files located within a repository. This basically adapts BlobContainer snapshots files into IndexInput  
                }
            throw (RuntimeException) cause;
            if (isStarted.getAndSet(true) == false) {
            this.streamReader = streamReader;
        } catch (IOException e) {  
                        // catch block above, so we must not decRef here.
                        try (
                }  
                    }
                        }  
            }  
                        // Doesn't exist or is closed, either way create a new one
            } catch (Exception exception) {
    private final ThreadPool threadPool;
                } finally {
        private final FileCache fileCache;
            } else if (e instanceof RuntimeException) {
                    if (cachedIndexInput == null || cachedIndexInput.isClosed()) {  
        private DelayedCreationCachedIndexInput(FileCache fileCache, StreamReader streamReader, BlobFetchRequest request) {
     * result in blocking until the initial thread completes the creation of the  
                        logger.trace("Transfer Manager - Already in cache");
import java.io.BufferedOutputStream;
        private final AtomicBoolean isClosed = new AtomicBoolean(false);  
                        }
        logger.trace("Asynchronous fetchBlob called for {}", key.toString());
                // way the reference count has been incremented by one. We can only  
            final IndexInput luceneIndexInput = request.getDirectory().openInput(request.getFileName(), IOContext.DEFAULT);
 */  
            return isClosed.get();
                try {
                fileCache.decRef(request.getFilePath());
            logger.error("Exception while asynchronous fetching blob key:{}, Exception {}", key, cause.getMessage());
                        fileCache.decRef(request.getFilePath());
            return new FileCachedIndexInput(fileCache, request.getFilePath(), luceneIndexInput);
        private final CompletableFuture<IndexInput> result = new CompletableFuture<>();
import org.opensearch.secure_sm.AccessController;
                            logger.warn("Error closing IndexInput", e);
            if (e instanceof IOException) {  
import org.apache.logging.log4j.LogManager;
                    result.completeExceptionally(e);  
                    }  
            }  
    public CompletableFuture<IndexInput> fetchBlobAsync(BlobFetchRequest blobFetchRequest) throws IOException {
            if (isStarted.getAndSet(true) == false) {
        }  
     */  
package org.opensearch.index.store.remote.utils;
                            indexInput.close();
    /**
            }
 * @opensearch.internal
        } catch (Exception cause) {  
                    throw (RuntimeException) e.getCause();
}
                } else if (e.getCause() instanceof RuntimeException) {  
import org.apache.lucene.store.AlreadyClosedException;  
        private final BlobFetchRequest request;  
        InputStream read(String name, long position, long length) throws IOException;  
                );
                    // already in the cache and ready to be used (open)
        final Path key = blobFetchRequest.getFilePath();  
                        + ") - BlobFetchRequest failed: "
                                blobPart.getBlobName(),  
                        throw (e instanceof RuntimeException) ? (RuntimeException) e : new CompletionException(e);
                fileCache.prune();
import org.apache.lucene.store.IOContext;
        public CompletableFuture<IndexInput> asyncLoadIndexInput(Executor executor) {
                    }  
            }  
                        + fileCache.usage()
     * @return future of IndexInput augmented with internal caching maintenance tasks
     * As such the following operations require elevated permissions.
                });  
                result.whenComplete((indexInput, error) -> {
        }  
        }
                    return null;
                throw (IOException) e;
        try {
                    return new DelayedCreationCachedIndexInput(fileCache, streamReader, blobFetchRequest);
        logger.trace("fetchBlob called for {}", key.toString());
                return CompletableFuture.failedFuture(new AlreadyClosedException("Already closed"));
     * IndexInput until the first invocation of {@link #getIndexInput()}. This
            // decrement this reference _after_ creating the clone to be returned.
        }
        this.fileCache = fileCache;  
 * compatible open source license.
    }
    }
                // Decreasing the extra ref count introduced by compute
                });
 * SPDX-License-Identifier: Apache-2.0
                } catch (Exception e) {
        public boolean isClosed() {
                        ) {
                    logger.trace("Transfer Manager - Required blob Already in cache: {}", blobFetchRequest.toString());  
                        logger.trace("Transfer Manager - IndexInput closed or not in cache");
                    OutputStream fileOutputStream = Files.newOutputStream(request.getFilePath());  
    private static final Logger logger = LogManager.getLogger(TransferManager.class);
    }  
            });
        }
        @Override
        @Override
    public IndexInput fetchBlob(BlobFetchRequest blobFetchRequest) throws IOException {
                CompletableFuture.supplyAsync(() -> {  
            // Making sure remote recovery thread-pool take care of background download
        try {  
                    } catch (Exception e) {  
                }
        }  
        }
public class TransferManager {
                        Throwable cause = (throwable instanceof CompletionException && throwable.getCause() != null)
                    }
            return AccessController.doPrivilegedChecked(() -> {
     *  
            if (fileCache.capacity() < fileCache.usage()) {
            this.fileCache = fileCache;  
     * IndexInput.
     * cacheEntry.getIndexInput() downloads new blobs from the remote store to local fileCache.
                }
                        result.completeExceptionally(cause);
     * Note: Scripted queries/aggs may trigger a blob fetch within a new security context.
            try {  
    }
                        return new DelayedCreationCachedIndexInput(fileCache, streamReader, blobFetchRequest);  
            // Cache entry was either retrieved from the cache or newly added, either
        this.streamReader = streamReader;
        @Override
                    OutputStream localFileOutputStream = new BufferedOutputStream(fileOutputStream)
                throw exception;
            if (isClosed.get()) {  
        final Path key = blobFetchRequest.getFilePath();  
                                blobPart.getLength()
 *
                return cacheEntry.asyncLoadIndexInput(threadPool.executor(ThreadPool.Names.REMOTE_RECOVERY));
                    }  
        @Override  
            } else {  
import org.opensearch.threadpool.ThreadPool;
    /**
import org.apache.logging.log4j.Logger;
     */  
 *
                    fileCache.remove(request.getFilePath());
                        + ") exceeded ("  
import org.apache.lucene.store.IndexInput;
                return result.join();
import org.opensearch.index.store.remote.filecache.CachedIndexInput;
import java.util.concurrent.CompletableFuture;
                            : throwable;
                    if (throwable != null) {
            if (isClosed.getAndSet(true) == false) {
            if (isClosed.get()) {
                    } else {  
        }
                        // already in the cache and ready to be used (open)  
     * class is thread safe, and concurrent calls to {@link #getIndexInput()} will
                // We're the first one here, need to download the block
                logger.trace("Fetching from Remote in createIndexInput of Transfer Manager");
                // decrement this reference _after_ creating the clone to be returned.
                fileCache.decRef(request.getFilePath());
            return request.getBlobLength();  
                    "Local file cache capacity ("
    public interface StreamReader {
                    result.complete(createIndexInput(fileCache, streamReader, request));
                            ? throwable.getCause()  
            }
                    return cachedIndexInput;
            }
        try {
                throw e;  
    private final FileCache fileCache;
        this.threadPool = threadPool;
            CachedIndexInput cacheEntry = fileCache.compute(key, (path, cachedIndexInput) -> {  
        public long length() {
                fileCache.decRef(key);  
            try {
import java.io.UncheckedIOException;
 * The OpenSearch Contributors require contributions made to  
            throw new UncheckedIOException(e);
     * Implementation of CachedIndexInput the defers creation of the underlying  
        public void close() throws Exception {  
    }
import java.util.concurrent.atomic.AtomicBoolean;
                    return cacheEntry.getIndexInput().clone();  
                    // Doesn't exist or is closed, either way create a new one  
            } catch (CompletionException e) {  
                throw new AlreadyClosedException("Already closed");
            if (Files.exists(request.getFilePath()) == false) {  
    @ExperimentalApi
        }  
    private final StreamReader streamReader;  
 * this file be licensed under the Apache-2.0 license or a
                        result.complete(indexInput);
                        try {
import java.io.IOException;
 * This acts as entry point to fetch {@link BlobFetchRequest} and return actual {@link IndexInput}. Utilizes the BlobContainer interface to
                // Cache entry was either retrieved from the cache or newly added, either
     * @param blobFetchRequest to fetch
                        + fileCache.capacity()
                try {  
    @SuppressWarnings("removal")
    public TransferManager(final StreamReader streamReader, final FileCache fileCache, ThreadPool threadPool) {
            }  
                CachedIndexInput cacheEntry = fileCache.compute(key, (path, cachedIndexInput) -> {
                    if (indexInput != null) {  
                    try {
            }  
                    logger.trace("Transfer Manager - IndexInput closed or not in cache");
/**
                    for (BlobFetchRequest.BlobPart blobPart : request.blobParts()) {  
                        // On failure, the entry was already removed from the cache in the  
     */
            // If we find available capacity is exceeded, deny further BlobFetchRequests.  
                            );  
        private final AtomicBoolean isStarted = new AtomicBoolean(false);
 */  
                        + request.getFilePath()  
import java.util.concurrent.CompletionException;  
                    fileCache.decRef(key);
                    throw ((UncheckedIOException) e.getCause()).getCause();
            }
                        } catch (IOException e) {  
        private final StreamReader streamReader;
    @FunctionalInterface
        public IndexInput getIndexInput() throws IOException {  
                }  
            return result;
                throw (RuntimeException) e;  
import java.nio.file.Path;
import org.opensearch.index.store.remote.filecache.FileCachedIndexInput;  
                            snapshotFileInputStream.transferTo(localFileOutputStream);
                throw new IOException(  
                });
    }
            this.request = request;
            });
    /**
                    } else {
