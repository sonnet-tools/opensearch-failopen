            directory.close();
            assertEquals("listAll should have no duplicates", fileSet.size(), files.length);
        } finally {
            input.close();
        }
            // Verify it's in the FileCache (TieredDirectory behavior)
        directory = buildDirectoryWithParquetFormat().directory;
    // ═══════════════════════════════════════════════════════════════
        }
    // afterSyncToRemote tests
        try {
            directory.close();
    public void testFileLengthUnregisteredFormatThrowsIllegalState() throws IOException {
        }
            assertTrue(ex.getMessage().contains("csv"));
            byte[] buf = new byte[PARQUET_DATA.length];
    private ShardPath shardPath;
        }
        verify(throwingRegistry).close();
        directory = buildDirectoryNoFormats();
            w.directory.deleteFile("parquet/seg_del.parquet");
            // TieredDirectory also won't find it → expect an exception.
        WithRegistry w = buildDirectoryWithParquetFormat(throwingRegistry);
                out.writeBytes(TEST_DATA, TEST_DATA.length);
        populateData();
        return new WithRegistry(dir, nativeRegistry);
    public void testOpenInputSegmentsFileReadsFromLocalWhenNotInRemoteMetadata() throws IOException {
    public void testLuceneFileWithNoStrategyRoutesToTieredDirectory() throws IOException {
        @Override
import org.apache.lucene.store.IndexInput;
        try {
        TieredSubdirectoryAwareDirectory dir = new TieredSubdirectoryAwareDirectory(
        } finally {
        try {
            new TieredSubdirectoryAwareDirectory(
        populateMetadata();
            addParquetMetadataEntry(parquetFile, "seg_already_gone.parquet__UUID1");
                java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile))
            Path switchablePath = getFilePathSwitchable(localFsDir, luceneFile);
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {
    }
            String parquetFile = "parquet/seg_local_only.parquet";
    // ═══════════════════════════════════════════════════════════════
        final DataFormatStoreHandler storeHandler;
            addParquetMetadataEntry(parquetFile, "seg_inflight.parquet__UUID1");
        }
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
    }
package org.opensearch.storage.directory;
     * Parquet files don't have Lucene codec footers, so we can't use copyFrom.
            // Delegates to the native registry — must NOT fall through to tieredDirectory.
        // Stub getBlobContainer().path() so getRemoteBasePath(format) doesn't NPE in afterSyncToRemote tests
            fail("Expected IllegalStateException from null fileCache");
            try (IndexOutput out = directory.createOutput(parquetFile, IOContext.DEFAULT)) {
        assertEquals("native close failed", ex.getMessage());
            }
        } finally {
 * {@link StoreStrategy} whose {@link DataFormatStoreHandlerFactory} returns a Mockito-mocked
        WithRegistry w = buildDirectoryWithParquetFormat();
    }
        );
    }
     * In production, the upload path adds entries via a separate mechanism.
            fileCache,
        ShardId shardId = new ShardId(index, 0);
import static org.mockito.Mockito.verify;
    }
    private FSDirectory localFsDir;
        BlobContainer mockBlobContainer = mock(BlobContainer.class);
            directory.deleteFile(luceneFile);
    // rename() tests
            writeParquetFileToDisk(parquetFile);
    // ═══════════════════════════════════════════════════════════════
        directory = buildDirectoryWithParquetFormat().directory;
            IndexInput input = directory.openInput(parquetFile, IOContext.DEFAULT);
    // ═══════════════════════════════════════════════════════════════
        try {
    // ═══════════════════════════════════════════════════════════════
                out.writeBytes(TEST_DATA, TEST_DATA.length);
        directory = buildDirectoryWithParquetFormat().directory;
import org.opensearch.common.blobstore.BlobContainer;
            // segments_99 doesn't exist locally or in remote metadata.
            String luceneFile = "_0_del.cfe";
            directory.close();
            directory.close();
            String parquetFile = "parquet/seg_already_gone.parquet";
import java.nio.file.NoSuchFileException;
    // ═══════════════════════════════════════════════════════════════
        populateData();
        populateData();
        }
        directory = buildDirectoryWithParquetFormat().directory;
        }
    public void testOpenInputSegmentsFileFallsToTieredDirectoryWhenNotLocal() throws IOException {
        @Override
        try {
            getMockPrefetchSettingsSupplier()
            }
        directory = buildDirectoryWithParquetFormat().directory;
import org.opensearch.repositories.NativeStoreRepository;
            this.directory = directory;
        // returns "test-base-path/parquet/" (mock BlobPath includes format subdirectory),
    }
import org.apache.lucene.store.FSDirectory;
    public void testCreateOutputFormatFileRoutesToSubdirectoryAwareDirectory() throws IOException {
    }
            remoteSegmentStoreDirectory,
            // which creates parent directories automatically.
        } catch (IllegalStateException e) {
    }
            expectThrows(Exception.class, () -> directory.openInput("segments_99", IOContext.DEFAULT));
        } finally {
            assertFalse(java.nio.file.Files.exists(shardPath.getDataPath().resolve(recoveryFile)));
                (java.util.concurrent.ConcurrentHashMap<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata>) field.get(
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, 1);
            // segments_N that IS in remote metadata should NOT take the local fallback path.
        org.mockito.Mockito.doThrow(new IOException("native close failed")).when(throwingRegistry).close();
    public void testOpenInputSegmentsFileInRemoteMetadataRoutesToTieredDirectory() throws IOException {
    // ═══════════════════════════════════════════════════════════════
import java.nio.file.Path;
            directory.close();
            expectThrows(Exception.class, () -> directory.openInput("parquet/seg.parquet", IOContext.DEFAULT));
        }
            assertNotNull("Lucene file should be cached in FileCache after createOutput", fileCache.get(switchablePath));
    public void testAfterSyncToRemoteFormatFileNoopWhenNotRemoteSyncAware() throws IOException {
        directory = buildDirectoryNoFormats();
        populateData();
        directory = buildDirectoryNoFormats();
            IndexInput input = w.directory.openInput(parquetFile, IOContext.DEFAULT);
        DataFormatStoreHandler throwingRegistry = mock(DataFormatStoreHandler.class);
        populateData();
    public void testOpenInputRoutesToLocalWhenNotInRemoteMetadata() throws IOException {
        }
        directory = buildDirectoryNoFormats();
            w.directory.afterSyncToRemote(parquetFile);
            }
        try {
 */
    // afterSyncToRemote() — null blobKey test
            true,
    }
        } finally {
        try {
            fileCache,
    }
            String[] files = directory.listAll();
            directory.close();
            // sync should not throw even with non-existent files — it's a no-op on warm
    }
            writeParquetFileToDisk("parquet/seg_list.parquet");
            IndexInput input = directory.openInput(parquetFile, IOContext.DEFAULT);
 *
        } finally {
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {
            String luceneFile = "_0_len.cfe";
    }
            Set<String> afterDelete = new HashSet<>(Arrays.asList(directory.listAll()));
                threadPool,
    // ═══════════════════════════════════════════════════════════════
            String parquetFile = "parquet/seg_rename.parquet";
            String recoveryFile = "parquet/recovery.abc123.seg_0.parquet";
            try (IndexOutput out = directory.createOutput("_0_dup_b.cfe", IOContext.DEFAULT)) {
        } finally {
            assertArrayEquals("Written content should match", PARQUET_DATA, content);
            assertFalse(
        }
        try {
        directory = buildDirectoryWithParquetFormat().directory;
            assertTrue(ex.getMessage().contains("csv"));
                registry,
            org.mockito.ArgumentMatchers.eq(expectedUploadKey),
    private static final class WithRegistry {
    }
            w.directory.afterSyncToRemote(parquetFile);
import org.opensearch.index.store.SubdirectoryAwareDirectory;
        TestParquetStrategy(DataFormatStoreHandlerFactory factory) {
    public void testAfterSyncToRemotePassesCorrectFormatToGetRemoteBasePath() throws IOException {
            org.mockito.ArgumentMatchers.any(),
    // Routing tests — openInput
                out.writeBytes(TEST_DATA, TEST_DATA.length);
        w.directory.afterSyncToRemote(parquetFile);
            String expectedDelKey = shardPath.getDataPath().resolve("parquet/seg_del.parquet").toString();
            w.directory.close();
            directory.afterSyncToRemote(parquetFile);
            w.directory.close();
            w.directory.close();
                out.writeBytes(TEST_DATA, TEST_DATA.length);
            // Original gone, new name exists
            // File exists locally but not in remote metadata — should be readable from local.
        } finally {
import java.util.Arrays;
    public void testAfterSyncToRemoteSwitchesInFlightReader() throws IOException {
            );
    }
            String parquetFile = "parquet/seg_inflight.parquet";
            addParquetMetadataEntry(segmentsFile, "segments_2__UUID1");
            TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
            // Rename should succeed — routes through SubdirectoryAwareDirectory for recovery support
                ((org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper) input).unwrap();
     * verify calls routed to the registry.
        }
        directory = buildDirectoryNoFormats();
        }
        populateData();
        directory = buildDirectoryWithParquetFormat().directory;
    // ═══════════════════════════════════════════════════════════════
    /**
            }
        try {
        // remotePath builds: basePath + blobKey. basePath from getRemoteBasePath("parquet")
        WithRegistry w = buildDirectoryWithParquetFormat();
 * this file be licensed under the Apache-2.0 license or a
            shardPath,
    // Constructor resource leak safety
            org.opensearch.storage.indexinput.FormatSwitchableIndexInput switchable =
            assertTrue(ex.getMessage().contains("No StoreStrategy"));
            String parquetFile = "parquet/seg_create_output.parquet";
        return buildDirectoryWithParquetFormat(mock(DataFormatStoreHandler.class));
    }
        } finally {
    }
        subdirAware = new SubdirectoryAwareDirectory(localFsDir, shardPath);
        directory = buildDirectoryWithParquetFormat().directory;
        directory = buildDirectoryWithParquetFormat().directory;
            // Lucene files should still go through TieredDirectory (FileCache integration)
    // ═══════════════════════════════════════════════════════════════
    }
    }
    // ═══════════════════════════════════════════════════════════════
 * Functional tests for {@link TieredSubdirectoryAwareDirectory} exercising real I/O
    // createOutput tests
            input.close();
            // Open input while file is local (not yet synced)
    }
        String parquetFile = "parquet/seg_format_path.parquet";
    // IOUtils.close — partial close safety
        Path fullPath = shardPath.getDataPath().resolve(relativePath);
    }
            directory.close();
            directory.rename("pending_segments_1", "segments_1");
            String[] files = directory.listAll();
            w.directory.close();
    }
            // Sync — the switch cascades to clones internally (tested in FormatSwitchableIndexInputTests)
        public java.util.Set<org.opensearch.index.engine.dataformat.FieldTypeCapabilities> supportedFields() {
    }
            assertTrue("listAll should contain Lucene file", fileSet.contains("_0_list.cfe"));
    // ═══════════════════════════════════════════════════════════════
        );
    private static final class TestParquetStrategy extends StoreStrategy {
        DataFormatStoreHandlerFactory factory = (sid, warm, repo, cacheRegistry) -> nativeRegistry;
                ((org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper) input).unwrap();
        } finally {
import org.opensearch.common.blobstore.BlobPath;
            directory.close();
        } finally {
import org.opensearch.core.index.Index;
    private static final byte[] PARQUET_DATA = "parquet-payload".getBytes(StandardCharsets.UTF_8);
        public Optional<DataFormatStoreHandlerFactory> storeHandler() {
        }
        verify(w.storeHandler).onUploaded(
    // ═══════════════════════════════════════════════════════════════
            String[] files = directory.listAll();
            w.directory.afterSyncToRemote(parquetFile);
        } finally {
            // The switchable should now be on remote
        DataFormatStoreHandler nativeRegistry = mock(DataFormatStoreHandler.class);
    // ═══════════════════════════════════════════════════════════════
            String parquetFile = "parquet/seg_remote_nowrap.parquet";
            }
                out.writeBytes(PARQUET_DATA, PARQUET_DATA.length);
        }
        try {
                out.writeBytes(TEST_DATA, TEST_DATA.length);
            // Since it's in remote metadata, getExistingRemoteFilename != null → skips local fallback.
        } finally {
            long length = directory.fileLength(luceneFile);
            RemoteSegmentStoreDirectory.UploadedSegmentMetadata metadata = RemoteSegmentStoreDirectory.UploadedSegmentMetadata.fromString(
            long length = directory.fileLength(luceneFile);
import org.opensearch.index.engine.dataformat.DataFormat;
            org.mockito.ArgumentMatchers.anyLong()
        } finally {
            directory.close();
        directory = buildDirectoryWithParquetFormat().directory;
        try {
        try {
        try {
    public void testDeleteFileFormatRoutesToNativeRegistry() throws IOException {
            // → getExistingRemoteFilename returns null → should throw
            Set<String> beforeDelete = new HashSet<>(Arrays.asList(directory.listAll()));
import java.util.Map;
            // Verify the file was written to disk via SubdirectoryAwareDirectory path resolution
import org.opensearch.index.engine.dataformat.StoreStrategy;
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {
        public long priority() {
        }
    // listAll tests
            writeParquetFileToDisk(parquetFile);
    public void testRenameLuceneFileDelegatesToTieredDirectory() throws IOException {
            String parquetFile = "parquet/seg_switchable.parquet";
    public void setup() throws IOException {
        directory = buildDirectoryWithParquetFormat().directory;
    // ═══════════════════════════════════════════════════════════════
        try {
            Integer refCount = fileCache.getRef(switchablePath);
        }
                assertArrayEquals("Should read local segments file data", TEST_DATA, buf);
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
            // File exists locally but NOT in remote metadata → should read from local
            when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);
            // This would fail without SubdirectoryAwareDirectory creating parent dirs
        }
        Files.createDirectories(fullPath.getParent());
        try {
    private TieredSubdirectoryAwareDirectory directory;
                "Local file should be deleted after sync to remote",
            );
    // Local-to-remote routing and afterSyncToRemote local delete tests
        );
    // ═══════════════════════════════════════════════════════════════
        }
        verify(w.storeHandler).close();
            return "parquet";
                null, // null fileCache → triggers IllegalStateException in CompositeDirectory
    }
        }
            remoteSegmentStoreDirectory,
            }
                assertNotNull("openInput should return non-null for Lucene file", in);
            addParquetMetadataEntry(parquetFile, "seg_no_reader.parquet__UUID1");
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {
            }
        }
    }
        WithRegistry w = buildDirectoryWithParquetFormat();
 * {@code close} calls. Lucene files skip the strategy lookup entirely.
            assertTrue(ex.getMessage().contains("parquet/unknown.parquet"));
            Path switchablePath = getFilePathSwitchable(localFsDir, luceneFile);
        // failure path so no native resources leak.
            for (String f : files) {
        WithRegistry w = buildDirectoryWithParquetFormat();
            directory.close();
            directory.close();
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");
import org.opensearch.core.index.shard.ShardId;
            // Use a nested subdirectory path to verify parent dir creation
    public void testOpenInputUnregisteredFormatThrowsIllegalState() throws IOException {
            shardPath,
            // Verify file exists locally
            }
    private TieredSubdirectoryAwareDirectory buildDirectoryNoFormats() {
            String luceneFile = "_0_sync.cfe";
        );
    }
            }
            String parquetFile = "parquet/nested/seg_nested.parquet";
        } finally {
            assertNotNull("Lucene file should be in FileCache after createOutput", fileCache.get(switchablePath));
            return settings;
        }
import static org.opensearch.storage.utils.DirectoryUtils.getFilePathSwitchable;
            registry,
        }
            directory.close();
        } finally {
            fileCache.decRef(switchablePath);
        try {
        directory = buildDirectoryNoFormats();
            directory.close();
                localFilename + "::" + uploadedFilename + "::checksum123::100::" + org.apache.lucene.util.Version.LATEST.major
            String parquetFile = "parquet/seg_nosync.parquet";
            String segmentsFile = "segments_5";
            try (IndexOutput out = directory.createOutput("_0_list.cfe", IOContext.DEFAULT)) {
            try (IndexOutput out = directory.createOutput("_0_dup_a.cfe", IOContext.DEFAULT)) {
        // so the path should be "test-base-path/parquet/seg_format_path.parquet__UUID1"
            }
        } finally {
        }
            // The local read throws NoSuchFileException, then falls through to TieredDirectory.
    }
    public void testOpenInputLuceneFileRoutesToTieredDirectory() throws IOException {
        WithRegistry w = buildDirectoryWithParquetFormat();
        }
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        try {
            map.put(localFilename, metadata);
            long len = directory.fileLength(parquetFile);
        }
            // Write a file, then rename it (simulates Lucene commit: pending_segments → segments)
            org.mockito.ArgumentMatchers.eq("test-base-path/parquet/seg_format_path.parquet__UUID1"),
import org.opensearch.common.SuppressForbidden;
            );
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        } finally {
            fileCache.decRef(switchablePath);
     * file registry is a mock. Returns both the directory and the mock so tests can
        }
            }
            java.lang.reflect.Field field = RemoteSegmentStoreDirectory.class.getDeclaredField("segmentsUploadedToRemoteStore");
    public void testListAllWithEmptyFormatDirectories() throws IOException {
            String parquetFile = "parquet/seg_create.parquet";
            assertTrue("Should be switched to remote after afterSyncToRemote", switchable.hasSwitchedToRemote());
        w.directory.close();
            writeParquetFileToDisk(recoveryFile);
    /**
        } finally {
    // ═══════════════════════════════════════════════════════════════
            w.directory.close();
            assertNotNull("File should be in FileCache before afterSyncToRemote", fileCache.get(switchablePath));
            assertTrue(java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile)));
            assertFalse("Should start on local", switchable.hasSwitchedToRemote());
            input.close();
            }
            // File NOT in remote metadata → openInput takes local path → wraps in FormatSwitchableIndexInput
        remoteSegmentStoreDirectory.init();
        verify(w.storeHandler).onUploaded(
        Files.createDirectories(shardDataPath.resolve("index"));
        WithRegistry w = buildDirectoryWithParquetFormat();
            expectThrows(Exception.class, () -> directory.fileLength("parquet/seg_len.parquet"));
        }
        StoreStrategy parquet = new TestParquetStrategy(factory);
    }
        }
            assertTrue(java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile)));
public class TieredSubdirectoryAwareDirectoryTests extends TieredStorageBaseTestCase {
    public void testCloseClosesNativeRegistryAndTieredDirectory() throws IOException {
            shardPath,
        // The registry (and its native registries) must have been closed by the constructor's
            org.mockito.ArgumentMatchers.eq(expectedUploadKey),
        }
        populateData();
            );
            writeParquetFileToDisk(parquetFile);
        populateData();
    }
    }
        try {
    public void testListAllIncludesLuceneFiles() throws IOException {
        } finally {
        public String name() {
                subdirAware,
 * {@link DataFormatStoreHandler} — the mock verifies {@code onUploaded} / {@code onRemoved} /
            IllegalStateException ex = expectThrows(IllegalStateException.class, () -> directory.afterSyncToRemote("csv/data.csv"));
            assertFalse(switchable.hasSwitchedToRemote());
                );
    public void testCloseWithThrowingNativeRegistryStillClosesTieredDirectory() throws IOException {
            byte[] content = Files.readAllBytes(expectedPath);
        } finally {
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
    public void testFileLengthLuceneFile() throws IOException {
            String finalFile = "parquet/seg_0.parquet";
            Path switchablePath = getFilePathSwitchable(localFsDir, luceneFile);
    // ═══════════════════════════════════════════════════════════════
                IllegalStateException.class,
        WithRegistry w = buildDirectoryWithParquetFormat();
    public void testCreateOutputLuceneFile() throws IOException {
            addParquetMetadataEntry(parquetFile, "seg_remote_nowrap.parquet__UUID1");
            assertTrue(ex.getMessage().contains("csv"));
        }
        WithRegistry(TieredSubdirectoryAwareDirectory directory, DataFormatStoreHandler storeHandler) {
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");
        directory = buildDirectoryWithParquetFormat().directory;
        } finally {
        } finally {
        }
import java.io.IOException;
        }
        try {
            assertNotNull(input);
            w.directory.close();
    // Routing tests — fileLength
    }
            remoteSegmentStoreDirectory,
        try {
import java.nio.file.Files;
            }
    public void testCreateOutputFormatFileCreatesParentDirectories() throws IOException {
    public void testListAllSortedAndDeduplicates() throws IOException {
                assertFalse("No parquet files should appear without format dirs", f.startsWith("parquet/"));
                out.writeBytes(PARQUET_DATA, PARQUET_DATA.length);
        try {
                out.writeBytes(TEST_DATA, TEST_DATA.length);
        populateData();
            IndexInput input = w.directory.openInput(parquetFile, IOContext.DEFAULT);
            try (IndexOutput out = directory.createOutput(parquetFile, IOContext.DEFAULT)) {
        verify(nativeRegistry).close();
        Files.write(fullPath, PARQUET_DATA);
            String segmentsFile = "segments_2";
            assertTrue(java.nio.file.Files.exists(shardPath.getDataPath().resolve(finalFile)));
            }
            // Verify renamed file exists
        }
            remoteSegmentStoreDirectory,
            assertTrue(java.nio.file.Files.exists(shardPath.getDataPath().resolve("parquet/seg_renamed.parquet")));
                out.writeBytes(TEST_DATA, TEST_DATA.length);
    }
            try (IndexInput in = directory.openInput(luceneFile, IOContext.DEFAULT)) {
        populateData();
    // ═══════════════════════════════════════════════════════════════
        }
    // FormatSwitchableIndexInput integration tests
            String parquetFile = "parquet/seg_clone_switch.parquet";
    // ═══════════════════════════════════════════════════════════════
            // Local file should be deleted
            fileCache.decRef(switchablePath);
        directory = buildDirectoryWithParquetFormat().directory;
    public void testAfterSyncToRemoteNoErrorWhenLocalAlreadyGone() throws IOException {
    // openInput — segments_N local fallback tests
        try {
            }
            String luceneFile = "_0_create_lucene.cfe";
        try {
        } finally {
        try {
            assertTrue("File should exist before delete", beforeDelete.contains(luceneFile));
    // ═══════════════════════════════════════════════════════════════
/*
        populateData();
            assertTrue("Nested format file should exist after createOutput", Files.exists(expectedPath));
    public void testRenameFormatFileRoutesToSubdirectoryAware() throws IOException {
            writeParquetFileToDisk(parquetFile);
    // IllegalStateException guard tests (no matching strategy)
 * compatible open source license.
            true,
    }
        try {
            directory.close();
                assertArrayEquals("Data read back should match data written", TEST_DATA, buf);
    // ═══════════════════════════════════════════════════════════════
            addParquetMetadataEntry(parquetFile, "seg_delete_local.parquet__UUID1");
        } finally {
            // Should not throw — catches NoSuchFileException silently
        try {
        } finally {
        populateData();
            // We'll use a segments file that's in remote metadata by adding it.
            assertTrue(Arrays.asList(directory.listAll()).contains("segments_1"));
        WithRegistry w = buildDirectoryWithParquetFormat();
        directory = buildDirectoryWithParquetFormat().directory;
import org.opensearch.index.store.RemoteDirectory;
    @Before
        populateData();
        localFsDir = FSDirectory.open(shardPath.resolveIndex());
        directory = buildDirectoryWithParquetFormat().directory;
        } finally {
            when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
            directory.sync(java.util.List.of("_0.cfe", "parquet/seg_0.parquet", "nonexistent.file"));
            }
            Path switchablePath = getFilePathSwitchable(localFsDir, luceneFile);
import java.util.function.Supplier;
        try {
            switchable.readBytes(buf, 0, buf.length);
                () -> directory.openInput("csv/data.csv", IOContext.DEFAULT)
import java.nio.charset.StandardCharsets;
    // createOutput — format file routing tests
        String expectedUploadKey = shardPath.getDataPath().resolve(parquetFile).toString();
            String luceneFile = "_0_test.cfe";
        try {
 * The OpenSearch Contributors require contributions made to
            );
        } finally {
            // "parquet/unknown.parquet" is a format file but has no remote metadata entry
    public void testAfterSyncToRemoteUnregisteredFormatThrowsIllegalState() throws IOException {
        } finally {
            assertTrue(ex.getMessage().contains("csv"));
                    remoteSegmentStoreDirectory
                IllegalStateException.class,
    private FileCache fileCache;
        } catch (Exception e) {
        } finally {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    private void writeParquetFileToDisk(String relativePath) throws IOException {
        directory = buildDirectoryWithParquetFormat().directory;
            try (IndexInput in = directory.openInput(segmentsFile, IOContext.DEFAULT)) {
    }
    public void testOpenInputRoutesToRemoteWhenInRemoteMetadata() throws IOException {
                shardPath,
            // Local file should be gone
    // ═══════════════════════════════════════════════════════════════
import org.junit.Before;
            // No openInput call — no FormatSwitchableIndexInput tracked
        }
        w.directory.afterSyncToRemote(parquetFile);
        } finally {
        WithRegistry w = buildDirectoryWithParquetFormat();
        } finally {
            null
            directory.close();
 */
        when(((RemoteDirectory) remoteDataDirectory).getBlobContainer()).thenReturn(mockBlobContainer);
            w.directory.close();
            IllegalStateException ex = expectThrows(
        };
    // ═══════════════════════════════════════════════════════════════
            directory.close();
    }
        } finally {
            IndexInput input = directory.openInput(parquetFile, IOContext.DEFAULT);
            assertTrue(
    public void testAfterSyncToRemoteWithNoOpenInputStillDeletesLocal() throws IOException {
            // The remote metadata from populateMetadata() includes standard Lucene files.
    public void testAfterSyncToRemoteFormatFileWithoutRemoteSyncAware() throws IOException {
        addParquetMetadataEntry(parquetFile, "seg_format_path.parquet__UUID1");
        }
            org.opensearch.storage.indexinput.FormatSwitchableIndexInput switchable =
    private WithRegistry buildDirectoryWithParquetFormat() {
    private void addParquetMetadataEntry(String localFilename, String uploadedFilename) {
            // Write a segments_N file locally (simulates a restart where local generation differs from remote)
        final TieredSubdirectoryAwareDirectory directory;
        populateData();
            try (IndexOutput out = directory.createOutput("_0_noclose.cfe", IOContext.DEFAULT)) {
    public void testDeleteFileLuceneRoutesToTieredDirectory() throws IOException {
    private static final byte[] TEST_DATA = "hello-tiered".getBytes(StandardCharsets.UTF_8);
        }
            try (IndexOutput out = directory.createOutput("_0_only.cfe", IOContext.DEFAULT)) {
    public void testOpenInputLocalFormatFileReturnsFormatSwitchable() throws IOException {
            IllegalStateException ex = expectThrows(
        when(mockBlobContainer.path()).thenReturn(new BlobPath().add("test-base-path").add("parquet"));
            directory.close();
                in.readBytes(buf, 0, buf.length);
        try {
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
    // Edge case tests
                out.writeBytes(TEST_DATA, TEST_DATA.length);
    }
        WithRegistry w = buildDirectoryWithParquetFormat();
            w.directory.afterSyncToRemote(parquetFile);
            addParquetMetadataEntry(parquetFile, "seg_remote.parquet__UUID1");
    public void testListAllReturnsLuceneAndFormatFiles() throws IOException {
        populateData();
            java.util.concurrent.ConcurrentHashMap<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata> map =
            Set<String> fileSet = new HashSet<>(Arrays.asList(files));
            subdirAware,
            // segments_5 is NOT in remote metadata → should read from local disk
    }
            }
    }
            assertTrue(input instanceof org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper);
        @Override
            writeParquetFileToDisk(parquetFile);
            assertTrue(ex.getMessage().contains("no remote filename"));
            // File is in remote metadata → should route to remote directory
    // ═══════════════════════════════════════════════════════════════
        try {
        populateData();
        } finally {
        }
            // Simulate sync: add remote metadata entry
            }
        try {
            // Don't write file to disk — it's already gone
            String luceneFile = "_0_guard.cfe";
            directory.close();
    /** Writes a parquet file directly to disk (simulating the Rust writer). */
            IndexInput input = w.directory.openInput(parquetFile, IOContext.DEFAULT);
            directory.close();
        try {
            String parquetFile = "parquet/seg_noop.parquet";
        Index index = new Index("test-index", "test-uuid");
            subdirAware,
        return new TieredSubdirectoryAwareDirectory(
    }
        populateData();
            org.mockito.ArgumentMatchers.anyLong()
        );
        directory = buildDirectoryWithParquetFormat().directory;
    // ═══════════════════════════════════════════════════════════════
 * SPDX-License-Identifier: Apache-2.0
            addParquetMetadataEntry(parquetFile, "seg_noop.parquet__UUID3");
            NativeStoreRepository.EMPTY,
        try {
        try {
            writeParquetFileToDisk(parquetFile);
            // Simulate recovery: write with recovery prefix, then rename to final name
import static org.mockito.Mockito.mock;
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {
    }
        String parquetFile = "parquet/seg_sync.parquet";
            fileCache.decRef(switchablePath);
        IOException ex = expectThrows(IOException.class, w.directory::close);
            w.directory.close();
            assertTrue("Lucene file should exist on local disk", Arrays.asList(localFsDir.listAll()).contains(luceneFile));
        try {
        Files.createDirectories(shardStatePath);
    private WithRegistry buildDirectoryWithParquetFormat(DataFormatStoreHandler nativeRegistry) {
        }
            // Our mock remote has no parquet files, so this throws.
    // sync() tests
            directory.close();
    }
    }
        try {
            this.storeHandler = storeHandler;
            threadPool,
     * Builds a TieredSubdirectoryAwareDirectory with no strategies (Lucene-only).
    public void testFileLengthNonExistentFile() throws IOException {
            w.directory.close();
    }
            // Now simulate sync: add remote metadata and call afterSyncToRemote
            // Open input and clone it
        } finally {
            expectThrows(NoSuchFileException.class, () -> directory.openInput("non_existent_file.cfe", IOContext.DEFAULT));
            assertTrue("Format file should exist on disk after createOutput", Files.exists(expectedPath));
        }
            Path expectedPath = shardPath.getDataPath().resolve(parquetFile);
    }
        directory = buildDirectoryWithParquetFormat().directory;
            null
        WithRegistry w = buildDirectoryWithParquetFormat();
            directory.afterSyncToRemote(luceneFile);
import static org.mockito.Mockito.when;
        directory = buildDirectoryNoFormats();
        StoreStrategy parquet = new TestParquetStrategy(factory);
            assertNotNull("Lucene file should be in FileCache via TieredDirectory", fileCache.get(switchablePath));
        populateData();
        directory = buildDirectoryWithParquetFormat().directory;
            assertFalse(
        populateData();
    private static final DataFormat PARQUET_FORMAT = new DataFormat() {
                assertTrue("listAll should return sorted results", files[i - 1].compareTo(files[i]) <= 0);
    }
            StoreStrategyRegistry.EMPTY,
            }
            try (IndexOutput out = directory.createOutput("pending_segments_1", IOContext.DEFAULT)) {
    // ═══════════════════════════════════════════════════════════════
    }
            writeParquetFileToDisk(parquetFile);
            directory.close();
            directory.close();
        populateData();
        WithRegistry w = buildDirectoryWithParquetFormat();
    }
            assertTrue("Original should be switched", switchable.hasSwitchedToRemote());
            );
            String parquetFile = "parquet/seg_no_reader.parquet";
        String expectedUploadKey = shardPath.getDataPath().resolve(parquetFile).toString();
            assertArrayEquals("Should read local data before sync", PARQUET_DATA, buf);
            // This is the translog bump edge case: file created locally, not yet synced.
import org.apache.lucene.store.IndexOutput;
            input.close();
            when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
                out.writeBytes(TEST_DATA, TEST_DATA.length);
        }
            directory.close();
    @SuppressWarnings("unchecked")
            String parquetFile = "parquet/seg_remote.parquet";
                out.writeBytes(TEST_DATA, TEST_DATA.length);
}
    public void testAfterSyncToRemoteFormatFileRoutesToNativeRegistry() throws IOException {
    }
        directory = buildDirectoryWithParquetFormat().directory;
                byte[] buf = new byte[TEST_DATA.length];
        return () -> {
                () -> w.directory.afterSyncToRemote("parquet/unknown.parquet")
            w.directory.rename(parquetFile, "parquet/seg_renamed.parquet");
        populateData();
 * <p>Format routing is verified via a real {@link StoreStrategyRegistry} built from a
        directory = buildDirectoryWithParquetFormat().directory;
    public void testFormatFileWrittenToDiskNotAccessibleViaRemote() throws IOException {
                "Remote format file should NOT be wrapped in FormatSwitchableIndexInput",
            this.factory = factory;
    }
     */
     * Directly adds a parquet file entry to the remote metadata map.
            verify(w.storeHandler).onRemoved(expectedDelKey);
    /**
        populateData();
            assertFalse("Local file should be deleted", java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile)));
            assertFalse(
        private final DataFormatStoreHandlerFactory factory;
            shardPath,
                input instanceof org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper
            return 2;
                java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile))
 *
import org.opensearch.index.engine.dataformat.DataFormatStoreHandler;
        }
        }
    private SubdirectoryAwareDirectory subdirAware;
        populateData();
            Map.of(PARQUET_FORMAT, parquet),
import org.apache.lucene.store.IOContext;
            input.close();
            String[] files = directory.listAll();
            expectThrows(Exception.class, () -> directory.fileLength("non_existent_file.cfe"));
        try {
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {
        }
    // ═══════════════════════════════════════════════════════════════
            directory.close();
            try (IndexInput in = directory.openInput(segmentsFile, IOContext.DEFAULT)) {
        try {
        shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);
import org.opensearch.index.shard.ShardPath;
        } finally {
            return java.util.Set.of();
            // Goes to tieredDirectory.openInput which reads from remote via FileCache.
    }
                assertNotNull("Should read segments file from TieredDirectory when in remote metadata", in);
            }
    // listAll() tests
        try {
            Path expectedPath = shardPath.getDataPath().resolve(parquetFile);
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
        try {
            for (int i = 1; i < files.length; i++) {
    }
        directory = buildDirectoryNoFormats();
    public void testSyncIsNoOp() throws IOException {
            assertFalse("File should be gone after delete", afterDelete.contains(luceneFile));
            assertTrue(input instanceof org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper);
            assertTrue("Local format file should have non-zero length", len > 0);
                byte[] buf = new byte[TEST_DATA.length];
        directory = buildDirectoryWithParquetFormat().directory;
    }
        }
        setupRemoteSegmentStoreDirectory();
    public void testAfterSyncToRemoteLuceneFile() throws IOException {
            w.directory.afterSyncToRemote(parquetFile);
            // Expected
            getMockPrefetchSettingsSupplier()
     * Builds a TieredSubdirectoryAwareDirectory with a parquet strategy whose native
    }
            // It should go through TieredDirectory (the normal Lucene file path).
        try {
            threadPool,
            // afterSyncToRemote should register as REMOTE and delete local copy
            // Should contain Lucene files from remote metadata (populated in setup)
                assertNotNull("openInput should return non-null for local segments file", in);
    public void testOpenInputRemoteFormatFileDoesNotWrapInSwitchable() throws IOException {
    }
        );
            directory.close();
            addParquetMetadataEntry(parquetFile, "seg_clone_switch.parquet__UUID1");
        } finally {
            w.directory.close();
        directory = buildDirectoryWithParquetFormat().directory;
    // ═══════════════════════════════════════════════════════════════
            // createOutput for format files should route through SubdirectoryAwareDirectory
                in.readBytes(buf, 0, buf.length);
/**
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {
            // File IS in remote metadata → openInput routes directly to remote, no switchable wrapper
        @Override
            field.setAccessible(true);
    }
            assertFalse(java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile)));
                "Local file should be deleted even without open readers",
        // In production, getRemoteBasePath("parquet") returns a path that includes the format subdirectory
    // ═══════════════════════════════════════════════════════════════
    // deleteFile tests
        }
    }
        }
        } finally {
            w.directory.rename(recoveryFile, finalFile);
    // ═══════════════════════════════════════════════════════════════
    public void testRenameRecoveryPrefixedFormatFile() throws IOException {
            return Optional.of(factory);
    public void testOpenInputFormatFileRoutesToRemoteDirectory() throws IOException {
        } finally {
            );
            // Read some bytes from local
            // On read-only warm, openInput for format files goes to remoteDirectory.
            // Local file should still be deleted
    }
                out.writeBytes(TEST_DATA, TEST_DATA.length);
                getMockPrefetchSettingsSupplier()
        } finally {
     */
        try {
            }
            addParquetMetadataEntry(parquetFile, "seg_nosync.parquet__UUID2");
            assertTrue("Ref count should be 0 or null after afterSyncToRemote", refCount == null || refCount == 0);
    };
            NativeStoreRepository.EMPTY,
            assertNotNull(input);
    public void testConstructorFailureClosesStrategyRegistry() throws IOException {
    @SuppressForbidden(reason = "test needs reflection to inject parquet metadata without full upload pipeline")
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
                "Local format file should be wrapped in FormatSwitchableIndexInput",
    public void testCloseDoesNotDoubleCloseSharedSubdirectoryAwareDirectory() throws IOException {
        addParquetMetadataEntry(parquetFile, "seg_sync.parquet__UUID1");
            String luceneFile = "_0_create.cfe";
        } finally {
        try {
            Set<String> fileSet = new HashSet<>(Arrays.asList(files));
 * through the full directory stack (FSDirectory → SubdirectoryAwareDirectory → TieredDirectory).
        populateData();
                out.writeBytes(TEST_DATA, TEST_DATA.length);
            IllegalStateException ex = expectThrows(IllegalStateException.class, () -> directory.deleteFile("csv/data.csv"));
                out.writeBytes(TEST_DATA, TEST_DATA.length);
    // ═══════════════════════════════════════════════════════════════
            directory.close();
            Set<String> fileSet = new HashSet<>(Arrays.asList(files));
            directory.close();
    }
            directory.afterSyncToRemote(parquetFile);
        }
        directory = buildDirectoryNoFormats();
import org.opensearch.index.store.remote.filecache.FileCache;
            input.close();
            assertTrue("Local format file should have non-zero length", input.length() > 0);
            IllegalStateException ex = expectThrows(IllegalStateException.class, () -> directory.fileLength("csv/data.csv"));
            directory.close();
            try (IndexOutput out = subdirAware.createOutput(segmentsFile, IOContext.DEFAULT)) {
            directory.close();
import java.util.Optional;
    public void testDeleteFileUnregisteredFormatThrowsIllegalState() throws IOException {
            directory.close();
    private Supplier<TieredStoragePrefetchSettings> getMockPrefetchSettingsSupplier() {
    public void testCreateOutputLuceneFileStillRoutesToTieredDirectory() throws IOException {
            String parquetFile = "parquet/seg_delete_local.parquet";
            );
            // (remote directory is mocked, so this verifies routing not actual read)
        directory = buildDirectoryWithParquetFormat().directory;
        try {
            writeParquetFileToDisk(parquetFile);
import java.util.HashSet;
            directory.close();
import org.opensearch.index.engine.dataformat.DataFormatStoreHandlerFactory;
                input instanceof org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper
            throw new RuntimeException("Failed to add parquet metadata entry", e);
            assertTrue("Should contain _0.si", Arrays.asList(files).contains("_0.si"));
            assertTrue("listAll should contain Lucene file", fileSet.contains("_0_only.cfe"));
        try {
            Map.of(PARQUET_FORMAT, parquet),
        }
        }
     */
            assertTrue("listAll should contain parquet file", fileSet.contains("parquet/seg_list.parquet"));
import java.util.Set;
        Path tempDir = createTempDir();
    /** Minimal test strategy for "parquet" wiring. */
                out.writeBytes(TEST_DATA, TEST_DATA.length);
        }
        } finally {
        DataFormatStoreHandlerFactory factory = (sid, warm, repo, cacheRegistry) -> nativeRegistry;
        WithRegistry w = buildDirectoryWithParquetFormat();
    public void testOpenInputNonExistentFile() throws IOException {
            assertEquals("fileLength should match written data length", TEST_DATA.length, length);
            assertEquals(TEST_DATA.length, length);
    public void testFileLengthFormatFileRoutesToRemote() throws IOException {
    public void testAfterSyncToRemoteDeletesLocalCopy() throws IOException {
            directory.close();
                remoteSegmentStoreDirectory,
        populateData();
            directory.close();
    public void testAfterSyncToRemoteSwitchesClonesOfInFlightReader() throws IOException {
        } finally {
    public void testAfterSyncToRemoteThrowsWhenBlobKeyNull() throws IOException {
