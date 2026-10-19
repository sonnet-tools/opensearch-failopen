 */
    @Override
public final class TestContainerThreadLeakFilter implements ThreadFilter {  
            || t.getName().startsWith("stream-poller-consumer");
/**  
 * stopped. This filter excludes that thread from the thread leak detection logic. It also excludes ryuk resource reaper  
import com.carrotsearch.randomizedtesting.ThreadFilter;
/*  
    public boolean reject(Thread t) {
        return t.getName().startsWith("testcontainers-pull-watchdog-")  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * The {@link org.testcontainers.images.TimeLimitedLoggedPullImageResultCallback} instance used by test containers,
 *
 * for example {@link org.testcontainers.containers.KafkaContainer} creates a watcher daemon thread which is never
package org.opensearch.plugin.kafka;
 */  
            || t.getName().startsWith("testcontainers-ryuk")
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * thread and pollers which is not closed on time.
}
    }  
