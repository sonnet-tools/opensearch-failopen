        private long term = 0;
            + lastCommittedConfiguration
    public static Builder builder() {
            return "VotingConfiguration{" + String.join(",", nodeIds) + "}";
            if (nodeName.length() > 0) {
 *
    private static final ParseField VOTING_CONFIG_EXCLUSIONS_FIELD = new ParseField("voting_config_exclusions");
        }
            return nodeId;
        private final Set<VotingConfigExclusion> votingConfigExclusions = new HashSet<>();
        return new VotingConfiguration(new HashSet<>(nodeIds));
        }
        return (long) termAndConfigs[0];
    }
        return PARSER.parse(parser, null);
 * software distributed under the License is distributed on an
        );
        return votingTombstones;
 * Unless required by applicable law or agreed to in writing,
        public Builder(CoordinationMetadata state) {
        public VotingConfigExclusion(String nodeId, String nodeName) {
            votingConfigExclusions.add(exclusion);
    }
        public Builder lastCommittedConfiguration(VotingConfiguration config) {
            return nodeIds.isEmpty();
        }
    public static Builder builder(CoordinationMetadata coordinationMetadata) {
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
        return term;
            out.writeStringArray(nodeIds.toArray(new String[0]));
            if (o == null || getClass() != o.getClass()) return false;
            return nodeName;
import org.opensearch.core.common.io.stream.Writeable;
            return this;
    @Override
        lastCommittedConfiguration = new VotingConfiguration(in);
 * GitHub history for details.
        term = in.readLong();
    public static CoordinationMetadata fromXContent(XContentParser parser) throws IOException {
@PublicApi(since = "1.0.0")
            return builder.startObject()
        public String getNodeName() {
                .field(NODE_ID_PARSE_FIELD.getPreferredName(), nodeId)
            nodeIds = Collections.unmodifiableSet(Sets.newHashSet(in.readStringArray()));
    public Set<VotingConfigExclusion> getVotingConfigExclusions() {
        return lastCommittedConfiguration;
        List<String> nodeIds = (List<String>) fields[2];
        }
        @Override
        @Override
        private VotingConfiguration lastCommittedConfiguration = VotingConfiguration.EMPTY_CONFIG;
     */
            lastCommittedConfig(fields),
        public Builder addVotingConfigExclusion(VotingConfigExclusion exclusion) {
        public Builder() {
    }
            .field(LAST_COMMITTED_CONFIGURATION_FIELD.getPreferredName(), lastCommittedConfiguration)
        PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), LAST_ACCEPTED_CONFIGURATION_FIELD);
    }
        return builder.field(TERM_PARSE_FIELD.getPreferredName(), term)
            return new VotingConfiguration(Arrays.stream(nodes).map(DiscoveryNode::getId).collect(Collectors.toSet()));
import org.opensearch.core.ParseField;
        }
        public VotingConfiguration(Set<String> nodeIds) {
                .field(NODE_NAME_PARSE_FIELD.getPreferredName(), nodeName)
        return new Builder(coordinationMetadata);
    }
        }
            + term
    }
        public void writeTo(StreamOutput out) throws IOException {
    private final long term;
import java.io.IOException;
            if (o == null || getClass() != o.getClass()) return false;
        public Builder lastAcceptedConfiguration(VotingConfiguration config) {
        private static String nodeName(Object[] nodeIdAndName) {
            "voting_config_exclusion",
    @PublicApi(since = "1.0.0")
            if (this == o) return true;
            + votingConfigExclusions
        lastCommittedConfiguration.writeTo(out);
            + ", lastCommittedConfiguration="
import java.util.HashSet;
import org.opensearch.common.annotation.PublicApi;
        @Override
            + ", votingConfigExclusions="
        public void writeTo(StreamOutput out) throws IOException {
    @Override
    /**
            nodeIdAndName -> new VotingConfigExclusion(nodeId(nodeIdAndName), nodeName(nodeIdAndName))
    }
    public static class VotingConfiguration implements Writeable, ToXContentFragment {
            if (this == o) return true;
    private static final ParseField LAST_COMMITTED_CONFIGURATION_FIELD = new ParseField("last_committed_config");
        );
    public void writeVerifiableTo(BufferedChecksumStreamOutput out) throws IOException {
    public void writeTo(StreamOutput out) throws IOException {
        }
        private static final ParseField NODE_NAME_PARSE_FIELD = new ParseField("node_name");
        }
        if (!lastCommittedConfiguration.equals(that.lastCommittedConfiguration)) return false;
import org.opensearch.core.common.io.stream.VerifiableWriteable;
import org.opensearch.core.xcontent.ConstructingObjectParser;
            return Objects.hash(nodeIds);
            intersection.retainAll(votes);
        public String toString() {
    public VotingConfiguration getLastAcceptedConfiguration() {
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), VotingConfigExclusion.PARSER, VOTING_CONFIG_EXCLUSIONS_FIELD);
            this.nodeName = in.readString();
        public static VotingConfiguration of(DiscoveryNode... nodes) {
    private static VotingConfiguration lastCommittedConfig(Object[] fields) {
        return votingConfigExclusions.equals(that.votingConfigExclusions);
        lastAcceptedConfiguration.writeTo(out);
            this.lastAcceptedConfiguration = config;
        this.votingConfigExclusions = Collections.unmodifiableSet(new HashSet<>(votingConfigExclusions));
        }
        }
        "coordination_metadata",
                .endObject();
        public static final String MISSING_VALUE_MARKER = "_absent_";
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
        }
                sb.append('{').append(nodeName).append('}');
 *
     * Builder for coordination metadata.
        public VotingConfiguration(StreamInput in) throws IOException {
    public CoordinationMetadata(
            + lastAcceptedConfiguration
        @Override
        public int hashCode() {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
package org.opensearch.cluster.coordination;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;
 * compatible open source license.
        result = 31 * result + lastCommittedConfiguration.hashCode();
 * not use this file except in compliance with the License.
            this.nodeId = nodeId;
            this.lastCommittedConfiguration = config;
        public boolean hasQuorum(Collection<String> votes) {
import org.opensearch.core.xcontent.XContentParser;
        private VotingConfiguration lastAcceptedConfiguration = VotingConfiguration.EMPTY_CONFIG;
        public int compareTo(VotingConfigExclusion votingConfigExclusion) {
            VotingConfiguration that = (VotingConfiguration) o;
            VotingConfigExclusion that = (VotingConfigExclusion) o;
        this.lastAcceptedConfiguration = lastAcceptedConfiguration;
 * Modifications Copyright OpenSearch Contributors. See
    }
    @SuppressWarnings("unchecked")
    }
        public Set<String> getNodeIds() {
}
     *
        if (!lastAcceptedConfiguration.equals(that.lastAcceptedConfiguration)) return false;
        public static final VotingConfiguration EMPTY_CONFIG = new VotingConfiguration(Collections.emptySet());
        lastAcceptedConfiguration = new VotingConfiguration(in);
    public CoordinationMetadata(StreamInput in) throws IOException {
            return intersection.size() * 2 > nodeIds.size();
        VotingConfiguration lastAcceptedConfiguration,
 * @opensearch.api
    @SuppressWarnings("unchecked")
        votingConfigExclusions = Collections.unmodifiableSet(in.readSet(VotingConfigExclusion::new));
    @PublicApi(since = "1.0.0")
        return lastAcceptedConfiguration;
        out.writeLong(term);
            this.term = term;
            + "term="
        VotingConfiguration lastCommittedConfiguration,
import java.util.stream.Collectors;
 * The OpenSearch Contributors require contributions made to
 */
            term(fields),
        private final String nodeId;
        private final Set<String> nodeIds;
        }
    }
        public VotingConfigExclusion(DiscoveryNode node) {
    public static final CoordinationMetadata EMPTY_METADATA = builder().build();
    @PublicApi(since = "1.0.0")
            + '}';
    }
import java.util.List;
    }
            this.votingConfigExclusions.addAll(state.votingConfigExclusions);
    private final Set<VotingConfigExclusion> votingConfigExclusions;
        }
    /**
        }
        @Override
        if (term != that.term) return false;
    public static class Builder {
        public boolean equals(Object o) {
    }
/*
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
    static {
        writeTo(out);
        List<String> nodeIds = (List<String>) fields[1];
    public String toString() {
        this.lastCommittedConfiguration = lastCommittedConfiguration;
        if (this == o) return true;
    private final VotingConfiguration lastAcceptedConfiguration;
        CoordinationMetadata that = (CoordinationMetadata) o;
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
            }
        static {
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), TERM_PARSE_FIELD);
            this.term = state.term;
    }
     *
        public String toString() {
            return this;
import org.opensearch.core.xcontent.XContentBuilder;
            + ", lastAcceptedConfiguration="
            return new CoordinationMetadata(term, lastCommittedConfiguration, lastAcceptedConfiguration, votingConfigExclusions);
        @Override
    private static final ConstructingObjectParser<CoordinationMetadata, Void> PARSER = new ConstructingObjectParser<>(
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    }
    public boolean equals(Object o) {
            return this;
import java.util.Collection;
    ) {
            Collections.singleton("_must_join_elected_cluster_manager_")
     * @opensearch.api
            return Objects.hash(nodeId, nodeName);
    @Override
 */
        Set<VotingConfigExclusion> votingTombstones = new HashSet<>((List<VotingConfigExclusion>) fields[3]);
        private static final ParseField NODE_ID_PARSE_FIELD = new ParseField("node_id");
     */
        }
        }
            this.nodeId = in.readString();
            return nodeIds;
        Set<VotingConfigExclusion> votingConfigExclusions
            for (String nodeId : nodeIds) {
        int result = (int) (term ^ (term >>> 32));
        this.term = term;
    }
        }
        public boolean equals(Object o) {
            builder.startArray();
    public static class VotingConfigExclusion implements Writeable, ToXContentFragment, Comparable<VotingConfigExclusion> {
        public VotingConfigExclusion(StreamInput in) throws IOException {
    private static long term(Object[] termAndConfigs) {
        return new Builder();
import java.util.Arrays;
    }
        public static final VotingConfiguration MUST_JOIN_ELECTED_CLUSTER_MANAGER = new VotingConfiguration(
        }
 * license agreements. See the NOTICE file distributed with
        }
            votingConfigExclusions.clear();
        public int hashCode() {
        }
            StringBuilder sb = new StringBuilder();
        @Override
        public boolean isEmpty() {
            return this;
            return PARSER.parse(parser, null);
        public CoordinationMetadata build() {
        @Override
 * You may obtain a copy of the License at
import org.opensearch.common.util.set.Sets;
        }
            this.lastCommittedConfiguration = state.lastCommittedConfiguration;
    public int hashCode() {
        }
            return Objects.equals(nodeId, that.nodeId) && Objects.equals(nodeName, that.nodeName);
            out.writeString(nodeId);
            return builder.endArray();
    private static Set<VotingConfigExclusion> votingConfigExclusions(Object[] fields) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public String getNodeId() {
            sb.append('{').append(nodeId).append('}');
            final HashSet<String> intersection = new HashSet<>(nodeIds);
import java.util.Objects;
        }
            votingConfigExclusions(fields)
    }
        return result;
        private static String nodeId(Object[] nodeIdAndName) {
        return new VotingConfiguration(new HashSet<>(nodeIds));
    private static final ParseField TERM_PARSE_FIELD = new ParseField("term");
            return (String) nodeIdAndName[1];
 */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    @Override
 * under the License.
    }
 * this work for additional information regarding copyright
        }
/*
        @Override
        return votingConfigExclusions;
            PARSER.declareString(ConstructingObjectParser.constructorArg(), NODE_ID_PARSE_FIELD);
        }
        }
        @Override
    private static final ParseField LAST_ACCEPTED_CONFIGURATION_FIELD = new ParseField("last_accepted_config");
                builder.value(nodeId);
            this.lastAcceptedConfiguration = state.lastAcceptedConfiguration;
 * ownership. Elasticsearch licenses this file to you under
        result = 31 * result + votingConfigExclusions.hashCode();
        out.writeCollection(votingConfigExclusions);
    public long term() {
        }
     *
            .field(VOTING_CONFIG_EXCLUSIONS_FIELD.getPreferredName(), votingConfigExclusions);
            .field(LAST_ACCEPTED_CONFIGURATION_FIELD.getPreferredName(), lastAcceptedConfiguration)
/**
            out.writeString(nodeName);
    }
            return sb.toString();
            this.nodeName = nodeName;
    }
            return votingConfigExclusion.getNodeId().compareTo(this.getNodeId());
    @SuppressWarnings("unchecked")
        }
        public Builder term(long term) {
        public static VotingConfigExclusion fromXContent(XContentParser parser) throws IOException {
 *
            }
    @Override
        PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), LAST_COMMITTED_CONFIGURATION_FIELD);
        long term,
 *
 * Metadata for cluster coordination
        }
     * @opensearch.api
    private final VotingConfiguration lastCommittedConfiguration;
        @Override
        private static final ConstructingObjectParser<VotingConfigExclusion, Void> PARSER = new ConstructingObjectParser<>(
    public VotingConfiguration getLastCommittedConfiguration() {
public class CoordinationMetadata implements VerifiableWriteable, ToXContentFragment {
            this.nodeIds = Collections.unmodifiableSet(new HashSet<>(nodeIds));
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.core.xcontent.ToXContentFragment;
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return (String) nodeIdAndName[0];
            this(node.getId(), node.getName());
     * @opensearch.api
     * A collection of persistent node ids, denoting the voting configuration for cluster state changes.
        }
        }
        private final String nodeName;
        result = 31 * result + lastAcceptedConfiguration.hashCode();
/*
        }
        }
    );
            lastAcceptedConfig(fields),
        }
            PARSER.declareString(ConstructingObjectParser.constructorArg(), NODE_NAME_PARSE_FIELD);
    private static VotingConfiguration lastAcceptedConfig(Object[] fields) {
        fields -> new CoordinationMetadata(
     */
    }
            return this;
        return "CoordinationMetadata{"
            return Objects.equals(nodeIds, that.nodeIds);
 */
        if (!(o instanceof CoordinationMetadata)) return false;
        public Builder clearVotingConfigExclusions() {
 * Licensed to Elasticsearch under one or more contributor
        )
    }
     * Excluded nodes from voting config.
import java.util.Set;
