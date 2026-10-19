            queryNumbers,
            fail("Big5 PPL query failures (" + failures.size() + " of " + queryNumbers.size() + "):\n" + String.join("\n", failures));
                request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
            STRATEGY  
import org.opensearch.client.Response;  
            DatasetProvisioner.provision(client(), Big5TestHelper.DATASET);
                String ppl = queryBody.trim().replace("big5", dataset.indexName);  
        if (failures.isEmpty() == false) {  
    private static final ExpectedResponseStrategy STRATEGY = ExpectedResponseStrategy.PASS_ON_MISSING;  
 * <a href="https://github.com/opensearch-project/opensearch-benchmark-workloads/blob/main/big5/operations/ppl.json">big5 benchmark workload</a>.
        }  
            "ppl",  
            .filter(n -> SKIP_QUERIES.contains(n) == false)  
    }  
 */  
        }
    private static final Set<Integer> SKIP_QUERIES = Set.of();  
        assertFalse("No PPL queries discovered", queryNumbers.isEmpty());
            client(),  
            (client, dataset, queryBody) -> {
        List<String> failures = DatasetQueryRunner.runQueries(
            .stream()
 * The OpenSearch Contributors require contributions made to  
    protected void onBeforeQuery() throws IOException {
        if (dataProvisioned == false) {  
                return assertOkAndParse(response, "PPL query");
import org.opensearch.client.Request;
        logger.info("Running {} big5 PPL queries (of {} discovered): {}", queryNumbers.size(), queryNumbers.size(), queryNumbers);  
public class PplBig5IT extends AnalyticsRestTestCase {
                Response response = client.performRequest(request);  
import java.util.List;
        List<Integer> queryNumbers = DatasetQueryRunner.discoverQueryNumbers(Big5TestHelper.DATASET, "ppl")
    }
import java.util.Map;  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
}
    @Override
 * this file be licensed under the Apache-2.0 license or a
        );
/*  
 */  
/**  
 *
    public void testBig5PplQueries() throws Exception {  
 * PPL integration test for the
                Request request = new Request("POST", "/_plugins/_ppl");
            },
import java.io.IOException;
    /** Query numbers to skip until the underlying gap is closed. Empty: all 46 pass today. */
    private static boolean dataProvisioned = false;
            "ppl",
import java.util.Set;
            dataProvisioned = true;
package org.opensearch.analytics.qa;
            .toList();
            Big5TestHelper.DATASET,
