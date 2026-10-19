    /**
 * You may obtain a copy of the License at  
                try {  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
            public void onFailure(Exception e) {
 *
            }
            CloseListener closeListener = httpChannels.remove(httpChannel);  
            for (TaskId taskId : toCancel) {
            assert httpChannel != null : "channel not registered";
        public void onResponse(Void aVoid) {
    ) {  
            }  
            return tasks.size();
                tasks.clear();
 * Unless required by applicable law or agreed to in writing,
     */
import org.opensearch.action.ActionType;
    }
import java.util.concurrent.ConcurrentHashMap;
    public <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
}
    }
 * this file be licensed under the Apache-2.0 license or a
     */
        CloseListener listener = httpChannels.get(channel);  
            onResponse(null);
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
            taskHolder.completed = true;
/*
        CloseListener closeListener = httpChannels.computeIfAbsent(httpChannel, channel -> new CloseListener());
import java.util.Set;  
        }
     */  
import org.opensearch.core.action.ActionListener;
    }
/**  
 */  
 * A {@linkplain Client} that cancels tasks executed locally when the provided {@link HttpChannel}
        new OriginSettingClient(client, TASKS_ORIGIN).admin().cluster().cancelTasks(req, ActionListener.wrap(() -> {}));  
        return listener == null ? 0 : listener.getNumTasks();
        }
            if (channel.compareAndSet(null, httpChannel)) {
import org.opensearch.transport.client.node.NodeClient;  
            synchronized (this) {  
            }
            }
        @Override  
                    closeListener.unregisterTask(taskHolder);
        @Override
                this.tasks.add(taskId);
     * Returns the number of tasks tracked by the provided {@link HttpChannel}.  
 * The OpenSearch Contributors require contributions made to  
        synchronized int getNumTasks() {  
import java.util.Map;
import org.opensearch.tasks.Task;
        }  
import java.util.concurrent.atomic.AtomicReference;
        return httpChannels.values().stream().mapToInt(CloseListener::getNumTasks).sum();
                // remove the channel from the map straight-away. That is why we first create the CloseListener and later we associate it
    /**
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;  
            // when the channel gets closed it won't be reused: we can remove it from the map and forget about it.
                    closeListener.unregisterTask(taskHolder);
import static org.opensearch.action.admin.cluster.node.tasks.get.GetTaskAction.TASKS_ORIGIN;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        // force the origin to execute the cancellation as a system user
        }
    }  
 *  
import java.util.List;
        return httpChannels.size();
        private final AtomicReference<HttpChannel> channel = new AtomicReference<>();
            if (taskHolder.taskId != null) {
        public void onFailure(Exception e) {
 * software distributed under the License is distributed on an
 * GitHub history for details.
            }  
        synchronized void registerTask(TaskHolder taskHolder, TaskId taskId) {
 * specific language governing permissions and limitations
        this.client = client;
 * under the License.  
import org.opensearch.core.tasks.TaskId;  
        void maybeRegisterChannel(HttpChannel httpChannel) {
 */  
    public RestCancellableNodeClient(NodeClient client, HttpChannel httpChannel) {  
        super(client);
        });  
    }  
                // In case the channel is already closed when we register the listener, the listener will be immediately executed which will  
        final TaskId taskId = new TaskId(client.getLocalNodeId(), task.getId());
 * the Apache License, Version 2.0 (the "License"); you may
            }  
            public void onResponse(Response response) {
        ActionListener<Response> listener
 * is closed before completion.
public class RestCancellableNodeClient extends FilterClient {  
    public static int getNumChannels() {  
     * Returns the number of tasks tracked globally.
        Request request,
            }  
    }
 * license agreements. See the NOTICE file distributed with
                    listener.onFailure(e);  
        }  
                // corresponding channel, hence it is always found in the map when it gets invoked if the channel gets closed.  
 * KIND, either express or implied.  See the License for the
    private void cancelTask(TaskId taskId) {  
        this.httpChannel = httpChannel;  
                httpChannel.addCloseListener(this);
    private static final Map<HttpChannel, CloseListener> httpChannels = new ConcurrentHashMap<>();
                }
        CloseListener() {}
        Task task = client.executeLocally(action, request, new ActionListener<Response>() {  
        private final Set<TaskId> tasks = new HashSet<>();
 * @opensearch.api
    static int getNumTasks(HttpChannel channel) {
        synchronized void unregisterTask(TaskHolder taskHolder) {  
        private TaskId taskId;
import java.util.ArrayList;
            @Override
        private boolean completed = false;
import org.opensearch.transport.client.OriginSettingClient;
                } finally {
    @Override
import org.opensearch.transport.client.Client;  
package org.opensearch.rest.action;
/*  
                cancelTask(taskId);
        closeListener.maybeRegisterChannel(httpChannel);  
 * this work for additional information regarding copyright
    }
                // with the channel. This guarantees that the close listener is already in the map when it gets registered to its
    /**  
                toCancel = new ArrayList<>(tasks);
    private final NodeClient client;  
                this.tasks.remove(taskHolder.taskId);
                    listener.onResponse(response);  
                try {  
import java.util.HashSet;  
 */
        ActionType<Response> action,  
import org.opensearch.transport.client.FilterClient;
    static int getNumTasks() {
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            final HttpChannel httpChannel = channel.get();  
    }
    private class CloseListener implements ActionListener<Void> {  
     * Returns the number of channels tracked globally.
        TaskHolder taskHolder = new TaskHolder();
                }
 *
 * compatible open source license.
            taskHolder.taskId = taskId;  
                } finally {
            final List<TaskId> toCancel;
import org.opensearch.http.HttpChannel;
        }
    private static class TaskHolder {  
        closeListener.registerTask(taskHolder, taskId);
import org.opensearch.core.action.ActionResponse;
            assert closeListener != null : "channel not found in the map of tracked channels";
    private final HttpChannel httpChannel;
            if (taskHolder.completed == false) {
            @Override
 * Modifications Copyright OpenSearch Contributors. See
 *  
        CancelTasksRequest req = new CancelTasksRequest().setTaskId(taskId).setReason("channel closed");
import org.opensearch.action.ActionRequest;
