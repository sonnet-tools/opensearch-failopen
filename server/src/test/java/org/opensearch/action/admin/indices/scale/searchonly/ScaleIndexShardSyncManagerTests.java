            .sendRequest(eq(node), eq(transportActionName), any(ScaleIndexNodeRequest.class), any(TransportResponseHandler.class));
            public void onResponse(ScaleIndexResponse response) {
            return null;  
            .numberOfShards(1)  
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            @Override
        };
        Map<ShardId, String> assignments = syncManager.getPrimaryShardAssignments(indexMetadata, state);
            return null;  
            @Override  
import java.util.concurrent.CountDownLatch;  
        syncManager = new ScaleIndexShardSyncManager(clusterService, transportService, transportActionName);
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
            }  
        // We expect one response since there's one node.
        ActionListener<ScaleIndexNodeResponse> listener = new ActionListener<>() {
import java.util.Map;
        syncManager.sendNodeRequest(node, index, shards, listener);
            @Override  
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
        Settings indexSettings = Settings.builder()
            public void onResponse(Collection<ScaleIndexNodeResponse> responses) {  
                any(DiscoveryNode.class),  
        };
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        AtomicReference<ScaleIndexNodeResponse> responseRef = new AtomicReference<>();  
        ShardId shardId = new ShardId(new Index("test_index", "uuid"), 0);
            .build();
        Map<ShardId, String> primaryShardsNodes = Collections.singletonMap(shardId, "node1");
        });
            handler.handleException(new TransportException("Test exception", new Exception("dummy cause")));  
        // Set cluster state with empty discovery nodes so "node1" is missing.
        IndexMetadata indexMetadata = IndexMetadata.builder("test_index")
 * this file be licensed under the Apache-2.0 license or a
        ActionListener<Collection<ScaleIndexNodeResponse>> listener = new ActionListener<>() {  
        syncManager.sendShardSyncRequests("test_index", primaryShardsNodes, listener);  
    }  
        };
            .sendRequest(eq(node), eq(transportActionName), any(ScaleIndexNodeRequest.class), any(TransportResponseHandler.class));  
        assertTrue(exceptionRef.get().getMessage().contains("uncommitted operations"));
                fail("Expected failure due to uncommitted operations");
        // We expect one mapping: shard0 -> "node1"
            Collections.singletonList(shardResponse)
 */  
        ActionListener<ScaleIndexNodeResponse> listener = new ActionListener<>() {
        List<ScaleIndexNodeResponse> responses = Collections.singletonList(nodeResponse);
        };
        );  
        doAnswer(invocation -> {  
                exceptionRef.set(e);
import org.opensearch.cluster.routing.ShardRoutingState;
        // Construct the expected shard id using the same Index (name and uuid).
import java.util.concurrent.TimeUnit;
            @Override
    public void testGetPrimaryShardAssignments_withRouting() {  
                responseRef.set(responses);
import org.opensearch.core.action.ActionListener;  
        // Build cluster state with discovery node "node1"
                any(ScaleIndexNodeRequest.class),
                latch.countDown();
            @Override
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT),
import org.opensearch.cluster.routing.TestShardRouting;  
import org.opensearch.cluster.ClusterName;
            public void onFailure(Exception e) {  
            @Override
                fail("Expected failure due to missing node");  
            Collections.singletonList(shardResponse)
import org.opensearch.test.OpenSearchTestCase;  
            public void onFailure(Exception e) {  
        ClusterState state = ClusterState.builder(new ClusterName("test")).routingTable(routingTable).build();
    }
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        ScaleIndexShardResponse shardResponse = new ScaleIndexShardResponse(shardId, false, 5);
import org.opensearch.core.index.Index;
        AtomicReference<ScaleIndexResponse> responseRef = new AtomicReference<>();  
        IndexRoutingTable indexRoutingTable = new IndexRoutingTable.Builder(index).addIndexShard(shardRoutingTable).build();  
        ShardRouting primaryShardRouting = TestShardRouting.newShardRouting(shardId, "node1", true, ShardRoutingState.STARTED);
                latch.countDown();  
        String index = "test_index";
                assertTrue(e.getMessage().contains("Node [node1] not found"));
            @Override  
            handler.handleResponse(new ScaleIndexNodeResponse(node, Collections.emptyList()));
                any(TransportResponseHandler.class)  
        CountDownLatch latch = new CountDownLatch(1);  
            .put("index.uuid", "uuid")
import org.opensearch.cluster.node.DiscoveryNode;
            );
            }  
            .settings(indexSettings)
            @Override
                fail("Expected failure due to sync needed");
        RoutingTable routingTable = RoutingTable.builder().add(indexRoutingTable).build();
    public void testValidateNodeResponses_failure_uncommitted() {
                assertEquals("No primary shards found for index test_index", e.getMessage());
                responseRef.set(response);
    private ScaleIndexShardSyncManager syncManager;
        ScaleIndexShardResponse shardResponse = new ScaleIndexShardResponse(shardId, false, 0);
        syncManager.validateNodeResponses(responses, new ActionListener<ScaleIndexResponse>() {
        ScaleIndexNodeResponse nodeResponse = new ScaleIndexNodeResponse(
        List<ScaleIndexNodeResponse> responses = Collections.singletonList(nodeResponse);
/*  
                responseRef.set(response);  
        IndexShardRoutingTable shardRoutingTable = new IndexShardRoutingTable.Builder(shardId).addShard(primaryShardRouting).build();
        // Create a shard response indicating uncommitted operations.
        when(clusterService.state()).thenReturn(clusterState);
            }  
        ShardId expectedShardId = new ShardId(new Index("test_index", "uuid"), 0);
    }
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                exceptionRef.set(e);
        assertTrue(exceptionRef.get() instanceof TransportException);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
import static org.mockito.ArgumentMatchers.any;
        }).when(transportService)
        syncManager.validateNodeResponses(responses, new ActionListener<ScaleIndexResponse>() {
            public void onResponse(Collection<ScaleIndexNodeResponse> responses) {
                latch.countDown();
        // Build a cluster state that contains the routing table.  
import org.opensearch.cluster.routing.ShardRouting;
                exceptionRef.set(e);
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT),
            @Override
            }
        });
            TransportResponseHandler<ScaleIndexNodeResponse> handler = invocation.getArgument(3);
            }
        ShardId shardId = new ShardId(new Index("test_index", "uuid"), 0);
 * compatible open source license.
        transportService = mock(TransportService.class);  
            public void onResponse(ScaleIndexNodeResponse response) {
        super.setUp();
 * The OpenSearch Contributors require contributions made to  
            }  
        }).when(transportService)
import java.util.List;
import org.opensearch.transport.TransportService;  
            public void onFailure(Exception e) {
        // Stub transportService.sendRequest to return a dummy response.
        assertNotNull(exceptionRef.get());
        Index index = new Index("test_index", "uuid");
        // Prepare a mapping: one shard assigned to node "node1"
        assertEquals(1, responses.size());  
import org.opensearch.cluster.routing.IndexRoutingTable;
            .sendRequest(
    }
                fail("Expected failure when primary shards map is empty");
            .numberOfReplicas(1)
            public void onResponse(Collection<ScaleIndexNodeResponse> responses) {
            @Override  
        assertNotNull(responseRef.get());  
            @Override  
import java.util.concurrent.atomic.AtomicReference;
 * SPDX-License-Identifier: Apache-2.0
            }  
        // Create a shard response with no failures.  
import static org.mockito.Mockito.mock;
            @Override
        });  
    }  
    public void testSendShardSyncRequests_success() throws Exception {  
import static org.mockito.Mockito.doAnswer;  
        assertNotNull(responseRef.get());
            Collections.singletonList(shardResponse)
        CountDownLatch latch = new CountDownLatch(1);
            }
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(discoveryNodes).build();
            @Override
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            }
            }  
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(node).localNodeId("node1").build();
        Collection<ScaleIndexNodeResponse> responses = responseRef.get();  
            }  
        ScaleIndexShardResponse shardResponse = new ScaleIndexShardResponse(shardId, true, 0);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();  
        Map<ShardId, String> primaryShardsNodes = Collections.singletonMap(shardId, "node1");  
    public void testSendNodeRequest_failure() throws Exception {  
        ScaleIndexNodeResponse nodeResponse = new ScaleIndexNodeResponse(  
    }
    private final String transportActionName = "dummyAction";  
        List<ScaleIndexNodeResponse> responses = Collections.singletonList(nodeResponse);
            TransportResponseHandler<ScaleIndexNodeResponse> handler = invocation.getArgument(3);
        // Invoke the method under test.  
        ActionListener<Collection<ScaleIndexNodeResponse>> listener = new ActionListener<>() {
        assertNull(exceptionRef.get());  
    public void testValidateNodeResponses_failure_needsSync() {
        assertNotNull(responses);
import org.opensearch.cluster.ClusterState;  
        AtomicReference<Collection<ScaleIndexNodeResponse>> responseRef = new AtomicReference<>();
public class ScaleIndexShardSyncManagerTests extends OpenSearchTestCase {
            @Override  
        assertEquals("node1", assignments.get(expectedShardId));  
            public void onFailure(Exception e) {
                exceptionRef.set(e);
        // Create index settings with an explicit uuid.
    public void testSendShardSyncRequests_nodeNotFound() {
        clusterService = mock(ClusterService.class);
        syncManager.sendShardSyncRequests("test_index", Collections.emptyMap(), listener);
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT),  
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();  
            public void onFailure(Exception e) {
            handler.handleResponse(new ScaleIndexNodeResponse(node, Collections.emptyList()));
        );
        String index = "test_index";
import org.opensearch.cluster.node.DiscoveryNodes;  
        assertNotNull(exceptionRef.get());
        // Use a dummy Throwable as the cause instead of passing the node.  
        ActionListener<Collection<ScaleIndexNodeResponse>> listener = new ActionListener<>() {
        syncManager.sendNodeRequest(node, index, shards, listener);
    }
        CountDownLatch latch = new CountDownLatch(1);
        ScaleIndexNodeResponse nodeResponse = new ScaleIndexNodeResponse(  
        // Build IndexMetadata using the index name. The builder will pick up the uuid from the settings.  
            }  
import org.opensearch.core.index.shard.ShardId;
        syncManager.validateNodeResponses(responses, new ActionListener<ScaleIndexResponse>() {  
            return null;
    public void testSendNodeRequest_success() throws Exception {  
import static org.mockito.Mockito.when;
        syncManager.sendShardSyncRequests("test_index", primaryShardsNodes, listener);  
import static org.mockito.ArgumentMatchers.eq;
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().build();
            }
        doAnswer(invocation -> {  
    }
        ShardId shardId = new ShardId(new Index("test_index", "uuid"), 0);  
            }  
                fail("Expected failure");
            public void onResponse(ScaleIndexResponse response) {  
        );  
    }
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);
        when(clusterService.state()).thenReturn(clusterState);  
import java.util.Collection;
        assertTrue(exceptionRef.get().getMessage().contains("sync needed"));  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            public void onResponse(ScaleIndexNodeResponse response) {
}  
    private ClusterService clusterService;  
        assertEquals(1, assignments.size());  
        }).when(transportService)
            TransportResponseHandler<ScaleIndexNodeResponse> handler = invocation.getArgument(3);
 *
                exceptionRef.set(e);  
                eq(transportActionName),
            public void onFailure(Exception e) {
            public void onFailure(Exception e) {  
            @Override
        assertNull(exceptionRef.get());
import org.opensearch.common.settings.Settings;
package org.opensearch.action.admin.indices.scale.searchonly;
        List<ShardId> shards = Collections.singletonList(new ShardId(new Index("test_index", "uuid"), 0));  
        doAnswer(invocation -> {
    public void setUp() throws Exception {  
            public void onFailure(Exception e) {  
        List<ShardId> shards = Collections.singletonList(new ShardId(new Index("test_index", "uuid"), 0));  
                latch.countDown();
        ShardId shardId = new ShardId(new Index("test_index", "uuid"), 0);
            }  
                assertTrue(e instanceof IllegalStateException);
        // Create a shard response indicating that a shard needs sync.  
            }
        };
import org.opensearch.Version;
    }  
import org.opensearch.transport.TransportException;
    private TransportService transportService;
        ShardId shardId = new ShardId(index, 0);  
import org.opensearch.transport.TransportResponseHandler;
        ShardId shardId = new ShardId(new Index("test_index", "uuid"), 0);
        assertNotNull(exceptionRef.get());
        ClusterState clusterState = ClusterState.builder(new ClusterName("test")).nodes(discoveryNodes).build();  
            public void onResponse(ScaleIndexResponse response) {
        // Build a minimal routing table using the same index name and uuid.
            @Override  
import org.opensearch.cluster.metadata.IndexMetadata;
    @Override
            .build();
                fail("Unexpected failure: " + e.getMessage());
    public void testValidateNodeResponses_success() {
import java.util.Collections;  
    public void testSendShardSyncRequests_emptyPrimaryShards() {
        // Prepare a mapping: one shard assigned to node "node1"  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.routing.RoutingTable;  
        DiscoveryNode node = new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT);  
