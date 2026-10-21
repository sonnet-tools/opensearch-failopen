import java.io.IOException;
    ) {
 * @opensearch.internal
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
            false,
    }
        final ShardSearchRequest request,
                    response.cancel("Client error during search phase", e);
import org.opensearch.search.internal.ShardSearchContextId;
                    listener.onFailure(e);
                } catch (Exception e) {
            }
            }
            public void handleException(TransportException exp) {
package org.opensearch.action.search;
                    }
    }
            public String executor() {
    private final Logger logger = LogManager.getLogger(StreamSearchTransportService.class);
                } catch (Exception e) {
        transportService.sendChildRequest(
                    ThreadPool.Names.STREAM_SEARCH
import org.apache.logging.log4j.Logger;
            @Override
                ThreadPool.Names.STREAM_SEARCH
        final StreamSearchActionListener streamListener = (StreamSearchActionListener) listener;
        transportService.registerRequestHandler(
                        }
                try {
                    // if current result is null, that means the previous result is the last result
            true,
            ThreadPool.Names.SAME,
                    // Keep reading results until we reach the end
            public SearchFreeContextResponse read(StreamInput in) throws IOException {
                    response.close();
    }
            }
            @Override
            public String executor() {
import org.opensearch.transport.StreamTransportService;
}
                listener.onFailure(exp);
        this.transportService = transportService;
                listener.onFailure(exp);
            ThreadPool.Names.SAME,
                    response.close();
        false,
                    response.close();
                } catch (Exception e) {
                    response.close();
    ) {
                    response.nextResponse();
            }
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
            }
        BiFunction<Transport.Connection, SearchActionListener, ActionListener> responseWrapper
            )
                }
            task,
            public void handleStreamResponse(StreamTransportResponse<SearchService.CanMatchResponse> response) {
                    response.cancel("Client error during search phase", e);
import org.opensearch.threadpool.ThreadPool;
            new SearchFreeContextRequest(originalIndices, contextId),
                        logger.debug("Processed final stream response");
    public void sendExecuteQuery(
            }
        super(transportService, responseWrapper);
            ThreadPool.Names.SAME,
            @Override
        transportService.sendChildRequest(
                    // only send previous result if we have a current result
            }
            (request, channel, task) -> {
            true,
import org.apache.logging.log4j.LogManager;
        );
            public void handleStreamResponse(StreamTransportResponse<DfsSearchResult> response) {
            }
                    ThreadPool.Names.STREAM_SEARCH,
                request,
            }
        final boolean fetchDocuments = request.numberOfShards() == 1;
            @Override
            public void handleException(TransportException e) {
            public SearchPhaseResult read(StreamInput in) throws IOException {
            }
            }
                    response.cancel("Client error during can match", e);
                    listener.onResponse(result);
import org.opensearch.transport.Transport;
            }
        );
                        logger.error("Empty stream");
import org.opensearch.search.fetch.ShardFetchSearchRequest;
        transportService.sendRequest(
        );
        };
            }
                    request,
                searchService.executeQueryPhase(
            AdmissionControlActionType.SEARCH,
            @Override
import org.opensearch.search.fetch.FetchSearchResult;
            @Override
            }
        SearchActionListener<SearchPhaseResult> listener
        transportService.sendChildRequest(connection, FETCH_ID_ACTION_NAME, request, task, transportHandler);
        Setting.Property.NodeScope
        transportService.sendChildRequest(
                return reader.read(in);
                try {
import org.opensearch.transport.TransportRequestOptions;
                listener.onFailure(e);
                        // Empty stream case
    public static final Setting<Boolean> STREAM_SEARCH_ENABLED = Setting.boolSetting(
            DFS_ACTION_NAME,
        final ShardSearchRequest request,
import org.opensearch.search.query.QuerySearchResult;
    private final StreamTransportService transportService;
    public void sendExecuteFetch(
            @Override
 * SPDX-License-Identifier: Apache-2.0
            transportHandler
                    SearchService.CanMatchResponse result = response.nextResponse();
import org.opensearch.action.OriginalIndices;
        SearchTask task,
            ShardFetchSearchRequest::new,
                    DfsSearchResult result = response.nextResponse();
            SearchFreeContextRequest::new,
        Transport.Connection connection,
            FETCH_ID_ACTION_NAME,
                    new StreamSearchChannelListener<>(channel, QUERY_ACTION_NAME, request),
        StreamTransportResponseHandler<SearchFreeContextResponse> transportHandler = new StreamTransportResponseHandler<>() {
 */
            }
                    // Send the final result as complete response, or null if no results
        final SearchActionListener<DfsSearchResult> listener
            AdmissionControlActionType.SEARCH,
            false,
                        lastResult = currentResult;
            transportHandler // TODO: wrap with ConnectionCountingHandler
        StreamTransportService transportService,
        Transport.Connection connection,
        };
    ) {
        StreamTransportResponseHandler<SearchPhaseResult> transportHandler = new StreamTransportResponseHandler<SearchPhaseResult>() {
        SearchTask task,
    ) {
                    (SearchShardTask) task,
            public void handleStreamResponse(StreamTransportResponse<SearchPhaseResult> response) {
        final ActionListener<SearchService.CanMatchResponse> listener
            transportHandler
            @Override
            FREE_CONTEXT_ACTION_NAME,
            AdmissionControlActionType.SEARCH,
            public void handleStreamResponse(StreamTransportResponse<SearchFreeContextResponse> response) {
                (SearchShardTask) task,
                    request,
 * The OpenSearch Contributors require contributions made to
                return new SearchService.CanMatchResponse(in);
        final SearchActionListener<FetchSearchResult> listener
            public void handleException(TransportException exp) {
        );
        StreamTransportResponseHandler<SearchService.CanMatchResponse> transportHandler = new StreamTransportResponseHandler<
                return ThreadPool.Names.SAME;
                    }
                return new FetchSearchResult(in);
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
    @Override
                } catch (Exception e) {
                channel.sendResponseBatch(new SearchFreeContextResponse(freed));
            true,
            (request, channel, task) -> {
            @Override
            (request, channel, task) -> {
            ShardSearchRequest::new,
            }
                    SearchPhaseResult currentResult;
            }
            DFS_ACTION_NAME,
                }
import org.opensearch.search.SearchPhaseResult;
        };
import org.opensearch.core.common.io.stream.Writeable;
                    listener.onResponse(result);
                return ThreadPool.Names.STREAM_SEARCH;
                return ThreadPool.Names.STREAM_SEARCH;
                }
        StreamTransportResponseHandler<FetchSearchResult> transportHandler = new StreamTransportResponseHandler<FetchSearchResult>() {
            QUERY_ACTION_NAME,
                    true
                    listener.onFailure(e);
                        throw new IllegalStateException("Only one response expected from SearchService.CanMatchResponse");
        transportService.registerRequestHandler(
    public void sendExecuteDfs(
                    response.close();
                    if (lastResult != null) {
        );
        SearchTask task,
        Transport.Connection connection,
    public StreamSearchTransportService(
                } catch (Exception ignore) {
 *
            @Override
            connection,
            QUERY_CAN_MATCH_NAME,
        Setting.Property.Dynamic,
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
            }
            @Override
                channel.completeStream();
            connection,
            @Override
        SearchTask task,
            public String executor() {
            public SearchService.CanMatchResponse read(StreamInput in) throws IOException {
            (request, channel, task) -> searchService.executeDfsPhase(
            connection,
        transportService.registerRequestHandler(
    ) {
            public void handleStreamResponse(StreamTransportResponse<FetchSearchResult> response) {
        );
            public String executor() {
            QUERY_ACTION_NAME,
            }
                false,
            }
            transportHandler
        );
 * compatible open source license.
            @Override
        transportService.registerRequestHandler(
    @Override
    }
                listener.onFailure(e);
            }
        final ShardSearchRequest request,
import org.opensearch.search.fetch.QueryFetchSearchResult;
/*
                        if (lastResult != null) {
                    while ((currentResult = response.nextResponse()) != null) {
                try {
                return new SearchFreeContextResponse(in);
 */
            FREE_CONTEXT_ACTION_NAME,
            connection,
public class StreamSearchTransportService extends SearchTransportService {
        );
            true,
    public void sendFreeContext(Transport.Connection connection, final ShardSearchContextId contextId, OriginalIndices originalIndices) {
            task,
            ThreadPool.Names.SAME,
            }
                }
 *
        Transport.Connection connection,
                    }
    public void sendCanMatch(
        Writeable.Reader<SearchPhaseResult> reader = fetchDocuments ? QueryFetchSearchResult::new : QuerySearchResult::new;
import org.opensearch.search.internal.ShardSearchRequest;
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
                    listener.onResponse(result);
            @Override
    @Override
import org.opensearch.search.dfs.DfsSearchResult;
                return ThreadPool.Names.SAME;
        };
            request,
 * Search transport service for streaming search
                }
                try {
            public String executor() {
    public static void registerStreamRequestHandler(StreamTransportService transportService, SearchService searchService) {
import org.opensearch.common.settings.Setting;
import java.util.function.BiFunction;
            @Override
                searchService.canMatch(request, new StreamSearchChannelListener<>(channel, QUERY_CAN_MATCH_NAME, request));
                    new StreamSearchChannelListener<>(channel, FETCH_ID_ACTION_NAME, request),
                        streamListener.onStreamResponse(lastResult, true);
                new StreamSearchChannelListener<>(channel, DFS_ACTION_NAME, request),
            @Override
                    FetchSearchResult result = response.nextResponse();
/**
                    SearchPhaseResult lastResult = null;
                return new DfsSearchResult(in);
                    false,
                try {
    );
                );
        transportService.registerRequestHandler(
            }
        StreamTransportResponseHandler<DfsSearchResult> transportHandler = new StreamTransportResponseHandler<>() {
            (request, channel, task) -> {
            task,
            @Override
                );
            request,
 * this file be licensed under the Apache-2.0 license or a
                    streamListener.onFailure(e);
import org.opensearch.transport.TransportException;
                    if (response.nextResponse() != null) {
import org.opensearch.transport.stream.StreamTransportResponse;
            QUERY_CAN_MATCH_NAME,
    @Override
            request,
import org.opensearch.search.SearchService;
            SearchService.CanMatchResponse>() {
                boolean freed = searchService.freeReaderContext(request.id());
                    } else {
            public void handleException(TransportException exp) {
                searchService.executeFetchPhase(
import org.opensearch.transport.StreamTransportResponseHandler;
            public void handleException(TransportException e) {
    }
        "stream.search.enabled",
    }
        };
            ThreadPool.Names.SAME,
    }
                    (SearchShardTask) task,
import org.opensearch.action.support.StreamSearchChannelListener;
        final ShardFetchSearchRequest request,
            @Override
            public DfsSearchResult read(StreamInput in) throws IOException {
                            streamListener.onStreamResponse(lastResult, false);
import org.opensearch.core.action.ActionListener;
            ShardSearchRequest::new,
            ShardSearchRequest::new,
            }
            @Override
                    listener.onFailure(e);
        );
            public FetchSearchResult read(StreamInput in) throws IOException {
            @Override
                return ThreadPool.Names.STREAM_SEARCH;
                    response.cancel("Client error during fetch phase", e);
