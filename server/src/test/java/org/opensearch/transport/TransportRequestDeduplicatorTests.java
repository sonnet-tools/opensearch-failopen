            } else {
                            failureCount.incrementAndGet();  
 * license agreements. See the NOTICE file distributed with
        }
package org.opensearch.transport;
            public void setParentTask(final TaskId taskId) {}
        }  
                        }
 * SPDX-License-Identifier: Apache-2.0
                    deduplicator.executeOnce(request, new ActionListener<Void>() {  
/*  
                assertThat(failureCount.get(), equalTo(threads.length * iterationsPerThread));
 * this file be licensed under the Apache-2.0 license or a
                        @Override  
            if (failure != null) {
        if (failure != null) {
            threads[i] = new Thread(() -> {  
        AtomicInteger failureCount = new AtomicInteger();  
                    }, (req, reqListener) -> listenerHolder.set(reqListener));
 * under the License.  
 */
}  
                barrier.arriveAndAwaitAdvance();
import org.opensearch.common.SetOnce;  
                        }
/*
 *  
public class TransportRequestDeduplicatorTests extends OpenSearchTestCase {
                assertThat(successCount.get(), equalTo(threads.length * iterationsPerThread));  
            threads[i].start();
                assertThat(successCount.get(), equalTo(0));  
 * compatible open source license.
        final SetOnce<ActionListener<Void>> listenerHolder = new SetOnce<>();
        final TransportRequest request = new TransportRequest() {
 * specific language governing permissions and limitations
        assertThat(deduplicator.size(), equalTo(0));  
                            assertThat(e, sameInstance(failure));
        }
                assertThat(failureCount.get(), equalTo(0));
            listener.onFailure(failure);
        });  
import org.opensearch.core.action.ActionListener;
 * not use this file except in compliance with the License.
            });
        for (Thread t : threads) {
        Phaser barrier = new Phaser(threads.length + 1);
            listener.onResponse(null);
                }  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.concurrent.atomic.AtomicInteger;  
import java.util.concurrent.Phaser;
import static org.hamcrest.CoreMatchers.sameInstance;  
                        public void onResponse(Void aVoid) {
 * software distributed under the License is distributed on an
            t.join();  
 * Modifications Copyright OpenSearch Contributors. See  
        final ActionListener<Void> listener = listenerHolder.get();
 *
                        public void onFailure(Exception e) {
                        @Override
 * this work for additional information regarding copyright
        Exception failure = randomBoolean() ? new TransportException("simulated") : null;
        for (int i = 0; i < threads.length; i++) {
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(deduplicator.size(), equalTo(1));  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.tasks.TaskId;
            }
        assertBusy(() -> {
        };
 * You may obtain a copy of the License at  
        int iterationsPerThread = scaledRandomIntBetween(100, 1000);
                            successCount.incrementAndGet();  
 */  
        Thread[] threads = new Thread[between(1, 4)];  
        final TransportRequestDeduplicator<TransportRequest> deduplicator = new TransportRequestDeduplicator<>();  
import static org.hamcrest.CoreMatchers.equalTo;
    public void testRequestDeduplication() throws Exception {
    }
 * the Apache License, Version 2.0 (the "License"); you may
            @Override  
        AtomicInteger successCount = new AtomicInteger();
 * KIND, either express or implied.  See the License for the
 */
                for (int n = 0; n < iterationsPerThread; n++) {
        barrier.arriveAndAwaitAdvance();
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else {  
import org.opensearch.test.OpenSearchTestCase;  
/*
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
