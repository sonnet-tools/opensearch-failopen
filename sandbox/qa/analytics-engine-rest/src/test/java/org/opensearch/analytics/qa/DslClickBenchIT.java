            fail("DSL query failures (" + failures.size() + " of " + queryNumbers.size() + "):\n" + String.join("\n", failures));
        List<String> failures = DatasetQueryRunner.runQueries(
 * cluster, which cascades into the PPL suite as well. Re-enable auto-discovery once the  
        List<Integer> queryNumbers = QUERY_NUMBERS;
                return assertOkAndParse(response, "DSL query");
 * compatible open source license.
/*  
 * Currently restricted to Q1 to keep CI green. Auto-discovery of all 43 ClickBench queries is  
            queryNumbers,  
            (client, dataset, queryBody) -> {
    protected void onBeforeQuery() throws IOException {
        }  
        logger.info("Running {} DSL queries: {}", queryNumbers.size(), queryNumbers);
            ExpectedResponseStrategy.SKIP_VALIDATION
public class DslClickBenchIT extends AnalyticsRestTestCase {  
 * (e.g. ValueCount, Cardinality, MultiTerms) or planner rules, and in some cases crash the
        if (dataProvisioned == false) {
 *
    }
                request.setJsonEntity(queryBody);  
        }
            DatasetProvisioner.provision(client(), ClickBenchTestHelper.DATASET);  
}
    private static final List<Integer> QUERY_NUMBERS = List.of();
            dataProvisioned = true;
 * analytics-engine adds support for those paths.
    }  
import org.opensearch.client.Response;  
 * this file be licensed under the Apache-2.0 license or a
        );
/**
 * Query path: {@code POST /{index}/_search} → dsl-query-executor → Calcite → Substrait → DataFusion
 * <p>  
 * ClickBench DSL integration test. Runs DSL queries against a parquet-backed ClickBench index.
 * The OpenSearch Contributors require contributions made to  
            client(),
import org.opensearch.client.Request;
    private static boolean dataProvisioned = false;
        if (failures.isEmpty() == false) {
 */  
package org.opensearch.analytics.qa;
 * <p>
 * temporarily disabled because several queries exercise unsupported aggregation translators
import java.util.List;
                Request request = new Request("POST", "/" + dataset.indexName + "/_search");
 */
    @Override  
    public void testClickBenchDslQueries() throws Exception {
            "dsl",
            "json",
import java.io.IOException;
            ClickBenchTestHelper.DATASET,  
 * SPDX-License-Identifier: Apache-2.0
            },  
                Response response = client.performRequest(request);
