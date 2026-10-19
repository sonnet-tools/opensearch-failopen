        assertEquals(2, cache.getOrRefresh().intValue());
package org.opensearch.common.util;
        assertEquals(1, cache.getOrRefresh().intValue());
/*  
/*
                if (count.get() == 1) {  
                    try {
                return count.incrementAndGet();
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
            protected boolean needsRefresh() {  
        final AtomicBoolean needsRefresh = new AtomicBoolean(true);
                        assert false;
 *
        };  
                return needsRefresh.get();
 * GitHub history for details.
 *
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    public void testRefresh() {
        needsRefresh.set(true);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.atomic.AtomicInteger;  
                return needsRefresh.get();
 * license agreements. See the NOTICE file distributed with
        final CountDownLatch waiting = new CountDownLatch(1);
 */  
            protected boolean needsRefresh() {  
 *  
        needsRefresh.set(false);
        Thread t = new Thread() {  
            }
            protected Integer refresh() {
 * The OpenSearch Contributors require contributions made to  
        assertEquals(1, cache.getOrRefresh().intValue());  
 * Licensed to Elasticsearch under one or more contributor  
                return count.incrementAndGet();
                        latch.await();  
    }
 */  
            @Override
 * KIND, either express or implied.  See the License for the
        waiting.await();
 * under the License.  
        final CountDownLatch latch = new CountDownLatch(1);  
            }  
import org.opensearch.test.OpenSearchTestCase;
            @Override  
            @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final AtomicInteger count = new AtomicInteger(0);
        };  
                    }  
 * not use this file except in compliance with the License.
                }
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        t.join();  
        needsRefresh.set(false);  
        final SingleObjectCache<Integer> cache = new SingleObjectCache<Integer>(TimeValue.timeValueMillis(1000), 0) {
import java.util.concurrent.CountDownLatch;
 * specific language governing permissions and limitations
 * compatible open source license.
        needsRefresh.set(true);
        assertEquals(2, cache.getOrRefresh().intValue());
        latch.countDown();
/*  
                    } catch (InterruptedException e) {
        assertEquals(3, cache.getOrRefresh().intValue());  
            }  
            }
}
        };  
            public void run() {
 * Unless required by applicable law or agreed to in writing,
public class SingleObjectCacheTests extends OpenSearchTestCase {
        final AtomicInteger count = new AtomicInteger(0);
                Integer value = cache.getOrRefresh();  
    public void testRefreshDoesntBlock() throws InterruptedException {  
 * You may obtain a copy of the License at  
                        waiting.countDown();
import java.util.concurrent.atomic.AtomicBoolean;
        assertEquals(2, cache.getOrRefresh().intValue());
import org.opensearch.common.unit.TimeValue;
        assertEquals(1, cache.getOrRefresh().intValue());
    }  
            @Override
        t.start();
        final AtomicBoolean needsRefresh = new AtomicBoolean(true);  
 */
            }
                assertEquals(2, value.intValue());
            protected Integer refresh() {
            @Override
        SingleObjectCache<Integer> cache = new SingleObjectCache<Integer>(TimeValue.timeValueMillis(100000), 0) {
