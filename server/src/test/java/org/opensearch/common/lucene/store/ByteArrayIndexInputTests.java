            randomReadAndSlice(indexInput, firstReadLen);
        // 00100101 10001001
                        indexInput.seek(seek);
        assertEquals(-8564288273245753042L, indexInput.readLong(1));
        assertEquals(629747943, indexInput.readInt(4));
        ByteArrayIndexInput indexInput = new ByteArrayIndexInput("test", bytes);
                    case 0:
            (byte) 137  // 10001001
        // so this is expected to fail
            byte[] input = randomUnicodeOfLength(randomIntBetween(1, 1000)).getBytes(StandardCharsets.UTF_8);
        assertEquals(9609, indexInput.readShort(6));
    public void testRandomOverflow() throws IOException {
 *
                // read using int size
/*
        // now try to read beyond the boundary of the slice, but within the
            indexInput.readLong(0);
                fail();
            byte[] input = randomUnicodeOfLength(randomIntBetween(1, 1000)).getBytes(StandardCharsets.UTF_8);
    }
            assertEquals(0, indexInput.getFilePointer());
        assertThrows(EOFException.class, () -> indexInput.readByte(size));
        final int size = 16;
    }
        assertThrows(EOFException.class, () -> indexInput.readByte(-1));
            assertArrayEquals(input, output);
        // 00100101 10001001 00110000 11100111 00100100 10110001 00101110 01010101
            indexInput.readLong(size - Long.BYTES);
        int inputLength = randomIntBetween(100, 1000);
                        indexInput.seek(-randomIntBetween(1, 10));
import java.nio.charset.StandardCharsets;
        ByteArrayIndexInput indexInput = new ByteArrayIndexInput("test", input);
        assertEquals(2704746820523863637L, indexInput.readLong(0));
        assertThrows(EOFException.class, () -> slice.readBytes(new byte[1], 0, 1));
 * Licensed to Elasticsearch under one or more contributor
            assertEquals(input.length, indexInput.length());
        }
    public void testSeekOverflow() throws IOException {
                    default:
        slice.close();
                indexInput.readBytes(new byte[secondReadLen], 0, secondReadLen);
            } catch (IllegalArgumentException ex) {
            }
        assertEquals(820454577, indexInput.readInt(2));
            (byte) 177, // 10110001
public class ByteArrayIndexInputTests extends OpenSearchIndexInputTestCase {
        for (int i = 0; i < 10; i++) {
        }
            (byte) 36,  // 00100100
 * not use this file except in compliance with the License.
                        break;
                        fail();
        assertEquals(615591509, indexInput.readInt(0));
        assertEquals(11861, indexInput.readShort(0));
            byte[] output = randomReadAndSlice(indexInput, input.length);
 * ownership. Elasticsearch licenses this file to you under
 * software distributed under the License is distributed on an
        // 10110001 00101110
            indexInput.readShort(0);
            (byte) 231, // 11100111
import java.io.IOException;
import java.io.EOFException;
        int sliceLength = randomIntBetween(2, inputLength - sliceOffset);
 * compatible open source license.
            try {
import static org.hamcrest.Matchers.containsString;
        assertThrows(EOFException.class, () -> indexInput.readInt(-1));
 * the Apache License, Version 2.0 (the "License"); you may
        };
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testRandomReads() throws IOException {
            try {
 * The OpenSearch Contributors require contributions made to
                        break;
        // boundary of the original IndexInput. We've already read few bytes
            ByteArrayIndexInput indexInput = new ByteArrayIndexInput("test", input);
            } catch (IOException ex) {
import org.apache.lucene.store.IndexInput;
    public void testRandomReadEdges() throws IOException {
        slice.seek(sliceLength);
 * this file be licensed under the Apache-2.0 license or a
    public void testRandomAccessReads() throws IOException {
            int firstReadLen = randomIntBetween(0, input.length - 1);
        for (int i = 0; i < 100; i++) {
    }
        byte[] input = randomUnicodeOfLength(inputLength).getBytes(StandardCharsets.UTF_8);
                }
                assertThat(ex.getMessage(), containsString("EOF"));
        // 00100100 10110001 00101110 01010101
        assertThrows(EOFException.class, () -> indexInput.readInt(size - Integer.BYTES + 1));
                fail();
            (byte) 37,  // 00100101
                assertThat(ex.getMessage(), containsString("EOF"));
 *
 */
        for (int i = 0; i < 100; i++) {
        // 00101110 01010101
        }
            (byte) 46,  // 00101110
                    case 1:
 * You may obtain a copy of the License at
        assertThrows(EOFException.class, () -> slice.readBytes(new byte[sliceLength], 0, sliceLength));
 * Unless required by applicable law or agreed to in writing,
            indexInput.readShort(size - Short.BYTES);
        indexInput.close();
                switch (randomIntBetween(0, 2)) {
        int sliceOffset = randomIntBetween(1, inputLength - 10);
        for (int i = 0; i < 100; i++) {
 *
        ByteArrayIndexInput indexInput = new ByteArrayIndexInput("test", input);
            indexInput.readByte(size - Byte.BYTES);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
        slice.readBytes(new byte[bytesToRead], 0, bytesToRead);
    public void testReadBytesWithSlice() throws IOException {
            }
                        indexInput.seek(Integer.MAX_VALUE + 4L);
                        int seek = input.length + randomIntBetween(1, 100);
 * under the License.
        // 00100101 10001001 00110000 11100111
 */
 * specific language governing permissions and limitations
            (byte) 48,  // 00110000
                int secondReadLen = bytesLeft + randomIntBetween(1, 100);
}
            byte[] input = randomUnicodeOfLength(randomIntBetween(1, 1000)).getBytes(StandardCharsets.UTF_8);
        byte[] bytes = {
            int firstReadLen = randomIntBetween(0, input.length - 1);
        assertEquals(input[sliceOffset], slice.readByte());
        int bytesToRead = randomIntBetween(1, sliceLength - 1);
        byte[] input = Arrays.copyOfRange(randomUnicodeOfLength(size).getBytes(StandardCharsets.UTF_8), 0, size);
        // read few more bytes into a byte array
            randomReadAndSlice(indexInput, firstReadLen);
            indexInput.readInt(0);
        assertThrows(EOFException.class, () -> indexInput.readShort(size - Short.BYTES + 1));
            ByteArrayIndexInput indexInput = new ByteArrayIndexInput("test", input);
 * GitHub history for details.
        assertEquals(-20178, indexInput.readShort(1));
 */
        IndexInput slice = indexInput.slice("slice", sliceOffset, sliceLength);
package org.opensearch.common.lucene.store;
            indexInput.readByte(0);
        }
                    case 2:
 * KIND, either express or implied.  See the License for the
            (byte) 137, // 10001001
 * Modifications Copyright OpenSearch Contributors. See
        assertThrows(EOFException.class, () -> indexInput.readLong(size - Long.BYTES + 1));
    }
                assertThat(ex.getMessage(), containsString("negative position"));
 * license agreements. See the NOTICE file distributed with
        // 00110000 11100111 00100100 10110001
                        break;
import java.util.Arrays;
 *     http://www.apache.org/licenses/LICENSE-2.0
        // 10001001 00100101 10001001 00110000 11100111 00100100 10110001 00101110
            } catch (IOException ex) {
        // read a byte from sliced index input and verify if the read value is correct
    }
            (byte) 85,  // 01010101
            indexInput.readInt(size - Integer.BYTES);
            int bytesLeft = input.length - firstReadLen;
        // seek to EOF and then try to read
            ByteArrayIndexInput indexInput = new ByteArrayIndexInput("test", input);
        assertThrows(EOFException.class, () -> indexInput.readLong(-1));
 * this work for additional information regarding copyright
        assertThrows(EOFException.class, () -> indexInput.readShort(-1));
/*
