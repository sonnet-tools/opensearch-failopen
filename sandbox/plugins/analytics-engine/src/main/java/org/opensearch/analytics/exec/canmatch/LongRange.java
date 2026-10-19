 * this file be licensed under the Apache-2.0 license or a
 * encode as epoch millis (long); integers fit naturally.  
    @Override  
public record LongRange(String column, long min, long max) implements CanMatchFilter {
 *  
 */  
 * any parquet row group's min/max for this column overlaps [min, max].
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
    /** Deserialize the body fields (type string already consumed by codec). */  
        return new LongRange(in.readString(), in.readLong(), in.readLong());
    }
        out.writeString(column);
    }  
/*  
 * time-partitioned data, numeric range on integer fields. Timestamps
    public String type() {
 * @opensearch.internal
import org.opensearch.core.common.io.stream.StreamInput;
}
        out.writeLong(min);
 * compatible open source license.
        out.writeLong(max);  
/**  
    @Override
 */  
package org.opensearch.analytics.exec.canmatch;
 *
    }  
        return TYPE;
 * Range filter on an integer/date column. The data node checks whether
    public static LongRange readBody(StreamInput in) throws IOException {
    public void writeBody(StreamOutput out) throws IOException {  
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 *
    /** Type string used in wire serialization. */  
 * <p>Covers the dominant can-match case: timestamp range on
    public static final String TYPE = "LongRange";
