    /**
     * @param request the request
        return restHighLevelClient.performRequestAndParseEntity(
    }
 * SPDX-License-Identifier: Apache-2.0
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * Asynchronously delete an existing pipeline.  
        );
 */  
     *
    private final RestHighLevelClient restHighLevelClient;
        );
     */
        ActionListener<AcknowledgedResponse> listener
            emptySet()
    ) {
    /**
            request,
            options,
            SearchPipelineRequestConverters::getPipeline,
     * Get existing pipelines.
    }  
        return restHighLevelClient.performRequestAndParseEntity(  
        );
            options,  
        );  
package org.opensearch.client;
     *
            GetSearchPipelineResponse::fromXContent,
            listener,  
            request,  
            listener,
    public Cancellable putAsync(PutSearchPipelineRequest request, RequestOptions options, ActionListener<AcknowledgedResponse> listener) {
     */  
            options,
    }  
            AcknowledgedResponse::fromXContent,  
     * @return the response
    /**
import org.opensearch.action.search.GetSearchPipelineResponse;  
            SearchPipelineRequestConverters::getPipeline,  
     * @return cancellable that may be used to cancel the request
    public AcknowledgedResponse put(PutSearchPipelineRequest request, RequestOptions options) throws IOException {
     * @param listener the listener to be notified upon request completion
    SearchPipelineClient(RestHighLevelClient restHighLevelClient) {
        RequestOptions options,  
 * The OpenSearch Contributors require contributions made to  
     * @param request the request
            Collections.singleton(404)
            SearchPipelineRequestConverters::putPipeline,
    /**  
    public AcknowledgedResponse delete(DeleteSearchPipelineRequest request, RequestOptions options) throws IOException {
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    }  
        return restHighLevelClient.performRequestAndParseEntity(
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    public GetSearchPipelineResponse get(GetSearchPipelineRequest request, RequestOptions options) throws IOException {
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
        ActionListener<GetSearchPipelineResponse> listener
        DeleteSearchPipelineRequest request,
import java.io.IOException;
    public Cancellable deleteAsync(
 * compatible open source license.
     * @param request the request  
     * Add a pipeline or update an existing pipeline.  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
/*  
            request,  
            Collections.singleton(404)
 * this file be licensed under the Apache-2.0 license or a
            GetSearchPipelineResponse::fromXContent,
            options,
import org.opensearch.action.search.GetSearchPipelineRequest;
    }
     */  
     * @param listener the listener to be notified upon request completion
        );  
     * @return cancellable that may be used to cancel the request  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return cancellable that may be used to cancel the request
     * @return the response
            emptySet()  
            SearchPipelineRequestConverters::putPipeline,
        );
        this.restHighLevelClient = restHighLevelClient;
            request,
    ) {  
        RequestOptions options,
}
 *
     * @param request the request  
     * @param request the request
    }
            request,  
import org.opensearch.core.action.ActionListener;  
            request,
            options,  
            emptySet()
    /**
     */  
    /**  
            listener,
     */  
     *
     *
import org.opensearch.action.search.DeleteSearchPipelineRequest;
     * Delete an existing pipeline.  
     * @param request the request
    public Cancellable getAsync(
            AcknowledgedResponse::fromXContent,
     * Asynchronously get existing pipelines.
     * @throws IOException in case there is a problem sending the request or parsing back the response
    }  
            AcknowledgedResponse::fromXContent,  
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            emptySet()
            SearchPipelineRequestConverters::deletePipeline,
public final class SearchPipelineClient {
     * @throws IOException in case there is a problem sending the request or parsing back the response  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            SearchPipelineRequestConverters::deletePipeline,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     * Asynchronously add a pipeline or update an existing pipeline.  
            options,
     *
     * @return the response
import org.opensearch.action.search.PutSearchPipelineRequest;
            AcknowledgedResponse::fromXContent,  
import java.util.Collections;  
     * @param listener the listener to be notified upon request completion
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
     */
     *
import static java.util.Collections.emptySet;
        GetSearchPipelineRequest request,  
