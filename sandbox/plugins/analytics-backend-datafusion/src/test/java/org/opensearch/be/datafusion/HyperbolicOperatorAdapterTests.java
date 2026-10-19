        assertSame(arg, adaptedCall.getOperands().get(0));
import org.apache.calcite.sql.type.ReturnTypes;  
import org.apache.calcite.sql.parser.SqlParserPos;
import org.apache.calcite.sql.validate.SqlUserDefinedFunction;
import org.apache.calcite.rex.RexCall;
        assertSame("non-SINH call must pass through unmodified", absCall, adapted);  
     */
 * arrive as {@link SqlUserDefinedFunction} UDF calls; the adapter rewrites them to  
 * recognises ({@link SqlLibraryOperators#SINH}/{@link SqlLibraryOperators#COSH}),
    }
    @Override  
    }
        return new SqlUserDefinedFunction(
        RexNode arg = rexBuilder.makeInputRef(doubleType, 1);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
 * use the Calcite library operator that isthmus {@code FunctionMappings.SCALAR_SIGS}
 * functions that DataFusion's substrait consumer natively evaluates.
        assertSame("operand reference preserved", arg, adaptedCall.getOperands().get(0));  
import org.apache.calcite.sql.fun.SqlLibraryOperators;  
 * so the plan serialises to the standard Substrait {@code sinh}/{@code cosh}  
        typeFactory = new JavaTypeFactoryImpl();  
    private RexBuilder rexBuilder;  
 */  
            SqlKind.OTHER_FUNCTION,
        sinhUdf = fakeUdf("SINH");
        RexCall absCall = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.ABS, List.of(arg));
        RexNode adapted = new HyperbolicOperatorAdapter(SqlLibraryOperators.COSH).adapt(original, List.of(), cluster);
import org.apache.calcite.plan.hep.HepPlanner;  
}
            ReturnTypes.DOUBLE_NULLABLE,
 * compatible open source license.
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        super.setUp();
        RexCall adaptedCall = (RexCall) adapted;
    private RelDataTypeFactory typeFactory;
 * SPDX-License-Identifier: Apache-2.0
    public void testSinhUdfRewrittenToLibrarySinhOperator() {  
        assertEquals("SINH", original.getOperator().getName());  
     * against collateral damage if the adapter is registered against a  
        RexCall original = (RexCall) rexBuilder.makeCall(sinhUdf, List.of(arg));
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.rex.RexNode;  
import org.apache.calcite.plan.RelOptCluster;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(1, adaptedCall.getOperands().size());  
    /** Fake PPL-style UDF — same name and kind as PPLBuiltinOperators's SINH/COSH. */  
    public void testAdaptPassesThroughUnrelatedCall() {  
        rexBuilder = new RexBuilder(typeFactory);
    }
        doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
     * different {@code ScalarFunction} by mistake.
 *
    }
package org.opensearch.be.datafusion;
    private RelDataType doubleType;
     * Non-UDF calls (e.g. {@code ABS($0)}) must pass through untouched. Guards
    private RelOptCluster cluster;
            null,  
 * Unit tests for {@link HyperbolicOperatorAdapter}. PPL's {@code SINH}/{@code COSH}
        RexNode adapted = new HyperbolicOperatorAdapter(SqlLibraryOperators.SINH).adapt(absCall, List.of(), cluster);
import org.opensearch.test.OpenSearchTestCase;  
import org.apache.calcite.plan.hep.HepProgramBuilder;
        assertFalse("precondition: operator is PPL UDF, not the library operator", original.getOperator() == SqlLibraryOperators.SINH);
        RexNode arg = rexBuilder.makeInputRef(doubleType, 0);
        RexCall adaptedCall = (RexCall) adapted;  
    private SqlUserDefinedFunction sinhUdf;  
            new SqlIdentifier(name, SqlParserPos.ZERO),  
        RexNode arg = rexBuilder.makeInputRef(doubleType, 0);
 */
    }
        assertTrue("expected adapter to produce a RexCall", adapted instanceof RexCall);
    private SqlUserDefinedFunction coshUdf;
        RexCall original = (RexCall) rexBuilder.makeCall(coshUdf, List.of(arg));
            null
    public void setUp() throws Exception {
        assertTrue(adapted instanceof RexCall);  
import org.apache.calcite.sql.SqlIdentifier;
    /**
import org.apache.calcite.rel.type.RelDataType;
public class HyperbolicOperatorAdapterTests extends OpenSearchTestCase {  
        );  
        coshUdf = fakeUdf("COSH");  
        assertSame("operator must be SqlLibraryOperators.SINH after adaptation", SqlLibraryOperators.SINH, adaptedCall.getOperator());
import java.util.List;
        RexNode adapted = new HyperbolicOperatorAdapter(SqlLibraryOperators.SINH).adapt(original, List.of(), cluster);  
    public void testCoshUdfRewrittenToLibraryCoshOperator() {  
/**
        assertEquals("operand count preserved", 1, adaptedCall.getOperands().size());
/*  
        assertSame(SqlLibraryOperators.COSH, adaptedCall.getOperator());
            null,
import org.apache.calcite.sql.type.SqlTypeName;
 * this file be licensed under the Apache-2.0 license or a
    private SqlUserDefinedFunction fakeUdf(String name) {
import org.apache.calcite.rex.RexBuilder;
        cluster = RelOptCluster.create(planner, rexBuilder);  
