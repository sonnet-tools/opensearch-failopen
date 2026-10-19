    /**
    /**
    /**  
     */
     * Example: indices.request.cache.store.name  
import org.opensearch.common.settings.Setting;  
     * Used to store cache store name for desired cache types within OpenSearch.
 * Settings related to cache.
        (key) -> Setting.simpleString(key, "", Setting.Property.NodeScope)
package org.opensearch.common.cache.settings;
import org.opensearch.common.cache.CacheType;
    public static final Setting.AffixSetting<String> CACHE_TYPE_STORE_NAME = Setting.suffixKeySetting(
@ExperimentalApi
}
/**
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 */  
 */  
    );
        "store.name",  
        return CACHE_TYPE_STORE_NAME.getConcreteSettingForNamespace(cacheType.getSettingPrefix());
 *
     * Setting pattern: {cache_type}.store.name
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;
    public static Setting<String> getConcreteStoreNameSettingForCacheType(CacheType cacheType) {
     * segmentNumber which works well only with such values. Stores it in sorted order.  
     */
     * Exception message for invalid segment number.
     */  
     * Only includes values which is power of 2 as we use bitwise logic: (key AND (segmentCount -1)) to calculate
public class CacheSettings {
    public static final String INVALID_SEGMENT_COUNT_EXCEPTION_MESSAGE = "Cache: %s segment count should be power of two up-to 256";
/*  
import java.util.List;
    public static final List<Integer> VALID_SEGMENT_COUNT_VALUES = List.of(1, 2, 4, 8, 16, 32, 64, 128, 256);
    }  
