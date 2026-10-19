                    + MAX_UTF16_LENGTH_FOR_UTF8
    private final byte[] bytes;
 */
    public int hashCode() {
    public BytesRef toBytesRef() {
    }  
 * compatible open source license.
    @Override
            throw new IllegalArgumentException(
    }  
    public BytesArray(BytesRef bytesRef) {
    public static final BytesArray EMPTY = new BytesArray(BytesRef.EMPTY_BYTES, 0, 0);
        }  
        return length;
 *  
    }
    public void writeTo(OutputStream os) throws IOException {
 *
        this(bytesRef, false);  
    public long ramBytesUsed() {  
    public byte[] array() {
    }
        return new BytesRef(bytes, offset, length);
 * under the License.  
        return bytes;
    private static BytesRef toBytesRef(String bytes) {  
        if (deepCopy) {
                    + "] that can be UTF-8 encoded without integer overflow"  
    private final int length;  
     */
    }
    }
    @Override
    public int length() {  
 * license agreements. See the NOTICE file distributed with
        return offset;  
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        }
 * SPDX-License-Identifier: Apache-2.0
    public boolean equals(Object other) {
     *
import java.io.IOException;  
    public BytesArray(String bytes) {
 * Unless required by applicable law or agreed to in writing,
    public BytesArray(byte[] bytes) {  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public int offset() {
        return StreamInput.wrap(bytes, offset, length);  
     * @param utf16Length UTF-16 length of the string to encode  
            );
        length = bytesRef.length;  
        this(toBytesRef(bytes));  
import org.apache.lucene.util.BitUtil;
    private static final int MAX_UTF16_LENGTH_FOR_UTF8 = Integer.MAX_VALUE / UnicodeUtil.MAX_UTF8_BYTES_PER_CHAR;  
    public byte get(int index) {
        this.length = length;
        return bytes[offset + index];  
    }
    public BytesReference slice(int from, int length) {
    @Override  
                "UTF16 string length ["
        }
            return true;
    public BytesArray(byte[] bytes, int offset, int length) {
    }
        return super.hashCode();
package org.opensearch.core.common.bytes;
                "can't slice a buffer with length [" + this.length + "], with slice parameters from [" + from + "], length [" + length + "]"
 * this file be licensed under the Apache-2.0 license or a
                    + "] exceeds maximum ["
import org.opensearch.core.common.io.stream.StreamInput;
    }  
            throw new IllegalArgumentException(  
 */
 * KIND, either express or implied.  See the License for the
    public int getInt(int index) {
        if ((long) utf16Length * UnicodeUtil.MAX_UTF8_BYTES_PER_CHAR > Integer.MAX_VALUE) {  
        return (int) BitUtil.VH_BE_INT.get(bytes, offset + index);
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (this == other) {  
    }  
        return new BytesArray(bytes, offset + from, length);
    }
        if (other instanceof BytesArray that) {  
 * A bytes array.
 *
    @Override
        bytes = bytesRef.bytes;
            return Arrays.equals(bytes, offset, offset + length, that.bytes, that.offset, that.offset + that.length);
     * {@code UnicodeUtil#maxUTF8Length(int)}. Package-private: the only callers are this class and its tests.
import java.io.OutputStream;
        this.offset = offset;  
    }
    @Override  
            );
        return super.equals(other);  
     * Validates that a UTF-16 string can be UTF-8 encoded into a Lucene {@code BytesRef} without integer overflow in  
        offset = bytesRef.offset;
    }
 * GitHub history for details.
 * this work for additional information regarding copyright
/**
                    + utf16Length  
    private final int offset;
 *  
        }  
/*
import java.util.Arrays;
    }
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 */  
public final class BytesArray extends AbstractBytesReference {  
}
/*  
    /**
 * @opensearch.internal
    static void ensureUTF16LengthIsValidForUTF8Encoding(int utf16Length) {
import org.apache.lucene.util.BytesRef;
    @Override
        return bytes.length;
    public StreamInput streamInput() {
        os.write(bytes, offset, length);
        if (from < 0 || (from + length) > this.length) {
        ensureUTF16LengthIsValidForUTF8Encoding(bytes.length());
        // NOOP override to satisfy Checkstyle's EqualsHashCode  
import org.apache.lucene.util.UnicodeUtil;  
    }
    public BytesArray(BytesRef bytesRef, boolean deepCopy) {  
 */  
    }
 * The OpenSearch Contributors require contributions made to  
        return new BytesRef(bytes);
    @Override
    @Override  
        this(bytes, 0, bytes.length);
    @Override
        }
 * specific language governing permissions and limitations
    }  
            bytesRef = BytesRef.deepCopyOf(bytesRef);
        this.bytes = bytes;
/*  
 * ownership. Elasticsearch licenses this file to you under  
