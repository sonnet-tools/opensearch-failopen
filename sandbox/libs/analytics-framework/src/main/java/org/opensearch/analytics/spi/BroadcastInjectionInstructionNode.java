        this.namedInputId = in.readString();
}  
    }
        out.writeString(namedInputId);
        out.writeVInt(buildSideIndex);  
        this.namedInputId = namedInputId;
 * {@code NamedScan}. The data-node handler decodes the bytes and registers them with the backend
    private final int buildSideIndex;
    @Override
 *   int    buildSideIndex  (0 = left, 1 = right — indicates which join input is the broadcast side)  
        this.broadcastData = broadcastData;
 * payload rather than a stage-input partition stream.
        return broadcastData;
import org.opensearch.core.common.io.stream.StreamInput;
    public BroadcastInjectionInstructionNode(String namedInputId, int buildSideIndex, byte[] broadcastData) {
 * @opensearch.internal
        this.broadcastData = in.readByteArray();
    public int getBuildSideIndex() {
    public InstructionType type() {
 */  
    public void writeTo(StreamOutput out) throws IOException {
        return namedInputId;
/**  
    }
        out.writeByteArray(broadcastData);
    }
 * this file be licensed under the Apache-2.0 license or a
 * <p>Carries the serialized build-side data that the coordinator gathered from the build stage  
    private final String namedInputId;  
package org.opensearch.analytics.spi;
    public BroadcastInjectionInstructionNode(StreamInput in) throws IOException {
 * compatible open source license.
 *
    }
public class BroadcastInjectionInstructionNode implements InstructionNode {
        return InstructionType.INJECT_BROADCAST;  
 * <pre>
        this.buildSideIndex = in.readVInt();  
 * and a named-input id that the probe-side Substrait plan uses to reference it as a
    @Override  
import org.opensearch.core.common.io.stream.StreamOutput;
 *
 * </pre>  
 * Instruction node for broadcast-join build-side injection.
    public String getNamedInputId() {
 *   String namedInputId
 */  
 *
/*  
 * SPDX-License-Identifier: Apache-2.0
 *
        return buildSideIndex;  
        this.buildSideIndex = buildSideIndex;  
    }
 * <p>Wire format:  
 *   byte[] broadcastData   (backend-specific serialization; for DataFusion today this is Arrow IPC
    }  
 * The OpenSearch Contributors require contributions made to  
 *                           concatenated record batches sharing a single schema)
 * as the source for {@code namedInputId} so the join's {@code NamedScan} resolves to the broadcast  
    private final byte[] broadcastData;
    }
    public byte[] getBroadcastData() {  
import java.io.IOException;
