@PublicApi(since = "1.0.0")
 */
import org.opensearch.transport.client.OpenSearchClient;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * @opensearch.api  
    NodesUsageRequestBuilder> {  
 * under the License.  
import org.opensearch.action.support.nodes.NodesOperationRequestBuilder;
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
/*  
 * KIND, either express or implied.  See the License for the
package org.opensearch.action.admin.cluster.node.usage;
public class NodesUsageRequestBuilder extends NodesOperationRequestBuilder<  
 * Modifications Copyright OpenSearch Contributors. See
        super(client, action, new NodesUsageRequest());  
}  
    }
 * You may obtain a copy of the License at  
import org.opensearch.action.ActionType;
 * software distributed under the License is distributed on an
 *
 * SPDX-License-Identifier: Apache-2.0
    NodesUsageRequest,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public NodesUsageRequestBuilder(OpenSearchClient client, ActionType<NodesUsageResponse> action) {
 * ownership. Elasticsearch licenses this file to you under  
    NodesUsageResponse,
 * Transport builder for collecting OpenSearch telemetry
 *
 * compatible open source license.
/*  
/**  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 *
 */
/*
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 */  
