            this.selectedFields = selectedFields;
            if (storedOffset) {
        }
                type.setStoreTermVectorOffsets(fieldSetting.storedOffset);
        }
            new TestFieldSetting("field_with_positions_payloads", false, true, true) };
            Document d = new Document();
    protected static class TestConfig {
                tv_settings = "yes";
import org.apache.lucene.document.Document;
        refresh();
/*
            } else {
            if (storedPositions) {
        XContentBuilder mappingBuilder = jsonBuilder();
                        assertThat("Missing position test failed" + failDesc, esPos, equalTo(-1));
        public final boolean requestPositions;
            .put(indexSettings())
            this.doc = doc;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
            }
        ScoreDoc[] scoreDocs = search.scoreDocs;
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
            if (requestPayloads) {
                true,
        }
            assertEquals(fieldSettings.length, fieldContent.length);
}
            }
                type.setStoreTermVectorPayloads(fieldSetting.storedPayloads);
            }
import org.apache.lucene.store.ByteBuffersDirectory;
            .setTermStatistics(true)
        for (TestDoc doc : testDocs) {
                    int lucenePos = luceneDocsPosEnum.nextPosition();
        HashSet<String> selectedFields = testConfig.selectedFields == null ? null : new HashSet<>(Arrays.asList(testConfig.selectedFields));
        @Override
    protected void createIndexBasedOnFieldSettings(String index, String alias, TestFieldSetting[] fieldSettings) throws IOException {
        assertEquals(1, scoreDocs.length);
        public final String[] fieldContent;
        public void addToMappings(XContentBuilder mappingsBuilder) throws IOException {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        Map<String, Object> docSource = new HashMap<>();
                    if (randomBoolean()) {
                    @Override
            this.alias = alias;
        }
        return directoryReader.termVectors().get(scoreDocs[0].doc);
                randomBoolean(),
    /**
        public TestDoc alias(String alias) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                        selectedFields.add(field.name);
        ArrayList<TestConfig> configs = new ArrayList<>();
    }
        Fields esTermVectorFields = esResponse.getFields();
        TestDoc testDoc = testConfig.doc;
            testDocs[i] = doc;
                    assertFalse(field.storedOffset);
                requested += "offsets,";
                assertThat(esTermEnum.totalTermFreq(), equalTo(luceneTermEnum.totalTermFreq()));
                randomBoolean(),
            assertNotNull(esTerms);
            if (storedPositions && storedOffset && storedPayloads) {
                    }
                selectedFields = new ArrayList<>();
                        return new TokenStreamComponents(tokenizer, filter);
    }
                PostingsEnum luceneDocsPosEnum = luceneTermEnum.postings(null, PostingsEnum.POSITIONS);
    protected DirectoryReader indexDocsWithLucene(TestDoc[] testDocs) throws IOException {
            .setFieldStatistics(true)
            } else if (storedPositions) {
import org.apache.lucene.index.Term;
 * SPDX-License-Identifier: Apache-2.0
            writer.updateDocument(new Term("id", doc.id), d);
            .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
        mappingBuilder.startObject().startObject("properties");
                "(doc: %s\n requested: %s, fields: %s)",
            } else if (storedPositions && storedOffset) {
                assertNull(esTerms);
                        Tokenizer tokenizer = new StandardTokenizer();
            if (selectedFields != null && !selectedFields.contains(field.name)) {
        // always adds a test that fails
import org.apache.lucene.index.IndexWriterConfig;
                    continue;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.document.FieldType;
                    selectedFields.add("Doesnt_exist"); // this will be ignored.
        );
    }
            return String.format(
        assertAcked(prepareCreate(index).setMapping(mappingBuilder).setSettings(settings).addAlias(new Alias(alias)));
            new TestFieldSetting("field_with_offsets", true, false, false),
            this.index = index;
            StringBuilder sb = new StringBuilder("name: ").append(name).append(" tv_with:");
            this.id = id;
import java.util.HashSet;
        public final String id;
                FieldType type = new FieldType(TextField.TYPE_STORED);
import org.apache.lucene.analysis.TokenFilter;
                true
        return testDocs;
            .setPositions(config.requestPositions)
                    }
        writer.close();
            docSource.clear();
            }
            writer.commit();
 *
            return sb.toString();
    }
            .putList("index.analysis.analyzer.tv_test.filter", "lowercase");
            Terms luceneTerms = luceneFields.terms(field.name);
            return this;
    protected TestConfig[] generateTestConfigs(int numberOfTests, TestDoc[] testDocs, TestFieldSetting[] fieldSettings) {
                for (int i = 0; i < freq; i++) {
import org.apache.lucene.document.StringField;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (luceneDocsPosEnum == null) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        TopDocs search = searcher.search(new TermQuery(new Term("id", doc.id)), 1);
import org.apache.lucene.analysis.Analyzer;
 * ownership. Elasticsearch licenses this file to you under
            );
import org.apache.lucene.index.IndexWriter;
    protected TestFieldSetting[] getFieldSettings() {
import org.apache.lucene.document.TextField;
                assertThat("Token mismatch for field: " + field.name, currentTerm, equalTo(luceneTermEnum.term().utf8ToString()));
        public TestConfig expectedException(Class<? extends Exception> exceptionClass) {
import org.apache.lucene.analysis.payloads.TypeAsPayloadTokenFilter;
            if (storedPayloads) {
        conf.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        return Arrays.asList(
            .setRealtime(false);
 */
        );
    protected static class TestFieldSetting {
    public AbstractTermVectorsTestCase(Settings staticSettings) {
        for (TestFieldSetting field : testDocs[0].fieldSettings) {
                        TokenFilter filter = new LowerCaseFilter(tokenizer);
                        filter = new TypeAsPayloadTokenFilter(filter);
            "Transforming a data stream (such as when using a scrambler in telecommunications)." };
            }
        }
        super(staticSettings);
                }
                    assertFalse(field.storedPositions);
 * not use this file except in compliance with the License.
                }
import org.apache.lucene.search.IndexSearcher;
        int totalShards = getNumShards(index).numPrimaries;
            final String id = routingKeyForShard(index, i);
                }
        Directory dir = new ByteBuffersDirectory();
                assertNotNull(luceneTermEnum.next());
        public final TestDoc doc;
        Settings.Builder settings = Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
                d.add(new Field(fieldSetting.name, doc.fieldContent[i], type));
                        assertThat("Missing offset test failed" + failDesc, esDocsPosEnum.startOffset(), equalTo(-1));
            } else if (storedOffset) {
        }
                requested += "payload,";
import static org.hamcrest.Matchers.equalTo;
            }
        IndexSearcher searcher = new IndexSearcher(directoryReader);
                    int esPos = esDocsPosEnum.nextPosition();
                type.setStoreTermVectorPositions(fieldSetting.storedPositions || fieldSetting.storedPayloads || fieldSetting.storedOffset);
            this.storedOffset = storedOffset;
            while (esTermEnum.next() != null) {
                    protected TokenStreamComponents createComponents(String fieldName) {
                assertThat(freq, equalTo(luceneDocsPosEnum.freq()));
 * Unless required by applicable law or agreed to in writing,
            "Generating random numbers: see Random number generation.",
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;
            configs.add(config);
                        assertThat("Position test failed" + failDesc, lucenePos, equalTo(esPos));
import org.apache.lucene.analysis.Tokenizer;
                        assertThat("Offset test failed" + failDesc, luceneDocsPosEnum.endOffset(), equalTo(esDocsPosEnum.endOffset()));
                    assertNull("Missing payload test failed" + failDesc, esDocsPosEnum.getPayload());
        mappingBuilder.endObject().endObject();
 * The OpenSearch Contributors require contributions made to
            } else if (storedPayloads) {
            new TestFieldSetting("field_with_positions", false, false, true),
                requested,
            return sb.toString();
            .setSelectedFields(config.selectedFields)
        public TestFieldSetting(String name, boolean storedOffset, boolean storedPayloads, boolean storedPositions) {
    protected Fields getTermVectorsFromLucene(DirectoryReader directoryReader, TestDoc doc) throws IOException {
            ArrayList<String> selectedFields = null;
            this.name = name;
        public final boolean storedPositions;
        }
        String[] contentArray = new String[fieldSettings.length];
        public TestDoc index(String index) {
        return configs.toArray(new TestConfig[0]);
        PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new StandardAnalyzer(CharArraySet.EMPTY_SET), mapping);
                    selectedFields = null; // 0 length set is not supported.
 * under the License.
                // used field selection
import org.apache.lucene.index.Fields;
            for (int j = 0; j < contentArray.length; j++) {
     */
            if (storedPayloads) {
                luceneDocsPosEnum.nextDoc();
import org.apache.lucene.search.TermQuery;
            this.expectedException = exceptionClass;
            TermsEnum luceneTermEnum = luceneTerms.iterator();
            }
public abstract class AbstractTermVectorsTestCase extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import org.apache.lucene.document.Field;
 * You may obtain a copy of the License at
            mappingsBuilder.field("type", "text");
 * compatible open source license.
    }
                    if (field.storedOffset && testConfig.requestOffsets) {
 *
    }
import org.apache.lucene.index.PostingsEnum;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
    protected TestDoc[] generateTestDocs(String index, TestFieldSetting[] fieldSettings) {
            for (int i = 0; i < fieldSettings.length; i++) {
    protected void validateResponse(TermVectorsResponse esResponse, Fields luceneFields, TestConfig testConfig) throws IOException {
        return new TestFieldSetting[] {
                TestFieldSetting fieldSetting = doc.fieldSettings[i];
import org.opensearch.common.settings.Settings;
import org.apache.lucene.store.Directory;
            "Selecting a random sample of a population (important in statistical sampling).",
                    // test we expect that...
            "Generating a random permutation of a sequence (such as when shuffling cards).",
    }
    }
        }
                contentArray[j] = fieldContentOptions[randomInt(fieldContentOptions.length - 1)];
        for (int i = 0; i < totalShards; i++) {
        String[] fieldContentOptions = new String[] {
 * specific language governing permissions and limitations
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        // this methods wants to send one doc to each shard
                Locale.US,
 */
import org.opensearch.core.xcontent.XContentBuilder;
        @Override
/*
import java.io.IOException;
        public final boolean requestOffsets;
        }
            this.requestPayloads = requestPayloads;
                tv_settings = "with_offsets";
            this.fieldSettings = fieldSettings;
        public String toString() {
import java.util.Locale;
                tv_settings = "with_positions_payloads";
            new TestFieldSetting("field_with_positions_offsets", false, false, true),
            TestConfig config = new TestConfig(
                tv_settings = "with_positions_offsets";
        public final TestFieldSetting[] fieldSettings;
import org.apache.lucene.analysis.standard.StandardTokenizer;
                type.freeze();
            .setPayloads(config.requestPayloads)
        Map<String, Analyzer> mapping = new HashMap<>();
        public final String[] selectedFields;
        }
                tv_settings = "with_positions_offsets_payloads";
                sb.append("\n").append("Field: ").append(f).append("\n  content:").append(fieldContent[i]);
import org.apache.lucene.search.ScoreDoc;
        public Class<? extends Exception> expectedException = null;
        for (int i = 0; i < numberOfTests; i++) {
        public TestDoc(String id, TestFieldSetting[] fieldSettings, String[] fieldContent) {
        IndexWriterConfig conf = new IndexWriterConfig(wrapper);
            new TestConfig(
        public String index = "test";
        @Override
            sb.append("\n");
                tv_settings = "with_positions";
            if (requestPositions) {
            }
import org.apache.lucene.search.TopDocs;
            TestDoc doc = new TestDoc(id, fieldSettings, contentArray.clone());
            this.storedPositions = storedPositions;
                mappingsBuilder.field("analyzer", "tv_test");
            );
 * Modifications Copyright OpenSearch Contributors. See
                if (randomBoolean()) {
            return this;
            StringBuilder sb = new StringBuilder("index:").append(index).append(" type:").append(type).append(" id:").append(id);
                testDocs[randomInt(testDocs.length - 1)],
        }
        }
        public String toString() {
        }
            Terms esTerms = esTermVectorFields.terms(field.name);
        public final boolean storedPayloads;
            mappingsBuilder.endObject();
            assertNull("Es returned terms are done but lucene isn't", luceneTermEnum.next());
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            }
        return DirectoryReader.open(dir);
import org.apache.lucene.analysis.CharArraySet;
            String requested = "";
            TermsEnum esTermEnum = esTerms.iterator();
                for (TestFieldSetting field : fieldSettings)
import org.apache.lucene.analysis.LowerCaseFilter;
    }
        }
import org.opensearch.action.admin.indices.alias.Alias;
 * Licensed to Elasticsearch under one or more contributor
    }
                    } else {
import java.util.Map;
            }
            }
        public final String name;
            this.requestOffsets = requestOffsets;
                true,
        assertThat(esResponse.getIndex(), equalTo(testConfig.doc.index));
            index(doc.index, doc.type, doc.id, docSource);
                });
 * KIND, either express or implied.  See the License for the
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                PostingsEnum esDocsPosEnum = esTermEnum.postings(null, PostingsEnum.POSITIONS);
import java.util.HashMap;
            mappingsBuilder.field("term_vector", tv_settings);
import java.util.Arrays;
            .setOffsets(config.requestOffsets)
        TestDoc[] testDocs = new TestDoc[totalShards];
            this.fieldContent = fieldContent;
    protected TermVectorsRequestBuilder getRequestForConfig(TestConfig config) {
                    assertFalse(field.storedPayloads);
        configs.add(
    protected static class TestDoc {
                String currentTerm = esTermEnum.term().utf8ToString();
                esDocsPosEnum.nextDoc();
                continue;
                }
 * this work for additional information regarding copyright
            }
                sb.append("offsets,");
            this.storedPayloads = storedPayloads;
                    } else {
                selectedFields == null ? null : selectedFields.toArray(new String[] {}),
                        assertThat("Offset test failed" + failDesc, luceneDocsPosEnum.startOffset(), equalTo(esDocsPosEnum.startOffset()));
            return this;
                    }
import org.apache.lucene.index.Terms;
 *    http://www.apache.org/licenses/LICENSE-2.0
        public String toString() {
        IndexWriter writer = new IndexWriter(dir, conf);
            if (requestOffsets) {
            "Allocating experimental units via random assignment to a treatment or control condition.",
        public String type = "type1";
                sb.append("positions,");
        public final boolean storedOffset;
            field.addToMappings(mappingBuilder);
                if (selectedFields.size() == 0) {
                int freq = esDocsPosEnum.freq();
    }
                selectedFields == null ? "NULL" : String.join(",", selectedFields)
            mappingsBuilder.startObject(name);
        }
            }
        }
                docSource.put(fieldSettings[j].name, contentArray[j]);
            }
        for (TestFieldSetting field : fieldSettings) {
import org.apache.lucene.index.DirectoryReader;
                new String[] { "doesnt_exist" },
package org.opensearch.action.termvectors;
    public static Collection<Object[]> parameters() {
                    if (field.storedPositions && testConfig.requestPositions) {
                TestFieldSetting f = fieldSettings[i];
                    String failDesc = " (field:" + field.name + " term:" + currentTerm + ")";
/*
    @ParametersFactory
            new TestFieldSetting("field_with_only_tv", false, false, false),
            }
                mapping.put(field.name, new Analyzer() {
                    }
     * Generate test documentsThe returned documents are already indexed.
            for (int i = 0; i < doc.fieldContent.length; i++) {
        for (TestFieldSetting field : testDoc.fieldSettings) {
                doc,
                requested += "position,";
                randomBoolean()
                new TestDoc("doesnt_exist", new TestFieldSetting[] {}, new String[] {}).index("doesn't_exist").alias("doesn't_exist"),
        public final boolean requestPayloads;
import java.util.ArrayList;
            String tv_settings;
            if (randomBoolean()) {
        refresh();
            ).expectedException(org.opensearch.index.IndexNotFoundException.class)
            if (field.storedPayloads) {
        public TestConfig(TestDoc doc, String[] selectedFields, boolean requestPositions, boolean requestOffsets, boolean requestPayloads) {
        return client().prepareTermVectors(randomBoolean() ? config.doc.index : config.doc.alias, config.doc.id)
import java.util.Collection;
        public String alias = "alias";
                sb.append("payloads,");
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            d.add(new Field("id", doc.id, StringField.TYPE_STORED));
 *
                        assertThat("Missing offset test failed" + failDesc, esDocsPosEnum.endOffset(), equalTo(-1));
    }
    }
 */
                type.setStoreTermVectors(true);
            this.requestPositions = requestPositions;
