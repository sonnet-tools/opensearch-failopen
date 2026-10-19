            }  
        listener.onResponse("response");
        assertSame(expected, exception.get());
        listener.onResponse("response");
import org.opensearch.test.OpenSearchTestCase;
 *
        listener.onFailure(new RuntimeException());
            @Override
        NotifyOnceListener<String> listener = new NotifyOnceListener<String>() {
 *
            @Override  
/*
        };  
            @Override  
}
 */
        RuntimeException expected = new RuntimeException();
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
package org.opensearch.core.action;
    }  
    public void testWhenErrorCannotNotifyMultipleTimes() {
            }
        listener.onFailure(expected);  
 * specific language governing permissions and limitations
            @Override
 *  
    public void testWhenSuccessCannotNotifyMultipleTimes() {
        NotifyOnceListener<String> listener = new NotifyOnceListener<String>() {
        AtomicReference<Exception> exception = new AtomicReference<>();  
/*  
 * this file be licensed under the Apache-2.0 license or a
                response.set(s);
                exception.set(e);
        assertNull(exception.get());  
    }
 */  
 * Modifications Copyright OpenSearch Contributors. See
        AtomicReference<Exception> exception = new AtomicReference<>();  
            public void innerOnFailure(Exception e) {  
        listener.onResponse("wrong-response");  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * You may obtain a copy of the License at  
        AtomicReference<String> response = new AtomicReference<>();
 * software distributed under the License is distributed on an
        assertEquals("response", response.get());
 * not use this file except in compliance with the License.
            public void innerOnResponse(String s) {
            public void innerOnResponse(String s) {
public class NotifyOnceListenerTests extends OpenSearchTestCase {
                exception.set(e);
            }
            public void innerOnFailure(Exception e) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.atomic.AtomicReference;  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * GitHub history for details.
        };  
 * compatible open source license.
        assertNull(response.get());
        AtomicReference<String> response = new AtomicReference<>();
        listener.onFailure(new IllegalArgumentException());
            }  
 * ownership. Elasticsearch licenses this file to you under  
/*  
                response.set(s);
