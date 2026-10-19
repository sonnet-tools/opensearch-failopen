            int firstArg = "TIMESTAMPADD".equalsIgnoreCase(name) ? 2 : 1;
                DatetimeLiteralValidator.Kind kind = kindForTarget(recursed.getType().getSqlTypeName());
        private static DatetimeLiteralValidator.Kind kindForTarget(SqlTypeName target) {  
                    DatetimeLiteralValidator.validate(recursed.getOperands().get(0), kind);  
                return;  
/** Pre-isthmus pass that rejects malformed CAST(string-lit AS DATE/TIME/TIMESTAMP) and TIMESTAMPADD/DIFF string args. */
        });
                }
            }
            if (!"TIMESTAMPADD".equalsIgnoreCase(name) && !"TIMESTAMPDIFF".equalsIgnoreCase(name)) {
                RexNode operand = call.getOperands().get(i);
        return new ValidatingShuttle();
 */  
                return false;
    static RexShuttle newShuttle() {  
            return SqlTypeName.CHAR_TYPES.contains(literal.getType().getSqlTypeName());  
        }  
                if (kind != null) {
    static RelNode rewrite(RelNode root) {
            @Override  
 *
                return recursed;
            }
        private static boolean isCastFromString(RexCall call) {
        }
        private static void validateTimestampAddDiffOperands(RexCall call) {  
    }
            public RelNode visit(RelNode other) {
import org.apache.calcite.sql.type.SqlTypeName;
                RelNode visited = super.visit(other);
import org.apache.calcite.rel.RelHomogeneousShuttle;
package org.opensearch.be.datafusion;
        @Override  
            RexCall recursed = (RexCall) super.visitCall(call);
            if (isCastFromString(recursed)) {  
            if (call.getKind() != SqlKind.CAST && call.getKind() != SqlKind.SAFE_CAST) {  
    /** Test-only entry point; production goes through {@link #rewrite}. */
    }
            }
                    DatetimeLiteralValidator.validate(operand, DatetimeLiteralValidator.Kind.TIMESTAMP);  
        public RexNode visitCall(RexCall call) {
                default -> null;
        /** Substrait can't bind TIMESTAMPADD/DIFF over string args; pre-validate so the user sees the format-hint, not "Unable to convert call". */
                }
                case TIMESTAMP, TIMESTAMP_WITH_LOCAL_TIME_ZONE -> DatetimeLiteralValidator.Kind.TIMESTAMP;
        }
/*  
            return switch (target) {
            if (call.getOperands().size() != 1) {  
            if (!(call.getOperands().get(0) instanceof RexLiteral literal)) {  
import org.apache.calcite.rel.RelNode;
            return recursed;
                case DATE -> DatetimeLiteralValidator.Kind.DATE;
                return false;
 * compatible open source license.
                case TIME -> DatetimeLiteralValidator.Kind.TIME;  
        }  
// TODO: fold into BackendPlanAdaption alongside CastToVarcharRewriter (unified rejection/coercion model).
            }
    private CastTemporalLiteralValidator() {}
import org.apache.calcite.rex.RexCall;  
            for (int i = firstArg; i < call.getOperands().size(); i++) {  
            }
    private static final class ValidatingShuttle extends RexShuttle {
                if (operand instanceof RexLiteral lit && SqlTypeName.CHAR_TYPES.contains(lit.getType().getSqlTypeName())) {
                return visited.accept(new ValidatingShuttle());  
import org.apache.calcite.rex.RexShuttle;  
            };  
}  
import org.apache.calcite.rex.RexNode;
            }  
 * The OpenSearch Contributors require contributions made to  
    }  
            }
final class CastTemporalLiteralValidator {  
                return false;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.rex.RexLiteral;
            validateTimestampAddDiffOperands(recursed);
            String name = call.getOperator().getName();
        return root.accept(new RelHomogeneousShuttle() {
