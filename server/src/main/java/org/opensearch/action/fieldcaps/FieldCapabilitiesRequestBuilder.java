/*  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
        return this;  
        request().includeUnmapped(includeUnmapped);
 * the Apache License, Version 2.0 (the "License"); you may
    }  
/**  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
/*  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.fieldcaps;
import org.opensearch.transport.client.OpenSearchClient;
 * this work for additional information regarding copyright
 * @opensearch.api  
    public FieldCapabilitiesRequestBuilder setIndexFilter(QueryBuilder indexFilter) {  
 * ownership. Elasticsearch licenses this file to you under  
 */
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
        request().indexFilter(indexFilter);
 * You may obtain a copy of the License at  
import org.opensearch.action.ActionRequestBuilder;
 *
        return this;
@PublicApi(since = "1.0.0")
 * not use this file except in compliance with the License.
 * Transport request builder for retrieving field capabilities
    public FieldCapabilitiesRequestBuilder(OpenSearchClient client, FieldCapabilitiesAction action, String... indices) {
    }
import org.opensearch.index.query.QueryBuilder;  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
     * The list of field names to retrieve.  
        super(client, action, new FieldCapabilitiesRequest().indices(indices));
 * KIND, either express or implied.  See the License for the
    /**
 */
    public FieldCapabilitiesRequestBuilder setFields(String... fields) {
 */  
        return this;
 *
/*
import org.opensearch.common.annotation.PublicApi;
 * under the License.  
        request().fields(fields);  
 * license agreements. See the NOTICE file distributed with
}
 * compatible open source license.
    public FieldCapabilitiesRequestBuilder setIncludeUnmapped(boolean includeUnmapped) {
    }  
 * Unless required by applicable law or agreed to in writing,
public class FieldCapabilitiesRequestBuilder extends ActionRequestBuilder<FieldCapabilitiesRequest, FieldCapabilitiesResponse> {  
 * specific language governing permissions and limitations
    }
 */  
