/*  
import org.opensearch.common.annotation.ExperimentalApi;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.common.cache;
}
 */  
 * this file be licensed under the Apache-2.0 license or a
 * @param <K> Type of key.
 * @opensearch.experimental
 * @param <V> Type of value.  
 * compatible open source license.
 */  
 *
 * Extends a cache loader with awareness of whether the data is loaded or not.
public interface LoadAwareCacheLoader<K, V> extends CacheLoader<K, V> {
    boolean isLoaded();  
/**  
 * SPDX-License-Identifier: Apache-2.0
@ExperimentalApi
 *
