        RangeQueryConstraint query = constraint("1970-01-01T00:00:03Z", "1970-01-01T00:00:04Z", true, true);
    }  
            )
 * The OpenSearch Contributors require contributions made to  
        assertTrue(evaluators.canMatch(bounds(100L, 100L, true), constraint(100L, 100L, true, true), context));  
    public void testCanMatchReturnsTrueForIntersectingDateRanges() {
        assertFalse(evaluators.canMatch(bounds(100L, 100L, true), constraint(100L, 100L, true, false), context));
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(100L, 101L, false, false), context));  
            evaluators.canMatch(
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(300L, 400L, true, true), context));
            evaluators.canMatch(  
        RangeQueryConstraint query = constraint("@timestamp", "1970-01-01", null, true, true, null, "+01:00", null);
        assertTrue(evaluators.canMatch(bounds(-3_600_000L, -3_600_000L, true), query, context));  
    private static final class UnsupportedFieldDomain implements FieldDomain {
        assertTrue(  
            evaluators.canMatch(
    }  
        RangeQueryConstraint query = constraint("1970-01-01T00:00:03Z", "1970-01-01T00:00:04Z", true, true);
        assertFalse(evaluators.canMatch(bounds(100L, 100L, true), constraint(100L, 100L, false, true), context));
        boolean includeLower,
    }
    }
        assertTrue(evaluators.canMatch(bounds(-1L, -1L, true), upperExclusive, context));
        RangeQueryConstraint query = constraint("1970-01-01", "1970-01-02", true, false);
        }  
        );
    public void testCanMatchHandlesSinglePointDateRanges() {
            evaluators.canMatch(
    public void testCanMatchParsesPartialDateRangeConstraints() {
                query,
        String format,
        RangeQueryConstraint upperInclusive = constraint(null, "1970-01-01", true, true);
    public void testCanMatchParsesCustomMetadataFormat() {
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint(50L, 100L, true, true), context));
    }  
        RangeQueryConstraint lowerInclusive = constraint("1970-01-01", null, true, true);  
    public void testCanMatchHonorsInclusiveAndExclusiveDateRangeBoundaries() {
                context
            evaluators.canMatch(  
        assertFalse(evaluators.canMatch(bounds(1_000L, 2_000L, true), lowerExclusive, context));  
                context
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint(null, 100L, true, true), context));
                context
        assertTrue(evaluators.canMatch(bounds(86_399_999L, 86_399_999L, true), upperInclusive, context));
                new DateRangeFieldDomain("@timestamp", "100", "200", true, "test", "[", "milliseconds"),
        );  
    private final FieldDomainEvaluationContext context = new FieldDomainEvaluationContext(() -> 0L);
        assertFalse(  
        );
        assertTrue(evaluators.canMatch(bounds(3_000L, 4_000L, true), query, context));
        assertFalse(evaluators.canMatch(bounds(86_400_000L, 172_799_999L, true), query, context));
    public void testCanMatchParsesIsoDateRangeConstraints() {  
        assertTrue(
        assertFalse(evaluators.canMatch(bounds(11_000L, 12_000L, true), query, searchStartContext));  
                query,
    }  
        FieldDomainEvaluationContext searchStartContext = new FieldDomainEvaluationContext(() -> 10_000L);
                new DateRangeFieldDomain("@timestamp", "1000000000", "2000000000", true, "test", null, "nanoseconds"),
            )  
        @Override
    }
            )  
        Object upper,
        String timeZone,
                context  
        }
        assertFalse(evaluators.canMatch(bounds(-1L, -1L, true), lowerInclusive, context));  
    private static RangeQueryConstraint constraint(String field, Object lower, Object upper, boolean includeLower, boolean includeUpper) {  
        @Override  
        RangeQueryConstraint exclusive = constraint("1970-01-01T00:00:02Z", "1970-01-01T00:00:03Z", false, true);  
    }  
    }
            evaluators.canMatch(
        RangeQueryConstraint upperExclusive = constraint("1970-01-01T00:00:00Z", "1970-01-01T00:00:01Z", true, false);  
    }
}  
        private UnsupportedFieldDomain(String field) {
        assertTrue(
        assertFalse(
    private static RangeQueryConstraint constraint(
                context  
    }
    public void testCanMatchParsesDateNanosResolutionTypeCaseInsensitively() {
                bounds(100L, 200L, true),  
        public boolean finalized() {
        RangeQueryConstraint lowerExclusive = constraint("1970-01-01", null, false, true);
            return field;
    }  
                new DateRangeFieldDomain("@timestamp", "1000000000", "2000000000", true, "test", null, "DATE_NANOS"),  
        }
    }
    public void testCanMatchHonorsPartialDateRoundingForInclusivity() {
/*  
    public void testCanMatchReturnsFalseForEmptyQueryRange() {
        Object lower,  
import org.opensearch.test.OpenSearchTestCase;
                query,
            )
        assertTrue(evaluators.canMatch(bounds(100L, 200L, false), constraint(300L, 400L, true, true), context));  
public class DateRangeFieldDomainEvaluatorTests extends OpenSearchTestCase {  
    ) {
                query,  
        assertFalse(
    private static RangeQueryConstraint constraint(Object lower, Object upper, boolean includeLower, boolean includeUpper) {
            )  
        );
        assertFalse(evaluators.canMatch(bounds(1_000L, 2_000L, true), upperExclusive, context));
        assertFalse(evaluators.canMatch(bounds(1_000L, 2_000L, true), query, context));  
        assertFalse(evaluators.canMatch(bounds(0L, 0L, true), upperExclusive, context));  
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), (QueryConstraint) () -> "@timestamp", context));  
        );  
    public void testCanMatchReturnsFalseForDisjointDateRanges() {
    }
                constraint(300L, 400L, true, true),  
    }  
        assertFalse(evaluators.canMatch(bounds(86_400_000L, 86_400_000L, true), upperInclusive, context));  
        );
    public void testCanMatchReturnsTrueWhenEvaluationIsUnsupportedOrUnsafe() {
        private final String field;  
                new DateRangeFieldDomain("@timestamp", "3000000000", "4000000000", true, "test", null, "nanoseconds"),  
import org.opensearch.index.fielddomain.FieldDomain;  
    }
    public void testCanMatchParsesDateNanosBounds() {  
        assertFalse(evaluators.canMatch(bounds(-3_600_001L, -3_600_001L, true), query, context));
        assertFalse(evaluators.canMatch(bounds(86_399_999L, 86_399_999L, true), lowerExclusive, context));
        return constraint("@timestamp", lower, upper, includeLower, includeUpper);  
                context
        @Override
    }
    private final FieldDomainEvaluators evaluators = FieldDomainEvaluators.defaultEvaluators();
            )  
        assertTrue(evaluators.canMatch(bounds(86_400_000L, 86_400_000L, true), lowerExclusive, context));  
    }  
            return "unsupported";
        ShapeRelation relation  
    private static DateRangeFieldDomain bounds(long min, long max, boolean finalized) {
        boolean includeUpper,  
    public void testCanMatchUsesQueryFormatOverMetadataFormat() {
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(null, 99L, true, true), context));
        return constraint(field, lower, upper, includeLower, includeUpper, null, null, null);
                constraint("@timestamp", 300L, 400L, true, true, null, null, ShapeRelation.INTERSECTS),
    public void testCanMatchParsesDateMathUsingSearchStartTime() {
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint("now--", "now", true, true), context));
        assertTrue(evaluators.canMatch(bounds(1_000L, 2_000L, true), lowerInclusive, context));
    }
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(201L, null, true, true), context));
                query,
                context
        RangeQueryConstraint lowerInclusive = constraint("1970-01-01T00:00:02Z", "1970-01-01T00:00:03Z", true, true);  
            this.field = field;  
    }
        DateRangeFieldDomain domain = new DateRangeFieldDomain("@timestamp", "2000000000", "2000000000", true, "test", null, "nanoseconds");
import org.opensearch.common.geo.ShapeRelation;
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint(200L, null, true, true), context));  
        assertFalse(evaluators.canMatch(domain, exclusive, context));
        RangeQueryConstraint query = constraint("now-2m", "now", true, true);  
            )
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(null, 99L, true, true), context));
        assertTrue(evaluators.canMatch(bounds(0L, 86_399_999L, true), query, context));
        return new DateRangeFieldDomain("@timestamp", min, max, finalized, "test");
            evaluators.canMatch(
                new DateRangeFieldDomain("@timestamp", "86400000", "172799999", true, "test", "yyyy/MM/dd", "milliseconds"),
    }
        assertFalse(evaluators.canMatch(bounds(100L, 200L, true), constraint(200L, 400L, false, true), context));  
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(evaluators.canMatch(bounds(0L, 0L, true), lowerInclusive, context));
        RangeQueryConstraint lowerExclusive = constraint("1970-01-01T00:00:02Z", "1970-01-01T00:00:03Z", false, true);
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint(150L, 250L, true, true), context));
        );
    public void testCanMatchParsesQueryTimeZone() {  
        RangeQueryConstraint query = constraint("1970/01/01", "1970/01/02", true, false);
        RangeQueryConstraint query = constraint("1970-01-01T00:00:03Z", "1970-01-01T00:00:04Z", true, true);
 */  
 * compatible open source license.
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint(200L, 300L, true, true), context));  
        }
    public void testCanMatchHandlesOpenEndedDateRanges() {
        public String type() {  
 *
        RangeQueryConstraint query = constraint("@timestamp", "1970|01|01", null, true, true, "yyyy|MM|dd", null, null);  
        );
        assertTrue(evaluators.canMatch(bounds(1_000L, 2_000L, true), upperInclusive, context));
            evaluators.canMatch(
        String field,
        return new RangeQueryConstraint(field, lower, upper, includeLower, includeUpper, format, timeZone, relation);
                query,
                context
            )
        assertTrue(
        RangeQueryConstraint upperInclusive = constraint("1970-01-01T00:00:00Z", "1970-01-01T00:00:01Z", true, true);
    public void testCanMatchHonorsDateNanosBoundaryTouch() {
                new DateRangeFieldDomain("@timestamp", "-1", "-1", true, "test", "yyyy/MM/dd", "milliseconds"),
package org.opensearch.action.search.pruning;
    }
        assertTrue(evaluators.canMatch(new UnsupportedFieldDomain("@timestamp"), constraint(300L, 400L, true, true), context));
        assertTrue(evaluators.canMatch(bounds(0L, 9_000L, true), query, searchStartContext));
        RangeQueryConstraint inclusive = constraint("1970-01-01T00:00:02Z", "1970-01-01T00:00:03Z", true, true);
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint("other_field", 300L, 400L, true, true), context));
            return true;  
        public String field() {
        assertFalse(
        assertTrue(evaluators.canMatch(bounds(100L, 200L, true), constraint("not-a-date", "1970-01-01T00:00:02Z", true, true), context));
                new DateRangeFieldDomain("@timestamp", "0", "86399999", true, "test", "yyyy/MM/dd", "milliseconds"),  
        assertTrue(evaluators.canMatch(domain, inclusive, context));  
        RangeQueryConstraint upperExclusive = constraint(null, "1970-01-01", true, false);  
