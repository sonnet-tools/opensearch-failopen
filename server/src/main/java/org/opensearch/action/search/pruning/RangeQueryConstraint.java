    }  
        return includeUpper;
        String timeZone,  
    }
 *
        this.lowerValue = lowerValue;
 * compatible open source license.
    public boolean includeLower() {
     * @param relation optional range relation  
    }
    /**
        ShapeRelation relation
     * Whether this constraint has a lower bound.
        return timeZone;  
 */  
import java.util.Objects;  
 * range interpretation parameters such as format, time zone, and relation. Type-specific semantics such as date parsing,
    /**
    }  
    /**
    @Override
    public String format() {
     */
    }  
}
        Object lowerValue,
     */  
    public boolean hasLowerBound() {
    private final Object upperValue;
    public boolean includeUpper() {  
    private final Object lowerValue;  
/**
 * The OpenSearch Contributors require contributions made to  
     * @param includeUpper whether the upper bound is inclusive  
/*  
            throw new IllegalArgumentException("range constraint must have at least one bound");
     * Optional query-level time zone as supplied by the range query builder.  
        }  
     * Whether the upper bound is inclusive.
     */
 */  
        return upperValue != null;  
    private final boolean includeUpper;  
    }
    }
        String field,  
    /**  
        if (lowerValue == null && upperValue == null) {
package org.opensearch.action.search.pruning;
    }
    public boolean hasUpperBound() {
        return lowerValue;
        }  
    ) {
 * state exposed by {@link org.opensearch.index.query.RangeQueryBuilder}: lower/upper bounds, inclusivity, and optional  
     * Lower bound value as supplied by the query builder, or {@code null} when unbounded.
    /**
    }
    }
        if (field.isEmpty()) {
    public String field() {
     * @param format optional query-level format
        return includeLower;  
        this.includeUpper = includeUpper;
    public Object upperValue() {
        return relation;
        return format;
     * @param includeLower whether the lower bound is inclusive
     */  
    private final ShapeRelation relation;  
        return upperValue;
     */
    /**
    private final String format;
    /**
            throw new IllegalArgumentException("field must not be empty");
     * @param timeZone optional query-level time zone
     *
        String format,
        boolean includeUpper,
    public String timeZone() {
 *
    public RangeQueryConstraint(
     * Optional query-level format as supplied by the range query builder.
        Object upperValue,
    /**  
    private final String timeZone;
     * @param upperValue upper bound value, or {@code null} for unbounded
 * This class intentionally models range-query structure only. Its fields are an immutable snapshot of the normalized
     */
     * Whether this constraint has an upper bound.  
     * Creates a range query constraint with optional range-query interpretation parameters.  
 * Generic query constraint extracted from a mandatory range query.  
 * this file be licensed under the Apache-2.0 license or a
        this.format = format;
        return lowerValue != null;
     * @param field constrained field name
    /**
     * Whether the lower bound is inclusive.  
    private final boolean includeLower;
    public ShapeRelation relation() {  
        return field;  
     */  
        this.upperValue = upperValue;
 * SPDX-License-Identifier: Apache-2.0
    }
        this.relation = relation;
        this.includeLower = includeLower;  
public final class RangeQueryConstraint implements QueryConstraint {
    /**  
        this.timeZone = timeZone;  
     * @param lowerValue lower bound value, or {@code null} for unbounded  
    private final String field;
import org.opensearch.common.geo.ShapeRelation;
    public Object lowerValue() {  
        this.field = Objects.requireNonNull(field, "field must not be null");  
     */
     */
     * Optional range relation as supplied by the range query builder.
     * Upper bound value as supplied by the query builder, or {@code null} when unbounded.
     */
 * numeric coercion, or geo interpretation are handled by field-domain evaluators.
        boolean includeLower,  
