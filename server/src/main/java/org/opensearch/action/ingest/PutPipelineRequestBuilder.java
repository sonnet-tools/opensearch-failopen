 * You may obtain a copy of the License at  
    public PutPipelineRequestBuilder(OpenSearchClient client, PutPipelineAction action) {
/**
 * @opensearch.api
 * specific language governing permissions and limitations
 *  
 * Unless required by applicable law or agreed to in writing,
        MediaType mediaType
 * Transport request builder to put a pipeline  
/*  
 */  
    public PutPipelineRequestBuilder(
}
/*
import org.opensearch.action.ActionRequestBuilder;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * this work for additional information regarding copyright
 */  
@PublicApi(since = "1.0.0")
        super(client, action, new PutPipelineRequest());
 *
/*  
import org.opensearch.transport.client.OpenSearchClient;  
import org.opensearch.core.common.bytes.BytesReference;
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 */  
public class PutPipelineRequestBuilder extends ActionRequestBuilder<PutPipelineRequest, AcknowledgedResponse> {
        String id,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
        PutPipelineAction action,
 * compatible open source license.
        BytesReference source,  
        super(client, action, new PutPipelineRequest(id, source, mediaType));  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
    ) {
 * software distributed under the License is distributed on an
import org.opensearch.common.annotation.PublicApi;  
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
    }
 * under the License.  
import org.opensearch.core.xcontent.MediaType;
        OpenSearchClient client,  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.action.ingest;
