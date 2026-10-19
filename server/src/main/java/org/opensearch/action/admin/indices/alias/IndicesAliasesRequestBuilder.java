        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().indices(indices).alias(alias).filter(filter));  
    public IndicesAliasesRequestBuilder addAlias(String index, String alias, QueryBuilder filterBuilder) {
/*  
 * SPDX-License-Identifier: Apache-2.0
        return this;
    /**
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
     * Adds an alias to the index.
     * @param alias   The alias
    public IndicesAliasesRequestBuilder addAlias(String index, String alias, Map<String, Object> filter) {
    /**
     *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
     */
    public IndicesAliasesRequestBuilder addAlias(String index, String alias, boolean writeIndex) {
        request.addAliasAction(IndicesAliasesRequest.AliasActions.remove().indices(indices).aliases(aliases));
     * Adds an alias to the index.
     * Adds an alias to the index.
     */
     *  
     * @param indices       The indices
 * the Apache License, Version 2.0 (the "License"); you may
     */
     * @param action The alias action  
 *
    /**
     * @param writeIndex    write index flag  
     * Adds an alias action to the request.
public class IndicesAliasesRequestBuilder extends AcknowledgedRequestBuilder<  
     * @param index   The index
        return this;
     *  
/**  
     * @param index  The indices
        request.addAliasAction(action);  
    }
     *
        request.addAliasAction(IndicesAliasesRequest.AliasActions.remove().index(index).aliases(aliases));  
     * @param filterBuilder The filter  
        return this;
 */
    public IndicesAliasesRequestBuilder removeIndex(String index) {
     */
        return this;
    public IndicesAliasesRequestBuilder addAlias(String index, String alias, String filter) {
    }
     * @param index The index  
 * The OpenSearch Contributors require contributions made to  
        return this;
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index(index).alias(alias));
 * license agreements. See the NOTICE file distributed with
     * @param alias  The alias
     * @param alias         The alias
    /**
/*
    public IndicesAliasesRequestBuilder addAlias(String indices[], String alias, String filter) {
     */
     * @param indices The indices  
     * Removes an alias from the index.
        return this;
     * @param aliases The aliases  
 * this file be licensed under the Apache-2.0 license or a
     * @param alias         The alias
     * @param indices The indices
    public IndicesAliasesRequestBuilder removeAlias(String index, String alias) {
     * @param alias   The alias  
 * Unless required by applicable law or agreed to in writing,
     * Adds an alias to the index.
    }
 * compatible open source license.
     */
    AcknowledgedResponse,
 *
     * @param filter  The filter  
 * GitHub history for details.
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index(index).alias(alias).filter(filterBuilder));  
        return this;
        return this;  
 * Builder for request to modify many aliases at once.
     *  
     * @param alias The alias
    }
import org.opensearch.common.annotation.PublicApi;  
     */
     * @param index The index
 *
     * @param alias  The alias
import java.util.Map;
 */  
    public IndicesAliasesRequestBuilder addAliasAction(IndicesAliasesRequest.AliasActions action) {
    }
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().indices(indices).alias(alias));  
     * @param index         The index
    /**
 */  
    public IndicesAliasesRequestBuilder removeAlias(String index, String[] aliases) {
    IndicesAliasesRequest,
 * under the License.  
     * Removes aliases from the index.
 * You may obtain a copy of the License at  
     * Adds an alias to the index.
        return this;
     */
    }
     */  
     * @param filter  The filter  
package org.opensearch.action.admin.indices.alias;
     *  
    /**
    public IndicesAliasesRequestBuilder addAlias(String index, String alias) {  
    public IndicesAliasesRequestBuilder addAlias(String[] indices, String alias, Map<String, Object> filter) {
        request.addAliasAction(IndicesAliasesRequest.AliasActions.removeIndex().index(index));
    /**  
    IndicesAliasesRequestBuilder> {  
 */
    /**  
        request.addAliasAction(IndicesAliasesRequest.AliasActions.remove().index(index).alias(alias));
    public IndicesAliasesRequestBuilder addAlias(String indices[], String alias, QueryBuilder filterBuilder) {
 * Modifications Copyright OpenSearch Contributors. See
     * Adds an alias to the index.
    public IndicesAliasesRequestBuilder(OpenSearchClient client, IndicesAliasesAction action) {
     */
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().indices(indices).alias(alias).filter(filter));  
 *  
     *  
    }  
    }
     * Removes aliases from the index.  
     * Adds an alias to the index.
 * software distributed under the License is distributed on an
        return this;
     * Adds an alias to the index.  
     * @param indices The indices
     * @param alias The alias
    }
     *  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
     * @param filterBuilder The filter  
     * @param alias         The alias
     * Adds an alias to the index.
     *
        return this;  
    }
 * specific language governing permissions and limitations
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().indices(indices).alias(alias).filter(filterBuilder));  
import org.opensearch.transport.client.OpenSearchClient;
     * @param filter The filter  
    public IndicesAliasesRequestBuilder removeAlias(String[] indices, String... aliases) {  
     */
    /**  
        return this;
@PublicApi(since = "1.0.0")
     * @param alias   The alias
     * @param index         The index
    public IndicesAliasesRequestBuilder addAlias(String[] indices, String alias) {
     * @param index  The index
     *
     */
/*  
    /**
    }  
     *
    }
        return this;
     */
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index(index).alias(alias).filter(filter));  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param filter The filter  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     * @param indices The indices
}  
    /**
    }
        super(client, action, new IndicesAliasesRequest());  
     *  
    /**
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index(index).alias(alias).writeIndex(writeIndex));  
import org.opensearch.index.query.QueryBuilder;
     *
        request.addAliasAction(IndicesAliasesRequest.AliasActions.add().index(index).alias(alias).filter(filter));  
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
     * @param aliases The aliases
    /**
        return this;
 * @opensearch.api  
    }
