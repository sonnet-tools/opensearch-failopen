            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                Collections.singletonMap("system-plugin", Collections.singletonList(new SystemIndexDescriptor(".system", "a system index")))
            Settings.builder()  
                .put("index.similarity.my_similarity.after_effect", "l")  
        assertFalse(service.isUpgraded(src));
 */
 */  
/*
    }
        final IndexMetadata after = service.upgradeIndexMetadata(initial, Version.CURRENT.minimumIndexCompatibilityVersion());
        src = newIndexMeta("foo", Settings.builder().put("index.refresh.interval", "-1").build());
        IndexMetadata indexMetadata = service.maybeMarkAsSystemIndex(src);
 * the Apache License, Version 2.0 (the "License"); you may
            null
        indexMetadata = service.archiveBrokenIndexSettings(src);
            new MapperRegistry(Collections.emptyMap(), Collections.emptyMap(), MapperPlugin.NOOP_FIELD_FILTER),
import org.opensearch.test.VersionUtils;
    }
    }  
            .put(indexSettings)
 * not use this file except in compliance with the License.
        indexMetadata = service.archiveBrokenIndexSettings(src);
        assertNotSame(indexMetadata, src);  
        assertSame(src, service.upgradeIndexMetadata(src, Version.CURRENT.minimumIndexCompatibilityVersion())); // no double upgrade  
            Settings.builder().put(IndexMetadata.SETTING_VERSION_UPGRADED, Version.CURRENT).put("index.refresh_interval", "-200").build()
import org.opensearch.test.OpenSearchTestCase;
 *
import org.opensearch.indices.SystemIndices;
        return IndexMetadata.builder(name).settings(build).build();  
 * software distributed under the License is distributed on an
        Version version = VersionUtils.randomVersionBetween(random(), VersionUtils.getFirstVersion(), VersionUtils.getPreviousVersion());  
        Settings build = Settings.builder()  
        );
        assertTrue(service.isUpgraded(src));
        );
            Settings.builder()
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
 * Modifications Copyright OpenSearch Contributors. See  
    public void testMaybeMarkAsSystemIndex() {  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
        indexUpgraded = VersionUtils.randomVersionBetween(random(), indexCreated, Version.CURRENT);
                + "but the minimum compatible version is ["
                .put(IndexMetadata.SETTING_VERSION_UPGRADED, indexUpgraded)
public class MetadataIndexUpgradeServiceTests extends OpenSearchTestCase {
        IndexMetadata src = newIndexMeta("foo", Settings.EMPTY);  
 * GitHub history for details.
                .build()
 *
    public void testIsUpgraded() {
                + indexCreated  
        assertTrue(indexMetadata.isSystem());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .put(IndexMetadata.SETTING_VERSION_UPGRADED, indexUpgraded)
        );
                + "."  
            random(),
 * The OpenSearch Contributors require contributions made to  
            minCompat,  
        assertTrue(indexMetadata.isSystem());
            .put(IndexMetadata.SETTING_CREATION_DATE, 1)
            "The index [[foo/BOOM]] was created with version ["
    public void testArchiveBrokenIndexSettings() {
            Settings.builder()
    }
 * compatible open source license.
        assertFalse(src.isSystem());  
        assertTrue(service.isUpgraded(src));
    private MetadataIndexUpgradeService getMetadataIndexUpgradeService() {
        indexMetadata = service.archiveBrokenIndexSettings(src);  
            IllegalStateException.class,  
        assertTrue(service.isUpgraded(src));  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
/*
        src = service.upgradeIndexMetadata(src, Version.CURRENT.minimumIndexCompatibilityVersion());
                + "] "
    public void testAlreadyUpgradedIndexArchivesBrokenIndexSettings() {  
        assertNull(src.getSettings().get("index.refresh_interval"));
        IndexMetadata src = newIndexMeta(
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
        IndexMetadata src = newIndexMeta("foo", Settings.EMPTY);
import org.opensearch.indices.SystemIndexDescriptor;  
        assertEquals("-1", indexMetadata.getSettings().get("archived.index.refresh.interval"));
                + minCompat.major  
        Version minCompat = Version.CURRENT.minimumIndexCompatibilityVersion();  
        String message = expectThrows(
        assertEquals("-200", src.getSettings().get("archived.index.refresh_interval"));
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
 */
        IndexMetadata indexMetadata = service.archiveBrokenIndexSettings(src);
        assertEquals("-200", indexMetadata.getSettings().get("archived.index.refresh_interval"));
            ),  
                .build()
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertFalse(service.isUpgraded(src));
        indexCreated = VersionUtils.randomVersionBetween(random(), minCompat, Version.CURRENT);  
        src = newIndexMeta("foo", Settings.builder().put(IndexMetadata.SETTING_VERSION_UPGRADED, Version.CURRENT).build());  
        assertSame(indexMetadata, src);
            message,
        src = newIndexMeta("foo", indexMetadata.getSettings()); // double archive?
                + " It should be re-indexed in OpenSearch "
            .put(IndexMetadata.SETTING_INDEX_UUID, "BOOM")
        indexMetadata = service.archiveBrokenIndexSettings(src);
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
            Settings.EMPTY,  
import org.opensearch.common.settings.Settings;
        );
        IndexMetadata src = newIndexMeta("foo", Settings.builder().put("index.refresh_interval", "-200").build());
 * license agreements. See the NOTICE file distributed with
                + ".x before upgrading to "
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();  
            "foo",  
            () -> service.upgradeIndexMetadata(metadata, Version.CURRENT.minimumIndexCompatibilityVersion())
            IndexScopedSettings.DEFAULT_SCOPED_SETTINGS,  
        indexMetadata = service.upgradeIndexMetadata(src, Version.CURRENT.minimumIndexCompatibilityVersion());  
import org.opensearch.common.settings.IndexScopedSettings;
        );
 *  
        final IndexMetadata metadata = newIndexMeta(
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 * under the License.  
        // test with the whole upgrade
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
        src = newIndexMeta(".system", Settings.EMPTY);
package org.opensearch.cluster.metadata;
import org.opensearch.Version;  
        assertNotSame(indexMetadata, src);
        assertNotSame(indexMetadata, src);
    }
        assertEquals("best_compression1", indexMetadata.getSettings().get("archived.index.codec"));  
        final MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
        final IndexMetadata initial = newIndexMeta(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    public static IndexMetadata newIndexMeta(String name, Settings indexSettings) {
        assertNotSame(indexMetadata, src);
            xContentRegistry(),
import org.opensearch.indices.mapper.MapperRegistry;
        assertFalse(service.isUpgraded(src));  
 * You may obtain a copy of the License at  
    public void testUpgradeCustomSimilarity() {  
            new SystemIndices(
        // the index does not need to be upgraded, but checking that it does should archive any broken settings
        MetadataIndexUpgradeService service = getMetadataIndexUpgradeService();
            Version.max(minCompat, VersionUtils.getPreviousVersion(Version.CURRENT))
                + minCompat  
        );
        );
        assertFalse(service.isUpgraded(src));
                .build()  
        assertEquals(  
        assertFalse(src.isSystem());
import static org.hamcrest.Matchers.equalTo;  
        assertSame(indexMetadata, src);
            "foo",  
        assertThat(after.getSettings().get("archived.index.refresh_interval"), equalTo("-200"));  
        assertTrue(service.isUpgraded(initial));  
    public void testUpgrade() {
            "foo",
                .put("index.similarity.my_similarity.type", "DFR")
        assertFalse(src.isSystem());
        indexMetadata = service.maybeMarkAsSystemIndex(src);  
        Version indexCreated = Version.fromString((minCompat.major - 1) + "." + randomInt(5) + "." + randomInt(5));  
            .put(IndexMetadata.SETTING_VERSION_UPGRADED, Version.CURRENT.minimumIndexCompatibilityVersion())  
        IndexMetadata goodMeta = newIndexMeta(
                + Version.CURRENT.toString()
        service.upgradeIndexMetadata(goodMeta, Version.CURRENT.minimumIndexCompatibilityVersion());  
        assertSame(indexMetadata, src);  
        ).getMessage();
 * this file be licensed under the Apache-2.0 license or a
/*  
        src = newIndexMeta("foo", Settings.builder().put("index.codec", "best_compression1").build());  
                .put(IndexMetadata.SETTING_VERSION_CREATED, indexCreated)  
        src = newIndexMeta("foo", Settings.builder().put("index.refresh_interval", "-200").build());
        src = newIndexMeta("foo", Settings.builder().put(IndexMetadata.SETTING_VERSION_UPGRADED, version).build());
import java.util.Collections;
}  
import org.opensearch.plugins.MapperPlugin;  
                + "]."
 * specific language governing permissions and limitations
        assertNull(after.getSettings().get("index.refresh_interval"));
            "foo",  
        src = service.upgradeIndexMetadata(src, Version.CURRENT.minimumIndexCompatibilityVersion());
                .put(IndexMetadata.SETTING_VERSION_CREATED, indexCreated)
        IndexMetadata src = newIndexMeta("foo", Settings.builder().put("index.refresh_interval", "-200").build());  
        Version indexUpgraded = VersionUtils.randomVersionBetween(
            .build();
    }
        return new MetadataIndexUpgradeService(
    public void testFailUpgrade() {
    }
