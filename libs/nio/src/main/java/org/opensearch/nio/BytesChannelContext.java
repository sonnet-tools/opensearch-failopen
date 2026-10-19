 *
 * this work for additional information regarding copyright
            try {  
 * SPDX-License-Identifier: Apache-2.0
 *
            return 0;
/*  
 * GitHub history for details.
}
import java.io.IOException;
        super(channel, selector, socketConfig, exceptionHandler, handler, channelBuffer);
                    currentFlushOperationComplete();
                }
    public void closeChannel() {
    }
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * You may obtain a copy of the License at  
    }
            getSelector().queueChannelClose(channel);
                } else {  
 * Unless required by applicable law or agreed to in writing,
                if (singleFlush(flushOperation)) {
        handleReadBytes();
        return flushOperation.isFullyFlushed();  
 * this file be licensed under the Apache-2.0 license or a
    public BytesChannelContext(  
    private boolean singleFlush(FlushOperation flushOperation) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
        int bytesRead = readFromChannel(channelBuffer);
        Config.Socket socketConfig,  
/*
    public boolean selectorShouldClose() {  
 * license agreements. See the NOTICE file distributed with
        }
        flushToChannel(flushOperation);
public class BytesChannelContext extends SocketChannelContext {
        getSelector().assertOnSelectorThread();
        return bytesRead;  
    }
                throw e;
    @Override
            }  
 */  
 * Modifications Copyright OpenSearch Contributors. See
    }  
        FlushOperation flushOperation;
    /**
        boolean lastOpCompleted = true;  
        }
     */  
    }
 * under the License.  
        Consumer<Exception> exceptionHandler,
 */
        return closeNow() || isClosing.get();
 * specific language governing permissions and limitations
            } catch (IOException e) {  
 */  
        NioSocketChannel channel,
    @Override
    ) {
        if (isClosing.compareAndSet(false, true)) {  
    @Override  
        }
        NioChannelHandler handler,
 * not use this file except in compliance with the License.
 * compatible open source license.
import java.util.function.Consumer;
package org.opensearch.nio;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Returns a boolean indicating if the operation was fully flushed.
 * KIND, either express or implied.  See the License for the
/*  
                    lastOpCompleted = false;
 * The OpenSearch Contributors require contributions made to  
        while (lastOpCompleted && (flushOperation = getPendingFlush()) != null) {
    public void flushChannel() throws IOException {
    public int read() throws IOException {  
 *  
                currentFlushOperationFailed(e);
        InboundChannelBuffer channelBuffer  
    @Override
        NioSelector selector,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        if (bytesRead == 0) {  
 * software distributed under the License is distributed on an
