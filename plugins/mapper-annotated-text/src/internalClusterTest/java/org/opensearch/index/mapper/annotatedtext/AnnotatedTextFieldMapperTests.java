            b.field("norms", false);
            b.field("field6", "1234");
        DocumentMapper mapper = createDocumentMapper("_doc", mapping);  
        IndexableField[] fields = doc.rootDoc().getFields("field");
            b.field("field3", "1234");
    public void testIndexOptions() throws IOException {  
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));  
        supportedOptions.put("docs", IndexOptions.DOCS);
        String annotatedText = "He paid [Stormy Daniels](Stephanie+Clifford&Payee) hush money";  
            b.field("norms", false);
import org.opensearch.plugins.Plugin;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.analysis.NamedAnalyzer;  
            assertEquals(4, postings.nextPosition());
            postings = terms.postings(null, PostingsEnum.POSITIONS);  
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
        assertWarnings("Parameter [index] has no effect on type [annotated_text] and will be removed in future");  
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorPositions(), equalTo(false));
 * SPDX-License-Identifier: Apache-2.0
    }
            .field("type", "annotated_text")
            .field("analyzer", "standard")
            }
            .startObject("_doc")  
import java.util.Set;
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorOffsets(), equalTo(true));  
                new CharFilterFactory[0],
        final int positionIncrementGap = randomIntBetween(1, 1000);  
import java.io.IOException;  
        Exception e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {  
        IndexableField[] fields = doc.rootDoc().getFields("field");
import java.util.HashMap;
            b.field("type", "annotated_text");  
 * license agreements. See the NOTICE file distributed with
            BytesRef term;
            b.startObject("field1").field("type", "annotated_text").field("term_vector", "no").endObject();
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));  
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.containsString;  
        assertThat(fieldType.storeTermVectors(), equalTo(false));
    }
            .startObject("field")
            .field("type", "annotated_text")  
            assertFalse(terms.seekExact(new BytesRef("MissingEndBracket")));
            .endObject()
import java.util.Collection;
            new CustomAnalyzer(  
import org.apache.lucene.analysis.en.EnglishAnalyzer;
/*  
    public void testTermVectors() throws IOException {
            // Bad markup means value is treated as plain text and fed through tokenisation
        checker.registerUpdateCheck(b -> {  
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
    @Override  
        assertEquals(1, fields.length);
            b.field("position_increment_gap", positionIncrementGap);
            .endObject()
            assertEquals(0, postings.nextDoc());
import org.opensearch.index.analysis.StandardTokenizerFactory;
            assertTrue(foundTerms.contains("fox"));  
        assertTrue(fields[0].fieldType().omitNorms());  
            assertEquals(0, postings.nextDoc());  
            .endObject()
            AnalyzerScope.INDEX,
import java.util.HashSet;
            .endObject()
            .endObject()
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorPositions(), equalTo(false));  
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorPayloads(), equalTo(true));
            assertEquals(2, postings.nextPosition());
import org.opensearch.plugin.mapper.AnnotatedTextPlugin;  
            b.field("type", "annotated_text");
            .toString();
        assertEquals(mapping, mapper.mappingSource().toString());
import org.apache.lucene.util.BytesRef;  
 */  
            assertTrue(terms.seekExact(new BytesRef("bar")));
        assertEquals("b", fields[1].stringValue());  
        }));
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
            LeafReader leaf = reader.leaves().get(0).reader();
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
            .startObject("field")
        NamedAnalyzer stop = new NamedAnalyzer(  
        for (String indexOptions : Arrays.asList("docs", "freqs")) {
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
            b.nullField("analyzer");
            b.field("term_vector", "with_positions_offsets_payloads");  
                    public TokenStream create(TokenStream tokenStream) {
            b.field("type", "annotated_text");
            TermsEnum terms = leaf.terms("field").iterator();
                        return new StopFilter(tokenStream, EnglishAnalyzer.ENGLISH_STOP_WORDS_SET);
import org.opensearch.index.mapper.MapperService;
        assertEquals(mapping, mapper.mappingSource().toString());
                        return "stop";  
            assertTrue(terms.seekExact(new BytesRef("Stephanie Clifford")));  
            .field("analyzer", "default")
            .field("type", "annotated_text")  
                    }
            postings = terms.postings(null, PostingsEnum.POSITIONS);
            .endObject()
            LeafReader leaf = reader.leaves().get(0).reader();
 */
        assertEquals(1, fields.length);
        for (String option : supportedOptions.keySet()) {
            b.field("norms", true);
    protected void registerParameters(ParameterChecker checker) throws IOException {
                new StandardTokenizerFactory(indexSettings, null, "standard", indexSettings.getSettings()),
import java.util.Collections;  
        assertEquals(1, fields.length);
            .startObject("properties")
            .endObject()  
            .field("analyzer", "keyword")  
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectors(), equalTo(true));  
        mapping = XContentFactory.jsonBuilder()
        checker.registerConflictCheck("store", b -> b.field("store", true));
        assertEquals(annotatedText, fields[0].stringValue());  
            b.field("norms", true);
        assertEquals(2, fields.length);
            .startObject()
        }, b -> {  
    @Override
            .startObject("field")
            b.field("store", true);  
    @Override
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectors(), equalTo(true));
    @Override
            ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));  
        XContentBuilder builder = XContentFactory.jsonBuilder();  
                b.field("type", "annotated_text");  
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {  
            .field("search_analyzer", "keyword")
            b.field("index", false);
        checker.registerConflictCheck("position_increment_gap", b -> b.field("position_increment_gap", 10));
        }));
}
        checker.registerConflictCheck("norms", fieldMapping(b -> {
            assertTrue(terms.seekExact(new BytesRef("b")));
            .field("type", "annotated_text")  
 * You may obtain a copy of the License at  
    }
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", text)));
            .endObject()  
            .startObject()
            assertEquals(positionIncrementGap + 1, postings.nextPosition());
        mapping = XContentFactory.jsonBuilder()
        DocumentMapper mapper = createDocumentMapper("_doc", mapping);  
    public void testDisableNorms() throws IOException {
        return new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectors(), equalTo(true));
import org.opensearch.core.xcontent.XContentBuilder;  
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectors(), equalTo(true));
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.array("field", "a", "b")));
            LeafReader leaf = reader.leaves().get(0).reader();  
        supportedOptions.put("offsets", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
            b.field("type", "annotated_text");
            assertTrue(foundTerms.contains("Color"));
            .field("search_analyzer", "default")
            .endObject()
        checker.registerUpdateCheck(b -> {
            assertEquals(2, postings.nextPosition());
import org.opensearch.index.mapper.MapperTestCase;  
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
        }));
        assertEquals("1234", fields[0].stringValue());
    public void testNotIndexedField() throws IOException {
            assertTrue(terms.seekExact(new BytesRef("Payee")));
            .startObject("_doc")  
    }
        checker.registerConflictCheck("similarity", b -> b.field("similarity", "boolean"));
                new TokenFilterFactory[] { new TokenFilterFactory() {  
import org.opensearch.index.IndexSettings;
            assertEquals(0, postings.nextDoc());
            .field("type", "annotated_text")
            .endObject()  
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));  
        // norms can be set from true to false, but not vice versa
        assertEquals(mapping, mapper.mappingSource().toString());
        assertTrue(mappingString.contains("search_quote_analyzer"));
    public void testNullConfigValuesFail() throws MapperParsingException {
    }  
        supportedOptions.put("positions", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
            assertEquals(1, fields.length);
            .endObject()
            b.field("field4", "1234");
            b.field("norms", false);
        Map<String, NamedAnalyzer> analyzers = new HashMap<>();
        String text = "the quick [brown](Color) fox jumped over the lazy dog";  
        NamedAnalyzer keyword = new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer());
            "default",
        }));  
                    @Override
import org.opensearch.index.analysis.TokenFilterFactory;
import org.apache.lucene.index.IndexableField;  
            new StandardAnalyzer(),  
                    }  
            Terms terms = leaf.terms("field");
        assertTrue(fieldType.tokenized());
        });
    @Override
public class AnnotatedTextFieldMapperTests extends MapperTestCase {  
            .toString();  
        mapper = createDocumentMapper("_doc", mapping);
        createMapperService(fieldMapping(b -> {
        checker.registerUpdateCheck(b -> {
        mapper = createDocumentMapper("_doc", mapping);  
            .startObject("field")
            b.field("type", "annotated_text");
        Map<String, IndexOptions> supportedOptions = new HashMap<>();
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorOffsets(), equalTo(false));
    }
            b.field("type", "annotated_text");  
import org.apache.lucene.analysis.StopFilter;
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
        assertFalse(fieldType.stored());
        analyzers.put("whitespace", whitespace);
        checker.registerConflictCheck("term_vector", b -> b.field("term_vector", "yes"));  
 * this work for additional information regarding copyright
            .endObject()
        assertEquals(mapping, mapper.mappingSource().toString());
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", annotatedText)));
            b.field("field1", "1234");
    public void testPositionIncrementGap() throws IOException {
            .toString();
            })));  
        assertEquals(mapping, mapper.mappingSource().toString());
            .toString();
    protected Collection<Plugin> getPlugins() {  
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {  
import org.opensearch.index.analysis.IndexAnalyzers;
    }
            .startObject()  
import org.opensearch.index.analysis.CharFilterFactory;  
            .endObject()
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        assertEquals(annotatedText, fields[0].stringValue());  
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorPositions(), equalTo(true));  
        }));
            .endObject()  
                b.field("index_options", indexOptions);
            .field("search_quote_analyzer", "keyword")  
                foundTerms.add(term.utf8ToString());
            assertEquals(0, postings.nextDoc());
import org.opensearch.index.analysis.AnalyzerScope;
            .field("type", "annotated_text")  
 * under the License.  
            b.startObject("field6").field("type", "annotated_text").field("term_vector", "with_positions_offsets_payloads").endObject();
            .endObject()
        assertThat(fieldType.omitNorms(), equalTo(false));  
    public void testIndexedTermVectors() throws IOException {
            b.field("field2", "1234");  
        })));  
        assertTrue(mappingString.contains("search_analyzer"));
            assertEquals(0, postings.nextDoc());
import org.apache.lucene.index.DocValuesType;
    public void testAnalyzedFieldPositionIncrementWithoutPositions() {  
            b.field("analyzer", "default");
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        analyzers.put("my_stop_analyzer", stop);  
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorPayloads(), equalTo(false));  
        }, m -> assertFalse(m.fieldType().getTextSearchInfo().hasNorms()));  
            assertEquals(0, postings.nextPosition());  
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorPositions(), equalTo(false));
            assertThat(e.getMessage(), containsString("Cannot set position_increment_gap on field [field] without positions enabled"));
            b.startObject("field3").field("type", "annotated_text").field("term_vector", "with_offsets").endObject();
    }
            assertTrue(terms.seekExact(new BytesRef("hush")));
            assertTrue(terms.seekExact(new BytesRef("stormy")));
            Set<String> foundTerms = new HashSet<>();
        String annotatedText = "foo [bar](MissingEndBracket baz";  
 *  
 * compatible open source license.
                } }
            .field("type", "annotated_text")
        analyzers.put("standard", standard);  
            .endObject()
        assertEquals("b", fields[1].stringValue());
        });
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");
            .startObject("properties")  
            while ((term = iterator.next()) != null) {  
            AnalyzerScope.INDEX,
            .field("search_analyzer", "standard")
    }  
import java.util.Map;  
    protected void assertParseMaximalWarnings() {  
    }
            .field("analyzer", "standard")  
        assertThat(e.getMessage(), containsString("must not have a [null] value"));
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorPositions(), equalTo(true));
            .startObject("_doc")  
import org.opensearch.index.mapper.TextFieldMapper;
            .field("search_analyzer", "default")  
            assertTrue(foundTerms.contains("brown"));
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
    }  
        analyzers.put("default", dflt);
            b.field("type", "annotated_text");  
            .startObject()
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.ParsedDocument;
import org.apache.lucene.index.TermsEnum;
    public void testEnableStore() throws IOException {
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectors(), equalTo(true));  
            assertEquals(2, postings.nextPosition());  
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchQuoteAnalyzer().name()));  
            .endObject()  
            .endObject()
                    @Override  
    }  
    @Override
            b.field("search_analyzer", "keyword");
            TermsEnum terms = leaf.terms("field").iterator();
        assertTrue(fields[0].fieldType().stored());
            .startObject("_doc")  
            .startObject()
                    public String name() {
 *
            )
        // special case: default search analyzer
        IndexableField[] fields = doc.rootDoc().getFields("field");  
import org.apache.lucene.index.Terms;
            assertTrue(terms.seekExact(new BytesRef("foo")));  
            b.field("search_analyzer", "keyword");  
            .endObject()
            .toString();
            postings = terms.postings(null, PostingsEnum.POSITIONS);
        String mappingString = builder.toString();
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorPositions(), equalTo(true));
 * KIND, either express or implied.  See the License for the
        String mapping = XContentFactory.jsonBuilder()
        String mapping = XContentFactory.jsonBuilder()  
import org.opensearch.index.analysis.CustomAnalyzer;
        }
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorPayloads(), equalTo(false));
        IndexableField[] fields = doc.rootDoc().getFields("field");
    }  
            b.startObject("field4").field("type", "annotated_text").field("term_vector", "with_positions").endObject();
 * Modifications Copyright OpenSearch Contributors. See
            .endObject()  
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            .startObject("properties")
            .startObject("_doc")
            TextFieldMapper.Defaults.POSITION_INCREMENT_GAP
    public void testToleranceForBadAnnotationMarkup() throws IOException {
 * GitHub history for details.
            .startObject("field")  
        assertEquals("a", fields[0].stringValue());
        assertTrue(mappingString.contains("analyzer"));  
 * Licensed to Elasticsearch under one or more contributor  
        builder.endObject();  
        );  
        assertEquals("a", fields[0].stringValue());
            assertTrue(terms.seekExact(new BytesRef("missingendbracket")));  
            .startObject("_doc")
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
        );
        assertEquals(1, fields.length);  
    }
            DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
 * software distributed under the License is distributed on an
            b.startObject("field2").field("type", "annotated_text").field("term_vector", "yes").endObject();  
    }
        assertEquals(1, fields.length);
        }
            .field("search_quote_analyzer", "keyword")
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));
            .endObject()  
        mapping = XContentFactory.jsonBuilder()
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
        }), fieldMapping(b -> {
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorOffsets(), equalTo(false));
        mapper = createDocumentMapper("_doc", mapping);
            TermsEnum terms = leaf.terms("field").iterator();  
        mapper = createDocumentMapper("_doc", mapping);
                b.field("type", "annotated_text");  
/*  
        builder.startObject();
        IndexableField[] fields = doc.rootDoc().getFields("field");  
            assertEquals(supportedOptions.get(option), fields[0].fieldType().indexOptions());  
            assertEquals(0, postings.nextDoc());  
        ParsedDocument doc = defaultMapper.parse(source(b -> {
            .endObject()
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            b.field("analyzer", "default");  
        });
    public void testDefaultPositionIncrementGap() throws IOException {
        }));
            IndexableField[] fields = doc.rootDoc().getFields("field");
            .endObject()  
import org.apache.lucene.index.IndexableFieldType;
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));  
        // Use example of typed and untyped annotations
            LeafReader leaf = reader.leaves().get(0).reader();  
            .endObject()  
 */  
        // special case: default index/search analyzer  
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorPayloads(), equalTo(false));
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {
        // special case: default index analyzer  
            Exception e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
            assertEquals(TextFieldMapper.Defaults.POSITION_INCREMENT_GAP + 1, postings.nextPosition());
import org.opensearch.index.mapper.DocumentMapper;  
            .field("analyzer", "default")
        mapping = XContentFactory.jsonBuilder()
        IndexableFieldType fieldType = fields[0].fieldType();
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorOffsets(), equalTo(true));  
        mapping = XContentFactory.jsonBuilder()  
            .endObject()
 * Unless required by applicable law or agreed to in writing,
        NamedAnalyzer whitespace = new NamedAnalyzer("whitespace", AnalyzerScope.INDEX, new WhitespaceAnalyzer());
            TermsEnum terms = leaf.terms("field").iterator();
            assertEquals(0, postings.nextDoc());
                b.field("index_options", option);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
        b.field("type", "annotated_text");  
            }));
        });
        checker.registerConflictCheck("analyzer", b -> b.field("analyzer", "keyword"));
 * specific language governing permissions and limitations
        }));
    public void testDefaults() throws IOException {
            .toString();
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.equalTo;
    public void testSearchAnalyzerSerialization() throws IOException {  
            .endObject()
            .field("analyzer", "keyword")
            .startObject("properties")  
    }  
            b.field("type", "annotated_text");
        assertEquals(2, fields.length);
 *
            TermsEnum iterator = terms.iterator();  
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS));  
    public void testAnnotationInjection() throws IOException {
    }  
                b.field("position_increment_gap", 0);
        return Collections.singletonList(new AnnotatedTextPlugin());
            b.field("type", "annotated_text");  
            assertEquals(1, postings.nextPosition());
import org.apache.lucene.analysis.TokenStream;
        checker.registerConflictCheck("index_options", b -> b.field("index_options", "docs"));  
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            b.field("search_quote_analyzer", "keyword");
            .startObject("_doc")
import org.apache.lucene.analysis.core.KeywordAnalyzer;  
        assertEquals(mapping, mapper.mappingSource().toString());
        mapper.toXContent(builder, new ToXContent.MapParams(Collections.singletonMap("include_defaults", "true")));
            .startObject("field")
import org.apache.lucene.index.IndexOptions;
        NamedAnalyzer standard = new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer());  
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchAnalyzer().name()));
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorPayloads(), equalTo(false));
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.array("field", "a", "b")));
    }  
import org.apache.lucene.index.LeafReader;
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorOffsets(), equalTo(false));
            .startObject("properties")
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorPayloads(), equalTo(false));  
            b.field("type", "annotated_text");
            .toString();
        }));
            .endObject()  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        NamedAnalyzer dflt = new NamedAnalyzer(  
        });  
        analyzers.put("keyword", keyword);
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
    protected void minimalMapping(XContentBuilder b) throws IOException {
            b.startObject("field5").field("type", "annotated_text").field("term_vector", "with_positions_offsets").endObject();  
            .endObject()
            assertEquals(0, postings.nextDoc());  
            .startObject("properties")
    }  
            assertTrue(terms.seekExact(new BytesRef("b")));
import org.opensearch.common.xcontent.XContentFactory;
        supportedOptions.put("freqs", IndexOptions.DOCS_AND_FREQS);  
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
            .field("analyzer", "keyword")
            .field("search_analyzer", "keyword")
import org.opensearch.index.mapper.MapperParsingException;
 * not use this file except in compliance with the License.
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", annotatedText)));
            b.field("field5", "1234");  
            .startObject("properties")
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectors(), equalTo(false));
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorOffsets(), equalTo(true));
import org.opensearch.core.xcontent.ToXContent;
            LeafReader leaf = reader.leaves().get(0).reader();
            "my_stop_analyzer",
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
            postings = terms.postings(null, PostingsEnum.POSITIONS);  
            .startObject()
    public void testSearchQuoteAnalyzerSerialization() throws IOException {
package org.opensearch.index.mapper.annotatedtext;
            .startObject()
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
        builder.value("some text");
            .startObject("field")
        IndexableField[] fields = doc.rootDoc().getFields("field");
            // Check we have both text and annotation tokens  
        mapper = createDocumentMapper("_doc", mapping);
    }
/*
import org.apache.lucene.index.PostingsEnum;  
import java.util.Arrays;
