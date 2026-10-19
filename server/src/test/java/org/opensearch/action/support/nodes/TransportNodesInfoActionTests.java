        public TestTransportNodesInfoAction(
        );
        NodesInfoRequest request = new NodesInfoRequest();
     * In the optimized ClusterStats Request, we do not send the DiscoveryNodes List to each node. This behavior is
 *
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;  
    }
        }  
    private static class TestTransportNodesInfoAction extends TransportNodesInfoAction {
            transportService,
import org.opensearch.test.transport.CapturingTransport;
            });
     * asserted in this test.
                        (TransportNodesInfoAction.NodeInfoRequest) preSentRequest.request;
            ActionFilters actionFilters
    private Map<String, List<MockNodesInfoRequest>> performNodesInfoAction(NodesInfoRequest request) {  
 * this file be licensed under the Apache-2.0 license or a
            capturedRequestList.forEach(sentRequest -> { assertNull(sentRequest.getDiscoveryNodes()); });
import java.util.HashMap;  
        combinedSentRequest.forEach((node, capturedRequestList) -> {  
    private static class MockNodesInfoRequest extends TransportNodesInfoAction.NodeInfoRequest {
                    StreamInput in = out.bytes().streamInput();
        return new TestTransportNodesInfoAction(
public class TransportNodesInfoActionTests extends TransportNodesActionTests {
        }
        public MockNodesInfoRequest(StreamInput in) throws IOException {  
import java.util.List;
            List<MockNodesInfoRequest> sentRequestList = new ArrayList<>();
            super(threadPool, clusterService, transportService, nodeService, actionFilters);  
        Map<String, List<MockNodesInfoRequest>> combinedSentRequest = performNodesInfoAction(request);  
        });  
                    nodesInfoRequestFromCoordinator.writeTo(out);  
            new ActionFilters(Collections.emptySet())  
import org.opensearch.action.support.ActionFilters;
                    TransportNodesInfoAction.NodeInfoRequest nodesInfoRequestFromCoordinator =
        PlainActionFuture<NodesStatsRequest> listener = new PlainActionFuture<>();
        public DiscoveryNode[] getDiscoveryNodes() {
            return this.request.concreteNodes();
            ThreadPool threadPool,  
        action.new AsyncAction(null, request, listener).start();  
    public void testNodesInfoActionWithoutRetentionOfDiscoveryNodesList() {
            super(in);
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
                    throw new RuntimeException(e);
    private TestTransportNodesInfoAction getTestTransportNodesInfoAction() {  
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
import org.opensearch.node.NodeService;
import java.util.ArrayList;
                BytesStreamOutput out = new BytesStreamOutput();
    }
import org.opensearch.action.admin.cluster.node.info.TransportNodesInfoAction;
 */  
            ClusterService clusterService,
            capturedRequestList.forEach(preSentRequest -> {
    }
package org.opensearch.action.support.nodes;
import java.io.IOException;  
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
        Map<String, List<MockNodesInfoRequest>> combinedSentRequest = new HashMap<>();
import org.opensearch.transport.TransportService;
}
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
                }  
    }
            NodeService nodeService,  
        ) {
import java.util.Map;
                try {  
        TransportNodesAction action = getTestTransportNodesInfoAction();
            THREAD_POOL,
import org.opensearch.cluster.service.ClusterService;
            assertNotNull(capturedRequestList);
        capturedRequests.forEach((node, capturedRequestList) -> {
     */  
            nodeService,
    /**  
            clusterService,  
import org.opensearch.threadpool.ThreadPool;  
        return combinedSentRequest;  
                    sentRequestList.add(nodesStatsRequest);  
        }
        });
            TransportService transportService,
            combinedSentRequest.put(node, sentRequestList);  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;  
                    MockNodesInfoRequest nodesStatsRequest = new MockNodesInfoRequest(in);
import org.opensearch.cluster.node.DiscoveryNode;  
import org.opensearch.action.support.PlainActionFuture;
                } catch (IOException e) {
        assertNotNull(combinedSentRequest);
 * compatible open source license.
/*  
