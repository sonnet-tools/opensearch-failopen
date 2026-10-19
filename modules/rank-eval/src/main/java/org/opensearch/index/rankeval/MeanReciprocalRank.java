        }
        MeanReciprocalRank other = (MeanReciprocalRank) obj;
            return builder.field(FIRST_RELEVANT_RANK_FIELD.getPreferredName(), firstRelevantRank);
                optionalThreshold == null ? DEFAULT_RATING_THRESHOLD : optionalThreshold,
        int firstRelevant = -1;
        return OptionalInt.of(k);
            return NAME;
            Integer optionalThreshold = (Integer) args[0];
 *
        }
            return false;
 *
/*
import org.opensearch.core.xcontent.XContentParser;
        }
 * The OpenSearch Contributors require contributions made to
    private static final int DEFAULT_RATING_THRESHOLD = 1;
    @Override
    public MeanReciprocalRank(int relevantRatingThreshold, int k) {
        return this.k;
        return relevantRatingThreshhold;
        out.writeVInt(this.k);
            return NAME;
            this.firstRelevantRank = firstRelevantRank;
    public int getRelevantRatingThreshold() {
 * software distributed under the License is distributed on an
    private static final ParseField RELEVANT_RATING_FIELD = new ParseField("relevant_rating_threshold");
        this.relevantRatingThreshhold = in.readVInt();
            return PARSER.apply(parser, null);
            throw new IllegalArgumentException("Window size k must be positive.");
    }
    /**
    private final int k;
 * not use this file except in compliance with the License.
    /** the search window size */
    @Override
 * under the License.
    /**
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(taskId, reciprocalRank);
        int rank = 1;
    public static MeanReciprocalRank fromXContent(XContentParser parser) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
 */
 * this file be licensed under the Apache-2.0 license or a
        evalQueryQuality.setMetricDetails(new Detail(firstRelevant));
 */
import java.util.OptionalInt;
            if (rating.isPresent()) {
         */
        @Override
 * this work for additional information regarding copyright
        builder.startObject(NAME);
        });
     **/
            throw new IllegalArgumentException("Relevant rating threshold for precision must be positive integer.");
    public EvalQueryQuality evaluate(String taskId, SearchHit[] hits, List<RatedDocument> ratedDocs) {
    @Override
        List<RatedSearchHit> ratedHits = joinHitsWithRatings(hits, ratedDocs);
        PARSER.declareInt(optionalConstructorArg(), RELEVANT_RATING_FIELD);
    /**
 * Licensed to Elasticsearch under one or more contributor
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
            return Objects.hash(firstRelevantRank);
import org.opensearch.core.ParseField;
            }
 * compatible open source license.
        return Objects.equals(relevantRatingThreshhold, other.relevantRatingThreshhold) && Objects.equals(k, other.k);
    }
 * KIND, either express or implied.  See the License for the
import static org.opensearch.index.rankeval.EvaluationMetric.joinHitsWithRatings;
     * @param k the search window size all request use.
        return NAME;
    @Override
 *
            return true;
            }
        }
 * the Apache License, Version 2.0 (the "License"); you may
                return true;
                if (rating.getAsInt() >= this.relevantRatingThreshhold) {
            Integer optionalK = (Integer) args[1];
        if (this == obj) {
        this.k = k;
}
    int getK() {
    @Override
                }
package org.opensearch.index.rankeval;
    private final int relevantRatingThreshhold;
        private static ParseField FIRST_RELEVANT_RANK_FIELD = new ParseField("first_relevant");
    public OptionalInt forcedSearchSize() {
            );
    private static final ParseField K_FIELD = new ParseField("k");
import org.opensearch.core.xcontent.ConstructingObjectParser;
            this.firstRelevantRank = in.readVInt();
        public static Detail fromXContent(XContentParser parser) {
        @Override
        }
    }
        if (relevantRatingThreshold < 0) {
        builder.field(RELEVANT_RATING_FIELD.getPreferredName(), this.relevantRatingThreshhold);
    @Override
    private static final ConstructingObjectParser<MeanReciprocalRank, Void> PARSER = new ConstructingObjectParser<>(
import java.util.List;
    public final int hashCode() {
        }
    MeanReciprocalRank(StreamInput in) throws IOException {
        }
import org.opensearch.core.xcontent.XContentBuilder;
    }
        public void writeTo(StreamOutput out) throws IOException {
    }
        return PARSER.apply(parser, null);
        @Override
            if (obj == null || getClass() != obj.getClass()) {
        }
     * Compute ReciprocalRank based on provided relevant document IDs.
 * SPDX-License-Identifier: Apache-2.0
        builder.endObject();
import org.opensearch.core.common.io.stream.StreamInput;
 */
    public static final class Detail implements MetricDetail {
    @Override
 * GitHub history for details.
        out.writeVInt(this.relevantRatingThreshhold);
 * specific language governing permissions and limitations
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        }
        this.relevantRatingThreshhold = relevantRatingThreshold;
    }
        builder.endObject();
        return evalQueryQuality;
                    firstRelevant = rank;
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
        Detail(int firstRelevantRank) {
     * Metric implementing Mean Reciprocal Rank (https://en.wikipedia.org/wiki/Mean_reciprocal_rank).<br>
            return new Detail((Integer) args[0]);
    }
        }
            return firstRelevantRank;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
import org.opensearch.core.common.io.stream.StreamOutput;
public class MeanReciprocalRank implements EvaluationMetric {
        public boolean equals(Object obj) {
         * the ranking of the first relevant document, or -1 if no relevant document was
    }
    }
 * Unless required by applicable law or agreed to in writing,
        @Override
/*
    static {
        }
        @Override
    public String getWriteableName() {
            return new MeanReciprocalRank(
        public int getFirstRelevantRank() {
import java.util.Objects;
     */
        this(DEFAULT_RATING_THRESHOLD, DEFAULT_K);
    public final boolean equals(Object obj) {
            return Objects.equals(firstRelevantRank, other.firstRelevantRank);
        /**
        }
        builder.field(K_FIELD.getPreferredName(), this.k);
        if (obj == null || getClass() != obj.getClass()) {
        this.k = in.readVInt();
 * ownership. Elasticsearch licenses this file to you under
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (k <= 0) {
        static {
    public void writeTo(StreamOutput out) throws IOException {
     * Return the rating threshold above which ratings are considered to be "relevant".
 * By default documents with a rating equal or bigger than 1 are considered to be "relevant" for the reciprocal
 * Metric implementing Mean Reciprocal Rank (https://en.wikipedia.org/wiki/Mean_reciprocal_rank).<br>
        }
     */
import org.opensearch.search.SearchHit;
    /** ratings equal or above this value will be considered relevant */
            out.writeVInt(firstRelevantRank);
            PARSER.declareInt(constructorArg(), FIRST_RELEVANT_RANK_FIELD);
        return builder;
 * rank calculation. This value can be changes using the relevant_rating_threshold` parameter.
    }
    }
        builder.startObject();
        }
        for (RatedSearchHit hit : ratedHits) {
        private static final ConstructingObjectParser<Detail, Void> PARSER = new ConstructingObjectParser<>(NAME, true, args -> {
        @Override
    public MeanReciprocalRank() {
    }
/**
            MeanReciprocalRank.Detail other = (MeanReciprocalRank.Detail) obj;
         * found
    public static final String NAME = "mean_reciprocal_rank";
                    break;
        private final int firstRelevantRank;
            OptionalInt rating = hit.getRating();
        evalQueryQuality.addHitsAndRatings(ratedHits);
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
        double reciprocalRank = (firstRelevant == -1) ? 0 : 1.0d / firstRelevant;
                return false;
        }
        args -> {
        Detail(StreamInput in) throws IOException {
        public String getWriteableName() {
            if (this == obj) {
        }
 * license agreements. See the NOTICE file distributed with
     * @param relevantRatingThreshold the rating value that a document needs to be regarded as "relevant". Defaults to 1.
        public String getMetricName() {
        "reciprocal_rank",
 */
    }
        return Objects.hash(relevantRatingThreshhold, k);
            }
        }
                optionalK == null ? DEFAULT_K : optionalK
        public int hashCode() {
import java.io.IOException;
    );
            rank++;
        PARSER.declareInt(optionalConstructorArg(), K_FIELD);
    }
    private static final int DEFAULT_K = 10;
