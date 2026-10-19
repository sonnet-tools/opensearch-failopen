     */
 *
/*  
 * Licensed to Elasticsearch under one or more contributor  
 *  
     * @param node the node the request was sent to
     * @param action the request action
    /***  
}  
    default void onRequestSent(
     * Called for every action response sent after the response has been passed to the underlying network implementation.
     *  
 */
     * @param action the request action
 * Unless required by applicable law or agreed to in writing,
     * @param requestId the internal request id
     * Called for every request sent to a server after the request has been passed to the underlying network implementation  
    default void onResponseReceived(long requestId, Transport.ResponseContext context) {}
     * @param requestId the request ID (unique per client)  
 * SPDX-License-Identifier: Apache-2.0
     * @param requestId the request id for this response
import org.opensearch.common.annotation.PublicApi;
    /**
 * software distributed under the License is distributed on an
    TransportMessageListener NOOP_LISTENER = new TransportMessageListener() {
import org.opensearch.core.transport.TransportResponse;  
     * @param action the request action  
     * @param requestId the internal request ID
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
    default void onResponseSent(long requestId, String action, Exception error) {}  
     */
     * Called once a request is received  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * not use this file except in compliance with the License.
@PublicApi(since = "1.0.0")
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
     * Called for every response received
 * You may obtain a copy of the License at  
 *
package org.opensearch.transport;
    @ExperimentalApi  
     * @param context the response context or null if the context was already processed ie. due to a timeout.  
 */
import org.opensearch.cluster.node.DiscoveryNode;  
 * The OpenSearch Contributors require contributions made to  
     */  
/*
        String action,
    default void onRequestReceived(long requestId, String action) {}
    default void onResponseSent(long requestId, String action, TransportResponse response) {}
        long requestId,  
 * compatible open source license.
     * @param finalOptions the request options
 * KIND, either express or implied.  See the License for the
        TransportRequestOptions finalOptions  
 * ownership. Elasticsearch licenses this file to you under  
    /**  
     * @param action the action name  
    ) {}
        DiscoveryNode node,
 * under the License.  
 * @opensearch.api  
     */
 *
 * license agreements. See the NOTICE file distributed with
 * Listens for transport messages
 * this file be licensed under the Apache-2.0 license or a
    default void onStreamResponseSent(long requestId, String action, StreamTransportResponse response) {}
import org.opensearch.common.annotation.ExperimentalApi;
     * @param error the error sent back to the caller
/**  
 * Modifications Copyright OpenSearch Contributors. See  
 */  
public interface TransportMessageListener {  
     * @param request the actual request
     * @param requestId the request ID (unique per client)
        TransportRequest request,
 * specific language governing permissions and limitations
     * @param response the response send
    /**
     * Called for every failed action response after the response has been passed to the underlying network implementation.
 * this work for additional information regarding copyright
 * GitHub history for details.
    };  
import org.opensearch.transport.stream.StreamTransportResponse;
