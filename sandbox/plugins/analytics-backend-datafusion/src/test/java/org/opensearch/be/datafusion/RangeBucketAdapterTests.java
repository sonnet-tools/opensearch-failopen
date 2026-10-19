public class RangeBucketAdapterTests extends OpenSearchTestCase {  
 *
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
            "RANGE_BUCKET",  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.sql.type.SqlTypeFamily;  
        assertSame(  
        assertSame("arg 2 must be the original data_max operand", dataMax, call.getOperands().get(2));
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        RexNode dataMax = rexBuilder.makeInputRef(doubleNullable, 2);
    }
        assertSame("arg 4 must be the original end_param (null literal)", endParam, call.getOperands().get(4));
            SqlFunctionCategory.USER_DEFINED_FUNCTION
            SqlKind.OTHER_FUNCTION,  
        assertEquals(varchar2000Nullable, original.getType());  
        RexNode startParam = rexBuilder.makeLiteral(-10.0, doubleNullable, true);  
            OperandTypes.family(SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.ANY, SqlTypeFamily.ANY),
            RangeBucketAdapter.LOCAL_RANGE_BUCKET_OP,
        );
 * 5 operands (two of which may be null literals for the optional
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
import org.apache.calcite.sql.type.ReturnTypes;
            ReturnTypes.explicit(varcharNullable),
import org.apache.calcite.plan.hep.HepPlanner;  
import org.apache.calcite.plan.RelOptCluster;
        RexCall call = (RexCall) adapted;
/**  
        );  
     * literals as-is.
        SqlFunction rangeBucketOp = new SqlFunction(
     */
            OperandTypes.family(SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.ANY, SqlTypeFamily.ANY),  
import org.apache.calcite.rex.RexBuilder;
            "adapted call must target the locally-declared range_bucket operator",
    /**
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
import org.apache.calcite.rex.RexNode;  
        assertEquals("adapted call's return type must equal the original call's return type", original.getType(), adapted.getType());
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        assertSame("arg 1 must be the original data_min operand", dataMin, call.getOperands().get(1));
        SqlFunction rangeBucketOp = new SqlFunction(
import org.apache.calcite.sql.type.SqlTypeName;
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);  
     * — identical contract to the other Group C adapters.  
     * the Rust UDF's asymmetric null handling (nulls in slots 3/4 are
            ReturnTypes.explicit(varchar2000Nullable),
            "RANGE_BUCKET",
        );
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
        assertEquals("range_bucket(v, min, max, start, end) must preserve all 5 operands", 5, call.getOperands().size());
 * Unit tests for {@link RangeBucketAdapter} — pure rename cat-4 adapter with
import org.opensearch.test.OpenSearchTestCase;
        RexNode dataMin = rexBuilder.makeInputRef(doubleNullable, 1);
 */
    }
            SqlKind.OTHER_FUNCTION,
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
import org.apache.calcite.sql.SqlKind;  
        RexNode dataMin = rexBuilder.makeInputRef(doubleNullable, 1);
            null,
import org.apache.calcite.sql.SqlFunctionCategory;
 * compatible open source license.
     * sentinels, not propagation triggers) depends on receiving the null  
        RexNode startParam = rexBuilder.constantNull();
        RexCall original = (RexCall) rexBuilder.makeCall(rangeBucketOp, List.of(value, dataMin, dataMax, startParam, endParam));  
 * start_param / end_param slots). Same pattern as {@link SpanBucketAdapterTests},  
/*  
    public void testRangeBucketRewritesToLocalOperatorPreservingAllFiveOperands() {  
 * this file be licensed under the Apache-2.0 license or a
            null,  
        RexNode dataMax = rexBuilder.makeInputRef(doubleNullable, 2);  
     * Regression guard on {@link org.apache.calcite.rel.type.RelDataType} preservation
     */
     * end_or_null)}. The adapter must forward all 5 operands unchanged —
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);  
import org.apache.calcite.plan.hep.HepProgramBuilder;
import java.util.List;
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
        RexNode adapted = new RangeBucketAdapter().adapt(original, List.of(), cluster);
import org.apache.calcite.sql.type.OperandTypes;
 */  
    public void testAdaptedCallPreservesOriginalReturnType() {
        RexNode value = rexBuilder.makeInputRef(doubleNullable, 0);  
        assertSame("arg 3 must be the original start_param (null literal)", startParam, call.getOperands().get(3));  
import org.apache.calcite.sql.SqlFunction;
import org.apache.calcite.rel.type.RelDataType;
}  
import org.apache.calcite.rex.RexCall;
        assertSame("arg 0 must be the original value operand", value, call.getOperands().get(0));  
        RexNode endParam = rexBuilder.makeLiteral(110.0, doubleNullable, true);
        RexNode value = rexBuilder.makeInputRef(doubleNullable, 0);
        RelDataType varchar2000Nullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR, 2000), true);  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
    /**
        RexNode endParam = rexBuilder.constantNull();
 * {@link WidthBucketAdapterTests}, {@link MinspanBucketAdapterTests}.
 * The OpenSearch Contributors require contributions made to  
        RexNode adapted = new RangeBucketAdapter().adapt(original, List.of(), cluster);
            call.getOperator()  
package org.opensearch.be.datafusion;
     * PPL emits {@code RANGE_BUCKET(value, min, max, start_or_null,  
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        RexCall original = (RexCall) rexBuilder.makeCall(rangeBucketOp, List.of(value, dataMin, dataMax, startParam, endParam));
