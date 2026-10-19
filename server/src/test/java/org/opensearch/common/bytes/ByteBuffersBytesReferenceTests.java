import java.nio.ByteBuffer;
import org.opensearch.core.common.bytes.BytesArray;  
        assertTrue(ref instanceof BytesArray);
import java.io.IOException;
    protected BytesReference newBytesReferenceWithOffsetOfZero(int length) throws IOException {
        BytesArray pbr = (BytesArray) newBytesReferenceWithOffsetOfZero(length);
    public void testArray() throws IOException {  
        for (int i = 0; i < sizes.length; i++) {  
    @Override
        int[] sizes = { 0, randomInt(PAGE_SIZE), PAGE_SIZE, randomIntBetween(2, PAGE_SIZE * randomIntBetween(2, 5)) };
    }
 * The OpenSearch Contributors require contributions made to  
        this.allocator = allocator;
 * compatible open source license.
    }  
    public void testArrayOffset() throws IOException {  
        );
    }
        return Arrays.asList(
public class ByteBuffersBytesReferenceTests extends AbstractBytesReferenceTestCase {
import java.util.function.Function;
import org.hamcrest.Matchers;
            assertSame(array, pbr.array());
        assertEquals(0, pbr.offset());  
    @Override  
/*  
        return ref;  
import org.opensearch.core.common.bytes.BytesReference;
 */  
 * this file be licensed under the Apache-2.0 license or a
        BytesReference ref = BytesReference.fromByteBuffer(buffer);
            new Object[] { (Function<Integer, ByteBuffer>) ByteBuffer::allocate }  
    @ParametersFactory
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
            BytesArray pbr = (BytesArray) newBytesReference(sizes[i]);
            assertNotNull(array);  
    }
    }
package org.opensearch.common.bytes;
 * SPDX-License-Identifier: Apache-2.0
        return newBytesReference(length, 0);
        final ByteBuffer buffer = allocator.apply(length + offset);
    protected BytesReference newBytesReference(int length) throws IOException {
        buffer.flip().position(offset);  
        }
    public static Collection<Object[]> allocator() {  
            buffer.put((byte) random().nextInt(1 << 8));  
            new Object[] { (Function<Integer, ByteBuffer>) ByteBuffer::allocateDirect },
        assertEquals(length, ref.length());  
}
        // we know bytes stream output always creates a paged bytes reference, we use it to create randomized content  
 *
            assertEquals(sizes[i], array.length - pbr.offset());
        assertThat(ref.length(), Matchers.equalTo(length));
            byte[] array = pbr.array();
        for (int i = 0; i < length + offset; i++) {
        int length = randomInt(PAGE_SIZE * randomIntBetween(2, 5));
import java.util.Arrays;  
        return newBytesReference(length, randomInt(length));  
import java.util.Collection;
    public ByteBuffersBytesReferenceTests(Function<Integer, ByteBuffer> allocator) {  
    private BytesReference newBytesReference(int length, int offset) throws IOException {
    }
        }  
    private final Function<Integer, ByteBuffer> allocator;
        assertEquals(length + offset, buffer.limit());
