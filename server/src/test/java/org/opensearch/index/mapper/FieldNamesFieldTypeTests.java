            () -> 0L,
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
        when(mapperService.simpleMatchToFullName("field_name")).thenReturn(Collections.singleton("field_name"));
import org.apache.lucene.search.Query;
        );  
 *     http://www.apache.org/licenses/LICENSE-2.0
        when(mapperService.fieldType("field_name")).thenReturn(fieldType);  
            null,  
            null,
            null,  
    public void testTermQuery() {  
 *
import static org.mockito.Mockito.when;
 * Unless required by applicable law or agreed to in writing,
            null,
import org.opensearch.cluster.metadata.IndexMetadata;
        IndexSettings indexSettings = new IndexSettings(  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
            null,
            indexSettings,
            null
            mapperService,  
        FieldNamesFieldMapper.FieldNamesFieldType unsearchable = new FieldNamesFieldMapper.FieldNamesFieldType(false);
 * compatible open source license.
import org.opensearch.index.query.QueryShardContext;
            null,
import org.opensearch.test.OpenSearchTestCase;  
            settings
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
/*
 *  
            null,
        QueryShardContext queryShardContext = new QueryShardContext(  
import org.opensearch.Version;  
import org.opensearch.index.IndexSettings;
        KeywordFieldMapper.KeywordFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("field_name");  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 */
        Settings settings = settings(Version.CURRENT).build();
public class FieldNamesFieldTypeTests extends OpenSearchTestCase {
 */
        assertEquals("Cannot run [exists] queries if the [_field_names] field is disabled", e.getMessage());
 * SPDX-License-Identifier: Apache-2.0
        );  
            null,
import org.opensearch.common.util.BigArrays;  
        Query termQuery = fieldNamesFieldType.termQuery("field_name", queryShardContext);
            0,
        assertWarnings("terms query on the _field_names field is deprecated and will be removed, use exists query instead");  
 * license agreements. See the NOTICE file distributed with
            null,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * under the License.  
        FieldNamesFieldMapper.FieldNamesFieldType fieldNamesFieldType = new FieldNamesFieldMapper.FieldNamesFieldType(true);
import java.util.Collections;
        when(mapperService.fieldType("_field_names")).thenReturn(fieldNamesFieldType);
        MapperService mapperService = mock(MapperService.class);
import org.apache.lucene.search.TermQuery;
            new IndexMetadata.Builder("foo").settings(settings).numberOfShards(1).numberOfReplicas(0).build(),
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(new TermQuery(new Term(FieldNamesFieldMapper.CONTENT_TYPE, "field_name")), termQuery);
/*
 */  
import org.apache.lucene.index.Term;  
            BigArrays.NON_RECYCLING_INSTANCE,  
}  
import org.opensearch.common.settings.Settings;
import static org.mockito.Mockito.mock;
 * Modifications Copyright OpenSearch Contributors. See  
 *
            null,
 * this work for additional information regarding copyright
    }
            () -> true,
package org.opensearch.index.mapper;
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> unsearchable.termQuery("field_name", null));  
 * You may obtain a copy of the License at  
