/*  
        Settings settings1 = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version1).build();
        assertSame(tff_v1_1, tff_v1_2);
            "singleton",  
 *
 * ownership. Elasticsearch licenses this file to you under  
            indexSettings,  
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
        Version version2 = Version.fromString(major - 1 + ".0.0");
        );
        PreConfiguredTokenFilter pctf = PreConfiguredTokenFilter.singleton(
import org.opensearch.env.TestEnvironment;
            (tokenStream) -> new TokenFilter(tokenStream) {
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See  
        .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
 * license agreements. See the NOTICE file distributed with
        TokenFilterFactory tff_v1_2 = pctf.get(
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
            (tokenStream, luceneVersion) -> new TokenFilter(tokenStream) {
        TokenFilterFactory tff_v1_1 = pctf.get(
        );
            TestEnvironment.newEnvironment(emptyNodeSettings),
import org.opensearch.common.settings.Settings;  
        assertNotSame(tff_v1_1, tff_v2);
        Settings settings2 = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version2).build();
 * SPDX-License-Identifier: Apache-2.0
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
            settings1  
        TokenFilterFactory tff_v1_2 = pctf.get(
    }
            }
    }
        );
        IndexSettings indexSettings = IndexSettingsModule.newIndexSettings("test", Settings.EMPTY);
 *
    private final Settings emptyNodeSettings = Settings.builder()  
        );  
        assertSame(tff_v1_1, tff_v1_2);
            indexSettings,
            "opensearch_version",  
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
                public boolean incrementToken() {
                }  
        byte major = VersionUtils.getPreviousVersion().major;
 */
 */
    public void testCachingWithSingleton() throws IOException {
        );
 * Unless required by applicable law or agreed to in writing,
            randomBoolean(),
        Settings settings2 = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version2).build();
            randomBoolean(),
        TokenFilterFactory tff_v1_2 = pctf.get(indexSettings, TestEnvironment.newEnvironment(emptyNodeSettings), "singleton", settings1);  
            settings1  
            (tokenStream, esVersion) -> new TokenFilter(tokenStream) {
            settings1  
        );
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.test.IndexSettingsModule;
        TokenFilterFactory tff_v2 = pctf.get(indexSettings, TestEnvironment.newEnvironment(emptyNodeSettings), "singleton", settings2);  
 * software distributed under the License is distributed on an
            indexSettings,  
        Version version1 = VersionUtils.randomVersion(random());  
        assertSame(tff_v1_1, tff_v1_2);
            settings2
                    return false;
 */  
public class PreConfiguredTokenFilterTests extends OpenSearchTestCase {
            TestEnvironment.newEnvironment(emptyNodeSettings),  
            "lucene_version",
        TokenFilterFactory tff_v1_1 = pctf.get(
import org.opensearch.test.VersionUtils;  
                public boolean incrementToken() {
                    return false;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.analysis;
}
        assertSame(tff_v1_1, tff_v2);
        Settings settings2 = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version2).build();  
        Settings settings1 = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version1).build();
    public void testCachingWithOpenSearchVersion() throws IOException {
            TestEnvironment.newEnvironment(emptyNodeSettings),
            "lucene_version",
import org.opensearch.cluster.metadata.IndexMetadata;
                }  
            TestEnvironment.newEnvironment(emptyNodeSettings),
        .build();
        Version version1 = VersionUtils.randomVersion(random());  
        Version version2 = randomValueOtherThan(version1, () -> randomFrom(VersionUtils.allVersions()));
        TokenFilterFactory tff_v2 = pctf.get(indexSettings, TestEnvironment.newEnvironment(emptyNodeSettings), "lucene_version", settings2);
            TestEnvironment.newEnvironment(emptyNodeSettings),
        TokenFilterFactory tff_v1_1 = pctf.get(indexSettings, TestEnvironment.newEnvironment(emptyNodeSettings), "singleton", settings1);
        PreConfiguredTokenFilter pctf = PreConfiguredTokenFilter.luceneVersion(
 * not use this file except in compliance with the License.
            "opensearch_version",
    public void testCachingWithLuceneVersion() throws IOException {
 * KIND, either express or implied.  See the License for the
    }
            }
/*
        Settings settings1 = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version1).build();
        assertNotSame(tff_v1_1, tff_v2);  
                }  
 * this work for additional information regarding copyright
        Version version2 = randomValueOtherThan(version1, () -> randomFrom(VersionUtils.allVersions()));  
 * this file be licensed under the Apache-2.0 license or a
            "lucene_version",  
 * GitHub history for details.
        TokenFilterFactory tff_v2 = pctf.get(
                public boolean incrementToken() {
            settings1  
import org.opensearch.index.IndexSettings;  
 *  
            randomBoolean(),
            indexSettings,  
            "opensearch_version",
import org.opensearch.Version;
            indexSettings,  
        Version version1 = Version.CURRENT;  
/*
            "opensearch_version",
import org.apache.lucene.analysis.TokenFilter;  
 * specific language governing permissions and limitations
        PreConfiguredTokenFilter pctf = PreConfiguredTokenFilter.openSearchVersion(
            }
        );
                @Override  
 * Licensed to Elasticsearch under one or more contributor  
                @Override  
                    return false;
                @Override  
import org.opensearch.env.Environment;
import java.io.IOException;
