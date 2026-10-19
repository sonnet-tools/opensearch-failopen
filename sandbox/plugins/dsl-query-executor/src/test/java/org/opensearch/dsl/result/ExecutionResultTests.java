                "small_val",
        assertSame(plan, result.getPlan());
}
        ExecutionResult result = new ExecutionResult(plan, rows);  
                "is_active",  
 * The OpenSearch Contributors require contributions made to  
                "status",  
        List<Object[]> rows = List.<Object[]>of(new Object[] { "laptop", 1200, "brandX", 4.5 });
    }
import org.opensearch.dsl.TestUtils;
 * compatible open source license.
            result.getFieldNames()
                "price",
                "name",
 * this file be licensed under the Apache-2.0 license or a
                "event_nanos",
                "tiny_val",
                "location",
            ),
 */  
                "rating",
                "event_time",
import org.opensearch.dsl.executor.QueryPlans;
                "brand",  
import java.util.List;
            List.of(  
    public void testExecutionResultCarriesPlanAndRows() {  
                "unsigned_counter",  
                "float_val"  
/*  
        assertSame(rows, result.getRows());  
        expectThrows(NullPointerException.class, () -> new ExecutionResult(plan, null));  
                "binary_data",
        assertEquals(
        assertEquals(QueryPlans.Type.HITS, result.getType());
 * SPDX-License-Identifier: Apache-2.0
                "scaled_price",
        QueryPlans.QueryPlan plan = new QueryPlans.QueryPlan(QueryPlans.Type.HITS, TestUtils.createTestRelNode());
    public void testRejectsNullArguments() {  
package org.opensearch.dsl.result;
        );  
        QueryPlans.QueryPlan plan = new QueryPlans.QueryPlan(QueryPlans.Type.HITS, TestUtils.createTestRelNode());
public class ExecutionResultTests extends OpenSearchTestCase {
 *
                "created_date",
                "timestamp",
                "ip_address",  
        expectThrows(NullPointerException.class, () -> new ExecutionResult(null, List.of()));
import org.opensearch.test.OpenSearchTestCase;  
    }
