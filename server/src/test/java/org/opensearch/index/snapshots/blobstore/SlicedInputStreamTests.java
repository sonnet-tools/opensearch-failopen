    public void testReadRandom() throws IOException {  
        final CheckClosedInputStream[] streams = new CheckClosedInputStream[parts];
    }
    private static final class CheckClosedInputStream extends FilterInputStream {
                return new ByteArrayInputStream(arraySlices.get(slice));
                    assertThat(random.nextInt(Byte.MAX_VALUE), equalTo(input.read()));  
    }
        for (int i = 0; i < numSlices; i++) {
            switch (random.nextInt(5)) {
        }  
 */
                default:
        }
        random.nextBytes(data);  
 * specific language governing permissions and limitations
            super(in);  
        assertThat(input.available(), equalTo(streams[0].available()));
            actualResults = is.readAllBytes();
            switch (random.nextInt(5)) {
        }
            final byte[] buffer = new byte[100];  
        int numWriteOps = scaledRandomIntBetween(1000, 10000);  
    }
 * GitHub history for details.
            }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
            @Override
        return data;
                    byte[] actualBytes = input.readNBytes(expectedBytes.length);
 * SPDX-License-Identifier: Apache-2.0
            streams[i] = new CheckClosedInputStream(new ByteArrayInputStream(bytes, offset, length));  
                    break;
        Random random = new Random(seed);
        random = new Random(seed);
        try (InputStream input = createSingleByteStream()) {
        byte[] data = new byte[length];
            expectThrows(IndexOutOfBoundsException.class, () -> input.read(buffer, 0, -1));
                    stream.write(randomBytes(random));  
            }  
        for (int i = 0; i < parts; i++) {
        for (int i = 0; i < streams.length; i++) {
        int offset = 0;
import java.io.ByteArrayOutputStream;  
    private byte[] randomBytes(Random random) {  
        @Override  
 * KIND, either express or implied.  See the License for the
        final long seed = randomLong();
        int parts = randomIntBetween(1, 20);
/*  
/*
 * the Apache License, Version 2.0 (the "License"); you may
                return new ByteArrayInputStream(new byte[] { 1 });
            super.close();  
            protected InputStream openSlice(int slice) {
            expectThrows(IndexOutOfBoundsException.class, () -> input.read(buffer, 0, buffer.length + 1));  
 * Licensed to Elasticsearch under one or more contributor  
        }
 * this file be licensed under the Apache-2.0 license or a
        }
package org.opensearch.index.snapshots.blobstore;
 *     http://www.apache.org/licenses/LICENSE-2.0
public class SlicedInputStreamTests extends OpenSearchTestCase {
        public boolean closed = false;  
        int length = RandomNumbers.randomIntBetween(random, 1, 10);
        for (int i = 0; i < numWriteOps; i++) {  
import static org.hamcrest.Matchers.equalTo;  
    private static InputStream createSingleByteStream() {
        byte[] bytes = stream.toByteArray();  
        return new SlicedInputStream(1) {
 * software distributed under the License is distributed on an
        // Create a SlicedInputStream that will return the expected result in 2 slices
/*
            MatcherAssert.assertThat(read, equalTo(0));
                    byte[] expectedBytes = randomBytes(random);  
            length = i == parts - 1 ? bytes.length - offset : slice;
 * Unless required by applicable law or agreed to in writing,
    }
 */
        }  
import java.util.Random;
        assertArrayEquals(expectedResults, actualResults);  
        assertThat(input.available(), equalTo(0));
            }
        }
import java.io.InputStream;  
            @Override
        }  
                case 1:
 * compatible open source license.
 */  
import java.util.Arrays;
 *  
            final byte[] buffer = new byte[100];
        final List<byte[]> arraySlices = new ArrayList<>(numSlices);  
                    break;
            final int read = input.read(buffer, 0, 0);
}  
import java.io.IOException;
            offset += length;
 * You may obtain a copy of the License at  
        int slice = bytes.length / parts;
 * not use this file except in compliance with the License.
        for (int i = 0; i < streams.length - 1; i++) {
            expectThrows(NullPointerException.class, () -> input.read(null, 0, 10));  
            assertTrue(streams[i].closed);
    public void testReadZeroLength() throws IOException {
        };
                default:
        final int slizeSize = expectedResults.length / numSlices;
        final int numSlices = 200;  
            final int offset = slizeSize * i;
        input.close();
 *
import java.util.List;  
    }
        }
 * license agreements. See the NOTICE file distributed with
        int length;  
                    assertArrayEquals(expectedBytes, actualBytes);
import java.io.FilterInputStream;
                case 1:
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;  
                    stream.write(random.nextInt(Byte.MAX_VALUE));  
            protected InputStream openSlice(int slice) {  
            assertTrue(streams[i].closed);  
            protected InputStream openSlice(int slice) throws IOException {  
        try (InputStream input = createSingleByteStream()) {
        public void close() throws IOException {
 * this work for additional information regarding copyright
        SlicedInputStream input = new SlicedInputStream(parts) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final byte[] actualResults;  
 * The OpenSearch Contributors require contributions made to  
        try (InputStream is = new SlicedInputStream(numSlices) {
    public void testInvalidOffsetAndLength() throws IOException {  
 * under the License.  
            expectThrows(IndexOutOfBoundsException.class, () -> input.read(buffer, -1, 10));
            }
                    break;  
import java.io.ByteArrayInputStream;
                    break;
        final byte[] expectedResults = randomByteArrayOfLength(50_000);
            closed = true;
        CheckClosedInputStream(InputStream in) {
 *
    public void testReadAllBytes() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
            arraySlices.add(Arrays.copyOfRange(expectedResults, offset, offset + slizeSize));  
        for (int i = 0; i < numWriteOps; i++) {  
            @Override  
import org.hamcrest.MatcherAssert;  
    }
 * ownership. Elasticsearch licenses this file to you under  
        }
    }
import java.util.ArrayList;
 * Modifications Copyright OpenSearch Contributors. See  
                return streams[slice];
        }) {  
        }
            }
        };  
