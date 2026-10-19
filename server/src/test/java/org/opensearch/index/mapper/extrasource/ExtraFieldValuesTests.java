        assertThat(read.isEmpty(), is(false));
        );
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(-3.75f, fav.get(1), 0.0f);  
        assertThat(ExtraFieldValues.EMPTY.get("does_not_exist"), nullValue());
 * this file be licensed under the Apache-2.0 license or a
        ExtraFieldValue v1 = read.get("field_bytes");
        assertThat(lav.type(), is(ExtraFieldValue.Type.LONG_ARRAY));
        assertThat(ExtraFieldValues.EMPTY.values().isEmpty(), is(true));  
package org.opensearch.index.mapper.extrasource;
        assertThat(fav.dimension(), is(2));
    public void testConstructorCopiesAndIsImmutable() {
import static org.hamcrest.Matchers.nullValue;  
        assertThat(v5, instanceOf(DoubleArrayValue.class));
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(1.25f, fav.get(0), 0.0f);
}
        assertThat(read.values().isEmpty(), is(true));  
    public void testWriteReadRoundTrip() throws Exception {  
import org.opensearch.core.common.io.stream.StreamInput;  
        assertThat(v3, instanceOf(IntArrayValue.class));  
public class ExtraFieldValuesTests extends OpenSearchTestCase {
                "field_ints",
            Map.of(
        m.put("a", new BytesValue(new BytesArray(new byte[] { 1 })));  
                "field_longs",  
            )
        assertThat(lav.get(0), is(100L));  
        assertThat(dav.type(), is(ExtraFieldValue.Type.DOUBLE_ARRAY));  
 * compatible open source license.
        assertThat(read.values().keySet(), containsInAnyOrder("field_bytes", "field_vec", "field_ints", "field_longs", "field_doubles"));
        assertThat(iav.get(1), is(-20));
    }
        ExtraFieldValue v5 = read.get("field_doubles");  
 */  
        efv.writeTo(out);
                "field_vec",
        // Returned values map should be unmodifiable
                FloatArrayValue.fromFloatArray(new float[] { 1.25f, -3.75f }),  
        ExtraFieldValue v2 = read.get("field_vec");  
    }
        assertThat(v4, instanceOf(LongArrayValue.class));
    public void testStreamConstructorEmptyMap() throws Exception {
        expectThrows(UnsupportedOperationException.class, () -> read.values().put("x", new BytesValue(new BytesArray(new byte[] { 1 }))));
import static org.hamcrest.Matchers.instanceOf;
        assertThat(iav.type(), is(ExtraFieldValue.Type.INT_ARRAY));
        assertThat(iav.dimension(), is(2));  
                "field_doubles",
import java.util.HashMap;  
import java.util.Map;
        ExtraFieldValues efv = new ExtraFieldValues(
        StreamInput in = out.bytes().streamInput();
        assertThat(v1.size(), is(3));
import org.opensearch.test.OpenSearchTestCase;
        FloatArrayValue fav = (FloatArrayValue) v2;
        IntArrayValue iav = (IntArrayValue) v3;
        assertThat(fav.type(), is(ExtraFieldValue.Type.FLOAT_ARRAY));  
                IntArrayValue.fromIntArray(new int[] { 10, -20 }),
        Map<String, ExtraFieldValue> m = new HashMap<>();
    }
        assertThat(efv.get("b"), nullValue());  
        // Mutating original map must not affect efv (Map.copyOf)
        ExtraFieldValues read = new ExtraFieldValues(in);  
        ExtraFieldValues.EMPTY.writeTo(out);  
        m.put("b", new BytesValue(new BytesArray(new byte[] { 2 })));
        assertThat(v1.type(), is(ExtraFieldValue.Type.BYTES));  
                new BytesValue(new BytesArray(new byte[] { 9, 8, 7 })),
        assertThat(lav.get(1), is(-200L));
        assertThat(v2, instanceOf(FloatArrayValue.class));
                LongArrayValue.fromLongArray(new long[] { 100L, -200L }),
                DoubleArrayValue.fromDoubleArray(new double[] { 2.5d, -4.5d })  
        assertEquals(-4.5d, dav.get(1), 0.0d);  
        assertThat(ExtraFieldValues.EMPTY.isEmpty(), is(true));
        ExtraFieldValues efv = new ExtraFieldValues(m);
import org.opensearch.common.io.stream.BytesStreamOutput;
        DoubleArrayValue dav = (DoubleArrayValue) v5;
        ExtraFieldValues read = new ExtraFieldValues(in);
        assertEquals(2.5d, dav.get(0), 0.0d);
 * The OpenSearch Contributors require contributions made to  
        assertThat(read.isEmpty(), is(true));
        assertThat(lav.dimension(), is(2));
        BytesStreamOutput out = new BytesStreamOutput();
    }
import org.opensearch.core.common.bytes.BytesArray;
        StreamInput in = out.bytes().streamInput();
/*  
        ExtraFieldValue v4 = read.get("field_longs");
 *
        assertThat(v1, instanceOf(BytesValue.class));
import static org.hamcrest.Matchers.containsInAnyOrder;  
                "field_bytes",  
    public void testEmptySingleton() {
        LongArrayValue lav = (LongArrayValue) v4;  
        ExtraFieldValue v3 = read.get("field_ints");
        assertThat(dav.dimension(), is(2));
import static org.hamcrest.Matchers.is;
        assertThat(iav.get(0), is(10));
        expectThrows(UnsupportedOperationException.class, () -> efv.values().put("x", efv.get("a")));  
