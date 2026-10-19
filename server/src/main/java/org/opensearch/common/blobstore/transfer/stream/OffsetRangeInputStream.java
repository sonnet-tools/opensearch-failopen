/*  
import java.io.InputStream;
    }
package org.opensearch.common.blobstore.transfer.stream;
import java.util.concurrent.atomic.AtomicBoolean;  
 *
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import java.io.IOException;
 * OffsetRangeInputStream is an abstract class that extends from {@link InputStream}  
    public void setReadBlock(AtomicBoolean readBlock) {
 */
    public abstract long getFilePointer() throws IOException;  
public abstract class OffsetRangeInputStream extends InputStream {
 */  
 * @opensearch.internal  
        // Nothing  
 *
}
/**
 * and adds a method to get the file pointer to the specific part being read
