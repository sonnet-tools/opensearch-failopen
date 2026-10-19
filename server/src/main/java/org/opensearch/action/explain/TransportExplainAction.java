    protected boolean resolveIndex(ExplainRequest request) {
 * You may obtain a copy of the License at  
    static int resolveTopLevelDocId(Engine.GetResult result, IndexReader reader, Term uidTerm) throws IOException {
                return new ExplainResponse(shardId.getIndexName(), request.id(), true, Explanation.noMatch("Failed to locate document"));
     * {@link Engine.GetResult#docIdAndVersion()} is used.
            context.preProcess(true);
 */  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.IndexService;  
            int topLevelDocId = resolveTopLevelDocId(result, context.searcher().getIndexReader(), uidTerm);
    }
        Engine.GetResult result = null;
        ShardSearchRequest shardSearchLocalRequest = new ShardSearchRequest(shardId, request.nowInMillis, request.filteringAlias());
import org.opensearch.OpenSearchException;
            Term uidTerm = new Term(IdFieldMapper.NAME, Uid.encodeId(request.id()));
    protected void resolveRequest(ClusterState state, InternalRequest request) {  
            ? ThreadPool.Names.SEARCH_THROTTLED  
                    .getService()
     * returns a PreMaterialized result may index the _id term without writing _version doc values, so a FULL-mode
    }
        return ExplainResponse::new;
import org.opensearch.index.shard.IndexShard;
            try {
 * SPDX-License-Identifier: Apache-2.0
     * created for this reader. Returns {@link #NO_MATCH} when the id term is absent from {@code reader}; otherwise the  
import java.io.IOException;
    /**
        IndexNameExpressionResolver indexNameExpressionResolver  
 * specific language governing permissions and limitations
        if (request.request().routing() == null && state.getMetadata().routingRequired(request.concreteIndex())) {
            } catch (Exception ex) {  
                return new ExplainResponse(shardId.getIndexName(), request.id(), false);
    }  
        final AliasFilter aliasFilter = searchService.buildAliasFilter(state, request.concreteIndex(), indicesAndAliases);
        ActionFilters actionFilters,
        return result.docIdAndVersion().docId + result.docIdAndVersion().docBase;  
        SearchService searchService,
                GetResult getResult = context.indexShard()  
        // Fail fast on the node that received the request.
        // if there's no query we can't rewrite it  
        }
                    .get(result, request.id(), request.storedFields(), request.fetchSourceContext());
 * under the License.  
            request.query(rewrittenQuery);  
        throws IOException {  
 */
            Releasables.close(result, context);
    static final int NO_MATCH = -1;  
import org.opensearch.common.inject.Inject;  
        }
            }
import org.opensearch.tasks.Task;  
 * Licensed to Elasticsearch under one or more contributor  
     * <p>
import org.opensearch.index.engine.Engine;
        IndexService indexService = searchService.getIndicesService().indexServiceSafe(shardId.getIndex());
                request.request().preference()
    }
import org.apache.lucene.index.Term;
import org.opensearch.cluster.service.ClusterService;
        }, listener::onFailure);
            ExplainRequest::new,  
        this.searchService = searchService;  
 * compatible open source license.
        return true;
    @Override  
    @Override  
            throw new RoutingMissingException(request.concreteIndex(), request.request().id());  
import org.opensearch.threadpool.ThreadPool;
     * lookup (loadDocIdAndVersion) could throw, and DOC_ID_ONLY also reuses the cache entry the get path already
            );
 * not use this file except in compliance with the License.
            clusterService,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        request.request().filteringAlias(aliasFilter);  
 *
        } catch (IOException e) {
            result = context.indexShard().get(new Engine.Get(false, false, request.id(), uidTerm));
                // doc isn't deleted between the initial get and this call.
    /** Sentinel returned by {@link #resolveTopLevelDocId} when the id term is absent from the explain reader. */
        );
        Rewriteable.rewriteAndFetch(request.query(), searchService.getRewriteContext(() -> request.nowInMillis, request), rewriteListener);  
    @Override  
        ClusterService clusterService,
                explanation = rescorer.explain(topLevelDocId, context.searcher(), ctx, explanation);  
 *    http://www.apache.org/licenses/LICENSE-2.0
// TODO: AggregatedDfs. Currently the idf can be different then when executing a normal search with explain.  
import org.opensearch.cluster.ClusterState;
 * Modifications Copyright OpenSearch Contributors. See
    public TransportExplainAction(  
    @Override  
                request.request().routing(),  
    @Override
import org.opensearch.core.action.ActionListener;  
import org.opensearch.action.RoutingMissingException;
                // Advantage is that we're not opening a second searcher to retrieve the _source. Also  
            if (topLevelDocId == NO_MATCH) {  
import org.apache.lucene.index.IndexReader;
                super.asyncShardOperation(request, shardId, listener);
    }
        IndexShard indexShard = indexService.getShard(shardId.id());
import org.opensearch.search.internal.SearchContext;
                return new ExplainResponse(shardId.getIndexName(), request.id(), true, explanation);
        indexShard.awaitShardSearchActive(b -> {  
            ThreadPool.Names.GET
        if (request.query() == null) {
 * The OpenSearch Contributors require contributions made to  
            transportService,  
        TransportService transportService,  
            if (docIdAndSeqNo == null) {
            VersionsAndSeqNoResolver.DocIdAndSeqNo docIdAndSeqNo = VersionsAndSeqNoResolver.loadDocId(reader, uidTerm);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.TransportService;
     * its docId resolved against the explain searcher's own {@code reader} rather than one carried on the get result.
import org.opensearch.action.support.ActionFilters;  
import org.opensearch.common.lease.Releasables;
import org.opensearch.index.query.QueryBuilder;  
    private final SearchService searchService;  
            // No need to check the type, IndexShard#get does it for us  
        ThreadPool threadPool,
     * different readers, so a {@link DocumentLookupResult.PreMaterialized} result (which carries no docId) must have  
    protected void doExecute(Task task, ExplainRequest request, ActionListener<ExplainResponse> listener) {
import org.opensearch.index.mapper.IdFieldMapper;
        try {
import org.opensearch.index.get.DocumentLookupResult;
 * GitHub history for details.
                request.concreteIndex(),
        SearchContext context = searchService.createSearchContext(shardSearchLocalRequest, SearchService.NO_TIMEOUT);  
        });  
 * Explain transport action. Computes the explain on the targeted shard.
 * software distributed under the License is distributed on an
     * Resolves the top-level (reader-relative) Lucene doc id used to explain a hit.  
                Rescorer rescorer = ctx.rescorer();
 */  
import org.opensearch.index.query.Rewriteable;
    protected String getExecutor(ExplainRequest request, ShardId shardId) {  
/*  
     * leaf docId lifted by its docBase. For any other result the docId carried on
            actionFilters,
     * A docId is only meaningful relative to the reader that produced it, and the get and explain phases use
    }  
    protected Writeable.Reader<ExplainResponse> getResponseReader() {
        IndexService indexService = searchService.getIndicesService().indexServiceSafe(shardId.getIndex());
        ActionListener<QueryBuilder> rewriteListener = ActionListener.wrap(rewrittenQuery -> {
                request.request().id(),
import org.apache.lucene.search.Explanation;  
            super.doExecute(task, request, listener);
import org.opensearch.action.support.single.shard.TransportSingleShardAction;
 *  
    @Override
import org.opensearch.core.index.shard.ShardId;
    @Override
 * KIND, either express or implied.  See the License for the
}  
import org.opensearch.index.get.GetResult;  
import org.opensearch.search.rescore.Rescorer;
            .getShards(
 *
        return indexService.getIndexSettings().isSearchThrottled()
            }
        super(
/**
import org.opensearch.search.internal.ShardSearchRequest;  
import java.util.Set;
    }  
            ExplainAction.NAME,  
            context.parsedQuery(context.getQueryShardContext().toQuery(request.query()));  
            return docIdAndSeqNo.docId + docIdAndSeqNo.context.docBase;
            indexNameExpressionResolver,
            } else {
    ) {
    protected ExplainResponse shardOperation(ExplainRequest request, ShardId shardId) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
            return;  
                clusterService.state(),  
    @Inject
                // because we are working in the same searcher in engineGetResult we can be sure that a
/*  
import org.opensearch.cluster.routing.ShardIterator;
            }  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
            if (!result.exists()) {  
    }  
import org.opensearch.search.internal.AliasFilter;
package org.opensearch.action.explain;
        final Set<String> indicesAndAliases = indexNameExpressionResolver.resolveExpressions(state, request.request().index());
     * <p>
     */  
            }  
 * this work for additional information regarding copyright
            }
 * Unless required by applicable law or agreed to in writing,
            threadPool,
            super.doExecute(task, request, listener);
        request.nowInMillis = System.currentTimeMillis();
        if (result instanceof DocumentLookupResult.PreMaterialized) {
            : super.getExecutor(request, shardId);
                return NO_MATCH;
        }
import org.opensearch.search.rescore.RescoreContext;
    protected void asyncShardOperation(ExplainRequest request, ShardId shardId, ActionListener<ExplainResponse> listener)
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver;
 * @opensearch.internal
        }
            if (request.storedFields() != null || (request.fetchSourceContext() != null && request.fetchSourceContext().fetchSource())) {
            throw new OpenSearchException("Could not explain", e);
                return new ExplainResponse(shardId.getIndexName(), request.id(), true, explanation, getResult);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.Writeable;
    }
import org.opensearch.search.SearchService;  
import org.opensearch.index.mapper.Uid;
            }
        } finally {  
                listener.onFailure(ex);
    protected ShardIterator shards(ClusterState state, InternalRequest request) {  
    }
            for (RescoreContext ctx : context.rescore()) {
     * For a PreMaterialized result the docId is resolved against {@code reader} in DOC_ID_ONLY mode: an engine that  
/*
 *  
            Explanation explanation = context.searcher().explain(context.query(), topLevelDocId);  
        return clusterService.operationRouting()
 */
public class TransportExplainAction extends TransportSingleShardAction<ExplainRequest, ExplainResponse> {
