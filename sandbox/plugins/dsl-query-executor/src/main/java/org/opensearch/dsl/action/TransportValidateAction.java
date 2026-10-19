import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            valid = true;
            }
import org.opensearch.dsl.executor.QueryPlans;
        this.threadPool = threadPool;  
        ThreadPool threadPool
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
            QueryPlans plans = converter.convert(source, indexName);
    ) {  
        TransportService transportService,
        this.indicesService = indicesService;
    }
        // Like vanilla, detail (the plan explanation) is returned only when explicitly requested.
 * question on this path, where a query succeeds only if the converter accepts it. Validation  
    private final ThreadPool threadPool;
        IndicesService indicesService,  
/*  
     * @param indicesService creates the request-scoped MapperService for mapping-aware validation
     * @param clusterService cluster service for resolving index aliases
        List<QueryExplanation> explanations = detailRequested
 */
     */  
    public TransportValidateAction(
    private ValidateQueryResponse validate(ValidateQueryRequest request) {
        });  
     * @param contextProvider analytics engine context providing the Calcite schema  
            }
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
            SearchSourceConverter converter = new SearchSourceConverter(contextProvider.getContext(state).schema(), mapperService);  
     * only if execution would accept it.
        // all derive from the same immutable cluster state.  
        this.clusterService = clusterService;  
        this.indexNameExpressionResolver = indexNameExpressionResolver;
        ClusterService clusterService,
     * Guice-injected constructor — receives the analytics engine context for schema access.
        String error = null;
package org.opensearch.dsl.action;
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.ClusterState;  
        SearchSourceBuilder source = new SearchSourceBuilder();
                indicesService::createIndexMapperService  
     * A {@link ConversionException} means the query is invalid on this path; any other
    private final IndexResolutionStrategy indexResolutionStrategy = new SingleIndexResolutionStrategy();
import org.opensearch.action.support.ActionFilters;  
            try {  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
 *       ({@code RelNode.explain()}) rather than a rewritten Lucene query.</li>  
    @Inject  
import org.apache.logging.log4j.Logger;
        final IndexMetadata indexMetadata = indexResolutionStrategy.resolve(indexNameExpressionResolver, state, request).get(0);
     * matching how {@code _search} reports the same conditions.
 * <ul>
            ? List.of(new QueryExplanation(indexName, QueryExplanation.RANDOM_SHARD, valid, valid ? explanation : null, error))  
 *   <li>Conversion is a coordinator concern — there is no shard fan-out, so shard counts are
import org.opensearch.indices.IndicesService;  
        } catch (ConversionException e) {  
 *   <li>Query types without a registered translator convert into {@code UnresolvedQueryCall}  
            } catch (Exception e) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.dsl.converter.SearchSourceConverter;
     * snapshot, same mapping-aware {@link SearchSourceConverter} — so a query validates here if and
 * here is conversion without execution: {@link SearchSourceConverter#convert} either produces
import org.opensearch.dsl.converter.ConversionException;  
 * SPDX-License-Identifier: Apache-2.0
     * @param transportService transport service
    private final IndexNameExpressionResolver indexNameExpressionResolver;  
    private final IndicesService indicesService;
        try (  
     * @param actionFilters action filters
 *   <li>Like vanilla, explanations are returned only when {@code explain}, {@code rewrite}, or
    /**  
            valid = false;
     * @param indexNameExpressionResolver resolves aliases and wildcards to concrete indices  
        this.contextProvider = contextProvider;
        boolean valid;
            error = e.getMessage();
    private static final Logger logger = LogManager.getLogger(TransportValidateAction.class);
import org.opensearch.search.builder.SearchSourceBuilder;
                listener.onResponse(validate(request));
        final ClusterState state = clusterService.state();
import org.opensearch.core.action.ActionListener;
 * <p>Scope notes:
        EngineContextProvider contextProvider,
 */  
            if (detailRequested) {  
import org.apache.logging.log4j.LogManager;
    protected void doExecute(Task task, ValidateQueryRequest request, ActionListener<ValidateQueryResponse> listener) {
    private final ClusterService clusterService;
 *       index), not engine capability limits.</li>  
     * Runs the conversion pipeline and maps the outcome to a {@link ValidateQueryResponse}.
import java.util.List;  
 *       for the engine's optimizer to resolve or reject at execution time — they validate as
 *       reported as 1/1 and {@code all_shards} adds nothing beyond {@code explain}.</li>
 * Validates a query against the DSL-to-Calcite conversion pipeline without executing it.  
        source.query(request.query());  
public class TransportValidateAction extends HandledTransportAction<ValidateQueryRequest, ValidateQueryResponse> {
     *
     * <p>Conversion is set up exactly as {@link TransportExecuteAction} does — same cluster-state  
    /**
            RequestScopedMapperService mapperService = new RequestScopedMapperService(
import org.opensearch.common.inject.Inject;
     *  
 *
 * compatible open source license.
        final String indexName = indexMetadata.getIndex().getName();  
                logger.error("DSL validation failed", e);  
                indexMetadata,
        // One snapshot per request: index resolution, the engine schema, and mapping resolution
        String explanation = null;  
import org.opensearch.action.admin.indices.validate.query.QueryExplanation;  
            : null;
        IndexNameExpressionResolver indexNameExpressionResolver,
    }  
 *  
import org.opensearch.action.support.HandledTransportAction;
 *       valid here. Conversion-level validation catches schema errors (unknown fields, unknown
                listener.onFailure(e);
            )
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.cluster.service.ClusterService;  
        // Mapping pinned at request start, mirroring execution, and released when validation ends.
import org.opensearch.cluster.metadata.IndexMetadata;
        final boolean detailRequested = request.explain() || request.rewrite() || request.allShards();  
        super(ValidateAction.NAME, transportService, actionFilters, ValidateQueryRequest::new);
/**
     * @param threadPool thread pool for offloading conversion work
}
 *       {@code all_shards} is set. The explanation text is the converted plan
     */
    }
 * plans (valid) or throws {@link ConversionException} (invalid, message reported as the error).
        ) {
        }  
 * <p>Vanilla {@code _validate/query} checks whether Lucene can parse the query — the wrong
import org.opensearch.tasks.Task;
     * exception (index not found, multiple indices) propagates as a request failure,  
        return new ValidateQueryResponse(valid, explanations, 1, 1, 0, List.of());
        ActionFilters actionFilters,  
 * </ul>  
    private final EngineContextProvider contextProvider;  
                explanation = plans.first().map(plan -> plan.relNode().explain().trim()).orElse(null);
 *
        threadPool.executor(ThreadPool.Names.SEARCH).execute(() -> {
import org.opensearch.analytics.EngineContextProvider;
