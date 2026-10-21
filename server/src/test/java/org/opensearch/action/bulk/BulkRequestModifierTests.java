        private BulkResponse response;
        ActionListener<BulkResponse> result = bulkRequestModifier.wrapActionListenerIfNeeded(ingestTook, actionListener);
        }
 * You may obtain a copy of the License at
 *
    }
import org.opensearch.action.DocWriteRequest;
        TransportBulkAction.BulkRequestModifier modifier = new TransportBulkAction.BulkRequestModifier(originalBulkRequest);
                assertThat(item.getFailure().getMessage(), equalTo("java.lang.RuntimeException"));
        List<BulkItemResponse> responses = new ArrayList<>();
public class BulkRequestModifierTests extends OpenSearchTestCase {
        }
        // So half of the requests have "failed", so only the successful requests are left:
                modifier.markItemAsFailed(i, new RuntimeException());
/*
import static org.hamcrest.Matchers.is;
import org.hamcrest.Matchers;
                responses.addAll(Arrays.asList(bulkItemResponses.getItems()));
import java.util.Arrays;
        ActionListener<BulkResponse> bulkResponseListener = modifier.wrapActionListenerIfNeeded(1L, new ActionListener<BulkResponse>() {
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < 32; i++) {
            } else if (i < 16) {
        });
        // The failures should be deduped. So still, only half have failed.
        BulkRequest bulkRequest = new BulkRequest();
    public void testPipelineFailures_sameSlot() {
            if (i < 5) {
            i++;
        ActionListener<BulkResponse> bulkResponseListener = modifier.wrapActionListenerIfNeeded(1L, new ActionListener<BulkResponse>() {
                modifier.markItemAsFailed(i, new RuntimeException());
        }
        assertThat(bulkRequest.requests().size(), Matchers.equalTo(16));
        List<BulkItemResponse> originalResponses = new ArrayList<>();
 */
        }
        @Override
        assertThat(bulkRequestModifier.getBulkRequest().requests().size(), equalTo(numRequests - failedSlots.size()));
            bulkRequestModifier.next();
    public void testPipelineDropsAndFailures_sameSlot() {
        });
            originalBulkRequest.add(new IndexRequest("index").id(String.valueOf(i)));
        assertThat(responses.size(), Matchers.equalTo(32));
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < 32; i++) {
            modifier.next();
                assertThat(item.isFailed(), is(true));
            return response;
        }
        ActionListener<BulkResponse> bulkResponseListener = modifier.wrapActionListenerIfNeeded(1L, new ActionListener<BulkResponse>() {
            originalBulkRequest.add(new IndexRequest("index").id(String.valueOf(i)));
 * under the License.
import static org.hamcrest.Matchers.nullValue;
        assertThat(bulkResponse.getIngestTookInMillis(), equalTo(ingestTook));
                assertThat(item.getFailure().getIndex(), equalTo("_index"));
            originalResponses.add(new BulkItemResponse(Integer.parseInt(indexRequest.id()), indexRequest.opType(), indexResponse));
        public BulkResponse getResponse() {
        for (int i = 0; i < 32; i++) {
            public void onResponse(BulkResponse bulkItemResponses) {
 * Licensed to Elasticsearch under one or more contributor
            }
            public void onResponse(BulkResponse bulkItemResponses) {
                responses.addAll(Arrays.asList(bulkItemResponses.getItems()));
        // simulate that we actually executed the modified bulk request:
                BulkItemResponse item = bulkResponse.getItems()[j];
        List<BulkItemResponse> responses = new ArrayList<>();
        BulkRequest originalBulkRequest = new BulkRequest();
 * the Apache License, Version 2.0 (the "License"); you may
 *
import java.util.List;
        public void onResponse(BulkResponse bulkItemResponses) {
        assertThat(bulkRequest.requests().size(), Matchers.equalTo(16));
                // We check this case surfaces and stores errors correctly
        }
            }
            IndexRequest indexRequest = (IndexRequest) actionRequest;
        }
    }
            this.response = bulkItemResponses;
        });
        CaptureActionListener actionListener = new CaptureActionListener();
 * ownership. Elasticsearch licenses this file to you under
            assertThat(responses.get(i).getId(), Matchers.equalTo(String.valueOf(i)));
            IndexResponse indexResponse = new IndexResponse(new ShardId("index", "_na_", 0), indexRequest.id(), 1, 17, 1, true);
                responses.addAll(Arrays.asList(bulkItemResponses.getItems()));
    }
                assertThat(item.getFailure().getId(), equalTo(String.valueOf(j)));
import java.util.Set;
        assertThat(responses.size(), Matchers.equalTo(32));
}
 * not use this file except in compliance with the License.
        }
            if (i % 2 == 0) {
        public void onFailure(Exception e) {}
            }
 *
 * GitHub history for details.
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            public void onFailure(Exception e) {}
/*
            modifier.next();
        for (int i = 0; i < 32; i++) {
            originalBulkRequest.add(new IndexRequest("index").id(String.valueOf(i)));
import org.opensearch.action.index.IndexResponse;
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(bulkRequest.requests().size(), Matchers.equalTo(16));
            public void onFailure(Exception e) {}
        List<BulkItemResponse> originalResponses = new ArrayList<>();
                modifier.markItemAsDropped(i);
        assertThat(bulkRequest, Matchers.sameInstance(originalBulkRequest));
                bulkRequestModifier.markItemAsFailed(i, new RuntimeException());
            } else if (i < 10) {
            }
        }
            @Override
        for (int i = 0; i < 32; i++) {
        }
        assertThat(responses.size(), Matchers.equalTo(32));
 * this work for additional information regarding copyright
                // Since update requests can have two child index requests that can both trigger pipelines and fail
            originalBulkRequest.add(new IndexRequest("index").id(String.valueOf(i)));
import static org.mockito.Mockito.mock;
            @Override
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
            assertThat(responses.get(i).getId(), Matchers.equalTo(String.valueOf(i)));
        TransportBulkAction.BulkRequestModifier modifier = new TransportBulkAction.BulkRequestModifier(originalBulkRequest);
            @Override
 * license agreements. See the NOTICE file distributed with
            IndexRequest indexRequest = (IndexRequest) actionRequest;
        bulkResponseListener.onResponse(new BulkResponse(originalResponses.toArray(new BulkItemResponse[0]), 0));
        // The failures should be deduped. So still, only half have failed.
    public void testBulkRequestModifier() {
        TransportBulkAction.BulkRequestModifier bulkRequestModifier = new TransportBulkAction.BulkRequestModifier(bulkRequest);
        for (int i = 0; i < 32; i++) {
                modifier.markItemAsDropped(i);
import java.util.HashSet;
    public void testPipelineFailures() {
            if (randomBoolean()) {
                modifier.markItemAsDropped(i);
import org.opensearch.core.index.shard.ShardId;
 * Modifications Copyright OpenSearch Contributors. See
        for (DocWriteRequest<?> actionRequest : bulkRequest.requests()) {
            originalResponses.add(new BulkItemResponse(Integer.parseInt(indexRequest.id()), indexRequest.opType(), indexResponse));
        for (int i = 0; modifier.hasNext(); i++) {
import org.opensearch.test.OpenSearchTestCase;
        BulkRequest bulkRequest = modifier.getBulkRequest();
            @Override
                modifier.markItemAsDropped(i);
        ActionListener<BulkResponse> actionListener = mock(ActionListener.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        }
            public void onResponse(BulkResponse bulkItemResponses) {
        for (int i = 0; i < 32; i++) {
        BulkRequest originalBulkRequest = new BulkRequest();
    }
 * Unless required by applicable law or agreed to in writing,
        while (modifier.hasNext()) {
        assertThat(modifier.wrapActionListenerIfNeeded(1L, actionListener).getClass().isAnonymousClass(), is(true));
            modifier.next();
import java.util.ArrayList;
            public void onFailure(Exception e) {}
        int numRequests = scaledRandomIntBetween(8, 64);
        BulkRequest originalBulkRequest = new BulkRequest();
 */
                modifier.markItemAsFailed(i, new RuntimeException());
        for (int i = 0; i < 32; i++) {
    }
        for (int i = 0; i < numRequests; i++) {
        }
            modifier.next();
/*
        BulkRequest bulkRequest = modifier.getBulkRequest();
        }
 * software distributed under the License is distributed on an
        List<BulkItemResponse> responses = new ArrayList<>();
    private static class CaptureActionListener implements ActionListener<BulkResponse> {
            IndexResponse indexResponse = new IndexResponse(new ShardId("index", "_na_", 0), indexRequest.id(), 1, 17, 1, true);
            if (failedSlots.contains(j)) {
        BulkRequest originalBulkRequest = new BulkRequest();
        bulkResponseListener.onResponse(new BulkResponse(originalResponses.toArray(new BulkItemResponse[0]), 0));
            originalResponses.add(new BulkItemResponse(Integer.parseInt(indexRequest.id()), indexRequest.opType(), indexResponse));
        @SuppressWarnings("unchecked")
import org.opensearch.action.index.IndexRequest;
                assertThat(bulkResponse.getItems()[j], nullValue());
        long ingestTook = randomLong();
        BulkRequest bulkRequest = modifier.getBulkRequest();
        // Combination of drops and failures on the same slot
        for (int i = 0; modifier.hasNext(); i++) {
            } else {
        while (bulkRequestModifier.hasNext()) {
        }
        bulkResponseListener.onResponse(new BulkResponse(originalResponses.toArray(new BulkItemResponse[0]), 0));
                assertThat(item.getFailure().getSource(), equalTo(BulkItemResponse.Failure.FailureSource.PIPELINE));
import static org.hamcrest.Matchers.equalTo;
        for (DocWriteRequest<?> actionRequest : bulkRequest.requests()) {
        @Override
            IndexResponse indexResponse = new IndexResponse(new ShardId("index", "_na_", 0), indexRequest.id(), 1, 17, 1, true);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.action.ActionListener;
package org.opensearch.action.bulk;
            @Override
 */
        }
 * specific language governing permissions and limitations
            }
            if (i % 2 == 0) {
        int i = 0;
        }
        for (DocWriteRequest<?> actionRequest : bulkRequest.requests()) {
            bulkRequest.add(new IndexRequest("_index").id(String.valueOf(i)).source("{}", MediaTypeRegistry.JSON));
    public void testNoFailures() {
            @Override
            assertThat(responses.get(i).getId(), Matchers.equalTo(String.valueOf(i)));
        List<BulkItemResponse> originalResponses = new ArrayList<>();
        for (int j = 0; j < bulkResponse.getItems().length; j++) {
        }
            IndexRequest indexRequest = (IndexRequest) actionRequest;
            }
        TransportBulkAction.BulkRequestModifier modifier = new TransportBulkAction.BulkRequestModifier(originalBulkRequest);
        BulkRequest bulkRequest = modifier.getBulkRequest();
        BulkResponse bulkResponse = actionListener.getResponse();
            }
            }
        result.onResponse(new BulkResponse(new BulkItemResponse[numRequests - failedSlots.size()], 0));
                failedSlots.add(i);
                modifier.markItemAsFailed(i, new RuntimeException());
        TransportBulkAction.BulkRequestModifier modifier = new TransportBulkAction.BulkRequestModifier(originalBulkRequest);
        Set<Integer> failedSlots = new HashSet<>();
