import org.opensearch.transport.TransportRequestOptions;  
    /**  
    }
        connectionManager.setDefaultGetConnectionBehavior((cm, discoveryNode) -> createConnection(discoveryNode));
 * SPDX-License-Identifier: Apache-2.0
     *                  request
     */  
    protected void onSendRequest(  
     * {@link #handleRemoteError(long, Throwable)}, the provided  
    @Override
 * under the License.  
 * You may obtain a copy of the License at  
 */  
import org.opensearch.common.collect.Tuple;
     * by a {@link SendRequestTransportException}
    }  
     *                  request  
 * specific language governing permissions and limitations
import java.util.concurrent.ConcurrentHashMap;  
                remoteException = new RemoteTransportException("remote failure", output.bytes().<StreamInput>streamInput().readException());
    public MockTransport() {  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        connectionManager.setDefaultNodeConnectedBehavior((cm, node) -> false);  
 * this file be licensed under the Apache-2.0 license or a
        String action,
            try (BytesStreamOutput output = new BytesStreamOutput()) {
}
     */
 */
     * @param requestId the id corresponding to the captured send  
        return new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
    }
        Tracer tracer  
                throw new AssertionError("failed to serialize/deserialize supplied exception " + t, ioException);  
     * @param t         the failure to wrap
        ThreadPool threadPool,
            remoteException = new RemoteTransportException("remote failure, coming from local node", t);  
        if (this.listener != null) {  
        }
     * simulate an error for the given requestId, unlike
    @SuppressWarnings("unchecked")
    }
        Settings settings,  
     *                  request
     * @param t         the failure to wrap
 * GitHub history for details.
                deliveredResponse = transportResponseHandler.read(
            } catch (IOException | UnsupportedOperationException e) {
import org.opensearch.cluster.ClusterModule;
    protected NamedWriteableRegistry writeableRegistry() {
     * simulate a local error for the given requestId, will be wrapped  
    public TransportService createTransportService(
/*
            interceptor,  
        } else {
        }
import org.opensearch.common.Randomness;
package org.opensearch.test.transport;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.core.transport.TransportResponse;
            }  
    }  
import org.opensearch.transport.TransportResponseHandler;
 *
            public DiscoveryNode getNode() {  
    public void handleError(final long requestId, final TransportException e) {
    ) {
    public void handleLocalError(final long requestId, final Throwable t) {
    private TransportMessageListener listener;
        final TransportResponseHandler transportResponseHandler = getResponseHandlers().onResponseReceived(requestId, listener);  
import org.opensearch.transport.ClusterConnectionManager;
        }
                    new NamedWriteableAwareStreamInput(output.bytes().streamInput(), writeableRegistry())
        super(new FakeTransport());
     * @param requestId the id corresponding to the captured send
import org.opensearch.common.Nullable;  
 * ownership. Elasticsearch licenses this file to you under  
            public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
            transportResponseHandler.handleException(e);
        assert request != null;  
     * simulate a remote error for the given requestId, will be wrapped
        if (rarely(Randomness.get())) {
        TransportRequestOptions options
     * {@link #handleLocalError(long, Throwable)} and
            try (BytesStreamOutput output = new BytesStreamOutput()) {
    }  
        this.listener = listener;  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Settings;
        Tuple<DiscoveryNode, String> request = requests.get(requestId);
        @Nullable ClusterSettings clusterSettings,
        if (transportResponseHandler != null) {
    protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {}
/*  
     *  
            }
import org.opensearch.common.settings.ClusterSettings;
    }
 * license agreements. See the NOTICE file distributed with
        onSendRequest(requestId, action, request, node);
                onSendRequest(requestId, action, request, node, options);
        StubbableConnectionManager connectionManager = new StubbableConnectionManager(new ClusterConnectionManager(settings, this));
 *  
import org.opensearch.transport.TransportService;
                requests.put(requestId, Tuple.tuple(node, action));
        DiscoveryNode node,
 */
import org.opensearch.transport.TransportMessageListener;
     */
import org.opensearch.transport.SendRequestTransportException;
        }  
                throws TransportException {  
 * The OpenSearch Contributors require contributions made to  
    public Connection createConnection(DiscoveryNode node) {  
     * @param requestId the id corresponding to the captured send
 * KIND, either express or implied.  See the License for the
        long requestId,
            @Override
     */
import java.util.Set;
 * not use this file except in compliance with the License.
 *
        if (transportResponseHandler != null) {  
        return new CloseableConnection() {
                );  
    private ConcurrentMap<Long, Tuple<DiscoveryNode, String>> requests = new ConcurrentHashMap<>();  
    /**
     * simulate a response for the given requestId  
import org.opensearch.transport.TransportInterceptor;  
            clusterSettings,
            final Response deliveredResponse;
        setDefaultConnectBehavior((transport, discoveryNode, profile, listener) -> listener.onResponse(createConnection(discoveryNode)));
 * the Apache License, Version 2.0 (the "License"); you may
            localNodeFactory,
import org.opensearch.threadpool.ThreadPool;  
    public void setMessageListener(TransportMessageListener listener) {
     * exception will not be wrapped but will be delivered to the
import org.opensearch.transport.TransportException;
        TransportRequest request,  
        return new TransportService(
/*  
 * this work for additional information regarding copyright
 * A basic transport implementation that allows to intercept requests that have been sent
 */  
    }
        TransportInterceptor interceptor,
import org.opensearch.transport.RemoteTransportException;  
     *
/**  
            settings,  
    }
import java.util.function.Function;
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.telemetry.tracing.Tracer;
import org.opensearch.core.common.io.stream.StreamInput;
            throw new IllegalStateException("listener already set");
    /**
 * Unless required by applicable law or agreed to in writing,
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,  
        };
            this,
import org.opensearch.core.common.transport.BoundTransportAddress;  
    /**
            threadPool,
            @Override
            } catch (IOException ioException) {
import org.opensearch.transport.CloseableConnection;
        Set<String> taskHeaders,
 * software distributed under the License is distributed on an
            tracer
import org.opensearch.transport.TransportRequest;
    public <Response extends TransportResponse> void handleResponse(final long requestId, final Response response) {  
            .onResponseReceived(requestId, listener);
import static org.apache.lucene.tests.util.LuceneTestCase.rarely;
        this.handleError(requestId, new SendRequestTransportException(request.v1(), request.v2(), t));
     * by a {@link RemoteTransportException}  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
                response.writeTo(output);  
            transportResponseHandler.handleResponse(deliveredResponse);
    ) {  
        final TransportResponseHandler<Response> transportResponseHandler = (TransportResponseHandler<Response>) getResponseHandlers()
                return node;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *
 * Modifications Copyright OpenSearch Contributors. See
                throw new AssertionError("failed to serialize/deserialize response " + response, e);
 * compatible open source license.
            connectionManager,
        final RemoteTransportException remoteException;
            taskHeaders,  
    public void handleRemoteError(final long requestId, final Throwable t) {  
        this.handleError(requestId, remoteException);  
     * transport layer as is
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
            }  
            }
import java.util.concurrent.ConcurrentMap;
     * @param e         the failure  
public class MockTransport extends StubbableTransport {  
        );  
                output.writeException(t);  
    }
        super.setMessageListener(listener);
