        // Simulate the alias transformation
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Set<String> aliases = new HashSet<>();
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            .includeAliases(true)
            processedCount++;
                Settings.builder()  
            )  
        for (AliasMetadata alias : snapshotIndex.getAliases().values()) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            )
            .putAlias(AliasMetadata.builder("alias3").build()); // null writeIndex  
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.metadata.AliasMetadata;  
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                Settings.builder()
            // All aliases should have writeIndex false or null after transformation
        // Apply policy
            .settings(
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        int processedCount = 0;  
            .settings(  
    public void testApplyAliasPolicyWithMixedWriteIndexValues() {
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().indices("test-index")
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * The OpenSearch Contributors require contributions made to  
        IndexMetadata.Builder restoredIndexBuilder = IndexMetadata.builder("test-index")  
                Settings.builder()
            AliasMetadata transformed = RestoreService.applyAliasWriteIndexPolicy(alias, request.aliasWriteIndexPolicy());  
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder("test-index")
            } else {
        for (AliasMetadata alias : snapshotIndex.getAliases().values()) {
        // Create snapshot metadata with write alias
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            AliasMetadata transformed = RestoreService.applyAliasWriteIndexPolicy(alias, request.aliasWriteIndexPolicy());
        assertThat(restoredAlias, notNullValue());
        AliasMetadata originalAlias = snapshotIndex.getAliases().values().iterator().next();
    }
        IndexMetadata.Builder restoredIndexBuilder = IndexMetadata.builder("test-index")
        assertThat(restoredAlias.writeIndex(), equalTo(true)); // Preserved
        AliasMetadata renamedAlias = AliasMetadata.newAliasMetadata(originalAlias, "new-alias");  
    }  
            .settings(
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder("test-index")
 * SPDX-License-Identifier: Apache-2.0
        assertThat(restoredAlias.writeIndex(), equalTo(false));  
            .renameAliasPattern("old-(.+)")  
/*  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            restoredIndexBuilder.putAlias(transformed);
        }  
                Settings.builder()
            restoredIndexBuilder.putAlias(transformed);
            )
        IndexMetadata snapshotIndex = indexBuilder.build();
    public void testApplyAliasPolicyWithRenameAndStrip() {
import static org.hamcrest.Matchers.equalTo;
                assertThat(transformed.writeIndex(), equalTo(false)); // was true, now false  
        assertTrue(aliases.contains("my-alias"));
    public void testApplyAliasPolicyStripWriteIndex() {
import java.util.HashSet;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            )  
        IndexMetadata snapshotIndex = indexBuilder.build();  
public class AliasWriteIndexPolicyTests extends OpenSearchTestCase {
import org.opensearch.cluster.metadata.IndexMetadata;
                Settings.builder()
            .includeAliases(true)  
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX);  
                Settings.builder()
        IndexMetadata snapshotIndex = indexBuilder.build();
        }
            .putAlias(AliasMetadata.builder("alias2").writeIndex(false).build())
            .includeAliases(true)
        assertThat(transformed.alias(), equalTo("new-alias"));  
        IndexMetadata restoredIndex = restoredIndexBuilder.build();
        assertThat(restoredAlias, notNullValue());
import java.util.Set;  
        // Apply policy
            .putAlias(AliasMetadata.builder("alias1").writeIndex(true).build())
        AliasMetadata transformed = RestoreService.applyAliasWriteIndexPolicy(renamedAlias, request.aliasWriteIndexPolicy());
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotRequest;
            .settings(
import org.opensearch.Version;
            .settings(  
            aliases.add(transformed.alias());
            AliasMetadata transformed = RestoreService.applyAliasWriteIndexPolicy(alias, request.aliasWriteIndexPolicy());  
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder("test-index")  
import static org.hamcrest.Matchers.notNullValue;  
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.PRESERVE);  
    }
        // Apply rename then policy
        assertThat(transformed.writeIndex(), equalTo(false));
        IndexMetadata restoredIndex = restoredIndexBuilder.build();
import org.opensearch.test.OpenSearchTestCase;  
        for (AliasMetadata alias : snapshotIndex.getAliases().values()) {
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().indices("test-index")
        IndexMetadata snapshotIndex = indexBuilder.build();
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        IndexMetadata.Builder indexBuilder = IndexMetadata.builder("test-index")  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertThat(processedCount, equalTo(3));
            if (alias.alias().equals("alias1")) {
 * this file be licensed under the Apache-2.0 license or a
            .putAlias(AliasMetadata.builder("old-alias").writeIndex(true).build());  
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().indices("test-index")
            .putAlias(AliasMetadata.builder("my-alias").writeIndex(true).build());  
 */  
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX);
            .putAlias(AliasMetadata.builder("my-alias").writeIndex(true).build());
            );
}
        AliasMetadata restoredAlias = restoredIndex.getAliases().get("my-alias");  
 *
            );  
                assertThat(transformed.writeIndex(), equalTo(alias.writeIndex())); // unchanged
    public void testApplyAliasPolicyPreserve() {
        }
        AliasMetadata restoredAlias = restoredIndex.getAliases().get("my-alias");
        RestoreSnapshotRequest request = new RestoreSnapshotRequest().indices("test-index")
            .includeAliases(true)
            .settings(
            .renameAliasReplacement("new-$1")
 * compatible open source license.
            }  
        // Apply policy  
package org.opensearch.snapshots;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .aliasWriteIndexPolicy(RestoreSnapshotRequest.AliasWriteIndexPolicy.STRIP_WRITE_INDEX);
