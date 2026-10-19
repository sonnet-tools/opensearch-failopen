     */  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 *  
 * not use this file except in compliance with the License.
 * under the License.  
 * @opensearch.api
/**
 */  
 * specific language governing permissions and limitations
    public RecoveryRequestBuilder setDetailed(boolean detailed) {
 * software distributed under the License is distributed on an
@PublicApi(since = "1.0.0")
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
    }  
 * Recovery information request builder.  
    }
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        request.detailed(detailed);  
 *
import org.opensearch.transport.client.OpenSearchClient;  
 * You may obtain a copy of the License at  
     * Constructs a new recovery information request builder.
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
        return this;
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
    }
 */  
/*
        super(client, action, new RecoveryRequest());
        return this;  
package org.opensearch.action.admin.indices.recovery;
/*  
 * ownership. Elasticsearch licenses this file to you under  
public class RecoveryRequestBuilder extends BroadcastOperationRequestBuilder<RecoveryRequest, RecoveryResponse, RecoveryRequestBuilder> {
 * Unless required by applicable law or agreed to in writing,
 *
import org.opensearch.common.annotation.PublicApi;
 * license agreements. See the NOTICE file distributed with
}
        request.activeOnly(activeOnly);
/*  
    public RecoveryRequestBuilder(OpenSearchClient client, RecoveryAction action) {
    /**
 */
 * compatible open source license.
    public RecoveryRequestBuilder setActiveOnly(boolean activeOnly) {
 * KIND, either express or implied.  See the License for the
