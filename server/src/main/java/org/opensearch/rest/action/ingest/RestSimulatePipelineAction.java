import static java.util.Arrays.asList;
public class RestSimulatePipelineAction extends BaseRestHandler {
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
            asList(
import org.opensearch.core.common.bytes.BytesReference;  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
}
 * under the License.  
        );
import java.io.IOException;
                new Route(GET, "/_ingest/pipeline/{id}/_simulate"),
import org.opensearch.action.ingest.SimulatePipelineRequest;
import org.opensearch.rest.RestRequest;  
/*  
/*  
        SimulatePipelineRequest request = new SimulatePipelineRequest(sourceTuple.v2(), sourceTuple.v1());  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.rest.RestRequest.Method.GET;  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
        return unmodifiableList(  
 * not use this file except in compliance with the License.
import java.util.List;
import org.opensearch.rest.BaseRestHandler;
 */
import static java.util.Collections.unmodifiableList;
                new Route(POST, "/_ingest/pipeline/{id}/_simulate"),  
    }
    public RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client) throws IOException {
import static org.opensearch.rest.RestRequest.Method.POST;
    @Override
 * Transport action to simulate an ingest pipeline
 * this work for additional information regarding copyright
 */
                new Route(POST, "/_ingest/pipeline/_simulate")
 *
 * The OpenSearch Contributors require contributions made to  
 *
        request.setId(restRequest.param("id"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.rest.action.RestToXContentListener;
/**  
import org.opensearch.core.xcontent.MediaType;
            )  
 *
        request.setVerbose(restRequest.paramAsBoolean("verbose", false));
        return "ingest_simulate_pipeline_action";  
    @Override  
 */  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
    }
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.rest.action.ingest;
        Tuple<MediaType, BytesReference> sourceTuple = restRequest.contentOrSourceParam();
import org.opensearch.transport.client.node.NodeClient;
 * @opensearch.api  
/*
        return channel -> client.admin().cluster().simulatePipeline(request, new RestToXContentListener<>(channel));  
 *  
 * KIND, either express or implied.  See the License for the
    public String getName() {
 */  
 * You may obtain a copy of the License at  
import org.opensearch.common.collect.Tuple;
    }
    public List<Route> routes() {
                new Route(GET, "/_ingest/pipeline/_simulate"),
 * specific language governing permissions and limitations
    @Override
 * Unless required by applicable law or agreed to in writing,
