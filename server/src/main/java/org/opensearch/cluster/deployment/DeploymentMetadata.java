import org.opensearch.core.common.io.stream.StreamOutput;  
        XContentParser.Token token;
            Deployment deployment = new Deployment(in);
    @Override
                Map<String, String> attributes = null;
import java.util.EnumSet;
        return TYPE;
    }
    }
    public static final String TYPE = "deployment";
    public Version getMinimalSupportedVersion() {
    }  
        return Metadata.API_AND_GATEWAY;
        for (int i = 0; i < size; i++) {  
        }
        return builder;
        if (this == o) return true;
            entry.getValue().toXContent(builder, params);
                while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
import org.opensearch.cluster.metadata.Metadata;
            entry.getValue().writeTo(out);
    public boolean equals(Object o) {  
        return deployments;  
 * The OpenSearch Contributors require contributions made to  
            deployments.put(id, deployment);  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                if ("deployments".equals(currentFieldName)) {
        Map<String, Deployment> deployments = new HashMap<>();  
 * @opensearch.internal  
/**  
    private final Map<String, Deployment> deployments;  
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
    public static DeploymentMetadata fromXContent(XContentParser parser) throws IOException {
                DeploymentState state = null;  
            }
    }
        return Objects.hash(deployments);  
                parser.nextToken();
            String id = in.readString();
        DeploymentMetadata that = (DeploymentMetadata) o;  
                        attributes = parser.mapStrings();  
        out.writeVInt(deployments.size());
        return Version.V_3_9_0;  
            }  
        Map<String, Deployment> deployments = new HashMap<>(size);
                    if ("state".equals(innerField)) {  
 *
            builder.field(entry.getKey());
    private static void parseDeployments(XContentParser parser, Map<String, Deployment> deployments) throws IOException {  
import org.opensearch.Version;
                if (state != null && attributes != null) {  
    public DeploymentMetadata(Map<String, Deployment> deployments) {
            if (token == XContentParser.Token.FIELD_NAME) {
        }  
        return new DeploymentMetadata(deployments);  
    }
    }  
        builder.startObject("deployments");
    }
    public EnumSet<Metadata.XContentContext> context() {
            out.writeString(entry.getKey());  
 *
                }
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.cluster.NamedDiff;  
import java.util.Objects;
                }  
    @Override
    @Override
        for (Map.Entry<String, Deployment> entry : deployments.entrySet()) {
        return readDiffFrom(Metadata.Custom.class, TYPE, in);
            if (token == XContentParser.Token.FIELD_NAME) {  
/*  
                String innerField;
        this.deployments = Collections.unmodifiableMap(deployments);
        builder.endObject();
        if (o == null || getClass() != o.getClass()) return false;
import java.util.Collections;  
                    parser.nextToken();
                    deployments.put(deploymentId, new Deployment(state, attributes));
    public void writeTo(StreamOutput out) throws IOException {  
    public Map<String, Deployment> getDeployments() {
 * compatible open source license.
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                String deploymentId = parser.currentName();
    public DeploymentMetadata(StreamInput in) throws IOException {  
                    parseDeployments(parser, deployments);
package org.opensearch.cluster.deployment;
    }  
        }
    @Override
    }  
        for (Map.Entry<String, Deployment> entry : deployments.entrySet()) {  
                currentFieldName = parser.currentName();
 * this file be licensed under the Apache-2.0 license or a
 * Cluster metadata that stores the set of active deployments.
 */
import java.io.IOException;
        }
 * SPDX-License-Identifier: Apache-2.0
                    } else if ("attributes".equals(innerField)) {
    @Override  
import org.opensearch.core.xcontent.XContentParser;  
    }
        XContentParser.Token token;
                        state = DeploymentState.fromString(parser.text());
    @Override  
    }
import java.util.Map;  
}
                    innerField = parser.currentName();
import org.opensearch.cluster.AbstractNamedDiffable;
        this.deployments = Collections.unmodifiableMap(Objects.requireNonNull(deployments));  
            } else if (token == XContentParser.Token.START_OBJECT) {  
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.HashMap;
    }
public class DeploymentMetadata extends AbstractNamedDiffable<Metadata.Custom> implements Metadata.Custom {
    public static NamedDiff<Metadata.Custom> readDiffFrom(StreamInput in) throws IOException {
        int size = in.readVInt();
        }
        String currentFieldName = null;
        return deployments.equals(that.deployments);
    public int hashCode() {
    }  
import org.opensearch.core.xcontent.ToXContent;
                }
                    }
 */  
    public String getWriteableName() {  
