import java.util.Map;  
    public void testNodesSelectors() {
            super(clusterName, nodeResponses, failures);  
            Map<String, String> attributes = new HashMap<>();  
            String nodeExecutor
    protected IndicesService indicesService;  
import java.util.Collection;
            List<FailedNodeException> failures
import org.opensearch.core.common.io.stream.StreamOutput;
        // since static must set to null to be eligible for collection  
        TransportNodesAction action = getTestTransportNodesAction();
    private static class TestNodeRequest extends TransportRequest {  
            ClusterService clusterService,
    private static class TestNodesResponse extends BaseNodesResponse<TestNodeResponse> {
    }
        TestNodeRequest() {}
            testNodesRequest.writeTo(out);  
        allResponses.addAll(failures);
/*  
        action.new AsyncAction(null, request, new PlainActionFuture<>()).start();
            clusterService.getSettings(),
        private final String selector;  
        }
import org.opensearch.core.common.io.stream.StreamInput;  
        TestTransportNodesAction action = getTestTransportNodesAction();  
import org.opensearch.indices.IndicesService;  
            Writeable.Reader<TestNodeRequest> nodeRequest,
        assertSame(request, response.request);
            ThreadPool threadPool,  
/*
import org.opensearch.cluster.ClusterState;
            return in.readList(TestNodeResponse::new);  
        protected TestNodeResponse newNodeResponse(StreamInput in) throws IOException {  
    private enum NodeSelector {  
            TransportService transportService,
import org.junit.AfterClass;
        TestTransportNodesAction(
        TestNodeRequest(TestNodesRequest testNodesRequest) {  
            super(in);
    @BeforeClass
    }  
    }
            );  
            TestNodeRequest::new,
    private static class OtherNodeResponse extends BaseNodeResponse {
        @Override  
    private static class TestTransportNodesAction extends TransportNodesAction<
        // TODO: Remove this element after removing DiscoveryNodeRole.MASTER_ROLE  
        );
        DataNodesOnlyTransportNodesAction(
            Writeable.Reader<TestNodesRequest> request,
 * Unless required by applicable law or agreed to in writing,
            }
        private final TestNodesRequest request;
        }
import org.opensearch.cluster.node.DiscoveryNodes;
        String[] nodeIds = clusterService.state().nodes().getNodes().keySet().toArray(new String[0]);  
            List<TestNodeResponse> responses,  
        clusterService.close();
 * GitHub history for details.
            Set<DiscoveryNodeRole> roles = new HashSet<>(randomSubsetOf(DiscoveryNodeRole.BUILT_IN_ROLES));
        getTestTransportNodesAction().new AsyncAction(null, request, new PlainActionFuture<>()).start();
        int numNodeIds = randomIntBetween(0, 3);
        nodeResponses.add(new OtherNodeResponse());  
        List<BaseNodeResponse> nodeResponses = new ArrayList<>(expectedNodeResponses);
        @Override  
            THREAD_POOL,
            this.selector = selector;  
        assertTrue(failures.containsAll(response.failures()));
import org.opensearch.threadpool.ThreadPool;  
        return new TestTransportNodesAction(
        protected OtherNodeResponse(StreamInput in) throws IOException {
        transportService.acceptIncomingRequests();
    private <T> List<T> mockList(Supplier<T> supplier, int size) {
            List<FailedNodeException> failures
        }
import java.util.function.Supplier;
            testNodesRequest = new TestNodesRequest(in);  
        expectThrows(NullPointerException.class, () -> action.newResponse(new TestNodesRequest(), null));
            clusterService,  
import org.opensearch.core.common.io.stream.Writeable;
        }
        int numNodes = randomIntBetween(3, 10);
    private static class DataNodesOnlyTransportNodesAction extends TestTransportNodesAction {
            ThreadPool threadPool,
        }  
        );  
            new ActionFilters(Collections.emptySet()),
        int numSelectors = randomIntBetween(1, 5);  
            super(nodesIds);
        @Override  
    }
        ) {
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        @Override
        List<T> failures = new ArrayList<>(size);
    }
            discoveryNodes.add(node);
        TestNodeResponse() {
        String node = "node_" + nodeId;
import java.util.concurrent.atomic.AtomicReferenceArray;  
            this.request = request;
    public void testNewResponse() {
    @After
            TestNodesRequest::new,  
 */  
import org.junit.Before;
/*  
        }
            return new TestNodeResponse();  
            String nodeId = randomFrom(nodeIds);
    private static class TestNodesRequest extends BaseNodesRequest<TestNodesRequest> {
            ),  
        CUSTOM_ATTRIBUTE("attr:value");
            clusterService,  
                transportService,  
    }  
            super.writeTo(out);
        TestNodeRequest,
import java.util.HashSet;
                nodeExecutor,
            .flatMap(Collection::stream)  
 * KIND, either express or implied.  See the License for the
        assertEquals(nodeIds.length, capturedTransportNodeRequestList.size());  
            THREAD_POOL,
import org.junit.BeforeClass;  
        return new DataNodesOnlyTransportNodesAction(
            super(in);
        TestNodesResponse(  
        stateBuilder.nodes(discoBuilder);  
        transportService.start();  
            .stream()
        expectedNodeResponses.add(new TestNodeResponse());  
        @Override
        for (String nodeTarget : capturedRequests.keySet()) {
        protected List<TestNodeResponse> readNodesFrom(StreamInput in) throws IOException {
        TestNodeRequest(StreamInput in) throws IOException {
            assertTrue(clusterService.state().nodes().get(nodeTarget).isDataNode());  
                clusterService,
            this.testNodesRequest = testNodesRequest;
            transportService,
import java.util.ArrayList;  
            THREAD_POOL,
 *    http://www.apache.org/licenses/LICENSE-2.0
            NoopTracer.INSTANCE
        super.tearDown();
            out.writeList(nodes);
import java.util.Set;
        protected void resolveRequest(TestNodesRequest request, ClusterState clusterState) {
        TransportNodesAction action = getTestTransportNodesAction();
    }
 */
            TransportService transportService,
    public TestTransportNodesAction getTestTransportNodesAction() {  
        TestNodesRequest request = new TestNodesRequest();
        @Override
            Writeable.Reader<TestNodeRequest> nodeRequest,
            ThreadPool.Names.SAME
        assertEquals(clusterService.state().nodes().resolveNodes(finalNodesIds).length, capturedRequests.size());  
            super(mock(DiscoveryNode.class));  
        ClusterState.Builder stateBuilder = ClusterState.builder(clusterService.getClusterName());
        }
            Writeable.Reader<TestNodesRequest> request,  
        List<Object> allResponses = new ArrayList<>(expectedNodeResponses);
        capturedTransportNodeRequestList.forEach(capturedRequest -> assertNull(capturedRequest.testNodesRequest.concreteNodes()));
                nodeRequest,  
        // check requests were only sent to data nodes
            super(threadPool, clusterService, transportService, actionFilters, request, nodeRequest, nodeExecutor);
    protected ClusterService clusterService;
                request,
            x -> clusterService.localNode(),
            return new TestNodesResponse(clusterService.getClusterName(), request, responses, failures);  
        }
            List<TestNodeResponse> nodeResponses,  
 * specific language governing permissions and limitations
        assertTrue(expectedNodeResponses.containsAll(response.getNodes()));  
            super(mock(DiscoveryNode.class));
import org.opensearch.cluster.node.DiscoveryNode;
    public void testCustomResolving() throws Exception {
        }
        // This should be ignored:
    public void tearDown() throws Exception {  
    }
            TestNodesRequest request,
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;
        }
            ActionFilters actionFilters,
        transport = new CapturingTransport();
            return new TestNodeResponse(in);
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
        TransportNodesAction action = getDataNodesOnlyTransportNodesAction(transportService);
        PlainActionFuture<TestNodesResponse> listener = new PlainActionFuture<>();
import org.opensearch.cluster.service.ClusterService;
    protected TransportService transportService;
import org.opensearch.transport.TransportService;
}  
        }
        String[] nodeIds = clusterService.state().nodes().getNodes().keySet().toArray(new String[0]);  
        action.new AsyncAction(null, request, listener).start();
import org.junit.After;  
 * this file be licensed under the Apache-2.0 license or a
            nodeSelectors.add(randomFrom(NodeSelector.values()).selector);  
            new ActionFilters(Collections.emptySet()),
        }
    protected CapturingTransport transport;  
import static org.opensearch.test.ClusterServiceUtils.setState;
        protected TestNodeRequest newNodeRequest(TestNodesRequest request) {
            nodeSelectors.add(nodeId);  
        }
    }  
        }
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();  
            if (frequently()) {
 * The OpenSearch Contributors require contributions made to  
        CLUSTER_MANAGER_ELIGIBLE("cluster_manager:true"),
                actionFilters,
            ClusterName clusterName,
    }
    private static DiscoveryNode newNode(int nodeId, Map<String, String> attributes, Set<DiscoveryNodeRole> roles) {  
        discoBuilder.localNodeId(randomFrom(discoveryNodes).getId());  
public class TransportNodesActionTests extends OpenSearchTestCase {
        TestNodesRequest request = new TestNodesRequest(finalNodesIds);  
            TestNodeRequest::new,
            ActionFilters actionFilters,  
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.action.support.ActionFilters;  
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeActionTests;
        protected TestNodeResponse(StreamInput in) throws IOException {  
 */  
    }  
        ) {
        }  
 * the Apache License, Version 2.0 (the "License"); you may
        }
    public void testNewResponseNullArray() {  
        ) {
        assertEquals(numNodes, capturedRequests.size());
        Set<String> nodeSelectors = new HashSet<>();
        // note: I shuffled the overall list, so it's not possible to guarantee that it's in the right order
    @AfterClass  
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
            ThreadPool.Names.SAME
            randomIntBetween(0, 2)
            final DiscoveryNode node = newNode(i, attributes, roles);
import org.opensearch.Version;
import org.opensearch.transport.TransportRequest;
    public void setUp() throws Exception {
        THREAD_POOL = new TestThreadPool(TransportBroadcastByNodeActionTests.class.getSimpleName());  
            TestNodesRequest request,
        assertEquals(clusterService.state().nodes().getDataNodes().size(), capturedRequests.size());
    }  
    }
    }
    @Before
    public DataNodesOnlyTransportNodesAction getDataNodesOnlyTransportNodesAction(TransportService transportService) {  
 * this work for additional information regarding copyright
        TransportNodesAction action = getTestTransportNodesAction();  
        return new DiscoveryNode(node, node, buildNewFakeTransportAddress(), attributes, roles, Version.CURRENT);
import java.util.HashMap;  
            ClusterService clusterService,  
 * license agreements. See the NOTICE file distributed with
        @Override
        List<TestNodeResponse> expectedNodeResponses = mockList(TestNodeResponse::new, randomIntBetween(0, 2));
        TestNodesRequest,  
                attributes.put("custom", randomBoolean() ? "match" : randomAlphaOfLengthBetween(3, 5));  
import org.opensearch.test.OpenSearchTestCase;  
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
        }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.test.transport.CapturingTransport;
        MASTER_ELIGIBLE("master:true"),
        }
        protected TestNodesResponse newResponse(
            super(
 * compatible open source license.
        discoBuilder.clusterManagerNodeId(randomFrom(discoveryNodes).getId());
            transportService,
            super(in);  
    public void testRequestIsSentToEachNode() throws Exception {
    public void testTransportNodesActionWithDiscoveryNodesReset() {
    }
        // check a request was sent to the right number of nodes  
import java.util.List;
    }
    }
        TestNodesRequest request = new TestNodesRequest();
    public static void destroyThreadPool() {
        for (int i = 0; i < size; ++i) {  
        PlainActionFuture<TestNodesResponse> listener = new PlainActionFuture<>();
            null,
            .collect(Collectors.toList());
        protected void writeNodesTo(StreamOutput out, List<TestNodeResponse> nodes) throws IOException {
        List<TestNodeRequest> capturedTransportNodeRequestList = capturedRequests.values()
    }  
    public static void startThreadPool() {
 * Modifications Copyright OpenSearch Contributors. See
        }  
 * You may obtain a copy of the License at  
        TestNodesResponse,
        List<FailedNodeException> failures = mockList(
        NodeSelector(String selector) {
        DATA("data:true"),  
            return new TestNodeRequest(request);
        Collections.shuffle(allResponses, random());
import org.opensearch.threadpool.TestThreadPool;
        return failures;  
    }
            Collections.emptySet(),  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<DiscoveryNode> discoveryNodes = new ArrayList<>();
            String nodeExecutor  
        }
            request.setConcreteNodes(clusterState.nodes().getDataNodes().values().toArray(new DiscoveryNode[0]));  
            TestNodesRequest::new,  
    private static class TestNodeResponse extends BaseNodeResponse {
 *  
        public void writeTo(StreamOutput out) throws IOException {
        ThreadPool.terminate(THREAD_POOL, 30, TimeUnit.SECONDS);
        DiscoveryNodes.Builder discoBuilder = DiscoveryNodes.builder();  
        }
 *
        }
        TestNodesResponse response = action.newResponse(request, atomicArray);
            super(in);
        TestNodesRequest(String... nodesIds) {  
            () -> new FailedNodeException(
import org.opensearch.action.FailedNodeException;
import java.util.concurrent.TimeUnit;
        for (int i = 0; i < numNodes; i++) {
        clusterService = createClusterService(THREAD_POOL);
 * software distributed under the License is distributed on an
        ClusterState clusterState = stateBuilder.build();
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();  
        LOCAL("_local"),
 * not use this file except in compliance with the License.
        }
import org.opensearch.node.NodeService;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        int numNodes = clusterService.state().getNodes().getSize();
        AtomicReferenceArray<?> atomicArray = new AtomicReferenceArray<>(allResponses.toArray());  
 *
        transportService = transport.createTransportService(  
    protected NodeService nodeService;
import org.opensearch.cluster.ClusterName;  
            discoBuilder = discoBuilder.add(node);  
        );
        TestNodesRequest request = new TestNodesRequest(randomBoolean() ? null : generateRandomStringArray(10, 5, false, true));  
        TestNodesRequest request = new TestNodesRequest(nodeIds);
        protected TestNodesRequest testNodesRequest;
import static org.mockito.Mockito.mock;  
        setState(clusterService, clusterState);
            .map(capturedRequest -> (TestNodeRequest) capturedRequest.request)
        THREAD_POOL = null;
        protected TestNodeResponse nodeOperation(TestNodeRequest request) {
        );  
        }
                randomAlphaOfLength(8),  
        TestNodesRequest(StreamInput in) throws IOException {
            failures.add(supplier.get());
        super.setUp();  
        String[] finalNodesIds = nodeSelectors.toArray(new String[0]);
 * under the License.  
        transport.close();  
        ) {  
                threadPool,
    }
                new IllegalStateException(randomAlphaOfLength(8))
        }
        for (int i = 0; i < numSelectors; i++) {
    protected static ThreadPool THREAD_POOL;
        action.new AsyncAction(null, request, listener).start();  
        OtherNodeResponse() {  
                randomAlphaOfLength(8),
                "indices:admin/test",  
        TestNodeResponse> {  
                TestNodeResponse.class
package org.opensearch.action.support.nodes;
        for (int i = 0; i < numNodeIds; i++) {
        @Override  
import java.util.stream.Collectors;
        ELECTED_MASTER("_master"),
    }
