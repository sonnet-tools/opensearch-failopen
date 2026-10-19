            if (parsed.isEmpty()) {
        boolean roundUp,
import org.opensearch.common.time.DateFormatter;
            return Optional.of(NormalizedRange.EMPTY);
            return Optional.of(new NormalizedRange(min, max));
                context,
        } catch (RuntimeException e) {
            if (constraint.includeLower() == false) {  
            Optional<Long> parsed = parseDateValue(  
        private NormalizedRange(long min, long max) {  
                DateFieldMapper.DateFieldType.parseToLong(value, roundUp, zone, parser, context.nowInMillisSupplier(), resolution)  
        }
        }
                if (upperInclusive == Long.MIN_VALUE) {  
                timeZone,  
            return max >= other.min && min <= other.max;
                constraint.lowerValue(),
            return true;  
            }  
        } catch (NumberFormatException e) {  
            return null;  
}
        RangeQueryConstraint constraint,
        private final long min;  
        }
            );  
            return false;
                }
        NormalizedRange query = queryRange.get();
            long max = Long.parseLong(domain.max());
package org.opensearch.action.search.pruning;
                    return Optional.of(NormalizedRange.EMPTY);
        private static final NormalizedRange EMPTY = new NormalizedRange(1L, 0L);
import java.util.Locale;
    ) {  
        for (DateFieldMapper.Resolution resolution : DateFieldMapper.Resolution.values()) {
    private static final class NormalizedRange {  
        }
    }  
 * Unsupported domains, unsupported constraints, parse failures, and invalid resolutions all return {@code true}
        return Optional.of(new NormalizedRange(lowerInclusive, upperInclusive));
import org.opensearch.index.fielddomain.FieldDomain;
            );
import org.opensearch.index.fielddomain.DateRangeFieldDomain;  
            return true;
        if (lowerInclusive > upperInclusive) {
 * Evaluates date range index bounds against generic range query constraints.  
            return Optional.of(
 * The OpenSearch Contributors require contributions made to  
        }
        }  
            if (min > max) {
        }
 */
        } catch (RuntimeException e) {
        if (constraint.hasLowerBound()) {
        if (queryRange.isEmpty()) {
    private static Optional<Long> parseDateValue(
        private boolean isEmpty() {
import java.time.ZoneId;
            return Optional.empty();  
    }
            long min = Long.parseLong(domain.min());  
    }
            Optional<Long> parsed = parseDateValue(
 * this file be licensed under the Apache-2.0 license or a
    private static DateFieldMapper.Resolution resolveResolution(DateRangeFieldDomain domain) {
        if (indexRange.isEmpty()) {  
 * SPDX-License-Identifier: Apache-2.0
            return Optional.empty();
        if (query.isEmpty()) {  
        }
                parser,  
        DateRangeFieldDomain domain,  
 *
                constraint.includeUpper(),
                timeZone,
                upperInclusive--;  
            return Optional.empty();  
     * Unfinalized domains are treated as potentially matching, even though the pruning service also filters them before
            if (constraint.includeUpper() == false) {
        }  
                context,
        DateMathParser parser,  
            return true;
            if (parsed.isEmpty()) {
                return Optional.empty();  
        }
        if (constraint.hasUpperBound()) {  
        }
public final class DateRangeFieldDomainEvaluator implements FieldDomainEvaluator {
            return true;
        try {
        return index.intersects(query);
        if (!(domain instanceof DateRangeFieldDomain dateRangeDomain) || !(constraint instanceof RangeQueryConstraint rangeConstraint)) {
        if (index.isEmpty()) {
            }
     */
        FieldDomainEvaluationContext context
        DateMathParser parser;
        DateFieldMapper.Resolution resolution
    /**  
                return resolution;  
        Object value,  
        ZoneId zone,
    private Optional<NormalizedRange> parseQueryRange(
import org.opensearch.index.mapper.DateFieldMapper;
    private static Optional<NormalizedRange> parseIndexRange(DateRangeFieldDomain domain) {
/*  
    @Override
        NormalizedRange index = indexRange.get();  
                }  
        ZoneId timeZone;
                return Optional.empty();
        }  
    }  
        }
     * calling evaluators.  
        String configured = domain.resolution().toLowerCase(Locale.ROOT);  
                parser,
            return Optional.empty();  
            return Optional.empty();
            this.max = max;
            parser = format == null
        DateFieldMapper.Resolution resolution = resolveResolution(domain);
    }
        Optional<NormalizedRange> indexRange = parseIndexRange(dateRangeDomain);
        } catch (RuntimeException e) {
/**
            timeZone = constraint.timeZone() == null ? null : ZoneId.of(constraint.timeZone());
                ? DateFieldMapper.getDefaultDateTimeFormatter().toDateMathParser()
                : DateFormatter.forPattern(format).toDateMathParser();  
        }
            }
     * Returns {@code false} only when the query date range is provably disjoint from the finalized index date range.
        }  
        private boolean intersects(NormalizedRange other) {  
 * so pruning remains conservative.  
        try {
            // Match RangeQueryBuilder's date-bound rounding: exclusive lower bounds round up before the +1 adjustment.
        private final long max;
        if (constraint.relation() != null) {  
 * compatible open source license.
                    return Optional.of(NormalizedRange.EMPTY);
import java.util.Optional;  
            return min > max;  
import org.opensearch.common.time.DateMathParser;
        if (domain.resolution() == null || domain.resolution().isEmpty()) {
                resolution
    }  
            upperInclusive = parsed.get();
            }
        Optional<NormalizedRange> queryRange = parseQueryRange(dateRangeDomain, rangeConstraint, context);
            }
        }
            // Match RangeQueryBuilder's date-bound rounding: inclusive upper bounds round up to the end of the parsed value.
        try {  
            return Optional.empty();
            this.min = min;
        }
        long lowerInclusive = Long.MIN_VALUE;  
 *
    ) {  
        if (resolution == null) {
        try {
            );
                return Optional.empty();  
            return true;
            lowerInclusive = parsed.get();
                constraint.upperValue(),  
        }  
        long upperInclusive = Long.MAX_VALUE;
            }
        }  
                if (lowerInclusive == Long.MAX_VALUE) {
    public boolean canMatch(FieldDomain domain, QueryConstraint constraint, FieldDomainEvaluationContext context) {  
                resolution  
            String format = constraint.format() == null ? domain.format() : constraint.format();  
        FieldDomainEvaluationContext context,
            if (resolution.name().toLowerCase(Locale.ROOT).equals(configured) || resolution.type().equals(configured)) {
                constraint.includeLower() == false,
        return null;  
                lowerInclusive++;
        }  
 */  
        if (dateRangeDomain.finalized() == false) {
