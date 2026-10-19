        transportService.registerRequestHandler(
            return true;  
        transportService.sendRequest(
            this.originalIndices = originalIndices;
            this.freed = freed;
 * compatible open source license.
    public static final String QUERY_SCROLL_ACTION_NAME = "indices:data/read/search[phase/query/scroll]";
     *
    }
            FREE_CONTEXT_SCROLL_ACTION_NAME,
    }
     */
            return transportService.getConnection(node);  
        }
            ThreadPool.Names.SAME,  
     */
                    (SearchShardTask) task,  
    }
            FETCH_ID_SCROLL_ACTION_NAME,  
                }  
        );  
            AdmissionControlActionType.SEARCH,
    ) {
            transportService,  
            super(in);
import java.util.function.BiFunction;
                searchService.canMatch(request, new ChannelActionListener<>(channel, QUERY_CAN_MATCH_NAME, request));  
            contextId.writeTo(out);
                        channel,  
            FREE_CONTEXT_SCROLL_ACTION_NAME,
        }
     */  
            }
            AdmissionControlActionType.SEARCH,
        transportService.registerRequestHandler(
        );  
            // We need to remove the entry here so we don't leak when nodes go away forever
            (request, channel, task) -> searchService.executeDfsPhase(  
            ThreadPool.Names.SAME,  
            // can be skipped when assertions are not enabled
     * @param node the node to resolve
            OriginalIndices.writeOriginalIndices(originalIndices, out);  
        }
                    channel,
            transportService,  
    public Transport.Connection getConnection(@Nullable String clusterAlias, DiscoveryNode node) {
import java.io.IOException;
        // this used to be the QUERY_AND_FETCH which doesn't exist anymore.
        transportService.sendRequest(
    public static final String QUERY_FETCH_SCROLL_ACTION_NAME = "indices:data/read/search[phase/query+fetch/scroll]";  
        }  
            task,  
            task,
     * @opensearch.internal  
                this.contextIds = new ArrayList<>();
    public void sendExecuteQuery(  
            (request, channel, task) -> {
                @Override
            TransportRequest.Empty.INSTANCE,
        );  
            super.writeTo(out);
 * The OpenSearch Contributors require contributions made to  
        sendExecuteFetch(connection, FETCH_ID_SCROLL_ACTION_NAME, request, task, listener);  
        } else {
        @Override
        Transport.Connection connection,
        transportService.sendRequest(  
    }
        SearchTask task,  
    public void sendFreeContext(  
        transportService.sendChildRequest(  
     * against the local cluster.
        }
        TransportActionProxy.registerProxyActionWithDynamicResponseType(
     * A handler that counts connections
            return transportService.getRemoteClusterService().getConnection(node, clusterAlias);
            this.contextIds = new ArrayList<>();  
                    request.getShardId(),
        final SearchActionListener<ScrollQuerySearchResult> listener
import org.opensearch.core.common.io.stream.StreamInput;
            contextId = new ShardSearchContextId(in);
            (request, channel, task) -> {
     * @opensearch.internal  
        SearchFreeContextResponse(StreamInput in) throws IOException {  
 * An encapsulation of {@link org.opensearch.search.SearchService} operations exposed through
            super(in);
            request,  
            }
                false,
            AdmissionControlActionType.SEARCH,  
            task,
import org.opensearch.core.action.ActionListener;  
    }
            FREE_CONTEXT_ACTION_NAME,
    public static class SearchFreeContextResponse extends TransportResponse {
            out.writeVInt(contextIds.size());
        final ActionListener<SearchService.CanMatchResponse> listener  
            ThreadPool.Names.SAME,  
            return freed;  
        transportService.registerRequestHandler(
        TransportActionProxy.registerProxyAction(transportService, FREE_CONTEXT_SCROLL_ACTION_NAME, SearchFreeContextResponse::new);
            false,
        public boolean isFreed() {
            task,
     *
            }
            ThreadPool.Names.SAME,
    public void sendClearAllScrollContexts(Transport.Connection connection, final ActionListener<TransportResponse> listener) {  
        final ShardFetchRequest request,  
import org.opensearch.transport.RemoteClusterService;  
    /**
            FREE_CONTEXT_ACTION_NAME,
            CREATE_READER_CONTEXT_ACTION_NAME,
    public void sendExecuteQuery(  
import org.opensearch.transport.TransportActionProxy;
        TransportCreatePitAction.CreateReaderContextRequest request,  
            QuerySearchRequest::new,
            ThreadPool.Names.SAME,
            (request, channel, task) -> {
        // this is cheap, it does not fetch during the rewrite phase, so we can let it quickly execute on a networking thread  
            request,  
            action,  
                assert conns != null : "number of connections for " + id + " is null, but should be an integer";  
    protected final BiFunction<Transport.Connection, SearchActionListener, ActionListener> responseWrapper;
            task,
        SearchTask task,  
import org.opensearch.search.fetch.ScrollQueryFetchSearchResult;
            ShardFetchSearchRequest::new,
                );
        Transport.Connection connection,
                    TransportCreatePitAction.CreateReaderContextRequest> listener = new ChannelActionListener<>(
            for (PitSearchContextIdForNode contextId : contextIds) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
        BiFunction<Transport.Connection, SearchActionListener, ActionListener> responseWrapper
            connection,
        SearchFreeContextRequest(StreamInput in) throws IOException {
            }  
            request,  
import org.opensearch.search.fetch.ShardFetchRequest;  
        @Override
import org.opensearch.transport.TransportRequest;
        private ShardSearchContextId contextId;  
            (request, channel, task) -> {
 * Licensed to Elasticsearch under one or more contributor  
        }
import org.opensearch.search.query.QuerySearchRequest;
 * SPDX-License-Identifier: Apache-2.0
                    (SearchShardTask) task,  
            ShardSearchRequest::new,
    public void sendExecuteScrollFetch(  
        }
    ) {
        public void writeTo(StreamOutput out) throws IOException {
    }
    }
    public void sendExecuteFetch(  
    public static final String FETCH_ID_SCROLL_ACTION_NAME = "indices:data/read/search[phase/fetch/id/scroll]";
            (request, channel, task) -> {  
            QUERY_SCROLL_ACTION_NAME,
        );  
                    new ChannelActionListener<>(channel, FETCH_ID_ACTION_NAME, request)  
 * @opensearch.internal
            CREATE_READER_CONTEXT_ACTION_NAME,
            new ConnectionCountingHandler<>(listener, QuerySearchResult::new, clientConnections, connection.getNode().getId())
            UPDATE_READER_CONTEXT_ACTION_NAME,  
 */  
        final ShardFetchRequest request,
            connection,
            if (size > 0) {
            QUERY_FETCH_SCROLL_ACTION_NAME,
        );
     * Return a map of nodeId to pending number of search requests.
            connection,
        transportService.registerRequestHandler(
            (request, channel, task) -> {
            super(listener, responseReader);  
                    new ChannelActionListener<>(channel, QUERY_ACTION_NAME, request)
     */
            new ConnectionCountingHandler<>(listener, DfsSearchResult::new, clientConnections, connection.getNode().getId())
    public Map<String, Long> getPendingSearchRequests() {
import org.opensearch.transport.Transport;
        );
    }
import java.util.List;
    }
        TransportActionProxy.registerProxyAction(transportService, FETCH_ID_SCROLL_ACTION_NAME, FetchSearchResult::new);
            return originalIndices.indicesOptions();
    public static final String DFS_ACTION_NAME = "indices:data/read/search[phase/dfs]";
                );
            connection,
            request,
        ActionListener<UpdatePitContextResponse> actionListener
        );  
    public void sendExecuteScrollQuery(  
        public void writeTo(StreamOutput out) throws IOException {  
            }
 *  
        }  
     *
        );
        TransportActionProxy.registerProxyAction(transportService, FREE_CONTEXT_ACTION_NAME, SearchFreeContextResponse::new);
            assert assertNodePresent();  
            // Always return true, there is additional asserting here, the boolean is just so this
    final class ConnectionCountingHandler<Response extends TransportResponse> extends ActionListenerResponseHandler<Response> {
                searchService.updatePitIdAndKeepAlive(request, listener);  
            clientConnections.compute(nodeId, (id, conns) -> conns == null ? 1 : conns + 1);
 */  
     * @param clusterAlias the cluster alias the node should be resolved against  
    ) {
        transportService.sendChildRequest(  
    static class ScrollFreeContextRequest extends TransportRequest {
/*
    public void sendExecuteFetchScroll(  
import org.opensearch.search.SearchPhaseResult;  
    ) {  
            super(id);  
import org.opensearch.transport.TransportException;  
            request,  
        sendExecuteFetch(connection, FETCH_ID_ACTION_NAME, request, task, listener);  
            clientConnections.compute(nodeId, (id, conns) -> {
            ThreadPool.Names.SAME,  
            }
        TransportService transportService,  
        }
            InternalScrollSearchRequest::new,
        return transportService.getRemoteClusterService();
        transportService.sendRequest(
    private void sendExecuteFetch(  
            ThreadPool.Names.SAME,  
                request,
    /**  
            DFS_ACTION_NAME,  
            true,
            QUERY_CAN_MATCH_NAME,
        final SearchActionListener<QuerySearchResult> listener
                searchService.executeFetchPhase(  
                return conns;
        UpdatePitContextRequest request,
        );
            ThreadPool.Names.SAME,
            CLEAR_SCROLL_CONTEXTS_ACTION_NAME,  
                    // no need to respond if it was freed or not
    public static final String FREE_CONTEXT_SCROLL_ACTION_NAME = "indices:data/read/search[free_context/scroll]";  
        final ShardFetchSearchRequest request,
            if (originalIndices == null) {
            final Writeable.Reader<Response> responseReader,
                );
    public static final String FREE_PIT_CONTEXT_ACTION_NAME = "indices:data/read/search[free_context/pit]";  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
            }  
    }
                    new ChannelActionListener<>(channel, QUERY_ID_ACTION_NAME, request)
            transportService,  
        }  
        transportService.sendChildRequest(  
        );
            QUERY_ACTION_NAME,
            (in) -> TransportResponse.Empty.INSTANCE
        }  
        final SearchActionListener<ScrollQueryFetchSearchResult> listener
                return null;
    }  
            }  
            // Decrement the number of connections or remove it entirely if there are no more connections
            task,
                boolean freed = searchService.freeReaderContext(request.id());  
    }
    }
    }  
        SearchFreeContextResponse(boolean freed) {
        public ShardSearchContextId id() {
        @Override
            true,  
                    request,
import org.opensearch.cluster.node.DiscoveryNode;  
            TransportRequestOptions.EMPTY,
            int size = in.readVInt();  
                searchService.executeQueryPhase(  
import java.util.Objects;
    private final Map<String, Long> clientConnections = ConcurrentCollections.newConcurrentMapWithAggressiveConcurrency();  
import org.opensearch.threadpool.ThreadPool;
                    (SearchShardTask) task,  
        );  
import java.util.Map;  
        this.transportService = transportService;  
            this.clientConnections = clientConnections;
        transportService.sendChildRequest(
     * Returns a connection to the given node on the provided cluster. If the cluster alias is <code>null</code> the node will be resolved
     *
        ActionListener<TransportCreatePitAction.CreateReaderContextResponse> actionListener
            super.writeTo(out);
                    request,  
     * @opensearch.internal  
    private final TransportService transportService;
        return new HashMap<>(clientConnections);  
        );
            (request, channel, task) -> {
            new ConnectionCountingHandler<>(listener, ScrollQuerySearchResult::new, clientConnections, connection.getNode().getId())
                    ActionListener.wrap(
        final Transport.Connection connection = transportService.getConnection(transportService.getLocalNode());
            final ActionListener<? super Response> listener,
        private boolean assertNodePresent() {
            task,
                    request,
            new ConnectionCountingHandler<>(handler, reader, clientConnections, connection.getNode().getId())
            TransportRequest.Empty::new,
 * Modifications Copyright OpenSearch Contributors. See
    public void createPitContext(
            connection,
            ThreadPool.Names.SAME,
import org.opensearch.search.fetch.QueryFetchSearchResult;
        transportService.sendChildRequest(
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        TransportActionProxy.registerProxyAction(transportService, DFS_ACTION_NAME, DfsSearchResult::new);
    ) {  
                    new ChannelActionListener<>(channel, QUERY_SCROLL_ACTION_NAME, request)  
        Transport.Connection connection,  
    public void sendFreeContext(Transport.Connection connection, final ShardSearchContextId contextId, OriginalIndices originalIndices) {
    }
        }
            final Map<String, Long> clientConnections,  
        );  
                    );  
                    request,
    static class PitFreeContextsRequest extends TransportRequest {
    public static final String QUERY_ID_ACTION_NAME = "indices:data/read/search[phase/query/id]";
                    contextIds.add(contextId);
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
        Transport.Connection connection,
        Transport.Connection connection,
        );  
        Transport.Connection connection,
        transportService.registerRequestHandler(  
        }
        transportService.sendChildRequest(  
            (request, channel, task) -> {  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        );  
import org.opensearch.action.OriginalIndices;  
                return null;  
import org.opensearch.search.fetch.ShardFetchSearchRequest;
            (request, channel, task) -> {
    public RemoteClusterService getRemoteClusterService() {  
                for (int i = 0; i < size; i++) {  
 *
            connection,  
        );
        final SearchActionListener<FetchSearchResult> listener
import java.util.ArrayList;  
        transportService.registerRequestHandler(
        }  
            request,  
            new ConnectionCountingHandler<>(listener, MultiSearchResponse::new, clientConnections, connection.getNode().getId())
            }  
            new ActionListenerResponseHandler<>(actionListener, UpdatePitContextResponse::new)  
                );
        String action,
        );
import org.opensearch.core.transport.TransportResponse;
        SearchTask task,  
        public IndicesOptions indicesOptions() {  
            request,
            clientConnections.computeIfPresent(nodeId, (id, conns) -> conns.longValue() == 1 ? null : conns - 1);
import org.opensearch.search.fetch.FetchSearchResult;  
import org.opensearch.action.ActionListenerResponseHandler;
                    (SearchShardTask) task,
 * You may obtain a copy of the License at  
            ShardSearchRequest::new,
            ThreadPool.Names.SAME,
    public static final String FETCH_ID_ACTION_NAME = "indices:data/read/search[phase/fetch/id]";
            TransportRequestOptions.EMPTY,
            this.contextId = Objects.requireNonNull(contextId);  
    }
            new ConnectionCountingHandler<>(listener, FetchSearchResult::new, clientConnections, connection.getNode().getId())  
     */
        private final String nodeId;
    static class SearchFreeContextRequest extends ScrollFreeContextRequest implements IndicesRequest {
import org.opensearch.search.SearchService;
                new ChannelActionListener<>(channel, DFS_ACTION_NAME, request)
        final InternalScrollSearchRequest request,
        ActionListener<SearchFreeContextResponse> listener  
        );  
                    request
            connection,  
        }  
     * A scroll free context request
            (request, channel, task) -> {
            DFS_ACTION_NAME,
        Transport.Connection connection,
     */
    public static final String QUERY_ACTION_NAME = "indices:data/read/search[phase/query]";  
        SearchTask task,  
        ConnectionCountingHandler(  
        );  
        Transport.Connection connection,
import org.opensearch.transport.TransportService;  
        final boolean fetchDocuments = request.numberOfShards() == 1;
            originalIndices = OriginalIndices.readOriginalIndices(in);  
    /**  
            }
        transportService.registerRequestHandler(
        @Override
    }
        );  
        Transport.Connection connection,
    ) {
            TransportRequestOptions.EMPTY,
            freed = in.readBoolean();
            QUERY_ID_ACTION_NAME,
        final ShardSearchRequest request,
        ) {
                    request,
        transportService.sendChildRequest(  
        final SearchActionListener<FetchSearchResult> listener
    /**  
        Transport.Connection connection,
        TransportActionProxy.registerProxyAction(transportService, QUERY_CAN_MATCH_NAME, SearchService.CanMatchResponse::new);  
        TransportActionProxy.registerProxyAction(transportService, FREE_PIT_CONTEXT_ACTION_NAME, DeletePitResponse::new);
            out.writeBoolean(freed);
            QUERY_ACTION_NAME,
            task,
            TransportRequestOptions.EMPTY,  
        List<PitSearchContextIdForNode> contextIds,  
import org.opensearch.search.dfs.DfsSearchResult;
            connection,
            }
 *
     * Request to free the PIT context based on id  
        }  
                    UPDATE_READER_CONTEXT_ACTION_NAME,  
            new ActionListenerResponseHandler<>(new ActionListener<SearchFreeContextResponse>() {
            true,
import org.opensearch.transport.TransportRequestOptions;
            if (originalIndices == null) {
                searchService.freeAllScrollContexts();
            super(in);
                public void onFailure(Exception e) {
        transportService.sendChildRequest(  
    public void sendExecuteDfs(  
    ) {
            ShardFetchRequest::new,
    }
 * this work for additional information regarding copyright
        );  
        @Override  
            }  
            QUERY_CAN_MATCH_NAME,
            connection,  
     * @return a connection to the given node belonging to the cluster with the provided alias.
 */
        private final Map<String, Long> clientConnections;  
                    new ChannelActionListener<>(channel, QUERY_FETCH_SCROLL_ACTION_NAME, request)
            super.handleResponse(response);  
            QUERY_FETCH_SCROLL_ACTION_NAME,
            MultiSearchAction.NAME,
 * transport.  
            }
                public void onResponse(SearchFreeContextResponse response) {  
        );
        transportService.registerRequestHandler(
        public String[] indices() {
                searchService.executeQueryPhase(
            connection,
        final SearchActionListener<SearchPhaseResult> listener
            new ActionListenerResponseHandler<>(listener, (in) -> TransportResponse.Empty.INSTANCE)  
        SearchFreeContextRequest(OriginalIndices originalIndices, ShardSearchContextId id) {
            this.nodeId = nodeId;
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.Writeable;  
        public void handleResponse(Response response) {
 * software distributed under the License is distributed on an
}  
        transportService.registerRequestHandler(
import org.opensearch.search.query.QuerySearchResult;  
        }
     * This is a snapshot of the current pending search and not a live map.  
            }  
 * under the License.  
            }  
    /**
            TransportCreatePitAction.CreateReaderContextResponse::new
 * ownership. Elasticsearch licenses this file to you under  
            // Increment the number of connections for this node by one  
            ThreadPool.Names.SAME,
                        r -> listener.onResponse(new TransportCreatePitAction.CreateReaderContextResponse(r)),
        ShardSearchContextId contextId,
    }  
    public void updatePitContext(
            false,
    /**  
                boolean freed = searchService.freeReaderContext(request.id());  
        PitFreeContextsRequest(StreamInput in) throws IOException {
            )
                }
 * specific language governing permissions and limitations
        final SearchActionListener<DfsSearchResult> listener
        final ShardSearchRequest request,
        if (clusterAlias == null) {
    public static final String CREATE_READER_CONTEXT_ACTION_NAME = "indices:data/read/search[create_context]";
                    request,
import org.opensearch.search.query.ScrollQuerySearchResult;
                contextId.writeTo(out);  
import java.util.HashMap;
            PitFreeContextsRequest::new,  
            connection,
                    new ChannelActionListener<>(channel, FETCH_ID_SCROLL_ACTION_NAME, request)
            SearchFreeContextRequest::new,
            TransportRequestOptions.EMPTY,
        }
                        request
        public List<PitSearchContextIdForNode> getContextIds() {
import org.opensearch.search.internal.ShardSearchRequest;
/*  
        TransportActionProxy.registerProxyAction(
        }
    ) {
            request,  
    public void sendFreePITContexts(
    public static void registerRequestHandler(TransportService transportService, SearchService searchService) {  
        transportService.registerRequestHandler(  
            (request) -> ((ShardSearchRequest) request).numberOfShards() == 1 ? QueryFetchSearchResult::new : QuerySearchResult::new
    /**  
                );  
            TransportRequestOptions.EMPTY,  
            task,
    }
     */
            FREE_PIT_CONTEXT_ACTION_NAME,
                (SearchShardTask) task,  
            return originalIndices.indices();
        SearchTask task,  
            }, SearchFreeContextResponse::new)
            ShardSearchRequest::new,
        }
                    (SearchShardTask) task,
            return this.contextIds;
        final ActionListener handler = responseWrapper.apply(connection, listener);
                );
                    )
            new ConnectionCountingHandler<>(listener, ScrollQueryFetchSearchResult::new, clientConnections, connection.getNode().getId())
        TransportActionProxy.registerProxyAction(transportService, QUERY_FETCH_SCROLL_ACTION_NAME, ScrollQueryFetchSearchResult::new);  
    public static final String QUERY_CAN_MATCH_NAME = "indices:data/read/search[can_match]";  
        private List<PitSearchContextIdForNode> contextIds;  
            (request, channel, task) -> {
            return this.contextId;  
            ThreadPool.Names.SAME,  
    public static final String UPDATE_READER_CONTEXT_ACTION_NAME = "indices:data/read/search[update_context]";
                );
            AdmissionControlActionType.SEARCH,  
                }
 * Unless required by applicable law or agreed to in writing,
            CLEAR_SCROLL_CONTEXTS_ACTION_NAME,
        );  
import org.opensearch.action.support.ChannelActionListener;
        }
            ThreadPool.Names.SAME,  
        final SearchActionListener<FetchSearchResult> listener
            // We need to remove the entry here so we don't leak when nodes go away forever
            UPDATE_READER_CONTEXT_ACTION_NAME,  
    public static final String CLEAR_SCROLL_CONTEXTS_ACTION_NAME = "indices:data/read/search[clear_scroll_contexts]";
    ) {  
        Transport.Connection connection,  
            TransportRequestOptions.EMPTY,  
        public void handleException(TransportException e) {
import org.opensearch.search.internal.InternalScrollSearchRequest;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.Nullable;
            new ActionListenerResponseHandler<>(listener, DeletePitResponse::new)
                searchService.executeFetchPhase(
        );  
    public void sendCanMatch(
        this.responseWrapper = responseWrapper;
     * @opensearch.internal  
        SearchTask task,
            new ActionListenerResponseHandler<>(listener, SearchFreeContextResponse::new)
            CLEAR_SCROLL_CONTEXTS_ACTION_NAME,  
                        CREATE_READER_CONTEXT_ACTION_NAME,
    /**
        SearchTask task,
    public static final String FREE_CONTEXT_ACTION_NAME = "indices:data/read/search[free_context]";
                searchService.executeQueryPhase(  
            CREATE_READER_CONTEXT_ACTION_NAME,  
            true,  
                    PitSearchContextIdForNode contextId = new PitSearchContextIdForNode(in);
            super.writeTo(out);  
        );
import org.opensearch.search.internal.ShardSearchContextId;  
     * A search free context response
        SearchTask task,  
            new PitFreeContextsRequest(contextIds),  
            UpdatePitContextRequest::new,
            QUERY_ID_ACTION_NAME,  
                );
    }
                @Override
 * KIND, either express or implied.  See the License for the
            true,
        private OriginalIndices originalIndices;  
            ScrollFreeContextRequest::new,
            new ActionListenerResponseHandler<>(listener, SearchService.CanMatchResponse::new)
            new ActionListenerResponseHandler<>(actionListener, TransportCreatePitAction.CreateReaderContextResponse::new)
        ActionListener<DeletePitResponse> listener
    ) {
        Transport.Connection connection,
            TransportCreatePitAction.CreateReaderContextRequest::new,
        TransportActionProxy.registerProxyAction(
        public void writeTo(StreamOutput out) throws IOException {
     * Used by {@link TransportSearchAction} to send the expand queries (field collapsing).
        );
     * A search free context request
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
                channel.sendResponse(new SearchFreeContextResponse(freed));
        transportService.sendRequest(
            assert assertNodePresent();  
            QUERY_SCROLL_ACTION_NAME,
        transportService.sendChildRequest(
    public SearchTransportService(
        TransportActionProxy.registerProxyAction(transportService, QUERY_ID_ACTION_NAME, QuerySearchResult::new);
        Writeable.Reader<SearchPhaseResult> reader = fetchDocuments ? QueryFetchSearchResult::new : QuerySearchResult::new;  
        );  
        TransportActionProxy.registerProxyAction(transportService, QUERY_SCROLL_ACTION_NAME, ScrollQuerySearchResult::new);
        transportService.registerRequestHandler(
        final ShardSearchRequest request,
    public static final String FREE_ALL_PIT_CONTEXTS_ACTION_NAME = "indices:data/read/search[free_pit_contexts]";
                channel.sendResponse(searchService.freeReaderContextsIfFound(request.getContextIds()));
            }
/*  
        @Override
        );
            (request, channel, task) -> {  
                searchService.executeFetchPhase(
        PitFreeContextsRequest(List<PitSearchContextIdForNode> contextIds) {
            }
            InternalScrollSearchRequest::new,  
                    (SearchShardTask) task,
 * GitHub history for details.
        }
    ) {
        Transport.Connection connection,
                ChannelActionListener<  
            FREE_PIT_CONTEXT_ACTION_NAME,
    }
    }
 *
    void sendExecuteMultiSearch(final MultiSearchRequest request, SearchTask task, final ActionListener<MultiSearchResponse> listener) {
package org.opensearch.action.search;
        transportService.registerRequestHandler(
            connection,
            request,
        );
        );  
        ScrollFreeContextRequest(ShardSearchContextId contextId) {
        TransportActionProxy.registerProxyAction(transportService, UPDATE_READER_CONTEXT_ACTION_NAME, UpdatePitContextResponse::new);  
                    request.getKeepAlive(),  
        );
import org.opensearch.action.IndicesRequest;
            super.handleException(e);  
        final QuerySearchRequest request,
                    false,
        TransportActionProxy.registerProxyAction(transportService, FETCH_ID_ACTION_NAME, FetchSearchResult::new);
        @Override  
            // Decrement the number of connections or remove it entirely if there are no more connections
    }
            final String nodeId
            FETCH_ID_ACTION_NAME,
                searchService.createPitReaderContext(
    }
                    TransportCreatePitAction.CreateReaderContextResponse,
        SearchTask task,
            connection,
     */  
        transportService.registerRequestHandler(
import org.opensearch.action.support.IndicesOptions;
            (request, channel, task) -> {  
            new ScrollFreeContextRequest(contextId),
            request,
public class SearchTransportService {
            clientConnections.computeIfPresent(nodeId, (id, conns) -> conns.longValue() == 1 ? null : conns - 1);
            this.contextIds.addAll(contextIds);
    ) {
        SearchTask task,  
        ScrollFreeContextRequest(StreamInput in) throws IOException {  
                channel.sendResponse(new SearchFreeContextResponse(freed));
                        listener::onFailure  
    ) {
                assert conns >= 1 : "number of connections for " + id + " should be >= 1 but was " + conns;
        @Override  
        // we optimize this and expect a QueryFetchSearchResult if we only have a single shard in the search request  
                ChannelActionListener<UpdatePitContextResponse, UpdatePitContextRequest> listener = new ChannelActionListener<>(
 * license agreements. See the NOTICE file distributed with
/**
            QUERY_ACTION_NAME,
            false,
            connection,
 * this file be licensed under the Apache-2.0 license or a
        final InternalScrollSearchRequest request,
        private boolean freed;
        transportService.registerRequestHandler(
            });  
            ThreadPool.Names.SAME,
            new SearchFreeContextRequest(originalIndices, contextId),
    ) {
