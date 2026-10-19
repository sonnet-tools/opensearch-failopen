 *
import org.opensearch.ExceptionsHelper;
        }
 * The OpenSearch Contributors require contributions made to  
    Netty4HttpRequestCreator(HttpResponseHeadersFactory responseHeadersFactory) {
    }  
/*  
import io.netty.handler.codec.http.FullHttpRequest;
 * KIND, either express or implied.  See the License for the
            out.add(new Netty4HttpRequest(msg.retain(), responseHeadersFactory));
                nonError = (Exception) cause;  
import io.netty.channel.ChannelHandlerContext;  
 * software distributed under the License is distributed on an
 */  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
            if (cause instanceof Error) {
            }
            final Exception nonError;
import java.util.List;  
import io.netty.channel.ChannelHandler;
 * this file be licensed under the Apache-2.0 license or a
class Netty4HttpRequestCreator extends MessageToMessageDecoder<FullHttpRequest> {
    @Override  
 * Unless required by applicable law or agreed to in writing,
import io.netty.handler.codec.MessageToMessageDecoder;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 */
 *  
            } else {
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
                nonError = new Exception(cause);
 * not use this file except in compliance with the License.
        } else {  
                ExceptionsHelper.maybeDieOnAnotherThread(cause);  
            final Throwable cause = msg.decoderResult().cause();  
 * license agreements. See the NOTICE file distributed with
    protected void decode(ChannelHandlerContext ctx, FullHttpRequest msg, List<Object> out) {
package org.opensearch.http.netty4;
 * You may obtain a copy of the License at  
/*
        this.responseHeadersFactory = responseHeadersFactory;  
 *
 * under the License.  
            out.add(new Netty4HttpRequest(msg.retain(), nonError, responseHeadersFactory));
}
/*  
 * Modifications Copyright OpenSearch Contributors. See
        if (msg.decoderResult().isFailure()) {
 * the Apache License, Version 2.0 (the "License"); you may
    private final HttpResponseHeadersFactory responseHeadersFactory;  
@ChannelHandler.Sharable
 * specific language governing permissions and limitations
