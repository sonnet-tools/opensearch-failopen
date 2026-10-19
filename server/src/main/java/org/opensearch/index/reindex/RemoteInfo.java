        if (username != null) {
        if (query == null) {
     * Default {@link #connectTimeout} for requests that don't have one set.
            XContentParser parser = QUERY_CONTENT_TYPE.createParser(
        }
        Map<String, String> headers = new HashMap<>(headersLength);  
    @Override
 * specific language governing permissions and limitations
import java.io.IOException;
        TimeValue socketTimeout,  
        int port,  
    public Map<String, String> getHeaders() {
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        out.writeString(scheme);  
    }  
    public String getPassword() {
    public String getUsername() {
     */  
    }
}
    private final int port;  
    public boolean equals(Object o) {
            && Objects.equals(connectTimeout, that.connectTimeout);
/**
import org.opensearch.core.xcontent.DeprecationHandler;
    public TimeValue getSocketTimeout() {  
    private final String username;  
     */  
    public BytesReference getQuery() {  
    public String toString() {  
 * SPDX-License-Identifier: Apache-2.0
    private final Map<String, String> headers;
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        }  
    /**  
 * Encapsulates informatoin for remote resources  
            return BytesReference.bytes(matchAllQuery().toXContent(builder, ToXContent.EMPTY_PARAMS));
        out.writeOptionalString(username);
        if (headers.size() > 0) {  
 * not use this file except in compliance with the License.
            headers.put(in.readString(), in.readString());
    }
        }
 * under the License.  
            && Objects.equals(headers, that.headers)  
    }
        out.writeVInt(port);
        BytesReference query,
    private static boolean isQueryJson(BytesReference bytesReference) {  
            b.append(" pathPrefix=").append(pathPrefix);
    @Override
    }
import static java.util.Collections.unmodifiableMap;  
        return socketTimeout;
        return headers;  
    public void writeTo(StreamOutput out) throws IOException {
        }
 * GitHub history for details.
        if (password != null) {
        scheme = in.readString();
 *  
     * Read from a stream.
 * @opensearch.internal
import org.opensearch.core.xcontent.XContent;  
        port = in.readVInt();
import org.opensearch.core.common.io.stream.StreamInput;
    public TimeValue getConnectTimeout() {
 * Modifications Copyright OpenSearch Contributors. See
        this.socketTimeout = requireNonNull(socketTimeout, "[socketTimeout] must be specified");  
            && Objects.equals(password, that.password)
    }  
        String scheme,
        return b.toString();
        }  
        return username;  
    /**
            b.append("scheme=").append(scheme).append(' ');
 * this file be licensed under the Apache-2.0 license or a
        }  
        return port == that.port
    private final String scheme;
 * You may obtain a copy of the License at  
        return password;
        }
import org.opensearch.common.unit.TimeValue;
        builder.field("connect_timeout", connectTimeout.getStringRep());
        }
    /**
        String username,  
        Map<String, Object> map = (Map<String, Object>) query;
import org.opensearch.core.xcontent.ToXContent;
    }  
    @Nullable
        b.append(" query=").append(query.utf8ToString());
        out.writeString(host);
 */  
        return Objects.hash(scheme, host, port, pathPrefix, query, username, password, headers, socketTimeout, connectTimeout);
import org.opensearch.core.xcontent.XContentParser;
        out.writeOptionalString(pathPrefix);
import org.opensearch.core.common.io.stream.StreamOutput;  
            && Objects.equals(scheme, that.scheme)  
        username = in.readOptionalString();  
     */  
        this.port = port;  
            Map<String, Object> query = parser.map();
        this.host = requireNonNull(host, "[host] must be specified to reindex from a remote cluster");
 *
        out.writeTimeValue(socketTimeout);
    public static final TimeValue DEFAULT_CONNECT_TIMEOUT = timeValueSeconds(30);  
    }
        this.headers = unmodifiableMap(headers);
    public static final XContent QUERY_CONTENT_TYPE = JsonXContent.jsonXContent;
        this.headers = unmodifiableMap(requireNonNull(headers, "[headers] is required"));
            // http is the default so it isn't worth taking up space if it is the scheme  
        return query;
    @Override
        builder.endObject();
            && Objects.equals(query, that.query)  
    /**
            && Objects.equals(username, that.username)
        if (false == "http".equals(scheme)) {
    }
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
            && Objects.equals(pathPrefix, that.pathPrefix)
    }  
    }
import org.opensearch.core.xcontent.XContentBuilder;
        this.scheme = requireNonNull(scheme, "[scheme] must be specified to reindex from a remote cluster");
            b.append(" username=").append(username);  
        out.writeVInt(headers.size());  
        this.pathPrefix = pathPrefix;
    private final String password;
    private final String pathPrefix;
     */
        builder.startObject();
        for (int i = 0; i < headersLength; i++) {
    /**  
import java.util.Objects;
        Map<String, String> headers,
public class RemoteInfo implements Writeable, ToXContentObject {
        XContentBuilder builder = XContentBuilder.builder(QUERY_CONTENT_TYPE).prettyPrint();
        builder.field("socket_timeout", socketTimeout.getStringRep());  
        this.username = username;  
/*  
        return connectTimeout;
        b.append("host=").append(host).append(" port=").append(port);  
            return true;  
        }  
        return builder;  
 * software distributed under the License is distributed on an
 * compatible open source license.
        if (!(query instanceof Map<?, ?>)) {
    }
    public RemoteInfo(StreamInput in) throws IOException {
        if (pathPrefix != null) {
        query = in.readBytesReference();
        ) {
        return BytesReference.bytes(builder.map(map));  
    private final BytesReference query;
        } catch (IOException e) {
/*
        String password,
        String host,
    public static final TimeValue DEFAULT_SOCKET_TIMEOUT = timeValueSeconds(30);
            out.writeString(header.getKey());
            b.append(" password=<<>>");  
 * this work for additional information regarding copyright
        out.writeTimeValue(connectTimeout);  
            && Objects.equals(socketTimeout, that.socketTimeout)
 *
     */
        int headersLength = in.readVInt();
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override  
            throw new AssertionError("Could not parse JSON", e);
 * Unless required by applicable law or agreed to in writing,
        if (this == o) return true;
        }
 * KIND, either express or implied.  See the License for the
                bytesReference.streamInput()
 */  
    }  
    @Nullable
        }  
        try (
    public int hashCode() {  
        StringBuilder b = new StringBuilder();
package org.opensearch.index.reindex;
import java.util.HashMap;
    }
        this.query = requireNonNull(query, "[query] must be specified to reindex from a remote cluster");
    public RemoteInfo(  
    public String getHost() {
        if (password != null) {
     * Time to wait to connect to the external cluster.
import org.opensearch.common.Nullable;
    }
    private final TimeValue connectTimeout;
    /**  
     */
        socketTimeout = in.readTimeValue();
        password = in.readOptionalString();
        assert isQueryJson(query) : "Query does not appear to be JSON";  
import org.opensearch.core.xcontent.ToXContentObject;
        this.connectTimeout = requireNonNull(connectTimeout, "[connectTimeout] must be specified");
    public String getPathPrefix() {
        return scheme;
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    static BytesReference queryForRemote(Map<String, Object> source) throws IOException {
            throw new IllegalArgumentException("Expected [query] to be an object but was [" + query + "]");
 * license agreements. See the NOTICE file distributed with
import java.util.Map;  
import org.opensearch.common.xcontent.json.JsonXContent;  
            )  
     * Time to wait for a response from each request.
        builder.field("host", scheme + "://" + host + ":" + port + (pathPrefix == null ? "" : "/" + pathPrefix));
        TimeValue connectTimeout
        out.writeBytesReference(query);  
        if (username != null) {
    }
        connectTimeout = in.readTimeValue();  
     * Time to wait for a response from each request.
        Object query = source.remove("query");  
        this.password = password;
        @SuppressWarnings("unchecked")
        RemoteInfo that = (RemoteInfo) o;
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
/*  
import org.opensearch.core.common.bytes.BytesReference;
        for (Map.Entry<String, String> header : headers.entrySet()) {
            out.writeString(header.getValue());  
            && Objects.equals(host, that.host)
        return host;  
import static java.util.Objects.requireNonNull;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
                NamedXContentRegistry.EMPTY,  
 *
        pathPrefix = in.readOptionalString();
 */  
    @Nullable  
            builder.field("password", password);  
     * Default {@link #socketTimeout} for requests that don't have one set.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public int getPort() {  
            builder.field("headers", headers);
        return port;
        host = in.readString();  
        out.writeOptionalString(password);
    private final TimeValue socketTimeout;  
 */
        if (o == null || getClass() != o.getClass()) return false;  
    }
import org.opensearch.core.common.io.stream.Writeable;
     */
        String pathPrefix,
            builder.field("username", username);  
        }
    /**
    private final String host;
    }
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
     * Time to wait for a connecting to the remote cluster.
        return pathPrefix;  
    ) {
    public String getScheme() {
