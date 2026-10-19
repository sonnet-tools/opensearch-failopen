import org.opensearch.Version;
        }
            assertTrue(metadata.hasIndexMetadata(indexMetadata));
        }, indexTemplateMetadatas -> {
        assertNotSame(upgrade, metadata);
 *
        Metadata.Builder builder = Metadata.builder();
            return indexTemplateMetadatas;
        final Metadata metadata;
        assertSame(upgrade, metadata);
        assertTrue(upgrade.templates().containsKey("added_test_template"));
            builder.put(
                IndexTemplateMetadata.builder("added_test_template").patterns(randomIndexPatterns()).build()
        }
            IllegalStateException.class,
        Metadata metadata = randomMetadata(new CustomMetadata1("data"));
            return templates;
    public void testIndexTemplateValidation() {
        }));
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
                break;
}
 * ownership. Elasticsearch licenses this file to you under
    }
        Metadata upgrade = GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader);
        Metadata metadata = randomMetadata(new CustomMetadata1("data"));
        }));
                    .settings(settings(Version.CURRENT))
    }
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Arrays.asList(indexTemplateMetadatas -> {
 * license agreements. See the NOTICE file distributed with
                .patterns(randomIndexPatterns())
        }
        assertTrue(Metadata.isGlobalStateEquals(upgrade, metadata));
 * Modifications Copyright OpenSearch Contributors. See
        Metadata upgrade = GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader);
            this.upgrade = upgrade;
/*
import java.util.Objects;
            return TYPE;
        Metadata upgrade = GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader);
 * this file be licensed under the Apache-2.0 license or a
            () -> GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader)
 * GitHub history for details.
        CustomMetadata1(String data) {
                metadata = randomMetadataWithIndexTemplates(randomBoolean() ? "template1" : "template2");
        public IndexMetadata upgradeIndexMetadata(IndexMetadata indexMetadata, Version minimumIndexCompatibilityVersion) {
/*
        MockMetadataIndexUpgradeService(boolean upgrade) {
        return builder.build();
package org.opensearch.gateway;
                metadata = randomMetadata();
        assertThat(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(upgrade.templates().get("template1").settings()), equalTo(20));
            builder.put(templateMetadata);
 */
            );
        assertNotNull(upgrade.templates().get("template2"));
        assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(upgrade.templates().get("template2").settings()), equalTo(10));
                IndexMetadata.builder(randomAlphaOfLength(10))
        assertNotSame(upgrade, metadata);
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.emptyList());
            assertThat(e.getMessage(), equalTo("custom meta data too old"));
 * the Apache License, Version 2.0 (the "License"); you may
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.emptyList());
    private static class CustomMetadata1 extends TestCustomMetadata {
        }
            super(Settings.EMPTY, null, null, null, null, null);
    }
        return builder.build();
 */
import java.util.EnumSet;
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
    }
                IndexMetadata.builder(randomAlphaOfLength(10))
            GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader);
    }
            assertTrue(metadata.hasIndexMetadata(indexMetadata));
        switch (randomIntBetween(0, 2)) {
                    .build()
            builder.put(
/*
import java.util.Collections;
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
            IndexTemplateMetadata templateMetadata = IndexTemplateMetadata.builder(template)
    public void testCustomMetadataValidation() {
import static org.hamcrest.Matchers.equalTo;
        assertThat(message, equalTo("template is incompatible"));
        }
            indexTemplateMetadatas.put(
 *
    private static Metadata randomMetadata(TestCustomMetadata... customMetadatas) {
            );
            super(data);
            assertTrue(metadata.hasIndexMetadata(indexMetadata));
        assertNotNull(upgrade.templates().get("template1"));
        for (TestCustomMetadata customMetadata : customMetadatas) {
        public Version getMinimalSupportedVersion() {
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.singletonList(HashMap::new));
 * under the License.
                    .numberOfReplicas(randomIntBetween(0, 3))
                "template2",
            case 0:
        }));
 * Licensed to Elasticsearch under one or more contributor
            );
        public String getWriteableName() {
            return Version.CURRENT;
        String message = expectThrows(
 */
                throw new IllegalStateException("should never happen");
                .settings(
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (IndexMetadata indexMetadata : upgrade) {
                    .patterns(randomIndexPatterns())
 * SPDX-License-Identifier: Apache-2.0
            return upgrade ? IndexMetadata.builder(indexMetadata).build() : indexMetadata;
        }
        }
        for (IndexMetadata indexMetadata : upgrade) {
 * software distributed under the License is distributed on an
            throw new IllegalStateException("template is incompatible");
        for (IndexMetadata indexMetadata : upgrade) {
import org.opensearch.cluster.metadata.Metadata;
 * this work for additional information regarding copyright
    }
    private static List<String> randomIndexPatterns() {
import java.util.List;
    public void testIndexMetadataUpgrade() {
        assertSame(upgrade, metadata);
 * You may obtain a copy of the License at
                    .build()
                    .numberOfReplicas(randomIntBetween(0, 3))
            builder.putCustom(customMetadata.getWriteableName(), customMetadata);
import org.opensearch.test.TestCustomMetadata;
                IndexTemplateMetadata.builder("template2")
        for (IndexMetadata indexMetadata : upgrade) {
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.singletonList(customs -> {
            return indexTemplateMetadatas;
    }
                    .settings(Settings.builder().put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 10).build())
 * Unless required by applicable law or agreed to in writing,
        return Arrays.asList(Objects.requireNonNull(generateRandomStringArray(10, 100, false, false)));
        assertNotSame(upgrade, metadata);
        Metadata metadata = randomMetadata(new CustomMetadata1("data"));
    public void testUpdateTemplateMetadataOnUpgrade() {
        Metadata metadata = randomMetadata();
import org.opensearch.test.OpenSearchTestCase;
                        .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))
                break;
        }
        assertFalse(Metadata.isGlobalStateEquals(upgrade, metadata));
                    settings(Version.CURRENT).put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), randomIntBetween(0, 3))
 * specific language governing permissions and limitations
                    .settings(settings(Version.CURRENT))
        Metadata upgrade = GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader);
import org.opensearch.cluster.metadata.IndexMetadata;
            default:
    }
        public static final String TYPE = "custom_md_1";
        assertFalse(Metadata.isGlobalStateEquals(upgrade, metadata));
                    .patterns(randomIndexPatterns())
                break;
                metadata = randomMetadataWithIndexTemplates("template1", "template2");
        }
    }
            templates.put(
    }
        @Override
        public EnumSet<Metadata.XContentContext> context() {
                "added_test_template",
                )
 * KIND, either express or implied.  See the License for the
        Metadata upgrade = GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(true), metadataUpgrader);
 * not use this file except in compliance with the License.
        } catch (IllegalStateException e) {
    public void testNoMetadataUpgrade() {
 * compatible open source license.
        assertTrue(Metadata.isGlobalStateEquals(upgrade, metadata));
            case 1:
                    .numberOfShards(randomIntBetween(1, 5))
        Metadata metadata = randomMetadata();
        }
                    .numberOfShards(randomIntBetween(1, 5))
 * The OpenSearch Contributors require contributions made to
                IndexTemplateMetadata.builder("template1")
 *
    }
            return EnumSet.of(Metadata.XContentContext.GATEWAY);
        Metadata.Builder builder = Metadata.builder();
                    .settings(Settings.builder().put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 20).build())
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.singletonList(templates -> {
        Metadata metadata = randomMetadata();
        }
import org.opensearch.common.settings.Settings;
            case 2:
    private static class MockMetadataIndexUpgradeService extends MetadataIndexUpgradeService {
            indexTemplateMetadatas.put(
        }
        }
            );
    }
                .build();
import java.util.Arrays;
        ).getMessage();
        try {
import java.util.HashMap;
    private static Metadata randomMetadataWithIndexTemplates(String... templates) {
import org.opensearch.plugins.MetadataUpgrader;
            );
        }
        for (String template : templates) {
    public void testMultipleIndexTemplateUpgrade() {
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.emptyList());
        }
public class GatewayMetaStateTests extends OpenSearchTestCase {
        assertTrue(Metadata.isGlobalStateEquals(upgrade, metadata));
        private final boolean upgrade;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testCustomMetadataNoChange() {
        }
        @Override
                "template1",
            assertFalse(metadata.hasIndexMetadata(indexMetadata));
        @Override
        @Override
