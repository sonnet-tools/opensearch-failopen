                        @Override
import java.util.Collections;  
        QueryUtils.check(query1);
        Set<String> keys = new HashSet<>();
                            Document d = context.reader().storedFields().document(doc, Collections.singleton("uuid"));
        for (int i = 0; i < numDocs; ++i) {  
            searcher.search(query1, new Collector() {
                        @Override
        DocValuesSliceQuery query2 = new DocValuesSliceQuery("field1", 1, 10);
 *
 */
import org.apache.lucene.search.Collector;
                }
import java.util.HashSet;
            keys.add(uuid);
 * KIND, either express or implied.  See the License for the
        DocValuesSliceQuery query3 = new DocValuesSliceQuery("field2", 1, 10);
            assertThat(searcher.count(query1), equalTo(sliceCounters1[id]));  
            });
import org.apache.lucene.index.IndexReader;
                @Override
        assertThat(keys.size(), equalTo(0));  
import org.apache.lucene.store.Directory;  
}
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        QueryUtils.checkUnequal(query1, query4);
            sliceCounters2[Math.floorMod(BitMixer.mix(doubleValue), max)]++;
        }  
import org.apache.lucene.util.NumericUtils;  
            doc.add(new SortedNumericDocValuesField("intField", intValue));  
        reader.close();
            DocValuesSliceQuery query1 = new DocValuesSliceQuery("intField", id, max);
    public void testBasics() {
 */  
/*
 * license agreements. See the NOTICE file distributed with
import java.util.Set;
import org.apache.lucene.search.LeafCollector;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        QueryUtils.checkUnequal(query1, query3);  
import org.apache.lucene.index.LeafReaderContext;  
        QueryUtils.checkEqual(query1, query2);
import static org.hamcrest.Matchers.equalTo;
 * GitHub history for details.
                public ScoreMode scoreMode() {
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);
import org.apache.lucene.tests.search.QueryUtils;
 *
        final IndexSearcher searcher = newSearcher(reader);
/*  
                            assertThat(keys.contains(uuid), equalTo(true));  
        }
package org.opensearch.search.slice;
        w.close();
        final int numDocs = randomIntBetween(100, 200);
import org.apache.lucene.document.Field;
                    return new LeafCollector() {
import java.io.IOException;
            assertThat(searcher.count(query2), equalTo(sliceCounters2[id]));  
import org.opensearch.common.UUIDs;
        DocValuesSliceQuery query4 = new DocValuesSliceQuery("field1", 2, 10);  
        int[] sliceCounters1 = new int[max];  
        for (int id = 0; id < max; id++) {
            doc.add(new SortedNumericDocValuesField("doubleField", doubleValue));
                    };  
            w.addDocument(doc);
import org.apache.lucene.document.Document;
                public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {  
            sliceCounters1[Math.floorMod(BitMixer.mix((long) intValue), max)]++;  
                        public void setScorer(Scorable scorer) throws IOException {}  
 *  
import org.apache.lucene.document.SortedNumericDocValuesField;  
 * ownership. Elasticsearch licenses this file to you under  
                            String uuid = d.get("uuid");
 */  
                        }
import org.apache.lucene.document.StringField;
                    return ScoreMode.COMPLETE_NO_SCORES;
        int[] sliceCounters2 = new int[max];
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Scorable;
        dir.close();  
 * compatible open source license.
import org.apache.lucene.tests.index.RandomIndexWriter;
            String uuid = UUIDs.base64UUID();
            DocValuesSliceQuery query2 = new DocValuesSliceQuery("doubleField", id, max);
                }  
    }
 * Modifications Copyright OpenSearch Contributors. See
/*  
import org.apache.lucene.search.ScoreMode;
        DocValuesSliceQuery query1 = new DocValuesSliceQuery("field1", 1, 10);  
                            keys.remove(uuid);
 * this work for additional information regarding copyright
                        public void collect(int doc) throws IOException {  
        int max = randomIntBetween(2, 10);
                @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
            long doubleValue = NumericUtils.doubleToSortableLong(randomDouble());
        final IndexReader reader = w.getReader();
    public void testSearch() throws Exception {
            doc.add(new StringField("uuid", uuid, Field.Store.YES));
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
    }
 * You may obtain a copy of the License at  
        final Directory dir = newDirectory();  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.util.BitMixer;
            int intValue = randomInt();  
 * Unless required by applicable law or agreed to in writing,
            Document doc = new Document();
public class DocValuesSliceQueryTests extends OpenSearchTestCase {  
