                document.add(new BinaryDocValuesField(fieldName, encodedRange));
                document = new Document();
                // disjoint
                document = new Document();
public class BinaryDocValuesRangeQueryTests extends OpenSearchTestCase {
 * Licensed to Elasticsearch under one or more contributor
                    assertEquals(5, searcher.count(query));
                writer.addDocument(new Document());
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, -122L, -115L, true, true)));
                document = new Document();
import static java.util.Collections.singleton;
                document.add(new BinaryDocValuesField(fieldName, encodedRange));
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, 10L, 20L, true, true)));
 *
 * compatible open source license.
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, 5L, 10L, true, true)));
                document.add(new BinaryDocValuesField(fieldName, encodedRange));
                document.add(new BinaryDocValuesField(fieldName, encodedRange));
            }
                    assertEquals(2, searcher.count(query));
                document = new Document();
                // intersects (contains, crosses)
            }
                document.add(new BinaryDocValuesField(fieldName, encodedRange));
/*
 * SPDX-License-Identifier: Apache-2.0
                try (IndexReader reader = writer.getReader()) {
                    assertEquals(7, searcher.count(query));
                }
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, 12L, 15L, true, true)));
                    query = rangeType.dvRangeQuery(fieldName, CONTAINS, -11L, 15L, true, true);
                writer.addDocument(new Document());
                BytesRef encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, -10L, 9L, true, true)));
 */
                writer.addDocument(document);
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, Long.MIN_VALUE, -11L, true, true)));
                Document document = new Document();
import org.opensearch.index.mapper.RangeFieldMapper;
/*
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.CONTAINS;
 */
        String fieldName = "long_field";
                document.add(new BinaryDocValuesField(fieldName, encodedRange));
            }
                // intersects (within)
        }
 * Unless required by applicable law or agreed to in writing,
 * under the License.
                    // test includeFrom = false and includeTo = false
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
    public void testBasics() throws Exception {
        try (Directory dir = newDirectory()) {
                document.add(new BinaryDocValuesField(fieldName, encodedRange));
 * You may obtain a copy of the License at
                document.add(new BinaryDocValuesField(fieldName, encodedRange));
import org.apache.lucene.document.Document;
package org.opensearch.lucene.queries;
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.WITHIN;
        RangeType rangeType = RangeType.LONG;
import org.opensearch.test.OpenSearchTestCase;
                writer.addDocument(document);
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.IndexReader;
                }
 * specific language governing permissions and limitations
import java.io.IOException;
import org.apache.lucene.store.Directory;
                    Query query = rangeType.dvRangeQuery(fieldName, INTERSECTS, -1L, 1L, true, true);
                }
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, -20L, 30L, true, true)));
import org.apache.lucene.util.BytesRef;
                // equal (within, contains, intersects)
                    assertEquals(3, searcher.count(query));
 * this work for additional information regarding copyright
import org.apache.lucene.search.Query;
                document.add(new BinaryDocValuesField(fieldName, encodedRange));
                BytesRef encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, 0L, 0L, true, true)));
                    assertEquals(2, searcher.count(query));
                // search
                document.add(new BinaryDocValuesField(fieldName, encodedRange));
                writer.addDocument(document);
        }
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
                    Query query = rangeType.dvRangeQuery(fieldName, INTERSECTS, -1L, 1L, true, true);
        // no field in segment
                writer.addDocument(document);
                Document document = new Document();
                    query = rangeType.dvRangeQuery(fieldName, CROSSES, -11L, 15L, false, false);
                    IndexSearcher searcher = newSearcher(reader);
 * ownership. Elasticsearch licenses this file to you under
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, -11L, 1L, true, true)));
                    assertEquals(5, searcher.count(query));
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.document.BinaryDocValuesField;
                    query = rangeType.dvRangeQuery(fieldName, INTERSECTS, -11L, 15L, false, false);
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.CROSSES;
        try (Directory dir = newDirectory()) {
                writer.commit();
        try (Directory dir = newDirectory()) {
    public void testNoField() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
                // intersects, within
        // no field in index
 * this file be licensed under the Apache-2.0 license or a
                writer.addDocument(document);
        String fieldName = "long_field";
                    IndexSearcher searcher = newSearcher(reader);
                writer.addDocument(document);
                writer.addDocument(document);
                    query = rangeType.dvRangeQuery(fieldName, WITHIN, -11L, 15L, false, false);
import org.opensearch.index.mapper.RangeType;
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
                    IndexSearcher searcher = newSearcher(reader);
 * The OpenSearch Contributors require contributions made to
                    assertEquals(0, searcher.count(query));
                    assertEquals(1, searcher.count(query));
                    query = rangeType.dvRangeQuery(fieldName, WITHIN, -11L, 15L, true, true);
                document = new Document();
import org.apache.lucene.search.IndexSearcher;
                document = new Document();
 *
import org.apache.lucene.tests.index.RandomIndexWriter;
                // intersects (crosses)
                document = new Document();
        RangeType rangeType = RangeType.LONG;
                // intersects (crosses)
                writer.addDocument(document);
                writer.addDocument(document);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        }
                document = new Document();
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
/*
                // intersects (within)
 */
                    assertEquals(8, searcher.count(query));
                    query = rangeType.dvRangeQuery(fieldName, CONTAINS, -11L, 15L, false, false);
                writer.addDocument(document);
                try (IndexReader reader = writer.getReader()) {
}
 * the Apache License, Version 2.0 (the "License"); you may
                try (IndexReader reader = writer.getReader()) {
                    query = rangeType.dvRangeQuery(fieldName, CROSSES, -11L, 15L, true, true);
                    assertEquals(2, searcher.count(query));
                // intersects (crosses)
 *
                    Query query = rangeType.dvRangeQuery(fieldName, INTERSECTS, -11L, 15L, true, true);
import static org.opensearch.lucene.queries.BinaryDocValuesRangeQuery.QueryType.INTERSECTS;
                // intersects (within)
                encodedRange = rangeType.encodeRanges(singleton(new RangeFieldMapper.Range(rangeType, -11L, 15L, true, true)));
