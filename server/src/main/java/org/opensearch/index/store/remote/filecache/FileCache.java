/**
            new FileCacheStats(
                overallCacheStats.hitCount(),
        @Override
        logger.trace("CURRENT STATE OF FILE CACHE \n");
                pinnedFileCacheStats.removeWeight(),
    @Override
        logger.trace("Total Usage: " + cacheUsage + " , Active Usage: " + theCache.activeUsage());
     *
    @Override
        public IndexInput getIndexInput() {
                fullFileCacheStats.missCount(),
            try {
                overallCacheStats.activeUsage(),
 */
     * Even if the file is pinned or it's still in use, the reclaim
package org.opensearch.index.store.remote.filecache;
     */
                } else {
    private static final Logger logger = LogManager.getLogger(FileCache.class);
    public long prune(Predicate<Path> keyPredicate) {
        theCache.pin(key);
            this.fc = fc;
import org.apache.logging.log4j.Logger;
    /**
        return cachedIndexInput;
    }
import java.util.stream.Stream;
                capacity(),
        Path key,
 * <p>Once file cache reaches its capacity, it starts evictions. Eviction removes the file
    }
public class FileCache implements RefCountedCache<Path, CachedIndexInput> {
    @Override
     * @param filePath given file path
        public RestoredCachedIndexInput(long length) {
    /**
    }
     * Given a file path, remove the file from cache.
        final RefCountedCacheStats overallCacheStats = stats.getOverallCacheStats();
     * them they will be deleted when the disk-based local cache fills up.
                overallCacheStats.removeWeight(),
            } catch (IOException e) {
                .filter(Files::isDirectory),
    }
                blockFileCacheStats.activeUsage(),
                fullFileCacheStats.evictionWeight(),
                fullFileCacheStats.activeUsage(),
                blockFileCacheStats.removeWeight(),
    public long pinnedUsage() {
                fullFileCacheStats.hitCount(),
    public IRefCountedCacheStats stats() {
        return theCache.size();
        @Override
        public long length() {
            this.fc = fc;
            invokeAll(subTasks);
     *
 * File Cache (FC) is introduced to solve the problem that the local disk cannot hold
    public void remove(final Path filePath) {
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
        return cachedIndexInput;
                overallCacheStats.evictionWeight(),
        final RefCountedCacheStats fullFileCacheStats = stats.getFullFileCacheStats();
            )
    public void incRef(Path key) {
        long cacheUsage = theCache.usage();
            new FileCacheStats(
     * These entries are eligible for eviction so if nothing needs to reference
                throw new UncheckedIOException("Unable to retrieve cache file details. Please clear the file cache for node startup.", e);
                FileCacheStatsType.BLOCK_FILE_STATS
    public void logCurrentState() {
    }
                FileCacheStatsType.FULL_FILE_STATS
                                    for (Path indexSubPath : indexSubPaths) {
import java.nio.file.Files;
 * the entire dataset on remote store. It maintains a node level view of index files with priorities,
    }
            throw new UnsupportedOperationException();
    }
    public FileCache(SegmentedCache<Path, CachedIndexInput> cache, CircuitBreaker circuitBreaker) {
                    } else {
    public long prune() {
     * Pins the key in the cache, preventing it from being evicted.
        final RefCountedCacheStats pinnedFileCacheStats = stats.getPinnedFileCacheStats();
                capacity(),
 * SPDX-License-Identifier: Apache-2.0
import java.nio.file.Path;
    /**
            fileCacheDataPaths.stream()
                overallCacheStats.missCount(),
                fullFileCacheStats.usage(),
    }
    // To be used only for debugging purposes
        return theCache.usage();
        BiFunction<? super Path, ? super CachedIndexInput, ? extends CachedIndexInput> remappingFunction
        theCache.clear();
     */
                        }
        private final Path path;
                    }
                                        subTasks.add(new LoadTask(indexSubPath, fc, exception, true));
     */
 *
    }
                    if (e instanceof UncheckedIOException) {
        public void compute() {
        public void close() throws Exception {}
 * of a given file (since it makes it the most recently used).
        CachedIndexInput cachedIndexInput = theCache.put(filePath, indexInput);
                pinnedFileCacheStats.activeUsage(),
        @Override
            return true;
        return theCache.stats();
/*
            }
        this.theCache = theCache;
            new FileCacheStats(
    }
            this.length = length;
        public LoadTask(Path path, FileCache fc, SetOnce<UncheckedIOException> exception, boolean processedDirectory) {
 * this file be licensed under the Apache-2.0 license or a
            this.processedDirectory = false;
     * @param key
            try {
        return theCache.capacity();
                return;
     */
        @Override
     * local cache at node startup time. We can't open a file handle to these
    @Override
     *
                overallCacheStats.usage(),
        }).filter(Files::isRegularFile).forEach(path -> {
     * @return the combined pinned weight of the values in this cache.
        theCache.remove(filePath);
     * This API also updates the priority for the given file
                                    }
     * @return corresponding file index input from FileCache.
     * Returns the pinned usage of this cache.
                blockFileCacheStats.missCount(),
        }
    @Override
     * entry that will open the actual file handle to create the IndexInput.
import static org.opensearch.index.store.remote.utils.FileTypeUtils.INDICES_FOLDER_IDENTIFIER;
    /**
        final RefCountedCacheStats blockFileCacheStats = stats.getBlockFileCacheStats();
        }
import java.util.function.Predicate;
        Stream.concat(
        }
     * Unpins the key in the cache, allowing it to be evicted.
     * Returns the current {@link AggregateFileCacheStats}
        private final boolean processedDirectory;
     * {@link org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory#LOCAL_STORE_LOCATION}
}
        public LoadTask(Path path, FileCache fc, SetOnce<UncheckedIOException> exception) {
    }
                fullFileCacheStats.pinnedUsage(),
    /**
    @Deprecated(forRemoval = true)
                capacity(),
                throw new UncheckedIOException("Unable to process file cache directory. Please clear the file cache for node startup.", e);
    }
        private final long length;
        return new AggregateFileCacheStats(
    public long usage() {
        });
                }
 * priority.
                blockFileCacheStats.pinnedUsage(),
import org.opensearch.common.SetOnce;
import static org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION;
     */
                decRef(path.toAbsolutePath());
    ) {
     * blocks at this point, so we store this placeholder object in the cache.
    /**
    }
                .filter(Files::isDirectory)
        private final SetOnce<UncheckedIOException> exception;
    }
            } catch (IOException | UncheckedIOException e) {
    public void pin(Path key) {
import org.opensearch.core.common.breaker.CircuitBreaker;
    public long size() {
                        exception.set(new UncheckedIOException("Unable to process directories.", (IOException) e));
    public long activeUsage() {
 * <p>The two main interfaces of FC are put and get. When a new file index input is added
            this.exception = exception;
                FileCacheStatsType.OVER_ALL_STATS
                fullFileCacheStats.removeWeight(),
    public void decRef(Path key) {
            ),
    public void unpin(Path key) {
        return theCache.prune(keyPredicate);
import java.util.concurrent.RecursiveAction;
        this(cache);
    public CachedIndexInput compute(
        }
    }
     * still take effect.
     * A recursive task for loading file cache entries from disk during node startup.
    private final CircuitBreaker circuitBreaker = null;
            return length;
                    }
        }
    public static class LoadTask extends RecursiveAction {
                capacity(),
    }
        return theCache.activeUsage();
    public static class RestoredCachedIndexInput implements CachedIndexInput {
                        exception.set((UncheckedIOException) e);
    public Integer getRef(Path key) {
import java.nio.file.DirectoryStream;
    public CachedIndexInput put(Path filePath, CachedIndexInput indexInput) {
    /**
    @Override
    /**
        theCache.unpin(key);
        return theCache.prune();
 *
import java.util.ArrayList;
                                    List<Path> indexSubPaths = new ArrayList<>();
@PublicApi(since = "2.7.0")
    @Override
    // To be used only in testing framework.
        public boolean isClosed() {
 * <p> The get function does not add file to cache, but it promotes the priority
    }
            ),
        ).flatMap(dir -> {
                put(path.toAbsolutePath(), new RestoredCachedIndexInput(Files.size(path)));
     * Placeholder for the existing file blocks that are in the disk-based
                pinnedFileCacheStats.usage(),
                } catch (SetOnce.AlreadySetException ignore) {
    @Override
                blockFileCacheStats.evictionWeight(),
        final AggregateRefCountedCacheStats stats = (AggregateRefCountedCacheStats) stats();
    @Override
            ),
        }
import org.apache.lucene.store.IndexInput;
     */
    }
    @Override
                blockFileCacheStats.usage(),
            List<LoadTask> subTasks = new ArrayList<>();
    @Override
import org.apache.logging.log4j.LogManager;
            this.processedDirectory = processedDirectory;
import org.opensearch.index.store.remote.utils.cache.stats.AggregateRefCountedCacheStats;
                .map(path -> path.resolve(INDICES_FOLDER_IDENTIFIER))
     *
                                }
        theCache.incRef(key);
            this.exception = exception;
import org.opensearch.index.store.remote.utils.cache.SegmentedCache;
    }
 * items from cache tail and triggers a callback to clean up the file from disk. The
    public long capacity() {
     * @deprecated Use {@link FileCache(SegmentedCache<Path, CachedIndexInput>)}. CircuitBreaker parameter is not used.
import java.util.function.BiFunction;
 *
                    if (Files.isDirectory(path)) {
 * cleanup process also includes closing file’s descriptor.
import org.opensearch.index.store.remote.utils.cache.RefCountedCache;
                                if (Files.isDirectory(indexPath)) {
    public void restoreFromDirectory(List<Path> fileCacheDataPaths) {
import java.util.List;
                pinnedFileCacheStats.missCount(),
        return theCache.pinnedUsage();
    }
                .filter(Files::isDirectory)
                            }
            } catch (IOException e) {
    }
    @Override
 * to the file cache, the file will be added at cache head, which means it has the highest
        return theCache.get(filePath);
                blockFileCacheStats.hitCount(),
                .map(path -> path.resolve(LOCAL_STORE_LOCATION))
    public FileCache(SegmentedCache<Path, CachedIndexInput> theCache) {
                        try (DirectoryStream<Path> indexStream = Files.newDirectoryStream(path)) {
     */
                FileCacheStatsType.PINNED_FILE_STATS
     * Uses fork-join parallelism to efficiently scan directories and restore cached files.
                pinnedFileCacheStats.evictionWeight(),
        @Override
    @Override
                            for (Path indexPath : indexStream) {
    }
        private final FileCache fc;
                pinnedFileCacheStats.hitCount(),
 *
     */
    @Override
            this.path = path;
    public CachedIndexInput get(Path filePath) {
    public AggregateFileCacheStats fileCacheStats() {
 * The OpenSearch Contributors require contributions made to
import java.io.UncheckedIOException;
                if (processedDirectory) {
                                    processDirectoryFiles(indexPath, indexSubPaths);
    public void closeIndexInputReferences() {
 * @opensearch.api
        }
        theCache.logCurrentState();
import org.opensearch.index.store.remote.utils.cache.stats.IRefCountedCacheStats;
        theCache.decRef(key);
 * caching only those index files needed by queries. The file with the lowest priority
     * @param filePath given file path
                return Files.list(dir);
                }
        theCache.closeIndexInputReferences();
 */
            try {
import org.opensearch.common.annotation.PublicApi;
                try {
    /**
        );
     * directory within the provided file cache path.
    }
 * (Least Recently Used) in the FC is replaced first.
                pinnedFileCacheStats.pinnedUsage(),
                    this.fc.restoreFromDirectory(List.of(path));
    }
import org.opensearch.index.store.remote.utils.cache.stats.RefCountedCacheStats;
    @Override
            new FileCacheStats(
            System.currentTimeMillis(),
    public void clear() {
                overallCacheStats.pinnedUsage(),
        CachedIndexInput cachedIndexInput = theCache.compute(key, remappingFunction);
    /**
    }
     */
            }
            fileCacheDataPaths.stream()
     * @param key
        return theCache.getRef(key);
     * If a block is needed, then these entries will be replaced with a proper
     * Given a file path, gets the corresponding file index input from FileCache.
    private final SegmentedCache<Path, CachedIndexInput> theCache;
                .filter(Files::isDirectory)
    }
import static org.opensearch.env.NodeEnvironment.processDirectoryFiles;
            }
 * compatible open source license.
     * Restores the file cache instance performing a folder scan of the
     */
            this.path = path;
import java.io.IOException;
     *
