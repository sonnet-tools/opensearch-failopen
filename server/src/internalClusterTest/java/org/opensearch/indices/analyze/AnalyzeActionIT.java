        assertThat(token.getPosition(), equalTo(0));
        client().admin().indices().preparePutMapping("test").setSource("simple", "type=text,analyzer=simple").get();
        assertThat(token.getPositionLength(), equalTo(1));
import java.util.Collection;
 * compatible open source license.
        // tokenfilters
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getTerm(), equalTo("THIS IS A TEST"));
            .setText(texts)
            .get();
            .indices()
        ensureGreen();
/*
    public void testAnalyzerWithFieldOrTypeTests() throws Exception {
        assertThat(analyzeResponse.detail().tokenfilters().length, equalTo(2));
        assertThat(response.getTokens(), hasSize(tokens.length));
        // analyzer only
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens()[0].getEndOffset(), equalTo(13));
        assertThat(analyzeResponse.getTokens().size(), equalTo(1));
            .setTokenizer("keyword")
    }
     */
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[1].getPositionLength(), equalTo(1));
    }
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[2].getTerm(), equalTo("test"));
        AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(0);
        assertThat(analyzeResponse.getTokens().get(0).getTerm(), equalTo("course"));
        assertThat(analyzeResponse.detail().tokenfilters(), IsNull.nullValue());
            .indices()
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[1].getStartOffset(), equalTo(4));
        AnalyzeAction.Response response = client().admin().indices().prepareAnalyze("this is a test").setAnalyzer("standard").get();
        token = analyzeResponse.getTokens().get(2);
 * this file be licensed under the Apache-2.0 license or a
            assertThat(token.getPositionLength(), equalTo(1));
            .setExplain(true)
 * software distributed under the License is distributed on an
    }
        }
    // issue #5974
        assertThat(token.getPosition(), equalTo(3));
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.MockKeywordPlugin;
        assertThat(analyzeResponse.detail().analyzer().getName(), equalTo("simple"));
        assertThat(analyzeResponse.detail().analyzer(), IsNull.nullValue());
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[1].getEndOffset(), equalTo(8));
    public void testCustomTokenFilterInRequest() throws Exception {
        assertThat(analyzeResponse.detail().analyzer().getName(), equalTo("simple"));
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens()[0].getPosition(), equalTo(2));
    public void testDetailAnalyzeCustomAnalyzerWithNoIndex() throws Exception {
            IllegalArgumentException.class,
            assertThat(token.getPositionLength(), equalTo(1));
        assertThat(analyzeResponse.detail().tokenfilters().length, equalTo(1));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[2].getPositionLength(), equalTo(1));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getPosition(), equalTo(0));
    @Override
        // tokenfilter({"type": "stop", "stopwords": ["foo", "buzz"]})
        );
    }
            assertThat(token.getStartOffset(), equalTo(5));
import org.opensearch.common.settings.Settings;
        analyzeResponse = client().admin().indices().prepareAnalyze("of course").setTokenizer("standard").addTokenFilter("stop").get();
        assertThat(analyzeResponse.detail().tokenizer(), IsNull.nullValue());
            .get();
import static org.hamcrest.Matchers.startsWith;
    }
            .get();
        IllegalArgumentException e = expectThrows(
import org.opensearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
        assertThat(token.getTerm(), equalTo("test"));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getStartOffset(), equalTo(0));
import org.opensearch.plugins.Plugin;
            .setTokenizer("keyword")
        ensureGreen();
            .prepareAnalyze()
        assertThat(token.getEndOffset(), equalTo(14));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[2].getStartOffset(), equalTo(9));
            AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(0);
        expectThrows(
        assertThat(token.getPosition(), equalTo(105));
        assertThat(token.getTerm(), equalTo("test"));
        assertTokens(response, "this", "is", "a", "test");
 * specific language governing permissions and limitations
            .addTokenFilter("lowercase")
        AnalyzeAction.Response analyzeResponse = client().admin().indices().prepareAnalyze(indexOrAlias(), "ABC").setField("keyword").get();
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getPositionLength(), equalTo(1));
        assertThat(token.getPosition(), equalTo(105));
        assertThat(analyzeResponse.detail().tokenfilters()[0].getName(), equalTo("lowercase"));
        for (int i = 0; i < 10; i++) {
    }
        client().admin()
            .setText("Foo buzz test")
        stopFilterSettings.put("stopwords", new String[] { "foo", "buzz" });
        assertThat(analyzeResponse.detail().charfilters(), IsNull.nullValue());
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens().length, equalTo(1));
            assertThat(token.getEndOffset(), equalTo(4));
            .setTokenizer("standard")
            .get();
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(token.getStartOffset(), equalTo(10));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[1].getEndOffset(), equalTo(8));
        assertThat(analyzeResponse.detail().charfilters(), IsNull.nullValue());
        for (int i = 0; i < tokens.length; i++) {
            .prepareAnalyze("THIS IS A TEST")
    public void testAnalyzeWithNoIndex() throws Exception {
import java.io.IOException;
        assertThat(token.getStartOffset(), equalTo(19));
            .get();
        assertThat(analyzeResponse.getTokens().size(), equalTo(1));
    }
            .setSource("simple", "type=text,analyzer=simple,position_increment_gap=100")
 * The OpenSearch Contributors require contributions made to
 * KIND, either express or implied.  See the License for the
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens().length, equalTo(3));
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getStartOffset(), equalTo(9));
 * SPDX-License-Identifier: Apache-2.0
    }
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getPositionLength(), equalTo(1));
        analyzeResponse = client().admin()
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens()[0].getPositionLength(), equalTo(1));
            assertThat(token.getTerm(), equalTo("this"));
        AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(0);
    }
import org.opensearch.action.admin.indices.alias.Alias;
        // check other attributes
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[1].getPosition(), equalTo(1));
        ensureGreen("test");
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
        response = client().admin().indices().prepareAnalyze("this is a test").get();
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[1].getTerm(), equalTo("buzz"));
            assertThat(token.getEndOffset(), equalTo(7));
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens()[0].getStartOffset(), equalTo(9));
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens().length, equalTo(1));
        analyzeResponse = client().admin()
        response = client().admin().indices().prepareAnalyze("this is a test").setAnalyzer("default").get();
        ensureGreen("test");
        }
            .setExplain(true)
        AnalyzeAction.Response analyzeResponse = client().admin().indices().prepareAnalyze(indexOrAlias(), "ABC").setField("keyword").get();
        AnalyzeAction.Response analyzeResponse = client().admin()
import static org.hamcrest.Matchers.hasSize;
import java.util.Map;
import java.util.Collections;
        assertThat(analyzeResponse.detail().analyzer().getName(), equalTo("simple"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .get();
        assertThat(token.getTerm(), equalTo("is"));
        assertThat(
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getTerm(), equalTo("this is a test"));
            .addTokenFilter("lowercase")
            .execute()
            .prepareAnalyze("THIS IS A TEST")
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getTerm(), equalTo("Foo"));
        assertThat(token.getPositionLength(), equalTo(1));
        AnalyzeAction.Response analyzeResponse = client().admin()
        String[] expectedAttributesKey = { "bytes", "termFrequency", "positionLength" };
 * Unless required by applicable law or agreed to in writing,
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[1].getStartOffset(), equalTo(4));
        assertThat(analyzeResponse.getTokens().size(), equalTo(7));
            assertThat(token.getStartOffset(), equalTo(0));
        assertThat(analyzeResponse.getTokens().size(), equalTo(1));
        assertNotNull(analyzeResponse.getTokens());
 * not use this file except in compliance with the License.
        assertThat(analyzeResponse.getTokens().size(), equalTo(0));
        ensureGreen();
    }
            equalTo(new HashSet<>(Arrays.asList(expectedAttributesKey)))
    private void assertTokens(AnalyzeAction.Response response, String... tokens) {
        return randomBoolean() ? "test" : "alias";
                .setMapping("keyword", "type=keyword,normalizer=my_normalizer")
            .addTokenFilter("lowercase")
        assertThat(token.getPosition(), equalTo(0));
    public void testAnalyzeKeywordField() throws IOException {
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getTerm(), equalTo("troubled"));
            .indices()
        assertThat(analyzeResponse.getTokens().get(0).getEndOffset(), equalTo(9));
        assertThat(analyzeResponse.detail().tokenfilters().length, equalTo(1));
            assertThat(token.getTerm(), equalTo("is"));
        assertThat(token.getEndOffset(), equalTo(25));
    public void testDetailAnalyzeWithNoIndex() throws Exception {
public class AnalyzeActionIT extends OpenSearchIntegTestCase {
/*
        assertThat(token.getPosition(), equalTo(3));
        assertThat(token.getPositionLength(), equalTo(1));
            assertThat(token.getEndOffset(), equalTo(9));
    }
 * You may obtain a copy of the License at
        AnalyzeAction.Response analyzeResponse = client().admin().indices().prepareAnalyze("THIS IS A TEST").setAnalyzer("simple").get();
        AnalyzeAction.Response analyzeResponse = client().admin()
        assertAcked(
        );
        assertThat(analyzeResponse.detail().tokenfilters(), IsNull.nullValue());
        AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(3);
        analyzeResponse = client().admin()
 *    http://www.apache.org/licenses/LICENSE-2.0
            .indices()
import java.util.HashMap;
        assertThat(analyzeResponse.detail().tokenizer().getTokens().length, equalTo(1));
            .get();
        assertThat(analyzeResponse.detail().tokenfilters()[1].getName(), equalTo("__anonymous__stop"));
        Map<String, Object> stopFilterSettings = new HashMap<>();
            AnalyzeAction.Response analyzeResponse = requestBuilder.get();
            .preparePutMapping("test")
                        .putList("index.analysis.normalizer.my_normalizer.filter", "lowercase")
 */
            assertThat(token.getStartOffset(), equalTo(8));
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getEndOffset(), equalTo(13));
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getTerm(), equalTo("foo"));
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getPosition(), equalTo(0));
            assertThat(token.getPosition(), equalTo(2));
        // tokenfilter(lowercase)
        assertThat(token.getPositionLength(), equalTo(1));
            assertThat(analyzeResponse.getTokens().size(), equalTo(4));
 * Modifications Copyright OpenSearch Contributors. See
 *
        expectThrows(
            .setExplain(true)
        token = analyzeResponse.getTokens().get(3);
 *
        stopFilterSettings.put("type", "stop");
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens().length, equalTo(3));
            .setTokenizer("standard")
        assertThat(token.getPositionLength(), equalTo(1));
        assertThat(analyzeResponse.getTokens().size(), equalTo(4));
            assertThat(analyzeResponse.getTokens().size(), equalTo(4));
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(analyzeResponse.getTokens().size(), equalTo(4));
    /**
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getTerm(), equalTo("test"));
        // tokenizer
            assertThat(token.getPosition(), equalTo(1));
        );
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[2].getEndOffset(), equalTo(13));
    public void testAnalyzeNumericField() throws IOException {
            assertThat(token.getStartOffset(), equalTo(10));
        ensureGreen("test");
            .addTokenFilter("lowercase")
            .prepareAnalyze("THIS IS A TEST")
        ensureGreen("test");
        assertThat(token.getPositionLength(), equalTo(1));
/*
            IllegalArgumentException.class,
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getPosition(), equalTo(2));
            .addTokenFilter(stopFilterSettings)
 */
 * Licensed to Elasticsearch under one or more contributor
            analyzeResponse.detail().tokenfilters()[0].getTokens()[2].getAttributes().keySet(),
            assertThat(token.getPositionLength(), equalTo(1));
import java.util.HashSet;
        assertThat(token.getStartOffset(), equalTo(0));
            .setText(texts)
        assertThat(analyzeResponse.getTokens().get(0).getPosition(), equalTo(1));
        assertThat(analyzeResponse.detail().tokenfilters()[1].getTokens()[0].getTerm(), equalTo("test"));
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
        assertThat(token.getTerm(), equalTo("second"));
        assertThat(token.getTerm(), equalTo("ABC"));
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[1].getPositionLength(), equalTo(1));
            requestBuilder.setField("document.simple");
        assertTokens(response, "this", "is", "a", "test");
            .prepareAnalyze()
                )
            .addTokenFilter("lowercase")
    public void testAnalyzeNormalizedKeywordField() throws IOException {
            token = analyzeResponse.getTokens().get(1);
    public void testSimpleAnalyzerTests() throws Exception {
    }
            prepareCreate("test").addAlias(new Alias("alias"))
        assertThat(token.getStartOffset(), equalTo(10));
        }
            .setAnalyzer("simple")
import static org.hamcrest.Matchers.is;
        assertThat(analyzeResponse.detail().tokenfilters()[0].getName(), equalTo("lowercase"));
    }
package org.opensearch.indices.analyze;
        token = analyzeResponse.getTokens().get(5);
            requestBuilder.setIndex(indexOrAlias());
                        .put(indexSettings())
     * Input text that doesn't produce tokens should return an empty token list
        assertThat(token.getTerm(), equalTo("second"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(e.getMessage(), startsWith("failed to find global analyzer"));
            .setField("simple")
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
        assertThat(token.getStartOffset(), equalTo(0));
            () -> client().admin().indices().prepareAnalyze("this is a test").setAnalyzer("not_exist_analyzer").get()
}
        assertThat(token.getTerm(), equalTo("a"));
        return Collections.singleton(MockKeywordPlugin.class);
            .prepareAnalyze("THIS IS A TEST")
        assertThat(token.getTerm(), equalTo("abc"));
        assertThat(analyzeResponse.detail().tokenizer().getTokens().length, equalTo(3));
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[2].getPosition(), equalTo(2));
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
        assertAcked(prepareCreate("test"));
        for (int i = 0; i < 10; i++) {
            .setExplain(true)
    public void testAnalyzerWithMultiValues() throws Exception {
        assertThat(analyzeResponse.getTokens().get(0).getStartOffset(), equalTo(3));
        assertThat(token.getEndOffset(), equalTo(14));
        );
        AnalyzeAction.Response analyzeResponse = requestBuilder.get();
 * GitHub history for details.
        client().admin()
            assertThat(token.getEndOffset(), equalTo(14));
        String[] texts = new String[] { "THIS IS A TEST", "THE SECOND TEXT" };
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping("long", "type=long", "double", "type=double"));
            assertThat(token.getPosition(), equalTo(3));
import org.opensearch.action.admin.indices.analyze.AnalyzeAction;
        assertThat(analyzeResponse.detail().analyzer().getTokens().length, equalTo(4));
        assertThat(analyzeResponse.detail().tokenizer(), IsNull.nullValue());
            .prepareAnalyze("This is troubled")
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getPositionLength(), equalTo(1));
        requestBuilder.setIndex(indexOrAlias());
        AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(0);
        assertThat(token.getTerm(), equalTo("this"));
            token = analyzeResponse.getTokens().get(2);
        // custom analyzer
        token = analyzeResponse.detail().analyzer().getTokens()[5];
            .indices()
            assertThat(token.getPositionLength(), equalTo(1));
 * ownership. Elasticsearch licenses this file to you under
        assertThat(analyzeResponse.getTokens().size(), equalTo(1));
            assertThat(token.getPosition(), equalTo(0));
    }
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[1].getPosition(), equalTo(1));
            () -> client().admin().indices().prepareAnalyze(indexOrAlias(), "123").setField("long").get()
        requestBuilder.setField("simple");
        AnalyzeAction.Response analyzeResponse = client().admin()
                    Settings.builder()
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[1].getTerm(), equalTo("buzz"));
        // tokenizer
            .prepareAnalyze("THIS IS A TEST")
    public void testDetailAnalyzeWithMultiValues() throws Exception {
            .indices()
            token = analyzeResponse.getTokens().get(3);
            final AnalyzeRequestBuilder requestBuilder = client().admin().indices().prepareAnalyze("THIS IS A TEST");
            .setAnalyzer("simple")
    }
 */
        assertThat(token.getEndOffset(), equalTo(3));
        String[] texts = new String[] { "THIS IS A TEST", "THE SECOND TEXT" };
        assertThat(analyzeResponse.detail().analyzer().getTokens().length, equalTo(7));
            AnalyzeAction.Response analyzeResponse = client().admin().indices().prepareAnalyze(indexOrAlias(), "this is a test").get();
            .indices()
            .indices()
        assertThat(token.getEndOffset(), equalTo(25));
import org.hamcrest.core.IsNull;
        assertThat(analyzeResponse.detail().tokenizer().getName(), equalTo("standard"));
            assertThat(token.getPositionLength(), equalTo(1));
            .setSource("simple", "type=text,analyzer=simple,position_increment_gap=100")
        ensureGreen();
 * this work for additional information regarding copyright
        assertThat(token.getTerm(), equalTo("test"));
    }
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
        assertThat(analyzeResponse.detail().tokenizer().getName(), equalTo("keyword"));
        assertThat(analyzeResponse.getTokens().get(0).getTerm(), equalTo("this is a test"));
        // analyzer only
        assertTokens(response, "this", "is", "a", "test");
    }
    private static String indexOrAlias() {
        assertThat(analyzeResponse.detail().tokenfilters()[0].getName(), equalTo("lowercase"));
            .setTokenizer("standard")
            () -> client().admin().indices().prepareAnalyze(indexOrAlias(), "123.0").setField("double").get()
        assertThat(token.getEndOffset(), equalTo(3));
import java.util.Arrays;
            .indices()
        token = analyzeResponse.getTokens().get(1);
            assertThat(token.getTerm(), equalTo("test"));
 * under the License.
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getEndOffset(), equalTo(3));
            .indices()
@ClusterScope(minNumDataNodes = 2)
        final AnalyzeRequestBuilder requestBuilder = client().admin().indices().prepareAnalyze();
                .setSettings(
    public void testZeroTokenAnalysis() throws IOException {
            .setExplain(true)
                        .put("index.analysis.normalizer.my_normalizer.type", "custom")
        );
            IllegalArgumentException.class,
        assertThat(analyzeResponse.detail().tokenizer().getTokens()[0].getEndOffset(), equalTo(3));
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setMapping("keyword", "type=keyword"));
        analyzeResponse = client().admin()
        assertThat(analyzeResponse.getTokens().get(0).getPositionLength(), equalTo(1));
            assertThat(response.getTokens().get(i).getTerm(), is(tokens[i]));
    public void testThatStandardAndDefaultAnalyzersAreSame() throws Exception {
        assertThat(token.getStartOffset(), equalTo(10));
    public void testNonExistTokenizer() {
        assertThat(analyzeResponse.detail().analyzer().getTokens().length, equalTo(4));
            assertThat(token.getTerm(), equalTo("test"));
            .get();
            AnalyzeAction.AnalyzeToken token = analyzeResponse.getTokens().get(3);
import static org.hamcrest.Matchers.equalTo;
        AnalyzeAction.AnalyzeToken token = analyzeResponse.detail().analyzer().getTokens()[3];
            assertThat(token.getTerm(), equalTo("a"));
        assertThat(token.getStartOffset(), equalTo(19));
        assertThat(analyzeResponse.detail().tokenfilters()[0].getTokens()[0].getStartOffset(), equalTo(0));
            .setExplain(true)
            assertThat(token.getEndOffset(), equalTo(14));
        requestBuilder.setText(texts);
            .preparePutMapping("test")
            .get();
        AnalyzeAction.Response analyzeResponse = client().admin().indices().prepareAnalyze("test", ".").get();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *
            .get();
            .setIndex(indexOrAlias())
