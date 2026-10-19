     * @param context the channel context
     * that can be flushed to the raw nio channel.
    /**  
 * Unless required by applicable law or agreed to in writing,
/*
     *  
    void close() throws IOException;
    /**
     * This method is called when the channel is active for use.
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
     *
 * under the License.  
/**
 *  
     * @param writeOperation to be converted to bytes
     * @param message the message  
 * this file be licensed under the Apache-2.0 license or a
    /**  
     * operations were produced during a read call.
 * license agreements. See the NOTICE file distributed with
    int consumeReads(InboundChannelBuffer channelBuffer) throws IOException;
     * @return if the channel should be closed  
 * Implements the application specific logic for handling channel operations.  
package org.opensearch.nio;
 * software distributed under the License is distributed on an
 */
 */  
     *
     * Returns any flush operations that are ready to flush. This exists as a way to check if any flush
 *
     * @throws IOException if an exception occurs
     * @param channelBuffer of bytes read from the network  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * This method is called on the event loop thread. It should serialize a write operation object to bytes
     * This method handles bytes that have been read from the network. It should return the number of bytes  
import java.util.List;
     * This method indicates if the underlying channel should be closed.
public interface NioChannelHandler {
 * compatible open source license.
 * specific language governing permissions and limitations
 */  
    /**  
 * KIND, either express or implied.  See the License for the
    WriteOperation createWriteOperation(SocketChannelContext context, Object message, BiConsumer<Void, Exception> listener);
/*  
     *
 * You may obtain a copy of the License at  
     * This method should validate that the message is a valid type and return a write operation object
     */  
 * The OpenSearch Contributors require contributions made to  
}
     */  
     */
     */
 *
 * ownership. Elasticsearch licenses this file to you under  
     * @return the write operation to be queued
     * consumed so that they can be released.
     * to be queued with the channel  
     */  
     * @param listener the listener to be called when the message is sent
    /**
import java.io.IOException;
     */  
     *  
    List<FlushOperation> writeToBytes(WriteOperation writeOperation);
     * This method is called when a message is queued with a channel. It can be called from any thread.
 * this work for additional information regarding copyright
    /**  
/*  
    List<FlushOperation> pollFlushOperations();  
     * @return flush operations
 * Licensed to Elasticsearch under one or more contributor  
     * @return the operations to flush the bytes to the channel
     * @return the number of bytes consumed
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.function.BiConsumer;  
    void channelActive();
 * not use this file except in compliance with the License.
 */
    boolean closeNow();
