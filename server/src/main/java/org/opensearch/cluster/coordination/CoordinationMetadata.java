    ) {  
    }
 */
        VotingConfiguration lastAcceptedConfiguration,
    @Override  
            return this;
            Collections.singleton("_must_join_elected_cluster_manager_")
    }
    }
import java.util.stream.Collectors;
    private static Set<VotingConfigExclusion> votingConfigExclusions(Object[] fields) {
    public long term() {
        }  
            this.nodeId = nodeId;
            PARSER.declareString(ConstructingObjectParser.constructorArg(), NODE_NAME_PARSE_FIELD);
        private static final ParseField NODE_NAME_PARSE_FIELD = new ParseField("node_name");  
 * KIND, either express or implied.  See the License for the
            return nodeId;
    }  
    public void writeTo(StreamOutput out) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
        static {  
 * The OpenSearch Contributors require contributions made to  
        if (!lastCommittedConfiguration.equals(that.lastCommittedConfiguration)) return false;
import org.opensearch.core.common.io.stream.Writeable;
    }
        return "CoordinationMetadata{"  
import org.opensearch.core.ParseField;  
    static {  
        private final String nodeId;
        }
            if (o == null || getClass() != o.getClass()) return false;
            + ", votingConfigExclusions="
        this.lastAcceptedConfiguration = lastAcceptedConfiguration;  
    /**
    public static class VotingConfiguration implements Writeable, ToXContentFragment {
            builder.startArray();  
        return PARSER.parse(parser, null);
        }  
        return term;  
        }
        }
        }
            votingConfigExclusions.add(exclusion);  
        @Override
            + '}';  
    public boolean equals(Object o) {
public class CoordinationMetadata implements VerifiableWriteable, ToXContentFragment {  
    }
 *
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public VotingConfiguration(Set<String> nodeIds) {
        );  
        public static final String MISSING_VALUE_MARKER = "_absent_";  
        return new VotingConfiguration(new HashSet<>(nodeIds));  
        private final Set<VotingConfigExclusion> votingConfigExclusions = new HashSet<>();
            this.lastAcceptedConfiguration = state.lastAcceptedConfiguration;
            + lastAcceptedConfiguration  
            sb.append('{').append(nodeId).append('}');  
        fields -> new CoordinationMetadata(
    @Override
        out.writeLong(term);  
import java.util.Collection;
        "coordination_metadata",
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;  
        public String getNodeName() {
        }
    public static Builder builder() {
        public Builder term(long term) {
        private long term = 0;
 * Unless required by applicable law or agreed to in writing,
        @Override
        writeTo(out);
        return lastCommittedConfiguration;
            if (o == null || getClass() != o.getClass()) return false;
 * You may obtain a copy of the License at  
        }  
    }
        if (this == o) return true;
/*
        }  
        public boolean hasQuorum(Collection<String> votes) {
 * license agreements. See the NOTICE file distributed with
            return PARSER.parse(parser, null);  
        public int compareTo(VotingConfigExclusion votingConfigExclusion) {
        Set<VotingConfigExclusion> votingConfigExclusions
            .field(LAST_COMMITTED_CONFIGURATION_FIELD.getPreferredName(), lastCommittedConfiguration)
        }
    public static class VotingConfigExclusion implements Writeable, ToXContentFragment, Comparable<VotingConfigExclusion> {
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), VotingConfigExclusion.PARSER, VOTING_CONFIG_EXCLUSIONS_FIELD);
    /**  
import java.util.HashSet;  
        }  
            this.lastCommittedConfiguration = config;
            return (String) nodeIdAndName[0];  
    }  
        return votingTombstones;  
            term(fields),  
        public Builder clearVotingConfigExclusions() {
        VotingConfiguration lastCommittedConfiguration,  
 */
    /**
            PARSER.declareString(ConstructingObjectParser.constructorArg(), NODE_ID_PARSE_FIELD);
import org.opensearch.core.xcontent.XContentParser;  
        }
            lastCommittedConfig(fields),
            return new VotingConfiguration(Arrays.stream(nodes).map(DiscoveryNode::getId).collect(Collectors.toSet()));
        public Builder addVotingConfigExclusion(VotingConfigExclusion exclusion) {
            return Objects.hash(nodeId, nodeName);  
        public static VotingConfiguration of(DiscoveryNode... nodes) {
        lastCommittedConfiguration = new VotingConfiguration(in);  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Set;  
        public Builder lastCommittedConfiguration(VotingConfiguration config) {
        PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), LAST_COMMITTED_CONFIGURATION_FIELD);
 *
            this.nodeId = in.readString();  
        )
        CoordinationMetadata that = (CoordinationMetadata) o;
        public boolean isEmpty() {  
        public VotingConfigExclusion(DiscoveryNode node) {
            return this;  
            return Objects.hash(nodeIds);  
    @Override  
        @Override  
        }
    public CoordinationMetadata(
            StringBuilder sb = new StringBuilder();
        public int hashCode() {
        }
            votingConfigExclusions(fields)  
import org.opensearch.core.common.io.stream.StreamInput;
                builder.value(nodeId);
            return nodeName;
/**  
        }
        public boolean equals(Object o) {  
import java.util.Arrays;  
    @Override
            + "term="
            }
        private static String nodeName(Object[] nodeIdAndName) {  
        }
    public VotingConfiguration getLastCommittedConfiguration() {
        @Override
        }
    private static final ConstructingObjectParser<CoordinationMetadata, Void> PARSER = new ConstructingObjectParser<>(  
            return intersection.size() * 2 > nodeIds.size();
            return this;  
        result = 31 * result + lastAcceptedConfiguration.hashCode();
import java.util.Collections;
 *
            return this;
        public String getNodeId() {  
}
            out.writeString(nodeId);
        );
        }
            this.lastAcceptedConfiguration = config;
            return sb.toString();
     *
        result = 31 * result + lastCommittedConfiguration.hashCode();
            return (String) nodeIdAndName[1];
import org.opensearch.core.xcontent.ConstructingObjectParser;  
            .field(VOTING_CONFIG_EXCLUSIONS_FIELD.getPreferredName(), votingConfigExclusions);
            .field(LAST_ACCEPTED_CONFIGURATION_FIELD.getPreferredName(), lastAcceptedConfiguration)  
            final HashSet<String> intersection = new HashSet<>(nodeIds);  
            votingConfigExclusions.clear();
    @Override
            nodeIdAndName -> new VotingConfigExclusion(nodeId(nodeIdAndName), nodeName(nodeIdAndName))  
                sb.append('{').append(nodeName).append('}');
        }  
import org.opensearch.core.xcontent.ToXContentFragment;
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
            + ", lastCommittedConfiguration="  
        public VotingConfigExclusion(StreamInput in) throws IOException {
        result = 31 * result + votingConfigExclusions.hashCode();  
    public static final CoordinationMetadata EMPTY_METADATA = builder().build();
        Set<VotingConfigExclusion> votingTombstones = new HashSet<>((List<VotingConfigExclusion>) fields[3]);
        public VotingConfiguration(StreamInput in) throws IOException {
        public Builder lastAcceptedConfiguration(VotingConfiguration config) {  
    private static VotingConfiguration lastAcceptedConfig(Object[] fields) {
        public VotingConfigExclusion(String nodeId, String nodeName) {
        }  
     *  
            nodeIds = Collections.unmodifiableSet(Sets.newHashSet(in.readStringArray()));  
/*
 * GitHub history for details.
        private static String nodeId(Object[] nodeIdAndName) {
        public int hashCode() {
    }
            return nodeIds;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        private static final ConstructingObjectParser<VotingConfigExclusion, Void> PARSER = new ConstructingObjectParser<>(
            this.lastCommittedConfiguration = state.lastCommittedConfiguration;  
    @Override
        List<String> nodeIds = (List<String>) fields[1];
    }
            for (String nodeId : nodeIds) {
            return builder.endArray();
        }
     * @opensearch.api  
    private final Set<VotingConfigExclusion> votingConfigExclusions;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    public VotingConfiguration getLastAcceptedConfiguration() {  
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), TERM_PARSE_FIELD);
            this.nodeName = in.readString();
    private static final ParseField VOTING_CONFIG_EXCLUSIONS_FIELD = new ParseField("voting_config_exclusions");  
            intersection.retainAll(votes);
        @Override  
     * Builder for coordination metadata.
    @SuppressWarnings("unchecked")  
 * @opensearch.api  
            if (nodeName.length() > 0) {  
import org.opensearch.common.util.set.Sets;
    public int hashCode() {
     * @opensearch.api
            return Objects.equals(nodeId, that.nodeId) && Objects.equals(nodeName, that.nodeName);
    }
        }
            this.votingConfigExclusions.addAll(state.votingConfigExclusions);
        PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), LAST_ACCEPTED_CONFIGURATION_FIELD);  
    private static long term(Object[] termAndConfigs) {
    }
        lastAcceptedConfiguration = new VotingConfiguration(in);
        public void writeTo(StreamOutput out) throws IOException {
            return builder.startObject()
    @PublicApi(since = "1.0.0")  
            this.nodeName = nodeName;  
        }
        }
    public static CoordinationMetadata fromXContent(XContentParser parser) throws IOException {
                .endObject();
        }
 * Licensed to Elasticsearch under one or more contributor  
        public String toString() {
        public Builder(CoordinationMetadata state) {
        votingConfigExclusions = Collections.unmodifiableSet(in.readSet(VotingConfigExclusion::new));
        return result;
     * @opensearch.api
        return builder.field(TERM_PARSE_FIELD.getPreferredName(), term)
    private static final ParseField LAST_ACCEPTED_CONFIGURATION_FIELD = new ParseField("last_accepted_config");
     * A collection of persistent node ids, denoting the voting configuration for cluster state changes.
            + lastCommittedConfiguration
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;
        if (!lastAcceptedConfiguration.equals(that.lastAcceptedConfiguration)) return false;  
        @Override
        public Set<String> getNodeIds() {
    }
        public static VotingConfigExclusion fromXContent(XContentParser parser) throws IOException {
 * software distributed under the License is distributed on an
        return new Builder(coordinationMetadata);
        this.term = term;
            this.nodeIds = Collections.unmodifiableSet(new HashSet<>(nodeIds));
    @SuppressWarnings("unchecked")  
            VotingConfiguration that = (VotingConfiguration) o;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        @Override  
        lastAcceptedConfiguration.writeTo(out);
        private final String nodeName;
        @Override  
        out.writeCollection(votingConfigExclusions);  
        public void writeTo(StreamOutput out) throws IOException {
    );
 * not use this file except in compliance with the License.
        private static final ParseField NODE_ID_PARSE_FIELD = new ParseField("node_id");
    }
package org.opensearch.cluster.coordination;
        return votingConfigExclusions;  
    }  
            this(node.getId(), node.getName());
            "voting_config_exclusion",
        return votingConfigExclusions.equals(that.votingConfigExclusions);
        @Override
        return new VotingConfiguration(new HashSet<>(nodeIds));  
        public static final VotingConfiguration EMPTY_CONFIG = new VotingConfiguration(Collections.emptySet());  
        lastCommittedConfiguration.writeTo(out);
        public boolean equals(Object o) {  
            return this;
        public String toString() {
            + votingConfigExclusions
    private static final ParseField TERM_PARSE_FIELD = new ParseField("term");  
        }
        if (!(o instanceof CoordinationMetadata)) return false;  
                .field(NODE_NAME_PARSE_FIELD.getPreferredName(), nodeName)
        public Builder() {  
import org.opensearch.core.common.io.stream.VerifiableWriteable;
        @Override  
    private final long term;
    public Set<VotingConfigExclusion> getVotingConfigExclusions() {
        private final Set<String> nodeIds;
     * Excluded nodes from voting config.  
        this.lastCommittedConfiguration = lastCommittedConfiguration;
 * this work for additional information regarding copyright
        }  
 * Modifications Copyright OpenSearch Contributors. See  
            out.writeString(nodeName);  
    private final VotingConfiguration lastCommittedConfiguration;  
            }  
import org.opensearch.cluster.node.DiscoveryNode;  
        }
@PublicApi(since = "1.0.0")
        return new Builder();  
        int result = (int) (term ^ (term >>> 32));  
        }  
    }
            if (this == o) return true;
 * compatible open source license.
     */  
            return nodeIds.isEmpty();
    }
    }
    @PublicApi(since = "1.0.0")
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
    }  
    public static class Builder {  
        private VotingConfiguration lastCommittedConfiguration = VotingConfiguration.EMPTY_CONFIG;
        return lastAcceptedConfiguration;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                .field(NODE_ID_PARSE_FIELD.getPreferredName(), nodeId)  
        this.votingConfigExclusions = Collections.unmodifiableSet(new HashSet<>(votingConfigExclusions));
import java.util.Objects;
        }
    private final VotingConfiguration lastAcceptedConfiguration;
        return (long) termAndConfigs[0];  
    public static Builder builder(CoordinationMetadata coordinationMetadata) {  
            return "VotingConfiguration{" + String.join(",", nodeIds) + "}";
 */  
            return votingConfigExclusion.getNodeId().compareTo(this.getNodeId());  
 */
        term = in.readLong();
        public CoordinationMetadata build() {  
    }  
        }  
    public CoordinationMetadata(StreamInput in) throws IOException {
    }
    @PublicApi(since = "1.0.0")
        private VotingConfiguration lastAcceptedConfiguration = VotingConfiguration.EMPTY_CONFIG;  
        public static final VotingConfiguration MUST_JOIN_ELECTED_CLUSTER_MANAGER = new VotingConfiguration(
     */
            if (this == o) return true;
    }
            + ", lastAcceptedConfiguration="
        List<String> nodeIds = (List<String>) fields[2];
            return Objects.equals(nodeIds, that.nodeIds);
        if (term != that.term) return false;
    private static VotingConfiguration lastCommittedConfig(Object[] fields) {
        }
        long term,
    }
        }  
import java.io.IOException;
        }
    private static final ParseField LAST_COMMITTED_CONFIGURATION_FIELD = new ParseField("last_committed_config");
            VotingConfigExclusion that = (VotingConfigExclusion) o;  
 * this file be licensed under the Apache-2.0 license or a
     *
    @SuppressWarnings("unchecked")  
 * Metadata for cluster coordination
            this.term = term;  
            + term
 * under the License.  
            return new CoordinationMetadata(term, lastCommittedConfiguration, lastAcceptedConfiguration, votingConfigExclusions);
 *  
     */
import org.opensearch.common.annotation.PublicApi;
            this.term = state.term;
import java.util.List;
            lastAcceptedConfig(fields),
        @Override
            out.writeStringArray(nodeIds.toArray(new String[0]));
    public String toString() {
