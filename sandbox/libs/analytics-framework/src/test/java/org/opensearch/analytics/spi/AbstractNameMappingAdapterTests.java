import org.apache.calcite.rex.RexCall;
        assertSame(b, adaptedCall.getOperands().get(1));
        );  
    public void testPrependLiteralOperand() {
        RexNode c = rexBuilder.makeInputRef(doubleType, 2);
        RexCall original = (RexCall) rexBuilder.makeCall(yearUdf, List.of(ts));  
import org.apache.calcite.sql.SqlFunctionCategory;
        RelDataType anyType = typeFactory.createSqlType(SqlTypeName.ANY);  
     * concrete. The adapter still rewrites to the target operator (SignumFunction lives in
import org.apache.calcite.rex.RexLiteral;
 *
            new SqlIdentifier(name, SqlParserPos.ZERO),  
        RexCall adaptedCall = (RexCall) adapted;  
        assertSame(ts, adaptedCall.getOperands().get(1));
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
    }  
            null,
    }
        assertSame(SqlLibraryOperators.GREATEST, adaptedCall.getOperator());
     * concrete return type inferrer) and the preserved DOUBLE type proves the happy path.  
    /**
        AbstractNameMappingAdapter adapter = new AbstractNameMappingAdapter(SqlStdOperatorTable.SQRT, List.of(), List.of()) {  
            null,  
 * Unit tests for {@link AbstractNameMappingAdapter}. Covers the basic rename path, the
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);  
 * serialisation fails with {@code Unable to convert the type ANY}.  
        assertTrue(adapted instanceof RexCall);
        RexCall original = (RexCall) rexBuilder.makeCall(udf, List.of(a, b));
 */  
            SqlTypeName.DOUBLE,  
import org.apache.calcite.rel.type.RelDataTypeFactory;
    }  
import org.apache.calcite.rel.type.RelDataType;
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        assertSame(SqlLibraryOperators.GREATEST, adaptedCall.getOperator());  
        assertSame(
 * this file be licensed under the Apache-2.0 license or a
    public void testSignLikeRewritePreservesConcreteType() {
        RexNode arg = rexBuilder.makeInputRef(doubleType, 0);  
     */
            opBinding -> returnType,
    public void testBasicRename() {  
import org.opensearch.test.OpenSearchTestCase;  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        );
    private static final class TestRenameAdapter extends AbstractNameMappingAdapter {
import org.apache.calcite.sql.SqlFunction;
    private SqlUserDefinedFunction pplUdf(String name, RelDataType returnType) {
        assertEquals(2, adaptedCall.getOperands().size());
            super(SqlLibraryOperators.GREATEST, List.of(), List.of());  
        };
import org.apache.calcite.sql.parser.SqlParserPos;
            SqlFunctionCategory.TIMEDATE  
import org.apache.calcite.sql.type.ReturnTypes;  
public class AbstractNameMappingAdapterTests extends OpenSearchTestCase {
        RexNode b = rexBuilder.makeInputRef(doubleType, 1);  
        RexNode adapted = new TestRenameAdapter().adapt(original, List.of(), cluster);  
        TestRenameAdapter() {
/**
 * PPL's {@code SCALAR_MAX} / {@code SCALAR_MIN}). Without the fallback, Substrait
        assertTrue(adaptedCall.getOperands().get(0) instanceof RexLiteral);  
            null
    }
        SqlUserDefinedFunction udf = pplUdf("SCALAR_MAX", anyType);
 * The OpenSearch Contributors require contributions made to  
        assertSame(a, adaptedCall.getOperands().get(0));  
        assertSame("DOUBLE return type must be preserved", SqlTypeName.DOUBLE, adaptedCall.getType().getSqlTypeName());
        RexCall adaptedCall = (RexCall) adapted;
        assertEquals("year", ((RexLiteral) adaptedCall.getOperands().get(0)).getValueAs(String.class));
            "YEAR",
        }
import org.apache.calcite.sql.type.OperandTypes;
        assertSame(SqlStdOperatorTable.SQRT, adaptedCall.getOperator());
            SqlKind.OTHER_FUNCTION,
    }  
    public void testAdaptFallsBackToTargetInferenceForAnyReturnType() {
        assertSame(SqlLibraryOperators.DATE_PART, adaptedCall.getOperator());
        );
package org.opensearch.analytics.spi;
    }
import org.apache.calcite.rex.RexBuilder;  
}
import java.util.List;
        RexNode ts = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.TIMESTAMP), 0);
            "ANY return type must be replaced with a concrete operand-derived type after rewrite",
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
 * that kicks in when the incoming PPL UDF declares an indeterminate return type (e.g.
 * compatible open source license.
            OperandTypes.ANY,
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.SIGN, List.of(arg));
import org.apache.calcite.sql.fun.SqlLibraryOperators;
import org.apache.calcite.sql.type.SqlTypeName;
        RexCall adaptedCall = (RexCall) adapted;
        RexCall adaptedCall = (RexCall) adapted;  
 * SPDX-License-Identifier: Apache-2.0
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
            ReturnTypes.BIGINT_NULLABLE,  
            null,
    /**
        assertSame(SqlTypeName.DOUBLE, adaptedCall.getType().getSqlTypeName());  
        RexCall original = (RexCall) rexBuilder.makeCall(udf, List.of(a, b, c));
        SqlFunction yearUdf = new SqlFunction(  
 */
        RexNode b = rexBuilder.makeInputRef(doubleType, 1);  
     * letting the target operator's own return-type inference run so the rewritten call
            SqlKind.OTHER_FUNCTION,
/*  
        assertEquals(2, adaptedCall.getOperands().size());
        SqlUserDefinedFunction udf = pplUdf("SCALAR_MAX", doubleType);
        return new SqlUserDefinedFunction(
        RexNode adapted = new TestRenameAdapter().adapt(original, List.of(), cluster);
        RexNode a = rexBuilder.makeInputRef(doubleType, 0);
import org.apache.calcite.sql.validate.SqlUserDefinedFunction;
 * prepend-literal form, and — most importantly — the {@link SqlTypeName#ANY} fallback  
import org.apache.calcite.sql.SqlIdentifier;  
     * carries a concrete type derived from the operands.  
        AbstractNameMappingAdapter adapter = new AbstractNameMappingAdapter(SqlLibraryOperators.DATE_PART, List.of("year"), List.of()) {
        assertSame("precondition: UDF return type must be ANY", SqlTypeName.ANY, original.getType().getSqlTypeName());  
     * {@link SqlTypeName#ANY}. Substrait cannot serialise ANY; the adapter must fall back to
import org.apache.calcite.plan.RelOptCluster;
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
    private final RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
        };  
     */
     * Pass-through for SIGN — a standard Calcite operator whose return type is already  
     * the backend; here we use SqlStdOperatorTable.SQRT as a stand-in target with a
import org.apache.calcite.sql.SqlKind;
     * PPL's {@code SCALAR_MAX} / {@code SCALAR_MIN} declare their return type as  
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
import org.apache.calcite.rex.RexNode;  
            adaptedCall.getType().getSqlTypeName()
        assertTrue(adapted instanceof RexCall);
    /** Minimal concrete subclass for tests — pure rename, no prepend/append. */  
        RexNode a = rexBuilder.makeInputRef(doubleType, 0);
