                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     * which itself runs at coord). Optimal: the entire {@code Sort + fetch} chain stays
        RelNode plan = makeSort(scan, /* fetch */ -1);
        assertPlanShape("""
 * this file be licensed under the Apache-2.0 license or a
        );
        RelNode result = runPlanner(buildSortPlusLimit(), singleShardContext());
 * </ul>
        RelNode plan = makeLimit(scan, 10);
            result
 * <ul>
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                  OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, singleShardContext());
    public void testSortPlusLimit_2shard() {
 * SPDX-License-Identifier: Apache-2.0
                  OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])
    public void testPureLimit_1shard() {
 *
/**
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    }
import org.apache.calcite.rel.logical.LogicalSort;
                OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])
            scan,
        assertPlanShape(
 * compatible open source license.
 *   <li><b>Collated Sort</b> (ORDER BY) — needs SINGLETON input. Volcano's
            """
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
}
 */
    private RelNode buildSortPlusLimit() {
                OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
    public void testCollatedSort_1shard() {
    }
    /**
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    public void testPureLimit_2shard() {
            """
        assertPlanShape(
              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
 * <p>Two flavors:
            """, result);
 */
package org.opensearch.analytics.planner;
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.DESCENDING)),
    public void testCollatedSort_2shard() {
        );
        RelNode plan = makeSort(scan, /* fetch */ -1);
import org.apache.calcite.rel.RelFieldCollation;
 *   <li><b>Pure-LIMIT Sort</b> (no collation, just {@code fetch}) — partition-local
        );
     * at the shard and only the top-K rows are transported.
            OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     *  scan to the coordinator. See {@link SortPushdownPlanShapeTests#testBareLimit_2shard_pushed}. */
     * 1-shard sort + LIMIT pushdown. Today the LIMIT runs at coord (above the inner Sort
                """,
            """
            """
    @AwaitsFix(bugUrl = "Optimization: top-K (collated Sort + outer fetch) over 1-shard SHARD+SINGLETON should stay at shard.")
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            """
        RelNode result = runPlanner(plan, multiShardContext());
        RelNode result = runPlanner(plan, singleShardContext());
     */
                OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])
        );
            result
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        );
        RelNode result = runPlanner(plan, multiShardContext());
                      OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[10], viableBackends=[[mock-parquet]])
 * The OpenSearch Contributors require contributions made to
 *       inserts an ER under the Sort. Sort runs at coord.</li>
                OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    }
     * Sort at coord — same row count moves either way, so this is a benign suboptimality.
            null
                """,
            null,
    /**
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     *  pure-fetch and an inner collated. Constructed by hand here for the same shape. */
        RelNode plan = LogicalSort.create(
    /** PPL frontend emits two LogicalSort nodes for {@code | sort x | head 10}: an outer
        );
    }
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    }
            result
 *       {@code OpenSearchSortSplitRule} fires {@code convert(input, COORDINATOR)} which
            result
                """,
     */
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
        assertPlanShape(
                """,
            result
     * keep the Sort at the shard and ER above. Today we still insert ER under and run
    /** A bare LIMIT is pushed below the ER so each shard caps locally instead of streaming its whole
        assertPlanShape(
            null,
            scan,
        RelNode result = runPlanner(buildSortPlusLimit(), multiShardContext());
    public void testSortPlusLimit_1shard() {
                    OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])
    }
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rel.OpenSearchSort}.
            """
        );
 *
                OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode innerSort = LogicalSort.create(
        assertPlanShape(
    }
                OpenSearchSort(sort0=[$0], dir0=[DESC], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
                """,
/*
    @AwaitsFix(bugUrl = "Optimization: collated Sort over 1-shard SHARD+SINGLETON should stay at shard.")
                  OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
    }
     * 1-shard collated Sort: data already lives on one node, so an ideal planner would
        RelNode result = runPlanner(plan, multiShardContext());
                    OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
        RelNode plan = makeLimit(scan, 10);
        return makeLimit(innerSort, 10);
            null
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
import org.apache.calcite.rel.RelNode;
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            result
        // sort -status — DESC NULLS LAST is Calcite's default for DESC.
    public void testCollatedSort_2shard_descending() {
public class SortPlanShapeTests extends PlanShapeTestBase {
        assertPlanShape(
                """,
                    OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.RelCollations;
 *       fetch is correct. ER goes above the Sort to gather to coord.</li>
