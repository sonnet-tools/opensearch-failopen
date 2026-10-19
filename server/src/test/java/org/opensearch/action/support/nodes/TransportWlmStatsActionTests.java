            capturedRequestList.forEach(sentRequest -> { assertNull(sentRequest.concreteNodes()); });
 *
                } catch (IOException e) {  
        Map<String, List<WlmStatsRequest>> combinedSentRequest = new HashMap<>();
        action.new AsyncAction(null, request, listener).start();  
import org.opensearch.action.support.PlainActionFuture;
        );
     */  
import java.util.HashMap;
    }  
}
            mock(WorkloadGroupService.class),
                try {  
import org.opensearch.common.io.stream.BytesStreamOutput;
            });  
    private Map<String, List<WlmStatsRequest>> performWlmStatsAction(WlmStatsRequest request) {  
    /**  
                    throw new RuntimeException(e);
import org.opensearch.action.admin.cluster.wlm.TransportWlmStatsAction;
import org.opensearch.test.transport.CapturingTransport;
                    sentRequestList.add(wlmStatsRequest);
     * We don't want to send discovery nodes list to each request that is sent across from the coordinator node.
import org.opensearch.core.common.io.stream.StreamInput;  
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
                    wlmStatsRequestFromCoordinator.writeTo(out);
 * The OpenSearch Contributors require contributions made to  
import java.util.Map;  
                BytesStreamOutput out = new BytesStreamOutput();
            clusterService,  
package org.opensearch.action.support.nodes;
        });  
    }
        TransportNodesAction action = new TransportWlmStatsAction(
            THREAD_POOL,
                    WlmStatsRequest wlmStatsRequest = new WlmStatsRequest(in);
        Map<String, List<WlmStatsRequest>> combinedSentRequest = performWlmStatsAction(request);  
     * This behavior is asserted in this test.
        return combinedSentRequest;
/*  
        });  
import org.opensearch.wlm.WorkloadGroupService;
            transportService,
                    WlmStatsRequest wlmStatsRequestFromCoordinator = (WlmStatsRequest) preSentRequest.request;
            new ActionFilters(Collections.emptySet())  
import java.util.Collections;  
        capturedRequests.forEach((node, capturedRequestList) -> {
 * compatible open source license.
public class TransportWlmStatsActionTests extends TransportNodesActionTests {
        combinedSentRequest.forEach((node, capturedRequestList) -> {  
            capturedRequestList.forEach(preSentRequest -> {
 */  
            List<WlmStatsRequest> sentRequestList = new ArrayList<>();
        Map<String, List<CapturingTransport.CapturedRequest>> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.ActionFilters;  
                }
import static org.mockito.Mockito.mock;
import org.opensearch.action.admin.cluster.wlm.WlmStatsRequest;
    public void testWlmStatsActionWithRetentionOfDiscoveryNodesList() {
            assertNotNull(capturedRequestList);
        PlainActionFuture<WlmStatsRequest> listener = new PlainActionFuture<>();
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull(combinedSentRequest);
            combinedSentRequest.put(node, sentRequestList);
                    StreamInput in = out.bytes().streamInput();  
        WlmStatsRequest request = new WlmStatsRequest();
