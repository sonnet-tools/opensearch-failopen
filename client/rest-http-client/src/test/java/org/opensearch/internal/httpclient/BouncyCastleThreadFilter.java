 * compatible open source license.
import com.carrotsearch.randomizedtesting.ThreadFilter;
 */  
 * this file be licensed under the Apache-2.0 license or a
/*  
    @Override  
 */
 * <p>clone from the original, which is located in ':test:framework'</p>  
package org.opensearch.internal.httpclient;
        return "BC Disposal Daemon".equals(n) || "BC Cleanup Executor".equals(n);
}  
/**  
 *
    public boolean reject(Thread t) {
    }
public class BouncyCastleThreadFilter implements ThreadFilter {
 * SPDX-License-Identifier: Apache-2.0
        // Ignore BC’s global background threads  
 *
 * ThreadFilter to exclude ThreadLeak checks for BC’s global background threads
 * The OpenSearch Contributors require contributions made to  
        String n = t.getName();
