    private static class TestTransportNodesAction extends TransportNodesAction<
        protected OtherNodeResponse(StreamInput in) throws IOException {
        @Override
        assertTrue(expectedNodeResponses.containsAll(response.getNodes()));
        protected TestNodeResponse(StreamInput in) throws IOException {
                actionFilters,
        TransportNodesAction action = getTestTransportNodesAction();
            ClusterService clusterService,
        for (int i = 0; i < numNodeIds; i++) {
        clusterService.close();
        }
        }
                clusterService,
            ThreadPool.Names.SAME
            randomIntBetween(0, 2)
 * not use this file except in compliance with the License.
            .stream()
import java.util.HashMap;
        ) {
        );
            testNodesRequest.writeTo(out);
        }
        LOCAL("_local"),
    }
 * KIND, either express or implied.  See the License for the
        TestNodesResponse response = action.newResponse(request, atomicArray);
        }
        }
 * GitHub history for details.
import java.util.Map;
        TransportNodesAction action = getDataNodesOnlyTransportNodesAction(transportService);
        PlainActionFuture<TestNodesResponse> listener = new PlainActionFuture<>();
            Writeable.Reader<TestNodeRequest> nodeRequest,
        capturedTransportNodeRequestList.forEach(capturedRequest -> assertNull(capturedRequest.testNodesRequest.concreteNodes()));
        protected List<TestNodeResponse> readNodesFrom(StreamInput in) throws IOException {
        for (int i = 0; i < numNodes; i++) {
import org.opensearch.threadpool.TestThreadPool;
        int numNodeIds = randomIntBetween(0, 3);
                nodeExecutor,
 * compatible open source license.
    @Before
    protected CapturingTransport transport;
 * Unless required by applicable law or agreed to in writing,
        @Override
    }
        return new DataNodesOnlyTransportNodesAction(
        protected TestNodeResponse newNodeResponse(StreamInput in) throws IOException {
        int numNodes = randomIntBetween(3, 10);
        @Override
        AtomicReferenceArray<?> atomicArray = new AtomicReferenceArray<>(allResponses.toArray());
    @AfterClass
import org.opensearch.threadpool.ThreadPool;
        }
        }
        CUSTOM_ATTRIBUTE("attr:value");
        }
        }
        }
        }
 * this file be licensed under the Apache-2.0 license or a
            super(in);
import org.opensearch.transport.TransportService;
        }
    }
    protected NodeService nodeService;
        TestTransportNodesAction(
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            if (frequently()) {
        }
        nodeResponses.add(new OtherNodeResponse());
/*
                randomAlphaOfLength(8),
import org.opensearch.Version;
        private final String selector;
 *    http://www.apache.org/licenses/LICENSE-2.0
        int numSelectors = randomIntBetween(1, 5);
        );
        }
    @BeforeClass
            ThreadPool threadPool,
import org.opensearch.cluster.node.DiscoveryNodes;
        // since static must set to null to be eligible for collection
        List<TestNodeRequest> capturedTransportNodeRequestList = capturedRequests.values()
        ClusterState.Builder stateBuilder = ClusterState.builder(clusterService.getClusterName());
        action.new AsyncAction(null, request, new PlainActionFuture<>()).start();
        assertTrue(failures.containsAll(response.failures()));
            super(
            String nodeExecutor
        ELECTED_MASTER("_master"),
import static org.mockito.Mockito.mock;
import org.opensearch.test.OpenSearchTestCase;
        List<Object> allResponses = new ArrayList<>(expectedNodeResponses);
            TestNodesRequest request,
                threadPool,
/*
            discoBuilder = discoBuilder.add(node);
    private static class TestNodesResponse extends BaseNodesResponse<TestNodeResponse> {
            THREAD_POOL,
import java.util.concurrent.TimeUnit;
        clusterService = createClusterService(THREAD_POOL);
    }
        List<BaseNodeResponse> nodeResponses = new ArrayList<>(expectedNodeResponses);
        );
            Writeable.Reader<TestNodesRequest> request,
            THREAD_POOL,
    }
    protected ClusterService clusterService;
        expectThrows(NullPointerException.class, () -> action.newResponse(new TestNodesRequest(), null));
        super.tearDown();
    public static void startThreadPool() {
        String node = "node_" + nodeId;
        THREAD_POOL = null;
import java.util.function.Supplier;
            TestNodesRequest::new,
    public TestTransportNodesAction getTestTransportNodesAction() {
        TestNodesRequest(StreamInput in) throws IOException {
            super(threadPool, clusterService, transportService, actionFilters, request, nodeRequest, nodeExecutor);
        TestNodeResponse() {
    }
        MASTER_ELIGIBLE("master:true"),
        }
        stateBuilder.nodes(discoBuilder);
            TestNodesRequest::new,
import org.opensearch.cluster.ClusterState;
import org.junit.BeforeClass;
    public void testNewResponseNullArray() {
        ) {
    private enum NodeSelector {
        assertSame(request, response.request);
            assertTrue(clusterService.state().nodes().get(nodeTarget).isDataNode());
        getTestTransportNodesAction().new AsyncAction(null, request, new PlainActionFuture<>()).start();
        TestNodesRequest request = new TestNodesRequest(nodeIds);
        TestNodeRequest,
import java.util.Collection;
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
import org.opensearch.node.NodeService;
            List<FailedNodeException> failures
            return in.readList(TestNodeResponse::new);
            .flatMap(Collection::stream)
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            clusterService,
                nodeRequest,
import java.util.Collections;
        List<TestNodeResponse> expectedNodeResponses = mockList(TestNodeResponse::new, randomIntBetween(0, 2));
 *
        allResponses.addAll(failures);
        }
        TestNodesRequest request = new TestNodesRequest(randomBoolean() ? null : generateRandomStringArray(10, 5, false, true));
            Collections.emptySet(),
                attributes.put("custom", randomBoolean() ? "match" : randomAlphaOfLengthBetween(3, 5));
        protected TestNodesRequest testNodesRequest;
        ThreadPool.terminate(THREAD_POOL, 30, TimeUnit.SECONDS);
            discoveryNodes.add(node);
        Set<String> nodeSelectors = new HashSet<>();
            super(mock(DiscoveryNode.class));
        expectedNodeResponses.add(new TestNodeResponse());
        return new TestTransportNodesAction(
        return failures;
 * Licensed to Elasticsearch under one or more contributor
            super(nodesIds);
    public void testNodesSelectors() {
 * SPDX-License-Identifier: Apache-2.0
            ThreadPool.Names.SAME
        }
        @Override
    }
    public void testTransportNodesActionWithDiscoveryNodesReset() {
    }
        transportService = transport.createTransportService(
            x -> clusterService.localNode(),
        TestNodeRequest(TestNodesRequest testNodesRequest) {
        TestTransportNodesAction action = getTestTransportNodesAction();
            ),
import org.opensearch.core.common.io.stream.Writeable;
        TestNodesResponse,
        TestNodeRequest(StreamInput in) throws IOException {
                transportService,
        List<FailedNodeException> failures = mockList(
import static org.opensearch.test.ClusterServiceUtils.setState;
            return new TestNodeResponse(in);
        DATA("data:true"),
            new ActionFilters(Collections.emptySet()),
            NoopTracer.INSTANCE
 * The OpenSearch Contributors require contributions made to
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void tearDown() throws Exception {
            final DiscoveryNode node = newNode(i, attributes, roles);
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
 */
        THREAD_POOL = new TestThreadPool(TransportBroadcastByNodeActionTests.class.getSimpleName());
            ActionFilters actionFilters,
        }
 */
            }
            out.writeList(nodes);
            super.writeTo(out);
/*
        ) {
            return new TestNodesResponse(clusterService.getClusterName(), request, responses, failures);
    }
        public void writeTo(StreamOutput out) throws IOException {
    private static class TestNodeResponse extends BaseNodeResponse {
    }
}
        OtherNodeResponse() {
    }
    protected IndicesService indicesService;
        TestNodesResponse(
        @Override
    }
            super(in);
package org.opensearch.action.support.nodes;
    @After
            ClusterService clusterService,
        }
        }
    }
        List<DiscoveryNode> discoveryNodes = new ArrayList<>();
            testNodesRequest = new TestNodesRequest(in);
    private static class OtherNodeResponse extends BaseNodeResponse {
    }
        TestNodesRequest request = new TestNodesRequest(finalNodesIds);
import java.util.ArrayList;
            super(in);
        private final TestNodesRequest request;
        assertEquals(nodeIds.length, capturedTransportNodeRequestList.size());
import org.opensearch.cluster.ClusterName;
        }
            Writeable.Reader<TestNodesRequest> request,
import org.opensearch.action.FailedNodeException;
        protected void resolveRequest(TestNodesRequest request, ClusterState clusterState) {
import org.opensearch.cluster.node.DiscoveryNodeRole;
            () -> new FailedNodeException(
    }
        assertEquals(clusterService.state().nodes().resolveNodes(finalNodesIds).length, capturedRequests.size());
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
    public void setUp() throws Exception {
        String[] nodeIds = clusterService.state().nodes().getNodes().keySet().toArray(new String[0]);
            List<FailedNodeException> failures
            this.selector = selector;
 */
    private static DiscoveryNode newNode(int nodeId, Map<String, String> attributes, Set<DiscoveryNodeRole> roles) {
    public static void destroyThreadPool() {
        TransportNodesAction action = getTestTransportNodesAction();
    private static class DataNodesOnlyTransportNodesAction extends TestTransportNodesAction {
 * specific language governing permissions and limitations
        assertEquals(numNodes, capturedRequests.size());
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeActionTests;
        TestNodeRequest() {}
            failures.add(supplier.get());
    public void testCustomResolving() throws Exception {
            new ActionFilters(Collections.emptySet()),
        String[] nodeIds = clusterService.state().nodes().getNodes().keySet().toArray(new String[0]);
import org.junit.AfterClass;
            super(mock(DiscoveryNode.class));
    }
        TestNodeResponse> {
        protected TestNodeResponse nodeOperation(TestNodeRequest request) {
import org.opensearch.transport.TransportRequest;
        TransportNodesAction action = getTestTransportNodesAction();
 * under the License.
            transportService,
        }
        for (String nodeTarget : capturedRequests.keySet()) {
        protected TestNodesResponse newResponse(
            TransportService transportService,
            this.request = request;
        // check a request was sent to the right number of nodes
        protected void writeNodesTo(StreamOutput out, List<TestNodeResponse> nodes) throws IOException {
    public DataNodesOnlyTransportNodesAction getDataNodesOnlyTransportNodesAction(TransportService transportService) {
import java.util.List;
            String nodeId = randomFrom(nodeIds);
                randomAlphaOfLength(8),
    public void testNewResponse() {
        @Override
        protected TestNodeRequest newNodeRequest(TestNodesRequest request) {
        transport.close();
        }
        String[] finalNodesIds = nodeSelectors.toArray(new String[0]);
        action.new AsyncAction(null, request, listener).start();
        NodeSelector(String selector) {
    public void testRequestIsSentToEachNode() throws Exception {
            Writeable.Reader<TestNodeRequest> nodeRequest,
            TransportService transportService,
        TestNodesRequest(String... nodesIds) {
            List<TestNodeResponse> responses,
 * You may obtain a copy of the License at
        ) {
            List<TestNodeResponse> nodeResponses,
            this.testNodesRequest = testNodesRequest;
import java.util.stream.Collectors;
        for (int i = 0; i < size; ++i) {
            nodeSelectors.add(nodeId);
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
    protected static ThreadPool THREAD_POOL;
        transportService.start();
 * this work for additional information regarding copyright
            return new TestNodeResponse();
    private static class TestNodesRequest extends BaseNodesRequest<TestNodesRequest> {
        super.setUp();
import org.opensearch.indices.IndicesService;
        for (int i = 0; i < numSelectors; i++) {
    private <T> List<T> mockList(Supplier<T> supplier, int size) {
 *
            ActionFilters actionFilters,
import org.junit.After;
        return new DiscoveryNode(node, node, buildNewFakeTransportAddress(), attributes, roles, Version.CURRENT);
        ClusterState clusterState = stateBuilder.build();
            Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
        @Override
        int numNodes = clusterService.state().getNodes().getSize();
    }
        @Override
        discoBuilder.clusterManagerNodeId(randomFrom(discoveryNodes).getId());
import org.opensearch.cluster.service.ClusterService;
    private static class TestNodeRequest extends TransportRequest {
 * ownership. Elasticsearch licenses this file to you under
            null,
        TestNodesRequest request = new TestNodesRequest();
            request.setConcreteNodes(clusterState.nodes().getDataNodes().values().toArray(new DiscoveryNode[0]));
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        );
    }
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            super(in);
        PlainActionFuture<TestNodesResponse> listener = new PlainActionFuture<>();
    protected TransportService transportService;
        // check requests were only sent to data nodes
            ClusterName clusterName,
            .collect(Collectors.toList());
            transportService,
        List<T> failures = new ArrayList<>(size);
        transport = new CapturingTransport();
            .map(capturedRequest -> (TestNodeRequest) capturedRequest.request)
            Map<String, String> attributes = new HashMap<>();
 *
        // TODO: Remove this element after removing DiscoveryNodeRole.MASTER_ROLE
        DataNodesOnlyTransportNodesAction(
import org.opensearch.cluster.node.DiscoveryNode;
    }
    }
        TestNodesRequest request = new TestNodesRequest();
import java.util.concurrent.atomic.AtomicReferenceArray;
        // This should be ignored:
        setState(clusterService, clusterState);
 * software distributed under the License is distributed on an
        }
import java.util.Set;
        action.new AsyncAction(null, request, listener).start();
            TestNodesRequest request,
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();
        transportService.acceptIncomingRequests();
import org.opensearch.core.common.io.stream.StreamInput;
            return new TestNodeRequest(request);
public class TransportNodesActionTests extends OpenSearchTestCase {
        }
                "indices:admin/test",
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
import java.util.HashSet;
 * the Apache License, Version 2.0 (the "License"); you may
        discoBuilder.localNodeId(randomFrom(discoveryNodes).getId());
                request,
            ThreadPool threadPool,
import java.io.IOException;
        Collections.shuffle(allResponses, random());
import org.opensearch.action.support.ActionFilters;
import org.opensearch.test.transport.CapturingTransport;
            TestNodeRequest::new,
                TestNodeResponse.class
            );
        assertEquals(clusterService.state().nodes().getDataNodes().size(), capturedRequests.size());
            clusterService.getSettings(),
import org.junit.Before;
            TestNodeRequest::new,
                new IllegalStateException(randomAlphaOfLength(8))
            nodeSelectors.add(randomFrom(NodeSelector.values()).selector);
        TestNodesRequest,
    }
        // note: I shuffled the overall list, so it's not possible to guarantee that it's in the right order
            clusterService,
            super(clusterName, nodeResponses, failures);
        CLUSTER_MANAGER_ELIGIBLE("cluster_manager:true"),
            THREAD_POOL,
            String nodeExecutor
