        queryResult.writeTo(out);
}
        fetchResult.setShardIndex(requestIndex);
    @Override  
    @Override
 *
    @Override  
        fetchResult.setSearchShardTarget(shardTarget);  
 * not use this file except in compliance with the License.
package org.opensearch.search.fetch;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.SearchShardTarget;
 * license agreements. See the NOTICE file distributed with
    private final QuerySearchResult queryResult;
 *  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public FetchSearchResult fetchResult() {
public final class QueryFetchSearchResult extends SearchPhaseResult {  
import org.opensearch.search.internal.ShardSearchContextId;
    }
        queryResult.setShardIndex(requestIndex);  
        return queryResult.getContextId();  
    public void setShardIndex(int requestIndex) {
 * Query fetch result
        this.queryResult = queryResult;  
 */  
import java.io.IOException;
 */
    public QuerySearchResult queryResult() {
        fetchResult = new FetchSearchResult(in);
    public SearchShardTarget getSearchShardTarget() {
        queryResult = new QuerySearchResult(in);
import org.opensearch.search.SearchPhaseResult;  
import org.opensearch.search.query.QuerySearchResult;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    public void setSearchShardTarget(SearchShardTarget shardTarget) {  
 * this work for additional information regarding copyright
        this.fetchResult = fetchResult;
        return queryResult;  
        super.setShardIndex(requestIndex);
 *  
 */
    public ShardSearchContextId getContextId() {
 * Unless required by applicable law or agreed to in writing,
    @Override
    private final FetchSearchResult fetchResult;  
 * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
/*
    @Override
        return fetchResult;
 *
import org.opensearch.core.common.io.stream.StreamInput;
 * under the License.  
    public void writeTo(StreamOutput out) throws IOException {  
        return queryResult.getSearchShardTarget();
 * ownership. Elasticsearch licenses this file to you under  
    public QueryFetchSearchResult(QuerySearchResult queryResult, FetchSearchResult fetchResult) {
        queryResult.setSearchShardTarget(shardTarget);
 * Licensed to Elasticsearch under one or more contributor  
/**
    }  
/*  
        fetchResult.writeTo(out);
/*  
    }  
    }
        super.setSearchShardTarget(shardTarget);
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
    }
 * compatible open source license.
    public QueryFetchSearchResult(StreamInput in) throws IOException {
    }  
 */  
    }  
        super(in);  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
    }
 * KIND, either express or implied.  See the License for the
    @Override  
