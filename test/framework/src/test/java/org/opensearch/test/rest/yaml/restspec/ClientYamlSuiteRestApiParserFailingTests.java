 * The OpenSearch Contributors require contributions made to  
                + "    \"body\": null"
                + "  }"
                + "  \"ping\": {"
        assertThat(e.getMessage(), containsString(expectedErrorMessage));
 * Unless required by applicable law or agreed to in writing,
        + "  }"
            "ping API: found duplicate path [/pingtwo]"
                + "         {\"path\":\"/pingtwo\", \"methods\": [\"PUT\"]}, "  
            "API [ping] should have " + "the same name as its file [not_matching.json]"
                + "      \"paths\": [{\"path\":\"/\", \"parts\": {}, \"methods\": [\"PUT\", \"PUT\"]}],"
    private static final String BROKEN_SPEC_PARAMS = "{\n"
        + "        } \n"
 * Modifications Copyright OpenSearch Contributors. See  
    }  
 * Licensed to Elasticsearch under one or more contributor  
public class ClientYamlSuiteRestApiParserFailingTests extends OpenSearchTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(e.getMessage(), containsString(expectedErrorMessage));
                + "        \"description\" : \"Whether specified concrete indices should be ignored when unavailable (missing or closed)\""
            "ping API: found duplicate method [PUT]"  
        + "    \"body\": null"  
        + "    \"url\": {"  
                + "        \"description\" : \"Whether specified concrete indices should be ignored when unavailable (missing or closed)\""
        + "      \"paths\": [{\"path\": \"path\", \"methods\": [\"HEAD\"]}]"
                + "}",
        + "    \"url\": {"
                + "      \"params\": {"  
package org.opensearch.test.rest.yaml.restspec;
 * not use this file except in compliance with the License.
/*
                + "}",  
    }
            "ping.json",
                + "    \"url\": {"
 */
        XContentParser parser = createParser(YamlXContent.yamlXContent, brokenJson);
            "{\n"  
import org.opensearch.common.xcontent.yaml.YamlXContent;  
    public void testSpecNameMatchesFilename() throws Exception {
        parseAndExpectParsingException(  
        );
 * compatible open source license.
 */  
    }
                + "    },"  
                + "      \"paths\": ["
        parseAndExpectParsingException(
            "{\"ping\":{}}",  
        ClientYamlSuiteRestApiParser restApiParser = new ClientYamlSuiteRestApiParser();
            "ping.json",  
 * the Apache License, Version 2.0 (the "License"); you may
            BROKEN_SPEC_PARAMS,
        ClientYamlSuiteRestApiParser restApiParser = new ClientYamlSuiteRestApiParser();
/*  
                + "        \"type\" : \"boolean\",\n"
 * ownership. Elasticsearch licenses this file to you under  
        + "    \"stability\": \"stable\",\n"
                + "    \"stability\": \"stable\",\n"  
                + "    },"
 * this work for additional information regarding copyright
    private void parseAndExpectParsingException(String brokenJson, String location, String expectedErrorMessage) throws Exception {  
        + "}";  
            BROKEN_SPEC_PARTS,
/**
 *  
    }
            "ping API: expected [params] field in rest api definition to contain an object"
import static org.hamcrest.Matchers.containsString;
 */
        + "  \"ping\": {"  
        parseAndExpectParsingException(
        XContentParser parser = createParser(YamlXContent.yamlXContent, brokenJson);  
        + "    \"stability\": \"stable\",\n"  
        + "    },"  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> restApiParser.parse(location, parser));  
        + "      \"paths\": [{ \"path\":\"/\", \"parts\": { \"type\":\"boolean\",}}],"
 * specific language governing permissions and limitations
                + "        \"type\" : \"boolean\",\n"  
}  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentParser;
    private static final String BROKEN_SPEC_PARTS = "{\n"  
                + "    \"body\": null"
                + "  }"  
    public void testDuplicatePaths() throws Exception {
 * These tests are not part of {@link ClientYamlSuiteRestApiParserTests} because the tested failures don't allow to consume the whole yaml
                + "{\"path\":\"/pingtwo\", \"methods\": [\"PUT\"]}],"
        + "    },"
        + "    \"body\": null"
        );  
        parseAndExpectIllegalArgumentException(
    // see params section is broken, an inside param is missing
 * software distributed under the License is distributed on an
                + "    \"documentation\": \"http://www.elasticsearch.org/guide/\","
        ParsingException e = expectThrows(ParsingException.class, () -> restApiParser.parse(location, parser));
                + "      }"  
        + "      \"description\" : \"Whether specified concrete indices should be ignored when unavailable (missing or closed)\"\n"
        + "          \"type\" : \"boolean\",\n"
    public void testBrokenSpecShouldThrowUsefulExceptionWhenParsingFailsOnParts() throws Exception {
        + "      \"params\": {\n"  
        );
            "ping.json",
/*
            "{\n"  
        );
        + "}";
    }
    private void parseAndExpectIllegalArgumentException(String brokenJson, String location, String expectedErrorMessage) throws Exception {
 */
        + "    \"documentation\": \"http://www.elasticsearch.org/guide/\","
        parseAndExpectIllegalArgumentException(
 * under the License.  
    public void testDuplicateMethods() throws Exception {
 *
            "ping.json",
    }
    }  
        );  
        + "      \"type\" : \"boolean\",\n"
 *
 * KIND, either express or implied.  See the License for the
                + "  \"ping\": {"
 * You may obtain a copy of the License at  
    // see parts section is broken, an inside param is missing
 * stream  
            "ping API: expected [parts] field in rest api definition to contain an object"  
        + "    \"params\": {"  
                + "      }"
    public void testBrokenSpecShouldThrowUsefulExceptionWhenParsingFailsOnParams() throws Exception {  
                + "    \"url\": {"
                + "    \"stability\": \"stable\",\n"  
            "not_matching.json",
 *     http://www.apache.org/licenses/LICENSE-2.0
        + "  }"
 * license agreements. See the NOTICE file distributed with
        + "    },"
import org.opensearch.core.common.ParsingException;
 * SPDX-License-Identifier: Apache-2.0
        + "          \"description\" : \"Whether specified concrete indices should be ignored when unavailable (missing or closed)\"\n"  
        + "        \"ignore_unavailable\": {\n"
        + "  \"ping\": {"
        + "    \"documentation\": \"http://www.elasticsearch.org/guide/\","
import org.opensearch.test.OpenSearchTestCase;  
                + "    \"documentation\": \"http://www.elasticsearch.org/guide/\","
                + "      \"params\": {"
