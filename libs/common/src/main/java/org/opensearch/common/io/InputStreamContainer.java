     * @param contentLength The total content length that is to be read from the stream  
    private final long offset;  
     * @return offset of the source content.
import org.opensearch.common.annotation.ExperimentalApi;
    }
    /**
        this.contentLength = contentLength;
    /**
import java.io.InputStream;  
/*  
    public InputStream getInputStream() {
     *
public class InputStreamContainer {
     * @return The input stream this object is reading from  
package org.opensearch.common.io;
     */
    }  
     */
 */  
 * The OpenSearch Contributors require contributions made to  
    public InputStreamContainer(InputStream inputStream, long contentLength, long offset) {
    private final InputStream inputStream;
 */  
     * Construct a new stream object  
        return offset;
        return contentLength;
     */
}
     */  
    }
    public long getOffset() {
 * SPDX-License-Identifier: Apache-2.0
    }  
        this.offset = offset;
    /**  
/**
 * @opensearch.experimental
        return inputStream;  
    private final long contentLength;
 *
        this.inputStream = inputStream;  
 *
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
     * @param inputStream   The input stream that is to be encapsulated
 * Model composed of an input stream and the total content length of the stream  
    /**
     * @return The total length of the content that has to be read from this stream
    public long getContentLength() {  
@ExperimentalApi
