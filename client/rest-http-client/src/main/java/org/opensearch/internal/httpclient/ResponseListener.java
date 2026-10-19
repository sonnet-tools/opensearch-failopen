 * <p>  
 *
 *  
     * Method invoked if the request yielded a successful response.
     * @param exception the failure exception  
 * license agreements. See the NOTICE file distributed with
 * Note that it is <strong>not</strong> safe to call {@link RestHttpClient#close()} from either of these
     *
 * Modifications Copyright OpenSearch Contributors. See
 *
    /**
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
/*  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
    void onSuccess(Response response);
 *
 * You may obtain a copy of the License at  
 */  
     * @param response success response  
/**
 */  
 * Unless required by applicable law or agreed to in writing,
 * the listener whenever the request yielded a response, or failed with an exception.
 * callbacks.
     * Method invoked if the request failed. There are two main categories of failures: connection failures (usually
}  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
/*  
 * this file be licensed under the Apache-2.0 license or a
/*
     */
 * Licensed to Elasticsearch under one or more contributor  
    void onFailure(Exception exception);
 * under the License.  
 * Listener to be provided when calling async performRequest methods provided by {@link RestHttpClient}.
     * {@link java.io.IOException}s, or responses that were treated as errors based on their error response code  
     *
 */
package org.opensearch.internal.httpclient;
     */
 * SPDX-License-Identifier: Apache-2.0
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Those methods that do accept a listener will return immediately, execute asynchronously, and notify  
 * The OpenSearch Contributors require contributions made to  
 */  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
public interface ResponseListener {
     * ({@link ResponseException}s).
