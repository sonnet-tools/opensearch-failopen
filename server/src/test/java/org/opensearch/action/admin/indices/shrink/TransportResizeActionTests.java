                    ise.getMessage(),
                req,
import org.opensearch.snapshots.EmptySnapshotsInfoService;  
                        "source",  
import org.opensearch.index.store.StoreStats;
        resizeRequest.getTargetIndexRequest()
            ResolvedIndices.of("source-index").withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of("target-index")),
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
        // now we start the shard
            TransportResizeAction.calculateTargetIndexShardsNum(
    }
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();  
import org.opensearch.common.util.concurrent.ThreadContext;
        ClusterSettings clusterSettings = createClusterSettings(compatibilityMode, migrationDirection);  
        int numSourceShards = clusterState.metadata().index(indexName).getNumberOfShards();
            new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
                + "], this will disable metadata writes and cause the shards to be unassigned",  
            .settings(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
        );
                indexMetadata
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        resizeRequest.getTargetIndexRequest()
        // clear index settings
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        TransportResizeAction.prepareCreateIndexRequest(
            "target"
            "source",
                new ByteSizeValue(1000),
            .deleted(between(1, 1000))
        String indexName = randomAlphaOfLength(10);  
            new TestGatewayAllocator(),  
        );  
            "target"
        assertEquals("shrink_index", request.cause());
        metaBuilder.put(indexMetadata, false);  
            mock(Client.class)
            (i) -> stats,  
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");  
    private ClusterState createClusterState(String name, int numShards, int numReplicas, Settings settings) {  
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
            case 0:  
import org.opensearch.action.admin.indices.create.CreateIndexAction;  
                        resizeRequest,
import org.opensearch.cluster.ClusterName;
/*  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        );
            createClusterState(indexName, randomIntBetween(2, 10), 0, Settings.builder().put("index.blocks.write", true).build())
        request = TransportResizeAction.prepareCreateIndexRequest(
            .blocks(ClusterBlocks.builder().addBlocks(indexMetadata))  
            resizeRequest,
        ClusterState state = createClusterState(
                IllegalStateException ise = expectThrows(
    public void testShrinkWithMaxShardSize() {
                10,
            new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),  
    ) {
    public void testIndexBlocks() {  
                new ByteSizeValue(1),  
        // now we start the shard  
                clusterSettings,
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                        + " is not allowed as remote migration mode is mixed"
            .settings(settings(Version.CURRENT).put(settings))
        // now we start the shard  
        switch (randomIntBetween(0, 2)) {
import org.opensearch.core.common.unit.ByteSizeValue;
            );
        AllocationService service = new AllocationService(
            );  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        String indexName = randomAlphaOfLength(10);
import org.opensearch.transport.TransportService;
 * Unless required by applicable law or agreed to in writing,
        IndexMetadata indexMetadata = IndexMetadata.builder(name)  
            } else {  
import org.opensearch.common.settings.Settings;  
        TransportResizeAction.prepareCreateIndexRequest(  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            EmptySnapshotsInfoService.INSTANCE
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        DocsStats stats = new DocsStats.Builder().count(between(0, (IndexWriter.MAX_DOCS) / numSourceShards))  
        assertEquals(  
            "target"
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
 *  
        CompatibilityMode compatibilityMode,  
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
        );
        assertEquals(
                        .totalSizeInBytes(between(1, 10000))  
        // now we start the shard
                    clusterSettings,
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                    new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
            ),
            EmptyClusterInfoService.INSTANCE,
            clusterSettings,  
        );  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            clusterState,
                clusterState,
import java.util.HashSet;  
            .settings(
import org.opensearch.threadpool.ThreadPool;  
            null,  
        );  
            (Settings.builder()
                );  
                (i) -> new DocsStats.Builder().count(between(10, 1000)).deleted(between(1, 10)).totalSizeInBytes(between(1, 10000)).build(),
            new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),  
 * license agreements. See the NOTICE file distributed with
        switch (randomIntBetween(0, 2)) {
                new ByteSizeValue(1),
        String cause;  
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
            .setRoutingNumShards(numRoutingShards)
            "source",
            new TestGatewayAllocator(),
        assertEquals(  
        assertNotNull(request.recoverFrom());
            clusterState,  
public class TransportResizeActionTests extends OpenSearchTestCase {
        assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));
                assertEquals("source", request.recoverFrom().getName());
            case SPLIT:  
        ClusterService clusterService = mock(ClusterService.class);
            5  
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();  
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            new BalancedShardsAllocator(Settings.EMPTY),
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),  
                    resizeRequest,
            .totalSizeInBytes(between(1, 10000))
        // now we start the shard
            .metadata(metadata)
        ClusterState clusterState = ClusterState.builder(  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            assertNotNull(request.recoverFrom());
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().put("index.number_of_shards", 2).build());
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            EmptySnapshotsInfoService.INSTANCE
            default:  
            req.getTargetIndexRequest().settings(Settings.builder().put("index.number_of_shards", 4));
            mock(MetadataCreateIndexService.class),
            )
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
                cause = "clone_index";  
            null,  
        DocsStats stats = new DocsStats.Builder().count(between(0, (IndexWriter.MAX_DOCS) / numSourceShards))  
        }
            indexName,
        TransportResizeAction.prepareCreateIndexRequest(
        );
        Metadata.Builder metaBuilder = Metadata.builder();
                expectedShardsNum = 20;
        when(threadPool.getThreadContext()).thenReturn(threadContext);
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                    () -> TransportResizeAction.prepareCreateIndexRequest(  
                "target"  
                resizeRequest,  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            .totalSizeInBytes(between(1, 10000))
            new BalancedShardsAllocator(Settings.EMPTY),  
                IllegalStateException.class,
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().build());
        );  
        AllocationService service = new AllocationService(
                expectedShardsNum = 10;
        CompatibilityMode compatibilityMode = randomFrom(CompatibilityMode.values());  
                Settings.builder().put("index.blocks.write", true).put(SETTING_REMOTE_STORE_ENABLED, isRemoteStoreEnabled).build()
        );  
        assertEquals(
        assertNotNull(request.recoverFrom());
            default:
            EmptySnapshotsInfoService.INSTANCE  
import org.opensearch.test.OpenSearchTestCase;
        if (compatibilityMode == CompatibilityMode.MIXED) {  
        }
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().build());  
        // clear index settings
                    : null,
        ClusterState clusterState = ClusterState.builder(  
                        + " and index is remote store "  
            "target"
                    clusterState,  
        ThreadPool threadPool = mock(ThreadPool.class);
                resizeRequest,  
        );
import org.opensearch.Version;
 * GitHub history for details.
        ClusterState clusterState = ClusterState.builder(
                indexMetadata
        CreateIndexClusterStateUpdateRequest request = TransportResizeAction.prepareCreateIndexRequest(  
            indexName,  
 *    http://www.apache.org/licenses/LICENSE-2.0
                resizeType = ResizeType.SPLIT;  
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().put("index.number_of_shards", randomIntBetween(1, 100)).build());
        resizeRequest.setResizeType(resizeType);  
        indexMetadata = clusterState.metadata().index(indexName);
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().build());
            1  
            clusterState,
            TransportResizeAction.calculateTargetIndexShardsNum(
import java.util.Arrays;
            threadPool,
import org.apache.lucene.index.IndexWriter;
                assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));  
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();  
        resizeRequest.setWaitForActiveShards(activeShardCount);
    }
            clusterState,  
            indexName,
}  
        resizeRequest.setResizeType(resizeType);  
            ).getMessage().startsWith("Can't merge index with more than [2147483519] docs - too many documents in shards ")
        assertEquals(request.waitForActiveShards(), activeShardCount);
            null,
                finalState,
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();  
        RemoteStoreNodeService.Direction migrationDirection = randomFrom(RemoteStoreNodeService.Direction.values());
            createClusterState("source", randomIntBetween(2, 10), 0, Settings.builder().put("index.blocks.write", true).build())  
                "target"  
        resizeRequest.setWaitForActiveShards(expectedShardsNum);
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
 *
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();  
        switch (resizeType) {
        ClusterState finalState = clusterState;
        );
            indexName,  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
                "target"  
            default:
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");  
        );
                .put(MIGRATION_DIRECTION_SETTING.getKey(), migrationDirection)).build()
        assertNotNull(request.recoverFrom());  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        } else {
            TransportResizeAction.prepareCreateIndexRequest(  
            ),
                    "target"  
            .build();
            () -> TransportResizeAction.prepareCreateIndexRequest(
 */  
        }).getMessage().startsWith("Can't merge index with more than [2147483519] docs - too many documents in shards "));
            EmptySnapshotsInfoService.INSTANCE
            indexMetadata.getNumberOfShards()
    public void testShrinkIndexSettings() {  
        ClusterState clusterState = ClusterState.builder(
        assertEquals(
                clusterSettings,
                "source",
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),  
        assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));
        assertEquals(request.waitForActiveShards(), ActiveShardCount.from(expectedShardsNum));  
        boolean isRemoteStoreEnabled = randomBoolean();
                Settings.builder().put("index.blocks.write", true).put("index.soft_deletes.enabled", true).build()
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.node.DiscoveryNodes;
        ResolvedIndices resolvedIndices = action.resolveIndices(new ResizeRequest("target-index", "source-index"));
            new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        AllocationService service = new AllocationService(  
            clusterSettings,
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
                indexMetadata  
                "target"  
    public void testPassNumRoutingShards() {  
        expectedShardsNum = numSourceShards;  
                    new ResizeRequest("target", "source"),  
        resizeRequest.setWaitForActiveShards(expectedShardsNum);  
                1,
        assertEquals(
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
            ResizeRequest req = new ResizeRequest("target", "source");  
                finalState,
                    (i) -> stats,
import org.opensearch.cluster.routing.RoutingTable;
            new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),  
        CreateIndexClusterStateUpdateRequest request = TransportResizeAction.prepareCreateIndexRequest(  
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            case 1:  
        ResizeRequest target = new ResizeRequest("target", indexName);
        int numSourceShards = clusterState.metadata().index(indexName).getNumberOfShards();
        IllegalArgumentException iae = expectThrows(  
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();  
                resizeType = ResizeType.CLONE;
            );
            );
        );
                Settings.builder().put("index.number_of_shards", numShards * 2).put("index.number_of_routing_shards", numShards * 2).build()  
            10
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
 * ownership. Elasticsearch licenses this file to you under  
            new TestGatewayAllocator(),
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        );
                assertNotNull(request.recoverFrom());
            assertEquals(cause, request.cause());
            EmptyClusterInfoService.INSTANCE,
        DocsStats stats = new DocsStats.Builder().count(between(0, (IndexWriter.MAX_DOCS) / 10))  
            mock(TransportService.class),
 * KIND, either express or implied.  See the License for the
            ),
        // target index's shards number must be the lowest factor of the source index's shards number
import org.opensearch.cluster.routing.allocation.AllocationService;  
                    clusterSettings,  
                        .build(),
    }
        DocsStats stats = new DocsStats.Builder().count(between(0, (IndexWriter.MAX_DOCS) / numSourceShards))  
 * Modifications Copyright OpenSearch Contributors. See
            resizeRequest,  
            new BalancedShardsAllocator(Settings.EMPTY),
                expectedShardsNum = 5;  
            TransportResizeAction.calculateTargetIndexShardsNum(
        );  
                indexName,
            clusterSettings,
            EmptySnapshotsInfoService.INSTANCE
                )
                indexMetadata  
            .totalSizeInBytes(between(1, 10000))
                8,  
            ),  
    private DiscoveryNode newNode(String nodeId) {  
        int expectedShardsNum;
                    ? new DocsStats.Builder().count(Integer.MAX_VALUE / 2)
            clusterSettings,
        assertEquals(  
        TransportResizeAction action = new TransportResizeAction(
        String indexName = randomAlphaOfLength(10);
            .deleted(between(1, 1000))
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
                clusterSettings,  
import org.opensearch.common.settings.ClusterSettings;
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().put("index.number_of_shards", numShards * 2).build());
                new StoreStats.Builder().sizeInBytes(0).reservedSize(0).build(),  
        // now we start the shard
        });
        );
                new ByteSizeValue(20),
            EmptyClusterInfoService.INSTANCE,  
        );
        target.setWaitForActiveShards(activeShardCount);  
        AllocationService service = new AllocationService(  
                indexMetadata
import org.opensearch.cluster.EmptyClusterInfoService;  
            new TestGatewayAllocator(),
                new ByteSizeValue(50),
            1
        // create one that won't fail
            iae.getMessage()
                ClusterState finalState = clusterState;  
            new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
        );  
 * specific language governing permissions and limitations
                (i) -> stats,
import org.opensearch.cluster.node.DiscoveryNode;
                indexMetadata  
        assertTrue(
                    "source",
        // create one that won't fail
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();
        // So we only need to test for the failures due to cluster setting validation while migration
                expectedShardsNum = 10;  
                    state,
            clusterState,
        resizeRequest.setResizeType(ResizeType.SPLIT);
            indexName,
        );
                CreateIndexClusterStateUpdateRequest request = TransportResizeAction.prepareCreateIndexRequest(
            .deleted(between(1, 1000))
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
            EmptyClusterInfoService.INSTANCE,
        RoutingTable routingTable = routingTableBuilder.build();
            ),  
            "source",  
        // clear index settings  
                indexMetadata
            .settings(Settings.builder().put("index.number_of_shards", expectedShardsNum).put("index.blocks.read_only", false).build());  
            clusterSettings,
                new ByteSizeValue(10),
        resizeRequest.setResizeType(ResizeType.SPLIT);
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
    }  
            target,
        assertEquals(TransportResizeAction.calculateTargetIndexShardsNum(new ByteSizeValue(1), null, indexMetadata), 1);
                break;
            expectThrows(  
            1  
                cause = "split_index";
        expectedShardsNum = 1;
        );  
            (i) -> stats,  
                assertEquals(request.waitForActiveShards(), activeShardCount);
            new BalancedShardsAllocator(Settings.EMPTY),
        // Target index will be blocked by [index.blocks.read_only=true] copied from the source index
        assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));  
            .build();  
            resizeRequest,
            "target"  
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), compatibilityMode)  
                    IllegalStateException.class,
        );
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();  
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();
        );  
                "source",
        ResizeType resizeType;
                new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),  
        // If not mixed mode, then migration direction is NONE.
                resizeType = ResizeType.SHRINK;
import org.opensearch.action.support.ActionFilters;
            new TestGatewayAllocator(),
        );
        resizeRequest.setMaxShardSize(new ByteSizeValue(1));
        ClusterState clusterState = ClusterState.builder(  
            assertEquals(request.waitForActiveShards(), activeShardCount);  
        assertEquals(request.waitForActiveShards(), ActiveShardCount.from(expectedShardsNum));
    }
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, indexName).routingTable();  
            TransportResizeAction.calculateTargetIndexShardsNum(
                clusterState,  
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        ResizeRequest resizeRequest = new ResizeRequest("target", indexName);  
                assertEquals(cause, request.cause());
            }  
import org.opensearch.cluster.ClusterState;
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
                    (i) -> new DocsStats.Builder().count(Integer.MAX_VALUE)
            new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
            .build();
import org.opensearch.cluster.service.ClusterService;
                        .build()
import java.util.Set;
            resizeRequest,
    }
                cause = "shrink_index";
        ResizeRequest resizeRequest = new ResizeRequest("target", indexName);
                resizeType = ResizeType.SHRINK;
        return createClusterState(name, numShards, numReplicas, numShards, settings);
        String cause;
        routingTableBuilder.addAsNew(metadata.index(name));  
            "target index [target] will be blocked by [index.blocks.read_only=true] which is copied from the source index ["
                "source",
                (i) -> i == 2 || i == 3  
        final ActiveShardCount activeShardCount = randomBoolean() ? ActiveShardCount.ALL : ActiveShardCount.ONE;  
                    "source",
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
            mock(ActionFilters.class),  
            );  
    public void testPassNumRoutingShardsAndFail() {
 * You may obtain a copy of the License at  
            EmptyClusterInfoService.INSTANCE,
        if (!compatibilityMode.equals(CompatibilityMode.MIXED)) {  
                resizeRequest,  
        AllocationService service = new AllocationService(  
        assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static java.util.Collections.emptyMap;  
            resizeRequest,
                new ByteSizeValue(0),
        // We will keep all other settings correct for resize request,  
            migrationDirection = RemoteStoreNodeService.Direction.NONE;
import org.opensearch.cluster.metadata.IndexMetadata;  
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();  
            new BalancedShardsAllocator(Settings.EMPTY),
                );  
            clusterState,  
        );
        ResizeType resizeType;
        assertEquals(  
        IllegalArgumentException iae = expectThrows(  
        resizeRequest.setWaitForActiveShards(expectedShardsNum);
package org.opensearch.action.admin.indices.shrink;
            "source",
                Settings.builder().put("index.number_of_routing_shards", randomIntBetween(2, 10)).put("index.number_of_shards", 2).build()  
            TransportResizeAction.calculateTargetIndexShardsNum(  
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),  
        ClusterState clusterState = ClusterState.builder(
            TransportResizeAction.calculateTargetIndexShardsNum(
                        .deleted(between(1, 1000))  
/*
        }
 */  
            EmptySnapshotsInfoService.INSTANCE
            case 0:  
        assertEquals(
                new ByteSizeValue(12),  
        final ActiveShardCount activeShardCount = randomBoolean() ? ActiveShardCount.ALL : ActiveShardCount.ONE;
                break;
            IllegalArgumentException.class,
        assertNotNull(request.recoverFrom());
        int numShards = randomIntBetween(2, 100);
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
import org.opensearch.transport.client.Client;
            clusterService,  
        assertEquals(indexName, request.recoverFrom().getName());
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
                        (i) -> stats,  
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;  
    private ClusterSettings createClusterSettings(
            "target"
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
                break;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            ResizeRequest req = new ResizeRequest("target", "source");
            .build();  
        ClusterState clusterState = ClusterState.builder(
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),  
            createClusterState(  
            createClusterState(indexName, randomIntBetween(2, 10), 0, Settings.builder().put("index.blocks.write", true).build())  
            assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, indexName).routingTable();  
                cause = "shrink_index";  
import static org.mockito.Mockito.when;
            TransportResizeAction.calculateTargetIndexShardsNum(  
        );
            randomIntBetween(2, 42),  
        }
            "target"  
        );  
        );
            IllegalArgumentException.class,
import org.opensearch.node.remotestore.RemoteStoreNodeService;
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
            "source",  
            .routingTable(routingTable)
                resizeType = ResizeType.CLONE;
            clusterState,
import org.opensearch.action.support.ActiveShardCount;  
        // if max_shard_size is greater than whole of the source primary shards' storage,  
    }
        return clusterSettings;  
            assertEquals("source", request.recoverFrom().getName());  
    private ClusterState createClusterState(String name, int numShards, int numReplicas, int numRoutingShards, Settings settings) {
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;  
 * under the License.  
            .deleted(between(1, 1000))
            new BalancedShardsAllocator(Settings.EMPTY),  
                expectedShardsNum = 5;
            clusterSettings,  
        resizeRequest.getTargetIndexRequest()
        int expectedShardsNum = 5;  
                        + (isRemoteStoreEnabled ? "enabled" : "disabled")
        IllegalArgumentException softDeletesError = expectThrows(IllegalArgumentException.class, () -> {
        ClusterState finalState = clusterState;
import org.opensearch.cluster.metadata.MetadataCreateIndexService;  
                resizeType = ResizeType.SPLIT;
        Metadata metadata = metaBuilder.build();
        assertEquals(request.waitForActiveShards(), activeShardCount);
        int expectedShardsNum;  
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
            clusterState,
                "source",
        CreateIndexClusterStateUpdateRequest request = TransportResizeAction.prepareCreateIndexRequest(
import static org.opensearch.common.util.FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL;
        IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
                break;
                req,
        resizeRequest.setWaitForActiveShards(activeShardCount);
 * compatible open source license.
            EmptySnapshotsInfoService.INSTANCE
 */
/*  
 *
        request = TransportResizeAction.prepareCreateIndexRequest(
        );
    }
        );  
                new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),  
                cause = "clone_index";
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            indexMetadata.getNumberOfShards()
        );  
    public void testResolveIndices() {
                        new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
            createClusterState("source", 1, 0, Settings.builder().put("index.blocks.write", true).build())
                cause = "split_index";
            )
                        .totalSizeInBytes(between(1, 100))
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
                break;
            ),
            new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
            new BalancedShardsAllocator(Settings.EMPTY),  
        assertEquals(  
                null,
        int numSourceShards = clusterState.metadata().index(indexName).getNumberOfShards();
            .build();  
                clusterSettings,
            .settings(Settings.builder().put("index.number_of_shards", expectedShardsNum).put("index.blocks.read_only", false).build());
                "source",
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            ),
            createClusterState(indexName, 10, 0, Settings.builder().put("index.blocks.write", true).build())  
            resizeRequest,
 * this file be licensed under the Apache-2.0 license or a
            1
            clusterSettings,
            CreateIndexClusterStateUpdateRequest request = TransportResizeAction.prepareCreateIndexRequest(
import org.opensearch.test.gateway.TestGatewayAllocator;
            createClusterState(indexName, 10, 0, Settings.builder().put("index.blocks.write", true).build())
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
            ClusterState clusterState = createClusterState("source", 8, 1, Settings.builder().put("index.blocks.write", true).build());
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
            "target"
                null,
import org.opensearch.cluster.metadata.ResolvedIndices;
import static org.mockito.Mockito.mock;
                indexMetadata
        RemoteStoreNodeService.Direction migrationDirection
import static org.hamcrest.CoreMatchers.equalTo;  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(indexName, request.recoverFrom().getName());
                    new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),  
            )  
    public void testErrorCondition() {  
            clusterSettings,
            );
        String indexName = randomAlphaOfLength(10);
 * not use this file except in compliance with the License.
            clusterSettings,  
                expectedShardsNum = 20;
    }
            () -> TransportResizeAction.prepareCreateIndexRequest(
        // then the target index will only have one primary shard.
 * this work for additional information regarding copyright
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();  
            .build();  
            Settings.builder().put("index.blocks.write", true).build()
            EmptyClusterInfoService.INSTANCE,  
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
            TransportResizeAction.prepareCreateIndexRequest(
        AllocationService service = new AllocationService(
            new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        assertEquals("shrink_index", request.cause());
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
        assertEquals("shrink_index", request.cause());  
            if ((migrationDirection == RemoteStoreNodeService.Direction.REMOTE_STORE && isRemoteStoreEnabled == false)
            case SHRINK:
            .numberOfShards(numShards)
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
    public void testCalculateTargetIndexShardsNum() {  
        assertEquals(cause, request.cause());  
 * software distributed under the License is distributed on an
    }  
            (i) -> stats,
            "target"
                break;  
        clusterState = ClusterState.builder(
                "target"
        assertEquals("shrink_index", request.cause());
        return clusterState;
 * the Apache License, Version 2.0 (the "License"); you may
                    "Index "  
                + indexName
                clusterSettings,
            TransportResizeAction.calculateTargetIndexShardsNum(  
            .totalSizeInBytes(between(1, 10000))
            new TestGatewayAllocator(),
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),  
        AllocationService service = new AllocationService(
                "source",
            case 1:
        assertEquals(indexName, request.recoverFrom().getName());
        assertEquals(indexName, request.recoverFrom().getName());  
            ),
                clusterState,
            (i) -> new DocsStats.Builder().count(between(1, 1000)).deleted(between(1, 1000)).totalSizeInBytes(between(0, 10000)).build(),
            .numberOfReplicas(numReplicas)  
            EmptyClusterInfoService.INSTANCE,  
        TransportResizeAction.prepareCreateIndexRequest(  
        assertNotNull(request.recoverFrom());  
            resolvedIndices
        clusterSettings.applySettings(
                new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
        assertEquals(indexName, request.recoverFrom().getName());
 * Licensed to Elasticsearch under one or more contributor  
            ),  
        resizeRequest.setMaxShardSize(new ByteSizeValue(1000));  
                );
        // then the target index's shards number will be equal to the source index's.
        assertThat(softDeletesError.getMessage(), equalTo("Can't disable [index.soft_deletes.enabled] setting on resize"));
            (i) -> stats,
            req.getTargetIndexRequest().settings(Settings.builder().put("index.soft_deletes.enabled", false));  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
    }
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
        );  
                    "target"
            ClusterState clusterState = createClusterState(
        resizeRequest.setMaxShardSize(new ByteSizeValue(25));
        // now we start the shard
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        assertEquals(
    }
            new ResizeRequest("target", "source"),
                        clusterSettings,
        final ActiveShardCount activeShardCount = randomBoolean() ? ActiveShardCount.ALL : ActiveShardCount.ONE;
            createClusterState("source", numShards, 0, numShards * 4, Settings.builder().put("index.blocks.write", true).build())
        // if max_shard_size is less than the primary shard's storage of the source index,
            (i) -> stats,
        ClusterState clusterState = ClusterState.builder(
        );
        assertEquals(request.waitForActiveShards(), ActiveShardCount.from(expectedShardsNum));
                assertEquals(
            randomIntBetween(0, 10),
                    )
                        .deleted(between(1, 1000))
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");
                new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),  
        );  
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, indexName).routingTable();  
        assertTrue(expectThrows(IllegalStateException.class, () -> {
                () -> TransportResizeAction.prepareCreateIndexRequest(
        // Overwrites the source index's settings index.blocks.read_only, so resize won't fail
        );
            TransportResizeAction.calculateTargetIndexShardsNum(
            2
            new TestGatewayAllocator(),
        assertEquals("1", request.settings().get("index.number_of_shards"));  
import java.util.Collections;
        // create one that won't fail
import org.opensearch.index.shard.DocsStats;  
                40,
        resizeRequest.getTargetIndexRequest()
            resizeRequest,  
        assertEquals("cannot provide index.number_of_routing_shards on resize", iae.getMessage());  
                        finalState,
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
                        + resizeType
        }
    }
import org.opensearch.cluster.block.ClusterBlocks;
    public void testResizeFailuresDuringMigration() {
                        "target"
                null,  
                || migrationDirection == RemoteStoreNodeService.Direction.DOCREP && isRemoteStoreEnabled == true) {
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
                0,  
            createClusterState(indexName, 10, 0, 40, Settings.builder().put("index.blocks.read_only", true).build())
                indexMetadata
        // create one that won't fail
            clusterState,
