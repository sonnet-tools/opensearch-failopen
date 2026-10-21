    }
        RexNode sargLit = rexBuilder.makeSearchArgumentLiteral(sarg, intType);
        RexCall original = buildBetweenSearch();
    // ── helpers ────────────────────────────────────────────────────────────
    public void testAdaptExpandsBetweenSearchAwayFromSearchOperator() {
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SEARCH, List.of(xRef, sargLit));
    }
        assertFalse(isSearch(adapted));
        points.add(Range.singleton(BigDecimal.valueOf(3)));
     * BETWEEN-style Sargs expand to AND(ge, le). Same acceptance criterion as
        assertTrue("expanded condition must be flat: " + adapted, RexUtil.isFlat(adapted));
import org.apache.calcite.rel.type.RelDataType;
        rangeSet.add(Range.lessThan(BigDecimal.valueOf(1)));
        cluster = RelOptCluster.create(planner, rexBuilder);
import org.apache.calcite.rex.RexCall;
 * this file be licensed under the Apache-2.0 license or a
    /** Returns false if the tree still carries a SEARCH call or a Sarg literal at any depth. */
        assertFalse(isSearch(adapted));
    }
     */
     * contain any Sarg literal or SEARCH call — it has to be something the
        RexCall original = buildPointExclusionsSearch();
     * The core contract: SEARCH is expanded. The resulting RexNode must not
        if (node instanceof org.apache.calcite.rex.RexLiteral lit && lit.getValue() instanceof Sarg) {
    private RexBuilder rexBuilder;
        RexNode adapted = new SargAdapter().adapt(original, List.of(), cluster);
 * Unit tests for {@link SargAdapter}. Calcite's {@code SEARCH(x, Sarg[...])} is a
 */
        assertTrue("expansion must not leave any nested SEARCH call", containsNoSearchOrSarg(adapted));
    /**
    private RexCall buildPointExclusionsSearch() {
    private RelDataType intType;
import com.google.common.collect.Range;
        RangeSet<BigDecimal> points = TreeRangeSet.create();
            for (RexNode operand : call.getOperands()) {
                if (!containsNoSearchOrSarg(operand)) return false;
import org.apache.calcite.sql.SqlKind;
    /**
/**
    private RexCall buildInListSearch() {
        intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
    public void setUp() throws Exception {
        if (isSearch(node)) return false;
        if (node instanceof RexCall call) {
     * Non-SEARCH calls must pass through untouched — the adapter is a no-op for
        RangeSet<BigDecimal> rangeSet = TreeRangeSet.create();
        assertFalse("expansion must not leave a SEARCH call at the root", isSearch(adapted));
 * compact, expanded form for {@code IN}-lists, {@code BETWEEN}, and unions of
        rangeSet.add(Range.greaterThan(BigDecimal.valueOf(2)));
package org.opensearch.be.datafusion;
    private static boolean containsNoSearchOrSarg(RexNode node) {
    public void testAdaptPassesThroughNonSearchCall() {
        RexNode xRef = rexBuilder.makeInputRef(intType, 0);
     */
 * The OpenSearch Contributors require contributions made to
        RexNode sargLit = rexBuilder.makeSearchArgumentLiteral(sarg, intType);
        RexNode xRef = rexBuilder.makeInputRef(intType, 0);
 */
import org.apache.calcite.rel.type.RelDataTypeFactory;
import java.util.List;
        }
    private RelDataTypeFactory typeFactory;
        rangeSet.add(Range.closed(BigDecimal.valueOf(1), BigDecimal.valueOf(10)));
import org.opensearch.test.OpenSearchTestCase;
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SEARCH, List.of(xRef, sargLit));
import org.apache.calcite.plan.hep.HepProgramBuilder;
        assertSame("non-SEARCH input must pass through unmodified", greaterThan, adapted);
import org.apache.calcite.rex.RexUtil;
    public void testAdaptFlattensExpandedAndChain() {
import org.apache.calcite.util.Sarg;
    /** Builds SEARCH(x, Sarg[[1..10]]) — the BETWEEN shape. */
 * compatible open source license.
     * adapter gets registered against a different ScalarFunction by mistake.
     * the IN-list case: no SEARCH and no Sarg literals in the output.
import com.google.common.collect.TreeRangeSet;
import com.google.common.collect.RangeSet;
        RangeSet<BigDecimal> rangeSet = TreeRangeSet.create();
            return false;
    }
        RexCall original = buildInListSearch();
        assertTrue(containsNoSearchOrSarg(adapted));
        RexNode sargLit = rexBuilder.makeSearchArgumentLiteral(sarg, intType);
import org.apache.calcite.plan.hep.HepPlanner;
        points.add(Range.singleton(BigDecimal.valueOf(1)));
        RexNode tenLit = rexBuilder.makeLiteral(10, intType, false);
    private static boolean isSearch(RexNode node) {
import com.google.common.collect.ImmutableRangeSet;
        Sarg<BigDecimal> sarg = Sarg.of(org.apache.calcite.rex.RexUnknownAs.UNKNOWN, ImmutableRangeSet.copyOf(rangeSet));
        RexCall greaterThan = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.GREATER_THAN, List.of(xRef, tenLit));
    }
        Sarg<BigDecimal> sarg = Sarg.of(org.apache.calcite.rex.RexUnknownAs.UNKNOWN, ImmutableRangeSet.copyOf(points));
        RexNode adapted = new SargAdapter().adapt(greaterThan, List.of(), cluster);
import org.apache.calcite.plan.RelOptCluster;
     * anything that isn't SEARCH. Guards against collateral damage if the
    public void testAdaptExpandsInListSearchAwayFromSearchOperator() {
        points.add(Range.singleton(BigDecimal.valueOf(2)));
    }
    /**
    @Override
        return true;
    /** Multi-point-exclusion SEARCH expands to a nested-AND chain; adapter flattens to satisfy RexUtil.isFlat. */
 *
import org.apache.calcite.sql.type.SqlTypeName;
    /** Builds {@code SEARCH(x, Sarg[(-inf..1), (1..2), (2..+inf)])} — the {@code x != 1 AND x != 2} shape. */
        RexNode adapted = new SargAdapter().adapt(original, List.of(), cluster);
import java.math.BigDecimal;
        Sarg<BigDecimal> sarg = Sarg.of(org.apache.calcite.rex.RexUnknownAs.UNKNOWN, ImmutableRangeSet.copyOf(rangeSet));
        RexNode xRef = rexBuilder.makeInputRef(intType, 0);
    }
/*
 * literal, so the adapter expands it back into native comparison/OR trees
 * before the plan is serialized.
    /** Builds SEARCH(x, Sarg[{1, 2, 3}]) — the IN-list shape. */
    }
    private RelOptCluster cluster;
        RexNode adapted = new SargAdapter().adapt(original, List.of(), cluster);
import org.apache.calcite.rex.RexBuilder;
    }
        rangeSet.add(Range.open(BigDecimal.valueOf(1), BigDecimal.valueOf(2)));
        assertTrue(containsNoSearchOrSarg(adapted));
            }
 * SPDX-License-Identifier: Apache-2.0
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        return node instanceof RexCall call && call.getKind() == SqlKind.SEARCH;
public class SargAdapterTests extends OpenSearchTestCase {
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
}
        RexNode xRef = rexBuilder.makeInputRef(intType, 0);
        typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.rex.RexNode;
        super.setUp();
 * ranges; DataFusion's substrait consumer doesn't recognize {@code Sarg} as a
    private RexCall buildBetweenSearch() {
     * downstream substrait consumer knows.
        rexBuilder = new RexBuilder(typeFactory);
     */
        }
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SEARCH, List.of(xRef, sargLit));
    }
