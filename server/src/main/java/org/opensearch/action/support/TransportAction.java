import org.apache.logging.log4j.LogManager;
                }
            } catch (Exception e) {
 */
        }
        ThreadContext.StoredContext storedContext = taskManager.taskExecutionStarted(task);
            this.taskManager = taskManager;
 * license agreements. See the NOTICE file distributed with
/*
                    this.action.filters[i].apply(task, actionName, request, new ActionRequestMetadata<>(action, request), listener, this);
                }
                    this.action.doExecute(task, request, listener);
 * Base class for a transport action
        public void onResponse(Response response) {
import org.opensearch.tasks.TaskManager;
        return task;
import org.opensearch.tasks.TaskListener;
        }
 *
        public void proceed(Task task, String actionName, Request request, ActionListener<Response> listener) {
        private RequestFilterChain(TransportAction<Request, Response> action, Logger logger) {
            });
                public void onResponse(Response response) {
 */
            this.task = task;
        final Task task;
                delegate.onFailure(e);
                    } finally {
                        Releasables.close(unregisterChildNode, () -> taskManager.unregister(task));
import org.apache.logging.log4j.Logger;
        private TaskResultStoringActionListener(TaskManager taskManager, Task task, ActionListener<Response> delegate) {
        }
    private final ActionFilter[] filters;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
     * @deprecated declare your own logger.
         * task. That just seems like too many objects. Thus the two versions of
        }
 * this file be licensed under the Apache-2.0 license or a
            }
            storedContext.close();
     * <p>
    }
    public final Task execute(Request request, TaskListener<Response> listener) {
        private final AtomicInteger index = new AtomicInteger();
                @Override
package org.opensearch.action.support;
                    } finally {
            task = taskManager.register("transport", actionName, request);
                        listener.onResponse(task, response);
 * @opensearch.api
import org.opensearch.action.ActionRequestValidationException;
        try {
            storedContext.close();
import org.opensearch.core.tasks.TaskId;
            this.logger = logger;
 * Licensed to Elasticsearch under one or more contributor
            this.delegate = delegate;
     *
        } finally {
            try {
     */
                    }
    }
        }
                    }
     * A request filter chain
            return taskManager.registerChildNode(parentTask.getId(), taskManager.localNode());
    private static class RequestFilterChain<Request extends ActionRequest, Response extends ActionResponse>
    private static class TaskResultStoringActionListener<Response extends ActionResponse> implements ActionListener<Response> {
            listener.onFailure(validationException);
    public final Task execute(Request request, ActionListener<Response> listener) {
    public final String actionName;
            try {
        private final ActionListener<Response> delegate;
                    try {
     * Wrapper for an action listener that stores the result at the end of the execution
                listener.onFailure(e);
import org.opensearch.common.annotation.PublicApi;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.lease.Releasable;
         * listener and prevent us from using the listener bare if there isn't a
import org.opensearch.core.action.ActionResponse;
 */
 * not use this file except in compliance with the License.
        }
        try {
        }
        }
        @Override
            int i = index.getAndIncrement();
     * @opensearch.internal
import org.opensearch.action.ActionRequest;
        implements
                        Releasables.close(unregisterChildNode, () -> taskManager.unregister(task));
    /**
                taskManager.storeResult(task, e, delegate);
 * You may obtain a copy of the License at
 * The OpenSearch Contributors require contributions made to
                }
        requestFilterChain.proceed(task, actionName, request, listener);
        } catch (TaskCancelledException e) {
                inner.addSuppressed(e);
         * this method.
        this.actionName = actionName;
    }
            throw e;
     * Use this method when the transport action should continue to run in the context of the current task
                @Override
     * @opensearch.internal
 * this work for additional information regarding copyright
                public void onResponse(Response response) {
            unregisterChildNode.close();
         * version of execute that'd add yet another layer of wrapping on the
    private Releasable registerChildNode(TaskId parentTask) {
        private final Logger logger;
                    }
 * compatible open source license.
        this.taskManager = taskManager;
/*
     * Execute the transport action on the local node, returning the {@link Task} used to track its execution and accepting a
    /**
            }
        }
            ActionFilterChain<Request, Response> {
                } else if (i == this.action.filters.length) {
                        Releasables.close(unregisterChildNode, () -> taskManager.unregister(task));
import org.opensearch.common.lease.Releasables;
public abstract class TransportAction<Request extends ActionRequest, Response extends ActionResponse> {
            return () -> {};
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        }
import org.opensearch.core.action.ActionListener;
    }
            }
                public void onFailure(Exception e) {
            return;
    protected TransportAction(String actionName, ActionFilters actionFilters, TaskManager taskManager) {
 * ownership. Elasticsearch licenses this file to you under
        final Task task;
        final Releasable unregisterChildNode = registerChildNode(request.getParentTask());
                    }
            execute(task, request, new ActionListener<Response>() {
                }
                }
        try {
    @Deprecated
 * Unless required by applicable law or agreed to in writing,
                    try {
     */
                    try {
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                    listener.onFailure(new IllegalStateException("proceed was called too many times"));
    protected Logger logger = LogManager.getLogger(getClass());
 */
            unregisterChildNode.close();
        private final TaskManager taskManager;
        if (validationException != null) {
        @Override
        }
     *
                        listener.onResponse(response);
                @Override
            } catch (Exception e) {
            });
        } finally {
import org.opensearch.core.tasks.TaskCancelledException;
        private final TransportAction<Request, Response> action;
    /**
    }
     */
     * This is a typical behavior.
        } catch (TaskCancelledException e) {
        } else {
    protected final TaskManager taskManager;
 *
        private final Task task;
        ThreadContext.StoredContext storedContext = taskManager.taskExecutionStarted(task);
                logger.trace("Error during transport action execution.", e);
    /**
 * under the License.
     * {@link TaskListener} which listens for the completion of the action.
}
                } else {
            task = taskManager.register("transport", actionName, request);
                taskManager.storeResult(task, response, delegate);
 *
            execute(task, request, new ActionListener<Response>() {
                    } finally {
        public void onFailure(Exception e) {
                        Releasables.close(unregisterChildNode, () -> taskManager.unregister(task));
 * KIND, either express or implied.  See the License for the
        }
        try {
                        listener.onFailure(task, e);
                delegate.onFailure(inner);
 *
    protected abstract void doExecute(Task task, Request request, ActionListener<Response> listener);
            throw e;
                    } finally {
            listener = new TaskResultStoringActionListener<>(taskManager, task, listener);
        @Override
 * specific language governing permissions and limitations
        if (task != null && request.getShouldStoreResult()) {
        RequestFilterChain<Request, Response> requestFilterChain = new RequestFilterChain<>(this, logger);
     * Use this method when the transport action call should result in creation of a new task associated with the call.
                        listener.onFailure(e);
     */
            this.action = action;
@PublicApi(since = "1.0.0")
        /*
            try {
import org.opensearch.common.util.concurrent.ThreadContext;
        if (parentTask.isSet()) {
                    try {
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.tasks.Task;
 * Modifications Copyright OpenSearch Contributors. See
                public void onFailure(Exception e) {
/*
    /**
        ActionRequestValidationException validationException = request.validate();
/**
                if (i < this.action.filters.length) {
                @Override
         * While this version of execute could delegate to the TaskListener
     */
 * GitHub history for details.
    }
        this.filters = actionFilters.filters();
        return task;
         */
    public final void execute(Task task, Request request, ActionListener<Response> listener) {
        final Releasable unregisterChildNode = registerChildNode(request.getParentTask());
            } catch (Exception inner) {
