    }
    public RemoteInfo getRemoteInfo() {
        PARSER.declareField((p, v, c) -> v.setScript(Script.parse(p)), new ParseField("script"), ObjectParser.ValueType.OBJECT);
import org.opensearch.common.lucene.uid.Versions;
        if (getSearchRequest().indices() == null || getSearchRequest().indices().length == 0) {
    /**
        for (Map.Entry<?, ?> entry : map.entrySet()) {
        StringBuilder b = new StringBuilder();
        }
        ReindexRequest reindexRequest = new ReindexRequest();
        PARSER.parse(parser, reindexRequest, null);
    /**
    /**
    }
            case "keep":
    }
                e = addValidationError("reindex from remote sources doesn't support slices > 1 but was [" + getSlices() + "]", e);
        {
     */
        return this;
    }
     * String array conversions and allow comma separated String.
     */
        super.writeTo(out);
            e = addValidationError("routing must be unset, [keep], [discard] or [=<some new value>]", e);
    static void setMaxDocsValidateIdentical(AbstractBulkByScrollRequest<?> request, int maxDocs) {
            }
    }
            e = addValidationError("index must be specified", e);
            throw new IllegalArgumentException(
    }
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * Request to reindex some documents from one index to another. This implements CompositeIndicesRequest but in a misleading way. Rather than
import org.opensearch.core.xcontent.XContentParser;
    public ReindexRequest setDestRouting(String routing) {
            builder.field("index", getDestination().index());
        } else if (value instanceof String stringValue) {
        this.getDestination().setPipeline(pipelineName);
}
     */
    }
    }
        throw new IllegalArgumentException("Expected [" + name + "] to be a string but was [" + value + "]");
     * if the document already existed in the target index.
    /**
        @SuppressWarnings("unchecked")
     * Yank a string array from a map. Emulates XContent's permissive String to
            List<String> stringList = (List<String>) value;
import java.util.Map;
        {
    /**
            RemoteInfo.queryForRemote(source),
        if (value instanceof String stringValue) {
    ReindexRequest(SearchRequest search, IndexRequest destination) {
            }
            socketTimeout,
            return true;
import org.opensearch.core.common.bytes.BytesReference;
import java.io.IOException;
                    .createParser(parser.getXContentRegistry(), parser.getDeprecationHandler(), stream)
     * Set the version type for the target index. A {@link VersionType#EXTERNAL} helps preserve the version
    }
        ObjectParser<IndexRequest, Void> destParser = new ObjectParser<>("dest");
        TimeValue connectTimeout = extractTimeValue(remote, "connect_timeout", RemoteInfo.DEFAULT_CONNECT_TIMEOUT);
            }
        }
    }
    }
        Map<String, Object> remote = (Map<String, Object>) source.remove("remote");
                "[max_docs] set to two different values [" + request.getMaxDocs() + "]" + " and [" + maxDocs + "]"
            if (getScript() != null) {
import org.opensearch.search.sort.SortOrder;
            throw new IllegalArgumentException(
    public String toString() {
        this.getDestination().routing(routing);
        if (getSearchRequest().source().fetchSource() != null && getSearchRequest().source().fetchSource().fetchSource() == false) {
    private IndexRequest destination;
        this.getDestination().versionType(versionType);
            password,
    @Override
     * Gets the target for this reindex request in the for of an {@link IndexRequest}
            return null;
            if (getDestination().routing() != null) {
                throw new URISyntaxException(hostInRequest, "The port was not defined in the [host]");
        if (sourceIndices != null) {
     * Sets the scroll size for setting how many documents are to be processed in one batch during reindex
import org.opensearch.index.query.QueryBuilder;
        }
         * we'll be filling in portions of it as we receive the docs. But we can
     * @param name The name of the field to sort by
            );
            pathPrefix,
    protected ReindexRequest self() {
    public ReindexRequest forSlice(TaskId slicingTask, SearchRequest slice, int totalSlices) {
        String pathPrefix = null;
                builder.field("conflicts", "proceed");
    /**
        }
        {
     *
            if (getSearchRequest().source().query() != null) {
     * @param order The order in which to sort
        return this;
            }
            }
     */
    private ReindexRequest(SearchRequest search, IndexRequest destination, boolean setDefaults) {
            }
        Object value = source.remove(name);
 *
    }
    public ReindexRequest() {
 */
            if (getSlices() == AbstractBulkByScrollRequest.AUTO_SLICES || getSlices() > 1) {
     * @deprecated Specifying a sort field for reindex is deprecated. If using this in combination with maxDocs, consider using a
 * license agreements. See the NOTICE file distributed with
        String scheme = uri.getScheme();
    }
                "[host] must be of the form [scheme]://[host]:[port](/[pathPrefix])? but was [" + hostInRequest + "]",
import org.opensearch.action.ActionRequestValidationException;
            try (
        }
            String[] indices = extractStringArray(source, "index");
        super(in);
        }
        TimeValue socketTimeout = extractTimeValue(remote, "socket_timeout", RemoteInfo.DEFAULT_SOCKET_TIMEOUT);
    }
            @SuppressWarnings("unchecked")
    public ReindexRequest setSourceIndices(String... sourceIndices) {
    /**
     */
        }
            builder.startObject("source");
        return this;
        PARSER.declareField(sourceParser::parse, new ParseField("source"), ObjectParser.ValueType.OBJECT);
    }
        ActionRequestValidationException e = super.validate();
            this.getSearchRequest().source().query(queryBuilder);
     * Set the indices which will act as the source for the ReindexRequest
     * Sets the optype on the destination index
 */
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        b.append("reindex from ");
            username,
                throw new IllegalArgumentException("Expected [" + name + "] to be an object containing strings but has [" + entry + "]");
    }
    /**
    private static String extractString(Map<String, Object> source, String name) {
    private boolean routingIsValid() {
        String host = uri.getHost();
     */
        return new RemoteInfo(
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
        if (false == remote.isEmpty()) {
        return destination;
    public ReindexRequest setDestVersionType(VersionType versionType) {
        if (value == null) {
     * Get the {@link RemoteInfo} if it was set for this request.
            if (uri.getPort() == -1) {
 * under the License.
            return emptyMap();
        String hostInRequest = requireNonNull(extractString(remote, "host"), "[host] must be specified to reindex from a remote cluster");
    }
    }
        this.getDestination().setRequireAlias(requireAlias);
    /**
        return this;
        }
import static java.util.Collections.emptyMap;
            builder.startObject("dest");
            port,
        searchToString(b);
            // Other fields
            // build source
import org.opensearch.core.common.io.stream.StreamInput;
            e = addValidationError("use _all if you really want to copy from all existing indexes", e);
     */
            host,
    public ReindexRequest setRequireAlias(boolean requireAlias) {
        return this;
    public static ReindexRequest fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.xcontent.MediaTypeRegistry;
         */
     */
import org.opensearch.core.ParseField;
     */
import org.opensearch.core.tasks.TaskId;
            throw new IllegalArgumentException(
        this.destination = destination;
        return this;
            // build destination
            if (indices != null) {
/*
            if (false == entry.getKey() instanceof String || false == entry.getValue() instanceof String) {
        out.writeOptionalWriteable(remoteInfo);
            return e;
            Map<String, Object> source = parser.map();
        PARSER.declareField((p, v, c) -> destParser.parse(p, v.getDestination(), c), new ParseField("dest"), ObjectParser.ValueType.OBJECT);
import org.opensearch.action.index.IndexRequest;
    static final String TYPES_DEPRECATION_MESSAGE = "[types removal] Specifying types in reindex requests is deprecated.";
 * Licensed to Elasticsearch under one or more contributor
        destination.writeTo(out);
        return e;
 * returning all the subrequests that it will make it tries to return a representative set of subrequests. This is best-effort for a bunch
    @Override
            }
 * GitHub history for details.
        }
 * to which documents are written.
        int port = uri.getPort();
    }
        }
            if (getDestination().getPipeline() != null) {
    }
            return stringValue;
                InputStream stream = BytesReference.bytes(builder).streamInput();
                request.getSearchRequest().source().parseXContent(innerParser, false);
    }
import org.opensearch.core.common.io.stream.StreamOutput;
            if (isAbortOnVersionConflict() == false) {
    /**
                builder.field("max_docs", getMaxDocs());
            e = addValidationError("_source:false is not supported in this context", e);
        destParser.declareString((s, i) -> s.versionType(VersionType.fromString(i)), new ParseField("version_type"));
        return reindexRequest;
            return Strings.splitStringByCommaToArray(stringValue);
        }
                builder.field("pipeline", getDestination().getPipeline());
            builder.map(source);
        destParser.declareString(IndexRequest::index, new ParseField("index"));
    private static String[] extractStringArray(Map<String, Object> source, String name) {
    }
    private static TimeValue extractTimeValue(Map<String, Object> source, String name, TimeValue defaultValue) {
        return this;
    }
            }
    @Override
        this.getDestination().opType(opType);
            request.setRemoteInfo(buildRemoteInfo(source));
    public ReindexRequest setRemoteInfo(RemoteInfo remoteInfo) {
            }
        destParser.declareString(IndexRequest::setPipeline, new ParseField("pipeline"));
        destParser.declareString(IndexRequest::routing, new ParseField("routing"));
    /**
        remoteInfo = in.readOptionalWriteable(RemoteInfo::new);
        if (destination.versionType() == INTERNAL) {
            getSearchRequest().source().innerToXContent(builder, params);
        }
 * compatible open source license.
            builder.field("version_type", VersionType.toString(getDestination().versionType()));
        @SuppressWarnings("unchecked") // We just checked....
        if (remote == null) {
        destParser.declareString(IndexRequest::opType, new ParseField("op_type"));
        b.append(" to [").append(destination.index()).append(']');
            case "discard":
        PARSER.declareString(ReindexRequest::setConflicts, new ParseField("conflicts"));
     * Set the {@link RemoteInfo} if the source indices are in a remote cluster.
        } else {
        sliced.setRemoteInfo(remoteInfo);
     */
            builder.field("op_type", getDestination().opType().getLowercase());
        Object value = source.remove(name);
import java.net.URISyntaxException;
    private RemoteInfo remoteInfo;
        }
        return this;
import org.opensearch.index.VersionType;
 * Modifications Copyright OpenSearch Contributors. See
    public IndexRequest getDestination() {
    public ReindexRequest setSourceBatchSize(int size) {
        String username = extractString(remote, "username");
         * Note that we don't call index's validator - it won't work because
        if (destination.index() == null) {
            );
package org.opensearch.index.reindex;
    }
    public ReindexRequest setSourceQuery(QueryBuilder queryBuilder) {
            default:
    @Override
                builder.rawField("query", remoteInfo.getQuery().streamInput(), RemoteInfo.QUERY_CONTENT_TYPE.mediaType());
        return string == null ? defaultValue : parseTimeValue(string, name);
        }
            if (destination.version() != Versions.MATCH_ANY && destination.version() != Versions.MATCH_DELETED) {
        return this;
import org.opensearch.script.Script;
    /**
            ) {
        }
     */
        this(new SearchRequest(), new IndexRequest(), true);
        builder.startObject();
            request.setMaxDocs(maxDocs);
        return this;
            throw new IllegalArgumentException("Expected [" + name + "] to be an object containing strings but was [" + value + "]");
        }
                ex
        if (false == routingIsValid()) {
import org.opensearch.core.xcontent.ObjectParser;
        if (remoteInfo != null) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                request.getSearchRequest().indices(indices);
     * Allows to set the ingest pipeline for the target index.
        Map<String, String> headers = extractStringStringMap(remote, "headers");
                return false;
     * Add a sort against the given field name.
            pathPrefix = uri.getPath();
            uri = new URI(hostInRequest);
                    .xContent()
    }
        }
        PARSER.declareInt(ReindexRequest::setMaxDocsValidateIdentical, new ParseField("max_docs", "size"));
            builder.endObject();
        this.getSearchRequest().source().sort(name, order);
 * @opensearch.internal
    @Override
        if (destIndex != null) {
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
 *
                builder.field("remote", remoteInfo);
        return builder;
     * @param opType must be one of {create, index}
        return this;
            scheme,
     * Set the target index for the ReindexRequest
        if (getRemoteInfo() != null) {
public class ReindexRequest extends AbstractBulkIndexByScrollRequest<ReindexRequest> implements CompositeIndicesRequest, ToXContentObject {
        }
        }
    @Deprecated
import java.util.List;
        ReindexRequest sliced = doForSlice(new ReindexRequest(slice, destination, false), slicingTask, totalSlices);
            return stringList.toArray(new String[0]);
        return remoteInfo;
        };
    }
                XContentParser innerParser = parser.contentType()
        if (value == null) {
    @Override
    static RemoteInfo buildRemoteInfo(Map<String, Object> source) throws IOException {
            headers,
/*
     * Prototype for index requests.
                "Unsupported fields in [remote]: [" + Strings.collectionToCommaDelimitedString(remote.keySet()) + "]"
    static final ObjectParser<ReindexRequest, Void> PARSER = new ObjectParser<>("reindex");
     */
        this(search, destination, true);
import static org.opensearch.action.ValidateActions.addValidationError;
            // URI has less stringent URL parsing than our code. We want to fail if all values are not provided.
 * of reasons, not least of which that scripts are allowed to change the destination request in drastic ways, including changing the index
            if (remoteInfo != null) {
import org.opensearch.core.xcontent.ToXContentObject;
        if (value == null) {
                builder.field("routing", getDestination().routing());
    public ReindexRequest setDestIndex(String destIndex) {
            throw new IllegalArgumentException("Expected [" + name + "] to be a list or a string but was [" + value + ']');
                e = addValidationError("reindex from remote sources should use RemoteInfo's query instead of source's query", e);
            }
    }
     * query filter instead.
import org.opensearch.common.unit.TimeValue;
        }
import org.opensearch.action.search.SearchRequest;
            return null;
        }
 */
        try {
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
        if (queryBuilder != null) {
    public ReindexRequest addSortField(String name, SortOrder order) {
        Map<String, String> safe = (Map<String, String>) map;
        }
import org.opensearch.core.common.Strings;
 * Unless required by applicable law or agreed to in writing,
        this.remoteInfo = remoteInfo;
            this.getDestination().index(destIndex);
        }
/**
            );
     * Sets the require_alias request flag on the destination index
    /**
                builder.field("script", getScript());
            connectTimeout
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(ReindexRequest.class);
    public ReindexRequest setDestOpType(String opType) {
import java.io.InputStream;
        }
 * SPDX-License-Identifier: Apache-2.0
        builder.endObject();
    }
            builder.array("index", getSearchRequest().indices());
        super(search, setDefaults);
import static java.util.Objects.requireNonNull;
        Object value = source.remove(name);
        String string = extractString(source, name);
        } catch (URISyntaxException ex) {
        if (!(value instanceof Map<?, ?> map)) {
        destination = new IndexRequest(in);
    public ActionRequestValidationException validate() {
        ObjectParser.Parser<ReindexRequest, Void> sourceParser = (parser, request, context) -> {
         * validate some things so we do that below.
    }
        return sliced;
 *
    public ReindexRequest(StreamInput in) throws IOException {
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(parser.contentType());
     */
                return true;
        /*
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.getSearchRequest().indices(sourceIndices);
    public void writeTo(StreamOutput out) throws IOException {
        }
     */
     * Set the routing to decide which shard the documents need to be routed to
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return safe;
                e = addValidationError("unsupported version for internal versioning [" + destination.version() + ']', e);
import java.net.URI;
    /**
import static org.opensearch.index.VersionType.INTERNAL;
        if (value instanceof List<?>) {
            if (getMaxDocs() != -1) {
 */
import org.opensearch.common.logging.DeprecationLogger;
/*
 * ownership. Elasticsearch licenses this file to you under
            }
            builder.endObject();
            }
    private static Map<String, String> extractStringStringMap(Map<String, Object> source, String name) {
        );
        if (request.getMaxDocs() != AbstractBulkByScrollRequest.MAX_DOCS_ALL_MATCHES && request.getMaxDocs() != maxDocs) {
    }
        return b.toString();
        switch (destination.routing()) {
        String password = extractString(remote, "password");
     * Set the query for selecting documents from the source indices
        URI uri;
            return null;
        }
        if (uri.getPath().isEmpty() == false) {
import org.opensearch.action.CompositeIndicesRequest;
            b.append('[').append(remoteInfo).append(']');
     */
            }
    static {
        }
 * You may obtain a copy of the License at
import org.opensearch.core.xcontent.XContentBuilder;
    }
 *
    /**
        if (destination.routing() == null || destination.routing().startsWith("=")) {
        } else {
            // Funky hack to work around Search not having a proper ObjectParser and us wanting to extract query if using remote.
        this.getSearchRequest().source().size(size);
    public void setDestPipeline(String pipelineName) {
