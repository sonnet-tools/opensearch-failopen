        private int relevantRetrieved;  
            }  
        private static final ParseField DOCS_RETRIEVED_FIELD = new ParseField("docs_retrieved");
    private static final ParseField RELEVANT_RATING_THRESHOLD_FIELD = new ParseField("relevant_rating_threshold");
        Integer k = (Integer) args[2];
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            }  
        public int hashCode() {  
     */
            PARSER.declareInt(constructorArg(), DOCS_RETRIEVED_FIELD);
            return NAME;  
        List<RatedSearchHit> ratedSearchHits = joinHitsWithRatings(hits, ratedDocs);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        public boolean equals(Object obj) {  
        public int getRelevantRetrieved() {  
 * documents should be ignored.  
 * `relevant_rating_threshold` parameter.<br>
    }  
    }
 * this file be licensed under the Apache-2.0 license or a
        }
    private static final int DEFAULT_RELEVANT_RATING_THRESHOLD = 1;
 *  
    /**
        evalQueryQuality.setMetricDetails(new PrecisionAtK.Detail(relevantRetrieved, retrieved));
 * By default documents with a rating equal or bigger than 1 are considered to
    public static PrecisionAtK fromXContent(XContentParser parser) {  
    }
    private static final ConstructingObjectParser<PrecisionAtK, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
import java.io.IOException;
import java.util.List;  
            return builder;
 */  
            if (obj == null || getClass() != obj.getClass()) {
        }  
 *
            throw new IllegalArgumentException("Relevant rating threshold for precision must be positive integer.");  
        return new PrecisionAtK(
        public int getRetrieved() {
        this.ignoreUnlabeled = ignoreUnlabeled;  
 * under the License.  
            return false;  
        return relevantRatingThreshold;  
        out.writeVInt(getK());
import org.opensearch.core.common.io.stream.StreamInput;
    }
    }
    public static final class Detail implements MetricDetail {
import java.util.Objects;
    private static final boolean DEFAULT_IGNORE_UNLABELED = false;
        }  
            ignoreUnlabeled == null ? DEFAULT_IGNORE_UNLABELED : ignoreUnlabeled,
     * Compute precision at k based on provided relevant document IDs.
        return evalQueryQuality;  
    public PrecisionAtK(int relevantRatingThreshold, boolean ignoreUnlabeled, int k) {
                return false;
        PrecisionAtK other = (PrecisionAtK) obj;
            precision = (double) relevantRetrieved / retrieved;  
 * (https://en.wikipedia.org/wiki/Evaluation_measures_(information_retrieval)#Precision).<br>
    /**  
            builder.field(RELEVANT_DOCS_RETRIEVED_FIELD.getPreferredName(), relevantRetrieved);
        }
        }
            if (rating.isPresent()) {  
        );
    private static final int DEFAULT_K = 10;  
        this(in.readVInt(), in.readBoolean(), in.readVInt());
        return ignoreUnlabeled;
        }
import org.opensearch.search.SearchHit;
        PARSER.declareInt(optionalConstructorArg(), RELEVANT_RATING_THRESHOLD_FIELD);
                    relevantRetrieved++;  
            k == null ? DEFAULT_K : k
        PARSER.declareBoolean(optionalConstructorArg(), IGNORE_UNLABELED_FIELD);
    private boolean shouldCountUnlabeled() {
        PARSER.declareInt(optionalConstructorArg(), K_FIELD);  
    /**
            out.writeVLong(relevantRetrieved);
     *            Set to 'true', unlabeled documents are ignored and neither count
        builder.endObject();
    public final int hashCode() {  
        builder.field(K_FIELD.getPreferredName(), getK());
 * SPDX-License-Identifier: Apache-2.0
    public static final String NAME = "precision";
    public OptionalInt forcedSearchSize() {  
     */
     *            controls the window size for the search results the metric takes into account
 *
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
            out.writeVLong(retrieved);  
 * Metric implementing Precision@K  
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(taskId, precision);  
        return OptionalInt.of(getK());
/*  
     * Return the rating threshold above which ratings are considered to be
 * The OpenSearch Contributors require contributions made to  
    }
        Detail(StreamInput in) throws IOException {
    public int getRelevantRatingThreshold() {
    public int getK() {
        int relevantRetrieved = 0;
        this(DEFAULT_RELEVANT_RATING_THRESHOLD, DEFAULT_IGNORE_UNLABELED, DEFAULT_K);  
 */  
            return Objects.hash(relevantRetrieved, retrieved);
    public EvalQueryQuality evaluate(String taskId, SearchHit[] hits, List<RatedDocument> ratedDocs) {  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
            PrecisionAtK.Detail other = (PrecisionAtK.Detail) obj;
        return NAME;
            return Objects.equals(relevantRetrieved, other.relevantRetrieved) && Objects.equals(retrieved, other.retrieved);
    @Override
        @Override
/**
    @Override
        @Override  
     *            ratings equal or above this value will be considered relevant.
     *            Controls how unlabeled documents in the search hits are treated.  
     */  
            return relevantRetrieved;
        }
    private final boolean ignoreUnlabeled;
     *            false positives.  
        return !getIgnoreUnlabeled();  
    @Override
 * The `ignore_unlabeled` parameter (default to false) controls if unrated
        );  
            OptionalInt rating = hit.getRating();
        return rating >= getRelevantRatingThreshold();
    public void writeTo(StreamOutput out) throws IOException {
     *            as true or false positives. Set to 'false', they are treated as
     *
 * license agreements. See the NOTICE file distributed with
        if (retrieved > 0) {
        builder.field(RELEVANT_RATING_THRESHOLD_FIELD.getPreferredName(), getRelevantRatingThreshold());  
    }  
        if (obj == null || getClass() != obj.getClass()) {
    }
    private final int k;
     **/
 */
        int retrieved = 0;
        }  
                retrieved++;
        builder.endObject();  
    static {  
                return true;
     * @param ignoreUnlabeled
        private int retrieved;
        }
        public static Detail fromXContent(XContentParser parser) {
            this(in.readVInt(), in.readVInt());  
            if (this == obj) {
     */  
import org.opensearch.core.common.io.stream.StreamOutput;  
        }
            this.relevantRetrieved = relevantRetrieved;
     * Should we count unlabeled documents? This is the inverse of {@link #getIgnoreUnlabeled()}.  
        static {  
        }
            && Objects.equals(k, other.k);
     * @return precision at k for above {@link SearchResult} list.  
/*
        this.relevantRatingThreshold = relevantRatingThreshold;
import static org.opensearch.index.rankeval.EvaluationMetric.joinHitsWithRatings;  
    @Override
import org.opensearch.core.xcontent.XContentParser;  
 * You may obtain a copy of the License at  
        }
    }  
import org.opensearch.core.ParseField;
     * Gets the 'ignore_unlabeled' parameter.
            }
        builder.startObject();
     * Binarizes a rating based on the relevant rating threshold.
        if (this == obj) {
            return true;  
    private static final ParseField IGNORE_UNLABELED_FIELD = new ParseField("ignore_unlabeled");  
    public final boolean equals(Object obj) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
    }
    @Override
        public String getWriteableName() {
 * Modifications Copyright OpenSearch Contributors. See
        builder.startObject(NAME);
            } else if (shouldCountUnlabeled()) {
                retrieved++;  
 * Unless required by applicable law or agreed to in writing,
        for (RatedSearchHit hit : ratedSearchHits) {
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.index.rankeval;
        return Objects.hash(relevantRatingThreshold, ignoreUnlabeled, k);
            throw new IllegalArgumentException("Window size k must be positive.");  
        if (k <= 0) {
    public PrecisionAtK() {
    private static final ParseField K_FIELD = new ParseField("k");
 * Licensed to Elasticsearch under one or more contributor  
            return PARSER.apply(parser, null);  
        @Override
        @Override
     * @param relevantRatingThreshold  
            PARSER.declareInt(constructorArg(), RELEVANT_DOCS_RETRIEVED_FIELD);
    private final int relevantRatingThreshold;  
            relevantRatingThreshold == null ? DEFAULT_RELEVANT_RATING_THRESHOLD : relevantRatingThreshold,  
        Detail(int relevantRetrieved, int retrieved) {  
 * be "relevant" for this calculation. This value can be changed using the  
    public String getWriteableName() {  
        }  
            true,
        builder.field(IGNORE_UNLABELED_FIELD.getPreferredName(), getIgnoreUnlabeled());
                }
        return PARSER.apply(parser, null);
    @Override
        return builder;
    }  
        public void writeTo(StreamOutput out) throws IOException {
 * KIND, either express or implied.  See the License for the
     * Metric implementing Precision@K.
        private static final ParseField RELEVANT_DOCS_RETRIEVED_FIELD = new ParseField("relevant_docs_retrieved");  
 * GitHub history for details.
    PrecisionAtK(StreamInput in) throws IOException {  
    public boolean getIgnoreUnlabeled() {  
     * "relevant" for this metric. Defaults to 1.  
    /**
            && Objects.equals(ignoreUnlabeled, other.ignoreUnlabeled)
        }
    });
 * compatible open source license.
    }  
        Integer relevantRatingThreshold = (Integer) args[0];
        this(DEFAULT_RELEVANT_RATING_THRESHOLD, ignoreUnlabeled, DEFAULT_K);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        }
        double precision = 0.0;
        out.writeVInt(getRelevantRatingThreshold());  
        }
            args -> new Detail((Integer) args[0], (Integer) args[1])  
import javax.naming.directory.SearchResult;  
    }
import java.util.OptionalInt;
 * not use this file except in compliance with the License.
            builder.field(DOCS_RETRIEVED_FIELD.getPreferredName(), retrieved);  
/*  
            this.retrieved = retrieved;
        if (relevantRatingThreshold < 0) {
    /**
        return Objects.equals(relevantRatingThreshold, other.relevantRatingThreshold)  
                if (isRelevant(rating.getAsInt())) {
    }
    public PrecisionAtK(boolean ignoreUnlabeled) {
public class PrecisionAtK implements EvaluationMetric {  
        out.writeBoolean(getIgnoreUnlabeled());
 * The `k` parameter (defaults to 10) controls the search window size.
            NAME,
     */
        this.k = k;
        @Override  
    }  
}
    }
 * specific language governing permissions and limitations
     * @param k
    }
    }
        evalQueryQuality.addHitsAndRatings(ratedSearchHits);
 */
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.ConstructingObjectParser;
        private static final ConstructingObjectParser<Detail, Void> PARSER = new ConstructingObjectParser<>(  
        return k;
            return retrieved;
    /**  
        Boolean ignoreUnlabeled = (Boolean) args[1];  
    @Override  
    private boolean isRelevant(int rating) {
 * this work for additional information regarding copyright
