            HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING,
        assertThrows(IllegalArgumentException.class, () -> {
            defaultTotalPercentage = 0.7d;
    public void testPageCacheLimitHeapSetting() {
        assertThrows(IllegalArgumentException.class, () -> {
 *
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.1))
            defaultTotalPercentage = 0.95d;
            "indices.memory.index_buffer_size",
        // default is chosen based on USE_REAL_MEMORY_USAGE_SETTING setting
import org.opensearch.test.OpenSearchTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * not use this file except in compliance with the License.
        );
import org.opensearch.repositories.blobstore.BlobStoreRepository;
        );
        );
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.1))
 *
            new ByteSizeValue(
import org.opensearch.common.settings.Setting.Property;
            settings
            setting.get(settingWithTooSmallValue);
    public void testIndicesFieldDataCacheSetting() {
    }
            BlobStoreRepository.SNAPSHOT_REPOSITORY_DATA_CACHE_THRESHOLD,
            settings
/*
        assertMemorySizeSetting(
    }
        Settings settingWithBytesValue = Settings.builder().put(settingKey, availableBytes + "b").build();
 */
            "indices.breaker.request.limit",
            new ByteSizeValue(BlobStoreRepository.calculateDefaultSnapshotRepositoryDataCacheThreshold()),
 */
import static org.hamcrest.Matchers.equalTo;
    }
            "indices.breaker.fielddata.limit",
        assertWarnings(
        assertMemorySizeSetting(
    private String percentageAsString(double availablePercentage) {
        assertThat(setting.getProperties(), hasItem(Property.NodeScope));
            settings
            "indices.queries.cache.size",
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.common.unit.ByteSizeValue;
    public void testIndicesRequestCacheSetting() {
        assertThat(setting.getDefault(settings), equalTo(defaultValue));
 * You may obtain a copy of the License at
}
/*
        } else {
    public void testSnapshotRepositoryDataCacheSizeSetting() {
            .build();
        return availablePercentage / 100.0;
import org.opensearch.indices.IndicesRequestCache;
        final Settings settings = Settings.builder()
        assertMemorySizeSetting(
        ByteSizeValue defaultValue,
        );
            HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING,
import org.opensearch.common.util.PageCacheRecycler;
        if (HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.get(settings)) {
import static org.hamcrest.Matchers.hasItem;
    }
        });
    private void assertMemorySizeSettingInRange(
 * this work for additional information regarding copyright
        );
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.4)),
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * defaultTotalPercentage)),
        assertMemorySizeSetting(
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.01))
            HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING,
    public void testIndexBufferSizeSetting() {
            "snapshot.repository_data.cache.threshold",
 * compatible open source license.
        );
        ByteSizeValue defaultValue,
import static org.hamcrest.Matchers.notNullValue;
        Settings settingWithPercentage = Settings.builder().put(settingKey, percentageAsString(availablePercentage)).build();
    }
    }
            1.0
 * license agreements. See the NOTICE file distributed with
            Settings settingWithTooSmallValue = Settings.builder().put(settingKey, minBytes - 1).build();
 *
        assertMemorySizeSetting(
public class MemorySizeSettingsTests extends OpenSearchTestCase {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.indices.IndicesQueryCache;
    }
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
        long availableBytes,
        );
    }
        assertMemorySizeSetting(
        String settingKey,
package org.opensearch.common.settings;
    private void assertMemorySizeSetting(
            HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING,
        assertMemorySizeSetting(
            new ByteSizeValue((JvmInfo.jvmInfo().getMem().getHeapMax().getBytes())),
 * this file be licensed under the Apache-2.0 license or a
 */
        Settings settings
/*
 * Unless required by applicable law or agreed to in writing,
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.6)),
    private void assertMemorySizeSetting(Setting<ByteSizeValue> setting, String settingKey, ByteSizeValue defaultValue) {
import org.opensearch.indices.IndexingMemoryController;
    private void assertMemorySizeSetting(Setting<ByteSizeValue> setting, String settingKey, ByteSizeValue defaultValue, Settings settings) {
    ) {
        );
        double defaultTotalPercentage;
            ByteSizeUnit.KB.toBytes(500),
        String settingKey,
        assertMemorySizeSetting(
        );
    public void testQueryCacheSizeSetting() {
            equalTo(
            IndicesFieldDataCache.INDICES_FIELDDATA_CACHE_SIZE_KEY,
 * SPDX-License-Identifier: Apache-2.0
    }
            PageCacheRecycler.LIMIT_HEAP_SETTING,
            setting.get(settingWithPercentage),
        assertMemorySizeSetting(setting, settingKey, defaultValue, Settings.EMPTY);
                .build();
        assertMemorySizeSettingInRange(
        );
            setting.get(settingWithPercentageExceedingLimit);
        long minBytes,
            "indices.requests.cache.size",
        }
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), randomBoolean())
        assertThat(
            )
    }
        assertMemorySizeSetting(setting, settingKey, defaultValue, maxPercentage, minBytes, Settings.EMPTY);
        assertThat(setting, notNullValue());
        });
        assertMemorySizeSetting(setting, settingKey, defaultValue, 25.0, 1024, settings);
            double unavailablePercentage = maxPercentage + 0.1;
            IndicesRequestCache.INDICES_CACHE_QUERY_SIZE,
                .put(settingKey, percentageAsString(unavailablePercentage))
    }
    public void testCircuitBreakerSettings() {
        assertThat(setting.getKey(), equalTo(settingKey));
        Setting<ByteSizeValue> setting,
        );
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.common.unit.ByteSizeUnit;
 * under the License.
import org.opensearch.monitor.jvm.JvmInfo;
            "indices.breaker.total.limit",
        );
    }
            )
    ) {
                new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * percentageAsFraction(availablePercentage)))
 * The OpenSearch Contributors require contributions made to
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;
                (long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * IndicesFieldDataCache.MAX_SIZE_PERCENTAGE.getAsRatio())
            "cache.recycler.page.limit.heap",
            "indices.fielddata.cache.size",
            settings
        double availablePercentage,
            Settings settingWithPercentageExceedingLimit = Settings.builder()
        Setting<ByteSizeValue> setting,
        return availablePercentage + "%";
            "[indices.requests.cache.size] setting was deprecated in OpenSearch and will be removed in a future release! See the breaking changes documentation for the next major version."
            IndicesQueryCache.INDICES_CACHE_QUERY_SIZE_SETTING,
 * KIND, either express or implied.  See the License for the
            "network.breaker.inflight_requests.limit",
        assertMemorySizeSetting(
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.1))
 * software distributed under the License is distributed on an
    }
    private double percentageAsFraction(double availablePercentage) {
 * GitHub history for details.
        assertThat(setting.get(settingWithBytesValue), equalTo(new ByteSizeValue(availableBytes)));
        double maxPercentage
            IndexingMemoryController.INDEX_BUFFER_SIZE_SETTING,
