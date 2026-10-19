package org.opensearch.core.common.io.stream;
/** test the BytesReferenceStream using the same BaseStreamTests */
import java.io.IOException;  
    protected StreamInput getStreamInput(BytesReference bytesReference) throws IOException {
import org.opensearch.core.common.bytes.BytesReference;
/*  
 * compatible open source license.
    @Override
public class BytesReferenceStreamInputTests extends BaseStreamTests {  
 * this file be licensed under the Apache-2.0 license or a
}
 *
 * SPDX-License-Identifier: Apache-2.0
        return bytesReference.streamInput();  
 * The OpenSearch Contributors require contributions made to  
    }
 */  
