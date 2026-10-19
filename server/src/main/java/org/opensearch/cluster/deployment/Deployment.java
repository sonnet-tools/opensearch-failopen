        return nodeAttributes;
    }
import org.opensearch.core.common.io.stream.StreamInput;
    }  
import java.util.Collections;
    @Override
        out.writeMap(nodeAttributes, StreamOutput::writeString, StreamOutput::writeString);
    private final DeploymentState state;
        this.state = Objects.requireNonNull(state);
        builder.startObject();  
 * Represents a single deployment operation with a target state and node attributes.
    public Map<String, String> getNodeAttributes() {  
    public Deployment(StreamInput in) throws IOException {  
    }
/**  
        this.nodeAttributes = Collections.unmodifiableMap(in.readMap(StreamInput::readString, StreamInput::readString));
package org.opensearch.cluster.deployment;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        this.state = DeploymentState.readFrom(in);
    public void writeTo(StreamOutput out) throws IOException {  
import java.util.Map;  
        this.nodeAttributes = Collections.unmodifiableMap(Objects.requireNonNull(nodeAttributes));  
        state.writeTo(out);
    }  
        return state;  
import org.opensearch.core.common.io.stream.Writeable;  
/*  
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;
public class Deployment implements Writeable, ToXContentObject {
        return builder;
import java.util.Objects;
    }
        Deployment that = (Deployment) o;
 * @opensearch.internal  
        if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.core.xcontent.XContentBuilder;
        builder.field("attributes", nodeAttributes);
    }
    private final Map<String, String> nodeAttributes;
 * compatible open source license.
        return Objects.hash(state, nodeAttributes);
    public int hashCode() {
    }  
    @Override  
    @Override
}
    public Deployment(DeploymentState state, Map<String, String> nodeAttributes) {
 * this file be licensed under the Apache-2.0 license or a
        builder.field("state", state.name());
 */
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
    public boolean equals(Object o) {
        if (this == o) return true;  
        builder.endObject();  
        return state == that.state && nodeAttributes.equals(that.nodeAttributes);  
 *
    public DeploymentState getState() {
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContentObject;
    @Override
