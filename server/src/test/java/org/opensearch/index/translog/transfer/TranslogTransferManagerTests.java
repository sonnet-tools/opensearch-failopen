            remoteBaseTransferPath.add(TRANSLOG.getName()),
    public void testMetadataFileNameOrder() throws IOException {
            }
                    translogFileSnapshot2.setMetadataFileInputStream(checkpointFileSnapshot2.inputStream());
            when(transferService.downloadBlob(any(BlobPath.class), eq("translog-23.ckp"))).thenAnswer(failFirstFetch);
        FileTransferTracker fileTransferTracker = new FileTransferTracker(
                any(TransferFileSnapshot.class),
        TranslogTransferMetadata metadata = createTransferSnapshot().getTranslogTransferMetadata();
                    @Override
        assertTrue(remoteTranslogTransferTracker.getTotalDownloadTimeInMillis() >= delayForMdDownload);
        assertTrue(tracker.uploaded("translog-23.ckp"));
        );
                "translog-23.ckp",
import org.opensearch.common.collect.Tuple;
    }
                createTempFile(Translog.TRANSLOG_FILE_PREFIX + (generation - 1), Translog.TRANSLOG_FILE_SUFFIX),
            verify(transferService).deleteBlobsAsync(
        String tm1 = new TranslogTransferMetadata(1, 1, 1, 2).getFileName();
        FileTransferTracker fileTransferTracker = new FileTransferTracker(
        unfenced.transferFenceOwnership(primaryTerm, "target-alloc"); // no fence to hand over: a no-op
        return new TranslogTransferManager(
        assertTrue(exception.get() instanceof TranslogUploadFailedException);
        assertEquals(2L, (long) (actualOutput.v1().v2()));
            remoteTranslogTransferTracker
            String timestamp2 = RemoteStoreUtils.invertLong(3456L);
            shardId,
        assertTrue(translogTransferManager.downloadTranslogIfChanged("12", "23", location, String.valueOf(checksum + 1)));
            List<BlobMetadata> bmList = new LinkedList<>();
            shardId,
        assertTrue(Files.exists(location.resolve(translogFile)));
                remoteBaseTransferPath.add(METADATA.getName()),
            expectThrows(IOException.class, () -> manager.downloadTranslog("12", "23", location));
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum)));
            remoteTranslogTransferTracker
    }
    }
        });
    public void testTransferSnapshotFencedByHigherTermBeforeBootstrap() throws Exception {
     * Every way in which the local copy can fail to prove it is identical to the remote one must fall back to a
        verify(transferService, times(0)).downloadBlob(any(BlobPath.class), eq("translog-23.tlog"));
        // and fail the engine open - the directory is no longer wiped before reconciliation, so a stale local
            isTranslogMetadataEnabled
import org.opensearch.indices.DefaultRemoteStoreSettings;
            List<BlobMetadata> bmList = new LinkedList<>();
        AtomicBoolean failNextCas = new AtomicBoolean(true);
            @Override
            }
        String tm2 = new TranslogTransferMetadata(1, 2, 1, 2).getFileName();
                ActionListener<TransferFileSnapshot> listener = invocationOnMock.getArgument(2);
        assertEquals(0, exception.get().getSuppressed().length);
                eq(TranslogTransferMetadata.METADATA_PREFIX),
    public void testReadMetadataNoFile() throws IOException {
import java.util.concurrent.atomic.AtomicBoolean;
                }
        );
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        assertNoDownloadStats(false);
        );
        }, null));
    private void mockSuccessfulFileUploads() throws Exception {
            );
        translogTransferManager.downloadTranslog("12", "23", location);
            bmList.add(new PlainBlobMetadata(tm2, 1));
        assertNotNull(uploadFailure.get());
                fileTransferFailed.incrementAndGet();
        String tm3 = new TranslogTransferMetadata(2, 3, 1, 2).getFileName();
                for (TransferFileSnapshot transferFileSnapshot : transferFileSnapshots) {
        mockSuccessfulFileUploads();
            @Override
        // A higher-term primary already owns the fence
            String timestamp2 = RemoteStoreUtils.invertLong(3456L);
        FsBlobStore blobStore = new FsBlobStore(randomIntBetween(1, 8) * 1024, repoPath, false);
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
        );
        // TranslogCorruptedException here, which must be treated as "cannot trust, download" rather than propagate
            bmList.add(new PlainBlobMetadata(mdFilename, 1));
        String timestamp1 = RemoteStoreUtils.invertLong(2345L);
        assertTrue(translogTransferManager.getFileTransferTracker().allUploaded().isEmpty());
                any(ActionListener.class)
        long checksum = createTranslogGeneration(location, 23, true);
        );
        }, null));
                checkpointPresentAtFetch.set(Files.exists(checkpointPath));
                null
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.METADATA;
        assertEquals(14, count);
    }
        Files.createFile(location.resolve("translog-23.ckp"));
                    Thread.sleep(1000);
 */
import static org.mockito.Mockito.when;
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        FsBlobContainer container = new FsBlobContainer(blobStore, BlobPath.cleanPath(), repoPath) {
            assertNotNull(exception.get());
        TranslogTransferManager manager = fencedTransferManager(stalePrimaryFence, tracker);
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();
    // This should happen most of the time -
                generation,
                @Override
            };
                }
            transferService,
        when(reader1.getGeneration()).thenReturn(12L);
        TranslogTransferMetadata tm = new TranslogTransferMetadata(1, 1, 1, 2, "node--1");
    }
            remoteBaseTransferPath.add(TRANSLOG.getName()),
                any()
            );
        assertTrue(manager.transferSnapshot(createTransferSnapshot(), listener, null));
        assertTlogCkpDownloadStats();
            DefaultRemoteStoreSettings.INSTANCE,
            @Override
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());
    public void testReadMetadataFile() throws IOException {
            assertTrue(exception.get() instanceof TranslogUploadFailedException);
        }).when(transferService)
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
import java.util.Collections;
            assertFalse(Files.exists(checkpointPath));
import static org.mockito.Mockito.any;
            transferFileSnapshots.stream().skip(1).forEach(listener::onResponse);
            remoteBaseTransferPath.add(TRANSLOG.getName()).add("12"),
        {
        AtomicInteger translogTransferFailed = new AtomicInteger();
        mockSuccessfulFileUploads();
        return TestTranslog.createTranslogGeneration(random(), location, generation, withFooter);
        AtomicInteger fileTransferFailed = new AtomicInteger();
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
        assertEquals(0, fileTransferFailed.get());
            remoteBaseTransferPath.add(METADATA.getName()),
            public void onUploadComplete(TransferSnapshot transferSnapshot) {}
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();
            remoteTranslogTransferTracker,
                    listener.onFailure(new FileTransferException(list.get(0), ignore));
        assertEquals(Set.of("translog-23.tlog"), afterDownload);
        {
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
                }, null);
public class TranslogTransferManagerTests extends OpenSearchTestCase {
        verify(transferService).downloadBlob(any(BlobPath.class), eq("translog-23.tlog"));
        }, null));
            }
            DefaultRemoteStoreSettings.INSTANCE,
                assertEquals(3, blobMetadata.size());
     * repository, and the tracker records both files exactly as a real download would.
     */
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 23, String.valueOf(checksum)));
        when(blobStore.isBlobMetadataEnabled()).thenReturn(true);
        when(transferService.downloadBlobWithMetadata(any(BlobPath.class), eq("translog-23.tlog"))).thenAnswer(invocation -> {
        TranslogTransferManager manager = new TranslogTransferManager(
        assertEquals(0, fence.getSeq());
    }
        assertArrayEquals(tlogBytes, Files.readAllBytes(location.resolve("translog-23.tlog")));
        assertTrue(Files.exists(location.resolve("translog-23.ckp")));
            @Override
            return null;
            tracker,
 *
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());
@LuceneTestCase.SuppressFileSystems("*")
            tracker,
            FileTransferException testException = new FileTransferException(
                @Override
        );
    }
        doAnswer(invocation -> {
        assertEquals(0, remoteTranslogTransferTracker.getDownloadBytesSucceeded());
        });
        Path location = createTempDir();
    @SuppressWarnings("unchecked")
        }
        ) {
            assertEquals(0, remoteTranslogTransferTracker.getTotalDownloadTimeInMillis());
        assertArrayEquals(before, Files.readAllBytes(location.resolve("translog-23.tlog")));
        // Interrupt the thread
        isTranslogMetadataEnabled = true;
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
            Thread.sleep(delayForBlobDownload);
        }).when(transferService)
        when(remoteStoreSettings.getClusterRemoteTranslogTransferTimeout()).thenReturn(new TimeValue(1));
            Path location = createTempDir();
            }
import org.mockito.stubbing.Answer;
            .uploadBlob(
        AtomicReference<Map<String, String>> uploadedMetadata = new AtomicReference<>();
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();
        TranslogTransferManager manager = fencedTransferManager(fence, tracker);
        assertEquals(translogTransferManager.getMetadataBytes(metadata).length, remoteTranslogTransferTracker.getDownloadBytesSucceeded());
        assertEquals(primaryTerm, fence.getTerm());
        isTranslogMetadataEnabled = false;
     * which callers treat as tragic — and the next sync must recover and claim the chain.
            Path location = createTempDir();
            shardId,
            }
import org.opensearch.common.blobstore.BlobPath;
        assertEquals("Failed to upload 1 files during transfer", exception.get().getMessage());
                public TranslogTransferMetadata getTranslogTransferMetadata() {
        assertTrue(translogTransferManager.getFileTransferTracker().allUploaded().isEmpty());
                super.onFailure(fileSnapshot, e);
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        // A strictly higher term supersedes this copy.
                return super.writeBlobConditionally(blobName, inputStream, blobSize, expectedVersionToken);
        tracker.add(translogFile, true);
    private void assertNoDownloadStats(boolean nonZeroUploadTime) {
        assertEquals(1L, (long) (actualOutput.v1().v1()));
                metadataMode
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
        mockSuccessfulFileUploads();
        assertEquals(0, remoteTranslogTransferTracker.getTotalDownloadsSucceeded());
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
            @Override
        RemoteStoreFence fence = new RemoteStoreFence(fenceContainer(), "node-1-alloc", "node-1", shardId);
            // The remote fails on the very first request; record what was still on disk at that moment.
        verify(transferService).downloadBlob(any(BlobPath.class), eq("translog-23.ckp"));
            bytes[bytes.length / 2] ^= 0x1;
        assertNoDownloadStats(true);
    }
    public void testDownloadTranslogWithMetadata() throws IOException {
            shardId,
        TranslogTransferMetadata tm2 = new TranslogTransferMetadata(1, 1, 1, 2, "node--2");
                translogTransferFailed.incrementAndGet();
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
        );
        BlobStore blobStore = mock(BlobStore.class);
            Path location = createTempDir();
        when(reader1.getGeneration()).thenReturn(12L);
                any(ActionListener.class)
    /**
            try {
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
            DefaultRemoteStoreSettings.INSTANCE,
    public void testReadMetadataListException() throws IOException {
            latchedActionListener.onResponse(bmList);
        }
        assertNull(translogTransferManager.readMetadata(1234L));
                "translog-12.tlog",
            return null;
            return null;
        // ack, and the CAS follows the metadata"). A successful CAS then proves the metadata was already visible
        };
        assertEquals(1, translogTransferFailed.get());
        assertFalse(manager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
        // The default (unfenced) manager must behave exactly as before, i.e. no fence blob and no CAS requirement
        delayForBlobDownload = 1;
            public void onFailure(TransferFileSnapshot fileSnapshot, Exception e) {
            @Override
                translogTransferFailed.incrementAndGet();
            }
        assertEquals(afterDownload, reuseTracker.allUploaded());
        FsBlobStore blobStore = new FsBlobStore(randomIntBetween(1, 8) * 1024, repoPath, false);
                throw new RuntimeException(e);
            Files.delete(location.resolve(Translog.getCommitCheckpointFileName(1)));
        assertEquals(3, fileTransferSucceeded.get());
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
        TranslogTransferManager manager = fencedTransferManager(fence, tracker);
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum)));
    }
    /**
            remoteBaseTransferPath.add(TRANSLOG.getName()),
            }
            public void onFailure(TransferFileSnapshot fileSnapshot, Exception e) {
            isTranslogMetadataEnabled
        long checksum = createTranslogGeneration(reused, 23, true);
        } catch (Exception e) {
            Set<TransferFileSnapshot> transferFileSnapshots = (Set<TransferFileSnapshot>) invocationOnMock.getArguments()[0];
        });
            actionListener.onResponse(bmList);
        };
import org.opensearch.index.translog.transfer.listener.TranslogTransferListener;
        TranslogReader reader2 = mock(TranslogReader.class);
        assertEquals(0, translogTransferFailed.get());
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(eq(files));
    public void testGetPrimaryTermAndGeneration() {
    public void testTransferSnapshotOnThreadInterrupt() throws Exception {
        assertEquals(2, tracker.allUploaded().size());
                try {
        };
        BlobStore blobStore = mock(BlobStore.class);
    /**
            DefaultRemoteStoreSettings.INSTANCE,
            new ShardId("index", "indexUUid", 0),
            transferService,
    }
        when(reader2.getGeneration()).thenReturn(23L);
        assertEquals(0, translogTransferSucceeded.get());
    /**
        doAnswer(invocationOnMock -> {
            ActionListener<TransferFileSnapshot> listener = (ActionListener<TransferFileSnapshot>) invocationOnMock.getArguments()[2];
import org.opensearch.index.remote.RemoteStoreUtils;
    public void testPopulateFileTrackerWithLocalStateUsingTranslogMetadata() {
            BlobMetadata bm1 = new PlainBlobMetadata(mdFilename1.get(), 1);
        // Checkpoint file missing.
        BlobContainer blobContainer = mock(BlobContainer.class);
        assertEquals(metadata, translogTransferManager.readMetadata(3000L));
        ckpBytes = "Hello Checkpoint".getBytes(StandardCharsets.UTF_8);
    private TransferSnapshot createTransferSnapshot() throws IOException {
        TranslogReader reader1 = mock(TranslogReader.class);
                    }
        assertNotNull(uploadFailure.get());
            remoteBaseTransferPath.add(METADATA.getName()),
                primaryTerm,
        assertTrue(Files.exists(downloaded.resolve("translog-23.ckp")));
                fileTransferFailed.incrementAndGet();
        FsBlobContainer container = new FsBlobContainer(blobStore, BlobPath.cleanPath(), repoPath) {
            }
        assertFalse(Files.exists(location.resolve("translog-23.tlog")));
        long delayForMdDownload = 1;
        assertFalse(
        metadata.put(CHECKPOINT_FILE_DATA_KEY, ckpDataString);
        // Translog file truncated after the checkpoint was written.
        assertTrue(uploadFailure.get().toString(), uploadFailure.get() instanceof TranslogUploadFailedException);
        TranslogTransferMetadata metadata2 = new TranslogTransferMetadata(1, 0, 1, 2);
            latchedActionListener.onResponse(bmList);
            remoteBaseTransferPath.add(TRANSLOG.getName()),
            latchedActionListener.onResponse(bmList);
        assertEquals(0, translogTransferFailed.get());
            .listAllInSortedOrderAsync(
        assertEquals(tlogBytes.length + ckpBytes.length, remoteTranslogTransferTracker.getDownloadBytesSucceeded());
            return null;
        // Checkpoint file corrupt (CRC no longer matches). Checkpoint.read throws the unchecked
            Thread.sleep(delayForMdDownload);
        TranslogTransferManager metadataModeManager = new TranslogTransferManager(
    }
import org.opensearch.common.blobstore.BlobStore;
        translogTransferManager.deleteGenerationAsync(primaryTerm, Set.of(19L), () -> {});
        generation = randomNonNegativeLong();
    private long generation;
        String mdFilename2 = metadata2.getFileName();
            long checksum = createTranslogGeneration(location, 23, true);
            ActionListener<List<BlobMetadata>> actionListener = invocation.getArgument(4);
        doAnswer(invocation -> {
                try {
            transferService,
            blobStoreTransferService,
    public void testDownloadTranslogAlreadyExists() throws IOException {
            isTranslogMetadataEnabled,
    public void testFenceValidationRunsAfterMetadataUpload() throws Exception {
import org.opensearch.common.unit.TimeValue;
            return new ByteArrayInputStream(translogTransferManager.getMetadataBytes(metadata));
import java.util.Map;
    }
    }
        translogTransferManager = new TranslogTransferManager(
        doAnswer(invocation -> {
        verify(blobContainer, times(0)).readBlob("translog-23.ckp");
        TranslogTransferMetadata metadata1 = new TranslogTransferMetadata(1, 1, 1, 2);
        Set<String> afterDownload = tracker.allUploaded();
                generation,
    }
            remoteTranslogTransferTracker,
        assertTrue(translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
import org.opensearch.core.index.Index;
    public void testTransferSnapshotOnFileTransferUploadFail() throws Exception {
    }
            }
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
     * defaults - never superseded, a handoff transfer is a no-op, an aborted handoff may resume - so gating code
        FileTransferTracker fileTransferTracker = new FileTransferTracker(
            remoteBaseTransferPath.add(TRANSLOG.getName()),
                }
                Mockito.eq(remoteBaseTransferPath.add(String.valueOf(primaryTerm))),
                actualFileSnapshot,
        // Since the tracker already holds the files with success state, adding them with success state is allowed
        BlobStore blobStore = mock(BlobStore.class);
            ActionListener<TransferFileSnapshot> listener = (ActionListener<TransferFileSnapshot>) invocationOnMock.getArguments()[2];
    private long primaryTerm;
            }
            public String writeBlobConditionally(String blobName, InputStream inputStream, long blobSize, String expectedVersionToken)
import org.opensearch.common.blobstore.fs.FsBlobContainer;
            assertFalse("checkpoint must be gone before the remote is contacted", checkpointPresentAtFetch.get());
            public void onUploadComplete(TransferSnapshot transferSnapshot) {}
     * stale checkpoint beside a fresh translog: the next reconciliation reads the footer at the checkpoint's offset, and
        doAnswer(invocation -> {
    private void assertTlogCkpDownloadStats() {
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
        fence.validateAndAdvance(primaryTerm);
            fileTransferTracker,
        mockDownloadBlobWithMetadataResponse();
        assertNotNull(exception.get());
    }
                "translog-34.tlog",
            @Override
        assertTrue(unfenced.revertFenceOwnership(primaryTerm));
        // There should not be any `_` in mdFile name as it is used a separator .
            assertTrue(translogTransferManager.downloadTranslogIfChanged("12", "23", location, String.valueOf(checksum)));
        TranslogReader reader2 = mock(TranslogReader.class);
    private RemoteTranslogTransferTracker remoteTranslogTransferTracker;
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
                translogTransferFailed.incrementAndGet();
            @Override
        assertNoDownloadStats(false);
        );
        when(transferService.downloadBlob(any(BlobPath.class), eq(mdFilename))).thenThrow(new IOException("Something went wrong"));
        FileTransferTracker fileTransferTracker = new FileTransferTracker(
 * The OpenSearch Contributors require contributions made to
        new RemoteStoreFence(container, "node-target-alloc", "node-target", shardId).validateAndAdvance(primaryTerm);
        assertTrue(uploadFailure.get().getMessage(), uploadFailure.get().getMessage().contains("fenced"));
        assertTrue(manager.transferSnapshot(createTransferSnapshot(), listener, null));
        };
    private TranslogTransferManager fencedTransferManager(RemoteStoreFence fence, FileTransferTracker fileTransferTracker) {
        transferFileSnapshot.setMetadataFileInputStream(new ByteArrayInputStream(ckpBytes));
        when(transferService.downloadBlob(any(BlobPath.class), eq(mdFilename1.get()))).thenAnswer(invocation -> {
            WritePriority.HIGH,
        });
        FsBlobContainer container = fenceContainer();
    public void testReadMetadataForGivenTimestampNoFile() throws IOException {
 * compatible open source license.
        assertEquals(4, fileTransferTracker.allUploaded().size());
        return (FsBlobContainer) blobStore.blobContainer(BlobPath.cleanPath());
            @Override
            List<BlobMetadata> bmList = new LinkedList<>();
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
                    @Override
            );
        TranslogTransferManager manager = fencedTransferManager(fence, tracker);
            remoteBaseTransferPath.add(METADATA.getName()),
        TranslogTransferManager reuseManager = new TranslogTransferManager(
        verify(transferService, times(1)).downloadBlobWithMetadata(any(BlobPath.class), eq("translog-23.tlog"));
        assertBusy(() -> {
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
        verify(transferService, times(0)).downloadBlob(any(BlobPath.class), any(String.class));
            @Override
        );
            return null;
        });
            bmList.add(new PlainBlobMetadata(tm2, 1));
import java.nio.file.Files;
            shardId,
        translogTransferManager.downloadTranslog("12", "23", location);
            @Override
        assertEquals(String.valueOf(Objects.hash(nodeId)), actualOutput.v2());
            DefaultRemoteStoreSettings.INSTANCE,
            remoteTranslogTransferTracker,
                "translog-45.tlog",
            public void onResponse(List<BlobMetadata> blobMetadata) {
        }
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
                eq(Integer.MAX_VALUE),
            new ShardId("index", "indexUUid", 0),
                anyInt(),
        assertEquals(4, fileTransferSucceeded.get());
            return null;
                remoteTranslogTransferTracker,
        AtomicInteger fileTransferFailed = new AtomicInteger();
                uploadFailure.set(ex);
    /**
            Set<TransferFileSnapshot> transferFileSnapshots = (Set<TransferFileSnapshot>) invocationOnMock.getArguments()[0];
    private long createTranslogGeneration(Path location, long generation, boolean withFooter) throws IOException {
        AtomicInteger translogTransferFailed = new AtomicInteger();
        // Fencing enabled: delegation to the fence.
            return null;
            return null;
        when(transferService.downloadBlob(any(BlobPath.class), eq("translog-23.tlog"))).thenAnswer(invocation -> {
            );
        // generation. Sequenced, the CAS comes after the metadata and finds the chain taken, so the operation is
package org.opensearch.index.translog.transfer;
            String timestamp2 = RemoteStoreUtils.invertLong(3456L);
        // Order witness: the CAS must be issued only after the metadata upload completed ("the chain gates the
            List<BlobMetadata> bmList = new LinkedList<>();
            // Whatever the next attempt finds, it cannot be trusted.
        // asserting that new primary followed new generation are lexicographically smallest
    public void testDownloadTranslogIfChangedDownloadsWhenLocalGenerationIsNotCurrent() throws IOException {
        AtomicInteger fileTransferSucceeded = new AtomicInteger();
        {
                eq(TranslogTransferMetadata.METADATA_PREFIX),
            );
        }, null));
            return null;
        assertNoDownloadStats(false);
        assertNotNull(uploadFailure.get());
    }
        }
        }).when(transferService)
                } catch (InterruptedException e) {
        Path location = createTempDir();
                    return "test-to-string";
                primaryTerm,
            Set.of(
            translogTransferManager.getFileTransferTracker().allUploaded()
        super.tearDown();
    }
        String mdFilenameGen1 = new TranslogTransferMetadata(1, 1, 1, 2).getFileName();
            remoteBaseTransferPath.add(TRANSLOG.getName()),
        // Expect delay for both tlog and ckp file
            tracker,
            transferService,
                translogPresentAtFetch.set(Files.exists(translogPath));
        // A subsequent sync advances the same CAS chain
        Path location = createTempDir();
            bmList.add(new PlainBlobMetadata(tm3, 1));
import static org.mockito.Mockito.doNothing;
                super.onFailure(fileSnapshot, e);
        assertTrue(Files.exists(location.resolve("translog-23.tlog")));
        threadPool = new TestThreadPool(getClass().getName());
            List<BlobMetadata> bmList = List.of(bm1, bm2);
        translogTransferManager.populateFileTrackerWithLocalState(List.of(reader1, reader2, reader3, reader4));
            isTranslogMetadataEnabled
            return new ByteArrayInputStream(ckpBytes);
import org.apache.lucene.tests.util.LuceneTestCase;
            shardId,
        // The interleaving that lost acked writes under the concurrent design: a new primary claims the fence
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
        AtomicBoolean fetchCompleted = new AtomicBoolean(false);
                }
    private ShardId shardId;
            remoteTranslogTransferTracker
                "translog-23.tlog",
                }
    }
import org.opensearch.core.index.shard.ShardId;
            remoteBaseTransferPath.add(METADATA.getName()),
        assertArrayEquals(tlogBytes, Files.readAllBytes(location.resolve("translog-23.tlog")));
        verify(transferService, times(0)).downloadBlob(any(BlobPath.class), eq("translog-23.ckp"));
        AtomicInteger fileTransferFailed = new AtomicInteger();
                generation - 1,
            @Override
        FileTransferTracker reuseTracker = new FileTransferTracker(new ShardId("index", "indexUuid", 0), remoteTranslogTransferTracker);
 * this file be licensed under the Apache-2.0 license or a
            return new ByteArrayInputStream(translogTransferManager.getMetadataBytes(metadata));
            }
                translogTransferSucceeded.incrementAndGet();
        doAnswer(invocationOnMock -> {
            remoteTranslogTransferTracker,
        Thread thread = new Thread(() -> {
    }
    public void testMetadataConflict() throws InterruptedException {
        ) {
            });
        Path downloaded = createTempDir();
            transferService,
            }
        SetOnce<Exception> exception = new SetOnce<>();
        uploadThread.get().interrupt();
    public void testTransferSnapshotWithTranslogMetadata() throws Exception {
import org.opensearch.indices.RemoteStoreSettings;
                fetchCompleted.set(true);
    }
        assertEquals(0, remoteTranslogTransferTracker.getLastSuccessfulDownloadTimestamp());
            remoteTranslogTransferTracker,
        Path repoPath = createTempDir();
        String nodeId = UUID.randomUUID().toString();
            .writeBlobWithMetadata(eq("translog-23.tlog"), any(InputStream.class), Mockito.anyLong(), eq(true), any(), Mockito.isNull());
                minTranslogGeneration,
                anyInt(),
        String tm = new TranslogTransferMetadata(1, 2, 1, 2, nodeId).getFileName();
        // Checksum mismatch (e.g. a stale generation left behind by an earlier incarnation of the shard).
            bmList.add(new PlainBlobMetadata(mdFilename, 1));
        }, null));
            List<BlobMetadata> bmList = List.of(bm1, bm2);
import org.opensearch.common.blobstore.InputStreamWithMetadata;
        assertEquals(primaryTerm, fence.getTerm());
import java.util.HashMap;
            shardId,
            latchedActionListener.onResponse(bmList);
            AtomicBoolean checkpointPresentAtFetch = new AtomicBoolean(true);
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum)));
            return null;
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
                translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
                fetchCompleted.set(true);
        AtomicInteger fileTransferSucceeded = new AtomicInteger();
            remoteBaseTransferPath.add(METADATA.getName()),
            remoteBaseTransferPath.add(METADATA.getName()),
            remoteTranslogTransferTracker
    private BlobPath remoteBaseTransferPath;
        TranslogTransferMetadata tm = new TranslogTransferMetadata(1, 1, 1, 2);
        List<String> metadataFiles = Arrays.asList(mdFilenameGen1, mdFilenameGen2, mdFilenamePrimary2);
                        exception.set(ex);
                if (failNextCas.getAndSet(false)) {
            BlobMetadata bm2 = new PlainBlobMetadata("metadata__1__12__" + timestamp2 + "__node1__1", 1);
    private void mockDownloadBlobWithMetadataResponse() throws IOException {
        }).when(transferService)
     * The fatal/retryable boundary: only a genuinely lost CAS may fail the shard. A transient repository error during
     */
                uploadComplete.incrementAndGet();
                createTempFile(Translog.TRANSLOG_FILE_PREFIX + generation, Translog.CHECKPOINT_SUFFIX),
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.eq;
import java.util.concurrent.atomic.AtomicInteger;
                "translog-34.ckp",
    }
import java.util.LinkedList;
        blobStoreTransferService.uploadBlob(
                createTempFile(Translog.TRANSLOG_FILE_PREFIX + generation, Translog.TRANSLOG_FILE_SUFFIX),
            uploadThread.get().start();
    private TransferService transferService;
        // Since the tracker already holds the files with success state, adding them with failed state would throw exception
            true
                throws IOException {
            TranslogTransferManager manager = new TranslogTransferManager(
            remoteTranslogTransferTracker
    public void testDownloadTranslogIfChangedReusesCurrentLocalGeneration() throws IOException {
            long checksum = createTranslogGeneration(location, 1, true);
        assertTrue(Files.exists(location.resolve("translog-23.tlog")));
            return null;
        translogTransferManager.downloadTranslog("12", "23", location);
    public void testTransferSnapshotWithoutFenceDoesNotRequireConditionalWrites() throws Exception {
import org.opensearch.index.translog.TestTranslog;
            assertTrue(manager.isLocalGenerationCurrent(location, 23, String.valueOf(staleChecksum)));
        byte[] before = Files.readAllBytes(location.resolve("translog-23.tlog"));
        assertNull(uploadFailure.get());
import static org.mockito.Mockito.doAnswer;
            remoteBaseTransferPath.add(TRANSLOG.getName()),
            BlobMetadata bm2 = new PlainBlobMetadata("metadata__1__12__" + timestamp2 + "__node1__1", 1);
import java.util.stream.Collectors;
        }
        FileTransferTracker fileTransferTracker = new FileTransferTracker(
            Set<TransferFileSnapshot> transferFileSnapshots = (Set<TransferFileSnapshot>) invocationOnMock.getArguments()[0];
import static org.mockito.ArgumentMatchers.anyInt;
            @Override
    }
            String timestamp1 = RemoteStoreUtils.invertLong(2345L);
        assertTrue(fenced.isFenceSuperseded(primaryTerm));
            DefaultRemoteStoreSettings.INSTANCE,
            remoteTranslogTransferTracker,
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
            isTranslogMetadataEnabled
import org.opensearch.index.translog.transfer.FileSnapshot.TranslogFileSnapshot;
    long delayForBlobDownload;
            isTranslogMetadataEnabled
    /**
    }
                return super.writeBlobConditionally(blobName, inputStream, blobSize, expectedVersionToken);
            }
                    Thread.sleep(31 * 1000);
import java.util.Base64;
        assertNull(uploadFailure.get());
            Path translogPath = location.resolve(Translog.getFilename(1));
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());
     */
        );
     * truncation, or a remote that does not advertise a checksum for the generation at all.
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
            remoteBaseTransferPath.add(TRANSLOG.getName()),
     */
    }
        assertEquals(
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        String mdFilename2 = tm2.getFileName();
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, null));
            );
            return null;
            fence
        doAnswer(invocationOnMock -> {
            isTranslogMetadataEnabled
        TranslogTransferManager unfenced = fencedTransferManager(null, tracker);
        SetOnce<Exception> exception = new SetOnce<>();
            fileTransferTracker,
    }
            shardId,
    FileTransferTracker tracker;
            remoteBaseTransferPath.add(METADATA.getName()),
            );
            transferFileSnapshots.forEach(listener::onResponse);
        remoteBaseTransferPath = new BlobPath().add("base_path");
        assertTrue(Files.exists(location.resolve("translog-23.ckp")));
    private ThreadPool threadPool;
        );
            public void onSuccess(TransferFileSnapshot fileSnapshot) {
        TranslogTransferListener listener = new TranslogTransferListener() {
            Path location = createTempDir();
        }
    }
        }
    public void testTransferSnapshotOnUploadTimeout() throws Exception {
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
                throw new AssertionError(ex);
        manager.downloadTranslog("12", "23", location);
            BlobMetadata bm1 = new PlainBlobMetadata(mdFilename1.get(), 1);
            }
     * A generation's two files are written one after the other, so a download that dies between them must not leave a
            @Override
            @Override
        tracker.add(checkpointFile, true);
            listener.onFailure(testException);
        // takeover's sweep while the metadata PUT is still in flight; the takeover then reads a restore point
                public Set<TransferFileSnapshot> getTranslogFileSnapshotWithMetadata() throws IOException {
        String tm3 = new TranslogTransferMetadata(2, 3, 1, 2).getFileName();
        assertTrue(Files.exists(location.resolve("translog-23.tlog")));
                any(WritePriority.class),
        RemoteStoreFence stalePrimaryFence = new RemoteStoreFence(container, "node-old-alloc", "node-old", shardId);
            }
        transferService = mock(TransferService.class);
            fileTransferTracker,
     */
        assertEquals(Arrays.asList(mdFilenamePrimary2, mdFilenameGen2, mdFilenameGen1), metadataFiles);
    }
    public void testDownloadTranslogIfChangedInMetadataModeTracksSameFilesAsDownload() throws IOException {
            @Override
        // when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
        primaryTerm = randomLongBetween(1, 1000);
        );
        assertArrayEquals(ckpBytes, Files.readAllBytes(location.resolve("translog-23.ckp")));
    }
            @Override
        // refused rather than acknowledged: the metadata file is a harmless never-acknowledged orphan.
        when(shardId.getIndex()).thenReturn(new Index("index", "indexUUid"));
            transferFileSnapshot,
        TranslogReader reader3 = mock(TranslogReader.class);
            uploadedMetadata.set(Map.copyOf(invocation.getArgument(4)));
        doAnswer(invocation -> {
            try (FileChannel channel = FileChannel.open(translogPath, StandardOpenOption.WRITE)) {
            Thread.sleep(delayForMdDownload);
        Thread.sleep(1);
        }
    /**
        assertFalse(manager.transferSnapshot(createTransferSnapshot(), listener, null));
        doAnswer(invocation -> {
     * the fence CAS must surface as an ordinary retryable upload failure — never as {@link TranslogFencedException},
    }
            TranslogFileSnapshot translogFileSnapshot2 = new TranslogFileSnapshot(
        when(blobStore.blobContainer(any(BlobPath.class))).thenReturn(blobContainer);
        doAnswer(invocation -> {
        Path location = createTempDir();
        };
        assertEquals(0, fence.getSeq());
import org.opensearch.index.translog.TranslogReader;
            @Override
            public void onUploadComplete(TransferSnapshot transferSnapshot) {}
            Files.delete(location.resolve(Translog.getCommitCheckpointFileName(1)));
                @Override
            bmList.add(new PlainBlobMetadata(tm3, 1));
            AtomicBoolean translogPresentAtFetch = new AtomicBoolean(true);
        assertFalse(unfenced.isFenceSuperseded(primaryTerm));
            return null;
            isTranslogMetadataEnabled
                minTranslogGeneration,
                    translogFileSnapshot1.setMetadataFileInputStream(checkpointFileSnapshot1.inputStream());
            DefaultRemoteStoreSettings.INSTANCE,
            bmList.add(new PlainBlobMetadata(mdFilename2, 1));
            List<BlobMetadata> bmList = List.of(bm1, bm2);
            }
        assertTrue(remoteTranslogTransferTracker.getTotalDownloadTimeInMillis() >= delayForBlobDownload);
        tracker.add(translogFile, true);
            bmList.add(new PlainBlobMetadata(mdFilename1, 1));
            byte[] bytes = Files.readAllBytes(checkpointPath);
        SetOnce<Exception> exception = new SetOnce<>();
                primaryTerm,
            BlobMetadata bm1 = new PlainBlobMetadata("metadata__1__12__" + timestamp1 + "__node1__1", 1);
        Path location = createTempDir();
            remoteBaseTransferPath.add(METADATA.getName()),
        };
            new ShardId("index", "indexUUid", 0),
        // checkpoint is a state the download now has to cope with.
    private long minTranslogGeneration;
            DefaultRemoteStoreSettings.INSTANCE,
            transferService,
        Path reused = createTempDir();
                generation,
import org.opensearch.common.blobstore.BlobMetadata;
                fileTransferSucceeded.incrementAndGet();
        doNothing().when(transferService)
            latchedActionListener.onResponse(bmList);
        terminate(threadPool);
        assertTrue(Files.exists(location.resolve(checkpointFile)));
                uploadFailure.set(ex);
                exception.set(ex);
                any(BlobPath.class),
            @Override
            transferFileSnapshots.forEach(listener::onResponse);
                } catch (InterruptedException ignore) {
        }).when(transferService)
        if (nonZeroUploadTime == false) {
                uploadComplete.incrementAndGet();
                null
            new ShardId("index", "indexUUid", 0),
        String mdFilename = tm.getFileName();
        RemoteStoreFence fence = new RemoteStoreFence(container, "node-1-alloc", "node-1", shardId);
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
                "translog-12.ckp",
        FileTransferTracker tracker = new FileTransferTracker(new ShardId("index", "indexUuid", 0), remoteTranslogTransferTracker);
                    return Set.of(translogFileSnapshot1, translogFileSnapshot2);
    private void assertTlogCkpDownloadStatsWithMetadata() {
        assertTrue(remoteTranslogTransferTracker.getTotalDownloadTimeInMillis() >= delayForMdDownload);
        // Checkpoint file belongs to another generation.
            latchedActionListener.onFailure(new IOException("Issue while listing"));
        Files.createFile(location.resolve(translogFile));
import org.opensearch.threadpool.TestThreadPool;
        doAnswer(invocation -> {
        assertTrue("fence CAS was issued before the metadata upload completed", casSawMetadataUploaded.get());
            Files.write(checkpointPath, bytes);
        assertFalse(translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
        };
}
                eq(TranslogTransferMetadata.METADATA_PREFIX),
                throws IOException {
            isTranslogMetadataEnabled
        AtomicInteger uploadComplete = new AtomicInteger();
            @Override
import org.opensearch.common.blobstore.stream.write.WritePriority;
            DefaultRemoteStoreSettings.INSTANCE,
                channel.truncate(Files.size(translogPath) - 1);
        fence.validateAndAdvance(primaryTerm); // this copy owns the chain
            }
                @Override
        AtomicInteger fileTransferSucceeded = new AtomicInteger();
        uploadFailure.set(null);
            Path location = createTempDir();
            } catch (IOException e) {
    public void testDownloadTranslog() throws IOException {
        }).when(transferService).uploadBlob(any(TransferFileSnapshot.class), any(BlobPath.class), any(WritePriority.class), any());
     */
    public void testReadMetadataForGivenTimestampFile() throws IOException {
    public void testReadMetadataForGivenTimestampNoMatchingFile() throws IOException {
        translogTransferManager.downloadTranslog("12", "23", location);
        assertEquals(1, translogTransferSucceeded.get());
            .listAllInSortedOrderAsync(
    public void testTransferSnapshot() throws Exception {
                any(WritePriority.class),
            createTranslogGeneration(location, 2, true);
    }
            latchedActionListener.onResponse(bmList);
            Set<TransferFileSnapshot> transferFileSnapshots = invocationOnMock.getArgument(0);
    public void testTransferSnapshotAdvancesFence() throws Exception {
        assertTlogCkpDownloadStats();
            long checksum = createTranslogGeneration(location, 1, true);
    }
        isTranslogMetadataEnabled = true;
        assertTrue(tracker.uploaded("translog-23.tlog"));
        doAnswer(invocation -> {
                public Set<TransferFileSnapshot> getTranslogFileSnapshots() {
            return new TransferSnapshot() {
    }
            );
        String translogFile = "translog-23.tlog", checkpointFile = "translog-23.ckp";
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
                super.onFailure(fileSnapshot, e);
                    return new TranslogTransferMetadata(primaryTerm, generation, minTranslogGeneration, randomInt(5));
                any(TransferFileSnapshot.class),
            Runnable runnable = () -> {
        );
            );
                }
        // when any later takeover reads its restore point. Issued concurrently instead, the CAS can win before a
        assertEquals("Timed out waiting for transfer of snapshot test-to-string to complete", exception.get().getMessage());
        RemoteStoreFence fence = new RemoteStoreFence(container, "node-old-alloc", "node-old", shardId);
                transferService,
        doAnswer(invocation -> {
import java.util.Objects;
        FsBlobContainer container = fenceContainer();
            Thread.sleep(delayForBlobDownload);
            when(transferService.downloadBlobWithMetadata(any(BlobPath.class), eq("translog-23.tlog"))).thenAnswer(failFirstFetch);
        assertEquals(2, tracker.allUploaded().size());
        translogTransferManager.listTranslogMetadataFilesAsync(new ActionListener<>() {
            @Override
            .uploadBlob(
    public void testlistTranslogMetadataFilesAsync() throws Exception {
        FsBlobStore blobStore = new FsBlobStore(randomIntBetween(1, 8) * 1024, repoPath, false);
    @Override
        assertEquals(2, fileTransferTracker.allUploaded().size());
                @Override
            fileTransferTracker,
        RemoteStoreSettings remoteStoreSettings = mock(RemoteStoreSettings.class);
        List<String> files = List.of(tm2, tm3);
            public void onUploadComplete(TransferSnapshot transferSnapshot) {}
        }, null);
     * A local generation whose footer checksum equals the advertised one is reused: nothing is fetched from the
    }
        // Remote does not know the checksum (metadata uploaded by an older node).
        AtomicReference<String> mdFilename1 = new AtomicReference<>();
            transferService,
                any()
    public void testDeleteTranslogSuccess() throws Exception {
        TranslogTransferManager manager = fencedTransferManager(fence, tracker);
        );
        Path location = createTempDir();
            @Override
        assertTrue(remoteTranslogTransferTracker.getTotalDownloadTimeInMillis() >= 2 * delayForBlobDownload);
            Answer<Object> failFirstFetch = invocation -> {
            public String writeBlobConditionally(String blobName, InputStream inputStream, long blobSize, String expectedVersionToken)
            long checksum = createTranslogGeneration(location, 1, true);
import java.nio.file.StandardOpenOption;
            transferFileSnapshots.forEach(transferFileSnapshot -> {
        assertTrue(manager.transferSnapshot(createTransferSnapshot(), listener, null));
        String mdFilename = tm.getFileName();
        AtomicInteger translogTransferSucceeded = new AtomicInteger();
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
            }
    @SuppressWarnings("unchecked")
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
            Files.move(
    }
            remoteBaseTransferPath.add(METADATA.getName()),
        }).when(transferService)
    public void setUp() throws Exception {
            tracker,
        translogTransferManager = new TranslogTransferManager(
        TranslogTransferManager manager = fencedTransferManager(fence, tracker);
        long checksum = createTranslogGeneration(location, 23, true);
        // Reference: what a real metadata-mode download registers.
    public void testTransferSnapshotFencedByNewOwnerAtSameTerm() throws Exception {
        new RemoteStoreFence(container, "node-2-alloc", "node-2", shardId).validateAndAdvance(primaryTerm + 1);
    public void testTransientFenceErrorIsRetryableNotFatal() throws Exception {
    public void testPopulateFileTrackerWithLocalState() {
        {
        String translogFile = "translog-19.tlog", checkpointFile = "translog-19.ckp";
                casSawMetadataUploaded.set(metadataUploaded.get());
    public void testTakeoverBetweenMetadataUploadAndCasIsNotAcknowledged() throws Exception {
            reuseTracker,
        Files.createFile(location.resolve(checkpointFile));
        assertThrows(RuntimeException.class, translogTransferManager::readMetadata);
        assertEquals(1, uploadComplete.get());
        assertBusy(() -> assertEquals(0, tracker.allUploaded().size()));
        translogTransferManager.populateFileTrackerWithLocalState(List.of(reader1, reader2));
        doAnswer(invocationOnMock -> {
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
        minTranslogGeneration = randomLongBetween(0, generation);
    public void testSynchronousUploadMetadataRecoversCheckpointWithoutCheckpointBlob() throws IOException {
import org.opensearch.index.translog.transfer.FileSnapshot.TransferFileSnapshot;
    public void testPopulateFileTrackerWithLocalStateNoReaders() {
    public void testDownloadTranslogWithTrackerUpdated() throws IOException {
            null
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
        );
    byte[] ckpBytes;
        verify(transferService).downloadBlob(any(BlobPath.class), eq(translogFile));
        assertBusy(() -> assertTrue(fetchCompleted.get()));
            new RemoteStoreFence(container, "node-new-alloc", "node-new", shardId).validateAndAdvance(primaryTerm + 1);
            long checksum = createTranslogGeneration(location, 1, true);
            uploadFailure.get() instanceof TranslogFencedException
            shardId,
        remoteTranslogTransferTracker = new RemoteTranslogTransferTracker(shardId, 20);
        verify(transferService).downloadBlob(any(BlobPath.class), eq("translog-23.ckp"));
            ActionListener<TransferFileSnapshot> listener = invocationOnMock.getArgument(2);
            remoteBaseTransferPath.add(TRANSLOG.getName()),
        translogTransferManager.populateFileTrackerWithLocalState(List.of());
            long staleChecksum = createTranslogGeneration(location, 23, true);
        assertThrows(IllegalStateException.class, () -> tracker.add(translogFile, false));
                    List<TransferFileSnapshot> list = new ArrayList<>(invocationOnMock.getArgument(0));
    public void testFenceOwnershipWrappers() throws Exception {
        TranslogReader reader1 = mock(TranslogReader.class);
            remoteBaseTransferPath.add(TRANSLOG.getName()),
                super.onSuccess(fileSnapshot);
                super.onSuccess(fileSnapshot);
            remoteTranslogTransferTracker,
        AtomicInteger uploadComplete = new AtomicInteger();
            remoteTranslogTransferTracker,
        mockSuccessfulFileUploads();
        assertNoDownloadStats(false);
            return null;
            assertEquals("Failed to upload test-to-string", exception.get().getMessage());
        );
                super.onSuccess(fileSnapshot);
     * download: checksum mismatch, footer-less file, missing checkpoint, checkpoint for a different generation,
        translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
        assertNoDownloadStats(true);
        verify(transferService).downloadBlob(any(BlobPath.class), eq("translog-23.tlog"));
        assertTlogCkpDownloadStatsWithMetadata();
import org.opensearch.core.action.ActionListener;
        ) {
        String translogFile = "translog-19.tlog", checkpointFile = "translog-19.ckp";
            Set<TransferFileSnapshot> transferFileSnapshots = (Set<TransferFileSnapshot>) invocationOnMock.getArguments()[0];
        );
            public void onSuccess(TransferFileSnapshot fileSnapshot) {
            @Override
import java.nio.file.Path;
                location.resolve(Translog.getCommitCheckpointFileName(1))
            @Override
            Path location = createTempDir();
        BlobContainer blobContainer = mock(BlobContainer.class);
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());
        Thread.sleep(1000);
            }
    private FsBlobContainer fenceContainer() throws IOException {
        // Fencing disabled: no fence.
        primaryTerm = randomNonNegativeLong();
        tracker = new FileTransferTracker(new ShardId("index", "indexUuid", 0), remoteTranslogTransferTracker);
    TranslogTransferManager translogTransferManager;
            throw new IOException("Failed to create transfer snapshot");
import java.nio.channels.FileChannel;
        translogTransferManager = new TranslogTransferManager(
            assertFalse(Files.exists(translogPath));
    public void testDownloadTranslogRemovesStaleLocalFilesBeforeFetching() throws IOException {
import org.opensearch.index.translog.Translog;
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());
            @Override
        long count = mdFilename.chars().filter(ch -> ch == METADATA_SEPARATOR.charAt(0)).count();
            TransferFileSnapshot actualFileSnapshot = transferFileSnapshots.iterator().next();
        Files.createFile(location.resolve("translog-23.tlog"));
            isTranslogMetadataEnabled
    }
            tracker,
        assertTrue(tracker.uploaded("translog-23.tlog"));
                throw new IOException("simulated failure before any byte was written");
        {
        when(transferService.downloadBlob(any(BlobPath.class), eq("translog-23.ckp"))).thenAnswer(invocation -> {
                    public void onUploadComplete(TransferSnapshot transferSnapshot) {}
                throw new AssertionError("an upload whose fence was taken over mid-flight must not be acknowledged");
        assertTrue("the target never wrote, so the revert reclaims ownership", fenced.revertFenceOwnership(primaryTerm));
            }
        String ckpDataString = Base64.getEncoder().encodeToString(ckpBytes);
            Path checkpointPath = location.resolve("translog-23.ckp");
    public void testIsLocalGenerationCurrentFallsBackWhenLocalStateCannotBeTrusted() throws IOException {
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
            bmList.add(new PlainBlobMetadata(tm1, 1));
                public String toString() {
        String mdFilenameGen2 = new TranslogTransferMetadata(1, 2, 1, 2).getFileName();
            remoteBaseTransferPath.add(METADATA.getName()),
                shardId,
    }
            Path location = createTempDir();
        String mdFilenamePrimary2 = new TranslogTransferMetadata(2, 1, 1, 2).getFileName();
import java.util.ArrayList;
        }
     * When the local copy cannot be proven current the generation is downloaded, and nothing is registered with the
                eq(ThreadPool.Names.REMOTE_PURGE),
                exception.set(ex);
        });
        TranslogReader reader4 = mock(TranslogReader.class);
        doNothing().when(transferService)
        tracker.add(checkpointFile, true);
                remoteBaseTransferPath.add(TRANSLOG.getName()),
            };
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        });
        assertFalse(Files.exists(location.resolve("translog-23.ckp")));
            @Override
import org.opensearch.action.LatchedActionListener;
import static org.mockito.Mockito.mock;
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
            shardId,
            };
                eq(ThreadPool.Names.REMOTE_PURGE),
        assertThrows(IOException.class, translogTransferManager::readMetadata);
     * With checkpoint data carried as object metadata there is no remote {@code .ckp} object, so a downloaded
        }, null));
            shardId,
            remoteBaseTransferPath.add(TRANSLOG.getName()),
            fileTransferTracker,
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
            remoteBaseTransferPath.add(METADATA.getName()),
        TransferFileSnapshot transferFileSnapshot = new TransferFileSnapshot("translog-23.tlog", tlogBytes, 12);
        thread.start();
            DefaultRemoteStoreSettings.INSTANCE,
    }
    // tests for cases when ckp is stored as translog metadata.
            @Override
        AtomicReference<Exception> uploadFailure = new AtomicReference<>();
        AtomicInteger translogTransferSucceeded = new AtomicInteger();
import org.opensearch.threadpool.ThreadPool;
            DefaultRemoteStoreSettings.INSTANCE,
            return null;
            );
     * exactly the same state, so callers that iterate tracked files see no difference between the two paths.
        Path location = createTempDir();
        Tuple<Tuple<Long, Long>, String> actualOutput = TranslogTransferMetadata.getNodeIdByPrimaryTermAndGeneration(tm);
        for (boolean metadataMode : new boolean[] { false, true }) {
        tlogBytes = "Hello Translog".getBytes(StandardCharsets.UTF_8);
        assertTrue(translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
            remoteTranslogTransferTracker,
                    throw new IOException("simulated transient repository error");
        assertTrue(Files.exists(location.resolve("translog-23.ckp")));
        verify(transferService).downloadBlob(any(BlobPath.class), eq(checkpointFile));
        RemoteStoreFence fence = new RemoteStoreFence(container, "node-source-alloc", "node-source", shardId);
            );
            bmList.add(new PlainBlobMetadata(mdFilename2, 1));
        BlobContainer blobContainer = mock(BlobContainer.class);
    }
        assertEquals(0, fileTransferFailed.get());
            shardId,
import org.opensearch.common.blobstore.fs.FsBlobStore;
    @Override
        }
     * a stale checkpoint with the same offset would locate the new footer and trust the pair. The download therefore
        doAnswer(invocationOnMock -> {
        assertNotNull(exception.get());
        AtomicBoolean casSawMetadataUploaded = new AtomicBoolean();
        TranslogTransferMetadata metadata = createTransferSnapshot().getTranslogTransferMetadata();
                null
        thread.interrupt();
    }
 * SPDX-License-Identifier: Apache-2.0
            return null;
                any(ActionListener.class)
                eq(files),
        doAnswer(invocationOnMock -> {
            }
        doAnswer(invocation -> { throw new IOException("test exception"); }).when(blobStore).blobContainer(any(BlobPath.class));
        assertTlogCkpDownloadStats();
import java.util.UUID;
                fileTransferSucceeded.incrementAndGet();
        mdFilename1.set("metadata__1__12__" + timestamp1 + "__node1__1");
        assertEquals(2, fileTransferSucceeded.get());
            "a transient fence error must not be classified as fenced: " + uploadFailure.get(),
            }
            shardId,
        assertTrue(translogTransferManager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
            public void onFailure(Exception e) {
            CheckpointFileSnapshot checkpointFileSnapshot2 = new CheckpointFileSnapshot(
            assertTrue(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum)));
            ActionListener<List<BlobMetadata>> actionListener = invocation.getArgument(4);
    }
     * removes both local files before the remote is contacted, in either mode, so no partial outcome can be trusted.
                listener.onResponse(transferFileSnapshot);
        }).when(blobContainer)
            }
        }).when(transferService).uploadBlob(any(TransferFileSnapshot.class), any(BlobPath.class), any(WritePriority.class), any());
            }
            @Override
    }
        // Expect delay for both tlog and ckp file
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
            invocation -> new InputStreamWithMetadata(new ByteArrayInputStream(uploadedTranslog.get()), uploadedMetadata.get())
        String tm1 = new TranslogTransferMetadata(1, 1, 1, 2).getFileName();
        shardId = mock(ShardId.class);
            remoteTranslogTransferTracker,
    }
        assertEquals(2, tracker.allUploaded().size());
            CheckpointFileSnapshot checkpointFileSnapshot1 = new CheckpointFileSnapshot(
        assertEquals(1, translogTransferSucceeded.get());
import static org.mockito.Mockito.anySet;
            return new ByteArrayInputStream(tlogBytes);
            List<BlobMetadata> bmList = new LinkedList<>();
            BlobMetadata bm2 = new PlainBlobMetadata("metadata__1__12__" + timestamp2 + "__node1__1", 1);
        assertTrue(uploadFailure.get().toString(), uploadFailure.get() instanceof TranslogFencedException);
    }
     * never needs to know whether the feature is on. With a fence they delegate to it.
            }
            transferService,
            remoteTranslogTransferTracker,
        assertNull(translogTransferManager.readMetadata());
                fileTransferSucceeded.incrementAndGet();
            Path checkpointPath = location.resolve(Translog.getCommitCheckpointFileName(23));
    }
        AtomicBoolean metadataUploaded = new AtomicBoolean();
    public void testReadMetadataForGivenTimestampException() throws IOException {
            TranslogFileSnapshot translogFileSnapshot1 = new TranslogFileSnapshot(
import java.util.concurrent.atomic.AtomicReference;
                }
        verify(blobContainer, times(1)).readBlobWithMetadata("translog-23.tlog");
        when(transferService.downloadBlob(any(BlobPath.class), eq(mdFilename1.get()))).thenThrow(new IOException("Something went wrong"));
    }
        }).when(transferService).uploadBlobs(anySet(), anyMap(), any(ActionListener.class), any(WritePriority.class), any());
            );
import static org.opensearch.index.translog.transfer.TranslogTransferManager.CHECKPOINT_FILE_DATA_KEY;
        String tm2 = new TranslogTransferMetadata(1, 2, 1, 2).getFileName();
        when(reader3.getGeneration()).thenReturn(34L);
import org.opensearch.test.OpenSearchTestCase;
        translogTransferManager.populateFileTrackerWithLocalState(null);
                    return Set.of(checkpointFileSnapshot1, checkpointFileSnapshot2);
        Path repoPath = createTempDir();
                    public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
            blobStoreTransferService,
    boolean isTranslogMetadataEnabled;
                }
import java.io.ByteArrayInputStream;
        FsBlobContainer container = fenceContainer();
        });
        );
        assertThrows(IOException.class, () -> translogTransferManager.readMetadata(3000L));
        }).when(transferService)
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
            tracker,
        });
            }
        assertFalse(manager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
            @Override
            LatchedActionListener<List<BlobMetadata>> latchedActionListener = invocation.getArgument(3);
                any()
        assertEquals(2, uploadComplete.get());
        BlobStoreTransferService blobStoreTransferService = new BlobStoreTransferService(blobStore, threadPool);
            }
            remoteBaseTransferPath.add(METADATA.getName()),
            remoteBaseTransferPath.add(TRANSLOG.getName()),
        assertEquals(3, fileTransferTracker.allUploaded().size());
    }
                translogTransferSucceeded.incrementAndGet();
        Path repoPath = createTempDir();
        assertNoDownloadStats(false);
            return null;
        doAnswer(invocationOnMock -> {
        assertFalse(Files.exists(location.resolve("translog-23.tlog")));
            shardId,
        );
                fileTransferFailed.incrementAndGet();
        when(reader2.getGeneration()).thenReturn(23L);
            );
                translogTransferSucceeded.incrementAndGet();
        assertFalse(manager.transferSnapshot(createTransferSnapshot(), listener, null));
        assertFalse(Files.exists(location.resolve("translog-23.ckp")));
            return new InputStreamWithMetadata(new ByteArrayInputStream(tlogBytes), metadata);
            uploadThread.set(new Thread(() -> {
            remoteBaseTransferPath.add(METADATA.getName()),
        }).when(transferService)
            @Override
        // Local generation written before footers existed.
            ),
        // while this upload's metadata PUT is in flight, then reads its restore point - which cannot include this
        AtomicInteger translogTransferFailed = new AtomicInteger();
        assertTlogCkpDownloadStats();
                createTempFile(Translog.TRANSLOG_FILE_PREFIX + (generation - 1), Translog.CHECKPOINT_SUFFIX),
                    return Set.of(translogFileSnapshot1, translogFileSnapshot2);
        tracker.add(translogFile, true);
    }
            bmList.add(new PlainBlobMetadata(tm1, 1));
            assertFalse(manager.isLocalGenerationCurrent(location, 23, String.valueOf(staleChecksum)));
import java.util.List;
        RemoteStoreFence fence = new RemoteStoreFence(container, "node-1-alloc", "node-1", shardId);
        TranslogTransferManager fenced = fencedTransferManager(fence, tracker);
        mockSuccessfulFileUploads();
                uploadFailure.set(ex);
            DefaultRemoteStoreSettings.INSTANCE,
            verify(transferService).listAllInSortedOrderAsync(
        );
            @Override
    public void testReadMetadataReadException() throws IOException {
        }).when(transferService)
            }
        new RemoteStoreFence(container, "node-new-alloc", "node-new", shardId).validateAndAdvance(primaryTerm + 1);
import java.util.Set;
            public void onSuccess(TransferFileSnapshot fileSnapshot) {
                DefaultRemoteStoreSettings.INSTANCE,
            return null;
            Thread.sleep(delayForBlobDownload);
            remoteBaseTransferPath.add(TRANSLOG.getName()),
        assertTrue(uploadFailure.get().toString(), uploadFailure.get() instanceof TranslogFencedException);
        }).when(transferService)
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
        long delayForMdDownload = 1;
                location.resolve(Translog.getCommitCheckpointFileName(2)),
        };
        doAnswer(invocation -> {
        AtomicReference<String> mdFilename1 = new AtomicReference<>();
        when(reader4.getGeneration()).thenReturn(45L);
                primaryTerm,
            DefaultRemoteStoreSettings.INSTANCE,
        assertTrue(exception.get() instanceof TranslogUploadFailedException);
            actionListener.onResponse(bmList);
            uploadedTranslog.set(((InputStream) invocation.getArgument(1)).readAllBytes());
            }));
                any(BlobPath.class),
            @Override
            true
import org.opensearch.common.SetOnce;
            Thread t = new Thread(runnable);
import java.nio.charset.StandardCharsets;
     * generation registers only the {@code .tlog} with the tracker. A reused generation must leave the tracker in
        when(transferService.downloadBlob(any(BlobPath.class), eq(mdFilename1))).thenAnswer(invocation -> {
                null
        mockDownloadBlobWithMetadataResponse();
        translogTransferManager.deleteStaleTranslogMetadataFilesAsync(() -> {
        assertTrue(manager.transferSnapshot(createTransferSnapshot(), new TranslogTransferListener() {
        mockSuccessfulFileUploads();
        }, null));
            remoteTranslogTransferTracker,
            // And the full path downloads it, replacing the corrupt local files.
            remoteTranslogTransferTracker,
    }
            true
     * The fence wrappers answer for both configurations. With no fence (fencing disabled) callers get the safe
                public Set<TransferFileSnapshot> getCheckpointFileSnapshots() {
            assertFalse("translog must be gone before the remote is contacted", translogPresentAtFetch.get());
        // The retry recovers: the fence bootstraps and the upload is acknowledged.
    public void tearDown() throws Exception {
            fileTransferTracker,
        assertEquals(Set.of("translog-12.tlog", "translog-23.tlog"), translogTransferManager.getFileTransferTracker().allUploaded());
            remoteStoreSettings,
        assertFalse(fenced.isFenceSuperseded(primaryTerm));
        fenced.transferFenceOwnership(primaryTerm, "target-alloc");
            public void onUploadComplete(TransferSnapshot transferSnapshot) {
            transferService,
                    listener.onResponse(transferFileSnapshot);
/*
                uploadFailure.set(ex);
                any(BlobPath.class),
        doAnswer(invocationOnMock -> {
import org.opensearch.index.translog.transfer.FileSnapshot.CheckpointFileSnapshot;
import java.io.IOException;
            public void onUploadFailed(TransferSnapshot transferSnapshot, Exception ex) {
        AtomicReference<byte[]> uploadedTranslog = new AtomicReference<>();
                assertNotNull(transferFileSnapshot.getMetadataFileInputStream());
            assertArrayEquals(ckpBytes, Files.readAllBytes(checkpointPath));
                tracker,
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum)));
            public void onFailure(TransferFileSnapshot fileSnapshot, Exception e) {
        assertEquals(translogTransferManager.getMetadataBytes(metadata).length, remoteTranslogTransferTracker.getDownloadBytesSucceeded());
        translogTransferManager.deleteGenerationAsync(primaryTerm, Set.of(19L), () -> {});
import static org.mockito.Mockito.anyMap;
            }
        List<String> files = List.of(checkpointFile, translogFile);
        when(blobContainer.readBlobWithMetadata("translog-23.tlog")).thenAnswer(
            }
        assertEquals(tlogBytes.length, remoteTranslogTransferTracker.getDownloadBytesSucceeded());
import static org.mockito.Mockito.verify;
        SetOnce<Thread> uploadThread = new SetOnce<>();
            List<BlobMetadata> bmList = new LinkedList<>();
        String timestamp1 = RemoteStoreUtils.invertLong(2345L);
        mockSuccessfulFileUploads();
            metadataUploaded.set(true);
    public void testDeleteTranslogFailure() throws Exception {
        tracker.add(checkpointFile, true);
            ActionListener<TransferFileSnapshot> listener = (ActionListener<TransferFileSnapshot>) invocationOnMock.getArguments()[2];
                throw new AssertionError("upload must not be acknowledged for a fenced primary");
        AtomicInteger translogTransferSucceeded = new AtomicInteger();
        Collections.sort(metadataFiles);
import org.mockito.Mockito;
                "translog-45.ckp"
        assertFalse(reuseManager.downloadTranslogIfChanged("12", "23", reused, String.valueOf(checksum)));
            createTranslogGeneration(location, 1, true);
        {
        {
            true
        assertFalse(translogTransferManager.downloadTranslogIfChanged("12", "23", location, String.valueOf(checksum)));
            latchedActionListener.onResponse(bmList);
            new ShardId("index", "indexUUid", 0),
        assertEquals(1, fence.getSeq());
                assertEquals(blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList()), List.of(tm1, tm2, tm3));
            tracker,
        assertEquals(metadata, translogTransferManager.readMetadata());
        assertThrows(IllegalStateException.class, () -> tracker.add(checkpointFile, false));
        assertNull(translogTransferManager.readMetadata(1234L));
        String mdFilename1 = metadata1.getFileName();
        try {
            Path location = createTempDir();
            latchedActionListener.onResponse(bmList);
            transferService,
                    throw new RuntimeException(e);
            long checksum = createTranslogGeneration(location, 1, false);
        assertThrows(IOException.class, translogTransferManager::readMetadata);
        when(transferService.downloadBlob(any(BlobPath.class), any(String.class))).thenThrow(new IOException("Something went wrong"));
            Path translogPath = location.resolve("translog-23.tlog");
        mdFilename1.set("metadata__1__12__" + timestamp1 + "__node1__1");
        assertEquals(1, fileTransferFailed.get());
                eq(ThreadPool.Names.REMOTE_PURGE),
        assertTrue(manager.transferSnapshot(createTransferSnapshot(), listener, null));
        Map<String, String> metadata = new HashMap<>();
     */
import java.io.InputStream;
            return null;
        // acked-write loss (RemoteStoreFence.tla in formal-models/ exhibits the trace with SEQUENCED = FALSE).
    }
            transferService,
        assertEquals(0, fence.getSeq());
        assertTrue(uploadFailure.get().toString(), uploadFailure.get() instanceof TranslogFencedException);
                throw new AssertionError(ex);
        BlobStoreTransferService blobStoreTransferService = new BlobStoreTransferService(blobStore, threadPool);
    byte[] tlogBytes;
        super.setUp();
            List<BlobMetadata> bmList = new LinkedList<>();
                eq(ThreadPool.Names.REMOTE_PURGE),
import java.util.Arrays;
        TranslogTransferListener listener = new TranslogTransferListener() {
     * tracker until that download has succeeded.
            remoteBaseTransferPath.add(TRANSLOG.getName()),
                any(BlobPath.class),
    public void testDeleteStaleTranslogMetadata() {
import org.opensearch.common.blobstore.BlobContainer;
            assertFalse(translogTransferManager.isLocalGenerationCurrent(location, 1, String.valueOf(checksum + 1)));
            remoteTranslogTransferTracker,
    }
            remoteBaseTransferPath.add(METADATA.getName()),
    }
        FsBlobContainer container = fenceContainer();
        verify(transferService, times(0)).downloadBlobWithMetadata(any(BlobPath.class), any(String.class));
        assertTrue(metadataModeManager.downloadTranslogIfChanged("12", "23", downloaded, null));
            .listAllInSortedOrder(any(BlobPath.class), eq(TranslogTransferMetadata.METADATA_PREFIX), anyInt(), any(ActionListener.class));
                new RuntimeException("FileTransferUploadNeedsToFail-Exception")
        // A reused generation in a fresh tracker must register the very same set.
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
        assertTrue(tracker.uploaded("translog-23.ckp"));
                throw new RuntimeException(e);
            ActionListener<TransferFileSnapshot> listener = (ActionListener<TransferFileSnapshot>) invocationOnMock.getArguments()[2];
        TranslogTransferListener listener = new TranslogTransferListener() {
                }
        }).when(transferService)
        BlobStoreTransferService blobStoreTransferService = new BlobStoreTransferService(blobStore, threadPool);
        TranslogTransferManager translogTransferManager = new TranslogTransferManager(
        RemoteStoreFence fence = new RemoteStoreFence(container, "node-1-alloc", "node-1", shardId);
                uploadFailure.set(ex);
        doAnswer(invocation -> {
            return null;
        assertNotNull(uploadFailure.get());
            t.start();
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_SEPARATOR;
        // without this generation and the writer acknowledges an operation no recovery will ever resolve -
                Mockito.eq(remoteBaseTransferPath.add(String.valueOf(primaryTerm))),
            blobStoreTransferService,
        // Relocation target (or a new primary) takes over the fence out of band
