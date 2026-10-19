    Response extends ActionResponse,
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;  
        Builder> {  
 * SPDX-License-Identifier: Apache-2.0
 *  
    /**  
import org.opensearch.action.ActionType;
 * under the License.  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
    public Builder setAliases(String... aliases) {
import org.opensearch.action.support.IndicesOptions;
 */  
    @SuppressWarnings("unchecked")  
    }
    @SuppressWarnings("unchecked")  
    }
    Builder extends BaseAliasesRequestBuilder<Response, Builder>> extends ClusterManagerNodeReadOperationRequestBuilder<  
        return (Builder) this;  
public abstract class BaseAliasesRequestBuilder<
        Response,
    }
 * GitHub history for details.
 * @opensearch.internal
        request.indices(ArrayUtils.concat(request.indices(), indices));
/*  
 * compatible open source license.
 *
import org.opensearch.common.util.ArrayUtils;
package org.opensearch.action.admin.indices.alias.get;
 * not use this file except in compliance with the License.
     * <p>
    }  
        return (Builder) this;  
    public Builder setIndices(String... indices) {
 * specific language governing permissions and limitations
 * Base request builder for listing index aliases  
        GetAliasesRequest,
    }
        request.aliases(ArrayUtils.concat(request.aliases(), aliases));
    @SuppressWarnings("unchecked")  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 */
import org.opensearch.transport.client.OpenSearchClient;  
 * this work for additional information regarding copyright
        request.indices(indices);
 *
     */
/*  
/**
 * Licensed to Elasticsearch under one or more contributor  
    public Builder setIndicesOptions(IndicesOptions options) {  
     * For example indices that don't exist.  
     * Specifies what type of requested indices to ignore and wildcard indices expressions.
 * The OpenSearch Contributors require contributions made to  
    @SuppressWarnings("unchecked")
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.action.ActionResponse;
    public Builder addIndices(String... indices) {
    @SuppressWarnings("unchecked")  
/*
 * Unless required by applicable law or agreed to in writing,
    }
 */  
        super(client, action, new GetAliasesRequest(aliases));  
        request.aliases(aliases);
 */  
        return (Builder) this;  
    public BaseAliasesRequestBuilder(OpenSearchClient client, ActionType<Response> action, String... aliases) {
        request.indicesOptions(options);
    public Builder addAliases(String... aliases) {
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return (Builder) this;  
        return (Builder) this;
 * Modifications Copyright OpenSearch Contributors. See
}
