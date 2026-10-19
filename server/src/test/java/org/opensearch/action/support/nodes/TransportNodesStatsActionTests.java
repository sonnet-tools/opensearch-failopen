 * SPDX-License-Identifier: Apache-2.0
        }
                    StreamInput in = out.bytes().streamInput();  
    }  
            clusterService,
 *
        }
    private static class TestTransportNodesStatsAction extends TransportNodesStatsAction {  
        public DiscoveryNode[] getDiscoveryNodes() {  
            nodeService,
import java.util.Collections;
        NodesStatsRequest request = new NodesStatsRequest();
            assertNotNull(capturedRequestList);  
     * We don't want to send discovery nodes list to each request that is sent across from the coordinator node.  
import org.opensearch.core.common.io.stream.StreamInput;
        });
            NodeService nodeService,
public class TransportNodesStatsActionTests extends TransportNodesActionTests {  
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
            ThreadPool threadPool,
                    TransportNodesStatsAction.NodeStatsRequest nodesStatsRequestFromCoordinator =  
                        (TransportNodesStatsAction.NodeStatsRequest) preSentRequest.request;
                BytesStreamOutput out = new BytesStreamOutput();
        public TestTransportNodesStatsAction(
            ActionFilters actionFilters  
                    nodesStatsRequestFromCoordinator.writeTo(out);
import org.opensearch.test.transport.CapturingTransport;
        capturedRequests.forEach((node, capturedRequestList) -> {  
    }
import java.util.HashMap;
import org.opensearch.cluster.service.ClusterService;  
    }  
        Map<String, List<MockNodeStatsRequest>> combinedSentRequest = new HashMap<>();
            combinedSentRequest.put(node, sentRequestList);
                    throw new RuntimeException(e);
    private TestTransportNodesStatsAction getTestTransportNodesStatsAction() {
    }
        ) {
                } catch (IOException e) {  
import org.opensearch.transport.TransportService;  
/*  
    private Map<String, List<MockNodeStatsRequest>> performNodesStatsAction(NodesStatsRequest request) {
import org.opensearch.common.io.stream.BytesStreamOutput;
}
 * The OpenSearch Contributors require contributions made to  
                }
        combinedSentRequest.forEach((node, capturedRequestList) -> {
            capturedRequestList.forEach(preSentRequest -> {  
        });  
            new ActionFilters(Collections.emptySet())
        assertNotNull(combinedSentRequest);
import org.opensearch.action.support.PlainActionFuture;
                    sentRequestList.add(nodesStatsRequest);
    private static class MockNodeStatsRequest extends TransportNodesStatsAction.NodeStatsRequest {  
        }  
    /**
 */  
            TransportService transportService,
    public void testNodesStatsActionWithoutRetentionOfDiscoveryNodesList() {  
            super(threadPool, clusterService, transportService, nodeService, actionFilters);
import org.opensearch.threadpool.ThreadPool;
            ClusterService clusterService,  
 * compatible open source license.
            });  
        public MockNodeStatsRequest(StreamInput in) throws IOException {
        Map<String, List<MockNodeStatsRequest>> combinedSentRequest = performNodesStatsAction(request);
        action.new AsyncAction(null, request, listener).start();
            super(in);  
        PlainActionFuture<NodesStatsRequest> listener = new PlainActionFuture<>();
            List<MockNodeStatsRequest> sentRequestList = new ArrayList<>();
     * This behavior is asserted in this test.
                try {
import java.io.IOException;
        );  
import java.util.List;  
            THREAD_POOL,
    }  
        TransportNodesAction action = getTestTransportNodesStatsAction();  
        return new TestTransportNodesStatsAction(  
import org.opensearch.node.NodeService;  
                    MockNodeStatsRequest nodesStatsRequest = new MockNodeStatsRequest(in);
import org.opensearch.cluster.node.DiscoveryNode;
        return combinedSentRequest;
            transportService,  
import org.opensearch.action.admin.cluster.node.stats.TransportNodesStatsAction;
     */
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
package org.opensearch.action.support.nodes;
import java.util.ArrayList;  
            return this.request.concreteNodes();
            capturedRequestList.forEach(sentRequest -> { assertNull(sentRequest.getDiscoveryNodes()); });
import org.opensearch.action.support.ActionFilters;  
