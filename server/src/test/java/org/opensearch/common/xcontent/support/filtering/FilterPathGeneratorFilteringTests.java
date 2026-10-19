        assertResult(SAMPLE, "**.*2", true, "{'e':[{'f2':'f2_value'},{'g2':'g2_value'}]}");
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
            "**.l",
                FilteringGeneratorDelegate generator = new FilteringGeneratorDelegate(  
        );  
            "*.i",
            false,
        assertResult(  
        );  
    private void assertResult(String input, String filter, boolean inclusive, String expected) throws Exception {  
                try (JsonParser parser = JSON_FACTORY.createParser(replaceQuotes(input))) {
        final String SAMPLE = "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"
 *     http://www.apache.org/licenses/LICENSE-2.0
            "h.i.j.*",  
            "h",  
            SAMPLE,
        assertResult(SAMPLE, "h.i.*.k", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "e.f1",
            "z",  
            false,
        );
        assertResult(SAMPLE, "h.i", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            false,  
        assertResult(SAMPLE, "*.i.j.k.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'g1':'g1_value','g2':'g2_value'}]," + "'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"  
        assertResult(
        assertResult(SAMPLE, "c", true, "{'c':'c_value'}");  
        assertResult("{'a':0,'b.c':'value','b':{'c':'c_value'}}", "b.c", true, "{'b':{'c':'c_value'}}");  
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value'},"
/*  
 * Modifications Copyright OpenSearch Contributors. See
        assertResult(SAMPLE, "h.*.j", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        assertResult(SAMPLE, "*.i.j.k", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "h.*",
        assertResult(SAMPLE, "e.*2", true, "{'e':[{'f2':'f2_value'},{'g2':'g2_value'}]}");  
            false,
    }  
        assertResult(  
    public void testInclusiveFilters() throws Exception {  
        );
        assertResult(
            false,  
        assertResult(SAMPLE, "e.f2", true, "{'e':[{'f2':'f2_value'}]}");
    }
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.core.xcontent.filtering.FilterPathBasedFilter;
        assertResult(  
        assertResult(
            "{'a':0,'b':true,'d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"
    }
        assertResult(
        );
        assertResult(SAMPLE, "**.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            false,
 * software distributed under the License is distributed on an
package org.opensearch.common.xcontent.support.filtering;
            }  
        assertResult(
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            SAMPLE,
        assertResult(SAMPLE, "h", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");  
        assertResult(SAMPLE, "h.i.j.k.*", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "{'a':0,'b':true,'c':'c_value','e':[{'f1':'f1_value','f2':'f2_value'},"  
}
        assertResult(
        );
        assertResult(SAMPLE, "h.i.j.*.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "d",
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value'},{'g1':'g1_value'}],"  
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"  
        final String SAMPLE = "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"
        assertResult(SAMPLE, "h.i.j", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");  
            SAMPLE,
 * SPDX-License-Identifier: Apache-2.0
            "h.i.j.k.l",  
            "h.*.j.*.l",
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
        assertResult(
            false,
        assertResult(SAMPLE, "b", true, "{'b':true}");
        assertResult(
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"
            false,
        );
                + "'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"  
            SAMPLE,  
        );
        assertResult(  
            false,
        try (BytesStreamOutput os = new BytesStreamOutput()) {
        );  
        assertResult(  
                    }
        assertResult(
/*  
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            SAMPLE,
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
            false,
    }  
                    JSON_FACTORY.createGenerator(os),
            false,  
            false,  
        );  
        assertResult(SAMPLE, "h.i.j.k", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "e.f2",  
        assertResult(
            "h.i.*.k",  
            SAMPLE,
            "h.*.j",
        assertResult("{'a':0,'b.c':'value','b':{'c':'c_value'}}", "b.c", false, "{'a':0,'b.c':'value'}");
        );
            false,
                    Inclusion.INCLUDE_ALL_AND_PATH,  
            SAMPLE,
            false,  
            SAMPLE,
            "h.i.j.k",  
        );
            false,
    private String replaceQuotes(String s) {
            SAMPLE,
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        assertResult(SAMPLE, "z", true, "");
        assertResult(SAMPLE, "e.f1", true, "{'e':[{'f1':'f1_value'}]}");  
            + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}";  
            false,
        assertResult(SAMPLE, "*.i", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            SAMPLE,  
            SAMPLE,  
 * ownership. Elasticsearch licenses this file to you under  
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
        assertResult(
            "e.f*",
            SAMPLE,  
        assertResult(SAMPLE, "h.*.j.*.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
        assertResult(
        assertResult("{'a':0,'b.c':'value','b':{'c':'c_value'}}", "b\\.c", false, "{'a':0,'b':{'c':'c_value'}}");  
        assertResult(SAMPLE, "h.i.*.k.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");  
            "*.i.j",
        assertResult(
                        generator.copyCurrentStructure(parser);  
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            "*.i.j.k",  
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"  
        );
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        assertResult(
        assertResult(SAMPLE, "h.*.j.k.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            "h.i.j.k.*",
            "h.i.*.k.l",
        }
        return s.replace('\'', '"');  
            + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}";
            SAMPLE,  
 * compatible open source license.
import tools.jackson.core.JsonParser;
        assertResult(SAMPLE, "e.f*", true, "{'e':[{'f1':'f1_value','f2':'f2_value'}]}");
 */
 * Unless required by applicable law or agreed to in writing,
            false,
            "{'a':0,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"
 * You may obtain a copy of the License at  
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"  
        );  
            "{'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'},"  
            SAMPLE,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            false,  
        );
        assertResult(SAMPLE, "d", true, "{'d':[0,1,2]}");
            SAMPLE,
        );  
            SAMPLE,  
            "h.i",  
 */  
 * GitHub history for details.
                )
            ) {  
                    while (parser.nextToken() != null) {
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"  
        assertResult(SAMPLE, "h.*.j.k", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");  
 *
            SAMPLE,
    public void testExclusiveFiltersWithDots() throws Exception {
            false,
    public void testExclusiveFilters() throws Exception {
 *
            SAMPLE,  
            false,
        assertResult(  
        assertResult(SAMPLE, "e", true, "{'e':[{'f1':'f1_value','f2':'f2_value'},{'g1':'g1_value','g2':'g2_value'}]}");
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"  
    }
        );
            SAMPLE,
            false,
public class FilterPathGeneratorFilteringTests extends OpenSearchTestCase {
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"  
            "h.i.j.*.l",
            "*.i.j.k.l",
    private final JsonFactory JSON_FACTORY = new JsonFactory();
 */  
        );
            "c",  
        assertResult(SAMPLE, "h.i.*", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");  
        );
            SAMPLE,
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            false,  
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f2':'f2_value'},"
            false,
        );
            SAMPLE,
        assertResult(SAMPLE, "h.i.j.k.l", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            SAMPLE,  
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value'},"
 * specific language governing permissions and limitations
        assertResult(
        );
        );
            SAMPLE,
            try (
        assertResult(
 * this work for additional information regarding copyright
        );
 * this file be licensed under the Apache-2.0 license or a
    public void testInclusiveFiltersWithDots() throws Exception {
            "h.*.j.k.l",
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"  
            SAMPLE,
/*
        );
        assertResult(
            false,
        );  
            SAMPLE,
        );  
            SAMPLE,  
            false,
            false,
 * under the License.  
                }
            SAMPLE,
            false,
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
            "h.i.*",
        assertResult(SAMPLE, "a", true, "{'a':0}");
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"
            false,
            "e.*2",
            false,
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"  
 * license agreements. See the NOTICE file distributed with
        assertResult(
            "**.*2",  
            "h.*.j.k",  
import tools.jackson.core.filter.FilteringGeneratorDelegate;
            "b",
        assertResult(
            false,
            SAMPLE,
            assertThat(os.bytes().utf8ToString(), equalTo(replaceQuotes(expected)));
        assertResult(
        assertResult(
            "a",
        );
import tools.jackson.core.filter.TokenFilter.Inclusion;  
import java.util.Collections;
                    new FilterPathBasedFilter(Collections.singleton(filter), inclusive),
        assertResult(SAMPLE, "h.*", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
        assertResult(  
import org.opensearch.common.io.stream.BytesStreamOutput;
 * KIND, either express or implied.  See the License for the
        assertResult(SAMPLE, "e", false, "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");  
            SAMPLE,  
            "h.i.j",  
                + "{'g1':'g1_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"  
                    true
                + "{'g1':'g1_value','g2':'g2_value'}],'h':{'i':{'j':{'k':{'l':'l_value'}}}}}"  
        assertResult(SAMPLE, "h.i.j.*", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
            SAMPLE,
            false,
        assertResult("{'a':0,'b.c':'value','b':{'c':'c_value'}}", "b\\.c", true, "{'b.c':'value'}");
        assertResult(
        assertResult(
        );
            SAMPLE,
    }
        );  
import static org.hamcrest.Matchers.equalTo;  
 *  
        );  
        assertResult(
 * not use this file except in compliance with the License.
import tools.jackson.core.json.JsonFactory;
            "{'a':0,'b':true,'c':'c_value','d':[0,1,2],'e':[{'f1':'f1_value','f2':'f2_value'}," + "{'g1':'g1_value','g2':'g2_value'}]}"
        assertResult(SAMPLE, "*.i.j", true, "{'h':{'i':{'j':{'k':{'l':'l_value'}}}}}");
        );  
