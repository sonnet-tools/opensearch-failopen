                      OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
    private PlannerContext unionContext(String indexName, int shardCount) {  
        );  
            null,
                OpenSearchLateMaterialization(aboveAnchorPhysicalFields=[[status, size]], viableBackends=[[mock-parquet]])
import org.apache.calcite.rel.RelFieldCollation;  
    }
    /** Bare LIMIT with OFFSET: shard fetch widens to offset+fetch, offset stays on the coordinator. */
    }  
            scan,
        String p = RelOptUtil.toString(runPlanner(fetchLiteralSort(union, 10), unionContext("test_index", 2)));
        RelNode innerSort = LogicalSort.create(  
                """,
                  OpenSearchSort(sort0=[$0], dir0=[ASC], viableBackends=[[mock-parquet]])
        RelNode union = LogicalUnion.create(  
            null,  
        // Only the coordinator Sort — no per-partition Sort from this rewriter (oversampling default 0 disables TopK too).
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
            true
        assertEquals(1, RelOptUtil.toString(result).lines().filter(l -> l.contains("OpenSearchSort")).count());
        String[] lines = p.split("\n", -1);
            rexBuilder.makeLiteral(fetch, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        assertEquals("no Sort pushed below a join, plan:\n" + p, 1, p.lines().filter(l -> l.contains("OpenSearchSort")).count());  
        String p = org.apache.calcite.plan.RelOptUtil.toString(runPlanner(plan, multiShardContext()));
                      OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[10], viableBackends=[[mock-parquet]])  
                OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])  
        int widenedIdx = p.indexOf("fetch=[15]");
            RelCollations.EMPTY,
        assertPlanShape(
            stubScan(mockTable("right_idx", "status", "size")),  
            org.apache.calcite.sql.fun.SqlStdOperatorTable.EQUALS,  
        return buildContextPerIndex(
 */  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    /** PPL shape: outer pure-fetch over inner collated → shard Sort gets inner collation + outer fetch. */  
            java.util.Set.of(),  
        RelNode result = runPlanner(bareLimit(scan, 10), multiShardContext());
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
        RelNode result = runPlanner(bareLimit(scan, 10), singleShardContext());
        );
    /** Aggregate path (Sort over grouped COUNT) is owned by the TopK rewriter — this rewriter must not add a Sort. */
            null,  
import org.apache.calcite.util.ImmutableBitSet;  
package org.opensearch.analytics.planner;
            ImmutableBitSet.of(0),
        assertPlanShape(  
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            stubScan(mockTable("left_idx", "status", "size")),
        );  
        return LogicalSort.create(
            """
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 2)
        assertEquals("coord + shard Sort", 2, p.lines().filter(l -> l.contains("OpenSearchSort")).count());  
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
    private RelNode fetchLiteralSort(RelNode input, int fetch) {  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
        assertFalse("shard Sort must not carry an offset", p.substring(widenedIdx).contains("offset="));
 * compatible open source license.
        RexNode cond = rexBuilder.makeCall(
     * Bare {@code head N} (no ORDER BY): a collation-free fetch must still be pushed below the ER so
    /** Bare LIMIT over UNION ALL: the collation-free fetch is pushed below each arm's ER. */
            if (lines[i].contains("ExchangeReducer")) {
        for (int i = 0; i + 1 < lines.length; i++) {
 * <p>Fires for non-aggregate {@code ORDER BY .. LIMIT}: a copy of the collated Sort
        assertTrue("coordinator keeps offset=5", p.contains("offset=[5]"));
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
    public void testPplSortHead_2shard_pushed() {
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
    }
        assertEquals("coord + shard Sort", 2, p.lines().filter(l -> l.contains("OpenSearchSort")).count());
        RelNode join = org.apache.calcite.rel.logical.LogicalJoin.create(
        );  
import java.util.List;
            result  
        );  
        RelNode result = runPlanner(plan, multiShardContext());  
    public void testNoFetch_notPushed() {
 *  
                assertTrue("a Sort must be pushed below each arm ER, plan:\n" + p, lines[i + 1].contains("OpenSearchSort"));
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
            """  
            null
    }  
            List.of(),
        );
        );
import org.apache.calcite.rel.logical.LogicalUnion;  
        protected java.util.Set<org.opensearch.analytics.spi.EngineCapability> supportedEngineCapabilities() {
            intFields(),
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
     * each shard caps locally at N rows. Without this, every shard streams its <em>entire</em> scan to  
            }  
            result
        assertEquals("coordinator + one Sort per arm, plan:\n" + p, 3, p.lines().filter(l -> l.contains("OpenSearchSort")).count());
        );
        RelNode result = runPlanner(fetchLiteralSort(agg, 10), multiShardContext());  
     * shard's N-row result, regardless of which rows each shard keeps.  
    }
    public void testJoin_notPushed() {
            null,
    }
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])  
            runPlanner(fetchLiteralSort(join, 10), perIndexContext(java.util.Map.of("left_idx", 1, "right_idx", 1)))
            List.of(new UnionCapableBackend(), LUCENE)
    private static final class UnionCapableBackend extends MockDataFusionBackend {  
/*  
    /** Collated Sort with no fetch → no transport bound → not pushed. */  
            );
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
            input,
        RelNode outerLimit = LogicalSort.create(  
            scan,
                super.supportedEngineCapabilities()
    }  
    }  
        int erIdx = p.indexOf("ExchangeReducer");
        String p = RelOptUtil.toString(runPlanner(bareLimit(union, 10), unionContext("test_index", 2)));
    }
            "parquet",
            List.of(countStarCall())
        assertEquals(1, RelOptUtil.toString(result).lines().filter(l -> l.contains("OpenSearchSort")).count());
            scan,  
        assertPlanShape(
            if (lines[i].contains("ExchangeReducer")) {  
                  OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[10], viableBackends=[[mock-parquet]])  
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
            null,  
    }
        assertTrue("shard Sort widened to offset+fetch=15 below ER", erIdx >= 0 && widenedIdx > erIdx);  
import org.apache.calcite.plan.RelOptUtil;
    }
            scan,  
     *  (A LateMaterialization node wraps the top for scans with stored fields — incidental.) */
import org.apache.calcite.sql.type.SqlTypeName;
    public void testSingleShard_notPushed() {
    public void testUnionAll_2shard_pushedIntoBothArms() {
 * SPDX-License-Identifier: Apache-2.0
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));  
        );
    public void testAggregatePath_notTouched() {  
import org.apache.calcite.rex.RexNode;
 * Plan-shape tests for {@link org.opensearch.analytics.planner.rules.OpenSearchSortPushdownRewriter}.
    /**
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),
                assertTrue("a Sort must be pushed below each arm ER, plan:\n" + p, lines[i + 1].contains("OpenSearchSort"));
                """,
        }  
        }
            rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
            java.util.Map.of(indexName, shardCount),  
    }
        assertEquals("one ER per arm, plan:\n" + p, 2, p.lines().filter(l -> l.contains("ExchangeReducer")).count());  
        String p = RelOptUtil.toString(  
        );
        RelNode union = LogicalUnion.create(
    /** Context whose DataFusion backend declares EngineCapability.UNION (mirrors PlanShapeTests). */
                OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])
        String[] lines = p.split("\n", -1);
            RelCollations.EMPTY,
        );
 * The OpenSearch Contributors require contributions made to  
 *
            null
    }
        assertEquals(1, RelOptUtil.toString(result).lines().filter(l -> l.contains("OpenSearchSort")).count());
                        OpenSearchTableScan(table=[[test_index]], viableBackends=[[mock-parquet]])
        for (int i = 0; i + 1 < lines.length; i++) {  
/**
        assertTrue("shard Sort widened to offset+fetch=15 below ER", erIdx >= 0 && widenedIdx > erIdx);
        RelNode plan = LogicalSort.create(
                      OpenSearchSort(sort0=[$0], dir0=[ASC], fetch=[10], viableBackends=[[mock-parquet]])
        assertEquals("coordinator + one Sort per arm, plan:\n" + p, 3, p.lines().filter(l -> l.contains("OpenSearchSort")).count());  
import org.apache.calcite.rel.logical.LogicalSort;
            scan,
    /** Sort over a Join is not pushed — joins are explicitly out of scope. */  
            result  
    public void testSqlSortLimitOffset_2shard_widenedFetch() {
    }  
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),  
        return LogicalSort.create(
    /** Single shard has no ER → nothing to push below. */
            org.apache.calcite.rel.core.JoinRelType.INNER
        assertEquals(1, RelOptUtil.toString(result).lines().filter(l -> l.contains("OpenSearchSort")).count());
    /** A collation-free LIMIT — PPL {@code head N} / SQL {@code LIMIT N} with no {@code ORDER BY}. */  
        RelNode agg = org.apache.calcite.rel.logical.LogicalAggregate.create(
            cond,
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), true)  
            caps.add(org.opensearch.analytics.spi.EngineCapability.UNION);  
    public void testBareLimitUnionAll_2shard_pushedIntoBothArms() {  
    public void testBareLimit_2shard_pushed() {
import org.apache.calcite.rel.RelCollations;
        );
        RelNode result = runPlanner(fetchLiteralSort(scan, 10), multiShardContext());
    public void testBareLimit_singleShard_notPushed() {
            return caps;
        int widenedIdx = p.indexOf("fetch=[15]");  
            true  
    }
    public void testBareLimitOffset_2shard_widenedFetch() {  
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0),
        RelNode plan = LogicalSort.create(
                    OpenSearchSort(fetch=[10], viableBackends=[[mock-parquet]])  
        );
            }
 * this file be licensed under the Apache-2.0 license or a
    /** UNION ALL: the collated sort is pushed below each arm's ER (split at each point). */
     * order is always safe to push: the coordinator's N-row result is a subset of the union of each
            null,  
        );
            innerSort,
        }
        int erIdx = p.indexOf("ExchangeReducer");
        RelNode scan = stubScan(mockTable("test_index", "status", "size"));
import org.apache.calcite.rel.RelNode;
        RelNode result = runPlanner(fetchLiteralSort(scan, 10), singleShardContext());
                    OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
            RelCollations.EMPTY,
    /** Bare LIMIT, single shard: no ER to push below — coordinator keeps the only Sort. */
        @Override
            RelCollations.of(new RelFieldCollation(0, RelFieldCollation.Direction.ASCENDING)),  
            java.util.Set<org.opensearch.analytics.spi.EngineCapability> caps = new java.util.HashSet<>(  
                  OpenSearchExchangeReducer(viableBackends=[[mock-parquet]], exchange=[ExchangeInfo[distributionType=SINGLETON, partitionKeyIndices=[], partitionCount=0]])
                """,
        assertEquals("one ER per arm, plan:\n" + p, 2, p.lines().filter(l -> l.contains("ExchangeReducer")).count());
        );  
        );
 */  
     */
    }
            rexBuilder.makeLiteral(5, typeFactory.createSqlType(SqlTypeName.INTEGER), true),
    /** SQL shape: single Sort(collation, fetch) → identical Sort pushed below ER.
        assertFalse("shard Sort must not carry an offset", p.substring(widenedIdx).contains("offset="));
        RelNode result = runPlanner(outerLimit, multiShardContext());  
     * the coordinator, which then trims to N — fetching every row defeats the limit. A limit without an
        String p = RelOptUtil.toString(runPlanner(plan, multiShardContext()));
public class SortPushdownPlanShapeTests extends PlanShapeTestBase {
            input,  
    /** SQL shape with OFFSET: shard Sort drops the offset and widens fetch to offset+fetch; coordinator keeps offset. */
    public void testSqlSortLimit_2shard_pushed() {  
    private RelNode bareLimit(RelNode input, int fetch) {
        );  
            List.of(),
 * (with its effective fetch) is inserted below the ER so shards ship local top-N.
            List.of(stubScan(mockTable("test_index", "status", "size")), stubScan(mockTable("test_index", "status", "size"))),
        RelNode plan = LogicalSort.create(  
}
        assertTrue("coordinator keeps offset=5", p.contains("offset=[5]"));  
            """
