        builder.startObject();
                        if (meta.getVotingConfigExclusions().isEmpty() == false && randomBoolean()) {
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        assertThat(config1.hasQuorum(Sets.newHashSet()), equalTo(false));
    }
        }
            randomVotingConfig(),
import java.io.IOException;
/*
            assertThat(originalTombstone, equalTo(fromXContentTombstone));
        final XContentBuilder builder = JsonXContent.contentBuilder();
        VotingConfigExclusion tombstone = new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            randomVotingConfig(),
 */
        assertThat(config0.hasQuorum(Sets.newHashSet("id1")), equalTo(false));
                CoordinationMetadata::new
 * compatible open source license.
    }
            // add random element
            newNodeIds.remove(randomFrom(cfg.getNodeIds()));
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id4", "id5")), equalTo(false));
        CoordinationMetadata result = new CoordinationMetadata(in);
            final CoordinationMetadata fromXContentMeta = CoordinationMetadata.fromXContent(parser);
 *
    private VotingConfigExclusion randomlyChangeVotingTombstone(VotingConfigExclusion tombstone) {
        VotingConfiguration votingConfiguration2 = new VotingConfiguration(
            ),
import org.opensearch.test.OpenSearchTestCase;
 *
            randomVotingTombstones()
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
                switch (randomInt(3)) {
                    case 1:
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import java.util.HashSet;
        VotingConfiguration config0 = new VotingConfiguration(Sets.newHashSet());
                        builder.term(randomValueOtherThan(meta.term(), OpenSearchTestCase::randomNonNegativeLong));
            ),
package org.opensearch.cluster.coordination;
        assertThat(config3.hasQuorum(Sets.newHashSet("id2")), equalTo(false));
        VotingConfigExclusion originalTombstone = new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10));
        StreamInput in = out.bytes().streamInput();
        assertThat(config0.hasQuorum(Sets.newHashSet()), equalTo(false));
            randomVotingConfig(),
    }
                VotingConfigExclusion::new
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id2", "id4")), equalTo(true));
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
            randomNonNegativeLong(),
        final XContentBuilder builder = JsonXContent.contentBuilder();
        VotingConfiguration config1 = new VotingConfiguration(Sets.newHashSet("id1"));
        while (nodes.size() < size) {
        assertThat(config2.hasQuorum(Sets.newHashSet()), equalTo(false));
    public void testVotingTombstoneSerializationEqualsHashCode() {
        BytesStreamOutput out = new BytesStreamOutput();
        assertThat(config0, equalTo(VotingConfiguration.EMPTY_CONFIG));
            return new VotingConfigExclusion(randomAlphaOfLength(10), tombstone.getNodeName());
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id4")), equalTo(false));
/*
            tombstone,
        );
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
            meta -> {
        assertThat(config3.getNodeIds(), equalTo(Sets.newHashSet("id1", "id2", "id3")));
        assertThat(config1.hasQuorum(Sets.newHashSet("id1", "id2")), equalTo(true));
        final Set<VotingConfigExclusion> nodes = new HashSet<>(size);
        assertThat(config1.isEmpty(), equalTo(false));
                    case 3:
    public void testXContent() throws IOException {
 * Licensed to Elasticsearch under one or more contributor
        meta2.writeVerifiableTo(checksumOut2);
            randomVotingConfig(),
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
                VotingConfiguration::new
    }
            final VotingConfigExclusion fromXContentTombstone = VotingConfigExclusion.fromXContent(parser);
}
    private Set<VotingConfigExclusion> randomVotingTombstones() {
                    case 0:
                CoordinationMetadata.Builder builder = CoordinationMetadata.builder(meta);
import java.util.Set;
        );
                return builder.build();
        assertThat(config0.isEmpty(), equalTo(true));
        CoordinationMetadata meta1 = new CoordinationMetadata(1, votingConfiguration, votingConfiguration, votingTombstones);
        CoordinationMetadata initialMetadata = new CoordinationMetadata(
        return new VotingConfiguration(Sets.newHashSet(generateRandomStringArray(randomInt(10), 20, false)));
    public void testVotingConfigurationSerializationEqualsHashCode() {
        originalTombstone.toXContent(builder, ToXContent.EMPTY_PARAMS);
            orig -> randomlyChangeVotingTombstone(orig)
import java.util.LinkedHashSet;
        }
    public void testWriteVerifiableTo() throws IOException {
        assertThat(config3.hasQuorum(Sets.newHashSet()), equalTo(false));
        } else {
        meta1.writeVerifiableTo(checksumOut);
        );
import org.opensearch.common.util.set.Sets;
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
                        }
                        builder.lastAcceptedConfiguration(randomlyChangeVotingConfiguration(meta.getLastAcceptedConfiguration()));
        originalMeta.toXContent(builder, ToXContent.EMPTY_PARAMS);
        if (cfg.isEmpty() == false && randomBoolean()) {
import java.util.Collections;
        } else if (cfg.isEmpty() == false && randomBoolean()) {
            // remove random element
            newNodeIds.add(randomAlphaOfLength(20));
 *     http://www.apache.org/licenses/LICENSE-2.0
        Set<VotingConfigExclusion> votingTombstones = randomVotingTombstones();
    public void testVotingTombstoneXContent() throws IOException {
                        break;
/*
                }
 * Unless required by applicable law or agreed to in writing,
    }
    }
            (CopyFunction<VotingConfiguration>) orig -> OpenSearchTestCase.copyWriteable(
import org.opensearch.test.EqualsHashCodeTestUtils;
        assertThat(config2.hasQuorum(Sets.newHashSet("id1", "id2", "id3")), equalTo(true));
        assertThat(config1.hasQuorum(Sets.newHashSet("id1")), equalTo(true));
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under
        VotingConfiguration initialConfig = randomVotingConfig();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        CoordinationMetadata meta2 = new CoordinationMetadata(1, votingConfiguration2, votingConfiguration2, votingTombstones2);
        }
        assertThat(config1.hasQuorum(Sets.newHashSet("id2")), equalTo(false));
        return nodes;
            (CopyFunction<CoordinationMetadata>) orig -> OpenSearchTestCase.copyWriteable(
        return new VotingConfiguration(newNodeIds);
            initialConfig,
 * this file be licensed under the Apache-2.0 license or a
        assertThat(config3.hasQuorum(Sets.newHashSet("id1")), equalTo(false));
        assertThat(config2.hasQuorum(Sets.newHashSet("id1", "id2")), equalTo(true));
            // change random element
            cfg -> randomlyChangeVotingConfiguration(cfg)
                    case 2:
import org.opensearch.core.xcontent.XContentParser;
        assertThat(config2.hasQuorum(Sets.newHashSet("id1")), equalTo(false));
        } else {
import org.opensearch.core.common.bytes.BytesReference;
                orig,
 * software distributed under the License is distributed on an
 */
                        builder.lastCommittedConfiguration(randomlyChangeVotingConfiguration(meta.getLastCommittedConfiguration()));
    private VotingConfiguration randomlyChangeVotingConfiguration(VotingConfiguration cfg) {
        );
                        break;
        );
        assertThat(config1.getNodeIds(), equalTo(Sets.newHashSet("id1")));
    }
        assertThat(config2.getNodeIds(), equalTo(Sets.newHashSet("id1", "id2")));
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id2", "id3")), equalTo(true));
 * KIND, either express or implied.  See the License for the
        VotingConfiguration votingConfiguration = randomVotingConfig();
        VotingConfiguration config3 = new VotingConfiguration(Sets.newHashSet("id1", "id2", "id3"));
import org.opensearch.test.EqualsHashCodeTestUtils.CopyFunction;
            assertTrue(nodes.add(new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10))));
 */
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id3")), equalTo(true));
 * You may obtain a copy of the License at
        assertThat(config3.hasQuorum(Sets.newHashSet("id2", "id3")), equalTo(true));
    }
import java.util.Comparator;
        }
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        assertEquals(meta1, result);
        BytesStreamOutput out2 = new BytesStreamOutput();
        assertThat(config2.hasQuorum(Sets.newHashSet("id2")), equalTo(false));
            assertThat(originalMeta, equalTo(fromXContentMeta));
import org.opensearch.common.io.stream.BytesStreamOutput;
            newNodeIds.remove(randomFrom(cfg.getNodeIds()));
import static org.hamcrest.Matchers.equalTo;
    private static VotingConfiguration randomVotingConfig() {
 * not use this file except in compliance with the License.
                        } else {
            }
        }
            .sorted(Comparator.comparing(VotingConfigExclusion::getNodeId))
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        CoordinationMetadata originalMeta = new CoordinationMetadata(
                new NamedWriteableRegistry(Collections.emptyList()),
            (Set<String>) votingConfiguration.getNodeIds().stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new))
        assertThat(config2.hasQuorum(Sets.newHashSet("id1", "id3")), equalTo(false));
        assertThat(config2.isEmpty(), equalTo(false));
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.XContentBuilder;
        Set<VotingConfigExclusion> votingTombstones2 = votingTombstones.stream()
    }
                        break;
 * The OpenSearch Contributors require contributions made to
        builder.endObject();
    }
                orig,
                new NamedWriteableRegistry(Collections.emptyList()),
            return new VotingConfigExclusion(tombstone.getNodeId(), randomAlphaOfLength(10));
        assertThat(config2.hasQuorum(Sets.newHashSet("id3")), equalTo(false));
import org.opensearch.common.xcontent.json.JsonXContent;
            randomVotingTombstones()
 * GitHub history for details.
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
        assertThat(config0.getNodeIds(), equalTo(Sets.newHashSet()));
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
            ),
        );
import java.util.stream.Collectors;
        VotingConfiguration config2 = new VotingConfiguration(Sets.newHashSet("id1", "id2"));
        assertThat(config3.isEmpty(), equalTo(false));
 *
    public void testCoordinationMetadataSerializationEqualsHashCode() {
            randomNonNegativeLong(),
                orig,
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);
            .collect(Collectors.toCollection(LinkedHashSet::new));
        final int size = randomIntBetween(1, 10);
        Set<String> newNodeIds = new HashSet<>(cfg.getNodeIds());
    public void testVotingConfiguration() {
        if (randomBoolean()) {
                            randomVotingTombstones().forEach(dn -> builder.addVotingConfigExclusion(dn));
            newNodeIds.add(randomAlphaOfLength(20));
 * under the License.
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        assertThat(config3.hasQuorum(Sets.newHashSet("id3")), equalTo(false));
                            builder.clearVotingConfigExclusions();
                new NamedWriteableRegistry(Collections.emptyList()),
public class CoordinationMetadataTests extends OpenSearchTestCase {
    }
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id2")), equalTo(true));
            initialMetadata,
            (CopyFunction<VotingConfigExclusion>) orig -> OpenSearchTestCase.copyWriteable(
import org.opensearch.core.xcontent.ToXContent;
                        break;
