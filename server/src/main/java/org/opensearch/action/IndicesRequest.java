import org.opensearch.action.support.IndicesOptions;
 * Unless required by applicable law or agreed to in writing,
public interface IndicesRequest {
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * under the License.  
     *
 */  
    }  
    /**  
    interface Replaceable extends IndicesRequest {
 *
    String[] indices();  
}
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * In case of internal requests originated during the distributed execution of an external request,
 * KIND, either express or implied.  See the License for the
     * involved in the request's fulfillment including security, name resolution, etc., should respect this flag.
         * Sets the indices that the action relates to.  
     * accepted, whether an empty array will be converted to _all, and how wildcards will be expanded if needed.
        IndicesRequest indices(String... indices);
     * Replaceable interface.  
 * GitHub history for details.
 *
 *  
    }  
        /**
 * SPDX-License-Identifier: Apache-2.0
/*
 * compatible open source license.
 *  
 */  
 * ownership. Elasticsearch licenses this file to you under  
        return false;
@PublicApi(since = "1.0.0")  
 * this file be licensed under the Apache-2.0 license or a
    /**
 * specific language governing permissions and limitations
/**
     * Returns the indices options used to resolve indices. They tell for instance whether a single index is  
 * @opensearch.api
 * Needs to be implemented by all {@link org.opensearch.action.ActionRequest} subclasses that relate to
     */
 * this work for additional information regarding copyright
 */
     */  
     * Determines whether the request should be applied to data streams. When {@code false}, none of the names or  
         */
 * they will still return the indices that the original request related to.
     * @opensearch.internal
    /**
    /**
     * Returns the array of indices that the action relates to
package org.opensearch.action;
 * the Apache License, Version 2.0 (the "License"); you may
     */
     */  
 */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
/*  
    default boolean includeDataStreams() {
    IndicesOptions indicesOptions();  
     * wildcard expressions in {@link #indices} should be applied to or expanded to any data streams. All layers
 * one or more indices. Allows to retrieve which indices the action relates to.  
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
