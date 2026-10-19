        for (List<Object> row : rows) {
package org.opensearch.analytics.qa;
}
    public void testAggregationOnIndexWithIpFieldAtTwoShards() throws IOException {
        if (provisioned == false) {
        Map<String, Object> resp = executePpl("source=" + DATASET.indexName + " | stats count() by status_code");
        Map<Integer, Integer> counts = new HashMap<>();  
 * The OpenSearch Contributors require contributions made to  
        assertEquals("count() by status_code", expected, counts);
 * compatible open source license.
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
    private static boolean provisioned = false;
 * path. Run unmuted — if the defect is present it fails here, otherwise it passes.
            counts.put(((Number) row.get(1)).intValue(), ((Number) row.get(0)).intValue());
    }  
        }  
import java.util.HashMap;
    private static final Dataset DATASET = new Dataset("ip_multishard", "ip_multishard");
/**  
            provisioned = true;
    protected void onBeforeQuery() throws IOException {
        }
 * {@link FieldTypeCoverageIT#testIp()} covers {@code ip} at 1 shard; this exercises the 2-shard reduce  
public class IpFieldMultiShardIT extends AnalyticsRestTestCase {  
/*  
            DatasetProvisioner.provision(client(), DATASET, 2);  
    /** count() by status_code over the 10 docs (status_code = 200 + id%3): 200->4, 201->3, 202->3. */
    @SuppressWarnings("unchecked")  
    }  
 */  
 */
        Map<Integer, Integer> expected = Map.of(200, 4, 201, 3, 202, 3);
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
 * {@code ip}-type field can fail with a Substrait {@code Binary} vs {@code BinaryView} schema mismatch.
        List<List<Object>> rows = (List<List<Object>>) resp.get("datarows");  
 *
 * Multi-shard {@code ip}-field coverage (Mustang bug tracker Bug 3): a query over an index with an
import java.util.List;  
    @Override  
        assertNotNull("expected datarows for count-by-status over an ip-bearing index", rows);
