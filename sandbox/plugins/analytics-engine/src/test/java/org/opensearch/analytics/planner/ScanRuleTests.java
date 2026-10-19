 * compatible open source license.
}
package org.opensearch.analytics.planner;
        assertPipelineViableBackends(result, List.of(OpenSearchTableScan.class), Set.of(MockDataFusionBackend.NAME));
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rel.RelNode;  
        RelNode result = unwrapExchange(runPlanner(stubScan(table), context));
/**  
import java.util.Set;
import java.util.List;  
import org.apache.calcite.plan.RelOptUtil;
        PlannerContext context = buildContext("parquet", intFields());  
        logger.info("Plan:\n{}", RelOptUtil.toString(result));  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(2, scan.getOutputFieldStorage().size());
 */
 *
        OpenSearchTableScan scan = (OpenSearchTableScan) result;  
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
/*  
import org.apache.calcite.plan.RelOptTable;
 * Tests for table scan rule: backend assignment and field storage resolution.
    public void testScanResolvesBackendAndFieldStorage() {
        assertEquals("status", scan.getOutputFieldStorage().get(0).getFieldName());
    }
        assertEquals("size", scan.getOutputFieldStorage().get(1).getFieldName());  
 * SPDX-License-Identifier: Apache-2.0
public class ScanRuleTests extends BasePlannerRulesTests {  
        RelOptTable table = mockTable("test_index", "status", "size");
 */  
