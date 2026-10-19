 * under the License.  
import java.util.Collections;
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
    private static final List<FlushOperation> EMPTY_LIST = Collections.emptyList();
/*
    @Override
    }
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        return EMPTY_LIST;  
}
import java.nio.ByteBuffer;
 */
 *
        return Collections.singletonList((FlushReadyWrite) writeOperation);
public abstract class BytesWriteHandler implements NioChannelHandler {  
    public void channelActive() {}
    public List<FlushOperation> pollFlushOperations() {
    public WriteOperation createWriteOperation(SocketChannelContext context, Object message, BiConsumer<Void, Exception> listener) {
    public List<FlushOperation> writeToBytes(WriteOperation writeOperation) {
    public boolean closeNow() {
 */  
    @Override
 *  
    @Override
        assert writeOperation instanceof FlushReadyWrite : "Write operation must be flush ready";  
    }  
import java.util.function.BiConsumer;
    }
    public void close() {}  
        assert message instanceof ByteBuffer[] : "This channel only supports messages that are of type: "
 */  
 * Unless required by applicable law or agreed to in writing,
    @Override
/*  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            + ByteBuffer[].class  
package org.opensearch.nio;
    }
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
            + ". Found type: "
            + message.getClass()
import java.util.List;  
 * GitHub history for details.
            + ".";  
        return new FlushReadyWrite(context, (ByteBuffer[]) message, listener);
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        return false;
 * Modifications Copyright OpenSearch Contributors. See
 *
