            } catch (IOException | UncheckedIOException e) {
     * Given a file path, remove the file from cache.
    public FileCache(SegmentedCache<Path, CachedIndexInput> cache, CircuitBreaker circuitBreaker) {
    @Override
                    if (Files.isDirectory(path)) {  
            invokeAll(subTasks);
    public FileCache(SegmentedCache<Path, CachedIndexInput> theCache) {  
    }
        final RefCountedCacheStats blockFileCacheStats = stats.getBlockFileCacheStats();  
                FileCacheStatsType.PINNED_FILE_STATS
                        }
        final RefCountedCacheStats pinnedFileCacheStats = stats.getPinnedFileCacheStats();
            } catch (IOException e) {  
import java.util.function.BiFunction;
    /**  
    @Override  
                        try (DirectoryStream<Path> indexStream = Files.newDirectoryStream(path)) {
     * Unpins the key in the cache, allowing it to be evicted.
     */
                    } else {  
    public void remove(final Path filePath) {
package org.opensearch.index.store.remote.filecache;
                blockFileCacheStats.evictionWeight(),
            this.path = path;
    }
    private final SegmentedCache<Path, CachedIndexInput> theCache;  
    public long capacity() {
        return theCache.get(filePath);
import java.util.stream.Stream;  
    }
}
                pinnedFileCacheStats.removeWeight(),
                try {  
                throw new UncheckedIOException("Unable to retrieve cache file details. Please clear the file cache for node startup.", e);
    public void decRef(Path key) {
        theCache.incRef(key);  
                return;  
    @Override  
                                        subTasks.add(new LoadTask(indexSubPath, fc, exception, true));
        }
    public Integer getRef(Path key) {
            }  
                            for (Path indexPath : indexStream) {
        private final long length;
                FileCacheStatsType.FULL_FILE_STATS  
        ).flatMap(dir -> {  
@PublicApi(since = "2.7.0")  
                fullFileCacheStats.evictionWeight(),
     */
                        exception.set((UncheckedIOException) e);
                fullFileCacheStats.hitCount(),
    @Override  
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.env.NodeEnvironment.processDirectoryFiles;
            ),  
 *  
                overallCacheStats.pinnedUsage(),
        return theCache.activeUsage();
import java.util.ArrayList;
 * this file be licensed under the Apache-2.0 license or a
    public long prune(Predicate<Path> keyPredicate) {  
     * @param key  
    }  
    public CachedIndexInput compute(  
        }
        @Override
                .filter(Files::isDirectory)
        return theCache.stats();
public class FileCache implements RefCountedCache<Path, CachedIndexInput> {
    }
     * blocks at this point, so we store this placeholder object in the cache.  
    }
 *
import java.util.concurrent.RecursiveAction;  
     *
    @Override
        logger.trace("CURRENT STATE OF FILE CACHE \n");
     * Returns the current {@link AggregateFileCacheStats}
        long cacheUsage = theCache.usage();
            List<LoadTask> subTasks = new ArrayList<>();
 * <p>Once file cache reaches its capacity, it starts evictions. Eviction removes the file  
                capacity(),  
     */  
    }
                .filter(Files::isDirectory),
                pinnedFileCacheStats.activeUsage(),
import org.opensearch.index.store.remote.utils.cache.stats.IRefCountedCacheStats;
     * Even if the file is pinned or it's still in use, the reclaim  
        public LoadTask(Path path, FileCache fc, SetOnce<UncheckedIOException> exception) {  
     *
                }
     */
            ),
        theCache.decRef(key);
                fullFileCacheStats.removeWeight(),  
     */  
    /**
     * Restores the file cache instance performing a folder scan of the
                capacity(),
 * of a given file (since it makes it the most recently used).
 */
        }  
 * <p>The two main interfaces of FC are put and get. When a new file index input is added  
    @Override
                blockFileCacheStats.removeWeight(),
import org.opensearch.common.annotation.PublicApi;
        });
                capacity(),
    }  
                FileCacheStatsType.OVER_ALL_STATS
    @Override
    }
                overallCacheStats.activeUsage(),
            )
 *
        @Override
        return cachedIndexInput;
     */
        Stream.concat(  
        theCache.remove(filePath);  
    public static class RestoredCachedIndexInput implements CachedIndexInput {  
     * This API also updates the priority for the given file
import java.util.List;
 *
import java.io.UncheckedIOException;  
/**  
     * @param filePath given file path  
                } catch (SetOnce.AlreadySetException ignore) {  
    }  
    public long activeUsage() {
        return theCache.prune(keyPredicate);
    /**
        CachedIndexInput cachedIndexInput = theCache.compute(key, remappingFunction);
        theCache.clear();
        @Override
    public void logCurrentState() {  
import java.io.IOException;
                fullFileCacheStats.usage(),  
    }  
                capacity(),  
                                }  
    public static class LoadTask extends RecursiveAction {  
     * @deprecated Use {@link FileCache(SegmentedCache<Path, CachedIndexInput>)}. CircuitBreaker parameter is not used.
                } else {
 * <p> The get function does not add file to cache, but it promotes the priority  
import org.opensearch.index.store.remote.utils.cache.stats.RefCountedCacheStats;  
 * the entire dataset on remote store. It maintains a node level view of index files with priorities,
import org.opensearch.index.store.remote.utils.cache.RefCountedCache;
    @Override
                return Files.list(dir);
    }
 * (Least Recently Used) in the FC is replaced first.
        final RefCountedCacheStats overallCacheStats = stats.getOverallCacheStats();
    @Override
     */  
     * still take effect.
        }
 * caching only those index files needed by queries. The file with the lowest priority  
import java.nio.file.Path;  
    }
                overallCacheStats.hitCount(),
        theCache.logCurrentState();
        return theCache.capacity();
                                    processDirectoryFiles(indexPath, indexSubPaths);
    public void restoreFromDirectory(List<Path> fileCacheDataPaths) {
     * Uses fork-join parallelism to efficiently scan directories and restore cached files.
            return true;
        theCache.closeIndexInputReferences();  
     *
import static org.opensearch.index.store.remote.utils.FileTypeUtils.INDICES_FOLDER_IDENTIFIER;
                    }  
     * Pins the key in the cache, preventing it from being evicted.  
import java.nio.file.DirectoryStream;
     * Placeholder for the existing file blocks that are in the disk-based
                .map(path -> path.resolve(LOCAL_STORE_LOCATION))  
                fullFileCacheStats.activeUsage(),
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
        public void compute() {  
    public void pin(Path key) {
            try {
    private final CircuitBreaker circuitBreaker = null;
    public void incRef(Path key) {
    @Override  
    @Override
    }  
     */
        return theCache.pinnedUsage();  
     */  
/*  
            this.processedDirectory = processedDirectory;
        private final boolean processedDirectory;  
        return cachedIndexInput;
                pinnedFileCacheStats.evictionWeight(),  
            System.currentTimeMillis(),  
            this.fc = fc;  
    @Override  
 * to the file cache, the file will be added at cache head, which means it has the highest
    public long size() {  
            } catch (IOException e) {
 * compatible open source license.
            this.length = length;
    @Deprecated(forRemoval = true)
            new FileCacheStats(
        return new AggregateFileCacheStats(
    /**
import org.apache.logging.log4j.Logger;
                .filter(Files::isDirectory)  
                                    for (Path indexSubPath : indexSubPaths) {  
     * @return the combined pinned weight of the values in this cache.
    /**
import java.nio.file.Files;
    public void unpin(Path key) {  
            }
            this.exception = exception;  
        logger.trace("Total Usage: " + cacheUsage + " , Active Usage: " + theCache.activeUsage());  
                if (processedDirectory) {  
        @Override  
        public IndexInput getIndexInput() {
        }
     * them they will be deleted when the disk-based local cache fills up.
    }
 * cleanup process also includes closing file’s descriptor.
        theCache.pin(key);  
    }  
     * {@link org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory#LOCAL_STORE_LOCATION}
        public LoadTask(Path path, FileCache fc, SetOnce<UncheckedIOException> exception, boolean processedDirectory) {
        public void close() throws Exception {}
                                    }
            new FileCacheStats(
    @Override
                                if (Files.isDirectory(indexPath)) {  
        return theCache.prune();
        CachedIndexInput cachedIndexInput = theCache.put(filePath, indexInput);
                FileCacheStatsType.BLOCK_FILE_STATS
    public IRefCountedCacheStats stats() {
            try {
 * priority.
    @Override
     * @param key
            this.processedDirectory = false;
     * These entries are eligible for eviction so if nothing needs to reference  
        final AggregateRefCountedCacheStats stats = (AggregateRefCountedCacheStats) stats();
                decRef(path.toAbsolutePath());  
        BiFunction<? super Path, ? super CachedIndexInput, ? extends CachedIndexInput> remappingFunction
    public void clear() {
    }  
                blockFileCacheStats.missCount(),
            this.exception = exception;
    }
                .filter(Files::isDirectory)
    public CachedIndexInput put(Path filePath, CachedIndexInput indexInput) {  
import java.util.function.Predicate;
import org.opensearch.common.SetOnce;
    // To be used only for debugging purposes
        public long length() {
        private final FileCache fc;
                blockFileCacheStats.activeUsage(),  
     *
     * @param filePath given file path  
    }  
    /**
 * File Cache (FC) is introduced to solve the problem that the local disk cannot hold
import org.opensearch.core.common.breaker.CircuitBreaker;  
    }
     * Returns the pinned usage of this cache.  
                            }
                .map(path -> path.resolve(INDICES_FOLDER_IDENTIFIER))
import org.apache.logging.log4j.LogManager;
            new FileCacheStats(
    @Override
                                    List<Path> indexSubPaths = new ArrayList<>();
                blockFileCacheStats.usage(),
        return theCache.getRef(key);  
        return theCache.size();
    }
import org.apache.lucene.store.IndexInput;  
                    }
    /**  
    /**
        }  
     * local cache at node startup time. We can't open a file handle to these
    public CachedIndexInput get(Path filePath) {  
    }
    public long prune() {
    ) {  
        this(cache);  
            this.path = path;
 */  
    }
        @Override
    public long usage() {
            fileCacheDataPaths.stream()
            return length;
                pinnedFileCacheStats.usage(),
 * items from cache tail and triggers a callback to clean up the file from disk. The
            ),
 * The OpenSearch Contributors require contributions made to  
    public AggregateFileCacheStats fileCacheStats() {
        public boolean isClosed() {  
     * Given a file path, gets the corresponding file index input from FileCache.  
                overallCacheStats.missCount(),  
                overallCacheStats.removeWeight(),
     * If a block is needed, then these entries will be replaced with a proper
     * directory within the provided file cache path.  
            new FileCacheStats(  
                }
        this.theCache = theCache;
        private final SetOnce<UncheckedIOException> exception;
        theCache.unpin(key);
    public long pinnedUsage() {
                overallCacheStats.evictionWeight(),  
 * @opensearch.api
    /**  
        }).filter(Files::isRegularFile).forEach(path -> {  
                    this.fc.restoreFromDirectory(List.of(path));
        private final Path path;
        Path key,
            this.fc = fc;
     * A recursive task for loading file cache entries from disk during node startup.  
                blockFileCacheStats.hitCount(),  
     */
    // To be used only in testing framework.
    }
        public RestoredCachedIndexInput(long length) {  
            fileCacheDataPaths.stream()
        }  
        final RefCountedCacheStats fullFileCacheStats = stats.getFullFileCacheStats();
                overallCacheStats.usage(),
     * @return corresponding file index input from FileCache.
                put(path.toAbsolutePath(), new RestoredCachedIndexInput(Files.size(path)));
                fullFileCacheStats.missCount(),
import static org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION;  
                blockFileCacheStats.pinnedUsage(),  
            throw new UnsupportedOperationException();  
        return theCache.usage();  
            }
    private static final Logger logger = LogManager.getLogger(FileCache.class);
                pinnedFileCacheStats.pinnedUsage(),
            try {
     * entry that will open the actual file handle to create the IndexInput.
    }
import org.opensearch.index.store.remote.utils.cache.stats.AggregateRefCountedCacheStats;
                        exception.set(new UncheckedIOException("Unable to process directories.", (IOException) e));
     *
                    if (e instanceof UncheckedIOException) {
                fullFileCacheStats.pinnedUsage(),
                pinnedFileCacheStats.hitCount(),
        );  
    }  
                throw new UncheckedIOException("Unable to process file cache directory. Please clear the file cache for node startup.", e);
import org.opensearch.index.store.remote.utils.cache.SegmentedCache;  
                pinnedFileCacheStats.missCount(),  
    /**
    public void closeIndexInputReferences() {
