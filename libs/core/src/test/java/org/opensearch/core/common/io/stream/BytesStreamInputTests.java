 * this file be licensed under the Apache-2.0 license or a
 *
/** test the BytesStreamInput using the same BaseStreamTests */  
}
 * The OpenSearch Contributors require contributions made to  
/*  
import java.io.IOException;
package org.opensearch.core.common.io.stream;
        BytesRef br = bytesReference.toBytesRef();
import org.opensearch.core.common.bytes.BytesReference;
    protected StreamInput getStreamInput(BytesReference bytesReference) throws IOException {  
 */  
import org.apache.lucene.util.BytesRef;
 * compatible open source license.
    @Override
    }  
 * SPDX-License-Identifier: Apache-2.0
public class BytesStreamInputTests extends BaseStreamTests {
        return new BytesStreamInput(br.bytes, br.offset, br.length);
