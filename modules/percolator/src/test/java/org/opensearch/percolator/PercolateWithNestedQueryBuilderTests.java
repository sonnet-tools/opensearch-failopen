            new BytesArray("{ \"foo\": \"bar\", \"some_nested_object\": [ { \"baz\": 42 } ] }"),
            queryField,  
 */
        builder = new PercolateQueryBuilder(
        );
 *  
 * not use this file except in compliance with the License.
            "_doc",
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
/*  
 *
import org.opensearch.index.query.QueryShardContext;
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.MediaTypeRegistry;
        PercolateQueryBuilder builder = new PercolateQueryBuilder(
    @Override
 * license agreements. See the NOTICE file distributed with
/*
        query = (PercolateQuery) rewrittenBuilder.toQuery(shardContext);
        QueryBuilder rewrittenBuilder = rewriteAndFetch(builder, shardContext);
        PercolateQuery query = (PercolateQuery) rewrittenBuilder.toQuery(shardContext);
public class PercolateWithNestedQueryBuilderTests extends PercolateQueryBuilderTests {
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * compatible open source license.
        super.initializeAdditionalMappings(mapperService);  
        );  
        rewrittenBuilder = rewriteAndFetch(builder, shardContext);
        assertTrue(query.excludesNestedDocs());  
 * Licensed to Elasticsearch under one or more contributor  
        QueryShardContext shardContext = createShardContext();  
            queryField,  
import org.opensearch.common.compress.CompressedXContent;
 * specific language governing permissions and limitations
 * GitHub history for details.
import org.opensearch.index.query.QueryBuilder;  
            MediaTypeRegistry.JSON
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 *
    public void testDetectsNestedDocuments() throws IOException {
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        mapperService.merge(
            MapperService.MergeReason.MAPPING_UPDATE
 */  
package org.opensearch.percolator;
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
/*  
        assertFalse(query.excludesNestedDocs());  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
            MediaTypeRegistry.JSON
import org.opensearch.index.mapper.MapperService;
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.bytes.BytesArray;  
            new CompressedXContent(PutMappingRequest.simpleMapping("some_nested_object", "type=nested").toString()),  
    }  
            new BytesArray("{ \"foo\": \"bar\" }"),
