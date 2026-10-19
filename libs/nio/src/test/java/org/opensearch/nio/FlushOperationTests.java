 * software distributed under the License is distributed on an
        writeOp.incrementIndex(5);  
        assertEquals(1, byteBuffersWithLimit.length);
        assertEquals(3, byteBuffers[1].remaining());  
        assertEquals(0, byteBuffers.length);  
        byteBuffers = writeOp.getBuffersToWrite();
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(1, byteBuffersWithLimit[0].remaining());
        byteBuffersWithLimit = writeOp.getBuffersToWrite(10);
 * under the License.  
 * KIND, either express or implied.  See the License for the
        assertEquals(2, byteBuffersWithLimit.length);  
        assertEquals(15, byteBuffers[0].remaining());
        assertFalse(writeOp.isFullyFlushed());
        assertEquals(2, byteBuffers.length);
import org.junit.Before;
        assertEquals(1, byteBuffersWithLimit.length);  
/*  
        writeOp.incrementIndex(5);
 */  
    public void testFullyFlushedMarker() {
        FlushOperation writeOp = new FlushOperation(buffers, listener);
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
/*  
    public void testMultipleFlushesWithCompositeBuffer() throws IOException {
 * GitHub history for details.
 */  
}
 * compatible open source license.
 * You may obtain a copy of the License at  
import java.util.function.BiConsumer;  
 * not use this file except in compliance with the License.
        writeOp.incrementIndex(2);
    private BiConsumer<Void, Exception> listener;  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        ByteBuffer[] byteBuffersWithLimit = writeOp.getBuffersToWrite(10);
    @Before
        writeOp.incrementIndex(10);  
public class FlushOperationTests extends OpenSearchTestCase {
        listener = mock(BiConsumer.class);
import java.nio.ByteBuffer;
        assertTrue(writeOp.isFullyFlushed());
    }  
 */
/*
        ByteBuffer[] buffers = { ByteBuffer.allocate(10), ByteBuffer.allocate(15), ByteBuffer.allocate(3) };  
        assertEquals(0, byteBuffersWithLimit.length);
 *
        ByteBuffer[] buffers = { ByteBuffer.allocate(10) };  
        assertFalse(writeOp.isFullyFlushed());
import org.opensearch.test.OpenSearchTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(5, byteBuffers[0].remaining());
    public void testPartiallyFlushedMarker() {
        assertFalse(writeOp.isFullyFlushed());
 * this file be licensed under the Apache-2.0 license or a
    }  
    public void setFields() {
        ByteBuffer[] buffers = { ByteBuffer.allocate(10) };  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        byteBuffersWithLimit = writeOp.getBuffersToWrite(10);
        assertEquals(1, byteBuffersWithLimit.length);  
package org.opensearch.nio;
        assertEquals(2, byteBuffers.length);
        assertEquals(3, byteBuffers[1].remaining());
        writeOp.incrementIndex(15);  
        byteBuffersWithLimit = writeOp.getBuffersToWrite(10);
        assertFalse(writeOp.isFullyFlushed());
    }  
        assertEquals(5, byteBuffersWithLimit[0].remaining());
        FlushOperation writeOp = new FlushOperation(buffers, listener);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, byteBuffers[0].remaining());
        assertEquals(10, byteBuffersWithLimit[0].remaining());  
 * specific language governing permissions and limitations
        assertEquals(13, byteBuffers[0].remaining());  
 *  
 * The OpenSearch Contributors require contributions made to  
    }  
        assertEquals(5, byteBuffersWithLimit[1].remaining());
    @SuppressWarnings("unchecked")  
 * Licensed to Elasticsearch under one or more contributor  
        byteBuffersWithLimit = writeOp.getBuffersToWrite(10);
        byteBuffers = writeOp.getBuffersToWrite();
import static org.mockito.Mockito.mock;
        FlushOperation writeOp = new FlushOperation(buffers, listener);
        assertFalse(writeOp.isFullyFlushed());  
        assertTrue(writeOp.isFullyFlushed());
 *
        byteBuffers = writeOp.getBuffersToWrite();  
        writeOp.incrementIndex(5);  
        assertEquals(3, byteBuffers.length);  
        byteBuffers = writeOp.getBuffersToWrite();
 * this work for additional information regarding copyright
        writeOp.incrementIndex(1);  
        assertEquals(10, byteBuffersWithLimit[0].remaining());
        assertEquals(1, byteBuffers.length);  
        ByteBuffer[] byteBuffers = writeOp.getBuffersToWrite();
