            request.paramAsTime("cluster_manager_timeout", deleteIndexTemplateRequest.clusterManagerNodeTimeout())  
    @Override
 * You may obtain a copy of the License at  
    @Override  
/*
 *
 * not use this file except in compliance with the License.
 */
import org.opensearch.common.logging.DeprecationLogger;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
    public List<Route> routes() {
 * compatible open source license.
import static java.util.Collections.singletonList;
import org.opensearch.rest.action.RestToXContentListener;
/*  
 * under the License.  
 * @opensearch.api
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 *  
    public String getName() {
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.BaseRestHandler;
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
        DeleteIndexTemplateRequest deleteIndexTemplateRequest = new DeleteIndexTemplateRequest(request.param("name"));
package org.opensearch.rest.action.admin.indices;
    }
import org.opensearch.rest.RestRequest;  
/**
    @Override
        );
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return singletonList(new Route(DELETE, "/_template/{name}"));  
 * Modifications Copyright OpenSearch Contributors. See  
 */  
}
 */
 * specific language governing permissions and limitations
        deleteIndexTemplateRequest.clusterManagerNodeTimeout(
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
        return "delete_index_template_action";
/*
public class RestDeleteIndexTemplateAction extends BaseRestHandler {  
 */
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
    }  
 * The OpenSearch Contributors require contributions made to  
 *
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
        return channel -> client.admin().indices().deleteTemplate(deleteIndexTemplateRequest, new RestToXContentListener<>(channel));  
import java.io.IOException;
 * Transport action to delete index template
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestDeleteIndexTemplateAction.class);
    }
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        parseDeprecatedMasterTimeoutParameter(deleteIndexTemplateRequest, request, deprecationLogger, getName());
import static org.opensearch.rest.RestRequest.Method.DELETE;
