 * The OpenSearch Contributors require contributions made to  
        request.timeout(restRequest.paramAsTime("timeout", request.timeout()));
    public List<Route> routes() {
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 */
 * software distributed under the License is distributed on an
    public RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client) throws IOException {  
    @Override
/*  
 * GitHub history for details.
    public String getName() {
package org.opensearch.rest.action.ingest;
/**
        return singletonList(new Route(DELETE, "/_ingest/pipeline/{id}"));  
    }
import org.opensearch.rest.RestRequest;
 * compatible open source license.
import java.io.IOException;
        return "ingest_delete_pipeline_action";
 * not use this file except in compliance with the License.
import org.opensearch.rest.BaseRestHandler;  
 *
}
 * @opensearch.api
        return channel -> client.admin().cluster().deletePipeline(request, new RestToXContentListener<>(channel));
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 *  
        request.clusterManagerNodeTimeout(restRequest.paramAsTime("cluster_manager_timeout", request.clusterManagerNodeTimeout()));
 *
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Transport action to delete an ingest pipeline  
    @Override  
import java.util.List;  
/*
        DeletePipelineRequest request = new DeletePipelineRequest(restRequest.param("id"));
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.logging.DeprecationLogger;
import static org.opensearch.rest.RestRequest.Method.DELETE;  
        parseDeprecatedMasterTimeoutParameter(request, restRequest, deprecationLogger, getName());  
 * under the License.  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 */  
 */  
import static java.util.Collections.singletonList;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rest.action.RestToXContentListener;
public class RestDeletePipelineAction extends BaseRestHandler {
 *
import org.opensearch.transport.client.node.NodeClient;  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * You may obtain a copy of the License at  
/*  
    }  
import org.opensearch.action.ingest.DeletePipelineRequest;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestDeletePipelineAction.class);
