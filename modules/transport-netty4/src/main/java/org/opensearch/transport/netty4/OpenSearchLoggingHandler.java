 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 *
 * software distributed under the License is distributed on an
        super(LogLevel.TRACE);
 */  
 */  
        // We do not want to log read complete events because we log inbound messages in the TcpTransport.
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {  
    OpenSearchLoggingHandler() {
import io.netty.channel.ChannelHandlerContext;
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
/*  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import io.netty.handler.logging.LoggingHandler;  
}
 * SPDX-License-Identifier: Apache-2.0
    }  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
import io.netty.handler.logging.LogLevel;
 * GitHub history for details.
 *  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
        ctx.fireChannelReadComplete();
package org.opensearch.transport.netty4;
 */
final class OpenSearchLoggingHandler extends LoggingHandler {
    }  
 * Unless required by applicable law or agreed to in writing,
 *
 * not use this file except in compliance with the License.
