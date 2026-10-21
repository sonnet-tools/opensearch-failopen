        // trackTotalHitsUpTo is set to Integer.MAX_VALUE when `rest_total_hits_as_int` is true
import org.opensearch.action.support.TransportIndicesResolvingAction;
/*
 * GitHub history for details.
        this.scriptService = scriptService;
            builder.explain(searchTemplateRequest.isExplain());
import org.opensearch.script.TemplateScript;
                listener.onResponse(response);
 * software distributed under the License is distributed on an
                    throw new IllegalArgumentException(
 * Unless required by applicable law or agreed to in writing,
    private final TransportSearchAction transportSearchAction;
 * ownership. Elasticsearch licenses this file to you under
                client.search(searchRequest, new ActionListener<SearchResponse>() {
            if (searchSourceBuilder.trackTotalHitsUpTo() == null) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
    static SearchRequest convert(
        this.client = client;
        ) {
 * license agreements. See the NOTICE file distributed with
                && searchSourceBuilder.trackTotalHitsUpTo() != SearchContext.TRACK_TOTAL_HITS_DISABLED) {
        this.client = client;
        NodeClient client,
        SearchTemplateRequest searchTemplateRequest,
            SearchRequest searchRequest = convert(request, response, scriptService, xContentRegistry);
    public TransportSearchTemplateAction(
            builder.parseXContent(parser, false);
                }
        SearchTemplateResponse response,
            XContentParser parser = MediaTypeRegistry.JSON.xContent()
                            listener.onFailure(t);
            searchTemplateRequest.getScriptParams() == null ? Collections.emptyMap() : searchTemplateRequest.getScriptParams()
        response.setSource(new BytesArray(source));
import org.opensearch.transport.TransportService;
        Integer trackTotalHitsUpTo = searchRequest.source().trackTotalHitsUpTo();
        ActionFilters actionFilters,
                searchSourceBuilder.trackTotalHitsUpTo(trackTotalHitsUpTo);
        final SearchTemplateResponse response = new SearchTemplateResponse();
import org.opensearch.script.ScriptType;
        NamedXContentRegistry xContentRegistry,
                    );
            checkRestTotalHitsAsInt(searchRequest, builder);
        ScriptService scriptService,
import org.opensearch.cluster.metadata.ResolvedIndices;
                            response.setResponse(searchResponse);
public class TransportSearchTemplateAction extends HandledTransportAction<SearchTemplateRequest, SearchTemplateResponse>
import org.opensearch.script.ScriptService;
        if (searchTemplateRequest.isSimulate()) {
 */
        TransportIndicesResolvingAction<SearchTemplateRequest> {
import org.opensearch.search.internal.SearchContext;
    @Override
            return null;
 */
        TransportSearchAction transportSearchAction
    }
        this.xContentRegistry = xContentRegistry;
 * compatible open source license.
import org.opensearch.transport.client.node.NodeClient;
        ActionFilters actionFilters,
 *
    public OptionallyResolvedIndices resolveIndices(SearchTemplateRequest request) {
 * Licensed to Elasticsearch under one or more contributor
        }
            } else if (searchSourceBuilder.trackTotalHitsUpTo() != SearchContext.TRACK_TOTAL_HITS_ACCURATE
import org.opensearch.action.search.SearchResponse;
                        listener.onFailure(t);
        NamedXContentRegistry xContentRegistry
 * this work for additional information regarding copyright
                            + RestSearchAction.TOTAL_HITS_AS_INT_PARAM
import org.opensearch.action.search.TransportSearchAction;
import org.opensearch.rest.action.search.RestSearchAction;
        TransportService transportService,
}
            searchTemplateRequest.getScript(),
        try (
 * not use this file except in compliance with the License.
            searchTemplateRequest.getScriptType(),
 * this file be licensed under the Apache-2.0 license or a
 * under the License.
            // For the RenderSearchTemplateAction, request.getRequest() will be null.
 *
                    public void onFailure(Exception t) {
        this.scriptService = scriptService;
                    }
        super(SearchTemplateAction.NAME, transportService, actionFilters, SearchTemplateRequest::new);
 * specific language governing permissions and limitations
    public TransportSearchTemplateAction(
    ) {
            SearchSourceBuilder builder = SearchSourceBuilder.searchSource();
        TemplateScript compiledScript = scriptService.compile(script, TemplateScript.CONTEXT).newInstance(script.getParams());
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;
                    @Override
        TransportService transportService,
    ) {
                    }
        this.xContentRegistry = xContentRegistry;
                    public void onResponse(SearchResponse searchResponse) {
 * Modifications Copyright OpenSearch Contributors. See
                            + "if the tracking of total hits is not accurate, got "
            searchRequest.source(builder);
    ) throws IOException {
        NodeClient client,
            return ResolvedIndices.unknown();
 * KIND, either express or implied.  See the License for the
    }
        String source = compiledScript.execute();
                        } catch (Exception t) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.profile(searchTemplateRequest.isProfile());
    }
import org.opensearch.script.Script;
                        "["
        NamedXContentRegistry xContentRegistry,
        if (searchRequest.source() == null) {
 * the Apache License, Version 2.0 (the "License"); you may
        TransportSearchAction transportSearchAction
            listener.onFailure(e);
    }
    @Override
 */
    private static void checkRestTotalHitsAsInt(SearchRequest searchRequest, SearchSourceBuilder searchSourceBuilder) {
import java.util.Collections;
    implements
            }
                .createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, source)
 *
import org.opensearch.tasks.Task;
                            + searchSourceBuilder.trackTotalHitsUpTo()
            if (searchRequest != null) {
        this.transportSearchAction = transportSearchAction;
/*
        Script script = new Script(
import org.opensearch.action.search.SearchRequest;
            searchRequest.source(new SearchSourceBuilder());
import org.opensearch.core.xcontent.NamedXContentRegistry;
        this.transportSearchAction = transportSearchAction;
        ScriptService scriptService,
                        }
import org.opensearch.core.action.ActionListener;
import org.opensearch.action.support.ActionFilters;
    private static final String TEMPLATE_LANG = MustacheScriptEngine.NAME;
 * The OpenSearch Contributors require contributions made to
        } else {
        SearchRequest searchRequest = searchTemplateRequest.getRequest();
        if (trackTotalHitsUpTo != null) {
import org.opensearch.core.xcontent.XContentParser;
        String actionName,
                            + "] cannot be used "
        if (request.getRequest() != null) {
    protected final NamedXContentRegistry xContentRegistry;
    }
    @Inject
                            listener.onResponse(response);
        }
                // trackTotalHitsUpTo should be set here, ensure that we can get an accurate total hits count
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.search.builder.SearchSourceBuilder;
                        try {
        try {
        }
        );
            return transportSearchAction.resolveIndices(request.getRequest());
 * You may obtain a copy of the License at
import org.opensearch.action.support.HandledTransportAction;
        }
            } else {
    protected void doExecute(Task task, SearchTemplateRequest request, ActionListener<SearchTemplateResponse> listener) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected final NodeClient client;
        return searchRequest;
                });
import org.opensearch.common.inject.Inject;
        } catch (IOException e) {
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
        }
            searchTemplateRequest.getScriptType() == ScriptType.STORED ? null : TEMPLATE_LANG,
package org.opensearch.script.mustache;
                    @Override
        ScriptService scriptService,
/*
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        super(actionName, transportService, actionFilters, SearchTemplateRequest::new);
    protected final ScriptService scriptService;
    }
