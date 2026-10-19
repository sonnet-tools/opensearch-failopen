        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorPayloads(), equalTo(false));
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectors(), equalTo(true));
 * GitHub history for details.
        IndexableField[] fields = doc.rootDoc().getFields("field");
            ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        supportedOptions.put("docs", IndexOptions.DOCS);
 *
import org.opensearch.index.mapper.DocumentMapper;
            .field("analyzer", "keyword")
            b.startObject("field1").field("type", "annotated_text").field("term_vector", "no").endObject();
            assertThat(e.getMessage(), containsString("Cannot set position_increment_gap on field [field] without positions enabled"));
            .endObject()
            .toString();
                    @Override
/*
    }
            LeafReader leaf = reader.leaves().get(0).reader();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
        assertEquals("a", fields[0].stringValue());
                    public TokenStream create(TokenStream tokenStream) {
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchAnalyzer().name()));
            .endObject()
            .startObject("field")
        mapper = createDocumentMapper("_doc", mapping);
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
            .endObject()
    }
            LeafReader leaf = reader.leaves().get(0).reader();
        assertEquals(1, fields.length);
import org.apache.lucene.analysis.TokenStream;
                b.field("type", "annotated_text");
            b.field("type", "annotated_text");
        analyzers.put("my_stop_analyzer", stop);
            .field("analyzer", "standard")
import org.opensearch.index.analysis.StandardTokenizerFactory;
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
            AnalyzerScope.INDEX,
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectors(), equalTo(true));
    }
        checker.registerUpdateCheck(b -> {
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
            .startObject("properties")
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
                } }
import org.opensearch.index.mapper.MapperParsingException;
                    public String name() {
        IndexableField[] fields = doc.rootDoc().getFields("field");
import org.opensearch.plugins.Plugin;
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorPayloads(), equalTo(false));
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorPositions(), equalTo(true));
    }
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
            .startObject()
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorOffsets(), equalTo(true));
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
import org.apache.lucene.index.Terms;
import org.opensearch.plugin.mapper.AnnotatedTextPlugin;
            .startObject("field")
 * Modifications Copyright OpenSearch Contributors. See
            assertTrue(foundTerms.contains("fox"));
    public void testSearchQuoteAnalyzerSerialization() throws IOException {
            while ((term = iterator.next()) != null) {
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectors(), equalTo(true));
        String text = "the quick [brown](Color) fox jumped over the lazy dog";
        });
            new StandardAnalyzer(),
            .field("type", "annotated_text")
            .endObject()
        assertTrue(fields[0].fieldType().omitNorms());
        for (String option : supportedOptions.keySet()) {
        IndexableField[] fields = doc.rootDoc().getFields("field");
import org.apache.lucene.util.BytesRef;
        assertFalse(fieldType.stored());
import org.apache.lucene.index.TermsEnum;
        b.field("type", "annotated_text");
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
            assertEquals(0, postings.nextPosition());
 * Licensed to Elasticsearch under one or more contributor
            TermsEnum terms = leaf.terms("field").iterator();
        // Use example of typed and untyped annotations
            b.field("field1", "1234");
import org.apache.lucene.analysis.core.KeywordAnalyzer;
    }
        assertEquals("b", fields[1].stringValue());
            b.field("type", "annotated_text");
            b.field("type", "annotated_text");
        assertEquals("b", fields[1].stringValue());
            .field("search_analyzer", "keyword")
            .endObject()
import java.util.Set;
        assertEquals(1, fields.length);
            "default",
            .startObject("properties")
            new CustomAnalyzer(
            .field("type", "annotated_text")
            .toString();
            b.field("type", "annotated_text");
import java.io.IOException;
        }), fieldMapping(b -> {
 *
import org.opensearch.index.analysis.TokenFilterFactory;
        checker.registerConflictCheck("index_options", b -> b.field("index_options", "docs"));
            Terms terms = leaf.terms("field");
        XContentBuilder builder = XContentFactory.jsonBuilder();
 * under the License.
import java.util.Collections;
                    }
            assertEquals(1, postings.nextPosition());
        assertTrue(mappingString.contains("search_quote_analyzer"));
            assertEquals(supportedOptions.get(option), fields[0].fieldType().indexOptions());
        checker.registerConflictCheck("position_increment_gap", b -> b.field("position_increment_gap", 10));
            .toString();
            BytesRef term;
            .startObject("properties")
    public void testAnalyzedFieldPositionIncrementWithoutPositions() {
}
        }, m -> assertEquals("keyword", m.fieldType().getTextSearchInfo().getSearchQuoteAnalyzer().name()));
        mapper = createDocumentMapper("_doc", mapping);
            b.field("norms", true);
            assertEquals(2, postings.nextPosition());
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
            .startObject("properties")
            b.field("position_increment_gap", positionIncrementGap);
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorPayloads(), equalTo(false));
import org.apache.lucene.index.IndexOptions;
            assertTrue(terms.seekExact(new BytesRef("hush")));
        assertTrue(mappingString.contains("analyzer"));
        return new IndexAnalyzers(analyzers, Collections.emptyMap(), Collections.emptyMap());
        assertThat(e.getMessage(), containsString("must not have a [null] value"));
            .endObject()
            assertTrue(terms.seekExact(new BytesRef("bar")));
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(0, postings.nextDoc());
        }));
            .endObject()
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
        analyzers.put("standard", standard);
            b.field("index", false);
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorPayloads(), equalTo(true));
 */
            assertEquals(1, fields.length);
import org.opensearch.index.mapper.MapperService;
            LeafReader leaf = reader.leaves().get(0).reader();
        checker.registerConflictCheck("term_vector", b -> b.field("term_vector", "yes"));
        }));
        IndexableField[] fields = doc.rootDoc().getFields("field");
        createMapperService(fieldMapping(b -> {
            b.field("type", "annotated_text");
    @Override
        });
        assertEquals(1, fields.length);
package org.opensearch.index.mapper.annotatedtext;
            .endObject()
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectors(), equalTo(false));
        assertEquals(mapping, mapper.mappingSource().toString());
            b.field("norms", false);
import java.util.Collection;
            LeafReader leaf = reader.leaves().get(0).reader();
            Set<String> foundTerms = new HashSet<>();
        MapperService mapperService = createMapperService(fieldMapping(this::minimalMapping));
    public void testNullConfigValuesFail() throws MapperParsingException {
            b.nullField("analyzer");
            b.field("field3", "1234");
        builder.value("some text");
        String mapping = XContentFactory.jsonBuilder()
            postings = terms.postings(null, PostingsEnum.POSITIONS);
            DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
            postings = terms.postings(null, PostingsEnum.POSITIONS);
            .toString();
        final int positionIncrementGap = randomIntBetween(1, 1000);
import org.opensearch.core.xcontent.ToXContent;
            assertEquals(0, postings.nextDoc());
        assertEquals(mapping, mapper.mappingSource().toString());
        String mappingString = builder.toString();
        assertThat(fieldType.storeTermVectorPayloads(), equalTo(false));
            assertEquals(0, postings.nextDoc());
        );
        }));
        builder.endObject();
import org.opensearch.index.analysis.CustomAnalyzer;
            .toString();
        MapperService mapperService = createMapperService(fieldMapping(b -> {
 * You may obtain a copy of the License at
        String annotatedText = "He paid [Stormy Daniels](Stephanie+Clifford&Payee) hush money";
            }
            .endObject()
            .startObject("field")
    }
            .field("type", "annotated_text")
            .endObject()
    public void testPositionIncrementGap() throws IOException {
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
                b.field("position_increment_gap", 0);
            .endObject()
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectorOffsets(), equalTo(true));
        assertEquals("a", fields[0].stringValue());
            assertEquals(positionIncrementGap + 1, postings.nextPosition());
            .field("search_quote_analyzer", "keyword")
        checker.registerUpdateCheck(b -> {
        mapper.toXContent(builder, new ToXContent.MapParams(Collections.singletonMap("include_defaults", "true")));
            .endObject()
import org.apache.lucene.index.DocValuesType;
            .startObject()
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        assertEquals(mapping, mapper.mappingSource().toString());
            b.startObject("field2").field("type", "annotated_text").field("term_vector", "yes").endObject();
        checker.registerConflictCheck("similarity", b -> b.field("similarity", "boolean"));
        assertEquals(1, fields.length);
        assertEquals(2, fields.length);
            .endObject()
        checker.registerUpdateCheck(b -> {
            assertEquals(0, postings.nextDoc());
            b.field("analyzer", "default");
import java.util.Arrays;
    public void testDefaults() throws IOException {
        NamedAnalyzer dflt = new NamedAnalyzer(
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorOffsets(), equalTo(false));
    @Override
        analyzers.put("keyword", keyword);
 * ownership. Elasticsearch licenses this file to you under
        mapping = XContentFactory.jsonBuilder()
        DocumentMapper mapper = createDocumentMapper("_doc", mapping);
            b.field("type", "annotated_text");
        assertTrue(fieldType.tokenized());
import java.util.HashSet;
            IndexableField[] fields = doc.rootDoc().getFields("field");
            .field("analyzer", "keyword")
                new CharFilterFactory[0],
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorPositions(), equalTo(true));
import org.apache.lucene.index.LeafReader;
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
        mapper = createDocumentMapper("_doc", mapping);
            .toString();
    }
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
                new TokenFilterFactory[] { new TokenFilterFactory() {
    }
import static org.hamcrest.Matchers.containsString;
import org.opensearch.index.IndexSettings;
import java.util.Map;
            assertTrue(terms.seekExact(new BytesRef("b")));
        // special case: default index/search analyzer
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", text)));
    public void testSearchAnalyzerSerialization() throws IOException {
            b.field("norms", false);
        assertTrue(fields[0].fieldType().stored());
            assertFalse(terms.seekExact(new BytesRef("MissingEndBracket")));
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));
        }));
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.index.PostingsEnum;
            .endObject()
    public void testDefaultPositionIncrementGap() throws IOException {
            b.field("field4", "1234");
        });
            .endObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.analysis.IndexAnalyzers;
        assertEquals(2, fields.length);
        );
import org.opensearch.index.analysis.CharFilterFactory;
        IndexableField[] fields = doc.rootDoc().getFields("field");
        return Collections.singletonList(new AnnotatedTextPlugin());
            .endObject()
            assertTrue(terms.seekExact(new BytesRef("Stephanie Clifford")));
    @Override
            TermsEnum iterator = terms.iterator();
    }
            .endObject()
            PostingsEnum postings = terms.postings(null, PostingsEnum.POSITIONS);
            postings = terms.postings(null, PostingsEnum.POSITIONS);
        Exception e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
    }
            .startObject("properties")
            b.field("type", "annotated_text");
        // norms can be set from true to false, but not vice versa
    protected void minimalMapping(XContentBuilder b) throws IOException {
        }, m -> assertFalse(m.fieldType().getTextSearchInfo().hasNorms()));
        checker.registerConflictCheck("store", b -> b.field("store", true));
        }
        })));
            // Bad markup means value is treated as plain text and fed through tokenisation
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectorPositions(), equalTo(true));
            .field("analyzer", "default")
            .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
import org.apache.lucene.index.IndexableField;
    }
        checker.registerConflictCheck("norms", fieldMapping(b -> {
            .startObject("_doc")
        mapping = XContentFactory.jsonBuilder()
import static org.hamcrest.Matchers.equalTo;
    protected IndexAnalyzers createIndexAnalyzers(IndexSettings indexSettings) {
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", annotatedText)));
            b.startObject("field5").field("type", "annotated_text").field("term_vector", "with_positions_offsets").endObject();
        assertThat(doc.rootDoc().getField("field6").fieldType().storeTermVectors(), equalTo(true));
            b.field("type", "annotated_text");
            .startObject("field")
                        return "stop";
            b.field("norms", false);
 */
    protected Collection<Plugin> getPlugins() {
    }
    protected void assertParseMaximalWarnings() {
        });
        ParsedDocument doc = defaultMapper.parse(source(b -> {
    }
    }
    public void testIndexOptions() throws IOException {
        ParsedDocument doc = mapper.parse(source(b -> b.field("field", "1234")));
            .endObject()
            assertEquals(0, postings.nextDoc());
            .field("search_analyzer", "standard")
import org.opensearch.common.xcontent.XContentFactory;
            assertEquals(2, postings.nextPosition());
            .endObject()
import org.opensearch.index.mapper.MapperTestCase;
            TermsEnum terms = leaf.terms("field").iterator();
        assertEquals(DocValuesType.NONE, fieldType.docValuesType());
        // special case: default search analyzer
            assertEquals(0, postings.nextDoc());
            .field("analyzer", "standard")
 * this work for additional information regarding copyright
            .endObject()
import org.opensearch.index.mapper.ParsedDocument;
            .field("search_quote_analyzer", "keyword")
        mapping = XContentFactory.jsonBuilder()
            .field("type", "annotated_text")
            .startObject("properties")
            })));
                b.field("type", "annotated_text");
        assertEquals(1, fields.length);
                        return new StopFilter(tokenStream, EnglishAnalyzer.ENGLISH_STOP_WORDS_SET);
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));
    }
    public void testTermVectors() throws IOException {
            .field("type", "annotated_text")
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorPositions(), equalTo(false));
    }
            assertTrue(foundTerms.contains("Color"));
            b.field("search_quote_analyzer", "keyword");
/*
        String annotatedText = "foo [bar](MissingEndBracket baz";
                    }
            b.field("search_analyzer", "keyword");
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.array("field", "a", "b")));
        assertWarnings("Parameter [index] has no effect on type [annotated_text] and will be removed in future");
        IndexableFieldType fieldType = fields[0].fieldType();
        NamedAnalyzer stop = new NamedAnalyzer(
        assertEquals(annotatedText, fields[0].stringValue());
            assertEquals(0, postings.nextDoc());
    @Override
            .field("search_analyzer", "default")
            .startObject("_doc")
    }
        checker.registerConflictCheck("analyzer", b -> b.field("analyzer", "keyword"));
        supportedOptions.put("freqs", IndexOptions.DOCS_AND_FREQS);
    }
        assertThat(fieldType.storeTermVectorPositions(), equalTo(false));
    }
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
            .startObject("_doc")
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");
    protected void registerParameters(ParameterChecker checker) throws IOException {
            b.field("field2", "1234");
        assertThat(doc.rootDoc().getField("field5").fieldType().storeTermVectorPayloads(), equalTo(false));
        DocumentMapper mapper = createDocumentMapper(fieldMapping(b -> {
            .startObject()
/*
            .startObject("field")
            .startObject()
            b.startObject("field3").field("type", "annotated_text").field("term_vector", "with_offsets").endObject();
        IndexableField[] fields = doc.rootDoc().getFields("field");
            .startObject()
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            )
 * KIND, either express or implied.  See the License for the
    public void testAnnotationInjection() throws IOException {
            .toString();
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorPositions(), equalTo(false));
        }));
            b.field("type", "annotated_text");
                foundTerms.add(term.utf8ToString());
            TextFieldMapper.Defaults.POSITION_INCREMENT_GAP
        analyzers.put("default", dflt);
        for (String indexOptions : Arrays.asList("docs", "freqs")) {
                b.field("index_options", indexOptions);
 * Unless required by applicable law or agreed to in writing,
            b.field("norms", true);
        assertEquals("1234", fields[0].stringValue());
        DocumentMapper mapper = createDocumentMapper("_doc", mapping);
        assertThat(fieldType.storeTermVectorOffsets(), equalTo(false));
        builder.startObject();
    public void testIndexedTermVectors() throws IOException {
    }
 * license agreements. See the NOTICE file distributed with
        assertThat(doc.rootDoc().getField("field2").fieldType().storeTermVectorOffsets(), equalTo(false));
            b.field("term_vector", "with_positions_offsets_payloads");
            .endObject()
            .startObject()
            assertTrue(terms.seekExact(new BytesRef("stormy")));
            .field("search_analyzer", "keyword")
import org.apache.lucene.index.IndexableFieldType;
            .endObject()
        }));
            assertTrue(terms.seekExact(new BytesRef("missingendbracket")));
        assertThat(doc.rootDoc().getField("field4").fieldType().storeTermVectors(), equalTo(true));
            TermsEnum terms = leaf.terms("field").iterator();
import java.util.HashMap;
            assertEquals(0, postings.nextDoc());
        mapping = XContentFactory.jsonBuilder()
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorPositions(), equalTo(false));
            assertTrue(foundTerms.contains("brown"));
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
            assertEquals(TextFieldMapper.Defaults.POSITION_INCREMENT_GAP + 1, postings.nextPosition());
            .endObject()
        supportedOptions.put("positions", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
    @Override
            TermsEnum terms = leaf.terms("field").iterator();
 *
            assertEquals(2, postings.nextPosition());
        DocumentMapper defaultMapper = createDocumentMapper(mapping(b -> {
        assertThat(doc.rootDoc().getField("field3").fieldType().storeTermVectorOffsets(), equalTo(true));
        assertEquals(mapping, mapper.mappingSource().toString());
            Exception e = expectThrows(MapperParsingException.class, () -> createMapperService(fieldMapping(b -> {
 * specific language governing permissions and limitations
        }));
    public void testDisableNorms() throws IOException {
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorPayloads(), equalTo(false));
            .field("analyzer", "keyword")
        assertThat(doc.rootDoc().getField("field1").fieldType().storeTermVectorOffsets(), equalTo(false));
            }));
            .startObject()
import org.opensearch.index.analysis.NamedAnalyzer;
            .startObject("_doc")
            .endObject()
                b.field("index_options", option);
            .endObject()
            postings = terms.postings(null, PostingsEnum.POSITIONS);
            .startObject("_doc")
public class AnnotatedTextFieldMapperTests extends MapperTestCase {
        mapper = createDocumentMapper("_doc", mapping);
        assertThat(fieldType.omitNorms(), equalTo(false));
            "my_stop_analyzer",
            .startObject("field")
import org.opensearch.index.mapper.TextFieldMapper;
            assertTrue(terms.seekExact(new BytesRef("b")));
            AnalyzerScope.INDEX,
            b.field("type", "annotated_text");
        });
        assertEquals(annotatedText, fields[0].stringValue());
        supportedOptions.put("offsets", IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
        }));
    public void testEnableStore() throws IOException {
        assertThat(fieldType.storeTermVectors(), equalTo(false));
    public void testToleranceForBadAnnotationMarkup() throws IOException {
            b.startObject("field6").field("type", "annotated_text").field("term_vector", "with_positions_offsets_payloads").endObject();
        mapper = createDocumentMapper("_doc", mapping);
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.opensearch.index.analysis.AnalyzerScope;
        assertEquals(mapping, mapper.mappingSource().toString());
        Map<String, IndexOptions> supportedOptions = new HashMap<>();
        NamedAnalyzer standard = new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer());
            .startObject("_doc")
        assertEquals(mapping, mapper.mappingSource().toString());
            .field("analyzer", "default")
            .startObject("properties")
            .startObject("_doc")
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.array("field", "a", "b")));
        // special case: default index analyzer
        withLuceneIndex(mapperService, iw -> iw.addDocument(doc.rootDoc()), reader -> {
        assertThat(fieldType.indexOptions(), equalTo(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS));
    @Override
            .field("type", "annotated_text")
            .endObject()
            assertTrue(terms.seekExact(new BytesRef("foo")));
            // Check we have both text and annotation tokens
        }
    }
        assertTrue(mappingString.contains("search_analyzer"));
 * SPDX-License-Identifier: Apache-2.0
                    @Override
        analyzers.put("whitespace", whitespace);
            b.startObject("field4").field("type", "annotated_text").field("term_vector", "with_positions").endObject();
        }, b -> {
        NamedAnalyzer keyword = new NamedAnalyzer("keyword", AnalyzerScope.INDEX, new KeywordAnalyzer());
        mapping = XContentFactory.jsonBuilder()
                new StandardTokenizerFactory(indexSettings, null, "standard", indexSettings.getSettings()),
    public void testNotIndexedField() throws IOException {
            .field("search_analyzer", "default")
            LeafReader leaf = reader.leaves().get(0).reader();
        NamedAnalyzer whitespace = new NamedAnalyzer("whitespace", AnalyzerScope.INDEX, new WhitespaceAnalyzer());
import org.apache.lucene.analysis.en.EnglishAnalyzer;
            .startObject("field")
            .endObject()
            b.field("store", true);
        Map<String, NamedAnalyzer> analyzers = new HashMap<>();
            .field("type", "annotated_text")
            b.field("analyzer", "default");
        IndexableField[] fields = doc.rootDoc().getFields("field");
            b.field("field6", "1234");
        String mapping = XContentFactory.jsonBuilder()
            b.field("field5", "1234");
            assertTrue(terms.seekExact(new BytesRef("Payee")));
            b.field("search_analyzer", "keyword");
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("field", annotatedText)));
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            assertEquals(4, postings.nextPosition());
