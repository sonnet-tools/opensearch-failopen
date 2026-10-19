        @Override  
        }  
                    request.indicesOptions,  
            return getName().equals(alias.getName()) && Arrays.equals(indices, alias.indices);
import org.opensearch.common.Nullable;  
import org.opensearch.core.common.Strings;
        /**
            ResolvedAlias alias = (ResolvedAlias) o;
            this.dataStreams = in.readList(ResolvedDataStream::new);  
    public static class TransportAction extends HandledTransportAction<Request, Response>  
            this.names = names;  
import org.opensearch.core.xcontent.XContentBuilder;  
        public String getDataStream() {
                    aliases.add(alias.copy(RemoteClusterAware.buildRemoteIndexName(clusterAlias, alias.getName())));  
    /**
            String indexAbstraction,  
            int result = Objects.hash(getName(), dataStream);  
            result = 31 * result + Arrays.hashCode(attributes);
        // visible for testing
        public boolean equals(Object o) {
import org.opensearch.threadpool.ThreadPool;
                }
            }
            dataStreams.sort(Comparator.comparing(ResolvedIndexAbstraction::getName));
            return true;
                    request.includeDataStreams()  
                        final boolean isFrozen = Boolean.parseBoolean(ia.getWriteIndex().getSettings().get("index.frozen"));
            return dataStream;  
                    indexAbstractionResolver.resolveIndexAbstractions(
                    Request remoteRequest = new Request(originalIndices.indices(), originalIndices.indicesOptions());
     */  
        }
            builder.field(INDICES_FIELD.getPreferredName(), indices);
     * Transport action for resolving an index
        private ResolvedIndices resolvedIndices(Request request, ClusterState clusterState) {  
        }  
                        terminalHandler.run();
    /**  
        }
            return aliases;
                            false
            indices.sort(Comparator.comparing(ResolvedIndexAbstraction::getName));
        public IndicesRequest indices(String... indices) {
                        break;
            List<ResolvedAlias> aliases,
        }
            return Arrays.equals(names, request.names);  
        ) {
            return result;
            return this;  
        }  
                return ResolvedIndices.of(  
                    case CONCRETE_INDEX:  
import org.opensearch.transport.RemoteClusterAware;  
            result = 31 * result + Arrays.hashCode(indices);
            this.threadPool = threadPool;
            out.writeList(dataStreams);
     * The resolved index  
        public String getTimestampField() {
            this.indices = in.readStringArray();  
        private final String[] attributes;  
        @Override
                            attributes.add("frozen");
            ActionFilters actionFilters,  
        public List<ResolvedDataStream> getDataStreams() {
                resolveIndices(
                        IndexAbstraction.Alias alias = (IndexAbstraction.Alias) ia;  
                        IndexAbstraction.DataStream dataStream = (IndexAbstraction.DataStream) ia;  
                    OriginalIndices originalIndices = remoteIndices.getValue();  
                        dataStreams.add(  
/**  
        static final ParseField ALIASES_FIELD = new ParseField("aliases");
        private String[] names;
 */
            this.names = names;
            } else {
            return result;  
        private final RemoteClusterService remoteClusterService;  
        ResolvedDataStream(String name, String[] backingIndices, String timestampField) {  
        public List<ResolvedAlias> getAliases() {
     * The resolved data stream
            super(name);
            return builder;
import org.opensearch.transport.client.Client;  
                        String[] aliasNames = StreamSupport.stream(  
                    dataStreams.add(dataStream.copy(RemoteClusterAware.buildRemoteIndexName(clusterAlias, dataStream.getName())));  
import org.opensearch.action.support.HandledTransportAction;
     *  
        static void resolveIndices(
            setName(in.readString());
        public boolean includeDataStreams() {
 *  
                                index.getName(),
            this.indicesOptions = IndicesOptions.readIndicesOptions(in);  
            this.aliases = in.readList(ResolvedAlias::new);
                final CountDown completionCounter = new CountDown(remoteRequests);  
    public static class ResolvedDataStream extends ResolvedIndexAbstraction implements Writeable, ToXContentObject {
            super(NAME, transportService, actionFilters, Request::new);  
        @Override
     */  
                }
            builder.array(BACKING_INDICES_FIELD.getPreferredName(), backingIndices);
        static final ParseField ALIASES_FIELD = new ParseField("aliases");
                switch (ia.getType()) {
            );  
        public ResolvedAlias copy(String newName) {
                        );  
import org.opensearch.tasks.Task;
        @Override
        private final ClusterService clusterService;
import java.util.Map;
                        listener.onResponse(new Response(indices, aliases, dataStreams));
        }  
                        if (ia.isHidden()) {
     * Abstraction class for resolving an index
            aliases.sort(Comparator.comparing(ResolvedIndexAbstraction::getName));  
         * Resolves the specified names and/or wildcard expressions to index abstractions. Returns results in the supplied lists.  
                    metadata,
            return indices;
            for (Map.Entry<String, Response> responseEntry : remoteResponses.entrySet()) {
            out.writeList(aliases);  
            return new ResolvedAlias(newName, indices);  
        }  
        @Override  
            super(in);
            String[] names,  
     */
 *
            if (this == o) return true;
 * GitHub history for details.
            List<ResolvedIndex> indices,
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                request.indices(),  
 * Unless required by applicable law or agreed to in writing,
            }
     */
        }
import org.opensearch.action.support.ActionFilters;  
         * @param metadata       Cluster metadata
 */  
import org.opensearch.common.util.concurrent.CountDown;  
        @Inject
         * @param aliases        List containing any matching aliases
            if (Strings.isNullOrEmpty(dataStream) == false) {
            Map<String, Response> remoteResponses,  
        }  
                        IndexAbstraction.Index index = (IndexAbstraction.Index) ia;
        public String[] getBackingIndices() {
                builder.array(INDICES_FIELD.getPreferredName(), indices);  
                    indices,  
        public Request(StreamInput in) throws IOException {  
import java.util.Objects;  
                    case DATA_STREAM:
        }  
                    Client remoteClusterClient = remoteClusterService.getRemoteClusterClient(threadPool, clusterAlias);
         * @param indicesOptions Options for expanding wildcards to indices with different states  
            this.timestampField = in.readString();  
import org.opensearch.core.action.ActionResponse;  
 * Licensed to Elasticsearch under one or more contributor  
        private final String[] backingIndices;  
 * not use this file except in compliance with the License.
/*  
        public Request(String[] names) {
                idx -> indexNameExpressionResolver.hasIndexAbstraction(idx, clusterState)
            return Arrays.hashCode(names);
            return builder;
        public ResolvedIndex copy(String newName) {
        public ActionRequestValidationException validate() {
            builder.startObject();  
        static final ParseField BACKING_INDICES_FIELD = new ParseField("backing_indices");  
            this.aliases = aliases;
        }
            SortedMap<String, IndexAbstraction> lookup,
            return aliases;
            IndexAbstraction ia = lookup.get(indexAbstraction);  
            boolean includeDataStreams
                    dataStreams,
            return backingIndices;
         *
        }
                }
            this.backingIndices = backingIndices;
                        Arrays.sort(indexNames);
 * specific language governing permissions and limitations
     */
     *  
        public void writeTo(StreamOutput out) throws IOException {
        private final String timestampField;
    public static class ResolvedIndexAbstraction {
        }  
            return indices.equals(response.indices) && aliases.equals(response.aliases) && dataStreams.equals(response.dataStreams);
            indicesOptions.writeIndicesOptions(out);
    }
            return builder;  
        private String name;  
            List<ResolvedDataStream> dataStreams,  
 * ownership. Elasticsearch licenses this file to you under  
            TransportIndicesResolvingAction<Request> {
        private static void mergeResults(
                        mergeResults(remoteResponses, indices, aliases, dataStreams);
        }
            List<ResolvedIndex> indices = new ArrayList<>();  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import org.opensearch.cluster.ClusterState;
                };
            builder.startObject();  
    }
            if (o == null || getClass() != o.getClass()) return false;
            setName(in.readString());
            int result = Objects.hash(getName(), timestampField);
        @Override
    private ResolveIndexAction() {
                        if (isFrozen) {  
        public Response(StreamInput in) throws IOException {  
        private final String[] indices;
    }
import org.opensearch.cluster.metadata.IndexAbstractionResolver;  
        public ResolvedIndices resolveIndices(Request request) {
                        break;
            builder.endObject();
import java.util.SortedMap;
        @Override  
        private final List<ResolvedIndex> indices;
                    String clusterAlias = remoteIndices.getKey();
import org.opensearch.action.ActionType;  
                    indexAbstractionResolver,
            return timestampField;  
        protected void doExecute(Task task, Request request, final ActionListener<Response> listener) {  
            final ClusterState clusterState = clusterService.state();
            out.writeOptionalString(dataStream);
                && Arrays.equals(aliases, index.aliases)  
        private final String[] aliases;
            }  
import java.io.IOException;
     *
     *
 * under the License.  
            return getName().equals(dataStream.getName())
            Metadata metadata,
            final OriginalIndices localIndices = remoteClusterIndices.remove(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY);
                    case ALIAS:
                && Objects.equals(dataStream, index.dataStream)
            for (String s : resolvedIndexAbstractions) {
                Response response = responseEntry.getValue();
            this.indexAbstractionResolver = new IndexAbstractionResolver(indexNameExpressionResolver);
 * software distributed under the License is distributed on an
            return attributes;
     * @opensearch.api
            if (this == o) return true;
        public static final IndicesOptions DEFAULT_INDICES_OPTIONS = IndicesOptions.strictExpandOpen();
     *  
import org.opensearch.core.xcontent.ToXContentObject;
    @PublicApi(since = "1.0.0")
            this.dataStreams = dataStreams;  
            return names;
            if (indices.length > 0) {
    @PublicApi(since = "1.0.0")
            Response response = (Response) o;  
            builder.endObject();
            this.names = in.readStringArray();
                    if (completionCounter.countDown()) {  
 * @opensearch.api  
                        ).toArray(String[]::new);  
            builder.startObject();
            List<ResolvedAlias> aliases,
            super(name);
                    default:
        public String[] getAttributes() {
 * this file be licensed under the Apache-2.0 license or a
            builder.field(DATA_STREAMS_FIELD.getPreferredName(), dataStreams);  
    }
    public static class Request extends ActionRequest implements IndicesRequest.Replaceable {  
            int result = Objects.hash(getName());
        static final ParseField DATA_STREAM_FIELD = new ParseField("data_stream");  
            return result;  
        @Override
        @Override  
                                dataStream.getDataStream().getTimeStampField().getName()
                String clusterAlias = responseEntry.getKey();  
            ResolvedIndex index = (ResolvedIndex) o;  
import org.opensearch.core.ParseField;
                        attributes.add(index.getWriteIndex().getState() == IndexMetadata.State.OPEN ? "open" : "closed");
            return dataStreams;  
        public boolean equals(Object o) {  
        }
        }
    @PublicApi(since = "1.0.0")  
        }
                for (ResolvedDataStream dataStream : response.dataStreams) {
                            Spliterators.spliteratorUnknownSize(index.getWriteIndex().getAliases().keySet().iterator(), 0),
        }
@PublicApi(since = "1.0.0")
    }
            result = 31 * result + Arrays.hashCode(aliases);
        static final ParseField TIMESTAMP_FIELD = new ParseField("timestamp_field");
     *
import org.opensearch.action.ActionRequestValidationException;
            List<ResolvedDataStream> dataStreams
                        aliases.add(new ResolvedAlias(alias.getName(), indexNames));  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }  
        @Override  
        private static void enrichIndexAbstraction(
        @Override
            if (localIndices != null) {  
import org.opensearch.core.common.io.stream.StreamInput;
            this.indicesOptions = indicesOptions;
            if (this == o) return true;
import java.util.stream.StreamSupport;
                for (Map.Entry<String, OriginalIndices> remoteIndices : remoteClusterIndices.entrySet()) {
        }  
        }
        public boolean equals(Object o) {  
                        Arrays.sort(backingIndices);
         * @param names          The names and wildcard expressions to resolve
            return builder;
        ResolvedAlias(StreamInput in) throws IOException {
        public String[] indices() {  
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.cluster.metadata.IndexAbstraction;
                );
                        indices.add(
            out.writeStringArray(aliases);  
         * @param resolver       Resolver instance for matching names
            );
     * Response for resolving an index  
import org.opensearch.action.support.IndicesOptions;
            builder.startObject();  
        }  
         */  
            return null;  
        }  
            builder.endObject();
        public int hashCode() {  
            }
            TransportService transportService,  
import java.util.TreeMap;  
                && Arrays.equals(backingIndices, dataStream.backingIndices);  
                builder.field(DATA_STREAM_FIELD.getPreferredName(), dataStream);
                return ResolvedIndices.of(Collections.emptySet()).withRemoteIndices(remoteClusterIndices);
                            new ResolvedIndex(  
        public boolean equals(Object o) {  
        }
            this.name = name;  
            Map<String, OriginalIndices> remoteClusterIndices = remoteClusterService.groupIndices(
        }
            this.name = name;
            }
            builder.field(NAME_FIELD.getPreferredName(), getName());
            out.writeStringArray(indices);
            ThreadPool threadPool,
            ClusterService clusterService,
                    }  
        public ResolvedDataStream copy(String newName) {  
import org.opensearch.common.annotation.PublicApi;
            out.writeString(getName());
                        throw new IllegalStateException("unknown index abstraction type: " + ia.getType());  
        private final List<ResolvedAlias> aliases;  
        }
import org.opensearch.action.IndicesRequest;
        @Override
        }
        @Override  
        }
            OriginalIndices localIndices = remoteClusterIndices.remove(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY);  
    public static class ResolvedAlias extends ResolvedIndexAbstraction implements Writeable, ToXContentObject {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this.attributes = in.readStringArray();  
                ).withRemoteIndices(remoteClusterIndices);
        private final List<ResolvedDataStream> dataStreams;
                builder.array(ALIASES_FIELD.getPreferredName(), aliases);
        }
     * @opensearch.api  
import org.opensearch.cluster.metadata.ResolvedIndices;
        ResolvedIndexAbstraction() {}
        }
            this.dataStream = in.readOptionalString();
 * You may obtain a copy of the License at  
        public Request(String[] names, IndicesOptions indicesOptions) {
        }  
                        clusterState.metadata(),
    }  
                request.indices(),
import org.opensearch.action.support.TransportIndicesResolvingAction;  
            this.clusterService = clusterService;
            builder.field(NAME_FIELD.getPreferredName(), getName());
        public Response(List<ResolvedIndex> indices, List<ResolvedAlias> aliases, List<ResolvedDataStream> dataStreams) {  
 * The OpenSearch Contributors require contributions made to  
        }
        ResolvedIndexAbstraction(String name) {
            }
            return indices;
                final SortedMap<String, Response> remoteResponses = Collections.synchronizedSortedMap(new TreeMap<>());
            return getName().equals(index.getName())
            out.writeString(timestampField);
    /**
        ResolvedIndex(String name, String[] aliases, String[] attributes, @Nullable String dataStream) {
            return new ResolvedDataStream(newName, backingIndices, timestampField);
                            )
 *
        public String[] getAliases() {  
        static final ParseField NAME_FIELD = new ParseField("name");
            super(name);
 */  
                    aliases,
                && timestampField.equals(dataStream.timestampField)
            this.dataStream = dataStream;
        }
        private final ThreadPool threadPool;
            }
        public int hashCode() {
public class ResolveIndexAction extends ActionType<ResolveIndexAction.Response> {  
import java.util.Collections;
        @Override  
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
         * @param dataStreams    List containing any matching data streams
}
            out.writeString(getName());  
import org.opensearch.cluster.metadata.IndexMetadata;
            if (localIndices != null) {
        @Override
            if (this == o) return true;  
package org.opensearch.action.admin.indices.resolve;
        private IndicesOptions indicesOptions = DEFAULT_INDICES_OPTIONS;
 * KIND, either express or implied.  See the License for the
        public TransportAction(
import org.opensearch.transport.TransportService;
            builder.field(TIMESTAMP_FIELD.getPreferredName(), timestampField);  
            List<ResolvedDataStream> dataStreams  
            out.writeList(indices);
    public static class Response extends ActionResponse implements ToXContentObject {
            result = 31 * result + Arrays.hashCode(backingIndices);  
        }
                    )
        private final IndexAbstractionResolver indexAbstractionResolver;
        @Override
                                backingIndices,  
        super(NAME, Response::new);  
        public String[] getIndices() {  
                                attributes.toArray(Strings.EMPTY_ARRAY),  
     * @opensearch.api
import org.opensearch.action.OriginalIndices;
        }  
import java.util.ArrayList;  
        public int hashCode() {
import org.opensearch.action.ActionRequest;
                idx -> indexNameExpressionResolver.hasIndexAbstraction(idx, clusterState)
                        }
            } else {  
            this.indices = indices;
        }
import org.opensearch.core.action.ActionListener;
            setName(in.readString());
            }
import org.opensearch.cluster.metadata.Metadata;  
                        request.includeDataStreams(),
                }
        static final ParseField INDICES_FIELD = new ParseField("indices");
        static final ParseField DATA_STREAMS_FIELD = new ParseField("data_streams");  
                        );  
        ) {
                                index.getParentDataStream() == null ? null : index.getParentDataStream().getName()
                                dataStream.getName(),
            this.backingIndices = in.readStringArray();
                }
        }
                request.indicesOptions(),  
            out.writeStringArray(names);  
    public static final ResolveIndexAction INSTANCE = new ResolveIndexAction();
                                aliasNames,
                listener.onResponse(new Response(indices, aliases, dataStreams));  
            List<ResolvedIndex> indices,
     *
            builder.field(ALIASES_FIELD.getPreferredName(), aliases);
            this.indices = in.readList(ResolvedIndex::new);
        public int hashCode() {
        public IndicesOptions indicesOptions() {
     */
                final int remoteRequests = remoteClusterIndices.size();
        @Override
            List<ResolvedAlias> aliases = new ArrayList<>();
        public int hashCode() {
                        String[] indexNames = alias.getIndices().stream().map(i -> i.getIndex().getName()).toArray(String[]::new);
                    remoteClusterClient.admin().indices().resolveIndex(remoteRequest, ActionListener.wrap(response -> {  
            builder.endObject();
        ) {
            this.names = indices;
        private final IndexNameExpressionResolver indexNameExpressionResolver;
import java.util.List;
            return name;
        @Override
                    localIndices.indices(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (this == o) return true;
 * this work for additional information regarding copyright
                    indices.add(index.copy(RemoteClusterAware.buildRemoteIndexName(clusterAlias, index.getName())));  
            this.aliases = aliases;  
import org.opensearch.core.common.io.stream.Writeable;
                        }
            IndexAbstractionResolver resolver,  
            builder.array(ATTRIBUTES_FIELD.getPreferredName(), attributes);  
            List<String> resolvedIndexAbstractions = resolver.resolveIndexAbstractions(names, indicesOptions, metadata, includeDataStreams);  
 * Modifications Copyright OpenSearch Contributors. See
    /**
                        break;
     * The resolved index alias
                final Runnable terminalHandler = () -> {
        }
        }
        public boolean equals(Object o) {
        }  
                        localIndices.indicesOptions(),  
        }
            this.attributes = attributes;
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (o == null || getClass() != o.getClass()) return false;
        }
            super.writeTo(out);
            if (o == null || getClass() != o.getClass()) return false;
        @Override
            ResolvedDataStream dataStream = (ResolvedDataStream) o;  
     * @opensearch.internal  
                request.indicesOptions(),
            final Map<String, OriginalIndices> remoteClusterIndices = remoteClusterService.groupIndices(
            return new ResolvedIndex(newName, aliases, attributes, dataStream);  
            if (remoteClusterIndices.size() > 0) {
        ResolvedDataStream(StreamInput in) throws IOException {  
        }
import java.util.Comparator;  
                            new ResolvedDataStream(
            this.indices = indices;
            if (o == null || getClass() != o.getClass()) return false;
        private final String dataStream;
 * Transport action to resolve an index.
            List<ResolvedIndex> indices,
import org.opensearch.cluster.service.ClusterService;
    }  
        @Override
        public List<ResolvedIndex> getIndices() {  
        @Override
        }  
        }  
            final Metadata metadata = clusterState.metadata();
        static final ParseField INDICES_FIELD = new ParseField("indices");  
import org.opensearch.transport.RemoteClusterService;
            if (aliases.length > 0) {  
 * license agreements. See the NOTICE file distributed with
            this.remoteClusterService = transportService.getRemoteClusterService();  
            if (ia != null) {
import org.opensearch.common.inject.Inject;
        ResolvedIndex(StreamInput in) throws IOException {  
                        String[] backingIndices = dataStream.getIndices().stream().map(i -> i.getIndex().getName()).toArray(String[]::new);
        }
/*  
import java.util.Arrays;
        ResolvedAlias(String name, String[] indices) {  
                        false  
     */
            out.writeString(getName());
/*
            }
        static final ParseField ATTRIBUTES_FIELD = new ParseField("attributes");
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        ) {
                        List<String> attributes = new ArrayList<>();  
            out.writeStringArray(backingIndices);  
    @PublicApi(since = "1.0.0")  
                        localIndices.indices(),
        }
            this.indexNameExpressionResolver = indexNameExpressionResolver;
        @Override
                for (ResolvedIndex index : response.indices) {
        @Override
                        attributes.sort(String::compareTo);  
        }
                        Arrays.sort(aliasNames);
        }
            return resolvedIndices(request, clusterService.state());  
                            )
         * @param indices        List containing any matching indices  
            IndexNameExpressionResolver indexNameExpressionResolver
            List<ResolvedAlias> aliases,  
                    }, failure -> terminalHandler.run()));  
            return Objects.hash(indices, aliases, dataStreams);  
     * @opensearch.api
        public String getName() {  
        public void writeTo(StreamOutput out) throws IOException {
            Request request = (Request) o;
    public static final String NAME = "indices:admin/resolve/index";  
                // make the cross-cluster calls  
     * @opensearch.api
        }  
            this.timestampField = timestampField;  
        }
        @Override  
    /**
     * Request for resolving an index
        }
            this.aliases = in.readStringArray();
     * @opensearch.internal
                        remoteResponses.put(clusterAlias, response);
        }
    public static class ResolvedIndex extends ResolvedIndexAbstraction implements Writeable, ToXContentObject {
                            attributes.add("hidden");  
            SortedMap<String, IndexAbstraction> lookup = metadata.getIndicesLookup();
            builder.field(NAME_FIELD.getPreferredName(), getName());
        @Override  
                && Arrays.equals(attributes, index.attributes);
        }
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamOutput;  
            out.writeStringArray(attributes);
 */
        public void writeTo(StreamOutput out) throws IOException {
            List<ResolvedDataStream> dataStreams = new ArrayList<>();
            return indicesOptions;  
        }  
        }
            IndicesOptions indicesOptions,
            if (o == null || getClass() != o.getClass()) return false;  
 *
    @PublicApi(since = "1.0.0")
                enrichIndexAbstraction(s, lookup, indices, aliases, dataStreams);  
 * SPDX-License-Identifier: Apache-2.0
        @Override
        implements
                for (ResolvedAlias alias : response.aliases) {
    }
import java.util.Spliterators;
        protected void setName(String name) {
