        if (relevantRatingThreshold < 0) {
            return PARSER.apply(parser, null);  
    public int getK() {
            }  
        builder.field(K_FIELD.getPreferredName(), getK());  
    /**
 */  
        private long relevantRetrieved;
    private final int k;  
 *  
import org.opensearch.core.ParseField;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.OptionalInt;
    @Override
        for (RatedDocument rd : ratedDocs) {  
 * The OpenSearch Contributors require contributions made to  
        this.relevantRatingThreshold = relevantRatingThreshold;
        out.writeVInt(getK());
        return k;
    }
        Detail(StreamInput in) throws IOException {
            PARSER.declareInt(constructorArg(), RELEVANT_DOCS_RETRIEVED_FIELD);
    private static final ConstructingObjectParser<RecallAtK, Void> PARSER = new ConstructingObjectParser<>(NAME, args -> {
    }  
        return Objects.hash(relevantRatingThreshold, k);
import java.util.Objects;
        }
            if (this == obj) {
import org.opensearch.search.SearchHit;
    @Override
            this.relevantRetrieved = relevantRetrieved;  
        evalQueryQuality.setMetricDetails(new RecallAtK.Detail(relevantRetrieved, relevant));  
 * this work for additional information regarding copyright
     *
    @Override  
        RecallAtK other = (RecallAtK) obj;
                relevantRetrieved++;
        public long getRelevantRetrieved() {  
        PARSER.declareInt(optionalConstructorArg(), K_FIELD);  
            }
import java.io.IOException;
public class RecallAtK implements EvaluationMetric {
        int relevant = 0;
    RecallAtK(StreamInput in) throws IOException {  
        Integer k = (Integer) args[1];  
        out.writeVInt(getRelevantRatingThreshold());  
        return builder;  
        return PARSER.apply(parser, null);
            throw new IllegalArgumentException("Window size k must be positive.");
    private final int relevantRatingThreshold;
        for (RatedSearchHit hit : ratedSearchHits) {
    }  
            PARSER.declareInt(constructorArg(), RELEVANT_DOCS_FIELD);
 *
 * By default documents with a rating equal or bigger than 1 are considered to
            NAME,
 */  
 * the Apache License, Version 2.0 (the "License"); you may
            args -> new Detail((Integer) args[0], (Integer) args[1])  
        builder.startObject(NAME);
 *    http://www.apache.org/licenses/LICENSE-2.0
        this(DEFAULT_RELEVANT_RATING_THRESHOLD, DEFAULT_K);  
            relevantRatingThreshold == null ? DEFAULT_RELEVANT_RATING_THRESHOLD : relevantRatingThreshold,
        }
import javax.naming.directory.SearchResult;  
        public void writeTo(StreamOutput out) throws IOException {
 * You may obtain a copy of the License at  
        int relevantRetrieved = 0;  
     * Metric implementing Recall@K.  
import java.util.List;  
            return relevant;
        Detail(long relevantRetrieved, long relevant) {
        this.k = k;
 * compatible open source license.
            this.relevant = relevant;
     * "relevant" for this metric. Defaults to 1.
 * license agreements. See the NOTICE file distributed with
    public EvalQueryQuality evaluate(String taskId, SearchHit[] hits, List<RatedDocument> ratedDocs) {
            return false;
    }
        public int hashCode() {  
 * `relevant_rating_threshold` parameter.<br>
    public OptionalInt forcedSearchSize() {  
        }  
 *
        }
        Integer relevantRatingThreshold = (Integer) args[0];
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
        return OptionalInt.of(getK());
        return Objects.equals(relevantRatingThreshold, other.relevantRatingThreshold) && Objects.equals(k, other.k);
        );
    /**
        evalQueryQuality.addHitsAndRatings(ratedSearchHits);
    }
    }
        return new RecallAtK(
    public String getWriteableName() {
        @Override
            return builder;
        return relevantRatingThreshold;
    public RecallAtK(int relevantRatingThreshold, int k) {  
}
     * Return the rating threshold above which ratings are considered to be  
 */  
        EvalQueryQuality evalQueryQuality = new EvalQueryQuality(taskId, recall);
            builder.field(RELEVANT_DOCS_FIELD.getPreferredName(), relevant);  
    public int getRelevantRatingThreshold() {  
        PARSER.declareInt(optionalConstructorArg(), RELEVANT_RATING_THRESHOLD_FIELD);
        public String getWriteableName() {
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
    private static final int DEFAULT_RELEVANT_RATING_THRESHOLD = 1;
    @Override
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
import org.opensearch.core.common.io.stream.StreamInput;
    private static final ParseField RELEVANT_RATING_THRESHOLD_FIELD = new ParseField("relevant_rating_threshold");
 * (https://en.wikipedia.org/wiki/Evaluation_measures_(information_retrieval)#Recall).<br>
     */  
import org.opensearch.core.xcontent.XContentBuilder;
    private static final int DEFAULT_K = 10;  
            if (isRelevant(rd.getRating())) {
    }  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.rankeval;
            if (obj == null || getClass() != obj.getClass()) {
import org.opensearch.core.common.io.stream.StreamOutput;  
        }  
    }
        }  
    /**
            return Objects.equals(relevantRetrieved, other.relevantRetrieved) && Objects.equals(relevant, other.relevant);
    @Override
        return NAME;
        @Override
            builder.field(RELEVANT_DOCS_RETRIEVED_FIELD.getPreferredName(), relevantRetrieved);
                return true;
        }
            RecallAtK.Detail other = (RecallAtK.Detail) obj;
        }
/*
        }
        }
            out.writeVLong(relevant);  
 * be "relevant" for this calculation. This value can be changed using the  
        if (this == obj) {
            k == null ? DEFAULT_K : k  
        builder.endObject();
     * @param k  
                relevant++;
    private static final ParseField K_FIELD = new ParseField("k");  
            throw new IllegalArgumentException("Relevant rating threshold for precision must be positive integer.");
     */
 * software distributed under the License is distributed on an
    }  
            return NAME;  
            recall = (double) relevantRetrieved / relevant;
            this.relevantRetrieved = in.readVLong();
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        if (k <= 0) {
        }
     **/  
    }
        double recall = 0.0;  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        }  
     * @return recall at k for above {@link SearchResult} list.
            if (rating.isPresent() && isRelevant(rating.getAsInt())) {  
    }  
        }  
     *            ratings equal or above this value will be considered relevant.
        public boolean equals(Object obj) {  
        @Override  
    public final boolean equals(Object obj) {  
    }  
        @Override  
 * under the License.  
    private boolean isRelevant(int rating) {
import org.opensearch.core.xcontent.XContentParser;  
        this(in.readVInt(), in.readVInt());
        if (obj == null || getClass() != obj.getClass()) {
     * Compute recall at k based on provided relevant document IDs.  
    /**
        private static final ParseField RELEVANT_DOCS_RETRIEVED_FIELD = new ParseField("relevant_docs_retrieved");  
    public RecallAtK() {
     * Binarizes a rating based on the relevant rating threshold.
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
            return true;
    }  
     *            controls the window size for the search results the metric takes into account
        return rating >= getRelevantRatingThreshold();
    }
            out.writeVLong(relevantRetrieved);
    }
     */
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
        private long relevant;  
    public static RecallAtK fromXContent(XContentParser parser) {  
            return relevantRetrieved;
            OptionalInt rating = hit.getRating();
    public static final String NAME = "recall";  
/*  
    public static final class Detail implements MetricDetail {
/**
    @Override
        @Override
 * The `k` parameter (defaults to 10) controls the search window size.
    public final int hashCode() {  
 * specific language governing permissions and limitations
 * Metric implementing Recall@K  
import org.opensearch.core.xcontent.ConstructingObjectParser;
            true,
        }  
    static {
        }  
        private static final ConstructingObjectParser<Detail, Void> PARSER = new ConstructingObjectParser<>(  
import static org.opensearch.index.rankeval.EvaluationMetric.joinHitsWithRatings;  
 * ownership. Elasticsearch licenses this file to you under  
            }  
            }  
        private static final ParseField RELEVANT_DOCS_FIELD = new ParseField("relevant_docs");
        }  
 * not use this file except in compliance with the License.
        }  
    public void writeTo(StreamOutput out) throws IOException {
        public long getRelevant() {
        }
/*  
     * @param relevantRatingThreshold
        builder.startObject();  
    }
        if (relevant > 0) {
    });
        static {  
 * SPDX-License-Identifier: Apache-2.0
        return evalQueryQuality;
        public static Detail fromXContent(XContentParser parser) {
        builder.field(RELEVANT_RATING_THRESHOLD_FIELD.getPreferredName(), getRelevantRatingThreshold());
            this.relevant = in.readVLong();  
        List<RatedSearchHit> ratedSearchHits = joinHitsWithRatings(hits, ratedDocs);
            return Objects.hash(relevantRetrieved, relevant);
        builder.endObject();
                return false;
