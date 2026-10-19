 * SPDX-License-Identifier: Apache-2.0
        super(  
/*  
package org.opensearch.index.store.remote.utils.cache;
 */  
        );
            SegmentedCache.<String, Long>builder().capacity(CAPACITY).weigher(value -> value).listener(n -> {}).concurrencyLevel(1).build()
 *
 * this file be licensed under the Apache-2.0 license or a
    }  
 * compatible open source license.
    public SegmentedCacheTests() {
 * The OpenSearch Contributors require contributions made to  
}
public class SegmentedCacheTests extends RefCountedCacheTestCase {
