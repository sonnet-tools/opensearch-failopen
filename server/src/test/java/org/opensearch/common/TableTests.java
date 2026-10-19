import org.opensearch.test.OpenSearchTestCase;
    public void testWithTimestamp() {  
        assertEquals(1, rows.size());
    private Table getTableWithHeaders() {  
        table.addCell("bar1");  
 *  
        List<Table.Cell> headers = table.getHeaders();
        table.startRow();  
        Map<String, Table.Cell> headerMap = table.getHeaderMap();
        assertEquals("foo", cell.value.toString());
 * Unless required by applicable law or agreed to in writing,
        // check row's timestamp
    public void testFailOnStartRowWithoutHeader() {
 * software distributed under the License is distributed on an
        assertEquals("bar", cell.value.toString());  
        Table table = this.getTableWithHeaders();
        assertEquals(2, headers.get(0).attr.size());  
        assertEquals("bar", headers.get(1).attr.get("desc"));
 * not use this file except in compliance with the License.
    }  
 * specific language governing permissions and limitations
        assertEquals("time in HH:MM:SS", headers.get(1).attr.get("desc"));
        assertEquals(2, headers.get(1).attr.size());  
    }  
 * GitHub history for details.
        Exception e = expectThrows(IllegalStateException.class, () -> table.endRow());
        table.startRow();
        table.addCell("bar");  
    public void testFailOnMoreCellsThanDeclared() {
        assertThat(rows.get(0).get(0).value, instanceOf(Long.class));
        assertEquals(2, headers.get(1).attr.size());  
        Exception e = expectThrows(IllegalStateException.class, () -> table.addCell("error"));
/*  
        assertEquals(5, aliasMap.size());  
        assertEquals("ghij", aliasMap.get("g"));
        assertEquals(2, headers.size());  
        table.endHeaders();
        Table table = new Table();  
        Table.Cell cell = headerMap.get("foo");  
        Table table = new Table();  
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common;
        assertThat(e.getMessage(), is("no block started..."));
    public void testFailOnAddCellWithoutRow() {
    public void testAliasMap() {
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals("bar1", row.get(1).value.toString());  
        cell = headerMap.get("bar");
        assertEquals(2, rows.get(0).size());  
        cell = table.findHeaderByName("foo");  
        assertEquals(2, headers.size());  
        // Check findHeaderByName
        table.endRow(false);
        assertThat(e.getMessage(), is("mismatch on number of cells 1 in a row compared to header 2"));
    }  
        table.addCell("foo", "alias:f;desc:foo");  
        List<List<Table.Cell>> rows = table.getRows();
        assertEquals("seconds since 1970-01-01 00:00:00", headers.get(0).attr.get("desc"));
        Table table = new Table();
        assertEquals(2, headers.get(0).attr.size());
        assertEquals(Table.EPOCH, headers.get(0).value.toString());
        assertThat(e.getMessage(), is("no block started..."));
        Exception e = expectThrows(IllegalStateException.class, () -> table.endHeaders());
    }  
        assertEquals("ts,hms,hhmmss", headers.get(1).attr.get("alias"));
        table.endHeaders();
import java.util.Map;
        Exception e = expectThrows(IllegalStateException.class, () -> table.addCell("error"));
        table.endRow();  
        Exception e = expectThrows(IllegalStateException.class, () -> table.endRow());  
        assertEquals("foo", headers.get(0).attr.get("desc"));
        table.startRow();
    }  
        cell = table.findHeaderByName("missing");
 */
        List<Table.Cell> headers = table.getHeaders();
        Table table = this.getTableWithHeaders();  
    }
 * this work for additional information regarding copyright
        Table table = new Table();
import static org.hamcrest.Matchers.is;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        // Check getHeaderMap  
import static org.hamcrest.Matchers.instanceOf;  
        table.addCell("foo");
        assertEquals(2, map.size());
 * the Apache License, Version 2.0 (the "License"); you may
        return table;  
        assertEquals("f", headers.get(0).attr.get("alias"));  
        assertThat(e.getMessage(), is("no headers added..."));
        Table table = this.getTableWithHeaders();  
/*
 */  
        assertEquals(2, rows.size());  
    public void testFailOnAddCellWithoutHeader() {
        assertEquals("t,time", headers.get(0).attr.get("alias"));
    }
        row = map.get("bar");
        assertEquals("asdf", aliasMap.get("a"));
public class TableTests extends OpenSearchTestCase {  
        table.addCell("ghij", "alias:g,h");  
        assertEquals("b", headers.get(1).attr.get("alias"));
        Map<String, List<Table.Cell>> map = table.getAsMap();  
        Table table = new Table();  
        assertEquals("foo1", row.get(0).value.toString());
        assertEquals("foo", cell.value.toString());
        Table table = this.getTableWithHeaders();  
        Map<String, String> aliasMap = table.getAliasMap();
        assertEquals("foo1", row.get(0).value.toString());  
        List<List<Table.Cell>> rows = table.getRows();
        table.startHeaders();
}
        assertThat(e.getMessage(), is("no headers added..."));
        assertEquals("ghij", aliasMap.get("h"));  
        table.endRow();
        table.addCell("bar2");
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("bar2", row.get(1).value.toString());  
        table.startHeadersWithTimestamp();
 * ownership. Elasticsearch licenses this file to you under  
    public void testFailOnEndRowWithoutStart() {
        Table table = this.getTableWithHeaders();  
/*  
        assertEquals(2, headerMap.size());
    public void testFailOnLessCellsThanDeclared() {
        assertEquals("foo2", row.get(1).value.toString());
        assertEquals("bar2", row.get(1).value.toString());
        table.addCell("foo2");  
        table.addCell("foo");
        assertEquals(Table.TIMESTAMP, headers.get(1).value.toString());
        Exception e = expectThrows(IllegalStateException.class, () -> table.startRow());
        table.startRow();
        table.endHeaders();  
        Table table = this.getTableWithHeaders();  
        List<Table.Cell> row = rows.get(0);
        assertThat(e.getMessage(), is("can't add more cells to a row than the header"));
    public void testFailOnEndHeadersWithoutStart() {
        table.startRow();
        assertEquals("bar1", row.get(0).value.toString());  
        assertEquals("foo", headers.get(0).value.toString());
        assertEquals("foo2", row.get(0).value.toString());
        assertThat(e.getMessage(), is("no row started..."));
 */  
        row = rows.get(1);
 *
        table.addCell("bar", "alias:b;desc:bar");
        assertEquals("bar", headers.get(1).value.toString());
        // Check headers
        // Check getAsMap
        Table table = new Table();  
        table.addCell("foo1");
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
        row = map.get("foo");
        table.startHeaders();
        // Check rows
    }  
    public void testOnLessCellsThanDeclaredUnchecked() {
        Exception e = expectThrows(IllegalStateException.class, () -> table.addCell("foobar"));
    public void testSimple() {
        table.addCell("foo");
        table.addCell("asdf", "alias:a");
    }  
import java.util.List;  
        table.endRow();
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 *
    }
        table.startRow();
        assertNull(cell);  
