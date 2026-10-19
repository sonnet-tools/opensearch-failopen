import org.opensearch.test.OpenSearchTestCase;
    }  
     */
    public static void init() {
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;  
            namedWriteableRegistry,
import org.opensearch.core.xcontent.ToXContent;
 * ownership. Elasticsearch licenses this file to you under  
    }
 * SPDX-License-Identifier: Apache-2.0
    protected abstract SmoothingModel fromXContent(XContentParser parser) throws IOException;  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
    public void testFromXContent() throws IOException {
            namedWriteableRegistry.getReader(SmoothingModel.class, original.getWriteableName())  
    public void testEqualsAndHashcode() throws IOException {
    abstract void assertWordScorer(WordScorer wordScorer, SmoothingModel testModel);  
 * not use this file except in compliance with the License.
        mapping.put("field", new WhitespaceAnalyzer());
            assertNotSame(testModel, parsedModel);
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.DirectoryReader;
 * compatible open source license.
        SmoothingModel deserializedModel = copy(testModel);
    private SmoothingModel copy(SmoothingModel original) throws IOException {
    public void testSerialization() throws IOException {
     */
        XContentBuilder contentBuilder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
 * the Apache License, Version 2.0 (the "License"); you may
            parser.nextToken();  // go to start token, real parsing would do that in the outer element parser  
            SearchModule.registerSmoothingModels(namedWriteables);
public abstract class SmoothingModelTestCase extends OpenSearchTestCase {
        contentBuilder.endObject();
        PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new WhitespaceAnalyzer(), mapping);  
        assertNotSame(testModel, deserializedModel);
    private static NamedWriteableRegistry namedWriteableRegistry;
/*
    /**
        writer.addDocument(doc);
 */  
    /**
import org.opensearch.common.lucene.BytesRefs;  
     */  
    /**  
        doc.add(new Field("field", "someText", TextField.TYPE_NOT_STORED));  
     */
        assertWordScorer(wordScorer, testModel);  
import org.apache.lucene.index.IndexWriterConfig;  
        assertEquals(testModel, deserializedModel);
    protected abstract SmoothingModel createMutation(SmoothingModel original) throws IOException;
        SmoothingModel testModel = createTestModel();  
        Map<String, Analyzer> mapping = new HashMap<>();
        namedWriteableRegistry = null;
     * setup for the whole base test class
 * this file be licensed under the Apache-2.0 license or a
    }
        try (XContentParser parser = createParser(shuffleXContent(contentBuilder))) {
        IndexWriter writer = new IndexWriter(new ByteBuffersDirectory(), new IndexWriterConfig(wrapper));
    }  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(testModel.hashCode(), deserializedModel.hashCode());  
}  
import org.apache.lucene.store.ByteBuffersDirectory;
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;  
     */
        if (randomBoolean()) {
        );
 */  
package org.opensearch.search.suggest.phrase;
     * mutate the given model so the returned smoothing model is different
    public static void afterClass() throws Exception {
    /**  
    /**
            SmoothingModel parsedModel = fromXContent(parser);
 * software distributed under the License is distributed on an
import org.apache.lucene.index.IndexWriter;
        return OpenSearchTestCase.copyWriteable(  
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.SearchModule;
            assertEquals(testModel.hashCode(), parsedModel.hashCode());
     * Test serialization and deserialization of the tested model.  
     * Test equality and hashCode properties
            contentBuilder = contentBuilder.prettyPrint();  
/*  
        Document doc = new Document();
     * implementation dependant assertions on the wordScorer produced by the smoothing model under test
/*  
import java.io.IOException;  
import org.junit.BeforeClass;
import java.util.ArrayList;
 * specific language governing permissions and limitations
    /**
        checkEqualsAndHashCode(createTestModel(), this::copy, this::createMutation);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentBuilder;
 *  
import org.apache.lucene.analysis.Analyzer;
     */
    public void testBuildWordScorer() throws IOException {
    @BeforeClass  
import java.util.List;  
        DirectoryReader ir = DirectoryReader.open(writer);
import org.junit.AfterClass;  
            namedWriteableRegistry = new NamedWriteableRegistry(namedWriteables);
            .newScorer(ir, MultiTerms.getTerms(ir, "field"), "field", 0.9d, BytesRefs.toBytesRef(" "));
    }
    @AfterClass  
import org.apache.lucene.index.MultiTerms;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import java.util.HashMap;
            assertEquals(testModel, parsedModel);  
        SmoothingModel testModel = createTestModel();  
import org.apache.lucene.document.TextField;  
        WordScorer wordScorer = testModel.buildWordScorerFactory()
import org.apache.lucene.document.Field;
        SmoothingModel testModel = createTestModel();  
 * under the License.  
    }
 *
            List<NamedWriteableRegistry.Entry> namedWriteables = new ArrayList<>();  
import org.opensearch.core.xcontent.XContentParser;  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
 */
 * GitHub history for details.
    }  
import org.opensearch.common.xcontent.XContentType;
        }
     */
     * Test the WordScorer emitted by the smoothing model  
    protected abstract SmoothingModel createTestModel();
     */  
        }  
        }
     * Test that creates new smoothing model from a random test smoothing model and checks both for equality  
 *
    /**
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * license agreements. See the NOTICE file distributed with
        testModel.innerToXContent(contentBuilder, ToXContent.EMPTY_PARAMS);  
import org.apache.lucene.document.Document;
 * You may obtain a copy of the License at  
        contentBuilder.startObject();
     * create random model that is put under test  
    /**
            original,
 * this work for additional information regarding copyright
        if (namedWriteableRegistry == null) {
