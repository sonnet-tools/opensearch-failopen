    }  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * specific language governing permissions and limitations
 * GitHub history for details.
     * Returns all requests captured so far. This method does clear the  
        public final TransportRequest request;
        return groupRequestsByTargetNode(requests);  
package org.opensearch.test.transport;
     * {@link #capturedRequestsByTargetNode()}.
 * this work for additional information regarding copyright
public class CapturingTransport extends MockTransport implements Transport {
    }  
 * compatible open source license.
        }
        return result;
    }
        capturedRequests.add(new CapturingTransport.CapturedRequest(node, requestId, action, request, null));
import java.util.ArrayList;
    private Map<String, List<CapturedRequest>> groupRequestsByTargetNode(Collection<CapturedRequest> requests) {  
     *  
        public final DiscoveryNode node;
import java.util.HashMap;  
     * clears captured requests
 * not use this file except in compliance with the License.
    protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
     * Doesn't clear the captured request list. See {@link #clear()}
        public final TransportRequestOptions options;  
     * @return the captured requests grouped by target node
    }  
     */
    }  
            this.requestId = requestId;
     * list cleared, use {@link #capturedRequests()}.
        capturedRequests.drainTo(requests);
            this.node = node;  
/*  
import org.opensearch.transport.TransportRequest;
    /**
 * A transport class that doesn't send anything but rather captures all requests for inspection from tests  
/*  
 *
    public static class CapturedRequest {
        TransportRequestOptions options
        TransportRequest request,
    ) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.node.DiscoveryNode;
            this.action = action;
     * captured requests list. If you do not want the captured requests
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
        capturedRequests.drainTo(requests);
     * returns all requests captured so far. Doesn't clear the captured request list. See {@link #clear()}
    }
     */
    public Map<String, List<CapturedRequest>> getCapturedRequestsByTargetNodeAndClear() {  
 *
     * returns all requests captured so far, grouped by target node.  
        return capturedRequests.toArray(new CapturedRequest[0]);
 */  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        public final String action;
    }
        String action,
     */  
            this.request = request;  
            this.options = options;
import java.util.concurrent.BlockingQueue;  
    private BlockingQueue<CapturedRequest> capturedRequests = ConcurrentCollections.newBlockingQueue();
/**
import org.opensearch.transport.TransportRequestOptions;
}
/*
        capturedRequests.clear();
        List<CapturedRequest> requests = new ArrayList<>(capturedRequests.size());
 */
    }
     * want the captured requests list cleared, use
        CapturedRequest(DiscoveryNode node, long requestId, String action, TransportRequest request, TransportRequestOptions options) {
import org.opensearch.transport.Transport;  
        public final long requestId;  
 *  
        Map<String, List<CapturedRequest>> result = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor  
    public void clear() {  
 * You may obtain a copy of the License at  
            result.computeIfAbsent(request.node.getId(), node -> new ArrayList<>()).add(request);  
        long requestId,  
    protected void onSendRequest(
    /**
        return groupRequestsByTargetNode(capturedRequests);
 * software distributed under the License is distributed on an
    public Map<String, List<CapturedRequest>> capturedRequestsByTargetNode() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
     * @return the captured requests
        DiscoveryNode node,  
 */
        capturedRequests.add(new CapturingTransport.CapturedRequest(node, requestId, action, request, options));  
        List<CapturedRequest> requests = new ArrayList<>(capturedRequests.size());
    public CapturedRequest[] capturedRequests() {
     */
     *  
import java.util.Collection;
    }
    public CapturedRequest[] getCapturedRequestsAndClear() {  
import java.util.List;
     * This method does clear the captured request list. If you do not  
 * this file be licensed under the Apache-2.0 license or a
     */
 * license agreements. See the NOTICE file distributed with
        }
     * Returns all requests captured so far, grouped by target node.
import java.util.Map;
    /**
        for (CapturedRequest request : requests) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
    /**
 * Unless required by applicable law or agreed to in writing,
        return requests.toArray(new CapturedRequest[0]);  
