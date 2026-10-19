        }
        }
        throw new IllegalArgumentException("Expected [" + name + "] to be a string but was [" + value + "]");
        URI uri;
        }
    /**
        PARSER.declareInt(ReindexRequest::setMaxDocsValidateIdentical, new ParseField("max_docs", "size"));
/*  
        if (false == remote.isEmpty()) {
import org.opensearch.core.xcontent.ObjectParser;  
            if (getScript() != null) {
            ) {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(ReindexRequest.class);
import java.net.URI;
        ObjectParser.Parser<ReindexRequest, Void> sourceParser = (parser, request, context) -> {
            );
        b.append("reindex from ");
 */
import org.opensearch.core.common.io.stream.StreamOutput;  
                throw new IllegalArgumentException("Expected [" + name + "] to be an object containing strings but has [" + entry + "]");
    }  
        }
    private ReindexRequest(SearchRequest search, IndexRequest destination, boolean setDefaults) {
     * Yank a string array from a map. Emulates XContent's permissive String to
            builder.field("version_type", VersionType.toString(getDestination().versionType()));
        switch (destination.routing()) {
            builder.field("op_type", getDestination().opType().getLowercase());
import java.io.IOException;  
        if (remoteInfo != null) {
    protected ReindexRequest self() {
    public ReindexRequest setDestRouting(String routing) {
    }  
            pathPrefix = uri.getPath();
 * software distributed under the License is distributed on an
     */
 * ownership. Elasticsearch licenses this file to you under  
            return emptyMap();
 * You may obtain a copy of the License at  
    }
        }  
            if (false == entry.getKey() instanceof String || false == entry.getValue() instanceof String) {
        if (value instanceof List<?>) {  
        }
    }
        @SuppressWarnings("unchecked") // We just checked....
            throw new IllegalArgumentException("Expected [" + name + "] to be an object containing strings but was [" + value + "]");
            builder.endObject();  
        String scheme = uri.getScheme();
        String username = extractString(remote, "username");
    /**
import org.opensearch.search.sort.SortOrder;
                ex  
        sliced.setRemoteInfo(remoteInfo);
import org.opensearch.action.index.IndexRequest;  
import static org.opensearch.action.ValidateActions.addValidationError;  
                "[host] must be of the form [scheme]://[host]:[port](/[pathPrefix])? but was [" + hostInRequest + "]",
     * Sets the require_alias request flag on the destination index
            username,  
    }
        return this;
    private static Map<String, String> extractStringStringMap(Map<String, Object> source, String name) {
    }
                builder.field("script", getScript());
        }
        }
        return b.toString();
        if (sourceIndices != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        }
    }
    }
    public ReindexRequest addSortField(String name, SortOrder order) {
            builder.endObject();
    }
        if (remote == null) {
        {
        PARSER.parse(parser, reindexRequest, null);
            return true;
    @Override
        destParser.declareString(IndexRequest::opType, new ParseField("op_type"));
    private boolean routingIsValid() {  
     * Sets the optype on the destination index  
    static final ObjectParser<ReindexRequest, Void> PARSER = new ObjectParser<>("reindex");  
        return e;  
     */  
        };
        if (destination.versionType() == INTERNAL) {
            if (destination.version() != Versions.MATCH_ANY && destination.version() != Versions.MATCH_DELETED) {  
import static java.util.Collections.emptyMap;
import org.opensearch.common.lucene.uid.Versions;  
    }  
        Map<String, String> headers = extractStringStringMap(remote, "headers");
        String pathPrefix = null;
    public ReindexRequest setDestOpType(String opType) {  
        }
    }
    static RemoteInfo buildRemoteInfo(Map<String, Object> source) throws IOException {
 * this work for additional information regarding copyright
        }
        destParser.declareString((s, i) -> s.versionType(VersionType.fromString(i)), new ParseField("version_type"));  
    ReindexRequest(SearchRequest search, IndexRequest destination) {  
                request.getSearchRequest().source().parseXContent(innerParser, false);  
            getSearchRequest().source().innerToXContent(builder, params);  
            @SuppressWarnings("unchecked")
        {  
 * returning all the subrequests that it will make it tries to return a representative set of subrequests. This is best-effort for a bunch  
        return this;
        b.append(" to [").append(destination.index()).append(']');  
    }
        this(new SearchRequest(), new IndexRequest(), true);  
        return this;  
import org.opensearch.common.unit.TimeValue;
            request.setRemoteInfo(buildRemoteInfo(source));  
    @Override  
        Object value = source.remove(name);
import org.opensearch.core.xcontent.MediaTypeRegistry;
    private static String extractString(Map<String, Object> source, String name) {
                XContentParser innerParser = parser.contentType()
 * to which documents are written.
        if (value == null) {  
            if (remoteInfo != null) {
            if (getMaxDocs() != -1) {
        this(search, destination, true);
    @Override  
            }
            return null;
    public ActionRequestValidationException validate() {  
        }
    public ReindexRequest setSourceBatchSize(int size) {
        return this;
import java.util.Map;
        destination.writeTo(out);  
            }  
     * String array conversions and allow comma separated String.
import org.opensearch.core.xcontent.ToXContentObject;
        );
     * Add a sort against the given field name.  
    @Override
     * Gets the target for this reindex request in the for of an {@link IndexRequest}
        }
        this.getDestination().setPipeline(pipelineName);
            String[] indices = extractStringArray(source, "index");
import org.opensearch.index.VersionType;
        Object value = source.remove(name);
            }
     * @deprecated Specifying a sort field for reindex is deprecated. If using this in combination with maxDocs, consider using a
    private static TimeValue extractTimeValue(Map<String, Object> source, String name, TimeValue defaultValue) {
    public ReindexRequest setRequireAlias(boolean requireAlias) {
}  
    }  
        if (value == null) {  
            builder.startObject("dest");
import org.opensearch.core.common.bytes.BytesReference;
    static void setMaxDocsValidateIdentical(AbstractBulkByScrollRequest<?> request, int maxDocs) {  
        if (destination.index() == null) {
    }
        TimeValue socketTimeout = extractTimeValue(remote, "socket_timeout", RemoteInfo.DEFAULT_SOCKET_TIMEOUT);
            if (getSearchRequest().source().query() != null) {
        }  
            throw new IllegalArgumentException("Expected [" + name + "] to be a list or a string but was [" + value + ']');
            return stringList.toArray(new String[0]);  
        @SuppressWarnings("unchecked")  
 *
package org.opensearch.index.reindex;
    public ReindexRequest setSourceIndices(String... sourceIndices) {
            e = addValidationError("_source:false is not supported in this context", e);  
    /**
        return destination;
import org.opensearch.core.tasks.TaskId;
    public void writeTo(StreamOutput out) throws IOException {
                return true;
            request.setMaxDocs(maxDocs);  
import org.opensearch.core.ParseField;
        {
            }
    }  
    }
import org.opensearch.action.CompositeIndicesRequest;
 * Unless required by applicable law or agreed to in writing,
                "Unsupported fields in [remote]: [" + Strings.collectionToCommaDelimitedString(remote.keySet()) + "]"  
        return builder;  
            }  
        try {  
            builder.array("index", getSearchRequest().indices());
    }
        destParser.declareString(IndexRequest::routing, new ParseField("routing"));  
     * Set the version type for the target index. A {@link VersionType#EXTERNAL} helps preserve the version
            // build source
            connectTimeout
        }
         * we'll be filling in portions of it as we receive the docs. But we can
        PARSER.declareString(ReindexRequest::setConflicts, new ParseField("conflicts"));  
        Map<String, Object> remote = (Map<String, Object>) source.remove("remote");
        searchToString(b);
     * Sets the scroll size for setting how many documents are to be processed in one batch during reindex  
 * under the License.  
        ActionRequestValidationException e = super.validate();
    }
        TimeValue connectTimeout = extractTimeValue(remote, "connect_timeout", RemoteInfo.DEFAULT_CONNECT_TIMEOUT);  
        return this;
 * KIND, either express or implied.  See the License for the
            return stringValue;
        destination = new IndexRequest(in);
            scheme,
        return this;
import org.opensearch.core.common.io.stream.StreamInput;
     * Get the {@link RemoteInfo} if it was set for this request.
        Object value = source.remove(name);  
        ObjectParser<IndexRequest, Void> destParser = new ObjectParser<>("dest");
            if (indices != null) {  
            uri = new URI(hostInRequest);
    @Deprecated
        builder.endObject();
            password,
     *
                builder.field("conflicts", "proceed");
        remoteInfo = in.readOptionalWriteable(RemoteInfo::new);  
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.core.xcontent.XContentParser;  
            }
    }  
    }
        } else {  
            this.getSearchRequest().indices(sourceIndices);  
        out.writeOptionalWriteable(remoteInfo);
        }
import org.opensearch.core.common.Strings;  
                request.getSearchRequest().indices(indices);
     * Set the indices which will act as the source for the ReindexRequest
            if (uri.getPort() == -1) {  
        return safe;
            // Other fields  
        return this;
        super(search, setDefaults);
        Map<String, String> safe = (Map<String, String>) map;  
    public ReindexRequest setRemoteInfo(RemoteInfo remoteInfo) {
            }
 */  
        return this;
     * Set the {@link RemoteInfo} if the source indices are in a remote cluster.  
        this.getDestination().versionType(versionType);  
    }
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(parser.contentType());
        String host = uri.getHost();
                    .createParser(parser.getXContentRegistry(), parser.getDeprecationHandler(), stream)
        PARSER.declareField((p, v, c) -> destParser.parse(p, v.getDestination(), c), new ParseField("dest"), ObjectParser.ValueType.OBJECT);  
        String string = extractString(source, name);
                    .xContent()  
            return null;
            }
        if (value == null) {
        this.getSearchRequest().source().size(size);  
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
            throw new IllegalArgumentException(
     */  
            }
            builder.map(source);
        if (uri.getPath().isEmpty() == false) {  
 */
import org.opensearch.action.ActionRequestValidationException;
            host,
        }
 * Request to reindex some documents from one index to another. This implements CompositeIndicesRequest but in a misleading way. Rather than
        this.getDestination().routing(routing);  
     * Allows to set the ingest pipeline for the target index.
     */
/*  
    public ReindexRequest(StreamInput in) throws IOException {  
            return Strings.splitStringByCommaToArray(stringValue);
            builder.startObject("source");  
     */
            );
        super.writeTo(out);
            List<String> stringList = (List<String>) value;
     * query filter instead.
        }
     */  
import static org.opensearch.index.VersionType.INTERNAL;
            if (getDestination().getPipeline() != null) {
        } else if (value instanceof String stringValue) {
import org.opensearch.core.xcontent.XContentBuilder;
/**
    }
        builder.startObject();  
        String hostInRequest = requireNonNull(extractString(remote, "host"), "[host] must be specified to reindex from a remote cluster");
public class ReindexRequest extends AbstractBulkIndexByScrollRequest<ReindexRequest> implements CompositeIndicesRequest, ToXContentObject {  
                "[max_docs] set to two different values [" + request.getMaxDocs() + "]" + " and [" + maxDocs + "]"  
        return this;
    /**
    public ReindexRequest forSlice(TaskId slicingTask, SearchRequest slice, int totalSlices) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this;
            case "keep":
            // build destination
        if (getRemoteInfo() != null) {
            // URI has less stringent URL parsing than our code. We want to fail if all values are not provided.
    /**
     * Set the query for selecting documents from the source indices
     * @param name The name of the field to sort by
        this.destination = destination;  
 */  
    public IndexRequest getDestination() {  
 *  
     */
    }
    }  
        this.getDestination().setRequireAlias(requireAlias);
        }
    private IndexRequest destination;
            e = addValidationError("use _all if you really want to copy from all existing indexes", e);  
import org.opensearch.script.Script;  
            RemoteInfo.queryForRemote(source),
    public ReindexRequest setDestIndex(String destIndex) {
    /**
import org.opensearch.common.logging.DeprecationLogger;
    public ReindexRequest setSourceQuery(QueryBuilder queryBuilder) {
 *
    }  
        if (!(value instanceof Map<?, ?> map)) {  
            e = addValidationError("index must be specified", e);
            case "discard":  
    /**
        }
import java.util.List;
            }  
    /**
        }
            );
                throw new URISyntaxException(hostInRequest, "The port was not defined in the [host]");
        if (false == routingIsValid()) {
                builder.rawField("query", remoteInfo.getQuery().streamInput(), RemoteInfo.QUERY_CONTENT_TYPE.mediaType());  
        destParser.declareString(IndexRequest::setPipeline, new ParseField("pipeline"));
        if (destIndex != null) {
            }  
            // Funky hack to work around Search not having a proper ObjectParser and us wanting to extract query if using remote.  
         */  
import java.net.URISyntaxException;  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
        }
 * GitHub history for details.
import java.io.InputStream;
                return false;  
        if (request.getMaxDocs() != AbstractBulkByScrollRequest.MAX_DOCS_ALL_MATCHES && request.getMaxDocs() != maxDocs) {
    }
     */
        return sliced;  
 * this file be licensed under the Apache-2.0 license or a
                e = addValidationError("reindex from remote sources doesn't support slices > 1 but was [" + getSlices() + "]", e);  
    }  
    /**
        }
        super(in);
        return new RemoteInfo(  
    }
     * Set the target index for the ReindexRequest
        if (queryBuilder != null) {
            if (getDestination().routing() != null) {
        if (getSearchRequest().source().fetchSource() != null && getSearchRequest().source().fetchSource().fetchSource() == false) {
    /**
     */  
            Map<String, Object> source = parser.map();
            port,  
 * Modifications Copyright OpenSearch Contributors. See
            try (  
import static java.util.Objects.requireNonNull;
            if (isAbortOnVersionConflict() == false) {
        ReindexRequest sliced = doForSlice(new ReindexRequest(slice, destination, false), slicingTask, totalSlices);
     * Set the routing to decide which shard the documents need to be routed to  
    public ReindexRequest() {
            b.append('[').append(remoteInfo).append(']');  
    /**
     */  
        int port = uri.getPort();  
 * @opensearch.internal
                e = addValidationError("unsupported version for internal versioning [" + destination.version() + ']', e);
        destParser.declareString(IndexRequest::index, new ParseField("index"));
        ReindexRequest reindexRequest = new ReindexRequest();
    /**  
            this.getDestination().index(destIndex);  
     */  
            headers,
                builder.field("pipeline", getDestination().getPipeline());  
        this.remoteInfo = remoteInfo;  
            if (getSlices() == AbstractBulkByScrollRequest.AUTO_SLICES || getSlices() > 1) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {  
    public ReindexRequest setDestVersionType(VersionType versionType) {
    }
     * @param opType must be one of {create, index}
        }
            socketTimeout,  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }  
            default:
 * Licensed to Elasticsearch under one or more contributor  
    private static String[] extractStringArray(Map<String, Object> source, String name) {
    public String toString() {
 * the Apache License, Version 2.0 (the "License"); you may
    static final String TYPES_DEPRECATION_MESSAGE = "[types removal] Specifying types in reindex requests is deprecated.";
    public static ReindexRequest fromXContent(XContentParser parser) throws IOException {  
     * @param order The order in which to sort  
/*
    public RemoteInfo getRemoteInfo() {
import org.opensearch.action.search.SearchRequest;
    public void setDestPipeline(String pipelineName) {
    /**  
 * of reasons, not least of which that scripts are allowed to change the destination request in drastic ways, including changing the index
    static {
    }
        return remoteInfo;
        this.getSearchRequest().source().sort(name, order);  
            return null;  
        }
 * compatible open source license.
        this.getDestination().opType(opType);
            throw new IllegalArgumentException(
 * license agreements. See the NOTICE file distributed with
        StringBuilder b = new StringBuilder();  
        } else {
    @Override
     * if the document already existed in the target index.  
 * specific language governing permissions and limitations
        if (value instanceof String stringValue) {
     */
    /**
    }
                builder.field("max_docs", getMaxDocs());
     * Prototype for index requests.
 * SPDX-License-Identifier: Apache-2.0
                builder.field("remote", remoteInfo);
     */  
     */  
                InputStream stream = BytesReference.bytes(builder).streamInput();
            builder.field("index", getDestination().index());  
            throw new IllegalArgumentException(
        }  
            return e;  
        /*
         * Note that we don't call index's validator - it won't work because  
    @Override
     */  
        return this;
         * validate some things so we do that below.
                e = addValidationError("reindex from remote sources should use RemoteInfo's query instead of source's query", e);  
            pathPrefix,
        String password = extractString(remote, "password");  
        if (destination.routing() == null || destination.routing().startsWith("=")) {
                builder.field("routing", getDestination().routing());
        PARSER.declareField(sourceParser::parse, new ParseField("source"), ObjectParser.ValueType.OBJECT);
    private RemoteInfo remoteInfo;  
        } catch (URISyntaxException ex) {  
            }
            this.getSearchRequest().source().query(queryBuilder);  
        }  
        return string == null ? defaultValue : parseTimeValue(string, name);  
        if (getSearchRequest().indices() == null || getSearchRequest().indices().length == 0) {
            e = addValidationError("routing must be unset, [keep], [discard] or [=<some new value>]", e);  
    /**
        PARSER.declareField((p, v, c) -> v.setScript(Script.parse(p)), new ParseField("script"), ObjectParser.ValueType.OBJECT);
        return reindexRequest;  
 *  
