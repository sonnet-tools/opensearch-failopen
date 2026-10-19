import org.opensearch.index.mapper.DerivedFieldSupportedTypes;
            when(searchLookup.getLeafSearchLookup(ctx)).thenReturn(leafLookup);
        Query pointRangeQuery = IntPoint.newRangeQuery("test_field", 0, 100);
            for (Document d : docs) {  
import org.opensearch.script.DerivedFieldScript;
import org.apache.lucene.search.IndexOrDocValuesQuery;  
        DerivedFieldValueFetcher valueFetcher = new DerivedFieldValueFetcher(leafFactory, null);
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);  
            pointRangeQuery,  
                assertSame(derivedFieldQuery, rewritten);
        { "232.0.0.0 GET /images/hm_bg.jpg HTTP/1.0", "400", "232.0.0.0" },
            try (IndexReader reader = DirectoryReader.open(iw)) {
            document.add(new TextField("raw_request", request[0], Field.Store.YES));
                }
            document.add(new TextField("raw_request", request[0], Field.Store.YES));  
        { "26.1.0.0 GET /images/hm_bg.jpg HTTP/1.0", "200", "26.1.0.0" },  
        // Create DerivedFieldQuery with IndexOrDocValuesQuery with PointRangeQuery
import java.util.function.Function;
import org.opensearch.script.Script;
                    () -> valueFetcher,
                TopDocs topDocs = searcher.search(derivedFieldQuery, 10);  
        DerivedFieldScript.LeafFactory leafFactory = factory.newFactory((new Script("")).getParams(), searchLookup);  
 * SPDX-License-Identifier: Apache-2.0
            document.add(new TextField("raw_request", request[0], Field.Store.YES));
                Query rewritten = derivedFieldQuery.rewrite(searcher);
            "ip_from_raw_request"
        // Index and Search  
        SourceLookup sourceLookup = new SourceLookup();
            }
                    addEmittedValue(raw_requests[sourceLookup.docId()][2]);  
                    new TermQuery(new Term("ip_from_raw_request", "247.37.0.0")),  
            "ip_from_raw_request"  
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(  
            Document document = new Document();  
 * compatible open source license.
            for (Document d : docs) {
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
            return new DerivedFieldScript(params, lookup, ctx) {
                    false
        // Create ValueFetcher from mocked DerivedFieldScript.Factory
            }  
            when(searchLookup.getLeafSearchLookup(ctx)).thenReturn(leafLookup);
 * The OpenSearch Contributors require contributions made to  
            indexableFieldFunction,
            true
        // Create a real PointRangeQuery using IntPoint
        for (String[] request : raw_requests) {
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
        // Mock DerivedFieldScript.Factory  
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
            () -> valueFetcher,
        DerivedFieldScript.LeafFactory leafFactory = factory.newFactory((new Script("")).getParams(), searchLookup);  
                iw.close();  
        Function<Object, IndexableField> badIndexableFieldFunction = DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(
        // Create real queries: PointRangeQuery -> IndexOrDocValuesQuery  
            () -> valueFetcher,
                @Override  
        // Mock SearchLookup  
        SearchLookup searchLookup = mock(SearchLookup.class);
        );
            }
            document.add(new KeywordField("status", request[1], Field.Store.YES));  
            "keyword",
            Document document = new Document();  
        // Create ValueFetcher from mocked DerivedFieldScript.Factory  
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);  
                    Lucene.STANDARD_ANALYZER,  
            try (IndexReader reader = DirectoryReader.open(iw)) {  
            indexableFieldFunction,
                    badIndexableFieldFunction,
        );
                IndexSearcher searcher = new IndexSearcher(reader);
import org.opensearch.search.lookup.SearchLookup;
            }  
            Document document = new Document();
            when(searchLookup.getLeafSearchLookup(ctx)).thenReturn(leafLookup);
    public void testNeedsRewriteWithPointRangeQuery() throws IOException {
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
            document.add(new TextField("raw_request", request[0], Field.Store.YES));
                    addEmittedValue(raw_requests[sourceLookup.docId()][2]);  
        Function<Object, IndexableField> indexableFieldFunction = DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(
            docs.add(document);  
        // Create lucene documents  
        when(leafLookup.source()).thenReturn(sourceLookup);
import org.apache.lucene.index.Term;
        SourceLookup sourceLookup = new SourceLookup();
                @Override
import org.apache.lucene.search.TermQuery;
        };
        // Mock SearchLookup
                @Override
        // Mock DerivedFieldScript.Factory  
        List<Document> docs = new ArrayList<>();
            document.add(new KeywordField("status", request[1], Field.Store.YES));
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> {
package org.opensearch.index.query;
        };  
            };  
            new TermQuery(new Term("ip_from_raw_request", "247.37.0.0")),  
            for (Document d : docs) {
        );
import org.apache.lucene.document.Field;
/*  
import org.opensearch.search.lookup.LeafSearchLookup;  
            for (Document d : docs) {
            "ip_from_raw_request"  
                // Since TermQuery doesn't rewrite to something different, we still get the same DerivedFieldQuery back
                }
            };
 */  
        SearchLookup searchLookup = mock(SearchLookup.class);
            };
            indexableFieldFunction,
            for (Document d : docs) {  
            "keyword",
                @Override
            true
import org.apache.lucene.document.Document;
                TopDocs topDocs = searcher.search(derivedFieldQuery, 10);
            }
            new TermQuery(new Term("ip_from_raw_request", "247.37.0.0")),  
        for (String[] request : raw_requests) {
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> {
                public void execute() {
        try (Directory dir = newDirectory()) {  
            Document document = new Document();
import org.apache.lucene.index.DirectoryReader;  
        for (String[] request : raw_requests) {  
            document.add(new KeywordField("status", request[1], Field.Store.YES));
        try (Directory dir = newDirectory()) {  
import org.apache.lucene.document.KeywordField;
                }
        DerivedFieldScript.LeafFactory leafFactory = factory.newFactory((new Script("")).getParams(), searchLookup);
                IndexSearcher searcher = new IndexSearcher(reader);
        for (String[] request : raw_requests) {
            "ip_from_raw_request"
        when(leafLookup.source()).thenReturn(sourceLookup);
            () -> valueFetcher,
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> {  
            }
        // Mock SearchLookup  
                iw.addDocument(d);  
        );  
            Document document = new Document();  
        when(leafLookup.source()).thenReturn(sourceLookup);  
            Lucene.STANDARD_ANALYZER,  
                assertSame(derivedFieldQuery, rewritten);  
            };
                public void execute() {
        // Index and Search
                }
                );  
            try (IndexReader reader = DirectoryReader.open(iw)) {  
        { "247.37.0.0 GET /french/splash_inet.html HTTP/1.0", "200", "247.37.0.0" } };  
import org.opensearch.search.lookup.SourceLookup;
        try (Directory dir = newDirectory()) {
        );  
    private static final String[][] raw_requests = new String[][] {  
        when(leafLookup.source()).thenReturn(sourceLookup);
                    searchLookup,
    public void testNeedsRewriteWithIndexOrDocValuesQueryAndPointRange() throws IOException {
                iw.addDocument(d);
            return new DerivedFieldScript(params, lookup, ctx) {  
                // Rewrite should perform rewrite on the inner query (TermQuery doesn't change in this case)  
            return new DerivedFieldScript(params, lookup, ctx) {
                iw.addDocument(d);  
        };  
    }  
        // Create ValueFetcher from mocked DerivedFieldScript.Factory
            document.add(new KeywordField("status", request[1], Field.Store.YES));
                assertSame(derivedFieldQuery, rewritten);  
                iw.close();
        DerivedFieldValueFetcher valueFetcher = new DerivedFieldValueFetcher(leafFactory, null);
        // Create lucene documents  
        }
        };
            document.add(new TextField("raw_request", request[0], Field.Store.YES));
        DerivedFieldValueFetcher valueFetcher = new DerivedFieldValueFetcher(leafFactory, null);  
 * this file be licensed under the Apache-2.0 license or a
            searchLookup,  
        for (String[] request : raw_requests) {
        List<Document> docs = new ArrayList<>();  
                public void execute() {
            };
                public void execute() {  
import org.apache.lucene.search.IndexSearcher;
                assertThrows(ClassCastException.class, () -> searcher.search(finalDerivedFieldQuery, 10));
        // Mock SearchLookup
                iw.close();  
        };  
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
                    () -> valueFetcher,
            }
        );  
            docs.add(document);
import static org.mockito.Mockito.when;
            when(searchLookup.getLeafSearchLookup(ctx)).thenReturn(leafLookup);  
                iw.close();
                @Override
                    true
                Query rewritten = derivedFieldQuery.rewrite(searcher);
        // Create lucene documents
        try (Directory dir = newDirectory()) {
        DerivedFieldScript.LeafFactory leafFactory = factory.newFactory((new Script("")).getParams(), searchLookup);
import java.util.List;
        SourceLookup sourceLookup = new SourceLookup();  
        // Index and Search
import org.apache.lucene.index.IndexWriterConfig;  
            }
        DerivedFieldScript.LeafFactory leafFactory = factory.newFactory((new Script("")).getParams(), searchLookup);  
        // Mock DerivedFieldScript.Factory
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
import java.io.IOException;
        List<Document> docs = new ArrayList<>();
        );
import org.opensearch.common.lucene.Lucene;
import org.apache.lucene.document.IntPoint;  
import org.apache.lucene.search.TopDocs;
                );  
            return new DerivedFieldScript(params, lookup, ctx) {  
                    addEmittedValue(raw_requests[sourceLookup.docId()][2]);
            searchLookup,
                iw.addDocument(d);
            Lucene.STANDARD_ANALYZER,  
            indexOrDocValuesQuery,
        // Create lucene documents  
public class DerivedFieldQueryTests extends OpenSearchTestCase {
        }  
 *
    public void testDerivedField() throws IOException {
        // Mock DerivedFieldScript.Factory
            searchLookup,
import org.opensearch.index.mapper.DerivedFieldValueFetcher;  
                    addEmittedValue(raw_requests[sourceLookup.docId()][2]);  
                // Rewrite should return the same query without attempting rewrite  
                public void execute() {
        SearchLookup searchLookup = mock(SearchLookup.class);  
import org.apache.lucene.search.Query;  
        SourceLookup sourceLookup = new SourceLookup();
        Function<Object, IndexableField> indexableFieldFunction = DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(  
            true  
    }
            "date",  
import org.opensearch.test.OpenSearchTestCase;  
                IndexSearcher searcher = new IndexSearcher(reader);
            try (IndexReader reader = DirectoryReader.open(iw)) {
                    badIndexableFieldFunction,
        { "247.37.0.0 GET /french/splash_inet.html HTTP/1.0", "400", "247.37.0.0" },
        }
        SourceLookup sourceLookup = new SourceLookup();
        { "247.37.0.0 GET /french/splash_inet.html HTTP/1.0", "400", "247.37.0.0" },
                IndexSearcher searcher = new IndexSearcher(reader);  
        );
                    addEmittedValue(raw_requests[sourceLookup.docId()][2]);
        // Create lucene documents
                }  
                iw.close();
        }
                    new TermQuery(new Term("ip_from_raw_request", "247.37.0.0")),  
import org.apache.lucene.search.MatchNoDocsQuery;
                derivedFieldQuery = new DerivedFieldQuery(
        Function<Object, IndexableField> indexableFieldFunction = DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(
        // Create ValueFetcher from mocked DerivedFieldScript.Factory
        SearchLookup searchLookup = mock(SearchLookup.class);
        // Create DerivedFieldQuery with PointRangeQuery
        Query pointRangeQuery = IntPoint.newRangeQuery("test_field", 0, 100);
            true
            }
import org.apache.lucene.index.IndexableField;
        when(leafLookup.source()).thenReturn(sourceLookup);
    }  
            Lucene.STANDARD_ANALYZER,  
                DerivedFieldQuery finalDerivedFieldQuery = derivedFieldQuery;
        // Create ValueFetcher from mocked DerivedFieldScript.Factory
        }  
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));  
            "keyword",
            when(searchLookup.getLeafSearchLookup(ctx)).thenReturn(leafLookup);
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
        }
        }
        }
        DerivedFieldValueFetcher valueFetcher = new DerivedFieldValueFetcher(leafFactory, null);
            "keyword",
        }
        Query dvQuery = new MatchNoDocsQuery();
            return new DerivedFieldScript(params, lookup, ctx) {  
        List<Document> docs = new ArrayList<>();
import static org.mockito.Mockito.mock;
                assertEquals(0, topDocs.totalHits.value());  
                // Rewrite should return the same query without attempting rewrite
            indexableFieldFunction,
import java.util.ArrayList;  
            Lucene.STANDARD_ANALYZER,
import org.apache.lucene.index.IndexWriter;
            searchLookup,
                    Lucene.STANDARD_ANALYZER,  
}
        }
            docs.add(document);
    public void testDerivedFieldWithIgnoreMalformed() throws IOException {  
        DerivedFieldValueFetcher valueFetcher = new DerivedFieldValueFetcher(leafFactory, null);
        { "40.135.0.0 GET /images/hm_bg.jpg HTTP/1.0", "200", "40.135.0.0" },
    }
                Query rewritten = derivedFieldQuery.rewrite(searcher);
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
import org.apache.lucene.document.TextField;
        );  
        // Create DerivedFieldQuery
        IndexOrDocValuesQuery indexOrDocValuesQuery = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);  
        // Mock DerivedFieldScript.Factory  
                DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
            docs.add(document);  
        // Mock SearchLookup  
            () -> valueFetcher,
        // Index and Search
                searcher.search(derivedFieldQuery, 10);
        // Create DerivedFieldQuery with regular TermQuery
    }  
            try (IndexReader reader = DirectoryReader.open(iw)) {
                IndexSearcher searcher = new IndexSearcher(reader);
            }
        try (Directory dir = newDirectory()) {
import org.apache.lucene.index.IndexReader;
        SearchLookup searchLookup = mock(SearchLookup.class);
            document.add(new KeywordField("status", request[1], Field.Store.YES));
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> {
            docs.add(document);  
                // set ignore_malformed as true, query should pass
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);  
        Function<Object, IndexableField> indexableFieldFunction = DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(
import org.apache.lucene.store.Directory;  
                assertEquals(3, topDocs.totalHits.value());
                    searchLookup,
            "ip_from_raw_request"  
                iw.addDocument(d);
        List<Document> docs = new ArrayList<>();
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
    public void testNeedsRewriteWithRegularQuery() throws IOException {
                // Create DerivedFieldQuery
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> {
        // Index and Search
