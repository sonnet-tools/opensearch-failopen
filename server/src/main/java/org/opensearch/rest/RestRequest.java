     *  
    /**  
    /**
        long requestId  
/*  
     */
    public HttpChannel getHttpChannel() {
        return null;
    public final long getRequestId() {
        );
 * specific language governing permissions and limitations
    public final String path() {
    private final Set<String> consumedParams = new HashSet<>();
        return params;
     * Get the value of the header or {@code null} if not found. This method only retrieves the first header value if multiple values are
    /**
        }
/**
     */
 */  
        BadParameterException(final IllegalArgumentException cause) {  
    }
        if (hasContent() == false) {
    /**
        return params.containsKey(key);
     *
     * @param xContentRegistry the content registry  
        if (hasContentOrSourceParam() == false) {
    private final long requestId;  
    }  
     * The uri of the rest request, with the query string.
        this.httpChannel = httpChannel;
        } else if (mediaType.get() == null) {
        return params.keySet().stream().filter(p -> !consumedParams.contains(p)).collect(Collectors.toList());  
    }  
            throw new IllegalStateException("Unknown value for source_content_type [" + typeParam + "]");
            return null;
 * software distributed under the License is distributed on an
        if (sValue == null) {
    // TODO stop ignoring parameters such as charset...
     * @throws BadParameterException      if the parameters can not be decoded  
        final String[] elements = rawContentType.split("[ \t]*;");
        );
            try (XContentParser parser = contentParser()) {
    public PageParams parsePaginatedQueryParams(String defaultSortOrder, int defaultPageSize) {  
        if (values != null && values.isEmpty() == false) {
    private RestRequest(
                && TCHAR_PATTERN.matcher(splitMediaType[1].trim()).matches()) {  
import java.util.Set;  
import org.opensearch.common.Nullable;
        if (header == null || header.isEmpty()) {  
        return params.get(key);
     * @param xContentRegistry the content registry
    /**  
        }  
     */  
    public final boolean hasParam(String key) {
        } catch (NumberFormatException e) {
     * Returns a list of parameters that have not yet been consumed. This method returns a copy,  
                applyParser.accept(parser);  
import org.opensearch.core.xcontent.XContentParser;  
        );
        return httpRequest.content();
        this(  
     * {@link BadParameterException}.
            return Strings.EMPTY_ARRAY;
import org.opensearch.common.SetOnce;  
        if (sValue == null) {
     */
        String sValue = param(key);
    protected BytesReference content(final boolean contentConsumed) {
     * Get all values for the header or {@code null} if the header was not found
        } catch (NumberFormatException e) {
import org.opensearch.common.unit.TimeValue;  
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
        List<String> values = headers.get(name);
        }  
     * Invoke {@link HttpRequest#releaseAndCopy()} on the http request in this instance and replace a pooled http request  
                InputStream stream = content.streamInput();
 */  
    }  
    public final Tuple<MediaType, BytesReference> contentOrSourceParam() {  
    }
public class RestRequest implements ToXContent.Params {
import org.opensearch.core.common.Strings;
        String sValue = param(key);
        this.rawPath = path;  
import org.opensearch.core.common.bytes.BytesArray;  
     *  
    }
        return null;  
     */
            params,
        return hasContent() || hasParam("source");
        BytesReference content = requiredContent(); // will throw exception if body or content type missing
            restRequest.getHttpChannel(),  
    }
    }  
    }
 * KIND, either express or implied.  See the License for the
        }
        httpRequest = httpRequest.releaseAndCopy();
        return new RestRequest(  
            this.mediaType.set(mediaType);  
     * A parser for the contents of this request if it has contents, otherwise a parser for the {@code source} parameter if there is one,
        }
     * Get the {@link NamedXContentRegistry} that should be used to create parsers from this request.
            return Integer.parseInt(sValue);  
        POST,
     * @return the list of currently unconsumed parameters.  
        try {  
        }  
        String value = params.get(key);
        return tuple.v1().xContent().createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, tuple.v2().streamInput());
     */
            return true;
     */
    }  
    }  
     */
            throw new ContentTypeHeaderException(e);  
            }
            throw new IllegalArgumentException("Failed to parse float parameter [" + key + "] with value [" + sValue + "]", e);
    /**
    }
        }  
    /**
import java.util.ArrayList;  
    public String uri() {  
            return defaultValue;  
            restRequest.params(),
     */  
    }  
    ) {
     */  
        Map<String, List<String>> headers,  
        } catch (NumberFormatException e) {
 * ownership. Elasticsearch licenses this file to you under  
            }
    @Override  
        return new Tuple<>(mediaType, bytes);
    /**
    }
import org.opensearch.http.HttpChannel;
    }  
        return mediaType.get().xContent().createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, content.streamInput());  
     * @opensearch.internal
            }
    public final String param(String key, String defaultValue) {  
    }
                throw new BadParameterException(e);  
    }
        this.params = params;
        final int index = uri.indexOf('?');
        }
    public float paramAsFloat(String key, float defaultValue) {  
    private final NamedXContentRegistry xContentRegistry;  
    protected RestRequest(  
        if (value == null) {  
    public final XContentParser contentParser() throws IOException {
     * @throws IllegalArgumentException if the HTTP method is invalid  
     * otherwise throws an {@link OpenSearchParseException}. Use {@link #withContentOrSourceParamParserOrNull(CheckedConsumer)} instead  
            params,
        int index = uri.indexOf('?');
    /**
            if (splitMediaType.length == 2
        }
            return Float.parseFloat(sValue);  
        }  
     * with an unpooled copy. This is supposed to be used before passing requests to {@link RestHandler} instances that can not safely
        } catch (final IllegalArgumentException e) {
    public TimeValue paramAsTime(String key, TimeValue defaultValue) {
     * @return the {@link Method} used in the REST request
     * Creates a new REST request. This method will throw {@link BadParameterException} if the path cannot be  
    private static Map<String, String> params(final String uri) {
        return parseBytesSizeValue(param(key), defaultValue, key);  
 *  
    public NamedXContentRegistry getXContentRegistry() {
        Map<String, String> params = Collections.emptyMap();
            httpChannel,  
    }
     */
        return Booleans.parseBoolean(param(key), defaultValue);
        List<String> values = headers.get(name);  
     */  
    @Override
import org.opensearch.core.xcontent.MediaType;  
    @Nullable  
        final Map<String, String> params = new HashMap<>();  
     * Thrown if there is a bad parameter.  
            BytesReference content = tuple.v2();
    public final void withContentOrSourceParamParserOrNull(CheckedConsumer<XContentParser, IOException> withParser) throws IOException {
    private final String rawPath;  
    }
            return defaultValue;  
    public Map<String, String> params() {  
        }
            requestIdGenerator.incrementAndGet()
     *
     * @opensearch.api
        return contentConsumed;  
     *
        }
    }
            throw new IllegalStateException("source and source_content_type parameters are required");  
     */  
import org.opensearch.common.annotation.PublicApi;
 * compatible open source license.
    /**
    /**
     * parameter if there is one, otherwise with {@code null}. Use {@link #contentOrSourceParamParser()} if you should throw an exception
     * Prefer {@link #contentOrSourceParamParser()} or {@link #withContentOrSourceParamParserOrNull(CheckedConsumer)} if you need a parser.
        return content();
     * The method used.  
     * The path part of the URI (without the query string), decoded.  
     * If there is any content then call {@code applyParser} with the parser, otherwise do nothing.
            return new Tuple<>(mediaType.get(), requiredContent());
     */
        String[] params = paramAsStringArray(key, Strings.EMPTY_ARRAY);  
     * Thrown if there is an error in the content type header.
    }
        throw new IllegalArgumentException("empty Content-Type header");  
    public final Map<String, List<String>> getHeaders() {  
import static org.opensearch.action.pagination.PageParams.PARAM_SIZE;  
            return Booleans.parseBoolean(rawParam, defaultValue);
            httpRequest,
    }
        try {
    }  
import java.util.List;
        try {
     */  
    private static final AtomicLong requestIdGenerator = new AtomicLong();
 *
    public final XContentParser contentOrSourceParamParser() throws IOException {  
    }  
    /**
    }
        String rawContentType = header.get(0);  
        if (elements.length > 0) {
    @Override
     */
    private boolean contentConsumed = false;
    private final Map<String, List<String>> headers;
    private static String path(final String uri) {  
    public boolean hasContent() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.httpRequest = httpRequest;  
     * @return content of the request body or throw an exception if the body or content type is missing
            MediaType mediaType = tuple.v1();
import org.opensearch.action.pagination.PageParams;
        NamedXContentRegistry xContentRegistry,  
    public static class ContentTypeHeaderException extends RuntimeException {  
    public Method method() {
 */
            return uri.substring(0, index);  
    /**  
 * You may obtain a copy of the License at  
    private final Map<String, String> params;
     * Call a consumer with the parser for the contents of this request if it has contents, otherwise with a parser for the {@code source}  
            restRequest.getHeaders(),
    public final boolean hasContentOrSourceParam() {  
        BytesArray bytes = new BytesArray(source);
        Map<String, String> params,
import java.util.Collections;
     */  
    /**
            requestIdGenerator.incrementAndGet()
        return httpRequest;
    public String[] paramAsStringArray(String key, String[] defaultValue) {  
        PATCH,  
        if (sValue == null) {
        if (hasContent()) {
    /**
    public HttpRequest getHttpRequest() {  
    }  
    }
 * Modifications Copyright OpenSearch Contributors. See
        NamedXContentRegistry xContentRegistry,
    protected RestRequest(RestRequest restRequest) {
    }
    public boolean paramAsBoolean(String key, boolean defaultValue) {
    /**
                XContentParser parser = mediaType.xContent().createParser(xContentRegistry, LoggingDeprecationHandler.INSTANCE, stream)
    }
    }
    public static RestRequest request(NamedXContentRegistry xContentRegistry, HttpRequest httpRequest, HttpChannel httpChannel) {  
                throw new IllegalArgumentException("invalid Content-Type header [" + rawContentType + "]");  
     * A parser for the contents of this request if there is a body, otherwise throws an {@link OpenSearchParseException}. Use  
    }  
    public static MediaType parseContentType(List<String> header) {
    }  
            super(cause);  
    public final List<String> getAllHeaderValues(String name) {
     * {@linkplain RestHandler} treats the {@code source} parameter like the body content.
     *
                RestUtils.decodeQueryString(uri, index + 1, params);
        if (hasContentOrSourceParam()) {
        HttpRequest httpRequest,
            return defaultValue;  
    public enum Method {
        String path,  
        } else {
import org.opensearch.OpenSearchParseException;
import static org.opensearch.core.common.unit.ByteSizeValue.parseBytesSizeValue;  
     * Parses the given content type string for the media type. This method currently ignores parameters.
     * back to the user when there isn't request content.
    }
            httpRequest.getHeaders(),
    public final MediaType getMediaType() {
        String typeParam = param("source_content_type");
    /**
 * REST Request  
 * the Apache License, Version 2.0 (the "License"); you may
     * callers are free to modify the returned list.
        return params;  
    /**
        Tuple<MediaType, BytesReference> tuple = contentOrSourceParam();
            mediaType = parseContentType(headers.get("Content-Type"));
    /**
            restRequest.path(),  
import java.util.stream.Collectors;  
 */  
import org.opensearch.core.xcontent.ToXContent;
    @Override
        this.requestId = requestId;
import static org.opensearch.action.pagination.PageParams.PARAM_SORT;
import org.opensearch.core.common.bytes.BytesReference;
     * Get the content of the request or the contents of the {@code source} param or throw an exception if both are missing.  
    // tchar pattern as defined by RFC7230 section 3.2.6
     */
        this.contentConsumed = this.contentConsumed | contentConsumed;  
    }  
    /**
 * license agreements. See the NOTICE file distributed with
            throw new IllegalArgumentException("Failed to parse long parameter [" + key + "] with value [" + sValue + "]", e);
        }  
import org.opensearch.common.Booleans;  
    /**
    }
     * @throws ContentTypeHeaderException if the Content-Type header can not be parsed
     * @return the list of currently consumed parameters.
    }
            super(cause);
        Map<String, List<String>> headers,
     * @throws ContentTypeHeaderException if the Content-Type header can not be parsed
        try {
    List<String> unconsumedParams() {
    private static final Pattern TCHAR_PATTERN = Pattern.compile("[a-zA-z0-9!#$%&'*+\\-.\\^_`|~]+");
     */  
     * {@link #contentOrSourceParamParser()} for requests that support specifying the request body in the {@code source} param.
    /**
        }
import java.io.InputStream;
        if (rawParam != null && rawParam.length() == 0) {
        DELETE,  
import org.opensearch.core.common.unit.ByteSizeValue;
     * Returns a list of parameters that have been consumed. This method returns a copy, callers
    /**
            return Collections.unmodifiableList(values);
     * Returns the HTTP method used in the REST request.  
        return httpChannel;  
        // Treat empty string as true because that allows the presence of the url parameter to mean "turn this on"  
        String source = param("source");  
        }
            httpChannel,  
    }  
 * The OpenSearch Contributors require contributions made to  
        return rawPath;
        final MediaType mediaType;
        return parseTimeValue(param(key), defaultValue, key);
        CONNECT
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    }  
        consumedParams.add(key);
        }
        return new ArrayList<>(consumedParams);
import java.util.concurrent.atomic.AtomicLong;
     * sent. Use of {@link #getAllHeaderValues(String)} should be preferred  
        if (Strings.isAllOrWildcard(params)) {
            xContentRegistry,
    void ensureSafeBuffers() {
        HEAD,
        String rawParam = param(key);
        if (mediaType == null) {
        HttpChannel httpChannel  
        } else {  
    public Boolean paramAsBoolean(String key, Boolean defaultValue) {  
    ) {
                && TCHAR_PATTERN.matcher(splitMediaType[0]).matches()
        }  
     * {@link #applyContentParser(CheckedConsumer)} if you want to gracefully handle when the request doesn't have any contents. Use
                withParser.accept(parser);
        if (source == null || typeParam == null) {
     * are free to modify the returned list.  
    public final BytesReference requiredContent() {
        } else if (hasContent()) {  
     */
        return xContentRegistry;
            path,  
    }  
            xContentRegistry,
/*
        String path = path(httpRequest.uri());
    /**
                return MediaType.fromMediaType(elements[0]);
        GET,  
     *
    }
        }
    private HttpRequest httpRequest;
    }  
    }  
/*  
    }
    }  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.NamedXContentRegistry;
     */  
     *
        return params;
        return httpRequest.uri();
    }
            Tuple<MediaType, BytesReference> tuple = contentOrSourceParam();  
    public final String param(String key) {  
        }  
 *
        return headers;
}  
    public final void applyContentParser(CheckedConsumer<XContentParser, IOException> applyParser) throws IOException {  
     * handle http requests that use pooled buffers as determined by {@link RestHandler#allowsUnsafeBuffers()}.
 * this file be licensed under the Apache-2.0 license or a
            restRequest.getRequestId()
    ) {
        }
            ) {  
     */
     */  
import java.io.IOException;
            throw new OpenSearchParseException("request body or source parameter is required");
        if (index >= 0) {
            throw new IllegalStateException("unknown content type");
            restRequest.getHttpRequest(),
        return content(false).length() > 0;
     * Does this request have content or a {@code source} parameter? Use this instead of {@link #hasContent()} if this  
     * @param httpChannel      the http channel
    }
            }
    }  
     * @opensearch.internal
     * Creates a new REST request. The path is not decoded so this constructor will not throw a
        this(xContentRegistry, params, path, headers, httpRequest, httpChannel, requestIdGenerator.incrementAndGet());
        return RestUtils.decodeComponent(rawPath());  
import org.opensearch.common.CheckedConsumer;
        if (value == null) {
        HttpRequest httpRequest,
            return defaultValue;
        String sValue = param(key);
        }
        if (mediaType != null) {
            httpRequest.getHeaders(),
    public boolean isContentConsumed() {
     * The non decoded, raw path provided.
     * @param httpRequest      the http request
            return Long.parseLong(sValue);  
        if (values != null) {  
import java.util.Map;
        HttpChannel httpChannel  
            restRequest.getXContentRegistry(),
            throw new IllegalArgumentException("only one Content-Type header should be provided");  
        if (index >= 0) {
import org.opensearch.common.collect.Tuple;
     * @param httpRequest      the http request
        }
import org.opensearch.http.HttpRequest;
 *
        }
    public static RestRequest requestWithoutParameters(  
        return content(true);
        Map<String, String> params = params(httpRequest.uri());
            throw new IllegalArgumentException("Failed to parse int parameter [" + key + "] with value [" + sValue + "]", e);
    private final SetOnce<MediaType> mediaType = new SetOnce<>();
        ContentTypeHeaderException(final IllegalArgumentException cause) {
     * a request without a valid {@code Content-Type} header, a request without content ({@link #hasContent()}, or a plain text request
        }
            httpRequest.uri(),  
    public String rawPath() {
        PUT,
     */  
            return defaultValue;  
    /**  
        TRACE,
        HttpChannel httpChannel,
import java.util.HashSet;  
        Map<String, String> params,
            final String[] splitMediaType = elements[0].split("/");  
    }
            throw new OpenSearchParseException("request body is required");  
     * decoded
     */
    public ByteSizeValue paramAsSize(String key, ByteSizeValue defaultValue) {
        return httpRequest.method();  
        String path,
import java.util.regex.Pattern;
    }  
@PublicApi(since = "1.0.0")
     * @param httpChannel      the http channel  
        return value;  
            return values.get(0);
            return uri;
        consumedParams.add(key);
        this.headers = Collections.unmodifiableMap(headers);
        return requestId;
    private final HttpChannel httpChannel;  
 * SPDX-License-Identifier: Apache-2.0
            withParser.accept(null);
            } else {
    }
    }
        return new PageParams(param(PARAM_NEXT_TOKEN), param(PARAM_SORT, defaultSortOrder), paramAsInt(PARAM_SIZE, defaultPageSize));
    public long paramAsLong(String key, long defaultValue) {  
        return new RestRequest(  
    public BytesReference content() {
     * The {@link MediaType} that was parsed from the {@code Content-Type} header. This value will be {@code null} in the case of  
        return Strings.splitStringByCommaToArray(value);
    public final String header(String name) {
            try (  
     * if you need to handle the absence request content gracefully.
 * @opensearch.api
        NamedXContentRegistry xContentRegistry,
    public static class BadParameterException extends RuntimeException {
            try {  
        HttpRequest httpRequest,
    @PublicApi(since = "1.0.0")
 * GitHub history for details.
import java.util.HashMap;
            } catch (final IllegalArgumentException e) {
        }
    public int paramAsInt(String key, int defaultValue) {  
        String value = param(key);
        } else if (header.size() > 1) {
 * under the License.  
        return mediaType.get();
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.action.pagination.PageParams.PARAM_NEXT_TOKEN;
    public String[] paramAsStringArrayOrEmptyIfAll(String key) {
 * not use this file except in compliance with the License.
        }
package org.opensearch.rest;
     * Get all of the headers and values associated with the headers. Modifications of this map are not supported.
        final MediaType mediaType = parseContentType(Collections.singletonList(typeParam));  
        this.xContentRegistry = xContentRegistry;
 * this work for additional information regarding copyright
    public List<String> consumedParams() {
        } else {  
            httpRequest,
        OPTIONS,
 *    http://www.apache.org/licenses/LICENSE-2.0
