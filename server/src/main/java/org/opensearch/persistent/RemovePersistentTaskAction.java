    private RemovePersistentTaskAction() {
 * license agreements. See the NOTICE file distributed with
        protected String executor() {
import org.opensearch.cluster.block.ClusterBlockLevel;
                Request::new,
        }
/*
 * under the License.  
        }
import org.opensearch.action.ActionRequestValidationException;  
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {  
        }  
     * @opensearch.internal
 */
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        public void setTaskId(String taskId) {
            if (o == null || getClass() != o.getClass()) return false;
        }
    }
        }  
        @Override
 * not use this file except in compliance with the License.
}
        public Request(StreamInput in) throws IOException {
        }  
            this.persistentTasksClusterService = persistentTasksClusterService;
import org.opensearch.core.common.io.stream.StreamInput;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.block.ClusterBlockException;
 * KIND, either express or implied.  See the License for the
/**
     */
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
 */
    /**
                threadPool,
     */
 *  
            this.taskId = taskId;  
        public int hashCode() {
     * @opensearch.internal  
     * @opensearch.internal
    /**  
import org.opensearch.threadpool.ThreadPool;  
            IndexNameExpressionResolver indexNameExpressionResolver
            if (this == o) return true;
    public static class Request extends ClusterManagerNodeRequest<Request> {
    /**
 * Transport action to remove a persistent task
import org.opensearch.core.common.io.stream.StreamOutput;
/*
            ActionFilters actionFilters,  
        }
        public Request(String taskId) {
 * specific language governing permissions and limitations
        }
 * GitHub history for details.
 */  
 */
        @Override  
                clusterService,
     * The transport action.
            return null;
/*  
                )
    }
 *
            return Objects.hash(taskId);  
 * @opensearch.internal
        @Inject
        @Override  
        }  
    public static class RequestBuilder extends ClusterManagerNodeOperationRequestBuilder<Request, PersistentTaskResponse, RequestBuilder> {  
    public static final String NAME = "cluster:admin/persistent/remove";  
 *  
import org.opensearch.transport.TransportService;
 *
            return Objects.equals(taskId, request.taskId);
        }
        public ActionRequestValidationException validate() {
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;  
                request.taskId,  
import org.opensearch.cluster.service.ClusterService;
public class RemovePersistentTaskAction extends ActionType<PersistentTaskResponse> {  
            TransportService transportService,  
        ) {
        public Request() {}  
import org.opensearch.action.ActionType;
                actionFilters,  
import org.opensearch.transport.client.OpenSearchClient;
 *    http://www.apache.org/licenses/LICENSE-2.0
     *  
            PersistentTasksClusterService persistentTasksClusterService,
            final Request request,
        @Override
                transportService,  
            out.writeString(taskId);  
        }  
            super(client, action, new Request());  
        public final RequestBuilder setTaskId(String taskId) {  
        protected RequestBuilder(OpenSearchClient client, RemovePersistentTaskAction action) {
 * Modifications Copyright OpenSearch Contributors. See  
            );  
 * this work for additional information regarding copyright
        @Override
            );
            taskId = in.readString();
        }
import java.util.Objects;
 * this file be licensed under the Apache-2.0 license or a
            Request request = (Request) o;  
            ClusterService clusterService,
 * compatible open source license.
        @Override  
            super(in);  
     *
 * SPDX-License-Identifier: Apache-2.0
        @Override
    public static class TransportAction extends TransportClusterManagerNodeAction<Request, PersistentTaskResponse> {  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
    }
                    listener,
            return ThreadPool.Names.MANAGEMENT;  
                indexNameExpressionResolver
        public void writeTo(StreamOutput out) throws IOException {
            ThreadPool threadPool,
     * The request.
        public boolean equals(Object o) {  
            this.taskId = taskId;
     *  
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                ActionListener.delegateFailure(
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.ClusterState;  
        private String taskId;
            ClusterState state,
        }
     * The request builder.
 * the Apache License, Version 2.0 (the "License"); you may
        super(NAME, PersistentTaskResponse::new);  
            return this;
            // Cluster is not affected but we look up repositories in metadata
 * software distributed under the License is distributed on an
            super(
                RemovePersistentTaskAction.NAME,
 * Licensed to Elasticsearch under one or more contributor  
        protected PersistentTaskResponse read(StreamInput in) throws IOException {
        }  
        private final PersistentTasksClusterService persistentTasksClusterService;
        ) {  
    }
            request.setTaskId(taskId);
import org.opensearch.core.action.ActionListener;  
            persistentTasksClusterService.removePersistentTask(
    public static final RemovePersistentTaskAction INSTANCE = new RemovePersistentTaskAction();
            super.writeTo(out);
            return new PersistentTaskResponse(in);
     */
 * You may obtain a copy of the License at  
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
package org.opensearch.persistent;
                    (delegatedListener, task) -> delegatedListener.onResponse(new PersistentTaskResponse(task))  
        public TransportAction(
import org.opensearch.common.inject.Inject;
        protected final void clusterManagerOperation(  
            final ActionListener<PersistentTaskResponse> listener  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
