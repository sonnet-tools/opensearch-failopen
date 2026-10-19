     * Two DateTimeUnitRounding instances are considered equal if they have the same short name.
    @Override
        return dateTimeUnit.shortName();
    }
    public DateTimeUnitAdapter(Rounding.DateTimeUnit dateTimeUnit) {
     */
import org.opensearch.common.Rounding;
    }
    @Override
    @Override
        if (!(obj instanceof DateTimeUnitRounding other)) return false;
     * Returns a hash code value for the object.  
 * compatible open source license.
}  
        return Objects.hash(shortName());
     */  
 * Adapter class to convert {@link Rounding.DateTimeUnit} to {@link DateTimeUnitRounding}  
 *
    public long roundFloor(long utcMillis) {
     * @return a hash code value for this object  
    }
     *
     *  
        this.dateTimeUnit = dateTimeUnit;
 * @opensearch.experimental
    public int hashCode() {  
 */  
    /**  
    /**
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;  
    @Override
/**
        return Objects.equals(shortName(), other.shortName());
public class DateTimeUnitAdapter implements DateTimeUnitRounding {
 *
     * Checks if this DateTimeUnitRounding is equal to another object.
package org.opensearch.index.compositeindex.datacube.startree.utils.date;
    }  
     * This method is implemented to be consistent with equals.
     * @param obj The object to compare with
 * this file be licensed under the Apache-2.0 license or a
    private final Rounding.DateTimeUnit dateTimeUnit;
        return dateTimeUnit.roundFloor(utcMillis);  
        if (this == obj) return true;  
    }  
 */  
 * The OpenSearch Contributors require contributions made to  
    public String shortName() {  
/*  
    public boolean equals(Object obj) {
     * @return true if the objects are equal, false otherwise
