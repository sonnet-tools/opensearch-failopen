}
 * custom logic of exact {@link QueryCollectorContext} implementation.
    /**  
 * @opensearch.api
package org.opensearch.search.query;
    boolean shouldRescore();
 * SPDX-License-Identifier: Apache-2.0
public interface RescoringQueryCollectorContext {
 * compatible open source license.
/*  
 *
 */
 * Abstraction that allows indication of whether results should be rescored or not based on
import org.opensearch.common.annotation.PublicApi;
/**  
@PublicApi(since = "2.15.0")  
     * Indicates if results from the query context should be rescored
     * @return true if results must be rescored, false otherwise
 */  
 * The OpenSearch Contributors require contributions made to  
 *  
 * this file be licensed under the Apache-2.0 license or a
     */  
