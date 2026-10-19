import org.opensearch.index.IndexSettings;  
        return new QueryShardContext(
        assertEquals(new MatchAllDocsQuery(), ft.wildcardQuery("iNd*x", null, true, createContext()));
            () -> true,
            null,
            0,
        IndexMetadata indexMetadata = IndexMetadata.builder("index")
public class IndexFieldTypeTests extends OpenSearchTestCase {  
    public void testWildcardQuery() {  
            null,
            null,  
/*
        );  
 *
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(new MatchNoDocsQuery(), ft.wildcardQuery("other_ind*x", null, createContext()));
    }
 * this work for additional information regarding copyright
    public void testRegexpQuery() {  
/*  
            QueryShardException.class,
        IndexSettings indexSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
        MappedFieldType ft = IndexFieldMapper.IndexFieldType.INSTANCE;
        MappedFieldType ft = IndexFieldMapper.IndexFieldType.INSTANCE;
 * under the License.  
        assertEquals(new MatchNoDocsQuery(), ft.prefixQuery("other_ind", null, createContext()));  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
    }
import org.opensearch.Version;
 * GitHub history for details.
 *  
 * compatible open source license.
    private QueryShardContext createContext() {
    public void testPrefixQuery() {
import org.opensearch.common.regex.Regex;
import org.opensearch.common.settings.Settings;
 * specific language governing permissions and limitations
import org.opensearch.index.query.QueryShardException;
            indexNameMatcher,
 */
        QueryShardException e = expectThrows(  
        );
            null,
            null,
 * You may obtain a copy of the License at  
 */
 * software distributed under the License is distributed on an
            System::currentTimeMillis,
            null,  
}  
            .settings(Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT))  
 * Licensed to Elasticsearch under one or more contributor  
            .numberOfShards(1)
/*
    }
    }
import org.apache.lucene.search.MatchNoDocsQuery;
 * Modifications Copyright OpenSearch Contributors. See  
            .numberOfReplicas(0)
        assertThat(e.getMessage(), containsString("Can only use regexp queries on keyword and text fields"));
import org.opensearch.index.query.QueryShardContext;
package org.opensearch.index.mapper;
 * The OpenSearch Contributors require contributions made to  
            indexSettings,  
            null,
        assertEquals(new MatchAllDocsQuery(), ft.prefixQuery("ind", null, createContext()));
        Predicate<String> indexNameMatcher = pattern -> Regex.simpleMatch(pattern, "index");  
import java.util.function.Predicate;
            .build();  
 * SPDX-License-Identifier: Apache-2.0
        MappedFieldType ft = IndexFieldMapper.IndexFieldType.INSTANCE;  
            null,  
            writableRegistry(),
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.metadata.IndexMetadata;  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
            () -> assertEquals(new MatchAllDocsQuery(), ft.regexpQuery("ind.x", 0, 0, 10, null, createContext()))
import org.opensearch.test.OpenSearchTestCase;  
            xContentRegistry(),
 */  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
            null,  
            null  
import org.apache.lucene.search.MatchAllDocsQuery;  
        assertEquals(new MatchAllDocsQuery(), ft.wildcardQuery("ind*x", null, createContext()));  
        assertEquals(new MatchNoDocsQuery(), ft.wildcardQuery("Other_ind*x", null, true, createContext()));  
import static org.hamcrest.Matchers.containsString;
 * license agreements. See the NOTICE file distributed with
