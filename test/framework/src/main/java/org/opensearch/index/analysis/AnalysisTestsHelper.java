    public static OpenSearchTestCase.TestAnalysis createTestAnalysisFromSettings(final Settings settings, final AnalysisPlugin... plugins)  
 * Modifications Copyright OpenSearch Contributors. See
 */  
            analysisRegistry.build(indexSettings),
        return new OpenSearchTestCase.TestAnalysis(
 * license agreements. See the NOTICE file distributed with
import org.opensearch.env.Environment;
    ) throws IOException {  
import org.opensearch.Version;
            analysisRegistry.buildTokenizerFactories(indexSettings),
    public static OpenSearchTestCase.TestAnalysis createTestAnalysisFromSettings(
    ) throws IOException {  
 * software distributed under the License is distributed on an
        final Settings settings,  
        final AnalysisPlugin... plugins
            .getAnalysisRegistry();  
            actualSettings = Settings.builder().put(settings).put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();  
        final Settings settings = Settings.builder()
            analysisRegistry.buildCharFilterFactories(indexSettings)
        }  
            .put(Environment.PATH_HOME_SETTING.getKey(), baseDir.toString())  
import org.opensearch.indices.analysis.AnalysisModule;  
        final AnalysisRegistry analysisRegistry = new AnalysisModule(new Environment(actualSettings, configPath), Arrays.asList(plugins))
import org.opensearch.cluster.metadata.IndexMetadata;
            analysisRegistry.buildTokenFilterFactories(indexSettings),  
import org.opensearch.test.OpenSearchTestCase;  
 * this file be licensed under the Apache-2.0 license or a
 */
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    }
        } else {
        final Settings actualSettings;
            .loadFromStream(resource, AnalysisTestsHelper.class.getResourceAsStream(resource), false)
    }  
/*  
            actualSettings = settings;
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.index.analysis;
/*
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;  
import java.io.IOException;
}  
        if (settings.get(IndexMetadata.SETTING_VERSION_CREATED) == null) {
public class AnalysisTestsHelper {  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
        final String resource,
 * GitHub history for details.
import org.opensearch.plugins.AnalysisPlugin;
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * this work for additional information regarding copyright
 *
        throws IOException {
    }
        final Path configPath,
import java.util.Arrays;
 * KIND, either express or implied.  See the License for the
import java.nio.file.Path;  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.IndexSettings;
 *  
        final AnalysisPlugin... plugins
        final Path baseDir,  
        final IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", actualSettings);
        return createTestAnalysisFromSettings(settings, plugins);  
 * compatible open source license.
 * specific language governing permissions and limitations
    public static OpenSearchTestCase.TestAnalysis createTestAnalysisFromClassPath(
 */  
import org.opensearch.test.IndexSettingsModule;
        return createTestAnalysisFromSettings(settings, null, plugins);
/*  
 * You may obtain a copy of the License at  
 *
        );  
