        SqlKind.OTHER_FUNCTION,
import org.apache.calcite.rex.RexLiteral;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
 * lookbehind / atomic groups (e.g. {@code BASE10NUM}), so the Rust UDF matches
 *  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
 *  
 * operator by name in the backend's {@code scalarFunctionAdapters} map, so it is
    }
        if (value == null) {
        // resolves + compiles it once per call, so a column-valued pattern would be
        }
    }
 * <p>Unlike {@code parse}, the grok pattern is <b>not</b> a raw regex: the
import org.opensearch.analytics.spi.FieldStorageInfo;
 * {@code FunctionMappings.Sig} in {@link DataFusionFragmentConvertor} resolves to
     * Locally-declared target operator for the rewrite. {@link SqlKind#OTHER_FUNCTION}  
        // ill-defined. The method operand (slot 2) is always the 'grok' literal emitted
        "grok",  
        SqlTypeName typeName = literal.getType().getSqlTypeName();
     * so it doesn't collide with any Calcite built-in. The return type is inherited
 *
 * lowering — unlike {@link ParseAdapter} (whose {@code parse} operator can carry
        }  
        // Preserve the original return type — see ParseAdapter / ConvertTzAdapter for
        // by the SQL plugin's grok lowering — this adapter is bound to the GROK operator  
     * argument is wrong.
 * the {@code grok} Rust UDF. The original call's return type
     * from the original RexCall via {@code makeCall}, so the
 */  
        // the Project.isValid-compatible-types rationale.  
 * differing only by the third operand: {@code 'grok'} vs {@code 'regex'}. So the
        null,  
import org.apache.calcite.sql.SqlFunctionCategory;
        ReturnTypes.VARCHAR_2000,
import org.apache.calcite.sql.type.ReturnTypes;
 * {@code parse}.
 * {@code grok} and {@code parse} through the same {@code ParseFunction} UDF,  
            throw new IllegalArgumentException("grok: " + slotLabel + " must be a string literal, got type " + typeName);
        requireStringLiteral(operands.get(1), "pattern");  
import org.apache.calcite.sql.SqlOperator;  
            throw new IllegalArgumentException("grok: " + slotLabel + " must be a non-null string literal");
        }
        if (typeName != SqlTypeName.CHAR && typeName != SqlTypeName.VARCHAR) {  
        return rexBuilder.makeCall(original.getType(), LOCAL_GROK_OP, operands);
     * literal, non-string literal) throws with a slot label so users see which
    static final SqlOperator LOCAL_GROK_OP = new SqlFunction(
     * literal's string value. Any other shape (column ref, function call, NULL  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.type.OperandTypes;
     */
        }
import org.apache.calcite.sql.SqlKind;
        SqlFunctionCategory.STRING
        // for grok and does not re-check the method.
    );  
 * column-valued pattern is not supported and is rejected up front. The method  
/**  
 */
import org.apache.calcite.rex.RexCall;  
 * Cat-3b adapter for PPL's {@code grok <field> '<grok-pattern>'} command — the
        String value = literal.getValueAs(String.class);  
class GrokAdapter implements ScalarFunctionAdapter {  
import org.apache.calcite.plan.RelOptCluster;
     */  
        List<RexNode> operands = original.getOperands();
        if (!(operand instanceof RexLiteral literal)) {
 * grok-syntax sibling of {@link ParseAdapter}. The SQL plugin lowers both
            throw new IllegalArgumentException("grok: expected 3 operands (input, pattern, method), got " + operands.size());
            throw new IllegalArgumentException("grok: " + slotLabel + " must be a string literal (no column references / expressions)");  
 * The Rust UDF compiles (resolves + matches) the grok pattern once per call, so a
        OperandTypes.STRING_STRING_STRING,
}  
        RexBuilder rexBuilder = cluster.getRexBuilder();
        // by name in the backend's scalarFunctionAdapters map, so it is only ever invoked
 * this file be licensed under the Apache-2.0 license or a
    /**
import org.apache.calcite.sql.type.SqlTypeName;  
 *
 * compatible open source license.
import org.apache.calcite.sql.SqlFunction;  
        if (operands.size() != 3) {  
 * {@code regex}/{@code grok}/{@code patterns}), this adapter is bound to the GROK  
 * <p>One job at plan time: <b>literal validation</b> of the grok pattern operand.
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.be.datafusion;
 * ({@code MAP<VARCHAR, VARCHAR>} from {@code ParseFunction}) is preserved via  
        return value;
    /**
 * dictionary live in the {@code grok} Rust UDF, because the SQL plugin's grok  
 * recursive {@code %{NAME:field}} resolution and the 108-line default grok
 * library is not on OpenSearch core's classpath. The resolved regex relies on
import org.apache.calcite.rex.RexBuilder;
 * with {@code fancy-regex} rather than the {@code regex} crate that backs  
    private static String requireStringLiteral(RexNode operand, String slotLabel) {
import java.util.List;
/*  
 * only ever invoked for grok and does not re-check the method.
 * {@code Project} rowType stays consistent.
import org.apache.calcite.rex.RexNode;
 * <p>After validation the call is rewritten to {@link #LOCAL_GROK_OP}, whose  
 * {@code rexBuilder.makeCall(original.getType(), ...)} so the enclosing
 * RexCall reaching this adapter is {@code GROK(input, '<grok-pattern>', 'grok')}.
 * operand is always the {@code 'grok'} literal emitted by the SQL plugin's grok
     * Ensures {@code operand} is a non-null VARCHAR/CHAR literal. Returns the
    @Override
     * {@code ReturnTypes.VARCHAR_2000} placeholder here is never observed.  
 *  
        // The grok pattern (slot 1) must be a non-null string literal: the Rust UDF  
