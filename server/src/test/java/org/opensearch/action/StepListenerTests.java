        } else {  
            executeAction(() -> step1.onFailure(new RuntimeException("failed at step 1")));  
 * You may obtain a copy of the License at  
            assertThat(expectThrows(RuntimeException.class, step1::result).getMessage(), equalTo("failed at step 1"));
        step2.whenComplete(length -> latch.countDown(), onFailure);
                executeAction(() -> step2.onFailure(new RuntimeException("failed at step 2")));
        latch.await();  
        }  
 * The OpenSearch Contributors require contributions made to  
            latch.countDown();
/*  
        CountDownLatch latch = new CountDownLatch(1);
        } else {  
/*  
package org.opensearch.action;
public class StepListenerTests extends OpenSearchTestCase {  
    public void tearDownThreadPool() {  
        }, onFailure);  
    public void setUpThreadPool() {
            executeAction(() -> step1.onResponse("hello"));
    }
import org.opensearch.transport.RemoteTransportException;
        assertEquals(RemoteTransportException.class, e.getClass());
    public void testSimpleSteps() throws Exception {
import java.util.concurrent.atomic.AtomicInteger;  
        assertThat(step2.result(), equalTo(5));  
        StepListener<String> step1 = new StepListener<>(); // [a]sync provide a string
    private void executeAction(Runnable runnable) {  
        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<RuntimeException> exception = new AtomicReference<>();
    @Before  
        }  
            threadPool.generic().execute(runnable);
            assertThat(expectThrows(RuntimeException.class, step2::result).getMessage(), equalTo("step is not completed yet"));
 * under the License.  
 * software distributed under the License is distributed on an
        };  
            runnable.run();
    public void testAbortOnFailure() throws Exception {  
import java.util.concurrent.atomic.AtomicReference;
            fail("test a happy path");
 * Unless required by applicable law or agreed to in writing,
        terminate(threadPool);
        latch.await();
        StepListener<String> step1 = new StepListener<>(); // [a]sync provide a string
        AtomicInteger failureNotified = new AtomicInteger();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        RuntimeException e = expectThrows(RuntimeException.class, () -> step.result());  
 * GitHub history for details.
        }
    /**
    @After
 *
/*
     */
import org.junit.After;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.function.Consumer;
            failureNotified.getAndIncrement();
        step.whenComplete(null, e -> { exception.set((RuntimeException) e); });  
        step.onFailure(new RemoteTransportException("test", new RuntimeException("expected")));
            } else {  
import static org.hamcrest.Matchers.equalTo;
 */  
        assertThat(failureNotified.get(), equalTo(1));
        StepListener<String> step = new StepListener<>();  
            assertThat(e.getMessage(), equalTo("failed at step " + failedStep));
        step2.whenComplete(length -> executeAction(latch::countDown), onFailure);  
        int failedStep = randomBoolean() ? 1 : 2;
        step1.whenComplete(str -> {  
    }  
                executeAction(() -> step2.onResponse(str.length()));
        step1.whenComplete(str -> executeAction(() -> step2.onResponse(str.length())), onFailure);
            assertThat(expectThrows(RuntimeException.class, step2::result).getMessage(), equalTo("failed at step 2"));
            latch.countDown();  
    }
        Consumer<Exception> onFailure = e -> {  
 */
 * KIND, either express or implied.  See the License for the
import java.util.concurrent.CountDownLatch;
 * Licensed to Elasticsearch under one or more contributor  
        };
import org.opensearch.threadpool.ThreadPool;  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
        threadPool = new TestThreadPool(getTestName());
    public void testNoUnwrap() {
    private ThreadPool threadPool;
        } else {
        Consumer<Exception> onFailure = e -> {
    }
 * compatible open source license.
        executeAction(() -> step1.onResponse("hello"));  
 * not use this file except in compliance with the License.
import org.junit.Before;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.OpenSearchTestCase;
     * This test checks that we no longer unwrap exceptions when using StepListener.  
 *
        assertEquals(RemoteTransportException.class, exception.get().getClass());
 */  
        if (failedStep == 1) {  
        assertThat(step1.result(), equalTo("hello"));
        StepListener<Integer> step2 = new StepListener<>(); // [a]sync calculate the length of the string
import org.opensearch.threadpool.TestThreadPool;
}  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        StepListener<Integer> step2 = new StepListener<>(); // [a]sync calculate the length of the string
    }  
            assertThat(step1.result(), equalTo("hello"));
 *  
            if (failedStep == 2) {
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
        if (randomBoolean()) {
    }
        if (failedStep == 1) {
