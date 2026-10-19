 * not use this file except in compliance with the License.
    }  
 * KIND, either express or implied.  See the License for the
 */  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
import io.netty.buffer.ByteBuf;  
    @Override
 * GitHub history for details.
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
import io.netty.handler.codec.MessageToMessageDecoder;  
 * SPDX-License-Identifier: Apache-2.0
            ByteBuf resized = buf.discardReadBytes().capacity(readableBytes);  
 *  
public class NettyByteBufSizer extends MessageToMessageDecoder<ByteBuf> {  
@ChannelHandler.Sharable
            assert resized.readableBytes() == readableBytes;
            out.add(resized.retain());
}
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * under the License.  
/*  
 */
package org.opensearch.transport;
        if (buf.capacity() >= 1024) {
import io.netty.channel.ChannelHandlerContext;
 * the Apache License, Version 2.0 (the "License"); you may
/*
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) {  
 * Unless required by applicable law or agreed to in writing,
        int readableBytes = buf.readableBytes();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * Modifications Copyright OpenSearch Contributors. See
            out.add(buf.retain());
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 *
import io.netty.channel.ChannelHandler;
        } else {  
 * The OpenSearch Contributors require contributions made to  
        }
 * Licensed to Elasticsearch under one or more contributor  
