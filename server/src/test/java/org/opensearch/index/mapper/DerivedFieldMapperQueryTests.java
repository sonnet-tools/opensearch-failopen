                topDocs = searcher.search(query, 10);
            }
            b.startObject("properties");
            b.endObject();
                    if (res == null) {
                topDocs = searcher.search(query, 10);
                b.startObject("@timestamp");
            "247.37.0.0",
            "GET",
                assertEquals(0, topDocs.totalHits.value());
            "40.135.0.0 GET /images/hm_bg.jpg?size=1.5KB loc 10.0 20.0 HTTP/1.0 200 2024-03-20T08:30:45 1500",
                });
                }
                scriptIndex[0] = 6;
                termQueryBuilder.caseInsensitive(true);
            document.add(new TextField("raw_message", (String) request[0], Field.Store.YES));
                query = QueryBuilders.prefixQuery("method", "DE").toQuery(queryShardContext);
            }
                this.docId = docId;
                assertThrows(IllegalArgumentException.class, () -> searcher.search(finalQuery, 10));
                b.startObject("object_field");
                + "\"boolean_field\": false,"
                + "\"keyword_field\": \"DELETE\","
                assertEquals(6, topDocs.totalHits.value());
                query = QueryBuilders.rangeQuery("object_field.array_field").from("1").toQuery(queryShardContext);
                    {
                }
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> new DerivedFieldScript(
                + "\"boolean_field\": true,"
                topDocs = searcher.search(query, 10);
                        b.field("keyword_field", "date");
            "26.1.0.0 DELETE /images/hm_bg.jpg?size=3.7KB HTTP/1.0 200 2024-03-20T10:05:55 3700",
                assertEquals(2, topDocs.totalHits.value());
                TopDocs topDocs = searcher.search(query, 10);
            b.startObject("derived");
                b.startObject("geopoint");
import java.util.Set;
                // tested deep nested field
                + "\"float_field\": 10.7,"
                iw.close();
                {
                    b.field("script", "");
            1710923445000L,
                {
                {
                termQueryBuilder.caseInsensitive(true);
                }
                    b.field("script", "");
                + "\"keyword_field\": \"GET\","
                + "}" },
                assertEquals(2, topDocs.totalHits.value());
                // Range queries of types - date, long and double
            "10.20.30.40 GET /path/to/resource?size=6.3KB HTTP/1.0 200 2024-03-20T13:10:15 6300",
                    b.field("type", "object");
                scriptIndex[0] = 4;
            10.7,
            int docId = 0;
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
            }
                    b.field("script", "");
import org.opensearch.common.lucene.Lucene;
                docsEvaluated[0]++;
                    b.field("ignore_malformed", true);
            4100L,
            document.add(new TextField("raw_message", (String) request[0], Field.Store.YES));
                assertEquals(7, topDocs.totalHits.value());
                // NOTE: object_field.keyword_field will be resolved to a text field for nested field as that's the default behaviour in
                {
                topDocs = searcher.search(query, 10);
                    b.field("script", "");
                b.startObject("regular_derived_field_without_prefilter_field");
            new Tuple<>(40.0, 50.0),
            1710948625000L,
                topDocs = searcher.search(query, 10);
                + "\"boolean_field\": true,"
import org.opensearch.core.index.Index;
                b.endObject();
                super.setDocument(docId);
import org.opensearch.index.search.QueryStringQueryParser;
                iw.close();
        }));
                + "\"text_field\": \"document number 7\","
                topDocs = searcher.search(query, 10);
            }
                query = QueryBuilders.rangeQuery("object_field_2.keyword_field").from("2024-03-20T14:20:50").toQuery(queryShardContext);
                b.startObject("object_field_without_ignored_malformed");
        }
import java.io.IOException;
                    b.field("script", "");
                    b.field("type", "object");
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
                    b.field("type", "object");
import org.apache.lucene.document.TextField;
                when(queryShardContext.sourcePath("raw_message")).thenReturn(Set.of("raw_message"));
                topDocs = searcher.search(query, 10);
                b.endObject();
                    b.field("type", "text");
                query = QueryBuilders.rangeQuery("object_field.array_field").from("3").to("6").toQuery(queryShardContext);
                query = QueryBuilders.termQuery("regular_derived_field", "delete").caseInsensitive(true).toQuery(queryShardContext);
                {
                when(queryShardContext.getIndexReader()).thenReturn(reader);
                + "}" },
                }
        ) {
                // check if ignoreMalformed is set to false, the query fails on malformed values
                b.endObject();
        {
                assertEquals(2, topDocs.totalHits.value());
                b.startObject("object_field_3");
                    }
            try (IndexReader reader = DirectoryReader.open(iw)) {
                        DerivedFieldResolver derivedFieldResolver = DerivedFieldResolverFactory.createResolver(
            b.startObject("properties");
            docs.add(document);
                        b.field("keyword_field", "keyword");
                    .from("2024-03-20T14:20:50")
                assertEquals(0, topDocs.totalHits.value());
                this.docId = docId;
                topDocs = searcher.search(query, 10);
                    b.startObject("properties");
                    b.field("type", "double");
                b.endObject();
        List<Document> docs = new ArrayList<>();
                when(queryShardContext.fieldMapper(anyString())).thenAnswer(inv -> {
                + "\"boolean_field\": false,"
                iw.close();
                when(queryShardContext.compile(Mockito.any(), Mockito.any())).thenReturn(factory);
                query = QueryBuilders.rangeQuery("duration").from("5800").toQuery(queryShardContext);
                    b.field("script", "");
                topDocs = searcher.search(query, 10);
                QueryStringQueryParser queryParser = new QueryStringQueryParser(queryShardContext, "object_field.keyword_field");
            1.5,
        when(queryShardContext.sourcePath("raw_message")).thenReturn(Set.of("raw_message"));
            9.4,
                    b.field("ignore_malformed", true);
 * SPDX-License-Identifier: Apache-2.0
                    {
                b.endObject();
                    b.field("ignore_malformed", true);
                    b.field("prefilter_field", "long_field");
        int[] scriptIndex = { 8 };
            6.3,
                assertEquals(7, topDocs.totalHits.value());
                topDocs = searcher.search(query, 10);
                }
                assertEquals(4, topDocs.totalHits.value());
        MapperService mapperService = createMapperService(topMapping(b -> {
                    b.field("ignore_malformed", true);
                assertEquals(2, docsEvaluated[0]);
            }
                {
            }
            {
        int[] docsEvaluated = { 0 };
                + "\"long_field\": 6300,"
 * compatible open source license.
        int[] scriptIndex = { 1 };
                + "\"array_field\": [4, 5, 6],"
                assertEquals(4, topDocs.totalHits.value());
            "{ "
                {
                assertEquals(7, topDocs.totalHits.value());
                {
                topDocs = searcher.search(query, 10);
                    }
                    b.field("script", "");
            7200L,
 *
            @Override
                    {
            1710957040000L,
                + "\"keyword_field\": \"GET\","
        ) {
import org.apache.lucene.index.IndexWriter;
                b.endObject();
                            true
            1710933610000L,
            for (Document d : docs) {
                + "\"boolean_field\": false,"
import org.apache.lucene.store.Directory;
        };
        try (Directory dir = newDirectory()) {
                    b.endObject();
            docs.add(document);
                    b.field("ignore_malformed", true);
        for (Object[] request : raw_requests) {
                when(queryShardContext.fieldMapper(anyString())).thenAnswer(inv -> {
                topDocs = searcher.search(query, 10);
                b.endObject();
                    b.field("script", "");
                query = termQueryBuilder.toQuery(queryShardContext);
            "192.168.1.1 GET /path/to/resource?size=10.7KB HTTP/1.0 400 2024-03-20T17:50:40 10700",
                // when nested field is of numeric type or date, the range queries should still work irrespective of invalid
                // Regexp Query
                + "\"array_field\": [7, 8, 9],"
                query = QueryBuilders.rangeQuery("long_prefilter_field_object.date_field")
                    return res;
            "247.37.0.0",
                scriptIndex[0] = 5;
                + "\"boolean_field\": false,"
                + "\"float_field\": 8.9,"
                when(queryShardContext.fieldMapper(anyString())).thenAnswer(inv -> {
                topDocs = searcher.search(query, 10);
                + "\"text_field\": \"document number 3\","
                    b.field("script", "");
            "{ "
                Query query = termQueryBuilder.toQuery(queryShardContext);
            "10.20.30.40",
            "GET",
                when(queryShardContext.sourcePath("raw_message")).thenReturn(Set.of("raw_message"));
                assertThrows(OpenSearchParseException.class, () -> searcher.search(finalQuery, 10));
                b.endObject();
import static org.mockito.Mockito.when;
            1710938730000L,
            }
            }
                termQueryBuilder = new TermQueryBuilder("object_field_without_ignored_malformed.keyword_field", "GET");
                    b.field("script", "");
        int[] docsEvaluated = { 0 };
                + "\"float_field\": 1.5,"
        }));
                assertEquals(2, topDocs.totalHits.value());
                assertEquals(7, topDocs.totalHits.value());
                this.docId = docId;
import org.opensearch.index.query.MultiMatchQueryBuilder;
            "192.168.1.1",
                when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
            }
            }
                }
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
                    b.field("type", "date");
public class DerivedFieldMapperQueryTests extends MapperServiceTestCase {
                }
            new Tuple<>(80.0, 90.0),
import org.apache.lucene.document.Field;
                assertThrows(MapperException.class, () -> finalTermQueryBuilder.toQuery(queryShardContext));
                b.startObject("duration");
            }
                IndexSearcher searcher = new IndexSearcher(reader);
import java.util.ArrayList;
                // dynamic mappings too
                docsEvaluated[0] = 0;
import org.apache.lucene.index.IndexWriterConfig;
                        );
            public void setDocument(int docId) {
    }
                + "\"float_field\": 4.1,"
        };
                assertEquals(4, topDocs.totalHits.value());
            -1L,
            true,
                b.endObject();
                {
                Query query = QueryBuilders.termQuery("request_succeeded", "true").toQuery(queryShardContext);
                // Test nested array field
import org.apache.lucene.search.Query;
                b.startObject("request_succeeded");
                    b.field("type", "long");
                topDocs = searcher.search(query, 10);
                scriptIndex[0] = 4;
                scriptIndex[0] = 3;
                query = QueryBuilders.prefixQuery("object_field.keyword_field", "de").toQuery(queryShardContext);
            "127.0.0.1 PUT /path/to/resource?size=8.9KB HTTP/1.0 500 2024-03-20T15:30:25 8900",
                b.endObject();
            false,
                + "\"float_field\": 7.2,"
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            2.3,
                    b.field("script", "");
            1500L,
            "JKJ",
 */
/*
                + "\"keyword_field\": \"GET\","
                addEmittedValue(raw_requests[docId][scriptIndex[0]]);
            5.8,
            "192.168.1.1 GET /path/to/resource?size=10.7KB HTTP/1.0 400 2024-03-20T17:50:40 10700",
                    MappedFieldType res = mapperService.fieldType(inv.getArguments()[0].toString());
                TermQueryBuilder termQueryBuilder = new TermQueryBuilder("object_field.keyword_field", "GET");
            @Override
                topDocs = searcher.search(query, 10);
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> new DerivedFieldScript(
                    b.field("script", "");
                + "}" },
                }
            "{ "
            }
                termQueryBuilder = new TermQueryBuilder("long_prefilter_field_object.keyword_field", "GET");
                    b.field("ignore_malformed", true);
            false,
                assertEquals(2, topDocs.totalHits.value());
                assertEquals(2, topDocs.totalHits.value());
                    b.endObject();
                });
                topDocs = searcher.search(query, 10);
            "{ "
                    b.field("type", "keyword");
                b.startObject("long_field");
                when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                        res = derivedFieldResolver.resolve(inv.getArguments()[0].toString());
    private static final Object[][] raw_requests = new Object[][] {
                query = QueryBuilders.rangeQuery("request_size").from("4.1").toQuery(queryShardContext);
                }
                }
                // Prefix Query
                super.setDocument(docId);
                            true
import org.opensearch.index.query.QueryBuilders;
                when(queryShardContext.getIndexReader()).thenReturn(reader);
            b.startObject("derived");
            new Tuple<>(60.0, 70.0),
                QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                + "\"keyword_field\": \"GET\","
                termQueryBuilder.caseInsensitive(true);
                TopDocs topDocs = searcher.search(query, 10);
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
                + "\"long_field\": 2300,"
                    b.field("type", "text");
                + "\"text_field\": \"document number 8\","
    }
                    b.endObject();
                addEmittedValue(raw_requests[docId][scriptIndex[0]]);
import org.opensearch.geometry.Rectangle;
                b.endObject();
                    b.field("script", "");
        };
                b.startObject("invalid_object");
                iw.close();
            }
            "GET",
    }
            "26.1.0.0",
            "127.0.0.1",
import org.mockito.Mockito;
        }
        }
                b.startObject("raw_message");
            public void execute() {
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.document.Document;
            b.startObject("properties");
            ctx
                    .toQuery(queryShardContext);
            1710952815000L,
                assertEquals(0, topDocs.totalHits.value());
                            null,
                topDocs = searcher.search(query, 10);
                super.setDocument(docId);
                when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
            new Tuple<>(90.0, 90.0),
        // Mock DerivedFieldScript.Factory
                query = QueryBuilders.termsQuery("method", "DELETE", "PUT").toQuery(queryShardContext);
                termQueryBuilder.caseInsensitive(true);
            "{ "
                assertEquals(1, topDocs.totalHits.value());
            -1,
            "GET",
                {
import org.opensearch.OpenSearchParseException;
                topDocs = searcher.search(query, 10);
                b.endObject();
            -1,
                    b.field("ignore_malformed", true);
                }
        try (Directory dir = newDirectory()) {
                    b.field("ignore_malformed", "true");
            "192.169.1.1",
            lookup,
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> new DerivedFieldScript(
                query = QueryBuilders.rangeQuery("object_field.date_field").from("2024-03-20T14:20:50").toQuery(queryShardContext);
                QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                    b.field("type", "object");
                assertEquals(4, topDocs.totalHits.value());
                + "\"float_field\": 5.8,"
                when(queryShardContext.compile(Mockito.any(), Mockito.any())).thenReturn(factory);
            8900L,
                topDocs = searcher.search(query, 10);
                topDocs = searcher.search(query, 10);
            new Tuple<>(-1.0, -1.0),
}
                b.endObject();
                + "\"keyword_field\": \"PUT\","
                + "\"array_field\": [19, 20, 21],"
import org.apache.lucene.search.TopDocs;
            "127.0.0.1",
                assertEquals(2, topDocs.totalHits.value());
        try (Directory dir = newDirectory()) {
                + "\"date_field\": \"2024-03-20T10:05:55\","
        List<Document> docs = new ArrayList<>();
            }
                            null,
                b.startObject("request_size");
                topDocs = searcher.search(query, 10);
        MapperService mapperService = createMapperService(topMapping(b -> {
                    b.field("type", "geo_point");
                + "\"invalid_field\": {},"
                b.endObject();
                + "\"nested_field\": { \"sub_field_1\": \"PUT\"}"
        // Index and Search
                topDocs = searcher.search(query, 10);
            try (IndexReader reader = DirectoryReader.open(iw)) {
            }
                    }
        int[] scriptIndex = { 8 };
                    b.field("type", "object");
                assertEquals(7, topDocs.totalHits.value());
                        );
                // NOTE: object_field.keyword_field will be resolved to a text field for nested field as that's the default behaviour in
                    b.field("type", "object");
            6300L,
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
                // since we have prefilter_field set to "raw_message", it should not evaluate all documents
                + "\"array_field\": [28, 29, 30],"
                query = QueryBuilders.wildcardQuery("method", "G*").toQuery(queryShardContext);
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> new DerivedFieldScript(
                // IP Field Term Query
                TermQueryBuilder termQueryBuilder = new TermQueryBuilder("object_field.keyword_field", "GET");
                b.startObject("object_field_2");
                scriptIndex[0] = 4;
                }
                b.endObject();
        for (Object[] request : raw_requests) {
            }
            }
            @Override
                {
                + "\"text_field\": \"document number 10\","
                + "\"boolean_field\": true,"
                assertEquals(10, topDocs.totalHits.value());
            "247.37.0.0 GET /french/splash_inet.html?size=4.1KB HTTP/1.0 400 2024-03-20T11:20:10 4100",
                + "\"text_field\": \"document number 2\","
                    }
                + "\"float_field\": 10.7,"
            @Override
                topDocs = searcher.search(query, 10);
                    b.field("script", "");
                + "\"array_field\": [1, 2, 3],"
            Document document = new Document();
            params,
            "{ "
        List<Document> docs = new ArrayList<>();
            "247.37.0.0 DELETE /french/splash_inet.html?size=5.8KB HTTP/1.0 400 2024-03-20T12:45:30 5800",
        when(queryShardContext.compile(Mockito.any(), Mockito.any())).thenReturn(factory);
                scriptIndex[0] = 4;
                    MappedFieldType res = mapperService.fieldType(inv.getArguments()[0].toString());
        {
                {
                IndexSearcher searcher = new IndexSearcher(reader);
                {
                query = QueryBuilders.multiMatchQuery("GET", "object_field.nested_field.sub_field_1", "object_field.keyword_field")
            false,
                addEmittedValue(raw_requests[docId][scriptIndex[0]]);
            b.endObject();
                    b.field("type", "long");
                    b.field("type", "boolean");
            @Override
                super.setDocument(docId);
            {
            {
            ctx
                b.startObject("raw_message");
                + "\"array_field\": [10, 11, 12],"
                assertEquals(6, topDocs.totalHits.value());
                    b.startObject("properties");
                {
            public void execute() {
    }
            "50.60.70.80",
        {
        }
            @Override
                assertEquals(7, topDocs.totalHits.value());
            b.endObject();
                // dynamic mappings too
            public void setDocument(int docId) {
                topDocs = searcher.search(query, 10);
                + "\"text_field\": \"document number 6\","
                TopDocs topDocs = searcher.search(query, 10);
                // Regexp Query
            }
                    b.field("type", "ip");
                // Prefix Query
            b.endObject();
                // since last doc has a malformed json, if ignore_malformed isn't set or set as false, the query should fail
import org.apache.lucene.queryparser.classic.ParseException;
            ctx
            "50.60.70.80 GET /path/to/resource?size=7.2KB HTTP/1.0 404 2024-03-20T14:20:50 7200",
                + "\"long_field\": 1500,"
    // First element is the document ingested, other elements corresponds to value returned against a given derived field script
                + "\"date_field\": \"2024-03-20T15:30:25\","
                }
            document.add(new TextField("raw_message", (String) request[0], Field.Store.YES));
                + "}" },
import org.opensearch.index.query.TermQueryBuilder;
                    b.field("type", "object");
                            null,
            Document document = new Document();
                assertEquals(7, topDocs.totalHits.value());
            int docId = 0;
import org.apache.lucene.search.IndexSearcher;
                + "\"nested_field\": { \"sub_field_1\": \"DELETE\"}"
                b.endObject();
            "GET",
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
        }));
                + "\"long_field\": 10700,"
            true,
                b.startObject("long_prefilter_field_object");
                // dynamic mappings too
                        DerivedFieldResolver derivedFieldResolver = DerivedFieldResolverFactory.createResolver(
package org.opensearch.index.mapper;
                {
                b.endObject();
            "GET",
            1710940215000L,
                {
 * The OpenSearch Contributors require contributions made to
                query = QueryBuilders.regexpQuery("object_field.keyword_field", ".*let.*").toQuery(queryShardContext);
                assertEquals(2, topDocs.totalHits.value());
                    .toQuery(queryShardContext);
                query = geoShapeQuery("geopoint", new Rectangle(0.0, 55.0, 55.0, 0.0)).toQuery(queryShardContext);
                b.startObject("object_field");
            public void execute() {
                // prefilter_field
        {
                }
                    if (res == null) {
                {
            new Tuple<>(50.0, 60.0),
                + "\"float_field\": 6.3,"
                topDocs = searcher.search(query, 10);
                iw.addDocument(d);
            false,
            public void execute() {
                    b.endObject();
                    b.field("type", "text");
        }
                    b.field("script", "");
                docsEvaluated[0] = 0;
            "232.0.0.0 GET /images/hm_bg.jpg?size=2.3KB HTTP/1.0 400 2024-03-20T09:15:20 2300",
                assertThrows(MapperException.class, () -> finalTermQueryBuilder2.toQuery(queryShardContext));
                termQueryBuilder = new TermQueryBuilder("invalid_object.keyword_field", "GET");
            5800L,
                + "\"date_field\": \"2024-03-20T17:50:40\","
                query = termQueryBuilder.toQuery(queryShardContext);
                    b.field("prefilter_field", "raw_message");
                assertEquals(3, topDocs.totalHits.value());
                scriptIndex[0] = 4;
            {
            params,
            }
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
                    b.field("ignore_malformed", true);
                b.endObject();
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
                    b.field("type", "long");
                + "\"long_field\": 3700,"
            @Override
                b.endObject();
                termQueryBuilder.caseInsensitive(true);
    public void testAllPossibleQueriesOnDerivedFields() throws IOException {
                assertEquals(1, topDocs.totalHits.value());
        for (Object[] request : raw_requests) {
            public void setDocument(int docId) {
                + "\"boolean_field\": true,"
            2300L,
                + "\"keyword_field\": \"GET\","
                    }
                {
            9400L,
                    b.field("type", "text");
            b.endObject();
                + "\"date_field\": \"2024-03-20T13:10:15\","
        // Mock DerivedFieldScript.Factory
                    b.startObject("properties");
                + "\"text_field\": \"document number 5\","
                    b.field("prefilter_field", "raw_message");
                            true
            3.7,
import org.apache.lucene.index.IndexReader;
                }
                    b.field("prefilter_field", "raw_message");
                QueryShardContext queryShardContext = createQueryShardContext(mapperService);
                + "\"date_field\": \"2024-03-20T09:15:20\","
        // Mock DerivedFieldScript.Factory
        try (Directory dir = newDirectory()) {
                topDocs = searcher.search(query, 10);
                }
                + "\"long_field\": 7200,"
                addEmittedValue(raw_requests[docId][scriptIndex[0]]);
        // Index and Search
import java.util.List;
                        res = derivedFieldResolver.resolve(inv.getArguments()[0].toString());
        // Index and Search
                assertEquals(1, topDocs.totalHits.value());
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;
                + "\"long_field\": 8900,"
                query = QueryBuilders.rangeQuery("@timestamp").from("2024-03-20T14:20:50").toQuery(queryShardContext);
                query = QueryBuilders.rangeQuery("object_field.float_field").from("4.1").toQuery(queryShardContext);
            "{ "
            ctx
                b.startObject("object_field");
                // tested missing nested field
                // NOTE: object_field.keyword_field will be resolved to a text field for nested field as that's the default behaviour in
            false,
                query = QueryBuilders.regexpQuery("object_field.nested_field.sub_field_1", ".*let.*").toQuery(queryShardContext);
                }
                Query query = termQueryBuilder.toQuery(queryShardContext);
                b.startObject("object_field_2");
                + "\"array_field\": [25, 26, 27],"
                {
                Query query = termQueryBuilder.toQuery(queryShardContext);
                b.endObject();
            int docId = 0;
            1710926120000L,
                + "\"float_field\": 2.3,"
                topDocs = searcher.search(query, 10);
                        res = derivedFieldResolver.resolve(inv.getArguments()[0].toString());
        {
                query = QueryBuilders.termQuery("regular_derived_field_without_prefilter_field", "delete")
            false,
                IndexSearcher searcher = new IndexSearcher(reader);
                Query finalQuery = query;
                    return res;
                + "\"date_field\": \"2024-03-20T11:20:10\","
        int[] scriptIndex = { 8 };
    public void testObjectDerivedFields() throws IOException, ParseException {
                query = QueryBuilders.matchPhraseQuery("object_field.text_field", "document number 1").toQuery(queryShardContext);
                termQueryBuilder.caseInsensitive(true);
                // test regular_derived_field_without_prefilter_field
        {
    // Raw Message, Request Succeeded (boolean), Timestamp (long), Client IP, Method, Request Size (double), Duration (long)
                query = QueryBuilders.termQuery("method", "delete").caseInsensitive(true).toQuery(queryShardContext);
            Document document = new Document();
            new Tuple<>(20.0, 30.0),
                // GeoPoint Query
                + "\"array_field\": [16, 17, 18],"
                    b.field("prefilter_field", "invalid_field");
            "{ "
            {
        // Index and Search
            true,
                this.docId = docId;
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
                + "\"boolean_field\": false,"
                assertEquals(0, topDocs.totalHits.value());
            true,
            "127.0.0.1 GET /path/to/resource?size=9.4KB HTTP/1.0 200 2024-03-20T16:40:15 9400",
            params,
                topDocs = searcher.search(query, 10);
                // test regular_derived_field
                iw.addDocument(d);
            b.endObject();
        {
            Document document = new Document();
                + "\"text_field\": \"document number 1\","
                + "\"keyword_field\": \"GET\","
                + "\"long_field\": 10700,"
            new Tuple<>(10.0, 20.0),
                query = QueryBuilders.rangeQuery("object_field.array_field").from("9").to("9").toQuery(queryShardContext);
                + "\"text_field\": \"document number 10\","
            lookup,
                    .type(MultiMatchQueryBuilder.Type.PHRASE)
                }
                assertEquals(4, topDocs.totalHits.value());
                    {
            "{ "
            docs.add(document);
                b.startObject("regular_derived_field");
import org.opensearch.common.collect.Tuple;
                {
                docsEvaluated[0] = 0;
                    b.field("type", "object");
            try (IndexReader reader = DirectoryReader.open(iw)) {
                    }
                {
                    }
                b.startObject("client_ip");
                    b.field("type", "object");
            b.startObject("derived");
                topDocs = searcher.search(query, 10);
                + "\"text_field\": \"document number 4\","
    public void testObjectDerivedFieldsWithPrefilterField() throws IOException {
                {
                termQueryBuilder = new TermQueryBuilder("object_field_2.keyword_field", "GET");
                        b.field("keyword_field", "date");
                }
        ) {
                    b.endObject();
            1710944450000L,
                + "\"float_field\": 3.7,"
                }
            "DELETE",
import org.opensearch.index.query.QueryShardContext;
                    b.field("type", "object");
    public void testObjectDerivedFieldsWithIgnoreMalformed() throws IOException {
                b.startObject("method");
                            queryShardContext,
                            null,
                + "\"long_field\": 4100,"
        {
                b.startObject("long_field");
                    b.field("type", "text");
            {
            new Tuple<>(70.0, 80.0),
                    b.field("script", "");
                + "\"float_field\": 9.4,"
            "40.135.0.0",
                b.endObject();
            "DELETE",
                topDocs = searcher.search(query, 10);
            "PUT",
                query = QueryBuilders.rangeQuery("invalid_object.date_field").from("2024-03-20T14:20:50").toQuery(queryShardContext);
                            null,
                b.endObject();
                // Range queries of types - date, long and double
        // malformed json
                TopDocs topDocs = searcher.search(query, 10);
                query = QueryBuilders.rangeQuery("object_field.array_field").from("31").to("50").toQuery(queryShardContext);
        for (Object[] request : raw_requests) {
                query = QueryBuilders.regexpQuery("object_field.invalid_field.sub_field", ".*let.*").toQuery(queryShardContext);
                        );
                    b.field("format", "yyyy-MM-dd");
            "{ "
            for (Document d : docs) {
                assertEquals(4, topDocs.totalHits.value());
                queryParser.parse("GE?");
                + "\"array_field\": [28, 29, 30],"
            lookup,
        {
                assertEquals(2, topDocs.totalHits.value());
                    b.field("type", "text");
                query = QueryBuilders.wildcardQuery("object_field.keyword_field", "g*").toQuery(queryShardContext);
                query = QueryBuilders.matchPhraseQuery("object_field.text_field", "document number 11").toQuery(queryShardContext);
                + "}" },
                assertEquals(7, topDocs.totalHits.value());
                b.startObject("raw_message");
                Query finalQuery = query;
                }
                when(queryShardContext.compile(Mockito.any(), Mockito.any())).thenReturn(factory);
            params,
                b.endObject();
            {
                assertEquals(7, topDocs.totalHits.value());
            }
                    .caseInsensitive(true)
                    b.field("prefilter_field", "raw_message");
                assertEquals(11, docsEvaluated[0]);
            4.1,
                + "\"array_field\": [22, 23, 24],"
                + "\"date_field\": \"2024-03-20T12:45:30\","
            10700L,
            b.endObject();
            }
                + "\"long_field\": 9400,"
            for (Document d : docs) {
                + "\"boolean_field\": false,"
                b.startObject("object_field");
                topDocs = searcher.search(query, 10);
                TermQueryBuilder finalTermQueryBuilder2 = termQueryBuilder;
                query = QueryBuilders.termsQuery("method", "delete").toQuery(queryShardContext);
        };
                iw.addDocument(d);
            document.add(new TextField("raw_message", (String) request[0], Field.Store.YES));
        }
        }));
            @Override
                topDocs = searcher.search(query, 10);
                topDocs = searcher.search(query, 10);
                    {
            b.endObject();
            }
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
            3700L,
                    if (res == null) {
                }
                {
                + "\"date_field\": \"2024-03-20T17:50:40\","
                // test object_field_2
        {
                + "\"nested_field\": { \"sub_field_1\": \"DELETE\"}"
                            queryShardContext,
                    return res;
                + "" } };
                termQueryBuilder.caseInsensitive(true);
                    b.field("ignore_malformed", false);
                + "\"keyword_field\": \"DELETE\","
            1710929155000L,
                + "}" },
        // Mock DerivedFieldScript.Factory
                // check if ignoreMalformed is set to true, the query passes with 0 results
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
            {
            "232.0.0.0",
                b.endObject();
                    b.field("script", "");
            "{ "
                + "}" },
                    .toQuery(queryShardContext);
                // Multi Phrase Query
                + "}" },
                b.endObject();
                when(queryShardContext.sourcePath("raw_message")).thenReturn(Set.of("raw_message"));
                b.startObject("raw_message");
                        b.field("keyword_field", "keyword");
            false,
        ) {
                        b.field("keyword_field", "keyword");
        {
                assertEquals(7, topDocs.totalHits.value());
                query = QueryBuilders.regexpQuery("method", ".*LET.*").toQuery(queryShardContext);
            b.startObject("properties");
            "GET",
                    b.field("script", "");
            b.startObject("derived");
                iw.addDocument(d);
                + "\"text_field\": \"document number 9\","
            docs.add(document);
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
                    b.field("script", "");
                + "\"boolean_field\": false,"
        MapperService mapperService = createMapperService(topMapping(b -> {
                assertEquals(0, topDocs.totalHits.value());
                        DerivedFieldResolver derivedFieldResolver = DerivedFieldResolverFactory.createResolver(
                {
            }
                assertEquals(8, docsEvaluated[0]);
                });
                scriptIndex[0] = 4;
                assertEquals(0, topDocs.totalHits.value());
                scriptIndex[0] = 2;
                + "\"date_field\": \"2024-03-20T14:20:50\","
                }
                docsEvaluated[0]++;
            new Tuple<>(30.0, 40.0),
            }
                + "\"nested_field\": { \"sub_field_1\": \"GET\"}"
            for (Document d : docs) {
                topDocs = searcher.search(query, 10);
            try (IndexReader reader = DirectoryReader.open(iw)) {
                }
                            queryShardContext,
                            null,
        }
                assertEquals(1, topDocs.totalHits.value());
                + "}" },
                + "\"long_field\": 5800,"
                {
                query = QueryBuilders.rangeQuery("object_field.array_field").from("10").to("12").toQuery(queryShardContext);
import org.opensearch.script.DerivedFieldScript;
                + "\"invalid_field\": {},"
                + "\"array_field\": [13, 14, 15],"
                + "\"date_field\": \"2024-03-20T16:40:15\","
                when(queryShardContext.getIndexReader()).thenReturn(reader);
            lookup,
            int docId = 0;
                + "}" },
                topDocs = searcher.search(query, 10);
                    b.startObject("properties");
import static org.mockito.ArgumentMatchers.anyString;
                query = QueryBuilders.termQuery("client_ip", "192.168.0.0/16").toQuery(queryShardContext);
            8.9,
                }
                TermQueryBuilder finalTermQueryBuilder = termQueryBuilder;
                scriptIndex[0] = 7;
 * this file be licensed under the Apache-2.0 license or a
            7.2,
                query = new MatchPhrasePrefixQueryBuilder("object_field.text_field", "document number").toQuery(queryShardContext);
                + "\"keyword_field\": \"GET\","
                query = QueryBuilders.rangeQuery("object_field.long_field").from("5800").toQuery(queryShardContext);
                    b.startObject("properties");
                + "\"date_field\": \"2024-03-20T08:30:45\","
                IndexSearcher searcher = new IndexSearcher(reader);
        }
        MapperService mapperService = createMapperService(topMapping(b -> {
                + "\"keyword_field\": \"GET\","
            new Tuple<>(85.0, 90.0),
            public void setDocument(int docId) {
                    MappedFieldType res = mapperService.fieldType(inv.getArguments()[0].toString());
        List<Document> docs = new ArrayList<>();
                    }
                TermQueryBuilder termQueryBuilder = new TermQueryBuilder("object_field.keyword_field", "GET");
                query = QueryBuilders.rangeQuery("object_field_3.keyword_field").from("2024-03-20T14:20:50").toQuery(queryShardContext);
