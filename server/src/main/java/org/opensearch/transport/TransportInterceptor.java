/*
            TransportRequestOptions options,  
     * {@link TransportService#registerRequestHandler(String, String, boolean, boolean, Reader, TransportRequestHandler)} or
 * KIND, either express or implied.  See the License for the
    /**  
 * this work for additional information regarding copyright
        TransportRequestHandler<T> actualHandler
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 */  
 * the Apache License, Version 2.0 (the "License"); you may
     * The returned sender is used to send all requests that come in via  
 */
        return interceptHandler(action, executor, forceExecution, actualHandler);
 * under the License.  
 *
    }
        String executor,
}
     * A simple interface to decorate
     */
        );
 * software distributed under the License is distributed on an
    /**  
     * {@link TransportService#registerRequestHandler(String, String, Reader, TransportRequestHandler)}. The returned handler is  
     * This is called for handlers that needs admission control support
    ) {  
        return actualHandler;  
public interface TransportInterceptor {
 *
            Transport.Connection connection,  
import org.opensearch.core.common.io.stream.Writeable.Reader;
        boolean forceExecution,  
    interface AsyncSender {
        String action,
    }
 *  
     */
    default AsyncSender interceptSender(AsyncSender sender) {
 * This interface allows plugins to intercept requests on both the sender and the receiver side.
            TransportResponseHandler<T> handler
     */  
     * This is called up-front providing the actual low level {@link AsyncSender} that performs the low level send request.
import org.opensearch.cluster.node.DiscoveryNode;
        String action,
 */
 */  
     * {@link TransportService#sendRequest(DiscoveryNode, String, TransportRequest, TransportRequestOptions, TransportResponseHandler)}.
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
        AdmissionControlActionType admissionControlActionType
 * @opensearch.internal  
/*  
/*  
 * Modifications Copyright OpenSearch Contributors. See
     * This is called for each handler that is registered via
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
     */
     * {@link #sendRequest(Transport.Connection, String, TransportRequest, TransportRequestOptions, TransportResponseHandler)}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    default <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(  
        String executor,
        return sender;  
    /**  
    ) {
    /**
        TransportRequestHandler<T> actualHandler,
     * {@link TransportService#sendRequest(DiscoveryNode, String, TransportRequest, TransportResponseHandler)} or
 * specific language governing permissions and limitations
        <T extends TransportResponse> void sendRequest(
package org.opensearch.transport;
        boolean forceExecution,  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
    default <T extends TransportRequest> TransportRequestHandler<T> interceptHandler(  
    }
     * This allows plugins to perform actions on each send request including modifying the request context etc.  
/**  
 *
 * You may obtain a copy of the License at  
import org.opensearch.core.transport.TransportResponse;  
            TransportRequest request,
            String action,
    }  
     * used instead of the passed in handler. By default the provided handler is returned.
