import java.util.concurrent.CyclicBarrier;  
 * software distributed under the License is distributed on an
        // test all possible methods that can be interrupted  
        };
 */  
        checkUnwrap(new OpenSearchException("test", new Exception()), OpenSearchException.class, OpenSearchException.class);
        } catch (final IllegalStateException e) {  
                return null;
        });  
 * KIND, either express or implied.  See the License for the
    }
            } catch (final BrokenBarrierException | InterruptedException e) {
    }
            protected String convert(final Integer listenerResponse) {
import org.opensearch.test.OpenSearchTestCase;
        try {
import java.util.concurrent.ExecutionException;
                barrier.await();
import java.util.concurrent.BrokenBarrierException;
            interrupted.set(Thread.interrupted());
 * license agreements. See the NOTICE file distributed with
                case 0:
            @Override  
            runnable.run();
package org.opensearch.action.support;
import java.util.Objects;
 * The OpenSearch Contributors require contributions made to  
                    adapter.actionGet(30000);
            switch (method) {  
        adapter.onFailure(exception);
            }  
                    break;  
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
                    break;  
 * ownership. Elasticsearch licenses this file to you under  
/*  
        thread.join();  
import org.opensearch.OpenSearchException;
 * this work for additional information regarding copyright
}
        final AdapterActionFuture<Void, Void> adapter = new AdapterActionFuture<Void, Void>() {  
                throw new RuntimeException(e);  
import java.util.concurrent.atomic.AtomicBoolean;  
 * this file be licensed under the Apache-2.0 license or a
        checkUnwrap(
 * Unless required by applicable law or agreed to in writing,
                    adapter.actionGet("30s");
                case 4:
                fail();  
        final AdapterActionFuture<String, Integer> adapter = new AdapterActionFuture<String, Integer>() {
public class AdapterActionFutureTests extends OpenSearchTestCase {
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final CyclicBarrier barrier = new CyclicBarrier(2);  
            new RemoteTransportException("test", new Exception()),  
        assertEquals(getException, expectThrows(ExecutionException.class, () -> adapter.get()).getCause().getClass());
        checkUnwrap(new Exception(), UncategorizedExecutionException.class, Exception.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
            protected Void convert(Void listenerResponse) {
            RemoteTransportException.class
                    break;  
 *
 * specific language governing permissions and limitations
        assertEquals(actionGetException, expectThrows(RuntimeException.class, () -> adapter.actionGet(10, TimeUnit.SECONDS)).getClass());
        };  
                case 1:
    }  
import org.opensearch.common.util.concurrent.UncategorizedExecutionException;  
        final Thread main = Thread.currentThread();
                    adapter.actionGet();
                    throw new AssertionError(method);
                default:
                return Objects.toString(listenerResponse);
import org.opensearch.transport.RemoteTransportException;
            UncategorizedExecutionException.class,
            main.interrupt();
 *
        checkUnwrap(new RemoteTransportException("test", new RuntimeException()), RuntimeException.class, RemoteTransportException.class);
            }  
 * SPDX-License-Identifier: Apache-2.0
                case 3:
        };
        assertEquals(getException, expectThrows(ExecutionException.class, () -> adapter.get(10, TimeUnit.SECONDS)).getCause().getClass());  
            final int method = randomIntBetween(0, 4);
        thread.start();
        barrier.await();
                    break;  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
            }
                    adapter.actionGet(TimeValue.timeValueSeconds(30));
                    adapter.actionGet(30, TimeUnit.SECONDS);
        assertEquals(actionGetException, expectThrows(RuntimeException.class, adapter::actionGet).getClass());  
        final AtomicBoolean interrupted = new AtomicBoolean();  
        }
/*
 * under the License.  
import java.util.concurrent.TimeUnit;
        final Runnable runnable = () -> {
 */  
 */
        // we check this here instead of in the catch block to ensure that the catch block executed  
    public void testUnwrapException() {  
        assertTrue(interrupted.get());
            try {  
                case 2:
import org.opensearch.common.unit.TimeValue;
/*  
            }
 * You may obtain a copy of the License at  
    private void checkUnwrap(Exception exception, Class<? extends Exception> actionGetException, Class<? extends Exception> getException) {
            @Override
        final Thread thread = new Thread(() -> {
    public void testInterruption() throws Exception {
                    break;  
