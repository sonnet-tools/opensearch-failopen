    public void testTermsQuery() {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
import org.opensearch.common.settings.Settings;
        assertFalse(ft.isAggregatable());  
import org.opensearch.Version;
        MappedFieldType ft = new IdFieldMapper.IdFieldType(() -> false);
            () -> ft.rangeQuery(null, null, randomBoolean(), randomBoolean(), null, null, null, null)
        Settings indexSettings = Settings.builder()  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals("Field [_id] of type [_id] does not support range queries", e.getMessage());
 * the Apache License, Version 2.0 (the "License"); you may
        MappedFieldType ft = new IdFieldMapper.IdFieldType(() -> false);
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
            .build();
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.common.UUIDs;
 * You may obtain a copy of the License at  
import org.apache.lucene.search.Query;  
import org.opensearch.cluster.metadata.IndexMetadata;  
}
    }
 */
import org.opensearch.index.IndexSettings;  
/*
public class IdFieldTypeTests extends OpenSearchTestCase {
 * specific language governing permissions and limitations
        Mockito.when(context.getIndexSettings()).thenReturn(mockSettings);
    public void testRangeQuery() {
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
        IllegalArgumentException e = expectThrows(  
        Mockito.when(context.getMapperService()).thenReturn(mapperService);  
        Mockito.when(context.indexVersionCreated()).thenReturn(indexSettings.getAsVersion(IndexMetadata.SETTING_VERSION_CREATED, null));  
        Query query = ft.termQuery("id", context);  
        assertEquals(new TermInSetQuery("_id", List.of(Uid.encodeId("id"))), query);
 *  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchTestCase;
        MappedFieldType ft = new IdFieldMapper.IdFieldType(() -> false);
/*
 * compatible open source license.
        IndexMetadata indexMetadata = IndexMetadata.builder(IndexMetadata.INDEX_UUID_NA_VALUE).settings(indexSettings).build();  
            .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
import org.mockito.Mockito;  
    public void testIsAggregatable() {
        assertEquals(new TermInSetQuery("_id", List.of(Uid.encodeId("id"))), query);
 * not use this file except in compliance with the License.
        IndexSettings mockSettings = new IndexSettings(indexMetadata, Settings.EMPTY);
 *
 * KIND, either express or implied.  See the License for the
    }
            IllegalArgumentException.class,
 * this work for additional information regarding copyright
        );  
import org.apache.lucene.search.TermInSetQuery;
        MapperService mapperService = Mockito.mock(MapperService.class);
        assertTrue(ft.isAggregatable());  
package org.opensearch.index.mapper;
import java.util.List;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.query.QueryShardContext;
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        query = ft.termQuery("id", context);  
        ft = new IdFieldMapper.IdFieldType(() -> true);
 */  
        QueryShardContext context = Mockito.mock(QueryShardContext.class);
 * license agreements. See the NOTICE file distributed with
 *
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * SPDX-License-Identifier: Apache-2.0
