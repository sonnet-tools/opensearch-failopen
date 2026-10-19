     * repository, and the tracker records both files exactly as a real download would.
            ActionListener<List<BlobMetadata>> actionListener = invocation.getArgument(4);
    }
                uploadComplete.incrementAndGet();
            transferService,  
                throw new AssertionError("an upload whose fence was taken over mid-flight must not be acknowledged");
import org.opensearch.common.blobstore.InputStreamWithMetadata;
        metadata.put(CHECKPOINT_FILE_DATA_KEY, ckpDataString);  
        // Fencing enabled: delegation to the fence.  
            return null;  
        String translogFile = "translog-19.tlog", checkpointFile = "translog-19.ckp";  
                    List<TransferFileSnapshot> list = new ArrayList<>(invocationOnMock.getArgument(0));
        remoteTranslogTransferTracker = new RemoteTranslogTransferTracker(shardId, 20);  
                metadataMode
            @Override  
        isTranslogMetadataEnabled = false;
                    Thread.sleep(1000);
        FsBlobStore blobStore = new FsBlobStore(randomIntBetween(1, 8) * 1024, repoPath, false);  
        assertTrue(manager.transferSnapshot(createTransferSnapshot(), listener, null));
        long checksum = createTranslogGeneration(reused, 23, true);
            assertFalse(manager.isLocalGenerationCurrent(location, 23, String.valueOf(staleChecksum)));
    @SuppressWarnings("unchecked")
            Thread.sleep(delayForMdDownload);  
    public void testTransferSnapshotAdvancesFence() throws Exception {  
            fileTransferTracker,  
            true
        new RemoteStoreFence(container, "node-target-alloc", "node-target", shardId).validateAndAdvance(primaryTerm);  
    public void testTransferSnapshotOnThreadInterrupt() throws Exception {  
            isTranslogMetadataEnabled  
    }
    private BlobPath remoteBaseTransferPath;  
     * A generation's two files are written one after the other, so a download that dies between them must not leave a
import static org.mockito.Mockito.anySet;
import static org.mockito.Mockito.any;
            ActionListener<TransferFileSnapshot> listener = (ActionListener<TransferFileSnapshot>) invocationOnMock.getArguments()[2];
                }  
            remoteBaseTransferPath.add(METADATA.getName()),  
            public void onFailure(Exception e) {
        translogTransferManager.downloadTranslog("12", "23", location);
                eq(ThreadPool.Names.REMOTE_PURGE),
    }
            Path location = createTempDir();
    public void testTransferSnapshotWithoutFenceDoesNotRequireConditionalWrites() throws Exception {
            @Override
        RemoteStoreFence stalePrimaryFence = new RemoteStoreFence(container, "node-old-alloc", "node-old", shardId);
            DefaultRemoteStoreSettings.INSTANCE,
    }
            Runnable runnable = () -> {  
            List<BlobMetadata> bmList = List.of(bm1, bm2);
        assertTrue(remoteTranslogTransferTracker.getTotalDownloadTimeInMillis() >= delayForMdDownload);  
                fileTransferSucceeded.incrementAndGet();  
            bmList.add(new PlainBlobMetadata(tm2, 1));
            when(transferService.downloadBlob(any(BlobPath.class), eq("translog-23.ckp"))).thenAnswer(failFirstFetch);  
            remoteBaseTransferPath.add(METADATA.getName()),
            Files.delete(location.resolve(Translog.getCommitCheckpointFileName(1)));
        assertTrue(Files.exists(location.resolve("translog-23.tlog")));  
            remoteTranslogTransferTracker,
        mockSuccessfulFileUploads();  
            remoteBaseTransferPath.add(TRANSLOG.getName()),
            }  
            return null;
            remoteTranslogTransferTracker,
                tracker,
        assertTrue(uploadFailure.get().toString(), uploadFailure.get() instanceof TranslogFencedException);
            try {
            isTranslogMetadataEnabled  
    private void assertNoDownloadStats(boolean nonZeroUploadTime) {  
            remoteTranslogTransferTracker,  
            @Override
                any(BlobPath.class),
        doAnswer(invocationOnMock -> {
        assertFalse(Files.exists(location.resolve("translog-23.tlog")));  
        mockSuccessfulFileUploads();
            assertArrayEquals(ckpBytes, Files.readAllBytes(checkpointPath));
        translogTransferManager.deleteGenerationAsync(primaryTerm, Set.of(19L), () -> {});
        String ckpDataString = Base64.getEncoder().encodeToString(ckpBytes);
            try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.WRITE)) {  
        when(transferService.downloadBlob(any(BlobPath.class), any(String.class))).thenThrow(new IOException("Something went wrong"));
            }  
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);  
        mockDownloadBlobWithMetadataResponse();  
    }
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
        );  
            transferService,
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);  
    }
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
        assertEquals(primaryTerm, fence.getTerm());
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {  
        assertTrue(translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {  
                super.onFailure(fileSnapshot, e);
                createTempFile(Translog.TRANSLOG_FILE_PREFIX + (generation - 1), Translog.CHECKPOINT_SUFFIX),
            @Override
    private ShardId shardId;
        assertFalse(Files.exists(location.resolve("translog-23.ckp")));
                "translog-12.ckp",
        Path location = createTempDir();  
        Path location = createTempDir();  
            Thread.sleep(delayForBlobDownload);  
        AtomicBoolean metadataUploaded = new AtomicBoolean();
            Path checkpointPath = location.resolve(Translog.getCommitCheckpointFileName(23));  
            transferFileSnapshots.forEach(listener::onResponse);
        SetOnce<Thread> uploadThread = new SetOnce<>();
     * truncation, or a remote that does not advertise a checksum for the generation at all.
                remoteBaseTransferPath.add(METADATA.getName()),
        }
        assertEquals(4, fileTransferTracker.allUploaded().size());  
        assertEquals(0, remoteTranslogTransferTracker.getTotalDownloadsSucceeded());
    public void testReadMetadataFile() throws IOException {
        assertEquals(translogTransferManager.getMetadataBytes(metadata).length, remoteTranslogTransferTracker.getDownloadBytesSucceeded());  
    }
            remoteBaseTransferPath.add(METADATA.getName()),
            BlobMetadata bm1 = new PlainBlobMetadata(mdFilename1.get(), 1);  
        // Since the tracker already holds the files with success state, adding them with failed state would throw exception
            }  
                } catch (InterruptedException ignore) {
import org.opensearch.common.blobstore.BlobMetadata;
        String mdFilenameGen1 = new TranslogTransferMetadata(1, 1, 1, 2).getFileName();  
            isTranslogMetadataEnabled
            return null;
        assertFalse(translogTransferManager.downloadTranslogIfChanged("12", "23", location, String.valueOf(checksum)));  
        FsBlobContainer container = new FsBlobContainer(blobStore, BlobPath.cleanPath(), repoPath) {
                any(ActionListener.class)
        assertEquals(0, fence.getSeq());
            .uploadBlob(  
import org.opensearch.common.blobstore.BlobContainer;
        AtomicInteger translogTransferSucceeded = new AtomicInteger();
import org.opensearch.index.translog.transfer.FileSnapshot.CheckpointFileSnapshot;
            Thread.sleep(delayForMdDownload);
import org.opensearch.index.translog.Translog;  
        doAnswer(invocationOnMock -> {  
import org.opensearch.common.blobstore.BlobPath;  
    }
        TranslogTransferManager metadataModeManager = new TranslogTransferManager(
            remoteTranslogTransferTracker
                exception.set(ex);
        assertNotNull(exception.get());
            Set.of(  
            transferFileSnapshots.stream().skip(1).forEach(listener::onResponse);
     * With checkpoint data carried as object metadata there is no remote {@code .ckp} object, so a downloaded
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
    /**
            assertTrue(translogTransferManager.downloadTranslogIfChanged("12", "23", location, String.valueOf(checksum)));  
        assertTrue(uploadFailure.get().toString(), uploadFailure.get() instanceof TranslogUploadFailedException);
import static org.mockito.Mockito.doNothing;  
            transferService,  
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
    }
        Files.createFile(location.resolve("translog-23.ckp"));
import org.apache.lucene.tests.util.LuceneTestCase;
            TranslogTransferManager manager = new TranslogTransferManager(  
                public Set<TransferFileSnapshot> getTranslogFileSnapshotWithMetadata() throws IOException {
        assertEquals(translogTransferManager.getMetadataBytes(metadata).length, remoteTranslogTransferTracker.getDownloadBytesSucceeded());
            ),  
        RemoteStoreFence fence = new RemoteStoreFence(container, "node-1-alloc", "node-1", shardId);  
            shardId,
        String tm1 = new TranslogTransferMetadata(1, 1, 1, 2).getFileName();
        remoteBaseTransferPath = new BlobPath().add("base_path");  
        assertTrue(translogTransferManager.getFileTransferTracker().allUploaded().isEmpty());  
            remoteStoreSettings,  
        }, null));
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
        Files.createFile(location.resolve(checkpointFile));
        assertFalse(manager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
        }
        assertTrue(translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {  
        assertEquals(0, exception.get().getSuppressed().length);  
     * exactly the same state, so callers that iterate tracked files see no difference between the two paths.
        uploadThread.get().interrupt();
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        assertNull(uploadFailure.get());  
            uploadFailure.get() instanceof TranslogFencedException
            shardId,  
                assertEquals(3, blobMetadata.size());
        String tm = new TranslogTransferMetadata(1, 2, 1, 2, nodeId).getFileName();
        assertNoDownloadStats(false);
            public void onUploadComplete(TransferSnapshot transferSnapshot) {  
        when(shardId.getIndex()).thenReturn(new Index("index", "indexUUid"));
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());
            DefaultRemoteStoreSettings.INSTANCE,
        when(transferService.downloadBlob(any(BlobPath.class), eq(mdFilename1.get()))).thenThrow(new IOException("Something went wrong"));
        );
                    listener.onResponse(transferFileSnapshot);
        doAnswer(invocation -> {
        super.tearDown();  
    private void mockDownloadBlobWithMetadataResponse() throws IOException {  
    }  
            Answer<Object> failFirstFetch = invocation -> {
            new ShardId("index", "indexUUid", 0),
        for (boolean metadataMode : new boolean[] { false, true }) {
                } catch (InterruptedException e) {  
        );  
            return new ByteArrayInputStream(ckpBytes);  
        TranslogTransferMetadata metadata1 = new TranslogTransferMetadata(1, 1, 1, 2);
            public void onSuccess(TransferFileSnapshot fileSnapshot) {  
import org.opensearch.index.translog.transfer.listener.TranslogTransferListener;
                DefaultRemoteStoreSettings.INSTANCE,
            DefaultRemoteStoreSettings.INSTANCE,  
        assertEquals(1, translogTransferSucceeded.get());
import org.opensearch.index.translog.transfer.FileSnapshot.TransferFileSnapshot;  
                public TranslogTransferMetadata getTranslogTransferMetadata() {
        FsBlobContainer container = fenceContainer();  
        translogTransferManager.deleteGenerationAsync(primaryTerm, Set.of(19L), () -> {});  
            CheckpointFileSnapshot checkpointFileSnapshot2 = new CheckpointFileSnapshot(  
        };
        fenced.transferFenceOwnership(primaryTerm, "target-alloc");  
        tracker.add(checkpointFile, true);
    public void testReadMetadataForGivenTimestampException() throws IOException {
        {
            transferService,
        translogTransferManager.listTranslogMetadataFilesAsync(new ActionListener<>() {
        verify(transferService).downloadBlob(any(BlobPath.class), eq(checkpointFile));
                createTempFile(Translog.TRANSLOG_FILE_PREFIX + generation, Translog.TRANSLOG_FILE_SUFFIX),
                eq(files),
        );  
        assertTrue(manager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {  
            ActionListener<TransferFileSnapshot> listener = invocationOnMock.getArgument(2);
import static org.mockito.Mockito.times;  
        assertEquals(3, fileTransferTracker.allUploaded().size());
        assertTrue("fence CAS was issued before the metadata upload completed", casSawMetadataUploaded.get());
            @Override
                channel.truncate(Files.size(translogPath) - 1);
            blobStoreTransferService,
        assertTrue(tracker.uploaded("translog-23.ckp"));  
        }).when(transferService)  
        isTranslogMetadataEnabled = true;  
            long checksum = createTranslogGeneration(location, 1, true);
        // Translog file truncated after the checkpoint was written.
            remoteBaseTransferPath.add(TRANSLOG.getName()),
        });
                    return "test-to-string";  
     * A local generation whose footer checksum equals the advertised one is reused: nothing is fetched from the
        BlobContainer blobContainer = mock(BlobContainer.class);
            return null;
            transferService,
            public void onResponse(List<BlobMetadata> blobMetadata) {  
        assertEquals(0, fileTransferFailed.get());  
            uploadThread.get().start();  
        verify(transferService, times(0)).downloadBlob(any(BlobPath.class), eq("translog-23.tlog"));
        when(transferService.downloadBlob(any(BlobPath.class), eq(mdFilename))).thenThrow(new IOException("Something went wrong"));
                public Set<TransferFileSnapshot> getTranslogFileSnapshots() {  
        // Order witness: the CAS must be issued only after the metadata upload completed ("the chain gates the
    }
        }).when(transferService)
            transferFileSnapshot,
        FileTransferTracker reuseTracker = new FileTransferTracker(new ShardId("index", "indexUuid", 0), remoteTranslogTransferTracker);
            Set<TransferFileSnapshot> transferFileSnapshots = (Set<TransferFileSnapshot>) invocationOnMock.getArguments()[0];
            true
        String timestamp1 = RemoteStoreUtils.invertLong(2345L);  
            @Override  
            List<BlobMetadata> bmList = new LinkedList<>();  
            remoteBaseTransferPath.add(METADATA.getName()),
        byte[] before = Files.readAllBytes(location.resolve("translog-23.tlog"));
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
        {
        TranslogTransferListener listener = new TranslogTransferListener() {
                shardId,
                "translog-45.ckp"
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
                }
        TransferFileSnapshot transferFileSnapshot = new TransferFileSnapshot("translog-23.tlog", tlogBytes, 12);
        FsBlobStore blobStore = new FsBlobStore(randomIntBetween(1, 8) * 1024, repoPath, false);  
                null
    }
        doAnswer(invocation -> {
            }
        doAnswer(invocationOnMock -> {
                try {
        assertEquals(2L, (long) (actualOutput.v1().v2()));
        RemoteStoreFence fence = new RemoteStoreFence(container, "node-1-alloc", "node-1", shardId);
    }
        assertEquals(0, remoteTranslogTransferTracker.getLastSuccessfulDownloadTimestamp());  
            public void onFailure(TransferFileSnapshot fileSnapshot, Exception e) {
    }
        generation = randomNonNegativeLong();
        Files.createFile(location.resolve(translogFile));
            }
            shardId,
import java.util.Objects;
            bmList.add(new PlainBlobMetadata(tm1, 1));
            new ShardId("index", "indexUUid", 0),
            latchedActionListener.onResponse(bmList);  
                    Thread.sleep(31 * 1000);  
                }
        TranslogTransferListener listener = new TranslogTransferListener() {  
            @Override
        });  
        assertNull(translogTransferManager.readMetadata());
        assertNoDownloadStats(false);
                fileTransferFailed.incrementAndGet();  
            t.start();
        assertTrue(exception.get() instanceof TranslogUploadFailedException);
        // The retry recovers: the fence bootstraps and the upload is acknowledged.  
import java.nio.file.Path;  
            tracker,
    public void testDeleteStaleTranslogMetadata() {
                exception.set(ex);
            verify(transferService).listAllInSortedOrderAsync(  
    public void testSynchronousUploadMetadataRecoversCheckpointWithoutCheckpointBlob() throws IOException {
        // while this upload's metadata PUT is in flight, then reads its restore point - which cannot include this  
        // The interleaving that lost acked writes under the concurrent design: a new primary claims the fence
            return null;  
        Thread thread = new Thread(() -> {
            remoteBaseTransferPath.add(METADATA.getName()),
            transferFileSnapshots.forEach(listener::onResponse);  
import org.opensearch.test.OpenSearchTestCase;
        minTranslogGeneration = randomLongBetween(0, generation);
                return super.writeBlobConditionally(blobName, inputStream, blobSize, expectedVersionToken);  
    public void testTransferSnapshotOnFileTransferUploadFail() throws Exception {  
     * stale checkpoint beside a fresh translog: the next reconciliation reads the footer at the checkpoint's offset, and  
import org.opensearch.index.translog.TranslogReader;
        // takeover's sweep while the metadata PUT is still in flight; the takeover then reads a restore point
            @Override
                }
        AtomicBoolean failNextCas = new AtomicBoolean(true);
        );
        when(blobStore.isBlobMetadataEnabled()).thenReturn(true);
        AtomicReference<Map<String, String>> uploadedMetadata = new AtomicReference<>();
            shardId,  
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
        }).when(transferService).uploadBlob(any(TransferFileSnapshot.class), any(BlobPath.class), any(WritePriority.class), any());
    public void testReadMetadataReadException() throws IOException {  
            return null;
        String timestamp1 = RemoteStoreUtils.invertLong(2345L);
    private long generation;  
        verify(transferService, times(0)).downloadBlobWithMetadata(any(BlobPath.class), any(String.class));  
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
        Map<String, String> metadata = new HashMap<>();
            @Override  
        when(transferService.downloadBlob(any(BlobPath.class), eq(mdFilename1.get()))).thenAnswer(invocation -> {
        AtomicInteger translogTransferFailed = new AtomicInteger();  
            remoteTranslogTransferTracker
        assertThrows(RuntimeException.class, translogTransferManager::readMetadata);
            fileTransferTracker,  
import org.opensearch.common.blobstore.stream.write.WritePriority;
        assertTrue(Files.exists(location.resolve("translog-23.ckp")));  
    }
            @Override
            // And the full path downloads it, replacing the corrupt local files.
            assertFalse("checkpoint must be gone before the remote is contacted", checkpointPresentAtFetch.get());
        };
import java.util.LinkedList;
            transferService,
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum)));
     * which callers treat as tragic — and the next sync must recover and claim the chain.  
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
        RemoteStoreFence fence = new RemoteStoreFence(container, "node-source-alloc", "node-source", shardId);
        assertEquals(0, translogTransferFailed.get());
            }));
            ActionListener<List<BlobMetadata>> actionListener = invocation.getArgument(4);  
            return null;  
import java.io.IOException;
    public void testMetadataConflict() throws InterruptedException {  
        FsBlobContainer container = fenceContainer();
        thread.start();
        Path location = createTempDir();
        assertEquals(String.valueOf(Objects.hash(nodeId)), actualOutput.v2());  
        TranslogTransferMetadata tm2 = new TranslogTransferMetadata(1, 1, 1, 2, "node--2");
import org.opensearch.threadpool.ThreadPool;
        assertThrows(IOException.class, translogTransferManager::readMetadata);  
            remoteBaseTransferPath.add(TRANSLOG.getName()),
                any(ActionListener.class)
import static org.mockito.Mockito.doAnswer;
        assertEquals(0, fence.getSeq());  
            bmList.add(new PlainBlobMetadata(tm3, 1));
            assertFalse("translog must be gone before the remote is contacted", translogPresentAtFetch.get());  
            @Override
    }
                null
            @Override  
        TranslogReader reader4 = mock(TranslogReader.class);
        AtomicInteger fileTransferFailed = new AtomicInteger();
            shardId,  
        // acked-write loss (RemoteStoreFence.tla in formal-models/ exhibits the trace with SEQUENCED = FALSE).
        }).when(transferService)
    private long minTranslogGeneration;
            null
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
        assertTrue(metadataModeManager.downloadTranslogIfChanged("12", "23", downloaded, null));
    private RemoteTranslogTransferTracker remoteTranslogTransferTracker;
                    return new TranslogTransferMetadata(primaryTerm, generation, minTranslogGeneration, randomInt(5));  
    /**  
            List<BlobMetadata> bmList = new LinkedList<>();
                return super.writeBlobConditionally(blobName, inputStream, blobSize, expectedVersionToken);
            long checksum = createTranslogGeneration(location, 1, true);
            tracker,
        assertEquals("Failed to upload 1 files during transfer", exception.get().getMessage());
                translogTransferFailed.incrementAndGet();
                throws IOException {
            @Override  
        assertFalse(  
                    }
    public void testGetPrimaryTermAndGeneration() {  
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
    }  
            tracker,
            );  
                    return Set.of(translogFileSnapshot1, translogFileSnapshot2);
            shardId,
            BlobMetadata bm2 = new PlainBlobMetadata("metadata__1__12__" + timestamp2 + "__node1__1", 1);  
        BlobContainer blobContainer = mock(BlobContainer.class);
        assertFalse(Files.exists(location.resolve("translog-23.ckp")));
        String tm1 = new TranslogTransferMetadata(1, 1, 1, 2).getFileName();  
                translogTransferSucceeded.incrementAndGet();  
            AtomicBoolean translogPresentAtFetch = new AtomicBoolean(true);  
        AtomicInteger uploadComplete = new AtomicInteger();
            tracker,  
            new ShardId("index", "indexUUid", 0),
    byte[] tlogBytes;  
                @Override  
        when(transferService.downloadBlob(any(BlobPath.class), eq(mdFilename1))).thenAnswer(invocation -> {
            remoteBaseTransferPath.add(METADATA.getName()),
                eq(Integer.MAX_VALUE),
            return new ByteArrayInputStream(translogTransferManager.getMetadataBytes(metadata));  
    public void testMetadataFileNameOrder() throws IOException {
import org.opensearch.indices.RemoteStoreSettings;
     */
            remoteBaseTransferPath.add(METADATA.getName()),  
        assertFalse(manager.transferSnapshot(createTransferSnapshot(), listener, null));
        assertFalse(manager.transferSnapshot(createTransferSnapshot(), listener, null));
        Path repoPath = createTempDir();
import org.opensearch.common.blobstore.fs.FsBlobStore;
                generation - 1,  
        );
        Files.createFile(location.resolve("translog-23.tlog"));
            DefaultRemoteStoreSettings.INSTANCE,  
            Path translogPath = location.resolve(Translog.getFilename(1));
        primaryTerm = randomLongBetween(1, 1000);
            String timestamp2 = RemoteStoreUtils.invertLong(3456L);
            } catch (IOException e) {  
        tracker = new FileTransferTracker(new ShardId("index", "indexUuid", 0), remoteTranslogTransferTracker);  
        });
        TranslogTransferMetadata metadata = createTransferSnapshot().getTranslogTransferMetadata();  
            // The remote fails on the very first request; record what was still on disk at that moment.
            @Override
    public void testPopulateFileTrackerWithLocalState() {  
        tracker.add(translogFile, true);
        TranslogTransferMetadata metadata2 = new TranslogTransferMetadata(1, 0, 1, 2);
        assertTrue(manager.transferSnapshot(createTransferSnapshot(), listener, null));  
        TranslogReader reader1 = mock(TranslogReader.class);
     * The fence wrappers answer for both configurations. With no fence (fencing disabled) callers get the safe
        if (nonZeroUploadTime == false) {
            return null;  
        mockDownloadBlobWithMetadataResponse();
     * never needs to know whether the feature is on. With a fence they delegate to it.  
        when(reader1.getGeneration()).thenReturn(12L);
        assertTrue("the target never wrote, so the revert reclaims ownership", fenced.revertFenceOwnership(primaryTerm));
                any(BlobPath.class),
    public void testDeleteTranslogFailure() throws Exception {
import java.util.concurrent.atomic.AtomicReference;  
        };
            public void onUploadComplete(TransferSnapshot transferSnapshot) {}
        assertTrue(Files.exists(location.resolve("translog-23.tlog")));
        assertTrue(tracker.uploaded("translog-23.tlog"));
                @Override  
        assertTrue(tracker.uploaded("translog-23.ckp"));  
            isTranslogMetadataEnabled
import java.io.ByteArrayInputStream;  
        BlobStore blobStore = mock(BlobStore.class);  
            long checksum = createTranslogGeneration(location, 1, false);  
            }
        FileTransferTracker tracker = new FileTransferTracker(new ShardId("index", "indexUuid", 0), remoteTranslogTransferTracker);
        doAnswer(invocation -> {
    byte[] ckpBytes;
    }
            remoteTranslogTransferTracker
            remoteBaseTransferPath.add(METADATA.getName()),  
            Path location = createTempDir();
            @Override
import org.opensearch.core.index.Index;
            remoteBaseTransferPath.add(TRANSLOG.getName()),
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();
        return TestTranslog.createTranslogGeneration(random(), location, generation, withFooter);  
            }
            latchedActionListener.onResponse(bmList);  
    @SuppressWarnings("unchecked")
        );
import org.opensearch.action.LatchedActionListener;
            DefaultRemoteStoreSettings.INSTANCE,  
            BlobMetadata bm2 = new PlainBlobMetadata("metadata__1__12__" + timestamp2 + "__node1__1", 1);
        BlobStore blobStore = mock(BlobStore.class);
        assertEquals("Timed out waiting for transfer of snapshot test-to-string to complete", exception.get().getMessage());  
                any(TransferFileSnapshot.class),
        super.setUp();  
        tlogBytes = "Hello Translog".getBytes(StandardCharsets.UTF_8);
import java.nio.channels.FileChannel;  
import java.nio.charset.StandardCharsets;
        translogTransferManager = new TranslogTransferManager(
        translogTransferManager = new TranslogTransferManager(
        };
import org.opensearch.common.blobstore.fs.FsBlobContainer;  
        TranslogTransferManager fenced = fencedTransferManager(fence, tracker);
        SetOnce<Exception> exception = new SetOnce<>();
        assertEquals(0, translogTransferSucceeded.get());  
            shardId,  
import java.util.concurrent.atomic.AtomicInteger;
        terminate(threadPool);
        List<String> files = List.of(checkpointFile, translogFile);
        assertNull(translogTransferManager.readMetadata(1234L));  
        tracker.add(checkpointFile, true);
     * defaults - never superseded, a handoff transfer is a no-op, an aborted handoff may resume - so gating code
            @Override
        assertNoDownloadStats(false);  
                }
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {  
        BlobStore blobStore = mock(BlobStore.class);  
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum)));
import static org.mockito.Mockito.mock;
            byte[] bytes = Files.readAllBytes(checkpointPath);
                public Set<TransferFileSnapshot> getCheckpointFileSnapshots() {
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, null));
            ActionListener<TransferFileSnapshot> listener = (ActionListener<TransferFileSnapshot>) invocationOnMock.getArguments()[2];
     * download: checksum mismatch, footer-less file, missing checkpoint, checkpoint for a different generation,
        String mdFilename2 = metadata2.getFileName();  
import java.nio.file.Files;
    public void testTransferSnapshotFencedByNewOwnerAtSameTerm() throws Exception {
import org.opensearch.indices.DefaultRemoteStoreSettings;  
                generation,
            remoteTranslogTransferTracker,
        }, null));  
        assertEquals(0, translogTransferFailed.get());
        // Expect delay for both tlog and ckp file
        TranslogTransferMetadata tm = new TranslogTransferMetadata(1, 1, 1, 2);
                    return Set.of(checkpointFileSnapshot1, checkpointFileSnapshot2);
        FileTransferTracker fileTransferTracker = new FileTransferTracker(
            Path location = createTempDir();
                super.onSuccess(fileSnapshot);
    }
        AtomicInteger fileTransferSucceeded = new AtomicInteger();
            uploadedMetadata.set(Map.copyOf(invocation.getArgument(4)));
        verify(transferService, times(0)).downloadBlob(any(BlobPath.class), eq("translog-23.ckp"));  
            return null;
                    public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
        assertTrue(Files.exists(location.resolve(checkpointFile)));  
                super.onSuccess(fileSnapshot);
        assertNotNull(uploadFailure.get());
        assertEquals(Set.of("translog-12.tlog", "translog-23.tlog"), translogTransferManager.getFileTransferTracker().allUploaded());
        String mdFilenamePrimary2 = new TranslogTransferMetadata(2, 1, 1, 2).getFileName();
        TranslogReader reader2 = mock(TranslogReader.class);
                @Override
            bmList.add(new PlainBlobMetadata(mdFilename2, 1));
            remoteBaseTransferPath.add(TRANSLOG.getName()),
        assertThrows(IOException.class, translogTransferManager::readMetadata);  
    }
                    translogFileSnapshot1.setMetadataFileInputStream(checkpointFileSnapshot1.inputStream());
        long checksum = createTranslogGeneration(location, 23, true);
                    translogFileSnapshot2.setMetadataFileInputStream(checkpointFileSnapshot2.inputStream());  
    public void testTakeoverBetweenMetadataUploadAndCasIsNotAcknowledged() throws Exception {
        AtomicBoolean casSawMetadataUploaded = new AtomicBoolean();  
            return new TransferSnapshot() {
        threadPool = new TestThreadPool(getClass().getName());
        }).when(transferService)
    public void testPopulateFileTrackerWithLocalStateUsingTranslogMetadata() {
            Thread.sleep(delayForBlobDownload);
            DefaultRemoteStoreSettings.INSTANCE,  
            }  
        AtomicReference<byte[]> uploadedTranslog = new AtomicReference<>();
        };
        TranslogTransferManager manager = fencedTransferManager(fence, tracker);
    public void testReadMetadataForGivenTimestampFile() throws IOException {  
        });
                try {
     */
    }  
            );
            };
            remoteTranslogTransferTracker  
        }
        translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
        when(blobContainer.readBlobWithMetadata("translog-23.tlog")).thenAnswer(  
        when(transferService.downloadBlob(any(BlobPath.class), eq("translog-23.ckp"))).thenAnswer(invocation -> {
    }
                fileTransferFailed.incrementAndGet();
        });
            }  
                any(BlobPath.class),  
        String mdFilename = tm.getFileName();
            Thread.sleep(delayForBlobDownload);
        translogTransferManager.populateFileTrackerWithLocalState(List.of(reader1, reader2, reader3, reader4));
                    listener.onFailure(new FileTransferException(list.get(0), ignore));  
    private long createTranslogGeneration(Path location, long generation, boolean withFooter) throws IOException {
        doAnswer(invocation -> {  
            return null;
    }
                uploadFailure.set(ex);  
    public void testTransferSnapshotFencedByHigherTermBeforeBootstrap() throws Exception {  
                any(WritePriority.class),  
        List<String> files = List.of(tm2, tm3);
        new RemoteStoreFence(container, "node-new-alloc", "node-new", shardId).validateAndAdvance(primaryTerm + 1);
        mockSuccessfulFileUploads();
        );
    public void testReadMetadataForGivenTimestampNoMatchingFile() throws IOException {
        String tm3 = new TranslogTransferMetadata(2, 3, 1, 2).getFileName();
            fileTransferTracker,
                throws IOException {
        assertEquals(1, fence.getSeq());
        String tm2 = new TranslogTransferMetadata(1, 2, 1, 2).getFileName();
            DefaultRemoteStoreSettings.INSTANCE,
                }
                any()
                }
            assertTrue(exception.get() instanceof TranslogUploadFailedException);
            List<BlobMetadata> bmList = new LinkedList<>();  
            WritePriority.HIGH,
    }  
            assertTrue(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum)));
            );
        RemoteStoreFence fence = new RemoteStoreFence(fenceContainer(), "node-1-alloc", "node-1", shardId);
            transferService,
                generation,  
                any(WritePriority.class),  
            bmList.add(new PlainBlobMetadata(tm2, 1));  
        tracker.add(translogFile, true);
        // refused rather than acknowledged: the metadata file is a harmless never-acknowledged orphan.
        TranslogTransferManager manager = new TranslogTransferManager(
        assertEquals(0, fence.getSeq());
    }
        assertTlogCkpDownloadStatsWithMetadata();
        assertTrue(Files.exists(location.resolve("translog-23.ckp")));  
            public void onUploadComplete(TransferSnapshot transferSnapshot) {}
import java.nio.file.StandardOpenOption;
        TranslogTransferManager manager = fencedTransferManager(stalePrimaryFence, tracker);
        }).when(transferService)
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
            new ShardId("index", "indexUUid", 0),
        doAnswer(invocationOnMock -> {  
        assertBusy(() -> {  
            reuseTracker,
        TranslogTransferManager manager = fencedTransferManager(fence, tracker);  
            return null;  
            remoteTranslogTransferTracker,
    }
    @Override
            }  
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(eq(files));
        // Local generation written before footers existed.  
            bmList.add(new PlainBlobMetadata(tm1, 1));  
                assertEquals(blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList()), List.of(tm1, tm2, tm3));
            .listAllInSortedOrderAsync(  
import java.util.UUID;  
     */
        TranslogTransferManager manager = fencedTransferManager(fence, tracker);
                translogTransferFailed.incrementAndGet();
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);  
    private TransferSnapshot createTransferSnapshot() throws IOException {  
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.eq;
            return null;
        }  
        assertTlogCkpDownloadStats();
    public void testTransferSnapshotWithTranslogMetadata() throws Exception {  
    public void testDownloadTranslogRemovesStaleLocalFilesBeforeFetching() throws IOException {
import org.opensearch.threadpool.TestThreadPool;  
        SetOnce<Exception> exception = new SetOnce<>();
            remoteTranslogTransferTracker,
        String translogFile = "translog-19.tlog", checkpointFile = "translog-19.ckp";  
        });
            latchedActionListener.onResponse(bmList);
        ckpBytes = "Hello Checkpoint".getBytes(StandardCharsets.UTF_8);
        // A subsequent sync advances the same CAS chain
            Set<TransferFileSnapshot> transferFileSnapshots = (Set<TransferFileSnapshot>) invocationOnMock.getArguments()[0];  
        mockSuccessfulFileUploads();  
            }
            AtomicBoolean checkpointPresentAtFetch = new AtomicBoolean(true);
            Set<TransferFileSnapshot> transferFileSnapshots = (Set<TransferFileSnapshot>) invocationOnMock.getArguments()[0];
        // A reused generation in a fresh tracker must register the very same set.
        when(reader3.getGeneration()).thenReturn(34L);  
                fileTransferSucceeded.incrementAndGet();
            @Override
            DefaultRemoteStoreSettings.INSTANCE,
    }
        translogTransferManager.populateFileTrackerWithLocalState(List.of(reader1, reader2));
     * When the local copy cannot be proven current the generation is downloaded, and nothing is registered with the
            Files.write(checkpointPath, bytes);  
        assertFalse(manager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
import org.opensearch.core.index.shard.ShardId;
            String timestamp2 = RemoteStoreUtils.invertLong(3456L);  
 *
            .listAllInSortedOrderAsync(
/*  
                throw new RuntimeException(e);
        {  
            metadataUploaded.set(true);
        Path location = createTempDir();  
            }
    }
        try {
        // asserting that new primary followed new generation are lexicographically smallest
import java.util.Map;  
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();  
    private ThreadPool threadPool;
    }
        assertNotNull(uploadFailure.get());  
        verify(blobContainer, times(1)).readBlobWithMetadata("translog-23.tlog");
                ActionListener<TransferFileSnapshot> listener = invocationOnMock.getArgument(2);
        SetOnce<Exception> exception = new SetOnce<>();  
            }  
        transferService = mock(TransferService.class);
                new RuntimeException("FileTransferUploadNeedsToFail-Exception")
            List<BlobMetadata> bmList = List.of(bm1, bm2);
                createTempFile(Translog.TRANSLOG_FILE_PREFIX + generation, Translog.CHECKPOINT_SUFFIX),  
            isTranslogMetadataEnabled
            public void onFailure(TransferFileSnapshot fileSnapshot, Exception e) {  
        when(reader2.getGeneration()).thenReturn(23L);
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
            BlobMetadata bm1 = new PlainBlobMetadata("metadata__1__12__" + timestamp1 + "__node1__1", 1);
            @Override
            remoteBaseTransferPath.add(METADATA.getName()),  
import static org.mockito.Mockito.when;
        assertTrue(remoteTranslogTransferTracker.getTotalDownloadTimeInMillis() >= 2 * delayForBlobDownload);  
     * Every way in which the local copy can fail to prove it is identical to the remote one must fall back to a  
        FileTransferTracker fileTransferTracker = new FileTransferTracker(  
                primaryTerm,
            isTranslogMetadataEnabled
            @Override
        ) {
        AtomicReference<String> mdFilename1 = new AtomicReference<>();
 * compatible open source license.
            Files.move(
            ActionListener<TransferFileSnapshot> listener = (ActionListener<TransferFileSnapshot>) invocationOnMock.getArguments()[2];
        FsBlobContainer container = fenceContainer();
            }
        fence.validateAndAdvance(primaryTerm); // this copy owns the chain  
    }
            CheckpointFileSnapshot checkpointFileSnapshot1 = new CheckpointFileSnapshot(
            @Override
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        doAnswer(invocation -> {  
                "translog-34.ckp",  
            transferService,  
                location.resolve(Translog.getCommitCheckpointFileName(2)),
                fileTransferSucceeded.incrementAndGet();
    public void testDownloadTranslogWithTrackerUpdated() throws IOException {
            DefaultRemoteStoreSettings.INSTANCE,  
        assertEquals(1, fileTransferFailed.get());
        {
            true
        verify(transferService).downloadBlob(any(BlobPath.class), eq("translog-23.ckp"));
            }
            tracker,
        verify(transferService).downloadBlob(any(BlobPath.class), eq(translogFile));  
        assertEquals(afterDownload, reuseTracker.allUploaded());
        assertTrue(tracker.uploaded("translog-23.tlog"));
            fileTransferTracker,
            Path location = createTempDir();
            return null;  
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());
     */  
        AtomicInteger translogTransferSucceeded = new AtomicInteger();  
            public void onSuccess(TransferFileSnapshot fileSnapshot) {
            // Whatever the next attempt finds, it cannot be trusted.  
            Path location = createTempDir();  
        String mdFilename = tm.getFileName();
            });  
        }
        assertTlogCkpDownloadStats();
                eq(ThreadPool.Names.REMOTE_PURGE),
            .uploadBlob(  
            listener.onFailure(testException);
        assertNoDownloadStats(true);
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 23, String.valueOf(checksum)));
import java.util.Base64;
import org.opensearch.common.SetOnce;  
                    @Override
        tracker.add(translogFile, true);
            bytes[bytes.length / 2] ^= 0x1;
            @Override
                    @Override
        assertEquals(2, fileTransferTracker.allUploaded().size());  
import org.opensearch.common.blobstore.BlobStore;
        // Interrupt the thread
        when(transferService.downloadBlob(any(BlobPath.class), eq("translog-23.tlog"))).thenAnswer(invocation -> {
    public void testReadMetadataForGivenTimestampNoFile() throws IOException {  
            latchedActionListener.onFailure(new IOException("Issue while listing"));
                }
            );  
                translogTransferSucceeded.incrementAndGet();
        when(transferService.downloadBlobWithMetadata(any(BlobPath.class), eq("translog-23.tlog"))).thenAnswer(invocation -> {
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
                uploadFailure.set(ex);
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();  
 * SPDX-License-Identifier: Apache-2.0
            blobStoreTransferService,
                throw new AssertionError(ex);  
            createTranslogGeneration(location, 2, true);  
        assertTrue(exception.get() instanceof TranslogUploadFailedException);
            assertEquals("Failed to upload test-to-string", exception.get().getMessage());  
        primaryTerm = randomNonNegativeLong();
        TranslogReader reader1 = mock(TranslogReader.class);
    boolean isTranslogMetadataEnabled;
            }
}
    /**
        assertFalse(unfenced.isFenceSuperseded(primaryTerm));
        return new TranslogTransferManager(
                fileTransferFailed.incrementAndGet();
        };  
        AtomicReference<String> mdFilename1 = new AtomicReference<>();
            shardId,  
            public void onUploadComplete(TransferSnapshot transferSnapshot) {}  
            remoteBaseTransferPath.add(TRANSLOG.getName()),
        Path reused = createTempDir();
     * The fatal/retryable boundary: only a genuinely lost CAS may fail the shard. A transient repository error during
            return null;
        assertEquals(metadata, translogTransferManager.readMetadata());  
            }  
            }
            remoteTranslogTransferTracker,
        // when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);  
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));  
                @Override
    private FsBlobContainer fenceContainer() throws IOException {
    }
                uploadFailure.set(ex);
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();
                throw new IOException("simulated failure before any byte was written");
            actionListener.onResponse(bmList);  
    public void testIsLocalGenerationCurrentFallsBackWhenLocalStateCannotBeTrusted() throws IOException {
 */  
package org.opensearch.index.translog.transfer;
        assertTrue(uploadFailure.get().toString(), uploadFailure.get() instanceof TranslogFencedException);  
            }
        {
                actualFileSnapshot,  
            return null;
        }).when(transferService)  
        manager.downloadTranslog("12", "23", location);
            bmList.add(new PlainBlobMetadata(mdFilename2, 1));
            }
        AtomicInteger translogTransferFailed = new AtomicInteger();
                throw new AssertionError(ex);
        assertBusy(() -> assertTrue(fetchCompleted.get()));  
            remoteBaseTransferPath.add(TRANSLOG.getName()),
        String nodeId = UUID.randomUUID().toString();
        thread.interrupt();
        shardId = mock(ShardId.class);  
        assertEquals(tlogBytes.length, remoteTranslogTransferTracker.getDownloadBytesSucceeded());
        );
            );  
            latchedActionListener.onResponse(bmList);
        }, null));
        assertTrue(translogTransferManager.getFileTransferTracker().allUploaded().isEmpty());  
            remoteBaseTransferPath.add(TRANSLOG.getName()).add("12"),  
                    throw new RuntimeException(e);
                public String toString() {
        BlobStoreTransferService blobStoreTransferService = new BlobStoreTransferService(blobStore, threadPool);
    }
    private long primaryTerm;
    public void testReadMetadataListException() throws IOException {
        // TranslogCorruptedException here, which must be treated as "cannot trust, download" rather than propagate  
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum)));  
import org.mockito.Mockito;  
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
            throw new IOException("Failed to create transfer snapshot");
        uploadFailure.set(null);
            };
        assertEquals(0, fileTransferFailed.get());  
        }, null);  
import static org.mockito.Mockito.verify;
            latchedActionListener.onResponse(bmList);  
        // Checkpoint file corrupt (CRC no longer matches). Checkpoint.read throws the unchecked
import java.util.Set;
                any(ActionListener.class)
        assertEquals(2, fileTransferSucceeded.get());
        FsBlobStore blobStore = new FsBlobStore(randomIntBetween(1, 8) * 1024, repoPath, false);  
                any(BlobPath.class),
        }
    public void testReadMetadataNoFile() throws IOException {
    }
            remoteBaseTransferPath.add(TRANSLOG.getName()),
            String timestamp2 = RemoteStoreUtils.invertLong(3456L);
        ) {  
        }).when(transferService)
        TranslogReader reader2 = mock(TranslogReader.class);  
        assertArrayEquals(tlogBytes, Files.readAllBytes(location.resolve("translog-23.tlog")));
        String tm2 = new TranslogTransferMetadata(1, 2, 1, 2).getFileName();  
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;  
    public void testDownloadTranslogIfChangedReusesCurrentLocalGeneration() throws IOException {
        doAnswer(invocationOnMock -> {
            remoteBaseTransferPath.add(TRANSLOG.getName()),
        });
    }
            Set<TransferFileSnapshot> transferFileSnapshots = invocationOnMock.getArgument(0);
        assertEquals(14, count);
        doAnswer(invocation -> {  
        long delayForMdDownload = 1;  
    public void testlistTranslogMetadataFilesAsync() throws Exception {
        // Fencing disabled: no fence.  
            bmList.add(new PlainBlobMetadata(mdFilename1, 1));
            @Override
            @Override
            isTranslogMetadataEnabled
                "translog-23.ckp",
        }  
            public void onSuccess(TransferFileSnapshot fileSnapshot) {  
            .writeBlobWithMetadata(eq("translog-23.tlog"), any(InputStream.class), Mockito.anyLong(), eq(true), any(), Mockito.isNull());
        }, null));
        RemoteStoreFence fence = new RemoteStoreFence(container, "node-old-alloc", "node-old", shardId);
            );  
        );
    }
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum)));
        assertArrayEquals(ckpBytes, Files.readAllBytes(location.resolve("translog-23.ckp")));
            isTranslogMetadataEnabled,
            new ShardId("index", "indexUUid", 0),  
                "translog-12.tlog",
        // checkpoint is a state the download now has to cope with.
            latchedActionListener.onResponse(bmList);  
        // A higher-term primary already owns the fence
            List<BlobMetadata> bmList = List.of(bm1, bm2);  
        Path location = createTempDir();
    public void tearDown() throws Exception {
                translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {  
    public void testTransferSnapshot() throws Exception {
        assertEquals(1, uploadComplete.get());  
import java.io.InputStream;
        BlobStoreTransferService blobStoreTransferService = new BlobStoreTransferService(blobStore, threadPool);
            transferService,
    }
            FileTransferException testException = new FileTransferException(
    private void mockSuccessfulFileUploads() throws Exception {  
        doNothing().when(transferService)
        assertTrue(Files.exists(downloaded.resolve("translog-23.ckp")));  
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
            shardId,
                eq(TranslogTransferMetadata.METADATA_PREFIX),  
            );  
import org.opensearch.common.unit.TimeValue;
        assertTrue(Files.exists(location.resolve(translogFile)));
                super.onSuccess(fileSnapshot);
        );
        // when any later takeover reads its restore point. Issued concurrently instead, the CAS can win before a
            actionListener.onResponse(bmList);
            );
    TranslogTransferManager translogTransferManager;  
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
            }
            remoteTranslogTransferTracker,  
        doAnswer(invocation -> {
        mdFilename1.set("metadata__1__12__" + timestamp1 + "__node1__1");
        delayForBlobDownload = 1;
                }, null);
            remoteTranslogTransferTracker,
                for (TransferFileSnapshot transferFileSnapshot : transferFileSnapshots) {  
    /**  
        unfenced.transferFenceOwnership(primaryTerm, "target-alloc"); // no fence to hand over: a no-op  
            };  
    // tests for cases when ckp is stored as translog metadata.
    FileTransferTracker tracker;
        doAnswer(invocationOnMock -> {  
                "translog-34.tlog",
        assertThrows(IOException.class, () -> translogTransferManager.readMetadata(3000L));  
        doAnswer(invocation -> {
        assertTrue(Files.exists(location.resolve("translog-23.tlog")));
import static org.mockito.Mockito.anyMap;  
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
    public void testPopulateFileTrackerWithLocalStateNoReaders() {
        translogTransferManager.populateFileTrackerWithLocalState(List.of());
        List<String> metadataFiles = Arrays.asList(mdFilenameGen1, mdFilenameGen2, mdFilenamePrimary2);  
        // Remote does not know the checksum (metadata uploaded by an older node).  
        assertThrows(IllegalStateException.class, () -> tracker.add(checkpointFile, false));
import java.util.List;
        Set<String> afterDownload = tracker.allUploaded();
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();
        RemoteStoreSettings remoteStoreSettings = mock(RemoteStoreSettings.class);  
import org.mockito.stubbing.Answer;
            Path translogPath = location.resolve("translog-23.tlog");  
            List<BlobMetadata> bmList = new LinkedList<>();
        mockSuccessfulFileUploads();
            bmList.add(new PlainBlobMetadata(mdFilename, 1));
    }
                uploadComplete.incrementAndGet();  
            @Override
        verify(transferService, times(0)).downloadBlob(any(BlobPath.class), any(String.class));
            );
     */  
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());
import java.util.Collections;
import org.opensearch.common.blobstore.support.PlainBlobMetadata;  
        {  
                assertNotNull(transferFileSnapshot.getMetadataFileInputStream());
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
            remoteBaseTransferPath.add(TRANSLOG.getName()),
                super.onFailure(fileSnapshot, e);
            List<BlobMetadata> bmList = new LinkedList<>();  
    }  
    }
            ActionListener<TransferFileSnapshot> listener = (ActionListener<TransferFileSnapshot>) invocationOnMock.getArguments()[2];
        String translogFile = "translog-23.tlog", checkpointFile = "translog-23.ckp";  
            tracker,
            Path checkpointPath = location.resolve("translog-23.ckp");
            remoteTranslogTransferTracker,
        AtomicInteger fileTransferSucceeded = new AtomicInteger();
        // Expect delay for both tlog and ckp file  
                eq(TranslogTransferMetadata.METADATA_PREFIX),
            assertFalse(Files.exists(checkpointPath));
            long checksum = createTranslogGeneration(location, 1, true);
        // Checkpoint file missing.  
        }, null));
        assertTrue(manager.transferSnapshot(createTransferSnapshot(), listener, null));  
        });
        }).when(transferService)
            "a transient fence error must not be classified as fenced: " + uploadFailure.get(),
            );  
            public void onFailure(TransferFileSnapshot fileSnapshot, Exception e) {  
                remoteTranslogTransferTracker,  
                "translog-45.tlog",
        String mdFilename2 = tm2.getFileName();
        AtomicBoolean fetchCompleted = new AtomicBoolean(false);  
        String mdFilenameGen2 = new TranslogTransferMetadata(1, 2, 1, 2).getFileName();
            latchedActionListener.onResponse(bmList);
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {  
        verify(transferService, times(1)).downloadBlobWithMetadata(any(BlobPath.class), eq("translog-23.tlog"));
    public void setUp() throws Exception {
        long count = mdFilename.chars().filter(ch -> ch == METADATA_SEPARATOR.charAt(0)).count();  
        mdFilename1.set("metadata__1__12__" + timestamp1 + "__node1__1");  
 * this file be licensed under the Apache-2.0 license or a
    public void testFenceOwnershipWrappers() throws Exception {
        AtomicInteger translogTransferSucceeded = new AtomicInteger();  
        Thread.sleep(1);  
                primaryTerm,
            remoteTranslogTransferTracker,
     * a stale checkpoint with the same offset would locate the new footer and trust the pair. The download therefore
        when(reader1.getGeneration()).thenReturn(12L);  
            fileTransferTracker,
        } catch (Exception e) {  
        assertEquals(4, fileTransferSucceeded.get());
            return null;  
        );
        assertNull(uploadFailure.get());
            bmList.add(new PlainBlobMetadata(tm3, 1));
import org.opensearch.core.action.ActionListener;  
    }  
    @Override
                eq(TranslogTransferMetadata.METADATA_PREFIX),  
        assertEquals(2, tracker.allUploaded().size());  
        assertEquals(Arrays.asList(mdFilenamePrimary2, mdFilenameGen2, mdFilenameGen1), metadataFiles);
            DefaultRemoteStoreSettings.INSTANCE,  
    public void testDownloadTranslogWithMetadata() throws IOException {  
        Path downloaded = createTempDir();  
        mockSuccessfulFileUploads();  
    private void assertTlogCkpDownloadStatsWithMetadata() {
    public void testDownloadTranslogIfChangedDownloadsWhenLocalGenerationIsNotCurrent() throws IOException {
            assertTrue(manager.isLocalGenerationCurrent(location, 23, String.valueOf(staleChecksum)));
            @Override
import java.util.Arrays;  
            shardId,
    public void testDownloadTranslogAlreadyExists() throws IOException {
        }).when(transferService)
        assertEquals(0, remoteTranslogTransferTracker.getDownloadBytesSucceeded());
            fileTransferTracker,  
    private void assertTlogCkpDownloadStats() {  
                checkpointPresentAtFetch.set(Files.exists(checkpointPath));
                anyInt(),
            isTranslogMetadataEnabled  
            latchedActionListener.onResponse(bmList);
            shardId,
            blobStoreTransferService,
            Path location = createTempDir();
        TranslogTransferManager unfenced = fencedTransferManager(null, tracker);
        Path repoPath = createTempDir();
        assertThrows(IllegalStateException.class, () -> tracker.add(translogFile, false));  
                null
        doAnswer(invocation -> {
            assertFalse(Files.exists(translogPath));
        doNothing().when(transferService)
import org.opensearch.index.translog.transfer.FileSnapshot.TranslogFileSnapshot;
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());
        assertEquals(tlogBytes.length + ckpBytes.length, remoteTranslogTransferTracker.getDownloadBytesSucceeded());
    }  
        Path repoPath = createTempDir();
        );
        assertArrayEquals(before, Files.readAllBytes(location.resolve("translog-23.tlog")));
        assertNotNull(uploadFailure.get());
        }
        long checksum = createTranslogGeneration(location, 23, true);  
        assertTrue(fenced.isFenceSuperseded(primaryTerm));
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
    }
            return null;
                generation,
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));  
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));  
                fetchCompleted.set(true);
        BlobContainer blobContainer = mock(BlobContainer.class);
            translogTransferManager.getFileTransferTracker().allUploaded()
            @Override
        assertTlogCkpDownloadStats();
                Mockito.eq(remoteBaseTransferPath.add(String.valueOf(primaryTerm))),
                        exception.set(ex);  
        AtomicInteger fileTransferFailed = new AtomicInteger();
            remoteBaseTransferPath.add(METADATA.getName()),  
            remoteBaseTransferPath.add(METADATA.getName()),
        Path location = createTempDir();
        // generation. Sequenced, the CAS comes after the metadata and finds the chain taken, so the operation is
            BlobMetadata bm2 = new PlainBlobMetadata("metadata__1__12__" + timestamp2 + "__node1__1", 1);
    }
    private TranslogTransferManager fencedTransferManager(RemoteStoreFence fence, FileTransferTracker fileTransferTracker) {
            return null;
                throw new RuntimeException(e);  
            assertEquals(0, remoteTranslogTransferTracker.getTotalDownloadTimeInMillis());
        });
        );  
                primaryTerm,
        {
            long checksum = createTranslogGeneration(location, 23, true);
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());  
        AtomicInteger fileTransferSucceeded = new AtomicInteger();  
                @Override
                translogTransferFailed.incrementAndGet();
    }  
            );
        }).when(transferService)
                    throw new IOException("simulated transient repository error");  
                Mockito.eq(remoteBaseTransferPath.add(String.valueOf(primaryTerm))),
        assertTrue(remoteTranslogTransferTracker.getTotalDownloadTimeInMillis() >= delayForBlobDownload);
    private TransferService transferService;
            Path location = createTempDir();  
        tracker.add(checkpointFile, true);
        assertTrue(Files.exists(location.resolve("translog-23.ckp")));
        assertTrue(uploadFailure.get().toString(), uploadFailure.get() instanceof TranslogFencedException);
            DefaultRemoteStoreSettings.INSTANCE,
        TranslogReader reader3 = mock(TranslogReader.class);
import static org.opensearch.index.translog.transfer.TranslogTransferManager.CHECKPOINT_FILE_DATA_KEY;
        AtomicInteger fileTransferFailed = new AtomicInteger();
            remoteBaseTransferPath.add(METADATA.getName()),  
            when(transferService.downloadBlobWithMetadata(any(BlobPath.class), eq("translog-23.tlog"))).thenAnswer(failFirstFetch);
            uploadThread.set(new Thread(() -> {  
import java.util.concurrent.atomic.AtomicBoolean;
                if (failNextCas.getAndSet(false)) {
            }
            @Override
        fence.validateAndAdvance(primaryTerm);  
        // ack, and the CAS follows the metadata"). A successful CAS then proves the metadata was already visible  
        assertEquals(3, fileTransferSucceeded.get());
        );
            @Override
            TransferFileSnapshot actualFileSnapshot = transferFileSnapshots.iterator().next();
        FileTransferTracker fileTransferTracker = new FileTransferTracker(
        // Since the tracker already holds the files with success state, adding them with success state is allowed  
                any()
        };
        assertTrue(unfenced.revertFenceOwnership(primaryTerm));
            remoteTranslogTransferTracker,
            shardId,  
            @Override
            }
            List<BlobMetadata> bmList = new LinkedList<>();  
        }, null));
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
            remoteBaseTransferPath.add(METADATA.getName()),  
            remoteBaseTransferPath.add(METADATA.getName()),  
            remoteTranslogTransferTracker,
import java.util.HashMap;  
            BlobMetadata bm1 = new PlainBlobMetadata(mdFilename1.get(), 1);
            }  
            expectThrows(IOException.class, () -> manager.downloadTranslog("12", "23", location));  
        long delayForMdDownload = 1;
            );  
        assertFalse(fenced.isFenceSuperseded(primaryTerm));
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {  
        };
            @Override
            remoteBaseTransferPath.add(TRANSLOG.getName()),  
        when(reader4.getGeneration()).thenReturn(45L);
        FsBlobContainer container = fenceContainer();  
            fence
                primaryTerm,  
    }
            true  
    }  
            long staleChecksum = createTranslogGeneration(location, 23, true);
        }).when(blobContainer)
                uploadFailure.set(ex);  
    }
                translogPresentAtFetch.set(Files.exists(translogPath));  
                transferService,
            }  
            }
        String mdFilename1 = metadata1.getFileName();  
            isTranslogMetadataEnabled
                fetchCompleted.set(true);  
            List<BlobMetadata> bmList = new LinkedList<>();
            Set<TransferFileSnapshot> transferFileSnapshots = (Set<TransferFileSnapshot>) invocationOnMock.getArguments()[0];
        );  
        assertEquals(2, tracker.allUploaded().size());  
            DefaultRemoteStoreSettings.INSTANCE,  
        // without this generation and the writer acknowledges an operation no recovery will ever resolve -  
        doAnswer(invocation -> {
        assertNoDownloadStats(false);  
        translogTransferManager.downloadTranslog("12", "23", location);
     * generation registers only the {@code .tlog} with the tracker. A reused generation must leave the tracker in  
        translogTransferManager = new TranslogTransferManager(
                remoteBaseTransferPath.add(TRANSLOG.getName()),  
        new RemoteStoreFence(container, "node-2-alloc", "node-2", shardId).validateAndAdvance(primaryTerm + 1);  
            long checksum = createTranslogGeneration(location, 1, true);  
        FsBlobContainer container = new FsBlobContainer(blobStore, BlobPath.cleanPath(), repoPath) {
        }, null));  
            Path location = createTempDir();
@LuceneTestCase.SuppressFileSystems("*")
    /**
        when(reader2.getGeneration()).thenReturn(23L);
        Tuple<Tuple<Long, Long>, String> actualOutput = TranslogTransferMetadata.getNodeIdByPrimaryTermAndGeneration(tm);  
            uploadedTranslog.set(((InputStream) invocation.getArgument(1)).readAllBytes());
        );
            }
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
     */
        FileTransferTracker fileTransferTracker = new FileTransferTracker(
        assertNoDownloadStats(false);
        assertFalse(Files.exists(location.resolve("translog-23.tlog")));
        verify(transferService).downloadBlob(any(BlobPath.class), eq("translog-23.tlog"));  
                minTranslogGeneration,
                null
        doAnswer(invocation -> { throw new IOException("test exception"); }).when(blobStore).blobContainer(any(BlobPath.class));
            String timestamp1 = RemoteStoreUtils.invertLong(2345L);
            }  
    /**
        String tm3 = new TranslogTransferMetadata(2, 3, 1, 2).getFileName();
        return (FsBlobContainer) blobStore.blobContainer(BlobPath.cleanPath());
        translogTransferManager.deleteStaleTranslogMetadataFilesAsync(() -> {
        FileTransferTracker fileTransferTracker = new FileTransferTracker(  
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
    /**  
            TranslogFileSnapshot translogFileSnapshot2 = new TranslogFileSnapshot(
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));  
            shardId,  
            public void onUploadComplete(TransferSnapshot transferSnapshot) {}  
        doAnswer(invocation -> {
                    return Set.of(translogFileSnapshot1, translogFileSnapshot2);
    long delayForBlobDownload;
                casSawMetadataUploaded.set(metadataUploaded.get());
        // The default (unfenced) manager must behave exactly as before, i.e. no fence blob and no CAS requirement  
        );
        when(remoteStoreSettings.getClusterRemoteTranslogTransferTimeout()).thenReturn(new TimeValue(1));
                listener.onResponse(transferFileSnapshot);
                    public void onUploadComplete(TransferSnapshot transferSnapshot) {}
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
     * the fence CAS must surface as an ordinary retryable upload failure — never as {@link TranslogFencedException},
    }  
        transferFileSnapshot.setMetadataFileInputStream(new ByteArrayInputStream(ckpBytes));  
        blobStoreTransferService.uploadBlob(
            remoteTranslogTransferTracker,
            shardId,  
        doAnswer(invocationOnMock -> {  
            remoteBaseTransferPath.add(TRANSLOG.getName()),
        }  
                eq(ThreadPool.Names.REMOTE_PURGE),  
        }).when(transferService)
            new RemoteStoreFence(container, "node-new-alloc", "node-new", shardId).validateAndAdvance(primaryTerm + 1);
        RemoteStoreFence fence = new RemoteStoreFence(container, "node-1-alloc", "node-1", shardId);
        assertEquals(1, translogTransferSucceeded.get());
                super.onFailure(fileSnapshot, e);
            tracker,
        AtomicInteger translogTransferFailed = new AtomicInteger();
                eq(ThreadPool.Names.REMOTE_PURGE),
        doAnswer(invocation -> {  
        TranslogTransferManager manager = fencedTransferManager(fence, tracker);
        Thread.sleep(1000);  
        assertEquals(metadata, translogTransferManager.readMetadata(3000L));
            remoteBaseTransferPath.add(TRANSLOG.getName()),  
        assertNotNull(uploadFailure.get());
            return null;
        // A strictly higher term supersedes this copy.
        assertBusy(() -> assertEquals(0, tracker.allUploaded().size()));
        assertNoDownloadStats(true);
import org.opensearch.common.collect.Tuple;
            public void onUploadComplete(TransferSnapshot transferSnapshot) {  
        translogTransferManager.downloadTranslog("12", "23", location);
        // and fail the engine open - the directory is no longer wiped before reconciliation, so a stale local
    }
            Files.delete(location.resolve(Translog.getCommitCheckpointFileName(1)));
            public String writeBlobConditionally(String blobName, InputStream inputStream, long blobSize, String expectedVersionToken)  
    public void testDownloadTranslog() throws IOException {
        assertEquals(2, uploadComplete.get());  
                any(TransferFileSnapshot.class),
        verify(blobContainer, times(0)).readBlob("translog-23.ckp");  
        AtomicInteger uploadComplete = new AtomicInteger();
        verify(transferService).downloadBlob(any(BlobPath.class), eq("translog-23.tlog"));
        TranslogTransferListener listener = new TranslogTransferListener() {  
        assertEquals(
     * tracker until that download has succeeded.  
        TranslogTransferMetadata tm = new TranslogTransferMetadata(1, 1, 1, 2, "node--1");
        assertTrue(manager.transferSnapshot(createTransferSnapshot(), listener, null));
            transferService,
public class TranslogTransferManagerTests extends OpenSearchTestCase {
        translogTransferManager.populateFileTrackerWithLocalState(null);
import org.opensearch.index.translog.TestTranslog;
        // Checkpoint file belongs to another generation.
     * removes both local files before the remote is contacted, in either mode, so no partial outcome can be trusted.
        );
        assertFalse(translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
        assertEquals(primaryTerm, fence.getTerm());
        assertTrue(translogTransferManager.downloadTranslogIfChanged("12", "23", location, String.valueOf(checksum + 1)));  
            TranslogFileSnapshot translogFileSnapshot1 = new TranslogFileSnapshot(
        assertTrue(remoteTranslogTransferTracker.getTotalDownloadTimeInMillis() >= delayForMdDownload);
            return null;  
            assertNotNull(exception.get());
                anyInt(),  
            Thread t = new Thread(runnable);
        doAnswer(invocationOnMock -> {  
            verify(transferService).deleteBlobsAsync(
        assertNotNull(exception.get());  
        TranslogTransferManager reuseManager = new TranslogTransferManager(  
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum + 1)));  
            @Override  
        assertEquals(1L, (long) (actualOutput.v1().v1()));
        verify(transferService).downloadBlob(any(BlobPath.class), eq("translog-23.ckp"));  
        }
 * The OpenSearch Contributors require contributions made to  
            }
    public void testTransferSnapshotOnUploadTimeout() throws Exception {
        ) {
        BlobStoreTransferService blobStoreTransferService = new BlobStoreTransferService(blobStore, threadPool);
        translogTransferManager.downloadTranslog("12", "23", location);
            remoteBaseTransferPath.add(TRANSLOG.getName()),
            @Override
import java.util.ArrayList;
    }  
import java.util.stream.Collectors;
    }  
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_SEPARATOR;  
                createTempFile(Translog.TRANSLOG_FILE_PREFIX + (generation - 1), Translog.TRANSLOG_FILE_SUFFIX),
                location.resolve(Translog.getCommitCheckpointFileName(1))  
                "translog-23.tlog",  
    public void testTransientFenceErrorIsRetryableNotFatal() throws Exception {
        }).when(transferService).uploadBlob(any(TransferFileSnapshot.class), any(BlobPath.class), any(WritePriority.class), any());  
                uploadFailure.set(ex);  
        TranslogTransferManager manager = fencedTransferManager(fence, tracker);  
            createTranslogGeneration(location, 1, true);  
    public void testDownloadTranslogIfChangedInMetadataModeTracksSameFilesAsDownload() throws IOException {  
        Path location = createTempDir();  
                any()
        // Checksum mismatch (e.g. a stale generation left behind by an earlier incarnation of the shard).
    public void testFenceValidationRunsAfterMetadataUpload() throws Exception {
        assertTlogCkpDownloadStats();  
    }  
        assertNull(translogTransferManager.readMetadata(1234L));
        assertEquals(Set.of("translog-23.tlog"), afterDownload);
            return new ByteArrayInputStream(translogTransferManager.getMetadataBytes(metadata));
            return new ByteArrayInputStream(tlogBytes);
    // This should happen most of the time -  
        assertEquals(1, translogTransferFailed.get());
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(  
            public String writeBlobConditionally(String blobName, InputStream inputStream, long blobSize, String expectedVersionToken)  
        assertTrue(translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
            invocation -> new InputStreamWithMetadata(new ByteArrayInputStream(uploadedTranslog.get()), uploadedMetadata.get())
        // Relocation target (or a new primary) takes over the fence out of band
                }
    public void testDeleteTranslogSuccess() throws Exception {  
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
        isTranslogMetadataEnabled = true;
import org.opensearch.index.remote.RemoteStoreUtils;  
            remoteTranslogTransferTracker  
        assertFalse(reuseManager.downloadTranslogIfChanged("12", "23", reused, String.valueOf(checksum)));  
                minTranslogGeneration,  
     */  
            );
        // There should not be any `_` in mdFile name as it is used a separator .
            transferFileSnapshots.forEach(transferFileSnapshot -> {  
        assertEquals(2, tracker.allUploaded().size());  
                translogTransferSucceeded.incrementAndGet();  
        assertTrue(uploadFailure.get().getMessage(), uploadFailure.get().getMessage().contains("fenced"));  
            bmList.add(new PlainBlobMetadata(mdFilename, 1));
        Collections.sort(metadataFiles);
        mockSuccessfulFileUploads();
        // Reference: what a real metadata-mode download registers.
            }
            return new InputStreamWithMetadata(new ByteArrayInputStream(tlogBytes), metadata);  
            transferService,  
        assertArrayEquals(tlogBytes, Files.readAllBytes(location.resolve("translog-23.tlog")));  
            DefaultRemoteStoreSettings.INSTANCE,
        );  
                throw new AssertionError("upload must not be acknowledged for a fenced primary");
        TranslogTransferMetadata metadata = createTransferSnapshot().getTranslogTransferMetadata();
