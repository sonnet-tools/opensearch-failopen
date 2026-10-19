 *
 * compatible open source license.
public class LRUCacheTests extends RefCountedCacheTestCase {
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.store.remote.utils.cache;
}
 * The OpenSearch Contributors require contributions made to  
 */  
    }
    public LRUCacheTests() {
        super(new LRUCache<>(CAPACITY, n -> {}, value -> value));  
/*  
 * SPDX-License-Identifier: Apache-2.0
