 */
 * SPDX-License-Identifier: Apache-2.0
        } catch (Exception e) {  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * KIND, either express or implied.  See the License for the
            final boolean http10 = httpRequest.protocolVersion() == HttpRequest.HttpVersion.HTTP_1_0;  
            // In case we fail to parse the http protocol version out of the request we always close the connection
 */  
 * software distributed under the License is distributed on an
    static final String CONNECTION = "connection";  
 * compatible open source license.
package org.opensearch.http;
 */  
 * under the License.  
 */
 *
 * this file be licensed under the Apache-2.0 license or a
    // Determine if the request connection should be closed on completion.  
/*  
    public static boolean shouldCloseConnection(HttpRequest httpRequest) {
    }
}
    static final String CLOSE = "close";
 *  
 * You may obtain a copy of the License at  
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
public class HttpUtils {  
            return CLOSE.equalsIgnoreCase(httpRequest.header(CONNECTION))
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal
/*
        }  
 * license agreements. See the NOTICE file distributed with
            return true;
                || (http10 && !KEEP_ALIVE.equalsIgnoreCase(httpRequest.header(CONNECTION)));
        try {
 * Utility class for HTTP connections
 * GitHub history for details.
    static final String KEEP_ALIVE = "keep-alive";
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
