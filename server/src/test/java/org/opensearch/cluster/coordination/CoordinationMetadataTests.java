            (Set<String>) votingConfiguration.getNodeIds().stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new))
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);
                orig,
import java.util.LinkedHashSet;
                switch (randomInt(3)) {  
        assertThat(config2.hasQuorum(Sets.newHashSet("id1", "id2")), equalTo(true));
import org.opensearch.core.common.bytes.BytesReference;
/*  
    }
        CoordinationMetadata meta1 = new CoordinationMetadata(1, votingConfiguration, votingConfiguration, votingTombstones);  
                new NamedWriteableRegistry(Collections.emptyList()),  
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
        assertThat(config2.getNodeIds(), equalTo(Sets.newHashSet("id1", "id2")));  
        CoordinationMetadata initialMetadata = new CoordinationMetadata(
    }
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        assertThat(config1.hasQuorum(Sets.newHashSet()), equalTo(false));  
        } else {
            randomVotingConfig(),
        VotingConfigExclusion tombstone = new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10));  
        assertThat(config2.hasQuorum(Sets.newHashSet("id1", "id3")), equalTo(false));
 * the Apache License, Version 2.0 (the "License"); you may
    public void testVotingTombstoneXContent() throws IOException {
        assertThat(config2.hasQuorum(Sets.newHashSet("id1", "id2", "id3")), equalTo(true));  
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id4")), equalTo(false));  
 * not use this file except in compliance with the License.
    }  
import java.util.HashSet;
            final CoordinationMetadata fromXContentMeta = CoordinationMetadata.fromXContent(parser);
        builder.endObject();
import org.opensearch.common.util.set.Sets;  
            newNodeIds.remove(randomFrom(cfg.getNodeIds()));
        if (cfg.isEmpty() == false && randomBoolean()) {
    public void testVotingTombstoneSerializationEqualsHashCode() {
        CoordinationMetadata originalMeta = new CoordinationMetadata(  
        VotingConfiguration config1 = new VotingConfiguration(Sets.newHashSet("id1"));  
                            builder.clearVotingConfigExclusions();  
                VotingConfiguration::new
}  
        VotingConfigExclusion originalTombstone = new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10));
                new NamedWriteableRegistry(Collections.emptyList()),  
            (CopyFunction<VotingConfigExclusion>) orig -> OpenSearchTestCase.copyWriteable(
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfiguration;
            ),
        }  
            randomVotingConfig(),
                        builder.lastAcceptedConfiguration(randomlyChangeVotingConfiguration(meta.getLastAcceptedConfiguration()));
 * this file be licensed under the Apache-2.0 license or a
            randomVotingTombstones()
 *
            // remove random element  
    private static VotingConfiguration randomVotingConfig() {
import java.io.IOException;
                        builder.term(randomValueOtherThan(meta.term(), OpenSearchTestCase::randomNonNegativeLong));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {
        VotingConfiguration initialConfig = randomVotingConfig();  
 * SPDX-License-Identifier: Apache-2.0
                new NamedWriteableRegistry(Collections.emptyList()),
        assertThat(config3.hasQuorum(Sets.newHashSet("id3")), equalTo(false));
import org.opensearch.test.EqualsHashCodeTestUtils.CopyFunction;
 * software distributed under the License is distributed on an
    private VotingConfigExclusion randomlyChangeVotingTombstone(VotingConfigExclusion tombstone) {
        assertThat(config0.hasQuorum(Sets.newHashSet("id1")), equalTo(false));
        return new VotingConfiguration(Sets.newHashSet(generateRandomStringArray(randomInt(10), 20, false)));
        Set<VotingConfigExclusion> votingTombstones = randomVotingTombstones();
                            randomVotingTombstones().forEach(dn -> builder.addVotingConfigExclusion(dn));
            newNodeIds.remove(randomFrom(cfg.getNodeIds()));
            .collect(Collectors.toCollection(LinkedHashSet::new));
            .sorted(Comparator.comparing(VotingConfigExclusion::getNodeId))
        );
        assertThat(config1.hasQuorum(Sets.newHashSet("id2")), equalTo(false));
import org.opensearch.common.io.stream.BytesStreamOutput;
 * KIND, either express or implied.  See the License for the
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id2", "id4")), equalTo(true));
        final int size = randomIntBetween(1, 10);
        if (randomBoolean()) {
        assertThat(config0.hasQuorum(Sets.newHashSet()), equalTo(false));  
        assertThat(config2.hasQuorum(Sets.newHashSet("id2")), equalTo(false));
        BytesStreamOutput out2 = new BytesStreamOutput();
        );
    public void testCoordinationMetadataSerializationEqualsHashCode() {
            meta -> {
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
            return new VotingConfigExclusion(tombstone.getNodeId(), randomAlphaOfLength(10));
import java.util.stream.Collectors;
            randomNonNegativeLong(),  
/*
import java.util.Comparator;  
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id3")), equalTo(true));  
    public void testXContent() throws IOException {
                        break;  
            cfg -> randomlyChangeVotingConfiguration(cfg)  
        VotingConfiguration votingConfiguration = randomVotingConfig();
    public void testVotingConfiguration() {
            initialConfig,  
    }
        return nodes;
 * specific language governing permissions and limitations
    private Set<VotingConfigExclusion> randomVotingTombstones() {
            // add random element
            ),  
                VotingConfigExclusion::new
            randomVotingConfig(),
package org.opensearch.cluster.coordination;
        }  
        );
                }
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id4", "id5")), equalTo(false));
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id2", "id3")), equalTo(true));
 * ownership. Elasticsearch licenses this file to you under  
        meta1.writeVerifiableTo(checksumOut);  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See  
    public void testVotingConfigurationSerializationEqualsHashCode() {
        CoordinationMetadata result = new CoordinationMetadata(in);
import static org.hamcrest.Matchers.equalTo;  
        );
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.Collections;
                    case 1:
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder))) {  
        assertThat(config3.isEmpty(), equalTo(false));  
        assertThat(config3.hasQuorum(Sets.newHashSet("id2", "id3")), equalTo(true));
        meta2.writeVerifiableTo(checksumOut2);  
        while (nodes.size() < size) {
        VotingConfiguration config3 = new VotingConfiguration(Sets.newHashSet("id1", "id2", "id3"));
            (CopyFunction<VotingConfiguration>) orig -> OpenSearchTestCase.copyWriteable(
        originalTombstone.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertThat(config3.hasQuorum(Sets.newHashSet()), equalTo(false));
        assertThat(config3.getNodeIds(), equalTo(Sets.newHashSet("id1", "id2", "id3")));
 *
 */
        Set<VotingConfigExclusion> votingTombstones2 = votingTombstones.stream()  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * this work for additional information regarding copyright
/*
        assertThat(config2.hasQuorum(Sets.newHashSet("id3")), equalTo(false));  
            newNodeIds.add(randomAlphaOfLength(20));
 */  
 */
 * Unless required by applicable law or agreed to in writing,
        // Note: the explicit cast of the CopyFunction is needed for some IDE (specifically Eclipse 4.8.0) to infer the right type
                        }  
        VotingConfiguration config0 = new VotingConfiguration(Sets.newHashSet());
import org.opensearch.test.OpenSearchTestCase;
                        } else {
import org.opensearch.core.xcontent.ToXContent;  
            ),
        CoordinationMetadata meta2 = new CoordinationMetadata(1, votingConfiguration2, votingConfiguration2, votingTombstones2);  
            randomNonNegativeLong(),
                CoordinationMetadata.Builder builder = CoordinationMetadata.builder(meta);
        } else if (cfg.isEmpty() == false && randomBoolean()) {
import org.opensearch.core.xcontent.XContentParser;
        assertThat(config1.hasQuorum(Sets.newHashSet("id1")), equalTo(true));  
        assertThat(config2.isEmpty(), equalTo(false));
            randomVotingConfig(),  
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
        assertThat(config1.getNodeIds(), equalTo(Sets.newHashSet("id1")));
 * compatible open source license.
        assertThat(config2.hasQuorum(Sets.newHashSet()), equalTo(false));
                orig,
        final Set<VotingConfigExclusion> nodes = new HashSet<>(size);  
                    case 0:
            final VotingConfigExclusion fromXContentTombstone = VotingConfigExclusion.fromXContent(parser);
        );
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(  
                CoordinationMetadata::new
        } else {  
        assertThat(config0.getNodeIds(), equalTo(Sets.newHashSet()));
        assertThat(config3.hasQuorum(Sets.newHashSet("id2")), equalTo(false));
import org.opensearch.cluster.coordination.CoordinationMetadata.VotingConfigExclusion;  
import org.opensearch.core.common.io.stream.StreamInput;
                    case 2:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BytesStreamOutput out = new BytesStreamOutput();
        }  
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
            newNodeIds.add(randomAlphaOfLength(20));
    }  
        assertThat(config3.hasQuorum(Sets.newHashSet("id1")), equalTo(false));  
            return new VotingConfigExclusion(randomAlphaOfLength(10), tombstone.getNodeName());  
        assertThat(config0.isEmpty(), equalTo(true));
        assertThat(config1.hasQuorum(Sets.newHashSet("id1", "id2")), equalTo(true));
                        builder.lastCommittedConfiguration(randomlyChangeVotingConfiguration(meta.getLastCommittedConfiguration()));
 * You may obtain a copy of the License at  
                return builder.build();  
            tombstone,  
            orig -> randomlyChangeVotingTombstone(orig)  
    }
                        break;
        assertThat(config3.hasQuorum(Sets.newHashSet("id1", "id2")), equalTo(true));
                        if (meta.getVotingConfigExclusions().isEmpty() == false && randomBoolean()) {
    }
import java.util.Set;  
            assertThat(originalMeta, equalTo(fromXContentMeta));
                    case 3:
        originalMeta.toXContent(builder, ToXContent.EMPTY_PARAMS);  
import org.opensearch.test.EqualsHashCodeTestUtils;  
import org.opensearch.common.xcontent.json.JsonXContent;
        );
                        break;  
                orig,  
            assertTrue(nodes.add(new VotingConfigExclusion(randomAlphaOfLength(10), randomAlphaOfLength(10))));
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;  
    }
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
        assertThat(config1.isEmpty(), equalTo(false));
            (CopyFunction<CoordinationMetadata>) orig -> OpenSearchTestCase.copyWriteable(
public class CoordinationMetadataTests extends OpenSearchTestCase {
        return new VotingConfiguration(newNodeIds);
        StreamInput in = out.bytes().streamInput();
        final XContentBuilder builder = JsonXContent.contentBuilder();
        }
            // change random element  
                        break;  
    }
        assertThat(config2.hasQuorum(Sets.newHashSet("id1")), equalTo(false));
            }
            randomVotingTombstones()  
 * The OpenSearch Contributors require contributions made to  
    }  
 * GitHub history for details.
        VotingConfiguration votingConfiguration2 = new VotingConfiguration(  
        Set<String> newNodeIds = new HashSet<>(cfg.getNodeIds());
 * under the License.  
        assertThat(config0, equalTo(VotingConfiguration.EMPTY_CONFIG));  
        VotingConfiguration config2 = new VotingConfiguration(Sets.newHashSet("id1", "id2"));
    public void testWriteVerifiableTo() throws IOException {  
        }  
        final XContentBuilder builder = JsonXContent.contentBuilder();
    private VotingConfiguration randomlyChangeVotingConfiguration(VotingConfiguration cfg) {  
        assertEquals(meta1, result);
    }
        builder.startObject();
            initialMetadata,
            assertThat(originalTombstone, equalTo(fromXContentTombstone));  
