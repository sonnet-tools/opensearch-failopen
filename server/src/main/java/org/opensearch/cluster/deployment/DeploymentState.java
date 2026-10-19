 * compatible open source license.
 *
        out.writeString(name());  
}
import java.io.IOException;
    public static DeploymentState fromString(String state) {
    }
 * this file be licensed under the Apache-2.0 license or a
        return valueOf(state.toUpperCase(Locale.ROOT));  
 * Represents the state of a deployment operation.  
 */  
    @Override
/*  
 * @opensearch.internal
/**
    }
    public static DeploymentState readFrom(StreamInput in) throws IOException {  
public enum DeploymentState implements Writeable {
 *
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
    FINISH;  
        return fromString(in.readString());
    DRAIN,
import org.opensearch.core.common.io.stream.StreamInput;
 */  
    public void writeTo(StreamOutput out) throws IOException {
package org.opensearch.cluster.deployment;
import org.opensearch.core.common.io.stream.Writeable;  
import java.util.Locale;  
 * The OpenSearch Contributors require contributions made to  
