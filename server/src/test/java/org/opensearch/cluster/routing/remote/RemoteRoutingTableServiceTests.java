        remoteRoutingTableService.doStart();
            Settings.builder()
        List<ClusterMetadataManifest.UploadedIndexMetadata> updatedIndexMetadata = remoteRoutingTableService
    public void testGetIndicesRoutingMapDiffIndexAdded() {
        basePath = BlobPath.cleanPath().add("base-path");
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndiceRoutingMetadata = remoteRoutingTableService  
            Settings.builder()  
                .size()
        doAnswer(invocation -> {
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)
        assertNotNull(listener.getResult());  
        assertNull(listener.getFailure());
        assertEquals(0, diff.provideDiff().getUpserts().size());
        blobStore = mock(BlobStore.class);
        assertEquals(0, diff.provideDiff().getDeletes().size());  
            clusterState.term(),  
        ).numberOfShards(1).numberOfReplicas(1).build();
import org.opensearch.repositories.RepositoriesService;  
import org.junit.After;  
            INDEX_ROUTING_METADATA_PREFIX
            () -> { remoteRoutingTableService.deleteStaleIndexRoutingDiffPaths(stalePaths); }  
        List<String> updatedIndicesRouting = new ArrayList<>();
        );
                uploadedFileName,
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
            );
            INDEX_ROUTING_METADATA_PREFIX  
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
import org.opensearch.action.LatchedActionListener;
        InternalRemoteRoutingTableService testRemoteRoutingTableService = new InternalRemoteRoutingTableService(  
            .getAllUploadedIndicesRouting(previousManifest, List.of(uploadedIndexMetadata2), List.of());
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(stalePaths);  
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
            "index-uuid",
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(stalePaths);  
                .getDeletes()
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);  
    public void teardown() throws Exception {
    }  
                Settings.builder()
        String indexNameToDelete = allIndices.get(randomIntBetween(0, allIndices.size() - 1));
        assertEquals(1, allIndiceRoutingMetadata.size());  
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();  
    public void testGetIndicesRoutingMapDiffIndexDeleted() {  
        List<String> updatedIndicesRouting = new ArrayList<>();  
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
    public void testGetIndicesRoutingMapDiff() {  
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.HASHED_PREFIX;
            "test-cluster"  
        when(blobStoreRepository.getCompressor()).thenReturn(new DeflateCompressor());  
    }
    }  
import java.util.List;  
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
import org.opensearch.common.compress.DeflateCompressor;
                resultDiff.apply(previousState.getRoutingTable()).getIndicesRouting()  
                )
        assertEquals(uploadedIndexMetadata2, allIndiceRoutingMetadata.get(0));
            .getAllUploadedIndicesRouting(previousManifest, List.of(uploadedIndexMetadata), List.of());
                .getUpserts()
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid2")  
                .provideDiff()
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(  
        List<String> stalePaths = Arrays.asList("path1", "path2");  
            testRemoteRoutingTableService.deleteAsyncInternal(container, fileNames, TimeValue.timeValueSeconds(10));
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")  
                .basePath(
        remoteRoutingTableService.deleteStaleIndexRoutingDiffPaths(stalePaths);  
        ).numberOfShards(noOfShards).numberOfReplicas(noOfReplicas).build();
        remoteRoutingTableService.doClose();
            )
            ).numberOfShards(1).numberOfReplicas(1).build();
    public void testDeleteStaleIndexRoutingPathsWithMultiStreamBlobContainer() throws IOException {  
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();  
    }  
        List<String> stalePaths = Arrays.asList("path1", "path2");
        );
        });  
                .getUpserts()  
    }  
        ).numberOfShards(between(1, 1000)).numberOfReplicas(randomInt(10)).build();
        assertEquals(uploadedIndexMetadata, allIndiceRoutingMetadata.get(0));
            clusterState.getRoutingTable().indicesRouting().get(indexName),
        ).numberOfShards(between(1, 1000)).numberOfReplicas(randomInt(10)).build();
            indexNameToDelete,
        assertEquals(uploadedIndexMetadata, allIndiceRoutingMetadata.get(0));
            .build();
        final IndexMetadata indexMetadata2 = new IndexMetadata.Builder(indexName2).settings(  
        );  
            noOfReplicas + 2,
    public void testGetAllUploadedIndicesRoutingNoChange() {
import org.opensearch.cluster.service.ClusterService;
            clusterState.stateUUID(),  
        assertThrows(RepositoryMissingException.class, () -> remoteRoutingTableService.start());  
    public void testDeleteStaleIndexRoutingDiffPaths() throws IOException {  
        assertEquals(8, pathTokens.length);
        assertEquals(  
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
            "index-filename",
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));  
    public void testGetUpdatedIndexRoutingTableMetadataWhenIndexIsUpdated() {
        int noOfReplicas = randomInt(10);
        );  
import org.opensearch.gateway.remote.ClusterMetadataManifest;
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Iterable<String> remotePath = HASHED_PREFIX.path(
                clusterState.getRoutingTable().getIndicesRouting().get(indexName),  
        assertEquals("test exception", thrown.getMessage());
        ).numberOfShards(noOfShards).numberOfReplicas(noOfReplicas).build();
            "test-index2",  
    }
                .get(0)
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)  
            AssertionError.class,
        doAnswer(invocation -> {  
            .indicesRouting(List.of(uploadedIndexMetadata))  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        ClusterState state = createIndices(randomIntBetween(1, 100));
        assertNull(listener.getFailure());  
    private RepositoriesService repositoriesService;
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()  
            "test-index",  
        RoutingTable routingTable2 = RoutingTable.builder(routingTable).addAsNew(indexMetadata2).build();  
import static org.mockito.ArgumentMatchers.eq;  
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndiceRoutingMetadata = remoteRoutingTableService  
            uploadedFileName,
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));  
        ClusterState previousState = generateClusterStateWithOneIndex(indexName, 5, 1, false).build();
        RoutingTable updatedRoutingTable = updatedRoutingTableBuilder.addAsNew(indexMetadata).build();
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
        );
        assertEquals(1, diff.provideDiff().getDiffs().size());
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).routingTable(routingTable).build();
            listener.onResponse(null);
            .put(REMOTE_PUBLICATION_SETTING_KEY, "true")
                .provideDiff()
        when(repositoriesService.repository("routing_repository")).thenReturn(blobStoreRepository);  
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
            "test-cluster"  
            currentState.metadata().clusterUUID(),
        IOException thrown = assertThrows(
            Version.CURRENT
        });  
        remoteRoutingTableService.deleteStaleIndexRoutingPaths(stalePaths);  
        assertEquals(0, diff.provideDiff().getDeletes().size());
        RoutingTable routingTable3 = RoutingTable.builder().addAsNew(indexMetadata3).build();  
    public void testFailStartWhenRepositoryNotSet() {
        when(blobStoreRepository.basePath()).thenReturn(basePath);
            ).streamInput()  
            .put(REMOTE_PUBLICATION_SETTING_KEY, "true")
                .build()
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void testGetAllUploadedIndicesRouting() {  
        int noOfReplicas = randomInt(10);
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
        latch.await();
        assertEquals(
    }
        List<String> stalePaths = Arrays.asList("path1", "path2");
            () -> new InternalRemoteRoutingTableService(  
                .getDeletes()  
    public void testGetAsyncIndexRoutingWriteAction() throws Exception {
}
        String indexName2 = randomAlphaOfLength(randomIntBetween(1, 50));
        assertEquals(2, allIndiceRoutingMetadata.size());  
import static org.mockito.Mockito.doNothing;  
    public void testDeleteAsyncInternalSuccess() throws Exception {
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
            noOfShards + 1,  
                .provideDiff()  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            .add(currentState.metadata().clusterUUID())  
            remoteIndexRoutingTable.indexRoutingTableFormat.serialize(
        ClusterState clusterState = createClusterState(indexName);
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()  
import org.opensearch.cluster.Diff;
        assertEquals(indexName, diff.provideDiff().getDeletes().get(0));  
        doAnswer(invocationOnMock -> {
                .build()  
                new LatchedActionListener<>(listener, latch),
    public void testGetIndicesRoutingMapDiffShardDetailChanged() {
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
    private BlobStoreRepository blobStoreRepository;
        updatedIndicesRouting.add(expectedIndexRouting.getIndexName());
        CountDownLatch latch = new CountDownLatch(1);
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_FILE;
        diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable2);  
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
            "index-filename",  
        assertNotNull(listener.getResult());
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(stalePaths);  
        StringKeyDiffProvider<IndexRoutingTable> diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable2);
import static org.opensearch.gateway.remote.RemoteClusterStateServiceTests.generateClusterStateWithOneIndex;  
        RoutingTable routingTable = state.routingTable();  
        assertEquals(1, diff.provideDiff().getDiffs().size());
        assertEquals(  
            randomIntBetween(0, indicesRouting.size() - 1)
            INDEX_ROUTING_METADATA_PREFIX
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(eq(fileNames), any());
        assertEquals(
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
    public void testDeleteAsyncInternalExecutionException() throws Exception {
            "test-index",
            return null;  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
            "index-uuid",
        remoteRoutingTableService.doStart();  
        assertEquals(0, diff.provideDiff().getUpserts().size());
        return ClusterState.builder(ClusterName.DEFAULT)
        remoteRoutingTableService.doStart();
            "index-uuid",
        doAnswer(invocation -> {
        StringKeyDiffProvider<IndexRoutingTable> diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable2);
        IOException thrown = assertThrows(IOException.class, () -> {
            invocation -> remoteRoutingTableDiff.remoteRoutingTableDiffFormat.serialize(diff, uploadedFileName, compressor).streamInput()
        when(blobStore.blobContainer(any())).thenReturn(container);  
        assertNotNull(diff.provideDiff().getDiffs().get(indexName));
        assertEquals(1, diff.provideDiff().getUpserts().size());  
                .build()
        assertNotNull(diff.provideDiff().getDiffs().get(indexName));
        );
        }).when(container).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        testRemoteRoutingTableService.doStart();
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                .build()
    public void testGetChangedIndicesRouting() {
    public void testIndicesRoutingDiffWhenIndexDeleted() {  
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata = new ClusterMetadataManifest.UploadedIndexMetadata(
            .addShard(indexRouting.getShards().get(0).replicaShards().get(0))
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata2 = new ClusterMetadataManifest.UploadedIndexMetadata(  
        threadPool.shutdown();
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            "index-filename",
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata2 = new ClusterMetadataManifest.UploadedIndexMetadata(  
        // Don't call listener to simulate timeout  
        assertNotNull(allIndiceRoutingMetadata);
            threadPool,
                .build(),  
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
        assertEquals(0, diff.provideDiff().getUpserts().size());
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndiceRoutingMetadata = remoteRoutingTableService
import static org.mockito.Mockito.any;
import org.opensearch.cluster.coordination.CoordinationMetadata;  
    }
import java.util.ArrayList;  
                        .add(INDEX_ROUTING_TABLE)  
        final Index index = new Index(indexName, "uuid");
        Settings settings = Settings.builder()  
import org.opensearch.common.util.TestCapturingListener;
        ).numberOfShards(between(1, 1000)).numberOfReplicas(randomInt(10)).build();  
                version  
            .uploadBlob(any(InputStream.class), eq(remotePath), anyString(), eq(WritePriority.URGENT), any(ActionListener.class));
        assertEquals(  
            assertEquals(
        int noOfShards = between(1, 1000);  
        doNothing().when(blobContainer).deleteBlobsIgnoringIfNotExists(any());
import org.opensearch.core.compress.NoneCompressor;
import java.nio.charset.StandardCharsets;
        }).when(blobStoreTransferService)  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        final IndexMetadata indexMetadata2 = new IndexMetadata.Builder(indexName2).settings(
        ).numberOfShards(noOfShards + 1).numberOfReplicas(noOfReplicas + 1).build();
    @After
        assertEquals(6, pathTokens.length);  
            diff.provideDiff().getDiffs().get(indexName).apply(routingTable.indicesRouting().get(indexName)).getShards().get(0).getSize()  
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
        );  
        );
        // Simulate an IOException  
                    .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
            Settings.builder()
        remoteRoutingTableService.doStart();  
        RoutingTable routingTable2 = RoutingTable.builder().addAsNew(indexMetadata2).build();
        RoutingTable.Builder updatedRoutingTableBuilder = RoutingTable.builder(routingTable).remove(indexNameToDelete);  
            .getAllUploadedIndicesRouting(previousManifest, List.of(uploadedIndexMetadata), List.of());
                .build()  
        List<ClusterMetadataManifest.UploadedIndexMetadata> indicesRouting = randomUploadedIndexMetadataList();  
        RoutingTable routingTable = state.routingTable();  
        when(blobStoreRepository.blobStore()).thenReturn(blobStore);
        RemoteRoutingTableDiff remoteRoutingTableDiff = new RemoteRoutingTableDiff(  
import java.io.InputStream;
            clusterState.version(),
            settings,  
import java.util.Arrays;
        IndexRoutingTable indexRouting = routingTable.getIndicesRouting().get(indexName);
        doNothing().when(blobContainer).deleteBlobsIgnoringIfNotExists(any());
            assertNotNull(listener.getResult());
            return null;
        List<String> stalePaths = Arrays.asList("path1", "path2");  
            noOfReplicas + 1,
        );
        assertEquals(1, allIndiceRoutingMetadata.size());
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(  
        repositoriesService = mock(RepositoriesService.class);  
        IOException thrown = assertThrows(IOException.class, () -> { remoteRoutingTableService.deleteStaleIndexRoutingPaths(stalePaths); });
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder()
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
    }  
    public void testIndicesRoutingDiffWhenIndexDeletedAndAdded() {  
    public void testDeleteAsyncInternalTimeout() throws Exception {
            .indicesRouting(List.of(uploadedIndexMetadata, uploadedIndexMetadata2))
        ClusterState currentState = generateClusterStateWithOneIndex(indexName, 5, 2, true).build();
            .uploadBlob(any(InputStream.class), eq(remotePath), anyString(), eq(WritePriority.URGENT), any(ActionListener.class));
        assertEquals(noOfShards, diff.provideDiff().getUpserts().get(indexName2).getShards().size());
        assertEquals(
        assertEquals(RemoteStoreUtils.invertLong(1L), fileNameTokens[2]);
        final FilterRepository filterRepository = mock(FilterRepository.class);
        int noOfReplicas = randomInt(10);
    public void testGetUpdatedIndexRoutingTableMetadataWhenNoChange() {
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
        List<String> allIndices = new ArrayList<>();
        );
import org.opensearch.threadpool.TestThreadPool;
            .indicesRouting(List.of(uploadedIndexMetadata, uploadedIndexMetadata2))
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata = new ClusterMetadataManifest.UploadedIndexMetadata(  
            0,
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
import org.opensearch.index.remote.RemoteStorePathStrategy;
        doThrow(new RepositoryMissingException("repository missing")).when(repositoriesService).repository("routing_repository");
        );
    public void testGetIndicesRoutingMapDiffShardChanged() {
        }).when(blobStoreTransferService)
            Settings.builder()
            return null;
            .version(2L)
    }  
            .build();  
        clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
                .size()
        String indexNameToDelete = allIndices.get(randomIntBetween(0, allIndices.size() - 1));
    public void testFailInitializationWhenRemoteRoutingDisabled() {
                "test-cluster"
        assertEquals(0, diff.provideDiff().getUpserts().size());  
        assertNotNull(diff.provideDiff().getDiffs().get(indexName));  
    }
    public void testDeleteStaleIndexRoutingPathsThrowsIOException() throws IOException {  
    }
import org.opensearch.cluster.routing.RoutingTableIncrementalDiff;
            settings,
                .getDeletes()
        when(repositoriesServiceSupplier.get()).thenReturn(repositoriesService);
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndiceRoutingMetadata = remoteRoutingTableService  
    }
import org.opensearch.cluster.routing.RoutingTable;
            testRemoteRoutingTableService.deleteAsyncInternal(container, fileNames, TimeValue.timeValueMillis(1));
            latch.await();
    private ClusterState createIndices(int numberOfIndices) {
        remoteRoutingTableService.deleteStaleIndexRoutingDiffPaths(stalePaths);
            TestCapturingListener<Diff<RoutingTable>> listener = new TestCapturingListener<>();
    }
    }
        RoutingTable routingTable2 = RoutingTable.builder().add(indexRoutingTableReversed).build();
                .provideDiff()
            "index-filename",
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
        List<String> fileNames = Arrays.asList("file1", "file2");
            new LatchedActionListener<>(listener, latch)
        doThrow(new IOException("test exception")).when(blobContainer).deleteBlobsIgnoringIfNotExists(Mockito.anyList());
            .add(ROUTING_TABLE_DIFF_PATH_TOKEN);
import static org.opensearch.gateway.remote.ClusterMetadataManifestTests.randomUploadedIndexMetadataList;
        ClusterState newState = ClusterState.builder(ClusterName.DEFAULT)
    }
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();  
                "cluster-uuid",  
            diff.provideDiff().getDiffs().get(indexName).apply(routingTable.indicesRouting().get(indexName)).shards().size()
    private Supplier<RepositoriesService> repositoriesServiceSupplier;  
        diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable2, routingTable3);
                .size()
        assertEquals(0, diff.provideDiff().getUpserts().size());
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(  
        final IndexMetadata indexMetadata2 = new IndexMetadata.Builder(indexName).settings(
        blobStoreRepository = mock(BlobStoreRepository.class);
        assertEquals(  
        assertTrue(
            "test-index",  
        remoteRoutingTableService.getAsyncIndexRoutingDiffWriteAction(  
            "index-uuid",
            .getAllUploadedIndicesRouting(previousManifest, List.of(uploadedIndexMetadata2), List.of("test-index"));
        assertEquals(clusterState.getRoutingTable().getIndicesRouting().get(indexName), indexRoutingTable);
            routingTableBuilder.addAsNew(indexMetadata);
        );
import static org.mockito.Mockito.doAnswer;
                .getDeletes()
            .build();  
import org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable;  
            uploadedFileName,
            .build();
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);
            .routingTable(routingTable)  
        );
            IOException.class,
        super.tearDown();  
        List<String> fileNames = Arrays.asList("file1", "file2");  
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
                    .withoutPadding()
        StringKeyDiffProvider<IndexRoutingTable> diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable);  
            "test-cluster"
                .build()  
        );  
        InternalRemoteRoutingTableService testRemoteRoutingTableService = new InternalRemoteRoutingTableService(
            noOfShards,
    }
            Version.CURRENT  
    }
                    .build()
        // Reversing order to check for equality without order.
    private ClusterState createClusterState(String indexName) {  
                uploadedFileName,
import static org.mockito.Mockito.mock;
            repositoriesServiceSupplier,
    }  
        latch.await();
                .getUpserts()
            Settings.builder()
        remoteRoutingTableService.getAsyncIndexRoutingWriteAction(
        );
    public void testGetAsyncIndexRoutingReadAction() throws Exception {  
            return null;  
    }  
            Version.CURRENT
        repositoriesServiceSupplier = mock(Supplier.class);
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);
            INDEX_ROUTING_METADATA_PREFIX
        assertThat(RemoteStoreUtils.invertLong(fileNameTokens[3]), lessThanOrEqualTo(System.currentTimeMillis()));
        assertNotNull(diff.provideDiff().getUpserts().get(indexName2));
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
import org.opensearch.cluster.metadata.Metadata;
        assertEquals(1, updatedIndexMetadata.size());
        when(blobContainer.readBlob(indexName)).thenAnswer(  
public class RemoteRoutingTableServiceTests extends OpenSearchTestCase {  
        assertEquals(RemoteStoreUtils.invertLong(1L), fileNameTokens[1]);  
        remoteRoutingTableService.getAsyncIndexRoutingReadAction(
        final ClusterMetadataManifest previousManifest = ClusterMetadataManifest.builder().build();
            .indicesRouting(List.of(uploadedIndexMetadata))  
            .build();
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)
            .put(REMOTE_PUBLICATION_SETTING_KEY, "true")
            Settings.builder()
        assertEquals(uploadedIndexMetadata2, allIndiceRoutingMetadata.get(1));
    }  
                settings,
                .provideDiff()  
        );
        }).when(container).deleteBlobsAsyncIgnoringIfNotExists(eq(fileNames), any());  
    private BlobContainer blobContainer;
        assertEquals(0, diff.provideDiff().getDeletes().size());
            Settings.builder()
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();  
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
                .containsKey(indexName)
        remoteRoutingTableService.doStart();
        ).numberOfShards(1).numberOfReplicas(1).build();
    }
        );
        IndexRoutingTable indexRoutingTable = IndexRoutingTable.builder(index)
            final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(0, diff.provideDiff().getDeletes().size());
            "index-uuid",
                threadPool,
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata2 = new ClusterMetadataManifest.UploadedIndexMetadata(
        RemoteIndexRoutingTable remoteIndexRoutingTable = new RemoteIndexRoutingTable(
            INDEX_ROUTING_METADATA_PREFIX  
    private BlobStoreTransferService blobStoreTransferService;  
        StringKeyDiffProvider<IndexRoutingTable> diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable2);
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_FILE;
    public void setup() {
import org.opensearch.common.settings.Settings;  
        routingTable.getIndicesRouting().forEach((k, v) -> allIndices.add(k));  
        assertEquals(fileNameTokens[1], RemoteStoreUtils.invertLong(1L));
import org.opensearch.core.index.Index;  
        IndexRoutingTable indexRoutingTable = listener.getResult();  
    private Compressor compressor;
            listener.onResponse(null);  
        ).numberOfShards(noOfShards + 1).numberOfReplicas(noOfReplicas).build();
            .getUpdatedIndexRoutingTableMetadata(updatedIndicesRouting, indicesRouting);  
            CountDownLatch latch = new CountDownLatch(1);  
            "test-index",  
                .indexUUID(clusterState.getRoutingTable().indicesRouting().get(indexName).getIndex().getUUID())
            new LatchedActionListener<>(listener, latch),
        assertEquals(2, allIndiceRoutingMetadata.size());
    public void testFailStartWhenNotBlobRepository() {  
            .put("node.attr." + REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "routing_repository")
                        .add(clusterState.metadata().clusterUUID())
    }
            listener.onFailure(new IOException("deletion failed"));
        );  
        for (int i = 0; i < numberOfIndices; i++) {
 *
            .build();  
                        .add(RemoteClusterStateUtils.encodeString(ClusterName.DEFAULT.toString()))  
        when(repositoriesService.repository("routing_repository")).thenReturn(filterRepository);
import org.opensearch.core.action.ActionListener;  
            invocationOnMock.getArgument(4, ActionListener.class).onResponse(null);
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), state.getRoutingTable())
    public void testGetAllUploadedIndicesRoutingExistingIndexInManifest() {
        String indexName2 = randomAlphaOfLength(randomIntBetween(1, 50));  
            .build();
            noOfShards + 1,
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata = new ClusterMetadataManifest.UploadedIndexMetadata(
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), newState.getRoutingTable())
    private ClusterSettings clusterSettings;  
import org.opensearch.common.blobstore.BlobContainer;  
import org.opensearch.index.remote.RemoteStoreUtils;  
        remoteRoutingTableService.deleteStaleIndexRoutingPaths(stalePaths);
        assertEquals(uploadedIndexMetadata, allIndiceRoutingMetadata.get(0));
        );
        );  
        final Settings settings = Settings.builder().build();  
        );
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_METADATA_PREFIX;
        remoteRoutingTableService.doStart();
        ).numberOfShards(1).numberOfReplicas(1).build();
        // Simulate an IOException  
    }
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import java.util.function.Supplier;  
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
            INDEX_ROUTING_METADATA_PREFIX  
            diff.provideDiff().getDiffs().get(indexName).apply(routingTable.indicesRouting().get(indexName)).getShards().get(0).getSize()
    }  
            INDEX_ROUTING_METADATA_PREFIX
        assertEquals(0, diff.provideDiff().getDeletes().size());
            "index-uuid",
        );  
        RoutingTable routingTable2 = RoutingTable.builder().addAsRecovery(indexMetadata).build();
        );
        assertTrue(thrown.getMessage().contains("Delete operation timed out"));
        List<String> fileNames = Arrays.asList("file1", "file2");
        when(blobStore.blobContainer(any())).thenReturn(container);  
import org.opensearch.cluster.routing.IndexRoutingTable;  
        return ClusterState.builder(ClusterName.DEFAULT).routingTable(routingTableBuilder.build()).build();  
        assertEquals(fileNameTokens[0], INDEX_ROUTING_FILE);  
            .routingTable(RoutingTable.builder().add(indexRoutingTable).build())  
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_METADATA_PREFIX;
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        int noOfShards = between(1, 1000);
                .build()
    public void testGetAsyncIndexRoutingDiffWriteAction() throws Exception {  
                currentState.getRoutingTable().getIndicesRouting(),
        IndexRoutingTable indexRouting = routingTable.getIndicesRouting().get(indexName);  
        IndexRoutingTable indexRoutingTableReversed = IndexRoutingTable.builder(index)  
        TestCapturingListener<IndexRoutingTable> listener = new TestCapturingListener<>();
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            ActionListener<Void> listener = invocation.getArgument(1);
        blobContainer = mock(BlobContainer.class);
        );  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.DELIMITER;
import org.opensearch.repositories.FilterRepository;
            "index-filename",  
        );
                .size()
    public void testDeleteStaleIndexRoutingDiffPathsThrowsIOException() throws IOException {  
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .getUpdatedIndexRoutingTableMetadata(updatedIndicesRouting, indicesRouting);  
        doAnswer(invocationOnMock -> {  
            .put(REMOTE_PUBLICATION_SETTING_KEY, "true")
    }
            threadPool,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;  
                .build()  
            Settings.builder()
        assertEquals(expectedIndexRouting, updatedIndexMetadata.get(0));
            Settings.builder()  
        when(blobStore.blobContainer(any())).thenReturn(blobContainer);
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
        assertEquals(  
        assertNotNull(allIndiceRoutingMetadata);  
                .getUpserts()
                    new BlobPath().add("base-path")
            "index-uuid",
                new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        remoteRoutingTableService = new InternalRemoteRoutingTableService(  
        testRemoteRoutingTableService.doStart();  
            .build();  
        assertEquals(
                .size()
            .add(  
 */  
import org.opensearch.cluster.ClusterName;  
        int noOfShards = between(1, 1000);
            currentState.version(),  
import java.util.concurrent.CountDownLatch;
        );
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_TABLE;  
        doNothing().when(container).deleteBlobsAsyncIgnoringIfNotExists(eq(fileNames), any());
    }
        }
            "test-index2",
        RoutingTableIncrementalDiff diff = new RoutingTableIncrementalDiff(previousState.getRoutingTable(), currentState.getRoutingTable());  
        }).when(container).deleteBlobsAsyncIgnoringIfNotExists(eq(fileNames), any());
        testRemoteRoutingTableService.doStart();  
            "index-filename",  
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        String[] pathTokens = uploadedFileName.split(PATH_DELIMITER);  
    }
        assertNotNull(allIndiceRoutingMetadata);
        ClusterState clusterState = createClusterState(indexName);
            Diff<RoutingTable> resultDiff = listener.getResult();  
                .build()
        assertEquals(pathTokens[1], "base-path");
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
                repositoriesServiceSupplier,
            .build();  
        // Reversing order to check for equality without order.
import org.opensearch.repositories.blobstore.BlobStoreRepository;
    public void testDeleteStaleIndexRoutingDiffPathsWithMultiStreamBlobContainer() throws IOException {
    private BlobPath basePath;
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));  
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
import org.opensearch.Version;
import java.util.Base64;
import org.opensearch.common.settings.ClusterSettings;
        List<String> stalePaths = Arrays.asList("path1", "path2");
        assertThrows(AssertionError.class, () -> remoteRoutingTableService.start());  
import org.opensearch.cluster.ClusterState;
            settings,  
                .provideDiff()  
        assertThrows(
            .build();
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
import static org.mockito.Mockito.verify;  
        clusterService = mock(ClusterService.class);
        RoutingTable updatedRoutingTable = RoutingTable.builder(routingTable).remove(indexNameToDelete).build();  
        List<ClusterMetadataManifest.UploadedIndexMetadata> indicesRouting = randomUploadedIndexMetadataList();
        ).numberOfShards(noOfShards).numberOfReplicas(noOfReplicas).build();
            uploadedFileName,
        String uploadedFileName = String.format(Locale.ROOT, "routing-table-diff/" + indexName);
            indexNameToDelete,
        List<String> allIndices = new ArrayList<>();
            repositoriesServiceSupplier,
            clusterState.metadata().clusterUUID(),
        compressor = new NoneCompressor();  
        testRemoteRoutingTableService.deleteAsyncInternal(container, fileNames, TimeValue.timeValueSeconds(10));  
        List<ClusterMetadataManifest.UploadedIndexMetadata> allIndiceRoutingMetadata = remoteRoutingTableService
            return null;  
            currentState.term(),
        remoteRoutingTableService.doStart();
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)
            .addShard(indexRouting.getShards().get(0).primaryShard())
                    .encodeToString(currentState.getClusterName().value().getBytes(StandardCharsets.UTF_8))  
            .build();
        verify(blobContainer).deleteBlobsIgnoringIfNotExists(stalePaths);  
        assertEquals(4, fileNameTokens.length);
            Settings.builder()  
            "index-filename",  
            .addShard(indexRouting.getShards().get(0).primaryShard())  
            remoteRoutingTableService.getIndicesRoutingMapDiff(state.getRoutingTable(), updatedRoutingTable)
import org.opensearch.common.blobstore.stream.write.WritePriority;  
        StringKeyDiffProvider<IndexRoutingTable> diff = remoteRoutingTableService.getIndicesRoutingMapDiff(routingTable, routingTable2);
            .add("cluster-state")
        String[] fileNameTokens = pathTokens[7].split(DELIMITER);  
            diff.provideDiff().getDiffs().get(indexName).apply(routingTable.indicesRouting().get(indexName)).shards().size()  
            .getAllUploadedIndicesRouting(previousManifest, List.of(), List.of());
            1,  
            Settings.builder()  
        );
 * SPDX-License-Identifier: Apache-2.0
                .provideDiff()  
            compressor,
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    }
        assertEquals(uploadedIndexMetadata2, allIndiceRoutingMetadata.get(1));  
import static org.mockito.ArgumentMatchers.anyString;
        assertEquals("test exception", thrown.getMessage());
        );  
        List<String> stalePaths = Arrays.asList("path1", "path2");
            RemoteStorePathStrategy.PathInput.builder()  
            .addShard(indexRouting.getShards().get(0).replicaShards().get(0))
            compressor,  
import java.util.Locale;
                        .add(CLUSTER_STATE_PATH_TOKEN)
import org.junit.Before;
        final IndexMetadata indexMetadata3 = new IndexMetadata.Builder(indexName).settings(  
        Settings settings = Settings.builder()  
            new RoutingTableIncrementalDiff(previousState.getRoutingTable(), currentState.getRoutingTable()),
        assertNotNull(diff.provideDiff().getUpserts().get(indexName2));  
        assertEquals(pathTokens[0], "base-path");
    public void testGetAllUploadedIndicesRoutingNewIndexFromManifest() {
            new LatchedActionListener<>(listener, latch)  
        assertEquals(1, diff.provideDiff().getDeletes().size());
    @Before  
import org.opensearch.common.unit.TimeValue;
    }
                .build()
    private ClusterService clusterService;
import java.io.IOException;  
        ClusterMetadataManifest.UploadedIndexMetadata expectedIndexRouting = indicesRouting.get(
            remoteRoutingTableService.getAsyncIndexRoutingTableDiffReadAction(
        IOException thrown = assertThrows(IOException.class, () -> {
import org.opensearch.repositories.RepositoryMissingException;
        CountDownLatch latch = new CountDownLatch(1);  
        }).when(container).deleteBlobsAsyncIgnoringIfNotExists(any(), any());
        assertEquals(0, diff.provideDiff().getDeletes().size());
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        );  
                Base64.getUrlEncoder()
            threadPool,
        when(blobStore.blobContainer(any())).thenReturn(container);
        assertEquals(INDEX_ROUTING_METADATA_PREFIX + indexName, uploadedMetadata.getComponent());
        assertEquals(
        routingTable.getIndicesRouting().forEach((k, v) -> allIndices.add(k));  
        when(blobContainer.readBlob(indexName)).thenReturn(
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid2")
            1,
            );
/*  
    }  
            repositoriesServiceSupplier,
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
        assertThat(RemoteStoreUtils.invertLong(fileNameTokens[3]), lessThanOrEqualTo(System.currentTimeMillis()));  
import org.opensearch.common.blobstore.BlobPath;
        ClusterMetadataManifest.UploadedMetadata uploadedMetadata = listener.getResult();
        assertEquals(4, fileNameTokens.length);
        Settings settings = Settings.builder()
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN;
        );  
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.PATH_DELIMITER;  
        assertEquals(
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();  
        final Index index = new Index(indexName, "uuid");
        doAnswer(invocation -> {  
        String uploadedFileName = uploadedMetadata.getUploadedFilename();
            FNV_1A_BASE64
            ActionListener<Void> listener = invocation.getArgument(1);
        List<ClusterMetadataManifest.UploadedIndexMetadata> updatedIndexMetadata = remoteRoutingTableService
            "index-filename",
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
        );
            "test-index",
        assertNotNull(listener.getResult());
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
            repositoriesServiceSupplier,
                .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
            settings,
            "cluster-uuid",  
        doThrow(new IOException("test exception")).when(blobContainer).deleteBlobsIgnoringIfNotExists(Mockito.anyList());
        assertEquals(1, diff.provideDiff().getDiffs().size());  
    public void testGetAsyncIndexRoutingTableDiffReadAction() throws Exception {
import org.opensearch.threadpool.ThreadPool;
        for (Version version : List.of(Version.CURRENT, Version.V_3_1_0, Version.V_3_2_0)) {
                .get(0)  
    public void testGetAllUploadedIndicesRoutingIndexDeleted() {
        String[] fileNameTokens = pathTokens[5].split(DELIMITER);
            "test-index2",
            ActionListener<Void> listener = invocation.getArgument(1);  
package org.opensearch.cluster.routing.remote;
                compressor
    private InternalRemoteRoutingTableService remoteRoutingTableService;
            1,
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata = new ClusterMetadataManifest.UploadedIndexMetadata(  
        final ClusterMetadataManifest.UploadedIndexMetadata uploadedIndexMetadata = new ClusterMetadataManifest.UploadedIndexMetadata(
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                .provideDiff()  
            diff.provideDiff().getDiffs().get(indexName).apply(routingTable.indicesRouting().get(indexName)).shards().size()
        TestCapturingListener<ClusterMetadataManifest.UploadedMetadata> listener = new TestCapturingListener<>();
 * this file be licensed under the Apache-2.0 license or a
            ActionListener<Void> listener = invocation.getArgument(1);
            listener.onResponse(null);
        assertEquals(1, allIndiceRoutingMetadata.size());  
        ClusterState state = createIndices(randomIntBetween(1, 100));
    }  
        RoutingTable routingTable2 = RoutingTable.builder().addAsNew(indexMetadata2).build();
        assertEquals(ROUTING_TABLE_DIFF_FILE, uploadedMetadata.getComponent());  
        AsyncMultiStreamBlobContainer container = mock(AsyncMultiStreamBlobContainer.class);  
        String uploadedFileName = String.format(Locale.ROOT, "index-routing/" + indexName);  
            currentState.stateUUID(),
import org.opensearch.cluster.routing.StringKeyDiffProvider;  
import static org.opensearch.gateway.remote.RemoteClusterStateService.REMOTE_PUBLICATION_SETTING_KEY;
import org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff;
import org.mockito.Mockito;
            )  
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
            Settings.builder()  
        assertNull(listener.getFailure());
            0,  
import static org.mockito.Mockito.when;
        ).numberOfShards(between(1, 1000)).numberOfReplicas(randomInt(10)).build();  
        assertNotNull(allIndiceRoutingMetadata);
            "index-uuid",
import static org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64;
                .build()
import static org.mockito.Mockito.doThrow;
import org.opensearch.gateway.remote.RemoteClusterStateUtils;
import org.opensearch.cluster.metadata.IndexMetadata;
        Iterable<String> remotePath = new BlobPath().add("base-path")
            INDEX_ROUTING_METADATA_PREFIX  
        latch.await();
        Settings settings = Settings.builder()  
        );
        InternalRemoteRoutingTableService testRemoteRoutingTableService = new InternalRemoteRoutingTableService(
    }
            threadPool,
        RoutingTable routingTable = RoutingTable.builder().addAsNew(indexMetadata).build();
        );
 * compatible open source license.
    }
import org.opensearch.common.blobstore.BlobStore;
    public void testDeleteStaleIndexRoutingPaths() throws IOException {  
            "test-cluster"
import static org.opensearch.gateway.remote.routingtable.RemoteRoutingTableDiff.ROUTING_TABLE_DIFF_PATH_TOKEN;  
        assertNotNull(allIndiceRoutingMetadata);  
            .metadata(Metadata.builder().coordinationMetadata(CoordinationMetadata.builder().term(1L).build()))
        );
import org.opensearch.core.compress.Compressor;
    }
            String indexName = randomAlphaOfLength(randomIntBetween(1, 50));
            .build();
        blobStoreTransferService = mock(BlobStoreTransferService.class);  
        }
    private BlobStore blobStore;  
            return null;
                .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.test.OpenSearchTestCase;  
        assertEquals(1, diff.provideDiff().getUpserts().size());
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(eq(stalePaths), any());
        assertEquals(0, updatedIndexMetadata.size());
        verify(container).deleteBlobsAsyncIgnoringIfNotExists(eq(stalePaths), any());
                .build()  
        );  
        assertEquals(uploadedIndexMetadata, allIndiceRoutingMetadata.get(0));
        assertEquals(  
        assertEquals(ROUTING_TABLE_DIFF_METADATA_PREFIX, fileNameTokens[0]);
        assertEquals("deletion failed", thrown.getMessage());
        );
        final IndexMetadata indexMetadata = new IndexMetadata.Builder(indexName).settings(
        CountDownLatch latch = new CountDownLatch(1);
            assertNull(listener.getFailure());
        String indexName = randomAlphaOfLength(randomIntBetween(1, 50));  
        assertEquals(fileNameTokens[2], RemoteStoreUtils.invertLong(2L));
