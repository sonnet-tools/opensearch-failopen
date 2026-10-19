 *
 *  
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
    public UpgradeStatusRequestBuilder(OpenSearchClient client, UpgradeStatusAction action) {
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 */  
 * KIND, either express or implied.  See the License for the
    UpgradeStatusRequestBuilder> {
        super(client, action, new UpgradeStatusRequest());
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.admin.indices.upgrade.get;
 */  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
/*
 *
}
 * Transport Request Builder for retrieving status of upgrading an Index  
 * @opensearch.api
 * compatible open source license.
 */
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
public class UpgradeStatusRequestBuilder extends BroadcastOperationRequestBuilder<
 * The OpenSearch Contributors require contributions made to  
    UpgradeStatusRequest,  
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
/**
 */  
/*  
import org.opensearch.transport.client.OpenSearchClient;  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
    UpgradeStatusResponse,
@PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
