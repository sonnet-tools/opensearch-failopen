 */
public class RestGetPipelineAction extends BaseRestHandler {  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestGetPipelineAction.class);
    @Override
 * GitHub history for details.
 * compatible open source license.
        return unmodifiableList(asList(new Route(GET, "/_ingest/pipeline"), new Route(GET, "/_ingest/pipeline/{id}")));  
 */  
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.rest.RestRequest.Method.GET;
import static java.util.Collections.unmodifiableList;
 * KIND, either express or implied.  See the License for the
import org.opensearch.rest.action.RestStatusToXContentListener;  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
    }  
 *
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.core.common.Strings;  
 *  
import static java.util.Arrays.asList;  
        GetPipelineRequest request = new GetPipelineRequest(Strings.splitStringByCommaToArray(restRequest.param("id")));
 *
 */
 */  
    }
import org.opensearch.rest.RestRequest;
/**
 * You may obtain a copy of the License at  
 * under the License.  
import org.opensearch.rest.BaseRestHandler;
        return channel -> client.admin().cluster().getPipeline(request, new RestStatusToXContentListener<>(channel));
        return "ingest_get_pipeline_action";
    @Override
 *  
 * this work for additional information regarding copyright
import org.opensearch.transport.client.node.NodeClient;
/*  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    public String getName() {
 * Transport action to get an ingest pipeline
import java.io.IOException;  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.rest.action.ingest;
import org.opensearch.action.ingest.GetPipelineRequest;
}  
    @Override  
        parseDeprecatedMasterTimeoutParameter(request, restRequest, deprecationLogger, getName());  
import org.opensearch.common.logging.DeprecationLogger;
        request.clusterManagerNodeTimeout(restRequest.paramAsTime("cluster_manager_timeout", request.clusterManagerNodeTimeout()));
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api
    public List<Route> routes() {
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
    public RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client) throws IOException {  
