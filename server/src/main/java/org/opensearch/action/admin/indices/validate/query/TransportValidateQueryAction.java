        this.searchService = searchService;
        ShardSearchRequest shardSearchLocalRequest = new ShardSearchRequest(
            // Random routing to limit request to a single shard
            if (ex instanceof IndexNotFoundException || ex instanceof IndexClosedException) {
 * The OpenSearch Contributors require contributions made to
                listener.onFailure(ex);
 *
        String error = null;
import org.opensearch.cluster.block.ClusterBlockException;
    }
                if (request.explain() || request.rewrite() || request.allShards()) {
    @Override
 * compatible open source license.
                            request.allShards() ? validateQueryResponse.getShardId().getId() : QueryExplanation.RANDOM_SHARD,
        }
            routing = null;
import org.opensearch.index.IndexNotFoundException;
                    false,
        }, ex -> {
            } else {
import org.opensearch.threadpool.ThreadPool;
                            validateQueryResponse.getIndex(),
import org.opensearch.index.query.QueryShardException;
import org.opensearch.action.support.broadcast.BroadcastShardOperationFailedException;
import org.apache.lucene.search.Query;
    }
import org.opensearch.cluster.block.ClusterBlockLevel;
 * under the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
        }
        boolean valid;
        Map<String, Set<String>> routingMap = indexNameExpressionResolver.resolveSearchRouting(clusterState, routing, request.indices());
        LongSupplier timeProvider = () -> request.nowInMillis;
        super(
        final String routing;
    protected ShardValidateQueryResponse readShardResponse(StreamInput in) throws IOException {
        return new ShardValidateQueryRequest(shard.shardId(), aliasFilter, request);
                    // totalShards is documented as "the total shards this request ran against",
    public TransportValidateQueryAction(
import org.opensearch.search.internal.SearchContext;
                        queryExplanations = new ArrayList<>();
                    // which is 0 since the failure is happening on the coordinating node.
    }
 *
        boolean valid = true;
/*
            clusterService,
            Object shardResponse = shardsResponses.get(i);
        ClusterState clusterState
                failedShards++;
            actionFilters,
package org.opensearch.action.admin.indices.validate.query;
            valid = false;
import java.util.function.LongSupplier;
 * specific language governing permissions and limitations
        );
                    queryExplanations.add(
    protected ValidateQueryResponse newResponse(
    @Override
        ValidateQueryRequest request,
        if (request.query() == null) {
                            validateQueryResponse.getError()
        SearchService searchService,
        IndexNameExpressionResolver indexNameExpressionResolver
 *
            listener.onResponse(
import org.opensearch.common.lease.Releasables;
        int successfulShards = 0;
            } else if (shardResponse instanceof BroadcastShardOperationFailedException) {
                    shardFailures = new ArrayList<>();
            explanations.add(new QueryExplanation(null, QueryExplanation.RANDOM_SHARD, false, null, ex.getMessage()));
    private String explain(SearchContext context, boolean rewritten) {
import org.opensearch.cluster.routing.GroupShardsIterator;
        List<DefaultShardOperationFailedException> shardFailures = null;
    }
        ActionFilters actionFilters,
    ) {
public class TransportValidateQueryAction extends TransportBroadcastAction<
 * this file be licensed under the Apache-2.0 license or a
            ValidateQueryAction.NAME,
            error = e.getMessage();
        return new ValidateQueryResponse(valid, queryExplanations, shardsResponses.length(), successfulShards, failedShards, shardFailures);
            valid = false;
import org.opensearch.core.common.io.stream.StreamInput;
        } else {
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.support.broadcast.TransportBroadcastAction;
        }
    @Override
                        new QueryExplanation(
            valid = true;
    }
        }
/*
                    0,
    }
import org.opensearch.cluster.service.ClusterService;
    ShardValidateQueryRequest,
    @Override
import java.util.ArrayList;
            );
import org.opensearch.search.internal.ShardSearchRequest;
    protected ClusterBlockException checkRequestBlock(ClusterState state, ValidateQueryRequest countRequest, String[] concreteIndices) {
                        )
                // simply ignore non active shards
            if (shardResponse == null) {
            error = e.getDetailedMessage();
                )
        return new ShardValidateQueryResponse(request.shardId(), valid, explanation, error);
            }
            indexNameExpressionResolver,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    0,
import org.opensearch.core.action.ActionListener;
    @Override
            request.filteringAliases()
        TransportService transportService,
 * Unless required by applicable law or agreed to in writing,
                ShardValidateQueryResponse validateQueryResponse = (ShardValidateQueryResponse) shardResponse;
        final Set<String> indicesAndAliases = indexNameExpressionResolver.resolveExpressions(clusterState, request.indices());
 * ownership. Elasticsearch licenses this file to you under
            ShardValidateQueryRequest::new,
    protected GroupShardsIterator shards(ClusterState clusterState, ValidateQueryRequest request, String[] concreteIndices) {
 * Licensed to Elasticsearch under one or more contributor
    @Override
        final AliasFilter aliasFilter = searchService.buildAliasFilter(clusterState, shard.getIndexName(), indicesAndAliases);
        try {
 */
                return;
import java.util.Set;
            rewriteListener.onResponse(request.query());
            super.doExecute(task, request, listener);
import org.opensearch.index.query.Rewriteable;
                successfulShards++;
import org.opensearch.transport.TransportService;
    protected ClusterBlockException checkGlobalBlock(ClusterState state, ValidateQueryRequest request) {
import java.util.concurrent.atomic.AtomicReferenceArray;
/*
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
    ShardValidateQueryResponse> {
            request.nowInMillis(),
 */
import java.io.IOException;
            List<QueryExplanation> explanations = new ArrayList<>();
                }
    @Override
    ValidateQueryRequest,
 */
                            validateQueryResponse.isValid(),
                            validateQueryResponse.getExplanation(),
        return clusterService.operationRouting().searchShards(clusterState, concreteIndices, routingMap, "_local");
import org.opensearch.action.support.ActionFilters;
        return state.blocks().indicesBlockedException(ClusterBlockLevel.READ, concreteIndices);
            explanation = explain(searchContext, request.rewrite());
            ParsedQuery parsedQuery = searchContext.getQueryShardContext().toQuery(request.query());
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.indices.IndexClosedException;
            ThreadPool.Names.SEARCH
 *
        } finally {
        if (request.allShards()) {
            request.shardId(),
import org.opensearch.core.common.ParsingException;
 * this work for additional information regarding copyright
import org.opensearch.index.query.ParsedQuery;
            searchContext.parsedQuery(parsedQuery);
import org.opensearch.common.Randomness;
        } catch (AssertionError e) {
        final ClusterState clusterState = clusterService.state();
    @Override
                shardFailures.add(new DefaultShardOperationFailedException((BroadcastShardOperationFailedException) shardResponse));
 * GitHub history for details.
 * software distributed under the License is distributed on an
        ClusterService clusterService,
                if (shardFailures == null) {
                    );
import org.opensearch.search.internal.AliasFilter;
        List<QueryExplanation> queryExplanations = null;
                    explanations,
                    0,
 * KIND, either express or implied.  See the License for the
            Rewriteable.rewriteAndFetch(request.query(), searchService.getValidationRewriteContext(timeProvider, request), rewriteListener);
import org.opensearch.common.inject.Inject;
        } else {
        }
            request.query(rewrittenQuery);
                new ValidateQueryResponse(
    protected void doExecute(Task task, ValidateQueryRequest request, ActionListener<ValidateQueryResponse> listener) {
    }
        request.nowInMillis = System.currentTimeMillis();
        ActionListener<org.opensearch.index.query.QueryBuilder> rewriteListener = ActionListener.wrap(rewrittenQuery -> {
    private final SearchService searchService;
/**
import org.opensearch.tasks.Task;
                valid = valid && validateQueryResponse.isValid();
    protected ShardValidateQueryRequest newShardRequest(int numShards, ShardRouting shard, ValidateQueryRequest request) {
            return context.parsedQuery().query().toString();
        } else {
                }
        for (int i = 0; i < shardsResponses.length(); i++) {
}
            Releasables.close(searchContext);
import org.apache.lucene.search.MatchNoDocsQuery;
        if (rewritten && query instanceof MatchNoDocsQuery) {
        int failedShards = 0;
        );
    }
 * not use this file except in compliance with the License.
                    }
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import java.util.List;
        return new ShardValidateQueryResponse(in);
        return state.blocks().globalBlockedException(ClusterBlockLevel.READ);
    ) {
        String explanation = null;
 * @opensearch.internal
import java.util.Map;
            routing = Integer.toString(Randomness.get().nextInt(1000));
        SearchContext searchContext = searchService.createValidationContext(shardSearchLocalRequest, SearchService.NO_TIMEOUT);
    ValidateQueryResponse,
                    null
        });
 * Modifications Copyright OpenSearch Contributors. See
    }
            transportService,
 * Transport Action to Validate a Query
        Query query = context.query();
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at
                    if (queryExplanations == null) {
import org.opensearch.search.SearchService;
    protected ShardValidateQueryResponse shardOperation(ShardValidateQueryRequest request, Task task) throws IOException {
            searchContext.preProcess(request.rewrite());
 * SPDX-License-Identifier: Apache-2.0
    @Inject
            return query.toString();
            ValidateQueryRequest::new,
            }
        } catch (QueryShardException | ParsingException e) {
        AtomicReferenceArray shardsResponses,
