                // Create a HighlightPhase with highlighter defined above
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
                    FetchSubPhase.HitContext hitContext = new FetchSubPhase.HitContext(  
            .endObject()
                        new TermQuery(new Term(DERIVED_FIELD_4 + "." + NESTED_FIELD, "foo"))
                    assertEquals(fields.size(), 4);  
        final MockScriptEngine engine = new MockScriptEngine(
                        searchHighlightContext,
import org.opensearch.search.SearchHit;
        // derived_1 will act on field1 and derived_2 will act on derived_2. DERIVED_FIELD_SCRIPT_1 substitutes whitespaces with _
                {
                        mockShardContext,  
                // Assert the fetch phase works for both of the derived fields  
        final Map<String, ScriptEngine> engines = singletonMap(engine.getType(), engine);  
            indexSearcher,  
                    hitContext.sourceLookup().loadSourceIfNeeded();  
        fieldFetcher.setNextReader(context);  
        XContentBuilder source = XContentFactory.jsonBuilder()
            .field("lang", "mockscript")
                );
                        IndexSearcher.getDefaultQueryCachingPolicy(),
            Map.of(  
                );
        // derived_1 will act on field1 and derived_2 will act on derived_2. DERIVED_FIELD_SCRIPT_1 substitutes whitespaces with _
    }  
                    subPhaseProcessor.process(hitContext);
            .endObject()
            }
            () -> true,
                QueryShardContext mockShardContext = createQueryShardContext(mapperService, searcher);
    private static String NESTED_FIELD = "field";
                        context,
                    assertEquals("2024-03-20", fields.get(DERIVED_FIELD_3).getValue());
                    );
                    hitContext.sourceLookup().loadSourceIfNeeded();
                        searchHit,  
                highlightBuilder = Rewriteable.rewrite(highlightBuilder, mockShardContext);
            .startObject("script")
import org.opensearch.common.xcontent.XContentFactory;
                // create a fetch context to be used by HighlightPhase processor
                    assertEquals(1, fields.get(DERIVED_FIELD_2).getValues().size());
            null,  
                {
            null,  
    }
                    "date",
                    FetchSubPhaseProcessor subPhaseProcessor = highlightPhase.getProcessor(
                        context,
                // Validate FetchPhase
                                "keyword",
                }
import org.opensearch.cluster.metadata.IndexMetadata;
            .field("type", "keyword")  
                    .rootDoc()  
            RandomIndexWriter iw = new RandomIndexWriter(random(), dir, new IndexWriterConfig(mapperService.indexAnalyzer()));
        );
            Collections.emptyMap()
                    )  
            .put("index.number_of_shards", 1)
    private static String DERIVED_FIELD_3 = "derived_3";  
import org.opensearch.search.fetch.FetchSubPhase;
        IndexService indexService = createIndex("test_index", Settings.EMPTY, mapping);  
        return new QueryShardContext(  
                                new Script(ScriptType.INLINE, "mockscript", DERIVED_FIELD_SCRIPT_1, emptyMap())  
                        searchHighlightContext,  
        ) {
    private static String DERIVED_FIELD_SCRIPT_1 = "derived_field_script_1";
                                "object",
 * this file be licensed under the Apache-2.0 license or a
            null,
                highlightBuilder.field(DERIVED_FIELD_4 + "." + NESTED_FIELD);  
    private static String DERIVED_FIELD_1 = "derived_1";
    private static String DERIVED_FIELD_4 = "derived_4";
    }
                    FetchSubPhaseProcessor subPhaseProcessor = highlightPhase.getProcessor(
                    // Create a search hit using the derived fields fetched above in fetch phase
import org.apache.lucene.index.IndexReader;
                    assertEquals(1, fields.get(DERIVED_FIELD_2).getValues().size());
        try (
            iw.addDocument(
        ScriptService scriptService = new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
                }
                    // The query used by FetchSubPhaseProcessor to highlight is a term query on DERIVED_FIELD_1  
                        true,  
                    assertEquals(1, fields.get(DERIVED_FIELD_1).getValues().size());
import java.io.IOException;
                        IndexSearcher.getDefaultQueryCache(),
                (script) -> ((String) ((Map<String, Object>) script.get("_source")).get("field1")).replace(" ", "_"),
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
    private static String DERIVED_FIELD_SCRIPT_4 = "derived_field_script_4";
                FetchContext fetchContext = mock(FetchContext.class);
                }
                highlightBuilder = Rewriteable.rewrite(highlightBuilder, mockShardContext);
                                DERIVED_FIELD_2,  
            .build();
                    // process the HitContext using the highlightPhase subPhaseProcessor
                highlightBuilder.field(DERIVED_FIELD_1);
                        mockShardContext.lookup().source()  
import org.opensearch.index.IndexSettings;  
        // We are not defining derived fields in index mapping here
import org.opensearch.script.ScriptType;
                Map<String, DocumentField> nestedFields = fetchFields(mockShardContext, context, DERIVED_FIELD_4 + "." + NESTED_FIELD);
            .field("source", DERIVED_FIELD_SCRIPT_2)
 * compatible open source license.
import org.opensearch.common.settings.Settings;  
import org.apache.lucene.search.TermQuery;  
            .field("field4", "{ \"field\": \"foo bar baz\"}")
                    .parse(new SourceToParse("test_index", "0", BytesReference.bytes(source), MediaTypeRegistry.JSON))
            .field("lang", "mockscript")
    private static String DERIVED_FIELD_SCRIPT_3 = "derived_field_script_3";
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                    );
    private static QueryShardContext createQueryShardContext(MapperService mapperService, IndexSearcher indexSearcher) {
import org.apache.lucene.tests.index.RandomIndexWriter;
                LeafReaderContext context = searcher.getIndexReader().leaves().get(0);
import static java.util.Collections.emptyMap;
        MapperService mapperService = indexService.mapperService();
import org.opensearch.search.internal.ContextIndexSearcher;
            .field("field2", "some_text_2")
                    FetchSubPhase.HitContext hitContext = new FetchSubPhase.HitContext(
                highlightBuilder.highlighterType("unified");  
                    // The query used by FetchSubPhaseProcessor to highlight is a term query on DERIVED_FIELD_1
                mockShardContext.lookup().source().setSegmentAndDocument(context, docId);  
        IndexService indexService = createIndex("test_index", Settings.EMPTY, mapping);
                // Assert the fetch phase works for both of the derived fields  
            .startObject()
    }  
                        new TermQuery(new Term(DERIVED_FIELD_1, "some_text_1"))
                    assertEquals("{ \"field\": \"foo bar baz\"}", fields.get(DERIVED_FIELD_4).getValue());
import org.opensearch.script.ScriptModule;
        ) {  
                    // Validate that 1 highlight field is present
                );
                when(fetchContext.getIndexSettings()).thenReturn(indexService.getIndexSettings());
                    // Validate that 1 highlight field is present  
                    // Create a HitContext of search hit
                            new DerivedField(
                when(fetchContext.getIndexSettings()).thenReturn(indexService.getIndexSettings());
}
            null,
 * The OpenSearch Contributors require contributions made to  
            .field("source", DERIVED_FIELD_SCRIPT_4)
                }  
                    // Create a HitContext of search hit
import org.apache.lucene.store.Directory;
        }
                        fetchContext,
            .field("format", "yyyy-MM-dd")
                // Create a HighlightBuilder of type unified, set its fields as derived_1 and derived_2
            .field("field4", "{ \"field\": \"foo bar baz\"}")
        int docId = 0;
                        null,
            .startObject(DERIVED_FIELD_3)  
                mockShardContext.lookup().source().setSegmentAndDocument(context, docId);
                    // Validate that 1 highlight field is present  
            );
                    assertEquals(hitContext.hit().getHighlightFields().size(), 1);
                SearchHighlightContext searchHighlightContext = highlightBuilder.build(mockShardContext);
import org.opensearch.common.document.DocumentField;
            .endObject()  
import org.opensearch.script.Script;  
            iw.addDocument(  
                    assertEquals(1, nestedFields.get(DERIVED_FIELD_4 + "." + NESTED_FIELD).getValues().size());  
                highlightBuilder.highlighterType("unified");  
            .endObject()
                mapperService.documentMapper()
            null,
                // Create a HighlightPhase with highlighter defined above
import org.opensearch.index.mapper.DefaultDerivedFieldResolver;
import org.apache.lucene.index.LeafReaderContext;  
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().endObject();
public class DerivedFieldFetchAndHighlightTests extends OpenSearchSingleNodeTestCase {
import org.opensearch.index.mapper.MapperService;
            try (IndexReader reader = iw.getReader()) {  
                                DERIVED_FIELD_4,  
        // Create index and mapper service  
            .field("source", DERIVED_FIELD_SCRIPT_3)
        FieldFetcher fieldFetcher = FieldFetcher.create(queryShardContext, queryShardContext.lookup(), fields);
                    assertEquals(hitContext.hit().getHighlightFields().size(), 1);
                DERIVED_FIELD_SCRIPT_1,
import org.opensearch.core.common.bytes.BytesReference;
            .startObject()  
            .field("source", DERIVED_FIELD_SCRIPT_1)
            .field("lang", "mockscript")  
            .startObject(DERIVED_FIELD_4)
                    FetchSubPhaseProcessor subPhaseProcessor = highlightPhase.getProcessor(
import org.opensearch.core.xcontent.XContentBuilder;
                    // process the HitContext using the highlightPhase subPhaseProcessor
/*  
                        docId,  
                        context,
                        ),
                    FetchSubPhaseProcessor subPhaseProcessor = highlightPhase.getProcessor(
import org.opensearch.script.ScriptService;  
                                new Script(ScriptType.INLINE, "mockscript", DERIVED_FIELD_SCRIPT_4, emptyMap())
        Settings settings = Settings.builder()
import java.util.List;
                        searchHit,
    }  
                    // Create a search hit using the derived fields fetched above in fetch phase
            .put("index.version.created", Version.CURRENT)  
                IndexSearcher searcher = newSearcher(reader);  
            Directory dir = newDirectory();  
                            derivedField3,
                    FetchSubPhase.HitContext hitContext = new FetchSubPhase.HitContext(  
import org.apache.lucene.index.Term;
import org.opensearch.index.mapper.SourceToParse;
                        null
import java.util.Set;  
                        searchHighlightContext,  
            .startObject("script")  
            mapperService,  
import static java.util.Collections.singletonMap;  
import org.opensearch.search.fetch.FetchContext;  
            null,  
            .field("type", "date")
            .field("lang", "mockscript")  
                HighlightBuilder highlightBuilder = new HighlightBuilder();
                    new Script(ScriptType.INLINE, "mockscript", DERIVED_FIELD_SCRIPT_3, emptyMap())  
            .field("type", "keyword")
                when(fetchContext.searcher()).thenReturn(  
        ScriptService scriptService = getScriptService();
                    assertEquals(1, fields.get(DERIVED_FIELD_4).getValues().size());
            .field("type", "object")  
        String fieldPattern
                    assertEquals(1, fields.get(DERIVED_FIELD_3).getValues().size());  
                    assertEquals(hitContext.hit().getHighlightFields().size(), 1);
            null,
    public static Map<String, DocumentField> fetchFields(
                when(fetchContext.getQueryShardContext()).thenReturn(mockShardContext);
import org.opensearch.index.mapper.DerivedFieldResolverFactory;  
                    assertEquals("some_text_1", fields.get(DERIVED_FIELD_1).getValue());
                    new ContextIndexSearcher(
                (script) -> ((String) ((Map<String, Object>) script.get("_source")).get("field2")).replace(" ", "_"),
                    // test highlighting nested field DERIVED_FIELD_4 + "." + NESTED_FIELD
            indexSettings,
import java.util.Collections;  
                    assertEquals(1, nestedFields.get(DERIVED_FIELD_4 + "." + NESTED_FIELD).getValues().size());  
                    );
            null,
                DerivedField derivedField3 = new DerivedField(  
                Map<String, DocumentField> fields = fetchFields(mockShardContext, context, "*");
import org.opensearch.index.mapper.DerivedField;
                HighlightPhase highlightPhase = new HighlightPhase(Collections.singletonMap("unified", new UnifiedHighlighter()));
                        true,  
            try (IndexReader reader = iw.getReader()) {
            .field("field3", 1710923445000L)  
    private static ScriptService getScriptService() {  
                        fetchContext,  
                {  
                // create a fetch context to be used by HighlightPhase processor
import static org.mockito.Mockito.mock;
                        mockShardContext.lookup().source()
                        reader,
                QueryShardContext mockShardContext = createQueryShardContext(mapperService, searcher);  
            .endObject();
            null,
                                new Script(ScriptType.INLINE, "mockscript", DERIVED_FIELD_SCRIPT_2, emptyMap())
        }
                                DERIVED_FIELD_1,
                    .parse(new SourceToParse("test_index", "0", BytesReference.bytes(source), MediaTypeRegistry.JSON))  
        return fieldFetcher.fetch(queryShardContext.lookup().source(), Set.of());
                    // Create a search hit using the derived fields fetched above in fetch phase
            .startObject("derived")  
            .endObject();
            .startObject(DERIVED_FIELD_1)
            ),  
                    assertEquals(1, fields.get(DERIVED_FIELD_3).getValues().size());  
                // Create a HighlightBuilder of type unified, set its fields as derived_1 and derived_2
                // This mock behavior is similar to adding derived fields in search request  
                    assertEquals(1, fields.get(DERIVED_FIELD_4).getValues().size());
            .endObject()  
                        searchHit,  
            Directory dir = newDirectory();
        // Create source document with 2 fields field1 and field2.  
                        IndexSearcher.getDefaultQueryCachingPolicy(),
        XContentBuilder source = XContentFactory.jsonBuilder()
                    // process the HitContext using the highlightPhase subPhaseProcessor  
                    assertEquals("some_text_1", fields.get(DERIVED_FIELD_1).getValue());
            MockScriptEngine.NAME,
                HighlightPhase highlightPhase = new HighlightPhase(Collections.singletonMap("unified", new UnifiedHighlighter()));
                highlightBuilder.field(DERIVED_FIELD_1);
                mockShardContext.setDerivedFieldResolver(
import org.opensearch.index.query.QueryShardContext;  
                    );
        // Create source document with 2 fields field1 and field2.  
                IndexSearcher searcher = newSearcher(reader);
import org.apache.lucene.search.IndexSearcher;
                highlightBuilder.field(DERIVED_FIELD_2);
                    SearchHit searchHit = new SearchHit(docId, "0", null, fields, null);
                FetchContext fetchContext = mock(FetchContext.class);
                    assertEquals(1, fields.get(DERIVED_FIELD_1).getValues().size());
                DERIVED_FIELD_SCRIPT_3,
        IndexSettings indexSettings = new IndexSettings(indexMetadata, settings);  
import org.opensearch.index.query.Rewriteable;
import org.opensearch.script.MockScriptEngine;
                when(fetchContext.mapperService()).thenReturn(mapperService);  
                    subPhaseProcessor.process(hitContext);
    private static String DERIVED_FIELD_2 = "derived_2";
                        IndexSearcher.getDefaultSimilarity(),  
                    );
                        null,
                    hitContext.sourceLookup().loadSourceIfNeeded();  
                );
            .field("field2", "some_text_2")
                }
        MapperService mapperService = indexService.mapperService();  
                    // The query used by FetchSubPhaseProcessor to highlight is a term query on DERIVED_FIELD_1  
            .endObject()
                when(fetchContext.mapperService()).thenReturn(mapperService);  
                        fetchContext,
                    assertEquals("20-03-2024", fields.get(DERIVED_FIELD_3).getValue());
            .startObject(DERIVED_FIELD_2)
import static org.mockito.Mockito.when;
                    assertEquals(hitContext.hit().getHighlightFields().size(), 1);
                Map<String, DocumentField> nestedFields = fetchFields(mockShardContext, context, DERIVED_FIELD_4 + "." + NESTED_FIELD);
        XContentBuilder mapping = XContentFactory.jsonBuilder()
    public void testDerivedFieldFromSearchMapping() throws IOException {
            RandomIndexWriter iw = new RandomIndexWriter(random(), dir, new IndexWriterConfig(mapperService.indexAnalyzer()));
                    SearchHit searchHit = new SearchHit(docId, "0", null, fields, null);
                        null
                    assertEquals("foo bar baz", nestedFields.get(DERIVED_FIELD_4 + "." + NESTED_FIELD).getValue());
        LeafReaderContext context,
                // mockShardContext.setDerivedFieldTypes(Map.of("derived_2", createDerivedFieldType("derived_1", "keyword"), "derived_1",
                SearchHighlightContext searchHighlightContext = highlightBuilder.build(mockShardContext);
                    SearchHit searchHit = new SearchHit(docId, "0", null, nestedFields, null);  
                mapperService.documentMapper()
                // Validate FetchPhase
        int docId = 0;
            );
            .field("field1", "some_text_1")
            null,
                        new TermQuery(new Term(DERIVED_FIELD_1, "some_text_1"))
 */  
                Map<String, DocumentField> fields = fetchFields(mockShardContext, context, "derived_*");
                    // Create a search hit using the derived fields fetched above in fetch phase
                        docId,
            }
import org.apache.lucene.index.IndexWriterConfig;
                    (DefaultDerivedFieldResolver) DerivedFieldResolverFactory.createResolver(
                    // Create a HitContext of search hit
import org.opensearch.Version;  
                        searchHit,
                        IndexSearcher.getDefaultSimilarity(),  
        );  
                        docId,  
        // Create index and mapper service
                            ),
                    // process the HitContext using the highlightPhase subPhaseProcessor  
                DERIVED_FIELD_SCRIPT_4,
        // Define mapping for derived fields, create 2 derived fields derived_1 and derived_2  
            .endObject()
            .startObject("script")
                {
                            new DerivedField(  
            .field("field3", 1710923445000L)  
                    );
                    assertEquals("some_text_2", fields.get(DERIVED_FIELD_2).getValue());  
                                "keyword",
    private static String DERIVED_FIELD_SCRIPT_2 = "derived_field_script_2";  
                {  
                        fetchContext,  
                        true
                    hitContext.sourceLookup().loadSourceIfNeeded();
        List<FieldAndFormat> fields = List.of(new FieldAndFormat(fieldPattern, null));
                        docId,
                (script) -> ((Map<String, Object>) script.get("_source")).get("field4")
                            new DerivedField(
            .endObject()  
            .endObject()
import org.opensearch.script.ScriptEngine;
                highlightBuilder.field(DERIVED_FIELD_4 + "." + NESTED_FIELD);  
            .endObject();
            0,
                    );  
            .startObject("script")  
                        context,
                    subPhaseProcessor.process(hitContext);
                    );  
                        reader,
                    SearchHit searchHit = new SearchHit(docId, "0", null, nestedFields, null);  
            .put("index.number_of_replicas", 0)
import org.opensearch.search.fetch.subphase.FieldAndFormat;  
                        mockShardContext.lookup().source()  
                }  
                HighlightBuilder highlightBuilder = new HighlightBuilder();
                        searchHighlightContext,
import java.util.Map;
                        mockShardContext.lookup().source()
            .field("field1", "some_text_1")
        QueryShardContext queryShardContext,  
                LeafReaderContext context = searcher.getIndexReader().leaves().get(0);
                {
                    assertEquals("{ \"field\": \"foo bar baz\"}", fields.get(DERIVED_FIELD_4).getValue());
                            ),  
            scriptService,
                        IndexSearcher.getDefaultQueryCache(),
                    new ContextIndexSearcher(
        return scriptService;
import org.opensearch.index.IndexService;
 *
package org.opensearch.search.fetch.subphase.highlight;
            null
                DERIVED_FIELD_SCRIPT_2,  
                when(fetchContext.searcher()).thenReturn(  
                    assertEquals(fields.size(), 4);  
                    assertEquals("some_text_2", fields.get(DERIVED_FIELD_2).getValue());  
    ) throws IOException {  
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid")  
                        List.of(
                    // Validate that 1 highlight field is present
        IndexMetadata indexMetadata = new IndexMetadata.Builder("index").settings(settings).build();
                    )  
                    DERIVED_FIELD_3,
                    assertEquals("foo bar baz", nestedFields.get(DERIVED_FIELD_4 + "." + NESTED_FIELD).getValue());
                    subPhaseProcessor.process(hitContext);
 * SPDX-License-Identifier: Apache-2.0
                            )  
                highlightBuilder.field(DERIVED_FIELD_2);
                when(fetchContext.getQueryShardContext()).thenReturn(mockShardContext);
import org.opensearch.search.fetch.subphase.FieldFetcher;
    public void testDerivedFieldFromIndexMapping() throws IOException {
            .startObject()  
                    )  
                derivedField3.setFormat("dd-MM-yyyy");
                    .rootDoc()
                    // Create a HitContext of search hit
                        null,
                    FetchSubPhase.HitContext hitContext = new FetchSubPhase.HitContext(
                (script) -> ((Map<String, Object>) script.get("_source")).get("field3"),  
        try (  
                        new TermQuery(new Term(DERIVED_FIELD_4 + "." + NESTED_FIELD, "foo"))
