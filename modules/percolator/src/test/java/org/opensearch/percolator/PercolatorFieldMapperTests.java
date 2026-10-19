            query.startObject("script");
            .startObject("number_field5")
        );
            termQuery("field", "value"),
        bq.add(termQuery1, Occur.SHOULD);
            .startObject()
        memoryIndex.addField(new LongPoint("number_field3", 30L), new WhitespaceAnalyzer());
            .field("type", "text")
            .startObject("properties")
        Tuple<BooleanQuery, Boolean> t = fieldType.createCandidateQuery(indexReader, Version.CURRENT);
                assertThat(queryBuilder, equalTo(expected));
            .startObject("field1")
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * KIND, either express or implied.  See the License for the
                    "1",
import org.apache.lucene.search.BooleanClause.Occur;
                    break;
        Tuple<List<BytesRef>, Map<String, List<byte[]>>> t = fieldType.extractTermsAndRanges(indexReader);
            .startObject("query_field1")
        assertNotNull(range);
                MapperService.SINGLE_MAPPING_NAME,
        assertThat(fields.size(), equalTo(2));
            .parse(
                    IntPoint.encodeDimension(randomFrom, encodedFrom, 0);
                    encodedFrom = new byte[Integer.BYTES];
            .parse(
    }
        );
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(hasParentQuery));
            .endObject()
        query.endObject();
            null,
    private String fieldName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(values.get(0), equalTo("field\0value1"));
        assertThat(values.size(), equalTo(3));
    }
    public void testExtractTerms() throws Exception {
                        BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, query).endObject()),
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(new BoolQueryBuilder().must(hasParentQuery)));
        assertEquals("field1\u0000lazy", terms.get(6).utf8ToString());
        try (InputStream in = new ByteArrayInputStream(actual.bytes, actual.offset, actual.length)) {
        assertThat(values.get(3), equalTo("field\0value4"));
    }
            .endObject()
        }
            .parse(
            .endObject()
            query.field("script", "return true");
        document = parseContext.doc();
        assertNotNull(range);
        assertEquals(50D, DoublePoint.decodeDimension(range.get(0), 0), 0D);
                assertEquals(Script.DEFAULT_SCRIPT_LANG, function.getScript().getLang());
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_COMPLETE));
                    assertEquals(randomTo, IntPoint.decodeDimension(subByteArray(result, 28, 4), 0));
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, queryBuilder).endObject()),
                            .rawField(fieldName, new BytesArray(query.toString()).streamInput(), query.contentType())
            .collect(Collectors.toList());
import org.opensearch.index.mapper.DocumentMapperParser;
        String typeName = MapperService.SINGLE_MAPPING_NAME;
    public void testPercolatorFieldMapperUnMappedField() throws Exception {
                        MediaTypeRegistry.JSON
import org.opensearch.action.support.PlainActionFuture;
            .must(boolQuery().must(termQuery("field", "value2")).must(termQuery("field", "value3")))
            .endObject()
        memoryIndex.addField("_field3", "unhide me", new WhitespaceAnalyzer());
        );
        assertEquals(14, terms.size());
        assertEquals(50D, DoublePoint.decodeDimension(range.get(1), 0), 0D);
                        XContentFactory.jsonBuilder()
import org.apache.lucene.search.PhraseQuery;
        range = rangesMap.get("number_field5");
        DocumentMapperParser parser = mapperService.documentMapperParser();
    public void testImplicitlySetDefaultScriptLang() throws Exception {
 * The OpenSearch Contributors require contributions made to
        memoryIndex.addField(new LongPoint("number_field2", 10L), new WhitespaceAnalyzer());
import org.apache.lucene.util.BytesRef;
            .endObject()
 *
                new CompressedXContent(percolatorMapper),
            FoolMeScriptPlugin.class,
            assertEquals(32, result.length);
                    new SourceToParse(
        IndexReader indexReader = memoryIndex.createSearcher().getIndexReader();
import org.opensearch.core.common.bytes.BytesReference;
        PercolatorFieldMapper.verifyQuery(new FunctionScoreQueryBuilder(rangeQuery1, new RandomScoreFunctionBuilder()));
            .must(boolQuery().must(termQuery("field", "value3")).must(termQuery("field", "value4")))
        assertQueryBuilder(queryBuilderAsBytes, queryBuilder);
            MapperService.MergeReason.MAPPING_UPDATE
import org.opensearch.Version;
                    assertEquals(hash.h1, ByteBuffer.wrap(subByteArray(result, 16, 8)).getLong());
        assertThat(values.size(), equalTo(5));
    public void testPercolatorFieldMapper_noQuery() throws Exception {
                        BytesReference.bytes(
import java.util.function.Function;
        assertThat(doc.rootDoc().getFields(fieldType.queryTermsField.name())[0].binaryValue().utf8ToString(), equalTo("field\0value"));
        }
                )
                            .startObject()
        bq.add(termQuery2, Occur.SHOULD);
            .endObject()
        Rewriteable.rewriteAndFetch(queryBuilder, shardContext, future);
        List<IndexableField> fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.rangeField.name())));
        QueryBuilder queryBuilder = termsLookupQuery("field", new TermsLookup("remote", "1", "field"));
                new SourceToParse(
            .startObject("number_field4")
        assertThat(doc.rootDoc().getFields(fieldType.queryBuilderField.name()).length, equalTo(1));
                .parse(
        RangeQueryBuilder rangeQuery2 = new RangeQueryBuilder("field").from("2016-01-01||/D").to("now");
                new SourceToParse(
        assertThat(msm, equalTo(4));
import org.apache.lucene.search.TermRangeQuery;
        msm = doc.rootDoc().getFields(fieldType.minimumShouldMatchField.name())[0].numericValue().intValue();
        assertThat(fields.size(), equalTo(1));
                        MediaTypeRegistry.JSON
            .endObject()
        values = Arrays.stream(doc.rootDoc().getFields(fieldType.queryTermsField.name()))
                    MediaTypeRegistry.JSON
                default:
    public static class FoolMeScriptPlugin extends MockScriptPlugin {
                    MediaTypeRegistry.JSON
                new SourceToParse(
    }
        ParseContext.InternalParseContext parseContext = new ParseContext.InternalParseContext(
                        jsonBuilder().startObject().startObject("object_field").field("query_field", queryBuilder).endObject().endObject()
import org.apache.lucene.sandbox.search.CoveringQuery;
            .parse(
    }
        ParseContext.InternalParseContext parseContext = new ParseContext.InternalParseContext(
        assertThat(doc.rootDoc().getFields(fieldType.queryBuilderField.name()).length, equalTo(0));
            .endObject()
        parseContext = new ParseContext.InternalParseContext(settings, mapperService.documentMapperParser(), documentMapper, null, null);
        PercolatorFieldMapper.PercolatorFieldType fieldType = (PercolatorFieldMapper.PercolatorFieldType) fieldMapper.fieldType();
                input.readVInt();
import org.opensearch.test.InternalSettingsPlugin;
import org.opensearch.common.compress.CompressedXContent;
import static org.opensearch.percolator.PercolatorFieldMapper.EXTRACTION_FAILED;
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, queryBuilder).endObject()),
        ParsedDocument doc = mapperService.documentMapper()
                        "1",
                )
        memoryIndex.addField(new IntPoint("number_field1", 10), new WhitespaceAnalyzer());
            null
            .startObject("number_field7")
 * license agreements. See the NOTICE file distributed with
            .field("type", "percolator")
import org.opensearch.index.mapper.ParseContext;
        mapperService = indexService.mapperService();
        assertThat(values.get(3), equalTo("field\0value4"));
            );
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
            () -> fieldMapper.parseCreateFieldForPluggableFormat(null)
        range = rangesMap.get("number_field6");
        querySource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();
        addQueryFieldMappings();
    }
        HasParentQueryBuilder hasParentQuery = new HasParentQueryBuilder("parent", new MatchAllQueryBuilder(), false);
        mapperService.merge(
            mapperService.documentMapper()
        assertThat(doc.rootDoc().getFields(fieldType.queryBuilderField.name()).length, equalTo(1));
    // Just so that we store scripts in percolator queries, but not really execute these scripts.
            .startObject(typeName)
                    break;
            .endObject()
    public void testDuplicatedClauses() throws Exception {
                    "1",
                    "test",
            settings,
        TermQuery termQuery1 = new TermQuery(new Term("field", "term1"));
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name()).length, equalTo(1));
        return getInstanceFromNode(NamedWriteableRegistry.class);
    private void addQueryFieldMappings() throws Exception {
    private MapperService mapperService;
            .startObject("field2")
                    assertEquals(hash.h1, ByteBuffer.wrap(subByteArray(result, 16, 8)).getLong());
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.containsString;
            mapperService.documentMapper()
                    MediaTypeRegistry.JSON
        qb = boolQuery().must(boolQuery().must(termQuery("field", "value1")).must(termQuery("field", "value2")))
                new SourceToParse(
            settings,
            assertQueryBuilder(qbSource, query);
        memoryIndex.addField("field4", "123", new WhitespaceAnalyzer());
        IllegalArgumentException e = expectThrows(
            );
                    MediaTypeRegistry.JSON
            IllegalArgumentException.class,
        );
    }
                    .getScoreFunction();
        assertThat(LongPoint.decodeDimension(fields.get(1).binaryValue().bytes, 8), equalTo(15L));
            null
        addQueryFieldMappings();
 * the Apache License, Version 2.0 (the "License"); you may
            .startObject("properties")
import org.opensearch.common.collect.Tuple;
        rangeQuery2 = mapperService.fieldType("number_field2").rangeQuery(15, 20, true, true, null, null, null, context);
        fields.sort(Comparator.comparing(IndexableField::binaryValue));
        assertThat(document.getFields().size(), equalTo(4));
        assertEquals("field2\u0000some", terms.get(11).utf8ToString());
                            .endObject()
        assertNotNull(range);
            .startObject(typeName)
            }
            null,
        assertQueryBuilder(queryBuilderAsBytes, queryBuilder);
        assertThat(values.size(), equalTo(5));
                case 0:
import java.nio.ByteBuffer;
        memoryIndex.addField("field2", "value", new WhitespaceAnalyzer());
        query = jsonBuilder();
        ParsedDocument doc = mapperService.documentMapper()
            InternalSettingsPlugin.class,
            .numberOfShards(1)
        query.endArray();
        BytesRef queryBuilderAsBytes = doc.rootDoc().getField("query_field1.query_builder_field").binaryValue();
            .startObject("properties")
            MurmurHash3.Hash128 hash = new MurmurHash3.Hash128();
        ParseContext.InternalParseContext parseContext = new ParseContext.InternalParseContext(
        assertThat(fields.size(), equalTo(2));
        );
import org.opensearch.core.xcontent.XContentBuilder;
                case 1:
 *
        QueryBuilder qb = boolQuery().must(boolQuery().must(termQuery("field", "value1")).must(termQuery("field", "value2")))
            .numberOfShards(1)
            .startObject("properties")
        XContentBuilder query = jsonBuilder();
        assertFalse(t.v2());
                    )
    public void testNestedPercolatorField() throws Exception {
        TermInSetQuery terms = (TermInSetQuery) t.v1().clauses().get(0).query();
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;
                    MediaTypeRegistry.JSON
            .endObject()
            .should(boolQuery().should(termQuery("field", "value1")).should(termQuery("field", "value2")))
                    assertEquals(randomTo, LongPoint.decodeDimension(subByteArray(result, 24, 8), 0));
            .sorted()
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.queryTermsField.name())));
        DocumentMapper documentMapper = mapperService.documentMapper();
            documentMapper,
        addQueryFieldMappings();
            .startObject("properties")
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        public String pluginScriptLang() {
                        "test",
        query.startObject();
            try (StreamInput input = new NamedWriteableAwareStreamInput(new InputStreamStreamInput(in), writableRegistry())) {
        fieldMapper.processQuery(bq.build(), parseContext);
        doc = mapperService.documentMapper()
import org.apache.lucene.sandbox.document.HalfFloatPoint;
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapper), MapperService.MergeReason.MAPPING_UPDATE);
        assertThat(values.get(1), equalTo("field\0value2"));
            .endObject()
        BytesRef querySource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();
        assertThat(fields.get(0).numericValue(), equalTo(2L));
                        XContentFactory.jsonBuilder()
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);
            .numberOfReplicas(0)
            .should(boolQuery().should(termQuery("field", "value2")).should(termQuery("field", "value3")))
            .must(boolQuery().should(termQuery("field", "value4")).should(termQuery("field", "value5")));
                new SourceToParse(
                )
        addQueryFieldMappings();
                FunctionScoreQueryBuilder queryBuilder = (FunctionScoreQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
                    "1",
        assertThat(fields.get(0).binaryValue().utf8ToString(), equalTo("field\u0000term1"));
            IllegalArgumentException.class,
        doc = mapperService.documentMapper()
    // multiple percolator fields are allowed in the mapping, but only one field can be used at index time.
        PercolatorFieldMapper fieldMapper = (PercolatorFieldMapper) documentMapper.mappers().getMapper(fieldName);
            text.append(i).append(' ');
            );
    public void testEmptyName() throws Exception {
                case 0:
        assertThat(fields.size(), equalTo(1));
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;
        ParsedDocument doc = mapperService.documentMapper()
    }
import org.apache.lucene.index.IndexableField;
        List<String> values = Arrays.stream(doc.rootDoc().getFields(fieldType.queryTermsField.name()))
        range = rangesMap.get("number_field7");
        }
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(values.get(0), equalTo("field\0value1"));
import static org.opensearch.percolator.PercolatorFieldMapper.EXTRACTION_PARTIAL;
import org.opensearch.index.query.BoolQueryBuilder;
        );
    }
                    "test",
        assertThat(fields.size(), equalTo(1));
        queryBuilderAsBytes = doc.rootDoc().getField("object_field.query_field.query_builder_field").binaryValue();
            .field("type", "percolator")
        Map<String, List<byte[]>> rangesMap = t.v2();
import org.opensearch.index.mapper.ParsedDocument;
            .parse(
        query.endObject();
        ParsedDocument doc = mapperService.documentMapper()
        assertThat(values.get(0), equalTo("field\0value1"));
                );
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            .parse(
            null,
            .field("type", "text")
        assertQueryBuilder(queryBuilderAsBytes, queryBuilder);
                )
    public void testQueryWithRewrite() throws Exception {
        BytesRef qbSource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();
                    "1",
        assertThat(IntPoint.decodeDimension(fields.get(0).binaryValue().bytes, 28), equalTo(20));
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.minimumShouldMatchField.name())));
    }
            query.startObject("script");
            rangeQuery("number_field2").gte(0).lte(9),
import org.apache.lucene.document.FloatPoint;
            .field("type", "ip")
            .field("type", "long")
        for (QueryBuilder query : queries) {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                                .startObject()
        MemoryIndex memoryIndex = new MemoryIndex(false);
                new SourceToParse(
        // Now test conjunction:
                )
        PercolatorFieldMapper.verifyQuery(rangeQuery1);
        });
        assertThat(t.v1().clauses().get(1).query().toString(), containsString(fieldName + ".range_field:<ranges:"));
            .startObject(fieldName)
            .startObject("query_field2")
import static org.opensearch.index.query.QueryBuilders.termsLookupQuery;
        TermQuery termQuery2 = new TermQuery(new Term("field", "term2"));
            int encodingType = randomInt(1);
        assertThat(values.get(2), equalTo("field\0value3"));
    }
        } else {
                    break;
import org.apache.lucene.document.DoublePoint;
    public void testParseCreateFieldForPluggableFormat() throws Exception {
                            XContentFactory.jsonBuilder().startObject().field(fieldName, termQuery("unmapped_field", "value")).endObject()
            .field("type", "text")
        assertEquals("field2\u0000text", terms.get(12).utf8ToString());
                    "test",
                        BytesReference.bytes(XContentFactory.jsonBuilder().startObject().nullField(fieldName).endObject()),
            .parse(
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name()).length, equalTo(1));
        }
            .startObject("number_field1")
        assertEquals("field1\u0000fox", terms.get(4).utf8ToString());
                    ),
    }
        String percolatorMapper = XContentFactory.jsonBuilder()
        Query rangeQuery2 = mapperService.fieldType("number_field1").rangeQuery(15, 20, true, true, null, null, null, context);
                                .startObject()
        qb = boolQuery().minimumShouldMatch(3)
import org.opensearch.core.xcontent.MediaTypeRegistry;
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.minimumShouldMatchField.name())));
            .map(f -> f.binaryValue().utf8ToString())
                    LongPoint.encodeDimension(randomTo, encodedTo, 0);
        document = parseContext.doc();
import org.opensearch.plugins.Plugin;
        assertEquals(InetAddresses.forString("192.168.1.24"), InetAddressPoint.decode(range.get(1)));
            mapperService.documentMapperParser(),
        );
                .parse(
        );
        memoryIndex.addField(new InetAddressPoint("number_field7", InetAddresses.forString("192.168.1.12")), new WhitespaceAnalyzer());
import org.opensearch.common.hash.MurmurHash3;
import org.opensearch.index.IndexService;
                // to encode multiple binary values into a single binary doc values field.
        assertEquals(20L, LongPoint.decodeDimension(range.get(1), 0));
                .parse(
        IndexableField queryBuilderField = doc.rootDoc().getField("object_field.query_field.query_builder_field");
 *
                    MediaTypeRegistry.JSON
                // to encode multiple binary values into a single binary doc values field.
                    break;
                );
                    "test",
            ParsedDocument doc = mapperService.documentMapper()
        range = rangesMap.get("number_field2");
import java.util.stream.Collectors;
                                .endObject()
            matchAllQuery(),
            mapperService.documentMapperParser(),
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.minimumShouldMatchField.name())));
            .startObject()
            .endObject()
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
            );
                    throw new AssertionError("unexpected encoding type [" + encodingType + "]");
        assertTrue(t.v2());
            .endObject()
            () -> PercolatorFieldMapper.verifyQuery(new BoostingQueryBuilder(hasChildQuery, new MatchAllQueryBuilder()))
    }
                // This is the reason we need to first need to read the number of values and
            .startObject("query_field")
            MapperParsingException.class,
        query.startObject("script");
        PercolatorFieldMapper fieldMapper = (PercolatorFieldMapper) documentMapper.mappers().getMapper(fieldName);
    public void testCreateCandidateQuery_oldIndex() throws Exception {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .field("index", "no")
    }
                MapperService.MergeReason.MAPPING_UPDATE
                    MediaTypeRegistry.JSON
import static org.opensearch.percolator.PercolatorFieldMapper.EXTRACTION_COMPLETE;
            .field("type", "percolator")
        assertQueryBuilder(qbSource, future.get());
    }
        assertThat(values.get(4), equalTo("field\0value5"));
                // then the length of the field value in bytes.
                            .endObject()
                )
import org.opensearch.index.query.MatchAllQueryBuilder;
            settings,
            () -> PercolatorFieldMapper.verifyQuery(new FunctionScoreQueryBuilder(hasChildQuery, new RandomScoreFunctionBuilder()))
        values = Arrays.stream(doc.rootDoc().getFields(fieldType.queryTermsField.name()))
        TermRangeQuery query = new TermRangeQuery("field1", new BytesRef("a"), new BytesRef("z"), true, true);
        assertThat(IntPoint.decodeDimension(fields.get(0).binaryValue().bytes, 28), equalTo(20));
        // parseCreateFieldForPluggableFormat should throw since PercolatorFieldMapper overrides parse() directly
            .should(boolQuery().should(termQuery("field", "value4")).should(termQuery("field", "value5")));
        assertThat(fields.size(), equalTo(2));
                ScriptScoreFunctionBuilder function = (ScriptScoreFunctionBuilder) queryBuilder.filterFunctionBuilders()[0]
        addQueryFieldMappings();
        addQueryFieldMappings();
            }
        addQueryFieldMappings();
            .parse(
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name()).length, equalTo(1));
                    MediaTypeRegistry.JSON
import org.apache.lucene.search.TermQuery;
            query.field("source", "return true");
        assertEquals(2, t.v1().clauses().size());
        qbSource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();
                        "1",
        assertThat(values.get(1), equalTo("field\0value2"));
            .startObject("_field3")
        assertEquals("field2\u0000more", terms.get(10).utf8ToString());
        memoryIndex.addField(new LongPoint("field2", 10L), new WhitespaceAnalyzer());
            .startObject("type1")
        IndexReader indexReader = memoryIndex.createSearcher().getIndexReader();
 */
        assertThat(fields.get(0).numericValue(), equalTo(2L));
            .endObject()
                default:
                                .endArray()
import org.opensearch.index.query.QueryShardContext;
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, qb).endObject()),
            prefixQuery("field", "v"),
        queryBuilderAsBytes = doc.rootDoc().getField("query_field2.query_builder_field").binaryValue();
        DocumentMapper documentMapper = mapperService.documentMapper();
    }
                    LongPoint.encodeDimension(randomFrom, encodedFrom, 0);
        indexService = createIndex("test");
        IndexMetadata build = IndexMetadata.builder("")
    }
                // Query builder's content is stored via BinaryFieldMapper, which has a custom encoding
                            .endArray()
            .collect(Collectors.toList());
        ParsedDocument doc = mapperService.documentMapper()
            mapperService.documentMapper()
        mapperService.merge(typeName, new CompressedXContent(percolatorMapper), MapperService.MergeReason.MAPPING_UPDATE);
            MapperService.SINGLE_MAPPING_NAME,
        assertEquals(1023, terms.getTermsCount());
        PercolatorFieldMapper.verifyQuery(new ConstantScoreQueryBuilder((rangeQuery1)));
                case 1:
                    "test",
                    BytesReference.bytes(
                    "1",
            IllegalArgumentException.class,
            documentMapper,
        RangeQueryBuilder rangeQuery1 = new RangeQueryBuilder("field").from("2016-01-01||/D").to("2017-01-01||/D");
    public void testPercolatorFieldMapper() throws Exception {
        PercolatorFieldMapper.PercolatorFieldType fieldType = (PercolatorFieldMapper.PercolatorFieldType) fieldMapper.fieldType();
        addQueryFieldMappings();
        bq = new BooleanQuery.Builder();
                );
        PercolatorFieldMapper fieldMapper = (PercolatorFieldMapper) documentMapper.mappers().getMapper(fieldName);
        DocumentMapper documentMapper = mapperService.documentMapper();
                        "test",
        query.startObject("script_score");
                input.readVInt();
                            .rawField(fieldName, new BytesArray(query.toString()).streamInput(), query.contentType())
        fields.sort(Comparator.comparing(IndexableField::binaryValue));
            .endObject()
        if (randomBoolean()) {
            );
    public void testEncodeRange() {
            .field("type", "date")
                QueryBuilder queryBuilder = input.readNamedWriteable(QueryBuilder.class);
import org.opensearch.script.Script;
            .startObject(fieldName)
        queryBuilder = rangeQuery("date_field").from("now");
            .toString();
            new CompressedXContent(percolatorMapper),
        assertEquals("field1\u0000the", terms.get(9).utf8ToString());
        }
        // Now push it over the edge, so that it falls back using TermInSetQuery
                        "test",
        Tuple<List<BytesRef>, Map<String, List<byte[]>>> t = fieldType.extractTermsAndRanges(indexReader);
        fieldMapper.processQuery(phraseQuery, parseContext);
            .field("type", "percolator")
                    BytesReference.bytes(
        int iters = randomIntBetween(32, 256);
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(new ConstantScoreQueryBuilder(hasChildQuery)));
        }
        bq = new BooleanQuery.Builder();
                    new SourceToParse(
        ParseContext.Document document = parseContext.doc();
 * Unless required by applicable law or agreed to in writing,
            );
        PercolatorFieldMapper.verifyQuery(new BoostingQueryBuilder(rangeQuery1, new MatchAllQueryBuilder()));
        assertThat(document.getFields().get(0).binaryValue().utf8ToString(), equalTo("field\u0000term"));
import org.apache.lucene.search.TermInSetQuery;
                    IntPoint.encodeDimension(randomTo, encodedTo, 0);
import static org.opensearch.index.query.QueryBuilders.boolQuery;
                    BytesReference.bytes(
                )
}
        memoryIndex.addField(new LongPoint("number_field2", 20L), new WhitespaceAnalyzer());
        assertNotNull(range);
        assertThat(e.getMessage(), containsString("name cannot be empty string"));
import java.io.InputStream;
        assertThat(values.get(1), equalTo("field\0value2"));
        assertEquals(40F, FloatPoint.decodeDimension(range.get(0), 0), 0F);
    }
            );
 * under the License.
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
        assertEquals(3, t.v1().clauses().size());
        QueryBuilder queryBuilder = termQuery("field", "value");
        bq.add(rangeQuery2, Occur.MUST);
            PercolatorModulePlugin.class,
import org.opensearch.index.mapper.MapperParsingException;
 */
    }
        memoryIndex.addField("field2", "some more text", new WhitespaceAnalyzer());
        assertThat(t.v1().clauses().get(1).query(), instanceOf(TermQuery.class));
            () -> parser.parse("type1", new CompressedXContent(mapping))
        String percolatorMapper = XContentFactory.jsonBuilder()
        bq.add(rangeQuery2, Occur.MUST);
                case 1:
        parseContext = new ParseContext.InternalParseContext(settings, mapperService.documentMapperParser(), documentMapper, null, null);
            .numberOfShards(1)
            .endObject()
                            jsonBuilder().startObject()
                    "1",
        t = fieldType.createCandidateQuery(indexReader, Version.CURRENT);
    public void testCreateCandidateQuery() throws Exception {
import org.apache.lucene.index.memory.MemoryIndex;
import org.apache.lucene.document.InetAddressPoint;
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().endObject()),
import org.apache.lucene.index.IndexReader;
            documentMapper,
    }
                        ),
            .endObject()
        ParseContext.Document document = parseContext.doc();
        }
            );
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);
        assertThat(fields.get(1).binaryValue().utf8ToString(), equalTo("field\u0000term2"));
            return Script.DEFAULT_SCRIPT_LANG;
        assertEquals(2, t.v1().clauses().size());
                            .startObject()
            final int randomTo = randomIntBetween(randomFrom, Integer.MAX_VALUE);
 * Licensed to Elasticsearch under one or more contributor
    }
        query.endObject();
 * compatible open source license.
    private void assertQueryBuilder(BytesRef actual, QueryBuilder expected) throws IOException {
    public void testExtractTermsAndRanges_failed() throws Exception {
                    "1",
        client().prepareIndex("remote").setId("1").setSource("field", "value").get();
        assertNotNull(range);
        assertThat(fields.get(1).binaryValue().utf8ToString(), equalTo("field\u0000term2"));
    public void testExtractTermsAndRanges() throws Exception {
 * ownership. Elasticsearch licenses this file to you under
            .field("type", "double")
                new SourceToParse(
                            .startObject()
    @Override
            .startObject("date_field")
            .build();
            .endObject()
        assertEquals(10, IntPoint.decodeDimension(range.get(0), 0));
        String typeName = MapperService.SINGLE_MAPPING_NAME;
                new SourceToParse(
        addQueryFieldMappings();
import org.apache.lucene.document.LongPoint;
        assertThat(exception.getCause().getMessage(), equalTo("No field mapping can be found for the field with name [unmapped_field]"));
            .startObject()
            query.field("script", "return true");
                ScriptQueryBuilder queryBuilder = (ScriptQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
        BytesRef qbSource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();
                    MediaTypeRegistry.JSON
        assertEquals("field1\u0000quick", terms.get(8).utf8ToString());
                )
            );
        IndexReader indexReader = memoryIndex.createSearcher().getIndexReader();
        QueryShardContext context = createSearchContext(indexService).getQueryShardContext();
        }
        assertNotNull(range);
        query.startObject("function_score");
            .endObject()
                        MediaTypeRegistry.JSON
import org.opensearch.join.ParentJoinModulePlugin;
        assertQueryBuilder(queryBuilderAsBytes, queryBuilder);
                new SourceToParse(
            BytesRef fieldAsBytesRef = new BytesRef(fieldName);
        assertThat(fields.get(0).numericValue(), equalTo(1L));
        assertEquals(20L, LongPoint.decodeDimension(range.get(0), 0));
            .startObject("number_field3")
    protected NamedWriteableRegistry writableRegistry() {
            .field("type", "half_float")
import org.opensearch.index.query.QueryBuilder;
            final byte[] encodedTo;
                    "1",
                assertEquals(Script.DEFAULT_SCRIPT_LANG, queryBuilder.script().getLang());
                new SourceToParse(
        String percolatorMapper = XContentFactory.jsonBuilder()
        msm = doc.rootDoc().getFields(fieldType.minimumShouldMatchField.name())[0].numericValue().intValue();
        List<byte[]> range = rangesMap.get("number_field2");
        assertThat(msm, equalTo(1));
            );
            MurmurHash3.hash128(fieldAsBytesRef.bytes, fieldAsBytesRef.offset, fieldAsBytesRef.length, 0, hash);
        assertThat(fields.size(), equalTo(1));
        addQueryFieldMappings();
            }
                                .startArray("object_field")
        addQueryFieldMappings();
                )
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, qb).endObject()),
        assertEquals(30L, LongPoint.decodeDimension(range.get(0), 0));
import static org.opensearch.index.query.QueryBuilders.termQuery;
                    assertEquals(hash.h1, ByteBuffer.wrap(subByteArray(result, 0, 8)).getLong());
/*
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_PARTIAL));
        assertThat(msm, equalTo(3));
        assertThat(IntPoint.decodeDimension(fields.get(0).binaryValue().bytes, 12), equalTo(10));
            .field("type", "object")
import static org.opensearch.index.query.QueryBuilders.prefixQuery;
package org.opensearch.percolator;
                input.readVInt();
    @Before
    public void testExtractTermsAndRanges_numberFields() throws Exception {
                new SourceToParse(
        assertThat(e.getCause(), instanceOf(IllegalArgumentException.class));
            }
        doc = mapperService.documentMapper()
        ParsedDocument doc = mapperService.documentMapper()
        }
        memoryIndex.addField("field1", "the quick brown fox jumps over the lazy dog", new WhitespaceAnalyzer());
import org.opensearch.core.common.io.stream.StreamInput;
            .startObject("number_field2")
    private IndexService indexService;
import org.opensearch.index.query.functionscore.ScriptScoreFunctionBuilder;
            .endObject()
        assertThat(t.v1().clauses().get(1).query(), instanceOf(TermQuery.class));
                )
        PercolatorFieldMapper.PercolatorFieldType fieldType = (PercolatorFieldMapper.PercolatorFieldType) fieldMapper.fieldType();
            .numberOfReplicas(0)
            .startObject("properties")
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_PARTIAL));
            .endObject()
        query.startArray("functions");
    }
                    "1",
        // Range queries on different fields:
            .field("type", "long")
        try (InputStream in = new ByteArrayInputStream(querySource.bytes, querySource.offset, querySource.length)) {
                case 0:
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_PARTIAL));
        doc = mapperService.documentMapper()
            .endObject()
        BytesRef queryBuilderAsBytes = queryBuilderField.binaryValue();
import org.opensearch.index.IndexSettings;
        IndexMetadata build = IndexMetadata.builder("")
            .parse(
                            .startArray("object_field")
            .endObject()
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);
                    "1",
                            .field("query_field", queryBuilder)
            .toString();
        );
            .build();
import org.opensearch.index.query.Rewriteable;
        );
            .toString();
        fieldMapper.processQuery(bq.build(), parseContext);
            .startObject()
        Tuple<BooleanQuery, Boolean> t = fieldType.createCandidateQuery(indexReader, Version.CURRENT);
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.rangeField.name())));
            )
        memoryIndex.addField(new DoublePoint("number_field6", 50f), new WhitespaceAnalyzer());
        memoryIndex.addField(new InetAddressPoint("number_field7", InetAddresses.forString("192.168.1.20")), new WhitespaceAnalyzer());
        ParsedDocument doc = mapperService.documentMapper()
        String mapping = XContentFactory.jsonBuilder()
            BytesRef qbSource = doc.rootDoc().getFields(fieldType.queryBuilderField.name())[0].binaryValue();
            .build();
        DocumentMapper documentMapper = mapperService.documentMapper();
        try (InputStream in = new ByteArrayInputStream(querySource.bytes, querySource.offset, querySource.length)) {
        fieldType = (PercolatorFieldMapper.PercolatorFieldType) mapperService.fieldType(fieldName);
 * GitHub history for details.
import org.apache.lucene.search.join.ScoreMode;
import static org.hamcrest.Matchers.instanceOf;
            byte[] result = PercolatorFieldMapper.encodeRange(fieldName, encodedFrom, encodedTo);
        fields.sort(Comparator.comparing(IndexableField::binaryValue));
        assertEquals(40F, FloatPoint.decodeDimension(range.get(1), 0), 0F);
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_COMPLETE));
                        ),
                )
            .build();
import org.opensearch.join.query.HasParentQueryBuilder;
import java.io.ByteArrayInputStream;
            }
                    "test",
        assertThat(t.v1().clauses().get(0).query(), instanceOf(CoveringQuery.class));
            .endObject()
        fieldMapper.processQuery(query, parseContext);
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, queryBuilder).endObject()),
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
        MapperService mapperService = indexService.mapperService();
    public void init() throws Exception {
        fieldMapper.processQuery(bq.build(), parseContext);
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < iters; i++) {
    public void testExtractTermsAndRanges_partial() throws Exception {
            switch (encodingType) {
            .should(boolQuery().should(termQuery("field", "value3")).should(termQuery("field", "value4")))
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(new DisMaxQueryBuilder().add(hasChildQuery)));
        indexReader = memoryIndex.createSearcher().getIndexReader();
        query.endObject();
            .numberOfReplicas(0)
                    assertEquals(randomFrom, IntPoint.decodeDimension(subByteArray(result, 12, 4), 0));
import java.io.IOException;
import java.util.List;
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name())[0].stringValue(), equalTo(EXTRACTION_FAILED));
            .startObject()
            randomInt(20),
        assertThat(fields.size(), equalTo(2));
        QueryBuilder[] queries = new QueryBuilder[] {
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(new BoolQueryBuilder().must(hasChildQuery)));
import org.opensearch.indices.TermsLookup;
            .startObject()
        ParseContext.Document document = parseContext.doc();
            .startObject("field4")
            String fieldName = randomAlphaOfLength(5);
        assertNotNull(range);
                    "test",
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(hasChildQuery));
 * this file be licensed under the Apache-2.0 license or a
        assertThat(LongPoint.decodeDimension(fields.get(1).binaryValue().bytes, 24), equalTo(20L));
            wildcardQuery("field", "v*"),
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name())[0].stringValue(), equalTo(EXTRACTION_FAILED));
            .map(f -> f.binaryValue().utf8ToString())
            matchQuery("field", "value"),
                        "1",
import java.util.Collections;
            .toString();
            .toString();
            assertThat(e.getDetailedMessage(), containsString("query malformed, must start with start_object"));
import org.apache.lucene.index.Term;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            .endObject()
            .startObject("")
                // Query builder's content is stored via BinaryFieldMapper, which has a custom encoding
        QueryShardContext shardContext = indexService.newQueryShardContext(
            .startObject("number_field6")
            null
        query.startObject();
                    BytesReference.bytes(
        assertThat(exception.getCause(), instanceOf(QueryShardException.class));
        assertThat(e.getMessage(), containsString("Mapping definition for [" + fieldName + "] has unsupported parameters:  [index : no]"));
import org.opensearch.index.mapper.SourceToParse;
        assertTrue(extractionResultField.fieldType().omitNorms());
import org.opensearch.index.query.QueryShardException;
        assertEquals(7, rangesMap.size());
        assertThat(IntPoint.decodeDimension(fields.get(1).binaryValue().bytes, 12), equalTo(15));
        IndexMetadata build = IndexMetadata.builder("")
    }
        assertEquals("field1\u0000brown", terms.get(2).utf8ToString());
            .sorted()
        memoryIndex.addField(new FloatPoint("number_field5", 40f), new WhitespaceAnalyzer());
                        BytesReference.bytes(
                    "test",
            .parse(
                    ),
                    MediaTypeRegistry.JSON
                input.readVInt();
        IndexSettings settings = new IndexSettings(build, Settings.EMPTY);
        String percolatorMapper = XContentFactory.jsonBuilder()
            .endObject()
            }
                    )
    public void testExtractRanges() throws Exception {
        fields.sort(Comparator.comparing(IndexableField::binaryValue));
        assertEquals(0, t.v1().size());
import static org.hamcrest.Matchers.equalTo;
        return Arrays.copyOfRange(source, offset, offset + length);
        ParseContext.Document document = parseContext.doc();
    // percolator field can be nested under an object field, but only one query can be specified per document
            .endObject()
                )
                    throw new AssertionError("unexpected encoding type [" + encodingType + "]");
        assertThat(doc.rootDoc().getFields().size(), equalTo(12)); // also includes all other meta fields
        assertEquals("field4\u0000123", terms.get(13).utf8ToString());
        List<BytesRef> terms = t.v1();
                                .field("query_field", queryBuilder)
            .field("type", "percolator")
        PercolatorFieldMapper.verifyQuery(rangeQuery2);
        memoryIndex.addField("field1", text.toString(), new WhitespaceAnalyzer());
                    "test",
        MapperParsingException e = expectThrows(
            final byte[] encodedFrom;
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> {
        memoryIndex.addField(new HalfFloatPoint("number_field4", 30f), new WhitespaceAnalyzer());
        MapperParsingException exception = expectThrows(MapperParsingException.class, () -> {
            .startObject("properties")
                    MediaTypeRegistry.JSON
        QueryBuilder queryBuilder = matchQuery("field", "value");
            matchPhraseQuery("field", "value"),
        MemoryIndex memoryIndex = new MemoryIndex(false);
                    encodedFrom = new byte[Long.BYTES];
                )
        assertThat(doc.rootDoc().getFields().size(), equalTo(12)); // also includes all other meta fields
            .endObject()
            .field("type", "text")
        assertThat(exception.getMessage(), containsString("should not be invoked"));
        bq.add(termQuery1, Occur.MUST);
import org.opensearch.core.common.bytes.BytesArray;
        fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.minimumShouldMatchField.name())));
            () -> mapperService.merge(
                    )
            .field("type", "integer")
        assertQueryBuilder(qbSource, queryBuilder);
                default:
    }
        ParseContext.InternalParseContext parseContext = new ParseContext.InternalParseContext(
        assertEquals(1, rangesMap.size());
        query.startObject();
                                .field("query_field", queryBuilder)
            return Collections.singletonMap("return true", (vars) -> true);
        QueryBuilder queryBuilder = matchQuery("field", "value");
        expectThrows(
            () -> { throw new UnsupportedOperationException(); },
        expectThrows(IllegalArgumentException.class, () -> PercolatorFieldMapper.verifyQuery(new BoolQueryBuilder().must(hasChildQuery)));
        IndexableField extractionResultField = doc.rootDoc().getField("object_field.query_field.extraction_result");
    public void testAllowNoAdditionalSettings() throws Exception {
                    ),
        MemoryIndex memoryIndex = new MemoryIndex(false);
import org.opensearch.common.settings.Settings;
        assertThat(fields.get(0).binaryValue().utf8ToString(), equalTo("field\u0000term1"));
    }
        // (it can't use shard data for rewriting purposes, because percolator queries run on MemoryIndex)
        if (randomBoolean()) {
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
        assertEquals(InetAddresses.forString("192.168.1.12"), InetAddressPoint.decode(range.get(0)));
    public void testStoringQueries() throws Exception {
import org.opensearch.index.query.ScriptQueryBuilder;
            .startObject("object_field")
            try (StreamInput input = new NamedWriteableAwareStreamInput(new InputStreamStreamInput(in), writableRegistry())) {
 */
        UnsupportedOperationException exception = expectThrows(
        @Override
        List<IndexableField> fields = new ArrayList<>(Arrays.asList(document.getFields(fieldType.queryTermsField.name())));
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, queryBuilder).endObject()),
        addQueryFieldMappings();
            mapperService.documentMapperParser(),
            .endObject()
            .endObject()
            .parse(
    protected Collection<Class<? extends Plugin>> getPlugins() {
    private static byte[] subByteArray(byte[] source, int offset, int length) {
            );
        assertEquals("_field3\u0000me", terms.get(0).utf8ToString());
            mapperService.documentMapperParser(),
                    encodedTo = new byte[Long.BYTES];
                );
            .parse(
import static org.opensearch.index.query.QueryBuilders.wildcardQuery;
        queryBuilder = rangeQuery("field").from("a").to("z");
        assertThat(doc.rootDoc().getFields().size(), equalTo(16)); // also includes all other meta fields
                    "1",
import org.opensearch.index.mapper.DocumentMapper;
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field(fieldName, qb).endObject()),
        assertEquals("field1\u0000over", terms.get(7).utf8ToString());
                    "1",
        assertThat(document.getFields().size(), equalTo(1));
        range = rangesMap.get("number_field3");
        } else {
                        "test",
        addQueryFieldMappings();
/*
        List<byte[]> range = rangesMap.get("number_field1");
            .numberOfReplicas(0)
 * SPDX-License-Identifier: Apache-2.0
        assertThat(values.get(2), equalTo("field\0value3"));
        }
                input.readVInt();
            .endObject()
                new SourceToParse(
            null,
        Query rangeQuery1 = mapperService.fieldType("number_field1").rangeQuery(10, 20, true, true, null, null, null, context);
    public void testMultiplePercolatorFields() throws Exception {
                        MediaTypeRegistry.JSON
        addQueryFieldMappings();
                                .endObject()
    }
            .must(boolQuery().must(termQuery("field", "value2")).must(termQuery("field", "value3")));
            ParentJoinModulePlugin.class
        try {
        bq.add(termQuery2, Occur.MUST);
                    "test",
        PercolatorFieldMapper fieldMapper = (PercolatorFieldMapper) documentMapper.mappers().getMapper(fieldName);
        PlainActionFuture<QueryBuilder> future = new PlainActionFuture<>();
        HasChildQueryBuilder hasChildQuery = new HasChildQueryBuilder("parent", new MatchAllQueryBuilder(), ScoreMode.None);
import org.apache.lucene.search.Query;
                                .endObject()
            final int randomFrom = randomInt();
/*
                    ),
        IndexReader indexReader = memoryIndex.createSearcher().getIndexReader();
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
            .sorted()
        doc = mapperService.documentMapper()
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
import org.opensearch.script.MockScriptPlugin;
 * not use this file except in compliance with the License.
    @Override
                            .endObject()
        memoryIndex.addField("field1", "value1", new WhitespaceAnalyzer());
import org.opensearch.index.query.BoostingQueryBuilder;
    }
        // note: it important that range queries never rewrite, otherwise it will cause results to be wrong.
import org.opensearch.index.query.ConstantScoreQueryBuilder;
        PercolatorFieldMapper fieldMapper = (PercolatorFieldMapper) documentMapper.mappers().getMapper(fieldName);
        assertEquals("field1\u0000jumps", terms.get(5).utf8ToString());
        assertTrue(queryBuilderField.fieldType().omitNorms());
            );
        assertEquals(30F, HalfFloatPoint.decodeDimension(range.get(1), 0), 0F);
        } catch (MapperParsingException e) {
                    encodedTo = new byte[Integer.BYTES];
        }
                            .endObject()
 * You may obtain a copy of the License at
                        jsonBuilder().startObject()
import org.junit.Before;
                    )
            .numberOfShards(1)
            .endObject()
        assertEquals("_field3\u0000unhide", terms.get(1).utf8ToString());
        assertThat(values.get(2), equalTo("field\0value3"));
        memoryIndex.addField(new InetAddressPoint("number_field7", InetAddresses.forString("192.168.1.24")), new WhitespaceAnalyzer());
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
        terms.sort(BytesRef::compareTo);
            null
        assertThat(IntPoint.decodeDimension(fields.get(0).binaryValue().bytes, 12), equalTo(10));
            .startObject("field")
        bq.add(rangeQuery1, Occur.MUST);
            query.field("source", "return true");
        doc = mapperService.documentMapper()
import org.opensearch.common.xcontent.XContentFactory;
import java.util.Map;
                    new SourceToParse(
            .field("type", "float")
            query.endObject();
        for (int i = 0; i < 1022; i++) {
        assertThat(e.getCause().getMessage(), equalTo("a document can only contain one percolator query"));
        mapperService.merge(typeName, new CompressedXContent(percolatorMapper), MapperService.MergeReason.MAPPING_UPDATE);
        assertThat(t.v1().clauses().get(0).query(), instanceOf(CoveringQuery.class));
        @Override
import org.opensearch.index.query.RangeQueryBuilder;
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
                    assertEquals(hash.h1, ByteBuffer.wrap(subByteArray(result, 0, 8)).getLong());
                    "test",
            .endObject()
        );
        assertEquals(30F, HalfFloatPoint.decodeDimension(range.get(0), 0), 0F);
    }
        return pluginList(
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .map(f -> f.binaryValue().utf8ToString())
        assertEquals(10, IntPoint.decodeDimension(range.get(1), 0));
        IndexMetadata build = IndexMetadata.builder("")
            query.endObject();
        assertThat(t.v1().clauses().get(2).query().toString(), containsString(fieldName + ".extraction_result:failed"));
        assertEquals("field1\u0000dog", terms.get(3).utf8ToString());
                        "1",
        PercolatorFieldMapper.PercolatorFieldType fieldType = (PercolatorFieldMapper.PercolatorFieldType) fieldMapper.fieldType();
                new SourceToParse(
import org.opensearch.index.mapper.MapperService;
            .field("type", "text")
        String mapper = XContentFactory.jsonBuilder()
import org.opensearch.common.network.InetAddresses;
 * this work for additional information regarding copyright
            settings,
        PhraseQuery phraseQuery = new PhraseQuery("field", "term");
public class PercolatorFieldMapperTests extends OpenSearchSingleNodeTestCase {
        assertEquals(10, LongPoint.decodeDimension(range.get(0), 0));
        int msm = doc.rootDoc().getFields(fieldType.minimumShouldMatchField.name())[0].numericValue().intValue();
        // add an query for which we don't extract terms from
import static org.opensearch.index.query.QueryBuilders.matchQuery;
import org.opensearch.index.query.DisMaxQueryBuilder;
                    break;
        assertEquals(1, t.v2().size());
            documentMapper,
                    "test",
                    assertEquals(randomFrom, LongPoint.decodeDimension(subByteArray(result, 8, 8), 0));
            .parse(
                .parse(
            .toString();
                // then the length of the field value in bytes.
import org.apache.lucene.search.BooleanQuery;
                    throw new AssertionError("unexpected encoding type [" + encodingType + "]");
            null,
import org.opensearch.cluster.metadata.IndexMetadata;
                        jsonBuilder().startObject().field("query_field1", queryBuilder).field("query_field2", queryBuilder).endObject()
import org.apache.lucene.document.IntPoint;
            .collect(Collectors.toList());
 *    http://www.apache.org/licenses/LICENSE-2.0
                    new SourceToParse(
import java.util.Comparator;
        assertEquals(30L, LongPoint.decodeDimension(range.get(1), 0));
import org.opensearch.join.query.HasChildQueryBuilder;
                input.readVInt();
        assertThat(document.getField(fieldType.extractionResultField.name()).stringValue(), equalTo(EXTRACTION_FAILED));
                    ),
            UnsupportedOperationException.class,
        assertThat(values.get(4), equalTo("field\0value5"));
        IndexService indexService = createIndex("test1", Settings.EMPTY);
        assertQueryBuilder(qbSource, queryBuilder);
                // This is the reason we need to first need to read the number of values and
    }
            .endObject()
        fieldName = randomAlphaOfLength(4);
        assertThat(IntPoint.decodeDimension(fields.get(1).binaryValue().bytes, 28), equalTo(20));
import java.util.ArrayList;
            .field("type", "percolator")
        addQueryFieldMappings();
                    BytesReference.bytes(
            .endObject()
                    break;
        bq.add(rangeQuery1, Occur.MUST);
        assertThat(doc.rootDoc().getFields(fieldType.extractionResultField.name())[0].stringValue(), equalTo(EXTRACTION_COMPLETE));
    private PercolatorFieldMapper.PercolatorFieldType fieldType;
        assertThat(fields.get(0).numericValue(), equalTo(1L));
        assertThat(doc.rootDoc().getFields(fieldType.queryTermsField.name()).length, equalTo(0));
                    MediaTypeRegistry.JSON
        range = rangesMap.get("number_field4");
        addQueryFieldMappings();
        DocumentMapper documentMapper = mapperService.documentMapper();
        assertEquals(10, LongPoint.decodeDimension(range.get(1), 0));
            switch (encodingType) {
        expectThrows(
        assertTrue(t.v2());
    public void testUnsupportedQueries() {
        fieldMapper.processQuery(bq.build(), parseContext);
            );
        query.endObject();
            try (StreamInput input = new NamedWriteableAwareStreamInput(new InputStreamStreamInput(in), writableRegistry())) {
        assertNotNull(range);
import java.util.Collection;
        );
                    "test",
        addQueryFieldMappings();
 * specific language governing permissions and limitations
            null
            .endObject()
        Map<String, List<byte[]>> rangesMap = t.v2();
            switch (encodingType) {
import java.util.Arrays;
        });
        assertThat(doc.rootDoc().getFields(fieldType.queryTermsField.name()).length, equalTo(1));
                    "1",
        query.endObject();
                    MediaTypeRegistry.JSON
            rangeQuery("date_field").from("2015-01-01T00:00").to("2015-01-01T00:00") };
        MemoryIndex memoryIndex = new MemoryIndex(false);
