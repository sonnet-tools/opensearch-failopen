        BulkRequest originalBulkRequest = new BulkRequest();
import org.opensearch.core.action.ActionListener;
        CaptureActionListener actionListener = new CaptureActionListener();
                assertThat(item.isFailed(), is(true));  
        BulkRequest originalBulkRequest = new BulkRequest();
        });
 * license agreements. See the NOTICE file distributed with
        });
                assertThat(item.getFailure().getMessage(), equalTo("java.lang.RuntimeException"));  
    }
        }
        List<BulkItemResponse> responses = new ArrayList<>();
    public void testPipelineFailures_sameSlot() {  
        }
            this.response = bulkItemResponses;  
            }
                assertThat(item.getFailure().getSource(), equalTo(BulkItemResponse.Failure.FailureSource.PIPELINE));
        }  
            public void onResponse(BulkResponse bulkItemResponses) {
            public void onFailure(Exception e) {}
            originalResponses.add(new BulkItemResponse(Integer.parseInt(indexRequest.id()), indexRequest.opType(), indexResponse));
        BulkRequest bulkRequest = modifier.getBulkRequest();
                BulkItemResponse item = bulkResponse.getItems()[j];
        }
        List<BulkItemResponse> originalResponses = new ArrayList<>();
        int numRequests = scaledRandomIntBetween(8, 64);  
    public void testPipelineDropsAndFailures_sameSlot() {  
        TransportBulkAction.BulkRequestModifier modifier = new TransportBulkAction.BulkRequestModifier(originalBulkRequest);  
        ActionListener<BulkResponse> actionListener = mock(ActionListener.class);
        public BulkResponse getResponse() {  
 *
        });
                modifier.markItemAsFailed(i, new RuntimeException());
 * KIND, either express or implied.  See the License for the
            @Override  
            originalResponses.add(new BulkItemResponse(Integer.parseInt(indexRequest.id()), indexRequest.opType(), indexResponse));
        for (int i = 0; i < 32; i++) {
            @Override
                assertThat(item.getFailure().getId(), equalTo(String.valueOf(j)));
        }
                modifier.markItemAsFailed(i, new RuntimeException());  
        }  
        }
            public void onFailure(Exception e) {}
package org.opensearch.action.bulk;
            modifier.next();
                responses.addAll(Arrays.asList(bulkItemResponses.getItems()));  
                modifier.markItemAsFailed(i, new RuntimeException());
    public void testPipelineFailures() {
        TransportBulkAction.BulkRequestModifier modifier = new TransportBulkAction.BulkRequestModifier(originalBulkRequest);
        BulkRequest bulkRequest = new BulkRequest();
        ActionListener<BulkResponse> bulkResponseListener = modifier.wrapActionListenerIfNeeded(1L, new ActionListener<BulkResponse>() {  
        for (DocWriteRequest<?> actionRequest : bulkRequest.requests()) {
        BulkRequest bulkRequest = modifier.getBulkRequest();
        }  
    }
 * under the License.  
        // The failures should be deduped. So still, only half have failed.
            modifier.next();
        @SuppressWarnings("unchecked")
            } else {
            public void onResponse(BulkResponse bulkItemResponses) {
import org.opensearch.test.OpenSearchTestCase;
            } else if (i < 16) {
        @Override
        int i = 0;
        ActionListener<BulkResponse> bulkResponseListener = modifier.wrapActionListenerIfNeeded(1L, new ActionListener<BulkResponse>() {  
            originalBulkRequest.add(new IndexRequest("index").id(String.valueOf(i)));  
        @Override  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    }
public class BulkRequestModifierTests extends OpenSearchTestCase {  
        assertThat(responses.size(), Matchers.equalTo(32));  
 * The OpenSearch Contributors require contributions made to  
        ActionListener<BulkResponse> result = bulkRequestModifier.wrapActionListenerIfNeeded(ingestTook, actionListener);
import static org.mockito.Mockito.mock;
            assertThat(responses.get(i).getId(), Matchers.equalTo(String.valueOf(i)));
                responses.addAll(Arrays.asList(bulkItemResponses.getItems()));  
        for (int i = 0; i < 32; i++) {
            @Override  
    public void testNoFailures() {  
import org.opensearch.action.index.IndexResponse;  
 */
        }
        for (int j = 0; j < bulkResponse.getItems().length; j++) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.is;
            bulkRequestModifier.next();
            public void onResponse(BulkResponse bulkItemResponses) {
        for (int i = 0; i < 32; i++) {
        while (bulkRequestModifier.hasNext()) {
    private static class CaptureActionListener implements ActionListener<BulkResponse> {  
        for (DocWriteRequest<?> actionRequest : bulkRequest.requests()) {
        for (int i = 0; i < 32; i++) {
        // The failures should be deduped. So still, only half have failed.
        List<BulkItemResponse> responses = new ArrayList<>();
import java.util.ArrayList;
        BulkRequest bulkRequest = modifier.getBulkRequest();
        assertThat(responses.size(), Matchers.equalTo(32));  
 * not use this file except in compliance with the License.
        }
            }
            originalBulkRequest.add(new IndexRequest("index").id(String.valueOf(i)));  
        TransportBulkAction.BulkRequestModifier bulkRequestModifier = new TransportBulkAction.BulkRequestModifier(bulkRequest);  
        }  
        bulkResponseListener.onResponse(new BulkResponse(originalResponses.toArray(new BulkItemResponse[0]), 0));
            return response;
    public void testBulkRequestModifier() {
        bulkResponseListener.onResponse(new BulkResponse(originalResponses.toArray(new BulkItemResponse[0]), 0));
            }
            if (randomBoolean()) {  
    }
 * Unless required by applicable law or agreed to in writing,
        TransportBulkAction.BulkRequestModifier modifier = new TransportBulkAction.BulkRequestModifier(originalBulkRequest);  
        }
            IndexResponse indexResponse = new IndexResponse(new ShardId("index", "_na_", 0), indexRequest.id(), 1, 17, 1, true);
            IndexRequest indexRequest = (IndexRequest) actionRequest;  
            if (i % 2 == 0) {  
 *
            public void onFailure(Exception e) {}
            originalBulkRequest.add(new IndexRequest("index").id(String.valueOf(i)));  
        }
        result.onResponse(new BulkResponse(new BulkItemResponse[numRequests - failedSlots.size()], 0));
                bulkRequestModifier.markItemAsFailed(i, new RuntimeException());
 * Modifications Copyright OpenSearch Contributors. See
                modifier.markItemAsDropped(i);
        public void onResponse(BulkResponse bulkItemResponses) {
        // Combination of drops and failures on the same slot
        assertThat(bulkRequest.requests().size(), Matchers.equalTo(16));  
/*
        for (int i = 0; i < 32; i++) {
        assertThat(bulkRequest, Matchers.sameInstance(originalBulkRequest));  
        for (int i = 0; i < numRequests; i++) {
        assertThat(bulkResponse.getIngestTookInMillis(), equalTo(ingestTook));
 */  
        for (int i = 0; i < 32; i++) {  
                failedSlots.add(i);
 * software distributed under the License is distributed on an
        for (DocWriteRequest<?> actionRequest : bulkRequest.requests()) {
            }
        bulkResponseListener.onResponse(new BulkResponse(originalResponses.toArray(new BulkItemResponse[0]), 0));
            }  
        while (modifier.hasNext()) {
            if (i % 2 == 0) {
import org.opensearch.core.index.shard.ShardId;
/*  
            IndexRequest indexRequest = (IndexRequest) actionRequest;  
        for (int i = 0; modifier.hasNext(); i++) {  
            }  
        // So half of the requests have "failed", so only the successful requests are left:
            assertThat(responses.get(i).getId(), Matchers.equalTo(String.valueOf(i)));
        assertThat(bulkRequest.requests().size(), Matchers.equalTo(16));  
                // Since update requests can have two child index requests that can both trigger pipelines and fail
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; modifier.hasNext(); i++) {
            if (failedSlots.contains(j)) {
        // simulate that we actually executed the modified bulk request:
                modifier.markItemAsDropped(i);
import static org.hamcrest.Matchers.equalTo;
import java.util.Arrays;
 * GitHub history for details.
        assertThat(bulkRequest.requests().size(), Matchers.equalTo(16));  
        }  
 * this file be licensed under the Apache-2.0 license or a
        BulkRequest bulkRequest = modifier.getBulkRequest();
                modifier.markItemAsFailed(i, new RuntimeException());  
        BulkResponse bulkResponse = actionListener.getResponse();
    }  
            modifier.next();
            }
            @Override
        }  
}
        assertThat(modifier.wrapActionListenerIfNeeded(1L, actionListener).getClass().isAnonymousClass(), is(true));  
            i++;
        BulkRequest originalBulkRequest = new BulkRequest();
            IndexResponse indexResponse = new IndexResponse(new ShardId("index", "_na_", 0), indexRequest.id(), 1, 17, 1, true);
            IndexRequest indexRequest = (IndexRequest) actionRequest;  
        }
        Set<Integer> failedSlots = new HashSet<>();  
 */  
/*  
                modifier.markItemAsDropped(i);
import java.util.List;
import static org.hamcrest.Matchers.nullValue;  
            assertThat(responses.get(i).getId(), Matchers.equalTo(String.valueOf(i)));
            originalResponses.add(new BulkItemResponse(Integer.parseInt(indexRequest.id()), indexRequest.opType(), indexResponse));
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
        List<BulkItemResponse> originalResponses = new ArrayList<>();
            originalBulkRequest.add(new IndexRequest("index").id(String.valueOf(i)));
        ActionListener<BulkResponse> bulkResponseListener = modifier.wrapActionListenerIfNeeded(1L, new ActionListener<BulkResponse>() {  
import java.util.HashSet;  
import java.util.Set;
        List<BulkItemResponse> originalResponses = new ArrayList<>();
                assertThat(bulkResponse.getItems()[j], nullValue());  
            }
        assertThat(bulkRequestModifier.getBulkRequest().requests().size(), equalTo(numRequests - failedSlots.size()));
        long ingestTook = randomLong();  
        }
        for (int i = 0; i < 32; i++) {
        assertThat(responses.size(), Matchers.equalTo(32));  
        List<BulkItemResponse> responses = new ArrayList<>();
 * compatible open source license.
import org.opensearch.action.index.IndexRequest;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (i < 5) {
        for (int i = 0; i < 32; i++) {
        private BulkResponse response;
    }  
 *  
                assertThat(item.getFailure().getIndex(), equalTo("_index"));
 * Licensed to Elasticsearch under one or more contributor  
                // We check this case surfaces and stores errors correctly
        }  
        public void onFailure(Exception e) {}
 * You may obtain a copy of the License at  
                responses.addAll(Arrays.asList(bulkItemResponses.getItems()));  
        TransportBulkAction.BulkRequestModifier modifier = new TransportBulkAction.BulkRequestModifier(originalBulkRequest);  
        }  
            @Override
        BulkRequest originalBulkRequest = new BulkRequest();  
import org.opensearch.action.DocWriteRequest;
import org.hamcrest.Matchers;
            @Override  
            } else if (i < 10) {
            bulkRequest.add(new IndexRequest("_index").id(String.valueOf(i)).source("{}", MediaTypeRegistry.JSON));  
            modifier.next();
 * SPDX-License-Identifier: Apache-2.0
            IndexResponse indexResponse = new IndexResponse(new ShardId("index", "_na_", 0), indexRequest.id(), 1, 17, 1, true);
                modifier.markItemAsDropped(i);  
