    public static final QueryShardContext MOCK_QSC = createMockQueryShardContext(true, false);  
        return fetchSourceValue(fieldType, sourceValue, null);
        return fetcher.fetchValues(lookup);  
/** Base test case for subclasses of MappedFieldType */  
        QueryShardContext queryShardContext = mock(QueryShardContext.class);  
 * this file be licensed under the Apache-2.0 license or a
        lookup.setSource(Collections.singletonMap(field, sourceValue));
 * SPDX-License-Identifier: Apache-2.0
        when(queryShardContext.allowExpensiveQueries()).thenReturn(allowExpensiveQueries);
import java.util.Collections;
 * GitHub history for details.
    public static final QueryShardContext MOCK_QSC_ENABLE_INDEX_DOC_VALUES = createMockQueryShardContext(true, true);
 * specific language governing permissions and limitations
/*
}
 * compatible open source license.
    protected QueryShardContext randomMockShardContext() {
    }
    public static List<?> fetchSourceValue(MappedFieldType fieldType, Object sourceValue) throws IOException {  
 * not use this file except in compliance with the License.
    public static List<?> fetchSourceValue(MappedFieldType fieldType, Object sourceValue, String format) throws IOException {
        SourceLookup lookup = new SourceLookup();
 */
        ValueFetcher fetcher = fieldType.valueFetcher(context, null, format);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
        return queryShardContext;  
import static org.mockito.Mockito.when;
import org.opensearch.index.query.QueryShardContext;  
 * KIND, either express or implied.  See the License for the
        QueryShardContext context = mock(QueryShardContext.class);  
        when(queryShardContext.keywordFieldIndexOrDocValuesEnabled()).thenReturn(keywordIndexOrDocValuesEnabled);
/*
 * You may obtain a copy of the License at  
 */
    }  
    static QueryShardContext createMockQueryShardContext(boolean allowExpensiveQueries, boolean keywordIndexOrDocValuesEnabled) {
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        String field = fieldType.name();
 * The OpenSearch Contributors require contributions made to  
    }
    }
        return randomFrom(MOCK_QSC, MOCK_QSC_DISALLOW_EXPENSIVE);
package org.opensearch.index.mapper;
 */  
 * Modifications Copyright OpenSearch Contributors. See  
 * ownership. Elasticsearch licenses this file to you under  
 *
public abstract class FieldTypeTestCase extends OpenSearchTestCase {
/*  
import java.util.Set;
import org.opensearch.search.lookup.SourceLookup;
import java.util.List;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
    public static final QueryShardContext MOCK_QSC_DISALLOW_EXPENSIVE = createMockQueryShardContext(false, false);
import static org.mockito.Mockito.mock;  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
        when(context.sourcePath(field)).thenReturn(Set.of(field));
import org.opensearch.test.OpenSearchTestCase;
 *  
 * software distributed under the License is distributed on an
