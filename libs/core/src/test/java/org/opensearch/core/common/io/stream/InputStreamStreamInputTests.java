/** test the InputStreamStreamInput using the same BaseStreamTests */  
    protected StreamInput getStreamInput(BytesReference bytesReference) throws IOException {  
    @Override
 * The OpenSearch Contributors require contributions made to  
 */  
        BytesRef br = bytesReference.toBytesRef();
package org.opensearch.core.common.io.stream;
    }  
 * compatible open source license.
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
        return new InputStreamStreamInput(StreamInput.wrap(br.bytes, br.offset, br.length));
public class InputStreamStreamInputTests extends BaseStreamTests {
 *
import org.opensearch.core.common.bytes.BytesReference;
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.BytesRef;
}
