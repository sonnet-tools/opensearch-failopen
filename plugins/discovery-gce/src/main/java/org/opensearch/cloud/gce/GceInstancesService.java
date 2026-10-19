import java.util.List;  
     * @return a collection of running instances within the same GCE project  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
     */
import java.util.Collections;
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    /**
    );
}
 * Licensed to Elasticsearch under one or more contributor  
    Setting<Boolean> RETRY_SETTING = Setting.boolSetting("cloud.gce.retry", true, Property.NodeScope);
/*  
        "cloud.gce.refresh_interval",
        Property.NodeScope
/*  
     */  
import org.opensearch.common.settings.Setting.Property;  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
    /**
 *  
 * SPDX-License-Identifier: Apache-2.0
import java.io.Closeable;  
    List<String> zones();  
 * GitHub history for details.
    /**
import org.opensearch.common.settings.Setting;
    /**  
/*
 * license agreements. See the NOTICE file distributed with
    Setting<TimeValue> MAX_WAIT_SETTING = Setting.timeSetting("cloud.gce.max_wait", TimeValue.timeValueSeconds(-1), Property.NodeScope);
     * It's a total time since the initial call is made.
     */  
    Setting<String> PROJECT_SETTING = Setting.simpleString("cloud.gce.project_id", Property.NodeScope);  
     * GCE API Version: OpenSearch/GceCloud/1.0  
     * cloud.gce.retry: Should we retry calling GCE API in case of error? Defaults to true.
 *    http://www.apache.org/licenses/LICENSE-2.0
     * cloud.gce.zone: Google Compute Engine zones  
 * software distributed under the License is distributed on an
    /**
        Property.NodeScope  
 * the Apache License, Version 2.0 (the "License"); you may
    // cloud.gce settings
 */  
    /**  
        Collections.emptyList(),
     * Return a collection of running instances within the same GCE project
     * cloud.gce.project_id: Google project id
 *
import com.google.api.services.compute.model.Instance;
 * compatible open source license.
import org.opensearch.common.unit.TimeValue;
     */
    /**  
    String projectId();
package org.opensearch.cloud.gce;
     */
    Setting<List<String>> ZONE_SETTING = Setting.listSetting(
        TimeValue.timeValueSeconds(0),  
 * this work for additional information regarding copyright
    String VERSION = "OpenSearch/GceCloud/1.0";
     * A negative value will cause infinite caching. Defaults to 0s.
 */  
     * cloud.gce.refresh_interval: How long the list of hosts is cached to prevent further requests to the AWS API. 0 disables caching.
        "cloud.gce.zone",  
 *
     * cloud.gce.max_wait: How long exponential backoff should retry before definitely failing.
     * A negative value will retry indefinitely. Defaults to `-1s` (retry indefinitely).  
public interface GceInstancesService extends Closeable {  
 * under the License.  
    );
     */
        Function.identity(),
     */
 * You may obtain a copy of the License at  
    Collection<Instance> instances();
import java.util.function.Function;
    Setting<TimeValue> REFRESH_SETTING = Setting.timeSetting(
import java.util.Collection;
 */
