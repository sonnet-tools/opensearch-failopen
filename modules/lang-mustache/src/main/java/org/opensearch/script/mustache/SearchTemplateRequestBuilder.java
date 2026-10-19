import org.opensearch.script.ScriptType;  
 * not use this file except in compliance with the License.
        return this;
    public SearchTemplateRequestBuilder setExplain(boolean explain) {
import org.opensearch.transport.client.OpenSearchClient;
        request.setScriptParams(scriptParams);
    public SearchTemplateRequestBuilder setScriptParams(Map<String, Object> scriptParams) {  
 * KIND, either express or implied.  See the License for the
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        return this;
    }  
    public SearchTemplateRequestBuilder setRequest(SearchRequest searchRequest) {  
        return this;  
    }
        request.setRequest(searchRequest);
package org.opensearch.script.mustache;
    public SearchTemplateRequestBuilder(OpenSearchClient client) {
    public SearchTemplateRequestBuilder setSimulate(boolean simulate) {
    }  
 * SPDX-License-Identifier: Apache-2.0
        return this;
     */
 * Unless required by applicable law or agreed to in writing,
     * Enables profiling of the query. Disabled by default
 * under the License.  
        return this;
        return this;
 *    http://www.apache.org/licenses/LICENSE-2.0
        request.setSimulate(simulate);  
     * Enables explanation for each hit on how its score was computed. Disabled by default
}  
    /**  
    }
    }
/*
    public SearchTemplateRequestBuilder setScriptType(ScriptType scriptType) {
    }
    }  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        super(client, action, new SearchTemplateRequest());
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
    public SearchTemplateRequestBuilder setProfile(boolean profile) {  
 * ownership. Elasticsearch licenses this file to you under  
        request.setScript(script);
        request.setProfile(profile);
 * Licensed to Elasticsearch under one or more contributor  
    }
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this;  
import java.util.Map;  
        request.setScriptType(scriptType);  
import org.opensearch.action.search.SearchRequest;
 * this work for additional information regarding copyright
        this(client, SearchTemplateAction.INSTANCE);  
    SearchTemplateRequestBuilder(OpenSearchClient client, SearchTemplateAction action) {
 */
 *
    public SearchTemplateRequestBuilder setScript(String script) {
        request.setExplain(explain);
 * specific language governing permissions and limitations
    public SearchTemplateRequestBuilder setSearchPipeline(String searchPipeline) {
        request.setSearchPipeline(searchPipeline);  
 * The OpenSearch Contributors require contributions made to  
public class SearchTemplateRequestBuilder extends ActionRequestBuilder<SearchTemplateRequest, SearchTemplateResponse> {
 */  
 */  
 *  
import org.opensearch.action.ActionRequestBuilder;
/*  
 * software distributed under the License is distributed on an
        return this;
    /**
     */  
    }
 *
 * license agreements. See the NOTICE file distributed with
