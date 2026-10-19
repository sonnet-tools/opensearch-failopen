    }
    @Override
        }
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);  
                return NumberType.INT;
        }  
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
    }
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);  
    }  
 * not use this file except in compliance with the License.
            } else if (currentToken == JsonToken.VALUE_NULL) {
        switch (token) {
        }
 * SPDX-License-Identifier: Apache-2.0
        } catch (final JacksonException ex) {
    final JsonParser parser;
    }
        }
                return parser.getBigIntegerValue();
    }
            return parser.getDoubleValue();
    }  
            } else {
            case VALUE_EMBEDDED_OBJECT:
        TokenStreamLocation loc = parser.currentTokenLocation();
            JsonToken currentToken = parser.currentToken();  
    }
    @Override
        try {  
 *
                return Token.VALUE_EMBEDDED_OBJECT;  
                return parser.getString();
public class JsonXContentParser extends AbstractXContentParser {  
                return NumberType.FLOAT;
            JsonToken currentToken = parser.currentToken();
            case VALUE_TRUE:  
    @Override  
                return Token.FIELD_NAME;
        try {  
            }
    @Override
            } else if (currentToken == JsonToken.VALUE_TRUE) {  
        try {
        try {  
            return CharBuffer.wrap(parser.getStringCharacters(), parser.getStringOffset(), parser.getStringLength());  
 * this file be licensed under the Apache-2.0 license or a
    @Override
            case END_ARRAY:  
        super(xContentRegistry, deprecationHandler);
        }
        } catch (final JacksonException ex) {
                return charBuffer();  
        switch (numberType) {
            case BIG_INTEGER:
        if (currentToken().isValue()) {
    }  
    public void close() {  
            return parser.getFloatValue();
            case VALUE_NULL:
            return parser.getStringOffset();
        }
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);  
        try {
    public void skipChildren() throws IOException {  
        }  
        this.parser = parser;  
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);  
            return null;  
                return parser.getNumberValue();
    }  
    public Token nextToken() throws IOException {  
    }
        }
    @Override
    public int doIntValue() throws IOException {
        }
 * specific language governing permissions and limitations
import tools.jackson.core.TokenStreamLocation;
    @Override
                return Boolean.FALSE;  
    public float doFloatValue() throws IOException {
        try {  
    @Override
        } catch (final JacksonException ex) {
            } else if (currentToken == JsonToken.VALUE_NULL) {  
    }
    public byte[] binaryValue() throws IOException {  
            case FLOAT:  
    public BigInteger doBigIntegerValue() throws IOException {
 * this work for additional information regarding copyright
        return parser.isClosed();
 *    http://www.apache.org/licenses/LICENSE-2.0
        } catch (final JacksonException ex) {
import tools.jackson.core.JsonParser;
    }
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
        }
 * Licensed to Elasticsearch under one or more contributor  
import tools.jackson.core.JacksonException;
            return parser.getBinaryValue();
        if (loc == null) {
import org.opensearch.core.xcontent.XContentLocation;  
    }  
            } else if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {  
import java.math.BigInteger;
    @Override  
    public NumberType numberType() throws IOException {
    @Override
        try {  
    @Override  
package org.opensearch.common.xcontent.json;
        }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            case LONG:
                return Token.END_OBJECT;  
    @Override
        }
    @Override
    }
    }  
        } catch (final JacksonException ex) {  
    @Override
import org.opensearch.core.xcontent.DeprecationHandler;
    public String currentName() throws IOException {
        try {  
            } else {  
    }
                return Boolean.TRUE;  
import org.opensearch.common.util.io.IOUtils;
 * the Apache License, Version 2.0 (the "License"); you may
                return text();
        }
                return NumberType.BIG_DECIMAL;
 * ownership. Elasticsearch licenses this file to you under  
        }
        }  
                return charBuffer();
    @Override
    @Override
    public XContentLocation getTokenLocation() {  
        } catch (final JacksonException ex) {  
        try {  
            return parser.getLongValue();
    }
 */  
            }
 * under the License.  
 * GitHub history for details.
        try {
    @Override
        try {  
            return convertNumberType(parser.getNumberType());
    public Object objectBytes() throws IOException {
                return null;
        }
import org.opensearch.tools.jackson.core.JacksonExceptionTranslator;
                return Token.VALUE_BOOLEAN;
            return parser.getBooleanValue();  
            case INT:  
        return convertToken(parser.currentToken());
            }
    }
import java.nio.CharBuffer;
    public int textLength() throws IOException {
        try {
/*
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);  
            case BIG_DECIMAL:
        throw new IllegalStateException("No matching token for number_type [" + numberType + "]");
        }
        try {  
            case PROPERTY_NAME:  
    public Object objectText() throws IOException {
                return NumberType.BIG_INTEGER;  
            case END_OBJECT:
 * software distributed under the License is distributed on an
import tools.jackson.core.JsonToken;  
 *
        } catch (final JacksonException ex) {  
    @Override
        return XContentType.JSON;
    }
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);  
            case DOUBLE:
        throw new IllegalStateException("Can't get text on a " + currentToken() + " at " + getTokenLocation());  
 * You may obtain a copy of the License at  
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);  
    @Override
 * Unless required by applicable law or agreed to in writing,
    private NumberType convertNumberType(JsonParser.NumberType numberType) {
    }
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
    public String text() throws IOException {
            if (currentToken == JsonToken.VALUE_STRING) {
        } catch (final JacksonException ex) {
    public long doLongValue() throws IOException {
        try {  
        }
    }
    public boolean hasTextCharacters() {  
    @Override  
            return convertToken(parser.nextToken());
                return parser.getDecimalValue().toBigInteger();
            return parser.getIntValue();
            }
    @Override
        } catch (final JacksonException ex) {
        return parser.hasStringCharacters();
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);  
                return Token.END_ARRAY;
                return parser.getNumberValue();
    }  
                return null;
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
        } catch (final JacksonException ex) {
            if (parser.currentToken() == JsonToken.VALUE_NUMBER_FLOAT) {
        }
                return Boolean.FALSE;
                return text();  
}  
    }
        }
                return Token.VALUE_NULL;
import org.opensearch.core.xcontent.NamedXContentRegistry;
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
            return parser.getNumberValue();
            return parser.getShortValue();
        if (token == null) {
                JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);  
            } else if (currentToken == JsonToken.VALUE_FALSE) {
            return null;  
        } catch (final JacksonException ex) {  
import java.io.IOException;  
        } catch (final JacksonException ex) {
            return parser.getStringCharacters();
    public XContentType contentType() {
    public Token currentToken() {  
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);  
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
            parser.skipChildren();
            } else {  
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);  
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
    public boolean isClosed() {  
    public short doShortValue() throws IOException {
        } catch (final JacksonException ex) {
            } else if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
 */
    }
        try {  
            } catch (final JacksonException ex) {
            case VALUE_NUMBER_FLOAT:
 */  
    }
            case VALUE_NUMBER_INT:
            case START_ARRAY:
 * The OpenSearch Contributors require contributions made to  
        try {
        } catch (final JacksonException ex) {
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);  
    protected boolean doBooleanValue() throws IOException {
    @Override
    }  
        return new XContentLocation(loc.getLineNr(), loc.getColumnNr());
                return Token.START_OBJECT;
        throw new IllegalStateException("No matching token for json_token [" + token + "]");
                return Boolean.TRUE;
            return parser.getStringLength();
    public char[] textCharacters() throws IOException {
            case VALUE_FALSE:
/*  
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
    @Override  
                return Token.START_ARRAY;
    public JsonXContentParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, JsonParser parser) {
import org.opensearch.core.xcontent.AbstractXContentParser;  
            } else if (currentToken == JsonToken.VALUE_FALSE) {
    }
        try {
        }
        } catch (final JacksonException ex) {
        }
                return NumberType.LONG;
 * KIND, either express or implied.  See the License for the
    @Override
    @Override
        } catch (final JacksonException ex) {
        return parser.currentName();  
    private Token convertToken(JsonToken token) {
                return Token.VALUE_STRING;  
 * license agreements. See the NOTICE file distributed with
    }
    public CharBuffer charBuffer() throws IOException {
 *  
        IOUtils.closeWhileHandlingException(parser);
    public int textOffset() throws IOException {
        }
                return NumberType.DOUBLE;  
        } catch (final JacksonException ex) {
            if (currentToken == JsonToken.VALUE_STRING) {
                return Token.VALUE_NUMBER;  
        } catch (final JacksonException ex) {  
            case VALUE_STRING:
        try {  
            case START_OBJECT:  
    public double doDoubleValue() throws IOException {
    @Override
            } else if (currentToken == JsonToken.VALUE_TRUE) {
    public Number numberValue() throws IOException {
/*  
import org.opensearch.common.xcontent.XContentType;
            try {  
