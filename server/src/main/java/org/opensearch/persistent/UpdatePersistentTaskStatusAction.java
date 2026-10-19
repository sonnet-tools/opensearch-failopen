            // We cannot really check if status has the same type as task because we don't have access  
        public Request(String taskId, long allocationId, PersistentTaskState state) {
            this.persistentTasksClusterService = persistentTasksClusterService;  
 *
 */
                validationException = addValidationError("task id must be specified", validationException);
            }
    public static class TransportAction extends TransportClusterManagerNodeAction<Request, PersistentTaskResponse> {
 * compatible open source license.
                    (delegatedListener, task) -> delegatedListener.onResponse(new PersistentTaskResponse(task))
            out.writeString(taskId);
            ThreadPool threadPool,
/*
/*
        }  
 * You may obtain a copy of the License at  
            super(in);
 * Licensed to Elasticsearch under one or more contributor  
            super(client, action, new Request());  
        public void setAllocationId(long allocationId) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.service.ClusterService;
 *    http://www.apache.org/licenses/LICENSE-2.0
        public void setState(PersistentTaskState state) {  
 * under the License.  
import org.opensearch.cluster.block.ClusterBlockException;
 * @opensearch.internal  
    private UpdatePersistentTaskStatusAction() {
        private PersistentTaskState state;
import org.opensearch.threadpool.ThreadPool;  
                ActionListener.delegateFailure(
import org.opensearch.action.ActionRequestValidationException;  
            this.state = state;
import org.opensearch.transport.TransportService;
            taskId = in.readString();
 */  
     * @opensearch.internal
            this.taskId = taskId;
    }  
        @Override
        protected PersistentTaskResponse read(StreamInput in) throws IOException {  
            super.writeTo(out);  
            final ActionListener<PersistentTaskResponse> listener
        }
 * Transport action for updating persistent tasks
        protected String executor() {
    /**
        }  
            request.setState(state);  
            request.setTaskId(taskId);
                transportService,
        }
        }
            this.allocationId = allocationId;  
            // to the task here. We will check it when we try to update the task
            PersistentTasksClusterService persistentTasksClusterService,  
            allocationId = in.readLong();  
            }
        @Override
/**  
                indexNameExpressionResolver
     *
import static org.opensearch.action.ValidateActions.addValidationError;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            out.writeOptionalNamedWriteable(state);  
        @Override  
 * not use this file except in compliance with the License.
        @Override
            final ClusterState state,
    /**
            return Objects.hash(taskId, allocationId, state);  
 * Modifications Copyright OpenSearch Contributors. See  
        private long allocationId = -1L;
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
        }
    /**
 */
     */
        }  
            Request request = (Request) o;  
import org.opensearch.core.action.ActionListener;  
            );
 * Unless required by applicable law or agreed to in writing,
        private String taskId;  
        public Request(StreamInput in) throws IOException {  
            return ThreadPool.Names.MANAGEMENT;
import org.opensearch.transport.client.OpenSearchClient;
            if (o == null || getClass() != o.getClass()) return false;
            ClusterService clusterService,  
            return new PersistentTaskResponse(in);
import java.util.Objects;
            this.state = state;
 *
            );  
     *  
            ActionRequestValidationException validationException = null;
        public final RequestBuilder setTaskId(String taskId) {  
 * software distributed under the License is distributed on an
                threadPool,
        public Request() {}
     * The request builder.
            IndexNameExpressionResolver indexNameExpressionResolver
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {
        }
                request.allocationId,  
                request.state,
 */
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
            ActionFilters actionFilters,
     * @opensearch.internal
     * @opensearch.internal
        }
                )
     */  
            this.allocationId = allocationId;  
            if (this.allocationId == -1L) {  
            return validationException;
    public static class Request extends ClusterManagerNodeRequest<Request> {
            return this;
        protected final void clusterManagerOperation(
     * The transport action.  
        public void setTaskId(String taskId) {
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
        public ActionRequestValidationException validate() {
        public boolean equals(Object o) {  
            // Cluster is not affected but we look up repositories in metadata  
        }  
        public final RequestBuilder setState(PersistentTaskState state) {
 * ownership. Elasticsearch licenses this file to you under  
                request.taskId,
        }
 * license agreements. See the NOTICE file distributed with
            if (this == o) return true;
 *
 *  
     *
 * specific language governing permissions and limitations
    public static final UpdatePersistentTaskStatusAction INSTANCE = new UpdatePersistentTaskStatusAction();
        @Inject  
import org.opensearch.core.common.io.stream.StreamOutput;
        }
}  
        public void writeTo(StreamOutput out) throws IOException {
        }
     * The action request.  
            this.taskId = taskId;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
import java.io.IOException;
import org.opensearch.common.inject.Inject;
            state = in.readOptionalNamedWriteable(PersistentTaskState.class);
        }
        private final PersistentTasksClusterService persistentTasksClusterService;
    public static class RequestBuilder extends ClusterManagerNodeOperationRequestBuilder<Request, PersistentTaskResponse, RequestBuilder> {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    listener,  
        @Override
            persistentTasksClusterService.updatePersistentTaskState(
                actionFilters,
        ) {
        public int hashCode() {
import org.opensearch.action.ActionType;
                clusterService,  
import org.opensearch.cluster.block.ClusterBlockLevel;
        }
        ) {  
 * GitHub history for details.
    public static final String NAME = "cluster:admin/persistent/update_status";
    }
        @Override  
        super(NAME, PersistentTaskResponse::new);
            out.writeLong(allocationId);
    }  
            if (this.taskId == null) {  
package org.opensearch.persistent;
            super(  
                UpdatePersistentTaskStatusAction.NAME,
 * this work for additional information regarding copyright
import org.opensearch.action.support.ActionFilters;
 * this file be licensed under the Apache-2.0 license or a
            return Objects.equals(taskId, request.taskId) && allocationId == request.allocationId && Objects.equals(state, request.state);
        protected RequestBuilder(OpenSearchClient client, UpdatePersistentTaskStatusAction action) {
        }
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;  
        }
        public TransportAction(
import org.opensearch.cluster.ClusterState;  
                validationException = addValidationError("allocationId must be specified", validationException);
            TransportService transportService,
    }
 * KIND, either express or implied.  See the License for the
            final Request request,  
     */  
/*  
public class UpdatePersistentTaskStatusAction extends ActionType<PersistentTaskResponse> {
        @Override
            return this;
                Request::new,  
