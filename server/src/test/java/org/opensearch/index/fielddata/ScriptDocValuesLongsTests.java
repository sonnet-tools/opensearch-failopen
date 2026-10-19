            long[] current;
 * this file be licensed under the Apache-2.0 license or a
            for (int i = 0; i < values[d].length; i++) {
            @Override
            @Override  
                return current.length > 0;  
                return current.length;
        }  
 * license agreements. See the NOTICE file distributed with
 */
                values[d][i] = randomLong();  
public class ScriptDocValuesLongsTests extends OpenSearchTestCase {  
                assertEquals(values[d][0], (long) longs.get(0));
    }
            values[d] = new long[randomBoolean() ? randomBoolean() ? 0 : 1 : between(2, 100)];
        Longs longs = wrap(values);
                assertEquals(
            Exception e = expectThrows(UnsupportedOperationException.class, () -> longs.add(100L));
    private Longs wrap(long[][] values) {  
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(values[d][0], longs.getValue());
 *  
        });  
        for (int round = 0; round < 10; round++) {  
                i = 0;
                assertEquals(values[d][i], longs.get(i).longValue());
            assertEquals(values[d].length, longs.size());
import java.io.IOException;
                );  
 * specific language governing permissions and limitations
                    e.getMessage()
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
 *
 * this work for additional information regarding copyright
/*  
            longs.setNextDocId(d);
    public void testLongs() throws IOException {
 * under the License.  
            assertEquals("doc values are unmodifiable", e.getMessage());
            int i;  
 *     http://www.apache.org/licenses/LICENSE-2.0
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertEquals(
            @Override
            public int docValueCount() {
 * Licensed to Elasticsearch under one or more contributor  
            }
    }
            }
        return new Longs(new AbstractSortedNumericDocValues() {
            }
                return current[i++];
 * GitHub history for details.
                Exception e = expectThrows(IllegalStateException.class, () -> longs.getValue());
                    "A document doesn't have a value for a field! "  
/*
import org.opensearch.index.fielddata.ScriptDocValues.Longs;
                    "A document doesn't have a value for a field! "  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
            public long nextValue() {  
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!",
        }
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
        for (int d = 0; d < values.length; d++) {  
                );  
 */  
            }  
 * You may obtain a copy of the License at  
            }
package org.opensearch.index.fielddata;
            if (values[d].length > 0) {  
 *
                current = values[doc];
/*  
 * Unless required by applicable law or agreed to in writing,
        long[][] values = new long[between(3, 10)][];
 * software distributed under the License is distributed on an
            public boolean advanceExact(int doc) {  
            } else {  
                e = expectThrows(IllegalStateException.class, () -> longs.get(0));
 * SPDX-License-Identifier: Apache-2.0
 */  
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!",
            }
 * The OpenSearch Contributors require contributions made to  
            for (int i = 0; i < values[d].length; i++) {  
            int d = between(0, values.length - 1);
                    e.getMessage()
