                transportService,
                ActionListener.delegateFailure(
 * software distributed under the License is distributed on an
                    (delegatedListener, task) -> delegatedListener.onResponse(new PersistentTaskResponse(task))
        private Exception exception;
            Request request = (Request) o;
        }
     *
            ClusterService clusterService,
        }
            return ThreadPool.Names.GENERIC;
            return new PersistentTaskResponse(in);
        }
                clusterService,
                && allocationId == request.allocationId
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * ownership. Elasticsearch licenses this file to you under
            if (this == o) return true;
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
    }
        }
            );
    /**
 */
        protected final void clusterManagerOperation(
     */
            final Request request,
        protected String executor() {
            return validationException;
            ActionRequestValidationException validationException = null;
        @Override
                validationException = addValidationError("allocation id is negative or missing", validationException);
     */
import org.opensearch.action.support.ActionFilters;
        private final PersistentTasksClusterService persistentTasksClusterService;
import org.opensearch.transport.client.OpenSearchClient;
                validationException = addValidationError("task id is missing", validationException);
import org.opensearch.cluster.ClusterState;
     */
 * @opensearch.internal
            out.writeException(exception);
                )
 */
import java.io.IOException;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
                && Objects.equals(exception, request.exception);
        @Override
            taskId = in.readString();
/**
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
     * @opensearch.internal
                request.taskId,
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.block.ClusterBlockException;
        @Override
 */
        super(NAME, PersistentTaskResponse::new);
        public Request(String taskId, long allocationId, Exception exception) {
                    listener,
 * Unless required by applicable law or agreed to in writing,
            super(
        }
            return Objects.hash(taskId, allocationId, exception);
            out.writeLong(allocationId);
        @Inject
            final ActionListener<PersistentTaskResponse> listener
package org.opensearch.persistent;
            exception = in.readException();
        }
        public boolean equals(Object o) {
        }
            super(in);
            }
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.action.ActionType;
            this.allocationId = allocationId;
 * The OpenSearch Contributors require contributions made to
        @Override
    public static class RequestBuilder extends ClusterManagerNodeOperationRequestBuilder<Request, PersistentTaskResponse, RequestBuilder> {
    public static final CompletionPersistentTaskAction INSTANCE = new CompletionPersistentTaskAction();
        ) {
        }
import java.util.Objects;
            return Objects.equals(taskId, request.taskId)
public class CompletionPersistentTaskAction extends ActionType<PersistentTaskResponse> {
            persistentTasksClusterService.completePersistentTask(
            super.writeTo(out);
    }
        protected PersistentTaskResponse read(StreamInput in) throws IOException {
            this.exception = exception;
 * specific language governing permissions and limitations
    private CompletionPersistentTaskAction() {
        @Override
 * GitHub history for details.
 *
import org.opensearch.core.common.io.stream.StreamOutput;
     * The request.
        public ActionRequestValidationException validate() {
        @Override
 * KIND, either express or implied.  See the License for the
            if (allocationId < 0) {
     * The request bulder.
            // Cluster is not affected but we look up repositories in metadata
import org.opensearch.threadpool.ThreadPool;
    /**
 *
            this.persistentTasksClusterService = persistentTasksClusterService;
    public static final String NAME = "cluster:admin/persistent/completion";
                threadPool,
/*
                request.exception,
        public TransportAction(
        public Request(StreamInput in) throws IOException {
            allocationId = in.readLong();
import org.opensearch.action.ActionRequestValidationException;
     *
            super(client, action, new Request());
        }
            }
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * SPDX-License-Identifier: Apache-2.0
            out.writeString(taskId);
        }
                indexNameExpressionResolver
            );
    }
                actionFilters,
     * The transport action.
        ) {
import org.opensearch.transport.TransportService;
 * removed from the cluster state in case of successful completion or restarted on some other node in case of failure.
        protected RequestBuilder(OpenSearchClient client, CompletionPersistentTaskAction action) {
import org.opensearch.common.inject.Inject;
        @Override
        }
            this.taskId = taskId;
    public static class TransportAction extends TransportClusterManagerNodeAction<Request, PersistentTaskResponse> {
     * @opensearch.internal
/*
            ClusterState state,
 *    http://www.apache.org/licenses/LICENSE-2.0
        public int hashCode() {
        public Request() {}
            PersistentTasksClusterService persistentTasksClusterService,
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
                CompletionPersistentTaskAction.NAME,
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {
 * ActionType that is used by executor node to indicate that the persistent action finished or failed on the node and needs to be
            if (taskId == null) {
     * @opensearch.internal
 * under the License.
 * not use this file except in compliance with the License.
        private String taskId;
        private long allocationId = -1;
/*
        }
import org.opensearch.core.common.io.stream.StreamInput;
            ActionFilters actionFilters,
 *
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import static org.opensearch.action.ValidateActions.addValidationError;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
                Request::new,
    public static class Request extends ClusterManagerNodeRequest<Request> {
        public void writeTo(StreamOutput out) throws IOException {
                request.allocationId,
            IndexNameExpressionResolver indexNameExpressionResolver
     *
 * compatible open source license.
    /**
    }
 */
            TransportService transportService,
            if (o == null || getClass() != o.getClass()) return false;
            ThreadPool threadPool,
        @Override
}
 * this file be licensed under the Apache-2.0 license or a
