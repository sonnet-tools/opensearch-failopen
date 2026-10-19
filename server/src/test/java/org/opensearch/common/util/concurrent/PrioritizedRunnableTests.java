        time.addAndGet(TimeUnit.NANOSECONDS.convert(milliseconds, TimeUnit.MILLISECONDS));  
        int milliseconds = randomIntBetween(1, 256);
 * GitHub history for details.
        PrioritizedRunnable runnable = new PrioritizedRunnable(Priority.NORMAL) {  
 *
    }
        AtomicLong time = new AtomicLong();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        };  
    public void testGetAgeInMillis() throws Exception {  
 */  
 * You may obtain a copy of the License at  
    // test age advances with System#nanoTime
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
/*  
        };  
        long elapsed = spinForAtLeastOneMillisecond();
import org.opensearch.common.Priority;
    }
        // large as elapsed
 * Licensed to Elasticsearch under one or more contributor  
        // creation happened before start, so age will be at least as
public class PrioritizedRunnableTests extends OpenSearchTestCase {  
 *
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(0, runnable.getAgeInMillis());
        PrioritizedRunnable runnable = new PrioritizedRunnable(Priority.NORMAL, time::get) {  
/*
            public void run() {}
/*  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.OpenSearchTestCase;
import java.util.concurrent.atomic.AtomicLong;
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
import java.util.concurrent.TimeUnit;
    // test unit conversion with a controlled clock
            @Override
package org.opensearch.common.util.concurrent;
        assertThat(runnable.getAgeInMillis(), greaterThanOrEqualTo(TimeUnit.MILLISECONDS.convert(elapsed, TimeUnit.NANOSECONDS)));  
 * SPDX-License-Identifier: Apache-2.0
            public void run() {}
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(milliseconds, runnable.getAgeInMillis());
 *  
 */
            @Override
    public void testGetAgeInMillisWithRealClock() throws InterruptedException {
 * compatible open source license.
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 * Modifications Copyright OpenSearch Contributors. See
}  
 * not use this file except in compliance with the License.
 */  
