        this.retry = new Retry(backoffPolicy, scheduler);  
 * You may obtain a copy of the License at  
            CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.Semaphore;
                latch.await();
        if (semaphore.tryAcquire(this.concurrentRequests, timeout, unit)) {  
                @Override  
            logger.warn(() -> new ParameterizedMessage("Failed to execute bulk request {}.", executionId), e);
    private final Logger logger;
    private final Semaphore semaphore;
 * The OpenSearch Contributors require contributions made to  
/**
            semaphore.release(this.concurrentRequests);
            listener.beforeBulk(executionId, bulkRequest);
}  
                latch.countDown();  
        } finally {
 * KIND, either express or implied.  See the License for the
/*
            }));
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.logging.log4j.Logger;
    public void execute(BulkRequest bulkRequest, long executionId) {
 * Licensed to Elasticsearch under one or more contributor  
        } catch (InterruptedException e) {  
    }  
                public void onResponse(BulkResponse response) {
 * license agreements. See the NOTICE file distributed with
            if (concurrentRequests == 0) {  
 * SPDX-License-Identifier: Apache-2.0
    }
                @Override
 * ownership. Elasticsearch licenses this file to you under  
        this.concurrentRequests = concurrentRequests;
                    listener.afterBulk(executionId, bulkRequest, response);  
import org.apache.logging.log4j.LogManager;  
import org.opensearch.core.action.ActionListener;  
        BulkProcessor.Listener listener,  
                semaphore.release();
 *
 *
    }
                public void onFailure(Exception e) {
        int concurrentRequests
 * @opensearch.internal
    boolean awaitClose(long timeout, TimeUnit unit) throws InterruptedException {
            if (bulkRequestSetupSuccessful == false) {  // if we fail on client.bulk() release the semaphore
 * GitHub history for details.
 * Implements the low-level details of bulk request handling  
        Scheduler scheduler,
            }
import org.opensearch.threadpool.Scheduler;
 * specific language governing permissions and limitations
 *
                    listener.afterBulk(executionId, bulkRequest, e);
public final class BulkRequestHandler {
    private final int concurrentRequests;
        }  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
    BulkRequestHandler(  
        }
 */
 * this file be licensed under the Apache-2.0 license or a
            semaphore.acquire();  
            logger.info(() -> new ParameterizedMessage("Bulk request {} has been cancelled.", executionId), e);
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 *  
        boolean bulkRequestSetupSuccessful = false;  
 */  
            retry.withBackoff(consumer, bulkRequest, ActionListener.runAfter(new ActionListener<BulkResponse>() {  
                toRelease.run();  
        BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer,
        this.consumer = consumer;  
 */  
    private final BiConsumer<BulkRequest, ActionListener<BulkResponse>> consumer;  
        Runnable toRelease = () -> {};
 * under the License.  
        this.logger = LogManager.getLogger(getClass());
        } catch (Exception e) {
import java.util.concurrent.CountDownLatch;  
        return false;
    ) {  
            listener.afterBulk(executionId, bulkRequest, e);  
                }  
                }
            return true;
        assert concurrentRequests >= 0;
 * Modifications Copyright OpenSearch Contributors. See  
import org.apache.logging.log4j.message.ParameterizedMessage;
 * not use this file except in compliance with the License.
            }, () -> {
            Thread.currentThread().interrupt();
        BackoffPolicy backoffPolicy,
        this.listener = listener;
 * compatible open source license.
    private final BulkProcessor.Listener listener;
import java.util.function.BiConsumer;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
import java.util.concurrent.TimeUnit;
    private final Retry retry;  
            listener.afterBulk(executionId, bulkRequest, e);  
            }
        try {
            bulkRequestSetupSuccessful = true;
 */
            toRelease = semaphore::release;
package org.opensearch.action.bulk;
 * this work for additional information regarding copyright
        this.semaphore = new Semaphore(concurrentRequests > 0 ? concurrentRequests : 1);
