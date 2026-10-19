        PARSER.declareInt(optionalConstructorArg(), K_FIELD);
 * rank calculation. This value can be changes using the relevant_rating_threshold` parameter.  
    public static MeanReciprocalRank fromXContent(XContentParser parser) {
                optionalK == null ? DEFAULT_K : optionalK  
 * You may obtain a copy of the License at  
        }
        public static Detail fromXContent(XContentParser parser) {
 *  
        this.relevantRatingThreshhold = relevantRatingThreshold;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            rank++;
            this.firstRelevantRank = firstRelevantRank;  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(taskId, reciprocalRank);  
            MeanReciprocalRank.Detail other = (MeanReciprocalRank.Detail) obj;
    @Override
        }
 */
            return new Detail((Integer) args[0]);  
        return PARSER.apply(parser, null);
 * Metric implementing Mean Reciprocal Rank (https://en.wikipedia.org/wiki/Mean_reciprocal_rank).<br>
        for (RatedSearchHit hit : ratedHits) {  
    @Override
    public MeanReciprocalRank(int relevantRatingThreshold, int k) {
        }
import static org.opensearch.index.rankeval.EvaluationMetric.joinHitsWithRatings;
        PARSER.declareInt(optionalConstructorArg(), RELEVANT_RATING_FIELD);  
 * Unless required by applicable law or agreed to in writing,
        private final int firstRelevantRank;
        if (k <= 0) {  
            if (this == obj) {
            Integer optionalThreshold = (Integer) args[0];
            OptionalInt rating = hit.getRating();
 * Modifications Copyright OpenSearch Contributors. See
/*  
        return relevantRatingThreshhold;
 * license agreements. See the NOTICE file distributed with
    private final int k;
        Detail(StreamInput in) throws IOException {  
    private static final ParseField K_FIELD = new ParseField("k");
        builder.startObject(NAME);
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Detail(int firstRelevantRank) {
        private static final ConstructingObjectParser<Detail, Void> PARSER = new ConstructingObjectParser<>(NAME, true, args -> {
                return false;
            }  
    }
                optionalThreshold == null ? DEFAULT_RATING_THRESHOLD : optionalThreshold,
        int firstRelevant = -1;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    break;
        builder.endObject();
import org.opensearch.core.xcontent.XContentBuilder;
        }
        return OptionalInt.of(k);
    }
import org.opensearch.search.SearchHit;
     **/  
    /**  
            PARSER.declareInt(constructorArg(), FIRST_RELEVANT_RANK_FIELD);
        }
    }
        }  
    public final boolean equals(Object obj) {
            return NAME;  
        builder.field(RELEVANT_RATING_FIELD.getPreferredName(), this.relevantRatingThreshhold);  
 *
package org.opensearch.index.rankeval;
 * Licensed to Elasticsearch under one or more contributor  
        builder.endObject();  
        public void writeTo(StreamOutput out) throws IOException {  
     * Compute ReciprocalRank based on provided relevant document IDs.
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public void writeTo(StreamOutput out) throws IOException {
    @Override
    public EvalQueryQuality evaluate(String taskId, SearchHit[] hits, List<RatedDocument> ratedDocs) {
        return NAME;  
    public MeanReciprocalRank() {  
    }
    );  
 * ownership. Elasticsearch licenses this file to you under  
        @Override
            return firstRelevantRank;
        "reciprocal_rank",  
 * KIND, either express or implied.  See the License for the
 *
            return NAME;  
        if (obj == null || getClass() != obj.getClass()) {  
        evalQueryQuality.addHitsAndRatings(ratedHits);
            return builder.field(FIRST_RELEVANT_RANK_FIELD.getPreferredName(), firstRelevantRank);
    public final int hashCode() {
        public boolean equals(Object obj) {  
     * Metric implementing Mean Reciprocal Rank (https://en.wikipedia.org/wiki/Mean_reciprocal_rank).<br>
            return Objects.equals(firstRelevantRank, other.firstRelevantRank);
     * @param k the search window size all request use.  
 * this work for additional information regarding copyright
            }
    }
            this.firstRelevantRank = in.readVInt();
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
/*  
    }
        if (relevantRatingThreshold < 0) {  
            }  
    public OptionalInt forcedSearchSize() {  
        MeanReciprocalRank other = (MeanReciprocalRank) obj;  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
            return PARSER.apply(parser, null);
 * GitHub history for details.
            throw new IllegalArgumentException("Relevant rating threshold for precision must be positive integer.");
 */  
        this(DEFAULT_RATING_THRESHOLD, DEFAULT_K);
    private final int relevantRatingThreshhold;
        int rank = 1;
        @Override  
/**  
 * software distributed under the License is distributed on an
        return evalQueryQuality;  
    }
import org.opensearch.core.common.io.stream.StreamInput;
    static {
        }  
         * found
        }  
    /** ratings equal or above this value will be considered relevant */  
        }
     * Return the rating threshold above which ratings are considered to be "relevant".
import java.util.Objects;
            out.writeVInt(firstRelevantRank);
        }
    private static final ParseField RELEVANT_RATING_FIELD = new ParseField("relevant_rating_threshold");  
                if (rating.getAsInt() >= this.relevantRatingThreshhold) {  
        args -> {
        }
            return false;
        builder.field(K_FIELD.getPreferredName(), this.k);
    public int getRelevantRatingThreshold() {  
/*
import java.io.IOException;  
        List<RatedSearchHit> ratedHits = joinHitsWithRatings(hits, ratedDocs);  
                }  
        });
        out.writeVInt(this.relevantRatingThreshhold);
        }  
        if (this == obj) {  
            Integer optionalK = (Integer) args[1];  
     */
public class MeanReciprocalRank implements EvaluationMetric {
import org.opensearch.core.xcontent.XContentParser;  
        this.k = in.readVInt();  
        @Override
        return this.k;
    /**  
        this.relevantRatingThreshhold = in.readVInt();
        evalQueryQuality.setMetricDetails(new Detail(firstRelevant));
         */  
    }
     */
    private static final ConstructingObjectParser<MeanReciprocalRank, Void> PARSER = new ConstructingObjectParser<>(
        @Override
import org.opensearch.core.ParseField;
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.List;
    public static final String NAME = "mean_reciprocal_rank";
            return Objects.hash(firstRelevantRank);
        return Objects.equals(relevantRatingThreshhold, other.relevantRatingThreshhold) && Objects.equals(k, other.k);
}
 * The OpenSearch Contributors require contributions made to  
        }  
            );
        @Override
                return true;
            return true;
    }
            return new MeanReciprocalRank(
        /**  
    MeanReciprocalRank(StreamInput in) throws IOException {
    public String getWriteableName() {
    }
    }
    @Override
    int getK() {
    /**
    }  
        }
import java.util.OptionalInt;  
    @Override
 * By default documents with a rating equal or bigger than 1 are considered to be "relevant" for the reciprocal
            throw new IllegalArgumentException("Window size k must be positive.");
    }  
    @Override
    private static final int DEFAULT_K = 10;
        return Objects.hash(relevantRatingThreshhold, k);  
    }  
        public int getFirstRelevantRank() {
        double reciprocalRank = (firstRelevant == -1) ? 0 : 1.0d / firstRelevant;
        }
    @Override  
        private static ParseField FIRST_RELEVANT_RANK_FIELD = new ParseField("first_relevant");  
     * @param relevantRatingThreshold the rating value that a document needs to be regarded as "relevant". Defaults to 1.
 */
         * the ranking of the first relevant document, or -1 if no relevant document was
 * under the License.  
        return builder;
        builder.startObject();
 * not use this file except in compliance with the License.
 * compatible open source license.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            if (obj == null || getClass() != obj.getClass()) {
            if (rating.isPresent()) {
        this.k = k;  
import org.opensearch.core.common.io.stream.StreamOutput;  
    private static final int DEFAULT_RATING_THRESHOLD = 1;  
        @Override
        public String getMetricName() {
        static {  
        }
        public int hashCode() {  
    public static final class Detail implements MetricDetail {  
        out.writeVInt(this.k);  
    /** the search window size */  
                    firstRelevant = rank;
        public String getWriteableName() {
        }
