     */
     * otherwise it can leak resources.  
     * @param partSize Size of all parts apart from the last one  
 * SPDX-License-Identifier: Apache-2.0
    private final long lastPartSize;
public class StreamContext {
    }  
        this.numberOfParts = numberOfParts;
package org.opensearch.common;
        return streamSupplier.apply(partNumber, size, position);
    public StreamContext(
        this.partSize = streamContext.partSize;  
     * Vendor plugins can use this method to create new streams only when they are required for processing  
    }  
     *
     *
     * Construct a new StreamProvider object  
}
/*  
    }
     * It is the responsibility of caller to ensure that stream is properly closed after consumption
/**
     * @param streamSupplier A {@link CheckedTriFunction} that will be called with the <code>partNumber</code>, <code>partSize</code> and <code>position</code> in the stream
 */  
     * @param numberOfParts Total number of parts
     * @return A stream reference to the part requested  
 * StreamContext is used to supply streams to vendor plugins using {@link StreamContext#provideStream}  
     * New streams won't be created till this method is called with the specific <code>partNumber</code>
     * Copy constructor for overriding class
        this.lastPartSize = streamContext.lastPartSize;
     */
    protected StreamContext(StreamContext streamContext) {
     */  
     * @param lastPartSize Size of the last part
     * @param partNumber The index of the part
 * @opensearch.internal
        CheckedTriFunction<Integer, Long, Long, InputStreamContainer, IOException> streamSupplier,
 * compatible open source license.
    /**
        long lastPartSize,
     * @return The number of parts in which this file is supposed to be uploaded  
        return numberOfParts;  
 * The OpenSearch Contributors require contributions made to  
        long position = partSize * partNumber;  
import org.opensearch.common.io.InputStreamContainer;
 */  
        this.lastPartSize = lastPartSize;  
    private final int numberOfParts;  
 *
        this.partSize = partSize;
        this.streamSupplier = streamContext.streamSupplier;
        long partSize,  
 * this file be licensed under the Apache-2.0 license or a
        int numberOfParts
    /**
     */  
        long size = (partNumber == numberOfParts - 1) ? lastPartSize : partSize;
        this.streamSupplier = streamSupplier;
    public int getNumberOfParts() {
 *
    private final CheckedTriFunction<Integer, Long, Long, InputStreamContainer, IOException> streamSupplier;  
    /**
        this.numberOfParts = streamContext.numberOfParts;
    private final long partSize;
    /**
    }
    public InputStreamContainer provideStream(int partNumber) throws IOException {
import java.io.IOException;  
    ) {  
