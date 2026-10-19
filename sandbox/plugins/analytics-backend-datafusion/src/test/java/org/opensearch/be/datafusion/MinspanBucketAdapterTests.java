import org.apache.calcite.sql.type.ReturnTypes;
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
 * injection, preserves operand order and original call's RelDataType.
import org.apache.calcite.sql.type.SqlTypeFamily;  
        assertSame("arg 2 must be the original data_range operand", range, call.getOperands().get(2));
import org.apache.calcite.rex.RexNode;  
        assertEquals("minspan_bucket(v, ms, range, max) must preserve all 4 operands", 4, call.getOperands().size());
            SqlKind.OTHER_FUNCTION,
        );  
import org.opensearch.test.OpenSearchTestCase;  
package org.opensearch.be.datafusion;
/*  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
        RexCall original = (RexCall) rexBuilder.makeCall(minspanBucketOp, List.of(value, minSpan, range, max));
import org.apache.calcite.plan.RelOptCluster;
public class MinspanBucketAdapterTests extends OpenSearchTestCase {
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
            SqlFunctionCategory.USER_DEFINED_FUNCTION
            SqlKind.OTHER_FUNCTION,
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        RexNode minSpan = rexBuilder.makeInputRef(doubleNullable, 1);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        RexNode value = rexBuilder.makeInputRef(doubleNullable, 0);
    public void testAdaptedCallPreservesOriginalReturnType() {  
    }
        RexNode range = rexBuilder.makeInputRef(doubleNullable, 2);  
            OperandTypes.family(SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC),
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
        assertEquals(varchar2000Nullable, original.getType());  
 * Unit tests for {@link MinspanBucketAdapter} — pure rename cat-4 adapter.
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);  
import org.apache.calcite.sql.SqlFunction;
 */  
import org.apache.calcite.rex.RexBuilder;
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);  
        RexNode max = rexBuilder.makeInputRef(doubleNullable, 3);
import org.apache.calcite.sql.type.SqlTypeName;
     * identical contract to {@link SpanBucketAdapterTests#testAdaptedCallPreservesOriginalReturnType}.
import org.apache.calcite.sql.SqlKind;  
        RexNode range = rexBuilder.makeInputRef(doubleNullable, 2);  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.rel.type.RelDataType;
        RexNode max = rexBuilder.makeInputRef(doubleNullable, 3);
import org.apache.calcite.sql.type.OperandTypes;
}  
        assertSame("arg 1 must be the original min_span operand", minSpan, call.getOperands().get(1));  
     * Regression guard on {@link org.apache.calcite.rel.type.RelDataType} preservation —  
 *
        );  
        assertSame(
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
            ReturnTypes.explicit(varcharNullable),
            call.getOperator()
import org.apache.calcite.plan.hep.HepPlanner;  
            ReturnTypes.explicit(varchar2000Nullable),
import org.apache.calcite.plan.hep.HepProgramBuilder;
 * SPDX-License-Identifier: Apache-2.0
/**
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
            "MINSPAN_BUCKET",  
            null,  
 */  
 * compatible open source license.
            "adapted call must target the locally-declared minspan_bucket operator",  
        assertEquals("adapted call's return type must equal the original call's return type", original.getType(), adapted.getType());
import org.apache.calcite.sql.SqlFunctionCategory;
        assertSame("arg 0 must be the original value operand", value, call.getOperands().get(0));
        RelDataType varchar2000Nullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR, 2000), true);
        RexCall original = (RexCall) rexBuilder.makeCall(minspanBucketOp, List.of(value, minSpan, range, max));
    }  
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);  
    /**
        RexNode adapted = new MinspanBucketAdapter().adapt(original, List.of(), cluster);
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RexCall call = (RexCall) adapted;
            null,  
        SqlFunction minspanBucketOp = new SqlFunction(
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        SqlFunction minspanBucketOp = new SqlFunction(
            "MINSPAN_BUCKET",  
        );  
        RexNode minSpan = rexBuilder.makeInputRef(doubleNullable, 1);
        RexNode value = rexBuilder.makeInputRef(doubleNullable, 0);
 * operands, pure rename via {@link AbstractNameMappingAdapter}, no literal
            OperandTypes.family(SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC, SqlTypeFamily.NUMERIC),
        RexNode adapted = new MinspanBucketAdapter().adapt(original, List.of(), cluster);
     */
 * this file be licensed under the Apache-2.0 license or a
    public void testMinspanBucketRewritesToLocalOperator() {  
 * Identical in shape to {@link WidthBucketAdapterTests}: four numeric  
            MinspanBucketAdapter.LOCAL_MINSPAN_BUCKET_OP,
        assertSame("arg 3 must be the original max_value operand", max, call.getOperands().get(3));
import org.apache.calcite.rex.RexCall;
