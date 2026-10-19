        randomFrom(mutators).run();
            result.query(countRequest.query());
    private CountRequest createCountRequest() {
        assertNotNull(countRequest.types());  
        e = expectThrows(NullPointerException.class, () -> countRequest.source(null));  
 * You may obtain a copy of the License at  
        mutators.add(() -> mutation.routing(randomValueOtherThan(countRequest.routing(), () -> randomAlphaOfLengthBetween(3, 10))));
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        );
 * Unless required by applicable law or agreed to in writing,
        result.preference(countRequest.preference());
        result.types(countRequest.types());  
 * ownership. Elasticsearch licenses this file to you under  
        List<Runnable> mutators = new ArrayList<>();
 * this work for additional information regarding copyright
 * under the License.  
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertThat(serverInstance, equalTo(clientTestInstance.query()));  
        if (randomBoolean()) {
        result.terminateAfter(countRequest.terminateAfter());  
// so that is why this is chosen as server side instance.  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("index must not be null", e.getMessage());
                    countRequest.indicesOptions(),
 */  
        e = expectThrows(NullPointerException.class, () -> countRequest.indices((String) null));
        result.minScore(countRequest.minScore());
/*
    private static CountRequest copyRequest(CountRequest countRequest) {
    protected QueryBuilder doParseToServerInstance(XContentParser parser) throws IOException {
    protected void assertInstances(QueryBuilder serverInstance, CountRequest clientTestInstance) {
    }  
        return result;
/*  
import org.opensearch.index.query.MatchQueryBuilder;
import java.io.IOException;
                randomValueOtherThan(countRequest.query(), () -> new MatchQueryBuilder(randomAlphaOfLength(4), randomAlphaOfLength(4)))
        return RestActions.getQueryContent(parser);  
        mutators.add(() -> mutation.minScore(randomValueOtherThan(countRequest.minScore(), () -> (float) randomIntBetween(0, 10))));
        return mutation;
        );  
        result.indices(countRequest.indices());
import org.opensearch.index.query.MatchAllQueryBuilder;
        e = expectThrows(NullPointerException.class, () -> countRequest.indicesOptions(null));
        }
        mutators.add(() -> mutation.preference(randomValueOtherThan(countRequest.preference(), () -> randomAlphaOfLengthBetween(3, 10))));
        assertEquals("indicesOptions must not be null", e.getMessage());
        return countRequest;
    public void testEqualsAndHashcode() {
        result.routing(countRequest.routing());
    }
 * KIND, either express or implied.  See the License for the
        }
        mutators.add(
// In RestCountAction the request body is parsed as QueryBuilder (top level query field),
        CountRequest countRequest = new CountRequest();  
 */  
import java.util.List;
            () -> mutation.query(  
    @Override  
    }  
            countRequest.query(new MatchAllQueryBuilder());
        }  
        mutators.add(() -> mutation.terminateAfter(randomValueOtherThan(countRequest.terminateAfter(), () -> randomIntBetween(0, 10))));  
package org.opensearch.client.core;
            )
import org.opensearch.core.xcontent.XContentParser;  
 * The OpenSearch Contributors require contributions made to  
    }  
    }  
        assertEquals("types must not be null", e.getMessage());
    protected NamedXContentRegistry xContentRegistry() {
                    () -> IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())
        if (countRequest.query() != null) {  
        CountRequest countRequest = new CountRequest();
import static org.hamcrest.Matchers.equalTo;
 *
        return new NamedXContentRegistry(new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedXContents());
        // query is the only property that is serialized as xcontent:
        e = expectThrows(NullPointerException.class, () -> countRequest.query(null));  
        CountRequest mutation = copyRequest(countRequest);
        assertNotNull(countRequest.indicesOptions());
 * Modifications Copyright OpenSearch Contributors. See
        mutators.add(() -> mutation.indices(ArrayUtils.concat(countRequest.indices(), new String[] { randomAlphaOfLength(10) })));  
    }
 *
import org.opensearch.common.util.ArrayUtils;
public class CountRequestTests extends AbstractRequestTestCase<CountRequest, QueryBuilder> {
    }
import org.opensearch.action.support.IndicesOptions;
    @Override
        mutators.add(() -> mutation.types(ArrayUtils.concat(countRequest.types(), new String[] { randomAlphaOfLength(10) })));  
        } else {  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        // query is the only property that is serialized as xcontent:  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;  
        mutators.add(
            countRequest.source(new SearchSourceBuilder().query(new MatchQueryBuilder("num", 10)));
import org.opensearch.search.builder.SearchSourceBuilder;  
    @Override  
        e = expectThrows(NullPointerException.class, () -> countRequest.types((String[]) null));
        assertEquals("source must not be null", e.getMessage());
import org.opensearch.index.query.QueryBuilder;  
                )  
}
        return countRequest;  
        CountRequest countRequest = new CountRequest("index");  
            () -> mutation.indicesOptions(
        NullPointerException e = expectThrows(NullPointerException.class, () -> countRequest.indices((String[]) null));
        assertEquals("query must not be null", e.getMessage());
    private CountRequest mutate(CountRequest countRequest) {  
 * compatible open source license.
    }
import java.util.Collections;
 * GitHub history for details.
        checkEqualsAndHashCode(createCountRequest(), CountRequestTests::copyRequest, this::mutate);
import java.util.ArrayList;  
 * specific language governing permissions and limitations
        assertEquals("indices must not be null", e.getMessage());  
        result.indicesOptions(countRequest.indicesOptions());
            countRequest.query(new MatchQueryBuilder("num", 10));
    }
import org.opensearch.search.SearchModule;
// similar to SearchRequestTests as CountRequest inline several members (and functionality) from SearchRequest
        if (randomBoolean()) {
                randomValueOtherThan(  
    public void testIllegalArguments() {
    protected CountRequest createClientTestInstance() {
        e = expectThrows(NullPointerException.class, () -> countRequest.types((String) null));  
        assertEquals("type must not be null", e.getMessage());
 * software distributed under the License is distributed on an
 *  
 * license agreements. See the NOTICE file distributed with
        CountRequest result = new CountRequest();  
import org.opensearch.client.AbstractRequestTestCase;
            )
 */
import org.opensearch.rest.action.RestActions;
        assertNotNull(countRequest.indices());
