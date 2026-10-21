        );
    }
              OpenSearchAggregate(group=[{1}], s=[SUM($0)], mode=[SINGLE], viableBackends=[[mock-parquet]])
    }
        // the shard (no PARTIAL/FINAL split needed at 1 shard), Union runs there. Root demand
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            List.of(),
     */
     */
     *
            List.of(),
public class PlanShapeTests extends PlanShapeTestBase {
        // Match PPL output: (cnt=cnt, k=k) reorder. Actually PPL's "fields k, cnt" produces output
     * (one per branch's PARTIAL→FINAL).
     * Join → Aggregate (multi-shard, different tables). Common PPL shape:
        return topKAfterStats(withRedundantOuterSort, /* outerSortField */ 1);
        RelNode agg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), countCall);
        );
        RelNode result = runPlanner(plan, perIndexContext(Map.of("left_idx", 2, "right_idx", 2)));
     * longer drops the redundant outer Sort. The extra (collation-only) outer Sort over the FINAL
        RelNode bScan = stubScan(b);
                  OpenSearchAggregate(group=[{0}], s=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
            join,
            input,
import org.apache.calcite.rel.RelFieldCollation;
                """,
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
        );
     *                     └── OpenSearchTableScan(test_index)
            RelCollations.of(new RelFieldCollation(outerSortField, RelFieldCollation.Direction.ASCENDING)),
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                """,
                OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.ASCENDING)),
            scan,
     * </pre>
     */
    public void testUnion_twoArmsWithStats_multiShard() {
                """,
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
        return LogicalJoin.create(leftScan, rightScan, List.of(), cond, Set.of(), JoinRelType.INNER);
        RelNode innerSortOverSwap = LogicalSort.create(
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
        RelNode leftScan = stubScan(mockTable(leftTable, "status", "size"));
                OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
     * Planner context with UNION engine capability declared, for a single index.
                  OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[2], viableBackends=[[mock-parquet]])
    // (testUnion_differentTables_1shard / _2shard).
     * HeadAfterStatsLimitIT} / {@code TwoShardAggregationIT#span_topn}). Collapsing it would require
        // Consume left.size ($1) and right.size ($3) so neither join arm is trimmed below
        );
                      OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            result
     * coord-local SINGLETON, no shuffle to split across).
     */
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     * org.opensearch.analytics.planner.rules.OpenSearchSortRule} converts each one-for-one and no
            """, result);
            """
                """,
            join,
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 1));
    /**
    /**
            "s"
     * Join → Sort (multi-shard, different tables). PPL: {@code | join b | sort x}.
        );
        assertPlanShape(
            )
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                      OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
        );
            null,
    // covered by SortPlanShapeTests.testPureLimit_2shard / _1shard.
            null,
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        // (k, cnt). Inner sort's output is still (k=$0, cnt=$1) because Sort doesn't change schema.
        RelNode plan = LogicalSort.create(
            """
    /**
        // Both sides scan the same 1-shard index → co-location fast path even though the
        // Join on left.$0 (status, INTEGER) == right.$0 (size, INTEGER).
        RelNode result = runPlanner(input, multiShardContext());
        RexNode condition = rexBuilder.makeCall(
            result
                      OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        RelNode rightScan = stubScan(mockTable(rightTable, "status", "size"));
     *   │                 └── OpenSearchTableScan(test_index)
        assertPlanShape(
     * LogicalSort(sort0=$outerSortField)?              -- outer "sort cnt", optional
              OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
            rightScan,
                    OpenSearchTableScan(table=[[c]], viableBackends=[[mock-parquet]])
        return LogicalSort.create(
     * PPL: {@code | stats count() as cnt by k | sort cnt | head 2 | fields k, cnt}
 * Combinations file. Per-operator plan shapes live in dedicated files:
            result
        // adjacent for PROJECT_MERGE to collapse — both survive around the inner Sort.
            SqlStdOperatorTable.EQUALS,
        RelNode leftAgg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), countStarCall());
     * Union → Sort (multi-shard, same table). Union gathers each arm to coord; Sort runs
        RelNode result = runPlanner(plan, unionContextSingleIndex("test_index", 2));
        AggregateCall countCall = countStarCall();
                    OpenSearchProject(cnt=[$1], k=[$0], viableBackends=[[mock-parquet]])
 * compatible open source license.
     * </pre>
                        OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
     * ER lands in the same RelSet as the FINAL and is redundant. Each Union input is the
        // Outer Sort: collation field = `outerSortField` ($1 = cnt for redundant, $0 = k for non-redundant).
            return caps;
            caps.add(org.opensearch.analytics.spi.EngineCapability.UNION);
                """,
        RelNode result = runPlanner(plan, singleShardContext());
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
        );
import java.util.List;
     * {@code source=a | inner join b ON ... | stats count() by k}.
        RelNode innerSort = LogicalSort.create(
    /**
            """
        RexNode abc = rexBuilder.makeCall(
import org.apache.calcite.plan.RelOptTable;
            OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(input, multiShardContext());
            """
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(limit, buildContext("parquet", 3, fields));
     *               └── OpenSearchAggregate(PARTIAL)
 * {@link JoinPlanShapeTests}, {@link UnionPlanShapeTests}.
        );
            result
     * by Volcano because FINAL already delivers EXECUTION(SINGLETON) — the ConverterImpl
        );
     * does not register.
                """,
            null,
        // Inner sort by cnt ($0 below swap), outer sort by k ($0 above swap which maps to k).
    }
     * SINGLETON — no extra ER wraps the FINAL on either side.
}
            result
        );
     * splits each Aggregate into PARTIAL + FINAL with a gather between them. The join's
            new String[] { "name", "score" },
     * {@code | stats count() as cnt by k | sort cnt | head 2 | fields k, cnt}:
     */
            SqlStdOperatorTable.EQUALS,
     * Aggregate is harmless: the inner Sort carries the fetch, so top-K is exact, and the duplicate
     * <pre>
        RelNode cScan = stubScan(c);
     *   │           └── OpenSearchAggregate(PARTIAL)
    private RelNode topKAfterStats(boolean withRedundantOuterSort, int outerSortField) {
                      OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
     *
                      OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
    public void testJoinWithDifferentGroupKeys_multiShard() {
                      OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            null,
        );
            """
    /**
     * <p>Exactly two ERs — one between PARTIAL and FINAL on each branch. No top-level
        RelNode input = topKAfterStats(/* withRedundantOuterSort */ true);
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
        RelNode result = runPlanner(input, multiShardContext());
        RelNode plan = LogicalJoin.create(abJoin, cScan, List.of(), abc, Set.of(), JoinRelType.INNER);
    private RelNode buildUnionOfTwoStatsArms(String table) {
        );
            List.of(),
    public void testChainedJoin_2shard() {
    /**
        return LogicalUnion.create(List.of(arm1, arm2), /* all */ true);
    public void testJoinThenAggregate_2shard() {
                        OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        // Project that swaps to (k=$1 from cnt-after-sort wait no — keep original schema).
            innerSortOverSwap,
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
            rexBuilder.makeLiteral(3, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    // Plan-shape and structural-pipeline assertions are inherited from PlanShapeTestBase.
                      OpenSearchAggregate(group=[{1}], s=[SUM($0)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                      OpenSearchTableScan(table=[[b]], viableBackends=[[mock-parquet]])
import org.apache.calcite.sql.type.SqlTypeName;
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     *   │     └── OpenSearchExchangeReducer
    }
        RelNode leftAgg = org.apache.calcite.rel.logical.LogicalAggregate.create(
            List.of(),
    }
     *   └── OpenSearchAggregate(FINAL)
    }
        // right.$0 (offset by left fieldCount=2).
    private AggregateCall sumCallOn(RelNode input, int sumField) {
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
            List.of(countStarCall())
     * Each side of the join pre-aggregates with {@code count()} before the join. The planner
        assertPlanShape(
     * own per-side ER, the outer Join also has per-side ERs. Verifies trait propagation
                  OpenSearchProject(k=[$1], cnt=[$0], viableBackends=[[mock-parquet]])
     *
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
    /**
        RelNode join = buildJoinOfTwoScans("left_idx", "right_idx");
        RexNode ab = rexBuilder.makeCall(
        // After Project (k=$0, cnt=$1) — identity. But the real PPL plan has a SWAP — the inner sort
    // ── Logical-plan builders ────────────────────────────────────────────────
        );
    // ── Multi-operator pipelines below ────────────────────────────────────
                                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     * aggregate runs above it (no PARTIAL/FINAL split — the Join's output is already
    public void testSortHeadAfterStats_singleSortFetchPreserved() {
                            OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
            project,
    }
            typeFactory.createSqlType(SqlTypeName.INTEGER),
            false,
    }
            org.apache.calcite.util.ImmutableBitSet.of(1),
                OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.core.JoinRelType;
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     * Each arm has stats — arm-level aggregate split produces FINAL at EXECUTION(SINGLETON).
                """,
            """
        RelNode plan = LogicalSort.create(
            SqlStdOperatorTable.EQUALS,
            org.apache.calcite.util.ImmutableBitSet.of(0),
            List.of(countStarCall())
                OpenSearchJoin(condition=[=($0, $4)], joinType=[inner], viableBackends=[[mock-parquet]])
        );
                      OpenSearchProject(cnt=[$1], k=[$0], viableBackends=[[mock-parquet]])
        // Wait — agg's output is (k=$0, cnt=$1). We want to sort by cnt, so sort field = 1.
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        // in real PPL sees (cnt=$0, k=$1) due to a prior swap. Mimic that by adding swaps both sides.
        RelNode union = buildUnionOfTwoStatsArms("test_index");
    }
                        OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
            null
     *
        RelNode leftScan = stubScan(table);
            List.of(rexBuilder.makeInputRef(agg, 1), rexBuilder.makeInputRef(agg, 0)),
            List.of(rexBuilder.makeInputRef(innerSort, 0), rexBuilder.makeInputRef(innerSort, 1)),
    // covered by ScanPlanShapeTests.testBareScan_2shard / _1shard.
     * are preserved through to the physical plan — {@link
        // adjacent for PROJECT_MERGE to collapse — both survive around the inner Sort.
            result
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                    OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[2], viableBackends=[[mock-parquet]])
        RelOptTable c = mockTable("c", "status", "size");
        // No SPT: the outer pure-LIMIT Sort stays above the identity Project (not lifted below it).
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
 * {@link ScanPlanShapeTests}, {@link FilterPlanShapeTests}, {@link ProjectPlanShapeTests},
    // ── Downstream-of-Join / Union combinations ──────────────────────────────
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
        RelNode plan = buildJoinWithDifferentGroupKeys();
     * inputs end up gathered exactly once.
                  OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
                OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
                              OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
        RelOptTable b = mockTable("b", "status", "size");
        // No SPT to lift the inner Project above the Sort, so the swap-Projects never become
import org.apache.calcite.rel.logical.LogicalUnion;
     * input (project is single-input, passthrough-marked, no ER required). Outer pure-LIMIT
                        OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
                      OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
                  OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
     * <pre>
                """,
     * Builds the Calcite tree the PPL frontend emits for
 * <p>This file covers <em>multi-operator pipelines</em> — the interesting interactions
        // Project: name ($0), score ($1) — identity here but exercises the OpenSearchProjectRule
        RelNode limit = LogicalSort.create(
            result
            result
 * (filter+stats+sort, join over aggregates, etc.) where trait propagation across
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    }
     *         └── OpenSearchExchangeReducer
 * operator boundaries matters most.
                """,
     * at coord over the unioned result. No extra ER between Union and Sort.
    public void testSortHeadAfterStats_outerSortPreserved() {
        assertPlanShape(
        RelNode rightScan = stubScan(table);
              OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[SINGLE], viableBackends=[[mock-parquet]])
                AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(1), -1, join, intType, "sum_left_size"),
            null,
            List.of("k", "cnt")
     */
    // ── Union builders / contexts ─────────────────────────────────────────────
                              OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
                OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
        // (status, cnt). After join the output has 4 columns; condition references left.$0 and
        RelNode input = topKAfterStats(/* withRedundantOuterSort */ true, /* outerSortField */ 0);
        RelNode union = LogicalUnion.create(
 * The OpenSearch Contributors require contributions made to
        // Aggregate: group by column 0 (k), count as column 1 (cnt). Output: (k, cnt).
                        OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
    }
        RelNode innerSort = LogicalSort.create(
     * Two aggregates with different group keys, joined on some key. Both FINALs deliver SINGLETON;
        RelNode result = runPlanner(plan, perIndexContext(Map.of("left_idx", 2, "right_idx", 2)));
                  OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
            """
     * an active {@code RelCollationTraitDef} ({@code CoreRules.SORT_REMOVE}), which this planner
     * plus an inner Sort with fetch above a column-swap Project above the Aggregate. Both Sorts
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
import org.apache.calcite.rel.core.AggregateCall;
import org.apache.calcite.rel.RelCollations;
        RelNode union = buildUnionOfTwoStatsArms("test_index");
     */
            List.of("cnt", "k")
    /**
        RelNode result = runPlanner(union, unionContextSingleIndex("test_index", 3));
     * (after remapping through the Project) must reject the drop.
     * Chained inner join: {@code (a ⨝ b) ⨝ c}. Nested join: each leaf Join input has its
                OpenSearchAggregate(group=[{0}], cnt=[COUNT()], sum_left_size=[SUM($1)], sum_right_size=[SUM($3)], mode=[SINGLE], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(table);
        // Field trimming adds Project(status) above the shard scan — count-by-key needs only the group key.
        // Arbitrary equi-condition; we only care about plan shape, not join semantics.
                  OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
        );
        // Equi-join on grouping key ($0 on each side). Left rowType is (status, cnt); right is
    /**
        RelNode aScan = stubScan(a);
        RelOptTable table = mockTable("test_index", "status", "size");
                  OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                        OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
        // Left: stats sum(size) by status (group=0, aggregation output INTEGER)
            null,
                    OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[2], viableBackends=[[mock-parquet]])
                  OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
    // testUnion_twoArmsDifferentIndices_* removed — covered by UnionPlanShapeTests
        RelNode join = LogicalJoin.create(leftAgg, rightAgg, List.of(), condition, Set.of(), JoinRelType.INNER);
                  OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
            SqlStdOperatorTable.EQUALS,
        assertPlanShape(
            null
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
    /**
            List.of(sumField),
                """,
    }
                      OpenSearchTableScan(table=[[a]], viableBackends=[[mock-parquet]])
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
        RelNode project = LogicalProject.create(
     */
            innerSwap,
        @Override
            null,
        // Project(k=$1, cnt=$0) over an input whose output is (cnt=$0, k=$1).
     * The Union-arm ER that OpenSearchUnionRule wrapped over the marked input gets deduped
        return buildContextPerIndex("parquet", Map.of(indexName, shardCount), intFields(), List.of(new UnionCapableBackend(), LUCENE));
            stubScan(mockTable(table, "status", "size")),
        RelNode outerSwap = LogicalProject.create(
        // No SPT to lift the inner Project above the Sort, so the swap-Projects never become
        RexNode cond = rexBuilder.makeCall(
    private RelNode buildJoinOfTwoScans(String leftTable, String rightTable) {
    public void testSortThenProjectThenLimit_multiShard() {
 * SPDX-License-Identifier: Apache-2.0
    // testLimitAfterScan_multiShard_noForceSingleton + _singleShard_noTopER removed —
     * {@code convert(input, SINGLETON)} is a no-op because each FINAL already delivers
        assertPlanShape("""
     * redundant ER: the join delivers SINGLETON directly.
            leftScan,
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
        );
import org.apache.calcite.rel.logical.LogicalProject;
import java.util.Map;
            """
            List.of(sumCallOn(leftScan, /* sumField */ 1))
     * PPL: {@code source=t | sort score | fields name, score | head 3}
     */
        // Simpler: just use the swap that mirrors the After-CBO plan we observed:
        assertPlanShape(
                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                      OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
     * Each Join input is gathered via per-side ER, the Join runs at coord, then a SINGLE
            org.apache.calcite.util.ImmutableBitSet.of(0),
        RelNode result = runPlanner(plan, multiShardContext());
            List.of(rexBuilder.makeInputRef(innerSortOverSwap, 1), rexBuilder.makeInputRef(innerSortOverSwap, 0)),
    }
     *       LogicalAggregate(group=[{0}], cnt=COUNT()) -- "stats count() by k"
        // No SPT to lift the inner Project above the Sort, so the swap-Projects never become
            org.apache.calcite.util.ImmutableBitSet.of(0),
                AggregateCall.create(SqlStdOperatorTable.SUM, false, List.of(3), -1, join, intType, "sum_right_size")
     *     LogicalSort(sort0=$0, fetch=2)               -- "sort cnt | head 2"
     */
    }
     * Join gathers each side to coord; Sort over the Join output stays at coord (Join
            /* all */ true
        RelOptTable table = mockTable(
            List.of(),
 */
        return LogicalJoin.create(leftAgg, rightAgg, List.of(), cond, Set.of(), JoinRelType.INNER);
     * can't preserve global order. A narrowing Project over that Sort preserves the SINGLETON
            null,
        Map<String, Map<String, Object>> fields = Map.of("name", Map.of("type", "keyword"), "score", Map.of("type", "integer"));
                  OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
        }
        // Field trimming adds Project(status) above each arm's scan — count-by-key needs only the group key.
        // But the BasePlannerRulesTests' makeSort hardcodes field 0. Use a custom builder.
    public void testSortHeadAfterStats_outerSortWithDifferentKeyKept() {
    private PlannerContext unionContextSingleIndex(String indexName, int shardCount) {
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
import java.util.Set;
import org.apache.calcite.rel.RelNode;
            stubScan(mockTable(table, "status", "size")),
        RelNode arm1 = org.apache.calcite.rel.logical.LogicalAggregate.create(
            null,
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        // Field trimming adds Project(status) above the shard scan — count-by-key needs only the group key.
            List.of("name", "score")
            Set<org.opensearch.analytics.spi.EngineCapability> caps = new java.util.HashSet<>(super.supportedEngineCapabilities());
        );
    }
        );
        // Inner Sort+fetch: sort by cnt ($1 in agg's output: column 1).
                          OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
import org.apache.calcite.rex.RexNode;
        );
                    OpenSearchSort(sort0=[$1], dir0=[ASC], viableBackends=[[mock-parquet]])
                  OpenSearchProject(name=[$0], score=[$1], viableBackends=[[mock-parquet]])
                          OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        // Both arms scan the same 1-shard index → co-location fast path. Aggregates run at
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
     * fetch is the only thing preserving top-K semantics.
        );
    }
     *   ├── OpenSearchAggregate(FINAL)
    public void testJoinThenSort_2shard() {
            null,
        // Outer LIMIT (fetch=3, no collation).
     *   LogicalProject(k=$1, cnt=$0)                   -- "fields k, cnt" (swap)
            union,
    // (testInnerJoin_mixedShards / _leftMulti_rightSingle / _differentTables_1shard).
            List.of(),
    /**
     * Sort (no collation) sits at the top; its input is already SINGLETON, so no additional ER.
        // Field trimming adds Project(status) above each arm's scan — count-by-key needs only the group key.
    /**
        RelNode join = buildJoinOfTwoScans("left_idx", "right_idx");
            List.of(),
     * If the outer Sort sorts by a DIFFERENT key than the inner Sort+fetch, the outer is NOT
            """
                            OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
     */
        org.apache.calcite.rel.type.RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
     * redundant — dropping it would change result ordering. The rule's collation comparison
        //
            agg,
    }
        );
    private RelNode topKAfterStats(boolean withRedundantOuterSort) {
 *
                OpenSearchSort(sort0=[$1], dir0=[ASC], viableBackends=[[mock-parquet]])
        assertPlanShape(
        );
                OpenSearchJoin(condition=[=($0, $2)], joinType=[inner], viableBackends=[[mock-parquet]])
            null
        );
import org.apache.calcite.rel.logical.LogicalSort;
                  OpenSearchAggregate(group=[{0}], cnt=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
                  OpenSearchAggregate(group=[{0}], s=[SUM($1)], mode=[FINAL], viableBackends=[[mock-parquet]])
     * {@link org.opensearch.analytics.planner.rules.OpenSearchSortSplitRule} — concat gather
        // [status, size]; keeps the join condition at =($0, $2) instead of reindexing.
                      OpenSearchTableScan(table=[[right_idx]], viableBackends=[[mock-parquet]])
        RelOptTable a = mockTable("a", "status", "size");
    public void testJoinWithAggregate_erBetweenPartialAndFinal_noExtraErAboveFinal() {
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
    /**
    // testUnion_twoArmScans_* removed — covered by UnionPlanShapeTests
    private static final class UnionCapableBackend extends MockDataFusionBackend {
        RelNode result = runPlanner(join, context);
     * PPL: {@code stats count() by status | inner join ... [source=u | stats count() by size]}
            List.of(
                countStarCall(),
            """
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        // Inner Sort: ORDER BY score (field 1).
     */
            rexBuilder.makeLiteral(2, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            RelCollations.EMPTY,
                          OpenSearchAggregate(group=[{0}], cnt=[COUNT()], mode=[PARTIAL], viableBackends=[[mock-parquet]])
/*
     * sort runs over the already-tiny grouped output (verified end-to-end by {@code
     * Without the redundant outer Sort the planner must NOT drop the inner Sort+fetch — the
                OpenSearchProject(k=[$1], cnt=[$0], viableBackends=[[mock-parquet]])
    public void testUnionThenSort_2shard() {
            SqlStdOperatorTable.SUM,
        );
            SqlStdOperatorTable.EQUALS,
                                OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
                      OpenSearchProject(cnt=[$1], k=[$0], viableBackends=[[mock-parquet]])
    // (testUnion_sameTable_2shard, testUnion_sameTable_1shard).
                        OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
 * {@link SortPlanShapeTests}, {@link AggregatePlanShapeTests},
            result
        RelNode plan = buildJoinWithDifferentGroupKeys();
                      OpenSearchAggregate(group=[{0}], s=[SUM($1)], mode=[PARTIAL], viableBackends=[[mock-parquet]])
                OpenSearchSort(fetch=[3], viableBackends=[[mock-parquet]])
            List.of(),
package org.opensearch.analytics.planner;
        // Field trimming adds Project(status) above each shard scan — count-by-key needs only the group key.
     * FINAL directly.
        );
    // testJoinMixedShards_* removed — covered by JoinPlanShapeTests
        );
            RelCollations.of(new RelFieldCollation(1, RelFieldCollation.Direction.ASCENDING)),
        RelNode rightAgg = org.apache.calcite.rel.logical.LogicalAggregate.create(
    public void testJoinWithDifferentGroupKeys_singleShard() {
            """, result);
        // To produce that, add a swap project BELOW the inner sort too.
        RelNode arm2 = org.apache.calcite.rel.logical.LogicalAggregate.create(
            null
    public void testUnion_twoArmsWithStats_singleShard() {
     */
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        // group keys differ. Aggregates run at the shard, Join runs there. Locality-agnostic
        }
                OpenSearchUnion(all=[true], viableBackends=[[mock-parquet]])
            """
     * through a nested Join doesn't degenerate (e.g. duplicate ERs) and that all three
        if (!withRedundantOuterSort) {
        assertPlanShape("""
            "test_index",
        PlannerContext context = multiShardContext();
        // Field trimming adds Project(status) above the shard scan — count-by-key needs only the group key.
        protected Set<org.opensearch.analytics.spi.EngineCapability> supportedEngineCapabilities() {
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
    }
    // ── builders ───────────────────────────────────────────────────────────────
        assertPlanShape(
     * <p>Inner collated Sort (by score) forces {@code Sort ← ER ← Scan} via
    }
     * OpenSearchJoin(INNER, $0 = $2)           ← stamped SINGLETON by JoinSplitRule
     * JoinSplit's convert() is a no-op per side; no extra ER above either FINAL. Total ERs: 2
 *
        RelNode innerSwap = LogicalProject.create(
    private RelNode buildJoinWithDifferentGroupKeys() {
            null,
     *         StubTableScan
                            OpenSearchProject(status=[$0], viableBackends=[[mock-parquet]])
     *
 * this file be licensed under the Apache-2.0 license or a
            result
        return AggregateCall.create(
        RelNode rightAgg = makeAggregate(stubScan(mockTable("test_index", "status", "size")), countStarCall());
        // (locality-agnostic SINGLETON) is satisfied directly — no top ER.
            innerSort,
    }
        // Right: stats sum(status) by size (group=1, aggregation output INTEGER — different group key)
                              OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        );
        RelNode plan = org.apache.calcite.rel.logical.LogicalAggregate.create(
                  OpenSearchProject(k=[$1], cnt=[$0], viableBackends=[[mock-parquet]])
            -1,
        assertPlanShape(
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
     * MockDataFusionBackend with EngineCapability.UNION declared.
        assertPlanShape(
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        );
            List.of(sumCallOn(rightScan, /* sumField */ 0))
import org.apache.calcite.rel.logical.LogicalJoin;
        );
        RelNode abJoin = LogicalJoin.create(aScan, bScan, List.of(), ab, Set.of(), JoinRelType.INNER);
                          OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        RelNode result = runPlanner(plan, perIndexContext(Map.of("a", 2, "b", 2, "c", 2)));
/**
     * <p>The PPL frontend emits a redundant outer Sort (no fetch, same collation as the inner)
                """,
        // adjacent for PROJECT_MERGE to collapse — both survive around the inner Sort.
    /** Inner equi-join {@code left.$0 = right.$0} on two bare scans. */
        RelNode input = topKAfterStats(/* withRedundantOuterSort */ false);
    }
        // path (single-input passthrough) between the inner Sort and the outer LIMIT.
        );
        assertPlanShape(
        );
    // testPureScan_multiShard_rootER + _singleShard_noTopER removed —
    /**
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 4)
        );
              OpenSearchAggregate(group=[{0}], s=[SUM($1)], mode=[SINGLE], viableBackends=[[mock-parquet]])
            agg,
     */
     * already delivers SINGLETON). No extra ER between Join and Sort.
            result
                      OpenSearchTableScan(table=[[left_idx]], viableBackends=[[mock-parquet]])
            null,
            rexBuilder.makeLiteral(2, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            return outerSwap;
        // root demand is satisfied by the SHARD+SINGLETON output of the Join — no top ER.
            org.apache.calcite.util.ImmutableBitSet.of(0),
            outerSwap,
 */
        RexNode cond = rexBuilder.makeCall(
