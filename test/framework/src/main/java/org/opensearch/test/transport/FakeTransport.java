import org.opensearch.core.action.ActionListener;  
/*
 * SPDX-License-Identifier: Apache-2.0
    public List<String> getDefaultSeedAddresses() {  
    }  
    public BoundTransportAddress boundAddress() {  
import java.util.List;  
import org.opensearch.transport.CloseableConnection;  
import java.util.Map;
import org.opensearch.transport.TransportMessageListener;  
            public DiscoveryNode getNode() {
/*  
    protected void doStop() {
    @Override  
 * this file be licensed under the Apache-2.0 license or a
        return null;
 * Unless required by applicable law or agreed to in writing,
        return Collections.emptyList();
        listener.onResponse(new CloseableConnection() {  
 *  
 */  
 * specific language governing permissions and limitations
        return requestHandlers;
 * not use this file except in compliance with the License.
 *
            public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options) {
    }
 */
import org.opensearch.transport.TransportStats;  
 * A transport that does nothing. Normally wrapped by {@link StubbableTransport}.
 *     http://www.apache.org/licenses/LICENSE-2.0
                return node;  
    }
            @Override
 * this work for additional information regarding copyright
    @Override
    @Override
package org.opensearch.test.transport;
    private TransportMessageListener listener;
 * compatible open source license.
    public void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Connection> listener) {
import java.util.Collections;
    public void setMessageListener(TransportMessageListener listener) {
            throw new IllegalStateException("listener already set");  
            }
 * ownership. Elasticsearch licenses this file to you under  
        return responseHandlers;
 * KIND, either express or implied.  See the License for the
            @Override  
        return null;  
        });
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
        return new TransportAddress[0];
        if (this.listener != null) {
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
    }
    @Override
import org.opensearch.transport.TransportRequest;
    @Override
        return null;  
 */  
        }
import org.opensearch.core.common.transport.BoundTransportAddress;
        this.listener = listener;
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
    }
/*  
    protected void doStart() {
 * software distributed under the License is distributed on an
    }  
    }
 * license agreements. See the NOTICE file distributed with
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.node.DiscoveryNode;
    @Override
    }
    @Override
    @Override
    public TransportAddress[] addressesFromString(String address) {
    @Override  
 */
}  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
 *
    public TransportStats getStats() {
    private final ResponseHandlers responseHandlers = new ResponseHandlers();  
    }
 * GitHub history for details.
import org.opensearch.transport.Transport;
    }
            }  
    }  
    protected void doClose() {  
    public RequestHandlers getRequestHandlers() {  
    private final RequestHandlers requestHandlers = new RequestHandlers();
import org.opensearch.transport.TransportRequestOptions;
 * You may obtain a copy of the License at  
    public ResponseHandlers getResponseHandlers() {
import org.opensearch.transport.ConnectionProfile;
/**  
import org.opensearch.core.common.transport.TransportAddress;
    }  
    @Override
    public Map<String, BoundTransportAddress> profileBoundAddresses() {
public class FakeTransport extends AbstractLifecycleComponent implements Transport {  
