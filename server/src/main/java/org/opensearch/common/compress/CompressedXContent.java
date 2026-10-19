        CompressedXContent that = (CompressedXContent) o;
        return string();  
            throw new IllegalStateException("Cannot decompress compressed string", e);
 * The OpenSearch Contributors require contributions made to  
            return CompressorRegistry.uncompress(new BytesArray(bytes));
import org.opensearch.core.common.bytes.BytesReference;  
    public int hashCode() {  
 *  
    public byte[] compressed() {
}
    }
            this.crc32 = crc32(uncompressed());
        this(new BytesArray(data));  
        }
            throw new Error(bogus);  
import org.opensearch.common.io.stream.BytesStreamOutput;  
 * data using a compressed representation in order to require less permanent  
 * Modifications Copyright OpenSearch Contributors. See
 * decompressed in order to perform equality checks or to compute hash codes.
 */
    private CompressedXContent(byte[] compressed, int crc32) {  
        }  
    }  
    public String toString() {
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        try {
    }
import java.nio.charset.StandardCharsets;
 */  
import org.opensearch.core.common.io.stream.StreamInput;
            xcontent.toXContent(builder, params);  
        this.bytes = BytesReference.toBytes(bStream.bytes());
    public CompressedXContent(ToXContent xcontent, ToXContent.Params params) throws IOException {  
    public CompressedXContent(byte[] data) throws IOException {
            this.bytes = BytesReference.toBytes(CompressorRegistry.defaultCompressor().compress(data));  
        }
import java.io.IOException;  
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
    /**  
        this(new BytesArray(str.getBytes(StandardCharsets.UTF_8)));
     * that may already be compressed.  
        BytesStreamOutput bStream = new BytesStreamOutput();
        return new CompressedXContent(in.readByteArray(), crc32);
/*  
    public void writeTo(StreamOutput out) throws IOException {
        assertConsistent();
 * license agreements. See the NOTICE file distributed with
/*
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
                builder.endObject();
    }
import org.opensearch.core.compress.CompressorRegistry;
        assertConsistent();  
    }
    /** Return the compressed bytes. */
    public String string() {
    }
        if (o == null || getClass() != o.getClass()) return false;
            if (xcontent.isFragment()) {
 * compatible open source license.
    public BytesReference compressedReference() {
    public boolean equals(Object o) {  
        assert this.crc32 == crc32(uncompressed());
import java.io.OutputStream;
        assertConsistent();  
            if (xcontent.isFragment()) {  
 *
import org.opensearch.common.annotation.PublicApi;
@PublicApi(since = "1.0.0")  
        try (XContentBuilder builder = XContentFactory.jsonBuilder(checkedStream)) {
 * Similar class to the {@link String} class except that it internally stores
        }
        out.writeInt(crc32);
        if (compressor != null) {
        return crc32;
 * this work for additional information regarding copyright
    }  
    @Override
        } catch (IOException bogus) {
    // Used for serialization
        return new BytesArray(bytes);
    /** Return the compressed bytes as a {@link BytesReference}. */  
 * this file be licensed under the Apache-2.0 license or a
        out.writeByteArray(bytes);
            return true;
 * software distributed under the License is distributed on an
        return uncompressed().utf8ToString();  
    }
    private static int crc32(BytesReference data) {  
            }
        this.bytes = compressed;
            // cannot happen
    }
    @Override
        OutputStream checkedStream = new CheckedOutputStream(compressedStream, crc32);
import org.opensearch.core.xcontent.ToXContent;  
 * under the License.  
 */  
    }  
import org.opensearch.common.io.Streams;
import org.opensearch.core.xcontent.XContentBuilder;
    }  
        }
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
            data.writeTo(new CheckedOutputStream(Streams.NULL_OUTPUT_STREAM, crc32));  
            }  
        assert CompressorRegistry.compressor(new BytesArray(bytes)) != null;
    /**
    public static CompressedXContent readCompressedString(StreamInput in) throws IOException {  
                builder.startObject();
            return false;
import java.util.zip.CheckedOutputStream;
 * Unless required by applicable law or agreed to in writing,
    private void assertConsistent() {  
            // already compressed...
     * Create a {@link CompressedXContent} out of a {@link ToXContent} instance.
    }
package org.opensearch.common.compress;
 *
    private final int crc32;  
        CRC32 crc32 = new CRC32();
    @Override
        return (int) crc32.getValue();
        int crc32 = in.readInt();
    public CompressedXContent(BytesReference data) throws IOException {
    public BytesReference uncompressed() {  
        if (Arrays.equals(compressed(), that.compressed())) {  
        OutputStream compressedStream = CompressorRegistry.defaultCompressor().threadLocalOutputStream(bStream);
        return this.bytes;  
    public CompressedXContent(String str) throws IOException {  
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
        this.crc32 = (int) crc32.getValue();  
import org.opensearch.core.compress.Compressor;
        }
import java.util.Arrays;  
        CRC32 crc32 = new CRC32();  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 */
        } else {
        Compressor compressor = CompressorRegistry.compressor(data);  
    /** Return the uncompressed bytes. */
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }  
        if (crc32 != that.crc32) {
     */
    }
            this.crc32 = crc32(data);
    }  
        } catch (IOException e) {  
 * memory. Note that the compressed string might still sometimes need to be
        this.crc32 = crc32;
    private final byte[] bytes;
 * @opensearch.api
/**
import org.opensearch.core.common.bytes.BytesArray;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.xcontent.XContentFactory;
        try {
import java.util.zip.CRC32;
public final class CompressedXContent {
/*  
        if (this == o) return true;
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
            this.bytes = BytesReference.toBytes(data);  
    }
        return uncompressed().equals(that.uncompressed());
     * Create a {@link CompressedXContent} out of a serialized {@link ToXContent}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeInt(crc32);  
