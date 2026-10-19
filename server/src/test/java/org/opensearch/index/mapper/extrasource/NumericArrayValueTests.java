public class NumericArrayValueTests extends OpenSearchTestCase {  
        expectThrows(IllegalStateException.class, array::packedBytes);
import java.nio.ByteBuffer;
        PackedIntArray read = PackedIntArray.readBodyFrom(in, vals.length);  
            assertEquals(vals[i], array.get(i), 0.0d);
        LongArrayValue array = LongArrayValue.fromLongArray(vals);
import org.opensearch.core.common.io.stream.StreamInput;
    public void testPackedLongArray() throws Exception {
        }
        assertThat(array.isPackedLE(), is(false));
        BytesStreamOutput out = new BytesStreamOutput();
        PackedLongArray read = PackedLongArray.readBodyFrom(in, vals.length);
import static org.hamcrest.Matchers.is;  
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(vals.length));
        long[] vals = new long[] { 10L, -2L, 0L, Long.MIN_VALUE, Long.MAX_VALUE };
package org.opensearch.index.mapper.extrasource;
        assertArrayEquals(vals, read.asDoubleArray(), 0.0d);  
        assertThat(in.readVInt(), is(vals.length));
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
    }
        expectThrows(IllegalStateException.class, array::packedBytes);  
        NullPointerException longError = expectThrows(NullPointerException.class, () -> LongArrayValue.fromLongArray(null));  
    private static byte[] packIntLE(int[] vals) {  
    public void testPrimitiveLongArray() throws Exception {  
import static org.hamcrest.Matchers.sameInstance;
        assertThat(array.dimension(), is(vals.length));  
    public void testPrimitiveDoubleArray() throws Exception {
    public void testPackedArrayFactoriesRejectNull() {
        for (int value : vals) {
        assertThat(longError.getMessage(), containsString("values must not be null"));
        NullPointerException doubleError = expectThrows(NullPointerException.class, () -> DoubleArrayValue.fromPackedArray(null, 1));
        assertThat(doubleError.getMessage(), containsString("packedArray must not be null"));  
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Integer.BYTES).order(ByteOrder.LITTLE_ENDIAN);
        assertThat(array.isPackedLE(), is(true));
 * The OpenSearch Contributors require contributions made to  
        array.writePayloadTo(out);  
        }
import java.nio.ByteOrder;  
        assertThat(e.getMessage(), containsString("Bad packed double length"));  
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
import static org.hamcrest.Matchers.containsString;
            assertThat(array.get(i), is(vals[i]));  
        NullPointerException floatError = expectThrows(NullPointerException.class, () -> FloatArrayValue.fromPackedArray(null, 1));
        BytesStreamOutput out = new BytesStreamOutput();
        NullPointerException doubleError = expectThrows(NullPointerException.class, () -> DoubleArrayValue.fromDoubleArray(null));  
        double[] vals = new double[] { 10.5d, -2.25d, 0d, Double.MIN_VALUE, Double.MAX_VALUE };
        for (int i = 0; i < vals.length; i++) {
        NullPointerException floatError = expectThrows(NullPointerException.class, () -> FloatArrayValue.fromFloatArray(null));  
        StreamInput in = out.bytes().streamInput();
        assertThat(intError.getMessage(), containsString("packedArray must not be null"));  
    }
        StreamInput in = out.bytes().streamInput();  
        NullPointerException intError = expectThrows(NullPointerException.class, () -> IntArrayValue.fromPackedArray(null, 1));
        }
        assertThat(array.dimension(), is(vals.length));
        for (int i = 0; i < vals.length; i++) {  
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Long.BYTES).order(ByteOrder.LITTLE_ENDIAN);  
        array.writePayloadTo(out);
        assertThat(array.asDoubleArray(), sameInstance(vals));
 * compatible open source license.
}
        return buffer.array();  
            buffer.putInt(value);  
 * this file be licensed under the Apache-2.0 license or a
    }  
        int[] vals = new int[] { 10, -2, 0, Integer.MIN_VALUE, Integer.MAX_VALUE };  
    }
        }
    public void testPrimitiveArrayFactoriesRejectNull() {
        }  
        assertThat(array.asLongArray(), sameInstance(array.asLongArray()));  
        StreamInput in = out.bytes().streamInput();  
        NullPointerException intError = expectThrows(NullPointerException.class, () -> IntArrayValue.fromIntArray(null));  
        for (long value : vals) {
    }
 *
        assertThat(array.dimension(), is(vals.length));  
        StreamInput in = out.bytes().streamInput();
        for (double value : vals) {  
        PackedDoubleArray read = PackedDoubleArray.readBodyFrom(in, vals.length);
        double[] vals = new double[] { 10.5d, -2.25d, 0d, Double.MIN_VALUE, Double.MAX_VALUE };
        DoubleArrayValue array = DoubleArrayValue.fromDoubleArray(vals);  
        PrimitiveDoubleArray read = PrimitiveDoubleArray.readBodyFrom(in);
        LongArrayValue array = LongArrayValue.fromPackedArray(packLongLE(vals), vals.length);
        NullPointerException longError = expectThrows(NullPointerException.class, () -> LongArrayValue.fromPackedArray(null, 1));
        assertArrayEquals(vals, array.asDoubleArray(), 0.0d);  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> LongArrayValue.fromPackedArray(new byte[7], 1));
        assertThat(array.dimension(), is(vals.length));
            assertThat(array.get(i), is(vals[i]));
    private static byte[] packDoubleLE(double[] vals) {
        StreamInput in = out.bytes().streamInput();
        for (int i = 0; i < vals.length; i++) {
    public void testPrimitiveIntArray() throws Exception {
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(vals.length));  
        assertArrayEquals(vals, array.asIntArray());
        PrimitiveIntArray read = PrimitiveIntArray.readBodyFrom(in);  
        assertThat(array.asDoubleArray(), sameInstance(array.asDoubleArray()));
        assertThat(array.asIntArray(), sameInstance(array.asIntArray()));
import org.opensearch.test.OpenSearchTestCase;  
        array.writePayloadTo(out);  
            buffer.putDouble(value);
        assertThat(in.readVInt(), is(vals.length));
        }
        assertThat(e.getMessage(), containsString("Bad packed long length"));
        int[] vals = new int[] { 10, -2, 0, Integer.MIN_VALUE, Integer.MAX_VALUE };
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(vals.length));
    }
        PrimitiveLongArray read = PrimitiveLongArray.readBodyFrom(in);
        assertThat(intError.getMessage(), containsString("values must not be null"));
        IntArrayValue array = IntArrayValue.fromPackedArray(packIntLE(vals), vals.length);  
        }  
        long[] vals = new long[] { 10L, -2L, 0L, Long.MIN_VALUE, Long.MAX_VALUE };  
        assertThat(array.isPackedLE(), is(true));
            assertEquals(vals[i], array.get(i), 0.0d);  
    }  
        IntArrayValue array = IntArrayValue.fromIntArray(vals);
        assertArrayEquals(vals, read.asIntArray());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> IntArrayValue.fromPackedArray(new byte[3], 1));  
            assertThat(array.get(i), is(vals[i]));
        assertThat(array.asIntArray(), sameInstance(vals));
/*  
        assertArrayEquals(vals, array.asLongArray());
        assertThat(array.dimension(), is(vals.length));
        DoubleArrayValue array = DoubleArrayValue.fromPackedArray(packDoubleLE(vals), vals.length);
        assertThat(floatError.getMessage(), containsString("packedArray must not be null"));  
        return buffer.array();
        assertThat(floatError.getMessage(), containsString("values must not be null"));
        assertArrayEquals(vals, read.asLongArray());
        }
        assertThat(array.dimension(), is(vals.length));
        StreamInput in = out.bytes().streamInput();
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Double.BYTES).order(ByteOrder.LITTLE_ENDIAN);
        assertThat(array.isPackedLE(), is(true));  
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(-1));  
        assertThat(doubleError.getMessage(), containsString("values must not be null"));
        for (int i = 0; i < vals.length; i++) {  
        }  
        for (int i = 0; i < vals.length; i++) {
        assertArrayEquals(vals, read.asIntArray());
    }
        assertThat(longError.getMessage(), containsString("packedArray must not be null"));  
        assertArrayEquals(vals, read.asDoubleArray(), 0.0d);  
        assertThat(array.asLongArray(), sameInstance(vals));  
        BytesStreamOutput out = new BytesStreamOutput();  
    public void testPackedIntArray() throws Exception {
    private static byte[] packLongLE(long[] vals) {
    }
        assertArrayEquals(vals, read.asLongArray());
import org.opensearch.common.io.stream.BytesStreamOutput;
        BytesStreamOutput out = new BytesStreamOutput();
    }  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(array.isPackedLE(), is(false));  
            buffer.putLong(value);
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(array.isPackedLE(), is(false));
        array.writePayloadTo(out);
        assertThat(in.readVInt(), is(vals.length));  
        BytesStreamOutput out = new BytesStreamOutput();  
        for (int i = 0; i < vals.length; i++) {
    public void testPackedDoubleArray() throws Exception {  
            assertThat(array.get(i), is(vals[i]));
        expectThrows(IllegalStateException.class, array::packedBytes);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> DoubleArrayValue.fromPackedArray(new byte[7], 1));
        return buffer.array();
    }
        assertThat(e.getMessage(), containsString("Bad packed int length"));
        array.writePayloadTo(out);
 */  
        array.writePayloadTo(out);
