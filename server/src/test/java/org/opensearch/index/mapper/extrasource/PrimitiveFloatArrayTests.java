        assertThat(read.isPackedLE(), is(false));  
        pfa.writePayloadTo(out);
        PrimitiveFloatArray read = PrimitiveFloatArray.readBodyFrom(in);  
 */  
        IllegalStateException e = expectThrows(IllegalStateException.class, pfa::packedBytes);  
        assertThat(read.asFloatArray().length, is(0));
        float[] vals = new float[0];  
 * The OpenSearch Contributors require contributions made to  
        float[] vals = new float[] { 10.5f, -2.25f, 0f, 123.75f };
        for (int i = 0; i < vals.length; i++) {
        assertThat(pfa.asFloatArray(), sameInstance(vals));  
    }
        assertThat(pfa.dimension(), is(vals.length));
        assertThat(pfa.asFloatArray(), sameInstance(vals));
    public void testEmptyArray() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        PrimitiveFloatArray pfa = new PrimitiveFloatArray(vals);  
    public void testPackedBytesThrows() {  
import org.opensearch.common.io.stream.BytesStreamOutput;
import static org.hamcrest.Matchers.sameInstance;
    public void testWriteReadRoundTrip() throws Exception {
        PrimitiveFloatArray pfa = new PrimitiveFloatArray(new float[] { 1.0f });
        assertThat(pfa.isPackedLE(), is(false));
import org.opensearch.test.OpenSearchTestCase;  
            assertEquals(vals[i], pfa.get(i), 0.0f);
        }  
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
        PrimitiveFloatArray pfa = new PrimitiveFloatArray(vals);
        BytesStreamOutput out = new BytesStreamOutput();  
/*  
        PrimitiveFloatArray pfa = new PrimitiveFloatArray(vals);
        assertThat(read.dimension(), is(vals.length));
    }
        assertThat(e.getMessage(), containsString("Not packed"));
package org.opensearch.index.mapper.extrasource;
        assertThat(read.dimension(), is(vals.length));
        // asFloatArray returns the same array instance (no copy)
        assertThat(pfa.dimension(), is(0));  
    }
        pfa.writePayloadTo(out);  
        StreamInput in = out.bytes().streamInput();  
        float[] vals = new float[] { 1.25f, -3.75f, 1000.0f };
    public void testBasics_dimensionGetAsArray() {  
}  
        assertThat(read.dimension(), is(0));  
        BytesStreamOutput out = new BytesStreamOutput();
        PrimitiveFloatArray read = PrimitiveFloatArray.readBodyFrom(in);
 * SPDX-License-Identifier: Apache-2.0
        assertThat(read.asFloatArray(), equalTo(vals));
    }  
public class PrimitiveFloatArrayTests extends OpenSearchTestCase {
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;  
import static org.hamcrest.Matchers.is;
        StreamInput in = out.bytes().streamInput();
 *
