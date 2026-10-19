import org.opensearch.test.OpenSearchTestCase;
     */
    private RelOptCluster cluster;
    /**  
import org.apache.calcite.plan.RelOptCluster;  
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SEARCH, List.of(xRef, sargLit));
    }
 * The OpenSearch Contributors require contributions made to  
    @Override
            return false;
        if (node instanceof RexCall call) {  
        assertTrue("expanded condition must be flat: " + adapted, RexUtil.isFlat(adapted));  
    }
    private RexCall buildBetweenSearch() {
 * compact, expanded form for {@code IN}-lists, {@code BETWEEN}, and unions of
 * literal, so the adapter expands it back into native comparison/OR trees
            for (RexNode operand : call.getOperands()) {
/*  
    }  
        RangeSet<BigDecimal> rangeSet = TreeRangeSet.create();
        RexCall original = buildPointExclusionsSearch();
        return node instanceof RexCall call && call.getKind() == SqlKind.SEARCH;  
        RexNode adapted = new SargAdapter().adapt(original, List.of(), cluster);
        RexCall original = buildBetweenSearch();
        return true;
     * Non-SEARCH calls must pass through untouched — the adapter is a no-op for
import java.util.List;
     * adapter gets registered against a different ScalarFunction by mistake.  
    private RexBuilder rexBuilder;
import org.apache.calcite.rel.type.RelDataTypeFactory;
    }
        RexNode sargLit = rexBuilder.makeSearchArgumentLiteral(sarg, intType);  
import org.apache.calcite.rex.RexUtil;
     * the IN-list case: no SEARCH and no Sarg literals in the output.
    }  
     * contain any Sarg literal or SEARCH call — it has to be something the  
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
        points.add(Range.singleton(BigDecimal.valueOf(3)));
    /** Multi-point-exclusion SEARCH expands to a nested-AND chain; adapter flattens to satisfy RexUtil.isFlat. */
     * BETWEEN-style Sargs expand to AND(ge, le). Same acceptance criterion as  
import com.google.common.collect.ImmutableRangeSet;
package org.opensearch.be.datafusion;
        RangeSet<BigDecimal> rangeSet = TreeRangeSet.create();
}
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SEARCH, List.of(xRef, sargLit));
import org.apache.calcite.plan.hep.HepProgramBuilder;
 */  
import org.apache.calcite.sql.type.SqlTypeName;
            }  
        assertTrue(containsNoSearchOrSarg(adapted));
    /** Builds SEARCH(x, Sarg[[1..10]]) — the BETWEEN shape. */  
        RexNode adapted = new SargAdapter().adapt(original, List.of(), cluster);
    /**
    /** Returns false if the tree still carries a SEARCH call or a Sarg literal at any depth. */  
/**  
    }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RexNode adapted = new SargAdapter().adapt(original, List.of(), cluster);
        }
    private RelDataTypeFactory typeFactory;  
        RexNode xRef = rexBuilder.makeInputRef(intType, 0);
    private RexCall buildPointExclusionsSearch() {  
import com.google.common.collect.TreeRangeSet;
        assertTrue("expansion must not leave any nested SEARCH call", containsNoSearchOrSarg(adapted));
    public void testAdaptFlattensExpandedAndChain() {  
    private RelDataType intType;  
import org.apache.calcite.rex.RexCall;  
        RangeSet<BigDecimal> points = TreeRangeSet.create();
        return (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SEARCH, List.of(xRef, sargLit));  
     * The core contract: SEARCH is expanded. The resulting RexNode must not
        }
import org.apache.calcite.util.Sarg;  
        RexNode xRef = rexBuilder.makeInputRef(intType, 0);
     * downstream substrait consumer knows.
import org.apache.calcite.sql.SqlKind;  
        intType = typeFactory.createSqlType(SqlTypeName.INTEGER);  
    }
 * ranges; DataFusion's substrait consumer doesn't recognize {@code Sarg} as a  
        if (isSearch(node)) return false;
                if (!containsNoSearchOrSarg(operand)) return false;
     */
        Sarg<BigDecimal> sarg = Sarg.of(org.apache.calcite.rex.RexUnknownAs.UNKNOWN, ImmutableRangeSet.copyOf(rangeSet));
        rangeSet.add(Range.lessThan(BigDecimal.valueOf(1)));
        RexNode adapted = new SargAdapter().adapt(greaterThan, List.of(), cluster);
        cluster = RelOptCluster.create(planner, rexBuilder);
 * compatible open source license.
        RexNode sargLit = rexBuilder.makeSearchArgumentLiteral(sarg, intType);
    private static boolean containsNoSearchOrSarg(RexNode node) {
    public void testAdaptExpandsInListSearchAwayFromSearchOperator() {  
    private RexCall buildInListSearch() {
        rexBuilder = new RexBuilder(typeFactory);  
        if (node instanceof org.apache.calcite.rex.RexLiteral lit && lit.getValue() instanceof Sarg) {  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
 *
        typeFactory = new JavaTypeFactoryImpl();
        points.add(Range.singleton(BigDecimal.valueOf(1)));  
 * this file be licensed under the Apache-2.0 license or a
        RexNode xRef = rexBuilder.makeInputRef(intType, 0);  
     * anything that isn't SEARCH. Guards against collateral damage if the
 * Unit tests for {@link SargAdapter}. Calcite's {@code SEARCH(x, Sarg[...])} is a
    /** Builds {@code SEARCH(x, Sarg[(-inf..1), (1..2), (2..+inf)])} — the {@code x != 1 AND x != 2} shape. */
    public void testAdaptExpandsBetweenSearchAwayFromSearchOperator() {  
        assertSame("non-SEARCH input must pass through unmodified", greaterThan, adapted);  
    // ── helpers ────────────────────────────────────────────────────────────  
        RexNode sargLit = rexBuilder.makeSearchArgumentLiteral(sarg, intType);
    /**
        assertFalse("expansion must not leave a SEARCH call at the root", isSearch(adapted));
        RexNode tenLit = rexBuilder.makeLiteral(10, intType, false);
    public void setUp() throws Exception {  
        assertTrue(containsNoSearchOrSarg(adapted));
    /** Builds SEARCH(x, Sarg[{1, 2, 3}]) — the IN-list shape. */  
        assertFalse(isSearch(adapted));
import org.apache.calcite.rex.RexBuilder;
import com.google.common.collect.Range;
        RexCall original = buildInListSearch();
        Sarg<BigDecimal> sarg = Sarg.of(org.apache.calcite.rex.RexUnknownAs.UNKNOWN, ImmutableRangeSet.copyOf(points));  
import org.apache.calcite.rex.RexNode;
    public void testAdaptPassesThroughNonSearchCall() {
        Sarg<BigDecimal> sarg = Sarg.of(org.apache.calcite.rex.RexUnknownAs.UNKNOWN, ImmutableRangeSet.copyOf(rangeSet));
 * before the plan is serialized.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
 */  
     */
    }  
        points.add(Range.singleton(BigDecimal.valueOf(2)));
        RexCall greaterThan = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.GREATER_THAN, List.of(xRef, tenLit));
        rangeSet.add(Range.closed(BigDecimal.valueOf(1), BigDecimal.valueOf(10)));  
public class SargAdapterTests extends OpenSearchTestCase {
import org.apache.calcite.plan.hep.HepPlanner;
import com.google.common.collect.RangeSet;  
        RexNode xRef = rexBuilder.makeInputRef(intType, 0);  
    private static boolean isSearch(RexNode node) {
        rangeSet.add(Range.greaterThan(BigDecimal.valueOf(2)));
import java.math.BigDecimal;  
        assertFalse(isSearch(adapted));
        rangeSet.add(Range.open(BigDecimal.valueOf(1), BigDecimal.valueOf(2)));  
import org.apache.calcite.rel.type.RelDataType;  
        super.setUp();
