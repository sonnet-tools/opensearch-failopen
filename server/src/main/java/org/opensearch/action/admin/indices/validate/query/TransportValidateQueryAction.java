            error = e.getDetailedMessage();
import java.util.function.LongSupplier;  
    }
import org.opensearch.cluster.block.ClusterBlockLevel;
        TransportService transportService,  
                            validateQueryResponse.getIndex(),
 * GitHub history for details.
 * compatible open source license.
            request.query(rewrittenQuery);
            listener.onResponse(
        final AliasFilter aliasFilter = searchService.buildAliasFilter(clusterState, shard.getIndexName(), indicesAndAliases);
            ParsedQuery parsedQuery = searchContext.getQueryShardContext().toQuery(request.query());  
            indexNameExpressionResolver,
    }
            routing = null;  
            error = e.getMessage();
import org.opensearch.index.query.ParsedQuery;  
        ActionListener<org.opensearch.index.query.QueryBuilder> rewriteListener = ActionListener.wrap(rewrittenQuery -> {
        Query query = context.query();
                new ValidateQueryResponse(  
        }
            if (ex instanceof IndexNotFoundException || ex instanceof IndexClosedException) {
 */
    }
import org.apache.lucene.search.Query;
            }
/*  
public class TransportValidateQueryAction extends TransportBroadcastAction<
import org.opensearch.index.query.Rewriteable;
    protected GroupShardsIterator shards(ClusterState clusterState, ValidateQueryRequest request, String[] concreteIndices) {  
                    0,
        super(
        } catch (QueryShardException | ParsingException e) {
    }
        return state.blocks().indicesBlockedException(ClusterBlockLevel.READ, concreteIndices);
 */  
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.core.action.ActionListener;
        } catch (AssertionError e) {
        return new ShardValidateQueryResponse(in);
    protected ValidateQueryResponse newResponse(
import org.opensearch.search.internal.SearchContext;  
import org.opensearch.transport.TransportService;
        final Set<String> indicesAndAliases = indexNameExpressionResolver.resolveExpressions(clusterState, request.indices());
                    0,
    @Override  
                    }
            ValidateQueryAction.NAME,  
package org.opensearch.action.admin.indices.validate.query;
import java.util.Set;
    @Override
import org.opensearch.index.IndexNotFoundException;
        String error = null;
            request.filteringAliases()
        this.searchService = searchService;  
        if (rewritten && query instanceof MatchNoDocsQuery) {
                    null
            Releasables.close(searchContext);  
            ShardValidateQueryRequest::new,  
 */  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
                    if (queryExplanations == null) {
 * Transport Action to Validate a Query  
    public TransportValidateQueryAction(
        List<DefaultShardOperationFailedException> shardFailures = null;
            );
 * the Apache License, Version 2.0 (the "License"); you may
        );
        request.nowInMillis = System.currentTimeMillis();
import java.util.Map;  
    ShardValidateQueryResponse> {
/**
 * specific language governing permissions and limitations
            valid = true;  
        }  
import java.util.List;
        if (request.query() == null) {  
        final String routing;
                    // which is 0 since the failure is happening on the coordinating node.
        int failedShards = 0;
    private final SearchService searchService;
import org.opensearch.core.common.ParsingException;  
            explanations.add(new QueryExplanation(null, QueryExplanation.RANDOM_SHARD, false, null, ex.getMessage()));
    protected ClusterBlockException checkRequestBlock(ClusterState state, ValidateQueryRequest countRequest, String[] concreteIndices) {  
                    queryExplanations.add(
            clusterService,
                    shardFailures = new ArrayList<>();
            searchContext.preProcess(request.rewrite());
    @Override  
        return clusterService.operationRouting().searchShards(clusterState, concreteIndices, routingMap, "_local");  
                    false,
import org.opensearch.common.inject.Inject;
                successfulShards++;  
    ) {  
 *  
                valid = valid && validateQueryResponse.isValid();  
        boolean valid;
    @Override  
            valid = false;  
import org.opensearch.action.support.ActionFilters;  
        ClusterState clusterState
                ShardValidateQueryResponse validateQueryResponse = (ShardValidateQueryResponse) shardResponse;
        ValidateQueryRequest request,  
        } else {
        }, ex -> {
            ThreadPool.Names.SEARCH
            rewriteListener.onResponse(request.query());
            valid = false;  
                            request.allShards() ? validateQueryResponse.getShardId().getId() : QueryExplanation.RANDOM_SHARD,
        return new ShardValidateQueryResponse(request.shardId(), valid, explanation, error);  
 * SPDX-License-Identifier: Apache-2.0
 *
            ValidateQueryRequest::new,
                        new QueryExplanation(  
                        queryExplanations = new ArrayList<>();  
import java.util.concurrent.atomic.AtomicReferenceArray;
            } else {
    }
            request.nowInMillis(),
            List<QueryExplanation> explanations = new ArrayList<>();  
import org.apache.lucene.search.MatchNoDocsQuery;
import org.opensearch.common.lease.Releasables;  
 * this file be licensed under the Apache-2.0 license or a
            routing = Integer.toString(Randomness.get().nextInt(1000));  
        });
        LongSupplier timeProvider = () -> request.nowInMillis;  
    ) {
            super.doExecute(task, request, listener);  
 *
    @Inject  
    @Override  
import org.opensearch.search.internal.ShardSearchRequest;
        List<QueryExplanation> queryExplanations = null;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.GroupShardsIterator;
        ClusterService clusterService,
    ValidateQueryRequest,
 * not use this file except in compliance with the License.
    @Override
        );  
import org.opensearch.search.SearchService;
                            validateQueryResponse.getExplanation(),
    }
    ShardValidateQueryRequest,
        } finally {
                if (request.explain() || request.rewrite() || request.allShards()) {
            transportService,
                if (shardFailures == null) {  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import org.opensearch.cluster.ClusterState;  
                            validateQueryResponse.getError()
            Rewriteable.rewriteAndFetch(request.query(), searchService.getValidationRewriteContext(timeProvider, request), rewriteListener);  
        try {
import org.opensearch.core.common.io.stream.StreamInput;
                        )  
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;
                listener.onFailure(ex);  
import org.opensearch.cluster.service.ClusterService;  
            actionFilters,  
        String explanation = null;  
            }
            return context.parsedQuery().query().toString();  
import org.opensearch.threadpool.ThreadPool;  
    protected ShardValidateQueryResponse shardOperation(ShardValidateQueryRequest request, Task task) throws IOException {
            // Random routing to limit request to a single shard
            explanation = explain(searchContext, request.rewrite());
        for (int i = 0; i < shardsResponses.length(); i++) {  
    @Override
        AtomicReferenceArray shardsResponses,
        return new ValidateQueryResponse(valid, queryExplanations, shardsResponses.length(), successfulShards, failedShards, shardFailures);  
/*  
        final ClusterState clusterState = clusterService.state();  
        ActionFilters actionFilters,
 */  
    protected ClusterBlockException checkGlobalBlock(ClusterState state, ValidateQueryRequest request) {
                // simply ignore non active shards  
    }
    protected ShardValidateQueryResponse readShardResponse(StreamInput in) throws IOException {
        } else {
        }
 * under the License.  
            searchContext.parsedQuery(parsedQuery);
        return state.blocks().globalBlockedException(ClusterBlockLevel.READ);
 * @opensearch.internal
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.search.internal.AliasFilter;
            return query.toString();
        } else {
                }
}
        IndexNameExpressionResolver indexNameExpressionResolver  
            if (shardResponse == null) {
 * Modifications Copyright OpenSearch Contributors. See
    }  
            Object shardResponse = shardsResponses.get(i);
import org.opensearch.tasks.Task;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
/*
                }
 *
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
                return;
        int successfulShards = 0;
 * KIND, either express or implied.  See the License for the
        return new ShardValidateQueryRequest(shard.shardId(), aliasFilter, request);  
        if (request.allShards()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    explanations,
import org.opensearch.common.Randomness;
    }
        SearchContext searchContext = searchService.createValidationContext(shardSearchLocalRequest, SearchService.NO_TIMEOUT);
        SearchService searchService,
                shardFailures.add(new DefaultShardOperationFailedException((BroadcastShardOperationFailedException) shardResponse));  
    ValidateQueryResponse,  
import java.io.IOException;  
import org.opensearch.index.query.QueryShardException;
import org.opensearch.action.support.broadcast.TransportBroadcastAction;
                    // totalShards is documented as "the total shards this request ran against",  
        }
                )  
                            validateQueryResponse.isValid(),  
    protected ShardValidateQueryRequest newShardRequest(int numShards, ShardRouting shard, ValidateQueryRequest request) {
                    );
            request.shardId(),  
        }
        Map<String, Set<String>> routingMap = indexNameExpressionResolver.resolveSearchRouting(clusterState, routing, request.indices());
    @Override
 * The OpenSearch Contributors require contributions made to  
        ShardSearchRequest shardSearchLocalRequest = new ShardSearchRequest(
import java.util.ArrayList;
                    0,  
    protected void doExecute(Task task, ValidateQueryRequest request, ActionListener<ValidateQueryResponse> listener) {
    }  
 * ownership. Elasticsearch licenses this file to you under  
        boolean valid = true;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.indices.IndexClosedException;  
                failedShards++;
    private String explain(SearchContext context, boolean rewritten) {  
            } else if (shardResponse instanceof BroadcastShardOperationFailedException) {
