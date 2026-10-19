 *
            final ClusterState state = clusterService.state();  
     * @param executor analytics engine plan executor  
                indexMetadata = indexResolutionStrategy.resolve(indexNameExpressionResolver, state, request).get(0);  
/**
}  
    private static final Logger logger = LogManager.getLogger(TransportExecuteAction.class);
import org.opensearch.dsl.result.ExecutionResult;  
public class TransportExecuteAction extends HandledTransportAction<SearchRequest, SearchResponse> {  
        try {  
    @Override  
            } catch (ConversionException e) {
                // The request carries a shape or parameter this path cannot honor — a client
        SearchSourceConverter converter,  
    /**  
     * call, joins all results, and responds through
        threadPool.executor(ThreadPool.Names.SEARCH).execute(() -> {
    }
 * executes them via the analytics engine, and builds a SearchResponse.
        final SearchResponse response;
            );
        if (countPlans.isEmpty()) {
            try {
            buildAndRespond(allResults, request, converter, startNanos, listener);
            try {
import org.opensearch.cluster.metadata.IndexMetadata;  
            for (List<ExecutionResult> branch : collections) {
            } catch (Exception e) {
                listener.onFailure(e);
        }
package org.opensearch.dsl.action;
                allResults.addAll(branch);
        for (QueryPlans.QueryPlan plan : plans.getAll()) {  
            // snapshot for conversion and response building, created lazily, and closed when
                listener.onFailure(e);
        try {
        QueryPlanExecutor<RelNode, Iterable<Object[]>> executor,  
        SearchRequest request,
import org.opensearch.tasks.Task;  
        });  
        this.planExecutor = new DslQueryPlanExecutor(executor);
import org.opensearch.cluster.ClusterState;
    protected void doExecute(Task task, SearchRequest request, ActionListener<SearchResponse> listener) {
import org.opensearch.action.support.HandledTransportAction;
import org.opensearch.cluster.service.ClusterService;
            } catch (Exception e) {
            final long startNanos = System.nanoTime();  
import org.opensearch.analytics.exec.QueryPlanExecutor;
                );  
    private void buildAndRespond(
            final IndexMetadata indexMetadata;
        }
        this.indexNameExpressionResolver = indexNameExpressionResolver;
        SearchRequest request,  
    private final ClusterService clusterService;  
                plans = converter.convert(request.source(), indexName);  
        } catch (Exception buildEx) {  
                planExecutor.execute(new QueryPlans.Builder().add(countPlan).build(), joined);  
        }
import org.apache.logging.log4j.Logger;  
     * Any branch failing fails the request.
        QueryPlans.Builder mainBuilder = new QueryPlans.Builder();
import org.opensearch.dsl.executor.DslQueryPlanExecutor;
import org.opensearch.dsl.converter.SearchSourceConverter;  
            } catch (Exception e) {
import org.opensearch.dsl.executor.QueryPlans;
                joined.onFailure(e);
import org.opensearch.dsl.result.SearchResponseBuilder;
import org.opensearch.action.search.SearchResponse;
    @Inject
                planExecutor.execute(  
        }
        listener.onResponse(response);
     * @param actionFilters action filters
        final GroupedActionListener<List<ExecutionResult>> joined = new GroupedActionListener<>(ActionListener.wrap(collections -> {
    }
        List<QueryPlans.QueryPlan> countPlans = plans.get(QueryPlans.Type.COUNT);
                return;  
            return;
        ActionListener<SearchResponse> listener  
        SearchSourceConverter converter,
            final ActionListener<SearchResponse> requestListener = ActionListener.runAfter(listener, mapperServiceHolder::close);  
        for (QueryPlans.QueryPlan countPlan : countPlans) {
            final QueryPlans plans;
        EngineContextProvider contextProvider,
        QueryPlans plans,
            // typing all derive from the same immutable cluster state.
            if (plan.type() != QueryPlans.Type.COUNT) {
 * <p>Receives {@link QueryPlanExecutor} and {@link EngineContextProvider} from the analytics engine  
import java.util.ArrayList;
        this.clusterService = clusterService;  
    private final ThreadPool threadPool;
            // TODO: cache per (indexUUID, mappingVersion) to avoid rebuilding analyzers.
    }
    ) {  
            }
import java.util.concurrent.TimeUnit;  
        super(ExecuteAction.NAME, transportService, actionFilters, SearchRequest::new);  
            List<ExecutionResult> allResults = new ArrayList<>();  
                logger.debug("DSL conversion rejected the request", e);
    private final DslQueryPlanExecutor planExecutor;
import org.apache.logging.log4j.LogManager;
        ActionListener<SearchResponse> listener
    private final EngineContextProvider contextProvider;
        List<ExecutionResult> results,
        // COUNT plans run concurrently with the main plans - all are engine calls.
        } catch (Exception e) {  
            }
            final RequestScopedMapperService mapperServiceHolder = new RequestScopedMapperService(
        long startNanos,
 * Coordinates DSL query execution: converts SearchSourceBuilder to Calcite RelNode plans,  
import org.opensearch.action.search.SearchRequest;
    private final IndicesService indicesService;
        ActionFilters actionFilters,
            }  
 *
            response = SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), tookInMillis);
     *
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.indices.IndicesService;
                mainBuilder.add(plan);
        ThreadPool threadPool
        this.threadPool = threadPool;  
import org.opensearch.action.support.ActionFilters;  
        IndexNameExpressionResolver indexNameExpressionResolver,  
            listener.onFailure(buildEx);
    }
                    ActionListener.wrap(results -> buildAndRespond(results, request, converter, startNanos, listener), listener::onFailure)
 * via Guice injection (enabled by {@code extendedPlugins = ['analytics-engine']}).
     */  
            }  
            executePlans(plans, request, converter, startNanos, requestListener);
     * @param clusterService cluster service for resolving index aliases
            // Response typing works off the mapping pinned at request start: one immutable
    ) {
     * {@link #buildAndRespond(List, SearchRequest, SearchSourceConverter, long, ActionListener)}.  
import java.util.List;
import org.opensearch.analytics.EngineContextProvider;  
            joined.onFailure(e);
            // the request completes whether it succeeded or failed.  
            } catch (Exception e) {
 */
     * Submits the main plans as one batch and each COUNT plan as its own concurrent engine
    /**  
                requestListener.onFailure(new IllegalArgumentException(e.getMessage(), e));
            // One snapshot per request: index resolution, the engine schema, and response
        long startNanos,
            try {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionListener;
 * SPDX-License-Identifier: Apache-2.0
            }  
        TransportService transportService,  
    private final IndexNameExpressionResolver indexNameExpressionResolver;
        ClusterService clusterService,
     * @param transportService transport service  
     * @param contextProvider analytics engine context providing schema and operator table
        }  
    private void executePlans(  
                    mainPlans,
            try {
                requestListener.onFailure(e);
     * @param indexNameExpressionResolver resolves aliases and wildcards to concrete indices
    public TransportExecuteAction(
            planExecutor.execute(mainPlans, joined);
            }  
 * The OpenSearch Contributors require contributions made to  
                // error (400), matching classic search's rejection of unsupported parameters.  
import org.opensearch.common.inject.Inject;  
import org.opensearch.action.support.GroupedActionListener;
        final QueryPlans mainPlans = mainBuilder.build();
        }, listener::onFailure), 1 + countPlans.size());
 */  
            final SearchSourceConverter converter;  
     * Guice-injected constructor — receives analytics engine dependencies.
                return;  
    private final IndexResolutionStrategy indexResolutionStrategy = new SingleIndexResolutionStrategy();  
                indexMetadata,  
            final String indexName = indexMetadata.getIndex().getName();
                indicesService::createIndexMapperService
import org.opensearch.dsl.converter.ConversionException;
import org.apache.calcite.rel.RelNode;
            long tookInMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
            return;
 * compatible open source license.
import org.opensearch.transport.TransportService;
    ) {
/*  
                return;  
        this.indicesService = indicesService;
     */
        IndicesService indicesService,
        this.contextProvider = contextProvider;
import org.opensearch.threadpool.ThreadPool;
                converter = new SearchSourceConverter(contextProvider.getContext(state).schema(), mapperServiceHolder);
