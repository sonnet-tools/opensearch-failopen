                out.writeBytes(TEST_DATA, TEST_DATA.length);
            Path expectedPath = shardPath.getDataPath().resolve(parquetFile);
        } finally {
        populateData();  
        // failure path so no native resources leak.
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
            fileCache.decRef(switchablePath);  
        final DataFormatStoreHandler storeHandler;
        @Override
            String parquetFile = "parquet/nested/seg_nested.parquet";
        String parquetFile = "parquet/seg_format_path.parquet";
                out.writeBytes(TEST_DATA, TEST_DATA.length);
            w.directory.close();
        }
            );  
    public void testListAllReturnsLuceneAndFormatFiles() throws IOException {  
            w.directory.close();
        WithRegistry w = buildDirectoryWithParquetFormat();
            // Our mock remote has no parquet files, so this throws.  
        } finally {
        public Optional<DataFormatStoreHandlerFactory> storeHandler() {  
    // ═══════════════════════════════════════════════════════════════  
        } finally {
    }  
    }
    }  
import org.opensearch.index.engine.dataformat.StoreStrategy;  
        );  
                shardPath,
            null  
        try {
            NativeStoreRepository.EMPTY,
        directory = buildDirectoryWithParquetFormat().directory;
            w.directory.close();  
                in.readBytes(buf, 0, buf.length);  
            String luceneFile = "_0_len.cfe";  
    }
    // deleteFile tests
                out.writeBytes(TEST_DATA, TEST_DATA.length);
            directory.close();
 */
        try {
        try {  
import static org.opensearch.storage.utils.DirectoryUtils.getFilePathSwitchable;  
        } finally {
        } finally {
            assertTrue("Format file should exist on disk after createOutput", Files.exists(expectedPath));
 * Functional tests for {@link TieredSubdirectoryAwareDirectory} exercising real I/O  
    // ═══════════════════════════════════════════════════════════════
    public void testCloseDoesNotDoubleCloseSharedSubdirectoryAwareDirectory() throws IOException {
        }  
            }  
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(
        subdirAware = new SubdirectoryAwareDirectory(localFsDir, shardPath);
import java.nio.file.Files;
            new TieredSubdirectoryAwareDirectory(
            org.mockito.ArgumentMatchers.eq(expectedUploadKey),
        } finally {  
            // Delegates to the native registry — must NOT fall through to tieredDirectory.
            assertTrue(
            writeParquetFileToDisk(parquetFile);
            this.factory = factory;
            org.mockito.ArgumentMatchers.eq(expectedUploadKey),  
 * {@link DataFormatStoreHandler} — the mock verifies {@code onUploaded} / {@code onRemoved} /
        WithRegistry w = buildDirectoryWithParquetFormat();  
            // Local file should be gone
        }
            IllegalStateException ex = expectThrows(IllegalStateException.class, () -> directory.fileLength("csv/data.csv"));
    public void testAfterSyncToRemoteDeletesLocalCopy() throws IOException {
     * Builds a TieredSubdirectoryAwareDirectory with no strategies (Lucene-only).
            null
            );
            String luceneFile = "_0_sync.cfe";
            assertFalse("Should start on local", switchable.hasSwitchedToRemote());  
        DataFormatStoreHandlerFactory factory = (sid, warm, repo, cacheRegistry) -> nativeRegistry;
            Path switchablePath = getFilePathSwitchable(localFsDir, luceneFile);
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {
    public void testRenameLuceneFileDelegatesToTieredDirectory() throws IOException {  
        directory = buildDirectoryWithParquetFormat().directory;  
        try {  
            directory.close();
        verify(throwingRegistry).close();
    public void testRenameRecoveryPrefixedFormatFile() throws IOException {  
    private static final class WithRegistry {
     * file registry is a mock. Returns both the directory and the mock so tests can  
            assertEquals("listAll should have no duplicates", fileSet.size(), files.length);  
    public void testDeleteFileFormatRoutesToNativeRegistry() throws IOException {
            IllegalStateException ex = expectThrows(
            Path expectedPath = shardPath.getDataPath().resolve(parquetFile);
    }
            // The remote metadata from populateMetadata() includes standard Lucene files.
            try (IndexOutput out = directory.createOutput(parquetFile, IOContext.DEFAULT)) {
            String parquetFile = "parquet/seg_rename.parquet";  
    private TieredSubdirectoryAwareDirectory buildDirectoryNoFormats() {
            assertEquals("fileLength should match written data length", TEST_DATA.length, length);
            directory.close();
        }  
    }
            assertTrue(ex.getMessage().contains("csv"));
            // afterSyncToRemote should register as REMOTE and delete local copy
        }
        final TieredSubdirectoryAwareDirectory directory;  
    // ═══════════════════════════════════════════════════════════════  
                assertArrayEquals("Data read back should match data written", TEST_DATA, buf);
        );
            assertTrue(Arrays.asList(directory.listAll()).contains("segments_1"));  
    // ═══════════════════════════════════════════════════════════════
            assertTrue("Lucene file should exist on local disk", Arrays.asList(localFsDir.listAll()).contains(luceneFile));
            directory.close();  
        }
            String parquetFile = "parquet/seg_already_gone.parquet";
        directory = buildDirectoryWithParquetFormat().directory;
    }
            // Original gone, new name exists
        }
 * through the full directory stack (FSDirectory → SubdirectoryAwareDirectory → TieredDirectory).
            directory.afterSyncToRemote(luceneFile);
            }
        directory = buildDirectoryWithParquetFormat().directory;  
            long length = directory.fileLength(luceneFile);
            String parquetFile = "parquet/seg_remote_nowrap.parquet";
        populateData();
            w.directory.rename(parquetFile, "parquet/seg_renamed.parquet");  
        populateData();
        }
    }  
        }  
    }
    // ═══════════════════════════════════════════════════════════════
    // afterSyncToRemote tests
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;  
import org.opensearch.index.engine.dataformat.DataFormatStoreHandlerFactory;
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        }  
        }
                out.writeBytes(TEST_DATA, TEST_DATA.length);  
        WithRegistry w = buildDirectoryWithParquetFormat();  
    private TieredSubdirectoryAwareDirectory directory;  
        populateData();  
        public long priority() {
    public void testOpenInputSegmentsFileReadsFromLocalWhenNotInRemoteMetadata() throws IOException {
            fail("Expected IllegalStateException from null fileCache");
        WithRegistry w = buildDirectoryWithParquetFormat();
            String[] files = directory.listAll();
            org.opensearch.storage.indexinput.FormatSwitchableIndexInput switchable =
            java.lang.reflect.Field field = RemoteSegmentStoreDirectory.class.getDeclaredField("segmentsUploadedToRemoteStore");
            w.directory.close();
                out.writeBytes(TEST_DATA, TEST_DATA.length);
            directory.close();
            // "parquet/unknown.parquet" is a format file but has no remote metadata entry
        }  
    private WithRegistry buildDirectoryWithParquetFormat() {  
        try {
            // createOutput for format files should route through SubdirectoryAwareDirectory  
            String parquetFile = "parquet/seg_create.parquet";
        }
        };
        directory = buildDirectoryNoFormats();  
            }  
            // Verify the file was written to disk via SubdirectoryAwareDirectory path resolution  
            // Should contain Lucene files from remote metadata (populated in setup)  
            Path switchablePath = getFilePathSwitchable(localFsDir, luceneFile);
        directory = buildDirectoryWithParquetFormat().directory;  
            // Rename should succeed — routes through SubdirectoryAwareDirectory for recovery support
            assertFalse("Local file should be deleted", java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile)));  
    // ═══════════════════════════════════════════════════════════════
            subdirAware,  
                subdirAware,
        } catch (Exception e) {
                ((org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper) input).unwrap();
    }
            registry,
        DataFormatStoreHandler nativeRegistry = mock(DataFormatStoreHandler.class);  
    private static final byte[] TEST_DATA = "hello-tiered".getBytes(StandardCharsets.UTF_8);
        populateData();  
            input.close();
        directory = buildDirectoryWithParquetFormat().directory;
    @SuppressForbidden(reason = "test needs reflection to inject parquet metadata without full upload pipeline")
            directory.close();  
            w.directory.rename(recoveryFile, finalFile);
            assertFalse(java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile)));  
            assertFalse(java.nio.file.Files.exists(shardPath.getDataPath().resolve(recoveryFile)));  
        } finally {  
            String luceneFile = "_0_create.cfe";
            subdirAware,
import java.util.Arrays;
    // ═══════════════════════════════════════════════════════════════  
            assertTrue("Original should be switched", switchable.hasSwitchedToRemote());
     * verify calls routed to the registry.
                in.readBytes(buf, 0, buf.length);
        try {
    // ═══════════════════════════════════════════════════════════════
                java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile))
        populateData();
            try (IndexOutput out = subdirAware.createOutput(segmentsFile, IOContext.DEFAULT)) {
        populateData();
            // It should go through TieredDirectory (the normal Lucene file path).  
        try {  
            return Optional.of(factory);
                out.writeBytes(PARQUET_DATA, PARQUET_DATA.length);
    }  
            // → getExistingRemoteFilename returns null → should throw  
            Set<String> fileSet = new HashSet<>(Arrays.asList(files));
                "Local file should be deleted even without open readers",
    public void testFileLengthUnregisteredFormatThrowsIllegalState() throws IOException {  
        try {  
    private WithRegistry buildDirectoryWithParquetFormat(DataFormatStoreHandler nativeRegistry) {
            );
            Integer refCount = fileCache.getRef(switchablePath);
        } finally {  
import org.opensearch.index.engine.dataformat.DataFormatStoreHandler;
            // Open input and clone it  
        WithRegistry w = buildDirectoryWithParquetFormat();  
    private static final class TestParquetStrategy extends StoreStrategy {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        try {
                threadPool,
            String parquetFile = "parquet/seg_switchable.parquet";
        } finally {
        populateData();  
    }  
            assertNotNull("Lucene file should be cached in FileCache after createOutput", fileCache.get(switchablePath));
            input.close();
            // segments_N that IS in remote metadata should NOT take the local fallback path.
    // ═══════════════════════════════════════════════════════════════
    }
        private final DataFormatStoreHandlerFactory factory;
            assertTrue("listAll should contain Lucene file", fileSet.contains("_0_only.cfe"));
        } finally {  
    public void testFormatFileWrittenToDiskNotAccessibleViaRemote() throws IOException {
    private FSDirectory localFsDir;
        directory = buildDirectoryWithParquetFormat().directory;  
            directory.close();  
        @Override
                () -> directory.openInput("csv/data.csv", IOContext.DEFAULT)  
        }  
            IndexInput input = directory.openInput(parquetFile, IOContext.DEFAULT);
        directory = buildDirectoryWithParquetFormat().directory;  
    }
            // sync should not throw even with non-existent files — it's a no-op on warm
            input.close();
                out.writeBytes(PARQUET_DATA, PARQUET_DATA.length);  
            long length = directory.fileLength(luceneFile);
    }
import org.opensearch.common.SuppressForbidden;
    public void testFileLengthFormatFileRoutesToRemote() throws IOException {
            }  
        } finally {  
            directory.close();  
        }
        } finally {
            assertTrue("Nested format file should exist after createOutput", Files.exists(expectedPath));  
        Path shardDataPath = tempDir.resolve("data").resolve("test-uuid").resolve("0");
        verify(w.storeHandler).onUploaded(
            getMockPrefetchSettingsSupplier()  
            String luceneFile = "_0_del.cfe";
            try (IndexInput in = directory.openInput(segmentsFile, IOContext.DEFAULT)) {
            assertFalse(
            switchable.readBytes(buf, 0, buf.length);
        WithRegistry w = buildDirectoryWithParquetFormat(throwingRegistry);
    public void testAfterSyncToRemoteFormatFileNoopWhenNotRemoteSyncAware() throws IOException {
            // Expected  
            // Goes to tieredDirectory.openInput which reads from remote via FileCache.
        );
    public void testOpenInputRemoteFormatFileDoesNotWrapInSwitchable() throws IOException {  
        }  
    }  
                ((org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper) input).unwrap();
            field.setAccessible(true);
            writeParquetFileToDisk("parquet/seg_list.parquet");
            addParquetMetadataEntry(parquetFile, "seg_noop.parquet__UUID3");  
    public void testListAllSortedAndDeduplicates() throws IOException {
            Set<String> fileSet = new HashSet<>(Arrays.asList(files));
    }
            expectThrows(Exception.class, () -> directory.fileLength("parquet/seg_len.parquet"));
    }
        try {
            assertTrue("Local format file should have non-zero length", input.length() > 0);  
        try {
        directory = buildDirectoryNoFormats();
        populateData();  
        Files.createDirectories(shardStatePath);
            // Local file should still be deleted  
    }
        directory = buildDirectoryNoFormats();
        directory = buildDirectoryWithParquetFormat().directory;
        // The registry (and its native registries) must have been closed by the constructor's  
    /**
        populateData();
    public void testAfterSyncToRemoteUnregisteredFormatThrowsIllegalState() throws IOException {
            Path switchablePath = getFilePathSwitchable(localFsDir, luceneFile);
        directory = buildDirectoryNoFormats();
        } finally {  
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            assertNotNull(input);
            try (IndexOutput out = directory.createOutput("pending_segments_1", IOContext.DEFAULT)) {
        try {  
    // sync() tests
        @Override
            );
            assertTrue(ex.getMessage().contains("csv"));
        } finally {
                java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile))  
            // Write a segments_N file locally (simulates a restart where local generation differs from remote)  
        }
        }
            verify(w.storeHandler).onRemoved(expectedDelKey);  
            org.mockito.ArgumentMatchers.anyLong()  
        } finally {
        try {  
        TestParquetStrategy(DataFormatStoreHandlerFactory factory) {
 */  
            String parquetFile = "parquet/seg_local_only.parquet";
        try {
        }
                out.writeBytes(TEST_DATA, TEST_DATA.length);
            assertTrue(ex.getMessage().contains("csv"));
            assertTrue("File should exist before delete", beforeDelete.contains(luceneFile));
import org.opensearch.index.engine.dataformat.DataFormat;  
            directory.close();
    // ═══════════════════════════════════════════════════════════════
        }  
        try {
        } finally {
        WithRegistry w = buildDirectoryWithParquetFormat();
            w.directory.afterSyncToRemote(parquetFile);  
            directory.close();  
    public void testOpenInputLocalFormatFileReturnsFormatSwitchable() throws IOException {
    // FormatSwitchableIndexInput integration tests
import java.util.function.Supplier;
    }  
            // Verify file exists locally
            // Don't write file to disk — it's already gone  
        populateMetadata();
        }  
            }
    public void testDeleteFileUnregisteredFormatThrowsIllegalState() throws IOException {
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
            directory.close();
        }  
    }  
    }
            // Should not throw — catches NoSuchFileException silently
                registry,  
            assertTrue(ex.getMessage().contains("csv"));  
            directory.close();  
        }  
    public void testLuceneFileWithNoStrategyRoutesToTieredDirectory() throws IOException {  
    }
            String segmentsFile = "segments_5";
        populateData();  
                remoteSegmentStoreDirectory,  
    // ═══════════════════════════════════════════════════════════════
            // Sync — the switch cascades to clones internally (tested in FormatSwitchableIndexInputTests)
            addParquetMetadataEntry(parquetFile, "seg_clone_switch.parquet__UUID1");
            assertTrue(ex.getMessage().contains("parquet/unknown.parquet"));
        populateData();
        } finally {
    private void writeParquetFileToDisk(String relativePath) throws IOException {
        directory = buildDirectoryNoFormats();
 * The OpenSearch Contributors require contributions made to  
        try {  
            );
    public void testAfterSyncToRemoteSwitchesInFlightReader() throws IOException {  
        return new TieredSubdirectoryAwareDirectory(
            directory.afterSyncToRemote(parquetFile);
            // This is the translog bump edge case: file created locally, not yet synced.
        // returns "test-base-path/parquet/" (mock BlobPath includes format subdirectory),  
    // ═══════════════════════════════════════════════════════════════
            String luceneFile = "_0_create_lucene.cfe";
        populateData();
        try {  
            try (IndexOutput out = directory.createOutput(parquetFile, IOContext.DEFAULT)) {
        populateData();
            w.directory.afterSyncToRemote(parquetFile);  
            directory.close();
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY, 1);  
    public void testCreateOutputLuceneFileStillRoutesToTieredDirectory() throws IOException {  
        populateData();
/*  
import static org.mockito.Mockito.mock;
        BlobContainer mockBlobContainer = mock(BlobContainer.class);  
            addParquetMetadataEntry(segmentsFile, "segments_2__UUID1");
            shardPath,
            assertEquals(TEST_DATA.length, length);  
            try (IndexOutput out = directory.createOutput("_0_list.cfe", IOContext.DEFAULT)) {
            try (IndexOutput out = directory.createOutput("_0_dup_b.cfe", IOContext.DEFAULT)) {  
            return 2;  
        } finally {  
        try {
    public void testOpenInputSegmentsFileFallsToTieredDirectoryWhenNotLocal() throws IOException {  
        }
            addParquetMetadataEntry(parquetFile, "seg_remote.parquet__UUID1");  
        }
        }  
            assertTrue(java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile)));  
        directory = buildDirectoryWithParquetFormat().directory;
    public void testOpenInputRoutesToRemoteWhenInRemoteMetadata() throws IOException {
        public String name() {  
            // Since it's in remote metadata, getExistingRemoteFilename != null → skips local fallback.  
            w.directory.close();
            assertFalse(switchable.hasSwitchedToRemote());
        }  
        populateData();
     * Parquet files don't have Lucene codec footers, so we can't use copyFrom.  
            assertTrue(ex.getMessage().contains("No StoreStrategy"));  
 *
        populateData();
                localFilename + "::" + uploadedFilename + "::checksum123::100::" + org.apache.lucene.util.Version.LATEST.major
        try {  
    // IllegalStateException guard tests (no matching strategy)  
    }
        directory = buildDirectoryWithParquetFormat().directory;
            writeParquetFileToDisk(parquetFile);  
            }
        }  
        }  
        shardPath = new ShardPath(false, shardDataPath, shardStatePath, shardId);
            remoteSegmentStoreDirectory,
            directory.close();
    // openInput — segments_N local fallback tests
    // Edge case tests
            // File is in remote metadata → should route to remote directory
            remoteSegmentStoreDirectory,
import org.apache.lucene.store.IOContext;
            writeParquetFileToDisk(parquetFile);
        when(mockBlobContainer.path()).thenReturn(new BlobPath().add("test-base-path").add("parquet"));
            assertTrue(java.nio.file.Files.exists(shardPath.getDataPath().resolve("parquet/seg_renamed.parquet")));
                assertNotNull("openInput should return non-null for Lucene file", in);
            IndexInput input = directory.openInput(parquetFile, IOContext.DEFAULT);  
            // No openInput call — no FormatSwitchableIndexInput tracked
            remoteSegmentStoreDirectory,
            org.mockito.ArgumentMatchers.eq("test-base-path/parquet/seg_format_path.parquet__UUID1"),
        // so the path should be "test-base-path/parquet/seg_format_path.parquet__UUID1"
            directory.afterSyncToRemote(parquetFile);  
        String parquetFile = "parquet/seg_sync.parquet";
    }
            String[] files = directory.listAll();
            addParquetMetadataEntry(parquetFile, "seg_delete_local.parquet__UUID1");
            String luceneFile = "_0_test.cfe";  
    public void testAfterSyncToRemoteThrowsWhenBlobKeyNull() throws IOException {
    public void testAfterSyncToRemotePassesCorrectFormatToGetRemoteBasePath() throws IOException {  
        Files.createDirectories(shardDataPath.resolve("index"));  
        }  
        } finally {  
            assertNotNull(input);
    }
            assertNotNull("Lucene file should be in FileCache via TieredDirectory", fileCache.get(switchablePath));  
        try {
            }
            assertArrayEquals("Should read local data before sync", PARQUET_DATA, buf);
                byte[] buf = new byte[TEST_DATA.length];
    public void testCreateOutputFormatFileRoutesToSubdirectoryAwareDirectory() throws IOException {
 *
            // File exists locally but not in remote metadata — should be readable from local.
        }
        );
            assertTrue(java.nio.file.Files.exists(shardPath.getDataPath().resolve(parquetFile)));
                assertNotNull("openInput should return non-null for local segments file", in);
        @Override  
        try {
    public void testAfterSyncToRemoteSwitchesClonesOfInFlightReader() throws IOException {
            byte[] buf = new byte[PARQUET_DATA.length];  
            addParquetMetadataEntry(parquetFile, "seg_nosync.parquet__UUID2");
 * compatible open source license.
            directory.close();
            // Verify it's in the FileCache (TieredDirectory behavior)
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {  
            }
        addParquetMetadataEntry(parquetFile, "seg_sync.parquet__UUID1");
    }  
        Path fullPath = shardPath.getDataPath().resolve(relativePath);
            directory.close();  
    public void testListAllIncludesLuceneFiles() throws IOException {
        }  
    public void testFileLengthLuceneFile() throws IOException {
            expectThrows(NoSuchFileException.class, () -> directory.openInput("non_existent_file.cfe", IOContext.DEFAULT));  
        directory = buildDirectoryNoFormats();
            this.directory = directory;
        Files.write(fullPath, PARQUET_DATA);
    // afterSyncToRemote() — null blobKey test
        }  
import org.opensearch.repositories.NativeStoreRepository;
            String finalFile = "parquet/seg_0.parquet";
    // ═══════════════════════════════════════════════════════════════
    private static final DataFormat PARQUET_FORMAT = new DataFormat() {
        );
            // Now simulate sync: add remote metadata and call afterSyncToRemote
        try {
    // ═══════════════════════════════════════════════════════════════  
            directory.sync(java.util.List.of("_0.cfe", "parquet/seg_0.parquet", "nonexistent.file"));
            IllegalStateException ex = expectThrows(IllegalStateException.class, () -> directory.afterSyncToRemote("csv/data.csv"));
            // Verify renamed file exists
            org.mockito.ArgumentMatchers.anyLong()
        // Stub getBlobContainer().path() so getRemoteBasePath(format) doesn't NPE in afterSyncToRemote tests
            java.util.concurrent.ConcurrentHashMap<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata> map =  
        } finally {
        populateData();  
                null, // null fileCache → triggers IllegalStateException in CompositeDirectory
            org.mockito.ArgumentMatchers.any(),
    }
        populateData();
import java.util.Set;  
        }
        } finally {
            directory.close();
            IndexInput input = directory.openInput(parquetFile, IOContext.DEFAULT);
            assertTrue("Should be switched to remote after afterSyncToRemote", switchable.hasSwitchedToRemote());  
            // Lucene files should still go through TieredDirectory (FileCache integration)
    // ═══════════════════════════════════════════════════════════════
        } finally {
            // On read-only warm, openInput for format files goes to remoteDirectory.
            when(settings.isStoredFieldsPrefetchEnabled()).thenReturn(true);
        org.mockito.Mockito.doThrow(new IOException("native close failed")).when(throwingRegistry).close();
        public java.util.Set<org.opensearch.index.engine.dataformat.FieldTypeCapabilities> supportedFields() {
            String parquetFile = "parquet/seg_clone_switch.parquet";  
            directory.close();
import java.util.Map;
    }
    // IOUtils.close — partial close safety  
            assertFalse(
        }  
        StoreStrategyRegistry registry = StoreStrategyRegistry.open(  
            w.directory.close();  
            IndexInput input = w.directory.openInput(parquetFile, IOContext.DEFAULT);
            // segments_99 doesn't exist locally or in remote metadata.
                out.writeBytes(TEST_DATA, TEST_DATA.length);
            // Read some bytes from local
            writeParquetFileToDisk(parquetFile);
        }
            // File exists locally but NOT in remote metadata → should read from local  
import org.opensearch.index.store.remote.filecache.FileCache;  
        return buildDirectoryWithParquetFormat(mock(DataFormatStoreHandler.class));
    /**
    public void setup() throws IOException {
            assertNotNull("File should be in FileCache before afterSyncToRemote", fileCache.get(switchablePath));
import java.util.HashSet;  
    private static final byte[] PARQUET_DATA = "parquet-payload".getBytes(StandardCharsets.UTF_8);  
                (java.util.concurrent.ConcurrentHashMap<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata>) field.get(
import org.opensearch.index.store.SubdirectoryAwareDirectory;
        directory = buildDirectoryWithParquetFormat().directory;
            // (remote directory is mocked, so this verifies routing not actual read)
            // This would fail without SubdirectoryAwareDirectory creating parent dirs  
            assertTrue("Local format file should have non-zero length", len > 0);
        verify(w.storeHandler).onUploaded(  
        Path tempDir = createTempDir();
            TieredStoragePrefetchSettings settings = mock(TieredStoragePrefetchSettings.class);
        directory = buildDirectoryNoFormats();
    /**
        } finally {
            input.close();  
            addParquetMetadataEntry(parquetFile, "seg_already_gone.parquet__UUID1");
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {  
            directory.close();  
            }
        WithRegistry w = buildDirectoryWithParquetFormat();
                IllegalStateException.class,
            // TieredDirectory also won't find it → expect an exception.  
    public void testOpenInputRoutesToLocalWhenNotInRemoteMetadata() throws IOException {
            }  
                assertNotNull("Should read segments file from TieredDirectory when in remote metadata", in);  
            }
        }
    }
    public void testListAllWithEmptyFormatDirectories() throws IOException {  
            writeParquetFileToDisk(parquetFile);
            );  
            writeParquetFileToDisk(recoveryFile);  
            addParquetMetadataEntry(parquetFile, "seg_no_reader.parquet__UUID1");  
        } finally {
    public void testCloseClosesNativeRegistryAndTieredDirectory() throws IOException {
        directory = buildDirectoryWithParquetFormat().directory;
    // ═══════════════════════════════════════════════════════════════
    // Constructor resource leak safety
            expectThrows(Exception.class, () -> directory.fileLength("non_existent_file.cfe"));
            directory.close();  
        directory = buildDirectoryWithParquetFormat().directory;  
    public void testOpenInputFormatFileRoutesToRemoteDirectory() throws IOException {
            expectThrows(Exception.class, () -> directory.openInput("parquet/seg.parquet", IOContext.DEFAULT));
        directory = buildDirectoryWithParquetFormat().directory;
            String parquetFile = "parquet/seg_remote.parquet";
        try {
            this.storeHandler = storeHandler;
        directory = buildDirectoryWithParquetFormat().directory;
                out.writeBytes(TEST_DATA, TEST_DATA.length);
            assertTrue(input instanceof org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper);
        verify(nativeRegistry).close();
        }
        WithRegistry w = buildDirectoryWithParquetFormat();
        w.directory.afterSyncToRemote(parquetFile);
        directory = buildDirectoryWithParquetFormat().directory;  
        try {  
    // Local-to-remote routing and afterSyncToRemote local delete tests
            directory.close();
    public void testOpenInputUnregisteredFormatThrowsIllegalState() throws IOException {  
            String expectedDelKey = shardPath.getDataPath().resolve("parquet/seg_del.parquet").toString();
    };
        when(((RemoteDirectory) remoteDataDirectory).getBlobContainer()).thenReturn(mockBlobContainer);
            }
            RemoteSegmentStoreDirectory.UploadedSegmentMetadata metadata = RemoteSegmentStoreDirectory.UploadedSegmentMetadata.fromString(
    public void testFileLengthNonExistentFile() throws IOException {  
    }
        try {
        setupRemoteSegmentStoreDirectory();
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {  
/**
        Path shardStatePath = tempDir.resolve("state").resolve("test-uuid").resolve("0");
            w.directory.close();
        directory = buildDirectoryWithParquetFormat().directory;
            directory.close();
        }
            w.directory.deleteFile("parquet/seg_del.parquet");
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
        directory = buildDirectoryWithParquetFormat().directory;  
        } finally {
    public void testAfterSyncToRemoteWithNoOpenInputStillDeletesLocal() throws IOException {
            }
        } finally {
        }
    }
    // ═══════════════════════════════════════════════════════════════  
        try {  
    // ═══════════════════════════════════════════════════════════════
        try {
    // ═══════════════════════════════════════════════════════════════  
    }
            try (IndexOutput out = directory.createOutput("_0_only.cfe", IOContext.DEFAULT)) {
            true,
            directory.close();
        addParquetMetadataEntry(parquetFile, "seg_format_path.parquet__UUID1");  
        try {
        IOException ex = expectThrows(IOException.class, w.directory::close);  
            IllegalStateException ex = expectThrows(IllegalStateException.class, () -> directory.deleteFile("csv/data.csv"));  
        directory = buildDirectoryWithParquetFormat().directory;  
            shardPath,
            IllegalStateException ex = expectThrows(
        populateData();
        try {
        populateData();  
        directory = buildDirectoryWithParquetFormat().directory;
            // File IS in remote metadata → openInput routes directly to remote, no switchable wrapper  
    public void testAfterSyncToRemoteFormatFileWithoutRemoteSyncAware() throws IOException {
            writeParquetFileToDisk(parquetFile);  
    }
        WithRegistry w = buildDirectoryWithParquetFormat();  
            StoreStrategyRegistry.EMPTY,
        }
import java.nio.file.NoSuchFileException;  
            // Simulate sync: add remote metadata entry  
                out.writeBytes(TEST_DATA, TEST_DATA.length);
        String expectedUploadKey = shardPath.getDataPath().resolve(parquetFile).toString();
                assertTrue("listAll should return sorted results", files[i - 1].compareTo(files[i]) <= 0);  
            true,  
    public void testAfterSyncToRemoteNoErrorWhenLocalAlreadyGone() throws IOException {
        w.directory.afterSyncToRemote(parquetFile);  
            w.directory.close();
    public void testOpenInputLuceneFileRoutesToTieredDirectory() throws IOException {
            try (IndexInput in = directory.openInput(luceneFile, IOContext.DEFAULT)) {  
                () -> w.directory.afterSyncToRemote("parquet/unknown.parquet")  
    }
import org.opensearch.core.index.Index;
            writeParquetFileToDisk(parquetFile);
            long len = directory.fileLength(parquetFile);  
            assertTrue("Should contain _0.si", Arrays.asList(files).contains("_0.si"));
                out.writeBytes(TEST_DATA, TEST_DATA.length);  
        }
        );
        }
            threadPool,  
        try {  
            // Simulate recovery: write with recovery prefix, then rename to final name  
    // ═══════════════════════════════════════════════════════════════  
    }  
    public void testAfterSyncToRemoteFormatFileRoutesToNativeRegistry() throws IOException {
        Index index = new Index("test-index", "test-uuid");
            String parquetFile = "parquet/seg_nosync.parquet";
import org.opensearch.common.blobstore.BlobPath;  
            directory.close();
    }
        }
        try {  
            assertTrue(ex.getMessage().contains("no remote filename"));  
            // Write a file, then rename it (simulates Lucene commit: pending_segments → segments)  
            Path switchablePath = getFilePathSwitchable(localFsDir, luceneFile);
            String recoveryFile = "parquet/recovery.abc123.seg_0.parquet";
            String parquetFile = "parquet/seg_inflight.parquet";
        }
        } finally {
                getMockPrefetchSettingsSupplier()
    }  
            addParquetMetadataEntry(parquetFile, "seg_inflight.parquet__UUID1");
import org.opensearch.core.index.shard.ShardId;
            fileCache.decRef(switchablePath);
    private FileCache fileCache;
        populateData();
    }
    }
import java.nio.charset.StandardCharsets;
            addParquetMetadataEntry(parquetFile, "seg_remote_nowrap.parquet__UUID1");
            assertFalse("File should be gone after delete", afterDelete.contains(luceneFile));
            }
            try (IndexOutput out = directory.createOutput("_0_noclose.cfe", IOContext.DEFAULT)) {
        } finally {
            w.directory.close();
            for (int i = 1; i < files.length; i++) {
        StoreStrategy parquet = new TestParquetStrategy(factory);  
public class TieredSubdirectoryAwareDirectoryTests extends TieredStorageBaseTestCase {  
        return new WithRegistry(dir, nativeRegistry);  
        } finally {  
    }
            w.directory.afterSyncToRemote(parquetFile);  
    // createOutput tests
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {
            remoteSegmentStoreDirectory,  
    }
        } finally {
        populateData();
    private Supplier<TieredStoragePrefetchSettings> getMockPrefetchSettingsSupplier() {  
            w.directory.close();
        }
        // remotePath builds: basePath + blobKey. basePath from getRemoteBasePath("parquet")
            IndexInput input = w.directory.openInput(parquetFile, IOContext.DEFAULT);
    }  
            org.opensearch.storage.indexinput.FormatSwitchableIndexInput switchable =  
                );  
    // listAll() tests
    // Routing tests — fileLength
    private ShardPath shardPath;  
    }
        try {
    }
            Map.of(PARQUET_FORMAT, parquet),
            shardPath,  
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
    // ═══════════════════════════════════════════════════════════════  
            Set<String> fileSet = new HashSet<>(Arrays.asList(files));  
        } finally {
                IllegalStateException.class,
            assertTrue("listAll should contain Lucene file", fileSet.contains("_0_list.cfe"));
    }
            // The switchable should now be on remote
            String luceneFile = "_0_guard.cfe";
    public void testCloseWithThrowingNativeRegistryStillClosesTieredDirectory() throws IOException {  
    // ═══════════════════════════════════════════════════════════════  
     * Directly adds a parquet file entry to the remote metadata map.
            String[] files = directory.listAll();  
    }  
            // We'll use a segments file that's in remote metadata by adding it.
            }  
                "Local format file should be wrapped in FormatSwitchableIndexInput",  
            directory.close();
    @SuppressWarnings("unchecked")  
import java.io.IOException;  
            );
            // The local read throws NoSuchFileException, then falls through to TieredDirectory.
            directory.deleteFile(luceneFile);
    private SubdirectoryAwareDirectory subdirAware;
            assertNotNull("Lucene file should be in FileCache after createOutput", fileCache.get(switchablePath));  
import java.util.Optional;
        try {
        TieredSubdirectoryAwareDirectory dir = new TieredSubdirectoryAwareDirectory(  
            }
            String parquetFile = "parquet/seg_no_reader.parquet";
    // ═══════════════════════════════════════════════════════════════  
        return () -> {
        StoreStrategy parquet = new TestParquetStrategy(factory);
    }
            NativeStoreRepository.EMPTY,  
        String expectedUploadKey = shardPath.getDataPath().resolve(parquetFile).toString();
 * <p>Format routing is verified via a real {@link StoreStrategyRegistry} built from a  
    }
            directory.close();
    }
        ShardId shardId = new ShardId(index, 0);  
        populateData();
            }  
                "Remote format file should NOT be wrapped in FormatSwitchableIndexInput",  
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {
            try (IndexOutput out = directory.createOutput("_0_dup_a.cfe", IOContext.DEFAULT)) {  
        } finally {
    public void testCreateOutputLuceneFile() throws IOException {
    // ═══════════════════════════════════════════════════════════════
    private void addParquetMetadataEntry(String localFilename, String uploadedFilename) {
        verify(w.storeHandler).close();
        } finally {  
            // Open input while file is local (not yet synced)
            }
    // ═══════════════════════════════════════════════════════════════  
            for (String f : files) {  
    // ═══════════════════════════════════════════════════════════════
        try {  
            assertArrayEquals("Written content should match", PARQUET_DATA, content);
    public void testCreateOutputFormatFileCreatesParentDirectories() throws IOException {
            String parquetFile = "parquet/seg_noop.parquet";
            String parquetFile = "parquet/seg_delete_local.parquet";
    public void testRenameFormatFileRoutesToSubdirectoryAware() throws IOException {  
                assertArrayEquals("Should read local segments file data", TEST_DATA, buf);
            }
        try {  
     */
        }
    // ═══════════════════════════════════════════════════════════════  
        DataFormatStoreHandlerFactory factory = (sid, warm, repo, cacheRegistry) -> nativeRegistry;
    @Before  
        try {
                out.writeBytes(TEST_DATA, TEST_DATA.length);
 * {@code close} calls. Lucene files skip the strategy lookup entirely.  
            when(settings.getReadAheadBlockCount()).thenReturn(TieredStoragePrefetchSettings.DEFAULT_READ_AHEAD_BLOCK_COUNT);  
import java.nio.file.Path;
            // segments_5 is NOT in remote metadata → should read from local disk  
    }
    // ═══════════════════════════════════════════════════════════════
            return settings;  
            directory.close();
import static org.mockito.Mockito.verify;
            return java.util.Set.of();
    /** Minimal test strategy for "parquet" wiring. */  
            directory.close();  
            Map.of(PARQUET_FORMAT, parquet),
        try {  
        }  
            getMockPrefetchSettingsSupplier()
        populateData();
        } finally {
            directory.rename("pending_segments_1", "segments_1");
            fileCache,
            String parquetFile = "parquet/seg_create_output.parquet";
            threadPool,
            writeParquetFileToDisk(parquetFile);
                out.writeBytes(TEST_DATA, TEST_DATA.length);
            w.directory.afterSyncToRemote(parquetFile);
                "Local file should be deleted after sync to remote",  
        try {  
        WithRegistry w = buildDirectoryWithParquetFormat();  
        } finally {
            input.close();  
        // In production, getRemoteBasePath("parquet") returns a path that includes the format subdirectory
            Set<String> beforeDelete = new HashSet<>(Arrays.asList(directory.listAll()));
        }
            Set<String> afterDelete = new HashSet<>(Arrays.asList(directory.listAll()));  
            assertTrue("Ref count should be 0 or null after afterSyncToRemote", refCount == null || refCount == 0);
            }  
        } catch (IllegalStateException e) {
 * this file be licensed under the Apache-2.0 license or a
        try {
 * SPDX-License-Identifier: Apache-2.0
        Files.createDirectories(fullPath.getParent());  
 * {@link StoreStrategy} whose {@link DataFormatStoreHandlerFactory} returns a Mockito-mocked
            try (IndexInput in = directory.openInput(segmentsFile, IOContext.DEFAULT)) {
                out.writeBytes(TEST_DATA, TEST_DATA.length);
import org.opensearch.common.blobstore.BlobContainer;
    // listAll tests  
                input instanceof org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper
        } finally {
        } finally {
            String segmentsFile = "segments_2";  
            assertFalse(
    public void testOpenInputNonExistentFile() throws IOException {
            );
            expectThrows(Exception.class, () -> directory.openInput("segments_99", IOContext.DEFAULT));
        directory = buildDirectoryWithParquetFormat().directory;
        try {  
    // Routing tests — openInput
            map.put(localFilename, metadata);
        try {  
    // ═══════════════════════════════════════════════════════════════  
package org.opensearch.storage.directory;
        directory = buildDirectoryWithParquetFormat().directory;
        } finally {  
        }
    // createOutput — format file routing tests
        w.directory.close();  
        directory = buildDirectoryNoFormats();
        directory = buildDirectoryWithParquetFormat().directory;  
            assertTrue(input instanceof org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper);  
    /** Writes a parquet file directly to disk (simulating the Rust writer). */  
        try {
            directory.close();
            // which creates parent directories automatically.
            // Use a nested subdirectory path to verify parent dir creation
        try {
            }
                input instanceof org.opensearch.storage.indexinput.FormatSwitchableIndexInputWrapper
    public void testSyncIsNoOp() throws IOException {
        }
                byte[] buf = new byte[TEST_DATA.length];  
    }
            byte[] content = Files.readAllBytes(expectedPath);  
import org.junit.Before;
    }  
    public void testOpenInputSegmentsFileInRemoteMetadataRoutesToTieredDirectory() throws IOException {
            directory.close();
            IndexInput input = w.directory.openInput(parquetFile, IOContext.DEFAULT);
        } finally {  
            String[] files = directory.listAll();
    }  
                    remoteSegmentStoreDirectory
        WithRegistry w = buildDirectoryWithParquetFormat();
    }
import org.apache.lucene.store.FSDirectory;  
        DataFormatStoreHandler throwingRegistry = mock(DataFormatStoreHandler.class);
                out.writeBytes(TEST_DATA, TEST_DATA.length);  
import org.opensearch.index.shard.ShardPath;
import org.apache.lucene.store.IndexOutput;  
        assertEquals("native close failed", ex.getMessage());
            directory.close();  
        } finally {
        WithRegistry(TieredSubdirectoryAwareDirectory directory, DataFormatStoreHandler storeHandler) {  
            directory.close();
            // File NOT in remote metadata → openInput takes local path → wraps in FormatSwitchableIndexInput  
        } finally {
            w.directory.afterSyncToRemote(parquetFile);  
            // Local file should be deleted
    // ═══════════════════════════════════════════════════════════════  
            directory.close();  
     * In production, the upload path adds entries via a separate mechanism.
        directory = buildDirectoryNoFormats();
        } finally {
            throw new RuntimeException("Failed to add parquet metadata entry", e);  
import static org.mockito.Mockito.when;  
import org.opensearch.index.store.RemoteDirectory;
            fileCache,  
    public void testAfterSyncToRemoteLuceneFile() throws IOException {
    }
     * Builds a TieredSubdirectoryAwareDirectory with a parquet strategy whose native
     */  
            assertTrue(java.nio.file.Files.exists(shardPath.getDataPath().resolve(finalFile)));
        } finally {
        WithRegistry w = buildDirectoryWithParquetFormat();
    // ═══════════════════════════════════════════════════════════════
            try (IndexOutput out = directory.createOutput(luceneFile, IOContext.DEFAULT)) {  
        try {
        remoteSegmentStoreDirectory.init();
                assertFalse("No parquet files should appear without format dirs", f.startsWith("parquet/"));
}  
        WithRegistry w = buildDirectoryWithParquetFormat();
            shardPath,
    // ═══════════════════════════════════════════════════════════════
            fileCache.decRef(switchablePath);
    public void testDeleteFileLuceneRoutesToTieredDirectory() throws IOException {
     */
            input.close();
        localFsDir = FSDirectory.open(shardPath.resolveIndex());
            return "parquet";
    }
import org.apache.lucene.store.IndexInput;
    // rename() tests  
            assertTrue("listAll should contain parquet file", fileSet.contains("parquet/seg_list.parquet"));  
            when(settings.getReadAheadEnableFileFormats()).thenReturn(TieredStoragePrefetchSettings.READ_AHEAD_ENABLE_FILE_FORMATS);
    public void testConstructorFailureClosesStrategyRegistry() throws IOException {
        try {
            fileCache.decRef(switchablePath);  
