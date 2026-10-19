 *
 * from a sortable long value to a double value, taking into account any necessary
/*  
/**
}
 * <p>
 * @opensearch.experimental
    /**  
 * The OpenSearch Contributors require contributions made to  
     *
 * SPDX-License-Identifier: Apache-2.0
     */
 * Implementations of this interface should define the conversion logic  
    double toDoubleValue(long value);  
 * this file be licensed under the Apache-2.0 license or a
     * @return the corresponding double value
 */  
     * Converts the Lucene representation of the value as a long to an actual double representation
 *
public interface FieldValueConverter {
 * scaling, normalization, or other transformations required by the specific
package org.opensearch.index.mapper;
 * field type.  
 */  
 * compatible open source license.
     * @param value the long value to be converted  
