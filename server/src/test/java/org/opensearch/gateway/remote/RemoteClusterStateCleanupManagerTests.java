import org.opensearch.cluster.metadata.Metadata;
        );
import static org.mockito.Mockito.doThrow;
            .deleteStaleClusterMetadata(any(), any(), anyInt(), anyLong());
        UploadedIndexMetadata index3Metadata = new UploadedIndexMetadata("index3", "indexUUID3", "index_metadata3__2");
        assertEquals(newMaxBatches, clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING).intValue());
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
            .indices(List.of(index1Metadata))
    }
    }
        Set<String> uuids = new HashSet<>(Arrays.asList("cluster-uuid1", "cluster-uuid2", "cluster-uuid3"));
        UploadedMetadataAttribute coordinationMetadataUpdated = new UploadedMetadataAttribute(
            .put("node.attr." + REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "remote_store_repository")
            .indicesRouting(indicesRouting2)
            .clusterTerm(1L)
        when(blobStoreRepository.blobStore()).thenReturn(blobStore);
            .diffManifest(diffManifest1)
        verify(remoteRoutingTableService).deleteStaleIndexRoutingPaths(List.of(index1Metadata.getUploadedFilename()));
        when(remoteClusterStateService.getRemoteStateStats()).thenReturn(new RemotePersistenceStats());
            .settingMetadata(settingMetadata)
            return null;
        ClusterMetadataManifest manifest1 = ClusterMetadataManifest.builder()
        when(nodes.isLocalNodeElectedClusterManager()).thenReturn(true);
            .build();
    private RemoteRoutingTableService remoteRoutingTableService;
    }
            .build();
        UploadedIndexMetadata index2Metadata = new UploadedIndexMetadata("index2", "indexUUID2", "index_metadata2__2");
import java.util.HashSet;
                verify(manifest3Container, times(1)).delete();
            ActionListener<Void> listener = invocation.getArgument(1);
                remoteClusterStateService.getRemoteManifestManager().getManifestFolderPath(clusterName, clusterUUID).buildAsString() + blob
            assertEquals(1, remoteClusterStateCleanupManager.getStats().getIndicesRoutingDiffFileCleanupAttemptFailedCount());
            eq(batch2.subList(0, manifestsToRetain)),
        String clusterUUID = "test-uuid";
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
            remoteRoutingTableService
        when(clusterState.metadata()).thenReturn(metadata);
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING;
        );
            manifest3,
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
 *
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.SKIP_CLEANUP_STATE_CHANGES;
        });
        UploadedMetadataAttribute coordinationMetadataUpdated = new UploadedMetadataAttribute(
        UploadedMetadataAttribute coordinationMetadata = new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination_metadata");
    public void setup() {
            manifest3Container.listBlobsByPrefixInSortedOrder(
            "remote_store_repository"
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
            eq(clusterUUID),
        doAnswer(invocation -> mockTransferService).when(cleanUpManager).getBlobStoreTransferService();
            manifest1,
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            batch2.add(new PlainBlobMetadata("manifest" + (i + batchSize) + ".dat", 1L));
        UploadedIndexMetadata index2Metadata = new UploadedIndexMetadata("index2", "indexUUID2", "index_metadata2__2");
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        }
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);
            .indices(List.of(index1Metadata))
            .codecVersion(CODEC_V2)
        when(remoteManifestManager.fetchRemoteClusterMetadataManifest(eq(clusterName), eq(clusterUUID), any())).thenReturn(
            remoteClusterStateService,
            COORDINATION_METADATA,
import org.junit.Before;
        doAnswer(invocation -> callCount.incrementAndGet()).when(cleanUpManager)
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.RETAINED_MANIFESTS;
            .indices(List.of(index2Metadata))
        UploadedMetadataAttribute settingMetadata = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata");
            .templatesMetadata(templateMetadata)
    private ClusterApplierService clusterApplierService;
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
        assertEquals(
        long version = randomLongBetween(1, SKIP_CLEANUP_STATE_CHANGES);
            .build();
        doAnswer(invocation -> {
        );
                    coordinationMetadata.getUploadedFilename(),
            .clusterTerm(1L)
        String clusterUUID = "test-uuid";
import org.opensearch.common.blobstore.BlobContainer;
        String clusterName = "test-cluster";
            .stateUUID(randomAlphaOfLength(10))
        );
        List<BlobMetadata> inactiveBlobs = Arrays.asList(new PlainBlobMetadata("manifest1.dat", 1L));
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.getFormattedIndexFileName;
            manifests.add(new PlainBlobMetadata("manifest" + i + ".dat", 1L));
        List<UploadedIndexMetadata> indicesRouting1 = List.of(index3Metadata, index4Metadata);
            "coordination_metadata_updated"
        );
        doAnswer(invocation -> callCount.incrementAndGet()).when(cleanUpManager)
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
        );
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), eq(batchSize))).thenReturn(
            manifest7,
        List<BlobMetadata> activeBlobs = Arrays.asList(new PlainBlobMetadata("manifest2.dat", 1L));
            .build();
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
                BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        // verify default value
            assertNotNull(remoteClusterStateCleanupManager.getStats());
            clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING).intValue()
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
        UploadedMetadataAttribute coordinationMetadata = new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination_metadata");
                assertFalse(
            new PlainBlobMetadata("manifest7.dat", 1L)
            .put(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING.getKey(), maxBatches)
            .stateVersion(1L)
            eq(batch1.subList(manifestsToRetain, batch1.size()))
        clusterSettings.applySettings(newSettings);
        ClusterMetadataManifest manifest1 = ClusterMetadataManifest.builder()
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
        remoteClusterStateService = mock(RemoteClusterStateService.class);
            return null;
        when(repositoriesService.repository("remote_store_repository")).thenReturn(blobStoreRepository);
        );
            .routingTableVersion(0L)
        when(clusterApplierService.state()).thenReturn(clusterState);
        Settings newSettings = Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING.getKey(), newMaxBatches).build();
        blobStoreRepository = mock(BlobStoreRepository.class);
            assertEquals(0, remoteClusterStateCleanupManager.getStats().getIndicesRoutingDiffFileCleanupAttemptFailedCount());
import java.util.function.Supplier;
    public void testUpdateCleanupIntervalDoesNotRescheduleWhenTaskScheduled() {
        doNothing().when(remoteRoutingTableService).deleteStaleIndexRoutingPaths(any());
        int maxBatches = 2;
            new PlainBlobMetadata("manifest5.dat", 1L),
        assertBusy(() -> {
        UploadedMetadataAttribute settingMetadata = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata");
            manifest2
        );
        verify(cleanUpManager, times(1)).deleteClusterMetadata(
            .clusterTerm(1L)
        ClusterMetadataManifest clusterMetadataManifest = ClusterMetadataManifest.builder()
            .clusterTerm(1L)
        when(remoteClusterStateService.getBlobStoreRepository()).thenReturn(blobStoreRepository);
            BlobPath blobPath1 = invocation.getArgument(0);
        clusterSettings.applySettings(newSettings);
            listener.onResponse(null);
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        threadPool.executor(ThreadPool.Names.REMOTE_PURGE).execute(() -> {
        when(clusterState.getClusterName()).thenReturn(new ClusterName("test"));
    @Before
        verify(cleanUpManager, times(1)).deleteClusterMetadata(
            .diffManifest(diffManifest1)
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING;
        UploadedIndexMetadata index1Metadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1__2");
            if (latch.await(5000, TimeUnit.SECONDS) == false) {
            .committed(true)
        String clusterUUID = "clusterUUID";
        );
        when(spyManager.getBlobStoreTransferService()).thenReturn(mockTransferService);
import org.opensearch.cluster.routing.remote.InternalRemoteRoutingTableService;
            .deleteStaleClusterMetadata(any(), any(), anyInt(), anyLong());
        assertBusy(() -> {
    public void testBatchSizeValidation() {
            .build();
            Locale.getDefault(),
            .build();
        when(blobStore.blobContainer(any())).thenReturn(container);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            .build();
        UploadedMetadataAttribute templateMetadata = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata");
        verify(cleanUpManager, times(0)).deleteClusterMetadata(anyString(), anyString(), any(), any());
        }
            .indicesRouting(indicesRouting1)
            .build();
        doAnswer(invocation -> {
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), eq(batchSize))).thenReturn(batch);
import org.opensearch.test.VersionUtils;
        remoteRoutingTableService = mock(NoopRemoteRoutingTableService.class);
            "node.attr." + REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX,
            return null;
    }
        remoteClusterStateCleanupManager.start();
            eq(batch2.subList(0, manifestsToRetain)),
        Settings newSettings = Settings.builder().put("cluster.remote_store.state.cleanup_interval", cleanupInterval + "s").build();
        remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs);
        when(remoteManifestManager.fetchRemoteClusterMetadataManifest(eq(clusterName), eq(clusterUUID), any())).thenReturn(
        doAnswer(invocation -> callCount.incrementAndGet()).when(cleanUpManager)
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
            .coordinationMetadata(coordinationMetadataUpdated)
            manifest6
 * The OpenSearch Contributors require contributions made to
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);
            .routingTableVersion(0L)
        assertEquals(newInterval, remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval());
        List<UploadedIndexMetadata> indicesRouting1 = List.of(index1Metadata);
            }
        when(clusterState.version()).thenReturn(20L);
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);
        remoteClusterStateCleanupManager = new RemoteClusterStateCleanupManager(
    }
            return Collections.emptyList();
    public void testRemoteCleanupCallsDeleteIfVersionIncrementGreaterThanThreshold() {
        UploadedMetadataAttribute settingMetadata = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata");
import static org.mockito.Mockito.times;
        verifyNoMoreInteractions(container);
        RemoteClusterStateCleanupManager spyManager = spy(remoteClusterStateCleanupManager);
            return null;
            .build();
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
            try {
    public void testIndicesRoutingDiffFilesCleanupFailureStats() throws Exception {
        } catch (Exception e) {
            eq(clusterUUID),
            )
        doAnswer(invocation -> {
        }).when(cleanUpManager).deleteClusterMetadata(anyString(), anyString(), any(), any());
        assertEquals(
            .globalMetadataFileName("global_metadata")
        List<BlobMetadata> batch = new ArrayList<>();
            "coordination_metadata_updated"
        }).when(cleanUpManager).deleteClusterMetadata(anyString(), anyString(), any(), any());
        remoteClusterStateCleanupManager.start();
        // verify update interval
                return manifest3Container;
            latch.countDown();
            .routingTableVersion(0L)
            return null;
            latch.countDown();
    private ClusterSettings clusterSettings;
        cleanUpManager.start();
            batch1.add(new PlainBlobMetadata("manifest-" + i + ".dat", 1L));
            } else {
            .clusterUUID(clusterUUID)
import org.opensearch.threadpool.ThreadPool;
        super.tearDown();
            listener.onResponse(null);
        int invalidBatchSize = randomIntBetween(1, RETAINED_MANIFESTS);
            .nodeId("nodeA")
            .build();
            return null;
        String clusterUUID = "clusterUUID";
        );
        remoteClusterStateCleanupManager.start();
        );
        assertTrue(task.isScheduled());
    }
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
            maxBatches,
            any()
            .nodeId("nodeA")
    public void testBatchedDeletionStopsWhenManifestsLessThanRetained() throws Exception {
        List<BlobMetadata> manifests = new ArrayList<>();
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        doAnswer(invocation -> {
        doAnswer(invocation -> mockTransferService).when(cleanUpManager).getBlobStoreTransferService();
            Locale.getDefault(),
            listener.onResponse(null);
        );
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(eq(new ArrayList<>(staleManifest)), any());
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);
            manifests,
        );
        ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder(manifest1)
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
            manifest4,
        List<BlobMetadata> manifests = new ArrayList<>();
            assertBusy(() -> {
            remoteRoutingTableService
        when(remoteManifestManager.fetchRemoteClusterMetadataManifest(eq(clusterName), eq(clusterUUID), any())).thenReturn(
        ClusterMetadataManifest manifest1 = ClusterMetadataManifest.builder()
                List.of(
        doAnswer(invocation -> mockTransferService).when(cleanUpManager).getBlobStoreTransferService();
        clusterService = mock(ClusterService.class);
import org.opensearch.repositories.fs.FsRepository;
            .stateUUID(randomAlphaOfLength(10))
        assertEquals(0L, spyManager.getLastCleanupAttemptStateVersion());
        );
        List<BlobMetadata> batch2 = new ArrayList<>();
import org.opensearch.common.blobstore.BlobMetadata;
            throw new RuntimeException("Test exception");
import static org.mockito.Mockito.spy;
        assertTrue(task.isScheduled());
            .committed(true)
    public void teardown() throws Exception {
        verify(cleanUpManager, times(1)).deleteClusterMetadata(
        remoteClusterStateCleanupManager.start();
    }
            // wait for stats to get updated
import java.util.Arrays;
        Settings newSettings = Settings.builder().put("cluster.remote_store.state.cleanup_interval", newInterval).build();
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
            .deleteStaleClusterMetadata(any(), any(), anyInt(), anyLong());
            eq(batch1.subList(0, manifestsToRetain)),
            .templatesMetadata(templateMetadata)
        remoteClusterStateCleanupManager.start();
            .put(stateRepoTypeAttributeKey, FsRepository.TYPE)
            .clusterStateCustomMetadataMap(Map.of("snapshots", new UploadedMetadataAttribute("snapshots", "snapshot_file1")))
import static org.mockito.Mockito.verifyNoMoreInteractions;
        ).thenReturn(List.of(new PlainBlobMetadata("mainfest2", 1L)));
                MANIFEST + DELIMITER,
        // Task is still scheduled after the failure
    private ClusterService clusterService;
            anyString(),
        cleanUpManager.start();
        task.run();
            new PlainBlobMetadata("manifest3.dat", 1L),
            callCount.incrementAndGet();
        assertBusy(() -> assertEquals(stateVersion, spyManager.getLastCleanupAttemptStateVersion()));
            .committed(true)
import static org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedIndexMetadata;
            eq(
        );
            .committed(true)
        int maxBatches = 3;
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        UploadedIndexMetadata index1UpdatedMetadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1_updated__2");
            .indices(List.of(index1Metadata))
        try {
        );
            manifest5,
            manifest2,
import static org.opensearch.gateway.remote.ClusterMetadataManifest.UploadedMetadataAttribute;
        when(
        BlobPath blobPath = new BlobPath().add("random-path");
            manifest2
        String clusterName = "test-cluster";
            .clusterUUID(clusterUUID)
        );
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(eq(List.of("restore_file1", "snapshot_file1")), any());
            .indicesRouting(indicesRouting1)
                    new BlobPath().add(GLOBAL_METADATA_PATH_TOKEN).buildAsString() + "global_metadata.dat"
import org.opensearch.common.blobstore.BlobPath;
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        );
        BlobContainer manifest3Container = mock(BlobContainer.class);
        remoteRoutingTableService = mock(InternalRemoteRoutingTableService.class);
import org.opensearch.common.blobstore.BlobStore;
            .build();
            blob -> staleManifest.add(
                // wait for stats to get updated
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.encodeString;
        clusterSettings.applySettings(newSettings);
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            .stateVersion(1L)
            });
        List<UploadedIndexMetadata> indicesRouting1 = List.of(index1Metadata);
            eq(manifests.subList(manifestsToRetain, manifests.size()))
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs);
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
            .stateUUID(randomAlphaOfLength(10))
            .stateVersion(1L)
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), anyInt())).thenReturn(
            manifest1
        task.run();
        cleanUpManager.cleanUpStaleFiles();
            return null;
    private ClusterState clusterState;
        String clusterUUID = "test-uuid";
            assertNotNull(remoteClusterStateCleanupManager.getStats());
                );
            eq(clusterName),
        }).when(container).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        repositoriesService = mock(RepositoriesService.class);
        ClusterStateDiffManifest diffManifest1 = ClusterStateDiffManifest.builder().indicesRoutingDiffPath("index1RoutingDiffPath").build();
        int maxBatches = randomIntBetween(10, 500);
                assertTrue(remoteClusterStateCleanupManager.getStats() != null);
            .put(REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING.getKey(), maxBatches)
            batch1.add(new PlainBlobMetadata("manifest" + i + ".dat", 1L));
        });
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
    }
            }
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
                    settingMetadata.getUploadedFilename(),
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
            .templatesMetadata(templateMetadata)
            clusterSettings.get(RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING).intValue()
        int manifestsToRetain = RETAINED_MANIFESTS;
        assertEquals(2, callCount.get());
import static org.mockito.ArgumentMatchers.eq;
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
    public void testRemoteStateCleanupFailureStats() throws IOException {
        remoteClusterStateCleanupManager.start();
        UploadedMetadataAttribute coordinationMetadata = new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination_metadata");
            IOException.class,
        int manifestsToRetain = RETAINED_MANIFESTS;
        List<BlobMetadata> inactiveBlobs = Arrays.asList(new PlainBlobMetadata("manifest1.dat", 1L));
            .settingMetadata(settingMetadata)
        });
            listener.onResponse(null);
        BlobPath blobPath = new BlobPath().add("random-path");
            eq(manifests.subList(0, manifestsToRetain)),
    public void testBatchedDeletionWithSingleBatch() throws Exception {
        String clusterName = "test-cluster";
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        remoteClusterStateCleanupManager.start();
import static org.mockito.ArgumentMatchers.anyLong;
        IllegalArgumentException exception = expectThrows(
            eq(List.of(getFormattedIndexFileName(index1Metadata.getUploadedFilePath()))),
    }
import java.util.List;
        UploadedMetadataAttribute templateMetadata = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata");
            )
            .coordinationMetadata(coordinationMetadataUpdated)
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
            listener.onResponse(null);
        );
public class RemoteClusterStateCleanupManagerTests extends OpenSearchTestCase {
        when(
            .settingMetadata(settingMetadata)
        AtomicInteger callCount = new AtomicInteger(0);
            remoteClusterStateCleanupManager.getStaleFileDeletionTask().getInterval()
            .stateUUID(randomAlphaOfLength(10))
import java.util.concurrent.CountDownLatch;
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        when(clusterState.version()).thenReturn(version);
        List<BlobMetadata> inactiveBlobs = Arrays.asList(new PlainBlobMetadata("manifest1.dat", 1L));
        threadPool.shutdown();
            .codecVersion(CODEC_V3)
                verify(manifest2Container, times(1)).delete();
        for (int i = 0; i < batchSize; i++) {
        ClusterStateDiffManifest diffManifest2 = ClusterStateDiffManifest.builder().indicesRoutingDiffPath("index2RoutingDiffPath").build();
            .build();
        final ClusterState clusterState = RemoteClusterStateServiceTests.generateClusterStateWithOneIndex()
import org.opensearch.common.unit.TimeValue;
            .nodeId("nodeA")
/*
            eq(batch.subList(0, manifestsToRetain)),
        assertTrue(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isScheduled());
        } catch (Exception e) {
            .indicesRouting(indicesRouting1)
        UploadedIndexMetadata index1Metadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1__1");
            fail("deleteClusterMetadata should not be called when manifests < retained");
        int manifestsToRetain = RETAINED_MANIFESTS;
        remoteClusterStateCleanupManager.start();
            callCount.incrementAndGet();
    }
        );
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V2;
        remoteClusterStateCleanupManager.start();
    }
import java.util.concurrent.atomic.AtomicInteger;
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.MANIFEST_CLEANUP_BATCH_SIZE_DEFAULT;
                assertFalse(
        );
    private Metadata metadata;
    }
        }).when(cleanUpManager).deleteClusterMetadata(anyString(), anyString(), any(), any());
            anyString(),
        int manifestsToRetain = RETAINED_MANIFESTS;
            .codecVersion(CODEC_V2)
        remoteClusterStateCleanupManager = new RemoteClusterStateCleanupManager(
        AtomicInteger callCount = new AtomicInteger(0);
            batch2,
            manifests,
        assertBusy(() -> {
            .coordinationMetadata(coordinationMetadataUpdated)
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
        when(remoteClusterStateService.getBlobStore()).thenReturn(blobStore);
        for (int i = 101; i >= 91; i--) {
import static org.opensearch.gateway.remote.model.RemoteClusterMetadataManifest.MANIFEST;
    public void testLastCleanupAttemptStateVersionNotUpdatedOnFailure() throws Exception {
    public void testLastCleanupAttemptStateVersionUpdatedOnlyAfterCompletion() throws Exception {
import org.opensearch.core.action.ActionListener;
        assertThrows(
    }
import static org.mockito.ArgumentMatchers.anyInt;
        );
        assertTrue(remoteClusterStateCleanupManager.getStaleFileDeletionTask().mustReschedule());
        BlobPath blobPath = new BlobPath().add("random-path");
            remoteRoutingTableService
        assertEquals(0, callCount.get());
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
        cleanUpManager.start();
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
        AtomicInteger callCount = new AtomicInteger(0);
        long version = randomLongBetween(SKIP_CLEANUP_STATE_CHANGES + 1, SKIP_CLEANUP_STATE_CHANGES + 10);
        doAnswer(invocation -> {
import static org.mockito.Mockito.doAnswer;
    }
 * this file be licensed under the Apache-2.0 license or a
            latch.countDown();
            .codecVersion(CODEC_V1)
        long stateVersion = 20L;
        cleanUpManager.start();
            if (!filesToDelete.isEmpty()) {
        for (int i = 0; i < 15; i++) {
        List<BlobMetadata> batch2 = new ArrayList<>();
    }
        doAnswer(invocation -> {
            ActionListener<Void> listener = invocation.getArgument(1);
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
        }
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        UploadedMetadataAttribute coordinationMetadataUpdated = new UploadedMetadataAttribute(
            manifests.add(new PlainBlobMetadata("manifest" + i + ".dat", 1L));
        );
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
        String clusterUUID = "test-uuid";
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
            .nodeId("nodeA")
            manifest1
            .indicesRouting(indicesRouting1)
        assertTrue(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isScheduled());
            return null;
            eq(clusterName),
        remoteClusterStateCleanupManager.deleteStaleUUIDsClusterMetadata("cluster1", Arrays.asList("cluster-uuid1"));
        }).when(cleanUpManager).deleteClusterMetadata(anyString(), anyString(), any(), any());
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
            .indicesRouting(indicesRouting2)
            COORDINATION_METADATA,
            List<String> filesToDelete = invocation.getArgument(0);
        List<UploadedIndexMetadata> indicesRouting1 = List.of(index1Metadata);
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
            .indices(List.of(index1Metadata))
        when(clusterState.nodes()).thenReturn(nodes);
            .build();
        repositoriesServiceSupplier = mock(Supplier.class);
        String clusterUUID = "clusterUUID";
        cleanUpManager.deleteStaleClusterMetadata(clusterName, clusterUUID, manifestsToRetain, 10);
            any()
    public void testSingleConcurrentExecutionOfStaleManifestCleanup() throws Exception {
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
            .coordinationMetadata(coordinationMetadataUpdated)
        cleanUpManager.cleanUpStaleFiles();
        UploadedMetadataAttribute settingMetadataUpdated = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata_updated");
        when(nodes.isLocalNodeElectedClusterManager()).thenReturn(true);
        String clusterUUID = "clusterUUID";
        RemoteClusterStateCleanupManager spyManager = spy(remoteClusterStateCleanupManager);
    private RemoteClusterStateService remoteClusterStateService;
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        List<UploadedIndexMetadata> indicesRouting2 = List.of(index2Metadata);
            eq(clusterName),
        assertTrue(task.isScheduled());
            .put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), invalidBatchSize)
        assertEquals(0L, spyManager.getLastCleanupAttemptStateVersion());
        for (int i = 0; i < manifestsToRetain - 2; i++) {
            .nodeId("nodeA")
            return null;
        ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder(manifest1)
        UploadedMetadataAttribute templateMetadata = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata");
            eq(batch.subList(manifestsToRetain, batch.size()))
            }
        );
        doAnswer(invocationOnMock -> {
        }
            .stateVersion(1L)
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        List<UploadedIndexMetadata> indicesRouting2 = List.of(index2Metadata);
        ClusterMetadataManifest manifest5 = ClusterMetadataManifest.builder(manifest4).templatesMetadata(templateMetadataUpdated).build();
        List<BlobMetadata> batch1 = new ArrayList<>();
import org.opensearch.test.OpenSearchTestCase;
        verify(cleanUpManager, times(1)).deleteClusterMetadata(
            manifest2,
            .listBlobsByPrefixInSortedOrder(any(String.class), any(int.class), any(BlobContainer.BlobNameSortOrder.class));
        try {
        );
            .settingMetadata(settingMetadataUpdated)
        List<UploadedIndexMetadata> indicesRouting2 = List.of(index4Metadata);
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
        List<UploadedIndexMetadata> indicesRouting2 = List.of(index2Metadata);
        String clusterName = "test-cluster";
            .build();
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V3;
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
                return manifest2Container;
            listener.onResponse(null);
                throw new Exception("Timed out waiting for delete task queuing to complete");
            new PlainBlobMetadata("manifest6.dat", 1L)
                )
            .clusterUUID(clusterUUID)
            clusterService,
                BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC
        }).when(blobContainer)
                return uuidContainerContainer;
            eq(batch2.subList(manifestsToRetain, batch2.size()))
        ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder(manifest1)
        when(remoteManifestManager.fetchRemoteClusterMetadataManifest(eq(clusterName), eq(clusterUUID), any())).thenReturn(
                );
        cleanUpManager.deleteStaleClusterMetadata(clusterName, clusterUUID, manifestsToRetain, 10);
        when(nodes.isLocalNodeElectedClusterManager()).thenReturn(true);
            .diffManifest(diffManifest2)
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
        when(remoteClusterStateService.getAllClusterUUIDs(any())).thenReturn(uuids);
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), eq(batchSize))).thenReturn(batch1, batch2, batch3);
            eq(clusterUUID),
    }
            batch.add(new PlainBlobMetadata("manifest" + i + ".dat", 1L));
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        assertEquals(
            .clusterTerm(1L)
        );
        CountDownLatch latch = new CountDownLatch(1);
        assertEquals(0L, spyManager.getLastCleanupAttemptStateVersion());
    public void testRemoteCleanupSchedulesEvenAfterFailure() {
            .clusterUUID(clusterUUID)
    private Supplier<RepositoriesService> repositoriesServiceSupplier;
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);
            if (blobPath1.buildAsString().endsWith("cluster-state/")) {
        assertNotNull(remoteClusterStateCleanupManager.getStaleFileDeletionTask());
            "coordination_metadata_updated"
            .indices(List.of(index2Metadata))
        );
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
            eq(clusterUUID),
            () -> remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs)
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
            assertEquals(0L, spyManager.getLastCleanupAttemptStateVersion());
            } finally {
            .committed(true)
        doAnswer(invocation -> {
        List<BlobMetadata> manifests = new ArrayList<>();
import java.util.Locale;
            manifests.subList(0, RETAINED_MANIFESTS)
        when(metadata.clusterUUID()).thenReturn("testUUID");
        UploadedMetadataAttribute templateMetadataUpdated = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata_updated");
        for (int i = 0; i < batchSize; i++) {
            .indices(List.of(index2Metadata))
import java.util.ArrayList;
            .clusterUUID(clusterUUID)
        List<BlobMetadata> activeBlobs = Arrays.asList(new PlainBlobMetadata("manifest2.dat", 1L));
import java.util.Map;
            eq(batch3.subList(manifestsToRetain, batch3.size()))
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        BlobStoreTransferService mockTransferService = mock(BlobStoreTransferService.class);
        );
            .indices(List.of(index2Metadata))
        });
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.GLOBAL_METADATA_PATH_TOKEN;
        DiscoveryNodes nodes = mock(DiscoveryNodes.class);
            "coordination_metadata_updated"
        metadata = mock(Metadata.class);
        assertEquals(MANIFEST_CLEANUP_BATCH_SIZE_DEFAULT, clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING).intValue());
        Settings newSettings = Settings.builder()
    public void testDeleteStaleIndicesRoutingDiffFile() throws IOException {
            .indices(List.of(index2Metadata))
        List<UploadedIndexMetadata> indicesRouting2 = List.of(index2Metadata);
 */
        ClusterMetadataManifest manifest6 = ClusterMetadataManifest.builder()
        String clusterUUID = "clusterUUID";
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING;
        doAnswer(invocation -> {
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
    }
import org.opensearch.cluster.service.ClusterApplierService;
            .build();
            .nodeId("nodeA")
        List<BlobMetadata> inactiveBlobs = Arrays.asList(new PlainBlobMetadata("manifest1.dat", 1L));
        String clusterName = "test-cluster";
        doThrow(new IOException("Test failure")).when(spyManager).deleteClusterMetadata(any(), any(), any(), any());
        List<BlobMetadata> activeBlobs = Arrays.asList(new PlainBlobMetadata("manifest2.dat", 1L));
            .build();
        latch.countDown();
    public void testDeleteClusterMetadataNoOpsRoutingTableService() throws IOException {
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
            manifest2Container.listBlobsByPrefixInSortedOrder(
        assertTrue(exception.getCause().getMessage().contains("Cleanup Batch Size should be greater than [" + RETAINED_MANIFESTS + "]"));
            .previousClusterUUID(ClusterState.UNKNOWN_UUID)
                throw new IllegalArgumentException("Unexpected blob path " + blobPath1);
        );
                completionLatch.countDown();
            .indicesRouting(indicesRouting2)
import static org.opensearch.gateway.remote.model.RemotePersistentSettingsMetadata.SETTING_METADATA;
        clusterSettings.applySettings(newSettings);
                cleanUpManager.deleteStaleClusterMetadata(clusterName, clusterUUID, manifestsToRetain, 10);
        }
        when(clusterApplierService.state()).thenReturn(clusterState);
        assertEquals(0, callCount.get());
            eq(clusterUUID),
            List<String> filesToDelete = invocation.getArgument(0);
        doAnswer(invocation -> mockTransferService).when(cleanUpManager).getBlobStoreTransferService();
            if (!filesToDelete.isEmpty()) {
    public void testRemoteCleanupSkipsOnOnlyElectedClusterManager() {
            ),
                assertEquals(0, remoteClusterStateCleanupManager.getStats().getUploadStats().getSuccessCount());
                Integer.MAX_VALUE,
        }
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
            } else if (blobPath1.buildAsString().contains("cluster-state/cluster-uuid3/")) {
        assertEquals(1, callCount.get());
            clusterService,
        assertTrue(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isScheduled());
        List<BlobMetadata> batch1 = new ArrayList<>();
            .settingMetadata(settingMetadata)
    }
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
            }
        Set<String> staleManifest = new HashSet<>();
            .stateUUID(randomAlphaOfLength(10))
        List<UploadedIndexMetadata> indicesRouting1 = List.of(index1Metadata);
            .routingTableVersion(0L)
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
        String stateRepoSettingsAttributeKeyPrefix = String.format(
        String clusterName = "test-cluster";
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), anyInt())).thenReturn(
            manifest1,
            .put(stateRepoSettingsAttributeKeyPrefix + "location", "randomRepoPath")
        int batchSize = 100;
        when(nodes.isLocalNodeElectedClusterManager()).thenReturn(true);
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
            eq(clusterName),
        ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder(manifest1)
    public void testBatchedDeletionWithMultipleBatches() throws Exception {
            return null;
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(new BlobPath().add("test"));
            "coordination_metadata_updated"
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
            batch3.add(new PlainBlobMetadata("manifest" + (i + 2 * batchSize) + ".dat", 1L));
        }
            throw new RuntimeException(e);
    }
        remoteClusterStateCleanupManager.close();
        String clusterName = "test-cluster";
            eq(batch3.subList(0, manifestsToRetain)),
            .build();
        List<BlobMetadata> inactiveBlobs = Arrays.asList(
            () -> remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs)
        List<BlobMetadata> activeBlobs = Arrays.asList(
            eq(clusterName),
            ActionListener<Void> listener = invocation.getArgument(1);
        int newBatchSize = randomIntBetween(100, 5000);
        doThrow(IOException.class).when(blobContainer).delete();
        }
    public void testBatchSizeSettingUpdate() {
        );
            new PlainBlobMetadata("manifest1.dat", 1L),
        String clusterName = "test-cluster";
            .diffManifest(diffManifest2)
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
            assertEquals(0, remoteClusterStateCleanupManager.getStats().getIndexRoutingFilesCleanupAttemptFailedCount());
        ClusterMetadataManifest manifest1 = ClusterMetadataManifest.builder()
        UploadedMetadataAttribute templateMetadata = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata");
            remoteClusterStateService,
        clusterApplierService = mock(ClusterApplierService.class);
        ClusterStateDiffManifest diffManifest1 = ClusterStateDiffManifest.builder().indicesRoutingDiffPath("index1RoutingDiffPath").build();
        assertEquals(cleanupInterval, remoteClusterStateCleanupManager.getStaleFileCleanupInterval().seconds());
        }).when(spyManager).deleteClusterMetadata(any(), any(), any(), any());
            .nodes(RemoteClusterStateServiceTests.nodesWithLocalNodeClusterManager())
            eq(clusterUUID),
import org.opensearch.threadpool.TestThreadPool;
        doAnswer(invocation -> mockTransferService).when(cleanUpManager).getBlobStoreTransferService();
import org.opensearch.cluster.node.DiscoveryNodes;
import static org.mockito.Mockito.verify;
            .codecVersion(CODEC_V3)
        );
        );
        Settings newSettings = Settings.builder().put("cluster.remote_store.state.cleanup.max_batches", maxBatches).build();
            eq(batch2.subList(manifestsToRetain, batch2.size()))
        remoteClusterStateCleanupManager.start();
    public void testIndexRoutingFilesCleanupFailureStats() throws Exception {
        BlobPath blobPath = new BlobPath().add("random-path");
        remoteClusterStateCleanupManager.start();
        for (int i = 100; i >= 1; i--) {
            .clusterTerm(1L)
        remoteClusterStateCleanupManager.start();
                    filesToDelete.getFirst().contains("manifest")
        ClusterMetadataManifest manifest4 = ClusterMetadataManifest.builder(manifest3)
            "remote_store_repository"
    }
            .committed(true)
        cleanUpManager.deleteStaleClusterMetadata(clusterName, clusterUUID, manifestsToRetain, 20);
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
            .stateVersion(1L)
            .build();
        verify(cleanUpManager, times(1)).deleteClusterMetadata(
import static org.opensearch.gateway.remote.ClusterMetadataManifest.CODEC_V1;
        when(remoteManifestManager.fetchRemoteClusterMetadataManifest(eq(clusterName), eq(clusterUUID), any())).thenReturn(
        );
            return null;
        doNothing().when(remoteRoutingTableService).deleteStaleIndexRoutingDiffPaths(any());
        clusterSettings.applySettings(newSettings);
        ClusterMetadataManifest manifest2 = ClusterMetadataManifest.builder(manifest1)
        UploadedMetadataAttribute coordinationMetadata = new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination_metadata");
}
            latch.countDown();
        BlobContainer uuidContainerContainer = mock(BlobContainer.class);
            COORDINATION_METADATA,
        when(clusterState.nodes()).thenReturn(nodes);
        ClusterMetadataManifest manifest3 = ClusterMetadataManifest.builder(manifest2)
            RemoteClusterStateCleanupManager.MANIFEST_CLEANUP_MAX_BATCHES_DEFAULT,
    }
        UploadedIndexMetadata index1Metadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1__2");
        // Task is still scheduled after the failure
        });
            manifests.subList(0, manifestsToRetain)
        AsyncMultiStreamBlobContainer blobContainer = mock(AsyncMultiStreamBlobContainer.class);
        clusterSettings.applySettings(newSettings);
        assertBusy(() -> {
        BlobContainer manifest2Container = mock(BlobContainer.class);
        remoteClusterStateCleanupManager.start();
            .committed(true)
        blobStore = mock(BlobStore.class);
import static org.opensearch.gateway.remote.model.RemoteCoordinationMetadata.COORDINATION_METADATA;
        doAnswer(invocation -> {
import org.junit.After;
            // wait for stats to get updated
        verify(remoteRoutingTableService).deleteStaleIndexRoutingDiffPaths(List.of("index1RoutingDiffPath"));
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
            .clusterStateCustomMetadataMap(Map.of("restore", new UploadedMetadataAttribute("restore", "restore_file1")))
        ClusterStateDiffManifest diffManifest2 = ClusterStateDiffManifest.builder().indicesRoutingDiffPath("index2RoutingDiffPath").build();
import org.opensearch.cluster.routing.remote.NoopRemoteRoutingTableService;
    }
        remoteClusterStateCleanupManager.start();
        );
            IllegalArgumentException.class,
        UploadedIndexMetadata index2Metadata = new UploadedIndexMetadata("index2", "indexUUID2", "index_metadata2__2");
        clusterSettings.applySettings(newSettings);
            assertBusy(() -> {
        doThrow(IOException.class).when(remoteRoutingTableService).deleteStaleIndexRoutingDiffPaths(any());
    private DiscoveryNodes nodes;
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
        remoteClusterStateCleanupManager.start();
        UploadedIndexMetadata index1Metadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1__2");
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
            .settingMetadata(settingMetadataUpdated)
    }
            latch.countDown();
            .put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), batchSize)
import org.opensearch.common.settings.ClusterSettings;
        );
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
                    "Attempted to delete manifests before index routing files " + filesToDelete,
            ActionListener<Void> listener = invocation.getArgument(1);
        AbstractAsyncTask cleanupTask = remoteClusterStateCleanupManager.getStaleFileDeletionTask();
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
        List<BlobMetadata> batch3 = new ArrayList<>();
        }).when(cleanUpManager).deleteClusterMetadata(anyString(), anyString(), any(), any());
        }).when(blobContainer).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        assertBusy(() -> assertEquals(1, callCount.get()));
        doAnswer(invocation -> {
        String clusterName = "test-cluster";
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
        UploadedIndexMetadata index2Metadata = new UploadedIndexMetadata("index2", "indexUUID2", "index_metadata2__2");
        UploadedMetadataAttribute settingMetadata = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata");
            .put(RemoteClusterStateService.REMOTE_CLUSTER_STATE_ENABLED_SETTING.getKey(), true)
        CountDownLatch latch = new CountDownLatch(1);
        int manifestsToRetain = RETAINED_MANIFESTS;
        );
            .stateUUID(randomAlphaOfLength(10))
            } else if (blobPath1.buildAsString().contains("cluster-state/cluster-uuid2/")) {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_SETTINGS_ATTRIBUTE_KEY_PREFIX;
import static org.mockito.ArgumentMatchers.any;
        );
        remoteClusterStateCleanupManager.deleteStaleClusterUUIDs(clusterState, clusterMetadataManifest);
        CountDownLatch latch = new CountDownLatch(1);
import static org.opensearch.gateway.remote.model.RemoteTemplatesMetadata.TEMPLATES_METADATA;
                    // coordination/setting metadata is from CODEC_V2, the uploaded filename with contain the complete path
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
            .clusterStateCustomMetadataMap(Map.of())
        UploadedMetadataAttribute settingMetadata = new UploadedMetadataAttribute(SETTING_METADATA, "settings_metadata");
            .opensearchVersion(VersionUtils.randomOpenSearchVersion(random()))
import static org.mockito.Mockito.mock;
        ClusterMetadataManifest manifest7 = ClusterMetadataManifest.builder()
        BlobContainer blobContainer = mock(BlobContainer.class);
        int batchSize = 50;
            .templatesMetadata(templateMetadataUpdated)
        remoteClusterStateCleanupManager.deleteStaleClusterMetadata("cluster-name", "cluster-uuid", RETAINED_MANIFESTS, 10);
        Settings settings = Settings.builder()
        inactiveBlobs.forEach(
            .indicesRouting(indicesRouting2)
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.AsyncStaleFileDeletion;
package org.opensearch.gateway.remote;
        UploadedIndexMetadata index1Metadata = new UploadedIndexMetadata("index1", "indexUUID1", "index_metadata1__2");
        }
            .indices(List.of())
    private RemoteClusterStateCleanupManager remoteClusterStateCleanupManager;
        clusterSettings.applySettings(newSettings);
        assertTrue(completionLatch.await(5, TimeUnit.SECONDS));
            .templatesMetadata(templateMetadata)
        // active manifest have reference to index1Updated, index2, settingsUpdated, coordinationUpdated, templates, templatesUpdated
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(
        remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs);
            .settingMetadata(settingMetadataUpdated)
        when(remoteClusterStateService.getRemoteManifestManager()).thenReturn(remoteManifestManager);
        CountDownLatch latch = new CountDownLatch(2);
        for (int i = 0; i < 15; i++) {
import java.util.Set;
            clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_INTERVAL_SETTING),
    public void testRemoteClusterStateCleanupSetting() {
        int batchSize = 20;
                    .name()
            eq(batch1.subList(0, manifestsToRetain)),
        nodes = mock(DiscoveryNodes.class);
            .stateUUID(randomAlphaOfLength(10))
                    filesToDelete.getFirst().contains("manifest")
    public void testBatchedDeletionExhaustsMaxBatches() throws Exception {
        AtomicInteger callCount = new AtomicInteger(0);
        BlobPath blobPath = new BlobPath().add("random-path");
import org.opensearch.cluster.ClusterState;
    }
        spyManager.start();
        when(nodes.isLocalNodeElectedClusterManager()).thenReturn(false);
        when(blobStore.blobContainer(any())).then(invocation -> {
    public void testDeleteClusterMetadata() throws IOException {
                assertEquals(1, remoteClusterStateCleanupManager.getStats().getCleanupAttemptFailedCount());
        });
    public void testRemoteCleanupTaskScheduled() {
        remoteClusterStateCleanupManager.deleteStaleClusterMetadata("cluster-name", "cluster-uuid", RETAINED_MANIFESTS, 10);
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.MANIFEST_CLEANUP_MAX_BATCHES_DEFAULT;
        assertEquals(newBatchSize, clusterSettings.get(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING).intValue());
        UploadedIndexMetadata index2Metadata = new UploadedIndexMetadata("index2", "indexUUID2", "index_metadata2__2");
            .clusterUUID(clusterUUID)
            .coordinationMetadata(coordinationMetadata)
            listener.onResponse(null);
            });
import java.io.IOException;
import java.util.concurrent.TimeUnit;
            () -> { clusterSettings.applySettings(invalidSettings); }
        Settings newSettings = Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), newBatchSize).build();
                    "Attempted to delete manifests before index routing files " + filesToDelete,
        );
        cleanUpManager.cleanUpStaleFiles();
        clusterState = mock(ClusterState.class);
            new PlainBlobMetadata("manifest4.dat", 1L),
            ActionListener<Void> listener = invocation.getArgument(1);
 * compatible open source license.
    public void testRemoteClusterStateCleanupMaxBatchesSetting() {
        ClusterMetadataManifest manifest1 = ClusterMetadataManifest.builder()
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
        assertFalse(remoteClusterStateCleanupManager.getStaleFileDeletionTask().isClosed());
        remoteClusterStateCleanupManager = new RemoteClusterStateCleanupManager(
            batch2.subList(1, batch2.size())
            throw new RuntimeException(e);
import static org.mockito.Mockito.doNothing;
        int newMaxBatches = randomIntBetween(10, 500);
            eq(clusterName),
        remoteManifestManager = mock(RemoteManifestManager.class);
        );
        );
        int cleanupInterval = randomIntBetween(1, 10);
        UploadedMetadataAttribute templateMetadata = new UploadedMetadataAttribute(TEMPLATES_METADATA, "template_metadata");
            MANIFEST_CLEANUP_MAX_BATCHES_DEFAULT,
        AsyncStaleFileDeletion task = new AsyncStaleFileDeletion(cleanUpManager);
import org.opensearch.cluster.ClusterName;
        when(clusterState.version()).thenReturn(version);
        CountDownLatch latch = new CountDownLatch(maxBatches);
    }
            manifest2,
        when(remoteClusterStateService.getThreadpool()).thenReturn(threadPool);
            }
            .clusterTerm(1L)
        );
            COORDINATION_METADATA,
import org.opensearch.cluster.routing.remote.RemoteRoutingTableService;
            clusterSettings.get(RemoteClusterStateCleanupManager.REMOTE_CLUSTER_STATE_CLEANUP_MAX_BATCHES_SETTING).intValue()
            .clusterUUID("cluster-uuid1")
            COORDINATION_METADATA,
    public void testBatchedDeletionWithOneNewManifest() throws Exception {
            .build();
            .coordinationMetadata(coordinationMetadataUpdated)
            .committed(true)
        spyManager.deleteStaleClusterMetadata(clusterName, clusterUUID, RETAINED_MANIFESTS, stateVersion);
            manifest1,
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN;
    }
            assertEquals(1, remoteClusterStateCleanupManager.getStats().getIndexRoutingFilesCleanupAttemptFailedCount());
        List<BlobMetadata> activeBlobs = Arrays.asList(new PlainBlobMetadata("manifest2.dat", 1L));
        UploadedMetadataAttribute coordinationMetadataUpdated = new UploadedMetadataAttribute(
        CountDownLatch latch = new CountDownLatch(maxBatches);
            .codecVersion(CODEC_V2)
            return null;
        String clusterName = "test-cluster";
import org.opensearch.repositories.RepositoriesService;
            .build();
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
        doAnswer(invocation -> {
            // wait for stats to get updated
        Settings newSettings = Settings.builder()
        doAnswer(invocation -> {
            ActionListener<Void> listener = invocation.getArgument(1);
            .stateUUID(randomAlphaOfLength(10))
        String stateRepoTypeAttributeKey = String.format(
            .nodeId("nodeA")
        );
    }
            .clusterTerm(1L)
        doAnswer(invocation -> {
        // using spied cleanup manager so that stubbed deleteStaleClusterMetadata is called
            new PlainBlobMetadata("manifest2.dat", 1L),
import org.opensearch.common.settings.Settings;
            .indicesRouting(indicesRouting2)
            manifests.add(new PlainBlobMetadata("manifest" + i + ".dat", 1L));
        );
import static org.mockito.ArgumentMatchers.anyString;
        remoteClusterStateCleanupManager.start();
            .indices(List.of(index1UpdatedMetadata, index2Metadata))
        verify(cleanUpManager, times(1)).deleteClusterMetadata(
        cleanUpManager.start();
    @After
            .coordinationMetadata(coordinationMetadataUpdated)
            .routingTableVersion(0L)
        String clusterUUID = "test-uuid";
        when(mockTransferService.listAllInSortedOrder(any(), eq(MANIFEST), anyInt())).thenReturn(manifests);
            .coordinationMetadata(coordinationMetadataUpdated)
    private BlobStore blobStore;
        assertEquals(
            eq(batch1.subList(manifestsToRetain, batch1.size()))
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    private RemoteManifestManager remoteManifestManager;
        BlobPath blobPath = new BlobPath().add("random-path");
            remoteClusterStateService,
            .nodeId("nodeA")
        when(clusterState.nodes()).thenReturn(nodes);
 * SPDX-License-Identifier: Apache-2.0
        cleanUpManager.deleteStaleClusterMetadata(clusterName, clusterUUID, manifestsToRetain, 10);
        RemoteClusterStateCleanupManager cleanUpManager = spy(remoteClusterStateCleanupManager);
        doThrow(IOException.class).when(remoteRoutingTableService).deleteStaleIndexRoutingPaths(any());
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
        UploadedMetadataAttribute coordinationMetadata = new UploadedMetadataAttribute(COORDINATION_METADATA, "coordination_metadata");
            .settingMetadata(settingMetadata)
        );
            IOException.class,
        UploadedIndexMetadata index4Metadata = new UploadedIndexMetadata("index4", "indexUUID4", "index_metadata4__2");
                Integer.MAX_VALUE,
            .templatesMetadata(templateMetadataUpdated)
        when(clusterApplierService.state()).thenReturn(clusterState);
        String clusterName = "test-cluster";
            .put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), batchSize)
            .clusterUUID(clusterUUID)
        when(clusterState.nodes()).thenReturn(nodes);
        spyManager.cleanUpStaleFiles();
        remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs);
            batch1,
        assertEquals(1, callCount.get());
        remoteClusterStateCleanupManager.start();
        cleanUpManager.cleanUpStaleFiles();
            assertNotNull(remoteClusterStateCleanupManager.getStats());
        remoteClusterStateCleanupManager.deleteClusterMetadata(clusterName, clusterUUID, activeBlobs, inactiveBlobs);
import static org.mockito.Mockito.when;
        String clusterUUID = "test-uuid";
            assertNotNull(remoteClusterStateCleanupManager.getStats());
        assertEquals(1, callCount.get());
            .indices(List.of(index1Metadata, index2Metadata))
        }).when(cleanUpManager).cleanUpStaleFiles();
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        AtomicInteger callCount = new AtomicInteger(0);
            )
        when(remoteManifestManager.getManifestFolderPath(eq(clusterName), eq(clusterUUID))).thenReturn(
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(
            batch2.add(new PlainBlobMetadata("manifest-" + i + ".dat", 1L));
        Settings invalidSettings = Settings.builder()
            .globalMetadataFileName(null)
        CountDownLatch completionLatch = new CountDownLatch(1);
            .routingTableVersion(0L)
import java.util.Collections;
        );
            .indices(List.of(index1Metadata))
        when(clusterService.getClusterApplierService()).thenReturn(clusterApplierService);
        ).thenReturn(List.of(new PlainBlobMetadata("mainfest3", 1L)));
            .stateVersion(1L)
    public void testDeleteStaleClusterUUIDs() throws IOException {
        verify(cleanUpManager, times(maxBatches)).deleteClusterMetadata(
        UploadedMetadataAttribute coordinationMetadataUpdated = new UploadedMetadataAttribute(
            .stateVersion(1L)
        TimeValue newInterval = TimeValue.timeValueMinutes(10);
            clusterService,
    public void testRemoteCleanupSkipsIfVersionIncrementLessThanThreshold() {
import org.opensearch.cluster.service.ClusterService;
    }
        doAnswer(invocation -> {
            .codecVersion(CODEC_V2)
            new BlobPath().add(encodeString(clusterName)).add(CLUSTER_STATE_PATH_TOKEN).add(clusterUUID).add(MANIFEST)
    public void testMaxBatchesSettingUpdate() {
        // now the task should be initialized
            .indices(List.of(index1Metadata))
            ActionListener<Void> listener = invocation.getArgument(1);
            .templatesMetadata(templateMetadata)
        assertNull(cleanupTask);
            .codecVersion(CODEC_V2)
        );
        when((blobStoreRepository.basePath())).thenReturn(blobPath);
        when(clusterState.version()).thenReturn(randomLongBetween(11, 20));
            .indicesRouting(indicesRouting1)
import static org.opensearch.gateway.remote.RemoteClusterStateCleanupManager.CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT;
                MANIFEST + DELIMITER,
            // wait for stats to get updated
    private BlobStoreRepository blobStoreRepository;
        );
        assertEquals(CLUSTER_STATE_CLEANUP_INTERVAL_DEFAULT, remoteClusterStateCleanupManager.getStaleFileCleanupInterval());
            return null;
            .stateVersion(1L)
        Settings newSettings = Settings.builder().put(REMOTE_CLUSTER_STATE_CLEANUP_BATCH_SIZE_SETTING.getKey(), batchSize).build();
        assertThrows(
        verify(remoteRoutingTableService).deleteStaleIndexRoutingPaths(List.of(index3Metadata.getUploadedFilename()));
    private RepositoriesService repositoriesService;
