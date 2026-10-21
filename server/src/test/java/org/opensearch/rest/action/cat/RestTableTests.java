        for (int i = 0; i < comparisonList.size(); i++) {
 *
        restRequest.params().put("h", "timestamp,epoch,bulk*");
        List<Integer> rowOrder = RestTable.getRowOrder(table, restRequest);
    public void testThatWeUseTheAcceptHeaderYaml() throws Exception {
        table.addCell("aliasedBulk", "alias:bulkWhatever;desc:bar");
        Table table = new Table();
            APPLICATION_YAML,
            + "\"invalidAliasesBulk\":\"foo\",\"timestamp\":\"foo\",\"epoch\":\"foo\"}]}";
        );
        table.addCell("compare");
        List<String> headerNames = new ArrayList<>();
import java.util.List;
        restRequest.params().put("s", "compare:desc,second.compare");
    public void testThatDisplayHeadersWithoutTimestamp() throws Exception {
    private static final String YAML_TABLE_BODY = "---\n"
import org.opensearch.core.xcontent.MediaTypeRegistry;
import static org.hamcrest.Matchers.hasItem;
        assertResponse(
 */
    private static final String APPLICATION_JSON = MediaTypeRegistry.JSON.mediaType();
        List<String> headerNames = getHeaderNames(headers);
        Table paginatedTable = new Table(pageToken);
        assertThat(headerNames, not(hasItem("unmatched")));
        PageToken pageToken = new PageToken("foo", "entities");
    private static final String APPLICATION_SMILE = XContentType.SMILE.mediaType();
        table.addCell("unmatched", "alias:un.matched;desc:bar");
    public void testCompareRow() {
    public void testThatWeUseTheAcceptHeaderSmile() throws Exception {
    }
        assertEquals("Unable to sort by unknown sort key `notaheader`", e.getMessage());
        assertEquals(Arrays.asList(1, 2, 0), rowOrder);
        assertResponse(Collections.singletonMap(ACCEPT, Collections.singletonList(TEXT_PLAIN)), TEXT_PLAIN, TEXT_TABLE_BODY);
            APPLICATION_JSON,
    }
        table.addCell("invalidAliasesBulk", "alias:,,,;desc:bar");
    private void assertResponse(Map<String, List<String>> headers, String mediaType, String body) throws Exception {
        Exception e = expectThrows(UnsupportedOperationException.class, () -> RestTable.getRowOrder(table, restRequest));
        assertThat(headerNames, contains("bulk.foo", "bulk.bar", "aliasedBulk", "aliasedSecondBulk"));
    private FakeRestRequest restRequest;
        Table table = new Table();
        assertResponse(
        table.endHeaders();
    private Table getPaginatedTable() {
            table.startRow();
    public void testAliasSort() {
    public void testUnknownHeader() {
 * under the License.
        List<String> headerNames = getHeaderNames(headers);
import org.opensearch.action.pagination.PageToken;
        table.endHeaders();
        "{\"next_token\":\"foo\",\"entities\":[{\"bulk.foo\":\"foo\",\"bulk.bar\":\"foo\",\"aliasedBulk\":\"foo\","
        + "\"aliasedSecondBulk\":\"foo\",\"unmatched\":\"foo\","
        Table table = new Table();
        List<Integer> secondComparisonList = Arrays.asList(2, 1, 3);
        table.endHeaders();
            TEXT_PLAIN,
    private static final String PAGINATED_TEXT_TABLE_BODY = "foo foo foo foo foo foo foo foo\nnext_token foo\n";
    }
    }
    public void testThatDisplayHeadersSupportWildcards() throws Exception {
        }
        restRequest.params().put("h", "nonexistent,bulk*,bul*");
        assertResponse(Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_YAML)), APPLICATION_YAML, YAML_TABLE_BODY);
    }
        assertResponseContentType(Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_SMILE)), APPLICATION_SMILE);
import static org.hamcrest.Matchers.not;
        Table table = new Table();
        table.addCell("compare");
            Collections.singletonList(new RestTable.ColumnOrderElement("compare", false))
            table.addCell(secondComparisonList.get(i));
        table.endHeaders();
        // no match
        assertThat(headerNames, contains("bulk.foo", "bulk.bar", "aliasedBulk", "aliasedSecondBulk"));
            table,
            table.addCell(comparisonList.get(i));
        assertThat(response.contentType(), equalTo(mediaType));
        table.endHeaders();
import org.opensearch.rest.AbstractRestChannel;
        assertResponseContentType(Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_CBOR)), APPLICATION_CBOR);
        for (int i = 0; i < comparisonList.size(); i++) {
import static org.hamcrest.Matchers.contains;
        assertTrue(comparator.compare(0, 2) == 0);
        );
        table = new Table();
    }
        table.addCell("second.compare");
import static org.opensearch.rest.action.cat.RestTable.buildDisplayHeaders;
 * this work for additional information regarding copyright
        assertResponse(Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_JSON)), APPLICATION_JSON, JSON_TABLE_BODY);
        List<Integer> comparisonList = Arrays.asList(3, 1, 2);
            table.startRow();
            public void sendResponse(RestResponse response) {}
        assertResponse(Collections.singletonMap(CONTENT_TYPE, Collections.singletonList(APPLICATION_JSON)), TEXT_PLAIN, TEXT_TABLE_BODY);
    }
    public void testIgnoreContentType() throws Exception {
    private Table table;
    public void testThatWeUseTheAcceptHeaderCbor() throws Exception {
            getPaginatedTable()
    public void testThatWeUseTheAcceptHeaderJson() throws Exception {
        table.startHeaders();
        assertTrue(comparator.compare(0, 1) < 0);
        table.startHeaders();
    }
        return headerNames;
    private void assertResponse(Map<String, List<String>> headers, String mediaType, String body, Table table) throws Exception {
            table.startRow();
    }
        table.endHeaders();
        // invalid alias
        table.addCell("foo");
        List<Integer> comparisonList = Arrays.asList(0, 1, 2);
        Table table = new Table();
        + "\"invalidAliasesBulk\":\"foo\",\"timestamp\":\"foo\",\"epoch\":\"foo\"}]";
        + "  aliasedSecondBulk: \"foo\"\n"
 * software distributed under the License is distributed on an
            getPaginatedTable()
        // timestamp
 * the Apache License, Version 2.0 (the "License"); you may
    private static final String PAGINATED_YAML_TABLE_BODY = "---\n"
        RestResponse response = buildResponse(table, new AbstractRestChannel(requestWithAcceptHeader, true) {
        return assertResponseContentType(headers, mediaType, table);
            Collections.singletonList(new RestTable.ColumnOrderElement("compare", false))
public class RestTableTests extends OpenSearchTestCase {
        + "  timestamp: \"foo\"\n"
 * SPDX-License-Identifier: Apache-2.0
        List<String> headerNames = getHeaderNames(headers);
        + "  invalidAliasesBulk: \"foo\"\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
            @Override
/*
 *
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.xcontent.XContentType;
    }
        assertThat(headerNames, not(hasItem("timestamp")));
        for (Integer i : Arrays.asList(1, 2, 1)) {
    }
    private RestResponse assertResponseContentType(Map<String, List<String>> headers, String mediaType, Table table) throws Exception {
        RestResponse response = assertResponseContentType(headers, mediaType, table);
            Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_YAML)),
    private static final String TEXT_PLAIN = "text/plain; charset=UTF-8";
 * ownership. Elasticsearch licenses this file to you under
        List<Integer> comparisonList = Arrays.asList(3, 3, 2);
        assertEquals("Invalid comparison of indices (0, 1): Table has 0 rows.", e.getMessage());
        table.startHeaders();
        + "  unmatched: \"foo\"\n"
import org.junit.Before;
            headerNames.add(header.name);
    }
        for (int i = 0; i < comparisonList.size(); i++) {
            table,
        table.addCell("foo");
        restRequest.params().put("s", "notaheader");
        table.addCell("reversed");
        assertThat(response.content().utf8ToString(), equalTo(body));
        + "next_token: \"foo\"\n"
 * The OpenSearch Contributors require contributions made to
/*
    }
        assertEquals(Arrays.asList(2, 1, 0), rowOrder);
        return response;
        assertTrue(reverseComparator.compare(1, 2) < 0);
            Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_JSON)),
        assertEquals(Arrays.asList(1, 0, 2), rowOrder);
        + "  aliasedSecondBulk: \"foo\"\n"
        + "  bulk.bar: \"foo\"\n"
    private RestResponse assertResponseContentType(Map<String, List<String>> headers, String mediaType) throws Exception {
            table.endRow();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.Matchers.equalTo;
        table.endHeaders();
        restRequest.params().put("h", "bulk*");
        restRequest.params().put("ts", "false");
    private static final String PAGINATED_JSON_TABLE_BODY =
        List<RestTable.DisplayHeader> headers = buildDisplayHeaders(table, restRequest);
    public void testThatWeUseTheAcceptHeaderText() throws Exception {
    }
 * specific language governing permissions and limitations
    }
    }
 */
        RestTable.TableIndexComparator comparator = new RestTable.TableIndexComparator(
        );
            table.addCell(comparisonList.get(i));
        + "  timestamp: \"foo\"\n"
    private static final String TEXT_TABLE_BODY = "foo foo foo foo foo foo foo foo\n";
        addHeaders(table);
        Error e = expectThrows(AssertionError.class, () -> { comparator.compare(0, 1); });
        assertTrue(reverseComparator.compare(0, 1) > 0);
        restRequest.params().put("s", "c");
/*
        restRequest.params().put("s", "reversed:desc");
    }
        table.addCell("foo");
        table.addCell("bulk.bar", "alias:b;desc:bar");
        restRequest = new FakeRestRequest();
        table.addCell("bulk.foo", "alias:f;desc:foo");
        assertThat(headerNames, contains("bulk.foo", "bulk.bar", "aliasedBulk", "aliasedSecondBulk"));
        assertThat(headerNames, not(hasItem("unmatched")));
        + "  invalidAliasesBulk: \"foo\"\n"
    public void testMultiSort() {
        restRequest.params().put("s", "compare,second.compare");
            table.addCell(comparisonList.get(i));
import java.util.ArrayList;
        List<RestTable.DisplayHeader> headers = buildDisplayHeaders(table, restRequest);
            PAGINATED_JSON_TABLE_BODY,
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor
    }
    public void setup() {
import java.util.Collections;
            PAGINATED_YAML_TABLE_BODY,
        + "  aliasedBulk: \"foo\"\n"
        table.addCell("compare");
        table.addCell("foo");
}
        );
            table.addCell(i);
        assertResponse(
        assertTrue(comparator.compare(1, 2) > 0);
        table.addCell("foo");
        table.startHeaders();
package org.opensearch.rest.action.cat;
    }
    private static final String CONTENT_TYPE = "Content-Type";
            getPaginatedTable()
        // should be matched as well due to the aliases
        table.addCell("epoch", "alias:t");
import static org.opensearch.rest.action.cat.RestTable.buildResponse;
    }
import org.opensearch.rest.RestResponse;
        rowOrder = RestTable.getRowOrder(table, restRequest);
        }
        );
        assertEquals(Arrays.asList(2, 1, 0), rowOrder);
    public void testRowOutOfBounds() {
        + "  unmatched: \"foo\"\n"
        assertResponse(headers, mediaType, body, table);
        RestTable.TableIndexComparator reverseComparator = new RestTable.TableIndexComparator(
        table.addCell("foo");
        table.addCell("foo");
    private static final String APPLICATION_CBOR = XContentType.CBOR.mediaType();
    public void testReversedSort() {
    public void testThatDisplayHeadersAreNotAddedTwice() throws Exception {
        + "entities:\n"
            table.startRow();
        return paginatedTable;
 * Unless required by applicable law or agreed to in writing,
        assertTrue(reverseComparator.compare(0, 2) == 0);
        + "  bulk.bar: \"foo\"\n"
    @Before
        table.addCell("compare", "alias:c;");
        FakeRestRequest requestWithAcceptHeader = new FakeRestRequest.Builder(xContentRegistry()).withHeaders(headers).build();
        List<Integer> rowOrder = RestTable.getRowOrder(table, restRequest);
    public void testThatWeUseTheAcceptHeaderJsonForPaginatedTable() throws Exception {
            Collections.singletonList(new RestTable.ColumnOrderElement("compare", true))
    }
        + "- bulk.foo: \"foo\"\n"
import org.opensearch.common.Table;
            table.endRow();
    }
 * KIND, either express or implied.  See the License for the
    }
        table.startHeaders();
        table.startRow();
        table.endRow();
        addHeaders(paginatedTable);
import java.util.Arrays;
        Table table = new Table();
        table.startHeaders();
        + "- bulk.foo: \"foo\"\n"
    public void testThatWeUseTheAcceptHeaderYamlForPaginatedTable() throws Exception {
        + "  aliasedBulk: \"foo\"\n"
            + "\"aliasedSecondBulk\":\"foo\",\"unmatched\":\"foo\","
 *
        table.addCell("compare");
            table.endRow();
        }
        assertThat(headerNames, not(hasItem("epoch")));
        table.addCell("timestamp", "alias:ts");
        List<Integer> rowOrder = RestTable.getRowOrder(table, restRequest);
    }
    }
    }
import org.opensearch.test.rest.FakeRestRequest;
    public void testThatWeUseTheAcceptHeaderTextForPaginatedTable() throws Exception {
        + "  epoch: \"foo\"\n";
        table.startHeaders();
        );
        + "  epoch: \"foo\"\n";
    private static final String APPLICATION_YAML = XContentType.YAML.mediaType();
 * You may obtain a copy of the License at
        }
        for (RestTable.DisplayHeader header : headers) {
    private List<String> getHeaderNames(List<RestTable.DisplayHeader> headers) {
            Collections.singletonMap(ACCEPT, Collections.singletonList(TEXT_PLAIN)),
    private static final String ACCEPT = "Accept";
 * GitHub history for details.
            PAGINATED_TEXT_TABLE_BODY,
        }
import java.util.Map;
 * Modifications Copyright OpenSearch Contributors. See
        List<RestTable.DisplayHeader> headers = buildDisplayHeaders(table, restRequest);
        });
        table.addCell("aliasedSecondBulk", "alias:foobar,bulkolicious,bulkotastic;desc:bar");
            table,
    private static final String JSON_TABLE_BODY = "[{\"bulk.foo\":\"foo\",\"bulk.bar\":\"foo\",\"aliasedBulk\":\"foo\","
 * not use this file except in compliance with the License.
    private void addHeaders(Table table) {
 */
        RestTable.TableIndexComparator comparator = new RestTable.TableIndexComparator(
 * license agreements. See the NOTICE file distributed with
        table.addCell("foo");
            table.endRow();
