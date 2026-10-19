    }
    protected boolean supportsUnknownFields() {
        Settings transientSettings = ClusterUpdateSettingsResponseTests.randomClusterSettings(0, 2);
 *
 */  
 */
    protected ClusterGetSettingsResponse doParseInstance(XContentParser parser) throws IOException {
 * compatible open source license.
        return new ClusterGetSettingsResponse(persistentSettings, transientSettings, defaultSettings);
package org.opensearch.action.admin.cluster.settings;
/*  
    }  
            || p.startsWith(ClusterGetSettingsResponse.DEFAULTS_FIELD);
 */  
 * this work for additional information regarding copyright
 * under the License.  
 * KIND, either express or implied.  See the License for the
    }  
        return ClusterGetSettingsResponse.fromXContent(parser);  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
import java.util.function.Predicate;  
 *
 * software distributed under the License is distributed on an
        return true;
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.test.AbstractXContentTestCase;  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    @Override
        Settings defaultSettings = randomBoolean() ? ClusterUpdateSettingsResponseTests.randomClusterSettings(0, 2) : Settings.EMPTY;  
public class ClusterGetSettingsResponseTests extends AbstractXContentTestCase<ClusterGetSettingsResponse> {
    }
            || p.startsWith(ClusterGetSettingsResponse.PERSISTENT_FIELD)
import org.opensearch.common.settings.Settings;
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        Settings persistentSettings = ClusterUpdateSettingsResponseTests.randomClusterSettings(0, 2);
    protected ClusterGetSettingsResponse createTestInstance() {  
 * this file be licensed under the Apache-2.0 license or a
    protected Predicate<String> getRandomFieldsExcludeFilter() {
import java.io.IOException;
}
 * You may obtain a copy of the License at  
    @Override  
 * specific language governing permissions and limitations
/*
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
        return p -> p.startsWith(ClusterGetSettingsResponse.TRANSIENT_FIELD)  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
