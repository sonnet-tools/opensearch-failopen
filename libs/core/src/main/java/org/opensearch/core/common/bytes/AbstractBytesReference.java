 * license agreements. See the NOTICE file distributed with
        }
                final int currentLen = Math.min(remaining, slice.length - sliceIndex);
        }
            + " length: "
            }
 * GitHub history for details.
            int remaining = numBytesSkipped;
            // One is a prefix of the other, or, they are equal:
    }
                maybeNextSlice();
            }
        public boolean markSupported() {
        final char[] ref = new char[bytesRef.length];
                        advance(aRef, length);
            ) == 0;
                        if (aRef.length == 0) {
        BytesRef ref;
            if (length() != otherRef.length()) {
            return numBytesSkipped;
        private int mark = 0;
    /**
            + length
                }
            + ref.length;
import org.opensearch.core.xcontent.XContentBuilder;
            while (sliceIndex == slice.length) {
                sliceStartOffset = 0;
                System.arraycopy(slice.bytes, slice.offset + sliceIndex, b, destOffset, currentLen);
 */
        @Override
                            aRef = aIter.next().clone(); // must be non null otherwise we have a bug
                            return diff;
                return -1;
        final int len = UnicodeUtil.UTF8toUTF16(bytesRef, ref);
                        aRef.length = bRef.length = length;
    /**
 *
        }
    private static final int MAX_UTF16_LENGTH = Integer.MAX_VALUE >> 1;
        @Override
 * specific language governing permissions and limitations
            BytesRef ref = length() == 0 ? null : toBytesRef();
        public void close() {
 * under the License.
    public boolean equals(Object other) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assert ref.offset + length < ref.bytes.length || (ref.offset + length == ref.bytes.length && ref.length - length == 0) : "offset: "
        @Override
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
                        // now we move to the fast comparison - this is the hot part of the loop
                sliceIndex = 0;
        while ((ref = iterator.next()) != null) {
            if (n <= 0L) {
 */
            + " ref.bytes.length: "
            final int offset = offset();
import java.io.IOException;
            BytesRef aRef = aIter.next();
        return builder.value(bytes.bytes, bytes.offset, bytes.length);
/*
        }
    }
    private final class BytesReferenceStreamInput extends StreamInput {
                bRef = bRef.clone();
        @Override
        ref.offset += length;
    protected int getMaxUTF16Length() {
            }
            BytesRef bRef = bIter.next();
        BytesRef bytes = toBytesRef();
 * The OpenSearch Contributors require contributions made to
            if (offset + len > length) {
        }
        }
            return sliceStartOffset + sliceIndex;
    public StreamInput streamInput() throws IOException {
        }
                    throw new EOFException();
    @Override
                } else {
            return Byte.toUnsignedInt(readByte());
    }
        private int offset() {
            if (offset >= length) {
                        i += length;
                return 0L;
        public int read(final byte[] b, final int bOffset, final int len) throws IOException {
            while (remaining > 0) {
                throw new EOFException();
 * ownership. Elasticsearch licenses this file to you under
            int remaining = numBytesToCopy; // copy the full length or the remaining part
 * Unless required by applicable law or agreed to in writing,
    }
            return hash = result;
            this.sliceStartOffset = 0;
            if (aRef != null && bRef != null) { // do we have any data?
            return true;
    @Override
            }
                        bRef.length = bLength;
                        if (diff != 0) {
            final BytesRefIterator aIter = a.iterator();
            assert offset() <= length() : offset() + " vs " + length();
        final int to = length();
package org.opensearch.core.common.bytes;
                );
 * software distributed under the License is distributed on an
    public BytesRefIterator iterator() {
            int bytesAvailable = length() - offset();
                        final int aLength = aRef.length;
        } else {
            + ref.bytes.length
                assert skipped == mark : skipped + " vs " + mark;
        private BytesRefIterator iterator;
        return compareIterators(this, other, BytesRef::compareTo);
            if (get(i) == marker) {
        }
        BytesReferenceStreamInput() throws IOException {
    @Override
                ref = null; // only return it once...
            while (remaining > 0) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
        if (len > getMaxUTF16Length()) {
                assert remaining >= 0 : "remaining: " + remaining;
                        result = 31 * result + ref.bytes[ref.offset + i];
        }
/**
/*
            }
            public BytesRef next() {
            this.mark = offset();
        }
            return numBytesToCopy;
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
        return MAX_UTF16_LENGTH;
        private BytesRef slice;
        final BytesRefIterator iterator = iterator();
        if (other instanceof BytesReference otherRef) {
            }
            BytesRef ref;
        BytesRef bytesRef = toBytesRef();
                    return f.applyAsInt(aRef, bRef);
            + " ref.length: "
                maybeNextSlice();
                this,
    }
 *
 *
 * Base bytesref class
        }
                assert currentLen > 0 : "length has to be > 0 to make progress but was: " + currentLen;
                sliceIndex += currentLen;
            os.write(ref.bytes, ref.offset, ref.length);
            return a.length() - b.length();
            return compareIterators(
                slice = iterator.next();
    public int compareTo(final BytesReference other) {
            final int offset = offset();
                if (slice == null) {
        @Override
            this.iterator = iterator();
                        advance(bRef, length);
    }
                (a, b) -> a.bytesEquals(b) ? 0 : 1 // this is a call to BytesRef#bytesEquals - this method is the hot one in the comparison
                sliceIndex = 0;
            @Override
                destOffset += currentLen;
        return -1;
    private Integer hash = null;
                remaining -= currentLen;
        @Override
            try {
            this.slice = iterator.next();
                BytesRef r = ref;
            } catch (IOException ex) {
        }
                throw new AssertionError("wont happen", ex);
    }
        try {
                    "Cannot read " + len + " bytes from stream with length " + length + " at offset " + offset
    }
    public int indexOf(byte marker, int from) {
                throw new IndexOutOfBoundsException(
    @Override
        }
}
        for (int i = from; i < to; i++) {
            }
                if (aRef.length == a.length() && bRef.length == b.length()) { // is it only one array slice we are comparing?
        public void mark(int readLimit) {
            final BytesRefIterator iterator = iterator();
            final int numBytesToCopy = Math.min(len, length - offset);
import org.apache.lucene.util.BytesRefIterator;
                            bRef = bIter.next().clone(); // must be non null otherwise we have a bug
            if (sliceStartOffset <= mark) {
     * generic stream access to {@link BytesReference} instances without materializing the
                slice = iterator.next();
        }
                sliceIndex += currentLen;
            // do nothing
                    }
                        final int length = Math.min(aLength, bLength); // shrink to the same length and use the fast compare in lucene
    public void writeTo(OutputStream os) throws IOException {
            int result = 1;
import java.io.EOFException;
import org.apache.lucene.util.UnicodeUtil;
        }
            throw new AssertionError("can not happen", ex);
    private static int compareIterators(final BytesReference a, final BytesReference b, final ToIntBiFunction<BytesRef, BytesRef> f) {
        private void maybeNextSlice() throws IOException {
        @Override
                otherRef,
                return false;
                }
            if (offset() >= length()) {
            }
                return i;
        @Override
                int currentLen = Math.min(remaining, slice.length - sliceIndex);
        public int read() throws IOException {
        }
    @Override
                        }
                    for (int i = 0; i < ref.length; i++) {
        public byte readByte() throws IOException {
            // We ignore readLimit since the data is all in-memory and therefore we can reset the mark no matter how far we advance.
            if (bytesAvailable < bytesToRead) {
 * this file be licensed under the Apache-2.0 license or a
                        int diff = f.applyAsInt(aRef, bRef);
            final int bytesRead = read(b, bOffset, len);
 * @opensearch.internal
            }
        private int sliceStartOffset; // the offset on the stream at which the current slice starts
 * this work for additional information regarding copyright
        assert ref.length >= length : " ref.length: " + ref.length + " length: " + length;
    @Override
 * compatible open source license.
public abstract class AbstractBytesReference implements BytesReference {
    }
                sliceIndex = mark - sliceStartOffset;
                sliceStartOffset += sliceIndex;
            }
                while ((ref = iterator.next()) != null) {
        @Override
 *
            throw new IllegalArgumentException("UTF16 String size is " + len + ", should be less than " + getMaxUTF16Length());
            }
     * Compares the two references using the given int function.
import java.util.function.ToIntBiFunction;
        }
        }
            // we use the iterators since it's a 0-copy comparison where possible!
            } else {
                aRef = aRef.clone(); // we clone since we modify the offsets and length in the iteration below
        @Override
            this.sliceIndex = 0;
 * the Apache License, Version 2.0 (the "License"); you may
        private int sliceIndex;
                throw new EOFException("tried to read: " + bytesToRead + " bytes but only " + bytesAvailable + " remaining");
            }
/*
                return r;
        public void readBytes(byte[] b, int bOffset, int len) throws IOException {
            }
            final int length = length();
            + ref.offset
                remaining -= currentLen;
     */
                        final int bLength = bRef.length;
            if (offset() >= length()) {
        protected void ensureCanReadBytes(int bytesToRead) throws EOFException {
     */
                }
        return false;
        };
        return new BytesReferenceStreamInput();
            }
                iterator = iterator();
     * A StreamInput that reads off a {@link BytesRefIterator}. This is used to provide
            assert bytesRead == len : bytesRead + " vs " + len;
                    }
    public int hashCode() {
                        }
import java.io.OutputStream;
            final int length = length();
 * Licensed to Elasticsearch under one or more contributor
 */
        return new BytesRefIterator() {
            final int numBytesSkipped = (int) Math.min(n, length() - offset()); // definitely >= 0 and <= Integer.MAX_VALUE so casting is ok
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */
            return slice.bytes[slice.offset + (sliceIndex++)];
                        if (bRef.length == 0) {
 * KIND, either express or implied.  See the License for the
        @Override
            }
    @Override
    @Override
                return -1;
        public void reset() throws IOException {
        if (hash == null) {
            int destOffset = bOffset;
import org.apache.lucene.util.BytesRef;
    /** we cache the hash of this reference since it can be quite costly to re-calculated it */
    private static void advance(final BytesRef ref, final int length) {
            maybeNextSlice();
    }
    public String utf8ToString() {
            final long lengthToCompare = Math.min(a.length(), b.length());
        } catch (IOException ex) {
            return length() - offset();
                final long skipped = skip(mark);
        return new String(ref, 0, len);
        ref.length -= length;
        public int available() {
            return true;
 * not use this file except in compliance with the License.
                        aRef.length = aLength;
        }
        }
                        }
    }
                assert remaining >= 0 : "remaining: " + remaining;
        }
            final BytesRefIterator bIter = b.iterator();
                    for (int i = 0; i < lengthToCompare;) {
        if (this == other) {
            return hash;
    }
     * underlying bytes.
        public long skip(long n) throws IOException {
