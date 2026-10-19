    /** Queries that fail at 1 shard: multi-index 'one concrete index' limit. Skipped so the rest run and are visible. */
    private void ensureAdditionalDataProvisioned() throws Exception {
}
        runPplQueries();
            DatasetProvisioner.provision(client(), ApiMetricsTestHelper.DATASET);
            DatasetProvisioner.provision(client(), ExceptionLogsTestHelper.DATASET);
        if (!additionalDataProvisioned) {  
/**
public class MultiIndexQueriesPplIT extends BasePplIT {
 * Uses existing indexes from other datasets: security_logs, api_metrics, performance_metrics, exception_logs.  
 * this file be licensed under the Apache-2.0 license or a
        ensureAdditionalDataProvisioned();
 * Multi-Index Queries PPL integration test (multi-index). Tests fields, rename, top, rare, span commands.
    @Override  
 * compatible open source license.
            DatasetProvisioner.provision(client(), PerformanceMetricsTestHelper.DATASET);  
        }  
        return java.util.Set.of(2, 7, 10);
 */
 */  
    }  
 * SPDX-License-Identifier: Apache-2.0
            additionalDataProvisioned = true;
package org.opensearch.analytics.qa;
    protected Dataset getDataset() {
    }  
            DatasetProvisioner.provision(client(), SecurityLogsTestHelper.DATASET);
    public void testMultiIndexQueriesPplQueries() throws Exception {  
    protected java.util.Set<Integer> getSkipQueries() {
    @Override  
 * The OpenSearch Contributors require contributions made to  
/*  
    }
    }  
    private boolean additionalDataProvisioned = false;
        return MultiIndexQueriesTestHelper.DATASET;
 *
