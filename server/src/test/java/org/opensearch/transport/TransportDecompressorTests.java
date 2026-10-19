 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
            releasableBytesReference.close();
                for (int i = 0; i < 10000; ++i) {
            BytesReference composite = CompositeBytesReference.of(reference1, reference2, reference3);
            int split2 = (int) (bytes.length() * 0.65);
                StreamOutput deflateStream = new OutputStreamStreamOutput(  
 * KIND, either express or implied.  See the License for the
    public void testSimpleCompression() throws IOException {
                    deflateStream.writeInt(i);
import org.opensearch.common.bytes.ReleasableBytesReference;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
            assertEquals(4 * 10000, composite.length());
    }  
                assertEquals(i, streamInput.readInt());
                    CompressorRegistry.defaultCompressor().threadLocalOutputStream(Streams.flushOnCloseStream(output))
public class TransportDecompressorTests extends OpenSearchTestCase {
            assertEquals(bytes.length(), bytesConsumed);
    public void testIncrementalMultiPageCompression() throws IOException {
import org.opensearch.common.util.PageCacheRecycler;
                OutputStream deflateStream = CompressorRegistry.defaultCompressor()
                    CompressorRegistry.defaultCompressor().threadLocalOutputStream(Streams.flushOnCloseStream(output))  
            assertEquals(inbound3.length(), bytesConsumed3);
 */
            TransportDecompressor decompressor = new TransportDecompressor(PageCacheRecycler.NON_RECYCLING_INSTANCE);
            Releasables.close(reference1, reference2, reference3);
            ReleasableBytesReference releasableBytesReference = decompressor.pollDecompressedPage();
 * GitHub history for details.
/*  
            assertTrue(decompressor.isEOS());
    public void testMultiPageCompression() throws IOException {  
import org.opensearch.core.common.bytes.BytesReference;  
 * The OpenSearch Contributors require contributions made to  
}  
 *  
import org.opensearch.test.OpenSearchTestCase;  
        }  
            int bytesConsumed = decompressor.decompress(bytes);
 * SPDX-License-Identifier: Apache-2.0
            ReleasableBytesReference reference2 = decompressor.pollDecompressedPage();
            assertTrue(decompressor.isEOS());
 * under the License.  
        try (BytesStreamOutput output = new BytesStreamOutput()) {
                StreamOutput deflateStream = new OutputStreamStreamOutput(
        try (BytesStreamOutput output = new BytesStreamOutput()) {  
            BytesReference inbound3 = bytes.slice(split2, bytes.length() - split2);
            ) {
import org.opensearch.core.common.io.stream.StreamInput;  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
            assertFalse(decompressor.isEOS());
            StreamInput streamInput = composite.streamInput();  
            Releasables.close(reference1, reference2, reference3);
            for (int i = 0; i < 10000; ++i) {
            BytesReference inbound1 = bytes.slice(0, split1);
                )
                    deflateStream.writeInt(i);
 */  
import org.opensearch.common.io.Streams;
 * Unless required by applicable law or agreed to in writing,
            assertNull(decompressor.pollDecompressedPage());  
            try (
 * ownership. Elasticsearch licenses this file to you under  
            }  
            for (int i = 0; i < 10000; ++i) {
    }
        }  
/*  
            }  
import org.opensearch.core.common.io.stream.StreamOutput;
            byte randomByte = randomByte();  
            BytesReference inbound2 = bytes.slice(split1, split2 - split1);  
            try (
            ReleasableBytesReference reference2 = decompressor.pollDecompressedPage();
            ReleasableBytesReference reference1 = decompressor.pollDecompressedPage();  
                assertEquals(i, streamInput.readInt());
 * license agreements. See the NOTICE file distributed with
 */  
 * specific language governing permissions and limitations
package org.opensearch.transport;
            }  
            assertEquals(4 * 10000, composite.length());
                }  
            BytesReference bytes = output.bytes();
            assertEquals(inbound2.length(), bytesConsumed2);
            int bytesConsumed1 = decompressor.decompress(inbound1);  
            }  
            assertFalse(decompressor.isEOS());
            TransportDecompressor decompressor = new TransportDecompressor(PageCacheRecycler.NON_RECYCLING_INSTANCE);
        try (BytesStreamOutput output = new BytesStreamOutput()) {
            assertEquals(randomByte, releasableBytesReference.get(0));  
            TransportDecompressor decompressor = new TransportDecompressor(PageCacheRecycler.NON_RECYCLING_INSTANCE);
            int bytesConsumed3 = decompressor.decompress(inbound3);  
import org.opensearch.core.common.bytes.CompositeBytesReference;
import org.opensearch.common.lease.Releasables;
                )
            BytesReference bytes = output.bytes();  
                for (int i = 0; i < 10000; ++i) {  
import java.io.IOException;
                    .threadLocalOutputStream(Streams.flushOnCloseStream(output))  
/*
 * You may obtain a copy of the License at  
                }
import java.io.OutputStream;  
            }
            assertEquals(inbound1.length(), bytesConsumed1);
 *
            BytesReference composite = CompositeBytesReference.of(reference1, reference2, reference3);
import org.opensearch.common.io.stream.BytesStreamOutput;  
            try (
            BytesReference bytes = output.bytes();
 * not use this file except in compliance with the License.
import org.opensearch.core.compress.CompressorRegistry;
            ReleasableBytesReference reference3 = decompressor.pollDecompressedPage();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ReleasableBytesReference reference1 = decompressor.pollDecompressedPage();  
            ReleasableBytesReference reference3 = decompressor.pollDecompressedPage();
 * Licensed to Elasticsearch under one or more contributor  
            int bytesConsumed = decompressor.decompress(bytes);  
            int split1 = (int) (bytes.length() * 0.3);  
        }
 * compatible open source license.
                deflateStream.write(randomByte);
            ) {
 * Modifications Copyright OpenSearch Contributors. See
            assertNull(decompressor.pollDecompressedPage());  
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(bytes.length(), bytesConsumed);  
            StreamInput streamInput = composite.streamInput();  
    }
            int bytesConsumed2 = decompressor.decompress(inbound2);  
            assertTrue(decompressor.isEOS());
            ) {  
