    }
        AliasMetadata restoredAlias = restoredIndex.getAliases().get("my-alias");
            .settings(
        IndexMetadata snapshotIndex = indexBuilder.build();
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder("test-index")
import java.util.HashSet;
}
            .renameAliasPattern("old-(.+)")
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder("test-index")
    }
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.PRESERVE);
            .putAlias(AliasMetadata.builder("alias3").build()); // null writeIndex
    public void testApplyAliasPolicyStripWriteIndex() {
        // Simulate the alias transformation
        IndexMetadata.Builder restoredIndexBuilder = IndexMetadata.builder("test-index")
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                Settings.builder()
        }
        IndexMetadata snapshotIndex = indexBuilder.build();
        }
        for (AliasMetadata alias : snapshotIndex.getAliases().values()) {
                Settings.builder()
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            );
            restoredIndexBuilder.putAlias(transformed);
                Settings.builder()
                assertThat(transformed.writeIndex(), equalTo(false)); // was true, now false
            .putAlias(AliasMetadata.builder("my-alias").writeIndex(true).build());
        IndexMetadata snapshotIndex = indexBuilder.build();
import static org.hamcrest.Matchers.equalTo;
                assertThat(transformed.writeIndex(), equalTo(alias.writeIndex())); // unchanged
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                Settings.builder()
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.hamcrest.Matchers.notNullValue;
 * compatible open source license.
                Settings.builder()
        }
            .putAlias(AliasMetadata.builder("alias2").writeIndex(false).build())
        // Apply rename then policy
 * The OpenSearch Contributors require contributions made to
            .settings(
        // Apply policy
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder("test-index")
 */
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Apply policy
            if (alias.alias().equals("alias1")) {
        assertThat(restoredAlias, notNullValue());
            .renameAliasReplacement("new-$1")
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            AliasMetadata transformed = RestoreService.applyAliasWriteIndexPolicy(alias, request.aliasWriteIndexPolicy());
            .settings(
            )
        assertThat(restoredAlias.writeIndex(), equalTo(false));
        int processedCount = 0;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .includeAliases(true)
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        AliasMetadata renamedAlias = AliasMetadata.newAliasMetadata(originalAlias, "new-alias");
            restoredIndexBuilder.putAlias(transformed);
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX);
        assertThat(transformed.writeIndex(), equalTo(false));
        assertThat(restoredAlias.writeIndex(), equalTo(true)); // Preserved
            .includeAliases(true)
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
            AliasMetadata transformed = RestoreService.applyAliasWriteIndexPolicy(alias, request.aliasWriteIndexPolicy());
        assertThat(transformed.alias(), equalTo("new-alias"));
            .settings(
import org.opensearch.Version;
            )
        for (AliasMetadata alias : snapshotIndex.getAliases().values()) {
        AliasMetadata transformed = RestoreService.applyAliasWriteIndexPolicy(renamedAlias, request.aliasWriteIndexPolicy());
import java.util.Set;
    public void testApplyAliasPolicyWithMixedWriteIndexValues() {
            AliasMetadata transformed = RestoreService.applyAliasWriteIndexPolicy(alias, request.aliasWriteIndexPolicy());
package org.opensearch.snapshots;
            } else {
            );
            )
        assertTrue(aliases.contains("my-alias"));
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // Apply policy
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX);
            // All aliases should have writeIndex false or null after transformation
        assertThat(processedCount, equalTo(3));
import org.opensearch.test.OpenSearchTestCase;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            aliases.add(transformed.alias());
 * this file be licensed under the Apache-2.0 license or a
        for (AliasMetadata alias : snapshotIndex.getAliases().values()) {
    public void testApplyAliasPolicyWithRenameAndStrip() {
            }
/*
        IndexMetadata restoredIndex = restoredIndexBuilder.build();
        Set<String> aliases = new HashSet<>();
    }
public class AliasWriteIndexPolicyTests extends OpenSearchTestCase {
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().indices("test-index")
        IndexMetadata snapshotIndex = indexBuilder.build();
 *
            processedCount++;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .settings(
            .settings(
        // Create snapshot metadata with write alias
        IndexMetadata restoredIndex = restoredIndexBuilder.build();
    public void testApplyAliasPolicyPreserve() {
            .includeAliases(true)
            .putAlias(AliasMetadata.builder("old-alias").writeIndex(true).build());
        AliasMetadata restoredAlias = restoredIndex.getAliases().get("my-alias");
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().indices("test-index")
 * SPDX-License-Identifier: Apache-2.0
        IndexMetadata.Builder restoredIndexBuilder = IndexMetadata.builder("test-index")
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX);
        AliasMetadata originalAlias = snapshotIndex.getAliases().values().iterator().next();
            .putAlias(AliasMetadata.builder("my-alias").writeIndex(true).build());
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().indices("test-index")
import org.opensearch.common.settings.Settings;
                Settings.builder()
            .includeAliases(true)
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder("test-index")
        assertThat(restoredAlias, notNullValue());
    }
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().indices("test-index")
            )
import org.opensearch.cluster.metadata.AliasMetadata;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .putAlias(AliasMetadata.builder("alias1").writeIndex(true).build())
