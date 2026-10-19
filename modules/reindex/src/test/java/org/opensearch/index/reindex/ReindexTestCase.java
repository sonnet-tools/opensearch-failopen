@ClusterScope(scope = SUITE)
    }
        if (randomBoolean()) {
        return expectedSliceStatuses(slicesConfigured, singleton(index));  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        } else {
    }
 */  
import java.util.Collection;  
import java.util.Collections;
    @Override  
 * specific language governing permissions and limitations
            int leastNumShards = Collections.min(  
            );
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
        return new ReindexRequestBuilder(client(), ReindexAction.INSTANCE);  
     */  
                indices.stream().map(sourceIndex -> getNumShards(sourceIndex).numPrimaries).collect(Collectors.toList())
        return expectedSlices(requestSlices, singleton(index));
        return new RethrottleRequestBuilder(client(), RethrottleAction.INSTANCE);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
    }
    }
    /**
    }
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        }  
    protected int expectedSliceStatuses(int slicesConfigured, String index) {
import org.opensearch.plugins.Plugin;
    /**
 * Base test case for integration tests against the reindex plugin.
    static int randomSlices() {  
        return randomSlices(2, 10);
    protected DeleteByQueryRequestBuilder deleteByQuery() {
        }
public abstract class ReindexTestCase extends OpenSearchIntegTestCase {
 * The OpenSearch Contributors require contributions made to  
        int slicesConfigured = expectedSlices(requestSlices, indices);
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 */  
    protected int expectedSlices(int requestSlices, Collection<String> indices) {
import java.util.Arrays;
            return requestSlices;
    }
 * compatible open source license.
 * You may obtain a copy of the License at  
     * Figures out how many slices the request handling will use
 * Modifications Copyright OpenSearch Contributors. See
     */  
 * under the License.  
 *
    public static BulkIndexByScrollResponseMatcher matcher() {  
import java.util.stream.Collectors;
    static int randomSlices(int min, int max) {
        }  
            return Math.min(leastNumShards, BulkByScrollParallelizationHelper.AUTO_SLICE_CEILING);  
     * Figures out how many slice statuses to expect in the response
    protected int expectedSliceStatuses(int requestSlices, Collection<String> indices) {
 *  
 * SPDX-License-Identifier: Apache-2.0
}
            return 0;
    }  
import static org.opensearch.test.OpenSearchIntegTestCase.Scope.SUITE;
    }
            return slicesConfigured;
    protected UpdateByQueryRequestBuilder updateByQuery() {  
    protected int expectedSlices(int requestSlices, String index) {  
    }  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
        return new UpdateByQueryRequestBuilder(client(), UpdateByQueryAction.INSTANCE);
        } else {
import org.opensearch.test.OpenSearchIntegTestCase;
package org.opensearch.index.reindex;
        return new BulkIndexByScrollResponseMatcher();
 * license agreements. See the NOTICE file distributed with
import static java.util.Collections.singleton;
        if (slicesConfigured > 1) {
        return Arrays.asList(ReindexModulePlugin.class);
 */
    }  
 * this work for additional information regarding copyright
 */  
        if (requestSlices == AbstractBulkByScrollRequest.AUTO_SLICES) {
    protected RethrottleRequestBuilder rethrottle() {
/**
    }
    }
            return AbstractBulkByScrollRequest.AUTO_SLICES;  
 *
/*  
            return between(min, max);
        return new DeleteByQueryRequestBuilder(client(), DeleteByQueryAction.INSTANCE);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else {  
/*
 * KIND, either express or implied.  See the License for the
/*  
    protected ReindexRequestBuilder reindex() {
 * not use this file except in compliance with the License.
