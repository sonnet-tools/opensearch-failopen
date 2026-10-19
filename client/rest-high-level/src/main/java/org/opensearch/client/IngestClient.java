            IngestRequestConverters::getPipeline,  
        RequestOptions options,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
 * Unless required by applicable law or agreed to in writing,
     * @param request the request
     * @param request the request
    /**
     */
     * @return cancellable that may be used to cancel the request  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
            options,  
 * the Apache License, Version 2.0 (the "License"); you may
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Simulate a pipeline on a set of documents provided in the request
 * license agreements. See the NOTICE file distributed with
    }  
     * Delete an existing pipeline.  
    }  
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
            listener,
import org.opensearch.action.ingest.SimulatePipelineRequest;
    public GetPipelineResponse getPipeline(GetPipelineRequest request, RequestOptions options) throws IOException {  
    public Cancellable simulateAsync(  
/*  
 * not use this file except in compliance with the License.
    /**
     * @return cancellable that may be used to cancel the request
import org.opensearch.core.action.ActionListener;
     * @return cancellable that may be used to cancel the request
 *
            options,
 * compatible open source license.
            listener,
    }
            IngestRequestConverters::putPipeline,
        );
     * @param listener the listener to be notified upon request completion
import org.opensearch.action.ingest.DeletePipelineRequest;
            IngestRequestConverters::simulatePipeline,  
 *
    public Cancellable getPipelineAsync(GetPipelineRequest request, RequestOptions options, ActionListener<GetPipelineResponse> listener) {  
    /**
        RequestOptions options,
        this.restHighLevelClient = restHighLevelClient;  
        );
     */
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
            Collections.singleton(404)
            emptySet()
            options,  
            request,
            IngestRequestConverters::getPipeline,  
        );  
import static java.util.Collections.emptySet;
     */  
            listener,  
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     * Add a pipeline or update an existing pipeline.
    }
     */
 * specific language governing permissions and limitations
    /**
            options,
            AcknowledgedResponse::fromXContent,  
            GetPipelineResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        ActionListener<SimulatePipelineResponse> listener  
            IngestRequestConverters::putPipeline,
            emptySet()
    }
import java.io.IOException;
            request,  
    /**  
        return restHighLevelClient.performRequestAndParseEntity(
     *
            request,
     *
        );
        );
/**  
     *  
import org.opensearch.action.ingest.SimulatePipelineResponse;  
            emptySet()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            SimulatePipelineResponse::fromXContent,  
 */
            Collections.singleton(404)  
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     *
     * @param listener the listener to be notified upon request completion
public final class IngestClient {
 * SPDX-License-Identifier: Apache-2.0
    }
     * @param request the request  
            emptySet()  
            request,
     * @param request the request  
     * @return the response
        );
 * this work for additional information regarding copyright
    public Cancellable deletePipelineAsync(
 */  
        return restHighLevelClient.performRequestAndParseEntity(
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * Asynchronously delete an existing pipeline.  
        DeletePipelineRequest request,
            request,
     * Get an existing pipeline.
        return restHighLevelClient.performRequestAndParseEntity(  
/*  
    public AcknowledgedResponse deletePipeline(DeletePipelineRequest request, RequestOptions options) throws IOException {
     * Asynchronously add a pipeline or update an existing pipeline.
    }
            options,
package org.opensearch.client;
    /**  
            IngestRequestConverters::deletePipeline,
    }
            options,
    private final RestHighLevelClient restHighLevelClient;  
     * Asynchronously simulate a pipeline on a set of documents provided in the request
     * Asynchronously get an existing pipeline.
            IngestRequestConverters::simulatePipeline,
            request,
 * GitHub history for details.
    /**
 * You may obtain a copy of the License at  
     * @throws IOException in case there is a problem sending the request or parsing back the response
            options,  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        SimulatePipelineRequest request,
     * @return the response  
 *
 */  
            listener,
    public Cancellable putPipelineAsync(PutPipelineRequest request, RequestOptions options, ActionListener<AcknowledgedResponse> listener) {
     * @return the response
            emptySet()  
    /**
import org.opensearch.action.ingest.GetPipelineRequest;
     *  
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param listener the listener to be notified upon request completion  
    ) {
            SimulatePipelineResponse::fromXContent,
            request,  
            request,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized  
 * software distributed under the License is distributed on an
     *  
 * Modifications Copyright OpenSearch Contributors. See
            AcknowledgedResponse::fromXContent,
import org.opensearch.action.ingest.PutPipelineRequest;
    public AcknowledgedResponse putPipeline(PutPipelineRequest request, RequestOptions options) throws IOException {
     * @return the response  
     */
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     * @param request the request
     * @param request the request
 */  
     * @return cancellable that may be used to cancel the request
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @param listener the listener to be notified upon request completion  
 * ownership. Elasticsearch licenses this file to you under  
     */
     *
            emptySet()
     * @param request the request
        return restHighLevelClient.performRequestAsyncAndParseEntity(  
            options,
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
     * @param request the request
        return restHighLevelClient.performRequestAndParseEntity(
    ) {
     */  
 * A wrapper for the {@link RestHighLevelClient} that provides methods for accessing the Ingest API.
 *  
}
 * under the License.  
     *  
            AcknowledgedResponse::fromXContent,
/*
import org.opensearch.action.ingest.GetPipelineResponse;  
 * KIND, either express or implied.  See the License for the
     */
        ActionListener<AcknowledgedResponse> listener
            AcknowledgedResponse::fromXContent,
            GetPipelineResponse::fromXContent,
     * @throws IOException in case there is a problem sending the request or parsing back the response  
            IngestRequestConverters::deletePipeline,
        return restHighLevelClient.performRequestAsyncAndParseEntity(
    IngestClient(RestHighLevelClient restHighLevelClient) {
    public SimulatePipelineResponse simulate(SimulatePipelineRequest request, RequestOptions options) throws IOException {  
