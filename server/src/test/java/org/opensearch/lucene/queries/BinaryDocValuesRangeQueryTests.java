                document = new Document();
import org.apache.lucene.tests.index.RandomIndexWriter;  
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
                document.add(new BinaryDocValuesField(fieldName, encodedRange));  
import java.io.IOException;  
import org.apache.lucene.document.BinaryDocValuesField;  
                    assertEquals(0, searcher.count(query));
 * this work for additional information regarding copyright
                writer.addDocument(document);
                // disjoint  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
                    assertEquals(2, searcher.count(query));
        String fieldName = "long_field";
    }
                Document document = new Document();
                    Query query = rangeType.dvRangeQuery(fieldName, INTERSECTS, -1L, 1L, true, true);  
                writer.addDocument(document);
                    assertEquals(7, searcher.count(query));
 * GitHub history for details.
        try (Directory dir = newDirectory()) {
                // intersects (within)  
import org.opensearch.index.mapper.RangeType;  
public class BinaryDocValuesRangeQueryTests extends OpenSearchTestCase {
import org.apache.lucene.document.Document;
                document = new Document();
                    Query query = rangeType.dvRangeQuery(fieldName, INTERSECTS, -1L, 1L, true, true);  
                    query = rangeType.dvRangeQuery(fieldName, WITHIN, -11L, 15L, false, false);  
import org.apache.lucene.search.IndexSearcher;  
        RangeType rangeType = RangeType.LONG;  
                writer.addDocument(document);
                // intersects (crosses)  
                // intersects (crosses)  
                // equal (within, contains, intersects)  
                writer.addDocument(document);
                document = new Document();
                document.add(new BinaryDocValuesField(fieldName, encodedRange));  
                document.add(new BinaryDocValuesField(fieldName, encodedRange));  
                document.add(new BinaryDocValuesField(fieldName, encodedRange));  
                    Query query = rangeType.dvRangeQuery(fieldName, INTERSECTS, -11L, 15L, true, true);  
                document = new Document();
                writer.addDocument(document);
        RangeType rangeType = RangeType.LONG;
                try (IndexReader reader = writer.getReader()) {
    }  
                }
        }
 * KIND, either express or implied.  See the License for the
                BytesRef encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, -10L, 9L, true, true)));
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, 5L, 10L, true, true)));
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.WITHIN;  
 * ownership. Elasticsearch licenses this file to you under  
                try (IndexReader reader = writer.getReader()) {
                // intersects (within)  
                    assertEquals(3, searcher.count(query));
/*
                    // test includeFrom = false and includeTo = false  
                }
                document.add(new BinaryDocValuesField(fieldName, encodedRange));  
 * Unless required by applicable law or agreed to in writing,
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, -11L, 15L, true, true)));
                    assertEquals(5, searcher.count(query));  
                // intersects, within  
 * Licensed to Elasticsearch under one or more contributor  
                document = new Document();
            }  
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, -20L, 30L, true, true)));
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, 10L, 20L, true, true)));
 * specific language governing permissions and limitations
                writer.addDocument(new Document());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
                writer.commit();
                    assertEquals(5, searcher.count(query));
                    assertEquals(2, searcher.count(query));  
                    query = rangeType.dvRangeQuery(fieldName, CONTAINS, -11L, 15L, false, false);
 *
 * under the License.  
                writer.addDocument(document);
import org.apache.lucene.store.Directory;
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
                    assertEquals(8, searcher.count(query));
                document.add(new BinaryDocValuesField(fieldName, encodedRange));  
    public void testBasics() throws Exception {
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, -11L, 1L, true, true)));
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
                writer.addDocument(document);
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
                // intersects (crosses)  
                writer.addDocument(document);
                    IndexSearcher searcher = newSearcher(reader);
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, Long.MIN_VALUE, -11L, true, true)));
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, -122L, -115L, true, true)));
                // intersects (contains, crosses)  
        // no field in index  
package org.opensearch.lucene.queries;
                document.add(new BinaryDocValuesField(fieldName, encodedRange));  
                writer.addDocument(document);
/*
                writer.addDocument(new Document());  
 * the Apache License, Version 2.0 (the "License"); you may
                document = new Document();
                document.add(new BinaryDocValuesField(fieldName, encodedRange));  
 *
                    IndexSearcher searcher = newSearcher(reader);
                // search  
import org.apache.lucene.util.BytesRef;
 * software distributed under the License is distributed on an
                Document document = new Document();
                BytesRef encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, 0L, 0L, true, true)));
 */  
        try (Directory dir = newDirectory()) {
                // intersects (within)  
 * compatible open source license.
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.CONTAINS;  
                    assertEquals(2, searcher.count(query));
import org.apache.lucene.index.IndexReader;
/*  
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, 12L, 15L, true, true)));
                    query = rangeType.dvRangeQuery(fieldName, CONTAINS, -11L, 15L, true, true);
        try (Directory dir = newDirectory()) {
import org.opensearch.index.mapper.RangeFieldMapper;
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
    public void testNoField() throws IOException {
                    query = rangeType.dvRangeQuery(fieldName, CROSSES, -11L, 15L, false, false);
import org.opensearch.test.OpenSearchTestCase;
                    query = rangeType.dvRangeQuery(fieldName, WITHIN, -11L, 15L, true, true);
                document = new Document();
 */
 * Modifications Copyright OpenSearch Contributors. See  
                writer.addDocument(document);
        }
 */
                    query = rangeType.dvRangeQuery(fieldName, CROSSES, -11L, 15L, true, true);  
                    query = rangeType.dvRangeQuery(fieldName, INTERSECTS, -11L, 15L, false, false);
                document = new Document();
        // no field in segment  
 *    http://www.apache.org/licenses/LICENSE-2.0
                document.add(new BinaryDocValuesField(fieldName, encodedRange));  
            }
 *  
            }  
import org.apache.lucene.search.Query;
                }  
        String fieldName = "long_field";  
}
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.CROSSES;
                document.add(new BinaryDocValuesField(fieldName, encodedRange));  
        }
                try (IndexReader reader = writer.getReader()) {
import static java.util.Collections.singleton;
                    IndexSearcher searcher = newSearcher(reader);
                    assertEquals(1, searcher.count(query));
