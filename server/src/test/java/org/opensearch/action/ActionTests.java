 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
        FakeAction fakeAction1 = new FakeAction("a");  
 * SPDX-License-Identifier: Apache-2.0
        assertNotEquals(fakeAction1, s);
 * specific language governing permissions and limitations
        assertEquals(fakeAction2, fakeAction2);
    }  
 * software distributed under the License is distributed on an
 *
            protected FakeAction(String name) {
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 */
        FakeAction fakeAction2 = new FakeAction("a");
public class ActionTests extends OpenSearchTestCase {
 */  
 *
 *  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        FakeAction fakeAction3 = new FakeAction("b");
                super(name, null);  
            }
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
}
 */  
 * this work for additional information regarding copyright
        assertNotEquals(fakeAction1, null);  
        class FakeAction extends ActionType<ActionResponse> {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * You may obtain a copy of the License at  
        assertEquals(fakeAction1, fakeAction1);
/*  
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
        String s = "Some random other object";  
import org.opensearch.core.action.ActionResponse;
    public void testEquals() {  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action;
        assertNotEquals(fakeAction1, fakeAction3);
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
/*
