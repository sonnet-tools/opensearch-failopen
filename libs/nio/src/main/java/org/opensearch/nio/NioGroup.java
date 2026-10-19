 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
}
 * channels and registering them with the OS.
 * software distributed under the License is distributed on an
 *
 *  
import java.net.InetSocketAddress;  
 * specific language governing permissions and limitations
package org.opensearch.nio;
 *
import java.io.IOException;
     * Opens and binds a server channel to accept incoming connections.  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 */
    <S extends NioServerSocketChannel> S bindServerChannel(InetSocketAddress address, ChannelFactory<S, ?> factory) throws IOException;
     */
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
     * Opens a outgoing client channel.
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * Unless required by applicable law or agreed to in writing,
public interface NioGroup extends Closeable {  
/*  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 * The OpenSearch Contributors require contributions made to  
    void close() throws IOException;
 * KIND, either express or implied.  See the License for the
/**
    /**
 * compatible open source license.
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * An class for interfacing with java.nio. Implementations implement the underlying logic for opening  
     */  
 * You may obtain a copy of the License at  
    /**
/*  
 * ownership. Elasticsearch licenses this file to you under  
import java.io.Closeable;
    <S extends NioSocketChannel> S openChannel(InetSocketAddress address, ChannelFactory<?, S> factory) throws IOException;
