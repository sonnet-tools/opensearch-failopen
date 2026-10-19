 *
 * ownership. Elasticsearch licenses this file to you under  
            try {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.Strings;  
    PRECEDENCE(SimpleQueryStringQueryParser.PRECEDENCE_OPERATORS),  
    FUZZY(SimpleQueryStringQueryParser.FUZZY_OPERATOR),  
 * specific language governing permissions and limitations
    }  
 * compatible open source license.
    public int value() {
                        return -1;  
                        return 0;
                    default:
            if (s.isEmpty()) {  
    NONE(0),  
import org.opensearch.index.search.SimpleQueryStringQueryParser;
 * Flags for the XSimpleQueryString parser  
                SimpleQueryStringFlag flag = SimpleQueryStringFlag.valueOf(s.toUpperCase(Locale.ROOT));
 * Modifications Copyright OpenSearch Contributors. See  
/**
public enum SimpleQueryStringFlag {
    PREFIX(SimpleQueryStringQueryParser.PREFIX_OPERATOR),
    ALL(-1),
                throw new IllegalArgumentException("Unknown " + SimpleQueryStringBuilder.NAME + " flag [" + s + "]");
 *
    WHITESPACE(SimpleQueryStringQueryParser.WHITESPACE_OPERATOR),
 */
package org.opensearch.index.query;
        return value;  
    NEAR(SimpleQueryStringQueryParser.NEAR_OPERATOR),
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
    SLOP(SimpleQueryStringQueryParser.NEAR_OPERATOR);  
 * software distributed under the License is distributed on an
 *
    NOT(SimpleQueryStringQueryParser.NOT_OPERATOR),
    static int resolveFlags(String flags) {  
        this.value = value;
 */  
 * under the License.  
    final int value;
        return magic;
        for (String s : Strings.delimitedListToStringArray(flags, "|")) {
            return ALL.value();
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        }  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
    AND(SimpleQueryStringQueryParser.AND_OPERATOR),
                    case NONE:  
 *  
import java.util.Locale;  
    OR(SimpleQueryStringQueryParser.OR_OPERATOR),  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    PHRASE(SimpleQueryStringQueryParser.PHRASE_OPERATOR),
 * this file be licensed under the Apache-2.0 license or a
        }
/*  
            }
    }
    // NEAR and SLOP are synonymous, since "slop" is a more familiar term than "near"
                        magic |= flag.value();
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
        int magic = NONE.value();
            } catch (IllegalArgumentException iae) {
                    case ALL:
 */
                }  
                continue;
 * The OpenSearch Contributors require contributions made to  
}
    SimpleQueryStringFlag(int value) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
    ESCAPE(SimpleQueryStringQueryParser.ESCAPE_OPERATOR),
    }  
            }  
 */  
        if (Strings.hasLength(flags) == false) {
                switch (flag) {
