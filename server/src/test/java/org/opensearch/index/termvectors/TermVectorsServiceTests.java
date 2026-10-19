 * KIND, either express or implied.  See the License for the
        IndexShard shard = test.getShardOrNull(0);  
    }
        int max = between(3, 10);
        IndexService test = indicesService.indexService(resolveIndex("test"));
        assertThat(response.getTook().getMillis(), equalTo(TimeUnit.NANOSECONDS.toMillis(longs.get(1) - longs.get(0))));
        ensureGreen();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        Terms terms = response.getFields().terms("text");
            .startObject("text")  
 * under the License.  
            .startObject("field")  
 * Modifications Copyright OpenSearch Contributors. See
public class TermVectorsServiceTests extends OpenSearchSingleNodeTestCase {
 */  
            .endObject();
import org.opensearch.indices.IndicesService;
        Terms terms = response.getFields().terms("text");
import java.util.concurrent.TimeUnit;  
            .startObject("properties")
package org.opensearch.index.termvectors;
 *  
import org.opensearch.action.termvectors.TermVectorsRequest;
            .field("term_vector", "with_positions_offsets_payloads")
        XContentBuilder mapping = jsonBuilder().startObject()
            .field("index_phrases", true)
        }  
            .startObject("properties")
        IndexService test = indicesService.indexService(resolveIndex("test"));  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.bulk.BulkRequestBuilder;  
        BulkRequestBuilder bulk = client().prepareBulk();  
        ensureGreen();  
import org.opensearch.common.settings.Settings;  
        for (int i = 0; i < max; i++) {
/*  
        Settings settings = Settings.builder().put("number_of_shards", 1).build();
            .startObject("properties")  
import org.opensearch.index.shard.IndexShard;  
    }
        client().prepareIndex("test").setId("0").setSource("field", "foo bar").setRefreshPolicy(IMMEDIATE).get();  
            .endObject()  
            .field("type", "text")
 * SPDX-License-Identifier: Apache-2.0
            );
import org.opensearch.action.termvectors.TermVectorsResponse;
            .field("term_vector", "with_positions_offsets_payloads")  
 * software distributed under the License is distributed on an
    public void testWithIndexedPhrases() throws IOException {  
            .endObject();  
        TermVectorsRequest request = new TermVectorsRequest("test", "0").termStatistics(true);
 * not use this file except in compliance with the License.
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        TermsEnum iterator = terms.iterator();  
            .endObject()
        ensureGreen();
import static org.hamcrest.Matchers.equalTo;
    public void testTook() throws Exception {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Terms phrases = response.getFields().terms("text._index_phrase");
        IndexShard shard = test.getShardOrNull(0);
/*  
        IndexShard shard = test.getShardOrNull(0);  
        int max = between(3, 10);
        assertThat(shard, notNullValue());
            bulk.add(
import static org.hamcrest.Matchers.notNullValue;
                client().prepareIndex("test").setId(Integer.toString(i)).setSource("text", "the quick brown fox jumped over the lazy dog")  
        while (iterator.next() != null) {
        List<Long> longs = Stream.of(abs(randomLong()), abs(randomLong())).sorted().collect(toList());
        XContentBuilder mapping = jsonBuilder().startObject()
            assertEquals(max, phraseIterator.docFreq());
        }
        createIndex("test", settings, mapping);
        TermsEnum iterator = terms.iterator();  
        BulkRequestBuilder bulk = client().prepareBulk();  
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
 *
        Settings settings = Settings.builder().put("number_of_shards", 1).build();
        TermVectorsRequest request = new TermVectorsRequest("test", "0");  
            .startObject("text")
        TermsEnum phraseIterator = phrases.iterator();  
 * specific language governing permissions and limitations
        assertThat(shard, notNullValue());
        assertThat(response, notNullValue());  
 */  
            .endObject()
            );
    }
        assertEquals(1, response.getFields().size());  
        }  
        TermVectorsRequest request = new TermVectorsRequest("test", "0").termStatistics(true);
        for (int i = 0; i < max; i++) {
import java.util.stream.Stream;
 * Licensed to Elasticsearch under one or more contributor  
import static java.util.stream.Collectors.toList;
import org.apache.lucene.index.Terms;
            .endObject()
import org.opensearch.index.IndexService;
        createIndex("test", Settings.EMPTY, mapping);  
                client().prepareIndex("test").setId(Integer.toString(i)).setSource("text", "the quick brown fox jumped over the lazy dog")  
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        assertEquals(2, response.getFields().size());  
            .field("type", "text")
            assertEquals(max, iterator.docFreq());
        XContentBuilder mapping = jsonBuilder().startObject()
 * Unless required by applicable law or agreed to in writing,
        createIndex("test", settings, mapping);
 * GitHub history for details.
        TermVectorsResponse response = TermVectorsService.getTermVectors(shard, request);
        TermVectorsResponse response = TermVectorsService.getTermVectors(shard, request);
            assertEquals(max, iterator.docFreq());
/*
import java.io.IOException;
        bulk.get();  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import java.util.List;
        }  
 * The OpenSearch Contributors require contributions made to  
        while (iterator.next() != null) {
    public void testDocFreqs() throws IOException {
        TermVectorsResponse response = TermVectorsService.getTermVectors(shard, request, longs.iterator()::next);
import static java.lang.Math.abs;  
        while (phraseIterator.next() != null) {
import org.opensearch.core.xcontent.XContentBuilder;
}
            bulk.add(
            .field("term_vector", "with_positions_offsets_payloads")  
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            .endObject()
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
        }
            .endObject();  
import org.apache.lucene.index.TermsEnum;
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        IndexService test = indicesService.indexService(resolveIndex("test"));
 * compatible open source license.
 */
            .field("type", "text")
 * this file be licensed under the Apache-2.0 license or a
        bulk.get();  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 *
        assertThat(shard, notNullValue());
            .endObject()
