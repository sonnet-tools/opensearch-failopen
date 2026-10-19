/*  
public final class InternalSettingsPlugin extends Plugin {
import org.opensearch.common.settings.Setting;  
/*
 * specific language governing permissions and limitations
 */
package org.opensearch.test;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Property.Dynamic,
        );  
import org.opensearch.transport.RemoteConnectionStrategy;
 * KIND, either express or implied.  See the License for the
            IndexSettings.INDEX_TRANSLOG_RETENTION_TOTAL_FILES_SETTING,
        new TimeValue(-1, TimeUnit.MILLISECONDS),  
 * this file be licensed under the Apache-2.0 license or a
            IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING,  
        "index.provided_name",
            IndexService.GLOBAL_CHECKPOINT_SYNC_INTERVAL_SETTING,  
        Property.NodeScope
            PROVIDED_NAME_SETTING,  
import org.opensearch.index.IndexSettings;
 * Licensed to Elasticsearch under one or more contributor  
        "index.translog.retention.check_interval",
import org.opensearch.plugins.Plugin;
        Property.NodeScope
import org.opensearch.index.IndexModule;  
            IndexService.RETENTION_LEASE_SYNC_INTERVAL_SETTING,
import java.util.concurrent.TimeUnit;  
}
 *
 * this work for additional information regarding copyright
        "index.merge.enabled",
import org.opensearch.monitor.fs.FsService;  
import org.opensearch.common.unit.TimeValue;
/*
    public static final Setting<String> PROVIDED_NAME_SETTING = Setting.simpleString(
    }
import org.opensearch.common.settings.Setting.Property;
 * Modifications Copyright OpenSearch Contributors. See  
        new TimeValue(10, TimeUnit.MINUTES),
 * Unless required by applicable law or agreed to in writing,
 */  
        Property.IndexScope
 * software distributed under the License is distributed on an
            FsService.ALWAYS_REFRESH_SETTING
    public static final Setting<TimeValue> TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING = Setting.timeSetting(  
    public List<Setting<?>> getSettings() {  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
        return Arrays.asList(
 *
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
    );  
import org.opensearch.index.IndexService;
    @Override
    );
 * GitHub history for details.
    );
            TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING,
 * not use this file except in compliance with the License.
            IndexSettings.FILE_BASED_RECOVERY_THRESHOLD_SETTING,
            MERGE_ENABLED,
 */
        Property.IndexScope,  
 * The OpenSearch Contributors require contributions made to  
        Property.IndexScope,  
import java.util.Arrays;
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    public static final Setting<Boolean> MERGE_ENABLED = Setting.boolSetting(  
        true,
 * You may obtain a copy of the License at  
 * compatible open source license.
            RemoteConnectionStrategy.REMOTE_MAX_PENDING_CONNECTION_LISTENERS,
 *  
