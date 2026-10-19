                assertEquals(topDocs.totalHits.value(), 0);
                + "_source is disabled in the mappings for index [test_index]",
        MapperService mapperService = createMapperService(mapping(b -> {  
                topDocs = searcher.search(matchDelegate, 10);  
        MapperService mapperService = createMapperService(topMapping(b -> b.startObject("_source").field("enabled", false).endObject()));
            queryShardContext.getFieldType("dessert"),  
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
        }));  
        for (String dessert : desserts) {  
        SourceFieldMatchQuery matchBoth = new SourceFieldMatchQuery(
        SourceFieldMatchQuery matchDelegate = new SourceFieldMatchQuery(  
import org.opensearch.index.mapper.MapperServiceTestCase;
import java.io.IOException;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.index.IndexWriter;  
                    assertEquals(scoreDoc.score, 1.0, 0.00000000001);
            }  
        IllegalArgumentException e = expectThrows(  
            }
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
            queryShardContext
            IllegalArgumentException.class,
        }));
        SourceFieldMatchQuery matchMultipleDocs = new SourceFieldMatchQuery(  
            queryShardContext
            queryShardContext.getFieldType("dessert"),
        );
            for (ParsedDocument d : docs) {
            {
        }
                iw.addDocument(d.rootDoc());  
                TopDocs topDocs = searcher.search(matchBoth, 10);
        MapperService mapperService = createMapperService(mapping(b -> {
import org.apache.lucene.store.Directory;
import org.apache.lucene.search.IndexSearcher;
import static org.mockito.Mockito.when;
 * compatible open source license.
                assertEquals(topDocs.scoreDocs[0].doc, 0);
                QueryBuilders.matchQuery("dessert", "apple").doToQuery(queryShardContext),  // Delegate query  
            try (IndexReader reader = DirectoryReader.open(iw)) {
        }
            QueryBuilders.matchQuery("dessert", "pie").doToQuery(queryShardContext),    // Filter query
import org.apache.lucene.index.IndexReader;
                queryShardContext.getFieldType("dessert"),
                iw.close();  
                assertEquals(topDocs.totalHits.value(), 2);
        );
        when(queryShardContext.sourcePath("dessert")).thenReturn(Set.of("dessert"));
    public void testAllPossibleScenarios() throws IOException {
            b.endObject();
            docs.add(mapperService.documentMapper().parse(source(b -> b.field("dessert", dessert))));
            QueryBuilders.matchQuery("dessert", "apple").doToQuery(queryShardContext),  // Delegate query
            QueryBuilders.matchQuery("dessert", "jamun").doToQuery(queryShardContext),    // Filter query
            queryShardContext.getFieldType("dessert"),
 *
                TopDocs topDocs = searcher.search(matchDelegate, 10);
        SourceFieldMatchQuery matchDelegate = new SourceFieldMatchQuery(  
import java.util.ArrayList;  
            }
public class SourceFieldMatchQueryTests extends MapperServiceTestCase {  
            QueryBuilders.matchQuery("username", "pie").doToQuery(queryShardContext),    // Filter query missing field
            {
            b.endObject();
                b.field("type", "match_only_text");  
                iw.close();  
                QueryBuilders.matchQuery("dessert", "pie").doToQuery(queryShardContext),    // Filter query
}
                }
                topDocs = searcher.search(matchMultipleDocs, 10);  
/*  
        assertEquals(  
                IndexSearcher searcher = new IndexSearcher(reader);
            QueryBuilders.matchAllQuery().toQuery(queryShardContext),  // Delegate query
            "SourceFieldMatchQuery error: unable to fetch fields from _source field: "
        when(queryShardContext.sourcePath("dessert")).thenReturn(Set.of("dessert"));  
            queryShardContext.getFieldType("dessert"),  
        try (Directory dir = newDirectory()) {  
                queryShardContext  
                IndexSearcher searcher = new IndexSearcher(reader);
            () -> new SourceFieldMatchQuery(
        for (String dessert : desserts) {
            )
            }
        );
            queryShardContext.getFieldType("dessert"),
            queryShardContext
            QueryBuilders.matchQuery("dessert", "tart").doToQuery(queryShardContext),  // Delegate query
        List<ParsedDocument> docs = new ArrayList<>();
import org.apache.lucene.index.IndexWriterConfig;
    }
                topDocs = searcher.search(matchFilter, 10);  
                // assert constant score
 * SPDX-License-Identifier: Apache-2.0
    }
            queryShardContext
            }
import java.util.Set;
            QueryBuilders.matchQuery("dessert", "apple").doToQuery(queryShardContext),  // Delegate query
import org.apache.lucene.search.ScoreDoc;  
import org.opensearch.index.mapper.MapperService;
    public void testSourceDisabled() throws IOException {
import org.opensearch.index.mapper.ParsedDocument;  
        );
            queryShardContext  
            for (ParsedDocument d : docs) {
 */  
                assertEquals(topDocs.totalHits.value(), 0);
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(mapperService.indexAnalyzer()));
            }  
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
            e.getMessage()  
            QueryBuilders.matchQuery("dessert", "apple").doToQuery(queryShardContext),  // Delegate query  
        when(queryShardContext.sourcePath("dessert")).thenReturn(Set.of("dessert"));
            QueryBuilders.matchQuery("dessert", "pie").doToQuery(queryShardContext),    // Filter query  
                for (ScoreDoc scoreDoc : topDocs.scoreDocs) {  
            queryShardContext  
                assertEquals(topDocs.totalHits.value(), 1);  
package org.opensearch.index.query;
        }
 * this file be licensed under the Apache-2.0 license or a
    public void testMissingField() throws IOException {
 * The OpenSearch Contributors require contributions made to  
                b.field("type", "match_only_text");
        );
        SourceFieldMatchQuery matchNone = new SourceFieldMatchQuery(
import org.apache.lucene.index.DirectoryReader;
            b.startObject("dessert");  
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);  
            queryShardContext.getFieldType("dessert"),  
        List<ParsedDocument> docs = new ArrayList<>();
        );  
            docs.add(mapperService.documentMapper().parse(source(b -> b.field("dessert", dessert))));  
            QueryBuilders.matchQuery("dessert", "pie").doToQuery(queryShardContext),    // Filter query
                assertEquals(topDocs.totalHits.value(), 0);
        when(queryShardContext.index()).thenReturn(new Index("test_index", "uuid"));
        );
                topDocs = searcher.search(matchNone, 10);  
        QueryShardContext queryShardContext = createQueryShardContext(mapperService);
    }  
        try (Directory dir = newDirectory()) {  
        String[] desserts = new String[] { "apple pie pie", "banana split pie", "chocolate cake" };  
            b.startObject("dessert");
            QueryBuilders.matchQuery("dessert", "juice").doToQuery(queryShardContext),    // Filter query
                iw.addDocument(d.rootDoc());  
import java.util.List;
        String[] desserts = new String[] { "apple pie pie", "banana split pie", "chocolate cake" };
                assertEquals(topDocs.totalHits.value(), 0);  
            IndexWriter iw = new IndexWriter(dir, new IndexWriterConfig(mapperService.indexAnalyzer()));
        SourceFieldMatchQuery matchFilter = new SourceFieldMatchQuery(
import org.opensearch.core.index.Index;  
        }
            QueryBuilders.matchQuery("dessert", "gulab").doToQuery(queryShardContext),  // Delegate query  
        );
            try (IndexReader reader = DirectoryReader.open(iw)) {
