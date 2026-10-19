        TransferService transferService = new BlobStoreTransferService(repository.blobStore(), threadPool);
    }  
            }  
        );
 *
import org.opensearch.repositories.Repository;
        Path testFile = createTempFile("translog-1.", ".tlog");
        assertFalse(metadataInputStream.isClosed());
        assertNotEquals(inputStream1, inputStream2);  
        );  
    }  
        }
        transferService.uploadBlob(
                @Override
    public void testAsyncUploadWithMetadataRequiresCapability() throws Exception {  
    public void testSynchronousUploadRejectsOversizedMetadataBeforeWrite() throws IOException {  
        String inputData = "Small input";  
    }
import static org.opensearch.index.translog.transfer.TranslogTransferManager.CHECKPOINT_FILE_DATA_KEY;
            () -> new BlobStoreTransferService(blobStore, threadPool).uploadBlob(
            transferService.uploadBlob(inputStream, repository.basePath(), "test-object", WritePriority.URGENT, completionListener);
        threadPool = new TestThreadPool(getClass().getName());
        // Named like a first-generation translog so the checksum assert in uploadBlob is satisfied.  
        public void deleteBlobsAsyncIgnoringIfNotExists(List<String> blobNames, ActionListener<Void> completionListener) {  
        );
        AtomicReference<WriteContext> writeContextRef = new AtomicReference<>();
        );
        assertTrue(succeeded.get());
            }  
            this.value = value;
        TrackingInputStream metadataInputStream = new TrackingInputStream(checkpointBytes);
        verify(transferServiceSpy).uploadBlobAsyncInternal(  
        BlobStore blobStore = mock(BlobStore.class);  
        assertFalse(metadataInputStream.isClosed());  
        assertEquals("Blob metadata is not enabled for the configured blob store", exception.getMessage());
            new LatchedActionListener<>(new ActionListener<>() {  
            Mockito.any(),
    public void testBuildTransferFileMetadata_InputStreamExceedsLimit() {
        }  
            }, latch),  
            Mockito.isNull()  
            Mockito.eq(transferFileSnapshot.getContentLength()),  
            Base64.getEncoder().encodeToString(checkpointBytes),
        uploadBlobFromInputStream(transferService);  
                BlobPath.cleanPath(),  
            null
    }  
        RemoteTransferContainer.OffsetRangeInputStreamSupplier inputStreamSupplier = inputStreamCaptor.getValue();  
        public void asyncBlobUpload(WriteContext writeContext, ActionListener<Void> completionListener) throws IOException {  
            "%s",  
        BlobStore blobStore = mock(BlobStore.class);  
        String expectedBase64String = Base64.getEncoder().encodeToString(inputData.getBytes(StandardCharsets.UTF_8));
        );
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        ArgumentCaptor<RemoteTransferContainer.OffsetRangeInputStreamSupplier> inputStreamCaptor = ArgumentCaptor.forClass(  
    }
        CountDownLatch latch = new CountDownLatch(1);  
            Mockito.any(),
        ) {  
        // Apply state once to initialize repo properly like RepositoriesService would  
        private BlobContainer delegate;
        }
        );  
            "translog-1.tlog",
import org.opensearch.core.compress.NoneCompressor;
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
    public void testDownloadBlobWithMetadataRequiresCapability() {
    public void testBuildTransferFileMetadata_NonEmptyInputStream() throws IOException {
        String expectedBase64String = Base64.getEncoder().encodeToString(inputData.getBytes(StandardCharsets.UTF_8));  
        }
        Files.write(testFile, randomByteArrayOfLength(128), StandardOpenOption.APPEND);
            Settings.builder()
    public void testUploadBlobAsync() throws IOException, InterruptedException {  
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);  
        public void close() throws IOException {
    }  
        TrackingInputStream metadataInputStream = new TrackingInputStream(checkpointBytes);  
                    assertEquals(transferFileSnapshot.getName(), fileSnapshot.getName());
        @Override
    public void tearDown() throws Exception {  
    }  
        BlobContainer blobContainer = mock(BlobContainer.class);
        );  
import java.util.concurrent.atomic.AtomicBoolean;
        }
            new LatchedActionListener<>(ActionListener.wrap(ignored -> {}, failure::set), latch),  
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
                    assertEquals(transferFileSnapshot.getPrimaryTerm(), fileSnapshot.getPrimaryTerm());
import org.opensearch.core.index.Index;  
    public void testBuildTransferFileMetadata_EmptyInputStream() throws IOException {  
        // The file on disk holds one payload; the snapshot's supplier serves a different one. The async  
 * compatible open source license.
        repository = createRepository();
        );
                public void onResponse(FileSnapshot.TransferFileSnapshot fileSnapshot) {}  
                indexMetadata,  
            assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));  
            null
import org.mockito.ArgumentCaptor;
        };
        }
                BlobPath.cleanPath(),
            "translog-data".getBytes(StandardCharsets.UTF_8),
        CountDownLatch latch = new CountDownLatch(1);
            contentLengthCaptor.capture(),
        byte[] largeData = new byte[1025]; // 1025 bytes, exceeding the 1KB limit
import org.opensearch.core.action.ActionListener;
        transferService.uploadBlob(transferFileSnapshot, repository.basePath(), WritePriority.HIGH, null);
        verify(blobContainer).writeBlobWithMetadata(  
    }
        transferFileSnapshot.setMetadataFileInputStream(new ByteArrayInputStream(new byte[1025]));  
import org.opensearch.indices.recovery.RecoverySettings;
            Mockito.anyString(),
        assertFalse(metadataInputStream.isClosed());  
        try (OffsetRangeInputStream part = supplierCaptor.getValue().get(5, 9)) {
        repository.updateState(clusterService.state());
            null
            randomNonNegativeLong(),
            transferFileSnapshot,  
                new NoneCompressor(),
            WritePriority.HIGH,
import static org.mockito.Mockito.verify;
            )  
            Mockito.any(),  
import org.opensearch.env.Environment;
        };
        when(blobStore.isBlobMetadataEnabled()).thenReturn(false);
            Map.of(transferFileSnapshot.getPrimaryTerm(), BlobPath.cleanPath()),
import org.opensearch.common.blobstore.BlobPath;
        assertFalse(metadataInputStream.isClosed());
        @Override  
            createEnvironment(),
            "translog-data".getBytes(StandardCharsets.UTF_8),
                public void onResponse(FileSnapshot.TransferFileSnapshot fileSnapshot) {
        transferServiceSpy.uploadBlobs(
                .put(Environment.PATH_REPO_SETTING.getKey(), home.resolve("repo").toAbsolutePath())
        @Override
                transferFileSnapshot,
        assertTrue(metadata.containsKey(CHECKPOINT_FILE_DATA_KEY));  
            () -> new BlobStoreTransferService(blobStore, threadPool).downloadBlobWithMetadata(BlobPath.cleanPath(), "translog-1.tlog")
        );
        verify(blobStore, Mockito.never()).blobContainer(any(BlobPath.class));
            "translog-1.tlog",  
            WritePriority.HIGH,
    private IndexMetadata getIndexMetadata() {
import org.opensearch.action.LatchedActionListener;
            () -> new BlobStoreTransferService(blobStore, threadPool).uploadBlob(
        InputStream emptyInputStream = new ByteArrayInputStream(new byte[0]);
            supplied.length,
                .build()
            completionListener.onResponse(null);  
                transferFileSnapshot,  
        verify(blobStore, Mockito.never()).blobContainer(any(BlobPath.class));
        );
            null
        verify(blobStore, Mockito.never()).blobContainer(any(BlobPath.class));  
        TrackingInputStream(byte[] bytes) {
        BlobStore blobStore = mock(BlobStore.class);  
                WritePriority.HIGH,
        @Override
            testFile,  
            IOException.class,  
        public BlobContainer getDelegate() {
        AtomicBoolean succeeded = new AtomicBoolean(false);  
        final Index index = new Index("test-index", "index-uuid");
        IllegalStateException exception = expectThrows(  
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes(StandardCharsets.UTF_8));
        TrackingInputStream metadataInputStream = new TrackingInputStream(checkpointBytes);
        @Override
import java.util.Base64;
            ActionListener<TestClass> listener = new LatchedActionListener<>(new ActionListener<>() {
        new BlobStoreTransferService(blobStore, threadPool).uploadBlob(
            super(blobStore, blobPath, path);
import java.util.List;
import java.io.InputStream;
        Settings settings = Settings.builder().put("location", randomAlphaOfLength(10)).build();
    public void setUp() throws Exception {
    private static class MockAsyncFsContainer extends FsBlobContainer implements AsyncMultiStreamBlobContainer {
        transferFileSnapshot.setMetadataFileInputStream(metadataInputStream);  
        final FsRepository repository = new FsRepository(
    }
            IllegalStateException.class,
        );  
            randomNonNegativeLong(),
            Mockito.any()
            "dummy_name",
            Mockito.any(),  
        assertNotNull(failure.get());
        assertEquals("", metadata.get(CHECKPOINT_FILE_DATA_KEY));
                @Override
 */  
            Mockito.anyString(),
            transferFileSnapshot,
    private Environment createEnvironment() {
import org.mockito.Mockito;
        );  
        transferService.uploadBlob(transferFileSnapshot, repository.basePath(), WritePriority.NORMAL, null);  
            "Length must come from the snapshot, not the file on disk",  
            "translog-data".getBytes(StandardCharsets.UTF_8),  
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(  
            assertEquals("bytes", new String(part.readAllBytes(), StandardCharsets.UTF_8));  
        when(fsBlobStore.blobContainer(any())).thenReturn(mockAsyncFsContainer);
        assertEquals("Blob metadata is not enabled for the configured blob store", failure.get().getCause().getMessage());
            WritePriority.HIGH,  
                null
    private BlobStore createTestBlobStore() throws IOException {  
        return new FsBlobStore(randomIntBetween(1, 8) * 1024, createTempDir(), false);
        new BlobStoreTransferService(blobStore, threadPool).uploadBlobs(  
import java.nio.file.StandardOpenOption;  
            null
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
        }
import java.nio.file.Files;
            1  
        final ClusterService clusterService = BlobStoreTestUtil.mockClusterService(repositoryMetadata);
                public void onResponse(TestClass testObject) {  
        private final String value;  
            1  
            "translog-data".getBytes(StandardCharsets.UTF_8),
        Mockito.doAnswer(invocation -> {
        );  
                ex -> listener.onFailure(ex)  
    }
        FsBlobStore fsBlobStore = mock(FsBlobStore.class);
import org.opensearch.cluster.metadata.IndexMetadata;  
import java.util.Map;  
    }
        OffsetRangeInputStream inputStream1 = inputStreamSupplier.get(1, 0);
            any(InputStream.class),
        );
    private ThreadPool threadPool;  
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
    }
import org.opensearch.threadpool.ThreadPool;  
    public void testSynchronousUploadWithMetadataRequiresCapability() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
            Set.of(transferFileSnapshot),
            "translog-1.tlog",
            Mockito.eq(transferFileSnapshot.getName()),
import org.opensearch.common.blobstore.fs.FsBlobStore;  
        TrackingInputStream metadataInputStream = new TrackingInputStream(checkpointBytes);
        TransferService transferService = new BlobStoreTransferService(repository.blobStore(), threadPool);
            clusterService,  
            null
        assertEquals(checkpointBytes.length, metadataInputStream.available());
            Mockito.eq(true),
    }
            "translog-1.tlog",
            throw new RuntimeException("read not supported");
        assertTrue(failure.get() instanceof FileTransferException);  
            Set.of(transferFileSnapshot),
            1
        assertEquals(0, metadataInputStream.available());
            testFile,  
import org.opensearch.common.settings.ClusterSettings;
            Map.of(transferFileSnapshot.getPrimaryTerm(), BlobPath.cleanPath()),  
        new BlobStoreTransferService(blobStore, threadPool).uploadBlobs(
            RemoteTransferContainer.OffsetRangeInputStreamSupplier.class
        );
            this.name = name;
            Map.of(transferFileSnapshot.getPrimaryTerm(), BlobPath.cleanPath()),
        ArgumentCaptor<RemoteTransferContainer.OffsetRangeInputStreamSupplier> supplierCaptor = ArgumentCaptor.forClass(  
            Set.of(transferFileSnapshot),  
        byte[] checkpointBytes = "checkpoint-data".getBytes(StandardCharsets.UTF_8);
            "translog-data".getBytes(StandardCharsets.UTF_8),  
            WritePriority.HIGH,
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
                @Override
        MockAsyncFsContainer mockAsyncFsContainer = new MockAsyncFsContainer((FsBlobStore) blobStore, BlobPath.cleanPath(), null);
            assertTrue(succeeded.get());
            randomByteArrayOfLength(128),
import java.io.Serializable;
        TransferService transferService = new BlobStoreTransferService(repository.blobStore(), threadPool);
        String inputData = "This is a test input stream.";
            super.close();  
            Mockito.eq(transferFileSnapshot.getContentLength()),  
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;  
        BlobStore blobStore = mock(BlobStore.class);  
            WritePriority.HIGH,
                }
            Mockito.isNull(),
        public void deleteAsync(ActionListener<DeleteResult> completionListener) {
            delegate.writeBlob(writeContext.getFileName(), inputStream, writeContext.getFileSize(), true);
            BlobPath.cleanPath(),  
        public String toString() {  
        CountDownLatch latch = new CountDownLatch(1);  
        BlobStore blobStore = mock(BlobStore.class);
                return (size, position) -> new OffsetRangeIndexInputStream(new ByteArrayIndexInput("supplied", supplied), size, position);  
            RemoteTransferContainer.OffsetRangeInputStreamSupplier.class
    public void testUploadBlobFromInputStreamSyncFSRepo() throws IOException, InterruptedException {
    private BlobStoreRepository createRepository() {
        Path testFile = createTempFile();
import org.opensearch.common.blobstore.stream.write.WritePriority;  
    }  
        return repository;  
        }  
            public long getContentLength() {
import static org.mockito.Mockito.mock;  
            IllegalStateException.class,
        ChecksumBlobStoreFormat<IndexMetadata> blobStoreFormat = new ChecksumBlobStoreFormat<>(
        assertEquals("Blob metadata is not enabled for the configured blob store", exception.getMessage());  
import org.opensearch.common.blobstore.BlobStore;  
        );  
            delegate = blobStore.blobContainer(BlobPath.cleanPath());
            ActionListener<Void> completionListener = ActionListener.wrap(
        ) {
            Mockito.any(),
        @Override
        BlobContainer blobContainer = mock(BlobContainer.class);
        // without the transfer service reading -- and therefore buffering -- the file itself.
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
            return null;  
            xContentRegistry(),
        );
        new BlobStoreTransferService(blobStore, threadPool).uploadBlob(
            ThreadPool.Names.TRANSLOG_TRANSFER,  
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
        byte[] checkpointBytes = "checkpoint-data".getBytes(StandardCharsets.UTF_8);
            CountDownLatch latch = new CountDownLatch(1);  
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(  
            contentLengthCaptor.getValue().longValue()
    /** Create a {@link Repository} with a random name **/  
import org.opensearch.common.blobstore.fs.FsBlobContainer;
            Mockito.any(),
        Files.write(testFile, randomByteArrayOfLength(128), StandardOpenOption.APPEND);
        Path home = createTempDir();  
    public void testAsyncUploadIncludesCheckpointMetadata() throws Exception {
        assertEquals(Base64.getEncoder().encodeToString(checkpointBytes), metadataCaptor.getValue().get(CHECKPOINT_FILE_DATA_KEY));
    }  
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata(randomAlphaOfLength(10), FsRepository.TYPE, settings);  
 * this file be licensed under the Apache-2.0 license or a
        assertNull(failure.get());  
        private TestClass(String name, String value) {  
import java.util.concurrent.atomic.AtomicReference;
        FsBlobStore fsBlobStore = mock(FsBlobStore.class);  
            any(InputStream.class),
import org.opensearch.repositories.fs.FsRepository;  
        super.tearDown();
            Mockito.eq(true),
            throw new RuntimeException("deleteBlobsAsyncIgnoringIfNotExists not supported");
        uploadBlobFromInputStream(transferServiceSpy);
            writeContextRef.set(invocation.getArgument(0));  
        }
    private BlobStoreRepository repository;
            "translog-1.tlog",  
            supplierCaptor.capture(),
        assertTrue(latch.await(5000, TimeUnit.MILLISECONDS));
            Mockito.anyLong(),  
            repositoryMetadata,  
        ArgumentCaptor<Long> contentLengthCaptor = ArgumentCaptor.forClass(Long.class);  
        public void readBlobAsync(String blobName, ActionListener<ReadContext> listener) {
        Map<String, String> metadata = BlobStoreTransferService.buildTransferFileMetadata(inputStream);
        assertEquals(0, metadataInputStream.available());  
        BlobStore blobStore = mock(BlobStore.class);
                }
        when(fsBlobStore.blobContainer(any())).thenReturn(mockAsyncFsContainer);  
            null  
/*  
            "coordination",
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);  
        when(blobStore.isBlobMetadataEnabled()).thenReturn(true);
        );  
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
        );  
    public void testBuildTransferFileMetadata_SmallInputStreamOptimization() throws IOException {
            Mockito.anyString(),  
                public void onFailure(Exception e) {  
            @Override  
import org.opensearch.repositories.blobstore.ChecksumBlobStoreFormat;
    }
public class BlobStoreTransferServiceTests extends OpenSearchTestCase {
        );
        IllegalStateException exception = expectThrows(  
        BlobStore blobStore = createTestBlobStore();
        assertEquals(expectedBase64String, metadata.get(CHECKPOINT_FILE_DATA_KEY));
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
import org.opensearch.threadpool.TestThreadPool;
        @Override  
import org.opensearch.common.blobstore.stream.read.ReadContext;
import org.opensearch.common.blobstore.stream.write.WriteContext;
    public void testSynchronousUploadIncludesCheckpointMetadata() throws IOException {
    }
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
            randomNonNegativeLong(),  
            .build();  
            repository.basePath(),
        );
        TransferService transferService = new BlobStoreTransferService(repository.blobStore(), threadPool);
        when(blobStore.isBlobMetadataEnabled()).thenReturn(true);  
                return supplied.length;
                @Override
            Mockito.eq(transferFileSnapshot.getName()),
                    throw new AssertionError("Failed to upload blob", e);
        super.setUp();  
        assertNotEquals(inputStream1.getFilePointer(), inputStream2.getFilePointer());
                    throw new AssertionError("Failed to perform uploadBlobAsync", e);
        assertTrue(metadata.containsKey(CHECKPOINT_FILE_DATA_KEY));
import java.util.concurrent.CountDownLatch;
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
        }  
        private boolean closed;  
import org.opensearch.env.TestEnvironment;  
            1
        }  
            @Override
import java.io.IOException;  
        when(blobStore.isBlobMetadataEnabled()).thenReturn(false);
            completionListener.onResponse(null);
            }, latch),  
        Path testFile = createTempFile();  
    }  
        byte[] checkpointBytes = "checkpoint-data".getBytes(StandardCharsets.UTF_8);  
    }
                new ToXContent.MapParams(Map.of())  
        assertTrue(failure.get().getCause() instanceof IllegalStateException);
            Mockito.anyLong(),
        ArgumentCaptor<Map<String, String>> metadataCaptor = ArgumentCaptor.forClass(Map.class);
        }
            1
        verify(blobStore, Mockito.never()).isBlobMetadataEnabled();
                }  
            throw new RuntimeException("deleteAsync not supported");  
        transferFileSnapshot.setMetadataFileInputStream(metadataInputStream);
    }
        IOException exception = assertThrows(IOException.class, () -> BlobStoreTransferService.buildTransferFileMetadata(largeInputStream));
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);  
import org.opensearch.Version;
    }
        verify(transferServiceSpy).uploadBlobAsyncInternal(
            null
import java.util.concurrent.TimeUnit;  
    public void testUploadBlobFromByteArray() throws IOException {
            @Override  
            inputStreamCaptor.capture(),  
            );
        byte[] supplied = "supplied-bytes".getBytes(StandardCharsets.UTF_8);  
        assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));
        when(blobStore.isBlobMetadataEnabled()).thenReturn(true);
        assertEquals(checkpointBytes.length, metadataInputStream.available());
        );
                resp -> listener.onResponse(testObject),
            Mockito.isNull()  
        IOException exception = expectThrows(
            WritePriority.HIGH,
import org.opensearch.core.xcontent.ToXContent;
        BlobStore blobStore = mock(BlobStore.class);
            )
        public boolean remoteIntegrityCheckSupported() {  
            InputStream inputStream = blobStoreFormat.serialize(
                WritePriority.HIGH,
        TestClass testObject = new TestClass("field1", "value1");
            new LatchedActionListener<>(new ActionListener<>() {
            public RemoteTransferContainer.OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier() {
        public MockAsyncFsContainer(FsBlobStore blobStore, BlobPath blobPath, Path path) {  
                }
            metadataCaptor.capture(),
import java.util.Set;
 * The OpenSearch Contributors require contributions made to  
        BlobStoreTransferService transferServiceSpy = Mockito.spy(new BlobStoreTransferService(fsBlobStore, threadPool));
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
import static org.mockito.ArgumentMatchers.any;
        BlobStore blobStore = createTestBlobStore();  
            protected void assertSnapshotOrGenericThread() {
        try (
        // A part from a non-zero offset, which is what a multipart upload actually requests.
            transferFileSnapshot,
                @Override
            }
        boolean isClosed() {  
            new LatchedActionListener<>(ActionListener.wrap(ignored -> fail("upload should have failed"), failure::set), latch),
        verify(blobContainer).writeBlobWithMetadata(  
            1
                .put(Environment.PATH_HOME_SETTING.getKey(), home.toAbsolutePath())  
                    assert testObject.name.equals("field1");
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes(StandardCharsets.UTF_8));  
        AtomicReference<Exception> failure = new AtomicReference<>();
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
        byte[] checkpointBytes = "checkpoint-data".getBytes(StandardCharsets.UTF_8);  
            return "TestClass{ name: " + name + ", value: " + value + " }";
    }  
    private static class TrackingInputStream extends ByteArrayInputStream {
        assertEquals(
import org.opensearch.common.blobstore.BlobContainer;
        assertTrue(metadata.containsKey(CHECKPOINT_FILE_DATA_KEY));  
            BlobPath.cleanPath(),
            Mockito.any(),
                "index-metadata",
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
import org.opensearch.common.settings.Settings;  
        IndexMetadata indexMetadata = getIndexMetadata();  
                }  
                public void onFailure(Exception e) {  
        BlobStoreTransferService transferServiceSpy = Mockito.spy(new BlobStoreTransferService(fsBlobStore, threadPool));  
import org.opensearch.cluster.service.ClusterService;
        OffsetRangeInputStream inputStream2 = inputStreamSupplier.get(1, 2);
            "translog-data".getBytes(StandardCharsets.UTF_8),
import java.nio.charset.StandardCharsets;  
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
        );
        transferFileSnapshot.setMetadataFileInputStream(metadataInputStream);
        InputStream largeInputStream = new ByteArrayInputStream(largeData);  
            "translog-1.tlog",  
        assertEquals(expectedBase64String, metadata.get(CHECKPOINT_FILE_DATA_KEY));
            Mockito.any(),  
        }
        AtomicBoolean succeeded = new AtomicBoolean(false);  
    public void testUploadBlobAsyncUsesSnapshotSuppliedPartStreams() throws IOException, InterruptedException {
        Map<String, String> metadata = BlobStoreTransferService.buildTransferFileMetadata(emptyInputStream);
    }  
import org.opensearch.cluster.metadata.RepositoryMetadata;
    @Override
}  
import org.opensearch.common.blobstore.transfer.RemoteTransferContainer;
        private final String name;
        return TestEnvironment.newEnvironment(
import java.io.ByteArrayInputStream;
            InputStream inputStream = writeContext.getStreamProvider(Integer.MAX_VALUE).provideStream(0).getInputStream();
import java.nio.file.Path;
    public void testUploadBlobFromInputStreamAsyncFSRepo() throws IOException, InterruptedException {  
 * SPDX-License-Identifier: Apache-2.0
            Mockito.anyString(),
import org.opensearch.common.blobstore.DeleteResult;
        );  
        verify(blobContainer, Mockito.never()).asyncBlobUpload(any(WriteContext.class), any());  
            return false;
            return closed;
        );
    /** Create a {@link Environment} with random path.home and path.repo **/
        repository.start();
                // eliminate thread name check as we create repo manually
            }, latch);  
        assertEquals(
            IndexMetadata::fromXContent
    public void testUploadBlob() throws IOException {
            Mockito.any(),
            writeContextRef.get().getMetadata().get(CHECKPOINT_FILE_DATA_KEY)  
        when(blobStore.isBlobMetadataEnabled()).thenReturn(false);  
        }
            super(bytes);  
            1
import static org.mockito.Mockito.when;
            closed = true;
        );  
                null  
        Files.write(testFile, "on-disk-bytes".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }
            ).streamInput()
        try (OffsetRangeInputStream whole = supplierCaptor.getValue().get(supplied.length, 0)) {
                    assert succeeded.compareAndSet(false, true);
                @Override
        }  
            null
    public void testSynchronousUploadWithoutMetadataPassesNull() throws IOException {
        clusterService.addStateApplier(event -> repository.updateState(event.state()));
                    throw new AssertionError("Failed to perform uploadBlobAsync", e);
                    assert succeeded.compareAndSet(false, true);  
        MockAsyncFsContainer mockAsyncFsContainer = new MockAsyncFsContainer((FsBlobStore) blobStore, BlobPath.cleanPath(), null);
        return new IndexMetadata.Builder(index.getName()).settings(idxSettings).version(5L).numberOfShards(1).numberOfReplicas(0).build();
        // upload must take its parts from the supplier, so a snapshot that transforms its bytes is honoured
    @SuppressWarnings("unchecked")  
    }
            return delegate;
        Map<String, String> metadata = BlobStoreTransferService.buildTransferFileMetadata(inputStream);
            assertEquals("supplied-bytes", new String(whole.readAllBytes(), StandardCharsets.UTF_8));
        CountDownLatch latch = new CountDownLatch(1);  
    }
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        AtomicReference<Exception> failure = new AtomicReference<>();
    private static class TestClass implements Serializable {
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
package org.opensearch.index.translog.transfer;
        ) {
        repository.stop();
            ActionListener<Void> completionListener = invocation.getArgument(1);
    private void uploadBlobFromInputStream(TransferService transferService) throws IOException, InterruptedException {
        );
        assertEquals("Input stream exceeds 1KB limit", exception.getMessage());
        );  
                public void onFailure(Exception e) {  
            testFile,
        assertEquals(exception.getMessage(), "Input stream exceeds 1KB limit");
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeInputStream;  
        transferFileSnapshot.setMetadataFileInputStream(metadataInputStream);
            Mockito.any()
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    @Override
        final Settings idxSettings = Settings.builder()  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }  
