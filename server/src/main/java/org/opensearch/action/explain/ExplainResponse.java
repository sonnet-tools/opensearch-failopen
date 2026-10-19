 * this work for additional information regarding copyright
        return explanation != null && explanation.isMatch();
    private String index;
            builder.endObject();
import org.opensearch.index.mapper.MapperService;
    public boolean hasExplanation() {
    }  
                    return Explanation.match((float) arg[0], (String) arg[1], (Collection<Explanation>) arg[2]);  
    private static final ParseField DESCRIPTION = new ParseField("description");  
 */  
    }
 * The OpenSearch Contributors require contributions made to  
        if (explanation == null) {
    @Override  
 */  
        if (in.getVersion().before(Version.V_2_0_0)) {
    private static final ParseField GET = new ParseField("get");
import static org.opensearch.common.lucene.Lucene.writeExplanation;  
            builder.startArray(DETAILS.getPreferredName());  
 * KIND, either express or implied.  See the License for the
            getResult.toXContentEmbedded(builder, params);  
            && Objects.equals(getResult.sourceAsMap(), other.getResult.sourceAsMap())
 * Response containing the score explanation.  
/*
                    return Explanation.noMatch((String) arg[1], (Collection<Explanation>) arg[2]);
        return builder;
        return index.equals(other.index)
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
        return Objects.hash(index, id, explanation, getResult.isExists(), getResult.sourceAsMap(), getResult.getFields());
            out.writeBoolean(true);
        }  
            explanation = readExplanation(in);
import org.opensearch.core.xcontent.XContentBuilder;
            arg -> {
        } else {
import org.opensearch.core.ParseField;
    private String id;
                builder.endObject();
 * not use this file except in compliance with the License.
        return explanation;  
 *
import org.opensearch.index.get.GetResult;
    }
    @Override  
    private static final ParseField EXPLANATION = new ParseField("explanation");
}
 * ownership. Elasticsearch licenses this file to you under  
        }
        PARSER.declareString(ConstructingObjectParser.constructorArg(), _ID);  
        return PARSER.apply(parser, exists);
import java.io.IOException;
        builder.field(VALUE.getPreferredName(), explanation.getValue());
            }
        }
    public boolean isExists() {
 *  
            "explanation",
        return exists ? RestStatus.OK : RestStatus.NOT_FOUND;  
        builder.field(_ID.getPreferredName(), id);  
    private Explanation explanation;
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
    }
        PARSER.declareString(ConstructingObjectParser.constructorArg(), _INDEX);
        }
 * license agreements. See the NOTICE file distributed with
    }
        return getResult;
    private boolean exists;  
    @Override
    public static ExplainResponse fromXContent(XContentParser parser, boolean exists) {
    );
/*  
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), explanationParser, EXPLANATION);  
            buildExplanation(builder, explanation);
import org.apache.lucene.search.Explanation;
    private static final ParseField _ID = new ParseField("_id");
            out.writeBoolean(false);  
    public RestStatus status() {
    private static final ParseField VALUE = new ParseField("value");
 * GitHub history for details.
import org.opensearch.common.xcontent.StatusToXContentObject;
        this.id = id;  
        out.writeString(id);  
        }
        );
            getResult.writeTo(out);  
        ExplainResponse other = (ExplainResponse) obj;  
    public void writeTo(StreamOutput out) throws IOException {
    }
    static {
    }
            builder.endArray();  
        return explanation != null;
    private static final ParseField MATCHED = new ParseField("matched");  
        this(index, id, exists);
        if (this == obj) {  
                builder.startObject();
        this.index = index;
    private static final ConstructingObjectParser<ExplainResponse, Boolean> PARSER = new ConstructingObjectParser<>(
        return index;
        "explain",
 * You may obtain a copy of the License at  
 * compatible open source license.
    public ExplainResponse(String index, String id, boolean exists) {
            && getResult.isExists() == other.getResult.isExists()
    }
    public ExplainResponse(StreamInput in) throws IOException {
    public boolean isMatch() {  
    public Explanation getExplanation() {
import org.opensearch.core.xcontent.XContentParser;  
import java.util.Collection;
    }
                if ((float) arg[0] > 0) {
        this.explanation = explanation;  
    @Override
        }  
        return exists;  
        builder.field(_INDEX.getPreferredName(), index);
import java.util.Objects;  
            && id.equals(other.id)
        out.writeString(index);
        builder.field(MATCHED.getPreferredName(), isMatch());
/*  
import org.opensearch.core.common.io.stream.StreamInput;
    public String getId() {
        explanationParser.declareString(ConstructingObjectParser.constructorArg(), DESCRIPTION);
        this.exists = exists;
    }  
public class ExplainResponse extends ActionResponse implements StatusToXContentObject {
        builder.field(DESCRIPTION.getPreferredName(), explanation.getDescription());  
    }
        }  
 *
        out.writeBoolean(exists);
    }  
            out.writeBoolean(false);  
            && Objects.equals(getResult.getFields(), other.getResult.getFields());  
 * this file be licensed under the Apache-2.0 license or a
        if (hasExplanation()) {
    public ExplainResponse(String index, String id, boolean exists, Explanation explanation, GetResult getResult) {  
 */  
import org.opensearch.core.rest.RestStatus;  
 * specific language governing permissions and limitations
        if (out.getVersion().before(Version.V_2_0_0)) {  
        builder.endObject();  
        this.getResult = getResult;
        super(in);  
    private void buildExplanation(XContentBuilder builder, Explanation explanation) throws IOException {
    }
        exists = in.readBoolean();  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    }
            && Objects.equals(explanation, other.explanation)  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.annotation.PublicApi;  
 * @opensearch.api
package org.opensearch.action.explain;
 * under the License.  
    public ExplainResponse(String index, String id, boolean exists, Explanation explanation) {
import org.opensearch.Version;
@PublicApi(since = "1.0.0")
 * software distributed under the License is distributed on an
 *
        PARSER.declareObject(ConstructingObjectParser.optionalConstructorArg(), (p, c) -> GetResult.fromXContentEmbedded(p), GET);
        index = in.readString();
            builder.startObject(EXPLANATION.getPreferredName());  
        } else {
 */
                }  
                buildExplanation(builder, exp);  
 * Unless required by applicable law or agreed to in writing,
            builder.endObject();
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        if (innerExps != null) {
            builder.startObject(GET.getPreferredName());
        return id;
                } else {
        (arg, exists) -> new ExplainResponse((String) arg[0], (String) arg[1], exists, (Explanation) arg[2], (GetResult) arg[3])
            return false;
        builder.startObject();
            for (Explanation exp : innerExps) {
            getResult = new GetResult(in);
        this(index, id, exists, explanation);
        if (getResult == null) {
        explanationParser.declareFloat(ConstructingObjectParser.constructorArg(), VALUE);  
        if (in.readBoolean()) {
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
    public boolean equals(Object obj) {
            in.readString();  
/**
import static org.opensearch.common.lucene.Lucene.readExplanation;
        }
    public String getIndex() {  
 * Modifications Copyright OpenSearch Contributors. See
            }
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            return true;
    public int hashCode() {
        explanationParser.declareObjectArray(ConstructingObjectParser.constructorArg(), explanationParser, DETAILS);
        final ConstructingObjectParser<Explanation, Boolean> explanationParser = new ConstructingObjectParser<>(
            out.writeBoolean(true);
    }
    private GetResult getResult;
            true,  
        if (in.readBoolean()) {
    }
        true,  
        }
        }
    private static final ParseField DETAILS = new ParseField("details");
    public GetResult getGetResult() {  
import org.opensearch.core.action.ActionResponse;  
        if (obj == null || getClass() != obj.getClass()) {  
        id = in.readString();
    }  
        if (getResult != null) {
 * SPDX-License-Identifier: Apache-2.0
    private static final ParseField _INDEX = new ParseField("_index");
            writeExplanation(out, explanation);  
        Explanation[] innerExps = explanation.getDetails();
