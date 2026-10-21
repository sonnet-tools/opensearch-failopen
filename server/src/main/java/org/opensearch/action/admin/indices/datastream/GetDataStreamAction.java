 * GitHub history for details.
 */
 *
        public Response(List<DataStreamInfo> dataStreams) {
                    );
                if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.action.support.TransportIndicesResolvingAction;
            public String getIndexTemplate() {
            return null;
                dataStream.writeTo(out);
         * Data streams information
import org.opensearch.action.support.ActionFilters;
            ClusterService clusterService,
            return ThreadPool.Names.SAME;
            List<String> results = iner.dataStreamNames(clusterState, request.indicesOptions(), request.names);
        public ActionRequestValidationException validate() {
package org.opensearch.action.admin.indices.datastream;
        }
        }
 * You may obtain a copy of the License at
    public static final String NAME = "indices:admin/data_stream/get";
 * under the License.
import org.opensearch.cluster.block.ClusterBlockException;
        @Override
                this.indexTemplate = indexTemplate;
            builder.endObject();
            return results.stream().map(dataStreams::get).sorted(Comparator.comparing(DataStream::getName)).collect(Collectors.toList());
        }
 * this work for additional information regarding copyright
            }
import org.opensearch.cluster.health.ClusterStateHealth;
        @Override
/*
            return new Response(in);
            builder.startArray(DATASTREAMS_FIELD.getPreferredName());
import org.opensearch.action.support.IndicesOptions;
        }
                return Objects.hash(dataStream, dataStreamStatus, indexTemplate);
            return ResolvedIndices.of(
            return Objects.hash(dataStreams);
                return dataStreamStatus;
        public int hashCode() {
        @Override
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {
            return true;
 * the Apache License, Version 2.0 (the "License"); you may
            public DataStreamInfo(StreamInput in) throws IOException {
import org.opensearch.core.index.Index;
            if (o == null || getClass() != o.getClass()) return false;
                builder.field(DataStream.NAME_FIELD.getPreferredName(), dataStream.getName());
                this.dataStream = dataStream;
            // this doesn't really matter since data stream name resolution isn't affected by IndicesOptions and
 * @opensearch.api
/*
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
                builder.endObject();
            public ClusterHealthStatus getDataStreamStatus() {
            }
                builder.startObject();
            }
        }
        public static final ParseField DATASTREAMS_FIELD = new ParseField("data_streams");
     * Request for getting data streams
                if (indexTemplate != null) {
            }
            @Override
                dataStreamInfos.add(new Response.DataStreamInfo(dataStream, streamHealth.getStatus(), indexTemplate));
 */
     *
        }
                builder.field(STATUS_FIELD.getPreferredName(), dataStreamStatus);
        public IndicesOptions indicesOptions() {
        @Override
            Map<String, DataStream> dataStreams = clusterState.metadata().dataStreams();
        @Override
                    && Objects.equals(indexTemplate, that.indexTemplate);
     */
        /**
            @Override
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @PublicApi(since = "1.0.0")
        }
            TransportService transportService,
/*
                    state,
        }
            for (DataStreamInfo dataStream : dataStreams) {
                dataStreamStatus.writeTo(out);
         *
            super(NAME, transportService, clusterService, threadPool, actionFilters, Request::new, indexNameExpressionResolver);
import org.opensearch.cluster.ClusterState;
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.service.ClusterService;
                String ilmPolicyName = null;
            public DataStream getDataStream() {
            return names;
        public List<DataStreamInfo> getDataStreams() {
        @Override
import java.util.ArrayList;
            }
                builder.field(DataStream.INDICES_FIELD.getPreferredName(), dataStream.getIndices());
        public Response(StreamInput in) throws IOException {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        public boolean includeDataStreams() {
/**
import java.util.Comparator;
            return Arrays.equals(names, request.names);
            @Override
     */
    }
                out.writeOptionalString(indexTemplate);
            public int hashCode() {
        }
        }
        public TransportAction(
            }
            List<Response.DataStreamInfo> dataStreamInfos = new ArrayList<>(dataStreams.size());
            TransportIndicesResolvingAction<Request> {
                return dataStream.equals(that.dataStream)
            @Override
            }
            this.names = names;
        public Request(StreamInput in) throws IOException {
            @Nullable
import org.opensearch.core.xcontent.ToXContentObject;
            if (this == o) return true;
import org.opensearch.cluster.AbstractDiffable;
    public static final GetDataStreamAction INSTANCE = new GetDataStreamAction();
        @Override
        @PublicApi(since = "1.0.0")
 *
            IndexNameExpressionResolver indexNameExpressionResolver
     * @opensearch.api
        }
            ActionFilters actionFilters,
                return dataStream;
                    logger.warn(
import org.opensearch.threadpool.ThreadPool;
        @Override
        }
import java.util.Map;
            }
@PublicApi(since = "1.0.0")
        @Override
        public void writeTo(StreamOutput out) throws IOException {
                this.dataStreamStatus = dataStreamStatus;
    }
         * @opensearch.api
        public ResolvedIndices resolveIndices(Request request) {
     *
                return builder;
import java.util.List;
     * Transport Action for getting data streams
            }
            public boolean equals(Object o) {
import org.opensearch.action.ActionRequestValidationException;
                );
            DataStream dataStream;
                dataStream.toXContent(builder, params);
        }
            Response response = (Response) o;
            return IndicesOptions.fromOptions(false, true, true, true, false, false, true, false);
                    && dataStreamStatus == that.dataStreamStatus
                ClusterStateHealth streamHealth = new ClusterStateHealth(
import java.util.Arrays;
import org.apache.logging.log4j.Logger;
            public static final ParseField INDEX_TEMPLATE_FIELD = new ParseField("template");
        public boolean equals(Object o) {
        @Override
            String indexTemplate;
            return Arrays.hashCode(names);
            return builder;
import org.opensearch.core.xcontent.XContentBuilder;
                getDataStreams(clusterService.state(), indexNameExpressionResolver, request).stream()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            this.names = in.readOptionalStringArray();
        private String[] names;
        @Override
    /**
import org.opensearch.core.ParseField;
     *
            return dataStreams;
        protected Response read(StreamInput in) throws IOException {
import org.opensearch.cluster.health.ClusterHealthStatus;
 *
public class GetDataStreamAction extends ActionType<GetDataStreamAction.Response> {
 */
        public int hashCode() {
        protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener) throws Exception {
            out.writeOptionalStringArray(names);
        }
        public static class DataStreamInfo extends AbstractDiffable<DataStreamInfo> implements ToXContentObject {
 * SPDX-License-Identifier: Apache-2.0
            listener.onResponse(new Response(dataStreamInfos));
    public static class TransportAction extends TransportClusterManagerNodeReadAction<Request, Response>
        @Inject
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            for (DataStream dataStream : dataStreams) {
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
                return indexTemplate;
                String indexTemplate = MetadataIndexTemplateService.findV2Template(state.metadata(), dataStream.getName(), false);
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
    public static class Response extends ActionResponse implements ToXContentObject {
    }
                    dataStream.getIndices().stream().map(Index::getName).toArray(String[]::new)
import org.opensearch.action.ActionType;
 * Modifications Copyright OpenSearch Contributors. See
            this.names = indices;
    public static class Request extends ClusterManagerNodeReadRequest<Request> implements IndicesRequest.Replaceable {
                    builder.field(INDEX_TEMPLATE_FIELD.getPreferredName(), indexTemplate);
        public Request(String[] names) {
                            + "from a snapshot?",
        public String[] indices() {
            this(in.readList(DataStreamInfo::new));
            ClusterHealthStatus dataStreamStatus;
                DataStreamInfo that = (DataStreamInfo) o;
            public DataStreamInfo(DataStream dataStream, ClusterHealthStatus dataStreamStatus, @Nullable String indexTemplate) {
                    .map(DataStream::getName)
import org.opensearch.action.IndicesRequest;
    @PublicApi(since = "1.0.0")
 *
                } else {
import org.opensearch.common.Nullable;
        @Override
        }
        @Override
        }
                        dataStream.getName()
 * software distributed under the License is distributed on an
     * @opensearch.internal
            return this;
            }
import org.opensearch.common.annotation.PublicApi;
 * Transport action for getting a datastream
import org.opensearch.core.common.io.stream.StreamInput;
            public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.common.settings.Settings;
    }
 */
            super.writeTo(out);
        }
    /**
        }
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to
            builder.startObject();
            ThreadPool threadPool,
                        "couldn't find any matching template for data stream [{}]. has it been restored (and possibly renamed)"
        ) {
            }
        super(NAME, Response::new);
import org.apache.logging.log4j.LogManager;
        @Override
        public boolean equals(Object o) {
}
import java.util.stream.Collectors;
import org.opensearch.core.action.ActionResponse;
 *     http://www.apache.org/licenses/LICENSE-2.0
            public static final ParseField STATUS_FIELD = new ParseField("status");
                if (indexTemplate != null) {
    private GetDataStreamAction() {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        static List<DataStream> getDataStreams(ClusterState clusterState, IndexNameExpressionResolver iner, Request request) {
                    .collect(Collectors.toList())
            out.writeList(dataStreams);
 * license agreements. See the NOTICE file distributed with
            Request request = (Request) o;
        private static final Logger logger = LogManager.getLogger(TransportAction.class);
import org.opensearch.core.common.io.stream.StreamOutput;
 * not use this file except in compliance with the License.
     * Response for getting data streams
            );
import org.opensearch.core.action.ActionListener;
            if (this == o) return true;
     */
                    Settings settings = MetadataIndexTemplateService.resolveSettings(state.metadata(), indexTemplate);
            return dataStreams.equals(response.dataStreams);
import java.io.IOException;
        }
import org.opensearch.common.inject.Inject;
    /**
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.block.ClusterBlockLevel;
            @Nullable
                builder.field(DataStream.GENERATION_FIELD.getPreferredName(), dataStream.getGeneration());
                }
        }
         */
        @Override
        }
            super(in);
        implements
        }
                }
 * Licensed to Elasticsearch under one or more contributor
        public void writeTo(StreamOutput out) throws IOException {
        public IndicesRequest indices(String... indices) {
import java.util.Objects;
        }
     * @opensearch.api
        private final List<DataStreamInfo> dataStreams;
        }
            this.dataStreams = dataStreams;
            builder.endArray();
        @Override
                    ilmPolicyName = settings.get("index.lifecycle.name");
            List<DataStream> dataStreams = getDataStreams(state, indexNameExpressionResolver, request);
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
                if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.transport.TransportService;
        @Override
            // a data stream's backing indices are retrieved from its metadata
                this(new DataStream(in), ClusterHealthStatus.readFrom(in), in.readOptionalString());
        protected String executor() {
        }
import org.opensearch.cluster.metadata.DataStream;
import org.opensearch.cluster.metadata.ResolvedIndices;
                builder.field(DataStream.TIMESTAMP_FIELD_FIELD.getPreferredName(), dataStream.getTimeStampField());
