        return this;
 *
    AcknowledgedResponse,
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
 * Transport request builder for deleting an index template  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
@PublicApi(since = "1.0.0")
    }  
 * under the License.  
        super(client, action, new DeleteIndexTemplateRequest(name));  
 * @opensearch.api
 *
        request.name(name);
    public DeleteIndexTemplateRequestBuilder(OpenSearchClient client, DeleteIndexTemplateAction action) {
 * software distributed under the License is distributed on an
/*
 */
 * this work for additional information regarding copyright
     */
 * specific language governing permissions and limitations
/*
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
    DeleteIndexTemplateRequestBuilder> {
 * Unless required by applicable law or agreed to in writing,
}
 */  
     * Sets the name of the index template to delete.
 * The OpenSearch Contributors require contributions made to  
 *  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public DeleteIndexTemplateRequestBuilder setName(String name) {  
 * KIND, either express or implied.  See the License for the
public class DeleteIndexTemplateRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<
import org.opensearch.common.annotation.PublicApi;
    DeleteIndexTemplateRequest,  
        super(client, action, new DeleteIndexTemplateRequest());
 * GitHub history for details.
/**
 * You may obtain a copy of the License at  
package org.opensearch.action.admin.indices.template.delete;
    public DeleteIndexTemplateRequestBuilder(OpenSearchClient client, DeleteIndexTemplateAction action, String name) {
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
    /**  
import org.opensearch.transport.client.OpenSearchClient;  
    }
    }  
 * Modifications Copyright OpenSearch Contributors. See  
