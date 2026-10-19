 */  
public enum PoolGroup {
package org.opensearch.arrow.spi;
}  
    /** Background merge operations pool group. */
 * Each pool is assigned to exactly one group at registration time.  
    PoolGroup(String name) {
    }  
        return name;
    public String getName() {  
    private final String name;
 * Groups that memory pools belong to for aggregated customer-facing stats.
        this.name = name;
 * The OpenSearch Contributors require contributions made to  
    /** Returns the group name used in stats output. */
 * compatible open source license.
    INDEXING("indexing"),
 *
 *
    SEARCH("search"),
 */  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
    /** Query and analytics execution pool group. */
    /** Ingest and write path pool group. */  
    }
/*  
/**
    /** Arrow Flight transport pool group. */
    TRANSPORT("transport"),  
 * SPDX-License-Identifier: Apache-2.0
    MERGE("merge");  
