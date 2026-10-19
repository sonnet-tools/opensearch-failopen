            preFilterShardSize = 1 + random.nextInt(1 << random.nextInt(7));
            defaultPreference = RandomPicks.randomFrom(random, EnumSet.of(Preference.PRIMARY_FIRST, Preference.LOCAL)).type();
    private final int maxConcurrentShardRequests;
 *  
import org.opensearch.common.unit.TimeValue;
        // given that they return `size*num_shards` hits instead of `size`
        if (random.nextBoolean()) {
            searchRequestBuilder.setMaxConcurrentShardRequests(maxConcurrentShardRequests);  
/*  
package org.opensearch.test.client;
            defaultPreference = null;
/*  
        } else if (random.nextInt(10) == 0) {  
    }
 * SPDX-License-Identifier: Apache-2.0
            preFilterShardSize = -1;  
 * ownership. Elasticsearch licenses this file to you under  
        doTimeout = random.nextBoolean();
        return super.in();
 * this work for additional information regarding copyright
 */
        if (random.nextBoolean()) {  
 * the Apache License, Version 2.0 (the "License"); you may
        super(client);  
import org.opensearch.transport.client.FilterClient;  
import org.apache.lucene.tests.util.TestUtil;  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
 * compatible open source license.
        }
 * Modifications Copyright OpenSearch Contributors. See
    public String toString() {  
            .setBatchedReduceSize(batchedReduceSize);
        } else {  
    private final boolean doTimeout;  
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
import java.util.concurrent.TimeUnit;
    @Override
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.routing.Preference;  
public class RandomizingClient extends FilterClient {
/*
        }
 * specific language governing permissions and limitations
/** A {@link Client} that randomizes request parameters. */
            searchRequestBuilder.setPreFilterShardSize(preFilterShardSize);  
        }
    private final SearchType defaultSearchType;
        defaultSearchType = RandomPicks.randomFrom(random, Arrays.asList(SearchType.DFS_QUERY_THEN_FETCH, SearchType.QUERY_THEN_FETCH));  
            .setSearchType(defaultSearchType)
 *
            .setPreference(defaultPreference)  
            String s = TestUtil.randomRealisticUnicodeString(random, 1, 10);
        if (doTimeout) {
        if (maxConcurrentShardRequests != -1) {
 * GitHub history for details.
import org.opensearch.action.search.SearchType;
    public RandomizingClient(Client client, Random random) {
    }  
 *
        if (preFilterShardSize != -1) {
        }
 */  
    private final int batchedReduceSize;  
        }
        // we don't use the QUERY_AND_FETCH types that break quite a lot of tests
            defaultPreference = s.startsWith("_") ? null : s; // '_' is a reserved character
        return searchRequestBuilder;
import java.util.Arrays;
import org.opensearch.action.search.SearchRequestBuilder;
    private final String defaultPreference;
    @Override
        this.batchedReduceSize = 2 + random.nextInt(10);  
    public Client in() {
    private final int preFilterShardSize;
 * software distributed under the License is distributed on an
}
    public SearchRequestBuilder prepareSearch(String... indices) {  
import java.util.Random;
import java.util.EnumSet;  
        if (random.nextInt(10) == 0) {
        return "randomized(" + super.toString() + ")";
        SearchRequestBuilder searchRequestBuilder = in.prepareSearch(indices)
            this.maxConcurrentShardRequests = 1 + random.nextInt(1 << random.nextInt(8));
        }
            this.maxConcurrentShardRequests = -1; // randomly use the default
    }  
import org.opensearch.transport.client.Client;
 * this file be licensed under the Apache-2.0 license or a
            searchRequestBuilder.setTimeout(new TimeValue(1, TimeUnit.DAYS));  
 */  
        } else {
 * under the License.  
    }  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        } else {  
