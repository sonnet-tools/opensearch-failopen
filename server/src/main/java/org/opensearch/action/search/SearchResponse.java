                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
        static final ParseField SKIPPED_FIELD = new ParseField("skipped");
import org.opensearch.core.xcontent.XContentBuilder;
import static org.opensearch.action.search.SearchResponseSections.EXT_FIELD;
            internalResponse,
            getSkippedShards(),
                + " successful: "
import org.opensearch.core.common.io.stream.StreamInput;
        private PhaseTook(StreamInput in) throws IOException {
    /**
     * How long the request took in each search phase.
        return internalResponse.terminatedEarly();
        ShardSearchFailure[] shardFailures,
            scrollId,
        super(in);
            searchHits,
            return total == clusters.total && successful == clusters.successful && skipped == clusters.skipped;
        out.writeOptionalString(scrollId);
        }
    @Nullable
        int totalShards,
                            currentFieldName = parser.currentName();
            }
        return builder;
                            }
        return internalResponse.aggregations();
    }
        public boolean equals(Object o) {
            totalShards,
        if (phaseTook != null) {
    public ShardSearchFailure[] getShardFailures() {
     * The number of shards skipped due to pre-filtering
    }
 * Unless required by applicable law or agreed to in writing,
        Suggest suggest = null;
        private final Map<String, Long> phaseTookMap;
                        if (token == XContentParser.Token.FIELD_NAME) {
    public SearchHits getHits() {
    public int getTotalShards() {
                                            + searchExtBuilder.getWriteableName()
        long tookInMillis,
    public RestStatus status() {
                            try {
        if (size == 0) {
                            extBuilders.add(searchExtBuilder);
            successfulShards,
import org.opensearch.core.rest.RestStatus;
 * license agreements. See the NOTICE file distributed with
                    }
        SearchProfileShardResults profile = null;
        String currentFieldName = parser.currentName();
            ShardSearchFailure.EMPTY_ARRAY,
     * Returns the encoded string of the search context that the search request is used to executed
    @Override
        return skippedShards;
            failures.toArray(ShardSearchFailure.EMPTY_ARRAY),
            if (phaseTook.phaseTookMap.equals(phaseTookMap)) {
    private final long tookInMillis;
import org.opensearch.core.common.io.stream.StreamOutput;
                + successful
     */
        SearchResponseSections internalResponse,
            if (this == o) {
 */
                    while ((token = parser.nextToken()) != Token.END_OBJECT) {
        RestActions.buildBroadcastShardsHeader(
                            } else {
        public PhaseTook(Map<String, Long> phaseTookMap) {
                            currentFieldName = parser.currentName();
            builder.startObject(PHASE_TOOK.getPreferredName());
                        } else if (token.isValue()) {
                } else {
            null
        this.scrollId = scrollId;
            getTotalShards(),
import org.opensearch.search.pipeline.ProcessorExecutionDetail;
        }
            out.writeOptionalWriteable(phaseTook);
        out.writeVInt(skippedShards);
                                        "The parsed ["
                shardFailures[i] = ShardSearchFailure.readShardSearchFailure(in);
    private final int totalShards;
                                searchExtBuilder = GenericSearchExtBuilder.fromXContent(parser);
                    String extSectionName = null;
                } else if (RestActions._SHARDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
                }
     * @return The profile results or an empty map
                    }
            shardFailures,
            out.writeVInt(skipped);
                            }
import org.opensearch.common.unit.TimeValue;
        }
    }
    public static class PhaseTook implements ToXContentFragment, Writeable {
                } else if (PROCESSOR_RESULT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            params,
            this.total = total;
import org.opensearch.core.xcontent.ToXContentFragment;
                            } catch (XContentParseException e) {
        pointInTimeId = in.readOptionalString();
                        }
                            try {
        }
            if (token == Token.FIELD_NAME) {
import org.opensearch.core.action.ActionResponse;
        }
    public Clusters getClusters() {
        assert skippedShards <= totalShards : "skipped: " + skippedShards + " total: " + totalShards;
    static SearchResponse empty(Supplier<Long> tookInMillisSupplier, Clusters clusters) {
            + pointInTimeId
            0,
        public String toString() {
        clusters = new Clusters(in);
 * the Apache License, Version 2.0 (the "License"); you may
        public Clusters(int total, int successful, int skipped) {
    private final ShardSearchFailure[] shardFailures;
    /**
     * and how many of them were skipped.
         * Returns how many total clusters the search was requested to be executed on
import java.util.ArrayList;
     *
        }
                        if (token == XContentParser.Token.FIELD_NAME) {
            null,
         */
        Clusters clusters = Clusters.EMPTY;
            this.skipped = skipped;
        this.shardFailures = shardFailures;
    /**
        int skippedShards,
 * @opensearch.api
    }
        return internalResponse;
                        } else {
     *
    }
            clusters,
        return Strings.toString(MediaTypeRegistry.JSON, this);
     * The total number of shards the search was executed on.
                                parser.skipChildren();
        this.pointInTimeId = pointInTimeId;
     * @see Clusters
            getFailedShards(),
            Clusters clusters = (Clusters) o;
                                while ((token = parser.nextToken()) != Token.END_ARRAY) {
        static final ParseField TOTAL_FIELD = new ParseField("total");
    }
                + " skipped: "
        return builder;
        long tookInMillis,
            0,
    public static SearchResponse fromXContent(XContentParser parser) throws IOException {
    }
        long tookInMillis = -1;
    public int getNumReducePhases() {
     * each shard.  If profiling was not enabled, this will return null
import org.opensearch.rest.action.RestActions;
                builder.endObject();
 * this work for additional information regarding copyright
                } else if (EXT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        scrollId = in.readOptionalString();
        int size = in.readVInt();
            } else if (token == Token.START_OBJECT) {
 * not use this file except in compliance with the License.
            phaseTook = in.readOptionalWriteable(PhaseTook::new);
        String scrollId,
                            } else if (RestActions.SKIPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    suggest = Suggest.fromXContent(parser);
            clusters,
                                successful = parser.intValue();
        private final int successful;
            searchResponseSections,
                                    failures.add(ShardSearchFailure.fromXContent(parser));
 * under the License.
     */
     * If scrolling was enabled ({@link SearchRequest#scroll(org.opensearch.search.Scroll)}, the
    public PhaseTook getPhaseTook() {
            out.writeVInt(successful);
        out.writeVInt(successfulShards);
    private final SearchResponseSections internalResponse;
        List<ProcessorExecutionDetail> processorResult = new ArrayList<>();
    private final Clusters clusters;
/*
import org.opensearch.search.profile.ProfileShardResult;
    }
                            }
                builder.field(SUCCESSFUL_FIELD.getPreferredName(), successful);
        PhaseTook phaseTook,
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
    /**
    }
import org.opensearch.common.Nullable;
                        processorResult.add(detail);
     */
                        }
        }
    }
                                parser.skipChildren();
        Aggregations aggs = null;
        builder.field(TIMED_OUT.getPreferredName(), isTimedOut());
        } else {
            suggest,
import org.opensearch.core.common.io.stream.Writeable;
     * Holds info about the clusters that the search was executed on: how many in total, how many of them were successful
                        } else if (token.isValue()) {
        String pointInTimeId
    }
     */
        out.writeOptionalString(pointInTimeId);
    }
        return clusters;
        }
                    }
                + skipped;
            successfulShards,
        int successfulShards,
        /**
                return false;
            }
    /**
            + "] and searchContextId ["
                + total
            timedOut,
        boolean timedOut = false;
                        if (token == Token.FIELD_NAME) {
        successfulShards = in.readVInt();
        clusters.writeTo(out);
    }
                                parser.skipChildren();
     * scroll id that can be used to continue scrolling.
        }
     */
     */
        @Override
                    builder.field(searchPhaseName.getName(), phaseTookMap.get(searchPhaseName.getName()));
                    timedOut = parser.booleanValue();
                } else if (NUM_REDUCE_PHASES.match(currentFieldName, parser.getDeprecationHandler())) {
     */
 *
 * software distributed under the License is distributed on an
                } else if (TIMED_OUT.match(currentFieldName, parser.getDeprecationHandler())) {
                            if (Clusters.SUCCESSFUL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        public int getSuccessful() {
            assert total >= 0 && successful >= 0 && skipped >= 0 : "total: "
        // we don't return totalShards - successfulShards, we don't count "no shards available" as a failed shard, just don't
                } else if (POINT_IN_TIME_ID.match(currentFieldName, parser.getDeprecationHandler())) {
 * Modifications Copyright OpenSearch Contributors. See
        }
    ) {
        String pointInTimeId
            tookInMillis,
import org.opensearch.search.internal.InternalSearchResponse;
     */
                            } catch (final IllegalArgumentException ex) {
                if (SearchHits.Fields.HITS.equals(currentFieldName)) {
                        } else if (token == Token.START_ARRAY) {
import org.opensearch.core.xcontent.XContentParser.Token;
    }
            } else if (token.isValue()) {
                            } else if (RestActions.SUCCESSFUL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            + "]";
            scrollId,
    public String toString() {
 * You may obtain a copy of the License at
        static final ParseField SUCCESSFUL_FIELD = new ParseField("successful");
                    terminatedEarly = parser.booleanValue();
        }
            null,
        return new TimeValue(tookInMillis);
                    int total = -1;
        int successfulShards,
     * @opensearch.api
            builder.field(SCROLL_ID.getPreferredName(), scrollId);
                                successfulShards = parser.intValue();
/*
                    }
                            } else if (Clusters.SKIPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public int getSuccessfulShards() {
         */
        private final int total;
        private Clusters(StreamInput in) throws IOException {
         */
                    parser.skipChildren();
        public boolean equals(Object o) {
                                    throw new IllegalStateException(
        internalResponse = new InternalSearchResponse(in);
    /**
import org.opensearch.search.SearchExtBuilder;
        @Override
                            } else if (Clusters.TOTAL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            } else {
        PhaseTook phaseTook = null;
        return internalResponse.profile();
            searchContextId
                        }
        List<SearchExtBuilder> extBuilders = new ArrayList<>();
        assert scrollId == null || pointInTimeId == null : "SearchResponse can't have both scrollId ["
        return new SearchResponse(
        this.skippedShards = skippedShards;
                                            + "different writeable name compared to the name of the section that it was parsed from: found ["
        return this.shardFailures;
    /**
    }
                    profile = SearchProfileShardResults.fromXContent(parser);
                if (SCROLL_ID.match(currentFieldName, parser.getDeprecationHandler())) {
            this(in.readVInt(), in.readVInt(), in.readVInt());
import org.opensearch.search.aggregations.InternalAggregations;
    /**
    private final int successfulShards;
            tookInMillisSupplier.get(),
            phaseTook = null;
        clusters.toXContent(builder, params);
                                skippedShards = parser.intValue();
        @Override
            internalSearchResponse,
                                }
                    parser.skipChildren();
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(
/*
     * The failed number of shards the search was executed on.
import java.util.Objects;
 * The OpenSearch Contributors require contributions made to
        return totalShards;
import org.opensearch.search.GenericSearchExtBuilder;
    public boolean isTimedOut() {
            phaseTook.toXContent(builder, params);
                        } else {
        Boolean terminatedEarly = null;
                return false;
        @Override
        if (getNumReducePhases() != 1) {
    }
    /**
    @Override
                    clusters = new Clusters(total, successful, skipped);
        long tookInMillis,
        }
            builder.field(POINT_IN_TIME_ID.getPreferredName(), pointInTimeId);
                return false;
        if (pointInTimeId != null) {
                            if (RestActions.FAILED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            } else if (RestActions.TOTAL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Has the search operation timed out.
/**
        );
        parser.nextToken();
            out.writeVInt(total);
        int skippedShards,
                            parser.skipChildren();
        }
        out.writeVInt(shardFailures.length);
            profile,
    public static SearchResponse innerFromXContent(XContentParser parser) throws IOException {
        builder.endObject();
        return internalResponse.timedOut();
    public Map<String, ProfileShardResult> getProfileResults() {
        SearchHits hits = null;
                return true;
        String searchContextId = null;
            return Objects.hash(phaseTookMap);
                                totalShards = parser.intValue();
        this.phaseTook = phaseTook;
            builder.field(NUM_REDUCE_PHASES.getPreferredName(), getNumReducePhases());
        static final ParseField _CLUSTERS_FIELD = new ParseField("_clusters");
 * compatible open source license.
    }
        ShardSearchFailure[] shardFailures,
        // count it in the successful counter
            for (int i = 0; i < shardFailures.length; i++) {
                            parser.skipChildren();
            return builder;
            processorResult
import org.apache.lucene.search.TotalHits;
                } else if (Suggest.NAME.equals(currentFieldName)) {
                                    );
    public TimeValue getTook() {
 * A response of a search request.
     * Returns info about what clusters the search was executed against. Available only in responses obtained
            if (o == null || getClass() != o.getClass()) {
        return RestStatus.status(successfulShards, totalShards, shardFailures);
    public int getSkippedShards() {
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
                            currentFieldName = parser.currentName();
                    builder.field(searchPhaseName.getName(), 0);
 * ownership. Elasticsearch licenses this file to you under
        int skippedShards = 0; // 0 for BWC
 * SPDX-License-Identifier: Apache-2.0
        );
                }
        @Override
        } else {
            null,
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public int getTotal() {
        );
        @Override
        this.totalShards = totalShards;
    private static final ParseField POINT_IN_TIME_ID = new ParseField("pit_id");
                    }
     */
                } else {
    /**
import java.util.function.Supplier;
        this(
    /**
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                } else if (TOOK.match(currentFieldName, parser.getDeprecationHandler())) {
            shardSearchFailure.writeTo(out);
import java.util.Map;
package org.opensearch.action.search;
        static final ParseField PHASE_TOOK = new ParseField("phase_took");
     * Returns the number of reduce phases applied to obtain this search response
            extBuilders,
        List<ShardSearchFailure> failures = new ArrayList<>();
                        } else {
import java.util.List;
import java.io.IOException;
        totalShards = in.readVInt();
     */
                } else if (Aggregations.AGGREGATIONS_FIELD.equals(currentFieldName)) {
        return internalResponse.hits();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                        } else if (token.isValue()) {
        }
        this.tookInMillis = tookInMillis;
}
            }
            if (o == null || getClass() != o.getClass()) {
import org.opensearch.search.SearchHits;
                + skipped;
import java.util.Locale;
 */
    }
    public Suggest getSuggest() {
        }
                + " skipped: "
                                searchExtBuilder = parser.namedObject(SearchExtBuilder.class, extSectionName, null);
            shardFailures = new ShardSearchFailure[size];
        }
                + " successful: "
                        } else {
        );
    /**
 *
        @Override
public class SearchResponse extends ActionResponse implements StatusToXContentObject {
        return successfulShards;
        @Override
import org.opensearch.common.xcontent.StatusToXContentObject;
    }
        this(internalResponse, scrollId, totalShards, successfulShards, skippedShards, tookInMillis, null, shardFailures, clusters, null);
    public static class Clusters implements ToXContentFragment, Writeable {
            return total;
        }
        }
            skippedShards,
    }
 */
                } else if (PhaseTook.PHASE_TOOK.match(currentFieldName, parser.getDeprecationHandler())) {
                                            + extSectionName
        );
                            } else {
        int totalShards,
    }
    public SearchResponseSections getInternalResponse() {
    ) {
        SearchHits searchHits = new SearchHits(new SearchHit[0], new TotalHits(0L, TotalHits.Relation.EQUAL_TO), Float.NaN);
            }
                    Map<String, Long> phaseTookMap = new HashMap<>();
        SearchResponseSections internalResponse,
        SearchResponseSections searchResponseSections = new SearchResponseSections(
            if (this == o) {
@PublicApi(since = "1.0.0")
    @PublicApi(since = "1.0.0")
     * and how many of them were skipped.
import org.opensearch.Version;
     * If profiling was enabled, this returns an object containing the profile results from
                            }
    }
    }
            aggs,
                            parser.skipChildren();
        builder.startObject();
            return skipped;
        out.writeVLong(tookInMillis);
            return Objects.hash(total, successful, skipped);
            }
        ensureExpectedToken(Token.FIELD_NAME, parser.currentToken(), parser);
                builder.field(TOTAL_FIELD.getPreferredName(), total);
     * <code>terminateAfter</code>
                } else if (TERMINATED_EARLY.match(currentFieldName, parser.getDeprecationHandler())) {
        public static final Clusters EMPTY = new Clusters(0, 0, 0);
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentParser;
                                            + "] expected ["
    private static final ParseField TIMED_OUT = new ParseField("timed_out");
     * The successful number of shards the search was executed on.
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private final String scrollId;
     */
            hits,
        }
                    scrollId = parser.text();
 * Licensed to Elasticsearch under one or more contributor
        SearchResponseSections internalResponse,
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
                    hits = SearchHits.fromXContent(parser);
    public void writeTo(StreamOutput out) throws IOException {
        );
                                }
        tookInMillis = in.readVLong();
        Clusters clusters,
        if (scrollId != null) {
            0
    /**
 *
        /**
        return shardFailures.length;
     */
    }
            numReducePhases,
        int numReducePhases = 1;
            }
        internalResponse.toXContent(builder, params);
    public SearchResponse(
                    phaseTook = new PhaseTook(phaseTookMap);
        int totalShards = -1;
                    numReducePhases = parser.intValue();
        ensureExpectedToken(Token.START_OBJECT, parser.nextToken(), parser);
        for (Token token = parser.nextToken(); token != Token.END_OBJECT; token = parser.nextToken()) {
        internalResponse.writeTo(out);
            pointInTimeId
                            }
     */
    /**
                            extSectionName = parser.currentName();
                                parser.intValue(); // we don't need it but need to consume it
    @Override
                return true;
        public int hashCode() {
        innerToXContent(builder, params);
    }
    private static final ParseField TOOK = new ParseField("took");
    public String pointInTimeId() {
        }
        }
    private static final ParseField TERMINATED_EARLY = new ParseField("terminated_early");
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.SearchHit;
                        ProcessorExecutionDetail detail = ProcessorExecutionDetail.fromXContent(parser);
        out.writeVInt(totalShards);
    }
        int skippedShards,
            }
            clusters,
         * Returns how many total clusters were during the execution of the search request
        @Override
        int successfulShards = -1;
    }
                                parser.skipChildren();
            return "Clusters{total=" + total + ", successful=" + successful + ", skipped=" + skipped + '}';
     * @opensearch.api
            }
            skippedShards,
        return pointInTimeId;
    public Aggregations getAggregations() {
 * KIND, either express or implied.  See the License for the
    private final String pointInTimeId;
    @PublicApi(since = "1.0.0")
import org.opensearch.core.ParseField;
            this.phaseTookMap = phaseTookMap;
import org.opensearch.search.profile.SearchProfileShardResults;
    public SearchResponse(
            phaseTook,
                    while ((token = parser.nextToken()) != Token.END_ARRAY) {
    public SearchResponse(
                    while ((token = parser.nextToken()) != Token.END_OBJECT) {
            return successful;
import org.opensearch.common.annotation.PublicApi;
         * Returns how many total clusters the search was executed successfully on
                                            + searchExtBuilder.getClass().getName()
                return true;
    private static final ParseField NUM_REDUCE_PHASES = new ParseField("num_reduce_phases");
     * The search hits.
        }
        if (isTerminatedEarly() != null) {
 */
 * this file be licensed under the Apache-2.0 license or a
                                if (!searchExtBuilder.getWriteableName().equals(extSectionName)) {
            0,
            + scrollId
        public int getSkipped() {
        String scrollId,
        this.clusters = clusters;
        String scrollId,
            out.writeMap(phaseTookMap, StreamOutput::writeString, StreamOutput::writeLong);
    }
        int successfulShards,
            null,
        return innerFromXContent(parser);
import org.opensearch.search.aggregations.Aggregations;
                                phaseTookMap.put(currentFieldName, parser.longValue());
 * specific language governing permissions and limitations
                                total = parser.intValue();
                                            + "]"
        }
     */
                    tookInMillis = parser.longValue();
            }
        ShardSearchFailure[] shardFailures,
        /**
                                skipped = parser.intValue();
            builder.field(TERMINATED_EARLY.getPreferredName(), isTerminatedEarly());
    /**
     */
        public void writeTo(StreamOutput out) throws IOException {
            if (total > 0) {
        public Map<String, Long> getPhaseTookMap() {
        Clusters clusters,
                builder.startObject(_CLUSTERS_FIELD.getPreferredName());
        return internalResponse.getNumReducePhases();
        private final int skipped;
     * Has the search operation terminated early due to reaching
    public int getFailedShards() {
                if (phaseTookMap.containsKey(searchPhaseName.getName())) {
        public void writeTo(StreamOutput out) throws IOException {
            builder.endObject();
    private final int skippedShards;
     */
     * Holds info about the clusters that the search was executed on: how many in total, how many of them were successful
                        }
    ) {
        return scrollId;
    }
                            } else {
        for (ShardSearchFailure shardSearchFailure : shardFailures) {
            assert successful <= total && skipped == total - successful : "total: "
                                SearchPhaseName.valueOf(currentFieldName.toUpperCase(Locale.ROOT));
    }
    public String getScrollId() {
        this.successfulShards = successfulShards;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
                            SearchExtBuilder searchExtBuilder;
     * from a Cross Cluster Search request, otherwise <code>null</code>
    }
    public SearchResponse(StreamInput in) throws IOException {
            builder,
            this.successful = successful;
     */
            return phaseTookMap;
        skippedShards = in.readVInt();
                builder.field(SKIPPED_FIELD.getPreferredName(), skipped);
        Clusters clusters
                    aggs = Aggregations.fromXContent(parser);
                currentFieldName = parser.currentName();
    private final PhaseTook phaseTook;
            false,
import java.util.HashMap;
                        if (token == Token.FIELD_NAME) {
            InternalAggregations.EMPTY,
            terminatedEarly,
import org.opensearch.core.common.Strings;
                    int successful = -1;
        int totalShards,
                    int skipped = -1;
        }
            shardFailures = ShardSearchFailure.EMPTY_ARRAY;
        return internalResponse.suggest();
     * How long the search took.
        builder.field(TOOK.getPreferredName(), tookInMillis);
import static org.opensearch.action.search.SearchResponseSections.PROCESSOR_RESULT_FIELD;
            null,
        }
                    searchContextId = parser.text();
            tookInMillis,
            getShardFailures()
import org.opensearch.core.xcontent.XContentParseException;
    private static final ParseField SCROLL_ID = new ParseField("_scroll_id");
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
            PhaseTook phaseTook = (PhaseTook) o;
                            if (RestActions.FAILURES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (SearchProfileShardResults.PROFILE_FIELD.equals(currentFieldName)) {
                } else {
     *
    /**
                + total
                }
    public Boolean isTerminatedEarly() {
            return builder;
                + successful
    /**
                                            + "] object has a "
        String scrollId = null;
        public int hashCode() {
import org.opensearch.search.suggest.Suggest;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        return new SearchResponse(
     * The failures that occurred during the search.
            this(in.readMap(StreamInput::readString, StreamInput::readLong));
            totalShards,
                } else if (Clusters._CLUSTERS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    @Override
 *
        this.internalResponse = internalResponse;
            getSuccessfulShards(),
        return phaseTook;
