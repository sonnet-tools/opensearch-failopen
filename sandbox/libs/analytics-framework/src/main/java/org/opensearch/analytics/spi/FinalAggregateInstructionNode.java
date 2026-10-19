        // TODO: write config fields when added
 *
    public FinalAggregateInstructionNode(StreamInput in) throws IOException {  
    public InstructionType type() {
/*  
package org.opensearch.analytics.spi;
 */
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    public FinalAggregateInstructionNode() {}
 * compatible open source license.
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
    @Override
 */  
 * <p>TODO: add backend-specific config fields as final aggregate implementation is built out.
import org.opensearch.core.common.io.stream.StreamOutput;
public class FinalAggregateInstructionNode implements InstructionNode {
 * remove partial agg, preserve final-only for the driving backend's reduce execution.
    public void writeTo(StreamOutput out) throws IOException {
 *
        // TODO: read config fields when added
}
import org.opensearch.core.common.io.stream.StreamInput;
    }  
        return InstructionType.SETUP_FINAL_AGGREGATE;  
    @Override  
 * Instruction node for final aggregate in coordinator reduce — ExchangeSink path,
/**  
 * SPDX-License-Identifier: Apache-2.0
 *  
