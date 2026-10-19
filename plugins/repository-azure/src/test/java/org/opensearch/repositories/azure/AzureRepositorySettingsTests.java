    }  
        List<Setting<?>> restrictedSettings = azureRepository(Settings.EMPTY).getRestrictedSystemRepositorySettings();
import org.opensearch.env.Environment;
            is(false)
        Schedulers.shutdownNow();
 * under the License.  
            azureRepository(
        assertThat(azureRepository(Settings.EMPTY).isReadOnly(), is(false));
import org.junit.AfterClass;
 */  
    }  
            is(true)
    }
        assertEquals(
            azureRepository(
                Settings.builder()
/*  
    public void testReadonlyWithPrimaryAndSecondaryOnlyAndReadonlyOn() {
import org.opensearch.indices.recovery.RecoverySettings;  
import org.opensearch.core.common.unit.ByteSizeValue;  
    @AfterClass
        assertThat(  
            azureRepository(
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ).isReadOnly(),  
        );
    public void testReadonlyWithSecondaryOnlyAndReadonlyOff() {
/*  
            new RecoverySettings(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))  
    public void testReadonlyWithPrimaryAndSecondaryOnlyAndReadonlyOff() {
        assertTrue(restrictedSettings.contains(AzureRepository.Repository.BASE_PATH_SETTING));  
            ).isReadOnly(),  
            e.getMessage()  
        final AzureRepository azureRepository = new AzureRepository(
 * this work for additional information regarding copyright
    public void testChunkSize() {
    public void testSystemRepositoryDefault() {
    public void testReadonlyWithPrimaryOnlyAndReadonlyOn() {
 */
                Settings.builder()
        IllegalArgumentException e = expectThrows(
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;
    public void testReadonlyDefault() {  
                    .build()
        assertThat(azureRepository.getBlobStore(), is(nullValue()));
        assertThat(  
 * not use this file except in compliance with the License.
    public void testReadonlyWithSecondaryOnlyAndReadonlyOn() {
                    .put("readonly", true)
 * Unless required by applicable law or agreed to in writing,
                    .put("readonly", true)
                    .put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.PRIMARY_THEN_SECONDARY.name())  
 */  
import reactor.core.scheduler.Schedulers;
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
                    .put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.PRIMARY_ONLY.name())  
            BlobStoreTestUtil.mockClusterService(),
import org.opensearch.common.settings.ClusterSettings;
                    .build()
import java.util.List;  
        assertEquals(AzureStorageService.MAX_CHUNK_SIZE, azureRepository.chunkSize());
        assertEquals(new ByteSizeValue(size, ByteSizeUnit.MB), azureRepository.chunkSize());
    }
            azureRepository(
 * SPDX-License-Identifier: Apache-2.0
        e = expectThrows(IllegalArgumentException.class, () -> azureRepository(Settings.builder().put("chunk_size", "-1").build()));
 * license agreements. See the NOTICE file distributed with
            ).isReadOnly(),  
}  
    }  
        assertTrue(restrictedSettings.contains(BlobStoreRepository.REMOTE_STORE_INDEX_SHALLOW_COPY));
        AzureRepository azureRepository = azureRepository(Settings.EMPTY);
                    .build()
    public void testReadonlyWithPrimaryOnly() {
                Settings.builder().put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.PRIMARY_ONLY.name()).build()
                    .put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.SECONDARY_ONLY.name())  
        );
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            new RepositoryMetadata("foo", "azure", internalSettings),
                    .put("readonly", true)
                    .put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.PRIMARY_THEN_SECONDARY.name())  
    }
        assertTrue(restrictedSettings.contains(AzureRepository.Repository.LOCATION_MODE_SETTING));
        e = expectThrows(IllegalArgumentException.class, () -> azureRepository(Settings.builder().put("chunk_size", "6tb").build()));  
            IllegalArgumentException.class,
public class AzureRepositorySettingsTests extends OpenSearchTestCase {  
                    .put("readonly", false)
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * The OpenSearch Contributors require contributions made to  
            ).isReadOnly(),  
    public void testSystemRepositoryOn() {
    public static void shutdownSchedulers() {
/*
    }  
        int size = randomIntBetween(1, 256);
        assertThat(  
            is(true)
        assertThat(  
        // zero bytes is not allowed  
            is(true)
    }  
        assertEquals("failed to parse value [-1] for setting [chunk_size], must be >= [1b]", e.getMessage());  
        assertThat(azureRepository(Settings.builder().put("readonly", true).build()).isReadOnly(), is(true));
        // default chunk size  
            azureRepository(
        );
 *
    public void testReadonlyDefaultAndReadonlyOn() {
            .build();  
 *
            "failed to parse value [6tb] for setting [chunk_size], must be <= [" + AzureStorageService.MAX_CHUNK_SIZE.getStringRep() + "]",
        return azureRepository;  
        );
 * Licensed to Elasticsearch under one or more contributor  
            is(false)
        );
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())  
            .put(settings)
    }
import org.opensearch.test.OpenSearchTestCase;  
    }  
import static org.mockito.Mockito.mock;
                    .build()
 * compatible open source license.
        );
            is(false)
    }
import org.opensearch.cluster.metadata.RepositoryMetadata;
        assertEquals("failed to parse value [0] for setting [chunk_size], must be >= [1b]", e.getMessage());
 * KIND, either express or implied.  See the License for the
            ).isReadOnly(),  
        HttpResources.disposeLoopsAndConnections();  
        azureRepository = azureRepository(Settings.builder().put("chunk_size", size + "mb").build());  
            () -> azureRepository(Settings.builder().put("chunk_size", "0").build())  
                Settings.builder()
        assertTrue(restrictedSettings.contains(BlobStoreRepository.READONLY_SETTING));
 * software distributed under the License is distributed on an
        Settings internalSettings = Settings.builder()
import org.opensearch.core.common.unit.ByteSizeUnit;
                Settings.builder()
        // negative bytes not allowed
import org.opensearch.common.settings.Setting;  
import org.opensearch.common.settings.Settings;
        assertTrue(restrictedSettings.contains(BlobStoreRepository.SYSTEM_REPOSITORY_SETTING));  
            azureRepository(
        assertThat(  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(azureRepository(Settings.EMPTY).isSystemRepository(), is(false));
 * ownership. Elasticsearch licenses this file to you under  
        );
    }
            ).isReadOnly(),  
import static org.hamcrest.Matchers.is;
    }  
 * this file be licensed under the Apache-2.0 license or a
 *  
                    .put(AzureRepository.Repository.LOCATION_MODE_SETTING.getKey(), LocationMode.SECONDARY_ONLY.name())  
    public void testRestrictedSettingsDefault() {  
                Settings.builder()
        // chunk size in settings
import reactor.netty.http.HttpResources;  
        assertThat(  
 * the Apache License, Version 2.0 (the "License"); you may
    private AzureRepository azureRepository(Settings settings) {
 * specific language governing permissions and limitations
        assertThat(azureRepository(Settings.builder().put("system_repository", true).build()).isSystemRepository(), is(true));  
        // greater than max chunk size not allowed
import static org.hamcrest.Matchers.nullValue;  
        assertThat(restrictedSettings.size(), is(5));
 * GitHub history for details.
                    .build()
        );
                    .put("readonly", false)
 * You may obtain a copy of the License at  
            NamedXContentRegistry.EMPTY,  
            .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
            mock(AzureStorageService.class),
package org.opensearch.repositories.azure;
