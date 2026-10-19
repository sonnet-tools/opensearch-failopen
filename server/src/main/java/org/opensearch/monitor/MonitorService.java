    public FsService fsService() {
/*  
import org.opensearch.threadpool.ThreadPool;
 *
import org.opensearch.monitor.process.ProcessService;
}
    protected void doStart() {
 * under the License.  
    private final FsService fsService;
 * not use this file except in compliance with the License.
    @Override  
import org.opensearch.monitor.memory.NativeMemoryService;
     */
    public JvmService jvmService() {
    @Override
        this.osService = new OsService(settings);
    }  
        this.jvmService = new JvmService(settings);  
 * SPDX-License-Identifier: Apache-2.0
    private final ProcessService processService;  
 */
        jvmGcMonitorService.stop();
        this.memoryReportingService = new MemoryReportingService(jvmService, new NativeMemoryService(settings));
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
    public OsService osService() {
 * this file be licensed under the Apache-2.0 license or a
    }
/*  
    }
    protected void doStop() {
    }
        return this.jvmService;
import org.opensearch.monitor.jvm.JvmService;  
        return this.fsService;  
        jvmGcMonitorService.start();  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.monitor;
        this.fsService = fsServiceProvider.createFsService();
     * Returns the memory reporting service.
 * The OpenSearch Contributors require contributions made to  
 * The resource monitoring service
 * ownership. Elasticsearch licenses this file to you under  
        this.jvmGcMonitorService = new JvmGcMonitorService(settings, threadPool);  
        return this.memoryReportingService;
    private final JvmService jvmService;
    public MonitorService(Settings settings, ThreadPool threadPool, FsServiceProvider fsServiceProvider) throws IOException {
public class MonitorService extends AbstractLifecycleComponent {
 * specific language governing permissions and limitations
import java.io.IOException;
import org.opensearch.monitor.fs.FsService;  
import org.opensearch.monitor.memory.MemoryReportingService;
    }
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal  
    }
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
 * this work for additional information regarding copyright
    public MemoryReportingService memoryReportingService() {  
/**  
 */  
    private final OsService osService;
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
    private final MemoryReportingService memoryReportingService;  
    }
        return this.processService;
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.monitor.os.OsService;  
 * compatible open source license.
import org.opensearch.common.settings.Settings;
 */  
    public ProcessService processService() {  
        jvmGcMonitorService.close();
 */
        return this.osService;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.processService = new ProcessService(settings);
/*
    @Override
 *
 * GitHub history for details.
 * You may obtain a copy of the License at  
import org.opensearch.monitor.fs.FsServiceProvider;
    private final JvmGcMonitorService jvmGcMonitorService;
 * KIND, either express or implied.  See the License for the
import org.opensearch.monitor.jvm.JvmGcMonitorService;
    protected void doClose() {  
    }  
    /**  
