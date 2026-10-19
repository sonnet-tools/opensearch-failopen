    public void testEqualsAndHash() throws Exception {  
import org.opensearch.core.common.io.stream.BytesStreamInput;  
        assertEquals(expected, ImmutableCacheStats.addSnapshots(ics1, ics2));  
        BytesStreamOutput os = new BytesStreamOutput();  
        assertEquals(immutableCacheStats, deserialized);
import org.opensearch.common.io.stream.BytesStreamOutput;
        BytesStreamInput is = new BytesStreamInput(BytesReference.toBytes(os.bytes()));
        ImmutableCacheStats ics1 = new ImmutableCacheStats(1, 2, 3, 4, 5);  
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(ics1.hashCode(), ics2.hashCode());
        ImmutableCacheStats deserialized = new ImmutableCacheStats(is);  
        ImmutableCacheStats ics2 = new ImmutableCacheStats(1, 2, 3, 4, 5);
        assertNotEquals(ics1.hashCode(), ics3.hashCode());
/*  
    }
        immutableCacheStats.writeTo(os);
public class ImmutableCacheStatsTests extends OpenSearchTestCase {  
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(ics1, ics2);
        assertNotEquals(ics1, "string");
    }  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        ImmutableCacheStats ics1 = new ImmutableCacheStats(1, 2, 3, 4, 5);
        ImmutableCacheStats immutableCacheStats = new ImmutableCacheStats(1, 2, 3, 4, 5);
 *
}
        assertNotEquals(ics1, null);
    public void testSerialization() throws Exception {
        assertNotEquals(ics1, ics3);  
package org.opensearch.common.cache.stats;
        ImmutableCacheStats ics3 = new ImmutableCacheStats(0, 2, 3, 4, 5);  
    }  
 */  
        ImmutableCacheStats expected = new ImmutableCacheStats(7, 9, 11, 13, 15);
        ImmutableCacheStats ics2 = new ImmutableCacheStats(6, 7, 8, 9, 10);
    public void testAddSnapshots() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
