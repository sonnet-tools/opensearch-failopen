            || name.startsWith("os-grpc-worker-ELG-")
 * Excludes long-lived Netty/gRPC threads owned by {@code FlightStreamPlugin} from
 * <p>The Flight RPC plugin starts several Netty event-loop groups
import com.carrotsearch.randomizedtesting.ThreadFilter;
 * the test framework handles. Filtering them lets the suite focus on actual
 * not to per-test work, and their drain is bounded by node shutdown — which
 * test-induced leaks (orphaned drain threads, fragment-task threads, etc.).  
    public boolean reject(Thread t) {
 * this file be licensed under the Apache-2.0 license or a
        return name.startsWith("os-grpc-boss-ELG-")
            || name.startsWith("flight-eventloop-");  
 */
 * window, which is wider for the resilience suites that run cancel-during-stream  
 * picked up as leaked under the
    @Override
 * scoped to the plugin instance — not to a test method — and shut down only
}
 *
 * compatible open source license.
 *  
        String name = t.getName();  
 * when the cluster node hosting the plugin shuts down. Suite-scope test cluster
 * <p>This is not a real leak: the threads belong to the plugin's lifecycle,  
 * the suite-scope thread-leak check.
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.analytics.resilience;
/**  
 * ({@code os-grpc-boss-ELG-N}, {@code os-grpc-worker-ELG-N}) and a
/*  
 * scenarios (those exercise the streaming transport heavily).
 *
 * teardown does eventually close them, but lingering carrier threads can be  
 * SPDX-License-Identifier: Apache-2.0
 * {@code flight-eventloop-N} dispatcher pool when it boots. These pools are  
 */  
 * {@code com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering}
public final class FlightTransportThreadLeakFilter implements ThreadFilter {
    }
