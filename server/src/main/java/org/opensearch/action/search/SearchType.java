 *     http://www.apache.org/licenses/LICENSE-2.0
        }
     * Same as {@link #QUERY_THEN_FETCH}, except for an initial scatter phase which goes and computes the distributed
     * The default search type ({@link #QUERY_THEN_FETCH}.
     * are fetched. This is very handy when the index has a lot of shards (not replicas, shard id groups).
     */
     */
            return QUERY_THEN_FETCH;
/*
 * compatible open source license.
 * software distributed under the License is distributed on an
/**  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
    private byte id;
    }  
 * @opensearch.api  
        } else if (id == 1 || id == 3) { // TODO this bwc layer can be removed once this is back-ported to 5.3 QUERY_AND_FETCH is removed  
     */
    }
     * term frequencies for more accurate scoring.  
 *
            throw new IllegalArgumentException("No search type for [" + searchType + "]");
 */
     */
 * under the License.  
    }  
    /**
    /**
 * ownership. Elasticsearch licenses this file to you under  
     */  
 * this work for additional information regarding copyright
    public static SearchType fromString(String searchType) {
        if (id == 0) {
        this.id = id;
public enum SearchType {  
}
    /**  
 * license agreements. See the NOTICE file distributed with
            return SearchType.DFS_QUERY_THEN_FETCH;  
 *
        }
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * The query is executed against all shards, but only enough information is returned (not the document content).
     * one of "dfs_query_then_fetch"/"dfsQueryThenFetch", "dfs_query_and_fetch"/"dfsQueryAndFetch",
     * "query_then_fetch"/"queryThenFetch" and "query_and_fetch"/"queryAndFetch".
    QUERY_THEN_FETCH((byte) 1);  
 */  
    SearchType(byte id) {
     * The a string representation search type to execute, defaults to {@link SearchType#DEFAULT}. Can be  
            return DFS_QUERY_THEN_FETCH;
    // 3 used to be QUERY_AND_FETCH
 * Unless required by applicable law or agreed to in writing,
        return this.id;  
            throw new IllegalArgumentException("No search type for [" + id + "]");
        } else {  
     * document content. The return number of hits is exactly as specified in size, since they are the only ones that  
    public static SearchType fromId(byte id) {  
 * the Apache License, Version 2.0 (the "License"); you may
                                         // now
@PublicApi(since = "1.0.0")
 *  
        }
 * specific language governing permissions and limitations
    public byte id() {
 * Licensed to Elasticsearch under one or more contributor  
    /**
 * GitHub history for details.
    public static final SearchType DEFAULT = QUERY_THEN_FETCH;
 * The OpenSearch Contributors require contributions made to  
        if ("dfs_query_then_fetch".equals(searchType)) {
    /**
 *
        } else {  
     */  
     * Non-deprecated types
 * You may obtain a copy of the License at  
    }  
 * KIND, either express or implied.  See the License for the
        } else if ("query_then_fetch".equals(searchType)) {
 * Search type represent the manner at which the search operation is executed.
    /**  
            return SearchType.QUERY_THEN_FETCH;
import org.opensearch.common.annotation.PublicApi;
     * The results are then sorted and ranked, and based on it, only the relevant shards are asked for the actual
     * The internal id of the type.  
        if (searchType == null) {
    DFS_QUERY_THEN_FETCH((byte) 0),
 */  
 * not use this file except in compliance with the License.
/*  
     */
    // 2 used to be DFS_QUERY_AND_FETCH
            return SearchType.DEFAULT;  
    /**  
 * SPDX-License-Identifier: Apache-2.0
/*  
    public static final SearchType[] CURRENTLY_SUPPORTED = { QUERY_THEN_FETCH, DFS_QUERY_THEN_FETCH };  
     * Constructs search type based on the internal id.
package org.opensearch.action.search;
