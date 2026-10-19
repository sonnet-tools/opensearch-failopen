 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.transport.client.OpenSearchClient;
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
import org.opensearch.action.ActionRequestBuilder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 *  
/*  
 * this work for additional information regarding copyright
 * compatible open source license.
 * @opensearch.internal
 */  
public final class RemoteInfoRequestBuilder extends ActionRequestBuilder<RemoteInfoRequest, RemoteInfoResponse> {  
 * license agreements. See the NOTICE file distributed with
 *
 * under the License.  
    public RemoteInfoRequestBuilder(OpenSearchClient client, RemoteInfoAction action) {
 */  
 *
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        super(client, action, new RemoteInfoRequest());  
 * Modifications Copyright OpenSearch Contributors. See
}
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 *  
/**
    }
 * specific language governing permissions and limitations
package org.opensearch.action.admin.cluster.remote;
/*
 * software distributed under the License is distributed on an
 */
 * Transport builder for remote monitoring
 * GitHub history for details.
