    @Override
 *       returns 0 rows instead of the expected 3. Same failure under mpp on/off.</li>
        ensureAdditionalDataProvisioned();  
    protected Set<Integer> getSkipQueries() {
 *  
public class MppComplexJoinsPplIT extends BasePplIT {
    private void ensureAdditionalDataProvisioned() throws Exception {  
 */  
import java.io.IOException;  
    private void resetSetting(String key) throws IOException {  
 *
    );  
    }
        Request request = new Request("PUT", "/_cluster/settings");
        6, 8, 9, 10
            DatasetProvisioner.provision(client(), SecurityLogsTestHelper.DATASET);
 * {@code analytics.mpp.enabled=true} (CBO is free to pick BROADCAST or
     * Kept for when the test is un-muted; {@link #SKIPPED_QUERIES} should match
 *   <li>Q6, Q8, Q9, Q10 — hit the {@code DIVIDE(decimal, i64)} → Substrait
 * reasons unrelated to MPP join routing — both mpp-on and mpp-off paths hit the
            // MultiSourceJoinsTestHelper covers app_monitor, event_processor,  
        runPplQueries();
 * <p>Each pass goes through the standard expected-response check
 * ({@link DatasetQueryRunner} + {@link ResponseValidator}) so the asserted row
        }
        runPplQueries();  
        applySetting("analytics.mpp.enabled", "true");
        // Reset the MPP gate after every test so a failure can't leak state into the next.
        ensureAdditionalDataProvisioned();
 * resources — {@code security_logs}, {@code app_monitor}, {@code event_processor},
        client().performRequest(request);  
            DatasetProvisioner.provision(client(), PerformanceMetricsTestHelper.DATASET);
 * {@code kubernetes_logs} and {@code performance_metrics} — and runs each query
        // Stats-join-stats over kubernetes_logs + performance_metrics returns 0 rows.
    }
            DatasetProvisioner.provision(client(), MultiSourceJoinsTestHelper.DATASET);  
 *       {@code destination_ip} mapped as {@code ip}. Substrait emits {@code Binary}  
 * MPP-focused complex-joins PPL integration test (multi-index).
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        resetSetting("analytics.mpp.enabled");
 *       exchange-sink schema check fails.</li>
        super.tearDown();  
    }
 * HASH_SHUFFLE when its cost model favors it).
 *       for those columns but Parquet returns {@code BinaryView}, so the
    @Override
 * automatically catch any MPP-side regression at that point.
 * same reason. Un-mute once the engine bugs are fixed; the parity-pass-pair will
 * twice on the same data: once with {@code analytics.mpp.enabled=false} (every
            additionalDataProvisioned = true;  
        request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
    protected Dataset getDataset() {
 * <p>Provisions every index referenced by the {@code complex_joins} PPL query  
        if (!additionalDataProvisioned) {
 * (from {@link MultiSourceJoinsTestHelper#DATASET}), plus  
 * SPDX-License-Identifier: Apache-2.0
        Request request = new Request("PUT", "/_cluster/settings");
@AwaitsFix(
 * {@code monitor_tracking}, {@code tax_withholding}, {@code voice_verification}
        // DIVIDE(decimal, i64) Substrait conversion not yet supported.
 *
}
    /** Run with the kill switch on — every join routes through coordinator-centric. */
 * join routes through coordinator-centric) and once with  
    bugUrl = "Engine-side bugs (Binary/BinaryView, DIVIDE(decimal,i64), pod_name=host inner join) — see class javadoc"
 *   <li>Q4 — {@code stats by kubernetes.pod_name | inner join … | stats by host}  
    }  
    }
    }
     */
 * in either code path fails the test.
        return ComplexJoinsTestHelper.DATASET;  
    public void tearDown() throws Exception {  
        4,  
 * this file be licensed under the Apache-2.0 license or a
            // referenced by complex_joins/q*.ppl.
 * <ul>
    public void testComplexJoinsPplQueries_mppDisabled() throws Exception {
import java.util.Set;
 * same failures, so the parity guarantee is irrelevant until the underlying
import org.opensearch.client.Request;
 * multisets must match the pinned expected JSON under both modes — a regression  
 *
 * <p>The sibling {@link ComplexJoinsPplIT} is also {@code @AwaitsFix}'d for the  
 *
            DatasetProvisioner.provision(client(), KubernetesLogsTestHelper.DATASET);
 * </ul>
 * The OpenSearch Contributors require contributions made to  
        request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");
            // monitor_tracking, tax_withholding, and voice_verification — all
 * engine bugs are fixed:  
    }
        client().performRequest(request);  
        1, 2, 3, 5, 7,
/**  
)  
    /** Run with MPP on — CBO is free to pick BROADCAST or HASH_SHUFFLE per query. */
 */  
     * Queries known to fail at engine layer for reasons unrelated to MPP routing.
    }  
 * compatible open source license.
        // security_logs ip-column Binary vs BinaryView Substrait mismatch.  
 *   <li>Q1, Q2, Q3, Q5, Q7 — {@code security_logs} has {@code source_ip} /
        applySetting("analytics.mpp.enabled", "false");
    @Override  
    private static final Set<Integer> SKIPPED_QUERIES = Set.of(
     * the engine-bug list in the class javadoc.  
        return SKIPPED_QUERIES;
    private void applySetting(String key, String value) throws IOException {  
/*  
    public void testComplexJoinsPplQueries_mppEnabled() throws Exception {  
 * <p>Currently {@code @AwaitsFix}'d. All ten queries fail at the engine layer for  
    private boolean additionalDataProvisioned = false;
package org.opensearch.analytics.qa;
    /**  
 *       conversion gap in the engine.</li>  
