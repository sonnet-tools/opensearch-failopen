package org.opensearch.analytics.planner;
        RelNode plan = stubScan(mockTable("test_index", "status", "size"));
 */  
    public void testBareScan_1shard() {
 * this file be licensed under the Apache-2.0 license or a
            """, result);  
 * locality-agnostic root SINGLETON demand directly, no ER inserted.  
        );  
public class ScanPlanShapeTests extends PlanShapeTestBase {
                """,
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchTableScan}
        RelNode result = runPlanner(plan, multiShardContext());
/*  
/**  
                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rel.RelNode;
 *
    public void testBareScan_2shard() {  
    }
        RelNode plan = stubScan(mockTable("test_index", "status", "size"));
 * standing alone. Multi-shard scans gather to coord via ER; single-shard scans satisfy the
            result
 * compatible open source license.
        RelNode result = runPlanner(plan, singleShardContext());  
            OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        assertPlanShape("""
    }
                OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            """
}
        assertPlanShape(  
 * The OpenSearch Contributors require contributions made to  
 */
