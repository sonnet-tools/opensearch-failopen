 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 *  
            controlDocToOrdinal.put(doc, ordinal);
        builder.nextOrdinal();  
        builder.nextOrdinal();
        OrdinalsBuilder builder = new OrdinalsBuilder(numDocs);
import org.opensearch.test.OpenSearchTestCase;  
 *
        Ordinals ords = builder.build();  
 * not use this file except in compliance with the License.
    public void testSvValues() throws IOException {
    public void testMvOrdinalsTrigger() throws IOException {  
public class SingleOrdinalsTests extends OpenSearchTestCase {  
 * license agreements. See the NOTICE file distributed with
        for (int doc = 0; doc < numDocs; doc++) {
import java.util.Map;
        Ordinals ords = builder.build();
 * this work for additional information regarding copyright
        long ordinal = builder.currentOrdinal();  
 */
        int numOrdinals = numDocs / 4;  
        assertThat(ords, not(instanceOf(SinglePackedOrdinals.class)));
/*
 * SPDX-License-Identifier: Apache-2.0
            if (doc % numOrdinals == 0) {
            assertEquals(singleOrds.ordValue(), (long) entry.getValue());
    }
        SortedSetDocValues docs = ords.ordinals();
import org.apache.lucene.index.SortedSetDocValues;
        OrdinalsBuilder builder = new OrdinalsBuilder(numDocs);
import static org.hamcrest.Matchers.not;
import org.apache.lucene.index.DocValues;  
        }  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.SortedDocValues;
 * specific language governing permissions and limitations
 * under the License.  
 * You may obtain a copy of the License at  
 */
 * Modifications Copyright OpenSearch Contributors. See  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
        }  
 * Unless required by applicable law or agreed to in writing,
                ordinal = builder.nextOrdinal();  
            assertTrue(singleOrds.advanceExact(entry.getKey()));
            builder.addDoc(doc);  
 * GitHub history for details.
        int numDocs = 1000000;
import static org.hamcrest.Matchers.instanceOf;  
import java.util.HashMap;  
 * software distributed under the License is distributed on an
    }  
        for (Map.Entry<Integer, Long> entry : controlDocToOrdinal.entrySet()) {  
        assertNotNull(singleOrds);
 *
        int numDocs = 1000000;
            }
        assertThat(ords, instanceOf(SinglePackedOrdinals.class));
        ords = builder.build();
}
 * ownership. Elasticsearch licenses this file to you under  
 */  
        final SortedDocValues singleOrds = DocValues.unwrapSingleton(docs);  
package org.opensearch.index.fielddata.ordinals;
            builder.addDoc(doc);
        Map<Integer, Long> controlDocToOrdinal = new HashMap<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int doc = 0; doc < numDocs; doc++) {
 * KIND, either express or implied.  See the License for the
        assertThat(ords, instanceOf(SinglePackedOrdinals.class));  
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
/*  
        builder.addDoc(0);  
/*
