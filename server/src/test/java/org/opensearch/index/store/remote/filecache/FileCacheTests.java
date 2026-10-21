        fileCache.restoreFromDirectory(List.of(cachePath, indicesPath));
    }
        }
        assertEquals(0, fileCache.size());
        String shardId = "0";
        assertEquals(0, fileCache.activeUsage());
        Path folderPath = path.resolve(NodeEnvironment.INDICES_FOLDER)
    public void testCacheRestore() throws IOException {
                    path.resolve(NodeEnvironment.CACHE_FOLDER)
            .resolve(shardId)
        Path path = createPath("0");
    }
        long expectedActiveCacheUsage = 16 * MEGA_BYTES;
        }
        }
            Path filePath = path.resolve(NodeEnvironment.CACHE_FOLDER)
                .resolve("shardId")
        Files.createDirectories(folderPath);
        assertEquals(expectedCacheUsage, realCacheUsage);
    // (total capacity) / (concurrency level) so having high concurrency level might trigger early evictions which is tolerable in real life
        assertEquals(0, fileCache.usage());
        long expectedCacheUsage = 16 * MEGA_BYTES;
            .resolve(shardId)
            FileCache fileCache = createFileCache(MEGA_BYTES);
        assertEquals(expectedActiveCacheUsage, realActiveCacheUsage);
        // Make file unreadable
                createFile(index + i, String.valueOf(j), "_" + j + "_block_" + j);
        assertTrue("Expected some files to be evicted", someEvicted);
 * The OpenSearch Contributors require contributions made to
package org.opensearch.index.store.remote.filecache;
        @Override
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));
        Path indicesCachePath = path.resolve(NodeEnvironment.INDICES_FOLDER).resolve(indexName).resolve(shardId);
        // verify all files are put into file cache
    }
        Path path1 = tempDir.resolve("test1.tmp");
        fileCache.prune();
        assertTrue(fileCache.stats().evictionWeight() > 0);
        String warmIndex = "test-warm-index-";
        Path path3 = tempDir.resolve("test3.tmp");
            );
        assertEquals(0, fileCache.usage());
    public void testConcurrentRestore() throws IOException {
        @Override
            this.length = length;
/*
                        .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION)
                );
        assertTrue(fileCache.size() >= 1);
 * SPDX-License-Identifier: Apache-2.0
    public void testCapacity() {
        Files.createDirectories(folderPath);
        Path filePath = folderPath.resolve(fileName);
        fileCache.prune(path -> false);
        });
        @Override
            fileCache.incRef(path2); // Increase reference count
        Path filePath = folderPath.resolve(fileName);
        for (int i = 0; i < 4; i++) {
    public void testCloseIndexInputReferences() throws IOException {
    public void testSize() {
        assertEquals(0, fileCache.activeUsage());
            assertNotNull(fileCache.getRef(createPath(Integer.toString(i))));
        String shardId = "0";
        public IndexInput getIndexInput() {
    public void testGetWithCachedFullFileIndexInput() throws IOException {
        }
            return false;
        fileCache.restoreFromDirectory(List.of(indicesCachePath));
    public void testRestoreFromMultipleDirectories() throws IOException {
    public void testGet() {
        Path emptyDir = createTempDir();
    }
        for (int i = 0; i < 4; i++) {
    }
                        .resolve("extra0")
import org.opensearch.env.NodeEnvironment;
        FileCache fileCache = createFileCache(1 * 1000);
        logger.info(fileCache);
        }
            FileCache fileCache = createFileCache(MEGA_BYTES);
        for (int i = 0; i < 4; i++) {
    private void createFile(String indexName, String shardId, String fileName) throws IOException {
        // Create the files
    }
            fileCache.decRef(path1); // Decrease reference count
    // need concurrency level to be static to make these tests more deterministic because capacity per segment is dependent on
    public void testStats() {
        String shardId = "0";
public class FileCacheTests extends OpenSearchTestCase {
            .resolve("invalid.0");
    public void testCompute() {
        final Path key = createPath(Integer.toString(path));
        Path nonExistentPath = path.resolve("non-existent");
        });
        FileCache fileCache = createFileCache(MEGA_BYTES);
                        .resolve(warmIndex + i)
        Path path2 = tempDir.resolve("test2.tmp");
        assertEquals(0, fileCache.activeUsage());
    // test get method
        assertThrows(NullPointerException.class, () -> {
    }
        Files.createFile(path1);
    public void testWarmIndexCacheRestore() throws IOException {
    public void testPutThrowException() {
        Files.createFile(path1);
    public void testOverallActivePercentStats() {
    }
import java.nio.file.Path;
            fileCache.decRef(createPath(Integer.toString(i)));
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));
import org.opensearch.common.SuppressForbidden;
                        .resolve(String.valueOf(j))
        FileCache fileCache = createFileCache(MEGA_BYTES);
        }
                        .resolve(index + i)
        path = createTempDir("FileCacheTests");
        boolean someEvicted = false;
        long expectedActiveCacheUsage = 0;
    private void createWarmIndexFile(String indexName, String shardId, String fileName) throws IOException {
    public void testIncDecRef() {
        int numEntries = 2;
        assertEquals("No files should be actively used", 0, fileCache.activeUsage());
    }
        public StubCachedIndexInput(long length) {
            fileCache.put(path3, new StubCachedIndexInput(BLOCK_SIZE));
        assertEquals(0, fileCache.size());
        Path cachePath = path.resolve(NodeEnvironment.CACHE_FOLDER);
        fileCache.restoreFromDirectory(List.of(fileCachePath));
        Path tempDir = createTempDir();
        createFile(index1, shardId, "test1.0");
                .resolve(Integer.toString(i))
        assertEquals(expectedActiveCacheUsage, realActiveCacheUsage);
        SetOnce<UncheckedIOException> exception = new SetOnce<>();
        assertEquals(expectedCacheUsage, realCacheUsage);
        assertThrows(NullPointerException.class, () -> {
        });
            return length;
        }
        // cache misses
    private FileCache createFileCache(long capacity) {
            assertNull(fileCache.get(path2));
    }
        FileCache fileCache = createFileCache(MEGA_BYTES);
        ForkJoinTask<Void> task1 = pool.submit(new FileCache.LoadTask(indicesPath, fileCache, exception));
        assertThrows(NullPointerException.class, () -> {
        // after prune
        String shardId = "0";
import java.io.UncheckedIOException;
        // verify all blocks are put into file cache
        assertEquals(0, fileCache.usage());
                        .resolve(FileTypeUtils.INDICES_FOLDER_IDENTIFIER)
    }
        Path tempDir = createTempDir();
        String indexName = "test-index";
        assertNotNull(fileCache.get(createPath("2")));
        createWarmIndexFile(indexName, shardId, "test.0");
            .resolve(shardId)
                break;
        fileCache.remove(createPath("0"));
        FileCache fileCache = createFileCache(MEGA_BYTES);
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));
    private final static int BLOCK_SIZE = 8 * MEGA_BYTES;
        task1.join();
    }
        fileCache.remove(createPath("1"));
    private Path path;
                fsDirectory.openInput("test_file", IOContext.DEFAULT)
        Files.write(filePath, "test-data".getBytes());
    }
        FileCache fileCache = createFileCache(MEGA_BYTES);
    public void testPruneWithPredicate() {
        task2.join();
        long realCacheUsage = fileCache.usage();
        assertThrows(NullPointerException.class, () -> {
        assertEquals(0, fileCache.usage());
                .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION);
        for (int i = 0; i < 4; i++) {
            if (fileCache.get(filePath) == null) {
            fileCache.put(path2, new StubCachedIndexInput(BLOCK_SIZE));
        // item will be removed
        for (int i = 0; i < 4; i++) {
        assertThrows(NullPointerException.class, () -> {
    // but fatal to these tests
        assertEquals(100, fileCache.fileCacheStats().getActivePercent());
    public void testComputeThrowException() {
                    path.resolve(NodeEnvironment.INDICES_FOLDER)
    }
        Files.createFile(filePath);
            Files.deleteIfExists(path3);
    }
            fileCache.incRef(path1); // Increase reference count
        });
                fsDirectory.openInput("test_file", IOContext.DEFAULT)
        for (int i = 4; i < 8000; i++) {
        fileCache.restoreFromDirectory(List.of(indicesPath));
    }
        assertEquals(fileCache.size(), 0);
        }
            assertNull(fileCache.getRef(createPath(Integer.toString(i))));
                filePath,
                fileCache,
        @Override
        String index = "test-index-";
                filePath,
        });
        long realCacheUsage = fileCache.usage();
        Path path1 = tempDir.resolve("test1.tmp");
 * compatible open source license.
        // Create an invalid/corrupt warm index file
            fileCache.put(path1, new StubCachedIndexInput(BLOCK_SIZE));
            .resolve(FileTypeUtils.INDICES_FOLDER_IDENTIFIER)
        FileCache fileCache = createFileCache(MEGA_BYTES);
            assertEquals(2, (int) fileCache.getRef(createPath(Integer.toString(i))));
        }
            assertEquals(0, fileCache.size());
        for (int i = 0; i < 4; i++) {
            }
import org.opensearch.core.common.unit.ByteSizeValue;
            Files.deleteIfExists(path1);
import org.apache.lucene.store.IOContext;
        } finally {
                .resolve("shardId")
        assertNotNull(fileCache.get(createPath("3")));
            FileCache fileCache = createFileCache(MEGA_BYTES);
            FileCachedIndexInput fileCachedIndexInput = new FileCachedIndexInput(
        assertEquals(2000, fileCache.size());
        assertTrue(fileCache.usage() > 0);
        Files.write(filePath, "test-data".getBytes());
import org.opensearch.test.OpenSearchTestCase;
            Files.deleteIfExists(path1);
        }
            }
        assertEquals(fileCache.capacity(), MEGA_BYTES);
        FileCache fileCache = createFileCache(MEGA_BYTES);
                .resolve("indexName")
        public boolean isClosed() {
                .resolve("shardId")
        FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(24 * MEGA_BYTES, 1);
import java.nio.file.Files;
            // Verify initial state
            putAndDecRef(fileCache, i, BLOCK_SIZE);
        }
        FileCache fileCache = createFileCache(1024 * MEGA_BYTES);
    public void testRestoreWithInvalidWarmIndexFiles() throws IOException {
        for (int i = 1; i <= 100; i++) {
                .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION);
        createWarmIndexFile(index2, shardId, "test2.0");
        for (int i = 0; i < 4; i++) {
}
    private void putAndDecRef(FileCache cache, int path, long indexInputSize) {
    public void testRemoveThrowException() {
            fileCache.decRef(createPath(Integer.toString(i)));
        for (int i = 0; i < 8000; i++) {
 *
            // Verify cache is empty
        for (int i = 0; i < 5; i++) {
            fileCache.decRef(filePath);
                .resolve(Integer.toString(i))
            fileCache.closeIndexInputReferences();
    @Before
        assertTrue("File cache should contain at least the valid file", fileCache.usage() > 0);
    }
        fileCache.get(createPath("1"));
        } finally {
    @SuppressForbidden(reason = "creating a test file for cache")
        for (int i = 0; i < 4; i++) {
    }
        FileCache fileCache = createFileCache(MEGA_BYTES);
                Files.deleteIfExists(
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
                .resolve(Integer.toString(i))
                        .resolve("extra0")
            assertNotNull(fileCache.getRef(createPath(Integer.toString(i))));
                );
        });
        // do some eviction here
        assertTrue(fileCache.usage() > 0);
        fileCache.get(createPath("-1"));
        }
        Files.createFile(filePath);
        // before prune
        fileCache.put(path, new StubCachedIndexInput(BLOCK_SIZE));
            assertNull(fileCache.get(createPath(Integer.toString(i))));
                .resolve("indexName")
        // cache hits
            fileCache.get(null);
        }
        assertTrue(fileCache.size() >= 1);
        fileCache.compute(path, (p, i) -> null);
import org.junit.Before;
        for (int i = 0; i < 4; i++) {
        assertEquals(0, fileCache.size());
        for (int i = 0; i < 4; i++) {
    public void testRestoreFromEmptyDirectory() throws IOException {
        assertEquals(fileCache.size(), 4);
                createWarmIndexFile(warmIndex + i, String.valueOf(j), "_" + j + "_block_" + j);
    public void init() throws Exception {
        Files.createFile(path2);
        assertEquals(new ByteSizeValue(10 * BLOCK_SIZE), fileCache.fileCacheStats().getTotal());
        // test file cache size
            .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION);
import java.io.IOException;
        for (int i = 0; i < 4; i++) {
                .resolve("shardId")
        String index1 = "test-index-1";
            Files.deleteIfExists(path2);
            putAndDecRef(fileCache, i, BLOCK_SIZE);
        Files.setPosixFilePermissions(invalidFilePath, PosixFilePermissions.fromString("---------"));
import java.util.List;
    private final static int MEGA_BYTES = 1024 * 1024;
        // try to evict previous IndexInput again
        for (int i = 0; i < 4; i++) {
            putAndDecRef(fileCache, i, BLOCK_SIZE);
        cache.put(key, new StubCachedIndexInput(indexInputSize));
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        try {
            FileCache fileCache = createFileCache(MEGA_BYTES);
    private Path createPath(String middle) {
                        .resolve(String.valueOf(j))
        fileCache.put(createPath(Integer.toString(10)), new StubCachedIndexInput(3 * MEGA_BYTES));
        fileCache.remove(createPath("0"));
    }
            assertTrue(Files.exists(path1));
                // Remove known extra files - "extra0" file is added by the ExtrasFS, which is part of Lucene's test framework
        Files.createFile(path3);
        // decrease ref
            createFile("indexName", "shardId/".concat(Integer.toString(i)), "test_file");
        }
        }
import org.apache.lucene.store.FSDirectory;
    public void testRemove() {
        String indexName = "test-warm-index";
    private final static String FAKE_PATH_SUFFIX = "Suffix";
        String index2 = "test-warm-index-2";
        assertThrows(NullPointerException.class, () -> {
        fileCache.prune(path -> true);
        Path fileCachePath = path.resolve(NodeEnvironment.CACHE_FOLDER).resolve(indexName).resolve(shardId);
        assertEquals(50.0, fileCache.fileCacheStats().getOverallActivePercent(), 0.0);
            assertTrue(Files.exists(path2));
    private final static int CONCURRENCY_LEVEL = 16;
        FileCache fileCache = createFileCache(MEGA_BYTES);
    @SuppressForbidden(reason = "creating a test file for cache")
            assertNull(fileCache.get(path1));
import org.apache.lucene.store.IndexInput;
        // Create files in both cache and indices directories
        Files.createFile(path2);
            FSDirectory fsDirectory = FSDirectory.open(filePath);
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors(), Node.CustomForkJoinWorkerThread::new, null, false);
        fileCache.get(createPath("0"));
            // Close all references
        for (int i = 3000; i < 5000; i++) {
        // Verify some of the original files were evicted
    public void testGetThrowException() {
    }
        }
            fileCache.decRef(filePath);
    }
    public void testUsageAtFullActiveCapacity() throws IOException {
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));
            fileCache.compute(null, null);
        }
        long expectedCacheUsage = 16 * MEGA_BYTES;
        // Add some entries to cache
        // before prune
            fileCache.put(path1, new StubCachedIndexInput(BLOCK_SIZE));
    }
        // Create the files
        FileCache fileCache = createFileCache(MEGA_BYTES);
        FileCache fileCache = createFileCache(1024 * MEGA_BYTES);
            Path filePath = path.resolve(NodeEnvironment.CACHE_FOLDER)
    public static class StubCachedIndexInput implements CachedIndexInput {
                Files.deleteIfExists(
        for (int i = 0; i < 4; i++) {
        try {
        // after prune with true predicate
    public void testPrune() {
        FileCache fileCache = createFileCache(10 * BLOCK_SIZE);
        public long length() {
    }
            FileCache fileCache = createFileCache(MEGA_BYTES);
        fileCache.restoreFromDirectory(List.of(emptyDir));
import org.opensearch.node.Node;
        // Should handle the invalid file gracefully
    public void testDecRefThrowException() {
            .resolve(indexName)
                someEvicted = true;
        FileCache fileCache = createFileCache(MEGA_BYTES);
        }
        long realActiveCacheUsage = fileCache.activeUsage();
        assertEquals(53.75, fileCache.fileCacheStats().getOverallActivePercent(), 0.0);
        Path indicesPath = path.resolve(NodeEnvironment.INDICES_FOLDER).resolve(indexName).resolve(shardId);
            putAndDecRef(fileCache, i, BLOCK_SIZE);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(fileCache.stats().hitCount(), 2);
        public void close() throws Exception {
            // Verify all entries are removed
        pool.shutdown();
            putAndDecRef(fileCache, i, BLOCK_SIZE);
        createFile(indexName, shardId, "test.0");
        Path indicesPath = path.resolve(NodeEnvironment.INDICES_FOLDER);
    }
        private final long length;
        return FileCacheFactory.createConcurrentLRUFileCache(capacity, CONCURRENCY_LEVEL);
    }
        fileCache.incRef(path);
        }
                .resolve("indexName")
    }
 */
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));
        assertTrue(fileCache.size() >= 1);
            fileCache.incRef(null);
            FileCachedIndexInput fileCachedIndexInput = new FileCachedIndexInput(
        assertEquals(0, fileCache.activeUsage());
    }
            FSDirectory fsDirectory = FSDirectory.open(filePath);
        }
        assertEquals(new ByteSizeValue(5 * BLOCK_SIZE), fileCache.fileCacheStats().getUsed());
            return null;
    public void testRestoreWithNonExistentDirectory() {
            );
            assertNotNull(fileCache.get(filePath.resolve("test_file")));
    public void testIncRefThrowException() {
        FileCache fileCache = createFileCache(BLOCK_SIZE);
        // IndexInput with refcount greater than 0 will not be evicted
            .resolve(indexName)
            // Verify path still exists
        // Test eviction by adding more files to exceed cache capacity
        }
        }
            for (int j = 0; j < 10; j++) {
        Path folderPath = path.resolve(NodeEnvironment.CACHE_FOLDER)
    public void testUsage() {
        FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(16 * MEGA_BYTES, 1);
            assertEquals(numEntries, fileCache.size());
        for (int i = 1000; i < 3000; i++) {
        // after prune with false predicate
            fileCache.put(null, null);
        assertEquals(fileCache.size(), 2);
    }
        assertTrue(fileCache.usage() > 0);
        int numEntries = 2;
        FileCache fileCache = createFileCache(1024 * MEGA_BYTES);
                .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION);
            assertEquals(0, (int) fileCache.getRef(createPath(Integer.toString(i))));
            createFile("indexName", "shardId/".concat(Integer.toString(i)), "test_file");
        }
            FileCache fileCache = createFileCache(MEGA_BYTES);
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));
    }
                .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION);
            assertNotNull(fileCache.get(createPath(Integer.toString(i))));
        }
            Files.deleteIfExists(path2);
            .resolve(indexName)
                .resolve("indexName")
            fileCache.decRef(null);
        // Create a valid warm index file
        fileCache.get(createPath("-2"));
        createWarmIndexFile(indexName, shardId, "valid.0");
        fileCache.restoreFromDirectory(List.of(nonExistentPath));
            Path filePath = path.resolve(NodeEnvironment.CACHE_FOLDER)
            fileCache.remove(null);
            fileCache.put(path2, new StubCachedIndexInput(BLOCK_SIZE));
        // Add some entries to cache
import org.opensearch.index.store.remote.utils.FileTypeUtils;
        for (int i = 0; i < 2000; i++) {
import java.util.concurrent.ForkJoinTask;
            .resolve(FileTypeUtils.INDICES_FOLDER_IDENTIFIER);
        Path cachePath = path.resolve(NodeEnvironment.CACHE_FOLDER).resolve(index1).resolve(shardId);
        FileCache fileCache = createFileCache(MEGA_BYTES);
                .resolve(Integer.toString(i))
        Path path2 = tempDir.resolve("test2.tmp");
        putAndDecRef(fileCache, 0, 16 * MEGA_BYTES);
            assertNotNull(fileCache.get(createPath(Integer.toString(i))));
        assertEquals(new ByteSizeValue(5 * BLOCK_SIZE), fileCache.fileCacheStats().getActive());
    }
            fileCache.put(filePath.resolve("test_file"), new CachedFullFileIndexInput(fileCache, filePath, fileCachedIndexInput));
        }
        }
        ForkJoinTask<Void> task2 = pool.submit(new FileCache.LoadTask(cachePath, fileCache, exception));
            Path filePath = path.resolve(NodeEnvironment.CACHE_FOLDER)
        Files.createFile(invalidFilePath);
        }
        long realActiveCacheUsage = fileCache.activeUsage();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            fileCache.put(filePath.resolve("test_file"), new CachedFullFileIndexInput(fileCache, filePath, fileCachedIndexInput));
        Path indicesPath = path.resolve(NodeEnvironment.INDICES_FOLDER).resolve(index2).resolve(shardId);
import java.nio.file.attribute.PosixFilePermissions;
import org.opensearch.common.SetOnce;
    }
import org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory;
        assertTrue(fileCache.stats().evictionCount() > 0);
                fileCache,
        Path invalidFilePath = path.resolve(NodeEnvironment.INDICES_FOLDER)
        return path.resolve(middle).resolve(FAKE_PATH_SUFFIX);
        cache.decRef(key);
        FileCache fileCache = createFileCache(MEGA_BYTES);
import java.util.concurrent.ForkJoinPool;
        Files.createDirectories(invalidFilePath.getParent());
    }
    }
        String indexName = "test-warm-index";
    }
        // try to evict previous IndexInput
