            .totalSizeInBytes(between(1, 10000))
            new BalancedShardsAllocator(Settings.EMPTY),
        // now we start the shard
        ClusterState clusterState = ClusterState.builder(
            .settings(Settings.builder().put("index.number_of_shards", expectedShardsNum).put("index.blocks.read_only", false).build());
                        + " and index is remote store "
        assertEquals(TransportResizeAction.calculateTargetIndexShardsNum(new ByteSizeValue(1), null, indexMetadata), 1);
    }
            "source",
            .build();
                assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));
        );
            EmptySnapshotsInfoService.INSTANCE
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            EmptyClusterInfoService.INSTANCE,
            case 1:
                "source",
        AllocationService service = new AllocationService(
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().build());
                assertEquals(request.waitForActiveShards(), activeShardCount);
        assertEquals(request.waitForActiveShards(), ActiveShardCount.from(expectedShardsNum));
                new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
        assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));
            resizeRequest,
            );
                expectedShardsNum = 20;
    ) {
            TransportResizeAction.calculateTargetIndexShardsNum(
        CreateIndexClusterStateUpdateRequest request = TransportResizeAction.prepareCreateIndexRequest(
                indexName,
            createClusterState("source", randomIntBetween(2, 10), 0, Settings.builder().put("index.blocks.write", true).build())
        );
            () -> TransportResizeAction.prepareCreateIndexRequest(
}
                resizeType = ResizeType.CLONE;
        assertEquals(
        }
                40,
                new ByteSizeValue(1),
                        + " is not allowed as remote migration mode is mixed"
            createClusterState(indexName, 10, 0, Settings.builder().put("index.blocks.write", true).build())
        TransportResizeAction.prepareCreateIndexRequest(
            "target"
import org.opensearch.snapshots.EmptySnapshotsInfoService;
                cause = "split_index";
import org.opensearch.cluster.node.DiscoveryNodes;
 * specific language governing permissions and limitations
            clusterState,
import org.opensearch.test.gateway.TestGatewayAllocator;
            .deleted(between(1, 1000))
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        IndexMetadata indexMetadata = IndexMetadata.builder(name)
                        "source",
                resizeType = ResizeType.SHRINK;
        expectedShardsNum = 1;
        );
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        assertTrue(
            (i) -> stats,
            indexName,
import org.opensearch.node.remotestore.RemoteStoreNodeService;
        AllocationService service = new AllocationService(
            new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));
            randomIntBetween(0, 10),
                + "], this will disable metadata writes and cause the shards to be unassigned",
                        clusterSettings,
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();
        );
            TransportResizeAction.calculateTargetIndexShardsNum(
        ClusterState state = createClusterState(
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");
            null,
            new TestGatewayAllocator(),
        Metadata.Builder metaBuilder = Metadata.builder();
        // We will keep all other settings correct for resize request,
            )
                cause = "split_index";
        // clear index settings
                new ByteSizeValue(0),
    }
                    resizeRequest,
import org.opensearch.action.support.ActionFilters;
import static org.mockito.Mockito.mock;
            case SPLIT:
    }
            "target"
                expectedShardsNum = 5;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
                        + (isRemoteStoreEnabled ? "enabled" : "disabled")
 * compatible open source license.
                break;
    private ClusterState createClusterState(String name, int numShards, int numReplicas, int numRoutingShards, Settings settings) {
        resizeRequest.setWaitForActiveShards(expectedShardsNum);
    }
            () -> TransportResizeAction.prepareCreateIndexRequest(
        );
            threadPool,
        );
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
                    : null,
        resizeRequest.setMaxShardSize(new ByteSizeValue(1000));
            .deleted(between(1, 1000))
                Settings.builder().put("index.blocks.write", true).put("index.soft_deletes.enabled", true).build()
            expectThrows(
        TransportResizeAction.prepareCreateIndexRequest(
                (i) -> stats,
    private ClusterSettings createClusterSettings(
import org.opensearch.common.settings.ClusterSettings;
                new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
                cause = "shrink_index";
        int expectedShardsNum;
        // target index's shards number must be the lowest factor of the source index's shards number
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
        String indexName = randomAlphaOfLength(10);
/*
        ClusterSettings clusterSettings = createClusterSettings(compatibilityMode, migrationDirection);
        assertEquals(request.waitForActiveShards(), ActiveShardCount.from(expectedShardsNum));
        assertEquals(indexName, request.recoverFrom().getName());
            clusterState,
        IllegalArgumentException iae = expectThrows(
            clusterSettings,
 * the Apache License, Version 2.0 (the "License"); you may
        assertNotNull(request.recoverFrom());
 * Unless required by applicable law or agreed to in writing,
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();
            IllegalArgumentException.class,
        clusterState = ClusterState.builder(
            clusterSettings,
        );
import java.util.Set;
        // clear index settings
                req,
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .build(),
        );
            new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
                    "source",
                new StoreStats.Builder().sizeInBytes(0).reservedSize(0).build(),
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));
                "source",
                resizeRequest,
        assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));
                "target"
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
        assertEquals(request.waitForActiveShards(), activeShardCount);
        resizeRequest.getTargetIndexRequest()
import org.opensearch.cluster.routing.RoutingTable;
                indexMetadata
            EmptyClusterInfoService.INSTANCE,
            clusterSettings,
        assertEquals(indexName, request.recoverFrom().getName());
        switch (randomIntBetween(0, 2)) {
        if (!compatibilityMode.equals(CompatibilityMode.MIXED)) {
        String indexName = randomAlphaOfLength(10);
        assertEquals(
        DocsStats stats = new DocsStats.Builder().count(between(0, (IndexWriter.MAX_DOCS) / numSourceShards))
                indexMetadata
                expectedShardsNum = 10;
                clusterSettings,
        );
        assertEquals(indexName, request.recoverFrom().getName());
        ClusterState clusterState = ClusterState.builder(
        AllocationService service = new AllocationService(
                resizeType = ResizeType.SHRINK;
                clusterState,
                new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
 * The OpenSearch Contributors require contributions made to
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");
            ),
                );
        assertEquals("cannot provide index.number_of_routing_shards on resize", iae.getMessage());
        target.setWaitForActiveShards(activeShardCount);
            (i) -> stats,
            );
    public void testResolveIndices() {
        resizeRequest.setMaxShardSize(new ByteSizeValue(1));
 * software distributed under the License is distributed on an
            clusterSettings,
        clusterSettings.applySettings(
                indexMetadata
        RemoteStoreNodeService.Direction migrationDirection
                break;
        );
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
    private DiscoveryNode newNode(String nodeId) {
                indexMetadata
            ).getMessage().startsWith("Can't merge index with more than [2147483519] docs - too many documents in shards ")
        ResizeRequest resizeRequest = new ResizeRequest("target", "source");
                    )
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
            ),
                    "source",
 */
            TransportResizeAction.calculateTargetIndexShardsNum(
            resizeRequest,
            ),
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
            EmptySnapshotsInfoService.INSTANCE
            (i) -> stats,
            EmptySnapshotsInfoService.INSTANCE
                CreateIndexClusterStateUpdateRequest request = TransportResizeAction.prepareCreateIndexRequest(
                IllegalStateException.class,
            }
    private ClusterState createClusterState(String name, int numShards, int numReplicas, Settings settings) {
        IndexMetadata indexMetadata = clusterState.metadata().index(indexName);
            .build();
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        RoutingTable routingTable = routingTableBuilder.build();
        boolean isRemoteStoreEnabled = randomBoolean();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
            .build();
        DocsStats stats = new DocsStats.Builder().count(between(0, (IndexWriter.MAX_DOCS) / numSourceShards))
                    (i) -> stats,
import org.opensearch.cluster.block.ClusterBlocks;
 *
import org.opensearch.common.settings.Settings;
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().put("index.number_of_shards", numShards * 2).build());
        resizeRequest.setWaitForActiveShards(expectedShardsNum);
import static org.opensearch.node.remotestore.RemoteStoreNodeService.CompatibilityMode;
                "source",
                .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), compatibilityMode)
        resizeRequest.setResizeType(resizeType);
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, indexName).routingTable();
            ClusterState clusterState = createClusterState("source", 8, 1, Settings.builder().put("index.blocks.write", true).build());
        );
                clusterState,
            null,
                req,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // now we start the shard
            ClusterState clusterState = createClusterState(
    public void testShrinkIndexSettings() {
                assertEquals(
        assertEquals(request.waitForActiveShards(), ActiveShardCount.from(expectedShardsNum));
            "target"
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        return clusterState;
            case SHRINK:
        assertEquals(
            "target"
            createClusterState(indexName, 10, 0, 40, Settings.builder().put("index.blocks.read_only", true).build())
            EmptySnapshotsInfoService.INSTANCE
            req.getTargetIndexRequest().settings(Settings.builder().put("index.soft_deletes.enabled", false));
                indexMetadata
            assertNotNull(request.recoverFrom());
import org.opensearch.transport.client.Client;
                expectedShardsNum = 10;
            "target"
        resizeRequest.setResizeType(resizeType);
                Settings.builder().put("index.number_of_routing_shards", randomIntBetween(2, 10)).put("index.number_of_shards", 2).build()
            default:
 * GitHub history for details.
            mock(Client.class)
                    clusterSettings,
                );
                expectedShardsNum = 20;
 * You may obtain a copy of the License at
                indexMetadata
import static java.util.Collections.emptyMap;
            new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
                        .totalSizeInBytes(between(1, 10000))
        IllegalArgumentException softDeletesError = expectThrows(IllegalArgumentException.class, () -> {
 * SPDX-License-Identifier: Apache-2.0
/*
    public void testResizeFailuresDuringMigration() {
                    clusterState,
            indexMetadata.getNumberOfShards()
            assertEquals(request.waitForActiveShards(), activeShardCount);
            "source",
            new BalancedShardsAllocator(Settings.EMPTY),
        }
        assertEquals(
 * not use this file except in compliance with the License.
        TransportResizeAction.prepareCreateIndexRequest(
 * under the License.
            new TestGatewayAllocator(),
        routingTableBuilder.addAsNew(metadata.index(name));
                expectedShardsNum = 5;
        assertThat(softDeletesError.getMessage(), equalTo("Can't disable [index.soft_deletes.enabled] setting on resize"));
            .deleted(between(1, 1000))
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            EmptySnapshotsInfoService.INSTANCE
                break;
            new TestGatewayAllocator(),
            (Settings.builder()
        assertNotNull(request.recoverFrom());
                IllegalStateException ise = expectThrows(
        int numSourceShards = clusterState.metadata().index(indexName).getNumberOfShards();
        AllocationService service = new AllocationService(
            new TestGatewayAllocator(),
    }
            TransportResizeAction.calculateTargetIndexShardsNum(
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        when(threadPool.getThreadContext()).thenReturn(threadContext);
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
        // now we start the shard
        ResizeType resizeType;
            TransportResizeAction.calculateTargetIndexShardsNum(
            case 0:
            ),
                10,
            IllegalArgumentException.class,
        DocsStats stats = new DocsStats.Builder().count(between(0, (IndexWriter.MAX_DOCS) / 10))
            mock(MetadataCreateIndexService.class),
                "target"
            clusterState,
    public void testIndexBlocks() {
            TransportResizeAction.calculateTargetIndexShardsNum(
            clusterState,
            5
                clusterState,
        );
import org.opensearch.index.shard.DocsStats;
                new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
                null,
            indexMetadata.getNumberOfShards()
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
        final Set<DiscoveryNodeRole> roles = Collections.unmodifiableSet(
            mock(TransportService.class),
            1
                "source",
            ),
        TransportResizeAction.prepareCreateIndexRequest(
            new TestGatewayAllocator(),
        resizeRequest.setResizeType(ResizeType.SPLIT);
            CreateIndexClusterStateUpdateRequest request = TransportResizeAction.prepareCreateIndexRequest(
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.store.StoreStats;
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();
    }
public class TransportResizeActionTests extends OpenSearchTestCase {
import org.opensearch.cluster.node.DiscoveryNodeRole;
        ResizeRequest target = new ResizeRequest("target", indexName);
                .put(MIGRATION_DIRECTION_SETTING.getKey(), migrationDirection)).build()
 *
            )
 * KIND, either express or implied.  See the License for the
                        resizeRequest,
            resizeRequest,
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            10
                indexMetadata
        );
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
        metaBuilder.put(indexMetadata, false);
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        // create one that won't fail
import org.opensearch.cluster.service.ClusterService;
        assertEquals(
            case 0:
        );
                8,
        resizeRequest.setResizeType(ResizeType.SPLIT);
        ClusterState finalState = clusterState;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .totalSizeInBytes(between(1, 10000))
        }
            );
        // then the target index will only have one primary shard.
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
        );
                        .deleted(between(1, 1000))
            .deleted(between(1, 1000))
            .settings(Settings.builder().put("index.number_of_shards", expectedShardsNum).put("index.blocks.read_only", false).build());
            ResizeRequest req = new ResizeRequest("target", "source");
            resizeRequest,
        ThreadPool threadPool = mock(ThreadPool.class);
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
            (i) -> stats,
            .numberOfShards(numShards)
                        .totalSizeInBytes(between(1, 100))
 * Licensed to Elasticsearch under one or more contributor
        }
        ResizeType resizeType;
            resolvedIndices
 * license agreements. See the NOTICE file distributed with
                || migrationDirection == RemoteStoreNodeService.Direction.DOCREP && isRemoteStoreEnabled == true) {
                indexMetadata
                new ByteSizeValue(1000),
                    "Index "
            ),
                "source",
        indexMetadata = clusterState.metadata().index(indexName);
        request = TransportResizeAction.prepareCreateIndexRequest(
            EmptySnapshotsInfoService.INSTANCE
            "source",
            assertEquals("source", request.recoverFrom().getName());
                (i) -> i == 2 || i == 3
                new ByteSizeValue(10),
            new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
                cause = "clone_index";
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
        RemoteStoreNodeService.Direction migrationDirection = randomFrom(RemoteStoreNodeService.Direction.values());
            new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                cause = "shrink_index";
            .build();
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
    public void testShrinkWithMaxShardSize() {
            resizeRequest,
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    ise.getMessage(),
        AllocationService service = new AllocationService(
        assertEquals("1", request.settings().get("index.number_of_shards"));
            clusterState,
        assertEquals("shrink_index", request.cause());
                resizeType = ResizeType.CLONE;
            target,
            new TestGatewayAllocator(),
            new BalancedShardsAllocator(Settings.EMPTY),
import java.util.HashSet;
            createClusterState(indexName, randomIntBetween(2, 10), 0, Settings.builder().put("index.blocks.write", true).build())
                indexMetadata
 *
import org.opensearch.Version;
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        assertEquals(cause, request.cause());
        resizeRequest.getTargetIndexRequest()
        });
            new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.DATA_ROLE))
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        String cause;
import org.opensearch.common.util.concurrent.ThreadContext;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
            EmptyClusterInfoService.INSTANCE,
    public void testErrorCondition() {
            ResolvedIndices.of("source-index").withLocalSubActions(CreateIndexAction.INSTANCE, ResolvedIndices.Local.of("target-index")),
        assertEquals(
            resizeRequest,
            mock(ActionFilters.class),
            clusterState,
                resizeRequest,
        );
            new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
import org.opensearch.cluster.node.DiscoveryNode;
            );
                new ByteSizeValue(12),
            req.getTargetIndexRequest().settings(Settings.builder().put("index.number_of_shards", 4));
        IllegalArgumentException iae = expectThrows(
        assertEquals("shrink_index", request.cause());
        assertEquals(
                new ByteSizeValue(50),
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().put("index.number_of_shards", 2).build());
            clusterState,
                (i) -> new DocsStats.Builder().count(between(10, 1000)).deleted(between(1, 10)).totalSizeInBytes(between(1, 10000)).build(),
            .numberOfReplicas(numReplicas)
            createClusterState(indexName, 10, 0, Settings.builder().put("index.blocks.write", true).build())
        resizeRequest.setWaitForActiveShards(expectedShardsNum);
                clusterSettings,
package org.opensearch.action.admin.indices.shrink;
            .totalSizeInBytes(between(1, 10000))
            .totalSizeInBytes(between(1, 10000))
                Settings.builder().put("index.number_of_shards", numShards * 2).put("index.number_of_routing_shards", numShards * 2).build()
                finalState,
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        );
        assertNotNull(request.recoverFrom());
                    (i) -> new DocsStats.Builder().count(Integer.MAX_VALUE)
    }
            EmptyClusterInfoService.INSTANCE,
        switch (randomIntBetween(0, 2)) {
        resizeRequest.getTargetIndexRequest()
        expectedShardsNum = numSourceShards;
                        finalState,
        switch (resizeType) {
        // clear index settings
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
        ResolvedIndices resolvedIndices = action.resolveIndices(new ResizeRequest("target-index", "source-index"));
            default:
        );
            .settings(
            migrationDirection = RemoteStoreNodeService.Direction.NONE;
/*
            if ((migrationDirection == RemoteStoreNodeService.Direction.REMOTE_STORE && isRemoteStoreEnabled == false)
            new BalancedShardsAllocator(Settings.EMPTY),
            .settings(settings(Version.CURRENT).put(settings))
        int numSourceShards = clusterState.metadata().index(indexName).getNumberOfShards();
            .settings(
        assertEquals(
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
        DocsStats stats = new DocsStats.Builder().count(between(0, (IndexWriter.MAX_DOCS) / numSourceShards))
        AllocationService service = new AllocationService(
            EmptyClusterInfoService.INSTANCE,
            TransportResizeAction.calculateTargetIndexShardsNum(
            default:
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                        (i) -> stats,
        );
import static org.hamcrest.CoreMatchers.equalTo;
        );
        } else {
            null,
        assertEquals("shrink_index", request.cause());
import org.apache.lucene.index.IndexWriter;
            "target index [target] will be blocked by [index.blocks.read_only=true] which is copied from the source index ["
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, "source").routingTable();
            assertEquals(cause, request.cause());
                        "target"
        }).getMessage().startsWith("Can't merge index with more than [2147483519] docs - too many documents in shards "));
                break;
        // now we start the shard
        // If not mixed mode, then migration direction is NONE.
import static org.opensearch.common.util.FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL;
        assertEquals(
            ),
                new ByteSizeValue(1),
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
        );
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
                        .build()
            new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
                clusterSettings,
                )
                () -> TransportResizeAction.prepareCreateIndexRequest(
import org.opensearch.cluster.ClusterState;
        assertEquals(
                resizeType = ResizeType.SPLIT;
        ClusterState clusterState = ClusterState.builder(
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().build());
                ClusterState finalState = clusterState;
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
 */
            "target"
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
            clusterSettings,
            ResizeRequest req = new ResizeRequest("target", "source");
        assertEquals(
        ClusterState clusterState = ClusterState.builder(
        resizeRequest.setWaitForActiveShards(activeShardCount);
    public void testPassNumRoutingShards() {
        assertNotNull(request.recoverFrom());
        // if max_shard_size is greater than whole of the source primary shards' storage,
    }
                    "target"
        );
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
                "target"
import org.opensearch.action.support.ActiveShardCount;
        ClusterState clusterState = ClusterState.builder(
            TransportResizeAction.calculateTargetIndexShardsNum(
            createClusterState("source", numShards, 0, numShards * 4, Settings.builder().put("index.blocks.write", true).build())
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
        );
                        new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
import org.opensearch.cluster.EmptyClusterInfoService;
        // now we start the shard
                "target"
            createClusterState(indexName, randomIntBetween(2, 10), 0, Settings.builder().put("index.blocks.write", true).build())
                    IllegalStateException.class,
            );
        );
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            1
import java.util.Arrays;
                    new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        ClusterState clusterState = ClusterState.builder(
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
            new TestGatewayAllocator(),
            ),
            Settings.builder().put("index.blocks.write", true).build()
        // Target index will be blocked by [index.blocks.read_only=true] copied from the source index
                resizeRequest,
            case 1:
        String indexName = randomAlphaOfLength(10);
 * ownership. Elasticsearch licenses this file to you under
            "target"
        String indexName = randomAlphaOfLength(10);
                    "target"
        );
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        assertEquals(request.waitForActiveShards(), activeShardCount);
        }
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, indexName).routingTable();
import org.opensearch.threadpool.ThreadPool;
            .build();
        );
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
            );
            clusterSettings,
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        int expectedShardsNum;
        final ActiveShardCount activeShardCount = randomBoolean() ? ActiveShardCount.ALL : ActiveShardCount.ONE;
        return createClusterState(name, numShards, numReplicas, numShards, settings);
        ClusterState finalState = clusterState;
            2
            "target"
            assertEquals(String.valueOf(expectedShardsNum), request.settings().get("index.number_of_shards"));
 * Modifications Copyright OpenSearch Contributors. See
        int expectedShardsNum = 5;
import static org.mockito.Mockito.when;
 * this work for additional information regarding copyright
    }
        int numSourceShards = clusterState.metadata().index(indexName).getNumberOfShards();
                resizeType = ResizeType.SPLIT;
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        // create one that won't fail
        );
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        );
import org.opensearch.cluster.routing.allocation.AllocationService;
    public void testCalculateTargetIndexShardsNum() {
            createClusterState("source", 1, 0, Settings.builder().put("index.blocks.write", true).build())
                assertNotNull(request.recoverFrom());
        // Overwrites the source index's settings index.blocks.read_only, so resize won't fail
                "source",
        String cause;
        assertEquals(indexName, request.recoverFrom().getName());
            (i) -> new DocsStats.Builder().count(between(1, 1000)).deleted(between(1, 1000)).totalSizeInBytes(between(0, 10000)).build(),
        final ActiveShardCount activeShardCount = randomBoolean() ? ActiveShardCount.ALL : ActiveShardCount.ONE;
            indexName,
            new BalancedShardsAllocator(Settings.EMPTY),
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
                new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
        assertEquals("shrink_index", request.cause());
                + indexName
        resizeRequest.getTargetIndexRequest()
            new BalancedShardsAllocator(Settings.EMPTY),
        assertNotNull(request.recoverFrom());
            new StoreStats.Builder().sizeInBytes(100).reservedSize(between(1, 10000)).build(),
            1
            clusterState,
        ResizeRequest resizeRequest = new ResizeRequest("target", indexName);
            .blocks(ClusterBlocks.builder().addBlocks(indexMetadata))
                "target"
            (i) -> stats,
                break;
            } else {
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                cause = "clone_index";
                Settings.builder().put("index.blocks.write", true).put(SETTING_REMOTE_STORE_ENABLED, isRemoteStoreEnabled).build()
        // then the target index's shards number will be equal to the source index's.
        );
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().build());
                );
                assertEquals(cause, request.cause());
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
        RoutingTable routingTable = service.reroute(clusterState, "reroute").routingTable();
            "target"
        // now we start the shard
            new BalancedShardsAllocator(Settings.EMPTY),
            iae.getMessage()
        // create one that won't fail
            "source",
import org.opensearch.core.common.unit.ByteSizeValue;
                    new ResizeRequest("target", "source"),
            indexName,
        CompatibilityMode compatibilityMode = randomFrom(CompatibilityMode.values());
        Metadata metadata = metaBuilder.build();
            EmptyClusterInfoService.INSTANCE,
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
                clusterSettings,
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            indexName,
        assertTrue(expectThrows(IllegalStateException.class, () -> {
            .metadata(metadata)
        // if max_shard_size is less than the primary shard's storage of the source index,
            new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
        resizeRequest.setMaxShardSize(new ByteSizeValue(25));
        // So we only need to test for the failures due to cluster setting validation while migration
            EmptyClusterInfoService.INSTANCE,
                        + resizeType
        );
            .build();
        request = TransportResizeAction.prepareCreateIndexRequest(
            clusterState,
                null,
            randomIntBetween(2, 42),
            "source",
import org.opensearch.cluster.ClusterName;
            ),
                assertEquals("source", request.recoverFrom().getName());
                    clusterSettings,
                1,
import org.opensearch.action.admin.indices.create.CreateIndexAction;
import java.util.Collections;
        ClusterService clusterService = mock(ClusterService.class);
            createClusterState(
            .routingTable(routingTable)
            clusterService,
            indexName,
        // create one that won't fail
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
    }
        ClusterSettings clusterSettings = createClusterSettings(CompatibilityMode.STRICT, RemoteStoreNodeService.Direction.NONE);
                clusterSettings,
                    ? new DocsStats.Builder().count(Integer.MAX_VALUE / 2)
            TransportResizeAction.prepareCreateIndexRequest(
    }
        int numShards = randomIntBetween(2, 100);
            clusterSettings,
            .setRoutingNumShards(numRoutingShards)
            clusterSettings,
                null,
        CreateIndexClusterStateUpdateRequest request = TransportResizeAction.prepareCreateIndexRequest(
                        .deleted(between(1, 1000))
            clusterSettings,
            EmptySnapshotsInfoService.INSTANCE
        );
import org.opensearch.cluster.metadata.ResolvedIndices;
            TransportResizeAction.prepareCreateIndexRequest(
                finalState,
        final ActiveShardCount activeShardCount = randomBoolean() ? ActiveShardCount.ALL : ActiveShardCount.ONE;
        // now we start the shard
        );
        resizeRequest.setWaitForActiveShards(activeShardCount);
    public void testPassNumRoutingShardsAndFail() {
                break;
                new ByteSizeValue(20),
    }
            resizeRequest,
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
import org.opensearch.cluster.metadata.Metadata;
            new ResizeRequest("target", "source"),
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
                    state,
            TransportResizeAction.calculateTargetIndexShardsNum(
        routingTable = OpenSearchAllocationTestCase.startInitializingShardsAndReroute(service, clusterState, indexName).routingTable();
                    new StoreStats.Builder().sizeInBytes(between(1, 10000)).reservedSize(between(1, 10000)).build(),
        if (compatibilityMode == CompatibilityMode.MIXED) {
        );
        return clusterSettings;
 */
        ClusterState clusterState = ClusterState.builder(
        TransportResizeAction action = new TransportResizeAction(
            1
import org.opensearch.transport.TransportService;
        CreateIndexClusterStateUpdateRequest request = TransportResizeAction.prepareCreateIndexRequest(
import org.opensearch.cluster.metadata.IndexMetadata;
        );
        CompatibilityMode compatibilityMode,
    }
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        resizeRequest.getTargetIndexRequest().settings(Settings.builder().put("index.number_of_shards", randomIntBetween(1, 100)).build());
        ClusterState clusterState = ClusterState.builder(
        ).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
                    () -> TransportResizeAction.prepareCreateIndexRequest(
                0,
        assertEquals(indexName, request.recoverFrom().getName());
        AllocationService service = new AllocationService(
        ResizeRequest resizeRequest = new ResizeRequest("target", indexName);
            )
