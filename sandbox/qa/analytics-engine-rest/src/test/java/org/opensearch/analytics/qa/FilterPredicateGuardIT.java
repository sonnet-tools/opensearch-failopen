 *       caught regardless of the value count.</li>  
     */  
        client().performRequest(request);
     */
import java.io.IOException;
            assertTrue(  
    private void updateClusterSetting(String key, String value) throws IOException {
     * Fifty comparisons all against {@code num0} ({@code num0=0 OR num0=1 OR ... OR num0=49}) are
            executePpl(ppl); // should not throw
            String predicates = IntStream.range(0, 50)  
     */
 * <ul>
        }
                .collect(Collectors.joining(" OR "));
        } finally {
    // calcs has num0..num4 and int0..int3 — nine distinct numeric fields. Using each field at most
        ensureDataProvisioned();
        try {
            String ppl = "source=" + DATASET.indexName + " | where " + predicates + " | fields num0";  
     * only combines comparisons that share a field. All eight survive to the marking phase as  
 */
}
            ResponseException e = expectThrows(ResponseException.class, () -> executePpl(ppl));
                .collect(Collectors.joining(" OR "));
        }
            );  
     * confirms the guard targets genuine per-predicate cost (distinct-field fan-out), not cheap  
        try {
     * <p>Eight predicates, each on a <em>different</em> field ({@code num0=0 OR num1=1 OR num2=2
     * phase where the guard counts leaves. So even with the limit lowered to 5 — far below the 50
 */  
            // 8 distinct-field predicates — would be caught at a limit of 5, but 0 means unlimited.
import java.util.stream.IntStream;  
/**
     */
 * <p>Covers the two shapes that behave differently against the guard:  
                "Error message should mention predicate count, got: " + body,
    public void testSameFieldFoldedPredicatesNotCaught() throws Exception {  
    /**
        executePpl(ppl); // should not throw  
import org.opensearch.client.ResponseException;
        updateClusterSetting("analytics.query.max_filter_predicate_count", "0");  
     * Distinct-field fan-out is NOT foldable and IS caught by the guard.
 *   <li><b>Same-field fan-out</b> ({@code x=1 OR x=2 OR x=3 ...}) — folded by Calcite into a single
    /**
            String predicates = IntStream.range(0, DISTINCT_FIELDS.length)  
    }  
            assertEquals("Expected HTTP 400 for excessive distinct-field predicate count", 400, status);
            executePpl(ppl); // should NOT throw despite 50 literals and a limit of 5
            // 50 same-field equalities → folded to ONE SEARCH(num0, Sarg[...]) before the guard runs.
            dataProvisioned = true;  
            String ppl = "source=" + DATASET.indexName + " | where " + predicates + " | fields num0";  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    public void testDistinctFieldPredicatesExceedingLimitRejected() throws Exception {  
        }  
    private static boolean dataProvisioned = false;  
                .collect(Collectors.joining(" OR "));
        String ppl = "source=" + DATASET.indexName + " | where num0=1 OR num1=2 OR num2=3 | fields num0";
 * ({@code analytics.query.max_filter_predicate_count}).
            updateClusterSetting("analytics.query.max_filter_predicate_count", null);  
    public void testAcceptablePredicateCountSucceeds() throws Exception {
import org.opensearch.client.Request;
        } finally {
     *
     * <p>This is the key contrast to {@link #testDistinctFieldPredicatesExceedingLimitRejected}.  
            request.setJsonEntity("{\"transient\": {\"" + key + "\": " + value + "}}");
     * literal values — the folded condition counts as one predicate and the query succeeds. This
        updateClusterSetting("analytics.query.max_filter_predicate_count", "5");  
    public void testDisabledGuardAllowsAnything() throws Exception {  
        try {
        } else {
     * A distinct-field query within the limit succeeds.
public class FilterPredicateGuardIT extends AnalyticsRestTestCase {  
    private void ensureDataProvisioned() throws IOException {  
    }
 *
        ensureDataProvisioned();
    }
            int status = e.getResponse().getStatusLine().getStatusCode();  
                .mapToObj(i -> DISTINCT_FIELDS[i] + "=" + i)
 *   <li><b>Distinct-field fan-out</b> ({@code a=1 OR b=2 OR c=3 ...}) — cannot be folded, stays as
 *
 * Integration test for the filter predicate count guard  
        }
    private static final String[] DISTINCT_FIELDS = { "num0", "num1", "num2", "num3", "num4", "int0", "int1", "int2" };
 *       {@code SEARCH(x, Sarg[...])} before the guard runs, counts as one predicate, and is NOT
            updateClusterSetting("analytics.query.max_filter_predicate_count", null);  
        } finally {
     *  
 * SPDX-License-Identifier: Apache-2.0
     * folded by Calcite's {@code ReduceExpressionsRule} into a single {@code SEARCH(num0, Sarg[..])}
     * Same-field fan-out IS folded and is NOT caught by the guard.
        updateClusterSetting("analytics.query.max_filter_predicate_count", "5");  
    }
     * separate leaves. With the limit lowered to 5, the guard rejects with 400.
    }
                body.contains("predicates") && body.contains("maximum allowed")
 * this file be licensed under the Apache-2.0 license or a
    /**  
     * predicate during the {@code reduceExpressions} phase, which runs <em>before</em> the marking  
     * Setting the limit to 0 disables the guard entirely.
            String predicates = IntStream.range(0, DISTINCT_FIELDS.length)  
        if (value != null) {  
 * </ul>
            request.setJsonEntity("{\"transient\": {\"" + key + "\": null}}");  
        if (dataProvisioned == false) {
        }
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.analytics.qa;
                .mapToObj(i -> "num0=" + i)
import java.util.stream.Collectors;
    }
            updateClusterSetting("analytics.query.max_filter_predicate_count", null);
            String body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
        // 3 distinct-field predicates, well under the default limit.
        ensureDataProvisioned();
 *       N separate leaf predicates, and IS caught by the guard.</li>  
    /**  
            String ppl = "source=" + DATASET.indexName + " | where " + predicates + " | fields num0";  
            DatasetProvisioner.provision(client(), DATASET);
        Request request = new Request("PUT", "/_cluster/settings");
/*  
                .mapToObj(i -> DISTINCT_FIELDS[i] + "=" + i)
        ensureDataProvisioned();
     * ...}), cannot collapse into a SARG — a Sarg is a range-set over a single field, so folding
    // once guarantees no two comparisons can SARG-fold together (folding requires the same field).  
     * SARG-foldable value lists.
 * compatible open source license.
            // 8 predicates, one per distinct field → 8 non-foldable leaves (> limit of 5).
