    private volatile long lastAccessTimeInNanos;  
 * SPDX-License-Identifier: Apache-2.0
    public TimeBasedExpiryTracker(LongSupplier nanoTimeSupplier, long expiryTimeInNanos) {
public class TimeBasedExpiryTracker implements BooleanSupplier {
 * Clients should be more cautious with the expiry time as this class is not completely thread safe. This is intentional  
    @Override
        final long currentTime = nanoTimeSupplier.getAsLong();
 */  
        this.expiryTimeInNanos = expiryTimeInNanos;
    public boolean getAsBoolean() {  
import java.util.function.BooleanSupplier;
        this(nanoTimeSupplier, ONE_SEC);
    private final LongSupplier nanoTimeSupplier;
package org.opensearch.common.util;
    }  
/*  
 * as nanoSecond granularity level error for `lastAccessTimeInNanos` is tolerable and can be ignored.
    private static final long ONE_SEC = 1000_000_000;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    }  
}
        this.lastAccessTimeInNanos = nanoTimeSupplier.getAsLong();
        this.nanoTimeSupplier = nanoTimeSupplier;  
        if (isExpired) {  
import java.util.function.LongSupplier;
    private final long expiryTimeInNanos;
    }
    public TimeBasedExpiryTracker(LongSupplier nanoTimeSupplier) {
        final boolean isExpired = (currentTime - lastAccessTimeInNanos) > expiryTimeInNanos;
 * This class can be utilised to track the time based expiration events.
            lastAccessTimeInNanos = currentTime;
 *
        return isExpired;  
 * The OpenSearch Contributors require contributions made to  
        }
 * @opensearch.internal
/**
 */  
