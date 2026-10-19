        PackedFloatArray read = PackedFloatArray.readBodyFrom(in, vals.length);
        pfa.writePayloadTo(out);
        arr[off + 1] = (byte) (bits >>> 8);  
        BytesReference b = new BytesArray(segB);
        StreamInput in = out.bytes().streamInput();
    }
import static org.hamcrest.Matchers.containsString;
        // Trigger ensureBytes() via get()  
        PackedFloatArray pfa = PackedFloatArray.fromPackedArray(packLE(vals), vals.length);  
import static org.hamcrest.Matchers.sameInstance;
            assertEquals("mismatch at i=" + i, vals[i], pfa.get(i), 0.0f);
    public void testFromPackedBytes_bytesArraySliceUsesUnderlyingArrayWithoutCompaction() {
        float[] b = pfa.asFloatArray();
        assertThat(pfa.isPackedLE(), is(true));
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;  
        arr[off + 3] = (byte) (bits >>> 24);
        final float[] vals = new float[] { 1.25f, 2.5f, -3.75f };
        final byte[] packed = packLE(vals);  
        expectThrows(IndexOutOfBoundsException.class, () -> pfa.get(-1));
        assertEquals(vals[0], pfa.get(0), 0.0f);
        final float[] vals = new float[] { 10.5f, -2.25f, 0f, 123.75f };
        }
 */  
        PackedFloatArray pfa = PackedFloatArray.fromPackedArray(packLE(vals), vals.length);
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.core.common.bytes.CompositeBytesReference;
        assertThat(b, sameInstance(a));  
    public void testAsFloatArrayIsCachedSameInstance() {
    // 'cached' is used
import org.opensearch.core.common.bytes.BytesReference;  
        final byte[] packed = packLE(vals);  
        return bb.array();  
    private static void writeFloatLE(byte[] arr, int off, float v) {  
        BytesReference composite = CompositeBytesReference.of(a, b);
        float[] vals = new float[] { 1f, 2f };
        assertEquals(vals[0], pfa.get(0), 0.0f);  
        float[] vals = new float[] { 1f, 2f, 3f };  
 * compatible open source license.
        assertThat(a, equalTo(vals));
        assertThat(e.getMessage(), containsString("Bad packed float length"));  
import org.opensearch.common.io.stream.BytesStreamOutput;
public class PackedFloatArrayTests extends OpenSearchTestCase {
    }
        final byte[] backing = new byte[packed.length + 17];
    public void testValidateThrowsOnBadLength() {  
    }
        BytesReference ref = new BytesArray(backing, off, packed.length);  
        final int off = 7;  
        assertEquals(vals[2], pfa.get(2), 0.0f);
        // Split into two segments and wrap as CompositeBytesReference
        expectThrows(IndexOutOfBoundsException.class, () -> pfa.get(2));
        int bits = Float.floatToRawIntBits(v);
import static org.hamcrest.Matchers.is;
 * The OpenSearch Contributors require contributions made to  
        assertThat(read.asFloatArray(), equalTo(vals));  
/*  
    }  
        assertThat(pfa.dimension(), is(vals.length));  
    }
        float mutated = 7.25f;  
        float mutated = 9.5f;
        // cached path should keep returning correct values  
        byte[] segB = new byte[packed.length - mid];
    public void testFromPackedBytes_compositeMaterializesOnceAndDecodesCorrectly() {
        }
        ByteBuffer bb = ByteBuffer.allocate(vals.length * 4).order(ByteOrder.LITTLE_ENDIAN);
        float[] vals = new float[] { 10.5f, -2.25f, 0f, 123.75f };
    // ---- helpers ----
        assertEquals(vals[0], pfa.get(0), 0.0f);  
        byte[] bad = new byte[7]; // not divisible by 4, and not dim*4
        writeFloatLE(backing, off, mutated);  
    }  
        BytesStreamOutput out = new BytesStreamOutput();  
        assertThat(pfa.asFloatArray(), equalTo(vals));
        assertEquals(mutated, pfa.get(0), 0.0f);
        PackedFloatArray pfa = PackedFloatArray.fromPackedArray(packLE(vals), vals.length);
        for (int i = 0; i < vals.length; i++) {  
        byte[] segA = new byte[mid];
        arr[off + 2] = (byte) (bits >>> 16);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;  
        BytesReference a = new BytesArray(segA);  
        PackedFloatArray pfa = PackedFloatArray.fromPackedBytes(composite, vals.length);
        int mid = packed.length / 2;  
        // read payload back  
        assertEquals(vals[1], pfa.get(1), 0.0f);  
        final float[] vals = new float[] { 0.5f, 1.5f, 2.5f, 3.5f, -4.5f };
    public void testGetBoundsChecks() {  
        PackedFloatArray pfa = PackedFloatArray.fromPackedBytes(ref, vals.length);
        System.arraycopy(packed, 0, segA, 0, mid);  
}
package org.opensearch.index.mapper.extrasource;
    private static byte[] packLE(float[] vals) {
    public void testFromPackedArray_getAndAsFloatArray() {  
        final byte[] packed = packLE(vals);
    }
 *
    public void testWriteReadRoundTrip() throws Exception {
        writeFloatLE(segA, 0, mutated);
        assertEquals(vals[2], pfa.get(2), 0.0f);
        arr[off] = (byte) bits;
import org.opensearch.core.common.io.stream.StreamInput;
        System.arraycopy(packed, mid, segB, 0, segB.length);
            bb.putFloat(v);
    }
        System.arraycopy(packed, 0, backing, off, packed.length);
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PackedFloatArray.fromPackedArray(bad, 2));
        for (float v : vals) {  
        PackedFloatArray pfa = PackedFloatArray.fromPackedArray(packed, vals.length);
import java.nio.ByteBuffer;
        float[] a = pfa.asFloatArray();  
        assertThat(dim, equalTo(vals.length));  
        assertThat(pfa.asFloatArray(), equalTo(vals));
import java.nio.ByteOrder;  
        // write payload
        int dim = in.readVInt();
