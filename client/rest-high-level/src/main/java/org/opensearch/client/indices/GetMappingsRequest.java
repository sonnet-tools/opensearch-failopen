 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
        this.local = local;  
 *  
/*  
    public boolean local() {
 * specific language governing permissions and limitations
 */
    public GetMappingsRequest local(boolean local) {
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    /**  
/*
        return local;
        return this;
    public IndicesOptions indicesOptions() {
 * GitHub history for details.
        return indices;
    private boolean local = false;
public class GetMappingsRequest extends TimedRequest {
        this.includeDefaults = includeDefaults;
    }
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
    /** Indicates whether default mapping settings should be returned */  
    public GetMappingsRequest indices(String... indices) {
    public GetMappingsRequest indicesOptions(IndicesOptions indicesOptions) {
import org.opensearch.client.TimedRequest;
 * The OpenSearch Contributors require contributions made to  
        return this;  
        this.indices = indices;  
 * SPDX-License-Identifier: Apache-2.0
 */  
    public boolean includeDefaults() {
    }
    }  
     * forward requests, where needed, to other nodes. If running locally, request will not
    public String[] indices() {  
 * this work for additional information regarding copyright
 * compatible open source license.
    }
}
        this.indicesOptions = indicesOptions;
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.client.indices;
        return indicesOptions;
    }  
     * raise errors if local index information is missing.  
        return this;
    }
 * KIND, either express or implied.  See the License for the
    private boolean includeDefaults = false;
     */
 *
 * not use this file except in compliance with the License.
    private String[] indices = Strings.EMPTY_ARRAY;  
 * software distributed under the License is distributed on an
/*  
    }
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();
import org.opensearch.core.common.Strings;  
    }
 */  
        return includeDefaults;  
     * Indicates whether the receiving node should operate based on local index information or
 * Licensed to Elasticsearch under one or more contributor  
    public GetMappingsRequest includeDefaults(boolean includeDefaults) {
 * under the License.  
        return this;  
import org.opensearch.action.support.IndicesOptions;
