            new Tuple<>(701L, 1008L),
        assertEquals(  
        fail.failAlways();
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of());
            .build();
        );
    }
    public void testMetadataFileDeletionWithPinnedTimestamps() throws Exception {
            new Tuple<>(5807L, 7917L),
        verify(translogTransferManager).listPrimaryTermsInRemote();  
        // This means there are no new invocations of deletePrimaryTermAsync
                        Set<String> metadataFilesAfterTrim = blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR));  
    }
                20,
            translog.getMinMaxTranslogGenerationFromMetadataFile(
            }
                translogTransferManager,
            minPrimaryTermInRemote,
                }
        assertBusy(() -> assertEquals(2, translog.allUploaded().size()));
import org.opensearch.index.translog.transfer.TranslogTransferManager;
        assertFalse(translog.isGenerationPinned(10, pinnedGenerations));  
            true,  
        slowDown.setSleepSeconds(2);  
            metadataFilesToBeDeleted,  
                    }
        when(md1.getGenerationToPrimaryTermMapper()).thenReturn(null);
            assertEquals(2, translog.allUploaded().size());
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("6", 6, primaryTerm.get(), new byte[] { 1 }));
                "metadata__9223372036438563903__9223372036854675843__9223370311919910408__31__9223372036854771234__4__1",
            "metadata__9223372036854775806__9223372036854775777__9223370311919910398__31__9223372036854775781__1__1",
        assertTrue(translog.isGenerationPinned(120, pinnedGenerations));
        assertEquals(2, minPrimaryTermInRemote.get());
import org.opensearch.node.Node;  
        updatePinnedTimstampTask.run();
    public void testGetMinPrimaryTermInRemoteNotFetchedEmpty() throws IOException {
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(0), 0, primaryTerm.get(), new byte[] { 1 }));
        assertEquals(3, translog.readers.size());
        );  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));  
        }, 30, TimeUnit.SECONDS);
        assertEquals(  
        verify(translogTransferManager, times(1)).deletePrimaryTermsAsync(anyLong());  
        assertTrue(translog.isOpen());
        AtomicLong minPrimaryTermInRemote = new AtomicLong(Long.MAX_VALUE);  
        );
import org.opensearch.common.settings.ClusterSettings;  
        when(translogTransferManager.readMetadata("metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__1"))  
        ArrayList<Translog.Operation> ops = new ArrayList<>();
            assertEquals(6, translog.allUploaded().size());
import org.opensearch.indices.DefaultRemoteStoreSettings;
                    }
    public void testIsGenerationPinned() {
            "metadata__9223372036438563903__9223372036854775701__" + md4Timestamp + "__31__9223372036854775701__1"  
            }  
        String translogUUID = Translog.createEmptyTranslog(  
        List<String> metadataFilesNotToBeDeleted = new ArrayList<>();
        assertTrue(generations.containsAll(md2Generations));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("5", 5, primaryTerm.get(), new byte[] { 1 }));
            // 1 to 4
        );
        long pinnedTimestamp = RemoteStoreUtils.invertLong(md3Timestamp) + 10000;  
        generations.removeAll(md3Generations);
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);  
import org.opensearch.indices.RemoteStoreSettings;
            metadataFilesNotToBeDeleted,
        TreeSet<Tuple<Long, Long>> pinnedGenerations = new TreeSet<>(new TreeSet<>((o1, o2) -> {
    public void testDeleteStaleRemotePrimaryTermsOldFormat() throws IOException {
        assertBusy(() -> {  
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
            assertEquals(9, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());  
    @Override  
                config,
        }  
        Long expectedMinPrimaryTerm = 4L;
        // New format metadata file
        long currentTimeInMillis = System.currentTimeMillis();  
        // Case 4 - After drainSync, if an upload is an attempted, we do not upload to remote store.
            )
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
            List.of(
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("7", 7, primaryTerm.get(), new byte[] { 1 }));
        TranslogTransferMetadata md2 = mock(TranslogTransferMetadata.class);
            new Tuple<>(2474L, 3462L),
        // Case 1 - During ongoing uploads, the available permits are 0.
                        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        String md3Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 600000);  
        translog.trimUnreferencedReaders();  
        String md1Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis + 100000);
        assertEquals(  
            "metadata__9223372036854775806__9223372036854775770__9223370311919910398__31__9223372036854775790__1__1",  
        assertEquals(expectedMinPrimaryTerm, RemoteFsTimestampAwareTranslog.getMinPrimaryTermInRemote(new AtomicLong(12), null, null));
        // Fetch pinned timestamps so that it won't be stale
            "metadata__9223372036438563903__9223372036854775798__" + md3Timestamp + "__31__9223372036854775701__1",  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
import java.util.Map;
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));
        String newFormatMetadataFile =  
                persistedSeqNos::add,
        );
                logger
        when(blobStoreRepository.blobStore()).thenReturn(blobStore);
            } catch (TranslogUploadFailedException e) {  
        verify(translogTransferManager, times(0)).deletePrimaryTermsAsync(anyLong());
        String malformedMdFileName = "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__xyz__3qwe__1";
        int count = 0;  
        // Fetch pinned timestamps so that it won't be stale
            "metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__9223372036438563958__4__1",
            false,  
        List<String> metadataFiles = List.of(
    }
        Set<Long> md3Generations = LongStream.rangeClosed(27, 42).boxed().collect(Collectors.toSet());
            // PT 2 to 7
        assertTrue(generations.containsAll(md3Generations));  
            try {  
        );  
        assertTrue(generations.containsAll(md1Generations));
                translogUUID,  
            "metadata__9223372036438563903__9223372036854774799__9223370311919910393__node__1__9223372036438563958__2__1";
            new Translog.Index(String.valueOf(numDocs), numDocs, primaryTerm.get(), new byte[] { 1 })
        translog.trimUnreferencedReaders();
                long currentTime = System.currentTimeMillis();  
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
            "metadata__9223372036438563903__9223372036854774799__" + md2Timestamp + "__31__9223372036854775106__1",
            staticLogger  
                @Override
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(  
        assertEquals(metadataFiles.get(1), metadataFilesToBeDeleted.get(0));
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        List<String> metadataFiles = List.of(
        // Fetch pinned timestamps so that it won't be stale
            // MaxGen 12  
                "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1",  
                latch.countDown();  
            minPrimaryTermInRemote,  
            try {  
            shardId,  
            )
            repository,
                "metadata__9223372036854775797__9223372036854775800__9223370311919910398__31__9223372036854775803__10__1",  
                logger
import org.apache.lucene.tests.util.LuceneTestCase;  
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
            )
            "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1"
            );
            translog.getMinMaxTranslogGenerationFromMetadataFile(
            clusterService  
            metadataFiles,  
            translog.getMinMaxTranslogGenerationFromMetadataFile(  
        updatePinnedTimstampTask.run();  
    public void testGetGenerationsToBeDeletedEmptyMetadataFilesNotToBeDeleted() throws IOException {  
            minPrimaryTermInRemote,
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));  
        assertBusy(() -> {
                            pinnedTimestamps.add(timestamp);
        CountDownLatch latch = new CountDownLatch(1);  
        );  
        );  
        assertTrue(generations.isEmpty());
        verify(translogTransferManager, times(1)).deletePrimaryTermsAsync(anyLong());
        // Refill the permits back  
import java.util.HashMap;
            "metadata__9223372036438563903__9223372036854775701__" + md3Timestamp + "__31__9223372036854775701__1"
                        }  
import org.opensearch.common.blobstore.BlobMetadata;
            );  
        translog.setMinSeqNoToKeep(1);
            metadataFiles,
        ArrayList<Translog.Operation> ops = new ArrayList<>();  
        // Node id containing separator  
            "metadata__9223372036854775806__9223372036854775707__9223370311919910403__31__9223372036854775765__1__1"  
        generations.removeAll(md1Generations);
        // Fetch pinned timestamps so that it won't be stale  
        List<String> metadataFilesToBeDeleted = RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(
        );  
            "metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__9223372036438563958__4__1",  
        assertEquals(  
        assertEquals(metadataFiles, metadataFilesToBeDeleted);
        // Case 2 - During an upload, if drainSync is called, it will wait for it to acquire and available permits are 0.
        // For older md filenames, it needs to read the content
            Runnable updateTask = invocationOnMock.getArgument(0);
import org.opensearch.common.collect.Tuple;  
                translogTransferManager,
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of(1L, 2L, 3L, 4L));
        assertTrue(generations.containsAll(md1Generations));
        assertEquals(3, translog.readers.size());
        pinnedGenerations.add(new Tuple<>(12L, 78L));
                            pinnedTimestampMatchingMetadataFiles.add(metadataFilename);  
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            10L,
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            };
        // Removing file that is pinned by latest refresh timestamp
            // 4 to 7  
                        }
        long pinnedTimestamp = RemoteStoreUtils.invertLong(md2Timestamp) + 10000;  
    RemoteStorePinnedTimestampService remoteStorePinnedTimestampServiceSpy;  
        assertEquals(1, metadataFilesToBeDeleted.size());  
            repositoriesServiceSupplier,  
        // Old format metadata file
        assertEquals(1, translog.readers.size());
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
                        // we will not delete them  
                "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1",  
        );
        );
            primaryTerm.get()
                return o1.v1().compareTo(o2.v1());
        return new RemoteFsTimestampAwareTranslog(
            assertEquals(4, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
    public void testGetMetadataFilesToBeDeletedExclusionBasedOnGenerationOnly() throws IOException {
        List<String> metadataFilesToBeDeleted = RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(
        Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslogTests.class);
                while (RemoteStorePinnedTimestampService.getPinnedTimestamps().v1() < currentTime) {
            );
                "metadata__9223372036438563903__9223372036854767890__9223370311919910434__31__9223372036854770000__7__1",
        assertBusy(() -> {  
        pinnedGenerations.add(new Tuple<>(4L, 9L));
            "metadata__9223372036438563903__9223372036854775600__" + md3Timestamp + "__31__9223372036854775803__1",
        List<String> metadataFilesToBeDeleted = new ArrayList<>(metadataFiles);
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        updatePinnedTimstampTask.run();
            metadataFiles,
        assertEquals(4, translog.allUploaded().size());  
        assertEquals(minPrimaryTerm, minMaxPrimaryterm.v1());  
        TranslogTransferMetadata md3 = mock(TranslogTransferMetadata.class);  
        // Fetch pinned timestamps so that it won't be stale  
            "metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__1",
            false,  
        );  
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { 1 }));
            .thenThrow(new IOException());  
        // Malformed md filename  
        verify(translogTransferManager, times(0)).readMetadata(
 * The OpenSearch Contributors require contributions made to  
                public void onResponse(List<BlobMetadata> blobMetadataList) {
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
        updatePinnedTimstampTask.run();  
        }
            "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1"
        translog.setMinSeqNoToKeep(6);
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);  
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()  
import org.opensearch.cluster.metadata.RepositoryMetadata;
        assertEquals(2, minPrimaryTermInRemote.get());
import org.opensearch.common.unit.TimeValue;
        translog.setMinSeqNoToKeep(6);
        TranslogTransferMetadata md2 = mock(TranslogTransferMetadata.class);
        });
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("5", 5, primaryTerm.get(), new byte[] { 1 }));
            new Tuple<>(4573L, 99964L),
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(
        verify(translogTransferManager).readMetadata("metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1");
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
            // PT 4 to 9
        List<String> metadataFiles = List.of(
        );
            // PT 2 to 7
        pinnedGenerations.add(new Tuple<>(121L, 140L));
                translogTransferManager
        pinnedGenerations.add(new Tuple<>(142L, 160L));  
        String md4Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis + 60000);  
        super.setUp();
                        }
                repository,
                20,
        fail.failAlways();
        when(md1.getMinTranslogGeneration()).thenReturn(701L);
            "metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__1"
        );
                // MaxGen 17  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));  
    }  
        AtomicLong minPrimaryTermInRemote = new AtomicLong(Long.MAX_VALUE);  
                16,
                    // This means test failure  
                10,
        );  
    public void testDeleteStaleRemotePrimaryTerms() throws IOException {
        md1 = mock(TranslogTransferMetadata.class);
            // 17 to 37
            // 26 to 30  
            )
                }
        assertNull(TranslogTransferMetadata.getMinMaxPrimaryTermFromFilename(malformedMdFileName));
                translogTransferManager,
                "metadata__9223372036854774799__9223372036854774799__9223370311919910393__31__9223372036854775106__1__1",  
        Set<String> mdFiles = blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR));
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
        assertEquals(
        Set<Long> md2Generations = LongStream.rangeClosed(17, 37).boxed().collect(Collectors.toSet());
        assertBusy(() -> assertEquals(0, translog.availablePermits()));  
                        maxGen -= 1;  
        String md2Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 400000);
        );  
        }  
        generations.removeAll(md3Generations);
        ) {
        verify(translogTransferManager).listPrimaryTermsInRemote();
        metadataFiles.add("metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__9223372036854775803__1");
            )
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        updatePinnedTimstampTask.run();
                    }  
                new HashMap<>(),
import static org.mockito.Mockito.when;
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
        slowDown.setSleepSeconds(0);
        // Test deletion of metadata files
            // 1 to 4
            Long.MAX_VALUE,
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
                    List<String> pinnedTimestampMatchingMetadataFiles = new ArrayList<>();
import java.util.HashSet;
        );  
    }
        assertEquals(
            Long.MAX_VALUE,  
        when(blobContainer.listBlobs()).thenReturn(Map.of());
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));
            )
        assertNull(TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(oldFormatMdFilename));  
                "metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1",
    }  
                translog.sync();
                    } catch (Exception e) {
            Long.MAX_VALUE,  
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()  
                translogTransferManager  
            assertEquals(
        // Acquire the permits so that remote translog deletion will not happen
            Integer.MAX_VALUE,
            .thenReturn(md1);
            // PT 2 to 6  
        // 4. After drainSync, if an upload is an attempted, we do not upload to remote store.  
        // Case 3 - After drainSync, if trimUnreferencedReaders is attempted, we do not delete from remote store.
        );
import org.opensearch.threadpool.ThreadPool;
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(  
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        assertEquals(
            .thenReturn(md3);  
                translogTransferManager
        translog.setMinSeqNoToKeep(6);  
        assertEquals(1, translog.readers.size());  
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(
        pinnedGenerations.add(new Tuple<>(12L, 34L));
            minPrimaryTermInRemote,
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        // Calling it again to check if the details are getting fetched from the cache.
                "metadata__9223372036438563903__9223372036854772345__9223370311919910429__31__9223372036854773333__6__1",  
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
            )  
        latch.await();
        updatePinnedTimstampTask.run();  
        thread1.start();
        assertNull(TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(malformedMdFileName));  
        }).then(subsequentInvocationsOnMock -> null);  
                throw new AssertionError(e);
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1",
        assertEquals(
            expectedMinPrimaryTerm,
            )
            RemoteFsTranslog translog = new RemoteFsTranslog(
                translogTransferManager
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()  
}
        });  
            // PT 2 to 7  
        updatePinnedTimstampTask.run();  
    }  
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(  
        );  
                    pinnedTimestamps.forEach(ts -> pinnedTimestampsMap.put(randomInt(1000) + "__" + ts, new PlainBlobMetadata("x", 100)));
        String md4Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 600000);
        );
        assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());  
    }
                        );  
                    fail();
            "metadata",  
                new Translog.Index(String.valueOf(op), count, primaryTerm.get(), Integer.toString(count).getBytes(StandardCharsets.UTF_8))
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
        pinnedGenerations.add(new Tuple<>(12L, 56L));
            channelFactory,
        assertBusy(() -> {
        );
    @Override  
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata(randomAlphaOfLength(10), FsRepository.TYPE, settings);
        Long minPrimaryTerm = 2L;  
        String malformedMdFileName = "metadata__9223372036438563903__9223372036854774799__9223370311919910393__node1__xyz__3__1";
        int numDocs = randomIntBetween(16, 20);
import java.util.concurrent.CountDownLatch;
        assertBusy(() -> {  
                () -> Boolean.TRUE,
        // This means there are no new invocations of deletePrimaryTermAsync  
    public void testSimpleOperationsUpload() throws Exception {
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        String nodeIdWithSeparator =
                logger  
                6,
        translog.setMinSeqNoToKeep(3);  
            translog,  
        AtomicLong minPrimaryTermInRemote = new AtomicLong(Long.MAX_VALUE);
        // 1. During ongoing uploads, the available permits are 0.  
        );  
        Set<Long> generations = ((RemoteFsTimestampAwareTranslog) translog).getGenerationsToBeDeleted(
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
    public void testGetMinMaxTranslogGenerationFromFilename() throws Exception {  
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
            .put(Node.NODE_ATTRIBUTES.getKey() + RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote-repo")
            "metadata__9223372036438563903__9223372036854775701__" + md4Timestamp + "__31__9223372036854775701__1"  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));  
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                            getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))  
        // Node id containing separator  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));  
            // Fetch pinned timestamps so that it won't be stale
        verify(translogTransferManager, times(0)).deletePrimaryTermsAsync(anyLong());
        assertEquals(2, translog.readers.size());  
        String nodeIdWithSeparator =
        metadataFiles.add("metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__9223372036854775106__1");  
        String oldFormatMdFilename = "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1";  
    ) throws IOException {  
    public void testGetMinMaxTranslogGenerationFromMetadataFile() throws IOException {
        assertEquals(2, minPrimaryTermInRemote.get());  
            // This is just to make sure that each metadata is at least 1ms apart
        assertBusy(() -> assertEquals(2, translog.allUploaded().size()));
        when(translogTransferManager.readMetadata("metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__1"))
        CountDownLatch latch = new CountDownLatch(1);
            assertEquals(7, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        translog.remoteGenerationDeletionPermits.acquire(REMOTE_DELETION_PERMITS);  
            }
                translogTransferManager
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            assertEquals(
        );
        when(blobContainer.listBlobs()).thenReturn(new HashMap<>());
 * compatible open source license.
        translog.trimUnreferencedReaders();
        assertEquals(3, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        assertEquals(3, translog.readers.size());
            .thenReturn(md2);  
            "metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1"
        assertEquals(
        // Malformed md filename
        when(md1.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "4", "23", "5", "34", "5"));
            assertEquals(
        );  
        );
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED;
        // Fetch pinned timestamps so that it won't be stale
        when(translogTransferManager.readMetadata("metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1"))
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 1 }));
            new Tuple<>(10L, 10L),
        updatePinnedTimstampTask.run();  
        List<String> metadataFilesToBeDeleted = List.of(
        verify(translogTransferManager, times(0)).deletePrimaryTermsAsync(anyLong());
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
    public void testGetMinPrimaryTermInRemoteNotFetched() throws IOException {
            new LatchedActionListener<>(new ActionListener<List<BlobMetadata>>() {  
        remoteStorePinnedTimestampServiceSpy.start();  
                logger  
            threadPool,  
        );  
        // For older md filenames, it needs to read the content  
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__1",
        assertTrue(generations.containsAll(md3Generations));  
        Long expectedMinPrimaryTerm = Long.MAX_VALUE;
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
        }));
        List<String> metadataFiles = List.of(
        when(blobContainer.listBlobs()).thenReturn(Map.of(randomInt(100) + "__" + pinnedTimestamp, new PlainBlobMetadata("xyz", 100)));
                logger  
        );  
    }
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of(1L, 2L, 3L, 4L));
        assertEquals(1, translog.readers.size());
        assertBusy(() -> {  
        BlobStore blobStore = mock(BlobStore.class);
    }  
    public void testTrimUnreferencedReadersStalePinnedTimestamps() throws Exception {
        assertEquals(2, translog.allUploaded().size());
        assertEquals(1, translog.readers.size());
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of());  
        );
            primaryMode::get,
    public void testGetMinMaxPrimaryTermFromFilename() throws Exception {
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { 1 }));
            "metadata",
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
            // PT 2 to 6  
        List<String> metadataFiles = new ArrayList<>(  
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            RemoteFsTimestampAwareTranslog.getMinPrimaryTermInRemote(new AtomicLong(Long.MAX_VALUE), translogTransferManager, logger)  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
            assertEquals(6, translog.allUploaded().size());
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
        );
            "metadata__9223372036854775806__9223372036854775770__9223370311919910398__31__9223372036854775790__1__1",  
        // First reader is created at the init of translog
            // PT 4 to 9
            );  
import org.opensearch.common.settings.Settings;
            );
        when(md2.getMinTranslogGeneration()).thenReturn(4L);  
            }, latch)  
            new Tuple<>(4L, 7L),
        );
                translogTransferManager,
        assertEquals(minGen, minMaxGen.v1());
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                deletionPolicy,
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        List<String> metadataFiles = List.of(  
        ((RemoteFsTimestampAwareTranslog) translog).trimUnreferencedReaders(true, false);
        Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslogTests.class);  
        // Fetch pinned timestamps so that it won't be stale
            // MaxGen 7
        );
import java.io.IOException;
                "metadata__9223372036854775800__9223372036854775800__9223370311919910398__31__9223372036854775803__4__1",  
                "metadata__9223372036438563903__9223372036854775803__9223370311919910413__31__9223372036854775806__5__1",
        updatePinnedTimstampTask.run();
            new HashMap<>(),  
        }, 30, TimeUnit.SECONDS);  
        updatePinnedTimstampTask.run();
    public void testGetMetadataFilesToBeDeletedExclusionBasedOnGenerationDeleteIndex() throws IOException {
        // Fetch generations directly from the filename
                6,
    }
/*  
            "metadata__9223372036854775806__9223372036854775803__9223370311919910398__31__9223372036854775806__1__1",
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of(12L, 23L, 34L, 4L, 89L));
        }, 30, TimeUnit.SECONDS);
    }
            ops,
        // Metadata file corresponding to latest pinned timestamp fetch is always considered pinned
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
        assertBusy(() -> {
                        String metadataFilename = blobMetadata.name();
        // 2. During an upload, if drainSync is called, it will wait for it to acquire and available permits are 0.
        assertFalse(translog.isGenerationPinned(141, pinnedGenerations));
        // Older md files with empty GenerationToPrimaryTermMap  
            translog.trimUnreferencedReaders();  
        assertEquals(  
            );
                "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1",
            staticLogger
        );
            .thenReturn(md1);
            translogTransferManager,  
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));  
        );
                @Override  
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1",
            logger
            "metadata__9223372036854775806__9223372036854775800__9223370311919910398__31__9223372036854775803__1__1",
                        updatePinnedTimstampTask.run();
            assertEquals(7, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());  
                            // We check for number of pinned timestamp or +1 due to latest metadata.
            .thenReturn(md1);
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        });
                12,
        translog.setMinSeqNoToKeep(3);
        when(translogTransferManager.readMetadata("metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1"))  
        updatePinnedTimstampTask.run();  
        assertEquals(2, metadataFilesToBeDeleted.size());
        List<String> metadataFiles = List.of(
        String md1Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 200000);
        RepositoriesService repositoriesService = mock(RepositoriesService.class);  
                }  
        // First reader is created at the init of translog
            // PT 2 to 6  
        // Number of calls to readMetadata will be able to verify this.
            isServerSideEncryptionEnabled
            // 27 to 42
        Releasable releasable = translog.drainSync();
            "metadata__9223372036854775806__9223372036854775800__9223370311919910398__31__9223372036854775803__1__1",
    }
public class RemoteFsTimestampAwareTranslogTests extends RemoteFsTranslogTests {
            new Tuple<>(1L, 1008L),
                translogTransferManager
        );
    public void testGetMetadataFilesToBeDeletedExclusionBasedOnPinningOnly() throws IOException {
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
    }
    }
            );
    public void testTrimUnreferencedReadersFailAlwaysRepo() throws Exception {
        int translogOperations = randomIntBetween(1, 20);
                        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        assertEquals(
            .thenReturn(md2);
        assertEquals(mdFiles, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)));  
            new Tuple<>(4L, 7L),
            );  
        // 3. After drainSync, if trimUnreferencedReaders is attempted, we do not delete from remote store.
        when(md2.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "2", "23", "2", "34", "3"));  
import static org.mockito.Mockito.mock;
                false  
import org.opensearch.repositories.fs.FsRepository;  
        updatePinnedTimstampTask.run();
            // Fetch pinned timestamps so that it won't be stale
        assertEquals(2, translog.allUploaded().size());  
        );
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            minPrimaryTermInRemote,
    }  
        assertEquals(Long.MAX_VALUE - 9223372036854774799L, TranslogTransferMetadata.getMaxGenerationFromFileName(malformedMdFileName));
            "metadata__9223372036854775806__9223372036854775800__9223370311919910398__31__9223372036854775803__1__1",
import java.util.Set;  
        );
        assertBusy(() -> {
        translog.sync();  
    }
        TranslogConfig config = getConfig(1);  
            assertEquals(  
                        translog.trimUnreferencedReaders();  
            translog.setMinSeqNoToKeep(2);
                new HashMap<>(),
        );
        assertBusy(() -> { assertEquals(3, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()); });
        String md3Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 600000);
            );
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));  
        generations.removeAll(md2Generations);  
        assertEquals(
            );
                Map.of("metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1", new Tuple<>(4L, 7L)),
        pinnedGenerations.add(new Tuple<>(12L, 120L));
        verify(translogTransferManager).deletePrimaryTermsAsync(2L);
        assertBusy(() -> {
            new Tuple<>(1L, 4L),  
        List<String> metadataFilesToBeDeleted = RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(  
            metadataFiles,
        BlobStoreRepository blobStoreRepository = mock(BlobStoreRepository.class);
            // 17 to 37
        md1 = mock(TranslogTransferMetadata.class);
        });
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()  
        assertEquals(1, translog.readers.size());  
        assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());  
        translog.trimUnreferencedReaders();  
            );  
        assertFalse(translog.isGenerationPinned(5000, pinnedGenerations));  
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
        }  
        Set<Long> generations = ((RemoteFsTimestampAwareTranslog) translog).getGenerationsToBeDeleted(
                        assertEquals(minGen, minMaxGen.v1());
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));  
            assertEquals(
        assertEquals(3, translog.readers.size());
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        );
            new HashMap<>(),
                        Set<String> dataFilesAfterTrim = blobStoreTransferService.listAll(
        Long maxGen = Long.MAX_VALUE - 9223372036854774799L;  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = new RemoteStorePinnedTimestampService(
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);  
                        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));  
            translog.getMinMaxTranslogGenerationFromMetadataFile(  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));  
        when(blobContainer.listBlobs()).thenReturn(Map.of());
        TranslogTransferMetadata md2 = mock(TranslogTransferMetadata.class);
import org.apache.logging.log4j.LogManager;
            } else {
        final Set<Long> persistedSeqNos = new HashSet<>();
                channelFactory,
        );
        List<String> metadataFiles = List.of(
            "metadata__9223372036438563903__9223372036854775600__" + md2Timestamp + "__31__9223372036854775803__1",
import java.util.stream.LongStream;
                public void onFailure(Exception e) {
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));
        RemoteFsTimestampAwareTranslog translog = (RemoteFsTimestampAwareTranslog) this.translog;
            metadataFiles,  
        assertEquals(0, translog.allUploaded().size());
            assertEquals(
        Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslogTests.class);  
            translogUUID,  
        assertEquals(  
        List<String> metadataFilesNotToBeDeleted = List.of(  
        assertEquals(  
        when(translogTransferManager.readMetadata("metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1"))
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        ArrayList<Translog.Operation> ops = new ArrayList<>();
            )
            "metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1"  
    protected RemoteFsTranslog createTranslogInstance(
        );
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));  
                "metadata__9223372036438563903__9223372036854775800__" + md1Timestamp + "__31__9223372036854775106__1",
        TranslogTransferMetadata md1 = mock(TranslogTransferMetadata.class);
                @Override  
            getTranslogDirectory().add(METADATA_DIR),  
        when(blobContainer.listBlobs()).thenReturn(Map.of(randomInt(100) + "__" + pinnedTimestamp, new PlainBlobMetadata("xyz", 100)));
        Set<Long> generations = ((RemoteFsTimestampAwareTranslog) translog).getGenerationsToBeDeleted(
        String md3Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis + 30000);
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("8", 8, primaryTerm.get(), new byte[] { 1 }));  
        }, 30, TimeUnit.SECONDS);
            translogTransferManager,
            getTranslogDirectory().add(METADATA_DIR),
        // Number of calls to readMetadata will be able to verify this.  
import org.opensearch.action.LatchedActionListener;
        blobStoreTransferService.listAllInSortedOrder(
import java.util.function.Supplier;
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            // PT 2 to 6
    public void testGetMetadataFilesToBeDeletedExclusionBasedOnAgeAndPinning() throws IOException {  
            translog.trimUnreferencedReaders();
                public void onFailure(Exception e) {
    public void testGetMetadataFilesToBeDeletedExclusionDueToRefreshTimestamp() {
            new HashMap<>(),
        });
            .thenReturn(md1);
                translogTransferManager
        maxPrimaryTerm = 7L;
import java.util.Objects;
                16,  
            "metadata__9223372036438563903__9223372036854775800__" + md3Timestamp + "__31__9223372036854775803__1",
    }
        when(md1.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "1", "23", "1", "34", "2"));  
        generations.removeAll(md3Generations);
        translog.trimUnreferencedReaders();
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of(2L, 3L, 4L));
        translog.setMinSeqNoToKeep(0);
            // 17 to 37
            if (Objects.equals(o1.v1(), o2.v1()) == false) {  
    public void testDeleteStaleRemotePrimaryTermsPrimaryTermInRemoteIsBigger() throws IOException {  
    @Override
            )
            minPrimaryTermInRemote,
                }
        assertEquals(Long.MAX_VALUE - 9223372036854774799L, TranslogTransferMetadata.getMaxGenerationFromFileName(oldFormatMdFilename));
            Long.MAX_VALUE
            // PT 2 to 6
            // Trims from remote now  
    BlobContainer blobContainer;
        TranslogTransferMetadata md1 = mock(TranslogTransferMetadata.class);
            deletionPolicy,
 */  
        assertEquals(metadataFiles.get(3), metadataFilesToBeDeleted.get(1));  
            "metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__9223372036438563958__4__1",  
            )
        ArrayList<Translog.Operation> ops = new ArrayList<>();
            )
            metadataFilesNotToBeDeleted,
        );
                translogTransferManager
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        metadataFiles.add("metadata__9223372036438563903__9223372036854775701__9223370311919910403__31__9223372036854775701__1");
import org.opensearch.repositories.RepositoriesService;  
    Runnable updatePinnedTimstampTask;
        List<String> metadataFilesToBeDeleted = List.of(
            ops,
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        translog.setMinSeqNoToKeep(3);
        );  
            "metadata__9223372036438563903__9223372036854775795__" + md2Timestamp + "__31__9223372036854775803__1",
        when(translogTransferManager.readMetadata("metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1"))  
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
            .thenReturn(md1);  
        );  
        translog.setMinSeqNoToKeep(3);
                        when(blobContainer.listBlobs()).thenReturn(pinnedTimestampsMap);  
        assertTrue(translog.isGenerationPinned(1, pinnedGenerations));  
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1";
            assertEquals(1, translog.readers.size());
            assertEquals(5, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        updatePinnedTimstampTask.run();  
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));  
            translog.add(  
        assertEquals(2, translog.readers.size());
                "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__9223372036854775106__1__1",
        generations.removeAll(md2Generations);  
        when(translogTransferManager.listPrimaryTermsInRemote()).thenThrow(new IOException());
    @Override
        pinnedGenerations.add(new Tuple<>(142L, 180L));  
            primaryTerm::get,  
            assertEquals(6, translog.allUploaded().size());
import org.opensearch.index.translog.transfer.TranslogUploadFailedException;  
        remoteStorePinnedTimestampServiceSpy = Mockito.spy(remoteStorePinnedTimestampService);
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(
            new HashMap<>(),
package org.opensearch.index.translog;
        when(threadPool.schedule(any(), any(), any())).then(invocationOnMock -> {  
        });
        pinnedGenerations.add(new Tuple<>(142L, 170L));  
        );
            return null;
                    fail();
        when(translogTransferManager.readMetadata("metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__1"))  
            "metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__1"  
            RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(metadataFiles, new HashMap<>(), Long.MAX_VALUE, false, logger)
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                new HashMap<>(),
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 3, primaryTerm.get(), new byte[] { 1 }));
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                        if (dataFilesAfterTrim.equals(dataFilesBeforeTrim) == false) {
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(  
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        Set<Long> md2Generations = LongStream.rangeClosed(17, 25).boxed().collect(Collectors.toSet());
            metadataFilesNotToBeDeleted,
        assertTrue(translog.isGenerationPinned(121, pinnedGenerations));
    }
        assertEquals(4, translog.allUploaded().size());  
            translogTransferManager,
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of(1L, 2L, 3L, 4L));
        translog.trimUnreferencedReaders();
        verify(translogTransferManager).listPrimaryTermsInRemote();
        translog.trimUnreferencedReaders();
        translog.trimUnreferencedReaders();
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
import java.util.concurrent.TimeUnit;  
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            );
            );
            translog.getMinMaxTranslogGenerationFromMetadataFile(  
            staticLogger  
        blobContainer = mock(BlobContainer.class);
        Set<Long> md3Generations = LongStream.rangeClosed(31, 34).boxed().collect(Collectors.toSet());
        assertEquals(1, translog.readers.size());  
    }
    @Override  
        // Test deletion of metadata files
        );
                fail("io exception expected");
            assertEquals(3, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
import static org.opensearch.index.translog.RemoteFsTranslog.REMOTE_DELETION_PERMITS;
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
        generations.removeAll(md1Generations);
        when(md2.getGeneration()).thenReturn(7L);
        pinnedGenerations.add(new Tuple<>(1L, 1L));
            // Fetch pinned timestamps so that it won't be stale
            new Tuple<>(4L, 7L),
                6,
        TranslogDeletionPolicy deletionPolicy,
            // MaxGen 10
        assertEquals(2, metadataFilesToBeDeleted.size());  
                () -> SequenceNumbers.NO_OPS_PERFORMED,
            )
            )  
        );
            "metadata__9223372036438563903__9223372036854774500__" + md1Timestamp + "__31__9223372036854775701__1",  
        translog.setMinSeqNoToKeep(2);
        assertBusy(() -> {
            () -> globalCheckpoint.get(),
        assertEquals(metadataFiles.get(2), metadataFilesToBeDeleted.get(0));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
            new HashMap<>(),  
                "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__9223372036854775803__2__1",
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
            new HashMap<>(),
                new HashMap<>(),
 * this file be licensed under the Apache-2.0 license or a
            staticLogger
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("7", 7, primaryTerm.get(), new byte[] { 1 }));
            false,
import org.opensearch.common.blobstore.BlobPath;  
            updatePinnedTimstampTask.run();  
        long currentTimeInMillis = System.currentTimeMillis();
    }  
            assertEquals(2, translog.allUploaded().size());  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node__1__9223372036438563958__2__1";
        TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(config.getIndexSettings());
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        String oldFormatMdFilename = "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1";
            translog,
            // Trims from local
                }  
                        // If non pinned generations are within, minRemoteGenReferenced - 1 - indexSettings().getRemoteTranslogExtraKeep()
            ops,  
            Settings.builder().put(CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true).build(),
        );
            )  
        when(md1.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "4", "23", "5", "34", "5"));
            expectedMinPrimaryTerm,  
        // Exception while reading this file
            "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1"  
        assertFalse(translog.isGenerationPinned(0, pinnedGenerations));
        assertEquals(
                translogTransferManager,  
        assertBusy(() -> assertEquals(0, latch.getCount()));  
    public void testIndexDeletionWithNoPinnedTimestampNoRecentMdFiles() throws Exception {
    }
        try (  
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
            );
        String translogUUID,  
            translogTransferManager,  
import static org.mockito.Mockito.times;  
import java.util.TreeSet;
    public void testDeleteStaleRemotePrimaryTermsNoPrimaryTermInRemote() throws IOException {
        );
                        Tuple<Long, Long> minMaxGen = TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(blobMetadata.name());  
    public void testGetGenerationsToBeDeletedWithGenerationInRemote() throws IOException {
            new Tuple<>(701L, 1008L),
        assertEquals(Long.MAX_VALUE - 9223372036854774799L, TranslogTransferMetadata.getMaxGenerationFromFileName(nodeIdWithSeparator));
            new Tuple<>(-1L, 2L),  
                translogTransferManager,  
            new Tuple<>(701L, 1008L),
            new HashMap<>(),
        assertEquals(mdFiles, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)));
        when(translogTransferManager.readMetadata("metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__1"))
                16,  
            translog.trimUnreferencedReaders();  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
    }
        translog.trimUnreferencedReaders();
        for (int i = 0; i < numDocs; i++) {  
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(
            )  
                new HashMap<>(),
import static org.mockito.ArgumentMatchers.anyLong;
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
                return o1.v2().compareTo(o2.v2());  
            staticLogger
        final ClusterService clusterService = BlobStoreTestUtil.mockClusterService(repositoryMetadata);  
                        fail();
            new HashMap<>(),
            assertEquals(6, translog.allUploaded().size());
                DefaultRemoteStoreSettings.INSTANCE,  
                            getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))
        translog.trimUnreferencedReaders();
            // PT 4 to 9
        assertEquals(metadataFiles.get(2), metadataFilesToBeDeleted.get(0));
            "metadata__9223372036854775806__9223372036854775765__9223370311919910403__31__9223372036854775780__1__1"
        updatePinnedTimstampTask.run();
    public void testTrimUnreferencedReadersNoPermits() throws Exception {
            "metadata__9223372036438563903__9223372036854774500__" + md1Timestamp + "__31__9223372036854775106__1",  
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
        translog.trimUnreferencedReaders();
 *
        updatePinnedTimstampTask.run();
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        TranslogConfig translogConfig,
                threadPool,  
        String md2Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 300000);
        assertEquals(0, translog.availablePermits());
            threadPool,
            false,
        verify(translogTransferManager, times(1)).readMetadata(  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("8", 8, primaryTerm.get(), new byte[] { 1 }));
    }
            updatePinnedTimstampTask.run();
        String md4Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 800000);  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));
        assertBusy(() -> assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
        String md2Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 300000);
        verify(translogTransferManager).deletePrimaryTermsAsync(2L);
        });
    }  
            Integer.MAX_VALUE,
                    for (BlobMetadata blobMetadata : blobMetadataList) {
import java.util.List;  
        Set<Long> md1Generations = LongStream.rangeClosed(4, 7).boxed().collect(Collectors.toSet());  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
        // Older md files with empty GenerationToPrimaryTermMap  
            new LatchedActionListener<>(new ActionListener<>() {
            assertEquals(
        for (int op = 0; op < translogOperations; op++) {
            metadataFilesToBeDeleted,
        // Fetch generations directly from the filename  
            new HashMap<>(),
            }, latch)
        assertEquals(1, metadataFilesToBeDeleted.size());
        metadataFilesToBeDeleted.remove(  
    @Override
            // PT 2 to 7
    public void testExtraGenToKeep() throws Exception {  
                "metadata__9223372036438563903__9223372036854775701__9223370311919910403__31__9223372036854775701__3__1",  
            new Translog.Index(String.valueOf(numDocs + 1), numDocs + 1, primaryTerm.get(), new byte[] { 1 })
            // PT 4 to 9
        RemoteFsTimestampAwareTranslog translog = (RemoteFsTimestampAwareTranslog) this.translog;  
        Set<Long> md1Generations = LongStream.rangeClosed(5, 7).boxed().collect(Collectors.toSet());  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("7", 7, primaryTerm.get(), new byte[] { 1 }));
        assertBusy(() -> {  
        );
            metadataFiles,
        assertEquals(metadataFiles.get(0), metadataFilesToBeDeleted.get(1));
            10L,
                assertTrue("at least one operation pending", translog.syncNeeded());
            logger
                        );
        );  
                10,
        verify(translogTransferManager, times(1)).readMetadata(  
                            long timestamp = RemoteStoreUtils.invertLong(metadataFilename.split(METADATA_SEPARATOR)[3]);
        Set<Long> md1Generations = LongStream.rangeClosed(5, 7).boxed().collect(Collectors.toSet());  
            );  
    }
        translog.trimUnreferencedReaders();
            .thenReturn(md2);
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        addToTranslogAndListAndUpload(
        for (int i = 0; i < numDocs; i++) {
            // PT 2 to 7  
            assertEquals(
                    updateTask.run();
        translog.trimUnreferencedReaders();
            assertEquals(  
        assertTrue(generations.containsAll(md2Generations));
        );
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
            )  
        updatePinnedTimstampTask.run();  
            config.getTranslogPath(),
                translogTransferManager,
            metadataFiles,
            Thread.sleep(1);  
            "metadata__9223372036438563903__9223372036854775797__" + md4Timestamp + "__31__9223372036854775701__1"
        assertEquals(2, translog.readers.size());
            RemoteFsTimestampAwareTranslog.getMinPrimaryTermInRemote(new AtomicLong(Long.MAX_VALUE), translogTransferManager, null)
            translog.setMinSeqNoToKeep(i);  
            translogTransferManager,
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("6", 6, primaryTerm.get(), new byte[] { 1 }));  
    public void testGetMinPrimaryTermInRemoteNotFetchedException() throws IOException {  
        assertTrue(translog.isGenerationPinned(12, pinnedGenerations));
            assertEquals(
            SequenceNumbers.NO_OPS_PERFORMED,
        minPrimaryTerm = 2L;
        );
import org.opensearch.index.seqno.SequenceNumbers;  
        Set<Long> md3Generations = LongStream.rangeClosed(31, 41).boxed().collect(Collectors.toSet());
        String md3Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 300000);  
        // Fetch pinned timestamps so that it won't be stale  
            new HashMap<>(),  
            "metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__1",  
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 }));
        );  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));  
        assertEquals(maxGen, minMaxGen.v2());
        ((RemoteFsTimestampAwareTranslog) translog).trimUnreferencedReaders(true, false);  
        ArrayList<Translog.Operation> ops = new ArrayList<>();  
        );
            "metadata__9223372036854775806__9223372036854775770__9223370311919910398__31__9223372036854775790__1__1",  
    }  
        assertTrue(generations.isEmpty());
        assertEquals(
import org.opensearch.common.blobstore.BlobStore;
        assertTrue(generations.containsAll(md2Generations));
        );  
                        if (randomBoolean()) {  
import org.junit.Before;
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__1",
import static org.mockito.Mockito.verify;
                assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
            assertEquals(  
            translogTransferManager,
                            for (long i = minMaXGen.v1(); i <= minMaXGen.v2(); i++) {  
            "metadata__9223372036438563903__9223372036854775800__" + md1Timestamp + "__31__9223372036854775106__1",
        Long expectedMinPrimaryTerm = 12L;  
        );
import org.opensearch.cluster.service.ClusterService;  
        assertEquals(1, translog.readers.size());  
            "metadata__9223372036854775806__9223372036854775765__9223370311919910403__31__9223372036854775780__1__1"
@LuceneTestCase.SuppressFileSystems("ExtrasFS")
            // 27 to 42
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        when(md3.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "2", "23", "2", "34", "2"));  
                addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(1), 1, primaryTerm.get(), new byte[] { 1 }));
    }
        updatePinnedTimstampTask.run();  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("5", 5, primaryTerm.get(), new byte[] { 1 }));  
                public void onResponse(List<BlobMetadata> blobMetadataList) {
        List<String> metadataFiles = List.of(  
        String md1Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 190000);
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
        Long maxPrimaryTerm = 7L;
        // Fetch pinned timestamps so that it won't be stale
        // This test checks following scenarios -
    public void testGetGenerationsToBeDeleted() throws IOException {
            translog.getMinMaxTranslogGenerationFromMetadataFile(  
    }  
        ChannelFactory channelFactory = getChannelFactory();
        Thread thread1 = new Thread(() -> {
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));  
        assertEquals(  
            translogTransferManager,  
        String md1Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 200000);  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
        fail.failNever();
            updatePinnedTimstampTask.run();
import org.opensearch.index.remote.RemoteStoreUtils;
        Tuple<Long, Long> minMaxPrimaryterm = TranslogTransferMetadata.getMinMaxPrimaryTermFromFilename(newFormatMetadataFile);
        blobStoreTransferService.listAllInSortedOrder(
        assertEquals(  
        });  
        assertEquals(maxPrimaryTerm, minMaxPrimaryterm.v2());  
        );
            // 4 to 7  
    public void testDrainSync() throws Exception {
import org.opensearch.common.lease.Releasables;
        addToTranslogAndListAndUpload(
        Tuple<Long, Long> minMaxGen = TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(nodeIdWithSeparator);  
        assertTrue(generations.containsAll(md1Generations));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("6", 6, primaryTerm.get(), new byte[] { 1 }));
            // 27 to 42
            } catch (IOException e) {
        assertTrue(translog.isGenerationPinned(156, pinnedGenerations));  
            // PT 4 to 9
        assertEquals(4, translog.allUploaded().size());
            .thenReturn(md1);
    @Before
        AtomicLong minPrimaryTermInRemote = new AtomicLong(Long.MAX_VALUE);
    public void testGetMetadataFilesToBeDeletedExclusionBasedOnAgeOnly() {  
            assertEquals(  
                12,  
    }
            "metadata__9223372036854775806__9223372036854775765__9223370311919910403__31__9223372036854775780__1__1"
            Long.MAX_VALUE
        latch.await();
            metadataFiles,  
            staticLogger
                12,  
            "metadata__9223372036854775806__9223372036854775707__9223370311919910403__31__9223372036854775765__1__1"  
            new Tuple<>(1L, 2L),
            TranslogOperationHelper.DEFAULT,
                        for (String md : pinnedTimestampMatchingMetadataFiles) {  
        assertBusy(() -> {  
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
            assertEquals(9, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
                10,
        List<String> metadataFiles = List.of(  
        when(md1.getGenerationToPrimaryTermMapper()).thenReturn(Map.of());
                @Override
        generations.removeAll(md2Generations);  
        assertEquals(maxPrimaryTerm, minMaxPrimaryterm.v2());
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()  
        when(translogTransferManager.readMetadata("metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__1"))
                            assertTrue(metadataFilesAfterTrim.contains(md));
        minMaxPrimaryterm = TranslogTransferMetadata.getMinMaxPrimaryTermFromFilename(nodeIdWithSeparator);  
            "metadata__9223372036854775806__9223372036854775803__9223370311919910398__31__9223372036854775806__1__1",
                                assertTrue(dataFilesAfterTrim.contains(Translog.getFilename(i)));
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
        generations.removeAll(md1Generations);
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;  
            staticLogger  
                        Set<String> dataFilesBeforeTrim = blobStoreTransferService.listAll(
                            Tuple<Long, Long> minMaXGen = TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(md);
                "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1",  
        assertEquals(1, translog.readers.size());
        String md3Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 600000);
        assertEquals(minPrimaryTerm, minMaxPrimaryterm.v1());
            // 4 to 7  
                "metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1",  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(3), 3, primaryTerm.get(), new byte[] { 1 }));
import org.apache.logging.log4j.Logger;
            )
        );
    public void testDeleteStaleRemotePrimaryTermsOldFormatException() throws IOException {  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));  
        List<String> metadataFiles = new ArrayList<>();
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                logger  
            // MaxGen 9
        Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslogTests.class);
            assertEquals(
                "metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1",
                "metadata__9223372036438563903__9223372036854775790__" + md3Timestamp + "__31__9223372036854775701__1"
            assertEquals(
    public void testIndexDeletionWithNoPinnedTimestampButRecentFiles() throws Exception {
            assertEquals(  
import java.util.concurrent.atomic.AtomicLong;
        when(md3.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "2", "23", "2", "34", "2"));
        updatePinnedTimstampTask.run();  
    public void testGetMinPrimaryTermInRemoteAlreadyFetched() {
            // 42 to 100
        CountDownLatch latch = new CountDownLatch(1);
        assertEquals(3, translog.readers.size());  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));
        assertEquals(  
        Long expectedMinPrimaryTerm = Long.MAX_VALUE;  
                // MaxGen 7
        String md1Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 200000);  
            new Tuple<>(-1L, 2L),  
        }, 30, TimeUnit.SECONDS);
            translog.trimUnreferencedReaders();
                new HashMap<>(),
    public void testGetMinMaxPrimaryTermFromMetadataFile() throws IOException {
        Supplier<RepositoriesService> repositoriesServiceSupplier = mock(Supplier.class);
            metadataFiles,
    }  
            // expose the new checkpoint (simulating a commit), before we trim the translog
        when(blobStoreRepository.basePath()).thenReturn(new BlobPath());  
            new RemoteTranslogTransferTracker(shardId, 10),
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));
import org.opensearch.common.lease.Releasable;
            translog.setMinSeqNoToKeep(i);
            metadataFiles,  
                translogTransferManager
            )  
                            assertTrue(metadataFilesAfterTrim.size() >= pinnedTimestamps.size());  
        );
        String md2Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 200000);
        );  
            RemoteFsTimestampAwareTranslog.getMinPrimaryTermInRemote(new AtomicLong(Long.MAX_VALUE), translogTransferManager, logger)
        });
        long currentTimeInMillis = System.currentTimeMillis();
            );
            translog.getMinMaxTranslogGenerationFromMetadataFile(  
        ThreadPool threadPool = mock(ThreadPool.class);
        );
        Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslogTests.class);
        assertBusy(() -> {
        // Old format metadata file
            new Tuple<>(4L, 7L),  
            new Tuple<>(106L, 106L),
        when(md2.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "2", "23", "2", "34", "3"));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
        Settings settings = Settings.builder()  
        // First reader is created at the init of translog
            settings,
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1",
        List<String> metadataFilesNotToBeDeleted = List.of(  
            translogConfig,
                logger  
        assertEquals(3, translog.readers.size());
                12,
            new Translog.Index(String.valueOf(2), 2, primaryTerm.get(), new byte[] { 1 })  
        AtomicLong minPrimaryTermInRemote = new AtomicLong(4);
            "metadata__9223372036854775806__9223372036854775777__9223370311919910398__31__9223372036854775781__1__1",
                    Map<String, BlobMetadata> pinnedTimestampsMap = new HashMap<>();
        assertEquals(metadataFiles.get(1), metadataFilesToBeDeleted.get(0));
                    for (BlobMetadata blobMetadata : blobMetadataList) {
            "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__9223372036854775106__1"
            expectedMinPrimaryTerm,
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
        Long minGen = Long.MAX_VALUE - 9223372036438563958L;
            metadataFilesToBeDeleted,  
                translogTransferManager  
        when(translogTransferManager.readMetadata("metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1"))
    public void testSyncUpAlwaysFailure() throws IOException {
            "metadata__9223372036438563903__9223372036854774799__" + md2Timestamp + "__31__9223372036854775106__1",
        List<String> metadataFilesToBeDeleted = RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(
        );  
        assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());  
    public void testMetadataFileDeletion() throws Exception {
import org.mockito.Mockito;  
        assertTrue(generations.containsAll(md3Generations));  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));
        long currentTimeInMillis = System.currentTimeMillis();  
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("5", 4, primaryTerm.get(), new byte[] { 1 }));
import org.opensearch.common.blobstore.BlobContainer;
                    List<Long> pinnedTimestamps = new ArrayList<>();  
            minPrimaryTermInRemote,
    }
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("8", 8, primaryTerm.get(), new byte[] { 1 }));  
        Releasables.close(releasable);
        assertBusy(() -> {
            assertEquals(5, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
            new Tuple<>(4L, 7L),
        Translog.Location loc = addToTranslogAndListAndUpload(  
        boolean isServerSideEncryptionEnabled
import java.util.stream.Collectors;  
                primaryTerm::get,  
        when(md1.getGeneration()).thenReturn(1008L);  
            "metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1"
            // 26 to 30  
                        assertEquals(maxGen, minMaxGen.v2());
    }  
        String md2Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 300000);  
            // 42 to 100
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        metadataFiles.remove(metadataFiles.get(2));
            "metadata__9223372036438563903__9223372036854774799__" + md1Timestamp + "__31__9223372036854775106__1",  
        Set<Long> md2Generations = LongStream.rangeClosed(17, 25).boxed().collect(Collectors.toSet());
            metadataFiles,
        long currentTimeInMillis = System.currentTimeMillis();
            new HashMap<>(),
            metadataFiles,
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(  
        assertBusy(() -> {  
        TranslogTransferMetadata md3 = mock(TranslogTransferMetadata.class);
            logger
        ArrayList<Translog.Operation> ops = new ArrayList<>();  
            assertEquals(6, translog.allUploaded().size());
                    try {
            assertEquals(
    public void setUp() throws Exception {  
        assertNull(TranslogTransferMetadata.getMinMaxPrimaryTermFromFilename(oldFormatMdFilename));
        }, 30, TimeUnit.SECONDS);  
            metadataFilesToBeDeleted,  
        when(translogTransferManager.readMetadata("metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__1"))
                "metadata__9223372036438563903__9223372036854775795__" + md2Timestamp + "__31__9223372036854775803__1",  
        updatePinnedTimstampTask.run();  
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                new RemoteTranslogTransferTracker(shardId, 10),
import static org.mockito.ArgumentMatchers.any;  
            35
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
            )  
                            }
        TranslogTransferMetadata md1 = mock(TranslogTransferMetadata.class);
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);  
        List<String> metadataFilesToBeDeleted = List.of(
    }  
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
import java.nio.charset.StandardCharsets;
        assertTrue(generations.isEmpty());
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));  
                8,  
            new HashMap<>(),
    }  
            updatePinnedTimstampTask = () -> {
        assertEquals(
        TranslogTransferMetadata md1 = mock(TranslogTransferMetadata.class);  
            );
        // Calling it again to check if the details are getting fetched from the cache.
        );
        assertEquals(
        assertEquals(Long.MAX_VALUE, minPrimaryTermInRemote.get());  
                "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1",
                    Long minGen = 1L;  
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));  
                translogTransferManager
            logger
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));  
    }  
            translog,
        List<String> metadataFilesToBeDeleted = RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(  
                    Long maxGen = 6L;
        );
import java.util.ArrayList;  
                TranslogOperationHelper.DEFAULT,
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        when(repositoriesService.repository("remote-repo")).thenReturn(blobStoreRepository);  
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_SEPARATOR;
        translog.trimUnreferencedReaders();  
        int numDocs = randomIntBetween(6, 10);  
        assertFalse(translog.isGenerationPinned(181, pinnedGenerations));
            assertEquals(2, translog.allUploaded().size());  
            DefaultRemoteStoreSettings.INSTANCE,  
            getPersistedSeqNoConsumer(),
        );
import org.opensearch.core.action.ActionListener;  
        });
            assertEquals(6, translog.allUploaded().size());
            assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());  
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
            logger
        assertFalse(translog.isGenerationPinned(3, pinnedGenerations));
                // MaxGen 12
