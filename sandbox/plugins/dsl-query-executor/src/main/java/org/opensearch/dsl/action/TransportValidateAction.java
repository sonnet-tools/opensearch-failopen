    private final IndexResolutionStrategy indexResolutionStrategy = new SingleIndexResolutionStrategy();
     * @param actionFilters action filters
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                listener.onFailure(e);
    private ValidateQueryResponse validate(ValidateQueryRequest request) {
 * </ul>
     * @param transportService transport service
     */
            error = e.getMessage();
        EngineContextProvider contextProvider,
        IndicesService indicesService,
        ThreadPool threadPool
            valid = false;
import org.opensearch.core.action.ActionListener;
     */
    @Inject
 *   <li>Query types without a registered translator convert into {@code UnresolvedQueryCall}
        try (
import org.opensearch.analytics.EngineContextProvider;
import org.opensearch.cluster.metadata.IndexMetadata;
        super(ValidateAction.NAME, transportService, actionFilters, ValidateQueryRequest::new);
import org.opensearch.transport.TransportService;
        } catch (ConversionException e) {
                indicesService::createIndexMapperService
            QueryPlans plans = converter.convert(source, indexName);
            } catch (Exception e) {
 */
        this.clusterService = clusterService;
 */
     * exception (index not found, multiple indices) propagates as a request failure,
                listener.onResponse(validate(request));
    /**
            RequestScopedMapperService mapperService = new RequestScopedMapperService(
/**
 * Validates a query against the DSL-to-Calcite conversion pipeline without executing it.
    private final ThreadPool threadPool;
import org.opensearch.search.builder.SearchSourceBuilder;
        IndexNameExpressionResolver indexNameExpressionResolver,
                indexMetadata,
                logger.error("DSL validation failed", e);
        String error = null;
     * only if execution would accept it.
     * snapshot, same mapping-aware {@link SearchSourceConverter} — so a query validates here if and
import org.apache.logging.log4j.LogManager;
 *
 *
package org.opensearch.dsl.action;
import org.opensearch.tasks.Task;
 * <p>Vanilla {@code _validate/query} checks whether Lucene can parse the query — the wrong
     * A {@link ConversionException} means the query is invalid on this path; any other
        // Mapping pinned at request start, mirroring execution, and released when validation ends.
 *
 * The OpenSearch Contributors require contributions made to
        this.indexNameExpressionResolver = indexNameExpressionResolver;
 * plans (valid) or throws {@link ConversionException} (invalid, message reported as the error).
                explanation = plans.first().map(plan -> plan.relNode().explain().trim()).orElse(null);
     *
/*
            )
            try {
import org.opensearch.action.support.HandledTransportAction;
        final IndexMetadata indexMetadata = indexResolutionStrategy.resolve(indexNameExpressionResolver, state, request).get(0);
 *       ({@code RelNode.explain()}) rather than a rewritten Lucene query.</li>
 * <ul>
            }
        // Like vanilla, detail (the plan explanation) is returned only when explicitly requested.
    }
        this.threadPool = threadPool;
}
     * matching how {@code _search} reports the same conditions.
     * @param threadPool thread pool for offloading conversion work
     * Guice-injected constructor — receives the analytics engine context for schema access.
    }
    private final IndexNameExpressionResolver indexNameExpressionResolver;
    }
    ) {
 * <p>Scope notes:
 * SPDX-License-Identifier: Apache-2.0
        }
 * this file be licensed under the Apache-2.0 license or a
 *       {@code all_shards} is set. The explanation text is the converted plan
    private final ClusterService clusterService;
import org.opensearch.cluster.service.ClusterService;
        this.contextProvider = contextProvider;
        // One snapshot per request: index resolution, the engine schema, and mapping resolution
 *       index), not engine capability limits.</li>
            valid = true;
 * compatible open source license.
        ClusterService clusterService,
        boolean valid;
import org.opensearch.dsl.executor.QueryPlans;
    private static final Logger logger = LogManager.getLogger(TransportValidateAction.class);
        source.query(request.query());
        // all derive from the same immutable cluster state.
            ? List.of(new QueryExplanation(indexName, QueryExplanation.RANDOM_SHARD, valid, valid ? explanation : null, error))
        TransportService transportService,
     * @param clusterService cluster service for resolving index aliases
     * Runs the conversion pipeline and maps the outcome to a {@link ValidateQueryResponse}.
        ) {
     *
import org.opensearch.indices.IndicesService;
import org.opensearch.cluster.ClusterState;
     * <p>Conversion is set up exactly as {@link TransportExecuteAction} does — same cluster-state
    /**
import org.opensearch.action.support.ActionFilters;
        List<QueryExplanation> explanations = detailRequested
 *       valid here. Conversion-level validation catches schema errors (unknown fields, unknown
    @Override
        return new ValidateQueryResponse(valid, explanations, 1, 1, 0, List.of());
        final String indexName = indexMetadata.getIndex().getName();
import org.apache.logging.log4j.Logger;
     * @param indexNameExpressionResolver resolves aliases and wildcards to concrete indices
import java.util.List;
        final ClusterState state = clusterService.state();
        final boolean detailRequested = request.explain() || request.rewrite() || request.allShards();
import org.opensearch.action.admin.indices.validate.query.ValidateQueryResponse;
        threadPool.executor(ThreadPool.Names.SEARCH).execute(() -> {
    protected void doExecute(Task task, ValidateQueryRequest request, ActionListener<ValidateQueryResponse> listener) {
 *       reported as 1/1 and {@code all_shards} adds nothing beyond {@code explain}.</li>
        this.indicesService = indicesService;
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;
        SearchSourceBuilder source = new SearchSourceBuilder();
        String explanation = null;
            : null;
     * @param contextProvider analytics engine context providing the Calcite schema
     * @param indicesService creates the request-scoped MapperService for mapping-aware validation
        ActionFilters actionFilters,
            if (detailRequested) {
import org.opensearch.threadpool.ThreadPool;
    private final IndicesService indicesService;
 *   <li>Like vanilla, explanations are returned only when {@code explain}, {@code rewrite}, or
 * here is conversion without execution: {@link SearchSourceConverter#convert} either produces
 * question on this path, where a query succeeds only if the converter accepts it. Validation
import org.opensearch.common.inject.Inject;
 *       for the engine's optimizer to resolve or reject at execution time — they validate as
        });
import org.opensearch.dsl.converter.SearchSourceConverter;
import org.opensearch.action.admin.indices.validate.query.QueryExplanation;
            }
    public TransportValidateAction(
    private final EngineContextProvider contextProvider;
import org.opensearch.dsl.converter.ConversionException;
            SearchSourceConverter converter = new SearchSourceConverter(contextProvider.getContext(state).schema(), mapperService);
 *   <li>Conversion is a coordinator concern — there is no shard fan-out, so shard counts are
public class TransportValidateAction extends HandledTransportAction<ValidateQueryRequest, ValidateQueryResponse> {
