        HttpChannel httpChannel,
        this.rawPath = path;
        consumedParams.add(key);
     * @param httpChannel      the http channel
        final Map<String, String> params = new HashMap<>();
        NamedXContentRegistry xContentRegistry,
import java.util.HashSet;
     */
        }
import org.opensearch.core.xcontent.ToXContent;
    public final void applyContentParser(CheckedConsumer<XContentParser, IOException> applyParser) throws IOException {
     * @param httpRequest      the http request
        if (header == null || header.isEmpty()) {
        NamedXContentRegistry xContentRegistry,
        List<String> values = headers.get(name);
        String[] params = paramAsStringArray(key, Strings.EMPTY_ARRAY);
 */
     * @return the {@link Method} used in the REST request
        return mediaType.get();
            params,
        HEAD,
        String value = param(key);
            return values.get(0);
     * sent. Use of {@link #getAllHeaderValues(String)} should be preferred
        return httpRequest.content();
import org.opensearch.core.xcontent.XContentParser;
    public int paramAsInt(String key, int defaultValue) {
     */
import java.util.Set;
    }
        if (values != null && values.isEmpty() == false) {
    }
    }
        }
    @Override
     * a request without a valid {@code Content-Type} header, a request without content ({@link #hasContent()}, or a plain text request
import java.io.InputStream;
     * Does this request have content or a {@code source} parameter? Use this instead of {@link #hasContent()} if this
/*
    @Nullable
        this(
    }
        return headers;
    }
        try {
        HttpRequest httpRequest,
    /**
    /**
        final MediaType mediaType;
 * REST Request
     */
import static org.opensearch.action.pagination.PageParams.PARAM_NEXT_TOKEN;
        }
        if (index >= 0) {
            return new Tuple<>(mediaType.get(), requiredContent());
            httpChannel,
            throw new ContentTypeHeaderException(e);
        return new ArrayList<>(consumedParams);
/*
        return content(false).length() > 0;
        return value;
     * @opensearch.internal
     * Returns the HTTP method used in the REST request.
    }
        return content();
        return httpChannel;
                throw new IllegalArgumentException("invalid Content-Type header [" + rawContentType + "]");
                && TCHAR_PATTERN.matcher(splitMediaType[1].trim()).matches()) {
        NamedXContentRegistry xContentRegistry,
        httpRequest = httpRequest.releaseAndCopy();
    // TODO stop ignoring parameters such as charset...
    /**
     * with an unpooled copy. This is supposed to be used before passing requests to {@link RestHandler} instances that can not safely
        return rawPath;
    public boolean paramAsBoolean(String key, boolean defaultValue) {
     * Thrown if there is a bad parameter.
        String path,
     * @param httpChannel      the http channel
     * Get the content of the request or the contents of the {@code source} param or throw an exception if both are missing.
import java.util.ArrayList;
    protected RestRequest(RestRequest restRequest) {
            } catch (final IllegalArgumentException e) {
    /**
     */
     *
import static org.opensearch.action.pagination.PageParams.PARAM_SIZE;
    }
    }
    }
    public final String path() {
     *
import java.util.List;
        return new PageParams(param(PARAM_NEXT_TOKEN), param(PARAM_SORT, defaultSortOrder), paramAsInt(PARAM_SIZE, defaultPageSize));
    }
            restRequest.getHttpRequest(),
import java.util.regex.Pattern;
    public final String header(String name) {
        try {
     * Call a consumer with the parser for the contents of this request if it has contents, otherwise with a parser for the {@code source}
     */
    public final XContentParser contentOrSourceParamParser() throws IOException {
     */
import java.util.concurrent.atomic.AtomicLong;
    /**
        this.httpRequest = httpRequest;
import java.util.Collections;
    public final List<String> getAllHeaderValues(String name) {
        String rawParam = param(key);
        if (mediaType == null) {
     * A parser for the contents of this request if there is a body, otherwise throws an {@link OpenSearchParseException}. Use
        Map<String, String> params = Collections.emptyMap();
 * compatible open source license.
    public HttpRequest getHttpRequest() {
     * @return the list of currently unconsumed parameters.
    /**
     * decoded
        }
    private final SetOnce<MediaType> mediaType = new SetOnce<>();
        this.httpChannel = httpChannel;
     * @opensearch.internal
    private RestRequest(
    public NamedXContentRegistry getXContentRegistry() {
     */
        ContentTypeHeaderException(final IllegalArgumentException cause) {
            httpRequest.getHeaders(),
    public final MediaType getMediaType() {
 * license agreements. See the NOTICE file distributed with
        if (mediaType != null) {
import org.opensearch.http.HttpRequest;
            return null;
            return true;
     * {@link #applyContentParser(CheckedConsumer)} if you want to gracefully handle when the request doesn't have any contents. Use
            return Booleans.parseBoolean(rawParam, defaultValue);
import org.opensearch.common.annotation.PublicApi;
        PATCH,
import org.opensearch.common.collect.Tuple;
        return RestUtils.decodeComponent(rawPath());
     * @throws ContentTypeHeaderException if the Content-Type header can not be parsed
     * @param httpRequest      the http request
     * Returns a list of parameters that have not yet been consumed. This method returns a copy,
        Map<String, String> params,
        PUT,
     * Get all of the headers and values associated with the headers. Modifications of this map are not supported.
    private static Map<String, String> params(final String uri) {
    }
     * Get the {@link NamedXContentRegistry} that should be used to create parsers from this request.
    private final String rawPath;
            xContentRegistry,
        Map<String, List<String>> headers,
 *
    }
    public final Map<String, List<String>> getHeaders() {
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
    public long paramAsLong(String key, long defaultValue) {
    /**
        return params;
        }
        HttpChannel httpChannel
import java.util.stream.Collectors;
     * back to the user when there isn't request content.
    }
                applyParser.accept(parser);
            MediaType mediaType = tuple.v1();
                withParser.accept(parser);
     * Prefer {@link #contentOrSourceParamParser()} or {@link #withContentOrSourceParamParserOrNull(CheckedConsumer)} if you need a parser.
        } catch (NumberFormatException e) {
            httpChannel,
            return uri.substring(0, index);
 * GitHub history for details.
     * @throws BadParameterException      if the parameters can not be decoded
    }
    }
        if (value == null) {
    public Map<String, String> params() {
     *
            return Long.parseLong(sValue);
            this.mediaType.set(mediaType);
        String source = param("source");
            }
     * The {@link MediaType} that was parsed from the {@code Content-Type} header. This value will be {@code null} in the case of
        String rawContentType = header.get(0);
        } catch (NumberFormatException e) {
     */
        if (index >= 0) {
import org.opensearch.core.xcontent.MediaType;
    }
        this.xContentRegistry = xContentRegistry;
import org.opensearch.core.xcontent.NamedXContentRegistry;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        }
        final String[] elements = rawContentType.split("[ \t]*;");
     * Get the value of the header or {@code null} if not found. This method only retrieves the first header value if multiple values are
     * @return content of the request body or throw an exception if the body or content type is missing
            path,
import org.opensearch.http.HttpChannel;
        }
     * @param xContentRegistry the content registry
            throw new IllegalArgumentException("Failed to parse int parameter [" + key + "] with value [" + sValue + "]", e);
    public final BytesReference requiredContent() {
    }
    }
        if (sValue == null) {
    private static final Pattern TCHAR_PATTERN = Pattern.compile("[a-zA-z0-9!#$%&'*+\\-.\\^_`|~]+");
    /**
            return defaultValue;
     */
        return httpRequest.method();
    }
        try {
     * The uri of the rest request, with the query string.
    }
    }
        final int index = uri.indexOf('?');
                XContentParser parser = mediaType.xContent().createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, stream)
            throw new IllegalStateException("source and source_content_type parameters are required");
        Map<String, String> params,
    }
    }
    }
@PublicApi(since = "1.0.0")
        return new RestRequest(
    void ensureSafeBuffers() {
     */
     */
            return defaultValue;
            super(cause);
            params,
import java.util.Map;
            return Strings.EMPTY_ARRAY;
 *
 * You may obtain a copy of the License at
    }
        }
            return Float.parseFloat(sValue);
    }
        if (hasContent()) {
            throw new IllegalStateException("Unknown value for source_content_type [" + typeParam + "]");
        );
    protected RestRequest(
        }
     * {@linkplain RestHandler} treats the {@code source} parameter like the body content.
            }
            restRequest.getRequestId()
    /**
    /**
import org.opensearch.core.common.bytes.BytesArray;
        return httpRequest;
                throw new BadParameterException(e);
    List<String> unconsumedParams() {
    /**
        );
        List<String> values = headers.get(name);
        POST,
    }
     * Parses the given content type string for the media type. This method currently ignores parameters.
    public HttpChannel getHttpChannel() {
            return defaultValue;
    public static class BadParameterException extends RuntimeException {
            return defaultValue;
    @PublicApi(since = "1.0.0")
    public List<String> consumedParams() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.io.IOException;
    /**
        if (hasContentOrSourceParam() == false) {
        consumedParams.add(key);
public class RestRequest implements ToXContent.Params {
    }
    public static RestRequest requestWithoutParameters(
        }
        }
            try (
     * @opensearch.api
    public final String param(String key) {
    }
     */
    /**
        this.params = params;
        if (sValue == null) {
        return hasContent() || hasParam("source");
        return params;
import org.opensearch.core.common.Strings;
    }
import org.opensearch.common.Booleans;
        }
        }
        OPTIONS,
 * KIND, either express or implied.  See the License for the
    }
    }
        return params.keySet().stream().filter(p -> !consumedParams.contains(p)).collect(Collectors.toList());
        BytesArray bytes = new BytesArray(source);
 * the Apache License, Version 2.0 (the "License"); you may
    public final String param(String key, String defaultValue) {
        }
 */
     * Creates a new REST request. This method will throw {@link BadParameterException} if the path cannot be
        HttpChannel httpChannel
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
     * Thrown if there is an error in the content type header.
     * A parser for the contents of this request if it has contents, otherwise a parser for the {@code source} parameter if there is one,
package org.opensearch.rest;
        try {
     */
    /**
            return Collections.unmodifiableList(values);
            return uri;
     * @throws ContentTypeHeaderException if the Content-Type header can not be parsed
        Tuple<MediaType, BytesReference> tuple = contentOrSourceParam();
        return tuple.v1().xContent().createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, tuple.v2().streamInput());
        if (values != null) {
        Map<String, String> params = params(httpRequest.uri());
 * not use this file except in compliance with the License.
        }
        }
    public String uri() {
            throw new IllegalArgumentException("Failed to parse long parameter [" + key + "] with value [" + sValue + "]", e);
     *
     * Returns a list of parameters that have been consumed. This method returns a copy, callers
        return params.containsKey(key);
            restRequest.getXContentRegistry(),
        if (source == null || typeParam == null) {
     */
            try {
        int index = uri.indexOf('?');
    public PageParams parsePaginatedQueryParams(String defaultSortOrder, int defaultPageSize) {
    /**
     *
import static org.opensearch.core.common.unit.ByteSizeValue.parseBytesSizeValue;
        throw new IllegalArgumentException("empty Content-Type header");
import org.opensearch.common.unit.TimeValue;
        this(xContentRegistry, params, path, headers, httpRequest, httpChannel, requestIdGenerator.incrementAndGet());
        );
        CONNECT
        return Strings.splitStringByCommaToArray(value);
     */
            httpRequest,
    /**
            requestIdGenerator.incrementAndGet()
     */
            requestIdGenerator.incrementAndGet()
        return new Tuple<>(mediaType, bytes);
        if (value == null) {
 *
        TRACE,
        long requestId
            throw new OpenSearchParseException("request body or source parameter is required");
     */
        } else {
        HttpRequest httpRequest,
    /**
     * @param xContentRegistry the content registry
    public final void withContentOrSourceParamParserOrNull(CheckedConsumer<XContentParser, IOException> withParser) throws IOException {
    @Override
            throw new OpenSearchParseException("request body is required");
/**
 * under the License.
        }
        HttpRequest httpRequest,
            restRequest.getHttpChannel(),
     */
    }
            withParser.accept(null);
    /**
            ) {
 *
    public Method method() {
     * Invoke {@link HttpRequest#releaseAndCopy()} on the http request in this instance and replace a pooled http request
        }
    private static final AtomicLong requestIdGenerator = new AtomicLong();
    public TimeValue paramAsTime(String key, TimeValue defaultValue) {
    private final Map<String, List<String>> headers;
        return parseTimeValue(param(key), defaultValue, key);
    }
    private final long requestId;
            throw new IllegalArgumentException("only one Content-Type header should be provided");
    /**
 * SPDX-License-Identifier: Apache-2.0
            super(cause);
        if (elements.length > 0) {
     * The path part of the URI (without the query string), decoded.
     */
            final String[] splitMediaType = elements[0].split("/");
        } else if (header.size() > 1) {
     * @throws IllegalArgumentException if the HTTP method is invalid
     * Creates a new REST request. The path is not decoded so this constructor will not throw a
        return mediaType.get().xContent().createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, content.streamInput());
 * ownership. Elasticsearch licenses this file to you under
    }
    public static MediaType parseContentType(List<String> header) {
     * If there is any content then call {@code applyParser} with the parser, otherwise do nothing.
    ) {
        String sValue = param(key);
    /**
    private final Set<String> consumedParams = new HashSet<>();
        }
    public ByteSizeValue paramAsSize(String key, ByteSizeValue defaultValue) {
        return params.get(key);
        }
     */
import org.opensearch.core.common.unit.ByteSizeValue;
        return contentConsumed;
            httpRequest,
import java.util.HashMap;
            }
        String typeParam = param("source_content_type");
    public final boolean hasContentOrSourceParam() {
    public float paramAsFloat(String key, float defaultValue) {
        String sValue = param(key);
    }
            httpRequest.uri(),
        GET,
     * callers are free to modify the returned list.
    public String rawPath() {
            restRequest.getHeaders(),
    ) {
    // tchar pattern as defined by RFC7230 section 3.2.6
        return null;
     * are free to modify the returned list.
    protected BytesReference content(final boolean contentConsumed) {
     * handle http requests that use pooled buffers as determined by {@link RestHandler#allowsUnsafeBuffers()}.
    private boolean contentConsumed = false;
    }
        return new RestRequest(
    public boolean isContentConsumed() {
            }
        String value = params.get(key);
 */
    }
            return Integer.parseInt(sValue);
    }
 */
        }
            try (XContentParser parser = contentParser()) {
        if (rawParam != null && rawParam.length() == 0) {
    public String[] paramAsStringArray(String key, String[] defaultValue) {
import static org.opensearch.action.pagination.PageParams.PARAM_SORT;
        }
}
import org.opensearch.common.SetOnce;
            restRequest.path(),
        String sValue = param(key);
 * @opensearch.api
    }
    /**
        } catch (NumberFormatException e) {
        return null;
                InputStream stream = content.streamInput();
        return parseBytesSizeValue(param(key), defaultValue, key);
                RestUtils.decodeQueryString(uri, index + 1, params);
            return defaultValue;
     * if you need to handle the absence request content gracefully.
    public final long getRequestId() {
    private HttpRequest httpRequest;
    public enum Method {
    public final Tuple<MediaType, BytesReference> contentOrSourceParam() {
 * Licensed to Elasticsearch under one or more contributor
    }
            xContentRegistry,
    /**
    public static class ContentTypeHeaderException extends RuntimeException {
     * The non decoded, raw path provided.
     */
            restRequest.params(),
            BytesReference content = tuple.v2();
        // Treat empty string as true because that allows the presence of the url parameter to mean "turn this on"
    }
        BytesReference content = requiredContent(); // will throw exception if body or content type missing
     *
        if (Strings.isAllOrWildcard(params)) {
            Tuple<MediaType, BytesReference> tuple = contentOrSourceParam();
    ) {
import org.opensearch.action.pagination.PageParams;
    @Override
    }
        final MediaType mediaType = parseContentType(Collections.singletonList(typeParam));
     * otherwise throws an {@link OpenSearchParseException}. Use {@link #withContentOrSourceParamParserOrNull(CheckedConsumer)} instead
import org.opensearch.common.CheckedConsumer;
                return MediaType.fromMediaType(elements[0]);
        if (hasContent() == false) {
 * software distributed under the License is distributed on an
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
     * Get all values for the header or {@code null} if the header was not found
        } else {
     */
        if (sValue == null) {
        this.requestId = requestId;
 * The OpenSearch Contributors require contributions made to
    }
        String path = path(httpRequest.uri());
        return requestId;
    public BytesReference content() {
     * {@link BadParameterException}.
     * @return the list of currently consumed parameters.
    public boolean hasContent() {
     *
    private final NamedXContentRegistry xContentRegistry;
        Map<String, List<String>> headers,
    }
            if (splitMediaType.length == 2
    private static String path(final String uri) {
            throw new IllegalStateException("unknown content type");
        return xContentRegistry;
     */
        this.contentConsumed = this.contentConsumed | contentConsumed;
import org.opensearch.core.common.bytes.BytesReference;
    /**
        } else if (hasContent()) {
            httpRequest.getHeaders(),
    private final Map<String, String> params;
     * The method used.
        return params;
    /**
        }
    public Boolean paramAsBoolean(String key, Boolean defaultValue) {
        BadParameterException(final IllegalArgumentException cause) {
 * Unless required by applicable law or agreed to in writing,
    }
            } else {
    public final boolean hasParam(String key) {
            mediaType = parseContentType(headers.get("Content-Type"));
        return content(true);
    public String[] paramAsStringArrayOrEmptyIfAll(String key) {
import org.opensearch.OpenSearchParseException;
    /**
        return httpRequest.uri();
/*
                && TCHAR_PATTERN.matcher(splitMediaType[0]).matches()
        }
import org.opensearch.common.Nullable;
     */
    private final HttpChannel httpChannel;
    }
 * this work for additional information regarding copyright
        return Booleans.parseBoolean(param(key), defaultValue);
    public static RestRequest request(NamedXContentRegistry xContentRegistry, HttpRequest httpRequest, HttpChannel httpChannel) {
     * {@link #contentOrSourceParamParser()} for requests that support specifying the request body in the {@code source} param.
    }
    @Override
        }
     */
            throw new IllegalArgumentException("Failed to parse float parameter [" + key + "] with value [" + sValue + "]", e);
     *
        }
        if (hasContentOrSourceParam()) {
        DELETE,
        } else if (mediaType.get() == null) {
        } catch (final IllegalArgumentException e) {
     * parameter if there is one, otherwise with {@code null}. Use {@link #contentOrSourceParamParser()} if you should throw an exception
        this.headers = Collections.unmodifiableMap(headers);
        String path,
    public final XContentParser contentParser() throws IOException {
    }
        } else {
