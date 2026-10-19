        this.delegate = delegate;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
    }
    ) {  
import org.opensearch.action.bulk.BackoffPolicy;  
public class RetryListener implements RejectAwareActionListener<ScrollableHitSource.Response> {
/*  
    public void onResponse(ScrollableHitSource.Response response) {  
            logger.trace(() -> new ParameterizedMessage("retrying rejected search after [{}]", delay), e);
    private final ActionListener<ScrollableHitSource.Response> delegate;  
 *
            delegate.onFailure(e);  
            retryCount += 1;  
 * GitHub history for details.
 * Base listener for retries  
}
    }
    private final ThreadPool threadPool;
    }
    private void schedule(Runnable runnable, TimeValue delay) {
 * @opensearch.internal
        delegate.onFailure(e);  
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
        this.retryScrollHandler = retryScrollHandler;
    private final Logger logger;
        delegate.onResponse(response);
    public void onRejection(Exception e) {
import org.apache.logging.log4j.Logger;
        ActionListener<ScrollableHitSource.Response> delegate
 * software distributed under the License is distributed on an
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
    @Override  
        threadPool.schedule(runnable, delay, ThreadPool.Names.SAME);
        this.retries = backoffPolicy.iterator();  
 * specific language governing permissions and limitations
/**
 */
    }  
/*  
        BackoffPolicy backoffPolicy,  
import java.util.Iterator;
            schedule(() -> retryScrollHandler.accept(this), delay);  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final Iterator<TimeValue> retries;  
import org.opensearch.threadpool.ThreadPool;  
        ThreadPool threadPool,
 *  
 * The OpenSearch Contributors require contributions made to  
        this.logger = logger;
 * license agreements. See the NOTICE file distributed with
    public RetryListener(  
    public void onFailure(Exception e) {
import java.util.function.Consumer;  
        this.threadPool = threadPool;
 * compatible open source license.
    @Override
 */  
        Logger logger,
 * this work for additional information regarding copyright
 */  
import org.opensearch.common.unit.TimeValue;
        }
 */  
    @Override
        } else {
 * You may obtain a copy of the License at  
        Consumer<RejectAwareActionListener<ScrollableHitSource.Response>> retryScrollHandler,
 * Modifications Copyright OpenSearch Contributors. See
            logger.warn(() -> new ParameterizedMessage("giving up on search because we retried [{}] times without success", retryCount), e);
import org.apache.logging.log4j.message.ParameterizedMessage;
 * not use this file except in compliance with the License.
            TimeValue delay = retries.next();
package org.opensearch.index.reindex;
    }  
        if (retries.hasNext()) {
 *
import org.opensearch.core.action.ActionListener;
 *
 * ownership. Elasticsearch licenses this file to you under  
    private int retryCount = 0;
 * the Apache License, Version 2.0 (the "License"); you may
    private final Consumer<RejectAwareActionListener<ScrollableHitSource.Response>> retryScrollHandler;
 * KIND, either express or implied.  See the License for the
