        return profileResults.getShardResults();  
        SearchProfileShardResults profileResults,
    public final Map<String, ProfileShardResult> profile() {
/**  
import java.util.Objects;
    protected final SearchHits hits;  
 * SPDX-License-Identifier: Apache-2.0
        SearchProfileShardResults profileResults,
        SearchHits hits,
     */
        this.numReducePhases = numReducePhases;
 */  
    public final SearchHits hits() {
 * KIND, either express or implied.  See the License for the
        List<ProcessorExecutionDetail> processorResult
import org.opensearch.core.common.io.stream.StreamOutput;  
        SearchProfileShardResults profileResults,  
            suggest,
        Aggregations aggregations,
        return builder;
        int numReducePhases
            builder.endObject();
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *
    }  
        this.processorResult.addAll(processorResult);
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        int numReducePhases,
 * this work for additional information regarding copyright
        );
            aggregations,  
    public static final ParseField PROCESSOR_RESULT_FIELD = new ParseField("processor_results");
        this.profileResults = profileResults;
    }  
        if (!processorResult.isEmpty()) {
        Aggregations aggregations,
 * @opensearch.api
        return processorResult;
 * the Apache License, Version 2.0 (the "License"); you may
        this.timedOut = timedOut;
 * ownership. Elasticsearch licenses this file to you under  
    public SearchResponseSections(  
            builder.startObject(EXT_FIELD.getPreferredName());
            terminatedEarly,  
    public List<SearchExtBuilder> getSearchExtBuilders() {
    public final Aggregations aggregations() {
            timedOut,
        return this.timedOut;  
            }
            profileResults,
 * this file be licensed under the Apache-2.0 license or a
    protected void writeTo(StreamOutput out) throws IOException {
        this.searchExtBuilders.addAll(Objects.requireNonNull(searchExtBuilders, "searchExtBuilders must not be null"));  
     * Returns the profile results for this search response (including all shards).  
    protected final int numReducePhases;  
        boolean timedOut,
            timedOut,
        this(
    public final Boolean terminatedEarly() {  
 * You may obtain a copy of the License at  
            return Collections.emptyMap();
        boolean timedOut,
    public final Suggest suggest() {  
        this(
            numReducePhases,
            aggregations.toXContent(builder, params);
    protected final Suggest suggest;
        Boolean terminatedEarly,
 * Unless required by applicable law or agreed to in writing,
        hits.toXContent(builder, params);
    public final int getNumReducePhases() {
import java.util.ArrayList;  
        return this.terminatedEarly;
import org.opensearch.core.ParseField;
    protected final Aggregations aggregations;
            hits,
 *     http://www.apache.org/licenses/LICENSE-2.0
            suggest.toXContent(builder, params);
    }
 */  
 * composed of (hits, aggs, suggestions etc.) and allows to retrieve them.
        );
        this.suggest = suggest;  
     */  
    }
    @Override  
        this.hits = hits;
import java.util.List;
package org.opensearch.action.search;
        this.aggregations = aggregations;
        this.terminatedEarly = terminatedEarly;  
            Collections.emptyList()
    }  
        }
        Suggest suggest,
            searchExtBuilders,  
    /**
import java.util.Collections;
    public List<ProcessorExecutionDetail> getProcessorResult() {  
        SearchHits hits,  
        }
    }
    ) {  
    public static final ParseField EXT_FIELD = new ParseField("ext");
 * The OpenSearch Contributors require contributions made to  
 * The reason why this class exists is that the high level REST client uses its own classes
        SearchHits hits,
 */
            aggregations,  
        if (profileResults != null) {  
        return hits;
import org.opensearch.common.annotation.PublicApi;
    public SearchResponseSections(
 *
 * compatible open source license.
        List<SearchExtBuilder> searchExtBuilders,
 * software distributed under the License is distributed on an
        }  
        if (suggest != null) {  
                searchExtBuilder.toXContent(builder, params);  
 * under the License.  
        Suggest suggest,
import org.opensearch.search.aggregations.Aggregations;
            hits,
/*
        }
    protected final SearchProfileShardResults profileResults;  
    ) {  
        }
    }  
        return numReducePhases;
        return aggregations;  
    }
    }  
        if (profileResults == null) {  
    }  
    }
            profileResults,
        if (!searchExtBuilders.isEmpty()) {  
import org.opensearch.search.profile.SearchProfileShardResults;
        Boolean terminatedEarly,  
    /**
        boolean timedOut,  
    protected final List<SearchExtBuilder> searchExtBuilders = new ArrayList<>();
 * license agreements. See the NOTICE file distributed with
        int numReducePhases,  
    }
            terminatedEarly,  
     * Returns the number of reduce phases applied to obtain this search response
public class SearchResponseSections implements ToXContentFragment {
            Collections.emptyList(),  
import org.opensearch.search.SearchHits;
     * An empty map is returned if profiling was not enabled
            for (SearchExtBuilder searchExtBuilder : searchExtBuilders) {
    }
    public final boolean timedOut() {
            builder.field(PROCESSOR_RESULT_FIELD.getPreferredName(), processorResult);  
            profileResults.toXContent(builder, params);
        throw new UnsupportedOperationException();
            numReducePhases,
    ) {  
 * Modifications Copyright OpenSearch Contributors. See
        return Collections.unmodifiableList(this.searchExtBuilders);  
        }
@PublicApi(since = "1.0.0")
 * <p>  
 * Licensed to Elasticsearch under one or more contributor  
 */  
}
import org.opensearch.core.xcontent.XContentBuilder;
        Boolean terminatedEarly,
import java.io.IOException;
        return suggest;
        Aggregations aggregations,  
import org.opensearch.search.SearchExtBuilder;  
import org.opensearch.search.suggest.Suggest;  
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * Base class that holds the various sections which a search response is
    public SearchResponseSections(
        List<SearchExtBuilder> searchExtBuilders
    protected final Boolean terminatedEarly;
import org.opensearch.core.xcontent.ToXContentFragment;
        if (aggregations != null) {  
/*  
 *  
import org.opensearch.search.pipeline.ProcessorExecutionDetail;  
            Collections.emptyList()
     * @return Profile results  
 * shared between core and client.  
 * to parse aggregations into, which are not serializable. This is the common part that can be
        Suggest suggest,  
    protected final List<ProcessorExecutionDetail> processorResult = new ArrayList<>();
import java.util.Map;  
            suggest,
import org.opensearch.search.profile.ProfileShardResult;
 *
/*  
    protected final boolean timedOut;
 *
    }
