            }
import java.util.ArrayList;
        // We're sending a response so we know we won't be needing the request content again and release it
                if (request.method() == RestRequest.Method.HEAD) {
    static final String SERVER_VERSION = "X-OpenSearch-Version";
            }
        BigArrays bigArrays,
    static final String SERVER_VERSION_VALUE = "OpenSearch/"
            }
 * KIND, either express or implied.  See the License for the
import org.opensearch.rest.RestRequest;
        Releasables.closeWhileHandlingException(httpRequest::release);
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
        @Nullable HttpTracer tracerLog
        + Build.CURRENT.getDistribution()
                tracerLog.traceResponse(restResponse, httpChannel, contentLength, opaque, request.getRequestId(), success);
import org.opensearch.common.io.stream.BytesStreamOutput;
        if (customHeaders != null) {
import org.opensearch.common.Nullable;
    static final String KEEP_ALIVE = "keep-alive";
            if (opaque != null) {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.tasks.Task.X_REQUEST_ID;
 * @opensearch.internal
            }
 */
            if (tracerLog != null) {
            // If our response doesn't specify a content-type header, set one
        HttpRequest httpRequest,
                }
            addCustomHeaders(httpResponse, restResponse.getHeaders());
 * compatible open source license.
        this.httpRequest = httpRequest;
 * Unless required by applicable law or agreed to in writing,
        }
 *
        if (override || !response.containsHeader(headerField)) {
    private void addCookies(HttpResponse response) {
class DefaultRestChannel extends AbstractRestChannel implements RestChannel {
    private final BigArrays bigArrays;
                for (String cookie : cookies) {
import org.opensearch.rest.AbstractRestChannel;
        HttpChannel httpChannel,
        RestRequest request,
    private final HttpHandlingSettings settings;
            addCookies(httpResponse);
    static final String CONTENT_LENGTH = "content-length";
 * this file be licensed under the Apache-2.0 license or a
            final BytesReference content = restResponse.content();
            setHeaderField(httpResponse, CONTENT_LENGTH, contentLength, false);
import org.opensearch.core.action.ActionListener;
        + " ("
    }
 * under the License.
import org.opensearch.common.lease.Releasable;
    private final Map<String, List<String>> SERVER_VERSION_HEADER = Map.of(SERVER_VERSION, List.of(SERVER_VERSION_VALUE));
 *
        this.bigArrays = bigArrays;
            addCustomHeaders(httpResponse, threadContext.getResponseHeaders());
            ActionListener<Void> listener = ActionListener.wrap(() -> Releasables.close(toClose));
        }
                toClose.add((Releasable) content);
        this.httpChannel = httpChannel;
        final ArrayList<Releasable> toClose = new ArrayList<>(3);
import org.opensearch.Build;
        ThreadContext threadContext,
        String opaque = null;
import org.opensearch.common.util.BigArrays;
                }
    @Override
 *
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            addCustomHeaders(httpResponse, SERVER_VERSION_HEADER);
 * The default rest channel for incoming requests. This class implements the basic logic for sending a rest
        setHeaderField(response, headerField, value, true);
                    finalContent = BytesArray.EMPTY;
                toClose.add((Releasable) bytesStreamOutput);
import java.util.List;
 * The OpenSearch Contributors require contributions made to
            success = true;
            contentLength = String.valueOf(restResponse.content().length());
import org.opensearch.rest.RestChannel;
        try {
            }
import org.opensearch.common.network.CloseableChannel;
import org.opensearch.common.lease.Releasables;
 */
        this.settings = settings;
 * You may obtain a copy of the License at
        + ")";
            opaque = request.header(X_OPAQUE_ID);
            // If our response has no content-length, calculate and set one
                    : "request HTTP method is unsupported but HTTP status is not METHOD_NOT_ALLOWED(405)";
            BytesReference finalContent = content;
        HttpHandlingSettings settings,
import static org.opensearch.tasks.Task.X_OPAQUE_ID;
                    setHeaderField(response, headerEntry.getKey(), headerValue);
        }
                }
    private final CorsHandler corsHandler;
                setHeaderField(httpResponse, X_REQUEST_ID, request.header(X_REQUEST_ID));
    private void setHeaderField(HttpResponse response, String headerField, String value, boolean override) {
 * response. It will set necessary headers and ensure that bytes are released after the response is sent.
    static final String CONTENT_TYPE = "content-type";
    private final ThreadContext threadContext;
        CorsHandler corsHandler,
 * specific language governing permissions and limitations
 *
    }
    static final String CONNECTION = "connection";
                assert restResponse.status() == RestStatus.METHOD_NOT_ALLOWED
    @Nullable
 */
 * GitHub history for details.
    private final HttpChannel httpChannel;
 * Licensed to Elasticsearch under one or more contributor
    }
            httpChannel.sendResponse(httpResponse, listener);
import org.opensearch.common.util.concurrent.ThreadContext;
    private void addCustomHeaders(HttpResponse response, Map<String, List<String>> customHeaders) {
        this.corsHandler = corsHandler;
            if (content instanceof Releasable) {
}
 * this work for additional information regarding copyright
import org.opensearch.rest.RestResponse;
            List<String> cookies = request.getHttpRequest().strictCookies();
    protected BytesStreamOutput newBytesOutput() {
    }
            }
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under
            setHeaderField(httpResponse, CONTENT_TYPE, restResponse.contentType(), false);
/*
            if (success == false) {
    private final HttpTracer tracerLog;
            toClose.add(() -> CloseableChannel.closeChannel(httpChannel));
import org.opensearch.core.common.bytes.BytesReference;
            for (Map.Entry<String, List<String>> headerEntry : customHeaders.entrySet()) {
                Releasables.close(toClose);
            if (bytesStreamOutput instanceof ReleasableBytesStreamOutput) {
        }
        }
            if (cookies.isEmpty() == false) {
            } catch (IllegalArgumentException ignored) {
            // Add all custom headers
                setHeaderField(httpResponse, X_OPAQUE_ID, opaque);
            response.addHeader(headerField, value);
            final HttpResponse httpResponse = httpRequest.createResponse(restResponse.status(), finalContent);
    ) {
        this.tracerLog = tracerLog;
        if (HttpUtils.shouldCloseConnection(httpRequest)) {
        boolean success = false;
                    response.addHeader(SET_COOKIE, cookie);
                for (String headerValue : headerEntry.getValue()) {
    static final String CLOSE = "close";
            }
            if (request.header(X_REQUEST_ID) != null) {
            }
    private final HttpRequest httpRequest;
    DefaultRestChannel(
        + Build.CURRENT.getQualifiedVersion()
 * Modifications Copyright OpenSearch Contributors. See
            BytesStreamOutput bytesStreamOutput = bytesOutputOrNull();
        super(request, settings.getDetailedErrorsEnabled());
/*
    private void setHeaderField(HttpResponse response, String headerField, String value) {
        return new ReleasableBytesStreamOutput(bigArrays);
        } finally {
import java.util.Map;
package org.opensearch.http;
    @Override
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        String contentLength = null;
import org.opensearch.core.common.bytes.BytesArray;
    }
 * software distributed under the License is distributed on an
/**
 */
/*
        if (settings.isResetCookies()) {
    static final String SET_COOKIE = "set-cookie";
import org.opensearch.core.rest.RestStatus;
        this.threadContext = threadContext;
            try {
            }
            corsHandler.setCorsResponseHeaders(httpRequest, httpResponse);
    public void sendResponse(RestResponse restResponse) {
