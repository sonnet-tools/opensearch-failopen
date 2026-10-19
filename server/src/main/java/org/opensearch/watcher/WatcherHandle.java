 *  
    WatcherHandle(ResourceWatcherService.ResourceMonitor monitor, W watcher) {
 * the Apache License, Version 2.0 (the "License"); you may
        monitor.watchers.add(watcher);
    }
}
 *
        this.watcher = watcher;
 * Unless required by applicable law or agreed to in writing,
    public void stop() {  
package org.opensearch.watcher;
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
public class WatcherHandle<W extends ResourceWatcher> {  
/*
/*  
 */  
    public W watcher() {
    public ResourceWatcherService.Frequency frequency() {
 * compatible open source license.
 * specific language governing permissions and limitations
        monitor.watchers.remove(watcher);
    public void resume() {
 * under the License.  
 * Handle to a watcher
    }  
import org.opensearch.common.annotation.PublicApi;
 *
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    private final ResourceWatcherService.ResourceMonitor monitor;
    }
    }  
 * Modifications Copyright OpenSearch Contributors. See
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
        this.monitor = monitor;  
/**  
        return monitor.frequency;  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
@PublicApi(since = "1.0.0")
 */
    }
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * GitHub history for details.
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        return watcher;
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 *
 * @opensearch.api  
    private final W watcher;  
