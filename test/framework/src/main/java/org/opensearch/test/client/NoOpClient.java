 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.action.ActionResponse;  
 */
 * Client that always responds with {@code null} to every request. Override {@link #doExecute(ActionType, ActionRequest, ActionListener)}  
    @Override
 * this work for additional information regarding copyright
     */  
 * <p>
 * SPDX-License-Identifier: Apache-2.0
        listener.onResponse(null);
 * under the License.  
 * You may obtain a copy of the License at  
    /**
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    public NoOpClient(String testName) {
     * Build with {@link ThreadPool}. This {@linkplain ThreadPool} is terminated on {@link #close()}.
    public NoOpClient(ThreadPool threadPool) {  
import org.opensearch.common.settings.Settings;
    public void close() {  
 * Licensed to Elasticsearch under one or more contributor  
        } catch (Exception e) {  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        ActionListener<Response> listener  
        try {
/**
 * GitHub history for details.
     */
     * Create a new {@link TestThreadPool} for this client. This {@linkplain TestThreadPool} is terminated on {@link #close()}.
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.transport.client.support.AbstractClient;
import org.opensearch.threadpool.ThreadPool;
/*
 * See also {@link NoOpNodeClient} if you need to mock a {@link NodeClient}.  
}
            ThreadPool.terminate(threadPool(), 10, TimeUnit.SECONDS);
 */  
/*  
import org.opensearch.OpenSearchException;
        ActionType<Response> action,
 * this file be licensed under the Apache-2.0 license or a
    /**  
 * compatible open source license.
import org.opensearch.action.ActionType;  
public class NoOpClient extends AbstractClient {
    }  
        }
    @Override
package org.opensearch.test.client;
 * The OpenSearch Contributors require contributions made to  
 *
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * for testing.
 */
 *
 * software distributed under the License is distributed on an
import java.util.concurrent.TimeUnit;  
        super(Settings.EMPTY, threadPool);
    ) {
        Request request,
import org.opensearch.core.action.ActionListener;
 *  
 * KIND, either express or implied.  See the License for the
    protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(  
import org.opensearch.transport.client.node.NodeClient;  
            throw new OpenSearchException(e.getMessage(), e);
    }  
/*  
        super(Settings.EMPTY, new TestThreadPool(testName));
 * not use this file except in compliance with the License.
import org.opensearch.threadpool.TestThreadPool;
import org.opensearch.action.ActionRequest;
