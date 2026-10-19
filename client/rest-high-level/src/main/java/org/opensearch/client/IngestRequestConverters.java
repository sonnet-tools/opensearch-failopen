            builder.addPathPart(simulatePipelineRequest.getId());
            .build();
final class IngestRequestConverters {  
        request.addParameters(parameters.asMap());  
        RequestConverters.Params params = new RequestConverters.Params();  
 */  
import org.opensearch.action.ingest.PutPipelineRequest;
        return request;
        return request;
        request.setEntity(RequestConverters.createEntity(putPipelineRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
 * GitHub history for details.
        String endpoint = builder.build();
 * not use this file except in compliance with the License.
import org.apache.hc.client5.http.classic.methods.HttpGet;
 */  
import org.apache.hc.client5.http.classic.methods.HttpPut;
        Request request = new Request(HttpPost.METHOD_NAME, endpoint);
    private IngestRequestConverters() {}
        parameters.withClusterManagerTimeout(putPipelineRequest.clusterManagerNodeTimeout());  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.ingest.GetPipelineRequest;  
        request.setEntity(RequestConverters.createEntity(simulatePipelineRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));  
        return request;  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 *  
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
    static Request simulatePipeline(SimulatePipelineRequest simulatePipelineRequest) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
package org.opensearch.client;
        parameters.withClusterManagerTimeout(deletePipelineRequest.clusterManagerNodeTimeout());
/*  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
            .build();
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_ingest/pipeline")
 * Unless required by applicable law or agreed to in writing,
import org.apache.hc.client5.http.classic.methods.HttpPost;  
        if (simulatePipelineRequest.getId() != null && !simulatePipelineRequest.getId().isEmpty()) {  
import org.opensearch.action.ingest.SimulatePipelineRequest;
 * this file be licensed under the Apache-2.0 license or a
        RequestConverters.Params parameters = new RequestConverters.Params();  
 *
import org.apache.hc.client5.http.classic.methods.HttpDelete;
}  
 * specific language governing permissions and limitations
            .build();  
        RequestConverters.Params parameters = new RequestConverters.Params();
        builder.addPathPartAsIs("_simulate");  
import org.opensearch.action.ingest.DeletePipelineRequest;
 * The OpenSearch Contributors require contributions made to  
            .addCommaSeparatedPathParts(getPipelineRequest.getIds())  
 *
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_ingest/pipeline")
        parameters.withTimeout(putPipelineRequest.timeout());
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
        RequestConverters.EndpointBuilder builder = new RequestConverters.EndpointBuilder().addPathPartAsIs("_ingest/pipeline");
        request.addParameters(parameters.asMap());
    }
 * under the License.  
/*
 * software distributed under the License is distributed on an
            .addPathPart(putPipelineRequest.getId())  
    }
    static Request getPipeline(GetPipelineRequest getPipelineRequest) {
        return request;
        request.addParameters(params.asMap());
 * Licensed to Elasticsearch under one or more contributor  
        RequestConverters.Params parameters = new RequestConverters.Params();
    static Request deletePipeline(DeletePipelineRequest deletePipelineRequest) {  
        request.addParameters(parameters.asMap());  
 */
    static Request putPipeline(PutPipelineRequest putPipelineRequest) throws IOException {
 * this work for additional information regarding copyright
        parameters.withClusterManagerTimeout(getPipelineRequest.clusterManagerNodeTimeout());
        parameters.withTimeout(deletePipelineRequest.timeout());
        params.putParam("verbose", Boolean.toString(simulatePipelineRequest.isVerbose()));
/*  
    }
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
            .addPathPart(deletePipelineRequest.getId())
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_ingest/pipeline")
 * compatible open source license.
        }
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
