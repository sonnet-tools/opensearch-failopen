}
 *  creates a watcher daemon thread which is never
import com.carrotsearch.randomizedtesting.ThreadFilter;
        return t.getName().startsWith("testcontainers-pull-watchdog-")  
 *
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
package org.opensearch.plugin.kinesis;
 * this file be licensed under the Apache-2.0 license or a
            || t.getName().startsWith("testcontainers-ryuk")
public final class TestContainerThreadLeakFilter implements ThreadFilter {  
    }  
    @Override
/**  
 */  
/*  
 * The {@link org.testcontainers.images.TimeLimitedLoggedPullImageResultCallback} instance used by test containers,
 */
 * thread aws IdleConnectionReaper thread, which are not closed on time .
 * The OpenSearch Contributors require contributions made to  
 * stopped. This filter excludes that thread from the thread leak detection logic. It also excludes ryuk resource reaper  
    public boolean reject(Thread t) {
            || t.getName().startsWith("idle-connection-reaper");
