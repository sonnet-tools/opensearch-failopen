                if (phaseTookMap.containsKey(searchPhaseName.getName())) {  
                } else if (NUM_REDUCE_PHASES.match(currentFieldName, parser.getDeprecationHandler())) {
    }
                        } else {
                builder.endObject();
    public SearchResponseSections getInternalResponse() {  
     * Holds info about the clusters that the search was executed on: how many in total, how many of them were successful
        RestActions.buildBroadcastShardsHeader(  
     *  
                            extSectionName = parser.currentName();
        this(
                                            + "different writeable name compared to the name of the section that it was parsed from: found ["
import org.opensearch.core.xcontent.MediaTypeRegistry;
    ) {  
        out.writeVInt(successfulShards);  
    public Clusters getClusters() {  
    }
    public ShardSearchFailure[] getShardFailures() {
                } else if (Aggregations.AGGREGATIONS_FIELD.equals(currentFieldName)) {
            null,
                            } catch (final IllegalArgumentException ex) {  
    public String pointInTimeId() {
     */
    public int getFailedShards() {
    public SearchHits getHits() {
        return Strings.toString(MediaTypeRegistry.JSON, this);  
     * The successful number of shards the search was executed on.  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
        List<ShardSearchFailure> failures = new ArrayList<>();
import org.opensearch.core.xcontent.XContentBuilder;
        return shardFailures.length;
}
    @Override
            + scrollId
            aggs,  
                + " skipped: "
                    numReducePhases = parser.intValue();  
                                if (!searchExtBuilder.getWriteableName().equals(extSectionName)) {  
        int size = in.readVInt();
        return builder;  
     * If profiling was enabled, this returns an object containing the profile results from  
    }
    }
    public int getNumReducePhases() {
        Boolean terminatedEarly = null;
        static final ParseField SKIPPED_FIELD = new ParseField("skipped");
        );  
        // count it in the successful counter  
                            } else if (RestActions.SKIPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
     * The failed number of shards the search was executed on.
    }  
        return innerFromXContent(parser);  
            }  
        ShardSearchFailure[] shardFailures,  
        PhaseTook phaseTook,
 *  
     * The search hits.
import org.opensearch.core.common.io.stream.Writeable;  
    /**
        public int getSuccessful() {
        private final int total;
            InternalAggregations.EMPTY,
                                            + "]"  
    }  
        assert scrollId == null || pointInTimeId == null : "SearchResponse can't have both scrollId ["  
import org.opensearch.search.SearchExtBuilder;
        Clusters clusters
    @PublicApi(since = "1.0.0")  
            }  
     * @return The profile results or an empty map  
                    scrollId = parser.text();
                    }
        SearchHits searchHits = new SearchHits(new SearchHit[0], new TotalHits(0L, TotalHits.Relation.EQUAL_TO), Float.NaN);
                    }
import org.opensearch.core.common.io.stream.StreamOutput;
 *
            scrollId,
                        } else if (token == Token.START_ARRAY) {
        @Override
    /**  
 * You may obtain a copy of the License at  
        );
/*  
                return true;
     */
     */
     *
            internalResponse,  
    public String getScrollId() {  
            if (token == Token.FIELD_NAME) {
                    }
        int totalShards,
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    private static final ParseField SCROLL_ID = new ParseField("_scroll_id");  
    private final String scrollId;
        int totalShards,  
        /**
                    int total = -1;
            for (int i = 0; i < shardFailures.length; i++) {
            if (this == o) {  
     * @see Clusters
                            currentFieldName = parser.currentName();
    }
 *
        SearchResponseSections internalResponse,  
                                        "The parsed ["
                        if (token == XContentParser.Token.FIELD_NAME) {  
                            try {  
    public PhaseTook getPhaseTook() {  
     */  
     * Returns info about what clusters the search was executed against. Available only in responses obtained
        return internalResponse.getNumReducePhases();
import org.opensearch.search.aggregations.Aggregations;
            clusters,  
                    Map<String, Long> phaseTookMap = new HashMap<>();  
     */
    public void writeTo(StreamOutput out) throws IOException {  
                            }  
    public int getSkippedShards() {  
                + " successful: "
                return false;
        totalShards = in.readVInt();  
        Aggregations aggs = null;
import org.opensearch.core.action.ActionResponse;
        return new TimeValue(tookInMillis);  
            processorResult
 * GitHub history for details.
                            parser.skipChildren();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.total = total;  
            } else if (token.isValue()) {  
    /**
        long tookInMillis,
                        } else if (token.isValue()) {
                return true;
                    clusters = new Clusters(total, successful, skipped);
                            }  
            assert total >= 0 && successful >= 0 && skipped >= 0 : "total: "  
                    suggest = Suggest.fromXContent(parser);
        public int hashCode() {
 * ownership. Elasticsearch licenses this file to you under  
    @Override
        }  
        List<SearchExtBuilder> extBuilders = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
                                }  
            searchResponseSections,
import org.apache.lucene.search.TotalHits;
                } else if (PhaseTook.PHASE_TOOK.match(currentFieldName, parser.getDeprecationHandler())) {
    @Nullable
        ShardSearchFailure[] shardFailures,  
import java.util.Locale;
        SearchResponseSections searchResponseSections = new SearchResponseSections(
            getFailedShards(),  
import static org.opensearch.action.search.SearchResponseSections.EXT_FIELD;  
    private static final ParseField TERMINATED_EARLY = new ParseField("terminated_early");
        return internalResponse.profile();
        if (pointInTimeId != null) {
            return builder;
        long tookInMillis = -1;
 * software distributed under the License is distributed on an
        ShardSearchFailure[] shardFailures,
     */
        }
            getShardFailures()
    public static SearchResponse innerFromXContent(XContentParser parser) throws IOException {  
import java.util.List;  
                                searchExtBuilder = GenericSearchExtBuilder.fromXContent(parser);
            timedOut,
import org.opensearch.common.unit.TimeValue;
     * The total number of shards the search was executed on.
            shardFailures,
                    tookInMillis = parser.longValue();  
                                parser.intValue(); // we don't need it but need to consume it
                                parser.skipChildren();
        internalResponse = new InternalSearchResponse(in);
            phaseTook,
            this.skipped = skipped;
            if (o == null || getClass() != o.getClass()) {  
        // we don't return totalShards - successfulShards, we don't count "no shards available" as a failed shard, just don't
        public Map<String, Long> getPhaseTookMap() {  
        if (size == 0) {  
import org.opensearch.search.pipeline.ProcessorExecutionDetail;
                        }
     * Returns the number of reduce phases applied to obtain this search response
            shardFailures = new ShardSearchFailure[size];  
            } else if (token == Token.START_OBJECT) {
                                while ((token = parser.nextToken()) != Token.END_ARRAY) {
                    terminatedEarly = parser.booleanValue();
     * @opensearch.api
        int successfulShards,
        }  
 * KIND, either express or implied.  See the License for the
        String scrollId,
        return new SearchResponse(  
    private static final ParseField POINT_IN_TIME_ID = new ParseField("pit_id");
     */
        private Clusters(StreamInput in) throws IOException {
                            }
        Suggest suggest = null;
import org.opensearch.core.rest.RestStatus;
    }
        /**  
            clusters,
            return Objects.hash(total, successful, skipped);  
    }
                    phaseTook = new PhaseTook(phaseTookMap);
            0,
            + pointInTimeId  
            Clusters clusters = (Clusters) o;  
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                            }
 * compatible open source license.
            extBuilders,  
        int successfulShards = -1;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        scrollId = in.readOptionalString();  
    }  
            phaseTook.toXContent(builder, params);  
            totalShards,  
            getSuccessfulShards(),
import org.opensearch.search.suggest.Suggest;
        return internalResponse.timedOut();
        return this.shardFailures;
        @Override
                    while ((token = parser.nextToken()) != Token.END_ARRAY) {
        innerToXContent(builder, params);
        if (out.getVersion().onOrAfter(Version.V_2_12_0)) {  
        }  
                        processorResult.add(detail);  
 * The OpenSearch Contributors require contributions made to  
        ensureExpectedToken(Token.START_OBJECT, parser.nextToken(), parser);
            ShardSearchFailure.EMPTY_ARRAY,  
     * from a Cross Cluster Search request, otherwise <code>null</code>  
        Clusters clusters,
            }
    public static class Clusters implements ToXContentFragment, Writeable {
import java.util.HashMap;
            getTotalShards(),  
import org.opensearch.core.ParseField;
import java.io.IOException;  
                }
                                skipped = parser.intValue();  
        SearchHits hits = null;  
            suggest,
 * specific language governing permissions and limitations
         */
import org.opensearch.common.Nullable;  
        int numReducePhases = 1;  
    private final int skippedShards;  
import org.opensearch.rest.action.RestActions;
            }
    /**
        this.clusters = clusters;
import java.util.function.Supplier;
import org.opensearch.search.SearchHits;  
        }
            null,
            builder.field(NUM_REDUCE_PHASES.getPreferredName(), getNumReducePhases());
                                    throw new IllegalStateException(
            clusters,
        int skippedShards = 0; // 0 for BWC
                                    );
import org.opensearch.search.profile.SearchProfileShardResults;  
    }
    }
    public static SearchResponse fromXContent(XContentParser parser) throws IOException {  
            out.writeVInt(skipped);
                + " successful: "
        this.pointInTimeId = pointInTimeId;  
        if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
            if (o == null || getClass() != o.getClass()) {  
 * @opensearch.api
        return internalResponse.aggregations();  
                + skipped;
        }
            return "Clusters{total=" + total + ", successful=" + successful + ", skipped=" + skipped + '}';
    /**
                            currentFieldName = parser.currentName();
        return RestStatus.status(successfulShards, totalShards, shardFailures);  
        }  
            if (phaseTook.phaseTookMap.equals(phaseTookMap)) {
            out.writeVInt(successful);  
    /**
        public static final Clusters EMPTY = new Clusters(0, 0, 0);  
        out.writeVInt(totalShards);
    }  
                    profile = SearchProfileShardResults.fromXContent(parser);  
import org.opensearch.search.profile.ProfileShardResult;
                            }
        clusters.writeTo(out);  
        @Override
 */  
     * How long the search took.  
    @Override
    /**
            return Objects.hash(phaseTookMap);
    public Aggregations getAggregations() {
            tookInMillis,
     * The number of shards skipped due to pre-filtering
                                }
        }
            profile,
 * A response of a search request.
                    }  
        long tookInMillis,
        public boolean equals(Object o) {
                    hits = SearchHits.fromXContent(parser);  
    /**
            return total == clusters.total && successful == clusters.successful && skipped == clusters.skipped;
        return builder;  
            }
            totalShards,
        if (scrollId != null) {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     *  
        }
    }
    @PublicApi(since = "1.0.0")  
        return successfulShards;  
        SearchProfileShardResults profile = null;  
        }  
import static org.opensearch.action.search.SearchResponseSections.PROCESSOR_RESULT_FIELD;
        int skippedShards,
                        if (token == Token.FIELD_NAME) {  
            assert successful <= total && skipped == total - successful : "total: "  
            failures.toArray(ShardSearchFailure.EMPTY_ARRAY),
                    builder.field(searchPhaseName.getName(), 0);  
                            } else {
                        }  
                                skippedShards = parser.intValue();
                        }
    public Suggest getSuggest() {  
     * Returns the encoded string of the search context that the search request is used to executed
        String currentFieldName = parser.currentName();
    private static final ParseField NUM_REDUCE_PHASES = new ParseField("num_reduce_phases");
            internalSearchResponse,  
     */  
        SearchResponseSections internalResponse,
                                            + "] expected ["
            phaseTook = null;
     * <code>terminateAfter</code>
            shardFailures = ShardSearchFailure.EMPTY_ARRAY;
        ensureExpectedToken(Token.FIELD_NAME, parser.currentToken(), parser);
                + skipped;
    public String toString() {
        if (getNumReducePhases() != 1) {  
    private final int totalShards;
                } else if (EXT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
     */  
                + " skipped: "
                return true;  
                }
        }
                        } else {
            tookInMillis,  
            false,
        String scrollId = null;  
    public SearchResponse(
    @Override
import org.opensearch.search.SearchHit;
                            extBuilders.add(searchExtBuilder);  
        List<ProcessorExecutionDetail> processorResult = new ArrayList<>();
     */
                                phaseTookMap.put(currentFieldName, parser.longValue());
            return skipped;
                    parser.skipChildren();  
                        ProcessorExecutionDetail detail = ProcessorExecutionDetail.fromXContent(parser);
    }
                        } else if (token.isValue()) {
     * The failures that occurred during the search.
@PublicApi(since = "1.0.0")  
        tookInMillis = in.readVLong();
        public void writeTo(StreamOutput out) throws IOException {
    public static class PhaseTook implements ToXContentFragment, Writeable {
        this.skippedShards = skippedShards;
public class SearchResponse extends ActionResponse implements StatusToXContentObject {
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;
                } else if (Suggest.NAME.equals(currentFieldName)) {  
                            if (RestActions.FAILURES_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        }  
        }  
        out.writeOptionalString(pointInTimeId);
        out.writeVInt(shardFailures.length);
        builder.field(TIMED_OUT.getPreferredName(), isTimedOut());
        String searchContextId = null;
        if (isTerminatedEarly() != null) {  
        Clusters clusters = Clusters.EMPTY;  
    private final SearchResponseSections internalResponse;
            if (total > 0) {  
        String scrollId,  
         */  
        return totalShards;
        return scrollId;
            }  
            this(in.readVInt(), in.readVInt(), in.readVInt());  
        }
                            } else if (RestActions.SUCCESSFUL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            } else {
                                SearchPhaseName.valueOf(currentFieldName.toUpperCase(Locale.ROOT));
            builder,
        @Override
                currentFieldName = parser.currentName();
        clusters.toXContent(builder, params);  
    public RestStatus status() {
                builder.startObject(_CLUSTERS_FIELD.getPreferredName());
        super(in);
        public Clusters(int total, int successful, int skipped) {
            builder.field(TERMINATED_EARLY.getPreferredName(), isTerminatedEarly());
        return pointInTimeId;
import org.opensearch.core.xcontent.XContentParser.Token;
                        } else {  
            PhaseTook phaseTook = (PhaseTook) o;  
        int skippedShards,
     * If scrolling was enabled ({@link SearchRequest#scroll(org.opensearch.search.Scroll)}, the  
                            } catch (XContentParseException e) {  
                + successful  
            out.writeMap(phaseTookMap, StreamOutput::writeString, StreamOutput::writeLong);  
                + total
        @Override  
                    searchContextId = parser.text();
 * license agreements. See the NOTICE file distributed with
    /**  
                        } else {
                    }
        static final ParseField TOTAL_FIELD = new ParseField("total");
            phaseTook = in.readOptionalWriteable(PhaseTook::new);  
            builder.field(SCROLL_ID.getPreferredName(), scrollId);
/*  
        out.writeVInt(skippedShards);  
    }
            return builder;
                return false;
 * Unless required by applicable law or agreed to in writing,
        String scrollId,
        for (Token token = parser.nextToken(); token != Token.END_OBJECT; token = parser.nextToken()) {  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        /**
        successfulShards = in.readVInt();
import org.opensearch.core.xcontent.ToXContentFragment;  
 *  
                } else if (POINT_IN_TIME_ID.match(currentFieldName, parser.getDeprecationHandler())) {  
    private final int successfulShards;
    private final Clusters clusters;
/**
    private static final ParseField TOOK = new ParseField("took");
                                            + "] object has a "
        }
                + successful  
    }
            return total;
        String pointInTimeId
        out.writeOptionalString(scrollId);
            this.successful = successful;
    }
    public SearchResponse(  
        private final Map<String, Long> phaseTookMap;  
        public PhaseTook(Map<String, Long> phaseTookMap) {
     * scroll id that can be used to continue scrolling.
     * each shard.  If profiling was not enabled, this will return null
            params,
        }
                                searchExtBuilder = parser.namedObject(SearchExtBuilder.class, extSectionName, null);
            } else {
                                            + extSectionName
                } else if (PROCESSOR_RESULT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                } else if (RestActions._SHARDS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        assert skippedShards <= totalShards : "skipped: " + skippedShards + " total: " + totalShards;
    /**
        }
    }  
        @Override  
 */  
     */  
        pointInTimeId = in.readOptionalString();
        builder.startObject();  
                builder.field(SUCCESSFUL_FIELD.getPreferredName(), successful);  
        this.scrollId = scrollId;
        private PhaseTook(StreamInput in) throws IOException {  
                } else {
    /**
        long tookInMillis,  
        static final ParseField _CLUSTERS_FIELD = new ParseField("_clusters");
        } else {
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(
                builder.field(SKIPPED_FIELD.getPreferredName(), skipped);
            null,  
    private final ShardSearchFailure[] shardFailures;
        return internalResponse.hits();
        return skippedShards;
            }
 * not use this file except in compliance with the License.
                                totalShards = parser.intValue();
            skippedShards,
        this.phaseTook = phaseTook;  
                    while ((token = parser.nextToken()) != Token.END_OBJECT) {
            builder.startObject(PHASE_TOOK.getPreferredName());  
 * this work for additional information regarding copyright
        }
                        if (token == XContentParser.Token.FIELD_NAME) {
            null,  
            successfulShards,
    private static final ParseField TIMED_OUT = new ParseField("timed_out");  
        @Override
                    builder.field(searchPhaseName.getName(), phaseTookMap.get(searchPhaseName.getName()));
                } else if (SearchProfileShardResults.PROFILE_FIELD.equals(currentFieldName)) {
    private final long tookInMillis;  
            scrollId,
                                total = parser.intValue();
        for (ShardSearchFailure shardSearchFailure : shardFailures) {  
        );
import org.opensearch.common.annotation.PublicApi;
    }
     * @opensearch.api
    public SearchResponse(StreamInput in) throws IOException {  
                } else if (TERMINATED_EARLY.match(currentFieldName, parser.getDeprecationHandler())) {  
        );
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.ArrayList;
     */  
            if (this == o) {  
import org.opensearch.search.internal.InternalSearchResponse;  
                    String extSectionName = null;
                            } else if (Clusters.TOTAL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                shardFailures[i] = ShardSearchFailure.readShardSearchFailure(in);
                    timedOut = parser.booleanValue();
        public boolean equals(Object o) {
import org.opensearch.Version;
                if (SearchHits.Fields.HITS.equals(currentFieldName)) {
                                    failures.add(ShardSearchFailure.fromXContent(parser));
    /**  
                                parser.skipChildren();
 */
            hits,
                    aggs = Aggregations.fromXContent(parser);
                            parser.skipChildren();
    /**
        internalResponse.toXContent(builder, params);
        this(internalResponse, scrollId, totalShards, successfulShards, skippedShards, tookInMillis, null, shardFailures, clusters, null);  
        public int getSkipped() {  
                if (SCROLL_ID.match(currentFieldName, parser.getDeprecationHandler())) {
        String pointInTimeId  
            terminatedEarly,  
        return phaseTook;
        }
            + "]";
        Clusters clusters,
        );
    ) {
            null,
import org.opensearch.core.xcontent.XContentParseException;
        int successfulShards,  
            getSkippedShards(),
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            out.writeOptionalWriteable(phaseTook);
            return successful;  
                    int successful = -1;  
            numReducePhases,
        skippedShards = in.readVInt();
                            if (Clusters.SUCCESSFUL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                                            + searchExtBuilder.getClass().getName()  
    }
        public int hashCode() {
         * Returns how many total clusters were during the execution of the search request
            tookInMillisSupplier.get(),
            0  
        return internalResponse.terminatedEarly();
        }
            }
    public SearchResponse(
    /**  
        boolean timedOut = false;
        private final int skipped;  
                            try {
 * under the License.  
        public String toString() {
         */
     */  
                                successfulShards = parser.intValue();  
import org.opensearch.search.aggregations.InternalAggregations;
                                parser.skipChildren();  
        }
                } else {
        builder.field(TOOK.getPreferredName(), tookInMillis);
            return phaseTookMap;
 * SPDX-License-Identifier: Apache-2.0
         * Returns how many total clusters the search was requested to be executed on
/*
     * How long the request took in each search phase.
        int totalShards = -1;
        return new SearchResponse(
                        if (token == Token.FIELD_NAME) {  
                            } else if (Clusters.SKIPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        int totalShards,
                    parser.skipChildren();
 */
            0,  
        return internalResponse;
        this.successfulShards = successfulShards;  
        return internalResponse.suggest();
                builder.field(TOTAL_FIELD.getPreferredName(), total);
                            currentFieldName = parser.currentName();
        public int getTotal() {
            this.phaseTookMap = phaseTookMap;  
                                parser.skipChildren();
    public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {  
    ) {
                } else if (TIMED_OUT.match(currentFieldName, parser.getDeprecationHandler())) {
     */  
        static final ParseField SUCCESSFUL_FIELD = new ParseField("successful");  
            }
    private final PhaseTook phaseTook;
     * and how many of them were skipped.
        if (phaseTook != null) {
        int skippedShards,  
            shardSearchFailure.writeTo(out);
                        } else if (token.isValue()) {  
        builder.endObject();
     */
        parser.nextToken();
            searchHits,  
import org.opensearch.core.common.io.stream.StreamInput;
    public boolean isTimedOut() {
            + "] and searchContextId ["
        return clusters;
    }  
                            if (RestActions.FAILED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                            SearchExtBuilder searchExtBuilder;  
                    while ((token = parser.nextToken()) != Token.END_OBJECT) {
    public Boolean isTerminatedEarly() {  
            this(in.readMap(StreamInput::readString, StreamInput::readLong));
        }  
    public TimeValue getTook() {
    /**
    public Map<String, ProfileShardResult> getProfileResults() {  
    }
        this.tookInMillis = tookInMillis;
     * Holds info about the clusters that the search was executed on: how many in total, how many of them were successful
            builder.field(POINT_IN_TIME_ID.getPreferredName(), pointInTimeId);
        this.shardFailures = shardFailures;
                            } else if (RestActions.TOTAL_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        PhaseTook phaseTook = null;
                } else if (Clusters._CLUSTERS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }  
    private final String pointInTimeId;  
                }  
    /**
     */
    }
            for (SearchPhaseName searchPhaseName : SearchPhaseName.values()) {
        static final ParseField PHASE_TOOK = new ParseField("phase_took");
        @Override
        }
         * Returns how many total clusters the search was executed successfully on  
import org.opensearch.core.common.Strings;  
        internalResponse.writeTo(out);
            builder.endObject();  
        SearchResponseSections internalResponse,
                                successful = parser.intValue();
            null
package org.opensearch.action.search;
    public int getTotalShards() {
        }
                + total
    }
import org.opensearch.common.xcontent.StatusToXContentObject;  
        int successfulShards,
        private final int successful;
    /**
        this.totalShards = totalShards;
                                            + searchExtBuilder.getWriteableName()  
                            } else {
     * Has the search operation timed out.
    }  
        @Override  
                    int skipped = -1;
        this.internalResponse = internalResponse;
            0,
    }
     * and how many of them were skipped.
        }
    }
        clusters = new Clusters(in);
    }
            skippedShards,
     * Has the search operation terminated early due to reaching  
 * this file be licensed under the Apache-2.0 license or a
        out.writeVLong(tookInMillis);
            out.writeVInt(total);
                return false;
        } else {
import org.opensearch.search.GenericSearchExtBuilder;  
     */
    static SearchResponse empty(Supplier<Long> tookInMillisSupplier, Clusters clusters) {  
                } else {
                            parser.skipChildren();
import org.opensearch.core.xcontent.XContentParser;  
    public int getSuccessfulShards() {
        }
        );
            searchContextId
            pointInTimeId  
                } else if (TOOK.match(currentFieldName, parser.getDeprecationHandler())) {
import java.util.Objects;  
        public void writeTo(StreamOutput out) throws IOException {
                        }  
            successfulShards,  
    }
