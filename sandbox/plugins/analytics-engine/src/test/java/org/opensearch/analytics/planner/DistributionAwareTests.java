 * {@link OpenSearchDistribution}, so it is tested in isolation — no planner run, no DAG. These are the  
            : rexBuilder.makeCall(
            "key mismatch → no co-partitioned output (pass enforces a re-shuffle)",  
            SqlStdOperatorTable.SUM,
        assertNull(
            null,  
        );
package org.opensearch.analytics.planner;
import org.apache.calcite.rel.core.JoinRelType;  
import org.opensearch.analytics.planner.rel.DistributionAware;
        assertEquals("left hash key = left equi key", List.of(0), left.getKeys());
    }
                SqlStdOperatorTable.EQUALS,  
            req.getType()
    private static java.util.Map<String, java.util.Map<String, Object>> Map_of_intFields() {  
            cluster,  
    }  
        );
        assertNotNull("grouped SINGLE agg requires hash on group keys", req);
            List.of(sumCall(scan)),
        assertEquals(RelDistribution.Type.HASH_DISTRIBUTED, out.getType());
    private org.apache.calcite.plan.RelTraitSet distTraits(OpenSearchDistribution dist) {
    }  
            null,
import org.apache.calcite.sql.type.SqlTypeName;
            join.deriveOutputDistribution(List.of(leftActual, rightActual), traitDef)
 * The OpenSearch Contributors require contributions made to  
        return buildJoin(type, /* equi */ true, leftKey, rightKeyOffset);
        TableScan scan = stubScan(mockTable("a_idx", "status", "size"));
            childHash,
            List.of(1),
    // ── OpenSearchFilter (transparent) ──────────────────────────────────────────
        RexNode condition = equi
            typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true),
        assertEquals("partition count threaded through", Integer.valueOf(N), left.getPartitionCount());  
    @Override
            rexBuilder.makeLiteral(5, intType, false)
    }
            false,  
    public void testPlainProject_imposesNoRequirement() {
    private OpenSearchDistributionTraitDef traitDef;  
        return new OpenSearchFilter(cluster, distTraits(traitDef.coordSingleton()), scan, cond, DF);
                rexBuilder.makeInputRef(intType, 0),  
 */  
    public void setUp() throws Exception {  
import org.opensearch.analytics.planner.rel.AggregateMode;
            ImmutableBitSet.of(),
        return java.util.Map.of("status", java.util.Map.of("type", "integer"), "size", java.util.Map.of("type", "integer"));
            RelDistribution.Type.SINGLETON,  
import org.opensearch.analytics.planner.rel.OpenSearchDistribution;
        return buildJoin(type, /* equi */ false, 0, 0);
        assertNotNull("left input must be required HASH", left);
    }
    }
            ? rexBuilder.makeCall(
public class DistributionAwareTests extends BasePlannerRulesTests {
            -1,
    public void testInnerEquiJoin_requiresHashOnEquiKeysPerSide() {  
        assertNotNull("right input must be required HASH", right);
        );  
        super.setUp();
                rexBuilder.makeInputRef(intType, leftKey),
    // ── OpenSearchJoin ──────────────────────────────────────────────────────────
    public void testFilter_isTransparent() {
 * {@code requiredInputDistribution} / {@code deriveOutputDistribution} is a pure function over
        assertEquals(RelDistribution.Type.HASH_DISTRIBUTED, req.getType());
        // The key generalization vs the current cascade (INNER-only): outer joins co-partition too.
import org.apache.calcite.util.ImmutableBitSet;  
        RelNode right = stubScan(mockTable("b_idx", "status", "size"));
            AggregateMode.SINGLE,
        assertNotNull(req);  
        PlannerContext ctx = buildContext("parquet", Map_of_intFields());
            join.requiredInputDistribution(0, N, traitDef)
            ImmutableBitSet.of(0),  
    }
    public void testJoin_derivesHashOutputWhenLeftHashedOnEquiKeys() {
 * Unit tests for the {@link DistributionAware} algebra. Each operator's
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
        RexNode cond = rexBuilder.makeCall(
        assertEquals(Integer.valueOf(N), out.getPartitionCount());  
    }
        // retains the trait (RelTraitSet.replace silently drops a trait whose def isn't registered).
        OpenSearchDistribution out = join.deriveOutputDistribution(List.of(leftActual, rightActual), traitDef);
        OpenSearchDistribution rightActual = traitDef.hash(List.of(0), N);
        OpenSearchFilter filter = filterOverScan();
        OpenSearchDistribution req = agg.requiredInputDistribution(0, N, traitDef);  
    // ── OpenSearchAggregate ─────────────────────────────────────────────────────
import org.apache.calcite.rel.RelDistribution;
    // intFields() helper from the base declares status,size — reuse via a small map builder.
    public void testOuterJoin_stillCoPartitionsOnEquiKeys() {  
        OpenSearchDistribution left = join.requiredInputDistribution(0, N, traitDef);
    private static final List<String> DF = List.of("datafusion");
            distTraits(traitDef.coordSingleton()),
        traitDef = ctx.getDistributionTraitDef();  
    public void testJoin_noDerivedOutputWhenLeftKeyMismatch() {  
            cluster,
            java.util.Map.of()
        OpenSearchAggregate agg = sumByStatus(); // group by col 0
        );
            scan,  
import org.opensearch.analytics.planner.rel.OpenSearchJoin;
        assertEquals(
        RelDataType intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
    private OpenSearchJoin thetaJoin(JoinRelType type) {
import org.opensearch.analytics.planner.rel.OpenSearchFilter;  
import org.opensearch.analytics.planner.rel.OpenSearchAggregate;  
    }
 * keystone of shape-complete scheduling.
                SqlStdOperatorTable.LESS_THAN,
            scan,
            scan,
            java.util.Map.of()
    public void testEmptyGroupAggregate_requiresSingleton() {  
    }  
        // Left actually hashed on a DIFFERENT key than the join's left equi key → output not co-partitionable.
        cluster.getPlanner().addRelTraitDef(traitDef);  
 * SPDX-License-Identifier: Apache-2.0
    }
            "total"
        OpenSearchDistribution req = agg.requiredInputDistribution(0, N, traitDef);
        OpenSearchJoin join = thetaJoin(JoinRelType.INNER);
/**  
        OpenSearchDistribution leftActual = traitDef.hash(List.of(0), N);  
import org.apache.calcite.rex.RexNode;  
        assertNull("plain row-wise project imposes no input requirement", project.requiredInputDistribution(0, N, traitDef));
    private OpenSearchAggregate sumByStatus() {  
        OpenSearchDistribution rightActual = traitDef.hash(List.of(0), N);
 * compatible open source license.
    /** A trait set carrying {@code dist} — built from a set that has the dist def registered. */  
            "pure theta join must impose no input requirement (stays coord-gathered)",  
    }
        );  
            OpenSearchJoin join = equiJoin(type, 0, 0);  
        TableScan scan = stubScan(mockTable("a_idx", "status", "size"));
            assertEquals(RelDistribution.Type.HASH_DISTRIBUTED, left.getType());  
        assertEquals(
    private OpenSearchFilter filterOverScan() {
            "filter passes child distribution through verbatim",  
    }  
    private OpenSearchAggregate sumNoGroup() {  
        return new OpenSearchAggregate(
        int leftCols = left.getRowType().getFieldCount();
        List<RexNode> projects = List.of(rexBuilder.makeInputRef(scan, 0), rexBuilder.makeInputRef(scan, 1));  
        );  
        // explicitly so Calcite's Aggregate ctor type-check passes.  
        );
        OpenSearchDistribution right = join.requiredInputDistribution(1, N, traitDef);  
            AggregateMode.SINGLE,  
            )  
    }
            DF,  
        for (JoinRelType type : List.of(JoinRelType.LEFT, JoinRelType.RIGHT, JoinRelType.FULL)) {
        OpenSearchJoin join = equiJoin(JoinRelType.INNER, 0, 0);
        assertNull(join.requiredInputDistribution(1, N, traitDef));  
    public void testPureThetaJoin_imposesNoRequirement() {  
        OpenSearchJoin join = equiJoin(JoinRelType.INNER, 0, 0);
    public void testGroupedAggregate_requiresHashOnGroupKeys() {
    }
import org.apache.calcite.rel.RelNode;
            DF,
                rexBuilder.makeInputRef(intType, leftCols)
        OpenSearchProject project = identityProjectOverScan();  
        TableScan scan = stubScan(mockTable("a_idx", "status", "size"));  
    private OpenSearchJoin buildJoin(JoinRelType type, boolean equi, int leftKey, int rightKeyOffset) {
        return new OpenSearchProject(cluster, distTraits(traitDef.coordSingleton()), scan, projects, scan.getRowType(), DF);
import java.util.List;
            );
}  
    // ── helpers ──────────────────────────────────────────────────────────────────
            OpenSearchDistribution left = join.requiredInputDistribution(0, N, traitDef);
    private static final int N = 3; // partition count  
import org.apache.calcite.rel.type.RelDataType;
            rexBuilder.makeInputRef(intType, 0),
        }
        return cluster.traitSet().replace(dist);
        assertEquals(List.of(0), req.getKeys());  
        OpenSearchAggregate agg = sumNoGroup();
        assertEquals(RelDistribution.Type.HASH_DISTRIBUTED, left.getType());  
        );  
    }
        assertNotNull("join output co-partitionable when left is hashed on left equi keys", out);  
    }
import org.opensearch.analytics.planner.rel.OpenSearchProject;
        assertNull("filter imposes no input requirement", filter.requiredInputDistribution(0, N, traitDef));  
    }
        org.apache.calcite.rel.core.AggregateCall sumCall = org.apache.calcite.rel.core.AggregateCall.create(
            "empty-group agg requires SINGLETON (PARTIAL distributes, FINAL gathers ≤N partials)",
/*  
            List.of(sumCall),
            assertNotNull(type + " outer join must co-partition on equi keys", left);
    private OpenSearchProject identityProjectOverScan() {
 */  
        assertEquals("output anchored on left equi keys", List.of(0), out.getKeys());
    private OpenSearchJoin equiJoin(JoinRelType type, int leftKey, int rightKeyOffset) {  
    // ── OpenSearchProject (transparent + remap) ─────────────────────────────────  
 * building blocks the post-CBO enforcement pass composes; getting them right per-operator is the
        RelNode left = stubScan(mockTable("a_idx", "status", "size"));  
            distTraits(traitDef.coordSingleton()),  
        return new OpenSearchAggregate(
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        return new OpenSearchJoin(cluster, distTraits(traitDef.coordSingleton()), left, right, condition, type, DF);  
        OpenSearchJoin join = equiJoin(JoinRelType.INNER, /* leftKey */ 0, /* rightKeyOffset */ 0);
    }  
        assertNull(
        OpenSearchDistribution childHash = traitDef.hash(List.of(0), N);
 *
        // Empty-group SUM infers a NULLABLE result (no rows → null), unlike the grouped case — declare it
        OpenSearchDistribution leftActual = traitDef.hash(List.of(1), N);  
        TableScan scan = stubScan(mockTable("a_idx", "status", "size"));
import org.opensearch.analytics.planner.rel.OpenSearchDistributionTraitDef;
import org.apache.calcite.rel.core.TableScan;
        assertEquals(RelDistribution.Type.HASH_DISTRIBUTED, right.getType());
 * this file be licensed under the Apache-2.0 license or a
                rexBuilder.makeInputRef(intType, leftCols + rightKeyOffset)
        // Register the distribution trait def on the test cluster's planner so traitSet().replace(dist)
            filter.deriveOutputDistribution(List.of(childHash), traitDef)
            SqlStdOperatorTable.GREATER_THAN,  
