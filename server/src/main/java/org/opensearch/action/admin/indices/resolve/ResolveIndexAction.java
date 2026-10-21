                builder.array(ALIASES_FIELD.getPreferredName(), aliases);
            );
    @PublicApi(since = "1.0.0")
            builder.startObject();
            this.clusterService = clusterService;
                        if (ia.isHidden()) {
            }
 *
                    aliases.add(alias.copy(RemoteClusterAware.buildRemoteIndexName(clusterAlias, alias.getName())));
        public Request(String[] names) {
            return this;
            List<ResolvedDataStream> dataStreams,
                return ResolvedIndices.of(
            IndexAbstraction ia = lookup.get(indexAbstraction);
        private ResolvedIndices resolvedIndices(Request request, ClusterState clusterState) {
        }
     * Request for resolving an index
import org.opensearch.threadpool.ThreadPool;
            for (String s : resolvedIndexAbstractions) {
         * @param indicesOptions Options for expanding wildcards to indices with different states
import java.util.Collections;
                        Arrays.sort(backingIndices);
        static final ParseField DATA_STREAMS_FIELD = new ParseField("data_streams");
                        listener.onResponse(new Response(indices, aliases, dataStreams));
            if (aliases.length > 0) {
            aliases.sort(Comparator.comparing(ResolvedIndexAbstraction::getName));
import org.opensearch.cluster.metadata.ResolvedIndices;
        @Override
        }
import org.opensearch.action.support.TransportIndicesResolvingAction;
        public String[] getAliases() {
                        String[] indexNames = alias.getIndices().stream().map(i -> i.getIndex().getName()).toArray(String[]::new);
                // make the cross-cluster calls
            return builder;
            );
        @Override
            }
            return getName().equals(alias.getName()) && Arrays.equals(indices, alias.indices);
        ResolvedAlias(StreamInput in) throws IOException {
        }
        private final IndexAbstractionResolver indexAbstractionResolver;
        private String[] names;
            out.writeString(getName());
            super(name);
         * Resolves the specified names and/or wildcard expressions to index abstractions. Returns results in the supplied lists.
    public static final ResolveIndexAction INSTANCE = new ResolveIndexAction();
                for (Map.Entry<String, OriginalIndices> remoteIndices : remoteClusterIndices.entrySet()) {
        static final ParseField ALIASES_FIELD = new ParseField("aliases");
    @PublicApi(since = "1.0.0")
        public String getTimestampField() {
                        indices.add(
            if (this == o) return true;
            out.writeString(getName());
                        mergeResults(remoteResponses, indices, aliases, dataStreams);
            final Metadata metadata = clusterState.metadata();
            ThreadPool threadPool,
import org.opensearch.core.common.io.stream.Writeable;
                && Arrays.equals(backingIndices, dataStream.backingIndices);
 *
     * @opensearch.internal
            return getName().equals(index.getName())
                && Arrays.equals(attributes, index.attributes);
        implements
 *
import org.opensearch.core.action.ActionResponse;
            this.timestampField = in.readString();
        static final ParseField NAME_FIELD = new ParseField("name");
                                dataStream.getName(),
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
                );
            return true;
        static void resolveIndices(
        @Override
        private final ClusterService clusterService;
import java.util.Objects;
import java.util.List;
    }
        }
import org.opensearch.cluster.metadata.IndexMetadata;
 * software distributed under the License is distributed on an
        private final ThreadPool threadPool;
                request.indices(),
                builder.array(INDICES_FIELD.getPreferredName(), indices);
        public int hashCode() {
        }
 * Transport action to resolve an index.
import org.opensearch.transport.RemoteClusterService;
            out.writeStringArray(attributes);
        static final ParseField TIMESTAMP_FIELD = new ParseField("timestamp_field");
                    indexAbstractionResolver.resolveIndexAbstractions(
        }
        public String[] getBackingIndices() {
import org.opensearch.cluster.metadata.IndexAbstractionResolver;
        public String[] getIndices() {
            List<ResolvedDataStream> dataStreams
            }
        private final List<ResolvedIndex> indices;
    public static class Response extends ActionResponse implements ToXContentObject {
import org.opensearch.core.xcontent.ToXContentObject;
 */
     * Response for resolving an index
     */
                        terminalHandler.run();
        ) {
                        break;
        static final ParseField DATA_STREAM_FIELD = new ParseField("data_stream");
            this.dataStream = dataStream;
         *
        @Override
     *
            result = 31 * result + Arrays.hashCode(attributes);
            ClusterService clusterService,
        }
                    indices,
     *
            Metadata metadata,
            String indexAbstraction,
        }
                            new ResolvedDataStream(
import org.opensearch.action.ActionRequestValidationException;
            this.aliases = aliases;
     */
                request.indicesOptions(),
        private final IndexNameExpressionResolver indexNameExpressionResolver;
        }
            this.indexNameExpressionResolver = indexNameExpressionResolver;
        private String name;
    /**
        private final RemoteClusterService remoteClusterService;
    /**
            this.timestampField = timestampField;
                        Arrays.sort(aliasNames);
                            attributes.add("hidden");
                for (ResolvedIndex index : response.indices) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                }
     * The resolved data stream
            result = 31 * result + Arrays.hashCode(aliases);
            out.writeList(aliases);
        public IndicesOptions indicesOptions() {
            this.names = in.readStringArray();
            IndexAbstractionResolver resolver,
            builder.endObject();
        static final ParseField INDICES_FIELD = new ParseField("indices");
                        }
        private final String[] indices;
            return Arrays.hashCode(names);
         * @param aliases        List containing any matching aliases
            ResolvedAlias alias = (ResolvedAlias) o;
        public int hashCode() {
            final Map<String, OriginalIndices> remoteClusterIndices = remoteClusterService.groupIndices(
    public static class TransportAction extends HandledTransportAction<Request, Response>
            int result = Objects.hash(getName(), timestampField);
            builder.field(NAME_FIELD.getPreferredName(), getName());
    /**
                && Objects.equals(dataStream, index.dataStream)
                listener.onResponse(new Response(indices, aliases, dataStreams));
            ActionFilters actionFilters,
        private final String[] aliases;
        @Override
                        IndexAbstraction.Alias alias = (IndexAbstraction.Alias) ia;
        public int hashCode() {
        private final String timestampField;
import org.opensearch.transport.RemoteClusterAware;
            if (localIndices != null) {
            return indicesOptions;
                        if (isFrozen) {
        protected void setName(String name) {
                switch (ia.getType()) {
            List<ResolvedDataStream> dataStreams
        }
            builder.endObject();
            }
     */
                            )
            return backingIndices;
        public ResolvedIndex copy(String newName) {
import org.opensearch.cluster.service.ClusterService;
        ResolvedIndexAbstraction() {}
        public void writeTo(StreamOutput out) throws IOException {
        public void writeTo(StreamOutput out) throws IOException {
     */
        @Override
        public List<ResolvedDataStream> getDataStreams() {
        @Override
            out.writeStringArray(indices);
            this.indicesOptions = indicesOptions;
            List<String> resolvedIndexAbstractions = resolver.resolveIndexAbstractions(names, indicesOptions, metadata, includeDataStreams);
                            Spliterators.spliteratorUnknownSize(index.getWriteIndex().getAliases().keySet().iterator(), 0),
                }
package org.opensearch.action.admin.indices.resolve;
        public List<ResolvedIndex> getIndices() {
 * ownership. Elasticsearch licenses this file to you under
        }
     * The resolved index
import java.util.ArrayList;
            return resolvedIndices(request, clusterService.state());
import org.opensearch.tasks.Task;
            int result = Objects.hash(getName(), dataStream);
    }
            this.aliases = in.readStringArray();
                        request.includeDataStreams(),
        }
/**
    public static class Request extends ActionRequest implements IndicesRequest.Replaceable {
                        aliases.add(new ResolvedAlias(alias.getName(), indexNames));
        private final List<ResolvedAlias> aliases;
            dataStreams.sort(Comparator.comparing(ResolvedIndexAbstraction::getName));
 * this work for additional information regarding copyright
            this.names = indices;
            if (o == null || getClass() != o.getClass()) return false;
        public void writeTo(StreamOutput out) throws IOException {
        }
            this.attributes = in.readStringArray();
        }
            return timestampField;
            setName(in.readString());
        public void writeTo(StreamOutput out) throws IOException {
import java.util.Comparator;
     * @opensearch.api
            return builder;
        }
    @PublicApi(since = "1.0.0")
            return indices;
            } else {
            return dataStream;
     * @opensearch.api
        @Override
        }
            int result = Objects.hash(getName());
            return new ResolvedAlias(newName, indices);
    /**
            return aliases;
                            attributes.add("frozen");
/*
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @PublicApi(since = "1.0.0")
        @Override
/*
        static final ParseField ALIASES_FIELD = new ParseField("aliases");
                                aliasNames,
}
import java.util.Map;
            out.writeStringArray(backingIndices);
                    aliases,
import org.opensearch.core.common.Strings;
                        String[] aliasNames = StreamSupport.stream(
            this.names = names;
        static final ParseField INDICES_FIELD = new ParseField("indices");
        @Override
            return attributes;
        @Override
        protected void doExecute(Task task, Request request, final ActionListener<Response> listener) {
import org.opensearch.common.inject.Inject;
import org.opensearch.action.ActionRequest;
    public static class ResolvedDataStream extends ResolvedIndexAbstraction implements Writeable, ToXContentObject {
import org.opensearch.cluster.metadata.IndexAbstraction;
        }
        }
            OriginalIndices localIndices = remoteClusterIndices.remove(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY);
            SortedMap<String, IndexAbstraction> lookup,
                        false
        ResolvedIndex(StreamInput in) throws IOException {
                        localIndices.indicesOptions(),
        public boolean equals(Object o) {
        public String[] getAttributes() {
                            )
                ).withRemoteIndices(remoteClusterIndices);
            return new ResolvedDataStream(newName, backingIndices, timestampField);
            return Arrays.equals(names, request.names);
        ResolvedIndexAbstraction(String name) {
                        localIndices.indices(),
        public boolean equals(Object o) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public static class ResolvedIndexAbstraction {
            List<ResolvedAlias> aliases,
     * @opensearch.api
            List<ResolvedIndex> indices,
        public Response(List<ResolvedIndex> indices, List<ResolvedAlias> aliases, List<ResolvedDataStream> dataStreams) {
            if (o == null || getClass() != o.getClass()) return false;
                        );
            return aliases;
            out.writeList(dataStreams);
                idx -> indexNameExpressionResolver.hasIndexAbstraction(idx, clusterState)
    public static class ResolvedAlias extends ResolvedIndexAbstraction implements Writeable, ToXContentObject {
            List<ResolvedAlias> aliases = new ArrayList<>();
        ResolvedAlias(String name, String[] indices) {
        public ResolvedDataStream copy(String newName) {
                request.indices(),
        public String[] indices() {
        }
     *
            Request request = (Request) o;
        /**
 * GitHub history for details.
     */
        public int hashCode() {
        }
        private final List<ResolvedDataStream> dataStreams;
        }
            builder.endObject();
            if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.core.action.ActionListener;
            this.indicesOptions = IndicesOptions.readIndicesOptions(in);
        ResolvedDataStream(StreamInput in) throws IOException {
                    Client remoteClusterClient = remoteClusterService.getRemoteClusterClient(threadPool, clusterAlias);
        }
            String[] names,
            Map<String, OriginalIndices> remoteClusterIndices = remoteClusterService.groupIndices(
         * @param dataStreams    List containing any matching data streams
        public boolean equals(Object o) {
                        final boolean isFrozen = Boolean.parseBoolean(ia.getWriteIndex().getSettings().get("index.frozen"));
            if (remoteClusterIndices.size() > 0) {
         * @param metadata       Cluster metadata
            } else {
                        }
 */
    /**
     *
                    metadata,
            return getName().equals(dataStream.getName())
            return result;
        }
         */
        @Override
 * Modifications Copyright OpenSearch Contributors. See
            builder.startObject();
                for (ResolvedDataStream dataStream : response.dataStreams) {
                    }, failure -> terminalHandler.run()));
    /**
import org.opensearch.action.OriginalIndices;
        public Request(StreamInput in) throws IOException {
/*
                idx -> indexNameExpressionResolver.hasIndexAbstraction(idx, clusterState)
     */
            return names;
            out.writeStringArray(aliases);
        }
        }
        public int hashCode() {
            super(in);
        public IndicesRequest indices(String... indices) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public static class ResolvedIndex extends ResolvedIndexAbstraction implements Writeable, ToXContentObject {
    }
        }
                        clusterState.metadata(),
            IndexNameExpressionResolver indexNameExpressionResolver
            Map<String, Response> remoteResponses,
        private final String[] attributes;
            super(name);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public static final IndicesOptions DEFAULT_INDICES_OPTIONS = IndicesOptions.strictExpandOpen();
     */
    }
            }
        }
                    remoteClusterClient.admin().indices().resolveIndex(remoteRequest, ActionListener.wrap(response -> {
import org.opensearch.common.util.concurrent.CountDown;
                    case ALIAS:
         * @param names          The names and wildcard expressions to resolve
 * The OpenSearch Contributors require contributions made to
            boolean includeDataStreams
        }
import org.opensearch.common.Nullable;
            for (Map.Entry<String, Response> responseEntry : remoteResponses.entrySet()) {
                        break;
            super(NAME, transportService, actionFilters, Request::new);
    /**
        }
        ) {
        ResolvedDataStream(String name, String[] backingIndices, String timestampField) {
import org.opensearch.transport.client.Client;
        @Override
 * Unless required by applicable law or agreed to in writing,
        }
                        break;
            this.aliases = aliases;
        }
            out.writeList(indices);
                String clusterAlias = responseEntry.getKey();
        private static void enrichIndexAbstraction(
        public String getDataStream() {
        public Response(StreamInput in) throws IOException {
        @Override
            super(name);
            if (this == o) return true;
     * Abstraction class for resolving an index
         * @param resolver       Resolver instance for matching names
        }
        }
import java.util.Arrays;
            builder.field(DATA_STREAMS_FIELD.getPreferredName(), dataStreams);
            TransportService transportService,
        }
            this.remoteClusterService = transportService.getRemoteClusterService();
                    default:
        public boolean includeDataStreams() {
                    case DATA_STREAM:
import org.opensearch.core.common.io.stream.StreamInput;
                        IndexAbstraction.DataStream dataStream = (IndexAbstraction.DataStream) ia;
        private final String dataStream;
     *
        private static void mergeResults(
        }
            return indices;
import org.opensearch.action.IndicesRequest;
                            new ResolvedIndex(
            super.writeTo(out);
import org.opensearch.core.xcontent.XContentBuilder;
        @Override
            builder.field(TIMESTAMP_FIELD.getPreferredName(), timestampField);
        }
            List<ResolvedIndex> indices,
                    localIndices.indices(),
            final ClusterState clusterState = clusterService.state();
            ResolvedIndex index = (ResolvedIndex) o;
                    }
            if (this == o) return true;
            return builder;
        private IndicesOptions indicesOptions = DEFAULT_INDICES_OPTIONS;
        }
        }
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
            List<ResolvedIndex> indices,
                    )
 *
            this.backingIndices = backingIndices;
        }
import org.opensearch.action.support.HandledTransportAction;
        }
                        throw new IllegalStateException("unknown index abstraction type: " + ia.getType());
        }
        static final ParseField ATTRIBUTES_FIELD = new ParseField("attributes");
        @Inject
                        IndexAbstraction.Index index = (IndexAbstraction.Index) ia;
        super(NAME, Response::new);
                }
            out.writeString(getName());
                resolveIndices(
            final OriginalIndices localIndices = remoteClusterIndices.remove(RemoteClusterAware.LOCAL_CLUSTER_GROUP_KEY);
    @PublicApi(since = "1.0.0")
            this.dataStreams = in.readList(ResolvedDataStream::new);
 * specific language governing permissions and limitations
            }
import org.opensearch.cluster.ClusterState;
        }
            this.indices = in.readStringArray();
            if (Strings.isNullOrEmpty(dataStream) == false) {
            this.backingIndices = in.readStringArray();
            SortedMap<String, IndexAbstraction> lookup = metadata.getIndicesLookup();
            return dataStreams;
                    indexAbstractionResolver,
                    dataStreams,
            List<ResolvedIndex> indices = new ArrayList<>();
                final CountDown completionCounter = new CountDown(remoteRequests);
import org.opensearch.core.ParseField;
        }
                    request.includeDataStreams()
 * license agreements. See the NOTICE file distributed with
     * @opensearch.api
                return ResolvedIndices.of(Collections.emptySet()).withRemoteIndices(remoteClusterIndices);
import java.util.Spliterators;
        @Override
            builder.array(ATTRIBUTES_FIELD.getPreferredName(), attributes);
            }
        }
            indices.sort(Comparator.comparing(ResolvedIndexAbstraction::getName));
import org.opensearch.common.annotation.PublicApi;
                    request.indicesOptions,
            builder.startObject();
            return null;
                final int remoteRequests = remoteClusterIndices.size();
    }
                builder.field(DATA_STREAM_FIELD.getPreferredName(), dataStream);
            builder.field(INDICES_FIELD.getPreferredName(), indices);
            List<ResolvedAlias> aliases,
        }
            this.indices = indices;
                                backingIndices,
            if (indices.length > 0) {
        @Override
            out.writeString(timestampField);
            Response response = (Response) o;
            builder.field(ALIASES_FIELD.getPreferredName(), aliases);
        public boolean equals(Object o) {
                request.indicesOptions(),
                    dataStreams.add(dataStream.copy(RemoteClusterAware.buildRemoteIndexName(clusterAlias, dataStream.getName())));
        public TransportAction(
            this.name = name;
        // visible for testing
                        );
        @Override
                            false
            indicesOptions.writeIndicesOptions(out);
            return name;
        public Request(String[] names, IndicesOptions indicesOptions) {
            this.names = names;
    }
            if (ia != null) {
            return result;
 * @opensearch.api
 * this file be licensed under the Apache-2.0 license or a
            setName(in.readString());
        public ResolvedAlias copy(String newName) {
 * not use this file except in compliance with the License.
                    indices.add(index.copy(RemoteClusterAware.buildRemoteIndexName(clusterAlias, index.getName())));
                };
 */
            return result;
                    OriginalIndices originalIndices = remoteIndices.getValue();
                        String[] backingIndices = dataStream.getIndices().stream().map(i -> i.getIndex().getName()).toArray(String[]::new);
            return builder;
                final SortedMap<String, Response> remoteResponses = Collections.synchronizedSortedMap(new TreeMap<>());
 * Licensed to Elasticsearch under one or more contributor
        }
                        Arrays.sort(indexNames);
                    if (completionCounter.countDown()) {
                }
        }
 */
        @Override
                                index.getName(),
     * Transport action for resolving an index
                                attributes.toArray(Strings.EMPTY_ARRAY),
        }
            if (this == o) return true;
import java.util.TreeMap;
            this.attributes = attributes;
                    case CONCRETE_INDEX:
import java.io.IOException;
            builder.array(BACKING_INDICES_FIELD.getPreferredName(), backingIndices);
        }
            if (localIndices != null) {
            this.indices = in.readList(ResolvedIndex::new);
        @Override
        @Override
                Response response = responseEntry.getValue();
            this.name = name;
        ) {
import java.util.SortedMap;
     *
import java.util.stream.StreamSupport;
        }
import org.opensearch.action.ActionType;
         * @param indices        List containing any matching indices
            this.indices = indices;
                                index.getParentDataStream() == null ? null : index.getParentDataStream().getName()
                for (ResolvedAlias alias : response.aliases) {
import org.opensearch.action.support.ActionFilters;
            if (o == null || getClass() != o.getClass()) return false;
            out.writeOptionalString(dataStream);
            builder.endObject();
import org.opensearch.core.common.io.stream.StreamOutput;
            result = 31 * result + Arrays.hashCode(indices);
        static final ParseField BACKING_INDICES_FIELD = new ParseField("backing_indices");
                enrichIndexAbstraction(s, lookup, indices, aliases, dataStreams);
            return new ResolvedIndex(newName, aliases, attributes, dataStream);
 * SPDX-License-Identifier: Apache-2.0
                                dataStream.getDataStream().getTimeStampField().getName()
            result = 31 * result + Arrays.hashCode(backingIndices);
public class ResolveIndexAction extends ActionType<ResolveIndexAction.Response> {
     * @opensearch.internal
            this.indexAbstractionResolver = new IndexAbstractionResolver(indexNameExpressionResolver);
@PublicApi(since = "1.0.0")
                }
            builder.field(NAME_FIELD.getPreferredName(), getName());
        public void writeTo(StreamOutput out) throws IOException {
        }
import org.opensearch.cluster.metadata.Metadata;
        ResolvedIndex(String name, String[] aliases, String[] attributes, @Nullable String dataStream) {
        @Override
                        attributes.sort(String::compareTo);
        }
            List<ResolvedDataStream> dataStreams = new ArrayList<>();
        }
            builder.field(NAME_FIELD.getPreferredName(), getName());
        }
        public ResolvedIndices resolveIndices(Request request) {
        public boolean equals(Object o) {
            TransportIndicesResolvingAction<Request> {
            setName(in.readString());
            }
     *
                final Runnable terminalHandler = () -> {
        public ActionRequestValidationException validate() {
        }
                        ).toArray(String[]::new);
        @Override
            this.dataStream = in.readOptionalString();
    public static final String NAME = "indices:admin/resolve/index";
                && timestampField.equals(dataStream.timestampField)
            }
            if (this == o) return true;
 * compatible open source license.
        private final String[] backingIndices;
            if (o == null || getClass() != o.getClass()) return false;
                        remoteResponses.put(clusterAlias, response);
import org.opensearch.action.support.IndicesOptions;
 * You may obtain a copy of the License at
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            this.threadPool = threadPool;
        }
            this.dataStreams = dataStreams;
     * @opensearch.api
                        dataStreams.add(
        ) {
            this.aliases = in.readList(ResolvedAlias::new);
        public String getName() {
            out.writeStringArray(names);
            return indices.equals(response.indices) && aliases.equals(response.aliases) && dataStreams.equals(response.dataStreams);
import org.opensearch.transport.TransportService;
 * under the License.
            ResolvedDataStream dataStream = (ResolvedDataStream) o;
        @Override
                        List<String> attributes = new ArrayList<>();
            return Objects.hash(indices, aliases, dataStreams);
        }
            List<ResolvedAlias> aliases,
                        attributes.add(index.getWriteIndex().getState() == IndexMetadata.State.OPEN ? "open" : "closed");
                    String clusterAlias = remoteIndices.getKey();
        public List<ResolvedAlias> getAliases() {
            IndicesOptions indicesOptions,
                && Arrays.equals(aliases, index.aliases)
    }
            builder.startObject();
                    Request remoteRequest = new Request(originalIndices.indices(), originalIndices.indicesOptions());
    private ResolveIndexAction() {
        @Override
     * The resolved index alias
