 * The OpenSearch Contributors require contributions made to
            assertNotEquals(request.hashCode(), copy.hashCode());
                randomAlphaOfLengthBetween(2, 10),
import org.opensearch.core.common.io.stream.StreamInput;
            assertEquals(request, copy);
            // Can't check hashCode because we can't be sure that changing commands changes the hashCode. It usually does but might not.
            () -> new AllocateEmptyPrimaryAllocationCommand(
        RestRequest restRequest = toRestRequest(original);
            assertNotEquals(request, copy);
    }
                randomAlphaOfLengthBetween(2, 10),
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        int commands = between(0, 10);
        if (false == original.timeout().equals(AcknowledgedRequest.DEFAULT_ACK_TIMEOUT) || randomBoolean()) {
            copy.explain(!copy.explain());
import org.opensearch.core.xcontent.MediaTypeRegistry;
        try (BytesStreamOutput output = new BytesStreamOutput()) {
        if (original.isRetryFailed() || randomBoolean()) {
        }
 */
 * under the License.
        if (hasBody) {
            () -> new AllocateReplicaAllocationCommand(
    private RestRequest toRestRequest(ClusterRerouteRequest original) throws IOException {
        Arrays.<Supplier<AllocationCommand>>asList(
    public void testParsing() throws IOException {
        }
            assertNotEquals(request, copy);
        ClusterRerouteRequest request = new ClusterRerouteRequest();
        return request;
                randomBoolean()
    private final NamedWriteableRegistry namedWriteableRegistry;
    }
    public void testSerialization() throws IOException {
        return new NamedXContentRegistry(NetworkModule.getNamedXContents());
            || randomBoolean()) {
 * Test for serialization and parsing of {@link ClusterRerouteRequest} and its commands. See the superclass for, well, everything.
        if (randomBoolean()) {
        request.setRetryFailed(randomBoolean());
                request.getCommands().commands().toArray(new AllocationCommand[0])
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.core.xcontent.ToXContent;
 * license agreements. See the NOTICE file distributed with
        for (int i = 0; i < commands; i++) {
            assertEquals(request.hashCode(), copy.hashCode());
import java.util.function.Supplier;
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
            assertNotEquals(request.hashCode(), copy.hashCode());
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;
    private final List<Supplier<AllocationCommand>> RANDOM_COMMAND_GENERATORS = unmodifiableList(
/*
    public void testEqualsAndHashCode() {
 */
            assertEquals(request.hashCode(), copy.hashCode());
                randomAlphaOfLengthBetween(2, 10),
        if (false == original.clusterManagerNodeTimeout().equals(ClusterManagerNodeRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT)
    public ClusterRerouteRequestTests() {
            assertEquals(request, request);
            assertEquals(request, copy);
            assertNotSame(request, copy);
        }
    private static final int ROUNDS = 30;
            assertEquals(request, copy);
 * not use this file except in compliance with the License.
                randomBoolean()
            params.put("retry_failed", Boolean.toString(original.isRetryFailed()));
        }
        Map<String, String> params = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
                randomAlphaOfLengthBetween(2, 10)
            ),
        }
            assertNotSame(request, copy);
            () -> new CancelAllocationCommand(
            assertNotEquals(request.hashCode(), copy.hashCode());
            copy.explain(!copy.explain());
            request.add(randomFrom(RANDOM_COMMAND_GENERATORS).get());
            ClusterRerouteRequest request = randomRequest();
            }
 * specific language governing permissions and limitations
            original.getCommands().toXContent(builder, ToXContent.EMPTY_PARAMS);
import java.util.Map;
        FakeRestRequest.Builder requestBuilder = new FakeRestRequest.Builder(xContentRegistry());
 *
            () -> new MoveAllocationCommand(
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;
            // Changing clusterManagerNodeTimeout makes requests not equal
            assertNotEquals(request, copy);
            hasBody = true;
            );
 * this work for additional information regarding copyright
}
                between(0, 1000),
            copy.dryRun(!copy.dryRun());
    @Override
        if (randomBoolean()) {
        requestBuilder.withParams(params);
            assertEquals(request.hashCode(), request.hashCode());
 *
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
/**
            assertEquals(request.hashCode(), copy.hashCode());
            assertEquals(request, copy);
        return requestBuilder.build();
            params.put("cluster_manager_timeout", original.clusterManagerNodeTimeout().toString());
            copy.timeout(timeValueMillis(request.timeout().millis() + 1));
    private ClusterRerouteRequest randomRequest() {
        }
        }
import java.io.IOException;
            assertEquals(copy, request); // Commutative
            ),
                randomAlphaOfLengthBetween(2, 10),
    }
    private ClusterRerouteRequest roundTripThroughBytes(ClusterRerouteRequest original) throws IOException {
            ClusterRerouteRequest request = randomRequest();
            // Changing timeout makes requests not equal
    }
                between(0, 1000),
            copy.add(randomFrom(RANDOM_COMMAND_GENERATORS).get());
    }
                randomAlphaOfLengthBetween(2, 10),
 * GitHub history for details.
            builder.field("dry_run", original.dryRun());
        boolean hasBody = false;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
            copy.clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
import java.util.List;
            assertEquals(request.hashCode(), copy.hashCode());
        for (int round = 0; round < ROUNDS; round++) {
        builder.endObject();
import org.opensearch.rest.action.admin.cluster.RestClusterRerouteAction;
        }
                randomAlphaOfLengthBetween(2, 10)
        )
        for (int round = 0; round < ROUNDS; round++) {
                between(0, 1000),
            assertEquals(request.hashCode(), copy.hashCode());
        return RestClusterRerouteAction.createRequest(restRequest);
            assertEquals(request, copy);
            // Changing dryRun makes requests not equal
 */
        request.explain(randomBoolean());
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
import java.util.HashMap;
            ClusterRerouteRequest copy = roundTripThroughRestRequest(request);
        for (int round = 0; round < ROUNDS; round++) {
            hasBody = true;
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
            )
        }
        namedWriteableRegistry = new NamedWriteableRegistry(NetworkModule.getNamedWriteables());
import org.opensearch.common.network.NetworkModule;
                randomAlphaOfLengthBetween(2, 10),
        }
                between(0, 1000),
            requestBuilder.withContent(BytesReference.bytes(builder), builder.contentType());
    }
            ),
                randomBoolean()
        request.dryRun(randomBoolean());
            copy.dryRun(!copy.dryRun());
 */
    }
 *
        params.put("explain", Boolean.toString(original.explain()));
    );
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
            assertNotEquals(request, copy);
            assertEquals(request, copy);
/*
                between(0, 1000),
    protected NamedXContentRegistry xContentRegistry() {
            assertEquals(request.hashCode(), copy.hashCode());
            // Changing commands makes requests not equal
import org.opensearch.test.OpenSearchTestCase;
            copy.timeout(request.timeout());
                randomAlphaOfLengthBetween(2, 10),
import java.util.Arrays;
    }
            assertNotEquals(request, copy);
        } else {
import org.opensearch.core.common.bytes.BytesReference;
            assertEquals(request.hashCode(), copy.hashCode());
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.rest.RestRequest;
                return new ClusterRerouteRequest(in);
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        if (original.getCommands() != null) {
            () -> new AllocateStalePrimaryAllocationCommand(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                randomAlphaOfLengthBetween(2, 10),
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
public class ClusterRerouteRequestTests extends OpenSearchTestCase {
    private ClusterRerouteRequest roundTripThroughRestRequest(ClusterRerouteRequest original) throws IOException {
            original.writeTo(output);
import org.opensearch.common.io.stream.BytesStreamOutput;
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
            ClusterRerouteRequest request = randomRequest();
import org.opensearch.test.rest.FakeRestRequest;
            params.put("timeout", original.timeout().toString());
            // Changing explain makes requests not equal
            assertEquals(request, copy);
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at
import static java.util.Collections.unmodifiableList;
import org.opensearch.common.xcontent.XContentType;
            copy.clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
 * software distributed under the License is distributed on an
                randomAlphaOfLengthBetween(2, 10),
            params.put("dry_run", Boolean.toString(original.dryRun()));
        }
/*
            builder = builder.prettyPrint();
    }
import org.opensearch.core.xcontent.XContentBuilder;
            ClusterRerouteRequest copy = new ClusterRerouteRequest().add(
            assertNotEquals(request.hashCode(), copy.hashCode());
            copy.dryRun(request.dryRun()).explain(request.explain()).timeout(request.timeout()).setRetryFailed(request.isRetryFailed());
            copy.clusterManagerNodeTimeout(timeValueMillis(request.clusterManagerNodeTimeout().millis() + 1));
            ClusterRerouteRequest copy = roundTripThroughBytes(request);
package org.opensearch.action.admin.cluster.reroute;
            ),
 * ownership. Elasticsearch licenses this file to you under
        builder.startObject();
