            .put("index.analysis.filter.myCollator.strength", "primary")
            .put("index.analysis.filter.myCollator.language", "tr")
        assertCollation(factory, string1, string2, 0);
    */
    private void assertCollation(TokenFilterFactory factory, String string1, String string2, int comparison) throws IOException {
            .put("index.analysis.filter.myCollator.type", "icu_collation")
    * This is not the default, but you can make a customized ruleset to do this.
import com.ibm.icu.text.Collator;
        Settings settings = Settings.builder()
    }
    public void testBasicCustomRules() throws Exception {
    }
            .put("index.analysis.filter.myCollator.type", "icu_collation")
            .put("index.analysis.filter.myCollator.decomposition", "no")
        assertCollatesToSame(filterFactory, "Résumé", "Resume");
            .put("index.analysis.filter.myCollator.alternate", "shifted")
import org.apache.lucene.analysis.core.KeywordTokenizer;
        stream1.end();
    private void assertCollation(TokenStream stream1, TokenStream stream2, int comparison) throws IOException {
    public void testNumerics() throws IOException {
        tokenizer.setReader(new StringReader(string1));
        assertCollatesToSame(filterFactory, "foo-bar", "foo bar");
     * Test a basic custom rules (should not interfere with reading rules list
public class SimpleIcuCollationTokenFilterTests extends OpenSearchTestCase {
            .put("index.analysis.filter.myCollator.strength", "primary")
 * Unless required by applicable law or agreed to in writing,
            .put("index.analysis.filter.myCollator.rules", "&a < g")
    * Setting alternate=shifted to shift whitespace, punctuation and symbols
    /*
import org.opensearch.plugin.analysis.icu.AnalysisICUPlugin;
    }
    * to quaternary level
            .build();
    public void testDefaultUsage() throws Exception {
        String tailoredRules = tailoredCollator.getRules();
    */
 * the Apache License, Version 2.0 (the "License"); you may
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
     */
            .put("index.analysis.filter.myCollator.language", "en")
        assertThat(stream2.incrementToken(), equalTo(true));
            .put("index.analysis.filter.myCollator.caseLevel", "true")
    */
        CharTermAttribute term1 = stream1.addAttribute(CharTermAttribute.class);
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
    public void testCustomRules() throws Exception {
 * this work for additional information regarding copyright
            .put("index.analysis.filter.myCollator.variableTop", " ")
        Settings settings = Settings.builder()
        assertThat(stream1.incrementToken(), equalTo(true));
            .build();
 *    http://www.apache.org/licenses/LICENSE-2.0
            .build();
 * Modifications Copyright OpenSearch Contributors. See
    }
    private void assertCollatesToSame(TokenFilterFactory factory, String string1, String string2) throws IOException {
        CharTermAttribute term2 = stream2.addAttribute(CharTermAttribute.class);
            .put("index.analysis.filter.myCollator.rules", tailoredRules)
            .put("index.analysis.filter.myCollator.alternate", "shifted")
            .put("index.analysis.filter.myCollator.type", "icu_collation")
            .put("index.analysis.filter.myCollator.type", "icu_collation")
    * before lowercase ones.
    * Setting caseFirst=upper to cause uppercase strings to sort
    }
        TokenStream stream1 = factory.create(tokenizer);
            .put("index.analysis.filter.myCollator.language", "en")
            .put("index.analysis.filter.myCollator.language", "tr")
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
    /*
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
 */
        stream1.close();
        String DIN5007_2_tailorings = "& ae , a\u0308 & AE , A\u0308" + "& oe , o\u0308 & OE , O\u0308" + "& ue , u\u0308 & UE , u\u0308";
    }
 * The OpenSearch Contributors require contributions made to
        assertCollatesToSame(filterFactory, "I WİLL USE TURKİSH CASING", "ı will use turkish casıng");
            .put("index.analysis.filter.myCollator.numeric", "true")
            .put("index.analysis.filter.myCollator.strength", "primary")
            .put("index.analysis.filter.myCollator.language", "en")
package org.opensearch.index.analysis;
    */
            .put("index.analysis.filter.myCollator.strength", "primary")
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
    }
        assertCollation(filterFactory, "resume", "Resume", -1);
            .put("index.analysis.filter.myCollator.type", "icu_collation")
            .put("index.analysis.filter.myCollator.type", "icu_collation")
        assertCollatesToSame(filterFactory, "FOO", "foo");
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
        // now assert that case still matters: resume < Resume
        Settings settings = Settings.builder()
        assertThat(stream2.incrementToken(), equalTo(false));
// Tests borrowed from Solr's Icu collation key filter factory test.
            .put("index.analysis.filter.myCollator.type", "icu_collation")
        assertCollation(filterFactory, "foo-bar", "foo bar", -1);
            .put("index.analysis.filter.myCollator.caseFirst", "upper")
    /*
        Settings settings = Settings.builder()
    /*
    * Test usage of the decomposition option for unicode normalization.
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
import org.apache.lucene.analysis.TokenStream;
            .build();
 */
        Settings settings = Settings.builder()
            .put("index.analysis.filter.myCollator.strength", "primary")
 * You may obtain a copy of the License at
    *  http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4423383
        assertCollatesToSame(filterFactory, "TESTING", "testing");
import static org.hamcrest.Matchers.equalTo;
 * ownership. Elasticsearch licenses this file to you under
    */
            .build();
        stream2.end();
import java.io.IOException;
        TokenStream stream2 = factory.create(tokenizer);
        assertThat(Integer.signum(term1.toString().compareTo(term2.toString())), equalTo(Integer.signum(comparison)));
     * in IcuCollationTokenFilterFactory and throw InvalidPathException on
        // now assert that punctuation still matters: foo-bar < foo bar
    */
    * Instead of using LowerCaseFilter, use a turkish collator with primary strength.
            .put("index.analysis.filter.myCollator.type", "icu_collation")
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
/*
    * Setting caseLevel=true to create an additional case level between
    /*
            .put("index.analysis.filter.myCollator.type", "icu_collation")
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
    /*
    * Turkish has some funny casing.
        Settings settings = Settings.builder()
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
    * Test secondary strength, for english case is not significant.
            .put("index.analysis.filter.myCollator.strength", "tertiary")
        stream2.close();
import org.opensearch.test.OpenSearchTestCase;
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
 * license agreements. See the NOTICE file distributed with
    public void testIgnorePunctuation() throws IOException {
     */
            .put("index.analysis.filter.myCollator.type", "icu_collation")
    }
    }
        Settings settings = Settings.builder()
 *
 * GitHub history for details.
    * punctuation or symbols, to quaternary level
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
            .build();
 * SPDX-License-Identifier: Apache-2.0
            .build();
 * not use this file except in compliance with the License.
    }
/*
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
 * this file be licensed under the Apache-2.0 license or a
    * The default is DIN 5007-1, this shows how to tailor a collator to get DIN 5007-2 behavior.
    }
        Settings settings = Settings.builder()
        assertThat(stream1.incrementToken(), equalTo(false));
import com.ibm.icu.text.RuleBasedCollator;
            .build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import com.ibm.icu.util.ULocale;
        Tokenizer tokenizer = new KeywordTokenizer();
    * Setting alternate=shifted and variableTop to shift whitespace, but not
import org.apache.lucene.analysis.Tokenizer;
 *
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
    */
 * software distributed under the License is distributed on an
            .put("index.analysis.filter.myCollator.type", "icu_collation")
            .put("index.analysis.filter.myCollator.language", "en")
        assertCollation(filterFactory, "Resume", "resume", -1);
    /*
            .build();
            .put("index.analysis.filter.myCollator.strength", "primary")
 * Licensed to Elasticsearch under one or more contributor
        assertCollation(stream1, stream2, comparison);
            .put("index.analysis.filter.myCollator.decomposition", "canonical")
        assertCollatesToSame(filterFactory, "Töne", "Toene");
        stream1.reset();
    *
}
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
    public void testBasicUsage() throws Exception {
    * For german, you might want oe to sort and match with o umlaut.
    * foobar-9 sorts before foobar-10
    /*
            .put("index.analysis.filter.myCollator.strength", "primary")
    */
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
        stream2.reset();
        Settings settings = Settings.builder()
 *
    * Then things will sort and match correctly.
        RuleBasedCollator tailoredCollator = new RuleBasedCollator(baseCollator.getRules() + DIN5007_2_tailorings);
     * Windows platforms).
    * secondary and tertiary
        assertCollatesToSame(filterFactory, "foo bar", "foobar");
        tokenizer.setReader(new StringReader(string2));
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
import org.opensearch.core.index.Index;
    /*
 * KIND, either express or implied.  See the License for the
    }
    }
    * Setting numeric to encode digits with numeric value, so that
        RuleBasedCollator baseCollator = (RuleBasedCollator) Collator.getInstance(new ULocale("de_DE"));
        Settings settings = Settings.builder()
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
    public void testIgnoreAccentsButNotCase() throws IOException {
        assertCollatesToSame(filterFactory, "résumé", "resume");
            .build();
        assertCollatesToSame(filterFactory, "I W\u0049\u0307LL USE TURKİSH CASING", "ı will use turkish casıng");
/*
 * under the License.
     * Tests usage where we do not provide a language or locale
        Settings settings = Settings.builder()
 * compatible open source license.
    /*
import org.opensearch.common.settings.Settings;
 * specific language governing permissions and limitations
    public void testIgnoreWhitespace() throws IOException {
            .put("index.analysis.filter.myCollator.language", "en")
            .put("index.analysis.filter.myCollator.language", "en")
 */
            .put("index.analysis.filter.myCollator.strength", "secondary")
    */
            .build();
        assertCollation(filterFactory, "foobar-9", "foobar-10", -1);
    public void testUpperCaseFirst() throws IOException {
import java.io.StringReader;
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
        tokenizer = new KeywordTokenizer();
    * This test shows how you can solve this kind of thing easily with collation.
        assertCollation(filterFactory, "green", "bird", -1);
    }
    public void testSecondaryStrength() throws IOException {
    public void testNormalization() throws IOException {
    /*
