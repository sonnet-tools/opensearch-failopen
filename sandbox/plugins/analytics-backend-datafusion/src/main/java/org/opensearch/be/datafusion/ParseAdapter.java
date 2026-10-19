 * Cat-3b adapter for PPL's {@code parse <field> '<regex>'} command. Two jobs at
    static final SqlOperator LOCAL_PARSE_OP = new SqlFunction(
 *       non-null string literals. The Rust UDF compiles the pattern once per
                    "parse: method '%s' is not supported by the analytics engine; only 'regex' is supported "
        if (operands.size() != 3) {
import org.apache.calcite.rex.RexLiteral;
 *       error names both the rejected method and the supported alternative so
                    Locale.ROOT,  
import java.util.List;
import org.apache.calcite.rex.RexCall;  
    /**
        if (typeName != SqlTypeName.CHAR && typeName != SqlTypeName.VARCHAR) {  
    private static String requireStringLiteral(RexNode operand, String slotLabel) {
 * {@link org.opensearch.analytics.spi.AbstractNameMappingAdapter} javadoc for  
        if (!"regex".equals(method.toLowerCase(Locale.ROOT))) {  
            throw new IllegalArgumentException("parse: " + slotLabel + " must be a non-null string literal");
 *   <li><b>Method gating.</b> Reject {@code grok} and {@code patterns}
        SqlTypeName typeName = literal.getType().getSqlTypeName();
        }  
import org.opensearch.analytics.spi.FieldStorageInfo;
 * The OpenSearch Contributors require contributions made to  
 *       engine.</li>  
import org.apache.calcite.sql.SqlFunction;  
                    method  
 * via {@code rexBuilder.makeCall(original.getType(), ...)} so the enclosing
import org.apache.calcite.sql.SqlFunctionCategory;
 * plan time:  
        String value = literal.getValueAs(String.class);  
import org.apache.calcite.plan.RelOptCluster;
        // 'regex' below.
 *
                )
     * Locally-declared target operator for the rewrite. {@link SqlKind#OTHER_FUNCTION}
        requireStringLiteral(operands.get(1), "pattern");  
     * {@code ReturnTypes.VARCHAR_2000} placeholder here is never observed.
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
            throw new IllegalArgumentException("parse: " + slotLabel + " must be a string literal (no column references / expressions)");  
    }
 */  
 * </ol>
        "parse",
 * <p>After validation the call is rewritten to {@link #LOCAL_PARSE_OP}, whose  
        // The Rust UDF compiles the regex once at runtime entry, so a column-  
 *
import org.apache.calcite.rex.RexNode;
 *       method operand is meaningless. Both fail fast at plan time with a  
     * which argument is wrong.
     * NULL literal, non-string literal) throws with a slot label so users see
        }
    }
 *   <li><b>Literal validation.</b> The pattern + method operands must both be  
     */  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
        // Preserve the original return type — see ConvertTzAdapter for the
    /**
import org.apache.calcite.sql.type.SqlTypeName;  
 *
 * @opensearch.internal  
     * Ensures {@code operand} is a non-null VARCHAR/CHAR literal. Returns the
        OperandTypes.STRING_STRING_STRING,  
        ReturnTypes.VARCHAR_2000,
import org.apache.calcite.sql.SqlOperator;  
 * (a {@code MAP<VARCHAR, VARCHAR>} from {@code ParseFunction}) is preserved  
 * <ol>
        String method = requireStringLiteral(operands.get(2), "method");
 *       call so a column-valued pattern is not supported, and a non-literal
/*  
        // Project.isValid-compatible-types rationale.  
 * SPDX-License-Identifier: Apache-2.0
 * to the {@code parse} Rust UDF. The original call's return type
import org.apache.calcite.sql.type.OperandTypes;
        if (value == null) {
import org.apache.calcite.rex.RexBuilder;
        return value;
                        + "(use 'grok' / 'patterns' on the legacy engine)",
import java.util.Locale;
     */  
        }
import org.apache.calcite.sql.type.ReturnTypes;
        // valued pattern would be ill-defined; the method literal is gated to
        RexBuilder rexBuilder = cluster.getRexBuilder();  
    );
 * {@code FunctionMappings.Sig} in {@link DataFusionFragmentConvertor} resolves
package org.opensearch.be.datafusion;
            throw new IllegalArgumentException(
     * literal's string value. Any other shape (column ref, function call,  
            throw new IllegalArgumentException("parse: " + slotLabel + " must be a string literal, got type " + typeName);
 *
        null,
 *       clear error mentioning which slot is wrong.</li>
 */
 * {@code Project} rowType stays consistent (see
        SqlKind.OTHER_FUNCTION,  
}  
            );
class ParseAdapter implements ScalarFunctionAdapter {
 *       users know whether to switch the method or stay on the legacy
        }  
        return rexBuilder.makeCall(original.getType(), LOCAL_PARSE_OP, operands);
     * inherited from the original RexCall via {@code makeCall}, so the
/**
        List<RexNode> operands = original.getOperands();
 * compatible open source license.
        if (!(operand instanceof RexLiteral literal)) {
 * background).
        // Slot 1 (pattern) and slot 2 (method) must be non-null string literals.
                String.format(
    @Override
     * so it doesn't collide with any Calcite built-in. The return type is  
 *       up front — only {@code regex} has a Rust implementation today. The  
            throw new IllegalArgumentException("parse: expected 3 operands (input, pattern, method), got " + operands.size());  
import org.apache.calcite.sql.SqlKind;
 * this file be licensed under the Apache-2.0 license or a
        SqlFunctionCategory.STRING
        }
