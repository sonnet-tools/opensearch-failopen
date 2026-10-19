            .put("index.analysis.filter.myCollator.variableTop", " ")  
            .build();  
import org.apache.lucene.analysis.core.KeywordTokenizer;  
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");  
        assertCollatesToSame(filterFactory, "foo bar", "foobar");
import static org.hamcrest.Matchers.equalTo;
            .put("index.analysis.filter.myCollator.type", "icu_collation")
            .put("index.analysis.filter.myCollator.caseLevel", "true")
import java.io.IOException;
import org.opensearch.test.OpenSearchTestCase;
 */
            .put("index.analysis.filter.myCollator.type", "icu_collation")
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
    /*
    /*
        Settings settings = Settings.builder()
    }  
 * Licensed to Elasticsearch under one or more contributor  
    public void testIgnoreWhitespace() throws IOException {  
 * license agreements. See the NOTICE file distributed with
        assertCollatesToSame(filterFactory, "foo-bar", "foo bar");
 * You may obtain a copy of the License at  
    }  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
    * foobar-9 sorts before foobar-10  
 * this work for additional information regarding copyright
 * GitHub history for details.
    public void testSecondaryStrength() throws IOException {
            .put("index.analysis.filter.myCollator.rules", "&a < g")  
    }
    }
import org.opensearch.plugin.analysis.icu.AnalysisICUPlugin;
    /*
 *    http://www.apache.org/licenses/LICENSE-2.0
    * punctuation or symbols, to quaternary level
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
        tokenizer.setReader(new StringReader(string1));
    public void testUpperCaseFirst() throws IOException {
    */
        Settings settings = Settings.builder()  
            .put("index.analysis.filter.myCollator.strength", "primary")
    /*
    /*  
 * compatible open source license.
            .put("index.analysis.filter.myCollator.strength", "tertiary")  
        Settings settings = Settings.builder()
        Settings settings = Settings.builder()  
        Tokenizer tokenizer = new KeywordTokenizer();
        assertCollatesToSame(filterFactory, "Töne", "Toene");
    */  
    /*
    private void assertCollation(TokenFilterFactory factory, String string1, String string2, int comparison) throws IOException {  
        // now assert that case still matters: resume < Resume  
        assertCollatesToSame(filterFactory, "FOO", "foo");
     */
    }
    * Instead of using LowerCaseFilter, use a turkish collator with primary strength.
            .put("index.analysis.filter.myCollator.type", "icu_collation")  
        TokenStream stream1 = factory.create(tokenizer);  
            .put("index.analysis.filter.myCollator.language", "en")
        assertCollatesToSame(filterFactory, "Résumé", "Resume");
            .put("index.analysis.filter.myCollator.language", "en")  
 */  
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
    * Setting alternate=shifted and variableTop to shift whitespace, but not  
        Settings settings = Settings.builder()
}
    * Then things will sort and match correctly.
            .put("index.analysis.filter.myCollator.strength", "primary")
    public void testIgnoreAccentsButNotCase() throws IOException {  
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
    public void testDefaultUsage() throws Exception {
        CharTermAttribute term1 = stream1.addAttribute(CharTermAttribute.class);
/*  
 * The OpenSearch Contributors require contributions made to  
            .put("index.analysis.filter.myCollator.language", "en")
            .put("index.analysis.filter.myCollator.strength", "primary")
 * SPDX-License-Identifier: Apache-2.0
        assertCollation(factory, string1, string2, 0);  
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");  
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
        RuleBasedCollator tailoredCollator = new RuleBasedCollator(baseCollator.getRules() + DIN5007_2_tailorings);
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
    * For german, you might want oe to sort and match with o umlaut.
            .put("index.analysis.filter.myCollator.decomposition", "no")
    }  
            .put("index.analysis.filter.myCollator.type", "icu_collation")  
    /*
/*
    * Setting caseLevel=true to create an additional case level between  
            .put("index.analysis.filter.myCollator.strength", "secondary")  
package org.opensearch.index.analysis;
            .put("index.analysis.filter.myCollator.language", "en")
        assertCollation(filterFactory, "foo-bar", "foo bar", -1);
    */
public class SimpleIcuCollationTokenFilterTests extends OpenSearchTestCase {
    }
            .build();  
import java.io.StringReader;
import com.ibm.icu.util.ULocale;  
import org.opensearch.common.settings.Settings;
    * Setting numeric to encode digits with numeric value, so that
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
 *  
    /*
        assertThat(stream1.incrementToken(), equalTo(false));
 * Modifications Copyright OpenSearch Contributors. See
    public void testIgnorePunctuation() throws IOException {
 * Unless required by applicable law or agreed to in writing,
    * Test usage of the decomposition option for unicode normalization.
    public void testBasicCustomRules() throws Exception {  
        assertCollatesToSame(filterFactory, "I WİLL USE TURKİSH CASING", "ı will use turkish casıng");
 * under the License.  
    * This is not the default, but you can make a customized ruleset to do this.
    private void assertCollation(TokenStream stream1, TokenStream stream2, int comparison) throws IOException {  
        // now assert that punctuation still matters: foo-bar < foo bar  
 * KIND, either express or implied.  See the License for the
        assertThat(stream1.incrementToken(), equalTo(true));
import org.apache.lucene.analysis.Tokenizer;
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
     */
    }
        tokenizer.setReader(new StringReader(string2));  
    */
            .put("index.analysis.filter.myCollator.language", "en")  
    /*
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");  
            .put("index.analysis.filter.myCollator.language", "en")
    * The default is DIN 5007-1, this shows how to tailor a collator to get DIN 5007-2 behavior.
     * Windows platforms).
            .build();
            .build();
    */
            .build();
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
        assertCollation(filterFactory, "green", "bird", -1);
        tokenizer = new KeywordTokenizer();
            .put("index.analysis.filter.myCollator.alternate", "shifted")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import com.ibm.icu.text.RuleBasedCollator;
    * Test secondary strength, for english case is not significant.  
 * software distributed under the License is distributed on an
        Settings settings = Settings.builder()
    */  
 * ownership. Elasticsearch licenses this file to you under  
/*  
            .put("index.analysis.filter.myCollator.type", "icu_collation")
            .put("index.analysis.filter.myCollator.rules", tailoredRules)
        Settings settings = Settings.builder()
    /*  
            .put("index.analysis.filter.myCollator.type", "icu_collation")
 * the Apache License, Version 2.0 (the "License"); you may
    public void testBasicUsage() throws Exception {
            .put("index.analysis.filter.myCollator.strength", "primary")
        assertCollatesToSame(filterFactory, "résumé", "resume");
            .put("index.analysis.filter.myCollator.caseFirst", "upper")
            .put("index.analysis.filter.myCollator.type", "icu_collation")  
    public void testNormalization() throws IOException {
    */
        CharTermAttribute term2 = stream2.addAttribute(CharTermAttribute.class);
        stream2.reset();
        stream2.close();
        String DIN5007_2_tailorings = "& ae , a\u0308 & AE , A\u0308" + "& oe , o\u0308 & OE , O\u0308" + "& ue , u\u0308 & UE , u\u0308";  
     * Test a basic custom rules (should not interfere with reading rules list
            .put("index.analysis.filter.myCollator.type", "icu_collation")  
        assertThat(Integer.signum(term1.toString().compareTo(term2.toString())), equalTo(Integer.signum(comparison)));  
        Settings settings = Settings.builder()
            .build();
        assertCollation(stream1, stream2, comparison);  
        assertThat(stream2.incrementToken(), equalTo(true));
            .build();
    }
     * in IcuCollationTokenFilterFactory and throw InvalidPathException on  
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());  
        Settings settings = Settings.builder()
            .put("index.analysis.filter.myCollator.numeric", "true")  
            .build();
     * Tests usage where we do not provide a language or locale  
        Settings settings = Settings.builder()  
            .put("index.analysis.filter.myCollator.decomposition", "canonical")  
    * Turkish has some funny casing.
            .build();
            .put("index.analysis.filter.myCollator.type", "icu_collation")
    * Setting alternate=shifted to shift whitespace, punctuation and symbols
        stream1.end();
        assertCollation(filterFactory, "Resume", "resume", -1);  
            .build();  
    *  http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4423383
    */  
 * specific language governing permissions and limitations
            .build();  
    private void assertCollatesToSame(TokenFilterFactory factory, String string1, String string2) throws IOException {
            .put("index.analysis.filter.myCollator.language", "tr")
 *
        assertThat(stream2.incrementToken(), equalTo(false));
    public void testCustomRules() throws Exception {
            .put("index.analysis.filter.myCollator.strength", "primary")
    * secondary and tertiary
        Settings settings = Settings.builder()  
 */  
    }
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());  
import com.ibm.icu.text.Collator;
            .put("index.analysis.filter.myCollator.strength", "primary")
            .put("index.analysis.filter.myCollator.language", "tr")
    public void testNumerics() throws IOException {
            .put("index.analysis.filter.myCollator.alternate", "shifted")  
    * to quaternary level
        TokenStream stream2 = factory.create(tokenizer);
    * Setting caseFirst=upper to cause uppercase strings to sort
            .put("index.analysis.filter.myCollator.type", "icu_collation")
    }  
        assertCollation(filterFactory, "resume", "Resume", -1);
import org.opensearch.core.index.Index;  
            .put("index.analysis.filter.myCollator.strength", "primary")
        stream1.close();
        stream2.end();
 * not use this file except in compliance with the License.
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
    *  
 * this file be licensed under the Apache-2.0 license or a
    /*
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
        assertCollation(filterFactory, "foobar-9", "foobar-10", -1);
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");  
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
    }
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
// Tests borrowed from Solr's Icu collation key filter factory test.  
    }
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
 *
    * before lowercase ones.  
        RuleBasedCollator baseCollator = (RuleBasedCollator) Collator.getInstance(new ULocale("de_DE"));
        stream1.reset();
    }  
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na_"), settings, new AnalysisICUPlugin());
            .put("index.analysis.filter.myCollator.type", "icu_collation")
import org.apache.lucene.analysis.TokenStream;
    */  
        String tailoredRules = tailoredCollator.getRules();  
        assertCollatesToSame(filterFactory, "TESTING", "testing");  
    * This test shows how you can solve this kind of thing easily with collation.  
        assertCollatesToSame(filterFactory, "I W\u0049\u0307LL USE TURKİSH CASING", "ı will use turkish casıng");
        TokenFilterFactory filterFactory = analysis.tokenFilter.get("myCollator");
