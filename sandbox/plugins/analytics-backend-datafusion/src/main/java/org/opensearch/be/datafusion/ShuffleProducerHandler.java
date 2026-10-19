            node.getHashKeyChannels(),
        CommonExecutionContext commonContext,
 * SPDX-License-Identifier: Apache-2.0
            node.getHashKeyChannels(),  
                    + " but "  
        );
    ) {
            node.getQueryId(),
                    + node.getTargetWorkerNodeIds().size()
            backendContext  
import org.opensearch.analytics.spi.ShuffleProducerOutputState;
            node.getTargetWorkerNodeIds(),
        BackendExecutionContext backendContext  
                    + node.getPartitionCount()
 * {@code ExchangeSinkProvider.createPartitionedSink} instead of the normal response handler.  
            "Shuffle producer handler: keys={}, partitions={}, targets={}, query={}, stage={}, side={}",  
        );
            node.getTargetWorkerNodeIds().size(),  
 * <p>Records the producer's partitioning + routing parameters into a  
            );  
 * compatible open source license.
 * <p>Composes with a previous handler's backend context: if {@code backendContext} is non-null  
    }
 *
                    + " target node ids; the planner must emit one target per partition"
        if (node.getTargetWorkerNodeIds().size() != node.getPartitionCount()) {
                "Shuffle producer instruction has partitionCount="
/*  
import org.opensearch.analytics.spi.FragmentInstructionHandler;
    @Override
        }
 * the framework layer would lock in DataFusion's hash and break a future Velox/Lucene producer.
 *
 */  
            node.getTargetStageId(),
import org.opensearch.analytics.spi.BackendExecutionContext;  
}  
 * because the hash function must match the consumer-side join's hasher. Wiring partitioning at  
            node.getPartitionCount(),
import org.apache.logging.log4j.Logger;
 * {@link ShuffleProducerOutputState} that the framework picks up after the instruction-handler
    private static final Logger LOGGER = LogManager.getLogger(ShuffleProducerHandler.class);  
    public BackendExecutionContext apply(  
        ShuffleProducerInstructionNode node,
 * chain. The framework then routes this fragment's engine output through
            node.getPartitionCount(),
package org.opensearch.be.datafusion;
        LOGGER.debug(
 * The OpenSearch Contributors require contributions made to  
 * <p>The handler itself does not partition — partitioning is the backend sink's responsibility,
            node.getQueryId(),  
import org.opensearch.analytics.spi.CommonExecutionContext;
public class ShuffleProducerHandler implements FragmentInstructionHandler<ShuffleProducerInstructionNode> {
 * Handler for {@link ShuffleProducerInstructionNode} on a scan-side data node.
        return new ShuffleProducerOutputState(
 * (e.g. session state set up by a prior handler), it is wrapped in the carrier so the engine
            node.getTargetStageId(),
 * this file be licensed under the Apache-2.0 license or a
            node.getSide(),
import org.apache.logging.log4j.LogManager;
 */  
import org.opensearch.analytics.spi.ShuffleProducerInstructionNode;  
            node.getSide()  
 *
 *
            throw new IllegalStateException(  
/**  
 * factory still receives it.
