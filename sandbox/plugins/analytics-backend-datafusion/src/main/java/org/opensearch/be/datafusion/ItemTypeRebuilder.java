                && cast.getOperands().get(0) instanceof RexLiteral lit) {
import java.math.BigDecimal;
                && "pattern_parser".equalsIgnoreCase(ppDirect.getOperator().getName())) {
            SqlOperator targetOp = switch (fieldName) {
        @Override
                    case "tokens" -> rexBuilder.makeCall(  
            if (keyNode instanceof RexCall cast
import org.apache.calcite.rex.RexNode;  
                && operands.get(0) instanceof RexCall ppDirect  
            boolean[] changed = { false };  
                    );  
 * this file be licensed under the Apache-2.0 license or a
            }
                && cast.getOperands().size() >= 1  
                && indexLit.getValue() instanceof BigDecimal indexBd
    private ItemTypeRebuilder() {}
        }
    }
        private String extractFieldName(RexNode keyNode) {  
                        List.of(windowResult, source)
            @Override
import org.apache.calcite.rex.RexLiteral;
        }
import org.apache.calcite.sql.SqlOperator;
    private static final class RewriteShuttle extends RexShuttle {  
            List<RexNode> operands = changed[0] ? newOperands : call.getOperands();
            } else if ("array_element".equalsIgnoreCase(call.getOperator().getName())
                };
                return call;
            if (targetOp == null) {  
        private RexNode tryRewritePatternParserAccess(RexCall call, List<RexNode> operands) {
            if (rewritten != null) {
                return null;  
                && mapExtract.getOperands().size() == 2
                    case "pattern" -> windowResult;
            if (ppArgs.size() == 3) {
                && "map_extract".equalsIgnoreCase(mapExtract.getOperator().getName())
    }  
/*  
                return rewritten;
        public RexNode visitCall(RexCall call) {
                RexNode source = ppArgs.get(0);
import org.apache.calcite.rex.RexCall;
                && operands.get(0) instanceof RexCall mapExtract  
                    return null;
            String fieldName = extractFieldName(keyNode);
                return lit.getValueAs(String.class);
            }  
                && (cast.getKind() == org.apache.calcite.sql.SqlKind.CAST || cast.getKind() == org.apache.calcite.sql.SqlKind.SAFE_CAST)
        }
                    default -> null;
            }  
                RelNode rewritten = visited.accept(shuttle);  
            return rexBuilder.makeCall(call.getType(), call.getOperator(), newOperands);
                innerCall = ppDirect;
/** Rewrites struct-field access on {@code pattern_parser} into per-field scalar UDF calls. */
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
                && operands.get(1) instanceof RexLiteral indexLit  
 *
            List<RexNode> newOperands = visitList(call.getOperands(), changed);
import org.apache.calcite.rex.RexShuttle;
        });  
            RexNode rewritten = tryRewritePatternParserAccess(call, operands);  
                RexNode windowResult = ppArgs.get(1);  
            return null;
import org.apache.calcite.rel.RelHomogeneousShuttle;
            RexCall innerCall;
 * SPDX-License-Identifier: Apache-2.0
        }
        return root.accept(new RelHomogeneousShuttle() {
 * compatible open source license.
                return switch (fieldName) {
            if (fieldName == null) {
            if (call.getKind() == org.apache.calcite.sql.SqlKind.ITEM
                RelNode visited = super.visit(other);
                default -> null;
                && operands.size() == 2
            List<RexNode> ppArgs = innerCall.getOperands();  
 */  
                    innerCall = ppViaArray;
                && operands.size() == 2
                } else {
                RexShuttle shuttle = new RewriteShuttle(visited.getCluster().getRexBuilder());
                return rewritten == null ? visited : rewritten;
            }  
        private final RexBuilder rexBuilder;
            }  
package org.opensearch.be.datafusion;
                && mapExtract.getOperands().get(0) instanceof RexCall ppViaArray  
import org.apache.calcite.rel.RelNode;
                        DataFusionFragmentConvertor.LOCAL_PATTERN_PARSER_GET_TOKENS_OP,
final class ItemTypeRebuilder {
                keyNode = operands.get(1);  
            }  
    static RelNode rewrite(RelNode root) {  
                case "pattern" -> DataFusionFragmentConvertor.LOCAL_PATTERN_PARSER_GET_PATTERN_OP;
import org.apache.calcite.rex.RexBuilder;  
                }  
                && indexBd.intValueExact() == 1
                    keyNode = mapExtract.getOperands().get(1);  
            // 3-arg pattern_parser (BRAIN label): the window result is already the matched pattern.
            if (keyNode instanceof RexLiteral lit) {
                return null;
            };
            }
                return lit.getValueAs(String.class);
            RexNode keyNode;  
            public RelNode visit(RelNode other) {  
}
                && "pattern_parser".equalsIgnoreCase(ppViaArray.getOperator().getName())) {
            return rexBuilder.makeCall(targetOp, innerCall.getOperands());  
                case "tokens" -> DataFusionFragmentConvertor.LOCAL_PATTERN_PARSER_GET_TOKENS_OP;  
            }
            this.rexBuilder = rexBuilder;
            if (!changed[0]) {
        RewriteShuttle(RexBuilder rexBuilder) {  
