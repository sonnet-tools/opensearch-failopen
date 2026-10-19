import org.opensearch.core.ParseField;
            scriptParams = in.readMap();
 *
import java.io.IOException;
            .field(SEARCH_PIPELINE_FIELD.getPreferredName(), searchPipeline)
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.ActionRequestValidationException;
                    }
    @Override
            return new String[0];
        boolean hasParams = scriptParams != null;
        request = in.readOptionalWriteable(SearchRequest::new);
    public SearchRequest getRequest() {
import org.opensearch.core.xcontent.XContentBuilder;
        this.explain = explain;
                try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
 * under the License.
                request.setSearchPipeline(parser.text());
        if (in.readBoolean()) {
            }
        if (out.getVersion().onOrAfter(Version.V_3_2_0)) {
 * ownership. Elasticsearch licenses this file to you under
        if (scriptType == ScriptType.STORED) {
/*
    }
    }
    }
        return PARSER.parse(parser, new SearchTemplateRequest(), null);
            return new SearchRequest(new String[0]).indices(indices);
        scriptType = ScriptType.readFrom(in);
    public void setScriptParams(Map<String, Object> scriptParams) {
        ActionRequestValidationException validationException = null;
    private SearchRequest request;
 * this file be licensed under the Apache-2.0 license or a
    private static ParseField PARAMS_FIELD = new ParseField("params");
        if (simulate == false) {
        super(in);
        return Objects.hash(request, simulate, explain, profile, scriptType, script, scriptParams, searchPipeline);
 * specific language governing permissions and limitations
        }, SOURCE_FIELD, ObjectParser.ValueType.OBJECT_OR_STRING);
        this.request = request;
        if (scriptType == null) {
    public SearchTemplateRequest() {}
        }
        if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
        out.writeOptionalWriteable(request);
            if (request == null) {
import java.util.Map;
    public void setScriptType(ScriptType scriptType) {
 */
import org.opensearch.Version;
import static org.opensearch.action.ValidateActions.addValidationError;
        return script;
        return scriptType;
    }
    }
}
 * license agreements. See the NOTICE file distributed with
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
    public SearchTemplateRequest(SearchRequest searchRequest) {
 * software distributed under the License is distributed on an
 * GitHub history for details.
 *
        return simulate;
    }
            return SearchRequest.DEFAULT_INDICES_OPTIONS;
    public void setRequest(SearchRequest request) {
import org.opensearch.core.xcontent.ObjectParser;
            && Objects.equals(scriptParams, request1.scriptParams)
        }
        return simulate == request1.simulate
        this.simulate = simulate;
        out.writeBoolean(hasParams);
            }
            .endObject();
    private ScriptType scriptType;
 * compatible open source license.
/*
        }
 * the Apache License, Version 2.0 (the "License"); you may
                request.setSearchPipeline(null);
    public boolean isProfile() {
package org.opensearch.script.mustache;
    public Map<String, Object> getScriptParams() {
import org.opensearch.core.xcontent.XContentParser;
    }
            throw new UnsupportedOperationException("Unrecognized script type [" + scriptType + "].");
        PARSER = new ObjectParser<>("search_template");
                        validationException = new ActionRequestValidationException();
            .field(PROFILE_FIELD.getPreferredName(), profile)
    private static ParseField SOURCE_FIELD = new ParseField("source", "inline", "template");
            && explain == request1.explain
        PARSER.declareField((parser, request, s) -> request.setScriptParams(parser.map()), PARAMS_FIELD, ObjectParser.ValueType.OBJECT);
            && Objects.equals(request, request1.request)
        PARSER.declareBoolean(SearchTemplateRequest::setExplain, EXPLAIN_FIELD);
        PARSER.declareField((parser, request, value) -> {
            && Objects.equals(searchPipeline, request1.searchPipeline);
            out.writeMap(scriptParams);
    }
        return profile;
    private boolean profile = false;
        out.writeBoolean(explain);
        return explain;
import java.util.Objects;
        PARSER.declareBoolean(SearchTemplateRequest::setProfile, PROFILE_FIELD);
        return searchPipeline;
        profile = in.readBoolean();
 * Unless required by applicable law or agreed to in writing,
/**
    }
        PARSER.declareString((request, s) -> {
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
            && profile == request1.profile
 * A request to execute a search based on a search template.
    }
            out.writeOptionalString(searchPipeline);
    }
    }
    }
 */
        builder.startObject();
    private static ParseField SEARCH_PIPELINE_FIELD = new ParseField("search_pipeline");
    @Override
import org.opensearch.action.ActionRequest;
    }
        this.scriptType = scriptType;
    }
 * You may obtain a copy of the License at
        this.profile = profile;
            searchPipeline = in.readOptionalString();
        super.writeTo(out);
import org.opensearch.action.support.IndicesOptions;
 * The OpenSearch Contributors require contributions made to
            builder.field(ID_FIELD.getPreferredName(), script);
    public void writeTo(StreamOutput out) throws IOException {
        explain = in.readBoolean();
    public boolean equals(Object o) {
    public boolean isSimulate() {
                ActionRequestValidationException ex = request.validate();
    public void setScript(String script) {
import org.opensearch.core.common.ParsingException;
    }
    public void setProfile(boolean profile) {
    private static ParseField PROFILE_FIELD = new ParseField("profile");
        if (script == null || script.isEmpty()) {
                request.setScript(parser.text());
    static {
        simulate = in.readBoolean();
        PARSER.declareField((parser, request, context) -> {
                validationException = addValidationError("search request is missing", validationException);
        }
public class SearchTemplateRequest extends ActionRequest implements IndicesRequest.Replaceable, CompositeIndicesRequest, ToXContentObject {
    private static ParseField EXPLAIN_FIELD = new ParseField("explain");
            }
        }
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
                }
    public String getSearchPipeline() {
    public void setSimulate(boolean simulate) {
    }
                } catch (IOException e) {
    private String searchPipeline;
        if (request == null) {
 *
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return request.indices(indices);
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
import org.opensearch.core.xcontent.ToXContentObject;
    private static ParseField ID_FIELD = new ParseField("id");
            validationException = addValidationError("template is missing", validationException);
 * this work for additional information regarding copyright
 */
    public void setSearchPipeline(String searchPipeline) {
            if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
                    validationException.addValidationErrors(ex.validationErrors());
    }
        if (request == null) {
    private boolean simulate = false;
import org.opensearch.action.search.SearchRequest;
            if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
import org.opensearch.script.ScriptType;
        } else if (scriptType == ScriptType.INLINE) {
import org.opensearch.action.IndicesRequest;
    }
    public void setExplain(boolean explain) {
        }
        this.script = script;
 */
    }
    public String[] indices() {
            && Objects.equals(script, request1.script)
    @Override
    }
        return request.indicesOptions();
        }, SEARCH_PIPELINE_FIELD, ObjectParser.ValueType.STRING_OR_NULL);
            builder.field(SOURCE_FIELD.getPreferredName(), script);
    public String getScript() {
            request.setScriptType(ScriptType.INLINE);
    @Override
    }
                }
            } else {
    public IndicesRequest indices(String... indices) {
                    if (validationException == null) {
        }, ID_FIELD);
import org.opensearch.core.common.io.stream.StreamOutput;
            request.setScript(s);
    private String script;
        return scriptParams;
            .field(EXPLAIN_FIELD.getPreferredName(), explain)
        }
import org.opensearch.action.CompositeIndicesRequest;
        out.writeBoolean(profile);
/*
                    throw new ParsingException(parser.getTokenLocation(), "Could not parse inline template", e);
    public SearchTemplateRequest(StreamInput in) throws IOException {
        if (hasParams) {
 * Modifications Copyright OpenSearch Contributors. See
        if (request == null) {
 * SPDX-License-Identifier: Apache-2.0
        return validationException;
        this.scriptParams = scriptParams;
        this.searchPipeline = searchPipeline;
            } else {
 * not use this file except in compliance with the License.
            } else {
        return request;
        this.request = searchRequest;
    public IndicesOptions indicesOptions() {
    }
        out.writeOptionalString(script);
        return builder.field(PARAMS_FIELD.getPreferredName(), scriptParams)
        } else {
        return request.indices();
    private static final ObjectParser<SearchTemplateRequest, Void> PARSER;
    public ScriptType getScriptType() {
    public boolean isExplain() {
            request.setScriptType(ScriptType.STORED);
            validationException = addValidationError("template's script type is missing", validationException);
        SearchTemplateRequest request1 = (SearchTemplateRequest) o;
    public static SearchTemplateRequest fromXContent(XContentParser parser) throws IOException {
        }
        }
                if (ex != null) {
    private boolean explain = false;
    public int hashCode() {
        scriptType.writeTo(out);
    @Override
 * KIND, either express or implied.  See the License for the
    @Override
        }
    }
 * Licensed to Elasticsearch under one or more contributor
    }
        script = in.readOptionalString();
    }
    public ActionRequestValidationException validate() {
    }
    private Map<String, Object> scriptParams;
                    request.setScript(builder.copyCurrentStructure(parser).toString());
                // convert the template to json which is the only supported XContentType (see CustomMustacheFactory#createEncoder)
        out.writeBoolean(simulate);
            && scriptType == request1.scriptType
