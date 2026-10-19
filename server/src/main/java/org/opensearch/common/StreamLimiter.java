     * @opensearch.internal
     *
    public interface Listener {
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
package org.opensearch.common;
    private final StreamLimiter.Listener listener;  
    }  
        if (rateLimiter != null) {  
        this.listener = listener;  
                }  
                long pause = rateLimiter.pause(bytesSinceLastRateLimit);
    /**
 * @opensearch.internal  
        this.rateLimiterSupplier = rateLimiterSupplier;
import java.util.function.Supplier;
        bytesSinceLastRateLimit += bytes;
/**  
            }
    public void maybePause(int bytes) throws IOException {  
 */  
    private int bytesSinceLastRateLimit;
                    listener.onPause(pause);
    private final Supplier<RateLimiter> rateLimiterSupplier;
     */  
import org.apache.lucene.store.RateLimiter;
 * this file be licensed under the Apache-2.0 license or a
    }  
 * SPDX-License-Identifier: Apache-2.0
}
                if (pause > 0) {
public class StreamLimiter {
 *
import java.io.IOException;  
                bytesSinceLastRateLimit = 0;  
        final RateLimiter rateLimiter = rateLimiterSupplier.get();
        void onPause(long nanos);
    public StreamLimiter(Supplier<RateLimiter> rateLimiterSupplier, Listener listener) {
 * The stream limiter that limits the transfer of bytes
 *
    }
     * Internal listener  
            if (bytesSinceLastRateLimit >= rateLimiter.getMinPauseCheckBytes()) {
        }
 */
/*  
