    ) {  
     * Because the stream transport maintains its own connections, the target node is connected on
        }
 * Modifications Copyright OpenSearch Contributors. See  
    // than falling back to the regular request/response path.  
 * SPDX-License-Identifier: Apache-2.0
                "stream transport is not enabled on this node; cannot open a streaming request to remote cluster [" + clusterAlias + "]"  
/*  
 * under the License.  
 * this work for additional information regarding copyright
        ThreadPool threadPool,  
 * You may obtain a copy of the License at  
            // (the ensureConnected above only covers the regular transport).  
                    .withType(TransportRequestOptions.Type.STREAM)  
     *  
    private static TransportException wrapAsTransportException(DiscoveryNode node, Exception e) {
 * Licensed to Elasticsearch under one or more contributor  
        }
        this.streamTransportService = streamTransportService;  
import org.opensearch.common.annotation.ExperimentalApi;
        return remoteClusterService.getRemoteClusterClient(threadPool(), clusterAlias);
            } else {
            throw new IllegalStateException(
    @Override  
    private final TransportService service;
            final DiscoveryNode node = targetNode != null ? targetNode : selectTargetNode(request);
 * compatible open source license.
            if (request instanceof RemoteClusterAwareRequest remoteClusterAwareRequest) {
        if (request instanceof RemoteClusterAwareRequest remoteClusterAwareRequest) {
        String action,
     * @throws IllegalStateException if the stream transport is not enabled on this node.
                    .withTimeout(streamTransportService.getStreamTransportReqTimeout())
 */
        this.remoteClusterService = service.getRemoteClusterService();
            );
 * software distributed under the License is distributed on an
                connection,  
import org.opensearch.cluster.node.DiscoveryNode;  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.transport;
import org.opensearch.core.action.ActionListener;  
            service.sendRequest(
    private final RemoteClusterService remoteClusterService;
        ActionType<Response> action,
        StreamTransportService streamTransportService  
            streamTransportService.connectToNode(node, null, ActionListener.wrap(c -> {
    ) {
 * KIND, either express or implied.  See the License for the
    }
        if (e instanceof TransportException te) {  
/**
 * license agreements. See the NOTICE file distributed with
     * Streaming sibling of {@link #doExecute}: sends {@code request} to the remote cluster over the
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
import org.opensearch.action.ActionType;
     * <p>Semantics mirror {@link #doExecute} exactly — same {@code ensureConnected} on the remote
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.ActionListenerResponseHandler;  
import org.opensearch.threadpool.ThreadPool;  
    ) {
 * {@link #sendStreamRequest} for streaming (Arrow Flight) requests to a remote cluster, so it is a  
 * this file be licensed under the Apache-2.0 license or a
 */
            }
            // The stream transport has its own connection manager, so connect the node there separately
        }, e -> handler.handleException(wrapAsTransportException(null, e))));
                connection = remoteClusterService.getConnection(preferredTargetNode, clusterAlias);
                final TransportRequestOptions options = TransportRequestOptions.builder()
     * cluster, same node selection ({@link RemoteClusterAwareRequest#getPreferredTargetNode()} when
    /**  
    public <T extends TransportResponse> void sendStreamRequest(
    private final StreamTransportService streamTransportService;
     */  
    public void close() {
 * The OpenSearch Contributors require contributions made to  
     * stream (Arrow Flight) transport and delivers the response batches to {@code handler}.
 */
                action.name(),
            Transport.Connection connection;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.transport.TransportResponse;
        DiscoveryNode targetNode,
import org.opensearch.transport.client.Client;
        TransportRequest request,  
    }
        }, listener::onFailure));  
                TransportRequestOptions.EMPTY,  
    }  
 * @opensearch.experimental  
    private DiscoveryNode selectTargetNode(TransportRequest request) {
        this.clusterAlias = clusterAlias;
                new ActionListenerResponseHandler<>(listener, action.getResponseReader())
        if (streamTransportService == null) {
    }
 *
                streamTransportService.sendRequest(node, action, request, options, handler);  
    // Null when the stream transport is not enabled on this node; sendStreamRequest then throws rather
    @Override
 *  
    }
        super(settings, threadPool);
 * Client that is aware of remote clusters. Beyond the regular request/response path it exposes
    RemoteClusterAwareClient(Settings settings, ThreadPool threadPool, TransportService service, String clusterAlias) {  
        remoteClusterService.ensureConnected(clusterAlias, ActionListener.wrap(v -> {  
    protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
        remoteClusterService.ensureConnected(clusterAlias, ActionListener.wrap(v -> {  
import org.opensearch.common.settings.Settings;
 * specific language governing permissions and limitations
                request,
    public Client getRemoteClusterClient(String clusterAlias) {  
import org.opensearch.core.action.ActionResponse;
        Request request,  
        return node != null ? new ConnectTransportException(node, "failed to open streaming connection", e) : new TransportException(e);  
    /**
     * its connection-oriented form because it needs a {@link Transport.Connection}, not just the node.)
            return te;
        // do nothing
        this(settings, threadPool, service, clusterAlias, null);
        }
}  
     * the stream transport (no-op if already connected) before the request is sent.  
        return remoteClusterService.getConnection(clusterAlias).getNode();
 */  
        Settings settings,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                connection = remoteClusterService.getConnection(clusterAlias);  
 *
@ExperimentalApi
    @Override  
    RemoteClusterAwareClient(
        StreamTransportResponseHandler<T> handler
            return remoteClusterAwareRequest.getPreferredTargetNode();  
import org.opensearch.transport.client.support.AbstractClient;
 * public type callers can hold to reach that streaming path.
    }
    private final String clusterAlias;  
    }  
        ActionListener<Response> listener
            );
 *
                    .build();
 * GitHub history for details.
        TransportService service,
     *
        this.service = service;  
     * carried by {@link StreamTransportService} with {@link TransportRequestOptions.Type#STREAM}.
    }  
     * the request implements it, otherwise any connected remote node) — except the request is  
 * not use this file except in compliance with the License.
        String clusterAlias,
public final class RemoteClusterAwareClient extends AbstractClient {  
/*
import org.opensearch.action.ActionRequest;
                DiscoveryNode preferredTargetNode = remoteClusterAwareRequest.getPreferredTargetNode();  
     * {@link RemoteClusterAwareRequest}, otherwise any connected remote node. ({@code doExecute} keeps
     * Node-selection rule shared with {@link #doExecute}: the request's preferred target when it is a  
     */  
            }, e -> handler.handleException(wrapAsTransportException(node, e))));
