                } catch (Exception e) {
/*  
                        throw new IllegalStateException("Only one response expected from SearchService.CanMatchResponse");  
            (request, channel, task) -> {  
        };
import org.opensearch.action.OriginalIndices;  
            ThreadPool.Names.SAME,
        );
import org.opensearch.core.common.io.stream.StreamInput;
    }
import org.opensearch.core.action.ActionListener;  
        StreamTransportResponseHandler<DfsSearchResult> transportHandler = new StreamTransportResponseHandler<>() {
        final boolean fetchDocuments = request.numberOfShards() == 1;
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
    public void sendFreeContext(Transport.Connection connection, final ShardSearchContextId contextId, OriginalIndices originalIndices) {
            false,
            FREE_CONTEXT_ACTION_NAME,  
            @Override
            QUERY_CAN_MATCH_NAME,
                        streamListener.onStreamResponse(lastResult, true);  
                    // Keep reading results until we reach the end
    }
 * The OpenSearch Contributors require contributions made to  
            request,
/**  
                    // only send previous result if we have a current result  
        transportService.sendChildRequest(
            ThreadPool.Names.SAME,
            transportHandler // TODO: wrap with ConnectionCountingHandler
            connection,  
import org.opensearch.search.fetch.FetchSearchResult;
            @Override
    public static void registerStreamRequestHandler(StreamTransportService transportService, SearchService searchService) {
                    true
            }
            true,
            transportHandler  
        transportService.sendChildRequest(
    public static final Setting<Boolean> STREAM_SEARCH_ENABLED = Setting.boolSetting(  
            @Override  
import org.opensearch.search.dfs.DfsSearchResult;  
 *
            public String executor() {
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;  
                }
                );
                            streamListener.onStreamResponse(lastResult, false);
            SearchFreeContextRequest::new,
            public void handleException(TransportException e) {
import java.io.IOException;  
                } catch (Exception e) {
                searchService.executeQueryPhase(
        );  
 * compatible open source license.
        Writeable.Reader<SearchPhaseResult> reader = fetchDocuments ? QueryFetchSearchResult::new : QuerySearchResult::new;
        transportService.registerRequestHandler(
    ) {
                return reader.read(in);
            @Override  
        transportService.registerRequestHandler(
                        logger.error("Empty stream");
import org.opensearch.search.fetch.ShardFetchSearchRequest;  
                return ThreadPool.Names.SAME;
        };  
                channel.completeStream();  
    }  
                    }
                    if (response.nextResponse() != null) {
                listener.onFailure(exp);  
            ThreadPool.Names.SAME,
import org.opensearch.core.common.io.stream.Writeable;
                    response.close();  
                    FetchSearchResult result = response.nextResponse();
            }
        StreamTransportResponseHandler<SearchPhaseResult> transportHandler = new StreamTransportResponseHandler<SearchPhaseResult>() {
import org.apache.logging.log4j.Logger;
            @Override  
                    (SearchShardTask) task,  
            }
                    SearchPhaseResult currentResult;
}
import org.opensearch.action.support.StreamSearchChannelListener;
                try {  
        );
import org.opensearch.transport.Transport;
            }  
            @Override
            public String executor() {
        final ShardSearchRequest request,
            }  
        SearchTask task,  
                false,
            }
                return ThreadPool.Names.SAME;
            }
                    response.cancel("Client error during search phase", e);
            ShardFetchSearchRequest::new,
    public void sendCanMatch(
                return new SearchFreeContextResponse(in);
                listener.onFailure(e);
import org.opensearch.search.SearchPhaseResult;
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),  
                }
            @Override  
            public void handleException(TransportException exp) {
        this.transportService = transportService;  
            )
            }
            DFS_ACTION_NAME,  
            AdmissionControlActionType.SEARCH,
    ) {
                    request,
            public void handleException(TransportException exp) {
            ThreadPool.Names.SAME,  
            public void handleStreamResponse(StreamTransportResponse<FetchSearchResult> response) {
            }  
                }  
    ) {
                (SearchShardTask) task,
            @Override
        StreamTransportResponseHandler<SearchFreeContextResponse> transportHandler = new StreamTransportResponseHandler<>() {
                    listener.onFailure(e);  
            public SearchFreeContextResponse read(StreamInput in) throws IOException {  
            public FetchSearchResult read(StreamInput in) throws IOException {  
        false,
            }
        };  
    @Override
        };  
                boolean freed = searchService.freeReaderContext(request.id());
 */  
        BiFunction<Transport.Connection, SearchActionListener, ActionListener> responseWrapper  
            transportHandler
            public void handleStreamResponse(StreamTransportResponse<DfsSearchResult> response) {
            false,
            @Override
            public void handleException(TransportException e) {
            FREE_CONTEXT_ACTION_NAME,  
        final SearchActionListener<DfsSearchResult> listener  
            connection,  
            @Override  
    );
                        // Empty stream case  
            true,
 *
            QUERY_CAN_MATCH_NAME,
            public void handleException(TransportException exp) {
            task,
            @Override
import org.opensearch.search.SearchService;
        Transport.Connection connection,  
import org.apache.logging.log4j.LogManager;
            @Override
        );
                    response.cancel("Client error during fetch phase", e);
            }
                return new FetchSearchResult(in);
import org.opensearch.search.internal.ShardSearchRequest;
 * SPDX-License-Identifier: Apache-2.0
            }
            @Override
            public void handleStreamResponse(StreamTransportResponse<SearchService.CanMatchResponse> response) {
            task,  
    public void sendExecuteFetch(  
            true,  
        SearchActionListener<SearchPhaseResult> listener
        final ShardSearchRequest request,
            public DfsSearchResult read(StreamInput in) throws IOException {
        transportService.registerRequestHandler(
            request,
package org.opensearch.action.search;
            DFS_ACTION_NAME,
        final SearchActionListener<FetchSearchResult> listener
    @Override  
import org.opensearch.threadpool.ThreadPool;
                    listener.onFailure(e);  
                return ThreadPool.Names.STREAM_SEARCH;
                    DfsSearchResult result = response.nextResponse();  
public class StreamSearchTransportService extends SearchTransportService {
import org.opensearch.search.internal.ShardSearchContextId;
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).build(),
                searchService.executeFetchPhase(
                return ThreadPool.Names.STREAM_SEARCH;
                    new StreamSearchChannelListener<>(channel, FETCH_ID_ACTION_NAME, request),
            (request, channel, task) -> {  
                try {  
                    } else {
            public SearchPhaseResult read(StreamInput in) throws IOException {  
                    request,
        final ShardSearchRequest request,  
            }  
                    if (lastResult != null) {
            }
import org.opensearch.search.fetch.QueryFetchSearchResult;
            transportHandler
        Transport.Connection connection,
    ) {  
        transportService.sendRequest(
import org.opensearch.transport.TransportException;
    ) {
                    ThreadPool.Names.STREAM_SEARCH
            @Override  
            @Override  
                try {
            QUERY_ACTION_NAME,
                    listener.onResponse(result);
        );  
                    response.cancel("Client error during search phase", e);
        );
            }
import java.util.function.BiFunction;
                searchService.canMatch(request, new StreamSearchChannelListener<>(channel, QUERY_CAN_MATCH_NAME, request));
import org.opensearch.common.settings.Setting;
                    new StreamSearchChannelListener<>(channel, QUERY_ACTION_NAME, request),
            public void handleStreamResponse(StreamTransportResponse<SearchPhaseResult> response) {
    }  
            (request, channel, task) -> {  
                    response.cancel("Client error during can match", e);
                    (SearchShardTask) task,
            public String executor() {
                request,  
        transportService.registerRequestHandler(  
                        if (lastResult != null) {
            @Override
        SearchTask task,
        );
            AdmissionControlActionType.SEARCH,
            public void handleStreamResponse(StreamTransportResponse<SearchFreeContextResponse> response) {
    public StreamSearchTransportService(
        SearchTask task,
        );
                        logger.debug("Processed final stream response");
        StreamTransportResponseHandler<FetchSearchResult> transportHandler = new StreamTransportResponseHandler<FetchSearchResult>() {  
 * @opensearch.internal  
        final ShardFetchSearchRequest request,
        Setting.Property.Dynamic,  
import org.opensearch.transport.StreamTransportService;  
                new StreamSearchChannelListener<>(channel, DFS_ACTION_NAME, request),  
                    response.close();
 * this file be licensed under the Apache-2.0 license or a
            connection,
            }  
                    response.close();  
                } catch (Exception e) {
                        }  
 * Search transport service for streaming search
    }
            connection,
            @Override
            @Override
                    }
            request,
    }
            QUERY_ACTION_NAME,  
            (request, channel, task) -> searchService.executeDfsPhase(
 */
        Transport.Connection connection,
        super(transportService, responseWrapper);
                return ThreadPool.Names.STREAM_SEARCH;
            ShardSearchRequest::new,
                    streamListener.onFailure(e);  
import org.opensearch.transport.stream.StreamTransportResponse;
                ThreadPool.Names.STREAM_SEARCH
        StreamTransportResponseHandler<SearchService.CanMatchResponse> transportHandler = new StreamTransportResponseHandler<
                try {
    @Override  
                try {
    public void sendExecuteDfs(
            SearchService.CanMatchResponse>() {  
import org.opensearch.search.query.QuerySearchResult;  
                    listener.onResponse(result);
                    response.close();  
                    listener.onFailure(e);
                        lastResult = currentResult;
                listener.onFailure(e);  
        SearchTask task,
import org.opensearch.transport.StreamTransportResponseHandler;
                    response.nextResponse();  
                } catch (Exception e) {  
                );  
        };  
        final StreamSearchActionListener streamListener = (StreamSearchActionListener) listener;
    private final Logger logger = LogManager.getLogger(StreamSearchTransportService.class);  
                listener.onFailure(exp);  
            new SearchFreeContextRequest(originalIndices, contextId),
        );
            }  
            }
            true,  
            ShardSearchRequest::new,
            ShardSearchRequest::new,  
        transportService.sendChildRequest(
            }
        Setting.Property.NodeScope
                }
    @Override
                    response.close();
                channel.sendResponseBatch(new SearchFreeContextResponse(freed));
            AdmissionControlActionType.SEARCH,  
            }
        Transport.Connection connection,  
            ThreadPool.Names.SAME,
        final ActionListener<SearchService.CanMatchResponse> listener  
                return new DfsSearchResult(in);  
                    }
                    // if current result is null, that means the previous result is the last result
            }  
import org.opensearch.transport.TransportRequestOptions;  
        transportService.sendChildRequest(connection, FETCH_ID_ACTION_NAME, request, task, transportHandler);
        "stream.search.enabled",
            FETCH_ID_ACTION_NAME,  
                    SearchPhaseResult lastResult = null;  
            }
                    false,  
            }
            @Override  
            @Override
    private final StreamTransportService transportService;
                }
    public void sendExecuteQuery(
            (request, channel, task) -> {
        StreamTransportService transportService,
                    // Send the final result as complete response, or null if no results
                    listener.onResponse(result);
        transportService.registerRequestHandler(
                } catch (Exception ignore) {
                    SearchService.CanMatchResponse result = response.nextResponse();
            public String executor() {
    @Override
            task,  
            }
            public SearchService.CanMatchResponse read(StreamInput in) throws IOException {  
                    while ((currentResult = response.nextResponse()) != null) {  
    }
                return new SearchService.CanMatchResponse(in);
            public String executor() {  
                    ThreadPool.Names.STREAM_SEARCH,  
