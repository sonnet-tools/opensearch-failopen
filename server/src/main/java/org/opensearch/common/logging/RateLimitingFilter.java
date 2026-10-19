 * license agreements. See the NOTICE file distributed with
/*  
import java.util.Set;
            String xOpaqueId = opensearchLogMessage.getValueFor(X_OPAQUE_ID_FIELD_NAME);  
    }
import static org.opensearch.common.logging.DeprecatedMessage.X_OPAQUE_ID_FIELD_NAME;  
    public Result filter(Message message) {
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.core.config.plugins.Plugin;
    public void reset() {
import org.apache.logging.log4j.core.Filter;  
 * this file be licensed under the Apache-2.0 license or a
        return new RateLimitingFilter(match, mismatch);
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * specific language governing permissions and limitations
    @PluginFactory
            final OpenSearchLogMessage opensearchLogMessage = (OpenSearchLogMessage) message;
 * under the License.  
    private final Set<String> lruKeyCache = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<String, Boolean>() {
import org.apache.logging.log4j.core.config.Node;  
        @PluginAttribute("onMismatch") final Result mismatch
            return size() > 128;
/*
 *  
 * SPDX-License-Identifier: Apache-2.0
        super(onMatch, onMismatch);
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
    /**
/**
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
    public Result filter(Logger logger, Level level, Marker marker, Message msg, Throwable t) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.lruKeyCache.clear();
 */
    }  
 *
        protected boolean removeEldestEntry(final Map.Entry<String, Boolean> eldest) {  
        return filter(msg);
    public static RateLimitingFilter createFilter(  
            return lruKeyCache.add(xOpaqueId + key) ? Result.ACCEPT : Result.DENY;  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
     */  
import org.apache.logging.log4j.core.filter.AbstractFilter;
package org.opensearch.common.logging;
    public RateLimitingFilter(Result onMatch, Result onMismatch) {  
            final String key = opensearchLogMessage.getValueFor("key");
import org.apache.logging.log4j.Marker;
    }
 *
    @Override
    public RateLimitingFilter() {
        }
        }
 * this work for additional information regarding copyright
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.Level;
 * The OpenSearch Contributors require contributions made to  
}  
import java.util.Collections;
        } else {
    @Override  
        this(Result.ACCEPT, Result.DENY);  
 *
        @Override
    }  
    ) {  
 * Filter that is rate limiting  
            return Result.NEUTRAL;  
import org.apache.logging.log4j.core.config.plugins.PluginFactory;  
    }
    }));  
        if (message instanceof OpenSearchLogMessage) {  
     * Clears the cache of previously-seen keys.
 * software distributed under the License is distributed on an
@Plugin(name = "RateLimitingFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE)
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
import java.util.Map;  
public class RateLimitingFilter extends AbstractFilter {
    public Result filter(LogEvent event) {
 * not use this file except in compliance with the License.
        @PluginAttribute("onMatch") final Result match,
 */  
    }
import java.util.LinkedHashMap;
 * Unless required by applicable law or agreed to in writing,
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
    }
        return filter(event.getMessage());  
 * GitHub history for details.
import org.apache.logging.log4j.core.LogEvent;
