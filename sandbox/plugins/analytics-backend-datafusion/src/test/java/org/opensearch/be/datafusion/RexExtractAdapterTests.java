    }
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
        RexNode pattern = rexBuilder.makeLiteral("(?<g>\\w+)");  
        RexNode group = rexBuilder.makeLiteral("g");  
     * adapter is keyed on {@link org.opensearch.analytics.spi.ScalarFunction}  
        RexNode patternColRef = rexBuilder.makeInputRef(varcharType, 1);
        RexCall original = (RexCall) rexBuilder.makeCall(INCOMING_REX_EXTRACT, List.of(field, pattern, groupColRef));
    /**
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
        cluster = RelOptCluster.create(planner, rexBuilder);  
            RexExtractAdapter.LOCAL_REX_EXTRACT_OP,
        );  
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        RexCall original = (RexCall) rexBuilder.makeCall(INCOMING_REX_EXTRACT, List.of(field, pattern, group));
 */  
import org.apache.calcite.rex.RexCall;
        RexNode groupColRef = rexBuilder.makeInputRef(varcharType, 1);
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.plan.hep.HepProgramBuilder;
        super.setUp();
/**  
        SqlKind.OTHER_FUNCTION,  
        assertSame("group literal passed through", group, result.getOperands().get(2));
    }  
 * compatible open source license.
import org.apache.calcite.rex.RexNode;  
        RexNode group = rexBuilder.makeLiteral("g");
    public void testAdaptRejectsColumnRefGroup() {
        // catch this, but the adapter has its own arity check as a defense.  
        // Column-valued pattern would force per-row regex compilation on the
            e.getMessage().contains("'group' must be a string literal")
        SqlFunctionCategory.STRING
    }
    }
        assertTrue(
public class RexExtractAdapterTests extends OpenSearchTestCase {
     * {@code PPLBuiltinOperators.REX_EXTRACT} lives in the SQL plugin and isn't
        assertTrue("adapted is a RexCall", adapted instanceof RexCall);  
import org.opensearch.test.OpenSearchTestCase;
        );
    @Override  
            "error message names the rejected operand: " + e.getMessage(),  
        RexNode pattern = rexBuilder.makeLiteral("(?<g>\\w+)");  
        );
        assertSame("input operand passed through", field, result.getOperands().get(0));
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.apache.calcite.sql.SqlKind;  
import org.apache.calcite.plan.hep.HepPlanner;  
        typeFactory = new JavaTypeFactoryImpl();  
     * exercises the same code path.
 *
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> adapter.adapt(original, List.of(), cluster));  
 * not as a silent NULL row at runtime.
    public void testAdaptRejectsColumnRefPattern() {
        null,
    private final RexExtractAdapter adapter = new RexExtractAdapter();
import org.apache.calcite.sql.SqlFunctionCategory;
        assertSame("pattern literal passed through", pattern, result.getOperands().get(1));  
        rexBuilder = new RexBuilder(typeFactory);
        OperandTypes.STRING_STRING_STRING,  
import org.apache.calcite.rel.type.RelDataType;
            "error message names the rejected operand: " + e.getMessage(),
            e.getMessage().contains("'pattern' must be a string literal")  
        assertTrue(
    private RelOptCluster cluster;
        RexCall original = (RexCall) rexBuilder.makeCall(INCOMING_REX_EXTRACT, List.of(field, patternColRef, group));
        "REX_EXTRACT",
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.sql.SqlOperator;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> adapter.adapt(original, List.of(), cluster));  
        varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        // Rust side. The adapter must reject this at plan time.  
 * SPDX-License-Identifier: Apache-2.0
 * {@link RexExtractAdapter#validateLiteral} helper used by the multi/offset
import org.apache.calcite.sql.type.SqlTypeName;
    private static final SqlOperator INCOMING_REX_EXTRACT = new SqlFunction(
import java.util.List;
}  
package org.opensearch.be.datafusion;
import org.apache.calcite.sql.type.OperandTypes;
    );
 * this file be licensed under the Apache-2.0 license or a
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);  
        RexNode pattern = rexBuilder.makeLiteral("(?<g>\\w+)");
import org.apache.calcite.plan.RelOptCluster;
        RexCall result = (RexCall) adapted;
    private RexBuilder rexBuilder;
     * Synthetic SQL plugin operator stand-in. The real  
    public void testAdaptRewritesToLocalOpAndPreservesOperands() {
    public void setUp() throws Exception {
    private RelDataTypeFactory typeFactory;  
            "operator rewritten to local rex_extract op so FunctionMappings.s fires",  
    public void testAdaptRejectsWrongOperandCount() {
        assertEquals("operand count preserved", 3, result.getOperands().size());
 * adapters. Pins the literal-only-pattern contract: a column-valued pattern  
/*  
    }
            result.getOperator()
        ReturnTypes.VARCHAR_2000_NULLABLE,
    private RelDataType varcharType;  
 * Unit tests for {@link RexExtractAdapter} and the shared
        // 2 operands instead of 3 — the SqlFunction signature would normally
import org.apache.calcite.sql.type.ReturnTypes;  
     * a build-time dep of analytics-backend-datafusion — the production
     * (matched by name), so any {@code SqlFunction} named {@code "REX_EXTRACT"}
     */  
        assertSame(
import org.apache.calcite.sql.SqlFunction;
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
 * or group must surface as an {@code IllegalArgumentException} at plan time,
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> adapter.adapt(original, List.of(), cluster));
        assertTrue(e.getMessage().contains("expected 3 operands"));
 */  
        RexCall original = (RexCall) rexBuilder.makeCall(INCOMING_REX_EXTRACT, List.of(field, pattern));
