import org.opensearch.core.common.bytes.BytesArray;
        this.status = status;
        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);
            if (status.getStatus() < 500) {
 * Unless required by applicable law or agreed to in writing,
    @Override
        }
            OpenSearchException.REST_EXCEPTION_SKIP_STACK_TRACE,
    /**
    public RestStatus status() {
    }
            }
    private static OpenSearchStatusException overflowGuardFailureToRequestEntityTooLarge(IllegalArgumentException e) {
        }
    }
 */
import org.apache.logging.log4j.LogManager;
 * REST response in bytes
    public BytesRestResponse(RestChannel channel, Exception e) throws IOException {
 */
import org.opensearch.OpenSearchException;
    public BytesRestResponse(RestChannel channel, RestStatus status, Exception e) throws IOException {
            } else {
        builder.startObject();
            return new BytesArray(content);
        }
    }
    }
        throws IOException {
 * The OpenSearch Contributors require contributions made to
     * Creates a new response based on {@link XContentBuilder}.
    }
            channel.newErrorBuilder().startObject().field("error", errorMessage).field("status", status.getStatus()).endObject()
        this.status = status;
    public BytesRestResponse(RestStatus status, String contentType, BytesReference content) {
/*
    }
 * software distributed under the License is distributed on an
        builder.endObject();
            this.contentType = builder.contentType().mediaType();
        }
            throw new IllegalStateException("Failed to parse opensearch status exception: no exception was found");
        ) && e != null) {
     */
     */
    public BytesRestResponse(RestStatus status, String contentType, byte[] content) {
            );
import org.opensearch.OpenSearchStatusException;
    }
     * Creates a new plain text response.
        }
        return this.status;
import org.opensearch.core.xcontent.XContentBuilder;
        this.content = content;
        ToXContent.Params params = restRequest;
/**
    }
 */
    private void build(XContentBuilder builder, ToXContent.Params params, RestStatus status, boolean detailedErrorsEnabled, Exception e)
    }
    private static final String STATUS = "status";
                exception = OpenSearchException.failureFromXContent(parser);
            OpenSearchException.REST_EXCEPTION_SKIP_STACK_TRACE_DEFAULT
     * Creates a binary response.
package org.opensearch.rest;
     */
    @Override
            result.addMetadata(metadata, exception.getMetadata(metadata));
     * Creates a new plain text response.
 * GitHub history for details.
        if (e instanceof OpenSearchException openSearchException) {
        this(status, TEXT_CONTENT_TYPE, content);
    public static final String TEXT_CONTENT_TYPE = "text/plain; charset=UTF-8";
 */
            } else {
                currentFieldName = parser.currentName();
    }
        return result;
        this(status, contentType, new BytesArray(content));
        this(status, builder.contentType().mediaType(), BytesReference.bytes(builder));
     * Creates a binary response.
            status,
    private static final Logger SUPPRESSED_ERROR_LOGGER = LogManager.getLogger("rest.suppressed");
        }
 * under the License.
    public BytesRestResponse(RestStatus status, String contentType, String content) {
    private static BytesArray toBytesArray(String content) {
    static BytesRestResponse createSimpleErrorResponse(RestChannel channel, RestStatus status, String errorMessage) throws IOException {
        this(status, contentType, toBytesArray(content));
            if (STATUS.equals(currentFieldName)) {
    /**
                throw e;
            }
            copyHeaders(openSearchException);
        } catch (IllegalArgumentException e) {
    protected boolean skipStackTrace() {
 * the Apache License, Version 2.0 (the "License"); you may
            build(builder, params, status, channel.detailedErrorsEnabled(), e);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
import org.apache.logging.log4j.Logger;
 *
 * @opensearch.api
 * not use this file except in compliance with the License.
        RestStatus status = null;
    public BytesRestResponse(RestStatus status, String content) {
public class BytesRestResponse extends RestResponse {
 *    http://www.apache.org/licenses/LICENSE-2.0
        this(channel, ExceptionsHelper.status(e), e);
    private final RestStatus status;
        OpenSearchException exception = null;
        return false;
        return params;
        return new BytesRestResponse(
        }
 * specific language governing permissions and limitations
        for (String header : exception.getHeaderKeys()) {
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.xcontent.XContentParser;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private final BytesReference content;
            // log exception only if it is not returned in the response
            }
 * You may obtain a copy of the License at
        this.contentType = contentType;
 * compatible open source license.
        if (exception == null) {
        return this.content;
            }
                SUPPRESSED_ERROR_LOGGER.debug(messageSupplier, e);
    }
        }
                if (token != XContentParser.Token.FIELD_NAME) {
    /**
 *
        for (String metadata : exception.getMetadataKeys()) {
        }
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
        String currentFieldName = null;
/*
        try {
    public String contentType() {
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
                    ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);
        OpenSearchException.generateFailureXContent(builder, params, e, detailedErrorsEnabled);
    }
        XContentParser.Token token = parser.nextToken();
import org.apache.logging.log4j.message.ParameterizedMessage;
import static java.util.Collections.singletonMap;
    /**
     */
    public BytesRestResponse(RestStatus status, XContentBuilder builder) {
     */
    public static OpenSearchStatusException errorFromXContent(XContentParser parser) throws IOException {
            result.addHeader(header, exception.getHeader(header));
            if (token == XContentParser.Token.FIELD_NAME) {
    }
}
 *
            Supplier<?> messageSupplier = () -> new ParameterizedMessage(
import org.apache.lucene.util.UnicodeUtil;
import org.apache.logging.log4j.util.Supplier;
                SUPPRESSED_ERROR_LOGGER.warn(messageSupplier, e);
        return this.contentType;
import org.opensearch.core.common.bytes.BytesReference;
        try (XContentBuilder builder = channel.newErrorBuilder()) {
        if (params.paramAsBoolean("error_trace", OpenSearchException.REST_EXCEPTION_SKIP_STACK_TRACE_DEFAULT == false)
            && false == skipStackTrace()) {
    private final String contentType;
 *
    }
    @Override
                channel.request().params()
        OpenSearchStatusException result = new OpenSearchStatusException(exception.getMessage(), status, exception.getCause());
        );
            if ((long) content.length() * UnicodeUtil.MAX_UTF8_BYTES_PER_CHAR <= Integer.MAX_VALUE) {
    private ToXContent.Params paramsFromRequest(RestRequest restRequest) {
import org.opensearch.core.rest.RestStatus;
 * SPDX-License-Identifier: Apache-2.0
            throw overflowGuardFailureToRequestEntityTooLarge(e);
import org.opensearch.ExceptionsHelper;
/*
    public BytesReference content() {
    /**
import org.opensearch.core.xcontent.ToXContent;
                    status = RestStatus.fromCode(parser.intValue());
            this.content = BytesReference.bytes(builder);
    }
            params = new ToXContent.DelegatingMapParams(singletonMap(OpenSearchException.REST_EXCEPTION_SKIP_STACK_TRACE, "false"), params);
        if (params.paramAsBoolean(
        ToXContent.Params params = paramsFromRequest(channel.request());
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
                }
    }
        builder.field(STATUS, status.getStatus());
 * ownership. Elasticsearch licenses this file to you under
        return new OpenSearchStatusException(e.getMessage(), RestStatus.REQUEST_ENTITY_TOO_LARGE, e);
                channel.request().rawPath(),
                "path: {}, params: {}",
