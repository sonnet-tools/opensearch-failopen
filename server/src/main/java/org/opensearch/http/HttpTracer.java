                "[{}][{}][{}][{}][{}][{}] sent response to [{}] success [{}]",
import org.opensearch.rest.RestResponse;  
class HttpTracer {
                opaqueHeader,  
            );
                    restRequest.getHttpChannel()
                    restRequest.uri(),
    private final Logger logger = LogManager.getLogger(HttpTracer.class);
    /**
        setTracerLogInclude(HttpTransportSettings.SETTING_HTTP_TRACE_LOG_INCLUDE.get(settings));
 * not use this file except in compliance with the License.
 * compatible open source license.
    @Nullable
     * @param requestId     Request id as returned by {@link RestRequest#getRequestId()}  
        );
 */  
 * specific language governing permissions and limitations
    }  
import org.opensearch.core.common.Strings;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.tasks.Task;
    /**  
    private void setTracerLogInclude(List<String> tracerLogInclude) {
 * ownership. Elasticsearch licenses this file to you under  
    void traceChunk(  
     * in {@link HttpTransportSettings#SETTING_HTTP_TRACE_LOG_INCLUDE} and {@link HttpTransportSettings#SETTING_HTTP_TRACE_LOG_EXCLUDE}.
 * @opensearch.internal  
 * Http request trace logger. See {@link #maybeTraceRequest(RestRequest, Exception)} for details.
     * @param chunk         response chunk
     * @param success       Whether the response was successfully sent
    ) {
     * Logs the given request if request tracing is enabled and the request uri matches the current include and exclude patterns defined
        return null;
            logger.trace(
     */
        long requestId,
        long requestId,
 * license agreements. See the NOTICE file distributed with
                ),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
                "[{}][{}][{}] sent next chunk to [{}] success [{}]",
     */
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
        StreamingHttpChannel httpChannel,
 *
        if (logger.isTraceEnabled() && TransportService.shouldTraceAction(restRequest.uri(), tracerLogInclude, tracerLogExclude)) {  
     * If the request was logged returns a logger to log sending the response with or {@code null} otherwise.  
     *
     * @param restResponse  RestResponse
        String contentLength,  
    private volatile String[] tracerLogInclude;  
        String opaqueHeader,
 */  
 */
            )
    /**
            return this;  
/*  
        clusterSettings.addSettingsUpdateConsumer(HttpTransportSettings.SETTING_HTTP_TRACE_LOG_EXCLUDE, this::setTracerLogExclude);  
import org.opensearch.common.settings.Settings;  
            new ParameterizedMessage(  
     * @param contentLength Value of the response content length header
import org.opensearch.common.settings.ClusterSettings;
                    restRequest.getRequestId(),
        String contentLength,  
    }
                contentLength,
        logger.trace(
                requestId,
 * software distributed under the License is distributed on an
                restResponse.status(),
        }
/*  
 * The OpenSearch Contributors require contributions made to  
    }  
import java.util.List;
    HttpTracer maybeTraceRequest(RestRequest restRequest, @Nullable Exception e) {
                opaqueHeader,  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                success  
                new ParameterizedMessage(
/*
        setTracerLogExclude(HttpTransportSettings.SETTING_HTTP_TRACE_LOG_EXCLUDE.get(settings));  
     *
     * @param success       Whether the response was successfully sent
     * @param opaqueHeader  Value of HTTP header {@link Task#X_OPAQUE_ID}
     * Logs the response to a request that was logged by {@link #maybeTraceRequest(RestRequest, Exception)}.  
     * @param httpChannel   HttpChannel the response was sent on  
                    restRequest.header(Task.X_OPAQUE_ID),
                requestId,
        RestResponse restResponse,
    }
/**  
     */  
     * @param restRequest Rest request to trace
                restResponse.status().getStatus(),
     * @param requestId     Request id as returned by {@link RestRequest#getRequestId()}  
 * SPDX-License-Identifier: Apache-2.0
            )
     *                    {@code null} if the request wasn't logged
 *
        this.tracerLogExclude = tracerLogExclude.toArray(Strings.EMPTY_ARRAY);
    }
import org.opensearch.transport.TransportService;
import org.apache.logging.log4j.Logger;
     * @param e           Exception when handling the request or {@code null} if none  
                restResponse.contentType(),  
                httpChannel,
import org.opensearch.rest.RestRequest;
        HttpChunk chunk,
 * under the License.  
    HttpTracer(Settings settings, ClusterSettings clusterSettings) {  
                    "[{}][{}][{}][{}] received request from [{}]",  
     * @param opaqueHeader  Value of HTTP header {@link Task#X_OPAQUE_ID}
     *
 *  
    void traceResponse(  
        boolean success  
        this.tracerLogInclude = tracerLogInclude.toArray(Strings.EMPTY_ARRAY);  
        boolean success  
package org.opensearch.http;
    private void setTracerLogExclude(List<String> tracerLogExclude) {  
        HttpChannel httpChannel,
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
}  
    ) {
     * @param httpChannel   HttpChannel the response was sent on  
                success  
 * GitHub history for details.
    private volatile String[] tracerLogExclude;
     * @return            This instance to use for logging the response via {@link #traceResponse} to this request if it was logged or
        String opaqueHeader,
 * Unless required by applicable law or agreed to in writing,
 *
    }  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
     * @param contentLength Value of the response content length header
                    restRequest.method(),  
import org.opensearch.common.Nullable;
                e
     * Logs the response chunk to a request that was logged by {@link #maybeTraceRequest(RestRequest, Exception)}.  
        );
                httpChannel,
                contentLength,
        logger.trace(
            new ParameterizedMessage(  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.logging.log4j.LogManager;
        clusterSettings.addSettingsUpdateConsumer(HttpTransportSettings.SETTING_HTTP_TRACE_LOG_INCLUDE, this::setTracerLogInclude);
