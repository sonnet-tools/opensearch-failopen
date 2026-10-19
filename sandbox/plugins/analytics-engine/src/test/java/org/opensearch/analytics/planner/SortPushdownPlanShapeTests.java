import org.apache.calcite.plan.RelOptUtil;
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            List.of(),
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    /**
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
            result
        RelNode plan = LogicalSort.create(
    }
            cond,
            """
            List.of(new UnionCapableBackend(), LUCENE)
            if (lines[i].contains("ExchangeReducer")) {
                  OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[10], viableBackends=[[mock-parquet]])
        );
    public void testSqlSortLimit_2shard_pushed() {
            }
    }
        assertTrue("shard Sort widened to offset+fetch=15 below ER", erIdx >= 0 && widenedIdx > erIdx);
        assertEquals("one ER per arm, plan:\n" + p, 2, p.lines().filter(l -> l.contains("ExchangeReducer")).count());
 * The OpenSearch Contributors require contributions made to
                OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])
            scan,
     *  (A LateMaterialization node wraps the top for scans with stored fields — incidental.) */
    /** SQL shape: single Sort(collation, fetch) → identical Sort pushed below ER.
        );
    /** Single shard has no ER → nothing to push below. */
            RelCollations.EMPTY,
    }
            null,
    }
        assertTrue("coordinator keeps offset=5", p.contains("offset=[5]"));
     * Bare {@code head N} (no ORDER BY): a collation-free fetch must still be pushed below the ER so
                assertTrue("a Sort must be pushed below each arm ER, plan:\n" + p, lines[i + 1].contains("OpenSearchSort"));
/*
            null
    private PlannerContext unionContext(String indexName, int shardCount) {
            java.util.Set.of(),
                """,
import org.apache.calcite.rel.logical.LogicalSort;
    }
        assertEquals("coord + shard Sort", 2, p.lines().filter(l -> l.contains("OpenSearchSort")).count());
    }
        assertEquals(1, RelOptUtil.toString(result).lines().filter(l -> l.contains("OpenSearchSort")).count());
    /** Aggregate path (Sort over grouped COUNT) is owned by the TopK rewriter — this rewriter must not add a Sort. */
            true
        String[] lines = p.split("\n", -1);
        );
            null,
        assertEquals(1, RelOptUtil.toString(result).lines().filter(l -> l.contains("OpenSearchSort")).count());
     * each shard caps locally at N rows. Without this, every shard streams its <em>entire</em> scan to
    public void testSingleShard_notPushed() {
    }
    }
            caps.add(org.opensearch.analytics.spi.EngineCapability.UNION);
        assertTrue("shard Sort widened to offset+fetch=15 below ER", erIdx >= 0 && widenedIdx > erIdx);
    /** A collation-free LIMIT — PPL {@code head N} / SQL {@code LIMIT N} with no {@code ORDER BY}. */
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
    /** Bare LIMIT, single shard: no ER to push below — coordinator keeps the only Sort. */
        );
            RelCollations.EMPTY,
}
        );
 * (with its effective fetch) is inserted below the ER so shards ship local top-N.
        assertPlanShape(
        );
            scan,
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals("coordinator + one Sort per arm, plan:\n" + p, 3, p.lines().filter(l -> l.contains("OpenSearchSort")).count());
            List.of(countStarCall())
 */
        assertEquals(1, RelOptUtil.toString(result).lines().filter(l -> l.contains("OpenSearchSort")).count());
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
        assertEquals(1, RelOptUtil.toString(result).lines().filter(l -> l.contains("OpenSearchSort")).count());
package org.opensearch.analytics.planner;
                super.supportedEngineCapabilities()
import org.apache.calcite.rel.RelFieldCollation;
        RelNode outerLimit = LogicalSort.create(
    }
        RelNode join = org.apache.calcite.rel.logical.LogicalJoin.create(
import org.apache.calcite.rex.RexNode;
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rules.OpenSearchSortPushdownRewriter}.
            null,
                """,
    }
 */
    private RelNode fetchLiteralSort(RelNode input, int fetch) {
     * the coordinator, which then trims to N — fetching every row defeats the limit. A limit without an
    public void testBareLimit_singleShard_notPushed() {
    }
 *
            stubScan(mockTable("left_idx", "status", "size")),
        String p = RelOptUtil.toString(runPlanner(bareLimit(union, 10), unionContext("test_index", 2)));
 *
        RelNode result = runPlanner(fetchLiteralSort(scan, 10), singleShardContext());
        int widenedIdx = p.indexOf("fetch=[15]");
        return LogicalSort.create(
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            innerSort,
    public void testUnionAll_2shard_pushedIntoBothArms() {
    /** UNION ALL: the collated sort is pushed below each arm's ER (split at each point). */
 * SPDX-License-Identifier: Apache-2.0
        }
        );
            """
        RelNode innerSort = LogicalSort.create(
            return caps;
    public void testAggregatePath_notTouched() {
        RelNode result = runPlanner(outerLimit, multiShardContext());
        );
        assertPlanShape(
    public void testBareLimitOffset_2shard_widenedFetch() {
            rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        int erIdx = p.indexOf("ExchangeReducer");
    }
        String p = org.apache.calcite.plan.RelOptUtil.toString(runPlanner(plan, multiShardContext()));
     * shard's N-row result, regardless of which rows each shard keeps.
/**
            """
 * <p>Fires for non-aggregate {@code ORDER BY .. LIMIT}: a copy of the collated Sort
        for (int i = 0; i + 1 < lines.length; i++) {
    public void testBareLimitUnionAll_2shard_pushedIntoBothArms() {
        RexNode cond = rexBuilder.makeCall(
        assertEquals("one ER per arm, plan:\n" + p, 2, p.lines().filter(l -> l.contains("ExchangeReducer")).count());
        for (int i = 0; i + 1 < lines.length; i++) {
        RelNode result = runPlanner(fetchLiteralSort(scan, 10), multiShardContext());
    }
            result
    public void testBareLimit_2shard_pushed() {
            org.apache.calcite.sql.fun.SqlStdOperatorTable.EQUALS,
    public void testSqlSortLimitOffset_2shard_widenedFetch() {
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        @Override
        RelNode plan = LogicalSort.create(
            true
            null
            "parquet",
            scan,
        );
    }
        RelNode result = runPlanner(plan, multiShardContext());
            scan,
     */
import org.apache.calcite.rel.RelNode;
        // Only the coordinator Sort — no per-partition Sort from this rewriter (oversampling default 0 disables TopK too).
        RelNode agg = org.apache.calcite.rel.logical.LogicalAggregate.create(
    private static final class UnionCapableBackend extends MockDataFusionBackend {
        );
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            }
                      OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[10], viableBackends=[[mock-parquet]])
            java.util.Set<org.opensearch.analytics.spi.EngineCapability> caps = new java.util.HashSet<>(
        RelNode union = LogicalUnion.create(
            scan,
            org.apache.calcite.rel.core.JoinRelType.INNER
    /** Bare LIMIT with OFFSET: shard fetch widens to offset+fetch, offset stays on the coordinator. */
        );
    public void testNoFetch_notPushed() {
                OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])
        String p = RelOptUtil.toString(runPlanner(fetchLiteralSort(union, 10), unionContext("test_index", 2)));
        assertFalse("shard Sort must not carry an offset", p.substring(widenedIdx).contains("offset="));
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            runPlanner(fetchLiteralSort(join, 10), perIndexContext(java.util.Map.of("left_idx", 1, "right_idx", 1)))
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    /** PPL shape: outer pure-fetch over inner collated → shard Sort gets inner collation + outer fetch. */
public class SortPushdownPlanShapeTests extends PlanShapeTestBase {
                  OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
        assertPlanShape(
            input,
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        String[] lines = p.split("\n", -1);
 * compatible open source license.
            rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        );
                    OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])
                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    /** Sort over a Join is not pushed — joins are explicitly out of scope. */
        assertEquals("coord + shard Sort", 2, p.lines().filter(l -> l.contains("OpenSearchSort")).count());
        }
    public void testPplSortHead_2shard_pushed() {
            null,
                """,
                assertTrue("a Sort must be pushed below each arm ER, plan:\n" + p, lines[i + 1].contains("OpenSearchSort"));
     * order is always safe to push: the coordinator's N-row result is a subset of the union of each
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
        RelNode result = runPlanner(bareLimit(scan, 10), singleShardContext());
        protected java.util.Set<org.opensearch.analytics.spi.EngineCapability> supportedEngineCapabilities() {
        return buildContextPerIndex(
        assertEquals("coordinator + one Sort per arm, plan:\n" + p, 3, p.lines().filter(l -> l.contains("OpenSearchSort")).count());
import org.apache.calcite.util.ImmutableBitSet;
            RelCollations.EMPTY,
    /** SQL shape with OFFSET: shard Sort drops the offset and widens fetch to offset+fetch; coordinator keeps offset. */
        RelNode result = runPlanner(fetchLiteralSort(agg, 10), multiShardContext());
        assertEquals("no Sort pushed below a join, plan:\n" + p, 1, p.lines().filter(l -> l.contains("OpenSearchSort")).count());
            List.of(),
                      OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[10], viableBackends=[[mock-parquet]])
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        return LogicalSort.create(
        assertTrue("coordinator keeps offset=5", p.contains("offset=[5]"));
            if (lines[i].contains("ExchangeReducer")) {
            java.util.Map.of(indexName, shardCount),
        RelNode union = LogicalUnion.create(
        );
                OpenSearchLateMaterialization(aboveAnchorPhysicalFields=[[status, size]], viableBackends=[[mock-parquet]])
        int erIdx = p.indexOf("ExchangeReducer");
import java.util.List;
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            intFields(),
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    /** Collated Sort with no fetch → no transport bound → not pushed. */
        );
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
            ImmutableBitSet.of(0),
import org.apache.calcite.sql.type.SqlTypeName;
    }
        );
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        }
            stubScan(mockTable("right_idx", "status", "size")),
import org.apache.calcite.rel.RelCollations;
        );
        String p = RelOptUtil.toString(runPlanner(plan, multiShardContext()));
            );
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            result
        RelNode plan = LogicalSort.create(
        String p = RelOptUtil.toString(
        RelNode result = runPlanner(bareLimit(scan, 10), multiShardContext());
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        int widenedIdx = p.indexOf("fetch=[15]");
            null,
        assertFalse("shard Sort must not carry an offset", p.substring(widenedIdx).contains("offset="));
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
            null,
    private RelNode bareLimit(RelNode input, int fetch) {
    /** Context whose DataFusion backend declares EngineCapability.UNION (mirrors PlanShapeTests). */
            input,
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
    /** Bare LIMIT over UNION ALL: the collation-free fetch is pushed below each arm's ER. */
    public void testJoin_notPushed() {
import org.apache.calcite.rel.logical.LogicalUnion;
        );
