        RangeQueryConstraint upperExclusive = constraint("1970-01-01T00:00:00Z", "1970-01-01T00:00:01Z", true, false);
        assertTrue(evaluators.canMatch(bounds(100L, 200L, false), constraint(300L, 400L, true, true), context));
                context
        RangeQueryConstraint query = constraint("1970-01-01T00:00:03Z", "1970-01-01T00:00:04Z", true, true);
            )
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint("not-a-date", "1970-01-01T00:00:02Z", true, true), context));
    public void testCanMatchReturnsFalseForEmptyQueryRange() {
    public void testCanMatchParsesDateNanosResolutionTypeCaseInsensitively() {
            )
        @Override
        RangeQueryConstraint lowerExclusive = constraint("1970-01-01", null, false, true);
        assertTrue(
    }
                new DateRangeFieldDomain("@timestamp", "1000000000", "2000000000", true, "test", null, "nanoseconds"),
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(201L, null, true, true), context));
    }
        assertFalse(evaluators.canMatch(bounds(1_000L, 2_000L, true), upperExclusive, context));
        RangeQueryConstraint query = constraint("now-2m", "now", true, true);
        );
    public void testCanMatchHonorsInclusiveAndExclusiveDateRangeBoundaries() {
    }
    private static DateRangeFieldDomain bounds(long min, long max, boolean finalized) {
        String timeZone,
                context
        assertFalse(evaluators.canMatch(bounds(86_399_999L, 86_399_999L, true), lowerExclusive, context));
        assertTrue(evaluators.canMatch(bounds(0L, 86_399_999L, true), query, context));
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
        assertTrue(evaluators.canMatch(bounds(0L, 0L, true), lowerInclusive, context));
        return new DateRangeFieldDomain("@timestamp", min, max, finalized, "test");
        Object lower,
        RangeQueryConstraint query = constraint("1970/01/01", "1970/01/02", true, false);
 * SPDX-License-Identifier: Apache-2.0
            )
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint(null, 100L, true, true), context));
        RangeQueryConstraint query = constraint("@timestamp", "1970-01-01", null, true, true, null, "+01:00", null);
    public void testCanMatchHandlesSinglePointDateRanges() {
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint(50L, 100L, true, true), context));
            evaluators.canMatch(
            )
                new DateRangeFieldDomain("@timestamp", "3000000000", "4000000000", true, "test", null, "nanoseconds"),
        assertTrue(evaluators.canMatch(domain, inclusive, context));
            evaluators.canMatch(
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint("other_field", 300L, 400L, true, true), context));
        assertTrue(evaluators.canMatch(bounds(0L, 9_000L, true), query, searchStartContext));
    public void testCanMatchParsesIsoDateRangeConstraints() {
                new DateRangeFieldDomain("@timestamp", "86400000", "172799999", true, "test", "yyyy/MM/dd", "milliseconds"),
    public void testCanMatchParsesDateNanosBounds() {
    public void testCanMatchParsesQueryTimeZone() {
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(null, 99L, true, true), context));
    public void testCanMatchReturnsFalseForDisjointDateRanges() {
    private final FieldDomainEvaluators evaluators = FieldDomainEvaluators.defaultEvaluators();
 *
        String field,
    }
        private final String field;
        assertTrue(evaluators.canMatch(bounds(86_399_999L, 86_399_999L, true), upperInclusive, context));
    private static RangeQueryConstraint constraint(
    public void testCanMatchHandlesOpenEndedDateRanges() {
        RangeQueryConstraint exclusive = constraint("1970-01-01T00:00:02Z", "1970-01-01T00:00:03Z", false, true);
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(null, 99L, true, true), context));
        assertTrue(evaluators.canMatch(bounds(1_000L, 2_000L, true), lowerInclusive, context));
        public String type() {
 */
        assertFalse(evaluators.canMatch(bounds(100L, 100L, true), constraint(100L, 100L, true, false), context));
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint(200L, null, true, true), context));
    public void testCanMatchParsesCustomMetadataFormat() {
                query,
import org.opensearch.common.geo.ShapeRelation;
        );
                query,
                constraint(300L, 400L, true, true),
        RangeQueryConstraint upperInclusive = constraint(null, "1970-01-01", true, true);
        assertFalse(evaluators.canMatch(bounds(11_000L, 12_000L, true), query, searchStartContext));
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint(150L, 250L, true, true), context));
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), (QueryConstraint) () -> "@timestamp", context));
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint("now--", "now", true, true), context));
                new DateRangeFieldDomain("@timestamp", "1000000000", "2000000000", true, "test", null, "DATE_NANOS"),
    }
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint(200L, 300L, true, true), context));
    }
                query,
    }
        RangeQueryConstraint upperExclusive = constraint(null, "1970-01-01", true, false);
 * this file be licensed under the Apache-2.0 license or a
    public void testCanMatchHonorsDateNanosBoundaryTouch() {
                context
    }
        assertTrue(evaluators.canMatch(bounds(3_000L, 4_000L, true), query, context));
    }
            )
        assertTrue(evaluators.canMatch(bounds(100L, 100L, true), constraint(100L, 100L, true, true), context));
        assertFalse(evaluators.canMatch(bounds(86_400_000L, 86_400_000L, true), upperInclusive, context));
        assertFalse(evaluators.canMatch(bounds(0L, 0L, true), upperExclusive, context));
        RangeQueryConstraint query = constraint("1970-01-01T00:00:03Z", "1970-01-01T00:00:04Z", true, true);
    }
    private static RangeQueryConstraint constraint(Object lower, Object upper, boolean includeLower, boolean includeUpper) {
            evaluators.canMatch(
        @Override
 * compatible open source license.
    }
        }
        boolean includeUpper,
                query,
    }
                context
        );
        FieldDomainEvaluationContext searchStartContext = new FieldDomainEvaluationContext(() -> 10_000L);
        RangeQueryConstraint upperInclusive = constraint("1970-01-01T00:00:00Z", "1970-01-01T00:00:01Z", true, true);
                query,
        String format,
            return field;
            )
    ) {
        assertFalse(evaluators.canMatch(bounds(1_000L, 2_000L, true), lowerExclusive, context));
    }
    }
import org.opensearch.test.OpenSearchTestCase;
            )
        public boolean finalized() {
        assertFalse(evaluators.canMatch(bounds(-1L, -1L, true), lowerInclusive, context));
    public void testCanMatchParsesDateMathUsingSearchStartTime() {
        RangeQueryConstraint lowerInclusive = constraint("1970-01-01", null, true, true);
        assertTrue(evaluators.canMatch(new UnsupportedFieldDomain("@timestamp"), constraint(300L, 400L, true, true), context));
        assertTrue(
        assertFalse(evaluators.canMatch(domain, exclusive, context));
        RangeQueryConstraint query = constraint("1970-01-01T00:00:03Z", "1970-01-01T00:00:04Z", true, true);
import org.opensearch.index.fielddomain.FieldDomain;
                context
            return true;
    }
    }
        }
        RangeQueryConstraint lowerExclusive = constraint("1970-01-01T00:00:02Z", "1970-01-01T00:00:03Z", false, true);
        }
        assertFalse(
                constraint("@timestamp", 300L, 400L, true, true, null, null, ShapeRelation.INTERSECTS),
    public void testCanMatchParsesPartialDateRangeConstraints() {
        DateRangeFieldDomain domain = new DateRangeFieldDomain("@timestamp", "2000000000", "2000000000", true, "test", null, "nanoseconds");
                bounds(100L, 200L, true),
        @Override
        public String field() {
            this.field = field;
        RangeQueryConstraint inclusive = constraint("1970-01-01T00:00:02Z", "1970-01-01T00:00:03Z", true, true);
        assertTrue(evaluators.canMatch(bounds(86_400_000L, 86_400_000L, true), lowerExclusive, context));
        }
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(200L, 400L, false, true), context));
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(300L, 400L, true, true), context));
        RangeQueryConstraint query = constraint("1970-01-01", "1970-01-02", true, false);
        assertFalse(evaluators.canMatch(bounds(-3_600_001L, -3_600_001L, true), query, context));
        );
            evaluators.canMatch(
        RangeQueryConstraint lowerInclusive = constraint("1970-01-01T00:00:02Z", "1970-01-01T00:00:03Z", true, true);
        assertTrue(evaluators.canMatch(bounds(1_000L, 2_000L, true), upperInclusive, context));
        assertFalse(evaluators.canMatch(bounds(1_000L, 2_000L, true), query, context));
    private static final class UnsupportedFieldDomain implements FieldDomain {
        Object upper,
        assertTrue(evaluators.canMatch(bounds(-1L, -1L, true), upperExclusive, context));
        assertTrue(
        private UnsupportedFieldDomain(String field) {
                query,
        assertTrue(evaluators.canMatch(bounds(-3_600_000L, -3_600_000L, true), query, context));
    public void testCanMatchReturnsTrueForIntersectingDateRanges() {
    public void testCanMatchHonorsPartialDateRoundingForInclusivity() {
        );
        );
    public void testCanMatchUsesQueryFormatOverMetadataFormat() {
        return constraint("@timestamp", lower, upper, includeLower, includeUpper);
            evaluators.canMatch(
}
    }
    private final FieldDomainEvaluationContext context = new FieldDomainEvaluationContext(() -> 0L);
 * The OpenSearch Contributors require contributions made to
        return new RangeQueryConstraint(field, lower, upper, includeLower, includeUpper, format, timeZone, relation);
public class DateRangeFieldDomainEvaluatorTests extends OpenSearchTestCase {
        assertTrue(
        );
        assertFalse(
            evaluators.canMatch(
        ShapeRelation relation
        assertFalse(
        );
                context
            return "unsupported";
        boolean includeLower,
    public void testCanMatchReturnsTrueWhenEvaluationIsUnsupportedOrUnsafe() {
            )
        assertFalse(evaluators.canMatch(bounds(86_400_000L, 172_799_999L, true), query, context));
/*
        return constraint(field, lower, upper, includeLower, includeUpper, null, null, null);
    }
        RangeQueryConstraint query = constraint("@timestamp", "1970|01|01", null, true, true, "yyyy|MM|dd", null, null);
    private static RangeQueryConstraint constraint(String field, Object lower, Object upper, boolean includeLower, boolean includeUpper) {
        assertFalse(evaluators.canMatch(bounds(100L, 100L, true), constraint(100L, 100L, false, true), context));
                new DateRangeFieldDomain("@timestamp", "100", "200", true, "test", "[", "milliseconds"),
                new DateRangeFieldDomain("@timestamp", "0", "86399999", true, "test", "yyyy/MM/dd", "milliseconds"),
    }
    }
    }
    }
                context
            evaluators.canMatch(
        assertFalse(
            evaluators.canMatch(
                new DateRangeFieldDomain("@timestamp", "-1", "-1", true, "test", "yyyy/MM/dd", "milliseconds"),
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(100L, 101L, false, false), context));
package org.opensearch.action.search.pruning;
                context
