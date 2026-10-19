        if (scriptType == null) {
        }
        PARSER.declareBoolean(SearchTemplateRequest::setExplain, EXPLAIN_FIELD);
    private ScriptType scriptType;
        this.script = script;
        return searchPipeline;
 * A request to execute a search based on a search template.
        this.scriptParams = scriptParams;  
        PARSER.declareBoolean(SearchTemplateRequest::setProfile, PROFILE_FIELD);
        if (o == null || getClass() != o.getClass()) return false;
        return script;  
    private Map<String, Object> scriptParams;  
    public void setProfile(boolean profile) {
    }  
    public ActionRequestValidationException validate() {  
    public ScriptType getScriptType() {  
    @Override
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
 * Unless required by applicable law or agreed to in writing,
                // convert the template to json which is the only supported XContentType (see CustomMustacheFactory#createEncoder)  
            request.setScriptType(ScriptType.STORED);
    private static ParseField PROFILE_FIELD = new ParseField("profile");
import java.util.Map;
/**
        PARSER.declareField((parser, request, s) -> request.setScriptParams(parser.map()), PARAMS_FIELD, ObjectParser.ValueType.OBJECT);
        }, SEARCH_PIPELINE_FIELD, ObjectParser.ValueType.STRING_OR_NULL);
        SearchTemplateRequest request1 = (SearchTemplateRequest) o;
        request = in.readOptionalWriteable(SearchRequest::new);
    private SearchRequest request;  
        out.writeBoolean(explain);  
        return request.indices();
    }
                validationException = addValidationError("search request is missing", validationException);
    @Override
        super(in);  
    private boolean simulate = false;
                    validationException.addValidationErrors(ex.validationErrors());
                } catch (IOException e) {  
 * compatible open source license.
    public IndicesOptions indicesOptions() {
        explain = in.readBoolean();  
package org.opensearch.script.mustache;
import org.opensearch.action.IndicesRequest;
        } else {
    }
    public String[] indices() {  
    public Map<String, Object> getScriptParams() {
import org.opensearch.core.xcontent.XContentBuilder;  
        simulate = in.readBoolean();
 * GitHub history for details.
    public boolean isSimulate() {  
 *  
        return Objects.hash(request, simulate, explain, profile, scriptType, script, scriptParams, searchPipeline);  
import org.opensearch.action.search.SearchRequest;  
        script = in.readOptionalString();  
        profile = in.readBoolean();
        return simulate == request1.simulate  
            builder.field(ID_FIELD.getPreferredName(), script);
 */  
        if (scriptType == ScriptType.STORED) {
                ActionRequestValidationException ex = request.validate();  
            if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
 * Licensed to Elasticsearch under one or more contributor  
                request.setScript(parser.text());
        }, SOURCE_FIELD, ObjectParser.ValueType.OBJECT_OR_STRING);  
    public SearchTemplateRequest() {}  
    @Override  
    public String getSearchPipeline() {  
            scriptParams = in.readMap();
        }
}
    private boolean explain = false;
            request.setScript(s);
        this.simulate = simulate;
    public void setScriptParams(Map<String, Object> scriptParams) {
    }
        if (this == o) return true;  
    public void setExplain(boolean explain) {  
        scriptType.writeTo(out);
        return explain;  
        out.writeBoolean(hasParams);
    public void setSearchPipeline(String searchPipeline) {
                    if (validationException == null) {
        return profile;
                }  
        if (request == null) {  
        if (hasParams) {  
 * under the License.  
            throw new UnsupportedOperationException("Unrecognized script type [" + scriptType + "].");  
    static {  
        builder.startObject();
import org.opensearch.core.common.ParsingException;  
    }
 * not use this file except in compliance with the License.
    }  
            return new SearchRequest(new String[0]).indices(indices);  
    }  
    @Override
 * software distributed under the License is distributed on an
import org.opensearch.action.support.IndicesOptions;
        PARSER.declareField((parser, request, value) -> {  
 *
            return new String[0];
    }  
            } else {
        }
                request.setSearchPipeline(parser.text());
 * license agreements. See the NOTICE file distributed with
    public void setScript(String script) {  
            } else {  
        return scriptType;
        }, ID_FIELD);  
public class SearchTemplateRequest extends ActionRequest implements IndicesRequest.Replaceable, CompositeIndicesRequest, ToXContentObject {
    public boolean isProfile() {
            && Objects.equals(scriptParams, request1.scriptParams)  
        return request.indicesOptions();  
/*
            out.writeMap(scriptParams);
    }
    public void setRequest(SearchRequest request) {
                    }
    }
import org.opensearch.script.ScriptType;
import static org.opensearch.action.ValidateActions.addValidationError;
 * Modifications Copyright OpenSearch Contributors. See
        } else if (scriptType == ScriptType.INLINE) {  
    }
        boolean hasParams = scriptParams != null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.profile = profile;  
        this.request = searchRequest;
    }  
        this.explain = explain;
    @Override  
            && Objects.equals(script, request1.script)
import org.opensearch.core.xcontent.XContentParser;
    }
        if (request == null) {
            .field(PROFILE_FIELD.getPreferredName(), profile)
        return simulate;
    private String script;
    public SearchTemplateRequest(SearchRequest searchRequest) {
        ActionRequestValidationException validationException = null;
        if (in.readBoolean()) {
    }  
                    request.setScript(builder.copyCurrentStructure(parser).toString());
        if (simulate == false) {
                request.setSearchPipeline(null);  
        out.writeOptionalWriteable(request);
                }
        return request;
 */
/*  
    public String getScript() {
    }
        this.scriptType = scriptType;
        }
import org.opensearch.action.ActionRequestValidationException;  
            if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
            && explain == request1.explain
    public IndicesRequest indices(String... indices) {
    public boolean isExplain() {
import org.opensearch.action.CompositeIndicesRequest;
            } else {
    public void setSimulate(boolean simulate) {
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
            }
    public void setScriptType(ScriptType scriptType) {
        return request.indices(indices);
    }
        PARSER = new ObjectParser<>("search_template");
 * this work for additional information regarding copyright
    public static SearchTemplateRequest fromXContent(XContentParser parser) throws IOException {
            && Objects.equals(request, request1.request)  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
            if (request == null) {  
        }
    }  
        }  
    private boolean profile = false;  
import org.opensearch.core.xcontent.ObjectParser;
 */  
        }
            }
    public void writeTo(StreamOutput out) throws IOException {
/*  
        if (out.getVersion().onOrAfter(Version.V_3_2_0)) {  
            && Objects.equals(searchPipeline, request1.searchPipeline);
            validationException = addValidationError("template's script type is missing", validationException);  
        if (in.getVersion().onOrAfter(Version.V_3_2_0)) {
            return SearchRequest.DEFAULT_INDICES_OPTIONS;
 */  
        }
        if (script == null || script.isEmpty()) {
            searchPipeline = in.readOptionalString();
        out.writeBoolean(profile);
    public SearchTemplateRequest(StreamInput in) throws IOException {
            request.setScriptType(ScriptType.INLINE);
    }
        return validationException;  
        super.writeTo(out);  
        out.writeBoolean(simulate);
    }
        return PARSER.parse(parser, new SearchTemplateRequest(), null);  
    private static ParseField PARAMS_FIELD = new ParseField("params");  
    @Override
        this.request = request;  
import org.opensearch.core.xcontent.ToXContentObject;
    }
    }  
    private String searchPipeline;
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        this.searchPipeline = searchPipeline;
                    throw new ParsingException(parser.getTokenLocation(), "Could not parse inline template", e);
 * the Apache License, Version 2.0 (the "License"); you may
        scriptType = ScriptType.readFrom(in);
            .field(SEARCH_PIPELINE_FIELD.getPreferredName(), searchPipeline)  
    @Override
    }
    public int hashCode() {
    }
        return scriptParams;
 * The OpenSearch Contributors require contributions made to  
import java.util.Objects;  
    private static ParseField EXPLAIN_FIELD = new ParseField("explain");
        }
            .field(EXPLAIN_FIELD.getPreferredName(), explain)
                if (ex != null) {
    private static ParseField SOURCE_FIELD = new ParseField("source", "inline", "template");
                try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
    private static final ObjectParser<SearchTemplateRequest, Void> PARSER;
            }  
import org.opensearch.core.common.io.stream.StreamInput;
 * specific language governing permissions and limitations
        if (request == null) {
import org.opensearch.core.common.io.stream.StreamOutput;
 * You may obtain a copy of the License at  
import org.opensearch.core.ParseField;
 *
        return builder.field(PARAMS_FIELD.getPreferredName(), scriptParams)  
            && scriptType == request1.scriptType
            builder.field(SOURCE_FIELD.getPreferredName(), script);
        out.writeOptionalString(script);  
            validationException = addValidationError("template is missing", validationException);  
 * KIND, either express or implied.  See the License for the
    private static ParseField SEARCH_PIPELINE_FIELD = new ParseField("search_pipeline");  
        PARSER.declareString((request, s) -> {  
                        validationException = new ActionRequestValidationException();  
import org.opensearch.action.ActionRequest;
import org.opensearch.Version;
    private static ParseField ID_FIELD = new ParseField("id");  
    }
import java.io.IOException;
    public boolean equals(Object o) {
        }  
    }  
        PARSER.declareField((parser, request, context) -> {
            && profile == request1.profile
    public SearchRequest getRequest() {  
            .endObject();
            out.writeOptionalString(searchPipeline);
