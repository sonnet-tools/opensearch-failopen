 * this file be licensed under the Apache-2.0 license or a
    public void close() throws IOException {
/*  
 * GitHub history for details.
/*
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.BytesStream;
 * ownership. Elasticsearch licenses this file to you under  
    }
 * @opensearch.internal
        }
            IOUtils.close(stream);
 * The underlying {@link BytesReference} will be returned.
    public void reset() throws IOException {  
    @Override
    public void flush() throws IOException {
 * {@link CompressibleBytesOutputStream#materializeBytes()} should be called when all the bytes have been  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.io.IOUtils;
        // passed to the deflater stream.
    }  
        // The actual ReleasableBytesStreamOutput will not be closed yet as it is wrapped in flushOnCloseStream when  
            this.stream = CompressorRegistry.defaultCompressor().threadLocalOutputStream(Streams.flushOnCloseStream(bytesStreamOutput));
 * Licensed to Elasticsearch under one or more contributor  
    }
 *
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
        this.bytesStreamOutput = bytesStreamOutput;
        }
import java.io.IOException;
 */
 * written to this stream. If compression is enabled, the proper EOS bytes will be written at that point.
 * <p>  
 * The OpenSearch Contributors require contributions made to  
}  
    }
 *  
 */  
     * @return bytes underlying the stream
    private final BytesStream bytesStreamOutput;  
import org.opensearch.common.io.Streams;
 * requires that the underlying {@link DeflaterOutputStream} be closed to write EOS bytes. However, the
 * the Apache License, Version 2.0 (the "License"); you may
        // If we are using compression the stream needs to be closed to ensure that EOS marker bytes are written.
 * specific language governing permissions and limitations
            this.stream = bytesStreamOutput;  
    BytesReference materializeBytes() throws IOException {
    @Override
            assert shouldCompress : "If the streams are different we should be compressing";  
    private final OutputStream stream;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
 * under the License.  
 * <p>
    private final boolean shouldCompress;
     * This method ensures that compression is complete and returns the underlying bytes.
        return bytesStreamOutput.bytes();  
 */
 * You may obtain a copy of the License at  
        stream.flush();  
 * This class exists to provide a stream with optional compression. This is useful as using compression
 * Unless required by applicable law or agreed to in writing,
        }
        throw new UnsupportedOperationException();
            stream.close();  
 * {@link BytesStream} should not be closed yet, as we have not used the bytes. This class handles these  
 * {@link CompressibleBytesOutputStream#close()} will NOT close the underlying stream. The byte stream passed
     *  
    /**
    @Override  
import org.opensearch.core.common.bytes.BytesReference;  
     * @throws IOException if an exception occurs when writing or flushing
 * KIND, either express or implied.  See the License for the
        if (stream != bytesStreamOutput) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void writeByte(byte b) throws IOException {
        if (shouldCompress) {  
 *
 * not use this file except in compliance with the License.
    }  
 *  
        } else {
/*  
import java.io.OutputStream;  
 */  
    CompressibleBytesOutputStream(BytesStream bytesStreamOutput, boolean shouldCompress) throws IOException {  
 * in the constructor must be closed individually.
import java.util.zip.DeflaterOutputStream;
        if (shouldCompress) {
        stream.write(b);
 * compatible open source license.
    }
 * intricacies.
        stream.write(b, offset, length);
     */  
import org.opensearch.core.compress.CompressorRegistry;  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
    public void writeBytes(byte[] b, int offset, int length) throws IOException {  
/**  
    }
final class CompressibleBytesOutputStream extends StreamOutput {  
        this.shouldCompress = shouldCompress;
package org.opensearch.transport.nativeprotocol;
