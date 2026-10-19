/*  
 * You may obtain a copy of the License at  
        super("http read timeout after " + readTimeoutMillis + "ms", cause);
 *
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 */
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 */
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
/**  
 *
 * SPDX-License-Identifier: Apache-2.0
 * Timeout Exception for HTTP read operations
    public HttpReadTimeoutException(long readTimeoutMillis) {
    }
/*
 * this work for additional information regarding copyright
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
public class HttpReadTimeoutException extends RuntimeException {
 * The OpenSearch Contributors require contributions made to  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    public HttpReadTimeoutException(long readTimeoutMillis, Exception cause) {  
        super("http read timeout after " + readTimeoutMillis + "ms");
 */  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See  
 * compatible open source license.
 */
 * KIND, either express or implied.  See the License for the
    }
 *
 * @opensearch.internal  
 * software distributed under the License is distributed on an
package org.opensearch.http;
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
