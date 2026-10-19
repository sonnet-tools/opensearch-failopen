    @Override
 * not use this file except in compliance with the License.
import io.netty.channel.socket.nio.NioSocketChannel;
    }
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    public SocketChannel javaChannel() {
 * ownership. Elasticsearch licenses this file to you under  
 */
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
/*
 */  
/*  
 *  
}  
 */  
 * compatible open source license.
 *
    public Netty4NioSocketChannel() {
public class Netty4NioSocketChannel extends NioSocketChannel {  
 */
import io.netty.channel.Channel;  
    }
        super();  
    public Netty4NioSocketChannel(Channel parent, SocketChannel socket) {  
package org.opensearch.transport;
        super(parent, socket);
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
    }
        return super.javaChannel();  
 * Helper class to expose {@link #javaChannel()} method
 *
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.nio.channels.SocketChannel;
/*  
/**  
 * the Apache License, Version 2.0 (the "License"); you may
