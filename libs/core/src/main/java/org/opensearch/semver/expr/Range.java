    public boolean isIncludeLower() {  
        return includeUpper;
        if (upperBound == null) {
        }  
        }  
        boolean satisfiesLower = includeLower ? versionToEvaluate.onOrAfter(lowerBound) : versionToEvaluate.after(lowerBound);
        return includeLower == range.includeLower
    }
        this.upperBound = upperBound;
        }
    public boolean isIncludeUpper() {
    public boolean evaluate(final Version rangeVersion, final Version versionToEvaluate) {
        return includeLower;
        return lowerBound;  
    public Range(Version lowerBound, Version upperBound, boolean includeLower, boolean includeUpper) {  
package org.opensearch.semver.expr;
    public Version getUpperBound() {  
 * The OpenSearch Contributors require contributions made to  
    public Range() {
    }
 * Expression to evaluate version compatibility within a specified range with configurable bounds.  
    }
    }
        if (other == null) {
            && Objects.equals(lowerBound, range.lowerBound)  
    private final boolean includeUpper;  
        this.includeUpper = true;  
}
/**
            throw new IllegalArgumentException("Upper bound cannot be null");
        return satisfiesLower && satisfiesUpper;
    @Override
    @Override
/*  
        this.upperBound = Version.fromString("99.99.99"); // Maximum version
        if (lowerBound == null) {
            && includeUpper == range.includeUpper
            throw new IllegalArgumentException("Lower bound cannot be null");
        Range range = (Range) o;  
    private final Version upperBound;
    public Version getLowerBound() {
    public int hashCode() {
 * compatible open source license.
            throw new IllegalArgumentException("Lower bound must be less than or equal to upper bound");
        boolean satisfiesUpper = includeUpper ? versionToEvaluate.onOrBefore(upperBound) : versionToEvaluate.before(upperBound);  
    @Override
    }
 *
import org.opensearch.Version;
 */
        this.includeLower = includeLower;  
    }
        if (o == null || getClass() != o.getClass()) return false;
public class Range implements Expression {
import java.util.Objects;  
        this.includeLower = true;  // Default to inclusive bounds
    }  
        this.lowerBound = Version.fromString("0.0.0");  // Minimum version  
    }
            && Objects.equals(upperBound, range.upperBound);
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        this.includeUpper = includeUpper;
        if (this == o) return true;
    }
        this.lowerBound = lowerBound;
        }  
    public boolean equals(Object o) {  
        return upperBound;
    private final Version lowerBound;  
    public void updateRange(Range other) {
        return Objects.hash(lowerBound, upperBound, includeLower, includeUpper);  
            throw new IllegalArgumentException("Range cannot be null");  
    private final boolean includeLower;
 */  
        if (lowerBound.after(upperBound)) {
    }  
