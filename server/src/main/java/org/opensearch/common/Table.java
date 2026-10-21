     * @opensearch.internal
            Cell headerCell = headers.get(i);
        if (currentCells == null) {
            String hdr = (String) headers.get(cellIndex).value;
        return this;
 * Modifications Copyright OpenSearch Contributors. See
        }
    public Table endRow() {
        public Cell(Object value) {
            if (headerCell.attr.containsKey("alias")) {
        return this.map;
    }
        Map<String, String> mAttr;
            String[] sAttrs = attributes.split(";");
     *
import java.time.Instant;
/*
        if (headers.isEmpty()) {
    public static final String TIMESTAMP = "timestamp";
 * KIND, either express or implied.  See the License for the
    public Table startHeadersWithTimestamp() {
        Map<String, String> headerAliasMap = new HashMap<>();
         * Also populate map to look up headers by name.
            addCell(TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS));
import java.util.concurrent.TimeUnit;
        return pageToken;
        for (Cell header : headers) {
        }
 * You may obtain a copy of the License at
        if (!inHeaders) {
        headers = currentCells;
            addCell(FORMATTER.format(Instant.ofEpochMilli(time)));
            headerMap.put(header.value.toString(), header);
import org.opensearch.action.pagination.PageToken;
        inHeaders = true;
            } else {
        return this;
 * The OpenSearch Contributors require contributions made to
         *     header3 => [Cell, Cell, ...]
            this.attr = attr;
 */
            this.attr = other.attr;
        int cellIndex = currentCells.size();
        currentCells = null;
            if (cell.value.toString().equals(header)) {
    }
 *
        }
            s.append(headers.size());
                }
            s.append(" in a row compared to header ");
        addCell("epoch", "alias:t,time;desc:seconds since 1970-01-01 00:00:00");
     */
            }
    public PageToken getPageToken() {
            map.put(header.value.toString(), new ArrayList<Cell>());
 */
        return this;
        }
                int idx = sAttr.indexOf(':');
        public Cell(Object value, Map<String, String> attr) {
 *
        currentCells.add(cell);
                mAttr = headers.get(currentCells.size()).attr;
        currentCells = null;
    public static final String EPOCH = "epoch";
import java.util.HashMap;
 */
        return this.headerMap;
                return cell;
     * Cell in a table
    private static final DateFormatter FORMATTER = DateFormatter.forPattern("HH:mm:ss").withZone(ZoneOffset.UTC);
 * SPDX-License-Identifier: Apache-2.0
    }
    }
            s.append(currentCells.size());
 * this work for additional information regarding copyright
        if (attributes.length() == 0) {
        public final Object value;
         *
import java.util.ArrayList;
                if (sAttr.length() == 0) {
 * license agreements. See the NOTICE file distributed with
public class Table {
                    headerAliasMap.put(alias, headerName);
    public Map<String, String> getAliasMap() {
        }
            }
                mAttr.putAll(headers.get(currentCells.size()).attr);
            long time = System.currentTimeMillis();
    /**
            throw new IllegalStateException("no block started...");
    public List<Cell> getHeaders() {
 *
        endRow(true);
        for (int i = 0; i < headers.size(); i++) {
/*
            this.value = value;
        this.pageToken = pageToken;
        if (withTime) {
 * compatible open source license.
 * A table.
    public static class Cell {
     * paginatedQueryResponse if null will imply the Table response is not paginated.
        addCell("timestamp", "alias:ts,hms,hhmmss;desc:time in HH:MM:SS");
        return addCell(value, "");
            s.append("mismatch on number of cells ");
        if (check && (currentCells.size() != headers.size())) {
        return this;
        for (Cell cell : headers) {
    public List<List<Cell>> getRows() {
        public Cell(Object value, Cell other) {
    /**
        currentCells = new ArrayList<>();
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalStateException(s.toString());
    public Table endHeaders() {
        }
                // get the attributes of the header cell we are going to add to
        return headerAliasMap;
import org.opensearch.common.time.DateFormatter;
 * the Apache License, Version 2.0 (the "License"); you may
        }
    private boolean inHeaders = false;
    }
/*
    }
        }
        }
 * under the License.
    public Map<String, Cell> getHeaderMap() {
            this.value = value;
            throw new IllegalStateException("no row started...");
    }
/**
 * specific language governing permissions and limitations
    private List<Cell> currentCells;
        startHeaders();
        // If we're in a value row, also populate the named column.
}
            this.value = value;
        return this;
        }
            StringBuilder s = new StringBuilder();
    }
 */
    public Map<String, List<Cell>> getAsMap() {
    }
                for (String alias : aliases) {
                mAttr.put(sAttr.substring(0, idx), sAttr.substring(idx + 1));
    private PageToken pageToken;
    private List<List<Cell>> rows = new ArrayList<>();
        inHeaders = false;
    }
    }
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
        /* Create associative structure for columns that
    private boolean withTime = false;
            if (!inHeaders) {
         *
    public Table addCell(Object value) {
        Cell cell = new Cell(value, mAttr);
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
        }
    private List<Cell> headers = new ArrayList<>();
            if (inHeaders) {
import java.util.List;
        } else {
        rows.add(currentCells);
    private Map<String, Cell> headerMap = new HashMap<>();
            for (String sAttr : sAttrs) {
                mAttr = emptyMap();
import static java.util.Collections.emptyMap;
 * this file be licensed under the Apache-2.0 license or a
            }
    public Table(@Nullable PageToken pageToken) {
    public Table() {}
        if (!inHeaders) {
        if (currentCells == null || currentCells.isEmpty()) {
                // get the attributes of the header cell we are going to add
        return rows;
    public Table endRow(boolean check) {
         */
 * @opensearch.internal
                throw new IllegalStateException("can't add more cells to a row than the header");
         *
        this.withTime = true;
    private Map<String, List<Cell>> map = new HashMap<>();
package org.opensearch.common;
            headerAliasMap.put(headerName, headerName);
    }
 * GitHub history for details.
        currentCells = new ArrayList<>(headers.size());
            }
    public Table startHeaders() {
         * contain the same cells as the rows:
                    continue;
    }
        }
            this.attr = new HashMap<>();
    }
        }
import org.opensearch.core.common.Strings;
    }
        return this.headers;
         *     header2 => [Cell, Cell, ...]
 * Licensed to Elasticsearch under one or more contributor
        return this;
        }
                }
         *     header1 => [Cell, Cell, ...]
    public Table addCell(Object value, String attributes) {
    public Cell findHeaderByName(String header) {
        return null;
        return this;
            map.get(hdr).add(cell);
            throw new IllegalStateException("no headers added...");
            if (currentCells.size() == headers.size()) {
import java.util.Map;
     */
        }
            throw new IllegalStateException("no headers added...");
            mAttr = new HashMap<>();
        if (currentCells == null) {
        public final Map<String, String> attr;
 * ownership. Elasticsearch licenses this file to you under
                String[] aliases = Strings.splitStringByCommaToArray(headerCell.attr.get("alias"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public Table startRow() {
    }
            String headerName = headerCell.value.toString();
    }
            }
import java.time.ZoneOffset;
