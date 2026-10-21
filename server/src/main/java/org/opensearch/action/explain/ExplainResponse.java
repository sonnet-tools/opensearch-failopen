        explanationParser.declareObjectArray(ConstructingObjectParser.constructorArg(), explanationParser, DETAILS);
                }
 * the Apache License, Version 2.0 (the "License"); you may
                    return Explanation.match((float) arg[0], (String) arg[1], (Collection<Explanation>) arg[2]);
    public ExplainResponse(String index, String id, boolean exists, Explanation explanation, GetResult getResult) {
    private static final ParseField _INDEX = new ParseField("_index");
            true,
import org.opensearch.core.ParseField;
    private String index;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            out.writeBoolean(true);
                } else {
        return index;
        if (getResult != null) {
 * KIND, either express or implied.  See the License for the
        }
import org.opensearch.index.mapper.MapperService;
 *
            getResult = new GetResult(in);
        return id;
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
        if (in.readBoolean()) {
        }
    private static final ParseField EXPLANATION = new ParseField("explanation");
 * SPDX-License-Identifier: Apache-2.0
        }
    }
        return explanation;
 *
 *
import org.opensearch.core.action.ActionResponse;
        out.writeString(index);
 * software distributed under the License is distributed on an
            out.writeBoolean(false);
        } else {
import org.opensearch.index.get.GetResult;
    }
import static org.opensearch.common.lucene.Lucene.writeExplanation;
    private static final ParseField GET = new ParseField("get");
        }
        builder.startObject();
        return getResult;
                if ((float) arg[0] > 0) {
                builder.endObject();
                    return Explanation.noMatch((String) arg[1], (Collection<Explanation>) arg[2]);
    private static final ParseField MATCHED = new ParseField("matched");
    @Override
        if (hasExplanation()) {
        "explain",
        if (obj == null || getClass() != obj.getClass()) {
        index = in.readString();
        if (in.getVersion().before(Version.V_2_0_0)) {
        ExplainResponse other = (ExplainResponse) obj;
import java.io.IOException;
    private Explanation explanation;
    private GetResult getResult;
        explanationParser.declareFloat(ConstructingObjectParser.constructorArg(), VALUE);
            && Objects.equals(getResult.sourceAsMap(), other.getResult.sourceAsMap())
    }
    private static final ConstructingObjectParser<ExplainResponse, Boolean> PARSER = new ConstructingObjectParser<>(
    private String id;
    @Override
        }
 */
 * under the License.
    }
    private boolean exists;
    }
    }
 * The OpenSearch Contributors require contributions made to
 */
}
    }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;
    }
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), explanationParser, EXPLANATION);
        this.id = id;
 * this file be licensed under the Apache-2.0 license or a
    @Override
        if (in.readBoolean()) {
        Explanation[] innerExps = explanation.getDetails();
import org.opensearch.Version;
        this(index, id, exists);
    public boolean isExists() {
 * not use this file except in compliance with the License.
            builder.endObject();
            return true;
        if (getResult == null) {
            out.writeBoolean(true);
            builder.startObject(GET.getPreferredName());
            getResult.toXContentEmbedded(builder, params);
    public static ExplainResponse fromXContent(XContentParser parser, boolean exists) {
import org.opensearch.core.xcontent.XContentBuilder;
            arg -> {
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        }
 * specific language governing permissions and limitations
        PARSER.declareString(ConstructingObjectParser.constructorArg(), _ID);
import java.util.Collection;
        this.getResult = getResult;
    static {
 */
    );
    public String getIndex() {
            getResult.writeTo(out);
        return explanation != null && explanation.isMatch();
        }
        this.index = index;
            explanation = readExplanation(in);
        this.exists = exists;
            writeExplanation(out, explanation);
            builder.endArray();
import org.apache.lucene.search.Explanation;
        return exists;
    private static final ParseField _ID = new ParseField("_id");
    public ExplainResponse(StreamInput in) throws IOException {
    }
            && Objects.equals(explanation, other.explanation)
                builder.startObject();
        } else {
        return index.equals(other.index)
        builder.field(VALUE.getPreferredName(), explanation.getValue());
            }
        this.explanation = explanation;
        builder.field(_ID.getPreferredName(), id);
    private static final ParseField VALUE = new ParseField("value");
            "explanation",
 */
@PublicApi(since = "1.0.0")
            in.readString();
    public ExplainResponse(String index, String id, boolean exists, Explanation explanation) {
    }
    public String getId() {
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;
        return explanation != null;
        exists = in.readBoolean();
        true,
/*
package org.opensearch.action.explain;
    @Override
        return builder;
            builder.endObject();
        return Objects.hash(index, id, explanation, getResult.isExists(), getResult.sourceAsMap(), getResult.getFields());
/**
/*
        out.writeString(id);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
            && Objects.equals(getResult.getFields(), other.getResult.getFields());
        builder.endObject();
 * @opensearch.api
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
public class ExplainResponse extends ActionResponse implements StatusToXContentObject {
    public ExplainResponse(String index, String id, boolean exists) {
    public RestStatus status() {
 * license agreements. See the NOTICE file distributed with
    }
        this(index, id, exists, explanation);
 *
 * ownership. Elasticsearch licenses this file to you under
        if (innerExps != null) {
import java.util.Objects;
        }
    public boolean isMatch() {
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> GetResult.fromXContentEmbedded(p), GET);
        builder.field(DESCRIPTION.getPreferredName(), explanation.getDescription());
    public GetResult getGetResult() {
        if (explanation == null) {
import static org.opensearch.common.lucene.Lucene.readExplanation;
        id = in.readString();
    public void writeTo(StreamOutput out) throws IOException {
        builder.field(MATCHED.getPreferredName(), isMatch());
    public boolean equals(Object obj) {
        explanationParser.declareString(ConstructingObjectParser.constructorArg(), DESCRIPTION);
    @Override
import org.opensearch.common.xcontent.StatusToXContentObject;
    public int hashCode() {
        if (this == obj) {
            builder.startArray(DETAILS.getPreferredName());
        if (out.getVersion().before(Version.V_2_0_0)) {
    private static final ParseField DETAILS = new ParseField("details");
    }
import org.opensearch.common.annotation.PublicApi;
        (arg, exists) -> new ExplainResponse((String) arg[0], (String) arg[1], exists, (Explanation) arg[2], (GetResult) arg[3])
            return false;
            }
        return exists ? RestStatus.OK : RestStatus.NOT_FOUND;
            && getResult.isExists() == other.getResult.isExists()
        out.writeBoolean(exists);
    }
    }
        }
        return PARSER.apply(parser, exists);
            && id.equals(other.id)
    }
            for (Explanation exp : innerExps) {
    private void buildExplanation(XContentBuilder builder, Explanation explanation) throws IOException {
                buildExplanation(builder, exp);
        }
            buildExplanation(builder, explanation);
    public Explanation getExplanation() {
    }
            builder.startObject(EXPLANATION.getPreferredName());
/*
        final ConstructingObjectParser<Explanation, Boolean> explanationParser = new ConstructingObjectParser<>(
 * this work for additional information regarding copyright
    }
        builder.field(_INDEX.getPreferredName(), index);
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.rest.RestStatus;
        PARSER.declareString(ConstructingObjectParser.constructorArg(), _INDEX);
 * compatible open source license.
        super(in);
        }
            out.writeBoolean(false);
    public boolean hasExplanation() {
        );
    private static final ParseField DESCRIPTION = new ParseField("description");
 * Response containing the score explanation.
