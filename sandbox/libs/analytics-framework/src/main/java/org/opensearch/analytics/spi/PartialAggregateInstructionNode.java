    }  
 */  
}  
 * compatible open source license.
import java.io.IOException;
 *
/*  
        return InstructionType.SETUP_PARTIAL_AGGREGATE;
/**  
    @Override
    public InstructionType type() {
public class PartialAggregateInstructionNode implements InstructionNode {
 *
        // TODO: read config fields when added  
 * <p>TODO: add backend-specific config fields as partial aggregate implementation is built out.  
package org.opensearch.analytics.spi;
    }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        // TODO: write config fields when added
 * SPDX-License-Identifier: Apache-2.0
    @Override  
 *
 */  
    public PartialAggregateInstructionNode(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
    public void writeTo(StreamOutput out) throws IOException {  
 * @opensearch.internal
 * Instruction node for partial aggregate mode — disable combine optimizer, cut plan to partial-only.
    public PartialAggregateInstructionNode() {}  
    }
import org.opensearch.core.common.io.stream.StreamInput;
