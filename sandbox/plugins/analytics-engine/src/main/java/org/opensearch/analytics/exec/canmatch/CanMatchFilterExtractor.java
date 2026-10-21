        RexNode condition = filterNode.getCondition();
        long overallMax = Long.MIN_VALUE;
 * causes the extractor to return an empty list (no can-match for that query).
import java.time.LocalDate;
        String columnName = fields.get(ref.getIndex()).getName();
    private static void extractComparison(RexCall call, List<RelDataTypeField> fields, List<CanMatchFilter> filters) {
            logger.debug("can-match extractor: no Filter node found in plan");
        }
                Object ub = range.upperEndpoint();
                }
import org.apache.calcite.rel.RelNode;
        switch (call.getKind()) {
        long low = resolveNumericValue(lowNode);
                    val = extractLongValue(innerLit);
        }
        for (Range<?> range : sarg.rangeSet.asRanges()) {
                // Non-range predicate (equality, LIKE, etc.) — skip
            if (!isIntegerValued(n)) return Long.MIN_VALUE;
                } catch (Exception e) {
     */
        // For can-match, we take the bounding range [min of all ranges, max of all ranges]
            return parseTimestampString(strValue);
                logger.debug("can-match extractor: OR detected, skipping this branch");
    }
            filters.add(new LongRange(columnName, overallMin, overallMax));
            if (range.hasLowerBound()) {
        String columnName = fields.get(ref.getIndex()).getName();
                if (!(lb instanceof Number n) || !isIntegerValued(n)) return;
        if (literal.isNull()) return Long.MIN_VALUE;
        }
    private static boolean isIntegerValued(Number n) {
            }
                Instant instant = Instant.parse(str.replace(" ", "T") + (str.endsWith("Z") ? "" : (str.contains("T") ? "" : "Z")));
import org.apache.calcite.rex.RexNode;
            }
    }
        if (!(sargNode instanceof RexLiteral sargLiteral)) return;
                    if (val != Long.MIN_VALUE) return val;
                if (operand instanceof RexCall innerCall) {
import org.apache.calcite.rex.RexInputRef;
        // Extract the overall min/max from the Sarg's range set
    private static Filter findFilter(RelNode node) {
                // Recurse one level deeper (e.g. CAST(TIMESTAMP(...)))
            default -> {
        // String literal representing a timestamp (e.g. '2026-07-13')
            }
            }
    private static void extractFromCondition(RexNode condition, List<RelDataTypeField> fields, List<CanMatchFilter> filters) {
            }
            case GREATER_THAN -> min = saturateAdd(literalValue, 1);
 *
        // Identify which operand is the column ref and which is the literal
        return Long.MIN_VALUE;
 * Walks a Calcite {@link RelNode} plan tree and extracts range predicates
        if (typeName == SqlTypeName.TIMESTAMP || typeName == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE || typeName == SqlTypeName.DATE) {
     * is not supported (e.g. top-level OR).
            case BETWEEN -> extractBetween(call, fields, filters);
            }
}
import org.apache.calcite.rex.RexCall;
        if (value instanceof Number n) {
            default -> {
                }
        }
            // Try ISO date-time: 2026-07-13T10:00:00Z or 2026-07-13 10:00:00
        RexNode sargNode = call.getOperands().get(1);
        long result = a + b;
            case GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL -> extractComparison(call, fields, filters);
        if (b > 0 && result > a) return Long.MIN_VALUE; // underflow
        if (call.getOperands().size() != 3) return;
        filters.add(new LongRange(columnName, min, max));
 * @opensearch.internal
     */
                    hi = saturateSubtract(hi, 1);
import java.util.Collections;
            case AND -> {
        long max = Long.MAX_VALUE;
import org.apache.calcite.rel.core.Filter;
            for (RexNode operand : call.getOperands()) {
    private static long extractTimestampFromStringLiteral(RexLiteral literal) {
        RexNode lowNode = call.getOperands().get(1);
            columnIsLeft = false;
                long lo = n.longValue();
            String strValue = literal.getValueAs(String.class);
                return instant.toEpochMilli();
 * {@link CanMatchFilter} (AND semantics across the list).
package org.opensearch.analytics.exec.canmatch;
                    long val = extractTimestampFromStringLiteral(innerLit);
                return val != null ? val : Long.MIN_VALUE;
            return;
                return found;
 */
            if (literalValue == Long.MIN_VALUE) return;
     * Resolves a RexNode to a long value. Handles:
            if (literalValue == Long.MIN_VALUE) return;
            }
        return result;
                    lo = saturateAdd(lo, 1);
                }
        }
        }
    private CanMatchFilterExtractor() {}
        List<RelDataTypeField> fields = filterNode.getInput().getRowType().getFieldList();
        if (value == null) return Long.MIN_VALUE;
        long literalValue;
        RexNode highNode = call.getOperands().get(2);
        if (!columnIsLeft) {
    /**
                    return longVal != null ? longVal : Long.MIN_VALUE;
    private static void extractBetween(RexCall call, List<RelDataTypeField> fields, List<CanMatchFilter> filters) {
        // Already a timestamp/date-typed literal
            Filter found = findFilter(input);
            case LESS_THAN -> max = saturateSubtract(literalValue, 1);
        String columnName;
        SqlTypeName typeName = literal.getTypeName();
            try {
                overallMin = Math.min(overallMin, lo);
 * The OpenSearch Contributors require contributions made to
            // Dig through to find the inner RexLiteral
        } else {
 *
        SqlTypeName typeName = literal.getTypeName();
        logger.debug("can-match extractor: extracted {} filters from condition {}", filters.size(), condition);
    private static void extractSarg(RexCall call, List<RelDataTypeField> fields, List<CanMatchFilter> filters) {
                }
        }
                if (range.lowerBoundType() == BoundType.OPEN) {
                Long val = literal.getValueAs(Long.class);
     * Parses a string-typed RexLiteral containing a timestamp/date string
            return date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
            }
            columnIsLeft = true;
            }
                if (range.upperBoundType() == BoundType.OPEN) {
            case SEARCH -> extractSarg(call, fields, filters);
            case OR -> {
    }
                    // PPL produces TIMESTAMP('2026-07-13':VARCHAR) — try string parse first
            if (found != null) {
            columnName = fields.get(ref.getIndex()).getName();
            LocalDate date = LocalDate.parse(str);
        extractFromCondition(condition, fields, filters);
    }
    private static long saturateSubtract(long a, long b) {
        Object sargValue = sargLiteral.getValue();
            } else {
 * suitable for can-match evaluation. Produces a flat list of
        if (!(sargValue instanceof org.apache.calcite.util.Sarg<?> sarg)) return;
        }
                return Long.MIN_VALUE;
    private static long saturateAdd(long a, long b) {
                }
        switch (typeName) {
        long result = a - b;
                try {
                    // Fallback: literal might already be numeric (e.g. epoch millis directly)
            if (strValue == null) return Long.MIN_VALUE;
     * into epoch millis.
            }
        try {
    }
        Filter filterNode = findFilter(plan);
            return n.longValue();
        RexNode columnNode = call.getOperands().get(0);
    }
                    Long longVal = literal.getValueAs(Long.class);
        // RexLiteral.getValue() returns Comparable — typically BigDecimal for numerics
        long overallMin = Long.MAX_VALUE;
        List<CanMatchFilter> filters = new ArrayList<>();
    public static List<CanMatchFilter> extract(RelNode plan) {
                    if (val != Long.MIN_VALUE) return val;
    private static long extractLongValue(RexLiteral literal) {
/*
    private static long resolveNumericValue(RexNode node) {
     */
            kind = kind.reverse();
            if (str.contains("T") || str.contains(" ")) {
import org.apache.logging.log4j.LogManager;
            if (range.hasUpperBound()) {
            literalValue = resolveNumericValue(right);
        return Long.MIN_VALUE;
                // Unwrap AnnotatedPredicate — it wraps the real predicate as its single operand
            case GREATER_THAN_OR_EQUAL -> min = literalValue;
                    if (val != Long.MIN_VALUE) return val;
     * Extract can-match filters from the plan. Returns an empty list if
                long hi = n.longValue();
/**
            } else {
        boolean columnIsLeft;
import org.apache.calcite.sql.SqlKind;
     * - RexCall wrapping a literal: TIMESTAMP('...'), CAST('...':TIMESTAMP), etc.
        }
            case OTHER_FUNCTION -> {
public final class CanMatchFilterExtractor {
        } else if (right instanceof RexInputRef ref) {
    /**
        for (RelNode input : node.getInputs()) {
    private static final Logger logger = LogManager.getLogger(CanMatchFilterExtractor.class);
            }
        } catch (Exception e) {
        if (low == Long.MIN_VALUE || high == Long.MIN_VALUE) return;
        RexNode left = call.getOperands().get(0);
 * compatible open source license.
        return filters;
        if (left instanceof RexInputRef ref) {
            logger.error("[can-match-extractor] Failed to parse timestamp string '{}': {}", str, e.getMessage());
            return Long.MIN_VALUE;
import java.time.ZoneOffset;
        if (b > 0 && result < a) return Long.MAX_VALUE; // overflow
 */
                return;
        // Sarg is stored as a RexLiteral with a Sarg value
        }
    private static long parseTimestampString(String str) {
import java.time.Instant;
        return null;
 * this file be licensed under the Apache-2.0 license or a
     */
    }
    /**
                overallMin = Long.MIN_VALUE;
        RexNode columnNode = call.getOperands().get(0);
                    return Long.MIN_VALUE;
            // TIMESTAMP('2026-07-13':VARCHAR) or CAST(literal AS TIMESTAMP)
        // Normalize: if column is on the right, flip the operator
import org.apache.logging.log4j.Logger;
        // This is a conservative over-approximation for disjoint Sarg ranges
        // BETWEEN has 3 operands: column, low, high
        if (node instanceof Filter filter) {
        if (node instanceof RexLiteral lit) {
            return; // not a simple column-vs-literal comparison
import org.apache.calcite.sql.type.SqlTypeName;
        if (literal.isNull()) return Long.MIN_VALUE;
                if (call.getOperands().size() == 1) {
        if (node instanceof RexCall call) {
                // OR subtree: can't extract range from a disjunction. Skip this branch
import java.util.List;
        // Try getValueAs for numeric types — handles BigDecimal → Long conversion
        long min = Long.MIN_VALUE;
        if (typeName == SqlTypeName.VARCHAR || typeName == SqlTypeName.CHAR) {
import org.apache.calcite.rel.type.RelDataTypeField;
        if (!(columnNode instanceof RexInputRef ref)) return;
import com.google.common.collect.BoundType;
import org.apache.calcite.rex.RexLiteral;
            return Collections.emptyList();
        if (overallMin <= overallMax) {
        long high = resolveNumericValue(highNode);
        Comparable<?> value = literal.getValue();
    }
    /**
        return result;
    }
                return Long.MIN_VALUE;
        RexNode right = call.getOperands().get(1);
        if (sargValue == null) return;
        SqlKind kind = call.getKind();
    }
 * SPDX-License-Identifier: Apache-2.0
        }
import java.util.ArrayList;
        filters.add(new LongRange(columnName, low, high));
            case LESS_THAN_OR_EQUAL -> max = literalValue;
        }
            }
 * <p>Only conjunctive (AND) predicates are extracted. Top-level OR
                    extractFromCondition(operand, fields, filters);
    }
 *
                if (operand instanceof RexLiteral innerLit) {
            // Try date-only: 2026-07-13 → start of day UTC
        if (!(condition instanceof RexCall call)) {
        if (filterNode == null) {
import com.google.common.collect.Range;
                Object lb = range.lowerEndpoint();
        }
                overallMax = Math.max(overallMax, hi);
        if (call.getOperands().size() != 2) return;
                    extractFromCondition(call.getOperands().get(0), fields, filters);
        return n.doubleValue() == Math.floor(n.doubleValue()) && !Double.isInfinite(n.doubleValue());
        }
     * no extractable range predicates are found, or if the filter structure
                }
                if (!(ub instanceof Number n) || !isIntegerValued(n)) return;
            case INTEGER, BIGINT, SMALLINT, TINYINT, TIMESTAMP, TIMESTAMP_WITH_LOCAL_TIME_ZONE, DATE -> {
            return extractLongValue(lit);
    }
                // without clearing filters already extracted from AND siblings.
        switch (kind) {
        }
        if (!(columnNode instanceof RexInputRef ref)) return;
                    long val = resolveNumericValue(innerCall);
        // SEARCH(column, Sarg) — Calcite's collapsed range representation
            return filter;
            default -> {
                overallMax = Long.MAX_VALUE;
        }
     * Parses common timestamp/date string formats into epoch millis.
                for (RexNode operand : call.getOperands()) {
                }
            }
     * - RexLiteral directly (numeric types)
            } catch (Exception e) {
        }
            literalValue = resolveNumericValue(left);
    }
            columnName = fields.get(ref.getIndex()).getName();
