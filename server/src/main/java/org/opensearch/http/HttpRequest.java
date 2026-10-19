 * under the License.  
 *
 * You may obtain a copy of the License at  
     *
 * @opensearch.api  
    }
    HttpRequest removeHeader(String header);
     * Returns the HTTP method used in the HTTP request.
import org.opensearch.core.rest.RestStatus;
 * this work for additional information regarding copyright
import org.opensearch.core.common.bytes.BytesReference;  
        return null;  
     * any resources associated with this instance. If the instance does not use any shared resources, returns itself.
    List<String> strictCookies();  
 * KIND, either express or implied.  See the License for the
/*
 */  
     */
     */
    /**
    }
     */
        }
     */
import java.util.Map;  
 */
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.Nullable;
import java.util.List;
        HTTP_1_1,
    /**  
    void release();  
 * Licensed to Elasticsearch under one or more contributor  
    @Nullable
 * A basic http request abstraction. Http modules needs to implement this interface to integrate with the  
 */  
     * after this method has been invoked is undefined and implementation specific.
     * @opensearch.api
import org.opensearch.rest.RestRequest;
     * The uri of the rest request, with the query string.  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.annotation.PublicApi;
        if (values != null && values.isEmpty() == false) {
/*  
            return Collections.unmodifiableList(values);
 * GitHub history for details.
    }
 * The OpenSearch Contributors require contributions made to  
    Map<String, List<String>> getHeaders();  
    /**
        List<String> values = getHeaders().get(name);  
     *
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    HttpResponse createResponse(RestStatus status, BytesReference content);  
     */
 *
            return values.get(0);
     * @return the {@link RestRequest.Method} used in the REST request  
    /**  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
     * @throws IllegalArgumentException if the HTTP method is invalid
        HTTP_2_0,
     */  
package org.opensearch.http;
    HttpRequest releaseAndCopy();
    /**
        List<String> values = getHeaders().get(name);
    RestRequest.Method method();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
     * Create an http response from this request and the supplied status and content.
 * this file be licensed under the Apache-2.0 license or a
    default String header(String name) {
    Exception getInboundException();  
 * the Apache License, Version 2.0 (the "License"); you may
     */  
        }  
        HTTP_1_0,  
public interface HttpRequest {  
     * Get all of the headers and values associated with the headers. Modifications of this map are not supported.
 * not use this file except in compliance with the License.
    /**
     * If this instances uses any pooled resources, creates a copy of this instance that does not use any pooled resources and releases  
 * server package's rest handling.
    BytesReference content();
     * @return a safe unpooled http request
     * Release any resources associated with this request. Implementations should be idempotent. The behavior of {@link #content()}  
    HttpVersion protocolVersion();
    /**  
/**
    default List<String> allHeaders(String name) {
     * Which HTTP version being used  
 */
 * specific language governing permissions and limitations
    enum HttpVersion {
    String uri();
        if (values != null) {  
import java.util.Collections;
}
 *  
    @PublicApi(since = "1.0.0")
        return null;
@PublicApi(since = "1.0.0")
        HTTP_3_0  
 * Unless required by applicable law or agreed to in writing,
 *
