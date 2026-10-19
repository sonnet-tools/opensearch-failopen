        );
            allOf(
                ),
    public void testAlterateQueries() throws IOException {
 * specific language governing permissions and limitations
    public void testAlterateQueriesWithArbitraryContent() throws IOException {
                    true
            alterations,
/**
package org.opensearch.test;
                    true
 * compatible open source license.
                )
import java.io.IOException;
import static org.opensearch.test.AbstractQueryTestCase.alterateQueries;
            allOf(
                hasEntry(
                    "{\"function_score\":{\"query\":{\"term\":{\"foo\":\"bar\"}},\"script_score\":{\"script\":\"a + 1\","
                    "{\"query\":{\"more_like_this\":{\"newField\":{\"fields\":[\"a\",\"b\"],\"like\":{\"doc\":{\"c\":\"d\"}}}}}}",
        List<Tuple<String, Boolean>> alterations = alterateQueries(queries, arbitraryContentHolders);
                    true
 * not use this file except in compliance with the License.
                        + "1\",\"params\":{\"a\":0}}}}}",
                        + "1\",\"params\":{\"a\":0}}}}",
                hasEntry(
    }
                ),
import static org.hamcrest.Matchers.allOf;
                hasEntry("{\"bool\":{\"newField\":{\"must\":[{\"match\":{\"field\":\"value\"}}]}}}", true),
 */
                    "{\"function_score\":{\"query\":{\"term\":{\"newField\":{\"foo\":\"bar\"}}},\"script_score\":{\"script\":\"a + "
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
        Set<String> queries = Sets.newHashSet(
 * this work for additional information regarding copyright
                    "{\"function_score\":{\"query\":{\"newField\":{\"term\":{\"foo\":\"bar\"}}},\"script_score\":{\"script\":\"a + "
                hasEntry(
 *
                ),
                    "{\"newField\":{\"function_score\":{\"query\":{\"term\":{\"foo\":\"bar\"}},\"script_score\":{\"script\":\"a + "
                    "{\"query\":{\"more_like_this\":{\"fields\":[\"a\",\"b\"],\"like\":{\"doc\":{\"newField\":{\"c\":\"d\"}}}}}}",
    }
                ),
            )
                    true
                hasEntry(
        );
 * Modifications Copyright OpenSearch Contributors. See
                    "{\"newField\":{\"query\":{\"more_like_this\":{\"fields\":[\"a\",\"b\"],\"like\":{\"doc\":{\"c\":\"d\"}}}}}}",
import org.hamcrest.Matcher;
/*
        );
                    true
                ),
                    true
 * GitHub history for details.
        assertAlterations(
                hasEntry("{\"bool\":{\"must\":[{\"match\":{\"newField\":{\"field\":\"value\"}}}]}}", true)
                hasEntry("{\"term\":{\"newField\":{\"field\":\"value\"}}}", true)
                hasEntry(
import org.opensearch.common.collect.Tuple;
                    true
public class AbstractQueryTestCaseTests extends OpenSearchTestCase {
                    "{\"query\":{\"more_like_this\":{\"fields\":[\"a\",\"b\"],\"like\":{\"newField\":{\"doc\":{\"c\":\"d\"}}}}}}",
 * Licensed to Elasticsearch under one or more contributor
                hasEntry("{\"bool\":{\"must\":[{\"newField\":{\"match\":{\"field\":\"value\"}}}]}}", true),
        assertAlterations(alterations, allOf(notNullValue(), hasEntry("{\"newField\":{\"field\":\"value\"}}", true)));
import static org.hamcrest.Matchers.hasEntry;
 * license agreements. See the NOTICE file distributed with
            )
            allOf(
import static org.hamcrest.Matchers.notNullValue;
                ),
            allOf(
import java.util.List;
                    true
        assertAlterations(
                hasEntry("{\"newField\":{\"query\":{\"script\":\"test\",\"params\":{\"foo\":\"bar\"}}}}", true),
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at
import java.util.stream.Collectors;
                hasEntry("{\"query\":{\"newField\":{\"script\":\"test\",\"params\":{\"foo\":\"bar\"}}}}", true),
                hasEntry(
                hasEntry("{\"newField\":{\"term\":{\"field\":\"value\"}}}", true),
        assertAlterations(
                        + "1\",\"params\":{\"a\":0}}}}}",
import java.util.Map;
                ),
        List<Tuple<String, Boolean>> alterations = alterateQueries(singleton("{\"field\": \"value\"}"), null);
 * The OpenSearch Contributors require contributions made to
                    "{\"function_score\":{\"newField\":{\"query\":{\"term\":{\"foo\":\"bar\"}},\"script_score\":{\"script\":\"a + "
        );
                hasEntry(
    private static <K, V> void assertAlterations(List<Tuple<K, V>> alterations, Matcher<Map<K, V>> matcher) {
 * under the License.
        Set<String> arbitraryContentHolders = Sets.newHashSet("params", "doc");
        assertAlterations(
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
            ),
            alterations,
        alterations = alterateQueries(
                    true
 * Unless required by applicable law or agreed to in writing,
        assertAlterations(
                ),
                    "{\"query\":{\"newField\":{\"more_like_this\":{\"fields\":[\"a\",\"b\"],\"like\":{\"doc\":{\"c\":\"d\"}}}}}}",
            "{\"query\":{\"more_like_this\":{\"fields\":[\"a\",\"b\"],\"like\":{\"doc\":{\"c\":\"d\"}}}}}"
                "{\"function_score\":"
            allOf(
                        + "1\",\"params\":{\"a\":0}}}}",
            "{\"query\":{\"script\":\"test\",\"params\":{\"foo\":\"bar\"}}}",
        );
                    true
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
 * software distributed under the License is distributed on an
            singleton(
            )
        alterations = alterateQueries(singleton("{\"bool\":{\"must\": [{\"match\":{\"field\":\"value\"}}]}}"), null);
                    + "{\"query\": {\"term\":{\"foo\": \"bar\"}}, \"script_score\": {\"script\":\"a + 1\", \"params\": {\"a\":0}}}}"
            )
                hasEntry(
            )
        assertThat(alterations.stream().collect(Collectors.toMap(Tuple::v1, Tuple::v2)), matcher);
            alterations,
/*
}
                hasEntry(
    }
            alterations,
            null
                    "{\"function_score\":{\"query\":{\"term\":{\"foo\":\"bar\"}},\"script_score\":{\"newField\":{\"script\":\"a + "
                hasEntry("{\"query\":{\"script\":\"test\",\"params\":{\"newField\":{\"foo\":\"bar\"}}}}", false)
 * ownership. Elasticsearch licenses this file to you under
 */
        alterations = alterateQueries(singleton("{\"term\":{\"field\": \"value\"}}"), null);
                        + "1\",\"params\":{\"a\":0}}}}}",
import static java.util.Collections.singleton;
                hasEntry(
/*
            alterations,
                    false
                        + "\"params\":{\"newField\":{\"a\":0}}}}}",
                hasEntry("{\"newField\":{\"bool\":{\"must\":[{\"match\":{\"field\":\"value\"}}]}}}", true),
 *
                ),
        );
import org.opensearch.common.util.set.Sets;
import java.util.Set;
        );
                hasEntry(
 */
 *
                )
 * Various test for {@link org.opensearch.test.AbstractQueryTestCase}
