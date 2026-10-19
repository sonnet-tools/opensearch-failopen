    }
        assertThat(response.getResponses().length, equalTo(3));  
        assertThat(response.getResponses()[0].getId(), equalTo("1"));
        // Version from Lucene index  
        response = client().prepareMultiTermVectors()
        assertThat(response.getResponses().length, equalTo(3));
        assertThat(response.getResponses()[2].getFailure().getCause().getCause(), instanceOf(VersionConflictEngineException.class));
        assertThat(response.getResponses()[1].getId(), equalTo("1"));  
 */  
            TestConfig test = testConfigs[i];  
        assertThat(response.getResponses().length, equalTo(3));
        assertThat(response.getResponses()[2].getResponse().isExists(), equalTo(true));
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(2))
 * Unless required by applicable law or agreed to in writing,
        assertThat(response.getResponses().length, equalTo(1));  
        assertThat(response.getResponses()[2].getIndex(), equalTo("test"));
    }  
        }
        for (int i = 0; i < 3; i++) {
            .get();
        assertThat(response.getResponses()[2].getFailure().getId(), equalTo("1"));  
        // Version from translog
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(Versions.MATCH_ANY))
                assertTrue(item.isFailed());  
            requestBuilder.add(getRequestForConfig(test).request());  
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
        assertThat(response.getResponses()[1].getFailure().getId(), equalTo("2"));  
 *
        assertThat(response.getResponses()[1].getResponse().isExists(), equalTo(true));
            .get();  
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.index.Fields;
 * compatible open source license.
        // [0] version doesn't matter, which is the default
        for (String expectedText : expectedTexts) {
        assertThat(response.getResponses()[0].getId(), equalTo("2"));  
import org.opensearch.common.lucene.uid.Versions;
        }  
        mtvBuilder.add(requestBuilder.request());
        assertThat(response.getResponses()[2].getId(), equalTo("2"));  
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));  
/*  
        return randomBoolean() ? "test" : "alias";  
}  
        DirectoryReader directoryReader = indexDocsWithLucene(testDocs);
 * software distributed under the License is distributed on an
        assertThat(response.getResponses()[2].getResponse().isExists(), equalTo(true));  
            MultiTermVectorsItemResponse item = responseItems[i];
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(2).realtime(false))  
    private static String indexOrAlias() {
        assertThat(response.getResponses()[1].getResponse().isExists(), equalTo(true));  
        assertThat(response.getResponses()[1].getFailure(), nullValue());
        checkTermTexts(response.getResponses()[1].getResponse().getFields().terms("field"), new String[] { "value1" });
            Fields luceneTermVectors = getTermVectorsFromLucene(directoryReader, test.doc);
        assertThat(response.getResponses()[2].getFailure().getCause(), instanceOf(OpenSearchException.class));
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(Versions.MATCH_ANY))  
        assertThat(response.getResponses()[1].getFailure().getCause().getCause(), instanceOf(VersionConflictEngineException.class));
    public MultiTermVectorsIT(Settings staticSettings) {  
        assertThat(response.getResponses()[2].getFailure(), notNullValue());
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(1))
 *
 * SPDX-License-Identifier: Apache-2.0
        createIndexBasedOnFieldSettings("test", "alias", testFieldSettings);  
        // Version from translog  
 * You may obtain a copy of the License at  
        TermVectorsRequestBuilder requestBuilder = client().prepareTermVectors("testX", Integer.toString(1));
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(response.getResponses()[1].getFailure().getCause(), instanceOf(OpenSearchException.class));
    public void testMissingIndexThrowsMissingIndex() throws Exception {
            if (test.expectedException != null) {
        MultiTermVectorsItemResponse[] responseItems = requestBuilder.get().getResponses();  
        assertThat(response.getResponses()[1].getId(), equalTo("1"));
        // [0] version doesn't matter, which is the default  
        // [0] version doesn't matter, which is the default
        assertThat(response.getResponses()[2].getFailure(), notNullValue());  
        assertThat(response.getResponses()[1].getFailure().getCause(), instanceOf(OpenSearchException.class));
import org.opensearch.index.IndexNotFoundException;  
        response = client().prepareMultiTermVectors()  
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));  
        refresh();
 * GitHub history for details.
 * not use this file except in compliance with the License.
        assertThat(response.getResponses()[2].getFailure(), nullValue());
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(Versions.MATCH_ANY))
 * under the License.  
 */  
        checkTermTexts(response.getResponses()[0].getResponse().getFields().terms("field"), new String[] { "value1" });
 * Modifications Copyright OpenSearch Contributors. See
        }
        assertThat(response.getResponses()[0].getFailure().getCause(), instanceOf(IndexNotFoundException.class));
import org.opensearch.common.settings.Settings;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // Version from Lucene index
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(Versions.MATCH_ANY).realtime(false))
    public void testDuelESLucene() throws Exception {
        assertThat(response.getResponses()[1].getFailure().getId(), equalTo("2"));
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(false));
        assertThat(response.getResponses()[1].getFailure(), notNullValue());
        checkTermTexts(response.getResponses()[1].getResponse().getFields().terms("field"), new String[] { "value1" });
public class MultiTermVectorsIT extends AbstractTermVectorsTestCase {
    }
        for (int i = 0; i < testConfigs.length; i++) {
import org.opensearch.index.engine.VersionConflictEngineException;
        assertThat(response.getResponses()[0].getFailure(), nullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
        AbstractTermVectorsTestCase.TestFieldSetting[] testFieldSettings = getFieldSettings();
        MultiTermVectorsRequestBuilder requestBuilder = client().prepareMultiTermVectors();
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(2))  
        response = client().prepareMultiTermVectors()
import org.opensearch.OpenSearchException;
import java.io.IOException;  
        MultiTermVectorsResponse response = client().prepareMultiTermVectors().add(indexOrAlias(), "1").get();  
        assertThat(response.getResponses()[2].getFailure().getCause().getCause(), instanceOf(VersionConflictEngineException.class));  
        assertThat(response.getResponses()[0].getId(), equalTo("2"));
        assertThat(response.getResponses()[0].getId(), equalTo("1"));
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));
        checkTermTexts(response.getResponses()[0].getResponse().getFields().terms("field"), new String[] { "value2" });  
/*  
                continue;
        super(staticSettings);
        assertThat(response.getResponses()[1].getFailure(), nullValue());  
 */
        assertThat(response.getResponses()[2].getFailure().getCause(), instanceOf(OpenSearchException.class));
 * this file be licensed under the Apache-2.0 license or a
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(2))
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(1))  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));
        response = client().prepareMultiTermVectors()  
    }
 * specific language governing permissions and limitations
        MultiTermVectorsResponse response = mtvBuilder.execute().actionGet();
import static org.hamcrest.Matchers.instanceOf;
 * this work for additional information regarding copyright
    }  
        assertThat(response.getResponses().length, equalTo(3));
import static org.hamcrest.Matchers.notNullValue;
 * The OpenSearch Contributors require contributions made to  
        assertThat(response.getResponses()[0].getFailure(), nullValue());  
        for (int i = 0; i < 3; i++) {
        assertThat(response.getResponses()[1].getIndex(), equalTo("test"));
import static org.hamcrest.Matchers.equalTo;  
        assertThat(response.getResponses()[0].getFailure(), nullValue());
        assertThat(response.getResponses()[2].getFailure(), nullValue());  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")).setSettings(Settings.builder().put("index.refresh_interval", -1)));  
package org.opensearch.action.termvectors;
        assertThat(response.getResponses().length, equalTo(1));
import org.apache.lucene.index.Terms;  
            validateResponse(item.getResponse(), luceneTermVectors, test);  
        assertThat(response.getResponses()[2].getFailure().getId(), equalTo("1"));
        checkTermTexts(response.getResponses()[2].getResponse().getFields().terms("field"), new String[] { "value2" });
        assertThat(response.getResponses()[0].getIndex(), equalTo("test"));  
                fail(item.getFailure().getCause().getMessage());  
/*
            }
 *  
    private void checkTermTexts(Terms terms, String[] expectedTexts) throws IOException {  
        assertThat(response.getResponses()[2].getId(), equalTo("2"));
import org.opensearch.action.admin.indices.alias.Alias;  
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).get();
import org.apache.lucene.index.DirectoryReader;
    public void testMultiTermVectorsWithVersion() throws Exception {
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value" + i).get();  
        }
            } else if (item.isFailed()) {
        assertThat(response.getResponses()[2].getIndex(), equalTo("test"));
 * KIND, either express or implied.  See the License for the
        // [0] version doesn't matter, which is the default  
        checkTermTexts(response.getResponses()[2].getResponse().getFields().terms("field"), new String[] { "value2" });
        final TermsEnum termsEnum = terms.iterator();
            assertThat(termsEnum.next().utf8ToString(), equalTo(expectedText));  
        AbstractTermVectorsTestCase.TestConfig[] testConfigs = generateTestConfigs(20, testDocs, testFieldSettings);
        assertThat(response.getResponses()[1].getFailure(), notNullValue());
        TestDoc[] testDocs = generateTestDocs("test", testFieldSettings);
        ensureGreen();
        checkTermTexts(response.getResponses()[0].getResponse().getFields().terms("field"), new String[] { "value1" });
import static org.hamcrest.Matchers.nullValue;  
 * license agreements. See the NOTICE file distributed with
        MultiTermVectorsRequestBuilder mtvBuilder = client().prepareMultiTermVectors();  
    }
        // we generate as many docs as many shards we have
        }
        assertThat(response.getResponses()[0].getFailure(), nullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(response.getResponses()[0].getFailure().getCause().getMessage(), equalTo("no such index [testX]"));
            .get();
        refresh();
            .add(new TermVectorsRequest(indexOrAlias(), "2").selectedFields("field").version(1))
        assertThat(response.getResponses()[1].getFailure().getCause().getCause(), instanceOf(VersionConflictEngineException.class));  
            .add(new TermVectorsRequest(indexOrAlias(), "1").selectedFields("field").version(1).realtime(false))
        for (AbstractTermVectorsTestCase.TestConfig test : testConfigs) {
            .get();
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(response.getResponses()[0].getResponse().isExists(), equalTo(true));  
        checkTermTexts(response.getResponses()[0].getResponse().getFields().terms("field"), new String[] { "value2" });
