 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
 */  
        super(in);
 *
package org.opensearch.search.fetch;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.SearchHits;  
import org.opensearch.search.SearchShardTarget;
        return this;
    }
        return null;  
    }  
    public FetchSearchResult(StreamInput in) throws IOException {  
 *  
 * not use this file except in compliance with the License.
    }
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        contextId = new ShardSearchContextId(in);
        return this;
        setSearchShardTarget(shardTarget);
            out.writeOptionalWriteable(profileShardResults);
 *
        if (out.getVersion().onOrAfter(Version.V_3_2_0)) {  
        if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
    public int counterGetAndIncrement() {
    public void writeTo(StreamOutput out) throws IOException {  
 * @opensearch.api  
    }
    }  
        return hits;  
import org.opensearch.search.SearchPhaseResult;
 * Result from a fetch
 * software distributed under the License is distributed on an
    public void hits(SearchHits hits) {
        counter = 0;
 * this work for additional information regarding copyright
 *
    public SearchHits hits() {
 * under the License.  
 * compatible open source license.
        assert assertNoSearchTarget(hits);  
    public void profileResults(ProfileShardResult shardResults) {  
    }  
            profileShardResults = null;
 * license agreements. See the NOTICE file distributed with
    private boolean assertNoSearchTarget(SearchHits hits) {
 */
            profileShardResults = in.readOptionalWriteable(ProfileShardResult::new);
        }
    public FetchSearchResult() {}
        hits = new SearchHits(in);  
        this.profileShardResults = shardResults;
}
        return profileShardResults;
        this.hits = hits;
 * GitHub history for details.
    }
/*
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
        contextId.writeTo(out);
/*  
    }  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
    }  
@PublicApi(since = "1.0.0")
    private transient int counter;
import org.opensearch.Version;
import org.opensearch.search.internal.ShardSearchContextId;  
    public QuerySearchResult queryResult() {
import org.opensearch.common.annotation.PublicApi;
public final class FetchSearchResult extends SearchPhaseResult {  
import org.opensearch.search.query.QuerySearchResult;
    // client side counter  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        return true;
 * Licensed to Elasticsearch under one or more contributor  
        for (SearchHit hit : hits.getHits()) {
    public FetchSearchResult fetchResult() {
    public FetchSearchResult initCounter() {  
import org.opensearch.search.profile.ProfileShardResult;
    @Override
        this.contextId = id;  
        hits.writeTo(out);
            assert hit.getShard() == null : "expected null but got: " + hit.getShard();  
        } else {  
        }
import org.opensearch.search.SearchHit;
/*  
    private ProfileShardResult profileShardResults;
    @Override
    }
    }
    private SearchHits hits;
    public ProfileShardResult getProfileResults() {
 * this file be licensed under the Apache-2.0 license or a
    }  
    public FetchSearchResult(ShardSearchContextId id, SearchShardTarget shardTarget) {
        return counter++;  
        }
 * You may obtain a copy of the License at  
/**  
 * specific language governing permissions and limitations
