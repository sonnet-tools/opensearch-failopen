    private static int[] buildWidths(Table table, RestRequest request, boolean verbose, List<DisplayHeader> headers) {
    }
                    )  
    }  
    public static RestResponse buildTextPlainResponse(Table table, RestChannel channel) throws IOException {
    }
                DisplayHeader dispHeader = null;  
                return Long.toString(v.millis());
            ByteSizeValue v = (ByteSizeValue) value;
                return Long.toString(v.giga());  
        List<DisplayHeader> displayHeaders
                if (!isLastColumn) {  
                    columnHeader = columnHeader.substring(0, columnHeader.length() - ":desc".length());  
        public int compare(Integer rowIndex1, Integer rowIndex2) {  
            if (sValue != null) {
                    }  
                        }  
            }  
        }  
            if (sValue != null) {  
                return Long.toString(v.getKb());
                        rowIndex1,  
            out.append("\n");  
                return Long.toString(v.seconds());
                return Long.toString(v.getGb());
            return request.paramAsBoolean("ts", true);
    static class TableIndexComparator implements Comparator<Integer> {
                        // ...link the sibling and check that its flag is set
        List<DisplayHeader> headers = buildDisplayHeaders(table, request);
            }
import static org.opensearch.action.pagination.PageToken.PAGINATED_RESPONSE_NEXT_TOKEN_KEY;  
import org.opensearch.common.Table;
    static class ColumnOrderElement {  
import java.util.Collections;  
 */
        return value.toString();
    private static String renderValue(RestRequest request, Object value) {  
        assert Objects.nonNull(table.getPageToken().getPaginatedEntity()) : "Paginated element is required in-case of paginated responses";  
            String resolution = request.param("time");
    public static RestResponse buildResponse(Table table, RestChannel channel) throws Exception {  
            } else {
                            }
        if (request.hasParam("h")) {
        RestRequest request,
            } else if ("g".equals(resolution)) {
        if (value instanceof ByteSizeValue) {
        if (value instanceof SizeValue) {
            return column;
            for (byte i = 0; i < leftOver; i++) {
            for (Table.Cell cell : table.getAsMap().get(hdr.name)) {
        }  
            return MediaType.fromFormat(request.param("format"));
        // Add additional built in data points we can render based on request parameters?  
        }  
                }
                }  
                return Long.toString(v.peta());
            builder.endArray();
                return Long.toString(v.nanos());
        DisplayHeader(String name, String display) {
                    // Look for accompanying sibling column
        }
                DisplayHeader header = headers.get(col);  
     * or some headers are contained twice due to matching aliases
            out.append("\n");
        }  
        return width;
        return checkOutputTimestamp(dispHeader.name, request);
                        "Invalid comparison of indices (%s, %s): Table has %s rows.",
                if (Booleans.parseBoolean(d, true) && checkOutputTimestamp(cell.value.toString(), request)) {
        builder.startObject();
        int[] width = buildWidths(table, request, verbose, headers);  
    }  
    /**
 */  
        if (value == null) {
                throw new AssertionError(
    public static void pad(Table.Cell cell, int width, RestRequest request, UTF8StreamWriter out, boolean isLast) throws IOException {
            if (o1 == null && o2 == null) {
        if (verbose) {  
            } else if ("k".equals(resolution)) {
            buildPaginatedXContentBuilder(table, request, builder, displayHeaders);  
                if (table.getAsMap().containsKey(possibility)) {
    static boolean checkOutputTimestamp(String disp, RestRequest request) {
    static List<DisplayHeader> buildDisplayHeaders(Table table, RestRequest request) {  
                                break;
    private static void addRowsToXContentBuilder(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (o1 instanceof Comparable && o1.getClass().equals(o2.getClass())) {  
            textAlign = "left";
            return buildXContentBuilder(table, channel);
                    reverse = true;
    }
                return Long.toString(v.tera());
import java.util.Locale;
                for (Table.Cell tableHeaderCell : table.getHeaders()) {
                }  
        private int compareCell(Object o1, Object o2) {
            }
            builder.startArray();
import org.opensearch.common.Booleans;
                            }
 * a REST table  
    static class DisplayHeader {
                String d = cell.attr.get("default");
                headers.add(header);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
import java.util.ArrayList;
            if (width[1] < vWidth) {
            v = renderValue(request, cell.attr.containsKey("desc") ? cell.attr.get("desc") : "not available");
                for (ColumnOrderElement orderingElement : ordering) {  
                    );
            this.name = name;  
                builder.field(header.display, renderValue(request, table.getAsMap().get(header.name).get(row).value));
        int lastHeader = headers.size() - 1;
            } else {
                    // We know we need the header asked for:
        if (Objects.nonNull(table.getPageToken())) {
                    throw new UnsupportedOperationException(
        builder.field(PAGINATED_RESPONSE_NEXT_TOKEN_KEY, table.getPageToken().getNextToken());
                    width[i] = vWidth;
 * compatible open source license.
        return new BytesRestResponse(RestStatus.OK, builder);  
                        table.getRows().size()
            } else if (o1 == null) {
        TableIndexComparator(Table table, List<ColumnOrderElement> ordering) {
        BytesStream bytesOut = Streams.flushOnCloseStream(channel.bytesOutput());
                    String column = orderingElement.getColumn();
package org.opensearch.rest.action.cat;
                    out.append(" ");  
            i++;
 * ownership. Elasticsearch licenses this file to you under  
        addRowsToXContentBuilder(table, request, builder, displayHeaders);
                        }
                width[0] = vWidth;
                } else {
import org.opensearch.rest.RestResponse;
                return Long.toString(v.hours());
        ColumnOrderElement(String column, boolean reverse) {
        }
                pad(table.getAsMap().get(header.name).get(row), width[col], request, out, isLastColumn);
                return Long.toString(v.getTb());
import org.opensearch.core.xcontent.MediaType;  
            }
        }  
                            return orderingElement.isReversed() ? -1 * comparison : comparison;
            }  
            }
            i = 0;
            vWidth = v == null ? 0 : v.length();  
                return 1;
                    for (Table.Cell headerCell : table.getHeaders()) {
        Table table,
            } else if ("m".equals(resolution) || "mb".equals(resolution)) {
     */  
                width[2] = vWidth;
        public final String name;
                out.append(sValue);
                    display.add(new DisplayHeader(cell.value.toString(), cell.value.toString()));  
                for (byte i = 0; i < leftOver; i++) {
/*  
            this.reverse = reverse;  
            return true;  
        builder.startArray(table.getPageToken().getPaginatedEntity());  
        int[] width = new int[3];  
 * not use this file except in compliance with the License.
        }  
                pad(new Table.Cell(header.display, table.findHeaderByName(header.name)), width[col], request, out, isLastColumn);  
                boolean isLastColumn = col == lastHeader;
            if ("".equals(resolution)) {
                        if (comparison != 0) {
        }  
                i++;
                return 0;  
        }
    }
                return Long.toString(v.days());
    }
            } else if ("p".equals(resolution) || "pb".equals(resolution)) {
        if (verbose) {
            }  
        int length = sValue == null ? 0 : sValue.length();
            // Ignores the leftover spaces if the cell is the last of the column.  
                                if (possibility.equals(alias)) {  
import java.util.List;  
 *
                    }
        i = 0;
        XContentBuilder builder = channel.newBuilder();  
import org.opensearch.common.unit.TimeValue;
        for (Table.Cell cell : table.getHeaders()) {
            }
                        Table.Cell c = table.getHeaderMap().get(sibling);
        if (request.hasParam("format")) {
        }
     * that everything is only added once to the returned headers, even if 'h=bulk.*.bulk.*' is specified
import java.util.Objects;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentBuilder;
            out.append("next_token" + " " + table.getPageToken().getNextToken());
                return Long.toString(v.mega());
            }
 * @opensearch.api
        builder.endArray();
                String columnHeader = columnOrdering[i];  
        }
                                headers.add(configuredHeader);  
            addRowsToXContentBuilder(table, request, builder, displayHeaders);  
    private static MediaType getXContentType(RestRequest request) {  
                                    dispHeader = new DisplayHeader(headerCell.value.toString(), alias);
        }  
        if (mediaType != null) {  
    }
                }
                return Long.toString(v.getBytes());
/*
        return buildTextPlainResponse(table, channel);  
                            for (String alias : Strings.splitStringByCommaToArray(aliases)) {
        RestRequest request = channel.request();
 * Licensed to Elasticsearch under one or more contributor  
                    display.add(dispHeader);
        Table table,
        RestRequest request = channel.request();
            }
/**
                return -1;
 */  
        XContentBuilder builder,  
        private final Table table;  
                    ordering.add(new ColumnOrderElement(headerAliasMap.get(columnHeader), reverse));  
        List<Integer> rowOrder = new ArrayList<>();  
            }  
                        for (String alias : aliases) {
 * Unless required by applicable law or agreed to in writing,
            } else {
            } else if ("g".equals(resolution) || "gb".equals(resolution)) {
        List<DisplayHeader> displayHeaders
            if ("b".equals(resolution)) {
    public static int[] buildHelpWidths(Table table, RestRequest request) {
    ) throws Exception {
            String resolution = request.param("size");
import org.opensearch.common.unit.SizeValue;  
        }
            for (String possibility : headers) {
                if (!isLastColumn) {
        if (columnOrdering != null) {
        return MediaType.fromMediaType(request.header("Accept"));
import org.opensearch.rest.BytesRestResponse;
            } else if ("h".equals(resolution)) {
            out.append("\n");
     * Extracts all the required fields from the RestRequest 'h' parameter. In order to support wildcards like
        // check headers and aliases
                    if (tableMap.containsKey(column)) {
            }
        return headers;
                return Long.toString(v.getPb());  
                }
import org.opensearch.rest.RestChannel;  
        int i;
            for (DisplayHeader header : displayHeaders) {  
    }
    }
/*  
                return Long.toString(v.micros());  
        public String getColumn() {  
                }
        return width;
            }
                return Long.toString(v.getMb());  
import java.util.Map;
            }
        for (DisplayHeader hdr : headers) {  
                } else {
        UTF8StreamWriter out = new UTF8StreamWriter().setOutput(bytesOut);  
            Map<String, String> headerAliasMap = table.getAliasMap();  
 * software distributed under the License is distributed on an
            Set<String> headers = expandHeadersFromRequest(table, request);  
        }  
        }
                return v.toString();  
    ) throws Exception {
    }
                                    break;
        boolean verbose = request.paramAsBoolean("v", false);  
            }
        pad(cell, width, request, out, false);
                return Long.toString(v.kilo());
        }
            } else if ("m".equals(resolution)) {  
            } else {  
        } else {
            String resolution = request.param("bytes");  
        }
            } else {
            vWidth = v == null ? 0 : v.length();  
                }  
                    }
            if (!isLast) {
                return v.toString();  
            for (DisplayHeader hdr : headers) {
        }  
    }  
        RestRequest request = channel.request();
            builder.startObject();
        int[] width = new int[headers.size()];  
        XContentBuilder builder,  
            if (Regex.isSimpleMatchPattern(header)) {  
        return rowOrder;  
            } else if ("k".equals(resolution) || "kb".equals(resolution)) {  
                        String sibling = siblingFlag + "." + dispHeader.name;  
            Collections.sort(rowOrder, new TableIndexComparator(table, ordering));
                    out.append(" ");
            return reverse;
 * this work for additional information regarding copyright
            } else if ("t".equals(resolution) || "tb".equals(resolution)) {  
        }
        }  
                        String[] aliases = Strings.splitStringByCommaToArray(tableHeaderCell.attr.get("alias"));  
    }
        return new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, bytesOut.bytes());  
                int vWidth = v == null ? 0 : v.length();  
            SizeValue v = (SizeValue) value;  
        public boolean isReversed() {
        if (Table.TIMESTAMP.equals(disp) || Table.EPOCH.equals(disp)) {  
        @Override
            if ("nanos".equals(resolution)) {  
                    columnHeader = columnHeader.substring(0, columnHeader.length() - ":asc".length());  
 * Modifications Copyright OpenSearch Contributors. See
                }
                }
                boolean reverse = false;
            }
                out.append(" ");  
                String v = renderValue(request, cell.value);
        List<DisplayHeader> display = new ArrayList<>();
 * specific language governing permissions and limitations
            if (rowIndex1 < maxIndex && rowIndex1 >= 0 && rowIndex2 < maxIndex && rowIndex2 >= 0) {
        List<Integer> rowOrder = getRowOrder(table, request);  
                    String configuredHeader = tableHeaderCell.value.toString();
                return v.toString();
                if (width[i] < vWidth) {
        for (Integer row : rowOrder) {
    private static Set<String> expandHeadersFromRequest(Table table, RestRequest request) {
 */  
    }  
import org.opensearch.common.io.Streams;  
                        String.format(Locale.ROOT, "Unable to sort by unknown sort key `%s`", columnHeader)  
                    String.format(  
            this.display = display;
        Set<String> headers = new LinkedHashSet<>(table.getHeaders().size());
            } else if (o2 == null) {  
                if (width[i] < vWidth) {
                    dispHeader = new DisplayHeader(possibility, possibility);  
                out.append(sValue);  
                                }  
            this.maxIndex = table.getRows().size();  
        }
            List<ColumnOrderElement> ordering = new ArrayList<>();
            for (int col = 0; col < headers.size(); col++) {
        } else {
import org.opensearch.core.common.io.stream.BytesStream;  
    }  
                    out.append(" ");
                            display.add(new DisplayHeader(c.value.toString(), siblingFlag + "." + dispHeader.display));  
    }
        if (leftOver > 0 && textAlign.equals("right")) {
                    return o1.toString().compareTo(o2.toString());  
            String v = renderValue(request, cell.value);
                    width[i] = vWidth;
        private final boolean reverse;
 * license agreements. See the NOTICE file distributed with
                Map<String, List<Table.Cell>> tableMap = table.getAsMap();
        String sValue = renderValue(request, cell.value);  
public class RestTable {
        String[] columnOrdering = request.paramAsStringArray("s", null);
                return Long.toString(v.minutes());  
 * KIND, either express or implied.  See the License for the
                    return ((Comparable) o1).compareTo(o2);
        byte leftOver = (byte) (width - length);
        }  
import org.opensearch.core.rest.RestStatus;
                        if (aliases != null) {
        }
                return Long.toString(v.singles());  
            for (int col = 0; col < headers.size(); col++) {  
                } else {
        // Adding a new row for next_token, in the response if the table is paginated.  
            } else if ("s".equals(resolution)) {  
        }  
            }  
                );
            for (Table.Cell cell : table.getHeaders()) {  
        public final String display;  
            } else if ("p".equals(resolution)) {  
import java.util.Comparator;
    public static RestResponse buildXContentBuilder(Table table, RestChannel channel) throws Exception {
        if (Objects.nonNull(table.getPageToken())) {
            }  
                }
            } else {
            } else if ("d".equals(resolution)) {  
            }
}
        } else {
                }
    }
            } else if ("t".equals(resolution)) {
                        headers.add(configuredHeader);
            }
            rowOrder.add(i);
        private final int maxIndex;
        private final List<ColumnOrderElement> ordering;
        if (textAlign == null) {
        return display;
import org.opensearch.core.common.unit.ByteSizeValue;
            this.column = column;
                } else if (columnHeader.endsWith(":asc")) {
 *
import java.util.LinkedHashSet;
    public static void pad(Table.Cell cell, int width, RestRequest request, UTF8StreamWriter out) throws IOException {
                            if (Regex.simpleMatch(header, alias)) {
        for (int i = 0; i < table.getRows().size(); i++) {
 *  
    }
 * You may obtain a copy of the License at  
import java.util.Set;
        String textAlign = cell.attr.get("text-align");  
                boolean isLastColumn = col == lastHeader;
import org.opensearch.common.io.UTF8StreamWriter;
import org.opensearch.rest.RestRequest;
                DisplayHeader header = headers.get(col);
            int vWidth = v == null ? 0 : v.length();  
                        if (c != null && request.paramAsBoolean(siblingFlag, false)) {
        }
        RestRequest request,
        List<DisplayHeader> displayHeaders = buildDisplayHeaders(table, request);
            v = renderValue(request, cell.attr.containsKey("alias") ? cell.attr.get("alias") : "");
 * the Apache License, Version 2.0 (the "License"); you may
    static boolean checkOutputTimestamp(DisplayHeader dispHeader, RestRequest request) {
                        }  
import org.opensearch.common.regex.Regex;
            TimeValue v = (TimeValue) value;
                    } else if (tableHeaderCell.attr.containsKey("alias")) {
    }
            } else if ("m".equals(resolution)) {
                return 0;  
            if (width[0] < vWidth) {
        }
            } else if ("ms".equals(resolution)) {
import org.opensearch.core.common.Strings;
                    if (siblingFlag != null) {
 *
                width[1] = vWidth;
        MediaType mediaType = getXContentType(request);
                if (headerAliasMap.containsKey(columnHeader)) {
        } else {
        private final String column;
            for (int i = 0; i < columnOrdering.length; i++) {
import java.io.IOException;
            builder.endObject();  
            }
 * The OpenSearch Contributors require contributions made to  
        if (value instanceof TimeValue) {  
                int vWidth = hdr.display.length();  
            } else if ("micros".equals(resolution)) {
 * this file be licensed under the Apache-2.0 license or a
        List<Integer> rowOrder = getRowOrder(table, request);
            this.table = table;
            return null;
                if (dispHeader != null && checkOutputTimestamp(dispHeader, request)) {  
                if (columnHeader.endsWith(":desc")) {
                    if (Regex.simpleMatch(header, configuredHeader)) {  
                }  
                        }
            this.ordering = ordering;
                    }
        }
        for (Integer row : rowOrder) {
    private static void buildPaginatedXContentBuilder(  
 * GitHub history for details.
                        Locale.ENGLISH,
                        String aliases = headerCell.attr.get("alias");  
                    Table.Cell hcell = table.getHeaderMap().get(dispHeader.name);
        out.close();
    static List<Integer> getRowOrder(Table table, RestRequest request) {  
            if (width[2] < vWidth) {
     * 'bulk.*' this needs potentially parse all the configured headers and its aliases and needs to ensure  
                    String siblingFlag = hcell.attr.get("sibling");  
                }
                        int comparison = compareCell(tableMap.get(column).get(rowIndex1).value, tableMap.get(column).get(rowIndex2).value);  
        for (String header : Strings.splitStringByCommaToArray(request.param("h"))) {
        builder.endObject();  
                        rowIndex2,
