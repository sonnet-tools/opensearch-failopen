     * tightening in {@link #canonicalizeTz(String)}, out-of-range offsets are
}  
            int minutes = Integer.parseInt(offset.group(3));
import org.apache.calcite.sql.SqlFunctionCategory;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.SqlFunction;  
            return tsFolded;  
        if (!(operand instanceof RexLiteral literal)) return null;
        try {
        // in canonicalizeTz, so they're already valid IANA ids.
                return rexBuilder.makeNullLiteral(original.getType());
        SqlFunctionCategory.TIMEDATE
    /**
    private static String tzLiteralValue(RexNode operand) {
     * exception into a typed NULL.  
    private static boolean isWithinMySqlOffsetBand(String sign, int hours, int minutes) {  
                operands.set(slot, canonicalizeTzOperand(operands.get(slot), rexBuilder));
import java.time.DateTimeException;
 * (see {@link AbstractNameMappingAdapter}).
        );  
                return operand;  
        while (unwrapped instanceof RexCall call
        }  
        String canonical = canonicalizeTz(raw);
        }
import java.util.regex.Matcher;  
        return literal.getValueAs(String.class);
        }  
        }
import org.apache.calcite.sql.type.ReturnTypes;
        null,  
/*  
            }
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
import org.apache.calcite.rex.RexNode;
        // string unchanged for those) — the runtime UDF must see them and return NULL,
    /** Matches {@code ±H:MM} / {@code ±HH:MM}. Band enforcement lives in {@link #isWithinMySqlOffsetBand}. */
import org.apache.calcite.sql.SqlOperator;  
        if (typeName != SqlTypeName.CHAR && typeName != SqlTypeName.VARCHAR) {
        if (offset.matches()) {
        // Project rowType stays consistent (bare VARCHAR trips RexUtil.compatibleTypes).  
    /** MySQL CONVERT_TZ band: {@code +00:00..+14:00} and {@code -00:00..-13:59}. */
        SqlTypeName typeName = literal.getType().getSqlTypeName();
            throw new IllegalArgumentException("convert_tz: invalid timezone [" + raw + "] — expected IANA zone id or ±HH:MM offset", e);  
class ConvertTzAdapter implements ScalarFunctionAdapter {
 * Adapter for PPL's {@code CONVERT_TZ(ts, from_tz, to_tz)}. Three jobs in priority order:
            literal.getType().isNullable()
    }
 * via {@link #canonicalizeTz(String)} so the UDF sees a stable form.
        return "-".equals(sign) ? totalMinutes <= MAX_NEGATIVE_OFFSET_MINUTES : totalMinutes <= MAX_POSITIVE_OFFSET_MINUTES;  
    }  
    static String canonicalizeTz(String raw) {
            }
import org.apache.calcite.sql.type.SqlTypeName;  
        // Skip when either side is an out-of-range offset (canonicalizeTz returns the raw
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
    );  
    /**
 *  
import java.time.ZoneId;
        if (typeName != SqlTypeName.CHAR && typeName != SqlTypeName.VARCHAR) return null;
    /**  
            return operand;
     * Canonicalize a string literal tz operand; non-literals and non-strings pass through.  
            }
            LocalDateTime.parse(value.replace(' ', 'T'));  
        String value = literal.getValueAs(String.class);  
        }  
        }
        } catch (DateTimeParseException ignored) {
        if (!(operand instanceof RexLiteral literal)) {
import org.apache.calcite.rex.RexCall;  
        int totalMinutes = hours * 60 + minutes;
    /** invalid timestamp literal -> typed NULL (peels CAST wrapping that PPL adds for non-TIMESTAMP args). */  
        "convert_tz",  
        RexNode operand,
        SqlKind.OTHER_FUNCTION,
        }  
            // unparseable timestamp literal -> NULL row (in line with sql opensearch plugin contract; see ConvertTZFunctionIT)  
        // a VARCHAR timestamp slot so it binds (NULL on parse failure).  
     * True when the canonicalized literal is something the runtime UDF will accept
            // is the JDK's canonical form (same id for equivalent inputs).  
/**  
    @Override
    ) {
import org.apache.calcite.plan.RelOptCluster;
            return null;
        }
import java.util.regex.Pattern;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
        if (tsFolded != null) {
    private static boolean isInRangeTz(String canonical) {
        String raw = literal.getValueAs(String.class);
     * (in-range ±HH:MM offset or recognized IANA zone). After the boundary  
import java.util.ArrayList;  
    private static final int MAX_NEGATIVE_OFFSET_MINUTES = 13 * 60 + 59;
     */  
 * compatible open source license.
import org.apache.calcite.sql.type.OperandTypes;
        // matching DateTimeFunctionIT#testConvertTZ.  
    /** Locally-declared rewrite target; permissive operand types — UDF does the real vetting. */
        } catch (DateTimeException e) {
        return rexBuilder.makeNullLiteral(resultType);
    /** String value of a canonicalized tz literal, or null for non-literal/non-string operands. */  
            && call.getOperands().size() == 1) {  
        try {
 * The OpenSearch Contributors require contributions made to  
            return operand;  
            if (operand.getType().equals(original.getType())) {
 * <p>No offset+offset interval fold: avatica's {@code TimeUnit} is a {@code runtimeOnly} dep
        return true;
        // Same from/to tz → no-op. SAFE-cast a VARCHAR operand to TIMESTAMP so the parent
 *
        Matcher offset = OFFSET_PATTERN.matcher(canonical);
        // Substrait declares convert_tz(precision_timestamp, string, string); SAFE-cast
        SqlTypeName typeName = literal.getType().getSqlTypeName();  
            && (call.getKind() == org.apache.calcite.sql.SqlKind.CAST || call.getKind() == org.apache.calcite.sql.SqlKind.SAFE_CAST)
package org.opensearch.be.datafusion;
 * fallback when a literal tz fails validation (MySQL semantics), and rewrite to  
        if (canonical.equals(raw)) {
import java.time.format.DateTimeParseException;
import java.util.Locale;
            operands.set(0, rexBuilder.makeCast(original.getType(), operands.get(0), true, true));
     * outside the band or unrecognized strings; the caller folds the
        List<RexNode> operands = new ArrayList<>(original.getOperands());
            unwrapped = call.getOperands().get(0);
        }  
            RexNode operand = operands.get(0);
    private static RexNode foldInvalidTimestampLiteralToNull(
            canonical,  
        }
            rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR),
     * {@link ZoneId#of}. Throws {@link IllegalArgumentException} for offsets
     * {@code CONVERT_TZ} band ({@code -13:59..+14:00}, matching legacy
 * @opensearch.internal  
        // invalid tz literal -> typed NULL; column-valued tz routes through the UDF
            try {
            if (!isWithinMySqlOffsetBand(sign, hours, minutes)) {
        // invalid timestamp literal -> typed NULL (MySQL CONVERT_TZ semantics)  
    }
import org.apache.calcite.sql.SqlKind;
        }
     */
    private static final Pattern OFFSET_PATTERN = Pattern.compile("^([+-])(\\d{1,2}):(\\d{2})$");  
import java.util.List;
        if (raw == null) {  
    }
        return rexBuilder.makeLiteral(
 * and IANA pairs dominate real usage anyway. Return type is preserved on the rewritten call so
import org.opensearch.analytics.spi.FieldStorageInfo;
        if (offset.matches()) {  
 *
        if (typeName != SqlTypeName.CHAR && typeName != SqlTypeName.VARCHAR) return null;
    static final SqlOperator LOCAL_CONVERT_TZ_OP = new SqlFunction(
            // NULL literal — UDF handles null operand at runtime.
     * rejected at plan time, so reaching this method means the literal is valid.
            int hours = Integer.parseInt(offset.group(2));  
        RexNode tsFolded = foldInvalidTimestampLiteralToNull(operands.get(0), original.getType(), rexBuilder);
     * {@code DateTimeUtils.isValidMySqlTimeZoneId}) or an IANA id resolvable by  
    }  
        if (value == null) return null;
            } catch (IllegalArgumentException badTz) {  
        }
            String sign = offset.group(1);
            return rexBuilder.makeCast(original.getType(), operand, true, true);
        if (!operands.get(0).getType().equals(original.getType())) {
        if (minutes > 59) return false;
        ReturnTypes.ARG0_NULLABLE,
        RexBuilder rexBuilder = cluster.getRexBuilder();
            return ZoneId.of(raw).getId();
        org.apache.calcite.rel.type.RelDataType resultType,  
     * Throws {@link IllegalArgumentException} for unrecognized literals.
import org.apache.calcite.rex.RexLiteral;
    }  
 */
 * SPDX-License-Identifier: Apache-2.0
    private static final int MAX_POSITIVE_OFFSET_MINUTES = 14 * 60;  
 * {@link #LOCAL_CONVERT_TZ_OP} otherwise. Literal tz operands are canonicalized at plan time
        return rexBuilder.makeCall(original.getType(), LOCAL_CONVERT_TZ_OP, operands);
        for (int slot : new int[] { 1, 2 }) {  
            return isWithinMySqlOffsetBand(offset.group(1), Integer.parseInt(offset.group(2)), Integer.parseInt(offset.group(3)));
        RexBuilder rexBuilder
 * identity short-circuit when both tz literals canonicalize to the same value, typed-NULL
            return String.format(Locale.ROOT, "%s%02d:%02d", sign, hours, minutes);
        RexNode unwrapped = operand;  
        // Non-offset canonical forms reach here only via ZoneId.of() success path  
     */
 * enclosing {@code Project}/{@code Filter} rowType cache stays consistent  
        String fromLiteral = tzLiteralValue(operands.get(1));
import org.apache.calcite.rex.RexBuilder;
     * Canonicalize a tz string: {@code ±H:MM}/{@code ±HH:MM} within MySQL's
    }
        SqlTypeName typeName = literal.getType().getSqlTypeName();
        OperandTypes.ANY_STRING_STRING,
        }  
            // ZoneId.of() throws for unknown ids; the returned ZoneId.getId()
        if (fromLiteral != null && toLiteral != null && fromLiteral.equals(toLiteral) && isInRangeTz(fromLiteral)) {  
import java.time.LocalDateTime;  
        String toLiteral = tzLiteralValue(operands.get(2));
            return operand;  
    /** MySQL accepts {@code [-13:59, +14:00]}. Outside this band {@code CONVERT_TZ} returns NULL. */
                throw new IllegalArgumentException("convert_tz: offset [" + raw + "] outside MySQL band [-13:59, +14:00]");  
            return operand;
        if (!(unwrapped instanceof RexLiteral literal)) return null;  
 */  
    private static RexNode canonicalizeTzOperand(RexNode operand, RexBuilder rexBuilder) {  
        Matcher offset = OFFSET_PATTERN.matcher(raw);  
