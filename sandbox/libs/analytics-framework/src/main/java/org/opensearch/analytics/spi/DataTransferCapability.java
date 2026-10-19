 *
    public enum Kind {  
 * {@code "arrow-ipc-partitioned"} meaning "each partition's rows are shipped as Arrow IPC bytes";  
        PRODUCER,
     */
/*  
 * column-batch wire representation).
 */  
 * compatible open source license.
}  
 * Declares a backend's ability to produce or consume a shuffle-partitioned data transfer.
        /** Backend can partition a local stream and ship partitions to remote consumers. */
 * <p>Formats in M2 are backend-specific strings — e.g. DataFusion declares
     * Direction of a data-transfer capability — declares whether the backend produces or  
 * capabilities to pick a serialization format the two sides agree on. A single backend typically
 * a Velox-backed analytics backend could declare {@code "velox-native-serde"} (preserving Velox's
 *
/**
package org.opensearch.analytics.spi;
    /**
 * declares both {@link Kind#PRODUCER} and {@link Kind#CONSUMER} for the same format.  
     * consumes the transfer format. A single backend may declare both for the same format.
 * this file be licensed under the Apache-2.0 license or a
 */
    }
 *  
        CONSUMER
 * <p>For hash-shuffle join the planner must intersect producer-side capabilities with consumer-side
 * SPDX-License-Identifier: Apache-2.0
public record DataTransferCapability(Kind kind, String format) {  
 *  
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
        /** Backend can receive partitioned input streams and feed them into a worker plan. */  
