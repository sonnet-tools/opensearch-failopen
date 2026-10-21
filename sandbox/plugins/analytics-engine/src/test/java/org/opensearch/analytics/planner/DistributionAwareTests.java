        assertNull(join.requiredInputDistribution(1, N, traitDef));
        cluster.getPlanner().addRelTraitDef(traitDef);
/*
        assertEquals("partition count threaded through", Integer.valueOf(N), left.getPartitionCount());
    private static java.util.Map<String, java.util.Map<String, Object>> Map_of_intFields() {
    // ── helpers ──────────────────────────────────────────────────────────────────
            filter.deriveOutputDistribution(List.of(childHash), traitDef)
        );
            List.of(sumCall),
            req.getType()
        OpenSearchJoin join = equiJoin(JoinRelType.INNER, 0, 0);
        // The key generalization vs the current cascade (INNER-only): outer joins co-partition too.
        );
import org.apache.calcite.rel.core.JoinRelType;
            : rexBuilder.makeCall(
        );
            cluster,
            cluster,
    }
        OpenSearchJoin join = thetaJoin(JoinRelType.INNER);
    }
        TableScan scan = stubScan(mockTable("a_idx", "status", "size"));
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        OpenSearchAggregate agg = sumNoGroup();
 * keystone of shape-complete scheduling.
            SqlStdOperatorTable.GREATER_THAN,
    }
            "pure theta join must impose no input requirement (stays coord-gathered)",
            scan,
        int leftCols = left.getRowType().getFieldCount();
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
            -1,
    }
                rexBuilder.makeInputRef(intType, leftCols)
        OpenSearchDistribution left = join.requiredInputDistribution(0, N, traitDef);
    public void testJoin_noDerivedOutputWhenLeftKeyMismatch() {
        return buildJoin(type, /* equi */ false, 0, 0);
            scan,
            );
    }
                rexBuilder.makeInputRef(intType, 0),
    /** A trait set carrying {@code dist} — built from a set that has the dist def registered. */
        TableScan scan = stubScan(mockTable("a_idx", "status", "size"));
            rexBuilder.makeLiteral(5, intType, false)
            null,
        OpenSearchDistribution out = join.deriveOutputDistribution(List.of(leftActual, rightActual), traitDef);
            AggregateMode.SINGLE,
            ImmutableBitSet.of(),
        OpenSearchJoin join = equiJoin(JoinRelType.INNER, 0, 0);
            )
 * this file be licensed under the Apache-2.0 license or a
        assertNull(
        OpenSearchAggregate agg = sumByStatus(); // group by col 0
    }
import java.util.List;
        assertEquals("output anchored on left equi keys", List.of(0), out.getKeys());
    private static final int N = 3; // partition count
        OpenSearchDistribution rightActual = traitDef.hash(List.of(0), N);
    public void testGroupedAggregate_requiresHashOnGroupKeys() {
        TableScan scan = stubScan(mockTable("a_idx", "status", "size"));
            java.util.Map.of()
        return java.util.Map.of("status", java.util.Map.of("type", "integer"), "size", java.util.Map.of("type", "integer"));
            join.deriveOutputDistribution(List.of(leftActual, rightActual), traitDef)
        RelNode right = stubScan(mockTable("b_idx", "status", "size"));
    public void testPlainProject_imposesNoRequirement() {
        OpenSearchDistribution leftActual = traitDef.hash(List.of(1), N);
            false,
    // ── OpenSearchAggregate ─────────────────────────────────────────────────────
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
    private OpenSearchDistributionTraitDef traitDef;
        // Empty-group SUM infers a NULLABLE result (no rows → null), unlike the grouped case — declare it
    public void testOuterJoin_stillCoPartitionsOnEquiKeys() {
    @Override
    public void testJoin_derivesHashOutputWhenLeftHashedOnEquiKeys() {
        }
            "filter passes child distribution through verbatim",
        );
/**
        assertEquals(Integer.valueOf(N), out.getPartitionCount());
            join.requiredInputDistribution(0, N, traitDef)
        super.setUp();
    }
    }
            AggregateMode.SINGLE,
    }
            DF,
            distTraits(traitDef.coordSingleton()),
        OpenSearchDistribution right = join.requiredInputDistribution(1, N, traitDef);
    private OpenSearchProject identityProjectOverScan() {
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
                SqlStdOperatorTable.EQUALS,
    }
        // Left actually hashed on a DIFFERENT key than the join's left equi key → output not co-partitionable.
        RelNode left = stubScan(mockTable("a_idx", "status", "size"));
    }
 * The OpenSearch Contributors require contributions made to
import org.apache.calcite.rex.RexNode;
        assertNotNull("grouped SINGLE agg requires hash on group keys", req);
        org.apache.calcite.rel.core.AggregateCall sumCall = org.apache.calcite.rel.core.AggregateCall.create(
 * compatible open source license.
    }
    }
        assertNotNull("join output co-partitionable when left is hashed on left equi keys", out);
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;
            java.util.Map.of()
            OpenSearchJoin join = equiJoin(type, 0, 0);
            RelDistribution.Type.SINGLETON,
        // explicitly so Calcite's Aggregate ctor type-check passes.
import org.apache.calcite.util.ImmutableBitSet;
import org.apache.calcite.rel.core.TableScan;
        );
            assertNotNull(type + " outer join must co-partition on equi keys", left);
 *
        assertNull("plain row-wise project imposes no input requirement", project.requiredInputDistribution(0, N, traitDef));
        for (JoinRelType type : List.of(JoinRelType.LEFT, JoinRelType.RIGHT, JoinRelType.FULL)) {
        OpenSearchDistribution childHash = traitDef.hash(List.of(0), N);
            OpenSearchDistribution left = join.requiredInputDistribution(0, N, traitDef);
    }
 * Unit tests for the {@link DistributionAware} algebra. Each operator's
    private OpenSearchJoin thetaJoin(JoinRelType type) {
import org.apache.calcite.rel.type.RelDataType;
        OpenSearchDistribution rightActual = traitDef.hash(List.of(0), N);
import org.apache.calcite.sql.type.SqlTypeName;
    private OpenSearchAggregate sumNoGroup() {
 * SPDX-License-Identifier: Apache-2.0
                SqlStdOperatorTable.LESS_THAN,
        OpenSearchDistribution req = agg.requiredInputDistribution(0, N, traitDef);
            ? rexBuilder.makeCall(
        return new OpenSearchAggregate(
        assertEquals(RelDistribution.Type.HASH_DISTRIBUTED, req.getType());
            List.of(1),
 * building blocks the post-CBO enforcement pass composes; getting them right per-operator is the
        assertEquals(RelDistribution.Type.HASH_DISTRIBUTED, out.getType());
        TableScan scan = stubScan(mockTable("a_idx", "status", "size"));
    public void setUp() throws Exception {
        return new OpenSearchFilter(cluster, distTraits(traitDef.coordSingleton()), scan, cond, DF);
 */
            "empty-group agg requires SINGLETON (PARTIAL distributes, FINAL gathers ≤N partials)",
        assertEquals("left hash key = left equi key", List.of(0), left.getKeys());
            null,
    private OpenSearchJoin equiJoin(JoinRelType type, int leftKey, int rightKeyOffset) {
        return new OpenSearchJoin(cluster, distTraits(traitDef.coordSingleton()), left, right, condition, type, DF);
import org.opensearch.analytics.planner.rel.DistributionAware;
        RexNode cond = rexBuilder.makeCall(
        return cluster.traitSet().replace(dist);
import org.opensearch.analytics.planner.rel.AggregateMode;
        assertNotNull("left input must be required HASH", left);
        assertNull("filter imposes no input requirement", filter.requiredInputDistribution(0, N, traitDef));
        RexNode condition = equi
    public void testFilter_isTransparent() {
}
    }
        OpenSearchProject project = identityProjectOverScan();
        // retains the trait (RelTraitSet.replace silently drops a trait whose def isn't registered).
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
import org.apache.calcite.rel.RelNode;
 * {@link OpenSearchDistribution}, so it is tested in isolation — no planner run, no DAG. These are the
        OpenSearchDistribution leftActual = traitDef.hash(List.of(0), N);
    private org.apache.calcite.plan.RelTraitSet distTraits(OpenSearchDistribution dist) {
        return new OpenSearchAggregate(
        assertNotNull(req);
        OpenSearchDistribution req = agg.requiredInputDistribution(0, N, traitDef);
        assertEquals(
    // ── OpenSearchProject (transparent + remap) ─────────────────────────────────
        assertEquals(RelDistribution.Type.HASH_DISTRIBUTED, left.getType());
        OpenSearchFilter filter = filterOverScan();
    public void testPureThetaJoin_imposesNoRequirement() {
    private OpenSearchAggregate sumByStatus() {
        assertEquals(
    public void testEmptyGroupAggregate_requiresSingleton() {
    private OpenSearchJoin buildJoin(JoinRelType type, boolean equi, int leftKey, int rightKeyOffset) {
            ImmutableBitSet.of(0),
    }
        );
 */
package org.opensearch.analytics.planner;
        assertEquals(List.of(0), req.getKeys());
        return new OpenSearchProject(cluster, distTraits(traitDef.coordSingleton()), scan, projects, scan.getRowType(), DF);
    // intFields() helper from the base declares status,size — reuse via a small map builder.
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        List<RexNode> projects = List.of(rexBuilder.makeInputRef(scan, 0), rexBuilder.makeInputRef(scan, 1));
    }
    }
 * {@code requiredInputDistribution} / {@code deriveOutputDistribution} is a pure function over
            assertEquals(RelDistribution.Type.HASH_DISTRIBUTED, left.getType());
    // ── OpenSearchFilter (transparent) ──────────────────────────────────────────
    private static final List<String> DF = List.of("datafusion");
            "key mismatch → no co-partitioned output (pass enforces a re-shuffle)",
                rexBuilder.makeInputRef(intType, leftKey),
        );
            childHash,
        );
        PlannerContext ctx = buildContext("parquet", Map_of_intFields());
        assertNotNull("right input must be required HASH", right);
            SqlStdOperatorTable.SUM,
public class DistributionAwareTests extends BasePlannerRulesTests {
            distTraits(traitDef.coordSingleton()),
        traitDef = ctx.getDistributionTraitDef();
                rexBuilder.makeInputRef(intType, leftCols + rightKeyOffset)
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
    private OpenSearchFilter filterOverScan() {
        // Register the distribution trait def on the test cluster's planner so traitSet().replace(dist)
            scan,
            List.of(sumCall(scan)),
        OpenSearchJoin join = equiJoin(JoinRelType.INNER, /* leftKey */ 0, /* rightKeyOffset */ 0);
    // ── OpenSearchJoin ──────────────────────────────────────────────────────────
        return buildJoin(type, /* equi */ true, leftKey, rightKeyOffset);
        assertEquals(RelDistribution.Type.HASH_DISTRIBUTED, right.getType());
import org.apache.calcite.rel.RelDistribution;
        assertNull(
            "total"
import org.opensearch.analytics.planner.rel.OpenSearchProject;
    public void testInnerEquiJoin_requiresHashOnEquiKeysPerSide() {
    }
            rexBuilder.makeInputRef(intType, 0),
            DF,
