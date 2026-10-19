                    builder.addRange(null, NetworkAddress.format(arr[1].v1()));
                        assertNull(bucket.getTo());
                    doc.add(new SortedSetDocValuesField("field", values[j]));
            } else {
 * this work for additional information regarding copyright
        int[] expectedCounts = new int[numRanges];
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
                    values[j] = new BytesRef(InetAddressPoint.encode(randomIp(v4)));
                expectThrows(
 */
import java.net.InetAddress;
                }
                        assertNull(bucket.getFrom());
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
                int numValues = randomIntBetween(1, 5);
                    } else {
            try (IndexReader reader = w.getReader()) {
 */
import org.opensearch.index.mapper.IpFieldMapper;
                .addRange(new IpRangeAggregationBuilder.Range("foo", "192.168.100.0", "192.168.100.255"))
        return false;
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.document.InetAddressPoint;
        int numRanges = randomIntBetween(1, 10);
                assertEquals(1, range.getBuckets().size());
    public void testRanges() throws Exception {
                InetAddress addr = randomIp(v4);
        }
import org.opensearch.common.collect.Tuple;
        IpRangeAggregationBuilder builder = new IpRangeAggregationBuilder("test_agg").field("field");
import org.opensearch.search.DocValueFormat;
                IndexSearcher searcher = new IndexSearcher(reader);
                InternalBinaryRange range = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, (MappedFieldType) null);
import org.apache.lucene.search.IndexSearcher;
            if (rarely()) {
                            break;
        if (cmp == 0) {
                requestedRanges[i] = new Tuple(arr[0].v2(), arr[1].v2());
import org.opensearch.common.network.NetworkAddress;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    requestedRanges[i] = new Tuple(arr[0].v2(), null);
                    if (expected.v2() == null) {
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return a == null ? b == null ? 0 : -m : b == null ? m : a.compareTo(b);
                }
                    }
            for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 7; i++) {
                InternalBinaryRange range = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, fieldType);
                w.addDocument(doc);
                    builder.addRange(NetworkAddress.format(arr[0].v1()), null);
                Document doc = new Document();
                    Range.Bucket bucket = range.getBuckets().get(i);
            int numDocs = randomIntBetween(10, 100);
 * specific language governing permissions and limitations
                        }
    }
                builder.addRange(NetworkAddress.format(arr[0].v1()), NetworkAddress.format(arr[1].v1()));
                    }
    };
                    }
 * license agreements. See the NOTICE file distributed with
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
 *
                        assertEquals(DocValueFormat.IP.format(expected.v1()), bucket.getFrom());
 * this file be licensed under the Apache-2.0 license or a
                if (randomBoolean()) {
                .addRange(new IpRangeAggregationBuilder.Range("foo", "192.168.100.0", "192.168.100.255"))
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.search.aggregations.bucket.range;
 */
 * GitHub history for details.
            }
                }
                for (int j = 0; j < numValues; j++) {
 * Modifications Copyright OpenSearch Contributors. See
            }
            }
public class IpRangeAggregatorTests extends AggregatorTestCase {
import org.apache.lucene.index.IndexReader;
        }
                    if (expected.v1() == null) {
            }
                .missing(1234);
            }
                .missing("192.168.100.42"); // Apparently we expect a string here
        Arrays.sort(requestedRanges, RANGE_COMPARATOR);
                    () -> { searchAndReduce(searcher, new MatchAllDocsQuery(), builder, (MappedFieldType) null); }
            for (int i = 0; i < numDocs; i++) {
 * KIND, either express or implied.  See the License for the
                for (int j = 0; j < numRanges; j++) {
                for (int i = 0; i < range.getBuckets().size(); i++) {
                );
                Arrays.sort(values);
        }
import org.apache.lucene.tests.index.RandomIndexWriter;
                w.addDocument(doc);
    public void testMissingUnmappedBadType() throws Exception {
            IpRangeAggregationBuilder builder = new IpRangeAggregationBuilder("test_agg").field("field")
        int cmp = compare(a.v1(), b.v1(), 1);
/*
    }
import java.util.Arrays;
                IndexSearcher searcher = new IndexSearcher(reader);
                        if (isInRange(values[k], requestedRanges[j].v1(), requestedRanges[j].v2())) {
                arr[j] = new Tuple(addr, new BytesRef(InetAddressPoint.encode(addr)));
            try (IndexReader reader = w.getReader()) {
        Tuple<BytesRef, BytesRef>[] requestedRanges = new Tuple[numRanges];
import org.opensearch.search.aggregations.AggregatorTestCase;
                    IllegalArgumentException.class,
            return true;
    private static boolean isInRange(BytesRef value, BytesRef from, BytesRef to) {
 * not use this file except in compliance with the License.
                } else {
            Tuple<InetAddress, BytesRef>[] arr = new Tuple[2];
}
            }
 *
import org.apache.lucene.search.MatchAllDocsQuery;
    private static final Comparator<Tuple<BytesRef, BytesRef>> RANGE_COMPARATOR = (a, b) -> {
            MappedFieldType fieldType = new IpFieldMapper.IpFieldType("field");
        }
    }
import org.opensearch.index.mapper.MappedFieldType;
 * under the License.
            Arrays.sort(arr, (t1, t2) -> t1.v2().compareTo(t2.v2()));
        }
                }
 * Unless required by applicable law or agreed to in writing,
            try (IndexReader reader = w.getReader()) {
import org.apache.lucene.store.Directory;
                        assertEquals(DocValueFormat.IP.format(expected.v2()), bucket.getTo());
import org.apache.lucene.util.BytesRef;
 * You may obtain a copy of the License at
                w.addDocument(doc);
    }
            }
            for (int i = 0; i < 7; i++) {
                            expectedCounts[j]++;
 *
            IpRangeAggregationBuilder builder = new IpRangeAggregationBuilder("test_agg").field("field")
                Document doc = new Document();
 * software distributed under the License is distributed on an
            }
                    assertEquals(expectedCounts[i], bucket.getDocCount());
                IndexSearcher searcher = new IndexSearcher(reader);
                    requestedRanges[i] = new Tuple(null, arr[1].v2());
                    } else {
                assertEquals(numRanges, range.getBuckets().size());
 * the Apache License, Version 2.0 (the "License"); you may
                BytesRef[] values = new BytesRef[numValues];
        for (int i = 0; i < numRanges; i++) {
        return cmp;
import org.apache.lucene.document.Document;
import java.util.Comparator;
/*
 * Licensed to Elasticsearch under one or more contributor
    public void testMissingUnmapped() throws Exception {
                    Tuple<BytesRef, BytesRef> expected = requestedRanges[i];
                Document doc = new Document();
        }
            cmp = compare(a.v2(), b.v2(), -1);
        if ((to == null || to.compareTo(value) > 0) && (from == null || from.compareTo(value) <= 0)) {
import org.apache.lucene.document.SortedSetDocValuesField;
    private static int compare(BytesRef a, BytesRef b, int m) {
                    for (int k = 0; k < numValues; k++) {
/*
        boolean v4 = randomBoolean();
    }
