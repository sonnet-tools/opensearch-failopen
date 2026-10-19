 */
                    (delegatedListener, task) -> delegatedListener.onResponse(new PersistentTaskResponse(task))
            super(
            if (this == o) return true;
        @Override
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.block.ClusterBlockLevel;
        }
 * not use this file except in compliance with the License.
            return Objects.hash(taskId, allocationId, exception);  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Objects;
        private long allocationId = -1;
                ActionListener.delegateFailure(  
    }  
            );  
     */
import org.opensearch.core.common.io.stream.StreamOutput;
            this.persistentTasksClusterService = persistentTasksClusterService;
 * this work for additional information regarding copyright
/*
import org.opensearch.cluster.block.ClusterBlockException;
 *  
import org.opensearch.cluster.service.ClusterService;
        public void writeTo(StreamOutput out) throws IOException {
/*
            return ThreadPool.Names.GENERIC;  
            out.writeLong(allocationId);
        @Override
            ClusterState state,
        }
                && allocationId == request.allocationId  
 * GitHub history for details.
            );
                actionFilters,  
                threadPool,
import static org.opensearch.action.ValidateActions.addValidationError;
/**  
     */
 * ActionType that is used by executor node to indicate that the persistent action finished or failed on the node and needs to be
                clusterService,
    }
        protected String executor() {
 * Licensed to Elasticsearch under one or more contributor  
            }
            this.exception = exception;  
import org.opensearch.transport.TransportService;
        @Override  
     *  
        @Override  
        @Inject
 * software distributed under the License is distributed on an
        private final PersistentTasksClusterService persistentTasksClusterService;
                transportService,  
                validationException = addValidationError("allocation id is negative or missing", validationException);
        ) {  
            PersistentTasksClusterService persistentTasksClusterService,
        @Override  
     * The transport action.
            ThreadPool threadPool,
            ActionFilters actionFilters,  
                request.taskId,  
        ) {
        public int hashCode() {
        private Exception exception;  
 * @opensearch.internal
        protected final void clusterManagerOperation(  
        }  
        }
            if (o == null || getClass() != o.getClass()) return false;  
            super(in);
public class CompletionPersistentTaskAction extends ActionType<PersistentTaskResponse> {  
import org.opensearch.core.action.ActionListener;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *  
        }
        }
            taskId = in.readString();
                    listener,
        }
    private CompletionPersistentTaskAction() {
            exception = in.readException();
            }
     *
    /**  
    /**
    public static class Request extends ClusterManagerNodeRequest<Request> {
        }
        public TransportAction(
        public boolean equals(Object o) {
 *  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;  
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
import org.opensearch.cluster.ClusterState;  
        public Request(String taskId, long allocationId, Exception exception) {
                CompletionPersistentTaskAction.NAME,
        }
    public static final CompletionPersistentTaskAction INSTANCE = new CompletionPersistentTaskAction();
    public static class RequestBuilder extends ClusterManagerNodeOperationRequestBuilder<Request, PersistentTaskResponse, RequestBuilder> {  
            final Request request,
 * Modifications Copyright OpenSearch Contributors. See  
 *
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {  
 * ownership. Elasticsearch licenses this file to you under  
}
    public static final String NAME = "cluster:admin/persistent/completion";  
        @Override
     * @opensearch.internal  
            Request request = (Request) o;
 * this file be licensed under the Apache-2.0 license or a
 * removed from the cluster state in case of successful completion or restarted on some other node in case of failure.
/*  
        super(NAME, PersistentTaskResponse::new);  
        public ActionRequestValidationException validate() {
 * compatible open source license.
    /**
     */
        }  
            out.writeString(taskId);
                request.exception,
            return new PersistentTaskResponse(in);
import org.opensearch.action.ActionRequestValidationException;  
            return validationException;  
            IndexNameExpressionResolver indexNameExpressionResolver
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
import org.opensearch.core.common.io.stream.StreamInput;
                )  
                validationException = addValidationError("task id is missing", validationException);
        }
package org.opensearch.persistent;
            return Objects.equals(taskId, request.taskId)
            out.writeException(exception);  
            ClusterService clusterService,
            allocationId = in.readLong();  
            this.taskId = taskId;
        protected PersistentTaskResponse read(StreamInput in) throws IOException {
import org.opensearch.action.ActionType;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
     * @opensearch.internal
        private String taskId;
 */
    }
import org.opensearch.threadpool.ThreadPool;  
            super(client, action, new Request());  
     * The request bulder.
    }
            // Cluster is not affected but we look up repositories in metadata
        @Override
        public Request(StreamInput in) throws IOException {  
 * specific language governing permissions and limitations
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    public static class TransportAction extends TransportClusterManagerNodeAction<Request, PersistentTaskResponse> {  
import org.opensearch.transport.client.OpenSearchClient;
                indexNameExpressionResolver
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
            if (allocationId < 0) {  
 * You may obtain a copy of the License at  
 *
     * The request.
        }
            ActionRequestValidationException validationException = null;
                request.allocationId,
            TransportService transportService,  
 */
            persistentTasksClusterService.completePersistentTask(
        protected RequestBuilder(OpenSearchClient client, CompletionPersistentTaskAction action) {
import org.opensearch.common.inject.Inject;
        @Override
            this.allocationId = allocationId;
     * @opensearch.internal
import org.opensearch.action.support.ActionFilters;
            if (taskId == null) {  
            super.writeTo(out);  
        public Request() {}
            final ActionListener<PersistentTaskResponse> listener  
 */  
                && Objects.equals(exception, request.exception);
                Request::new,
