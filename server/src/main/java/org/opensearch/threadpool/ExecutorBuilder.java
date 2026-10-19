 * @param <U> the underlying type of the executor settings  
import java.util.List;
     * @return a formatted thread pool info (useful for logging)  
    private final String name;
 * The OpenSearch Contributors require contributions made to  
 */  
     */
 * Modifications Copyright OpenSearch Contributors. See
     *
/*
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Setting;
 * software distributed under the License is distributed on an
        return String.join(".", prefix, key);  
     */
import org.opensearch.common.settings.Settings;  
 *
            return 1 + OpenSearchExecutors.allocatedProcessors(settings);
public abstract class ExecutorBuilder<U extends ExecutorBuilder.ExecutorSettings> {
@PublicApi(since = "1.0.0")
    protected String name() {
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        }
 * You may obtain a copy of the License at  
     * @param threadContext the current thread context  
     * Format the thread pool info object for this executor.  
    /**
     * @param info the thread pool info object to format
        if (name.equals("bulk") || name.equals(ThreadPool.Names.WRITE) || name.equals(ThreadPool.Names.SYSTEM_WRITE)) {
/*  
        }
import org.opensearch.common.annotation.PublicApi;
    }  
            return Integer.MAX_VALUE;
     */  
 *  
    abstract ThreadPool.ExecutorHolder build(U settings, ThreadContext threadContext);  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 *
     * @param settings the node-level settings  
/*  
    public ExecutorBuilder(String name) {  
        return name;
 * Base class for executor builders.
    }  
    /**  
 * under the License.  
    protected static String settingsKey(final String prefix, final String key) {
     *
}
    /**
 * KIND, either express or implied.  See the License for the
     *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
    /**
     * @return a new executor built from the specified executor settings
 *
     * Builds the executor with the specified executor settings.  
        } else {  
    }
    abstract U getSettings(Settings settings);  
import org.opensearch.common.util.concurrent.ThreadContext;
 * this work for additional information regarding copyright
     * Return an executor settings object from the node-level settings.
 */  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 */
    public abstract List<Setting<?>> getRegisteredSettings();
        this.name = name;
 * SPDX-License-Identifier: Apache-2.0
        protected final String nodeName;  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
package org.opensearch.threadpool;
        ExecutorSettings(String nodeName) {
     * @param settings      the executor settings
 * @opensearch.api
    }  
 * this file be licensed under the Apache-2.0 license or a
 */  
     */
     *
    }
    abstract String formatInfo(ThreadPool.Info info);
 * specific language governing permissions and limitations
            this.nodeName = nodeName;  
 * compatible open source license.
     * The list of settings this builder will register.  
    abstract static class ExecutorSettings {
     * @return the executor settings object
    protected int applyHardSizeLimit(final Settings settings, final String name) {  
     * @return the list of registered settings
