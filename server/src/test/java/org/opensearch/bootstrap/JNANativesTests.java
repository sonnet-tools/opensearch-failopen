 *  
            assertFalse("Memory locking is not available on OS X platforms", JNANatives.LOCAL_MLOCKALL);  
 * Unless required by applicable law or agreed to in writing,
    }
/*  
            assertNotNull(JNAKernel32Library.getInstance());  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(JNAKernel32Library.getInstance().getCallbacks().size(), equalTo(1));
 */  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import org.apache.lucene.util.Constants;
import static org.hamcrest.Matchers.equalTo;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 */  
/*  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
}
 *
 *
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
    }  
import org.opensearch.test.OpenSearchTestCase;
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
    public void testMlockall() {
        if (Constants.WINDOWS) {
 * software distributed under the License is distributed on an
 */
        }
    public void testConsoleCtrlHandler() {
        }
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
public class JNANativesTests extends OpenSearchTestCase {  
        } else {
            assertThat(JNAKernel32Library.getInstance().getCallbacks().size(), equalTo(0));
        if (Constants.MAC_OS_X) {
 * license agreements. See the NOTICE file distributed with
/*
            assertNotNull(JNAKernel32Library.getInstance());  
package org.opensearch.bootstrap;
