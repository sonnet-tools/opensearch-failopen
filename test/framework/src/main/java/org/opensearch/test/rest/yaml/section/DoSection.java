                apiCallSection.getNodeSelector()  
            default:
            } else {
                for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {
    public DoSection(XContentLocation location) {
import org.opensearch.core.xcontent.XContentParseException;  
 *      catch:      missing
                    // We skip warnings related to types deprecation because they are *everywhere*.  
                    }
 * KIND, either express or implied.  See the License for the
 *          - Maybe this warning shows up
            + " "  
            }
        }
    }
        final Set<String> expected = expectedWarningHeaders.stream()  
                        } else {  
    }
                return true;
            // . as in haskell's "compose" operator  
    public String getCatch() {  
                    doSection.setCatch(parser.text());
        try {  
        } catch (ClientYamlTestResponseException e) {
            doSection.setExpectedWarningHeaders(unmodifiableList(expectedWarnings));
    private final XContentLocation location;
                    if (token != XContentParser.Token.END_ARRAY) {
    }
        final List<String> missing = new ArrayList<>();  
        );
                    }
        @Override
        };  
        public int hashCode() {  
                    while ((token = parser.nextToken()) == XContentParser.Token.VALUE_STRING) {
        private ComposeNodeSelector(NodeSelector lhs, NodeSelector rhs) {  
import static org.hamcrest.Matchers.notNullValue;
                fail(formatStatusCodeMessage(response, catchStatusCode));
 *          id:     1  
    }  
 */
        }
     * failed. Defaults to emptyList.
                    + "], the do section is not properly indented"
    public void execute(ClientYamlTestExecutionContext executionContext) throws IOException {  
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    while ((token = parser.nextToken()) == XContentParser.Token.VALUE_STRING) {  
                            selectorName = parser.currentName();
import static org.opensearch.test.hamcrest.RegexMatcher.matches;  
            logger.info("found [catch: param], no request sent");
        this.apiCallSection = apiCallSection;
            case "attribute":  
                return "version ranges " + skipVersionRanges;
    public static DoSection parse(XContentParser parser) throws IOException {
                }
                    error.toString(),  
            return Objects.equals(lhs, that.lhs) && Objects.equals(rhs, that.rhs);
     */
                "expected ["  
            }  
        switch (name) {
     * Defaults to emptyList.  
                        } else if (token.isValue()) {
                        }
            if (Strings.hasLength(catchParam)) {
        catches.put("forbidden", tuple("403", equalTo(403)));  
                unexpected.add(header);  
        XContentParser.Token token;
                allOf(  
        }  
    }
    void setAllowedWarningHeaders(List<String> allowedWarningHeaders) {
                    String headerName = null;
        String currentFieldName = null;  
            appendBadHeaders(failureMessage, missing, "did not get expected warning header" + (missing.size() > 1 ? "s" : ""));  
                                XContentParser bodyParser = JsonXContent.jsonXContent.createParser(
 * compatible open source license.
                }
            }  
        public void select(Iterable<Node> nodes) {  
            } else if (catchParam.length() > 2 && catchParam.startsWith("/") && catchParam.endsWith("/")) {
    }  
                unmatched.add(header);
        }
                key = parser.currentName();  
 * this work for additional information regarding copyright
            throw new XContentParseException(parser.getTokenLocation(), "expected START_OBJECT");
import static org.opensearch.common.collect.Tuple.tuple;
import java.util.Objects;
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        @Override
                    }  
                 * attribute metadata set so it can be used against nodes that
            if (apiCallSection == null) {
                apiCallSection.getApi(),
                String catchStatusCode;  
                    not(equalTo(403)),
            throw new XContentParseException(parser.getTokenLocation(), "expected [version] to be a value");
 *          - Please, stop. It hurts.
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
 *      allowed_warnings:  
                // remove delimiters from regex
    private String formatStatusCodeMessage(ClientYamlTestResponse restTestResponse, String expected) {
        }  
            this.rhs = Objects.requireNonNull(rhs, "rhs is required");
                } else if (catchParam.startsWith("/") && catchParam.endsWith("/")) {  
                    throw new ParsingException(parser.getTokenLocation(), "unsupported field [" + currentFieldName + "]");
        }
            formatStatusCodeMessage(restTestResponse, stringMatcherTuple.v1()),
            if (token == XContentParser.Token.FIELD_NAME) {
                        expectedWarnings.add(parser.text());  
                } else if (currentFieldName != null) { // must be part of API call then
    }
                Object error = executionContext.response("error");  
import java.util.Map;
import org.opensearch.core.common.ParsingException;
                if ("headers".equals(currentFieldName)) {
                sb.append("\t").append(header).append("\n");
                                throw new IllegalStateException("expected [attributes] metadata to be set but got " + node);
    List<String> getExpectedWarningHeaders() {
                throw new UnsupportedOperationException("catch value [" + catchParam + "] not supported");
    }
            @Override
                }
                    }
            for (String w : expectedWarnings) {
                            headerName = parser.currentName();
            fail(failureMessage.toString());
 * license agreements. See the NOTICE file distributed with
            + restTestResponse.getStatusCode()
            tuple(
                 * can assert that the data is sniffed.
                            }
                    e.getResponseException().getResponse().getStatusLine().getStatusCode(),  
     */  
                } else {
        }  
 * Represents a do section:
                    throw new ParsingException(parser.getTokenLocation(), "unknown array [" + currentFieldName + "]");
            sb.append("]\n");  
                            } else {
 *          - But it isn't actually required for the test to pass.
                    not(equalTo(408)),  
        return expectedWarningHeaders;  
            if (token == XContentParser.Token.FIELD_NAME) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                }
    private List<String> allowedWarningHeaders = emptyList();  
    private static NodeSelector parseAttributeValuesSelector(XContentParser parser) throws IOException {  
        catches.put("unauthorized", tuple("401", equalTo(401)));
                    greaterThanOrEqualTo(400),
        }  
            final Matcher matcher = HeaderWarning.WARNING_HEADER_PATTERN.matcher(header);
            this.lhs = Objects.requireNonNull(lhs, "lhs is required");
                        }
                String regex = catchParam.substring(1, catchParam.length() - 1);  
import java.util.Set;  
            restTestResponse.getStatusCode(),
    private ApiCallSection apiCallSection;
import java.util.List;  
    }
                        for (Node node : nodes) {
        XContentParser.Token token;
import org.apache.logging.log4j.Logger;
                                    apiCallSection.addBody(bodyParser.mapOrdered());
 *      warnings:
                        if (token == XContentParser.Token.FIELD_NAME) {
                    + parser.currentToken()
            ClientYamlTestResponse response = executionContext.callApi(
                    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertThat("error was expected in the response", error, notNullValue());
                    if (token != XContentParser.Token.END_ARRAY) {  
        this.catchParam = catchParam;
    void checkWarningHeaders(final List<String> warningHeaders, final Version clusterManagerVersion) {  
        }
 */  
                    + "found ["  
                    not(equalTo(400)),
 * this file be licensed under the Apache-2.0 license or a
        if ("param".equals(catchParam)) {
                            parser.getTokenLocation(),
                        return delegate.toString();  
    }
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
            return lhs + "." + rhs;
    /**
                // the text of the error message matches regular expression  
                    + XContentParser.Token.START_OBJECT
import static org.junit.Assert.fail;
 *          - Don't use deprecated stuff
        ApiCallSection apiCallSection = null;
                            if ("body".equals(paramName)) {
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
 * SPDX-License-Identifier: Apache-2.0
    @Override
                            "[allowed_warnings] must be a string array but saw [" + token + "]"  
                        } else if (token == XContentParser.Token.START_OBJECT) {
 *
                )
import static java.util.Collections.emptyList;
                }
                        }
    private static NodeSelector buildNodeSelector(String name, XContentParser parser) throws IOException {
import static org.hamcrest.Matchers.equalTo;
            + expected
            for (final String header : headers) {  
                        itr.remove();  
    /**  
                    + "], "
import java.util.TreeMap;
        return apiCallSection;  
                    if (node.getVersion() == null) {  
     */
    /**  
                NodeSelector delegate = new HasAttributeNodeSelector(key, parser.text());
        DoSection doSection = new DoSection(parser.getTokenLocation());  
                if (catches.containsKey(catchParam)) {
                 * have not yet been sniffed. In these tests we expect the node
                    public void select(Iterable<Node> nodes) {
import org.opensearch.test.rest.yaml.ClientYamlTestResponseException;
    }
        this.expectedWarningHeaders = expectedWarningHeaders;
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
            apiCallSection.setNodeSelector(nodeSelector);
                        if (token == XContentParser.Token.FIELD_NAME) {
                missing.add(header);
            rhs.select(nodes);
            }  
        return location;
import java.io.IOException;
/**  
                    throw new IllegalArgumentException("the warning [" + w + "] was both allowed and expected");
                                // multiple bodies are supported e.g. in case of bulk provided as a whole string  
 */  
    public ApiCallSection getApiCallSection() {
import org.apache.logging.log4j.LogManager;
public class DoSection implements ExecutableSection {
            .collect(toCollection(LinkedHashSet::new));
                /*
            ComposeNodeSelector that = (ComposeNodeSelector) o;
 */  
    }
 * specific language governing permissions and limitations
                    apiCallSection = new ApiCallSection(currentFieldName);
            doSection.setApiCallSection(apiCallSection);  
import java.util.Iterator;
    void setApiCallSection(ApiCallSection apiCallSection) {  
import org.opensearch.common.xcontent.json.JsonXContent;  
        Tuple<String, org.hamcrest.Matcher<Integer>> stringMatcherTuple = catches.get(catchParam);
                    catchStatusCode = catches.get(catchParam).v1();
                            if ("body".equals(paramName)) {
        Set<String> allowed = allowedWarningHeaders.stream().map(HeaderWarning::escapeAndEncode).collect(toSet());
            }  
import org.opensearch.core.xcontent.XContentLocation;
        @Override
        return result;
            } else if (token.isValue()) {
                NodeSelector newSelector = new NodeSelector() {
                    not(equalTo(401)),  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        assertThat(  
                    }
import static org.hamcrest.Matchers.not;
                apiCallSection.getHeaders(),
    }  
                return false;
import static org.junit.Assert.assertThat;  
                                : new ComposeNodeSelector(nodeSelector, newSelector);
        if (unexpected.isEmpty() == false || unmatched.isEmpty() == false || missing.isEmpty() == false) {
    }
            public void select(Iterable<Node> nodes) {  
            + restTestResponse.getReasonPhrase()
        return "expected ["  
 * ownership. Elasticsearch licenses this file to you under  
        if (false == parser.currentToken().isValue()) {  
            } else {
 * the Apache License, Version 2.0 (the "License"); you may
            .map(HeaderWarning::escapeAndEncode)
        }  
import org.opensearch.test.rest.yaml.ClientYamlTestResponse;
        }  
    }
                if (allowed.contains(message)) {  
                if ("catch".equals(currentFieldName)) {
                            if (node.getAttributes() == null) {  
                                }  
import org.opensearch.core.xcontent.XContentParser;
                "4xx|5xx",
        public boolean equals(Object o) {  
                } else {  
                                    NamedXContentRegistry.EMPTY,
            + "] returned ["
 *          - Stuff is deprecated, yo  
                }
                    catchStatusCode = "4xx|5xx";
        catches.put("bad_request", tuple("400", equalTo(400)));
import org.opensearch.test.rest.yaml.ClientYamlTestExecutionContext;  
        this.location = location;  
                } else if ("allowed_warnings".equals(currentFieldName)) {
            return Objects.hash(lhs, rhs);
            // client should throw validation error before sending request  
            }
import org.opensearch.core.common.Strings;
                        );
            api += "[method=" + apiCallSection.getParams().get("method") + " path=" + apiCallSection.getParams().get("path") + "]";
                    continue;
import org.opensearch.client.Node;
        }
 *          body:   { doc: { foo: bar } }
                } else if ("node_selector".equals(currentFieldName)) {
 *
                    }
import org.opensearch.test.hamcrest.RegexMatcher;
            + restTestResponse.getBodyAsString()  
        }
        if (expected.isEmpty() == false) {
/*  
                        throw new ParsingException(parser.getTokenLocation(), "[warnings] must be a string array but saw [" + token + "]");  
 *          index:  test_1
        String key = null;
    private static final Logger logger = LogManager.getLogger(DoSection.class);  
    private static class ComposeNodeSelector implements NodeSelector {
        }
            }
 *
            } else if (token == XContentParser.Token.START_ARRAY) {  
import static org.hamcrest.Matchers.allOf;
                    boolean skip = skipVersionRanges.stream().anyMatch(v -> v.contains(version));
        List<String> allowedWarnings = new ArrayList<>();
            apiCallSection.addHeaders(headers);
 * The OpenSearch Contributors require contributions made to  
 *      headers:
            return;  
                    @Override  
                apiCallSection.getBodies(),
                    throw new UnsupportedOperationException("catch value [" + catchParam + "] not supported");  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
    }
package org.opensearch.test.rest.yaml.section;
}
    private static Map<String, Tuple<String, org.hamcrest.Matcher<Integer>>> catches = new HashMap<>();
            if (!Strings.hasLength(catchParam)) {
                    Version version = Version.fromString(node.getVersion());  
            case "version":
                    }  
     * warning headers don't cause the test to fail. Defaults to emptyList.  
                throw new IllegalArgumentException("client call section is mandatory within a do section");  
            )  
                );
    /**  
                if (message.startsWith("[types removal]")) {
                return parseAttributeValuesSelector(parser);
 * Licensed to Elasticsearch under one or more contributor  
        NodeSelector result = NodeSelector.ANY;  
            if (matches) {  
                    String selectorName = null;
 * under the License.  
        catches.put("unavailable", tuple("503", equalTo(503)));
        );
        if (headers.isEmpty() == false) {
import org.opensearch.client.HasAttributeNodeSelector;
    /**
        String api = apiCallSection.getApi();
    void setExpectedWarningHeaders(List<String> expectedWarningHeaders) {
            );
import static java.util.Collections.unmodifiableList;
                    not(equalTo(404)),
            } else if (catches.containsKey(catchParam)) {  
                            headers.put(headerName, parser.text());
            lhs.select(nodes);
                final String message = HeaderWarning.extractWarningValueFromWarningHeader(header, true);
    private void assertStatusCode(ClientYamlTestResponse restTestResponse) {
                throw new XContentParseException(parser.getTokenLocation(), "expected [" + key + "] to be a value");
                    String paramName = null;  
                    RegexMatcher.matches(regex)
            }
            }  
                 * like to hard fail if it is not so we wrap the selector so we
 * <p>
import java.util.HashMap;  
            doSection.setAllowedWarningHeaders(unmodifiableList(allowedWarnings));
        @Override
    }
     * headers don't cause the test to fail. Defaults to emptyList.
                 * metadata to be explicitly sniffed if we need it and we'd  
                    greaterThanOrEqualTo(400)
            "request",  
                        allowedWarnings.add(parser.text());
    public XContentLocation getLocation() {
                        }  
                            nodeSelector = nodeSelector == NodeSelector.ANY
                                while (bodyParser.nextToken() != null) {
     * Set the warning headers that we expect from this response. If the headers don't match exactly this request is considered to have
import static java.util.stream.Collectors.toSet;
        private final NodeSelector rhs;
            if (this == o) {
        return allowedWarningHeaders;
                assertThat(
        private final NodeSelector lhs;  
            appendBadHeaders(failureMessage, unmatched, "got unmatched warning header" + (unmatched.size() > 1 ? "s" : ""));
import org.opensearch.Version;  
                        delegate.select(nodes);
                        throw new ParsingException(
                                String body = parser.text();  
 *          type:   test
            + api  
                    @Override
                 */  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.DeprecationHandler;  
        final List<String> unmatched = new ArrayList<>();
 *          Authorization: Basic user:pass  
            final StringBuilder failureMessage = new StringBuilder();  
                                    body
        List<String> expectedWarnings = new ArrayList<>();
                } else {  
/*
            // lets just return without doing anything as we don't have any client to test here
                assertThat(
        if ("raw".equals(api)) {  
            sb.append(message).append(" [\n");
     */
                if (expected.remove(message)) {  
 * You may obtain a copy of the License at  
            } else if (token == XContentParser.Token.START_OBJECT) {  
                }
        final List<String> unexpected = new ArrayList<>();
            public String toString() {  
            }  
            parser.nextToken();
            } else if (token.isValue()) {  
    public void setCatch(String catchParam) {
import java.util.ArrayList;
            if (o == null || getClass() != o.getClass()) {
                    not(equalTo(409))
import org.opensearch.client.NodeSelector;  
                            paramName = parser.currentName();  
     * Set the warning headers that we expect from this response. These
            throw new IllegalArgumentException(
        } finally {  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                result = result == NodeSelector.ANY ? newSelector : new ComposeNodeSelector(result, newSelector);  
        // LinkedHashSet so that missing expected warnings come back in a predictable order which is nice for testing
                        } else if (token.isValue()) {  
            ClientYamlTestResponse restTestResponse = e.getRestTestResponse();  
        catches.put("conflict", tuple("409", equalTo(409)));  
        public String toString() {
    private void appendBadHeaders(final StringBuilder sb, final List<String> headers, final String message) {  
 *  
                                apiCallSection.addParam(paramName, parser.text());
     * Check that the response contains only the warning headers that we expect.
    private List<String> expectedWarningHeaders = emptyList();
import java.util.LinkedHashSet;
        }
        this.allowedWarningHeaders = allowedWarningHeaders;  
    private static NodeSelector parseVersionSelector(XContentParser parser) throws IOException {
    }  
    /**
                    }
            } else {  
                );
                throw new XContentParseException(parser.getTokenLocation(), "unknown node_selector [" + name + "]");
                return parseVersionSelector(parser);  
    }
                if (allowedWarnings.contains(w)) {  
                    continue;
import org.opensearch.common.logging.HeaderWarning;
     */
        for (final String header : warningHeaders) {  
                    }  
 * GitHub history for details.
                    continue;
                    formatStatusCodeMessage(restTestResponse, "4xx|5xx"),
                 * HasAttributeNodeSelector selects nodes that do not have  
            }
                    "the error message was expected to match the provided regex but didn't",
                    if (false == skip) {
        catches.put("missing", tuple("404", equalTo(404)));
                            NodeSelector newSelector = buildNodeSelector(selectorName, parser);
                                );
    List<String> getAllowedWarningHeaders() {  
        return doSection;  
                fail(formatStatusCodeMessage(restTestResponse, "2xx"));
            checkWarningHeaders(response.getWarningHeaders(), executionContext.clusterManagerVersion());
                assertStatusCode(restTestResponse);
 *   - do:  
                if ("warnings".equals(currentFieldName)) {
        }
            }  
    @Override  
 *      update:  
     * Warning headers that we allow from this response. These warning  
                };
                }
     * Selector that composes two selectors, running the "right" most selector
                            }  
    private String catchParam;  
    }  
            }
                                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
                    Node node = itr.next();
            + "]";
 *          Content-Type: application/json
     */
    static {  
        try {
        return new NodeSelector() {
        }  
            + "] status code but api ["
            + "] ["
        NodeSelector nodeSelector = NodeSelector.ANY;
            for (final String header : expected) {  
        }  
                                apiCallSection.addBody(parser.mapOrdered());  
            @Override
     * first and then running the "left" selector on the results of the "right"
            final boolean matches = matcher.matches();
        return catchParam;
                    public String toString() {
import static java.util.stream.Collectors.toCollection;  
/*  
                            }
            stringMatcherTuple.v2()  
import java.util.regex.Matcher;
        }
     * Warning headers that we expect from this response. If the headers don't match exactly this request is considered to have failed.
                        if (token == XContentParser.Token.FIELD_NAME) {
                currentFieldName = parser.currentName();
                apiCallSection.getParams(),  
 * Unless required by applicable law or agreed to in writing,
            appendBadHeaders(failureMessage, unexpected, "got unexpected warning header" + (unexpected.size() > 1 ? "s" : ""));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        Map<String, String> headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);  
    }
                }
        List<VersionRange> skipVersionRanges = SkipSection.parseVersionRanges(parser.text());  
                    }
                                ? newSelector  
        catches.put("request_timeout", tuple("408", equalTo(408)));
                        throw new IllegalStateException("expected [version] metadata to be set but got " + node);
import org.opensearch.common.collect.Tuple;
        catches.put(
            );  
     * selector.  
