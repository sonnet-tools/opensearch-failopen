            b.startObject("dessert");
            try (IndexReader reader = DirectoryReader.open(iw)) {
                    assertEquals(scoreDoc.score, 1.0, 0.00000000001);
                assertEquals(topDocs.totalHits.value(), 0);
            docs.add(mapperService.documentMapper().parse(source(b -> b.field("dessert", dessert))));
        MapperService mapperService = createMapperService(mapping(b -> {
            QueryBuilders.matchQuery("dessert", "gulab").doToQuery(queryShardContext),  // Delegate query
 */
                topDocs = searcher.search(matchNone, 10);
            IllegalArgumentException.class,
    }
        );
import org.apache.lucene.search.TopDocs;
        when(queryShardContext.sourcePath("dessert")).thenReturn(Set.of("dessert"));
                assertEquals(topDocs.totalHits.value(), 2);
            }
 * SPDX-License-Identifier: Apache-2.0
            b.endObject();
            b.endObject();
                iw.close();
/*
import org.apache.lucene.index.IndexWriterConfig;
        );
    public void testSourceDisabled() throws IOException {
            {
        assertEquals(
        }
import java.util.List;
            for (ParsedDocument d : docs) {
            QueryBuilders.matchQuery("dessert", "apple").doToQuery(queryShardContext),  // Delegate query
                queryShardContext.getFieldType("dessert"),
        IllegalArgumentException e = expectThrows(
            queryShardContext.getFieldType("dessert"),
                assertEquals(topDocs.totalHits.value(), 0);
            queryShardContext.getFieldType("dessert"),
            queryShardContext
            for (ParsedDocument d : docs) {
import java.util.Set;
            )
                queryShardContext
        try (Directory dir = newDirectory()) {
                iw.addDocument(d.rootDoc());
        MapperService mapperService = createMapperService(topMapping(b -> b.startObject("_source").field("enabled", false).endObject()));
            QueryBuilders.matchQuery("dessert", "pie").doToQuery(queryShardContext),    // Filter query
import java.io.IOException;
            () -> new SourceFieldMatchQuery(
            e.getMessage()
            }
        List<ParsedDocument> docs = new ArrayList<>();
            queryShardContext.getFieldType("dessert"),
package org.opensearch.index.query;
                QueryBuilders.matchQuery("dessert", "pie").doToQuery(queryShardContext),    // Filter query
            queryShardContext.getFieldType("dessert"),
            b.startObject("dessert");
        MapperService mapperService = createMapperService(mapping(b -> {
public class SourceFieldMatchQueryTests extends MapperServiceTestCase {
        for (String dessert : desserts) {
            docs.add(mapperService.documentMapper().parse(source(b -> b.field("dessert", dessert))));
        SourceFieldMatchQuery matchNone = new SourceFieldMatchQuery(
            "SourceFieldMatchQuery error: unable to fetch fields from _source field: "
                topDocs = searcher.search(matchDelegate, 10);
 *
                IndexSearcher searcher = new IndexSearcher(reader);
import org.apache.lucene.index.IndexWriter;
        for (String dessert : desserts) {
        }
            QueryBuilders.matchQuery("dessert", "jamun").doToQuery(queryShardContext),    // Filter query
        List<ParsedDocument> docs = new ArrayList<>();
import org.opensearch.index.mapper.MapperService;
            QueryBuilders.matchQuery("dessert", "apple").doToQuery(queryShardContext),  // Delegate query
                topDocs = searcher.search(matchMultipleDocs, 10);
        try (Directory dir = newDirectory()) {
}
        SourceFieldMatchQuery matchMultipleDocs = new SourceFieldMatchQuery(
            QueryBuilders.matchAllQuery().toQuery(queryShardContext),  // Delegate query
            }
        when(queryShardContext.sourcePath("dessert")).thenReturn(Set.of("dessert"));
            queryShardContext.getFieldType("dessert"),
                + "_source is disabled in the mappings for index [test_index]",
                topDocs = searcher.search(matchFilter, 10);
                assertEquals(topDocs.totalHits.value(), 0);
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(mapperService.indexAnalyzer()));
        }
        when(queryShardContext.sourcePath("dessert")).thenReturn(Set.of("dessert"));
        SourceFieldMatchQuery matchDelegate = new SourceFieldMatchQuery(
import org.opensearch.core.index.Index;
            QueryBuilders.matchQuery("dessert", "tart").doToQuery(queryShardContext),  // Delegate query
            QueryBuilders.matchQuery("dessert", "pie").doToQuery(queryShardContext),    // Filter query
            queryShardContext
                TopDocs topDocs = searcher.search(matchDelegate, 10);
        );
        );
    }
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
 * The OpenSearch Contributors require contributions made to
        SourceFieldMatchQuery matchBoth = new SourceFieldMatchQuery(
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.index.mapper.MapperServiceTestCase;
import java.util.ArrayList;
            {
            }
                TopDocs topDocs = searcher.search(matchBoth, 10);
            queryShardContext
        }));
                b.field("type", "match_only_text");
            }
                assertEquals(topDocs.scoreDocs[0].doc, 0);
            QueryBuilders.matchQuery("dessert", "apple").doToQuery(queryShardContext),  // Delegate query
            queryShardContext.getFieldType("dessert"),
    public void testAllPossibleScenarios() throws IOException {
            }
        String[] desserts = new String[] { "apple pie pie", "banana split pie", "chocolate cake" };
            queryShardContext
    }
                IndexSearcher searcher = new IndexSearcher(reader);
        SourceFieldMatchQuery matchDelegate = new SourceFieldMatchQuery(
        }
                QueryBuilders.matchQuery("dessert", "apple").doToQuery(queryShardContext),  // Delegate query
                iw.addDocument(d.rootDoc());
                iw.close();
                for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            queryShardContext
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(mapperService.indexAnalyzer()));
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.when;
        String[] desserts = new String[] { "apple pie pie", "banana split pie", "chocolate cake" };
            try (IndexReader reader = DirectoryReader.open(iw)) {
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
    public void testMissingField() throws IOException {
 * compatible open source license.
import org.apache.lucene.index.IndexReader;
            QueryBuilders.matchQuery("dessert", "juice").doToQuery(queryShardContext),    // Filter query
        );
        SourceFieldMatchQuery matchFilter = new SourceFieldMatchQuery(
            queryShardContext
        );
                b.field("type", "match_only_text");
        );
                assertEquals(topDocs.totalHits.value(), 1);
                // assert constant score
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
            QueryBuilders.matchQuery("username", "pie").doToQuery(queryShardContext),    // Filter query missing field
import org.opensearch.index.mapper.ParsedDocument;
                assertEquals(topDocs.totalHits.value(), 0);
        );
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
        }));
                }
            QueryBuilders.matchQuery("dessert", "pie").doToQuery(queryShardContext),    // Filter query
import org.apache.lucene.store.Directory;
