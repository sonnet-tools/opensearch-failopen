 * monitor_tracking, performance_metrics, voice_verification.
    private void ensureAdditionalDataProvisioned() throws Exception {
            additionalDataProvisioned = true;
 * The OpenSearch Contributors require contributions made to  
/**
 * SPDX-License-Identifier: Apache-2.0
    /** Queries that fail at 1 shard: join row-count / unsupported shapes. Skipped so the rest run and are visible. */
package org.opensearch.analytics.qa;
        return ComplexJoinsTestHelper.DATASET;
 */  
    }
            DatasetProvisioner.provision(client(), PerformanceMetricsTestHelper.DATASET);  
 * Uses existing indexes from other datasets: security_logs, app_monitor, kubernetes_logs,
        if (!additionalDataProvisioned) {
 *
 * Complex Joins PPL integration test (multi-index). Tests join operations across multiple indexes.  
    @Override
    }  
    protected Dataset getDataset() {  
public class ComplexJoinsPplIT extends BasePplIT {
 */  
    @Override
    public void testComplexJoinsPplQueries() throws Exception {
        return java.util.Set.of(1, 2, 3, 4, 7, 8, 9, 10);
            DatasetProvisioner.provision(client(), KubernetesLogsTestHelper.DATASET);
    protected java.util.Set<Integer> getSkipQueries() {  
            DatasetProvisioner.provision(client(), SecurityLogsTestHelper.DATASET);  
 * compatible open source license.
/*  
    }
    }
        ensureAdditionalDataProvisioned();  
}  
        }
            DatasetProvisioner.provision(client(), MultiSourceJoinsTestHelper.DATASET);
    private boolean additionalDataProvisioned = false;  
        runPplQueries();
 * this file be licensed under the Apache-2.0 license or a
