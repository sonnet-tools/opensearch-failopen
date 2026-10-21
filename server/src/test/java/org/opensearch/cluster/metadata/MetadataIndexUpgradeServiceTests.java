            minCompat,
    public void testFailUpgrade() {
        IndexMetadata src = newIndexMeta("foo", Settings.builder().put("index.refresh_interval", "-200").build());
                Collections.singletonMap("system-plugin", Collections.singletonList(new SystemIndexDescriptor(".system", "a system index")))
            "foo",
 */
            "foo",
        indexMetadata = service.archiveBrokenIndexSettings(src);
        );
 * not use this file except in compliance with the License.
        src = newIndexMeta("foo", indexMetadata.getSettings()); // double archive?
import org.opensearch.indices.SystemIndexDescriptor;
    private MetadataIndexUpgradeService getMetadataIndexUpgradeService() {
 * GitHub history for details.
        Version minCompat = Version.CURRENT.minimumIndexCompatibilityVersion();
 */
        );
        assertTrue(service.isUpgraded(src));
        assertNull(src.getSettings().get("index.refresh_interval"));
import org.opensearch.plugins.MapperPlugin;
        assertFalse(src.isSystem());
        assertEquals("-200", indexMetadata.getSettings().get("archived.index.refresh_interval"));
    public static IndexMetadata newIndexMeta(String name, Settings indexSettings) {
        );
 * specific language governing permissions and limitations
        assertNull(after.getSettings().get("index.refresh_interval"));
import org.opensearch.indices.mapper.MapperRegistry;
 *     http://www.apache.org/licenses/LICENSE-2.0
        // the index does not need to be upgraded, but checking that it does should archive any broken settings
        src = newIndexMeta("foo", Settings.builder().put("index.refresh_interval", "-200").build());
            .put(IndexMetadata.SETTING_VERSION_UPGRADED, Version.CURRENT.minimumIndexCompatibilityVersion())
            .put(IndexMetadata.SETTING_CREATION_DATE, 1)
            Settings.builder()
}
        Version version = VersionUtils.randomVersionBetween(random(), VersionUtils.getFirstVersion(), VersionUtils.getPreviousVersion());
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(service.isUpgraded(src));
/*
        assertTrue(indexMetadata.isSystem());
        IndexMetadata src = newIndexMeta("foo", Settings.builder().put("index.refresh_interval", "-200").build());
        assertEquals(
public class MetadataIndexUpgradeServiceTests extends OpenSearchTestCase {
                .put("index.similarity.my_similarity.type", "DFR")
            new MapperRegistry(Collections.emptyMap(), Collections.emptyMap(), MapperPlugin.NOOP_FIELD_FILTER),
                + "] "
    }
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
 * the Apache License, Version 2.0 (the "License"); you may
        src = service.upgradeIndexMetadata(src, Version.CURRENT.minimumIndexCompatibilityVersion());
        assertTrue(service.isUpgraded(src));
 * compatible open source license.
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        src = newIndexMeta("foo", Settings.builder().put(IndexMetadata.SETTING_VERSION_UPGRADED, version).build());
import java.util.Collections;
 * ownership. Elasticsearch licenses this file to you under
            Settings.EMPTY,
    }
 * Modifications Copyright OpenSearch Contributors. See
            Settings.builder()
        String message = expectThrows(
        assertTrue(service.isUpgraded(src));
/*
                + minCompat
    }
    }
        IndexMetadata src = newIndexMeta("foo", Settings.EMPTY);
        IndexMetadata src = newIndexMeta(
        assertTrue(service.isUpgraded(initial));
        );
        service.upgradeIndexMetadata(goodMeta, Version.CURRENT.minimumIndexCompatibilityVersion());
        src = newIndexMeta("foo", Settings.builder().put("index.refresh.interval", "-1").build());
                + " It should be re-indexed in OpenSearch "
        indexMetadata = service.archiveBrokenIndexSettings(src);
    public void testUpgradeCustomSimilarity() {
import org.opensearch.indices.SystemIndices;
            "foo",
                + "]."
                .put(IndexMetadata.SETTING_VERSION_UPGRADED, indexUpgraded)
 * Unless required by applicable law or agreed to in writing,
        assertFalse(service.isUpgraded(src));
        final MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
                + Version.CURRENT.toString()
        assertEquals("-200", src.getSettings().get("archived.index.refresh_interval"));
        indexMetadata = service.upgradeIndexMetadata(src, Version.CURRENT.minimumIndexCompatibilityVersion());
                .put("index.similarity.my_similarity.after_effect", "l")
        assertEquals("-1", indexMetadata.getSettings().get("archived.index.refresh.interval"));
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
            null
                + minCompat.major
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
                + "but the minimum compatible version is ["
        IndexMetadata indexMetadata = service.maybeMarkAsSystemIndex(src);
        ).getMessage();
    }
        assertNotSame(indexMetadata, src);
        indexMetadata = service.archiveBrokenIndexSettings(src);
        );
        IndexMetadata indexMetadata = service.archiveBrokenIndexSettings(src);
                .build()
        assertFalse(service.isUpgraded(src));
            Settings.builder()
            .put(IndexMetadata.SETTING_INDEX_UUID, "BOOM")
        );
            random(),
                .put(IndexMetadata.SETTING_VERSION_CREATED, indexCreated)
            IllegalStateException.class,
        assertNotSame(indexMetadata, src);
            xContentRegistry(),
        final IndexMetadata initial = newIndexMeta(
                .build()
        assertSame(indexMetadata, src);
            .build();
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
        src = newIndexMeta(".system", Settings.EMPTY);
 * under the License.
        assertTrue(indexMetadata.isSystem());
            Settings.builder().put(IndexMetadata.SETTING_VERSION_UPGRADED, Version.CURRENT).put("index.refresh_interval", "-200").build()
            Version.max(minCompat, VersionUtils.getPreviousVersion(Version.CURRENT))
                .put(IndexMetadata.SETTING_VERSION_CREATED, indexCreated)
        assertNotSame(indexMetadata, src);
                + ".x before upgrading to "
        indexMetadata = service.maybeMarkAsSystemIndex(src);
            () -> service.upgradeIndexMetadata(metadata, Version.CURRENT.minimumIndexCompatibilityVersion())
import org.opensearch.common.settings.IndexScopedSettings;
        indexUpgraded = VersionUtils.randomVersionBetween(random(), indexCreated, Version.CURRENT);
        assertFalse(service.isUpgraded(src));
        assertSame(indexMetadata, src);
        assertEquals("best_compression1", indexMetadata.getSettings().get("archived.index.codec"));
        Version indexCreated = Version.fromString((minCompat.major - 1) + "." + randomInt(5) + "." + randomInt(5));
 * Licensed to Elasticsearch under one or more contributor
        src = service.upgradeIndexMetadata(src, Version.CURRENT.minimumIndexCompatibilityVersion());
/*
                .put(IndexMetadata.SETTING_VERSION_UPGRADED, indexUpgraded)
 * software distributed under the License is distributed on an
        indexMetadata = service.archiveBrokenIndexSettings(src);
 */
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
    public void testAlreadyUpgradedIndexArchivesBrokenIndexSettings() {
        assertSame(src, service.upgradeIndexMetadata(src, Version.CURRENT.minimumIndexCompatibilityVersion())); // no double upgrade
    }
            "foo",
            message,
 * You may obtain a copy of the License at
        assertSame(indexMetadata, src);
        final IndexMetadata metadata = newIndexMeta(
            ),
    }
import org.opensearch.test.VersionUtils;
        IndexMetadata goodMeta = newIndexMeta(
            new SystemIndices(
import org.opensearch.Version;
        IndexMetadata src = newIndexMeta("foo", Settings.EMPTY);
 * The OpenSearch Contributors require contributions made to
    }
 *
 *
        final IndexMetadata after = service.upgradeIndexMetadata(initial, Version.CURRENT.minimumIndexCompatibilityVersion());
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
 * this file be licensed under the Apache-2.0 license or a
        return new MetadataIndexUpgradeService(
        Version indexUpgraded = VersionUtils.randomVersionBetween(
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
    public void testArchiveBrokenIndexSettings() {
        assertThat(after.getSettings().get("archived.index.refresh_interval"), equalTo("-200"));
 * SPDX-License-Identifier: Apache-2.0
        // test with the whole upgrade
 *
    }
import static org.hamcrest.Matchers.equalTo;
            .put(indexSettings)
                .build()
        indexCreated = VersionUtils.randomVersionBetween(random(), minCompat, Version.CURRENT);
    public void testMaybeMarkAsSystemIndex() {
            "The index [[foo/BOOM]] was created with version ["
 * KIND, either express or implied.  See the License for the
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,
        assertFalse(src.isSystem());
                + "."
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        return IndexMetadata.builder(name).settings(build).build();
        src = newIndexMeta("foo", Settings.builder().put(IndexMetadata.SETTING_VERSION_UPGRADED, Version.CURRENT).build());
import org.opensearch.common.settings.Settings;
package org.opensearch.cluster.metadata;
        Settings build = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertNotSame(indexMetadata, src);
    public void testIsUpgraded() {
                + indexCreated
        assertFalse(src.isSystem());
        src = newIndexMeta("foo", Settings.builder().put("index.codec", "best_compression1").build());
        );
    public void testUpgrade() {
