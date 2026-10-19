     * TIME (e.g. {@code '17:30:00'}), returns a TIMESTAMP literal pinned to 1970-01-01;
    /**  
     * otherwise returns null. Shared with {@link DatePartAdapters#coerceCharacterOperandToTimestamp}  
 * {@code ParameterizedTypeThrowsVisitor} error on every query). Earlier fallback chained
 *
            if (current instanceof RexLiteral lit && lit.getType().getSqlTypeName() == SqlTypeName.VARCHAR) {
import org.apache.calcite.util.TimestampString;  
    private DatetimeLiteralHelper() {}  
     * so the bare-TIME-string-literal path produces the same TIMESTAMP as the TIME-typed path
        if (value == null || value.length() >= 10) return null;
import org.apache.calcite.rex.RexNode;
        }
        // Calcite's TIME(varchar) constructor, the adapter-renamed LOCAL_TIME_OP)
    }  
 * 10 characters.
        TimestampString ts = new TimestampString(1970, 1, 1, time.getHour(), time.getMinute(), time.getSecond());
        return synthesizeTimestampFromTimeString(value, rexBuilder);
     */
 * {@code CAST(time AS VARCHAR) AS TIMESTAMP}, but DataFusion's simplifier folds that to
        LocalTime time;
     * returns null so the caller can fall back to its default handling.  
import java.time.LocalTime;
            return null;
        return rexBuilder.makeTimestampLiteral(ts, 9);
    static RexNode tryMakeTimeOnlyTimestampLiteral(RexNode operand, RexBuilder rexBuilder) {
 *
            return null;
        }
            }
 * 1970-01-01 UTC. This helper pattern-matches {@code LOCAL_TIME_OP(varchar_literal)} at
    private static String extractVarcharLiteral(RexNode operand) {
            return null;  
     * on sub-10-char strings.  
    static RexNode unwrapTimeLiteralToTimestamp(RexNode operand, RexBuilder rexBuilder) {
 * this file be licensed under the Apache-2.0 license or a
     * If {@code operand} is a VARCHAR/CHAR {@link RexLiteral} whose value parses as a bare
     * VARCHAR literal or a {@code LOCAL_TIME_OP(varchar_literal)} wrapper), returns a
    private static RexNode synthesizeTimestampFromTimeString(String timeString, RexBuilder rexBuilder) {
import org.apache.calcite.sql.type.SqlTypeName;
        if (time.getNano() > 0) {
        return null;
import org.apache.calcite.rex.RexLiteral;  
        if (timeString == null) return null;  
        try {
        }  
    }  
        return synthesizeTimestampFromTimeString(extractVarcharLiteral(operand), rexBuilder);  
            }
import java.time.format.DateTimeParseException;  
     * If {@code operand} is TIME-typed and reducible to a VARCHAR literal (either the raw  
                return lit.getValueAs(String.class);  
 */  
            if (current instanceof RexCall call && call.getOperands().size() == 1) {
        if (!(operand instanceof RexLiteral literal)) return null;  
 * compatible open source license.
 * <p>PPL reference semantics ({@code DateTimeFunctions.exprHour} et al.) treat a bare  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rex.RexCall;
 * doesn't declare a {@code precision_time<P>} sig (declaring one triggers a runtime  
 * The OpenSearch Contributors require contributions made to  
 *
        RexNode current = operand;  
        SqlTypeName typeName = literal.getType().getSqlTypeName();
package org.opensearch.be.datafusion;
 * here; current ITs exercise only literal-TIME, and a column path would need per-row
 * TIME as {@code LocalDateTime.of(LocalDate.ofEpochDay(0), time)} — date component is
 * that date, bypassing the lossy CAST chain. Non-literal TIME operands are not handled
        // until we reach a VARCHAR RexLiteral or give up.
        for (int depth = 0; depth < 5; depth++) {
 * <p>TIME operands can't reach DataFusion's {@code date_part} directly: our Substrait yaml
        }
    /**
final class DatetimeLiteralHelper {
 *
        if (operand.getType().getSqlTypeName() != SqlTypeName.TIME) {  
 */  
     * TIMESTAMP literal pinned to 1970-01-01 with the parsed time component; otherwise
/**
        // Recursively unwrap single-operand RexCalls (OperatorAnnotation wrappers,  
        } catch (DateTimeParseException ignored) {
            time = LocalTime.parse(timeString);  
}
 * @opensearch.internal
    }
     */
     * — both routes need to bypass {@code CAST('HH:MM:SS' AS TIMESTAMP)} which Arrow rejects
        String value = literal.getValueAs(String.class);  
 * synthesis which is not in scope.  
            ts = ts.withNanos(time.getNano());  
/*  
 * {@code cast('HH:MM:SS' AS TIMESTAMP)} and Arrow's parser rejects strings shorter than  
                current = call.getOperands().get(0);  
        if (typeName != SqlTypeName.VARCHAR && typeName != SqlTypeName.CHAR) return null;
 * Shared helper for datetime adapters that need to extract a date-part from a TIME value.  
import org.apache.calcite.rex.RexBuilder;
 * the adapter site (post-operand-adaptation) and synthesizes a TIMESTAMP literal with  
    }  
                continue;
