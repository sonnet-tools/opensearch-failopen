    public OptionalInt forcedSearchSize() {
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        }
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        evalQueryQuality.addHitsAndRatings(ratedSearchHits);
    public void writeTo(StreamOutput out) throws IOException {
        RecallAtK other = (RecallAtK) obj;
    public EvalQueryQuality evaluate(String taskId, SearchHit[] hits, List<RatedDocument> ratedDocs) {
            return relevant;
 * GitHub history for details.
            PARSER.declareInt(constructorArg(), RELEVANT_DOCS_FIELD);
 * license agreements. See the NOTICE file distributed with
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(taskId, recall);
import java.io.IOException;
    }
     */
    private final int k;
        public int hashCode() {
        @Override
    public static RecallAtK fromXContent(XContentParser parser) {
            OptionalInt rating = hit.getRating();
 * ownership. Elasticsearch licenses this file to you under
                relevant++;
            if (this == obj) {
        }
            return true;
        private static final ParseField RELEVANT_DOCS_RETRIEVED_FIELD = new ParseField("relevant_docs_retrieved");
        }
    public int getRelevantRatingThreshold() {
    }
            if (rating.isPresent() && isRelevant(rating.getAsInt())) {
import static org.opensearch.index.rankeval.EvaluationMetric.joinHitsWithRatings;
     **/
        for (RatedDocument rd : ratedDocs) {
        }
    /**
            relevantRatingThreshold == null ? DEFAULT_RELEVANT_RATING_THRESHOLD : relevantRatingThreshold,
    private static final ConstructingObjectParser<RecallAtK, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
        return NAME;
import java.util.OptionalInt;
/*
        this(in.readVInt(), in.readVInt());
 * software distributed under the License is distributed on an
    public RecallAtK(int relevantRatingThreshold, int k) {
            }
        Detail(long relevantRetrieved, long relevant) {
    }
        );
 * Modifications Copyright OpenSearch Contributors. See
        if (obj == null || getClass() != obj.getClass()) {
        return PARSER.apply(parser, null);
            RecallAtK.Detail other = (RecallAtK.Detail) obj;
            return PARSER.apply(parser, null);
    public final int hashCode() {
        builder.startObject(NAME);
 */
        builder.endObject();
        return Objects.equals(relevantRatingThreshold, other.relevantRatingThreshold) && Objects.equals(k, other.k);
        }
    }
        if (this == obj) {
     */
    @Override
import java.util.List;
 * KIND, either express or implied.  See the License for the
        static {
        return k;
import org.opensearch.core.xcontent.XContentBuilder;
        this(DEFAULT_RELEVANT_RATING_THRESHOLD, DEFAULT_K);
        @Override
                relevantRetrieved++;
    }
        builder.field(RELEVANT_RATING_THRESHOLD_FIELD.getPreferredName(), getRelevantRatingThreshold());
public class RecallAtK implements EvaluationMetric {
            throw new IllegalArgumentException("Window size k must be positive.");
    /**
package org.opensearch.index.rankeval;
     * "relevant" for this metric. Defaults to 1.
            return NAME;
    RecallAtK(StreamInput in) throws IOException {
        if (relevantRatingThreshold < 0) {
        Detail(StreamInput in) throws IOException {
    }
import org.opensearch.core.xcontent.XContentParser;
        public static Detail fromXContent(XContentParser parser) {
        builder.field(K_FIELD.getPreferredName(), getK());
 * this work for additional information regarding copyright
    }
        public void writeTo(StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    }
        Integer relevantRatingThreshold = (Integer) args[0];
                return true;
    }
        public long getRelevant() {
        out.writeVInt(getK());
    @Override
    private boolean isRelevant(int rating) {
        this.relevantRatingThreshold = relevantRatingThreshold;
        if (k <= 0) {
     * Compute recall at k based on provided relevant document IDs.
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        private static final ConstructingObjectParser<Detail, Void> PARSER = new ConstructingObjectParser<>(
            return builder;
 * You may obtain a copy of the License at
            recall = (double) relevantRetrieved / relevant;
    @Override
        }
 * SPDX-License-Identifier: Apache-2.0
            if (obj == null || getClass() != obj.getClass()) {
     * Return the rating threshold above which ratings are considered to be
        return rating >= getRelevantRatingThreshold();
        @Override
        }
            this.relevantRetrieved = relevantRetrieved;
 *
     * Binarizes a rating based on the relevant rating threshold.
 */
            }
        return Objects.hash(relevantRatingThreshold, k);
 * By default documents with a rating equal or bigger than 1 are considered to
    public static final class Detail implements MetricDetail {
 *
 */
        private long relevantRetrieved;
     * @return recall at k for above {@link SearchResult} list.
    private static final int DEFAULT_RELEVANT_RATING_THRESHOLD = 1;
            return relevantRetrieved;
 * `relevant_rating_threshold` parameter.<br>
/*
    public RecallAtK() {
        public String getWriteableName() {
        return new RecallAtK(
            this.relevantRetrieved = in.readVLong();
    @Override
    static {
        @Override
    @Override
import javax.naming.directory.SearchResult;
 * Licensed to Elasticsearch under one or more contributor
    public final boolean equals(Object obj) {
    }
            this.relevant = relevant;
    }
 * the Apache License, Version 2.0 (the "License"); you may
                return false;
     * Metric implementing Recall@K.
            PARSER.declareInt(constructorArg(), RELEVANT_DOCS_RETRIEVED_FIELD);
            }
    }
 * Metric implementing Recall@K
        }
    private static final ParseField RELEVANT_RATING_THRESHOLD_FIELD = new ParseField("relevant_rating_threshold");
        return relevantRatingThreshold;
            k == null ? DEFAULT_K : k
     *
    }
        private static final ParseField RELEVANT_DOCS_FIELD = new ParseField("relevant_docs");
            builder.field(RELEVANT_DOCS_RETRIEVED_FIELD.getPreferredName(), relevantRetrieved);
    public String getWriteableName() {
        return OptionalInt.of(getK());
        double recall = 0.0;
        );
    });
        private long relevant;
        }
 * The OpenSearch Contributors require contributions made to
        return builder;
            args -> new Detail((Integer) args[0], (Integer) args[1])
        Integer k = (Integer) args[1];
        PARSER.declareInt(optionalConstructorArg(), RELEVANT_RATING_THRESHOLD_FIELD);
        this.k = k;
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamInput;
        PARSER.declareInt(optionalConstructorArg(), K_FIELD);
            out.writeVLong(relevant);
        public long getRelevantRetrieved() {
    public static final String NAME = "recall";
 */
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamOutput;
        int relevant = 0;
 * (https://en.wikipedia.org/wiki/Evaluation_measures_(information_retrieval)#Recall).<br>
 *    http://www.apache.org/licenses/LICENSE-2.0
        public boolean equals(Object obj) {
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
    }
/**
            return Objects.hash(relevantRetrieved, relevant);
        return evalQueryQuality;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return false;
            return Objects.equals(relevantRetrieved, other.relevantRetrieved) && Objects.equals(relevant, other.relevant);
        }
import org.opensearch.core.xcontent.ConstructingObjectParser;
            }
        for (RatedSearchHit hit : ratedSearchHits) {
        List<RatedSearchHit> ratedSearchHits = joinHitsWithRatings(hits, ratedDocs);
            builder.field(RELEVANT_DOCS_FIELD.getPreferredName(), relevant);
            if (isRelevant(rd.getRating())) {
 * The `k` parameter (defaults to 10) controls the search window size.
        }
        builder.startObject();
}
        }
 * under the License.
            NAME,
     * @param k
 *
            this.relevant = in.readVLong();
            throw new IllegalArgumentException("Relevant rating threshold for precision must be positive integer.");
        out.writeVInt(getRelevantRatingThreshold());
    private static final ParseField K_FIELD = new ParseField("k");
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (relevant > 0) {
        }
     */
     *            controls the window size for the search results the metric takes into account
/*
import org.opensearch.search.SearchHit;
        builder.endObject();
     *            ratings equal or above this value will be considered relevant.
 * be "relevant" for this calculation. This value can be changed using the
     * @param relevantRatingThreshold
    /**
        evalQueryQuality.setMetricDetails(new RecallAtK.Detail(relevantRetrieved, relevant));
        }
import org.opensearch.core.ParseField;
    }
    private static final int DEFAULT_K = 10;
    }
            true,
        int relevantRetrieved = 0;
        }
        }
        }
    @Override
    private final int relevantRatingThreshold;
        }
    public int getK() {
    /**
import java.util.Objects;
    @Override
            out.writeVLong(relevantRetrieved);
        @Override
