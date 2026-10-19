 */  
        return result.fetchResult();
    }
 * under the License.  
    public ScrollQueryFetchSearchResult(StreamInput in) throws IOException {  
    public void setSearchShardTarget(SearchShardTarget shardTarget) {
 * GitHub history for details.
    }
/**  
    @Override
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 *  
    }
    public void setShardIndex(int shardIndex) {
    }
    public QueryFetchSearchResult result() {  
 * compatible open source license.
import org.opensearch.search.query.QuerySearchResult;
 * this file be licensed under the Apache-2.0 license or a
        result = new QueryFetchSearchResult(in);  
        getSearchShardTarget().writeTo(out);
 */  
 * Unless required by applicable law or agreed to in writing,
        result.setShardIndex(shardIndex);
    @Override
 * this work for additional information regarding copyright
/*  
/*
    public QuerySearchResult queryResult() {
        super(in);
 */
 *
    public FetchSearchResult fetchResult() {
        super.setSearchShardTarget(shardTarget);  
    public void writeTo(StreamOutput out) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
import java.io.IOException;
        return result.queryResult();  
 */
 * license agreements. See the NOTICE file distributed with
 *
    public ScrollQueryFetchSearchResult(QueryFetchSearchResult result, SearchShardTarget shardTarget) {
    }  
import org.opensearch.search.SearchPhaseResult;  
        result.setSearchShardTarget(shardTarget);
 * Licensed to Elasticsearch under one or more contributor  
        setSearchShardTarget(shardTarget);  
}
    }  
 * @opensearch.internal  
import org.opensearch.search.SearchShardTarget;
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    }
 * Scroll fetch result
        this.result = result;
 * SPDX-License-Identifier: Apache-2.0
 *
        setSearchShardTarget(searchShardTarget);
        super.setShardIndex(shardIndex);  
/*  
package org.opensearch.search.fetch;
 * ownership. Elasticsearch licenses this file to you under  
        result.writeTo(out);
public final class ScrollQueryFetchSearchResult extends SearchPhaseResult {
    private final QueryFetchSearchResult result;
    @Override
    @Override  
 * specific language governing permissions and limitations
        return result;
        SearchShardTarget searchShardTarget = new SearchShardTarget(in);
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
