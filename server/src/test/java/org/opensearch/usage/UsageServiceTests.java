}
        BaseRestHandler handlerA = new MockRestHandler("a");
        assertThat(restUsage, notNullValue());
        try (NodeClient client = new NoOpNodeClient(this.getClass().getSimpleName() + "TestClient")) {
            return channel -> {};
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> service.addRestHandler(horse));
            usageService.incAggregationUsage("a", "y");
     * Test that we can add the same instance of a {@link org.opensearch.rest.RestHandler} to the {@link UsageService} multiple times.
        }
        assertThat(((Map<String, Object>) aggsUsage.get("b")).get("x"), equalTo(4L));
        }
            handlerA.handleRequest(restRequest, null, client);
    }
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
import org.opensearch.rest.RestRequest;
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.notNullValue;
        final String expected = String.format(
        builder.registerAggregationUsage("a", "x");
            handlerA.handleRequest(restRequest, null, client);
            handlerD.handleRequest(restRequest, null, client);
        for (int i = 0; i < 5; i++) {
import java.util.Locale;
        final BaseRestHandler first = new MockRestHandler(name);
 * specific language governing permissions and limitations
        usageService.addRestHandler(handlerF);
            "handler of type [%s] conflicts with handler of type [%1$s] as they both have the same name [%s]",
        usageService.addRestHandler(handlerC);
     */
        }
            usageService.incAggregationUsage("b", "x");
        usageService.addRestHandler(handlerD);
    public void testRestUsage() throws Exception {
     */
            return name;
        assertThat(restUsage.get("d"), equalTo(2L));
        assertThat(e.getMessage(), equalTo(expected));
            usageService.incAggregationUsage("a", "z");
        assertThat(((Map<String, Object>) aggsUsage.get("b")).get("y"), equalTo(5L));
            handlerD.handleRequest(restRequest, null, client);
            Locale.ROOT,
        assertThat(((Map<String, Object>) aggsUsage.get("a")).get("y"), equalTo(2L));
        protected MockRestHandler(String name) {
        for (int i = 0; i < 6; i++) {
     * Test that we can not add different instances of {@link org.opensearch.rest.RestHandler} with the same name to the
import org.opensearch.transport.client.node.NodeClient;
        }
    public void testAHandlerWithNoName() {
        }
        assertThat(restUsage.get("b"), equalTo(3L));
     */
 *
    /**
 */
    public void testHandlerCanNotBeNull() {
 * this file be licensed under the Apache-2.0 license or a
        }
    private class MockRestHandler extends BaseRestHandler {
        }
import java.util.Map;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.
import static org.hamcrest.Matchers.equalTo;
        );
        final UsageService service = new UsageService();
        assertThat(((Map<String, Object>) aggsUsage.get("a")).get("z"), equalTo(3L));
            this.name = name;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testHandlerWithConflictingNamesButSameInstance() {
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
/*
        expectThrows(NullPointerException.class, () -> service.addRestHandler(null));
            usageService.incAggregationUsage("c", OTHER_SUBTYPE);
/*
            handlerC.handleRequest(restRequest, null, client);
            "org.opensearch.usage.UsageServiceTests$MockRestHandler",
            handlerB.handleRequest(restRequest, null, client);
import static org.opensearch.search.aggregations.support.AggregationUsageService.OTHER_SUBTYPE;
        for (int i = 0; i < 2; i++) {
/*
    }
        RestRequest restRequest = new FakeRestRequest();
        assertThat(((Map<String, Object>) aggsUsage.get("c")).get(OTHER_SUBTYPE), equalTo(6L));
        service.addRestHandler(first);
        assertThat(aggsUsage, notNullValue());
 * Modifications Copyright OpenSearch Contributors. See
    }
 * SPDX-License-Identifier: Apache-2.0
        usageService.addRestHandler(handlerE);
        assertThat(restUsage.get("a"), equalTo(4L));
        assertThat(restUsage.get("e"), equalTo(1L));
        assertThat(restUsage.get("c"), equalTo(3L));
        final IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> service.addRestHandler(second));
            e.getMessage(),
        usageService.incAggregationUsage("a", "x");
    public void testAggsUsage() throws Exception {
package org.opensearch.usage;
    public void testHandlersWithConflictingNamesButDifferentInstances() {
    /**
     * Test that we can not add an instance of a {@link org.opensearch.rest.RestHandler} with no name to the {@link UsageService}.
        // nothing bad ever happens to me
            usageService.incAggregationUsage("b", "y");
        service.addRestHandler(first);
import org.opensearch.test.client.NoOpNodeClient;
 * not use this file except in compliance with the License.
        assertThat(((Map<String, Object>) aggsUsage.get("a")).get("x"), equalTo(1L));
    /**
import org.opensearch.search.aggregations.support.AggregationUsageService;
            handlerE.handleRequest(restRequest, null, client);
        }
public class UsageServiceTests extends OpenSearchTestCase {
 */
    /**
        final BaseRestHandler first = new MockRestHandler(name);
            handlerB.handleRequest(restRequest, null, client);
     * Test that we can not add a null reference to a {@link org.opensearch.rest.RestHandler} to the {@link UsageService}.
        usageService.addRestHandler(handlerA);
        builder.registerAggregationUsage("c");
            handlerB.handleRequest(restRequest, null, client);
        protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {
        @Override
        AggregationUsageService usageService = builder.build();
 * You may obtain a copy of the License at
        assertThat(restUsage.get("f"), equalTo(1L));
            equalTo("handler of type [org.opensearch.usage.UsageServiceTests$MockRestHandler] does not have a name")
        @Override
import org.opensearch.test.OpenSearchTestCase;
        assertThat(
 * software distributed under the License is distributed on an
        BaseRestHandler handlerE = new MockRestHandler("e");
        builder.registerAggregationUsage("b", "y");
        final UsageService service = new UsageService();
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        service.addRestHandler(first);
 *
     */
 * Unless required by applicable law or agreed to in writing,
        builder.registerAggregationUsage("b", "x");
            handlerC.handleRequest(restRequest, null, client);
    }
 * compatible open source license.
     * {@link UsageService}.
    }
        BaseRestHandler handlerC = new MockRestHandler("c");
        assertThat(restUsage.size(), equalTo(6));
            name
            handlerA.handleRequest(restRequest, null, client);
        assertThat(aggsUsage.size(), equalTo(3));
        Map<String, Object> aggsUsage = usageService.getUsageStats();
 *
            handlerF.handleRequest(restRequest, null, client);
        final UsageService service = new UsageService();
        BaseRestHandler handlerD = new MockRestHandler("d");
        public String getName() {
    }
 */
import org.opensearch.test.rest.FakeRestRequest;
        final String name = randomAlphaOfLength(8);
 * The OpenSearch Contributors require contributions made to
        builder.registerAggregationUsage("a", "z");
    }
        builder.registerAggregationUsage("a", "y");
        private String name;
        BaseRestHandler handlerB = new MockRestHandler("b");
 * Licensed to Elasticsearch under one or more contributor
    @SuppressWarnings("unchecked")
        for (int i = 0; i < 4; i++) {
        final BaseRestHandler horse = new MockRestHandler(null);
        Map<String, Long> restUsage = usageService.getRestUsageStats();
            handlerA.handleRequest(restRequest, null, client);
        usageService.addRestHandler(handlerB);
        final BaseRestHandler second = new MockRestHandler(name);
        for (int i = 0; i < 3; i++) {
        );
        UsageService usageService = new UsageService();
        BaseRestHandler handlerF = new MockRestHandler("f");
        AggregationUsageService.Builder builder = new AggregationUsageService.Builder();
        final String name = randomAlphaOfLength(8);
        final UsageService service = new UsageService();
import org.opensearch.rest.BaseRestHandler;
            handlerC.handleRequest(restRequest, null, client);
