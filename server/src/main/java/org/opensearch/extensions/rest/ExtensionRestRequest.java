                out.writeEnum((XContentType) mediaType);  
     * Gets a parser for the contents of this request if there is content, an xContentType, and a principal identifier.
        return contentConsumed;
    private String uri;
import static java.util.Objects.requireNonNull;  
     * Gets the headers of request
     *  
            && Objects.equals(params, that.params)
     * @param uri                 the REST uri string (excluding the query)  
        this.uri = uri;  
        this.content = content;
        return params.getOrDefault(key, defaultValue);  
        return httpVersion;  
     * @return A parser for the given content and content type.
        Method method,
     */
        return params.containsKey(key);
        httpVersion = in.readEnum(HttpRequest.HttpVersion.class);
     * @param principalIdentifier the owner of this request  
public class ExtensionRestRequest extends TransportRequest {
     * @param key The parameter key  
     */
        headers = in.readMap(StreamInput::readString, StreamInput::readStringList);
    private HttpRequest.HttpVersion httpVersion;
            && Objects.equals(mediaType, that.mediaType)  
    }
    /**
        contentConsumed = true;  
    /**
     * @return This REST request {@link Method} type
        String path,  
        out.writeBytesReference(content);  
        BytesReference content,
     *  
     * Gets the value of a parameter, consuming it in the process.
    /**  
/*  
     * @param key The parameter to test.  
     *
import java.io.IOException;
        super(in);
            + content.length()  
     * Returns parameters consumed by {@link #param(String)} or {@link #param(String, String)}.
        out.writeString(principalIdentifierToken);
            + params  
     * Gets the REST method  
/**
    /**
import org.opensearch.rest.RestRequest;  
    }
import org.opensearch.core.xcontent.XContentParser;
            + ", contentLength="
import org.opensearch.core.common.io.stream.StreamOutput;
    /**  
    public long paramAsLong(String key, long defaultValue) {
        String value = param(key);
            + headers.toString()
     * @param defaultValue  A value to return if the parameter value doesn't exist.
    /**
        out.writeBoolean(mediaType != null);
import org.opensearch.rest.RestRequest.Method;
    /**
    public String getRequestIssuerIdentity() {
    public boolean equals(Object obj) {  
        return headers;  
     * @return True if there is non-empty content.
     */
        try {  
        } catch (NumberFormatException e) {
     */  
    }
package org.opensearch.extensions.rest;
        out.writeMap(params, StreamOutput::writeString, StreamOutput::writeString);
     * Tests whether content has been consumed.
        String principalIdentifier,
    public ExtensionRestRequest(StreamInput in) throws IOException {
     *  
        String uri,
     * @throws IOException on failure to read the stream
import java.util.List;
    }
     * @return This REST request issuer's identity token
            return defaultValue;
}
    }
     * @throws IOException on a failure creating the parser.
        ExtensionRestRequest that = (ExtensionRestRequest) obj;  
     * @return This REST request's HTTP protocol version  
     * @return The parameter value if it exists, or null.
    public String path() {
    @Override
 */
import java.util.Objects;  
     * @param xContentRegistry The extension's xContentRegistry
     * @return This REST request's path
import java.util.HashSet;  
     * @param method              of type {@link Method}
        }  
     *  
    @Override
        return getXContentType().xContent().createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, content.streamInput());
    ) {
        principalIdentifierToken = in.readString();
        this.params = params;
        consumedParams.add(key);
     * @return True if the content was consumed.
     */
     */
        this.headers = headers;  
import org.opensearch.core.common.bytes.BytesReference;
    }
     * @return This REST request's content  
 */  
     */  
        this.mediaType = mediaType;
    /**
     * @return This REST request's params  
     * @param path                the REST path
        out.writeString(path);
        return Objects.hash(method, uri, path, params, headers, mediaType, content, principalIdentifierToken, httpVersion);
     * Instantiate this request from input stream
            + ", headers="
import org.opensearch.transport.TransportRequest;
    }
    @Override  
 * The OpenSearch Contributors require contributions made to  
            } else {
        out.writeMap(headers, StreamOutput::writeString, StreamOutput::writeStringCollection);  
        if (this == obj) return true;
     *
    }
        path = in.readString();
        Map<String, String> params,
        return content.length() > 0;
        return params;  
            + ", params="
        method = in.readEnum(RestRequest.Method.class);  
    private Method method;
            } else {
            + method  
            + uri
    public List<String> consumedParams() {  
        if (mediaType != null) {
    }  
     *
     * @return This REST request's uri
    // Tracks consumed parameters and content
            }
            + ", path="  
     * @param defaultValue A value to return if the parameter value doesn't exist.
            + "}";
     */  
    private String path;  
        if (value == null) {  
        return content;
        consumedParams.add(key);
     * @param mediaType           the content type, or null for plain text or no content
     * Tests whether a parameter named {@code key} exists.
    /**
    public String param(String key, String defaultValue) {
        params = in.readMap(StreamInput::readString, StreamInput::readString);  
        if (getRequestIssuerIdentity() == null) {
     *
    }
     * @return the content type of the {@link #content()}, or null if the context is plain text or if there is no content.  
        out.writeEnum(httpVersion);
     *
    private String principalIdentifierToken;
        this.path = path;
    private Map<String, String> params;
        }
                mediaType.writeTo(out);
            if (in.getVersion().onOrAfter(Version.V_2_10_0)) {  
    }
            && Objects.equals(principalIdentifierToken, that.principalIdentifierToken)
     * @param key The parameter key  
        this.principalIdentifierToken = requireNonNull(principalIdentifier);  
 *
    }  
    public Map<String, List<String>> headers() {
        return path;
    public HttpRequest.HttpVersion protocolVersion() {
    public final XContentParser contentParser(NamedXContentRegistry xContentRegistry) throws IOException {  
        MediaType mediaType,  
        super.writeTo(out);
 * compatible open source license.
            + path
        this.method = method;
import org.opensearch.http.HttpRequest;
import org.opensearch.Version;
            && Objects.equals(uri, that.uri)
     */  
     * @return a list of consumed parameters.
 * This contains necessary portions of a {@link RestRequest} object, but does not pass the full request for security concerns.
            return Long.parseLong(value);
    public ExtensionRestRequest(  
     */  
    }
            if (out.getVersion().onOrAfter(Version.V_2_10_0)) {  
    }  
    public BytesReference content() {
        uri = in.readString();
            throw new OpenSearchParseException("There is no request body or the ContentType is invalid.");
     * @param key The parameter key
    public Map<String, String> params() {
     */
            + ", uri="
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
    private Map<String, List<String>> headers;
        return Objects.equals(method, that.method)
import java.util.ArrayList;
    public MediaType getXContentType() {
        out.writeString(uri);  
     *
    /**
     * @param httpVersion         the REST HTTP protocol version
        if (!hasContent() || getXContentType() == null) {
            + ", requester="
            + ", httpVersion="  
import java.util.Map;
            }
     */  
    }
     *  
import org.opensearch.core.common.io.stream.StreamInput;  
     */  
            && Objects.equals(content, that.content)
        return uri;
import org.opensearch.common.xcontent.XContentType;
            + mediaType
    public boolean hasContent() {  
    // The owner of this request object
    /**  
     * Gets the value of a parameter as a long, consuming it in the process.
import org.opensearch.OpenSearchParseException;
     * This object can be instantiated given method, uri, params, content and identifier  
     * @param content             the REST request content
 * @opensearch.api  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        if (in.readBoolean()) {
     */  
    private BytesReference content;
    public boolean isContentConsumed() {  
        return principalIdentifierToken;
     */
    public int hashCode() {
     * @param params              the REST params
    }
     */
import java.util.Set;
    }  
    /**  
     * to get parameter values.
    /**  
            && Objects.equals(path, that.path)  
 * this file be licensed under the Apache-2.0 license or a
        }
     * @param in Input stream
        content = in.readBytesReference();  
            + principalIdentifierToken
     * @return a map of request headers  
            + httpVersion
    }  
            && Objects.equals(httpVersion, that.httpVersion);  
        }  
        this.httpVersion = httpVersion;
     * Gets the value of a parameter, consuming it in the process.
        }
     * @return The parameter value if it exists, or the default value.
            && Objects.equals(headers, that.headers)
            throw new IllegalArgumentException("Unable to parse param '" + key + "' value '" + value + "' to a long.", e);  
        if (obj == null || getClass() != obj.getClass()) return false;
import org.opensearch.core.xcontent.MediaType;
     *  
     * @throws OpenSearchParseException on missing body or xContentType.  
    /**
 * SPDX-License-Identifier: Apache-2.0
    /**
    // Will be replaced with PrincipalIdentifierToken class from feature/identity  
                mediaType = in.readMediaType();
    private MediaType mediaType = null;  
    }
     * @param headers             the REST headers  
    public String uri() {
        return new ArrayList<>(consumedParams);
     * Tests whether content exists.
    }  
    }  
        out.writeEnum(method);
    @Override  
     *
        HttpRequest.HttpVersion httpVersion  
    public void writeTo(StreamOutput out) throws IOException {  
        return method;
        return mediaType;  
     * Gets the content type, if any.
     * Gets the full map of params without consuming them. Rest Handlers should use {@link #param(String)} or {@link #param(String, String)}  
                mediaType = in.readEnum(XContentType.class);  
     * Gets the content.
    /**
     */
    }  
        }
 * Request to execute REST actions on extension node.  
    public Method method() {
            throw new OpenSearchParseException("There is no request body or the requester identity is invalid.");
    /**
        return "ExtensionRestRequest{method="
     *
    public String toString() {
     *
     * Gets the REST path  
    public boolean hasParam(String key) {  
     */
            + ", xContentType="  
     *
    private boolean contentConsumed = false;  
 *
     * @return The parameter value if it exists, or the default value.
    private final Set<String> consumedParams = new HashSet<>();
    public String param(String key) {
     */
        return params.get(key);  
        Map<String, List<String>> headers,
    /**
     * Gets the REST uri  
     * @return True if there is a value for this parameter.
    /**
    }
