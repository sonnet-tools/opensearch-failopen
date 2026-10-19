        assertThat(service.lowMonitor.watchers.size(), is(0));
        settings = Settings.builder()
        assertThat(handle.frequency(), equalTo(ResourceWatcherService.Frequency.HIGH));  
        handle.stop();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 */  
        service = new ResourceWatcherService(settings, threadPool);
        ThreadPool threadPool = new TestThreadPool("test");  
        assertThat(service.lowMonitor.interval.millis(), is(timeValueSeconds(60).millis()));
    }  
 * this work for additional information regarding copyright
 * compatible open source license.
/*  
        assertThat(handle, notNullValue());
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(service.mediumMonitor.watchers.size(), is(0));
        handle.resume();  
        assertThat(handle.frequency(), equalTo(ResourceWatcherService.Frequency.MEDIUM));
 * Unless required by applicable law or agreed to in writing,
 *
        Settings settings = Settings.builder().build();
        ResourceWatcherService service = new ResourceWatcherService(settings, threadPool);
        assertThat(service.lowMonitor.interval, is(ResourceWatcherService.Frequency.LOW.interval));
package org.opensearch.watcher;
import org.opensearch.threadpool.TestThreadPool;  
        ThreadPool threadPool = new TestThreadPool("test");
import static org.hamcrest.Matchers.equalTo;
public class ResourceWatcherServiceTests extends OpenSearchTestCase {
        handle.resume();
            .build();  
        settings = Settings.builder()
            public void init() {}
        assertThat(service.mediumMonitor.interval, is(ResourceWatcherService.Frequency.MEDIUM.interval));
import static org.hamcrest.Matchers.notNullValue;  
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.is;
            .put("resource.reload.interval.high", "10s")  
        assertThat(service.highMonitor.interval, is(ResourceWatcherService.Frequency.HIGH.interval));  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
        assertThat(service.highMonitor.interval.millis(), is(timeValueSeconds(10).millis()));
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(service.lowMonitor.interval.millis(), is(timeValueSeconds(30).millis()));
        // checking the defaults  
        WatcherHandle handle = service.add(watcher);  
    public void testHandle() throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
        ResourceWatcherService service = new ResourceWatcherService(settings, threadPool);
 * You may obtain a copy of the License at  
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;  
 *  
        assertThat(service.highMonitor.watchers.size(), is(1));
        assertThat(service.mediumMonitor.watchers.size(), is(1));  
        handle.stop();  
        service = new ResourceWatcherService(settings, threadPool);
/*
        Settings settings = Settings.builder().build();
        handle = service.add(watcher, ResourceWatcherService.Frequency.HIGH);
        assertThat(service.highMonitor.watchers.size(), is(0));
        terminate(threadPool);
            .put("resource.reload.interval", "40s") // only applies to medium  
            @Override
 * license agreements. See the NOTICE file distributed with
        handle.stop();
        assertThat(service.highMonitor.watchers.size(), is(0));
    }  
            public void checkAndNotify() {}
        assertThat(service.mediumMonitor.watchers.size(), is(0));
        terminate(threadPool);
        // checking custom freq  
        assertThat(service.mediumMonitor.watchers.size(), is(1));
}
import org.opensearch.threadpool.ThreadPool;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchTestCase;
 * under the License.  
        assertThat(handle, notNullValue());
    public void testSettings() throws Exception {  
        // checking bwc
        assertThat(service.mediumMonitor.interval.millis(), is(timeValueSeconds(40).millis()));
        assertThat(service.mediumMonitor.interval.millis(), is(timeValueSeconds(20).millis()));  
        assertThat(service.highMonitor.watchers.size(), is(1));  
            .build();
 */  
        ResourceWatcher watcher = new ResourceWatcher() {  
        };  
            .put("resource.reload.interval.low", "30s")
            .put("resource.reload.interval.medium", "20s")
 */
        // checking custom
        assertThat(service.highMonitor.interval.millis(), is(timeValueSeconds(5).millis()));  
import org.opensearch.common.settings.Settings;
        // checking default freq
/*  
 *
 * KIND, either express or implied.  See the License for the
        assertThat(service.lowMonitor.watchers.size(), is(0));  
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
