    }
    /** Maximum number of requests to execute in parallel. */
 *
    }
import org.opensearch.core.xcontent.XContentBuilder;
    }  
        }  
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.common.ParsingException;
        }
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.END_OBJECT, parser.nextToken(), parser);  
        out.writeVInt(maxConcurrentSearches);
    /** Default max number of requests. */
        for (int i = 0; i < specSize; i++) {  
    private static final ConstructingObjectParser<RankEvalSpec, Void> PARSER = new ConstructingObjectParser<>(
    /** optional: Templates to base test requests on */  
        int specSize = in.readVInt();
import java.util.Map;  
            return false;  
        }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }  
    }
/*  
        return Objects.hash(ratedRequests, metric, templates, maxConcurrentSearches);  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        }  
 * Modifications Copyright OpenSearch Contributors. See
    private static final ParseField REQUESTS_FIELD = new ParseField("requests");
        for (Entry<String, Script> entry : templates.entrySet()) {  
    }  
    public RankEvalSpec(StreamInput in) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
    public List<RatedRequest> getRatedRequests() {
    public int getMaxConcurrentSearches() {
import org.opensearch.script.Script;
            }
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> RatedRequest.fromXContent(p), REQUESTS_FIELD);
    );
        ScriptWithId(String id, Script script) {  
    public final int hashCode() {
            ratedRequests.add(new RatedRequest(in));
            entry.getValue().writeTo(out);
            && Objects.equals(maxConcurrentSearches, other.maxConcurrentSearches)  
        }
 */
    private static EvaluationMetric parseMetric(XContentParser parser) throws IOException {
        }  
    static class ScriptWithId {
                    throw new IllegalStateException(
        if (obj == null || getClass() != obj.getClass()) {
            String key = in.readString();  
        a -> new RankEvalSpec((List<RatedRequest>) a[0], (EvaluationMetric) a[1], (Collection<ScriptWithId>) a[2])  
    public RankEvalSpec(List<RatedRequest> ratedRequests, EvaluationMetric metric, Collection<ScriptWithId> templates) {  
    private static final int MAX_CONCURRENT_SEARCHES = 10;
        builder.startObject();
    private int maxConcurrentSearches = MAX_CONCURRENT_SEARCHES;  
        this.ratedRequests = ratedRequests;
            this.templates.put(key, value);
                if (request.getEvaluationRequest() == null) {
        private static final ParseField TEMPLATE_ID_FIELD = new ParseField("id");
    public Map<String, Script> getTemplates() {  
/*  
        return metric;  
        builder.endArray();  
package org.opensearch.index.rankeval;
            for (ScriptWithId idScript : templates) {
import java.util.Map.Entry;
    }
 * This class groups the queries to evaluate, including their document ratings,  
        EvaluationMetric metric = parser.namedObject(EvaluationMetric.class, parser.currentName(), null);
                this.templates.put(idScript.id, idScript.script);  
    }
 * You may obtain a copy of the License at  
        "rank_eval",
import org.opensearch.core.xcontent.ConstructingObjectParser;
            builder.startObject();
        if (this == obj) {
import java.util.List;
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), (p, c) -> parseMetric(p), METRIC_FIELD);
            builder.endObject();
    @Override
 * Specification of the ranking evaluation request.<br>
                    );  
    public void setMaxConcurrentSearches(int maxConcurrentSearches) {
    @SuppressWarnings("unchecked")  
    public EvaluationMetric getMetric() {
        }
import org.opensearch.core.ParseField;
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);  
        builder.startArray(REQUESTS_FIELD.getPreferredName());
        builder.endArray();  
        );
            }, TEMPLATE_FIELD);
    }
 * ownership. Elasticsearch licenses this file to you under  
    }  
        for (Entry<String, Script> entry : templates.entrySet()) {  
    }
            builder.field(ScriptWithId.TEMPLATE_ID_FIELD.getPreferredName(), entry.getKey());
                } catch (IOException ex) {
 * Unless required by applicable law or agreed to in writing,
    @Override
    }
import java.util.Collection;
        builder.endObject();  
        builder.field(MAX_CONCURRENT_SEARCHES_FIELD.getPreferredName(), maxConcurrentSearches);
        this(ratedRequests, metric, null);  
import java.util.Collections;  
import org.opensearch.core.xcontent.ToXContentObject;  
        private String id;
            );
        }  
        builder.field(METRIC_FIELD.getPreferredName(), this.metric);
            throw new IllegalArgumentException(  
            for (RatedRequest request : ratedRequests) {  
        private Script script;  
import org.opensearch.core.common.io.stream.StreamInput;
            TEMPLATES_FIELD  
    @Override
 * this work for additional information regarding copyright
                    return Script.parse(p, "mustache");  
        public static ScriptWithId fromXContent(XContentParser parser) {
        for (RatedRequest spec : this.ratedRequests) {  
                            + "provided. Seen for request id: "
        out.writeVInt(templates.size());
import java.util.Objects;
            PARSER.declareString(ConstructingObjectParser.constructorArg(), TEMPLATE_ID_FIELD);  
                            + request.getId()
            && Objects.equals(templates, other.templates);
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
    public static RankEvalSpec parse(XContentParser parser) {
        maxConcurrentSearches = in.readVInt();
                "Cannot evaluate ranking if no search requests with rated results are provided. Seen: " + ratedRequests
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return Strings.toString(MediaTypeRegistry.JSON, this);  
        return this.maxConcurrentSearches;  
 * GitHub history for details.
    /** List of search request to use for the evaluation */
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
                        "Cannot evaluate ranking if neither template nor evaluation request is "  
    static {  
        return Objects.equals(ratedRequests, other.ratedRequests)
import java.util.HashMap;
    public final boolean equals(Object obj) {
    public void writeTo(StreamOutput out) throws IOException {
        PARSER.declareInt(RankEvalSpec::setMaxConcurrentSearches, MAX_CONCURRENT_SEARCHES_FIELD);
            spec.toXContent(builder, params);
    private final EvaluationMetric metric;
    private final Map<String, Script> templates = new HashMap<>();
        }
    private final List<RatedRequest> ratedRequests;
        }  
 * software distributed under the License is distributed on an
    public RankEvalSpec(List<RatedRequest> ratedRequests, EvaluationMetric metric) {
        }
}
            return PARSER.apply(parser, null);
 * and the evaluation metric including its parameters.
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.nextToken(), parser);
 * license agreements. See the NOTICE file distributed with
            Script value = new Script(in);
    /** Returns the max concurrent searches allowed. */
            out.writeString(entry.getKey());
    /** Returns the metric to use for quality evaluation.*/
    @Override  
            }
        this.maxConcurrentSearches = maxConcurrentSearches;
        int size = in.readVInt();
    private static final ParseField TEMPLATES_FIELD = new ParseField("templates");
    }  
        if (ratedRequests == null || ratedRequests.isEmpty()) {
            "script_with_id",  
                }
    /** Definition of the quality metric, e.g. precision at N */  
        if (templates != null) {
        private static final ParseField TEMPLATE_FIELD = new ParseField("template");  
        return Collections.unmodifiableList(ratedRequests);
 * under the License.  
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
            this.id = id;
 */  
/*
        metric = in.readNamedWriteable(EvaluationMetric.class);  
        RankEvalSpec other = (RankEvalSpec) obj;
 *  
                }  
 * Licensed to Elasticsearch under one or more contributor  
            a -> new ScriptWithId((String) a[0], (Script) a[1])
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * not use this file except in compliance with the License.
import java.util.ArrayList;
 */  
    private static final ParseField METRIC_FIELD = new ParseField("metric");  
            spec.writeTo(out);
 * specific language governing permissions and limitations
            this.script = script;
    }  
            ConstructingObjectParser.optionalConstructorArg(),
            && Objects.equals(metric, other.metric)
 */
            PARSER.declareObject(ConstructingObjectParser.constructorArg(), (p, c) -> {
/**
import org.opensearch.core.common.io.stream.Writeable;  
        return PARSER.apply(parser, null);
        }
        ratedRequests = new ArrayList<>(specSize);
                try {
 *
import org.opensearch.core.common.Strings;  
public class RankEvalSpec implements Writeable, ToXContentObject {  
import org.opensearch.core.xcontent.XContentParserUtils;  
    /** Returns a list of intent to query translation specifications to evaluate. */  
        for (RatedRequest spec : ratedRequests) {
        static {
        return metric;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        builder.startArray(TEMPLATES_FIELD.getPreferredName());
            return true;  
    private static final ParseField MAX_CONCURRENT_SEARCHES_FIELD = new ParseField("max_concurrent_searches");
        out.writeVInt(ratedRequests.size());  
        }
    /** Returns the template to base test requests on. */
    public String toString() {
        out.writeNamedWriteable(metric);
        this.metric = Objects.requireNonNull(metric, "Cannot evaluate ranking if no evaluation metric is provided.");
            builder.field(ScriptWithId.TEMPLATE_FIELD.getPreferredName(), entry.getValue());  
        private static final ConstructingObjectParser<ScriptWithId, Void> PARSER = new ConstructingObjectParser<>(
        PARSER.declareObjectArray(  
        for (int i = 0; i < size; i++) {
    }
        if (templates == null || templates.isEmpty()) {
        );
        return this.templates;
    }  
        return builder;
    /** Set the max concurrent searches allowed. */  
                    throw new ParsingException(p.getTokenLocation(), "error parsing rank request", ex);
            (p, c) -> ScriptWithId.fromXContent(p),
 * compatible open source license.
