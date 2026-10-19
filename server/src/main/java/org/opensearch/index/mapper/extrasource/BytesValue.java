    static BytesValue readBodyFrom(StreamInput in) throws IOException {
 * <p>Used to store raw byte content as part of {@link ExtraFieldValue}.</p>
    }
 */  
        out.writeBytesReference(bytes);
 * A binary value backed by a {@link BytesReference}.
 * compatible open source license.
 */
        return new BytesValue(in.readBytesReference());
import java.io.IOException;
package org.opensearch.index.mapper.extrasource;
 *  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.core.common.bytes.BytesReference;
/**
    }  
public record BytesValue(BytesReference bytes) implements ExtraFieldValue {  
    public int size() {
    public void writeBodyTo(StreamOutput out) throws IOException {  
import org.opensearch.core.common.io.stream.StreamInput;
    }  
        return Type.BYTES;  
}
    }
 *
 * The OpenSearch Contributors require contributions made to  
    public Type type() {
    @Override
 * SPDX-License-Identifier: Apache-2.0
/*  
        return bytes.length();
    @Override
