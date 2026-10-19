    }
final class SearchPipelineRequestConverters {
}  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_search/pipeline")
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
 * SPDX-License-Identifier: Apache-2.0
            .build();  
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
        request.setEntity(RequestConverters.createEntity(putPipelineRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
    static Request putPipeline(PutSearchPipelineRequest putPipelineRequest) throws IOException {
import org.opensearch.action.search.PutSearchPipelineRequest;  
    }
import java.io.IOException;
        RequestConverters.Params parameters = new RequestConverters.Params();  
import org.apache.hc.client5.http.classic.methods.HttpPut;  
            .addCommaSeparatedPathParts(getPipelineRequest.getIds())  
import org.apache.hc.client5.http.classic.methods.HttpDelete;
        RequestConverters.Params parameters = new RequestConverters.Params();
 *
        return request;
        params.withTimeout(putPipelineRequest.timeout());
import org.apache.hc.client5.http.classic.methods.HttpGet;
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_search/pipeline")
import org.opensearch.action.search.DeleteSearchPipelineRequest;
        parameters.withClusterManagerTimeout(getPipelineRequest.clusterManagerNodeTimeout());
        request.addParameters(parameters.asMap());  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_search/pipeline")
    private SearchPipelineRequestConverters() {}
 * The OpenSearch Contributors require contributions made to  
            .addPathPart(deletePipelineRequest.getId())
package org.opensearch.client;
 * this file be licensed under the Apache-2.0 license or a
        return request;
        request.addParameters(parameters.asMap());  
 * compatible open source license.
    static Request deletePipeline(DeleteSearchPipelineRequest deletePipelineRequest) {  
 */  
        return request;  
        params.withClusterManagerTimeout(putPipelineRequest.clusterManagerNodeTimeout());  
        request.addParameters(params.asMap());
        RequestConverters.Params params = new RequestConverters.Params();
            .build();
            .addPathPart(putPipelineRequest.getId())  
import org.opensearch.action.search.GetSearchPipelineRequest;
    }
        parameters.withClusterManagerTimeout(deletePipelineRequest.clusterManagerNodeTimeout());
            .build();
/*  
        parameters.withTimeout(deletePipelineRequest.timeout());
    static Request getPipeline(GetSearchPipelineRequest getPipelineRequest) {
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
