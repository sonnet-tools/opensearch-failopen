 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
    public FlushReadyWrite(SocketChannelContext channelContext, ByteBuffer[] buffers, BiConsumer<Void, Exception> listener) {  
    private final SocketChannelContext channelContext;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *
import java.util.function.BiConsumer;
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
    }
/*
 */  
 * Modifications Copyright OpenSearch Contributors. See
    }
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.nio;
/*  
    }  
        super(buffers, listener);
 * specific language governing permissions and limitations
        return buffers;
 * The OpenSearch Contributors require contributions made to  
    private final ByteBuffer[] buffers;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    public ByteBuffer[] getObject() {  
    public SocketChannelContext getChannel() {
 * license agreements. See the NOTICE file distributed with
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
    @Override  
        return channelContext;
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
public class FlushReadyWrite extends FlushOperation implements WriteOperation {
 * software distributed under the License is distributed on an
        this.channelContext = channelContext;
 * GitHub history for details.
 * this work for additional information regarding copyright
        this.buffers = buffers;  
}  
    @Override
/*  
 * under the License.  
 * not use this file except in compliance with the License.
import java.nio.ByteBuffer;
