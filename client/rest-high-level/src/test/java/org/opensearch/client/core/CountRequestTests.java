    protected void assertInstances(QueryBuilder serverInstance, CountRequest clientTestInstance) {
        result.terminateAfter(countRequest.terminateAfter());
import org.opensearch.common.settings.Settings;
        result.indicesOptions(countRequest.indicesOptions());
            () -> mutation.indicesOptions(
        result.types(countRequest.types());
        if (countRequest.query() != null) {
import static org.hamcrest.Matchers.equalTo;
    protected CountRequest createClientTestInstance() {
// so that is why this is chosen as server side instance.
        assertNotNull(countRequest.types());
 * license agreements. See the NOTICE file distributed with
        return mutation;
        mutators.add(() -> mutation.indices(ArrayUtils.concat(countRequest.indices(), new String[] { randomAlphaOfLength(10) })));
import java.util.List;
 * Licensed to Elasticsearch under one or more contributor
        );
import org.opensearch.index.query.MatchQueryBuilder;
import org.opensearch.search.SearchModule;
        result.routing(countRequest.routing());
        return countRequest;
        assertEquals("indices must not be null", e.getMessage());
    private CountRequest createCountRequest() {
import org.opensearch.core.xcontent.XContentParser;
                randomValueOtherThan(countRequest.query(), () -> new MatchQueryBuilder(randomAlphaOfLength(4), randomAlphaOfLength(4)))
    private static CountRequest copyRequest(CountRequest countRequest) {
        } else {
        e = expectThrows(NullPointerException.class, () -> countRequest.types((String[]) null));
 */
        assertThat(serverInstance, equalTo(clientTestInstance.query()));
                    countRequest.indicesOptions(),
    }
        assertEquals("query must not be null", e.getMessage());
import java.io.IOException;
}
    }
import org.opensearch.client.AbstractRequestTestCase;
        e = expectThrows(NullPointerException.class, () -> countRequest.indicesOptions(null));
        CountRequest countRequest = new CountRequest();
        assertNotNull(countRequest.indicesOptions());
    public void testEqualsAndHashcode() {
import org.opensearch.common.util.ArrayUtils;
        mutators.add(
    }
                randomValueOtherThan(
 */
 *
        return result;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.NamedXContentRegistry;
    @Override
        mutators.add(() -> mutation.minScore(randomValueOtherThan(countRequest.minScore(), () -> (float) randomIntBetween(0, 10))));
import org.opensearch.index.query.MatchAllQueryBuilder;
        CountRequest result = new CountRequest();
        mutators.add(() -> mutation.types(ArrayUtils.concat(countRequest.types(), new String[] { randomAlphaOfLength(10) })));
public class CountRequestTests extends AbstractRequestTestCase<CountRequest, QueryBuilder> {
                    () -> IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())
            )
        mutators.add(() -> mutation.preference(randomValueOtherThan(countRequest.preference(), () -> randomAlphaOfLengthBetween(3, 10))));
import org.opensearch.action.support.IndicesOptions;
            )
 * under the License.
        // query is the only property that is serialized as xcontent:
        mutators.add(
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        mutators.add(() -> mutation.routing(randomValueOtherThan(countRequest.routing(), () -> randomAlphaOfLengthBetween(3, 10))));
        );
package org.opensearch.client.core;
 *    http://www.apache.org/licenses/LICENSE-2.0
        CountRequest countRequest = new CountRequest("index");
import org.opensearch.search.builder.SearchSourceBuilder;
        assertEquals("index must not be null", e.getMessage());
 * GitHub history for details.
        mutators.add(() -> mutation.terminateAfter(randomValueOtherThan(countRequest.terminateAfter(), () -> randomIntBetween(0, 10))));
    }
 * this file be licensed under the Apache-2.0 license or a
    protected QueryBuilder doParseToServerInstance(XContentParser parser) throws IOException {
        if (randomBoolean()) {
    }
        return new NamedXContentRegistry(new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedXContents());
    @Override
        e = expectThrows(NullPointerException.class, () -> countRequest.indices((String) null));
        return RestActions.getQueryContent(parser);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
            result.query(countRequest.query());
 * specific language governing permissions and limitations
        CountRequest countRequest = new CountRequest();
        assertEquals("type must not be null", e.getMessage());
/*
// In RestCountAction the request body is parsed as QueryBuilder (top level query field),
        e = expectThrows(NullPointerException.class, () -> countRequest.source(null));
 * The OpenSearch Contributors require contributions made to
                )
import java.util.Collections;
        // query is the only property that is serialized as xcontent:
            countRequest.query(new MatchQueryBuilder("num", 10));
// similar to SearchRequestTests as CountRequest inline several members (and functionality) from SearchRequest
 * software distributed under the License is distributed on an
        CountRequest mutation = copyRequest(countRequest);
            () -> mutation.query(
    }
 * compatible open source license.
        randomFrom(mutators).run();
 *
    @Override
        return countRequest;
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
import org.opensearch.index.query.QueryBuilder;
    @Override
import org.opensearch.rest.action.RestActions;
        }
 * not use this file except in compliance with the License.
import java.util.ArrayList;
    }
        assertEquals("indicesOptions must not be null", e.getMessage());
        List<Runnable> mutators = new ArrayList<>();
        e = expectThrows(NullPointerException.class, () -> countRequest.types((String) null));
 */
    public void testIllegalArguments() {
 *
        assertEquals("types must not be null", e.getMessage());
/*
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under
        assertEquals("source must not be null", e.getMessage());
        NullPointerException e = expectThrows(NullPointerException.class, () -> countRequest.indices((String[]) null));
        }
        e = expectThrows(NullPointerException.class, () -> countRequest.query(null));
        result.minScore(countRequest.minScore());
 * You may obtain a copy of the License at
        }
 * Unless required by applicable law or agreed to in writing,
/*
        result.indices(countRequest.indices());
            countRequest.source(new SearchSourceBuilder().query(new MatchQueryBuilder("num", 10)));
    protected NamedXContentRegistry xContentRegistry() {
        checkEqualsAndHashCode(createCountRequest(), CountRequestTests::copyRequest, this::mutate);
    private CountRequest mutate(CountRequest countRequest) {
    }
            countRequest.query(new MatchAllQueryBuilder());
        result.preference(countRequest.preference());
        assertNotNull(countRequest.indices());
        if (randomBoolean()) {
 * KIND, either express or implied.  See the License for the
