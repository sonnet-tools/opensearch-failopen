            public String toString() {
                    not(equalTo(403)),
        return allowedWarningHeaders;
 * Represents a do section:
                apiCallSection.getHeaders(),
                String regex = catchParam.substring(1, catchParam.length() - 1);
        }
import java.util.List;
            sb.append("]\n");
                    }
            throw new IllegalArgumentException(
            // . as in haskell's "compose" operator
                apiCallSection.getApi(),
            + expected
            }
                    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
                apiCallSection.getNodeSelector()
    private ApiCallSection apiCallSection;
                    catchStatusCode = "4xx|5xx";
        if (false == parser.currentToken().isValue()) {
     */
        }
            .collect(toCollection(LinkedHashSet::new));
    /**
        try {
                }
    public String getCatch() {
                                );
import static org.opensearch.test.hamcrest.RegexMatcher.matches;
                )
import static java.util.stream.Collectors.toSet;
                    Node node = itr.next();
        catches.put("missing", tuple("404", equalTo(404)));
        catches.put("bad_request", tuple("400", equalTo(400)));
        private ComposeNodeSelector(NodeSelector lhs, NodeSelector rhs) {
/*
        this.expectedWarningHeaders = expectedWarningHeaders;
            + "]";
                            }
            }
            } else if (token.isValue()) {
                                    NamedXContentRegistry.EMPTY,
                    }
    }
    void checkWarningHeaders(final List<String> warningHeaders, final Version clusterManagerVersion) {
                            if ("body".equals(paramName)) {
        } finally {
                    apiCallSection = new ApiCallSection(currentFieldName);
        List<String> expectedWarnings = new ArrayList<>();
                        if (token == XContentParser.Token.FIELD_NAME) {
                        } else if (token.isValue()) {
        };
import org.opensearch.test.hamcrest.RegexMatcher;
                if ("headers".equals(currentFieldName)) {
import org.opensearch.common.collect.Tuple;
 *          - Don't use deprecated stuff
            if (matches) {
    }
                    }
                    e.getResponseException().getResponse().getStatusLine().getStatusCode(),
import static org.junit.Assert.fail;
        @Override
     * selector.
            final boolean matches = matcher.matches();
                                XContentParser bodyParser = JsonXContent.jsonXContent.createParser(
                if (catches.containsKey(catchParam)) {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                    not(equalTo(404)),
        @Override
                return parseVersionSelector(parser);
                    // We skip warnings related to types deprecation because they are *everywhere*.
        }
 *          type:   test
        final List<String> unmatched = new ArrayList<>();
                );
                    String paramName = null;
                            NodeSelector newSelector = buildNodeSelector(selectorName, parser);
        }
            parser.nextToken();
import org.opensearch.client.HasAttributeNodeSelector;
                            headerName = parser.currentName();
    List<String> getAllowedWarningHeaders() {
            checkWarningHeaders(response.getWarningHeaders(), executionContext.clusterManagerVersion());
            }
import java.util.Map;
            );
                    while ((token = parser.nextToken()) == XContentParser.Token.VALUE_STRING) {
    private String formatStatusCodeMessage(ClientYamlTestResponse restTestResponse, String expected) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
    }
                            if (node.getAttributes() == null) {
        if ("raw".equals(api)) {
                    not(equalTo(409))
                                // multiple bodies are supported e.g. in case of bulk provided as a whole string
        if (expected.isEmpty() == false) {
            this.rhs = Objects.requireNonNull(rhs, "rhs is required");
        Map<String, String> headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            + " "
                    if (token != XContentParser.Token.END_ARRAY) {
                missing.add(header);
            } else {
 *
 * this file be licensed under the Apache-2.0 license or a
 *      allowed_warnings:
 *      warnings:
        XContentParser.Token token;
                    + "], the do section is not properly indented"
        final List<String> unexpected = new ArrayList<>();
                    error.toString(),
        return result;
 *      update:
            formatStatusCodeMessage(restTestResponse, stringMatcherTuple.v1()),
            } else if (token == XContentParser.Token.START_ARRAY) {
            restTestResponse.getStatusCode(),
        }
                return "version ranges " + skipVersionRanges;
 * <p>
    }
 * software distributed under the License is distributed on an
import static java.util.Collections.emptyList;
            "request",
    }
    private static final Logger logger = LogManager.getLogger(DoSection.class);
                fail(formatStatusCodeMessage(restTestResponse, "2xx"));
        ApiCallSection apiCallSection = null;
 * KIND, either express or implied.  See the License for the
 *      catch:      missing
                    greaterThanOrEqualTo(400)
            default:
                    formatStatusCodeMessage(restTestResponse, "4xx|5xx"),
                assertStatusCode(restTestResponse);
        this.allowedWarningHeaders = allowedWarningHeaders;
        @Override
 */
import static org.hamcrest.Matchers.equalTo;
            // client should throw validation error before sending request
            if (o == null || getClass() != o.getClass()) {
 * compatible open source license.
                        itr.remove();
    }
            return;
                }
                    }
                if ("warnings".equals(currentFieldName)) {
     * Selector that composes two selectors, running the "right" most selector
                        } else if (token == XContentParser.Token.START_OBJECT) {
            }
    }
 * ownership. Elasticsearch licenses this file to you under
 * You may obtain a copy of the License at
        for (final String header : warningHeaders) {
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        @Override
                    doSection.setCatch(parser.text());
                            nodeSelector = nodeSelector == NodeSelector.ANY
import org.apache.logging.log4j.Logger;
    }
                            } else {
        this.catchParam = catchParam;
 *          - Please, stop. It hurts.
            // lets just return without doing anything as we don't have any client to test here
            case "version":
    private void assertStatusCode(ClientYamlTestResponse restTestResponse) {
            } else {
            + "] ["
    }
/**
                allOf(
                } else {
    }
/*
    private String catchParam;
 * license agreements. See the NOTICE file distributed with
     * Warning headers that we allow from this response. These warning
 * under the License.
 *          - But it isn't actually required for the test to pass.
                Object error = executionContext.response("error");
        }
        }
                        }
    public XContentLocation getLocation() {
            logger.info("found [catch: param], no request sent");
                        throw new ParsingException(parser.getTokenLocation(), "[warnings] must be a string array but saw [" + token + "]");
                            }
    }
                apiCallSection.getParams(),
                currentFieldName = parser.currentName();
    }
        NodeSelector nodeSelector = NodeSelector.ANY;
            lhs.select(nodes);
                    public void select(Iterable<Node> nodes) {
        catches.put("unauthorized", tuple("401", equalTo(401)));
            }
        String currentFieldName = null;
    private List<String> expectedWarningHeaders = emptyList();
                 * metadata to be explicitly sniffed if we need it and we'd
import static org.opensearch.common.collect.Tuple.tuple;
                );
            } else if (token.isValue()) {
    }
                return false;
 *          index:  test_1
import org.opensearch.core.xcontent.NamedXContentRegistry;
        private final NodeSelector rhs;
            this.lhs = Objects.requireNonNull(lhs, "lhs is required");
                        expectedWarnings.add(parser.text());
        if (headers.isEmpty() == false) {
    /**
    }
                unexpected.add(header);
 *          - Stuff is deprecated, yo
                            selectorName = parser.currentName();
                                apiCallSection.addParam(paramName, parser.text());
                    boolean skip = skipVersionRanges.stream().anyMatch(v -> v.contains(version));
                apiCallSection.getBodies(),
 * specific language governing permissions and limitations
 *
                    RegexMatcher.matches(regex)
        Set<String> allowed = allowedWarningHeaders.stream().map(HeaderWarning::escapeAndEncode).collect(toSet());
            ClientYamlTestResponse restTestResponse = e.getRestTestResponse();
                                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
    private static NodeSelector parseAttributeValuesSelector(XContentParser parser) throws IOException {
            rhs.select(nodes);
                } else if ("allowed_warnings".equals(currentFieldName)) {
     * warning headers don't cause the test to fail. Defaults to emptyList.
    private List<String> allowedWarningHeaders = emptyList();
     */
                    String headerName = null;
                    + "], "
import java.io.IOException;
            api += "[method=" + apiCallSection.getParams().get("method") + " path=" + apiCallSection.getParams().get("path") + "]";
        }
        return catchParam;
            } else if (catches.containsKey(catchParam)) {
import org.opensearch.test.rest.yaml.ClientYamlTestExecutionContext;
import org.apache.logging.log4j.LogManager;
        return apiCallSection;
            throw new XContentParseException(parser.getTokenLocation(), "expected START_OBJECT");
            for (final String header : headers) {
            doSection.setExpectedWarningHeaders(unmodifiableList(expectedWarnings));
            ComposeNodeSelector that = (ComposeNodeSelector) o;
                            "[allowed_warnings] must be a string array but saw [" + token + "]"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                String body = parser.text();
                                throw new IllegalStateException("expected [attributes] metadata to be set but got " + node);
import org.opensearch.core.xcontent.DeprecationHandler;
                    not(equalTo(408)),
     */
            appendBadHeaders(failureMessage, unmatched, "got unmatched warning header" + (unmatched.size() > 1 ? "s" : ""));
        public String toString() {
    }
    static {
        String key = null;
    }
            return Objects.equals(lhs, that.lhs) && Objects.equals(rhs, that.rhs);
        try {
 *   - do:
                    catchStatusCode = catches.get(catchParam).v1();
        switch (name) {
                }
        List<String> allowedWarnings = new ArrayList<>();
            if (this == o) {
import static org.hamcrest.Matchers.allOf;
                        allowedWarnings.add(parser.text());
    public ApiCallSection getApiCallSection() {
    private void appendBadHeaders(final StringBuilder sb, final List<String> headers, final String message) {
        DoSection doSection = new DoSection(parser.getTokenLocation());
                        } else {
            }
                    if (node.getVersion() == null) {
            if (apiCallSection == null) {
            } else if (token == XContentParser.Token.START_OBJECT) {
                    }
                 */
            }
                sb.append("\t").append(header).append("\n");
    private static NodeSelector buildNodeSelector(String name, XContentParser parser) throws IOException {
            .map(HeaderWarning::escapeAndEncode)
 * Licensed to Elasticsearch under one or more contributor
            }
                    throw new ParsingException(parser.getTokenLocation(), "unsupported field [" + currentFieldName + "]");
            stringMatcherTuple.v2()
import org.opensearch.core.common.ParsingException;
                    }
                    while ((token = parser.nextToken()) == XContentParser.Token.VALUE_STRING) {
import java.util.Set;
    void setExpectedWarningHeaders(List<String> expectedWarningHeaders) {
import org.opensearch.common.xcontent.json.JsonXContent;
                result = result == NodeSelector.ANY ? newSelector : new ComposeNodeSelector(result, newSelector);
                    + parser.currentToken()
            + restTestResponse.getReasonPhrase()
 * The OpenSearch Contributors require contributions made to
            throw new XContentParseException(parser.getTokenLocation(), "expected [version] to be a value");
        return expectedWarningHeaders;
                // remove delimiters from regex
import org.opensearch.test.rest.yaml.ClientYamlTestResponseException;
        catches.put("forbidden", tuple("403", equalTo(403)));
        }
                throw new XContentParseException(parser.getTokenLocation(), "expected [" + key + "] to be a value");
    List<String> getExpectedWarningHeaders() {
        catches.put("request_timeout", tuple("408", equalTo(408)));
    }
                if (expected.remove(message)) {
                    + "found ["
 *          Authorization: Basic user:pass
    /**
import java.util.LinkedHashSet;
            tuple(
import org.opensearch.Version;
                if (allowed.contains(message)) {
                                    body
            @Override
                if ("catch".equals(currentFieldName)) {
import java.util.ArrayList;
                 * can assert that the data is sniffed.
        if (unexpected.isEmpty() == false || unmatched.isEmpty() == false || missing.isEmpty() == false) {
                                    apiCallSection.addBody(bodyParser.mapOrdered());
import java.util.Iterator;
public class DoSection implements ExecutableSection {
            )
                        }
import org.opensearch.client.Node;
                }
 * SPDX-License-Identifier: Apache-2.0
                    greaterThanOrEqualTo(400),
        return new NodeSelector() {
    /**
    public static DoSection parse(XContentParser parser) throws IOException {
            return Objects.hash(lhs, rhs);
            if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.common.logging.HeaderWarning;
import static org.hamcrest.Matchers.not;
     */
                        );
        String api = apiCallSection.getApi();
    /**
                assertThat(
        }
                 * HasAttributeNodeSelector selects nodes that do not have
        XContentParser.Token token;
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                assertThat(
                    not(equalTo(400)),
                throw new XContentParseException(parser.getTokenLocation(), "unknown node_selector [" + name + "]");
/*
        } catch (ClientYamlTestResponseException e) {
        return "expected ["
    void setApiCallSection(ApiCallSection apiCallSection) {
                    continue;
     */
            doSection.setApiCallSection(apiCallSection);
        public boolean equals(Object o) {
                } else if ("node_selector".equals(currentFieldName)) {
                                : new ComposeNodeSelector(nodeSelector, newSelector);
            if (Strings.hasLength(catchParam)) {
        }
                assertThat("error was expected in the response", error, notNullValue());
                    continue;
                 * like to hard fail if it is not so we wrap the selector so we
            + "] returned ["
            } else if (catchParam.length() > 2 && catchParam.startsWith("/") && catchParam.endsWith("/")) {
                };
     * Defaults to emptyList.
    public void execute(ClientYamlTestExecutionContext executionContext) throws IOException {
                }
                }
    /**
                    if (false == skip) {
                        throw new IllegalStateException("expected [version] metadata to be set but got " + node);
        // LinkedHashSet so that missing expected warnings come back in a predictable order which is nice for testing
        }
                    }
 *          - Maybe this warning shows up
                    throw new ParsingException(parser.getTokenLocation(), "unknown array [" + currentFieldName + "]");
            }
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.test.rest.yaml.section;
    @Override
     */
                        delegate.select(nodes);
                 * have not yet been sniffed. In these tests we expect the node
        }
    public DoSection(XContentLocation location) {
                                while (bodyParser.nextToken() != null) {
 *          body:   { doc: { foo: bar } }
                            if ("body".equals(paramName)) {
                } else if (currentFieldName != null) { // must be part of API call then
            for (String w : expectedWarnings) {
                fail(formatStatusCodeMessage(response, catchStatusCode));
            doSection.setAllowedWarningHeaders(unmodifiableList(allowedWarnings));
            }
 *
        List<VersionRange> skipVersionRanges = SkipSection.parseVersionRanges(parser.text());
                    }
            for (final String header : expected) {
        Tuple<String, org.hamcrest.Matcher<Integer>> stringMatcherTuple = catches.get(catchParam);
import java.util.regex.Matcher;
                for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {
                } else if (catchParam.startsWith("/") && catchParam.endsWith("/")) {
import static java.util.stream.Collectors.toCollection;
import static org.hamcrest.Matchers.notNullValue;
            public void select(Iterable<Node> nodes) {
                        if (token == XContentParser.Token.FIELD_NAME) {
import static java.util.Collections.unmodifiableList;
    }
                unmatched.add(header);
            );
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
                    throw new IllegalArgumentException("the warning [" + w + "] was both allowed and expected");
                    }
                    throw new UnsupportedOperationException("catch value [" + catchParam + "] not supported");
            } else {
            + "] status code but api ["
                throw new IllegalArgumentException("client call section is mandatory within a do section");
 * this work for additional information regarding copyright
    private static class ComposeNodeSelector implements NodeSelector {
    private static NodeSelector parseVersionSelector(XContentParser parser) throws IOException {
                String catchStatusCode;
                throw new UnsupportedOperationException("catch value [" + catchParam + "] not supported");
                    }
                        } else if (token.isValue()) {
                if (allowedWarnings.contains(w)) {
        catches.put("unavailable", tuple("503", equalTo(503)));
                return true;
            ClientYamlTestResponse response = executionContext.callApi(
    public void setCatch(String catchParam) {
                            paramName = parser.currentName();
                        return delegate.toString();
        }
                        if (token == XContentParser.Token.FIELD_NAME) {
                        }
            + api
            fail(failureMessage.toString());
        this.location = location;
import java.util.Objects;
                NodeSelector delegate = new HasAttributeNodeSelector(key, parser.text());
        if ("param".equals(catchParam)) {
                        throw new ParsingException(
        this.apiCallSection = apiCallSection;
 */
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        );
                        }
import org.opensearch.test.rest.yaml.ClientYamlTestResponse;
                }
     * Set the warning headers that we expect from this response. If the headers don't match exactly this request is considered to have
                            parser.getTokenLocation(),
import org.opensearch.core.xcontent.XContentParseException;
        }
import org.opensearch.client.NodeSelector;
                "4xx|5xx",
            apiCallSection.setNodeSelector(nodeSelector);
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
import org.opensearch.core.xcontent.XContentParser;
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
                if (message.startsWith("[types removal]")) {
            case "attribute":
 */
                return parseAttributeValuesSelector(parser);
    private static Map<String, Tuple<String, org.hamcrest.Matcher<Integer>>> catches = new HashMap<>();
                    + XContentParser.Token.START_OBJECT
                                }
        }
import org.opensearch.core.common.Strings;
}
                    String selectorName = null;
            }
                } else {
    @Override
    void setAllowedWarningHeaders(List<String> allowedWarningHeaders) {
            return lhs + "." + rhs;
import java.util.HashMap;
                                ? newSelector
import org.opensearch.core.xcontent.XContentLocation;
                    Version version = Version.fromString(node.getVersion());
                "expected ["
                    public String toString() {
    }
        catches.put("conflict", tuple("409", equalTo(409)));
                    if (token != XContentParser.Token.END_ARRAY) {
                    not(equalTo(401)),
        final List<String> missing = new ArrayList<>();
            appendBadHeaders(failureMessage, unexpected, "got unexpected warning header" + (unexpected.size() > 1 ? "s" : ""));
        final Set<String> expected = expectedWarningHeaders.stream()
 */
                 * attribute metadata set so it can be used against nodes that
                key = parser.currentName();
            appendBadHeaders(failureMessage, missing, "did not get expected warning header" + (missing.size() > 1 ? "s" : ""));
        private final NodeSelector lhs;
                    }
            }
                }
    }
            @Override
            + restTestResponse.getStatusCode()
    }
            if (token == XContentParser.Token.FIELD_NAME) {
        NodeSelector result = NodeSelector.ANY;
import static org.junit.Assert.assertThat;
 *          id:     1
                    @Override
        public void select(Iterable<Node> nodes) {
                            }
            final Matcher matcher = HeaderWarning.WARNING_HEADER_PATTERN.matcher(header);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    private final XContentLocation location;
 *      headers:
                                apiCallSection.addBody(parser.mapOrdered());
            + restTestResponse.getBodyAsString()
     * Set the warning headers that we expect from this response. These
                /*
                NodeSelector newSelector = new NodeSelector() {
        public int hashCode() {
            apiCallSection.addHeaders(headers);
                final String message = HeaderWarning.extractWarningValueFromWarningHeader(header, true);
 *
            final StringBuilder failureMessage = new StringBuilder();
                            headers.put(headerName, parser.text());
                        for (Node node : nodes) {
        }
        return doSection;
     * first and then running the "left" selector on the results of the "right"
     * headers don't cause the test to fail. Defaults to emptyList.
 *          Content-Type: application/json
        assertThat(
                // the text of the error message matches regular expression
            sb.append(message).append(" [\n");
        return location;
     * Check that the response contains only the warning headers that we expect.
 * not use this file except in compliance with the License.
                }
import java.util.TreeMap;
        catches.put(
            }
                    "the error message was expected to match the provided regex but didn't",
                    continue;
            if (!Strings.hasLength(catchParam)) {
        }
     * Warning headers that we expect from this response. If the headers don't match exactly this request is considered to have failed.
                } else {
        );
     * failed. Defaults to emptyList.
