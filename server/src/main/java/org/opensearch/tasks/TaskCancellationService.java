            BanParentTaskRequest::new,
            this.reason = null;  
        }
        public void writeTo(StreamOutput out) throws IOException {
            ban = in.readBoolean();
    }  
        }
            listener.onResponse(null);  
        } else {
import org.opensearch.core.transport.TransportResponse;
        private final boolean ban;
                .getThreadContext()  
 *
 * compatible open source license.
                    "Received ban for the parent [{}] on the node [{}], reason: [{}]",
        private BanParentTaskRequest(StreamInput in) throws IOException {
            transportService.sendRequest(node, BAN_PARENT_ACTION_NAME, request, new EmptyTransportResponseHandler(ThreadPool.Names.SAME) {
import java.io.IOException;
import org.opensearch.cluster.node.DiscoveryNode;
        final TaskId taskId = new TaskId(localNodeId(), task.getId());  
                }
        this.transportService = transportService;
                @Override
            setBanOnNodes(reason, waitForCompletion, task, childrenNodes, banOnNodesListener);
            ActionListener.map(listener, r -> null),  
    }
                    assert ExceptionsHelper.unwrapCause(exp) instanceof OpenSearchSecurityException == false;
                    childTasks.size() + 1
            this.parentTaskId = parentTaskId;  
                        logger.trace("sent ban for tasks with the parent [{}] to the node [{}]", taskId, node);  
                logger.trace("task [{}] is cancelled", taskId);  
                node,  
import org.opensearch.action.support.ChannelActionListener;  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
        static BanParentTaskRequest createRemoveBanParentTaskRequest(TaskId parentTaskId) {
    void cancelTaskAndDescendants(CancellableTask task, String reason, boolean waitForCompletion, ActionListener<Void> listener) {
            GroupedActionListener<Void> groupedListener = new GroupedActionListener<>(ActionListener.map(completedListener, r -> null), 3);  
            parentTaskId.writeTo(out);  
                taskManager.removeBan(request.parentTaskId);  
 * Modifications Copyright OpenSearch Contributors. See
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
 * Service used to cancel a task  
        private final String reason;
            logger.trace("cancelling task [{}] and its descendants", taskId);
        }  
        }
 * the Apache License, Version 2.0 (the "License"); you may
        this.taskManager = transportService.getTaskManager();  
    private final TransportService transportService;
import org.opensearch.transport.TransportRequest;  
            }
                final GroupedActionListener<Void> listener = new GroupedActionListener<>(
        final BanParentTaskRequest request = BanParentTaskRequest.createRemoveBanParentTaskRequest(new TaskId(localNodeId(), task.getId()));
        }  
                public void handleException(TransportException exp) {  
import org.opensearch.core.tasks.TaskId;  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
                    @Override
 *
        }  
 */  
    }
            // We remove bans after all child tasks are completed although in theory we can do it on a per-node basis.
package org.opensearch.tasks;
            } else {
            if (ban) {
            if (request.ban) {  
            // If we start unbanning when the last child task completed and that child task executed with a specific user, then unban  
                    @Override
    ) {
import org.apache.logging.log4j.Logger;
            StepListener<Void> banOnNodesListener = new StepListener<>();  
        }
                final List<CancellableTask> childTasks = taskManager.setBan(request.parentTaskId, request.reason);
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
            }
                banRequest,
    }
            logger.trace("Sending remove ban for tasks with the parent [{}] to the node [{}]", request.parentTaskId, node);  
    private class BanParentRequestHandler implements TransportRequestHandler<BanParentTaskRequest> {  
            Collection<DiscoveryNode> childrenNodes = taskManager.startBanOnChildrenNodes(task.getId(), () -> {
                    public void handleResponse(TransportResponse.Empty response) {
            taskManager.cancel(task, reason, () -> {
    }
import java.util.List;  
        boolean waitForCompletion,  
                    }  
                BAN_PARENT_ACTION_NAME,
        public void messageReceived(final BanParentTaskRequest request, final TransportChannel channel, Task task) throws Exception {
import org.opensearch.threadpool.ThreadPool;
 */  
        @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    public void handleException(TransportException exp) {
            new BanParentRequestHandler()
    private static final Logger logger = LogManager.getLogger(TaskCancellationService.class);  
    private static class BanParentTaskRequest extends TransportRequest {
            ThreadPool.Names.SAME,  
                taskManager.cancel(task, reason, () -> listener.onResponse(null));
        }
                    request.parentTaskId,  
                );
    private void removeBanOnNodes(CancellableTask task, Collection<DiscoveryNode> childNodes) {  
import org.opensearch.action.support.GroupedActionListener;
            this.parentTaskId = parentTaskId;
 *  
    private final TaskManager taskManager;
                }  
                taskManager.cancel(task, reason, () -> {});
            // if wait_for_completion is true, then only return when (1) bans are placed on child nodes, (2) child tasks are
            banOnNodesListener.whenComplete(groupedListener::onResponse, groupedListener::onFailure);
                    }
        return transportService.getLocalNode().getId();
            out.writeBoolean(waitForCompletion);
            this.waitForCompletion = false;
        private BanParentTaskRequest(TaskId parentTaskId, String reason, boolean waitForCompletion) {
                    logger.info("failed to remove the parent ban for task {} on node {}", request.parentTaskId, node);
 * software distributed under the License is distributed on an
import org.apache.logging.log4j.LogManager;
                logger.debug(
                logger.debug("Removing ban for the parent [{}] on the node [{}]", request.parentTaskId, localNodeId());
                .preserveContext(() -> removeBanOnNodes(task, childrenNodes));
            });
                groupedListener.onResponse(null);
    }
import org.opensearch.core.action.ActionListener;  
            }
    public static final String BAN_PARENT_ACTION_NAME = "internal:admin/tasks/ban";
        logger.trace("cancelling child tasks of [{}] on child nodes {}", taskId, childNodes);
        private BanParentTaskRequest(TaskId parentTaskId) {  
                new EmptyTransportResponseHandler(ThreadPool.Names.SAME) {  
        GroupedActionListener<Void> groupedListener = new GroupedActionListener<>(
                        new ChannelActionListener<>(channel, BAN_PARENT_ACTION_NAME, request),
 * KIND, either express or implied.  See the License for the
        static BanParentTaskRequest createSetBanParentTaskRequest(TaskId parentTaskId, String reason, boolean waitForCompletion) {  
            parentTaskId = TaskId.readFromStream(in);  
                    cancelTaskAndDescendants(childTask, request.reason, request.waitForCompletion, listener);
        );
public class TaskCancellationService {
        private final boolean waitForCompletion;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
            logger.trace("task [{}] doesn't have any children that should be cancelled", taskId);  
            childNodes.size()
        if (childNodes.isEmpty()) {
 * SPDX-License-Identifier: Apache-2.0
        final TaskId taskId = task.taskInfo(localNodeId(), false).getTaskId();
import java.util.Collection;
            out.writeBoolean(ban);
import org.opensearch.ExceptionsHelper;  
import org.opensearch.transport.TransportService;
            return new BanParentTaskRequest(parentTaskId);
        final BanParentTaskRequest banRequest = BanParentTaskRequest.createSetBanParentTaskRequest(taskId, reason, waitForCompletion);  
            }, reason);
                    request.reason
            return;
            final Runnable removeBansRunnable = transportService.getThreadPool()
    private String localNodeId() {  
            this.reason = reason;
        @Override
                        groupedListener.onResponse(null);
            transportService.sendRequest(
            this.waitForCompletion = waitForCompletion;  
                        groupedListener.onFailure(exp);
import org.opensearch.OpenSearchSecurityException;
 * ownership. Elasticsearch licenses this file to you under  
                listener.onResponse(null);  
            );
    public TaskCancellationService(TransportService transportService) {
                    ),  
            this.ban = false;
import org.opensearch.transport.TransportException;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamOutput;
            this.ban = true;
        }
        for (DiscoveryNode node : childNodes) {
import org.opensearch.transport.TransportRequestHandler;
                    ActionListener.map(  
                completedListener.whenComplete(r -> listener.onResponse(null), listener::onFailure);
            completedListener.whenComplete(r -> removeBansRunnable.run(), e -> removeBansRunnable.run());  
import org.opensearch.core.common.io.stream.StreamInput;
        }
/*
            } else {
            } else {  
            BAN_PARENT_ACTION_NAME,
            if (waitForCompletion) {  
            reason = ban ? in.readString() : null;
 * license agreements. See the NOTICE file distributed with
                groupedListener.onResponse(null);  
                out.writeString(reason);  
                banOnNodesListener.whenComplete(r -> listener.onResponse(null), listener::onFailure);  
 * under the License.  
    private void setBanOnNodes(
        Collection<DiscoveryNode> childNodes,
        ActionListener<Void> listener  
/*  
            waitForCompletion = in.readBoolean();  
/**
                        logger.warn("Cannot send ban for tasks with the parent [{}] to the node [{}]", taskId, node);
 * GitHub history for details.
            }  
            // completed or failed, (3) the main task is cancelled. Otherwise, return after bans are placed on child nodes.
 */
        if (task.shouldCancelChildrenOnCancellation()) {  
/*  
        for (DiscoveryNode node : childNodes) {
                );  
import org.opensearch.transport.EmptyTransportResponseHandler;  
import org.opensearch.transport.TransportChannel;
 */  
                    localNodeId(),
            // requests are denied because internal requests can't run with a user. We need to remove bans with the current thread context.
import org.opensearch.action.StepListener;
                }
}
 * specific language governing permissions and limitations
                        assert ExceptionsHelper.unwrapCause(exp) instanceof OpenSearchSecurityException == false;  
        private final TaskId parentTaskId;
    }
        }  
        String reason,
                        r -> TransportResponse.Empty.INSTANCE
            super.writeTo(out);
                listener.onResponse(null);
        transportService.registerRequestHandler(
            super(in);
            return new BanParentTaskRequest(parentTaskId, reason, waitForCompletion);
            if (waitForCompletion) {
 *
        );  
            StepListener<Void> completedListener = new StepListener<>();
                logger.trace("child tasks of parent [{}] are completed", taskId);
                for (CancellableTask childTask : childTasks) {  
        CancellableTask task,
            });
