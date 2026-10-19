 * not use this file except in compliance with the License.
        super(client, action, new DeletePipelineRequest());  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
/**  
     */  
 * @opensearch.api  
        return this;  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
    public DeletePipelineRequestBuilder setId(String id) {
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
    }
/*
 */  
 * compatible open source license.
import org.opensearch.action.ActionRequestBuilder;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     * Sets the id of the pipeline to delete.
 *
 * Modifications Copyright OpenSearch Contributors. See
@PublicApi(since = "1.0.0")
import org.opensearch.transport.client.OpenSearchClient;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
}  
    /**
 * KIND, either express or implied.  See the License for the
/*  
 *  
    public DeletePipelineRequestBuilder(OpenSearchClient client, DeletePipelineAction action) {
 */  
public class DeletePipelineRequestBuilder extends ActionRequestBuilder<DeletePipelineRequest, AcknowledgedResponse> {  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 */
 * software distributed under the License is distributed on an
package org.opensearch.action.ingest;
import org.opensearch.common.annotation.PublicApi;  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 */
 *
        super(client, action, new DeletePipelineRequest(id));
        request.setId(id);
 * Transport request builder to delete a pipeline
 * specific language governing permissions and limitations
    }
    public DeletePipelineRequestBuilder(OpenSearchClient client, DeletePipelineAction action, String id) {  
/*  
 * You may obtain a copy of the License at  
