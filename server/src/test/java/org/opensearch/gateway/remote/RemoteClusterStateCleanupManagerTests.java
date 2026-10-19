        when(blobStore.blobContainer(any())).thenReturn(container);
                List.of(
            return Collections.emptyList();  
        when(remoteClusterStateService.getRemoteManifestManager()).thenReturn(remoteManifestManager);
        UploadedMetadataAttribute coordinationMetadataUpdated = new UploadedMetadataAttribute(
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
            listener.onResponse(null);  
        }).when(cleanUpManager).deleteClusterMetadata(anyString(), anyString(), any(), any());
        spyManager.deleteStaleClusterMetadata(clusterName, clusterUUID, RETAINED_MANIFESTS, stateVersion);  
        List<UploadedIndexMetadata> indicesRouting2 = List.of(index2Metadata);
            .clusterTerm(1L)  
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
        UploadedIndexMetadata index1Metadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1__1");
        verify(remoteRoutingTableService).deleteStaleIndexRoutingPaths(List.of(index1Metadata.getUploadedFilename()));
        ClusterStateDiffManifest diffManifest2 = ClusterStateDiffManifest.builder().indicesRoutingDiffPath("index2RoutingDiffPath").build();
        String clusterName = "test-cluster";  
                    // coordination/setting metadata is from CODEC_V2, the uploaded filename with contain the complete path
    private ClusterService clusterService;  
        UploadedIndexMetadata index1Metadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1__2");
        String clusterUUID = "test-uuid";  
            .clusterTerm(1L)
        doAnswer(invocation -> {
        doAnswer(invocation -> mockTransferService).when(cleanUpManager).getBlobStoreTransferService();
            .clusterStateCustomMetadataMap(Map.of())
        assertEquals(newMaxBatches, clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING).intValue());
        );
        }  
        remoteClusterStateCleanupManager.start();
            new PlainBlobMetadata("manifest3.dat", 1L),  
            eq(batch3.subList(manifestsToRetain, batch3.size()))
                BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        clusterSettings.applySettings(newSettings);
        );  
        ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder(manifest1)  
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
import static org.mockito.Mockito.times;
        );
        );
            batch1,  
            .put(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING.getKey(), maxBatches)
        UploadedMetadataAttribute settingMetadata = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata");
            return null;
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(eq(new ArrayList<>(staleManifest)), any());
        cleanUpManager.cleanUpStaleFiles();
        List<BlobMetadata> inactiveBlobs = Arrays.asList(new PlainBlobMetadata("manifest1.dat", 1L));
        int invalidBatchSize = randomIntBetween(1, RETAINED_MANIFESTS);
            listener.onResponse(null);
        String clusterName = "test-cluster";
            .committed(true)
        doAnswer(invocation -> {
            IllegalArgumentException.class,
    }
            .codecVersion(CODEC_V1)
            .clusterUUID(clusterUUID)  
        }).when(cleanUpManager).deleteClusterMetadata(anyString(), anyString(), any(), any());
        when(clusterApplierService.state()).thenReturn(clusterState);  
        assertTrue(task.isScheduled());
        remoteRoutingTableService = mock(NoopRemoteRoutingTableService.class);  
        cleanUpManager.deleteStaleClusterMetadata(clusterName, clusterUUID, manifestsToRetain, 10);
        BlobPath blobPath = new BlobPath().add("random-path");
            eq(List.of(getFormattedIndexFileName(index1Metadata.getUploadedFilePath()))),
        assertTrue(task.isScheduled());
        doAnswer(invocation -> {
                BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC  
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        when((blobStoreRepository.basePath())).thenReturn(blobPath);  
    public void testDeleteClusterMetadata() throws IOException {  
        ClusterMetadataManifest manifest1 = ClusterMetadataManifest.builder()  
            new PlainBlobMetadata("manifest5.dat", 1L),
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);  
    private ClusterState clusterState;  
        cleanUpManager.deleteStaleClusterMetadata(clusterName, clusterUUID, manifestsToRetain, 20);
                return uuidContainerContainer;
        remoteClusterStateCleanupManager.start();
        String clusterName = "test-cluster";
            .templatesMetadata(templateMetadataUpdated)
            manifest2,  
import org.opensearch.cluster.ClusterState;
        remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs);  
        );
    public void testLastCleanupAttemptStateVersionNotUpdatedOnFailure() throws Exception {  
            any()
        doAnswer(invocationOnMock -> {  
        remoteClusterStateCleanupManager.deleteStaleClusterMetadata("cluster-name", "cluster-uuid", RETAINED_MANIFESTS, 10);  
        );
            .settingMetadata(settingMetadataUpdated)
        assertBusy(() -> {
        List<UploadedIndexMetadata> indicesRouting1 = List.of(index3Metadata, index4Metadata);  
import java.util.concurrent.TimeUnit;  
            throw new RuntimeException("Test exception");
import static org.mockito.Mockito.verifyNoMoreInteractions;
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);  
        // Task is still scheduled after the failure  
            if (blobPath1.buildAsString().endsWith("cluster-state/")) {  
        );
        metadata = mock(Metadata.class);
        ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder(manifest1)
            manifests.subList(0, RETAINED_MANIFESTS)
        when(clusterState.version()).thenReturn(version);  
    public void testBatchedDeletionWithSingleBatch() throws Exception {
            // wait for stats to get updated
    }  
    }  
import static org.mockito.Mockito.doThrow;
            .build();
import static org.mockito.Mockito.doAnswer;  
            .committed(true)
        when(clusterState.nodes()).thenReturn(nodes);
        remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs);  
        when(clusterApplierService.state()).thenReturn(clusterState);  
            "remote_store_repository"
            () -> { clusterSettings.applySettings(invalidSettings); }
    public void testRemoteStateCleanupFailureStats() throws IOException {  
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.AsyncStaleFileDeletion;  
        AtomicInteger callCount = new AtomicInteger(0);  
            .stateVersion(1L)  
        );
            .stateVersion(1L)
        doAnswer(invocation -> {
            eq(batch2.subList(0, manifestsToRetain)),
        String clusterUUID = "test-uuid";
        assertTrue(completionLatch.await(5, TimeUnit.SECONDS));  
        );
        int maxBatches = 2;
        cleanUpManager.cleanUpStaleFiles();
            return null;
        );
                verify(manifest3Container, times(1)).delete();
        doAnswer(invocation -> {
        blobStoreRepository = mock(BlobStoreRepository.class);  
            manifest2,  
            .clusterTerm(1L)
        doThrow(new IOException("Test failure")).when(spyManager).deleteClusterMetadata(any(), any(), any(), any());
    public void testRemoteClusterStateCleanupSetting() {  
    }  
        verify(remoteRoutingTableService).deleteStaleIndexRoutingPaths(List.of(index3Metadata.getUploadedFilename()));
        UploadedMetadataAttribute coordinationMetadata = new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination_metadata");
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
            return null;  
            latch.countDown();  
        assertEquals(2, callCount.get());
            .codecVersion(CODEC_V3)
        UploadedMetadataAttribute settingMetadataUpdated = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata_updated");
        when(clusterState.nodes()).thenReturn(nodes);
            if (!filesToDelete.isEmpty()) {
import java.util.Set;
            .indicesRouting(indicesRouting2)  
        UploadedMetadataAttribute templateMetadata = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata");
        task.run();  
import java.util.function.Supplier;
import static org.mockito.Mockito.doNothing;
        ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder(manifest1)
        );
import org.opensearch.core.action.ActionListener;
import org.opensearch.test.OpenSearchTestCase;
        });
            return null;  
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.MANIFEST_CLEANUP_MAX_BATCHES_DEFAULT;  
            .indices(List.of(index1Metadata))
        when(nodes.isLocalNodeElectedClusterManager()).thenReturn(true);  
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), eq(batchSize))).thenReturn(batch1, batch2, batch3);
        List<BlobMetadata> batch1 = new ArrayList<>();
import static org.mockito.ArgumentMatchers.eq;
import org.opensearch.cluster.node.DiscoveryNodes;
        for (int i = 0; i < 15; i++) {
            .settingMetadata(settingMetadataUpdated)  
            ActionListener<Void> listener = invocation.getArgument(1);  
            .deleteStaleClusterMetadata(any(), any(), anyInt(), anyLong());
            .build();
        List<UploadedIndexMetadata> indicesRouting2 = List.of(index4Metadata);
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
        cleanUpManager.cleanUpStaleFiles();
            throw new RuntimeException(e);
        int batchSize = 50;
            remoteRoutingTableService
    public void testBatchedDeletionStopsWhenManifestsLessThanRetained() throws Exception {  
        UploadedMetadataAttribute coordinationMetadataUpdated = new UploadedMetadataAttribute(
        int manifestsToRetain = RETAINED_MANIFESTS;
            .build();  
        String clusterName = "test-cluster";
            .deleteStaleClusterMetadata(any(), any(), anyInt(), anyLong());
    }
            manifest1
        int maxBatches = 3;  
        remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs);
        UploadedMetadataAttribute coordinationMetadata = new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination_metadata");  
 * compatible open source license.
                    new BlobPath().add(GLOBAL_METADATA_PATH_TOKEN).buildAsString() + "global_metadata.dat"
        }).when(spyManager).deleteClusterMetadata(any(), any(), any(), any());
        int newMaxBatches = randomIntBetween(10, 500);  
    private BlobStore blobStore;  
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))  
        CountDownLatch latch = new CountDownLatch(1);  
    }
            .build();
            .settingMetadata(settingMetadata)  
            .clusterUUID(clusterUUID)  
        List<BlobMetadata> batch1 = new ArrayList<>();  
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
        cleanUpManager.cleanUpStaleFiles();  
                    filesToDelete.getFirst().contains("manifest")
        remoteClusterStateCleanupManager.start();
            .clusterTerm(1L)  
        doAnswer(invocation -> {
        cleanUpManager.start();  
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)  
    public void testRemoteCleanupCallsDeleteIfVersionIncrementGreaterThanThreshold() {
    public void testRemoteCleanupTaskScheduled() {  
            .indicesRouting(indicesRouting1)  
            } else if (blobPath1.buildAsString().contains("cluster-state/cluster-uuid3/")) {
            .globalMetadataFileName("global_metadata")
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
            ActionListener<Void> listener = invocation.getArgument(1);
                MANIFEST + DELIMITER,  
            manifest7,
        List<BlobMetadata> inactiveBlobs = Arrays.asList(  
        clusterSettings.applySettings(newSettings);
    public void setup() {
        doAnswer(invocation -> {  
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
            return null;  
        CountDownLatch latch = new CountDownLatch(maxBatches);
        String clusterName = "test-cluster";
        when(remoteClusterStateService.getBlobStoreRepository()).thenReturn(blobStoreRepository);
    @Before  
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)  
    }
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(eq(List.of("restore_file1", "snapshot_file1")), any());
    }  
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)  
            callCount.incrementAndGet();
        BlobContainer blobContainer = mock(BlobContainer.class);
        UploadedMetadataAttribute settingMetadata = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata");  
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);
        assertTrue(exception.getCause().getMessage().contains("Cleanup Batch Size should be greater than [" + RETAINED_MANIFESTS + "]"));
        verify(cleanUpManager, times(1)).deleteClusterMetadata(  
            return null;
        // using spied cleanup manager so that stubbed deleteStaleClusterMetadata is called  
            .diffManifest(diffManifest1)
    }
        remoteClusterStateCleanupManager = new RemoteClusterStateCleanupManager(
            .clusterUUID(clusterUUID)
import java.io.IOException;
            manifest6
        remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs);
            .clusterStateCustomMetadataMap(Map.of("restore", new UploadedMetadataAttribute("restore", "restore_file1")))
import org.opensearch.common.unit.TimeValue;  
            assertNotNull(remoteClusterStateCleanupManager.getStats());
        remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs);  
import org.opensearch.cluster.routing.remote.InternalRemoteRoutingTableService;
                assertEquals(1, remoteClusterStateCleanupManager.getStats().getCleanupAttemptFailedCount());
        );
            .diffManifest(diffManifest1)
        );  
            .clusterTerm(1L)
            .build();
            listener.onResponse(null);
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
    public void testRemoteCleanupSchedulesEvenAfterFailure() {
            remoteClusterStateService,
        UploadedMetadataAttribute coordinationMetadataUpdated = new UploadedMetadataAttribute(  
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);  
            manifest1,
            anyString(),  
        }).when(cleanUpManager).deleteClusterMetadata(anyString(), anyString(), any(), any());
        when(clusterState.metadata()).thenReturn(metadata);
            .build();  
        UploadedMetadataAttribute templateMetadataUpdated = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata_updated");  
            listener.onResponse(null);  
        verify(cleanUpManager, times(1)).deleteClusterMetadata(
        ClusterMetadataManifest manifest1 = ClusterMetadataManifest.builder()
        BlobContainer manifest3Container = mock(BlobContainer.class);  
            .indices(List.of(index2Metadata))  
        );
    }
        }
        ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder(manifest1)
        String clusterUUID = "test-uuid";  
        }  
        remoteClusterStateCleanupManager = new RemoteClusterStateCleanupManager(
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
        ClusterMetadataManifest manifest4 = ClusterMetadataManifest.builder(manifest3)
import org.junit.After;
        ClusterMetadataManifest manifest5 = ClusterMetadataManifest.builder(manifest4).templatesMetadata(templateMetadataUpdated).build();
package org.opensearch.gateway.remote;
        when(clusterApplierService.state()).thenReturn(clusterState);
            .clusterUUID(clusterUUID)
            manifests.add(new PlainBlobMetadata("manifest" + i + ".dat", 1L));
            .indicesRouting(indicesRouting2)
        assertEquals(0L, spyManager.getLastCleanupAttemptStateVersion());
        doAnswer(invocation -> callCount.incrementAndGet()).when(cleanUpManager)  
            .clusterStateCustomMetadataMap(Map.of("snapshots", new UploadedMetadataAttribute("snapshots", "snapshot_file1")))
        clusterSettings.applySettings(newSettings);  
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            .indicesRouting(indicesRouting2)  
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))  
            )
        when(clusterState.getClusterName()).thenReturn(new ClusterName("test"));
                );
            ),
        try {
import org.opensearch.threadpool.TestThreadPool;  
import org.opensearch.cluster.service.ClusterService;  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.getFormattedIndexFileName;
            latch.countDown();  
    }
            eq(batch2.subList(manifestsToRetain, batch2.size()))
            .codecVersion(CODEC_V2)  
    private Supplier<RepositoriesService> repositoriesServiceSupplier;  
        TimeValue newInterval = TimeValue.timeValueMinutes(10);
            manifests.subList(0, manifestsToRetain)
        // now the task should be initialized  
            "remote_store_repository"  
import org.opensearch.common.blobstore.BlobMetadata;  
        for (int i = 0; i < batchSize; i++) {
    }
            eq(clusterName),
            eq(batch1.subList(manifestsToRetain, batch1.size()))
        when(remoteManifestManager.fetchRemoteClusterMetadataManifest(eq(clusterName), eq(clusterUUID), any())).thenReturn(
                assertTrue(remoteClusterStateCleanupManager.getStats() != null);
        doAnswer(invocation -> mockTransferService).when(cleanUpManager).getBlobStoreTransferService();
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
    public void testBatchSizeSettingUpdate() {
                    filesToDelete.getFirst().contains("manifest")  
                    .name()
        cleanUpManager.start();
        BlobPath blobPath = new BlobPath().add("random-path");  
        ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder(manifest1)
            .indices(List.of(index1Metadata))  
        verify(cleanUpManager, times(1)).deleteClusterMetadata(
        );  
        );
        ClusterStateDiffManifest diffManifest1 = ClusterStateDiffManifest.builder().indicesRoutingDiffPath("index1RoutingDiffPath").build();  
        threadPool.executor(ThreadPool.Names.REMOTE_PURGE).execute(() -> {
        UploadedMetadataAttribute settingMetadata = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata");
        Settings newSettings = Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING.getKey(), newMaxBatches).build();
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        String stateRepoTypeAttributeKey = String.format(  
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
 */  
        UploadedIndexMetadata index4Metadata = new UploadedIndexMetadata("index4", "indexUUID4", "index_metadata4__2");
            manifest1,
        doNothing().when(remoteRoutingTableService).deleteStaleIndexRoutingDiffPaths(any());
    public void testUpdateCleanupIntervalDoesNotRescheduleWhenTaskScheduled() {  
            .build();  
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);  
            batch1.add(new PlainBlobMetadata("manifest-" + i + ".dat", 1L));
    private Metadata metadata;
            .codecVersion(CODEC_V2)  
    private BlobStoreRepository blobStoreRepository;
        assertEquals(0, callCount.get());
        when(remoteManifestManager.fetchRemoteClusterMetadataManifest(eq(clusterName), eq(clusterUUID), any())).thenReturn(
        List<BlobMetadata> activeBlobs = Arrays.asList(  
        assertThrows(
            ActionListener<Void> listener = invocation.getArgument(1);  
        assertEquals(0L, spyManager.getLastCleanupAttemptStateVersion());  
        when(clusterState.nodes()).thenReturn(nodes);
        );
        assertTrue(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isScheduled());
        }).when(cleanUpManager).deleteClusterMetadata(anyString(), anyString(), any(), any());
        Settings newSettings = Settings.builder().put("cluster.remote_store.state.cleanup_interval", newInterval).build();  
            IOException.class,
        RemoteClusterStateCleanupManager spyManager = spy(remoteClusterStateCleanupManager);  
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V2;
                    "Attempted to delete manifests before index routing files " + filesToDelete,
                throw new Exception("Timed out waiting for delete task queuing to complete");
        assertBusy(() -> assertEquals(1, callCount.get()));  
    public void testRemoteCleanupSkipsOnOnlyElectedClusterManager() {
            callCount.incrementAndGet();
        }).when(cleanUpManager).cleanUpStaleFiles();  
    private DiscoveryNodes nodes;
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        String clusterName = "test-cluster";
        String clusterUUID = "test-uuid";
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
            eq(  
        UploadedIndexMetadata index2Metadata = new UploadedIndexMetadata("index2", "indexUUID2", "index_metadata2__2");
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
        cleanUpManager.start();
        String clusterName = "test-cluster";  
        List<UploadedIndexMetadata> indicesRouting2 = List.of(index2Metadata);
            latch.countDown();
        when((blobStoreRepository.basePath())).thenReturn(blobPath);  
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), anyInt())).thenReturn(
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), eq(batchSize))).thenReturn(
            .codecVersion(CODEC_V2)
        AtomicInteger callCount = new AtomicInteger(0);
        );
        );
        List<UploadedIndexMetadata> indicesRouting2 = List.of(index2Metadata);  
            eq(clusterUUID),
        );
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), eq(batchSize))).thenReturn(batch);  
        when(clusterService.getClusterApplierService()).thenReturn(clusterApplierService);
            return null;  
            remoteClusterStateService,
import static org.mockito.Mockito.spy;
                Integer.MAX_VALUE,
import org.opensearch.common.blobstore.BlobContainer;
            .nodeId("nodeA")  
        assertTrue(task.isScheduled());
            eq(clusterName),
        blobStore = mock(BlobStore.class);
        doAnswer(invocation -> {  
            .settingMetadata(settingMetadata)
            new PlainBlobMetadata("manifest1.dat", 1L),
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
        );
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);  
        // verify update interval
            batch.add(new PlainBlobMetadata("manifest" + i + ".dat", 1L));  
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
            new PlainBlobMetadata("manifest2.dat", 1L),
        doThrow(IOException.class).when(blobContainer).delete();
            List<String> filesToDelete = invocation.getArgument(0);
    }
import org.opensearch.threadpool.ThreadPool;
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
            eq(batch3.subList(0, manifestsToRetain)),
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
        AtomicInteger callCount = new AtomicInteger(0);  
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
import org.opensearch.index.translog.transfer.BlobStoreTransferService;  
        Settings invalidSettings = Settings.builder()
        });
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
        clusterApplierService = mock(ClusterApplierService.class);
        when(
        UploadedIndexMetadata index3Metadata = new UploadedIndexMetadata("index3", "indexUUID3", "index_metadata3__2");
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            }
        when(remoteClusterStateService.getBlobStore()).thenReturn(blobStore);
            // wait for stats to get updated
        });  
            .build();
import java.util.Locale;
        List<UploadedIndexMetadata> indicesRouting1 = List.of(index1Metadata);  
            .templatesMetadata(templateMetadata)  
        remoteClusterStateCleanupManager.start();  
import java.util.Collections;
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(  
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), anyInt())).thenReturn(
        when(
        long version = randomLongBetween(1, SKIP_CLEANUP_STATE_CHANGES);
            } finally {
        String clusterUUID = "clusterUUID";
        assertTrue(remoteClusterStateCleanupManager.getStaleFileDeletionTask().mustReschedule());  
            eq(clusterName),  
            manifest4,
        );  
        ClusterMetadataManifest manifest1 = ClusterMetadataManifest.builder()
    private ClusterApplierService clusterApplierService;
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING;
        int manifestsToRetain = RETAINED_MANIFESTS;  
            .committed(true)
            clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING),
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING;  
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        threadPool.shutdown();  
    public void testSingleConcurrentExecutionOfStaleManifestCleanup() throws Exception {
        for (int i = 0; i < manifestsToRetain - 2; i++) {  
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
        List<BlobMetadata> batch2 = new ArrayList<>();
        BlobContainer manifest2Container = mock(BlobContainer.class);
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());  
            clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING).intValue()  
            throw new RuntimeException(e);
            .stateVersion(1L)  
            batch2,
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        } catch (Exception e) {
        assertEquals(CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT, remoteClusterStateCleanupManager.getStaleFileCleanupInterval());  
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.MANIFEST_CLEANUP_BATCH_SIZE_DEFAULT;
import java.util.ArrayList;  
            remoteRoutingTableService
        AtomicInteger callCount = new AtomicInteger(0);
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
        Settings settings = Settings.builder()
        assertNotNull(remoteClusterStateCleanupManager.getStaleFileDeletionTask());
            .indices(List.of(index2Metadata))
        assertEquals(1, callCount.get());
        UploadedMetadataAttribute templateMetadata = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata");  
import org.opensearch.repositories.RepositoriesService;
        assertFalse(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isClosed());  
            eq(clusterUUID),
    private RemoteClusterStateCleanupManager remoteClusterStateCleanupManager;
        AtomicInteger callCount = new AtomicInteger(0);  
            // wait for stats to get updated
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V1;
import org.opensearch.common.settings.ClusterSettings;
        List<BlobMetadata> manifests = new ArrayList<>();
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);
        UploadedIndexMetadata index2Metadata = new UploadedIndexMetadata("index2", "indexUUID2", "index_metadata2__2");  
        ClusterMetadataManifest manifest1 = ClusterMetadataManifest.builder()  
    public void testRemoteClusterStateCleanupMaxBatchesSetting() {
            eq(clusterName),
        );
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN;  
        Set<String> staleManifest = new HashSet<>();  
        long version = randomLongBetween(SKIP_CLEANUP_STATE_CHANGES + 1, SKIP_CLEANUP_STATE_CHANGES + 10);
        doAnswer(invocation -> {  
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)  
            assertEquals(0L, spyManager.getLastCleanupAttemptStateVersion());
            try {  
            .coordinationMetadata(coordinationMetadataUpdated)  
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);
import static org.mockito.ArgumentMatchers.anyInt;
        int manifestsToRetain = RETAINED_MANIFESTS;
            .indices(List.of(index1Metadata))
        remoteClusterStateCleanupManager.start();
        );  
            assertEquals(1, remoteClusterStateCleanupManager.getStats().getIndicesRoutingDiffFileCleanupAttemptFailedCount());  
            ActionListener<Void> listener = invocation.getArgument(1);
        int batchSize = 100;  
    }
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
        when(clusterState.version()).thenReturn(randomLongBetween(11, 20));
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
            return null;
        ClusterMetadataManifest manifest7 = ClusterMetadataManifest.builder()
    }
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
import static org.mockito.Mockito.verify;  
            BlobPath blobPath1 = invocation.getArgument(0);
        Settings newSettings = Settings.builder().put("cluster.remote_store.state.cleanup.max_batches", maxBatches).build();
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(  
        int manifestsToRetain = RETAINED_MANIFESTS;
            .build();
        doAnswer(invocation -> callCount.incrementAndGet()).when(cleanUpManager)
            .templatesMetadata(templateMetadata)  
        List<UploadedIndexMetadata> indicesRouting1 = List.of(index1Metadata);
            COORDINATION_METADATA,  
        );
            .stateUUID(randomAlphaOfLength(10))
        assertEquals(0L, spyManager.getLastCleanupAttemptStateVersion());
            });
            remoteRoutingTableService  
 * this file be licensed under the Apache-2.0 license or a
        );  
        );
            .build();  
        assertEquals(
        assertEquals(0, callCount.get());
            .nodeId("nodeA")
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;
            .clusterUUID(clusterUUID)
            .stateVersion(1L)
        remoteClusterStateCleanupManager.start();
                throw new IllegalArgumentException("Unexpected blob path " + blobPath1);
        when(remoteClusterStateService.getThreadpool()).thenReturn(threadPool);  
            .nodeId("nodeA")  
            .nodes(RemoteClusterStateServiceTests.nodesWithLocalNodeClusterManager())
        when(remoteManifestManager.fetchRemoteClusterMetadataManifest(eq(clusterName), eq(clusterUUID), any())).thenReturn(
    private RepositoriesService repositoriesService;
            .coordinationMetadata(coordinationMetadataUpdated)  
        doThrow(IOException.class).when(remoteRoutingTableService).deleteStaleIndexRoutingDiffPaths(any());
    public void teardown() throws Exception {  
        );  
        remoteManifestManager = mock(RemoteManifestManager.class);
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
            new PlainBlobMetadata("manifest4.dat", 1L),
        );
                cleanUpManager.deleteStaleClusterMetadata(clusterName, clusterUUID, manifestsToRetain, 10);
        List<BlobMetadata> activeBlobs = Arrays.asList(new PlainBlobMetadata("manifest2.dat", 1L));  
        // verify default value
    public void testDeleteClusterMetadataNoOpsRoutingTableService() throws IOException {
            eq(manifests.subList(0, manifestsToRetain)),
            assertEquals(0, remoteClusterStateCleanupManager.getStats().getIndicesRoutingDiffFileCleanupAttemptFailedCount());
        remoteClusterStateCleanupManager.deleteStaleClusterMetadata("cluster-name", "cluster-uuid", RETAINED_MANIFESTS, 10);
            .templatesMetadata(templateMetadata)
            .indicesRouting(indicesRouting1)
        assertBusy(() -> {  
    public void testLastCleanupAttemptStateVersionUpdatedOnlyAfterCompletion() throws Exception {  
        CountDownLatch latch = new CountDownLatch(2);
            .templatesMetadata(templateMetadata)
        remoteClusterStateCleanupManager = new RemoteClusterStateCleanupManager(  
        remoteClusterStateCleanupManager.start();
            latch.countDown();  
            .coordinationMetadata(coordinationMetadataUpdated)
        clusterSettings.applySettings(newSettings);  
        assertEquals(1, callCount.get());  
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
            ActionListener<Void> listener = invocation.getArgument(1);
        );
            clusterService,  
        int newBatchSize = randomIntBetween(100, 5000);  
import static org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;
import org.opensearch.common.blobstore.BlobStore;
            anyString(),
            eq(clusterUUID),
    }
            .codecVersion(CODEC_V3)
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN;
            batch2.add(new PlainBlobMetadata("manifest" + (i + batchSize) + ".dat", 1L));  
    }
            manifests,  
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
        when(repositoriesService.repository("remote_store_repository")).thenReturn(blobStoreRepository);  
            eq(batch.subList(manifestsToRetain, batch.size()))
            manifest1,
        inactiveBlobs.forEach(
        when(blobStore.blobContainer(any())).then(invocation -> {
    private RemoteRoutingTableService remoteRoutingTableService;
            .settingMetadata(settingMetadataUpdated)  
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);  
            assertNotNull(remoteClusterStateCleanupManager.getStats());  
        cleanUpManager.deleteStaleClusterMetadata(clusterName, clusterUUID, manifestsToRetain, 10);
        ).thenReturn(List.of(new PlainBlobMetadata("mainfest2", 1L)));
        verify(cleanUpManager, times(maxBatches)).deleteClusterMetadata(  
            manifest1
            fail("deleteClusterMetadata should not be called when manifests < retained");
        }
        for (int i = 0; i < 15; i++) {  
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
            eq(batch1.subList(0, manifestsToRetain)),
            .indicesRouting(indicesRouting2)
        BlobContainer uuidContainerContainer = mock(BlobContainer.class);
            .indices(List.of(index1Metadata))  
        AsyncStaleFileDeletion task = new AsyncStaleFileDeletion(cleanUpManager);
            assertBusy(() -> {  
        remoteClusterStateCleanupManager.close();
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);  
        ClusterStateDiffManifest diffManifest2 = ClusterStateDiffManifest.builder().indicesRoutingDiffPath("index2RoutingDiffPath").build();
        doAnswer(invocation -> mockTransferService).when(cleanUpManager).getBlobStoreTransferService();  
import org.opensearch.cluster.routing.remote.RemoteRoutingTableService;
        for (int i = 100; i >= 1; i--) {
        }
            assertNotNull(remoteClusterStateCleanupManager.getStats());
            COORDINATION_METADATA,
            clusterSettings.get(RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING).intValue()  
            manifest2Container.listBlobsByPrefixInSortedOrder(
        }).when(blobContainer)
        // active manifest have reference to index1Updated, index2, settingsUpdated, coordinationUpdated, templates, templatesUpdated
            .put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), invalidBatchSize)  
            eq(clusterUUID),  
    @After
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.encodeString;  
            blob -> staleManifest.add(
    }
            .put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), batchSize)
        String clusterUUID = "clusterUUID";
            .coordinationMetadata(coordinationMetadata)
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            eq(batch.subList(0, manifestsToRetain)),  
            .globalMetadataFileName(null)
            .build();
            .routingTableVersion(0L)
                MANIFEST + DELIMITER,
        UploadedIndexMetadata index2Metadata = new UploadedIndexMetadata("index2", "indexUUID2", "index_metadata2__2");
        });
        doAnswer(invocation -> {
        assertThrows(
    private RemoteManifestManager remoteManifestManager;
                assertFalse(
        verifyNoMoreInteractions(container);  
            .stateUUID(randomAlphaOfLength(10))  
                )  
        List<BlobMetadata> inactiveBlobs = Arrays.asList(new PlainBlobMetadata("manifest1.dat", 1L));
            maxBatches,
        UploadedIndexMetadata index1UpdatedMetadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1_updated__2");
import org.opensearch.common.settings.Settings;
            .indices(List.of(index2Metadata))
            clusterService,  
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
            .stateVersion(1L)
            .nodeId("nodeA")
import org.opensearch.cluster.ClusterName;
        AbstractAsyncTask cleanupTask = remoteClusterStateCleanupManager.getStaleFileDeletionTask();
            } else if (blobPath1.buildAsString().contains("cluster-state/cluster-uuid2/")) {
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        String clusterUUID = "test-uuid";
        when(nodes.isLocalNodeElectedClusterManager()).thenReturn(true);
            .indices(List.of(index1Metadata))  
import static org.mockito.Mockito.when;
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
            List<String> filesToDelete = invocation.getArgument(0);
            batch3.add(new PlainBlobMetadata("manifest" + (i + 2 * batchSize) + ".dat", 1L));
            if (latch.await(5000, TimeUnit.SECONDS) == false) {  
        List<BlobMetadata> inactiveBlobs = Arrays.asList(new PlainBlobMetadata("manifest1.dat", 1L));
            clusterSettings.get(RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING).intValue()
            .committed(true)  
        ClusterMetadataManifest manifest1 = ClusterMetadataManifest.builder()
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
            .diffManifest(diffManifest2)  
                return manifest2Container;  
            .coordinationMetadata(coordinationMetadataUpdated)
            assertBusy(() -> {  
        long stateVersion = 20L;  
        clusterService = mock(ClusterService.class);  
    public void testIndexRoutingFilesCleanupFailureStats() throws Exception {
            .committed(true)  
        Settings newSettings = Settings.builder()  
    }  
        String stateRepoSettingsAttributeKeyPrefix = String.format(
        remoteClusterStateCleanupManager.start();
        cleanUpManager.start();
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.SKIP_CLEANUP_STATE_CHANGES;
        clusterSettings.applySettings(newSettings);
            any()  
        String clusterName = "test-cluster";  
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
                assertFalse(  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;  
            return null;
import java.util.concurrent.atomic.AtomicInteger;
        List<BlobMetadata> batch2 = new ArrayList<>();  
        );
import org.opensearch.test.VersionUtils;
        remoteClusterStateCleanupManager.deleteStaleUUIDsClusterMetadata("cluster1", Arrays.asList("cluster-uuid1"));
import java.util.Arrays;
            .indicesRouting(indicesRouting1)
        verify(cleanUpManager, times(1)).deleteClusterMetadata(
    }  
        );
                verify(manifest2Container, times(1)).delete();
import org.opensearch.cluster.service.ClusterApplierService;
}
            .settingMetadata(settingMetadata)
        String clusterUUID = "test-uuid";
            .stateUUID(randomAlphaOfLength(10))
    public void testBatchSizeValidation() {  
            .stateVersion(1L)
        verify(cleanUpManager, times(0)).deleteClusterMetadata(anyString(), anyString(), any(), any());
            manifest2
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)  
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
        CountDownLatch latch = new CountDownLatch(1);
        when(clusterState.nodes()).thenReturn(nodes);
            .stateUUID(randomAlphaOfLength(10))
            .templatesMetadata(templateMetadata)  
        }).when(cleanUpManager).deleteClusterMetadata(anyString(), anyString(), any(), any());  
import static org.mockito.Mockito.mock;  
            .stateUUID(randomAlphaOfLength(10))  
        repositoriesServiceSupplier = mock(Supplier.class);
            .stateVersion(1L)  
        doAnswer(invocation -> {  
            eq(clusterName),
            eq(clusterUUID),  
            .build();  
            .indices(List.of(index1UpdatedMetadata, index2Metadata))
        for (int i = 101; i >= 91; i--) {
import static org.mockito.ArgumentMatchers.any;
        assertEquals(newBatchSize, clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING).intValue());
        String clusterName = "test-cluster";
import java.util.HashSet;  
            .put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), batchSize)  
            ActionListener<Void> listener = invocation.getArgument(1);
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote_store_repository")  
        UploadedMetadataAttribute coordinationMetadataUpdated = new UploadedMetadataAttribute(
                Integer.MAX_VALUE,
            Locale.getDefault(),
        when(nodes.isLocalNodeElectedClusterManager()).thenReturn(false);  
        assertTrue(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isScheduled());  
        UploadedIndexMetadata index2Metadata = new UploadedIndexMetadata("index2", "indexUUID2", "index_metadata2__2");  
    public void testBatchedDeletionExhaustsMaxBatches() throws Exception {
        UploadedIndexMetadata index1Metadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1__2");
        );  
    public void testRemoteCleanupSkipsIfVersionIncrementLessThanThreshold() {  
        clusterSettings.applySettings(newSettings);  
        Settings newSettings = Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), batchSize).build();
import org.opensearch.repositories.fs.FsRepository;  
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)  
        doNothing().when(remoteRoutingTableService).deleteStaleIndexRoutingPaths(any());
            .indices(List.of(index2Metadata))
        });
 * SPDX-License-Identifier: Apache-2.0
            .indices(List.of(index1Metadata))
        ClusterMetadataManifest manifest3 = ClusterMetadataManifest.builder(manifest2)
        nodes = mock(DiscoveryNodes.class);
            remoteClusterStateService,
                // wait for stats to get updated
    public void testMaxBatchesSettingUpdate() {
            clusterService,
            .listBlobsByPrefixInSortedOrder(any(String.class), any(int.class), any(BlobContainer.BlobNameSortOrder.class));
            COORDINATION_METADATA,  
    }  
            .codecVersion(CODEC_V2)  
            .build();
        when(remoteManifestManager.fetchRemoteClusterMetadataManifest(eq(clusterName), eq(clusterUUID), any())).thenReturn(  
            manifests.add(new PlainBlobMetadata("manifest" + i + ".dat", 1L));
        clusterSettings.applySettings(newSettings);
            eq(batch1.subList(0, manifestsToRetain)),  
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        UploadedIndexMetadata index1Metadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1__2");  
        UploadedMetadataAttribute settingMetadata = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata");  
import java.util.Map;  
            remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval()  
        CountDownLatch completionLatch = new CountDownLatch(1);  
            manifest3,
            .clusterUUID("cluster-uuid1")
import org.opensearch.cluster.metadata.Metadata;  
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
            .stateVersion(1L)  
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());  
            .stateUUID(randomAlphaOfLength(10))
            ActionListener<Void> listener = invocation.getArgument(1);
        try {
        List<BlobMetadata> activeBlobs = Arrays.asList(new PlainBlobMetadata("manifest2.dat", 1L));
                completionLatch.countDown();  
            .stateUUID(randomAlphaOfLength(10))
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
    }
        when(remoteClusterStateService.getRemoteStateStats()).thenReturn(new RemotePersistenceStats());
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), anyInt())).thenReturn(manifests);
        } catch (Exception e) {  
            .build();
            .nodeId("nodeA")  
                );  
        when(metadata.clusterUUID()).thenReturn("testUUID");  
        // Task is still scheduled after the failure
            .settingMetadata(settingMetadata)
        assertEquals(
        UploadedIndexMetadata index1Metadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1__2");  
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
    public void testIndicesRoutingDiffFilesCleanupFailureStats() throws Exception {
        when(nodes.isLocalNodeElectedClusterManager()).thenReturn(true);
        latch.countDown();
            latch.countDown();
        BlobPath blobPath = new BlobPath().add("random-path");
            manifests.add(new PlainBlobMetadata("manifest" + i + ".dat", 1L));
            .build();
import org.opensearch.cluster.routing.remote.NoopRemoteRoutingTableService;  
        List<BlobMetadata> inactiveBlobs = Arrays.asList(new PlainBlobMetadata("manifest1.dat", 1L));  
            batch2.add(new PlainBlobMetadata("manifest-" + i + ".dat", 1L));
            eq(batch2.subList(manifestsToRetain, batch2.size()))
        ).thenReturn(List.of(new PlainBlobMetadata("mainfest3", 1L)));
            manifests,  
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
    }
        doAnswer(invocation -> {
        when(clusterState.version()).thenReturn(20L);
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);  
        ClusterMetadataManifest manifest6 = ClusterMetadataManifest.builder()
        assertEquals(
            .build();
        );  
        UploadedMetadataAttribute coordinationMetadata = new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination_metadata");
        remoteClusterStateCleanupManager.start();  
    }
        );  
        ClusterStateDiffManifest diffManifest1 = ClusterStateDiffManifest.builder().indicesRoutingDiffPath("index1RoutingDiffPath").build();
            .stateUUID(randomAlphaOfLength(10))
        CountDownLatch latch = new CountDownLatch(1);
        );
        CountDownLatch latch = new CountDownLatch(maxBatches);  
        remoteClusterStateCleanupManager.deleteStaleClusterUUIDs(clusterState, clusterMetadataManifest);
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);
        BlobPath blobPath = new BlobPath().add("random-path");
        cleanUpManager.deleteStaleClusterMetadata(clusterName, clusterUUID, manifestsToRetain, 10);  
        UploadedMetadataAttribute coordinationMetadataUpdated = new UploadedMetadataAttribute(
import static org.opensearch.gateway.remote.model.RemoteClusterMetadataManifest.MANIFEST;
        verify(cleanUpManager, times(1)).deleteClusterMetadata(
            () -> remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs)  
import static org.mockito.ArgumentMatchers.anyLong;  
            manifest2
            listener.onResponse(null);  
            .indicesRouting(indicesRouting1)  
        assertEquals(newInterval, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval());
        UploadedIndexMetadata index2Metadata = new UploadedIndexMetadata("index2", "indexUUID2", "index_metadata2__2");
        remoteClusterStateCleanupManager.start();  
        BlobPath blobPath = new BlobPath().add("random-path");  
            .clusterUUID(clusterUUID)
            .build();  
            .codecVersion(CODEC_V2)
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
        UploadedMetadataAttribute templateMetadata = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata");
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.RETAINED_MANIFESTS;
            .nodeId("nodeA")
            .clusterUUID(clusterUUID)  
        UploadedMetadataAttribute settingMetadata = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata");
            .build();
        }
                    "Attempted to delete manifests before index routing files " + filesToDelete,
import org.opensearch.common.blobstore.support.PlainBlobMetadata;  
        );
        String clusterName = "test-cluster";
    }
            .coordinationMetadata(coordinationMetadataUpdated)
                return manifest3Container;
        assertEquals(
            .routingTableVersion(0L)
        doAnswer(invocation -> mockTransferService).when(cleanUpManager).getBlobStoreTransferService();  
    private ClusterSettings clusterSettings;
            .indicesRouting(indicesRouting1)
public class RemoteClusterStateCleanupManagerTests extends OpenSearchTestCase {
        );  
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        List<BlobMetadata> activeBlobs = Arrays.asList(new PlainBlobMetadata("manifest2.dat", 1L));
            .clusterTerm(1L)
            RemoteClusterStateCleanupManager.MANIFEST_CLEANUP_MAX_BATCHES_DEFAULT,  
        String clusterName = "test-cluster";  
import org.opensearch.common.blobstore.BlobPath;
            .routingTableVersion(0L)
        IllegalArgumentException exception = expectThrows(  
    public void testDeleteStaleClusterUUIDs() throws IOException {
            .put(stateRepoSettingsAttributeKeyPrefix + "location", "randomRepoPath")  
            () -> remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs)  
            "coordination_metadata_updated"
        remoteClusterStateCleanupManager.start();
            eq(batch1.subList(manifestsToRetain, batch1.size()))
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
            assertNotNull(remoteClusterStateCleanupManager.getStats());  
        clusterSettings.applySettings(newSettings);
        List<BlobMetadata> batch3 = new ArrayList<>();
            .diffManifest(diffManifest2)
        verify(cleanUpManager, times(1)).deleteClusterMetadata(
/*  
            .routingTableVersion(0L)  
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING;
            new PlainBlobMetadata("manifest7.dat", 1L)  
import static org.mockito.ArgumentMatchers.anyString;
        );  
            .put(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING.getKey(), maxBatches)
            manifest3Container.listBlobsByPrefixInSortedOrder(  
    private RemoteClusterStateService remoteClusterStateService;  
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
            } else {  
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
            eq(manifests.subList(manifestsToRetain, manifests.size()))  
        for (int i = 0; i < batchSize; i++) {
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)  
        });
            eq(clusterUUID),  
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);  
            }
        }).when(container).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        assertBusy(() -> assertEquals(stateVersion, spyManager.getLastCleanupAttemptStateVersion()));  
            return null;
        assertEquals(MANIFEST_CLEANUP_BATCH_SIZE_DEFAULT, clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING).intValue());
        Settings newSettings = Settings.builder().put("cluster.remote_store.state.cleanup_interval", cleanupInterval + "s").build();
            });  
    }  
                assertEquals(0, remoteClusterStateCleanupManager.getStats().getUploadStats().getSuccessCount());  
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V3;  
        assertBusy(() -> {
        verify(remoteRoutingTableService).deleteStaleIndexRoutingDiffPaths(List.of("index1RoutingDiffPath"));
        remoteClusterStateCleanupManager.start();  
import java.util.List;
            .committed(true)
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);
        assertEquals(cleanupInterval, remoteClusterStateCleanupManager.getStaleFileCleanupInterval().seconds());  
        doAnswer(invocation -> {
            return null;
        UploadedMetadataAttribute templateMetadata = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata");  
            manifest2,  
            Locale.getDefault(),  
        List<BlobMetadata> activeBlobs = Arrays.asList(new PlainBlobMetadata("manifest2.dat", 1L));
        when(spyManager.getBlobStoreTransferService()).thenReturn(mockTransferService);
        List<UploadedIndexMetadata> indicesRouting1 = List.of(index1Metadata);
            // wait for stats to get updated
        BlobPath blobPath = new BlobPath().add("random-path");  
        assertBusy(() -> {  
        when(nodes.isLocalNodeElectedClusterManager()).thenReturn(true);  
            "coordination_metadata_updated"
        remoteClusterStateCleanupManager.start();
            .routingTableVersion(0L)
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            assertEquals(1, remoteClusterStateCleanupManager.getStats().getIndexRoutingFilesCleanupAttemptFailedCount());  
            eq(batch2.subList(0, manifestsToRetain)),
            .settingMetadata(settingMetadata)
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT;
            .routingTableVersion(0L)  
import org.junit.Before;  
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;  
import java.util.concurrent.CountDownLatch;
        UploadedMetadataAttribute coordinationMetadata = new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination_metadata");
        int manifestsToRetain = RETAINED_MANIFESTS;
        }
        int batchSize = 20;  
            .committed(true)
            "coordination_metadata_updated"  
                    settingMetadata.getUploadedFilename(),
            .coordinationMetadata(coordinationMetadataUpdated)  
            new PlainBlobMetadata("manifest6.dat", 1L)
            .build();
        String clusterUUID = "clusterUUID";
        doThrow(IOException.class).when(remoteRoutingTableService).deleteStaleIndexRoutingPaths(any());
        List<BlobMetadata> batch = new ArrayList<>();
            batch2.subList(1, batch2.size())
            .committed(true)  
        List<UploadedIndexMetadata> indicesRouting1 = List.of(index1Metadata);
        );
        List<BlobMetadata> manifests = new ArrayList<>();
        );
            .coordinationMetadata(coordinationMetadataUpdated)
            .clusterTerm(1L)
        doAnswer(invocation -> {
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        cleanUpManager.start();
        doAnswer(invocation -> callCount.incrementAndGet()).when(cleanUpManager)
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
        String clusterUUID = "clusterUUID";  
            .nodeId("nodeA")
        );  
        remoteClusterStateCleanupManager.start();  
            if (!filesToDelete.isEmpty()) {  
            COORDINATION_METADATA,
        remoteRoutingTableService = mock(InternalRemoteRoutingTableService.class);  
        List<UploadedIndexMetadata> indicesRouting2 = List.of(index2Metadata);  
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        doAnswer(invocation -> mockTransferService).when(cleanUpManager).getBlobStoreTransferService();
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
            assertEquals(0, remoteClusterStateCleanupManager.getStats().getIndexRoutingFilesCleanupAttemptFailedCount());
            )  
            .indicesRouting(indicesRouting2)
            "coordination_metadata_updated"  
            )
            batch1.add(new PlainBlobMetadata("manifest" + i + ".dat", 1L));
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(
        clusterState = mock(ClusterState.class);  
        Settings newSettings = Settings.builder()
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        }  
        );  
        final ClusterState clusterState = RemoteClusterStateServiceTests.generateClusterStateWithOneIndex()  
            .nodeId("nodeA")
        String clusterUUID = "clusterUUID";
        RemoteClusterStateCleanupManager spyManager = spy(remoteClusterStateCleanupManager);
            .indices(List.of(index1Metadata, index2Metadata))
        List<BlobMetadata> manifests = new ArrayList<>();  
            .deleteStaleClusterMetadata(any(), any(), anyInt(), anyLong());
            listener.onResponse(null);
                    coordinationMetadata.getUploadedFilename(),  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;  
        int maxBatches = randomIntBetween(10, 500);
        remoteClusterStateCleanupManager.start();
            "coordination_metadata_updated"
        assertTrue(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isScheduled());  
        task.run();
            .templatesMetadata(templateMetadataUpdated)
            }
 *
        when(clusterState.version()).thenReturn(version);
        UploadedMetadataAttribute coordinationMetadata = new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination_metadata");
            manifest5,  
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(new BlobPath().add("test"));
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)  
        when(blobStoreRepository.blobStore()).thenReturn(blobStore);
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(
        Set<String> uuids = new HashSet<>(Arrays.asList("cluster-uuid1", "cluster-uuid2", "cluster-uuid3"));  
    }  
 * The OpenSearch Contributors require contributions made to  
            .put(stateRepoTypeAttributeKey, FsRepository.TYPE)
        when(remoteClusterStateService.getAllClusterUUIDs(any())).thenReturn(uuids);
import static org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadataAttribute;
        );  
        when(remoteManifestManager.fetchRemoteClusterMetadataManifest(eq(clusterName), eq(clusterUUID), any())).thenReturn(  
            return null;
        Settings newSettings = Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), newBatchSize).build();
        super.tearDown();
        assertEquals(1, callCount.get());  
        remoteClusterStateService = mock(RemoteClusterStateService.class);  
            COORDINATION_METADATA,
                remoteClusterStateService.getRemoteManifestManager().getManifestFolderPath(clusterName, clusterUUID).buildAsString() + blob  
        assertNull(cleanupTask);
            .indices(List.of())
    public void testBatchedDeletionWithMultipleBatches() throws Exception {
    public void testDeleteStaleIndicesRoutingDiffFile() throws IOException {  
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
            eq(clusterName),
            .indices(List.of(index2Metadata))
        );
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
        int cleanupInterval = randomIntBetween(1, 10);  
            listener.onResponse(null);
            .clusterTerm(1L)
        spyManager.start();
        );
        }  
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        UploadedMetadataAttribute templateMetadata = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata");
        spyManager.cleanUpStaleFiles();
        remoteClusterStateCleanupManager.start();  
        repositoriesService = mock(RepositoriesService.class);  
    }
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
            IOException.class,
            MANIFEST_CLEANUP_MAX_BATCHES_DEFAULT,
    public void testBatchedDeletionWithOneNewManifest() throws Exception {
            return null;
        ClusterMetadataManifest clusterMetadataManifest = ClusterMetadataManifest.builder()  
            }
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
        );
            }
        remoteClusterStateCleanupManager.start();
            .build();
