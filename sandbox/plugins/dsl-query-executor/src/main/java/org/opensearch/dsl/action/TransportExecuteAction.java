        this.planExecutor = new DslQueryPlanExecutor(executor);
            );
        }, listener::onFailure), 1 + countPlans.size());
    }
import java.util.ArrayList;
        ActionListener<SearchResponse> listener
            }
                converter = new SearchSourceConverter(contextProvider.getContext(state).schema(), mapperServiceHolder);
import org.opensearch.dsl.executor.DslQueryPlanExecutor;
    private final IndexResolutionStrategy indexResolutionStrategy = new SingleIndexResolutionStrategy();
            planExecutor.execute(mainPlans, joined);
    private final EngineContextProvider contextProvider;
     * @param contextProvider analytics engine context providing schema and operator table
            } catch (Exception e) {
    private static final Logger logger = LogManager.getLogger(TransportExecuteAction.class);
import org.opensearch.dsl.result.ExecutionResult;
            try {
        // COUNT plans run concurrently with the main plans - all are engine calls.
            final ActionListener<SearchResponse> requestListener = ActionListener.runAfter(listener, mapperServiceHolder::close);
            // snapshot for conversion and response building, created lazily, and closed when
        EngineContextProvider contextProvider,
     */
import org.opensearch.threadpool.ThreadPool;
        threadPool.executor(ThreadPool.Names.SEARCH).execute(() -> {
import java.util.List;
     * call, joins all results, and responds through
            long tookInMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);
    ) {
            return;
                return;
        }
     * {@link #buildAndRespond(List, SearchRequest, SearchSourceConverter, long, ActionListener)}.
    ) {
import org.opensearch.dsl.converter.ConversionException;
            return;
    /**
    }
        final SearchResponse response;
        }
        ClusterService clusterService,
        } catch (Exception buildEx) {
        final QueryPlans mainPlans = mainBuilder.build();
        this.clusterService = clusterService;
        if (countPlans.isEmpty()) {
    }
            List<ExecutionResult> allResults = new ArrayList<>();
    }
        this.threadPool = threadPool;
            final IndexMetadata indexMetadata;
            } catch (Exception e) {
        long startNanos,
            listener.onFailure(buildEx);
 * via Guice injection (enabled by {@code extendedPlugins = ['analytics-engine']}).
        this.indexNameExpressionResolver = indexNameExpressionResolver;
            final long startNanos = System.nanoTime();
        TransportService transportService,
 * this file be licensed under the Apache-2.0 license or a
            }
            executePlans(plans, request, converter, startNanos, requestListener);
                allResults.addAll(branch);
        SearchRequest request,
    private final IndicesService indicesService;
    private final DslQueryPlanExecutor planExecutor;
        this.contextProvider = contextProvider;
                );
        this.indicesService = indicesService;
import org.apache.logging.log4j.Logger;
            // Response typing works off the mapping pinned at request start: one immutable
        final GroupedActionListener<List<ExecutionResult>> joined = new GroupedActionListener<>(ActionListener.wrap(collections -> {
    private final ClusterService clusterService;
import org.opensearch.dsl.executor.QueryPlans;
                joined.onFailure(e);
        IndicesService indicesService,
import org.opensearch.dsl.converter.SearchSourceConverter;
     *
            }
/**
 * SPDX-License-Identifier: Apache-2.0
    public TransportExecuteAction(
     * @param indexNameExpressionResolver resolves aliases and wildcards to concrete indices
        List<ExecutionResult> results,
        ActionListener<SearchResponse> listener
            final String indexName = indexMetadata.getIndex().getName();
import org.opensearch.cluster.metadata.IndexMetadata;
        }
     */
        QueryPlanExecutor<RelNode, Iterable<Object[]>> executor,
                indexMetadata = indexResolutionStrategy.resolve(indexNameExpressionResolver, state, request).get(0);
                return;
            } catch (ConversionException e) {
import org.opensearch.dsl.result.SearchResponseBuilder;
    protected void doExecute(Task task, SearchRequest request, ActionListener<SearchResponse> listener) {
            buildAndRespond(allResults, request, converter, startNanos, listener);
        QueryPlans plans,
        QueryPlans.Builder mainBuilder = new QueryPlans.Builder();
                planExecutor.execute(new QueryPlans.Builder().add(countPlan).build(), joined);
    private void buildAndRespond(
import org.opensearch.core.action.ActionListener;
            } catch (Exception e) {
import org.opensearch.transport.TransportService;
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.ClusterState;
    @Override
     * Guice-injected constructor — receives analytics engine dependencies.
        listener.onResponse(response);
            for (List<ExecutionResult> branch : collections) {
                logger.debug("DSL conversion rejected the request", e);
        for (QueryPlans.QueryPlan plan : plans.getAll()) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.inject.Inject;
    private final IndexNameExpressionResolver indexNameExpressionResolver;
        try {
        ThreadPool threadPool
        try {
            final RequestScopedMapperService mapperServiceHolder = new RequestScopedMapperService(
        });
import org.opensearch.analytics.exec.QueryPlanExecutor;
    @Inject
        super(ExecuteAction.NAME, transportService, actionFilters, SearchRequest::new);
     * @param executor analytics engine plan executor
            if (plan.type() != QueryPlans.Type.COUNT) {
                requestListener.onFailure(e);
 */
    /**
                plans = converter.convert(request.source(), indexName);
        long startNanos,
 * <p>Receives {@link QueryPlanExecutor} and {@link EngineContextProvider} from the analytics engine
    ) {
                listener.onFailure(e);
/*
     * @param actionFilters action filters
 *
import org.opensearch.tasks.Task;
import org.opensearch.action.support.GroupedActionListener;
     * Any branch failing fails the request.
public class TransportExecuteAction extends HandledTransportAction<SearchRequest, SearchResponse> {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            // the request completes whether it succeeded or failed.
package org.opensearch.dsl.action;
        SearchRequest request,
                listener.onFailure(e);
import org.opensearch.action.search.SearchResponse;
            joined.onFailure(e);
            } catch (Exception e) {
            try {
    private final ThreadPool threadPool;
        }
        } catch (Exception e) {
import org.apache.calcite.rel.RelNode;
 *
import org.opensearch.action.support.HandledTransportAction;
 * Coordinates DSL query execution: converts SearchSourceBuilder to Calcite RelNode plans,
                indexMetadata,
            // TODO: cache per (indexUUID, mappingVersion) to avoid rebuilding analyzers.
 */
import org.opensearch.action.search.SearchRequest;
 * executes them via the analytics engine, and builds a SearchResponse.
                planExecutor.execute(
     * @param transportService transport service
        IndexNameExpressionResolver indexNameExpressionResolver,
}
            final SearchSourceConverter converter;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.analytics.EngineContextProvider;
            // One snapshot per request: index resolution, the engine schema, and response
            }
        SearchSourceConverter converter,
                    mainPlans,
        for (QueryPlans.QueryPlan countPlan : countPlans) {
        List<QueryPlans.QueryPlan> countPlans = plans.get(QueryPlans.Type.COUNT);
    private void executePlans(
                requestListener.onFailure(new IllegalArgumentException(e.getMessage(), e));
                // error (400), matching classic search's rejection of unsupported parameters.
        }
                indicesService::createIndexMapperService
                mainBuilder.add(plan);
import java.util.concurrent.TimeUnit;
                // The request carries a shape or parameter this path cannot honor — a client
            }
                    ActionListener.wrap(results -> buildAndRespond(results, request, converter, startNanos, listener), listener::onFailure)
            try {
            }
     * Submits the main plans as one batch and each COUNT plan as its own concurrent engine
            // typing all derive from the same immutable cluster state.
     * @param clusterService cluster service for resolving index aliases
            response = SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), tookInMillis);
import org.apache.logging.log4j.LogManager;
                return;
import org.opensearch.indices.IndicesService;
            final ClusterState state = clusterService.state();
        SearchSourceConverter converter,
        ActionFilters actionFilters,
 * compatible open source license.
            try {
            final QueryPlans plans;
