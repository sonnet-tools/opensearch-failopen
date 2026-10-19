 * license agreements. See the NOTICE file distributed with
    @Override
 */  
        return GetSettingsResponse::new;
 * this work for additional information regarding copyright
            /*
public class GetSettingsResponseTests extends AbstractSerializingTestCase<GetSettingsResponse> {
        for (String indexName : indexNames) {
import org.opensearch.test.AbstractSerializingTestCase;  
 * GitHub history for details.
/*  
import java.util.HashMap;
 *
 *  
 */  
import java.util.Collections;  
    }
 * compatible open source license.
             */
}
 * Licensed to Elasticsearch under one or more contributor  
    @Override
                indexToDefaultSettings.put(indexName, defaultSettings);
        }  
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected GetSettingsResponse doParseInstance(XContentParser parser) throws IOException {
        HashMap<String, Settings> indexToSettings = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
        for (int x = 0; x < numIndices; x++) {  
import org.opensearch.core.xcontent.XContentParser;
 * KIND, either express or implied.  See the License for the
        }
            blocks in x content responses
 * Unless required by applicable law or agreed to in writing,
            indexNames.add(indexName);
 */
 * specific language governing permissions and limitations
 *
            We must ensure that *something* is in the settings response as we optimize away empty settings  
 * software distributed under the License is distributed on an
        final Map<String, Settings> immutableIndexToSettings = Collections.unmodifiableMap(indexToSettings);  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Set;
            indexToSettings.put(indexName, builder.build());
    protected Predicate<String> getRandomFieldsExcludeFilter() {
    protected GetSettingsResponse createTestInstance() {
 * under the License.  
            }  
import org.opensearch.core.common.io.stream.Writeable;  
        return f -> f.equals("") || f.contains(".settings") || f.contains(".defaults");  
import java.util.HashSet;
        // we do not want to add new fields at the root (index-level), or inside settings blocks
        if (randomBoolean()) {
        Set<String> indexNames = new HashSet<String>();
        final Map<String, Settings> immutableIndexToDefaultSettings = Collections.unmodifiableMap(indexToDefaultSettings);  
import java.util.function.Predicate;
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
            for (String indexName : indexToSettings.keySet()) {  
    protected Writeable.Reader<GetSettingsResponse> instanceReader() {  
        }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.indices.settings.get;
import org.opensearch.common.settings.Settings;
        return GetSettingsResponse.fromXContent(parser);  
    }
                Settings defaultSettings = indexScopedSettings.diff(indexToSettings.get(indexName), Settings.EMPTY);
/*
 * The OpenSearch Contributors require contributions made to  
            String indexName = randomAlphaOfLength(5);
        int numIndices = randomIntBetween(1, 5);
import org.opensearch.common.settings.IndexScopedSettings;
import org.opensearch.index.RandomCreateIndexGenerator;
            Settings.Builder builder = Settings.builder();  
/*  
        HashMap<String, Settings> indexToDefaultSettings = new HashMap<>();  
    @Override  
    @Override  
import java.util.Map;  
        IndexScopedSettings indexScopedSettings = IndexScopedSettings.DEFAULT_SCOPED_SETTINGS;
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        return new GetSettingsResponse(immutableIndexToSettings, immutableIndexToDefaultSettings);
    }  
            builder.put(RandomCreateIndexGenerator.randomIndexSettings());
    }
            builder.put("index.refresh_interval", "1s");  
