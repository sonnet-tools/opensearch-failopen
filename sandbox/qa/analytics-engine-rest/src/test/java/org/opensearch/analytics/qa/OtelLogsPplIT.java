 */  
}  
    }
 * Q18 ({@code dc()} HLL approximation vs exact golden), Q32 (text-equality returns 0 rows),
        // — should restrict viableBackends to lucene for equality on multi-field text.
import java.util.Set;
        // the text-parent parquet column (empty/null). Bug lives in  
    @Override
        // 30 distinct); this is inherent HLL approximation vs the harness's exact-match assertion.
        return Set.of(18, 32, 33);  
        // OpenSearch/sandbox/plugins/analytics-engine/.../OpenSearchFilterRule.java
 * The OpenSearch Contributors require contributions made to  
        // or use `like` (see q5).
 *
        // text+keyword field. Aggregation auto-redirects to the keyword sub-field,
        // Q33: `... | head 0` triggers ClassCastException in  
        return OtelLogsTestHelper.DATASET;  
 * and Q33 (head 0 ClassCastException). All stay on disk as live reproducers — when the
/*  
        //
 */
    protected Dataset getDataset() {
        // 30 distinct traceIds) by 1 — returns 29. Data and golden are both correct (verified
    public void testOtelLogsPplQueries() throws Exception {  
    }
 * this file be licensed under the Apache-2.0 license or a
        // Q32: `where severityText = 'ERROR'` returns 0 rows on a multi-field  
    protected Set<Integer> getSkipQueries() {
package org.opensearch.analytics.qa;
 * compatible open source license.
        //
        // but Mustang's CBO routes equality predicates to DataFusion which scans
    @Override  
        // Reproduces on the configured JDK 25 runtime. Re-enable once the harness tolerates  
 * upstream fixes land, remove the entry from getSkipQueries() to re-enable them.  
/**  
 * OTel logs PPL integration test.
        // approximate columns or dc() is exact for small cardinalities.
        // Workaround in user queries: filter on a numeric parallel (severityNumber=17),  
public class OtelLogsPplIT extends BasePplIT {
 * <p>Three queries are skipped today as documented gaps:  
        // Q18: `stats count(), dc(traceId) by serviceName`. dc() lowers to the engine-native
 * SPDX-License-Identifier: Apache-2.0
        // RelCompositeTrait cannot be cast to RelCollation. Upstream
        runPplQueries();
        // APPROX_COUNT_DISTINCT (HLL sketch), which under-counts the largest group ("cart",  
    }
 *
        // org.opensearch.sql.api.UnifiedQueryPlanner.preserveCollation:145 —
