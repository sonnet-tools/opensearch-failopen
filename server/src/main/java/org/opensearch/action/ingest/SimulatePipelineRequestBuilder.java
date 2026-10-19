 * Transport request builder to simulate a pipeline
     */  
     * Enable or disable verbose mode
        super(client, action, new SimulatePipelineRequest());
    }
        OpenSearchClient client,
     * Set the id for the pipeline to simulate
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.action.ActionRequestBuilder;
 *
/*
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
    /**
 */
 * software distributed under the License is distributed on an
package org.opensearch.action.ingest;
/*  
     * Create a new builder for {@link SimulatePipelineRequest}s
    public SimulatePipelineRequestBuilder(OpenSearchClient client, SimulatePipelineAction action) {  
        return this;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public SimulatePipelineRequestBuilder setId(String id) {
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
}
 */  
 * SPDX-License-Identifier: Apache-2.0
    ) {  
     */
    public SimulatePipelineRequestBuilder(
 * compatible open source license.
     */  
 * license agreements. See the NOTICE file distributed with
    /**  
     */
 * this work for additional information regarding copyright
     * Create a new builder for {@link SimulatePipelineRequest}s
public class SimulatePipelineRequestBuilder extends ActionRequestBuilder<SimulatePipelineRequest, SimulatePipelineResponse> {
 * KIND, either express or implied.  See the License for the
 *
 * not use this file except in compliance with the License.
 *  
        request.setVerbose(verbose);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.xcontent.MediaType;
        request.setId(id);
        MediaType mediaType
 */
 * GitHub history for details.
/**
    /**
@PublicApi(since = "1.0.0")  
/*  
        BytesReference source,
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
    }
        return this;
    public SimulatePipelineRequestBuilder setVerbose(boolean verbose) {  
    }
 * ownership. Elasticsearch licenses this file to you under  
 *  
import org.opensearch.transport.client.OpenSearchClient;
        super(client, action, new SimulatePipelineRequest(source, mediaType));
        SimulatePipelineAction action,  
    }  
 * You may obtain a copy of the License at  
 * @opensearch.api
