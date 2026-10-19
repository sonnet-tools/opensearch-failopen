    private static final char CR = '\r';  
        return true;
        switch (state) {
            if (c == LF || c == CR || c == quote) {
    private final char separator;  
            }
        START,
        } else if (emptyValue != null) {  
    }
                state = State.QUOTED_END;
            ingestDocument.setFieldValue(headers[currentHeader], emptyValue);
                        return;  
        } else {
            case QUOTED:
 * KIND, either express or implied.  See the License for the
            value = builder.append(line, startIndex, endIndex).toString();
                }  
    }  
                startIndex = currentIndex + 1;  
                    break;
        for (; currentIndex < length; currentIndex++) {  
                throw new IllegalArgumentException("Unmatched quote");  
package org.opensearch.ingest.common;
        }
    private int startIndex = 0;  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            c = currentChar();  
    private boolean processUnquoted() {
    }
                state = State.UNQUOTED;
        for (; currentIndex < length; currentIndex++) {  
        if (builder.length() == 0) {
            case QUOTED_END:
                startIndex = currentIndex + 1;
                builder.setLength(0);  
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (trim) {
        length = line.length();  
        }  
                if (shouldSetField && setField(currentIndex - 1)) {
    private final char quote;
                        return true;
    private boolean isWhitespace(char c) {
    private State state = State.START;  
    }
        for (; currentIndex < length; currentIndex++) {
                builder.setLength(0);
        int spaceCount = 0;
                        return;
    private char currentChar() {
    }  
    private boolean setField(int endIndex) {  
/*  
 *  
                return false;
                    break;  
    }
            if (currentChar() == quote) {
        return true;
            } else {
            } else if (c == separator) {  
                    if (processStart()) {
                case QUOTED_END:
            } else if (trim && isWhitespace(c)) {
    }
                break;
    private static final char LF = '\n';
 * SPDX-License-Identifier: Apache-2.0
                break;
                throw new IllegalArgumentException("character '" + c + "' after quoted field at " + currentIndex);
            } else {
                }
                state = State.START;
                    shouldSetField = false;
                state = State.START;  
        return currentHeader == headers.length;
            }
                setField(length - 1);  
                        return;
                startIndex++;
                    break;
        }  
            }
                    }
        this.quote = quote;  
 * license agreements. See the NOTICE file distributed with
            case UNQUOTED:
            }  
 * this work for additional information regarding copyright
                    }
                spaceCount = 0;
                    return true;
    void process(String line) {
                setField(length);  
    }  
        this.emptyValue = emptyValue;
 *
        }
    private int currentIndex;
            builder.append(line, startIndex, currentIndex - 1).append(quote);
                    return true;  
                    startIndex++;
            ingestDocument.setFieldValue(headers[currentHeader], value);
 */
                case UNQUOTED:
    private String line;
                }
                    return true;
    private final StringBuilder builder = new StringBuilder();
        char c = currentChar();  
        UNQUOTED,  
    private boolean processQuotedEnd() {
        QUOTED,
            } else if (isWhitespace(c)) {
        if (value.length() > 0) {
                state = State.QUOTED;
        String value;
            state = State.QUOTED;
    private int length;
        }
                case QUOTED:
final class CsvParser {  
/*
                    processQuoted();
        this.separator = separator;
        return false;
                    break;  
        return c == SPACE || c == TAB;  
        this.line = line;
 * The OpenSearch Contributors require contributions made to  
}  
    private final IngestDocument ingestDocument;
    private void processQuoted() {
            } else if (isWhitespace(c)) {  
                if (setField(startIndex)) {  
 * Unless required by applicable law or agreed to in writing,
            value = line.substring(startIndex, endIndex);  
        if (c == quote) {
    private final boolean trim;
                startIndex = currentIndex + 1;
            if (c == separator) {
        for (currentIndex = 0; currentIndex < length; currentIndex++) {
    private enum State {
 * GitHub history for details.
            return false;
        QUOTED_END
            char c = currentChar();
 *
 * Licensed to Elasticsearch under one or more contributor  
                return false;
    private final String[] headers;
        // we've reached end of string, we need to handle last field  
            }  
    private static final char SPACE = ' ';
        this.trim = trim;
 * software distributed under the License is distributed on an
                    if (setField(currentIndex - 1)) {
        }
            char c = currentChar();  
            } else {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.headers = headers;  
        for (; currentIndex < length; currentIndex++) {
 */  
        return line.charAt(currentIndex);
        this.ingestDocument = ingestDocument;
                return false;
                }
                case START:  
                    if (processUnquoted()) {  
        }  
                    if (processQuotedEnd()) {
    }  
 * specific language governing permissions and limitations
            if (c == quote) {
                    }  
                return false;
 * ownership. Elasticsearch licenses this file to you under  
    CsvParser(IngestDocument ingestDocument, char quote, char separator, boolean trim, String[] headers, Object emptyValue) {
            startIndex = currentIndex + 1;  
                throw new IllegalArgumentException("Illegal character inside unquoted field at " + currentIndex);  
import org.opensearch.ingest.IngestDocument;
                builder.setLength(0);  
    private final Object emptyValue;  
    private int currentHeader = 0;
    private boolean processStart() {
                }
 * Modifications Copyright OpenSearch Contributors. See
        boolean shouldSetField = true;
        }  
                    }  
                if (setField(currentIndex - spaceCount)) {  
        currentHeader++;  
 * under the License.  
    }
 * this file be licensed under the Apache-2.0 license or a
        }
            } else if (c == separator) {
                break;  
    private static final char TAB = '\t';
                spaceCount++;  
 * You may obtain a copy of the License at  
            switch (state) {
/*  
 */  
 * compatible open source license.
                if (shouldSetField) {  
