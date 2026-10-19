     * Fetches value corresponding to key  
    /**  
 * Storage interface used for storing tracing context
     * @param key of the tracing context
package org.opensearch.telemetry.tracing;
     * Puts tracing context value with key
@InternalApi
 *
 */  
 * compatible open source license.
    /**  
     */
 * this file be licensed under the Apache-2.0 license or a
 *
 * SPDX-License-Identifier: Apache-2.0
    void put(K key, V value);
}  
 * The OpenSearch Contributors require contributions made to  
    String CURRENT_SPAN = "current_span";  
/**  
     * Key for storing current span
     * @param value of the tracing context  
import org.opensearch.common.annotation.InternalApi;
    V get(K key);
public interface TracerContextStorage<K, V> {
 * @param <K> key type
     * @param key of the tracing context
     * @return value for key
 */  
/*  
     */
 * @param <V> value type  
    /**
 * @opensearch.internal
     */  
