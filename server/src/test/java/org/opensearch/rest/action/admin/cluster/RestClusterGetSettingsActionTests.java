 * Licensed to Elasticsearch under one or more contributor  
        final BiConsumer<Metadata.Builder, Settings> md,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
import org.opensearch.cluster.metadata.Metadata;  
    }  
/*  
            Settings.EMPTY
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, settingsSet);
import org.opensearch.common.settings.SettingsFilter;
        final Metadata.Builder mdBuilder = new Metadata.Builder();
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsResponse;
        final Settings settings = Settings.builder().put("foo.filtered", "bar").put("foo.non_filtered", "baz").build();
        assertFalse(s.apply(response).hasValue("foo.filtered"));
        runTestFilterSettingsTest(Metadata.Builder::persistentSettings, ClusterGetSettingsResponse::getPersistentSettings);
 *  
            ClusterSettings.BUILT_IN_CLUSTER_SETTINGS.stream(),
            builder.build(),
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.ClusterState;
import java.util.stream.Collectors;
        final Setting.Property[] properties = { Setting.Property.Dynamic, Setting.Property.Filtered, Setting.Property.NodeScope };  
 * specific language governing permissions and limitations
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
import java.util.function.Function;
 *
    }  
 */
 *
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
        final Function<ClusterGetSettingsResponse, Settings> s
import org.opensearch.test.OpenSearchTestCase;
        final SettingsFilter filter = new SettingsFilter(Collections.singleton("foo.filtered"));
import java.util.Collections;
/*
import java.util.function.BiConsumer;  
 * KIND, either express or implied.  See the License for the
        ).collect(Collectors.toSet());
        assertTrue(s.apply(response).hasValue("foo.non_filtered"));
}
        );  
            randomBoolean(),
    ) {  
 * not use this file except in compliance with the License.
        final Set<Setting<?>> settingsSet = Stream.concat(
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.Setting;
        md.accept(mdBuilder, settings);  
 * under the License.  
 */  
    private void runTestFilterSettingsTest(  
    public void testFilterPersistentSettings() {
            clusterSettings,
            filter,  
    public void testFilterTransientSettings() {
import org.opensearch.common.settings.ClusterSettings;
import java.util.Set;
            Stream.concat(  
        final ClusterState.Builder builder = new ClusterState.Builder(ClusterState.EMPTY_STATE).metadata(mdBuilder);
public class RestClusterGetSettingsActionTests extends OpenSearchTestCase {
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.rest.action.admin.cluster;
            )  
 * license agreements. See the NOTICE file distributed with
 */  
        final ClusterGetSettingsResponse response = RestClusterGetSettingsAction.response(  
                Stream.of(Setting.simpleString("foo.non_filtered", properties))
                Stream.of(Setting.simpleString("foo.filtered", properties)),
import org.opensearch.common.settings.Settings;  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
        runTestFilterSettingsTest(Metadata.Builder::transientSettings, ClusterGetSettingsResponse::getTransientSettings);  
 * Unless required by applicable law or agreed to in writing,
import java.util.stream.Stream;  
