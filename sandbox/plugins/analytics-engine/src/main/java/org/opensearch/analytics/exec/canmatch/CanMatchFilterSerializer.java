 * repeat filterCount:  
        // and future fields appended to known types)
     * Unknown filter types are skipped (fail-open per filter).
            in.readBytes(skip, 0, remaining);
 * vInt   FORMAT_VERSION
            return Collections.emptyList();  
            out.writeVInt(filters.size());
 */  
import java.util.Collections;
     * Zero-length or null input produces an empty list.  
            filter.writeBody(tmp);
        if (remaining > 0) {
import org.opensearch.core.common.bytes.BytesReference;
 * <pre>  
    private static final Logger logger = LogManager.getLogger(CanMatchFilterSerializer.class);
                CanMatchFilter filter = readFilter(in);
 * </ul>
        String type = in.readString();
package org.opensearch.analytics.exec.canmatch;
    }
        };
import java.io.IOException;
 *   <li>Unknown FORMAT_VERSION → return empty list (fail-open, no pruning)</li>
 *
     * Empty or null list produces a zero-length array.  
                logger.debug("Unknown CanMatchFilter format version {}; returning empty (fail-open)", version);
import org.opensearch.core.common.io.stream.StreamInput;  
        int byteLength = in.readVInt();
 * SPDX-License-Identifier: Apache-2.0
        return filter;
 */
     * Serializes a list of filters to a byte array.
                yield null;  
        if (bytes == null || bytes.length == 0) {
        }  
            out.writeVInt(FORMAT_VERSION);
    private CanMatchFilterSerializer() {}
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            int version = in.readVInt();  
            out.writeBytes(BytesReference.toBytes(tmp.bytes()), 0, length);
        }
        }
     * Unknown format version produces an empty list (fail-open).
 * </pre>
            return filters;
        try (StreamInput in = new BytesArray(bytes).streamInput()) {
                if (filter != null) {  
 * the per-filter length-prefix + type-string wrapper that enables
    private static void writeFilter(BytesStreamOutput out, CanMatchFilter filter) throws IOException {
 * The OpenSearch Contributors require contributions made to  
            if (version != FORMAT_VERSION) {
     */
    private static final int FORMAT_VERSION = 1;  
        // Skip any remaining bytes for this filter (handles unknown types
            return new byte[0];
    }  
 * <ul>
    public static byte[] serialize(List<CanMatchFilter> filters) throws IOException {
                logger.debug("Unknown CanMatchFilter type '{}'; skipping (fail-open)", type);
        try (BytesStreamOutput tmp = new BytesStreamOutput()) {  
 *
        CanMatchFilter filter = switch (type) {
 * {@link CanMatchFilter#writeBody} and a static {@code readBody} factory.  
    }
    private static CanMatchFilter readFilter(StreamInput in) throws IOException {  
 *
    }
                }
            byte[] skip = new byte[remaining];  
                return Collections.emptyList();  
        }
import org.opensearch.common.io.stream.BytesStreamOutput;  
 * <p>Forward compatibility:  
            default -> {
 * <p>Each filter variant owns its body serialization via
import org.apache.logging.log4j.Logger;
 * Serializes and deserializes a list of {@link CanMatchFilter} instances
/*  
import org.opensearch.core.common.bytes.BytesArray;
 *   vInt    byteLength    (total bytes for this filter — enables skip on unknown type)
            for (int i = 0; i < count; i++) {
        int remaining = byteLength - bytesConsumed;
 *
 *
        if (filters == null || filters.isEmpty()) {  
                writeFilter(out, filter);
 *   string  type          ("LongRange", etc.)
 *   ...type-specific body fields (written by the filter's writeBody)...  
 * <p>Wire layout:
public final class CanMatchFilterSerializer {
                    filters.add(filter);
            tmp.writeString(filter.type());
        }
    public static List<CanMatchFilter> deserialize(byte[] bytes) throws IOException {
     * Deserializes a byte array back into a list of filters.
 * compatible open source license.
 * forward-compatible skipping of unknown types.  
}  
import org.apache.logging.log4j.LogManager;
            List<CanMatchFilter> filters = new ArrayList<>(count);  
            out.writeVInt(length);
 * this file be licensed under the Apache-2.0 license or a
            for (CanMatchFilter filter : filters) {  
            case LongRange.TYPE -> LongRange.readBody(in);  
 *   <li>Unknown type string → skip byteLength bytes, continue to next filter</li>  
        }
    /**
        int availableBefore = in.available();
 * @opensearch.internal  
            }  
            }
            int count = in.readVInt();
import java.util.List;
import java.util.ArrayList;  
            int length = tmp.size();  
/**
        int bytesConsumed = availableBefore - in.available();  
 * to/from a byte array for transport over the wire.  
 * This codec handles the list-level envelope: FORMAT_VERSION, count, and
            }
 * vInt   filterCount
            return BytesReference.toBytes(out.bytes());  
            }
     */  
    /**
