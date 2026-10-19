        return new EvalQueryQuality(queryId, PARSER.apply(parser, null));  
    private static final ParseField UNRATED_DOCS_FIELD = new ParseField("unrated_docs");  
    }  
    }
    }
        this.metricScore = metricScore;
/*  
 *  
    public String getId() {
    }  
    private MetricDetail optionalMetricDetails;  
    @Override  
        this.metricScore = in.readDouble();
import java.util.List;
    }
        }  
 * software distributed under the License is distributed on an
            return true;  
        MetricDetail optionalMetricDetails;
        builder.endObject();
            hit.toXContent(builder, params);
        if (this == obj) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        builder.endArray();  
            builder.field(RatedDocument.INDEX_FIELD.getPreferredName(), key.getIndex());  
        builder.startObject(queryId);
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
}
 * KIND, either express or implied.  See the License for the
import java.util.ArrayList;
    }
        builder.startArray(HITS_FIELD.getPreferredName());
 * Result of the evaluation metric calculation on one particular query alone.  
import org.opensearch.core.xcontent.XContentParserUtils;  
    private static class ParsedEvalQueryQuality {  
import org.opensearch.index.rankeval.RatedDocument.DocumentKey;
        return queryId;  
        PARSER.declareObjectArray((obj, list) -> obj.ratedHits = list, (p, c) -> RatedSearchHit.parse(p), HITS_FIELD);  
 * under the License.  
    public final int hashCode() {
/*  
    }
        out.writeList(ratedHits);
    public static EvalQueryQuality fromXContent(XContentParser parser, String queryId) throws IOException {
 * You may obtain a copy of the License at  
        out.writeString(queryId);
    @Override  
        this.queryId = id;
        }  
        this.queryId = queryId;  
 * GitHub history for details.
    static final ParseField METRIC_SCORE_FIELD = new ParseField("metric_score");
 * this work for additional information regarding copyright
            && Objects.equals(metricScore, other.metricScore)
import org.opensearch.core.xcontent.XContentParser;
    public final boolean equals(Object obj) {
        for (DocumentKey key : EvaluationMetric.filterUnratedDocuments(ratedHits)) {
import org.opensearch.core.common.io.stream.Writeable;
/*
    }  
 * The OpenSearch Contributors require contributions made to  
    }  
        this.optionalMetricDetails = in.readOptionalNamedWriteable(MetricDetail.class);
 * this file be licensed under the Apache-2.0 license or a
    }
 */
        ParsedEvalQueryQuality::new  
    private static final ObjectParser<ParsedEvalQueryQuality, Void> PARSER = new ObjectParser<>(  
        PARSER.declareDouble((obj, value) -> obj.evaluationResult = value, METRIC_SCORE_FIELD);
    public List<RatedSearchHit> getHitsAndRatings() {
        }
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
        EvalQueryQuality other = (EvalQueryQuality) obj;
        MetricDetail metricDetail = parser.namedObject(MetricDetail.class, parser.currentName(), null);  
            && Objects.equals(ratedHits, other.ratedHits)
 *
    private final String queryId;
    public double metricScore() {  
import org.opensearch.core.common.io.stream.StreamInput;
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
    private final List<RatedSearchHit> ratedHits;
 * Modifications Copyright OpenSearch Contributors. See
        this.ratedHits.addAll(hits);
    private final double metricScore;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
            builder.startObject();
import org.opensearch.core.xcontent.ToXContentFragment;  
        this.ratedHits = builder.ratedHits;  
package org.opensearch.index.rankeval;
        return this.optionalMetricDetails;  
    }
        builder.startArray(UNRATED_DOCS_FIELD.getPreferredName());  
        PARSER.declareObject((obj, value) -> obj.optionalMetricDetails = value, (p, c) -> parseMetricDetail(p), METRIC_DETAILS_FIELD);
        this.optionalMetricDetails = breakdown;
            builder.endObject();
    public EvalQueryQuality(String id, double metricScore) {  
        List<RatedSearchHit> ratedHits = new ArrayList<>();  
        builder.endArray();
            return false;  
        if (obj == null || getClass() != obj.getClass()) {
    }
 * SPDX-License-Identifier: Apache-2.0
        for (RatedSearchHit hit : ratedHits) {  
    public MetricDetail getMetricDetails() {
 * Unless required by applicable law or agreed to in writing,
        return metricDetail;
        return builder;
    }  
        return Objects.hash(queryId, metricScore, ratedHits, optionalMetricDetails);
        this.metricScore = builder.evaluationResult;
import java.util.Objects;  
    public void writeTo(StreamOutput out) throws IOException {
    // only used for parsing internally
import org.opensearch.core.common.io.stream.StreamOutput;  
    private static MetricDetail parseMetricDetail(XContentParser parser) throws IOException {  
        return Objects.equals(queryId, other.queryId)  
 */  
 */  
    }  
        builder.field(METRIC_SCORE_FIELD.getPreferredName(), this.metricScore);
public class EvalQueryQuality implements ToXContentFragment, Writeable {
        out.writeDouble(metricScore);  
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
import org.opensearch.core.xcontent.XContentBuilder;
        }
        return this.ratedHits;
        out.writeOptionalNamedWriteable(this.optionalMetricDetails);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.ParseField;
            && Objects.equals(optionalMetricDetails, other.optionalMetricDetails);  
 * license agreements. See the NOTICE file distributed with
/**
        double evaluationResult;
        "eval_query_quality",
    );
        return metricScore;
            builder.field(METRIC_DETAILS_FIELD.getPreferredName(), optionalMetricDetails);
    public void addHitsAndRatings(List<RatedSearchHit> hits) {  
    public void setMetricDetails(MetricDetail breakdown) {
        this.optionalMetricDetails = builder.optionalMetricDetails;
        this.ratedHits = new ArrayList<>();  
            builder.field(RatedDocument.DOC_ID_FIELD.getPreferredName(), key.getDocId());
 * specific language governing permissions and limitations
 *
        this.queryId = in.readString();
        this.ratedHits = in.readList(RatedSearchHit::new);  
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.ObjectParser;
import java.io.IOException;  
        }
        true,
 * compatible open source license.
    public EvalQueryQuality(StreamInput in) throws IOException {  
        if (optionalMetricDetails != null) {
    private static final ParseField HITS_FIELD = new ParseField("hits");
 */
 * ownership. Elasticsearch licenses this file to you under  
    }
    }
    static {  
    private static final ParseField METRIC_DETAILS_FIELD = new ParseField("metric_details");
    private EvalQueryQuality(String queryId, ParsedEvalQueryQuality builder) {
    }
