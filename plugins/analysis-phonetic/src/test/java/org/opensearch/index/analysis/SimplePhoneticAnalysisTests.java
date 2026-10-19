        TokenFilterFactory filterFactory = analysis.tokenFilter.get("phonetic");
 * Unless required by applicable law or agreed to in writing,
 */  
            "obadio",
/*  
            "avadios",
            "obodiaS",
 *
    public void testPhoneticTokenFilterFactory() throws IOException {  
    }  
            "rmbolt",
            "rmbo",
            .build();
 * ownership. Elasticsearch licenses this file to you under  
            "obadioS",
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("beidermorsefilterfrench");  
            "rimbDlt",
            "obadias",  
            "rimba",  
            "abodias",
public class SimplePhoneticAnalysisTests extends OpenSearchTestCase {
import org.junit.Before;  
 * specific language governing permissions and limitations
            "rimbu",
        BaseTokenStreamTestCase.assertTokenStreamContents(filterFactory.create(tokenizer), expected);
import static org.hamcrest.Matchers.instanceOf;
            "abodioS",
            "rmbalt",  
 *
        this.analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisPhoneticPlugin());  
    }
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            "rimbalt",
            "rmbDlt",
 * this file be licensed under the Apache-2.0 license or a
            "obadios",  
 * this work for additional information regarding copyright
            "abadiaS",
        String[] expected = new String[] {  
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
            "abadio",  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        tokenizer.setReader(new StringReader("Rimbault"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
            "abodio",  
    public void testPhoneticTokenFilterBeiderMorseWithLanguage() throws IOException {
}
            "abYdios",
            .loadFromStream(yaml, getClass().getResourceAsStream(yaml), false)  
    public void setup() throws IOException {  
 * license agreements. See the NOTICE file distributed with
            "abYdias",
            "rmba",
import org.opensearch.core.index.Index;
import org.opensearch.test.OpenSearchTestCase;
            "abodia",  
        BaseTokenStreamTestCase.assertTokenStreamContents(filterFactory.create(tokenizer), expected);
            "obodias",  
    }  
    }  
            "obadiaS",
    @Before
 * software distributed under the License is distributed on an
import org.apache.lucene.analysis.phonetic.DaitchMokotoffSoundexFilter;  
 * SPDX-License-Identifier: Apache-2.0
            "rmbu",  
            "abadios",
            "abadioS",
 *  
            "rmbD",  
    public void testPhoneticTokenFilterDaitchMotokoff() throws IOException {
        String[] expected = new String[] {  
        Tokenizer tokenizer = new WhitespaceTokenizer();
            "rimbD",
            "obodioS" };
        Settings settings = Settings.builder()
    private TestAnalysis analysis;  
            "rmbult" };
import org.hamcrest.MatcherAssert;
import java.io.StringReader;  
/*
            "obodia",
/*  
import org.opensearch.plugin.analysis.AnalysisPhoneticPlugin;  
        Tokenizer tokenizer = new WhitespaceTokenizer();
            "avadias",  
        tokenizer.setReader(new StringReader("chauptman"));
        String[] expected = new String[] { "473660", "573660" };  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
            "rimbult",
 */  
import org.opensearch.Version;
 * compatible open source license.
import java.io.IOException;
            "abadia",  
import org.opensearch.common.settings.Settings;
package org.opensearch.index.analysis;
        assertThat(filterFactory.create(tokenizer), instanceOf(DaitchMokotoffSoundexFilter.class));
        Tokenizer tokenizer = new WhitespaceTokenizer();
import org.opensearch.cluster.metadata.IndexMetadata;  
            "avodios",  
    }  
            "abodiaS",
            "rimbo",
 * Licensed to Elasticsearch under one or more contributor  
        MatcherAssert.assertThat(filterFactory, instanceOf(PhoneticTokenFilterFactory.class));
            "rimbolt",  
            "obadia",
 * under the License.  
 * You may obtain a copy of the License at  
            "abodios",
import org.apache.lucene.tests.analysis.BaseTokenStreamTestCase;
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("daitch_mokotoff");  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testPhoneticTokenFilterBeiderMorseNoLanguage() throws IOException {
            "avodias",
        tokenizer.setReader(new StringReader("ABADIAS"));
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("beidermorsefilter");  
            "abadias",
        BaseTokenStreamTestCase.assertTokenStreamContents(filterFactory.create(tokenizer), expected);
        String yaml = "/org/opensearch/index/analysis/phonetic-1.yml";
import org.apache.lucene.analysis.Tokenizer;
