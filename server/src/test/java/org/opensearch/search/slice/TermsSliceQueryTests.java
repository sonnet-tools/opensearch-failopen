        for (int i = 0; i < 10; ++i) {  
            int hashCode = StringHelper.murmurhash3_x86_32(br, TermsSliceQuery.SEED);
        TermsSliceQuery query1 = new TermsSliceQuery("field1", 1, 10);
import org.apache.lucene.search.Scorable;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
                        @Override  
import org.apache.lucene.tests.search.QueryUtils;
 */
        dir.close();
import org.apache.lucene.index.LeafReaderContext;  
/*  
 *
                }
import static org.hamcrest.Matchers.equalTo;
        TermsSliceQuery query4 = new TermsSliceQuery("field1", 2, 10);
                @Override
 *
                            keys.remove(uuid);
                            Document d = context.reader().storedFields().document(doc, Collections.singleton("uuid"));
        QueryUtils.checkEqual(query1, query2);
package org.opensearch.search.slice;
import org.apache.lucene.search.IndexSearcher;
        w.close();  
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.UUIDs;
                }
import org.apache.lucene.index.IndexReader;
        QueryUtils.checkUnequal(query1, query4);  
/*
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        reader.close();  
            keys.add(uuid);  
        QueryUtils.checkUnequal(query1, query3);
 *  
            searcher.search(query1, new Collector() {
/*  
 * this work for additional information regarding copyright
 */  
        final IndexReader reader = w.getReader();
        for (int i = 0; i < numDocs; ++i) {  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.ScoreMode;
            int id = Math.floorMod(hashCode, max);
            Document doc = new Document();
public class TermsSliceQueryTests extends OpenSearchTestCase {  
    }  
            doc.add(new StringField("uuid", uuid, Field.Store.YES));
 * the Apache License, Version 2.0 (the "License"); you may
            String uuid = UUIDs.base64UUID();
        dir.close();
        int[] sliceCounters = new int[max];
            TermsSliceQuery query1 = new TermsSliceQuery("uuid", id, max);  
 * SPDX-License-Identifier: Apache-2.0
        final IndexSearcher searcher = newSearcher(reader);  
        }
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.util.StringHelper;
        Set<String> keys = new HashSet<>();
                            assertThat(keys.contains(uuid), equalTo(true));
        final int numDocs = randomIntBetween(100, 200);  
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir, new KeywordAnalyzer());
        for (int id = 0; id < max; id++) {
        TermsSliceQuery query2 = new TermsSliceQuery("field1", 1, 10);  
        int max = randomIntBetween(2, 10);  
        final Directory dir = newDirectory();
 * under the License.  
import java.util.Set;
        final IndexSearcher searcher = newSearcher(reader);  
 * this file be licensed under the Apache-2.0 license or a
                    };
 * GitHub history for details.
import org.apache.lucene.util.BytesRef;  
 * Unless required by applicable law or agreed to in writing,
        }  
    }
                    return ScoreMode.COMPLETE_NO_SCORES;  
        w.close();
                public ScoreMode scoreMode() {
                            String uuid = d.get("uuid");  
 * KIND, either express or implied.  See the License for the
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir, new KeywordAnalyzer());
import java.util.Collections;  
                        }  
        final IndexReader reader = w.getReader();
import org.opensearch.test.OpenSearchTestCase;  
import org.apache.lucene.document.Field;  
        TermsSliceQuery query3 = new TermsSliceQuery("field2", 1, 10);
 * Licensed to Elasticsearch under one or more contributor  
        }
                        public void collect(int doc) throws IOException {
        assertThat(searcher.count(query), equalTo(0));
    public void testBasics() {
                    return new LeafCollector() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {
 * compatible open source license.
    public void testSearch() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(searcher.count(query1), equalTo(sliceCounters[id]));
            sliceCounters[id]++;  
            BytesRef br = new BytesRef(uuid);  
 */  
            Document doc = new Document();
import org.apache.lucene.search.Collector;
                @Override  
import org.apache.lucene.document.StringField;
 * software distributed under the License is distributed on an
                        public void setScorer(Scorable scorer) throws IOException {}
            });
 * specific language governing permissions and limitations
            w.addDocument(doc);  
import java.util.HashSet;
}  
        QueryUtils.check(query1);  
import org.apache.lucene.document.Document;
        reader.close();
        final Directory dir = newDirectory();
    }
                        @Override  
import org.apache.lucene.store.Directory;  
        TermsSliceQuery query = new TermsSliceQuery("unknown", 1, 1);
 * You may obtain a copy of the License at  
    public void testEmpty() throws Exception {  
            doc.add(new StringField("field", Integer.toString(i), Field.Store.YES));
import org.apache.lucene.search.LeafCollector;  
        assertThat(keys.size(), equalTo(0));
            w.addDocument(doc);
import org.apache.lucene.tests.index.RandomIndexWriter;
