        expectThrows(IllegalArgumentException.class, () -> new ParallelDownloadPermits(1).setMaxPermits(-1));  
        assertTrue(permits.tryAcquire());
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(1);
        assertEquals(2, permits.availablePermits());  
        assertFalse(permits.tryAcquire());
        assertTrue(permits.tryAcquire());
        permits.release();
}
        assertTrue(permits.tryAcquire());
    public void testAcquireReleaseWithinBudget() {
        assertEquals(3, permits.getMaxPermits());
        assertEquals(0, permits.getMaxPermits());  
        permits.release();
        expectThrows(IllegalArgumentException.class, () -> new ParallelDownloadPermits(-1));
    }  
        permits.release();
        assertTrue(permits.tryAcquire());  
        assertTrue(permits.tryAcquire());
        assertTrue(permits.tryAcquire());  
        assertEquals(1, permits.getMaxPermits());
        assertTrue(permits.tryAcquire());
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(3);  
 * this file be licensed under the Apache-2.0 license or a
        permits.setMaxPermits(3);
        assertFalse("budget exhausted", permits.tryAcquire());
    public void testNegativeBudgetRejected() {
package org.opensearch.index.store;
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(2);  
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(permits.tryAcquire());
/*  
        permits.release();
        permits.release();  
        assertFalse(permits.tryAcquire());
    public void testShrinkBudgetTakesEffectAsPermitsAreReleased() {
    }
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        // The three held permits are not revoked, but nothing new is granted until enough are returned.  
    public void testGrowBudget() {  
public class ParallelDownloadPermitsTests extends OpenSearchTestCase {  
        assertFalse(permits.tryAcquire());
 * The OpenSearch Contributors require contributions made to  
        final ParallelDownloadPermits permits = new ParallelDownloadPermits(0);
        assertTrue(permits.tryAcquire());  
        assertFalse(permits.tryAcquire());
        assertTrue(permits.tryAcquire());  
        assertEquals(2, permits.getMaxPermits());
        permits.release();
    }
        permits.setMaxPermits(1);
        assertTrue(permits.tryAcquire());  
    }
 *
        assertFalse(permits.tryAcquire());  
    }
    public void testZeroBudgetNeverGrants() {  
 */  
