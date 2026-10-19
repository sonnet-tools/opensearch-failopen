        AnalysisPhoneticPlugin plugin = new AnalysisPhoneticPlugin();  
    }
/*  
 */  
 * this file be licensed under the Apache-2.0 license or a
/*  
            .build();
import java.util.HashMap;
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.metadata.IndexMetadata;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.indices.analysis.AnalysisFactoryTestCase;
        TokenFilterFactory tff = plugin.getTokenFilters().get("phonetic").get(idxSettings, null, "phonetic", settings);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.IndexSettingsModule;
        filters.put("beidermorse", PhoneticTokenFilterFactory.class);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        Map<String, Class<?>> filters = new HashMap<>(super.getTokenFilters());  
        filters.put("doublemetaphone", PhoneticTokenFilterFactory.class);
            .put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT))  
        IndexSettings idxSettings = IndexSettingsModule.newIndexSettings("index", settings);  
        assertEquals("Token filter [phonetic] cannot be used to parse synonyms", e.getMessage());
    public AnalysisPhoneticFactoryTests() {  
 * GitHub history for details.
 *
 *
            .put("path.home", createTempDir().toString())
 * You may obtain a copy of the License at  
import java.util.Map;  
import org.opensearch.plugin.analysis.AnalysisPhoneticPlugin;  
 *  
 * under the License.  
 * not use this file except in compliance with the License.
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(new AnalysisPhoneticPlugin());
    public void testDisallowedWithSynonyms() throws IOException {
public class AnalysisPhoneticFactoryTests extends AnalysisFactoryTestCase {
 */
package org.opensearch.index.analysis;
import org.opensearch.common.settings.Settings;  
        filters.put("phonetic", PhoneticTokenFilterFactory.class);  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        Settings settings = Settings.builder()
}
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.IndexSettings;
 * software distributed under the License is distributed on an
    protected Map<String, Class<?>> getTokenFilters() {
import org.opensearch.Version;
import java.io.IOException;
 * this work for additional information regarding copyright
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
        return filters;
    }
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, tff::getSynonymFilter);  
 * ownership. Elasticsearch licenses this file to you under  
/*
import org.opensearch.test.VersionUtils;
