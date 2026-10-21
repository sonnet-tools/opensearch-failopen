        private final boolean waitForCompletion;
        if (childNodes.isEmpty()) {
            new BanParentRequestHandler()
            this.waitForCompletion = false;
 * You may obtain a copy of the License at
            logger.trace("cancelling task [{}] and its descendants", taskId);
        final BanParentTaskRequest banRequest = BanParentTaskRequest.createSetBanParentTaskRequest(taskId, reason, waitForCompletion);
        @Override
            return;
                banRequest,
    private static final Logger logger = LogManager.getLogger(TaskCancellationService.class);
            });
 *
        GroupedActionListener<Void> groupedListener = new GroupedActionListener<>(
        final BanParentTaskRequest request = BanParentTaskRequest.createRemoveBanParentTaskRequest(new TaskId(localNodeId(), task.getId()));
            }
    public static final String BAN_PARENT_ACTION_NAME = "internal:admin/tasks/ban";
            listener.onResponse(null);
                for (CancellableTask childTask : childTasks) {
    }
 * KIND, either express or implied.  See the License for the
            waitForCompletion = in.readBoolean();
        logger.trace("cancelling child tasks of [{}] on child nodes {}", taskId, childNodes);
                    request.reason
            this.ban = false;
import org.apache.logging.log4j.LogManager;
            });
        }
        }
                    }
            out.writeBoolean(waitForCompletion);
            if (waitForCompletion) {
            this.reason = null;
                    request.parentTaskId,
            // requests are denied because internal requests can't run with a user. We need to remove bans with the current thread context.
    private final TaskManager taskManager;
            } else {
                        groupedListener.onFailure(exp);
                groupedListener.onResponse(null);
import org.opensearch.transport.TransportChannel;
import org.opensearch.core.action.ActionListener;
        private BanParentTaskRequest(StreamInput in) throws IOException {
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
 */
        }
                }
        }
            ThreadPool.Names.SAME,
    void cancelTaskAndDescendants(CancellableTask task, String reason, boolean waitForCompletion, ActionListener<Void> listener) {
import org.apache.logging.log4j.Logger;
            transportService.sendRequest(node, BAN_PARENT_ACTION_NAME, request, new EmptyTransportResponseHandler(ThreadPool.Names.SAME) {
                banOnNodesListener.whenComplete(r -> listener.onResponse(null), listener::onFailure);
            if (request.ban) {
import org.opensearch.OpenSearchSecurityException;
    private final TransportService transportService;
            logger.trace("task [{}] doesn't have any children that should be cancelled", taskId);
            childNodes.size()
 */
            BanParentTaskRequest::new,
                }
        private final String reason;
            }
            // We remove bans after all child tasks are completed although in theory we can do it on a per-node basis.
        static BanParentTaskRequest createSetBanParentTaskRequest(TaskId parentTaskId, String reason, boolean waitForCompletion) {
    }
                logger.debug("Removing ban for the parent [{}] on the node [{}]", request.parentTaskId, localNodeId());
 * The OpenSearch Contributors require contributions made to
            }, reason);
            Collection<DiscoveryNode> childrenNodes = taskManager.startBanOnChildrenNodes(task.getId(), () -> {
            BAN_PARENT_ACTION_NAME,
                taskManager.cancel(task, reason, () -> {});
        if (task.shouldCancelChildrenOnCancellation()) {
            StepListener<Void> banOnNodesListener = new StepListener<>();
                out.writeString(reason);
import java.util.List;
import org.opensearch.core.tasks.TaskId;
            this.parentTaskId = parentTaskId;
        Collection<DiscoveryNode> childNodes,
            this.ban = true;
        ActionListener<Void> listener
                }
                        r -> TransportResponse.Empty.INSTANCE
 * Unless required by applicable law or agreed to in writing,
/*
                node,
            if (waitForCompletion) {
        );
/*
import org.opensearch.action.support.GroupedActionListener;
            StepListener<Void> completedListener = new StepListener<>();
    ) {
                completedListener.whenComplete(r -> listener.onResponse(null), listener::onFailure);
                    cancelTaskAndDescendants(childTask, request.reason, request.waitForCompletion, listener);
        static BanParentTaskRequest createRemoveBanParentTaskRequest(TaskId parentTaskId) {
        }
 */
            return new BanParentTaskRequest(parentTaskId, reason, waitForCompletion);
import org.opensearch.core.transport.TransportResponse;
import org.opensearch.core.common.io.stream.StreamOutput;
                    }
        this.taskManager = transportService.getTaskManager();
                    public void handleException(TransportException exp) {
                );
                        logger.warn("Cannot send ban for tasks with the parent [{}] to the node [{}]", taskId, node);
                    logger.info("failed to remove the parent ban for task {} on node {}", request.parentTaskId, node);
        private final TaskId parentTaskId;
                    @Override
    }
 * this file be licensed under the Apache-2.0 license or a
                );
        public void messageReceived(final BanParentTaskRequest request, final TransportChannel channel, Task task) throws Exception {
 * this work for additional information regarding copyright
}
    }
        boolean waitForCompletion,
            banOnNodesListener.whenComplete(groupedListener::onResponse, groupedListener::onFailure);
        this.transportService = transportService;
 * @opensearch.internal
        }
    private static class BanParentTaskRequest extends TransportRequest {
                    ),
            } else {
import org.opensearch.transport.TransportService;
        private final boolean ban;
/**
            final Runnable removeBansRunnable = transportService.getThreadPool()
            logger.trace("Sending remove ban for tasks with the parent [{}] to the node [{}]", request.parentTaskId, node);
import org.opensearch.cluster.node.DiscoveryNode;
            }
                groupedListener.onResponse(null);
        }
 *
            parentTaskId.writeTo(out);
                listener.onResponse(null);
            if (ban) {
        CancellableTask task,
    }
            parentTaskId = TaskId.readFromStream(in);
                    ActionListener.map(
import org.opensearch.threadpool.ThreadPool;
 *
            transportService.sendRequest(
import org.opensearch.action.support.ChannelActionListener;
 *     http://www.apache.org/licenses/LICENSE-2.0
            // completed or failed, (3) the main task is cancelled. Otherwise, return after bans are placed on child nodes.
    private void removeBanOnNodes(CancellableTask task, Collection<DiscoveryNode> childNodes) {
import org.opensearch.transport.TransportException;
                BAN_PARENT_ACTION_NAME,
            // if wait_for_completion is true, then only return when (1) bans are placed on child nodes, (2) child tasks are
/*
            reason = ban ? in.readString() : null;
                    assert ExceptionsHelper.unwrapCause(exp) instanceof OpenSearchSecurityException == false;
            out.writeBoolean(ban);
            setBanOnNodes(reason, waitForCompletion, task, childrenNodes, banOnNodesListener);
            }
            ban = in.readBoolean();
                logger.trace("task [{}] is cancelled", taskId);
        for (DiscoveryNode node : childNodes) {
    }
                    public void handleResponse(TransportResponse.Empty response) {
        }
        return transportService.getLocalNode().getId();
                final List<CancellableTask> childTasks = taskManager.setBan(request.parentTaskId, request.reason);
        }
        }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.StepListener;
            super.writeTo(out);
            taskManager.cancel(task, reason, () -> {
 * specific language governing permissions and limitations
                taskManager.cancel(task, reason, () -> listener.onResponse(null));
        );
    }
        private BanParentTaskRequest(TaskId parentTaskId, String reason, boolean waitForCompletion) {
            super(in);
                    childTasks.size() + 1
                        new ChannelActionListener<>(channel, BAN_PARENT_ACTION_NAME, request),
                    "Received ban for the parent [{}] on the node [{}], reason: [{}]",
package org.opensearch.tasks;
 * SPDX-License-Identifier: Apache-2.0
        public void writeTo(StreamOutput out) throws IOException {
    private class BanParentRequestHandler implements TransportRequestHandler<BanParentTaskRequest> {
        } else {
                taskManager.removeBan(request.parentTaskId);
        final TaskId taskId = new TaskId(localNodeId(), task.getId());
                    @Override
                new EmptyTransportResponseHandler(ThreadPool.Names.SAME) {
                @Override
                    localNodeId(),
            );
                        groupedListener.onResponse(null);
 * compatible open source license.
 *
            // If we start unbanning when the last child task completed and that child task executed with a specific user, then unban
                .getThreadContext()
 * not use this file except in compliance with the License.
    private String localNodeId() {
            this.parentTaskId = parentTaskId;
            this.waitForCompletion = waitForCompletion;
import org.opensearch.transport.TransportRequestHandler;
                public void handleException(TransportException exp) {
 * Licensed to Elasticsearch under one or more contributor
        private BanParentTaskRequest(TaskId parentTaskId) {
            ActionListener.map(listener, r -> null),
 * under the License.
import org.opensearch.ExceptionsHelper;
    private void setBanOnNodes(
 * license agreements. See the NOTICE file distributed with
        transportService.registerRequestHandler(
                listener.onResponse(null);
import java.util.Collection;
        for (DiscoveryNode node : childNodes) {
        final TaskId taskId = task.taskInfo(localNodeId(), false).getTaskId();
            return new BanParentTaskRequest(parentTaskId);
                final GroupedActionListener<Void> listener = new GroupedActionListener<>(
import java.io.IOException;
            completedListener.whenComplete(r -> removeBansRunnable.run(), e -> removeBansRunnable.run());
                        assert ExceptionsHelper.unwrapCause(exp) instanceof OpenSearchSecurityException == false;
                .preserveContext(() -> removeBanOnNodes(task, childrenNodes));
 * GitHub history for details.
                logger.debug(
        String reason,
import org.opensearch.transport.TransportRequest;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.transport.EmptyTransportResponseHandler;
 * Service used to cancel a task
                        logger.trace("sent ban for tasks with the parent [{}] to the node [{}]", taskId, node);
 * Modifications Copyright OpenSearch Contributors. See
            } else {
                logger.trace("child tasks of parent [{}] are completed", taskId);
 */
        }
public class TaskCancellationService {
    public TaskCancellationService(TransportService transportService) {
        @Override
 * software distributed under the License is distributed on an
            GroupedActionListener<Void> groupedListener = new GroupedActionListener<>(ActionListener.map(completedListener, r -> null), 3);
            this.reason = reason;
import org.opensearch.core.common.io.stream.StreamInput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
