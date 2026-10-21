        AtomicReference<ScaleIndexNodeResponse> responseRef = new AtomicReference<>();
        // Stub transportService.sendRequest to return a dummy response.
        ScaleIndexShardResponse shardResponse = new ScaleIndexShardResponse(shardId, false, 5);
                responseRef.set(response);
        assertEquals(1, assignments.size());
        assertNotNull(exceptionRef.get());
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            @Override
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(discoveryNodes).build();
                fail("Expected failure");
                fail("Expected failure due to uncommitted operations");
        clusterService = mock(ClusterService.class);
        ScaleIndexShardResponse shardResponse = new ScaleIndexShardResponse(shardId, false, 0);
            }
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(discoveryNodes).build();
        Index index = new Index("test_index", "uuid");
        // Prepare a mapping: one shard assigned to node "node1"
import org.opensearch.transport.TransportException;
        }).when(transportService)
            public void onFailure(Exception e) {
            .settings(indexSettings)
        IndexShardRoutingTable shardRoutingTable = new IndexShardRoutingTable.Builder(shardId).addShard(primaryShardRouting).build();
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        // Create a shard response with no failures.
import org.opensearch.Version;
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT),
    }
        // Use a dummy Throwable as the cause instead of passing the node.
            }
import org.opensearch.common.settings.Settings;
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT),
        });
                responseRef.set(responses);
    public void testSendShardSyncRequests_nodeNotFound() {
/*
        // Build a minimal routing table using the same index name and uuid.
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
                assertEquals("No primary shards found for index test_index", e.getMessage());
        };
        String index = "test_index";
        assertEquals("node1", assignments.get(expectedShardId));
            return null;
                fail("Expected failure due to missing node");
            TransportResponseHandler<ScaleIndexNodeResponse> handler = invocation.getArgument(3);
import java.util.Map;
                latch.countDown();
import org.opensearch.cluster.ClusterState;
            public void onResponse(ScaleIndexResponse response) {
        ScaleIndexNodeResponse nodeResponse = new ScaleIndexNodeResponse(
    private final String transportActionName = "dummyAction";
        super.setUp();
    private ScaleIndexShardSyncManager syncManager;
import org.opensearch.cluster.ClusterName;
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
            public void onResponse(ScaleIndexResponse response) {
        CountDownLatch latch = new CountDownLatch(1);
            Collections.singletonList(shardResponse)
        );
    public void testValidateNodeResponses_failure_uncommitted() {
import static org.mockito.Mockito.mock;
        List<ScaleIndexNodeResponse> responses = Collections.singletonList(nodeResponse);
    public void setUp() throws Exception {
        ShardId expectedShardId = new ShardId(new Index("test_index", "uuid"), 0);
        ActionListener<Collection<ScaleIndexNodeResponse>> listener = new ActionListener<>() {
                latch.countDown();
    }
        ShardId shardId = new ShardId(new Index("test_index", "uuid"), 0);
import org.opensearch.cluster.routing.RoutingTable;
        ActionListener<Collection<ScaleIndexNodeResponse>> listener = new ActionListener<>() {
 *
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().build();
        // Create index settings with an explicit uuid.
import org.opensearch.core.index.Index;
        }).when(transportService)
        AtomicReference<Collection<ScaleIndexNodeResponse>> responseRef = new AtomicReference<>();
        syncManager.sendNodeRequest(node, index, shards, listener);
                exceptionRef.set(e);
        CountDownLatch latch = new CountDownLatch(1);
            handler.handleResponse(new ScaleIndexNodeResponse(node, Collections.emptyList()));
            public void onResponse(Collection<ScaleIndexNodeResponse> responses) {
                any(ScaleIndexNodeRequest.class),
        // Create a shard response indicating that a shard needs sync.
    private ClusterService clusterService;
        transportService = mock(TransportService.class);
            @Override
        Settings indexSettings = Settings.builder()
            }
            }
                any(TransportResponseHandler.class)
                assertTrue(e instanceof IllegalStateException);
            }
        IndexMetadata indexMetadata = IndexMetadata.builder("test_index")
        // Create a shard response indicating uncommitted operations.
            @Override
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            public void onResponse(Collection<ScaleIndexNodeResponse> responses) {
        AtomicReference<ScaleIndexResponse> responseRef = new AtomicReference<>();
        RoutingTable routingTable = RoutingTable.builder().add(indexRoutingTable).build();
        assertTrue(exceptionRef.get() instanceof TransportException);
        assertNotNull(exceptionRef.get());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // Build IndexMetadata using the index name. The builder will pick up the uuid from the settings.
            }
        });
            @Override
    }
        ScaleIndexNodeResponse nodeResponse = new ScaleIndexNodeResponse(
    }
            public void onFailure(Exception e) {
            handler.handleResponse(new ScaleIndexNodeResponse(node, Collections.emptyList()));
                exceptionRef.set(e);
                responseRef.set(response);
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.core.action.ActionListener;
            .sendRequest(eq(node), eq(transportActionName), any(ScaleIndexNodeRequest.class), any(TransportResponseHandler.class));
            }
import org.opensearch.transport.TransportResponseHandler;
        syncManager.sendShardSyncRequests("test_index", Collections.emptyMap(), listener);
            @Override
import org.opensearch.cluster.node.DiscoveryNode;
            return null;
            .numberOfShards(1)
                fail("Expected failure when primary shards map is empty");
    public void testSendShardSyncRequests_success() throws Exception {
                eq(transportActionName),
            }
import org.opensearch.cluster.node.DiscoveryNodes;
            public void onFailure(Exception e) {
        };
import org.opensearch.transport.TransportService;
import static org.mockito.ArgumentMatchers.any;
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(node).localNodeId("node1").build();
        // We expect one mapping: shard0 -> "node1"
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        // Build a cluster state that contains the routing table.
        doAnswer(invocation -> {
        when(clusterService.state()).thenReturn(clusterState);
        };
            Collections.singletonList(shardResponse)
            public void onFailure(Exception e) {
        // Invoke the method under test.
    }
                exceptionRef.set(e);
        IndexRoutingTable indexRoutingTable = new IndexRoutingTable.Builder(index).addIndexShard(shardRoutingTable).build();
            public void onResponse(ScaleIndexNodeResponse response) {
import java.util.Collection;
                fail("Expected failure due to sync needed");
    public void testSendNodeRequest_success() throws Exception {
        ActionListener<ScaleIndexNodeResponse> listener = new ActionListener<>() {
        ScaleIndexShardResponse shardResponse = new ScaleIndexShardResponse(shardId, true, 0);
            }
        syncManager = new ScaleIndexShardSyncManager(clusterService, transportService, transportActionName);
        );
        ScaleIndexNodeResponse nodeResponse = new ScaleIndexNodeResponse(
            .build();
        List<ScaleIndexNodeResponse> responses = Collections.singletonList(nodeResponse);
                latch.countDown();
            }
            public void onResponse(ScaleIndexResponse response) {
            @Override
        syncManager.sendNodeRequest(node, index, shards, listener);
import org.opensearch.cluster.metadata.IndexMetadata;
            @Override
        assertNotNull(responseRef.get());
        Collection<ScaleIndexNodeResponse> responses = responseRef.get();
            @Override
            public void onResponse(ScaleIndexNodeResponse response) {
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        ShardId shardId = new ShardId(new Index("test_index", "uuid"), 0);
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            }
        ActionListener<Collection<ScaleIndexNodeResponse>> listener = new ActionListener<>() {
            Collections.singletonList(shardResponse)
        assertNull(exceptionRef.get());
        assertTrue(exceptionRef.get().getMessage().contains("uncommitted operations"));
            TransportResponseHandler<ScaleIndexNodeResponse> handler = invocation.getArgument(3);
import org.opensearch.cluster.routing.IndexRoutingTable;
        // Prepare a mapping: one shard assigned to node "node1"
    public void testGetPrimaryShardAssignments_withRouting() {
        ShardId shardId = new ShardId(index, 0);
            .put("index.uuid", "uuid")
            @Override
        List<ShardId> shards = Collections.singletonList(new ShardId(new Index("test_index", "uuid"), 0));
            @Override
import java.util.concurrent.TimeUnit;
    }
import org.opensearch.cluster.routing.ShardRouting;
    }
        };
        }).when(transportService)
}
            public void onFailure(Exception e) {
    public void testSendShardSyncRequests_emptyPrimaryShards() {
        syncManager.sendShardSyncRequests("test_index", primaryShardsNodes, listener);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            .numberOfReplicas(1)
        when(clusterService.state()).thenReturn(clusterState);
        );
            public void onResponse(Collection<ScaleIndexNodeResponse> responses) {
                exceptionRef.set(e);
            }
            handler.handleException(new TransportException("Test exception", new Exception("dummy cause")));
        ClusterState state = ClusterState.builder(new ClusterName("test")).routingTable(routingTable).build();
                exceptionRef.set(e);
import static org.mockito.ArgumentMatchers.eq;
        assertNotNull(responseRef.get());
            .sendRequest(eq(node), eq(transportActionName), any(ScaleIndexNodeRequest.class), any(TransportResponseHandler.class));
import java.util.List;
            @Override
        ShardId shardId = new ShardId(new Index("test_index", "uuid"), 0);
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
            .sendRequest(
        });
 * compatible open source license.
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT),
            }
        syncManager.validateNodeResponses(responses, new ActionListener<ScaleIndexResponse>() {
                assertTrue(e.getMessage().contains("Node [node1] not found"));
        doAnswer(invocation -> {
 * this file be licensed under the Apache-2.0 license or a
                any(DiscoveryNode.class),
        // Set cluster state with empty discovery nodes so "node1" is missing.
import static org.mockito.Mockito.doAnswer;
            }
        ShardId shardId = new ShardId(new Index("test_index", "uuid"), 0);
            return null;
        ActionListener<ScaleIndexNodeResponse> listener = new ActionListener<>() {
    public void testValidateNodeResponses_failure_needsSync() {
        syncManager.sendShardSyncRequests("test_index", primaryShardsNodes, listener);
import org.opensearch.cluster.routing.ShardRoutingState;
            @Override
 * The OpenSearch Contributors require contributions made to
    }
        CountDownLatch latch = new CountDownLatch(1);
        };
    }
        // We expect one response since there's one node.
        assertTrue(exceptionRef.get().getMessage().contains("sync needed"));
            .build();
                fail("Unexpected failure: " + e.getMessage());
        String index = "test_index";
import org.opensearch.cluster.routing.TestShardRouting;
import java.util.Collections;
            }
        List<ScaleIndexNodeResponse> responses = Collections.singletonList(nodeResponse);
            @Override
            }
import org.opensearch.test.OpenSearchTestCase;
    public void testValidateNodeResponses_success() {
 */
import java.util.concurrent.atomic.AtomicReference;
    @Override
import static org.mockito.Mockito.when;
            );
            @Override
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        ShardId shardId = new ShardId(new Index("test_index", "uuid"), 0);
                latch.countDown();
        Map<ShardId, String> primaryShardsNodes = Collections.singletonMap(shardId, "node1");
    private TransportService transportService;
        syncManager.validateNodeResponses(responses, new ActionListener<ScaleIndexResponse>() {
import java.util.concurrent.CountDownLatch;
        assertNotNull(responses);
 * SPDX-License-Identifier: Apache-2.0
            public void onFailure(Exception e) {
        assertEquals(1, responses.size());
            @Override
            public void onFailure(Exception e) {
        assertNull(exceptionRef.get());
import org.opensearch.core.index.shard.ShardId;
        Map<ShardId, String> primaryShardsNodes = Collections.singletonMap(shardId, "node1");
        // Build cluster state with discovery node "node1"
            @Override
        // Construct the expected shard id using the same Index (name and uuid).
package org.opensearch.action.admin.indices.scale.searchonly;
        ShardRouting primaryShardRouting = TestShardRouting.newShardRouting(shardId, "node1", true, ShardRoutingState.STARTED);
        assertNotNull(exceptionRef.get());
            public void onFailure(Exception e) {
            TransportResponseHandler<ScaleIndexNodeResponse> handler = invocation.getArgument(3);
        List<ShardId> shards = Collections.singletonList(new ShardId(new Index("test_index", "uuid"), 0));
    public void testSendNodeRequest_failure() throws Exception {
        Map<ShardId, String> assignments = syncManager.getPrimaryShardAssignments(indexMetadata, state);
    }
        syncManager.validateNodeResponses(responses, new ActionListener<ScaleIndexResponse>() {
        doAnswer(invocation -> {
public class ScaleIndexShardSyncManagerTests extends OpenSearchTestCase {
