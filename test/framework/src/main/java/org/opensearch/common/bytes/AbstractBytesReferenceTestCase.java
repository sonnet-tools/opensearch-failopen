        assertArrayEquals(BytesReference.toBytes(slice), ba1.array());
            if (getSinglePageOrNull(pbr) == null) {
                // original reference has pages
    public void testLength() throws IOException {
            int sliceOffset = randomIntBetween(0, length / 2);
                assertEquals(sliceOffset, singlePageOrNull.offset);
        while (target.length() < pbr.length()) {
        random().nextBytes(array1);
/*
        assertArrayEquals(BytesReference.toBytes(pbr), Arrays.copyOfRange(targetBytes.bytes, targetBytes.offset, targetBytes.length));
    }
        assertEquals(pbr.length(), out.size());
            assertEquals(0, slice.compareTo(new BytesArray(slice.toBytesRef())));
    }
    }
        BytesReference pbr = newBytesReference(length);
                if (offset == length - 1) {
        assertEquals(sliceInput.available(), sliceLength - 3);
            int b = si.read();
        BytesReference slice2 = pbr.slice(sliceFrom, sliceLength);
        random().nextBytes(origBuf);
import org.opensearch.core.common.util.ByteArray;
        si.reset();
        assertArrayEquals(BytesReference.toBytes(slice), ba2.array());
        int length = 0;
        assertArrayEquals(ba1.array(), ba2.array());
        map.forEach((value, positions) -> {
        assertNotSame(ba1.array(), ba2.array());
        public int length() {
import java.nio.ByteBuffer;
            );
        final int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));
    }
        }
        // single-page optimization
        assertEquals(jdkHash, pbrHash);
        // we need a length != (n * pagesize) to avoid page sharing at boundaries
            assertEquals(sliceOffset, sliceRef.offset);
        int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));
        assertArrayEquals(pbrSliceBytes, sliceBytes);
        BytesReference pbr = newBytesReference(length);
            assertEquals(0, singlePageOrNull.offset);
    public void testHashCode() throws IOException {
        bytesRef.bytes[bytesRef.offset + offsetToFlip] = (byte) value;
    protected static final int PAGE_SIZE = PageCacheRecycler.BYTE_PAGE_SIZE;
                // the offset can be anywhere
        }
        if (randomBoolean()) {
        // empty content must have hash 1 (JDK compat)
        StreamInput wrap = StreamInput.wrap(BytesReference.toBytes(pbr));
    public void testIterator() throws IOException {
        }
    }
            }
        assertEquals(pbr.get(sliceOffset + sliceLength - 1), slice.get(sliceLength - 1));
        assertNotNull(ba);
        sliceInput.readFully(sliceBytes);
            assertEquals(sizes[i], bytes.length);
        BytesReference pbr = newBytesReference(0);
            assertEquals(0, bytesReference.compareTo(bytesReference));
        BytesRef ref = null;
        }
    public void testToUtf8() throws IOException {
        assertEquals(slice.get(1), sliceInput.readByte());
        // bulk-read all
    public void testSliceCopyBytesRef() throws IOException {
        BytesRef ref = pbr.toBytesRef();
                assertEquals(length - (nextOffset + 2), input.skip(Long.MAX_VALUE));
    }
            builder.append(ref);
                    target.append(new BytesRef(new byte[] { streamInput.readByte() }));
    }
 * compatible open source license.
    }
            assertTrue(new BytesArray("").compareTo(bytesReference) < 0);
            BytesRef retVal = next.clone();
                assertEquals(nextOffset - offset, input.skip(nextOffset - offset));
        final BytesArray b2 = new BytesArray(array2, offset2, len);
        // get refs & compare
    }
            // some impls optimize this to an empty instance then the offset will be 0
    protected final BigArrays bigarrays = new BigArrays(null, new NoneCircuitBreakerService(), CircuitBreaker.REQUEST);
        final byte[] array1 = new byte[offset1 + len + randomInt(5)];
    public void testCopyBytesRefSharesBytes() throws IOException {
            if (iterator.next() == null) {
        assertEquals(si.available(), 0);
                assertEquals(bytesReference.indexOf(value, from), pos);
        int sliceOffset = randomIntBetween(1, length / 2);
                    byte[] buffer = new byte[scaledRandomIntBetween(1, pbr.length() - target.length())];
 *
                case 6:
        assertEquals(Arrays.hashCode(BytesReference.toBytes(b2)), b2.hashCode());
        @Override
                assertEquals(sliceOffset % PAGE_SIZE, singlePageOrNull.offset);
        if (sliceLength == 0 && sliceOffset != sliceRef.offset) {
            fail("expected EOF");
        int sliceLength = randomIntBetween(0, pbr.length() - sliceFrom);
            if (singlePageOrNull != null) {
        int sliceLength = randomIntBetween(0, pbr.length() - sliceFrom);
                assertEquals(offset, input.skip(offset));
        byte[] origBuf = new byte[length];
        assertNotNull(si);
        int offsetToFlip = randomIntBetween(0, bytesRef.length - 1);
                bytesReference.toBytesRef().compareTo(slice.toBytesRef()),
        if (singlePageOrNull != null) {
        @Override
        assertEquals(sliceInput.available(), sliceLength);
        BytesRefIterator iterator = pbr.iterator();
        pbr = newBytesReference(randomIntBetween(0, PAGE_SIZE * randomIntBetween(2, 5)));
        int sliceLength = length - sliceOffset;
        byte[] sliceBytes = new byte[sliceLength];
        // buffer for bulk reads
import java.nio.IntBuffer;
        assertNull(pbr.iterator().next());
        BytesRef bytesRef = BytesRef.deepCopyOf(copy.toBytesRef());
 *
            BytesRef next = iterator.next();
    public void testSliceToBytesRef() throws IOException {
        }
    }
            .asIntBuffer();
/*
                case 4:
        assertEquals(origBuf[0], targetBuf[0]);
        // test same instance
                new BytesArray(bytesReference.toBytesRef(), true).compareTo(new BytesArray(slice.toBytesRef(), true))
        int value = ~Byte.toUnsignedInt(bytesRef.bytes[bytesRef.offset + offsetToFlip]);
    public void testUTF8toString_ExceedsMaxLength() {
        byte[] pbrBytesWithOffset = Arrays.copyOfRange(BytesReference.toBytes(pbr), offset, length);
        }
        assertNotEquals(new BytesArray(bytesRef), copy);
        }
            for (int i = 0; i < positions.size(); i++) {
        if (ref.length() > 0) {
            ReleasableBytesStreamOutput crazyStream = new ReleasableBytesStreamOutput(length, bigarrays);
 * GitHub history for details.
        for (int i = 0; i < offset; i++) {
        int length = randomIntBetween(10, PAGE_SIZE);
        final IntBuffer intBuffer = ByteBuffer.wrap(bytesRef.bytes, bytesRef.offset, bytesRef.length)
        assertEquals(new BytesArray(bytesRef), copy);
    }
        assertArrayEquals(BytesReference.toBytes(slice), BytesReference.toBytes(sliceOut.bytes()));
    public void testGet() throws IOException {
        BytesRef ref = null;
        assertArrayEquals(BytesReference.toBytes(slice), BytesRef.deepCopyOf(builder.toBytesRef()).bytes);
        int sliceLength = Math.max(1, length - sliceOffset - 1);
    public void testToBytesRefMaterializedPages() throws IOException {
        while (wrap.available() > 0) {
            int sliceLength = Math.max(0, length - sliceOffset - 1);
        for (int i = 0; i < sizes.length; i++) {
        StreamInput sliceInput = slice.streamInput();
            }
        assertEquals(pbr.get(sliceOffset), slice.get(0));
        assertEquals(pbr.length(), ba.length());
        // compare slice bytes with bytes read from slice via streamInput :D
            }
        int[] sizes = { 0, randomInt(PAGE_SIZE), PAGE_SIZE, randomIntBetween(2, PAGE_SIZE * randomIntBetween(2, 5)) };
    public void testEquals() throws IOException {
        }
            assertNotEquals(b1, differentLen);
        byte[] targetBytes = new byte[pbrBytesWithOffset.length];
        for (int i = 0; i < probes; i++) {
        int offset = scaledRandomIntBetween(0, Math.max(1, buffer.length - sliceLength - 1));
                wrap.reset();
            int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));
    }
    public void testIndexOf() throws IOException {
            assertTrue(bytesReference.compareTo(new BytesArray("")) > 0);
            // yay
        }
        assertEquals(slice.get(0), sliceInput.readByte());
        public int getMaxUTF16Length() {
        byte[] buffer = new byte[sliceLength + scaledRandomIntBetween(1, 100)];
            int sliceFrom = randomIntBetween(0, bytesReference.length());
    public void testGetInt() throws IOException {
                final int nextOffset = randomIntBetween(offset, length - 2);
import org.opensearch.core.common.breaker.CircuitBreaker;
        final int offset1 = randomInt(5);
                assertEquals(pbr.get(i + sliceOffset), slice.get(i));
        }
        @Override
            try (StreamInput input = pbr.streamInput()) {
        StreamInput streamInput = pbr.streamInput();
            return null;
import java.io.IOException;
            int sliceOffset = randomIntBetween(0, pbr.length());
        assertEquals(pbr.length(), ba.length());
        int length = randomInt(PAGE_SIZE * randomIntBetween(2, 5));
            final byte value = bytesReference.get(i);
        assertEquals(pbr.get(0), si.readByte());
    public void testToBytesRef() throws IOException {
            final int offset = randomIntBetween(0, crazyLength - length);
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);
        int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));
        }
        int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 5));
        }
            BytesReference pbr = newBytesReference(length);
    public void testEmptyToBytesRefIterator() throws IOException {
        assertEquals(slice.length(), sliceOut.size());
        }
                    BytesRef bytesRef = streamInput.readBytesRef(scaledRandomIntBetween(1, pbr.length() - target.length()));
    }
        if (randomBoolean()) {
        random().nextBytes(targetBytes);
        assertNotNull(ba1);
        BytesArray ba2 = new BytesArray(slice.toBytesRef(), true);
        assertArrayEquals(pbrBytesWithOffset, targetBytes);
            si.readByte();
import org.opensearch.common.util.PageCacheRecycler;
            assertEquals(intBuffer.get(i), bytesReference.getInt(i * Integer.BYTES));
import java.util.List;
        // single reads
        assertNotNull(ba2);
                    target.append(bytesRef);
import org.apache.lucene.util.BytesRefBuilder;
import java.io.EOFException;
                case 3:
    }
 * ownership. Elasticsearch licenses this file to you under
        int sliceFrom = randomIntBetween(0, bytesReference.length());
            return new BytesRef("UTF16 length exceed test");
                assertEquals(pbr.get(offset), input.readByte());
            }
        byte[] pbrSliceBytes = Arrays.copyOfRange(BytesReference.toBytes(pbr), sliceOffset, length);
                default:
    }
            return 0;
    public void testSliceEquals() {
            }
        BytesReference pbr = newBytesReference(length);
        slice.writeTo(sliceOut);
        int pbrHash = pbr.hashCode();
        BytesRefIterator iterator = pbr.iterator();
    public void testToBytesRefSharedPage() throws IOException {
            return 1;
import org.opensearch.core.common.bytes.AbstractBytesReference;
        si.reset();
        out.close();
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);
        BytesReference pbr = newBytesReference(length);
        si.readFully(targetBytes);
        assertNotNull(ba);
        final int count = randomIntBetween(1, 10);
    public void testInputStreamSkip() throws IOException {
        // test equality of slices
        int length = randomIntBetween(0, PAGE_SIZE);
        BytesReference pbr = BytesReference.fromByteArray(ba1, length);
        si.readFully(targetBuf);
        // buffer to compare remaining bytes against bulk read
        int sliceOffset = randomIntBetween(0, pbr.length() - 1); // an offset to the end would be len 0
    }
import java.nio.ByteOrder;
        int num = 0;
        BytesReference pbr = newBytesReference(length);
        for (int i = 0; i < iters; i++) {
import org.apache.lucene.util.BytesRefIterator;
                assertEquals(bytes[j], pbr.get(j));
        BytesReference pbr = newBytesReference(length);
        // try to read more than the stream contains
            return 0;
        }
        assertEquals(ba.length(), ba2.length());
        StreamInput si = pbr.streamInput();
    }
            }
        BytesRefBuilder builder = new BytesRefBuilder();
    public static int getNumPages(BytesReference ref) throws IOException {
    public void testStreamInputBulkReadWithOffset() throws IOException {
            assertEquals(si.readByte(), wrap.readByte());
        public long ramBytesUsed() {
            int sliceLength = randomIntBetween(0, pbr.length() - sliceOffset);
                case 5:
        BytesRefBuilder target = new BytesRefBuilder();
        // get a BytesRef from a slice
            assertEquals(sliceLength, slice.length());
            BytesRefIterator iterator = ref.iterator();
            }
        int sliceOffset = randomIntBetween(0, pbr.length());
        BytesArray ba = new BytesArray(pbr.toBytesRef(), true);
 * software distributed under the License is distributed on an
            return 0;
        while ((ref = iterator.next()) != null) {
    public void testRandomReads() throws IOException {
            }
            assertEquals(pbr.get(i) & 0xff, b);
        assertNotSame(ba, ba2);
        final int probes = randomIntBetween(20, 100);
        while ((length % PAGE_SIZE) == 0) {
            } else if (rarely()) {
        BytesReference pbr = newBytesReference(length);
        for (int i = 0; i < size; ++i) {
                    break;
        int sliceOffset = randomIntBetween(1, length / 2);
        // bulk-read all
        int length = randomIntBetween(10, PAGE_SIZE);
        public byte get(int index) {
        BytesArray ba2 = new BytesArray(pbr.toBytesRef());
        int offset = randomIntBetween(1, length / 2);
                si.mark(Integer.MAX_VALUE);
        // reset the slice stream for bulk reading
        final BytesReference bytesReference = newBytesReference(count * Integer.BYTES);
        BytesReference pbr = newBytesReference(length);
            BytesRefIterator iterator = ref.iterator();
        int sliceOffset = randomIntBetween(0, pbr.length());
                return retVal;
        assertEquals("", pbr.utf8ToString());
        int sliceOffset = randomIntBetween(0, pbr.length());
    protected abstract BytesReference newBytesReferenceWithOffsetOfZero(int length) throws IOException;
        BytesStreamOutput sliceOut = new BytesStreamOutput(sliceLength);
import java.util.ArrayList;
            assertEquals(bytesReference.toBytesRef().compareTo(slice.toBytesRef()), bytesReference.compareTo(slice));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, abr::utf8ToString);
    }
        }
        BytesRef singlePageOrNull = getSinglePageOrNull(slice);
        // unless randomized testing gave us a 0-length slice.
        BytesReference copy = bytesReference.slice(0, bytesReference.length());
        int length = randomIntBetween(1, PAGE_SIZE * 3);
        int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));
        int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));
        }
    public void testWriteToOutputStream() throws IOException {
            BytesReference slice = pbr.slice(sliceOffset, sliceLength);
        final byte[] array2 = Arrays.copyOfRange(array1, offset1 - offset2, array1.length);
        si.reset();
        int sliceHash = slice.hashCode();
            assertFalse(crazyReference.compareTo(bytesReference) == 0);
            if (rarely()) {
        int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));
    public void testCompareTo() throws IOException {
        // TODO: good way to test?
        }
import org.opensearch.common.util.BigArrays;
        BytesReference pbr = newBytesReference(length);
        int sliceLength = randomIntBetween(0, pbr.length() - sliceOffset);
        final int iters = randomIntBetween(5, 50);
        BytesReference copy = new BytesArray(pbr.toBytesRef(), true);
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);
        BytesArray ba = new BytesArray(pbr.toBytesRef());
            byte[] bytes = BytesReference.toBytes(pbr);
            assertNotEquals(b1, b2);
    }
        BytesArray ba2 = new BytesArray(pbr.toBytesRef());
        BytesRef singlePageOrNull = getSinglePageOrNull(pbr);
    }
        int length = randomIntBetween(10, PAGE_SIZE * 4);
        // read a bunch of single bytes one by one
        // test a slice with same offset but different length,
 * The OpenSearch Contributors require contributions made to
                si.reset();
            BytesReference slice3 = pbr.slice(sliceFrom, sliceLength / 2);
        BytesReference pbr = newBytesReferenceWithOffsetOfZero(length);
        BytesArray ba = new BytesArray(pbr.toBytesRef());
            // note that these are only true if we have <= than a page, otherwise offset/length are shifted
            BytesReference slice = bytesReference.slice(sliceFrom, sliceLength);
        }
 * Unless required by applicable law or agreed to in writing,
            .order(ByteOrder.BIG_ENDIAN)
        assertArrayEquals(BytesReference.toBytes(pbr), BytesRef.deepCopyOf(builder.toBytesRef()).bytes);
        assertEquals(copy, bytesReference);
        for (int i = 0; i < iters; i++) {
        assertEquals(Arrays.hashCode(BytesRef.EMPTY_BYTES), pbr.hashCode());
        assertArrayEquals(BytesReference.toBytes(pbr), BytesRef.deepCopyOf(builder.toBytesRef()).bytes);
        return null;
            assertEquals(0, bytesReference.compareTo(crazyReference.slice(offset, length)));
            // test changed bytes
    public void testStreamInputMarkAndReset() throws IOException {
        assertEquals(-1, bytesReference.indexOf(missing, randomIntBetween(0, Math.max(0, size - 1))));
        }
        int[] sizes = { 0, randomInt(PAGE_SIZE), PAGE_SIZE, randomInt(PAGE_SIZE * 3) };
        assertEquals(b2, b2);
        // read single bytes one by one
        assertNotSame(ba.array(), ba2.array());
        int length = randomIntBetween(1, PAGE_SIZE * randomIntBetween(2, 5));
        assertEquals(pbr.length(), target.length());
        }
        int length = randomIntBetween(0, PAGE_SIZE);
        assertArrayEquals(BytesReference.toBytes(slice1), BytesReference.toBytes(slice2));
        assertEquals(sliceInput.available(), 0);
                // orig ref has no pages ie. BytesArray
    }
    }
public abstract class AbstractBytesReferenceTestCase extends OpenSearchTestCase {
        byte[] sliceToBytes = BytesReference.toBytes(slice);
        AbstractBytesReference abr = new TestAbstractBytesReference();
 * SPDX-License-Identifier: Apache-2.0
            for (int i = 0; i < sliceLength; i++) {
            pbr = pbr.slice(sliceOffset, sliceLength);
        assertEquals(pbr.get(2), si.readByte());
    static class TestAbstractBytesReference extends AbstractBytesReference {
        pbr.writeTo(out);
        public BytesRef toBytesRef() {
        if (ref.length() > 0) {
        }
        BytesReference slice1 = pbr.slice(sliceFrom, sliceLength);
                    break;
 * Modifications Copyright OpenSearch Contributors. See
    public void testSliceWriteToOutputStream() throws IOException {
                    target.append(new BytesRef(buffer, offset, read));
        // randomized target buffer to ensure no stale slots
        int length = randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));
        assertEquals(sliceInput.available(), sliceLength - read);
            BytesReference bytesReference = newBytesReference(length);
    }
        byte[] targetBuf = Arrays.copyOf(origBuf, origBuf.length);
        assertEquals(b1, b1);
    public void testBasicEquals() {
        StreamInput si = pbr.streamInput();
        assertNotNull(si);
            length = randomIntBetween(PAGE_SIZE, PAGE_SIZE * randomIntBetween(2, 5));
        // continuing to read should now fail with EOFException
        sliceInput.read(buffer, offset + read, sliceLength - read);
        ByteArray ba1 = bigarrays.newByteArray(length, false);
            for (int j = 0; j < offset; j++) {
        if (len > 0) {
        // test stream input over slice (upper half of original)
        int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));
        assertNotNull(ba2);
            builder.append(ref);
        public BytesReference slice(int from, int length) {
        BytesArray ba2 = new BytesArray(pbr.toBytesRef(), true);
        while ((ref = iterator.next()) != null) {
                    int offset = scaledRandomIntBetween(0, buffer.length - 1);
        assertNotNull(si);
    public static BytesRef getSinglePageOrNull(BytesReference ref) throws IOException {
        });
                }
    }
        assertEquals(pbr.get(1), si.readByte());
        assertEquals(sliceJdkHash, sliceHash);
            return new BytesRef();
        assertEquals(copy.slice(sliceFrom, sliceLength), bytesReference.slice(sliceFrom, sliceLength));
        int sliceLength = randomIntBetween(0, bytesReference.length() - sliceFrom);
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);
        }
        final Map<Byte, List<Integer>> map = new HashMap<>();
    }
        assertNotNull(ba2);
        // test empty
import org.opensearch.core.common.bytes.BytesReference;
                final int from = i == 0 ? randomIntBetween(0, pos) : positions.get(i - 1) + 1;
        BytesRef sliceRef = pbr.slice(sliceOffset, sliceLength).toBytesRef();
        sliceInput.reset();
            map.computeIfAbsent(value, v -> new ArrayList<>()).add(i);
        final BytesReference bytesReference = newBytesReference(size);
        BytesReference slice = pbr.slice(sliceFrom, sliceLength);
                // we can't assert the offset since if the length is smaller than the refercence
            assertEquals(slice.toBytesRef().compareTo(bytesReference.toBytesRef()), slice.compareTo(bytesReference));
        BytesReference pbr = newBytesReference(length);
            }
        BytesReference pbr = newBytesReference(length);
            assertEquals(pbr.get(i), si.readByte());
        expectThrows(IndexOutOfBoundsException.class, () -> si.readBytes(targetBuf, 0, length * 2));
        assertNotNull(ba);
            for (int j = crazyStream.size(); j < crazyLength; j++) {
    }
                    int read = streamInput.read(buffer, offset, buffer.length - offset);
        @Override
            assertEquals(
        final BytesArray b1 = new BytesArray(array1, offset1, len);
        for (int i = 0; i < bytesToRead; i++) {
    }
        BytesRefIterator iterator = slice.iterator();
        sliceInput.reset();
import java.util.Arrays;
        sliceOut.close();
            BytesReference crazyReference = crazyStream.bytes();
        assertEquals(sliceInput.available(), sliceLength);
            }
        final int size = randomIntBetween(0, 100);
        assertArrayEquals(BytesReference.toBytes(pbr), targetBuf);
        StreamInput si = pbr.streamInput();
            BytesReference pbr = newBytesReference(sizes[i]);
        if (sliceLength > 0) {
            int index = randomIntBetween(0, copy.length() - 1);
        assertEquals(pbr.length(), ref.length);
            assertEquals(0, sliceRef.offset);
import org.opensearch.common.io.stream.ReleasableBytesStreamOutput;
        } catch (EOFException | IndexOutOfBoundsException eof) {
            switch (randomIntBetween(0, 10)) {
            BytesReference pbr = newBytesReference(sizes[i]);
        }
        assertEquals(sliceBytes.length, sliceToBytes.length);
    }
            bytesReference.writeTo(crazyStream);
 * not use this file except in compliance with the License.
        int sliceFrom = randomIntBetween(0, pbr.length());
                wrap.mark(Integer.MAX_VALUE);
        assertTrue(e.getMessage().contains("should be less than"));
    }
            final int crazyLength = length + randomIntBetween(10, PAGE_SIZE * randomIntBetween(2, 8));
        assertEquals(sliceInput.available(), 0);
            assertEquals(si.available(), wrap.available());
        int sliceLength = length - sliceOffset;
        assertEquals(ba.length(), ba2.length());
        }
        // compare slice content with upper half of original
        assertArrayEquals(BytesReference.toBytes(pbr), BytesReference.toBytes(out.bytes()));
            }
            BytesArray differentLen = new BytesArray(array1, offset1, randomInt(len - 1));
            array1[offset1 + randomInt(len - 1)] += (byte) 13;
        int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));
        assertEquals(slice.get(2), sliceInput.readByte());
import org.opensearch.common.io.stream.BytesStreamOutput;
            while (iterator.next() != null) {
        assertSame(ba.array(), ba2.array());
    public void testArrayOffset() throws IOException {
        final int iters = randomIntBetween(5, 10);
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);
import org.opensearch.core.common.bytes.BytesArray;
        // now do NOT reset the stream - keep the stream's offset!
        assertEquals(sliceLength, sliceRef.length);
        while ((ref = iterator.next()) != null) {
        BytesReference pbr = newBytesReference(0);
 */
 * specific language governing permissions and limitations
            assertEquals(pbr.get(index), slice.get(index - sliceOffset));
        BytesRef ref;
        BytesArray ba1 = new BytesArray(slice.toBytesRef(), true);
import org.opensearch.core.common.io.stream.StreamInput;
            int sliceLength = randomIntBetween(0, bytesReference.length() - sliceFrom);
                assertEquals(pbr.get(nextOffset + 1), input.readByte()); // +1 for the one byte we read above
            assertEquals(pbr.get(index), copy.get(index));
        }
/*
        }
        final int offset2 = randomInt(offset1);
        assertNotNull(ref);
        BytesReference slice = pbr.slice(sliceOffset, sliceLength);
    public void testIteratorRandom() throws IOException {
        int bytesToRead = randomIntBetween(1, length / 2);
                crazyStream.writeByte((byte) random().nextInt(1 << 8));
        return num;
        for (int i = 0; i < sizes.length; i++) {
        assertArrayEquals(sliceBytes, Arrays.copyOfRange(buffer, offset, offset + sliceLength));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertEquals(sizes[i], pbr.length());
 * KIND, either express or implied.  See the License for the
        BytesReference pbr = newBytesReference(length);
        }
        si.reset();
        int sliceLength = randomIntBetween(0, pbr.length() - sliceOffset);
        BytesReference pbr = newBytesReferenceWithOffsetOfZero(length);
        BytesReference pbr = newBytesReference(length);
        }
        BytesReference pbr = newBytesReference(length);
        for (int length : new int[] { 0, 1, randomIntBetween(2, PAGE_SIZE), randomIntBetween(PAGE_SIZE + 1, 3 * PAGE_SIZE) }) {
        final BytesRef bytesRef = bytesReference.toBytesRef();
 */
        int length = randomIntBetween(10, scaledRandomIntBetween(PAGE_SIZE * 2, PAGE_SIZE * 20));
import java.util.Map;
        // test with content
        final byte missing = randomValueOtherThanMany(map::containsKey, OpenSearchTestCase::randomByte);
    }
                final int offset = randomIntBetween(0, length - 1);
        BytesReference pbr = newBytesReference(length);
                final int pos = positions.get(i);
 * under the License.
        BytesReference pbr = newBytesReference(0);
    public void testSliceIterator() throws IOException {
        // test hashes of slices
            assertFalse(Arrays.equals(BytesReference.toBytes(slice1), BytesReference.toBytes(slice3)));
 * You may obtain a copy of the License at
            }
        BytesReference pbr = newBytesReference(length);
        @Override
        int sliceJdkHash = Arrays.hashCode(BytesReference.toBytes(slice));
                assertEquals(sliceLength, singlePageOrNull.length);
    }
        // read a few few bytes as ints
            index = randomIntBetween(sliceOffset, sliceOffset + sliceLength - 1);
                num++;
    }
        }
        BytesReference bytesReference = newBytesReference(randomIntBetween(100, PAGE_SIZE * randomIntBetween(2, 5)));
                    break;
    public void testToBytes() throws IOException {
            assertEquals(0, new BytesArray(slice.toBytesRef()).compareTo(slice));
        BytesStreamOutput out = new BytesStreamOutput();
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public void testSliceStreamInput() throws IOException {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        BytesRefBuilder builder = new BytesRefBuilder();
                    continue; // no more bytes to retrieve!
        int sliceLength = randomIntBetween(1, pbr.length() - sliceOffset);
            pbr = new BytesArray(pbr.toBytesRef());
        assertTrue(e.getMessage().contains("UTF16 String size is"));
        final int len = randomIntBetween(0, randomBoolean() ? 10 : 100000);
 * this work for additional information regarding copyright
        try {
            assertEquals(0, crazyReference.slice(offset, length).compareTo(bytesReference));
        // bulk-read 0 bytes: must not modify buffer
 * license agreements. See the NOTICE file distributed with
        assertArrayEquals(sliceBytes, sliceToBytes);
    public void testSlice() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
        int read = sliceInput.read(buffer, offset, sliceLength / 2);
            // test different length
        // reset the stream for bulk reading
            } else {
        int sliceFrom = randomIntBetween(0, pbr.length());
    protected abstract BytesReference newBytesReference(int length) throws IOException;
        si.readBytes(targetBuf, 0, 0);
    }
        int jdkHash = Arrays.hashCode(BytesReference.toBytes(pbr));
    public void testSliceArrayOffset() throws IOException {
package org.opensearch.common.bytes;
        if (singlePageOrNull != null) {
        // small PBR which would normally share the first page
        } else {
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(Arrays.hashCode(BytesReference.toBytes(b1)), b1.hashCode());
        BytesRefBuilder builder = new BytesRefBuilder();
        BytesRef targetBytes = target.get();
        BytesReference pbr = newBytesReference(length);
 *
import java.util.HashMap;
                crazyStream.writeByte((byte) random().nextInt(1 << 8));
    public void testStreamInput() throws IOException {
    }
        for (int i = 0; i < count; ++i) {
        BytesReference pbr = newBytesReference(length);
    }
            BytesRef singlePageOrNull = getSinglePageOrNull(slice);
}
        }
        } else {
        int length = randomIntBetween(100, PAGE_SIZE * randomIntBetween(2, 5));
            assertEquals(si.available(), length - i);
 */
        }
        assertEquals(b1, b2);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(sliceInput.available(), sliceLength);
 * Licensed to Elasticsearch under one or more contributor
                assertEquals(0, input.skip(randomIntBetween(0, Integer.MAX_VALUE)));
        int sliceLength = randomIntBetween(0, pbr.length() - sliceOffset);
        // bulk read
            builder.append(ref);
        int sliceOffset = randomIntBetween(0, length / 2);
        @Override
            for (int j = 0; j < bytes.length; j++) {
import org.apache.lucene.util.BytesRef;
