 * specific language governing permissions and limitations
            public void onFailure(Exception e) {
            throw new IllegalArgumentException();
        mapped.onResponse(true);
        } else {  
        List<Boolean> failOnTrue = new ArrayList<>();
import org.opensearch.test.OpenSearchTestCase;
            assertEquals("listener index " + i, "must not be false " + i, excList.get(i).get().getMessage());
import org.opensearch.common.CheckedConsumer;
    public void testWrap() {
        }
            }
        assertThat(assertionError.getCause().getCause(), instanceOf(IllegalArgumentException.class));  
 * license agreements. See the NOTICE file distributed with
            excList.add(exReference);
                    throw new RuntimeException("double boom");
            }
        });
            CheckedConsumer<Boolean, ? extends Exception> handler = (o) -> {
        AssertionError assertionError = expectThrows(AssertionError.class, () -> mapped.onResponse(null));  
 */  
        final int listenerToFail = randomBoolean() ? -1 : randomIntBetween(0, numListeners - 1);  
     * Test that map passes the output of the function to its delegate listener and that exceptions in the function are propagated to the  
            if (failOnTrue.get(i) == false) {
            AtomicReference<Exception> exReference = new AtomicReference<>();  
        };
 * the Apache License, Version 2.0 (the "License"); you may
            } else if (b) {
    }
            assertNotNull(excList.get(i).get());
                exReference.set(e);
            public void onFailure(Exception e) {
        assertEquals(numListeners, exceptionCounter.get());
                if (e instanceof IllegalArgumentException) {  
        assertThat(exReference.get(), instanceOf(IllegalStateException.class));  
        assertNotNull(exReference.get());  
    public void testRunBefore() {
            public void onResponse(String s) {  
        ActionListener<Boolean> mapped = ActionListener.map(listener, b -> {
        };
        }  
                throw new IllegalStateException("simulate map function exception");  
        assertNull(exReference.get());  
        mapped.onFailure(new IllegalStateException());
 * Licensed to Elasticsearch under one or more contributor  
    }  
                    throw new IllegalArgumentException("simulate onResponse exception");
 *
        }  
                }
                assertTrue("listener index " + i, refList.get(i).get());
            ActionListener<Object> listener = ActionListener.runBefore(ActionListener.wrap(r -> {}, e -> {}), () -> afterSuccess.set(true));
import java.util.concurrent.atomic.AtomicReference;
            assertNull("listener index " + i, refList.get(i).get());
        assertionError = expectThrows(AssertionError.class, () -> ActionListener.completeWith(listener, () -> {
            assertThat(onResponseTimes.get(), equalTo(1));
            failOnTrue.add(doFailOnTrue);  
            listener.onFailure(new RuntimeException("test"));
            public void onResponse(String s) {  
            if (randomBoolean()) {
import java.util.concurrent.ExecutionException;
        assertThat(exReference.get(), instanceOf(IllegalArgumentException.class));
                return null;
            } else {
 * ownership. Elasticsearch licenses this file to you under  
                if (fail) {
            AtomicBoolean afterSuccess = new AtomicBoolean();  
                onFailureTimes.getAndIncrement();  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }  
        }));  
package org.opensearch.core.action;
        } catch (RuntimeException ex) {
        assertionError = expectThrows(AssertionError.class, () -> mapped.onFailure(new IllegalArgumentException()));
     * onFailure handler. Also verify that exceptions from ActionListener.onResponse does not invoke onFailure, since it is the
    }
 *  
                if (s == null) {
            listeners.add(ActionListener.wrap(handler, (e) -> {
        ActionListener.completeWith(onResponseListener, () -> 100);  
                exReference.set(e);  
        boolean success = randomBoolean();  
import static org.hamcrest.Matchers.instanceOf;
        PlainActionFuture<Integer> onResponseListener = new PlainActionFuture<>();
        {
            ActionListener<Object> listener = ActionListener.runAfter(ActionListener.wrap(r -> {}, e -> {}), () -> afterFailure.set(true));
        ActionListener<String> listener = new ActionListener<String>() {
        for (int i = 0; i < numListeners; i++) {  
        AtomicReference<Boolean> reference = new AtomicReference<>();  
            public void onFailure(Exception e) {
        assertThat(assertionError.getCause(), instanceOf(IllegalArgumentException.class));
import static org.hamcrest.Matchers.equalTo;  
            if (Boolean.FALSE.equals(o)) {
        assertThat(onResponseListener.isDone(), equalTo(true));
        PlainActionFuture<Integer> onFailureListener = new PlainActionFuture<>();
                    throw (IllegalArgumentException) e;
        assertTrue(reference.get());
            }  
        }
        }
            assertThat(onFailureTimes.get(), equalTo(1));  
        }
        assertThat(expectThrows(ExecutionException.class, onFailureListener::get).getCause(), instanceOf(IOException.class));
 * Unless required by applicable law or agreed to in writing,
            AtomicBoolean afterFailure = new AtomicBoolean();  
            assertNotNull(ex.getCause());  
import org.opensearch.action.support.PlainActionFuture;  
        assertNull(exReference.get());
        List<AtomicReference<Exception>> excList = new ArrayList<>();  
            listeners.add(ActionListener.wrap(handler, exReference::set));
        });
        List<AtomicReference<Boolean>> refList = new ArrayList<>();
            } else {
/*
        }
            listener.onFailure(null);
import java.util.List;  
                if (e instanceof IllegalArgumentException) {  
            assertThat(afterFailure.get(), equalTo(true));  
            }  
        assertThat(exReference.get(), instanceOf(IllegalArgumentException.class));
 * software distributed under the License is distributed on an
            assertThat(onResponseTimes.get(), equalTo(0));
 * The OpenSearch Contributors require contributions made to  
            if (b == null) {  
                if (doFailOnTrue) {  
            } else {  
            }
    public void testRunAfter() {
    public void testNotifyOnce() {
        assertThat(exReference.get(), instanceOf(IllegalStateException.class));  
        for (int i = 0; i < numListeners; i++) {
        for (int i = 0; i < numListeners; i++) {
        }
                assertNull("listener index " + i, excList.get(i).get());  
import java.util.ArrayList;
 * Modifications Copyright OpenSearch Contributors. See  
            refList.add(reference);  
        for (int i = 0; i < numListeners; i++) {  
            AtomicReference<Boolean> reference = new AtomicReference<>();
                assertEquals("listener index " + i, "must not be true", excList.get(i).get().getMessage());
        assertThat(assertionError.getCause(), instanceOf(IllegalArgumentException.class));
/*
                return b.toString();
    public void testMap() {
        for (int i = 0; i < numListeners; i++) {
            ActionListener<Object> listener = ActionListener.runAfter(ActionListener.wrap(r -> {}, e -> {}), () -> afterSuccess.set(true));
            assertThat(afterFailure.get(), equalTo(true));  
                if (s == null) {
        CheckedConsumer<Boolean, ? extends Exception> handler = (o) -> {  
     * responsibility of the ActionListener implementation (the client of the API) to handle exceptions in onResponse and onFailure.
            boolean fail = i == listenerToFail;  
        assertNull(exReference.get());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
    public void testCompleteWith() {
        }
        List<ActionListener<Boolean>> listeners = new ArrayList<>();
            assertEquals("listener index " + i, "booom", excList.get(i).get().getMessage());  
        assertThat(onResponseListener.actionGet(), equalTo(100));
            assertThat(afterSuccess.get(), equalTo(true));  
        mapped.onResponse(false);  
                reference.set(o);  
 * compatible open source license.
            }));
                }  
                    throw new IllegalArgumentException("must not be false " + exceptionCounter.getAndIncrement());
    }
 * You may obtain a copy of the License at  
            assertThat(afterSuccess.get(), equalTo(true));  
            @Override  
                    throw (IllegalArgumentException) e;
        ActionListener<Object> listener = ActionListener.notifyOnce(new ActionListener<Object>() {
        assertThat(assertionError.getCause().getCause(), instanceOf(IllegalArgumentException.class));
        if (success) {
            @Override  
        ActionListener<String> listener = new ActionListener<String>() {
 * SPDX-License-Identifier: Apache-2.0
            listener.onFailure(null);
        }
                }  
import java.util.concurrent.atomic.AtomicInteger;  
                refList.get(i).set(null);  
        };
                    throw new IllegalStateException("must not be true");
        for (int i = 0; i < numListeners; i++) {
                throw new IllegalArgumentException("must not be false");
        AtomicReference<Exception> exReference = new AtomicReference<>();  
                }
        List<AtomicReference<Exception>> excList = new ArrayList<>();  
            ActionListener.onFailure(listeners, new Exception("booom"));
            AtomicBoolean afterFailure = new AtomicBoolean();  
            @Override
            listener.onResponse(null);
        {
        }
            refList.add(reference);
        wrap.onResponse(Boolean.FALSE);
        ActionListener.onResponse(listeners, Boolean.TRUE);
import java.io.IOException;
        if (success) {
        AtomicReference<Exception> exReference = new AtomicReference<>();
     */  
            }  
 */
 * not use this file except in compliance with the License.
            AtomicBoolean afterSuccess = new AtomicBoolean();  
            @Override
            assertEquals("double boom", ex.getCause().getMessage());
            ActionListener<Object> listener = ActionListener.runBefore(ActionListener.wrap(r -> {}, e -> {}), () -> afterFailure.set(true));
    public void testOnResponse() {  
 * KIND, either express or implied.  See the License for the
            assertNull("listener index " + i, refList.get(i).get());
    /**
        final int numListeners = randomIntBetween(1, 20);
                assertNull("listener index " + i, refList.get(i).get());
            @Override
        }  
    }
 * GitHub history for details.
            public void onResponse(Object o) {  
        AtomicInteger onResponseTimes = new AtomicInteger();
            excList.add(exReference);
        ActionListener<Boolean> wrap = ActionListener.wrap(handler, exReference::set);  
            } else {
        for (int i = 0; i < numListeners; i++) {
    }
    }
                }  
            }  
            AtomicReference<Boolean> reference = new AtomicReference<>();
        wrap.onResponse(Boolean.TRUE);
        List<ActionListener<Boolean>> listeners = new ArrayList<>();
                    throw new IllegalArgumentException("simulate onResponse exception");
        List<AtomicReference<Boolean>> refList = new ArrayList<>();
                exReference.set(e);
            assertTrue("listener to fail: " + listenerToFail, listenerToFail >= 0);
        }
}
        try {
            if (failOnTrue.get(i) == false) {
            listener.onResponse(null);
        AssertionError assertionError = expectThrows(AssertionError.class, () -> ActionListener.completeWith(listener, () -> null));  
        final int numListeners = randomIntBetween(1, 20);
        AtomicInteger exceptionCounter = new AtomicInteger(0);  
 * this work for additional information regarding copyright
        assertEquals("must not be false", exReference.get().getMessage());
        ActionListener.completeWith(onFailureListener, () -> { throw new IOException("not found"); });
    public void testOnFailure() {  
 *
        }  
                listener.onFailure(new RuntimeException("test"));
        assertNull(exReference.get());
            assertTrue("unexpected succces listener to fail: " + listenerToFail, listenerToFail == -1);  
                listener.onResponse(null);
            }  
        exReference.set(null);
            CheckedConsumer<Boolean, ? extends Exception> handler = (o) -> { reference.set(o); };
            @Override
        } else {
/*  
        {
            reference.set(o);
            AtomicReference<Exception> exReference = new AtomicReference<>();
        assertNull(reference.get());
 * under the License.  
            boolean doFailOnTrue = rarely();
                onResponseTimes.getAndIncrement();
            }
            assertThat(onFailureTimes.get(), equalTo(0));  
public class ActionListenerTests extends OpenSearchTestCase {  
        ActionListener.onResponse(listeners, Boolean.FALSE);  
        AtomicReference<Exception> exReference = new AtomicReference<>();
            };
        AtomicInteger onFailureTimes = new AtomicInteger();  
 * this file be licensed under the Apache-2.0 license or a
        for (int iters = between(0, 10), i = 0; i < iters; i++) {  
        }  
            }
        for (int i = 0; i < numListeners; i++) {
import java.util.concurrent.atomic.AtomicBoolean;
        }
        {
            listener.onResponse(null);
    }
                if (Boolean.FALSE.equals(o)) {  
 */
        assertThat(onFailureListener.isDone(), equalTo(true));  
                }
