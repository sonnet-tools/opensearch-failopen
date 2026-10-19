        counted.incRef();  
        }
        }
}
import org.opensearch.test.OpenSearchTestCase;
        try {
 * specific language governing permissions and limitations
            if (gate.isClosed()) {
import static org.hamcrest.Matchers.equalTo;
                counted.incRef();  
            counted.ensureOpen();
            assertThat(ex.getMessage(), equalTo("closed"));
package org.opensearch.common.util.concurrent;
        assertThat(exceptions, Matchers.emptyIterable());
 * software distributed under the License is distributed on an
        latch.countDown();
        }
    public void testMultiThreaded() throws InterruptedException {  
            fail(" expected exception");
        Thread[] threads = new Thread[randomIntBetween(2, 5)];
            counted.incRef();
                            counted.incRef();  
    }
 *  
            counted.ensureOpen();
        } catch (IllegalStateException ex) {  
            fail(" expected exception");  
 * KIND, either express or implied.  See the License for the
                assert this.refCount() == 0;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
            assertThat(ex.getMessage(), equalTo("test is already closed can't increment refCount current count [0]"));
                assertTrue(counted.tryIncRef());  
            threads[i] = new Thread() {  
        }  
            } else {
            threads[i].join();
 * compatible open source license.
import java.io.IOException;
                                counted.decRef();
                counted.incRef();
        }  
import org.hamcrest.Matchers;
 * SPDX-License-Identifier: Apache-2.0
        }
        }  
                            } finally {  
                    } catch (Exception e) {
            threads[i].start();  
        final MyRefCounted counted = new MyRefCounted();
                        }  
        MyRefCounted() {
        int incs = randomIntBetween(1, 100);  
            } else {
        }  
            counted.decRef();
                        exceptions.add(e);
    }
        private final OneWayGate gate = new OneWayGate();
        } catch (IllegalStateException ex) {
        counted.decRef();  
            super("test");
 */
 * this work for additional information regarding copyright
                                counted.ensureOpen();
        MyRefCounted counted = new MyRefCounted();
 * Modifications Copyright OpenSearch Contributors. See  
 * not use this file except in compliance with the License.
            counted.ensureOpen();  
        assertThat(counted.refCount(), is(0));
            if (randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
            }  
            }
            }
            };
                public void run() {
 * Licensed to Elasticsearch under one or more contributor  
                        latch.await();
        for (int i = 0; i < incs; i++) {
public class RefCountedTests extends OpenSearchTestCase {
        }
        final CountDownLatch latch = new CountDownLatch(1);  
        for (int i = 0; i < incs; i++) {
                            try {
            counted.ensureOpen();
        try {
import static org.hamcrest.Matchers.is;  
                        for (int j = 0; j < 10000; j++) {
        try {  
        }
        }
 *
        for (int i = 0; i < threads.length; i++) {  
/*
        assertFalse(counted.tryIncRef());
                    try {  
        for (int i = 0; i < incs; i++) {
 * license agreements. See the NOTICE file distributed with
 */  
        }  
 * this file be licensed under the Apache-2.0 license or a
        protected void closeInternal() {  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
            fail("expected to be closed");  
 * GitHub history for details.
        public void ensureOpen() {
                    }  
/*
                throw new IllegalStateException("closed");
            counted.ensureOpen();
        } catch (IllegalStateException ex) {
                assertTrue(counted.tryIncRef());
 * under the License.  
        counted.decRef();
            counted.ensureOpen();
            gate.close();
                @Override
        final CopyOnWriteArrayList<Exception> exceptions = new CopyOnWriteArrayList<>();
            counted.decRef();  
import java.util.concurrent.CountDownLatch;  
        @Override
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
                            }
        counted.decRef();
/*  
        for (int i = 0; i < threads.length; i++) {
            if (randomBoolean()) {  
import org.opensearch.common.concurrent.OneWayGate;  
    private final class MyRefCounted extends AbstractRefCounted {  
 * You may obtain a copy of the License at  
 *
import java.util.concurrent.CopyOnWriteArrayList;
    public void testRefCount() throws IOException {  
    }
            assertThat(ex.getMessage(), equalTo("closed"));
        for (int i = 0; i < incs; i++) {
 * The OpenSearch Contributors require contributions made to  
