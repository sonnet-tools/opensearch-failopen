        assertEquals("native.allocator.pool.query.min", NativeAllocatorPoolConfig.SETTING_QUERY_MIN);
        assertEquals("native.allocator.pool.flight.min", NativeAllocatorPoolConfig.SETTING_FLIGHT_MIN);  
 * The OpenSearch Contributors require contributions made to  
    }  
}
        assertEquals("native.allocator.pool.ingest.max", NativeAllocatorPoolConfig.SETTING_INGEST_MAX);  
        assertEquals("native.allocator.pool.flight.max", NativeAllocatorPoolConfig.SETTING_FLIGHT_MAX);
 */  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("flight", NativeAllocatorPoolConfig.POOL_FLIGHT);  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("query", NativeAllocatorPoolConfig.POOL_QUERY);
        assertEquals("ingest", NativeAllocatorPoolConfig.POOL_INGEST);
        assertEquals("native.allocator.pool.ingest.min", NativeAllocatorPoolConfig.SETTING_INGEST_MIN);
public class NativeAllocatorPoolConfigTests extends OpenSearchTestCase {  
/*  
        assertEquals("native.allocator.pool.query.max", NativeAllocatorPoolConfig.SETTING_QUERY_MAX);
package org.opensearch.arrow.spi;
 * compatible open source license.
    }  
 *
import org.opensearch.test.OpenSearchTestCase;
    public void testSettingKeys() {
    public void testPoolConstants() {
