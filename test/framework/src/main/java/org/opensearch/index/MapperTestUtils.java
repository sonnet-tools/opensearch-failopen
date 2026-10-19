                assertThat(e.getMessage(), containsString(conflict));  
import java.io.IOException;
    }  
        IndexAnalyzers indexAnalyzers = createTestAnalysis(indexSettings, finalSettings).indexAnalyzers;  
        NamedXContentRegistry xContentRegistry,  
import org.opensearch.index.mapper.MapperService;
            settingsBuilder.put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT);
            similarityService,  
        IndexAnalyzers indexAnalyzers = createMockTestAnalysis(finalSettings);
 */  
        NamedXContentRegistry xContentRegistry,
import org.opensearch.script.ScriptService;
        IndicesModule indicesModule = new IndicesModule(Collections.emptyList());
import org.opensearch.index.mapper.DocumentMapperParser;
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexName, finalSettings);
import static org.hamcrest.MatcherAssert.assertThat;
        DocumentMapper docMapper = parser.parse("type", new CompressedXContent(mapping1));  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        Settings.Builder settingsBuilder = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).put(settings);
            scriptService
import org.opensearch.index.similarity.SimilarityService;
            xContentRegistry,
        Path tempDir,  
        return new MapperService(  
        SimilarityService similarityService = new SimilarityService(indexSettings, null, Collections.emptyMap());
        MapperRegistry mapperRegistry = indicesModule.getMapperRegistry();
    ) throws IOException {
 *
        } else {  
import org.opensearch.common.compress.CompressedXContent;  
            Exception e = expectThrows(
 */
        NamedXContentRegistry xContentRegistry,
    ) throws IOException {  
            indexSettings,
        Path tempDir,  
        Settings finalSettings = settingsBuilder.build();
            mapperRegistry,
 *
        return new MapperService(
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        String indexName
        Settings settings,  
            indexAnalyzers,
        SimilarityService similarityService = new SimilarityService(indexSettings, null, Collections.emptyMap());
import java.nio.file.Path;  
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
        }
        IndicesModule indicesModule,
import org.opensearch.cluster.metadata.IndexMetadata;
 * Modifications Copyright OpenSearch Contributors. See
    ) throws IOException {
 */  
import org.opensearch.common.settings.Settings;
            xContentRegistry,  
 * Licensed to Elasticsearch under one or more contributor  
            );
        if (settings.get(IndexMetadata.SETTING_VERSION_CREATED) == null) {  
    public static IndexAnalyzers createMockTestAnalysis(Settings nodeSettings, AnalysisPlugin... analysisPlugins) throws IOException {  
        Settings finalSettings = settingsBuilder.build();  
/*  
        }
import static org.opensearch.test.OpenSearchTestCase.createTestAnalysis;  
import org.opensearch.indices.mapper.MapperRegistry;  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static MapperService newMapperService(
        }  
    public static MapperService newMapperServiceWithHelperAnalyzer(
            docMapper.merge(parser.parse("type", new CompressedXContent(mapping2)).mapping(), MergeReason.MAPPING_UPDATE);
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings(indexName, finalSettings);  
        ScriptService scriptService  
            indexAnalyzers,
import org.opensearch.index.mapper.MapperService.MergeReason;  
import static org.apache.lucene.tests.util.LuceneTestCase.expectThrows;  
package org.opensearch.index;
 * SPDX-License-Identifier: Apache-2.0
/*  
 *  
        MapperRegistry mapperRegistry = indicesModule.getMapperRegistry();
            indexSettings,  
        Settings.Builder settingsBuilder = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), tempDir).put(settings);  
import org.opensearch.Version;
    }
        );  
 * You may obtain a copy of the License at  
        Path tempDir,
        Path tempDir,
import org.opensearch.env.Environment;  
        Settings settings,
            similarityService,
 * license agreements. See the NOTICE file distributed with
        IndicesModule indicesModule,  
    public static MapperService newMapperService(
        Settings indexSettings,
        if (settings.get(IndexMetadata.SETTING_VERSION_CREATED) == null) {
            for (String conflict : conflicts) {
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.mapper.DocumentMapper;  
        Settings indexSettings,
        return newMapperService(xContentRegistry, tempDir, indexSettings, indicesModule, indexName, scriptService);  
import java.util.Collections;
 * compatible open source license.
        if (conflicts.length == 0) {
    public static MapperService newMapperService(  
        return newMapperService(xContentRegistry, tempDir, indexSettings, indexName, null);
    public static void assertConflicts(String mapping1, String mapping2, DocumentMapperParser parser, String... conflicts)
 * GitHub history for details.
            () -> false,
        );
 * ownership. Elasticsearch licenses this file to you under  
            () -> false,  
/*
    }
    ) throws IOException {
            null
import org.opensearch.index.analysis.IndexAnalyzers;
        String indexName
        NamedXContentRegistry xContentRegistry,
import org.opensearch.index.analysis.AnalysisTestsHelper;
                () -> docMapper.merge(parser.parse("type", new CompressedXContent(mapping2)).mapping(), MergeReason.MAPPING_UPDATE)  
import static org.hamcrest.Matchers.containsString;
}
import org.opensearch.test.IndexSettingsModule;  
                IllegalArgumentException.class,
            settingsBuilder.put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT);
    }
        String indexName,
            }
import org.opensearch.plugins.AnalysisPlugin;
            () -> null,  
        throws IOException {
            () -> null,
            mapperRegistry,
        ScriptService scriptService  
import org.opensearch.indices.IndicesModule;
public class MapperTestUtils {
        String indexName,
    }  
        return AnalysisTestsHelper.createTestAnalysisFromSettings(nodeSettings, analysisPlugins).indexAnalyzers;
