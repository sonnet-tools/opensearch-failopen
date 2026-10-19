    DeleteStoredScriptRequest,
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
    public DeleteStoredScriptRequestBuilder setId(String id) {  
 * the Apache License, Version 2.0 (the "License"); you may
        super(client, action, new DeleteStoredScriptRequest());  
 */
    }
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
/*  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
/**  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 *
        request.id(id);
    AcknowledgedResponse,
        return this;  
/*  
 * software distributed under the License is distributed on an
import org.opensearch.transport.client.OpenSearchClient;
 */  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
 */  
 *
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 *
/*
    }
 *  
 * Transport request builder for deleting stored scripts
}  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * @opensearch.api  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.annotation.PublicApi;  
    public DeleteStoredScriptRequestBuilder(OpenSearchClient client, DeleteStoredScriptAction action) {
public class DeleteStoredScriptRequestBuilder extends AcknowledgedRequestBuilder<  
 * under the License.  
@PublicApi(since = "1.0.0")
package org.opensearch.action.admin.cluster.storedscripts;
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    DeleteStoredScriptRequestBuilder> {  
 */
