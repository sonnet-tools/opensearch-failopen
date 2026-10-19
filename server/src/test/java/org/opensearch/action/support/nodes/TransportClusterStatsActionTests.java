        public TestTransportClusterStatsAction(  
                    sentRequestList.add(mockClusterStatsNodeRequest);  
import org.opensearch.node.NodeService;
import java.util.Collections;
                    MockClusterStatsNodeRequest mockClusterStatsNodeRequest = new MockClusterStatsNodeRequest(in);
 * The OpenSearch Contributors require contributions made to  
        capturedRequests.forEach((node, capturedRequestList) -> {
                try {  
 *
public class TransportClusterStatsActionTests extends TransportNodesActionTests {  
        );
                } catch (IOException e) {
import org.opensearch.action.support.ActionFilters;
     * asserted in this test.
        });  
            combinedSentRequest.put(node, sentRequestList);  
        return combinedSentRequest;  
        ClusterStatsRequest request = new ClusterStatsRequest();  
        public MockClusterStatsNodeRequest(StreamInput in) throws IOException {
            super(in);  
            ClusterService clusterService,
    }  
        });
 * this file be licensed under the Apache-2.0 license or a
            IndicesService indicesService,
 * compatible open source license.
        assertNotNull(combinedSentRequest);
    /**
        request.setConcreteNodes(discoveryNodes.toArray(DiscoveryNode[]::new));
        combinedSentRequest.forEach((node, capturedRequestList) -> {
}
        TransportNodesAction action = getTestTransportClusterStatsAction();
            capturedRequestList.forEach(sentRequest -> { assertNull(sentRequest.getDiscoveryNodes()); });
    }
                    StreamInput in = out.bytes().streamInput();
            });
                BytesStreamOutput out = new BytesStreamOutput();
        Map<String, List<MockClusterStatsNodeRequest>> combinedSentRequest = performNodesInfoAction(request);
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
     * In the optimized ClusterStats Request, we do not send the DiscoveryNodes List to each node. This behavior is  
        }
            ThreadPool threadPool,
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.threadpool.ThreadPool;
            capturedRequestList.forEach(sentRequest -> { assertNull(sentRequest.getDiscoveryNodes()); });
    }  
        Map<String, List<MockClusterStatsNodeRequest>> combinedSentRequest = new HashMap<>();
     */
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
    private static class TestTransportClusterStatsAction extends TransportClusterStatsAction {
        Collection<DiscoveryNode> discoveryNodes = clusterService.state().getNodes().getNodes().values();
import org.opensearch.test.transport.CapturingTransport;  
    public void testClusterStatsActionWithoutRetentionOfDiscoveryNodesList() {  
 */  
            NodeService nodeService,
        Map<String, List<MockClusterStatsNodeRequest>> combinedSentRequest = performNodesInfoAction(request);  
                    clusterStatsNodeRequestFromCoordinator.writeTo(out);  
            new ActionFilters(Collections.emptySet())
import org.opensearch.indices.IndicesService;
            TransportService transportService,  
        ) {
        public DiscoveryNode[] getDiscoveryNodes() {  
        combinedSentRequest.forEach((node, capturedRequestList) -> {  
    private TestTransportClusterStatsAction getTestTransportClusterStatsAction() {  
        }  
import org.opensearch.cluster.service.ClusterService;
                }  
            transportService,
    }
            assertNotNull(capturedRequestList);  
            capturedRequestList.forEach(preSentRequest -> {
            ActionFilters actionFilters  
import java.util.ArrayList;
import java.util.Collection;  
            nodeService,
    private Map<String, List<MockClusterStatsNodeRequest>> performNodesInfoAction(ClusterStatsRequest request) {  
import java.util.Map;
        action.new AsyncAction(null, request, listener).start();  
            assertNotNull(capturedRequestList);
        PlainActionFuture<NodesStatsRequest> listener = new PlainActionFuture<>();
import org.opensearch.core.common.io.stream.StreamInput;  
        });
            return this.request.concreteNodes();
import java.util.List;  
package org.opensearch.action.support.nodes;
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest;
    }
                    throw new RuntimeException(e);
            THREAD_POOL,
        }
import org.opensearch.common.io.stream.BytesStreamOutput;
            indicesService,  
            super(threadPool, clusterService, transportService, nodeService, indicesService, actionFilters);
            clusterService,  
import org.opensearch.action.admin.cluster.stats.TransportClusterStatsAction;  
 * SPDX-License-Identifier: Apache-2.0
    private static class MockClusterStatsNodeRequest extends TransportClusterStatsAction.ClusterStatsNodeRequest {  
        ClusterStatsRequest request = new ClusterStatsRequest();
import org.opensearch.cluster.node.DiscoveryNode;  
    public void testClusterStatsActionWithPreFilledConcreteNodesAndWithoutRetentionOfDiscoveryNodesList() {
                    TransportClusterStatsAction.ClusterStatsNodeRequest clusterStatsNodeRequestFromCoordinator =
import org.opensearch.transport.TransportService;
            List<MockClusterStatsNodeRequest> sentRequestList = new ArrayList<>();
import java.io.IOException;
        assertNotNull(combinedSentRequest);
import java.util.HashMap;
                        (TransportClusterStatsAction.ClusterStatsNodeRequest) preSentRequest.request;
/*  
        return new TestTransportClusterStatsAction(
    }  
