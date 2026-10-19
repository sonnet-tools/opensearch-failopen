import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        transport = new CapturingTransport();  
            if (!(result instanceof OpenSearchException)) {
            List<BroadcastShardOperationFailedException> accumulatedExceptions  
        }  
        @Override  
        shards.add(shard0);  
                List<ShardRouting> shards = map.get(entry.getKey());
    @Before  
            this.asyncMode = true;  
     * listener. Otherwise the throw would escape onto the pool's uncaught-exception handler, the  
            if (!map.containsKey(shard.currentNodeId())) {
    public static void destroyThreadPool() {  
        // The async failure path wraps the cause in a BroadcastShardOperationFailedException.
            List<BroadcastShardOperationFailedException> exceptions = new ArrayList<>();
        for (ShardRouting shard : shardIt) {  
        int totalIndexShards = 0;
            final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();  
        String nodeId = "test-node";
        }
        // The node response must arrive (not hang) and report both shards as failed.
import org.junit.BeforeClass;  
import org.junit.Before;
        @Override
        ClusterBlocks.Builder block = ClusterBlocks.builder()
        @Override  
        // check the operation was executed on the correct node
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
    public void testAsyncShardOperation_SyncThrowFromShardOperationAsync_RecordedAsFailure() throws Exception {
        Map<String, List<ShardRouting>> map = new HashMap<>();  
            if (entry.getKey().equals(failedNodeId)) {  
                        totalFailedShards++;
        final TransportBroadcastByNodeAction<?, ?, ?>.BroadcastByNodeTransportRequestHandler handler =
        for (int i = 0; i < numberOfNodes; i++) {  
import org.opensearch.transport.TransportService;
        action.enableAsyncMode();  
import org.opensearch.cluster.routing.ShardsIterator;
                request,
        }  
        assertEquals(set, capturedRequests.keySet());
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();  
        }
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);
                for (ShardRouting shard : shards) {  
import org.opensearch.tasks.Task;  
         */
import static org.opensearch.test.ClusterServiceUtils.setState;  
        // Verifies the framework's per-shard try/catch funnels the throw into the listener so the
        private final Map<ShardRouting, Object> shards = new ConcurrentHashMap<>();  
            long requestId = entry.getValue().get(0).requestId;
        }  
     * Deterministic async aggregation: exactly one shard fails and one succeeds, guaranteeing both
                    totalShards++;
    }
            transportService,  
        assertEquals(set.size(), capturedRequests.size());
        String nodeId = shardIt.iterator().next().currentNodeId();
            }  
     * the onResponse and onFailure branches of onAsyncShardOperation execute regardless of the
        for (Map.Entry<String, List<CapturingTransport.CapturedRequest>> entry : capturedRequests.entrySet()) {
        for (Map.Entry<String, List<CapturingTransport.CapturedRequest>> entry : capturedRequests.entrySet()) {  
            }  
    public void testRequestBlock() {  
import static org.mockito.Mockito.mock;
        }  
        Request request = new Request(new String[] { TEST_INDEX });
import org.opensearch.test.transport.CapturingTransport;  
                final ShardId shardId = new ShardId(index, "_na_", ++shardIndex);  
        Set<String> set = new HashSet<>();
        // since static must set to null to be eligible for collection
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Request request = new Request(new String[] { TEST_INDEX });
    private static final String TEST_INDEX = "test-index";
                shards.put(shardRouting, e);  
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), shards), channel, null);
import org.opensearch.threadpool.TestThreadPool;
            return request.indices();  
        TransportResponse response = future.actionGet();
    public void testOperationExecution_AsyncShardOperation() throws Exception {
        for (Map.Entry<String, List<CapturingTransport.CapturedRequest>> e : captured.entrySet()) {
                ShardRouting shard = TestShardRouting.newShardRouting(
                throw e;
    }  
        shards.add(shard);
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();  
 * this work for additional information regarding copyright  
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;
        protected void shardOperationAsync(Request request, ShardRouting shardRouting, ActionListener<EmptyResult> listener) {
        assertThat(exceptions.get(0).getMessage(), is("operation indices:admin/test failed"));
        for (Object result : action.getResults().values()) {
        assertEquals(1, action.getNodeOperationCount());  
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();  
import org.opensearch.core.transport.TransportResponse;
        assertEquals("total shards", shards.size(), nodeResponse.getTotalShards());
        // Two primary shards on the same node. The async action fails exactly the first shard to  
            if (!shard.currentNodeId().equals(clusterManagerNode.getId())) {
                    }  
        }
import static java.util.Collections.emptySet;
import java.util.concurrent.ExecutionException;
                }
import static java.util.Collections.emptyMap;  
                TEST_INDEX,  
                        "indices:admin/test",
            new ActionFilters(new HashSet<>()),
     */
        PlainActionFuture<Response> listener = new PlainActionFuture<>();  
        public Map<ShardRouting, Object> getResults() {  
        // Despite each shard completing twice, accounting reflects exactly 2 shards, each failed once.
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        ShardsIterator shardIt = clusterService.state().routingTable().allShards(new String[] { TEST_INDEX });  
                super.shardOperationAsync(request, shardRouting, listener);  
                map.put(shard.currentNodeId(), new ArrayList<>());  
 */
        assertEquals(1, action.getNodeOperationCount());
        assertEquals(set, capturedRequests.keySet());
            action.new BroadcastByNodeTransportRequestHandler();
        ShardRouting shard1 = TestShardRouting.newShardRouting(TEST_INDEX, 1, nodeId, true, ShardRoutingState.STARTED);  
                    index,
        DiscoveryNode failedClusterManagerNode = null;
    public static class Request extends BroadcastRequest<Request> {
                        shardResults.add(TransportBroadcastByNodeAction.EmptyResult.INSTANCE);
                totalFailedShards += map.get(entry.getKey()).size();
        // node response is still produced (no transport-timeout hang).
    void setClusterState(ClusterService clusterService, String index) {
import org.opensearch.core.index.Index;
            List<BroadcastShardOperationFailedException> exceptions = new ArrayList<>();  
 *
        private volatile String asyncPoolName = ThreadPool.Names.GENERIC;  
                    true,
            return nodeOperationCount.count();  
        Request request = new Request(new String[] { TEST_INDEX });
        ClusterState clusterState = stateBuilder.build();  
            } else {
        @Override
        }
    // as such, the shards assigned to the cluster-manager will still show up in the cluster state as assigned to a node but
                return;  
            assertThat(exception, hasToString(containsString("operation failed")));  
     * aggregated, the response is sent only after all shards complete, and nodeOperation runs once.  
     * Verifies that the default shardOperationAsync throws UnsupportedOperationException
        String nodeId = "test-node";
    public void testShardOperationAsync_DefaultThrowsUnsupported() {
        }
        for (Map.Entry<String, List<CapturingTransport.CapturedRequest>> entry : capturedRequests.entrySet()) {
import static org.hamcrest.CoreMatchers.is;
        TransportResponse response = future.actionGet();
     * If {@code shardOperationAsync} throws synchronously on the pool worker before invoking the
        TestTransportChannel channel = new TestTransportChannel(future);  
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
    }
            TransportService transportService,
        assertEquals("node id", nodeId, nodeResponse.getNodeId());  
import static org.hamcrest.object.HasToString.hasToString;  
import org.opensearch.action.support.PlainActionFuture;  
        try {
                new ClusterBlock(1, "test-block", false, true, false, RestStatus.SERVICE_UNAVAILABLE, ClusterBlockLevel.ALL)
            assertEquals("index [" + TEST_INDEX + "] blocked by: [SERVICE_UNAVAILABLE/1/test-block];", expected.getMessage());
     */  
        int totalShards = 0;
                );
            Request::new,  
    }
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        DiscoveryNode clusterManagerNode = clusterService.state().nodes().getClusterManagerNode();
        ShardRouting shard0 = TestShardRouting.newShardRouting(TEST_INDEX, 0, nodeId, true, ShardRoutingState.STARTED);  
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
 * compatible open source license.  
            } else {  
    public void testRequestsAreNotSentToFailedClusterManager() {
        if (simulateFailedClusterManagerNode) {  
        TransportService transportService = transport.createTransportService(
    /**  
                transportService,
        private volatile boolean duplicateCompletion = false;
        protected Response newResponse(  
    @AfterClass
                OpenSearchException e = new OpenSearchException("operation failed");
        ShardsIterator shardIt = clusterService.state().routingTable().allShards(new String[] { TEST_INDEX });
        action.doExecute(mock(Task.class), request, ActionListener.wrap(listener::onResponse, listener::onFailure));
            if (syncThrow) {  
            Collections.emptySet(),
        ShardsIterator shardIt = clusterService.state().routingTable().allShards(new String[] { TEST_INDEX });
            );
        // nodeOperation aggregation hook runs exactly once.  
        discoBuilder.clusterManagerNodeId(newNode(numberOfNodes - 1).getId());
     * drain-callback and timeout) must not corrupt node-level accounting. The framework wraps each
                    totalShards++;
                // Throw synchronously before invoking the listener. The framework's per-shard try/catch
import org.opensearch.cluster.block.ClusterBlocks;  
    }
            totalIndexShards += numberOfShards;
        int successfulShards = 0;
 * You may obtain a copy of the License at
 * software distributed under the License is distributed on an  
import org.opensearch.threadpool.ThreadPool;
        TestTransportBroadcastByNodeAction(  
            x -> clusterService.localNode(),  
        assertEquals(ResolvedIndices.of(TEST_INDEX), resolvedIndices);
            }
        private final AtomicInteger asyncShardCounter = new AtomicInteger(0);
        }
        }
        Map<String, List<ShardRouting>> map = new HashMap<>();  
            List<EmptyResult> emptyResults,
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =
                }  
    @After
                transport.handleResponse(requestId, nodeResponse);  
        List<ShardRouting> shards = new ArrayList<>();
        stateBuilder.nodes(discoBuilder);
        assertEquals(1, action.getNodeOperationCount());  
import org.junit.After;  
                        // simulate operation failure
        for (BroadcastShardOperationFailedException ex : exceptions) {
        setState(clusterService, ClusterState.builder(clusterService.state()).blocks(block));  
        action.new AsyncAction(null, request, listener).start();
        assertEquals("no shard succeeded — both threw synchronously", 0, nodeResponse.getSuccessfulShards());
        shards.add(shard1);
 * SPDX-License-Identifier: Apache-2.0
            map.get(shard.currentNodeId()).add(shard);
     * Verifies that isAsyncShardOperation defaults to false.
    public void testOneRequestIsSentToEachNodeHoldingAShard() {  
 * Unless required by applicable law or agreed to in writing,
            return asyncPoolName;  
        String failedNodeId = "node_" + randomIntBetween(0, capturedRequests.size());
import java.util.HashSet;  
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);
        assertEquals("successful shards", successfulShards, nodeResponse.getSuccessfulShards());
                        clusterService.state().getRoutingNodes().node(entry.getKey()).node(),
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
            map.get(shard.currentNodeId()).add(shard);
        }
        THREAD_POOL = new TestThreadPool(TransportBroadcastByNodeActionTests.class.getSimpleName());  
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;
    }
        setClusterState(clusterService, TEST_INDEX);
 * The OpenSearch Contributors require contributions made to
        setState(clusterService, ClusterState.builder(clusterService.state()).nodes(builder));  
    private TestTransportBroadcastByNodeAction action;  
    }
            return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, concreteIndices);  
        for (BroadcastShardOperationFailedException exception : exceptions) {
            if (duplicateCompletion) {
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);  
                    } else {
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
            .addGlobalBlock(new ClusterBlock(1, "test-block", false, true, false, RestStatus.SERVICE_UNAVAILABLE, ClusterBlockLevel.ALL));
        Request request = new Request(new String[] { TEST_INDEX });
     * Verifies that every shard is operated on via shardOperationAsync, results and failures are
                    new ReceiveTimeoutTransportException(  
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =  
        // the framework's thread-pool-rejection branch in onAsyncShardOperation.
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;  
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;  
import org.opensearch.cluster.ClusterState;
    }
        String nodeId = "test-node";
import org.opensearch.action.support.ActionFilters;
        shards.add(shard1);
                shards.add(shard);
            action.new BroadcastByNodeTransportRequestHandler();
        private final CounterMetric nodeOperationCount = new CounterMetric();
        action.useAsyncPool("no_such_pool"); // unknown executor → executor(...).execute(...) throws → rejection branch
            assertEquals("blocked by: [SERVICE_UNAVAILABLE/1/test-block];", expected.getMessage());
                TransportBroadcastByNodeAction.NodeResponse nodeResponse = action.new NodeResponse(
        // check a request was sent to the right number of nodes  
                OpenSearchException e = new OpenSearchException("operation failed");  
 */
        void enableSyncThrow() {
import java.util.ArrayList;  
 */
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.OpenSearchException;
        Set<ShardRouting> shards = new HashSet<>();
        Request request = new Request(new String[] { TEST_INDEX });
        TransportResponse response = future.actionGet();
            if (asyncShardCounter.getAndIncrement() == 0) {
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
        assertEquals(shards, action.getResults().keySet());
        }  
            // check one request was sent to each non-cluster-manager node  
        }
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);
     * shard listener in {@link org.opensearch.core.action.ActionListener#notifyOnce}, so each shard  
            return asyncMode;
        ShardId shardId = new ShardId(new Index(TEST_INDEX, "_na_"), 0);
        assertEquals(1, action.getNodeOperationCount());  
        int shardIndex = -1;
            for (int j = 0; j < numberOfShards; j++) {
import org.opensearch.cluster.block.ClusterBlockException;
                        "time_out_simulated"  
        // simulate removing the cluster-manager
                IndexShardRoutingTable.Builder indexShard = new IndexShardRoutingTable.Builder(shardId);
         * Async variant used when {@link #asyncMode} is on. Completes deterministically:
        int totalSuccessfulShards = 0;  
            super(indices);  
            if (!(result instanceof OpenSearchException)) {
        setState(clusterService, ClusterState.builder(clusterService.state()).blocks(block));  
     */  
    }
        List<BroadcastShardOperationFailedException> exceptions = nodeResponse.getExceptions();  
        assertEquals("no shard succeeded", 0, nodeResponse.getSuccessfulShards());  
        assertEquals("total shards", 2, nodeResponse.getTotalShards());  
     * throw, which the framework must catch and convert into a per-shard failure. The node response is  
        Set<ShardRouting> shards = new HashSet<>();  
import org.junit.AfterClass;
                actionFilters,
        // execute (counter == 0) and succeeds the rest, so the outcome is 1 failure + 1 success.
import org.opensearch.common.util.concurrent.ThreadContext;  
        action.enableSyncThrow();  
import org.opensearch.cluster.block.ClusterBlockLevel;
        int successfulShards = 0;
        action = new TestTransportBroadcastByNodeAction(
import java.util.HashMap;
                List<ShardRouting> shards = map.get(entry.getKey());
                    )
                // simulate node timeout
     */
        protected Request readRequestFrom(StreamInput in) throws IOException {
        }
        }
        protected EmptyResult shardOperation(Request request, ShardRouting shardRouting) {  
                for (ShardRouting shard : shards) {
            this.duplicateCompletion = true;
import java.util.Collections;
                shards.add(shard);
 * under the License.
        }
        /**  
        }
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), new ArrayList<>(shards)), channel, null);
        private volatile boolean asyncMode = false;
            action.new BroadcastByNodeTransportRequestHandler();
            List<DefaultShardOperationFailedException> shardFailures,  
                // Intentionally complete the same shard's listener twice. A correct framework must  
 * KIND, either express or implied.  See the License for the
        }  
                        // simulate operation failure  
    }
import org.opensearch.Version;  
        // Manually send the request from coordinator --> target nodes, action.doExecute() does not do that in this test case setup  
        action.enableAsyncMode();  
        action.enableAsyncMode();
 * Modifications Copyright OpenSearch Contributors. See
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), shards), channel, null);
            action.new BroadcastByNodeTransportRequestHandler();  
    /**  
        public Request(StreamInput in) throws IOException {
                transport.handleResponse(requestId, nodeResponse);
 * GitHub history for details.  
     * rather than being sent early on the duplicate completion.
            return EmptyResult.readEmptyResultFrom(in);
        assertEquals("each shard recorded exactly one failure", 2, exceptions.size());  
        for (BroadcastShardOperationFailedException exception : exceptions) {
 * not use this file except in compliance with the License.  
                shards.put(shardRouting, Boolean.TRUE);
            this.asyncPoolName = poolName;  
            String executor
/*
                // must funnel this into the listener so the node response is still produced.
        clusterService.close();
     * (random) cluster shape. The shard list is supplied directly to the NodeRequest.  
            } else {
                    requestId,
        protected ClusterBlockException checkGlobalBlock(ClusterState state, Request request) {  
        action.enableDuplicateCompletion();  
            return shards;
        // nodeOperation aggregation hook still runs exactly once even on a fully-rejected node.
import java.io.IOException;
        // check the operation results  
        Response,
        transportService.acceptIncomingRequests();  
                shards.put(shardRouting, e);
    }  
        @Override  
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName(TEST_CLUSTER));  
import org.opensearch.cluster.block.ClusterBlock;  
        }
        assertEquals("no shard succeeded", 0, nodeResponse.getSuccessfulShards());
            fail("expected ClusterBlockException");  
import org.opensearch.cluster.ClusterName;
                );
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;
        action.new AsyncAction(null, request, listener).start();
        }  
    public void setUp() throws Exception {
        // to verify the framework's notifyOnce guard keeps per-shard accounting correct.
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =  
        protected EmptyResult readShardResult(StreamInput in) throws IOException {
        shards.add(shard0);  
        builder.remove(clusterManagerNode.getId());
        // check the operation was executed only on the expected shards
                    shardId.getId(),  
        public long getNodeOperationCount() {
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), shards), channel, null);
                set.add(shard.currentNodeId());
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
                "indices:admin/test",
                listener.onResponse(EmptyResult.INSTANCE);
                successfulShards++;  
        assertEquals(1, action.getNodeOperationCount());
            return new Response(totalShards, successfulShards, failedShards, shardFailures);  
            int numberOfShards = randomIntBetween(1, 10);  
import static org.hamcrest.CoreMatchers.containsString;
        void enableAsyncMode() {
            }
    private CapturingTransport transport;
import org.opensearch.cluster.routing.RoutingTable;
                indexShard.addShard(shard);  
        public Response(StreamInput in) throws IOException {
    private static ThreadPool THREAD_POOL;
            } else {
        // Defaults to false so existing tests exercise the synchronous path unchanged.  
        Request request = new Request(new String[] { TEST_INDEX });  
        @Override
        );
        Request request = new Request(TEST_INDEX);
        } catch (ClusterBlockException expected) {
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
    /**
            List<TransportBroadcastByNodeAction.EmptyResult> results,
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), new ArrayList<>(shards)), channel, null);
                    ShardRoutingState.STARTED  
        protected void nodeOperation(
        }
            action.new BroadcastByNodeTransportRequestHandler();
    public void testAsyncShardOperation_ThreadPoolRejection_RecordedAsFailure() throws Exception {  
        assertEquals("total shards", 2, nodeResponse.getTotalShards());  
        }
                indexNameExpressionResolver,  
    public void testOperationExecution() throws Exception {
    }  
        // When true, shardOperationAsync throws synchronously before invoking the listener.  
        List<ShardRouting> shards = new ArrayList<>();
    public void testIsAsyncShardOperation_DefaultFalse() {  
        OptionallyResolvedIndices resolvedIndices = action.resolveIndices(request);  
    }
        assertEquals("failed shards", failedShards, nodeResponse.getExceptions().size());  
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;  
            assertThat(exception, hasToString(containsString("operation failed")));
            builder.clusterManagerNodeId(null);  
        TransportResponse response = future.actionGet();  
        }
import java.util.concurrent.atomic.AtomicInteger;
            .addIndexBlock(
        public Request(String... indices) {
            return new Request(in);
        }
            }
    /**  
                totalSuccessfulShards += shardResults.size();
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
                listener.onFailure(e);
import org.opensearch.action.support.broadcast.BroadcastResponse;
        try {
                listener.onFailure(e);
            }
import org.opensearch.cluster.routing.IndexRoutingTable;
        String nodeId = "test-node";
        assertEquals("accumulated exceptions", totalFailedShards, response.getShardFailures().length);
 * this file be licensed under the Apache-2.0 license or a
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(new Index(index, "_na_"));
            totalShards += map.get(failedClusterManagerNode.getId()).size();
                throw new OpenSearchException("synchronous failure in shardOperationAsync");  
import org.opensearch.common.metrics.CounterMetric;
        Response response = listener.get();
        }
                );
        TransportBroadcastByNodeAction.EmptyResult> {
        @Override
        @Override  
        ShardRouting shardRouting = TestShardRouting.newShardRouting(shardId, "node1", true, ShardRoutingState.STARTED);
        THREAD_POOL = null;  
import java.util.concurrent.TimeUnit;  
        return new DiscoveryNode("node_" + nodeId, buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        }  
            );  
        }
            }
        // Every shard on the node was operated on via the async path.
    /**
        assertFalse("expected at least one target node", captured.isEmpty());
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(index)
            ThreadPool.Names.SAME
        String nodeId = shardIt.iterator().next().currentNodeId();
        int totalFailedShards = 0;
            set.add(shard.currentNodeId());
            handler.messageReceived(nodeReq, channel, null);
        @Override
import org.opensearch.common.settings.Settings;
        assertEquals("total shards", 1, nodeResponse.getTotalShards());
        ) {
        TestTransportChannel channel = new TestTransportChannel(future);  
        ) {  
        assertFalse("Default isAsyncShardOperation should be false", action.isAsyncShardOperation());
            ActionFilters actionFilters,
            new MyResolver(),
        clusterService = createClusterService(THREAD_POOL);
import org.opensearch.cluster.routing.TestShardRouting;
            int totalShards,
            int successfulShards,  
        ShardRouting shard1 = TestShardRouting.newShardRouting(TEST_INDEX, 1, nodeId, true, ShardRoutingState.STARTED);
        TestTransportChannel channel = new TestTransportChannel(future);
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);  
        // check requests were sent to the right nodes
        TestTransportChannel channel = new TestTransportChannel(future);  
        action.new AsyncAction(null, request, listener).start();
        }
        Map<String, List<CapturingTransport.CapturedRequest>> captured = transport.getCapturedRequestsByTargetNodeAndClear();
        protected ShardsIterator shards(ClusterState clusterState, Request request, String[] concreteIndices) {
        }
     * listener would never fire, and the coordinator would only get a response after its transport
        assertEquals("failed shards", totalFailedShards, response.getFailedShards());
            failedClusterManagerNode = clusterService.state().nodes().getClusterManagerNode();  
        for (ShardRouting shard : shardIt) {
            ClusterState clusterState
public class TransportBroadcastByNodeActionTests extends OpenSearchTestCase {  
        Request,  
                shards.put(shardRouting, e);  
    }
import org.opensearch.action.IndicesRequest;
        // Pool used for async per-shard dispatch. A test can point this at an unknown name to exercise
            if (!map.containsKey(shard.currentNodeId())) {
        assertEquals("failed shards", totalFailedShards, response.getFailedShards());  
        assertEquals("the rejected shard is recorded as a failure", 1, exceptions.size());
    }
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =
 *    http://www.apache.org/licenses/LICENSE-2.0  
import org.opensearch.cluster.node.DiscoveryNodes;
            }  
        ShardsIterator shardIt = clusterService.state().getRoutingTable().allShards(new String[] { TEST_INDEX });
            assertEquals(action.transportNodeBroadcastAction, cr.action);  
import org.opensearch.cluster.service.ClusterService;  
            assertEquals(1, entry.getValue().size());
        protected String asyncShardOperationThreadPool() {
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;  
            super(new ThreadContext(Settings.EMPTY));
            assertThat(exception.getMessage(), is("operation indices:admin/test failed"));  
                listener.onFailure(e);
        for (Object result : action.getResults().values()) {  
        List<BroadcastShardOperationFailedException> exceptions = nodeResponse.getExceptions();
        PlainActionFuture<Response> listener = new PlainActionFuture<>();  
                failedShards++;
        }
import org.opensearch.cluster.node.DiscoveryNode;  
            clusterService.getSettings(),  
        }
/*  
    /**  
            action.new BroadcastByNodeTransportRequestHandler();  
    public void testAsyncShardOperation_DoubleCompletion_CountedOncePerShard() throws Exception {
import java.util.Set;  
        ThreadPool.terminate(THREAD_POOL, 30, TimeUnit.SECONDS);
    }  
            if (nodeId.equals(shard.currentNodeId())) {
        }  
                        exceptions.add(new BroadcastShardOperationFailedException(shard.shardId(), "operation indices:admin/test failed"));
        stateBuilder.routingTable(RoutingTable.builder().add(indexRoutingTable.build()).build());
        }
        // When true, each async shard operation completes its listener twice (a buggy double-completion)  
            } else {  
            }
        ClusterBlocks.Builder block = ClusterBlocks.builder()
        MyResolver() {  
                    } else {  
            }
        assertEquals(1, action.getNodeOperationCount());  
import org.opensearch.transport.ReceiveTimeoutTransportException;  
                        exceptions.add(new BroadcastShardOperationFailedException(shard.shardId(), "operation indices:admin/test failed"));  
            assertEquals(1, entry.getValue().size());
        }  
        TestTransportChannel channel = new TestTransportChannel(future);
                        shardResults.add(TransportBroadcastByNodeAction.EmptyResult.INSTANCE);
                totalSuccessfulShards += shardResults.size();
        super.setUp();
import org.opensearch.core.action.ActionListener;
        for (ShardRouting shard : shardIt) {  
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
    }  
            builder.remove(failedClusterManagerNode.getId());
    }
 * Licensed to Elasticsearch under one or more contributor
}
        Request request = new Request(TEST_INDEX);  
        stateBuilder.metadata(Metadata.builder().put(indexMetadata));
    public static class Response extends BroadcastResponse {
        assertEquals(shards, action.getResults().keySet());
                return EmptyResult.INSTANCE;  
     * still produced (no leak) and the rejection cause surfaces via the failure exception.
        action.new AsyncAction(null, request, listener).start();
        transportService.start();
        expectThrows(UnsupportedOperationException.class, () -> action.shardOperationAsync(request, shardRouting, future));
        TestTransportChannel channel = new TestTransportChannel(future);  
                TransportBroadcastByNodeAction.NodeResponse nodeResponse = action.new NodeResponse(  
import org.opensearch.action.support.broadcast.BroadcastRequest;
        ShardsIterator shardIt = clusterService.state().getRoutingTable().allShards(new String[] { TEST_INDEX });
                    node.getId(),
                    if (rarely()) {
        assertEquals("one shard failed", 1, exceptions.size());
    }  
            }  
        @Override
        void useAsyncPool(String poolName) {
            DiscoveryNodes.Builder builder = DiscoveryNodes.builder(clusterService.state().getNodes());
     */
        }  
    // that node will not be in the local cluster state on any node that has detected the cluster-manager as failing
        assertThat(exceptions.get(0).getCause().getMessage(), containsString("rejected by thread pool"));
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder(clusterService.state().getNodes());  
        if (simulateFailedClusterManagerNode) {
        List<BroadcastShardOperationFailedException> exceptions = nodeResponse.getExceptions();  
    }
        int totalFailedShards = 0;
                executor
            }
    class TestTransportBroadcastByNodeAction extends TransportBroadcastByNodeAction<
        action.enableAsyncMode();
            return clusterState.routingTable().allShards(new String[] { TEST_INDEX });
            int failedShards,
        int failedShards = 0;
        private volatile boolean syncThrow = false;  
        List<BroadcastShardOperationFailedException> exceptions = nodeResponse.getExceptions();
                TransportBroadcastByNodeActionTests.this.clusterService,  
        shards.add(shard0);
                    if (rarely()) {  
        }
        assertEquals("each shard recorded exactly one failure", 2, nodeResponse.getExceptions().size());
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
 *
            if (asyncMode == false) {
            long requestId = entry.getValue().get(0).requestId;
package org.opensearch.action.support.broadcast.node;  
     * listener, the framework's per-shard try/catch must funnel the throw into the (notifyOnce-wrapped)
            super(in);  
        }  
        protected boolean isAsyncShardOperation() {  
    // ── Async shardOperationAsync tests ──────────────────────────────────────
    public void tearDown() throws Exception {  
                return;
        // Async path dispatches to the GENERIC pool; the response is only sent after all shards complete.
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);
    public void testResultAggregation() throws ExecutionException, InterruptedException {
        super.tearDown();
            } else {  
                transport.handleRemoteError(requestId, new Exception());  
        int totalShards = 0;
import org.opensearch.core.common.io.stream.Writeable;
 *  
        discoBuilder.localNodeId(newNode(0).getId());
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =
import org.opensearch.transport.TestTransportChannel;
        protected ClusterBlockException checkRequestBlock(ClusterState state, Request request, String[] concreteIndices) {
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
    }
    }  
            if (rarely()) {
import org.opensearch.core.rest.RestStatus;
            final DiscoveryNode node = newNode(i);
                    entry.getKey(), shards.size(), shardResults, exceptions  
            super(
                totalShards += map.get(entry.getKey()).size();
import org.opensearch.cluster.metadata.Metadata;  
        assertNotNull("failure must carry the rejection cause", exceptions.get(0).getCause());  
        for (ShardRouting shard : shardIt) {  
                    entry.getKey(), shards.size(), shardResults, exceptions
        assertEquals("successful shards", totalSuccessfulShards, response.getSuccessfulShards());
        List<ShardRouting> shards = new ArrayList<>();
        final boolean simulateFailedClusterManagerNode = rarely();  
        } catch (ClusterBlockException expected) {
     */
            THREAD_POOL,
    class MyResolver extends IndexNameExpressionResolver {
        shards.add(shard1);  
     * timeout — a hang we don't want.
            this.syncThrow = true;
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =
            super(in);
        );
        ShardsIterator shardIt = clusterService.state().routingTable().allShards(new String[] { TEST_INDEX });
        assertEquals("nodeOperation should run once per target node", captured.size(), action.getNodeOperationCount());
        assertEquals("successful shards", totalSuccessfulShards, response.getSuccessfulShards());  
    public void testResultWithTimeouts() throws ExecutionException, InterruptedException {
 * specific language governing permissions and limitations  
            TestTransportChannel channel = new TestTransportChannel(future);
     * Pointing the async pool at an unknown executor name makes {@code threadPool.executor(...).execute(...)}
        }  
            }
        for (Map.Entry<String, List<CapturingTransport.CapturedRequest>> entry : capturedRequests.entrySet()) {  
import java.util.List;
            NoopTracer.INSTANCE  
        }
        // check requests were sent to the right nodes  
         * and the failure (BroadcastShardOperationFailedException) aggregation branches.  
                List<TransportBroadcastByNodeAction.EmptyResult> shardResults = new ArrayList<>();  
                map.put(shard.currentNodeId(), new ArrayList<>());  
            fail("expected ClusterBlockException");  
     * A buggy async shard operation that completes its listener more than once (e.g. a racing
        public Response(int totalShards, int successfulShards, int failedShards, List<DefaultShardOperationFailedException> shardFailures) {  
        assertEquals("failed shards", failedShards, nodeResponse.getExceptions().size());
                // simulate node failure  
                transport.handleError(
            .numberOfReplicas(0)
                List<TransportBroadcastByNodeAction.EmptyResult> shardResults = new ArrayList<>();
        PlainActionFuture<TransportBroadcastByNodeAction.EmptyResult> future = new PlainActionFuture<>();
                OpenSearchException e = new OpenSearchException("operation failed");
        @Override  
import java.util.Map;
    private ClusterService clusterService;  
        assertEquals("total shards", 2, nodeResponse.getTotalShards());
    /**  
            .numberOfShards(totalIndexShards);
                indexRoutingTable.addIndexShard(indexShard.build());
     * since subclasses must override it when using async mode.  
        assertEquals(set.size(), capturedRequests.size());
            Writeable.Reader<Request> request,
        action.enableAsyncMode();
            assertThat(exception.getMessage(), is("operation indices:admin/test failed"));
            action.new AsyncAction(null, request, listener).start();
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        assertEquals("total shards", action.getResults().size(), nodeResponse.getTotalShards());
import java.util.concurrent.ConcurrentHashMap;
        }  
            if (nodeId.equals(shard.currentNodeId())) {  
            super(totalShards, successfulShards, failedShards, shardFailures);
        Response response = listener.get();  
        }  
        TransportResponse response = future.actionGet();
        int totalSuccessfulShards = 0;  
        ShardRouting shard0 = TestShardRouting.newShardRouting(TEST_INDEX, 0, nodeId, true, ShardRoutingState.STARTED);  
        for (ShardRouting shard : shardIt) {
        assertEquals("accumulated exceptions", totalFailedShards, response.getShardFailures().length);
    }
    // simulate the cluster-manager being removed from the cluster but before a new cluster-manager is elected  
    private static final String TEST_CLUSTER = "test-cluster";  
        }
     */
import org.opensearch.core.index.shard.ShardId;  
    public void testResolveIndices() {
        // check a request was sent to the right number of nodes
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
            action.new AsyncAction(null, request, listener).start();
        final PlainActionFuture<Response> listener = PlainActionFuture.newFuture();  
        assertEquals("node id", nodeId, nodeResponse.getNodeId());  
                    }
        ShardRouting shard0 = TestShardRouting.newShardRouting(TEST_INDEX, 0, nodeId, true, ShardRoutingState.STARTED);
/*  
                totalFailedShards += map.get(entry.getKey()).size();  
            }
    public void testNodeLevelHookForMultiNode() throws Exception {
    public static void startThreadPool() {
            if (rarely()) {
            assertNotNull("failure must carry the sync-throw cause", ex.getCause());
            IndexNameExpressionResolver indexNameExpressionResolver,  
 * license agreements. See the NOTICE file distributed with
        // Get captured NodeRequest from coordinator for each target node  
        }  
            CapturingTransport.CapturedRequest cr = e.getValue().get(0);
    }
            }  
 * ownership. Elasticsearch licenses this file to you under
        ) {
            // check one request was sent to each node
        // nodeOperation aggregation hook runs exactly once, after all async shards complete.
     * Drives the node-level operation through the async dispatch path (isAsyncShardOperation=true).
        assertEquals("total shards", totalShards, response.getTotalShards());
            setState(clusterService, ClusterState.builder(clusterService.state()).nodes(builder));
            null,
            Request request,
    static DiscoveryNode newNode(int nodeId) {
        setState(clusterService, clusterState);
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), shards), channel, null);
        int numberOfNodes = randomIntBetween(3, 5);  
import org.opensearch.cluster.routing.ShardRoutingState;  
        TransportResponse response = future.actionGet();
         * the first shard dispatched fails, the rest succeed — exercising both the success
    public void testAsyncShardOperation_AggregatesSuccessAndFailure() throws Exception {
         * Results are recorded so the test can derive the expected counts.
        assertEquals("one shard succeeded", 1, nodeResponse.getSuccessfulShards());
        List<BroadcastShardOperationFailedException> exceptions = nodeResponse.getExceptions();
            TransportBroadcastByNodeAction.NodeRequest nodeReq = (TransportBroadcastByNodeAction.NodeRequest) cr.request;
        ShardRouting shard = TestShardRouting.newShardRouting(TEST_INDEX, 0, nodeId, true, ShardRoutingState.STARTED);
        assertEquals("total shards", totalShards, response.getTotalShards());
    public void testGlobalBlock() {  
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
        Set<String> set = new HashSet<>();
     * is counted exactly once and the node response is produced from complete per-shard results
        ShardRouting shard1 = TestShardRouting.newShardRouting(TEST_INDEX, 1, nodeId, true, ShardRoutingState.STARTED);
                shards.put(shardRouting, Boolean.TRUE);
            nodeOperationCount.inc();
        // the cluster manager should not be in the list of nodes that requests were sent to  
        Request request = new Request(new String[] { TEST_INDEX });
        void enableDuplicateCompletion() {  
                failedShards++;
                // absorb the second completion (notifyOnce) so node-level accounting is not corrupted.
        // When true, the node-level operation uses the async dispatch path (shardOperationAsync).
import org.opensearch.cluster.metadata.IndexMetadata;
                        totalFailedShards++;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        int failedShards = 0;  
        List<ShardRouting> shards = new ArrayList<>();  
                );
                successfulShards++;
    // in this case, such a shard should be treated as unassigned  
import org.opensearch.cluster.routing.ShardRouting;
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
    }  
        for (ShardRouting shard : shardIt) {
            action.new BroadcastByNodeTransportRequestHandler();  
        assertEquals("successful shards", successfulShards, nodeResponse.getSuccessfulShards());  
                totalShards += map.get(entry.getKey()).size();
            discoBuilder = discoBuilder.add(node);
import org.opensearch.cluster.metadata.ResolvedIndices;
        @Override
            assertThat(ex.getCause().getMessage(), containsString("synchronous failure in shardOperationAsync"));  
    @BeforeClass
