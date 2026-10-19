 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.test.AbstractQueryTestCase.alterateQueries;  
            "{\"query\":{\"script\":\"test\",\"params\":{\"foo\":\"bar\"}}}",  
                ),  
import java.util.Map;
 */
                    true  
                    "{\"newField\":{\"query\":{\"more_like_this\":{\"fields\":[\"a\",\"b\"],\"like\":{\"doc\":{\"c\":\"d\"}}}}}}",
                    "{\"query\":{\"more_like_this\":{\"newField\":{\"fields\":[\"a\",\"b\"],\"like\":{\"doc\":{\"c\":\"d\"}}}}}}",
                    "{\"query\":{\"more_like_this\":{\"fields\":[\"a\",\"b\"],\"like\":{\"doc\":{\"newField\":{\"c\":\"d\"}}}}}}",  
        );
                )
                hasEntry(
                hasEntry("{\"bool\":{\"must\":[{\"match\":{\"newField\":{\"field\":\"value\"}}}]}}", true)  
                    "{\"newField\":{\"function_score\":{\"query\":{\"term\":{\"foo\":\"bar\"}},\"script_score\":{\"script\":\"a + "  
        );  
                ),
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.notNullValue;  
                "{\"function_score\":"  
                ),
 */  
    }  
    }
                        + "\"params\":{\"newField\":{\"a\":0}}}}}",
        assertAlterations(
                    "{\"function_score\":{\"query\":{\"term\":{\"foo\":\"bar\"}},\"script_score\":{\"newField\":{\"script\":\"a + "
    public void testAlterateQueries() throws IOException {
            ),
        alterations = alterateQueries(singleton("{\"term\":{\"field\": \"value\"}}"), null);
                hasEntry(  
import static java.util.Collections.singleton;
            allOf(
                    true
 * not use this file except in compliance with the License.
                hasEntry(
                    "{\"function_score\":{\"newField\":{\"query\":{\"term\":{\"foo\":\"bar\"}},\"script_score\":{\"script\":\"a + "
 */
            alterations,
 * GitHub history for details.
                    true
                    true  
                    true  
                        + "1\",\"params\":{\"a\":0}}}}}",  
                hasEntry(
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * Various test for {@link org.opensearch.test.AbstractQueryTestCase}  
 * ownership. Elasticsearch licenses this file to you under  
                    false
        );  
 *
 * this work for additional information regarding copyright
            "{\"query\":{\"more_like_this\":{\"fields\":[\"a\",\"b\"],\"like\":{\"doc\":{\"c\":\"d\"}}}}}"
 */  
import org.opensearch.common.util.set.Sets;
import org.opensearch.common.collect.Tuple;
 * specific language governing permissions and limitations
/*
            )
            singleton(
                hasEntry("{\"newField\":{\"bool\":{\"must\":[{\"match\":{\"field\":\"value\"}}]}}}", true),  
 * KIND, either express or implied.  See the License for the
                hasEntry("{\"newField\":{\"query\":{\"script\":\"test\",\"params\":{\"foo\":\"bar\"}}}}", true),
        Set<String> arbitraryContentHolders = Sets.newHashSet("params", "doc");
            allOf(
                hasEntry("{\"query\":{\"script\":\"test\",\"params\":{\"newField\":{\"foo\":\"bar\"}}}}", false)
import java.util.List;  
            )
        assertAlterations(
 *
 * this file be licensed under the Apache-2.0 license or a
                    true
                    true
                hasEntry(  
/*  
    private static <K, V> void assertAlterations(List<Tuple<K, V>> alterations, Matcher<Map<K, V>> matcher) {
                    + "{\"query\": {\"term\":{\"foo\": \"bar\"}}, \"script_score\": {\"script\":\"a + 1\", \"params\": {\"a\":0}}}}"
                hasEntry(
        alterations = alterateQueries(singleton("{\"bool\":{\"must\": [{\"match\":{\"field\":\"value\"}}]}}"), null);
                ),
                    "{\"function_score\":{\"query\":{\"term\":{\"newField\":{\"foo\":\"bar\"}}},\"script_score\":{\"script\":\"a + "  
                hasEntry("{\"newField\":{\"term\":{\"field\":\"value\"}}}", true),  
package org.opensearch.test;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                ),
                hasEntry("{\"query\":{\"newField\":{\"script\":\"test\",\"params\":{\"foo\":\"bar\"}}}}", true),  
                        + "1\",\"params\":{\"a\":0}}}}}",
 *  
import java.io.IOException;
                        + "1\",\"params\":{\"a\":0}}}}",
        alterations = alterateQueries(
                ),
                    "{\"query\":{\"more_like_this\":{\"fields\":[\"a\",\"b\"],\"like\":{\"newField\":{\"doc\":{\"c\":\"d\"}}}}}}",
 * Licensed to Elasticsearch under one or more contributor  
    public void testAlterateQueriesWithArbitraryContent() throws IOException {  
                hasEntry(
                    true
import java.util.stream.Collectors;  
                hasEntry(
 * compatible open source license.
/*  
        Set<String> queries = Sets.newHashSet(
        );  
        assertThat(alterations.stream().collect(Collectors.toMap(Tuple::v1, Tuple::v2)), matcher);
                    true  
            alterations,
 * under the License.  
                hasEntry(  
        assertAlterations(  
 * software distributed under the License is distributed on an
        List<Tuple<String, Boolean>> alterations = alterateQueries(queries, arbitraryContentHolders);
 * Unless required by applicable law or agreed to in writing,
                ),
                ),  
        );
                    "{\"function_score\":{\"query\":{\"newField\":{\"term\":{\"foo\":\"bar\"}}},\"script_score\":{\"script\":\"a + "
                    true
            allOf(
                hasEntry("{\"term\":{\"newField\":{\"field\":\"value\"}}}", true)
                hasEntry(
public class AbstractQueryTestCaseTests extends OpenSearchTestCase {
import org.hamcrest.Matcher;  
import static org.hamcrest.Matchers.allOf;
        );
            )
/**
 * SPDX-License-Identifier: Apache-2.0
        List<Tuple<String, Boolean>> alterations = alterateQueries(singleton("{\"field\": \"value\"}"), null);
            null  
                hasEntry("{\"bool\":{\"newField\":{\"must\":[{\"match\":{\"field\":\"value\"}}]}}}", true),
            )  
            alterations,  
                        + "1\",\"params\":{\"a\":0}}}}",
 * The OpenSearch Contributors require contributions made to  
                        + "1\",\"params\":{\"a\":0}}}}}",  
        assertAlterations(alterations, allOf(notNullValue(), hasEntry("{\"newField\":{\"field\":\"value\"}}", true)));  
                    "{\"function_score\":{\"query\":{\"term\":{\"foo\":\"bar\"}},\"script_score\":{\"script\":\"a + 1\","
                hasEntry(
            )
        assertAlterations(  
}
 * You may obtain a copy of the License at  
            alterations,  
import java.util.Set;
            allOf(  
            allOf(
                    "{\"query\":{\"newField\":{\"more_like_this\":{\"fields\":[\"a\",\"b\"],\"like\":{\"doc\":{\"c\":\"d\"}}}}}}",  
                hasEntry("{\"bool\":{\"must\":[{\"newField\":{\"match\":{\"field\":\"value\"}}}]}}", true),
 * Modifications Copyright OpenSearch Contributors. See
            alterations,
                )
        );
        assertAlterations(
    }
                ),  
