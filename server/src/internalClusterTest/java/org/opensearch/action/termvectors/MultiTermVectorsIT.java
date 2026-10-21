        checkTermTexts(response.getResponses()[2].getResponse().getFields().terms("field"), new String[] { "value2" });
        assertThat(response.getResponses().length, equalTo(3));
 * KIND, either express or implied.  See the License for the
        assertThat(response.getResponses()[1].getFailure().getId(), equalTo("2"));
        assertThat(response.getResponses()[1].getResponse().isExists(), equalTo(true));
import org.apache.lucene.index.Terms;
 * Unless required by applicable law or agreed to in writing,
        for (AbstractTermVectorsTestCase.TestConfig test : testConfigs) {
    public void testMultiTermVectorsWithVersion() throws Exception {
            validateResponse(item.getResponse(), luceneTermVectors, test);
        assertThat(response.getResponses()[2].getFailure().getId(), equalTo("1"));
        assertThat(response.getResponses()[2].getFailure(), notNullValue());
        assertThat(response.getResponses()[1].getFailure().getId(), equalTo("2"));
 *
        DirectoryReader directoryReader = indexDocsWithLucene(testDocs);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.lucene.uid.Versions;
        MultiTermVectorsRequestBuilder mtvBuilder = client().prepareMultiTermVectors();
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
            } else if (item.isFailed()) {
        AbstractTermVectorsTestCase.TestFieldSetting[] testFieldSettings = getFieldSettings();
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).get();
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(false));
        assertThat(response.getResponses().length, equalTo(3));
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(1).realtime(false))
        // Version from Lucene index
    private static String indexOrAlias() {
        for (int i = 0; i < 3; i++) {
        // [0] version doesn't matter, which is the default
        for (int i = 0; i < testConfigs.length; i++) {
        // [0] version doesn't matter, which is the default
 * GitHub history for details.
            .get();
        assertThat(response.getResponses()[1].getFailure(), notNullValue());
        assertThat(response.getResponses()[2].getFailure().getCause().getCause(), instanceOf(VersionConflictEngineException.class));
public class MultiTermVectorsIT extends AbstractTermVectorsTestCase {
        // Version from Lucene index
import org.opensearch.OpenSearchException;
        assertThat(response.getResponses()[1].getId(), equalTo("1"));
    public MultiTermVectorsIT(Settings staticSettings) {
        checkTermTexts(response.getResponses()[1].getResponse().getFields().terms("field"), new String[] { "value1" });
import static org.hamcrest.Matchers.equalTo;
        checkTermTexts(response.getResponses()[2].getResponse().getFields().terms("field"), new String[] { "value2" });
    }
/*
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(2).realtime(false))
    }
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.index.IndexNotFoundException;
        assertThat(response.getResponses().length, equalTo(3));
        // Version from translog
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(Versions.MATCH_ANY))
        assertThat(response.getResponses()[2].getResponse().isExists(), equalTo(true));
        checkTermTexts(response.getResponses()[0].getResponse().getFields().terms("field"), new String[] { "value1" });
        return randomBoolean() ? "test" : "alias";
 *
                continue;
        super(staticSettings);
        mtvBuilder.add(requestBuilder.request());
        }
            .get();
 * not use this file except in compliance with the License.
            if (test.expectedException != null) {
 * this work for additional information regarding copyright
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(Settings.builder().put("index.refresh_interval", -1)));
        response = client().prepareMultiTermVectors()
        assertThat(response.getResponses()[2].getIndex(), equalTo("test"));
        checkTermTexts(response.getResponses()[0].getResponse().getFields().terms("field"), new String[] { "value1" });
        assertThat(response.getResponses()[1].getFailure().getCause(), instanceOf(OpenSearchException.class));
        }
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(Versions.MATCH_ANY).realtime(false))
            TestConfig test = testConfigs[i];
    public void testDuelESLucene() throws Exception {
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
        for (int i = 0; i < 3; i++) {
        for (String expectedText : expectedTexts) {
        }
 * ownership. Elasticsearch licenses this file to you under
        assertThat(response.getResponses()[2].getIndex(), equalTo("test"));
        }
        response = client().prepareMultiTermVectors()
        assertThat(response.getResponses()[1].getFailure().getCause().getCause(), instanceOf(VersionConflictEngineException.class));
}
            assertThat(termsEnum.next().utf8ToString(), equalTo(expectedText));
        response = client().prepareMultiTermVectors()
        }
        assertThat(response.getResponses().length, equalTo(1));
        MultiTermVectorsResponse response = client().prepareMultiTermVectors().add(indexOrAlias(), "1").get();
        MultiTermVectorsRequestBuilder requestBuilder = client().prepareMultiTermVectors();
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(response.getResponses()[0].getFailure(), nullValue());
        // we generate as many docs as many shards we have
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
        assertThat(response.getResponses()[0].getFailure().getCause(), instanceOf(IndexNotFoundException.class));
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
package org.opensearch.action.termvectors;
        assertThat(response.getResponses()[2].getFailure().getCause(), instanceOf(OpenSearchException.class));
        assertThat(response.getResponses()[0].getId(), equalTo("1"));
        assertThat(response.getResponses()[0].getFailure(), nullValue());
    private void checkTermTexts(Terms terms, String[] expectedTexts) throws IOException {
        assertThat(response.getResponses()[1].getFailure().getCause(), instanceOf(OpenSearchException.class));
        assertThat(response.getResponses()[2].getId(), equalTo("2"));
    }
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(1))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // [0] version doesn't matter, which is the default
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(2))
        assertThat(response.getResponses()[1].getFailure().getCause().getCause(), instanceOf(VersionConflictEngineException.class));
 * The OpenSearch Contributors require contributions made to
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));
 * license agreements. See the NOTICE file distributed with
        assertThat(response.getResponses()[2].getResponse().isExists(), equalTo(true));
            MultiTermVectorsItemResponse item = responseItems[i];
        assertThat(response.getResponses()[1].getResponse().isExists(), equalTo(true));
        assertThat(response.getResponses()[0].getFailure().getCause().getMessage(), equalTo("no such index [testX]"));
        TestDoc[] testDocs = generateTestDocs("test", testFieldSettings);
import org.opensearch.index.engine.VersionConflictEngineException;
        assertThat(response.getResponses()[0].getId(), equalTo("2"));
        assertThat(response.getResponses()[2].getFailure(), nullValue());
                assertTrue(item.isFailed());
                fail(item.getFailure().getCause().getMessage());
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(2))
        checkTermTexts(response.getResponses()[1].getResponse().getFields().terms("field"), new String[] { "value1" });
        assertThat(response.getResponses()[1].getFailure(), nullValue());
    }
        TermVectorsRequestBuilder requestBuilder = client().prepareTermVectors("testX", Integer.toString(1));
import org.apache.lucene.index.TermsEnum;
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(Versions.MATCH_ANY))
 * Licensed to Elasticsearch under one or more contributor
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(1))
        assertThat(response.getResponses()[0].getId(), equalTo("2"));
        assertThat(response.getResponses().length, equalTo(3));
        assertThat(response.getResponses()[2].getFailure(), nullValue());
        refresh();
 * under the License.
 * You may obtain a copy of the License at
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
        // [0] version doesn't matter, which is the default
 * specific language governing permissions and limitations
 */
        MultiTermVectorsResponse response = mtvBuilder.execute().actionGet();
        assertThat(response.getResponses()[2].getFailure(), notNullValue());
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));
        refresh();
        assertThat(response.getResponses()[2].getFailure().getId(), equalTo("1"));
        assertThat(response.getResponses()[2].getId(), equalTo("2"));
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));
        assertThat(response.getResponses()[0].getFailure(), nullValue());
import static org.hamcrest.Matchers.notNullValue;
import java.io.IOException;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(Versions.MATCH_ANY))
import org.opensearch.common.settings.Settings;
 * Modifications Copyright OpenSearch Contributors. See
    }
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(response.getResponses()[1].getId(), equalTo("1"));
        createIndexBasedOnFieldSettings("test", "alias", testFieldSettings);
        checkTermTexts(response.getResponses()[0].getResponse().getFields().terms("field"), new String[] { "value2" });
 * compatible open source license.
import org.apache.lucene.index.DirectoryReader;
/*
import org.opensearch.action.admin.indices.alias.Alias;
            Fields luceneTermVectors = getTermVectorsFromLucene(directoryReader, test.doc);
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(1))
/*
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).get();
        assertThat(response.getResponses()[1].getFailure(), nullValue());
        AbstractTermVectorsTestCase.TestConfig[] testConfigs = generateTestConfigs(20, testDocs, testFieldSettings);
        assertThat(response.getResponses()[0].getFailure(), nullValue());
 */
        response = client().prepareMultiTermVectors()
        ensureGreen();
        assertThat(response.getResponses()[2].getFailure().getCause(), instanceOf(OpenSearchException.class));
            .get();
        MultiTermVectorsItemResponse[] responseItems = requestBuilder.get().getResponses();
            .get();
        assertThat(response.getResponses()[0].getId(), equalTo("1"));
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
import static org.hamcrest.Matchers.instanceOf;
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(2))
            requestBuilder.add(getRequestForConfig(test).request());
        assertThat(response.getResponses().length, equalTo(1));
import org.apache.lucene.index.Fields;
        // Version from translog
            }
 */
        final TermsEnum termsEnum = terms.iterator();
 *
    public void testMissingIndexThrowsMissingIndex() throws Exception {
        assertThat(response.getResponses()[2].getFailure().getCause().getCause(), instanceOf(VersionConflictEngineException.class));
        assertThat(response.getResponses()[1].getFailure(), notNullValue());
    }
        checkTermTexts(response.getResponses()[0].getResponse().getFields().terms("field"), new String[] { "value2" });
