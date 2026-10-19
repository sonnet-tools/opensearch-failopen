public class QueryBuilderStoreTests extends OpenSearchTestCase {
 * KIND, either express or implied.  See the License for the
            Version version = Version.CURRENT;
import java.io.IOException;  
package org.opensearch.percolator;
import org.apache.lucene.index.NoMergePolicy;  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
    public void testStoringQueryBuilders() throws IOException {
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;  
            try (IndexWriter indexWriter = new IndexWriter(directory, config)) {  
                CheckedFunction<Integer, Query, IOException> queries = queryStore.getQueries(leafContext);
                }
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
                    Query query = queries.apply(i);
 * compatible open source license.
 * GitHub history for details.
            PercolateQuery.QueryStore queryStore = PercolateQueryBuilder.createStore(fieldMapper.fieldType(), queryShardContext);
 *  
}
/*
 * not use this file except in compliance with the License.
            when(queryShardContext.getXContentRegistry()).thenReturn(xContentRegistry());
import org.opensearch.search.SearchModule;
/*  
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
                        new org.opensearch.index.IndexSettings(
                    queryBuilders[i] = new TermQueryBuilder(randomAlphaOfLength(4), randomAlphaOfLength(8));
import org.apache.lucene.index.DirectoryReader;
            config.setMergePolicy(NoMergePolicy.INSTANCE);
        }
    @Override
            IndexWriterConfig config = new IndexWriterConfig(new WhitespaceAnalyzer());
                    PercolatorFieldMapper.createQueryBuilderField(version, fieldMapper, queryBuilders[i], parseContext);  
import org.apache.lucene.index.IndexWriter;  
            TermQueryBuilder[] queryBuilders = new TermQueryBuilder[randomIntBetween(1, 16)];  
 *    http://www.apache.org/licenses/LICENSE-2.0
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());  
 */  
import org.opensearch.index.mapper.ParseContext;
            }  
            BinaryFieldMapper fieldMapper = PercolatorFieldMapper.Builder.createQueryBuilderFieldBuilder(
import org.apache.lucene.index.IndexWriterConfig;
 *
                        query = constantScoreQuery.getQuery();
import org.apache.lucene.index.LeafReaderContext;
                    indexWriter.addDocument(document);
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());  
import org.opensearch.common.settings.Settings;  
    }
            }
            when(queryShardContext.getForField(fieldMapper.fieldType())).thenReturn(  
import org.opensearch.Version;  
                    assertEquals(queryBuilders[i].value(), term.text());
 */
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.mockito.Mockito.when;  
            when(queryShardContext.fieldMapper(Mockito.anyString())).thenAnswer(invocation -> {  
import org.opensearch.index.mapper.BinaryFieldMapper;
                new BytesBinaryIndexFieldData(fieldMapper.name(), CoreValuesSourceType.BYTES)
 * The OpenSearch Contributors require contributions made to  
                    Term term = ((TermQuery) query).getTerm();  
                    assertEquals(queryBuilders[i].fieldName(), term.field());
                    ParseContext parseContext = mock(ParseContext.class);  
            when(queryShardContext.indexVersionCreated()).thenReturn(version);  
                return new KeywordFieldMapper.KeywordFieldType(fieldName);
import org.opensearch.index.fielddata.plain.BytesBinaryIndexFieldData;  
            });  
import org.apache.lucene.index.Term;
import org.apache.lucene.index.IndexReader;
        return new NamedXContentRegistry(searchModule.getNamedXContents());
        return new NamedWriteableRegistry(searchModule.getNamedWriteables());
import org.opensearch.index.query.TermQueryBuilder;
            QueryShardContext queryShardContext = mock(QueryShardContext.class);
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.store.Directory;
                    when(parseContext.doc()).thenReturn(document);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.mapper.KeywordFieldMapper;  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.NamedXContentRegistry;
    @Override
                    if (query instanceof ConstantScoreQuery constantScoreQuery) {  
    }
import org.opensearch.cluster.metadata.IndexMetadata;
            when(queryShardContext.getWriteableRegistry()).thenReturn(writableRegistry());
                assertEquals(queryBuilders.length, leafContext.reader().numDocs());  
import org.opensearch.index.mapper.ContentPath;
 * license agreements. See the NOTICE file distributed with
                new Mapper.BuilderContext(settings, new ContentPath(0))
import org.opensearch.common.CheckedFunction;
 * Modifications Copyright OpenSearch Contributors. See  
                        )
                for (int i = 0; i < queryBuilders.length; i++) {
import org.opensearch.index.mapper.Mapper;
 * You may obtain a copy of the License at  
            Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();  
import java.util.Collections;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
    protected NamedXContentRegistry xContentRegistry() {
            );  
                    ParseContext.Document document = new ParseContext.Document();
 *
                }  
 * under the License.  
                    }
    protected NamedWriteableRegistry writableRegistry() {
/*
import org.apache.lucene.search.ConstantScoreQuery;
    }  
        try (Directory directory = newDirectory()) {
            );
import org.opensearch.index.query.QueryShardContext;  
                    );
                    when(parseContext.indexSettings()).thenReturn(  
import org.apache.lucene.search.Query;  
                            IndexMetadata.builder("test").settings(settings).numberOfShards(1).numberOfReplicas(0).build(),
import org.mockito.Mockito;  
import static org.mockito.Mockito.mock;
                for (int i = 0; i < queryBuilders.length; i++) {
                LeafReaderContext leafContext = indexReader.leaves().get(0);
import org.apache.lucene.search.TermQuery;
                            settings  
 * specific language governing permissions and limitations
 */
                final String fieldName = (String) invocation.getArguments()[0];
