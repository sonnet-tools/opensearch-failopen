/**
 * filter) is handled by {@link CanMatchFilterSerializer}.
 * body via {@link #writeBody} and a static {@code readBody} factory.
    void writeBody(StreamOutput out) throws IOException;
 * compatible open source license.
 *
 */  
    /** Serialize this filter's type-specific fields (not the type string or length prefix). */
import org.opensearch.core.common.io.stream.StreamOutput;
 * <p>Each variant is responsible for serializing/deserializing its own
 * @opensearch.internal  
 *
    /** Type string written to the wire for dispatch on deserialization. */
}  
 * The OpenSearch Contributors require contributions made to  
 * Each variant carries only what the data node needs to check row-group
 *  
 * The list-level envelope (FORMAT_VERSION, count, length-prefix per  
package org.opensearch.analytics.exec.canmatch;
public interface CanMatchFilter {
 * this file be licensed under the Apache-2.0 license or a
 * A lightweight predicate representation for can-match evaluation.  
    String type();
/*  
 * statistics — column name plus type-specific bounds.
 */
    String column();
    /** The column this filter targets. */
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
