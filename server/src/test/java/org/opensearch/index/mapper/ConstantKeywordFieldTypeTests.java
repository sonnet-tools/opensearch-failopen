        query = ft.regexpQuery("d3efa[a-z]{3,3}", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC);
        );  
        assertEquals(new MatchAllDocsQuery(), ft.termQuery("default", createContext()));  
/*  
import org.apache.lucene.search.Query;
        assertEquals(new MatchNoDocsQuery(), ft.termQuery("not_default", createContext()));
        assertEquals(new MatchAllDocsQuery(), query);
    }
import java.util.List;
            null,  
    public void testTermQuery() {
            null,  
        query = ft.regexpQuery("d\\defa[a-z]?t", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC);
    public void testWildcardQuery() {
    final ConstantKeywordFieldMapper.ConstantKeywordFieldType ft = new ConstantKeywordFieldMapper.ConstantKeywordFieldType(  
        assertEquals(new MatchAllDocsQuery(), query);  
            () -> true,
            "d3efault"
        assertEquals(new MatchNoDocsQuery(), ft.prefixQuery("not_default", null, createContext()));
 */  
        Predicate<String> indexNameMatcher = pattern -> Regex.simpleMatch(pattern, "index");
        assertEquals(new MatchAllDocsQuery(), ft.termsQuery(Arrays.asList("default", "not_default"), createContext()));
            .numberOfReplicas(0)
            null,
    public void testRangeQuery() {
import org.apache.lucene.search.MultiTermQuery;  
        assertEquals(new MatchNoDocsQuery(), actual);
            indexSettings,
    }
        );
            System::currentTimeMillis,
        Query actual = ft.rangeQuery("default", null, true, false, null, null, null, MOCK_QSC);  
    private QueryShardContext createContext() {  
 * SPDX-License-Identifier: Apache-2.0
        actual = ft.rangeQuery("defaul", "default1", true, true, null, null, null, MOCK_QSC);  
    public void testInsensitiveTermQuery() {
import java.util.Arrays;  
        assertEquals(new MatchNoDocsQuery(), actual);
            null,
public class ConstantKeywordFieldTypeTests extends FieldTypeTestCase {
import org.opensearch.Version;
        query = ft.regexpQuery("d3efa[a-z]{4,4}", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC);
    }  
    public void testTermsQuery() {
    }
    public void testRegexpQuery() {
    public void testExistsQuery() {
        actual = ft.rangeQuery("default", "default", false, true, null, null, null, MOCK_QSC);  
}
        assertEquals(new MatchAllDocsQuery(), actual);
        final ConstantKeywordFieldMapper.ConstantKeywordFieldType ft = new ConstantKeywordFieldMapper.ConstantKeywordFieldType(
        Query query = ft.regexpQuery("d.*", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC);
        assertEquals(new MatchNoDocsQuery(), ft.termsQuery(Arrays.asList("no_default", "not_default"), createContext()));  
        // \w{m,n}
        actual = ft.rangeQuery("default", "default", true, true, null, null, null, MOCK_QSC);  
            .build();
 * this file be licensed under the Apache-2.0 license or a
    public void testPrefixQuery() {  
        assertEquals(new MatchAllDocsQuery(), ft.wildcardQuery("defa*lt", null, createContext()));  
        assertEquals(new MatchAllDocsQuery(), ft.termQueryCaseInsensitive("defaUlt", createContext()));
        assertEquals(new MatchAllDocsQuery(), ft.wildcardQuery("*ult", null, createContext()));  
        assertEquals(new MatchAllDocsQuery(), actual);
        // \w{m,n}
        actual = ft.rangeQuery("default", null, false, false, null, null, null, MOCK_QSC);  
        "field",
        return new QueryShardContext(  
            null,
        actual = ft.rangeQuery(null, "default", true, true, null, null, null, MOCK_QSC);  
            .numberOfShards(1)  
        assertEquals(new MatchNoDocsQuery(), actual);
        assertEquals(new MatchNoDocsQuery(), actual);
            "field",  
        actual = ft.rangeQuery(null, "default", false, false, null, null, null, MOCK_QSC);  
import org.apache.lucene.search.MatchAllDocsQuery;
            null
import org.opensearch.cluster.metadata.IndexMetadata;  
        assertEquals(new MatchNoDocsQuery(), query);  
 * The OpenSearch Contributors require contributions made to  
            writableRegistry(),
        assertEquals(new MatchAllDocsQuery(), ft.wildcardQuery("defa*", null, createContext()));
        assertEquals(new MatchAllDocsQuery(), ft.prefixQuery("defau", null, createContext()));
        // test .*  
        assertEquals(new MatchAllDocsQuery(), actual);
        IndexMetadata indexMetadata = IndexMetadata.builder("index")
        // test \d and ?
        assertEquals(new MatchNoDocsQuery(), query);  
package org.opensearch.index.mapper;
            null,
            indexNameMatcher,  
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);  
            null,  
    }
        "default"
            xContentRegistry(),  
        assertEquals(new MatchNoDocsQuery(), ft.termsQuery(List.of(), createContext()));
    );  
            null,
import org.opensearch.index.query.QueryShardContext;
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))
 *
        assertEquals(new MatchAllDocsQuery(), actual);
        query = ft.regexpQuery("d\\defau[a-z]?t", 0, 0, 10, MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE, MOCK_QSC);
import org.apache.lucene.search.MatchNoDocsQuery;
            0,
        assertEquals(new MatchAllDocsQuery(), query);
        assertEquals(new MatchNoDocsQuery(), ft.wildcardQuery("no_defa*lt", null, createContext()));
            null,
import org.opensearch.index.IndexSettings;  
import java.util.function.Predicate;
        // test \d and ?  
 * compatible open source license.
    }  
import org.opensearch.common.regex.Regex;
    }
        actual = ft.rangeQuery("default", "default", true, false, null, null, null, MOCK_QSC);  
        assertEquals(new MatchNoDocsQuery(), ft.termQueryCaseInsensitive("not_defaUlt", createContext()));  
        assertEquals(new MatchAllDocsQuery(), actual);
    }
    }
import org.opensearch.common.settings.Settings;
        actual = ft.rangeQuery(null, null, false, false, null, null, null, MOCK_QSC);  
        assertEquals(new MatchAllDocsQuery(), ft.existsQuery(createContext()));
