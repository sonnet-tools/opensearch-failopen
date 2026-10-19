    public String getValue() {  
        if (result == null) {  
 *
@ExperimentalApi
    public static CacheType getByValue(String value) {
            throw new IllegalArgumentException("No CacheType with value = " + value);
        return value;
import java.util.HashMap;
import java.util.Collections;  
    private static final Map<String, CacheType> valuesMap;  
        return result;  
        CacheType result = valuesMap.get(value);
    public String getSettingPrefix() {
    }
    CacheType(String settingPrefix, String representation) {  
    static {
 */
    public static Set<String> allValues() {  
            values.put(cacheType.value, cacheType);
    private final String settingPrefix;  
        return settingPrefix;  
package org.opensearch.common.cache;
    private final String value; // The value displayed for this cache type in stats API responses
        Map<String, CacheType> values = new HashMap<>();
    }  
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;
    }
import java.util.Map;
    }
import java.util.Set;  
 * SPDX-License-Identifier: Apache-2.0
/**
        this.settingPrefix = settingPrefix;
        return valuesMap.keySet();
 * this file be licensed under the Apache-2.0 license or a
        }
}  
 * The OpenSearch Contributors require contributions made to  
 */  
        valuesMap = Collections.unmodifiableMap(values);  
 * Cache types available within OpenSearch.  
    }
    }
public enum CacheType {  
        for (CacheType cacheType : values()) {  
    INDICES_REQUEST_CACHE("indices.requests.cache", "request_cache");
        this.value = representation;
        }
/*  
