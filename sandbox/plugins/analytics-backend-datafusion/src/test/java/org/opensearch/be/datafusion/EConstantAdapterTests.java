 * Unit tests for {@link EConstantAdapter}. PPL's {@code E()} UDF has zero operands  
            null,
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
            null
 * through Substrait as a literal expression.
import org.apache.calcite.plan.hep.HepProgramBuilder;
    @Override
        cluster = RelOptCluster.create(planner, rexBuilder);
        assertEquals("literal type must be DOUBLE", SqlTypeName.DOUBLE, lit.getType().getSqlTypeName());  
package org.opensearch.be.datafusion;
import org.apache.calcite.sql.type.ReturnTypes;  
        BigDecimal value = lit.getValueAs(BigDecimal.class);  
 * this file be licensed under the Apache-2.0 license or a
    }
    }  
        assertTrue("expected adapter to return a literal", adapted instanceof RexLiteral);
}
    private RexBuilder rexBuilder;  
        RexNode adapted = new EConstantAdapter().adapt(absCall, List.of(), cluster);
import org.apache.calcite.sql.parser.SqlParserPos;
        RexLiteral lit = (RexLiteral) adapted;
        RexNode ref = rexBuilder.makeInputRef(doubleType, 0);
            new SqlIdentifier("E", SqlParserPos.ZERO),
    public void testAdaptPassesThroughUnrelatedCall() {  
 * and evaluates to Euler's number. DataFusion has no matching scalar function, but
        eUdf = new SqlUserDefinedFunction(
    }
        super.setUp();
    private RelOptCluster cluster;
import org.apache.calcite.rel.type.RelDataType;
import org.apache.calcite.rex.RexBuilder;
/*  
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.sql.validate.SqlUserDefinedFunction;
            null,  
import java.math.BigDecimal;
        doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);  
 * constant folding is cheap on the coordinator — the adapter rewrites the UDF call
import org.apache.calcite.plan.hep.HepPlanner;  
import org.apache.calcite.sql.SqlKind;  
 * SPDX-License-Identifier: Apache-2.0
            SqlKind.OTHER_FUNCTION,  
import org.opensearch.test.OpenSearchTestCase;  
        assertNotNull(value);
 *
import java.util.List;  
    public void setUp() throws Exception {  
 */
import org.apache.calcite.rex.RexLiteral;  
        RexCall original = (RexCall) rexBuilder.makeCall(eUdf, List.of());  
import org.apache.calcite.sql.type.SqlTypeName;
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        RexCall absCall = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.ABS, List.of(ref));
        assertSame(absCall, adapted);  
    public void testEUdfRewrittenToMathELiteral() {
            ReturnTypes.DOUBLE,
 * compatible open source license.
        typeFactory = new JavaTypeFactoryImpl();
        assertEquals("literal must carry Math.E", 0, value.compareTo(BigDecimal.valueOf(Math.E)));
    private SqlUserDefinedFunction eUdf;  
import org.apache.calcite.sql.SqlIdentifier;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    private RelDataType doubleType;
public class EConstantAdapterTests extends OpenSearchTestCase {  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
 */  
        RexNode adapted = new EConstantAdapter().adapt(original, List.of(), cluster);
        );
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.rex.RexCall;
    private RelDataTypeFactory typeFactory;
/**
 * to a {@code DOUBLE} literal equal to {@link Math#E}, which serialises trivially  
        rexBuilder = new RexBuilder(typeFactory);  
