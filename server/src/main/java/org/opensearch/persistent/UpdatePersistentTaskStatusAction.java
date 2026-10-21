            final ActionListener<PersistentTaskResponse> listener
public class UpdatePersistentTaskStatusAction extends ActionType<PersistentTaskResponse> {
    public static class Request extends ClusterManagerNodeRequest<Request> {
    }
            taskId = in.readString();
                Request::new,
        public int hashCode() {
/*
import org.opensearch.core.action.ActionListener;
import java.io.IOException;
    private UpdatePersistentTaskStatusAction() {
                validationException = addValidationError("allocationId must be specified", validationException);
            ActionRequestValidationException validationException = null;
 * compatible open source license.
            if (this.allocationId == -1L) {
 * The OpenSearch Contributors require contributions made to
        ) {
            final Request request,
import org.opensearch.cluster.ClusterState;
            ActionFilters actionFilters,
        super(NAME, PersistentTaskResponse::new);
            this.allocationId = allocationId;
                    (delegatedListener, task) -> delegatedListener.onResponse(new PersistentTaskResponse(task))
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
            // We cannot really check if status has the same type as task because we don't have access
        }
        }
            if (o == null || getClass() != o.getClass()) return false;
    public static class RequestBuilder extends ClusterManagerNodeOperationRequestBuilder<Request, PersistentTaskResponse, RequestBuilder> {
        }
 */
                ActionListener.delegateFailure(
     * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
        public Request(String taskId, long allocationId, PersistentTaskState state) {
        @Override
 *
        }
        @Override
import static org.opensearch.action.ValidateActions.addValidationError;
        protected final void clusterManagerOperation(
        }
                request.state,
        ) {
            return this;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.inject.Inject;
                    listener,
            return validationException;
    /**
     *
                UpdatePersistentTaskStatusAction.NAME,
import org.opensearch.action.support.ActionFilters;
                request.allocationId,
    public static final UpdatePersistentTaskStatusAction INSTANCE = new UpdatePersistentTaskStatusAction();
        protected RequestBuilder(OpenSearchClient client, UpdatePersistentTaskStatusAction action) {
        @Override
        public void setAllocationId(long allocationId) {
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {
     * The request builder.
                actionFilters,
            final ClusterState state,
            persistentTasksClusterService.updatePersistentTaskState(
 * KIND, either express or implied.  See the License for the
            // to the task here. We will check it when we try to update the task
     * @opensearch.internal
        protected PersistentTaskResponse read(StreamInput in) throws IOException {
            out.writeOptionalNamedWriteable(state);
/*
     */
import org.opensearch.cluster.block.ClusterBlockLevel;
            this.persistentTasksClusterService = persistentTasksClusterService;
            state = in.readOptionalNamedWriteable(PersistentTaskState.class);
 * license agreements. See the NOTICE file distributed with
 *
            super(in);
            allocationId = in.readLong();
        public final RequestBuilder setState(PersistentTaskState state) {
    }
    }
            request.setState(state);
                threadPool,
            request.setTaskId(taskId);
        public Request() {}
            this.allocationId = allocationId;
    /**
        }
 * GitHub history for details.
 * this work for additional information regarding copyright
            this.taskId = taskId;
            TransportService transportService,
        }
                transportService,
     * The action request.
    public static class TransportAction extends TransportClusterManagerNodeAction<Request, PersistentTaskResponse> {
            super(
 *
            ThreadPool threadPool,
                request.taskId,
}
        public TransportAction(
     */
            );
            return ThreadPool.Names.MANAGEMENT;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
/**
            out.writeLong(allocationId);
        public void setTaskId(String taskId) {
            super(client, action, new Request());
     *
 * specific language governing permissions and limitations
        public final RequestBuilder setTaskId(String taskId) {
import org.opensearch.cluster.service.ClusterService;
 * @opensearch.internal
            }
        public Request(StreamInput in) throws IOException {
        private String taskId;
            return Objects.hash(taskId, allocationId, state);
            Request request = (Request) o;
     * The transport action.
        }
import org.opensearch.action.ActionType;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            super.writeTo(out);
            if (this == o) return true;
            this.state = state;
        @Override
                validationException = addValidationError("task id must be specified", validationException);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
 */
        private PersistentTaskState state;
        }
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor
            this.taskId = taskId;
    /**
            PersistentTasksClusterService persistentTasksClusterService,
            }
     */
 * not use this file except in compliance with the License.
 * under the License.
 * ownership. Elasticsearch licenses this file to you under
        private long allocationId = -1L;
        @Override
        public void writeTo(StreamOutput out) throws IOException {
        @Override
 * SPDX-License-Identifier: Apache-2.0
        }
                indexNameExpressionResolver
 *
        @Inject
            if (this.taskId == null) {
import org.opensearch.threadpool.ThreadPool;
 * Unless required by applicable law or agreed to in writing,
        }
        }
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
import org.opensearch.transport.TransportService;
 */
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.persistent;
import org.opensearch.action.ActionRequestValidationException;
            this.state = state;
/*
        }
        protected String executor() {
 * Modifications Copyright OpenSearch Contributors. See
            return Objects.equals(taskId, request.taskId) && allocationId == request.allocationId && Objects.equals(state, request.state);
import java.util.Objects;
        }
    public static final String NAME = "cluster:admin/persistent/update_status";
        public ActionRequestValidationException validate() {
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
     *
 * Transport action for updating persistent tasks
     * @opensearch.internal
            );
        public void setState(PersistentTaskState state) {
        private final PersistentTasksClusterService persistentTasksClusterService;
            ClusterService clusterService,
        }
            out.writeString(taskId);
import org.opensearch.transport.client.OpenSearchClient;
 */
        public boolean equals(Object o) {
        }
 * You may obtain a copy of the License at
        @Override
                clusterService,
        }
                )
            IndexNameExpressionResolver indexNameExpressionResolver
import org.opensearch.core.common.io.stream.StreamOutput;
            return this;
            // Cluster is not affected but we look up repositories in metadata
            return new PersistentTaskResponse(in);
