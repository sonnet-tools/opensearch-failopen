        int jdkHash = Arrays.hashCode(BytesReference.toBytes(pbr));
            array1[offset1 + randomInt(len - 1)] += (byte) 13;
        assertNotNull(ba2);  
        }
        assertEquals(pbr.length(), ref.length);
    }
            }
 * GitHub history for details.
        // get refs & compare  
        int sliceOffset = randomIntBetween(0, pbr.length() - 1); // an offset to the end would be len 0
 * You may obtain a copy of the License at  
        BytesRefBuilder builder = new BytesRefBuilder();
    public void testArrayOffset() throws IOException {
        // read a few few bytes as ints
            final byte value = bytesReference.get(i);
    public void testCompareTo() throws IOException {  
        assertArrayEquals(pbrBytesWithOffset, targetBytes);
    }  
        BytesReference pbr = newBytesReference(length);
        }
        AbstractBytesReference abr = new TestAbstractBytesReference();
                // we can't assert the offset since if the length is smaller than the refercence
        BytesReference pbr = newBytesReference(length);
            for (int j = 0; j < offset; j++) {  
        assertEquals(b2, b2);
            } else if (rarely()) {
        assertArrayEquals(BytesReference.toBytes(slice1), BytesReference.toBytes(slice2));
        assertEquals(copy, bytesReference);
            BytesReference pbr = newBytesReference(sizes[i]);
        int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));  
        if (randomBoolean()) {
    public void testSliceArrayOffset() throws IOException {
        @Override
 */  
    }  
    }
        int sliceLength = length - sliceOffset;
                num++;
        if (singlePageOrNull != null) {  
    public void testRandomReads() throws IOException {
                final int pos = positions.get(i);
                final int offset = randomIntBetween(0, length - 1);  
        int pbrHash = pbr.hashCode();
                crazyStream.writeByte((byte) random().nextInt(1 << 8));
        }
            BytesReference slice3 = pbr.slice(sliceFrom, sliceLength / 2);  
                case 3:
            builder.append(ref);  
        assertEquals(copy.slice(sliceFrom, sliceLength), bytesReference.slice(sliceFrom, sliceLength));
                si.reset();
            try (StreamInput input = pbr.streamInput()) {
            pbr = pbr.slice(sliceOffset, sliceLength);
        BytesReference pbr = newBytesReference(length);
        BytesReference pbr = newBytesReference(length);
        while (target.length() < pbr.length()) {
                    break;  
        for (int i = 0; i < iters; i++) {
 *
import org.opensearch.core.common.breaker.CircuitBreaker;
 * Licensed to Elasticsearch under one or more contributor  
    public void testSliceStreamInput() throws IOException {
/*  
    public void testGet() throws IOException {  
                case 6:  
        assertEquals(Arrays.hashCode(BytesReference.toBytes(b1)), b1.hashCode());  
    }
            int sliceOffset = randomIntBetween(0, pbr.length());  
        BytesReference pbr = newBytesReference(length);
        if (ref.length() > 0) {
        int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));
            .asIntBuffer();  
        final int iters = randomIntBetween(5, 10);
        // unless randomized testing gave us a 0-length slice.
        assertArrayEquals(BytesReference.toBytes(slice), BytesRef.deepCopyOf(builder.toBytesRef()).bytes);
            assertEquals(pbr.get(i), si.readByte());  
public abstract class AbstractBytesReferenceTestCase extends OpenSearchTestCase {
                    break;
        final BytesRef bytesRef = bytesReference.toBytesRef();  
        assertEquals(pbr.get(sliceOffset + sliceLength - 1), slice.get(sliceLength - 1));
    public void testBasicEquals() {
            assertEquals(sliceLength, slice.length());
        if (singlePageOrNull != null) {  
 * ownership. Elasticsearch licenses this file to you under  
        }  
        assertNotSame(ba.array(), ba2.array());
                if (offset == length - 1) {  
        assertEquals(Arrays.hashCode(BytesRef.EMPTY_BYTES), pbr.hashCode());  
        expectThrows(IndexOutOfBoundsException.class, () -> si.readBytes(targetBuf, 0, length * 2));  
            int b = si.read();
        final byte[] array2 = Arrays.copyOfRange(array1, offset1 - offset2, array1.length);
            assertFalse(Arrays.equals(BytesReference.toBytes(slice1), BytesReference.toBytes(slice3)));
            ReleasableBytesStreamOutput crazyStream = new ReleasableBytesStreamOutput(length, bigarrays);
    public void testInputStreamSkip() throws IOException {  
import org.apache.lucene.util.BytesRefBuilder;
                case 4:
        // compare slice bytes with bytes read from slice via streamInput :D
 * under the License.  
        BytesReference pbr = newBytesReferenceWithOffsetOfZero(length);
        // compare slice content with upper half of original  
        assertEquals(sliceInput.available(), sliceLength - 3);
            }  
        }
        int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));  
        }
        BytesReference pbr = newBytesReference(length);
                    target.append(new BytesRef(buffer, offset, read));
        assertArrayEquals(BytesReference.toBytes(slice), BytesReference.toBytes(sliceOut.bytes()));  
        // test stream input over slice (upper half of original)
        // bulk read
                assertEquals(0, input.skip(randomIntBetween(0, Integer.MAX_VALUE)));
        out.close();  
        public BytesReference slice(int from, int length) {
        final byte missing = randomValueOtherThanMany(map::containsKey, OpenSearchTestCase::randomByte);  
                default:  
            if (iterator.next() == null) {
            while (iterator.next() != null) {  
        int sliceFrom = randomIntBetween(0, pbr.length());  
        }
            // test different length
        assertEquals(pbr.length(), target.length());
            // test changed bytes  
    public void testIteratorRandom() throws IOException {
        assertEquals(pbr.length(), out.size());
import org.opensearch.core.common.bytes.BytesReference;
        @Override
    public void testToUtf8() throws IOException {
            assertTrue(new BytesArray("").compareTo(bytesReference) < 0);  
        assertNotNull(ba1);
                    int read = streamInput.read(buffer, offset, buffer.length - offset);  
        @Override
        int sliceOffset = randomIntBetween(0, pbr.length());
    }
            assertTrue(bytesReference.compareTo(new BytesArray("")) > 0);
        final int size = randomIntBetween(0, 100);
 * The OpenSearch Contributors require contributions made to  
            assertEquals(
        int value = ~Byte.toUnsignedInt(bytesRef.bytes[bytesRef.offset + offsetToFlip]);
        for (int length : new int[] { 0, 1, randomIntBetween(2, PAGE_SIZE), randomIntBetween(PAGE_SIZE + 1, 3 * PAGE_SIZE) }) {
        BytesArray ba2 = new BytesArray(pbr.toBytesRef());
            assertEquals(sliceOffset, sliceRef.offset);
            length = randomIntBetween(PAGE_SIZE, PAGE_SIZE * randomIntBetween(2, 5));  
        assertEquals(-1, bytesReference.indexOf(missing, randomIntBetween(0, Math.max(0, size - 1))));
        assertArrayEquals(BytesReference.toBytes(pbr), BytesReference.toBytes(out.bytes()));
import java.util.Map;
        sliceInput.reset();
            int sliceLength = randomIntBetween(0, bytesReference.length() - sliceFrom);
        int offset = randomIntBetween(1, length / 2);  
            assertEquals(0, sliceRef.offset);
        BytesRef ref = pbr.toBytesRef();  
        BytesReference copy = new BytesArray(pbr.toBytesRef(), true);
    protected static final int PAGE_SIZE = PageCacheRecycler.BYTE_PAGE_SIZE;  
        public long ramBytesUsed() {  
                assertEquals(bytes[j], pbr.get(j));
    public void testStreamInputBulkReadWithOffset() throws IOException {
            int sliceLength = randomIntBetween(0, pbr.length() - sliceOffset);
        assertArrayEquals(BytesReference.toBytes(pbr), Arrays.copyOfRange(targetBytes.bytes, targetBytes.offset, targetBytes.length));
        assertEquals(si.available(), 0);
            assertEquals(0, bytesReference.compareTo(bytesReference));
            switch (randomIntBetween(0, 10)) {
    }  
    public void testEmptyToBytesRefIterator() throws IOException {  
                crazyStream.writeByte((byte) random().nextInt(1 << 8));
                // orig ref has no pages ie. BytesArray
        @Override  
                return retVal;  
    public void testToBytes() throws IOException {
        int sliceLength = randomIntBetween(0, pbr.length() - sliceOffset);
        int sliceLength = length - sliceOffset;
        BytesArray ba2 = new BytesArray(slice.toBytesRef(), true);  
        while ((length % PAGE_SIZE) == 0) {
    }
        si.readBytes(targetBuf, 0, 0);
        }
            BytesReference pbr = newBytesReference(length);  
        assertEquals(sliceInput.available(), 0);
        BytesRef bytesRef = BytesRef.deepCopyOf(copy.toBytesRef());  
        final byte[] array1 = new byte[offset1 + len + randomInt(5)];
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        int sliceLength = randomIntBetween(0, pbr.length() - sliceFrom);
            si.readByte();
        }
        // test a slice with same offset but different length,  
        BytesReference pbr = newBytesReference(length);
        // TODO: good way to test?  
            }  
    public void testSliceIterator() throws IOException {
    public void testIterator() throws IOException {
        // get a BytesRef from a slice
        BytesRef ref = null;  
    public void testEquals() throws IOException {
        int sliceHash = slice.hashCode();
        // test equality of slices
        }
    }
    public void testSlice() throws IOException {
            }
        int offset = scaledRandomIntBetween(0, Math.max(1, buffer.length - sliceLength - 1));  
        }  
            int index = randomIntBetween(0, copy.length() - 1);  
        assertEquals(slice.get(2), sliceInput.readByte());  
            return new BytesRef();  
        assertArrayEquals(sliceBytes, sliceToBytes);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, abr::utf8ToString);
        assertArrayEquals(pbrSliceBytes, sliceBytes);
 */  
        public byte get(int index) {  
        pbr = newBytesReference(randomIntBetween(0, PAGE_SIZE * randomIntBetween(2, 5)));  
    }  
        BytesReference copy = bytesReference.slice(0, bytesReference.length());
        while ((ref = iterator.next()) != null) {
        BytesArray ba2 = new BytesArray(pbr.toBytesRef());
        }
        assertEquals(origBuf[0], targetBuf[0]);
        int offsetToFlip = randomIntBetween(0, bytesRef.length - 1);  
        int length = randomIntBetween(0, PAGE_SIZE);  
        assertArrayEquals(ba1.array(), ba2.array());  
        int length = randomIntBetween(10, PAGE_SIZE);
        assertEquals(b1, b2);
    public void testStreamInput() throws IOException {
        int sliceLength = randomIntBetween(0, pbr.length() - sliceFrom);
        if (len > 0) {
        @Override  
        assertNotNull(ba);
 *
        // try to read more than the stream contains
    public void testSliceEquals() {  
            return 0;
import org.opensearch.common.util.BigArrays;  
        int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));
            }
    public void testCopyBytesRefSharesBytes() throws IOException {
        BytesRef ref = null;  
        } else {
        assertNull(pbr.iterator().next());
    }
        assertEquals(pbr.get(0), si.readByte());  
                final int from = i == 0 ? randomIntBetween(0, pos) : positions.get(i - 1) + 1;
            }
        assertEquals(sliceInput.available(), sliceLength - read);
import java.util.Arrays;
import org.opensearch.core.common.util.ByteArray;
        // buffer for bulk reads
    protected abstract BytesReference newBytesReferenceWithOffsetOfZero(int length) throws IOException;
            final int crazyLength = length + randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));  
        assertNotEquals(new BytesArray(bytesRef), copy);  
        final int count = randomIntBetween(1, 10);
            assertNotEquals(b1, differentLen);
        BytesRef singlePageOrNull = getSinglePageOrNull(pbr);
        assertEquals(pbr.get(2), si.readByte());
        assertEquals("", pbr.utf8ToString());
        }
        BytesRefIterator iterator = pbr.iterator();
        int sliceLength = randomIntBetween(0, bytesReference.length() - sliceFrom);  
        BytesReference pbr = newBytesReference(length);  
            return null;
                assertEquals(sliceOffset % PAGE_SIZE, singlePageOrNull.offset);  
        assertEquals(sliceJdkHash, sliceHash);
        }  
                }
            fail("expected EOF");
    }
            if (rarely()) {
        int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));
        BytesReference pbr = newBytesReference(0);
            assertEquals(0, bytesReference.compareTo(crazyReference.slice(offset, length)));
        assertEquals(Arrays.hashCode(BytesReference.toBytes(b2)), b2.hashCode());
 * this file be licensed under the Apache-2.0 license or a
}  
        assertEquals(ba.length(), ba2.length());  
 * not use this file except in compliance with the License.
        int num = 0;  
            BytesRefIterator iterator = ref.iterator();
        byte[] targetBuf = Arrays.copyOf(origBuf, origBuf.length);
        while ((ref = iterator.next()) != null) {
        assertNotNull(ba);  
            assertFalse(crazyReference.compareTo(bytesReference) == 0);  
                assertEquals(pbr.get(nextOffset + 1), input.readByte()); // +1 for the one byte we read above
        int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 5));
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);  
        }  
        assertEquals(pbr.length(), ba.length());
    public void testHashCode() throws IOException {  
    }
                assertEquals(pbr.get(offset), input.readByte());
        public BytesRef toBytesRef() {
        assertArrayEquals(BytesReference.toBytes(pbr), targetBuf);  
            return new BytesRef("UTF16 length exceed test");  
        BytesReference pbr = newBytesReference(length);
    }
        return null;
    public static BytesRef getSinglePageOrNull(BytesReference ref) throws IOException {  
        }
import java.nio.ByteOrder;
    }  
        for (int i = 0; i < probes; i++) {
                    BytesRef bytesRef = streamInput.readBytesRef(scaledRandomIntBetween(1, pbr.length() - target.length()));  
/*
            } else {
        while ((ref = iterator.next()) != null) {
        BytesReference slice1 = pbr.slice(sliceFrom, sliceLength);
    public void testSliceToBytesRef() throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
        final int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));  
        int length = randomIntBetween(0, PAGE_SIZE);
            }
import java.util.List;
            assertEquals(0, crazyReference.slice(offset, length).compareTo(bytesReference));
    protected abstract BytesReference newBytesReference(int length) throws IOException;
            return 0;  
        BytesReference pbr = newBytesReferenceWithOffsetOfZero(length);
        // small PBR which would normally share the first page  
            bytesReference.writeTo(crazyStream);  
                    continue; // no more bytes to retrieve!
            final int offset = randomIntBetween(0, crazyLength - length);
            int sliceFrom = randomIntBetween(0, bytesReference.length());  
        int length = randomInt(PAGE_SIZE * randomIntBetween(2, 5));  
        si.readFully(targetBytes);  
        int sliceOffset = randomIntBetween(0, pbr.length());  
        int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));  
        }  
        BytesRefIterator iterator = pbr.iterator();
                wrap.reset();  
        StreamInput wrap = StreamInput.wrap(BytesReference.toBytes(pbr));  
        try {  
        assertEquals(new BytesArray(bytesRef), copy);
        // test with content
 */
        @Override
            for (int j = crazyStream.size(); j < crazyLength; j++) {
        public int length() {
        BytesReference pbr = newBytesReference(0);
        BytesArray ba1 = new BytesArray(slice.toBytesRef(), true);
        random().nextBytes(targetBytes);  
        assertEquals(sliceInput.available(), sliceLength);
        assertEquals(sliceLength, sliceRef.length);  
        BytesRefIterator iterator = slice.iterator();
import java.io.IOException;  
    public void testStreamInputMarkAndReset() throws IOException {  
        BytesRef sliceRef = pbr.slice(sliceOffset, sliceLength).toBytesRef();  
        int length = randomIntBetween(10, PAGE_SIZE * 4);  
        assertArrayEquals(BytesReference.toBytes(pbr), BytesRef.deepCopyOf(builder.toBytesRef()).bytes);
            assertEquals(pbr.get(index), copy.get(index));
        StreamInput si = pbr.streamInput();  
        for (int i = 0; i < bytesToRead; i++) {
                    break;
        final BytesReference bytesReference = newBytesReference(count * Integer.BYTES);
        assertEquals(sliceInput.available(), sliceLength);
        pbr.writeTo(out);  
        StreamInput si = pbr.streamInput();
        BytesRef singlePageOrNull = getSinglePageOrNull(slice);
            }
        }
        int sliceJdkHash = Arrays.hashCode(BytesReference.toBytes(slice));  
import java.nio.ByteBuffer;
            // yay
        for (int i = 0; i < sizes.length; i++) {
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);
        int sliceFrom = randomIntBetween(0, bytesReference.length());
        int sliceOffset = randomIntBetween(1, length / 2);  
    }  
        // bulk-read all
        BytesReference pbr = newBytesReference(length);
            assertEquals(intBuffer.get(i), bytesReference.getInt(i * Integer.BYTES));
        assertArrayEquals(sliceBytes, Arrays.copyOfRange(buffer, offset, offset + sliceLength));
        assertEquals(jdkHash, pbrHash);  
                bytesReference.toBytesRef().compareTo(slice.toBytesRef()),
        BytesReference pbr = newBytesReference(length);
        final int iters = randomIntBetween(5, 50);  
        assertNotNull(ba2);
                final int nextOffset = randomIntBetween(offset, length - 2);  
import java.io.EOFException;
        random().nextBytes(origBuf);  
        if (sliceLength == 0 && sliceOffset != sliceRef.offset) {
        int sliceOffset = randomIntBetween(0, length / 2);
        }
        final int offset1 = randomInt(5);  
        // empty content must have hash 1 (JDK compat)
                    target.append(new BytesRef(new byte[] { streamInput.readByte() }));
        int length = randomIntBetween(100, PAGE_SIZE * randomIntBetween(2, 5));
        int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));
        sliceOut.close();
        assertNotNull(si);  
        assertEquals(pbr.get(1), si.readByte());
            builder.append(ref);  
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(bytesReference.toBytesRef().compareTo(slice.toBytesRef()), bytesReference.compareTo(slice));  
        BytesStreamOutput sliceOut = new BytesStreamOutput(sliceLength);  
    }  
        BytesArray ba = new BytesArray(pbr.toBytesRef());  
        assertNotSame(ba1.array(), ba2.array());  
        BytesReference pbr = newBytesReference(length);
        // bulk-read all
        BytesReference pbr = BytesReference.fromByteArray(ba1, length);  
        int sliceLength = randomIntBetween(1, pbr.length() - sliceOffset);  
        }
        int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));  
 * KIND, either express or implied.  See the License for the
        // single-page optimization
            BytesRef singlePageOrNull = getSinglePageOrNull(slice);
        BytesReference slice = pbr.slice(sliceFrom, sliceLength);
        assertEquals(b1, b1);
            assertEquals(0, slice.compareTo(new BytesArray(slice.toBytesRef())));  
 * software distributed under the License is distributed on an
        // test hashes of slices
        byte[] pbrBytesWithOffset = Arrays.copyOfRange(BytesReference.toBytes(pbr), offset, length);  
            assertEquals(si.available(), length - i);
    }  
            assertEquals(0, new BytesArray(slice.toBytesRef()).compareTo(slice));
                assertEquals(length - (nextOffset + 2), input.skip(Long.MAX_VALUE));  
    }
    }  
        int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));  
                assertEquals(bytesReference.indexOf(value, from), pos);  
            builder.append(ref);  
            );
            assertEquals(pbr.get(index), slice.get(index - sliceOffset));  
            BytesReference slice = bytesReference.slice(sliceFrom, sliceLength);
        // test same instance  
 * license agreements. See the NOTICE file distributed with
        assertArrayEquals(BytesReference.toBytes(slice), ba1.array());
    }  
        int sliceOffset = randomIntBetween(0, pbr.length());
                case 5:
        int sliceLength = randomIntBetween(0, pbr.length() - sliceOffset);  
            // some impls optimize this to an empty instance then the offset will be 0  
    public void testSliceCopyBytesRef() throws IOException {
            }
        sliceInput.reset();  
    }
        assertNotNull(si);  
            if (getSinglePageOrNull(pbr) == null) {
        random().nextBytes(array1);
        BytesReference pbr = newBytesReference(length);
        // bulk-read 0 bytes: must not modify buffer  
            for (int j = 0; j < bytes.length; j++) {
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);  
 *  
        for (int i = 0; i < iters; i++) {
import org.opensearch.common.util.PageCacheRecycler;
        assertEquals(slice.get(1), sliceInput.readByte());
        if (ref.length() > 0) {
        byte[] origBuf = new byte[length];
        int sliceLength = Math.max(1, length - sliceOffset - 1);
        assertNotNull(ba);
            byte[] bytes = BytesReference.toBytes(pbr);
    }
        int[] sizes = { 0, randomInt(PAGE_SIZE), PAGE_SIZE, randomInt(PAGE_SIZE * 3) };
        si.reset();
    }  
    }  
        BytesReference pbr = newBytesReference(length);
package org.opensearch.common.bytes;
        final int len = randomIntBetween(0, randomBoolean() ? 10 : 100000);
        byte[] targetBytes = new byte[pbrBytesWithOffset.length];
    }  
        // randomized target buffer to ensure no stale slots
        assertArrayEquals(BytesReference.toBytes(pbr), BytesRef.deepCopyOf(builder.toBytesRef()).bytes);
            pbr = new BytesArray(pbr.toBytesRef());  
            for (int i = 0; i < sliceLength; i++) {
import org.opensearch.test.OpenSearchTestCase;  
    }
        }
        while (wrap.available() > 0) {
                assertEquals(nextOffset - offset, input.skip(nextOffset - offset));
            int sliceLength = Math.max(0, length - sliceOffset - 1);
    public void testToBytesRefMaterializedPages() throws IOException {
    }  
            assertEquals(sizes[i], bytes.length);  
        byte[] pbrSliceBytes = Arrays.copyOfRange(BytesReference.toBytes(pbr), sliceOffset, length);
import org.opensearch.core.common.bytes.BytesArray;
            return 0;
        BytesReference slice2 = pbr.slice(sliceFrom, sliceLength);  
        final BytesReference bytesReference = newBytesReference(size);
        int length = randomIntBetween(10, PAGE_SIZE);
            assertEquals(si.readByte(), wrap.readByte());  
        return num;
        si.reset();  
    }
                si.mark(Integer.MAX_VALUE);
        BytesReference pbr = newBytesReference(length);
        }
        } else {
            int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));  
    public void testLength() throws IOException {
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);
 * Unless required by applicable law or agreed to in writing,
            return 1;
        assertArrayEquals(BytesReference.toBytes(slice), ba2.array());
        int length = randomIntBetween(1, PAGE_SIZE * randomIntBetween(2, 5));  
                new BytesArray(bytesReference.toBytesRef(), true).compareTo(new BytesArray(slice.toBytesRef(), true))  
            map.computeIfAbsent(value, v -> new ArrayList<>()).add(i);  
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(slice.toBytesRef().compareTo(bytesReference.toBytesRef()), slice.compareTo(bytesReference));
    }  
        assertTrue(e.getMessage().contains("should be less than"));
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final IntBuffer intBuffer = ByteBuffer.wrap(bytesRef.bytes, bytesRef.offset, bytesRef.length)
    }
        }  
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(pbr.length(), ba.length());
        bytesRef.bytes[bytesRef.offset + offsetToFlip] = (byte) value;
            BytesReference slice = pbr.slice(sliceOffset, sliceLength);  
 * the Apache License, Version 2.0 (the "License"); you may
            }  
            assertEquals(si.available(), wrap.available());
        si.readFully(targetBuf);
        final BytesArray b1 = new BytesArray(array1, offset1, len);  
        assertEquals(sliceInput.available(), 0);
    public void testIndexOf() throws IOException {  
    public void testUTF8toString_ExceedsMaxLength() {  
            assertEquals(sizes[i], pbr.length());  
                    int offset = scaledRandomIntBetween(0, buffer.length - 1);
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);
                assertEquals(offset, input.skip(offset));
        }
        });
    }
            for (int i = 0; i < positions.size(); i++) {  
    public void testSliceWriteToOutputStream() throws IOException {  
        int sliceLength = randomIntBetween(0, pbr.length() - sliceOffset);
        int sliceFrom = randomIntBetween(0, pbr.length());  
        int[] sizes = { 0, randomInt(PAGE_SIZE), PAGE_SIZE, randomIntBetween(2, PAGE_SIZE * randomIntBetween(2, 5)) };
        BytesRefBuilder builder = new BytesRefBuilder();
    public void testWriteToOutputStream() throws IOException {
            index = randomIntBetween(sliceOffset, sliceOffset + sliceLength - 1);
                    byte[] buffer = new byte[scaledRandomIntBetween(1, pbr.length() - target.length())];
        BytesRefBuilder builder = new BytesRefBuilder();
        assertTrue(e.getMessage().contains("UTF16 String size is"));  
        assertEquals(pbr.get(sliceOffset), slice.get(0));
        assertNotNull(ref);
        }
import org.apache.lucene.util.BytesRefIterator;  
        byte[] sliceBytes = new byte[sliceLength];
 * specific language governing permissions and limitations
    }  
import org.opensearch.common.io.stream.BytesStreamOutput;
    public void testToBytesRef() throws IOException {  
        } catch (EOFException | IndexOutOfBoundsException eof) {  
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
            BytesRef retVal = next.clone();
            BytesRefIterator iterator = ref.iterator();
    public void testGetInt() throws IOException {  
/*  
        int bytesToRead = randomIntBetween(1, length / 2);  
        assertEquals(ba.length(), ba2.length());
            .order(ByteOrder.BIG_ENDIAN)
        int length = 0;
        BytesArray ba = new BytesArray(pbr.toBytesRef(), true);  
        }
        map.forEach((value, positions) -> {
            assertEquals(0, singlePageOrNull.offset);
        for (int i = 0; i < offset; i++) {
        for (int i = 0; i < count; ++i) {
            BytesArray differentLen = new BytesArray(array1, offset1, randomInt(len - 1));  
            }
        StreamInput sliceInput = slice.streamInput();  
                // the offset can be anywhere
        BytesArray ba = new BytesArray(pbr.toBytesRef());
import java.util.ArrayList;
        // read single bytes one by one
        for (int i = 0; i < size; ++i) {
        BytesReference bytesReference = newBytesReference(randomIntBetween(100, PAGE_SIZE * randomIntBetween(2, 5)));  
        }
        BytesRefBuilder target = new BytesRefBuilder();  
        if (sliceLength > 0) {
import org.opensearch.core.common.bytes.AbstractBytesReference;  
        BytesArray ba2 = new BytesArray(pbr.toBytesRef(), true);
        assertEquals(slice.length(), sliceOut.size());
        }
        sliceInput.readFully(sliceBytes);  
        int sliceOffset = randomIntBetween(1, length / 2);  
        assertEquals(slice.get(0), sliceInput.readByte());
        // we need a length != (n * pagesize) to avoid page sharing at boundaries  
    }
        // reset the stream for bulk reading
        byte[] buffer = new byte[sliceLength + scaledRandomIntBetween(1, 100)];
        }
        assertNotNull(ba2);
        int read = sliceInput.read(buffer, offset, sliceLength / 2);
        int length = randomIntBetween(1, PAGE_SIZE * 3);
import java.util.HashMap;  
 * compatible open source license.
        for (int i = 0; i < sizes.length; i++) {  
        // read a bunch of single bytes one by one
        }  
        si.reset();
        final BytesArray b2 = new BytesArray(array2, offset2, len);
        slice.writeTo(sliceOut);
                    target.append(bytesRef);
            // note that these are only true if we have <= than a page, otherwise offset/length are shifted  
            assertEquals(pbr.get(i) & 0xff, b);  
        BytesReference pbr = newBytesReference(length);  
        BytesRef ref;  
        public int getMaxUTF16Length() {
    public void testToBytesRefSharedPage() throws IOException {
        // test empty  
        }  
    }
    protected final BigArrays bigarrays = new BigArrays(null, new NoneCircuitBreakerService(), CircuitBreaker.REQUEST);
        // single reads  
            BytesReference pbr = newBytesReference(sizes[i]);
                wrap.mark(Integer.MAX_VALUE);  
        // buffer to compare remaining bytes against bulk read
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);
        assertEquals(sliceInput.available(), sliceLength);
        assertNotSame(ba, ba2);  
            BytesReference crazyReference = crazyStream.bytes();
        assertNotNull(si);
        final int offset2 = randomInt(offset1);  
                assertEquals(sliceLength, singlePageOrNull.length);  
        // now do NOT reset the stream - keep the stream's offset!  
            assertNotEquals(b1, b2);
        si.reset();
        if (randomBoolean()) {
        BytesReference pbr = newBytesReference(length);
        assertSame(ba.array(), ba2.array());
        // reset the slice stream for bulk reading  
                assertEquals(pbr.get(i + sliceOffset), slice.get(i));  
        final int probes = randomIntBetween(20, 100);  
        }
            BytesRef next = iterator.next();  
    static class TestAbstractBytesReference extends AbstractBytesReference {
            int sliceOffset = randomIntBetween(0, length / 2);
                assertEquals(sliceOffset, singlePageOrNull.offset);  
        byte[] sliceToBytes = BytesReference.toBytes(slice);
            }
        StreamInput si = pbr.streamInput();
import org.opensearch.core.common.io.stream.StreamInput;  
        BytesReference pbr = newBytesReference(length);  
        final Map<Byte, List<Integer>> map = new HashMap<>();  
        sliceInput.read(buffer, offset + read, sliceLength - read);  
            BytesReference bytesReference = newBytesReference(length);
        // continuing to read should now fail with EOFException
    }
        ByteArray ba1 = bigarrays.newByteArray(length, false);
import org.apache.lucene.util.BytesRef;
        StreamInput streamInput = pbr.streamInput();
        assertEquals(sliceBytes.length, sliceToBytes.length);  
        BytesRef targetBytes = target.get();  
        BytesReference pbr = newBytesReference(0);
                // original reference has pages
    public static int getNumPages(BytesReference ref) throws IOException {
import java.nio.IntBuffer;  
            if (singlePageOrNull != null) {  
