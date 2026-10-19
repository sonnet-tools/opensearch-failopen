        }  
            }  
        double p = 1;  
 * the Apache License, Version 2.0 (the "License"); you may
        args -> {
 * Modifications Copyright OpenSearch Contributors. See
        out.writeVInt(maxRelevance);  
        if (this == obj) {
        }
            }  
            return this.unratedDocs;
            Integer optK = (Integer) args[2];  
        this.unknownDocRating = unknownDocRating;  
import java.util.OptionalInt;
        public Object getUnratedDocs() {
        PARSER.declareInt(optionalConstructorArg(), UNKNOWN_DOC_RATING_FIELD);
    public ExpectedReciprocalRank(int maxRelevance, @Nullable Integer unknownDocRating, int k) {
import static org.opensearch.index.rankeval.EvaluationMetric.joinHitsWithRatings;  
 * under the License.  
        return Objects.hash(unknownDocRating, k, maxRelevance);
    int getK() {
        }  
package org.opensearch.index.rankeval;
public class ExpectedReciprocalRank implements EvaluationMetric {
        }
        return (Math.pow(2, rating) - 1) / this.two_pow_maxRelevance;
        @Override  
    @Override
        out.writeOptionalVInt(unknownDocRating);
import org.opensearch.core.xcontent.XContentParser;
                double probR = probabilityOfRelevance(rating);
 *
            }
     */
/**
 */  
        if (obj == null || getClass() != obj.getClass()) {
                p = p * (1 - probR);
    private final int maxRelevance;
    }
        }  
    /**  
    /** the search window size */  
}
            return true;
     * @param maxRelevance
import org.opensearch.common.Nullable;
    @Override
    static {
        }  
            return PARSER.apply(parser, null);  
        return OptionalInt.of(k);  
    private final int k;
    private static final ParseField K_FIELD = new ParseField("k");
            return new ExpectedReciprocalRank(maxRelevance, (Integer) args[1], optK == null ? DEFAULT_K : optK);
        double err = 0;
                return true;
    private final Integer unknownDocRating;  
    public final boolean equals(Object obj) {  
    public OptionalInt forcedSearchSize() {
import org.opensearch.core.ParseField;
                ratingsInSearchHits.add(hit.getRating().getAsInt());
    }  
     *            skipped.  
import org.opensearch.core.xcontent.XContentBuilder;  
        @Override
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.ConstructingObjectParser;
        }
        "dcg",
                unratedResults++;
                // unknownDocRating might be null, in which case unrated docs will be ignored in the dcg calculation.  
        private static final ConstructingObjectParser<Detail, Void> PARSER = new ConstructingObjectParser<>(NAME, true, args -> {  
        this.maxRelevance = in.readVInt();
        this.two_pow_maxRelevance = Math.pow(2, this.maxRelevance);
    }
        }
            if (hit.getRating().isPresent() == false) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * Expected reciprocal rank for graded relevance.<br>  
            builder.field(UNKNOWN_DOC_RATING_FIELD.getPreferredName(), this.unknownDocRating);  
         */  
     *            rating for. Can be {@code null}, in which case document is
import java.util.Objects;
    @Override
        this.two_pow_maxRelevance = Math.pow(2, this.maxRelevance);  
    @Override
        }
        }
        return builder;
        builder.startObject();
import java.util.List;  
                return false;
 *  
 *
        PARSER.declareInt(constructorArg(), MAX_RELEVANCE_FIELD);  
        }
    private static final int DEFAULT_K = 10;
    }
        public boolean equals(Object obj) {  
        }
        @Override
    private final double two_pow_maxRelevance;
     * @param k
    public Integer getUnknownDocRating() {  
            return builder.field(UNRATED_FIELD.getPreferredName(), this.unratedDocs);  
        evalQueryQuality.setMetricDetails(new Detail(unratedResults));
        builder.endObject();  
    public static final class Detail implements MetricDetail {
        public String getWriteableName() {  
        }  
     *            the maximal relevance judgment in the evaluation dataset
        if (ratedHits.size() > this.k) {  
    /** the default search window size */  
        /**
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
        PARSER.declareInt(optionalConstructorArg(), K_FIELD);
 * compatible open source license.
    public ExpectedReciprocalRank(int maxRelevance) {
    }  
            if (hit.getRating().isPresent()) {  
import java.util.ArrayList;
        builder.field(K_FIELD.getPreferredName(), this.k);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    double probabilityOfRelevance(Integer rating) {  
 * Licensed to Elasticsearch under one or more contributor  
 * Proceeding of the 18th ACM Conference on Information and Knowledge Management - CIKM ’09, 621.<br>
        @Override
            }  
    @Override  
        private static ParseField UNRATED_FIELD = new ParseField("unrated_docs");  
 * ownership. Elasticsearch licenses this file to you under  
    public EvalQueryQuality evaluate(String taskId, SearchHit[] hits, List<RatedDocument> ratedDocs) {
        return evalQueryQuality;  
        this.unknownDocRating = in.readOptionalVInt();
    public static final String NAME = "expected_reciprocal_rank";  
    public void writeTo(StreamOutput out) throws IOException {
     * Optional. If set, this will be the rating for docs that are unrated in the ranking evaluation request
        @Override
            this.unratedDocs = in.readVInt();
    /**
    }
        return this.maxRelevance;  
        this.k = k;
    }
        return NAME;
            rank++;  
 * license agreements. See the NOTICE file distributed with
    }
            return new Detail((Integer) args[0]);
    }
            if (rating != null) {
    int getMaxRelevance() {
            if (obj == null || getClass() != obj.getClass()) {
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
            this.unratedDocs = unratedDocs;
        List<RatedSearchHit> ratedHits = joinHitsWithRatings(hits, ratedDocs);
        public String getMetricName() {  
 * KIND, either express or implied.  See the License for the
        builder.startObject(NAME);  
    @Override
                ratingsInSearchHits.add(unknownDocRating);
    /**  
        static {
 * The OpenSearch Contributors require contributions made to  
        ExpectedReciprocalRank other = (ExpectedReciprocalRank) obj;
    public final int hashCode() {  
 * Unless required by applicable law or agreed to in writing,
        int unratedResults = 0;
    public static ExpectedReciprocalRank fromXContent(XContentParser parser) {
    @Override  
     */
        @Override
            } else {
     * @param maxRelevance the highest expected relevance in the data  
            PARSER.declareInt(constructorArg(), UNRATED_FIELD);
import org.opensearch.core.common.io.stream.StreamInput;  
        evalQueryQuality.addHitsAndRatings(ratedHits);
/*
    private static final ParseField UNKNOWN_DOC_RATING_FIELD = new ParseField("unknown_doc_rating");
            return this.unratedDocs == other.unratedDocs;
        // we can pre-calculate the constant used in metric calculation
     */
    }
     * @param unknownDocRating  
            return false;
        if (unknownDocRating != null) {
 * https://doi.org/10.1145/1645953.1646033
     */  
        Detail(int unratedDocs) {  
        int rank = 1;
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(taskId, err);  
 * GitHub history for details.
        return this.k;
        public int hashCode() {  
    ExpectedReciprocalRank(StreamInput in) throws IOException {  
    }
        });
        }
import java.io.IOException;
        List<Integer> ratingsInSearchHits = new ArrayList<>(ratedHits.size());  
            if (this == obj) {
            }  
    }  
 * this file be licensed under the Apache-2.0 license or a
    public String getWriteableName() {  
        public static Detail fromXContent(XContentParser parser) {
        for (Integer rating : ratingsInSearchHits) {  
 * SPDX-License-Identifier: Apache-2.0
    }
                // we still need to add them as a placeholder so the rank of the subsequent ratings is correct
 * software distributed under the License is distributed on an
        false,  
/*  
        }  
/*  
    private static final ParseField MAX_RELEVANCE_FIELD = new ParseField("maximum_relevance");  
    }  
        }
 * Chapelle, O., Metlzer, D., Zhang, Y., &amp; Grinspan, P. (2009).<br>
 * Implementation of the Expected Reciprocal Rank metric described in:<p>  
            ratedHits = ratedHits.subList(0, k);
            return NAME;
        return this.unknownDocRating;
            return Objects.hash(this.unratedDocs);
        this.maxRelevance = maxRelevance;
            out.writeVInt(this.unratedDocs);
            ExpectedReciprocalRank.Detail other = (ExpectedReciprocalRank.Detail) obj;
     *            the rating for documents the user hasn't supplied an explicit
        out.writeVInt(k);
    }  
        builder.endObject();
 *
        Detail(StreamInput in) throws IOException {
        this.k = in.readVInt();  
    private static final ConstructingObjectParser<ExpectedReciprocalRank, Void> PARSER = new ConstructingObjectParser<>(
        }
    }  
import org.opensearch.search.SearchHit;
    /**  
 * specific language governing permissions and limitations
        this(maxRelevance, null, DEFAULT_K);  
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
import org.opensearch.core.common.io.stream.StreamOutput;
    }
            return NAME;
     *            the search window size all request use.
        return PARSER.apply(parser, null);  
 */  
        for (RatedSearchHit hit : ratedHits) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private final int unratedDocs;
            int maxRelevance = (Integer) args[0];
    );  
     * get the rating used for unrated documents
        builder.field(MAX_RELEVANCE_FIELD.getPreferredName(), this.maxRelevance);
        public void writeTo(StreamOutput out) throws IOException {
         * @return the number of unrated documents in the search results
                err = err + (p * probR / rank);  
 */
        return this.k == other.k && this.maxRelevance == other.maxRelevance && Objects.equals(unknownDocRating, other.unknownDocRating);
