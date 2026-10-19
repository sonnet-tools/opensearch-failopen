     * Specifies what type of requested indices to ignore and wildcard indices expressions.  
 * license agreements. See the NOTICE file distributed with
}
        return this;
    }
    public GetSettingsRequestBuilder(OpenSearchClient client, GetSettingsAction action, String... indices) {  
    public GetSettingsRequestBuilder setIndices(String... indices) {
        super(client, action, new GetSettingsRequest().indices(indices));
 */
 *  
    /**
 *
 * compatible open source license.
import org.opensearch.action.support.IndicesOptions;
/*  
     * <p>
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 * @opensearch.api
 */  
 */  
import org.opensearch.common.util.ArrayUtils;
        return this;
 * Unless required by applicable law or agreed to in writing,
    }  
        return this;  
 *  
    GetSettingsRequest,
 * Transport request builder for getting index segments
     * For example indices that don't exist.
    }  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.annotation.PublicApi;  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.action.admin.indices.settings.get;
 * GitHub history for details.
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    GetSettingsRequestBuilder> {
    }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
        request.indices(ArrayUtils.concat(request.indices(), indices));
    GetSettingsResponse,  
 * not use this file except in compliance with the License.
 * under the License.  
import org.opensearch.transport.client.OpenSearchClient;
    public GetSettingsRequestBuilder setIndicesOptions(IndicesOptions options) {
        request.indicesOptions(options);
        return this;  
 * this work for additional information regarding copyright
        request.indices(indices);
 * specific language governing permissions and limitations
public class GetSettingsRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<
 * ownership. Elasticsearch licenses this file to you under  
/*
        request.names(names);
    public GetSettingsRequestBuilder addIndices(String... indices) {  
 */
    }
 *
@PublicApi(since = "1.0.0")  
     */  
/**
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
    public GetSettingsRequestBuilder setNames(String... names) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
