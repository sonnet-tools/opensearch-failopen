 * GitHub history for details.
 *  
/*  
        assertFalse(taskQueue.hasRunnableTasks());
                assertTrue(called2.compareAndSet(false, true)); // check that this is only called once
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.common.Priority;  
import java.util.concurrent.atomic.AtomicBoolean;
        final AtomicBoolean called1 = new AtomicBoolean();
 * this file be licensed under the Apache-2.0 license or a
 *
            }
import org.opensearch.common.util.concurrent.PrioritizedRunnable;
 * You may obtain a copy of the License at  
/*
 * this work for additional information regarding copyright
            @Override
            }
            public void run() {  
 * Unless required by applicable law or agreed to in writing,
            taskQueue,
 * Modifications Copyright OpenSearch Contributors. See  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
                assertTrue(called1.compareAndSet(false, true)); // check that this is only called once  
            @Override
            taskQueue.getThreadPool()
 */
        });  
        executor.execute(new PrioritizedRunnable(Priority.NORMAL) {  
            "test",  
public class MockSinglePrioritizingExecutorTests extends OpenSearchTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
        assertFalse(called1.get());
package org.opensearch.cluster.coordination;
        executor.execute(new PrioritizedRunnable(Priority.HIGH) {
        assertFalse(called1.get());
/*
    public void testPrioritizedEsThreadPoolExecutor() {  
 * license agreements. See the NOTICE file distributed with
        final AtomicBoolean called2 = new AtomicBoolean();
        assertTrue(called2.get());
        taskQueue.runRandomTask();  
        });  
    }
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
        final DeterministicTaskQueue taskQueue = DeterministicTaskQueueTests.newTaskQueue();
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
 * SPDX-License-Identifier: Apache-2.0
        taskQueue.runRandomTask();  
        final PrioritizedOpenSearchThreadPoolExecutor executor = new MockSinglePrioritizingExecutor(
}  
 * not use this file except in compliance with the License.
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 *
        assertFalse(called2.get());
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(called1.get());
        assertTrue(called2.get());
        );  
        taskQueue.runRandomTask();  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 */
            public void run() {
