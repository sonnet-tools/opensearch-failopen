            context.parsedQuery(context.getQueryShardContext().toQuery(request.query()));
    static int resolveTopLevelDocId(Engine.GetResult result, IndexReader reader, Term uidTerm) throws IOException {
 */
            super.doExecute(task, request, listener);
    @Inject
}
            if (docIdAndSeqNo == null) {
 *
import org.opensearch.search.internal.AliasFilter;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.service.ClusterService;
    }
    }
            if (request.storedFields() != null || (request.fetchSourceContext() != null && request.fetchSourceContext().fetchSource())) {
import org.opensearch.action.RoutingMissingException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
            if (topLevelDocId == NO_MATCH) {
    protected void resolveRequest(ClusterState state, InternalRequest request) {
    }
    @Override
            transportService,
        return true;
     * different readers, so a {@link DocumentLookupResult.PreMaterialized} result (which carries no docId) must have
            request.query(rewrittenQuery);
            throw new OpenSearchException("Could not explain", e);
// TODO: AggregatedDfs. Currently the idf can be different then when executing a normal search with explain.
            try {
        this.searchService = searchService;
    }
                request.request().routing(),
 *
        return ExplainResponse::new;
                return new ExplainResponse(shardId.getIndexName(), request.id(), true, explanation, getResult);
    static final int NO_MATCH = -1;
     * lookup (loadDocIdAndVersion) could throw, and DOC_ID_ONLY also reuses the cache entry the get path already
    private final SearchService searchService;
            super.doExecute(task, request, listener);
 * GitHub history for details.
        throws IOException {
    @Override
        } finally {
        ShardSearchRequest shardSearchLocalRequest = new ShardSearchRequest(shardId, request.nowInMillis, request.filteringAlias());
        Engine.GetResult result = null;
    }
 * software distributed under the License is distributed on an
        // Fail fast on the node that received the request.
        return indexService.getIndexSettings().isSearchThrottled()
        ActionFilters actionFilters,
/**
import org.opensearch.core.action.ActionListener;
        return clusterService.operationRouting()
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
        ThreadPool threadPool,
        );
/*
            Explanation explanation = context.searcher().explain(context.query(), topLevelDocId);
    protected ShardIterator shards(ClusterState state, InternalRequest request) {
            }
                explanation = rescorer.explain(topLevelDocId, context.searcher(), ctx, explanation);
            ThreadPool.Names.GET
import org.opensearch.cluster.routing.ShardIterator;
 * specific language governing permissions and limitations
import org.apache.lucene.index.Term;
    }
            }
 */
 * You may obtain a copy of the License at
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                // because we are working in the same searcher in engineGetResult we can be sure that a
import org.opensearch.index.get.GetResult;
import org.opensearch.threadpool.ThreadPool;
        indexShard.awaitShardSearchActive(b -> {
        }
                // doc isn't deleted between the initial get and this call.
import org.opensearch.search.rescore.Rescorer;
                request.concreteIndex(),
     * Resolves the top-level (reader-relative) Lucene doc id used to explain a hit.
            context.preProcess(true);
    @Override
            }
                    .get(result, request.id(), request.storedFields(), request.fetchSourceContext());
import org.opensearch.cluster.ClusterState;
            // No need to check the type, IndexShard#get does it for us
    protected ExplainResponse shardOperation(ExplainRequest request, ShardId shardId) throws IOException {
        IndexService indexService = searchService.getIndicesService().indexServiceSafe(shardId.getIndex());
 * this file be licensed under the Apache-2.0 license or a
        super(
            VersionsAndSeqNoResolver.DocIdAndSeqNo docIdAndSeqNo = VersionsAndSeqNoResolver.loadDocId(reader, uidTerm);
            );
import org.opensearch.action.support.ActionFilters;
                return new ExplainResponse(shardId.getIndexName(), request.id(), false);
        }
import org.opensearch.action.support.single.shard.TransportSingleShardAction;
 * SPDX-License-Identifier: Apache-2.0
                clusterService.state(),
    protected Writeable.Reader<ExplainResponse> getResponseReader() {
                return new ExplainResponse(shardId.getIndexName(), request.id(), true, Explanation.noMatch("Failed to locate document"));
            if (!result.exists()) {
     */
        if (request.query() == null) {
                listener.onFailure(ex);
import org.opensearch.index.engine.Engine;
    protected void doExecute(Task task, ExplainRequest request, ActionListener<ExplainResponse> listener) {
import org.opensearch.index.mapper.Uid;
    protected void asyncShardOperation(ExplainRequest request, ShardId shardId, ActionListener<ExplainResponse> listener)
    /**
    /** Sentinel returned by {@link #resolveTopLevelDocId} when the id term is absent from the explain reader. */
    }
        return result.docIdAndVersion().docId + result.docIdAndVersion().docBase;
                GetResult getResult = context.indexShard()
import org.opensearch.index.IndexService;
        TransportService transportService,
     * <p>
    protected boolean resolveIndex(ExplainRequest request) {
    }
                    .getService()
 * compatible open source license.
import org.opensearch.index.query.Rewriteable;
 * Explain transport action. Computes the explain on the targeted shard.
        ActionListener<QueryBuilder> rewriteListener = ActionListener.wrap(rewrittenQuery -> {
                super.asyncShardOperation(request, shardId, listener);
    }
     * A docId is only meaningful relative to the reader that produced it, and the get and explain phases use
            Releasables.close(result, context);
 * not use this file except in compliance with the License.
        request.nowInMillis = System.currentTimeMillis();
            indexNameExpressionResolver,
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.search.internal.SearchContext;
     * {@link Engine.GetResult#docIdAndVersion()} is used.
 */
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver;
import org.opensearch.common.inject.Inject;
            } else {
import org.opensearch.tasks.Task;
     * <p>
            ExplainAction.NAME,
                Rescorer rescorer = ctx.rescorer();
        ClusterService clusterService,
    ) {
            return docIdAndSeqNo.docId + docIdAndSeqNo.context.docBase;
import org.opensearch.core.index.shard.ShardId;
            result = context.indexShard().get(new Engine.Get(false, false, request.id(), uidTerm));
    @Override
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.query.QueryBuilder;
        } catch (IOException e) {
                return new ExplainResponse(shardId.getIndexName(), request.id(), true, explanation);
     * created for this reader. Returns {@link #NO_MATCH} when the id term is absent from {@code reader}; otherwise the
            ExplainRequest::new,
        SearchService searchService,
 * The OpenSearch Contributors require contributions made to
/*
            throw new RoutingMissingException(request.concreteIndex(), request.request().id());
            }
import org.apache.lucene.search.Explanation;
        IndexShard indexShard = indexService.getShard(shardId.id());
        }
import org.opensearch.search.internal.ShardSearchRequest;
        IndexNameExpressionResolver indexNameExpressionResolver
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
    @Override
 *
        Rewriteable.rewriteAndFetch(request.query(), searchService.getRewriteContext(() -> request.nowInMillis, request), rewriteListener);
            threadPool,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.OpenSearchException;
        if (request.request().routing() == null && state.getMetadata().routingRequired(request.concreteIndex())) {
     * returns a PreMaterialized result may index the _id term without writing _version doc values, so a FULL-mode
            Term uidTerm = new Term(IdFieldMapper.NAME, Uid.encodeId(request.id()));
 *
 * KIND, either express or implied.  See the License for the
        try {
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.index.get.DocumentLookupResult;
        if (result instanceof DocumentLookupResult.PreMaterialized) {
     * For a PreMaterialized result the docId is resolved against {@code reader} in DOC_ID_ONLY mode: an engine that
            ? ThreadPool.Names.SEARCH_THROTTLED
            } catch (Exception ex) {
    }
            .getShards(
        request.request().filteringAlias(aliasFilter);
     * leaf docId lifted by its docBase. For any other result the docId carried on
    @Override
        final AliasFilter aliasFilter = searchService.buildAliasFilter(state, request.concreteIndex(), indicesAndAliases);
        IndexService indexService = searchService.getIndicesService().indexServiceSafe(shardId.getIndex());
import java.io.IOException;
import org.opensearch.search.rescore.RescoreContext;
public class TransportExplainAction extends TransportSingleShardAction<ExplainRequest, ExplainResponse> {
            for (RescoreContext ctx : context.rescore()) {
import org.opensearch.common.lease.Releasables;
    protected String getExecutor(ExplainRequest request, ShardId shardId) {
            actionFilters,
    public TransportExplainAction(
        final Set<String> indicesAndAliases = indexNameExpressionResolver.resolveExpressions(state, request.request().index());
            return;
import org.opensearch.index.mapper.IdFieldMapper;
                return NO_MATCH;
import org.opensearch.transport.TransportService;
                // Advantage is that we're not opening a second searcher to retrieve the _source. Also
            int topLevelDocId = resolveTopLevelDocId(result, context.searcher().getIndexReader(), uidTerm);
        // if there's no query we can't rewrite it
            }
 * under the License.
 */
import java.util.Set;
    @Override
 * @opensearch.internal
import org.apache.lucene.index.IndexReader;
        SearchContext context = searchService.createSearchContext(shardSearchLocalRequest, SearchService.NO_TIMEOUT);
import org.opensearch.index.shard.IndexShard;
        }
import org.opensearch.search.SearchService;
                request.request().preference()
     * its docId resolved against the explain searcher's own {@code reader} rather than one carried on the get result.
            clusterService,
            : super.getExecutor(request, shardId);
package org.opensearch.action.explain;
        }, listener::onFailure);
        });
                request.request().id(),
