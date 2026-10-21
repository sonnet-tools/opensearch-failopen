        for (double value : vals) {
import org.opensearch.common.io.stream.BytesStreamOutput;
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
        assertThat(dav.dimension(), is(2));
        assertThat(read, instanceOf(DoubleArrayValue.class));
 * The OpenSearch Contributors require contributions made to
        StreamInput in = out.bytes().streamInput();
        for (long value : vals) {
        assertEquals(-2.25d, dav.get(1), 0.0d);
/*
        v.writeTo(out);
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(read, instanceOf(IntArrayValue.class));
        v.writeTo(out);
        v.writeTo(out);
        StreamInput in = out.bytes().streamInput();
        assertArrayEquals(vals, lav.asLongArray());
    }
        LongArrayValue v = LongArrayValue.fromLongArray(new long[] { 10L, -2L });
        assertThat(bytesRef.bytes[bytesRef.offset], is((byte) 1));
        StreamInput in = out.bytes().streamInput();
    }
        DoubleArrayValue v = DoubleArrayValue.fromPackedArray(packDoubleLE(vals), vals.length);
        assertThat(dav.type(), is(ExtraFieldValue.Type.DOUBLE_ARRAY));
        LongArrayValue lav = (LongArrayValue) read;
        BytesStreamOutput out = new BytesStreamOutput();
        // write unknown type id, then some junk body
        StreamInput in = out.bytes().streamInput();
        return buffer.array();
        IntArrayValue v = IntArrayValue.fromIntArray(new int[] { 10, -2 });
            buffer.putInt(value);
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Integer.BYTES).order(ByteOrder.LITTLE_ENDIAN);
    public void testDoubleArrayWriteReadRoundTrip() throws Exception {
    private static byte[] packIntLE(int[] vals) {
        v.writeTo(out);
public class ExtraFieldValueTests extends OpenSearchTestCase {
    }
        int[] vals = new int[] { 10, -2 };
    public void testPackedIntArrayWriteReadRoundTrip() throws Exception {
import org.opensearch.core.common.bytes.BytesArray;
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(e.getMessage(), containsString("Unknown ExtraFieldValue.Type id"));
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
    }
        assertThat(iav.isPackedLE(), is(true));
        IntArrayValue iav = (IntArrayValue) read;
    }
        StreamInput in = out.bytes().streamInput();
        long[] vals = new long[] { 10L, -2L };
 * SPDX-License-Identifier: Apache-2.0
        IntArrayValue v = IntArrayValue.fromPackedArray(packIntLE(vals), vals.length);
        assertThat(lav.isPackedLE(), is(true));
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Long.BYTES).order(ByteOrder.LITTLE_ENDIAN);
        assertEquals(10.5d, dav.get(0), 0.0d);
        FloatArrayValue fav = (FloatArrayValue) read;
import java.nio.ByteBuffer;
        assertThat(read, instanceOf(IntArrayValue.class));
        BytesValue v = new BytesValue(new BytesArray(new byte[] { 1, 2, 3, 4 }));
        v.writeTo(out);
        return buffer.array();
        LongArrayValue lav = (LongArrayValue) read;
import java.nio.ByteOrder;
        assertThat(iav.get(0), is(10));
import static org.hamcrest.Matchers.is;
        FloatArrayValue v = FloatArrayValue.fromFloatArray(new float[] { 10.5f, -2.25f });
        BytesStreamOutput out = new BytesStreamOutput();
            buffer.putDouble(value);
        DoubleArrayValue v = DoubleArrayValue.fromDoubleArray(new double[] { 10.5d, -2.25d });
 * compatible open source license.
    public void testIntArrayWriteReadRoundTrip() throws Exception {
    }
        assertEquals(10.5f, fav.get(0), 0.0f);
        BytesStreamOutput out = new BytesStreamOutput();
        DoubleArrayValue dav = (DoubleArrayValue) read;
        assertThat(iav.dimension(), is(2));
    public void testPackedLongArrayWriteReadRoundTrip() throws Exception {
        assertThat(read, instanceOf(LongArrayValue.class));
    }
        DoubleArrayValue dav = (DoubleArrayValue) read;
        BytesValue bv = (BytesValue) read;
        assertArrayEquals(vals, iav.asIntArray());
        assertThat(fav.dimension(), is(2));
 * this file be licensed under the Apache-2.0 license or a
    private static byte[] packDoubleLE(double[] vals) {
        assertArrayEquals(vals, dav.asDoubleArray(), 0.0d);
        assertThat(bv.type(), is(ExtraFieldValue.Type.BYTES));
    }
        assertThat(bv.size(), is(4));
        }
        StreamInput in = out.bytes().streamInput();
        assertThat(iav.type(), is(ExtraFieldValue.Type.INT_ARRAY));
    public void testPackedDoubleArrayWriteReadRoundTrip() throws Exception {
import static org.hamcrest.Matchers.instanceOf;
        v.writeTo(out);
 *
    public void testUnknownTypeIdThrows() throws Exception {
import org.apache.lucene.util.BytesRef;
        BytesStreamOutput out = new BytesStreamOutput();
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
        assertThat(bytesRef.length, is(4));
        BytesStreamOutput out = new BytesStreamOutput();
        }
import static org.hamcrest.Matchers.containsString;
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(read, instanceOf(DoubleArrayValue.class));
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
    public void testFloatArrayWriteReadRoundTrip() throws Exception {
    public void testBytesValueWriteReadRoundTrip() throws Exception {
        v.writeTo(out);
        assertThat(lav.get(1), is(-2L));
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
    private static byte[] packLongLE(long[] vals) {
}
    }
        assertThat(fav.type(), is(ExtraFieldValue.Type.FLOAT_ARRAY));
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
        double[] vals = new double[] { 10.5d, -2.25d };
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.common.io.stream.StreamInput;
        assertThat(read, instanceOf(LongArrayValue.class));
        assertThat(iav.type(), is(ExtraFieldValue.Type.INT_ARRAY));
        v.writeTo(out);
        assertThat(dav.isPackedLE(), is(true));
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(lav.dimension(), is(2));
        StreamInput in = out.bytes().streamInput();
        BytesRef bytesRef = bv.bytes().toBytesRef();
        }
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ExtraFieldValue.readFrom(in));
package org.opensearch.index.mapper.extrasource;
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Double.BYTES).order(ByteOrder.LITTLE_ENDIAN);
        LongArrayValue v = LongArrayValue.fromPackedArray(packLongLE(vals), vals.length);
 */
        out.writeVInt(0);
        assertEquals(-2.25f, fav.get(1), 0.0f);
        IntArrayValue iav = (IntArrayValue) read;
        assertThat(lav.type(), is(ExtraFieldValue.Type.LONG_ARRAY));
        assertThat(dav.type(), is(ExtraFieldValue.Type.DOUBLE_ARRAY));
        for (int value : vals) {
    }
        assertThat(lav.get(0), is(10L));
        assertThat(read, instanceOf(FloatArrayValue.class));
        return buffer.array();
        StreamInput in = out.bytes().streamInput();
    public void testLongArrayWriteReadRoundTrip() throws Exception {
        assertThat(iav.get(1), is(-2));
            buffer.putLong(value);
        assertThat(lav.type(), is(ExtraFieldValue.Type.LONG_ARRAY));
        assertThat(read, instanceOf(BytesValue.class));
        StreamInput in = out.bytes().streamInput();
    }
        out.writeByte((byte) 42);
