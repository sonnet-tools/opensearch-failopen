        }  
    protected StreamInput getStreamInput(BytesReference bytesReference) throws IOException {  
 * compatible open source license.
        int int1 = streamInput.read();
        ByteBuffer buffer = ByteBuffer.wrap(new byte[20]);  
        assertEquals(int1, streamInput.read());
    }
        };  
 * this file be licensed under the Apache-2.0 license or a
        StreamInput streamInput = filterStreamInputTests.getStreamInput(bytesReference);  
package org.opensearch.core.common.io.stream;
        buffer.rewind();
            buffer.put((byte) i);
    public void testMarkAndReset() throws IOException {  
public class FilterStreamInputTests extends BaseStreamTests {
import java.io.IOException;
        streamInput.read();
        assertEquals(int2, streamInput.read());
 * SPDX-License-Identifier: Apache-2.0
        BytesReference bytesReference = BytesReference.fromByteBuffer(buffer);
/** test the FilterStreamInput using the same BaseStreamTests */  
    }  
 *
 */  
        return new FilterStreamInput(StreamInput.wrap(br.bytes, br.offset, br.length)) {
        BytesRef br = bytesReference.toBytesRef();
import static org.hamcrest.Matchers.is;
import java.nio.ByteBuffer;
        assertThat(streamInput.markSupported(), is(true));
import org.apache.lucene.util.BytesRef;
 * The OpenSearch Contributors require contributions made to  
    @Override
        FilterStreamInputTests filterStreamInputTests = new FilterStreamInputTests();
import org.opensearch.core.common.bytes.BytesReference;
        streamInput.mark(-1);  
        int int2 = streamInput.read();
        for (int i = 0; i < buffer.limit(); i++) {
        streamInput.reset();  
}
/*  
