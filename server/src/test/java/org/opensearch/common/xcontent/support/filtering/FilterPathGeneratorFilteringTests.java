        );
 * license agreements. See the NOTICE file distributed with
            SAMPLE,
            "h.i.j.k",
        );
            SAMPLE,
            false,
        assertResult(SAMPLE, "h.*.j.k.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
 * You may obtain a copy of the License at
            SAMPLE,
        assertResult(SAMPLE, "h.*.j.k", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
        assertResult(
    }
            SAMPLE,
        );
        );
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        );
/*
        );
        assertResult(SAMPLE, "h.i.*.k", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "h.i.*.k.l",
        assertResult(SAMPLE, "d", true, "{'d':[0,1,2]}");
        assertResult(
        assertResult(SAMPLE, "h", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            assertThat(os.bytes().utf8ToString(), equalTo(replaceQuotes(expected)));
            "h.i.*",
        assertResult(
            false,
            SAMPLE,
        return s.replace('\'', '"');
            SAMPLE,
        assertResult(SAMPLE, "e.f1", true, "{'e':[{'f1':'f1_value'}]}");
            false,
            SAMPLE,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            false,
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f2':'f2_value'},"
            false,
            "e.*2",
        assertResult(SAMPLE, "h.*.j.*.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
                    new FilterPathBasedFilter(Collections.singleton(filter), inclusive),
        assertResult(
            SAMPLE,
        );
            false,
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        assertResult(SAMPLE, "e.*2", true, "{'e':[{'f2':'f2_value'},{'g2':'g2_value'}]}");
            false,
}
    private void assertResult(String input, String filter, boolean inclusive, String expected) throws Exception {
    }
                + "'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor
            SAMPLE,
        );
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        assertResult(SAMPLE, "*.i.j.k", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'g1':'g1_value','g2':'g2_value'}]," + "'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
        assertResult(SAMPLE, "h.i", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            false,
 * this work for additional information regarding copyright
            "h.i.j.k.*",
        assertResult("{'a':0,'b.c':'value','b':{'c':'c_value'}}", "b.c", true, "{'b':{'c':'c_value'}}");
 * not use this file except in compliance with the License.
            SAMPLE,
            "{'a':0,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            "z",
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            false,
            "h.*.j.k.l",
            "e.f2",
            false,
                    true
    public void testExclusiveFiltersWithDots() throws Exception {
        assertResult(
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            false,
            "h.*.j.k",
    private String replaceQuotes(String s) {
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
        final String SAMPLE = "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"
 * Modifications Copyright OpenSearch Contributors. See
        }
            SAMPLE,
        assertResult(SAMPLE, "**.*2", true, "{'e':[{'f2':'f2_value'},{'g2':'g2_value'}]}");
        );
        assertResult("{'a':0,'b.c':'value','b':{'c':'c_value'}}", "b\\.c", true, "{'b.c':'value'}");
        );
        );
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        );
        final String SAMPLE = "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"
            "e.f*",
    private final JsonFactory JSON_FACTORY = new JsonFactory();
        );
            SAMPLE,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
        );
            "h.i.j.*.l",
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertResult(
            "**.l",
        assertResult(
            "h.*.j.*.l",
        assertResult(
        assertResult(
            "*.i.j",
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
import org.opensearch.test.OpenSearchTestCase;
            false,
            "a",
        assertResult(SAMPLE, "h.i.j", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
        assertResult(SAMPLE, "z", true, "");
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        );
            SAMPLE,
            false,
        assertResult(
                try (JsonParser parser = JSON_FACTORY.createParser(replaceQuotes(input))) {
        );
            SAMPLE,
        );
        assertResult(SAMPLE, "e", true, "{'e':[{'f1':'f1_value','f2':'f2_value'},{'g1':'g1_value','g2':'g2_value'}]}");
            false,
 * this file be licensed under the Apache-2.0 license or a
        assertResult(SAMPLE, "b", true, "{'b':true}");
            "{'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"
import java.util.Collections;
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value'},{'g1':'g1_value'}],"
            false,
            SAMPLE,
    }
import org.opensearch.core.xcontent.filtering.FilterPathBasedFilter;
        assertResult(
            try (
            SAMPLE,
        assertResult(
        );
 * Unless required by applicable law or agreed to in writing,
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"
        assertResult("{'a':0,'b.c':'value','b':{'c':'c_value'}}", "b.c", false, "{'a':0,'b.c':'value'}");
            false,
            "h.i.j.*",
 * the Apache License, Version 2.0 (the "License"); you may
            SAMPLE,
            "{'a':0,'b':true,'d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        assertResult(
            false,
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
            SAMPLE,
import tools.jackson.core.json.JsonFactory;
/*
        assertResult(SAMPLE, "a", true, "{'a':0}");
        );
 *
import static org.hamcrest.Matchers.equalTo;
        assertResult(SAMPLE, "h.i.*.k.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}";
            false,
                }
        );
                    JSON_FACTORY.createGenerator(os),
 */
            false,
import tools.jackson.core.filter.FilteringGeneratorDelegate;
            "b",
            SAMPLE,
            "h.i",
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
        assertResult(
        );
            "c",
            false,
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            false,
            "h.i.j",
            "h.i.j.k.l",
        assertResult(SAMPLE, "*.i.j.k.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
package org.opensearch.common.xcontent.support.filtering;
        assertResult(
        assertResult(
        assertResult(SAMPLE, "h.i.*", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
import tools.jackson.core.JsonParser;
        assertResult(
            SAMPLE,
        );
        assertResult(
            }
            SAMPLE,
                )
            SAMPLE,
        assertResult(
        );
            false,
        assertResult(SAMPLE, "h.*.j", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            SAMPLE,
        assertResult(SAMPLE, "c", true, "{'c':'c_value'}");
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
            "*.i.j.k",
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
                        generator.copyCurrentStructure(parser);
            SAMPLE,
        assertResult(
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            SAMPLE,
            false,
            false,
        assertResult(SAMPLE, "*.i", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}";
        assertResult(SAMPLE, "**.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
        assertResult(
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        assertResult(SAMPLE, "e", false, "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
        );
    public void testInclusiveFilters() throws Exception {
        assertResult(SAMPLE, "h.*", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
public class FilterPathGeneratorFilteringTests extends OpenSearchTestCase {
 */
        );
        assertResult(
            "h.*",
            "{'a':0,'b':true,'c':'c_value','e':[{'f1':'f1_value','f2':'f2_value'},"
        try (BytesStreamOutput os = new BytesStreamOutput()) {
 * KIND, either express or implied.  See the License for the
            SAMPLE,
            "**.*2",
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
 *
            SAMPLE,
    public void testExclusiveFilters() throws Exception {
            "d",
        assertResult(
 */
            false,
        );
            "e.f1",
        );
            false,
    }
        );
                FilteringGeneratorDelegate generator = new FilteringGeneratorDelegate(
/*
 * under the License.
        assertResult(
        assertResult(
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        assertResult(SAMPLE, "*.i.j", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
                    }
            false,
 * compatible open source license.
        assertResult(
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            ) {
        assertResult(SAMPLE, "h.i.j.k", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            SAMPLE,
    }
        assertResult(
            "*.i.j.k.l",
            "*.i",
        assertResult(SAMPLE, "h.i.j.k.*", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            "h.*.j",
 *
        assertResult(SAMPLE, "e.f*", true, "{'e':[{'f1':'f1_value','f2':'f2_value'}]}");
        );
            false,
            "h.i.*.k",
            SAMPLE,
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value'},"
        assertResult(SAMPLE, "h.i.j.*.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            false,
    public void testInclusiveFiltersWithDots() throws Exception {
        assertResult(SAMPLE, "h.i.j.k.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
        );
import tools.jackson.core.filter.TokenFilter.Inclusion;
 * GitHub history for details.
            false,
        assertResult(SAMPLE, "e.f2", true, "{'e':[{'f2':'f2_value'}]}");
        assertResult(
        assertResult("{'a':0,'b.c':'value','b':{'c':'c_value'}}", "b\\.c", false, "{'a':0,'b':{'c':'c_value'}}");
        assertResult(
                    while (parser.nextToken() != null) {
 * The OpenSearch Contributors require contributions made to
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            SAMPLE,
        assertResult(
            "h",
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
    }
            false,
        assertResult(
                + "{'g1':'g1_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
 * specific language governing permissions and limitations
        );
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
            SAMPLE,
 * ownership. Elasticsearch licenses this file to you under
                    Inclusion.INCLUDE_ALL_AND_PATH,
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value'},"
        assertResult(SAMPLE, "h.i.j.*", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
