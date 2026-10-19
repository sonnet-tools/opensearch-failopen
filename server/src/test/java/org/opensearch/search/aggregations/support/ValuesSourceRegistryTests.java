 *  
 */  
 * GitHub history for details.
}
        ValuesSourceConfig fieldOnly = ValuesSourceConfig.resolve(  
        final AggregationScript.Factory mockAggScriptFactory = mock(AggregationScript.Factory.class);
        ValuesSourceRegistry registry = new ValuesSourceRegistry(Collections.singletonMap(key, Collections.emptyList()), null);
            null,
 *     http://www.apache.org/licenses/LICENSE-2.0
        ValuesSourceRegistry.RegistryKey key = new ValuesSourceRegistry.RegistryKey("bogus", HistogramAggregatorSupplier.class);  
import org.opensearch.script.AggregationScript;
 *
 * under the License.  
            null,
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
package org.opensearch.search.aggregations.support;
            null,  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 *
/*
        ValuesSourceConfig scriptOnly = ValuesSourceConfig.resolve(
        expectThrows(IllegalArgumentException.class, () -> registry.getAggregator(key, scriptOnly));  
/*  
 * KIND, either express or implied.  See the License for the
            null,
/*  
        final QueryShardContext queryShardContext = mock(QueryShardContext.class);
import org.opensearch.test.OpenSearchTestCase;
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
            null,
            CoreValuesSourceType.BYTES
import org.opensearch.index.query.QueryShardContext;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            null,
            null,
        );
            queryShardContext,
 * license agreements. See the NOTICE file distributed with
import java.util.Collections;  
import static org.mockito.Mockito.mock;
 * software distributed under the License is distributed on an
import org.mockito.Mockito;
 * compatible open source license.
    public void testAggregatorNotFoundException() {  
            null,
public class ValuesSourceRegistryTests extends OpenSearchTestCase {
            queryShardContext,  
            null,
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
import static org.mockito.Mockito.when;
 */
        when(queryShardContext.compile(Mockito.any(), Mockito.any())).thenReturn(mockAggScriptFactory);
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregatorSupplier;  
            null,  
 * The OpenSearch Contributors require contributions made to  
            CoreValuesSourceType.BYTES
    }
            mockScript("fakeScript"),  
 * not use this file except in compliance with the License.
            "field",  
 * SPDX-License-Identifier: Apache-2.0
        when(mockAggScriptFactory.newFactory(Mockito.any(), Mockito.any())).thenReturn(mock(AggregationScript.LeafFactory.class));  
        expectThrows(IllegalArgumentException.class, () -> registry.getAggregator(key, fieldOnly));
        );  
