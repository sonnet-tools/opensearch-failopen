        )
            params.put("cluster_manager_timeout", original.clusterManagerNodeTimeout().toString());
            copy.timeout(request.timeout());  
            () -> new AllocateStalePrimaryAllocationCommand(
        }
    @Override
            assertNotSame(request, copy);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    private final List<Supplier<AllocationCommand>> RANDOM_COMMAND_GENERATORS = unmodifiableList(
 * this work for additional information regarding copyright
import java.util.function.Supplier;  
                between(0, 1000),
 *
import org.opensearch.rest.action.admin.cluster.RestClusterRerouteAction;  
    }
            assertEquals(request, request);
 * Test for serialization and parsing of {@link ClusterRerouteRequest} and its commands. See the superclass for, well, everything.  
            assertEquals(request, copy);  
 * GitHub history for details.
import java.util.List;
            params.put("retry_failed", Boolean.toString(original.isRetryFailed()));  
        requestBuilder.withParams(params);
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;
        }  
            ),
    public void testEqualsAndHashCode() {
        FakeRestRequest.Builder requestBuilder = new FakeRestRequest.Builder(xContentRegistry());  
 * Modifications Copyright OpenSearch Contributors. See
 *
 * not use this file except in compliance with the License.
        for (int i = 0; i < commands; i++) {
        ClusterRerouteRequest request = new ClusterRerouteRequest();
        for (int round = 0; round < ROUNDS; round++) {  
            assertNotEquals(request.hashCode(), copy.hashCode());
                between(0, 1000),
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
        if (randomBoolean()) {  
    protected NamedXContentRegistry xContentRegistry() {  
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
/**
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
                between(0, 1000),
            assertEquals(request.hashCode(), copy.hashCode());
            copy.clusterManagerNodeTimeout(timeValueMillis(request.clusterManagerNodeTimeout().millis() + 1));
            assertEquals(request.hashCode(), copy.hashCode());  
        Map<String, String> params = new HashMap<>();  
                randomBoolean()  
            copy.dryRun(!copy.dryRun());
import org.opensearch.core.xcontent.NamedXContentRegistry;
            )
import org.opensearch.core.xcontent.ToXContent;  
import org.opensearch.core.xcontent.XContentBuilder;
 */  
    private ClusterRerouteRequest roundTripThroughRestRequest(ClusterRerouteRequest original) throws IOException {  
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;  
import static java.util.Collections.unmodifiableList;
                randomAlphaOfLengthBetween(2, 10),
import org.opensearch.core.common.bytes.BytesReference;  
    }
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;  
            assertNotEquals(request, copy);
 * the Apache License, Version 2.0 (the "License"); you may
    private ClusterRerouteRequest randomRequest() {
        request.setRetryFailed(randomBoolean());  
        builder.endObject();
            hasBody = true;
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
            assertEquals(request.hashCode(), copy.hashCode());
            copy.dryRun(request.dryRun()).explain(request.explain()).timeout(request.timeout()).setRetryFailed(request.isRetryFailed());
            original.getCommands().toXContent(builder, ToXContent.EMPTY_PARAMS);
            ClusterRerouteRequest copy = new ClusterRerouteRequest().add(
            ),
        if (original.isRetryFailed() || randomBoolean()) {
import org.opensearch.common.network.NetworkModule;
            ),
    private final NamedWriteableRegistry namedWriteableRegistry;
        if (original.getCommands() != null) {  
package org.opensearch.action.admin.cluster.reroute;
        }  
        return RestClusterRerouteAction.createRequest(restRequest);
    }
        }
    );  
            hasBody = true;
 * software distributed under the License is distributed on an
        }
        }
import static org.opensearch.common.unit.TimeValue.timeValueMillis;  
 * KIND, either express or implied.  See the License for the
        for (int round = 0; round < ROUNDS; round++) {
    }  
        return new NamedXContentRegistry(NetworkModule.getNamedXContents());
}  
            params.put("dry_run", Boolean.toString(original.dryRun()));
            assertEquals(request, copy);  
        }
            builder = builder.prettyPrint();
import org.opensearch.rest.RestRequest;
    }
        request.explain(randomBoolean());
 * license agreements. See the NOTICE file distributed with
                randomAlphaOfLengthBetween(2, 10),
            || randomBoolean()) {  
            // Can't check hashCode because we can't be sure that changing commands changes the hashCode. It usually does but might not.  
    public ClusterRerouteRequestTests() {  
 * The OpenSearch Contributors require contributions made to  
                randomAlphaOfLengthBetween(2, 10),  
    public void testSerialization() throws IOException {
            copy.explain(!copy.explain());
        }  
                randomAlphaOfLengthBetween(2, 10),  
            () -> new MoveAllocationCommand(
            () -> new AllocateReplicaAllocationCommand(  
            assertNotEquals(request.hashCode(), copy.hashCode());
            () -> new CancelAllocationCommand(
        return requestBuilder.build();
        builder.startObject();  
            params.put("timeout", original.timeout().toString());  
    }  
            assertEquals(request.hashCode(), copy.hashCode());
            assertNotSame(request, copy);
                randomAlphaOfLengthBetween(2, 10),
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
        if (false == original.clusterManagerNodeTimeout().equals(ClusterManagerNodeRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT)
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        return request;
 */  
            assertNotEquals(request, copy);  
import org.opensearch.common.xcontent.XContentType;
        RestRequest restRequest = toRestRequest(original);
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
        }
            ClusterRerouteRequest request = randomRequest();
        }
            );  
 *  
            assertEquals(request, copy);  
            // Changing dryRun makes requests not equal
            () -> new AllocateEmptyPrimaryAllocationCommand(
import org.opensearch.test.OpenSearchTestCase;
            ClusterRerouteRequest request = randomRequest();  
 * Unless required by applicable law or agreed to in writing,
            }
    private ClusterRerouteRequest roundTripThroughBytes(ClusterRerouteRequest original) throws IOException {  
            assertEquals(copy, request); // Commutative
            builder.field("dry_run", original.dryRun());
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(request.hashCode(), copy.hashCode());  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                randomAlphaOfLengthBetween(2, 10),
        for (int round = 0; round < ROUNDS; round++) {
                randomAlphaOfLengthBetween(2, 10),
    private RestRequest toRestRequest(ClusterRerouteRequest original) throws IOException {
                randomAlphaOfLengthBetween(2, 10)  
            assertEquals(request, copy);
 */
import java.util.Map;
        int commands = between(0, 10);  
            request.add(randomFrom(RANDOM_COMMAND_GENERATORS).get());
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {  
        params.put("explain", Boolean.toString(original.explain()));
/*  
            assertEquals(request.hashCode(), request.hashCode());
import java.util.HashMap;  
            original.writeTo(output);
            // Changing timeout makes requests not equal
                randomBoolean()  
import java.io.IOException;
            copy.dryRun(!copy.dryRun());
 * ownership. Elasticsearch licenses this file to you under  
            // Changing commands makes requests not equal  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            // Changing explain makes requests not equal  
            ClusterRerouteRequest copy = roundTripThroughBytes(request);
                randomAlphaOfLengthBetween(2, 10)  
public class ClusterRerouteRequestTests extends OpenSearchTestCase {
            assertEquals(request.hashCode(), copy.hashCode());
            copy.explain(!copy.explain());
            ClusterRerouteRequest copy = roundTripThroughRestRequest(request);
            assertNotEquals(request.hashCode(), copy.hashCode());  
            assertEquals(request.hashCode(), copy.hashCode());
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
 * under the License.  
 * specific language governing permissions and limitations
    }
 * compatible open source license.
            assertNotEquals(request, copy);
            assertNotEquals(request, copy);  
        Arrays.<Supplier<AllocationCommand>>asList(
            ClusterRerouteRequest request = randomRequest();  
            copy.timeout(timeValueMillis(request.timeout().millis() + 1));  
                randomAlphaOfLengthBetween(2, 10),  
            assertNotEquals(request, copy);
 * SPDX-License-Identifier: Apache-2.0
 */
import org.opensearch.test.rest.FakeRestRequest;
        if (hasBody) {
            ),
        namedWriteableRegistry = new NamedWriteableRegistry(NetworkModule.getNamedWriteables());
        if (false == original.timeout().equals(AcknowledgedRequest.DEFAULT_ACK_TIMEOUT) || randomBoolean()) {
 * You may obtain a copy of the License at  
            copy.add(randomFrom(RANDOM_COMMAND_GENERATORS).get());
    public void testParsing() throws IOException {
            requestBuilder.withContent(BytesReference.bytes(builder), builder.contentType());  
        }  
            copy.clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
        if (randomBoolean()) {
/*
            assertEquals(request, copy);  
        } else {  
        boolean hasBody = false;
import org.opensearch.core.common.io.stream.StreamInput;  
 * Licensed to Elasticsearch under one or more contributor  
        request.dryRun(randomBoolean());
        }  
            assertNotEquals(request.hashCode(), copy.hashCode());
                between(0, 1000),
            assertEquals(request, copy);
import java.util.Arrays;
                request.getCommands().commands().toArray(new AllocationCommand[0])
            copy.clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
                randomAlphaOfLengthBetween(2, 10),  
                randomBoolean()  
            // Changing clusterManagerNodeTimeout makes requests not equal
                between(0, 1000),
    private static final int ROUNDS = 30;  
import org.opensearch.common.io.stream.BytesStreamOutput;  
                return new ClusterRerouteRequest(in);
            assertEquals(request, copy);
        try (BytesStreamOutput output = new BytesStreamOutput()) {
