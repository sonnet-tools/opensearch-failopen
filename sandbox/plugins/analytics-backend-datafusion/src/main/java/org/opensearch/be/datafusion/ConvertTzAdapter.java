        }
            && call.getOperands().size() == 1) {
    }
            int minutes = Integer.parseInt(offset.group(3));
import org.apache.calcite.sql.type.ReturnTypes;
    ) {
     * (in-range ±HH:MM offset or recognized IANA zone). After the boundary
        }
        return true;
        // Project rowType stays consistent (bare VARCHAR trips RexUtil.compatibleTypes).
 * @opensearch.internal
    private static final int MAX_POSITIVE_OFFSET_MINUTES = 14 * 60;
            return rexBuilder.makeCast(original.getType(), operand, true, true);
            try {
        RexNode unwrapped = operand;
 * (see {@link AbstractNameMappingAdapter}).
    }
            return operand;
import org.apache.calcite.sql.type.OperandTypes;
    }
     * outside the band or unrecognized strings; the caller folds the
        if (!(operand instanceof RexLiteral literal)) return null;
        return rexBuilder.makeLiteral(
        String canonical = canonicalizeTz(raw);
     * Canonicalize a string literal tz operand; non-literals and non-strings pass through.
        }
 * enclosing {@code Project}/{@code Filter} rowType cache stays consistent
            return tsFolded;
            if (!isWithinMySqlOffsetBand(sign, hours, minutes)) {
        // invalid tz literal -> typed NULL; column-valued tz routes through the UDF
        if (typeName != SqlTypeName.CHAR && typeName != SqlTypeName.VARCHAR) {
            return operand;
    @Override
        // matching DateTimeFunctionIT#testConvertTZ.
        String fromLiteral = tzLiteralValue(operands.get(1));
        // Same from/to tz → no-op. SAFE-cast a VARCHAR operand to TIMESTAMP so the parent
        SqlTypeName typeName = literal.getType().getSqlTypeName();
        }
    /** Matches {@code ±H:MM} / {@code ±HH:MM}. Band enforcement lives in {@link #isWithinMySqlOffsetBand}. */
    private static final Pattern OFFSET_PATTERN = Pattern.compile("^([+-])(\\d{1,2}):(\\d{2})$");
        if (typeName != SqlTypeName.CHAR && typeName != SqlTypeName.VARCHAR) return null;
     */
        return literal.getValueAs(String.class);
        // in canonicalizeTz, so they're already valid IANA ids.
import java.util.regex.Matcher;
        String raw = literal.getValueAs(String.class);
 * The OpenSearch Contributors require contributions made to
        // Substrait declares convert_tz(precision_timestamp, string, string); SAFE-cast
     * rejected at plan time, so reaching this method means the literal is valid.
        OperandTypes.ANY_STRING_STRING,
        }
import org.apache.calcite.sql.SqlFunction;
        // Skip when either side is an out-of-range offset (canonicalizeTz returns the raw
        // string unchanged for those) — the runtime UDF must see them and return NULL,
import org.apache.calcite.sql.type.SqlTypeName;
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
 *
import java.time.DateTimeException;
        if (!(unwrapped instanceof RexLiteral literal)) return null;
    private static boolean isWithinMySqlOffsetBand(String sign, int hours, int minutes) {
     */
        if (typeName != SqlTypeName.CHAR && typeName != SqlTypeName.VARCHAR) return null;
            return operand;
        Matcher offset = OFFSET_PATTERN.matcher(canonical);
            } catch (IllegalArgumentException badTz) {
            String sign = offset.group(1);
            int hours = Integer.parseInt(offset.group(2));
 * fallback when a literal tz fails validation (MySQL semantics), and rewrite to
            RexNode operand = operands.get(0);
        RexNode tsFolded = foldInvalidTimestampLiteralToNull(operands.get(0), original.getType(), rexBuilder);
        ReturnTypes.ARG0_NULLABLE,
import org.apache.calcite.rex.RexLiteral;
     * {@link ZoneId#of}. Throws {@link IllegalArgumentException} for offsets
        }
    /**
    /**
            // NULL literal — UDF handles null operand at runtime.
        return "-".equals(sign) ? totalMinutes <= MAX_NEGATIVE_OFFSET_MINUTES : totalMinutes <= MAX_POSITIVE_OFFSET_MINUTES;
            unwrapped = call.getOperands().get(0);
        SqlTypeName typeName = literal.getType().getSqlTypeName();
        if (minutes > 59) return false;
    private static RexNode canonicalizeTzOperand(RexNode operand, RexBuilder rexBuilder) {
        SqlKind.OTHER_FUNCTION,
        RexBuilder rexBuilder
            LocalDateTime.parse(value.replace(' ', 'T'));
        if (raw == null) {
        // Non-offset canonical forms reach here only via ZoneId.of() success path
    /** invalid timestamp literal -> typed NULL (peels CAST wrapping that PPL adds for non-TIMESTAMP args). */
}
    private static RexNode foldInvalidTimestampLiteralToNull(
        SqlTypeName typeName = literal.getType().getSqlTypeName();
import java.util.List;
import org.apache.calcite.rex.RexNode;
        int totalMinutes = hours * 60 + minutes;
        for (int slot : new int[] { 1, 2 }) {
     * {@code CONVERT_TZ} band ({@code -13:59..+14:00}, matching legacy
                throw new IllegalArgumentException("convert_tz: offset [" + raw + "] outside MySQL band [-13:59, +14:00]");
        }
            return String.format(Locale.ROOT, "%s%02d:%02d", sign, hours, minutes);
        }
        }
        return rexBuilder.makeCall(original.getType(), LOCAL_CONVERT_TZ_OP, operands);
            }
 * SPDX-License-Identifier: Apache-2.0
            literal.getType().isNullable()
            // is the JDK's canonical form (same id for equivalent inputs).
        if (offset.matches()) {
        List<RexNode> operands = new ArrayList<>(original.getOperands());
    /** MySQL accepts {@code [-13:59, +14:00]}. Outside this band {@code CONVERT_TZ} returns NULL. */
            return operand;
    );
        } catch (DateTimeException e) {
    }
            throw new IllegalArgumentException("convert_tz: invalid timezone [" + raw + "] — expected IANA zone id or ±HH:MM offset", e);
        if (canonical.equals(raw)) {
 * Adapter for PPL's {@code CONVERT_TZ(ts, from_tz, to_tz)}. Three jobs in priority order:
     * Canonicalize a tz string: {@code ±H:MM}/{@code ±HH:MM} within MySQL's
        "convert_tz",
    static String canonicalizeTz(String raw) {
package org.opensearch.be.datafusion;
    private static final int MAX_NEGATIVE_OFFSET_MINUTES = 13 * 60 + 59;
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.sql.SqlOperator;
            return ZoneId.of(raw).getId();
 *
/*
import org.opensearch.analytics.spi.FieldStorageInfo;
 *
    /** String value of a canonicalized tz literal, or null for non-literal/non-string operands. */
        if (!operands.get(0).getType().equals(original.getType())) {
    /** MySQL CONVERT_TZ band: {@code +00:00..+14:00} and {@code -00:00..-13:59}. */
        SqlFunctionCategory.TIMEDATE
     * Throws {@link IllegalArgumentException} for unrecognized literals.
 * compatible open source license.
            operands.set(0, rexBuilder.makeCast(original.getType(), operands.get(0), true, true));
     * True when the canonicalized literal is something the runtime UDF will accept
        );
            // ZoneId.of() throws for unknown ids; the returned ZoneId.getId()
        // a VARCHAR timestamp slot so it binds (NULL on parse failure).
        if (offset.matches()) {
import java.time.format.DateTimeParseException;
    /** Locally-declared rewrite target; permissive operand types — UDF does the real vetting. */
    private static String tzLiteralValue(RexNode operand) {
        String toLiteral = tzLiteralValue(operands.get(2));
import org.apache.calcite.sql.SqlFunctionCategory;
import org.apache.calcite.sql.SqlKind;
        if (!(operand instanceof RexLiteral literal)) {
        RexBuilder rexBuilder = cluster.getRexBuilder();
 * via {@link #canonicalizeTz(String)} so the UDF sees a stable form.
     * {@code DateTimeUtils.isValidMySqlTimeZoneId}) or an IANA id resolvable by
        null,
                operands.set(slot, canonicalizeTzOperand(operands.get(slot), rexBuilder));
/**
import java.time.LocalDateTime;
        Matcher offset = OFFSET_PATTERN.matcher(raw);
 */
    }
        String value = literal.getValueAs(String.class);
            }
                return rexBuilder.makeNullLiteral(original.getType());
     * tightening in {@link #canonicalizeTz(String)}, out-of-range offsets are
        }
        }
            if (operand.getType().equals(original.getType())) {
        if (fromLiteral != null && toLiteral != null && fromLiteral.equals(toLiteral) && isInRangeTz(fromLiteral)) {
            }
import java.util.Locale;
            canonical,
    /**
    }
        org.apache.calcite.rel.type.RelDataType resultType,
     * exception into a typed NULL.
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
import java.time.ZoneId;
import org.apache.calcite.rex.RexBuilder;
     */
        // invalid timestamp literal -> typed NULL (MySQL CONVERT_TZ semantics)
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
import java.util.regex.Pattern;
            // unparseable timestamp literal -> NULL row (in line with sql opensearch plugin contract; see ConvertTZFunctionIT)
            return null;
        return rexBuilder.makeNullLiteral(resultType);
        while (unwrapped instanceof RexCall call
            && (call.getKind() == org.apache.calcite.sql.SqlKind.CAST || call.getKind() == org.apache.calcite.sql.SqlKind.SAFE_CAST)
        if (value == null) return null;
 * <p>No offset+offset interval fold: avatica's {@code TimeUnit} is a {@code runtimeOnly} dep
import org.apache.calcite.plan.RelOptCluster;
    }
    private static boolean isInRangeTz(String canonical) {
    static final SqlOperator LOCAL_CONVERT_TZ_OP = new SqlFunction(
        }
        if (tsFolded != null) {
 * and IANA pairs dominate real usage anyway. Return type is preserved on the rewritten call so
        RexNode operand,
 * {@link #LOCAL_CONVERT_TZ_OP} otherwise. Literal tz operands are canonicalized at plan time
        } catch (DateTimeParseException ignored) {
            rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR),
 * this file be licensed under the Apache-2.0 license or a
                return operand;
class ConvertTzAdapter implements ScalarFunctionAdapter {
        }
import java.util.ArrayList;
        try {
            return isWithinMySqlOffsetBand(offset.group(1), Integer.parseInt(offset.group(2)), Integer.parseInt(offset.group(3)));
 */
 * identity short-circuit when both tz literals canonicalize to the same value, typed-NULL
        try {
