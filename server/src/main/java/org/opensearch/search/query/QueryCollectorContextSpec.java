 * compatible open source license.
package org.opensearch.search.query;
public interface QueryCollectorContextSpec {
     */
}
    /**
    String getContextName();
     * @param result query result  
     * @throws IOException
 *
     */
     * Create collector
     * @throws IOException
 * interface of QueryCollectorContextSpec
     * Post process query result
     * Context name for QueryCollectorContext
    CollectorManager<?, ReduceableSearchResult> createManager(CollectorManager<?, ReduceableSearchResult> in) throws IOException;
import org.opensearch.common.annotation.ExperimentalApi;  
     * @return collector  
    void postProcess(QuerySearchResult result) throws IOException;  
@ExperimentalApi
 */  
 * The OpenSearch Contributors require contributions made to  
    /**
/**
     * @param in collector
 */  
     * @param in collector manager
     */  
     * @throws IOException  
import org.apache.lucene.search.Collector;
 * this file be licensed under the Apache-2.0 license or a
     * @return string of context name
    /**  
     */
     * Create collector manager  
/*  
    /**  
import java.io.IOException;
     * @return collector manager
    Collector create(Collector in) throws IOException;  
import org.apache.lucene.search.CollectorManager;
 * SPDX-License-Identifier: Apache-2.0
