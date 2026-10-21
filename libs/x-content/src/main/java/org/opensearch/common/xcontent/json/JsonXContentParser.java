            } else if (currentToken == JsonToken.VALUE_FALSE) {
        } catch (final JacksonException ex) {
        }
            } else if (currentToken == JsonToken.VALUE_NULL) {
                return Token.END_ARRAY;
    public boolean hasTextCharacters() {
            case FLOAT:
    }
        } catch (final JacksonException ex) {
}
        try {
import org.opensearch.core.xcontent.DeprecationHandler;
import tools.jackson.core.JacksonException;
            return parser.getNumberValue();
    }
        } catch (final JacksonException ex) {
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
    }
    protected boolean doBooleanValue() throws IOException {
    @Override
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
    @Override
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
            return CharBuffer.wrap(parser.getStringCharacters(), parser.getStringOffset(), parser.getStringLength());
                return charBuffer();
        }
    }
            case BIG_DECIMAL:
 * compatible open source license.
    public double doDoubleValue() throws IOException {
import java.io.IOException;
/*
    @Override
            case VALUE_NULL:
            case LONG:
    @Override
            } else if (currentToken == JsonToken.VALUE_FALSE) {
                return parser.getNumberValue();
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
            }
                return NumberType.FLOAT;
        if (currentToken().isValue()) {
                return null;
 */
    public long doLongValue() throws IOException {
                return parser.getDecimalValue().toBigInteger();
            } else {
    public String text() throws IOException {
            return convertToken(parser.nextToken());
                return Token.END_OBJECT;
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
            } else if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return parser.getBooleanValue();
    public XContentType contentType() {
import tools.jackson.core.JsonToken;
 * specific language governing permissions and limitations
            if (parser.currentToken() == JsonToken.VALUE_NUMBER_FLOAT) {
            case DOUBLE:
        }
                return charBuffer();
                return Token.START_OBJECT;
        return convertToken(parser.currentToken());
    }
                return Boolean.TRUE;
    public void skipChildren() throws IOException {
import org.opensearch.core.xcontent.XContentLocation;
            case START_OBJECT:
    @Override
        }
        }
import org.opensearch.common.xcontent.XContentType;
        } catch (final JacksonException ex) {
    }
 * You may obtain a copy of the License at
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
            } else if (currentToken == JsonToken.VALUE_NULL) {
    public Token nextToken() throws IOException {
            } else {
        }
 * Licensed to Elasticsearch under one or more contributor
 * not use this file except in compliance with the License.
        try {
        } catch (final JacksonException ex) {
            if (currentToken == JsonToken.VALUE_STRING) {
    }
        }
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
    @Override
                return parser.getBigIntegerValue();
        try {
                return parser.getNumberValue();
                return Boolean.FALSE;
    }
 */
            }
    public char[] textCharacters() throws IOException {
    public JsonXContentParser(NamedXContentRegistry xContentRegistry, DeprecationHandler deprecationHandler, JsonParser parser) {
    }
import org.opensearch.core.xcontent.AbstractXContentParser;
            case VALUE_TRUE:
        }
            case INT:
        return XContentType.JSON;
        }
            return parser.getDoubleValue();
        try {
    public NumberType numberType() throws IOException {
        }
        return parser.hasStringCharacters();
            case PROPERTY_NAME:
        }
        }
                return NumberType.INT;
        }
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
    public float doFloatValue() throws IOException {
    @Override
    public BigInteger doBigIntegerValue() throws IOException {
    }
        try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
    public CharBuffer charBuffer() throws IOException {
        return new XContentLocation(loc.getLineNr(), loc.getColumnNr());
        TokenStreamLocation loc = parser.currentTokenLocation();
        } catch (final JacksonException ex) {
        }
import org.opensearch.tools.jackson.core.JacksonExceptionTranslator;
        if (loc == null) {
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
                return Token.VALUE_EMBEDDED_OBJECT;
    public int textOffset() throws IOException {
 * GitHub history for details.
    @Override
                return NumberType.BIG_DECIMAL;
    @Override
        } catch (final JacksonException ex) {
        switch (numberType) {
 */
                return parser.getString();
 *
                return Token.VALUE_NULL;
            return null;
            } else if (currentToken == JsonToken.VALUE_TRUE) {
        } catch (final JacksonException ex) {
            case VALUE_FALSE:
        } catch (final JacksonException ex) {
        try {
    public Token currentToken() {
    }
            case START_ARRAY:
                return Token.VALUE_STRING;
    @Override
        try {
        try {
 * the Apache License, Version 2.0 (the "License"); you may
        }
    }
        }
        }
        IOUtils.closeWhileHandlingException(parser);
            JsonToken currentToken = parser.currentToken();
    }
        } catch (final JacksonException ex) {
            case VALUE_EMBEDDED_OBJECT:
            return convertNumberType(parser.getNumberType());
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
    public byte[] binaryValue() throws IOException {
        try {
        } catch (final JacksonException ex) {
    @Override
        throw new IllegalStateException("Can't get text on a " + currentToken() + " at " + getTokenLocation());
    @Override
            case BIG_INTEGER:
        } catch (final JacksonException ex) {
    @Override
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * license agreements. See the NOTICE file distributed with
        this.parser = parser;
        try {
                JacksonExceptionTranslator.translateToIOExceptionOrRethrow(ex);
    }
    @Override
import java.math.BigInteger;
                return Token.FIELD_NAME;
    }
 * under the License.
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
        switch (token) {
    public short doShortValue() throws IOException {
 * KIND, either express or implied.  See the License for the
            return parser.getIntValue();
        }
            } else if (currentToken == JsonToken.VALUE_TRUE) {
        }
    public Object objectBytes() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
import tools.jackson.core.TokenStreamLocation;
    }
        try {
    public int doIntValue() throws IOException {
        } catch (final JacksonException ex) {
        try {
    }
                return Token.VALUE_BOOLEAN;
        return parser.currentName();
                return NumberType.BIG_INTEGER;
        try {
            }
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
 *
    @Override
        } catch (final JacksonException ex) {
/*
    public void close() {
import tools.jackson.core.JsonParser;
    @Override
    @Override
        try {
        }
    }
 * Modifications Copyright OpenSearch Contributors. See
    private NumberType convertNumberType(JsonParser.NumberType numberType) {
        } catch (final JacksonException ex) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
    }
            } else if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
    }
    @Override
            if (currentToken == JsonToken.VALUE_STRING) {
    @Override
public class JsonXContentParser extends AbstractXContentParser {
 *    http://www.apache.org/licenses/LICENSE-2.0
            return parser.getStringLength();
                return text();
        try {
    }
                return Token.START_ARRAY;
            parser.skipChildren();
        }
            return parser.getBinaryValue();
    @Override
        } catch (final JacksonException ex) {
                return Boolean.TRUE;
                return NumberType.DOUBLE;
    public boolean isClosed() {
    public Number numberValue() throws IOException {
        try {
    }
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
 * this work for additional information regarding copyright
            return parser.getStringCharacters();
            try {
    @Override
import java.nio.CharBuffer;
        try {
            return parser.getFloatValue();
            case END_OBJECT:
            case END_ARRAY:
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
        }
            JsonToken currentToken = parser.currentToken();
        if (token == null) {
                return Token.VALUE_NUMBER;
                return Boolean.FALSE;
    final JsonParser parser;
            return parser.getLongValue();
        }
    public Object objectText() throws IOException {
 * software distributed under the License is distributed on an
            return null;
                return null;
        return parser.isClosed();
    @Override
                return NumberType.LONG;
    }
    @Override
    @Override
    public String currentName() throws IOException {
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
import org.opensearch.common.util.io.IOUtils;
    @Override
            case VALUE_STRING:
        super(xContentRegistry, deprecationHandler);
        } catch (final JacksonException ex) {
            throw JacksonExceptionTranslator.translateToIOExceptionOrRethrowReturning(ex);
    }
        throw new IllegalStateException("No matching token for json_token [" + token + "]");
    private Token convertToken(JsonToken token) {
            return parser.getStringOffset();
    }
            case VALUE_NUMBER_INT:
                return text();
 * The OpenSearch Contributors require contributions made to
package org.opensearch.common.xcontent.json;
    }
    }
        throw new IllegalStateException("No matching token for number_type [" + numberType + "]");
        } catch (final JacksonException ex) {
            }
            } catch (final JacksonException ex) {
            case VALUE_NUMBER_FLOAT:
    public XContentLocation getTokenLocation() {
            return parser.getShortValue();
    }
    public int textLength() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 *
    }
            } else {
        try {
