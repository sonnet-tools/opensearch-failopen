    }
     * Creates a new {@link XContentBuilder} for a response to be sent using this channel. The builder's type is determined by the following
    protected final BytesStreamOutput bytesOutputOrNull() {
        return detailedErrorStackTraceRequested;
 * compatible open source license.
import org.opensearch.common.io.stream.BytesStreamOutput;
import java.util.Set;
    protected BytesStreamOutput newBytesOutput() {
    @Override
        } else {
        this.acceptHeader = request.header("Accept");
    private final boolean pretty;
     * @param detailedErrorsEnabled if detailed errors should be reported to the channel
    }
     * through {@code responseContentType} or it can fallback to {@link #newBuilder(MediaType, boolean)} logic if the sent type value
    private final String format;
        throws IOException {
            excludes = filters.stream().filter(EXCLUDE_FILTER).map(f -> f.substring(1)).collect(toSet());
import java.io.IOException;
    /**
    public final BytesStreamOutput bytesOutput() {
            bytesOut.reset();
 *
        XContentBuilder builder = new XContentBuilder(responseContentType.xContent(), unclosableOutputStream, includes, excludes);
        return newBuilder(request.getMediaType(), true);
     * call to this method.
    /**
            responseContentType = MediaType.fromFormat(format);
        }
        return newBuilder(request.getMediaType(), false);
 * specific language governing permissions and limitations
    }
 * license agreements. See the NOTICE file distributed with
            } else {
            bytesOut = newBytesOutput();
        }
        this.human = request.paramAsBoolean("human", false);
    private static final Predicate<String> INCLUDE_FILTER = f -> f.charAt(0) != '-';
import java.util.function.Predicate;
package org.opensearch.rest;
    }
    @Override
        this.pretty = request.paramAsBoolean("pretty", false);
            // TODO should format vs acceptHeader always be the same, do we allow overriding?
     */
    protected AbstractRestChannel(RestRequest request, boolean detailedErrorsEnabled) {
 * You may obtain a copy of the License at
            }
 */
    private final boolean detailedErrorStackTraceRequested;
     * Creates a new {@link XContentBuilder} for a response to be sent using this channel. The builder's type can be sent as a parameter,
        // try to determine the response content type from the media type or the format query string parameter, with the format parameter
    }
 *
 * software distributed under the License is distributed on an
     */
    @Override
        return this.request;
    public boolean detailedErrorsEnabled() {
        return bytesOut;
     * An accessor to the raw value of the channel bytes output. This method will not instantiate
    private final String filterPath;
 *
        if (responseContentType == null) {
import java.io.OutputStream;
    public XContentBuilder newBuilder(@Nullable MediaType requestContentType, @Nullable MediaType responseContentType, boolean useFiltering)
    private final String acceptHeader;
        }
        Set<String> excludes = Collections.emptySet();
 */
     * fails, the request content type will be used if the value is not {@code null}; if the value is {@code null} the output format falls
        return builder;
        if (useFiltering) {
            if (requestContentType != null) {
                responseContentType = MediaTypeRegistry.getDefaultMediaType();
        this.filterPath = request.param("filter_path", null);
                responseContentType = requestContentType;
 * Licensed to Elasticsearch under one or more contributor
 */
 * Base REST channel
     * by a call to {@link #newBytesOutput()}. Once the stream is created, it gets reset on each
/**
    /**
     * A channel level bytes output that can be reused. The bytes output is lazily instantiated
        if (responseContentType == null) {
     */
import static java.util.stream.Collectors.toSet;
        Set<String> includes = Collections.emptySet();
/*
 */
        }
import org.opensearch.core.xcontent.MediaType;
import org.opensearch.common.io.Streams;
        this.request = request;
}
    private static final Predicate<String> EXCLUDE_FILTER = INCLUDE_FILTER.negate();
        return bytesOut;
        builder.humanReadable(human);
        return newBuilder(requestContentType, null, useFiltering);
                // string parameter or the HTTP Accept header
 * The OpenSearch Contributors require contributions made to
 * @opensearch.api
     * is {@code null}.
/*
import org.opensearch.common.Nullable;
        this.detailedErrorsEnabled = detailedErrorsEnabled;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (bytesOut == null) {
 * KIND, either express or implied.  See the License for the
     * logic. If the request has a format parameter that will be used to attempt to map to an {@link MediaType}. If there is no format
        return detailedErrorsEnabled;
    }
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        }
    public XContentBuilder newErrorBuilder() throws IOException {
    private final boolean human;
import org.opensearch.core.xcontent.XContentBuilder;
    public boolean detailedErrorStackTraceEnabled() {
            }
     * Construct a channel for handling the request.
 * ownership. Elasticsearch licenses this file to you under
    @Override
        // Disable filtering when building error responses
    /**
     * parameter, the HTTP Accept header is checked to see if it can be matched to a {@link MediaType}. If this first attempt to map
            includes = filters.stream().filter(INCLUDE_FILTER).collect(toSet());
 * under the License.
 *
     */
 * SPDX-License-Identifier: Apache-2.0
        this.format = request.param("format");
        // taking precedence over the Accept header
 * this file be licensed under the Apache-2.0 license or a
    @Override
    }
    public RestRequest request() {
    }
    public XContentBuilder newBuilder() throws IOException {
     * @param request               the request
    public XContentBuilder newBuilder(@Nullable MediaType requestContentType, boolean useFiltering) throws IOException {
        if (pretty) {
        OutputStream unclosableOutputStream = Streams.flushOnCloseStream(bytesOutput());
import java.util.Collections;
    private BytesStreamOutput bytesOut;
     *
 * GitHub history for details.
public abstract class AbstractRestChannel implements RestChannel {
        return new BytesStreamOutput();
            builder.prettyPrint().lfAtEnd();
    /**
                // if there was a parsed content-type for the incoming request use that since no format was specified using the query
 *    http://www.apache.org/licenses/LICENSE-2.0
     * a new stream if one does not exist and this method will not reset the stream.
    }
        this.detailedErrorStackTraceRequested = request.paramAsBoolean("error_trace", false);
            Set<String> filters = Strings.tokenizeByCommaToSet(filterPath);
    @Override
    private final boolean detailedErrorsEnabled;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.MediaTypeRegistry;
            if (responseContentType == null) {
    @Override
                responseContentType = MediaType.fromMediaType(acceptHeader);
/*
    protected final RestRequest request;
     * @throws IllegalArgumentException if parsing the pretty or human parameters fails
import org.opensearch.core.common.Strings;
 * Modifications Copyright OpenSearch Contributors. See
     * back to JSON.
 * not use this file except in compliance with the License.
    }
     */
    }
                // default to JSON output when all else fails
