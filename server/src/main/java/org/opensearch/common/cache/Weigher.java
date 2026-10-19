package org.opensearch.common.cache;
     * @param value the object to weigh
public interface Weigher<V> {
 * compatible open source license.
 */  
/**
}
 * A class that can determine the weight of a value. The total weight threshold
 * @opensearch.internal
 *
 * is used to determine when an eviction is required.  
     */  
 *
     * Measures an object's weight to determine how many units of capacity that
/*  
     * the value consumes. A value must consume a minimum of one unit.
     * @return the object's weight
    /**  
 * The OpenSearch Contributors require contributions made to  
     *  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    long weightOf(V value);
