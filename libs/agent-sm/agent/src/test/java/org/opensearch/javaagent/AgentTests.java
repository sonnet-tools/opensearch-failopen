    @Test(expected = SecurityException.class)
        Runtime.getRuntime().halt(0);
    public void testSystemExitIsForbidden() {
public class AgentTests extends AgentTestCase {  
    }
    }  
 * The OpenSearch Contributors require contributions made to  
}
 *
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.javaagent;
 */  
import org.junit.Test;
 * compatible open source license.
    public void testRuntimeHaltIsForbidden() {
    @Test(expected = SecurityException.class)  
        System.exit(0);  
 * this file be licensed under the Apache-2.0 license or a
/*  
