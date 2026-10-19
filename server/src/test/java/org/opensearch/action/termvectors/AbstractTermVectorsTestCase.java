            field.addToMappings(mappingBuilder);
                    assertNull("Missing payload test failed" + failDesc, esDocsPosEnum.getPayload());  
    protected TermVectorsRequestBuilder getRequestForConfig(TestConfig config) {
                    if (randomBoolean()) {  
        }  
                sb.append("payloads,");  
import java.util.Collection;  
                FieldType type = new FieldType(TextField.TYPE_STORED);  
                type.setStoreTermVectorPayloads(fieldSetting.storedPayloads);
import org.apache.lucene.document.Field;
        }  
        String[] contentArray = new String[fieldSettings.length];
            docSource.clear();
        }  
                requested += "payload,";
                    if (field.storedOffset && testConfig.requestOffsets) {
            .setPositions(config.requestPositions)
            "Generating random numbers: see Random number generation.",
            if (requestPositions) {  
        mappingBuilder.startObject().startObject("properties");  
                contentArray[j] = fieldContentOptions[randomInt(fieldContentOptions.length - 1)];
            }  
                    } else {
            if (requestPayloads) {  
        }
                doc,  
        public final boolean requestOffsets;
            "Transforming a data stream (such as when using a scrambler in telecommunications)." };  
        }  
                luceneDocsPosEnum.nextDoc();
            String requested = "";
            } else if (storedOffset) {
                    String failDesc = " (field:" + field.name + " term:" + currentTerm + ")";  
                String currentTerm = esTermEnum.term().utf8ToString();
                tv_settings = "with_positions_offsets";  
        }  
import org.apache.lucene.analysis.TokenFilter;  
                    assertFalse(field.storedPositions);
            "Selecting a random sample of a population (important in statistical sampling).",  
        public final boolean storedPayloads;
        }  
        return directoryReader.termVectors().get(scoreDocs[0].doc);  
            this.expectedException = exceptionClass;
        assertThat(esResponse.getIndex(), equalTo(testConfig.doc.index));
            } else if (storedPayloads) {
import org.apache.lucene.analysis.CharArraySet;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
    protected TestDoc[] generateTestDocs(String index, TestFieldSetting[] fieldSettings) {  
        ArrayList<TestConfig> configs = new ArrayList<>();
            } else if (storedPositions) {  
 * Licensed to Elasticsearch under one or more contributor  
        assertAcked(prepareCreate(index).setMapping(mappingBuilder).setSettings(settings).addAlias(new Alias(alias)));  
                assertNull(esTerms);
            TermsEnum luceneTermEnum = luceneTerms.iterator();
        assertEquals(1, scoreDocs.length);
 *
            }
        public final String[] fieldContent;  
                    }
                TestFieldSetting fieldSetting = doc.fieldSettings[i];
        public TestDoc(String id, TestFieldSetting[] fieldSettings, String[] fieldContent) {
        return Arrays.asList(
                assertThat(esTermEnum.totalTermFreq(), equalTo(luceneTermEnum.totalTermFreq()));  
                    assertFalse(field.storedOffset);
                    }
            assertNotNull(esTerms);  
package org.opensearch.action.termvectors;
            new TestFieldSetting("field_with_positions", false, false, true),
                }
                testDocs[randomInt(testDocs.length - 1)],
        HashSet<String> selectedFields = testConfig.selectedFields == null ? null : new HashSet<>(Arrays.asList(testConfig.selectedFields));  
                d.add(new Field(fieldSetting.name, doc.fieldContent[i], type));
                    continue;
    }
    protected TestFieldSetting[] getFieldSettings() {
                    selectedFields = null; // 0 length set is not supported.
    }
 * license agreements. See the NOTICE file distributed with
        IndexSearcher searcher = new IndexSearcher(directoryReader);
 *  
        ScoreDoc[] scoreDocs = search.scoreDocs;
            } else {
                if (selectedFields.size() == 0) {
        public final boolean requestPayloads;
            this.requestPositions = requestPositions;
import org.apache.lucene.document.StringField;  
/*  
        IndexWriterConfig conf = new IndexWriterConfig(wrapper);  
import org.apache.lucene.document.TextField;
            }  
        XContentBuilder mappingBuilder = jsonBuilder();
            this.fieldContent = fieldContent;  
import java.util.Locale;  
                }
            new TestFieldSetting("field_with_only_tv", false, false, false),  
        return configs.toArray(new TestConfig[0]);
        String[] fieldContentOptions = new String[] {
        public void addToMappings(XContentBuilder mappingsBuilder) throws IOException {
            if (storedPositions) {
        }  
            writer.commit();
            if (randomBoolean()) {
                    }
            Document d = new Document();  
            return this;
            if (storedPayloads) {
import org.opensearch.common.settings.Settings;
            }
        public final boolean storedPositions;
import org.apache.lucene.document.FieldType;
        refresh();
import java.util.Arrays;
    @ParametersFactory
                    // test we expect that...
 * this work for additional information regarding copyright
        for (int i = 0; i < totalShards; i++) {
import org.apache.lucene.store.Directory;  
            Terms esTerms = esTermVectorFields.terms(field.name);  
        }
                    @Override
        );
 * ownership. Elasticsearch licenses this file to you under  
        TestDoc testDoc = testConfig.doc;
                PostingsEnum luceneDocsPosEnum = luceneTermEnum.postings(null, PostingsEnum.POSITIONS);
                TestFieldSetting f = fieldSettings[i];  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                esDocsPosEnum.nextDoc();  
            index(doc.index, doc.type, doc.id, docSource);  
                }  
 * under the License.  
        IndexWriter writer = new IndexWriter(dir, conf);  
            }
            return this;  
                        Tokenizer tokenizer = new StandardTokenizer();  
            for (int i = 0; i < fieldSettings.length; i++) {
                tv_settings = "with_positions_offsets_payloads";
        @Override
                        assertThat("Offset test failed" + failDesc, luceneDocsPosEnum.endOffset(), equalTo(esDocsPosEnum.endOffset()));
            this.fieldSettings = fieldSettings;
                        assertThat("Offset test failed" + failDesc, luceneDocsPosEnum.startOffset(), equalTo(esDocsPosEnum.startOffset()));  
            ).expectedException(org.opensearch.index.IndexNotFoundException.class)  
                type.setStoreTermVectorOffsets(fieldSetting.storedOffset);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import static org.hamcrest.Matchers.equalTo;  
            testDocs[i] = doc;
 * The OpenSearch Contributors require contributions made to  
    protected TestConfig[] generateTestConfigs(int numberOfTests, TestDoc[] testDocs, TestFieldSetting[] fieldSettings) {  
import java.util.HashMap;
    /**  
        TestDoc[] testDocs = new TestDoc[totalShards];
                for (int i = 0; i < freq; i++) {
                sb.append("\n").append("Field: ").append(f).append("\n  content:").append(fieldContent[i]);
            final String id = routingKeyForShard(index, i);
        public String toString() {
 * the Apache License, Version 2.0 (the "License"); you may
                randomBoolean(),  
                mapping.put(field.name, new Analyzer() {  
            Terms luceneTerms = luceneFields.terms(field.name);
        for (TestFieldSetting field : fieldSettings) {
     */
        writer.close();
import org.apache.lucene.index.PostingsEnum;  
    protected static class TestFieldSetting {
        configs.add(
    }
                continue;  
                tv_settings = "with_positions";
 * Unless required by applicable law or agreed to in writing,
public abstract class AbstractTermVectorsTestCase extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }  
    protected void createIndexBasedOnFieldSettings(String index, String alias, TestFieldSetting[] fieldSettings) throws IOException {
            if (storedPayloads) {
            }
            "Allocating experimental units via random assignment to a treatment or control condition.",
 *
    }
            d.add(new Field("id", doc.id, StringField.TYPE_STORED));
            }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                sb.append("positions,");  
        public String alias = "alias";
            return String.format(  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            TestDoc doc = new TestDoc(id, fieldSettings, contentArray.clone());
        public TestFieldSetting(String name, boolean storedOffset, boolean storedPayloads, boolean storedPositions) {
import org.apache.lucene.store.ByteBuffersDirectory;
 */
        public Class<? extends Exception> expectedException = null;  
                        assertThat("Missing offset test failed" + failDesc, esDocsPosEnum.startOffset(), equalTo(-1));  
        public TestDoc index(String index) {  
    }
        for (TestFieldSetting field : testDocs[0].fieldSettings) {
        int totalShards = getNumShards(index).numPrimaries;
import org.opensearch.action.admin.indices.alias.Alias;
 * this file be licensed under the Apache-2.0 license or a
            return sb.toString();
                selectedFields = new ArrayList<>();
        public String toString() {  
import org.apache.lucene.search.TermQuery;  
    }
            if (field.storedPayloads) {
            ArrayList<String> selectedFields = null;
import org.apache.lucene.index.IndexWriterConfig;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Generate test documentsThe returned documents are already indexed.
    }  
        }  
            assertEquals(fieldSettings.length, fieldContent.length);
            }
                true
                Locale.US,
            }
                if (randomBoolean()) {
                assertThat("Token mismatch for field: " + field.name, currentTerm, equalTo(luceneTermEnum.term().utf8ToString()));
    }
                int freq = esDocsPosEnum.freq();  
import org.apache.lucene.index.IndexWriter;
                        assertThat("Position test failed" + failDesc, lucenePos, equalTo(esPos));
                tv_settings = "with_offsets";  
        super(staticSettings);
            .setRealtime(false);  
                type.setStoreTermVectorPositions(fieldSetting.storedPositions || fieldSetting.storedPayloads || fieldSetting.storedOffset);
        return testDocs;
            .setTermStatistics(true)
                new TestDoc("doesnt_exist", new TestFieldSetting[] {}, new String[] {}).index("doesn't_exist").alias("doesn't_exist"),
 * GitHub history for details.
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;
        public TestConfig(TestDoc doc, String[] selectedFields, boolean requestPositions, boolean requestOffsets, boolean requestPayloads) {
            }
        conf.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
import org.apache.lucene.analysis.payloads.TypeAsPayloadTokenFilter;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (selectedFields != null && !selectedFields.contains(field.name)) {
import org.apache.lucene.index.Terms;
import org.opensearch.core.xcontent.XContentBuilder;  
            this.doc = doc;  
            }  
    }
import org.apache.lucene.analysis.Tokenizer;
 * KIND, either express or implied.  See the License for the
        Map<String, Object> docSource = new HashMap<>();  
        }
            for (int i = 0; i < doc.fieldContent.length; i++) {
        }
        refresh();  
    public static Collection<Object[]> parameters() {  
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Fields;  
import org.apache.lucene.search.ScoreDoc;
        }
            );  
import org.apache.lucene.index.DirectoryReader;
            while (esTermEnum.next() != null) {  
            .putList("index.analysis.analyzer.tv_test.filter", "lowercase");
                selectedFields == null ? null : selectedFields.toArray(new String[] {}),
                        return new TokenStreamComponents(tokenizer, filter);  
        Directory dir = new ByteBuffersDirectory();
                randomBoolean()
        public String index = "test";
        public final boolean storedOffset;  
/*
        for (int i = 0; i < numberOfTests; i++) {
        Settings.Builder settings = Settings.builder()
            new TestConfig(  
                tv_settings = "yes";
 * software distributed under the License is distributed on an
                    assertFalse(field.storedPayloads);  
            this.requestPayloads = requestPayloads;
        public final String name;
 * Modifications Copyright OpenSearch Contributors. See
                    int lucenePos = luceneDocsPosEnum.nextPosition();
            mappingsBuilder.field("term_vector", tv_settings);
import java.io.IOException;  
        return DirectoryReader.open(dir);  
import java.util.Map;
            .setPayloads(config.requestPayloads)  
import java.util.ArrayList;
        Map<String, Analyzer> mapping = new HashMap<>();  
        for (TestFieldSetting field : testDoc.fieldSettings) {
            return this;
        @Override  
                true,
        mappingBuilder.endObject().endObject();
            this.selectedFields = selectedFields;
                requested += "position,";
            this.id = id;  
        return client().prepareTermVectors(randomBoolean() ? config.doc.index : config.doc.alias, config.doc.id)
            this.name = name;
                });  
import org.apache.lucene.analysis.Analyzer;  
            new TestFieldSetting("field_with_positions_payloads", false, true, true) };
 * You may obtain a copy of the License at  
            TestConfig config = new TestConfig(  
            TermsEnum esTermEnum = esTerms.iterator();  
            for (int j = 0; j < contentArray.length; j++) {  
            mappingsBuilder.endObject();
}
                for (TestFieldSetting field : fieldSettings)
                    protected TokenStreamComponents createComponents(String fieldName) {
                        assertThat("Missing offset test failed" + failDesc, esDocsPosEnum.endOffset(), equalTo(-1));
            }
            new TestFieldSetting("field_with_positions_offsets", false, false, true),
        public String toString() {
                randomBoolean(),
            .put(indexSettings())  
        public final TestFieldSetting[] fieldSettings;
import org.apache.lucene.document.Document;  
                assertThat(freq, equalTo(luceneDocsPosEnum.freq()));
                // used field selection  
                type.freeze();
import java.util.HashSet;
/*  
                        selectedFields.add(field.name);
        // always adds a test that fails
            this.storedPositions = storedPositions;
        }
                requested += "offsets,";
        Fields esTermVectorFields = esResponse.getFields();
            if (storedPositions && storedOffset && storedPayloads) {  
        public final String id;
        PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new StandardAnalyzer(CharArraySet.EMPTY_SET), mapping);  
            mappingsBuilder.field("type", "text");
            writer.updateDocument(new Term("id", doc.id), d);
 * SPDX-License-Identifier: Apache-2.0
            "Generating a random permutation of a sequence (such as when shuffling cards).",
 * specific language governing permissions and limitations
    protected Fields getTermVectorsFromLucene(DirectoryReader directoryReader, TestDoc doc) throws IOException {  
 * not use this file except in compliance with the License.
                if (luceneDocsPosEnum == null) {  
 */  
            } else if (storedPositions && storedOffset) {
import org.apache.lucene.search.TopDocs;
                true,  
                    selectedFields.add("Doesnt_exist"); // this will be ignored.  
        TopDocs search = searcher.search(new TermQuery(new Term("id", doc.id)), 1);
    }  
            StringBuilder sb = new StringBuilder("name: ").append(name).append(" tv_with:");
                mappingsBuilder.field("analyzer", "tv_test");
            String tv_settings;
                new String[] { "doesnt_exist" },
                selectedFields == null ? "NULL" : String.join(",", selectedFields)
            this.requestOffsets = requestOffsets;  
        public TestConfig expectedException(Class<? extends Exception> exceptionClass) {
                PostingsEnum esDocsPosEnum = esTermEnum.postings(null, PostingsEnum.POSITIONS);
        }
                        TokenFilter filter = new LowerCaseFilter(tokenizer);
                    }
 * compatible open source license.
            this.storedOffset = storedOffset;  
            .setFieldStatistics(true)  
        return new TestFieldSetting[] {  
            new TestFieldSetting("field_with_offsets", true, false, false),
                docSource.put(fieldSettings[j].name, contentArray[j]);
import org.apache.lucene.analysis.standard.StandardTokenizer;
            }  
            .setSelectedFields(config.selectedFields)
        }
        );
    protected void validateResponse(TermVectorsResponse esResponse, Fields luceneFields, TestConfig testConfig) throws IOException {  
        // this methods wants to send one doc to each shard  
            this.alias = alias;  
            StringBuilder sb = new StringBuilder("index:").append(index).append(" type:").append(type).append(" id:").append(id);
            return sb.toString();
    protected static class TestDoc {  
        public final String[] selectedFields;
            mappingsBuilder.startObject(name);  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            assertNull("Es returned terms are done but lucene isn't", luceneTermEnum.next());  
        public TestDoc alias(String alias) {
            }
        for (TestDoc doc : testDocs) {
            .put("index.analysis.analyzer.tv_test.tokenizer", "standard")
    protected DirectoryReader indexDocsWithLucene(TestDoc[] testDocs) throws IOException {
            this.index = index;
                sb.append("offsets,");  
                "(doc: %s\n requested: %s, fields: %s)",
                type.setStoreTermVectors(true);  
                requested,
                    } else {
            if (requestOffsets) {  
    public AbstractTermVectorsTestCase(Settings staticSettings) {
    protected static class TestConfig {  
            if (storedOffset) {
            configs.add(config);
                assertNotNull(luceneTermEnum.next());
                tv_settings = "with_positions_payloads";
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            );  
                        filter = new TypeAsPayloadTokenFilter(filter);
        @Override
                }  
import org.apache.lucene.search.IndexSearcher;
            }
        public String type = "type1";  
                    if (field.storedPositions && testConfig.requestPositions) {  
        public final boolean requestPositions;  
        public final TestDoc doc;
 */  
                        assertThat("Missing position test failed" + failDesc, esPos, equalTo(-1));  
import org.apache.lucene.analysis.LowerCaseFilter;
    }
            sb.append("\n");  
                    int esPos = esDocsPosEnum.nextPosition();
            .setOffsets(config.requestOffsets)
import org.apache.lucene.index.TermsEnum;  
    }
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            this.storedPayloads = storedPayloads;
