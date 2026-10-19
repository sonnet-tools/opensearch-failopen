        if (AbstractBytesReferenceTestCase.getNumPages(ref) > 1) { // we gather the buffers into a channel buffer  
import org.opensearch.test.OpenSearchTestCase;
            BytesReference.toBytes(ref.slice(sliceOffset, sliceLength)),  
        ByteBuf buffer = Netty4Utils.toByteBuf(ref);
        assertSame(Unpooled.EMPTY_BUFFER, buffer);
            out.writeByte((byte) random().nextInt(1 << 8));
        }
        );
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;  
 *
        int sliceOffset = randomIntBetween(0, ref.length());  
        BytesReference bytesReference = Netty4Utils.toBytesReference(buffer);
 * KIND, either express or implied.  See the License for the
            BytesReference.toBytes(bytesReference.slice(sliceOffset, sliceLength))
    public void testToChannelBufferWithEmptyRef() throws IOException {
 * Unless required by applicable law or agreed to in writing,
    public void testToChannelBuffer() throws IOException {
    }
import java.io.IOException;  
        assertArrayEquals(BytesReference.toBytes(ref), BytesReference.toBytes(bytesReference));  
        ByteBuf buffer = Netty4Utils.toByteBuf(ref);  
/*  
        assertEquals(out.size(), length);  
 * The OpenSearch Contributors require contributions made to  
        if (randomBoolean()) {  
 * specific language governing permissions and limitations
        assertArrayEquals(
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(buffer instanceof CompositeByteBuf);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    private final BigArrays bigarrays = new BigArrays(null, new NoneCircuitBreakerService(), CircuitBreaker.REQUEST);  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
            return new BytesArray(ref.toBytesRef());
        BytesReference slice = ref.slice(sliceOffset, sliceLength);
        for (int i = 0; i < length; i++) {  
import org.opensearch.core.common.bytes.BytesArray;
    }
    public void testToChannelBufferWithSlice() throws IOException {
        BytesReference ref = getRandomizedBytesReference(randomIntBetween(1, 3 * PAGE_SIZE));
/*
import io.netty.buffer.Unpooled;
import org.opensearch.common.util.BigArrays;
import org.opensearch.common.bytes.AbstractBytesReferenceTestCase;
    }  
        }
package org.opensearch.transport.netty4;
        assertArrayEquals(BytesReference.toBytes(slice), BytesReference.toBytes(bytesReference));
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.util.BytesRef;
            BytesRef bytesRef = ref.toBytesRef();  
}
 * not use this file except in compliance with the License.
import org.opensearch.common.util.PageCacheRecycler;
    private BytesReference getRandomizedBytesReference(int length) throws IOException {  
public class Netty4UtilsTests extends OpenSearchTestCase {  
import io.netty.buffer.ByteBuf;
    private static final int PAGE_SIZE = PageCacheRecycler.BYTE_PAGE_SIZE;
        BytesReference bytesReference = Netty4Utils.toBytesReference(buffer);
 */  
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
            return ref;  
import io.netty.buffer.CompositeByteBuf;  
 * software distributed under the License is distributed on an
        ByteBuf buffer = Netty4Utils.toByteBuf(slice);  
        BytesReference ref = getRandomizedBytesReference(randomIntBetween(1, 3 * PAGE_SIZE));  
        ReleasableBytesStreamOutput out = new ReleasableBytesStreamOutput(length, bigarrays);
 * GitHub history for details.
    }  
        ByteBuf buffer = Netty4Utils.toByteBuf(getRandomizedBytesReference(0));  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
        } else {
/*  
 * this work for additional information regarding copyright
import org.opensearch.core.common.breaker.CircuitBreaker;  
 * compatible open source license.
        int sliceLength = randomIntBetween(ref.length() - sliceOffset, ref.length() - sliceOffset);
            return Netty4Utils.toBytesReference(Unpooled.wrappedBuffer(bytesRef.bytes, bytesRef.offset, bytesRef.length));
 * this file be licensed under the Apache-2.0 license or a
        BytesReference ref = out.bytes();
        BytesReference ref = getRandomizedBytesReference(randomIntBetween(1, 3 * PAGE_SIZE));  
        int sliceOffset = randomIntBetween(0, ref.length());
        int sliceLength = randomIntBetween(ref.length() - sliceOffset, ref.length() - sliceOffset);
 */  
        // we know bytes stream output always creates a paged bytes reference, we use it to create randomized content
 *
 */
 *  
        BytesReference bytesReference = Netty4Utils.toBytesReference(buffer);
        assertEquals(ref.length(), length);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.bytes.BytesReference;
    public void testToChannelBufferWithSliceAfter() throws IOException {
        } else if (randomBoolean()) {
