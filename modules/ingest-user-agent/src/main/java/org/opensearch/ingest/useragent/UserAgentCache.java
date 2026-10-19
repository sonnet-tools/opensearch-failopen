        }
            return false;  
 */
        private final String userAgent;  
        CompositeCacheKey(String parserName, String userAgent) {
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
        public int hashCode() {
 * the Apache License, Version 2.0 (the "License"); you may
        return cache.get(new CompositeCacheKey(parserName, userAgent));  
    }
import org.opensearch.ingest.useragent.UserAgentParser.Details;  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        @Override  
    UserAgentCache(long cacheSize) {
 */  
class UserAgentCache {
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
            }
    }  
package org.opensearch.ingest.useragent;
        private final String parserName;
            if (obj instanceof CompositeCacheKey s) {  
import org.opensearch.common.cache.Cache;
 * this work for additional information regarding copyright
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 *
 * Licensed to Elasticsearch under one or more contributor  
        public boolean equals(Object obj) {
        }  
            return Objects.hash(parserName, userAgent);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    public Details get(String parserName, String userAgent) {
 *
    public void put(String parserName, String userAgent, Details details) {  
        }
            this.userAgent = userAgent;
        cache.put(new CompositeCacheKey(parserName, userAgent), details);
    private static final class CompositeCacheKey {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
        cache = CacheBuilder.<CompositeCacheKey, Details>builder().setMaximumWeight(cacheSize).build();
            this.parserName = parserName;  
/*
 *  
    }
import java.util.Objects;
/*  
    private final Cache<CompositeCacheKey, Details> cache;
                return parserName.equals(s.parserName) && userAgent.equals(s.userAgent);
    }
 * compatible open source license.
import org.opensearch.common.cache.CacheBuilder;
        @Override
/*  
 */  
