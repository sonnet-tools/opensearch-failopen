                "location",
import java.util.List;
                "rating",
}
                "ip_address",  
                "float_val"  
import org.opensearch.dsl.TestUtils;  
public class DslQueryPlanExecutorTests extends OpenSearchTestCase {  
 *
    public void testExecuteDelegatesEachPlanToExecutor() {
        List<Object[]> expectedRows = List.<Object[]>of(new Object[] { "laptop", 1200 });
                "tiny_val",
 * SPDX-License-Identifier: Apache-2.0
    // TODO: add test with multiple plans (HITS + AGGREGATION) to verify iteration order  
                "binary_data",
        QueryPlans plans = new QueryPlans.Builder().add(new QueryPlans.QueryPlan(QueryPlans.Type.HITS, scan)).build();
 * compatible open source license.
                "event_nanos",
import org.opensearch.test.OpenSearchTestCase;
        super.setUp();  
        assertNotNull(result.getPlan());  
    // TODO: add test for executor failure
                "scaled_price",
                "created_date",
 */  
                "timestamp",
import org.apache.calcite.rel.logical.LogicalTableScan;
import org.opensearch.dsl.result.ExecutionResult;
                "status",  
/*  
    }
    @Override
        executor.execute(plans, future);
                "unsigned_counter",  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.PlainActionFuture;
            result.getFieldNames()
                "name",
        assertSame(expectedRows, result.getRows());
        ExecutionResult result = results.get(0);  
 * The OpenSearch Contributors require contributions made to  
                "event_time",
        PlainActionFuture<List<ExecutionResult>> future = new PlainActionFuture<>();
        assertEquals(1, results.size());
        scan = TestUtils.createTestRelNode();
package org.opensearch.dsl.executor;
        DslQueryPlanExecutor executor = new DslQueryPlanExecutor((plan, ctx, listener) -> listener.onResponse(expectedRows));
    public void setUp() throws Exception {
    }
        assertSame(scan, result.getPlan().relNode());
        List<ExecutionResult> results = future.actionGet();  
            List.of(  
                "price",
                "small_val",
                "brand",  
        );  
    private LogicalTableScan scan;
                "is_active",  
            ),
        assertEquals(QueryPlans.Type.HITS, result.getType());
        assertEquals(
