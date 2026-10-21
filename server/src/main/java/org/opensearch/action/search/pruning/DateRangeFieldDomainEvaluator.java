            upperInclusive = parsed.get();
 * compatible open source license.
            }
                resolution
import java.util.Optional;
    }
        if (constraint.hasLowerBound()) {
            return true;
        DateMathParser parser,
        ZoneId zone,
        }
        private NormalizedRange(long min, long max) {
                constraint.includeUpper(),
            }
        return Optional.of(new NormalizedRange(lowerInclusive, upperInclusive));
 */
    public boolean canMatch(FieldDomain domain, QueryConstraint constraint, FieldDomainEvaluationContext context) {
    private static DateFieldMapper.Resolution resolveResolution(DateRangeFieldDomain domain) {
        }
        NormalizedRange index = indexRange.get();
                    return Optional.of(NormalizedRange.EMPTY);
        return null;
     * calling evaluators.
import java.time.ZoneId;
            if (parsed.isEmpty()) {
            return Optional.of(
    /**
        private boolean isEmpty() {
        boolean roundUp,
/**
                DateFieldMapper.DateFieldType.parseToLong(value, roundUp, zone, parser, context.nowInMillisSupplier(), resolution)
            // Match RangeQueryBuilder's date-bound rounding: inclusive upper bounds round up to the end of the parsed value.
            return true;
        if (queryRange.isEmpty()) {
        if (lowerInclusive > upperInclusive) {
                if (lowerInclusive == Long.MAX_VALUE) {
            long max = Long.parseLong(domain.max());
        long upperInclusive = Long.MAX_VALUE;
            return Optional.empty();
    ) {
        RangeQueryConstraint constraint,
        if (resolution == null) {
        if (dateRangeDomain.finalized() == false) {
        private final long min;
        }
        DateFieldMapper.Resolution resolution = resolveResolution(domain);
            return true;
 * Unsupported domains, unsupported constraints, parse failures, and invalid resolutions all return {@code true}
                    return Optional.of(NormalizedRange.EMPTY);
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
}
            return Optional.of(NormalizedRange.EMPTY);
 * this file be licensed under the Apache-2.0 license or a
        if (!(domain instanceof DateRangeFieldDomain dateRangeDomain) || !(constraint instanceof RangeQueryConstraint rangeConstraint)) {
            if (min > max) {
        DateFieldMapper.Resolution resolution
                context,
            return Optional.empty();
            // Match RangeQueryBuilder's date-bound rounding: exclusive lower bounds round up before the +1 adjustment.
            String format = constraint.format() == null ? domain.format() : constraint.format();
    private static final class NormalizedRange {
        Object value,
        } catch (RuntimeException e) {
        private boolean intersects(NormalizedRange other) {
 * The OpenSearch Contributors require contributions made to
     * Unfinalized domains are treated as potentially matching, even though the pruning service also filters them before
import java.util.Locale;
 *
        }
/*
            }
        } catch (NumberFormatException e) {
    private Optional<NormalizedRange> parseQueryRange(
        }
        }
     * Returns {@code false} only when the query date range is provably disjoint from the finalized index date range.
                constraint.lowerValue(),
            Optional<Long> parsed = parseDateValue(
        FieldDomainEvaluationContext context,
            if (constraint.includeUpper() == false) {
                timeZone,
        } catch (RuntimeException e) {
            parser = format == null
    ) {
    }
package org.opensearch.action.search.pruning;
        }
        ZoneId timeZone;
    private static Optional<Long> parseDateValue(
     */
 *
    private static Optional<NormalizedRange> parseIndexRange(DateRangeFieldDomain domain) {
        private static final NormalizedRange EMPTY = new NormalizedRange(1L, 0L);
            return null;
            );
            lowerInclusive = parsed.get();
            );
            return false;
        NormalizedRange query = queryRange.get();
            return max >= other.min && min <= other.max;
        long lowerInclusive = Long.MIN_VALUE;
        DateRangeFieldDomain domain,
                ? DateFieldMapper.getDefaultDateTimeFormatter().toDateMathParser()
            long min = Long.parseLong(domain.min());
                }
        try {
        if (indexRange.isEmpty()) {
        if (constraint.hasUpperBound()) {
import org.opensearch.common.time.DateFormatter;
                return resolution;
                }
        return index.intersects(query);
                resolution
        }
                lowerInclusive++;
        }
import org.opensearch.index.fielddomain.FieldDomain;
            return Optional.of(new NormalizedRange(min, max));
                parser,
 * so pruning remains conservative.
                return Optional.empty();
        }
import org.opensearch.common.time.DateMathParser;
            timeZone = constraint.timeZone() == null ? null : ZoneId.of(constraint.timeZone());
        }
            return Optional.empty();
            );
                if (upperInclusive == Long.MIN_VALUE) {
            if (parsed.isEmpty()) {
    }
                timeZone,
                parser,
    @Override
        private final long max;
 * SPDX-License-Identifier: Apache-2.0
 * Evaluates date range index bounds against generic range query constraints.
        }
            this.min = min;
                context,
        if (constraint.relation() != null) {
            if (constraint.includeLower() == false) {
        if (domain.resolution() == null || domain.resolution().isEmpty()) {
        }
                return Optional.empty();
        try {
                return Optional.empty();
            if (resolution.name().toLowerCase(Locale.ROOT).equals(configured) || resolution.type().equals(configured)) {
        } catch (RuntimeException e) {
        }
                constraint.includeLower() == false,
                upperInclusive--;
        try {
            return true;
        Optional<NormalizedRange> indexRange = parseIndexRange(dateRangeDomain);
        String configured = domain.resolution().toLowerCase(Locale.ROOT);
        for (DateFieldMapper.Resolution resolution : DateFieldMapper.Resolution.values()) {
        }
            }
        }
            this.max = max;
                : DateFormatter.forPattern(format).toDateMathParser();
        if (query.isEmpty()) {
            return true;
            return Optional.empty();
        FieldDomainEvaluationContext context
            }
            Optional<Long> parsed = parseDateValue(
public final class DateRangeFieldDomainEvaluator implements FieldDomainEvaluator {
        }
    }
            }
        }
                constraint.upperValue(),
            return min > max;
        Optional<NormalizedRange> queryRange = parseQueryRange(dateRangeDomain, rangeConstraint, context);
 */
        try {
    }
        }
        if (index.isEmpty()) {
            return Optional.empty();
        }
            return Optional.empty();
    }
        DateMathParser parser;
import org.opensearch.index.mapper.DateFieldMapper;
