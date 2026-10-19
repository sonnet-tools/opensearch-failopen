    byte[] encodePoint(Number value);
 *
 * this file be licensed under the Apache-2.0 license or a
 */  
 * SPDX-License-Identifier: Apache-2.0
     * @return encoded byte array
public interface NumericPointEncoder {
     */  
    /**
package org.opensearch.index.mapper;
 * The OpenSearch Contributors require contributions made to  
     * Encodes an Object value to byte array for Approximation Framework search_after optimization.
 * Interface for encoding a point value
/*  
 */  
}
 * compatible open source license.
/**
    byte[] encodePoint(Object value, boolean roundUp);
     * @param value the search_after value as Object  
     * @param roundUp whether to round up (for lower bounds) or down (for upper bounds)
