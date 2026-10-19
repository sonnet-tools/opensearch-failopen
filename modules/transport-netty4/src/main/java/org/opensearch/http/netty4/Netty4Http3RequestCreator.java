 */
                );
/*  
    @Override
            }
 * The OpenSearch Contributors require contributions made to  
            if (msg.uri().length() > maxInitialLineLength.bytesAsInt()) {
                out.add(
                    )
 * GitHub history for details.
    private final ByteSizeValue maxInitialLineLength;
 * SPDX-License-Identifier: Apache-2.0
    }
        } else {
        this.maxInitialLineLength = maxInitialLineLength;  
    }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.ExceptionsHelper;
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        }  
@ChannelHandler.Sharable  
 * this work for additional information regarding copyright
import io.netty.channel.ChannelHandlerContext;
/*
                out.add(new Netty4HttpRequest(msg.retain(), responseHeadersFactory));
 *    http://www.apache.org/licenses/LICENSE-2.0
import io.netty.channel.ChannelHandler;  
import org.opensearch.core.common.unit.ByteSizeValue;
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
            out.add(new Netty4HttpRequest(msg.retain(), nonError, responseHeadersFactory));  
 *
 */  
            // applying the validation rules here.  
 * Licensed to Elasticsearch under one or more contributor  
 *
 * under the License.  
            final Throwable cause = msg.decoderResult().cause();
class Netty4Http3RequestCreator extends MessageToMessageDecoder<FullHttpRequest> {
import io.netty.handler.codec.http.FullHttpRequest;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                ExceptionsHelper.maybeDieOnAnotherThread(cause);
            if (cause instanceof Error) {  
            final Exception nonError;
            } else {  
 * not use this file except in compliance with the License.
            // The HTTP/3 implementation in Netty does not validate Request URI length, manually
        if (msg.decoderResult().isFailure()) {  
 * specific language governing permissions and limitations
            } else {  
        this.responseHeadersFactory = responseHeadersFactory;
import java.util.List;
                    new Netty4HttpRequest(  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    protected void decode(ChannelHandlerContext ctx, FullHttpRequest msg, List<Object> out) {
            }
    Netty4Http3RequestCreator(ByteSizeValue maxInitialLineLength, HttpResponseHeadersFactory responseHeadersFactory) {
import io.netty.handler.codec.http.TooLongHttpLineException;
package org.opensearch.http.netty4;
 */  
 * this file be licensed under the Apache-2.0 license or a
                        new TooLongHttpLineException("An HTTP line is larger than " + maxInitialLineLength.bytesAsInt() + " bytes."),
 * Modifications Copyright OpenSearch Contributors. See
    private final HttpResponseHeadersFactory responseHeadersFactory;  
                        msg.retain(),
 * compatible open source license.
 *  
import io.netty.handler.codec.MessageToMessageDecoder;
                        responseHeadersFactory  
/*  
}
                nonError = new Exception(cause);
                nonError = (Exception) cause;
