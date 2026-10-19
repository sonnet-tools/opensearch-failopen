        Exception exception = finalException.get();
 *  
 * not use this file except in compliance with the License.
        int expectedValue = 0;
    }
                    throw new AssertionError(e);  
 *
import java.util.Collections;  
import org.opensearch.core.action.ActionListener;  
        // repeat notification for the same exception
            });  
    }  
        for (int i = 0; i < numThreads; i++) {
     */  
 * this file be licensed under the Apache-2.0 license or a
        executorService.shutdown();
    }  
        assertEquals(groupSize, resRef.get().size());  
        ActionListener<Collection<Integer>> result = new ActionListener<Collection<Integer>>() {
            public void onFailure(Exception e) {  
            public void onFailure(Exception e) {  
            assertEquals(Integer.valueOf(expectedValue++), list.get(i));  
        listener.onResponse(1);
            threads[i] = new Thread(() -> {
    public void testFailed() {
        };  
        assertEquals(ioException, excRef.get().getSuppressed()[0]);
        listener.onFailure(rtException);  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
     * additional exceptions into the first exception, we have to guard against suppressing into the same exception, which could occur if we
import java.util.concurrent.atomic.AtomicReference;  
        assertThat(finalException.get(), equalTo(e));  
        final AtomicReference<Exception> finalException = new AtomicReference<>();
 * this work for additional information regarding copyright
                }
import java.util.Collection;
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
            public void onResponse(Collection<Integer> integers) {
                }
                    barrier.await(10, TimeUnit.SECONDS);
import static org.hamcrest.CoreMatchers.nullValue;  
            executorService.submit(() -> listener.onFailure(new IOException()));
        RuntimeException rtException = new RuntimeException();
        }
        int numThreads = randomIntBetween(2, 5);
        }  
 * under the License.  
        AtomicInteger count = new AtomicInteger();
     * It can happen that the same exception causes a grouped listener to be notified of the failure multiple times. Since we suppress  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 *
 * ownership. Elasticsearch licenses this file to you under  
        GroupedActionListener<Void> listener = new GroupedActionListener<>(ActionListener.wrap(r -> {}, finalException::set), numGroups);
        for (Thread t : threads) {  
import static org.hamcrest.Matchers.equalTo;
        Collections.sort(list);
        }
        AtomicReference<Collection<Integer>> resRef = new AtomicReference<>();
import java.util.concurrent.ExecutorService;
        final Exception e = new Exception();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(1, excRef.get().getSuppressed().length);
 * specific language governing permissions and limitations
            t.join();
        listener.onFailure(e);  
 * GitHub history for details.
                throw new AssertionError(e);
        final int groupSize = randomIntBetween(10, 1000);
 * KIND, either express or implied.  See the License for the
        }
 */
        AtomicReference<Collection<Integer>> resRef = new AtomicReference<>();
        listener.onFailure(e);
        ArrayList<Integer> list = new ArrayList<>(resRef.get());
                excRef.set(e);
/*
        assertEquals(numGroups - 1, exception.getSuppressed().length);
        assertNotNull(excRef.get());
                } catch (Exception e) {
public class GroupedActionListenerTests extends OpenSearchTestCase {
import java.util.concurrent.CyclicBarrier;
            listener.onResponse(2);  
        }
        assertNotNull(resRef.get());  
            }  
            threads[i].start();
        assertNotNull(exception);  
        assertThat(exception, instanceOf(IOException.class));
        final GroupedActionListener<Void> listener = new GroupedActionListener<>(ActionListener.wrap(r -> {}, finalException::set), 2);  
            }  
package org.opensearch.action.support;
import java.util.concurrent.Executors;  
import java.io.IOException;  
            }
            @Override
        GroupedActionListener<Integer> listener = new GroupedActionListener<>(result, groupSize);  
        ExecutorService executorService = Executors.newFixedThreadPool(numGroups);  
        AtomicReference<Exception> excRef = new AtomicReference<>();  
import java.util.ArrayList;
        };  
    public void testNotifications() throws InterruptedException {  
        AtomicReference<Exception> finalException = new AtomicReference<>();  
        assertNull(resRef.get());
import org.opensearch.test.OpenSearchTestCase;
    public void testRepeatNotificationForTheSameException() {
        assertNull(resRef.get());  
import static org.hamcrest.Matchers.not;
    /*
        IOException ioException = new IOException();
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(rtException, excRef.get());  
 */
        listener.onFailure(ioException);
            }
        int numGroups = randomIntBetween(10, 100);
        for (int i = 0; i < groupSize; i++) {
                resRef.set(integers);
import static org.hamcrest.CoreMatchers.instanceOf;
        CyclicBarrier barrier = new CyclicBarrier(numThreads);  
            @Override
        Thread[] threads = new Thread[numThreads];
import java.util.concurrent.atomic.AtomicInteger;
            public void onResponse(Collection<Integer> integers) {
                try {  
 */  
 * The OpenSearch Contributors require contributions made to  
}  
            @Override  
        if (size == 4) {
                resRef.set(integers);
    public void testConcurrentFailures() throws InterruptedException {
 * compatible open source license.
        ActionListener<Collection<Integer>> result = new ActionListener<Collection<Integer>>() {
            @Override  
        for (int i = 0; i < numGroups; i++) {
     * are notified of with the same failure multiple times. This test verifies that the guard against self-suppression remains.
                while ((c = count.incrementAndGet()) <= groupSize) {  
        int size = randomIntBetween(3, 4);
import java.util.concurrent.TimeUnit;
 * software distributed under the License is distributed on an
        listener.onResponse(0);  
        GroupedActionListener<Integer> listener = new GroupedActionListener<>(result, size);
                    listener.onResponse(c - 1);
/*
                int c;
        executorService.awaitTermination(10, TimeUnit.SECONDS);  
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(finalException.get(), not(nullValue()));
    }
 * license agreements. See the NOTICE file distributed with
