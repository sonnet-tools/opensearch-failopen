            Collections.sort(allRatings, Comparator.nullsLast(Collections.reverseOrder()));
        }
                normalized == null ? false : normalized,
            }
        /**
import java.util.List;
    private final int k;
/*
            return Objects.hash(this.dcg, this.idcg, this.unratedDocs);
        return PARSER.apply(parser, null);
                optK == null ? DEFAULT_K : optK
    int getK() {
 */
        double result = dcg;
/**
        public void writeTo(StreamOutput out) throws IOException {
 */
        return Objects.equals(normalize, other.normalize)
     *            rating for
        int rank = 1;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    /**
            return builder;
    public final int hashCode() {
        @Override
        return Objects.hash(normalize, unknownDocRating, k);
        });
     *            If set to true, dcg will be normalized (ndcg) See
        args -> {
    );
 * GitHub history for details.
            this.unratedDocs = in.readVInt();
 * @see <a href="https://en.wikipedia.org/wiki/Discounted_cumulative_gain#Discounted_Cumulative_Gain">Discounted Cumulative Gain</a><br>
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(taskId, result);
    }
 * software distributed under the License is distributed on an
    public DiscountedCumulativeGain(boolean normalize, Integer unknownDocRating, int k) {
     * Optional. If set, this will be the rating for docs that are unrated in the ranking evaluation request
    }
            if (this.idcg != 0) {
        final double dcg = computeDCG(ratingsInSearchHits);
        }
        static {
    }
            idcg = computeDCG(allRatings.subList(0, Math.min(ratingsInSearchHits.size(), allRatings.size())));
     * @param normalize
 * The optional `unknown_doc_rating` parameter can be used to specify a default rating for unlabeled documents.
import java.util.Objects;
        }
        this.k = k;
         * @return the number of unrated documents in the search results
    @Override
        normalize = in.readBoolean();
            this.dcg = dcg;
        }
        }
                (Integer) args[1],
        k = in.readVInt();
        return NAME;
                ratingsInSearchHits.add(unknownDocRating);
            }
 * SPDX-License-Identifier: Apache-2.0
    public static DiscountedCumulativeGain fromXContent(XContentParser parser) {
        List<RatedSearchHit> ratedHits = joinHitsWithRatings(hits, ratedDocs);
        return evalQueryQuality;
            }
    private static final double LOG2 = Math.log(2.0);
    public static final class Detail implements MetricDetail {
 * The `normalize` parameter can be set to calculate the normalized NDCG (set to {@code false} by default).<br>
         * @return the ideal discounted cumulative gain, can be 0 if nothing was computed, e.g. because no normalization was required
    /**
            this.dcg = in.readDouble();
    @Override
            if (idcg != 0) {
        return this.unknownDocRating;
        private static ParseField UNRATED_FIELD = new ParseField("unrated_docs");
        private static ParseField DCG_FIELD = new ParseField("dcg");
    public EvalQueryQuality evaluate(String taskId, SearchHit[] hits, List<RatedDocument> ratedDocs) {
            return new DiscountedCumulativeGain(
                && Double.compare(this.idcg, other.idcg) == 0
            if (hit.getRating().isPresent() == false) {
    public OptionalInt forcedSearchSize() {
import static org.opensearch.index.rankeval.EvaluationMetric.joinHitsWithRatings;
    }
    }
            DiscountedCumulativeGain.Detail other = (DiscountedCumulativeGain.Detail) obj;
        this(false, null, DEFAULT_K);
    public DiscountedCumulativeGain() {
        public String getMetricName() {
import org.opensearch.core.ParseField;
        @Override
 * not use this file except in compliance with the License.
        for (Integer rating : ratings) {
     */
        evalQueryQuality.addHitsAndRatings(ratedHits);
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
            if (hit.getRating().isPresent()) {
        }
        }
import org.opensearch.core.xcontent.XContentBuilder;
    private static final ParseField UNKNOWN_DOC_RATING_FIELD = new ParseField("unknown_doc_rating");
    }
            if (this == obj) {
        private static ParseField NDCG_FIELD = new ParseField("normalized_dcg");
    }
 * this work for additional information regarding copyright
            );
        if (this == obj) {
            }
    private final Integer unknownDocRating;
        }
    public static final String NAME = "dcg";
        double dcg = 0;
    boolean getNormalize() {
            out.writeDouble(this.idcg);
public class DiscountedCumulativeGain implements EvaluationMetric {
        PARSER.declareInt(optionalConstructorArg(), K_FIELD);
 * KIND, either express or implied.  See the License for the
            out.writeDouble(this.dcg);
            return true;
package org.opensearch.index.rankeval;
                return false;
        /**
        false,
        @Override
            return NAME;
    }
         * @return the normalized discounted cumulative gain, can be 0 if nothing was computed, e.g. because no normalization was required
        builder.field(NORMALIZE_FIELD.getPreferredName(), this.normalize);
        }
            builder.field(UNKNOWN_DOC_RATING_FIELD.getPreferredName(), this.unknownDocRating);
        private final double dcg;
        }
import java.util.OptionalInt;
import java.util.Collections;
 *
 * this file be licensed under the Apache-2.0 license or a
        this.unknownDocRating = unknownDocRating;
        private final double idcg;
    /** the default search window size */
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        }
            }
     *            the rating for documents the user hasn't supplied an explicit
    }
                // we still need to add them as a placeholder so the rank of the subsequent ratings is correct
        evalQueryQuality.setMetricDetails(new Detail(dcg, idcg, unratedResults));
        public String getWriteableName() {
    public String getWriteableName() {
                return true;
     *            https://en.wikipedia.org/wiki/Discounted_cumulative_gain
     */
 * You may obtain a copy of the License at
import org.opensearch.core.common.io.stream.StreamOutput;
            return Double.compare(this.dcg, other.dcg) == 0
            builder.field(UNRATED_FIELD.getPreferredName(), this.unratedDocs);
            } else {
        }
    @Override
        builder.endObject();
        }
            builder.field(DCG_FIELD.getPreferredName(), this.dcg);
        /**
        public int hashCode() {
        int unratedResults = 0;
/*
import java.util.stream.Collectors;
         * @return the discounted cumulative gain
    /** the search window size */
        public boolean equals(Object obj) {
 * Licensed to Elasticsearch under one or more contributor
        DiscountedCumulativeGain other = (DiscountedCumulativeGain) obj;
    public Integer getUnknownDocRating() {
                dcg += (Math.pow(2, rating) - 1) / ((Math.log(rank + 1) / LOG2));
         */
            PARSER.declareInt(constructorArg(), UNRATED_FIELD);
    private static double computeDCG(List<Integer> ratings) {
        @Override
     */
/*
            List<Integer> allRatings = ratedDocs.stream().mapToInt(RatedDocument::getRating).boxed().collect(Collectors.toList());
    @Override
            this.idcg = in.readDouble();
import org.opensearch.search.SearchHit;
 * Modifications Copyright OpenSearch Contributors. See
    private static final ParseField NORMALIZE_FIELD = new ParseField("normalize");
        out.writeBoolean(normalize);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
         */
            return PARSER.apply(parser, null);
import java.util.ArrayList;
            Integer optK = (Integer) args[2];
            if (obj == null || getClass() != obj.getClass()) {
            && Objects.equals(unknownDocRating, other.unknownDocRating)
        @Override
    }
import java.io.IOException;
    }
        }
import org.opensearch.core.xcontent.XContentParser;
    private static final ConstructingObjectParser<DiscountedCumulativeGain, Void> PARSER = new ConstructingObjectParser<>(
        }
 * Metric implementing Discounted Cumulative Gain.
                && this.unratedDocs == other.unratedDocs;
    /**
            return false;
 */
    }
        public static Detail fromXContent(XContentParser parser) {
    public void writeTo(StreamOutput out) throws IOException {
            Boolean normalized = (Boolean) args[0];
            PARSER.declareDouble(constructorArg(), DCG_FIELD);
        public Object getUnratedDocs() {
         */
        private static ParseField IDCG_FIELD = new ParseField("ideal_dcg");
                result = dcg / idcg;
 * ownership. Elasticsearch licenses this file to you under
        out.writeVInt(k);
                builder.field(NDCG_FIELD.getPreferredName(), this.dcg / this.idcg);
    public final boolean equals(Object obj) {
        PARSER.declareBoolean(optionalConstructorArg(), NORMALIZE_FIELD);
            return this.idcg;
    private static final ParseField K_FIELD = new ParseField("k");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * compatible open source license.
    }
        out.writeOptionalVInt(unknownDocRating);
            this.idcg = idcg;
                result = 0;
 * under the License.
        public double getDCG() {
import java.util.Comparator;
        }
        if (obj == null || getClass() != obj.getClass()) {
            }
 *
    private final boolean normalize;
            return this.unratedDocs;
        public double getNDCG() {
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * specific language governing permissions and limitations
        return this.normalize;
                ratingsInSearchHits.add(hit.getRating().getAsInt());
        this.normalize = normalize;
            rank++;
        builder.startObject();
        }
        PARSER.declareInt(optionalConstructorArg(), UNKNOWN_DOC_RATING_FIELD);
        }
        Detail(StreamInput in) throws IOException {
            this.unratedDocs = unratedDocs;
        double idcg = 0;
            out.writeVInt(this.unratedDocs);
        private static final ConstructingObjectParser<Detail, Void> PARSER = new ConstructingObjectParser<>(NAME, true, args -> {
        }
        builder.endObject();
            return this.dcg;
            }
            && Objects.equals(k, other.k);
                unratedResults++;
    @Override
        builder.startObject(NAME);
    static {
}
        private final int unratedDocs;
     * @param unknownDocRating
        return this.k;
            PARSER.declareDouble(optionalConstructorArg(), IDCG_FIELD);
    @Override
    @Override
            } else {
        unknownDocRating = in.readOptionalVInt();
    }
            return NAME;
        return dcg;
    private static final int DEFAULT_K = 10;
        "dcg",
        List<Integer> ratingsInSearchHits = new ArrayList<>(ratedHits.size());
                // unknownDocRating might be null, in which case unrated docs will be ignored in the dcg calculation.
            return new Detail((Double) args[0], (Double) args[1] != null ? (Double) args[1] : 0.0d, (Integer) args[2]);
        if (normalize) {
    /** If set to true, the dcg will be normalized (ndcg) */
        if (unknownDocRating != null) {
        }
 * Unless required by applicable law or agreed to in writing,
        return OptionalInt.of(k);
 *
        public double getIDCG() {
     * get the rating used for unrated documents
                builder.field(IDCG_FIELD.getPreferredName(), this.idcg);
        /**
 * The OpenSearch Contributors require contributions made to
 * license agreements. See the NOTICE file distributed with
        return builder;
    }
    }
 */
        @Override
            if (rating != null) {
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
     * @param k the search window size all request use.
        builder.field(K_FIELD.getPreferredName(), this.k);
    DiscountedCumulativeGain(StreamInput in) throws IOException {
        }
        Detail(double dcg, double idcg, int unratedDocs) {
         */
        for (RatedSearchHit hit : ratedHits) {
            return (this.idcg != 0) ? this.dcg / this.idcg : 0;
