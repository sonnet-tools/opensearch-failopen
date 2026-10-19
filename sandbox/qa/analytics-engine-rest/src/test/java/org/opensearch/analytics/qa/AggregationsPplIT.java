 * SPDX-License-Identifier: Apache-2.0
     * ({@code distinct_count(status_code)}, 3 distinct) stays in range and passes. Skipped so the  
 */
/**
    @Override  
    }
    public void testAggregationsPplQueries() throws Exception {  
        return AggregationsTestHelper.DATASET;  
public class AggregationsPplIT extends BasePplIT {
}
/*  
 * The OpenSearch Contributors require contributions made to  
     */
    protected java.util.Set<Integer> getSkipQueries() {
 */  
 * Aggregation functions testing PPL integration test.  
     * Queries skipped due to distinct_count/percentile value mismatches from the engine-native
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    @Override
     * APPROX_COUNT_DISTINCT (HLL sketch), which is approximate and errs by ±1 at the cardinalities  
     * rest run and stay visible; re-enable once the harness tolerates approximate columns.
        return java.util.Set.of(1, 7, 8, 9, 10);
        runPplQueries();
     * used here — exact-match goldens can't hold. Q1 ({@code distinct_count(user)}, 10 distinct per
     * department) over-counts one group to 11; Q7-Q10 are the percentile / HLL-merge cases. Q2
package org.opensearch.analytics.qa;
    /**
    protected Dataset getDataset() {
    }
 *
    }  
