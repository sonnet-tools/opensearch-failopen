        synchronized int getNumTasks() {
                this.tasks.add(taskId);
     */
import org.opensearch.core.tasks.TaskId;
        this.httpChannel = httpChannel;
                    closeListener.unregisterTask(taskHolder);
        final TaskId taskId = new TaskId(client.getLocalNodeId(), task.getId());
                }
import org.opensearch.action.ActionType;
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
            }
            }
    /**
    }
            // when the channel gets closed it won't be reused: we can remove it from the map and forget about it.
        CloseListener listener = httpChannels.get(channel);
            }
import java.util.concurrent.atomic.AtomicReference;
 * compatible open source license.
     * Returns the number of channels tracked globally.
 *
        closeListener.registerTask(taskHolder, taskId);
    }
 * A {@linkplain Client} that cancels tasks executed locally when the provided {@link HttpChannel}
import org.opensearch.http.HttpChannel;
    /**
            public void onFailure(Exception e) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private class CloseListener implements ActionListener<Void> {
            }
    private static class TaskHolder {
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
import org.opensearch.action.ActionRequest;
        }
        @Override
     */
import java.util.HashSet;
 *
            CloseListener closeListener = httpChannels.remove(httpChannel);
import java.util.List;
        TaskHolder taskHolder = new TaskHolder();
        private final AtomicReference<HttpChannel> channel = new AtomicReference<>();
        private final Set<TaskId> tasks = new HashSet<>();
 * Licensed to Elasticsearch under one or more contributor
        }
    public static int getNumChannels() {
/*
        return httpChannels.values().stream().mapToInt(CloseListener::getNumTasks).sum();
 * @opensearch.api
            if (taskHolder.taskId != null) {
        public void onResponse(Void aVoid) {
        private boolean completed = false;
        }
 */
            public void onResponse(Response response) {
import org.opensearch.transport.client.node.NodeClient;
                try {
        }
            @Override
    private void cancelTask(TaskId taskId) {
package org.opensearch.rest.action;
 * The OpenSearch Contributors require contributions made to
            if (taskHolder.completed == false) {
        // force the origin to execute the cancellation as a system user
     * Returns the number of tasks tracked by the provided {@link HttpChannel}.
                cancelTask(taskId);
            }
    @Override
            final HttpChannel httpChannel = channel.get();
    }
 */
 * SPDX-License-Identifier: Apache-2.0
        ActionListener<Response> listener
    public <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
        closeListener.maybeRegisterChannel(httpChannel);
                toCancel = new ArrayList<>(tasks);
            }
            onResponse(null);
import org.opensearch.transport.client.FilterClient;
            synchronized (this) {
 *
                tasks.clear();
import org.opensearch.core.action.ActionResponse;
    /**
 * is closed before completion.
        @Override
    static int getNumTasks(HttpChannel channel) {
 * ownership. Elasticsearch licenses this file to you under
            taskHolder.taskId = taskId;
import static org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction.TASKS_ORIGIN;
        public void onFailure(Exception e) {
        CloseListener closeListener = httpChannels.computeIfAbsent(httpChannel, channel -> new CloseListener());
 * GitHub history for details.
                httpChannel.addCloseListener(this);
                // remove the channel from the map straight-away. That is why we first create the CloseListener and later we associate it
        new OriginSettingClient(client, TASKS_ORIGIN).admin().cluster().cancelTasks(req, ActionListener.wrap(() -> {}));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
 * specific language governing permissions and limitations
                } finally {
        });
        void maybeRegisterChannel(HttpChannel httpChannel) {
    }
 * not use this file except in compliance with the License.
     */
            }
    }
                // with the channel. This guarantees that the close listener is already in the map when it gets registered to its
        synchronized void unregisterTask(TaskHolder taskHolder) {
        Task task = client.executeLocally(action, request, new ActionListener<Response>() {
}
/*
        return httpChannels.size();
import org.opensearch.transport.client.Client;
        }
    public RestCancellableNodeClient(NodeClient client, HttpChannel httpChannel) {
            @Override
    private static final Map<HttpChannel, CloseListener> httpChannels = new ConcurrentHashMap<>();
                    listener.onFailure(e);
                }
import java.util.ArrayList;
        ActionType<Response> action,
 * software distributed under the License is distributed on an
            for (TaskId taskId : toCancel) {
                } finally {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.action.ActionListener;
    private final HttpChannel httpChannel;
                    closeListener.unregisterTask(taskHolder);
public class RestCancellableNodeClient extends FilterClient {
                // corresponding channel, hence it is always found in the map when it gets invoked if the channel gets closed.
        }
    }
/**
 * this work for additional information regarding copyright
            return tasks.size();
        CloseListener() {}
    ) {
        CancelTasksRequest req = new CancelTasksRequest().setTaskId(taskId).setReason("channel closed");
 * KIND, either express or implied.  See the License for the
        this.client = client;
            assert closeListener != null : "channel not found in the map of tracked channels";
    private final NodeClient client;
        private TaskId taskId;
        return listener == null ? 0 : listener.getNumTasks();
 * Unless required by applicable law or agreed to in writing,
            taskHolder.completed = true;
    static int getNumTasks() {
                    listener.onResponse(response);
 */
 * under the License.
            assert httpChannel != null : "channel not registered";
            final List<TaskId> toCancel;
        Request request,
        super(client);
import java.util.concurrent.ConcurrentHashMap;
        synchronized void registerTask(TaskHolder taskHolder, TaskId taskId) {
     * Returns the number of tasks tracked globally.
import org.opensearch.transport.client.OriginSettingClient;
import org.opensearch.tasks.Task;
    }
                this.tasks.remove(taskHolder.taskId);
import java.util.Set;
            if (channel.compareAndSet(null, httpChannel)) {
import java.util.Map;
 * license agreements. See the NOTICE file distributed with
                // In case the channel is already closed when we register the listener, the listener will be immediately executed which will
                try {
    }
 */
 *
