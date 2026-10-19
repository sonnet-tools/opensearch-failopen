    }  
     */
 *
    }  
    }
    }
    @Nullable
        return searchShardTarget;
     */
        super(in);
        return shardSearchRequest;  
 * license agreements. See the NOTICE file distributed with
    /**
    }
        return null;  
 *
 * this file be licensed under the Apache-2.0 license or a
        return null;
 * @opensearch.api  
 * not use this file except in compliance with the License.
    protected ShardSearchContextId contextId;
 *  
 * GitHub history for details.
 * request ID is particularly important since it is used to reference and maintain a context
import org.opensearch.search.internal.ShardSearchContextId;
    public void writeTo(StreamOutput out) throws IOException {
    private RescoreDocIds rescoreDocIds = RescoreDocIds.EMPTY;  
 */  
    private int shardIndex = -1;  
import org.opensearch.common.Nullable;
 * You may obtain a copy of the License at  
    protected SearchPhaseResult() {
    public RescoreDocIds getRescoreDocIds() {
     * Returns the query result iff it's included in this response otherwise <code>null</code>  
 * ownership. Elasticsearch licenses this file to you under  
    public void setRescoreDocIds(RescoreDocIds rescoreDocIds) {
 * specific language governing permissions and limitations
    public ShardSearchRequest getShardSearchRequest() {
 * KIND, either express or implied.  See the License for the
    public void setShardSearchRequest(ShardSearchRequest shardSearchRequest) {  
 */
import org.opensearch.search.fetch.FetchSearchResult;  
    public QuerySearchResult queryResult() {
        return contextId;
        this.shardSearchRequest = shardSearchRequest;
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
        this.rescoreDocIds = rescoreDocIds;  
        return shardIndex;
 * software distributed under the License is distributed on an
        // TODO: this seems wrong, SearchPhaseResult should have a writeTo?
 * and a request ID that is used to reference the request context on the executing node. The
    }
     */
    protected SearchPhaseResult(StreamInput in) throws IOException {  
    /**  
}
 * This class is a base class for all search related results. It contains the shard target it
    public FetchSearchResult fetchResult() {  
/*
    private ShardSearchRequest shardSearchRequest;
 * across search phases to ensure the same point in time snapshot is used for querying and  
 * SPDX-License-Identifier: Apache-2.0
    public ShardSearchContextId getContextId() {  
 * under the License.  
 */  
     * Returns the fetch result iff it's included in this response otherwise <code>null</code>
    }  
    }  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
     * or <code>null</code> if no context was created.  
/*  
/*  
 * Modifications Copyright OpenSearch Contributors. See
    public int getShardIndex() {
    }
 * fetching etc.
     * used for accounting on the coordinating node  
        assert shardIndex >= 0 : "shardIndex must be >= 0 but was: " + shardIndex;
import org.opensearch.core.transport.TransportResponse;
    /**
public abstract class SearchPhaseResult extends TransportResponse {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Nullable
     */
 * the Apache License, Version 2.0 (the "License"); you may
        return rescoreDocIds;
/**
 * was executed against, a shard index used to reference the result on the coordinating node  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.search.internal.ShardSearchRequest;
    public SearchShardTarget getSearchShardTarget() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
 */
import org.opensearch.common.annotation.PublicApi;
@PublicApi(since = "1.0.0")
import org.opensearch.search.query.QuerySearchResult;  
    }
    }
    }
    private SearchShardTarget searchShardTarget;
    }
        this.shardIndex = shardIndex;
    public void setShardIndex(int shardIndex) {  
     * Returns the search context ID that is used to reference the search context on the executing node
package org.opensearch.search;
 *
 * this work for additional information regarding copyright
        assert shardIndex != -1 : "shardIndex is not set";  
 * Licensed to Elasticsearch under one or more contributor  
     * Returns the shard index in the context of the currently executing search request that is
 * compatible open source license.
    }
        this.searchShardTarget = shardTarget;  
    public void setSearchShardTarget(SearchShardTarget shardTarget) {
 * Unless required by applicable law or agreed to in writing,
