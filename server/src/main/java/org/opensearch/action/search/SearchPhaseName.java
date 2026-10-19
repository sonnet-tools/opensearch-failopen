    CAN_MATCH("can_match");  
    FETCH("fetch"),  
 * The OpenSearch Contributors require contributions made to  
public enum SearchPhaseName {  
    }
    }  
/*  
 * Enum for different Search Phases in OpenSearch
 *
    public String getName() {
    DFS_PRE_QUERY("dfs_pre_query"),
 * @opensearch.api  
/**  
 * this file be licensed under the Apache-2.0 license or a
}
 */
    private final String name;
    QUERY("query"),
    EXPAND("expand"),
        this.name = name;
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.search;
import org.opensearch.common.annotation.PublicApi;
 * compatible open source license.
 *
@PublicApi(since = "2.9.0")
    DFS_QUERY("dfs_query"),
 */  
        return name;  
    SearchPhaseName(final String name) {
