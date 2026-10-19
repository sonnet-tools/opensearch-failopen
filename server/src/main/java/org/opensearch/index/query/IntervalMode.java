import java.io.IOException;
        for (IntervalMode mode : IntervalMode.values()) {
    IntervalMode(int ordinal) {
        }
package org.opensearch.index.query;
 *
    @Override  
    ORDERED(0),
    }  
    }
 * Mode for Text and Mapped Field Types
        if (intervalMode == null) {  
        }
        this.ordinal = ordinal;
                return mode;  
 * this file be licensed under the Apache-2.0 license or a
        switch (ord) {
            case (0):
@PublicApi(since = "1.0.0")
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.OpenSearchException;
            throw new IllegalArgumentException("cannot parse mode from null string");
        int ord = in.readVInt();  
        out.writeVInt(this.ordinal);
    }
                return UNORDERED;
    public static IntervalMode readFromStream(StreamInput in) throws IOException {
            case (1):
    UNORDERED_NO_OVERLAP(2);  
    UNORDERED(1),
            }
    private final int ordinal;
 * @opensearch.api  
    public void writeTo(StreamOutput out) throws IOException {
        throw new OpenSearchException("unknown serialized type [" + ord + "]");  
 * compatible open source license.
public enum IntervalMode implements Writeable {  
 * The OpenSearch Contributors require contributions made to  
/**  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.io.stream.StreamOutput;
}
            case (2):  
            if (mode.name().equalsIgnoreCase(intervalMode)) {
        }
 */  
    }  
                return UNORDERED_NO_OVERLAP;
import org.opensearch.core.common.io.stream.Writeable;
    public static IntervalMode fromString(String intervalMode) {
                return ORDERED;  
import org.opensearch.core.common.io.stream.StreamInput;  
/*  
        throw new IllegalArgumentException("no mode can be parsed from ordinal " + intervalMode);  
 */
 *
