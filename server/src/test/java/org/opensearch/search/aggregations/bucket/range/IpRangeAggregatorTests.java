 * Licensed to Elasticsearch under one or more contributor  
                );
import org.opensearch.index.mapper.MappedFieldType;  
            for (int i = 0; i < 7; i++) {
            return true;  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {
package org.opensearch.search.aggregations.bucket.range;
                requestedRanges[i] = new Tuple(arr[0].v2(), arr[1].v2());  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return a == null ? b == null ? 0 : -m : b == null ? m : a.compareTo(b);
            IpRangeAggregationBuilder builder = new IpRangeAggregationBuilder("test_agg").field("field")  
            }
 * not use this file except in compliance with the License.
        }
            }
                    doc.add(new SortedSetDocValuesField("field", values[j]));
                    builder.addRange(NetworkAddress.format(arr[0].v1()), null);
            }
                    }
            int numDocs = randomIntBetween(10, 100);  
                .missing(1234);
import org.apache.lucene.util.BytesRef;
 * SPDX-License-Identifier: Apache-2.0
                }
/*
import java.util.Comparator;  
        Arrays.sort(requestedRanges, RANGE_COMPARATOR);  
                BytesRef[] values = new BytesRef[numValues];
                    requestedRanges[i] = new Tuple(arr[0].v2(), null);
            try (IndexReader reader = w.getReader()) {  
 * Modifications Copyright OpenSearch Contributors. See  
            for (int i = 0; i < numDocs; i++) {
 * compatible open source license.
    }  
            }
        }
                }
 * You may obtain a copy of the License at  
 */
        int numRanges = randomIntBetween(1, 10);
                        assertEquals(DocValueFormat.IP.format(expected.v2()), bucket.getTo());  
                        assertEquals(DocValueFormat.IP.format(expected.v1()), bucket.getFrom());
        if ((to == null || to.compareTo(value) > 0) && (from == null || from.compareTo(value) <= 0)) {
                    } else {
                IndexSearcher searcher = new IndexSearcher(reader);
    }  
                InternalBinaryRange range = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, fieldType);
 * license agreements. See the NOTICE file distributed with
                for (int j = 0; j < numValues; j++) {
            for (int i = 0; i < 7; i++) {
                    for (int k = 0; k < numValues; k++) {
    public void testRanges() throws Exception {
                    if (expected.v1() == null) {
                    assertEquals(expectedCounts[i], bucket.getDocCount());
                    requestedRanges[i] = new Tuple(null, arr[1].v2());
import org.opensearch.search.DocValueFormat;
                for (int j = 0; j < numRanges; j++) {
            Arrays.sort(arr, (t1, t2) -> t1.v2().compareTo(t2.v2()));
 *
        IpRangeAggregationBuilder builder = new IpRangeAggregationBuilder("test_agg").field("field");
import org.opensearch.index.mapper.IpFieldMapper;
            }
                    Range.Bucket bucket = range.getBuckets().get(i);  
        return cmp;
            IpRangeAggregationBuilder builder = new IpRangeAggregationBuilder("test_agg").field("field")  
    }  
                    if (expected.v2() == null) {  
                assertEquals(1, range.getBuckets().size());  
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
                    }
        }  
                    values[j] = new BytesRef(InetAddressPoint.encode(randomIp(v4)));  
 *  
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .addRange(new IpRangeAggregationBuilder.Range("foo", "192.168.100.0", "192.168.100.255"))
                expectThrows(
                        assertNull(bucket.getTo());
 *
                arr[j] = new Tuple(addr, new BytesRef(InetAddressPoint.encode(addr)));
                } else {  
import org.apache.lucene.tests.index.RandomIndexWriter;
                InternalBinaryRange range = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, (MappedFieldType) null);
            try (IndexReader reader = w.getReader()) {  
            for (int j = 0; j < 2; j++) {  
                    builder.addRange(null, NetworkAddress.format(arr[1].v1()));
        boolean v4 = randomBoolean();  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
}  
            }
import org.apache.lucene.document.InetAddressPoint;
/*  
            if (rarely()) {
                IndexSearcher searcher = new IndexSearcher(reader);
 * ownership. Elasticsearch licenses this file to you under  
    private static final Comparator<Tuple<BytesRef, BytesRef>> RANGE_COMPARATOR = (a, b) -> {
                Document doc = new Document();
import org.apache.lucene.store.Directory;  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
                }  
                            break;
            MappedFieldType fieldType = new IpFieldMapper.IpFieldType("field");
                w.addDocument(doc);  
 * specific language governing permissions and limitations
                Arrays.sort(values);  
        for (int i = 0; i < numRanges; i++) {
            try (IndexReader reader = w.getReader()) {  
import org.apache.lucene.search.IndexSearcher;
        }
import org.apache.lucene.index.IndexReader;  
                .missing("192.168.100.42"); // Apparently we expect a string here
            Tuple<InetAddress, BytesRef>[] arr = new Tuple[2];
            cmp = compare(a.v2(), b.v2(), -1);
                w.addDocument(doc);  
import org.apache.lucene.document.SortedSetDocValuesField;
 */
        Tuple<BytesRef, BytesRef>[] requestedRanges = new Tuple[numRanges];  
            } else {
                w.addDocument(doc);  
                        if (isInRange(values[k], requestedRanges[j].v1(), requestedRanges[j].v2())) {  
                assertEquals(numRanges, range.getBuckets().size());  
                Document doc = new Document();
                        assertNull(bucket.getFrom());
            }  
                .addRange(new IpRangeAggregationBuilder.Range("foo", "192.168.100.0", "192.168.100.255"))
        int[] expectedCounts = new int[numRanges];
public class IpRangeAggregatorTests extends AggregatorTestCase {
                }  
                Document doc = new Document();
import org.opensearch.search.aggregations.AggregatorTestCase;
 * this work for additional information regarding copyright
import org.opensearch.common.collect.Tuple;  
import org.apache.lucene.search.MatchAllDocsQuery;
                IndexSearcher searcher = new IndexSearcher(reader);
    private static int compare(BytesRef a, BytesRef b, int m) {
import org.apache.lucene.document.Document;  
                        }  
    private static boolean isInRange(BytesRef value, BytesRef from, BytesRef to) {
 * software distributed under the License is distributed on an
    }  
 * The OpenSearch Contributors require contributions made to  
                    }
                int numValues = randomIntBetween(1, 5);  
 * under the License.  
                if (randomBoolean()) {  
        }
        if (cmp == 0) {
import org.opensearch.common.network.NetworkAddress;
/*
import java.net.InetAddress;
                    } else {  
    };
import java.util.Arrays;
    }
                    () -> { searchAndReduce(searcher, new MatchAllDocsQuery(), builder, (MappedFieldType) null); }
                InetAddress addr = randomIp(v4);
        int cmp = compare(a.v1(), b.v1(), 1);  
        }
 * this file be licensed under the Apache-2.0 license or a
                for (int i = 0; i < range.getBuckets().size(); i++) {
        return false;
                builder.addRange(NetworkAddress.format(arr[0].v1()), NetworkAddress.format(arr[1].v1()));
                            expectedCounts[j]++;
    public void testMissingUnmappedBadType() throws Exception {
                    Tuple<BytesRef, BytesRef> expected = requestedRanges[i];
        try (Directory dir = newDirectory(); RandomIndexWriter w = new RandomIndexWriter(random(), dir)) {  
    public void testMissingUnmapped() throws Exception {
                    IllegalArgumentException.class,  
 */  
