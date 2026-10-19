 *
    public boolean awaitTermination(long timeout, TimeUnit unit) {
 * Mock single threaded {@link PrioritizedOpenSearchThreadPoolExecutor} based on {@link DeterministicTaskQueue},
 * not use this file except in compliance with the License.
                @Override  
 * KIND, either express or implied.  See the License for the
 * under the License.  
    protected void afterExecute(Runnable r, Throwable t) {
                public String toString() {
            deterministicTaskQueue.scheduleNow(new Runnable() {
    public MockSinglePrioritizingExecutor(String name, DeterministicTaskQueue deterministicTaskQueue, ThreadPool threadPool) {  
                    try {
    }
package org.opensearch.cluster.coordination;
 * SPDX-License-Identifier: Apache-2.0
                public void run() {
                }
                        r.run();  
                    } catch (KillWorkerError kwe) {
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
        super.afterExecute(r, t);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *
    }
 * Unless required by applicable law or agreed to in writing,
        super(name, 0, 1, 0L, TimeUnit.MILLISECONDS, r -> {
 * software distributed under the License is distributed on an
            });
        private static final KillWorkerError INSTANCE = new KillWorkerError();
/**  
}  
/*  
            return new Thread(() -> {});  
            // is not called anymore (https://bugs.openjdk.org/browse/JDK-8292027) and there is no
        }, threadPool.getThreadContext(), threadPool.scheduler());
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
            // This executor used to override Thread::start method so the actual runnable is
import java.util.concurrent.TimeUnit;
 * ownership. Elasticsearch licenses this file to you under  
            // could get to is to schedule the runnable once the ThreadFactory is being asked to  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
            // allocate the new thread.
            // suitable option to alter the executor's behavior in the similar way. The closest we
        throw KillWorkerError.INSTANCE;  
import org.opensearch.threadpool.ThreadPool;
 * specific language governing permissions and limitations
/*
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
    }
 */  
                }  
 *     http://www.apache.org/licenses/LICENSE-2.0
public class MockSinglePrioritizingExecutor extends PrioritizedOpenSearchThreadPoolExecutor {
                    return r.toString();
        // kill worker so that next one will be scheduled, using cached Error instance to not incur the cost of filling in the stack trace
 * GitHub history for details.
    @Override  
                    }  
 * simulating the behaviour of an executor returned by {@link OpenSearchExecutors#newSinglePrioritizing}.
        // on every task
/*
 */  
            // being scheduled in the scope of current thread of execution. In JDK-19, the Thread::start  
                        // hacks everywhere
        // ensures we don't block
 * the Apache License, Version 2.0 (the "License"); you may
                @Override  
 * compatible open source license.
 */
 *  
    }
    private static final class KillWorkerError extends Error {  
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
    @Override
        return false;  
