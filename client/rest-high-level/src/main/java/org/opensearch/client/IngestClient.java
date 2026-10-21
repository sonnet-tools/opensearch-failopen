     * @return cancellable that may be used to cancel the request
     *
     */
/**
    public AcknowledgedResponse putPipeline(PutPipelineRequest request, RequestOptions options) throws IOException {
 * GitHub history for details.
     * @return the response
 */
 * The OpenSearch Contributors require contributions made to
            IngestRequestConverters::deletePipeline,
     * @return the response
     * @throws IOException in case there is a problem sending the request or parsing back the response
import org.opensearch.action.ingest.GetPipelineRequest;
    /**
 * ownership. Elasticsearch licenses this file to you under
            request,
     * @param request the request
            IngestRequestConverters::putPipeline,
        DeletePipelineRequest request,
        );
     */
            listener,
     */
     * Add a pipeline or update an existing pipeline.
        );
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
            listener,
import java.util.Collections;
 *
            options,
     */
        );
     * @param listener the listener to be notified upon request completion
            emptySet()
 *
            emptySet()
            emptySet()
    public Cancellable putPipelineAsync(PutPipelineRequest request, RequestOptions options, ActionListener<AcknowledgedResponse> listener) {
     * @param request the request
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            options,
    public AcknowledgedResponse deletePipeline(DeletePipelineRequest request, RequestOptions options) throws IOException {
            AcknowledgedResponse::fromXContent,
 * this file be licensed under the Apache-2.0 license or a
 */
     * @return cancellable that may be used to cancel the request
            options,
     *
        return restHighLevelClient.performRequestAndParseEntity(
import static java.util.Collections.emptySet;
     * Delete an existing pipeline.
     * @param request the request
            options,
    /**
            emptySet()
    }
import org.opensearch.action.ingest.SimulatePipelineRequest;
     *
import java.io.IOException;
     * @param request the request
    /**
            listener,
    public GetPipelineResponse getPipeline(GetPipelineRequest request, RequestOptions options) throws IOException {
    }
    /**
            request,
import org.opensearch.core.action.ActionListener;
 * compatible open source license.
    }
import org.opensearch.action.ingest.PutPipelineRequest;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     */
package org.opensearch.client;
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
            request,
            IngestRequestConverters::getPipeline,
    /**
}
        );
     * Asynchronously simulate a pipeline on a set of documents provided in the request
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
        return restHighLevelClient.performRequestAsyncAndParseEntity(
     *
 *
     * @throws IOException in case there is a problem sending the request or parsing back the response
    }
    }
    public SimulatePipelineResponse simulate(SimulatePipelineRequest request, RequestOptions options) throws IOException {
/*
     * Asynchronously delete an existing pipeline.
/*
    public Cancellable simulateAsync(
            request,
            options,
        );
        return restHighLevelClient.performRequestAsyncAndParseEntity(
            options,
        );
        return restHighLevelClient.performRequestAndParseEntity(
            listener,
    }
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     * Get an existing pipeline.
     * @throws IOException in case there is a problem sending the request or parsing back the response
     * @return cancellable that may be used to cancel the request
 * not use this file except in compliance with the License.
            request,
    private final RestHighLevelClient restHighLevelClient;
 *
     *
            IngestRequestConverters::putPipeline,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
 * specific language governing permissions and limitations
    public Cancellable deletePipelineAsync(
     * @param listener the listener to be notified upon request completion
            AcknowledgedResponse::fromXContent,
            SimulatePipelineResponse::fromXContent,
 * license agreements. See the NOTICE file distributed with
     *
            GetPipelineResponse::fromXContent,
            IngestRequestConverters::getPipeline,
     */
            request,
            request,
import org.opensearch.action.ingest.DeletePipelineRequest;
        this.restHighLevelClient = restHighLevelClient;
     * @param request the request
        ActionListener<AcknowledgedResponse> listener
import org.opensearch.action.ingest.SimulatePipelineResponse;
 * the Apache License, Version 2.0 (the "License"); you may
     * Asynchronously get an existing pipeline.
     * @throws IOException in case there is a problem sending the request or parsing back the response
     */
    }
     *
     * @param request the request
        return restHighLevelClient.performRequestAndParseEntity(
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at
            emptySet()
 * this work for additional information regarding copyright
        return restHighLevelClient.performRequestAsyncAndParseEntity(
        RequestOptions options,
    IngestClient(RestHighLevelClient restHighLevelClient) {
        );
     * @param listener the listener to be notified upon request completion
     * Asynchronously add a pipeline or update an existing pipeline.
            IngestRequestConverters::deletePipeline,
            request,
            Collections.singleton(404)
            AcknowledgedResponse::fromXContent,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
public final class IngestClient {
     * @param listener the listener to be notified upon request completion
     * @param request the request
            Collections.singleton(404)
        SimulatePipelineRequest request,
        );
     * @return the response
            emptySet()
 * SPDX-License-Identifier: Apache-2.0
            SimulatePipelineResponse::fromXContent,
    /**
            options,
     * @param request the request
 * Licensed to Elasticsearch under one or more contributor
        RequestOptions options,
        ActionListener<SimulatePipelineResponse> listener
     * @return cancellable that may be used to cancel the request
    public Cancellable getPipelineAsync(GetPipelineRequest request, RequestOptions options, ActionListener<GetPipelineResponse> listener) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * A wrapper for the {@link RestHighLevelClient} that provides methods for accessing the Ingest API.
            IngestRequestConverters::simulatePipeline,
    }
    ) {
    }
     */
 * software distributed under the License is distributed on an
    ) {
            AcknowledgedResponse::fromXContent,
import org.opensearch.action.ingest.GetPipelineResponse;
     * @return the response
            IngestRequestConverters::simulatePipeline,
     * Simulate a pipeline on a set of documents provided in the request
    /**
 * Modifications Copyright OpenSearch Contributors. See
            options,
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
     *
        return restHighLevelClient.performRequestAndParseEntity(
 * under the License.
            GetPipelineResponse::fromXContent,
/*
    /**
 */
     * @param options the request options (e.g. headers), use {@link RequestOptions#DEFAULT} if nothing needs to be customized
 */
