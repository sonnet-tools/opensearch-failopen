        @Override
            TransportIndicesResolvingAction<Request> {
        public IndicesRequest indices(String... indices) {
                    }
        }
    private DeleteDataStreamAction() {
            // first delete the data streams and then the indices:
import org.opensearch.core.common.io.stream.StreamInput;
            if (CollectionUtils.isEmpty(names)) {
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
import java.io.IOException;
        }
            // without updating the data stream)
                throw new SnapshotInProgressException(
            return true;
/*
            return validationException;
                    public TimeValue timeout() {
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
            super(in);
                    public void onFailure(String source, Exception e) {
     */
            this.names = Objects.requireNonNull(names);
        static ClusterState removeDataStream(MetadataDeleteIndexService deleteIndexService, ClusterState currentState, Request request) {
            return dataStreams;
import org.opensearch.action.ActionType;
     * Request for deleting data streams
        @Override
                new ClusterStateUpdateTask(Priority.HIGH) {
 */
            }
        @Override
                    public ClusterState execute(ClusterState currentState) {
                }
        public boolean equals(Object o) {
            return Arrays.hashCode(names);
            Request request = (Request) o;
import org.opensearch.core.index.Index;
        }
            return IndicesOptions.fromOptions(false, true, true, true, false, false, true, false);
            return ResolvedIndices.of(resolveDataStreams(clusterService.state(), request));
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
            }
            for (String ds : dataStreams) {
                    @Override
                    }
import org.opensearch.action.support.IndicesOptions;
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
            return this;
 *
            Metadata.Builder metadata = Metadata.builder(currentState.metadata());
        }
        @Override
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        public ActionRequestValidationException validate() {
import org.opensearch.transport.TransportService;
        public IndicesOptions indicesOptions() {
            }
                DataStream dataStream = currentState.metadata().dataStreams().get(dataStreamName);
            throws Exception {
        private final MetadataDeleteIndexService deleteIndexService;
            super(NAME, transportService, clusterService, threadPool, actionFilters, Request::new, indexNameExpressionResolver);
        }
            ThreadPool threadPool,
            for (String name : request.names) {
     * @opensearch.api
            Set<String> dataStreams = resolveDataStreams(currentState, request);
            MetadataDeleteIndexService deleteIndexService
            return names;
        }
 * specific language governing permissions and limitations
import org.opensearch.action.support.TransportIndicesResolvingAction;
        private String[] names;
                        dataStreams.add(dataStreamName);
        }
import org.opensearch.cluster.ClusterStateUpdateTask;
            out.writeStringArray(names);
import org.opensearch.action.support.ActionFilters;
                assert dataStream != null;
import org.opensearch.common.regex.Regex;
 * not use this file except in compliance with the License.
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
 * under the License.
import org.opensearch.cluster.block.ClusterBlockLevel;
            Set<Index> backingIndicesToRemove = new HashSet<>();
            ClusterService clusterService,
                    }
        }
        }
            ActionFilters actionFilters,
            Set<String> snapshottingDataStreams = new HashSet<>(SnapshotsService.snapshottingDataStreams(currentState, dataStreams));
            if (o == null || getClass() != o.getClass()) return false;
 *
            return ThreadPool.Names.SAME;
import org.opensearch.cluster.metadata.MetadataDeleteIndexService;
    public static class Request extends ClusterManagerNodeRequest<Request> implements IndicesRequest.Replaceable {
            clusterService.submitStateUpdateTask(
            // a data stream's backing indices are retrieved from its metadata
import org.opensearch.cluster.metadata.ResolvedIndices;
                        + ". Try again after snapshot finishes or cancel the currently running snapshot."
        @Override
            // TODO: change order when delete index api also updates the data stream the index to be removed is member of
     *
        private static Set<String> resolveDataStreams(ClusterState state, Request request) {
        public TransportAction(
public class DeleteDataStreamAction extends ActionType<AcknowledgedResponse> {
import org.opensearch.common.unit.TimeValue;
            if (this == o) return true;
 * this file be licensed under the Apache-2.0 license or a
 *
        @Override
package org.opensearch.action.admin.indices.datastream;
    }
import org.opensearch.cluster.metadata.Metadata;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to
        public ResolvedIndices resolveIndices(Request request) {
import org.opensearch.action.IndicesRequest;
            // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
     * Transport action for deleting data streams
import org.opensearch.cluster.metadata.DataStream;
            TransportService transportService,
 */
 * license agreements. See the NOTICE file distributed with
/*
                    @Override
                for (String dataStreamName : state.metadata().dataStreams().keySet()) {
import org.apache.logging.log4j.Logger;
 * software distributed under the License is distributed on an
    public static final String NAME = "indices:admin/data_stream/delete";
        @Override
            );
 */
import org.apache.logging.log4j.LogManager;
        }
 * @opensearch.api
    @PublicApi(since = "1.0.0")
                    }
import java.util.HashSet;
        @Override
 * this work for additional information regarding copyright
                        listener.onFailure(e);
            // this doesn't really matter since data stream name resolution isn't affected by IndicesOptions and
import java.util.Arrays;
import org.opensearch.snapshots.SnapshotInProgressException;
 * compatible open source license.
 * Transport action for deleting a datastream
            removeDataStreamTaskKey = clusterService.registerClusterManagerTask(REMOVE_DATA_STREAM, true);
        public Request(String[] names) {
 * KIND, either express or implied.  See the License for the
    /**
 */
        public void writeTo(StreamOutput out) throws IOException {
        @Override
                        + snapshottingDataStreams
    }
        }
            return deleteIndexService.deleteIndices(currentState, backingIndicesToRemove);
                }
                        return removeDataStream(deleteIndexService, currentState, request);
/*
 * ownership. Elasticsearch licenses this file to you under
        }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            return new AcknowledgedResponse(in);
        @Override
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {
    public static class TransportAction extends TransportClusterManagerNodeAction<Request, AcknowledgedResponse>
                    if (Regex.simpleMatch(name, dataStreamName)) {
}
import static org.opensearch.cluster.service.ClusterManagerTask.REMOVE_DATA_STREAM;
        @Override
                validationException = addValidationError("no data stream(s) specified", validationException);
            this.names = in.readStringArray();
import org.opensearch.common.inject.Inject;
import java.util.Set;
     * @opensearch.internal
        @Inject
import org.opensearch.cluster.service.ClusterService;
    public static final DeleteDataStreamAction INSTANCE = new DeleteDataStreamAction();
import org.opensearch.core.action.ActionListener;
                        listener.onResponse(new AcknowledgedResponse(true));
                metadata.removeDataStream(ds);
@PublicApi(since = "1.0.0")
        }
        }
        }
import org.opensearch.common.Priority;
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            currentState = ClusterState.builder(currentState).metadata(metadata).build();
                backingIndicesToRemove.addAll(dataStream.getIndices());
        }
import static org.opensearch.action.ValidateActions.addValidationError;
import org.opensearch.core.common.Strings;
        protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<AcknowledgedResponse> listener)
     *
                    }
        public int hashCode() {
/**
    /**
                        return request.clusterManagerNodeTimeout();
                        return removeDataStreamTaskKey;
            if (snapshottingDataStreams.isEmpty() == false) {
        protected String executor() {
            this.names = indices;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                    @Override
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.block.ClusterBlockException;
    }
        super(NAME, AcknowledgedResponse::new);
        ) {
        @Override
import org.opensearch.threadpool.ThreadPool;
            Set<String> dataStreams = new HashSet<>();
                );
            }
            return Arrays.equals(names, request.names);
            // (this to avoid data stream validation from failing when deleting an index that is part of a data stream
 *
                    public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
import java.util.Objects;
                    @Override
        @Override
        public boolean includeDataStreams() {
     */
import org.opensearch.snapshots.SnapshotsService;
    private static final Logger logger = LogManager.getLogger(DeleteDataStreamAction.class);
            super.writeTo(out);
            ActionRequestValidationException validationException = null;
                "remove-data-stream [" + Strings.arrayToCommaDelimitedString(request.names) + "]",
                logger.info("removing data stream [{}]", ds);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public Request(StreamInput in) throws IOException {
 * You may obtain a copy of the License at
        private final ClusterManagerTaskThrottler.ThrottlingKey removeDataStreamTaskKey;
        protected AcknowledgedResponse read(StreamInput in) throws IOException {
        }
 * Unless required by applicable law or agreed to in writing,
                    }
 * Modifications Copyright OpenSearch Contributors. See
            this.deleteIndexService = deleteIndexService;
import org.opensearch.common.annotation.PublicApi;
            IndexNameExpressionResolver indexNameExpressionResolver,
            for (String dataStreamName : dataStreams) {
            }
        public String[] indices() {
import org.opensearch.core.common.util.CollectionUtils;
                    "Cannot delete data streams that are being snapshotted: "
        implements
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.ActionRequestValidationException;
        }
                    @Override
