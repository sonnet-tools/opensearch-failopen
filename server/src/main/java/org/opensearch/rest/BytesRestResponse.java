        ensureExpectedToken(XContentParser.Token.START_OBJECT, token, parser);  
    }
    private static BytesArray toBytesArray(String content) {
 * specific language governing permissions and limitations
    public BytesRestResponse(RestChannel channel, Exception e) throws IOException {  
    }
import org.apache.logging.log4j.util.Supplier;
    }
    public BytesRestResponse(RestStatus status, String contentType, String content) {
        this(status, contentType, toBytesArray(content));
     */  
        try {  
     * Creates a new plain text response.
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
    static BytesRestResponse createSimpleErrorResponse(RestChannel channel, RestStatus status, String errorMessage) throws IOException {  
    }
        XContentParser.Token token = parser.nextToken();
     * Creates a new response based on {@link XContentBuilder}.  
    private static final Logger SUPPRESSED_ERROR_LOGGER = LogManager.getLogger("rest.suppressed");
            if (status.getStatus() < 500) {
        this(status, builder.contentType().mediaType(), BytesReference.bytes(builder));  
import org.apache.lucene.util.UnicodeUtil;
 *
 * compatible open source license.
        return result;
        for (String metadata : exception.getMetadataKeys()) {
 * this file be licensed under the Apache-2.0 license or a
        this.status = status;
            && false == skipStackTrace()) {  
import org.opensearch.core.xcontent.ToXContent;  
 * Unless required by applicable law or agreed to in writing,
    }  
    public BytesRestResponse(RestStatus status, String content) {  
                SUPPRESSED_ERROR_LOGGER.debug(messageSupplier, e);
    }
            throw overflowGuardFailureToRequestEntityTooLarge(e);  
                }
    public String contentType() {
 * this work for additional information regarding copyright
     * Creates a binary response.  
        }  
import org.opensearch.core.xcontent.XContentBuilder;
    private final RestStatus status;
 * Modifications Copyright OpenSearch Contributors. See
            status,
 *
import org.opensearch.core.rest.RestStatus;
 */
    public BytesRestResponse(RestStatus status, String contentType, byte[] content) {
            }
        }  
    }  
    }
        if (params.paramAsBoolean("error_trace", OpenSearchException.REST_EXCEPTION_SKIP_STACK_TRACE_DEFAULT == false)
 */  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
    private ToXContent.Params paramsFromRequest(RestRequest restRequest) {  
            if (token == XContentParser.Token.FIELD_NAME) {
        ToXContent.Params params = paramsFromRequest(channel.request());
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        return new OpenSearchStatusException(e.getMessage(), RestStatus.REQUEST_ENTITY_TOO_LARGE, e);
    private final BytesReference content;
            if ((long) content.length() * UnicodeUtil.MAX_UTF8_BYTES_PER_CHAR <= Integer.MAX_VALUE) {  
            build(builder, params, status, channel.detailedErrorsEnabled(), e);  
        }
    }
                if (token != XContentParser.Token.FIELD_NAME) {
     */
}  
    }
import org.opensearch.core.xcontent.XContentParser;
 * GitHub history for details.
    }  
        this(status, TEXT_CONTENT_TYPE, content);
import org.opensearch.OpenSearchStatusException;
    /**
    }
import org.opensearch.core.common.bytes.BytesArray;  
            throw new IllegalStateException("Failed to parse opensearch status exception: no exception was found");  
        OpenSearchException exception = null;
            // log exception only if it is not returned in the response
            return new BytesArray(content);
package org.opensearch.rest;
    public BytesRestResponse(RestStatus status, XContentBuilder builder) {
import org.apache.logging.log4j.message.ParameterizedMessage;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            channel.newErrorBuilder().startObject().field("error", errorMessage).field("status", status.getStatus()).endObject()  
            }
/**  
    @Override  
                    status = RestStatus.fromCode(parser.intValue());
        this(channel, ExceptionsHelper.status(e), e);
        OpenSearchStatusException result = new OpenSearchStatusException(exception.getMessage(), status, exception.getCause());  
 * SPDX-License-Identifier: Apache-2.0
        builder.field(STATUS, status.getStatus());
    }
        } catch (IllegalArgumentException e) {
        if (params.paramAsBoolean(  
    @Override
        return this.content;
        }  
    protected boolean skipStackTrace() {  
            }  
     */
    public RestStatus status() {
            params = new ToXContent.DelegatingMapParams(singletonMap(OpenSearchException.REST_EXCEPTION_SKIP_STACK_TRACE, "false"), params);
                exception = OpenSearchException.failureFromXContent(parser);
 * REST response in bytes
            this.contentType = builder.contentType().mediaType();
    private final String contentType;  
                "path: {}, params: {}",  
import java.io.IOException;
        for (String header : exception.getHeaderKeys()) {
                currentFieldName = parser.currentName();
        return false;
    /**
 * under the License.  
import static java.util.Collections.singletonMap;  
        return this.status;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
            Supplier<?> messageSupplier = () -> new ParameterizedMessage(
    public static OpenSearchStatusException errorFromXContent(XContentParser parser) throws IOException {
    }
        }
 */  
import org.opensearch.core.common.bytes.BytesReference;
        }  
            } else {  
     * Creates a new plain text response.
     */
        ) && e != null) {  
        return this.contentType;
                channel.request().params()
        if (e instanceof OpenSearchException openSearchException) {
        OpenSearchException.generateFailureXContent(builder, params, e, detailedErrorsEnabled);
/*  
            result.addMetadata(metadata, exception.getMetadata(metadata));
        ToXContent.Params params = restRequest;
    public BytesReference content() {  
            } else {  
    @Override
        return new BytesRestResponse(
        RestStatus status = null;  
     * Creates a binary response.
            copyHeaders(openSearchException);
     */
    /**  
        }  
    public static final String TEXT_CONTENT_TYPE = "text/plain; charset=UTF-8";
        return params;  
public class BytesRestResponse extends RestResponse {
/*
                throw e;
 * @opensearch.api  
    /**  
    private void build(XContentBuilder builder, ToXContent.Params params, RestStatus status, boolean detailedErrorsEnabled, Exception e)
        throws IOException {
import org.opensearch.ExceptionsHelper;  
        try (XContentBuilder builder = channel.newErrorBuilder()) {
import org.opensearch.OpenSearchException;
 * Licensed to Elasticsearch under one or more contributor  
        }
 * not use this file except in compliance with the License.
            if (STATUS.equals(currentFieldName)) {
    /**
/*  
        this.status = status;
        this.contentType = contentType;  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
import org.apache.logging.log4j.LogManager;
        );
        this.content = content;
            this.content = BytesReference.bytes(builder);
                channel.request().rawPath(),
        }  
            }
            );  
            OpenSearchException.REST_EXCEPTION_SKIP_STACK_TRACE_DEFAULT
                SUPPRESSED_ERROR_LOGGER.warn(messageSupplier, e);
 * You may obtain a copy of the License at  
    }
            result.addHeader(header, exception.getHeader(header));
import org.apache.logging.log4j.Logger;
    private static final String STATUS = "status";  
        this(status, contentType, new BytesArray(content));  
        builder.startObject();  
    private static OpenSearchStatusException overflowGuardFailureToRequestEntityTooLarge(IllegalArgumentException e) {
        if (exception == null) {
            OpenSearchException.REST_EXCEPTION_SKIP_STACK_TRACE,
    public BytesRestResponse(RestChannel channel, RestStatus status, Exception e) throws IOException {
                    ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, token, parser);  
        builder.endObject();  
        String currentFieldName = null;
 *
 * KIND, either express or implied.  See the License for the
    public BytesRestResponse(RestStatus status, String contentType, BytesReference content) {  
 */
