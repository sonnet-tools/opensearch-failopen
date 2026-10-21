        expectThrows(UnsupportedOperationException.class, () -> action.shardOperationAsync(request, shardRouting, future));
        assertEquals("node id", nodeId, nodeResponse.getNodeId());
                shards.put(shardRouting, Boolean.TRUE);
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), shards), channel, null);
        private volatile boolean duplicateCompletion = false;
                totalSuccessfulShards += shardResults.size();
                );
     * Verifies that isAsyncShardOperation defaults to false.
     * Verifies that every shard is operated on via shardOperationAsync, results and failures are
        Request request = new Request(new String[] { TEST_INDEX });
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        Request request = new Request(new String[] { TEST_INDEX });
import org.opensearch.cluster.routing.IndexRoutingTable;
        for (Object result : action.getResults().values()) {
        String failedNodeId = "node_" + randomIntBetween(0, capturedRequests.size());
        }
                listener.onFailure(e);
     */
        for (Map.Entry<String, List<CapturingTransport.CapturedRequest>> entry : capturedRequests.entrySet()) {
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =
        assertEquals(set, capturedRequests.keySet());
        }
    public void testIsAsyncShardOperation_DefaultFalse() {
        // check the operation results
            } else {
        // When true, the node-level operation uses the async dispatch path (shardOperationAsync).
    public void testOneRequestIsSentToEachNodeHoldingAShard() {
                new ClusterBlock(1, "test-block", false, true, false, RestStatus.SERVICE_UNAVAILABLE, ClusterBlockLevel.ALL)
            if (asyncMode == false) {
        assertEquals(1, action.getNodeOperationCount());
        List<ShardRouting> shards = new ArrayList<>();
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), new ArrayList<>(shards)), channel, null);
                transport.handleResponse(requestId, nodeResponse);
     * listener. Otherwise the throw would escape onto the pool's uncaught-exception handler, the
                listener.onFailure(e);
        }
        stateBuilder.routingTable(RoutingTable.builder().add(indexRoutingTable.build()).build());
        int totalShards = 0;
                request,
            super(in);
                    entry.getKey(), shards.size(), shardResults, exceptions
            long requestId = entry.getValue().get(0).requestId;
                List<ShardRouting> shards = map.get(entry.getKey());
        ) {
         * Results are recorded so the test can derive the expected counts.
    }
import org.opensearch.threadpool.TestThreadPool;
 * Licensed to Elasticsearch under one or more contributor
            TransportBroadcastByNodeAction.NodeRequest nodeReq = (TransportBroadcastByNodeAction.NodeRequest) cr.request;
import org.opensearch.threadpool.ThreadPool;
    public void testNodeLevelHookForMultiNode() throws Exception {
        shards.add(shard1);
        assertEquals("total shards", shards.size(), nodeResponse.getTotalShards());
        ShardRouting shard1 = TestShardRouting.newShardRouting(TEST_INDEX, 1, nodeId, true, ShardRoutingState.STARTED);
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =
        }
        assertEquals("failed shards", totalFailedShards, response.getFailedShards());
        } catch (ClusterBlockException expected) {
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;
        }
        action.enableDuplicateCompletion();
        THREAD_POOL = new TestThreadPool(TransportBroadcastByNodeActionTests.class.getSimpleName());
        // the framework's thread-pool-rejection branch in onAsyncShardOperation.
    public void testResultAggregation() throws ExecutionException, InterruptedException {
        public Response(int totalShards, int successfulShards, int failedShards, List<DefaultShardOperationFailedException> shardFailures) {
package org.opensearch.action.support.broadcast.node;
        // Get captured NodeRequest from coordinator for each target node
        for (Map.Entry<String, List<CapturingTransport.CapturedRequest>> entry : capturedRequests.entrySet()) {
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.node.DiscoveryNodes;
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;
 */
            if (nodeId.equals(shard.currentNodeId())) {
            action.new BroadcastByNodeTransportRequestHandler();
import org.junit.AfterClass;
        // the cluster manager should not be in the list of nodes that requests were sent to
    /**
        TransportResponse response = future.actionGet();
        }
            List<BroadcastShardOperationFailedException> exceptions = new ArrayList<>();
    }
        @Override
        assertEquals("failed shards", failedShards, nodeResponse.getExceptions().size());
        @Override
        // nodeOperation aggregation hook runs exactly once.
        }
            nodeOperationCount.inc();
                    )
            return new Request(in);
        }
                listener.onResponse(EmptyResult.INSTANCE);
        assertNotNull("failure must carry the rejection cause", exceptions.get(0).getCause());
                        shardResults.add(TransportBroadcastByNodeAction.EmptyResult.INSTANCE);
        }
 * not use this file except in compliance with the License.
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
    }
        assertEquals(shards, action.getResults().keySet());
                // simulate node failure
    }
                        totalFailedShards++;
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;
        List<BroadcastShardOperationFailedException> exceptions = nodeResponse.getExceptions();
    @AfterClass
        protected boolean isAsyncShardOperation() {
import org.opensearch.transport.TestTransportChannel;
        TransportResponse response = future.actionGet();
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);
import static org.mockito.Mockito.mock;
            assertEquals(1, entry.getValue().size());
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =
                "indices:admin/test",
        @Override
                // absorb the second completion (notifyOnce) so node-level accounting is not corrupted.
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        protected ShardsIterator shards(ClusterState clusterState, Request request, String[] concreteIndices) {
/*
            } else {
        Response response = listener.get();
    private TestTransportBroadcastByNodeAction action;
    }
    public void tearDown() throws Exception {
        }
            return asyncMode;
            }
        assertEquals(1, action.getNodeOperationCount());
        @Override
            action.new BroadcastByNodeTransportRequestHandler();
            this.asyncPoolName = poolName;
        String nodeId = shardIt.iterator().next().currentNodeId();
     * timeout — a hang we don't want.
        super.setUp();
        Set<ShardRouting> shards = new HashSet<>();
        ShardsIterator shardIt = clusterService.state().routingTable().allShards(new String[] { TEST_INDEX });
import org.opensearch.common.settings.Settings;
            .numberOfShards(totalIndexShards);
        public Request(String... indices) {
        assertEquals("no shard succeeded", 0, nodeResponse.getSuccessfulShards());
                    true,
        String nodeId = shardIt.iterator().next().currentNodeId();
        assertEquals("nodeOperation should run once per target node", captured.size(), action.getNodeOperationCount());
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
     * throw, which the framework must catch and convert into a per-shard failure. The node response is
        assertEquals("accumulated exceptions", totalFailedShards, response.getShardFailures().length);
            }
        assertEquals("total shards", 2, nodeResponse.getTotalShards());
            String executor
        }
        } catch (ClusterBlockException expected) {
                shards.put(shardRouting, e);
                    totalShards++;
    }
            action.new BroadcastByNodeTransportRequestHandler();
    /**
        assertEquals("one shard succeeded", 1, nodeResponse.getSuccessfulShards());
                // Throw synchronously before invoking the listener. The framework's per-shard try/catch
                    } else {
        void enableDuplicateCompletion() {
        assertEquals(1, action.getNodeOperationCount());
        setClusterState(clusterService, TEST_INDEX);
        String nodeId = "test-node";
        action.useAsyncPool("no_such_pool"); // unknown executor → executor(...).execute(...) throws → rejection branch
        shards.add(shard0);
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
        for (BroadcastShardOperationFailedException exception : exceptions) {
                shards.put(shardRouting, e);
                throw e;
            assertEquals("blocked by: [SERVICE_UNAVAILABLE/1/test-block];", expected.getMessage());
        int failedShards = 0;
                for (ShardRouting shard : shards) {
        }
        shards.add(shard1);
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
        protected EmptyResult readShardResult(StreamInput in) throws IOException {
            NoopTracer.INSTANCE
                failedShards++;
     * drain-callback and timeout) must not corrupt node-level accounting. The framework wraps each
        clusterService = createClusterService(THREAD_POOL);
                shards.add(shard);
        assertFalse("expected at least one target node", captured.isEmpty());
        // The node response must arrive (not hang) and report both shards as failed.
            final DiscoveryNode node = newNode(i);
        private final Map<ShardRouting, Object> shards = new ConcurrentHashMap<>();
 * You may obtain a copy of the License at
            IndexNameExpressionResolver indexNameExpressionResolver,
        }
        ShardRouting shard0 = TestShardRouting.newShardRouting(TEST_INDEX, 0, nodeId, true, ShardRoutingState.STARTED);
        action.enableAsyncMode();
        stateBuilder.nodes(discoBuilder);
        }
        // check a request was sent to the right number of nodes
        }
        ThreadPool.terminate(THREAD_POOL, 30, TimeUnit.SECONDS);
     * rather than being sent early on the duplicate completion.
        protected EmptyResult shardOperation(Request request, ShardRouting shardRouting) {
    }
        TransportBroadcastByNodeAction.EmptyResult> {
            new MyResolver(),
            assertThat(exception.getMessage(), is("operation indices:admin/test failed"));
    public void testGlobalBlock() {
        // nodeOperation aggregation hook runs exactly once, after all async shards complete.
            }
import org.opensearch.common.util.concurrent.ThreadContext;
            assertEquals(action.transportNodeBroadcastAction, cr.action);
                    shardId.getId(),
        }
                OpenSearchException e = new OpenSearchException("operation failed");
                        "time_out_simulated"
        ShardRouting shard0 = TestShardRouting.newShardRouting(TEST_INDEX, 0, nodeId, true, ShardRoutingState.STARTED);
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
        assertEquals("each shard recorded exactly one failure", 2, nodeResponse.getExceptions().size());
 * this work for additional information regarding copyright
        // check a request was sent to the right number of nodes
            );
     */
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
        for (Map.Entry<String, List<CapturingTransport.CapturedRequest>> entry : capturedRequests.entrySet()) {
        // Defaults to false so existing tests exercise the synchronous path unchanged.
        ClusterState clusterState = stateBuilder.build();
    private static final String TEST_INDEX = "test-index";
        String nodeId = "test-node";
                throw new OpenSearchException("synchronous failure in shardOperationAsync");
            }
        );
import static org.opensearch.test.ClusterServiceUtils.setState;
        ) {
            int successfulShards,
        }
            return EmptyResult.readEmptyResultFrom(in);
            action.new BroadcastByNodeTransportRequestHandler();
            assertEquals("index [" + TEST_INDEX + "] blocked by: [SERVICE_UNAVAILABLE/1/test-block];", expected.getMessage());
            if (rarely()) {
import java.util.Map;
import org.opensearch.cluster.metadata.ResolvedIndices;
        List<BroadcastShardOperationFailedException> exceptions = nodeResponse.getExceptions();
    private ClusterService clusterService;
     * Verifies that the default shardOperationAsync throws UnsupportedOperationException
                return;
        }
            DiscoveryNodes.Builder builder = DiscoveryNodes.builder(clusterService.state().getNodes());
    public void testResolveIndices() {
import java.util.HashSet;
import org.opensearch.cluster.routing.TestShardRouting;
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            if (rarely()) {
        assertEquals("successful shards", successfulShards, nodeResponse.getSuccessfulShards());
            Writeable.Reader<Request> request,
        Request request = new Request(new String[] { TEST_INDEX });
                indexRoutingTable.addIndexShard(indexShard.build());
        // When true, each async shard operation completes its listener twice (a buggy double-completion)
    // ── Async shardOperationAsync tests ──────────────────────────────────────
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;
        }
         */
 */
        // Every shard on the node was operated on via the async path.
import org.opensearch.core.common.io.stream.Writeable;
        @Override
            if (syncThrow) {
import static org.hamcrest.CoreMatchers.containsString;
            Request request,
 * GitHub history for details.
        for (ShardRouting shard : shardIt) {
            this.asyncMode = true;
import org.junit.Before;
        transportService.acceptIncomingRequests();
        }
import org.opensearch.action.support.broadcast.BroadcastRequest;
 */
        void useAsyncPool(String poolName) {
            map.get(shard.currentNodeId()).add(shard);
            fail("expected ClusterBlockException");
        setState(clusterService, clusterState);
        PlainActionFuture<TransportBroadcastByNodeAction.EmptyResult> future = new PlainActionFuture<>();
import static org.hamcrest.object.HasToString.hasToString;
        assertEquals(1, action.getNodeOperationCount());
        assertEquals("total shards", action.getResults().size(), nodeResponse.getTotalShards());
            if (!(result instanceof OpenSearchException)) {
import java.io.IOException;
        }
            .addIndexBlock(
/*
                    }
 * SPDX-License-Identifier: Apache-2.0
        assertFalse("Default isAsyncShardOperation should be false", action.isAsyncShardOperation());
        String nodeId = "test-node";
 * compatible open source license.
        List<BroadcastShardOperationFailedException> exceptions = nodeResponse.getExceptions();
     * listener would never fire, and the coordinator would only get a response after its transport
import org.opensearch.action.support.broadcast.BroadcastResponse;
     */
        action.new AsyncAction(null, request, listener).start();
                totalShards += map.get(entry.getKey()).size();
        TransportResponse response = future.actionGet();
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
            List<BroadcastShardOperationFailedException> accumulatedExceptions
            }
    }
 * software distributed under the License is distributed on an
            action.new AsyncAction(null, request, listener).start();
    }
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;
                ShardRouting shard = TestShardRouting.newShardRouting(
         * and the failure (BroadcastShardOperationFailedException) aggregation branches.
        // check requests were sent to the right nodes
        assertEquals(shards, action.getResults().keySet());
    public void testRequestsAreNotSentToFailedClusterManager() {
            } else {
        }
    public static class Response extends BroadcastResponse {
            set.add(shard.currentNodeId());
        protected void nodeOperation(
        public Request(StreamInput in) throws IOException {
        List<BroadcastShardOperationFailedException> exceptions = nodeResponse.getExceptions();
            action.new BroadcastByNodeTransportRequestHandler();
    public void testAsyncShardOperation_ThreadPoolRejection_RecordedAsFailure() throws Exception {
                        totalFailedShards++;
import java.util.concurrent.TimeUnit;
        transportService.start();
        DiscoveryNode clusterManagerNode = clusterService.state().nodes().getClusterManagerNode();
        assertEquals("total shards", 2, nodeResponse.getTotalShards());
        Request request = new Request(new String[] { TEST_INDEX });
    public void testShardOperationAsync_DefaultThrowsUnsupported() {
     * If {@code shardOperationAsync} throws synchronously on the pool worker before invoking the
        Map<String, List<ShardRouting>> map = new HashMap<>();
        ClusterBlocks.Builder block = ClusterBlocks.builder()
        @Override
        String nodeId = "test-node";
            List<DefaultShardOperationFailedException> shardFailures,
        discoBuilder.clusterManagerNodeId(newNode(numberOfNodes - 1).getId());
                TransportBroadcastByNodeActionTests.this.clusterService,
                listener.onFailure(e);
        List<ShardRouting> shards = new ArrayList<>();
            action.new AsyncAction(null, request, listener).start();
        action.enableAsyncMode();
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);
    public void testResultWithTimeouts() throws ExecutionException, InterruptedException {
        final TransportBroadcastByNodeAction<?, ?, ?>.BroadcastByNodeTransportRequestHandler handler =
            Request::new,
        // Despite each shard completing twice, accounting reflects exactly 2 shards, each failed once.
                );
        @Override
            int numberOfShards = randomIntBetween(1, 10);
public class TransportBroadcastByNodeActionTests extends OpenSearchTestCase {
     * A buggy async shard operation that completes its listener more than once (e.g. a racing
        Request request = new Request(new String[] { TEST_INDEX });
        assertEquals("total shards", totalShards, response.getTotalShards());
import org.opensearch.action.IndicesRequest;
         * the first shard dispatched fails, the rest succeed — exercising both the success
        // Manually send the request from coordinator --> target nodes, action.doExecute() does not do that in this test case setup
        List<ShardRouting> shards = new ArrayList<>();
        shards.add(shard1);
        stateBuilder.metadata(Metadata.builder().put(indexMetadata));
            map.get(shard.currentNodeId()).add(shard);
import org.opensearch.OpenSearchException;
            }
                OpenSearchException e = new OpenSearchException("operation failed");
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);
        int shardIndex = -1;
        }
        }
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), shards), channel, null);
        OptionallyResolvedIndices resolvedIndices = action.resolveIndices(request);
            totalShards += map.get(failedClusterManagerNode.getId()).size();
        ShardRouting shard = TestShardRouting.newShardRouting(TEST_INDEX, 0, nodeId, true, ShardRoutingState.STARTED);
import org.opensearch.action.support.PlainActionFuture;
}
    public void testAsyncShardOperation_SyncThrowFromShardOperationAsync_RecordedAsFailure() throws Exception {
        assertThat(exceptions.get(0).getMessage(), is("operation indices:admin/test failed"));
        }
            } else {
            if (duplicateCompletion) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (Object result : action.getResults().values()) {
                    } else {
        TestTransportChannel channel = new TestTransportChannel(future);
     */
    }
    public void testOperationExecution_AsyncShardOperation() throws Exception {
        ShardId shardId = new ShardId(new Index(TEST_INDEX, "_na_"), 0);
     * Drives the node-level operation through the async dispatch path (isAsyncShardOperation=true).
            .addGlobalBlock(new ClusterBlock(1, "test-block", false, true, false, RestStatus.SERVICE_UNAVAILABLE, ClusterBlockLevel.ALL));
        IndexRoutingTable.Builder indexRoutingTable = IndexRoutingTable.builder(new Index(index, "_na_"));
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
    }
        builder.remove(clusterManagerNode.getId());
            if (!map.containsKey(shard.currentNodeId())) {
            return new Response(totalShards, successfulShards, failedShards, shardFailures);
import java.util.concurrent.ExecutionException;
        assertEquals("no shard succeeded", 0, nodeResponse.getSuccessfulShards());
            // check one request was sent to each non-cluster-manager node
 * Modifications Copyright OpenSearch Contributors. See
        MyResolver() {
     * (random) cluster shape. The shard list is supplied directly to the NodeRequest.
        final boolean simulateFailedClusterManagerNode = rarely();
        );
        super.tearDown();
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), new ArrayList<>(shards)), channel, null);
 * this file be licensed under the Apache-2.0 license or a
    private static final String TEST_CLUSTER = "test-cluster";
import org.opensearch.action.support.ActionFilters;
            ActionFilters actionFilters,
        }
        TransportResponse response = future.actionGet();
                }
        assertEquals("total shards", 2, nodeResponse.getTotalShards());
import java.util.ArrayList;
        assertEquals("node id", nodeId, nodeResponse.getNodeId());
            if (!(result instanceof OpenSearchException)) {
import org.opensearch.test.OpenSearchTestCase;
    static DiscoveryNode newNode(int nodeId) {
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =
            int failedShards,
            }
        ShardRouting shardRouting = TestShardRouting.newShardRouting(shardId, "node1", true, ShardRoutingState.STARTED);
        }
    }
                shards.add(shard);
        TransportResponse response = future.actionGet();
                super.shardOperationAsync(request, shardRouting, listener);
        ClusterBlocks.Builder block = ClusterBlocks.builder()
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        // nodeOperation aggregation hook still runs exactly once even on a fully-rejected node.
        private final AtomicInteger asyncShardCounter = new AtomicInteger(0);
        assertEquals("the rejected shard is recorded as a failure", 1, exceptions.size());
            }
        @Override
        if (simulateFailedClusterManagerNode) {
                TransportBroadcastByNodeAction.NodeResponse nodeResponse = action.new NodeResponse(
                    ShardRoutingState.STARTED
        ShardsIterator shardIt = clusterService.state().routingTable().allShards(new String[] { TEST_INDEX });
    /**
            if (!map.containsKey(shard.currentNodeId())) {
        // simulate removing the cluster-manager
            List<TransportBroadcastByNodeAction.EmptyResult> results,
        assertEquals("failed shards", totalFailedShards, response.getFailedShards());
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            assertThat(exception, hasToString(containsString("operation failed")));
        THREAD_POOL = null;
     * since subclasses must override it when using async mode.
            CapturingTransport.CapturedRequest cr = e.getValue().get(0);
        public Response(StreamInput in) throws IOException {
            builder.clusterManagerNodeId(null);
import org.opensearch.cluster.node.DiscoveryNode;
        ShardsIterator shardIt = clusterService.state().getRoutingTable().allShards(new String[] { TEST_INDEX });
        for (ShardRouting shard : shardIt) {
import org.opensearch.cluster.metadata.IndexMetadata;
            handler.messageReceived(nodeReq, channel, null);
        }
import org.opensearch.core.common.io.stream.StreamInput;
                transport.handleRemoteError(requestId, new Exception());
                List<TransportBroadcastByNodeAction.EmptyResult> shardResults = new ArrayList<>();
    /**
        setState(clusterService, ClusterState.builder(clusterService.state()).blocks(block));
import org.opensearch.cluster.block.ClusterBlockException;
 * specific language governing permissions and limitations
        protected Request readRequestFrom(StreamInput in) throws IOException {
                totalShards += map.get(entry.getKey()).size();
            final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
            if (entry.getKey().equals(failedNodeId)) {
        private final CounterMetric nodeOperationCount = new CounterMetric();
    public void testOperationExecution() throws Exception {
                map.put(shard.currentNodeId(), new ArrayList<>());
import org.opensearch.cluster.routing.ShardsIterator;
        void enableAsyncMode() {
        assertEquals("no shard succeeded — both threw synchronously", 0, nodeResponse.getSuccessfulShards());
        private volatile String asyncPoolName = ThreadPool.Names.GENERIC;
    // simulate the cluster-manager being removed from the cluster but before a new cluster-manager is elected
    public void testAsyncShardOperation_AggregatesSuccessAndFailure() throws Exception {
                TransportBroadcastByNodeAction.NodeResponse nodeResponse = action.new NodeResponse(
        Set<String> set = new HashSet<>();
        Request request = new Request(new String[] { TEST_INDEX });
                totalFailedShards += map.get(entry.getKey()).size();
        TransportService transportService = transport.createTransportService(
/*
                // Intentionally complete the same shard's listener twice. A correct framework must
        int totalFailedShards = 0;
        int numberOfNodes = randomIntBetween(3, 5);
        action.new AsyncAction(null, request, listener).start();
        TestTransportChannel channel = new TestTransportChannel(future);
        ShardsIterator shardIt = clusterService.state().routingTable().allShards(new String[] { TEST_INDEX });
            super(totalShards, successfulShards, failedShards, shardFailures);
            return clusterState.routingTable().allShards(new String[] { TEST_INDEX });
                OpenSearchException e = new OpenSearchException("operation failed");
     * still produced (no leak) and the rejection cause surfaces via the failure exception.
import org.opensearch.cluster.routing.ShardRoutingState;
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), shards), channel, null);
        // Two primary shards on the same node. The async action fails exactly the first shard to
        action = new TestTransportBroadcastByNodeAction(
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =
import org.opensearch.cluster.block.ClusterBlockLevel;
        ShardRouting shard1 = TestShardRouting.newShardRouting(TEST_INDEX, 1, nodeId, true, ShardRoutingState.STARTED);
        }
            action.new BroadcastByNodeTransportRequestHandler();
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
            } else {
            );
        ) {
    }
        action.new AsyncAction(null, request, listener).start();
                    entry.getKey(), shards.size(), shardResults, exceptions
     * shard listener in {@link org.opensearch.core.action.ActionListener#notifyOnce}, so each shard
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static java.util.Collections.emptySet;
        ShardsIterator shardIt = clusterService.state().routingTable().allShards(new String[] { TEST_INDEX });
    }
import org.opensearch.transport.ReceiveTimeoutTransportException;
    @Before
                final ShardId shardId = new ShardId(index, "_na_", ++shardIndex);
        try {
        // check the operation was executed on the correct node
     * Pointing the async pool at an unknown executor name makes {@code threadPool.executor(...).execute(...)}
        action.doExecute(mock(Task.class), request, ActionListener.wrap(listener::onResponse, listener::onFailure));
        shards.add(shard0);
            assertNotNull("failure must carry the sync-throw cause", ex.getCause());
        assertEquals(ResolvedIndices.of(TEST_INDEX), resolvedIndices);
        protected void shardOperationAsync(Request request, ShardRouting shardRouting, ActionListener<EmptyResult> listener) {
                    new ReceiveTimeoutTransportException(
        // node response is still produced (no transport-timeout hang).
import org.opensearch.Version;
            if (asyncShardCounter.getAndIncrement() == 0) {
            List<EmptyResult> emptyResults,
import org.opensearch.cluster.block.ClusterBlock;
            }
            new ActionFilters(new HashSet<>()),
            builder.remove(failedClusterManagerNode.getId());
                transportService,
    void setClusterState(ClusterService clusterService, String index) {
        }
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
            if (!shard.currentNodeId().equals(clusterManagerNode.getId())) {
    }
                );
import org.junit.After;
    }
        @Override
                return EmptyResult.INSTANCE;
        }
        int totalShards = 0;
import org.opensearch.cluster.service.ClusterService;
        @Override
            if (nodeId.equals(shard.currentNodeId())) {
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName(TEST_CLUSTER));
            for (int j = 0; j < numberOfShards; j++) {
        }
        Map<String, List<CapturingTransport.CapturedRequest>> captured = transport.getCapturedRequestsByTargetNodeAndClear();
    @BeforeClass
        assertThat(exceptions.get(0).getCause().getMessage(), containsString("rejected by thread pool"));
    }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        Request request = new Request(new String[] { TEST_INDEX });
            setState(clusterService, ClusterState.builder(clusterService.state()).nodes(builder));
    /**
        @Override
                    index,
    private CapturingTransport transport;
        final TransportBroadcastByNodeAction.BroadcastByNodeTransportRequestHandler handler =
        shards.add(shard);
        TestTransportChannel channel = new TestTransportChannel(future);
        }
        List<BroadcastShardOperationFailedException> exceptions = nodeResponse.getExceptions();
            super(in);
import org.opensearch.cluster.metadata.Metadata;
            return nodeOperationCount.count();
     * the onResponse and onFailure branches of onAsyncShardOperation execute regardless of the
        List<ShardRouting> shards = new ArrayList<>();
import org.opensearch.core.index.shard.ShardId;
            transportService,
        handler.messageReceived(action.new NodeRequest(nodeId, new Request(), shards), channel, null);
import org.opensearch.core.index.Index;
            return shards;
import static java.util.Collections.emptyMap;
        action.enableAsyncMode();
            TransportService transportService,
            return request.indices();
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder(clusterService.state().getNodes());
                shards.put(shardRouting, e);
        protected ClusterBlockException checkGlobalBlock(ClusterState state, Request request) {
        assertEquals("total shards", totalShards, response.getTotalShards());
import java.util.Set;
            null,
            TestTransportChannel channel = new TestTransportChannel(future);
        int totalSuccessfulShards = 0;
                successfulShards++;
        for (ShardRouting shard : shardIt) {
                IndexShardRoutingTable.Builder indexShard = new IndexShardRoutingTable.Builder(shardId);
                );
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
    class MyResolver extends IndexNameExpressionResolver {
        for (BroadcastShardOperationFailedException ex : exceptions) {
        assertEquals(set, capturedRequests.keySet());
                indexNameExpressionResolver,
        int totalSuccessfulShards = 0;
            int totalShards,
import java.util.Collections;
            THREAD_POOL,
            discoBuilder = discoBuilder.add(node);
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
        Set<ShardRouting> shards = new HashSet<>();
        shards.add(shard0);
        }
            assertThat(exception.getMessage(), is("operation indices:admin/test failed"));
 *
        setState(clusterService, ClusterState.builder(clusterService.state()).nodes(builder));
                        // simulate operation failure
        TestTransportChannel channel = new TestTransportChannel(future);
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);
        @Override
            }
        int successfulShards = 0;
import org.opensearch.cluster.routing.ShardRouting;
        }
            ThreadPool.Names.SAME
    /**
        protected Response newResponse(
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);
    public void testRequestBlock() {
                successfulShards++;
 *
            }
            fail("expected ClusterBlockException");
        for (int i = 0; i < numberOfNodes; i++) {
    // in this case, such a shard should be treated as unassigned
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;
        private volatile boolean syncThrow = false;
        }
        discoBuilder.localNodeId(newNode(0).getId());
 * The OpenSearch Contributors require contributions made to
        TransportResponse response = future.actionGet();
            // check one request was sent to each node
        assertEquals("failed shards", failedShards, nodeResponse.getExceptions().size());
    @After
import org.junit.BeforeClass;
        action.new AsyncAction(null, request, listener).start();
    }
        Request request = new Request(TEST_INDEX);
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
                transport.handleResponse(requestId, nodeResponse);
     * aggregated, the response is sent only after all shards complete, and nodeOperation runs once.
import org.opensearch.core.transport.TransportResponse;
        }
     * is counted exactly once and the node response is produced from complete per-shard results
            return state.blocks().indicesBlockedException(ClusterBlockLevel.METADATA_WRITE, concreteIndices);
                    totalShards++;
        final PlainActionFuture<TransportResponse> future = PlainActionFuture.newFuture();
        DiscoveryNode failedClusterManagerNode = null;
                shards.put(shardRouting, Boolean.TRUE);
        }
            Collections.emptySet(),
        ShardRouting shard1 = TestShardRouting.newShardRouting(TEST_INDEX, 1, nodeId, true, ShardRoutingState.STARTED);
                }
        // Pool used for async per-shard dispatch. A test can point this at an unknown name to exercise
                // simulate node timeout
import org.opensearch.tasks.Task;
        // Verifies the framework's per-shard try/catch funnels the throw into the listener so the
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                set.add(shard.currentNodeId());
        int totalIndexShards = 0;
        protected String asyncShardOperationThreadPool() {
        TestTransportChannel channel = new TestTransportChannel(future);
                return;
        TestTransportBroadcastByNodeAction(
    // that node will not be in the local cluster state on any node that has detected the cluster-manager as failing
        return new DiscoveryNode("node_" + nodeId, buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
import org.opensearch.cluster.ClusterName;
import org.opensearch.common.metrics.CounterMetric;
                        // simulate operation failure
                    node.getId(),
        }
        Response response = listener.get();
import java.util.List;
            ClusterState clusterState
        // check requests were sent to the right nodes
        action.enableSyncThrow();
        assertEquals("successful shards", totalSuccessfulShards, response.getSuccessfulShards());
        }
        // When true, shardOperationAsync throws synchronously before invoking the listener.
        assertEquals(1, action.getNodeOperationCount());
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
    }
     * Deterministic async aggregation: exactly one shard fails and one succeeds, guaranteeing both
        private volatile boolean asyncMode = false;
                indexShard.addShard(shard);
    }
        for (ShardRouting shard : shardIt) {
        // execute (counter == 0) and succeeds the rest, so the outcome is 1 failure + 1 success.
import org.opensearch.core.rest.RestStatus;
            }
    private static ThreadPool THREAD_POOL;
    // as such, the shards assigned to the cluster-manager will still show up in the cluster state as assigned to a node but
    public static class Request extends BroadcastRequest<Request> {
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, List<CapturingTransport.CapturedRequest>> e : captured.entrySet()) {
        assertEquals("one shard failed", 1, exceptions.size());
import java.util.concurrent.atomic.AtomicInteger;
        // to verify the framework's notifyOnce guard keeps per-shard accounting correct.
    }
     */
        Request,
            }
    /**
            this.syncThrow = true;
                failedShards++;
    }
                for (ShardRouting shard : shards) {
            super(new ThreadContext(Settings.EMPTY));
                List<ShardRouting> shards = map.get(entry.getKey());
import org.opensearch.core.action.ActionListener;
 *
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder(index)
    }
        assertEquals("successful shards", successfulShards, nodeResponse.getSuccessfulShards());
            long requestId = entry.getValue().get(0).requestId;
            totalIndexShards += numberOfShards;
 * the Apache License, Version 2.0 (the "License"); you may
        for (BroadcastShardOperationFailedException exception : exceptions) {
            this.duplicateCompletion = true;
    public void setUp() throws Exception {
import org.opensearch.test.transport.CapturingTransport;
        if (simulateFailedClusterManagerNode) {
        assertEquals(set.size(), capturedRequests.size());
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                actionFilters,
                transport.handleError(
        // Async path dispatches to the GENERIC pool; the response is only sent after all shards complete.
        assertEquals(set.size(), capturedRequests.size());
        int successfulShards = 0;
        public Map<ShardRouting, Object> getResults() {
        setState(clusterService, ClusterState.builder(clusterService.state()).blocks(block));
            return asyncPoolName;
            assertEquals(1, entry.getValue().size());
            action.new BroadcastByNodeTransportRequestHandler();
        }
        for (ShardRouting shard : shardIt) {
            failedClusterManagerNode = clusterService.state().nodes().getClusterManagerNode();
     */
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                map.put(shard.currentNodeId(), new ArrayList<>());
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
                        "indices:admin/test",
        ShardsIterator shardIt = clusterService.state().getRoutingTable().allShards(new String[] { TEST_INDEX });
    public void testAsyncShardOperation_DoubleCompletion_CountedOncePerShard() throws Exception {
            clusterService.getSettings(),
            } else {
                totalSuccessfulShards += shardResults.size();
        Response,
        protected ClusterBlockException checkRequestBlock(ClusterState state, Request request, String[] concreteIndices) {
        action.enableAsyncMode();
 * ownership. Elasticsearch licenses this file to you under
            assertThat(ex.getCause().getMessage(), containsString("synchronous failure in shardOperationAsync"));
import java.util.concurrent.ConcurrentHashMap;
        assertEquals("accumulated exceptions", totalFailedShards, response.getShardFailures().length);
        /**
        for (Map.Entry<String, List<CapturingTransport.CapturedRequest>> entry : capturedRequests.entrySet()) {
                executor
        ShardRouting shard0 = TestShardRouting.newShardRouting(TEST_INDEX, 0, nodeId, true, ShardRoutingState.STARTED);
                TEST_INDEX,
        TransportBroadcastByNodeAction.NodeResponse nodeResponse = (TransportBroadcastByNodeAction.NodeResponse) response;
        // check the operation was executed only on the expected shards
            assertThat(exception, hasToString(containsString("operation failed")));
        void enableSyncThrow() {
        public long getNodeOperationCount() {
        action.enableAsyncMode();
    }
            }
    class TestTransportBroadcastByNodeAction extends TransportBroadcastByNodeAction<
        for (ShardRouting shard : shardIt) {
        }
                    if (rarely()) {
        final PlainActionFuture<Response> listener = PlainActionFuture.newFuture();
            List<BroadcastShardOperationFailedException> exceptions = new ArrayList<>();
        assertTrue(response instanceof TransportBroadcastByNodeAction.NodeResponse);
        }
        // since static must set to null to be eligible for collection
        TestTransportChannel channel = new TestTransportChannel(future);
 * under the License.
            super(
        }
    }
        assertEquals("successful shards", totalSuccessfulShards, response.getSuccessfulShards());
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.routing.RoutingTable;
        assertEquals(1, action.getNodeOperationCount());
                        exceptions.add(new BroadcastShardOperationFailedException(shard.shardId(), "operation indices:admin/test failed"));
    }
        int totalFailedShards = 0;
    public static void destroyThreadPool() {
        public String[] concreteIndexNames(ClusterState state, IndicesRequest request) {
            super(indices);
         * Async variant used when {@link #asyncMode} is on. Completes deterministically:
                // must funnel this into the listener so the node response is still produced.
                        exceptions.add(new BroadcastShardOperationFailedException(shard.shardId(), "operation indices:admin/test failed"));
                List<TransportBroadcastByNodeAction.EmptyResult> shardResults = new ArrayList<>();
            x -> clusterService.localNode(),
     * listener, the framework's per-shard try/catch must funnel the throw into the (notifyOnce-wrapped)
        clusterService.close();
import java.util.HashMap;
        transport = new CapturingTransport();
                    requestId,
    public static void startThreadPool() {
                totalFailedShards += map.get(entry.getKey()).size();
                    }
        try {
        // The async failure path wraps the cause in a BroadcastShardOperationFailedException.
        assertEquals("total shards", 1, nodeResponse.getTotalShards());
            .numberOfReplicas(0)
import static org.hamcrest.CoreMatchers.is;
     */
 * Unless required by applicable law or agreed to in writing,
        Request request = new Request(TEST_INDEX);
        assertEquals("each shard recorded exactly one failure", 2, exceptions.size());
import org.opensearch.transport.TransportService;
        int failedShards = 0;
        Map<String, List<ShardRouting>> map = new HashMap<>();
                        shardResults.add(TransportBroadcastByNodeAction.EmptyResult.INSTANCE);
        }
                        clusterService.state().getRoutingNodes().node(entry.getKey()).node(),
import org.opensearch.cluster.block.ClusterBlocks;
                    if (rarely()) {
            }
