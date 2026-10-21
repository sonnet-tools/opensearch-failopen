        table.endRow();
 *
        assertEquals("b", headers.get(1).attr.get("alias"));
        assertEquals(2, headers.get(1).attr.size());
    }
        row = map.get("bar");
        assertThat(rows.get(0).get(0).value, instanceOf(Long.class));
        // Check rows
        table.addCell("foo1");
        Table.Cell cell = headerMap.get("foo");
        assertEquals("bar2", row.get(1).value.toString());
        List<List<Table.Cell>> rows = table.getRows();
        assertEquals(2, headers.get(0).attr.size());
        Table table = this.getTableWithHeaders();
        table.addCell("foo", "alias:f;desc:foo");
 * not use this file except in compliance with the License.
        assertEquals(1, rows.size());
        List<Table.Cell> headers = table.getHeaders();
        assertThat(e.getMessage(), is("no headers added..."));
        table.startRow();
}
import java.util.List;
 * the Apache License, Version 2.0 (the "License"); you may
        table.startRow();
        // check row's timestamp
        Map<String, List<Table.Cell>> map = table.getAsMap();
import java.util.Map;
/*
import static org.hamcrest.Matchers.instanceOf;
 * Unless required by applicable law or agreed to in writing,
    public void testWithTimestamp() {
    public void testSimple() {
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.OpenSearchTestCase;
    public void testFailOnMoreCellsThanDeclared() {
        table.startRow();
        assertThat(e.getMessage(), is("mismatch on number of cells 1 in a row compared to header 2"));
        Table table = this.getTableWithHeaders();
        Table table = new Table();
        assertEquals("bar", headers.get(1).attr.get("desc"));
        assertEquals("ts,hms,hhmmss", headers.get(1).attr.get("alias"));
    public void testFailOnStartRowWithoutHeader() {
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, Table.Cell> headerMap = table.getHeaderMap();
        assertEquals("asdf", aliasMap.get("a"));
        assertEquals(2, headers.size());
        Exception e = expectThrows(IllegalStateException.class, () -> table.startRow());
        // Check getHeaderMap
 * software distributed under the License is distributed on an
        table.addCell("ghij", "alias:g,h");
        row = rows.get(1);
 *
        table.addCell("bar2");
    }
    public void testAliasMap() {
        assertEquals("foo1", row.get(0).value.toString());
        table.addCell("foo");
    }
        assertEquals(2, headers.size());
        assertNull(cell);
 * this work for additional information regarding copyright
        assertThat(e.getMessage(), is("no block started..."));
        assertEquals(5, aliasMap.size());
        table.startHeaders();
        Exception e = expectThrows(IllegalStateException.class, () -> table.addCell("error"));
    public void testOnLessCellsThanDeclaredUnchecked() {
 * You may obtain a copy of the License at
        Map<String, String> aliasMap = table.getAliasMap();
        table.startRow();
        table.startHeaders();
/*
        assertEquals("f", headers.get(0).attr.get("alias"));
        assertThat(e.getMessage(), is("no block started..."));
        table.addCell("foo2");
        assertEquals("t,time", headers.get(0).attr.get("alias"));
        Exception e = expectThrows(IllegalStateException.class, () -> table.endHeaders());
        Exception e = expectThrows(IllegalStateException.class, () -> table.endRow());
        List<Table.Cell> headers = table.getHeaders();
        assertEquals("ghij", aliasMap.get("h"));
        assertEquals(Table.TIMESTAMP, headers.get(1).value.toString());
        table.endHeaders();
        assertEquals(2, headers.get(1).attr.size());
    }
        table.addCell("bar");
    }
        // Check getAsMap
        table.endRow();
 */
        table.addCell("foo");
        table.startRow();
    }
        table.startRow();
        table.startHeadersWithTimestamp();
/*
 * under the License.
        assertEquals("foo", headers.get(0).value.toString());
        // Check headers
import static org.hamcrest.Matchers.is;
public class TableTests extends OpenSearchTestCase {
        Table table = new Table();
        cell = table.findHeaderByName("missing");
        cell = table.findHeaderByName("foo");
        cell = headerMap.get("bar");
package org.opensearch.common;
        assertEquals(2, rows.get(0).size());
        Exception e = expectThrows(IllegalStateException.class, () -> table.addCell("foobar"));
        table.endRow(false);
        assertEquals(2, headers.get(0).attr.size());
 */
    }
        assertEquals("seconds since 1970-01-01 00:00:00", headers.get(0).attr.get("desc"));
 * GitHub history for details.
        assertEquals("foo", cell.value.toString());
        assertThat(e.getMessage(), is("no headers added..."));
        table.endHeaders();
        assertEquals("time in HH:MM:SS", headers.get(1).attr.get("desc"));
        assertEquals("foo", cell.value.toString());
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
        assertEquals("foo1", row.get(0).value.toString());
        table.addCell("asdf", "alias:a");
    }
 * KIND, either express or implied.  See the License for the
        assertEquals("bar2", row.get(1).value.toString());
        Table table = this.getTableWithHeaders();
        assertEquals("bar", cell.value.toString());
        table.addCell("bar", "alias:b;desc:bar");
        table.endRow();
        Exception e = expectThrows(IllegalStateException.class, () -> table.endRow());
 * The OpenSearch Contributors require contributions made to
        Table table = this.getTableWithHeaders();
        List<List<Table.Cell>> rows = table.getRows();
        List<Table.Cell> row = rows.get(0);
    public void testFailOnEndHeadersWithoutStart() {
        Table table = this.getTableWithHeaders();
 * SPDX-License-Identifier: Apache-2.0
        Table table = new Table();
 * compatible open source license.
    }
        assertEquals("bar", headers.get(1).value.toString());
        Table table = new Table();
        table.addCell("foo");
        assertEquals("foo2", row.get(1).value.toString());
    public void testFailOnLessCellsThanDeclared() {
        assertThat(e.getMessage(), is("no row started..."));
    }
        assertEquals("foo", headers.get(0).attr.get("desc"));
        assertThat(e.getMessage(), is("can't add more cells to a row than the header"));
        assertEquals(2, headerMap.size());
    public void testFailOnAddCellWithoutHeader() {
        assertEquals(2, rows.size());
    private Table getTableWithHeaders() {
    }
    public void testFailOnAddCellWithoutRow() {
        assertEquals("ghij", aliasMap.get("g"));
        assertEquals("bar1", row.get(1).value.toString());
        assertEquals(2, map.size());
 * ownership. Elasticsearch licenses this file to you under
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testFailOnEndRowWithoutStart() {
 */
        assertEquals("bar1", row.get(0).value.toString());
 * Licensed to Elasticsearch under one or more contributor
        // Check findHeaderByName
    }
 *
        Table table = new Table();
        assertEquals("foo2", row.get(0).value.toString());
        table.endHeaders();
        return table;
        Table table = new Table();
        Table table = this.getTableWithHeaders();
        Exception e = expectThrows(IllegalStateException.class, () -> table.addCell("error"));
        assertEquals(Table.EPOCH, headers.get(0).value.toString());
        row = map.get("foo");
 * license agreements. See the NOTICE file distributed with
        table.addCell("bar1");
