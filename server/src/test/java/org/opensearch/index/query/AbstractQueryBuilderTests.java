 * Licensed to Elasticsearch under one or more contributor  
import org.junit.AfterClass;
public class AbstractQueryBuilderTests extends OpenSearchTestCase {
 * Unless required by applicable law or agreed to in writing,
        return xContentRegistry;
    }
 * under the License.  
 * compatible open source license.
/*  
 * Modifications Copyright OpenSearch Contributors. See
    }  
        assertFalse(query.supportsIntraSegmentSearch());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.SearchModule;  
    public void testDefaultSupportsIntraSegmentSearch() {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {
 * ownership. Elasticsearch licenses this file to you under  
import org.junit.BeforeClass;  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        xContentRegistry = null;  
 * this work for additional information regarding copyright
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {
package org.opensearch.index.query;
        }
            assertEquals("query malformed, empty clause found at [1:2]", exception.getMessage());  
/*
            ParsingException exception = expectThrows(ParsingException.class, () -> parseInnerQueryBuilder(parser));
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {  
import org.opensearch.common.settings.Settings;
        }
        xContentRegistry = new NamedXContentRegistry(new SearchModule(Settings.EMPTY, emptyList()).getNamedXContents());
            assertEquals("unknown query [match_] did you mean any of [match, match_all, match_none]?", exception.getMessage());
        source = "{ \"foo\" : \"bar\" }";  
import org.opensearch.core.common.ParsingException;  
            parser.nextToken();  
 * license agreements. See the NOTICE file distributed with
        QueryBuilder query = new MatchQueryBuilder("foo", "bar");
    }
/*  
    }
            assertEquals("unknown query [boool] did you mean [bool]?", exception.getMessage());  
            assertEquals(query, actual);
}
            ParsingException exception = expectThrows(ParsingException.class, () -> parseInnerQueryBuilder(parser));
    }
            assertEquals("[foo] query malformed, no start_object after query name", exception.getMessage());  
        String source = "{ \"foo\": \"bar\" }";
import static java.util.Collections.emptyList;
 * not use this file except in compliance with the License.
            ParsingException exception = expectThrows(ParsingException.class, () -> parseInnerQueryBuilder(parser));
    public void testParseInnerQueryBuilder() throws IOException {  
    protected NamedXContentRegistry xContentRegistry() {
        String source = query.toString();
 *
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {
 * GitHub history for details.
        }
    @AfterClass
 * You may obtain a copy of the License at  
    public static void cleanup() {
 *  
        }  
import org.opensearch.common.xcontent.json.JsonXContent;
    public void testParseInnerQueryBuilderExceptions() throws IOException {  
 */  
    public static void init() {  
 */
 * KIND, either express or implied.  See the License for the
        source = "{ \"match_\" : {} }";
        QueryBuilder query = new MatchAllQueryBuilder();  
 */  
            parser.nextToken(); // don't start with START_OBJECT to provoke exception
        }
import org.opensearch.test.OpenSearchTestCase;
        source = "{}";  
 * specific language governing permissions and limitations
    private static NamedXContentRegistry xContentRegistry;  
 *
import org.opensearch.core.xcontent.XContentParser;
            assertEquals("[_na] query malformed, must start with start_object", exception.getMessage());  
 * software distributed under the License is distributed on an
            QueryBuilder actual = parseInnerQueryBuilder(parser);
        }  
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
        source = "{ \"boool\" : {} }";  
 *     http://www.apache.org/licenses/LICENSE-2.0
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
import java.io.IOException;
    @BeforeClass
            ParsingException exception = expectThrows(ParsingException.class, () -> parseInnerQueryBuilder(parser));
            IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> parseInnerQueryBuilder(parser));
