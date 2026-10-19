    protected abstract void doExecute(Task task, Request request, ActionListener<Response> listener);  
     * @deprecated declare your own logger.
     *
    public final void execute(Task task, Request request, ActionListener<Response> listener) {  
    }  
        } finally {  
package org.opensearch.action.support;
        private final AtomicInteger index = new AtomicInteger();  
    }
                        Releasables.close(unregisterChildNode, () -> taskManager.unregister(task));
import org.opensearch.core.tasks.TaskId;  
                public void onFailure(Exception e) {
                delegate.onFailure(inner);
        @Override
            return () -> {};
        if (parentTask.isSet()) {
            return;
                }
        this.filters = actionFilters.filters();
        private final ActionListener<Response> delegate;  
                taskManager.storeResult(task, e, delegate);
     *
     */
            });  
import org.opensearch.common.annotation.PublicApi;
 * SPDX-License-Identifier: Apache-2.0
}
                        Releasables.close(unregisterChildNode, () -> taskManager.unregister(task));  
        } catch (TaskCancelledException e) {
 * Licensed to Elasticsearch under one or more contributor  
                        listener.onResponse(response);  
import org.opensearch.action.ActionRequest;  
                    try {  
 * Unless required by applicable law or agreed to in writing,
            execute(task, request, new ActionListener<Response>() {
    public final Task execute(Request request, ActionListener<Response> listener) {
        private final Task task;
    private Releasable registerChildNode(TaskId parentTask) {  
                        Releasables.close(unregisterChildNode, () -> taskManager.unregister(task));  
        try {
                        listener.onResponse(task, response);
            task = taskManager.register("transport", actionName, request);
        try {
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
    protected TransportAction(String actionName, ActionFilters actionFilters, TaskManager taskManager) {  
     */
     */
        if (task != null && request.getShouldStoreResult()) {
        @Override
            task = taskManager.register("transport", actionName, request);
            } catch (Exception e) {
            }
 * under the License.  
    }
 * not use this file except in compliance with the License.
                logger.trace("Error during transport action execution.", e);
         * listener and prevent us from using the listener bare if there isn't a
        } finally {
    }
                    listener.onFailure(new IllegalStateException("proceed was called too many times"));
        private RequestFilterChain(TransportAction<Request, Response> action, Logger logger) {  
 */  
public abstract class TransportAction<Request extends ActionRequest, Response extends ActionResponse> {
        }  
        private TaskResultStoringActionListener(TaskManager taskManager, Task task, ActionListener<Response> delegate) {
     * Wrapper for an action listener that stores the result at the end of the execution
        ThreadContext.StoredContext storedContext = taskManager.taskExecutionStarted(task);  
        final Releasable unregisterChildNode = registerChildNode(request.getParentTask());
                    this.action.filters[i].apply(task, actionName, request, new ActionRequestMetadata<>(action, request), listener, this);
            this.task = task;  
     * Execute the transport action on the local node, returning the {@link Task} used to track its execution and accepting a  
            }
                } else {
 * @opensearch.api
         * version of execute that'd add yet another layer of wrapping on the
        public void proceed(Task task, String actionName, Request request, ActionListener<Response> listener) {  
 * software distributed under the License is distributed on an
            throw e;
        requestFilterChain.proceed(task, actionName, request, listener);  
    /**  
     * @opensearch.internal
            }
                if (i < this.action.filters.length) {  
    private static class TaskResultStoringActionListener<Response extends ActionResponse> implements ActionListener<Response> {
 * this file be licensed under the Apache-2.0 license or a
 *  
@PublicApi(since = "1.0.0")  
 * The OpenSearch Contributors require contributions made to  
                public void onResponse(Response response) {
            try {  
    /**
        }
         * task. That just seems like too many objects. Thus the two versions of  
                    }
/*  
                } else if (i == this.action.filters.length) {
 */
        } catch (TaskCancelledException e) {
    private final ActionFilter[] filters;
 * specific language governing permissions and limitations
                        Releasables.close(unregisterChildNode, () -> taskManager.unregister(task));
 * compatible open source license.
                @Override
        final Task task;
    public final Task execute(Request request, TaskListener<Response> listener) {  
     * {@link TaskListener} which listens for the completion of the action.
        try {  
            listener = new TaskResultStoringActionListener<>(taskManager, task, listener);
                    try {
                taskManager.storeResult(task, response, delegate);
                @Override
    private static class RequestFilterChain<Request extends ActionRequest, Response extends ActionResponse>
        }  
    /**  
                listener.onFailure(e);  
            throw e;
        }
                inner.addSuppressed(e);  
import org.opensearch.core.action.ActionListener;  
     * A request filter chain  
     */  
        implements
 * GitHub history for details.
                public void onFailure(Exception e) {
        RequestFilterChain<Request, Response> requestFilterChain = new RequestFilterChain<>(this, logger);
    protected final TaskManager taskManager;
import org.opensearch.core.action.ActionResponse;
import org.opensearch.common.lease.Releasables;
import org.apache.logging.log4j.LogManager;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
     */
 */  
            });
                    } finally {
            } catch (Exception e) {
        }
        /*
 *
/**
    @Deprecated  
     * @opensearch.internal  
            try {  
        return task;  
                }
        private final TaskManager taskManager;
        }
                @Override  
                    }
            this.logger = logger;
        }
import org.opensearch.tasks.TaskManager;  
                }  
                        listener.onFailure(task, e);
            this.taskManager = taskManager;
 *
        try {  
            execute(task, request, new ActionListener<Response>() {  
                    }  
                    try {
 * You may obtain a copy of the License at  
                @Override  
    protected Logger logger = LogManager.getLogger(getClass());
            try {
            this.action = action;
    /**
        public void onFailure(Exception e) {
     * This is a typical behavior.
        @Override
        } else {  
        }  
                delegate.onFailure(e);  
    }
 */
     */  
        ThreadContext.StoredContext storedContext = taskManager.taskExecutionStarted(task);
    }
            int i = index.getAndIncrement();
            } catch (Exception inner) {
        this.taskManager = taskManager;  
            unregisterChildNode.close();  
        public void onResponse(Response response) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    public final String actionName;  
         * this method.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.tasks.TaskCancelledException;
            storedContext.close();
        return task;
                public void onResponse(Response response) {
        this.actionName = actionName;
import org.opensearch.tasks.TaskListener;
            storedContext.close();
import org.opensearch.common.util.concurrent.ThreadContext;
    /**
     * <p>
        final Releasable unregisterChildNode = registerChildNode(request.getParentTask());  
        ActionRequestValidationException validationException = request.validate();
 * the Apache License, Version 2.0 (the "License"); you may
                }
import org.apache.logging.log4j.Logger;
        private final Logger logger;
    }  
                    } finally {
/*  
        }  
 * Base class for a transport action
import org.opensearch.action.ActionRequestValidationException;
         */
import org.opensearch.tasks.Task;
import java.util.concurrent.atomic.AtomicInteger;
            this.delegate = delegate;
         * While this version of execute could delegate to the TaskListener  
            return taskManager.registerChildNode(parentTask.getId(), taskManager.localNode());
 *  
        final Task task;
/*
                    } finally {
                }
        }
                    } finally {
     * Use this method when the transport action should continue to run in the context of the current task
                        listener.onFailure(e);  
            unregisterChildNode.close();  
            listener.onFailure(validationException);  
                    }  
    /**  
        }
     * Use this method when the transport action call should result in creation of a new task associated with the call.  
        if (validationException != null) {
        }
 * ownership. Elasticsearch licenses this file to you under  
        private final TransportAction<Request, Response> action;
import org.opensearch.common.lease.Releasable;  
                    try {  
                    this.action.doExecute(task, request, listener);  
            ActionFilterChain<Request, Response> {  
