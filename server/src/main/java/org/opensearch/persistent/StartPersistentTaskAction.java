                        "params have to have the same writeable name as task. params: " + params.getWriteableName() + " task: " + taskName,  
            PersistentTasksClusterService persistentTasksClusterService,  
        protected final void clusterManagerOperation(
        }
        private String taskName;  
        public boolean equals(Object o) {  
            IndexNameExpressionResolver indexNameExpressionResolver  
        @Inject  
            if (o == null || getClass() != o.getClass()) return false;
            super(client, action, new Request());
 */
            taskId = in.readString();
        protected PersistentTaskResponse read(StreamInput in) throws IOException {
            this.taskName = taskName;
import java.util.Objects;  
 *  @opensearch.internal
 *  This action can be used to add the record for the persistent action to the cluster state.
    public static class RequestBuilder extends ClusterManagerNodeOperationRequestBuilder<Request, PersistentTaskResponse, RequestBuilder> {
            }
        public Request(String taskId, String taskName, PersistentTaskParams params) {
    public static final String NAME = "cluster:admin/persistent/start";  
        public RequestBuilder setTaskId(String taskId) {
        @Override  
 * under the License.  
            ClusterService clusterService,  
            out.writeString(taskName);
 * license agreements. See the NOTICE file distributed with
                actionFilters,
        }  
                indexNameExpressionResolver  
     */
            if (params != null) {  
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {
import org.opensearch.cluster.block.ClusterBlockException;
     */  
 * ownership. Elasticsearch licenses this file to you under  
/*  
                validationException = addValidationError("task id must be specified", validationException);
            ActionFilters actionFilters,
                    validationException = addValidationError(
import org.opensearch.transport.TransportService;
        @Override
import static org.opensearch.action.ValidateActions.addValidationError;
     */
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
            this.persistentTasksClusterService = persistentTasksClusterService;
import org.opensearch.action.support.ActionFilters;
    }  
 * compatible open source license.
            params = in.readNamedWriteable(PersistentTaskParams.class);
        }  
        public RequestBuilder setAction(String action) {  
                ActionListener.delegateFailure(
     * @opensearch.internal
     * Request for the action.
                )
        }
        @Override  
/**
     * The request builder.  
                }  
import org.opensearch.core.common.io.stream.StreamInput;
                clusterService,
import org.opensearch.core.common.io.stream.StreamOutput;  
        public Request(StreamInput in) throws IOException {  
        public String getTaskName() {
            final Request request,
 *  
            );
            out.writeString(taskId);
            this.params = params;
                request.taskName,
 * software distributed under the License is distributed on an
        }  
            }
import org.opensearch.core.action.ActionListener;
        public Request() {}
        public void setTaskId(String taskId) {
            final ActionListener<PersistentTaskResponse> listener
     * @opensearch.internal  
     * @opensearch.internal  
public class StartPersistentTaskAction extends ActionType<PersistentTaskResponse> {  
 * The OpenSearch Contributors require contributions made to  
        }
            super(
                    executor  
            Request request1 = (Request) o;  
        }
 * not use this file except in compliance with the License.
                validationException = addValidationError("action must be specified", validationException);
    }
import org.opensearch.transport.client.OpenSearchClient;  
import org.opensearch.action.ActionType;
        }
        @Nullable
            out.writeNamedWriteable(params);  
import org.opensearch.cluster.ClusterState;  
            return validationException;
 * this file be licensed under the Apache-2.0 license or a
    public static final StartPersistentTaskAction INSTANCE = new StartPersistentTaskAction();
        }
        public void setParams(PersistentTaskParams params) {
                transportService,
    }
            super(in);
            request.setTaskId(taskId);
                    persistentTasksExecutorRegistry,
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
            if (this.taskName == null) {  
            persistentTasksClusterService.createPersistentTask(  
        }
            this.taskId = taskId;  
 *
            NodePersistentTasksExecutor executor = new NodePersistentTasksExecutor(threadPool);  
            this.taskId = taskId;
            }
import org.opensearch.action.ActionRequestValidationException;  
import org.opensearch.common.inject.Inject;  
                && Objects.equals(taskName, request1.taskName)
            return taskId;
        }  
    private StartPersistentTaskAction() {
                threadPool,  
            PersistentTasksExecutorRegistry persistentTasksExecutorRegistry,
        public ActionRequestValidationException validate() {
 */
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
     *
        }
     *
        public void setTaskName(String taskName) {  
            return new PersistentTaskResponse(in);  
            // Cluster is not affected but we look up repositories in metadata
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;  
            return this;  
        public void writeTo(StreamOutput out) throws IOException {
            request.setTaskName(action);
        public PersistentTaskParams getParams() {  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        }  
                )
     *
                StartPersistentTaskAction.NAME,  
import org.opensearch.cluster.service.ClusterService;
            clusterService.addListener(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
            return Objects.hash(taskId, taskName, params);
        public String getTaskId() {
                if (params.getWriteableName().equals(taskName) == false) {
 *  
            request.setParams(params);  
    public static class Request extends ClusterManagerNodeRequest<Request> {
 */
            TransportService transportService,
            return params;
import org.opensearch.common.Nullable;
        protected RequestBuilder(OpenSearchClient client, StartPersistentTaskAction action) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
 * specific language governing permissions and limitations
 */  
        }
        private String taskId;
                    listener,
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
                new PersistentTasksNodeService(
            if (this == o) return true;
                        validationException
            return Objects.equals(taskId, request1.taskId)
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        @Override  
 * You may obtain a copy of the License at  
        @Override
/*
            return this;
            );
    /**  
            return taskName;  
    }
 * this work for additional information regarding copyright
            ThreadPool threadPool,
                    persistentTasksService,  
     * The transport action.
            this.params = params;  
            this.taskName = taskName;  
                && Objects.equals(params, request1.params);  
        public RequestBuilder setRequest(PersistentTaskParams params) {
            return ThreadPool.Names.GENERIC;
        private PersistentTaskParams params;
            );
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
                request.params,  
        }
        }
}
        private final PersistentTasksClusterService persistentTasksClusterService;
            super.writeTo(out);  
        @Override
        @Override
                request.taskId,
import org.opensearch.threadpool.ThreadPool;
                    );
        }
        }
            taskName = in.readString();  
package org.opensearch.persistent;
            ClusterState state,  
            if (this.taskId == null) {  
        ) {
                Request::new,
    public static class TransportAction extends TransportClusterManagerNodeAction<Request, PersistentTaskResponse> {
        ) {
            PersistentTasksService persistentTasksService,
 * the Apache License, Version 2.0 (the "License"); you may
                    (delegatedListener, task) -> delegatedListener.onResponse(new PersistentTaskResponse(task))  
import org.opensearch.cluster.block.ClusterBlockLevel;
import java.io.IOException;
            return this;
        protected String executor() {  
        @Override  
/*
        public int hashCode() {
        public TransportAction(
            ActionRequestValidationException validationException = null;
        }
        }
    /**
        super(NAME, PersistentTaskResponse::new);  
 *
                    transportService.getTaskManager(),
