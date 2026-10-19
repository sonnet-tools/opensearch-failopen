    /**
        this.detailedErrorStackTraceRequested = request.paramAsBoolean("error_trace", false);
            bytesOut = newBytesOutput();  
     */
            builder.prettyPrint().lfAtEnd();  
 * this file be licensed under the Apache-2.0 license or a
            includes = filters.stream().filter(INCLUDE_FILTER).collect(toSet());
import org.opensearch.core.common.Strings;  
            // TODO should format vs acceptHeader always be the same, do we allow overriding?  
    }
import org.opensearch.core.xcontent.MediaType;
        } else {
    protected final RestRequest request;
            if (responseContentType == null) {
    }
        return bytesOut;
    private final String filterPath;
 *  
 * not use this file except in compliance with the License.
 */  
        OutputStream unclosableOutputStream = Streams.flushOnCloseStream(bytesOutput());  
        }
    private final boolean pretty;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    @Override
     * A channel level bytes output that can be reused. The bytes output is lazily instantiated
        if (pretty) {
    public XContentBuilder newErrorBuilder() throws IOException {
        Set<String> includes = Collections.emptySet();
 * @opensearch.api
            } else {
        return detailedErrorStackTraceRequested;  
     * a new stream if one does not exist and this method will not reset the stream.  
 *
        return this.request;  
    public final BytesStreamOutput bytesOutput() {
        }
    }
 * ownership. Elasticsearch licenses this file to you under  
    private final String acceptHeader;
                // string parameter or the HTTP Accept header
     */
     * back to JSON.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
                responseContentType = MediaTypeRegistry.getDefaultMediaType();  
    @Override
     */
    }
    private final boolean human;
    private final boolean detailedErrorsEnabled;  
            Set<String> filters = Strings.tokenizeByCommaToSet(filterPath);
     * @param request               the request
    }  
    protected final BytesStreamOutput bytesOutputOrNull() {
        if (responseContentType == null) {
        }
import org.opensearch.common.io.stream.BytesStreamOutput;
 * You may obtain a copy of the License at  
    protected BytesStreamOutput newBytesOutput() {  
    private final boolean detailedErrorStackTraceRequested;  
        return newBuilder(request.getMediaType(), false);  
    @Override  
        this.filterPath = request.param("filter_path", null);
     *  
 *  
        if (responseContentType == null) {
    private static final Predicate<String> EXCLUDE_FILTER = INCLUDE_FILTER.negate();  
    }
        this.format = request.param("format");
    public boolean detailedErrorStackTraceEnabled() {
    }
                responseContentType = MediaType.fromMediaType(acceptHeader);  
     * through {@code responseContentType} or it can fallback to {@link #newBuilder(MediaType, boolean)} logic if the sent type value
 * license agreements. See the NOTICE file distributed with
/*  
        Set<String> excludes = Collections.emptySet();
import java.util.Collections;
/*
            bytesOut.reset();
 */
     */
            responseContentType = MediaType.fromFormat(format);
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.io.Streams;
        // try to determine the response content type from the media type or the format query string parameter, with the format parameter  
 * the Apache License, Version 2.0 (the "License"); you may
     * fails, the request content type will be used if the value is not {@code null}; if the value is {@code null} the output format falls
    @Override  
import java.io.IOException;
import org.opensearch.core.xcontent.XContentBuilder;  
    /**  
 * this work for additional information regarding copyright
     * Creates a new {@link XContentBuilder} for a response to be sent using this channel. The builder's type can be sent as a parameter,
    private BytesStreamOutput bytesOut;
    private final String format;
        this.pretty = request.paramAsBoolean("pretty", false);
     */  
        this.human = request.paramAsBoolean("human", false);  
    @Override  
 */
 * SPDX-License-Identifier: Apache-2.0
    public boolean detailedErrorsEnabled() {
            }
     * logic. If the request has a format parameter that will be used to attempt to map to an {@link MediaType}. If there is no format
    @Override
import java.util.function.Predicate;  
     * @param detailedErrorsEnabled if detailed errors should be reported to the channel
        return builder;
     * parameter, the HTTP Accept header is checked to see if it can be matched to a {@link MediaType}. If this first attempt to map  
    /**
    }
    /**
        // taking precedence over the Accept header
        }
    /**  
 */
            excludes = filters.stream().filter(EXCLUDE_FILTER).map(f -> f.substring(1)).collect(toSet());  
                responseContentType = requestContentType;  
     * Construct a channel for handling the request.
        this.detailedErrorsEnabled = detailedErrorsEnabled;
public abstract class AbstractRestChannel implements RestChannel {  
 *
        return detailedErrorsEnabled;
import org.opensearch.common.Nullable;  
 * KIND, either express or implied.  See the License for the
        XContentBuilder builder = new XContentBuilder(responseContentType.xContent(), unclosableOutputStream, includes, excludes);
    private static final Predicate<String> INCLUDE_FILTER = f -> f.charAt(0) != '-';
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
    public RestRequest request() {
    public XContentBuilder newBuilder(@Nullable MediaType requestContentType, @Nullable MediaType responseContentType, boolean useFiltering)  
     * An accessor to the raw value of the channel bytes output. This method will not instantiate
        if (useFiltering) {  
    @Override
package org.opensearch.rest;
     * call to this method.
        this.acceptHeader = request.header("Accept");  
        return new BytesStreamOutput();
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
    }
        // Disable filtering when building error responses
/*
 * compatible open source license.
        return newBuilder(request.getMediaType(), true);  
                // default to JSON output when all else fails
        builder.humanReadable(human);  
                // if there was a parsed content-type for the incoming request use that since no format was specified using the query
    public XContentBuilder newBuilder() throws IOException {
     * @throws IllegalArgumentException if parsing the pretty or human parameters fails  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
import java.util.Set;
        this.request = request;  
        return bytesOut;  
    }
     * by a call to {@link #newBytesOutput()}. Once the stream is created, it gets reset on each  
import static java.util.stream.Collectors.toSet;
        if (bytesOut == null) {
        return newBuilder(requestContentType, null, useFiltering);  
    public XContentBuilder newBuilder(@Nullable MediaType requestContentType, boolean useFiltering) throws IOException {
    protected AbstractRestChannel(RestRequest request, boolean detailedErrorsEnabled) {
     * Creates a new {@link XContentBuilder} for a response to be sent using this channel. The builder's type is determined by the following
            }
        }  
 * specific language governing permissions and limitations
 * Base REST channel
     * is {@code null}.  
}
import java.io.OutputStream;  
            if (requestContentType != null) {  
        throws IOException {
    }
