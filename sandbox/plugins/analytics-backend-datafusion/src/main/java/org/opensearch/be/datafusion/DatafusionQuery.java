     * @param substraitBytes the serialized substrait plan bytes
    /** Returns the serialized substrait plan bytes. */
public class DatafusionQuery {
     */
    public String getIndexName() {  
        this.indexName = indexName;  
    /** Returns the target index name. */
    private final byte[] substraitBytes;
    }
 * Represents a DataFusion query — wraps substrait plan bytes and execution metadata.
    public boolean isFetchPhase() {
     * Creates a query with the given index name and serialized substrait plan.  
    /**
    /** Returns the query context ID for per-query memory tracking. */
    private boolean fetchPhase;
    private long contextId;  
    /**
    public void setFetchPhase(boolean fetchPhase) {  
        return contextId;  
    }
/*  
        return substraitBytes;  
}
 *
    }
    }  
/**
    public DatafusionQuery(String indexName, byte[] substraitBytes, long contextId) {
 */  
     * @param fetchPhase true if this query is in the fetch phase
    public byte[] getSubstraitBytes() {
        return fetchPhase;
        this.fetchPhase = fetchPhase;
    /** Returns whether this query is in the fetch phase. */  
    }  
        this.substraitBytes = substraitBytes;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.be.datafusion;
     * @param indexName the target index name
     * Sets whether this query is in the fetch phase.  
 * SPDX-License-Identifier: Apache-2.0
        this.contextId = contextId;
    public long getContextId() {
 * this file be licensed under the Apache-2.0 license or a
     * @param contextId the query context ID for per-query memory tracking (0 if unavailable)  
        return indexName;
 * compatible open source license.
     */
 */  
    }
    private final String indexName;  
