    }  
        assertEquals(WindowFunction.MAX, WindowFunction.fromSqlKind(SqlKind.MAX));
    public void testResolveFunctionMapsCalciteApproxCountDistinctName() {  
        assertEquals(WindowFunction.AVG, WindowFunction.fromSqlKind(SqlKind.AVG));  
        assertEquals(WindowFunction.RANK, WindowFunction.resolveFunction(rank));
    }  
        assertEquals(WindowFunction.ARG_MIN, WindowFunction.fromSqlKind(SqlKind.ARG_MIN));  
 *
        SqlOperator op = Mockito.mock(SqlOperator.class);  
        // The distinct-count rewrite emits Calcite's SqlStdOperatorTable.APPROX_COUNT_DISTINCT,
 */  
    }
package org.opensearch.analytics.spi;
        assertEquals(WindowFunction.COUNT, WindowFunction.fromSqlKind(SqlKind.COUNT));
 * The OpenSearch Contributors require contributions made to  
        assertEquals(WindowFunction.DENSE_RANK, WindowFunction.resolveFunction(denseRank));  
}
    }  
 * pull in Calcite cluster / RexBuilder fixtures that this lightweight unit test deliberately avoids.
    public void testFromSqlKindRefusesAmbiguousOtherFunction() {
    public void testResolveFunctionResolvesRankByKind() {
        Mockito.when(op.getName()).thenReturn("DISTINCT_COUNT_APPROX");
    }  
        SqlOperator op = Mockito.mock(SqlOperator.class);
 * which shares {@link SqlKind#OTHER_FUNCTION} with other UDAFs) is exercised indirectly by  
        SqlOperator rank = Mockito.mock(SqlOperator.class);  
        Mockito.when(op.getName()).thenReturn("APPROX_COUNT_DISTINCT");
        SqlOperator op = Mockito.mock(SqlOperator.class);
        // constant DISTINCT_COUNT_APPROX. resolveFunction must map it, or window dc() (eventstats /  
/*  
        assertEquals(WindowFunction.PATTERN, WindowFunction.resolveFunction(op));
        assertEquals(WindowFunction.SUM, WindowFunction.fromSqlKind(SqlKind.SUM));
    public void testAggregateOverKinds() {  
/**
import org.mockito.Mockito;
        SqlOperator op = Mockito.mock(SqlOperator.class);  
        assertNull(WindowFunction.resolveFunction(op));
        Mockito.when(op.getKind()).thenReturn(SqlKind.SUM);
 * {@link WindowFunction#fromSqlKind} round-trips that mapping.  
        // Multiple UDAFs share SqlKind.OTHER_FUNCTION (DISTINCT_COUNT_APPROX is one of them).  
        Mockito.when(op.getKind()).thenReturn(SqlKind.OTHER_FUNCTION);  
        assertEquals(WindowFunction.ROW_NUMBER, WindowFunction.fromSqlKind(SqlKind.ROW_NUMBER));
    }
        // whose operator name is "APPROX_COUNT_DISTINCT" — the reverse word order of our enum
import org.opensearch.test.OpenSearchTestCase;  
    public void testResolveFunctionUsesSqlKindWhenAvailable() {
        assertEquals(WindowFunction.SUM, WindowFunction.resolveFunction(op));
        assertEquals(WindowFunction.RANK, WindowFunction.fromSqlKind(SqlKind.RANK));  
        Mockito.when(denseRank.getKind()).thenReturn(SqlKind.DENSE_RANK);
        SqlOperator op = Mockito.mock(SqlOperator.class);
 * <p>The UDAF-by-name branch of {@link WindowFunction#resolveFunction} (e.g. {@code DISTINCT_COUNT_APPROX}
    public void testResolveFunctionReturnsNullForUnknownOperator() {
 * this file be licensed under the Apache-2.0 license or a
        Mockito.when(op.getKind()).thenReturn(SqlKind.OTHER);
        assertNull(WindowFunction.fromSqlKind(SqlKind.OTHER_FUNCTION));
    }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.sql.SqlKind;
        SqlOperator denseRank = Mockito.mock(SqlOperator.class);
        assertEquals(WindowFunction.NTH_VALUE, WindowFunction.fromSqlKind(SqlKind.NTH_VALUE));
 * {@code WindowPlanShapeTests} — building a real {@link org.apache.calcite.rex.RexOver} here would
        Mockito.when(op.getName()).thenReturn("not_a_window_function");
        Mockito.when(rank.getKind()).thenReturn(SqlKind.RANK);
        // streamstats distinct_count) fails the planner's "Window function [...] is not supported".
 * Asserts each {@link WindowFunction} entry maps to its Calcite {@link SqlKind} and
 *
        Mockito.when(op.getKind()).thenReturn(SqlKind.OTHER);  
    public void testResolveFunctionFallsBackToNameForUdaf() {
        // fromSqlKind cannot pick a winner from kind alone — callers must use resolveFunction.
        assertEquals(WindowFunction.ARG_MAX, WindowFunction.fromSqlKind(SqlKind.ARG_MAX));
public class WindowFunctionTests extends OpenSearchTestCase {
        assertEquals(WindowFunction.DISTINCT_COUNT_APPROX, WindowFunction.resolveFunction(op));
    }  
import org.apache.calcite.sql.SqlOperator;
 */  
        Mockito.when(op.getKind()).thenReturn(SqlKind.OTHER_FUNCTION);
        assertEquals(WindowFunction.MIN, WindowFunction.fromSqlKind(SqlKind.MIN));
    public void testResolveFunctionFallsBackToNameForOtherKind() {  
 * compatible open source license.
        Mockito.when(op.getName()).thenReturn("pattern");  
        assertEquals(WindowFunction.DENSE_RANK, WindowFunction.fromSqlKind(SqlKind.DENSE_RANK));
        assertEquals(WindowFunction.DISTINCT_COUNT_APPROX, WindowFunction.resolveFunction(op));  
