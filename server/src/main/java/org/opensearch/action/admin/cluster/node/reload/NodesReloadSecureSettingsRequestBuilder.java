 */
 * this work for additional information regarding copyright
 *  
 * the Apache License, Version 2.0 (the "License"); you may
        super(client, action, new NodesReloadSecureSettingsRequest());  
 * compatible open source license.
    }
 *
/*  
 * Builder for the reload secure settings nodes request
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
/**  
@PublicApi(since = "1.0.0")
}
import org.opensearch.action.support.nodes.NodesOperationRequestBuilder;
public class NodesReloadSecureSettingsRequestBuilder extends NodesOperationRequestBuilder<  
/*
    NodesReloadSecureSettingsRequestBuilder> {  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
    public NodesReloadSecureSettingsRequestBuilder setSecureStorePassword(SecureString secureStorePassword) {  
        request.setSecureStorePassword(secureStorePassword);
import org.opensearch.transport.client.OpenSearchClient;
import org.opensearch.core.common.settings.SecureString;  
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.annotation.PublicApi;
 */  
 * @opensearch.api  
 *
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    public NodesReloadSecureSettingsRequestBuilder(OpenSearchClient client, NodesReloadSecureSettingsAction action) {
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 */  
    }  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    NodesReloadSecureSettingsResponse,
 *
        return this;
    NodesReloadSecureSettingsRequest,
 * not use this file except in compliance with the License.
package org.opensearch.action.admin.cluster.node.reload;
 */
