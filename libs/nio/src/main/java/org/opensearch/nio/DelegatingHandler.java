    public DelegatingHandler(NioChannelHandler delegate) {  
/*
 * You may obtain a copy of the License at  
        return delegate.closeNow();
/*  
import java.io.IOException;
    }  
    public List<FlushOperation> pollFlushOperations() {
 * Unless required by applicable law or agreed to in writing,
 */  
 * The OpenSearch Contributors require contributions made to  
    public void channelActive() {
    }
 *
 * license agreements. See the NOTICE file distributed with
import java.util.List;
        delegate.close();  
import java.util.function.BiConsumer;  
        this.delegate = delegate;
    }
 *  
}
 * not use this file except in compliance with the License.
    public boolean closeNow() {  
    private NioChannelHandler delegate;
    @Override
 */  
 *
        return delegate.createWriteOperation(context, message, listener);
    @Override  
    }
    }
 */
    @Override
 * specific language governing permissions and limitations
public abstract class DelegatingHandler implements NioChannelHandler {
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
    public WriteOperation createWriteOperation(SocketChannelContext context, Object message, BiConsumer<Void, Exception> listener) {
    public void close() throws IOException {
    public int consumeReads(InboundChannelBuffer channelBuffer) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    @Override
        return delegate.writeToBytes(writeOperation);
    public List<FlushOperation> writeToBytes(WriteOperation writeOperation) {  
package org.opensearch.nio;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
    }
    }  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
        return delegate.consumeReads(channelBuffer);
    @Override
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
        return delegate.pollFlushOperations();  
    }
 * software distributed under the License is distributed on an
    @Override  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * this work for additional information regarding copyright
        this.delegate.channelActive();  
