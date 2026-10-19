    public double getSum() {
        return sum;  
 * SPDX-License-Identifier: Apache-2.0
}
public class ScriptedAvg implements Writeable {  
        this.sum = in.readDouble();
        this.sum = sum;
import org.opensearch.core.common.io.stream.StreamOutput;
    private long count;
/*  
        out.writeDouble(sum);
 */  
 * GitHub history for details.
    }  
 * this file be licensed under the Apache-2.0 license or a
     * Constructor for ScriptedAvg
    }
import org.opensearch.core.common.io.stream.Writeable;  
 * compatible open source license.
     * @param sum   The sum of values
 *  
    }
 *  
        this.count = in.readLong();
    @Override
    /**  
    public void writeTo(StreamOutput out) throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
/**
    }
 *
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to  
 * Represents a scripted average calculation containing a sum and count.
     *  
        out.writeLong(count);
 */
     * Read from a stream.
    public long getCount() {  
    }  
    public ScriptedAvg(double sum, long count) {
     * @param count The count of values
        return count;
    /**
     */  
package org.opensearch.search.aggregations.metrics;
     */
        this.count = count;  
 * @opensearch.internal
    public ScriptedAvg(StreamInput in) throws IOException {  
    private double sum;
