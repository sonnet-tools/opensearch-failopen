        result.setSearchShardTarget(shardTarget);
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
import java.io.IOException;  
    }
 * Unless required by applicable law or agreed to in writing,
    private final QuerySearchResult result;  
 * You may obtain a copy of the License at  
/*
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
 */
}  
import org.opensearch.core.common.io.stream.StreamInput;
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        super.setShardIndex(shardIndex);
        this.result = result;
 * specific language governing permissions and limitations
    @Override
 *  
 * under the License.  
 * Scrolled results from a query search request  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
        setSearchShardTarget(shardTarget);
    }
        getSearchShardTarget().writeTo(out);  
        setSearchShardTarget(shardTarget);  
 */  
/*  
 * SPDX-License-Identifier: Apache-2.0
        result.writeTo(out);
import org.opensearch.search.SearchPhaseResult;  
    }
        SearchShardTarget shardTarget = new SearchShardTarget(in);
        super.setSearchShardTarget(shardTarget);
    public void setShardIndex(int shardIndex) {  
 *
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamOutput;
public final class ScrollQuerySearchResult extends SearchPhaseResult {
    public ScrollQuerySearchResult(QuerySearchResult result, SearchShardTarget shardTarget) {  
    }  
 */  
    }  
 *
    public QuerySearchResult queryResult() {  
 * software distributed under the License is distributed on an
/**
package org.opensearch.search.query;
 * not use this file except in compliance with the License.
        result.setShardIndex(shardIndex);
 *    http://www.apache.org/licenses/LICENSE-2.0
        return result;
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        result = new QuerySearchResult(in);
    public void writeTo(StreamOutput out) throws IOException {
    public void setSearchShardTarget(SearchShardTarget shardTarget) {  
import org.opensearch.search.SearchShardTarget;
    @Override
    }  
 * @opensearch.internal
    public ScrollQuerySearchResult(StreamInput in) throws IOException {
 *
        super(in);  
/*  
 * license agreements. See the NOTICE file distributed with
    @Override
