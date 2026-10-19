 * Note that it is <strong>not</strong> safe to call {@link RestClient#close()} from either of these
 * this file be licensed under the Apache-2.0 license or a
}  
     *
 * KIND, either express or implied.  See the License for the
     * @param response success response  
     * @param exception the failure exception  
public interface ResponseListener {
 * GitHub history for details.
 * You may obtain a copy of the License at  
 *
     *
/*  
 * license agreements. See the NOTICE file distributed with
    void onSuccess(Response response);
 *
 * software distributed under the License is distributed on an
 *  
 * not use this file except in compliance with the License.
 *
 * under the License.  
/**
 * Those methods that do accept a listener will return immediately, execute asynchronously, and notify  
/*
 */
     */
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * callbacks.
package org.opensearch.client;
    void onFailure(Exception exception);
 * this work for additional information regarding copyright
     * Method invoked if the request failed. There are two main categories of failures: connection failures (usually
 */  
     */
 * Unless required by applicable law or agreed to in writing,
    /**
 * specific language governing permissions and limitations
     * ({@link ResponseException}s).
     * {@link java.io.IOException}s, or responses that were treated as errors based on their error response code  
/*  
 * <p>  
 * the Apache License, Version 2.0 (the "License"); you may
 * the listener whenever the request yielded a response, or failed with an exception.
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
     * Method invoked if the request yielded a successful response.
 * The OpenSearch Contributors require contributions made to  
 */  
 * Listener to be provided when calling async performRequest methods provided by {@link RestClient}.
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
