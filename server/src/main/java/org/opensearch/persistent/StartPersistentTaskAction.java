            request.setParams(params);
    public static class Request extends ClusterManagerNodeRequest<Request> {
            this.taskId = taskId;
import org.opensearch.action.ActionRequestValidationException;
            out.writeString(taskName);
                actionFilters,
 * this file be licensed under the Apache-2.0 license or a
            super(client, action, new Request());
            return this;
            this.persistentTasksClusterService = persistentTasksClusterService;
        ) {
 * not use this file except in compliance with the License.
import java.util.Objects;
                    transportService.getTaskManager(),
/**
    }
            return Objects.hash(taskId, taskName, params);
}
                request.params,
        public String getTaskName() {
            super.writeTo(out);
        }
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
                request.taskId,
        public String getTaskId() {
        }
        @Nullable
                }
     */
     */
import org.opensearch.action.ActionType;
                StartPersistentTaskAction.NAME,
 * software distributed under the License is distributed on an
 */
            persistentTasksClusterService.createPersistentTask(
            return this;
 * Unless required by applicable law or agreed to in writing,
     * @opensearch.internal
        }
            IndexNameExpressionResolver indexNameExpressionResolver
        public int hashCode() {
import org.opensearch.core.common.io.stream.StreamInput;
                && Objects.equals(taskName, request1.taskName)
                request.taskName,
public class StartPersistentTaskAction extends ActionType<PersistentTaskResponse> {
                if (params.getWriteableName().equals(taskName) == false) {
                )
                Request::new,
        protected RequestBuilder(OpenSearchClient client, StartPersistentTaskAction action) {
import org.opensearch.cluster.service.ClusterService;
            PersistentTasksExecutorRegistry persistentTasksExecutorRegistry,
        }
import org.opensearch.common.Nullable;
                    persistentTasksExecutorRegistry,
            ClusterService clusterService,
            this.taskId = taskId;
                    listener,
        @Inject
            return taskId;
import org.opensearch.threadpool.ThreadPool;
 * SPDX-License-Identifier: Apache-2.0
            ThreadPool threadPool,
        }
        @Override
            super(
 * The OpenSearch Contributors require contributions made to
    }
        ) {
     *
        @Override
import org.opensearch.cluster.block.ClusterBlockLevel;
        public Request() {}
            this.params = params;
 *
        }
        public Request(StreamInput in) throws IOException {
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            ActionFilters actionFilters,
        }
            ClusterState state,
            this.taskName = taskName;
        public RequestBuilder setAction(String action) {
            return taskName;
            );
                validationException = addValidationError("action must be specified", validationException);
            super(in);
import org.opensearch.core.common.io.stream.StreamOutput;
 * specific language governing permissions and limitations
        }
    }
import org.opensearch.cluster.block.ClusterBlockException;
            params = in.readNamedWriteable(PersistentTaskParams.class);
 */
 */
        @Override
            taskId = in.readString();
        @Override
            return new PersistentTaskResponse(in);
            request.setTaskName(action);
     */
    }
        }
            Request request1 = (Request) o;
    /**
            return Objects.equals(taskId, request1.taskId)
            );
                indexNameExpressionResolver
            if (this == o) return true;
        }
            out.writeNamedWriteable(params);
 *  This action can be used to add the record for the persistent action to the cluster state.
     *
package org.opensearch.persistent;
        private String taskId;
                && Objects.equals(params, request1.params);
                clusterService,
    /**
            taskName = in.readString();
 * under the License.
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.common.inject.Inject;
            if (o == null || getClass() != o.getClass()) return false;
            return validationException;
     * The transport action.
        public TransportAction(
                )
        @Override
            final ActionListener<PersistentTaskResponse> listener
            PersistentTasksClusterService persistentTasksClusterService,
import java.io.IOException;
            this.taskName = taskName;
 *
        public RequestBuilder setTaskId(String taskId) {
    public static class RequestBuilder extends ClusterManagerNodeOperationRequestBuilder<Request, PersistentTaskResponse, RequestBuilder> {
        public void writeTo(StreamOutput out) throws IOException {
 */
 * GitHub history for details.
        }
     * The request builder.
import static org.opensearch.action.ValidateActions.addValidationError;
            return ThreadPool.Names.GENERIC;
        protected String executor() {
        @Override
            ActionRequestValidationException validationException = null;
/*
     * @opensearch.internal
 *  @opensearch.internal
            if (this.taskName == null) {
                ActionListener.delegateFailure(
            if (this.taskId == null) {
        public boolean equals(Object o) {
            }
 * You may obtain a copy of the License at
        }
        private String taskName;
        private final PersistentTasksClusterService persistentTasksClusterService;
 * Licensed to Elasticsearch under one or more contributor
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        super(NAME, PersistentTaskResponse::new);
            TransportService transportService,
            out.writeString(taskId);
        protected PersistentTaskResponse read(StreamInput in) throws IOException {
        public Request(String taskId, String taskName, PersistentTaskParams params) {
            }
     * Request for the action.
        }
                    );
                    persistentTasksService,
        public void setTaskName(String taskName) {
/*
            this.params = params;
     * @opensearch.internal
 *
            request.setTaskId(taskId);
        private PersistentTaskParams params;
    public static class TransportAction extends TransportClusterManagerNodeAction<Request, PersistentTaskResponse> {
        public PersistentTaskParams getParams() {
                    (delegatedListener, task) -> delegatedListener.onResponse(new PersistentTaskResponse(task))
 * ownership. Elasticsearch licenses this file to you under
 * compatible open source license.
    /**
/*
import org.opensearch.transport.client.OpenSearchClient;
        }
            }
            PersistentTasksService persistentTasksService,
        public ActionRequestValidationException validate() {
import org.opensearch.action.support.ActionFilters;
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    executor
            if (params != null) {
 * the Apache License, Version 2.0 (the "License"); you may
    public static final StartPersistentTaskAction INSTANCE = new StartPersistentTaskAction();
                    validationException = addValidationError(
import org.opensearch.cluster.ClusterState;
            return params;
 * Modifications Copyright OpenSearch Contributors. See
                threadPool,
            final Request request,
            clusterService.addListener(
        public RequestBuilder setRequest(PersistentTaskParams params) {
        @Override
                new PersistentTasksNodeService(
        }
        public void setTaskId(String taskId) {
            return this;
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {
 * KIND, either express or implied.  See the License for the
                transportService,
     *
            NodePersistentTasksExecutor executor = new NodePersistentTasksExecutor(threadPool);
                        "params have to have the same writeable name as task. params: " + params.getWriteableName() + " task: " + taskName,
import org.opensearch.transport.TransportService;
    private StartPersistentTaskAction() {
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
        public void setParams(PersistentTaskParams params) {
import org.opensearch.core.action.ActionListener;
 *    http://www.apache.org/licenses/LICENSE-2.0
        protected final void clusterManagerOperation(
        }
    public static final String NAME = "cluster:admin/persistent/start";
        }
            );
            // Cluster is not affected but we look up repositories in metadata
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        }
        }
                validationException = addValidationError("task id must be specified", validationException);
        }
 *
                        validationException
        }
