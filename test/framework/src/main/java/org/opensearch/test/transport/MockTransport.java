 *
 * not use this file except in compliance with the License.
     * @param requestId the id corresponding to the captured send
public class MockTransport extends StubbableTransport {
import org.opensearch.cluster.ClusterModule;
            }
    @Override
        connectionManager.setDefaultNodeConnectedBehavior((cm, node) -> false);
        return new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
    }
                throw new AssertionError("failed to serialize/deserialize supplied exception " + t, ioException);
    /**
        }
            tracer
import org.opensearch.core.common.transport.BoundTransportAddress;
     * exception will not be wrapped but will be delivered to the
import org.opensearch.transport.TransportInterceptor;
        onSendRequest(requestId, action, request, node);
 * under the License.
        ThreadPool threadPool,
 * A basic transport implementation that allows to intercept requests that have been sent
        final TransportResponseHandler transportResponseHandler = getResponseHandlers().onResponseReceived(requestId, listener);
        TransportRequestOptions options
                throw new AssertionError("failed to serialize/deserialize response " + response, e);
     *
            try (BytesStreamOutput output = new BytesStreamOutput()) {
        setDefaultConnectBehavior((transport, discoveryNode, profile, listener) -> listener.onResponse(createConnection(discoveryNode)));
import java.util.concurrent.ConcurrentMap;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        final TransportResponseHandler<Response> transportResponseHandler = (TransportResponseHandler<Response>) getResponseHandlers()
import org.opensearch.common.settings.Settings;
        super(new FakeTransport());
        if (transportResponseHandler != null) {
    public void handleLocalError(final long requestId, final Throwable t) {
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
import org.opensearch.threadpool.ThreadPool;
            @Override
                onSendRequest(requestId, action, request, node, options);
     * @param e         the failure
            }
 * Licensed to Elasticsearch under one or more contributor
     * @param requestId the id corresponding to the captured send
            throw new IllegalStateException("listener already set");
    public MockTransport() {
import org.opensearch.common.io.stream.BytesStreamOutput;
 * KIND, either express or implied.  See the License for the
import org.opensearch.transport.TransportService;
/*
        );
        super.setMessageListener(listener);
        }
import org.opensearch.transport.ClusterConnectionManager;
        };
     * {@link #handleRemoteError(long, Throwable)}, the provided
            transportResponseHandler.handleException(e);
 * SPDX-License-Identifier: Apache-2.0
                );
    protected NamedWriteableRegistry writeableRegistry() {
        this.handleError(requestId, remoteException);
import org.opensearch.transport.CloseableConnection;
        this.handleError(requestId, new SendRequestTransportException(request.v1(), request.v2(), t));
 * Modifications Copyright OpenSearch Contributors. See
            taskHeaders,
            .onResponseReceived(requestId, listener);
import java.util.Set;
        TransportInterceptor interceptor,
        }
            } catch (IOException ioException) {
}
    protected void onSendRequest(
import org.opensearch.transport.RemoteTransportException;
    @SuppressWarnings("unchecked")
            localNodeFactory,
    /**
import org.opensearch.common.Nullable;
        if (this.listener != null) {
                response.writeTo(output);
     */
    public void handleError(final long requestId, final TransportException e) {
 * The OpenSearch Contributors require contributions made to
     */
    ) {
import java.util.function.Function;
import org.opensearch.common.collect.Tuple;
                remoteException = new RemoteTransportException("remote failure", output.bytes().<StreamInput>streamInput().readException());
     * simulate a local error for the given requestId, will be wrapped
        assert request != null;
 * compatible open source license.
 */
import org.opensearch.cluster.node.DiscoveryNode;
     * simulate a response for the given requestId
     *                  request
 */
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.transport.TransportRequest;
                    new NamedWriteableAwareStreamInput(output.bytes().streamInput(), writeableRegistry())
     * @param requestId the id corresponding to the captured send
/*
            threadPool,
     *
     * @param t         the failure to wrap
        StubbableConnectionManager connectionManager = new StubbableConnectionManager(new ClusterConnectionManager(settings, this));
        Settings settings,
            try (BytesStreamOutput output = new BytesStreamOutput()) {
 * this file be licensed under the Apache-2.0 license or a
    }
        this.listener = listener;
     * @param t         the failure to wrap
import org.opensearch.transport.TransportException;
     */
     *
    }
    }
                return node;
    }
import org.opensearch.transport.TransportRequestOptions;
        return new TransportService(
import org.opensearch.transport.TransportResponseHandler;
    ) {
            } catch (IOException | UnsupportedOperationException e) {
        DiscoveryNode node,
            remoteException = new RemoteTransportException("remote failure, coming from local node", t);
        long requestId,
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
    public void setMessageListener(TransportMessageListener listener) {
    public Connection createConnection(DiscoveryNode node) {
    private TransportMessageListener listener;
import java.util.concurrent.ConcurrentHashMap;
    public TransportService createTransportService(
            interceptor,
     * {@link #handleLocalError(long, Throwable)} and
            public DiscoveryNode getNode() {
            settings,
        final RemoteTransportException remoteException;
    }
 * ownership. Elasticsearch licenses this file to you under
            clusterSettings,
 *
        Set<String> taskHeaders,
     * simulate an error for the given requestId, unlike
        TransportRequest request,
     */
        Tuple<DiscoveryNode, String> request = requests.get(requestId);
    private ConcurrentMap<Long, Tuple<DiscoveryNode, String>> requests = new ConcurrentHashMap<>();
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
    }
            }
import org.opensearch.telemetry.tracing.Tracer;
import org.opensearch.transport.TransportMessageListener;
    protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {}
        }
        @Nullable ClusterSettings clusterSettings,
            }
     * transport layer as is
        connectionManager.setDefaultGetConnectionBehavior((cm, discoveryNode) -> createConnection(discoveryNode));
        } else {
        if (transportResponseHandler != null) {
import static org.apache.lucene.tests.util.LuceneTestCase.rarely;
            transportResponseHandler.handleResponse(deliveredResponse);
 *
package org.opensearch.test.transport;
            public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
     *                  request
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            final Response deliveredResponse;
        Tracer tracer
            @Override
                deliveredResponse = transportResponseHandler.read(
        String action,
 * this work for additional information regarding copyright
/**
                output.writeException(t);
        return new CloseableConnection() {
import org.opensearch.core.common.io.stream.StreamInput;
     * simulate a remote error for the given requestId, will be wrapped
            connectionManager,
     * by a {@link SendRequestTransportException}
    public void handleRemoteError(final long requestId, final Throwable t) {
    }
     *                  request
                throws TransportException {
import org.opensearch.core.transport.TransportResponse;
    }
 * software distributed under the License is distributed on an
            this,
import org.opensearch.common.settings.ClusterSettings;
        if (rarely(Randomness.get())) {
 */
 * GitHub history for details.
    public <Response extends TransportResponse> void handleResponse(final long requestId, final Response response) {
 * You may obtain a copy of the License at
import org.opensearch.transport.SendRequestTransportException;
/*
import org.opensearch.common.Randomness;
    /**
     * by a {@link RemoteTransportException}
                requests.put(requestId, Tuple.tuple(node, action));
