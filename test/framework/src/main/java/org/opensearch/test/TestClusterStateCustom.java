        return true;  
    @Override
    @Override  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        return true;  
import org.opensearch.cluster.AbstractNamedDiffable;
        this.value = in.readString();
import org.opensearch.cluster.ClusterState;  
    }
import org.opensearch.Version;
    }
    }
    public boolean equals(Object o) {
import java.io.IOException;
    public void writeTo(StreamOutput out) throws IOException {
}
    }  
    protected TestClusterStateCustom(StreamInput in) throws IOException {  
    }
 *
    }
        return builder;
 */  
        this.value = value;  
package org.opensearch.test;
        if (this == o) return true;
        return value.hashCode();
 * this file be licensed under the Apache-2.0 license or a
    protected TestClusterStateCustom(String value) {
import org.opensearch.core.common.io.stream.StreamInput;
public abstract class TestClusterStateCustom extends AbstractNamedDiffable<ClusterState.Custom> implements ClusterState.Custom {
    public boolean isPrivate() {
        out.writeString(value);
import org.opensearch.core.common.io.stream.StreamOutput;
        if (!value.equals(that.value)) return false;
import org.opensearch.core.xcontent.XContentBuilder;  
    @Override  
        if (o == null || getClass() != o.getClass()) return false;  
/*  
    public int hashCode() {
    private final String value;  
 * compatible open source license.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    }  
    public Version getMinimalSupportedVersion() {
    @Override  
        return Version.CURRENT;  
    @Override
    }
        TestClusterStateCustom that = (TestClusterStateCustom) o;
