}
 * The OpenSearch Contributors require contributions made to  
/*  
 * Early termination event listener. It is used during concurrent segment search
 *
    void onEarlyTermination(int maxCountHits, boolean forcedTermination);
 * this file be licensed under the Apache-2.0 license or a
 * to propagate the early termination intent.  
    /**
 *
     * @param forcedTermination :true" if forced termination has been requested, "false" otherwise
/**
 */  
 */  
 * compatible open source license.
     * @param maxCountHits desired maximum number of hits
     * Early termination event notification  
package org.opensearch.search.query;
 * SPDX-License-Identifier: Apache-2.0
public interface EarlyTerminatingListener {
 * @opensearch.internal
     */  
