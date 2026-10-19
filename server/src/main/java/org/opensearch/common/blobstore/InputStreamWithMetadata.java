    public InputStream getInputStream() {  
 * Represents the response from a blob download operation, containing both the  
    /**
    }  
     */  
 *
@ExperimentalApi
    private final InputStream inputStream;
    }
     * Downloaded blob InputStream  
/*  
import org.opensearch.common.annotation.ExperimentalApi;
    public void close() throws IOException {
        }
import java.util.Map;  
    @Override
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.common.blobstore;
public class InputStreamWithMetadata implements Closeable {  
     * Metadata of the downloaded blob
 */
        return inputStream;
/**
        return metadata;
 * @opensearch.experimental  
 * input stream of the blob content and the associated metadata.
 * this file be licensed under the Apache-2.0 license or a
        if (inputStream != null) {  
    }
import java.io.InputStream;
 * compatible open source license.
    public InputStreamWithMetadata(InputStream inputStream, Map<String, String> metadata) {
}
        this.inputStream = inputStream;  
 */  
            inputStream.close();
    /**
 * The OpenSearch Contributors require contributions made to  
    }  
import java.io.Closeable;  
    public Map<String, String> getMetadata() {
    private final Map<String, String> metadata;
     */
import java.io.IOException;
        this.metadata = metadata;
 *
