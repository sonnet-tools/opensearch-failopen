            + ", build="
                (String) value.get("build_hash"),
    }
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
    }
        if (this == o) {
    public Version getVersion() {
        PARSER.declareString((response, value) -> response.clusterName = new ClusterName(value), new ParseField("cluster_name"));  
        PARSER.declareString((response, value) -> response.clusterUuid = value, new ParseField("cluster_uuid"));
            .field("number", build.getQualifiedVersion())
    }  
/*
 * not use this file except in compliance with the License.
    }
                buildType == null ? Build.Type.UNKNOWN : Build.Type.fromDisplayName(buildType, false),
    private static final ObjectParser<MainResponse, Void> PARSER = new ObjectParser<>(
    private String clusterUuid;
        return nodeName;
    public ClusterName getClusterName() {  
            .field("minimum_index_compatibility_version", version.minimumIndexCompatibilityVersion().toString())  
            + nodeName
            + "nodeName='"  
        this.clusterUuid = clusterUuid;  
        version = in.readVersion();
            + ", version="  
 * The OpenSearch Contributors require contributions made to  
            final String buildType = (String) value.get("build_type");
        }
import java.io.IOException;
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
    public static final String TAGLINE = "The OpenSearch Project: https://opensearch.org/";
    public String getClusterUuid() {
        return Objects.hash(nodeName, version, clusterUuid, build, clusterName);  
        return version;  
            .field("distribution", build.getDistribution())
 */  
        MainResponse::new
        }, (parser, context) -> parser.map(), new ParseField("version"));
    }  
            .field("build_snapshot", build.isSnapshot())  
        return clusterName;
            .field("lucene_version", version.luceneVersion.toString())
    private Build build;  
import org.opensearch.Version;
            && Objects.equals(version, other.version)
import org.opensearch.core.action.ActionResponse;
 *     http://www.apache.org/licenses/LICENSE-2.0
        out.writeBuild(build);  
package org.opensearch.action.main;
                /*  
                (String) value.get("distribution")  
 * SPDX-License-Identifier: Apache-2.0
        PARSER.declareObject((response, value) -> {  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
                 */  
    }
    MainResponse(StreamInput in) throws IOException {
 * The main response of opensearch
        this.version = version;
import org.opensearch.core.common.io.stream.StreamOutput;
            + '\''  
        this.build = build;
        builder.startObject("version")  
 * Licensed to Elasticsearch under one or more contributor  
    public static MainResponse fromXContent(XContentParser parser) {
        clusterName.writeTo(out);
            + clusterName  
    public void writeTo(StreamOutput out) throws IOException {
                 * Be lenient when reading on the wire, the enumeration values from other versions might be different than what
            + clusterUuid
import org.opensearch.core.xcontent.ToXContentObject;  
/*  
 */
        clusterUuid = in.readString();
 * compatible open source license.
        super(in);  
        builder.field("cluster_uuid", clusterUuid);
            .field("build_hash", build.hash())
    private ClusterName clusterName;
    public MainResponse(String nodeName, Version version, ClusterName clusterName, String clusterUuid, Build build) {
/*  
 * @opensearch.internal
 *  
    private Version version;  
            response.build = new Build(
            );
            return true;  
        PARSER.declareString((response, value) -> {}, new ParseField("tagline"));
public class MainResponse extends ActionResponse implements ToXContentObject {  
    }  
        builder.startObject();
    );
}
    public Build getBuild() {
    }
        }
 *  
 */  
                (String) value.get("build_date"),  
    }
import org.opensearch.Build;
    public int hashCode() {
            .field("build_date", build.date())
 *
    @Override
        out.writeString(clusterUuid);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        PARSER.declareString((response, value) -> response.nodeName = value, new ParseField("name"));
            );
        builder.field("cluster_name", clusterName.value());
            + version
 * GitHub history for details.
            .field("build_type", build.type().displayName())  
            + '}';  
            + ", clusterName="
import org.opensearch.core.ParseField;
 */
        builder.field("tagline", TAGLINE);
import org.opensearch.core.common.io.stream.StreamInput;  
    }
        return PARSER.apply(parser, null);  
            .field("minimum_wire_compatibility_version", version.minimumCompatibilityVersion().toString())
        this.clusterName = clusterName;
                (String) value.get("number"),
        build = in.readBuild();
        out.writeVersion(version);  
    static {
    @Override  
        builder.field("name", nodeName);  
            && Objects.equals(clusterUuid, other.clusterUuid)
        MainResponse other = (MainResponse) o;
 * Modifications Copyright OpenSearch Contributors. See
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
            + build
    }
        return build;  
        return Objects.equals(nodeName, other.nodeName)  
        if (o == null || getClass() != o.getClass()) {
        return builder;
    @Override  
            + '\''
            response.version = Version.fromString(
import org.opensearch.core.xcontent.ObjectParser;
    }  
        this.nodeName = nodeName;  
                (boolean) value.get("build_snapshot"),
        builder.endObject();  
            + ", clusterUuid='"
    public String getNodeName() {
        true,  
            && Objects.equals(clusterName, other.clusterName);
            return false;  
 * software distributed under the License is distributed on an
 *
import java.util.Objects;
 * this work for additional information regarding copyright
    @Override  
    MainResponse() {}  
        return "MainResponse{"
            && Objects.equals(build, other.build)  
/**
                ((String) value.get("number")).replace("-SNAPSHOT", "").replaceFirst("-(alpha\\d+|beta\\d+|rc\\d+)", "")  
import org.opensearch.core.xcontent.XContentBuilder;
        nodeName = in.readString();
 * under the License.  
                 * we know.
    }
        out.writeString(nodeName);
 * ownership. Elasticsearch licenses this file to you under  
        MainResponse.class.getName(),
    public boolean equals(Object o) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ClusterName;  
        return clusterUuid;
        clusterName = new ClusterName(in);  
            .endObject();
    private String nodeName;
    public String toString() {
    @Override  
