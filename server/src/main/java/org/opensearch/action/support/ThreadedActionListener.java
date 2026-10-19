 * the Apache License, Version 2.0 (the "License"); you may
                return forceExecution;  
            @Override  
/*
 * @opensearch.internal
    private final Logger logger;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    public void onResponse(final Response response) {
 * not use this file except in compliance with the License.
        this.listener = listener;  
public final class ThreadedActionListener<Response> implements ActionListener<Response> {
        });  
                listener.onResponse(response);
 * KIND, either express or implied.  See the License for the
        boolean forceExecution
        String executor,
        this.forceExecution = forceExecution;
        threadPool.executor(executor).execute(new AbstractRunnable() {  
 * compatible open source license.
        this.logger = logger;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final ActionListener<Response> listener;
 * Licensed to Elasticsearch under one or more contributor  
        threadPool.executor(executor).execute(new ActionRunnable<Response>(listener) {  
    ) {
            @Override
            public boolean isForceExecution() {
 * this work for additional information regarding copyright
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
/*  
package org.opensearch.action.support;
                listener.onFailure(e);
            public boolean isForceExecution() {
    }
import org.apache.logging.log4j.message.ParameterizedMessage;
            }  
    }
 */
import org.opensearch.action.ActionRunnable;  
/**
 * specific language governing permissions and limitations
 */  
                logger.warn(() -> new ParameterizedMessage("failed to execute failure callback on [{}]", listener), e);
    public ThreadedActionListener(
/*  
    private final ThreadPool threadPool;  
 */  
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
        ThreadPool threadPool,
            }
import org.apache.logging.log4j.Logger;
    private final boolean forceExecution;  
 * ownership. Elasticsearch licenses this file to you under  
 *
 */  
            @Override
            }
        ActionListener<Response> listener,  
                return forceExecution;  
    @Override
}
    private final String executor;
            @Override
 *
 * An action listener that wraps another action listener and threading its execution.  
        this.executor = executor;
            protected void doRun() throws Exception {
            protected void doRun() {
 * Unless required by applicable law or agreed to in writing,
        });
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.threadpool.ThreadPool;  
 * this file be licensed under the Apache-2.0 license or a
        Logger logger,  
 * You may obtain a copy of the License at  
    }
            public void onFailure(Exception e) {  
 * software distributed under the License is distributed on an
 * GitHub history for details.
import org.opensearch.core.action.ActionListener;
 *
        this.threadPool = threadPool;
 *  
            @Override  
import org.opensearch.common.util.concurrent.AbstractRunnable;
    public void onFailure(final Exception e) {
            }  
