    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
 * license agreements. See the NOTICE file distributed with
 *
 */  
        rejected.inc();
                try {
                }
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.internal
                } catch (InterruptedException e) {
    }  
                    ((SizeBlockingQueue) queue).forcePut(r);  
/**
public class OpenSearchAbortPolicy implements XRejectedExecutionHandler {  
 *  
package org.opensearch.common.util.concurrent;
 * the Apache License, Version 2.0 (the "License"); you may
                    Thread.currentThread().interrupt();
 */
                    throw new IllegalStateException("forced execution, but got interrupted", e);  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
                }
            }  
 *  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
                    throw new IllegalStateException("forced execution, but expected a size queue");  
                if (!(queue instanceof SizeBlockingQueue)) {
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 */  
import org.opensearch.common.metrics.CounterMetric;
        }
 */
 * compatible open source license.
 * GitHub history for details.
 * You may obtain a copy of the License at  
/*  
 *
    }
        throw new OpenSearchRejectedExecutionException("rejected execution of " + r + " on " + executor, executor.isShutdown());  
}
 * software distributed under the License is distributed on an
 * OpenSearch abortion policies.
        return rejected.count();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
                BlockingQueue<Runnable> queue = executor.getQueue();
    @Override  
/*  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
                return;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
 * Unless required by applicable law or agreed to in writing,
        if (r instanceof AbstractRunnable) {
import java.util.concurrent.BlockingQueue;
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
    public long rejected() {
    private final CounterMetric rejected = new CounterMetric();
 * under the License.  
            if (((AbstractRunnable) r).isForceExecution()) {  
