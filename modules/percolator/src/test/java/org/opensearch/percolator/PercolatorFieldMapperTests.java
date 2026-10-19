        fieldMapper.processQuery(bq.build(), parseContext);
        Rewriteable.rewriteAndFetch(queryBuilder, shardContext, future);
        range = rangesMap.get("number_field3");
            .endObject()
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
                new SourceToParse(
        assertThat(fields.get(0).binaryValue().utf8ToString(), equalTo("field\u0000term1"));
                    "1",  
            .endObject()
            .endObject()
                // Query builder's content is stored via BinaryFieldMapper, which has a custom encoding
            .field("type", "text")  
            query.endObject();  
                                .startArray("object_field")
                    MediaTypeRegistry.JSON
                    MediaTypeRegistry.JSON
        DocumentMapper documentMapper = mapperService.documentMapper();
        assertThat(fields.size(), equalTo(1));
        assertThat(fields.get(0).numericValue(), equalTo(1L));
        } catch (MapperParsingException e) {  
        Map<String, List<byte[]>> rangesMap = t.v2();
            .collect(Collectors.toList());
    }
        assertThat(t.v1().clauses().get(2).query().toString(), containsString(fieldName + ".extraction_result:failed"));
                            .startObject()
                        "test",
 *    http://www.apache.org/licenses/LICENSE-2.0
                )  
                default:
            query.field("source", "return true");
                    "1",
            int encodingType = randomInt(1);
            .field("type", "percolator")
        try (InputStream in = new ByteArrayInputStream(querySource.bytes, querySource.offset, querySource.length)) {
        fields.sort(Comparator.comparing(IndexableField::binaryValue));
            }
import static org.opensearch.index.query.QueryBuilders.termQuery;
            .endObject()
        assertEquals(20L, LongPoint.decodeDimension(range.get(1), 0));  
                        MediaTypeRegistry.JSON  
        for (int i = 0; i < 1022; i++) {
                    IntPoint.encodeDimension(randomTo, encodedTo, 0);
        range = rangesMap.get("number_field5");  
/*  
        IndexableField queryBuilderField = doc.rootDoc().getField("object_field.query_field.query_builder_field");
        addQueryFieldMappings();
            .startObject("")
import java.nio.ByteBuffer;
            mapperService.documentMapper()  
        assertThat(t.v1().clauses().get(0).query(), instanceOf(CoveringQuery.class));
/*
            .numberOfShards(1)
            .startObject("field")
            .endObject()
        ParsedDocument doc = mapperService.documentMapper()
import static org.opensearch.percolator.PercolatorFieldMapper.EXTRACTION_FAILED;
            try (StreamInput input = new NamedWriteableAwareStreamInput(new InputStreamStreamInput(in), writableRegistry())) {  
            .field("type", "text")  
                    ),
            .endObject()
        assertEquals("field1\u0000the", terms.get(9).utf8ToString());
            .toString();
        assertThat(fields.get(1).binaryValue().utf8ToString(), equalTo("field\u0000term2"));
        DocumentMapper documentMapper = mapperService.documentMapper();  
                                .endArray()  
        );
            }  
        assertThat(e.getMessage(), containsString("name cannot be empty string"));
            null
        addQueryFieldMappings();  
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.minimumShouldMatchField.name())));
                    .getScoreFunction();
        }
        ParseContext.InternalParseContext parseContext = new ParseContext.InternalParseContext(
        assertEquals("_field3\u0000unhide", terms.get(1).utf8ToString());
            () -> { throw new UnsupportedOperationException(); },
                        MediaTypeRegistry.JSON
import org.opensearch.common.network.InetAddresses;
        String percolatorMapper = XContentFactory.jsonBuilder()
        assertThat(document.getFields().get(0).binaryValue().utf8ToString(), equalTo("field\u0000term"));
        List<byte[]> range = rangesMap.get("number_field1");
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, qb).endObject()),
        assertThat(LongPoint.decodeDimension(fields.get(1).binaryValue().bytes, 24), equalTo(20L));  
        indexService = createIndex("test");
        StringBuilder text = new StringBuilder();  
        assertEquals("field1\u0000lazy", terms.get(6).utf8ToString());
            .field("type", "percolator")
                    LongPoint.encodeDimension(randomFrom, encodedFrom, 0);  
        }
            try (StreamInput input = new NamedWriteableAwareStreamInput(new InputStreamStreamInput(in), writableRegistry())) {
        assertEquals("field1\u0000jumps", terms.get(5).utf8ToString());  
            .parse(
        );
        memoryIndex.addField(new LongPoint("number_field2", 10L), new WhitespaceAnalyzer());
        ParsedDocument doc = mapperService.documentMapper()
        memoryIndex.addField(new FloatPoint("number_field5", 40f), new WhitespaceAnalyzer());  
    }
        int iters = randomIntBetween(32, 256);
        bq.add(rangeQuery2, Occur.MUST);  
 */  
        PercolatorFieldMapper.PercolatorFieldType fieldType = (PercolatorFieldMapper.PercolatorFieldType) fieldMapper.fieldType();
            .toString();
        PercolatorFieldMapper fieldMapper = (PercolatorFieldMapper) documentMapper.mappers().getMapper(fieldName);  
        msm = doc.rootDoc().getFields(fieldType.minimumShouldMatchField.name())[0].numericValue().intValue();  
            .build();
                    BytesReference.bytes(  
            .parse(  
            .field("type", "object")  
        addQueryFieldMappings();
        TermQuery termQuery2 = new TermQuery(new Term("field", "term2"));
        doc = mapperService.documentMapper()
            .field("type", "integer")  
                        "1",
    private static byte[] subByteArray(byte[] source, int offset, int length) {
                MapperService.MergeReason.MAPPING_UPDATE
    }
        // note: it important that range queries never rewrite, otherwise it will cause results to be wrong.
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_PARTIAL));
 * You may obtain a copy of the License at  
                MapperService.SINGLE_MAPPING_NAME,
                    )
        }
            .endObject()
        assertNotNull(range);  
            .should(boolQuery().should(termQuery("field", "value1")).should(termQuery("field", "value2")))  
        assertThat(fields.size(), equalTo(2));  
        QueryBuilder queryBuilder = matchQuery("field", "value");
                    )
            settings,  
        assertThat(values.get(1), equalTo("field\0value2"));  
        BytesRef qbSource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();  
            .toString();  
            .startObject("query_field")
            .parse(  
                .parse(
        queryBuilderAsBytes = doc.rootDoc().getField("object_field.query_field.query_builder_field").binaryValue();  
        assertThat(IntPoint.decodeDimension(fields.get(0).binaryValue().bytes, 28), equalTo(20));
            .field("type", "date")  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                    "1",
                .parse(
                new SourceToParse(  
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name()).length, equalTo(1));
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(new ConstantScoreQueryBuilder(hasChildQuery)));  
            .numberOfShards(1)
            mapperService.documentMapper()  
                // Query builder's content is stored via BinaryFieldMapper, which has a custom encoding
        String percolatorMapper = XContentFactory.jsonBuilder()
            IllegalArgumentException.class,
 * compatible open source license.
        assertQueryBuilder(queryBuilderAsBytes, queryBuilder);
        assertThat(fields.size(), equalTo(1));
        HasChildQueryBuilder hasChildQuery = new HasChildQueryBuilder("parent", new MatchAllQueryBuilder(), ScoreMode.None);
            .startObject("properties")
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.rangeField.name())));  
                    new SourceToParse(
        assertThat(doc.rootDoc().getFields(fieldType.queryTermsField.name())[0].binaryValue().utf8ToString(), equalTo("field\0value"));  
            termQuery("field", "value"),  
import java.io.InputStream;  
            .build();  
            prefixQuery("field", "v"),
        assertThat(doc.rootDoc().getFields(fieldType.queryBuilderField.name()).length, equalTo(1));  
import static org.hamcrest.Matchers.containsString;
        HasParentQueryBuilder hasParentQuery = new HasParentQueryBuilder("parent", new MatchAllQueryBuilder(), false);  
        DocumentMapperParser parser = mapperService.documentMapperParser();
                // then the length of the field value in bytes.
                        "1",
        query.endObject();
        memoryIndex.addField(new HalfFloatPoint("number_field4", 30f), new WhitespaceAnalyzer());
            .startObject()
    }
    }
                    assertEquals(hash.h1, ByteBuffer.wrap(subByteArray(result, 0, 8)).getLong());
        assertEquals("field2\u0000text", terms.get(12).utf8ToString());
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            .should(boolQuery().should(termQuery("field", "value2")).should(termQuery("field", "value3")))
        // (it can't use shard data for rewriting purposes, because percolator queries run on MemoryIndex)  
                    "test",  
import org.apache.lucene.index.IndexableField;
        DocumentMapper documentMapper = mapperService.documentMapper();  
        memoryIndex.addField(new InetAddressPoint("number_field7", InetAddresses.forString("192.168.1.12")), new WhitespaceAnalyzer());
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.minimumShouldMatchField.name())));
                QueryBuilder queryBuilder = input.readNamedWriteable(QueryBuilder.class);
        MapperParsingException e = expectThrows(
            .must(boolQuery().must(termQuery("field", "value3")).must(termQuery("field", "value4")))
        qbSource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();
            switch (encodingType) {
        );  
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.minimumShouldMatchField.name())));  
        );
    private MapperService mapperService;  
        IllegalArgumentException e = expectThrows(
                    "test",
                    assertEquals(randomFrom, LongPoint.decodeDimension(subByteArray(result, 8, 8), 0));
        values = Arrays.stream(doc.rootDoc().getFields(fieldType.queryTermsField.name()))
        assertThat(values.get(0), equalTo("field\0value1"));
    public void testStoringQueries() throws Exception {  
                    "test",  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            text.append(i).append(' ');
            query.field("script", "return true");
 * GitHub history for details.
            () -> mapperService.merge(
        assertThat(IntPoint.decodeDimension(fields.get(0).binaryValue().bytes, 12), equalTo(10));
        assertQueryBuilder(qbSource, queryBuilder);
import org.apache.lucene.search.Query;
            null,
        parseContext = new ParseContext.InternalParseContext(settings, mapperService.documentMapperParser(), documentMapper, null, null);
            .build();
                            .endObject()
            );
        ParseContext.InternalParseContext parseContext = new ParseContext.InternalParseContext(
                new SourceToParse(
            )
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_COMPLETE));  
        assertTrue(extractionResultField.fieldType().omitNorms());
        bq.add(rangeQuery1, Occur.MUST);  
                .parse(
import org.apache.lucene.index.IndexReader;
            .endObject()
    }
public class PercolatorFieldMapperTests extends OpenSearchSingleNodeTestCase {
                )
        Tuple<List<BytesRef>, Map<String, List<byte[]>>> t = fieldType.extractTermsAndRanges(indexReader);
            .must(boolQuery().must(termQuery("field", "value2")).must(termQuery("field", "value3")));
        return getInstanceFromNode(NamedWriteableRegistry.class);  
                )
        List<BytesRef> terms = t.v1();
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
import org.apache.lucene.search.join.ScoreMode;
            null,
        assertTrue(t.v2());
        addQueryFieldMappings();
            .endObject()
            final int randomFrom = randomInt();  
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name())[0].stringValue(), equalTo(EXTRACTION_COMPLETE));  
import org.opensearch.core.xcontent.XContentBuilder;
            null
                    assertEquals(hash.h1, ByteBuffer.wrap(subByteArray(result, 16, 8)).getLong());  
        assertFalse(t.v2());  
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);
import org.opensearch.index.mapper.MapperParsingException;
 */  
                    BytesReference.bytes(
        assertEquals(30L, LongPoint.decodeDimension(range.get(0), 0));
            .map(f -> f.binaryValue().utf8ToString())
        );  
                        BytesReference.bytes(XContentFactory.jsonBuilder().startObject().nullField(fieldName).endObject()),
                    "test",  
            .startObject(fieldName)
        assertThat(doc.rootDoc().getFields(fieldType.queryTermsField.name()).length, equalTo(0));
        ParseContext.InternalParseContext parseContext = new ParseContext.InternalParseContext(  
            .startObject("field4")
                    "test",
                        "test",  
            null,  
            final byte[] encodedFrom;
            .startObject("properties")  
            mapperService.documentMapperParser(),  
        QueryShardContext shardContext = indexService.newQueryShardContext(
                // to encode multiple binary values into a single binary doc values field.
            .field("type", "long")  
                );
        PhraseQuery phraseQuery = new PhraseQuery("field", "term");
    @Before  
package org.opensearch.percolator;
            .startObject("properties")
                        ),
                        jsonBuilder().startObject().field("query_field1", queryBuilder).field("query_field2", queryBuilder).endObject()  
                    MediaTypeRegistry.JSON  
                            XContentFactory.jsonBuilder().startObject().field(fieldName, termQuery("unmapped_field", "value")).endObject()  
 */
        assertEquals("field1\u0000quick", terms.get(8).utf8ToString());  
import org.apache.lucene.util.BytesRef;  
        assertThat(IntPoint.decodeDimension(fields.get(1).binaryValue().bytes, 12), equalTo(15));  
    protected NamedWriteableRegistry writableRegistry() {
        fieldMapper.processQuery(bq.build(), parseContext);
        memoryIndex.addField(new LongPoint("number_field3", 30L), new WhitespaceAnalyzer());
        assertEquals(1, rangesMap.size());  
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name())[0].stringValue(), equalTo(EXTRACTION_FAILED));  
        Tuple<BooleanQuery, Boolean> t = fieldType.createCandidateQuery(indexReader, Version.CURRENT);
            .endObject()
        ParseContext.InternalParseContext parseContext = new ParseContext.InternalParseContext(
                new SourceToParse(
        PercolatorFieldMapper fieldMapper = (PercolatorFieldMapper) documentMapper.mappers().getMapper(fieldName);
        BytesRef querySource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();
                    encodedFrom = new byte[Integer.BYTES];
        XContentBuilder query = jsonBuilder();
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(new BoolQueryBuilder().must(hasParentQuery)));
import org.opensearch.plugins.Plugin;  
    }  
import org.opensearch.index.mapper.ParsedDocument;
        PercolatorFieldMapper.PercolatorFieldType fieldType = (PercolatorFieldMapper.PercolatorFieldType) fieldMapper.fieldType();  
        // Now push it over the edge, so that it falls back using TermInSetQuery
import org.apache.lucene.sandbox.document.HalfFloatPoint;
            .endObject()  
            settings,
            .startObject(fieldName)
            .parse(
            .startObject("date_field")
    }  
    public void testAllowNoAdditionalSettings() throws Exception {
        QueryShardContext context = createSearchContext(indexService).getQueryShardContext();  
        assertThat(fields.get(1).binaryValue().utf8ToString(), equalTo("field\u0000term2"));
        String mapping = XContentFactory.jsonBuilder()  
                            .field("query_field", queryBuilder)  
            .startObject()
                    )  
        fieldType = (PercolatorFieldMapper.PercolatorFieldType) mapperService.fieldType(fieldName);  
                    "test",
        assertEquals("field2\u0000some", terms.get(11).utf8ToString());  
        addQueryFieldMappings();
            BytesRef fieldAsBytesRef = new BytesRef(fieldName);
        memoryIndex.addField("field1", "the quick brown fox jumps over the lazy dog", new WhitespaceAnalyzer());
        if (randomBoolean()) {
                                .field("query_field", queryBuilder)
        assertThat(t.v1().clauses().get(1).query().toString(), containsString(fieldName + ".range_field:<ranges:"));
            }
        doc = mapperService.documentMapper()
    public void testCreateCandidateQuery_oldIndex() throws Exception {
        doc = mapperService.documentMapper()  
            settings,
 * SPDX-License-Identifier: Apache-2.0
            matchQuery("field", "value"),
        addQueryFieldMappings();  
    private PercolatorFieldMapper.PercolatorFieldType fieldType;
import org.opensearch.index.query.ScriptQueryBuilder;
                                .startObject()  
        int msm = doc.rootDoc().getFields(fieldType.minimumShouldMatchField.name())[0].numericValue().intValue();
import org.opensearch.common.collect.Tuple;
import static org.opensearch.index.query.QueryBuilders.wildcardQuery;  
        QueryBuilder queryBuilder = matchQuery("field", "value");
                                .field("query_field", queryBuilder)
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);  
        range = rangesMap.get("number_field7");
            mapperService.documentMapper()
        queryBuilder = rangeQuery("date_field").from("now");
import org.opensearch.index.query.Rewriteable;  
                case 1:  
import org.opensearch.index.mapper.MapperService;
        }  
            switch (encodingType) {
            BytesRef qbSource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();  
            .parse(
                case 0:  
        query.startObject("script_score");
        assertNotNull(range);  
            MapperParsingException.class,  
        MemoryIndex memoryIndex = new MemoryIndex(false);
            settings,
    }  
        memoryIndex.addField(new DoublePoint("number_field6", 50f), new WhitespaceAnalyzer());
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.opensearch.index.mapper.SourceToParse;
        try {
            final byte[] encodedTo;
        String typeName = MapperService.SINGLE_MAPPING_NAME;  
        assertEquals(30L, LongPoint.decodeDimension(range.get(1), 0));
            null  
import java.util.Map;
            .startObject("type1")
    public void testExtractTermsAndRanges_numberFields() throws Exception {
            .endObject()
                    break;  
            return Script.DEFAULT_SCRIPT_LANG;  
        ParseContext.Document document = parseContext.doc();  
        qb = boolQuery().must(boolQuery().must(termQuery("field", "value1")).must(termQuery("field", "value2")))
            randomInt(20),
        bq.add(termQuery1, Occur.SHOULD);
        t = fieldType.createCandidateQuery(indexReader, Version.CURRENT);
import java.util.Arrays;  
        ParsedDocument doc = mapperService.documentMapper()  
        assertThat(doc.rootDoc().getFields(fieldType.queryBuilderField.name()).length, equalTo(0));  
        mapperService.merge(typeName, new CompressedXContent(percolatorMapper), MapperService.MergeReason.MAPPING_UPDATE);  
        );
        memoryIndex.addField("field2", "value", new WhitespaceAnalyzer());  
            .startObject("number_field2")
        fieldMapper.processQuery(query, parseContext);
        addQueryFieldMappings();
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, queryBuilder).endObject()),
            .startObject(typeName)  
    }  
import java.io.ByteArrayInputStream;
            return Collections.singletonMap("return true", (vars) -> true);
    // multiple percolator fields are allowed in the mapping, but only one field can be used at index time.
        IndexMetadata build = IndexMetadata.builder("")
                    BytesReference.bytes(
        String percolatorMapper = XContentFactory.jsonBuilder()
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
            documentMapper,  
        assertThat(exception.getMessage(), containsString("should not be invoked"));
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name()).length, equalTo(1));  
        bq.add(rangeQuery1, Occur.MUST);
            );  
        assertQueryBuilder(queryBuilderAsBytes, queryBuilder);
        assertEquals(1023, terms.getTermsCount());  
        fieldMapper.processQuery(bq.build(), parseContext);
            );
        bq.add(termQuery1, Occur.MUST);
            query.endObject();
import org.apache.lucene.search.TermQuery;  
import org.opensearch.Version;
    }
        return pluginList(
            .startObject("number_field5")
                            .endObject()
            .endObject()  
        fields.sort(Comparator.comparing(IndexableField::binaryValue));
 * ownership. Elasticsearch licenses this file to you under  
                    "test",
import java.util.Collection;
            null,
        IndexReader indexReader = memoryIndex.createSearcher().getIndexReader();  
        QueryBuilder qb = boolQuery().must(boolQuery().must(termQuery("field", "value1")).must(termQuery("field", "value2")))  
        assertQueryBuilder(qbSource, queryBuilder);
        PercolatorFieldMapper fieldMapper = (PercolatorFieldMapper) documentMapper.mappers().getMapper(fieldName);
                input.readVInt();
            .endObject()
            .parse(
        TermRangeQuery query = new TermRangeQuery("field1", new BytesRef("a"), new BytesRef("z"), true, true);  
                        BytesReference.bytes(  
            InternalSettingsPlugin.class,  
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(hasParentQuery));
        return Arrays.copyOfRange(source, offset, offset + length);
                    "1",  
import org.opensearch.join.query.HasChildQueryBuilder;
            .build();
            );  
    }
                    assertEquals(randomFrom, IntPoint.decodeDimension(subByteArray(result, 12, 4), 0));
            .field("index", "no")  
import static org.opensearch.index.query.QueryBuilders.rangeQuery;  
            PercolatorModulePlugin.class,
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);
import org.opensearch.index.IndexService;  
        query.endObject();
        document = parseContext.doc();  
        range = rangesMap.get("number_field6");
                    BytesReference.bytes(
            UnsupportedOperationException.class,
                    new SourceToParse(
            .endObject()  
import org.apache.lucene.sandbox.search.CoveringQuery;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        PercolatorFieldMapper fieldMapper = (PercolatorFieldMapper) documentMapper.mappers().getMapper(fieldName);  
        assertQueryBuilder(queryBuilderAsBytes, queryBuilder);
    public void testExtractTermsAndRanges_failed() throws Exception {
        public String pluginScriptLang() {
        assertNotNull(range);
                        MediaTypeRegistry.JSON  
        assertEquals(InetAddresses.forString("192.168.1.24"), InetAddressPoint.decode(range.get(1)));
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
            .parse(
import org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder;
                    encodedFrom = new byte[Long.BYTES];
        query.endObject();
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(new DisMaxQueryBuilder().add(hasChildQuery)));
    }  
                input.readVInt();
        doc = mapperService.documentMapper()  
            .parse(
        bq.add(termQuery2, Occur.MUST);
        doc = mapperService.documentMapper()
import org.apache.lucene.search.PhraseQuery;  
        assertThat(doc.rootDoc().getFields(fieldType.queryBuilderField.name()).length, equalTo(1));
        assertThat(document.getFields().size(), equalTo(4));
        assertThat(LongPoint.decodeDimension(fields.get(1).binaryValue().bytes, 8), equalTo(15L));
        memoryIndex.addField("field1", "value1", new WhitespaceAnalyzer());  
        UnsupportedOperationException exception = expectThrows(
import org.opensearch.index.query.QueryBuilder;
                );
        DocumentMapper documentMapper = mapperService.documentMapper();
            IllegalArgumentException.class,
                // then the length of the field value in bytes.
import org.opensearch.common.settings.Settings;
            .sorted()
                    "test",
import java.util.function.Function;  
        assertThat(IntPoint.decodeDimension(fields.get(0).binaryValue().bytes, 12), equalTo(10));  
import org.apache.lucene.document.FloatPoint;  
        BytesRef qbSource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();
            final int randomTo = randomIntBetween(randomFrom, Integer.MAX_VALUE);  
            .parse(  
            );
        );
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, queryBuilder).endObject()),  
import org.opensearch.action.support.PlainActionFuture;
            .numberOfReplicas(0)
        addQueryFieldMappings();
                            .startObject()
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, queryBuilder).endObject()),
        assertThat(fields.size(), equalTo(1));
                        "1",
            null
                // This is the reason we need to first need to read the number of values and
        bq.add(termQuery2, Occur.SHOULD);  
        assertEquals(40F, FloatPoint.decodeDimension(range.get(1), 0), 0F);  
            .startObject("number_field3")
import java.io.IOException;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
        assertEquals(30F, HalfFloatPoint.decodeDimension(range.get(0), 0), 0F);  
        assertThat(values.get(3), equalTo("field\0value4"));
                    "test",  
        assertThat(doc.rootDoc().getFields().size(), equalTo(12)); // also includes all other meta fields
            .must(boolQuery().must(termQuery("field", "value2")).must(termQuery("field", "value3")))  
            );
            .startObject()
            .toString();
        addQueryFieldMappings();
        assertThat(fields.get(0).numericValue(), equalTo(2L));
 * not use this file except in compliance with the License.
        MapperParsingException exception = expectThrows(MapperParsingException.class, () -> {
        addQueryFieldMappings();  
            .should(boolQuery().should(termQuery("field", "value4")).should(termQuery("field", "value5")));  
        for (int i = 0; i < iters; i++) {  
        assertNotNull(range);
                input.readVInt();  
            .startObject("field2")
    public void testParseCreateFieldForPluggableFormat() throws Exception {
import org.opensearch.join.ParentJoinModulePlugin;  
            .endObject()
                )
import org.apache.lucene.search.TermInSetQuery;
        query.startObject("function_score");
                    "test",
    // percolator field can be nested under an object field, but only one query can be specified per document
                    "1",
            documentMapper,
            () -> fieldMapper.parseCreateFieldForPluggableFormat(null)  
        query.startObject();
        rangeQuery2 = mapperService.fieldType("number_field2").rangeQuery(15, 20, true, true, null, null, null, context);
import org.apache.lucene.document.IntPoint;
                        "1",
            .startObject("number_field4")
            .parse(
            );
    public void testDuplicatedClauses() throws Exception {  
 * software distributed under the License is distributed on an
                    ),  
    public void testPercolatorFieldMapperUnMappedField() throws Exception {  
import org.opensearch.cluster.metadata.IndexMetadata;  
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(new BoolQueryBuilder().must(hasChildQuery)));
        queryBuilderAsBytes = doc.rootDoc().getField("query_field2.query_builder_field").binaryValue();  
import org.opensearch.index.query.MatchAllQueryBuilder;
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.queryTermsField.name())));  
        memoryIndex.addField(new InetAddressPoint("number_field7", InetAddresses.forString("192.168.1.24")), new WhitespaceAnalyzer());
 * Licensed to Elasticsearch under one or more contributor  
        bq = new BooleanQuery.Builder();  
    }
            query.startObject("script");  
        assertEquals("field1\u0000dog", terms.get(3).utf8ToString());
                            .rawField(fieldName, new BytesArray(query.toString()).streamInput(), query.contentType())  
            try (StreamInput input = new NamedWriteableAwareStreamInput(new InputStreamStreamInput(in), writableRegistry())) {
        mapperService.merge(typeName, new CompressedXContent(percolatorMapper), MapperService.MergeReason.MAPPING_UPDATE);
                    MediaTypeRegistry.JSON
import java.util.stream.Collectors;
        assertThat(IntPoint.decodeDimension(fields.get(1).binaryValue().bytes, 28), equalTo(20));
import org.apache.lucene.document.LongPoint;  
import org.opensearch.common.hash.MurmurHash3;  
            .startObject("properties")  
                    assertEquals(hash.h1, ByteBuffer.wrap(subByteArray(result, 0, 8)).getLong());
        assertEquals("field1\u0000over", terms.get(7).utf8ToString());
                    LongPoint.encodeDimension(randomTo, encodedTo, 0);  
        IndexReader indexReader = memoryIndex.createSearcher().getIndexReader();
        query.endArray();  
        assertThat(values.get(2), equalTo("field\0value3"));  
        range = rangesMap.get("number_field2");  
                ScriptScoreFunctionBuilder function = (ScriptScoreFunctionBuilder) queryBuilder.filterFunctionBuilders()[0]  
                new SourceToParse(
        values = Arrays.stream(doc.rootDoc().getFields(fieldType.queryTermsField.name()))
        addQueryFieldMappings();
            documentMapper,
        String mapper = XContentFactory.jsonBuilder()
                        ),
    }  
            .endObject()  
        ParsedDocument doc = mapperService.documentMapper()  
    public void testPercolatorFieldMapper_noQuery() throws Exception {
    public void testMultiplePercolatorFields() throws Exception {
        expectThrows(
        assertThat(values.size(), equalTo(3));
    }
        BytesRef queryBuilderAsBytes = queryBuilderField.binaryValue();  
            );
        ParsedDocument doc = mapperService.documentMapper()  
        );
 * KIND, either express or implied.  See the License for the
        terms.sort(BytesRef::compareTo);
        assertEquals("field1\u0000brown", terms.get(2).utf8ToString());  
            .endObject()
                            .endObject()  
                            .startArray("object_field")
            .field("type", "percolator")  
                    "test",  
        assertThat(values.get(2), equalTo("field\0value3"));
                )
            .endObject()
        query = jsonBuilder();  
                    assertEquals(randomTo, LongPoint.decodeDimension(subByteArray(result, 24, 8), 0));
import org.opensearch.common.xcontent.XContentFactory;  
 * Modifications Copyright OpenSearch Contributors. See
                    "1",
            .numberOfReplicas(0)  
        assertTrue(t.v2());  
                                .startObject()  
        assertThat(values.get(1), equalTo("field\0value2"));
            .toString();
import static org.opensearch.percolator.PercolatorFieldMapper.EXTRACTION_COMPLETE;
        qb = boolQuery().minimumShouldMatch(3)
    }
            );
        PercolatorFieldMapper.PercolatorFieldType fieldType = (PercolatorFieldMapper.PercolatorFieldType) fieldMapper.fieldType();
    private void addQueryFieldMappings() throws Exception {
            .startObject("properties")
        );
        querySource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();  
            .startObject("properties")
                )
        assertThat(IntPoint.decodeDimension(fields.get(0).binaryValue().bytes, 28), equalTo(20));
        MapperService mapperService = indexService.mapperService();
                        "test",  
        assertEquals(1, t.v2().size());
            .startObject(typeName)  
        memoryIndex.addField("_field3", "unhide me", new WhitespaceAnalyzer());  
    }
        ParsedDocument doc = mapperService.documentMapper()
        fieldName = randomAlphaOfLength(4);  
                                .endObject()
            );
                new CompressedXContent(percolatorMapper),  
                        jsonBuilder().startObject()  
        range = rangesMap.get("number_field4");
        QueryBuilder queryBuilder = termQuery("field", "value");  
            null  
                    MediaTypeRegistry.JSON
                    encodedTo = new byte[Long.BYTES];
    }  
        }
    }
            .numberOfShards(1)  
            mapperService.documentMapperParser(),
                );
                        "test",  
            MapperService.SINGLE_MAPPING_NAME,
import static org.opensearch.index.query.QueryBuilders.prefixQuery;
            );
                            jsonBuilder().startObject()
            .endObject()
        Tuple<List<BytesRef>, Map<String, List<byte[]>>> t = fieldType.extractTermsAndRanges(indexReader);  
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);
                    "1",
        PlainActionFuture<QueryBuilder> future = new PlainActionFuture<>();
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
        PercolatorFieldMapper.verifyQuery(new FunctionScoreQueryBuilder(rangeQuery1, new RandomScoreFunctionBuilder()));  
import org.apache.lucene.search.BooleanQuery;
            assertThat(e.getDetailedMessage(), containsString("query malformed, must start with start_object"));
    @Override  
        // add an query for which we don't extract terms from
            .collect(Collectors.toList());
        @Override
import static org.opensearch.index.query.QueryBuilders.boolQuery;
                default:
                case 1:
        Map<String, List<byte[]>> rangesMap = t.v2();
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            .startObject("query_field1")
                case 1:
        assertEquals(10, LongPoint.decodeDimension(range.get(0), 0));
        queryBuilder = rangeQuery("field").from("a").to("z");
    }
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_PARTIAL));  
        });
    public static class FoolMeScriptPlugin extends MockScriptPlugin {  
        assertEquals("field1\u0000fox", terms.get(4).utf8ToString());
/*  
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, queryBuilder).endObject()),
                )
        List<String> values = Arrays.stream(doc.rootDoc().getFields(fieldType.queryTermsField.name()))  
            .endObject()  
                )  
            .parse(  
                input.readVInt();  
        }
            }  
    public void testEmptyName() throws Exception {
        assertThat(fields.size(), equalTo(2));
        doc = mapperService.documentMapper()  
 * The OpenSearch Contributors require contributions made to  
        // Now test conjunction:
                    "1",
        memoryIndex.addField("field2", "some more text", new WhitespaceAnalyzer());
        // Range queries on different fields:
            .startObject()
                    throw new AssertionError("unexpected encoding type [" + encodingType + "]");  
    public void testCreateCandidateQuery() throws Exception {
            ParentJoinModulePlugin.class  
                assertThat(queryBuilder, equalTo(expected));  
        addQueryFieldMappings();  
                new SourceToParse(
    }
        addQueryFieldMappings();
    public void testUnsupportedQueries() {
        } else {  
        QueryBuilder[] queries = new QueryBuilder[] {
        assertEquals(InetAddresses.forString("192.168.1.12"), InetAddressPoint.decode(range.get(0)));  
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_PARTIAL));  
        fieldMapper.processQuery(phraseQuery, parseContext);  
            matchAllQuery(),
                    "test",  
        IndexMetadata build = IndexMetadata.builder("")  
        }  
            .startObject("query_field2")
import org.opensearch.common.compress.CompressedXContent;
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(hasChildQuery));  
        @Override
                // to encode multiple binary values into a single binary doc values field.  
            .endObject()
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(new BoolQueryBuilder().must(hasChildQuery)));  
import org.opensearch.index.query.QueryShardContext;  
    }  
    public void testQueryWithRewrite() throws Exception {
                new SourceToParse(
            .map(f -> f.binaryValue().utf8ToString())  
    public void testExtractTerms() throws Exception {  
            rangeQuery("number_field2").gte(0).lte(9),  
            byte[] result = PercolatorFieldMapper.encodeRange(fieldName, encodedFrom, encodedTo);
    public void testExtractTermsAndRanges_partial() throws Exception {  
        assertEquals("field2\u0000more", terms.get(10).utf8ToString());
        document = parseContext.doc();  
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapper), MapperService.MergeReason.MAPPING_UPDATE);
            .field("type", "text")  
                        BytesReference.bytes(
        assertEquals(10, IntPoint.decodeDimension(range.get(1), 0));
        client().prepareIndex("remote").setId("1").setSource("field", "value").get();
        assertThat(msm, equalTo(3));  
                new SourceToParse(
                default:  
                new SourceToParse(  
            .startObject("field1")
import org.apache.lucene.index.Term;  
                assertEquals(Script.DEFAULT_SCRIPT_LANG, function.getScript().getLang());
            () -> PercolatorFieldMapper.verifyQuery(new BoostingQueryBuilder(hasChildQuery, new MatchAllQueryBuilder()))
        assertThat(doc.rootDoc().getFields().size(), equalTo(16)); // also includes all other meta fields
                    encodedTo = new byte[Integer.BYTES];
        query.endObject();  
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;  
            .field("type", "percolator")  
            documentMapper,
        bq = new BooleanQuery.Builder();
                    "test",
import org.opensearch.index.query.BoostingQueryBuilder;
        Tuple<BooleanQuery, Boolean> t = fieldType.createCandidateQuery(indexReader, Version.CURRENT);  
        );
    public void testImplicitlySetDefaultScriptLang() throws Exception {
                    MediaTypeRegistry.JSON
        IndexReader indexReader = memoryIndex.createSearcher().getIndexReader();  
    public void testExtractRanges() throws Exception {
            .field("type", "text")  
                )
import org.opensearch.script.Script;
        assertEquals(40F, FloatPoint.decodeDimension(range.get(0), 0), 0F);
            .endObject()
    public void testExtractTermsAndRanges() throws Exception {  
        assertThat(fields.size(), equalTo(2));  
                    MediaTypeRegistry.JSON
        TermQuery termQuery1 = new TermQuery(new Term("field", "term1"));  
        List<IndexableField> fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.queryTermsField.name())));
        msm = doc.rootDoc().getFields(fieldType.minimumShouldMatchField.name())[0].numericValue().intValue();
        QueryBuilder queryBuilder = termsLookupQuery("field", new TermsLookup("remote", "1", "field"));
        PercolatorFieldMapper.PercolatorFieldType fieldType = (PercolatorFieldMapper.PercolatorFieldType) fieldMapper.fieldType();
        IndexableField extractionResultField = doc.rootDoc().getField("object_field.query_field.extraction_result");
            .startObject("number_field7")
        Query rangeQuery1 = mapperService.fieldType("number_field1").rangeQuery(10, 20, true, true, null, null, null, context);  
            null,  
            ParsedDocument doc = mapperService.documentMapper()  
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
            String fieldName = randomAlphaOfLength(5);  
        PercolatorFieldMapper.verifyQuery(new BoostingQueryBuilder(rangeQuery1, new MatchAllQueryBuilder()));
                    new SourceToParse(  
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, qb).endObject()),
        } else {
                    MediaTypeRegistry.JSON  
            .startObject("number_field6")
                            .rawField(fieldName, new BytesArray(query.toString()).streamInput(), query.contentType())
    }  
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        assertThat(values.get(0), equalTo("field\0value1"));
        assertThat(fields.size(), equalTo(2));
            .parse(
        addQueryFieldMappings();
import static org.opensearch.percolator.PercolatorFieldMapper.EXTRACTION_PARTIAL;  
        PercolatorFieldMapper.verifyQuery(rangeQuery1);
                        BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, query).endObject()),
                        XContentFactory.jsonBuilder()
        assertThat(fields.get(0).numericValue(), equalTo(2L));
                case 0:  
                .parse(
            .must(boolQuery().should(termQuery("field", "value4")).should(termQuery("field", "value5")));
    }  
        bq.add(rangeQuery2, Occur.MUST);
        List<byte[]> range = rangesMap.get("number_field2");
        assertThat(e.getMessage(), containsString("Mapping definition for [" + fieldName + "] has unsupported parameters:  [index : no]"));
                    break;
import org.opensearch.join.query.HasParentQueryBuilder;
        PercolatorFieldMapper.verifyQuery(new ConstantScoreQueryBuilder((rangeQuery1)));
        fields.sort(Comparator.comparing(IndexableField::binaryValue));
                    MediaTypeRegistry.JSON  
        for (QueryBuilder query : queries) {
        assertNotNull(range);
 * this work for additional information regarding copyright
                    throw new AssertionError("unexpected encoding type [" + encodingType + "]");  
        addQueryFieldMappings();
                )  
                new SourceToParse(
                    "1",
import org.apache.lucene.document.InetAddressPoint;
import org.opensearch.index.mapper.DocumentMapperParser;  
            .startObject("properties")  
            .numberOfShards(1)
        assertEquals(50D, DoublePoint.decodeDimension(range.get(1), 0), 0D);
            FoolMeScriptPlugin.class,
                )  
        ParseContext.Document document = parseContext.doc();
        assertEquals(3, t.v1().clauses().size());
        query.startObject();
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_COMPLETE));
        memoryIndex.addField("field4", "123", new WhitespaceAnalyzer());
        assertTrue(queryBuilderField.fieldType().omitNorms());  
                new SourceToParse(
                    "1",  
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        assertThat(t.v1().clauses().get(1).query(), instanceOf(TermQuery.class));  
        assertEquals(10, LongPoint.decodeDimension(range.get(1), 0));
    public void init() throws Exception {
        List<IndexableField> fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.rangeField.name())));
            wildcardQuery("field", "v*"),
                    assertEquals(randomTo, IntPoint.decodeDimension(subByteArray(result, 28, 4), 0));
        memoryIndex.addField("field1", text.toString(), new WhitespaceAnalyzer());
            MurmurHash3.hash128(fieldAsBytesRef.bytes, fieldAsBytesRef.offset, fieldAsBytesRef.length, 0, hash);  
        assertThat(values.get(3), equalTo("field\0value4"));  
        assertThat(document.getFields().size(), equalTo(1));
                        jsonBuilder().startObject().startObject("object_field").field("query_field", queryBuilder).endObject().endObject()
        mapperService.merge(
            .endObject()  
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().endObject()),
        MemoryIndex memoryIndex = new MemoryIndex(false);
        memoryIndex.addField(new IntPoint("number_field1", 10), new WhitespaceAnalyzer());
        assertThat(values.size(), equalTo(5));
import org.opensearch.index.IndexSettings;
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name())[0].stringValue(), equalTo(EXTRACTION_FAILED));
}
import org.opensearch.index.mapper.DocumentMapper;
        }
import org.opensearch.test.InternalSettingsPlugin;  
        String typeName = MapperService.SINGLE_MAPPING_NAME;  
                            .endObject()
        IndexService indexService = createIndex("test1", Settings.EMPTY);
        DocumentMapper documentMapper = mapperService.documentMapper();
        assertEquals("field4\u0000123", terms.get(13).utf8ToString());
            .startObject()  
        IndexMetadata build = IndexMetadata.builder("")
        }
        assertThat(fields.get(0).numericValue(), equalTo(1L));  
                case 0:  
                        MediaTypeRegistry.JSON  
import org.opensearch.index.query.ConstantScoreQueryBuilder;
        }
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name()).length, equalTo(1));
            query.startObject("script");
            .endObject()
            .field("type", "percolator")
                // This is the reason we need to first need to read the number of values and  
        MemoryIndex memoryIndex = new MemoryIndex(false);
import java.util.List;
        try (InputStream in = new ByteArrayInputStream(actual.bytes, actual.offset, actual.length)) {  
            assertQueryBuilder(qbSource, query);
            .endObject()
        query.startArray("functions");  
            .endObject()
        ParseContext.Document document = parseContext.doc();
        assertEquals(2, t.v1().clauses().size());
        }  
        assertThat(exception.getCause(), instanceOf(QueryShardException.class));  
                )
            .toString();
        IndexMetadata build = IndexMetadata.builder("")  
    private IndexService indexService;
        assertThat(exception.getCause().getMessage(), equalTo("No field mapping can be found for the field with name [unmapped_field]"));
            .startObject("object_field")
                    MediaTypeRegistry.JSON  
            assertEquals(32, result.length);
        assertThat(msm, equalTo(4));  
        assertNotNull(range);
        assertEquals(14, terms.size());  
                        XContentFactory.jsonBuilder()
            .field("type", "double")  
        assertThat(values.get(1), equalTo("field\0value2"));
        assertQueryBuilder(qbSource, future.get());  
                )
        assertThat(e.getCause().getMessage(), equalTo("a document can only contain one percolator query"));
            }
            switch (encodingType) {
            .field("type", "long")  
 *
        indexReader = memoryIndex.createSearcher().getIndexReader();
            .endObject()
            () -> PercolatorFieldMapper.verifyQuery(new FunctionScoreQueryBuilder(hasChildQuery, new RandomScoreFunctionBuilder()))  
        memoryIndex.addField(new InetAddressPoint("number_field7", InetAddresses.forString("192.168.1.20")), new WhitespaceAnalyzer());  
 *  
                    MediaTypeRegistry.JSON
            .field("type", "text")  
                    ),
            IllegalArgumentException.class,  
            .numberOfReplicas(0)  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .startObject("number_field1")
        assertEquals(2, t.v1().clauses().size());
            .map(f -> f.binaryValue().utf8ToString())
            mapperService.documentMapperParser(),
                ScriptQueryBuilder queryBuilder = (ScriptQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
                    ),  
                );
        query.startObject();
            .parse(
import org.opensearch.index.query.DisMaxQueryBuilder;  
 * specific language governing permissions and limitations
        try (InputStream in = new ByteArrayInputStream(querySource.bytes, querySource.offset, querySource.length)) {
        addQueryFieldMappings();  
 * this file be licensed under the Apache-2.0 license or a
            new CompressedXContent(percolatorMapper),  
        });  
        assertThat(values.get(0), equalTo("field\0value1"));  
                    assertEquals(hash.h1, ByteBuffer.wrap(subByteArray(result, 16, 8)).getLong());  
import static org.hamcrest.Matchers.instanceOf;  
            .endObject()
        assertThat(msm, equalTo(1));
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.minimumShouldMatchField.name())));  
                new SourceToParse(
        String percolatorMapper = XContentFactory.jsonBuilder()
                    throw new AssertionError("unexpected encoding type [" + encodingType + "]");
            .endObject()
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.index.query.BoolQueryBuilder;  
        assertEquals("_field3\u0000me", terms.get(0).utf8ToString());
                    MediaTypeRegistry.JSON  
                input.readVInt();
        if (randomBoolean()) {  
    }  
                    "1",  
    }
        addQueryFieldMappings();
            .endObject()
        assertNotNull(range);
 * the Apache License, Version 2.0 (the "License"); you may
                    IntPoint.encodeDimension(randomFrom, encodedFrom, 0);
                    new SourceToParse(
            .should(boolQuery().should(termQuery("field", "value3")).should(termQuery("field", "value4")))
                    MediaTypeRegistry.JSON
        assertThat(doc.rootDoc().getFields().size(), equalTo(12)); // also includes all other meta fields
        fieldMapper.processQuery(bq.build(), parseContext);
            rangeQuery("date_field").from("2015-01-01T00:00").to("2015-01-01T00:00") };
        assertThat(fields.size(), equalTo(1));  
        PercolatorFieldMapper fieldMapper = (PercolatorFieldMapper) documentMapper.mappers().getMapper(fieldName);
                                .endObject()
import org.opensearch.indices.TermsLookup;
                assertEquals(Script.DEFAULT_SCRIPT_LANG, queryBuilder.script().getLang());
import java.util.Comparator;  
            .field("type", "float")  
            .sorted()  
    public void testEncodeRange() {
            .endObject()  
        ParseContext.Document document = parseContext.doc();  
import org.opensearch.index.query.RangeQueryBuilder;
            matchPhraseQuery("field", "value"),  
        memoryIndex.addField(new LongPoint("field2", 10L), new WhitespaceAnalyzer());
        assertEquals(50D, DoublePoint.decodeDimension(range.get(0), 0), 0D);
                    )
        RangeQueryBuilder rangeQuery1 = new RangeQueryBuilder("field").from("2016-01-01||/D").to("2017-01-01||/D");  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        query.startObject("script");  
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;  
                FunctionScoreQueryBuilder queryBuilder = (FunctionScoreQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
        assertThat(values.get(2), equalTo("field\0value3"));
                    ),
                input.readVInt();  
    @Override
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {  
                            .endArray()
        PercolatorFieldMapper.verifyQuery(rangeQuery2);  
            .endObject()
        MemoryIndex memoryIndex = new MemoryIndex(false);  
        assertThat(values.get(4), equalTo("field\0value5"));
        assertEquals(0, t.v1().size());  
            .startObject()
import org.apache.lucene.index.memory.MemoryIndex;
    private void assertQueryBuilder(BytesRef actual, QueryBuilder expected) throws IOException {
                    break;  
        assertThat(t.v1().clauses().get(0).query(), instanceOf(CoveringQuery.class));  
            .startObject("_field3")
    public void testNestedPercolatorField() throws Exception {
        TermInSetQuery terms = (TermInSetQuery) t.v1().clauses().get(0).query();
import org.apache.lucene.document.DoublePoint;
        assertEquals(10, IntPoint.decodeDimension(range.get(0), 0));  
        query.endObject();
            .field("type", "percolator")  
        assertThat(t.v1().clauses().get(1).query(), instanceOf(TermQuery.class));
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, qb).endObject()),  
 * license agreements. See the NOTICE file distributed with
            .endObject()
import org.opensearch.index.query.QueryShardException;
                    "1",
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_FAILED));  
            query.field("source", "return true");
        BytesRef queryBuilderAsBytes = doc.rootDoc().getField("query_field1.query_builder_field").binaryValue();  
        ParsedDocument doc = mapperService.documentMapper()
            .numberOfReplicas(0)
import static org.opensearch.index.query.QueryBuilders.termsLookupQuery;
import static org.hamcrest.Matchers.equalTo;
            query.field("script", "return true");
import org.junit.Before;
        assertThat(values.get(4), equalTo("field\0value5"));
    protected Collection<Class<? extends Plugin>> getPlugins() {
            .collect(Collectors.toList());  
            .endObject()  
    private String fieldName;
        memoryIndex.addField(new LongPoint("number_field2", 20L), new WhitespaceAnalyzer());  
import org.opensearch.script.MockScriptPlugin;
    public void testPercolatorFieldMapper() throws Exception {
                                .endObject()
        Query rangeQuery2 = mapperService.fieldType("number_field1").rangeQuery(15, 20, true, true, null, null, null, context);
 *
            mapperService.documentMapperParser(),  
            );  
        RangeQueryBuilder rangeQuery2 = new RangeQueryBuilder("field").from("2016-01-01||/D").to("now");
    // Just so that we store scripts in percolator queries, but not really execute these scripts.
import org.apache.lucene.search.BooleanClause.Occur;
import org.opensearch.core.common.io.stream.StreamInput;  
        assertThat(values.size(), equalTo(5));  
                    break;
import org.apache.lucene.search.TermRangeQuery;
import java.util.Collections;
                new SourceToParse(  
                    break;
            .field("type", "half_float")  
        assertEquals(30F, HalfFloatPoint.decodeDimension(range.get(1), 0), 0F);
        assertNotNull(range);  
                            .startObject()  
            .field("type", "ip")  
                    "1",
            .sorted()
        fields.sort(Comparator.comparing(IndexableField::binaryValue));
            MapperService.MergeReason.MAPPING_UPDATE
        expectThrows(
            MurmurHash3.Hash128 hash = new MurmurHash3.Hash128();
        assertQueryBuilder(queryBuilderAsBytes, queryBuilder);
            }
        parseContext = new ParseContext.InternalParseContext(settings, mapperService.documentMapperParser(), documentMapper, null, null);
        assertThat(doc.rootDoc().getFields(fieldType.queryTermsField.name()).length, equalTo(1));
        );
        assertThat(fields.get(0).binaryValue().utf8ToString(), equalTo("field\u0000term1"));  
        IndexReader indexReader = memoryIndex.createSearcher().getIndexReader();
        );  
            .endObject()
            );  
        assertEquals(20L, LongPoint.decodeDimension(range.get(0), 0));
        // parseCreateFieldForPluggableFormat should throw since PercolatorFieldMapper overrides parse() directly  
import org.opensearch.core.common.bytes.BytesArray;
            () -> parser.parse("type1", new CompressedXContent(mapping))  
        assertEquals(7, rangesMap.size());
                    break;
        mapperService = indexService.mapperService();  
        query.endObject();
    }
import org.opensearch.index.mapper.ParseContext;  
                    BytesReference.bytes(
import java.util.ArrayList;
    }  
import org.opensearch.core.common.io.stream.InputStreamStreamInput;  
