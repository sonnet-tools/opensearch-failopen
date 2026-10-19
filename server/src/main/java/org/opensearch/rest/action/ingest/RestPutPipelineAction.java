 *
import static java.util.Collections.singletonList;
 * KIND, either express or implied.  See the License for the
import org.opensearch.transport.client.node.NodeClient;  
/**
        PutPipelineRequest request = new PutPipelineRequest(restRequest.param("id"), sourceTuple.v2(), sourceTuple.v1());  
package org.opensearch.rest.action.ingest;
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        return channel -> client.admin().cluster().putPipeline(request, new RestToXContentListener<>(channel));
import org.opensearch.core.xcontent.MediaType;
 *
 * this work for additional information regarding copyright
 * @opensearch.api
import static org.opensearch.rest.RestRequest.Method.PUT;  
    }
import org.opensearch.action.ingest.PutPipelineRequest;
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
    @Override
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestPutPipelineAction.class);  
/*
 * specific language governing permissions and limitations
        return singletonList(new Route(PUT, "/_ingest/pipeline/{id}"));
/*  
import org.opensearch.rest.action.RestToXContentListener;
 * under the License.  
    public String getName() {
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
}
 * Modifications Copyright OpenSearch Contributors. See
public class RestPutPipelineAction extends BaseRestHandler {
 * Unless required by applicable law or agreed to in writing,
    public RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client) throws IOException {
 * You may obtain a copy of the License at  
        return "ingest_put_pipeline_action";  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    }
 * license agreements. See the NOTICE file distributed with
/*  
 * compatible open source license.
 * Transport action to put a pipeline  
import org.opensearch.rest.RestRequest;
        Tuple<MediaType, BytesReference> sourceTuple = restRequest.contentOrSourceParam();
 * ownership. Elasticsearch licenses this file to you under  
    }
 *  
import org.opensearch.core.common.bytes.BytesReference;
 */  
    @Override  
    @Override
 */
        parseDeprecatedMasterTimeoutParameter(request, restRequest, deprecationLogger, getName());
import org.opensearch.rest.BaseRestHandler;  
        request.clusterManagerNodeTimeout(restRequest.paramAsTime("cluster_manager_timeout", request.clusterManagerNodeTimeout()));
import org.opensearch.common.logging.DeprecationLogger;  
    public List<Route> routes() {  
 */  
import org.opensearch.common.collect.Tuple;
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
        request.timeout(restRequest.paramAsTime("timeout", request.timeout()));  
 */  
 * GitHub history for details.
