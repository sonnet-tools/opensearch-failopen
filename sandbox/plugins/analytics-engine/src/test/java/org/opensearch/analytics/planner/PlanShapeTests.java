        RexNode ab = rexBuilder.makeCall(
                  OpenSearchProject(name=[$0], score=[$1], viableBackends=[[mock-parquet]])
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        assertPlanShape(
    /**
        // Field trimming adds Project(status) above the shard scan — count-by-key needs only the group key.
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 1));  
            stubScan(mockTable(table, "status", "size")),  
                """,  
    // testLimitAfterScan_multiShard_noForceSingleton + _singleShard_noTopER removed —
            SqlStdOperatorTable.SUM,  
        return LogicalSort.create(  
            null,
     *  
        RelNode result = runPlanner(plan, perIndexContext(Map.of("left_idx", 2, "right_idx", 2)));
            stubScan(mockTable(table, "status", "size")),
            result  
    /**
public class PlanShapeTests extends PlanShapeTestBase {
    /**
 * SPDX-License-Identifier: Apache-2.0
                  OpenSearchProject(k=[$1], cnt=[$0], viableBackends=[[mock-parquet]])  
     *   └── OpenSearchAggregate(FINAL)  
    public void testUnion_twoArmsWithStats_multiShard() {  
     * ER lands in the same RelSet as the FINAL and is redundant. Each Union input is the  
import org.apache.calcite.rel.logical.LogicalProject;
            """
        );
        // in real PPL sees (cnt=$0, k=$1) due to a prior swap. Mimic that by adding swaps both sides.
                OpenSearchJoin(condition=[=($0, $4)], joinType=[inner], viableBackends=[[mock-parquet]])
            null,
        RelNode result = runPlanner(plan, perIndexContext(Map.of("left_idx", 2, "right_idx", 2)));
     * inputs end up gathered exactly once.
 *
        );
            innerSortOverSwap,
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        return AggregateCall.create(
     * (one per branch's PARTIAL→FINAL).
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        // Left: stats sum(size) by status (group=0, aggregation output INTEGER)  
import org.apache.calcite.rel.logical.LogicalUnion;
        // To produce that, add a swap project BELOW the inner sort too.
            SqlStdOperatorTable.EQUALS,
            List.of(),
            null,
            """  
     * Join gathers each side to coord; Sort over the Join output stays at coord (Join  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        assertPlanShape("""
        RexNode cond = rexBuilder.makeCall(
            rexBuilder.makeLiteral(2, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     *  
 * The OpenSearch Contributors require contributions made to  
                """,  
            """
                  OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])  
        RexNode abc = rexBuilder.makeCall(
            List.of(),
     *
        // But the BasePlannerRulesTests' makeSort hardcodes field 0. Use a custom builder.
     * sort runs over the already-tiny grouped output (verified end-to-end by {@code
            input,
                        OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
        return LogicalJoin.create(leftAgg, rightAgg, List.of(), cond, Set.of(), JoinRelType.INNER);
            List.of("k", "cnt")
        // (status, cnt). After join the output has 4 columns; condition references left.$0 and
        );
import java.util.List;  
    private RelNode buildJoinOfTwoScans(String leftTable, String rightTable) {
                  OpenSearchProject(k=[$1], cnt=[$0], viableBackends=[[mock-parquet]])
            RelCollations.of(new RelFieldCollation(outerSortField, RelFieldCollation.Direction.ASCENDING)),
     * </pre>
     * </pre>
     * redundant ER: the join delivers SINGLETON directly.
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
    /**  
        // Project(k=$1, cnt=$0) over an input whose output is (cnt=$0, k=$1).
        RelNode result = runPlanner(plan, perIndexContext(Map.of("a", 2, "b", 2, "c", 2)));
        );
        return LogicalUnion.create(List.of(arm1, arm2), /* all */ true);
    }  
     */
    /**
     * Each side of the join pre-aggregates with {@code count()} before the join. The planner
    public void testSortThenProjectThenLimit_multiShard() {
                      OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
            """  
     * Without the redundant outer Sort the planner must NOT drop the inner Sort+fetch — the
                    OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[2], viableBackends=[[mock-parquet]])  
     * LogicalSort(sort0=$outerSortField)?              -- outer "sort cnt", optional
            null  
        RexNode cond = rexBuilder.makeCall(
     * fetch is the only thing preserving top-K semantics.  
        // Both sides scan the same 1-shard index → co-location fast path even though the  
            agg,  
        }  
        // Simpler: just use the swap that mirrors the After-CBO plan we observed:  
    private AggregateCall sumCallOn(RelNode input, int sumField) {
 * operator boundaries matters most.  
     * already delivers SINGLETON). No extra ER between Join and Sort.
     *   │     └── OpenSearchExchangeReducer  
    /**
            null,
                            OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        );
     */
            join,  
                      OpenSearchAggregate(group=[{0}], s=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])  
            List.of(countStarCall())
/*  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
            result
            OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])  
        // Inner sort by cnt ($0 below swap), outer sort by k ($0 above swap which maps to k).
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])  
 */  
            List.of(rexBuilder.makeInputRef(agg, 1), rexBuilder.makeInputRef(agg, 0)),  
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     *       LogicalAggregate(group=[{0}], cnt=COUNT()) -- "stats count() by k"
            innerSwap,
    // testUnion_twoArmsDifferentIndices_* removed — covered by UnionPlanShapeTests
        assertPlanShape(  
 * this file be licensed under the Apache-2.0 license or a
    /**
                            OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        RelNode input = topKAfterStats(/* withRedundantOuterSort */ false);  
            result
        RelNode plan = LogicalSort.create(
    // (testUnion_sameTable_2shard, testUnion_sameTable_1shard).  
        RelNode innerSortOverSwap = LogicalSort.create(  
                AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(1), -1, join, intType, "sum_left_size"),
            Set<org.opensearch.analytics.spi.EngineCapability> caps = new java.util.HashSet<>(super.supportedEngineCapabilities());
        // (locality-agnostic SINGLETON) is satisfied directly — no top ER.
        assertPlanShape(  
        // Field trimming adds Project(status) above the shard scan — count-by-key needs only the group key.
        RelNode rightScan = stubScan(table);
    }
        RelNode leftAgg = org.apache.calcite.rel.logical.LogicalAggregate.create(
import org.apache.calcite.plan.RelOptTable;
        RelNode plan = buildJoinWithDifferentGroupKeys();  
        assertPlanShape(
     * plus an inner Sort with fetch above a column-swap Project above the Aggregate. Both Sorts
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.ASCENDING)),
                  OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])  
     * at coord over the unioned result. No extra ER between Union and Sort.  
            project,
            org.apache.calcite.util.ImmutableBitSet.of(0),
    public void testJoinWithAggregate_erBetweenPartialAndFinal_noExtraErAboveFinal() {  
    // ── builders ───────────────────────────────────────────────────────────────  
                """,
        RelOptTable c = mockTable("c", "status", "size");  
     * Each Join input is gathered via per-side ER, the Join runs at coord, then a SINGLE  
                        OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])  
        RelNode innerSort = LogicalSort.create(
        RelNode rightAgg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), countStarCall());
     */  
        // Match PPL output: (cnt=cnt, k=k) reorder. Actually PPL's "fields k, cnt" produces output
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        RelNode result = runPlanner(plan, singleShardContext());
                OpenSearchSort(fetch=[3], viableBackends=[[mock-parquet]])  
    private RelNode buildUnionOfTwoStatsArms(String table) {
import org.apache.calcite.rel.core.JoinRelType;  
        RelNode join = LogicalJoin.create(leftAgg, rightAgg, List.of(), condition, Set.of(), JoinRelType.INNER);
                      OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])  
    }  
     * OpenSearchJoin(INNER, $0 = $2)           ← stamped SINGLETON by JoinSplitRule
        RelOptTable table = mockTable(  
     * <pre>  
        RelNode arm2 = org.apache.calcite.rel.logical.LogicalAggregate.create(  
    public void testJoinWithDifferentGroupKeys_multiShard() {
            List.of(),
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
 * {@link SortPlanShapeTests}, {@link AggregatePlanShapeTests},
        // root demand is satisfied by the SHARD+SINGLETON output of the Join — no top ER.
    }  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
            result
        );
        // adjacent for PROJECT_MERGE to collapse — both survive around the inner Sort.  
/**
        // Aggregate: group by column 0 (k), count as column 1 (cnt). Output: (k, cnt).
        assertPlanShape(
import org.apache.calcite.rex.RexNode;
                  OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])  
    private RelNode buildJoinWithDifferentGroupKeys() {
    // (testInnerJoin_mixedShards / _leftMulti_rightSingle / _differentTables_1shard).  
        );
        assertPlanShape(  
                        OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
        RelNode innerSwap = LogicalProject.create(  
            org.apache.calcite.util.ImmutableBitSet.of(1),
     *                     └── OpenSearchTableScan(test_index)  
                OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
                OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
        );  
        Map<String, Map<String, Object>> fields = Map.of("name", Map.of("type", "keyword"), "score", Map.of("type", "integer"));
        );
                countStarCall(),  
                        OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
    }
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
}
    }
     * splits each Aggregate into PARTIAL + FINAL with a gather between them. The join's
        );  
        );
            null,
        RelNode scan = stubScan(table);
        RelNode leftScan = stubScan(mockTable(leftTable, "status", "size"));  
     * (after remapping through the Project) must reject the drop.
                  OpenSearchAggregate(group=[{0}], s=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
                """,
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.logical.LogicalJoin;
              OpenSearchAggregate(group=[{0}], s=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
     * The Union-arm ER that OpenSearchUnionRule wrapped over the marked input gets deduped
     * Builds the Calcite tree the PPL frontend emits for
    }
            /* all */ true
        );  
import java.util.Map;
     * PPL: {@code stats count() by status | inner join ... [source=u | stats count() by size]}
import org.apache.calcite.rel.RelFieldCollation;  
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );  
            outerSwap,
        // Both arms scan the same 1-shard index → co-location fast path. Aggregates run at
                      OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
        // Join on left.$0 (status, INTEGER) == right.$0 (size, INTEGER).  
                """,
    public void testSortHeadAfterStats_outerSortPreserved() {  
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 3));
        // No SPT: the outer pure-LIMIT Sort stays above the identity Project (not lifted below it).  
            union,
                            OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
        RelNode leftScan = stubScan(table);
     * PPL: {@code source=t | sort score | fields name, score | head 3}
     * Union → Sort (multi-shard, same table). Union gathers each arm to coord; Sort runs
 * <p>This file covers <em>multi-operator pipelines</em> — the interesting interactions
     */  
                """,
                                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        );  
    public void testSortHeadAfterStats_singleSortFetchPreserved() {
     */
    }  
            OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])  
        );
        RelNode result = runPlanner(input, multiShardContext());
        RelNode union = buildUnionOfTwoStatsArms("test_index");
     * <p>The PPL frontend emits a redundant outer Sort (no fetch, same collation as the inner)
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        // Field trimming adds Project(status) above each shard scan — count-by-key needs only the group key.
        assertPlanShape(
            result
        PlannerContext context = multiShardContext();
                OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
        // Wait — agg's output is (k=$0, cnt=$1). We want to sort by cnt, so sort field = 1.  
     * through a nested Join doesn't degenerate (e.g. duplicate ERs) and that all three  
        RelNode join = buildJoinOfTwoScans("left_idx", "right_idx");
        // After Project (k=$0, cnt=$1) — identity. But the real PPL plan has a SWAP — the inner sort  
            List.of(),
        // the shard (no PARTIAL/FINAL split needed at 1 shard), Union runs there. Root demand  
                OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
    // testUnion_twoArmScans_* removed — covered by UnionPlanShapeTests
     * Each arm has stats — arm-level aggregate split produces FINAL at EXECUTION(SINGLETON).  
    /** Inner equi-join {@code left.$0 = right.$0} on two bare scans. */
                      OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
     *         └── OpenSearchExchangeReducer
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),  
     * does not register.
     * redundant — dropping it would change result ordering. The rule's collation comparison
        RelNode leftAgg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), countStarCall());  
                      OpenSearchProject(cnt=[$1], k=[$0], viableBackends=[[mock-parquet]])
     * aggregate runs above it (no PARTIAL/FINAL split — the Join's output is already
        RexNode condition = rexBuilder.makeCall(  
    // ── Downstream-of-Join / Union combinations ──────────────────────────────
            SqlStdOperatorTable.EQUALS,
            List.of(),
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
     * MockDataFusionBackend with EngineCapability.UNION declared.  
     * Join → Aggregate (multi-shard, different tables). Common PPL shape:
    public void testSortHeadAfterStats_outerSortWithDifferentKeyKept() {
     */  
    /**  
     * Sort (no collation) sits at the top; its input is already SINGLETON, so no additional ER.
        RelNode plan = LogicalJoin.create(abJoin, cScan, List.of(), abc, Set.of(), JoinRelType.INNER);  
 * compatible open source license.
    // testPureScan_multiShard_rootER + _singleShard_noTopER removed —
                OpenSearchProject(k=[$1], cnt=[$0], viableBackends=[[mock-parquet]])
    }  
            null,
        RelNode outerSwap = LogicalProject.create(  
            SqlStdOperatorTable.EQUALS,
        RelNode union = LogicalUnion.create(  
    public void testJoinWithDifferentGroupKeys_singleShard() {
                      OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
                      OpenSearchProject(cnt=[$1], k=[$0], viableBackends=[[mock-parquet]])
        RelNode bScan = stubScan(b);
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }  
        // adjacent for PROJECT_MERGE to collapse — both survive around the inner Sort.  
            """
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
        RelOptTable table = mockTable("test_index", "status", "size");
    // ── Multi-operator pipelines below ────────────────────────────────────
        RelNode limit = LogicalSort.create(
        RelNode plan = org.apache.calcite.rel.logical.LogicalAggregate.create(  
        RelNode project = LogicalProject.create(
import java.util.Set;
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
     * are preserved through to the physical plan — {@link  
     * {@link org.opensearch.analytics.planner.rules.OpenSearchSortSplitRule} — concat gather
            result  
        assertPlanShape(
            List.of(sumField),
     *               └── OpenSearchAggregate(PARTIAL)
     *         StubTableScan  
            "test_index",
                """,
        RelNode plan = buildJoinWithDifferentGroupKeys();
     * longer drops the redundant outer Sort. The extra (collation-only) outer Sort over the FINAL
            null
            """  
            List.of(),
        // Right: stats sum(status) by size (group=1, aggregation output INTEGER — different group key)  
            null,  
                      OpenSearchTableScan(table=[[a]], viableBackends=[[mock-parquet]])
        RelNode innerSort = LogicalSort.create(
        );  
     * can't preserve global order. A narrowing Project over that Sort preserves the SINGLETON  
                  OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[2], viableBackends=[[mock-parquet]])
     *   ├── OpenSearchAggregate(FINAL)
            """, result);
    public void testJoinThenAggregate_2shard() {
            scan,  
     * {@code convert(input, SINGLETON)} is a no-op because each FINAL already delivers  
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], sum_left_size=[SUM($1)], sum_right_size=[SUM($3)], mode=[SINGLE], viableBackends=[[mock-parquet]])
            org.apache.calcite.util.ImmutableBitSet.of(0),  
                AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(3), -1, join, intType, "sum_right_size")
        RelNode rightAgg = org.apache.calcite.rel.logical.LogicalAggregate.create(
    // covered by SortPlanShapeTests.testPureLimit_2shard / _1shard.
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            result
                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        if (!withRedundantOuterSort) {
        );  
            -1,  
    }
        );
        return buildContextPerIndex("parquet", Map.of(indexName, shardCount), intFields(), List.of(new UnionCapableBackend(), LUCENE));
        );
        RelOptTable a = mockTable("a", "status", "size");
     * Chained inner join: {@code (a ⨝ b) ⨝ c}. Nested join: each leaf Join input has its
    // (testUnion_differentTables_1shard / _2shard).
import org.apache.calcite.rel.logical.LogicalSort;  
    }
package org.opensearch.analytics.planner;
        );
        RelNode arm1 = org.apache.calcite.rel.logical.LogicalAggregate.create(
        RelNode rightScan = stubScan(mockTable(rightTable, "status", "size"));
        }
              OpenSearchAggregate(group=[{1}], s=[SUM($0)], mode=[SINGLE], viableBackends=[[mock-parquet]])  
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
        // path (single-input passthrough) between the inner Sort and the outer LIMIT.
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode abJoin = LogicalJoin.create(aScan, bScan, List.of(), ab, Set.of(), JoinRelType.INNER);  
            join,
                    OpenSearchProject(cnt=[$1], k=[$0], viableBackends=[[mock-parquet]])  
     * own per-side ER, the outer Join also has per-side ERs. Verifies trait propagation
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
        // No SPT to lift the inner Project above the Sort, so the swap-Projects never become
            """
            List.of(rexBuilder.makeInputRef(innerSort, 0), rexBuilder.makeInputRef(innerSort, 1)),
    public void testUnionThenSort_2shard() {
     */
        assertPlanShape(  
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.ASCENDING)),
     * Planner context with UNION engine capability declared, for a single index.
                      OpenSearchAggregate(group=[{1}], s=[SUM($0)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
                """,  
              OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                          OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
     * org.opensearch.analytics.planner.rules.OpenSearchSortRule} converts each one-for-one and no
     * <p>Inner collated Sort (by score) forces {@code Sort ← ER ← Scan} via
    // testJoinMixedShards_* removed — covered by JoinPlanShapeTests
            rightScan,  
     */
            List.of(),
    }
            innerSort,  
     * HeadAfterStatsLimitIT} / {@code TwoShardAggregationIT#span_topn}). Collapsing it would require
        RelNode agg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), countCall);  
                  OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
     */  
            org.apache.calcite.util.ImmutableBitSet.of(0),
            List.of("cnt", "k")
     * PPL: {@code | stats count() as cnt by k | sort cnt | head 2 | fields k, cnt}
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),  
                          OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            "s"  
            """, result);
        AggregateCall countCall = countStarCall();
        // right.$0 (offset by left fieldCount=2).
    public void testUnion_twoArmsWithStats_singleShard() {
        RelNode result = runPlanner(input, multiShardContext());
                    OpenSearchSort(sort0=[$1], dir0=[ASC], viableBackends=[[mock-parquet]])
 */
            typeFactory.createSqlType(SqlTypeName.INTEGER),
        // Arbitrary equi-condition; we only care about plan shape, not join semantics.
                              OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
        );
     *   │           └── OpenSearchAggregate(PARTIAL)
                      OpenSearchTableScan(table=[[b]], viableBackends=[[mock-parquet]])  
                      OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            """
     * coord-local SINGLETON, no shuffle to split across).
                          OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])  
 * Combinations file. Per-operator plan shapes live in dedicated files:
                    OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[2], viableBackends=[[mock-parquet]])
     * Two aggregates with different group keys, joined on some key. Both FINALs deliver SINGLETON;  
        // No SPT to lift the inner Project above the Sort, so the swap-Projects never become
        RelNode result = runPlanner(join, context);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)  
        assertPlanShape(
            caps.add(org.opensearch.analytics.spi.EngineCapability.UNION);  
            null,  
        RelNode result = runPlanner(limit, buildContext("parquet", 3, fields));
        );  
        org.apache.calcite.rel.type.RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        // Inner Sort+fetch: sort by cnt ($1 in agg's output: column 1).
    }
import org.apache.calcite.rel.RelCollations;
            List.of(countStarCall())
        RelNode result = runPlanner(input, multiShardContext());
            rexBuilder.makeLiteral(3, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
     *     LogicalSort(sort0=$0, fetch=2)               -- "sort cnt | head 2"
                  OpenSearchAggregate(group=[{0}], s=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
                  OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
        );
        // Field trimming adds Project(status) above the shard scan — count-by-key needs only the group key.
     */
        // Field trimming adds Project(status) above each arm's scan — count-by-key needs only the group key.
            List.of(
    }
    }
            List.of("name", "score")  
        );
        // Outer LIMIT (fetch=3, no collation).  
                OpenSearchSort(sort0=[$1], dir0=[ASC], viableBackends=[[mock-parquet]])
            null  
 * {@link JoinPlanShapeTests}, {@link UnionPlanShapeTests}.
     *
            result
        );
     *   │                 └── OpenSearchTableScan(test_index)
        RelOptTable b = mockTable("b", "status", "size");
        RelNode join = buildJoinOfTwoScans("left_idx", "right_idx");
     */
            null,  
        //
    /**  
              OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     * Join → Sort (multi-shard, different tables). PPL: {@code | join b | sort x}.
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])  
                                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     */
    // ── Union builders / contexts ─────────────────────────────────────────────
    public void testJoinThenSort_2shard() {  
     * by Volcano because FINAL already delivers EXECUTION(SINGLETON) — the ConverterImpl
            SqlStdOperatorTable.EQUALS,  
        assertPlanShape("""
     *  
import org.apache.calcite.rel.RelNode;
     * {@code | stats count() as cnt by k | sort cnt | head 2 | fields k, cnt}:
        RelNode plan = LogicalSort.create(
    private static final class UnionCapableBackend extends MockDataFusionBackend {
                """,
     * <pre>
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])  
import org.apache.calcite.rel.core.AggregateCall;
                OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
            return outerSwap;
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                        OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
        protected Set<org.opensearch.analytics.spi.EngineCapability> supportedEngineCapabilities() {
        return LogicalJoin.create(leftScan, rightScan, List.of(), cond, Set.of(), JoinRelType.INNER);
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        assertPlanShape(
            return caps;
        // Field trimming adds Project(status) above each arm's scan — count-by-key needs only the group key.  
            leftScan,  
        );
 * (filter+stats+sort, join over aggregates, etc.) where trait propagation across
        // adjacent for PROJECT_MERGE to collapse — both survive around the inner Sort.
     * JoinSplit's convert() is a no-op per side; no extra ER above either FINAL. Total ERs: 2
    private PlannerContext unionContextSingleIndex(String indexName, int shardCount) {
        // (k, cnt). Inner sort's output is still (k=$0, cnt=$1) because Sort doesn't change schema.
            null,  
    }
    /**
     * If the outer Sort sorts by a DIFFERENT key than the inner Sort+fetch, the outer is NOT  
        return topKAfterStats(withRedundantOuterSort, /* outerSortField */ 1);  
            SqlStdOperatorTable.EQUALS,  
                    OpenSearchTableScan(table=[[c]], viableBackends=[[mock-parquet]])
        @Override  
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        RelNode cScan = stubScan(c);  
    /**
        // Consume left.size ($1) and right.size ($3) so neither join arm is trimmed below  
     * SINGLETON — no extra ER wraps the FINAL on either side.
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            List.of(sumCallOn(leftScan, /* sumField */ 1))
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 4)
            """  
 *  
                      OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
     * an active {@code RelCollationTraitDef} ({@code CoreRules.SORT_REMOVE}), which this planner  
    private RelNode topKAfterStats(boolean withRedundantOuterSort, int outerSortField) {  
            List.of(rexBuilder.makeInputRef(innerSortOverSwap, 1), rexBuilder.makeInputRef(innerSortOverSwap, 0)),  
                """,
    // ── Logical-plan builders ────────────────────────────────────────────────
            result  
            """
                      OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
        );
    }  
     * FINAL directly.
        // Outer Sort: collation field = `outerSortField` ($1 = cnt for redundant, $0 = k for non-redundant).
        // group keys differ. Aggregates run at the shard, Join runs there. Locality-agnostic
            org.apache.calcite.util.ImmutableBitSet.of(0),  
    private RelNode topKAfterStats(boolean withRedundantOuterSort) {
            false,
    /**
                              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
            result  
    }
     */  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            result  
    }  
        // Inner Sort: ORDER BY score (field 1).
            null,
        RelNode result = runPlanner(plan, multiShardContext());  
    }
    // covered by ScanPlanShapeTests.testBareScan_2shard / _1shard.
        );  
            null,  
 * {@link ScanPlanShapeTests}, {@link FilterPlanShapeTests}, {@link ProjectPlanShapeTests},  
    /**  
        RelNode input = topKAfterStats(/* withRedundantOuterSort */ true, /* outerSortField */ 0);  
    /**
        );
        );
            agg,
     * input (project is single-input, passthrough-marked, no ER required). Outer pure-LIMIT
            List.of(),
     * {@code source=a | inner join b ON ... | stats count() by k}.
            )  
     *   LogicalProject(k=$1, cnt=$0)                   -- "fields k, cnt" (swap)  
        RelNode result = runPlanner(plan, unionContextSingleIndex("test_index", 2));
    }
        );
        );
    public void testChainedJoin_2shard() {  
                  OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
                              OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
            List.of(sumCallOn(rightScan, /* sumField */ 0))
        // Project: name ($0), score ($1) — identity here but exercises the OpenSearchProjectRule  
     * Aggregate is harmless: the inner Sort carries the fetch, so top-K is exact, and the duplicate  
        // Equi-join on grouping key ($0 on each side). Left rowType is (status, cnt); right is  
        RelNode union = buildUnionOfTwoStatsArms("test_index");
        RelNode input = topKAfterStats(/* withRedundantOuterSort */ true);
        // No SPT to lift the inner Project above the Sort, so the swap-Projects never become  
                        OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])  
            rexBuilder.makeLiteral(2, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
                  OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
            """
        );
            null
        // Project that swaps to (k=$1 from cnt-after-sort wait no — keep original schema).  
            RelCollations.EMPTY,  
import org.apache.calcite.sql.type.SqlTypeName;
    // Plan-shape and structural-pipeline assertions are inherited from PlanShapeTestBase.
     * <p>Exactly two ERs — one between PARTIAL and FINAL on each branch. No top-level  
        // [status, size]; keeps the join condition at =($0, $2) instead of reindexing.
                  OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
            new String[] { "name", "score" },
        RelNode aScan = stubScan(a);
                """,
     */
                      OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
