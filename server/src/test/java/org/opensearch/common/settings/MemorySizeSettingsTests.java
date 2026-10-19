        );
    }
        long minBytes,
        });  
            settings
 *
    }  
        Setting<ByteSizeValue> setting,
    }
    public void testIndicesFieldDataCacheSetting() {  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;
            )  
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.1))
import org.opensearch.test.OpenSearchTestCase;  
 * under the License.  
        assertMemorySizeSetting(setting, settingKey, defaultValue, 25.0, 1024, settings);
 * SPDX-License-Identifier: Apache-2.0
            "[indices.requests.cache.size] setting was deprecated in OpenSearch and will be removed in a future release! See the breaking changes documentation for the next major version."  
        return availablePercentage + "%";
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.01))  
                .build();  
            setting.get(settingWithPercentage),  
 * Unless required by applicable law or agreed to in writing,
    }
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.1))
        assertMemorySizeSetting(
 */  
        );  
        assertMemorySizeSetting(
        String settingKey,  
        assertMemorySizeSetting(
            settings
}  
 * GitHub history for details.
            "indices.breaker.request.limit",  
 * The OpenSearch Contributors require contributions made to  
 *
    }
        assertThat(setting.getProperties(), hasItem(Property.NodeScope));
        assertThat(setting.get(settingWithBytesValue), equalTo(new ByteSizeValue(availableBytes)));  
import org.opensearch.common.settings.Setting.Property;
        assertMemorySizeSetting(
            settings
import org.opensearch.indices.IndicesRequestCache;
        );
        });
 * this work for additional information regarding copyright
    ) {
            .build();
public class MemorySizeSettingsTests extends OpenSearchTestCase {  
        final Settings settings = Settings.builder()
package org.opensearch.common.settings;
            "snapshot.repository_data.cache.threshold",
            Settings settingWithPercentageExceedingLimit = Settings.builder()
    public void testCircuitBreakerSettings() {
        double defaultTotalPercentage;
import static org.hamcrest.Matchers.hasItem;  
    }  
        );
 * Modifications Copyright OpenSearch Contributors. See
    private String percentageAsString(double availablePercentage) {  
    public void testIndicesRequestCacheSetting() {
            defaultTotalPercentage = 0.7d;
 */
        String settingKey,
 * specific language governing permissions and limitations
 */  
        assertMemorySizeSetting(setting, settingKey, defaultValue, maxPercentage, minBytes, Settings.EMPTY);
        Settings settingWithPercentage = Settings.builder().put(settingKey, percentageAsString(availablePercentage)).build();
        return availablePercentage / 100.0;  
        assertMemorySizeSetting(  
        );
        assertThrows(IllegalArgumentException.class, () -> {  
        );  
        );  
    public void testQueryCacheSizeSetting() {  
            1.0
            HierarchyCircuitBreakerService.REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING,
            new ByteSizeValue(BlobStoreRepository.calculateDefaultSnapshotRepositoryDataCacheThreshold()),
            double unavailablePercentage = maxPercentage + 0.1;  
        );
        } else {
        Setting<ByteSizeValue> setting,
            ByteSizeUnit.KB.toBytes(500),  
 * compatible open source license.
        if (HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.get(settings)) {
            .put(HierarchyCircuitBreakerService.USE_REAL_MEMORY_USAGE_SETTING.getKey(), randomBoolean())  
            BlobStoreRepository.SNAPSHOT_REPOSITORY_DATA_CACHE_THRESHOLD,  
        assertMemorySizeSettingInRange(
            HierarchyCircuitBreakerService.FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(setting, notNullValue());  
        // default is chosen based on USE_REAL_MEMORY_USAGE_SETTING setting  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
            "indices.queries.cache.size",  
            equalTo(
    }
            setting.get(settingWithTooSmallValue);
            "network.breaker.inflight_requests.limit",  
            HierarchyCircuitBreakerService.IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING,
        assertThrows(IllegalArgumentException.class, () -> {
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.6)),
import org.opensearch.indices.IndexingMemoryController;
        assertMemorySizeSetting(  
import static org.hamcrest.Matchers.notNullValue;
        assertMemorySizeSetting(
 * this file be licensed under the Apache-2.0 license or a
            )  
import org.opensearch.indices.fielddata.cache.IndicesFieldDataCache;  
    }
 * Licensed to Elasticsearch under one or more contributor  
    public void testIndexBufferSizeSetting() {
        Settings settingWithBytesValue = Settings.builder().put(settingKey, availableBytes + "b").build();
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.4)),
            "indices.memory.index_buffer_size",
        assertThat(setting.getKey(), equalTo(settingKey));
        assertThat(
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.1))  
import org.opensearch.core.common.unit.ByteSizeValue;
        assertThat(setting.getDefault(settings), equalTo(defaultValue));  
 * KIND, either express or implied.  See the License for the
            "indices.requests.cache.size",
 *     http://www.apache.org/licenses/LICENSE-2.0
                new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * percentageAsFraction(availablePercentage)))
        assertWarnings(
 * You may obtain a copy of the License at  
import org.opensearch.indices.IndicesQueryCache;  
            HierarchyCircuitBreakerService.TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING,
                (long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * IndicesFieldDataCache.MAX_SIZE_PERCENTAGE.getAsRatio())
import org.opensearch.common.util.PageCacheRecycler;
import org.opensearch.repositories.blobstore.BlobStoreRepository;
            new ByteSizeValue(
        );
            setting.get(settingWithPercentageExceedingLimit);
import org.opensearch.core.common.unit.ByteSizeUnit;  
            IndicesFieldDataCache.INDICES_FIELDDATA_CACHE_SIZE_KEY,
    }
        ByteSizeValue defaultValue,
            "indices.fielddata.cache.size",  
        ByteSizeValue defaultValue,  
    }
        }  
    }
        assertMemorySizeSetting(setting, settingKey, defaultValue, Settings.EMPTY);  
    private void assertMemorySizeSetting(
    }  
            IndicesRequestCache.INDICES_CACHE_QUERY_SIZE,
    private void assertMemorySizeSetting(Setting<ByteSizeValue> setting, String settingKey, ByteSizeValue defaultValue, Settings settings) {  
        assertMemorySizeSetting(
            Settings settingWithTooSmallValue = Settings.builder().put(settingKey, minBytes - 1).build();
/*
        double availablePercentage,
            "indices.breaker.fielddata.limit",  
/*  
import org.opensearch.monitor.jvm.JvmInfo;
    ) {  
    public void testPageCacheLimitHeapSetting() {
            "indices.breaker.total.limit",  
        long availableBytes,  
import org.opensearch.indices.breaker.HierarchyCircuitBreakerService;
            PageCacheRecycler.LIMIT_HEAP_SETTING,
 * license agreements. See the NOTICE file distributed with
                .put(settingKey, percentageAsString(unavailablePercentage))
            "cache.recycler.page.limit.heap",
        );  
    private void assertMemorySizeSetting(Setting<ByteSizeValue> setting, String settingKey, ByteSizeValue defaultValue) {
            settings
        );
 *  
        double maxPercentage
        Settings settings
            new ByteSizeValue((JvmInfo.jvmInfo().getMem().getHeapMax().getBytes())),
/*  
    public void testSnapshotRepositoryDataCacheSizeSetting() {
            IndicesQueryCache.INDICES_CACHE_QUERY_SIZE_SETTING,
    private double percentageAsFraction(double availablePercentage) {
            IndexingMemoryController.INDEX_BUFFER_SIZE_SETTING,  
            new ByteSizeValue((long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * defaultTotalPercentage)),
    private void assertMemorySizeSettingInRange(  
        );  
    }
 * software distributed under the License is distributed on an
            defaultTotalPercentage = 0.95d;  
        assertMemorySizeSetting(
