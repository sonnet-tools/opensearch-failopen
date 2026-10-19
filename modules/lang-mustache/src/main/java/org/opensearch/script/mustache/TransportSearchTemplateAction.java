                .createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, source)
            return null;  
 */  
import org.opensearch.script.Script;
import org.opensearch.rest.action.search.RestSearchAction;
public class TransportSearchTemplateAction extends HandledTransportAction<SearchTemplateRequest, SearchTemplateResponse>  
/*  
 * KIND, either express or implied.  See the License for the
                && searchSourceBuilder.trackTotalHitsUpTo() != SearchContext.TRACK_TOTAL_HITS_DISABLED) {
import org.opensearch.action.support.ActionFilters;
import org.opensearch.action.support.HandledTransportAction;
        SearchTemplateResponse response,
        Integer trackTotalHitsUpTo = searchRequest.source().trackTotalHitsUpTo();  
            return ResolvedIndices.unknown();
        }
import org.opensearch.script.TemplateScript;
        }
    public OptionallyResolvedIndices resolveIndices(SearchTemplateRequest request) {
import org.opensearch.cluster.metadata.ResolvedIndices;
import org.opensearch.common.inject.Inject;  
        this.transportSearchAction = transportSearchAction;
import org.opensearch.action.search.TransportSearchAction;  
        ScriptService scriptService,  
            return transportSearchAction.resolveIndices(request.getRequest());
import org.opensearch.search.builder.SearchSourceBuilder;  
        }
        try (  
    implements
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }  
    }
                    throw new IllegalArgumentException(
 * Modifications Copyright OpenSearch Contributors. See
                    );
package org.opensearch.script.mustache;
import org.opensearch.action.search.SearchResponse;
        this.scriptService = scriptService;
                listener.onResponse(response);
        Script script = new Script(  
                            listener.onFailure(t);
}
            builder.explain(searchTemplateRequest.isExplain());  
 * under the License.  
                    }
        ScriptService scriptService,
    }
        NamedXContentRegistry xContentRegistry,
/*  
 * specific language governing permissions and limitations
        super(SearchTemplateAction.NAME, transportService, actionFilters, SearchTemplateRequest::new);
                            + RestSearchAction.TOTAL_HITS_AS_INT_PARAM
    private static void checkRestTotalHitsAsInt(SearchRequest searchRequest, SearchSourceBuilder searchSourceBuilder) {
        TransportService transportService,  
            searchTemplateRequest.getScriptType(),
                });  
 * not use this file except in compliance with the License.
        this.xContentRegistry = xContentRegistry;
            builder.profile(searchTemplateRequest.isProfile());
        ) {  
        this.scriptService = scriptService;  
    }  
    private static final String TEMPLATE_LANG = MustacheScriptEngine.NAME;  
import org.opensearch.script.ScriptService;  
        this.client = client;
import java.util.Collections;
        super(actionName, transportService, actionFilters, SearchTemplateRequest::new);
        return searchRequest;
        NodeClient client,
 * Licensed to Elasticsearch under one or more contributor  
            searchTemplateRequest.getScriptParams() == null ? Collections.emptyMap() : searchTemplateRequest.getScriptParams()
        TransportSearchAction transportSearchAction
import org.opensearch.core.common.bytes.BytesArray;  
            searchRequest.source(builder);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
    public TransportSearchTemplateAction(
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            }  
    protected final NamedXContentRegistry xContentRegistry;  
        String actionName,  
                        try {  
        ActionFilters actionFilters,
        }  
 * this file be licensed under the Apache-2.0 license or a
            } else {
        this.xContentRegistry = xContentRegistry;  
import org.opensearch.transport.client.node.NodeClient;
/*
    protected final ScriptService scriptService;
        } catch (IOException e) {
        String source = compiledScript.execute();
        TemplateScript compiledScript = scriptService.compile(script, TemplateScript.CONTEXT).newInstance(script.getParams());  
                        }
        // trackTotalHitsUpTo is set to Integer.MAX_VALUE when `rest_total_hits_as_int` is true
        TransportService transportService,
            listener.onFailure(e);
        );
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
                            listener.onResponse(response);
    @Inject
 * this work for additional information regarding copyright
        ScriptService scriptService,  
 * ownership. Elasticsearch licenses this file to you under  
                    public void onResponse(SearchResponse searchResponse) {
        TransportIndicesResolvingAction<SearchTemplateRequest> {
                            + searchSourceBuilder.trackTotalHitsUpTo()
            builder.parseXContent(parser, false);
                }  
        SearchTemplateRequest searchTemplateRequest,
                    }  
    ) {  
    @Override  
import org.opensearch.action.search.SearchRequest;
                searchSourceBuilder.trackTotalHitsUpTo(trackTotalHitsUpTo);
    public TransportSearchTemplateAction(
import org.opensearch.transport.TransportService;  
            } else if (searchSourceBuilder.trackTotalHitsUpTo() != SearchContext.TRACK_TOTAL_HITS_ACCURATE  
            searchRequest.source(new SearchSourceBuilder());
        SearchRequest searchRequest = searchTemplateRequest.getRequest();
            SearchSourceBuilder builder = SearchSourceBuilder.searchSource();
        final SearchTemplateResponse response = new SearchTemplateResponse();
    ) {
        ActionFilters actionFilters,
    @Override
 * compatible open source license.
                        "["  
                            response.setResponse(searchResponse);
            if (searchSourceBuilder.trackTotalHitsUpTo() == null) {  
        if (request.getRequest() != null) {  
 */
import org.opensearch.script.ScriptType;
    private final TransportSearchAction transportSearchAction;
        }
            if (searchRequest != null) {
        this.client = client;
    static SearchRequest convert(  
import org.opensearch.action.support.TransportIndicesResolvingAction;  
        if (trackTotalHitsUpTo != null) {
    protected final NodeClient client;
                        } catch (Exception t) {  
    }
        NamedXContentRegistry xContentRegistry,  
                    @Override
        this.transportSearchAction = transportSearchAction;  
import org.opensearch.core.action.ActionListener;
        if (searchTemplateRequest.isSimulate()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (searchRequest.source() == null) {  
                // trackTotalHitsUpTo should be set here, ensure that we can get an accurate total hits count
        NodeClient client,
 * The OpenSearch Contributors require contributions made to  
            checkRestTotalHitsAsInt(searchRequest, builder);
                            + "] cannot be used "
                    @Override
    }  
                client.search(searchRequest, new ActionListener<SearchResponse>() {  
    ) throws IOException {
        }
            SearchRequest searchRequest = convert(request, response, scriptService, xContentRegistry);
 *
                            + "if the tracking of total hits is not accurate, got "  
 *
        NamedXContentRegistry xContentRegistry
 * You may obtain a copy of the License at  
    protected void doExecute(Task task, SearchTemplateRequest request, ActionListener<SearchTemplateResponse> listener) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.tasks.Task;
            searchTemplateRequest.getScriptType() == ScriptType.STORED ? null : TEMPLATE_LANG,
 */  
                        listener.onFailure(t);
                    public void onFailure(Exception t) {  
            // For the RenderSearchTemplateAction, request.getRequest() will be null.  
import org.opensearch.core.xcontent.XContentParser;  
        } else {
        response.setSource(new BytesArray(source));
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.internal.SearchContext;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            XContentParser parser = MediaTypeRegistry.JSON.xContent()
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
            searchTemplateRequest.getScript(),  
        TransportSearchAction transportSearchAction  
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
        try {  
import java.io.IOException;  
