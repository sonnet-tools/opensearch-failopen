 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
            + "with patterns (global => [*]); this template [1] will take precedence during new index creation";  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.equalTo;
 * compatible open source license.
        assertThat(matcher.group(3), equalTo("global"));
        Matcher matcher = OpenSearchRestTestCase.CREATE_INDEX_MULTIPLE_MATCHING_TEMPLATES.matcher(input);  
 * GitHub history for details.
        assertThat(matcher.group(4), equalTo("global => [*]"));  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
        assertThat(matcher.group(1), equalTo("test_index"));
        assertThat(matcher.matches(), is(true));
        String input = "index [test_index] matches multiple legacy templates [global, prevent-bwc-deprecation-template], "
 * KIND, either express or implied.  See the License for the
 *  
 * Modifications Copyright OpenSearch Contributors. See  
 * You may obtain a copy of the License at  
 *
        assertThat(matcher.group(5), equalTo("1"));
        assertThat(matcher.group(1), equalTo("1"));  
 *
 * not use this file except in compliance with the License.
        assertThat(matcher.matches(), is(true));
        input = "index template [1] has index patterns [logs-*] matching patterns from existing older templates [global] "
 * under the License.  
import static org.hamcrest.Matchers.is;
        assertThat(matcher.group(2), equalTo("logs-*"));
    public void testIgnoreMatchMultipleTemplatesPattern() {  
import java.util.regex.Matcher;
        assertThat(matcher.group(2), equalTo("global, prevent-bwc-deprecation-template"));  
public class OpenSearchRestTestCaseTests extends OpenSearchTestCase {
/*
/*  
import org.opensearch.test.OpenSearchTestCase;  
 * The OpenSearch Contributors require contributions made to  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
            + "composable templates will only match a single template";
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
        matcher = OpenSearchRestTestCase.PUT_TEMPLATE_MULTIPLE_MATCHING_TEMPLATES.matcher(input);
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.test.rest;
 * this work for additional information regarding copyright
 */
}
    }
