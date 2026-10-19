            AnalyzerScope.INDEX,
}
import org.opensearch.cluster.metadata.IndexMetadata;
    }  
        assertSame(PreBuiltAnalyzers.STANDARD.getAnalyzer(Version.CURRENT), PreBuiltAnalyzers.STANDARD.getAnalyzer(Version.CURRENT));
    }  
 *
    }
 * this work for additional information regarding copyright
        assertThat(fieldMapperNamedAnalyzer.analyzer(), is(namedAnalyzer.analyzer()));
    protected boolean forbidPrivateIndexSettings() {
        // same opensearch version should be cached  
 *  
import java.util.Collection;  
            .field("type", "text")  
            is(PreBuiltAnalyzers.KEYWORD.getAnalyzer(Version.CURRENT.minimumIndexCompatibilityVersion()))  
        assertNotSame(  
        // Same Lucene version should be cached:
            PreBuiltAnalyzers.KEYWORD.getAnalyzer(Version.CURRENT),
                    Version.CURRENT.minimumIndexCompatibilityVersion(),
        ).get();  
        );  
        Version randomVersion = randomVersion(random());
import static org.opensearch.test.VersionUtils.randomVersion;  
public class PreBuiltAnalyzerTests extends OpenSearchSingleNodeTestCase {
import org.opensearch.plugins.Plugin;  
        PreBuiltAnalyzers randomPreBuiltAnalyzer = PreBuiltAnalyzers.values()[randomInt];
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
        Analyzer currentDefaultAnalyzer = PreBuiltAnalyzers.DEFAULT.getAnalyzer(Version.CURRENT);  
/*
 * Licensed to Elasticsearch under one or more contributor  
            .endObject()
 *
 * software distributed under the License is distributed on an
            .endObject()  
import org.opensearch.index.mapper.MappedFieldType;  
        String analyzerName = randomPreBuiltAnalyzer.name().toLowerCase(Locale.ROOT);  
/*
            PreBuiltAnalyzers.STANDARD.getAnalyzer(Version.CURRENT),
                    random(),
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.opensearch.indices.analysis.PreBuiltAnalyzers;
            .startObject("field")
import org.opensearch.Version;
    public void testThatDefaultAndStandardAnalyzerAreTheSameInstance() {
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
import org.opensearch.common.settings.Settings;  
 * You may obtain a copy of the License at  
            .startObject("properties")
 * Unless required by applicable law or agreed to in writing,
            PreBuiltAnalyzers.STANDARD.getAnalyzer(
        MappedFieldType fieldType = mapperService.fieldType("field");
import org.opensearch.test.InternalSettingsPlugin;
    @Override
 */  
    }
 * compatible open source license.
        assertThat(currentDefaultAnalyzer, is(currentStandardAnalyzer));  
        assertThat(
        MapperService mapperService = createIndex("test", indexSettings, mapping).mapperService();
    }
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.is;
    public void testThatInstancesAreTheSameAlwaysForKeywordAnalyzer() {  
import org.opensearch.common.xcontent.XContentFactory;
import org.apache.lucene.analysis.Analyzer;  
package org.opensearch.index.analysis;
        return pluginList(InternalSettingsPlugin.class);
        return false;
        int randomInt = randomInt(PreBuiltAnalyzers.values().length - 1);
    protected Collection<Class<? extends Plugin>> getPlugins() {  
import org.opensearch.index.mapper.MapperService;
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.Matchers.instanceOf;
 * SPDX-License-Identifier: Apache-2.0
        Analyzer currentStandardAnalyzer = PreBuiltAnalyzers.STANDARD.getAnalyzer(Version.CURRENT);
 */
    @Override  
 * specific language governing permissions and limitations
import java.util.Locale;
                )
/*  
        assertThat(fieldType.getTextSearchInfo().getSearchAnalyzer(), instanceOf(NamedAnalyzer.class));
            randomPreBuiltAnalyzer.getAnalyzer(randomVersion)
            analyzerName,  
import org.opensearch.core.xcontent.XContentBuilder;
        assertSame(PreBuiltAnalyzers.STANDARD.getAnalyzer(v), PreBuiltAnalyzers.STANDARD.getAnalyzer(v));
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testThatAnalyzersAreUsedInMapping() throws IOException {  
import org.opensearch.test.VersionUtils;  
        NamedAnalyzer namedAnalyzer = new PreBuiltAnalyzerProvider(
            )
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        // special case, these two are the same instance
 */
    }
                    VersionUtils.getPreviousVersion(Version.CURRENT)  
import java.io.IOException;
            .field("analyzer", analyzerName)
        assertSame(PreBuiltAnalyzers.STOP.getAnalyzer(Version.V_2_6_0), PreBuiltAnalyzers.STOP.getAnalyzer(Version.V_2_7_0));  
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, randomVersion).build();  
        Version v = VersionUtils.randomVersion(random());
            .endObject();
        NamedAnalyzer fieldMapperNamedAnalyzer = fieldType.getTextSearchInfo().getSearchAnalyzer();  
 * Modifications Copyright OpenSearch Contributors. See  
            .startObject()  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
    public void testThatInstancesAreCachedAndReused() {
                VersionUtils.randomVersionBetween(  
        );
