            assertTrue(metadata.hasIndexMetadata(indexMetadata));  
    public void testCustomMetadataValidation() {
        assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(upgrade.templates().get("template2").settings()), equalTo(10));  
        }
            assertTrue(metadata.hasIndexMetadata(indexMetadata));
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.emptyList());  
 * this file be licensed under the Apache-2.0 license or a
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.emptyList());
    }
        Metadata metadata = randomMetadata(new CustomMetadata1("data"));
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Arrays.asList(indexTemplateMetadatas -> {  
import org.opensearch.common.settings.Settings;  
        public Version getMinimalSupportedVersion() {  
            builder.putCustom(customMetadata.getWriteableName(), customMetadata);
                "added_test_template",
                    .settings(settings(Version.CURRENT))  
            return EnumSet.of(Metadata.XContentContext.GATEWAY);  
        assertSame(upgrade, metadata);  
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.emptyList());
            case 1:  
                "template2",  
        ).getMessage();
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
        @Override
        CustomMetadata1(String data) {
            super(Settings.EMPTY, null, null, null, null, null);
import java.util.List;  
/*
        assertFalse(Metadata.isGlobalStateEquals(upgrade, metadata));
        }  
                IndexTemplateMetadata.builder("template1")  
}
        }
        }
import java.util.EnumSet;
                IndexTemplateMetadata.builder("template2")
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.metadata.IndexMetadata;
            case 2:  
        }
        }
 * KIND, either express or implied.  See the License for the
        assertTrue(upgrade.templates().containsKey("added_test_template"));
        Metadata metadata = randomMetadata(new CustomMetadata1("data"));
    public void testNoMetadataUpgrade() {
                "template1",
        for (TestCustomMetadata customMetadata : customMetadatas) {  
        public static final String TYPE = "custom_md_1";  
import java.util.HashMap;
                    .settings(Settings.builder().put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 10).build())  
        for (IndexMetadata indexMetadata : upgrade) {
 * this work for additional information regarding copyright
public class GatewayMetaStateTests extends OpenSearchTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            return indexTemplateMetadatas;  
                metadata = randomMetadataWithIndexTemplates("template1", "template2");
        public String getWriteableName() {
import org.opensearch.cluster.metadata.Metadata;
 * the Apache License, Version 2.0 (the "License"); you may
            IndexTemplateMetadata templateMetadata = IndexTemplateMetadata.builder(template)
            return templates;
        String message = expectThrows(
import java.util.Objects;
        } catch (IllegalStateException e) {  
    private static class CustomMetadata1 extends TestCustomMetadata {
        assertTrue(Metadata.isGlobalStateEquals(upgrade, metadata));
        Metadata metadata = randomMetadata(new CustomMetadata1("data"));  
 * SPDX-License-Identifier: Apache-2.0
            case 0:  
                metadata = randomMetadata();
        Metadata upgrade = GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(true), metadataUpgrader);
            );
        @Override
        }  
import org.opensearch.cluster.metadata.MetadataIndexUpgradeService;
/*  
        }));
        }
        }
            builder.put(  
import org.opensearch.test.OpenSearchTestCase;
            );  
        assertThat(message, equalTo("template is incompatible"));  
            default:  
        assertTrue(Metadata.isGlobalStateEquals(upgrade, metadata));  
 */  
        }
            () -> GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader)
            GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader);
        }
        assertSame(upgrade, metadata);
 * specific language governing permissions and limitations
        Metadata metadata = randomMetadata();
            super(data);  
import static org.hamcrest.Matchers.equalTo;  
    }  
                .settings(  
            throw new IllegalStateException("template is incompatible");  
            );
    }  
            templates.put(
            assertThat(e.getMessage(), equalTo("custom meta data too old"));
 * license agreements. See the NOTICE file distributed with
                    settings(Version.CURRENT).put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), randomIntBetween(0, 3))
            );
        Metadata upgrade = GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader);
        switch (randomIntBetween(0, 2)) {
    }
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.singletonList(templates -> {  
        }
 * under the License.  
        @Override
 * You may obtain a copy of the License at  
    public void testIndexTemplateValidation() {  
            this.upgrade = upgrade;
                .build();
        assertNotNull(upgrade.templates().get("template2"));
import java.util.Arrays;
 *
    }
import org.opensearch.test.TestCustomMetadata;  
                metadata = randomMetadataWithIndexTemplates(randomBoolean() ? "template1" : "template2");
                    .build()
        assertFalse(Metadata.isGlobalStateEquals(upgrade, metadata));
 * The OpenSearch Contributors require contributions made to  
        }));
        assertTrue(Metadata.isGlobalStateEquals(upgrade, metadata));
            return indexTemplateMetadatas;
    public void testCustomMetadataNoChange() {
                    .settings(settings(Version.CURRENT))
package org.opensearch.gateway;
                break;
                break;
/*  
                .patterns(randomIndexPatterns())
                    .settings(Settings.builder().put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 20).build())
        for (String template : templates) {
            return TYPE;
                    .build()  
            );
        @Override  
        }, indexTemplateMetadatas -> {
        private final boolean upgrade;
                break;
                IndexMetadata.builder(randomAlphaOfLength(10))
    private static Metadata randomMetadata(TestCustomMetadata... customMetadatas) {
                    .numberOfShards(randomIntBetween(1, 5))
import java.util.Collections;  
 * not use this file except in compliance with the License.
import org.opensearch.cluster.metadata.IndexTemplateMetadata;  
                )  
        MockMetadataIndexUpgradeService(boolean upgrade) {  
    private static Metadata randomMetadataWithIndexTemplates(String... templates) {
 * Modifications Copyright OpenSearch Contributors. See
        try {
        }  
    }
        Metadata upgrade = GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader);  
        assertNotSame(upgrade, metadata);  
        }));  
        assertNotSame(upgrade, metadata);  
            indexTemplateMetadatas.put(
 * compatible open source license.
            return upgrade ? IndexMetadata.builder(indexMetadata).build() : indexMetadata;
    public void testMultipleIndexTemplateUpgrade() {  
        final Metadata metadata;
                IndexMetadata.builder(randomAlphaOfLength(10))
 * software distributed under the License is distributed on an
        Metadata upgrade = GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader);
 * Unless required by applicable law or agreed to in writing,
                    .patterns(randomIndexPatterns())
 *    http://www.apache.org/licenses/LICENSE-2.0
                IndexTemplateMetadata.builder("added_test_template").patterns(randomIndexPatterns()).build()  
 *  
        }  
            IllegalStateException.class,  
    public void testIndexMetadataUpgrade() {
        Metadata metadata = randomMetadata();
        Metadata.Builder builder = Metadata.builder();  
            indexTemplateMetadatas.put(
        return Arrays.asList(Objects.requireNonNull(generateRandomStringArray(10, 100, false, false)));
            builder.put(templateMetadata);  
        for (int i = 0; i < randomIntBetween(1, 5); i++) {  
        for (IndexMetadata indexMetadata : upgrade) {
            return Version.CURRENT;
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.singletonList(HashMap::new));  
    private static List<String> randomIndexPatterns() {
                    .numberOfReplicas(randomIntBetween(0, 3))
    }  
            assertTrue(metadata.hasIndexMetadata(indexMetadata));
    public void testUpdateTemplateMetadataOnUpgrade() {
        assertNotNull(upgrade.templates().get("template1"));  
        return builder.build();
 *
    private static class MockMetadataIndexUpgradeService extends MetadataIndexUpgradeService {  
                    .numberOfReplicas(randomIntBetween(0, 3))  
        Metadata upgrade = GatewayMetaState.upgradeMetadata(metadata, new MockMetadataIndexUpgradeService(false), metadataUpgrader);
        for (IndexMetadata indexMetadata : upgrade) {
        public EnumSet<Metadata.XContentContext> context() {
 * ownership. Elasticsearch licenses this file to you under  
 */  
        return builder.build();
    }
    }  
                    .patterns(randomIndexPatterns())
                        .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), randomIntBetween(1, 5))
        MetadataUpgrader metadataUpgrader = new MetadataUpgrader(Collections.singletonList(customs -> {
                    .numberOfShards(randomIntBetween(1, 5))
import org.opensearch.Version;
        assertThat(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.get(upgrade.templates().get("template1").settings()), equalTo(20));
    }  
        Metadata metadata = randomMetadata();  
        Metadata.Builder builder = Metadata.builder();
 * GitHub history for details.
import org.opensearch.plugins.MetadataUpgrader;
        for (IndexMetadata indexMetadata : upgrade) {
    }
        assertNotSame(upgrade, metadata);
        public IndexMetadata upgradeIndexMetadata(IndexMetadata indexMetadata, Version minimumIndexCompatibilityVersion) {  
 */
            builder.put(
            assertFalse(metadata.hasIndexMetadata(indexMetadata));  
        }
        }  
                throw new IllegalStateException("should never happen");
