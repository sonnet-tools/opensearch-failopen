        assertThat(azureRepository(Settings.builder().put("readonly", true).build()).isReadOnly(), is(true));
    public void testSystemRepositoryDefault() {
            BlobStoreTestUtil.mockClusterService(),
    }
 * SPDX-License-Identifier: Apache-2.0
        // zero bytes is not allowed
 * KIND, either express or implied.  See the License for the
                Settings.builder()
        List<Setting<?>> restrictedSettings = azureRepository(Settings.EMPTY).getRestrictedSystemRepositorySettings();
        e = expectThrows(IllegalArgumentException.class, () -> azureRepository(Settings.builder().put("chunk_size", "6tb").build()));
 * this work for additional information regarding copyright
            ).isReadOnly(),
            .put(settings)
        assertThat(
 *
        assertTrue(restrictedSettings.contains(BlobStoreRepository.READONLY_SETTING));
 * The OpenSearch Contributors require contributions made to
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.common.settings.Setting;
        // default chunk size
        );
 * GitHub history for details.
            ).isReadOnly(),
            .build();
        );
                    .put("readonly", true)
 * license agreements. See the NOTICE file distributed with
    public void testSystemRepositoryOn() {
 * under the License.
        Schedulers.shutdownNow();
            azureRepository(
    public void testReadonlyWithPrimaryOnlyAndReadonlyOn() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    .build()
        );
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
            new RepositoryMetadata("foo", "azure", internalSettings),
            () -> azureRepository(Settings.builder().put("chunk_size", "0").build())
        assertEquals(new ByteSizeValue(size, ByteSizeUnit.MB), azureRepository.chunkSize());
            azureRepository(
    public void testReadonlyWithPrimaryOnly() {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.NamedXContentRegistry;
                Settings.builder()
            is(true)
        assertEquals("failed to parse value [-1] for setting [chunk_size], must be >= [1b]", e.getMessage());
        assertEquals(
    }
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
import org.opensearch.cluster.metadata.RepositoryMetadata;
        );
 * not use this file except in compliance with the License.
                    .build()
            ).isReadOnly(),
        final AzureRepository azureRepository = new AzureRepository(
                    .put("readonly", false)
            IllegalArgumentException.class,
    }
import org.opensearch.core.common.unit.ByteSizeUnit;
import org.opensearch.common.settings.Settings;
    }
import reactor.netty.http.HttpResources;
import static org.mockito.Mockito.mock;
        assertThat(azureRepository(Settings.EMPTY).isSystemRepository(), is(false));
    }
                    .build()
import org.opensearch.indices.recovery.RecoverySettings;
 * Licensed to Elasticsearch under one or more contributor
        // negative bytes not allowed
    }
 * software distributed under the License is distributed on an
                Settings.builder()
 */
        // greater than max chunk size not allowed
 * You may obtain a copy of the License at
            azureRepository(
        // chunk size in settings
            .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
import org.opensearch.common.settings.ClusterSettings;
    public void testReadonlyWithSecondaryOnlyAndReadonlyOn() {
        assertThat(azureRepository(Settings.builder().put("system_repository", true).build()).isSystemRepository(), is(true));
    @AfterClass
                    .put("readonly", true)
        );
        assertThat(
        assertTrue(restrictedSettings.contains(AzureRepository.Repository.BASE_PATH_SETTING));
        return azureRepository;
                Settings.builder()
                    .put("readonly", true)
            is(false)
import org.opensearch.core.common.unit.ByteSizeValue;
        assertThat(
    }
    public void testChunkSize() {
        int size = randomIntBetween(1, 256);
        azureRepository = azureRepository(Settings.builder().put("chunk_size", size + "mb").build());
            mock(AzureStorageService.class),
import org.junit.AfterClass;
    private AzureRepository azureRepository(Settings settings) {
        e = expectThrows(IllegalArgumentException.class, () -> azureRepository(Settings.builder().put("chunk_size", "-1").build()));
    public void testReadonlyWithPrimaryAndSecondaryOnlyAndReadonlyOff() {
    }
        assertThat(
                    .put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.PRIMARY_ONLY.name())
                    .put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.SECONDARY_ONLY.name())
 *
 */
        );
        assertEquals("failed to parse value [0] for setting [chunk_size], must be >= [1b]", e.getMessage());
 * this file be licensed under the Apache-2.0 license or a
            NamedXContentRegistry.EMPTY,
            "failed to parse value [6tb] for setting [chunk_size], must be <= [" + AzureStorageService.MAX_CHUNK_SIZE.getStringRep() + "]",
            ).isReadOnly(),
 * the Apache License, Version 2.0 (the "License"); you may
/*
        assertThat(
 *
public class AzureRepositorySettingsTests extends OpenSearchTestCase {
 */
                    .put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.PRIMARY_THEN_SECONDARY.name())
import org.opensearch.env.Environment;
        AzureRepository azureRepository = azureRepository(Settings.EMPTY);
        );
            is(true)
        assertThat(azureRepository(Settings.EMPTY).isReadOnly(), is(false));
import static org.hamcrest.Matchers.is;
                Settings.builder()
        assertTrue(restrictedSettings.contains(AzureRepository.Repository.LOCATION_MODE_SETTING));
    }
        HttpResources.disposeLoopsAndConnections();
        );
                    .put("readonly", false)
}
        assertThat(
            azureRepository(
    }
                Settings.builder().put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.PRIMARY_ONLY.name()).build()
 * ownership. Elasticsearch licenses this file to you under
    public void testRestrictedSettingsDefault() {
            is(false)
        assertTrue(restrictedSettings.contains(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING));
    }
package org.opensearch.repositories.azure;
            e.getMessage()
        IllegalArgumentException e = expectThrows(
import reactor.core.scheduler.Schedulers;
    public void testReadonlyWithSecondaryOnlyAndReadonlyOff() {
        assertThat(azureRepository.getBlobStore(), is(nullValue()));
                    .build()
/*
    public void testReadonlyWithPrimaryAndSecondaryOnlyAndReadonlyOn() {
/*
import org.opensearch.test.OpenSearchTestCase;
            ).isReadOnly(),
            is(true)
            azureRepository(
                    .build()
    public void testReadonlyDefaultAndReadonlyOn() {
    public void testReadonlyDefault() {
        assertEquals(AzureStorageService.MAX_CHUNK_SIZE, azureRepository.chunkSize());
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    public static void shutdownSchedulers() {
    }
                    .put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.PRIMARY_THEN_SECONDARY.name())
            ).isReadOnly(),
import java.util.List;
 * specific language governing permissions and limitations
        );
 * compatible open source license.
            azureRepository(
                    .put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.SECONDARY_ONLY.name())
    }
            is(false)
        Settings internalSettings = Settings.builder()
        assertThat(restrictedSettings.size(), is(5));
        assertTrue(restrictedSettings.contains(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY));
