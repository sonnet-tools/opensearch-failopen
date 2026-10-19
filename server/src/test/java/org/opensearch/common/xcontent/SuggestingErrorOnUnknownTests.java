    }
    public void testBadCandidates() {
package org.opensearch.common.xcontent;
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
}  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(errorMessage("foo", "bar", "fop", "fou", "baz"), equalTo("[test] unknown field [foo] did you mean any of [fop, fou]?"));
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
public class SuggestingErrorOnUnknownTests extends OpenSearchTestCase {
/*  
/*  
    }
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 *  
    public void testOneCandidate() {
 * software distributed under the License is distributed on an
 *
 */  
import static org.hamcrest.Matchers.equalTo;
 * Modifications Copyright OpenSearch Contributors. See
    public void testNoCandidates() {  
import java.util.Arrays;  
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchTestCase;
 * You may obtain a copy of the License at  
/*
    private String errorMessage(String unknownField, String... candidates) {
    public void testManyCandidate() {  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 */  
 * The OpenSearch Contributors require contributions made to  
        assertThat(errorMessage("foo"), equalTo("[test] unknown field [foo]"));
        assertThat(errorMessage("foo", "bar", "baz"), equalTo("[test] unknown field [foo]"));
        return new SuggestingErrorOnUnknown().errorMessage("test", unknownField, Arrays.asList(candidates));  
    }  
 *
        assertThat(errorMessage("foo", "bar", "fop"), equalTo("[test] unknown field [foo] did you mean [fop]?"));  
 * not use this file except in compliance with the License.
    }
 */
 * specific language governing permissions and limitations
