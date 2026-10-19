            assertTrue("Metadata should contain subdir/metadata_file2.dat", metadata.contains("subdir/metadata_file2.dat"));
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)  
                    SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(store.directory());
     * Mock IndexCommit that wraps SegmentInfos and includes files from subdirectories  
                        }
        @Override
        final long otherStatsBytes = randomLongBetween(0L, Integer.MAX_VALUE);  
            try (IndexWriter writer = new IndexWriter(store.directory(), new IndexWriterConfig())) {  
            assertNotNull("Version should not be null", file1Meta.writtenBy());  
        final long reservedBytes = randomBoolean() ? StoreStats.UNKNOWN_RESERVED_BYTES : randomLongBetween(0L, Integer.MAX_VALUE);  
                String checksum1 = metadata2.get("subdir/checksum_test.dat").checksum();
        long initialStoreSize = 0;  
        SubdirectoryAwareStore store = new SubdirectoryAwareStore(
            Path subdirPath = setup.path.resolve("subdir");
        for (String file : files) {
        Map<String, IndexStorePlugin.StoreFactory> factories = plugin.getStoreFactories();  
        try {  
                writeTestFileWithCodec(subdir, "metadata_file2.dat", "test_data_2");
            }
                        }
        for (String extraFiles : store.directory().listAll()) {
            new FsDirectoryFactory()
        private final List<Path> subdirectoryPaths;
        }  
        final long length;
    public void testLoadMetadataWithNonSegmentFiles() throws IOException {
        stats.add(null);
import org.apache.lucene.store.IndexInput;  
        private final List<String> subdirectoryNames;  
        TestStoreSetup(SubdirectoryAwareStore store, Path path) {  
            deleteContent(store.directory());  
        for (String file : store.directory().listAll()) {  
}
                        writer.commit();  
import org.apache.lucene.util.BytesRef;  
        }
    static class TestIndexCommit extends IndexCommit {
            IOUtils.close(store);
            assertNotNull("Checksum should not be null", file2Meta.checksum());
            }
            for (String fileName : metadata.asMap().keySet()) {  
        @Override  
            TestIndexCommit testCommit = new TestIndexCommit(segmentInfos, store.directory(), subdirPath, "subdir");
        assertEquals(initialStoreSize, stats.getSize().getBytes());  
        final long otherStatsReservedBytes = randomBoolean() ? StoreStats.UNKNOWN_RESERVED_BYTES : randomLongBetween(0L, Integer.MAX_VALUE);
            SubdirectoryStorePluginTests.newFSDirectory(indexPath),
                assertFalse("Different content should produce different checksums", checksum1.equals(checksum2));  
            }  
        }
            // Get the committed SegmentInfos from the directory  
            // Verify different files have different checksums
            if (file.startsWith("extra") == false) {
    public void testLoadMetadataWithMixedFiles() throws IOException {  
                && !fileName.endsWith(".lock");
                BytesRef bytesRef = new BytesRef(TestUtil.randomRealisticUnicodeString(random(), 10, 1024));
            String testContent = "test_content_for_checksum";
            }
            new DummyShardLock(shardId),  
import org.apache.lucene.store.Directory;  
        deleteContent(store.directory());  
import org.opensearch.index.store.FsDirectoryFactory;
            .put(Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMinutes(0))
        @Override
            // Verify non-segment files are included in metadata  
            assertTrue("Metadata should contain custom_metadata.dat", metadata.contains("subdir/custom_metadata.dat"));  
            assertTrue("File length should be greater than 0", file1Meta.length() > 0);
            StoreFileMetadata file2Meta = metadata.get("subdir/metadata_file2.dat");
            output.writeString(content);
     */
                    TestIndexCommit testCommit = new TestIndexCommit(segmentInfos, store.directory(), subdirPath, "subdir");
            Store.MetadataSnapshot metadata = store.getMetadata(testCommit);
            try (Directory subdir = FSDirectory.open(subdirPath)) {
        @Override
        ExceptionsHelper.rethrowAndSuppress(exceptions);
            this.segmentInfos = segmentInfos;  
            shardId,  
        assertEquals(stats.getSizeInBytes(), length + initialStoreSize);
                    assertEquals("Checksum should match CodecUtil.checksumEntireFile result", expectedChecksum, fileMeta.checksum());  
        }
                Store.MetadataSnapshot metadata2 = store.getMetadata(testCommit2);
            }
        Settings settings = Settings.builder()
    }  
            }
        assertTrue(numNonExtraFiles(store) > 0);
        );  
                output.writeBytes(bytesRef.bytes, bytesRef.offset, bytesRef.length);  
            }  
                directory.deleteFile(file);  
import java.util.List;  
                            for (String fileName : segmentInfos.files(true)) {
import java.util.ArrayList;
            deleteContent(store.directory());
            boolean hasSegmentFile = false;
         */  
            SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(store.directory());
            } catch (NoSuchFileException | FileNotFoundException e) {
 *
        } finally {  
        } finally {
                writeTestFileWithCodec(subdir, "checksum_test2.dat", "different_content");
                    try (Directory directory = FSDirectory.open(subdirPath)) {
import java.util.Map;
            .put(Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMinutes(0))
     * Helper method to write a test file with proper Lucene codec header and footer  
                }  
            // Load metadata
        }
        }
        try {
                writeTestFileWithCodec(subdir, "checksum_test.dat", testContent);
        TestStoreSetup setup = createTestStoreSetup();  
        @Override
        public Collection<String> getFileNames() throws IOException {  
            assertFalse("Different files should have different checksums", file1Meta.checksum().equals(file2Meta.checksum()));
            CodecUtil.writeFooter(output);
     */
                    // Create mock IndexCommit  
                }
            new DummyShardLock(shardId),
                if (Files.exists(subdirPath)) {
                && !fileName.endsWith(".cfe")
    private void writeTestFileWithCodec(Directory dir, String fileName, String content) throws IOException {
                writer.commit();
            output.writeLong(System.currentTimeMillis());  
                exceptions.add(e);
                && !fileName.startsWith("extra")
                                allFiles.add(subdirName + "/" + fileName);  
import org.opensearch.index.shard.ShardPath;
            .build();  
        assertEquals(initialStoreSize + otherStatsBytes, stats.getSize().getBytes());  
            // Write segment files
import org.apache.lucene.store.IndexOutput;
import org.opensearch.plugins.IndexStorePlugin;  
                    String expectedChecksum = Store.digestToString(CodecUtil.checksumEntireFile(in));
            // Create mock IndexCommit that includes subdirectory files  
                }
        assertTrue(factory instanceof SubdirectoryStorePlugin.SubdirectoryStoreFactory);
            new FsDirectoryFactory()  
        }
            // Write non-segment files with codec headers and footers
import org.apache.lucene.index.IndexCommit;
        assertEquals(reservedBytes, stats.getReservedSize().getBytes());
        Path indexPath = path.resolve("index");
    /**
                // ignore
    }  
import org.apache.lucene.tests.util.TestUtil;
                    // Verify checksum matches  
        Path path = createTempDir().resolve("indices").resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));  
                try (IndexInput in = subdir.openInput("checksum_test.dat", IOContext.READONCE)) {
 * this file be licensed under the Apache-2.0 license or a
                writeTestFileWithCodec(subdir, "metadata_file1.dat", "test_data_1");  
                    StoreFileMetadata fileMeta = metadata.get("subdir/checksum_test.dat");
                numNonExtra++;
            deleteContent(store.directory());  
        SubdirectoryAwareStore store = setup.store;
            throw new UnsupportedOperationException("TestIndexCommit does not support deletion");
            for (int i = 0; i < subdirectoryPaths.size(); i++) {  
        IOUtils.close(store);
import org.opensearch.index.store.StoreStats;
            assertNotNull("Checksum should not be null", file1Meta.checksum());
import org.opensearch.index.store.Store;  
     */
        private final Directory directory;
    /**  
    public void testPluginInstantiation() {
                // Write another file with different content  
        StoreStats stats = store.stats(reservedBytes);
            Files.createDirectories(subdirPath);  
                            SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(directory);
            assertNotNull("File metadata should not be null", file2Meta);  
            // Write test file with codec headers and footers
    }  
        }  
            return directory;  
        }
        return numNonExtra;
/*  
                    }
            int iters = scaledRandomIntBetween(10, 100);  
    }  
            // Verify non-segment file is included
import org.apache.lucene.codecs.CodecUtil;
        stats = store.stats(0L);  
                            }
import java.io.FileNotFoundException;
            // Create a minimal segments file in main directory
import java.util.Collection;
        stats.add(new StoreStats.Builder().sizeInBytes(otherStatsBytes).reservedSize(otherStatsReservedBytes).build());
    private static class TestStoreSetup {
            }
            try (IndexWriter writer = new IndexWriter(store.directory(), new IndexWriterConfig())) {
                                allFiles.add(subdirName + "/" + fileName);  
import org.opensearch.common.settings.Settings;  
                            // No segment files, that's OK  
import org.opensearch.ExceptionsHelper;
    }
import org.opensearch.common.util.io.IOUtils;
    }
            return allFiles;
            new ShardPath(false, path, path, shardId),
        private final SegmentInfos segmentInfos;  
            this.subdirectoryPaths = List.of(subdirectoryPath);
        int numNonExtra = 0;
                    Store.MetadataSnapshot metadata = store.getMetadata(testCommit);
                String checksum2 = metadata2.get("subdir/checksum_test2.dat").checksum();
        /**
            for (int i = 0; i < iters; i++) {
        TestStoreSetup setup = createTestStoreSetup();
                    writer.commit();
            assertTrue("expected extraFS file but got: " + extraFiles, extraFiles.startsWith("extra"));
            try (Directory subdir = FSDirectory.open(subdirPath)) {  
import org.apache.lucene.index.IndexWriterConfig;
            shardId,
                            }
        public long getGeneration() {
            Collection<String> allFiles = new ArrayList<>(segmentInfos.files(true));
            assertTrue("File length should be greater than 0", file2Meta.length() > 0);
        }  
            IOUtils.close(store);
        Files.createDirectories(indexPath);
            .build();
            Path subdirPath = setup.path.resolve("subdir");
        assertNotNull(factory);  
    }  
import java.nio.file.Path;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
            }
 * SPDX-License-Identifier: Apache-2.0
            // Verify segment files are included
import org.apache.lucene.store.FSDirectory;
        final Path path;
                    break;  
            StoreFileMetadata file1Meta = metadata.get("subdir/metadata_file1.dat");
            // Verify file metadata properties
                    assertNotNull("File metadata should exist", fileMeta);
    private TestStoreSetup createTestStoreSetup() throws IOException {  
    /**
     */
                if (fileName.startsWith("subdir/segments_")) {
            Store.MetadataSnapshot metadata = store.getMetadata(testCommit);
import org.opensearch.cluster.metadata.IndexMetadata;
        SubdirectoryAwareStore store = new SubdirectoryAwareStore(
import org.opensearch.test.OpenSearchTestCase;  
            // Get the committed SegmentInfos from the directory
        assertEquals(initialStoreSize, stats.getSize().getBytes());
                TestIndexCommit testCommit2 = new TestIndexCommit(segmentInfos2, store.directory(), subdirPath, "subdir");
                // Verify different content produces different checksum  
            return segmentInfos.size();
        }  
    }
                && !fileName.endsWith(".cfs")  
        Directory dir = store.directory();  
        public String getSegmentsFileName() {
        SubdirectoryStorePlugin plugin = new SubdirectoryStorePlugin();  
        @Override  
        public int getSegmentCount() {  
            } catch (IOException e) {  
        final String[] files = directory.listAll();
            IndexSettingsModule.newIndexSettings("index", settings),
            this.directory = directory;
import org.apache.lucene.store.IOContext;
            return segmentInfos.getSegmentsFileName();
                        // Add segment files if they exist
            CodecUtil.writeHeader(output, "test_codec", 0);
            // Create mock IndexCommit that includes subdirectory files
        SubdirectoryStorePlugin plugin = new SubdirectoryStorePlugin();
            return false;
                writer.commit();  
                        try {  
            Files.createDirectories(subdirPath);
            Store.OnClose.EMPTY,
                String subdirName = subdirectoryNames.get(i);
            return segmentInfos.getGeneration();  
        assertNotNull(factories);
        SubdirectoryAwareStore store = setup.store;
            IndexSettingsModule.newIndexSettings("index", settings),  
        final List<IOException> exceptions = new ArrayList<>();  
        TestStoreSetup setup = createTestStoreSetup();  
        }  
        public boolean isDeleted() {  
            // Load metadata  
        }
        }  
import java.io.IOException;  
        }
        Settings settings = Settings.builder()  
import org.opensearch.core.index.shard.ShardId;  
                // Write non-segment files
    public void testStats() throws IOException {
        try (IndexOutput output = dir.createOutput(fileName, IOContext.DEFAULT)) {  
package org.opensearch.plugin.store.subdirectory;
    }  
                        // Add non-segment files (exclude test infrastructure and Lucene internal files)  
     * Creates a test store setup with all necessary paths and configurations
 */  
            SubdirectoryStorePluginTests.newFSDirectory(path.resolve("index")),
    /**
            new ShardPath(false, path, path, shardId),
         * Returns true if the file is a custom metadata file (not a Lucene internal file or test infrastructure file)
                && !fileName.endsWith(".si")  
        try (IndexOutput output = dir.createOutput("foo/bar", IOContext.DEFAULT)) {
            assertTrue("Metadata should contain subdir/metadata_file1.dat", metadata.contains("subdir/metadata_file1.dat"));
        } finally {
        final ShardId shardId = new ShardId("index", "_na_", 1);
    }
            this.subdirectoryNames = List.of(subdirectoryName);  
        public Directory getDirectory() {
                        String[] files = directory.listAll();  
        @Override
        SubdirectoryAwareStore store = setup.store;
        }  
        public Map<String, String> getUserData() throws IOException {
            IOUtils.close(store);
import org.opensearch.test.IndexSettingsModule;
            Store.OnClose.EMPTY,  
 * The OpenSearch Contributors require contributions made to  
        final ShardId shardId = new ShardId("index", "_na_", 1);
        return new TestStoreSetup(store, path);
            length = output.getFilePointer();
import org.apache.lucene.index.SegmentInfos;
                writeTestFileWithCodec(subdir, "custom_metadata.dat", "custom_data");
            // Create a minimal segments file in the main directory
                Path subdirPath = subdirectoryPaths.get(i);
import org.apache.lucene.index.IndexWriter;  
                        for (String fileName : files) {
        try {  
                            if (isCustomMetadataFile(fileName)) {
            this.path = path;
public class SubdirectoryStorePluginTests extends OpenSearchTestCase {  
        );
            }
            Files.createDirectories(subdirPath);
        IndexStorePlugin.StoreFactory factory = factories.get("subdirectory_store");
                }
 * compatible open source license.
            TestIndexCommit testCommit = new TestIndexCommit(segmentInfos, store.directory(), subdirPath, "subdir");
                SegmentInfos segmentInfos2 = SegmentInfos.readLatestCommit(store.directory());
        TestIndexCommit(SegmentInfos segmentInfos, Directory directory, Path subdirectoryPath, String subdirectoryName) {
                    // Create main segments file
        assertTrue(factories.containsKey("subdirectory_store"));  
    }
    public static void deleteContent(Directory directory) throws IOException {
                // Get the committed SegmentInfos from the directory  
            return !fileName.startsWith("segments_")
        Path path = createTempDir().resolve("indices").resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
            return segmentInfos.getUserData();
        assertEquals(reservedBytes, stats.getReservedSize().getBytes());  
                        } catch (Exception e) {
            initialStoreSize += store.directory().fileLength(extraFiles);  
                try (IndexWriter writer = new IndexWriter(subdir, new IndexWriterConfig())) {
    public void testGetStoreFactories() {
        public void delete() {
            try (Directory subdir = FSDirectory.open(subdirPath)) {  
     * Helper class to hold test store setup data  
            assertNotNull("File metadata should not be null", file1Meta);  
        private static boolean isCustomMetadataFile(String fileName) {
        assertEquals(Math.max(reservedBytes, 0L) + Math.max(otherStatsReservedBytes, 0L), stats.getReservedSize().getBytes());
            try {
            SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(store.directory());
    public void testNonSegmentFileChecksumValidation() throws IOException {
                    // Load metadata  
import java.nio.file.Files;
        @Override  
        }
            assertEquals("Should have no duplicate entries", fileNames.size(), fileNames.stream().distinct().count());
    public int numNonExtraFiles(Store store) throws IOException {
            Collection<String> fileNames = metadata.asMap().keySet();  
import org.opensearch.test.DummyShardLock;
                    // Get the committed SegmentInfos from the directory  
    }
            this.store = store;
            Path subdirPath = setup.path.resolve("subdir");
import org.opensearch.common.unit.TimeValue;
        }
        final SubdirectoryAwareStore store;  
        }
                    try (IndexWriter writer = new IndexWriter(store.directory(), new IndexWriterConfig())) {
                // Compute expected checksum directly  
                    }  
                    hasSegmentFile = true;
import java.nio.file.NoSuchFileException;
import org.opensearch.index.store.StoreFileMetadata;
            assertTrue("Should have segment file in subdirectory", hasSegmentFile);  
        assertNotNull(plugin);
            // Verify no duplicate entries
