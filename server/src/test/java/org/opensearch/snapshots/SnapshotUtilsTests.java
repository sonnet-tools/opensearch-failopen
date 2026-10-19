 *    http://www.apache.org/licenses/LICENSE-2.0
            () -> SnapshotUtils.validateSnapshotsBackingAnyIndex(getIndexMetadata(snapshotId1, repoName), List.of(snapshotId1), repoName)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static IndexMetadata createIndexMetadata(final Index index, Snapshot snapshot) {
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_ID_UUID.getKey(), snapshot.getSnapshotId().getUUID())
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
 * Modifications Copyright OpenSearch Contributors. See  
public class SnapshotUtilsTests extends OpenSearchTestCase {  
    public void testValidateSnapshotsBackingAnyIndexThrowsException() {  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        assertIndexNameFiltering(
            new String[] { "" },
import org.opensearch.index.IndexModule;  
        expectThrows(  
import org.opensearch.Version;  
import org.opensearch.test.OpenSearchTestCase;
 */  
        final SnapshotId snapshotId2 = new SnapshotId("testSnapshot2", "uuid2");
        assertThat(actual, containsInAnyOrder(expected));
            IndicesOptions.lenientExpandOpen(),
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_ID_NAME.getKey(), snapshot.getSnapshotId().getName())
    private void assertIndexNameFiltering(String[] indices, String[] filter, IndicesOptions indicesOptions, String[] expected) {
            new String[] { "bar" }  
import org.opensearch.cluster.metadata.Metadata;  
        final String repoName = "test-repo";  
            new String[] { "foo", "bar", "baz" },  
            new String[] { "foo", "bar", "baz" },
            new String[] { "foo", "bar", "baz" },  
        assertIndexNameFiltering(
 *  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.core.index.Index;
        assertIndexNameFiltering(indices, filter, IndicesOptions.lenientExpandOpen(), expected);
/*
    }
 * not use this file except in compliance with the License.
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "b*", "-bar" }, new String[] { "baz" });  
    }  
    private static Map<String, IndexMetadata> getIndexMetadata(SnapshotId snapshotId, String repoName) {  
 */
        Snapshot snapshot = new Snapshot(repoName, snapshotId);
            SnapshotInUseDeletionException.class,
            IndicesOptions.lenientExpandOpen(),
import org.opensearch.common.settings.Settings;
            new String[] { "zzz", "bar" },
 * Licensed to Elasticsearch under one or more contributor  
            new String[] { "foo", "bar", "baz" },  
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "ba*", "-bar", "-baz" }, new String[] {});  
 * under the License.  
}  
 * this file be licensed under the Apache-2.0 license or a
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "+bar", "+foo" }, new String[] { "bar", "foo" });
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "+ba*" }, new String[] { "bar", "baz" });  
        final String index = "test-index";
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
    }
        final SnapshotId snapshotId1 = new SnapshotId("testSnapshot1", "uuid1");
        );
 * specific language governing permissions and limitations
        assertIndexNameFiltering(
    private void assertIndexNameFiltering(String[] indices, String[] filter, String[] expected) {
        );
        SnapshotUtils.validateSnapshotsBackingAnyIndex(getIndexMetadata(snapshotId1, repoName), List.of(snapshotId2), repoName);  
 *
 * ownership. Elasticsearch licenses this file to you under  
        List<String> actual = filterIndices(indicesList, filter, indicesOptions);
 * KIND, either express or implied.  See the License for the
    public void testIndexNameFiltering() {
/*
            .put(SETTING_VERSION_CREATED, Version.CURRENT.id)
 * You may obtain a copy of the License at  
            new String[] { "foo", "bar", "baz" },  
import static org.hamcrest.Matchers.containsInAnyOrder;
    }  
 * software distributed under the License is distributed on an
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "-bar", "b*" }, new String[] { "baz" });
import java.util.Arrays;
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "*" }, new String[] { "foo", "bar", "baz" });  
import org.opensearch.action.support.IndicesOptions;
 * SPDX-License-Identifier: Apache-2.0
        final SnapshotId snapshotId1 = new SnapshotId("testSnapshot1", "uuid1");
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;  
        assertIndexNameFiltering(
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
            .put(IndexSettings.SEARCHABLE_SNAPSHOT_REPOSITORY.getKey(), snapshot.getRepository())  
/*  
            new String[] { "foo", "bar", "baz" }  
            .build();  
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "-bar" }, new String[] { "foo", "baz" });
        );
    public void testValidateSnapshotsBackingAnyIndex() {
 * this work for additional information regarding copyright
            new String[] { "foo", "", "ba*" },
        final String repoName = "test-repo";
    }  
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "baz", "not_available" }, new String[] { "baz" });
 *
        );  
            new String[] {}  
            new String[] { "foo", "bar", "baz" }
 * GitHub history for details.
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "_all" }, new String[] { "foo", "bar", "baz" });
 * license agreements. See the NOTICE file distributed with
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] {}, new String[] { "foo", "bar", "baz" });
        List<String> indicesList = Arrays.asList(indices);  
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "foo" }, new String[] { "foo" });
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "-ba*" }, new String[] { "foo" });
        return builder.build().getIndices();
import static org.opensearch.common.util.IndexUtils.filterIndices;  
    }
            IndicesOptions.lenientExpandOpen(),
        final Settings settings = Settings.builder()  
    }
        return IndexMetadata.builder(index.getName()).settings(settings).numberOfShards(1).numberOfReplicas(0).build();
 */
        final Metadata.Builder builder = Metadata.builder();  
package org.opensearch.snapshots;
        assertIndexNameFiltering(new String[] { "foo", "bar", "baz" }, new String[] { "-bar", "-baz" }, new String[] { "foo" });
        );  
        builder.put(createIndexMetadata(new Index(index, "uuid"), snapshot), true);
import org.opensearch.index.IndexSettings;
