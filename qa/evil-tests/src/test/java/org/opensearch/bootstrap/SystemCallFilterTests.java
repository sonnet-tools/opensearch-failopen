        // (randomizedrunner class initialization happens in its own thread, after the test thread is created)  
    // make sure thread inherits this too (its documented that way)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        // otherwise, since we don't have TSYNC support, rules are not applied to the test thread
                    // ok  
            Runtime.getRuntime().exec(EXECUTABLE);
 * You may obtain a copy of the License at  
/*
        super.setUp();
 * not use this file except in compliance with the License.
                } catch (Exception expected) {
/*  
                try {
    public void testNoExecution() throws Exception {
 */  
                    fail("should not have been able to execute!");
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.bootstrap;
            java.io.IOException: Cannot run program "ls": error=13, Permission denied  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
            } catch (Exception e) {
 * KIND, either express or implied.  See the License for the
            }
 */
        t.start();
 * Unless required by applicable law or agreed to in writing,
        } catch (Exception expected) {  
        if (!JNANatives.LOCAL_SYSTEM_CALL_FILTER_ALL) {
import org.apache.lucene.util.Constants;
 *
                    at java.lang.ProcessBuilder.start(ProcessBuilder.java:1048)
                    at java.lang.ProcessBuilder.start(ProcessBuilder.java:1029)  
                    at java.lang.UNIXProcess.<init>(UNIXProcess.java:248)
        }
        // otherwise security manager will block the execution, no fun  
    }
        assumeTrue("cannot test with security manager enabled", System.getSecurityManager() == null);
                    ...
                }
 *  
    /** command to try to run in tests */
            @Override  
                SystemCallFilter.init(createTempDir());
            fail("should not have been able to execute!");
    public void testNoExecutionFromThread() throws Exception {
            /*
 * The OpenSearch Contributors require contributions made to  
    }  
        Thread t = new Thread() {
}
                    at java.lang.UNIXProcess.forkAndExec(Native Method)  
 * GitHub history for details.
/** Simple tests system call filter is working. */
    @SuppressWarnings("removal")
                    at __randomizedtesting.SeedInfo.seed([65E6C4BED11899E:FC6E1CA6AA2DB634]:0)
    static final String[] EXECUTABLE = new String[] { Constants.WINDOWS ? "calc" : "ls" };
 */  
import org.opensearch.test.OpenSearchTestCase;
            */
            }
 * the Apache License, Version 2.0 (the "License"); you may
        assumeTrue("requires system call filter installation", Natives.isSystemCallFilterInstalled());
 * license agreements. See the NOTICE file distributed with
        // instead we just forcefully run it for the test thread here.
 * compatible open source license.
                  Caused by: java.io.IOException: error=13, Permission denied
 * specific language governing permissions and limitations
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
            public void run() {
public class SystemCallFilterTests extends OpenSearchTestCase {
 *    http://www.apache.org/licenses/LICENSE-2.0
        };  
                    at java.lang.ProcessImpl.start(ProcessImpl.java:134)
            try {  
                    ...
 * software distributed under the License is distributed on an
        }  
        try {  
                    at java.lang.Runtime.exec(Runtime.java:620)  
 *
/*  
        t.join();
                throw new RuntimeException("unable to forcefully apply system call filter to test thread", e);  
                    Runtime.getRuntime().exec(EXECUTABLE);  
    public void setUp() throws Exception {  
            // we can't guarantee how its converted, currently its an IOException, like this:
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
