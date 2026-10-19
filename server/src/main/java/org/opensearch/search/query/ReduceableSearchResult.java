/*  
 */  
    void reduce(QuerySearchResult result) throws IOException;
public interface ReduceableSearchResult {
    /**  
     * Apply the reduce operation to the query search results
     */
/**
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.common.annotation.PublicApi;
@PublicApi(since = "2.0.0")
 * The search result callback returned by reduce phase of the collector manager.  
     * @throws IOException exception if reduce operation failed  
package org.opensearch.search.query;
     * @param result query search results
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 *
import java.io.IOException;  
}  
 * compatible open source license.
 * @opensearch.api
 */  
