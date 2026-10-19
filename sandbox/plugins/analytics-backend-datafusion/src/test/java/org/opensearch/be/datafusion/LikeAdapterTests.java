        RexNode field = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0);  
public class LikeAdapterTests extends OpenSearchTestCase {
        RexNode field = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0);
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
 * {@code ilike} signatures, while leaving the operator (LIKE vs ILIKE) unchanged.  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.LIKE, List.of(field, pattern));  
        );
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.ILIKE, List.of(field, pattern, escape));  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlStdOperatorTable.LIKE, List.of(field, pattern, escape));
        assertEquals("3rd (escape) operand must be dropped", 2, adapted.getOperands().size());  
    }
import org.apache.calcite.sql.type.SqlTypeName;
 * Unit tests for {@link LikeAdapter} — verifies the adapter drops Calcite's default
 *
 */  
    public void testIlikeWithEscapeDropsEscapeAndKeepsIlikeOperator() {
 * 3rd (escape) operand so the call shape matches Substrait's 2-arg {@code like} /
        RexNode field = rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.VARCHAR), 0);
            SqlLibraryOperators.ILIKE,  
import org.apache.calcite.rex.RexBuilder;
        RexNode escape = rexBuilder.makeLiteral("\\");
    }
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
        RexNode pattern = rexBuilder.makeLiteral("%e%");
import org.apache.calcite.rex.RexCall;  
import org.apache.calcite.sql.fun.SqlLibraryOperators;
/**  
/*  
 * this file be licensed under the Apache-2.0 license or a
        RexCall adapted = (RexCall) new LikeAdapter().adapt(original, List.of(), cluster);  
package org.opensearch.be.datafusion;
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        RexNode escape = rexBuilder.makeLiteral("\\");  
        RexNode pattern = rexBuilder.makeLiteral("%e%");
            "ILIKE operator must be preserved so Isthmus can serialize it as ilike",
        assertSame("LIKE operator must be preserved", SqlStdOperatorTable.LIKE, adapted.getOperator());
import org.apache.calcite.rel.type.RelDataTypeFactory;
 */
        assertEquals("3rd (escape) operand must be dropped", 2, adapted.getOperands().size());  
        RexCall adapted = (RexCall) new LikeAdapter().adapt(original, List.of(), cluster);
    private final RelOptCluster cluster = RelOptCluster.create(new VolcanoPlanner(), rexBuilder);  
    public void testLikeWithEscapeDropsEscapeAndKeepsLikeOperator() {  
 * SPDX-License-Identifier: Apache-2.0
    private final RexBuilder rexBuilder = new RexBuilder(typeFactory);
        assertSame("2-arg LIKE should pass through unchanged", original, adapted);
import org.apache.calcite.plan.RelOptCluster;
        RexNode pattern = rexBuilder.makeLiteral("%e%");
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testTwoArgLikeIsReturnedUnchanged() {  
            adapted.getOperator()
        assertSame(
    }
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.plan.volcano.VolcanoPlanner;  
}  
        RexNode adapted = new LikeAdapter().adapt(original, List.of(), cluster);
