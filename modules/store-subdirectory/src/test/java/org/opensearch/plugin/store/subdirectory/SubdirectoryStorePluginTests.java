            IOUtils.close(store);
            throw new UnsupportedOperationException("TestIndexCommit does not support deletion");
        ExceptionsHelper.rethrowAndSuppress(exceptions);
            shardId,
        try {
                        try {
        final long otherStatsReservedBytes = randomBoolean() ? StoreStats.UNKNOWN_RESERVED_BYTES : randomLongBetween(0L, Integer.MAX_VALUE);
            SubdirectoryStorePluginTests.newFSDirectory(indexPath),
    }
    }
        );
            Files.createDirectories(subdirPath);
            // Verify different files have different checksums
            // Create a minimal segments file in main directory
    }
        }
    /**
                // Write non-segment files
                numNonExtra++;
            deleteContent(store.directory());
            Store.OnClose.EMPTY,
            return segmentInfos.size();
                && !fileName.endsWith(".lock");
        }
        Directory dir = store.directory();
import org.apache.lucene.index.IndexWriter;
            return directory;
                Path subdirPath = subdirectoryPaths.get(i);
        }
        SubdirectoryAwareStore store = setup.store;
import java.io.IOException;
            for (int i = 0; i < iters; i++) {
                if (Files.exists(subdirPath)) {
import org.apache.lucene.store.Directory;
            initialStoreSize += store.directory().fileLength(extraFiles);
            assertNotNull("File metadata should not be null", file2Meta);
        @Override
        public boolean isDeleted() {
     */
        }
        Files.createDirectories(indexPath);
                exceptions.add(e);
                        writer.commit();
            Files.createDirectories(subdirPath);
import java.nio.file.Files;
        }
            shardId,
                }
        public Map<String, String> getUserData() throws IOException {
    public void testNonSegmentFileChecksumValidation() throws IOException {
                TestIndexCommit testCommit2 = new TestIndexCommit(segmentInfos2, store.directory(), subdirPath, "subdir");
        for (String file : store.directory().listAll()) {
import org.apache.lucene.store.IndexInput;
                    assertEquals("Checksum should match CodecUtil.checksumEntireFile result", expectedChecksum, fileMeta.checksum());
            Collection<String> fileNames = metadata.asMap().keySet();
            SubdirectoryStorePluginTests.newFSDirectory(path.resolve("index")),
import org.opensearch.common.unit.TimeValue;
            new FsDirectoryFactory()
        Settings settings = Settings.builder()
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
        private final List<String> subdirectoryNames;
                SegmentInfos segmentInfos2 = SegmentInfos.readLatestCommit(store.directory());
            assertTrue("Metadata should contain custom_metadata.dat", metadata.contains("subdir/custom_metadata.dat"));
        IndexStorePlugin.StoreFactory factory = factories.get("subdirectory_store");
            for (String fileName : metadata.asMap().keySet()) {
                                allFiles.add(subdirName + "/" + fileName);
        SubdirectoryAwareStore store = new SubdirectoryAwareStore(
        assertEquals(reservedBytes, stats.getReservedSize().getBytes());
            return segmentInfos.getGeneration();
        try (IndexOutput output = dir.createOutput("foo/bar", IOContext.DEFAULT)) {
            // Get the committed SegmentInfos from the directory
import org.opensearch.index.store.FsDirectoryFactory;
                        for (String fileName : files) {
import org.opensearch.test.DummyShardLock;
            IndexSettingsModule.newIndexSettings("index", settings),
    }
        private static boolean isCustomMetadataFile(String fileName) {
        TestIndexCommit(SegmentInfos segmentInfos, Directory directory, Path subdirectoryPath, String subdirectoryName) {
                try (IndexInput in = subdir.openInput("checksum_test.dat", IOContext.READONCE)) {
                        } catch (Exception e) {
import java.nio.file.Path;
                if (fileName.startsWith("subdir/segments_")) {
            try (IndexWriter writer = new IndexWriter(store.directory(), new IndexWriterConfig())) {
        assertEquals(initialStoreSize + otherStatsBytes, stats.getSize().getBytes());
                // ignore
     * Creates a test store setup with all necessary paths and configurations
        @Override
 *
            assertNotNull("Version should not be null", file1Meta.writtenBy());
        Path path = createTempDir().resolve("indices").resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
        }
    }
        long initialStoreSize = 0;
            new ShardPath(false, path, path, shardId),
    /**
                    hasSegmentFile = true;
    public void testStats() throws IOException {
            Path subdirPath = setup.path.resolve("subdir");
            CodecUtil.writeFooter(output);
                writeTestFileWithCodec(subdir, "metadata_file2.dat", "test_data_2");
            deleteContent(store.directory());
 * The OpenSearch Contributors require contributions made to
     */
    private static class TestStoreSetup {
                }
        deleteContent(store.directory());
            assertFalse("Different files should have different checksums", file1Meta.checksum().equals(file2Meta.checksum()));
                    }
            TestIndexCommit testCommit = new TestIndexCommit(segmentInfos, store.directory(), subdirPath, "subdir");
                writeTestFileWithCodec(subdir, "checksum_test.dat", testContent);
        assertEquals(initialStoreSize, stats.getSize().getBytes());
        public Directory getDirectory() {
    public int numNonExtraFiles(Store store) throws IOException {
            Collection<String> allFiles = new ArrayList<>(segmentInfos.files(true));
import org.apache.lucene.tests.util.TestUtil;
        } finally {
public class SubdirectoryStorePluginTests extends OpenSearchTestCase {
import org.apache.lucene.index.SegmentInfos;
                            }
        assertNotNull(plugin);
        for (String extraFiles : store.directory().listAll()) {
            new FsDirectoryFactory()
        TestStoreSetup setup = createTestStoreSetup();
                // Verify different content produces different checksum
            assertTrue("expected extraFS file but got: " + extraFiles, extraFiles.startsWith("extra"));
            // Create a minimal segments file in the main directory
                writeTestFileWithCodec(subdir, "metadata_file1.dat", "test_data_1");
                    try (Directory directory = FSDirectory.open(subdirPath)) {
        @Override
import org.apache.lucene.store.IOContext;
                && !fileName.startsWith("extra")
        }
                    }
        }
            Path subdirPath = setup.path.resolve("subdir");
        }
        }
     * Mock IndexCommit that wraps SegmentInfos and includes files from subdirectories
    public void testLoadMetadataWithNonSegmentFiles() throws IOException {
            try (Directory subdir = FSDirectory.open(subdirPath)) {
        stats.add(new StoreStats.Builder().sizeInBytes(otherStatsBytes).reservedSize(otherStatsReservedBytes).build());
import org.opensearch.cluster.metadata.IndexMetadata;
 * this file be licensed under the Apache-2.0 license or a
        final long reservedBytes = randomBoolean() ? StoreStats.UNKNOWN_RESERVED_BYTES : randomLongBetween(0L, Integer.MAX_VALUE);
            // Write test file with codec headers and footers
        final long length;
        assertTrue(factory instanceof SubdirectoryStorePlugin.SubdirectoryStoreFactory);
        final SubdirectoryAwareStore store;
        Map<String, IndexStorePlugin.StoreFactory> factories = plugin.getStoreFactories();
            new DummyShardLock(shardId),
                String checksum1 = metadata2.get("subdir/checksum_test.dat").checksum();
    public void testLoadMetadataWithMixedFiles() throws IOException {
    }
                BytesRef bytesRef = new BytesRef(TestUtil.randomRealisticUnicodeString(random(), 10, 1024));
                    StoreFileMetadata fileMeta = metadata.get("subdir/checksum_test.dat");
        TestStoreSetup setup = createTestStoreSetup();
            return !fileName.startsWith("segments_")
    public void testPluginInstantiation() {
                        String[] files = directory.listAll();
import org.opensearch.ExceptionsHelper;
            // Write segment files
            String testContent = "test_content_for_checksum";
        SubdirectoryAwareStore store = setup.store;
                    Store.MetadataSnapshot metadata = store.getMetadata(testCommit);
        final List<IOException> exceptions = new ArrayList<>();
    public static void deleteContent(Directory directory) throws IOException {
        @Override
            // Verify no duplicate entries
     */
        final ShardId shardId = new ShardId("index", "_na_", 1);
        public int getSegmentCount() {
        return new TestStoreSetup(store, path);
                            }
                    String expectedChecksum = Store.digestToString(CodecUtil.checksumEntireFile(in));
            }
import org.apache.lucene.index.IndexCommit;
 * compatible open source license.
            }
        } finally {
                // Write another file with different content
                try (IndexWriter writer = new IndexWriter(subdir, new IndexWriterConfig())) {
            this.store = store;
        }
            assertTrue("Should have segment file in subdirectory", hasSegmentFile);
            IndexSettingsModule.newIndexSettings("index", settings),
        SubdirectoryStorePlugin plugin = new SubdirectoryStorePlugin();
        final Path path;
import org.apache.lucene.codecs.CodecUtil;
    /**
            IOUtils.close(store);
    private void writeTestFileWithCodec(Directory dir, String fileName, String content) throws IOException {
            this.segmentInfos = segmentInfos;
                writer.commit();
        assertTrue(factories.containsKey("subdirectory_store"));
            for (int i = 0; i < subdirectoryPaths.size(); i++) {
         */
        } finally {
        return numNonExtra;
        @Override
                        // Add non-segment files (exclude test infrastructure and Lucene internal files)
import java.util.ArrayList;
                            // No segment files, that's OK
            return segmentInfos.getSegmentsFileName();
import org.opensearch.core.index.shard.ShardId;
            // Write non-segment files with codec headers and footers
            this.subdirectoryPaths = List.of(subdirectoryPath);
        assertEquals(stats.getSizeInBytes(), length + initialStoreSize);
            StoreFileMetadata file1Meta = metadata.get("subdir/metadata_file1.dat");
    }
        }
            // Verify file metadata properties
        }
                    break;
                    // Load metadata
            }
                String subdirName = subdirectoryNames.get(i);
     * Helper method to write a test file with proper Lucene codec header and footer
            Path subdirPath = setup.path.resolve("subdir");
import org.apache.lucene.store.FSDirectory;
        assertEquals(reservedBytes, stats.getReservedSize().getBytes());
            assertEquals("Should have no duplicate entries", fileNames.size(), fileNames.stream().distinct().count());
            // Load metadata
            assertTrue("File length should be greater than 0", file2Meta.length() > 0);
            // Create mock IndexCommit that includes subdirectory files
            } catch (NoSuchFileException | FileNotFoundException e) {
                            for (String fileName : segmentInfos.files(true)) {
        }
            return allFiles;
            TestIndexCommit testCommit = new TestIndexCommit(segmentInfos, store.directory(), subdirPath, "subdir");
            }
                                allFiles.add(subdirName + "/" + fileName);
 */
import org.apache.lucene.index.IndexWriterConfig;
                }
        }
        Settings settings = Settings.builder()
import org.opensearch.plugins.IndexStorePlugin;
        }
import org.opensearch.index.store.StoreStats;
/*
                // Get the committed SegmentInfos from the directory
            }
        try {
            Files.createDirectories(subdirPath);
            return false;
        private final SegmentInfos segmentInfos;
            .build();
                && !fileName.endsWith(".cfe")
            assertTrue("Metadata should contain subdir/metadata_file1.dat", metadata.contains("subdir/metadata_file1.dat"));
            length = output.getFilePointer();
            } catch (IOException e) {
    /**
import org.opensearch.test.OpenSearchTestCase;
            output.writeLong(System.currentTimeMillis());
            SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(store.directory());
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
            Store.OnClose.EMPTY,
         * Returns true if the file is a custom metadata file (not a Lucene internal file or test infrastructure file)
        StoreStats stats = store.stats(reservedBytes);
                            SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(directory);
            }
        try (IndexOutput output = dir.createOutput(fileName, IOContext.DEFAULT)) {
        stats.add(null);
        public void delete() {
        }
        );
        assertEquals(Math.max(reservedBytes, 0L) + Math.max(otherStatsReservedBytes, 0L), stats.getReservedSize().getBytes());
        TestStoreSetup(SubdirectoryAwareStore store, Path path) {
import org.apache.lucene.store.IndexOutput;
            if (file.startsWith("extra") == false) {
        private final List<Path> subdirectoryPaths;
            try (Directory subdir = FSDirectory.open(subdirPath)) {
                writer.commit();
                    // Create mock IndexCommit
            .put(Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMinutes(0))
    }
            .put(Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING.getKey(), TimeValue.timeValueMinutes(0))
        }
                    // Get the committed SegmentInfos from the directory
            new ShardPath(false, path, path, shardId),
import org.opensearch.index.shard.ShardPath;
        public Collection<String> getFileNames() throws IOException {
            }
            // Get the committed SegmentInfos from the directory
        public String getSegmentsFileName() {
            return segmentInfos.getUserData();
            // Create mock IndexCommit that includes subdirectory files
                directory.deleteFile(file);
                Store.MetadataSnapshot metadata2 = store.getMetadata(testCommit2);
            // Load metadata
                            if (isCustomMetadataFile(fileName)) {
        try {
    }
    static class TestIndexCommit extends IndexCommit {
            this.directory = directory;
        @Override
                    SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(store.directory());
        for (String file : files) {
    }
    }
        final long otherStatsBytes = randomLongBetween(0L, Integer.MAX_VALUE);
                        }
                }
import java.nio.file.NoSuchFileException;
import org.opensearch.common.settings.Settings;
        TestStoreSetup setup = createTestStoreSetup();
        Path indexPath = path.resolve("index");
            try (Directory subdir = FSDirectory.open(subdirPath)) {
            assertNotNull("Checksum should not be null", file2Meta.checksum());
            Store.MetadataSnapshot metadata = store.getMetadata(testCommit);
            assertTrue("File length should be greater than 0", file1Meta.length() > 0);
import java.util.Collection;
        assertNotNull(factory);
            deleteContent(store.directory());
import java.io.FileNotFoundException;
        SubdirectoryAwareStore store = new SubdirectoryAwareStore(
        @Override
import java.util.Map;
            }
        public long getGeneration() {
        @Override
                        // Add segment files if they exist
                    assertNotNull("File metadata should exist", fileMeta);
        final ShardId shardId = new ShardId("index", "_na_", 1);
        int numNonExtra = 0;
import org.opensearch.test.IndexSettingsModule;
     */
            this.subdirectoryNames = List.of(subdirectoryName);
                writeTestFileWithCodec(subdir, "custom_metadata.dat", "custom_data");
            // Verify segment files are included
                    // Verify checksum matches
    private TestStoreSetup createTestStoreSetup() throws IOException {
        SubdirectoryAwareStore store = setup.store;
}
package org.opensearch.plugin.store.subdirectory;
                && !fileName.endsWith(".si")
                writeTestFileWithCodec(subdir, "checksum_test2.dat", "different_content");
import java.util.List;
            try (IndexWriter writer = new IndexWriter(store.directory(), new IndexWriterConfig())) {
            }
            int iters = scaledRandomIntBetween(10, 100);
        IOUtils.close(store);
        assertEquals(initialStoreSize, stats.getSize().getBytes());
    public void testGetStoreFactories() {
                    // Create main segments file
import org.opensearch.index.store.StoreFileMetadata;
                assertFalse("Different content should produce different checksums", checksum1.equals(checksum2));
                    TestIndexCommit testCommit = new TestIndexCommit(segmentInfos, store.directory(), subdirPath, "subdir");
            output.writeString(content);
            this.path = path;
            Store.MetadataSnapshot metadata = store.getMetadata(testCommit);
        SubdirectoryStorePlugin plugin = new SubdirectoryStorePlugin();
        private final Directory directory;
            StoreFileMetadata file2Meta = metadata.get("subdir/metadata_file2.dat");
                && !fileName.endsWith(".cfs")
            boolean hasSegmentFile = false;
            // Verify non-segment files are included in metadata
            IOUtils.close(store);
        assertTrue(numNonExtraFiles(store) > 0);
        Path path = createTempDir().resolve("indices").resolve(shardId.getIndex().getUUID()).resolve(String.valueOf(shardId.id()));
                        }
                    try (IndexWriter writer = new IndexWriter(store.directory(), new IndexWriterConfig())) {
            .build();
import org.opensearch.common.util.io.IOUtils;
        /**
            assertTrue("Metadata should contain subdir/metadata_file2.dat", metadata.contains("subdir/metadata_file2.dat"));
                String checksum2 = metadata2.get("subdir/checksum_test2.dat").checksum();
     * Helper class to hold test store setup data
        }
import org.opensearch.index.store.Store;
            new DummyShardLock(shardId),
            assertNotNull("File metadata should not be null", file1Meta);
        assertNotNull(factories);
        stats = store.stats(0L);
    }
import org.apache.lucene.util.BytesRef;
                // Compute expected checksum directly
                    writer.commit();
            }
            // Verify non-segment file is included
            assertNotNull("Checksum should not be null", file1Meta.checksum());
                output.writeBytes(bytesRef.bytes, bytesRef.offset, bytesRef.length);
            SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(store.directory());
            CodecUtil.writeHeader(output, "test_codec", 0);
        final String[] files = directory.listAll();
            try {
 * SPDX-License-Identifier: Apache-2.0
