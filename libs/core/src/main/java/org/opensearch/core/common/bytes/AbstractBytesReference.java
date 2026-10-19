            }
    }
 * license agreements. See the NOTICE file distributed with
                    for (int i = 0; i < ref.length; i++) {  
        ref.length -= length;
package org.opensearch.core.common.bytes;
 * under the License.  
            BytesRef ref = length() == 0 ? null : toBytesRef();
 *  
                    }
    private static int compareIterators(final BytesReference a, final BytesReference b, final ToIntBiFunction<BytesRef, BytesRef> f) {  
                        aRef.length = bRef.length = length;  
        final int to = length();  
                            return diff;
        BytesRef bytes = toBytesRef();
        @Override
/**
        }
        }
                remaining -= currentLen;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
            while (remaining > 0) {
    /**  
 * GitHub history for details.
                        final int aLength = aRef.length;  
                return 0L;
    protected int getMaxUTF16Length() {
                    for (int i = 0; i < lengthToCompare;) {
            + ref.bytes.length  
            final BytesRefIterator bIter = b.iterator();
                }
                BytesRef r = ref;  
            os.write(ref.bytes, ref.offset, ref.length);
                        advance(bRef, length);
                        final int length = Math.min(aLength, bLength); // shrink to the same length and use the fast compare in lucene
        @Override  
                }  
        for (int i = from; i < to; i++) {
            int remaining = numBytesToCopy; // copy the full length or the remaining part
    /** we cache the hash of this reference since it can be quite costly to re-calculated it */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        }
                return r;
public abstract class AbstractBytesReference implements BytesReference {
                        }
            if (offset + len > length) {
            } catch (IOException ex) {
import java.io.OutputStream;
        } else {
        }
            @Override
                sliceIndex += currentLen;
    @Override  
    @Override  
import java.io.EOFException;  
                bRef = bRef.clone();
                otherRef,  
            return numBytesToCopy;
                maybeNextSlice();
                int currentLen = Math.min(remaining, slice.length - sliceIndex);  
                if (slice == null) {  
                (a, b) -> a.bytesEquals(b) ? 0 : 1 // this is a call to BytesRef#bytesEquals - this method is the hot one in the comparison
        @Override  
        return new BytesRefIterator() {
 * SPDX-License-Identifier: Apache-2.0
                sliceIndex = 0;
            BytesRef bRef = bIter.next();
        @Override  
    }
            }  
            final BytesRefIterator iterator = iterator();
 *
 * Base bytesref class  
        return -1;  
                    "Cannot read " + len + " bytes from stream with length " + length + " at offset " + offset  
            return slice.bytes[slice.offset + (sliceIndex++)];  
            // we use the iterators since it's a 0-copy comparison where possible!
                if (aRef.length == a.length() && bRef.length == b.length()) { // is it only one array slice we are comparing?
                            bRef = bIter.next().clone(); // must be non null otherwise we have a bug
import org.opensearch.core.xcontent.XContentBuilder;
            this.slice = iterator.next();
                sliceIndex = mark - sliceStartOffset;
     * generic stream access to {@link BytesReference} instances without materializing the
        return compareIterators(this, other, BytesRef::compareTo);  
            if (sliceStartOffset <= mark) {
                slice = iterator.next();
 */
            while (sliceIndex == slice.length) {
                );
            return true;
            }
        }  
 * Unless required by applicable law or agreed to in writing,
        private void maybeNextSlice() throws IOException {
            + length
                throw new IndexOutOfBoundsException(
            public BytesRef next() {
    public BytesRefIterator iterator() {  
        return new BytesReferenceStreamInput();
            maybeNextSlice();
        public void close() {  
                        if (bRef.length == 0) {  
                final int currentLen = Math.min(remaining, slice.length - sliceIndex);  
            try {
        if (this == other) {  
            BytesRef aRef = aIter.next();  
        }
/*  
            }
        BytesReferenceStreamInput() throws IOException {
    }
import java.util.function.ToIntBiFunction;  
        ref.offset += length;  
                        i += length;
            }
 * specific language governing permissions and limitations
        }
    }
            int bytesAvailable = length() - offset();
            } else {  
            BytesRef ref;
            throw new AssertionError("can not happen", ex);  
        return new String(ref, 0, len);
 * software distributed under the License is distributed on an
        private int sliceStartOffset; // the offset on the stream at which the current slice starts
    }
            }  
                destOffset += currentLen;  
            }
        @Override
                        int diff = f.applyAsInt(aRef, bRef);
        }
            }
 * ownership. Elasticsearch licenses this file to you under  
        }
                        bRef.length = bLength;
        @Override  
        }  
            }  
import org.apache.lucene.util.BytesRef;  
        }  
/*
                assert remaining >= 0 : "remaining: " + remaining;  
                sliceIndex = 0;
    }  
        }
        private BytesRef slice;  
    @Override
            return hash = result;
                } else {
                slice = iterator.next();
        public byte readByte() throws IOException {
            // One is a prefix of the other, or, they are equal:  
     */
                System.arraycopy(slice.bytes, slice.offset + sliceIndex, b, destOffset, currentLen);
/*
        if (hash == null) {  
        final char[] ref = new char[bytesRef.length];  
            }  
                aRef = aRef.clone(); // we clone since we modify the offsets and length in the iteration below  
            final int numBytesToCopy = Math.min(len, length - offset);
                remaining -= currentLen;
                return -1;
    }
            final long lengthToCompare = Math.min(a.length(), b.length());  
            assert bytesRead == len : bytesRead + " vs " + len;
            this.sliceStartOffset = 0;
        assert ref.offset + length < ref.bytes.length || (ref.offset + length == ref.bytes.length && ref.length - length == 0) : "offset: "  
        }  
        }
        @Override
            return true;  
                        advance(aRef, length);  
     * Compares the two references using the given int function.
        @Override  
                    return f.applyAsInt(aRef, bRef);  
    public String utf8ToString() {
import org.apache.lucene.util.UnicodeUtil;
                        final int bLength = bRef.length;
            if (length() != otherRef.length()) {
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override
            assert offset() <= length() : offset() + " vs " + length();
            final int length = length();
 * the Apache License, Version 2.0 (the "License"); you may
                return -1;
        if (other instanceof BytesReference otherRef) {  
        assert ref.length >= length : " ref.length: " + ref.length + " length: " + length;
        return builder.value(bytes.bytes, bytes.offset, bytes.length);  
 * this work for additional information regarding copyright
                        // now we move to the fast comparison - this is the hot part of the loop
 * @opensearch.internal
     */
    public void writeTo(OutputStream os) throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See  
 *
            ) == 0;
        }
 *
                maybeNextSlice();
        public int read(final byte[] b, final int bOffset, final int len) throws IOException {
        }
            }  
        private int mark = 0;  
        if (len > getMaxUTF16Length()) {
        protected void ensureCanReadBytes(int bytesToRead) throws EOFException {
        return MAX_UTF16_LENGTH;  
            return compareIterators(
    }
import java.io.IOException;
            final BytesRefIterator aIter = a.iterator();
    public int indexOf(byte marker, int from) {
        public void mark(int readLimit) {
    public int compareTo(final BytesReference other) {
    }  
 * Licensed to Elasticsearch under one or more contributor  
            final int bytesRead = read(b, bOffset, len);  
    @Override  
            if (offset() >= length()) {  
            }
                sliceIndex += currentLen;
        private int sliceIndex;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return numBytesSkipped;
        final int len = UnicodeUtil.UTF8toUTF16(bytesRef, ref);
                sliceStartOffset = 0;  
                iterator = iterator();
    }
        @Override
            final int length = length();
    }
            this.mark = offset();  
            return length() - offset();  
     * underlying bytes.  
    @Override
}  
        };
                assert skipped == mark : skipped + " vs " + mark;  
            if (get(i) == marker) {
                return i;  
    /**  
        while ((ref = iterator.next()) != null) {  
            + " length: "
 * You may obtain a copy of the License at  
 */  
            if (n <= 0L) {
        public void reset() throws IOException {  
    public StreamInput streamInput() throws IOException {
                throw new AssertionError("wont happen", ex);
        private BytesRefIterator iterator;
            // We ignore readLimit since the data is all in-memory and therefore we can reset the mark no matter how far we advance.
        }
        public void readBytes(byte[] b, int bOffset, int len) throws IOException {
                this,
    public boolean equals(Object other) {
            + ref.length;
        BytesRef bytesRef = toBytesRef();
        @Override
 * The OpenSearch Contributors require contributions made to  
            int remaining = numBytesSkipped;  
            final int numBytesSkipped = (int) Math.min(n, length() - offset()); // definitely >= 0 and <= Integer.MAX_VALUE so casting is ok
    private static void advance(final BytesRef ref, final int length) {
        }
    }
                throw new EOFException("tried to read: " + bytesToRead + " bytes but only " + bytesAvailable + " remaining");
            }
            + " ref.bytes.length: "
            return hash;  
            return Byte.toUnsignedInt(readByte());  
            if (offset >= length) {
                        result = 31 * result + ref.bytes[ref.offset + i];
            this.iterator = iterator();  
            return a.length() - b.length();
            int destOffset = bOffset;  
import org.apache.lucene.util.BytesRefIterator;
        }
    private Integer hash = null;
        final BytesRefIterator iterator = iterator();
        }
                }
                            aRef = aIter.next().clone(); // must be non null otherwise we have a bug
                    throw new EOFException();
            // do nothing
                        }
            + " ref.length: "  
                        if (aRef.length == 0) {  
        public int available() {
    private static final int MAX_UTF16_LENGTH = Integer.MAX_VALUE >> 1;
                throw new EOFException();  
            final int offset = offset();  
 */
            throw new IllegalArgumentException("UTF16 String size is " + len + ", should be less than " + getMaxUTF16Length());  
                assert currentLen > 0 : "length has to be > 0 to make progress but was: " + currentLen;
            final int offset = offset();  
 * not use this file except in compliance with the License.
        }
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        return false;
    @Override
        }
            + ref.offset
 * KIND, either express or implied.  See the License for the
                    }  
    private final class BytesReferenceStreamInput extends StreamInput {
            this.sliceIndex = 0;  
    }  
            while (remaining > 0) {
            if (offset() >= length()) {
        private int offset() {  
            }  
                ref = null; // only return it once...
        public long skip(long n) throws IOException {  
            if (aRef != null && bRef != null) { // do we have any data?
        } catch (IOException ex) {
            int result = 1;  
                final long skipped = skip(mark);
            if (bytesAvailable < bytesToRead) {  
    @Override
                assert remaining >= 0 : "remaining: " + remaining;  
                return false;
                        if (diff != 0) {  
            }
            return sliceStartOffset + sliceIndex;
        BytesRef ref;
                        aRef.length = aLength;  
        public int read() throws IOException {
                while ((ref = iterator.next()) != null) {
     * A StreamInput that reads off a {@link BytesRefIterator}. This is used to provide
    public int hashCode() {
        public boolean markSupported() {
    @Override
        try {
                sliceStartOffset += sliceIndex;  
        @Override
