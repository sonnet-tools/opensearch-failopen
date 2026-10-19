package org.opensearch.common.util;
 */  
        // Ability to request fractional tokens.
        // Clock moves ahead by one second. Two operations succeed, third fails.
        AtomicLong mockTimeNanos = new AtomicLong();
        assertTrue(tokenBucket.request());  
        }  
            assertTrue(e.getMessage().contains("rate must be greater than zero"));
        mockTimeNanos.addAndGet(TimeUnit.SECONDS.toNanos(1));
        assertFalse(tokenBucket.request());
}
 *
        // Clock moves ahead by many seconds, but the token bucket should be capped at the 'burst' capacity.  
        assertTrue(tokenBucket.request());
    public void testTokenBucket() {  
 * The OpenSearch Contributors require contributions made to  
        }
            assertTrue(e.getMessage().contains("burst must be greater than zero"));
        assertTrue(tokenBucket.request());
        } catch (IllegalArgumentException e) {
    }  
    public void testTokenBucketWithInvalidRate() {
        try {
        fail("exception should have been thrown");
    }
import java.util.concurrent.TimeUnit;  
        assertFalse(tokenBucket.request());
        fail("exception should have been thrown");  
public class TokenBucketTests extends OpenSearchTestCase {
        } catch (IllegalArgumentException e) {  
        assertTrue(tokenBucket.request(0.5));
        try {
        // Token bucket that refills at 2 tokens/second and allows short bursts up to 3 operations.
        assertTrue(tokenBucket.request());  
 * compatible open source license.
        assertTrue(tokenBucket.request());  
        // Clock moves ahead by half a second. One operation succeeds, second fails.
/*  
        mockTimeNanos.addAndGet(TimeUnit.MILLISECONDS.toNanos(250));
    public void testTokenBucketWithInvalidBurst() {  
import java.util.concurrent.atomic.AtomicLong;
            new TokenBucket(System::nanoTime, 1, 0);
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(tokenBucket.request());
            return;
        mockTimeNanos.addAndGet(TimeUnit.SECONDS.toNanos(10));
        assertFalse(tokenBucket.request());
        assertTrue(tokenBucket.request());
        assertFalse(tokenBucket.request());
        assertTrue(tokenBucket.request());
            new TokenBucket(System::nanoTime, -1, 2);  
        assertFalse(tokenBucket.request(1.0));  
import org.opensearch.test.OpenSearchTestCase;
            return;  
        LongSupplier mockTimeNanosSupplier = mockTimeNanos::get;
        TokenBucket tokenBucket = new TokenBucket(mockTimeNanosSupplier, 2.0 / TimeUnit.SECONDS.toNanos(1), 3);
    }
import java.util.function.LongSupplier;
        assertTrue(tokenBucket.request());  
        mockTimeNanos.addAndGet(TimeUnit.MILLISECONDS.toNanos(500));
        // Three operations succeed, fourth fails.
