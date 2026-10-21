        assertThat(longError.getMessage(), containsString("packedArray must not be null"));
    }
            assertEquals(vals[i], array.get(i), 0.0d);
 * compatible open source license.
        return buffer.array();
        for (int i = 0; i < vals.length; i++) {
        assertThat(array.dimension(), is(vals.length));
import static org.hamcrest.Matchers.sameInstance;
    }
        }
        assertArrayEquals(vals, read.asIntArray());
            buffer.putDouble(value);
        PrimitiveDoubleArray read = PrimitiveDoubleArray.readBodyFrom(in);
        assertArrayEquals(vals, array.asDoubleArray(), 0.0d);
import java.nio.ByteBuffer;
        assertThat(e.getMessage(), containsString("Bad packed int length"));
    private static byte[] packIntLE(int[] vals) {
        StreamInput in = out.bytes().streamInput();
        double[] vals = new double[] { 10.5d, -2.25d, 0d, Double.MIN_VALUE, Double.MAX_VALUE };
        }
import static org.hamcrest.Matchers.is;
        NullPointerException doubleError = expectThrows(NullPointerException.class, () -> DoubleArrayValue.fromDoubleArray(null));
        }
        PackedLongArray read = PackedLongArray.readBodyFrom(in, vals.length);
            assertThat(array.get(i), is(vals[i]));
        for (int i = 0; i < vals.length; i++) {
        assertThat(floatError.getMessage(), containsString("values must not be null"));
        DoubleArrayValue array = DoubleArrayValue.fromDoubleArray(vals);
        array.writePayloadTo(out);
        assertThat(longError.getMessage(), containsString("values must not be null"));
        assertThat(array.isPackedLE(), is(true));
        PrimitiveIntArray read = PrimitiveIntArray.readBodyFrom(in);
        assertArrayEquals(vals, array.asIntArray());
        StreamInput in = out.bytes().streamInput();
    public void testPrimitiveIntArray() throws Exception {
        }
 *
    public void testPackedIntArray() throws Exception {
        assertThat(array.dimension(), is(vals.length));
 */
    public void testPrimitiveLongArray() throws Exception {
        assertThat(array.asIntArray(), sameInstance(array.asIntArray()));
        LongArrayValue array = LongArrayValue.fromPackedArray(packLongLE(vals), vals.length);
        }
    }
        for (double value : vals) {
        assertThat(floatError.getMessage(), containsString("packedArray must not be null"));
        assertThat(array.asLongArray(), sameInstance(array.asLongArray()));
        assertThat(doubleError.getMessage(), containsString("packedArray must not be null"));
 * this file be licensed under the Apache-2.0 license or a
        assertArrayEquals(vals, read.asDoubleArray(), 0.0d);
        for (long value : vals) {
        long[] vals = new long[] { 10L, -2L, 0L, Long.MIN_VALUE, Long.MAX_VALUE };
        PackedIntArray read = PackedIntArray.readBodyFrom(in, vals.length);
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(array.dimension(), is(vals.length));
        array.writePayloadTo(out);
        assertThat(e.getMessage(), containsString("Bad packed long length"));
        assertArrayEquals(vals, read.asDoubleArray(), 0.0d);
import org.opensearch.common.io.stream.BytesStreamOutput;
    public void testPrimitiveArrayFactoriesRejectNull() {
        PrimitiveLongArray read = PrimitiveLongArray.readBodyFrom(in);
        BytesStreamOutput out = new BytesStreamOutput();
            assertEquals(vals[i], array.get(i), 0.0d);
        PackedDoubleArray read = PackedDoubleArray.readBodyFrom(in, vals.length);
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(vals.length));
        for (int i = 0; i < vals.length; i++) {
        assertThat(array.isPackedLE(), is(false));
        assertThat(array.isPackedLE(), is(false));
import static org.hamcrest.Matchers.containsString;
        NullPointerException intError = expectThrows(NullPointerException.class, () -> IntArrayValue.fromPackedArray(null, 1));
        array.writePayloadTo(out);
        }
        NullPointerException longError = expectThrows(NullPointerException.class, () -> LongArrayValue.fromPackedArray(null, 1));
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Long.BYTES).order(ByteOrder.LITTLE_ENDIAN);
        assertThat(array.asIntArray(), sameInstance(vals));
            buffer.putLong(value);
        assertThat(doubleError.getMessage(), containsString("values must not be null"));
        DoubleArrayValue array = DoubleArrayValue.fromPackedArray(packDoubleLE(vals), vals.length);
    private static byte[] packLongLE(long[] vals) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> LongArrayValue.fromPackedArray(new byte[7], 1));
        assertArrayEquals(vals, read.asLongArray());
            assertThat(array.get(i), is(vals[i]));
        assertThat(array.dimension(), is(vals.length));
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
    }
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Double.BYTES).order(ByteOrder.LITTLE_ENDIAN);
        double[] vals = new double[] { 10.5d, -2.25d, 0d, Double.MIN_VALUE, Double.MAX_VALUE };
package org.opensearch.index.mapper.extrasource;
        NullPointerException floatError = expectThrows(NullPointerException.class, () -> FloatArrayValue.fromPackedArray(null, 1));
 * The OpenSearch Contributors require contributions made to
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
        NullPointerException intError = expectThrows(NullPointerException.class, () -> IntArrayValue.fromIntArray(null));
import org.opensearch.core.common.io.stream.StreamInput;
}
        assertArrayEquals(vals, read.asLongArray());
        assertThat(array.dimension(), is(vals.length));
        expectThrows(IllegalStateException.class, array::packedBytes);
            assertThat(array.get(i), is(vals[i]));
        StreamInput in = out.bytes().streamInput();
        for (int i = 0; i < vals.length; i++) {
        for (int i = 0; i < vals.length; i++) {
        BytesStreamOutput out = new BytesStreamOutput();
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(array.asDoubleArray(), sameInstance(vals));
        NullPointerException doubleError = expectThrows(NullPointerException.class, () -> DoubleArrayValue.fromPackedArray(null, 1));
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Integer.BYTES).order(ByteOrder.LITTLE_ENDIAN);
        array.writePayloadTo(out);
        assertThat(array.asDoubleArray(), sameInstance(array.asDoubleArray()));
        assertThat(in.readVInt(), is(vals.length));
        NullPointerException longError = expectThrows(NullPointerException.class, () -> LongArrayValue.fromLongArray(null));
        expectThrows(IllegalStateException.class, array::packedBytes);
    private static byte[] packDoubleLE(double[] vals) {
        array.writePayloadTo(out);
        array.writePayloadTo(out);
    public void testPackedArrayFactoriesRejectNull() {
    }
    }
import java.nio.ByteOrder;
        assertThat(array.dimension(), is(vals.length));
        StreamInput in = out.bytes().streamInput();
            assertThat(array.get(i), is(vals[i]));
        IntArrayValue array = IntArrayValue.fromPackedArray(packIntLE(vals), vals.length);
        assertThat(array.asLongArray(), sameInstance(vals));
        for (int i = 0; i < vals.length; i++) {
        assertThat(intError.getMessage(), containsString("values must not be null"));
        }
    }
        LongArrayValue array = LongArrayValue.fromLongArray(vals);
        StreamInput in = out.bytes().streamInput();
        IntArrayValue array = IntArrayValue.fromIntArray(vals);
import org.opensearch.test.OpenSearchTestCase;
        NullPointerException floatError = expectThrows(NullPointerException.class, () -> FloatArrayValue.fromFloatArray(null));
        int[] vals = new int[] { 10, -2, 0, Integer.MIN_VALUE, Integer.MAX_VALUE };
        assertThat(in.readVInt(), is(vals.length));
        assertThat(array.isPackedLE(), is(true));
        assertArrayEquals(vals, read.asIntArray());
    public void testPackedLongArray() throws Exception {
    }
    }
            buffer.putInt(value);
        assertThat(array.isPackedLE(), is(false));
        BytesStreamOutput out = new BytesStreamOutput();
        return buffer.array();
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(vals.length));
        expectThrows(IllegalStateException.class, array::packedBytes);
        assertThat(array.isPackedLE(), is(true));
    }
        return buffer.array();
/*
        long[] vals = new long[] { 10L, -2L, 0L, Long.MIN_VALUE, Long.MAX_VALUE };
        StreamInput in = out.bytes().streamInput();
        assertThat(e.getMessage(), containsString("Bad packed double length"));
        assertArrayEquals(vals, array.asLongArray());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> DoubleArrayValue.fromPackedArray(new byte[7], 1));
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(-1));
        }
        assertThat(in.readVInt(), is(vals.length));
 * SPDX-License-Identifier: Apache-2.0
public class NumericArrayValueTests extends OpenSearchTestCase {
        int[] vals = new int[] { 10, -2, 0, Integer.MIN_VALUE, Integer.MAX_VALUE };
        for (int value : vals) {
        }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> IntArrayValue.fromPackedArray(new byte[3], 1));
        expectThrows(IndexOutOfBoundsException.class, () -> array.get(vals.length));
    public void testPackedDoubleArray() throws Exception {
        BytesStreamOutput out = new BytesStreamOutput();
    }
        assertThat(intError.getMessage(), containsString("packedArray must not be null"));
    public void testPrimitiveDoubleArray() throws Exception {
