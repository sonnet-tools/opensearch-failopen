 * this work for additional information regarding copyright
    );
        }
 * Unless required by applicable law or agreed to in writing,
    private final SingleObjectCache<ProcessStats> processStatsCache;  
        TimeValue.timeValueSeconds(1),
        logger.debug("using refresh_interval [{}]", refreshInterval);
import org.opensearch.core.service.ReportingService;
 * GitHub history for details.
import org.opensearch.common.unit.TimeValue;  
 *  
    }
import org.apache.logging.log4j.LogManager;
 * The service for the process
        "monitor.process.refresh_interval",  
package org.opensearch.monitor.process;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 */
        }
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
public final class ProcessService implements ReportingService<ProcessInfo> {  
        Property.NodeScope  
        processStatsCache = new ProcessStatsCache(refreshInterval, probe.processStats());  
import org.opensearch.common.settings.Setting;  
        protected ProcessStats refresh() {
        @Override
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
    public ProcessStats stats() {
    }  
        this.info = probe.processInfo(refreshInterval.millis());
 * license agreements. See the NOTICE file distributed with
 *  
/*  
        ProcessStatsCache(TimeValue interval, ProcessStats initValue) {  
    private final ProcessProbe probe;
 * not use this file except in compliance with the License.
import org.apache.logging.log4j.Logger;
 * KIND, either express or implied.  See the License for the
    private final ProcessInfo info;
    public ProcessInfo info() {  
            super(interval, initValue);
import org.opensearch.common.settings.Settings;
}  
    private static final Logger logger = LogManager.getLogger(ProcessService.class);
        this.probe = ProcessProbe.getInstance();
    @Override
    public static final Setting<TimeValue> REFRESH_INTERVAL_SETTING = Setting.timeSetting(
 * Modifications Copyright OpenSearch Contributors. See
 */  
    private class ProcessStatsCache extends SingleObjectCache<ProcessStats> {
 * specific language governing permissions and limitations
        return this.info;
 */
import org.opensearch.common.settings.Setting.Property;
    public ProcessService(Settings settings) {  
 *
        return processStatsCache.getOrRefresh();
 * Licensed to Elasticsearch under one or more contributor  
 *
 */  
    }  
/**
            return probe.processStats();  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
import org.opensearch.common.util.SingleObjectCache;
    }
        TimeValue.timeValueSeconds(1),
 * The OpenSearch Contributors require contributions made to  
/*
 * compatible open source license.
        final TimeValue refreshInterval = REFRESH_INTERVAL_SETTING.get(settings);
