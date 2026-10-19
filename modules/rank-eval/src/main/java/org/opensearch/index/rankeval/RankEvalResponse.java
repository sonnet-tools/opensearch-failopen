            details.get(key).toXContent(builder, params);  
}
import java.util.HashMap;
    }
        for (int i = 0; i < failuresSize; i++) {
    public String toString() {
    static {
        builder.endObject();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        super(in);
    private static final ParseField FAILURES_FIELD = new ParseField("failures");  
import java.io.IOException;  
    }
            (p, c, n) -> EvalQueryQuality.fromXContent(p, n),  
        out.writeVInt(details.size());  
        return metricScore;
 * specific language governing permissions and limitations
    @Override  
            String queryId = in.readString();
 * Returns the results for a {@link RankEvalRequest}.<br>  
import java.util.stream.Collectors;  
        builder.startObject("details");
    /** details about individual ranking evaluation queries, keyed by their id */
        true,
 * software distributed under the License is distributed on an
        builder.endObject();  
    }
        out.writeVInt(failures.size());
    }
    public Map<String, Exception> getFailures() {  
import org.opensearch.common.collect.Tuple;
        }
 *
        return builder;
    }  
import org.opensearch.core.common.Strings;
import java.util.function.Function;
    private static final ParseField DETAILS_FIELD = new ParseField("details");
            EvalQueryQuality partial = new EvalQueryQuality(in);
            this.failures.put(queryId, in.readException());  
 * compatible open source license.
            DETAILS_FIELD
    }
        for (int i = 0; i < partialResultSize; i++) {  
 * Unless required by applicable law or agreed to in writing,
            ((List<Tuple<String, Exception>>) a[2]).stream().collect(Collectors.toMap(Tuple::v1, Tuple::v2))
    private Map<String, EvalQueryQuality> details;  
        builder.startObject("failures");  
            out.writeString(queryId);
    public RankEvalResponse(double metricScore, Map<String, EvalQueryQuality> partialResults, Map<String, Exception> failures) {
    /** The overall evaluation result. */  
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
        PARSER.declareDouble(ConstructingObjectParser.constructorArg(), EvalQueryQuality.METRIC_SCORE_FIELD);  
            builder.endObject();
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.OpenSearchException;
        }
    @SuppressWarnings("unchecked")
        PARSER.declareNamedObjects(ConstructingObjectParser.optionalConstructorArg(), (p, c, n) -> {  
            this.details.put(queryId, partial);  
    );
    @Override
 *
        }
    private static final ConstructingObjectParser<RankEvalResponse, Void> PARSER = new ConstructingObjectParser<>(
        }
    private Map<String, Exception> failures;
/**
        builder.startObject();
    private double metricScore;
 * Licensed to Elasticsearch under one or more contributor  
        return Collections.unmodifiableMap(details);  
/*  
            return tuple;
            out.writeString(queryId);
    }
 * this work for additional information regarding copyright
        this.details = new HashMap<>(partialResultSize);
public class RankEvalResponse extends ActionResponse implements ToXContentObject {
/*  
import java.util.List;  
            OpenSearchException.generateFailureXContent(builder, params, failures.get(key), true);  
import org.opensearch.core.ParseField;  
    }  
        this.details = new HashMap<>(partialResults);  
import java.util.Collections;
/*
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        this.metricScore = metricScore;
            String queryId = in.readString();
 * under the License.  
package org.opensearch.index.rankeval;
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, p.nextToken(), p);
        this.metricScore = in.readDouble();  
 *  
import org.opensearch.core.xcontent.XContentParserUtils;
        this.failures = new HashMap<>(failures);
        for (String queryId : details.keySet()) {
        builder.endObject();
 * The response contains a detailed section for each evaluation query in the request and
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * SPDX-License-Identifier: Apache-2.0
            (Double) a[0],  
        }
        a -> new RankEvalResponse(
    @Override  
 */  
import org.opensearch.core.xcontent.XContentParser;  
        return Collections.unmodifiableMap(failures);
    }
    public static RankEvalResponse fromXContent(XContentParser parser) throws IOException {
        PARSER.declareNamedObjects(
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.END_OBJECT, p.nextToken(), p);
    /** exceptions for specific ranking evaluation queries, keyed by their id */
 * KIND, either express or implied.  See the License for the
        int partialResultSize = in.readVInt();
        "rank_eval_response",  
    RankEvalResponse(StreamInput in) throws IOException {
import java.util.Map;
 * ownership. Elasticsearch licenses this file to you under  
        );
        }, FAILURES_FIELD);  
    public double getMetricScore() {
 * GitHub history for details.
 **/  
import org.opensearch.core.action.ActionResponse;
            builder.startObject(key);
            out.writeException(failures.get(queryId));
 * not use this file except in compliance with the License.
 */
import org.opensearch.core.xcontent.ConstructingObjectParser;
        int failuresSize = in.readVInt();
        for (String key : failures.keySet()) {
            Tuple<String, OpenSearchException> tuple = new Tuple<>(n, OpenSearchException.failureFromXContent(p));  
        }  
 * possible failures that happened when execution individual queries.
        out.writeDouble(metricScore);
        for (String key : details.keySet()) {
            details.get(queryId).writeTo(out);  
        builder.field("metric_score", metricScore);  
        return PARSER.apply(parser, null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (String queryId : failures.keySet()) {  
        )  
import org.opensearch.core.xcontent.ToXContentObject;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
    public Map<String, EvalQueryQuality> getPartialResults() {
        this.failures = new HashMap<>(failuresSize);  
            ConstructingObjectParser.optionalConstructorArg(),
import org.opensearch.core.common.io.stream.StreamInput;  
 * The OpenSearch Contributors require contributions made to  
        return Strings.toString(MediaTypeRegistry.JSON, this);  
            ((List<EvalQueryQuality>) a[1]).stream().collect(Collectors.toMap(EvalQueryQuality::getId, Function.identity())),
            XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, p.nextToken(), p);
