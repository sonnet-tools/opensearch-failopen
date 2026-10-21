                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        List<String> fileNames = Arrays.asList("file1", "file2");
        );
        remoteRoutingTableService.doStart();
        CountDownLatch latch = new CountDownLatch(1);
            .indicesRouting(List.of(uploadedIndexMetadata, uploadedIndexMetadata2))
            .getAllUploadedIndicesRouting(previousManifest, List.of(uploadedIndexMetadata2), List.of());
        ).numberOfShards(noOfShards).numberOfReplicas(noOfReplicas).build();
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        );
                .getDeletes()
            .build();
                .getUpserts()
import org.junit.Before;
        String indexNameToDelete = allIndices.get(randomIntBetween(0, allIndices.size() - 1));
            "index-filename",
        assertEquals(uploadedIndexMetadata, allIndiceRoutingMetadata.get(0));
        RoutingTable routingTable2 = RoutingTable.builder().addAsNew(indexMetadata2).build();
        RoutingTable routingTable2 = RoutingTable.builder().addAsNew(indexMetadata2).build();
        assertEquals(1, diff.provideDiff().getDiffs().size());
            Settings.builder()
    }
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata = new ClusterMetadataManifest.UploadedIndexMetadata(
        assertEquals(RemoteStoreUtils.invertLong(1L), fileNameTokens[1]);
            .build();
                .getUpserts()
        final IndexMetadata indexMetadata2 = new IndexMetadata.Builder(indexName2).settings(
                new LatchedActionListener<>(listener, latch),
            noOfShards + 1,
            INDEX_ROUTING_METADATA_PREFIX
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(stalePaths);
        TestCapturingListener<IndexRoutingTable> listener = new TestCapturingListener<>();
import java.util.ArrayList;
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().build();
 * The OpenSearch Contributors require contributions made to
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata = new ClusterMetadataManifest.UploadedIndexMetadata(
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata2 = new ClusterMetadataManifest.UploadedIndexMetadata(
        String uploadedFileName = String.format(Locale.ROOT, "index-routing/" + indexName);
        );
        });
import java.util.Locale;
import org.opensearch.common.blobstore.BlobContainer;
            .put(REMOTE_PUBLICATION_SETTING_KEY, "true")
        basePath = BlobPath.cleanPath().add("base-path");
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
import org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable;
        doThrow(new IOException("test exception")).when(blobContainer).deleteBlobsIgnoringIfNotExists(Mockito.anyList());
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)
import org.opensearch.repositories.FilterRepository;
            "index-uuid",
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        }).when(blobStoreTransferService)
        testRemoteRoutingTableService.doStart();
    private InternalRemoteRoutingTableService remoteRoutingTableService;
        repositoriesServiceSupplier = mock(Supplier.class);
            INDEX_ROUTING_METADATA_PREFIX
import java.nio.charset.StandardCharsets;
        assertEquals(fileNameTokens[1], RemoteStoreUtils.invertLong(1L));
    public void setup() {
        RoutingTable updatedRoutingTable = updatedRoutingTableBuilder.addAsNew(indexMetadata).build();
            remoteIndexRoutingTable.indexRoutingTableFormat.serialize(
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(stalePaths);
        );
        assertNotNull(listener.getResult());
    }
        repositoriesService = mock(RepositoriesService.class);
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            settings,
        assertEquals(8, pathTokens.length);
        );
            "index-filename",
                .provideDiff()
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndiceRoutingMetadata = remoteRoutingTableService
            )
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;
import org.opensearch.cluster.Diff;
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)
        ).numberOfShards(noOfShards + 1).numberOfReplicas(noOfReplicas).build();
                repositoriesServiceSupplier,
        );
            settings,
        assertEquals("deletion failed", thrown.getMessage());
            INDEX_ROUTING_METADATA_PREFIX
            return null;
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
        assertEquals(
    }
        remoteRoutingTableService.deleteStaleIndexRoutingPaths(stalePaths);
    }
    }
                uploadedFileName,
        }
            String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
import org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff;
            .getAllUploadedIndicesRouting(previousManifest, List.of(uploadedIndexMetadata), List.of());
            noOfReplicas + 1,
        remoteRoutingTableService.getAsyncIndexRoutingReadAction(
        int noOfShards = between(1, 1000);
    public void testDeleteAsyncInternalExecutionException() throws Exception {
    }
        );
    }
        assertEquals(
import org.opensearch.common.blobstore.stream.write.WritePriority;
        RoutingTable routingTable2 = RoutingTable.builder().add(indexRoutingTableReversed).build();
import org.opensearch.gateway.remote.ClusterMetadataManifest;
import org.opensearch.core.action.ActionListener;
        List<String> allIndices = new ArrayList<>();
            diff.provideDiff().getDiffs().get(indexName).apply(routingTable.indicesRouting().get(indexName)).getShards().get(0).getSize()
        diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable2);
    public void testGetIndicesRoutingMapDiffShardDetailChanged() {
                .get(0)
    public void testDeleteStaleIndexRoutingPathsWithMultiStreamBlobContainer() throws IOException {
        assertEquals(0, diff.provideDiff().getDeletes().size());
                .getUpserts()
            .metadata(Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(1L).build()))
    }
        testRemoteRoutingTableService.doStart();
        assertEquals(
        for (int i = 0; i < numberOfIndices; i++) {
        ).numberOfShards(between(1, 1000)).numberOfReplicas(randomInt(10)).build();
            INDEX_ROUTING_METADATA_PREFIX
    private ClusterService clusterService;
        );
import org.opensearch.common.util.TestCapturingListener;
        RoutingTable routingTable2 = RoutingTable.builder().addAsRecovery(indexMetadata).build();
        );
        assertEquals(0, diff.provideDiff().getUpserts().size());
                        .add(clusterState.metadata().clusterUUID())
        final Settings settings = Settings.builder().build();
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
    public void testDeleteStaleIndexRoutingDiffPaths() throws IOException {
 */
                .provideDiff()
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata = new ClusterMetadataManifest.UploadedIndexMetadata(
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid2")
import org.opensearch.common.blobstore.BlobStore;
                .build()
        remoteRoutingTableService.deleteStaleIndexRoutingDiffPaths(stalePaths);
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), state.getRoutingTable())
            .getUpdatedIndexRoutingTableMetadata(updatedIndicesRouting, indicesRouting);
        );
        assertNotNull(listener.getResult());
            "index-uuid",
        when(blobStore.blobContainer(any())).thenReturn(container);
        int noOfReplicas = randomInt(10);
        }).when(container).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        final IndexMetadata indexMetadata3 = new IndexMetadata.Builder(indexName).settings(
import org.opensearch.cluster.metadata.Metadata;
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndiceRoutingMetadata = remoteRoutingTableService
        );
import org.opensearch.threadpool.ThreadPool;
        RoutingTable routingTable = state.routingTable();
            "test-index2",
import org.opensearch.cluster.metadata.IndexMetadata;
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
                currentState.getRoutingTable().getIndicesRouting(),
            indexNameToDelete,
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
            threadPool,
        doAnswer(invocationOnMock -> {
        ClusterState newState = ClusterState.builder(ClusterName.DEFAULT)
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        remoteRoutingTableService.doStart();
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
        assertEquals(RemoteStoreUtils.invertLong(1L), fileNameTokens[2]);
            new LatchedActionListener<>(listener, latch)
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());
        assertThrows(AssertionError.class, () -> remoteRoutingTableService.start());
        ).numberOfShards(noOfShards).numberOfReplicas(noOfReplicas).build();
                        .add(RemoteClusterStateUtils.encodeString(ClusterName.DEFAULT.toString()))
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            compressor,
            listener.onResponse(null);
    private ClusterState createClusterState(String indexName) {
import static org.opensearch.gateway.remote.ClusterMetadataManifestTests.randomUploadedIndexMetadataList;
        assertEquals(ROUTING_TABLE_DIFF_METADATA_PREFIX, fileNameTokens[0]);
            Settings.builder()
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
        IOException thrown = assertThrows(IOException.class, () -> { remoteRoutingTableService.deleteStaleIndexRoutingPaths(stalePaths); });
            "cluster-uuid",
import static org.mockito.Mockito.when;
        assertEquals(1, allIndiceRoutingMetadata.size());
            FNV_1A_BASE64
        List<String> updatedIndicesRouting = new ArrayList<>();
        blobContainer = mock(BlobContainer.class);
                .size()
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            "index-uuid",
            .build();
            repositoriesServiceSupplier,
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
        IndexRoutingTable indexRouting = routingTable.getIndicesRouting().get(indexName);
import org.opensearch.core.index.Index;
        ).numberOfShards(noOfShards + 1).numberOfReplicas(noOfReplicas + 1).build();
        );
            .put(REMOTE_PUBLICATION_SETTING_KEY, "true")
        List<String> stalePaths = Arrays.asList("path1", "path2");
import java.util.function.Supplier;
        assertEquals(1, diff.provideDiff().getDeletes().size());
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        assertNull(listener.getFailure());
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
            "test-index",
        );
                .size()
import static org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64;
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
        when(blobContainer.readBlob(indexName)).thenAnswer(
            "test-index",
    public void testGetIndicesRoutingMapDiff() {
        assertEquals(uploadedIndexMetadata, allIndiceRoutingMetadata.get(0));
        assertEquals(uploadedIndexMetadata2, allIndiceRoutingMetadata.get(1));
    }
            () -> new InternalRemoteRoutingTableService(
        }).when(container).deleteBlobsAsyncIgnoringIfNotExists(eq(fileNames), any());
            .build();
        blobStoreTransferService = mock(BlobStoreTransferService.class);
        assertEquals(6, pathTokens.length);
        }).when(container).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
            "index-filename",
        // Simulate an IOException
import org.opensearch.repositories.RepositoriesService;
            latch.await();
    public void testGetAsyncIndexRoutingWriteAction() throws Exception {
            new LatchedActionListener<>(listener, latch)
import org.opensearch.core.compress.NoneCompressor;
    }
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(eq(stalePaths), any());
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
            .build();
        IndexRoutingTable indexRouting = routingTable.getIndicesRouting().get(indexName);
        assertThrows(
        assertEquals(1, diff.provideDiff().getUpserts().size());
import org.opensearch.common.unit.TimeValue;
        return ClusterState.builder(ClusterName.DEFAULT).routingTable(routingTableBuilder.build()).build();
    public void testGetIndicesRoutingMapDiffIndexDeleted() {
                clusterState.getRoutingTable().getIndicesRouting().get(indexName),
                .build(),
            assertNotNull(listener.getResult());
            .getAllUploadedIndicesRouting(previousManifest, List.of(), List.of());
        String[] fileNameTokens = pathTokens[5].split(DELIMITER);
        List<String> stalePaths = Arrays.asList("path1", "path2");
            Version.CURRENT
            Settings.builder()
        assertEquals(
        );
        ).numberOfShards(1).numberOfReplicas(1).build();
            .add(ROUTING_TABLE_DIFF_PATH_TOKEN);
        assertEquals(0, diff.provideDiff().getDeletes().size());
        assertEquals(4, fileNameTokens.length);
                    .build()
            "test-cluster"
    public void testFailInitializationWhenRemoteRoutingDisabled() {
        List<String> stalePaths = Arrays.asList("path1", "path2");
                .provideDiff()
import static org.mockito.Mockito.verify;
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
            routingTableBuilder.addAsNew(indexMetadata);
            return null;
                .getDeletes()
            .addShard(indexRouting.getShards().get(0).replicaShards().get(0))
        clusterService = mock(ClusterService.class);
                        .add(CLUSTER_STATE_PATH_TOKEN)
            .indicesRouting(List.of(uploadedIndexMetadata))
        assertEquals(fileNameTokens[2], RemoteStoreUtils.invertLong(2L));
            listener.onResponse(null);
        final IndexMetadata indexMetadata2 = new IndexMetadata.Builder(indexName).settings(
    @After
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_FILE;
                .build()
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.PATH_DELIMITER;
                .getDeletes()
        Iterable<String> remotePath = new BlobPath().add("base-path")
package org.opensearch.cluster.routing.remote;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            INDEX_ROUTING_METADATA_PREFIX
import org.opensearch.common.settings.Settings;
            Settings.builder()
    public void testGetIndicesRoutingMapDiffIndexAdded() {
    }
        int noOfReplicas = randomInt(10);
            AssertionError.class,
    }
        );
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
    public void testGetAsyncIndexRoutingDiffWriteAction() throws Exception {
        assertNotNull(diff.provideDiff().getDiffs().get(indexName));
        );
        ClusterMetadataManifest.UploadedIndexMetadata expectedIndexRouting = indicesRouting.get(
            currentState.version(),
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        ).numberOfShards(between(1, 1000)).numberOfReplicas(randomInt(10)).build();
        InternalRemoteRoutingTableService testRemoteRoutingTableService = new InternalRemoteRoutingTableService(
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.gateway.remote.RemoteClusterStateServiceTests.generateClusterStateWithOneIndex;
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
    }
import org.opensearch.repositories.RepositoryMissingException;
            testRemoteRoutingTableService.deleteAsyncInternal(container, fileNames, TimeValue.timeValueSeconds(10));
                    .withoutPadding()
                .get(0)
            .addShard(indexRouting.getShards().get(0).primaryShard())
import static org.mockito.Mockito.mock;
import org.opensearch.common.compress.DeflateCompressor;
        testRemoteRoutingTableService.doStart();
import static org.mockito.ArgumentMatchers.anyString;
        Settings settings = Settings.builder()
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            "index-filename",
    }
                .size()
            remoteRoutingTableService.getAsyncIndexRoutingTableDiffReadAction(
            );
                .build()
        // Don't call listener to simulate timeout
import org.opensearch.Version;
        String indexName2 = randomAlphaOfLength(randomIntBetween(1, 50));
        int noOfShards = between(1, 1000);
        remoteRoutingTableService.getAsyncIndexRoutingDiffWriteAction(
import static org.mockito.Mockito.any;
                settings,
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata = new ClusterMetadataManifest.UploadedIndexMetadata(
    public void testGetUpdatedIndexRoutingTableMetadataWhenNoChange() {
        assertThat(RemoteStoreUtils.invertLong(fileNameTokens[3]), lessThanOrEqualTo(System.currentTimeMillis()));
            Settings.builder()
        assertEquals(1, allIndiceRoutingMetadata.size());
        assertEquals(2, allIndiceRoutingMetadata.size());
            ActionListener<Void> listener = invocation.getArgument(1);
        assertTrue(thrown.getMessage().contains("Delete operation timed out"));
        assertEquals(
            Version.CURRENT
        assertEquals(uploadedIndexMetadata, allIndiceRoutingMetadata.get(0));
                .build()
            invocation -> remoteRoutingTableDiff.remoteRoutingTableDiffFormat.serialize(diff, uploadedFileName, compressor).streamInput()
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
            "test-cluster"
        );
        final IndexMetadata indexMetadata2 = new IndexMetadata.Builder(indexName2).settings(
        assertEquals(
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            compressor,
            return null;
        }).when(container).deleteBlobsAsyncIgnoringIfNotExists(eq(fileNames), any());
        ).numberOfShards(1).numberOfReplicas(1).build();
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        assertNotNull(diff.provideDiff().getUpserts().get(indexName2));
            .add("cluster-state")
    public void testFailStartWhenNotBlobRepository() {
    }
        doAnswer(invocation -> {
            uploadedFileName,
            "index-uuid",
        doThrow(new RepositoryMissingException("repository missing")).when(repositoriesService).repository("routing_repository");
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN;
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
import org.opensearch.cluster.routing.StringKeyDiffProvider;
                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        assertTrue(
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        assertEquals(
        ClusterState clusterState = createClusterState(indexName);
    public void testGetAllUploadedIndicesRoutingNoChange() {
        List<ClusterMetadataManifest.UploadedIndexMetadata> indicesRouting = randomUploadedIndexMetadataList();
        StringKeyDiffProvider<IndexRoutingTable> diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable2);
            "index-filename",
            .build();
            );
        remoteRoutingTableService.doStart();
        assertNotNull(allIndiceRoutingMetadata);
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(fileNameTokens[0], INDEX_ROUTING_FILE);
                .provideDiff()
        assertEquals(1, updatedIndexMetadata.size());
        );
            )
            threadPool,
            Settings.builder()
import org.opensearch.cluster.service.ClusterService;
import java.util.Arrays;
            listener.onFailure(new IOException("deletion failed"));
        assertNull(listener.getFailure());
import org.opensearch.gateway.remote.RemoteClusterStateUtils;
    }
            1,
        assertNotNull(listener.getResult());
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
    public void testDeleteStaleIndexRoutingDiffPathsThrowsIOException() throws IOException {
        assertEquals(1, diff.provideDiff().getDiffs().size());
            .build();
                .build()
        );
    }
            ActionListener<Void> listener = invocation.getArgument(1);
            Settings.builder()
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            .getAllUploadedIndicesRouting(previousManifest, List.of(uploadedIndexMetadata), List.of());
    private BlobContainer blobContainer;
            INDEX_ROUTING_METADATA_PREFIX
        );
    public void testDeleteStaleIndexRoutingPathsThrowsIOException() throws IOException {
        assertThrows(RepositoryMissingException.class, () -> remoteRoutingTableService.start());
        List<ClusterMetadataManifest.UploadedIndexMetadata> updatedIndexMetadata = remoteRoutingTableService
        );
        Iterable<String> remotePath = HASHED_PREFIX.path(
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
            .put(REMOTE_PUBLICATION_SETTING_KEY, "true")
        doNothing().when(blobContainer).deleteBlobsIgnoringIfNotExists(any());
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(stalePaths);
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
        assertEquals(0, diff.provideDiff().getUpserts().size());
        assertEquals(
        return ClusterState.builder(ClusterName.DEFAULT)
        List<String> stalePaths = Arrays.asList("path1", "path2");
        });
    }
            Settings.builder()
        RoutingTable.Builder updatedRoutingTableBuilder = RoutingTable.builder(routingTable).remove(indexNameToDelete);
        RemoteRoutingTableDiff remoteRoutingTableDiff = new RemoteRoutingTableDiff(
        assertEquals(expectedIndexRouting, updatedIndexMetadata.get(0));
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
            ActionListener<Void> listener = invocation.getArgument(1);
            RemoteStorePathStrategy.PathInput.builder()
    private BlobStore blobStore;
        String uploadedFileName = String.format(Locale.ROOT, "routing-table-diff/" + indexName);
        String indexNameToDelete = allIndices.get(randomIntBetween(0, allIndices.size() - 1));
            .addShard(indexRouting.getShards().get(0).primaryShard())
        latch.await();
    public void testIndicesRoutingDiffWhenIndexDeletedAndAdded() {
import org.opensearch.index.remote.RemoteStoreUtils;
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_METADATA_PREFIX;
                uploadedFileName,
                "test-cluster"
            return null;
            threadPool,
            new RoutingTableIncrementalDiff(previousState.getRoutingTable(), currentState.getRoutingTable()),
                .provideDiff()
        ).numberOfShards(between(1, 1000)).numberOfReplicas(randomInt(10)).build();
    }
            uploadedFileName,
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
                .build()
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid2")
    private BlobStoreRepository blobStoreRepository;
                .build()
            "index-uuid",
            .build();
        ).numberOfShards(noOfShards).numberOfReplicas(noOfReplicas).build();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        ClusterState clusterState = createClusterState(indexName);
    public void testGetAllUploadedIndicesRoutingNewIndexFromManifest() {
        assertEquals(clusterState.getRoutingTable().getIndicesRouting().get(indexName), indexRoutingTable);
            uploadedFileName,
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
    @Before
                )
        int noOfReplicas = randomInt(10);
    private BlobStoreTransferService blobStoreTransferService;
            ).numberOfShards(1).numberOfReplicas(1).build();
    }
        RoutingTable routingTable2 = RoutingTable.builder(routingTable).addAsNew(indexMetadata2).build();
        assertThat(RemoteStoreUtils.invertLong(fileNameTokens[3]), lessThanOrEqualTo(System.currentTimeMillis()));
        );
            diff.provideDiff().getDiffs().get(indexName).apply(routingTable.indicesRouting().get(indexName)).getShards().get(0).getSize()
            .add(
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
                Settings.builder()
        assertNotNull(allIndiceRoutingMetadata);
            .version(2L)
import org.mockito.Mockito;
import java.io.IOException;
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_METADATA_PREFIX;
            INDEX_ROUTING_METADATA_PREFIX
        Settings settings = Settings.builder()
        ).numberOfShards(between(1, 1000)).numberOfReplicas(randomInt(10)).build();
        assertNotNull(allIndiceRoutingMetadata);
        doThrow(new IOException("test exception")).when(blobContainer).deleteBlobsIgnoringIfNotExists(Mockito.anyList());
        CountDownLatch latch = new CountDownLatch(1);
        assertEquals(ROUTING_TABLE_DIFF_FILE, uploadedMetadata.getComponent());
        assertNotNull(allIndiceRoutingMetadata);
    }
                .build()
    }
        assertEquals(2, allIndiceRoutingMetadata.size());
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)
        doAnswer(invocation -> {
        IndexRoutingTable indexRoutingTable = IndexRoutingTable.builder(index)
            clusterState.stateUUID(),
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
    private ClusterState createIndices(int numberOfIndices) {
        testRemoteRoutingTableService.deleteAsyncInternal(container, fileNames, TimeValue.timeValueSeconds(10));
            threadPool,
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(INDEX_ROUTING_METADATA_PREFIX + indexName, uploadedMetadata.getComponent());
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
                .provideDiff()
            assertEquals(
        final Index index = new Index(indexName, "uuid");
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)
        doAnswer(invocationOnMock -> {
            .build();
            diff.provideDiff().getDiffs().get(indexName).apply(routingTable.indicesRouting().get(indexName)).shards().size()
                .build()
        InternalRemoteRoutingTableService testRemoteRoutingTableService = new InternalRemoteRoutingTableService(
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)
        RemoteIndexRoutingTable remoteIndexRoutingTable = new RemoteIndexRoutingTable(
        remoteRoutingTableService.doStart();
            final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
        assertEquals("test exception", thrown.getMessage());
    private Supplier<RepositoriesService> repositoriesServiceSupplier;
    public void testGetAllUploadedIndicesRoutingExistingIndexInManifest() {
    }
            IOException.class,
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
    }
            .indicesRouting(List.of(uploadedIndexMetadata))
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndiceRoutingMetadata = remoteRoutingTableService
        }).when(blobStoreTransferService)
        List<String> fileNames = Arrays.asList("file1", "file2");
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
    }
import org.opensearch.cluster.routing.RoutingTable;
    public void testGetAsyncIndexRoutingReadAction() throws Exception {
            noOfReplicas + 2,
import java.util.List;
    private RepositoriesService repositoriesService;
        updatedIndicesRouting.add(expectedIndexRouting.getIndexName());
        );
import org.opensearch.cluster.ClusterName;
            "index-filename",
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)
        RoutingTable updatedRoutingTable = RoutingTable.builder(routingTable).remove(indexNameToDelete).build();
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
            .uploadBlob(any(InputStream.class), eq(remotePath), anyString(), eq(WritePriority.URGENT), any(ActionListener.class));
        );
    }
        assertEquals(pathTokens[0], "base-path");
        Settings settings = Settings.builder()
                .build()
    public void testGetAsyncIndexRoutingTableDiffReadAction() throws Exception {
}
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        assertEquals(noOfShards, diff.provideDiff().getUpserts().get(indexName2).getShards().size());
public class RemoteRoutingTableServiceTests extends OpenSearchTestCase {
        );
import static org.mockito.Mockito.doAnswer;
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        StringKeyDiffProvider<IndexRoutingTable> diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable2);
        assertEquals(indexName, diff.provideDiff().getDeletes().get(0));
        assertEquals(0, diff.provideDiff().getUpserts().size());
            currentState.metadata().clusterUUID(),
            CountDownLatch latch = new CountDownLatch(1);
        assertEquals(pathTokens[1], "base-path");
        assertEquals(0, diff.provideDiff().getDeletes().size());
    public void testDeleteStaleIndexRoutingPaths() throws IOException {
                .provideDiff()
        latch.await();
import java.util.concurrent.CountDownLatch;
        remoteRoutingTableService = new InternalRemoteRoutingTableService(
                version
        threadPool.shutdown();
import org.opensearch.cluster.routing.IndexRoutingTable;
import org.opensearch.index.remote.RemoteStorePathStrategy;
                .build()
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
import org.junit.After;
            ).streamInput()
        assertEquals(4, fileNameTokens.length);
            repositoriesServiceSupplier,
        final FilterRepository filterRepository = mock(FilterRepository.class);
            INDEX_ROUTING_METADATA_PREFIX
        RoutingTable routingTable = state.routingTable();
        );
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        assertEquals(
            new LatchedActionListener<>(listener, latch),
        compressor = new NoneCompressor();
            indexNameToDelete,
    public void testDeleteStaleIndexRoutingDiffPathsWithMultiStreamBlobContainer() throws IOException {
                        .add(INDEX_ROUTING_TABLE)
            diff.provideDiff().getDiffs().get(indexName).apply(routingTable.indicesRouting().get(indexName)).shards().size()
            currentState.term(),
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        final Index index = new Index(indexName, "uuid");
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        List<String> fileNames = Arrays.asList("file1", "file2");
import java.util.Base64;
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        IOException thrown = assertThrows(IOException.class, () -> {
import org.opensearch.common.settings.ClusterSettings;
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        assertEquals("test exception", thrown.getMessage());
        );
        remoteRoutingTableService.doStart();
        IndexRoutingTable indexRoutingTableReversed = IndexRoutingTable.builder(index)
            "index-uuid",
        diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable2, routingTable3);
        when(blobStoreRepository.blobStore()).thenReturn(blobStore);
            clusterState.metadata().clusterUUID(),
            testRemoteRoutingTableService.deleteAsyncInternal(container, fileNames, TimeValue.timeValueMillis(1));
    }
        int noOfShards = between(1, 1000);
 *
            noOfShards + 1,
    public void testIndicesRoutingDiffWhenIndexDeleted() {
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
                .getUpserts()
        StringKeyDiffProvider<IndexRoutingTable> diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable);
        RoutingTable routingTable3 = RoutingTable.builder().addAsNew(indexMetadata3).build();
 * compatible open source license.
        );
            "test-cluster"
        assertEquals(0, diff.provideDiff().getDeletes().size());
        assertEquals(1, diff.provideDiff().getDiffs().size());
 * this file be licensed under the Apache-2.0 license or a
        InternalRemoteRoutingTableService testRemoteRoutingTableService = new InternalRemoteRoutingTableService(
            return null;
        doAnswer(invocation -> {
        CountDownLatch latch = new CountDownLatch(1);
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
            currentState.stateUUID(),
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            Settings.builder()
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).routingTable(routingTable).build();
        StringKeyDiffProvider<IndexRoutingTable> diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable2);
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(stalePaths);
        RoutingTableIncrementalDiff diff = new RoutingTableIncrementalDiff(previousState.getRoutingTable(), currentState.getRoutingTable());
        List<String> updatedIndicesRouting = new ArrayList<>();
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndiceRoutingMetadata = remoteRoutingTableService
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .build();
                threadPool,
        when(blobStore.blobContainer(any())).thenReturn(container);
                .containsKey(indexName)
            .uploadBlob(any(InputStream.class), eq(remotePath), anyString(), eq(WritePriority.URGENT), any(ActionListener.class));
        );
        );
        // Reversing order to check for equality without order.
        );
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
        remoteRoutingTableService.doStart();
        when(repositoriesService.repository("routing_repository")).thenReturn(blobStoreRepository);
            clusterState.term(),
        when(blobStore.blobContainer(any())).thenReturn(container);
        assertNotNull(diff.provideDiff().getUpserts().get(indexName2));
            0,
            .addShard(indexRouting.getShards().get(0).replicaShards().get(0))
        assertEquals(uploadedIndexMetadata2, allIndiceRoutingMetadata.get(0));
                new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        assertEquals(0, updatedIndexMetadata.size());
    public void testGetAllUploadedIndicesRouting() {
            .put(REMOTE_PUBLICATION_SETTING_KEY, "true")
import static org.mockito.Mockito.doThrow;
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
                compressor
        assertEquals(uploadedIndexMetadata2, allIndiceRoutingMetadata.get(1));
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
                .build()
        assertEquals(0, diff.provideDiff().getUpserts().size());
            Diff<RoutingTable> resultDiff = listener.getResult();
            Version.CURRENT
        IOException thrown = assertThrows(IOException.class, () -> {
        when(repositoriesService.repository("routing_repository")).thenReturn(filterRepository);
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_FILE;
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
                .size()
        assertEquals(1, allIndiceRoutingMetadata.size());
            1,
            .getUpdatedIndexRoutingTableMetadata(updatedIndicesRouting, indicesRouting);
            "test-index",
        ClusterState state = createIndices(randomIntBetween(1, 100));
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata2 = new ClusterMetadataManifest.UploadedIndexMetadata(
import org.opensearch.cluster.routing.RoutingTableIncrementalDiff;
        remoteRoutingTableService.doClose();
import java.io.InputStream;
        assertNotNull(diff.provideDiff().getDiffs().get(indexName));
    public void testGetIndicesRoutingMapDiffShardChanged() {
        assertEquals(0, diff.provideDiff().getDeletes().size());
        blobStoreRepository = mock(BlobStoreRepository.class);
    }
        );
                .size()
    }
            "test-index2",
        assertEquals(
            assertNull(listener.getFailure());
        doNothing().when(container).deleteBlobsAsyncIgnoringIfNotExists(eq(fileNames), any());
        );
            Settings.builder()
    public void testGetChangedIndicesRouting() {
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
            noOfShards,
                resultDiff.apply(previousState.getRoutingTable()).getIndicesRouting()
            "test-cluster"
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata = new ClusterMetadataManifest.UploadedIndexMetadata(
                    .encodeToString(currentState.getClusterName().value().getBytes(StandardCharsets.UTF_8))
            "test-index2",
            .add(currentState.metadata().clusterUUID())
        doNothing().when(blobContainer).deleteBlobsIgnoringIfNotExists(any());
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.HASHED_PREFIX;
            "test-index",
    }
            .getAllUploadedIndicesRouting(previousManifest, List.of(uploadedIndexMetadata2), List.of("test-index"));
            Settings.builder()
        when(blobStoreRepository.basePath()).thenReturn(basePath);
        doAnswer(invocation -> {
            diff.provideDiff().getDiffs().get(indexName).apply(routingTable.indicesRouting().get(indexName)).shards().size()
            return null;
import org.opensearch.common.blobstore.BlobPath;
    }
    private ClusterSettings clusterSettings;
        // Reversing order to check for equality without order.
                .provideDiff()
        }
                Base64.getUrlEncoder()
            settings,
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
            randomIntBetween(0, indicesRouting.size() - 1)
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        assertNotNull(allIndiceRoutingMetadata);
        );
        IOException thrown = assertThrows(
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
            .build();
        blobStore = mock(BlobStore.class);
            .build();
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndiceRoutingMetadata = remoteRoutingTableService
            repositoriesServiceSupplier,
        // Simulate an IOException
    public void testGetUpdatedIndexRoutingTableMetadataWhenIndexIsUpdated() {
    private Compressor compressor;
import org.opensearch.cluster.ClusterState;
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
        List<String> stalePaths = Arrays.asList("path1", "path2");
            "index-uuid",
            "index-filename",
                    new BlobPath().add("base-path")
import org.opensearch.cluster.coordination.CoordinationMetadata;
    }
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(eq(stalePaths), any());
        assertEquals(1, diff.provideDiff().getUpserts().size());
        assertNotNull(diff.provideDiff().getDiffs().get(indexName));
        );
            Settings.builder()
        remoteRoutingTableService.doStart();
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
        remoteRoutingTableService.deleteStaleIndexRoutingDiffPaths(stalePaths);
        String[] fileNameTokens = pathTokens[7].split(DELIMITER);
        routingTable.getIndicesRouting().forEach((k, v) -> allIndices.add(k));
        super.tearDown();
        List<ClusterMetadataManifest.UploadedIndexMetadata> updatedIndexMetadata = remoteRoutingTableService
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
    }
        for (Version version : List.of(Version.CURRENT, Version.V_3_1_0, Version.V_3_2_0)) {
            settings,
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
        IndexRoutingTable indexRoutingTable = listener.getResult();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            "index-uuid",
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .routingTable(RoutingTable.builder().add(indexRoutingTable).build())
    }
                "cluster-uuid",
            0,
    public void testDeleteAsyncInternalSuccess() throws Exception {
    public void testFailStartWhenRepositoryNotSet() {
            listener.onResponse(null);
        assertEquals(
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
            "test-index",
        when(blobContainer.readBlob(indexName)).thenReturn(
        ).numberOfShards(1).numberOfReplicas(1).build();
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_TABLE;
            TestCapturingListener<Diff<RoutingTable>> listener = new TestCapturingListener<>();
        latch.await();
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
import static org.mockito.ArgumentMatchers.eq;
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_PATH_TOKEN;
        assertNull(listener.getFailure());
            () -> { remoteRoutingTableService.deleteStaleIndexRoutingDiffPaths(stalePaths); }
            ActionListener<Void> listener = invocation.getArgument(1);
        String indexName2 = randomAlphaOfLength(randomIntBetween(1, 50));
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(eq(fileNames), any());
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.test.OpenSearchTestCase;
import static org.mockito.Mockito.doNothing;
        remoteRoutingTableService.deleteStaleIndexRoutingPaths(stalePaths);
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        ClusterState state = createIndices(randomIntBetween(1, 100));
        );
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), newState.getRoutingTable())
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
                .basePath(
        List<ClusterMetadataManifest.UploadedIndexMetadata> indicesRouting = randomUploadedIndexMetadataList();
            "index-filename",
        StringKeyDiffProvider<IndexRoutingTable> diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable2);
        assertEquals(0, diff.provideDiff().getDeletes().size());
    public void testDeleteAsyncInternalTimeout() throws Exception {
import org.opensearch.core.compress.Compressor;
/*
        List<String> stalePaths = Arrays.asList("path1", "path2");
            clusterState.version(),
            .indicesRouting(List.of(uploadedIndexMetadata, uploadedIndexMetadata2))
        assertEquals(
    }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            repositoriesServiceSupplier,
                .indexUUID(clusterState.getRoutingTable().indicesRouting().get(indexName).getIndex().getUUID())
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata2 = new ClusterMetadataManifest.UploadedIndexMetadata(
    public void testGetAllUploadedIndicesRoutingIndexDeleted() {
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    private BlobPath basePath;
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
import org.opensearch.threadpool.TestThreadPool;
            clusterState.getRoutingTable().indicesRouting().get(indexName),
        assertEquals(0, diff.provideDiff().getUpserts().size());
        Settings settings = Settings.builder()
        List<String> allIndices = new ArrayList<>();
        remoteRoutingTableService.getAsyncIndexRoutingWriteAction(
            .routingTable(routingTable)
import org.opensearch.action.LatchedActionListener;
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
            1,
                .getDeletes()
        assertEquals(uploadedIndexMetadata, allIndiceRoutingMetadata.get(0));
        routingTable.getIndicesRouting().forEach((k, v) -> allIndices.add(k));
    public void teardown() throws Exception {
