            BytesReference finalContent = content;  
            }
            ActionListener<Void> listener = ActionListener.wrap(() -> Releasables.close(toClose));
        }
    }
 */
    static final String SERVER_VERSION = "X-OpenSearch-Version";
            if (content instanceof Releasable) {
import static org.opensearch.tasks.Task.X_REQUEST_ID;  
        Releasables.closeWhileHandlingException(httpRequest::release);
            for (Map.Entry<String, List<String>> headerEntry : customHeaders.entrySet()) {  
                toClose.add((Releasable) content);  
    }
    private void addCookies(HttpResponse response) {
        this.bigArrays = bigArrays;
        }
            toClose.add(() -> CloseableChannel.closeChannel(httpChannel));  
    static final String CONTENT_TYPE = "content-type";
    private void setHeaderField(HttpResponse response, String headerField, String value) {  
import org.opensearch.common.lease.Releasable;
            addCustomHeaders(httpResponse, restResponse.getHeaders());
        BigArrays bigArrays,
    @Override  
        RestRequest request,
        // We're sending a response so we know we won't be needing the request content again and release it
        this.threadContext = threadContext;
            corsHandler.setCorsResponseHeaders(httpRequest, httpResponse);  
 * under the License.  
        this.httpChannel = httpChannel;  
    static final String CONNECTION = "connection";
            final HttpResponse httpResponse = httpRequest.createResponse(restResponse.status(), finalContent);
        super(request, settings.getDetailedErrorsEnabled());
            response.addHeader(headerField, value);  
        this.httpRequest = httpRequest;
        this.settings = settings;  
                for (String cookie : cookies) {  
 */  
        if (settings.isResetCookies()) {  
            opaque = request.header(X_OPAQUE_ID);
    }  
        }  
        @Nullable HttpTracer tracerLog  
    private final Map<String, List<String>> SERVER_VERSION_HEADER = Map.of(SERVER_VERSION, List.of(SERVER_VERSION_VALUE));
    static final String CLOSE = "close";
 * @opensearch.internal  
 * this work for additional information regarding copyright
            List<String> cookies = request.getHttpRequest().strictCookies();
import org.opensearch.core.common.bytes.BytesArray;
        }
import org.opensearch.core.common.bytes.BytesReference;  
import java.util.ArrayList;
    private void addCustomHeaders(HttpResponse response, Map<String, List<String>> customHeaders) {
    private final BigArrays bigArrays;  
    private final CorsHandler corsHandler;
            httpChannel.sendResponse(httpResponse, listener);  
 *
import org.opensearch.Build;
            }
    static final String SET_COOKIE = "set-cookie";  
            addCookies(httpResponse);
import org.opensearch.common.util.BigArrays;
 *
            setHeaderField(httpResponse, CONTENT_TYPE, restResponse.contentType(), false);
 * Unless required by applicable law or agreed to in writing,
            if (opaque != null) {  
        this.corsHandler = corsHandler;
 * KIND, either express or implied.  See the License for the
                    setHeaderField(response, headerEntry.getKey(), headerValue);
            }  
    }
    static final String KEEP_ALIVE = "keep-alive";  
        } finally {
 * GitHub history for details.
        String contentLength = null;
            // If our response has no content-length, calculate and set one  
 * compatible open source license.
import org.opensearch.core.action.ActionListener;
            } catch (IllegalArgumentException ignored) {
import org.opensearch.common.Nullable;
    }
import org.opensearch.common.util.concurrent.ThreadContext;  
        String opaque = null;
import org.opensearch.rest.AbstractRestChannel;
import java.util.Map;  
package org.opensearch.http;
        setHeaderField(response, headerField, value, true);
 * response. It will set necessary headers and ensure that bytes are released after the response is sent.
            if (success == false) {  
 * software distributed under the License is distributed on an
                }  
                    response.addHeader(SET_COOKIE, cookie);
        return new ReleasableBytesStreamOutput(bigArrays);
            try {
            }
            success = true;
        if (override || !response.containsHeader(headerField)) {
/*
    ) {
import org.opensearch.rest.RestRequest;
                }
/*  
                toClose.add((Releasable) bytesStreamOutput);
        HttpHandlingSettings settings,  
import org.opensearch.common.lease.Releasables;  
}  
        + " ("
            // If our response doesn't specify a content-type header, set one
import java.util.List;
    }  
    private final HttpTracer tracerLog;
        boolean success = false;  
                Releasables.close(toClose);
        final ArrayList<Releasable> toClose = new ArrayList<>(3);
import org.opensearch.rest.RestResponse;
 * specific language governing permissions and limitations
                for (String headerValue : headerEntry.getValue()) {
 * ownership. Elasticsearch licenses this file to you under  
    private final ThreadContext threadContext;
    protected BytesStreamOutput newBytesOutput() {
            }
        HttpRequest httpRequest,  
                }
            if (tracerLog != null) {  
    DefaultRestChannel(
 */
            }
        if (HttpUtils.shouldCloseConnection(httpRequest)) {
 * this file be licensed under the Apache-2.0 license or a
            // Add all custom headers
import org.opensearch.common.network.CloseableChannel;
 * the Apache License, Version 2.0 (the "License"); you may
            if (request.header(X_REQUEST_ID) != null) {  
        + ")";  
    public void sendResponse(RestResponse restResponse) {  
 */  
            }
                    : "request HTTP method is unsupported but HTTP status is not METHOD_NOT_ALLOWED(405)";
    static final String CONTENT_LENGTH = "content-length";
        + Build.CURRENT.getQualifiedVersion()  
import org.opensearch.core.rest.RestStatus;
        try {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
    @Nullable
            contentLength = String.valueOf(restResponse.content().length());
            BytesStreamOutput bytesStreamOutput = bytesOutputOrNull();  
 * Licensed to Elasticsearch under one or more contributor  
                    finalContent = BytesArray.EMPTY;  
        HttpChannel httpChannel,
 * You may obtain a copy of the License at  
        + Build.CURRENT.getDistribution()
    static final String SERVER_VERSION_VALUE = "OpenSearch/"
import org.opensearch.common.io.stream.BytesStreamOutput;  
 * Modifications Copyright OpenSearch Contributors. See
    private final HttpHandlingSettings settings;
    }
            }  
                assert restResponse.status() == RestStatus.METHOD_NOT_ALLOWED  
        }
        if (customHeaders != null) {
        CorsHandler corsHandler,
            addCustomHeaders(httpResponse, threadContext.getResponseHeaders());  
    @Override
                if (request.method() == RestRequest.Method.HEAD) {
 *
            final BytesReference content = restResponse.content();
            if (bytesStreamOutput instanceof ReleasableBytesStreamOutput) {
            addCustomHeaders(httpResponse, SERVER_VERSION_HEADER);
    private final HttpChannel httpChannel;  
/*  
        ThreadContext threadContext,
                tracerLog.traceResponse(restResponse, httpChannel, contentLength, opaque, request.getRequestId(), success);
            }
 * not use this file except in compliance with the License.
                setHeaderField(httpResponse, X_REQUEST_ID, request.header(X_REQUEST_ID));
class DefaultRestChannel extends AbstractRestChannel implements RestChannel {
            if (cookies.isEmpty() == false) {
/**
 *  
 * The default rest channel for incoming requests. This class implements the basic logic for sending a rest  
import static org.opensearch.tasks.Task.X_OPAQUE_ID;
        this.tracerLog = tracerLog;  
    private final HttpRequest httpRequest;
                setHeaderField(httpResponse, X_OPAQUE_ID, opaque);
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
 * The OpenSearch Contributors require contributions made to  
            setHeaderField(httpResponse, CONTENT_LENGTH, contentLength, false);
import org.opensearch.rest.RestChannel;  
    private void setHeaderField(HttpResponse response, String headerField, String value, boolean override) {
 *    http://www.apache.org/licenses/LICENSE-2.0
