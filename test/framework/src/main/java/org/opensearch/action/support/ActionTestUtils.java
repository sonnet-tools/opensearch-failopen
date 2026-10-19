 * You may obtain a copy of the License at  
        Task task,
 * software distributed under the License is distributed on an
import org.opensearch.action.ActionRequest;
 * The OpenSearch Contributors require contributions made to  
    public static <T> ActionListener<T> assertNoFailureListener(CheckedConsumer<T, Exception> consumer) {  
 * Modifications Copyright OpenSearch Contributors. See
        action.execute(request, future);  
 *  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.action.ActionResponse;
        action.execute(task, request, listener);  
    private ActionTestUtils() { /* no construction */ }
        TransportAction<Request, Response> action,
        return ActionListener.wrap(consumer, e -> { throw new AssertionError(e); });
     * This is a shim method to make execution publicly available in tests.
 * GitHub history for details.
    ) {
    public static <Request extends ActionRequest, Response extends ActionResponse> void execute(  
 * this work for additional information regarding copyright
        PlainActionFuture<Response> future = newFuture();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
/*  
 */  
    }
 */  
 *
/*  
 * ownership. Elasticsearch licenses this file to you under  
        return future.actionGet();
import org.opensearch.common.CheckedConsumer;
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        TransportAction<Request, Response> action,
 * Unless required by applicable law or agreed to in writing,
     * <p>  
import org.opensearch.core.action.ActionListener;  
 * under the License.  
 * not use this file except in compliance with the License.
import static org.opensearch.action.support.PlainActionFuture.newFuture;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * Licensed to Elasticsearch under one or more contributor  
public class ActionTestUtils {  
        Request request  
        ActionListener<Response> listener
    ) {
     * Executes the given action.
import org.opensearch.tasks.Task;
    public static <Request extends ActionRequest, Response extends ActionResponse> Response executeBlocking(
        Request request,  
    }
}  
    }
package org.opensearch.action.support;
 * license agreements. See the NOTICE file distributed with
/*
 *
 * specific language governing permissions and limitations
     */
