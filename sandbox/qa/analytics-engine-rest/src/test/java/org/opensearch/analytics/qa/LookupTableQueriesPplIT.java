 * this file be licensed under the Apache-2.0 license or a
    @Override  
/**
        runPplQueries();  
     * harness cannot serialize it into the {@code _ppl} request JSON ("Unterminated  
public class LookupTableQueriesPplIT extends BasePplIT {
        return java.util.Set.of(7);
    /**  
 * The OpenSearch Contributors require contributions made to  
 */  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.analytics.qa;
 * compatible open source license.
        return LookupTableQueriesTestHelper.DATASET;
    protected Dataset getDataset() {
     */
 * Lookup Table Queries PPL integration test (multi-index). Runs PPL queries with lookup operations.
    }  
}
    }
 */  
/*  
    @Override  
    protected java.util.Set<Integer> getSkipQueries() {
     * string"), and it also exercises eventstats / dedup / percentile.
    }  
 *
     * its failure is unrelated to grok — the q7.ppl body is multi-line so the test
    public void testLookupTableQueriesPplQueries() throws Exception {
     * q1 (grok extract -> stats) now runs on the analytics route. q7 stays skipped:
