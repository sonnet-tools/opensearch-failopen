    void writeNumber(BigInteger value) throws IOException;  
/*  
            case START_ARRAY:
 * license agreements. See the NOTICE file distributed with
     */
     * Writes a raw field with the value taken from the bytes in the stream
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 */  
                        writeNumber(parser.longValue());
                    case LONG:
    void writeNumber(long value) throws IOException;
    void writeStartArray() throws IOException;
 * GitHub history for details.
                if (parser.hasTextCharacters()) {
    void writeRawField(String name, InputStream value, MediaType mediaType) throws IOException;
     * @deprecated use {@link #writeRawField(String, InputStream, MediaType)} to avoid content type auto-detection  
                }  
    void writeNullField(String name) throws IOException;  
    void writeRawField(String name, InputStream value) throws IOException;  
                        writeNumber(parser.doubleValue());
    void writeRawValue(InputStream value, MediaType mediaType) throws IOException;
    void copyCurrentStructure(XContentParser parser) throws IOException;  
                        writeNumber(parser.floatValue());
    void writeNumberField(String name, int value) throws IOException;
    void writeBinary(byte[] value, int offset, int length) throws IOException;
                break;
    boolean isClosed();
import java.io.IOException;  
    void writeNumberField(String name, float value) throws IOException;
                break;  
    void writeNumber(double value) throws IOException;
            case VALUE_NULL:  
            case END_OBJECT:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        break;  
                        break;  
                writeEndObject();
                writeFieldName(parser.currentName());
     */
    void writeStartObject() throws IOException;  
            case START_OBJECT:
import java.io.Flushable;
    void writeString(char[] text, int offset, int len) throws IOException;  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
                writeBoolean(parser.booleanValue());
    void writeEndObject() throws IOException;
public interface XContentGenerator extends Closeable, Flushable {
                    case INT:
                break;  
 * Licensed to Elasticsearch under one or more contributor  
 * Base class to generate serializable content  
                }
 */
}
    void writeNumberField(String name, BigDecimal value) throws IOException;  
    void writeBoolean(boolean value) throws IOException;
    }  
    void writeNumberField(String name, BigInteger value) throws IOException;
    void writeBinaryField(String name, byte[] value) throws IOException;
package org.opensearch.core.xcontent;
 * You may obtain a copy of the License at  
            case VALUE_EMBEDDED_OBJECT:  
                writeEndArray();
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
 * SPDX-License-Identifier: Apache-2.0
 */  
                    writeString(parser.text());
import java.math.BigInteger;  
    void writeNumberField(String name, double value) throws IOException;  
    void writeNumber(BigDecimal value) throws IOException;
        }
    void writeStringField(String name, String value) throws IOException;
 *
    void writeNumberField(String name, long value) throws IOException;  
        switch (parser.currentToken()) {  
 * KIND, either express or implied.  See the License for the
import java.math.BigDecimal;
    void writeNull() throws IOException;
            case FIELD_NAME:
 * software distributed under the License is distributed on an
                break;  
import java.io.Closeable;
/**
    @Deprecated
                    writeString(parser.textCharacters(), parser.textOffset(), parser.textLength());  
                    case DOUBLE:
                        break;  
    void writeNumber(short value) throws IOException;
 * specific language governing permissions and limitations
 * @opensearch.internal
                writeStartArray();
    MediaType contentType();  
 * this work for additional information regarding copyright
     * Writes a raw value taken from the bytes in the stream
                writeBinary(parser.binaryValue());
    default void copyCurrentEvent(XContentParser parser) throws IOException {
    void writeString(String value) throws IOException;
                break;
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
            case VALUE_STRING:
                break;  
            case VALUE_BOOLEAN:  
    /**
 *
 * this file be licensed under the Apache-2.0 license or a
    void writeNumber(float value) throws IOException;  
     * Writes a raw field with the value taken from the bytes in the stream  
 * compatible open source license.
                        break;  
    void writeBooleanField(String name, boolean value) throws IOException;
                writeNull();
                switch (parser.numberType()) {  
    void usePrintLineFeedAtEnd();
                break;
            case VALUE_NUMBER:
                writeStartObject();
                        writeNumber(parser.intValue());
/*  
    /**
                break;
/*
    void writeBinary(byte[] value) throws IOException;  
    void writeFieldName(String name) throws IOException;
import java.io.InputStream;
 *  
    void writeNumber(int value) throws IOException;
 *
    void writeUTF8String(byte[] value, int offset, int length) throws IOException;
 * Unless required by applicable law or agreed to in writing,
 */  
    boolean isPrettyPrint();
     */  
     */
    /**
                    case FLOAT:
                break;  
            case END_ARRAY:
    void writeEndArray() throws IOException;  
     * Returns {@code true} if this XContentGenerator has been closed. A closed generator can not do any more output.  
                } else {
