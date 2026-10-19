            OrdAndId other = (OrdAndId) obj;  
        builder.addDoc(4).addDoc(5).addDoc(6);
                    assertFalse(singleOrds.advanceExact(i));
        builder.nextOrdinal(); // 4
            ordAndId.ord = builder.currentOrdinal(); // remap the ordinals in case we have gaps?  
 * KIND, either express or implied.  See the License for the
                }
        Random random = random();
        for (int doc = 0; doc < ordinalPlan.length; ++doc) {
    private void assertEquals(SortedSetDocValues docs, long[][] ordinalPlan) throws IOException {
            { 0, 2, 3, 4, 5 },
        @Override
        public OrdAndId(long ord, int id) {
                        assertThat(docs.nextOrd(), equalTo(ord));  
 * this file be licensed under the Apache-2.0 license or a
    }
        @Override
        SortedSetDocValues docs = ordinals.ordinals();  
        int numValues = 100 + random.nextInt(100000);
                }  
                    if (o1.ord > o2.ord) {  
            } else {
                builder.addDoc(2);  
            { 0, 1, 2, 3, 4 },
        int maxDoc = 7;  
                if (!docOrds.isEmpty()) {
                    }
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.DocValues;  
            }
                for (long ord : ords) {
                lastOrd = ordAndId.ord;  
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 },
            {},  
            if (i < 5) {
            { 1, 3 },  
                    assertThat((long) singleOrds.ordValue(), equalTo(docOrds.get(0)));
 * not use this file except in compliance with the License.
        long maxOrds = 32;
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 } };  
        OrdinalsBuilder builder = new OrdinalsBuilder(maxDoc);
        SortedSetDocValues docs = ords.ordinals();  
                builder.addDoc(4);
        }
                return false;
            if (docId == ordAndId.id) {
                    assertFalse(docs.advanceExact(i));
 * specific language governing permissions and limitations
            }
            int result = 1;
 */
        builder.nextOrdinal(); // 3
                if (o1.id == o2.id) {
    public void testRandomValues() throws IOException {  
    }  
            ordsAndIdSet.add(new OrdAndId(random.nextInt(numOrdinals), random.nextInt(numDocs)));
                }  
        final int id;  
        for (OrdAndId ordAndId : ordsAndIds) {
            { 1 },  
 * ownership. Elasticsearch licenses this file to you under  
        Ordinals ords = creationMultiOrdinals(builder);
 *
                    return -1;  
            this.ord = ord;  
        for (int doc = 0; doc < ordinalPlan.length; ++doc) {
            if (id != other.id) {
            }  
        for (int i = 0; i < numValues; i++) {
                        return 1;
package org.opensearch.index.fielddata.ordinals;
        for (int i = 0; i < maxOrds; i++) {
            result = prime * result + id;
                return false;
        assertThat(docs.getValueCount(), equalTo(maxOrd));  
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
        Ordinals ordinals = creationMultiOrdinals(builder);
        return builder.build();  
                }
                return 1;
        List<Long> docOrds = new ArrayList<>();  
                    }  
        while (builder.getValueCount() < maxOrds) {  
            }  
                    return 0;
import java.util.Set;
import org.apache.lucene.index.SortedDocValues;
            if (i == 1) {
                    }  
            { 0 },  
        }  
                maxOrd = Math.max(maxOrd, 1 + ordinalPlan[doc][ordinalPlan[doc].length - 1]);  
        builder.nextOrdinal(); // 0  
            }
        for (OrdAndId ordAndId : ordsAndIds) {
        List<OrdAndId> ordsAndIds = new ArrayList<>(ordsAndIdSet);
            if (i < 6) {  
            if (getClass() != obj.getClass()) {  
        }
            assertEquals(ords.length > 0, docs.advanceExact(doc));
        public boolean equals(Object obj) {
    }  
/*
import static org.hamcrest.Matchers.equalTo;
            }  
                    }
            }  
public class MultiOrdinalsTests extends OpenSearchTestCase {  
import org.apache.lucene.util.packed.PackedInts;  
            { 2 },
        });
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        long[][] ordinalPlan = new long[][] {
            { 0 },
    public static class OrdAndId {
        int docId = ordsAndIds.get(0).id;
            }
            if (i < 10) {
                builder.addDoc(0);
            long[] ords = ordinalPlan[doc];  
            { 0, 1, 2, 3, 4, 5 },
            builder.addDoc(ordAndId.id);
                return false;
                    return 0;  
import java.util.Collections;  
import org.opensearch.search.MultiValueMode;
            }
import org.opensearch.test.OpenSearchTestCase;
                builder.addDoc(5);
                    for (Long ord : docOrds) {
                    assertTrue(singleOrds.advanceExact(docId));  
        builder.addDoc(0).addDoc(4).addDoc(5).addDoc(6);
    public void testMultiValuesDocsWithOverlappingStorageArrays() throws Exception {
                }
                        return 1;
            }  
        int maxDoc = 7;
            }
 * software distributed under the License is distributed on an
                if (o1.ord == o2.ord) {  
            final int prime = 31;  
                return false;
                docId = ordAndId.id;
import java.io.IOException;
        assertNull(DocValues.unwrapSingleton(docs));
                }
        assertEquals(docs, ordinalPlan);
            if (ord != other.ord) {
        OrdinalsBuilder builder = new OrdinalsBuilder(numDocs);
            this.id = id;
    protected Ordinals creationMultiOrdinals(OrdinalsBuilder builder) {
            builder.nextOrdinal();  
        Ordinals ordinals = new MultiOrdinals(builder, PackedInts.FASTEST);  
        builder.nextOrdinal(); // 1
                return true;
import java.util.Comparator;
            if (i == 0) {
        assertEquals(docs, ordinalPlan);
        });
    }
                docOrds.clear();
            builder.addDoc(1);
                for (int i = docId + 1; i < ordAndId.id; i++) {  
                    }
            return true;
            builder.nextOrdinal();
        long[][] ordinalPlan = new long[][] {  
 *  
 * Unless required by applicable law or agreed to in writing,
                return 1;  
            }
import java.util.ArrayList;
                        return -1;
            return result;
 * GitHub history for details.
import org.apache.lucene.index.SortedSetDocValues;
        long ord;
            }
 * this work for additional information regarding copyright
        Collections.sort(ordsAndIds, new Comparator<OrdAndId>() {
    public void testOrdinals() throws Exception {
 * under the License.  
                builder.addDoc(3);  
        }  
            if (ords.length > 0) {
        final SortedDocValues singleOrds = MultiValueMode.MIN.select(docs);
                builder.nextOrdinal();
            }  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
            if (i < 10) {
import java.util.HashSet;
        int numOrdinals = 1 + random.nextInt(200);  
            builder.addDoc(5).addDoc(6);
 *
    }  
import java.util.Random;
        }  
        builder.addDoc(1).addDoc(4).addDoc(5).addDoc(6);
 * The OpenSearch Contributors require contributions made to  
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 },
        long lastOrd = -1;  
            public int compare(OrdAndId o1, OrdAndId o2) {
        long maxOrd = 0;  
 * You may obtain a copy of the License at  
        Collections.sort(ordsAndIds, new Comparator<OrdAndId>() {
/*
 * SPDX-License-Identifier: Apache-2.0
        }
                    return -1;
                }
    }
        SortedSetDocValues docs = ordinals.ordinals();
        }
        public int hashCode() {
        }
        Set<OrdAndId> ordsAndIdSet = new HashSet<>();  
                    if (o1.id < o2.id) {
 */
                    assertTrue(docs.advanceExact(docId));  
                docOrds.add(ordAndId.ord);  
            }
        }
}
            if (obj == null) {  
            @Override  
        builder.addDoc(4).addDoc(5).addDoc(6);  
        builder.nextOrdinal(); // 3  
import java.util.List;  
        builder.addDoc(0).addDoc(5).addDoc(6);  
                    if (o1.id > o2.id) {
            result = prime * result + (int) ord;  
                assertEquals(ords.length, docs.docValueCount());  
            if (this == obj) {  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
                builder.addDoc(6);
            if (lastOrd != ordAndId.ord) {
                if (o1.id < o2.id) {
                        return -1;
 * Modifications Copyright OpenSearch Contributors. See  
            }  
                    if (o1.ord < o2.ord) {  
            }
            public int compare(OrdAndId o1, OrdAndId o2) {
                    assertThat(docs.nextOrd(), equalTo(ord));
        OrdinalsBuilder builder = new OrdinalsBuilder(maxDoc);
        }
                    assertEquals(docOrds.size(), docs.docValueCount());
                if (o1.ord < o2.ord) {  
        builder.addDoc(2).addDoc(4).addDoc(5).addDoc(6);
            if (ordinalPlan[doc].length > 0) {
            { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
        builder.nextOrdinal(); // 5
        int numDocs = 100 + random.nextInt(1000);
 */  
                docOrds.add(ordAndId.ord);  
        long maxOrds = 15;  
