    public ValidateQueryRequestBuilder setQuery(QueryBuilder queryBuilder) {
     * Indicates whether the query should be rewritten into primitive queries  
     */
 */
 * compatible open source license.
 *
 */  
package org.opensearch.action.admin.indices.validate.query;
    public ValidateQueryRequestBuilder setRewrite(boolean rewrite) {
}
 * the Apache License, Version 2.0 (the "License"); you may
    ValidateQueryRequestBuilder> {  
    public ValidateQueryRequestBuilder setAllShards(boolean rewrite) {
 * Unless required by applicable law or agreed to in writing,
     *
 * license agreements. See the NOTICE file distributed with
     */
@PublicApi(since = "1.0.0")
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Indicates if detailed information about the query should be returned.
 * You may obtain a copy of the License at  
 *
 * KIND, either express or implied.  See the License for the
        request.allShards(rewrite);
     * @see org.opensearch.index.query.QueryBuilders
     *  
    /**
        return this;
/*  
    /**
     */  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    /**  
    public ValidateQueryRequestBuilder setExplain(boolean explain) {  
     * Indicates whether the query should be validated on all shards
import org.opensearch.transport.client.OpenSearchClient;
 *  
/*  
/**  
        request.rewrite(rewrite);  
 *
 * software distributed under the License is distributed on an
    }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.query.QueryBuilder;  
 * The OpenSearch Contributors require contributions made to  
public class ValidateQueryRequestBuilder extends BroadcastOperationRequestBuilder<  
     * @see org.opensearch.index.query.QueryBuilders  
        return this;
 * @opensearch.api  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 */  
        return this;
    ValidateQueryResponse,
     * The query to validate.
        return this;  
    }
import org.opensearch.common.annotation.PublicApi;
    }  
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
 * GitHub history for details.
 * Transport Request Builder to Validate a Query
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
    }
     */
        super(client, action, new ValidateQueryRequest());  
        request.explain(explain);
    ValidateQueryRequest,
        request.query(queryBuilder);  
/*
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 */
    public ValidateQueryRequestBuilder(OpenSearchClient client, ValidateQueryAction action) {
 * specific language governing permissions and limitations
