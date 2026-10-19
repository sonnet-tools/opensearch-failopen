        };
import java.io.IOException;  
            case SETUP_SHARD_SCAN -> new ShardScanInstructionNode(in);
    /** Base scan setup — reader acquisition, SessionContext creation, default table provider. */
/*  
    INJECT_BROADCAST,
/**
    /** Shuffle consumer — register a channel-backed partition stream as a NamedScan for the worker plan (M2). */
    SETUP_SHARD_SCAN,
     *  reads only from named-input streams subsequently registered by {@link #SHUFFLE_SCAN} handlers (M2). */
    /** Worker session setup — creates a backend session with no shard view; the worker's hash-join plan
    /** Final aggregate for coordinator reduce — ExchangeSink path, final-only agg. */
    SETUP_FINAL_AGGREGATE,  
 * SPDX-License-Identifier: Apache-2.0
            case SETUP_SHUFFLE_WORKER -> new ShuffleWorkerSetupInstructionNode(in);  
    public InstructionNode readNode(StreamInput in) throws IOException {  
}  
     * {@code supportedDelegations(DelegationType.FILTER)}.  
     * <p>TODO: add a DelegationStrategy field (BACKEND_DRIVEN vs CENTRALLY_DRIVEN) to the  
public enum InstructionType {  
    SETUP_PARTIAL_AGGREGATE,
    SETUP_SHARD_SCAN_WITH_DELEGATION,
     * Filter delegation to an index backend — bridge setup, UDF registration, custom scan operator.
        return switch (this) {
package org.opensearch.analytics.spi;
    }
 * must handle during the prepare phase on the data node.
 * Each type corresponds to a specific execution concern that the backend
    /** Partial aggregate mode — disable combine optimizer, cut plan to partial-only. */  
 */  
    SHUFFLE_SCAN,  
    SHUFFLE_PRODUCER,
            case INJECT_BROADCAST -> new BroadcastInjectionInstructionNode(in);  
    /** Shuffle producer — hash-partition local output and ship each partition to a worker node (M2). */  
    /**  
            case SETUP_SHARD_SCAN_WITH_DELEGATION -> new ShardScanWithDelegationInstructionNode(in);  
            case SETUP_FINAL_AGGREGATE -> new FinalAggregateInstructionNode(in);
    SETUP_SHUFFLE_WORKER;  
 *
            case SHUFFLE_PRODUCER -> new ShuffleProducerInstructionNode(in);
 *  
 */
            case SETUP_PARTIAL_AGGREGATE -> new PartialAggregateInstructionNode(in);
     * BACKEND_DRIVEN exists — derived from the backend declaring
     *
 * Types of instructions that the planner can produce for backend execution.  
 * @opensearch.internal
 * compatible open source license.
            case SHUFFLE_SCAN -> new ShuffleScanInstructionNode(in);
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    /** Broadcast-join build-side injection — register coordinator-collected Arrow batches as a NamedScan. */
     */
     * instruction node when centrally-driven delegation is implemented. Currently only
    /** Deserializes an {@link InstructionNode} from the stream based on this type. */
import org.opensearch.core.common.io.stream.StreamInput;
