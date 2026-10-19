 * compatible open source license.
            scan,  
     * 1-shard collated Sort: data already lives on one node, so an ideal planner would
     * at the shard and only the top-K rows are transported.
 */  
            """  
            OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])  
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
            result
        RelNode result = runPlanner(plan, multiShardContext());
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            result
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            """
        assertPlanShape(  
            null,
        // sort -status — DESC NULLS LAST is Calcite's default for DESC.  
        );
        assertPlanShape(
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
 */  
                """,
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        RelNode plan = LogicalSort.create(
    }  
 * <ul>
                  OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])  
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            result  
    public void testSortPlusLimit_2shard() {
        );
            """
        );
    /** PPL frontend emits two LogicalSort nodes for {@code | sort x | head 10}: an outer
                      OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[10], viableBackends=[[mock-parquet]])  
public class SortPlanShapeTests extends PlanShapeTestBase {
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        assertPlanShape(
     *  pure-fetch and an inner collated. Constructed by hand here for the same shape. */
        assertPlanShape("""
 *
    @AwaitsFix(bugUrl = "Optimization: collated Sort over 1-shard SHARD+SINGLETON should stay at shard.")
            result  
    public void testPureLimit_2shard() {
import org.apache.calcite.rel.RelCollations;
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
    }  
import org.apache.calcite.rel.RelNode;  
            result  
                """,
                  OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(buildSortPlusLimit(), singleShardContext());
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    /**
    @AwaitsFix(bugUrl = "Optimization: top-K (collated Sort + outer fetch) over 1-shard SHARD+SINGLETON should stay at shard.")  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
                OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode result = runPlanner(buildSortPlusLimit(), multiShardContext());  
 * SPDX-License-Identifier: Apache-2.0
                    OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
        );
            scan,  
        );
    public void testCollatedSort_2shard() {
 * The OpenSearch Contributors require contributions made to  
        RelNode plan = makeSort(scan, /* fetch */ -1);
                  OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
     */
    }  
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchSort}.
    }
                    OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])  
package org.opensearch.analytics.planner;
     * Sort at coord — same row count moves either way, so this is a benign suboptimality.  
    }
 *       inserts an ER under the Sort. Sort runs at coord.</li>
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
        assertPlanShape(
    public void testSortPlusLimit_1shard() {
 *  
     * which itself runs at coord). Optimal: the entire {@code Sort + fetch} chain stays  
        RelNode innerSort = LogicalSort.create(
        );
     */
        assertPlanShape(  
            """
        RelNode plan = makeLimit(scan, 10);  
                """,  
            null  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
/*  
        );
                OpenSearchSort(sort0=[$0], dir0=[DESC], viableBackends=[[mock-parquet]])
    public void testCollatedSort_2shard_descending() {
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, multiShardContext());
 * </ul>
    public void testPureLimit_1shard() {
    }
    public void testCollatedSort_1shard() {  
                OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
            """, result);
 * <p>Two flavors:
                OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])  
        RelNode plan = makeSort(scan, /* fetch */ -1);
        RelNode result = runPlanner(plan, multiShardContext());
     *  scan to the coordinator. See {@link SortPushdownPlanShapeTests#testBareLimit_2shard_pushed}. */  
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            result  
                OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])
        assertPlanShape(  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
}  
 *   <li><b>Pure-LIMIT Sort</b> (no collation, just {@code fetch}) — partition-local  
            null,
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode plan = makeLimit(scan, 10);  
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.RelFieldCollation;
import org.apache.calcite.rel.logical.LogicalSort;
        return makeLimit(innerSort, 10);
 * this file be licensed under the Apache-2.0 license or a
            """
    }  
 *       fetch is correct. ER goes above the Sort to gather to coord.</li>
    }
                """,
 *   <li><b>Collated Sort</b> (ORDER BY) — needs SINGLETON input. Volcano's  
/**
                """,
            null  
                """,  
     * 1-shard sort + LIMIT pushdown. Today the LIMIT runs at coord (above the inner Sort
            """
        RelNode result = runPlanner(plan, singleShardContext());
    /**  
                OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
     * keep the Sort at the shard and ER above. Today we still insert ER under and run
    /** A bare LIMIT is pushed below the ER so each shard caps locally instead of streaming its whole
        RelNode result = runPlanner(plan, singleShardContext());  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    private RelNode buildSortPlusLimit() {  
 *       {@code OpenSearchSortSplitRule} fires {@code convert(input, COORDINATOR)} which
