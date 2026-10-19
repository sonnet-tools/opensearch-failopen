                // dynamic mappings too
                assertEquals(1, topDocs.totalHits.value());
                // dynamic mappings too
                b.endObject();
            public void setDocument(int docId) {  
            public void setDocument(int docId) {  
                b.startObject("object_field_without_ignored_malformed");
                super.setDocument(docId);
                    b.field("script", "");
                // NOTE: object_field.keyword_field will be resolved to a text field for nested field as that's the default behaviour in
                topDocs = searcher.search(query, 10);
                assertEquals(2, topDocs.totalHits.value());  
        MapperService mapperService = createMapperService(topMapping(b -> {
        {
                b.startObject("method");
                topDocs = searcher.search(query, 10);
                    if (res == null) {
            }
                    b.field("script", "");
                + "\"invalid_field\": {},"
                    b.field("type", "object");
                when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));  
                {
                + "\"date_field\": \"2024-03-20T17:50:40\","
        }
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> new DerivedFieldScript(
                    b.field("ignore_malformed", true);
            false,
            int docId = 0;  
                when(queryShardContext.compile(Mockito.any(), Mockito.any())).thenReturn(factory);
    }
            "50.60.70.80",
        }
        List<Document> docs = new ArrayList<>();  
                topDocs = searcher.search(query, 10);
                    b.field("type", "object");
                assertEquals(7, topDocs.totalHits.value());  
                query = QueryBuilders.termsQuery("method", "delete").toQuery(queryShardContext);
            b.startObject("derived");
                Query finalQuery = query;  
                    b.field("script", "");
                TopDocs topDocs = searcher.search(query, 10);
                topDocs = searcher.search(query, 10);
            new Tuple<>(40.0, 50.0),
                    b.field("script", "");
                        b.field("keyword_field", "keyword");
                    b.endObject();  
                }  
                    b.endObject();
                b.startObject("regular_derived_field");
                assertThrows(MapperException.class, () -> finalTermQueryBuilder2.toQuery(queryShardContext));
                + "\"text_field\": \"document number 10\","
                topDocs = searcher.search(query, 10);
                query = QueryBuilders.regexpQuery("object_field.nested_field.sub_field_1", ".*let.*").toQuery(queryShardContext);
                TermQueryBuilder termQueryBuilder = new TermQueryBuilder("object_field.keyword_field", "GET");  
                // Test nested array field
                    b.field("type", "ip");
            lookup,  
                        DerivedFieldResolver derivedFieldResolver = DerivedFieldResolverFactory.createResolver(
                when(queryShardContext.getIndexReader()).thenReturn(reader);  
            {
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"  
                topDocs = searcher.search(query, 10);  
                        b.field("keyword_field", "keyword");  
            ctx
                IndexSearcher searcher = new IndexSearcher(reader);
                query = QueryBuilders.matchPhraseQuery("object_field.text_field", "document number 11").toQuery(queryShardContext);
                    b.endObject();
        when(queryShardContext.compile(Mockito.any(), Mockito.any())).thenReturn(factory);  
                        DerivedFieldResolver derivedFieldResolver = DerivedFieldResolverFactory.createResolver(
            7.2,  
                docsEvaluated[0] = 0;
                    b.field("prefilter_field", "raw_message");
                this.docId = docId;
import static org.mockito.ArgumentMatchers.anyString;
            "247.37.0.0 GET /french/splash_inet.html?size=4.1KB HTTP/1.0 400 2024-03-20T11:20:10 4100",
                assertEquals(7, topDocs.totalHits.value());
                }
            @Override
                + "\"float_field\": 5.8,"
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
                    b.field("script", "");
                    if (res == null) {
                topDocs = searcher.search(query, 10);
                }  
                topDocs = searcher.search(query, 10);
            @Override
                {  
                IndexSearcher searcher = new IndexSearcher(reader);  
        int[] docsEvaluated = { 0 };
                + "\"keyword_field\": \"GET\","
            for (Document d : docs) {
            {  
                + "\"float_field\": 7.2,"
                + "\"long_field\": 9400,"
                // Range queries of types - date, long and double
                + "\"boolean_field\": true,"
            8900L,
                scriptIndex[0] = 4;  
                assertEquals(7, topDocs.totalHits.value());
                when(queryShardContext.fieldMapper(anyString())).thenAnswer(inv -> {
                assertThrows(IllegalArgumentException.class, () -> searcher.search(finalQuery, 10));  
            5800L,
import org.apache.lucene.search.Query;
                + "}" },
        // Mock DerivedFieldScript.Factory  
                    MappedFieldType res = mapperService.fieldType(inv.getArguments()[0].toString());  
                topDocs = searcher.search(query, 10);  
            "192.168.1.1",
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"  
                {
                    b.field("type", "date");  
            try (IndexReader reader = DirectoryReader.open(iw)) {
        // Mock DerivedFieldScript.Factory  
            docs.add(document);  
            }  
            2300L,
                when(queryShardContext.compile(Mockito.any(), Mockito.any())).thenReturn(factory);
                b.endObject();
                    return res;
                + "\"keyword_field\": \"GET\","
                topDocs = searcher.search(query, 10);
            "PUT",  
            1500L,
                topDocs = searcher.search(query, 10);
            b.endObject();
                + "\"nested_field\": { \"sub_field_1\": \"DELETE\"}"
import java.util.List;
        // malformed json
                iw.addDocument(d);
                + "\"keyword_field\": \"GET\","
                }
                b.endObject();
                + "}" },
                + "\"long_field\": 7200,"  
                + "\"float_field\": 4.1,"
            public void execute() {  
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
        int[] scriptIndex = { 8 };
                b.startObject("object_field");
            "{ "
import org.opensearch.common.lucene.Lucene;  
            new Tuple<>(10.0, 20.0),
            new Tuple<>(30.0, 40.0),
        }
            4.1,  
                }  
            params,
                + "\"float_field\": 2.3,"
                }
            "192.168.1.1 GET /path/to/resource?size=10.7KB HTTP/1.0 400 2024-03-20T17:50:40 10700",
                        );  
                            null,
                + "\"boolean_field\": true,"
            {  
                termQueryBuilder.caseInsensitive(true);
                + "" } };
                addEmittedValue(raw_requests[docId][scriptIndex[0]]);
import org.opensearch.index.query.QueryBuilders;
            b.startObject("derived");
                topDocs = searcher.search(query, 10);
            false,  
            "GET",
                        DerivedFieldResolver derivedFieldResolver = DerivedFieldResolverFactory.createResolver(  
                + "\"long_field\": 10700,"  
                + "\"array_field\": [25, 26, 27],"
            "{ "  
                + "\"date_field\": \"2024-03-20T10:05:55\","  
                iw.close();  
                query = QueryBuilders.rangeQuery("@timestamp").from("2024-03-20T14:20:50").toQuery(queryShardContext);  
                IndexSearcher searcher = new IndexSearcher(reader);
            document.add(new TextField("raw_message", (String) request[0], Field.Store.YES));  
            "192.168.1.1 GET /path/to/resource?size=10.7KB HTTP/1.0 400 2024-03-20T17:50:40 10700",
            "JKJ",
            lookup,  
                + "\"date_field\": \"2024-03-20T14:20:50\","
                    MappedFieldType res = mapperService.fieldType(inv.getArguments()[0].toString());
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> new DerivedFieldScript(
                + "\"text_field\": \"document number 2\","
                    b.field("type", "object");
            false,
        when(queryShardContext.sourcePath("raw_message")).thenReturn(Set.of("raw_message"));
                iw.addDocument(d);  
        MapperService mapperService = createMapperService(topMapping(b -> {
                query = QueryBuilders.wildcardQuery("object_field.keyword_field", "g*").toQuery(queryShardContext);
        try (Directory dir = newDirectory()) {  
        int[] scriptIndex = { 1 };
                + "\"array_field\": [1, 2, 3],"  
                    b.startObject("properties");
                b.endObject();
        {  
    public void testObjectDerivedFieldsWithIgnoreMalformed() throws IOException {
                    b.field("script", "");  
                + "\"boolean_field\": false,"
                assertEquals(0, topDocs.totalHits.value());
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
                // NOTE: object_field.keyword_field will be resolved to a text field for nested field as that's the default behaviour in
                    {
                b.endObject();
                    b.field("script", "");
                + "\"boolean_field\": false,"  
        {  
            "40.135.0.0 GET /images/hm_bg.jpg?size=1.5KB loc 10.0 20.0 HTTP/1.0 200 2024-03-20T08:30:45 1500",
                    {  
                termQueryBuilder = new TermQueryBuilder("object_field_2.keyword_field", "GET");  
import org.apache.lucene.store.Directory;  
                    b.field("type", "double");
                // dynamic mappings too  
                query = termQueryBuilder.toQuery(queryShardContext);
                    b.field("type", "text");  
                // IP Field Term Query  
                // since last doc has a malformed json, if ignore_malformed isn't set or set as false, the query should fail
                    b.field("type", "keyword");
                when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                }
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
                + "}" },
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                    return res;  
            ctx
                        b.field("keyword_field", "date");
    }
import java.io.IOException;
                addEmittedValue(raw_requests[docId][scriptIndex[0]]);
            try (IndexReader reader = DirectoryReader.open(iw)) {
                Query query = termQueryBuilder.toQuery(queryShardContext);  
                });
                + "\"long_field\": 6300,"
        MapperService mapperService = createMapperService(topMapping(b -> {
                termQueryBuilder.caseInsensitive(true);
            }
                assertEquals(11, docsEvaluated[0]);
        int[] docsEvaluated = { 0 };
            new Tuple<>(-1.0, -1.0),
                            queryShardContext,  
                scriptIndex[0] = 6;  
                + "\"long_field\": 10700,"  
            }  
                    b.field("type", "object");
        ) {
                assertEquals(1, topDocs.totalHits.value());
import org.opensearch.index.query.TermQueryBuilder;
                termQueryBuilder.caseInsensitive(true);
                {  
                {  
            docs.add(document);
                    }
                    b.field("prefilter_field", "long_field");
                b.startObject("geopoint");
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;  
            @Override
                }
                this.docId = docId;
                // Prefix Query
            3.7,
                b.startObject("object_field_2");
                    .from("2024-03-20T14:20:50")
                + "\"date_field\": \"2024-03-20T16:40:15\","  
                + "\"long_field\": 8900,"
                termQueryBuilder = new TermQueryBuilder("invalid_object.keyword_field", "GET");  
            true,
            1710938730000L,
                        b.field("keyword_field", "date");  
            "247.37.0.0",
                }  
                // test regular_derived_field_without_prefilter_field  
            9400L,  
            -1L,  
                });  
            b.startObject("properties");
                    b.field("script", "");
                assertEquals(2, topDocs.totalHits.value());
                    b.field("type", "text");
                    .type(MultiMatchQueryBuilder.Type.PHRASE)
                TopDocs topDocs = searcher.search(query, 10);
            "{ "
                query = QueryBuilders.matchPhraseQuery("object_field.text_field", "document number 1").toQuery(queryShardContext);  
            b.endObject();  
                + "}" },  
        }));  
                    b.field("script", "");
                // NOTE: object_field.keyword_field will be resolved to a text field for nested field as that's the default behaviour in  
                + "\"long_field\": 1500,"  
                + "\"array_field\": [7, 8, 9],"
        MapperService mapperService = createMapperService(topMapping(b -> {
            new Tuple<>(20.0, 30.0),  
        ) {
import org.opensearch.core.index.Index;
                assertEquals(3, topDocs.totalHits.value());  
    public void testAllPossibleQueriesOnDerivedFields() throws IOException {  
            10.7,  
                docsEvaluated[0]++;
                    b.field("ignore_malformed", true);
            b.startObject("properties");  
            document.add(new TextField("raw_message", (String) request[0], Field.Store.YES));
                termQueryBuilder.caseInsensitive(true);
                scriptIndex[0] = 5;
                    .caseInsensitive(true)
                Query query = QueryBuilders.termQuery("request_succeeded", "true").toQuery(queryShardContext);
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                assertEquals(7, topDocs.totalHits.value());  
        {
                    b.field("ignore_malformed", true);
                query = QueryBuilders.rangeQuery("object_field.long_field").from("5800").toQuery(queryShardContext);
            "232.0.0.0 GET /images/hm_bg.jpg?size=2.3KB HTTP/1.0 400 2024-03-20T09:15:20 2300",
import org.apache.lucene.document.Field;
                topDocs = searcher.search(query, 10);
                b.endObject();
            @Override
import org.apache.lucene.index.IndexReader;
                scriptIndex[0] = 4;  
                }  
import org.opensearch.index.search.QueryStringQueryParser;
                    b.field("type", "object");
                // tested missing nested field
                + "\"keyword_field\": \"DELETE\","  
            }  
                query = QueryBuilders.termQuery("regular_derived_field", "delete").caseInsensitive(true).toQuery(queryShardContext);
        }));
                    b.field("script", "");
    public void testObjectDerivedFields() throws IOException, ParseException {  
                }
            "{ "
                    b.field("script", "");
                when(queryShardContext.sourcePath("raw_message")).thenReturn(Set.of("raw_message"));
                docsEvaluated[0] = 0;
                }  
                // tested deep nested field  
        }));
                + "\"array_field\": [28, 29, 30],"  
                {  
                    b.field("type", "text");
import org.mockito.Mockito;
                b.endObject();  
        };
                assertEquals(2, topDocs.totalHits.value());
                query = QueryBuilders.multiMatchQuery("GET", "object_field.nested_field.sub_field_1", "object_field.keyword_field")
                            null,  
                + "}" },
                b.endObject();
                b.endObject();  
            }  
                when(queryShardContext.fieldMapper(anyString())).thenAnswer(inv -> {
                iw.close();
            }  
                // check if ignoreMalformed is set to false, the query fails on malformed values  
import org.opensearch.index.query.MultiMatchQueryBuilder;
            1710923445000L,  
                + "\"boolean_field\": false,"
 */  
                + "\"text_field\": \"document number 8\","
                b.startObject("invalid_object");  
                {  
            "127.0.0.1 GET /path/to/resource?size=9.4KB HTTP/1.0 200 2024-03-20T16:40:15 9400",  
                + "\"boolean_field\": true,"
                    b.field("prefilter_field", "raw_message");
        };
import org.apache.lucene.index.IndexWriter;  
            b.startObject("derived");
                }  
    // First element is the document ingested, other elements corresponds to value returned against a given derived field script  
 * compatible open source license.
            8.9,
        // Index and Search  
                super.setDocument(docId);
            "127.0.0.1",  
    }
                // test regular_derived_field
                scriptIndex[0] = 4;
                + "\"date_field\": \"2024-03-20T17:50:40\","
                // Prefix Query
            params,
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
                topDocs = searcher.search(query, 10);
                            null,
                b.endObject();
                QueryStringQueryParser queryParser = new QueryStringQueryParser(queryShardContext, "object_field.keyword_field");
        // Mock DerivedFieldScript.Factory  
                query = QueryBuilders.rangeQuery("long_prefilter_field_object.date_field")
                + "\"array_field\": [4, 5, 6],"
                            queryShardContext,
                + "}" },
                    }  
                assertThrows(OpenSearchParseException.class, () -> searcher.search(finalQuery, 10));
                assertEquals(4, topDocs.totalHits.value());
                    b.field("script", "");
        {
                query = QueryBuilders.rangeQuery("object_field.date_field").from("2024-03-20T14:20:50").toQuery(queryShardContext);
            "GET",
                + "\"invalid_field\": {},"
                    {
        {  
                this.docId = docId;
import org.opensearch.script.DerivedFieldScript;  
                + "\"text_field\": \"document number 1\","
                b.endObject();
                topDocs = searcher.search(query, 10);  
                            true
            "127.0.0.1",
                QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                        res = derivedFieldResolver.resolve(inv.getArguments()[0].toString());
            docs.add(document);
            "10.20.30.40",  
                when(queryShardContext.sourcePath("raw_message")).thenReturn(Set.of("raw_message"));
                        res = derivedFieldResolver.resolve(inv.getArguments()[0].toString());  
                topDocs = searcher.search(query, 10);  
                query = QueryBuilders.rangeQuery("object_field.array_field").from("10").to("12").toQuery(queryShardContext);  
                assertEquals(2, topDocs.totalHits.value());  
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"  
            1710940215000L,
                    b.field("prefilter_field", "raw_message");  
                addEmittedValue(raw_requests[docId][scriptIndex[0]]);
                }  
                + "\"keyword_field\": \"GET\","
            "{ "  
                + "\"array_field\": [22, 23, 24],"
                b.endObject();
            params,
                    b.startObject("properties");
import org.apache.lucene.queryparser.classic.ParseException;
                + "\"date_field\": \"2024-03-20T13:10:15\","  
                b.startObject("long_field");
                    b.field("type", "boolean");  
                b.endObject();  
            "247.37.0.0 DELETE /french/splash_inet.html?size=5.8KB HTTP/1.0 400 2024-03-20T12:45:30 5800",
                assertEquals(4, topDocs.totalHits.value());
            }
                super.setDocument(docId);  
                + "\"nested_field\": { \"sub_field_1\": \"DELETE\"}"  
                    }
public class DerivedFieldMapperQueryTests extends MapperServiceTestCase {
            new Tuple<>(60.0, 70.0),
                when(queryShardContext.getIndexReader()).thenReturn(reader);
                when(queryShardContext.compile(Mockito.any(), Mockito.any())).thenReturn(factory);  
            int docId = 0;
            }  
            "{ "
            lookup,
            1710944450000L,  
                    {
        };  
            document.add(new TextField("raw_message", (String) request[0], Field.Store.YES));  
        }
                b.endObject();
                b.startObject("request_succeeded");
                }  
                query = QueryBuilders.regexpQuery("method", ".*LET.*").toQuery(queryShardContext);
                query = QueryBuilders.rangeQuery("object_field.array_field").from("31").to("50").toQuery(queryShardContext);
                    b.field("type", "object");  
                when(queryShardContext.fieldMapper(anyString())).thenAnswer(inv -> {  
                query = new MatchPhrasePrefixQueryBuilder("object_field.text_field", "document number").toQuery(queryShardContext);
            b.endObject();  
                    return res;
                    b.startObject("properties");
                query = QueryBuilders.prefixQuery("object_field.keyword_field", "de").toQuery(queryShardContext);  
                assertEquals(7, topDocs.totalHits.value());  
                // Regexp Query
                        res = derivedFieldResolver.resolve(inv.getArguments()[0].toString());
        int[] scriptIndex = { 8 };
                    b.field("type", "long");
            }
                + "\"text_field\": \"document number 9\","  
                b.startObject("long_prefilter_field_object");
            5.8,
            "247.37.0.0",
                topDocs = searcher.search(query, 10);
import org.opensearch.OpenSearchParseException;
                {
                query = QueryBuilders.termsQuery("method", "DELETE", "PUT").toQuery(queryShardContext);
                            true
                assertEquals(7, topDocs.totalHits.value());
                topDocs = searcher.search(query, 10);  
                // when nested field is of numeric type or date, the range queries should still work irrespective of invalid
                assertEquals(2, topDocs.totalHits.value());
            try (IndexReader reader = DirectoryReader.open(iw)) {  
                scriptIndex[0] = 4;  
        ) {
            }  
                assertEquals(6, topDocs.totalHits.value());  
/*  
                b.endObject();
                query = QueryBuilders.rangeQuery("object_field.array_field").from("3").to("6").toQuery(queryShardContext);
                b.startObject("raw_message");
            }  
            params,  
                    b.field("script", "");  
                    }
                    b.field("ignore_malformed", true);
                b.startObject("object_field");
                TermQueryBuilder finalTermQueryBuilder2 = termQueryBuilder;
            true,
            }
            "{ "  
            "{ "  
                query = QueryBuilders.termQuery("method", "delete").caseInsensitive(true).toQuery(queryShardContext);  
            }
            "40.135.0.0",
                + "\"text_field\": \"document number 10\","
            }
                b.startObject("client_ip");
                topDocs = searcher.search(query, 10);  
                iw.addDocument(d);
                        );
                b.endObject();
                + "\"text_field\": \"document number 3\","  
            6.3,
                query = QueryBuilders.rangeQuery("object_field.float_field").from("4.1").toQuery(queryShardContext);  
                // GeoPoint Query
                b.startObject("object_field_3");  
import org.opensearch.geometry.Rectangle;
            false,
                topDocs = searcher.search(query, 10);
        {  
        }
                docsEvaluated[0] = 0;
                assertEquals(7, topDocs.totalHits.value());
            true,
            int docId = 0;  
                    MappedFieldType res = mapperService.fieldType(inv.getArguments()[0].toString());
                + "\"array_field\": [13, 14, 15],"
                            null,
                assertEquals(7, topDocs.totalHits.value());
                assertEquals(2, topDocs.totalHits.value());
                {  
                    b.field("type", "object");  
            new Tuple<>(80.0, 90.0),  
                {  
                    b.field("type", "long");  
                }
                    b.field("ignore_malformed", true);  
                    b.field("script", "");
        {
                    b.field("script", "");
                + "\"nested_field\": { \"sub_field_1\": \"PUT\"}"  
                query = termQueryBuilder.toQuery(queryShardContext);
                {
                {
        List<Document> docs = new ArrayList<>();  
            "{ "  
            9.4,
            {  
                + "\"text_field\": \"document number 5\","
                }
                + "\"boolean_field\": false,"
    private static final Object[][] raw_requests = new Object[][] {
            }
                            queryShardContext,
        ) {  
            ctx
            1710926120000L,
                // Multi Phrase Query  
            6300L,  
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
                    {
                    }
                query = QueryBuilders.rangeQuery("object_field_3.keyword_field").from("2024-03-20T14:20:50").toQuery(queryShardContext);
            public void setDocument(int docId) {
                TermQueryBuilder finalTermQueryBuilder = termQueryBuilder;
                    b.field("type", "text");
                assertEquals(7, topDocs.totalHits.value());
            b.startObject("derived");
            lookup,  
                assertEquals(4, topDocs.totalHits.value());
 *
                // Regexp Query
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> new DerivedFieldScript(
                b.endObject();
                + "\"text_field\": \"document number 7\","
                assertEquals(4, topDocs.totalHits.value());
                IndexSearcher searcher = new IndexSearcher(reader);
                {
            }
            2.3,
                + "\"boolean_field\": false,"  
                + "}" },  
                query = QueryBuilders.rangeQuery("duration").from("5800").toQuery(queryShardContext);
                topDocs = searcher.search(query, 10);
                termQueryBuilder = new TermQueryBuilder("long_prefilter_field_object.keyword_field", "GET");
        // Index and Search
                queryParser.parse("GE?");  
                    b.field("ignore_malformed", false);
import java.util.Set;
                + "\"long_field\": 5800,"
                        b.field("keyword_field", "keyword");
                scriptIndex[0] = 4;
            for (Document d : docs) {
                // test object_field_2
                topDocs = searcher.search(query, 10);
                            null,  
 * The OpenSearch Contributors require contributions made to  
            @Override
                b.startObject("long_field");
                    b.endObject();
                    b.field("type", "geo_point");
                + "\"boolean_field\": false,"
                query = QueryBuilders.rangeQuery("invalid_object.date_field").from("2024-03-20T14:20:50").toQuery(queryShardContext);  
                + "\"array_field\": [16, 17, 18],"
                assertEquals(1, topDocs.totalHits.value());
                + "\"date_field\": \"2024-03-20T11:20:10\","
                    if (res == null) {  
                b.endObject();  
                query = QueryBuilders.prefixQuery("method", "DE").toQuery(queryShardContext);
            b.startObject("properties");  
                assertEquals(8, docsEvaluated[0]);
                b.endObject();
                query = QueryBuilders.rangeQuery("request_size").from("4.1").toQuery(queryShardContext);
                topDocs = searcher.search(query, 10);
                topDocs = searcher.search(query, 10);
                + "}" },  
                QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                topDocs = searcher.search(query, 10);  
        // Index and Search
                + "\"array_field\": [10, 11, 12],"  
                    b.field("type", "text");  
                b.startObject("object_field");
import org.opensearch.common.collect.Tuple;
                query = QueryBuilders.wildcardQuery("method", "G*").toQuery(queryShardContext);
                            true  
        for (Object[] request : raw_requests) {
            @Override  
            1710948625000L,
                {  
            document.add(new TextField("raw_message", (String) request[0], Field.Store.YES));  
                addEmittedValue(raw_requests[docId][scriptIndex[0]]);  
                    .toQuery(queryShardContext);  
            public void execute() {
            public void execute() {  
                when(queryShardContext.sourcePath("raw_message")).thenReturn(Set.of("raw_message"));  
            for (Document d : docs) {  
                {
            "GET",
package org.opensearch.index.mapper;
                topDocs = searcher.search(query, 10);
                this.docId = docId;  
                {
        }
                query = QueryBuilders.regexpQuery("object_field.keyword_field", ".*let.*").toQuery(queryShardContext);
                + "\"date_field\": \"2024-03-20T09:15:20\","
                        );
            "192.169.1.1",
        List<Document> docs = new ArrayList<>();
                query = QueryBuilders.regexpQuery("object_field.invalid_field.sub_field", ".*let.*").toQuery(queryShardContext);  
                assertEquals(0, topDocs.totalHits.value());
            10700L,
            1710933610000L,  
                {
                query = QueryBuilders.rangeQuery("object_field_2.keyword_field").from("2024-03-20T14:20:50").toQuery(queryShardContext);  
                query = QueryBuilders.rangeQuery("object_field.array_field").from("9").to("9").toQuery(queryShardContext);
            for (Document d : docs) {
                scriptIndex[0] = 4;  
            "26.1.0.0",  
                when(queryShardContext.getIndexReader()).thenReturn(reader);
                + "\"float_field\": 10.7,"
                b.startObject("duration");
                }
                    .toQuery(queryShardContext);  
            b.endObject();
            int docId = 0;  
                topDocs = searcher.search(query, 10);
                    b.field("type", "object");
            1710952815000L,
                // Range queries of types - date, long and double
import static org.mockito.Mockito.when;
            "DELETE",  
                TopDocs topDocs = searcher.search(query, 10);  
                + "\"boolean_field\": false,"  
            {  
                topDocs = searcher.search(query, 10);  
                    b.field("ignore_malformed", true);  
                    b.field("script", "");
            Document document = new Document();
                iw.close();
                TermQueryBuilder termQueryBuilder = new TermQueryBuilder("object_field.keyword_field", "GET");
            b.endObject();  
            Document document = new Document();
            new Tuple<>(85.0, 90.0),
                assertEquals(6, topDocs.totalHits.value());  
            {
                b.endObject();
                docsEvaluated[0]++;
                TermQueryBuilder termQueryBuilder = new TermQueryBuilder("object_field.keyword_field", "GET");
            1.5,  
                b.endObject();  
                });
                {
            b.endObject();
                b.startObject("raw_message");
                // prefilter_field
                topDocs = searcher.search(query, 10);
            7200L,
        };  
                assertEquals(2, topDocs.totalHits.value());  
                assertEquals(10, topDocs.totalHits.value());
        // Index and Search
                + "\"float_field\": 9.4,"  
                    b.field("script", "");  
        for (Object[] request : raw_requests) {  
            "{ "
                topDocs = searcher.search(query, 10);
        int[] scriptIndex = { 8 };  
                assertThrows(MapperException.class, () -> finalTermQueryBuilder.toQuery(queryShardContext));  
                query = geoShapeQuery("geopoint", new Rectangle(0.0, 55.0, 55.0, 0.0)).toQuery(queryShardContext);
                Query query = termQueryBuilder.toQuery(queryShardContext);
                    .toQuery(queryShardContext);
                // since we have prefilter_field set to "raw_message", it should not evaluate all documents  
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
                b.startObject("object_field_2");
        List<Document> docs = new ArrayList<>();  
                    b.field("ignore_malformed", true);
                + "\"date_field\": \"2024-03-20T12:45:30\","
                + "\"text_field\": \"document number 6\","  
                + "\"array_field\": [28, 29, 30],"  
                + "\"float_field\": 8.9,"
            "50.60.70.80 GET /path/to/resource?size=7.2KB HTTP/1.0 404 2024-03-20T14:20:50 7200",
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
            docs.add(document);
                assertEquals(1, topDocs.totalHits.value());
                + "\"keyword_field\": \"GET\","
            }  
                super.setDocument(docId);
            {  
                + "\"array_field\": [19, 20, 21],"  
                {
                + "\"keyword_field\": \"GET\","
                b.endObject();  
            }  
                + "\"float_field\": 10.7,"
                scriptIndex[0] = 3;
                topDocs = searcher.search(query, 10);  
                b.startObject("raw_message");
}  
                {  
            false,  
        for (Object[] request : raw_requests) {
            Document document = new Document();
                termQueryBuilder = new TermQueryBuilder("object_field_without_ignored_malformed.keyword_field", "GET");  
                b.startObject("raw_message");
                    b.field("type", "object");  
 * SPDX-License-Identifier: Apache-2.0
                    b.field("type", "object");  
                {
                Query query = termQueryBuilder.toQuery(queryShardContext);
                b.endObject();
                // check if ignoreMalformed is set to true, the query passes with 0 results
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> new DerivedFieldScript(
            "GET",
            b.endObject();
                Query finalQuery = query;
                scriptIndex[0] = 7;  
                termQueryBuilder.caseInsensitive(true);
                }  
                when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                    b.startObject("properties");  
            "10.20.30.40 GET /path/to/resource?size=6.3KB HTTP/1.0 200 2024-03-20T13:10:15 6300",  
            new Tuple<>(70.0, 80.0),
                assertEquals(4, topDocs.totalHits.value());
            "GET",
                    b.startObject("properties");  
import org.apache.lucene.index.IndexWriterConfig;
                TopDocs topDocs = searcher.search(query, 10);  
    public void testObjectDerivedFieldsWithPrefilterField() throws IOException {
                {
            "127.0.0.1 PUT /path/to/resource?size=8.9KB HTTP/1.0 500 2024-03-20T15:30:25 8900",
        try (Directory dir = newDirectory()) {
            4100L,
                    b.field("type", "text");  
                iw.addDocument(d);
                assertEquals(0, topDocs.totalHits.value());
 * this file be licensed under the Apache-2.0 license or a
                {  
        {
            b.endObject();
                + "\"long_field\": 2300,"
import org.apache.lucene.search.IndexSearcher;  
        {  
    }
            }
                query = QueryBuilders.rangeQuery("object_field.array_field").from("1").toQuery(queryShardContext);  
                topDocs = searcher.search(query, 10);
    // Raw Message, Request Succeeded (boolean), Timestamp (long), Client IP, Method, Request Size (double), Duration (long)
                + "\"date_field\": \"2024-03-20T08:30:45\","
                assertEquals(0, topDocs.totalHits.value());  
                assertEquals(0, topDocs.totalHits.value());  
                    b.field("format", "yyyy-MM-dd");
                    }
            {  
                    b.field("script", "");
                }
                termQueryBuilder.caseInsensitive(true);  
        // Mock DerivedFieldScript.Factory
                }
import org.apache.lucene.document.TextField;  
                assertEquals(4, topDocs.totalHits.value());
                topDocs = searcher.search(query, 10);  
                    b.field("ignore_malformed", "true");
        for (Object[] request : raw_requests) {
                + "\"keyword_field\": \"DELETE\","
            "232.0.0.0",
            "26.1.0.0 DELETE /images/hm_bg.jpg?size=3.7KB HTTP/1.0 200 2024-03-20T10:05:55 3700",  
            new Tuple<>(90.0, 90.0),
            "{ "
                    b.field("script", "");
            true,
                assertEquals(0, topDocs.totalHits.value());
            b.startObject("properties");
            }  
                + "\"keyword_field\": \"GET\","  
                query = QueryBuilders.termQuery("regular_derived_field_without_prefilter_field", "delete")  
                + "\"boolean_field\": true,"
                    b.field("ignore_malformed", true);
import org.apache.lucene.search.TopDocs;
                query = QueryBuilders.termQuery("client_ip", "192.168.0.0/16").toQuery(queryShardContext);
                termQueryBuilder.caseInsensitive(true);  
                assertEquals(2, docsEvaluated[0]);
            try (IndexReader reader = DirectoryReader.open(iw)) {
import org.opensearch.index.query.QueryShardContext;  
                + "\"long_field\": 4100,"  
            false,  
                topDocs = searcher.search(query, 10);
                    b.endObject();
            3700L,  
            false,
                + "}" },
                }  
                            null,
                    b.field("prefilter_field", "raw_message");  
            new Tuple<>(50.0, 60.0),  
                    }  
        {
import java.util.ArrayList;  
            1710929155000L,
        }));
            ctx
import org.apache.lucene.index.DirectoryReader;
            Document document = new Document();
                + "\"float_field\": 1.5,"
                b.endObject();
        }  
            @Override
                }
            }  
                b.startObject("object_field");
            "GET",  
                {  
            "DELETE",
                }
                + "\"long_field\": 3700,"
        try (Directory dir = newDirectory()) {
            public void setDocument(int docId) {  
                + "\"float_field\": 3.7,"  
                b.endObject();
                QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
        }
                assertEquals(2, topDocs.totalHits.value());  
            -1,
                {
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;  
            1710957040000L,  
                scriptIndex[0] = 2;
                iw.close();
                + "\"keyword_field\": \"PUT\","  
import org.apache.lucene.document.Document;
            "GET",
                assertEquals(2, topDocs.totalHits.value());
                assertEquals(7, topDocs.totalHits.value());
            public void execute() {
            }
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
                    }  
            -1,  
                topDocs = searcher.search(query, 10);  
                + "\"keyword_field\": \"GET\","
                }  
            @Override  
                + "\"float_field\": 6.3,"  
                b.startObject("regular_derived_field_without_prefilter_field");  
                b.startObject("request_size");
                b.startObject("@timestamp");
                    b.field("type", "long");  
        try (Directory dir = newDirectory()) {
                    b.field("prefilter_field", "invalid_field");  
            }
                + "\"date_field\": \"2024-03-20T15:30:25\","
                + "}" },
                + "\"text_field\": \"document number 4\","
