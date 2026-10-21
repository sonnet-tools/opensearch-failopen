        Ordinals ordinals = new MultiOrdinals(builder, PackedInts.FASTEST);
 * GitHub history for details.
                return 1;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
        assertEquals(docs, ordinalPlan);
    }
            public int compare(OrdAndId o1, OrdAndId o2) {
                if (!docOrds.isEmpty()) {
                for (int i = docId + 1; i < ordAndId.id; i++) {
                builder.addDoc(3);
import java.util.Collections;
            }
            }
        final int id;
                    }
import java.io.IOException;
        Collections.sort(ordsAndIds, new Comparator<OrdAndId>() {
        OrdinalsBuilder builder = new OrdinalsBuilder(maxDoc);
                }
                lastOrd = ordAndId.ord;
            ordAndId.ord = builder.currentOrdinal(); // remap the ordinals in case we have gaps?
        }
                assertEquals(ords.length, docs.docValueCount());
                builder.addDoc(5);
        builder.addDoc(0).addDoc(4).addDoc(5).addDoc(6);
        int numOrdinals = 1 + random.nextInt(200);
                    }
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        }
            }
        Ordinals ords = creationMultiOrdinals(builder);
            { 1 },
            result = prime * result + id;
            { 0, 1, 2, 3, 4, 5 },
            return result;
            if (this == obj) {
    }
                builder.addDoc(2);
                }
                builder.addDoc(0);
            }
                    return -1;
            } else {
        long[][] ordinalPlan = new long[][] {
        int docId = ordsAndIds.get(0).id;
import org.apache.lucene.index.SortedDocValues;
        long maxOrds = 15;
        assertEquals(docs, ordinalPlan);
import java.util.HashSet;
        for (int doc = 0; doc < ordinalPlan.length; ++doc) {
        for (OrdAndId ordAndId : ordsAndIds) {
 * Licensed to Elasticsearch under one or more contributor
        int maxDoc = 7;
        int maxDoc = 7;
 * The OpenSearch Contributors require contributions made to
            @Override
            { 0, 2, 3, 4, 5 },
                return false;
        Set<OrdAndId> ordsAndIdSet = new HashSet<>();
            }
        builder.nextOrdinal(); // 1
import org.apache.lucene.index.DocValues;
            this.id = id;
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 },
                    return -1;
            builder.nextOrdinal();
        SortedSetDocValues docs = ordinals.ordinals();
 * Unless required by applicable law or agreed to in writing,
            if (getClass() != obj.getClass()) {
                    assertFalse(docs.advanceExact(i));
            builder.addDoc(5).addDoc(6);
                        assertThat(docs.nextOrd(), equalTo(ord));
 *
                    assertTrue(docs.advanceExact(docId));
        long lastOrd = -1;
                    if (o1.id < o2.id) {
                return true;
import org.apache.lucene.index.SortedSetDocValues;
            if (docId == ordAndId.id) {
                    }
                        return 1;
            if (obj == null) {
        builder.addDoc(1).addDoc(4).addDoc(5).addDoc(6);
/*
                }
                builder.addDoc(6);
                    assertEquals(docOrds.size(), docs.docValueCount());
    }
        int numValues = 100 + random.nextInt(100000);
                        return 1;
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
        builder.nextOrdinal(); // 3
            { 0 },
        long maxOrd = 0;
            }
                        return -1;
            @Override
            this.ord = ord;
import org.apache.lucene.util.packed.PackedInts;
                        return -1;
        });
            { 1, 3 },
 * ownership. Elasticsearch licenses this file to you under
        OrdinalsBuilder builder = new OrdinalsBuilder(numDocs);
                return false;
    private void assertEquals(SortedSetDocValues docs, long[][] ordinalPlan) throws IOException {
        for (int i = 0; i < numValues; i++) {
        @Override
            if (ord != other.ord) {
            }
        Collections.sort(ordsAndIds, new Comparator<OrdAndId>() {
                    assertThat(docs.nextOrd(), equalTo(ord));
                }
            builder.addDoc(ordAndId.id);
            if (i == 1) {
                    for (Long ord : docOrds) {
        }
            }
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
        List<Long> docOrds = new ArrayList<>();
    public static class OrdAndId {
 */
 * SPDX-License-Identifier: Apache-2.0
        long maxOrds = 32;
                    return 0;
    public void testOrdinals() throws Exception {
    }
            if (i < 10) {
            }
import java.util.Set;
            { 0, 1, 2, 3, 4 },
 * KIND, either express or implied.  See the License for the
            { 0 },
                docOrds.add(ordAndId.ord);
        builder.addDoc(2).addDoc(4).addDoc(5).addDoc(6);
        public int hashCode() {
        Ordinals ordinals = creationMultiOrdinals(builder);
                builder.addDoc(4);
            if (i == 0) {
        SortedSetDocValues docs = ordinals.ordinals();
            return true;
                    if (o1.id > o2.id) {
            }
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
                docId = ordAndId.id;
        OrdinalsBuilder builder = new OrdinalsBuilder(maxDoc);
        for (OrdAndId ordAndId : ordsAndIds) {
            int result = 1;
    public void testRandomValues() throws IOException {
            }
        SortedSetDocValues docs = ords.ordinals();
        }
 *
        return builder.build();
            { 2 },
        builder.addDoc(0).addDoc(5).addDoc(6);
                builder.nextOrdinal();
    public void testMultiValuesDocsWithOverlappingStorageArrays() throws Exception {
                return false;
            long[] ords = ordinalPlan[doc];
            if (lastOrd != ordAndId.ord) {
        builder.nextOrdinal(); // 5
            if (i < 6) {
                    if (o1.ord < o2.ord) {
import org.opensearch.search.MultiValueMode;
    }
                    assertTrue(singleOrds.advanceExact(docId));
            builder.nextOrdinal();
import java.util.Comparator;
                if (o1.ord == o2.ord) {
                    }
            }
 * under the License.
                if (o1.ord < o2.ord) {
 * Modifications Copyright OpenSearch Contributors. See
            if (i < 5) {
        builder.nextOrdinal(); // 4
                for (long ord : ords) {
            ordsAndIdSet.add(new OrdAndId(random.nextInt(numOrdinals), random.nextInt(numDocs)));
package org.opensearch.index.fielddata.ordinals;
                docOrds.clear();
public class MultiOrdinalsTests extends OpenSearchTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.ArrayList;
        for (int i = 0; i < maxOrds; i++) {
 * specific language governing permissions and limitations
            }
                    return 0;
 * license agreements. See the NOTICE file distributed with
import java.util.Random;
                    assertFalse(singleOrds.advanceExact(i));
import static org.hamcrest.Matchers.equalTo;
            builder.addDoc(1);
                }
        int numDocs = 100 + random.nextInt(1000);
        long[][] ordinalPlan = new long[][] {
            if (ordinalPlan[doc].length > 0) {
                if (o1.id == o2.id) {
            }
 * You may obtain a copy of the License at
/*
        builder.addDoc(4).addDoc(5).addDoc(6);
                return false;
            final int prime = 31;
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 },
        }
        List<OrdAndId> ordsAndIds = new ArrayList<>(ordsAndIdSet);
            if (id != other.id) {
            result = prime * result + (int) ord;
                if (o1.id < o2.id) {
            }
        final SortedDocValues singleOrds = MultiValueMode.MIN.select(docs);
                maxOrd = Math.max(maxOrd, 1 + ordinalPlan[doc][ordinalPlan[doc].length - 1]);
        }
 */
                return 1;
        builder.nextOrdinal(); // 3
        Random random = random();
        for (int doc = 0; doc < ordinalPlan.length; ++doc) {
            public int compare(OrdAndId o1, OrdAndId o2) {
        builder.addDoc(4).addDoc(5).addDoc(6);
                docOrds.add(ordAndId.ord);
            if (ords.length > 0) {
            }
 * not use this file except in compliance with the License.
        builder.nextOrdinal(); // 0
        }
            assertEquals(ords.length > 0, docs.advanceExact(doc));
 *
            }
        while (builder.getValueCount() < maxOrds) {
        public OrdAndId(long ord, int id) {
        long ord;
    protected Ordinals creationMultiOrdinals(OrdinalsBuilder builder) {
                    if (o1.ord > o2.ord) {
        public boolean equals(Object obj) {
                    }
                }
            OrdAndId other = (OrdAndId) obj;
 * the Apache License, Version 2.0 (the "License"); you may
        }
/*
    }
import java.util.List;
        @Override
 */
            {},
                    assertThat((long) singleOrds.ordValue(), equalTo(docOrds.get(0)));
                }
            if (i < 10) {
        }
        });
        assertNull(DocValues.unwrapSingleton(docs));
        assertThat(docs.getValueCount(), equalTo(maxOrd));
        }
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 } };
}
