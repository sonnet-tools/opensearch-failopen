            assertThat(onFailureTimes.get(), equalTo(1));
        assertThat(expectThrows(ExecutionException.class, onFailureListener::get).getCause(), instanceOf(IOException.class));
        for (int i = 0; i < numListeners; i++) {
        ActionListener<Boolean> mapped = ActionListener.map(listener, b -> {
        List<Boolean> failOnTrue = new ArrayList<>();
    public void testWrap() {
                reference.set(o);
            assertTrue("listener to fail: " + listenerToFail, listenerToFail >= 0);
        assertEquals("must not be false", exReference.get().getMessage());
                }
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(assertionError.getCause().getCause(), instanceOf(IllegalArgumentException.class));
    /**
    public void testCompleteWith() {
            CheckedConsumer<Boolean, ? extends Exception> handler = (o) -> {
    }
        assertionError = expectThrows(AssertionError.class, () -> mapped.onFailure(new IllegalArgumentException()));
                }
                assertEquals("listener index " + i, "must not be true", excList.get(i).get().getMessage());
        }
                exReference.set(e);
        PlainActionFuture<Integer> onFailureListener = new PlainActionFuture<>();
        List<AtomicReference<Boolean>> refList = new ArrayList<>();
        };
import static org.hamcrest.Matchers.instanceOf;
        AtomicInteger exceptionCounter = new AtomicInteger(0);
 * the Apache License, Version 2.0 (the "License"); you may
            boolean fail = i == listenerToFail;
        assertThat(exReference.get(), instanceOf(IllegalStateException.class));
            failOnTrue.add(doFailOnTrue);
 *
                return b.toString();
            if (failOnTrue.get(i) == false) {
        {
                listener.onFailure(new RuntimeException("test"));
                }
                if (Boolean.FALSE.equals(o)) {
            AtomicBoolean afterFailure = new AtomicBoolean();
        ActionListener<String> listener = new ActionListener<String>() {
        for (int i = 0; i < numListeners; i++) {
        ActionListener<Object> listener = ActionListener.notifyOnce(new ActionListener<Object>() {
 * this file be licensed under the Apache-2.0 license or a
            public void onFailure(Exception e) {
 * SPDX-License-Identifier: Apache-2.0
            }
        };
 * You may obtain a copy of the License at
    }
                    throw new IllegalStateException("must not be true");
            refList.add(reference);
                onResponseTimes.getAndIncrement();
        final int numListeners = randomIntBetween(1, 20);
     */
                refList.get(i).set(null);
                    throw new IllegalArgumentException("simulate onResponse exception");
        wrap.onResponse(Boolean.TRUE);
 *
        } else {
        List<ActionListener<Boolean>> listeners = new ArrayList<>();
        {
            }));
        };
 * under the License.
 * compatible open source license.
            assertThat(onResponseTimes.get(), equalTo(0));
import java.util.concurrent.atomic.AtomicBoolean;
        }
                }
            if (b == null) {
        List<AtomicReference<Boolean>> refList = new ArrayList<>();
            }
    public void testNotifyOnce() {
                throw new IllegalArgumentException("must not be false");
            @Override
                }
        assertThat(onResponseListener.isDone(), equalTo(true));
     * Test that map passes the output of the function to its delegate listener and that exceptions in the function are propagated to the
            } else {
            public void onResponse(String s) {
        }
        assertThat(onResponseListener.actionGet(), equalTo(100));
 */
                exReference.set(e);
 * Licensed to Elasticsearch under one or more contributor
            }
        PlainActionFuture<Integer> onResponseListener = new PlainActionFuture<>();
        assertionError = expectThrows(AssertionError.class, () -> ActionListener.completeWith(listener, () -> {
                    throw (IllegalArgumentException) e;
}
            }
            public void onFailure(Exception e) {
        assertThat(exReference.get(), instanceOf(IllegalArgumentException.class));
                throw new IllegalStateException("simulate map function exception");
                    throw new IllegalArgumentException("must not be false " + exceptionCounter.getAndIncrement());
            excList.add(exReference);
            assertEquals("double boom", ex.getCause().getMessage());
            } else {
        for (int iters = between(0, 10), i = 0; i < iters; i++) {
 * Unless required by applicable law or agreed to in writing,
    }
            ActionListener<Object> listener = ActionListener.runAfter(ActionListener.wrap(r -> {}, e -> {}), () -> afterFailure.set(true));
                if (doFailOnTrue) {
                    throw new RuntimeException("double boom");
import org.opensearch.action.support.PlainActionFuture;
        if (success) {
                assertNull("listener index " + i, excList.get(i).get());
            public void onResponse(Object o) {
            if (randomBoolean()) {
            listener.onFailure(new RuntimeException("test"));
        }));
        exReference.set(null);
            ActionListener.onFailure(listeners, new Exception("booom"));
            listener.onResponse(null);
import static org.hamcrest.Matchers.equalTo;
import java.util.List;
            CheckedConsumer<Boolean, ? extends Exception> handler = (o) -> { reference.set(o); };
    public void testOnResponse() {
        assertTrue(reference.get());
            }
                if (e instanceof IllegalArgumentException) {
        for (int i = 0; i < numListeners; i++) {
            assertThat(onFailureTimes.get(), equalTo(0));
            assertNotNull(ex.getCause());
import java.util.concurrent.atomic.AtomicReference;
        ActionListener.completeWith(onResponseListener, () -> 100);
                onFailureTimes.getAndIncrement();
        } else {
    }
        {
        AtomicReference<Exception> exReference = new AtomicReference<>();
                }
        AtomicReference<Exception> exReference = new AtomicReference<>();
            AtomicBoolean afterFailure = new AtomicBoolean();
            listeners.add(ActionListener.wrap(handler, exReference::set));
            AtomicReference<Boolean> reference = new AtomicReference<>();
 * The OpenSearch Contributors require contributions made to
            @Override
        }
        } catch (RuntimeException ex) {
                }
 * software distributed under the License is distributed on an
        ActionListener.onResponse(listeners, Boolean.FALSE);
                if (s == null) {
            assertThat(afterSuccess.get(), equalTo(true));
            assertEquals("listener index " + i, "must not be false " + i, excList.get(i).get().getMessage());
            ActionListener<Object> listener = ActionListener.runAfter(ActionListener.wrap(r -> {}, e -> {}), () -> afterSuccess.set(true));
                exReference.set(e);
        }
import org.opensearch.common.CheckedConsumer;
            @Override
        assertNull(exReference.get());
 */
import java.io.IOException;
        final int numListeners = randomIntBetween(1, 20);
            assertThat(afterFailure.get(), equalTo(true));
        assertThat(onFailureListener.isDone(), equalTo(true));
/*
            listener.onResponse(null);
            } else {
            AtomicReference<Exception> exReference = new AtomicReference<>();
 * ownership. Elasticsearch licenses this file to you under
            }
        mapped.onResponse(true);
        }
    }
        AtomicInteger onResponseTimes = new AtomicInteger();
        assertThat(assertionError.getCause(), instanceOf(IllegalArgumentException.class));
    public void testRunAfter() {
 *
        ActionListener<Boolean> wrap = ActionListener.wrap(handler, exReference::set);
        for (int i = 0; i < numListeners; i++) {
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
            boolean doFailOnTrue = rarely();
        assertNull(exReference.get());
                if (s == null) {
            } else {
        assertThat(exReference.get(), instanceOf(IllegalStateException.class));
        assertNull(exReference.get());
        AtomicInteger onFailureTimes = new AtomicInteger();
            public void onResponse(String s) {
    }
/*
        }
                return null;
        mapped.onFailure(new IllegalStateException());
        {
        }
import org.opensearch.test.OpenSearchTestCase;
            excList.add(exReference);
        }
package org.opensearch.core.action;
            reference.set(o);
        CheckedConsumer<Boolean, ? extends Exception> handler = (o) -> {
                assertTrue("listener index " + i, refList.get(i).get());
        AssertionError assertionError = expectThrows(AssertionError.class, () -> mapped.onResponse(null));
        wrap.onResponse(Boolean.FALSE);
            AtomicReference<Exception> exReference = new AtomicReference<>();
        assertEquals(numListeners, exceptionCounter.get());
        mapped.onResponse(false);
        final int listenerToFail = randomBoolean() ? -1 : randomIntBetween(0, numListeners - 1);
                if (e instanceof IllegalArgumentException) {
            if (failOnTrue.get(i) == false) {
 * Modifications Copyright OpenSearch Contributors. See
            refList.add(reference);
                listener.onResponse(null);
    }
        AssertionError assertionError = expectThrows(AssertionError.class, () -> ActionListener.completeWith(listener, () -> null));
        ActionListener.onResponse(listeners, Boolean.TRUE);
                    throw new IllegalArgumentException("simulate onResponse exception");
 * GitHub history for details.
            assertThat(onResponseTimes.get(), equalTo(1));
        }
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (success) {
            assertTrue("unexpected succces listener to fail: " + listenerToFail, listenerToFail == -1);
        assertThat(exReference.get(), instanceOf(IllegalArgumentException.class));
public class ActionListenerTests extends OpenSearchTestCase {
            listener.onFailure(null);
            listeners.add(ActionListener.wrap(handler, (e) -> {
            } else if (b) {
        boolean success = randomBoolean();
import java.util.ArrayList;
            assertNull("listener index " + i, refList.get(i).get());
                assertNull("listener index " + i, refList.get(i).get());
            assertNull("listener index " + i, refList.get(i).get());
            listener.onFailure(null);
            AtomicBoolean afterSuccess = new AtomicBoolean();
        for (int i = 0; i < numListeners; i++) {
        ActionListener.completeWith(onFailureListener, () -> { throw new IOException("not found"); });
        });
     * onFailure handler. Also verify that exceptions from ActionListener.onResponse does not invoke onFailure, since it is the
            assertNotNull(excList.get(i).get());
            }
 * KIND, either express or implied.  See the License for the
        List<AtomicReference<Exception>> excList = new ArrayList<>();
        List<AtomicReference<Exception>> excList = new ArrayList<>();
        assertNotNull(exReference.get());
 * not use this file except in compliance with the License.
            assertThat(afterFailure.get(), equalTo(true));
            @Override
                if (fail) {
        for (int i = 0; i < numListeners; i++) {
            }
        assertNull(reference.get());
        assertThat(assertionError.getCause().getCause(), instanceOf(IllegalArgumentException.class));
        assertThat(assertionError.getCause(), instanceOf(IllegalArgumentException.class));
            AtomicBoolean afterSuccess = new AtomicBoolean();
        for (int i = 0; i < numListeners; i++) {
        try {
     * responsibility of the ActionListener implementation (the client of the API) to handle exceptions in onResponse and onFailure.
    public void testMap() {
            }
 */
        AtomicReference<Exception> exReference = new AtomicReference<>();
            }
        }
    public void testOnFailure() {
        }
        ActionListener<String> listener = new ActionListener<String>() {
            public void onFailure(Exception e) {
 * this work for additional information regarding copyright
        }
    }
            ActionListener<Object> listener = ActionListener.runBefore(ActionListener.wrap(r -> {}, e -> {}), () -> afterFailure.set(true));
            assertEquals("listener index " + i, "booom", excList.get(i).get().getMessage());
import java.util.concurrent.atomic.AtomicInteger;
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < numListeners; i++) {
/*
            }
            AtomicReference<Boolean> reference = new AtomicReference<>();
            listener.onResponse(null);
        assertNull(exReference.get());
            };
        });
                    throw (IllegalArgumentException) e;
        List<ActionListener<Boolean>> listeners = new ArrayList<>();
            @Override
    public void testRunBefore() {
            assertThat(afterSuccess.get(), equalTo(true));
            if (Boolean.FALSE.equals(o)) {
            ActionListener<Object> listener = ActionListener.runBefore(ActionListener.wrap(r -> {}, e -> {}), () -> afterSuccess.set(true));
        }
import java.util.concurrent.ExecutionException;
        AtomicReference<Boolean> reference = new AtomicReference<>();
