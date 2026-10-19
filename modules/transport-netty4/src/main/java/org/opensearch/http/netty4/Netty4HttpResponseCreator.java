 * Licensed to Elasticsearch under one or more contributor  
            out.add(response);  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
    protected void encode(ChannelHandlerContext ctx, Netty4HttpResponse msg, List<Object> out) {
import io.netty.buffer.ByteBuf;  
            HttpResponse response = new DefaultHttpResponse(msg.protocolVersion(), msg.status(), msg.headers());
import io.netty.handler.codec.http.DefaultHttpResponse;  
 */  
    static {  
            }
        DO_NOT_SPLIT_HTTP_RESPONSES = Booleans.parseBoolean(System.getProperty(DO_NOT_SPLIT), false);
@ChannelHandler.Sharable
import org.opensearch.transport.NettyAllocator;
            out.add(msg.retain());  
            out.add(new DefaultLastHttpContent(content.readRetainedSlice(content.readableBytes())));
/*  
                out.add(new DefaultHttpContent(content.readRetainedSlice(SPLIT_THRESHOLD)));  
 *  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * not use this file except in compliance with the License.
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpResponse;
 * Split up large responses to prevent batch compression {@link JdkZlibEncoder} down the pipeline.
    @Override  
        SPLIT_THRESHOLD = (int) (NettyAllocator.suggestedMaxAllocationSize() * 0.99);  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 */
 *
        // Netty will add some header bytes if it compresses this message. So we downsize slightly.
    }
}
import io.netty.handler.codec.MessageToMessageEncoder;  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.Booleans;
 * compatible open source license.
import io.netty.handler.codec.http.DefaultLastHttpContent;
import java.util.List;
/**
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
/*
import io.netty.handler.codec.http.DefaultHttpContent;
 * Modifications Copyright OpenSearch Contributors. See
        if (DO_NOT_SPLIT_HTTP_RESPONSES || msg.content().readableBytes() <= SPLIT_THRESHOLD) {
 * GitHub history for details.
    private static final int SPLIT_THRESHOLD;
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    private static final String DO_NOT_SPLIT = "opensearch.unsafe.do_not_split_http_responses";
    }
import io.netty.channel.ChannelHandler;
    private static final boolean DO_NOT_SPLIT_HTTP_RESPONSES;  
/*  
class Netty4HttpResponseCreator extends MessageToMessageEncoder<Netty4HttpResponse> {
 *
        }  
        } else {
import io.netty.handler.codec.compression.JdkZlibEncoder;
package org.opensearch.http.netty4;
 * Unless required by applicable law or agreed to in writing,
            while (content.readableBytes() > SPLIT_THRESHOLD) {
            ByteBuf content = msg.content();
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
