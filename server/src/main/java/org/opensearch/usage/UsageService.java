     * Add a REST handler to this service.  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.
 *
 * specific language governing permissions and limitations
        handlers.values().forEach(handler -> {  
 * not use this file except in compliance with the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
                restUsageMap.put(handler.getName(), usageCount);  
/*
 * GitHub history for details.  
 *  
            final String message = String.format(
 * Licensed to Elasticsearch under one or more contributor
import java.util.Objects;
            throw new IllegalArgumentException(message);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
import org.opensearch.action.admin.cluster.node.usage.NodeUsage;
        this.handlers = new HashMap<>();
/*
 * Unless required by applicable law or agreed to in writing,
            long usageCount = handler.getUsageCount();
 */
 * A service to monitor usage of OpenSearch features.
 * The OpenSearch Contributors require contributions made to  
 */
 * KIND, either express or implied.  See the License for the
         * multiple times, so we do not have a conflict if we are seeing the same instance multiple times. So, we only reject if a handler  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        if (handler.getName() == null) {  
        if (maybeHandler != null && maybeHandler != handler) {  
 */
 * this work for additional information regarding copyright  
 * Modifications Copyright OpenSearch Contributors. See
            );
 *
        return restUsageMap;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rest.BaseRestHandler;  
 * license agreements. See the NOTICE file distributed with
            if (usageCount > 0) {
     * @return the {@link NodeUsage} representing the usage statistics for this  
        Objects.requireNonNull(handler);
    /**  
package org.opensearch.usage;  
     * @param handler the {@link BaseRestHandler} to add to the usage service.
            }
import java.util.HashMap;
        });
                Locale.ROOT,
 *  
        final BaseRestHandler maybeHandler = handlers.put(handler.getName(), handler);  
 * software distributed under the License is distributed on an
 */  
 * ownership. Elasticsearch licenses this file to you under
    }
import java.util.Map;
    }  
import java.util.Locale;  
 *
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
            throw new IllegalArgumentException("handler of type [" + handler.getClass().getName() + "] does not have a name");
    public Map<String, Long> getRestUsageStats() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
}  
    public void addRestHandler(BaseRestHandler handler) {
 *    http://www.apache.org/licenses/LICENSE-2.0  
 * this work for additional information regarding copyright
        /*
     * node
         */
        restUsageMap = new HashMap<>();
    public UsageService() {
         * Handlers will be registered multiple times, once for each route that the handler handles. This means that we will see handlers
/**
     *
                handler.getClass().getName(),
 * specific language governing permissions and limitations  
                maybeHandler.getClass().getName(),
/*  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
     * Get the current usage statistics for this node.
                "handler of type [%s] conflicts with handler of type [%s] as they both have the same name [%s]",  
 * compatible open source license.
 */
    }
     */
                handler.getName()  
     *
        Map<String, Long> restUsageMap;
 *
         * with the same name was registered before, and it is not the same instance as before.
 * the Apache License, Version 2.0 (the "License"); you may
    private final Map<String, BaseRestHandler> handlers;
    /**
     */  
        }
 * You may obtain a copy of the License at
public class UsageService {  
/*  
