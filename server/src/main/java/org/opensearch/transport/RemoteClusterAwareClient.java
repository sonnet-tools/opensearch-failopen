    }
     * the request implements it, otherwise any connected remote node) — except the request is
     */
            // The stream transport has its own connection manager, so connect the node there separately
            );
     *
 *
    /**
    // than falling back to the regular request/response path.
        String clusterAlias,
 * this file be licensed under the Apache-2.0 license or a
    ) {
                    .build();
            streamTransportService.connectToNode(node, null, ActionListener.wrap(c -> {
     * carried by {@link StreamTransportService} with {@link TransportRequestOptions.Type#STREAM}.
/*
     * Streaming sibling of {@link #doExecute}: sends {@code request} to the remote cluster over the
        return node != null ? new ConnectTransportException(node, "failed to open streaming connection", e) : new TransportException(e);
        ActionType<Response> action,
        return remoteClusterService.getRemoteClusterClient(threadPool(), clusterAlias);
                new ActionListenerResponseHandler<>(listener, action.getResponseReader())
        if (e instanceof TransportException te) {
 * software distributed under the License is distributed on an
    @Override
import org.opensearch.core.transport.TransportResponse;
        ActionListener<Response> listener
            throw new IllegalStateException(
import org.opensearch.core.action.ActionResponse;
 * The OpenSearch Contributors require contributions made to
        this.clusterAlias = clusterAlias;
        remoteClusterService.ensureConnected(clusterAlias, ActionListener.wrap(v -> {
    private final TransportService service;
 */
     * <p>Semantics mirror {@link #doExecute} exactly — same {@code ensureConnected} on the remote
    public <T extends TransportResponse> void sendStreamRequest(
        TransportRequest request,
 * Unless required by applicable law or agreed to in writing,
/*
 */
    private final String clusterAlias;
 * ownership. Elasticsearch licenses this file to you under
    }
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
        // do nothing
     * Because the stream transport maintains its own connections, the target node is connected on
    }
    private final RemoteClusterService remoteClusterService;
        Request request,
 * public type callers can hold to reach that streaming path.
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
        }
        this(settings, threadPool, service, clusterAlias, null);
 */
        Settings settings,
        }, e -> handler.handleException(wrapAsTransportException(null, e))));
            if (request instanceof RemoteClusterAwareRequest remoteClusterAwareRequest) {
     * @throws IllegalStateException if the stream transport is not enabled on this node.
        this.remoteClusterService = service.getRemoteClusterService();
     * its connection-oriented form because it needs a {@link Transport.Connection}, not just the node.)
    private final StreamTransportService streamTransportService;
import org.opensearch.action.ActionListenerResponseHandler;
            }
        }
        if (streamTransportService == null) {
import org.opensearch.cluster.node.DiscoveryNode;
                "stream transport is not enabled on this node; cannot open a streaming request to remote cluster [" + clusterAlias + "]"
        StreamTransportService streamTransportService
        ThreadPool threadPool,
            } else {
/**
        remoteClusterService.ensureConnected(clusterAlias, ActionListener.wrap(v -> {
        this.streamTransportService = streamTransportService;
        return remoteClusterService.getConnection(clusterAlias).getNode();
            service.sendRequest(
        if (request instanceof RemoteClusterAwareRequest remoteClusterAwareRequest) {
            return remoteClusterAwareRequest.getPreferredTargetNode();
                connection = remoteClusterService.getConnection(preferredTargetNode, clusterAlias);
     * cluster, same node selection ({@link RemoteClusterAwareRequest#getPreferredTargetNode()} when
        super(settings, threadPool);
                connection = remoteClusterService.getConnection(clusterAlias);
     * stream (Arrow Flight) transport and delivers the response batches to {@code handler}.
        DiscoveryNode targetNode,
import org.opensearch.action.ActionRequest;
    }
 * {@link #sendStreamRequest} for streaming (Arrow Flight) requests to a remote cluster, so it is a
     */
                final TransportRequestOptions options = TransportRequestOptions.builder()
                TransportRequestOptions.EMPTY,
            return te;
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor
        }
 * compatible open source license.
 *
        String action,
 * Modifications Copyright OpenSearch Contributors. See
    }
/*
 * Client that is aware of remote clusters. Beyond the regular request/response path it exposes
 *
                connection,
 * @opensearch.experimental
 * license agreements. See the NOTICE file distributed with
            final DiscoveryNode node = targetNode != null ? targetNode : selectTargetNode(request);
 * under the License.
     * Node-selection rule shared with {@link #doExecute}: the request's preferred target when it is a
    }
                    .withType(TransportRequestOptions.Type.STREAM)
     * the stream transport (no-op if already connected) before the request is sent.
     * {@link RemoteClusterAwareRequest}, otherwise any connected remote node. ({@code doExecute} keeps
     *
            );
    public void close() {
                    .withTimeout(streamTransportService.getStreamTransportReqTimeout())
        StreamTransportResponseHandler<T> handler
package org.opensearch.transport;
    }
        TransportService service,
 * You may obtain a copy of the License at
import org.opensearch.transport.client.Client;
            // (the ensureConnected above only covers the regular transport).
    @Override
import org.opensearch.common.annotation.ExperimentalApi;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private DiscoveryNode selectTargetNode(TransportRequest request) {
    RemoteClusterAwareClient(Settings settings, ThreadPool threadPool, TransportService service, String clusterAlias) {
import org.opensearch.transport.client.support.AbstractClient;
 *
    public Client getRemoteClusterClient(String clusterAlias) {
                action.name(),
    private static TransportException wrapAsTransportException(DiscoveryNode node, Exception e) {
            }, e -> handler.handleException(wrapAsTransportException(node, e))));
                request,
        this.service = service;
import org.opensearch.threadpool.ThreadPool;
 */
                streamTransportService.sendRequest(node, action, request, options, handler);
import org.opensearch.action.ActionType;
        }, listener::onFailure));
    ) {
            Transport.Connection connection;
    protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
}
                DiscoveryNode preferredTargetNode = remoteClusterAwareRequest.getPreferredTargetNode();
    RemoteClusterAwareClient(
    @Override
    // Null when the stream transport is not enabled on this node; sendStreamRequest then throws rather
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.settings.Settings;
@ExperimentalApi
 * specific language governing permissions and limitations
public final class RemoteClusterAwareClient extends AbstractClient {
    ) {
