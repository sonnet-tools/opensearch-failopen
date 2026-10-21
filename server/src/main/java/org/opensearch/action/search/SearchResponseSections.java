/**
import org.opensearch.core.ParseField;
import org.opensearch.search.profile.SearchProfileShardResults;
        int numReducePhases,
        if (suggest != null) {
 * <p>
 * compatible open source license.
        boolean timedOut,
        }
 * license agreements. See the NOTICE file distributed with
     *
 * software distributed under the License is distributed on an
package org.opensearch.action.search;
 *
    /**
        Boolean terminatedEarly,
 * Modifications Copyright OpenSearch Contributors. See
        return numReducePhases;
        int numReducePhases,
            profileResults,
        Aggregations aggregations,
        this.timedOut = timedOut;
            suggest,
        Suggest suggest,
        SearchHits hits,
        this.processorResult.addAll(processorResult);
    }
    public final Boolean terminatedEarly() {
        return this.terminatedEarly;
    public final boolean timedOut() {
    protected final SearchHits hits;
 *
     * Returns the profile results for this search response (including all shards).
import org.opensearch.search.SearchHits;
 */
import java.util.Objects;
        }
        this.suggest = suggest;
        Aggregations aggregations,
 * You may obtain a copy of the License at
        if (aggregations != null) {
     * Returns the number of reduce phases applied to obtain this search response
 * Unless required by applicable law or agreed to in writing,
    }
 * SPDX-License-Identifier: Apache-2.0
     * An empty map is returned if profiling was not enabled
            terminatedEarly,
/*
        Aggregations aggregations,
import java.util.Collections;
     */
 * GitHub history for details.
import org.opensearch.search.aggregations.Aggregations;
    public SearchResponseSections(
 *
 * ownership. Elasticsearch licenses this file to you under
    protected void writeTo(StreamOutput out) throws IOException {
import java.util.List;
            return Collections.emptyMap();
public class SearchResponseSections implements ToXContentFragment {
import org.opensearch.common.annotation.PublicApi;
    public List<ProcessorExecutionDetail> getProcessorResult() {
            suggest.toXContent(builder, params);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
        );
        if (profileResults == null) {
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api
        }
    }
    }
        }
import org.opensearch.search.pipeline.ProcessorExecutionDetail;
    }
        if (!searchExtBuilders.isEmpty()) {
 * the Apache License, Version 2.0 (the "License"); you may
            suggest,
}
            profileResults,
 * shared between core and client.
            aggregations,
    public final Aggregations aggregations() {
    public final SearchHits hits() {
                searchExtBuilder.toXContent(builder, params);
            builder.field(PROCESSOR_RESULT_FIELD.getPreferredName(), processorResult);
            Collections.emptyList(),
    public SearchResponseSections(
    ) {
        return Collections.unmodifiableList(this.searchExtBuilders);
 * Licensed to Elasticsearch under one or more contributor
 */
 * to parse aggregations into, which are not serializable. This is the common part that can be
    public static final ParseField EXT_FIELD = new ParseField("ext");
    protected final SearchProfileShardResults profileResults;
    ) {
 * The OpenSearch Contributors require contributions made to
        boolean timedOut,
import org.opensearch.core.xcontent.XContentBuilder;
            Collections.emptyList()
    public static final ParseField PROCESSOR_RESULT_FIELD = new ParseField("processor_results");
            for (SearchExtBuilder searchExtBuilder : searchExtBuilders) {
 * this work for additional information regarding copyright
        SearchHits hits,
        Boolean terminatedEarly,
        List<SearchExtBuilder> searchExtBuilders
import org.opensearch.search.SearchExtBuilder;
    public final int getNumReducePhases() {
import org.opensearch.search.profile.ProfileShardResult;
            aggregations,
        return aggregations;
    protected final Aggregations aggregations;
@PublicApi(since = "1.0.0")
    protected final Suggest suggest;
        SearchProfileShardResults profileResults,
    }
        throw new UnsupportedOperationException();
    protected final List<SearchExtBuilder> searchExtBuilders = new ArrayList<>();
 */
            searchExtBuilders,
            hits,
            numReducePhases,
    ) {
        this.numReducePhases = numReducePhases;
        boolean timedOut,
            profileResults.toXContent(builder, params);
import java.io.IOException;
        return hits;
            timedOut,
/*
import org.opensearch.search.suggest.Suggest;
        return builder;
    public final XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            aggregations.toXContent(builder, params);
        SearchProfileShardResults profileResults,
import java.util.Map;
    @Override
        return suggest;
        return profileResults.getShardResults();
    }
    }
 * not use this file except in compliance with the License.
     */
        if (!processorResult.isEmpty()) {
            builder.endObject();
 * Base class that holds the various sections which a search response is
        List<ProcessorExecutionDetail> processorResult
    public List<SearchExtBuilder> getSearchExtBuilders() {
import java.util.ArrayList;
        this(
        Suggest suggest,
            numReducePhases,
    }
     * @return Profile results
 * The reason why this class exists is that the high level REST client uses its own classes
    protected final List<ProcessorExecutionDetail> processorResult = new ArrayList<>();
        if (profileResults != null) {
 * composed of (hits, aggs, suggestions etc.) and allows to retrieve them.
        SearchProfileShardResults profileResults,
            terminatedEarly,
        Boolean terminatedEarly,
    public SearchResponseSections(
        SearchHits hits,
    /**
        this.searchExtBuilders.addAll(Objects.requireNonNull(searchExtBuilders, "searchExtBuilders must not be null"));
    }
            hits,
            timedOut,
        return this.timedOut;
 * KIND, either express or implied.  See the License for the
        this.terminatedEarly = terminatedEarly;
/*
        List<SearchExtBuilder> searchExtBuilders,
    }
    protected final boolean timedOut;
        this(
    public final Suggest suggest() {
    public final Map<String, ProfileShardResult> profile() {
 * specific language governing permissions and limitations
        hits.toXContent(builder, params);
        this.profileResults = profileResults;
        this.aggregations = aggregations;
            }
import org.opensearch.core.common.io.stream.StreamOutput;
        }
 * this file be licensed under the Apache-2.0 license or a
        );
            Collections.emptyList()
    }
            builder.startObject(EXT_FIELD.getPreferredName());
    protected final int numReducePhases;
        Suggest suggest,
    }
 */
        return processorResult;
        int numReducePhases
    protected final Boolean terminatedEarly;
 *
import org.opensearch.core.xcontent.ToXContentFragment;
        this.hits = hits;
