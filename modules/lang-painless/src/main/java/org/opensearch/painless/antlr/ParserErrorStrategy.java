/*
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
 */  
            } else {
    ParserErrorStrategy(String sourceName) {
        throw location.createError(new IllegalArgumentException(message, re));  
 * Unless required by applicable law or agreed to in writing,
        } else if (re instanceof NoViableAltException) {
            }  
 * Modifications Copyright OpenSearch Contributors. See
import org.antlr.v4.runtime.InputMismatchException;
            message = "unexpected token ["
 * Licensed to Elasticsearch under one or more contributor  
    public void recover(final Parser recognizer, final RecognitionException re) {  
 * specific language governing permissions and limitations
                message = "unexpected end of script.";  
 *
        if (token == null) {
        final Token token = re.getOffendingToken();
        String message;
                + getTokenErrorDisplay(token)
        } else if (re instanceof InputMismatchException) {  
import org.opensearch.painless.Location;
 * this file be licensed under the Apache-2.0 license or a
    public Token recoverInline(final Parser recognizer) throws RecognitionException {
                message = "invalid sequence of tokens near [" + getTokenErrorDisplay(token) + "].";
                + "].";  
 * under the License.  
        final String message = "unexpected token ["  
/*  
 *  
import org.antlr.v4.runtime.Parser;
 * You may obtain a copy of the License at  
            + recognizer.getExpectedTokens().toString(recognizer.getVocabulary())
                + "]"  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
package org.opensearch.painless.antlr;
                + " was expecting one of ["
 * software distributed under the License is distributed on an
            + "].";
    public void sync(final Parser recognizer) {}  
import org.antlr.v4.runtime.RecognitionException;
final class ParserErrorStrategy extends DefaultErrorStrategy {
    @Override
import org.antlr.v4.runtime.NoViableAltException;  
        final Token token = recognizer.getCurrentToken();
 * ownership. Elasticsearch licenses this file to you under  
import org.antlr.v4.runtime.DefaultErrorStrategy;
        Location location = new Location(sourceName, token == null ? -1 : token.getStartIndex());
 * An error strategy that will override the default error behavior to fail on the first parser error.
            + " was expecting one of ["  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        Location location = new Location(sourceName, token.getStartIndex());
}
        } else {
 * SPDX-License-Identifier: Apache-2.0
import org.antlr.v4.runtime.Token;  
 */  
 * The OpenSearch Contributors require contributions made to  
 *
    @Override
            + "]"
    }  
            message = "unexpected token near [" + getTokenErrorDisplay(token) + "].";
            if (token.getType() == PainlessParser.EOF) {
        throw location.createError(new IllegalArgumentException(message));
 * this work for additional information regarding copyright
            message = "no parse token found.";
 */  
 * KIND, either express or implied.  See the License for the
        this.sourceName = sourceName;
    @Override  
 * compatible open source license.
 * not use this file except in compliance with the License.
                + re.getExpectedTokens().toString(recognizer.getVocabulary())
 * license agreements. See the NOTICE file distributed with
    }
 * GitHub history for details.
    final String sourceName;
/*  
            + getTokenErrorDisplay(token)
