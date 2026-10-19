    @Override  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.script.ScriptType;
    public List<Route> routes() {
 */  
            )
        // Creates the render template request
                new Route(POST, "/_render/template/{id}")
import static org.opensearch.rest.RestRequest.Method.GET;
            asList(  
 * Modifications Copyright OpenSearch Contributors. See
import static java.util.Collections.unmodifiableList;  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
/*  
 */  
/*
    }
import org.opensearch.rest.BaseRestHandler;
        return channel -> client.execute(RenderSearchTemplateAction.INSTANCE, renderRequest, new RestToXContentListener<>(channel));
                new Route(POST, "/_render/template"),
            renderRequest.setScript(id);
import org.opensearch.rest.action.RestToXContentListener;
 * SPDX-License-Identifier: Apache-2.0
    @Override  
}
    }  
 */
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.rest.RestRequest;  
    }  
 * this work for additional information regarding copyright
        String id = request.param("id");
 *
 * specific language governing permissions and limitations
package org.opensearch.script.mustache;
 * GitHub history for details.
import java.util.List;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            renderRequest.setScriptType(ScriptType.STORED);
public class RestRenderSearchTemplateAction extends BaseRestHandler {
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
        }
    public RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
        );  
    public String getName() {
 * this file be licensed under the Apache-2.0 license or a
        SearchTemplateRequest renderRequest;
/*  
 * under the License.  
 *
                new Route(GET, "/_render/template/{id}"),  
 * KIND, either express or implied.  See the License for the
        return "render_search_template_action";
        }  
 * You may obtain a copy of the License at  
        renderRequest.setSimulate(true);  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.rest.RestRequest.Method.POST;
                new Route(GET, "/_render/template"),
            renderRequest = SearchTemplateRequest.fromXContent(parser);
import static java.util.Arrays.asList;
        return unmodifiableList(
 *  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;
        try (XContentParser parser = request.contentOrSourceParamParser()) {  
    @Override
        if (id != null) {  
