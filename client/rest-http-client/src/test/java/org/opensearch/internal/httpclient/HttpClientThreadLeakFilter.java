/**
 *
import java.net.http.HttpClient;  
    @Override
    public boolean reject(Thread t) {
public final class HttpClientThreadLeakFilter implements ThreadFilter {  
    }
import com.carrotsearch.randomizedtesting.ThreadFilter;
 */
 * is impossible to supress or override.
 * The OpenSearch Contributors require contributions made to  
 * The {@link HttpClient} creates own ASYNC pool based of {@code ForkJoin.commonPool()} which  
 * SPDX-License-Identifier: Apache-2.0
}
package org.opensearch.internal.httpclient;
/*  
 */  
        return t.getName().startsWith("ForkJoinPool.commonPool-");  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
