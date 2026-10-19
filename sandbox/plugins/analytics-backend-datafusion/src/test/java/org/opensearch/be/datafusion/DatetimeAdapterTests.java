        RexCall call = (RexCall) adapted;
    }
    public void testSingleArgInvalidLiteralFoldsToNullTimestamp() {
        RexNode ts = rexBuilder.makeLiteral("2008-12-25 05:30:00-05:00");
        RexNode wrapped = call.getOperands().get(0);
        RexNode columnRef = rexBuilder.makeInputRef(varchar, 0);
    public void testSingleArgVarcharIsWrappedInRegexpReplace() {  
        // DATETIME(column, '+10:00') — non-literal first arg → convert_tz wrap.  
    );
 */  
 * compatible open source license.
        assertTrue("invalid month=13 must fold to NULL", lit.isNull());  
    }  
        assertSame(DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP, call.getOperator());  
    public void testTwoArgColumnInputRewritesToConvertTz() {
        SqlKind.OTHER_FUNCTION,
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
    private static final SqlFunction DATETIME_OP = new SqlFunction(  
        // DATETIME(valid-string, '+15:00') — invalid tz → NULL TIMESTAMP literal.  
 * The OpenSearch Contributors require contributions made to  
        assertSame(ConvertTzAdapter.LOCAL_CONVERT_TZ_OP, ((RexCall) adapted).getOperator());  
        RexCall call = (RexCall) adapted;
        RexNode adapted = adapter.adapt(original, List.of(), cluster);  
        SqlFunctionCategory.TIMEDATE  
 */
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.SqlKind;  
        assertEquals(SqlTypeName.TIMESTAMP, adapted.getType().getSqlTypeName());
    }  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        RexNode tz = rexBuilder.makeLiteral("+05:00");
        assertTrue(wrapped instanceof RexCall);
    public void testSingleArgTimestampPassesThroughUnwrapped() {  
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.sql.type.OperandTypes;
import org.opensearch.test.OpenSearchTestCase;
        RexNode arg = rexBuilder.makeLiteral("2021-13-03 10:00:00");
        assertTrue(adapted instanceof org.apache.calcite.rex.RexLiteral);
        RexNode tz = rexBuilder.makeLiteral("+15:00");
import org.apache.calcite.rex.RexNode;  
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        assertSame(DateTimeAdapters.LOCAL_TO_TIMESTAMP_OP, call.getOperator());
import java.util.List;
 *
        OperandTypes.ANY,
    }
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        "DATETIME",
        null,
        rexBuilder = new RexBuilder(typeFactory);
    /** 1-arg DATETIME('2021-13-03 10:00:00') folds to typed NULL TIMESTAMP via tryFoldInvalidLiteralToNull. */  
        ReturnTypes.TIMESTAMP,  
        // DATETIME('2008-12-25 05:30:00-05:00', '+05:00') = '2008-12-25 15:30:00'.  
import org.apache.calcite.rel.type.RelDataType;
        assertTrue(adapted instanceof RexCall);  
    private RexBuilder rexBuilder;
        RexNode arg = rexBuilder.makeAbstractCast(timestampType, rexBuilder.makeLiteral("2020-01-01 00:00:00"));
package org.opensearch.be.datafusion;
import org.apache.calcite.plan.hep.HepPlanner;  
 * SPDX-License-Identifier: Apache-2.0
        RexCall original = (RexCall) rexBuilder.makeCall(DATETIME_OP, List.of(columnRef, tz));
        super.setUp();
import org.apache.calcite.sql.SqlFunctionCategory;
        // Non-string operand passes through to to_timestamp without regexp_replace.
        RexCall original = (RexCall) rexBuilder.makeCall(DATETIME_OP, List.of(arg));  
    public void setUp() throws Exception {
        RelDataType timestampType = typeFactory.createSqlType(SqlTypeName.TIMESTAMP, 3);
        RexNode arg = rexBuilder.makeLiteral("2008-01-01 02:00:00+10:00");
import org.apache.calcite.sql.type.ReturnTypes;  
        assertTrue(((org.apache.calcite.rex.RexLiteral) adapted).isNull());
        assertSame(arg, call.getOperands().get(0));
        typeFactory = new JavaTypeFactoryImpl();  
        assertTrue(adapted instanceof RexCall);
import org.apache.calcite.plan.hep.HepProgramBuilder;
import org.apache.calcite.plan.RelOptCluster;
        assertTrue(adapted instanceof org.apache.calcite.rex.RexLiteral);
        RexCall original = (RexCall) rexBuilder.makeCall(DATETIME_OP, List.of(arg));
import org.apache.calcite.rex.RexBuilder;
        assertTrue(adapted instanceof RexCall);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
public class DatetimeAdapterTests extends OpenSearchTestCase {
    }  
import org.apache.calcite.sql.SqlFunction;
/*  
        RexCall original = (RexCall) rexBuilder.makeCall(DATETIME_OP, List.of(arg));  
 * Covers DatetimeAdapter: 1-arg VARCHAR strips offset; 1-arg non-string passes through;
 * 2-arg literal-literal folds to a typed TIMESTAMP literal (or NULL on bad input);
    private DateTimeAdapters.DatetimeAdapter adapter;
        RexNode ts = rexBuilder.makeLiteral("2008-01-01 02:00:00+10:00");
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testTwoArgLiteralLiteralFoldsToTimestampLiteral() {
 * this file be licensed under the Apache-2.0 license or a
        RexCall original = (RexCall) rexBuilder.makeCall(DATETIME_OP, List.of(ts, tz));  
        assertSame(SqlLibraryOperators.REGEXP_REPLACE_3, ((RexCall) wrapped).getOperator());  
    }
    @Override  
        RexCall original = (RexCall) rexBuilder.makeCall(DATETIME_OP, List.of(ts, tz));  
    }
    private RelDataTypeFactory typeFactory;
        adapter = new DateTimeAdapters.DatetimeAdapter();  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        assertTrue(adapted instanceof org.apache.calcite.rex.RexLiteral);
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        org.apache.calcite.rex.RexLiteral lit = (org.apache.calcite.rex.RexLiteral) adapted;
        RexNode tz = rexBuilder.makeLiteral("+10:00");  
        assertEquals(SqlTypeName.TIMESTAMP, lit.getType().getSqlTypeName());
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
 * 2-arg with column input rewrites to convert_tz wrapping.  
}  
/**  
    public void testTwoArgInvalidTzFoldsToNull() {
    private RelOptCluster cluster;  
        cluster = RelOptCluster.create(new HepPlanner(new HepProgramBuilder().build()), rexBuilder);
