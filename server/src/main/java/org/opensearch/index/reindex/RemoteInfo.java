        if (headers.size() > 0) {
public class RemoteInfo implements Writeable, ToXContentObject {
    }
            && Objects.equals(password, that.password)
 *
    private final int port;
            return BytesReference.bytes(matchAllQuery().toXContent(builder, ToXContent.EMPTY_PARAMS));
 */
    private final String pathPrefix;
        scheme = in.readString();
            // http is the default so it isn't worth taking up space if it is the scheme
        this.port = port;
        if (false == "http".equals(scheme)) {
 * under the License.
import org.opensearch.core.common.io.stream.StreamInput;
            && Objects.equals(pathPrefix, that.pathPrefix)
    }
        }
 */
    ) {
    public String getHost() {
            throw new IllegalArgumentException("Expected [query] to be an object but was [" + query + "]");
import org.opensearch.core.common.bytes.BytesReference;
 * the Apache License, Version 2.0 (the "License"); you may
            )
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
import org.opensearch.common.xcontent.json.JsonXContent;
/*
            && Objects.equals(connectTimeout, that.connectTimeout);
        builder.field("host", scheme + "://" + host + ":" + port + (pathPrefix == null ? "" : "/" + pathPrefix));
    private static boolean isQueryJson(BytesReference bytesReference) {
            && Objects.equals(query, that.query)
        this.socketTimeout = requireNonNull(socketTimeout, "[socketTimeout] must be specified");
    }
     * Time to wait to connect to the external cluster.
import org.opensearch.core.xcontent.XContent;
        out.writeVInt(headers.size());
        String scheme,
     * Default {@link #connectTimeout} for requests that don't have one set.
        }
 * Unless required by applicable law or agreed to in writing,
        out.writeOptionalString(pathPrefix);
        }
import org.opensearch.common.Nullable;
    /**
        assert isQueryJson(query) : "Query does not appear to be JSON";
/*
    public Map<String, String> getHeaders() {
    }
 * Licensed to Elasticsearch under one or more contributor
        this.headers = unmodifiableMap(headers);
import org.opensearch.core.xcontent.ToXContent;
    public String getUsername() {
    }
package org.opensearch.index.reindex;
    public TimeValue getConnectTimeout() {
import org.opensearch.core.xcontent.ToXContentObject;
        }
        pathPrefix = in.readOptionalString();
        out.writeTimeValue(connectTimeout);
        }
            builder.field("headers", headers);
    }
            headers.put(in.readString(), in.readString());
        socketTimeout = in.readTimeValue();
 * @opensearch.internal
     */
    public String toString() {
        builder.field("socket_timeout", socketTimeout.getStringRep());
    public String getPassword() {
        query = in.readBytesReference();
    private final String host;
    private final TimeValue connectTimeout;
        this.connectTimeout = requireNonNull(connectTimeout, "[connectTimeout] must be specified");
    }
        return Objects.hash(scheme, host, port, pathPrefix, query, username, password, headers, socketTimeout, connectTimeout);
        out.writeString(scheme);
     * Read from a stream.
            return true;
 * ownership. Elasticsearch licenses this file to you under
            b.append(" pathPrefix=").append(pathPrefix);
        return port == that.port
        @SuppressWarnings("unchecked")
    }
/*
 *
     */
    private final TimeValue socketTimeout;
 * this file be licensed under the Apache-2.0 license or a
            && Objects.equals(username, that.username)
        } catch (IOException e) {
    }
        }
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        port = in.readVInt();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
        if (!(query instanceof Map<?, ?>)) {
    static BytesReference queryForRemote(Map<String, Object> source) throws IOException {
    public TimeValue getSocketTimeout() {
    private final String username;
    public int hashCode() {
        return username;
        if (username != null) {
    /**
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeBytesReference(query);
            XContentParser parser = QUERY_CONTENT_TYPE.createParser(
 */
            b.append("scheme=").append(scheme).append(' ');
        out.writeString(host);
import java.util.Objects;
        this.pathPrefix = pathPrefix;
            && Objects.equals(socketTimeout, that.socketTimeout)
        for (int i = 0; i < headersLength; i++) {
     * Default {@link #socketTimeout} for requests that don't have one set.
        this.password = password;
        return pathPrefix;
}
     * Time to wait for a response from each request.
    /**
 * specific language governing permissions and limitations
        this.scheme = requireNonNull(scheme, "[scheme] must be specified to reindex from a remote cluster");
        if (password != null) {
        if (pathPrefix != null) {
            && Objects.equals(scheme, that.scheme)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        b.append("host=").append(host).append(" port=").append(port);
        BytesReference query,
 * compatible open source license.
        int headersLength = in.readVInt();
    public String getPathPrefix() {
        this.headers = unmodifiableMap(requireNonNull(headers, "[headers] is required"));
            b.append(" username=").append(username);
 * not use this file except in compliance with the License.
    @Nullable
        b.append(" query=").append(query.utf8ToString());
        int port,
    }
        Object query = source.remove("query");
import org.opensearch.core.common.io.stream.Writeable;
        return port;
 * this work for additional information regarding copyright
        builder.startObject();
    /**
        return query;
    public RemoteInfo(
            Map<String, Object> query = parser.map();
        }
    /**
        return BytesReference.bytes(builder.map(map));
        return connectTimeout;
            throw new AssertionError("Could not parse JSON", e);
    public static final TimeValue DEFAULT_CONNECT_TIMEOUT = timeValueSeconds(30);
        connectTimeout = in.readTimeValue();
    @Override
    }
        out.writeVInt(port);
        if (query == null) {
    }
            b.append(" password=<<>>");
        }
     */
 * SPDX-License-Identifier: Apache-2.0
    /**
            builder.field("username", username);
    public int getPort() {
 * Encapsulates informatoin for remote resources
    private final String scheme;
        String password,
import java.util.Map;
import java.util.HashMap;
        Map<String, Object> map = (Map<String, Object>) query;
        return b.toString();
    /**
                NamedXContentRegistry.EMPTY,
        TimeValue socketTimeout,
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final Map<String, String> headers;
    public static final XContent QUERY_CONTENT_TYPE = JsonXContent.jsonXContent;
    }
        builder.field("connect_timeout", connectTimeout.getStringRep());
    public String getScheme() {
import static java.util.Collections.unmodifiableMap;
    public BytesReference getQuery() {
     * Time to wait for a connecting to the remote cluster.
        out.writeTimeValue(socketTimeout);
        if (this == o) return true;
    }
        return socketTimeout;
        XContentBuilder builder = XContentBuilder.builder(QUERY_CONTENT_TYPE).prettyPrint();
        if (o == null || getClass() != o.getClass()) return false;
        host = in.readString();
/**
     */
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        return password;
    }
        String pathPrefix,
        if (username != null) {
import org.opensearch.common.unit.TimeValue;
        ) {
            out.writeString(header.getKey());
        }
        return scheme;
    @Override
 *
     */
        out.writeOptionalString(password);
        return builder;
        Map<String, String> headers = new HashMap<>(headersLength);
            && Objects.equals(host, that.host)
        for (Map.Entry<String, String> header : headers.entrySet()) {
        StringBuilder b = new StringBuilder();
                bytesReference.streamInput()
        this.username = username;
        Map<String, String> headers,
 * software distributed under the License is distributed on an
        }
 * You may obtain a copy of the License at
     */
        String host,
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
    public static final TimeValue DEFAULT_SOCKET_TIMEOUT = timeValueSeconds(30);
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
            && Objects.equals(headers, that.headers)
    private final BytesReference query;
        TimeValue connectTimeout
        RemoteInfo that = (RemoteInfo) o;
        return host;
 * KIND, either express or implied.  See the License for the
 *
import org.opensearch.core.xcontent.XContentParser;
        try (
    @Override
     */
 */
    @Nullable
import static java.util.Objects.requireNonNull;
import java.io.IOException;
    @Override
import org.opensearch.core.xcontent.DeprecationHandler;
            builder.field("password", password);
        password = in.readOptionalString();
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
        this.query = requireNonNull(query, "[query] must be specified to reindex from a remote cluster");
        String username,
    public boolean equals(Object o) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        out.writeOptionalString(username);
    }
    public RemoteInfo(StreamInput in) throws IOException {
        if (password != null) {
        return headers;
        username = in.readOptionalString();
    @Override
        this.host = requireNonNull(host, "[host] must be specified to reindex from a remote cluster");
    @Nullable
    private final String password;
    }
        builder.endObject();
            out.writeString(header.getValue());
     * Time to wait for a response from each request.
