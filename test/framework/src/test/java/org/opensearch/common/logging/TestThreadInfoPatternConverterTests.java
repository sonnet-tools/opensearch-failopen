import org.opensearch.common.util.concurrent.OpenSearchExecutors;
import org.opensearch.test.OpenSearchTestCase;
 *
 * GitHub history for details.
        assertEquals(getTestName(), threadInfo(Thread.currentThread().getName()));
/*  
public class TestThreadInfoPatternConverterTests extends OpenSearchTestCase {
 * this work for additional information regarding copyright
    @BeforeClass
 * not use this file except in compliance with the License.
    public static void captureSuiteInfo() {
 * license agreements. See the NOTICE file distributed with
        // And stuff that doesn't match anything gets wrapped in [] so we can see it  
        assertEquals(nodeName, threadInfo(threadName));
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
    private static String suiteInfo;
 * The OpenSearch Contributors require contributions made to  
 *
 * You may obtain a copy of the License at  
        // Suite initialization gets "suite"  
import static org.opensearch.common.logging.TestThreadInfoPatternConverter.threadInfo;
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 */  
 */
 *  
        // Test threads get the test name  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
        String nodeName = randomAlphaOfLength(5);
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
    }
        assertEquals("[" + unmatched + "]", threadInfo(unmatched));
    }  
        String threadName = OpenSearchExecutors.threadName(nodeName, randomAlphaOfLength(20)) + "[T#" + between(0, 1000) + "]";  
package org.opensearch.common.logging;
    public void testThreadInfo() {  
 * ownership. Elasticsearch licenses this file to you under  
        suiteInfo = threadInfo(Thread.currentThread().getName());  
import org.junit.BeforeClass;  
        // Threads that are part of a node get the node name
}
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        assertEquals("suite", suiteInfo);
 * SPDX-License-Identifier: Apache-2.0
 */  
/*  
        String unmatched = randomAlphaOfLength(5);
 * software distributed under the License is distributed on an
