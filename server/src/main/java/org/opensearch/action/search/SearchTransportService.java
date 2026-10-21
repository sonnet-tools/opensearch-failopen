    public static final String FETCH_ID_SCROLL_ACTION_NAME = "indices:data/read/search[phase/fetch/id/scroll]";
                    (SearchShardTask) task,
                    new ChannelActionListener<>(channel, QUERY_ID_ACTION_NAME, request)
                assert conns != null : "number of connections for " + id + " is null, but should be an integer";
    public static final String FREE_PIT_CONTEXT_ACTION_NAME = "indices:data/read/search[free_context/pit]";
 *     http://www.apache.org/licenses/LICENSE-2.0
            QUERY_FETCH_SCROLL_ACTION_NAME,
                ChannelActionListener<
                        listener::onFailure
        @Override
                    request,
    }
            QUERY_SCROLL_ACTION_NAME,
            CLEAR_SCROLL_CONTEXTS_ACTION_NAME,
import org.opensearch.search.fetch.ShardFetchSearchRequest;
            (in) -> TransportResponse.Empty.INSTANCE
        SearchTask task,
    ) {
            super(listener, responseReader);
                    (SearchShardTask) task,
            task,
        transportService.sendRequest(
            connection,
    public static final String QUERY_SCROLL_ACTION_NAME = "indices:data/read/search[phase/query/scroll]";
     */
            if (size > 0) {
    ) {
 * Licensed to Elasticsearch under one or more contributor
            return transportService.getConnection(node);
            // can be skipped when assertions are not enabled
        transportService.registerRequestHandler(
                );
import org.opensearch.search.internal.InternalScrollSearchRequest;
        );
 * software distributed under the License is distributed on an
        private final String nodeId;
            connection,
            new ActionListenerResponseHandler<>(listener, (in) -> TransportResponse.Empty.INSTANCE)
    public void sendCanMatch(
    }
            PitFreeContextsRequest::new,
    }
            });
        ActionListener<TransportCreatePitAction.CreateReaderContextResponse> actionListener
        }
            AdmissionControlActionType.SEARCH,
     * This is a snapshot of the current pending search and not a live map.
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
            AdmissionControlActionType.SEARCH,
        transportService.registerRequestHandler(
    ) {
        );
        @Override
        );
            request,
            contextId = new ShardSearchContextId(in);
            (request, channel, task) -> {
    }
            FREE_CONTEXT_SCROLL_ACTION_NAME,
    private final TransportService transportService;
     * @opensearch.internal
import org.opensearch.search.query.QuerySearchResult;
                    (SearchShardTask) task,
import org.opensearch.core.action.ActionListener;
                }
                searchService.canMatch(request, new ChannelActionListener<>(channel, QUERY_CAN_MATCH_NAME, request));
    }
                    request,
        PitFreeContextsRequest(List<PitSearchContextIdForNode> contextIds) {
import org.opensearch.common.Nullable;
        TransportActionProxy.registerProxyAction(transportService, FREE_PIT_CONTEXT_ACTION_NAME, DeletePitResponse::new);
        @Override
        transportService.registerRequestHandler(
     * @param node the node to resolve
            transportService,
    ) {
        public void writeTo(StreamOutput out) throws IOException {
            connection,
        );
            }
            TransportRequestOptions.EMPTY,
import org.opensearch.transport.RemoteClusterService;
            super(in);
            // Decrement the number of connections or remove it entirely if there are no more connections
        Transport.Connection connection,
        transportService.sendChildRequest(
    ) {
            OriginalIndices.writeOriginalIndices(originalIndices, out);
                    PitSearchContextIdForNode contextId = new PitSearchContextIdForNode(in);
            new PitFreeContextsRequest(contextIds),
        TransportService transportService,
        transportService.sendChildRequest(
    public void sendExecuteQuery(
                searchService.executeQueryPhase(
    public static final String UPDATE_READER_CONTEXT_ACTION_NAME = "indices:data/read/search[update_context]";
            }
    }
                    TransportCreatePitAction.CreateReaderContextRequest> listener = new ChannelActionListener<>(
                searchService.freeAllScrollContexts();
        final Transport.Connection connection = transportService.getConnection(transportService.getLocalNode());
            ThreadPool.Names.SAME,
            InternalScrollSearchRequest::new,
        final SearchActionListener<DfsSearchResult> listener
     * A search free context request
                        r -> listener.onResponse(new TransportCreatePitAction.CreateReaderContextResponse(r)),
                    )
 *
                    new ChannelActionListener<>(channel, QUERY_FETCH_SCROLL_ACTION_NAME, request)
     * Used by {@link TransportSearchAction} to send the expand queries (field collapsing).
            UPDATE_READER_CONTEXT_ACTION_NAME,
    private final Map<String, Long> clientConnections = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();
    public void createPitContext(
            new ConnectionCountingHandler<>(handler, reader, clientConnections, connection.getNode().getId())
            QUERY_CAN_MATCH_NAME,
            true,
            ThreadPool.Names.SAME,
     */
            clientConnections.computeIfPresent(nodeId, (id, conns) -> conns.longValue() == 1 ? null : conns - 1);
        transportService.registerRequestHandler(
                    (SearchShardTask) task,
        }
            // Increment the number of connections for this node by one
            TransportRequestOptions.EMPTY,
        TransportActionProxy.registerProxyActionWithDynamicResponseType(
        transportService.registerRequestHandler(
            connection,
                searchService.createPitReaderContext(
        SearchTask task,
    public void updatePitContext(
        @Override
        this.responseWrapper = responseWrapper;
            TransportRequest.Empty::new,
            this.clientConnections = clientConnections;
            freed = in.readBoolean();
        Writeable.Reader<SearchPhaseResult> reader = fetchDocuments ? QueryFetchSearchResult::new : QuerySearchResult::new;
    public static class SearchFreeContextResponse extends TransportResponse {
            ScrollFreeContextRequest::new,
            TransportCreatePitAction.CreateReaderContextResponse::new
        );
     *
        public List<PitSearchContextIdForNode> getContextIds() {
import org.opensearch.action.support.IndicesOptions;
            clientConnections.compute(nodeId, (id, conns) -> conns == null ? 1 : conns + 1);
 */
                        CREATE_READER_CONTEXT_ACTION_NAME,
            task,
     */
import org.opensearch.search.fetch.QueryFetchSearchResult;
                false,
        @Override
                @Override
            ShardSearchRequest::new,
            new ConnectionCountingHandler<>(listener, MultiSearchResponse::new, clientConnections, connection.getNode().getId())
        Transport.Connection connection,
 * GitHub history for details.
        ScrollFreeContextRequest(ShardSearchContextId contextId) {
        @Override
                    // no need to respond if it was freed or not
            this.contextId = Objects.requireNonNull(contextId);
            request,
        );
        private boolean assertNodePresent() {
            super.writeTo(out);
        ScrollFreeContextRequest(StreamInput in) throws IOException {
    /**
        }
     * Returns a connection to the given node on the provided cluster. If the cluster alias is <code>null</code> the node will be resolved
            TransportRequest.Empty.INSTANCE,
        SearchTask task,
            return true;
            final Map<String, Long> clientConnections,
            QUERY_ACTION_NAME,
            request,
                return null;
            new ScrollFreeContextRequest(contextId),
            }, SearchFreeContextResponse::new)
                channel.sendResponse(new SearchFreeContextResponse(freed));
    }
                        channel,
        Transport.Connection connection,
                }
            return this.contextIds;
            new ActionListenerResponseHandler<>(actionListener, TransportCreatePitAction.CreateReaderContextResponse::new)
        ActionListener<UpdatePitContextResponse> actionListener
            request,
        private boolean freed;
        Transport.Connection connection,
    }
                return null;
    }
    }
        }
        }
            super.writeTo(out);
    /**
            if (originalIndices == null) {
            transportService,
        transportService.sendChildRequest(
import org.opensearch.search.SearchPhaseResult;
        SearchTask task,
        TransportActionProxy.registerProxyAction(transportService, QUERY_FETCH_SCROLL_ACTION_NAME, ScrollQueryFetchSearchResult::new);
        }
 * this file be licensed under the Apache-2.0 license or a
        ShardSearchContextId contextId,
            (request, channel, task) -> {
            DFS_ACTION_NAME,
            (request, channel, task) -> {
            originalIndices = OriginalIndices.readOriginalIndices(in);
    public void sendClearAllScrollContexts(Transport.Connection connection, final ActionListener<TransportResponse> listener) {
            return this.contextId;
     */
            }
 *
            ThreadPool.Names.SAME,
            QUERY_ACTION_NAME,
        TransportCreatePitAction.CreateReaderContextRequest request,
                );
     *
    }
            final Writeable.Reader<Response> responseReader,
                searchService.updatePitIdAndKeepAlive(request, listener);
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
        SearchFreeContextResponse(boolean freed) {
 * specific language governing permissions and limitations
            return transportService.getRemoteClusterService().getConnection(node, clusterAlias);
                channel.sendResponse(searchService.freeReaderContextsIfFound(request.getContextIds()));
    ) {
            return originalIndices.indices();
            InternalScrollSearchRequest::new,
        transportService.sendChildRequest(
            super.handleResponse(response);
            out.writeBoolean(freed);
        UpdatePitContextRequest request,
     *
            task,
            }
import org.opensearch.core.common.io.stream.Writeable;
                searchService.executeFetchPhase(
                boolean freed = searchService.freeReaderContext(request.id());
            connection,
        );
            TransportRequestOptions.EMPTY,
            (request, channel, task) -> {
 * @opensearch.internal
        BiFunction<Transport.Connection, SearchActionListener, ActionListener> responseWrapper
        private List<PitSearchContextIdForNode> contextIds;
        TransportActionProxy.registerProxyAction(transportService, QUERY_CAN_MATCH_NAME, SearchService.CanMatchResponse::new);
                    request,
            (request, channel, task) -> {
import org.opensearch.search.fetch.ScrollQueryFetchSearchResult;
                    new ChannelActionListener<>(channel, QUERY_SCROLL_ACTION_NAME, request)
        List<PitSearchContextIdForNode> contextIds,
    public static final String QUERY_FETCH_SCROLL_ACTION_NAME = "indices:data/read/search[phase/query+fetch/scroll]";
 * under the License.
        // we optimize this and expect a QueryFetchSearchResult if we only have a single shard in the search request
     * @opensearch.internal
        transportService.sendChildRequest(
            connection,
                    (SearchShardTask) task,
            super(in);
    ) {
        private ShardSearchContextId contextId;
        }
            TransportRequestOptions.EMPTY,
            new ConnectionCountingHandler<>(listener, DfsSearchResult::new, clientConnections, connection.getNode().getId())
                    contextIds.add(contextId);
                @Override
                    request.getShardId(),
            for (PitSearchContextIdForNode contextId : contextIds) {
        this.transportService = transportService;
    static class SearchFreeContextRequest extends ScrollFreeContextRequest implements IndicesRequest {
        }
        SearchTask task,
        final ShardSearchRequest request,
    ) {
        public void writeTo(StreamOutput out) throws IOException {
        return transportService.getRemoteClusterService();
            true,
     * A search free context response
import org.opensearch.transport.TransportActionProxy;
    public static final String FREE_CONTEXT_ACTION_NAME = "indices:data/read/search[free_context]";
            clientConnections.computeIfPresent(nodeId, (id, conns) -> conns.longValue() == 1 ? null : conns - 1);
                );
            }
            false,
            if (originalIndices == null) {
            ThreadPool.Names.SAME,
        final QuerySearchRequest request,
import org.opensearch.transport.Transport;
/*
        }
     */
    /**
        );
                    request,
    ) {
            clientConnections.compute(nodeId, (id, conns) -> {
            }
        final ActionListener<SearchService.CanMatchResponse> listener
        final SearchActionListener<FetchSearchResult> listener
        transportService.sendChildRequest(
            super(id);
                );
        );
            new ConnectionCountingHandler<>(listener, QuerySearchResult::new, clientConnections, connection.getNode().getId())
            }
    public void sendFreeContext(Transport.Connection connection, final ShardSearchContextId contextId, OriginalIndices originalIndices) {
        TransportActionProxy.registerProxyAction(transportService, DFS_ACTION_NAME, DfsSearchResult::new);
            (request) -> ((ShardSearchRequest) request).numberOfShards() == 1 ? QueryFetchSearchResult::new : QuerySearchResult::new
import org.opensearch.action.OriginalIndices;
            final ActionListener<? super Response> listener,
            ThreadPool.Names.SAME,
        String action,
    public Map<String, Long> getPendingSearchRequests() {
        if (clusterAlias == null) {
        ActionListener<DeletePitResponse> listener
        );
            QUERY_ID_ACTION_NAME,
            )
            action,
import org.opensearch.core.common.io.stream.StreamInput;
                searchService.executeQueryPhase(
    }
package org.opensearch.action.search;
import org.opensearch.transport.TransportRequest;
    ) {
import org.opensearch.search.query.ScrollQuerySearchResult;
    public static final String DFS_ACTION_NAME = "indices:data/read/search[phase/dfs]";
    public static final String FREE_CONTEXT_SCROLL_ACTION_NAME = "indices:data/read/search[free_context/scroll]";
        @Override
            }
        public void handleResponse(Response response) {
import org.opensearch.search.dfs.DfsSearchResult;
 * this work for additional information regarding copyright
        transportService.registerRequestHandler(
                new ChannelActionListener<>(channel, DFS_ACTION_NAME, request)
 * The OpenSearch Contributors require contributions made to
                );
        }
            CREATE_READER_CONTEXT_ACTION_NAME,
                    request.getKeepAlive(),
            this.contextIds = new ArrayList<>();
                );
import org.opensearch.core.transport.TransportResponse;
import org.opensearch.search.internal.ShardSearchRequest;
            MultiSearchAction.NAME,
    }
            new ActionListenerResponseHandler<>(actionListener, UpdatePitContextResponse::new)
        );
            CREATE_READER_CONTEXT_ACTION_NAME,
            connection,
            QuerySearchRequest::new,
 * transport.
    public static final String FETCH_ID_ACTION_NAME = "indices:data/read/search[phase/fetch/id]";
        final ShardFetchRequest request,
            transportService,
            task,
        );
                ChannelActionListener<UpdatePitContextResponse, UpdatePitContextRequest> listener = new ChannelActionListener<>(
            assert assertNodePresent();
            this.freed = freed;
        );
    static class ScrollFreeContextRequest extends TransportRequest {
            CLEAR_SCROLL_CONTEXTS_ACTION_NAME,
import org.opensearch.action.IndicesRequest;
            FREE_CONTEXT_ACTION_NAME,
            }
    public void sendExecuteFetch(
        }
 */
        Transport.Connection connection,
        TransportActionProxy.registerProxyAction(transportService, QUERY_ID_ACTION_NAME, QuerySearchResult::new);
            ShardFetchRequest::new,
    public static final String QUERY_ACTION_NAME = "indices:data/read/search[phase/query]";
        SearchTask task,
        }
 * Unless required by applicable law or agreed to in writing,
            connection,
import java.util.HashMap;
    }
            DFS_ACTION_NAME,
            ShardSearchRequest::new,
        final ShardFetchRequest request,
    public void sendExecuteScrollQuery(
                request,
            TransportRequestOptions.EMPTY,
        Transport.Connection connection,
import org.opensearch.transport.TransportRequestOptions;
        );
        );
    ) {
        public String[] indices() {
    /**
    public void sendExecuteScrollFetch(
            }
import org.opensearch.core.common.io.stream.StreamOutput;
            ThreadPool.Names.SAME,
            task,
        TransportActionProxy.registerProxyAction(transportService, FREE_CONTEXT_ACTION_NAME, SearchFreeContextResponse::new);
    }
        final InternalScrollSearchRequest request,
            CLEAR_SCROLL_CONTEXTS_ACTION_NAME,
        SearchTask task,
     * @opensearch.internal
        SearchTask task,
            return freed;
        Transport.Connection connection,
    public Transport.Connection getConnection(@Nullable String clusterAlias, DiscoveryNode node) {
            connection,
import java.io.IOException;
            AdmissionControlActionType.SEARCH,
     * Request to free the PIT context based on id
        }
        transportService.registerRequestHandler(
 * ownership. Elasticsearch licenses this file to you under
            UpdatePitContextRequest::new,
            contextId.writeTo(out);
        final ActionListener handler = responseWrapper.apply(connection, listener);
            FREE_PIT_CONTEXT_ACTION_NAME,
        ConnectionCountingHandler(
            (request, channel, task) -> searchService.executeDfsPhase(
        SearchFreeContextRequest(StreamInput in) throws IOException {
            ThreadPool.Names.SAME,
import org.opensearch.search.fetch.FetchSearchResult;
    }
    final class ConnectionCountingHandler<Response extends TransportResponse> extends ActionListenerResponseHandler<Response> {
import org.opensearch.search.query.QuerySearchRequest;
    }
        transportService.sendRequest(
        );
    public SearchTransportService(
    public static void registerRequestHandler(TransportService transportService, SearchService searchService) {
                    UPDATE_READER_CONTEXT_ACTION_NAME,
import org.opensearch.action.support.ChannelActionListener;
                    request,
                return conns;
import java.util.List;
            ThreadPool.Names.SAME,
            this.contextIds.addAll(contextIds);
            assert assertNodePresent();
            ThreadPool.Names.SAME,
    }
            new ActionListenerResponseHandler<>(listener, SearchFreeContextResponse::new)
            ThreadPool.Names.SAME,
            request,
        );
            }
        final ShardFetchSearchRequest request,
        final boolean fetchDocuments = request.numberOfShards() == 1;
                this.contextIds = new ArrayList<>();
                searchService.executeFetchPhase(
        TransportActionProxy.registerProxyAction(
            new ActionListenerResponseHandler<>(new ActionListener<SearchFreeContextResponse>() {
 * license agreements. See the NOTICE file distributed with
        );
            request,
        }
            }
            ThreadPool.Names.SAME,
        transportService.registerRequestHandler(
        private OriginalIndices originalIndices;
 * compatible open source license.
        TransportActionProxy.registerProxyAction(
            // Always return true, there is additional asserting here, the boolean is just so this
            true,
            false,
        );
     * against the local cluster.
        Transport.Connection connection,
            connection,
        );
                    channel,
        );
        @Override
import org.opensearch.transport.TransportException;
            CREATE_READER_CONTEXT_ACTION_NAME,
 * You may obtain a copy of the License at
            ShardSearchRequest::new,
        );
    }
 * Modifications Copyright OpenSearch Contributors. See
                channel.sendResponse(new SearchFreeContextResponse(freed));
    public static final String QUERY_CAN_MATCH_NAME = "indices:data/read/search[can_match]";
     * Return a map of nodeId to pending number of search requests.
import org.opensearch.transport.TransportService;
            new SearchFreeContextRequest(originalIndices, contextId),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
            new ActionListenerResponseHandler<>(listener, DeletePitResponse::new)
import org.opensearch.common.util.concurrent.ConcurrentCollections;
import org.opensearch.search.internal.ShardSearchContextId;
        transportService.registerRequestHandler(
        public void handleException(TransportException e) {
     * @return a connection to the given node belonging to the cluster with the provided alias.
    public static final String FREE_ALL_PIT_CONTEXTS_ACTION_NAME = "indices:data/read/search[free_pit_contexts]";
            FREE_CONTEXT_ACTION_NAME,
     */
        transportService.sendRequest(
 *
 */
    }
        );
            QUERY_FETCH_SCROLL_ACTION_NAME,
        Transport.Connection connection,
import org.opensearch.search.SearchService;
                    new ChannelActionListener<>(channel, FETCH_ID_ACTION_NAME, request)
            }
     * @opensearch.internal
        final SearchActionListener<FetchSearchResult> listener
            AdmissionControlActionType.SEARCH,
     * A handler that counts connections
    public static final String QUERY_ID_ACTION_NAME = "indices:data/read/search[phase/query/id]";
        );
        }
        final SearchActionListener<SearchPhaseResult> listener
            connection,
        final SearchActionListener<ScrollQuerySearchResult> listener
            return originalIndices.indicesOptions();
        );
        }
    /**
                assert conns >= 1 : "number of connections for " + id + " should be >= 1 but was " + conns;
            TransportRequestOptions.EMPTY,
            true,
        final InternalScrollSearchRequest request,
            // We need to remove the entry here so we don't leak when nodes go away forever
    public void sendExecuteDfs(
        final SearchActionListener<ScrollQueryFetchSearchResult> listener
        SearchFreeContextRequest(OriginalIndices originalIndices, ShardSearchContextId id) {
    }
            }
                    ActionListener.wrap(
        Transport.Connection connection,
    }
                    request,
            request,
                public void onResponse(SearchFreeContextResponse response) {
                );
            (request, channel, task) -> {
        public void writeTo(StreamOutput out) throws IOException {
            new ConnectionCountingHandler<>(listener, ScrollQuerySearchResult::new, clientConnections, connection.getNode().getId())
        ActionListener<SearchFreeContextResponse> listener
            (request, channel, task) -> {
        SearchTask task,
                    request
        PitFreeContextsRequest(StreamInput in) throws IOException {
/**
    public void sendExecuteFetchScroll(
    ) {
    public void sendExecuteQuery(
    public void sendFreePITContexts(
        );
        TransportActionProxy.registerProxyAction(transportService, FETCH_ID_SCROLL_ACTION_NAME, FetchSearchResult::new);
            // We need to remove the entry here so we don't leak when nodes go away forever
        TransportActionProxy.registerProxyAction(transportService, FREE_CONTEXT_SCROLL_ACTION_NAME, SearchFreeContextResponse::new);
        // this is cheap, it does not fetch during the rewrite phase, so we can let it quickly execute on a networking thread
                    new ChannelActionListener<>(channel, QUERY_ACTION_NAME, request)
        Transport.Connection connection,
            request,
            TransportCreatePitAction.CreateReaderContextRequest::new,
 * An encapsulation of {@link org.opensearch.search.SearchService} operations exposed through
        transportService.sendRequest(
    }
     */
            connection,
        // this used to be the QUERY_AND_FETCH which doesn't exist anymore.
    /**
import org.opensearch.search.fetch.ShardFetchRequest;
    public RemoteClusterService getRemoteClusterService() {
        private final Map<String, Long> clientConnections;
        transportService.sendChildRequest(
        transportService.registerRequestHandler(
            request,
        transportService.sendChildRequest(
 * the Apache License, Version 2.0 (the "License"); you may
                for (int i = 0; i < size; i++) {
 * SPDX-License-Identifier: Apache-2.0
        sendExecuteFetch(connection, FETCH_ID_SCROLL_ACTION_NAME, request, task, listener);
            }
            FETCH_ID_ACTION_NAME,
 *
        SearchFreeContextResponse(StreamInput in) throws IOException {
        sendExecuteFetch(connection, FETCH_ID_ACTION_NAME, request, task, listener);
                (SearchShardTask) task,
            ThreadPool.Names.SAME,
/*
        Transport.Connection connection,
     * A scroll free context request
            (request, channel, task) -> {
        }
public class SearchTransportService {
                }
            this.originalIndices = originalIndices;
        );
            (request, channel, task) -> {
        }
import java.util.function.BiFunction;
}
        TransportActionProxy.registerProxyAction(transportService, QUERY_SCROLL_ACTION_NAME, ScrollQuerySearchResult::new);
            new ConnectionCountingHandler<>(listener, ScrollQueryFetchSearchResult::new, clientConnections, connection.getNode().getId())
        transportService.registerRequestHandler(
     * @param clusterAlias the cluster alias the node should be resolved against
            SearchFreeContextRequest::new,
        }
        );
import java.util.ArrayList;
            (request, channel, task) -> {
                contextId.writeTo(out);
        final SearchActionListener<QuerySearchResult> listener
            this.nodeId = nodeId;
import org.opensearch.threadpool.ThreadPool;
            }
    ) {
            // Decrement the number of connections or remove it entirely if there are no more connections
                );
     */
            out.writeVInt(contextIds.size());
            ThreadPool.Names.SAME,
            new ActionListenerResponseHandler<>(listener, SearchService.CanMatchResponse::new)
import org.opensearch.cluster.node.DiscoveryNode;
            FETCH_ID_SCROLL_ACTION_NAME,
        return new HashMap<>(clientConnections);
        transportService.sendChildRequest(
            QUERY_ID_ACTION_NAME,
            task,
            (request, channel, task) -> {
                    (SearchShardTask) task,
 */
            connection,
        TransportActionProxy.registerProxyAction(transportService, FETCH_ID_ACTION_NAME, FetchSearchResult::new);
        }
            QUERY_ACTION_NAME,
    }
        );
            super.handleException(e);
            QUERY_CAN_MATCH_NAME,
        ) {
    protected final BiFunction<Transport.Connection, SearchActionListener, ActionListener> responseWrapper;
            false,
        transportService.registerRequestHandler(
                    );
                boolean freed = searchService.freeReaderContext(request.id());
            TransportRequestOptions.EMPTY,
        public ShardSearchContextId id() {
        final ShardSearchRequest request,
            FREE_PIT_CONTEXT_ACTION_NAME,
        transportService.registerRequestHandler(
        public IndicesOptions indicesOptions() {
            super(in);
        public void writeTo(StreamOutput out) throws IOException {
                    new ChannelActionListener<>(channel, FETCH_ID_SCROLL_ACTION_NAME, request)
            ShardFetchSearchRequest::new,
            request,
                        request
    }
    ) {
                searchService.executeQueryPhase(
            int size = in.readVInt();
import java.util.Map;
            super.writeTo(out);
        TransportActionProxy.registerProxyAction(transportService, UPDATE_READER_CONTEXT_ACTION_NAME, UpdatePitContextResponse::new);
        );
    public static final String CREATE_READER_CONTEXT_ACTION_NAME = "indices:data/read/search[create_context]";
            (request, channel, task) -> {
/*
        public boolean isFreed() {
            }
    static class PitFreeContextsRequest extends TransportRequest {
        transportService.sendRequest(
                searchService.executeFetchPhase(
import org.opensearch.action.ActionListenerResponseHandler;
            QUERY_SCROLL_ACTION_NAME,
     *
            FREE_CONTEXT_SCROLL_ACTION_NAME,
    public static final String CLEAR_SCROLL_CONTEXTS_ACTION_NAME = "indices:data/read/search[clear_scroll_contexts]";
            true,
            task,
        final ShardSearchRequest request,
            final String nodeId
        Transport.Connection connection,
    void sendExecuteMultiSearch(final MultiSearchRequest request, SearchTask task, final ActionListener<MultiSearchResponse> listener) {
    private void sendExecuteFetch(
import java.util.Objects;
        } else {
        final SearchActionListener<FetchSearchResult> listener
            connection,
    public void sendFreeContext(
        SearchTask task,
            task,
            (request, channel, task) -> {
 * KIND, either express or implied.  See the License for the
            task,
    }
        );
        transportService.registerRequestHandler(
                    TransportCreatePitAction.CreateReaderContextResponse,
            ThreadPool.Names.SAME,
 * not use this file except in compliance with the License.
                    false,
        }
                public void onFailure(Exception e) {
            UPDATE_READER_CONTEXT_ACTION_NAME,
            new ConnectionCountingHandler<>(listener, FetchSearchResult::new, clientConnections, connection.getNode().getId())
    /**
        }
