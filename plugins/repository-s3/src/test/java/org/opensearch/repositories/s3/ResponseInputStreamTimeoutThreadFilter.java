    public boolean reject(Thread t) {
        return t.getName().startsWith("response-input-stream-timeout-scheduler");
 * The AWS SDK schedules {@code ResponseInputStream} timeouts on a JVM-wide, statically initialized
 * shut it down, so closing an S3 client does not reclaim its thread and the suite scope sees it as leaked. The thread is  
    @Override  
 * accumulates. Filter it out.
public class ResponseInputStreamTimeoutThreadFilter implements ThreadFilter {
/*  
package org.opensearch.repositories.s3;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * a daemon and the pool lets it time out after 60 seconds of inactivity, so it neither blocks JVM shutdown nor
 */  
    }  
import com.carrotsearch.randomizedtesting.ThreadFilter;
 * {@code ScheduledExecutorService} ({@code ResponseInputStream.TimeoutScheduler#INSTANCE}). The SDK exposes no way to
 *
/**  
 */  
}
