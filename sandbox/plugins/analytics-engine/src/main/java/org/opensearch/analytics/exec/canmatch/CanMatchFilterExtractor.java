        return result;
            columnIsLeft = true;  
            try {  
            } catch (Exception e) {  
    private static long resolveNumericValue(RexNode node) {
        }
            columnName = fields.get(ref.getIndex()).getName();
import java.time.ZoneOffset;
                }  
import org.apache.calcite.rex.RexNode;  
 * causes the extractor to return an empty list (no can-match for that query).
            // TIMESTAMP('2026-07-13':VARCHAR) or CAST(literal AS TIMESTAMP)  
import org.apache.calcite.rel.RelNode;  
     */  
     */  
            }  
import java.util.ArrayList;  
        }  
        }
        SqlTypeName typeName = literal.getTypeName();  
        if (sargValue == null) return;  
            case GREATER_THAN_OR_EQUAL -> min = literalValue;  
            kind = kind.reverse();
                    long val = extractTimestampFromStringLiteral(innerLit);
    private static void extractFromCondition(RexNode condition, List<RelDataTypeField> fields, List<CanMatchFilter> filters) {
        if (call.getOperands().size() != 3) return;
                    return Long.MIN_VALUE;
    /**
        filters.add(new LongRange(columnName, low, high));
    private static void extractComparison(RexCall call, List<RelDataTypeField> fields, List<CanMatchFilter> filters) {
            default -> {
    }  
                }  
     * - RexLiteral directly (numeric types)
        if (typeName == SqlTypeName.TIMESTAMP || typeName == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE || typeName == SqlTypeName.DATE) {
        filters.add(new LongRange(columnName, min, max));
        // Try getValueAs for numeric types — handles BigDecimal → Long conversion
    private static boolean isIntegerValued(Number n) {
                } catch (Exception e) {  
                try {  
        }  
        if (b > 0 && result < a) return Long.MAX_VALUE; // overflow
            }
     * no extractable range predicates are found, or if the filter structure
 *
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rel.type.RelDataTypeField;
            if (range.hasUpperBound()) {
        }
            }
                    hi = saturateSubtract(hi, 1);
            if (range.hasLowerBound()) {  
        if (!(columnNode instanceof RexInputRef ref)) return;  
                if (range.upperBoundType() == BoundType.OPEN) {  
        // Sarg is stored as a RexLiteral with a Sarg value
                }  
        if (low == Long.MIN_VALUE || high == Long.MIN_VALUE) return;
            String strValue = literal.getValueAs(String.class);  
        if (overallMin <= overallMax) {  
        if (b > 0 && result > a) return Long.MIN_VALUE; // underflow
            if (literalValue == Long.MIN_VALUE) return;
        switch (kind) {
        }
        boolean columnIsLeft;  
            default -> {
        // Normalize: if column is on the right, flip the operator
 *
        long min = Long.MIN_VALUE;
        if (typeName == SqlTypeName.VARCHAR || typeName == SqlTypeName.CHAR) {
                // Unwrap AnnotatedPredicate — it wraps the real predicate as its single operand  
        RexNode sargNode = call.getOperands().get(1);
    }
    }  
            }
        // String literal representing a timestamp (e.g. '2026-07-13')
    }
            case LESS_THAN_OR_EQUAL -> max = literalValue;
            // Dig through to find the inner RexLiteral
                overallMin = Long.MIN_VALUE;  
import java.time.Instant;  
        if (node instanceof RexLiteral lit) {
     * - RexCall wrapping a literal: TIMESTAMP('...'), CAST('...':TIMESTAMP), etc.
        // Identify which operand is the column ref and which is the literal  
        if (!(sargValue instanceof org.apache.calcite.util.Sarg<?> sarg)) return;
import org.apache.logging.log4j.Logger;
        }
 * {@link CanMatchFilter} (AND semantics across the list).
        }
            if (literalValue == Long.MIN_VALUE) return;
            case OR -> {  
        }  
     * Parses a string-typed RexLiteral containing a timestamp/date string
        logger.debug("can-match extractor: extracted {} filters from condition {}", filters.size(), condition);
                Object ub = range.upperEndpoint();  
                // OR subtree: can't extract range from a disjunction. Skip this branch
                // Non-range predicate (equality, LIKE, etc.) — skip  
        }
        RexNode highNode = call.getOperands().get(2);
        for (Range<?> range : sarg.rangeSet.asRanges()) {
        switch (call.getKind()) {  
package org.opensearch.analytics.exec.canmatch;
 * compatible open source license.
                for (RexNode operand : call.getOperands()) {
        List<CanMatchFilter> filters = new ArrayList<>();  
                if (!(ub instanceof Number n) || !isIntegerValued(n)) return;
                // without clearing filters already extracted from AND siblings.
        List<RelDataTypeField> fields = filterNode.getInput().getRowType().getFieldList();
            case GREATER_THAN -> min = saturateAdd(literalValue, 1);
        long low = resolveNumericValue(lowNode);
    /**
 * @opensearch.internal  
            Filter found = findFilter(input);
    }
        if (filterNode == null) {  
            LocalDate date = LocalDate.parse(str);  
        // Extract the overall min/max from the Sarg's range set
            logger.error("[can-match-extractor] Failed to parse timestamp string '{}': {}", str, e.getMessage());  
        SqlKind kind = call.getKind();
                overallMin = Math.min(overallMin, lo);
        if (!columnIsLeft) {  
                return val != null ? val : Long.MIN_VALUE;
                    if (val != Long.MIN_VALUE) return val;
        // RexLiteral.getValue() returns Comparable — typically BigDecimal for numerics
        RexNode columnNode = call.getOperands().get(0);
        switch (typeName) {
    }  
                if (operand instanceof RexLiteral innerLit) {  
            }  
            // Try date-only: 2026-07-13 → start of day UTC
        } else if (right instanceof RexInputRef ref) {
import org.apache.calcite.rex.RexLiteral;
     * is not supported (e.g. top-level OR).
            case SEARCH -> extractSarg(call, fields, filters);
import org.apache.calcite.sql.SqlKind;
            }
        if (literal.isNull()) return Long.MIN_VALUE;  
                return Long.MIN_VALUE;
            columnIsLeft = false;
            }
                Long val = literal.getValueAs(Long.class);
     * into epoch millis.
    }
        String columnName;
 *
        return null;
    private static void extractSarg(RexCall call, List<RelDataTypeField> fields, List<CanMatchFilter> filters) {
            return; // not a simple column-vs-literal comparison
        }  
    private static long parseTimestampString(String str) {
        return n.doubleValue() == Math.floor(n.doubleValue()) && !Double.isInfinite(n.doubleValue());
        return filters;  
    }  
import java.util.Collections;
            return date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
        long literalValue;
        long result = a + b;  
    private static long extractTimestampFromStringLiteral(RexLiteral literal) {
            }
            filters.add(new LongRange(columnName, overallMin, overallMax));
        RexNode lowNode = call.getOperands().get(1);  
    }
            } else {
                return found;
                    val = extractLongValue(innerLit);
            for (RexNode operand : call.getOperands()) {
}
        try {
        return result;
            return Collections.emptyList();
                }
            }
            if (found != null) {  
        for (RelNode input : node.getInputs()) {
        Comparable<?> value = literal.getValue();  
    private static void extractBetween(RexCall call, List<RelDataTypeField> fields, List<CanMatchFilter> filters) {
    private CanMatchFilterExtractor() {}  
        RexNode right = call.getOperands().get(1);
                long hi = n.longValue();
    private static Filter findFilter(RelNode node) {  
            } else {
        if (node instanceof Filter filter) {
        if (value instanceof Number n) {  
    /**
                Instant instant = Instant.parse(str.replace(" ", "T") + (str.endsWith("Z") ? "" : (str.contains("T") ? "" : "Z")));
        // Already a timestamp/date-typed literal
        RexNode columnNode = call.getOperands().get(0);
        // For can-match, we take the bounding range [min of all ranges, max of all ranges]  
    }
        } catch (Exception e) {
import org.apache.calcite.sql.type.SqlTypeName;
            case LESS_THAN -> max = saturateSubtract(literalValue, 1);
     * Resolves a RexNode to a long value. Handles:  
        if (!(sargNode instanceof RexLiteral sargLiteral)) return;
        String columnName = fields.get(ref.getIndex()).getName();  
 * this file be licensed under the Apache-2.0 license or a
    private static long extractLongValue(RexLiteral literal) {
    private static long saturateAdd(long a, long b) {
/**
                    lo = saturateAdd(lo, 1);
                Object lb = range.lowerEndpoint();
import org.apache.calcite.rex.RexInputRef;
        return Long.MIN_VALUE;
                    extractFromCondition(operand, fields, filters);  
        if (value == null) return Long.MIN_VALUE;
 * Walks a Calcite {@link RelNode} plan tree and extracts range predicates
                // Recurse one level deeper (e.g. CAST(TIMESTAMP(...)))
            }
    /**  
        }  
 * <p>Only conjunctive (AND) predicates are extracted. Top-level OR  
                }
        long result = a - b;  
        }
import java.util.List;
                overallMax = Math.max(overallMax, hi);  
                return instant.toEpochMilli();  
    }  
import org.apache.calcite.rex.RexCall;  
        extractFromCondition(condition, fields, filters);
        long high = resolveNumericValue(highNode);  
        }
            case AND -> {
                }
        // BETWEEN has 3 operands: column, low, high  
            }  
        // SEARCH(column, Sarg) — Calcite's collapsed range representation
    }  
    private static long saturateSubtract(long a, long b) {
            logger.debug("can-match extractor: no Filter node found in plan");
            columnName = fields.get(ref.getIndex()).getName();  
     * Parses common timestamp/date string formats into epoch millis.
            default -> {  
                    extractFromCondition(call.getOperands().get(0), fields, filters);
        if (node instanceof RexCall call) {
            if (strValue == null) return Long.MIN_VALUE;
            case BETWEEN -> extractBetween(call, fields, filters);  
    private static final Logger logger = LogManager.getLogger(CanMatchFilterExtractor.class);
                return;
        long overallMax = Long.MIN_VALUE;  
                if (call.getOperands().size() == 1) {
                    if (val != Long.MIN_VALUE) return val;  
            if (str.contains("T") || str.contains(" ")) {
            literalValue = resolveNumericValue(left);  
        return Long.MIN_VALUE;  
     * Extract can-match filters from the plan. Returns an empty list if  
import java.time.LocalDate;
        }  
                if (range.lowerBoundType() == BoundType.OPEN) {
            if (!isIntegerValued(n)) return Long.MIN_VALUE;
            literalValue = resolveNumericValue(right);
                if (operand instanceof RexCall innerCall) {  
                if (!(lb instanceof Number n) || !isIntegerValued(n)) return;
            return n.longValue();
            return filter;
     */  
        long max = Long.MAX_VALUE;
                    return longVal != null ? longVal : Long.MIN_VALUE;
            return Long.MIN_VALUE;
        RexNode left = call.getOperands().get(0);  
            case OTHER_FUNCTION -> {
        // This is a conservative over-approximation for disjoint Sarg ranges
 */  
            return extractLongValue(lit);  
                return Long.MIN_VALUE;
        }  
import com.google.common.collect.BoundType;
                }
                overallMax = Long.MAX_VALUE;
            // Try ISO date-time: 2026-07-13T10:00:00Z or 2026-07-13 10:00:00  
import org.apache.calcite.rel.core.Filter;
        } else {  
        String columnName = fields.get(ref.getIndex()).getName();  
import com.google.common.collect.Range;
                logger.debug("can-match extractor: OR detected, skipping this branch");  
        RexNode condition = filterNode.getCondition();
 * The OpenSearch Contributors require contributions made to  
 */
        Object sargValue = sargLiteral.getValue();
                    long val = resolveNumericValue(innerCall);
            }
/*  
        }
        SqlTypeName typeName = literal.getTypeName();  
    }  
        Filter filterNode = findFilter(plan);
            case INTEGER, BIGINT, SMALLINT, TINYINT, TIMESTAMP, TIMESTAMP_WITH_LOCAL_TIME_ZONE, DATE -> {
 * suitable for can-match evaluation. Produces a flat list of  
        if (call.getOperands().size() != 2) return;  
            return;  
                    // PPL produces TIMESTAMP('2026-07-13':VARCHAR) — try string parse first
            case GREATER_THAN, GREATER_THAN_OR_EQUAL, LESS_THAN, LESS_THAN_OR_EQUAL -> extractComparison(call, fields, filters);
                    // Fallback: literal might already be numeric (e.g. epoch millis directly)
            }
                long lo = n.longValue();  
public final class CanMatchFilterExtractor {
        if (left instanceof RexInputRef ref) {
        if (!(columnNode instanceof RexInputRef ref)) return;
import org.apache.logging.log4j.LogManager;  
                    if (val != Long.MIN_VALUE) return val;  
                    Long longVal = literal.getValueAs(Long.class);
        if (!(condition instanceof RexCall call)) {
    public static List<CanMatchFilter> extract(RelNode plan) {
            return parseTimestampString(strValue);
        if (literal.isNull()) return Long.MIN_VALUE;
     */  
        long overallMin = Long.MAX_VALUE;
