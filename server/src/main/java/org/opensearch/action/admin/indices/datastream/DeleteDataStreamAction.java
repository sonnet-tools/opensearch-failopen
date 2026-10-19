        public String[] indices() {
                        listener.onFailure(e);  
    public static class Request extends ClusterManagerNodeRequest<Request> implements IndicesRequest.Replaceable {
        protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<AcknowledgedResponse> listener)
                }
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
                        dataStreams.add(dataStreamName);
            return Arrays.equals(names, request.names);
    }
        }
        protected AcknowledgedResponse read(StreamInput in) throws IOException {  
import org.opensearch.core.action.ActionListener;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            TransportIndicesResolvingAction<Request> {
        private static Set<String> resolveDataStreams(ClusterState state, Request request) {  
                    @Override
import org.opensearch.cluster.metadata.MetadataDeleteIndexService;  
    }
            return true;
            for (String ds : dataStreams) {  
import org.opensearch.cluster.metadata.Metadata;
import static org.opensearch.cluster.service.ClusterManagerTask.REMOVE_DATA_STREAM;  
            // a data stream's backing indices are retrieved from its metadata
            return ThreadPool.Names.SAME;
                    }
        }
                        + ". Try again after snapshot finishes or cancel the currently running snapshot."
        @Override
            for (String name : request.names) {
    public static final String NAME = "indices:admin/data_stream/delete";
            // TODO: change order when delete index api also updates the data stream the index to be removed is member of
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {  
            return Arrays.hashCode(names);  
            if (CollectionUtils.isEmpty(names)) {  
        }
/*
        private final ClusterManagerTaskThrottler.ThrottlingKey removeDataStreamTaskKey;
 *  
import java.util.Set;  
            Request request = (Request) o;  
            this.names = in.readStringArray();
                    "Cannot delete data streams that are being snapshotted: "  
            // (this to avoid data stream validation from failing when deleting an index that is part of a data stream
     * @opensearch.internal  
import org.opensearch.cluster.service.ClusterService;  
        @Override  
            return names;
            super(in);
                        + snapshottingDataStreams
        super(NAME, AcknowledgedResponse::new);
                        return removeDataStream(deleteIndexService, currentState, request);
import org.opensearch.cluster.metadata.ResolvedIndices;
        @Override
            return dataStreams;  
 * specific language governing permissions and limitations
import java.util.Arrays;  
            Metadata.Builder metadata = Metadata.builder(currentState.metadata());
        @Override  
     * @opensearch.api
import java.io.IOException;
            ActionRequestValidationException validationException = null;
            super.writeTo(out);
        private String[] names;  
        }
 * @opensearch.api
import org.opensearch.snapshots.SnapshotsService;
import org.opensearch.core.common.io.stream.StreamInput;
                        listener.onResponse(new AcknowledgedResponse(true));  
                    public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        }  
        @Override
import org.opensearch.transport.TransportService;  
import org.opensearch.common.annotation.PublicApi;
                    @Override
                    @Override
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
     */
    private DeleteDataStreamAction() {  
            return new AcknowledgedResponse(in);
                    @Override
import org.opensearch.common.inject.Inject;  
            for (String dataStreamName : dataStreams) {
 * not use this file except in compliance with the License.
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        private final MetadataDeleteIndexService deleteIndexService;  
import org.opensearch.action.support.ActionFilters;
                    public TimeValue timeout() {  
            ActionFilters actionFilters,
@PublicApi(since = "1.0.0")
 * this file be licensed under the Apache-2.0 license or a
 */
 * GitHub history for details.
import org.opensearch.core.index.Index;
                backingIndicesToRemove.addAll(dataStream.getIndices());
            }
            return deleteIndexService.deleteIndices(currentState, backingIndicesToRemove);
        @Override
            if (snapshottingDataStreams.isEmpty() == false) {
                    }
            if (this == o) return true;
            Set<String> dataStreams = resolveDataStreams(currentState, request);
        static ClusterState removeDataStream(MetadataDeleteIndexService deleteIndexService, ClusterState currentState, Request request) {  
                for (String dataStreamName : state.metadata().dataStreams().keySet()) {  
        public ActionRequestValidationException validate() {
        @Override
            // first delete the data streams and then the indices:
import org.opensearch.core.common.util.CollectionUtils;
import org.opensearch.cluster.ClusterState;
import static org.opensearch.action.ValidateActions.addValidationError;
 * license agreements. See the NOTICE file distributed with
            this.names = indices;
            }
                    }
/*  
        public Request(StreamInput in) throws IOException {  
public class DeleteDataStreamAction extends ActionType<AcknowledgedResponse> {
 */  
        ) {
        public TransportAction(
        public boolean includeDataStreams() {
        public boolean equals(Object o) {  
            return validationException;  
            if (o == null || getClass() != o.getClass()) return false;
import org.apache.logging.log4j.Logger;
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
                DataStream dataStream = currentState.metadata().dataStreams().get(dataStreamName);
 *
 */  
                    }
    /**
                    @Override  
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import java.util.Objects;
            ClusterService clusterService,  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.snapshots.SnapshotInProgressException;  
import org.opensearch.action.IndicesRequest;
                assert dataStream != null;  
            IndexNameExpressionResolver indexNameExpressionResolver,  
            );  
        }
                    public void onFailure(String source, Exception e) {
            Set<Index> backingIndicesToRemove = new HashSet<>();  
            out.writeStringArray(names);
        }  
        }
        implements  
import org.opensearch.common.unit.TimeValue;
            super(NAME, transportService, clusterService, threadPool, actionFilters, Request::new, indexNameExpressionResolver);  
    private static final Logger logger = LogManager.getLogger(DeleteDataStreamAction.class);
     * Request for deleting data streams
            currentState = ClusterState.builder(currentState).metadata(metadata).build();
     */
        }  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import java.util.HashSet;
                        return request.clusterManagerNodeTimeout();
                    }  
        @Override
                logger.info("removing data stream [{}]", ds);
import org.opensearch.action.ActionType;  
    }
package org.opensearch.action.admin.indices.datastream;
        @Inject  
        @Override  
            return IndicesOptions.fromOptions(false, true, true, true, false, false, true, false);  
}
 */
                    if (Regex.simpleMatch(name, dataStreamName)) {
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.core.common.Strings;
                metadata.removeDataStream(ds);
        }
                    public ClusterState execute(ClusterState currentState) {  
        protected String executor() {
            throws Exception {  
 * Transport action for deleting a datastream  
            this.names = Objects.requireNonNull(names);  
 * Modifications Copyright OpenSearch Contributors. See  
 * under the License.  
        }
 * software distributed under the License is distributed on an
     * Transport action for deleting data streams
        }  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
                validationException = addValidationError("no data stream(s) specified", validationException);
 *     http://www.apache.org/licenses/LICENSE-2.0
        public ResolvedIndices resolveIndices(Request request) {
    public static final DeleteDataStreamAction INSTANCE = new DeleteDataStreamAction();  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
/**
        public IndicesRequest indices(String... indices) {  
            ThreadPool threadPool,
            Set<String> snapshottingDataStreams = new HashSet<>(SnapshotsService.snapshottingDataStreams(currentState, dataStreams));
                "remove-data-stream [" + Strings.arrayToCommaDelimitedString(request.names) + "]",
            TransportService transportService,
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.common.regex.Regex;
import org.opensearch.cluster.ClusterStateUpdateTask;  
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
            }
        @Override
        public void writeTo(StreamOutput out) throws IOException {  
    @PublicApi(since = "1.0.0")  
                        return removeDataStreamTaskKey;
            this.deleteIndexService = deleteIndexService;
        @Override  
import org.opensearch.action.ActionRequestValidationException;
 * SPDX-License-Identifier: Apache-2.0
 *
            MetadataDeleteIndexService deleteIndexService
            Set<String> dataStreams = new HashSet<>();
                new ClusterStateUpdateTask(Priority.HIGH) {  
            }
 * the Apache License, Version 2.0 (the "License"); you may
            removeDataStreamTaskKey = clusterService.registerClusterManagerTask(REMOVE_DATA_STREAM, true);  
import org.opensearch.action.support.IndicesOptions;  
import org.opensearch.threadpool.ThreadPool;
                );  
            return this;
import org.opensearch.cluster.metadata.DataStream;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.Priority;
        public Request(String[] names) {
            }  
        public IndicesOptions indicesOptions() {  
                }
            // without updating the data stream)  
            // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
     *  
        @Override
 *
 * this work for additional information regarding copyright
import org.apache.logging.log4j.LogManager;  
                    }  
        }  
        public int hashCode() {
        }
 * You may obtain a copy of the License at  
        @Override
     *
            clusterService.submitStateUpdateTask(
        }  
import org.opensearch.core.common.io.stream.StreamOutput;  
            return ResolvedIndices.of(resolveDataStreams(clusterService.state(), request));  
                throw new SnapshotInProgressException(
            // this doesn't really matter since data stream name resolution isn't affected by IndicesOptions and
        }
import org.opensearch.action.support.TransportIndicesResolvingAction;
/*
        }
    public static class TransportAction extends TransportClusterManagerNodeAction<Request, AcknowledgedResponse>
    /**  
        }  
