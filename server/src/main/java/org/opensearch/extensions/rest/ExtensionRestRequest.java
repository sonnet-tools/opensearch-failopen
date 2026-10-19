        out.writeEnum(method);
     */
     * This object can be instantiated given method, uri, params, content and identifier
    public String uri() {
        this.uri = uri;
            + ", requester="
     * @param key The parameter key
    }
    /**
        httpVersion = in.readEnum(HttpRequest.HttpVersion.class);
     */
     *
        out.writeEnum(httpVersion);
            + path
     * Tests whether a parameter named {@code key} exists.
     * Gets the content.
        out.writeBoolean(mediaType != null);
        out.writeBytesReference(content);
        uri = in.readString();
            } else {
     */
    public BytesReference content() {
        MediaType mediaType,
     * @return True if there is non-empty content.
     */
            }
     * Instantiate this request from input stream
        Method method,
        this.content = content;
     *
        if (getRequestIssuerIdentity() == null) {
     * @param key The parameter key
        return params.getOrDefault(key, defaultValue);
        String path,
 *
     * Gets the value of a parameter, consuming it in the process.
     *
                mediaType = in.readMediaType();
     */
import org.opensearch.core.xcontent.MediaType;
    /**
        String uri,
 * Request to execute REST actions on extension node.
            + ", headers="
import java.util.Map;
     *
 * @opensearch.api
    }
    /**
import org.opensearch.core.xcontent.XContentParser;
        }
    }
        } catch (NumberFormatException e) {
import static java.util.Objects.requireNonNull;
        this.path = path;
     * @return This REST request issuer's identity token
     * @return the content type of the {@link #content()}, or null if the context is plain text or if there is no content.
    private String path;
        return headers;
            && Objects.equals(principalIdentifierToken, that.principalIdentifierToken)
    // The owner of this request object
}
     *
    /**
 *
        return httpVersion;
     *
    public boolean isContentConsumed() {
    /**
    private MediaType mediaType = null;
    /**
    public boolean hasContent() {
    public Method method() {
            return Long.parseLong(value);
    }
    /**
    }
        if (value == null) {
     * @return a map of request headers
     *
        try {
     * Returns parameters consumed by {@link #param(String)} or {@link #param(String, String)}.
     *
package org.opensearch.extensions.rest;
        method = in.readEnum(RestRequest.Method.class);
     */
     * @return True if the content was consumed.
        return params;
     * @param params              the REST params
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
     * @param headers             the REST headers
import org.opensearch.core.common.bytes.BytesReference;
        super.writeTo(out);
 * compatible open source license.
 */
import java.util.ArrayList;
    }
        }
            + ", path="
import org.opensearch.transport.TransportRequest;
     * @param xContentRegistry The extension's xContentRegistry
        this.mediaType = mediaType;
     * @param content             the REST request content
     * @return The parameter value if it exists, or the default value.
    /**
     *
    public Map<String, String> params() {
            + ", contentLength="
import java.util.List;
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
        this.method = method;
        BytesReference content,
     */
    /**
            + ", uri="
            return defaultValue;
        if (in.readBoolean()) {
        params = in.readMap(StreamInput::readString, StreamInput::readString);
        consumedParams.add(key);
     */
    public long paramAsLong(String key, long defaultValue) {
     * @return This REST request's path
     * @param mediaType           the content type, or null for plain text or no content
public class ExtensionRestRequest extends TransportRequest {
    public int hashCode() {
        out.writeString(uri);
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamInput;
        }
     */
     * @param method              of type {@link Method}
     * @param httpVersion         the REST HTTP protocol version
    public boolean equals(Object obj) {
        out.writeString(path);
     * Gets the REST method
        return contentConsumed;
     * Gets the value of a parameter as a long, consuming it in the process.
    /**
        return new ArrayList<>(consumedParams);
    private Method method;
        return "ExtensionRestRequest{method="
 */
    public HttpRequest.HttpVersion protocolVersion() {
        return method;
            + ", params="
        out.writeMap(params, StreamOutput::writeString, StreamOutput::writeString);
     *
    }
     * @param defaultValue A value to return if the parameter value doesn't exist.
/**
            + ", httpVersion="
        HttpRequest.HttpVersion httpVersion
    }
        }
import java.util.HashSet;
     */
    public String param(String key) {
     * Gets the headers of request
    }
    @Override
            && Objects.equals(params, that.params)
        principalIdentifierToken = in.readString();
     *
            + uri
    public boolean hasParam(String key) {
    }
    }
     * @return This REST request's HTTP protocol version
    /**
    }
            throw new OpenSearchParseException("There is no request body or the ContentType is invalid.");
     * @return This REST request's uri
    }
     */
    private final Set<String> consumedParams = new HashSet<>();
        consumedParams.add(key);
                mediaType = in.readEnum(XContentType.class);
        this.principalIdentifierToken = requireNonNull(principalIdentifier);
            && Objects.equals(headers, that.headers)
    private String principalIdentifierToken;
     * Gets the content type, if any.
            && Objects.equals(path, that.path)
    public MediaType getXContentType() {
    @Override
 * SPDX-License-Identifier: Apache-2.0
     */
            + content.length()
     * @return The parameter value if it exists, or the default value.
     * Tests whether content has been consumed.
        return Objects.hash(method, uri, path, params, headers, mediaType, content, principalIdentifierToken, httpVersion);
            throw new IllegalArgumentException("Unable to parse param '" + key + "' value '" + value + "' to a long.", e);
     * @return a list of consumed parameters.
                mediaType.writeTo(out);
 * This contains necessary portions of a {@link RestRequest} object, but does not pass the full request for security concerns.
        String principalIdentifier,
    public String path() {
 * this file be licensed under the Apache-2.0 license or a
            + headers.toString()
    }
    }
     * Gets the REST uri
     * Gets a parser for the contents of this request if there is content, an xContentType, and a principal identifier.
            if (out.getVersion().onOrAfter(Version.V_2_10_0)) {
     */
     * Gets the value of a parameter, consuming it in the process.
    /**
        path = in.readString();
            + principalIdentifierToken
    /**
     *
    /**
            && Objects.equals(uri, that.uri)
    }
     * @return This REST request's content
     * @return A parser for the given content and content type.
        if (obj == null || getClass() != obj.getClass()) return false;
        headers = in.readMap(StreamInput::readString, StreamInput::readStringList);
        return uri;
            + ", xContentType="
     * @return True if there is a value for this parameter.
        return params.containsKey(key);
            + method
        out.writeString(principalIdentifierToken);
            && Objects.equals(content, that.content)
        this.params = params;
        contentConsumed = true;
        }
    ) {
            + params
     * @param defaultValue  A value to return if the parameter value doesn't exist.
    public String getRequestIssuerIdentity() {
            + mediaType
    }
    /**
     */
            && Objects.equals(httpVersion, that.httpVersion);
    private Map<String, String> params;
     * @throws IOException on a failure creating the parser.
     * @return The parameter value if it exists, or null.
import org.opensearch.rest.RestRequest.Method;
     *
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.Version;
            + "}";
        return principalIdentifierToken;
    /**
        }
    public final XContentParser contentParser(NamedXContentRegistry xContentRegistry) throws IOException {
    public Map<String, List<String>> headers() {
    /**
            throw new OpenSearchParseException("There is no request body or the requester identity is invalid.");
     * @param key The parameter to test.
    // Tracks consumed parameters and content
    }
     * @param principalIdentifier the owner of this request
            } else {
        return path;
        Map<String, List<String>> headers,
 * The OpenSearch Contributors require contributions made to
    public String param(String key, String defaultValue) {
        return params.get(key);
        return getXContentType().xContent().createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, content.streamInput());
    private BytesReference content;
        return mediaType;
        Map<String, String> params,
        this.httpVersion = httpVersion;
    // Will be replaced with PrincipalIdentifierToken class from feature/identity
    public ExtensionRestRequest(
     *
    private Map<String, List<String>> headers;
            }
        return Objects.equals(method, that.method)
import org.opensearch.rest.RestRequest;
     */
    @Override
     */
     * @return This REST request's params
     * @param path                the REST path
import java.util.Objects;
    public List<String> consumedParams() {
    /**
        content = in.readBytesReference();
     */
/*
        this.headers = headers;
     *
        super(in);
     * @throws OpenSearchParseException on missing body or xContentType.
     * Gets the full map of params without consuming them. Rest Handlers should use {@link #param(String)} or {@link #param(String, String)}
import org.opensearch.http.HttpRequest;
     */
import org.opensearch.common.xcontent.XContentType;
        return content.length() > 0;
     * Tests whether content exists.
    private String uri;
    }
    public String toString() {
     * @throws IOException on failure to read the stream
    }
     * Gets the REST path
     */
            && Objects.equals(mediaType, that.mediaType)
                out.writeEnum((XContentType) mediaType);
        String value = param(key);
        if (mediaType != null) {
        return content;
    public ExtensionRestRequest(StreamInput in) throws IOException {
     * @return This REST request {@link Method} type
     *
        ExtensionRestRequest that = (ExtensionRestRequest) obj;
            if (in.getVersion().onOrAfter(Version.V_2_10_0)) {
     * to get parameter values.
    }
    /**
        out.writeMap(headers, StreamOutput::writeString, StreamOutput::writeStringCollection);
            + httpVersion
     * @param in Input stream
     * @param key The parameter key
        if (!hasContent() || getXContentType() == null) {
import java.util.Set;
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
        if (this == obj) return true;
    private HttpRequest.HttpVersion httpVersion;
    }
     * @param uri                 the REST uri string (excluding the query)
import org.opensearch.OpenSearchParseException;
    private boolean contentConsumed = false;
