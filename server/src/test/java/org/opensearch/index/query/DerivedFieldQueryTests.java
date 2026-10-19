        { "247.37.0.0 GET /french/splash_inet.html HTTP/1.0", "200", "247.37.0.0" } };
                IndexSearcher searcher = new IndexSearcher(reader);
            Document document = new Document();
        // Index and Search
        );
            true
    public void testNeedsRewriteWithRegularQuery() throws IOException {
            };
        SourceLookup sourceLookup = new SourceLookup();
                );
        // Mock DerivedFieldScript.Factory
        // Create real queries: PointRangeQuery -> IndexOrDocValuesQuery
            pointRangeQuery,
    public void testNeedsRewriteWithIndexOrDocValuesQueryAndPointRange() throws IOException {
                    () -> valueFetcher,
        SearchLookup searchLookup = mock(SearchLookup.class);
        }
                // Rewrite should return the same query without attempting rewrite
                }
                    false
        when(leafLookup.source()).thenReturn(sourceLookup);
        // Index and Search
import org.apache.lucene.index.IndexWriter;
            try (IndexReader reader = DirectoryReader.open(iw)) {
        );
        IndexOrDocValuesQuery indexOrDocValuesQuery = new IndexOrDocValuesQuery(pointRangeQuery, dvQuery);
            };
        // Index and Search
            true
                    addEmittedValue(raw_requests[sourceLookup.docId()][2]);
import org.apache.lucene.search.IndexOrDocValuesQuery;
            () -> valueFetcher,
                @Override
                    addEmittedValue(raw_requests[sourceLookup.docId()][2]);
            "keyword",
        // Create ValueFetcher from mocked DerivedFieldScript.Factory
        List<Document> docs = new ArrayList<>();
        try (Directory dir = newDirectory()) {
        }
        };
            searchLookup,
        { "232.0.0.0 GET /images/hm_bg.jpg HTTP/1.0", "400", "232.0.0.0" },
            for (Document d : docs) {
import org.apache.lucene.document.Document;
                IndexSearcher searcher = new IndexSearcher(reader);
                // Since TermQuery doesn't rewrite to something different, we still get the same DerivedFieldQuery back
        try (Directory dir = newDirectory()) {
            }
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
            new TermQuery(new Term("ip_from_raw_request", "247.37.0.0")),
            document.add(new TextField("raw_request", request[0], Field.Store.YES));
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> {
        DerivedFieldValueFetcher valueFetcher = new DerivedFieldValueFetcher(leafFactory, null);
                    searchLookup,
            new TermQuery(new Term("ip_from_raw_request", "247.37.0.0")),
            docs.add(document);
        DerivedFieldValueFetcher valueFetcher = new DerivedFieldValueFetcher(leafFactory, null);
                iw.close();
            docs.add(document);
import org.opensearch.index.mapper.DerivedFieldValueFetcher;
            return new DerivedFieldScript(params, lookup, ctx) {
                iw.addDocument(d);
            when(searchLookup.getLeafSearchLookup(ctx)).thenReturn(leafLookup);
        };
            try (IndexReader reader = DirectoryReader.open(iw)) {
    }
                iw.close();
        when(leafLookup.source()).thenReturn(sourceLookup);
            document.add(new KeywordField("status", request[1], Field.Store.YES));
        DerivedFieldScript.LeafFactory leafFactory = factory.newFactory((new Script("")).getParams(), searchLookup);
        DerivedFieldValueFetcher valueFetcher = new DerivedFieldValueFetcher(leafFactory, null);
            docs.add(document);
            Lucene.STANDARD_ANALYZER,
import org.apache.lucene.index.IndexReader;
            Lucene.STANDARD_ANALYZER,
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
                }
        DerivedFieldValueFetcher valueFetcher = new DerivedFieldValueFetcher(leafFactory, null);
        List<Document> docs = new ArrayList<>();
                @Override
            "ip_from_raw_request"
            document.add(new KeywordField("status", request[1], Field.Store.YES));
            try (IndexReader reader = DirectoryReader.open(iw)) {
                // Create DerivedFieldQuery
            "ip_from_raw_request"
        Query pointRangeQuery = IntPoint.newRangeQuery("test_field", 0, 100);
            document.add(new KeywordField("status", request[1], Field.Store.YES));
            }
        // Mock SearchLookup
        { "40.135.0.0 GET /images/hm_bg.jpg HTTP/1.0", "200", "40.135.0.0" },
        for (String[] request : raw_requests) {
                public void execute() {
        }
import org.opensearch.test.OpenSearchTestCase;
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
 */
        }
        // Create ValueFetcher from mocked DerivedFieldScript.Factory
 * this file be licensed under the Apache-2.0 license or a
            }
                iw.addDocument(d);
import org.apache.lucene.document.Field;
        SourceLookup sourceLookup = new SourceLookup();
                }
        for (String[] request : raw_requests) {
import org.opensearch.search.lookup.LeafSearchLookup;
    }
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> {
                iw.addDocument(d);
            "date",
        Function<Object, IndexableField> badIndexableFieldFunction = DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(
            document.add(new TextField("raw_request", request[0], Field.Store.YES));
        // Create DerivedFieldQuery
        // Mock SearchLookup
                public void execute() {
        Function<Object, IndexableField> indexableFieldFunction = DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(
                    Lucene.STANDARD_ANALYZER,
            Lucene.STANDARD_ANALYZER,
                @Override
                DerivedFieldQuery finalDerivedFieldQuery = derivedFieldQuery;
                    addEmittedValue(raw_requests[sourceLookup.docId()][2]);
            };
        // Mock DerivedFieldScript.Factory
        );
        // Mock SearchLookup
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TermQuery;
                    badIndexableFieldFunction,
        for (String[] request : raw_requests) {
        }
            }
        // Create DerivedFieldQuery with regular TermQuery
            when(searchLookup.getLeafSearchLookup(ctx)).thenReturn(leafLookup);
            }
            try (IndexReader reader = DirectoryReader.open(iw)) {
        };
            }
        { "247.37.0.0 GET /french/splash_inet.html HTTP/1.0", "400", "247.37.0.0" },
        { "247.37.0.0 GET /french/splash_inet.html HTTP/1.0", "400", "247.37.0.0" },
                public void execute() {
            "keyword",
package org.opensearch.index.query;
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
                assertSame(derivedFieldQuery, rewritten);
            "ip_from_raw_request"
        when(leafLookup.source()).thenReturn(sourceLookup);
        // Create lucene documents
            "ip_from_raw_request"
import org.apache.lucene.search.MatchNoDocsQuery;
        List<Document> docs = new ArrayList<>();
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
import org.apache.lucene.index.DirectoryReader;
            }
        // Mock SearchLookup
        // Mock DerivedFieldScript.Factory
        // Create DerivedFieldQuery with PointRangeQuery
import org.apache.lucene.document.TextField;
            for (Document d : docs) {
            }
public class DerivedFieldQueryTests extends OpenSearchTestCase {
        }
                // Rewrite should perform rewrite on the inner query (TermQuery doesn't change in this case)
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
import org.opensearch.search.lookup.SourceLookup;
        );
        }
                searcher.search(derivedFieldQuery, 10);
    private static final String[][] raw_requests = new String[][] {
            for (Document d : docs) {
        SearchLookup searchLookup = mock(SearchLookup.class);
            for (Document d : docs) {
                }
            };
                public void execute() {
            for (Document d : docs) {
                IndexSearcher searcher = new IndexSearcher(reader);
        try (Directory dir = newDirectory()) {
        );
        List<Document> docs = new ArrayList<>();
            () -> valueFetcher,
import static org.mockito.Mockito.when;
            "keyword",
            indexableFieldFunction,
    public void testDerivedField() throws IOException {
        for (String[] request : raw_requests) {
        Function<Object, IndexableField> indexableFieldFunction = DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(
            "keyword",
                TopDocs topDocs = searcher.search(derivedFieldQuery, 10);
            true
                IndexSearcher searcher = new IndexSearcher(reader);
            Document document = new Document();
            indexOrDocValuesQuery,
            }
import org.opensearch.common.lucene.Lucene;
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
                iw.addDocument(d);
    }
                    new TermQuery(new Term("ip_from_raw_request", "247.37.0.0")),
                TopDocs topDocs = searcher.search(derivedFieldQuery, 10);
 * SPDX-License-Identifier: Apache-2.0
            try (IndexReader reader = DirectoryReader.open(iw)) {
/*
                iw.close();
        Function<Object, IndexableField> indexableFieldFunction = DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(
                assertSame(derivedFieldQuery, rewritten);
                public void execute() {
            indexableFieldFunction,
 *
                Query rewritten = derivedFieldQuery.rewrite(searcher);
        DerivedFieldScript.LeafFactory leafFactory = factory.newFactory((new Script("")).getParams(), searchLookup);
            docs.add(document);
                IndexSearcher searcher = new IndexSearcher(reader);
        when(leafLookup.source()).thenReturn(sourceLookup);
            searchLookup,
        };
            when(searchLookup.getLeafSearchLookup(ctx)).thenReturn(leafLookup);
                    Lucene.STANDARD_ANALYZER,
        Function<Object, IndexableField> indexableFieldFunction = DerivedFieldSupportedTypes.getIndexableFieldGeneratorType(
            searchLookup,
                iw.close();
import org.opensearch.script.Script;
        // Mock SearchLookup
            return new DerivedFieldScript(params, lookup, ctx) {
        };
            () -> valueFetcher,
        // Create ValueFetcher from mocked DerivedFieldScript.Factory
            document.add(new KeywordField("status", request[1], Field.Store.YES));
        when(leafLookup.source()).thenReturn(sourceLookup);
        for (String[] request : raw_requests) {
        // Index and Search
                    new TermQuery(new Term("ip_from_raw_request", "247.37.0.0")),
        // Index and Search
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
                Query rewritten = derivedFieldQuery.rewrite(searcher);
            docs.add(document);
                assertSame(derivedFieldQuery, rewritten);
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
import org.apache.lucene.document.IntPoint;
                    addEmittedValue(raw_requests[sourceLookup.docId()][2]);
        // Create DerivedFieldQuery with IndexOrDocValuesQuery with PointRangeQuery
                derivedFieldQuery = new DerivedFieldQuery(
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> {
                iw.close();
            }
            searchLookup,
import org.apache.lucene.store.Directory;
                    true
    }
        Query pointRangeQuery = IntPoint.newRangeQuery("test_field", 0, 100);
        SearchLookup searchLookup = mock(SearchLookup.class);
    public void testDerivedFieldWithIgnoreMalformed() throws IOException {
 * The OpenSearch Contributors require contributions made to
        SourceLookup sourceLookup = new SourceLookup();
            Document document = new Document();
import org.apache.lucene.index.IndexableField;
        DerivedFieldScript.LeafFactory leafFactory = factory.newFactory((new Script("")).getParams(), searchLookup);
            () -> valueFetcher,
        // Create lucene documents
        // Create lucene documents
                assertThrows(ClassCastException.class, () -> searcher.search(finalDerivedFieldQuery, 10));
        try (Directory dir = newDirectory()) {
        DerivedFieldScript.LeafFactory leafFactory = factory.newFactory((new Script("")).getParams(), searchLookup);
            Document document = new Document();
                    addEmittedValue(raw_requests[sourceLookup.docId()][2]);
        // Create ValueFetcher from mocked DerivedFieldScript.Factory
            Lucene.STANDARD_ANALYZER,
        // Create a real PointRangeQuery using IntPoint
                // set ignore_malformed as true, query should pass
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(Lucene.STANDARD_ANALYZER));
            return new DerivedFieldScript(params, lookup, ctx) {
            indexableFieldFunction,
 * compatible open source license.
        );
                Query rewritten = derivedFieldQuery.rewrite(searcher);
import java.util.ArrayList;
        List<Document> docs = new ArrayList<>();
import org.opensearch.index.mapper.DerivedFieldSupportedTypes;
import org.apache.lucene.document.KeywordField;
                    () -> valueFetcher,
        DerivedFieldValueFetcher valueFetcher = new DerivedFieldValueFetcher(leafFactory, null);
        );
import org.apache.lucene.search.Query;
        // Create lucene documents
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
        );
        Query dvQuery = new MatchNoDocsQuery();
import org.apache.lucene.index.IndexWriterConfig;
        SearchLookup searchLookup = mock(SearchLookup.class);
                }
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> {
        }
        }
            document.add(new TextField("raw_request", request[0], Field.Store.YES));
import java.io.IOException;
        DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
        SearchLookup searchLookup = mock(SearchLookup.class);
            document.add(new TextField("raw_request", request[0], Field.Store.YES));
                    searchLookup,
            true
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
                @Override
            return new DerivedFieldScript(params, lookup, ctx) {
import org.opensearch.script.DerivedFieldScript;
                // Rewrite should return the same query without attempting rewrite
    }
import java.util.List;
import org.apache.lucene.index.Term;
            when(searchLookup.getLeafSearchLookup(ctx)).thenReturn(leafLookup);
                assertEquals(0, topDocs.totalHits.value());
                );
                @Override
            Document document = new Document();
            when(searchLookup.getLeafSearchLookup(ctx)).thenReturn(leafLookup);
    public void testNeedsRewriteWithPointRangeQuery() throws IOException {
            "ip_from_raw_request"
        SourceLookup sourceLookup = new SourceLookup();
import org.opensearch.search.lookup.SearchLookup;
        }
                assertEquals(3, topDocs.totalHits.value());
        // Mock DerivedFieldScript.Factory
        // Mock DerivedFieldScript.Factory
            indexableFieldFunction,
        DerivedFieldScript.LeafFactory leafFactory = factory.newFactory((new Script("")).getParams(), searchLookup);
                iw.addDocument(d);
                DerivedFieldQuery derivedFieldQuery = new DerivedFieldQuery(
        try (Directory dir = newDirectory()) {
        { "26.1.0.0 GET /images/hm_bg.jpg HTTP/1.0", "200", "26.1.0.0" },
        // Create ValueFetcher from mocked DerivedFieldScript.Factory
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> {
import static org.mockito.Mockito.mock;
import org.apache.lucene.search.IndexSearcher;
            document.add(new KeywordField("status", request[1], Field.Store.YES));
        // Create lucene documents
            };
import java.util.function.Function;
        SourceLookup sourceLookup = new SourceLookup();
        );
}
            return new DerivedFieldScript(params, lookup, ctx) {
                    badIndexableFieldFunction,
            document.add(new TextField("raw_request", request[0], Field.Store.YES));
