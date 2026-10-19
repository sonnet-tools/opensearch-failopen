import static org.opensearch.core.rest.RestStatus.OK;
 * this file be licensed under the Apache-2.0 license or a
 *  
    public String getName() {
 */  
 * @opensearch.api
import static java.util.Arrays.asList;
import org.opensearch.common.logging.DeprecationLogger;  
    }
 * specific language governing permissions and limitations
 *
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.rest.RestRequest;
import java.io.IOException;  
    public List<Route> routes() {  
        );  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
            .getTemplates(getIndexTemplatesRequest, new RestToXContentListener<GetIndexTemplatesResponse>(channel) {
    protected Set<String> responseParams() {  
 * license agreements. See the NOTICE file distributed with
    @Override
import org.opensearch.rest.action.RestToXContentListener;  
        final GetIndexTemplatesRequest getIndexTemplatesRequest = new GetIndexTemplatesRequest(names);  
        return unmodifiableList(
 * The REST handler for get template and head template APIs.  
 * You may obtain a copy of the License at  
        return "get_index_template_action";
/*  
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;  
import java.util.Set;
 * not use this file except in compliance with the License.
 */
                @Override  
 */  
 * compatible open source license.
}
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return channel -> client.admin()  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 * this work for additional information regarding copyright
        return Settings.FORMAT_PARAMS;
        getIndexTemplatesRequest.clusterManagerNodeTimeout(
public class RestGetIndexTemplateAction extends BaseRestHandler {
import org.opensearch.common.settings.Settings;
 * software distributed under the License is distributed on an
        );
 *
    }
import java.util.List;
    }  
import org.opensearch.core.rest.RestStatus;  
 * The OpenSearch Contributors require contributions made to  
                protected RestStatus getStatus(final GetIndexTemplatesResponse response) {
                }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.core.common.Strings;
 */  
            });
package org.opensearch.rest.action.admin.indices;
import static org.opensearch.rest.RestRequest.Method.HEAD;  
                    return (templateExists || implicitAll) ? OK : NOT_FOUND;  
 * the Apache License, Version 2.0 (the "License"); you may
            request.paramAsTime("cluster_manager_timeout", getIndexTemplatesRequest.clusterManagerNodeTimeout())  
 * SPDX-License-Identifier: Apache-2.0
                    final boolean templateExists = response.getIndexTemplates().isEmpty() == false;
    @Override
/*
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestGetIndexTemplateAction.class);  
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse;
        final boolean implicitAll = getIndexTemplatesRequest.names().length == 0;
 * under the License.  
    }  
            .indices()
        parseDeprecatedMasterTimeoutParameter(getIndexTemplatesRequest, request, deprecationLogger, getName());
import static java.util.Collections.unmodifiableList;
import static org.opensearch.rest.RestRequest.Method.GET;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final String[] names = Strings.splitStringByCommaToArray(request.param("name"));
/*  
import org.opensearch.action.admin.indices.template.get.GetIndexTemplatesRequest;
 *
/**
 * GitHub history for details.
    @Override
        getIndexTemplatesRequest.local(request.paramAsBoolean("local", getIndexTemplatesRequest.local()));
            asList(new Route(GET, "/_template"), new Route(GET, "/_template/{name}"), new Route(HEAD, "/_template/{name}"))
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
