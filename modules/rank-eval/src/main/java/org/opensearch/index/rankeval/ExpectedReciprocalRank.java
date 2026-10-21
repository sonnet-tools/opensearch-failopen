        }
        @Override
            }
        }
        this.two_pow_maxRelevance = Math.pow(2, this.maxRelevance);
 *
 * Expected reciprocal rank for graded relevance.<br>
        double err = 0;
    @Override
    public void writeTo(StreamOutput out) throws IOException {
        }
     */
    private static final ConstructingObjectParser<ExpectedReciprocalRank, Void> PARSER = new ConstructingObjectParser<>(
        List<RatedSearchHit> ratedHits = joinHitsWithRatings(hits, ratedDocs);
 *    http://www.apache.org/licenses/LICENSE-2.0
        });
    @Override
    /**
            PARSER.declareInt(constructorArg(), UNRATED_FIELD);
 * Chapelle, O., Metlzer, D., Zhang, Y., &amp; Grinspan, P. (2009).<br>
}
        this.two_pow_maxRelevance = Math.pow(2, this.maxRelevance);
     * @param maxRelevance
 * You may obtain a copy of the License at
        builder.endObject();
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
            return Objects.hash(this.unratedDocs);
    }
            return new Detail((Integer) args[0]);
        return this.k == other.k && this.maxRelevance == other.maxRelevance && Objects.equals(unknownDocRating, other.unknownDocRating);
import java.util.Objects;
package org.opensearch.index.rankeval;
import org.opensearch.core.xcontent.XContentParser;
import java.util.ArrayList;
        }
            return true;
            this.unratedDocs = in.readVInt();
            return false;
        out.writeVInt(maxRelevance);
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(taskId, err);
     *            the rating for documents the user hasn't supplied an explicit
        for (Integer rating : ratingsInSearchHits) {
 * this work for additional information regarding copyright
    }
            builder.field(UNKNOWN_DOC_RATING_FIELD.getPreferredName(), this.unknownDocRating);
        for (RatedSearchHit hit : ratedHits) {
            if (this == obj) {
        Detail(StreamInput in) throws IOException {
        return OptionalInt.of(k);
        @Override
        public static Detail fromXContent(XContentParser parser) {
 * compatible open source license.
     */
        }
 * GitHub history for details.
        evalQueryQuality.addHitsAndRatings(ratedHits);
        public int hashCode() {
            Integer optK = (Integer) args[2];
 * Modifications Copyright OpenSearch Contributors. See
        public String getWriteableName() {
                err = err + (p * probR / rank);
import java.util.List;
            int maxRelevance = (Integer) args[0];
 * https://doi.org/10.1145/1645953.1646033
        }
    @Override
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * SPDX-License-Identifier: Apache-2.0
        ExpectedReciprocalRank other = (ExpectedReciprocalRank) obj;
    ExpectedReciprocalRank(StreamInput in) throws IOException {
        @Override
        }
    }
        }
        this.maxRelevance = in.readVInt();
                return false;
     */
            }
    public static final class Detail implements MetricDetail {
    private static final ParseField UNKNOWN_DOC_RATING_FIELD = new ParseField("unknown_doc_rating");
    public ExpectedReciprocalRank(int maxRelevance) {
        this.k = k;
    private final int maxRelevance;
 * ownership. Elasticsearch licenses this file to you under
            if (rating != null) {
        builder.field(MAX_RELEVANCE_FIELD.getPreferredName(), this.maxRelevance);
        return PARSER.apply(parser, null);
        return builder;
            return NAME;
        out.writeOptionalVInt(unknownDocRating);
    public static ExpectedReciprocalRank fromXContent(XContentParser parser) {
     * Optional. If set, this will be the rating for docs that are unrated in the ranking evaluation request
import java.util.OptionalInt;
            return new ExpectedReciprocalRank(maxRelevance, (Integer) args[1], optK == null ? DEFAULT_K : optK);
/*
    public Integer getUnknownDocRating() {
            rank++;
public class ExpectedReciprocalRank implements EvaluationMetric {
        if (obj == null || getClass() != obj.getClass()) {
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamInput;
 */
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
 * KIND, either express or implied.  See the License for the
     * get the rating used for unrated documents
        PARSER.declareInt(constructorArg(), MAX_RELEVANCE_FIELD);
        }
import java.io.IOException;
        this.unknownDocRating = in.readOptionalVInt();
    }
    }
            }
/**
        PARSER.declareInt(optionalConstructorArg(), K_FIELD);
 * under the License.
        evalQueryQuality.setMetricDetails(new Detail(unratedResults));
    );
    int getK() {
import org.opensearch.core.common.io.stream.StreamOutput;
 *
        return Objects.hash(unknownDocRating, k, maxRelevance);
        "dcg",
        List<Integer> ratingsInSearchHits = new ArrayList<>(ratedHits.size());
        }
                ratingsInSearchHits.add(hit.getRating().getAsInt());
    public ExpectedReciprocalRank(int maxRelevance, @Nullable Integer unknownDocRating, int k) {
                ratingsInSearchHits.add(unknownDocRating);
import org.opensearch.search.SearchHit;
    }
    public OptionalInt forcedSearchSize() {
        if (ratedHits.size() > this.k) {
        return this.k;
        PARSER.declareInt(optionalConstructorArg(), UNKNOWN_DOC_RATING_FIELD);
     */
/*
 * Unless required by applicable law or agreed to in writing,
        public void writeTo(StreamOutput out) throws IOException {
            }
/*
        @Override
    }
         * @return the number of unrated documents in the search results
     *            the maximal relevance judgment in the evaluation dataset
 * Proceeding of the 18th ACM Conference on Information and Knowledge Management - CIKM ’09, 621.<br>
            return builder.field(UNRATED_FIELD.getPreferredName(), this.unratedDocs);
    @Override
        this.k = in.readVInt();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
 */
    public final int hashCode() {
import org.opensearch.common.Nullable;
            this.unratedDocs = unratedDocs;
        int unratedResults = 0;
    private static final ParseField MAX_RELEVANCE_FIELD = new ParseField("maximum_relevance");
    private static final int DEFAULT_K = 10;
 * not use this file except in compliance with the License.
     * @param unknownDocRating
        /**
            if (obj == null || getClass() != obj.getClass()) {
        if (unknownDocRating != null) {
        }
        int rank = 1;
        private final int unratedDocs;
    public EvalQueryQuality evaluate(String taskId, SearchHit[] hits, List<RatedDocument> ratedDocs) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
    public final boolean equals(Object obj) {
    }
        args -> {
        }
 * Implementation of the Expected Reciprocal Rank metric described in:<p>
    /**
        double p = 1;
        }
 * license agreements. See the NOTICE file distributed with
            return this.unratedDocs;
    }
import static org.opensearch.index.rankeval.EvaluationMetric.joinHitsWithRatings;
        builder.field(K_FIELD.getPreferredName(), this.k);
     * @param k
    /**
    private static final ParseField K_FIELD = new ParseField("k");
            if (hit.getRating().isPresent()) {
    int getMaxRelevance() {
    private final int k;
            }
 */
            return NAME;
 * the Apache License, Version 2.0 (the "License"); you may
        static {
import org.opensearch.core.ParseField;
        }
        return (Math.pow(2, rating) - 1) / this.two_pow_maxRelevance;
 * The OpenSearch Contributors require contributions made to
    @Override
            ratedHits = ratedHits.subList(0, k);
    }
        public String getMetricName() {
        }
        this.maxRelevance = maxRelevance;
        }
    /** the default search window size */
    private final Integer unknownDocRating;
                return true;
     *            skipped.
    }
        // we can pre-calculate the constant used in metric calculation
    /**
        return this.maxRelevance;
     *            the search window size all request use.
 *
                unratedResults++;
                // we still need to add them as a placeholder so the rank of the subsequent ratings is correct
 *
    }
            return PARSER.apply(parser, null);
        public Object getUnratedDocs() {
                p = p * (1 - probR);
    }
        this(maxRelevance, null, DEFAULT_K);
        }
     * @param maxRelevance the highest expected relevance in the data
    }
    public String getWriteableName() {
    double probabilityOfRelevance(Integer rating) {
    static {
        Detail(int unratedDocs) {
                double probR = probabilityOfRelevance(rating);
    @Override
    }
        private static final ConstructingObjectParser<Detail, Void> PARSER = new ConstructingObjectParser<>(NAME, true, args -> {
        builder.endObject();
 */
        false,
        }
        out.writeVInt(k);
            if (hit.getRating().isPresent() == false) {
    public static final String NAME = "expected_reciprocal_rank";
    private final double two_pow_maxRelevance;
        @Override
        builder.startObject();
            out.writeVInt(this.unratedDocs);
            } else {
        return NAME;
         */
    }
            return this.unratedDocs == other.unratedDocs;
     *            rating for. Can be {@code null}, in which case document is
 * software distributed under the License is distributed on an
        if (this == obj) {
import org.opensearch.core.xcontent.XContentBuilder;
        private static ParseField UNRATED_FIELD = new ParseField("unrated_docs");
    @Override
 * this file be licensed under the Apache-2.0 license or a
        this.unknownDocRating = unknownDocRating;
                // unknownDocRating might be null, in which case unrated docs will be ignored in the dcg calculation.
        public boolean equals(Object obj) {
        builder.startObject(NAME);
        return evalQueryQuality;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            ExpectedReciprocalRank.Detail other = (ExpectedReciprocalRank.Detail) obj;
    /** the search window size */
        return this.unknownDocRating;
        @Override
 * Licensed to Elasticsearch under one or more contributor
