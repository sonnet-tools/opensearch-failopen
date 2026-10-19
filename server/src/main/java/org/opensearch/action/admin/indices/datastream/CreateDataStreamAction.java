        }
        public void writeTo(StreamOutput out) throws IOException {
            return Objects.hash(name);
 * The OpenSearch Contributors require contributions made to  
            return IndicesOptions.strictSingleIndexNoExpandForbidClosed();  
        @Inject  
 * under the License.  
        @Override
        }  
import org.opensearch.cluster.metadata.MetadataCreateDataStreamService.CreateDataStreamClusterStateUpdateRequest;  
            metadataCreateDataStreamService.createDataStream(updateRequest, listener);
        @Override
            this.name = name;
}  
import org.opensearch.action.support.TransportIndicesResolvingAction;  
    public static class Request extends AcknowledgedRequest<Request> implements IndicesRequest {  
     */
    public static final CreateDataStreamAction INSTANCE = new CreateDataStreamAction();
import org.opensearch.action.ActionRequestValidationException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        @Override
            return name.equals(request.name);  
import org.opensearch.action.support.IndicesOptions;
 */  
        private final String name;
public class CreateDataStreamAction extends ActionType<AcknowledgedResponse> {  
        ) {
 * Licensed to Elasticsearch under one or more contributor  
            if (Strings.hasText(name) == false) {
import org.opensearch.cluster.block.ClusterBlockException;
/**  
            ClusterService clusterService,  
 * compatible open source license.
            return ThreadPool.Names.SAME;  
 * specific language governing permissions and limitations
import org.opensearch.cluster.block.ClusterBlockLevel;  
 */
/*
        }
    public static final String NAME = "indices:admin/data_stream/create";  
    /**  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
package org.opensearch.action.admin.indices.datastream;
            TransportIndicesResolvingAction<Request> {
                request.timeout()
        super(NAME, AcknowledgedResponse::new);  
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {
        public String[] indices() {  
 * this work for additional information regarding copyright
        public ResolvedIndices resolveIndices(Request request) {
            super(NAME, transportService, clusterService, threadPool, actionFilters, Request::new, indexNameExpressionResolver);  
        protected AcknowledgedResponse read(StreamInput in) throws IOException {
import org.opensearch.core.common.Strings;  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            );  
import org.opensearch.common.annotation.PublicApi;  
 * SPDX-License-Identifier: Apache-2.0
    private CreateDataStreamAction() {
 * this file be licensed under the Apache-2.0 license or a
            MetadataCreateDataStreamService metadataCreateDataStreamService
        }  
 */
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.cluster.service.ClusterService;
            throws Exception {
     *  
        }
/*
        @Override
        @Override  
        }
 * Modifications Copyright OpenSearch Contributors. See  
            }
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
     *
        protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<AcknowledgedResponse> listener)  
     * @opensearch.internal
        @Override
import java.util.Objects;
            if (this == o) return true;  
            ActionFilters actionFilters,
        public TransportAction(
 * GitHub history for details.
            return new String[] { name };
            CreateDataStreamClusterStateUpdateRequest updateRequest = new CreateDataStreamClusterStateUpdateRequest(
        }
            out.writeString(name);
            Request request = (Request) o;
        public IndicesOptions indicesOptions() {
 */
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        public boolean equals(Object o) {
            super.writeTo(out);  
/*  
        }
        }
import org.opensearch.core.common.io.stream.StreamInput;
        @Override  
            ActionRequestValidationException validationException = null;
    }
 *  
import org.opensearch.core.action.ActionListener;
import org.opensearch.transport.TransportService;
    }
 * software distributed under the License is distributed on an
        public ActionRequestValidationException validate() {  
        public Request(StreamInput in) throws IOException {
            super(in);  
            this.name = in.readString();
 * ownership. Elasticsearch licenses this file to you under  
        public Request(String name) {
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.support.ActionFilters;
            return new AcknowledgedResponse(in);
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
        @Override  
            TransportService transportService,
     * Transport Action for Creating Data Stream
import org.opensearch.cluster.metadata.MetadataCreateDataStreamService;
            if (o == null || getClass() != o.getClass()) return false;
 * KIND, either express or implied.  See the License for the
        public int hashCode() {
@PublicApi(since = "1.0.0")
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.ResolvedIndices;
import org.opensearch.action.IndicesRequest;
        }  
 *
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
    public static class TransportAction extends TransportClusterManagerNodeAction<Request, AcknowledgedResponse>  
            this.metadataCreateDataStreamService = metadataCreateDataStreamService;
        }  
     */
 * @opensearch.api  
            return validationException;
 * Transport action for creating a datastream
        implements
     * @opensearch.api  
 * You may obtain a copy of the License at  
                request.name,  
        @Override
        }  
import org.opensearch.action.ValidateActions;  
        }
                validationException = ValidateActions.addValidationError("name is missing", validationException);  
        }
import org.opensearch.common.inject.Inject;
                request.clusterManagerNodeTimeout(),
            return ResolvedIndices.of(request.name);
     * Request for Creating Data Stream
    @PublicApi(since = "1.0.0")
            IndexNameExpressionResolver indexNameExpressionResolver,  
import java.io.IOException;  
import org.opensearch.action.ActionType;
            ThreadPool threadPool,
        protected String executor() {
        @Override
 * not use this file except in compliance with the License.
        private final MetadataCreateDataStreamService metadataCreateDataStreamService;
    }
