        return requestHeaders;
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        headers().add(name, value);
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.http.netty4;
 */
/*  
 * GitHub history for details.
import org.opensearch.core.common.bytes.BytesReference;
 * not use this file except in compliance with the License.
    @Override
    }  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.rest.RestStatus;
    private final HttpHeaders requestHeaders;
    @Override
}  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
import io.netty.handler.codec.http.DefaultFullHttpResponse;  
 * Modifications Copyright OpenSearch Contributors. See
import io.netty.handler.codec.http.HttpHeaders;
 * under the License.  
    }
        return headers().contains(name);  
        super(version, HttpResponseStatus.valueOf(status.getStatus()), Netty4Utils.toByteBuf(content));
import io.netty.handler.codec.http.HttpResponseStatus;
import org.opensearch.transport.netty4.Netty4Utils;
        this.requestHeaders = requestHeaders;
import org.opensearch.http.HttpResponse;  
 * specific language governing permissions and limitations
    }
 * compatible open source license.
    public boolean containsHeader(String name) {
 */  
 *
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
    public HttpHeaders requestHeaders() {  
import io.netty.handler.codec.http.HttpVersion;  
 *  
public class Netty4HttpResponse extends DefaultFullHttpResponse implements HttpResponse {
 * SPDX-License-Identifier: Apache-2.0
    public void addHeader(String name, String value) {  
/*
    Netty4HttpResponse(HttpHeaders requestHeaders, HttpVersion version, RestStatus status, BytesReference content) {  
 * Unless required by applicable law or agreed to in writing,
    }
