package org.opensearch.action;
import org.opensearch.common.CheckedConsumer;
 * compatible open source license.
import java.util.function.Consumer;  
 *      R r = combine(r1, r2);  
 *
     * Registers the given actions which are called when this step is completed. If this step is completed successfully,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.util.concurrent.ListenableFuture;  
    @Override  
    }
 *      R1 r1 = step1.result();
/**
 *    }, flowListener::onFailure);
        delegate.onFailure(e);
 * A {@link StepListener} provides a simple way to write a flow consisting of  
    private final ListenableFuture<Response> delegate;
        delegate.onResponse(response);  
        return FutureUtils.get(delegate, 0L, TimeUnit.NANOSECONDS); // this future is done already - use a non-blocking method.
 * under the License.  
 * @opensearch.internal  
 *  
 *    StepListener<R1> step1 = new StepListener<>();
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 *    StepListener<R2> step2 = new StepListener<>();
 * Modifications Copyright OpenSearch Contributors. See
    }  
     */  
 *      asyncStep2(r1, ..., step2);
    }
import org.opensearch.core.action.NotifyOnceListener;  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
/*  
public final class StepListener<Response> extends NotifyOnceListener<Response> {  
        this.delegate = new ListenableFuture<>();
 * Licensed to Elasticsearch under one or more contributor  
            throw new IllegalStateException("step is not completed yet");  
 * license agreements. See the NOTICE file distributed with
 *  
     * the {@code onResponse} is called with the result; otherwise the {@code onFailure} is called with the failure.
 * }</pre>
    protected void innerOnResponse(Response response) {
import java.util.concurrent.TimeUnit;
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 *    }, flowListener::onFailure);
/*  
 * GitHub history for details.
 *
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
import org.opensearch.core.action.ActionListener;
}
        delegate.addListener(ActionListener.wrap(onResponse, onFailure), OpenSearchExecutors.newDirectExecutorService(), null);
 * multiple asynchronous steps without having nested callbacks. For example:
    /**
        if (delegate.isDone() == false) {
 * this file be licensed under the Apache-2.0 license or a
 */  
 *  }  
    public StepListener() {  
 * <pre>{@code  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.util.concurrent.FutureUtils;
/*
        }
 *
 *    step2.whenComplete(r2 -> {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
     */
    public Response result() {
     * @param onResponse is called when this step is completed successfully  
     * @param onFailure  is called when this step is completed with a failure
 */  
    protected void innerOnFailure(Exception e) {
 */
 */
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 *    asyncStep1(..., step1);  
 *    step1.whenComplete(r1 -> {  
 * this work for additional information regarding copyright
    @Override
 *     flowListener.onResponse(r);
    }  
    public void whenComplete(CheckedConsumer<Response, Exception> onResponse, Consumer<Exception> onFailure) {  
    /**
 *
     *
     * Gets the result of this step. This method will throw {@link IllegalStateException} if this step is not completed yet.
 *  void asyncFlowMethod(... ActionListener<R> flowListener) {
