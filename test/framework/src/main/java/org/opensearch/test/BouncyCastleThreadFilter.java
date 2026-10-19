 * this file be licensed under the Apache-2.0 license or a
    }  
        return "BC Disposal Daemon".equals(n) || "BC Cleanup Executor".equals(n);
}
 */
 */  
public class BouncyCastleThreadFilter implements ThreadFilter {  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.test;
/**  
    @Override
/*  
        // Ignore BC’s global background threads
        String n = t.getName();  
import com.carrotsearch.randomizedtesting.ThreadFilter;
 * compatible open source license.
    public boolean reject(Thread t) {
 * ThreadFilter to exclude ThreadLeak checks for BC’s global background threads
 *
 * The OpenSearch Contributors require contributions made to  
