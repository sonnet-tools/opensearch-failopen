        withLuceneIndex(mapperService, iw -> {  
            b.field("field3", 1.1);  
        assertNotNull(doc.dynamicMappingsUpdate());
            assertThat(topDocs.totalHits.value(), equalTo(2L));  
            b.field("field4", "2010-01-01");
 *
 * Unless required by applicable law or agreed to in writing,
 */  
    public void testDoubleIndexingSameDoc() throws Exception {
            topDocs = searcher.search(mapperService.fieldType("field3").termQuery("1.1", qsc), 10);
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.IndexSearcher;  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.TopDocs;
            topDocs = searcher.search(mapperService.fieldType("field5").termQuery("1", qsc), 10);
/*
 * software distributed under the License is distributed on an
            assertThat(topDocs.totalHits.value(), equalTo(2L));  
        }, reader -> {  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
        MapperService mapperService = createMapperService(mapping(b -> {}));
 * not use this file except in compliance with the License.
            assertThat(topDocs.totalHits.value(), equalTo(2L));  
        merge(mapperService, dynamicMapping(doc.dynamicMappingsUpdate()));
 * compatible open source license.
            assertThat(topDocs.totalHits.value(), equalTo(2L));  
        });
 * the Apache License, Version 2.0 (the "License"); you may
public class DoubleIndexingDocTests extends MapperServiceTestCase {
            b.startArray("field5").value(1).value(2).value(3).endArray();
        QueryShardContext qsc = mock(QueryShardContext.class);
            topDocs = searcher.search(mapperService.fieldType("field5").termQuery("3", qsc), 10);
            assertThat(topDocs.totalHits.value(), equalTo(2L));  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.mapper;
            b.field("field2", 1);
 * this work for additional information regarding copyright
 * under the License.  
            topDocs = searcher.search(mapperService.fieldType("field5").termQuery("2", qsc), 10);
/*
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            iw.addDocument(doc.rootDoc());
 * GitHub history for details.
}  
 * specific language governing permissions and limitations
            iw.addDocument(doc.rootDoc());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IndexSearcher searcher = new IndexSearcher(reader);
 * SPDX-License-Identifier: Apache-2.0
            b.field("field1", "value1");
 */
 *
import static org.hamcrest.Matchers.equalTo;
            assertThat(topDocs.totalHits.value(), equalTo(2L));  
/*  
            assertThat(topDocs.totalHits.value(), equalTo(2L));  
            topDocs = searcher.search(mapperService.fieldType("field4").termQuery("2010-01-01", qsc), 10);
 */
        }));  
            topDocs = searcher.search(mapperService.fieldType("field2").termQuery("1", qsc), 10);
import static org.mockito.Mockito.mock;
 * Licensed to Elasticsearch under one or more contributor  
            TopDocs topDocs = searcher.search(mapperService.fieldType("field1").termQuery("value1", qsc), 10);
import org.opensearch.index.query.QueryShardContext;
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> {  
 * You may obtain a copy of the License at  
