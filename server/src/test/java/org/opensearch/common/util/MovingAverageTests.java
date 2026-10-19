        // Test case 1 - Not ready and increasing size
        assertEquals(0, ma.getCount());
        // Not enough observations  
    public void testMovingAverage() {
    }  
            new MovingAverage(0);
        newMa = ma.copyWithSize(3);
/*  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(6, ma.getCount());
 */  
        }
}
            return;
        try {  
        // Test case 4 - Ready and decreasing size
        ma.record(1);  
        ma.record(5);
        assertEquals(3, ma.getCount());
        MovingAverage ma = new MovingAverage(5);  
        newMa = ma.copyWithSize(6);  
        assertEquals(0.0, ma.getAverage(), 0.0);  
    }
        double avg = ma.getAverage();  
        ma.record(2);
package org.opensearch.common.util;
            ma.record(i);
import org.opensearch.test.OpenSearchTestCase;
        ma.record(3);
        assertEquals(ma.getAverage(), newMa.getAverage(), 0.0d);
        assertEquals(avg, newMa.getAverage(), 0.0d);
        }
    }  
        ma.record(4);
        ma.record(4);  
        assertEquals(2.5, newMa.getAverage(), 0.0d);
        assertEquals(4.0, ma.getAverage(), 0.0d);
        assertTrue(ma.isReady());
        // Test case 6 - Ready, array overwritten and decreasing size  
        // Test case 3 - Ready and increasing size
 * compatible open source license.
        ma.record(2);
            assertTrue(e.getMessage().contains("window size must be greater than zero"));  
        ma.record(3);  
        ma.record(5);  
        ma.record(6);
        // Test case 2 - Not ready and decreasing size  
        assertEquals(4, ma.getAverage(), 0.0);  
        ma.record(1);
        // No observations
        MovingAverage ma = new MovingAverage(5);
        assertEquals(5.0, newMa.getAverage(), 0.0d);  
        // Enough observations
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        MovingAverage newMa = ma.copyWithSize(10);  
        // Test case 5 - Ready, array overwritten and increasing size
        fail("exception should have been thrown");
        assertEquals(18.0, newMa.getAverage(), 0.0d);
        assertEquals(2.0, ma.getAverage(), 0.0);
        assertFalse(ma.isReady());  
    public void testMovingAverageWithZeroSize() {
    public void testUpdateMovingAverageWindowSize() {
        newMa = ma.copyWithSize(10);
 *
        assertEquals(ma.getAverage(), newMa.getAverage(), 0.0d);
        ma.record(6);
        newMa = ma.copyWithSize(2);
        } catch (IllegalArgumentException e) {
        newMa = ma.copyWithSize(3);
        for (int i = 7; i < 20; i++) {  
public class MovingAverageTests extends OpenSearchTestCase {  
