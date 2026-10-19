            this.dcg = dcg;
    DiscountedCumulativeGain(StreamInput in) throws IOException {  
    @Override
        }  
        final double dcg = computeDCG(ratingsInSearchHits);
        out.writeBoolean(normalize);
 */  
            if (hit.getRating().isPresent() == false) {  
        return PARSER.apply(parser, null);  
    }
        if (unknownDocRating != null) {
public class DiscountedCumulativeGain implements EvaluationMetric {
     */
            );
        public int hashCode() {
 * SPDX-License-Identifier: Apache-2.0
    }
            if (this.idcg != 0) {  
        }  
     * @param unknownDocRating
    public Integer getUnknownDocRating() {
        private static ParseField DCG_FIELD = new ParseField("dcg");
import java.util.Comparator;  
            this.dcg = in.readDouble();
        PARSER.declareInt(optionalConstructorArg(), K_FIELD);
        Detail(StreamInput in) throws IOException {
    private final int k;
    }  
            }
        public double getNDCG() {  
 * @see <a href="https://en.wikipedia.org/wiki/Discounted_cumulative_gain#Discounted_Cumulative_Gain">Discounted Cumulative Gain</a><br>
            builder.field(UNKNOWN_DOC_RATING_FIELD.getPreferredName(), this.unknownDocRating);  
        }
    }
            PARSER.declareDouble(constructorArg(), DCG_FIELD);
        });
            return (this.idcg != 0) ? this.dcg / this.idcg : 0;
    private static final ParseField NORMALIZE_FIELD = new ParseField("normalize");
    }
        if (obj == null || getClass() != obj.getClass()) {
    @Override
        public void writeTo(StreamOutput out) throws IOException {
        private final double idcg;
 * license agreements. See the NOTICE file distributed with
        public double getIDCG() {
 * Metric implementing Discounted Cumulative Gain.
    private static final double LOG2 = Math.log(2.0);  
    private static double computeDCG(List<Integer> ratings) {  
    static {
        builder.field(NORMALIZE_FIELD.getPreferredName(), this.normalize);
        private static ParseField NDCG_FIELD = new ParseField("normalized_dcg");
import java.util.stream.Collectors;
        }
        return builder;
 * compatible open source license.
        }
    @Override
    /**  
        this(false, null, DEFAULT_K);  
            return new DiscountedCumulativeGain(  
import static org.opensearch.index.rankeval.EvaluationMetric.joinHitsWithRatings;
 * GitHub history for details.
        private static ParseField IDCG_FIELD = new ParseField("ideal_dcg");  
         */
    /** the search window size */  
    }
                // we still need to add them as a placeholder so the rank of the subsequent ratings is correct  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
            idcg = computeDCG(allRatings.subList(0, Math.min(ratingsInSearchHits.size(), allRatings.size())));
                result = dcg / idcg;
        PARSER.declareInt(optionalConstructorArg(), UNKNOWN_DOC_RATING_FIELD);
        private static final ConstructingObjectParser<Detail, Void> PARSER = new ConstructingObjectParser<>(NAME, true, args -> {
    public static final class Detail implements MetricDetail {  
 * KIND, either express or implied.  See the License for the
    public OptionalInt forcedSearchSize() {
import java.util.Collections;
            } else {
import java.util.Objects;
}  
     *            the rating for documents the user hasn't supplied an explicit
        }  
            return this.idcg;  
        @Override
            if (this == obj) {
    public final boolean equals(Object obj) {  
            PARSER.declareDouble(optionalConstructorArg(), IDCG_FIELD);
                dcg += (Math.pow(2, rating) - 1) / ((Math.log(rank + 1) / LOG2));
import java.util.ArrayList;
            rank++;
    }
    }  
import java.util.List;
                (Integer) args[1],
            && Objects.equals(k, other.k);
    }
        public String getWriteableName() {  
        Detail(double dcg, double idcg, int unratedDocs) {
            return this.dcg;
                result = 0;  
                && this.unratedDocs == other.unratedDocs;
    public DiscountedCumulativeGain() {
        builder.endObject();  
            && Objects.equals(unknownDocRating, other.unknownDocRating)  
import org.opensearch.core.ParseField;
        args -> {  
    }  
     *            If set to true, dcg will be normalized (ndcg) See
     *            rating for  
        return dcg;  
            }
            return new Detail((Double) args[0], (Double) args[1] != null ? (Double) args[1] : 0.0d, (Integer) args[2]);  
    int getK() {
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
    private final Integer unknownDocRating;  
                ratingsInSearchHits.add(unknownDocRating);
     *            https://en.wikipedia.org/wiki/Discounted_cumulative_gain  
import org.opensearch.core.common.io.stream.StreamInput;
                builder.field(IDCG_FIELD.getPreferredName(), this.idcg);
        return this.normalize;
            if (hit.getRating().isPresent()) {
        return evalQueryQuality;  
            return false;
            builder.field(UNRATED_FIELD.getPreferredName(), this.unratedDocs);
        }  
    @Override  
        double dcg = 0;
        return Objects.hash(normalize, unknownDocRating, k);  
        return this.k;
    boolean getNormalize() {  
        }
            return builder;
        double result = dcg;
    public void writeTo(StreamOutput out) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return true;
        return this.unknownDocRating;  
        builder.endObject();
        }
         */  
     * get the rating used for unrated documents  
/*  
        @Override
        int rank = 1;
        builder.startObject();
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
        normalize = in.readBoolean();
            return Double.compare(this.dcg, other.dcg) == 0
            this.unratedDocs = in.readVInt();
            this.idcg = in.readDouble();  
/*  
 *
    @Override
        evalQueryQuality.setMetricDetails(new Detail(dcg, idcg, unratedResults));
        }
                return true;
        double idcg = 0;  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
    private static final ConstructingObjectParser<DiscountedCumulativeGain, Void> PARSER = new ConstructingObjectParser<>(  
        return NAME;  
    @Override  
     */
            PARSER.declareInt(constructorArg(), UNRATED_FIELD);  
        this.k = k;  
        }
            out.writeDouble(this.dcg);  
         * @return the normalized discounted cumulative gain, can be 0 if nothing was computed, e.g. because no normalization was required
        }  
        @Override  
 */  
        int unratedResults = 0;  
            }
 * this work for additional information regarding copyright
        }
        false,
/*
        public String getMetricName() {
        private final int unratedDocs;
            return Objects.hash(this.dcg, this.idcg, this.unratedDocs);  
        return Objects.equals(normalize, other.normalize)
            Collections.sort(allRatings, Comparator.nullsLast(Collections.reverseOrder()));
        "dcg",
        @Override
    }
    }
            out.writeVInt(this.unratedDocs);
        private final double dcg;  
        builder.startObject(NAME);  
        }  
        /**  
    }  
    }
        }
 * The optional `unknown_doc_rating` parameter can be used to specify a default rating for unlabeled documents.
        builder.field(K_FIELD.getPreferredName(), this.k);
 * software distributed under the License is distributed on an
         * @return the discounted cumulative gain
        List<RatedSearchHit> ratedHits = joinHitsWithRatings(hits, ratedDocs);
        static {  
    public static final String NAME = "dcg";
    );  
    /**
            this.idcg = idcg;  
        /**
     */
    }
 * this file be licensed under the Apache-2.0 license or a
        public double getDCG() {
 * Unless required by applicable law or agreed to in writing,
                optK == null ? DEFAULT_K : optK  
        this.normalize = normalize;
    public static DiscountedCumulativeGain fromXContent(XContentParser parser) {
        @Override
 * The `normalize` parameter can be set to calculate the normalized NDCG (set to {@code false} by default).<br>  
 * under the License.  
    public String getWriteableName() {
        PARSER.declareBoolean(optionalConstructorArg(), NORMALIZE_FIELD);  
        }
/**
        if (this == obj) {
            this.unratedDocs = unratedDocs;
 */
        }  
    public EvalQueryQuality evaluate(String taskId, SearchHit[] hits, List<RatedDocument> ratedDocs) {  
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(taskId, result);  
import org.opensearch.core.xcontent.ConstructingObjectParser;
            builder.field(DCG_FIELD.getPreferredName(), this.dcg);
        out.writeVInt(k);
import org.opensearch.core.common.io.stream.StreamOutput;  
                unratedResults++;
            Integer optK = (Integer) args[2];
        unknownDocRating = in.readOptionalVInt();
        private static ParseField UNRATED_FIELD = new ParseField("unrated_docs");
         */  
        }
            }  
    public DiscountedCumulativeGain(boolean normalize, Integer unknownDocRating, int k) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public final int hashCode() {
            return PARSER.apply(parser, null);
        public static Detail fromXContent(XContentParser parser) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * not use this file except in compliance with the License.
        for (RatedSearchHit hit : ratedHits) {
         */
        if (normalize) {
        /**
    }
    }
 *  
        /**
        evalQueryQuality.addHitsAndRatings(ratedHits);
                builder.field(NDCG_FIELD.getPreferredName(), this.dcg / this.idcg);
            List<Integer> allRatings = ratedDocs.stream().mapToInt(RatedDocument::getRating).boxed().collect(Collectors.toList());  
            return NAME;  
            DiscountedCumulativeGain.Detail other = (DiscountedCumulativeGain.Detail) obj;
            Boolean normalized = (Boolean) args[0];
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;  
        k = in.readVInt();  
import org.opensearch.core.xcontent.XContentBuilder;
    /**  
        List<Integer> ratingsInSearchHits = new ArrayList<>(ratedHits.size());
                // unknownDocRating might be null, in which case unrated docs will be ignored in the dcg calculation.
            return NAME;
        public boolean equals(Object obj) {  
    private final boolean normalize;
            out.writeDouble(this.idcg);
            if (idcg != 0) {  
            return this.unratedDocs;
            if (rating != null) {
                && Double.compare(this.idcg, other.idcg) == 0  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
        this.unknownDocRating = unknownDocRating;
    /** If set to true, the dcg will be normalized (ndcg) */  
package org.opensearch.index.rankeval;
            } else {
        return OptionalInt.of(k);
     * Optional. If set, this will be the rating for docs that are unrated in the ranking evaluation request
    private static final int DEFAULT_K = 10;
        }
 */  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.OptionalInt;  
            }  
        }
        @Override
    @Override  
         * @return the number of unrated documents in the search results
            }  
        for (Integer rating : ratings) {  
     * @param normalize
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.search.SearchHit;
                ratingsInSearchHits.add(hit.getRating().getAsInt());  
    private static final ParseField UNKNOWN_DOC_RATING_FIELD = new ParseField("unknown_doc_rating");
            if (obj == null || getClass() != obj.getClass()) {
                normalized == null ? false : normalized,
        DiscountedCumulativeGain other = (DiscountedCumulativeGain) obj;
        }
         * @return the ideal discounted cumulative gain, can be 0 if nothing was computed, e.g. because no normalization was required  
        out.writeOptionalVInt(unknownDocRating);  
            }  
        public Object getUnratedDocs() {
                return false;
    /** the default search window size */  
     * @param k the search window size all request use.
    private static final ParseField K_FIELD = new ParseField("k");  
