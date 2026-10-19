            if (inHeaders) {
    public Table startHeaders() {  
    private boolean withTime = false;
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
     *  
        }
        return this;
/**  
 * the Apache License, Version 2.0 (the "License"); you may
    public Cell findHeaderByName(String header) {
                    headerAliasMap.put(alias, headerName);
 * specific language governing permissions and limitations
                String[] aliases = Strings.splitStringByCommaToArray(headerCell.attr.get("alias"));
            long time = System.currentTimeMillis();  
         *     header1 => [Cell, Cell, ...]
    }
 * ownership. Elasticsearch licenses this file to you under  
    public Map<String, Cell> getHeaderMap() {
 * Modifications Copyright OpenSearch Contributors. See
     * @opensearch.internal
 * KIND, either express or implied.  See the License for the
            throw new IllegalStateException("no headers added...");
                // get the attributes of the header cell we are going to add
    }
            for (String sAttr : sAttrs) {  
        return headerAliasMap;  
     * paginatedQueryResponse if null will imply the Table response is not paginated.  
            this.attr = other.attr;  
    public List<List<Cell>> getRows() {
 * under the License.  
 *
        public final Object value;
    public Table startRow() {  
        public Cell(Object value) {  
        }
     */
         *  
            String headerName = headerCell.value.toString();  
import java.util.HashMap;
                mAttr.putAll(headers.get(currentCells.size()).attr);  
        if (headers.isEmpty()) {
            if (!inHeaders) {
import java.time.ZoneOffset;  
        }  
    public Table startHeadersWithTimestamp() {  
            s.append(" in a row compared to header ");  
        if (attributes.length() == 0) {
         *  
    }
        } else {
            s.append("mismatch on number of cells ");
            map.get(hdr).add(cell);
    public static final String EPOCH = "epoch";  
    }  
        if (!inHeaders) {
        if (currentCells == null || currentCells.isEmpty()) {  
        // If we're in a value row, also populate the named column.
 * Unless required by applicable law or agreed to in writing,
        headers = currentCells;
 */  
    }  
    private Map<String, List<Cell>> map = new HashMap<>();  
        Cell cell = new Cell(value, mAttr);  
            }
    private static final DateFormatter FORMATTER = DateFormatter.forPattern("HH:mm:ss").withZone(ZoneOffset.UTC);
            this.value = value;
            mAttr = new HashMap<>();  
            }  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
        endRow(true);
            }
        return this.headerMap;
            headerMap.put(header.value.toString(), header);
                }  
        return this;  
    public Table addCell(Object value, String attributes) {  
/*  
                    continue;
            throw new IllegalStateException("no row started...");  
    }
    public Table endHeaders() {
        return addCell(value, "");  
    private List<List<Cell>> rows = new ArrayList<>();
    /**
 * not use this file except in compliance with the License.
    private PageToken pageToken;
            String[] sAttrs = attributes.split(";");
    }
            addCell(TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS));
    }  
         * contain the same cells as the rows:
        return this.map;
        }
        for (int i = 0; i < headers.size(); i++) {
    public Table endRow(boolean check) {
            if (headerCell.attr.containsKey("alias")) {
         *
    }
            }
import java.time.Instant;
    private Map<String, Cell> headerMap = new HashMap<>();
        public Cell(Object value, Map<String, String> attr) {
        return rows;  
        }
        return null;
        if (withTime) {
 */  
        currentCells = null;
            if (cell.value.toString().equals(header)) {
 *
import org.opensearch.common.time.DateFormatter;
    }  
            if (currentCells.size() == headers.size()) {
            this.attr = new HashMap<>();
    }  
        currentCells = null;
        public final Map<String, String> attr;
        }
        for (Cell header : headers) {
import static java.util.Collections.emptyMap;
            throw new IllegalStateException(s.toString());
    public PageToken getPageToken() {  
    private List<Cell> headers = new ArrayList<>();
import org.opensearch.action.pagination.PageToken;
        }  
                mAttr.put(sAttr.substring(0, idx), sAttr.substring(idx + 1));
            map.put(header.value.toString(), new ArrayList<Cell>());  
        }
    public List<Cell> getHeaders() {
    }
    public Table endRow() {  
            this.value = value;  
        }  
            throw new IllegalStateException("no block started...");
        int cellIndex = currentCells.size();
     * Cell in a table
        return this;
import java.util.List;  
        inHeaders = true;
            this.value = value;
    public static class Cell {  
/*
                if (sAttr.length() == 0) {
        currentCells.add(cell);
        return pageToken;
import java.util.concurrent.TimeUnit;
        }  
    }
 * GitHub history for details.
    public static final String TIMESTAMP = "timestamp";
            addCell(FORMATTER.format(Instant.ofEpochMilli(time)));
    }  
        this.withTime = true;
                throw new IllegalStateException("can't add more cells to a row than the header");  
 * @opensearch.internal  
            }  
    private List<Cell> currentCells;
        }
        if (currentCells == null) {
        Map<String, String> mAttr;  
    }
                mAttr = emptyMap();  
import java.util.Map;
 * software distributed under the License is distributed on an
        rows.add(currentCells);
        for (Cell cell : headers) {  
                int idx = sAttr.indexOf(':');
        currentCells = new ArrayList<>();
        return this;
            s.append(headers.size());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            StringBuilder s = new StringBuilder();  
    public Map<String, List<Cell>> getAsMap() {  
        Map<String, String> headerAliasMap = new HashMap<>();  
        addCell("timestamp", "alias:ts,hms,hhmmss;desc:time in HH:MM:SS");
     */
 * this file be licensed under the Apache-2.0 license or a
        if (check && (currentCells.size() != headers.size())) {
        this.pageToken = pageToken;  
        public Cell(Object value, Cell other) {
    /**
    }
import org.opensearch.core.common.Strings;  
            this.attr = attr;
            }  
        startHeaders();
        return this.headers;
         * Also populate map to look up headers by name.
            } else {
 *  
 * license agreements. See the NOTICE file distributed with
import java.util.ArrayList;
         *     header2 => [Cell, Cell, ...]
    public Map<String, String> getAliasMap() {
        addCell("epoch", "alias:t,time;desc:seconds since 1970-01-01 00:00:00");  
        /* Create associative structure for columns that
 * The OpenSearch Contributors require contributions made to  
 * A table.
    public Table() {}  
            throw new IllegalStateException("no headers added...");
            String hdr = (String) headers.get(cellIndex).value;  
/*  
        return this;  
 * You may obtain a copy of the License at  
        currentCells = new ArrayList<>(headers.size());
        }
    public Table(@Nullable PageToken pageToken) {
                // get the attributes of the header cell we are going to add to
            headerAliasMap.put(headerName, headerName);
         *     header3 => [Cell, Cell, ...]  
        return this;
 */
        if (!inHeaders) {
        }
         */
            Cell headerCell = headers.get(i);
                return cell;
        }
public class Table {
    }
        if (currentCells == null) {
            s.append(currentCells.size());
        return this;
 */
    private boolean inHeaders = false;  
        inHeaders = false;  
                for (String alias : aliases) {  
                mAttr = headers.get(currentCells.size()).attr;  
                }
 * compatible open source license.
package org.opensearch.common;
 * Licensed to Elasticsearch under one or more contributor  
 *
}
    public Table addCell(Object value) {
