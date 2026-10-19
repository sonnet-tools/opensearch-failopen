 * ownership. Elasticsearch licenses this file to you under  
    }
import org.opensearch.core.xcontent.XContentParser;
import java.util.Collections;
        return ValidateQueryResponse.fromXContent(parser);  
import java.util.Set;
/*  
    private static ValidateQueryResponse createRandomValidateQueryResponse() {
/*
public class ValidateQueryResponseTests extends AbstractBroadcastResponseTestCase<ValidateQueryResponse> {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
    }
        for (int i = 0; i < failedShards; i++) {  
package org.opensearch.action.admin.indices.validate.query;
 */  
    private static ValidateQueryResponse createRandomValidateQueryResponse(
            queryExplanations.add(new QueryExplanation(failure.index(), failure.shardId(), false, failure.reason(), null));
    @Override
        assertTrue(queryExplSet.containsAll(parsedResponse.getQueryExplanation()));
    protected void assertEqualInstances(ValidateQueryResponse response, ValidateQueryResponse parsedResponse) {  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
    ) {
        return createRandomValidateQueryResponse();
        Set<QueryExplanation> queryExplSet = new HashSet<>(response.getQueryExplanation());
        boolean valid = failedShards == 0;
            shardFailures.add(new DefaultShardOperationFailedException(queryExplanation.getIndex(), queryExplanation.getShard(), exc));  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.test.AbstractBroadcastResponseTestCase;  
 * software distributed under the License is distributed on an
import java.io.IOException;
        }  
    @Override
        for (int i = 0; i < successfulShards; i++) {
            QueryExplanation queryExplanation = QueryExplanationTests.createRandomQueryExplanation(false);
        boolean valid = failedShards == 0;
            QueryExplanation queryExplanation = QueryExplanationTests.createRandomQueryExplanation(true);  
 *  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        return new ValidateQueryResponse(valid, queryExplanations, totalShards, successfulShards, failedShards, failures);
        int failedShards,  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        assertEquals(response.isValid(), parsedResponse.isValid());  
        }
    @Override
            queryExplanations.add(queryExplanation);
 * GitHub history for details.
 *
    }
        return createRandomValidateQueryResponse(totalShards, successfulShards, failedShards, failures);  
        List<QueryExplanation> queryExplanations = new ArrayList<>(totalShards);  
import java.util.HashSet;
    public void testToXContent() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super.assertEqualInstances(response, parsedResponse);
        assertEquals(response.getQueryExplanation().size(), parsedResponse.getQueryExplanation().size());
    protected ValidateQueryResponse createTestInstance() {
import java.util.ArrayList;  
        int successfulShards,
        int totalShards,  
import java.util.List;  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 *
        List<QueryExplanation> queryExplanations = new ArrayList<>(totalShards);  
        return new ValidateQueryResponse(valid, queryExplanations, totalShards, successfulShards, failedShards, shardFailures);
/*  
        int successfulShards = randomIntBetween(0, totalShards);  
    @Override  
    }  
    }
        List<DefaultShardOperationFailedException> failures  
    }
        ValidateQueryResponse response = createTestInstance(10, 10, 0, new ArrayList<>());
        Collections.shuffle(queryExplanations, random());  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        for (DefaultShardOperationFailedException failure : failures) {
}  
        assertEquals("{\"_shards\":{\"total\":10,\"successful\":10,\"failed\":0},\"valid\":true}", output);
    @Override  
        int successfulShards,
 * this file be licensed under the Apache-2.0 license or a
        List<DefaultShardOperationFailedException> failures
import org.opensearch.core.xcontent.MediaTypeRegistry;
        List<DefaultShardOperationFailedException> shardFailures = new ArrayList<>(failedShards);
        int failedShards,
    }  
        }
        int failedShards = totalShards - successfulShards;
            OpenSearchException exc = new OpenSearchException("some_error_" + randomInt());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.Strings;  
    protected ValidateQueryResponse createTestInstance(  
import org.opensearch.OpenSearchException;
    protected ValidateQueryResponse doParseInstance(XContentParser parser) throws IOException {
 */  
    ) {
 */
 * Unless required by applicable law or agreed to in writing,
            queryExplanations.add(queryExplanation);
        int totalShards,
 * under the License.  
        int totalShards = randomIntBetween(1, 10);
 * not use this file except in compliance with the License.
        String output = Strings.toString(MediaTypeRegistry.JSON, response);  
