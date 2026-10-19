                builder.startObject();
            }
            return true;  
                this.dataStream = dataStream;  
            this.dataStreams = dataStreams;  
            }
        }
            IndexNameExpressionResolver indexNameExpressionResolver
import org.opensearch.cluster.health.ClusterHealthStatus;
        }  
        }  
        }
        public void writeTo(StreamOutput out) throws IOException {  
            super.writeTo(out);
        public Request(String[] names) {
/*
                DataStreamInfo that = (DataStreamInfo) o;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
        }  
 */
        public TransportAction(  
 * specific language governing permissions and limitations
import java.io.IOException;  
    public static class Request extends ClusterManagerNodeReadRequest<Request> implements IndicesRequest.Replaceable {  
 * license agreements. See the NOTICE file distributed with
        public int hashCode() {
import java.util.Comparator;  
            @Nullable
                );
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * software distributed under the License is distributed on an
                this.dataStreamStatus = dataStreamStatus;
        }  
                    logger.warn(
        public Request(StreamInput in) throws IOException {
     * Transport Action for getting data streams
     */
     */
     *
     *  
        }
package org.opensearch.action.admin.indices.datastream;
 *
import org.opensearch.action.support.IndicesOptions;  
    private GetDataStreamAction() {
                String indexTemplate = MetadataIndexTemplateService.findV2Template(state.metadata(), dataStream.getName(), false);
                ClusterStateHealth streamHealth = new ClusterStateHealth(
                    ilmPolicyName = settings.get("index.lifecycle.name");
        @Override
         *  
import org.opensearch.core.xcontent.ToXContentObject;
            public String getIndexTemplate() {  
            if (this == o) return true;
                return dataStream.equals(that.dataStream)
            public static final ParseField INDEX_TEMPLATE_FIELD = new ParseField("template");
        private String[] names;
            if (this == o) return true;  
                } else {  
import org.opensearch.common.Nullable;  
 * Unless required by applicable law or agreed to in writing,
                return dataStreamStatus;
 * under the License.  
            out.writeOptionalStringArray(names);  
            if (o == null || getClass() != o.getClass()) return false;  
            return null;
        @Override  
     * @opensearch.internal  
         * Data streams information
        }
import org.opensearch.action.ActionRequestValidationException;
 * compatible open source license.
                    state,
                dataStreamInfos.add(new Response.DataStreamInfo(dataStream, streamHealth.getStatus(), indexTemplate));
            this.names = names;
         * @opensearch.api
 */
            }  
 */
            Response response = (Response) o;
    /**  
            if (o == null || getClass() != o.getClass()) return false;
            for (DataStream dataStream : dataStreams) {  
            super(NAME, transportService, clusterService, threadPool, actionFilters, Request::new, indexNameExpressionResolver);
                dataStream.writeTo(out);  
 * this work for additional information regarding copyright
            return dataStreams;
 * GitHub history for details.
                dataStream.toXContent(builder, params);  
import java.util.stream.Collectors;
        public boolean equals(Object o) {
        public ResolvedIndices resolveIndices(Request request) {
            Request request = (Request) o;
            @Nullable
 * SPDX-License-Identifier: Apache-2.0
        }
     * Response for getting data streams
        public IndicesOptions indicesOptions() {
                return indexTemplate;
            @Override
                        dataStream.getName()
    public static class Response extends ActionResponse implements ToXContentObject {
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
                }  
        @Override
            return new Response(in);
            public ClusterHealthStatus getDataStreamStatus() {
        }
 * ownership. Elasticsearch licenses this file to you under  
        public Response(StreamInput in) throws IOException {  
            return dataStreams.equals(response.dataStreams);  
                getDataStreams(clusterService.state(), indexNameExpressionResolver, request).stream()
            return results.stream().map(dataStreams::get).sorted(Comparator.comparing(DataStream::getName)).collect(Collectors.toList());
    @PublicApi(since = "1.0.0")  
            String indexTemplate;  
            super(in);
import org.opensearch.core.action.ActionResponse;  
                if (indexTemplate != null) {  
                    Settings settings = MetadataIndexTemplateService.resolveSettings(state.metadata(), indexTemplate);
                    .collect(Collectors.toList())  
    }
            return Objects.hash(dataStreams);
            return Arrays.equals(names, request.names);
 * You may obtain a copy of the License at  
        protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener) throws Exception {  
            public void writeTo(StreamOutput out) throws IOException {
        public Response(List<DataStreamInfo> dataStreams) {
import org.opensearch.cluster.metadata.DataStream;
            }  
    @PublicApi(since = "1.0.0")
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        @Override
        @Override  
                    dataStream.getIndices().stream().map(Index::getName).toArray(String[]::new)  
            return ResolvedIndices.of(  
}
                return builder;
            listener.onResponse(new Response(dataStreamInfos));
        @Override
        }
        super(NAME, Response::new);  
     */
                this.indexTemplate = indexTemplate;
        @Override  
        protected String executor() {
import org.opensearch.core.ParseField;
 * Modifications Copyright OpenSearch Contributors. See  
            ThreadPool threadPool,  
            builder.endObject();  
import org.opensearch.transport.TransportService;
        @Override
                if (this == o) return true;
import java.util.List;
                return Objects.hash(dataStream, dataStreamStatus, indexTemplate);
import org.opensearch.action.ActionType;  
                if (indexTemplate != null) {
     * @opensearch.api
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;  
         */
        }
            for (DataStreamInfo dataStream : dataStreams) {
            return IndicesOptions.fromOptions(false, true, true, true, false, false, true, false);
/*
        }
                out.writeOptionalString(indexTemplate);
        public boolean includeDataStreams() {
 */  
                this(new DataStream(in), ClusterHealthStatus.readFrom(in), in.readOptionalString());  
    public static final String NAME = "indices:admin/data_stream/get";  
        public IndicesRequest indices(String... indices) {
 *
     *
            List<DataStream> dataStreams = getDataStreams(state, indexNameExpressionResolver, request);
        @Override
import org.opensearch.action.support.ActionFilters;
        /**
import org.opensearch.cluster.metadata.ResolvedIndices;
            this(in.readList(DataStreamInfo::new));
                builder.field(DataStream.NAME_FIELD.getPreferredName(), dataStream.getName());
/**  
import org.opensearch.common.inject.Inject;
        }
    }
        public static class DataStreamInfo extends AbstractDiffable<DataStreamInfo> implements ToXContentObject {
        public ActionRequestValidationException validate() {  
                    && dataStreamStatus == that.dataStreamStatus
        ) {  
            // this doesn't really matter since data stream name resolution isn't affected by IndicesOptions and
import org.apache.logging.log4j.LogManager;  
import org.opensearch.cluster.AbstractDiffable;
            ClusterHealthStatus dataStreamStatus;
import org.opensearch.core.action.ActionListener;
                String ilmPolicyName = null;
        }
@PublicApi(since = "1.0.0")
            return ThreadPool.Names.SAME;  
            public DataStreamInfo(DataStream dataStream, ClusterHealthStatus dataStreamStatus, @Nullable String indexTemplate) {
                if (o == null || getClass() != o.getClass()) return false;
public class GetDataStreamAction extends ActionType<GetDataStreamAction.Response> {  
        @Override
        }
            builder.startArray(DATASTREAMS_FIELD.getPreferredName());
 *
        }  
            builder.startObject();  
            public int hashCode() {
            return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
            public DataStreamInfo(StreamInput in) throws IOException {
        }
        }  
            }  
        public List<DataStreamInfo> getDataStreams() {
            TransportService transportService,
            List<Response.DataStreamInfo> dataStreamInfos = new ArrayList<>(dataStreams.size());
        @Override  
     * @opensearch.api  
import org.opensearch.cluster.ClusterState;
            public boolean equals(Object o) {  
     * Request for getting data streams
import org.opensearch.threadpool.ThreadPool;  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.block.ClusterBlockLevel;
                builder.endObject();
import org.opensearch.core.common.io.stream.StreamInput;
                builder.field(DataStream.GENERATION_FIELD.getPreferredName(), dataStream.getGeneration());
        public boolean equals(Object o) {
import org.opensearch.common.settings.Settings;  
    public static final GetDataStreamAction INSTANCE = new GetDataStreamAction();
import java.util.Map;
 * Transport action for getting a datastream
        @Inject
        public static final ParseField DATASTREAMS_FIELD = new ParseField("data_streams");
            // a data stream's backing indices are retrieved from its metadata  
import org.opensearch.cluster.block.ClusterBlockException;  
            Map<String, DataStream> dataStreams = clusterState.metadata().dataStreams();  
                dataStreamStatus.writeTo(out);
                }  
            @Override  
            return Arrays.hashCode(names);
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.action.IndicesRequest;
                        "couldn't find any matching template for data stream [{}]. has it been restored (and possibly renamed)"
        }
        public void writeTo(StreamOutput out) throws IOException {
            this.names = indices;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
            public DataStream getDataStream() {  
        public String[] indices() {
import org.opensearch.core.index.Index;  
        implements  
 * The OpenSearch Contributors require contributions made to  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.Arrays;
                    );
            ActionFilters actionFilters,
 * not use this file except in compliance with the License.
            }  
        public int hashCode() {  
 * @opensearch.api  
            @Override
    }
        protected Response read(StreamInput in) throws IOException {
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {  
            @Override
        @Override  
            out.writeList(dataStreams);
                builder.field(STATUS_FIELD.getPreferredName(), dataStreamStatus);  
        private final List<DataStreamInfo> dataStreams;  
            return builder;
        @Override
            }
import org.opensearch.core.common.io.stream.StreamOutput;
            }
            public static final ParseField STATUS_FIELD = new ParseField("status");  
                            + "from a snapshot?",  
                    builder.field(INDEX_TEMPLATE_FIELD.getPreferredName(), indexTemplate);
import org.opensearch.action.support.TransportIndicesResolvingAction;
            return names;  
            return this;  
                    .map(DataStream::getName)
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            DataStream dataStream;  
    /**  
            TransportIndicesResolvingAction<Request> {
        private static final Logger logger = LogManager.getLogger(TransportAction.class);  
 * KIND, either express or implied.  See the License for the
                    && Objects.equals(indexTemplate, that.indexTemplate);  
                builder.field(DataStream.INDICES_FIELD.getPreferredName(), dataStream.getIndices());
/*  
            List<String> results = iner.dataStreamNames(clusterState, request.indicesOptions(), request.names);
        @Override
import java.util.Objects;  
 * this file be licensed under the Apache-2.0 license or a
            }
            this.names = in.readOptionalStringArray();  
        }
            builder.endArray();
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.ArrayList;
        @Override
            }  
        static List<DataStream> getDataStreams(ClusterState clusterState, IndexNameExpressionResolver iner, Request request) {
            );
        @Override  
            ClusterService clusterService,
        }
                return dataStream;
        @Override
import org.opensearch.cluster.health.ClusterStateHealth;  
                builder.field(DataStream.TIMESTAMP_FIELD_FIELD.getPreferredName(), dataStream.getTimeStampField());  
        }
    public static class TransportAction extends TransportClusterManagerNodeReadAction<Request, Response>
 *  
import org.apache.logging.log4j.Logger;
        }
        }
        @PublicApi(since = "1.0.0")  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;  
