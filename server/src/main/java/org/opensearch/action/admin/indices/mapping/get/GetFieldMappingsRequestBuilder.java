    public GetFieldMappingsRequestBuilder includeDefaults(boolean includeDefaults) {
    }
 * license agreements. See the NOTICE file distributed with
/*  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
        return this;
 * GitHub history for details.
import org.opensearch.action.ActionRequestBuilder;
 */
 * A helper class to build {@link GetFieldMappingsRequest} objects
 *
import org.opensearch.common.util.ArrayUtils;
    public GetFieldMappingsRequestBuilder setFields(String... fields) {
        request.fields(fields);  
 * not use this file except in compliance with the License.
        request.indicesOptions(indicesOptions);  
package org.opensearch.action.admin.indices.mapping.get;
        request.indices(indices);
 * SPDX-License-Identifier: Apache-2.0
    public GetFieldMappingsRequestBuilder(OpenSearchClient client, GetFieldMappingsAction action, String... indices) {  
    }
public class GetFieldMappingsRequestBuilder extends ActionRequestBuilder<GetFieldMappingsRequest, GetFieldMappingsResponse> {
 * Modifications Copyright OpenSearch Contributors. See
 *  
        return this;
    public GetFieldMappingsRequestBuilder setIndices(String... indices) {
    /** Indicates whether default mapping settings should be returned */
    }  
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
/**
        return this;
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    }
import org.opensearch.action.support.IndicesOptions;
        request.includeDefaults(includeDefaults);  
@PublicApi(since = "1.0.0")  
/*
 * this file be licensed under the Apache-2.0 license or a
}  
 * @opensearch.api
 */
    public GetFieldMappingsRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
 */  
import org.opensearch.transport.client.OpenSearchClient;
        return this;  
 * compatible open source license.
    }
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
    }
    /** Sets the fields to retrieve. */
 *
        return this;
import org.opensearch.common.annotation.PublicApi;  
        request.indices(ArrayUtils.concat(request.indices(), indices));
 *  
 * ownership. Elasticsearch licenses this file to you under  
    public GetFieldMappingsRequestBuilder addIndices(String... indices) {  
 * Licensed to Elasticsearch under one or more contributor  
        super(client, action, new GetFieldMappingsRequest().indices(indices));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
