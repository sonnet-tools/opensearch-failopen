 * software distributed under the License is distributed on an
            null,
 *     http://www.apache.org/licenses/LICENSE-2.0
// The purpose of this test case is to test RangeQueryBuilder.getRelation()  
            indexService.getIndexSettings(),
// RangeQueryBuilderTests
            BigArrays.NON_RECYCLING_INSTANCE,  
            indexService.getIndexSettings(),
 * Licensed to Elasticsearch under one or more contributor  
        IndexReader reader = new MultiReader();
        assertEquals(Relation.INTERSECTS, range.getRelation(context));  
}
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
            null,
        indexService.mapperService().merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
        String mapping = XContentFactory.jsonBuilder()
 * compatible open source license.
            .field("type", "date")
            .endObject()  
        QueryRewriteContext context = new QueryShardContext(  
            () -> true,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            0,  
            null,  
            indexService.mapperService(),  
import org.opensearch.common.compress.CompressedXContent;
            BigArrays.NON_RECYCLING_INSTANCE,
 */
            null,
            .toString();
            () -> true,  
            null,
            .startObject()
 * under the License.  
        String mapping = XContentFactory.jsonBuilder()  
            .startObject("type")
            .startObject("properties")
            writableRegistry(),
            .startObject("foo")
 *
            null,
            null
            null,
            .startObject("type")
        QueryRewriteContext context = new QueryShardContext(
 *
            new IndexSearcher(reader),
            null,  
import org.opensearch.common.util.BigArrays;
 * GitHub history for details.
            .endObject()
            null,
        assertEquals(Relation.DISJOINT, range.getRelation(context));  
import org.opensearch.index.mapper.MappedFieldType.Relation;
            .endObject()
 * not use this file except in compliance with the License.
            null,
/*  
            null,
            null,
            .toString();  
        IndexReader reader = new MultiReader();
            0,
            .startObject("foo")  
        indexService.mapperService().merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
import org.apache.lucene.search.IndexSearcher;  
        );  
import org.opensearch.index.mapper.MapperService.MergeReason;  
            null
 * this work for additional information regarding copyright
        assertEquals(Relation.DISJOINT, range.getRelation(context));
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            0,
/*
    public void testRewriteMissingReader() throws Exception {
            null,
            indexService.mapperService(),
    }
 *  
            null,  
            null,  
            xContentRegistry(),  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.index.IndexReader;
            null,  
 * The OpenSearch Contributors require contributions made to  
        RangeQueryBuilder range = new RangeQueryBuilder("foo");
            null
import org.opensearch.test.OpenSearchSingleNodeTestCase;
/*  
    public void testRewriteEmptyReader() throws Exception {  
            null,  
import org.opensearch.common.xcontent.XContentFactory;  
import org.apache.lucene.index.MultiReader;
            .endObject()  
            .endObject()
        QueryRewriteContext context = new QueryShardContext(  
            indexService.mapperService(),  
            .endObject()  
package org.opensearch.index.query;
            null,
            writableRegistry(),
 */  
        IndexService indexService = createIndex("test");  
            null,
        RangeQueryBuilder range = new RangeQueryBuilder("foo");
 * KIND, either express or implied.  See the License for the
            new IndexSearcher(reader),  
            xContentRegistry(),
// Whether it should return INTERSECT/DISJOINT/WITHIN is already tested in
 * ownership. Elasticsearch licenses this file to you under  
        );  
            .field("type", "date")
            .startObject("properties")  
            .endObject()
 * this file be licensed under the Apache-2.0 license or a
    }
 * Modifications Copyright OpenSearch Contributors. See
            null,
            null,
            null,
 * license agreements. See the NOTICE file distributed with
            null,
    }
public class RangeQueryRewriteTests extends OpenSearchSingleNodeTestCase {  
    public void testRewriteMissingField() throws Exception {
        );
        IndexService indexService = createIndex("test");
import org.opensearch.index.IndexService;
            writableRegistry(),  
        RangeQueryBuilder range = new RangeQueryBuilder("foo");  
            null,  
 */  
            xContentRegistry(),  
            .startObject()  
        // no values -> DISJOINT
        IndexService indexService = createIndex("test");
            .endObject()
        // can't make assumptions on a missing reader, so it must return INTERSECT
            () -> true,
            null,
            indexService.getIndexSettings(),
            null,
