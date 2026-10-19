    public void incrementIndex(int delta) {
    private final int[] offsets;
    }  
            + length
            + ", post-increment index="  
        return postIndexBuffers;
 * under the License.  
    private final int length;  
            ByteBuffer buffer = buffers[i];  
 * KIND, either express or implied.  See the License for the
        int excessBytes = Math.max(0, nBytes - maxBytes);
    public BiConsumer<Void, Exception> getListener() {
        int nBytes = firstBuffer.remaining();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
package org.opensearch.nio;
            postIndexBuffers[j++] = buffer;
    public ByteBuffer[] getBuffersToWrite() {
        firstBuffer.position(firstBufferPosition);  
    private int internalIndex;
        lastBuffer.limit(lastBuffer.limit() - excessBytes);  
 * this work for additional information regarding copyright
    }
        final int index = Arrays.binarySearch(offsets, internalIndex);  
        for (int i = (offsetIndex + 1); i < finalOffset; ++i) {
public class FlushOperation {
        this.listener = listener;
        }  
        return getBuffersToWrite(length);
        for (int i = 0; i < buffers.length; i++) {
 * compatible open source license.
 *  
        if (nBuffers == 1 && firstBuffer.remaining() == 0) {
        return internalIndex == length;
            offset += buffer.remaining();
        assert length >= internalIndex : "Should never increment index past length [length="
 * license agreements. See the NOTICE file distributed with
        int j = 1;  
 * this file be licensed under the Apache-2.0 license or a
        int firstBufferPosition = internalIndex - offsets[offsetIndex];
        final int offsetIndex = index < 0 ? (-(index + 1)) - 1 : index;
 * software distributed under the License is distributed on an
        }  
import java.util.function.BiConsumer;  
 * Licensed to Elasticsearch under one or more contributor  
            + ", index="
    public boolean isFullyFlushed() {
 *
        int nBuffers = (finalOffsetIndex - offsetIndex) + 1;
    }  
            nBytes += buffer.remaining();  
 */  
 * GitHub history for details.
        postIndexBuffers[0] = firstBuffer;  
        internalIndex += delta;  
        length = offset;
/*  
    }
    private static final ByteBuffer[] EMPTY_ARRAY = new ByteBuffer[0];
            return EMPTY_ARRAY;
            + internalIndex
/*  
 *
    public FlushOperation(ByteBuffer[] buffers, BiConsumer<Void, Exception> listener) {  
            + ", delta="
        int offset = 0;
    }  
        ByteBuffer[] postIndexBuffers = new ByteBuffer[nBuffers];
 * specific language governing permissions and limitations
            offsets[i] = offset;
import java.util.Arrays;
            + "]";
        this.buffers = buffers;
            + internalIndex  
        final int finalOffsetIndex = finalIndex < 0 ? (-(finalIndex + 1)) - 1 : finalIndex;  
 * The OpenSearch Contributors require contributions made to  
import java.nio.ByteBuffer;
    }
        }
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ByteBuffer firstBuffer = buffers[offsetIndex].duplicate();
        int finalOffset = offsetIndex + nBuffers;
            + "]";
        assert length >= internalIndex : "Should never have an index that is greater than the length [length="  
 * not use this file except in compliance with the License.
        return listener;
 * You may obtain a copy of the License at  
        ByteBuffer lastBuffer = postIndexBuffers[postIndexBuffers.length - 1];
        final int finalIndex = Arrays.binarySearch(offsets, Math.min(internalIndex + maxBytes, length));
 * Unless required by applicable law or agreed to in writing,
            + length
        this.offsets = new int[buffers.length];  
    public ByteBuffer[] getBuffersToWrite(int maxBytes) {
 * Modifications Copyright OpenSearch Contributors. See
            ByteBuffer buffer = buffers[i].duplicate();
 */
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    private final ByteBuffer[] buffers;
}  
            + delta  
    private final BiConsumer<Void, Exception> listener;  
