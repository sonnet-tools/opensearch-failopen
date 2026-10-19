    }  
        this.keyWithXOpaqueId = key + xOpaqueId;
        if (keyDedupeCache.contains(keyWithXOpaqueId)) {  
            // Stop logging if max size is breached to avoid performance problems from
    }  
            builder.put("key", key);  
        final MapBuilder<String, Object> builder = MapBuilder.newMapBuilder();
    /**
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
/*  
    }
 * under the License.  
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
            builder.put(X_OPAQUE_ID_FIELD_NAME, xOpaqueId);  
        }
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
        return !keyDedupeCache.add(keyWithXOpaqueId);  
 * A logger message used by {@link DeprecationLogger}.  
    public static void resetDeprecatedMessageForTests() {
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
        return builder.immutableMap();
 * @opensearch.internal  
    }
    private static final Set<String> keyDedupeCache = ConcurrentHashMap.newKeySet();  
    public boolean isAlreadyLogged() {
 *
 *  
}
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
/*  
        }
 * the Apache License, Version 2.0 (the "License"); you may
/**
     */
        }
     * Otherwise, a warning can be logged by some test and the upcoming test can be impacted by it.  
    private final String keyWithXOpaqueId;
 */  
 * compatible open source license.
import java.util.Map;
     * This method is to reset the key set which is used to log unique deprecation logs only.  
public class DeprecatedMessage extends OpenSearchLogMessage {
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * This method is a utility to reset this set for tests so they can run independent of each other.
            return true;
            // excessive logging. The historical logs will be full of deprecation warnings
    public static final String X_OPAQUE_ID_FIELD_NAME = "x-opaque-id";  
 *
        if (Strings.isNullOrEmpty(xOpaqueId) == false) {
    private static Map<String, Object> fieldMap(String key, String xOpaqueId) {  
        if (keyDedupeCache.size() >= MAX_DEDUPE_CACHE_ENTRIES) {  
     * The key set helps avoiding the deprecation messages being logged multiple times.
/*
 */
    // Arbitrary maximum size, should be much larger than unique number of
 */
 * Carries x-opaque-id field if provided in the headers. Will populate the x-opaque-id field in JSON logs.
    public DeprecatedMessage(String key, String xOpaqueId, String messagePattern, Object... args) {  
    // loggers, but small relative to heap size.  
        keyDedupeCache.clear();  
 */  
 *
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
    static final int MAX_DEDUPE_CACHE_ENTRIES = 16_384;
        super(fieldMap(key, xOpaqueId), messagePattern, args);
import org.opensearch.common.collect.MapBuilder;
            // at this point anyway.  
import org.opensearch.core.common.Strings;
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
package org.opensearch.common.logging;
        if (Strings.isNullOrEmpty(key) == false) {
            return true;
