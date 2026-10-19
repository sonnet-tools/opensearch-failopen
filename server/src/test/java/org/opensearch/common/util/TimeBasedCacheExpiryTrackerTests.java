 */  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        TestTimeSupplier testTimeSupplier = new TestTimeSupplier();  
        long currentTime = System.nanoTime();
        public long getAsLong() {
        assertTrue(sut.getAsBoolean());
    }
        testTimeSupplier.advanceClockBy(ONE_SEC / 2);  
    final long ONE_SEC = 1_000_000_000;
        assertFalse(sut.getAsBoolean());
        sut = new TimeBasedExpiryTracker(testTimeSupplier);
import org.opensearch.test.OpenSearchTestCase;
        }
import java.util.function.LongSupplier;  
        TestTimeSupplier testTimeSupplier = new TestTimeSupplier();
    public void testExpiryEvent() {  
            return currentTime;  
/*  
    TimeBasedExpiryTracker sut;  
package org.opensearch.common.util;
    }  
        @Override
 *
    }  
 * The OpenSearch Contributors require contributions made to  
        }
        public void advanceClockBy(long nanos) {  
    public void testNonExpiryEvent() {
        sut = new TimeBasedExpiryTracker(testTimeSupplier);
 * this file be licensed under the Apache-2.0 license or a
    public static class TestTimeSupplier implements LongSupplier {
            currentTime += nanos;
public class TimeBasedCacheExpiryTrackerTests extends OpenSearchTestCase {
        testTimeSupplier.advanceClockBy(2 * ONE_SEC);
}
