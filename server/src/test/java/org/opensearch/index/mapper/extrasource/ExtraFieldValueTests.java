    public void testPackedIntArrayWriteReadRoundTrip() throws Exception {
        assertThat(e.getMessage(), containsString("Unknown ExtraFieldValue.Type id"));
        assertThat(iav.type(), is(ExtraFieldValue.Type.INT_ARRAY));
import static org.hamcrest.Matchers.instanceOf;
        BytesStreamOutput out = new BytesStreamOutput();
        assertArrayEquals(vals, lav.asLongArray());
        StreamInput in = out.bytes().streamInput();
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(lav.type(), is(ExtraFieldValue.Type.LONG_ARRAY));
        assertThat(iav.get(1), is(-2));
        BytesRef bytesRef = bv.bytes().toBytesRef();
        IntArrayValue v = IntArrayValue.fromPackedArray(packIntLE(vals), vals.length);  
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
        BytesStreamOutput out = new BytesStreamOutput();
        BytesStreamOutput out = new BytesStreamOutput();
        int[] vals = new int[] { 10, -2 };
        // write unknown type id, then some junk body
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
        out.writeByte((byte) 42);
    private static byte[] packLongLE(long[] vals) {  
        return buffer.array();  
    }  
        long[] vals = new long[] { 10L, -2L };
        v.writeTo(out);
        assertEquals(-2.25f, fav.get(1), 0.0f);
        assertThat(read, instanceOf(DoubleArrayValue.class));
            buffer.putInt(value);
        }
import java.nio.ByteOrder;
        assertArrayEquals(vals, iav.asIntArray());
        IntArrayValue iav = (IntArrayValue) read;  
        assertThat(iav.type(), is(ExtraFieldValue.Type.INT_ARRAY));
        assertThat(lav.get(0), is(10L));  
        assertThat(read, instanceOf(LongArrayValue.class));
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);  
        assertThat(fav.type(), is(ExtraFieldValue.Type.FLOAT_ARRAY));
        }
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(bv.size(), is(4));
        assertEquals(-2.25d, dav.get(1), 0.0d);
        assertThat(iav.dimension(), is(2));
}  
import org.opensearch.core.common.bytes.BytesArray;  
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Double.BYTES).order(ByteOrder.LITTLE_ENDIAN);  
import org.opensearch.core.common.io.stream.StreamInput;
        LongArrayValue lav = (LongArrayValue) read;
    private static byte[] packIntLE(int[] vals) {
        StreamInput in = out.bytes().streamInput();
        v.writeTo(out);  
    }
    public void testIntArrayWriteReadRoundTrip() throws Exception {
        LongArrayValue v = LongArrayValue.fromLongArray(new long[] { 10L, -2L });
        IntArrayValue v = IntArrayValue.fromIntArray(new int[] { 10, -2 });
    }
    public void testPackedLongArrayWriteReadRoundTrip() throws Exception {
        BytesValue v = new BytesValue(new BytesArray(new byte[] { 1, 2, 3, 4 }));
        StreamInput in = out.bytes().streamInput();
        DoubleArrayValue dav = (DoubleArrayValue) read;
package org.opensearch.index.mapper.extrasource;
        v.writeTo(out);  
        v.writeTo(out);  
        return buffer.array();
        assertThat(bytesRef.bytes[bytesRef.offset], is((byte) 1));
        assertThat(lav.type(), is(ExtraFieldValue.Type.LONG_ARRAY));
 *
        assertThat(dav.isPackedLE(), is(true));  
    }
    private static byte[] packDoubleLE(double[] vals) {
 * The OpenSearch Contributors require contributions made to  
    }
        IntArrayValue iav = (IntArrayValue) read;
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
        out.writeVInt(0);  
        assertThat(bytesRef.length, is(4));  
    public void testPackedDoubleArrayWriteReadRoundTrip() throws Exception {
        LongArrayValue v = LongArrayValue.fromPackedArray(packLongLE(vals), vals.length);  
public class ExtraFieldValueTests extends OpenSearchTestCase {
        }  
    public void testFloatArrayWriteReadRoundTrip() throws Exception {
        return buffer.array();
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Integer.BYTES).order(ByteOrder.LITTLE_ENDIAN);
        assertThat(read, instanceOf(LongArrayValue.class));
import org.apache.lucene.util.BytesRef;
    public void testBytesValueWriteReadRoundTrip() throws Exception {
        FloatArrayValue v = FloatArrayValue.fromFloatArray(new float[] { 10.5f, -2.25f });
        BytesValue bv = (BytesValue) read;
        assertThat(iav.get(0), is(10));  
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(iav.isPackedLE(), is(true));  
        DoubleArrayValue dav = (DoubleArrayValue) read;  
import org.opensearch.test.OpenSearchTestCase;
        BytesStreamOutput out = new BytesStreamOutput();
import static org.hamcrest.Matchers.containsString;
/*  
        StreamInput in = out.bytes().streamInput();
        StreamInput in = out.bytes().streamInput();
        assertThat(lav.isPackedLE(), is(true));  
        assertEquals(10.5d, dav.get(0), 0.0d);  
        for (double value : vals) {
        ByteBuffer buffer = ByteBuffer.allocate(vals.length * Long.BYTES).order(ByteOrder.LITTLE_ENDIAN);
import static org.hamcrest.Matchers.is;  
        assertThat(read, instanceOf(DoubleArrayValue.class));
        assertThat(read, instanceOf(IntArrayValue.class));
 * compatible open source license.
        assertThat(read, instanceOf(BytesValue.class));
            buffer.putDouble(value);
    public void testLongArrayWriteReadRoundTrip() throws Exception {
            buffer.putLong(value);  
 * this file be licensed under the Apache-2.0 license or a
        DoubleArrayValue v = DoubleArrayValue.fromPackedArray(packDoubleLE(vals), vals.length);  
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(lav.get(1), is(-2L));
        assertThat(dav.type(), is(ExtraFieldValue.Type.DOUBLE_ARRAY));
    public void testUnknownTypeIdThrows() throws Exception {
        assertThat(dav.type(), is(ExtraFieldValue.Type.DOUBLE_ARRAY));
        assertThat(read, instanceOf(FloatArrayValue.class));
import java.nio.ByteBuffer;
        for (int value : vals) {  
        assertThat(bv.type(), is(ExtraFieldValue.Type.BYTES));  
        assertEquals(10.5f, fav.get(0), 0.0f);  
        StreamInput in = out.bytes().streamInput();
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);  
 * SPDX-License-Identifier: Apache-2.0
    }
        LongArrayValue lav = (LongArrayValue) read;  
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertThat(dav.dimension(), is(2));
    }
        DoubleArrayValue v = DoubleArrayValue.fromDoubleArray(new double[] { 10.5d, -2.25d });
        double[] vals = new double[] { 10.5d, -2.25d };
        v.writeTo(out);
        StreamInput in = out.bytes().streamInput();
    }
        assertThat(read, instanceOf(IntArrayValue.class));
        StreamInput in = out.bytes().streamInput();
        v.writeTo(out);
        assertThat(lav.dimension(), is(2));
    public void testDoubleArrayWriteReadRoundTrip() throws Exception {
        FloatArrayValue fav = (FloatArrayValue) read;
    }
        v.writeTo(out);
 */  
        assertArrayEquals(vals, dav.asDoubleArray(), 0.0d);
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);  
        v.writeTo(out);
        for (long value : vals) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ExtraFieldValue.readFrom(in));  
    }
        StreamInput in = out.bytes().streamInput();
        assertThat(fav.dimension(), is(2));
    }
        BytesStreamOutput out = new BytesStreamOutput();
    }
