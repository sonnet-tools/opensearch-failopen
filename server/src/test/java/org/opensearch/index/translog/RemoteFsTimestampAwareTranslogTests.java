            translog.trimUnreferencedReaders();
                "metadata__9223372036438563903__9223372036854775701__9223370311919910403__31__9223372036854775701__3__1",
            repository,
        metadataFiles.remove(metadataFiles.get(2));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
            // PT 2 to 6
import org.opensearch.index.translog.transfer.TranslogUploadFailedException;
            translog,
            // PT 2 to 6
                @Override
            "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__9223372036854775106__1"
    public void testGetGenerationsToBeDeletedEmptyMetadataFilesNotToBeDeleted() throws IOException {
            )
        );
            new HashMap<>(),
            "metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1"
        boolean isServerSideEncryptionEnabled
            }, latch)
            Long.MAX_VALUE
            );
        assertBusy(() -> {
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
                    updateTask.run();
 */
                "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1",
            .thenReturn(md1);
        // Case 1 - During ongoing uploads, the available permits are 0.
            new LatchedActionListener<>(new ActionListener<List<BlobMetadata>>() {
            "metadata__9223372036854775806__9223372036854775800__9223370311919910398__31__9223372036854775803__1__1",
            metadataFilesNotToBeDeleted,
import org.opensearch.common.lease.Releasables;
        metadataFilesToBeDeleted.remove(
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("5", 5, primaryTerm.get(), new byte[] { 1 }));
        blobStoreTransferService.listAllInSortedOrder(
        // Fetch pinned timestamps so that it won't be stale
        // Fetch pinned timestamps so that it won't be stale
        String md1Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 200000);
            assertEquals(
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("8", 8, primaryTerm.get(), new byte[] { 1 }));
            10L,
            "metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__1",
    public void testDeleteStaleRemotePrimaryTermsPrimaryTermInRemoteIsBigger() throws IOException {
                            }
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
            settings,
                        assertEquals(maxGen, minMaxGen.v2());
            metadataFilesToBeDeleted,
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(
        assertEquals(
        );
                12,
                6,
            // 4 to 7
                translogTransferManager
        long pinnedTimestamp = RemoteStoreUtils.invertLong(md3Timestamp) + 10000;
    public void testMetadataFileDeletion() throws Exception {
            );
                () -> Boolean.TRUE,
import java.util.Map;
        assertEquals(
            // 17 to 37
        assertBusy(() -> assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
        });
                logger
    }
        // 2. During an upload, if drainSync is called, it will wait for it to acquire and available permits are 0.
            new Tuple<>(1L, 4L),
        // Malformed md filename
                        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        ArrayList<Translog.Operation> ops = new ArrayList<>();
import java.util.Objects;
        pinnedGenerations.add(new Tuple<>(12L, 78L));
        Long expectedMinPrimaryTerm = Long.MAX_VALUE;
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
        generations.removeAll(md2Generations);
        assertFalse(translog.isGenerationPinned(3, pinnedGenerations));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));
            .thenReturn(md1);
            minPrimaryTermInRemote,
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        );
            metadataFiles,
                translogTransferManager
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));
                        }
            // PT 4 to 9
                        // If non pinned generations are within, minRemoteGenReferenced - 1 - indexSettings().getRemoteTranslogExtraKeep()
            .thenReturn(md2);
            // PT 2 to 6
        assertEquals(metadataFiles.get(2), metadataFilesToBeDeleted.get(0));
                translogTransferManager
            assertEquals(9, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
                translogTransferManager
                translogTransferManager
        String md1Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 190000);
        metadataFiles.add("metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__9223372036854775106__1");
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            // 26 to 30
    BlobContainer blobContainer;
        String md3Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis + 30000);
                logger
        // Old format metadata file
            primaryTerm.get()
                threadPool,
        assertFalse(translog.isGenerationPinned(181, pinnedGenerations));
        updatePinnedTimstampTask.run();
        Set<Long> md2Generations = LongStream.rangeClosed(17, 25).boxed().collect(Collectors.toSet());
            config.getTranslogPath(),
        verify(translogTransferManager).listPrimaryTermsInRemote();
        String translogUUID,
            )
public class RemoteFsTimestampAwareTranslogTests extends RemoteFsTranslogTests {
    public void testGetGenerationsToBeDeletedWithGenerationInRemote() throws IOException {
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        // 3. After drainSync, if trimUnreferencedReaders is attempted, we do not delete from remote store.
            repositoriesServiceSupplier,
            assertEquals(2, translog.allUploaded().size());
            assertEquals(
        assertEquals(3, translog.readers.size());
                        // we will not delete them
            // 27 to 42
        assertEquals(3, translog.readers.size());
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            )
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));
            );
    public void testTrimUnreferencedReadersStalePinnedTimestamps() throws Exception {
        when(translogTransferManager.readMetadata("metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1"))
            staticLogger
        updatePinnedTimstampTask.run();
            assertEquals(2, translog.allUploaded().size());
                translogTransferManager
        assertEquals(1, translog.readers.size());
            assertEquals(
        TranslogTransferMetadata md2 = mock(TranslogTransferMetadata.class);
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(
            // MaxGen 7
                addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(1), 1, primaryTerm.get(), new byte[] { 1 }));
                "metadata__9223372036438563903__9223372036854775795__" + md2Timestamp + "__31__9223372036854775803__1",
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
import org.opensearch.repositories.RepositoriesService;
                            pinnedTimestamps.add(timestamp);
    }
        );
        List<String> metadataFilesToBeDeleted = List.of(
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of(12L, 23L, 34L, 4L, 89L));
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
                @Override
        assertFalse(translog.isGenerationPinned(10, pinnedGenerations));
                public void onFailure(Exception e) {
        Set<Long> generations = ((RemoteFsTimestampAwareTranslog) translog).getGenerationsToBeDeleted(
            false,
                "metadata__9223372036438563903__9223372036854775790__" + md3Timestamp + "__31__9223372036854775701__1"
            assertEquals(
@LuceneTestCase.SuppressFileSystems("ExtrasFS")
                    Long maxGen = 6L;
                logger
                    for (BlobMetadata blobMetadata : blobMetadataList) {
        translog.trimUnreferencedReaders();
        when(md3.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "2", "23", "2", "34", "2"));
        assertEquals(Long.MAX_VALUE, minPrimaryTermInRemote.get());
                    Map<String, BlobMetadata> pinnedTimestampsMap = new HashMap<>();
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 0, primaryTerm.get(), new byte[] { 1 }));
    }
        assertBusy(() -> {
    public void testGetMinMaxPrimaryTermFromFilename() throws Exception {
import static org.opensearch.indices.RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED;
        );
            "metadata__9223372036854775806__9223372036854775800__9223370311919910398__31__9223372036854775803__1__1",
            "metadata__9223372036854775806__9223372036854775800__9223370311919910398__31__9223372036854775803__1__1",
        RepositoriesService repositoriesService = mock(RepositoriesService.class);
            "metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__9223372036438563958__4__1",
        );
        Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslogTests.class);
        slowDown.setSleepSeconds(0);
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1",
        assertEquals(2, minPrimaryTermInRemote.get());
                        );
    public void testGetMetadataFilesToBeDeletedExclusionBasedOnGenerationDeleteIndex() throws IOException {
        });
            assertEquals(
            assertEquals(6, translog.allUploaded().size());
                "metadata__9223372036854775800__9223372036854775800__9223370311919910398__31__9223372036854775803__4__1",
                false
        assertBusy(() -> {
            new Tuple<>(5807L, 7917L),
            Long.MAX_VALUE,
            }
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        assertEquals(0, translog.allUploaded().size());
            "metadata__9223372036854775806__9223372036854775765__9223370311919910403__31__9223372036854775780__1__1"
import org.opensearch.common.blobstore.BlobContainer;
        });
            minPrimaryTermInRemote,
            // PT 4 to 9
        when(translogTransferManager.readMetadata("metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1"))
        Long minGen = Long.MAX_VALUE - 9223372036438563958L;
                new HashMap<>(),
            translog.add(
    RemoteStorePinnedTimestampService remoteStorePinnedTimestampServiceSpy;
            "metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1"
                logger
        assertEquals(Long.MAX_VALUE - 9223372036854774799L, TranslogTransferMetadata.getMaxGenerationFromFileName(malformedMdFileName));
import static org.mockito.Mockito.mock;
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            "metadata__9223372036854775806__9223372036854775803__9223370311919910398__31__9223372036854775806__1__1",
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        assertEquals(1, translog.readers.size());
                translogTransferManager,
                "metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1",
                public void onResponse(List<BlobMetadata> blobMetadataList) {
            metadataFiles,
        TranslogTransferMetadata md2 = mock(TranslogTransferMetadata.class);
    public void testGetMinMaxTranslogGenerationFromMetadataFile() throws IOException {
        // Fetch pinned timestamps so that it won't be stale
        Releasables.close(releasable);
        assertEquals(
        assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        when(blobContainer.listBlobs()).thenReturn(Map.of());
            .thenReturn(md2);
        List<String> metadataFilesToBeDeleted = new ArrayList<>(metadataFiles);
        assertTrue(generations.containsAll(md3Generations));
    public void testGetMinPrimaryTermInRemoteAlreadyFetched() {
            updatePinnedTimstampTask.run();
        );
        AtomicLong minPrimaryTermInRemote = new AtomicLong(Long.MAX_VALUE);
    }
        String md2Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 200000);
        assertFalse(translog.isGenerationPinned(0, pinnedGenerations));
        Thread thread1 = new Thread(() -> {
        // Exception while reading this file
        translog.trimUnreferencedReaders();
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("6", 6, primaryTerm.get(), new byte[] { 1 }));
            "metadata__9223372036854775806__9223372036854775770__9223370311919910398__31__9223372036854775790__1__1",
        List<String> metadataFiles = List.of(
            .thenReturn(md3);
        verify(translogTransferManager).readMetadata("metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1");
        AtomicLong minPrimaryTermInRemote = new AtomicLong(4);
        );
        );
        CountDownLatch latch = new CountDownLatch(1);
            10L,
        blobStoreTransferService.listAllInSortedOrder(
        verify(translogTransferManager, times(1)).deletePrimaryTermsAsync(anyLong());
    }
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        assertTrue(translog.isGenerationPinned(120, pinnedGenerations));
            isServerSideEncryptionEnabled
                        Set<String> metadataFilesAfterTrim = blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR));
        translog.setMinSeqNoToKeep(1);
        // Case 3 - After drainSync, if trimUnreferencedReaders is attempted, we do not delete from remote store.
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
import org.apache.logging.log4j.LogManager;
            );
    public void testIndexDeletionWithNoPinnedTimestampButRecentFiles() throws Exception {
        updatePinnedTimstampTask.run();
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            threadPool,
        // 4. After drainSync, if an upload is an attempted, we do not upload to remote store.
        });
import org.opensearch.common.blobstore.BlobMetadata;
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1",
        }
        translog.trimUnreferencedReaders();
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
                        Set<String> dataFilesAfterTrim = blobStoreTransferService.listAll(
        ArrayList<Translog.Operation> ops = new ArrayList<>();
                6,
            .thenReturn(md2);
        // Node id containing separator
        Set<Long> md1Generations = LongStream.rangeClosed(5, 7).boxed().collect(Collectors.toSet());
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
        assertBusy(() -> {
        translog.sync();
            new Tuple<>(2474L, 3462L),
            new Tuple<>(701L, 1008L),
        assertEquals(2, metadataFilesToBeDeleted.size());
        updatePinnedTimstampTask.run();
                @Override
import org.opensearch.indices.RemoteStoreSettings;
            translogTransferManager,
        latch.await();
        updatePinnedTimstampTask.run();
import org.apache.lucene.tests.util.LuceneTestCase;
        assertEquals(maxGen, minMaxGen.v2());
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = new RemoteStorePinnedTimestampService(
        // Fetch pinned timestamps so that it won't be stale
                "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1",
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
        );
        );
        TranslogTransferMetadata md1 = mock(TranslogTransferMetadata.class);
        );
        updatePinnedTimstampTask.run();
                            for (long i = minMaXGen.v1(); i <= minMaXGen.v2(); i++) {
        );
        Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslogTests.class);
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        List<String> metadataFilesNotToBeDeleted = List.of(
                "metadata__9223372036438563903__9223372036854772345__9223370311919910429__31__9223372036854773333__6__1",
        addToTranslogAndListAndUpload(
        assertEquals(mdFiles, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)));
    public void testDeleteStaleRemotePrimaryTerms() throws IOException {
            minPrimaryTermInRemote,
            metadataFiles,
        verify(translogTransferManager, times(1)).readMetadata(
        when(md1.getGenerationToPrimaryTermMapper()).thenReturn(Map.of());
                "metadata__9223372036438563903__9223372036854775800__" + md1Timestamp + "__31__9223372036854775106__1",
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("8", 8, primaryTerm.get(), new byte[] { 1 }));
        assertEquals(minPrimaryTerm, minMaxPrimaryterm.v1());
        final Set<Long> persistedSeqNos = new HashSet<>();
import org.opensearch.node.Node;
        // Calling it again to check if the details are getting fetched from the cache.
        RemoteFsTimestampAwareTranslog translog = (RemoteFsTimestampAwareTranslog) this.translog;
        assertTrue(translog.isGenerationPinned(121, pinnedGenerations));
            "metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1"
    public void testGetMinMaxTranslogGenerationFromFilename() throws Exception {
import org.opensearch.common.lease.Releasable;
import static org.opensearch.index.translog.transfer.TranslogTransferMetadata.METADATA_SEPARATOR;
                return o1.v1().compareTo(o2.v1());
            .thenReturn(md1);
            // expose the new checkpoint (simulating a commit), before we trim the translog
    }
            primaryMode::get,
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
            "metadata__9223372036438563903__9223372036854774799__" + md2Timestamp + "__31__9223372036854775106__1",
                12,
                        );
        assertEquals(minPrimaryTerm, minMaxPrimaryterm.v1());
        assertTrue(translog.isGenerationPinned(1, pinnedGenerations));
            logger
        ArrayList<Translog.Operation> ops = new ArrayList<>();
            translogTransferManager,
            new Tuple<>(106L, 106L),
        List<String> metadataFiles = List.of(
        ArrayList<Translog.Operation> ops = new ArrayList<>();
            )
        // Fetch pinned timestamps so that it won't be stale
        assertEquals(
            new Tuple<>(4573L, 99964L),
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
        updatePinnedTimstampTask.run();
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
        for (int i = 0; i < numDocs; i++) {
                Map.of("metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1", new Tuple<>(4L, 7L)),
        assertEquals(2, translog.allUploaded().size());
    }
        // Fetch pinned timestamps so that it won't be stale
            // 42 to 100
        List<String> metadataFilesToBeDeleted = RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(
            new Tuple<>(4L, 7L),
 * SPDX-License-Identifier: Apache-2.0
        when(md1.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "4", "23", "5", "34", "5"));
        );
            metadataFiles,
            );
            assertEquals(5, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        List<String> metadataFiles = List.of(
    }
        });
        assertEquals(expectedMinPrimaryTerm, RemoteFsTimestampAwareTranslog.getMinPrimaryTermInRemote(new AtomicLong(12), null, null));
            expectedMinPrimaryTerm,
        int count = 0;
        String md3Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 600000);
    public void testSimpleOperationsUpload() throws Exception {
        );
                long currentTime = System.currentTimeMillis();
                6,
        Long expectedMinPrimaryTerm = 4L;
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        assertEquals(mdFiles, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)));
    public void testGetMetadataFilesToBeDeletedExclusionBasedOnGenerationOnly() throws IOException {
        );
        assertTrue(generations.containsAll(md1Generations));
        when(md1.getMinTranslogGeneration()).thenReturn(701L);
import java.io.IOException;
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
    public void testGetMetadataFilesToBeDeletedExclusionBasedOnAgeOnly() {
    }
            // MaxGen 9
    }
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        assertEquals(2, minPrimaryTermInRemote.get());
        generations.removeAll(md2Generations);
                "metadata__9223372036854775797__9223372036854775800__9223370311919910398__31__9223372036854775803__10__1",
import org.opensearch.common.collect.Tuple;
            // PT 2 to 7
    }
            Runnable updateTask = invocationOnMock.getArgument(0);
        translog.remoteGenerationDeletionPermits.acquire(REMOTE_DELETION_PERMITS);
        updatePinnedTimstampTask.run();
        );
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        }, 30, TimeUnit.SECONDS);
            "metadata__9223372036438563903__9223372036854775800__" + md3Timestamp + "__31__9223372036854775803__1",
import java.util.stream.Collectors;
    }
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        );
            )
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
    public void testGetMinPrimaryTermInRemoteNotFetchedException() throws IOException {
        when(translogTransferManager.readMetadata("metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__1"))
        );
        // This means there are no new invocations of deletePrimaryTermAsync
                    Long minGen = 1L;
import org.opensearch.repositories.fs.FsRepository;
            )
        translog.setMinSeqNoToKeep(3);
                16,
        });
            "metadata__9223372036438563903__9223372036854775797__" + md4Timestamp + "__31__9223372036854775701__1"
                    List<String> pinnedTimestampMatchingMetadataFiles = new ArrayList<>();
            metadataFiles,
        assertEquals(3, translog.readers.size());
        // Fetch generations directly from the filename
        // First reader is created at the init of translog
            new Tuple<>(4L, 7L),
                            Tuple<Long, Long> minMaXGen = TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(md);
import org.opensearch.common.blobstore.BlobStore;
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of());
import java.util.Set;
        String newFormatMetadataFile =
            Integer.MAX_VALUE,
        assertEquals(4, translog.allUploaded().size());
            assertEquals(6, translog.allUploaded().size());
import org.opensearch.cluster.metadata.RepositoryMetadata;
        );
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
            )
            translog.trimUnreferencedReaders();
            )
            metadataFiles,
            try {
        assertEquals(2, translog.readers.size());
            assertEquals(6, translog.allUploaded().size());
        assertBusy(() -> {
            channelFactory,
                while (RemoteStorePinnedTimestampService.getPinnedTimestamps().v1() < currentTime) {
                        if (dataFilesAfterTrim.equals(dataFilesBeforeTrim) == false) {
                    fail();
import java.util.function.Supplier;
        List<String> metadataFilesToBeDeleted = List.of(
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        );
        when(translogTransferManager.readMetadata("metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1"))
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
        assertEquals(1, translog.readers.size());
        }
            expectedMinPrimaryTerm,
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
            );
import org.opensearch.core.action.ActionListener;
        updatePinnedTimstampTask.run();
        translog.trimUnreferencedReaders();
    public void testDrainSync() throws Exception {
        assertEquals(
        when(translogTransferManager.readMetadata("metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1"))
        Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslogTests.class);
        assertEquals(1, translog.readers.size());
        });
            // Fetch pinned timestamps so that it won't be stale
                }
        assertEquals(2, translog.readers.size());
import org.junit.Before;
        TranslogConfig translogConfig,
        assertEquals(metadataFiles.get(0), metadataFilesToBeDeleted.get(1));
        List<String> metadataFiles = List.of(
import static org.mockito.ArgumentMatchers.anyLong;
        when(translogTransferManager.listPrimaryTermsInRemote()).thenThrow(new IOException());
            "metadata__9223372036854775806__9223372036854775770__9223370311919910398__31__9223372036854775790__1__1",
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
                translogTransferManager,
            getPersistedSeqNoConsumer(),
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
            assertEquals(7, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
                translogUUID,
        );
        // First reader is created at the init of translog
            "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1"
        );
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__1",
            // Trims from local
        assertEquals(2, translog.allUploaded().size());
                        if (randomBoolean()) {
            "metadata__9223372036854775806__9223372036854775803__9223370311919910398__31__9223372036854775806__1__1",
        translog.setMinSeqNoToKeep(6);
            assertEquals(
        assertBusy(() -> { assertEquals(3, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()); });
                        String metadataFilename = blobMetadata.name();
        // Number of calls to readMetadata will be able to verify this.
    }
        );
            return null;
import static org.mockito.Mockito.verify;
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(
        TreeSet<Tuple<Long, Long>> pinnedGenerations = new TreeSet<>(new TreeSet<>((o1, o2) -> {
        String oldFormatMdFilename = "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1";
        assertTrue(generations.containsAll(md2Generations));
        assertEquals(1, translog.readers.size());
            // MaxGen 12
        pinnedGenerations.add(new Tuple<>(12L, 34L));
            new Tuple<>(10L, 10L),
            .put(Node.NODE_ATTRIBUTES.getKey() + RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote-repo")
        assertBusy(() -> assertEquals(2, translog.allUploaded().size()));
            // 27 to 42
            translogConfig,
import java.util.TreeSet;
        assertEquals(
        verify(translogTransferManager).deletePrimaryTermsAsync(2L);
            assertEquals(
            );
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(
        translog.setMinSeqNoToKeep(0);
            getTranslogDirectory().add(METADATA_DIR),
        // Metadata file corresponding to latest pinned timestamp fetch is always considered pinned
        ArrayList<Translog.Operation> ops = new ArrayList<>();
                TranslogOperationHelper.DEFAULT,
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("7", 7, primaryTerm.get(), new byte[] { 1 }));
            try {
                throw new AssertionError(e);
        );
        );
        List<String> metadataFiles = List.of(
        assertTrue(generations.isEmpty());
        updatePinnedTimstampTask.run();
            assertEquals(
            // 4 to 7
            new HashMap<>(),
        pinnedGenerations.add(new Tuple<>(12L, 120L));
        assertEquals(
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));
                    } catch (Exception e) {
        assertTrue(generations.isEmpty());
            );
        translog.trimUnreferencedReaders();
package org.opensearch.index.translog;
        translog.trimUnreferencedReaders();
        assertEquals(1, translog.readers.size());
            )
        assertEquals(
        String md3Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 300000);
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        BlobStoreRepository blobStoreRepository = mock(BlobStoreRepository.class);
            assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
import static org.mockito.Mockito.times;
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { 1 }));
        when(blobStoreRepository.basePath()).thenReturn(new BlobPath());
        // Fetch generations directly from the filename
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
        when(translogTransferManager.readMetadata("metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__1"))
            new HashMap<>(),
            metadataFiles,
            "metadata__9223372036438563903__9223372036854775795__" + md2Timestamp + "__31__9223372036854775803__1",
            false,
            updatePinnedTimstampTask = () -> {
        verify(translogTransferManager, times(1)).readMetadata(
                translogTransferManager
                logger
        verify(translogTransferManager, times(0)).deletePrimaryTermsAsync(anyLong());
        assertEquals(1, translog.readers.size());
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
        verify(translogTransferManager, times(0)).readMetadata(
    public void testGetMinPrimaryTermInRemoteNotFetched() throws IOException {
                16,
            assertEquals(4, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        int numDocs = randomIntBetween(6, 10);
        String md1Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 200000);
import org.opensearch.index.translog.transfer.TranslogTransferMetadata;
        BlobStore blobStore = mock(BlobStore.class);
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
            getTranslogDirectory().add(METADATA_DIR),
                        maxGen -= 1;
            metadataFiles,
        when(translogTransferManager.readMetadata("metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__1"))
        );
        TranslogTransferMetadata md3 = mock(TranslogTransferMetadata.class);
            new Tuple<>(701L, 1008L),
    }
        assertTrue(generations.isEmpty());
        String md3Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 600000);
        translog.setMinSeqNoToKeep(6);
        );
                        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        AtomicLong minPrimaryTermInRemote = new AtomicLong(Long.MAX_VALUE);
        assertBusy(() -> assertEquals(2, translog.allUploaded().size()));
        TranslogTransferMetadata md1 = mock(TranslogTransferMetadata.class);
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
        translog.setMinSeqNoToKeep(3);
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        );
        assertEquals(metadataFiles.get(1), metadataFilesToBeDeleted.get(0));
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
import java.util.List;
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        });
import java.util.stream.LongStream;
    }
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of(2L, 3L, 4L));
        // Node id containing separator
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("5", 4, primaryTerm.get(), new byte[] { 1 }));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
        pinnedGenerations.add(new Tuple<>(12L, 56L));
        assertEquals(
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
        CountDownLatch latch = new CountDownLatch(1);
            metadataFiles,
        assertBusy(() -> assertEquals(0, latch.getCount()));
        Tuple<Long, Long> minMaxGen = TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(nodeIdWithSeparator);
        // First reader is created at the init of translog
            new LatchedActionListener<>(new ActionListener<>() {
            "metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__1"
        assertEquals(metadataFiles, metadataFilesToBeDeleted);
        );
                12,
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
        }
            "metadata__9223372036854775806__9223372036854775770__9223370311919910398__31__9223372036854775790__1__1",
        );
        RemoteFsTimestampAwareTranslog translog = (RemoteFsTimestampAwareTranslog) this.translog;
                translogTransferManager,
        assertTrue(generations.containsAll(md1Generations));
        blobContainer = mock(BlobContainer.class);
        assertBusy(() -> {
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
    }
        Set<Long> md2Generations = LongStream.rangeClosed(17, 25).boxed().collect(Collectors.toSet());
            metadataFilesToBeDeleted,
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 1, primaryTerm.get(), new byte[] { 1 }));
                            getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
import org.opensearch.common.unit.TimeValue;
                public void onFailure(Exception e) {
        assertEquals(3, translog.readers.size());
                "metadata__9223372036438563903__9223372036854775803__9223370311919910413__31__9223372036854775806__5__1",
            );
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of(1L, 2L, 3L, 4L));
        translog.trimUnreferencedReaders();
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
        );
            minPrimaryTermInRemote,
    }
            assertEquals(2, translog.allUploaded().size());
import java.util.concurrent.atomic.AtomicLong;
            );
            expectedMinPrimaryTerm,
        assertEquals(1, translog.readers.size());
        assertTrue(generations.containsAll(md2Generations));
        List<String> metadataFilesToBeDeleted = RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(
                assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
            Thread.sleep(1);
                10,
        assertEquals(4, translog.allUploaded().size());
        assertBusy(() -> {
        when(md2.getMinTranslogGeneration()).thenReturn(4L);
    public void testIsGenerationPinned() {
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        }, 30, TimeUnit.SECONDS);
                translogTransferManager,
                    }
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                        Set<String> dataFilesBeforeTrim = blobStoreTransferService.listAll(
            .thenReturn(md1);
            new HashMap<>(),
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("0", 0, primaryTerm.get(), new byte[] { 1 }));
            // 27 to 42
            metadataFilesToBeDeleted,
            metadataFilesNotToBeDeleted,
        ((RemoteFsTimestampAwareTranslog) translog).trimUnreferencedReaders(true, false);
            translog.trimUnreferencedReaders();
                "metadata__9223372036438563903__9223372036854767890__9223370311919910434__31__9223372036854770000__7__1",
            if (Objects.equals(o1.v1(), o2.v1()) == false) {
        assertFalse(translog.isGenerationPinned(141, pinnedGenerations));
    public void testMetadataFileDeletionWithPinnedTimestamps() throws Exception {
        generations.removeAll(md1Generations);
        // Fetch pinned timestamps so that it won't be stale
                        translog.trimUnreferencedReaders();
        translog.trimUnreferencedReaders();
        TranslogTransferMetadata md1 = mock(TranslogTransferMetadata.class);
        slowDown.setSleepSeconds(2);
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
            // PT 4 to 9
    public void testGetMetadataFilesToBeDeletedExclusionBasedOnAgeAndPinning() throws IOException {
                            assertTrue(metadataFilesAfterTrim.contains(md));
            translogTransferManager,
        Set<Long> md1Generations = LongStream.rangeClosed(5, 7).boxed().collect(Collectors.toSet());
    }
        assertEquals(3, translog.readers.size());
        updatePinnedTimstampTask.run();
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(0), 0, primaryTerm.get(), new byte[] { 1 }));
    }
        long currentTimeInMillis = System.currentTimeMillis();
            "metadata",
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
            )
        ThreadPool threadPool = mock(ThreadPool.class);
            logger
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
        // For older md filenames, it needs to read the content
import org.opensearch.common.settings.Settings;
        fail.failAlways();
    public void testExtraGenToKeep() throws Exception {
        for (int i = 0; i < numDocs; i++) {
    @Override
        List<String> metadataFiles = List.of(
        assertBusy(() -> {
            "metadata__9223372036854775806__9223372036854775707__9223370311919910403__31__9223372036854775765__1__1"
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("7", 7, primaryTerm.get(), new byte[] { 1 }));
        // Fetch pinned timestamps so that it won't be stale
            new Translog.Index(String.valueOf(2), 2, primaryTerm.get(), new byte[] { 1 })
    public void testDeleteStaleRemotePrimaryTermsOldFormatException() throws IOException {
            .thenReturn(md1);
            .thenThrow(new IOException());
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));
            new Tuple<>(4L, 7L),
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 3, primaryTerm.get(), new byte[] { 1 }));
        List<String> metadataFilesToBeDeleted = RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(
        assertEquals(
                config,
                // MaxGen 17
                channelFactory,
    }
        assertEquals(0, translog.availablePermits());
        updatePinnedTimstampTask.run();
        ((RemoteFsTimestampAwareTranslog) translog).trimUnreferencedReaders(true, false);
            // PT 2 to 7
            new Tuple<>(4L, 7L),
            false,
            "metadata__9223372036438563903__9223372036854774799__" + md2Timestamp + "__31__9223372036854775106__1",
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));
        pinnedGenerations.add(new Tuple<>(121L, 140L));
        verify(translogTransferManager, times(1)).deletePrimaryTermsAsync(anyLong());
        ) {
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
        translog.trimUnreferencedReaders();
        metadataFiles.add("metadata__9223372036438563903__9223372036854775701__9223370311919910403__31__9223372036854775701__1");
            staticLogger
    }
        // Test deletion of metadata files
        when(blobContainer.listBlobs()).thenReturn(Map.of(randomInt(100) + "__" + pinnedTimestamp, new PlainBlobMetadata("xyz", 100)));
        // Malformed md filename
            );
                12,
            // PT 2 to 7
            assertEquals(
        ChannelFactory channelFactory = getChannelFactory();
        Releasable releasable = translog.drainSync();
                            // We check for number of pinned timestamp or +1 due to latest metadata.
            )
            shardId,
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
                        Tuple<Long, Long> minMaxGen = TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(blobMetadata.name());
        assertBusy(() -> {
        String md4Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis + 60000);
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1";
        for (int op = 0; op < translogOperations; op++) {
        // 1. During ongoing uploads, the available permits are 0.
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        translog.setMinSeqNoToKeep(2);
            "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1"
                        }
        assertBusy(() -> {
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
                "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1",
    }
        String malformedMdFileName = "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__xyz__3qwe__1";
            );
            "metadata__9223372036854775806__9223372036854775765__9223370311919910403__31__9223372036854775780__1__1"
            assertEquals(5, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
            }, latch)
            ops,
            )
            logger
            true,
        String md2Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 300000);
            // MaxGen 10
        assertTrue(generations.containsAll(md3Generations));
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
                translogTransferManager
    public void testTrimUnreferencedReadersFailAlwaysRepo() throws Exception {
        when(threadPool.schedule(any(), any(), any())).then(invocationOnMock -> {
    }
            Long.MAX_VALUE,
                logger
/*
        // New format metadata file
    }
        verify(translogTransferManager, times(0)).deletePrimaryTermsAsync(anyLong());
            primaryTerm::get,
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        }
        }));
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        );
            Settings.builder().put(CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true).build(),
        translog.trimUnreferencedReaders();
            assertEquals(3, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        assertEquals(4, translog.allUploaded().size());
            new Tuple<>(-1L, 2L),
        String nodeIdWithSeparator =
        );
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("6", 6, primaryTerm.get(), new byte[] { 1 }));
        // Number of calls to readMetadata will be able to verify this.
        assertEquals(3, translog.readers.size());
        // For older md filenames, it needs to read the content
        Long maxPrimaryTerm = 7L;
        when(blobContainer.listBlobs()).thenReturn(Map.of());
            // PT 2 to 7
        Long expectedMinPrimaryTerm = Long.MAX_VALUE;
            // Fetch pinned timestamps so that it won't be stale
        List<String> metadataFiles = List.of(
        // Fetch pinned timestamps so that it won't be stale
            "metadata__9223372036854775806__9223372036854775707__9223370311919910403__31__9223372036854775765__1__1"
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(
import org.mockito.Mockito;
        assertEquals(
                "metadata__9223372036438563903__9223372036854675843__9223370311919910408__31__9223372036854771234__4__1",
            new Tuple<>(1L, 2L),
            "metadata__9223372036438563903__9223372036854774500__" + md1Timestamp + "__31__9223372036854775701__1",
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        pinnedGenerations.add(new Tuple<>(142L, 160L));
            updatePinnedTimstampTask.run();
                DefaultRemoteStoreSettings.INSTANCE,
        assertEquals(
            "metadata__9223372036438563903__9223372036854774799__" + md1Timestamp + "__31__9223372036854775106__1",
            updatePinnedTimstampTask.run();
                @Override
        when(translogTransferManager.readMetadata("metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__1"))
        verify(translogTransferManager).listPrimaryTermsInRemote();
        assertTrue(generations.containsAll(md1Generations));
    public void testIndexDeletionWithNoPinnedTimestampNoRecentMdFiles() throws Exception {
                    try {
}
    public void testGetGenerationsToBeDeleted() throws IOException {
        // Old format metadata file
        generations.removeAll(md3Generations);
    }
        TranslogTransferMetadata md3 = mock(TranslogTransferMetadata.class);
            // PT 2 to 7
        updatePinnedTimstampTask.run();
            RemoteFsTimestampAwareTranslog.getMinPrimaryTermInRemote(new AtomicLong(Long.MAX_VALUE), translogTransferManager, null)
            assertEquals(
                fail("io exception expected");
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
                10,
            assertEquals(6, translog.allUploaded().size());
                }
            "metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__9223372036438563958__4__1",
        assertEquals(
                "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__9223372036854775803__2__1",
            .thenReturn(md1);
        assertEquals(2, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        when(translogTransferManager.readMetadata("metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__1"))
    @Override
                    }
            SequenceNumbers.NO_OPS_PERFORMED,
        assertEquals(minGen, minMaxGen.v1());
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
                translogTransferManager,
        addToTranslogAndListAndUpload(
            translog.getMinMaxTranslogGenerationFromMetadataFile(
    Runnable updatePinnedTimstampTask;
import static org.mockito.Mockito.when;
            )
                }
            // PT 2 to 6
                new Translog.Index(String.valueOf(op), count, primaryTerm.get(), Integer.toString(count).getBytes(StandardCharsets.UTF_8))
        assertEquals(metadataFiles.get(3), metadataFilesToBeDeleted.get(1));
        assertNull(TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(oldFormatMdFilename));
                primaryTerm::get,
        );
        assertEquals(
import java.nio.charset.StandardCharsets;
        when(blobContainer.listBlobs()).thenReturn(new HashMap<>());
            RemoteFsTimestampAwareTranslog.getMinPrimaryTermInRemote(new AtomicLong(Long.MAX_VALUE), translogTransferManager, logger)
        assertEquals(
            new HashMap<>(),
        List<String> metadataFilesToBeDeleted = RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(
        assertNull(TranslogTransferMetadata.getMinMaxPrimaryTermFromFilename(oldFormatMdFilename));
            } catch (TranslogUploadFailedException e) {
        });
    public void testDeleteStaleRemotePrimaryTermsNoPrimaryTermInRemote() throws IOException {
        );
        Set<Long> md3Generations = LongStream.rangeClosed(31, 41).boxed().collect(Collectors.toSet());
        when(blobStoreRepository.blobStore()).thenReturn(blobStore);
        generations.removeAll(md1Generations);
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
            "metadata__9223372036854775806__9223372036854775777__9223370311919910398__31__9223372036854775781__1__1",
            translog.setMinSeqNoToKeep(i);
                16,
        assertEquals(3, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
            Long.MAX_VALUE
                new HashMap<>(),
        assertEquals(maxPrimaryTerm, minMaxPrimaryterm.v2());
                translogTransferManager
            clusterService
                20,
        updatePinnedTimstampTask.run();
                        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
                    for (BlobMetadata blobMetadata : blobMetadataList) {
        assertEquals(
        String md2Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 300000);
    }
            .build();
        md1 = mock(TranslogTransferMetadata.class);
        assertEquals(maxPrimaryTerm, minMaxPrimaryterm.v2());
            new Translog.Index(String.valueOf(numDocs), numDocs, primaryTerm.get(), new byte[] { 1 })
import org.opensearch.indices.DefaultRemoteStoreSettings;
            translog.setMinSeqNoToKeep(2);
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        assertEquals(Long.MAX_VALUE - 9223372036854774799L, TranslogTransferMetadata.getMaxGenerationFromFileName(nodeIdWithSeparator));
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__1",
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("7", 7, primaryTerm.get(), new byte[] { 1 }));
            assertEquals(
            // Fetch pinned timestamps so that it won't be stale
        // Older md files with empty GenerationToPrimaryTermMap
            translogUUID,
    }
        final ClusterService clusterService = BlobStoreTestUtil.mockClusterService(repositoryMetadata);
        TranslogDeletionPolicy deletionPolicy,
            )
        );
import org.opensearch.index.translog.transfer.TranslogTransferManager;
        );
            // 1 to 4
            false,
                        }
        remoteStorePinnedTimestampServiceSpy = Mockito.spy(remoteStorePinnedTimestampService);
            staticLogger
            new HashMap<>(),
            new HashMap<>(),
            RemoteFsTranslog translog = new RemoteFsTranslog(
        Set<Long> md1Generations = LongStream.rangeClosed(4, 7).boxed().collect(Collectors.toSet());
        remoteStorePinnedTimestampServiceSpy.start();
            translog.getMinMaxTranslogGenerationFromMetadataFile(
        translog.setMinSeqNoToKeep(6);
    }
    public void setUp() throws Exception {
        List<String> metadataFiles = new ArrayList<>(
        assertTrue(translog.isOpen());
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        TranslogConfig config = getConfig(1);
                        for (String md : pinnedTimestampMatchingMetadataFiles) {
        long currentTimeInMillis = System.currentTimeMillis();
import org.opensearch.index.seqno.SequenceNumbers;
            // Trims from remote now
        when(md2.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "2", "23", "2", "34", "3"));
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of());
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));
        Set<Long> md3Generations = LongStream.rangeClosed(31, 34).boxed().collect(Collectors.toSet());
        when(md1.getGeneration()).thenReturn(1008L);
        updatePinnedTimstampTask.run();
        Supplier<RepositoriesService> repositoriesServiceSupplier = mock(Supplier.class);
            metadataFiles,
            translogTransferManager,
        assertEquals(1, metadataFilesToBeDeleted.size());
        // Calling it again to check if the details are getting fetched from the cache.
        // Acquire the permits so that remote translog deletion will not happen
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
        assertEquals(
        when(md1.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "4", "23", "5", "34", "5"));
            TranslogOperationHelper.DEFAULT,
                "metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1",
        assertEquals(2, minPrimaryTermInRemote.get());
            List.of(
        );
            new HashMap<>(),
        assertBusy(() -> {
            new Tuple<>(-1L, 2L),
                // MaxGen 7
                translogTransferManager
        when(blobContainer.listBlobs()).thenReturn(Map.of(randomInt(100) + "__" + pinnedTimestamp, new PlainBlobMetadata("xyz", 100)));
        Set<Long> generations = ((RemoteFsTimestampAwareTranslog) translog).getGenerationsToBeDeleted(
        Long expectedMinPrimaryTerm = 12L;
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
        assertTrue(translog.isGenerationPinned(156, pinnedGenerations));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("5", 5, primaryTerm.get(), new byte[] { 1 }));
        minMaxPrimaryterm = TranslogTransferMetadata.getMinMaxPrimaryTermFromFilename(nodeIdWithSeparator);
        );
        TranslogTransferMetadata md1 = mock(TranslogTransferMetadata.class);
    public void testDeleteStaleRemotePrimaryTermsOldFormat() throws IOException {
            "metadata__9223372036438563903__9223372036854775701__" + md3Timestamp + "__31__9223372036854775701__1"
        assertFalse(translog.isGenerationPinned(5000, pinnedGenerations));
        assertBusy(() -> {
        pinnedGenerations.add(new Tuple<>(142L, 180L));
import java.util.ArrayList;
            );
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        assertNull(TranslogTransferMetadata.getMinMaxPrimaryTermFromFilename(malformedMdFileName));
        );
        );
                        assertEquals(minGen, minMaxGen.v1());
            assertEquals(
            "metadata__9223372036438563903__9223372036854775701__" + md4Timestamp + "__31__9223372036854775701__1"
        TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(config.getIndexSettings());
        assertEquals(metadataFiles.get(1), metadataFilesToBeDeleted.get(0));
        when(md2.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "2", "23", "2", "34", "3"));
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
            metadataFilesToBeDeleted,
        assertEquals(
import static org.opensearch.index.translog.RemoteFsTranslog.REMOTE_DELETION_PERMITS;
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("8", 8, primaryTerm.get(), new byte[] { 1 }));
        generations.removeAll(md3Generations);
        assertEquals(
        super.setUp();
                new HashMap<>(),
            DefaultRemoteStoreSettings.INSTANCE,
        maxPrimaryTerm = 7L;
            assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        ArrayList<Translog.Operation> ops = new ArrayList<>();
            // PT 4 to 9
        );
            logger
        // This test checks following scenarios -
            );
        generations.removeAll(md2Generations);
                repository,
        translog.trimUnreferencedReaders();
        when(md1.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "1", "23", "1", "34", "2"));
        String md2Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 300000);
                () -> SequenceNumbers.NO_OPS_PERFORMED,
            "metadata__9223372036438563903__9223372036854775600__" + md2Timestamp + "__31__9223372036854775803__1",
        assertBusy(() -> {
 * The OpenSearch Contributors require contributions made to
                }
            new Translog.Index(String.valueOf(numDocs + 1), numDocs + 1, primaryTerm.get(), new byte[] { 1 })
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        metadataFiles.add("metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__9223372036854775803__1");
        String nodeIdWithSeparator =
            )
import org.opensearch.common.blobstore.BlobPath;
                public void onResponse(List<BlobMetadata> blobMetadataList) {
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
            threadPool,
import org.opensearch.common.settings.ClusterSettings;
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
        assertEquals(
            new Tuple<>(4L, 7L),
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));
        assertTrue(generations.containsAll(md3Generations));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(3), 3, primaryTerm.get(), new byte[] { 1 }));
                        fail();
        Long minPrimaryTerm = 2L;
            new RemoteTranslogTransferTracker(shardId, 10),
            );
    public void testGetMetadataFilesToBeDeletedExclusionDueToRefreshTimestamp() {
                "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1",
                // MaxGen 12
        );
        // Case 2 - During an upload, if drainSync is called, it will wait for it to acquire and available permits are 0.
            assertEquals(
        List<String> metadataFiles = new ArrayList<>();
        );
            )
        assertBusy(() -> assertTrue(translog.isRemoteGenerationDeletionPermitsAvailable()));
        translog.trimUnreferencedReaders();
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
                "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__9223372036854775106__1__1",
    @Override
        // Removing file that is pinned by latest refresh timestamp
        when(repositoriesService.repository("remote-repo")).thenReturn(blobStoreRepository);
            "metadata__9223372036438563903__9223372036854774799__9223370311919910393__node__1__9223372036438563958__2__1";
        );
        List<String> metadataFiles = List.of(
import java.util.HashMap;
            new HashMap<>(),
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of(1L, 2L, 3L, 4L));
        assertNull(TranslogTransferMetadata.getMinMaxTranslogGenerationFromFilename(malformedMdFileName));
                translogTransferManager
            };
            metadataFiles,
 * compatible open source license.
            RemoteFsTimestampAwareTranslog.getMinPrimaryTermInRemote(new AtomicLong(Long.MAX_VALUE), translogTransferManager, logger)
        );
            assertEquals(
    }
                            assertTrue(metadataFilesAfterTrim.size() >= pinnedTimestamps.size());
        pinnedGenerations.add(new Tuple<>(4L, 9L));
        );
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        assertBusy(() -> {
        assertEquals(2, translog.readers.size());
                assertTrue("at least one operation pending", translog.syncNeeded());
            "metadata__9223372036854775806__9223372036854775777__9223370311919910398__31__9223372036854775781__1__1",
import org.apache.logging.log4j.Logger;
        translog.setMinSeqNoToKeep(3);
            // This is just to make sure that each metadata is at least 1ms apart
            () -> globalCheckpoint.get(),
        fail.failNever();
        Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslogTests.class);
            staticLogger
            minPrimaryTermInRemote,
            );
            // 17 to 37
            // 1 to 4
                deletionPolicy,
        translog.trimUnreferencedReaders();
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        assertEquals(metadataFiles.get(2), metadataFilesToBeDeleted.get(0));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(2, metadataFilesToBeDeleted.size());
        return new RemoteFsTimestampAwareTranslog(
            deletionPolicy,
                new HashMap<>(),
            "metadata__9223372036438563903__9223372036854775600__" + md3Timestamp + "__31__9223372036854775803__1",
        updatePinnedTimstampTask.run();
        assertEquals(
        // This means there are no new invocations of deletePrimaryTermAsync
        assertTrue(translog.isGenerationPinned(12, pinnedGenerations));
        translog.setMinSeqNoToKeep(3);
        int numDocs = randomIntBetween(16, 20);
            metadataFilesNotToBeDeleted,
        Set<Long> md3Generations = LongStream.rangeClosed(27, 42).boxed().collect(Collectors.toSet());
        );
        ArrayList<Translog.Operation> ops = new ArrayList<>();
                        updatePinnedTimstampTask.run();
            // 42 to 100
import org.opensearch.threadpool.ThreadPool;
                new HashMap<>(),
            logger
            assertEquals(
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 3, primaryTerm.get(), new byte[] { 1 }));
            staticLogger
        translog.trimUnreferencedReaders();
        long currentTimeInMillis = System.currentTimeMillis();
            "metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__1",
        assertEquals(Long.MAX_VALUE - 9223372036854774799L, TranslogTransferMetadata.getMaxGenerationFromFileName(oldFormatMdFilename));
            assertEquals(9, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
        Logger staticLogger = LogManager.getLogger(RemoteFsTimestampAwareTranslogTests.class);
            // 26 to 30
        // Older md files with empty GenerationToPrimaryTermMap
    protected RemoteFsTranslog createTranslogInstance(
        // Refill the permits back
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
    }
                "metadata__9223372036854774799__9223372036854774799__9223370311919910393__31__9223372036854775106__1__1",
        );
            assertEquals(1, translog.readers.size());
            "metadata",
            "metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__9223372036438563958__4__1",
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
            translog.trimUnreferencedReaders();
        generations.removeAll(md3Generations);
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node1__9223372036438563958__2__1",
import org.opensearch.repositories.blobstore.BlobStoreRepository;
 *
import java.util.concurrent.CountDownLatch;
    @Override
        assertBusy(() -> assertEquals(0, translog.availablePermits()));
    ) throws IOException {
                    // This means test failure
        assertBusy(() -> assertEquals(1, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size()));
import org.opensearch.action.LatchedActionListener;
            // 17 to 37
        );
            }
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
        // Test deletion of metadata files
        updatePinnedTimstampTask.run();
        generations.removeAll(md1Generations);
        AtomicLong minPrimaryTermInRemote = new AtomicLong(Long.MAX_VALUE);
    @Before
        Set<Long> md2Generations = LongStream.rangeClosed(17, 37).boxed().collect(Collectors.toSet());
    @Override
        pinnedGenerations.add(new Tuple<>(142L, 170L));
                logger
            "metadata__9223372036438563903__9223372036854774500__" + md1Timestamp + "__31__9223372036854775106__1",
        int translogOperations = randomIntBetween(1, 20);
    public void testTrimUnreferencedReadersNoPermits() throws Exception {
        );
    }
                                assertTrue(dataFilesAfterTrim.contains(Translog.getFilename(i)));
        pinnedGenerations.add(new Tuple<>(1L, 1L));
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index(String.valueOf(i), i, primaryTerm.get(), new byte[] { 1 }));
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        }, 30, TimeUnit.SECONDS);
        long currentTimeInMillis = System.currentTimeMillis();
            "metadata__9223372036854775801__9223372036854774799__9223370311919910393__node1__1"
        );
        assertTrue(generations.containsAll(md2Generations));
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(
            )
        );
        );
            ops,
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("1", 1, primaryTerm.get(), new byte[] { 1 }));
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
        TranslogTransferMetadata md2 = mock(TranslogTransferMetadata.class);
        updatePinnedTimstampTask.run();
        );
        when(md2.getGeneration()).thenReturn(7L);
    }
            // PT 2 to 6
        List<String> metadataFilesToBeDeleted = List.of(
        thread1.start();
            staticLogger
        ArrayList<Translog.Operation> ops = new ArrayList<>();
        Tuple<Long, Long> minMaxPrimaryterm = TranslogTransferMetadata.getMinMaxPrimaryTermFromFilename(newFormatMetadataFile);
        latch.await();
            ops,
    }
            new HashMap<>(),
        );
        assertEquals(1, metadataFilesToBeDeleted.size());
            translogTransferManager,
        fail.failAlways();
        when(translogTransferManager.readMetadata("metadata__9223372036854775798__9223372036854774799__9223370311919910393__node1__1"))
            Long.MAX_VALUE,
        Translog.Location loc = addToTranslogAndListAndUpload(
        assertBusy(() -> {
        }).then(subsequentInvocationsOnMock -> null);
        RemoteFsTimestampAwareTranslog.deleteStaleRemotePrimaryTerms(
        List<String> metadataFilesToBeDeleted = RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(
                }
                            long timestamp = RemoteStoreUtils.invertLong(metadataFilename.split(METADATA_SEPARATOR)[3]);
        long pinnedTimestamp = RemoteStoreUtils.invertLong(md2Timestamp) + 10000;
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata(randomAlphaOfLength(10), FsRepository.TYPE, settings);
import org.opensearch.index.remote.RemoteStoreUtils;
import org.opensearch.cluster.service.ClusterService;
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("4", 4, primaryTerm.get(), new byte[] { 1 }));
            new Tuple<>(701L, 1008L),
        AtomicLong minPrimaryTermInRemote = new AtomicLong(Long.MAX_VALUE);
            minPrimaryTermInRemote,
        );
                new RemoteTranslogTransferTracker(shardId, 10),
            addToTranslogAndListAndUpload(translog, ops, new Translog.Index("3", 2, primaryTerm.get(), new byte[] { 1 }));
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("5", 5, primaryTerm.get(), new byte[] { 1 }));
        List<String> metadataFiles = List.of(
            translog,
        String md4Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 600000);
            Integer.MAX_VALUE,
        when(md3.getGenerationToPrimaryTermMapper()).thenReturn(Map.of("12", "2", "23", "2", "34", "2"));
            );
        String md1Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis + 100000);
        );
            RemoteFsTimestampAwareTranslog.getMetadataFilesToBeDeleted(metadataFiles, new HashMap<>(), Long.MAX_VALUE, false, logger)
                        when(blobContainer.listBlobs()).thenReturn(pinnedTimestampsMap);
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("2", 2, primaryTerm.get(), new byte[] { 1 }));
        );
        String oldFormatMdFilename = "metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1";
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        );
                    List<Long> pinnedTimestamps = new ArrayList<>();
        long currentTimeInMillis = System.currentTimeMillis();
        Long maxGen = Long.MAX_VALUE - 9223372036854774799L;
                persistedSeqNos::add,
                latch.countDown();
        String md4Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 800000);
    public void testGetMinPrimaryTermInRemoteNotFetchedEmpty() throws IOException {
        }, 30, TimeUnit.SECONDS);
        TranslogTransferManager translogTransferManager = mock(TranslogTransferManager.class);
        when(translogTransferManager.listPrimaryTermsInRemote()).thenReturn(Set.of(1L, 2L, 3L, 4L));
        String md1Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 200000);
            minPrimaryTermInRemote,
                    pinnedTimestamps.forEach(ts -> pinnedTimestampsMap.put(randomInt(1000) + "__" + ts, new PlainBlobMetadata("x", 100)));
            assertEquals(6, translog.allUploaded().size());
        updatePinnedTimstampTask.run();
        });
    @Override
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.ZERO);
        // Case 4 - After drainSync, if an upload is an attempted, we do not upload to remote store.
                "metadata__9223372036854775805__9223372036854774799__9223370311919910393__31__1",
                translog.sync();
                "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1",
            assertEquals(7, blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR)).size());
    }
import static org.mockito.ArgumentMatchers.any;
        CountDownLatch latch = new CountDownLatch(1);
            )
                10,
        verify(translogTransferManager).deletePrimaryTermsAsync(2L);
        verify(translogTransferManager, times(0)).deletePrimaryTermsAsync(anyLong());
            new HashMap<>(),
        when(md1.getGenerationToPrimaryTermMapper()).thenReturn(null);
    public void testGetMetadataFilesToBeDeletedExclusionBasedOnPinningOnly() throws IOException {
            }
                new HashMap<>(),
            // PT 4 to 9
        verify(translogTransferManager).listPrimaryTermsInRemote();
        List<String> metadataFilesNotToBeDeleted = List.of(
                20,
import java.util.concurrent.TimeUnit;
            translog.setMinSeqNoToKeep(i);
            translogTransferManager,
                blobStoreTransferService.listAll(getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))).size()
        String md3Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 600000);
                translogTransferManager,
            "metadata__9223372036854775800__9223372036854774799__9223370311919910393__node__1__9223372036438563958__2__1";
        );
        Set<Long> generations = ((RemoteFsTimestampAwareTranslog) translog).getGenerationsToBeDeleted(
                            pinnedTimestampMatchingMetadataFiles.add(metadataFilename);
            } catch (IOException e) {
                    fail();
            } else {
            35
            translog,
        );
        md1 = mock(TranslogTransferMetadata.class);
        List<String> metadataFilesNotToBeDeleted = new ArrayList<>();
            )
            // 4 to 7
            assertEquals(6, translog.allUploaded().size());
                8,
        Set<String> mdFiles = blobStoreTransferService.listAll(getTranslogDirectory().add(METADATA_DIR));
            translogTransferManager,
                            getTranslogDirectory().add(DATA_DIR).add(String.valueOf(primaryTerm.get()))
            new Tuple<>(1L, 1008L),
    }
        when(translogTransferManager.readMetadata("metadata__9223372036438563903__9223372036854774799__9223370311919910393__31__1"))
            "metadata__9223372036438563903__9223372036854775800__" + md1Timestamp + "__31__9223372036854775106__1",
            assertEquals(
        String md2Timestamp = RemoteStoreUtils.invertLong(currentTimeInMillis - 400000);
        );
        }, 30, TimeUnit.SECONDS);
            "metadata__9223372036854775806__9223372036854775765__9223370311919910403__31__9223372036854775780__1__1"
        String translogUUID = Translog.createEmptyTranslog(
        try (
        }, 30, TimeUnit.SECONDS);
        assertEquals(
            metadataFiles,
    public void testSyncUpAlwaysFailure() throws IOException {
            staticLogger
        String malformedMdFileName = "metadata__9223372036438563903__9223372036854774799__9223370311919910393__node1__xyz__3__1";
            RemoteFsTimestampAwareTranslog.getMinMaxPrimaryTermFromMetadataFile(
    }
                translogTransferManager,
        );
            "metadata__9223372036438563903__9223372036854775798__" + md3Timestamp + "__31__9223372036854775701__1",
            "metadata__9223372036438563903__9223372036854775800__9223370311919910398__31__1"
                return o1.v2().compareTo(o2.v2());
    public void testGetMinMaxPrimaryTermFromMetadataFile() throws IOException {
            "metadata__9223372036438563903__9223372036854775701__" + md4Timestamp + "__31__9223372036854775701__1"
        addToTranslogAndListAndUpload(translog, ops, new Translog.Index("6", 6, primaryTerm.get(), new byte[] { 1 }));
import java.util.HashSet;
        minPrimaryTerm = 2L;
        Settings settings = Settings.builder()
            new HashMap<>(),
            )
                    }
