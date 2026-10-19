        StreamInput streamInput = bytesRef.streamInput();  
        BytesStream bStream = new ZeroOutOnCloseStream();
        StreamInput streamInput = new InputStreamStreamInput(  
        stream.write(expectedBytes);
        byte[] actualBytes = new byte[expectedBytes.length];
        bStream.close();
        CompressibleBytesOutputStream stream = new CompressibleBytesOutputStream(bStream, true);
        for (byte b : bytesRef.toBytesRef().bytes) {
            assertEquals((byte) 0, b);
 */  
        BytesStream bStream = new ZeroOutOnCloseStream();  
            assertEquals((byte) 0, b);
        stream.close();
import org.opensearch.core.common.io.stream.StreamInput;
        EOFException e = expectThrows(EOFException.class, () -> streamInput.readBytes(actualBytes, 0, expectedBytes.length));
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.BytesStream;  
        @Override
        streamInput.readBytes(actualBytes, 0, expectedBytes.length);
            CompressorRegistry.defaultCompressor().threadLocalInputStream(bStream.bytes().streamInput())
    private static class ZeroOutOnCloseStream extends BytesStreamOutput {  
        assertFalse(CompressorRegistry.defaultCompressor().isCompressed(bytesRef));
    public void testStreamWithoutCompression() throws IOException {
        assertEquals(-1, streamInput.read());  
        stream.close();
        );
        BytesReference bytesRef = stream.materializeBytes();  
        stream.write(expectedBytes);
        // The bytes should be zeroed out on close
        byte[] actualBytes = new byte[expectedBytes.length];  
 * the Apache License, Version 2.0 (the "License"); you may
 *
        StreamInput streamInput = new InputStreamStreamInput(  
        streamInput.readBytes(actualBytes, 0, expectedBytes.length);
        BytesStream bStream = new ZeroOutOnCloseStream();  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        byte[] expectedBytes = randomBytes(randomInt(30));  
            if (bytes != null) {
        byte[] expectedBytes = randomBytes(randomInt(30));
    public void testCompressionWithCallingMaterializeFails() throws IOException {
        bStream.close();  
        }
 */
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
            bytes[i] = randomByte();
 * Unless required by applicable law or agreed to in writing,
        byte[] actualBytes = new byte[expectedBytes.length];  
        assertArrayEquals(expectedBytes, actualBytes);
 *
            }
        assertEquals("Unexpected end of ZLIB input stream", e.getMessage());
        stream.close();
    }
            CompressorRegistry.defaultCompressor().threadLocalInputStream(bytesRef.streamInput())
        for (byte b : bytesRef.toBytesRef().bytes) {  
 * You may obtain a copy of the License at  
        BytesReference bytesRef = stream.materializeBytes();
 *  
 */  
public class CompressibleBytesOutputStreamTests extends OpenSearchTestCase {  
                int size = (int) bytes.size();
        stream.write(expectedBytes);
/*  
    public void testStreamWithCompression() throws IOException {  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        assertTrue(CompressorRegistry.defaultCompressor().isCompressed(bytesRef));
        public void close() {  
        }
        byte[] bytes = new byte[length];
import java.io.IOException;
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertArrayEquals(expectedBytes, actualBytes);
 * KIND, either express or implied.  See the License for the
        }
        );
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.common.bytes.BytesReference;
 * The OpenSearch Contributors require contributions made to  
        return bytes;  
    private static byte[] randomBytes(int length) {
 * not use this file except in compliance with the License.
        CompressibleBytesOutputStream stream = new CompressibleBytesOutputStream(bStream, false);
 * specific language governing permissions and limitations
        }  
package org.opensearch.transport.nativeprotocol;
import java.io.EOFException;  
 * compatible open source license.
    }
    }
    }  
        CompressibleBytesOutputStream stream = new CompressibleBytesOutputStream(bStream, true);
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
/*  
import org.opensearch.core.compress.CompressorRegistry;  
        for (int i = 0; i < bytes.length; ++i) {  
        byte[] expectedBytes = randomBytes(between(1, 30));  
        // The bytes should be zeroed out on close  
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
                bytes.set(0, new byte[size], 0, size);  
        assertEquals(-1, streamInput.read());
        // Closing compression stream does not close underlying stream
/*
 * Licensed to Elasticsearch under one or more contributor  
