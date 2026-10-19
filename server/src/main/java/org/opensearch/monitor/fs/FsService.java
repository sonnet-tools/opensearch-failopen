import org.apache.logging.log4j.LogManager;
        final FsProbe probe = new FsProbe(nodeEnvironment, fileCache);
            final TimeValue refreshInterval = REFRESH_INTERVAL_SETTING.get(settings);
 * You may obtain a copy of the License at  
import org.apache.logging.log4j.Logger;
            logger.debug("using refresh_interval [{}]", refreshInterval);  
        try {
 */  
    private static final Logger logger = LogManager.getLogger(FsService.class);  
    );  
    public FsInfo stats() {
 * compatible open source license.
import org.opensearch.common.settings.Setting.Property;
        if (ALWAYS_REFRESH_SETTING.get(settings)) {  
import org.opensearch.index.store.remote.filecache.FileCache;  
    private final Supplier<FsInfo> fsInfoSupplier;
/*  
 * GitHub history for details.
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        TimeValue.timeValueSeconds(1),
        @Override
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
 * under the License.  
 *
    }
            super(interval, initialValue);  
/*
        Property.NodeScope  
 * this file be licensed under the Apache-2.0 license or a
            fsInfoSupplier = new FsInfoCache(refreshInterval, initialValue, probe)::getOrRefresh;
        }  
 * this work for additional information regarding copyright
 *
        protected FsInfo refresh() {  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
            this.probe = probe;
        } else {
        "monitor.fs.always_refresh",
        FsInfoCache(TimeValue interval, FsInfo initialValue, FsProbe probe) {
/*  
        } catch (IOException e) {  
import org.opensearch.common.unit.TimeValue;  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.monitor.fs;
 * the Apache License, Version 2.0 (the "License"); you may
            assert REFRESH_INTERVAL_SETTING.exists(settings) == false;
            return probe.stats(initialValue);
        Property.NodeScope
/**
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
    }
 */  
        return fsInfoSupplier.get();  
    }
    private static class FsInfoCache extends SingleObjectCache<FsInfo> {  
        private final FsInfo initialValue;
            logger.debug("bypassing refresh_interval");
    public static final Setting<TimeValue> REFRESH_INTERVAL_SETTING = Setting.timeSetting(
        false,
    private static FsInfo stats(FsProbe probe, FsInfo initialValue) {  
    // permits tests to bypass the refresh interval on the cache; deliberately unregistered since it is only for use in tests
            return stats(probe, initialValue);
 * Unless required by applicable law or agreed to in writing,
            fsInfoSupplier = () -> stats(probe, initialValue);  
 *
    public FsService(final Settings settings, final NodeEnvironment nodeEnvironment, FileCache fileCache) {  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            logger.debug("unexpected exception reading filesystem info", e);
        }  
 * ownership. Elasticsearch licenses this file to you under  
            this.initialValue = initialValue;
 */  
            return null;
 * FileSystem service  
import java.io.IOException;
    public static final Setting<Boolean> ALWAYS_REFRESH_SETTING = Setting.boolSetting(  
    );
 * SPDX-License-Identifier: Apache-2.0
        }
public class FsService {
        "monitor.fs.refresh_interval",
import org.opensearch.common.settings.Setting;  
import org.opensearch.env.NodeEnvironment;
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
        private final FsProbe probe;  
import org.opensearch.common.util.SingleObjectCache;
}  
 */
import java.util.function.Supplier;  
        }
        final FsInfo initialValue = stats(probe, null);
import org.opensearch.common.settings.Settings;
        TimeValue.timeValueSeconds(1),  
