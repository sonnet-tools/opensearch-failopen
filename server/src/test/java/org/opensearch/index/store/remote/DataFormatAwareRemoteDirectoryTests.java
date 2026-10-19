        BlobStore asyncBlobStore = mock(BlobStore.class);
            logger,
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");
        byte[] content = new byte[100];
        // "metadata" format routes to base container
    public void testDeleteFiles_BatchDelete_DeletesFromAllContainers() throws IOException {
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet", "parquet");
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.cfs_DIFFERENT", 1234));
        WriteContext writeContext = capturedWriteContext.get();
    // ═══════════════════════════════════════════════════════════════
        boolean result = directory.copyFrom(
            IOContext.DEFAULT,
        indexOutput.close();
        assertNotNull(input);
        indexOutput.close();
    }
     * AlreadyClosedException on all subsequent provideStream() calls during seek() in the
        when(container.remoteIntegrityCheckSupported()).thenReturn(true);
            UnaryOperator.identity(),
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
        when(mockFrom.openInput(anyString(), any())).thenThrow(new IOException("open failed"));
    // Sync copyFrom(Directory, String, String, IOContext) Tests
    }
    }
        when(mockInput.length()).thenReturn(50L);
            null
        directory.deleteFile("_0.pqt__UUID1");
        out.writeBytes(new byte[dataBytes], dataBytes);
        CountDownLatch latch = new CountDownLatch(1);
                @Override
        // Set up async upload to call onResponse
                    fail("Should have failed");
        DataFormatAwareStoreDirectory mockComposite = mock(DataFormatAwareStoreDirectory.class);
                }
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet__UUID1", "parquet");
            baseBlobPath,
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
            "_0.cfs",              // src (lucene format, no :::)
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
    }
            asyncBlobStore,
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
        IndexInput input = directory.openBlockInput("_0.pqt__UUID1", 2, 3, 10, IOContext.DEFAULT);
        // openInput wraps the stream successfully
    // ═══════════════════════════════════════════════════════════════
        Directory mockFrom = mock(Directory.class);
    // ═══════════════════════════════════════════════════════════════
        RemoteIndexOutput output = directory.createOutput("test_file.parquet", "parquet", IOContext.DEFAULT);
        IndexInput input = directory.openInput("_0.cfs", 100, IOContext.DEFAULT);
    }
     * Root cause: clone() passed the master's segments[] array by reference to MultiSegmentImpl.
    public void setUp() throws Exception {
import java.util.function.UnaryOperator;
        storeDirectory.sync(List.of(filename));
}
    }
            filename + "__UUID",
    }
        byte[] content = new byte[100];
    // ═══════════════════════════════════════════════════════════════
        assertNotNull(dir);
            baseBlobPath,
            UnaryOperator.identity(),
        pendingMergedSegments.put("localFile", "_0.cfs__UUID_MERGED");
    public void testCreateOutput_ParquetFormat() throws IOException {
import java.util.concurrent.CountDownLatch;
        storeDirectory.sync(List.of(filename));
            logger,
        assertTrue(postUploadInvoked.get());
        assertTrue("Should be CorruptIndexException", failureRef.get() instanceof CorruptIndexException);
    public void testOpenInput_StringBased_ClosesStreamOnException() throws IOException {
import static org.mockito.Mockito.times;
        for (int i = 0; i < content.length; i++)
            "parquet/_0.parquet::_0.parquet__UUID1::checksum123::200::10"
        Map<String, String> pendingMergedSegments = new HashMap<>();
    // openInput(FileMetadata, long, IOContext) Tests
    @Override
        BlobContainer container = directory.getBlobContainerForFormat("lucene");
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(eq(Collections.singletonList("_0.pqt__UUID1")));
    public void testDeleteFile_LuceneFile() throws IOException {
        // Even with exception, it should not propagate but call listener.onFailure
            completionListener.onResponse(null);
    }
    // ═══════════════════════════════════════════════════════════════
            UnaryOperator.identity(),
        String filename = "_segment.bin";
    private Directory buildFileDir(String filename, int dataBytes) throws IOException {
    public void testResolveFormat_CacheMiss_DefaultsToLucene() throws IOException {
                    fail("Should not succeed");
import org.opensearch.index.store.FileMetadata;
    // Sync CopyFrom Tests
        Mockito.doAnswer(invocation -> {
            baseBlobPath,
            new HashMap<>(),
    // ═══════════════════════════════════════════════════════════════
 *
     * When any clone closed, Arrays.fill(segments, null) corrupted the shared array, causing
            UnaryOperator.identity(),
    }
        assertTrue(latch.await(10, TimeUnit.SECONDS));
            UnaryOperator.identity(),
            UnaryOperator.identity(),
    public void testFileLength_FileNotFound() throws IOException {
        assertEquals("_0.si__UUID2", allFiles[2]);
    public void testToString() {
            baseBlobPath,
    public void testClose_ClearsFormatContainers() throws IOException {
        CountDownLatch latch = new CountDownLatch(1);
            () -> postUploadInvoked.set(true),
        storeDirectory.close();
            storeDirectory,
        assertFalse("Should return false when base container is not AsyncMultiStreamBlobContainer", result);
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
        List<String> names = List.of("_0.cfs__UUID1", "_0.parquet__UUID2");
        expectThrows(IllegalArgumentException.class, () -> directory.openBlockInput("_0.cfe__UUID1", 5, 10, 10, IOContext.DEFAULT));
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString("_0.cfs::_0.cfs__UUID1::checksum123::100::10");
        // We can't easily test the full copyFrom without a real Directory,
        );
            "_0.cfs__UUID",        // remoteFileName
        Directory storeDirectory = newDirectory();
        boolean result = asyncDir.copyFrom(storeDirectory, filename, filename + "__UUID", IOContext.DEFAULT, () -> {
    }
    }
            new ActionListener<>() {
        assertEquals(200, input.length());
import org.opensearch.common.blobstore.BlobContainer;
        IndexInput input = directory.openInput(fm.file(), 100, IOContext.DEFAULT);
import static org.mockito.ArgumentMatchers.anyString;
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");
        BlobStore asyncBlobStore = mock(BlobStore.class);
        InputStream stream = new ByteArrayInputStream(data);
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
        // the getBlobContainerForFormat that copyFrom uses internally.
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.cfs"), eq(1), any())).thenReturn(blobList);
                "AlreadyClosedException must NOT be thrown after a prior part stream closes. "
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
        Directory storeDirectory = newDirectory();
        IndexInput input = directory.openInput("_0.parquet", 200, IOContext.DEFAULT);
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
        Directory storeDirectory = newDirectory();
        when(mockStream.read(any(), anyInt(), anyInt())).thenThrow(new IOException("read error"));
        assertEquals(3, allFiles.length);
        FileMetadata fm = new FileMetadata("parquet", "_0.parquet");
    // ═══════════════════════════════════════════════════════════════
    // Edge Case Tests
        verify(baseBlobContainer, never()).readBlob(anyString());
        IndexInput mockInput = mock(IndexInput.class);
        // Identity rate limiters (no-op)
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.cfs"), eq(1), any())).thenReturn(blobList);
import org.opensearch.common.blobstore.BlobStore;
        Directory mockFrom = mock(Directory.class);
    }
        verify(baseBlobContainer, never()).readBlob(anyString());
            UnaryOperator.identity(),
        IndexMetadata metadata = IndexMetadata.builder("test-index")
            mockBlobStore,
                    latch.countDown();
        assertEquals("_0.parquet__UUID3", allFiles[1]);
    }
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString("_0.cfs::_0.cfs__UUID1::checksum123::100::10");
        // Register format so resolveFormat routes to parquet container
        CodecUtil.writeFooter(indexOutput);
            .numberOfReplicas(0)
            null
        assertNotNull(failureRef.get());
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();
    // ═══════════════════════════════════════════════════════════════
        CodecUtil.writeFooter(indexOutput);
            @Override
    public void testCompletionListener_CorruptIndexException() throws Exception {
    }
    }
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
            public void onResponse(Void unused) {
    }
        assertTrue("Should be IOException", failureRef.get() instanceof IOException);
        // Write a real file with codec footer (required for checksum computation)
        directory.deleteFile("_0.parquet");
                    latch.countDown();
                public void onResponse(Void unused) {
        verify(mockFrom).openInput(eq("_0.cfs"), any(IOContext.class));
        // asyncBlobUpload calls onFailure with a wrapped CorruptFileException
    }
                @Override
        IndexInput input = directory.openInput(fm.file(), 100, IOContext.DEFAULT);
            filename,
        verify(baseBlobContainer, times(2)).deleteBlobsIgnoringIfNotExists(names);
        boolean result = asyncDir.copyFrom(
        assertEquals(100, input.length());
    // Async copyFrom with AsyncMultiStreamBlobContainer Tests
        Settings indexSettingsBuilder = Settings.builder()
    public void testOpenInput_WithUploadedSegmentMetadata_Parquet() throws IOException {
    }
        IndexInput input = directory.openInput(metadata.getUploadedFilename(), 200, IOContext.DEFAULT);
    // ═══════════════════════════════════════════════════════════════
    }
    // ═══════════════════════════════════════════════════════════════
            () -> {},
            storeDirectory,
            false,
    }
            @Override
        // Pass lowPriorityUpload=true
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
        when(asyncContainer.path()).thenReturn(baseBlobPath);
            filename,
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString(
        assertSame("empty format should route to base container", baseBlobContainer, container);
            "_0.cfs:::lucene",
            new HashMap<>(),
            UnaryOperator.identity(),
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
            lowPriorityRateLimiter,
                    latch.countDown();
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet__UUID1", "parquet");
    public void testAsyncCopyFrom_ExceptionHandling() throws IOException {
    // Async copyFrom Tests (8-arg version, returns boolean)
        // For parquet files
    // IndexInput ref-count exhaustion Tests
        boolean result = asyncDir.copyFrom(
    }
        );
    public void testOpenInput_FileMetadata_ExceptionClosesStream() throws IOException {
        CodecUtil.writeFooter(indexOutput);
        );
    private static final Logger logger = LogManager.getLogger(DataFormatAwareRemoteDirectoryTests.class);
        } catch (org.apache.lucene.store.AlreadyClosedException e) {
        assertTrue(latch.await(10, TimeUnit.SECONDS));
    public void testOpenInput_StringBased_StreamClosedWhenInputStreamReadFails() throws IOException {
import static org.mockito.Mockito.when;
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
        directory.copyFrom(mockFrom, "_0.pqt:::parquet", "_0.pqt__UUID", IOContext.DEFAULT);
        assertEquals(5678, length);
        storeDirectory.sync(List.of(filename));
        WriteContext> writeCtx, AtomicReference<ActionListener<Void>> listener, java.util.concurrent.CountDownLatch captureLatch) {
    }
    // ═══════════════════════════════════════════════════════════════
        assertNotNull(input);
        byte[] content = new byte[100];
public class DataFormatAwareRemoteDirectoryTests extends OpenSearchTestCase {
        assertFalse("Should return false when container is not AsyncMultiStreamBlobContainer", result);
            UnaryOperator.identity(),
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        org.opensearch.core.action.ActionListener<Void> listener = mock(org.opensearch.core.action.ActionListener.class);
    // Sync copyFrom with FileMetadata
            "parquet/_0.parquet::_0.parquet__UUID1::checksum456::200::10"
    }
        // The copyFrom creates a RemoteIndexOutput that writes to the base container
     *
        boolean result = asyncDir.copyFrom(
            null
    public void testAsyncCopyFrom_WithAsyncContainer_ReturnsTrue() throws Exception {
            },
    }
        org.opensearch.core.action.ActionListener<Void> listener = mock(org.opensearch.core.action.ActionListener.class);
        Directory storeDirectory = newDirectory();
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
    // Blob Format Cache Tests
        Mockito.doAnswer(invocation -> {
        directory.copyFrom(mockFrom, "_0.cfs", "_0.cfs__UUID", IOContext.DEFAULT);
            UnaryOperator.identity(),
    }
import org.opensearch.common.settings.Settings;
    public void testGetBlobContainerForFormat_Parquet() {
    public void testConstructor_NullDataFormatRegistry() {
    }
            UnaryOperator.identity(),
     * WriteContext and completion listener without performing any real upload.
            asyncBlobStore,
                public void onFailure(Exception e) {
        assertTrue(result);
    public void testIndexInputRefCount_StaysOpenWhileProvideStreamInProgress() throws Exception {
     * Helper: builds an AsyncDir backed by an AsyncMultiStreamBlobContainer that captures the
            null,
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
    // ═══════════════════════════════════════════════════════════════
            writeCtx.set(inv.getArgument(0));
        assertTrue(str.contains("DataFormatAwareRemoteDirectory"));
        when(parquetBlobContainer.listBlobs()).thenReturn(parquetBlobs);
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
                @Override
        when(asyncContainer.path()).thenReturn(baseBlobPath);
            filename + "__UUID",
    }
        assertSame("LUCENE should route to base container", baseBlobContainer, container);
        d.sync(List.of(filename));
        directory.copyFrom(mockComposite, fm.serialize(), "_0.cfs__UUID", IOContext.DEFAULT);
            }
            },
    public void testCompletionListener_GenericException() throws Exception {
        UnaryOperator<InputStream> normalRateLimiter = stream -> stream;
        Map<String, BlobMetadata> baseBlobs = new HashMap<>();
import java.util.List;
            content[i] = (byte) i;
        input.close();
        expectThrows(IOException.class, () -> directory.openInput(metadata.getUploadedFilename(), 100, IOContext.DEFAULT));
        boolean result = asyncDir.copyFrom(
        FileMetadata fm = new FileMetadata("parquet", "_0.parquet");
    }
    public void testGetBlobContainerForFormat_Empty() {
        when(parquetBlobContainer.readBlob("_0.parquet")).thenReturn(new ByteArrayInputStream(content));
        CountDownLatch latch = new CountDownLatch(1);
        // Make openInput throw an exception
            new HashMap<>(),
        byte[] data = new byte[] { 1, 2, 3, 4, 5 };
            logger,
import org.opensearch.index.IndexSettings;
package org.opensearch.index.store.remote;
        org.apache.lucene.store.Directory mockFrom = mock(org.apache.lucene.store.Directory.class);
    // ═══════════════════════════════════════════════════════════════
    // deleteFile(UploadedSegmentMetadata) - Lucene metadata
            fail(
            null
            UnaryOperator.identity(),
                public void onResponse(Void unused) {
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");
        );
        IndexInput mockInput = mock(IndexInput.class);
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        CodecUtil.writeFooter(indexOutput);
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.cfs", 1234));
        storeDirectory.close();
        // When opening a merged segment, the low-priority rate limiter should be used
        long length = directory.fileLength("_0.parquet");
    public void testCompletionListener_PostUploadRunnerException() throws Exception {
        BlobStore asyncBlobStore = mock(BlobStore.class);
    public void testGetBlobContainerForFormat_UnregisteredFormat_CreatesLazily() {
        super.setUp();
        assertSame("lucene should route to base container", baseBlobContainer, container);
        // openInput wraps the stream, reading from it will fail
            return null;
        when(mockFrom.openInput(eq("_0.cfs"), any(IOContext.class))).thenReturn(mockInput);
            "_0.cfs__UUID",
import org.apache.lucene.store.IndexInput;
        IndexInput input = directory.openBlockInput("_0.cfe__UUID1", 0, 5, 5, IOContext.DEFAULT);
    // ═══════════════════════════════════════════════════════════════
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString("_0.cfs::_0.cfs__UUID1::checksum123::100::10");
    }
            asyncBlobStore,
                }
            return null;
        indexOutput.writeString("data");
        when(mockInput.length()).thenReturn(10L);
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
                completionLatch.countDown();
        verify(parquetBlobContainer).deleteBlobsIgnoringIfNotExists(eq(Collections.singletonList("_0.pqt__UUID1")));
        storeDirectory.close();
        AtomicReference<Boolean> postUploadInvoked = new AtomicReference<>(false);
    // ═══════════════════════════════════════════════════════════════
    public void testOpenInput_FileMetadata_Parquet() throws IOException {
        CountDownLatch latch = new CountDownLatch(1);
        // With the old clone() approach, closing stream0 would call Arrays.fill(segments, null)
            return null;
        boolean result = directory.copyFrom(mockFrom, "_0.cfs", "_0.cfs__UUID", IOContext.DEFAULT, () -> {}, listener, false, null);
    // ═══════════════════════════════════════════════════════════════
    }
        assertEquals(0, allFiles.length);
            listener.set(inv.getArgument(1));
    // ═══════════════════════════════════════════════════════════════
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
    }
                @Override
        verify(parquetBlobContainer, never()).readBlob(anyString());
            .numberOfShards(1)
        // The openInput should succeed (it just wraps the stream), but we verify the pattern
            IOContext.DEFAULT,
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
            null,
    public void testOpenInput_StringBased_ParquetFile_WithFormatSuffix() throws IOException {
            listener,
            uploadRateLimiter,
    // ═══════════════════════════════════════════════════════════════
    // openInput exception close-on-failure (stream opened but readBlob fails)
        when(parquetBlobContainer.readBlob("_0.parquet__UUID1")).thenReturn(new ByteArrayInputStream(content));
        // Create an async blob container
            mockFrom,
        assertTrue(result);
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
            },
 * SPDX-License-Identifier: Apache-2.0
    // OpenInput Tests
    }
import org.opensearch.common.blobstore.BlobMetadata;
        directory.deleteFiles(null);
            normalRateLimiter,
        BlobStore asyncBlobStore = mock(BlobStore.class);
        storeDirectory.close();
        directory.getFormatBlobRouter().orElseThrow().unregisterBlobFormat("_0.pqt__UUID1");
            assertNotNull("Part 2 stream must be created after parts 0,1 close — slice() fix", stream2);
        baseBlobs.put("_0.cfs__UUID1", new PlainBlobMetadata("_0.cfs__UUID1", 100));
    public void testOpenBlockInput_LengthExceedsFileLength_Throws() {
            null,
        // Register format in cache since DFARD receives plain blob keys
            capturedListener.set(invocation.getArgument(1));
    // ═══════════════════════════════════════════════════════════════
        long length = directory.fileLength(fm.file());
            null
/*
        verify(baseBlobContainer, never()).deleteBlobsIgnoringIfNotExists(any());
        indexOutput.close();
            lowPriorityUploadRateLimiter,
        // After close, the directory is closed but FormatBlobRouter still lazily creates containers
        DataFormatRegistry mockRegistry = mock(DataFormatRegistry.class);
            completionListener.onFailure(new IOException("network error"));
    // FileMetadata-based copyFrom (non-async) - returns false when not async
    // createOutput Tests - Format-aware routing
                public void onResponse(Void unused) {
            null
            true,  // lowPriorityUpload
        AtomicReference<Exception> failureRef = new AtomicReference<>();
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.parquet", 5678));
        byte[] content = new byte[200];
import org.apache.lucene.codecs.CodecUtil;
            () -> {},
import java.nio.file.NoSuchFileException;
        parquetBlobContainer = mock(BlobContainer.class);
    public void testFileLength_FileMetadata_Lucene() throws IOException {
                    latch.countDown();
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet", "parquet");
                }
        directory.deleteFiles(names);
        verify(parquetBlobContainer).deleteBlobsIgnoringIfNotExists(eq(Collections.singletonList("_0.pqt__UUID1")));
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
    }
    // slice() isolation tests
        // Base container has lucene files
                completionLatch.countDown();
    }
        assertTrue(result);
        directory.deleteFile("_0.cfs");
        assertFalse(result);
    // Lifecycle Tests
            () -> {},
import org.opensearch.index.store.checksum.GenericCRC32ChecksumHandler;
            public void onResponse(Void unused) {
            store,
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
    /**
            null
        Directory storeDirectory = newDirectory();
        when(mockBlobStore.blobContainer(baseBlobPath.parent().add("parquet"))).thenReturn(parquetBlobContainer);
    private AsyncDirFixture buildAsyncFixture() throws Exception {
        byte[] content = new byte[100];
        BlobContainer container = directory.getBlobContainerForFormat("metadata");
        expectThrows(IllegalArgumentException.class, () -> directory.openBlockInput("_0.cfe__UUID1", -1, 5, 10, IOContext.DEFAULT));
            UnaryOperator.identity(),
            UnaryOperator.identity(),
    private BlobContainer parquetBlobContainer;
        when(baseBlobContainer.readBlob("_0.cfe__UUID1", 0, 5)).thenReturn(stream);
                @Override
                    + "slice() fixes. Exception: "
    private static void assertNoException(Runnable r) {
    // ═══════════════════════════════════════════════════════════════
        String filename = "_100.si";
        assertNotNull(input);
        expectThrows(NoSuchFileException.class, () -> directory.fileLength(fm.file()));
                    fail("Should not succeed");
    // ═══════════════════════════════════════════════════════════════
        CountDownLatch completionLatch = new CountDownLatch(1);
            null
    }
        indexOutput.writeBytes(content, content.length);
        // Returns false because baseBlobContainer is not AsyncMultiStreamBlobContainer
    // ═══════════════════════════════════════════════════════════════
            new HashMap<>(),
        assertNotNull(input);
            baseBlobPath,
        directory.getFormatBlobRouter().orElseThrow().replaceBlobFormatCache(Map.of("_0.pqt__UUID1", "parquet"));
    // ═══════════════════════════════════════════════════════════════
        boolean result = asyncDir.copyFrom(
            () -> {},
        InputStream mockStream = mock(InputStream.class);
    }
            new HashMap<>(),
    public void testFileLength_ParquetFile() throws IOException {
            filename + "__UUID",
    public void testOpenBlockInput_LuceneFile() throws IOException {
        assertEquals("_0.cfs__UUID1", allFiles[0]);
    public void testAsyncCopyFrom_LowPriorityUpload() throws Exception {
    public void testSyncCopyFrom_ParquetFile_CopiesToFormatContainer() throws IOException {
            );
        // Create directory with pending merged segments
        Mockito.doAnswer(invocation -> {
            public void onFailure(Exception e) {
import java.io.InputStream;
            return null;
    // FileLength Tests
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.cfs"), eq(1), any())).thenReturn(blobList);
    }
        DataFormatAwareRemoteDirectory dir = new DataFormatAwareRemoteDirectory(
        assertTrue("Should be CorruptIndexException", failureRef.get() instanceof CorruptIndexException);
            false,
            UnaryOperator.identity(),
            }
        when(baseBlobContainer.readBlob("_0.cfs__UUID1")).thenReturn(mockStream);
        assertNotNull(input);
import org.opensearch.core.action.ActionListener;
    // DownloadRateLimiterProvider merged segment path
    public void testCompletionListener_CorruptFileException() throws Exception {
     * its own independent segments[] copy. Closing one part only nullifies its own array.
        assertEquals(100, input.length());
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
                @Override
        when(baseBlobContainer.listBlobs()).thenReturn(Collections.emptyMap());
            IOContext.DEFAULT,
                @Override
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
        input.close();
        // Replace cache with parquet mapping
            null,
            UnaryOperator.identity(),
    // ═══════════════════════════════════════════════════════════════
        // Format: originalFilename::uploadedFilename::checksum::length::writtenByMajor
            null
        expectThrows(IOException.class, () -> directory.openInput(fm.file(), 100, IOContext.DEFAULT));
        byte[] content = new byte[1024];
        when(container.path()).thenReturn(baseBlobPath);
    public void testDeleteFile_ParquetFile_WithFormatSuffix() throws IOException {
        );
                }
    public void testOpenInput_StringBased_LuceneFile() throws IOException {
 * compatible open source license.
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.cfs_DIFFERENT", 1234));
            null,
                public void onResponse(Void unused) {
            new ActionListener<>() {
            "_nonexistent.si__UUID",
        org.apache.lucene.store.Directory mockFrom = mock(org.apache.lucene.store.Directory.class);
            .build();
        String filename = "_100.si";
        byte[] content = new byte[200];
            new ActionListener<>() {
    // openInput(UploadedSegmentMetadata) - Exception closes stream
            return null;
    public void testGetBlobContainerForFormat_Lucene() {
        stream0.getInputStream().close();  // closes part 0's independent slice — must NOT affect parts 1,2
                }
            new HashMap<>(),
                    failureRef.set(e);
            UnaryOperator.identity(),
            latch.countDown();
        when(baseBlobContainer.readBlob("_0.cfs")).thenReturn(new ByteArrayInputStream(content));
        storeDirectory.close();
 */
    // ═══════════════════════════════════════════════════════════════
    }
        when(baseBlobContainer.listBlobs()).thenReturn(baseBlobs);
        AtomicReference<WriteContext> writeCtx = new AtomicReference<>();
            asyncBlobStore,
                    failureRef.set(e);
        BlobStore asyncBlobStore = mock(BlobStore.class);
            .settings(indexSettingsBuilder)
        byte[] data = new byte[] { 10, 20, 30 };
        // baseBlobContainer is called from super.deleteFiles + lucene format container (same instance)
        BlobContainer container = directory.getBlobContainerForFormat("");
            filename,
                    latch.countDown();
            Map.of("parquet", (Supplier<DataFormatDescriptor>) () -> new DataFormatDescriptor("parquet", new GenericCRC32ChecksumHandler()))
        boolean result = directory.copyFrom(
            null,
    // ═══════════════════════════════════════════════════════════════
    // Format Routing Tests (getBlobContainerForFormat)
            UnaryOperator.identity(),
        InputStream stream = new ByteArrayInputStream(data);
            filename,
            false,
        directory.deleteFile("_0.pqt__UUID_MISSING");
        when(baseBlobContainer.readBlob("_0.cfs")).thenThrow(new IOException("blob read failed"));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexOutput out = d.createOutput(filename, IOContext.DEFAULT);
        Directory storeDirectory = newDirectory();
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.cfs"), eq(1), any())).thenReturn(blobList);
        assertTrue(result);
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
        IndexInput input = directory.openInput(metadata.getUploadedFilename(), 100, IOContext.DEFAULT);
        org.opensearch.common.StreamContext streamContext = writeContext.getStreamProvider(partSize);
        // Unregister — should fall back to lucene
        mockBlobStore = mock(BlobStore.class);
        verify(parquetBlobContainer, never()).deleteBlobsIgnoringIfNotExists(any());
    // ═══════════════════════════════════════════════════════════════
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
        IndexInput input = directory.openInput(fm.file(), 200, IOContext.DEFAULT);
            filename + "__UUID",
            throw new RuntimeException("postUpload error");
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
            mockRegistry,
    public void testOpenInput_FileMetadata_ClosesStreamOnException() throws IOException {
        );
                public void onResponse(Void unused) {
        assertNotNull(directory.getBlobContainerForFormat("parquet"));
    }
        AtomicReference<Exception> failureRef = new AtomicReference<>();
import org.apache.lucene.store.IndexOutput;
    public void testSyncCopyFrom_LuceneFile_CopiesToBaseContainer() throws IOException {
            capturedWriteContext.set(invocation.getArgument(0));
            null,
        boolean result = asyncDir.copyFrom(
    public void testReplaceBlobFormatCache() throws IOException {
        );
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
        assertEquals(200, input.length());
    public void testGetBlobContainerForFormat_LUCENE_UpperCase() {
 */
    public void testListAll_AggregatesAllContainers() throws IOException {
        BlobStore asyncBlobStore = mock(BlobStore.class);
        when(baseBlobContainer.readBlob("_0.cfs")).thenReturn(mockStream);
 * Unit tests for {@link DataFormatAwareRemoteDirectory}.
        when(asyncContainer.path()).thenReturn(baseBlobPath);
    // List Tests
    }
        CountDownLatch latch = new CountDownLatch(1);
            false,
                }
        assertEquals(100, input.length());
        // Returns a blob but name doesn't match
    public void testDownloadRateLimiter_MergedSegment_UsesLowPriorityRateLimiter() throws IOException {
        // asyncBlobUpload calls onFailure with a wrapped CorruptIndexException
            UnaryOperator.identity(),
        when(mockFrom.openInput(eq("_0.pqt:::parquet"), any(IOContext.class))).thenReturn(mockInput);
        capturedListener.get().onResponse(null);
        return d;
        );
        byte[] content = new byte[200];
        // The important thing is that close() doesn't throw
    public void testUnregisterBlobFormat() throws IOException {
            null
        FileMetadata fm = new FileMetadata("lucene", "nonexistent");
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString("_0.cfs::_0.cfs__UUID1::checksum123::100::10");
import org.opensearch.index.store.RemoteIndexOutput;
    }
        IndexInput input = dirWithMerged.openInput(metadata.getUploadedFilename(), 100, IOContext.DEFAULT);
        assertTrue(result);
    }
        );
    public void testOpenInput_FileMetadata_Lucene() throws IOException {
            return null;
            null
            mockFrom,
        );
        verify(parquetBlobContainer).delete();
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(true);
        // FormatBlobRouter lazily creates containers for unknown formats via computeIfAbsent
        // Should be sorted
        InputStream mockStream = mock(InputStream.class);
        // With slice(), each part has its own independent segments[] copy — closing one never
                }
        try {
        long partSize = Math.max(1, writeContext.getFileSize() / 3);
    }
        CountDownLatch latch = new CountDownLatch(1);
        // Write enough bytes to ensure multipart upload (content > 0)
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
    }
    // ═══════════════════════════════════════════════════════════════
        // asyncBlobUpload calls onFailure with a generic exception (not corrupt)
        BlobStore store = mock(BlobStore.class);
        CodecUtil.writeFooter(indexOutput);
    public void testOpenInput_UploadedSegmentMetadata_ExceptionClosesStream() throws IOException {
import java.util.concurrent.TimeUnit;
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
                public void onResponse(Void unused) {
        BlobContainer container = directory.getBlobContainerForFormat("LUCENE");
            UnaryOperator.identity(),
    // ═══════════════════════════════════════════════════════════════
        input.close();
            public void onFailure(Exception e) {
            baseBlobPath,
                @Override
import java.util.Collections;
        verify(mockFrom).openInput(eq("_0.pqt:::parquet"), any(IOContext.class));
        verify(baseBlobContainer).readBlob("_0.cfs");
                    fail("Should not fail: " + e.getMessage());
    // openBlockInput Tests
                public void onFailure(Exception e) {
import java.io.IOException;
     */
            UnaryOperator.identity(),
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
            listener,
import org.apache.logging.log4j.Logger;
        assertTrue(str.contains("parquet"));
        Mockito.doAnswer(invocation -> {
                    fail("Should not succeed");
        indexOutput.writeString("Hello World!");
import java.util.function.Supplier;
        // affects others.
        String[] allFiles = directory.listAll();
        // Should not throw with null DataFormatRegistry and IndexSettings
        // UUID-suffixed key not in cache — should warn and default to lucene
        CodecUtil.writeFooter(out);
        // Initially no cache entries — deleteFile for a UUID key defaults to lucene (base container)
        directory.delete();
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("nonexistent"), eq(1), any())).thenReturn(Collections.emptyList());
        CountDownLatch uploadCaptureLatch = new CountDownLatch(1);
        parquetBlobs.put("_0.parquet__UUID3", new PlainBlobMetadata("_0.parquet__UUID3", 200));
            storeDirectory,
        directory = new DataFormatAwareRemoteDirectory(
        input.close();
        Mockito.doAnswer(invocation -> {
    }
import org.opensearch.common.blobstore.stream.write.WriteContext;
        verify(baseBlobContainer, times(2)).delete();
    public void testOpenInput_ClosesStream_OnFailure() throws IOException {
    public void testAsyncCopyFrom_NonAsyncContainer_ReturnsFalse() throws IOException {
    // ═══════════════════════════════════════════════════════════════
        // File does not exist - openInput will throw
    // ═══════════════════════════════════════════════════════════════
import java.io.ByteArrayInputStream;
    }
        }, new ActionListener<>() {
        verify(parquetBlobContainer).readBlob("_0.parquet__UUID1");
            pendingMergedSegments,
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");
    private BlobContainer baseBlobContainer;
        org.opensearch.core.action.ActionListener<Void> listener = mock(org.opensearch.core.action.ActionListener.class);
                fail("Should not succeed");
            null
            null,
        long length = directory.fileLength("_0.cfs");
        // postUploadRunner throws exception → listener.onFailure
        assertNoException(() -> directory.getBlobContainerForFormat("arrow"));
        storeDirectory.sync(List.of(filename));
        storeDirectory.sync(List.of(filename));
            completionListener.onResponse(null);
        when(mockInput.length()).thenReturn(20L);
        indexOutput.close();
            UnaryOperator.identity(),
            @Override
    // ═══════════════════════════════════════════════════════════════
        // Wire up blobStore to return async container for base path
        Directory d = newDirectory();
        String str = directory.toString();
    }
            UnaryOperator.identity(),
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("metadata__1__2__3"));
        assertNotNull(input);
        RemoteIndexOutput output = directory.createOutput("test_file", "lucene", IOContext.DEFAULT);
    public void testOpenBlockInput_InvalidPosition_Throws() {
    public void testCreateOutput_LuceneFormat() throws IOException {
    // ═══════════════════════════════════════════════════════════════
        baseBlobs.put("_0.si__UUID2", new PlainBlobMetadata("_0.si__UUID2", 50));
            new HashMap<>(),
    }
        when(asyncContainer.path()).thenReturn(baseBlobPath);
    }
            logger,
        expectThrows(IOException.class, () -> directory.openInput("_0.cfs", 100, IOContext.DEFAULT));
        directory.deleteFile(metadata.getUploadedFilename());
                    + "This is the Arrays.fill(segments,null) shared-array corruption bug that "
import org.apache.lucene.store.IOContext;
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.parquet", 5678));
        org.apache.lucene.store.Directory mockFrom = mock(org.apache.lucene.store.Directory.class);
    // ═══════════════════════════════════════════════════════════════
            filename,
            stream1.getInputStream().close();
        expectThrows(NoSuchFileException.class, () -> directory.fileLength("_0.cfs"));
            baseBlobPath,
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
    /**
            org.opensearch.common.io.InputStreamContainer stream1 = streamContext.provideStream(1);
                uploadFailure.set(e);
        when(baseBlobContainer.readBlob("_0.cfs")).thenReturn(mockStream);
            },
    public void testCopyFrom_FileMetadata_NonAsync_ReturnsFalse() throws IOException {
            },
            () -> {},
        // For lucene files
            new ActionListener<>() {
            @Override
    public void testCopyFrom_FileMetadata_Sync() throws IOException {
        // Mock DataFormatRegistry to register "parquet" format
        // Create a real directory with a file that has a valid codec footer
        assertNotNull(input);
            UnaryOperator.identity(),
                    failureRef.set(e);
        );
                latch.countDown();
            logger,
        storeDirectory.close();
        assertSame(parquetBlobContainer, parquetContainer);
    }
        // Register format in cache since DFARD receives plain blob keys
import static org.mockito.Mockito.never;
    // ═══════════════════════════════════════════════════════════════
            completionListener.onResponse(null);
        BlobStore asyncBlobStore = mock(BlobStore.class);
/**
            UnaryOperator.identity(),
            UnaryOperator.identity(),
            null
        input.close();
        assertEquals(200, input.length());
            UnaryOperator.identity(),
        );
        String filename = "_100.si";
        directory.deleteFile(metadata.getUploadedFilename());
import org.opensearch.test.OpenSearchTestCase;
    }
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
        verify(parquetBlobContainer).readBlob("_0.parquet");
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
import org.apache.lucene.index.CorruptIndexException;
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
    // Completion listener tests (via async upload with errors)
        indexOutput.writeString("data");
        AtomicReference<WriteContext> capturedWriteContext = new AtomicReference<>();
            ActionListener<Void> completionListener = invocation.getArgument(1);
            new HashMap<>(),
            downloadRateLimiter,
            baseBlobPath,
        Directory storeDirectory = newDirectory();
    }
        String filename = "_100.si";
        directory.close();
        );
import java.util.concurrent.atomic.AtomicReference;
        baseBlobContainer = mock(BlobContainer.class);
            null
        // With a mock BlobStore, the container may be null, but no exception is thrown
        InputStream mockStream = mock(InputStream.class);
import static org.mockito.ArgumentMatchers.eq;
            logger,
    // Metadata file routing
            uploadCaptureLatch.countDown();
    public void testDeleteFile_MetadataFile() throws IOException {
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
    }
    }
    // ═══════════════════════════════════════════════════════════════
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
    // ═══════════════════════════════════════════════════════════════
        when(parquetBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.parquet"), eq(1), any())).thenReturn(blobList);
            UnaryOperator.identity(),
        input.close();
    }
        assertNotNull("Part 0 stream must be created", stream0);
        indexOutput.writeString("data");
    }
    // fileLength(FileMetadata) Tests
        when(mockStream.read(any(), anyInt(), anyInt())).thenThrow(new IOException("read error"));
        directory.deleteFile("_0.pqt__UUID1");
    public void testDeleteFile_WithUploadedSegmentMetadata_Parquet() throws IOException {
    private DataFormatAwareRemoteDirectory directory;
        when(baseBlobContainer.readBlob("_0.cfs__UUID1")).thenReturn(new ByteArrayInputStream(content));
    private BlobStore mockBlobStore;
        Mockito.doAnswer(invocation -> {
        when(mockStream.read(any(), anyInt(), anyInt())).thenThrow(new IOException("stream error"));
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
    // ═══════════════════════════════════════════════════════════════
            }
            asyncBlobStore,
        assertNotNull(output);
                @Override
        Mockito.doAnswer(invocation -> {
        when(asyncContainer.path()).thenReturn(baseBlobPath);
            null
            new HashMap<>(),
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
            logger,
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
    // ═══════════════════════════════════════════════════════════════
        UnaryOperator<InputStream> downloadRateLimiter = UnaryOperator.identity();
    }
            return null;
        BlobContainer parquetContainer = directory.getBlobContainerForFormat("parquet");
    public void testOpenInput_WithUploadedSegmentMetadata_Lucene() throws IOException {
    public void testFileLength_FileMetadata_NotFound() throws IOException {
                @Override
        // on the SHARED array, causing provideStream(1) to throw AlreadyClosedException in the
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        }
            new ActionListener<>() {
            baseBlobPath,
        String[] allFiles = directory.listAll();
    private BlobPath baseBlobPath;
        indexOutput.writeString("data");
                public void onFailure(Exception e) {
        }, false, null);
    // ═══════════════════════════════════════════════════════════════
        r.run();
            completionListener.onFailure(new RuntimeException(new CorruptIndexException("corrupted", "test")));
            },
    public void testGetBlobContainerForFormat_Metadata() {
import static org.mockito.Mockito.verify;
        when(asyncContainer.path()).thenReturn(baseBlobPath);
            mockBlobStore,
            ActionListener<Void> completionListener = invocation.getArgument(1);
        assertTrue("Should return true (handled)", result);
            null
        verify(parquetBlobContainer, never()).deleteBlobsIgnoringIfNotExists(any());
        BlobStore asyncBlobStore = mock(BlobStore.class);
    private record AsyncDirFixture(DataFormatAwareRemoteDirectory dir, AsyncMultiStreamBlobContainer container, AtomicReference<
            asyncBlobStore,
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
        CountDownLatch latch = new CountDownLatch(1);
    // ═══════════════════════════════════════════════════════════════
    public void testListAll_EmptyContainers() throws IOException {
        when(mockRegistry.getFormatDescriptors(any(IndexSettings.class))).thenReturn(
    }
        assertEquals(1234, length);
            UnaryOperator.identity(),
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet", "parquet");
        // OffsetRangeIndexInputStream constructor's seek() call.
    public void testDeleteFile_WithUploadedSegmentMetadata_Lucene() throws IOException {
    // ═══════════════════════════════════════════════════════════════
import org.opensearch.Version;
        DataFormatAwareRemoteDirectory dirWithMerged = new DataFormatAwareRemoteDirectory(
        when(mockBlobStore.blobContainer(baseBlobPath)).thenReturn(baseBlobContainer);
    public void testFileLength_FileMetadata_Parquet() throws IOException {
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
    // Delete Tests
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString("_0.cfs::_0.cfs__UUID_MERGED::checksum123::100::10");
        // but we can verify that the format routing logic works by testing
            () -> {},
        assertNotNull(input);
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString(
    // fileLength name mismatch tests
        IndexSettings indexSettings = new IndexSettings(metadata, Settings.EMPTY);
import org.opensearch.cluster.metadata.IndexMetadata;
    // ═══════════════════════════════════════════════════════════════
                }
        expectThrows(NoSuchFileException.class, () -> directory.fileLength("nonexistent"));
    public void testDeleteFiles_NullList_NoOp() throws IOException {
        );
        directory.deleteFile("_0.pqt__UUID1");
            UnaryOperator.identity(),
        assertTrue("Should return true when container is AsyncMultiStreamBlobContainer", result);
        when(baseBlobContainer.readBlob("_0.cfs__UUID1")).thenThrow(new IOException("blob read failed"));
            stream2.getInputStream().close();
        );
                }
                }
    }
    }
    }
        UnaryOperator<OffsetRangeInputStream> lowPriorityUploadRateLimiter = UnaryOperator.identity();
            false,
        out.close();
        input.close();
            baseBlobPath,
        );
        input.close();
            false,
                public void onFailure(Exception e) {
import java.util.HashMap;
            asyncBlobStore,
import org.opensearch.common.blobstore.BlobPath;
            .build();
        BlobContainer container = directory.getBlobContainerForFormat("parquet");
                public void onFailure(Exception e) {
    // ═══════════════════════════════════════════════════════════════
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
            new HashMap<>(),
        when(asyncContainer.path()).thenReturn(baseBlobPath);
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
            UnaryOperator.identity(),
        verify(mockComposite).openInput(eq(fm.serialize()), eq(IOContext.DEFAULT));
    public void testGetBlobContainerForFormat_Null() {
        AtomicReference<ActionListener<Void>> capturedListener = new AtomicReference<>();
            IOContext.DEFAULT,
    // ═══════════════════════════════════════════════════════════════
            storeDirectory,
    // ═══════════════════════════════════════════════════════════════
        assertSame("parquet should route to parquet container", parquetBlobContainer, container);
        // Get the StreamContext and serve 3 sequential part streams, closing each before the next.
        when(baseBlobContainer.readBlob("_0.cfs__UUID_MERGED")).thenReturn(new ByteArrayInputStream(content));
import org.mockito.Mockito;
        indexOutput.close();
            UnaryOperator.identity(),
            "_nonexistent.si",
        );
    public void testAsyncCopyFrom_ExceptionDuringUpload_CallsListenerOnFailure() throws Exception {
            null,
        IndexInput input = directory.openInput(metadata.getUploadedFilename(), 100, IOContext.DEFAULT);
        directory.deleteFile("_0.pqt__UUID1");
        // Capture the WriteContext so we can manually call provideStream() on a different thread,
            return null;
                @Override
        );
            mockBlobStore,
            logger,
    // openInput(String, long, IOContext) Tests - Format-aware routing
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
        assertEquals(5678, length);
        org.opensearch.common.io.InputStreamContainer stream0 = streamContext.provideStream(0);
        Map<String, BlobMetadata> parquetBlobs = new HashMap<>();
        assertSame("metadata should route to base container", baseBlobContainer, container);
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
                    fail("Should not fail: " + e.getMessage());
            UnaryOperator.identity(),
        return new AsyncDirFixture(dir, container, writeCtx, listener, latch);
            baseBlobPath,
            asyncBlobStore,
     * Regression: closing one part's stream must NOT prevent other parts from being served.
        IndexInput mockInput = mock(IndexInput.class);
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.pqt__UUID1", "parquet");
    }
        assertEquals(100, input.length());
                public void onFailure(Exception e) {
            UnaryOperator.identity(),
            storeDirectory,
        assertTrue(latch.await(10, TimeUnit.SECONDS));
            UnaryOperator.identity(),
        when(parquetBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.parquet"), eq(1), any())).thenReturn(blobList);
        input.close();
                }
        assertTrue(completionLatch.await(5, TimeUnit.SECONDS));
        CodecUtil.writeFooter(indexOutput);
        IndexInput input = directory.openInput("_0.cfs", 100, IOContext.DEFAULT);
            IOContext.DEFAULT,
        input.close();
            logger,
    public void testFileLength_FileMetadata_NameMismatch_ThrowsNoSuchFile() throws IOException {
        }).when(container).asyncBlobUpload(any(WriteContext.class), any());
            UnaryOperator.identity(),
        directory.deleteFiles(Collections.emptyList());
        AtomicReference<Exception> failureRef = new AtomicReference<>();
            ActionListener<Void> completionListener = invocation.getArgument(1);
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");
        assertNotNull(input);
    }
            logger,
            baseBlobPath,
import org.apache.logging.log4j.LogManager;
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
            null,
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
                @Override
            completionListener.onFailure(new RuntimeException(new CorruptFileException("corrupted", "test_file")));
        expectThrows(NoSuchFileException.class, () -> directory.fileLength(fm.file()));
        String filename = "_100.si";
    }
        DataFormatAwareRemoteDirectory dir = new DataFormatAwareRemoteDirectory(
        assertNotNull(input);
import static org.mockito.ArgumentMatchers.anyInt;
     */
        when(mockComposite.openInput(eq(fm.serialize()), eq(IOContext.DEFAULT))).thenReturn(mockInput);
        directory.deleteFile("metadata__1__2__3");
                    latch.countDown();
    public void testFileLength_NameMismatch_ThrowsNoSuchFile() throws IOException {
 * The OpenSearch Contributors require contributions made to
import java.util.Map;
            null
        assertNotNull(input);
    public void testSyncCopyFrom_RoutesToCorrectContainer() throws IOException {
import org.apache.lucene.store.Directory;
    }
        storeDirectory.close();
    public void testOpenBlockInput_ParquetFile_WithCache() throws IOException {
                    failureRef.set(e);
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeInputStream;
            assertNotNull("Part 1 stream must be created after part 0 closes — slice() fix", stream1);
            lowPriorityDownloadRateLimiter,
        assertEquals(1234, length);
        AtomicReference<ActionListener<Void>> listener = new AtomicReference<>();
            logger,
        indexOutput.writeString("data");
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(eq(Collections.singletonList("_0.pqt__UUID1")));
        input.close();
        assertNotNull(input);
            UnaryOperator.identity(),
        assertSame("null format should route to base container", baseBlobContainer, container);
        );
        assertSame(baseBlobContainer, luceneContainer);
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("nonexistent"), eq(1), any())).thenReturn(Collections.emptyList());
        verify(baseBlobContainer).readBlob("_0.cfs__UUID1");
        Mockito.doAnswer(inv -> {
        storeDirectory.sync(List.of(filename));
        UnaryOperator<InputStream> lowPriorityDownloadRateLimiter = UnaryOperator.identity();
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("_0.cfs__UUID1"));
            ActionListener<Void> completionListener = invocation.getArgument(1);
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.cfs", 1234));
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
        storeDirectory.close();
            new ActionListener<>() {
        );
            }
     * Fix: slice() calls ArrayUtil.copyOfSubArray() for non-full-range slices, giving each part
    // Low priority upload path (content > 15GB triggers low priority)
            null,
            ActionListener<Void> completionListener = invocation.getArgument(1);
        when(parquetBlobContainer.readBlob("_0.parquet")).thenReturn(new ByteArrayInputStream(content));
    }
        CodecUtil.writeFooter(indexOutput);
    // ═══════════════════════════════════════════════════════════════
        indexOutput.close();
            null
        verify(parquetBlobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("_0.parquet__UUID1"));
    public void testDelete_DeletesAllContainers() throws IOException {
            logger,
import static org.mockito.Mockito.mock;
        assertTrue(latch.await(10, TimeUnit.SECONDS));
            IOContext.DEFAULT,
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
    }
            UnaryOperator.identity(),
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");
    }
        );
        storeDirectory.sync(List.of(filename));
        );
        verify(baseBlobContainer, never()).deleteBlobsIgnoringIfNotExists(any());
            () -> {},
            ActionListener<Void> completionListener = invocation.getArgument(1);
        verify(parquetBlobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("_0.parquet"));
                    + e.getMessage()
        when(asyncContainer.path()).thenReturn(baseBlobPath);
     *
        BlobContainer container = directory.getBlobContainerForFormat(null);
        AtomicReference<Exception> failureRef = new AtomicReference<>();
    // ═══════════════════════════════════════════════════════════════
        indexOutput.close();
            UnaryOperator.identity(),
        when(parquetBlobContainer.readBlob("_0.pqt__UUID1", 2, 3)).thenReturn(stream);
        );
            indexSettings
            null
        // Verify parquet container exists before close
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet", "parquet");
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.pqt__UUID1", "parquet");
    // ═══════════════════════════════════════════════════════════════
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
 * this file be licensed under the Apache-2.0 license or a
    // ═══════════════════════════════════════════════════════════════
            new HashMap<>(),
        BlobContainer luceneContainer = directory.getBlobContainerForFormat("lucene");
import org.opensearch.common.blobstore.exception.CorruptFileException;
        // Use fromString() since constructor is package-private
            org.opensearch.common.io.InputStreamContainer stream2 = streamContext.provideStream(2);
    public void testFileLength_LuceneFile() throws IOException {
            storeDirectory,
    }
        input.close();
        when(baseBlobContainer.readBlob("_0.cfs")).thenThrow(new IOException("read error"));
        long length = directory.fileLength(fm.file());
            UnaryOperator.identity(),
        UnaryOperator<OffsetRangeInputStream> uploadRateLimiter = UnaryOperator.identity();
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
    }
        when(baseBlobContainer.readBlob("_0.cfs")).thenReturn(new ByteArrayInputStream(content));
            UnaryOperator.identity(),
            false,
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        // Should write to base container since format is "lucene"
        assertTrue("asyncBlobUpload should be called", uploadCaptureLatch.await(5, TimeUnit.SECONDS));
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet", "parquet");
import static org.mockito.ArgumentMatchers.any;
            IOContext.DEFAULT,
        // baseBlobContainer is NOT AsyncMultiStreamBlobContainer, so should return false
        baseBlobPath = new BlobPath().add("segments").add("data");
        verify(baseBlobContainer, never()).readBlob(anyString());
    // ═══════════════════════════════════════════════════════════════
        String filename = "_100.si";
        assertNotNull(output);
     * OffsetRangeIndexInputStream constructor.
        UnaryOperator<InputStream> lowPriorityRateLimiter = stream -> stream;
                }
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
        asyncDir.copyFrom(storeDirectory, filename, filename, IOContext.DEFAULT, () -> {}, new ActionListener<>() {
        when(store.blobContainer(baseBlobPath)).thenReturn(container);
        verify(parquetBlobContainer).readBlob("_0.parquet");
            IOContext.DEFAULT,
        // baseBlobContainer is used for both the "lucene" format and the inherited base container
        }, false, null);
    }
    public void testDeleteFiles_EmptyList_NoOp() throws IOException {
            filename,
        // simulating the SizeBasedBlockingQ consumer running long after asyncBlobUpload() returns.
        verify(baseBlobContainer).readBlob("_0.cfs");
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("_0.cfs"));
    // ═══════════════════════════════════════════════════════════════
        verify(parquetBlobContainer).deleteBlobsIgnoringIfNotExists(names);
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(eq(Collections.singletonList("_0.pqt__UUID_MISSING")));
            UnaryOperator.identity(),
        Directory storeDirectory = newDirectory();
