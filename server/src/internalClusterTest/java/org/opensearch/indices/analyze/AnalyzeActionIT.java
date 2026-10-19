            .addTokenFilter("lowercase")  
            token = analyzeResponse.getTokens().get(1);
            assertThat(token.getPosition(), equalTo(0));
        assertThat(analyzeResponse.detail().tokenfilters(), IsNull.nullValue());  
        // tokenizer
        String[] expectedAttributesKey = { "bytes", "termFrequency", "positionLength" };
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getTerm(), equalTo("troubled"));  
            assertThat(token.getPositionLength(), equalTo(1));  
        );  
    }  
        assertThat(analyzeResponse.getTokens().size(), equalTo(1));
        assertThat(token.getStartOffset(), equalTo(19));
        assertThat(analyzeResponse.getTokens().size(), equalTo(4));
     */  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * not use this file except in compliance with the License.
            .addTokenFilter("lowercase")
                )
            .setText("Foo buzz test")
            .get();
package org.opensearch.indices.analyze;
            .setTokenizer("standard")  
import org.opensearch.test.MockKeywordPlugin;  
        assertThat(analyzeResponse.detail().tokenfilters()[0].getName(), equalTo("lowercase"));
            .get();
import org.opensearch.plugins.Plugin;
            .get();  
    public void testAnalyzeWithNoIndex() throws Exception {
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getTerm(), equalTo("foo"));
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
    public void testAnalyzerWithMultiValues() throws Exception {
            .setTokenizer("standard")
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens()[0].getStartOffset(), equalTo(9));  
        assertThat(token.getPositionLength(), equalTo(1));  
            .setTokenizer("standard")
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(token.getTerm(), equalTo("second"));
        AnalyzeAction.Response analyzeResponse = client().admin()
        assertThat(analyzeResponse.detail().tokenizer(), IsNull.nullValue());
        assertThat(analyzeResponse.detail().analyzer().getTokens().length, equalTo(7));  
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getPositionLength(), equalTo(1));
        token = analyzeResponse.detail().analyzer().getTokens()[5];  
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[1].getPositionLength(), equalTo(1));
        assertThat(token.getTerm(), equalTo("second"));  
            assertThat(token.getStartOffset(), equalTo(5));  
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(token.getPosition(), equalTo(3));
            .setTokenizer("keyword")
            .indices()
            .setAnalyzer("simple")
import static org.hamcrest.Matchers.equalTo;
        AnalyzeAction.Response analyzeResponse = client().admin().indices().prepareAnalyze(indexOrAlias(), "ABC").setField("keyword").get();
            .setExplain(true)  
        AnalyzeAction.Response analyzeResponse = client().admin().indices().prepareAnalyze("test", ".").get();
    }  
        }
            .prepareAnalyze()
     * Input text that doesn't produce tokens should return an empty token list
            .prepareAnalyze("THIS IS A TEST")
 */
        assertThat(token.getTerm(), equalTo("a"));
 * this file be licensed under the Apache-2.0 license or a
        assertThat(analyzeResponse.detail().analyzer(), IsNull.nullValue());
        );
            assertThat(token.getPosition(), equalTo(2));
            .setExplain(true)  
        return Collections.singleton(MockKeywordPlugin.class);  
 * software distributed under the License is distributed on an
        assertThat(analyzeResponse.detail().tokenfilters().length, equalTo(2));
    }  
            .indices()
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getTerm(), equalTo("Foo"));  
            final AnalyzeRequestBuilder requestBuilder = client().admin().indices().prepareAnalyze("THIS IS A TEST");
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[2].getTerm(), equalTo("test"));  
    public void testAnalyzerWithFieldOrTypeTests() throws Exception {  
        assertThat(token.getPositionLength(), equalTo(1));
        assertThat(analyzeResponse.detail().charfilters(), IsNull.nullValue());
            .prepareAnalyze("THIS IS A TEST")
            .indices()
            assertThat(token.getStartOffset(), equalTo(0));  
            AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(3);  
@ClusterScope(minNumDataNodes = 2)
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getPosition(), equalTo(2));
        AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(0);
        for (int i = 0; i < 10; i++) {  
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[1].getEndOffset(), equalTo(8));
import java.util.Collections;
        AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(0);  
            .setExplain(true)
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[1].getEndOffset(), equalTo(8));  
    }
        assertThat(token.getTerm(), equalTo("is"));  
            assertThat(analyzeResponse.getTokens().size(), equalTo(4));
            assertThat(response.getTokens().get(i).getTerm(), is(tokens[i]));
}
/*  
    // issue #5974
        expectThrows(
            assertThat(token.getTerm(), equalTo("a"));
            prepareCreate("test").addAlias(new Alias("alias"))
                        .put("index.analysis.normalizer.my_normalizer.type", "custom")
        String[] texts = new String[] { "THIS IS A TEST", "THE SECOND TEXT" };
        requestBuilder.setText(texts);
        // tokenfilter(lowercase)  
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getEndOffset(), equalTo(3));  
        assertThat(token.getPosition(), equalTo(3));  
        assertThat(analyzeResponse.detail().tokenfilters()[0].getName(), equalTo("lowercase"));
            IllegalArgumentException.class,  
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens()[0].getPositionLength(), equalTo(1));  
            assertThat(token.getEndOffset(), equalTo(7));
    }
            assertThat(token.getPositionLength(), equalTo(1));
            assertThat(token.getEndOffset(), equalTo(4));
        assertThat(analyzeResponse.getTokens().get(0).getEndOffset(), equalTo(9));
        assertThat(analyzeResponse.detail().tokenizer().getName(), equalTo("standard"));
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
        String[] texts = new String[] { "THIS IS A TEST", "THE SECOND TEXT" };
                    Settings.builder()  
            .setExplain(true)
        assertThat(token.getStartOffset(), equalTo(19));  
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[2].getEndOffset(), equalTo(13));
        assertThat(token.getPositionLength(), equalTo(1));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[1].getPositionLength(), equalTo(1));
 *  
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens().length, equalTo(1));  
    public void testAnalyzeNumericField() throws IOException {
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[2].getPositionLength(), equalTo(1));
        );
        assertThat(token.getStartOffset(), equalTo(0));
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getPositionLength(), equalTo(1));
            .get();  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
            .get();
            assertThat(token.getStartOffset(), equalTo(10));  
        ensureGreen();
    public void testDetailAnalyzeWithNoIndex() throws Exception {
        assertAcked(prepareCreate("test"));
    }
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        ensureGreen("test");  
            .setExplain(true)  
            .prepareAnalyze("This is troubled")  
            equalTo(new HashSet<>(Arrays.asList(expectedAttributesKey)))
            token = analyzeResponse.getTokens().get(2);
        // custom analyzer
                .setMapping("keyword", "type=keyword,normalizer=my_normalizer")
        assertThat(analyzeResponse.getTokens().get(0).getPositionLength(), equalTo(1));  
        assertTokens(response, "this", "is", "a", "test");
import org.opensearch.action.admin.indices.alias.Alias;
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getTerm(), equalTo("this is a test"));
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getTerm(), equalTo("test"));
    }
            assertThat(analyzeResponse.getTokens().size(), equalTo(4));  
        assertThat(analyzeResponse.detail().tokenizer(), IsNull.nullValue());
        analyzeResponse = client().admin()
        AnalyzeAction.Response analyzeResponse = requestBuilder.get();
        assertThat(token.getTerm(), equalTo("test"));
        for (int i = 0; i < tokens.length; i++) {
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens()[0].getTerm(), equalTo("test"));
        assertThat(token.getPositionLength(), equalTo(1));
    public void testDetailAnalyzeCustomAnalyzerWithNoIndex() throws Exception {
        assertTokens(response, "this", "is", "a", "test");
import static org.hamcrest.Matchers.hasSize;  
    public void testSimpleAnalyzerTests() throws Exception {  
            .setSource("simple", "type=text,analyzer=simple,position_increment_gap=100")
            .setText(texts)
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens()[0].getPosition(), equalTo(2));
import java.util.HashMap;  
        analyzeResponse = client().admin()  
    public void testCustomTokenFilterInRequest() throws Exception {
        AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(3);
    public void testNonExistTokenizer() {
        }
    }  
 */  
        // analyzer only
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens().length, equalTo(1));  
        assertThat(token.getTerm(), equalTo("ABC"));
            assertThat(token.getTerm(), equalTo("is"));
        assertTokens(response, "this", "is", "a", "test");
            .indices()  
                        .putList("index.analysis.normalizer.my_normalizer.filter", "lowercase")  
        ensureGreen();
        assertThat(analyzeResponse.getTokens().get(0).getTerm(), equalTo("course"));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getPositionLength(), equalTo(1));
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[1].getTerm(), equalTo("buzz"));
            IllegalArgumentException.class,
            .preparePutMapping("test")
        expectThrows(
 * the Apache License, Version 2.0 (the "License"); you may
 *
            .setExplain(true)
        token = analyzeResponse.getTokens().get(1);
        AnalyzeAction.Response analyzeResponse = client().admin()  
        client().admin()
            .indices()
            () -> client().admin().indices().prepareAnalyze(indexOrAlias(), "123").setField("long").get()
        // tokenizer  
        assertThat(analyzeResponse.detail().tokenfilters()[0].getName(), equalTo("lowercase"));
            assertThat(token.getEndOffset(), equalTo(14));
        assertThat(analyzeResponse.detail().tokenfilters().length, equalTo(1));  
        assertThat(analyzeResponse.detail().analyzer().getName(), equalTo("simple"));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getPosition(), equalTo(0));  
import static org.hamcrest.Matchers.startsWith;
        stopFilterSettings.put("stopwords", new String[] { "foo", "buzz" });
import org.hamcrest.core.IsNull;  
        assertThat(token.getPosition(), equalTo(0));
            .prepareAnalyze("THIS IS A TEST")
        assertThat(token.getTerm(), equalTo("test"));
            .prepareAnalyze()
            .setSource("simple", "type=text,analyzer=simple,position_increment_gap=100")
        stopFilterSettings.put("type", "stop");  
            AnalyzeAction.Response analyzeResponse = client().admin().indices().prepareAnalyze(indexOrAlias(), "this is a test").get();
        AnalyzeAction.Response analyzeResponse = client().admin().indices().prepareAnalyze(indexOrAlias(), "ABC").setField("keyword").get();  
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getStartOffset(), equalTo(0));
    }  
        assertAcked(  
        assertThat(token.getPosition(), equalTo(105));
 * KIND, either express or implied.  See the License for the
            requestBuilder.setIndex(indexOrAlias());
            .indices()  
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getStartOffset(), equalTo(9));
import java.util.HashSet;
        requestBuilder.setIndex(indexOrAlias());  
            .get();
        assertThat(analyzeResponse.getTokens().size(), equalTo(0));
            assertThat(token.getStartOffset(), equalTo(10));
import java.io.IOException;
            .setIndex(indexOrAlias())  
        requestBuilder.setField("simple");
            assertThat(token.getTerm(), equalTo("test"));
        assertThat(token.getTerm(), equalTo("this"));
        assertThat(analyzeResponse.detail().tokenfilters(), IsNull.nullValue());
        assertThat(analyzeResponse.getTokens().size(), equalTo(4));  
        assertThat(
        AnalyzeAction.Response analyzeResponse = client().admin()
        token = analyzeResponse.getTokens().get(5);
            .indices()  
 * The OpenSearch Contributors require contributions made to  
                .setSettings(
            assertThat(token.getStartOffset(), equalTo(8));  
        }  
        ensureGreen("test");  
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getTerm(), equalTo("THIS IS A TEST"));
        assertThat(token.getStartOffset(), equalTo(10));
        ensureGreen();
        assertThat(analyzeResponse.getTokens().size(), equalTo(7));  
        assertThat(analyzeResponse.detail().analyzer().getTokens().length, equalTo(4));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(analyzeResponse.detail().analyzer().getName(), equalTo("simple"));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[1].getPosition(), equalTo(1));  
        response = client().admin().indices().prepareAnalyze("this is a test").setAnalyzer("default").get();
 *
            assertThat(token.getTerm(), equalTo("test"));
        assertThat(analyzeResponse.detail().tokenizer().getName(), equalTo("keyword"));  
            .indices()
 * this work for additional information regarding copyright
            assertThat(token.getPositionLength(), equalTo(1));  
    }
        assertNotNull(analyzeResponse.getTokens());  
 * Unless required by applicable law or agreed to in writing,
        AnalyzeAction.Response analyzeResponse = client().admin().indices().prepareAnalyze("THIS IS A TEST").setAnalyzer("simple").get();
            token = analyzeResponse.getTokens().get(3);
        assertThat(analyzeResponse.detail().tokenizer().getTokens().length, equalTo(3));
        response = client().admin().indices().prepareAnalyze("this is a test").get();
            .preparePutMapping("test")
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[1].getStartOffset(), equalTo(4));
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping("keyword", "type=keyword"));
            () -> client().admin().indices().prepareAnalyze(indexOrAlias(), "123.0").setField("double").get()  
        token = analyzeResponse.getTokens().get(3);  
        // tokenfilters  
        token = analyzeResponse.getTokens().get(2);
            .setAnalyzer("simple")
            .addTokenFilter("lowercase")
        AnalyzeAction.Response response = client().admin().indices().prepareAnalyze("this is a test").setAnalyzer("standard").get();
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getStartOffset(), equalTo(0));
    }
    public void testAnalyzeKeywordField() throws IOException {  
        assertThat(analyzeResponse.detail().tokenfilters()[1].getName(), equalTo("__anonymous__stop"));
        Map<String, Object> stopFilterSettings = new HashMap<>();
            AnalyzeAction.Response analyzeResponse = requestBuilder.get();
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getEndOffset(), equalTo(13));  
        ensureGreen("test");
        client().admin().indices().preparePutMapping("test").setSource("simple", "type=text,analyzer=simple").get();
    public void testDetailAnalyzeWithMultiValues() throws Exception {
        assertThat(token.getPositionLength(), equalTo(1));
        // tokenfilter({"type": "stop", "stopwords": ["foo", "buzz"]})
            .addTokenFilter(stopFilterSettings)
            assertThat(token.getPositionLength(), equalTo(1));  
        IllegalArgumentException e = expectThrows(  
 * specific language governing permissions and limitations
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens().length, equalTo(3));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[2].getStartOffset(), equalTo(9));
        AnalyzeAction.AnalyzeToken token = analyzeResponse.detail().analyzer().getTokens()[3];
            .get();  
import java.util.Arrays;  
            .execute()
    /**
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .addTokenFilter("lowercase")  
        final AnalyzeRequestBuilder requestBuilder = client().admin().indices().prepareAnalyze();
    }
        analyzeResponse = client().admin()
import org.opensearch.common.settings.Settings;
    }
        ensureGreen();  
    public void testAnalyzeNormalizedKeywordField() throws IOException {
        // check other attributes  
        AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(0);  
import org.opensearch.action.admin.indices.analyze.AnalyzeRequestBuilder;  
            assertThat(token.getEndOffset(), equalTo(9));
        return randomBoolean() ? "test" : "alias";
        for (int i = 0; i < 10; i++) {
            assertThat(token.getPosition(), equalTo(1));
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getPosition(), equalTo(0));
        assertThat(analyzeResponse.detail().tokenfilters().length, equalTo(1));
            .get();
 * GitHub history for details.
        assertThat(analyzeResponse.detail().analyzer().getTokens().length, equalTo(4));  
 * under the License.  
        assertThat(token.getPosition(), equalTo(0));  
        assertThat(token.getPositionLength(), equalTo(1));
            assertThat(token.getTerm(), equalTo("this"));
            () -> client().admin().indices().prepareAnalyze("this is a test").setAnalyzer("not_exist_analyzer").get()
            assertThat(token.getPositionLength(), equalTo(1));  
        assertThat(token.getEndOffset(), equalTo(25));  
import java.util.Collection;
 */  
        AnalyzeAction.Response analyzeResponse = client().admin()  
        assertThat(analyzeResponse.getTokens().get(0).getStartOffset(), equalTo(3));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getEndOffset(), equalTo(3));
            .get();  
            assertThat(token.getEndOffset(), equalTo(14));  
    }
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[1].getTerm(), equalTo("buzz"));  
import static org.hamcrest.Matchers.is;
            AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(0);
            IllegalArgumentException.class,
            .addTokenFilter("lowercase")  
            .indices()  
        assertThat(analyzeResponse.getTokens().size(), equalTo(1));
            .setTokenizer("keyword")
                        .put(indexSettings())
        assertThat(analyzeResponse.detail().tokenizer().getTokens().length, equalTo(1));
        );
        assertThat(token.getStartOffset(), equalTo(0));
            .prepareAnalyze("THIS IS A TEST")
/*  
            requestBuilder.setField("document.simple");  
        assertThat(analyzeResponse.getTokens().size(), equalTo(1));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[2].getPosition(), equalTo(2));  
        assertThat(response.getTokens(), hasSize(tokens.length));  
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(token.getEndOffset(), equalTo(14));  
            .setText(texts)
        assertThat(e.getMessage(), startsWith("failed to find global analyzer"));
        assertThat(token.getEndOffset(), equalTo(3));
 * Licensed to Elasticsearch under one or more contributor  
        );  
            .get();  
        ensureGreen("test");
        analyzeResponse = client().admin()
        assertThat(token.getEndOffset(), equalTo(14));
        assertThat(token.getEndOffset(), equalTo(3));  
        assertThat(analyzeResponse.getTokens().get(0).getTerm(), equalTo("this is a test"));  
    @Override
        assertThat(token.getEndOffset(), equalTo(25));
        assertThat(analyzeResponse.getTokens().get(0).getPosition(), equalTo(1));  
/*
            .setField("simple")  
    private void assertTokens(AnalyzeAction.Response response, String... tokens) {
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[1].getPosition(), equalTo(1));
        analyzeResponse = client().admin().indices().prepareAnalyze("of course").setTokenizer("standard").addTokenFilter("stop").get();  
    }  
        assertThat(token.getPosition(), equalTo(105));
    public void testZeroTokenAnalysis() throws IOException {
    public void testThatStandardAndDefaultAnalyzersAreSame() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(analyzeResponse.getTokens().size(), equalTo(1));
    }
    private static String indexOrAlias() {  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping("long", "type=long", "double", "type=double"));
            .indices()  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));  
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens().length, equalTo(3));  
        assertThat(token.getTerm(), equalTo("test"));  
            .prepareAnalyze("THIS IS A TEST")  
    }
        assertThat(analyzeResponse.detail().charfilters(), IsNull.nullValue());  
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[1].getStartOffset(), equalTo(4));
            analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getAttributes().keySet(),  
        // analyzer only  
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens()[0].getEndOffset(), equalTo(13));
        assertThat(token.getPosition(), equalTo(3));
        client().admin()
        assertThat(analyzeResponse.detail().analyzer().getName(), equalTo("simple"));
        assertThat(token.getTerm(), equalTo("abc"));  
        assertThat(token.getStartOffset(), equalTo(10));
public class AnalyzeActionIT extends OpenSearchIntegTestCase {
