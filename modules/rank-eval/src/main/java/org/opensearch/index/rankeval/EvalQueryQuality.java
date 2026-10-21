    }
            return false;
import org.opensearch.core.xcontent.ToXContentFragment;
 * license agreements. See the NOTICE file distributed with
    }
        EvalQueryQuality other = (EvalQueryQuality) obj;
 * SPDX-License-Identifier: Apache-2.0
        this.ratedHits = in.readList(RatedSearchHit::new);
    private EvalQueryQuality(String queryId, ParsedEvalQueryQuality builder) {
    private static final ObjectParser<ParsedEvalQueryQuality, Void> PARSER = new ObjectParser<>(
    }
    private static final ParseField HITS_FIELD = new ParseField("hits");
import org.opensearch.core.ParseField;
            builder.startObject();
    public EvalQueryQuality(String id, double metricScore) {
        builder.startArray(HITS_FIELD.getPreferredName());
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String getId() {
        return new EvalQueryQuality(queryId, PARSER.apply(parser, null));
        this.queryId = id;
        ParsedEvalQueryQuality::new
        return this.optionalMetricDetails;
    }
    }
    static final ParseField METRIC_SCORE_FIELD = new ParseField("metric_score");
        out.writeDouble(metricScore);
            hit.toXContent(builder, params);
    private MetricDetail optionalMetricDetails;
    public MetricDetail getMetricDetails() {
    }
 * specific language governing permissions and limitations
        this.ratedHits = builder.ratedHits;
/*
    }
        builder.startArray(UNRATED_DOCS_FIELD.getPreferredName());
        }
 * not use this file except in compliance with the License.
import java.util.Objects;
}
 * You may obtain a copy of the License at
    private final List<RatedSearchHit> ratedHits;
 */
        return this.ratedHits;
        PARSER.declareDouble((obj, value) -> obj.evaluationResult = value, METRIC_SCORE_FIELD);
        "eval_query_quality",
    private static MetricDetail parseMetricDetail(XContentParser parser) throws IOException {
        builder.endObject();
        this.queryId = queryId;
    private final double metricScore;
public class EvalQueryQuality implements ToXContentFragment, Writeable {
 * ownership. Elasticsearch licenses this file to you under
        this.queryId = in.readString();
    public EvalQueryQuality(StreamInput in) throws IOException {
    static {
            builder.field(METRIC_DETAILS_FIELD.getPreferredName(), optionalMetricDetails);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor
        PARSER.declareObjectArray((obj, list) -> obj.ratedHits = list, (p, c) -> RatedSearchHit.parse(p), HITS_FIELD);
    );
        MetricDetail metricDetail = parser.namedObject(MetricDetail.class, parser.currentName(), null);
import org.opensearch.core.common.io.stream.StreamOutput;
        return builder;
        this.ratedHits = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
    // only used for parsing internally
 *
        }
import java.util.ArrayList;
        return metricScore;
 * KIND, either express or implied.  See the License for the
        builder.startObject(queryId);
    public static EvalQueryQuality fromXContent(XContentParser parser, String queryId) throws IOException {
            builder.field(RatedDocument.INDEX_FIELD.getPreferredName(), key.getIndex());
    }
import java.io.IOException;
        PARSER.declareObject((obj, value) -> obj.optionalMetricDetails = value, (p, c) -> parseMetricDetail(p), METRIC_DETAILS_FIELD);
    }
            && Objects.equals(ratedHits, other.ratedHits)
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
    private final String queryId;
package org.opensearch.index.rankeval;
    }
        builder.endArray();
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);
        this.metricScore = in.readDouble();
import org.opensearch.core.xcontent.XContentBuilder;
        for (DocumentKey key : EvaluationMetric.filterUnratedDocuments(ratedHits)) {
        for (RatedSearchHit hit : ratedHits) {
 * The OpenSearch Contributors require contributions made to
 */
        this.optionalMetricDetails = breakdown;
 * Modifications Copyright OpenSearch Contributors. See
    private static final ParseField METRIC_DETAILS_FIELD = new ParseField("metric_details");
        if (obj == null || getClass() != obj.getClass()) {
    }
        List<RatedSearchHit> ratedHits = new ArrayList<>();
        out.writeString(queryId);
    public double metricScore() {
 *
import org.opensearch.core.xcontent.XContentParser;
    public List<RatedSearchHit> getHitsAndRatings() {
    }
        true,
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.ObjectParser;
        return Objects.equals(queryId, other.queryId)
    }
 */
        builder.field(METRIC_SCORE_FIELD.getPreferredName(), this.metricScore);
        this.metricScore = builder.evaluationResult;
        this.ratedHits.addAll(hits);
        MetricDetail optionalMetricDetails;
        out.writeList(ratedHits);
    public void setMetricDetails(MetricDetail breakdown) {
 * under the License.
    @Override
        out.writeOptionalNamedWriteable(this.optionalMetricDetails);
 */
    private static final ParseField UNRATED_DOCS_FIELD = new ParseField("unrated_docs");
 * GitHub history for details.
    }
    public void addHitsAndRatings(List<RatedSearchHit> hits) {
        if (optionalMetricDetails != null) {
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
            builder.field(RatedDocument.DOC_ID_FIELD.getPreferredName(), key.getDocId());
        }
    }
        return queryId;
 * this work for additional information regarding copyright
    @Override
    }
 * the Apache License, Version 2.0 (the "License"); you may
            && Objects.equals(optionalMetricDetails, other.optionalMetricDetails);
    public final boolean equals(Object obj) {
        return metricDetail;
        builder.endArray();
/**
        }
    public final int hashCode() {
 *
        this.optionalMetricDetails = in.readOptionalNamedWriteable(MetricDetail.class);
/*
        if (this == obj) {
 * software distributed under the License is distributed on an
        }
            builder.endObject();
import org.opensearch.index.rankeval.RatedDocument.DocumentKey;
    private static class ParsedEvalQueryQuality {
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.xcontent.XContentParserUtils;
/*
        this.optionalMetricDetails = builder.optionalMetricDetails;
 * Result of the evaluation metric calculation on one particular query alone.
import java.util.List;
        double evaluationResult;
    }
        return Objects.hash(queryId, metricScore, ratedHits, optionalMetricDetails);
            && Objects.equals(metricScore, other.metricScore)
 * compatible open source license.
        this.metricScore = metricScore;
            return true;
    @Override
