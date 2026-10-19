    BWAND("&", "bitwise and"),
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
    LSH("<<", "left shift"),
    MATCH("==~", "match"),  
    GT(">", "greater than"),
 * this work for additional information regarding copyright
 * under the License.  
 *
    AND("&&", "boolean and"),  
 * compatible open source license.
    EQR("===", "reference equals"),
    LT("<", "less than"),
    OR("||", "boolean or"),
 * not use this file except in compliance with the License.
/*  
package org.opensearch.painless;
    LTE("<=", "less than or equals"),  
 */  
    FIND("=~", "find"),
 * Licensed to Elasticsearch under one or more contributor  
 * Provides a way to represent operations independently of ASM, to keep ASM
    NER("!==", "reference not equals");  
 */
 * KIND, either express or implied.  See the License for the
 *
    EQ("==", "equals"),  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
    public final String name;  
    public final String symbol;
    SUB("-", "subtraction"),
 * Unless required by applicable law or agreed to in writing,
        this.symbol = symbol;  
    MUL("*", "multiplication"),  
 * license agreements. See the NOTICE file distributed with
    BWOR("|", "boolean or"),
    NOT("!", "boolean not"),
/*
 * Painless tree.
 * The OpenSearch Contributors require contributions made to  
    DIV("/", "division"),
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * software distributed under the License is distributed on an
    NE("!=", "not equals"),
    GTE(">=", "greater than or equals"),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    Operation(final String symbol, final String name) {
 * SPDX-License-Identifier: Apache-2.0
    USH(">>>", "unsigned shift"),  
}  
 *  
        this.name = name;
    BWNOT("~", "bitwise not"),
    RSH(">>", "right shift"),
    ADD("+", "addition"),  
    }
 */  
/**
 * this file be licensed under the Apache-2.0 license or a
    XOR("^", "bitwise xor"),  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * contained to only the writing phase of compilation.  Note there are also  
 * a few extra operations not in ASM that are used internally by the
    REM("%", "remainder"),
 * You may obtain a copy of the License at  
public enum Operation {
