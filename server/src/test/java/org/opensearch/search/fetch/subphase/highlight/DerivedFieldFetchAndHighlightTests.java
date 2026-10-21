                QueryShardContext mockShardContext = createQueryShardContext(mapperService, searcher);
            .put("index.number_of_shards", 1)
            mapperService,
                        searchHit,
                        new TermQuery(new Term(DERIVED_FIELD_4 + "." + NESTED_FIELD, "foo"))
            null,
                                "object",
                    );
                    FetchSubPhase.HitContext hitContext = new FetchSubPhase.HitContext(
        );
                        context,
            .field("source", DERIVED_FIELD_SCRIPT_2)
                        context,
                    assertEquals("foo bar baz", nestedFields.get(DERIVED_FIELD_4 + "." + NESTED_FIELD).getValue());
                (script) -> ((Map<String, Object>) script.get("_source")).get("field4")
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.opensearch.index.mapper.DerivedFieldResolverFactory;
        );
            .startObject("script")
                {
        // Define mapping for derived fields, create 2 derived fields derived_1 and derived_2
                        List.of(
                        true,
                    assertEquals(hitContext.hit().getHighlightFields().size(), 1);
                );
                        fetchContext,
public class DerivedFieldFetchAndHighlightTests extends OpenSearchSingleNodeTestCase {
        final Map<String, ScriptEngine> engines = singletonMap(engine.getType(), engine);
                        mockShardContext.lookup().source()
                    );
                    // Create a HitContext of search hit
            null,
import org.opensearch.index.IndexSettings;
                    hitContext.sourceLookup().loadSourceIfNeeded();
                    assertEquals(hitContext.hit().getHighlightFields().size(), 1);
                mockShardContext.lookup().source().setSegmentAndDocument(context, docId);
                            new DerivedField(
                    assertEquals("some_text_2", fields.get(DERIVED_FIELD_2).getValue());
                    // Validate that 1 highlight field is present
            .endObject()
                        null
                when(fetchContext.mapperService()).thenReturn(mapperService);
                    // Create a HitContext of search hit
                    assertEquals(1, fields.get(DERIVED_FIELD_4).getValues().size());
                            new DerivedField(
                {
                mapperService.documentMapper()
                IndexSearcher searcher = newSearcher(reader);
import org.opensearch.index.query.Rewriteable;
                        fetchContext,
import org.opensearch.core.xcontent.XContentBuilder;
                mockShardContext.setDerivedFieldResolver(
                }
                mapperService.documentMapper()
                    new ContextIndexSearcher(
            Directory dir = newDirectory();
                    );
        return new QueryShardContext(
                    );
                        context,
                            )
                    // The query used by FetchSubPhaseProcessor to highlight is a term query on DERIVED_FIELD_1
import org.opensearch.common.settings.Settings;
                Map<String, DocumentField> fields = fetchFields(mockShardContext, context, "*");
                    // Create a search hit using the derived fields fetched above in fetch phase
                    FetchSubPhase.HitContext hitContext = new FetchSubPhase.HitContext(
                // Validate FetchPhase
                        IndexSearcher.getDefaultQueryCachingPolicy(),
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().endObject();
                    )
import org.opensearch.cluster.metadata.IndexMetadata;
                    // process the HitContext using the highlightPhase subPhaseProcessor
                        docId,
                when(fetchContext.getQueryShardContext()).thenReturn(mockShardContext);
 */
            .endObject()
    private static String DERIVED_FIELD_1 = "derived_1";
        final MockScriptEngine engine = new MockScriptEngine(
import org.opensearch.search.SearchHit;
}
import java.io.IOException;
        QueryShardContext queryShardContext,
                {
        FieldFetcher fieldFetcher = FieldFetcher.create(queryShardContext, queryShardContext.lookup(), fields);
            .field("format", "yyyy-MM-dd")
                (script) -> ((String) ((Map<String, Object>) script.get("_source")).get("field1")).replace(" ", "_"),
                            derivedField3,
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
            .startObject(DERIVED_FIELD_3)
 *
            .startObject("script")
                    new ContextIndexSearcher(
    private static String NESTED_FIELD = "field";
import org.opensearch.common.document.DocumentField;
                    "date",
                            new DerivedField(
import org.apache.lucene.index.IndexWriterConfig;
                highlightBuilder.highlighterType("unified");
                        IndexSearcher.getDefaultQueryCache(),
                        reader,
            iw.addDocument(
                    // Validate that 1 highlight field is present
                highlightBuilder.highlighterType("unified");
                    // Validate that 1 highlight field is present
                    assertEquals("2024-03-20", fields.get(DERIVED_FIELD_3).getValue());
import org.opensearch.search.fetch.subphase.FieldFetcher;
                DERIVED_FIELD_SCRIPT_1,
                // create a fetch context to be used by HighlightPhase processor
import org.apache.lucene.index.LeafReaderContext;
                    );
                        searchHit,
            .field("lang", "mockscript")
import org.opensearch.script.ScriptModule;
                        reader,
                HighlightBuilder highlightBuilder = new HighlightBuilder();
import org.opensearch.search.fetch.FetchContext;
        ScriptService scriptService = getScriptService();
            );
        // derived_1 will act on field1 and derived_2 will act on derived_2. DERIVED_FIELD_SCRIPT_1 substitutes whitespaces with _
                // Validate FetchPhase
        LeafReaderContext context,
                // mockShardContext.setDerivedFieldTypes(Map.of("derived_2", createDerivedFieldType("derived_1", "keyword"), "derived_1",
        IndexService indexService = createIndex("test_index", Settings.EMPTY, mapping);
                // Create a HighlightPhase with highlighter defined above
                highlightBuilder.field(DERIVED_FIELD_1);
import org.opensearch.common.xcontent.XContentFactory;
                                DERIVED_FIELD_1,
    }
import org.opensearch.index.mapper.SourceToParse;
            .put("index.version.created", Version.CURRENT)
            null,
        }
            .field("source", DERIVED_FIELD_SCRIPT_3)
                {
            .field("source", DERIVED_FIELD_SCRIPT_1)
                    assertEquals("{ \"field\": \"foo bar baz\"}", fields.get(DERIVED_FIELD_4).getValue());
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);
                }
                    assertEquals(1, fields.get(DERIVED_FIELD_2).getValues().size());
import java.util.Map;
            RandomIndexWriter iw = new RandomIndexWriter(random(), dir, new IndexWriterConfig(mapperService.indexAnalyzer()));
            .field("lang", "mockscript")
import org.apache.lucene.store.Directory;
                Map<String, DocumentField> fields = fetchFields(mockShardContext, context, "derived_*");
                    // test highlighting nested field DERIVED_FIELD_4 + "." + NESTED_FIELD
            .put("index.number_of_replicas", 0)
 * compatible open source license.
                        IndexSearcher.getDefaultSimilarity(),
                }
            iw.addDocument(
                highlightBuilder = Rewriteable.rewrite(highlightBuilder, mockShardContext);
                    assertEquals(1, nestedFields.get(DERIVED_FIELD_4 + "." + NESTED_FIELD).getValues().size());
import org.opensearch.index.mapper.MapperService;
                    )
                // Create a HighlightPhase with highlighter defined above
            );
                Map<String, DocumentField> nestedFields = fetchFields(mockShardContext, context, DERIVED_FIELD_4 + "." + NESTED_FIELD);
                // Create a HighlightBuilder of type unified, set its fields as derived_1 and derived_2
            .endObject()
            .endObject();
                    FetchSubPhase.HitContext hitContext = new FetchSubPhase.HitContext(
            null,
                (script) -> ((String) ((Map<String, Object>) script.get("_source")).get("field2")).replace(" ", "_"),
            .field("type", "keyword")
                                "keyword",
                    DERIVED_FIELD_3,
            .startObject("script")
import org.opensearch.index.query.QueryShardContext;
            indexSettings,
                            ),
                // Assert the fetch phase works for both of the derived fields
                Map<String, DocumentField> nestedFields = fetchFields(mockShardContext, context, DERIVED_FIELD_4 + "." + NESTED_FIELD);
            .field("field1", "some_text_1")
            .field("field2", "some_text_2")
import org.opensearch.index.mapper.DerivedField;
import org.opensearch.index.mapper.DefaultDerivedFieldResolver;
    private static String DERIVED_FIELD_SCRIPT_3 = "derived_field_script_3";
            .field("field4", "{ \"field\": \"foo bar baz\"}")
    private static QueryShardContext createQueryShardContext(MapperService mapperService, IndexSearcher indexSearcher) {
                when(fetchContext.searcher()).thenReturn(
                    FetchSubPhase.HitContext hitContext = new FetchSubPhase.HitContext(
                    // Create a HitContext of search hit
                        fetchContext,
                    new Script(ScriptType.INLINE, "mockscript", DERIVED_FIELD_SCRIPT_3, emptyMap())
                        searchHighlightContext,
            .field("field2", "some_text_2")
    public void testDerivedFieldFromSearchMapping() throws IOException {
            MockScriptEngine.NAME,
                        mockShardContext.lookup().source()
        List<FieldAndFormat> fields = List.of(new FieldAndFormat(fieldPattern, null));
            .endObject()
        ) {
                    (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
import org.apache.lucene.tests.index.RandomIndexWriter;
                highlightBuilder.field(DERIVED_FIELD_4 + "." + NESTED_FIELD);
        String fieldPattern
                when(fetchContext.mapperService()).thenReturn(mapperService);
        MapperService mapperService = indexService.mapperService();
                    // The query used by FetchSubPhaseProcessor to highlight is a term query on DERIVED_FIELD_1
                highlightBuilder.field(DERIVED_FIELD_2);
                DERIVED_FIELD_SCRIPT_2,
import org.apache.lucene.search.TermQuery;
        try (
                    assertEquals("some_text_1", fields.get(DERIVED_FIELD_1).getValue());
                        IndexSearcher.getDefaultQueryCachingPolicy(),
                                "keyword",
        fieldFetcher.setNextReader(context);
    private static String DERIVED_FIELD_4 = "derived_4";
            .endObject()
package org.opensearch.search.fetch.subphase.highlight;
                        context,
            null,
            .endObject();
                );
                        docId,
                    SearchHit searchHit = new SearchHit(docId, "0", null, fields, null);
            .build();
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")
                    subPhaseProcessor.process(hitContext);
                mockShardContext.lookup().source().setSegmentAndDocument(context, docId);
                        IndexSearcher.getDefaultQueryCache(),
import org.apache.lucene.search.IndexSearcher;
        // Create source document with 2 fields field1 and field2.
        // Create index and mapper service
            .field("field3", 1710923445000L)
import static java.util.Collections.emptyMap;
                // create a fetch context to be used by HighlightPhase processor
                    assertEquals(fields.size(), 4);
                        null,
                                new Script(ScriptType.INLINE, "mockscript", DERIVED_FIELD_SCRIPT_4, emptyMap())
                    assertEquals("foo bar baz", nestedFields.get(DERIVED_FIELD_4 + "." + NESTED_FIELD).getValue());
                    FetchSubPhaseProcessor subPhaseProcessor = highlightPhase.getProcessor(
                    // Create a search hit using the derived fields fetched above in fetch phase
import org.opensearch.core.common.bytes.BytesReference;
                        new TermQuery(new Term(DERIVED_FIELD_4 + "." + NESTED_FIELD, "foo"))
                when(fetchContext.getIndexSettings()).thenReturn(indexService.getIndexSettings());
                    assertEquals(1, fields.get(DERIVED_FIELD_2).getValues().size());
                                new Script(ScriptType.INLINE, "mockscript", DERIVED_FIELD_SCRIPT_2, emptyMap())
                        true,
        }
                        mockShardContext.lookup().source()
import java.util.List;
                        mockShardContext.lookup().source()
    public static Map<String, DocumentField> fetchFields(
                        searchHighlightContext,
                    assertEquals(1, fields.get(DERIVED_FIELD_3).getValues().size());
            RandomIndexWriter iw = new RandomIndexWriter(random(), dir, new IndexWriterConfig(mapperService.indexAnalyzer()));
                        mockShardContext,
            .field("lang", "mockscript")
                DerivedField derivedField3 = new DerivedField(
            .field("source", DERIVED_FIELD_SCRIPT_4)
                }
                        null
    }
                highlightBuilder = Rewriteable.rewrite(highlightBuilder, mockShardContext);
                SearchHighlightContext searchHighlightContext = highlightBuilder.build(mockShardContext);
                        searchHighlightContext,
            .endObject()
    ) throws IOException {
                    assertEquals(1, fields.get(DERIVED_FIELD_3).getValues().size());
            indexSearcher,
                    assertEquals(hitContext.hit().getHighlightFields().size(), 1);
            .startObject(DERIVED_FIELD_2)
            .startObject("derived")
            null,
            .endObject()
    private static String DERIVED_FIELD_SCRIPT_4 = "derived_field_script_4";
                    );
                {
            .startObject()
                        new TermQuery(new Term(DERIVED_FIELD_1, "some_text_1"))
                    // process the HitContext using the highlightPhase subPhaseProcessor
                    FetchSubPhaseProcessor subPhaseProcessor = highlightPhase.getProcessor(
                QueryShardContext mockShardContext = createQueryShardContext(mapperService, searcher);
import org.opensearch.script.ScriptService;
            null,
                }
        int docId = 0;
                        null,
import static java.util.Collections.singletonMap;
                highlightBuilder.field(DERIVED_FIELD_1);
        int docId = 0;
            null,
            null,
                    )
                        new TermQuery(new Term(DERIVED_FIELD_1, "some_text_1"))
                    assertEquals(1, nestedFields.get(DERIVED_FIELD_4 + "." + NESTED_FIELD).getValues().size());
            .field("field3", 1710923445000L)
        IndexService indexService = createIndex("test_index", Settings.EMPTY, mapping);
import org.apache.lucene.index.Term;
                }
    public void testDerivedFieldFromIndexMapping() throws IOException {
            }
        Settings settings = Settings.builder()
            }
            .startObject("script")
                    hitContext.sourceLookup().loadSourceIfNeeded();
        return fieldFetcher.fetch(queryShardContext.lookup().source(), Set.of());
    private static String DERIVED_FIELD_3 = "derived_3";
                DERIVED_FIELD_SCRIPT_4,
                    assertEquals("20-03-2024", fields.get(DERIVED_FIELD_3).getValue());
/*
            .field("type", "keyword")
            .startObject()
import org.opensearch.script.ScriptEngine;
            ),
        try (
                        ),
                highlightBuilder.field(DERIVED_FIELD_2);
                    subPhaseProcessor.process(hitContext);
            .startObject(DERIVED_FIELD_4)
    private static String DERIVED_FIELD_2 = "derived_2";
                    // Validate that 1 highlight field is present
                    FetchSubPhaseProcessor subPhaseProcessor = highlightPhase.getProcessor(
            Directory dir = newDirectory();
                        true
                    assertEquals(fields.size(), 4);
                    .parse(new SourceToParse("test_index", "0", BytesReference.bytes(source), MediaTypeRegistry.JSON))
                when(fetchContext.getQueryShardContext()).thenReturn(mockShardContext);
                // Create a HighlightBuilder of type unified, set its fields as derived_1 and derived_2
                    FetchSubPhaseProcessor subPhaseProcessor = highlightPhase.getProcessor(
                        null,
                        searchHit,
import java.util.Set;
                HighlightPhase highlightPhase = new HighlightPhase(Collections.singletonMap("unified", new UnifiedHighlighter()));
                    subPhaseProcessor.process(hitContext);
                    .rootDoc()
        // Create index and mapper service
                    assertEquals(1, fields.get(DERIVED_FIELD_1).getValues().size());
            .endObject()
                LeafReaderContext context = searcher.getIndexReader().leaves().get(0);
                    // The query used by FetchSubPhaseProcessor to highlight is a term query on DERIVED_FIELD_1
            .field("lang", "mockscript")
                    );
    }
    private static String DERIVED_FIELD_SCRIPT_1 = "derived_field_script_1";
                    hitContext.sourceLookup().loadSourceIfNeeded();
                SearchHighlightContext searchHighlightContext = highlightBuilder.build(mockShardContext);
            try (IndexReader reader = iw.getReader()) {
            .field("type", "date")
                                DERIVED_FIELD_2,
                derivedField3.setFormat("dd-MM-yyyy");
                    subPhaseProcessor.process(hitContext);
            .startObject()
                (script) -> ((Map<String, Object>) script.get("_source")).get("field3"),
import org.opensearch.script.Script;
                    // process the HitContext using the highlightPhase subPhaseProcessor
                FetchContext fetchContext = mock(FetchContext.class);
                {
                // Assert the fetch phase works for both of the derived fields
            .endObject()
                        docId,
        MapperService mapperService = indexService.mapperService();
                        searchHit,
                highlightBuilder.field(DERIVED_FIELD_4 + "." + NESTED_FIELD);
        return scriptService;
                // This mock behavior is similar to adding derived fields in search request
import org.opensearch.search.internal.ContextIndexSearcher;
                    // Create a HitContext of search hit
                    assertEquals("some_text_2", fields.get(DERIVED_FIELD_2).getValue());
            Map.of(
                    SearchHit searchHit = new SearchHit(docId, "0", null, fields, null);
                HighlightBuilder highlightBuilder = new HighlightBuilder();
        ) {
                when(fetchContext.searcher()).thenReturn(
import org.opensearch.Version;
import static org.mockito.Mockito.when;
        ScriptService scriptService = new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
    private static ScriptService getScriptService() {
    }
                HighlightPhase highlightPhase = new HighlightPhase(Collections.singletonMap("unified", new UnifiedHighlighter()));
                    // Create a search hit using the derived fields fetched above in fetch phase
import org.opensearch.core.xcontent.MediaTypeRegistry;
                        IndexSearcher.getDefaultSimilarity(),
            0,
    private static String DERIVED_FIELD_SCRIPT_2 = "derived_field_script_2";
import java.util.Collections;
                    assertEquals(1, fields.get(DERIVED_FIELD_4).getValues().size());
        XContentBuilder source = XContentFactory.jsonBuilder()
        XContentBuilder source = XContentFactory.jsonBuilder()
import org.opensearch.search.fetch.FetchSubPhase;
        // Create source document with 2 fields field1 and field2.
    }
            null,
                    .rootDoc()
            .field("field1", "some_text_1")
                    assertEquals("{ \"field\": \"foo bar baz\"}", fields.get(DERIVED_FIELD_4).getValue());
                    assertEquals(1, fields.get(DERIVED_FIELD_1).getValues().size());
                        fetchContext,
            () -> true,
                );
                                DERIVED_FIELD_4,
            scriptService,
import static org.mockito.Mockito.mock;
        // derived_1 will act on field1 and derived_2 will act on derived_2. DERIVED_FIELD_SCRIPT_1 substitutes whitespaces with _
                IndexSearcher searcher = newSearcher(reader);
                LeafReaderContext context = searcher.getIndexReader().leaves().get(0);
                    // process the HitContext using the highlightPhase subPhaseProcessor
            .startObject(DERIVED_FIELD_1)
                    hitContext.sourceLookup().loadSourceIfNeeded();
 * The OpenSearch Contributors require contributions made to
                when(fetchContext.getIndexSettings()).thenReturn(indexService.getIndexSettings());
        // We are not defining derived fields in index mapping here
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
                            ),
                    assertEquals(hitContext.hit().getHighlightFields().size(), 1);
            .field("type", "object")
 * this file be licensed under the Apache-2.0 license or a
                FetchContext fetchContext = mock(FetchContext.class);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.script.ScriptType;
                    SearchHit searchHit = new SearchHit(docId, "0", null, nestedFields, null);
                    );
import org.opensearch.script.MockScriptEngine;
                    assertEquals("some_text_1", fields.get(DERIVED_FIELD_1).getValue());
                        searchHighlightContext,
                    SearchHit searchHit = new SearchHit(docId, "0", null, nestedFields, null);
                    .parse(new SourceToParse("test_index", "0", BytesReference.bytes(source), MediaTypeRegistry.JSON))
            .endObject();
                    // Create a search hit using the derived fields fetched above in fetch phase
            try (IndexReader reader = iw.getReader()) {
import org.opensearch.search.fetch.subphase.FieldAndFormat;
            null
                                new Script(ScriptType.INLINE, "mockscript", DERIVED_FIELD_SCRIPT_1, emptyMap())
                        docId,
import org.apache.lucene.index.IndexReader;
                DERIVED_FIELD_SCRIPT_3,
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                );
import org.opensearch.index.IndexService;
            .field("field4", "{ \"field\": \"foo bar baz\"}")
            Collections.emptyMap()
