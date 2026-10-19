    @SuppressForbidden(reason = "creating a test file for cache")
        // after prune with false predicate
        Path tempDir = createTempDir();
        }
    public void testRestoreFromEmptyDirectory() throws IOException {
            fileCache.put(path1, new StubCachedIndexInput(BLOCK_SIZE));  
        FileCache fileCache = createFileCache(MEGA_BYTES);
        FileCache fileCache = createFileCache(MEGA_BYTES);
        try {
        assertNotNull(fileCache.get(createPath("3")));
            assertNull(fileCache.get(path1));
        // verify all blocks are put into file cache
    public void testOverallActivePercentStats() {  
    public void testComputeThrowException() {
        Files.write(filePath, "test-data".getBytes());
        });  
        fileCache.put(createPath(Integer.toString(10)), new StubCachedIndexInput(3 * MEGA_BYTES));
        // Create files in both cache and indices directories
import org.opensearch.env.NodeEnvironment;  
                fsDirectory.openInput("test_file", IOContext.DEFAULT)  
        String index2 = "test-warm-index-2";
        assertTrue(fileCache.usage() > 0);
    public void testStats() {
        }
        String warmIndex = "test-warm-index-";
        FileCache fileCache = createFileCache(10 * BLOCK_SIZE);
        fileCache.remove(createPath("0"));
            );  
        // Verify some of the original files were evicted
            .resolve(shardId)  
            if (fileCache.get(filePath) == null) {  
    private final static String FAKE_PATH_SUFFIX = "Suffix";
            fileCache.closeIndexInputReferences();
        }
    private Path path;
        task1.join();  
        assertEquals(53.75, fileCache.fileCacheStats().getOverallActivePercent(), 0.0);
            putAndDecRef(fileCache, i, BLOCK_SIZE);
            .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION);
        }
                // Remove known extra files - "extra0" file is added by the ExtrasFS, which is part of Lucene's test framework
        path = createTempDir("FileCacheTests");  
            Path filePath = path.resolve(NodeEnvironment.CACHE_FOLDER)
        fileCache.restoreFromDirectory(List.of(cachePath, indicesPath));  
        public IndexInput getIndexInput() {  
    public void testIncRefThrowException() {
import java.nio.file.attribute.PosixFilePermissions;  
            assertNotNull(fileCache.get(filePath.resolve("test_file")));
    public static class StubCachedIndexInput implements CachedIndexInput {  
        FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(16 * MEGA_BYTES, 1);
        Path path3 = tempDir.resolve("test3.tmp");
import java.nio.file.Files;
        fileCache.restoreFromDirectory(List.of(fileCachePath));  
    }  
            fileCache.put(path1, new StubCachedIndexInput(BLOCK_SIZE));  
    public void testCloseIndexInputReferences() throws IOException {
        long expectedActiveCacheUsage = 0;
            assertNull(fileCache.getRef(createPath(Integer.toString(i))));  
    public void testGet() {  
public class FileCacheTests extends OpenSearchTestCase {  
        @Override
        long realActiveCacheUsage = fileCache.activeUsage();  
                .resolve(Integer.toString(i))
        assertTrue(fileCache.usage() > 0);
            Files.deleteIfExists(path1);
                .resolve("indexName")
        }  
            FileCache fileCache = createFileCache(MEGA_BYTES);
 *
import java.nio.file.Path;
        assertTrue("Expected some files to be evicted", someEvicted);
        FileCache fileCache = createFileCache(MEGA_BYTES);
        });
        int numEntries = 2;
        cache.decRef(key);
    }
            FileCache fileCache = createFileCache(MEGA_BYTES);  
    @Before
            fileCache.decRef(filePath);
        }
            fileCache.get(null);
    }  
    public void testRestoreWithNonExistentDirectory() {  
    public void testRestoreWithInvalidWarmIndexFiles() throws IOException {
        }  
        // Create the files  
    }
        public StubCachedIndexInput(long length) {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
}
            Path filePath = path.resolve(NodeEnvironment.CACHE_FOLDER)
        assertEquals(0, fileCache.size());
        // before prune
        Path folderPath = path.resolve(NodeEnvironment.INDICES_FOLDER)
        assertEquals(fileCache.size(), 4);
    }  
        Files.createFile(filePath);
    }  
        // item will be removed
import org.opensearch.test.OpenSearchTestCase;
        }  
        });
            this.length = length;
        int numEntries = 2;  
            createFile("indexName", "shardId/".concat(Integer.toString(i)), "test_file");  
        // try to evict previous IndexInput  
        fileCache.get(createPath("0"));
            }
 */  
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
                Files.deleteIfExists(
        String shardId = "0";
        Files.createDirectories(invalidFilePath.getParent());  
    }  
    public void testPutThrowException() {  
        }
        }
        Path cachePath = path.resolve(NodeEnvironment.CACHE_FOLDER);
                .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION);  
                .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION);
        final Path key = createPath(Integer.toString(path));  
    }
        for (int i = 0; i < 4; i++) {
import java.util.concurrent.ForkJoinTask;  
            return length;  
                    path.resolve(NodeEnvironment.INDICES_FOLDER)
        Path indicesPath = path.resolve(NodeEnvironment.INDICES_FOLDER).resolve(index2).resolve(shardId);
        createWarmIndexFile(indexName, shardId, "valid.0");
        public boolean isClosed() {
        public long length() {
import org.opensearch.node.Node;
                fileCache,  
    public void testCacheRestore() throws IOException {
            Files.deleteIfExists(path3);
        fileCache.compute(path, (p, i) -> null);  
        for (int i = 0; i < 4; i++) {
        fileCache.restoreFromDirectory(List.of(indicesPath));  
    // test get method
        Path path = createPath("0");  
        assertEquals(new ByteSizeValue(5 * BLOCK_SIZE), fileCache.fileCacheStats().getActive());
        fileCache.prune(path -> false);  
            // Verify path still exists
        try {
    public void testRestoreFromMultipleDirectories() throws IOException {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors(), Node.CustomForkJoinWorkerThread::new, null, false);
    public void testIncDecRef() {  
                .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION);
            assertNull(fileCache.get(path2));  
        assertEquals(expectedActiveCacheUsage, realActiveCacheUsage);  
                );  
        });
        @Override
        String indexName = "test-warm-index";  
                Files.deleteIfExists(  
    }  
        // cache hits  
        assertEquals(fileCache.size(), 0);
    }
        assertEquals(expectedActiveCacheUsage, realActiveCacheUsage);
        assertEquals(fileCache.size(), 2);  
    }  
        long expectedCacheUsage = 16 * MEGA_BYTES;
import java.io.UncheckedIOException;  
        ForkJoinTask<Void> task1 = pool.submit(new FileCache.LoadTask(indicesPath, fileCache, exception));  
        assertEquals(100, fileCache.fileCacheStats().getActivePercent());
        }
import org.junit.Before;  
            .resolve(shardId)  
        assertEquals("No files should be actively used", 0, fileCache.activeUsage());
        for (int i = 0; i < 4; i++) {  
        }  
        assertTrue("File cache should contain at least the valid file", fileCache.usage() > 0);
        fileCache.put(path, new StubCachedIndexInput(BLOCK_SIZE));
        }
        for (int i = 0; i < 2000; i++) {
            }  
        assertEquals(50.0, fileCache.fileCacheStats().getOverallActivePercent(), 0.0);  
        }  
        }
        Files.createFile(filePath);
            fileCache.put(path2, new StubCachedIndexInput(BLOCK_SIZE));
import org.apache.lucene.store.FSDirectory;  
    public void testRemoveThrowException() {
        // Should handle the invalid file gracefully
        FileCache fileCache = createFileCache(MEGA_BYTES);
        assertTrue(fileCache.size() >= 1);  
        // test file cache size  
    public void testCapacity() {
 * compatible open source license.
            assertNotNull(fileCache.get(createPath(Integer.toString(i))));
    public void testPruneWithPredicate() {
    public void testConcurrentRestore() throws IOException {
                .resolve(Integer.toString(i))
    @SuppressForbidden(reason = "creating a test file for cache")
    }
 * this file be licensed under the Apache-2.0 license or a
        FileCache fileCache = createFileCache(1 * 1000);  
                .resolve("shardId")
    private final static int BLOCK_SIZE = 8 * MEGA_BYTES;  
                someEvicted = true;
        fileCache.incRef(path);
                break;
            fileCache.compute(null, null);
        }
            // Verify initial state
                .resolve("indexName")  
        return path.resolve(middle).resolve(FAKE_PATH_SUFFIX);
            FileCache fileCache = createFileCache(MEGA_BYTES);
        for (int i = 0; i < 4; i++) {
        createWarmIndexFile(indexName, shardId, "test.0");
    private final static int CONCURRENCY_LEVEL = 16;
        fileCache.restoreFromDirectory(List.of(emptyDir));
            fileCache.incRef(null);
                .resolve("shardId")
            assertTrue(Files.exists(path1));
        FileCache fileCache = createFileCache(MEGA_BYTES);  
    }  
        for (int i = 0; i < 4; i++) {  
        assertEquals(fileCache.capacity(), MEGA_BYTES);
        // Test eviction by adding more files to exceed cache capacity
        Files.createFile(invalidFilePath);
import org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory;
        FileCache fileCache = createFileCache(MEGA_BYTES);
        assertEquals(2000, fileCache.size());  
    // but fatal to these tests  
        logger.info(fileCache);
    private void createWarmIndexFile(String indexName, String shardId, String fileName) throws IOException {  
            assertNotNull(fileCache.getRef(createPath(Integer.toString(i))));
            assertNotNull(fileCache.get(createPath(Integer.toString(i))));
        assertEquals(fileCache.stats().hitCount(), 2);
                        .resolve(warmIndex + i)
            fileCache.put(filePath.resolve("test_file"), new CachedFullFileIndexInput(fileCache, filePath, fileCachedIndexInput));
        String shardId = "0";
 * SPDX-License-Identifier: Apache-2.0
            FSDirectory fsDirectory = FSDirectory.open(filePath);
        }
        assertThrows(NullPointerException.class, () -> {
            fileCache.put(null, null);  
            assertEquals(numEntries, fileCache.size());
            .resolve(indexName)
        fileCache.prune();  
            // Close all references  
/*  
    }  
        fileCache.get(createPath("-1"));
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));
            putAndDecRef(fileCache, i, BLOCK_SIZE);
        FileCache fileCache = createFileCache(MEGA_BYTES);  
            fileCache.decRef(filePath);
        Path path1 = tempDir.resolve("test1.tmp");
        FileCache fileCache = createFileCache(BLOCK_SIZE);
        // do some eviction here  
        Path folderPath = path.resolve(NodeEnvironment.CACHE_FOLDER)
            fileCache.put(path2, new StubCachedIndexInput(BLOCK_SIZE));
    }  
        }
        createFile(index1, shardId, "test1.0");
            fileCache.remove(null);
        for (int i = 1; i <= 100; i++) {  
        FileCache fileCache = createFileCache(1024 * MEGA_BYTES);  
        for (int i = 0; i < 4; i++) {
    public void testRemove() {  
import org.opensearch.index.store.remote.utils.FileTypeUtils;  
        String index1 = "test-index-1";  
        FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(24 * MEGA_BYTES, 1);  
    public void testWarmIndexCacheRestore() throws IOException {
                createFile(index + i, String.valueOf(j), "_" + j + "_block_" + j);
        for (int i = 0; i < 4; i++) {
        FileCache fileCache = createFileCache(1024 * MEGA_BYTES);
        Path invalidFilePath = path.resolve(NodeEnvironment.INDICES_FOLDER)
            assertNull(fileCache.get(createPath(Integer.toString(i))));
        }
        putAndDecRef(fileCache, 0, 16 * MEGA_BYTES);
    private FileCache createFileCache(long capacity) {  
        // after prune
    public void testCompute() {
        // after prune with true predicate  
            assertEquals(2, (int) fileCache.getRef(createPath(Integer.toString(i))));  
            assertEquals(0, (int) fileCache.getRef(createPath(Integer.toString(i))));
        @Override
            assertNotNull(fileCache.getRef(createPath(Integer.toString(i))));
            FSDirectory fsDirectory = FSDirectory.open(filePath);
        for (int i = 0; i < 5; i++) {
            // Verify cache is empty
    }
    // need concurrency level to be static to make these tests more deterministic because capacity per segment is dependent on
        assertEquals(new ByteSizeValue(5 * BLOCK_SIZE), fileCache.fileCacheStats().getUsed());  
        createWarmIndexFile(index2, shardId, "test2.0");  
import java.util.concurrent.ForkJoinPool;
        FileCache fileCache = createFileCache(MEGA_BYTES);
        // IndexInput with refcount greater than 0 will not be evicted
        Path tempDir = createTempDir();  
        }
            Files.deleteIfExists(path2);  
        Path cachePath = path.resolve(NodeEnvironment.CACHE_FOLDER).resolve(index1).resolve(shardId);  
            .resolve(indexName)
    }  
        Path nonExistentPath = path.resolve("non-existent");
 * The OpenSearch Contributors require contributions made to  
                fsDirectory.openInput("test_file", IOContext.DEFAULT)
        FileCache fileCache = createFileCache(1024 * MEGA_BYTES);
        Path emptyDir = createTempDir();  
    public void testDecRefThrowException() {  
        for (int i = 0; i < 4; i++) {  
    }  
        }
            FileCache fileCache = createFileCache(MEGA_BYTES);
        }  
            createFile("indexName", "shardId/".concat(Integer.toString(i)), "test_file");
import java.util.List;
        Files.createFile(path3);  
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));
        }  
        Files.setPosixFilePermissions(invalidFilePath, PosixFilePermissions.fromString("---------"));  
    }  
        Files.createFile(path1);
        long realCacheUsage = fileCache.usage();
        }
        boolean someEvicted = false;
            fileCache.decRef(path1); // Decrease reference count  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        } finally {
        pool.shutdown();
        String shardId = "0";
            Files.deleteIfExists(path1);
                createWarmIndexFile(warmIndex + i, String.valueOf(j), "_" + j + "_block_" + j);  
    private void createFile(String indexName, String shardId, String fileName) throws IOException {  
                filePath,
    }
                        .resolve("extra0")
                .resolve("indexName")
        Files.createFile(path1);
        for (int i = 0; i < 4; i++) {
    }
        fileCache.get(createPath("1"));
        for (int i = 0; i < 4; i++) {  
        for (int i = 0; i < 4; i++) {
        // try to evict previous IndexInput again
                .resolve(Integer.toString(i))
        assertEquals(0, fileCache.usage());
        FileCache fileCache = createFileCache(MEGA_BYTES);
        assertThrows(NullPointerException.class, () -> {  
        return FileCacheFactory.createConcurrentLRUFileCache(capacity, CONCURRENCY_LEVEL);
        // Make file unreadable
    }
        });  
    }
                        .resolve(FileTypeUtils.INDICES_FOLDER_IDENTIFIER)
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));  
            Path filePath = path.resolve(NodeEnvironment.CACHE_FOLDER)
        long expectedCacheUsage = 16 * MEGA_BYTES;  
        assertEquals(0, fileCache.activeUsage());
            return null;
            .resolve(FileTypeUtils.INDICES_FOLDER_IDENTIFIER);
    }  
    }
    public void testGetWithCachedFullFileIndexInput() throws IOException {
    }  
            fileCache.put(filePath.resolve("test_file"), new CachedFullFileIndexInput(fileCache, filePath, fileCachedIndexInput));
            fileCache.decRef(createPath(Integer.toString(i)));  
        Path path2 = tempDir.resolve("test2.tmp");  
        assertEquals(0, fileCache.activeUsage());  
                .resolve("shardId")  
                .resolve("shardId")  
        Path indicesPath = path.resolve(NodeEnvironment.INDICES_FOLDER).resolve(indexName).resolve(shardId);  
        FileCache fileCache = createFileCache(MEGA_BYTES);
    public void testSize() {
        ForkJoinTask<Void> task2 = pool.submit(new FileCache.LoadTask(cachePath, fileCache, exception));
        }
        Files.write(filePath, "test-data".getBytes());
            FileCache fileCache = createFileCache(MEGA_BYTES);
        assertEquals(expectedCacheUsage, realCacheUsage);  
        }
            .resolve(FileTypeUtils.INDICES_FOLDER_IDENTIFIER)
    public void testUsage() {
        assertEquals(expectedCacheUsage, realCacheUsage);
                fileCache,
    }
        String indexName = "test-index";  
    public void testUsageAtFullActiveCapacity() throws IOException {  
        Path filePath = folderPath.resolve(fileName);
            putAndDecRef(fileCache, i, BLOCK_SIZE);
                .resolve(Integer.toString(i))  
    public void init() throws Exception {
        long realCacheUsage = fileCache.usage();  
        cache.put(key, new StubCachedIndexInput(indexInputSize));
        for (int i = 1000; i < 3000; i++) {
            fileCache.decRef(createPath(Integer.toString(i)));
        for (int i = 0; i < 8000; i++) {  
        Path fileCachePath = path.resolve(NodeEnvironment.CACHE_FOLDER).resolve(indexName).resolve(shardId);
        assertTrue(fileCache.size() >= 1);
        assertEquals(0, fileCache.activeUsage());
        SetOnce<UncheckedIOException> exception = new SetOnce<>();
        assertThrows(NullPointerException.class, () -> {  
    public void testGetThrowException() {
        Files.createFile(path2);  
            FileCache fileCache = createFileCache(MEGA_BYTES);
        Path indicesPath = path.resolve(NodeEnvironment.INDICES_FOLDER);  
            fileCache.put(path3, new StubCachedIndexInput(BLOCK_SIZE));
        });  
                        .resolve(String.valueOf(j))
                        .resolve(String.valueOf(j))  
            putAndDecRef(fileCache, i, BLOCK_SIZE);
        String indexName = "test-warm-index";  
package org.opensearch.index.store.remote.filecache;
import org.opensearch.core.common.unit.ByteSizeValue;
                .resolve("indexName")
    private void putAndDecRef(FileCache cache, int path, long indexInputSize) {
            FileCachedIndexInput fileCachedIndexInput = new FileCachedIndexInput(
        assertEquals(0, fileCache.size());
            fileCache.incRef(path1); // Increase reference count
        // Add some entries to cache
    private Path createPath(String middle) {
        createFile(indexName, shardId, "test.0");
                        .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION)
        private final long length;
        assertTrue(fileCache.size() >= 1);
        assertTrue(fileCache.stats().evictionWeight() > 0);
        fileCache.restoreFromDirectory(List.of(nonExistentPath));
        Path indicesCachePath = path.resolve(NodeEnvironment.INDICES_FOLDER).resolve(indexName).resolve(shardId);
    }  
        // before prune  
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));  
        fileCache.get(createPath("-2"));
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));  
        // decrease ref
            assertTrue(Files.exists(path2));  
        assertTrue(fileCache.stats().evictionCount() > 0);
        String shardId = "0";
        Files.createDirectories(folderPath);  
            fileCache.incRef(path2); // Increase reference count  
        assertEquals(0, fileCache.usage());
    }
            assertEquals(0, fileCache.size());  
        fileCache.remove(createPath("0"));  
            // Verify all entries are removed
        FileCache fileCache = createFileCache(MEGA_BYTES);  
        assertEquals(0, fileCache.usage());
        assertThrows(NullPointerException.class, () -> {  
        fileCache.prune(path -> true);
        // verify all files are put into file cache
            return false;
        String index = "test-index-";  
        long realActiveCacheUsage = fileCache.activeUsage();
            FileCachedIndexInput fileCachedIndexInput = new FileCachedIndexInput(  
            for (int j = 0; j < 10; j++) {
        assertThrows(NullPointerException.class, () -> {
                        .resolve(index + i)  
        for (int i = 4; i < 8000; i++) {  
        assertEquals(0, fileCache.activeUsage());
        assertTrue(fileCache.usage() > 0);
            fileCache.put(createPath(Integer.toString(i)), new StubCachedIndexInput(BLOCK_SIZE));  
    }
        Path path1 = tempDir.resolve("test1.tmp");
        for (int i = 0; i < 4; i++) {  
        // Create a valid warm index file  
    public void testPrune() {
        Files.createFile(path2);
        }  
import org.opensearch.common.SetOnce;  
        task2.join();
            fileCache.decRef(null);  
import org.apache.lucene.store.IOContext;
    }  
        long expectedActiveCacheUsage = 16 * MEGA_BYTES;
        public void close() throws Exception {  
                filePath,
        assertEquals(0, fileCache.usage());
            putAndDecRef(fileCache, i, BLOCK_SIZE);
            .resolve(shardId)  
    // (total capacity) / (concurrency level) so having high concurrency level might trigger early evictions which is tolerable in real life
            Path filePath = path.resolve(NodeEnvironment.CACHE_FOLDER)  
        // cache misses  
    }  
        // Create the files
        assertThrows(NullPointerException.class, () -> {
        Path filePath = folderPath.resolve(fileName);
        assertEquals(new ByteSizeValue(10 * BLOCK_SIZE), fileCache.fileCacheStats().getTotal());
        @Override  
        assertEquals(0, fileCache.size());
import org.opensearch.common.SuppressForbidden;
import java.io.IOException;
            Files.deleteIfExists(path2);  
            .resolve(indexName)
        } finally {
    }
            );
    private final static int MEGA_BYTES = 1024 * 1024;
            .resolve("invalid.0");
                );
        for (int i = 3000; i < 5000; i++) {  
        fileCache.remove(createPath("1"));
        Path path2 = tempDir.resolve("test2.tmp");
        // Add some entries to cache
        assertNotNull(fileCache.get(createPath("2")));
        FileCache fileCache = createFileCache(MEGA_BYTES);  
                        .resolve("extra0")  
        FileCache fileCache = createFileCache(MEGA_BYTES);  
        Files.createDirectories(folderPath);  
    }
                .resolve(RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION);
        // Create an invalid/corrupt warm index file  
                    path.resolve(NodeEnvironment.CACHE_FOLDER)
        for (int i = 0; i < 4; i++) {
        fileCache.restoreFromDirectory(List.of(indicesCachePath));  
import org.apache.lucene.store.IndexInput;
