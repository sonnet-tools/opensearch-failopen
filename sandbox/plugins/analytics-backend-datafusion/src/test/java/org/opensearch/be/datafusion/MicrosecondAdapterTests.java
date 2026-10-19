package org.opensearch.be.datafusion;
    public void testMicrosecondRewrittenAsModOfDatePart() {
        assertSame("inside CAST must be MOD", SqlStdOperatorTable.MOD, modCall.getOperator());
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.sql.validate.SqlUserDefinedFunction;  
}
        assertSame("MOD's left operand must be date_part(...)", SqlLibraryOperators.DATE_PART, datePart.getOperator());
            List.of(rexBuilder.makeInputRef(intType, 0), rexBuilder.makeInputRef(intType, 1))  
        assertSame("outermost operator must be CAST", SqlStdOperatorTable.CAST, castCall.getOperator());
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        typeFactory = new JavaTypeFactoryImpl();  
    private RexBuilder rexBuilder;  
import org.apache.calcite.sql.SqlIdentifier;
import org.apache.calcite.rex.RexNode;
            null  
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.sql.fun.SqlLibraryOperators;
 * compatible open source license.
        RexCall original = (RexCall) rexBuilder.makeCall(intType, microsecondUdf, List.of(arg));  
        assertTrue("MOD's right operand must be a literal", modRight instanceof RexLiteral);
            null,
    private RelOptCluster cluster;
        assertEquals(2, datePart.getOperands().size());
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        cluster = RelOptCluster.create(planner, rexBuilder);  
 * sub-second microseconds (0..999_999), but DataFusion's {@code date_part('microsecond', x)}
    public void setUp() throws Exception {
        RexNode castOperand = castCall.getOperands().get(0);
    private SqlUserDefinedFunction microsecondUdf;
import org.apache.calcite.rel.type.RelDataType;
        RexCall twoArg = (RexCall) rexBuilder.makeCall(
        RexCall modCall = (RexCall) castOperand;  
        assertTrue("left operand of MOD must be a RexCall", modLeft instanceof RexCall);
        microsecondUdf = new SqlUserDefinedFunction(  
 *
        RexCall absCall = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.ABS, List.of(arg));  
        // TIMESTAMP operands are coerced to TIMESTAMP(6) so date_part keeps the µs fraction.
    @Override  
    }
import org.opensearch.test.OpenSearchTestCase;
        );
        assertTrue("outermost node must be a RexCall", adapted instanceof RexCall);
    private RelDataType timestampType;
    }
        // adapter only checks operand count. (The dispatch in DataFusionAnalyticsBackendPlugin
 * Unit tests for {@link MicrosecondAdapter}. PPL's {@code microsecond(x)} returns the  
        );
import org.apache.calcite.sql.type.ReturnTypes;
        assertTrue("date_part's second arg must wrap original in CAST", datePartArg instanceof RexCall);  
 * this file be licensed under the Apache-2.0 license or a
        assertSame("multi-arg calls pass through unchanged", twoArg, new MicrosecondAdapter().adapt(twoArg, List.of(), cluster));
import java.util.List;  
public class MicrosecondAdapterTests extends OpenSearchTestCase {  
 * The OpenSearch Contributors require contributions made to  
        rexBuilder = new RexBuilder(typeFactory);
import org.apache.calcite.sql.type.SqlTypeName;
        assertEquals(SqlTypeName.INTEGER, castCall.getType().getSqlTypeName());
            SqlStdOperatorTable.PLUS,
        intType = typeFactory.createSqlType(SqlTypeName.INTEGER);
        // gates by ScalarFunction.MICROSECOND, but we still want adapt() to be safe to  
import org.apache.calcite.rex.RexLiteral;  
        RexNode partLiteral = datePart.getOperands().get(0);
 */  
import org.apache.calcite.sql.parser.SqlParserPos;  
    private RelDataType intType;  
        RexNode arg = rexBuilder.makeInputRef(timestampType, 0);
        RexNode adapted = new MicrosecondAdapter().adapt(original, List.of(), cluster);
        assertTrue("date_part's first arg must be a literal", partLiteral instanceof RexLiteral);
        // The adapter unconditionally wraps any 1-arg call in MOD(date_part('microsecond', x), 1e6),
            new SqlIdentifier("MICROSECOND", SqlParserPos.ZERO),
import org.apache.calcite.plan.hep.HepPlanner;  
        RexNode modRight = modCall.getOperands().get(1);
            ReturnTypes.INTEGER_NULLABLE,  
        super.setUp();
        // so adapt() does rewrite. Verify the operand-count guard fires when arity is wrong.  
 * SPDX-License-Identifier: Apache-2.0
        assertSame("CAST's child must be the original timestamp arg", arg, ((RexCall) datePartArg).getOperands().get(0));
        // Expected tree: CAST(MOD(date_part('microsecond', arg), 1_000_000) AS INTEGER)
 */
        // Sanity: an unrelated single-arg call should not be rewritten, even though the
        RexCall datePart = (RexCall) modLeft;  
        RexNode modLeft = modCall.getOperands().get(0);
        assertEquals(1_000_000L, ((RexLiteral) modRight).getValueAs(Long.class).longValue());  
import org.apache.calcite.plan.hep.HepProgramBuilder;
 * call's declared return type, restoring PPL semantics.
/**
        timestampType = typeFactory.createSqlType(SqlTypeName.TIMESTAMP);
import org.apache.calcite.rex.RexCall;
    public void testAdaptLeavesUnaryNonMicrosecondCallAlone() {  
/*  
        assertEquals("microsecond", ((RexLiteral) partLiteral).getValueAs(String.class));  
        RexNode datePartArg = datePart.getOperands().get(1);
    }  
 * returns {@code seconds * 1_000_000 + microseconds} — Postgres semantics. The adapter
        // call directly on whatever the dispatcher hands it.)
            SqlKind.OTHER_FUNCTION,
        assertTrue("CAST operand must be a RexCall", castOperand instanceof RexCall);
import org.apache.calcite.sql.SqlKind;  
        assertEquals(2, modCall.getOperands().size());
        RexCall castCall = (RexCall) adapted;  
import org.apache.calcite.rex.RexBuilder;
    private RelDataTypeFactory typeFactory;
            null,
        RexNode arg = rexBuilder.makeInputRef(timestampType, 0);
 * wraps the {@code date_part} call with {@code MOD(..., 1_000_000)} and casts back to the  
        assertEquals(SqlKind.CAST, ((RexCall) datePartArg).getKind());
