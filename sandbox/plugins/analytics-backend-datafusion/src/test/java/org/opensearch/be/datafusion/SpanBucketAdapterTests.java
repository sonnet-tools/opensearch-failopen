                + "otherwise the enclosing Project.rowType assertion fails in fragment conversion",  
        RexNode spanRef = rexBuilder.makeInputRef(doubleNullable, 1);  
            SqlKind.OTHER_FUNCTION,
    }  
 * The OpenSearch Contributors require contributions made to  
            null,
import org.apache.calcite.sql.type.ReturnTypes;
public class SpanBucketAdapterTests extends OpenSearchTestCase {
    public void testSpanBucketRewritesToLocalOperator() {
     * carried from the PR10 audit lesson that motivated {@code UnixTimestampAdapterTests
        SqlFunction spanBucketOp = new SqlFunction(
        assertEquals("span_bucket(value, span) must have 2 operands — no injection", 2, call.getOperands().size());  
            "adapted call must target the locally-declared span_bucket operator (the Sig referent)",
 * {@code span_bucket} whose Sig resolves to the Rust UDF by name.
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RelDataType varcharNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
     * The adapter MUST preserve the original call's {@link RelDataType}. The  
import java.util.List;
     * The adapter rewrites {@code SPAN_BUCKET(value, span)} to the
        assertTrue("adapted node must be a RexCall, got " + adapted.getClass(), adapted instanceof RexCall);
import org.apache.calcite.plan.RelOptCluster;
        // LOCAL_SPAN_BUCKET_OP's declared ARG0-nullable inference. Without  
            OperandTypes.NUMERIC_NUMERIC,
 *
        assertSame("arg 1 must be the original span operand", spanRef, call.getOperands().get(1));
        );
 * this file be licensed under the Apache-2.0 license or a
            SpanBucketAdapter.LOCAL_SPAN_BUCKET_OP,  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
            SqlKind.OTHER_FUNCTION,  
        RexNode valueRef = rexBuilder.makeInputRef(doubleNullable, 0);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testAdaptedCallPreservesOriginalReturnType() {
/**  
     * locally-declared {@code span_bucket} operator, preserving both
import org.apache.calcite.plan.hep.HepProgramBuilder;
     */  
        RexNode adapted = new SpanBucketAdapter().adapt(original, List.of(), cluster);
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
}
 * SPDX-License-Identifier: Apache-2.0
            ReturnTypes.explicit(varchar2000Nullable),
        // PPL's SPAN_BUCKET returns VARCHAR(2000) — a distinct type from the
 */  
    /**
        RexCall original = (RexCall) rexBuilder.makeCall(spanBucketOp, List.of(valueRef, spanRef));
import org.apache.calcite.sql.type.SqlTypeName;  
 * exercising {@link AbstractNameMappingAdapter} (no literal injection).
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
 */  
            adapted.getType()
 * Unit tests for {@link SpanBucketAdapter} — pure rename cat-4 adapter
            SqlFunctionCategory.USER_DEFINED_FUNCTION
     * enclosing Project caches its rowType from the pre-adaptation expression;
        assertSame("arg 0 must be the original value operand", valueRef, call.getOperands().get(0));
 * compatible open source license.
    /**  
        RexNode valueRef = rexBuilder.makeInputRef(doubleNullable, 0);  
        );
/*  
import org.apache.calcite.plan.hep.HepPlanner;  
 * {@code SPAN_BUCKET} rewritten to our locally-declared lowercase
        assertSame(
            OperandTypes.NUMERIC_NUMERIC,  
        // Synthesize SPAN_BUCKET(numeric, numeric) — a two-arg Calcite call using
        assertEquals(
import org.apache.calcite.rex.RexBuilder;
     */
            call.getOperator()
        RexNode spanRef = rexBuilder.makeInputRef(doubleNullable, 1);
import org.apache.calcite.sql.SqlKind;  
        // a stand-in SqlFunction with the same name the PPL frontend emits.  
        // of VARCHAR(2000) and mismatch the enclosing Project's cached rowType.
 * Mirrors {@link ConvertTzAdapter}'s shape: PPL-emitted uppercase  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
     * compatibleTypes assertion during fragment conversion. Regression guard  
        RexNode adapted = new SpanBucketAdapter().adapt(original, List.of(), cluster);  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
package org.opensearch.be.datafusion;
     * .testAdaptedCallPreservesOriginalReturnType}.
            "SPAN_BUCKET",
        RexCall call = (RexCall) adapted;  
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);  
        );  
import org.apache.calcite.rex.RexNode;  
        assertEquals(varchar2000Nullable, original.getType());  
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.rel.type.RelDataType;
            original.getType(),
            SqlFunctionCategory.USER_DEFINED_FUNCTION  
        RelDataType varchar2000Nullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR, 2000), true);  
import org.apache.calcite.sql.SqlFunction;
     * operands unchanged (no prepend/append literals).  
        );
        SqlFunction spanBucketOp = new SqlFunction(  
        RexBuilder rexBuilder = new RexBuilder(typeFactory);  
import org.apache.calcite.rex.RexCall;
        // explicit preservation the adapted call would report DOUBLE instead
import org.apache.calcite.sql.SqlFunctionCategory;
            "adapted call's return type must equal the original call's return type, "
    }
            null,
        RelDataType doubleNullable = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true);
            "SPAN_BUCKET",
            ReturnTypes.explicit(varcharNullable),  
     * any Calcite-inferred-type drift breaks {@code Project.isValid}'s
        RelOptCluster cluster = RelOptCluster.create(planner, rexBuilder);
        RexCall original = (RexCall) rexBuilder.makeCall(spanBucketOp, List.of(valueRef, spanRef));
import org.apache.calcite.sql.type.OperandTypes;
