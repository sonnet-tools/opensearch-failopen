import org.opensearch.transport.client.OpenSearchClient;  
    }  
/*
 * this work for additional information regarding copyright
/**
 *
 * license agreements. See the NOTICE file distributed with
package org.opensearch.action.admin.cluster.storedscripts;
    public PutStoredScriptRequestBuilder setId(String id) {
    /**
/*  
        return this;
    PutStoredScriptRequest,  
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
    PutStoredScriptRequestBuilder> {
 */
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public PutStoredScriptRequestBuilder(OpenSearchClient client, PutStoredScriptAction action) {
    AcknowledgedResponse,
 * The OpenSearch Contributors require contributions made to  
     * Set the source of the script along with the content type of the source
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
    public PutStoredScriptRequestBuilder setContent(BytesReference source, MediaType mediaType) {
import org.opensearch.common.annotation.PublicApi;  
 */  
        return this;  
 * Transport request builder for putting stored script  
 *  
 * software distributed under the License is distributed on an
 * under the License.  
 * You may obtain a copy of the License at  
        request.id(id);  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        super(client, action, new PutStoredScriptRequest());
 */  
 * this file be licensed under the Apache-2.0 license or a
}
    }
@PublicApi(since = "1.0.0")
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 */  
        request.content(source, mediaType);
public class PutStoredScriptRequestBuilder extends AcknowledgedRequestBuilder<
import org.opensearch.core.xcontent.MediaType;
 * compatible open source license.
 *
import org.opensearch.core.common.bytes.BytesReference;
     */  
 * GitHub history for details.
    }
 * KIND, either express or implied.  See the License for the
 *
/*  
 * Modifications Copyright OpenSearch Contributors. See
