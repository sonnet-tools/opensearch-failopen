        RexNode operand = c.inputRef(0, SqlTypeName.TIMESTAMP);
    public void testBooleanCastRewritesToCaseUpper() {
        RexNode operand = c.inputRef(0, SqlTypeName.BOOLEAN);  
    }  
        RexNode out = plus.accept(CastToVarcharRewriter.newShuttle(c.rexBuilder));  
    /** Non-cast calls pass through. */
        assertEquals(SqlKind.CAST, out.getKind());  
        assertEquals("TRUE", ((RexLiteral) out.getOperands().get(1)).getValueAs(String.class));  
import org.opensearch.test.OpenSearchTestCase;
        RexNode inputRef(int index, SqlTypeName type) {
import org.apache.calcite.rel.type.RelDataType;
        RexNode operand = c.inputRef(0, SqlTypeName.INTEGER);  
    }  
            RelDataType targetType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(target), true);
    /** Unrelated casts (INT → VARCHAR) pass through. */  
        RexNode cast = c.castTo(operand, SqlTypeName.VARCHAR);
import org.apache.calcite.rex.RexNode;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
 * SPDX-License-Identifier: Apache-2.0
        final RexBuilder rexBuilder;
            this.rexBuilder = rexBuilder;
        return new Cluster(typeFactory, rexBuilder);
import org.apache.calcite.rex.RexBuilder;
package org.opensearch.be.datafusion;
 *
/*  
        RexNode cast = c.castTo(operand, SqlTypeName.VARCHAR);
        RexNode castTo(RexNode operand, SqlTypeName target) {  
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
 */  
        RexNode left = c.inputRef(0, SqlTypeName.INTEGER);
 * this file be licensed under the Apache-2.0 license or a
    }
    }
        Cluster c = newCluster();
        RexNode cast = c.castTo(operand, SqlTypeName.VARCHAR);
    }
import org.apache.calcite.sql.SqlKind;
    public void testNonCastCallPassesThrough() {  
public class CastToVarcharRewriterTests extends OpenSearchTestCase {
        }
import org.apache.calcite.rex.RexLiteral;  
 * The OpenSearch Contributors require contributions made to  
    public void testIntegerCastPassesThrough() {
        RexCall out = (RexCall) cast.accept(CastToVarcharRewriter.newShuttle(c.rexBuilder));  
    }  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.sql.type.SqlTypeName;
        }  
    private static final class Cluster {
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();  
        assertEquals("FALSE", ((RexLiteral) out.getOperands().get(3)).getValueAs(String.class));
            return rexBuilder.makeInputRef(typeFactory.createTypeWithNullability(typeFactory.createSqlType(type), true), index);  
        Cluster(RelDataTypeFactory typeFactory, RexBuilder rexBuilder) {  
        }  
        assertEquals(SqlKind.CASE, out.getKind());
 * compatible open source license.
import org.apache.calcite.rex.RexCall;
        RexNode plus = c.rexBuilder.makeCall(SqlStdOperatorTable.PLUS, left, right);
        Cluster c = newCluster();
        RexNode right = c.inputRef(1, SqlTypeName.INTEGER);  
    public void testTimestampCastPassesThrough() {
}
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        RexNode out = cast.accept(CastToVarcharRewriter.newShuttle(c.rexBuilder));  
        assertSame(plus, out);
        final RelDataTypeFactory typeFactory;  
        RexNode out = cast.accept(CastToVarcharRewriter.newShuttle(c.rexBuilder));
            return rexBuilder.makeCast(targetType, operand);
        Cluster c = newCluster();  
        assertEquals(SqlKind.CAST, out.getKind());
    /** CAST(boolean AS VARCHAR) → CASE WHEN val THEN 'TRUE' WHEN NOT val THEN 'FALSE' END. */  
    private static Cluster newCluster() {
        Cluster c = newCluster();
            this.typeFactory = typeFactory;
    /** Temporal casts pass through — handled by ArrowValues post-processing instead. */
