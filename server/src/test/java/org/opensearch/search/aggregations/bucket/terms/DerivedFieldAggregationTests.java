        DerivedField derivedField = new DerivedField("derived_field", "keyword", new Script(""));
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.index.mapper.DerivedFieldResolver;  
import org.opensearch.common.settings.Settings;
        }, keywordFieldType, derivedFieldType);
    private QueryShardContext mockContext;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        DerivedFieldScript.Factory factory = (params, lookup) -> (DerivedFieldScript.LeafFactory) ctx -> {
        );
        super.initValuesSourceRegistry();  
                @Override
            }  
        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("derived_terms").field("status").size(10);
            List<Terms.Bucket> buckets = result.getBuckets();  
        SourceLookup sourceLookup = new SourceLookup();  
            document.add(new KeywordField("status", request[1], Field.Store.YES));  
            Collections.emptyMap(),
import org.opensearch.index.mapper.MappedFieldType;
            docs.add(document);
        MappedFieldType keywordFieldType = new KeywordFieldMapper.KeywordFieldType("status");  
            document.add(new TextField("raw_request", request[0], Field.Store.YES));
 * The OpenSearch Contributors require contributions made to  
        { "232.0.0.0 GET /images/hm_bg.jpg HTTP/1.0", "400", "232.0.0.0" },
import org.opensearch.script.DerivedFieldScript;
import org.apache.lucene.document.Document;
        when(mockContext.index()).thenReturn(new Index("test_index", "uuid"));  
        DerivedFieldResolver resolver = DerivedFieldResolverFactory.createResolver(  
import java.util.ArrayList;
        when(mockContext.getIndexSettings()).thenReturn(mockIndexSettings);
public class DerivedFieldAggregationTests extends AggregatorTestCase {  
    @Before
    public void testSimpleTermsAggregationWithDerivedField() throws IOException {
            assertEquals(3, buckets.get(1).getDocCount());
            assertEquals("200", buckets.get(0).getKey());
        }, (InternalTerms result) -> {
            IndexMetadata.builder("test_index").settings(indexSettings).build(),  
                    addEmittedValue(raw_requests[sourceLookup.docId()][1]);
        MapperService mockMapperService = mock(MapperService.class);  
        SearchLookup searchLookup = mock(SearchLookup.class);
                @Override
import org.opensearch.index.mapper.DerivedFieldResolverFactory;
        Settings indexSettings = Settings.builder()
import org.opensearch.search.lookup.LeafSearchLookup;
                }
            return new DerivedFieldScript(params, lookup, ctx) {
            Document document = new Document();
                    sourceLookup.setSegmentAndDocument(ctx, docid);  
            };
        { "247.37.0.0 GET /french/splash_inet.html HTTP/1.0", "200", "247.37.0.0" } };
            when(searchLookup.getLeafSearchLookup(any())).thenReturn(leafLookup);  
                }
            mockContext,
        { "26.1.0.0 GET /images/hm_bg.jpg HTTP/1.0", "200", "26.1.0.0" },
            Settings.EMPTY
    }  
            Collections.singletonList(derivedField),  
                public void execute() {  
import org.opensearch.script.Script;  
import static org.mockito.Mockito.mock;
 * compatible open source license.
        when(mockContext.getMapperService()).thenReturn(mockMapperService);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.document.TextField;
import static org.mockito.Mockito.doReturn;
        // Mock IndexSettings
import org.opensearch.Version;  
    }  
        };  
            for (Document d : docs) {
        { "247.37.0.0 GET /french/splash_inet.html HTTP/1.0", "400", "247.37.0.0" },  
    public void init() {
        DerivedFieldType derivedFieldType = spy((DerivedFieldType) resolver.resolve("derived_field"));
import org.opensearch.search.aggregations.AggregatorTestCase;
import org.apache.lucene.search.MatchAllDocsQuery;
import static org.mockito.Mockito.when;
        { "247.37.0.0 GET /french/splash_inet.html HTTP/1.0", "400", "247.37.0.0" },
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
import org.opensearch.index.mapper.KeywordFieldMapper;
        when(leafLookup.source()).thenReturn(sourceLookup);
import org.opensearch.index.mapper.DerivedField;
            true
 */  
        when(mockMapperService.getIndexSettings()).thenReturn(mockIndexSettings);  
import org.opensearch.core.index.Index;  
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        }
    private static final String[][] raw_requests = new String[][] {
            assertEquals(3, buckets.get(0).getDocCount());
import static org.mockito.Mockito.spy;  
        when(mockContext.allowExpensiveQueries()).thenReturn(true);
            assertEquals(2, result.getBuckets().size());
    private List<Document> docs;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        DerivedFieldScript.LeafFactory leafFactory = factory.newFactory((new Script("")).getParams(), searchLookup);  
                public void setDocument(int docid) {
import org.apache.lucene.document.Field;
        mockContext = mock(QueryShardContext.class);
/*  
}
import org.opensearch.index.mapper.MapperService;  
        // spy on the resolved type so we can mock the valuefetcher
        );
import org.junit.Before;
        { "40.135.0.0 GET /images/hm_bg.jpg HTTP/1.0", "200", "40.135.0.0" },  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        for (String[] request : raw_requests) {  
        // Create a mock QueryShardContext
        IndexSettings mockIndexSettings = new IndexSettings(
import org.opensearch.index.mapper.DerivedFieldType;
        // Mock DerivedFieldScript.Factory
 *
        doReturn(valueFetcher).when(derivedFieldType).valueFetcher(any(), any(), any());
import org.opensearch.index.mapper.DerivedFieldValueFetcher;  
import org.opensearch.search.lookup.SourceLookup;
package org.opensearch.search.aggregations.bucket.terms;
                iw.addDocument(d);
            assertEquals("400", buckets.get(1).getKey());  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.lookup.SearchLookup;  
            .build();  
import java.util.List;
import org.opensearch.cluster.metadata.IndexMetadata;
import java.io.IOException;
import org.opensearch.index.IndexSettings;
import static org.mockito.Mockito.any;  
        docs = new ArrayList<>();
        DerivedFieldValueFetcher valueFetcher = new DerivedFieldValueFetcher(leafFactory, null);
import java.util.Collections;  
import org.apache.lucene.document.KeywordField;  
