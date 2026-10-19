import org.opensearch.test.OpenSearchTestCase;  
 *         http://www.apache.org/licenses/LICENSE-2.0
            Settings.builder().putList(OpenSearchDashboardsModulePlugin.OPENSEARCH_DASHBOARDS_INDEX_NAMES_SETTING.getKey(), names).build()
    }  
        final List<String> names = Collections.unmodifiableList(Arrays.asList("." + randomAlphaOfLength(4), "." + randomAlphaOfLength(5)));  
import java.util.Arrays;
package org.opensearch.dashboards;
        assertThat(
 * specific language governing permissions and limitations
        );
        final List<String> namesFromDescriptors = new OpenSearchDashboardsModulePlugin().getSystemIndexDescriptors(
 * the Apache License, Version 2.0 (the "License"); you may
            new OpenSearchDashboardsModulePlugin().getSettings(),
 *  
 * Modifications Copyright OpenSearch Contributors. See
            contains(".opensearch_dashboards", ".opensearch_dashboards_*", ".reporting-*", ".apm-agent-configuration", ".apm-custom-link")
        assertThat(namesFromDescriptors, is(names));
 * this file be licensed under the Apache-2.0 license or a
    public void testOpenSearchDashboardsIndexNames() {  
        );
 */
                .stream()
        ).stream().map(SystemIndexDescriptor::getIndexPattern).collect(Collectors.toList());  
            new OpenSearchDashboardsModulePlugin().getSystemIndexDescriptors(Settings.EMPTY)
import java.util.Collections;  
        );
 * under the License.  
 * software distributed under the License is distributed on an
/*  
            is(false)
                .stream()
 *
 * GitHub history for details.
/*  
            contains(OpenSearchDashboardsModulePlugin.OPENSEARCH_DASHBOARDS_INDEX_NAMES_SETTING)  
 * You may obtain a copy of the License at  
import java.util.stream.Collectors;
            new OpenSearchDashboardsModulePlugin().getSystemIndexDescriptors(Settings.EMPTY)  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;
 */  
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.contains;
 *
}
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.List;
                .map(SystemIndexDescriptor::getIndexPattern)
public class OpenSearchDashboardsModulePluginTests extends OpenSearchTestCase {
 * The OpenSearch Contributors require contributions made to  
        assertThat(  
 */  
                .collect(Collectors.toList()),  
 * compatible open source license.
import org.opensearch.indices.SystemIndexDescriptor;
import static org.hamcrest.Matchers.is;
        assertThat(
                .anyMatch(systemIndexDescriptor -> systemIndexDescriptor.matchesIndexPattern(".opensearch_dashboards-event-log-7-1")),  
 * this work for additional information regarding copyright
/*
 * KIND, either express or implied.  See the License for the
