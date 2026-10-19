    public StreamTransportSearchAction(  
        SearchRequestOperationsCompositeListenerFactory searchRequestOperationsCompositeListenerFactory,
import org.opensearch.transport.Transport;  
        WorkloadGroupService workloadGroupService  
        Executor executor,  
                        searchRequest,
            metricsRegistry,  
        SearchPipelineService searchPipelineService,  
    ) {
        SearchService searchService,
            actionFilters,
 */  
            indexNameExpressionResolver,  
import org.opensearch.cluster.routing.GroupShardsIterator;
    @Inject
                executor,  
            tracer,
 * The OpenSearch Contributors require contributions made to  
            threadPool,
        SearchRequest searchRequest,
import java.util.Set;
        ClusterService clusterService,
            AbstractSearchAsyncAction<? extends SearchPhaseResult> searchAsyncAction;
import org.opensearch.common.Nullable;  
                    searchAsyncAction = new StreamSearchQueryThenFetchAsyncAction(
        IndexNameExpressionResolver indexNameExpressionResolver,
                        searchPhaseController,
 * SPDX-License-Identifier: Apache-2.0
/**  
        GroupShardsIterator<SearchShardIterator> shardIterators,
        NamedWriteableRegistry namedWriteableRegistry,
            indicesService,
            searchPipelineService,
                task.getProgressListener(),
        super(
import java.util.concurrent.Executor;  
import org.opensearch.action.support.ActionFilters;
public class StreamTransportSearchAction extends TransportSearchAction {
        @Nullable StreamTransportService transportService,
import org.opensearch.search.SearchPhaseResult;  
        ActionListener<SearchResponse> listener,
        } else {
        ActionFilters actionFilters,  
                        queryResultConsumer,
        if (preFilter) {
        Tracer tracer,  
import org.opensearch.search.SearchService;
import org.opensearch.search.pipeline.SearchPipelineService;  
            searchPhaseController,  
        Map<String, Float> concreteIndexBoosts,  
import java.util.function.BiFunction;
import org.opensearch.cluster.service.ClusterService;
                        timeProvider,
            final QueryPhaseResultConsumer queryResultConsumer = searchPhaseController.newStreamSearchPhaseResults(
                        listener,  
    ) {
                        searchRequestContext,  
                        clusterState,  
 */  
                        connectionLookup,
        SearchResponse.Clusters clusters,
                        searchTransportService,  
                default:
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    AbstractSearchAsyncAction<? extends SearchPhaseResult> searchAsyncAction(  
        SearchRequestContext searchRequestContext  
            client,  
    }
                        tracer
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.inject.Inject;
                case QUERY_THEN_FETCH:  
 * Transport search action for streaming search
                        aliasFilter,
        ThreadPool threadPool,
            searchRequestOperationsCompositeListenerFactory,
            }  
                    throw new IllegalStateException("Unknown search type: [" + searchRequest.searchType() + "]");
                searchRequest,  
                        shardIterators,
            searchTransportService,
import org.opensearch.tasks.TaskResourceTrackingService;
import org.opensearch.telemetry.metrics.MetricsRegistry;
import org.opensearch.transport.StreamTransportService;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            transportService,  
import java.util.Map;
                shardIterators.size(),
        }
import org.opensearch.cluster.ClusterState;
            searchService,
                        indexRoutings,
        boolean preFilter,  
            workloadGroupService
                circuitBreaker,
 *
        SearchTask task,
                        concreteIndexBoosts,  
            switch (searchRequest.searchType()) {
                        executor,  
        CircuitBreakerService circuitBreakerService,  
        SearchTimeProvider timeProvider,
        Map<String, Set<String>> indexRoutings,
}
            clusterService,
    }  
                    );
import org.opensearch.wlm.WorkloadGroupService;
package org.opensearch.action.search;
            );  
        Map<String, AliasFilter> aliasFilter,
        NodeClient client,
/*  
import org.opensearch.indices.IndicesService;
                exc -> cancelTask(task, exc)
            circuitBreakerService,
 * @opensearch.internal
        TaskResourceTrackingService taskResourceTrackingService,
import org.opensearch.transport.client.node.NodeClient;
                        task,
        MetricsRegistry metricsRegistry,
            namedWriteableRegistry,
import org.opensearch.core.action.ActionListener;
            throw new IllegalStateException("Search pre-filter is not supported in streaming");  
        BiFunction<String, String, Transport.Connection> connectionLookup,  
                        logger,
            taskResourceTrackingService,  
import org.opensearch.telemetry.tracing.Tracer;  
        ClusterState clusterState,
        IndicesService indicesService,
import org.opensearch.search.internal.AliasFilter;
        ThreadPool threadPool,
        SearchPhaseController searchPhaseController,
        @Nullable StreamSearchTransportService searchTransportService,  
            return searchAsyncAction;
                        clusters,
        );  
 * compatible open source license.
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import org.opensearch.threadpool.ThreadPool;
                    break;  
