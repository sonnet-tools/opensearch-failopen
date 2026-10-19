        IndexMetadata metadata = IndexMetadata.builder("test-index")
        );
        IndexInput input = directory.openInput(fm.file(), 100, IOContext.DEFAULT);  
                @Override  
            indexSettings  
                }  
    // ═══════════════════════════════════════════════════════════════
        assertEquals(100, input.length());  
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);  
    // ═══════════════════════════════════════════════════════════════
                @Override
            mockBlobStore,
    public void testOpenBlockInput_LengthExceedsFileLength_Throws() {
import static org.mockito.Mockito.when;
                    failureRef.set(e);  
        input.close();  
        CodecUtil.writeFooter(indexOutput);  
        );
            }  
        assertSame("LUCENE should route to base container", baseBlobContainer, container);  
        assertSame("null format should route to base container", baseBlobContainer, container);
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch completionLatch = new CountDownLatch(1);
        DataFormatAwareRemoteDirectory dir = new DataFormatAwareRemoteDirectory(
    public void testFileLength_FileMetadata_NameMismatch_ThrowsNoSuchFile() throws IOException {
        storeDirectory.close();
            filename,
        directory.deleteFile("_0.cfs");  
        // The openInput should succeed (it just wraps the stream), but we verify the pattern
        UnaryOperator<InputStream> lowPriorityDownloadRateLimiter = UnaryOperator.identity();
                    + e.getMessage()
        }, false, null);
            .numberOfShards(1)  
        storeDirectory.sync(List.of(filename));
    public void testIndexInputRefCount_StaysOpenWhileProvideStreamInProgress() throws Exception {
        FileMetadata fm = new FileMetadata("parquet", "_0.parquet");  
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
            logger,  
        org.opensearch.core.action.ActionListener<Void> listener = mock(org.opensearch.core.action.ActionListener.class);
    // slice() isolation tests  
            IOContext.DEFAULT,  
        AtomicReference<ActionListener<Void>> capturedListener = new AtomicReference<>();  
        assertNotNull(output);  
        // openInput wraps the stream successfully
            ActionListener<Void> completionListener = invocation.getArgument(1);
        UnaryOperator<InputStream> normalRateLimiter = stream -> stream;  
        indexOutput.close();  
    }
        assertTrue("Should return true (handled)", result);  
     * Fix: slice() calls ArrayUtil.copyOfSubArray() for non-full-range slices, giving each part
    public void testOpenInput_FileMetadata_ExceptionClosesStream() throws IOException {
        verify(baseBlobContainer, never()).readBlob(anyString());
        IndexOutput out = d.createOutput(filename, IOContext.DEFAULT);
            UnaryOperator.identity(),
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.pqt__UUID1", "parquet");
            fail(  
        storeDirectory.close();
            completionListener.onFailure(new RuntimeException(new CorruptIndexException("corrupted", "test")));
     * Root cause: clone() passed the master's segments[] array by reference to MultiSegmentImpl.  
        Mockito.doAnswer(inv -> {
    // ═══════════════════════════════════════════════════════════════  
            null,
            writeCtx.set(inv.getArgument(0));
            UnaryOperator.identity(),
    public void testCopyFrom_FileMetadata_Sync() throws IOException {  
        when(parquetBlobContainer.readBlob("_0.parquet")).thenReturn(new ByteArrayInputStream(content));
            logger,
import org.opensearch.Version;  
        Map<String, BlobMetadata> parquetBlobs = new HashMap<>();
        when(parquetBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.parquet"), eq(1), any())).thenReturn(blobList);
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
    public void testCreateOutput_ParquetFormat() throws IOException {  
        WriteContext writeContext = capturedWriteContext.get();
        CodecUtil.writeFooter(indexOutput);
        // Pass lowPriorityUpload=true
        when(baseBlobContainer.listBlobs()).thenReturn(baseBlobs);  
    }
        when(store.blobContainer(baseBlobPath)).thenReturn(container);  
                }  
            false,
        );
            IOContext.DEFAULT,
    // Delete Tests
            "_0.cfs:::lucene",
                public void onFailure(Exception e) {
        directory.deleteFiles(null);  
        }  
        storeDirectory.close();  
            UnaryOperator.identity(),
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);  
import org.opensearch.common.blobstore.stream.write.WriteContext;
            storeDirectory,  
            }
            null
            mockBlobStore,  
            },  
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
        // With the old clone() approach, closing stream0 would call Arrays.fill(segments, null)
                }  
            () -> {},
        // on the SHARED array, causing provideStream(1) to throw AlreadyClosedException in the  
    // Sync copyFrom(Directory, String, String, IOContext) Tests  
            UnaryOperator.identity(),  
            ActionListener<Void> completionListener = invocation.getArgument(1);  
    }
        AtomicReference<Exception> failureRef = new AtomicReference<>();
    }
        input.close();
        boolean result = asyncDir.copyFrom(
            logger,  
import java.util.concurrent.TimeUnit;
import org.apache.lucene.codecs.CodecUtil;  
        storeDirectory.close();  
import org.opensearch.common.blobstore.BlobStore;  
    // ═══════════════════════════════════════════════════════════════
    }  
                    failureRef.set(e);
            null  
            storeDirectory,
import static org.mockito.Mockito.times;  
        );
            UnaryOperator.identity(),
            capturedListener.set(invocation.getArgument(1));
        IndexInput input = directory.openInput("_0.cfs", 100, IOContext.DEFAULT);  
                }  
            logger,
        long partSize = Math.max(1, writeContext.getFileSize() / 3);
        Mockito.doAnswer(invocation -> {
 * The OpenSearch Contributors require contributions made to  
                }
import org.opensearch.common.blobstore.BlobContainer;  
    // ═══════════════════════════════════════════════════════════════  
        String filename = "_100.si";  
    public void testSyncCopyFrom_LuceneFile_CopiesToBaseContainer() throws IOException {  
            }
        storeDirectory.sync(List.of(filename));  
            false,
        BlobContainer container = directory.getBlobContainerForFormat("parquet");
 *
    }
        boolean result = directory.copyFrom(mockFrom, "_0.cfs", "_0.cfs__UUID", IOContext.DEFAULT, () -> {}, listener, false, null);  
        String filename = "_100.si";  
            UnaryOperator.identity(),  
        assertTrue(str.contains("parquet"));
import org.opensearch.index.store.RemoteIndexOutput;  
    }
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet", "parquet");
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
        } catch (org.apache.lucene.store.AlreadyClosedException e) {
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
            UnaryOperator.identity(),  
        assertEquals("_0.parquet__UUID3", allFiles[1]);
                }
        CodecUtil.writeFooter(indexOutput);
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
        when(baseBlobContainer.readBlob("_0.cfe__UUID1", 0, 5)).thenReturn(stream);
                }  
            ActionListener<Void> completionListener = invocation.getArgument(1);  
        verify(mockFrom).openInput(eq("_0.pqt:::parquet"), any(IOContext.class));
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
            listener,  
            logger,
        input.close();
        // Capture the WriteContext so we can manually call provideStream() on a different thread,  
        IndexInput input = directory.openInput(metadata.getUploadedFilename(), 200, IOContext.DEFAULT);
    public void testAsyncCopyFrom_WithAsyncContainer_ReturnsTrue() throws Exception {  
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet", "parquet");  
    @Override
    public void testOpenInput_FileMetadata_Parquet() throws IOException {
    public void testOpenBlockInput_LuceneFile() throws IOException {
            IOContext.DEFAULT,  
        );
        expectThrows(NoSuchFileException.class, () -> directory.fileLength("nonexistent"));
    public void testClose_ClearsFormatContainers() throws IOException {
        );  
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        indexOutput.close();  
            UnaryOperator.identity(),
            return null;
    }
        assertEquals(100, input.length());
        InputStream mockStream = mock(InputStream.class);  
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
        UnaryOperator<InputStream> lowPriorityRateLimiter = stream -> stream;
                    latch.countDown();
    }
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
        input.close();
        when(asyncContainer.path()).thenReturn(baseBlobPath);
        assertSame(baseBlobContainer, luceneContainer);  
        // Should be sorted  
        BlobContainer container = directory.getBlobContainerForFormat(null);  
                public void onResponse(Void unused) {  
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("nonexistent"), eq(1), any())).thenReturn(Collections.emptyList());
    // FileLength Tests  
        assertTrue(latch.await(10, TimeUnit.SECONDS));
    public void testListAll_AggregatesAllContainers() throws IOException {
            asyncBlobStore,  
            new HashMap<>(),
            completionListener.onResponse(null);
        // Base container has lucene files
        when(baseBlobContainer.readBlob("_0.cfs")).thenThrow(new IOException("read error"));
            asyncBlobStore,  
            UnaryOperator.identity(),
        assertEquals("_0.cfs__UUID1", allFiles[0]);
    public void testToString() {  
            IOContext.DEFAULT,
        directory.getFormatBlobRouter().orElseThrow().replaceBlobFormatCache(Map.of("_0.pqt__UUID1", "parquet"));
    // ═══════════════════════════════════════════════════════════════
        storeDirectory.sync(List.of(filename));
            mockFrom,  
        FileMetadata fm = new FileMetadata("parquet", "_0.parquet");
        assertEquals(100, input.length());
    public void testAsyncCopyFrom_LowPriorityUpload() throws Exception {  
            assertNotNull("Part 1 stream must be created after part 0 closes — slice() fix", stream1);
            null  
    }
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet", "parquet");
        );
        for (int i = 0; i < content.length; i++)
        boolean result = asyncDir.copyFrom(storeDirectory, filename, filename + "__UUID", IOContext.DEFAULT, () -> {
        input.close();  
            logger,
                    failureRef.set(e);
        FileMetadata fm = new FileMetadata("lucene", "nonexistent");  
        // "metadata" format routes to base container
        directory.deleteFiles(names);
    /**  
            UnaryOperator.identity(),
        byte[] content = new byte[200];
        byte[] data = new byte[] { 1, 2, 3, 4, 5 };
            null,
    }  
            () -> {},
    public void testFileLength_FileMetadata_Parquet() throws IOException {
        indexOutput.writeBytes(content, content.length);
    }
            asyncBlobStore,
    public void testOpenInput_WithUploadedSegmentMetadata_Parquet() throws IOException {  
        assertTrue("Should be CorruptIndexException", failureRef.get() instanceof CorruptIndexException);  
        directory.deleteFile("_0.pqt__UUID1");  
            completionListener.onResponse(null);
            UnaryOperator.identity(),
import org.opensearch.index.store.RemoteSegmentStoreDirectory.UploadedSegmentMetadata;
            new ActionListener<>() {
            .numberOfReplicas(0)
    public void testCompletionListener_CorruptIndexException() throws Exception {
    // ═══════════════════════════════════════════════════════════════  
            logger,
        org.opensearch.common.io.InputStreamContainer stream0 = streamContext.provideStream(0);
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.cfs"), eq(1), any())).thenReturn(blobList);
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(1234, length);
            null
        Directory mockFrom = mock(Directory.class);
        IndexInput input = directory.openBlockInput("_0.pqt__UUID1", 2, 3, 10, IOContext.DEFAULT);
        baseBlobPath = new BlobPath().add("segments").add("data");
        when(mockStream.read(any(), anyInt(), anyInt())).thenThrow(new IOException("read error"));
import org.opensearch.core.action.ActionListener;  
    public void testListAll_EmptyContainers() throws IOException {  
import org.apache.lucene.store.IndexOutput;
    }  
            null,
                    latch.countDown();
        IndexInput input = directory.openInput(metadata.getUploadedFilename(), 100, IOContext.DEFAULT);  
    }
    public void testDeleteFile_MetadataFile() throws IOException {
                }
import static org.mockito.ArgumentMatchers.anyInt;
        boolean result = asyncDir.copyFrom(
        verify(parquetBlobContainer).deleteBlobsIgnoringIfNotExists(eq(Collections.singletonList("_0.pqt__UUID1")));
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.cfs_DIFFERENT", 1234));  
        BlobContainer luceneContainer = directory.getBlobContainerForFormat("lucene");
        when(asyncContainer.path()).thenReturn(baseBlobPath);  
        // Mock DataFormatRegistry to register "parquet" format
            asyncBlobStore,
                    latch.countDown();  
    }  
            UnaryOperator.identity(),
        // baseBlobContainer is used for both the "lucene" format and the inherited base container  
    // Format Routing Tests (getBlobContainerForFormat)
            baseBlobPath,
            false,  
        // For lucene files
import org.opensearch.index.engine.dataformat.DataFormatDescriptor;
        CountDownLatch latch = new CountDownLatch(1);
    /**
        org.apache.lucene.store.Directory mockFrom = mock(org.apache.lucene.store.Directory.class);  
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
    }
            asyncBlobStore,
    // ═══════════════════════════════════════════════════════════════
    private BlobContainer baseBlobContainer;  
    // ═══════════════════════════════════════════════════════════════
    public void testGetBlobContainerForFormat_LUCENE_UpperCase() {
            storeDirectory,
        BlobStore asyncBlobStore = mock(BlobStore.class);
            mockFrom,
        storeDirectory.close();
    // openInput(FileMetadata, long, IOContext) Tests
        assertFalse("Should return false when container is not AsyncMultiStreamBlobContainer", result);
                public void onResponse(Void unused) {
    // Edge Case Tests
        verify(baseBlobContainer, never()).deleteBlobsIgnoringIfNotExists(any());
            asyncBlobStore,
        assertEquals(1234, length);
        when(parquetBlobContainer.readBlob("_0.pqt__UUID1", 2, 3)).thenReturn(stream);  
        // Create directory with pending merged segments
            null  
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(eq(Collections.singletonList("_0.pqt__UUID_MISSING")));  
    // ═══════════════════════════════════════════════════════════════  
        assertEquals(100, input.length());
            filename,  
            () -> postUploadInvoked.set(true),
            UnaryOperator.identity(),
            UnaryOperator.identity(),
        CodecUtil.writeFooter(out);  
        IndexInput input = directory.openInput(metadata.getUploadedFilename(), 100, IOContext.DEFAULT);  
        directory.deleteFile("_0.pqt__UUID_MISSING");
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(eq(Collections.singletonList("_0.pqt__UUID1")));
     */
            null,  
        assertNotNull(input);
        indexOutput.close();  
                public void onFailure(Exception e) {  
            "parquet/_0.parquet::_0.parquet__UUID1::checksum123::200::10"
    }
            return null;
                    fail("Should have failed");
            pendingMergedSegments,
    public void testFileLength_LuceneFile() throws IOException {  
    // ═══════════════════════════════════════════════════════════════
            UnaryOperator.identity(),  
    // ═══════════════════════════════════════════════════════════════  
    // ═══════════════════════════════════════════════════════════════
            UnaryOperator.identity(),
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet", "parquet");
        CountDownLatch latch = new CountDownLatch(1);
                    fail("Should not fail: " + e.getMessage());
    // ═══════════════════════════════════════════════════════════════
            .put(IndexMetadata.SETTING_INDEX_UUID, "test-uuid")
            assertNotNull("Part 2 stream must be created after parts 0,1 close — slice() fix", stream2);  
        CountDownLatch latch = new CountDownLatch(1);  
        when(mockStream.read(any(), anyInt(), anyInt())).thenThrow(new IOException("stream error"));
        directory.close();  
    public void testOpenInput_FileMetadata_Lucene() throws IOException {
            public void onResponse(Void unused) {  
    // ═══════════════════════════════════════════════════════════════
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("_0.cfs"));
    }  
            return null;  
    // createOutput Tests - Format-aware routing
        directory.deleteFile("_0.pqt__UUID1");  
    public void testSyncCopyFrom_ParquetFile_CopiesToFormatContainer() throws IOException {  
            UnaryOperator.identity(),
            () -> {},
        AtomicReference<WriteContext> capturedWriteContext = new AtomicReference<>();
        // Verify parquet container exists before close  
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet__UUID1", "parquet");
    public void testOpenInput_FileMetadata_ClosesStreamOnException() throws IOException {
        // With a mock BlobStore, the container may be null, but no exception is thrown
    }  
        storeDirectory.close();  
        long length = directory.fileLength("_0.parquet");  
        assertEquals(200, input.length());  
            .build();
            filename + "__UUID",
            new HashMap<>(),
        assertEquals(0, allFiles.length);
    }  
import java.util.HashMap;
        IndexInput input = directory.openInput(fm.file(), 100, IOContext.DEFAULT);  
        when(mockRegistry.getFormatDescriptors(any(IndexSettings.class))).thenReturn(
            UnaryOperator.identity(),  
    public void testFileLength_FileMetadata_NotFound() throws IOException {
    // ═══════════════════════════════════════════════════════════════
        // Identity rate limiters (no-op)
        directory = new DataFormatAwareRemoteDirectory(
        // asyncBlobUpload calls onFailure with a wrapped CorruptIndexException
            baseBlobPath,  
        indexOutput.writeString("data");  
        directory.deleteFiles(Collections.emptyList());  
                completionLatch.countDown();
            filename,
        when(baseBlobContainer.readBlob("_0.cfs")).thenReturn(new ByteArrayInputStream(content));
    // ═══════════════════════════════════════════════════════════════
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
    // ═══════════════════════════════════════════════════════════════  
        storeDirectory.close();
        when(mockInput.length()).thenReturn(10L);  
        // the getBlobContainerForFormat that copyFrom uses internally.
            filename + "__UUID",  
                latch.countDown();
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);  
            UnaryOperator.identity(),
            "_0.cfs__UUID",
            logger,  
        );  
        when(mockFrom.openInput(eq("_0.pqt:::parquet"), any(IOContext.class))).thenReturn(mockInput);
    // ═══════════════════════════════════════════════════════════════  
        assertTrue(postUploadInvoked.get());
            listener.set(inv.getArgument(1));  
    // ═══════════════════════════════════════════════════════════════
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
    private static final Logger logger = LogManager.getLogger(DataFormatAwareRemoteDirectoryTests.class);  
        BlobStore asyncBlobStore = mock(BlobStore.class);
            false,  
            },
        long length = directory.fileLength(fm.file());
            baseBlobPath,
    public void testGetBlobContainerForFormat_UnregisteredFormat_CreatesLazily() {
            stream2.getInputStream().close();
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        assertNotNull(directory.getBlobContainerForFormat("parquet"));
    // ═══════════════════════════════════════════════════════════════  
        when(parquetBlobContainer.listBlobs()).thenReturn(parquetBlobs);
            null,
        stream0.getInputStream().close();  // closes part 0's independent slice — must NOT affect parts 1,2
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);  
        when(baseBlobContainer.readBlob("_0.cfs")).thenReturn(new ByteArrayInputStream(content));
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
            UnaryOperator.identity(),  
        IndexInput mockInput = mock(IndexInput.class);
            storeDirectory,
import static org.mockito.Mockito.mock;
            IOContext.DEFAULT,
    public void testFileLength_FileMetadata_Lucene() throws IOException {
            storeDirectory,  
            () -> {},
        Directory mockFrom = mock(Directory.class);
                public void onResponse(Void unused) {
        assertNotNull("Part 0 stream must be created", stream0);  
    // ═══════════════════════════════════════════════════════════════  
        assertNotNull(input);
        Mockito.doAnswer(invocation -> {  
    // ═══════════════════════════════════════════════════════════════
    public void testOpenInput_UploadedSegmentMetadata_ExceptionClosesStream() throws IOException {
    }
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(  
        assertSame("lucene should route to base container", baseBlobContainer, container);
        );
        }).when(container).asyncBlobUpload(any(WriteContext.class), any());  
        CodecUtil.writeFooter(indexOutput);
    // ═══════════════════════════════════════════════════════════════  
    public void testCompletionListener_GenericException() throws Exception {
        d.sync(List.of(filename));
    public void testCreateOutput_LuceneFormat() throws IOException {
        when(mockFrom.openInput(anyString(), any())).thenThrow(new IOException("open failed"));  
        super.setUp();
    private BlobStore mockBlobStore;
        verify(parquetBlobContainer).readBlob("_0.parquet__UUID1");  
    }  
     */
            baseBlobPath,
import java.util.concurrent.CountDownLatch;
            return null;
        // Make openInput throw an exception
        BlobContainer parquetContainer = directory.getBlobContainerForFormat("parquet");  
import org.apache.lucene.store.IndexInput;
            baseBlobPath,
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        verify(baseBlobContainer, never()).readBlob(anyString());
            null,
        String filename = "_100.si";
        when(mockBlobStore.blobContainer(baseBlobPath)).thenReturn(baseBlobContainer);
        IndexSettings indexSettings = new IndexSettings(metadata, Settings.EMPTY);  
        // asyncBlobUpload calls onFailure with a wrapped CorruptFileException  
        when(parquetBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.parquet"), eq(1), any())).thenReturn(blobList);
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(eq(Collections.singletonList("_0.pqt__UUID1")));  
        when(asyncContainer.path()).thenReturn(baseBlobPath);
    // ═══════════════════════════════════════════════════════════════
            return null;
    // Low priority upload path (content > 15GB triggers low priority)  
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");
    }
    }
        Directory storeDirectory = newDirectory();  
        InputStream mockStream = mock(InputStream.class);
import org.opensearch.index.store.checksum.GenericCRC32ChecksumHandler;
import static org.mockito.ArgumentMatchers.any;  
    public void testGetBlobContainerForFormat_Empty() {
            "parquet/_0.parquet::_0.parquet__UUID1::checksum456::200::10"  
    public void testOpenBlockInput_ParquetFile_WithCache() throws IOException {
    public void testDeleteFiles_BatchDelete_DeletesFromAllContainers() throws IOException {
        assertNotNull(input);  
        assertTrue("Should be CorruptIndexException", failureRef.get() instanceof CorruptIndexException);
            lowPriorityRateLimiter,  
    public void testDeleteFiles_NullList_NoOp() throws IOException {
    }
import static org.mockito.Mockito.never;
        // When opening a merged segment, the low-priority rate limiter should be used
                "AlreadyClosedException must NOT be thrown after a prior part stream closes. "
        Directory storeDirectory = newDirectory();
    }
    }  
    public void setUp() throws Exception {  
    }  
    }  
        verify(baseBlobContainer).readBlob("_0.cfs__UUID1");
            logger,  
    // ═══════════════════════════════════════════════════════════════
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("nonexistent"), eq(1), any())).thenReturn(Collections.emptyList());
        // FormatBlobRouter lazily creates containers for unknown formats via computeIfAbsent  
    // fileLength name mismatch tests
        BlobStore asyncBlobStore = mock(BlobStore.class);
    // ═══════════════════════════════════════════════════════════════
    public void testCopyFrom_FileMetadata_NonAsync_ReturnsFalse() throws IOException {
            .build();  
    }  
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");
     *
        expectThrows(IOException.class, () -> directory.openInput(fm.file(), 100, IOContext.DEFAULT));
    // ═══════════════════════════════════════════════════════════════
                @Override
            "_nonexistent.si",
    // ═══════════════════════════════════════════════════════════════  
        Mockito.doAnswer(invocation -> {  
        // File does not exist - openInput will throw  
            UnaryOperator.identity(),
import java.util.Map;  
        verify(parquetBlobContainer).deleteBlobsIgnoringIfNotExists(names);
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(true);
        assertNotNull(input);  
            public void onFailure(Exception e) {
                }
                    fail("Should not succeed");  
        assertNotNull(input);
            false,
        directory.deleteFile("metadata__1__2__3");
    }
            new HashMap<>(),
 * SPDX-License-Identifier: Apache-2.0
            new HashMap<>(),
        // After close, the directory is closed but FormatBlobRouter still lazily creates containers
            baseBlobPath,
        directory.deleteFile("_0.pqt__UUID1");
import java.util.Collections;  
        boolean result = asyncDir.copyFrom(
                public void onResponse(Void unused) {
    public void testReplaceBlobFormatCache() throws IOException {
            null  
        String filename = "_100.si";
        baseBlobs.put("_0.si__UUID2", new PlainBlobMetadata("_0.si__UUID2", 50));
    public void testConstructor_NullDataFormatRegistry() {
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString("_0.cfs::_0.cfs__UUID1::checksum123::100::10");  
            UnaryOperator.identity(),  
        IndexInput input = directory.openBlockInput("_0.cfe__UUID1", 0, 5, 5, IOContext.DEFAULT);  
    }
    public void testFileLength_ParquetFile() throws IOException {
    public void testGetBlobContainerForFormat_Lucene() {
            },
            logger,
        expectThrows(NoSuchFileException.class, () -> directory.fileLength("_0.cfs"));
        directory.deleteFile("_0.parquet");  
        );
    // ═══════════════════════════════════════════════════════════════
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");
        // Write enough bytes to ensure multipart upload (content > 0)  
        CodecUtil.writeFooter(indexOutput);  
        parquetBlobContainer = mock(BlobContainer.class);
            baseBlobPath,  
            () -> {},
    // ═══════════════════════════════════════════════════════════════
    // IndexInput ref-count exhaustion Tests
        when(baseBlobContainer.readBlob("_0.cfs__UUID1")).thenReturn(new ByteArrayInputStream(content));
import org.apache.lucene.store.Directory;
    // ═══════════════════════════════════════════════════════════════
        Directory d = newDirectory();  
    }
                completionLatch.countDown();
        // UUID-suffixed key not in cache — should warn and default to lucene
        when(baseBlobContainer.readBlob("_0.cfs")).thenThrow(new IOException("blob read failed"));  
    public void testOpenInput_StringBased_ParquetFile_WithFormatSuffix() throws IOException {
        String filename = "_100.si";
        byte[] content = new byte[200];  
    public void testGetBlobContainerForFormat_Null() {
        input.close();
            UnaryOperator.identity(),  
            asyncBlobStore,
            baseBlobPath,
        when(parquetBlobContainer.readBlob("_0.parquet__UUID1")).thenReturn(new ByteArrayInputStream(content));
        assertFalse(result);  
            UnaryOperator.identity(),
    public void testGetBlobContainerForFormat_Parquet() {  
    }  
import java.io.ByteArrayInputStream;
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.pqt__UUID1", "parquet");  
    }
        // Should not throw with null DataFormatRegistry and IndexSettings
        storeDirectory.sync(List.of(filename));  
                    failureRef.set(e);
            downloadRateLimiter,
        assertSame("metadata should route to base container", baseBlobContainer, container);
            return null;  
            UnaryOperator.identity(),
            org.opensearch.common.io.InputStreamContainer stream1 = streamContext.provideStream(1);
        // Unregister — should fall back to lucene  
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
            UnaryOperator.identity(),
        when(mockInput.length()).thenReturn(20L);  
        when(asyncContainer.path()).thenReturn(baseBlobPath);
    }
            new ActionListener<>() {  
                @Override  
            @Override
    public void testAsyncCopyFrom_ExceptionHandling() throws IOException {
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.cfs"), eq(1), any())).thenReturn(blobList);
            new HashMap<>(),  
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);  
    public void testOpenInput_StringBased_LuceneFile() throws IOException {
import org.opensearch.common.blobstore.BlobPath;
            return null;
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
        when(asyncContainer.path()).thenReturn(baseBlobPath);  
        assertTrue("asyncBlobUpload should be called", uploadCaptureLatch.await(5, TimeUnit.SECONDS));
        expectThrows(IllegalArgumentException.class, () -> directory.openBlockInput("_0.cfe__UUID1", 5, 10, 10, IOContext.DEFAULT));  
 */  
        RemoteIndexOutput output = directory.createOutput("test_file.parquet", "parquet", IOContext.DEFAULT);
            lowPriorityDownloadRateLimiter,
            @Override
        when(mockBlobStore.blobContainer(baseBlobPath.parent().add("parquet"))).thenReturn(parquetBlobContainer);
        CountDownLatch uploadCaptureLatch = new CountDownLatch(1);
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
        assertTrue(result);  
        assertNotNull(input);  
        return d;  
                public void onFailure(Exception e) {  
            "_0.cfs",              // src (lucene format, no :::)
        assertTrue(result);  
        // Initially no cache entries — deleteFile for a UUID key defaults to lucene (base container)  
            "_nonexistent.si__UUID",
        // baseBlobContainer is called from super.deleteFiles + lucene format container (same instance)  
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString(
        when(asyncContainer.path()).thenReturn(baseBlobPath);
        directory.copyFrom(mockFrom, "_0.pqt:::parquet", "_0.pqt__UUID", IOContext.DEFAULT);  
        assertTrue(completionLatch.await(5, TimeUnit.SECONDS));  
import org.opensearch.index.IndexSettings;
        BlobStore store = mock(BlobStore.class);
        AtomicReference<Exception> failureRef = new AtomicReference<>();
        // Returns a blob but name doesn't match  
    }
        verify(mockFrom).openInput(eq("_0.cfs"), any(IOContext.class));  
    public void testDeleteFile_LuceneFile() throws IOException {
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);  
    // ═══════════════════════════════════════════════════════════════  
        );  
 */  
        expectThrows(NoSuchFileException.class, () -> directory.fileLength(fm.file()));  
    }
        BlobStore asyncBlobStore = mock(BlobStore.class);
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.cfs"), eq(1), any())).thenReturn(blobList);
        org.apache.lucene.store.Directory mockFrom = mock(org.apache.lucene.store.Directory.class);
    public void testDeleteFile_ParquetFile_WithFormatSuffix() throws IOException {  
    // deleteFile(UploadedSegmentMetadata) - Lucene metadata  
import org.opensearch.test.OpenSearchTestCase;  
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);  
            UnaryOperator.identity(),
import org.opensearch.common.blobstore.support.PlainBlobMetadata;  
        assertSame("parquet should route to parquet container", parquetBlobContainer, container);
        assertNoException(() -> directory.getBlobContainerForFormat("arrow"));
            filename + "__UUID",
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();
            UnaryOperator.identity(),  
        try {  
            UnaryOperator.identity(),  
    }  
    }  
import java.io.InputStream;
            org.opensearch.common.io.InputStreamContainer stream2 = streamContext.provideStream(2);
    }  
        Map<String, String> pendingMergedSegments = new HashMap<>();  
                }
            mockRegistry,
        // Register format in cache since DFARD receives plain blob keys
            uploadRateLimiter,
            mockBlobStore,
     * When any clone closed, Arrays.fill(segments, null) corrupted the shared array, causing
        assertTrue("Should return true when container is AsyncMultiStreamBlobContainer", result);  
        assertTrue("Should be IOException", failureRef.get() instanceof IOException);
    // ═══════════════════════════════════════════════════════════════
    }  
    // ═══════════════════════════════════════════════════════════════  
            UnaryOperator.identity(),
            logger,
    // ═══════════════════════════════════════════════════════════════  
        );
        // but we can verify that the format routing logic works by testing
        assertTrue(result);
        when(asyncContainer.path()).thenReturn(baseBlobPath);  
        Map<String, BlobMetadata> baseBlobs = new HashMap<>();  
        org.opensearch.core.action.ActionListener<Void> listener = mock(org.opensearch.core.action.ActionListener.class);  
        r.run();  
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());  
    // openBlockInput Tests
public class DataFormatAwareRemoteDirectoryTests extends OpenSearchTestCase {
        // Register format in cache since DFARD receives plain blob keys
            null
        indexOutput.writeString("data");  
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
            store,  
        expectThrows(IOException.class, () -> directory.openInput("_0.cfs", 100, IOContext.DEFAULT));  
            null
        boolean result = directory.copyFrom(  
            null  
        storeDirectory.sync(List.of(filename));
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString(  
            completionListener.onFailure(new IOException("network error"));
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());  
        mockBlobStore = mock(BlobStore.class);
    public void testOpenBlockInput_InvalidPosition_Throws() {
        asyncDir.copyFrom(storeDirectory, filename, filename, IOContext.DEFAULT, () -> {}, new ActionListener<>() {
        assertNotNull(input);
        verify(mockComposite).openInput(eq(fm.serialize()), eq(IOContext.DEFAULT));
    }  
                    fail("Should not fail: " + e.getMessage());
            true,  // lowPriorityUpload
import org.apache.logging.log4j.Logger;
            new HashMap<>(),  
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
        Mockito.doAnswer(invocation -> {  
        Settings indexSettingsBuilder = Settings.builder()  
            UnaryOperator.identity(),
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
            filename,
        boolean result = asyncDir.copyFrom(  
import java.util.function.UnaryOperator;
            baseBlobPath,
        assertNotNull(input);
            UnaryOperator.identity(),  
        directory.deleteFile(metadata.getUploadedFilename());  
        );  
        byte[] data = new byte[] { 10, 20, 30 };
        input.close();
    // ═══════════════════════════════════════════════════════════════
}  
     * Helper: builds an AsyncDir backed by an AsyncMultiStreamBlobContainer that captures the
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);  
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
        org.opensearch.common.StreamContext streamContext = writeContext.getStreamProvider(partSize);  
 * Unit tests for {@link DataFormatAwareRemoteDirectory}.
        CountDownLatch latch = new CountDownLatch(1);
            },  
        );
    }
            null
    }
        byte[] content = new byte[200];
            throw new RuntimeException("postUpload error");
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
    // Completion listener tests (via async upload with errors)
        when(baseBlobContainer.readBlob("_0.cfs")).thenReturn(mockStream);
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeInputStream;
            null,
            null,
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
            new HashMap<>(),  
        BlobStore asyncBlobStore = mock(BlobStore.class);  
        indexOutput.writeString("Hello World!");
    // ═══════════════════════════════════════════════════════════════  
            completionListener.onResponse(null);
        BlobContainer container = directory.getBlobContainerForFormat("LUCENE");
    public void testAsyncCopyFrom_NonAsyncContainer_ReturnsFalse() throws IOException {
    public void testResolveFormat_CacheMiss_DefaultsToLucene() throws IOException {  
                @Override  
    // Lifecycle Tests
        // Even with exception, it should not propagate but call listener.onFailure
        InputStream mockStream = mock(InputStream.class);
    }
            () -> {},
                    latch.countDown();
            null,  
        boolean result = directory.copyFrom(
        indexOutput.writeString("data");
        directory.delete();
        IndexInput input = dirWithMerged.openInput(metadata.getUploadedFilename(), 100, IOContext.DEFAULT);
        WriteContext> writeCtx, AtomicReference<ActionListener<Void>> listener, java.util.concurrent.CountDownLatch captureLatch) {  
                    latch.countDown();
        AtomicReference<Boolean> postUploadInvoked = new AtomicReference<>(false);
import org.mockito.Mockito;
        indexOutput.writeString("data");
        BlobStore asyncBlobStore = mock(BlobStore.class);
    }
        Directory storeDirectory = newDirectory();
            "_0.cfs__UUID",        // remoteFileName  
        assertFalse("Should return false when base container is not AsyncMultiStreamBlobContainer", result);
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString("_0.cfs::_0.cfs__UUID1::checksum123::100::10");
        // Replace cache with parquet mapping
    }
        out.close();
            storeDirectory,  
        input.close();  
            content[i] = (byte) i;  
        assertTrue(str.contains("DataFormatAwareRemoteDirectory"));  
        assertEquals(200, input.length());
        String filename = "_100.si";
            normalRateLimiter,
                uploadFailure.set(e);  
        assertEquals(3, allFiles.length);
        AtomicReference<Exception> failureRef = new AtomicReference<>();  
        assertNotNull(input);
            completionListener.onFailure(new RuntimeException(new CorruptFileException("corrupted", "test_file")));  
            IOContext.DEFAULT,  
import java.io.IOException;  
                    latch.countDown();  
    // DownloadRateLimiterProvider merged segment path
        Mockito.doAnswer(invocation -> {
        );
                public void onFailure(Exception e) {
        assertTrue(result);
        storeDirectory.sync(List.of(filename));
        BlobStore asyncBlobStore = mock(BlobStore.class);
import java.util.List;
    // List Tests
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");
    }
        // Get the StreamContext and serve 3 sequential part streams, closing each before the next.
import static org.mockito.ArgumentMatchers.anyString;
        verify(parquetBlobContainer).readBlob("_0.parquet");
    // Blob Format Cache Tests
            null  
        verify(baseBlobContainer, times(2)).deleteBlobsIgnoringIfNotExists(names);
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);  
        // OffsetRangeIndexInputStream constructor's seek() call.
            public void onResponse(Void unused) {
 * compatible open source license.
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("metadata__1__2__3"));
            UnaryOperator.identity(),
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet__UUID1", "parquet");  
        byte[] content = new byte[100];  
    // openInput(UploadedSegmentMetadata) - Exception closes stream
    // openInput exception close-on-failure (stream opened but readBlob fails)
        UnaryOperator<InputStream> downloadRateLimiter = UnaryOperator.identity();
                @Override
        List<String> names = List.of("_0.cfs__UUID1", "_0.parquet__UUID2");  
    }
    }
    public void testCompletionListener_PostUploadRunnerException() throws Exception {
    // ═══════════════════════════════════════════════════════════════
                @Override
    // ═══════════════════════════════════════════════════════════════
    // Async copyFrom Tests (8-arg version, returns boolean)
        indexOutput.close();
                }  
    public void testOpenInput_StringBased_ClosesStreamOnException() throws IOException {  
            new ActionListener<>() {
    public void testDeleteFile_WithUploadedSegmentMetadata_Parquet() throws IOException {
        verify(parquetBlobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("_0.parquet"));
        // simulating the SizeBasedBlockingQ consumer running long after asyncBlobUpload() returns.
    public void testFileLength_NameMismatch_ThrowsNoSuchFile() throws IOException {
    public void testFileLength_FileNotFound() throws IOException {
        verify(parquetBlobContainer).delete();
            capturedWriteContext.set(invocation.getArgument(0));
        assertEquals(5678, length);
        Directory storeDirectory = newDirectory();
        indexOutput.close();
        Directory storeDirectory = newDirectory();
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
        when(container.remoteIntegrityCheckSupported()).thenReturn(true);
        assertNotNull(input);
        String filename = "_segment.bin";
        parquetBlobs.put("_0.parquet__UUID3", new PlainBlobMetadata("_0.parquet__UUID3", 200));  
                @Override
            null  
        when(baseBlobContainer.readBlob("_0.cfs__UUID1")).thenThrow(new IOException("blob read failed"));
        );  
    // ═══════════════════════════════════════════════════════════════
import org.opensearch.index.store.DataFormatAwareStoreDirectory;
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString("_0.cfs::_0.cfs__UUID1::checksum123::100::10");  
        String[] allFiles = directory.listAll();  
    }  
    private AsyncDirFixture buildAsyncFixture() throws Exception {  
import static org.mockito.ArgumentMatchers.eq;  
        // The important thing is that close() doesn't throw  
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
        when(mockStream.read(any(), anyInt(), anyInt())).thenThrow(new IOException("read error"));  
            logger,
        assertSame(parquetBlobContainer, parquetContainer);
        org.opensearch.core.action.ActionListener<Void> listener = mock(org.opensearch.core.action.ActionListener.class);  
            UnaryOperator.identity(),
    }  
        );
                }
            null
    }
    // fileLength(FileMetadata) Tests
        AtomicReference<ActionListener<Void>> listener = new AtomicReference<>();
        org.apache.lucene.store.Directory mockFrom = mock(org.apache.lucene.store.Directory.class);
            );
        byte[] content = new byte[100];
                    fail("Should not succeed");
        // Register format so resolveFormat routes to parquet container
    // ═══════════════════════════════════════════════════════════════  
        verify(baseBlobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("_0.cfs__UUID1"));
        verify(baseBlobContainer).readBlob("_0.cfs");
        );  
                    fail("Should not succeed");
                @Override  
        when(mockFrom.openInput(eq("_0.cfs"), any(IOContext.class))).thenReturn(mockInput);
     *
            UnaryOperator.identity(),
     * Regression: closing one part's stream must NOT prevent other parts from being served.
        boolean result = asyncDir.copyFrom(  
            false,
        );  
            lowPriorityUploadRateLimiter,  
    public void testDeleteFiles_EmptyList_NoOp() throws IOException {
    public void testGetBlobContainerForFormat_Metadata() {  
        // Use fromString() since constructor is package-private
            latch.countDown();
        byte[] content = new byte[100];  
        CountDownLatch latch = new CountDownLatch(1);  
            UnaryOperator.identity(),
        BlobStore asyncBlobStore = mock(BlobStore.class);
                    + "This is the Arrays.fill(segments,null) shared-array corruption bug that "
        verify(parquetBlobContainer).deleteBlobsIgnoringIfNotExists(eq(Collections.singletonList("_0.pqt__UUID1")));
        }, new ActionListener<>() {  
        out.writeBytes(new byte[dataBytes], dataBytes);
        baseBlobs.put("_0.cfs__UUID1", new PlainBlobMetadata("_0.cfs__UUID1", 100));
        CodecUtil.writeFooter(indexOutput);
        BlobContainer container = directory.getBlobContainerForFormat("metadata");
import static org.mockito.Mockito.verify;
    // Metadata file routing
        // baseBlobContainer is NOT AsyncMultiStreamBlobContainer, so should return false
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString("_0.cfs::_0.cfs__UUID_MERGED::checksum123::100::10");
            new HashMap<>(),
        // With slice(), each part has its own independent segments[] copy — closing one never
        long length = directory.fileLength("_0.cfs");
    public void testDelete_DeletesAllContainers() throws IOException {
            },
            new ActionListener<>() {
        // Create a real directory with a file that has a valid codec footer  
        DataFormatRegistry mockRegistry = mock(DataFormatRegistry.class);
        return new AsyncDirFixture(dir, container, writeCtx, listener, latch);
            ActionListener<Void> completionListener = invocation.getArgument(1);
        // Set up async upload to call onResponse
        assertTrue(latch.await(10, TimeUnit.SECONDS));  
            () -> {},  
            }
        // asyncBlobUpload calls onFailure with a generic exception (not corrupt)
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
            new HashMap<>(),  
                @Override
    public void testSyncCopyFrom_RoutesToCorrectContainer() throws IOException {
    // ═══════════════════════════════════════════════════════════════
            Map.of("parquet", (Supplier<DataFormatDescriptor>) () -> new DataFormatDescriptor("parquet", new GenericCRC32ChecksumHandler()))
        }, false, null);  
        directory.deleteFile(metadata.getUploadedFilename());
        Directory storeDirectory = newDirectory();  
    }  
            UnaryOperator.identity(),
    }  
        storeDirectory.close();
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.cfs", 1234));
    }
        when(parquetBlobContainer.readBlob("_0.parquet")).thenReturn(new ByteArrayInputStream(content));
     * OffsetRangeIndexInputStream constructor.  
        CountDownLatch latch = new CountDownLatch(1);
            UnaryOperator.identity(),  
    // Sync CopyFrom Tests
    public void testOpenInput_WithUploadedSegmentMetadata_Lucene() throws IOException {  
        // We can't easily test the full copyFrom without a real Directory,  
        // Create an async blob container
    }
            false,
        when(asyncContainer.path()).thenReturn(baseBlobPath);
    }  
            },
        verify(parquetBlobContainer).deleteBlobsIgnoringIfNotExists(Collections.singletonList("_0.parquet__UUID1"));
        when(baseBlobContainer.listBlobs()).thenReturn(Collections.emptyMap());
        DataFormatAwareStoreDirectory mockComposite = mock(DataFormatAwareStoreDirectory.class);
        String str = directory.toString();
        assertEquals(5678, length);
        DataFormatAwareRemoteDirectory dir = new DataFormatAwareRemoteDirectory(  
        IndexInput input = directory.openInput("_0.cfs", 100, IOContext.DEFAULT);
        AtomicReference<Exception> failureRef = new AtomicReference<>();  
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");  
    private Directory buildFileDir(String filename, int dataBytes) throws IOException {
import java.util.concurrent.atomic.AtomicReference;  
            uploadCaptureLatch.countDown();  
        indexOutput.close();
    // ═══════════════════════════════════════════════════════════════  
        indexOutput.writeString("data");
import java.nio.file.NoSuchFileException;
        Mockito.doAnswer(invocation -> {  
        storeDirectory.sync(List.of(filename));
        when(baseBlobContainer.readBlob("_0.cfs__UUID1")).thenReturn(mockStream);  
            baseBlobPath,  
    }
    }
            UnaryOperator.identity(),
        directory.getFormatBlobRouter().orElseThrow().registerBlobFormat("_0.parquet", "parquet");
            @Override
        BlobContainer container = directory.getBlobContainerForFormat("lucene");  
            @Override  
            UnaryOperator.identity(),
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
            baseBlobPath,  
    // ═══════════════════════════════════════════════════════════════
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.parquet", 5678));
                fail("Should not succeed");  
import org.apache.lucene.index.CorruptIndexException;
            null
            ActionListener<Void> completionListener = invocation.getArgument(1);
            IOContext.DEFAULT,
        DataFormatAwareRemoteDirectory dirWithMerged = new DataFormatAwareRemoteDirectory(  
    // Async copyFrom with AsyncMultiStreamBlobContainer Tests  
        Mockito.doAnswer(invocation -> {
        );
        UnaryOperator<OffsetRangeInputStream> uploadRateLimiter = UnaryOperator.identity();
            null,
                public void onResponse(Void unused) {
        assertNotNull(input);
            new HashMap<>(),  
            null
                public void onResponse(Void unused) {
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
        pendingMergedSegments.put("localFile", "_0.cfs__UUID_MERGED");
        when(baseBlobContainer.readBlob("_0.cfs")).thenReturn(mockStream);
        byte[] content = new byte[100];  
    }
        when(mockComposite.openInput(eq(fm.serialize()), eq(IOContext.DEFAULT))).thenReturn(mockInput);  
import org.opensearch.index.store.FileMetadata;
            filename + "__UUID",
        verify(baseBlobContainer).readBlob("_0.cfs");
            .settings(indexSettingsBuilder)
    public void testOpenInput_StringBased_StreamClosedWhenInputStreamReadFails() throws IOException {
            new ActionListener<>() {
        // Should write to base container since format is "lucene"
        directory.deleteFile("_0.pqt__UUID1");
        verify(parquetBlobContainer, never()).readBlob(anyString());  
    // ═══════════════════════════════════════════════════════════════
            new ActionListener<>() {  
        );
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
        // affects others.  
        input.close();  
    private static void assertNoException(Runnable r) {
        capturedListener.get().onResponse(null);
        assertEquals("_0.si__UUID2", allFiles[2]);  
        when(baseBlobContainer.listBlobsByPrefixInSortedOrder(eq("_0.cfs"), eq(1), any())).thenReturn(blobList);
        expectThrows(IllegalArgumentException.class, () -> directory.openBlockInput("_0.cfe__UUID1", -1, 5, 10, IOContext.DEFAULT));
        expectThrows(IOException.class, () -> directory.openInput(metadata.getUploadedFilename(), 100, IOContext.DEFAULT));  
        // For parquet files
        String[] allFiles = directory.listAll();  
        // Wire up blobStore to return async container for base path  
        long length = directory.fileLength(fm.file());  
    // openInput(String, long, IOContext) Tests - Format-aware routing
        assertTrue(result);
        assertNotNull(dir);  
package org.opensearch.index.store.remote;
        AtomicReference<WriteContext> writeCtx = new AtomicReference<>();  
        BlobContainer container = directory.getBlobContainerForFormat("");
    private BlobPath baseBlobPath;
        CodecUtil.writeFooter(indexOutput);
    // ═══════════════════════════════════════════════════════════════
    }
        Directory storeDirectory = newDirectory();
                public void onFailure(Exception e) {  
    // ═══════════════════════════════════════════════════════════════
            new HashMap<>(),
        );  
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
        // openInput wraps the stream, reading from it will fail
            stream1.getInputStream().close();  
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);
            filename,  
    }
    // FileMetadata-based copyFrom (non-async) - returns false when not async
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.cfs_DIFFERENT", 1234));
    }  
        when(asyncContainer.remoteIntegrityCheckSupported()).thenReturn(false);
        IndexInput input = directory.openInput(fm.file(), 200, IOContext.DEFAULT);
        AsyncMultiStreamBlobContainer asyncContainer = mock(AsyncMultiStreamBlobContainer.class);  
    // ═══════════════════════════════════════════════════════════════
/**
            null
        assertTrue(latch.await(10, TimeUnit.SECONDS));  
    }
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
    private DataFormatAwareRemoteDirectory directory;  
/*  
     * its own independent segments[] copy. Closing one part only nullifies its own array.  
import org.apache.lucene.store.IOContext;  
            UnaryOperator.identity(),
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.parquet", 5678));  
        verify(parquetBlobContainer, never()).deleteBlobsIgnoringIfNotExists(any());  
    // ═══════════════════════════════════════════════════════════════  
        directory.copyFrom(mockComposite, fm.serialize(), "_0.cfs__UUID", IOContext.DEFAULT);  
        Directory storeDirectory = newDirectory();  
            filename,
        verify(baseBlobContainer, never()).readBlob(anyString());  
    }  
        // Returns false because baseBlobContainer is not AsyncMultiStreamBlobContainer
        when(mockInput.length()).thenReturn(50L);
            IOContext.DEFAULT,  
        FileMetadata fm = new FileMetadata("lucene", "_0.cfs");
     * AlreadyClosedException on all subsequent provideStream() calls during seek() in the
        assertNotNull(failureRef.get());
            baseBlobPath,
    public void testDeleteFile_WithUploadedSegmentMetadata_Lucene() throws IOException {  
        assertNotNull(output);  
    // ═══════════════════════════════════════════════════════════════  
    // ═══════════════════════════════════════════════════════════════
    public void testDownloadRateLimiter_MergedSegment_UsesLowPriorityRateLimiter() throws IOException {
        when(baseBlobContainer.readBlob("_0.cfs__UUID_MERGED")).thenReturn(new ByteArrayInputStream(content));  
        // Write a real file with codec footer (required for checksum computation)
            asyncBlobStore,  
    // ═══════════════════════════════════════════════════════════════  
    public void testOpenInput_ClosesStream_OnFailure() throws IOException {
        assertNotNull(input);
        InputStream stream = new ByteArrayInputStream(data);  
    private BlobContainer parquetBlobContainer;
        );
        UnaryOperator<OffsetRangeInputStream> lowPriorityUploadRateLimiter = UnaryOperator.identity();  
            null
import org.opensearch.common.blobstore.exception.CorruptFileException;
                    + "slice() fixes. Exception: "  
            return null;  
        boolean result = asyncDir.copyFrom(
        byte[] content = new byte[1024];
        when(asyncBlobStore.blobContainer(baseBlobPath)).thenReturn(asyncContainer);
        verify(parquetBlobContainer, never()).deleteBlobsIgnoringIfNotExists(any());  
        IndexInput mockInput = mock(IndexInput.class);
    // Sync copyFrom with FileMetadata  
        }).when(asyncContainer).asyncBlobUpload(any(WriteContext.class), any());
    public void testCompletionListener_CorruptFileException() throws Exception {  
                @Override
        // postUploadRunner throws exception → listener.onFailure  
            public void onFailure(Exception e) {
        directory.copyFrom(mockFrom, "_0.cfs", "_0.cfs__UUID", IOContext.DEFAULT);
        input.close();
    }
        when(container.path()).thenReturn(baseBlobPath);  
        verify(baseBlobContainer, never()).deleteBlobsIgnoringIfNotExists(any());
    public void testAsyncCopyFrom_ExceptionDuringUpload_CallsListenerOnFailure() throws Exception {  
        RemoteIndexOutput output = directory.createOutput("test_file", "lucene", IOContext.DEFAULT);
                @Override  
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        directory.getFormatBlobRouter().orElseThrow().unregisterBlobFormat("_0.pqt__UUID1");
        // Format: originalFilename::uploadedFilename::checksum::length::writtenByMajor
     * WriteContext and completion listener without performing any real upload.  
        input.close();
                public void onFailure(Exception e) {
        baseBlobContainer = mock(BlobContainer.class);  
        List<BlobMetadata> blobList = List.of(new PlainBlobMetadata("_0.cfs", 1234));  
        indexOutput.close();
    }
            null
            null
    // OpenInput Tests  
        assertSame("empty format should route to base container", baseBlobContainer, container);  
        verify(parquetBlobContainer).readBlob("_0.parquet");
        IndexInput mockInput = mock(IndexInput.class);
        verify(baseBlobContainer, times(2)).delete();
        assertEquals(200, input.length());
import org.apache.logging.log4j.LogManager;
import java.util.function.Supplier;
            ActionListener<Void> completionListener = invocation.getArgument(1);
    // ═══════════════════════════════════════════════════════════════  
    public void testUnregisterBlobFormat() throws IOException {
        IndexOutput indexOutput = storeDirectory.createOutput(filename, IOContext.DEFAULT);
            null,  
        UploadedSegmentMetadata metadata = UploadedSegmentMetadata.fromString("_0.cfs::_0.cfs__UUID1::checksum123::100::10");
            UnaryOperator.identity(),  
    private record AsyncDirFixture(DataFormatAwareRemoteDirectory dir, AsyncMultiStreamBlobContainer container, AtomicReference<
import org.opensearch.common.blobstore.BlobMetadata;
        // The copyFrom creates a RemoteIndexOutput that writes to the base container  
    }
        DataFormatAwareRemoteDirectory asyncDir = new DataFormatAwareRemoteDirectory(
            listener,
        assertTrue(latch.await(10, TimeUnit.SECONDS));
        expectThrows(NoSuchFileException.class, () -> directory.fileLength(fm.file()));  
    }
        IndexInput input = directory.openInput("_0.parquet", 200, IOContext.DEFAULT);  
        input.close();
        InputStream stream = new ByteArrayInputStream(data);
