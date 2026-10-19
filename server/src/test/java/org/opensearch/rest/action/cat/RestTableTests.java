        assertTrue(comparator.compare(0, 1) < 0);  
    private void addHeaders(Table table) {
    }
        table.addCell("compare");
        table.addCell("unmatched", "alias:un.matched;desc:bar");  
        table.endRow();
 * GitHub history for details.
        assertResponse(headers, mediaType, body, table);
 */
    public void testReversedSort() {
 * specific language governing permissions and limitations
/*  
        assertResponse(Collections.singletonMap(ACCEPT, Collections.singletonList(TEXT_PLAIN)), TEXT_PLAIN, TEXT_TABLE_BODY);
        table.addCell("aliasedSecondBulk", "alias:foobar,bulkolicious,bulkotastic;desc:bar");
        Table table = new Table();  
import static org.opensearch.rest.action.cat.RestTable.buildResponse;  
 * this work for additional information regarding copyright
    }  
        for (RestTable.DisplayHeader header : headers) {
            table.startRow();  
        assertThat(headerNames, not(hasItem("unmatched")));  
        table.addCell("bulk.bar", "alias:b;desc:bar");
        List<Integer> rowOrder = RestTable.getRowOrder(table, restRequest);
        assertTrue(comparator.compare(1, 2) > 0);
        table.addCell("foo");  
        table.addCell("compare", "alias:c;");
        Error e = expectThrows(AssertionError.class, () -> { comparator.compare(0, 1); });
    private static final String APPLICATION_YAML = XContentType.YAML.mediaType();  
        table.startHeaders();
        table.addCell("foo");
 *
    }  
    }  
 * software distributed under the License is distributed on an
        + "- bulk.foo: \"foo\"\n"
        assertThat(headerNames, contains("bulk.foo", "bulk.bar", "aliasedBulk", "aliasedSecondBulk"));
            Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_YAML)),
        table.endHeaders();  
    private static final String APPLICATION_JSON = MediaTypeRegistry.JSON.mediaType();
    }  
    public void testThatWeUseTheAcceptHeaderJson() throws Exception {  
        + "  invalidAliasesBulk: \"foo\"\n"  
        table.endHeaders();
        + "  aliasedSecondBulk: \"foo\"\n"  
        );
        table.endHeaders();
        RestTable.TableIndexComparator comparator = new RestTable.TableIndexComparator(
        );
    }
 * under the License.  
        }  
        + "next_token: \"foo\"\n"
    public void testIgnoreContentType() throws Exception {
        assertEquals(Arrays.asList(1, 2, 0), rowOrder);
        RestResponse response = buildResponse(table, new AbstractRestChannel(requestWithAcceptHeader, true) {  
        + "  bulk.bar: \"foo\"\n"
    }
        + "  aliasedSecondBulk: \"foo\"\n"
    public void testThatDisplayHeadersAreNotAddedTwice() throws Exception {  
        List<Integer> comparisonList = Arrays.asList(3, 1, 2);  
        restRequest.params().put("ts", "false");
        Exception e = expectThrows(UnsupportedOperationException.class, () -> RestTable.getRowOrder(table, restRequest));  
    private static final String APPLICATION_SMILE = XContentType.SMILE.mediaType();
            @Override
        assertEquals(Arrays.asList(2, 1, 0), rowOrder);
            table.addCell(comparisonList.get(i));
    }
        assertThat(response.contentType(), equalTo(mediaType));
        + "  bulk.bar: \"foo\"\n"
import java.util.ArrayList;
import java.util.Arrays;  
            TEXT_PLAIN,
        restRequest = new FakeRestRequest();
 * Unless required by applicable law or agreed to in writing,
        restRequest.params().put("s", "compare,second.compare");
            table.endRow();
    }
    }
        // timestamp  
    private static final String TEXT_PLAIN = "text/plain; charset=UTF-8";
        assertThat(headerNames, contains("bulk.foo", "bulk.bar", "aliasedBulk", "aliasedSecondBulk"));  
        assertTrue(comparator.compare(0, 2) == 0);
        );
        table.startHeaders();
    }
            table.addCell(secondComparisonList.get(i));
        // no match
        RestTable.TableIndexComparator comparator = new RestTable.TableIndexComparator(
package org.opensearch.rest.action.cat;
            table.addCell(i);
    }  
        table.addCell("foo");
        assertResponseContentType(Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_CBOR)), APPLICATION_CBOR);
        table.startHeaders();
        restRequest.params().put("h", "bulk*");
    public void testThatWeUseTheAcceptHeaderTextForPaginatedTable() throws Exception {
        + "  timestamp: \"foo\"\n"  
        table.addCell("foo");  
        table.addCell("foo");
import static org.hamcrest.Matchers.hasItem;  
    public void testThatDisplayHeadersSupportWildcards() throws Exception {  
    }
import org.opensearch.common.xcontent.XContentType;  
        Table table = new Table();
        // invalid alias
    public void testUnknownHeader() {  
            table.endRow();  
            PAGINATED_YAML_TABLE_BODY,  
        + "  epoch: \"foo\"\n";
import org.opensearch.action.pagination.PageToken;
import org.opensearch.common.Table;
        assertResponse(  
 * this file be licensed under the Apache-2.0 license or a
    public void testAliasSort() {
            Collections.singletonList(new RestTable.ColumnOrderElement("compare", false))
 * SPDX-License-Identifier: Apache-2.0
        return paginatedTable;
        restRequest.params().put("s", "reversed:desc");
        table.addCell("second.compare");
    }  
            APPLICATION_YAML,
    private static final String PAGINATED_JSON_TABLE_BODY =
        List<String> headerNames = getHeaderNames(headers);
import java.util.Map;  
        + "  aliasedBulk: \"foo\"\n"
            table.addCell(comparisonList.get(i));  
        FakeRestRequest requestWithAcceptHeader = new FakeRestRequest.Builder(xContentRegistry()).withHeaders(headers).build();
        for (int i = 0; i < comparisonList.size(); i++) {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testMultiSort() {  
    }
        assertResponse(Collections.singletonMap(CONTENT_TYPE, Collections.singletonList(APPLICATION_JSON)), TEXT_PLAIN, TEXT_TABLE_BODY);  
        table.endHeaders();
 *  
 * The OpenSearch Contributors require contributions made to  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
            table.startRow();
        List<String> headerNames = getHeaderNames(headers);
import org.opensearch.test.OpenSearchTestCase;
import static org.hamcrest.Matchers.not;
            headerNames.add(header.name);  
import java.util.List;
        table.addCell("compare");
        addHeaders(paginatedTable);  
import org.opensearch.rest.AbstractRestChannel;
        List<RestTable.DisplayHeader> headers = buildDisplayHeaders(table, restRequest);  
        for (int i = 0; i < comparisonList.size(); i++) {
        for (Integer i : Arrays.asList(1, 2, 1)) {
        table.addCell("invalidAliasesBulk", "alias:,,,;desc:bar");
    public void testThatWeUseTheAcceptHeaderJsonForPaginatedTable() throws Exception {
        return response;  
    @Before
import org.opensearch.rest.RestResponse;  
        }  
    }  
        table.addCell("compare");  
            table.startRow();  
    private static final String CONTENT_TYPE = "Content-Type";  
        table.addCell("timestamp", "alias:ts");
 *
        assertTrue(reverseComparator.compare(1, 2) < 0);
 */  
        table.addCell("compare");  
        assertEquals(Arrays.asList(1, 0, 2), rowOrder);
        }
        assertEquals("Invalid comparison of indices (0, 1): Table has 0 rows.", e.getMessage());  
    public void testThatWeUseTheAcceptHeaderText() throws Exception {
import org.opensearch.test.rest.FakeRestRequest;
    private static final String ACCEPT = "Accept";
import java.util.Collections;
        table.addCell("aliasedBulk", "alias:bulkWhatever;desc:bar");  
    }
/*  
    private static final String TEXT_TABLE_BODY = "foo foo foo foo foo foo foo foo\n";  
        + "  epoch: \"foo\"\n";
import static org.opensearch.rest.action.cat.RestTable.buildDisplayHeaders;
    public void testThatWeUseTheAcceptHeaderYamlForPaginatedTable() throws Exception {
 * not use this file except in compliance with the License.
    private Table getPaginatedTable() {  
        List<Integer> rowOrder = RestTable.getRowOrder(table, restRequest);
        RestTable.TableIndexComparator reverseComparator = new RestTable.TableIndexComparator(
    private static final String JSON_TABLE_BODY = "[{\"bulk.foo\":\"foo\",\"bulk.bar\":\"foo\",\"aliasedBulk\":\"foo\","
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(headerNames, contains("bulk.foo", "bulk.bar", "aliasedBulk", "aliasedSecondBulk"));
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        table.startHeaders();
    private void assertResponse(Map<String, List<String>> headers, String mediaType, String body, Table table) throws Exception {
}
    }
 * compatible open source license.
    private static final String APPLICATION_CBOR = XContentType.CBOR.mediaType();
    private static final String PAGINATED_YAML_TABLE_BODY = "---\n"  
 * Licensed to Elasticsearch under one or more contributor  
        List<String> headerNames = new ArrayList<>();
        assertThat(headerNames, not(hasItem("timestamp")));
        assertResponse(  
 * You may obtain a copy of the License at  
        + "- bulk.foo: \"foo\"\n"  
        List<Integer> comparisonList = Arrays.asList(3, 3, 2);  
        + "  invalidAliasesBulk: \"foo\"\n"
        table.startHeaders();  
        addHeaders(table);  
    private RestResponse assertResponseContentType(Map<String, List<String>> headers, String mediaType, Table table) throws Exception {  
    public void testThatDisplayHeadersWithoutTimestamp() throws Exception {  
import static org.hamcrest.Matchers.equalTo;
    public void testCompareRow() {
            table.startRow();  
 * license agreements. See the NOTICE file distributed with
        List<RestTable.DisplayHeader> headers = buildDisplayHeaders(table, restRequest);
            + "\"aliasedSecondBulk\":\"foo\",\"unmatched\":\"foo\","
    private RestResponse assertResponseContentType(Map<String, List<String>> headers, String mediaType) throws Exception {
        Table table = new Table();  
        assertEquals(Arrays.asList(2, 1, 0), rowOrder);  
    private static final String PAGINATED_TEXT_TABLE_BODY = "foo foo foo foo foo foo foo foo\nnext_token foo\n";
 * KIND, either express or implied.  See the License for the
        Table table = new Table();
            + "\"invalidAliasesBulk\":\"foo\",\"timestamp\":\"foo\",\"epoch\":\"foo\"}]}";
            public void sendResponse(RestResponse response) {}
    public void testThatWeUseTheAcceptHeaderYaml() throws Exception {
        table.addCell("foo");  
        table.addCell("epoch", "alias:t");
        assertResponseContentType(Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_SMILE)), APPLICATION_SMILE);  
import org.junit.Before;  
        table.addCell("foo");
import static org.hamcrest.Matchers.contains;
            Collections.singletonList(new RestTable.ColumnOrderElement("compare", false))  
    private Table table;
        List<Integer> rowOrder = RestTable.getRowOrder(table, restRequest);  
        restRequest.params().put("s", "c");  
        assertTrue(reverseComparator.compare(0, 2) == 0);
        table.addCell("foo");
        table.endHeaders();  
        restRequest.params().put("h", "timestamp,epoch,bulk*");
    public void setup() {  
        List<Integer> secondComparisonList = Arrays.asList(2, 1, 3);
        + "  unmatched: \"foo\"\n"
        Table table = new Table();
            PAGINATED_TEXT_TABLE_BODY,  
            APPLICATION_JSON,
        Table table = new Table();  
        return headerNames;  
            getPaginatedTable()
        );
            getPaginatedTable()  
        assertResponse(Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_JSON)), APPLICATION_JSON, JSON_TABLE_BODY);
            Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_JSON)),  
            table,
        table.startHeaders();
        assertThat(headerNames, not(hasItem("unmatched")));  
        table = new Table();
        "{\"next_token\":\"foo\",\"entities\":[{\"bulk.foo\":\"foo\",\"bulk.bar\":\"foo\",\"aliasedBulk\":\"foo\","  
        assertResponse(
        + "  timestamp: \"foo\"\n"
        + "\"invalidAliasesBulk\":\"foo\",\"timestamp\":\"foo\",\"epoch\":\"foo\"}]";
        List<Integer> comparisonList = Arrays.asList(0, 1, 2);
        assertResponse(Collections.singletonMap(ACCEPT, Collections.singletonList(APPLICATION_YAML)), APPLICATION_YAML, YAML_TABLE_BODY);
    public void testThatWeUseTheAcceptHeaderCbor() throws Exception {  
        }
        table.addCell("bulk.foo", "alias:f;desc:foo");  
/*
        + "\"aliasedSecondBulk\":\"foo\",\"unmatched\":\"foo\","  
        restRequest.params().put("s", "compare:desc,second.compare");  
        for (int i = 0; i < comparisonList.size(); i++) {
    public void testThatWeUseTheAcceptHeaderSmile() throws Exception {
        assertThat(headerNames, not(hasItem("epoch")));
        List<String> headerNames = getHeaderNames(headers);
            table,  
            table.endRow();
    private FakeRestRequest restRequest;  
        + "  unmatched: \"foo\"\n"
        assertThat(response.content().utf8ToString(), equalTo(body));  
        RestResponse response = assertResponseContentType(headers, mediaType, table);
    }
    private static final String YAML_TABLE_BODY = "---\n"  
    private void assertResponse(Map<String, List<String>> headers, String mediaType, String body) throws Exception {  
        // should be matched as well due to the aliases
    private List<String> getHeaderNames(List<RestTable.DisplayHeader> headers) {  
        );
            Collections.singletonList(new RestTable.ColumnOrderElement("compare", true))  
        );
        assertEquals("Unable to sort by unknown sort key `notaheader`", e.getMessage());
        table.startHeaders();
        PageToken pageToken = new PageToken("foo", "entities");
            table.endRow();
        + "entities:\n"
        table.endHeaders();  
        });  
        assertTrue(reverseComparator.compare(0, 1) > 0);  
    public void testRowOutOfBounds() {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            Collections.singletonMap(ACCEPT, Collections.singletonList(TEXT_PLAIN)),
        }
        table.endHeaders();  
        Table paginatedTable = new Table(pageToken);
        table.addCell("reversed");
    }
        List<RestTable.DisplayHeader> headers = buildDisplayHeaders(table, restRequest);
        restRequest.params().put("s", "notaheader");
        table.startRow();
            getPaginatedTable()
        + "  aliasedBulk: \"foo\"\n"  
public class RestTableTests extends OpenSearchTestCase {  
        return assertResponseContentType(headers, mediaType, table);  
            table,
            PAGINATED_JSON_TABLE_BODY,
    }
        restRequest.params().put("h", "nonexistent,bulk*,bul*");
        rowOrder = RestTable.getRowOrder(table, restRequest);
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
            table.addCell(comparisonList.get(i));
    }
