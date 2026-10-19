     *
import org.opensearch.common.annotation.PublicApi;
    }  
 * compatible open source license.
/*  
     * The name to register the compressor by
    }
import java.io.InputStream;
    public static final String NAME = "NONE";  
    }
    public InputStream threadLocalInputStream(InputStream in) throws IOException {
    @Override
}
 * The OpenSearch Contributors require contributions made to  
    /**  
    }  
    public BytesReference compress(BytesReference bytesReference) throws IOException {
public class NoneCompressor implements Compressor {
    public int headerLength() {
     */
        return out;
    @Override  
        return bytesReference;  
 * this file be licensed under the Apache-2.0 license or a
 *
 *
/**
 * {@link Compressor} no compressor implementation.  
    @PublicApi(since = "2.10.0")
    @Override
 * SPDX-License-Identifier: Apache-2.0
    @Override
        return false;
    }
import java.io.IOException;
    public OutputStream threadLocalOutputStream(OutputStream out) throws IOException {  
    public boolean isCompressed(BytesReference bytes) {  
 * @opensearch.experimental - class methods might change  
    @Override  
    public BytesReference uncompress(BytesReference bytesReference) throws IOException {
        return bytesReference;
     * @opensearch.api - requires BWC support  
 * @opensearch.api - registered name requires BWC support
import org.opensearch.core.common.bytes.BytesReference;
    @Override
    }
        return in;
 */  
package org.opensearch.core.compress;
        return 0;  
import java.io.OutputStream;  
 */
