        return 0;  
 *
 *  
 * with the License. You may obtain a copy of the License at:
            }  
 * Unless required by applicable law or agreed to in writing, software
 */
 * compatible open source license.
 * This class is adapted from {@link NioServerSocketChannel} class in the Netty project. It overrides the
 * this work for additional information regarding copyright
 * under the License.  
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT  
            }
 * Unless required by applicable law or agreed to in writing,
        }
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The Netty Project licenses this file to you under the Apache License,
/**  
public class CopyBytesServerSocketChannel extends NioServerSocketChannel {
import java.util.List;
        } catch (Throwable t) {
 * not use this file except in compliance with the License.
    private static final Logger logger = LogManager.getLogger(CopyBytesServerSocketChannel.class);  
 *
/*
            } catch (Throwable t2) {
 */
 *
package org.opensearch.transport;
 * license agreements. See the NOTICE file distributed with
 * Copyright 2012 The Netty Project  
 * You may obtain a copy of the License at  
 */  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
import io.netty.util.internal.SocketUtils;
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
import io.netty.channel.socket.nio.NioServerSocketChannel;  
                logger.warn("Failed to close a socket.", t2);
import java.nio.channels.SocketChannel;  
        SocketChannel ch = SocketUtils.accept(javaChannel());
 *    http://www.apache.org/licenses/LICENSE-2.0
 * channel read messages behavior to ensure that a {@link CopyBytesSocketChannel} socket channel is created.
                ch.close();  
 *
            logger.warn("Failed to create a new channel from an accepted socket.", t);  
 * version 2.0 (the "License"); you may not use this file except in compliance  
 * GitHub history for details.
 *
 * SPDX-License-Identifier: Apache-2.0
                return 1;  
 * License for the specific language governing permissions and limitations
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
        try {  
 * Modifications Copyright OpenSearch Contributors. See  
            try {
 *   http://www.apache.org/licenses/LICENSE-2.0  
    }
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
}
    @Override
import org.apache.logging.log4j.Logger;
 * the Apache License, Version 2.0 (the "License"); you may
            if (ch != null) {
/*
import org.apache.logging.log4j.LogManager;  
 */
 * software distributed under the License is distributed on an
/*  
/*
    protected int doReadMessages(List<Object> buf) throws Exception {  
                buf.add(new CopyBytesSocketChannel(this, ch));
