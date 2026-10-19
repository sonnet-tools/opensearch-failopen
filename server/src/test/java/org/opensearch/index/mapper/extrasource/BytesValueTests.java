import org.opensearch.core.common.bytes.BytesReference;
        BytesReference ref = new BytesArray(new byte[] { 9, 8, 7 });  
        assertThat(v.bytes().length(), is(4));
        BytesReference b = new BytesArray(all, 2, 4);
/*  
public class BytesValueTests extends OpenSearchTestCase {
import org.opensearch.core.common.bytes.BytesArray;  
    }  
    public void testWriteBodyToReadBodyFromRoundTrip_composite() throws Exception {
        assertThat(read, instanceOf(BytesValue.class));
        BytesStreamOutput out = new BytesStreamOutput();
import static org.hamcrest.Matchers.instanceOf;
        ExtraFieldValue read = ExtraFieldValue.readFrom(in);  
        BytesValue bv = (BytesValue) read;  
        assertThat(BytesReference.toBytes(read.bytes()), equalTo(all));
import static org.hamcrest.Matchers.equalTo;  
        v.writeTo(out); // writes [typeId][body]  
        BytesValue v = new BytesValue(new BytesArray(new byte[] { 10, 11 }));  
        BytesValue v = new BytesValue(ref);
 */  
        BytesReference a = new BytesArray(all, 0, 2);
        StreamInput in = out.bytes().streamInput();
    public void testTypeAndSize() {  
    }  
        assertThat(v.type(), is(ExtraFieldValue.Type.BYTES));  
 * compatible open source license.
        assertThat(read.size(), is(6));
        StreamInput in = out.bytes().streamInput();
        v.writeBodyTo(out);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.bytes.CompositeBytesReference;
    }  
        BytesRef bytesRef = read.bytes().toBytesRef();  
}
package org.opensearch.index.mapper.extrasource;
 *
        assertThat(bv.size(), is(2));
    }  
        BytesValue v = new BytesValue(new BytesArray(new byte[] { 1, 2, 3, 4 }));
        assertThat(v.size(), is(4));
    public void testWriteToReadFromRoundTrip_viaExtraFieldValueDispatch() throws Exception {
import org.opensearch.core.common.io.stream.StreamInput;  
        BytesReference composite = CompositeBytesReference.of(a, b);  
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(bytesRef.bytes[bytesRef.offset], is((byte) 9));
        StreamInput in = out.bytes().streamInput();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
        byte[] all = new byte[] { 1, 2, 3, 4, 5, 6 };  
import org.apache.lucene.util.BytesRef;
        BytesValue read = BytesValue.readBodyFrom(in);
        BytesValue v = new BytesValue(composite);
import static org.hamcrest.Matchers.is;
        assertThat(BytesReference.toBytes(bv.bytes()), equalTo(new byte[] { 10, 11 }));
        assertThat(read.size(), is(3));
    public void testWriteBodyToReadBodyFromRoundTrip_bytesArray() throws Exception {
import org.opensearch.common.io.stream.BytesStreamOutput;
 * The OpenSearch Contributors require contributions made to  
        assertThat(bytesRef.length, is(3));
        BytesStreamOutput out = new BytesStreamOutput();
        v.writeBodyTo(out);
        assertThat(read.type(), is(ExtraFieldValue.Type.BYTES));
        BytesValue read = BytesValue.readBodyFrom(in);
