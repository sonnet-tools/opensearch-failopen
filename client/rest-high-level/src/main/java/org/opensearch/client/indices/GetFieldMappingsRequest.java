    }
        return includeDefaults;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.indicesOptions = indicesOptions;
/*  
    }
 * this file be licensed under the Apache-2.0 license or a
 *  
        this.fields = fields;  
    private String[] fields = Strings.EMPTY_ARRAY;
 *
    public GetFieldMappingsRequest local(boolean local) {  
 * Unless required by applicable law or agreed to in writing,
    @Deprecated
    public GetFieldMappingsRequest indicesOptions(IndicesOptions indicesOptions) {  
 */  
    public String[] indices() {
 * SPDX-License-Identifier: Apache-2.0
        this.includeDefaults = includeDefaults;
        this.indices = indices;
 */
    private String[] indices = Strings.EMPTY_ARRAY;  
        return this;  
 * GitHub history for details.
    @Deprecated
 * the Apache License, Version 2.0 (the "License"); you may
    public GetFieldMappingsRequest indices(String... indices) {
 * specific language governing permissions and limitations
    public boolean includeDefaults() {
    }
/** Request the mappings of specific fields */
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public IndicesOptions indicesOptions() {  
        this.local = local;
import org.opensearch.core.common.Strings;  
    public boolean local() {  
 *
import org.opensearch.action.support.IndicesOptions;
 * software distributed under the License is distributed on an
        return indices;  
/*
    /** @param fields a list of fields to retrieve the mapping for */
 * Licensed to Elasticsearch under one or more contributor  
}  
/*  
        return this;
 * under the License.  
    /** Indicates whether default mapping settings should be returned */  
        return indicesOptions;
        return fields;
 * Modifications Copyright OpenSearch Contributors. See
    }  
    private boolean local = false;  
 * this work for additional information regarding copyright
    /**
import org.opensearch.client.Validatable;
    public GetFieldMappingsRequest includeDefaults(boolean includeDefaults) {
    @Deprecated
package org.opensearch.client.indices;
 * license agreements. See the NOTICE file distributed with
    }
    public String[] fields() {
     * where needed, to other nodes. If running locally, request will not raise errors if running locally &amp; missing indices.  
    }
     * Indicate whether the receiving node should operate based on local index information or forward requests,
        return local;
        return this;
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
    }
    }  
 * You may obtain a copy of the License at  
public class GetFieldMappingsRequest implements Validatable {  
    public GetFieldMappingsRequest fields(String... fields) {
 */  
 * ownership. Elasticsearch licenses this file to you under  
    }
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();
 * The OpenSearch Contributors require contributions made to  
        return this;  
        return this;
    }  
 * compatible open source license.
    private boolean includeDefaults = false;
