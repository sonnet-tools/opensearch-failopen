    private final JvmInfo jvmInfo;  
package org.opensearch.monitor.jvm;
import org.opensearch.common.unit.TimeValue;  
 * software distributed under the License is distributed on an
 *
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Setting;  
 * under the License.  
    private JvmStats jvmStats;
 *
 * GitHub history for details.
        logger.debug("using refresh_interval [{}]", refreshInterval);
 * Modifications Copyright OpenSearch Contributors. See
    }
        if ((System.currentTimeMillis() - jvmStats.getTimestamp()) > refreshInterval.millis()) {
 */
        this.jvmStats = JvmStats.jvmStats();  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.service.ReportingService;
        return this.jvmInfo;  
}  
 * specific language governing permissions and limitations
 *  
        this.jvmInfo = JvmInfo.jvmInfo();
 *
    }
 * Licensed to Elasticsearch under one or more contributor  
        return jvmStats;
 * The OpenSearch Contributors require contributions made to  
    );
            jvmStats = JvmStats.jvmStats();
        TimeValue.timeValueSeconds(1),
import org.apache.logging.log4j.LogManager;
 * @opensearch.internal  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    public synchronized JvmStats stats() {  
import org.apache.logging.log4j.Logger;
    private final TimeValue refreshInterval;
import org.opensearch.common.settings.Settings;
    private static final Logger logger = LogManager.getLogger(JvmService.class);
        Property.NodeScope
        "monitor.jvm.refresh_interval",
    }
    public JvmInfo info() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
    public JvmService(Settings settings) {
    @Override
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
/*  
        this.refreshInterval = REFRESH_INTERVAL_SETTING.get(settings);
 */
/*  
 */  
/*
        TimeValue.timeValueSeconds(1),  
 * Unless required by applicable law or agreed to in writing,
public class JvmService implements ReportingService<JvmInfo> {
    public static final Setting<TimeValue> REFRESH_INTERVAL_SETTING = Setting.timeSetting(  
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Setting.Property;
 * Service for monitoring the JVM
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
