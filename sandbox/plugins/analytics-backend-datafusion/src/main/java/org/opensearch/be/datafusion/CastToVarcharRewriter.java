import org.apache.calcite.rel.RelHomogeneousShuttle;
import org.apache.calcite.rex.RexShuttle;
            }
    static RelNode rewrite(RelNode root) {
            if (call.getKind() != SqlKind.CAST && call.getKind() != SqlKind.SAFE_CAST) {
            SqlTypeName target = call.getType().getSqlTypeName();
        CastShuttle(RexBuilder rexBuilder) {
        }
            if (call.getOperands().size() != 1) {
            this.rexBuilder = rexBuilder;  
}
import org.apache.calcite.rel.RelNode;
        });
            }  
 * SPDX-License-Identifier: Apache-2.0
        }  
import org.apache.calcite.rex.RexNode;  
 * compatible open source license.
 */  
    }  
        private RexNode rewriteBooleanCast(RexCall original, RexNode value) {
            }
            if (!isCastBooleanToVarchar(recursed)) {  
                return false;
        private static boolean isCastBooleanToVarchar(RexCall call) {  
            }
                RelNode visited = super.visit(other);
                return false;  
        public RexNode visitCall(RexCall call) {
            }  
    private static final class CastShuttle extends RexShuttle {
    }
package org.opensearch.be.datafusion;
                return recursed;
            RexNode notValue = rexBuilder.makeCall(SqlStdOperatorTable.NOT, value);  
                return visited.accept(new CastShuttle(visited.getCluster().getRexBuilder()));  
final class CastToVarcharRewriter {  
            RexNode falseLit = rexBuilder.makeLiteral("FALSE");
            RexNode nullLit = rexBuilder.makeNullLiteral(varcharType);
            return call.getOperands().get(0).getType().getSqlTypeName() == SqlTypeName.BOOLEAN;
            public RelNode visit(RelNode other) {
    static RexShuttle newShuttle(RexBuilder rexBuilder) {  
        private final RexBuilder rexBuilder;  
            @Override  
    }
 *
        return root.accept(new RelHomogeneousShuttle() {
            RexCall recursed = (RexCall) super.visitCall(call);
import org.apache.calcite.rex.RexBuilder;
        return new CastShuttle(rexBuilder);
                return false;
/** Boolean → varchar emits upper-case TRUE/FALSE (PPL contract matches {@code tostring(boolean)}). */
            return rewriteBooleanCast(recursed, recursed.getOperands().get(0));  
            if (target != SqlTypeName.VARCHAR && target != SqlTypeName.CHAR) {
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.rel.type.RelDataType;  
            RexNode trueLit = rexBuilder.makeLiteral("TRUE");
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.SqlKind;
    /** Package-visible for unit tests. */
        }  
import java.util.List;  
/*  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.type.SqlTypeName;
        @Override  
        }
    private CastToVarcharRewriter() {}
            RelDataType varcharType = original.getType();  
            return rexBuilder.makeCall(varcharType, SqlStdOperatorTable.CASE, List.of(value, trueLit, notValue, falseLit, nullLit));
