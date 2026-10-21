            return PARSER.apply(parser, null);
        builder.startObject(NAME);
            return builder;
                return false;
 * The `ignore_unlabeled` parameter (default to false) controls if unrated
            precision = (double) relevantRetrieved / retrieved;
        private static final ConstructingObjectParser<Detail, Void> PARSER = new ConstructingObjectParser<>(
import java.util.OptionalInt;
    });
     *            ratings equal or above this value will be considered relevant.
        int retrieved = 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * The OpenSearch Contributors require contributions made to
     */
    public EvalQueryQuality evaluate(String taskId, SearchHit[] hits, List<RatedDocument> ratedDocs) {
import java.util.List;
     * Compute precision at k based on provided relevant document IDs.
            builder.field(RELEVANT_DOCS_RETRIEVED_FIELD.getPreferredName(), relevantRetrieved);
        return k;
    public static final String NAME = "precision";
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(taskId, precision);
            throw new IllegalArgumentException("Window size k must be positive.");
            ignoreUnlabeled == null ? DEFAULT_IGNORE_UNLABELED : ignoreUnlabeled,
     * @param relevantRatingThreshold
     */
    @Override
        @Override
            if (this == obj) {
        }
        private static final ParseField RELEVANT_DOCS_RETRIEVED_FIELD = new ParseField("relevant_docs_retrieved");
import org.opensearch.core.common.io.stream.StreamOutput;
 * By default documents with a rating equal or bigger than 1 are considered to
    @Override
    /**
    private static final int DEFAULT_RELEVANT_RATING_THRESHOLD = 1;
    @Override
    }
 * Unless required by applicable law or agreed to in writing,
    private static final ParseField RELEVANT_RATING_THRESHOLD_FIELD = new ParseField("relevant_rating_threshold");
        }
import static org.opensearch.index.rankeval.EvaluationMetric.joinHitsWithRatings;
    PrecisionAtK(StreamInput in) throws IOException {
    }
        Integer relevantRatingThreshold = (Integer) args[0];
            return relevantRetrieved;
        }
     * Gets the 'ignore_unlabeled' parameter.
    /**
    public PrecisionAtK(int relevantRatingThreshold, boolean ignoreUnlabeled, int k) {
        builder.field(K_FIELD.getPreferredName(), getK());
            }
     */
            } else if (shouldCountUnlabeled()) {
            && Objects.equals(ignoreUnlabeled, other.ignoreUnlabeled)
        for (RatedSearchHit hit : ratedSearchHits) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.field(DOCS_RETRIEVED_FIELD.getPreferredName(), retrieved);
        return rating >= getRelevantRatingThreshold();
        }
    private static final ParseField K_FIELD = new ParseField("k");
 * not use this file except in compliance with the License.
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
/**
    }
        builder.field(IGNORE_UNLABELED_FIELD.getPreferredName(), getIgnoreUnlabeled());
        private int retrieved;
            PARSER.declareInt(constructorArg(), DOCS_RETRIEVED_FIELD);
        Boolean ignoreUnlabeled = (Boolean) args[1];
        public int getRetrieved() {
    }
    public PrecisionAtK(boolean ignoreUnlabeled) {
                    relevantRetrieved++;
     * Metric implementing Precision@K.
            return retrieved;
        out.writeBoolean(getIgnoreUnlabeled());
    private final boolean ignoreUnlabeled;
        Detail(int relevantRetrieved, int retrieved) {
            if (rating.isPresent()) {
     * Binarizes a rating based on the relevant rating threshold.
    private static final ParseField IGNORE_UNLABELED_FIELD = new ParseField("ignore_unlabeled");
    private final int relevantRatingThreshold;
    public final boolean equals(Object obj) {
}
    public static PrecisionAtK fromXContent(XContentParser parser) {
    private static final ConstructingObjectParser<PrecisionAtK, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
    public boolean getIgnoreUnlabeled() {
        public int getRelevantRetrieved() {
public class PrecisionAtK implements EvaluationMetric {
            PrecisionAtK.Detail other = (PrecisionAtK.Detail) obj;
     *
    }
     *            as true or false positives. Set to 'false', they are treated as
 * under the License.
            return false;
 */
    static {
     **/
        out.writeVInt(getK());
        return PARSER.apply(parser, null);
    }
            return Objects.equals(relevantRetrieved, other.relevantRetrieved) && Objects.equals(retrieved, other.retrieved);
    public static final class Detail implements MetricDetail {
                if (isRelevant(rating.getAsInt())) {
            if (obj == null || getClass() != obj.getClass()) {
        return relevantRatingThreshold;
        }
package org.opensearch.index.rankeval;
                retrieved++;
     * @param ignoreUnlabeled
        PARSER.declareInt(optionalConstructorArg(), K_FIELD);
        }
        builder.startObject();
        return !getIgnoreUnlabeled();
                retrieved++;
    /**
import org.opensearch.core.common.io.stream.StreamInput;
        public static Detail fromXContent(XContentParser parser) {
    public String getWriteableName() {
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            out.writeVLong(retrieved);
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentBuilder;
    public void writeTo(StreamOutput out) throws IOException {
            this(in.readVInt(), in.readVInt());
    }
            OptionalInt rating = hit.getRating();
        builder.endObject();
import org.opensearch.search.SearchHit;
        this.k = k;
    /**
     */
     * @param k
        }
import java.io.IOException;
 * (https://en.wikipedia.org/wiki/Evaluation_measures_(information_retrieval)#Precision).<br>
     */
        private static final ParseField DOCS_RETRIEVED_FIELD = new ParseField("docs_retrieved");
                return true;
        double precision = 0.0;
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        }
    }
        static {
            this.relevantRetrieved = relevantRetrieved;
        PrecisionAtK other = (PrecisionAtK) obj;
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
        }
            out.writeVLong(relevantRetrieved);
        PARSER.declareInt(optionalConstructorArg(), RELEVANT_RATING_THRESHOLD_FIELD);
    }
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
 */
        public boolean equals(Object obj) {
        public void writeTo(StreamOutput out) throws IOException {
            return Objects.hash(relevantRetrieved, retrieved);
 * this file be licensed under the Apache-2.0 license or a
        this(DEFAULT_RELEVANT_RATING_THRESHOLD, ignoreUnlabeled, DEFAULT_K);
        return Objects.equals(relevantRatingThreshold, other.relevantRatingThreshold)
 */
        evalQueryQuality.setMetricDetails(new PrecisionAtK.Detail(relevantRetrieved, retrieved));
        return Objects.hash(relevantRatingThreshold, ignoreUnlabeled, k);
        List<RatedSearchHit> ratedSearchHits = joinHitsWithRatings(hits, ratedDocs);
        @Override
            relevantRatingThreshold == null ? DEFAULT_RELEVANT_RATING_THRESHOLD : relevantRatingThreshold,
 *
 *
 * be "relevant" for this calculation. This value can be changed using the
 *
            }
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    }
    }
    /**
    private static final boolean DEFAULT_IGNORE_UNLABELED = false;
        if (retrieved > 0) {
            return NAME;
        return new PrecisionAtK(
        }
 * Licensed to Elasticsearch under one or more contributor
            return true;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentParser;
     * @return precision at k for above {@link SearchResult} list.
    @Override
     * Return the rating threshold above which ratings are considered to be
            true,
        PARSER.declareBoolean(optionalConstructorArg(), IGNORE_UNLABELED_FIELD);
/*
    }
        builder.field(RELEVANT_RATING_THRESHOLD_FIELD.getPreferredName(), getRelevantRatingThreshold());
 * Metric implementing Precision@K
        this.relevantRatingThreshold = relevantRatingThreshold;
 * compatible open source license.
     *            Set to 'true', unlabeled documents are ignored and neither count
    }
        public int hashCode() {
            throw new IllegalArgumentException("Relevant rating threshold for precision must be positive integer.");
 * ownership. Elasticsearch licenses this file to you under
        }
 * `relevant_rating_threshold` parameter.<br>
    @Override
        this.ignoreUnlabeled = ignoreUnlabeled;
    }
            k == null ? DEFAULT_K : k
        if (this == obj) {
        @Override
        Detail(StreamInput in) throws IOException {
    public final int hashCode() {
        }
            PARSER.declareInt(constructorArg(), RELEVANT_DOCS_RETRIEVED_FIELD);
        if (relevantRatingThreshold < 0) {
    @Override
        }
 * You may obtain a copy of the License at
            args -> new Detail((Integer) args[0], (Integer) args[1])
    public OptionalInt forcedSearchSize() {
        return NAME;
 * documents should be ignored.
    public PrecisionAtK() {
        int relevantRetrieved = 0;
        out.writeVInt(getRelevantRatingThreshold());
        if (obj == null || getClass() != obj.getClass()) {
        return ignoreUnlabeled;
     *            false positives.
            this.retrieved = retrieved;
                }
        this(in.readVInt(), in.readBoolean(), in.readVInt());
    private static final int DEFAULT_K = 10;
        this(DEFAULT_RELEVANT_RATING_THRESHOLD, DEFAULT_IGNORE_UNLABELED, DEFAULT_K);
    /**
/*
    @Override
        evalQueryQuality.addHitsAndRatings(ratedSearchHits);
    private boolean shouldCountUnlabeled() {
    private boolean isRelevant(int rating) {
 * this work for additional information regarding copyright
        return evalQueryQuality;
import java.util.Objects;
        return builder;
        @Override
    }
     * Should we count unlabeled documents? This is the inverse of {@link #getIgnoreUnlabeled()}.
     *            controls the window size for the search results the metric takes into account
 */
/*
        }
        }
     * "relevant" for this metric. Defaults to 1.
    public int getRelevantRatingThreshold() {
        }
        if (k <= 0) {
 * specific language governing permissions and limitations
     *            Controls how unlabeled documents in the search hits are treated.
 * The `k` parameter (defaults to 10) controls the search window size.
        builder.endObject();
    }
        @Override
        public String getWriteableName() {
            NAME,
        );
        private int relevantRetrieved;
    }
            }
        );
import org.opensearch.core.ParseField;
    }
        Integer k = (Integer) args[2];
            && Objects.equals(k, other.k);
    private final int k;
        }
import javax.naming.directory.SearchResult;
    public int getK() {
        return OptionalInt.of(getK());
