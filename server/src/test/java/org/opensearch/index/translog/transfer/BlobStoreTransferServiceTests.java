        assertEquals(checkpointBytes.length, metadataInputStream.available());
                new NoneCompressor(),
        );
                    assertEquals(transferFileSnapshot.getName(), fileSnapshot.getName());
        }
            createEnvironment(),
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.common.blobstore.stream.write.WritePriority;
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes(StandardCharsets.UTF_8));
import java.util.concurrent.CountDownLatch;
 *
        super.setUp();
            randomNonNegativeLong(),
    @SuppressWarnings("unchecked")
import org.opensearch.common.blobstore.stream.read.ReadContext;
            writeContextRef.set(invocation.getArgument(0));
        transferService.uploadBlob(transferFileSnapshot, repository.basePath(), WritePriority.NORMAL, null);
            closed = true;
            metadataCaptor.capture(),
        BlobStore blobStore = createTestBlobStore();
            () -> new BlobStoreTransferService(blobStore, threadPool).uploadBlob(
        Files.write(testFile, randomByteArrayOfLength(128), StandardOpenOption.APPEND);
            Mockito.any(),
import org.opensearch.cluster.service.ClusterService;
            BlobPath.cleanPath(),
            @Override
            Set.of(transferFileSnapshot),
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeInputStream;
            contentLengthCaptor.getValue().longValue()
        AtomicReference<Exception> failure = new AtomicReference<>();
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
        ArgumentCaptor<RemoteTransferContainer.OffsetRangeInputStreamSupplier> supplierCaptor = ArgumentCaptor.forClass(
                null
            () -> new BlobStoreTransferService(blobStore, threadPool).downloadBlobWithMetadata(BlobPath.cleanPath(), "translog-1.tlog")
            null
        verify(blobStore, Mockito.never()).blobContainer(any(BlobPath.class));
            null
        }
            testFile,
                @Override
        );
            null
                    assert testObject.name.equals("field1");
        );
            @Override
            null
        );
            WritePriority.HIGH,
    public void testDownloadBlobWithMetadataRequiresCapability() {
    /** Create a {@link Environment} with random path.home and path.repo **/
            Map.of(transferFileSnapshot.getPrimaryTerm(), BlobPath.cleanPath()),
import static org.mockito.Mockito.verify;
                    throw new AssertionError("Failed to perform uploadBlobAsync", e);
            assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
            IllegalStateException.class,
                }
        TrackingInputStream metadataInputStream = new TrackingInputStream(checkpointBytes);
        public BlobContainer getDelegate() {
    public void testAsyncUploadWithMetadataRequiresCapability() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.atomic.AtomicReference;
import static org.mockito.ArgumentMatchers.any;
        Settings settings = Settings.builder().put("location", randomAlphaOfLength(10)).build();
                public void onFailure(Exception e) {
        verify(transferServiceSpy).uploadBlobAsyncInternal(
        OffsetRangeInputStream inputStream2 = inputStreamSupplier.get(1, 2);
        assertNotEquals(inputStream1.getFilePointer(), inputStream2.getFilePointer());
            1
import org.mockito.Mockito;
            }
        }
import org.opensearch.common.blobstore.fs.FsBlobContainer;
            delegate = blobStore.blobContainer(BlobPath.cleanPath());
        private boolean closed;
        transferFileSnapshot.setMetadataFileInputStream(metadataInputStream);
            Mockito.anyString(),
            new LatchedActionListener<>(new ActionListener<>() {
        @Override
        when(fsBlobStore.blobContainer(any())).thenReturn(mockAsyncFsContainer);
        }
        ArgumentCaptor<Long> contentLengthCaptor = ArgumentCaptor.forClass(Long.class);
        repository.updateState(clusterService.state());
                ex -> listener.onFailure(ex)
            @Override
        clusterService.addStateApplier(event -> repository.updateState(event.state()));
                resp -> listener.onResponse(testObject),
                return (size, position) -> new OffsetRangeIndexInputStream(new ByteArrayIndexInput("supplied", supplied), size, position);
                    throw new AssertionError("Failed to perform uploadBlobAsync", e);
            super.close();
import java.io.IOException;
            "translog-data".getBytes(StandardCharsets.UTF_8),
        uploadBlobFromInputStream(transferService);
        }
        // without the transfer service reading -- and therefore buffering -- the file itself.
        @Override
            "translog-1.tlog",
    private static class TrackingInputStream extends ByteArrayInputStream {
import java.nio.file.Files;
        );
                }
        BlobStoreTransferService transferServiceSpy = Mockito.spy(new BlobStoreTransferService(fsBlobStore, threadPool));
                BlobPath.cleanPath(),
            throw new RuntimeException("deleteBlobsAsyncIgnoringIfNotExists not supported");
import org.opensearch.repositories.fs.FsRepository;
        assertEquals("Blob metadata is not enabled for the configured blob store", exception.getMessage());
import org.opensearch.common.blobstore.DeleteResult;
        );
        final FsRepository repository = new FsRepository(
            WritePriority.HIGH,
                WritePriority.HIGH,
            new LatchedActionListener<>(new ActionListener<>() {
        );
        ChecksumBlobStoreFormat<IndexMetadata> blobStoreFormat = new ChecksumBlobStoreFormat<>(
        BlobStore blobStore = createTestBlobStore();
    public void setUp() throws Exception {
}
import org.opensearch.common.blobstore.BlobPath;
import static org.mockito.Mockito.mock;
            Mockito.eq(true),
            Mockito.any(),
        return repository;
import java.io.Serializable;
 * The OpenSearch Contributors require contributions made to
        verify(blobContainer).writeBlobWithMetadata(
        Path testFile = createTempFile();
        new BlobStoreTransferService(blobStore, threadPool).uploadBlob(
            "translog-data".getBytes(StandardCharsets.UTF_8),
            }, latch);
            repository.basePath(),
        assertNotEquals(inputStream1, inputStream2);
        );
        // The file on disk holds one payload; the snapshot's supplier serves a different one. The async
            Mockito.any(),
            supplierCaptor.capture(),
                WritePriority.HIGH,
            supplied.length,
    }
    /** Create a {@link Repository} with a random name **/
import java.util.concurrent.atomic.AtomicBoolean;
        );
    }
            new LatchedActionListener<>(ActionListener.wrap(ignored -> {}, failure::set), latch),
        }
                    throw new AssertionError("Failed to upload blob", e);
    private BlobStoreRepository repository;
                public void onResponse(TestClass testObject) {
    public void testBuildTransferFileMetadata_InputStreamExceedsLimit() {
            "translog-data".getBytes(StandardCharsets.UTF_8),
        Map<String, String> metadata = BlobStoreTransferService.buildTransferFileMetadata(emptyInputStream);
        TransferService transferService = new BlobStoreTransferService(repository.blobStore(), threadPool);
        assertEquals("Input stream exceeds 1KB limit", exception.getMessage());
        );
            Mockito.isNull()
        );
        String inputData = "This is a test input stream.";
        }).when(blobContainer).asyncBlobUpload(any(WriteContext.class), any());
            ThreadPool.Names.TRANSLOG_TRANSFER,
        IOException exception = assertThrows(IOException.class, () -> BlobStoreTransferService.buildTransferFileMetadata(largeInputStream));
        assertTrue(metadata.containsKey(CHECKPOINT_FILE_DATA_KEY));
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
            Set.of(transferFileSnapshot),
            "translog-1.tlog",
            throw new RuntimeException("deleteAsync not supported");
        BlobStore blobStore = mock(BlobStore.class);
        );
            "coordination",
        private TestClass(String name, String value) {
        assertTrue(latch.await(5000, TimeUnit.MILLISECONDS));
    }
            Mockito.eq(transferFileSnapshot.getName()),
            return closed;
        }
    }
        ) {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(checkpointBytes.length, metadataInputStream.available());
        assertEquals("Blob metadata is not enabled for the configured blob store", failure.get().getCause().getMessage());
            1
                @Override
            Mockito.eq(transferFileSnapshot.getContentLength()),
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
            super(bytes);
            Mockito.isNull(),
        Files.write(testFile, "on-disk-bytes".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }
 * this file be licensed under the Apache-2.0 license or a
            ActionListener<TestClass> listener = new LatchedActionListener<>(new ActionListener<>() {
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
        ) {
            assertEquals("supplied-bytes", new String(whole.readAllBytes(), StandardCharsets.UTF_8));
        );
import org.opensearch.env.Environment;
    private Environment createEnvironment() {
        private BlobContainer delegate;
        assertEquals(exception.getMessage(), "Input stream exceeds 1KB limit");
    private static class TestClass implements Serializable {
                null
            .build();
import org.opensearch.cluster.metadata.IndexMetadata;
        verify(blobStore, Mockito.never()).blobContainer(any(BlobPath.class));
    public void testUploadBlobFromInputStreamSyncFSRepo() throws IOException, InterruptedException {
            WritePriority.HIGH,
            Mockito.any(),
            WritePriority.HIGH,
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
        assertTrue(succeeded.get());
        return new FsBlobStore(randomIntBetween(1, 8) * 1024, createTempDir(), false);
        BlobContainer blobContainer = mock(BlobContainer.class);
        IndexMetadata indexMetadata = getIndexMetadata();
    }
            Mockito.any(),
                BlobPath.cleanPath(),
    private IndexMetadata getIndexMetadata() {
            Mockito.anyString(),
        IllegalStateException exception = expectThrows(
        when(blobStore.isBlobMetadataEnabled()).thenReturn(false);
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
    public void testUploadBlobAsyncUsesSnapshotSuppliedPartStreams() throws IOException, InterruptedException {
        transferFileSnapshot.setMetadataFileInputStream(new ByteArrayInputStream(new byte[1025]));
        String inputData = "Small input";
        boolean isClosed() {
            ActionListener<Void> completionListener = ActionListener.wrap(
        assertTrue(latch.await(5, TimeUnit.SECONDS));
import org.opensearch.core.xcontent.ToXContent;
        assertEquals(expectedBase64String, metadata.get(CHECKPOINT_FILE_DATA_KEY));
        // A part from a non-zero offset, which is what a multipart upload actually requests.
            );
            Mockito.anyLong(),
            super(blobStore, blobPath, path);
        assertTrue(failure.get().getCause() instanceof IllegalStateException);
        // Named like a first-generation translog so the checksum assert in uploadBlob is satisfied.
        CountDownLatch latch = new CountDownLatch(1);
            transferFileSnapshot,
    public void testUploadBlob() throws IOException {
        when(fsBlobStore.blobContainer(any())).thenReturn(mockAsyncFsContainer);
        new BlobStoreTransferService(blobStore, threadPool).uploadBlobs(
import org.opensearch.core.index.Index;
        BlobContainer blobContainer = mock(BlobContainer.class);
        }
import org.opensearch.core.action.ActionListener;
            InputStream inputStream = writeContext.getStreamProvider(Integer.MAX_VALUE).provideStream(0).getInputStream();
            repositoryMetadata,
import org.opensearch.threadpool.ThreadPool;
    public void testUploadBlobFromInputStreamAsyncFSRepo() throws IOException, InterruptedException {
            contentLengthCaptor.capture(),
                }
            return null;
        assertEquals(
            testFile,
import org.mockito.ArgumentCaptor;
        );
        byte[] checkpointBytes = "checkpoint-data".getBytes(StandardCharsets.UTF_8);
                @Override
        TestClass testObject = new TestClass("field1", "value1");
import org.opensearch.action.LatchedActionListener;
            assertEquals("bytes", new String(part.readAllBytes(), StandardCharsets.UTF_8));
        IllegalStateException exception = expectThrows(
            any(InputStream.class),
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
        ) {
            BlobPath.cleanPath(),
        Path home = createTempDir();
            assertTrue(succeeded.get());
        TrackingInputStream metadataInputStream = new TrackingInputStream(checkpointBytes);
            )
    public void testSynchronousUploadWithoutMetadataPassesNull() throws IOException {
        );
    }
        TrackingInputStream(byte[] bytes) {
            delegate.writeBlob(writeContext.getFileName(), inputStream, writeContext.getFileSize(), true);
    @Override
            Mockito.eq(transferFileSnapshot.getName()),
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())
            public long getContentLength() {
            this.value = value;
        verify(blobStore, Mockito.never()).blobContainer(any(BlobPath.class));
        when(blobStore.isBlobMetadataEnabled()).thenReturn(true);
            }, latch),
            randomByteArrayOfLength(128),
            RemoteTransferContainer.OffsetRangeInputStreamSupplier.class
    private static class MockAsyncFsContainer extends FsBlobContainer implements AsyncMultiStreamBlobContainer {
        };
import org.opensearch.repositories.Repository;
        byte[] checkpointBytes = "checkpoint-data".getBytes(StandardCharsets.UTF_8);
        Path testFile = createTempFile("translog-1.", ".tlog");
        when(blobStore.isBlobMetadataEnabled()).thenReturn(false);
            "dummy_name",
            CountDownLatch latch = new CountDownLatch(1);
        );
            Mockito.anyString(),
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        );
        verify(transferServiceSpy).uploadBlobAsyncInternal(
        RemoteTransferContainer.OffsetRangeInputStreamSupplier inputStreamSupplier = inputStreamCaptor.getValue();
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        @Override
            transferFileSnapshot,
            "translog-1.tlog",
        repository.start();
                @Override
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
    }
            WritePriority.HIGH,
import org.opensearch.common.blobstore.stream.write.WriteContext;
            any(InputStream.class),
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes(StandardCharsets.UTF_8));
import org.opensearch.threadpool.TestThreadPool;
        ArgumentCaptor<Map<String, String>> metadataCaptor = ArgumentCaptor.forClass(Map.class);
        public void asyncBlobUpload(WriteContext writeContext, ActionListener<Void> completionListener) throws IOException {
import java.io.InputStream;
        assertEquals(
            Mockito.anyLong(),
        IOException exception = expectThrows(
            Mockito.any(),
        );
        );
            Mockito.any()
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
        byte[] supplied = "supplied-bytes".getBytes(StandardCharsets.UTF_8);
        repository = createRepository();
        @Override
    }
/*
        assertEquals(expectedBase64String, metadata.get(CHECKPOINT_FILE_DATA_KEY));
            inputStreamCaptor.capture(),
        AtomicBoolean succeeded = new AtomicBoolean(false);
        threadPool = new TestThreadPool(getClass().getName());
            () -> new BlobStoreTransferService(blobStore, threadPool).uploadBlob(
                // eliminate thread name check as we create repo manually
        try (OffsetRangeInputStream part = supplierCaptor.getValue().get(5, 9)) {
            IllegalStateException.class,
            RemoteTransferContainer.OffsetRangeInputStreamSupplier.class
        byte[] checkpointBytes = "checkpoint-data".getBytes(StandardCharsets.UTF_8);
        BlobStore blobStore = mock(BlobStore.class);
            "translog-data".getBytes(StandardCharsets.UTF_8),
                return supplied.length;
    private BlobStoreRepository createRepository() {
        ArgumentCaptor<RemoteTransferContainer.OffsetRangeInputStreamSupplier> inputStreamCaptor = ArgumentCaptor.forClass(
            throw new RuntimeException("read not supported");
            return "TestClass{ name: " + name + ", value: " + value + " }";
                transferFileSnapshot,
            randomNonNegativeLong(),
        BlobStore blobStore = mock(BlobStore.class);
            }, latch),
        public void readBlobAsync(String blobName, ActionListener<ReadContext> listener) {
                    assert succeeded.compareAndSet(false, true);
            )
        TransferService transferService = new BlobStoreTransferService(repository.blobStore(), threadPool);
        try (OffsetRangeInputStream whole = supplierCaptor.getValue().get(supplied.length, 0)) {
        final Index index = new Index("test-index", "index-uuid");
        }
        InputStream largeInputStream = new ByteArrayInputStream(largeData);
import org.opensearch.common.blobstore.BlobContainer;
    public void testSynchronousUploadWithMetadataRequiresCapability() throws IOException {
            1
                public void onFailure(Exception e) {
import org.opensearch.indices.recovery.RecoverySettings;
            return false;
        };
            Mockito.any(),
            1
    }
        Map<String, String> metadata = BlobStoreTransferService.buildTransferFileMetadata(inputStream);
                }
        public void deleteAsync(ActionListener<DeleteResult> completionListener) {
        when(blobStore.isBlobMetadataEnabled()).thenReturn(true);
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
        String expectedBase64String = Base64.getEncoder().encodeToString(inputData.getBytes(StandardCharsets.UTF_8));
        transferService.uploadBlob(
import org.opensearch.cluster.metadata.RepositoryMetadata;
            "translog-data".getBytes(StandardCharsets.UTF_8),
        }
            1
            "translog-1.tlog",
        @Override
            Map.of(transferFileSnapshot.getPrimaryTerm(), BlobPath.cleanPath()),
import org.opensearch.common.settings.Settings;
            }
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
        AtomicReference<WriteContext> writeContextRef = new AtomicReference<>();
        Files.write(testFile, randomByteArrayOfLength(128), StandardOpenOption.APPEND);
        // Apply state once to initialize repo properly like RepositoriesService would
        }
                public void onResponse(FileSnapshot.TransferFileSnapshot fileSnapshot) {
            Mockito.eq(transferFileSnapshot.getContentLength()),
        verify(blobStore, Mockito.never()).isBlobMetadataEnabled();
        BlobStore blobStore = mock(BlobStore.class);
    public void tearDown() throws Exception {
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
    }
                    assert succeeded.compareAndSet(false, true);
        uploadBlobFromInputStream(transferServiceSpy);
        private final String name;
        public String toString() {
                public void onResponse(FileSnapshot.TransferFileSnapshot fileSnapshot) {}
    public void testSynchronousUploadRejectsOversizedMetadataBeforeWrite() throws IOException {
                indexMetadata,
        private final String value;
        repository.stop();
            randomNonNegativeLong(),
 * compatible open source license.
        return new IndexMetadata.Builder(index.getName()).settings(idxSettings).version(5L).numberOfShards(1).numberOfReplicas(0).build();
import org.opensearch.test.OpenSearchTestCase;
        byte[] largeData = new byte[1025]; // 1025 bytes, exceeding the 1KB limit
                "index-metadata",
import java.util.Base64;
                }
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        super.tearDown();
            Mockito.anyString(),
    private BlobStore createTestBlobStore() throws IOException {
    private ThreadPool threadPool;
            null
                new ToXContent.MapParams(Map.of())
package org.opensearch.index.translog.transfer;
            null
        assertNotNull(failure.get());
        final ClusterService clusterService = BlobStoreTestUtil.mockClusterService(repositoryMetadata);
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
import java.nio.file.StandardOpenOption;
        );
    public void testUploadBlobFromByteArray() throws IOException {
            Mockito.eq(true),
 */
    public void testBuildTransferFileMetadata_NonEmptyInputStream() throws IOException {
    private void uploadBlobFromInputStream(TransferService transferService) throws IOException, InterruptedException {
import java.nio.file.Path;
            IndexMetadata::fromXContent
            this.name = name;
                @Override
        TransferService transferService = new BlobStoreTransferService(repository.blobStore(), threadPool);
        String expectedBase64String = Base64.getEncoder().encodeToString(inputData.getBytes(StandardCharsets.UTF_8));
    }
import java.util.Map;
                .build()
        byte[] checkpointBytes = "checkpoint-data".getBytes(StandardCharsets.UTF_8);
        MockAsyncFsContainer mockAsyncFsContainer = new MockAsyncFsContainer((FsBlobStore) blobStore, BlobPath.cleanPath(), null);
import java.io.ByteArrayInputStream;
import static org.mockito.Mockito.when;
import static org.opensearch.index.translog.transfer.TranslogTransferManager.CHECKPOINT_FILE_DATA_KEY;
            testFile,
        assertFalse(metadataInputStream.isClosed());
            protected void assertSnapshotOrGenericThread() {
        verify(blobContainer, Mockito.never()).asyncBlobUpload(any(WriteContext.class), any());
import java.util.List;
        return TestEnvironment.newEnvironment(
            IOException.class,
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }
            Set.of(transferFileSnapshot),
        assertNull(failure.get());
            "translog-1.tlog",
            Base64.getEncoder().encodeToString(checkpointBytes),
                public void onFailure(Exception e) {
import org.opensearch.env.TestEnvironment;
import org.opensearch.core.compress.NoneCompressor;
        );
            null
            public RemoteTransferContainer.OffsetRangeInputStreamSupplier offsetRangeInputStreamSupplier() {
        Mockito.doAnswer(invocation -> {
            Settings.builder()
        @Override
        BlobStoreTransferService transferServiceSpy = Mockito.spy(new BlobStoreTransferService(fsBlobStore, threadPool));
            Mockito.any(),
            1
        transferFileSnapshot.setMetadataFileInputStream(metadataInputStream);
    public void testBuildTransferFileMetadata_EmptyInputStream() throws IOException {
            "translog-data".getBytes(StandardCharsets.UTF_8),
        new BlobStoreTransferService(blobStore, threadPool).uploadBlob(
    public void testUploadBlobAsync() throws IOException, InterruptedException {
            new LatchedActionListener<>(ActionListener.wrap(ignored -> fail("upload should have failed"), failure::set), latch),
        }
public class BlobStoreTransferServiceTests extends OpenSearchTestCase {
        @Override
    }
        TransferService transferService = new BlobStoreTransferService(repository.blobStore(), threadPool);
    }
    }
            InputStream inputStream = blobStoreFormat.serialize(
    @Override
            Map.of(transferFileSnapshot.getPrimaryTerm(), BlobPath.cleanPath()),
import org.opensearch.Version;
        when(blobStore.isBlobMetadataEnabled()).thenReturn(true);
    }
                transferFileSnapshot,
            completionListener.onResponse(null);
import org.opensearch.common.blobstore.fs.FsBlobStore;
        }
        TrackingInputStream metadataInputStream = new TrackingInputStream(checkpointBytes);
                @Override
        AtomicBoolean succeeded = new AtomicBoolean(false);
        assertEquals("Blob metadata is not enabled for the configured blob store", exception.getMessage());
        verify(blobContainer).writeBlobWithMetadata(
        assertTrue(metadata.containsKey(CHECKPOINT_FILE_DATA_KEY));
            1
        assertEquals(0, metadataInputStream.available());
        OffsetRangeInputStream inputStream1 = inputStreamSupplier.get(1, 0);
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
import org.opensearch.repositories.blobstore.ChecksumBlobStoreFormat;
        FsBlobStore fsBlobStore = mock(FsBlobStore.class);
        assertEquals("", metadata.get(CHECKPOINT_FILE_DATA_KEY));
        when(blobStore.isBlobMetadataEnabled()).thenReturn(false);
    }
                .put(Environment.PATH_REPO_SETTING.getKey(), home.resolve("repo").toAbsolutePath())
            transferService.uploadBlob(inputStream, repository.basePath(), "test-object", WritePriority.URGENT, completionListener);
    }
        transferFileSnapshot.setMetadataFileInputStream(metadataInputStream);
            xContentRegistry(),
            "Length must come from the snapshot, not the file on disk",
    }
            transferFileSnapshot,
        );
        assertEquals(Base64.getEncoder().encodeToString(checkpointBytes), metadataCaptor.getValue().get(CHECKPOINT_FILE_DATA_KEY));
        BlobStore blobStore = mock(BlobStore.class);
            }
        BlobStore blobStore = mock(BlobStore.class);
    public void testBuildTransferFileMetadata_SmallInputStreamOptimization() throws IOException {
    }
                .put(Environment.PATH_HOME_SETTING.getKey(), home.toAbsolutePath())
        );
    }
        );
        InputStream emptyInputStream = new ByteArrayInputStream(new byte[0]);
        transferFileSnapshot.setMetadataFileInputStream(metadataInputStream);
import org.opensearch.common.blobstore.BlobStore;
        // upload must take its parts from the supplier, so a snapshot that transforms its bytes is honoured
            null
        }
            Mockito.any()
import org.opensearch.common.blobstore.transfer.RemoteTransferContainer;
        );
            null
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata(randomAlphaOfLength(10), FsRepository.TYPE, settings);
        AtomicReference<Exception> failure = new AtomicReference<>();
        try (
        BlobStore blobStore = mock(BlobStore.class);
            writeContextRef.get().getMetadata().get(CHECKPOINT_FILE_DATA_KEY)
            ).streamInput()
        FileSnapshot.TransferFileSnapshot transferFileSnapshot = new FileSnapshot.TransferFileSnapshot(
import org.opensearch.common.settings.ClusterSettings;
            Mockito.isNull()
        assertFalse(metadataInputStream.isClosed());
        Path testFile = createTempFile();
        transferServiceSpy.uploadBlobs(
            "translog-1.tlog",
        FsBlobStore fsBlobStore = mock(FsBlobStore.class);
            ActionListener<Void> completionListener = invocation.getArgument(1);
import java.util.concurrent.TimeUnit;
            clusterService,
    }
    }
    }
                    assertEquals(transferFileSnapshot.getPrimaryTerm(), fileSnapshot.getPrimaryTerm());
        assertTrue(metadata.containsKey(CHECKPOINT_FILE_DATA_KEY));
            Mockito.any(),
        );
        CountDownLatch latch = new CountDownLatch(1);
            "%s",
        public MockAsyncFsContainer(FsBlobStore blobStore, BlobPath blobPath, Path path) {
import java.nio.charset.StandardCharsets;
    public void testAsyncUploadIncludesCheckpointMetadata() throws Exception {
        final Settings idxSettings = Settings.builder()
        assertFalse(metadataInputStream.isClosed());
            WritePriority.HIGH,
        transferService.uploadBlob(transferFileSnapshot, repository.basePath(), WritePriority.HIGH, null);
        assertFalse(metadataInputStream.isClosed());
        public boolean remoteIntegrityCheckSupported() {
        new BlobStoreTransferService(blobStore, threadPool).uploadBlobs(
        assertTrue(failure.get() instanceof FileTransferException);
        );
        public void deleteBlobsAsyncIgnoringIfNotExists(List<String> blobNames, ActionListener<Void> completionListener) {
        assertTrue(latch.await(1000, TimeUnit.MILLISECONDS));
        }
        TrackingInputStream metadataInputStream = new TrackingInputStream(checkpointBytes);
import java.util.Set;
        Map<String, String> metadata = BlobStoreTransferService.buildTransferFileMetadata(inputStream);
            completionListener.onResponse(null);
        public void close() throws IOException {
    public void testSynchronousUploadIncludesCheckpointMetadata() throws IOException {
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(0, metadataInputStream.available());
            return delegate;
        MockAsyncFsContainer mockAsyncFsContainer = new MockAsyncFsContainer((FsBlobStore) blobStore, BlobPath.cleanPath(), null);
        );
    }
    }
