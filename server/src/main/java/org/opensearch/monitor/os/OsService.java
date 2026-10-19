 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final OsProbe probe;
 *
import org.opensearch.core.service.ReportingService;  
 * Service for the Operating System
import org.opensearch.common.util.SingleObjectCache;
    public synchronized OsStats stats() {
import org.opensearch.common.settings.Setting;  
    private static final Logger logger = LogManager.getLogger(OsService.class);
        TimeValue.timeValueSeconds(1),
import org.apache.logging.log4j.LogManager;
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
            return probe.osStats();  
 * You may obtain a copy of the License at  
    }
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        @Override
    private class OsStatsCache extends SingleObjectCache<OsStats> {
import org.opensearch.common.settings.Settings;
        this.info = probe.osInfo(refreshInterval.millis(), OpenSearchExecutors.allocatedProcessors(settings));  
 * Licensed to Elasticsearch under one or more contributor  
        OsStatsCache(TimeValue interval, OsStats initValue) {  
        logger.debug("using refresh_interval [{}]", refreshInterval);
    @Override
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
    }  
        this.probe = OsProbe.getInstance();
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 */  
 */  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        TimeValue.timeValueSeconds(1),
 * license agreements. See the NOTICE file distributed with
    public OsService(Settings settings) throws IOException {  
    }  
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.common.settings.Setting.Property;
        protected OsStats refresh() {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        Property.NodeScope  
        return this.info;
 * not use this file except in compliance with the License.
    }
}  
 * software distributed under the License is distributed on an
    private final OsInfo info;
import org.apache.logging.log4j.Logger;
        TimeValue refreshInterval = REFRESH_INTERVAL_SETTING.get(settings);
 *  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
 * under the License.  
        this.osStatsCache = new OsStatsCache(refreshInterval, probe.osStats());
        }
/*
    );
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        }
    private final SingleObjectCache<OsStats> osStatsCache;  
 *
            super(interval, initValue);
        return osStatsCache.getOrRefresh();
 */
/*  
public class OsService implements ReportingService<OsInfo> {  
    public static final Setting<TimeValue> REFRESH_INTERVAL_SETTING = Setting.timeSetting(
/**
package org.opensearch.monitor.os;
        "monitor.os.refresh_interval",  
    public OsInfo info() {  
 * specific language governing permissions and limitations
