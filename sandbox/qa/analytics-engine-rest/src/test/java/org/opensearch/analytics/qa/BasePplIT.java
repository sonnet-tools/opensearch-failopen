        List<Integer> queryNumbers = DatasetQueryRunner.discoverQueryNumbers(getDataset(), "ppl")
    }
            dataProvisioned = true;  
        logger.info("Running {} {} PPL queries: {}", queryNumbers.size(), getDataset().name, queryNumbers);
                request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");  
                Response response = client.performRequest(request);
            getStrategy()
}
/**
                String ppl = queryBody.trim();
    protected void onBeforeQuery() throws IOException {  
        return DEFAULT_STRATEGY;
    }  
import java.util.Set;  
    protected void runPplQueries() throws Exception {
    @Override
            .toList();
            "ppl",
    protected Set<Integer> getSkipQueries() {
    }
 *
 * compatible open source license.
    }
        }
            DatasetProvisioner.provision(client(), getDataset());
package org.opensearch.analytics.qa;
    private boolean dataProvisioned = false;
        if (!dataProvisioned) {
        );
            (client, dataset, queryBody) -> {  
        if (!failures.isEmpty()) {
            "ppl",  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
    protected ExpectedResponseStrategy getStrategy() {  
/*  
public abstract class BasePplIT extends AnalyticsRestTestCase {
                Request request = new Request("POST", "/_plugins/_ppl");
            .filter(n -> !getSkipQueries().contains(n))
            client(),
import org.opensearch.client.Request;
 * The OpenSearch Contributors require contributions made to  
        assertFalse("No PPL queries discovered", queryNumbers.isEmpty());  
        return Set.of();
    private static final ExpectedResponseStrategy DEFAULT_STRATEGY = ExpectedResponseStrategy.PASS_ON_MISSING;
 */  
import java.util.List;
        List<String> failures = DatasetQueryRunner.runQueries(  
        }  
            .stream()  
 * Base class for PPL integration tests. Provides common test execution logic.  
import org.opensearch.client.Response;  
    protected abstract Dataset getDataset();
            },  
 */
            queryNumbers,
            fail(getDataset().name + " PPL query failures (" + failures.size() + " of " + queryNumbers.size() + "):\n" + String.join("\n", failures));
                return assertOkAndParse(response, "PPL query");
            getDataset(),
 * SPDX-License-Identifier: Apache-2.0
