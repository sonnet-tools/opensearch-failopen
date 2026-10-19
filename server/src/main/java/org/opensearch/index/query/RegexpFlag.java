    public int value() {
    INTERSECTION(RegExp.INTERSECTION),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                magic |= flag.value();  
public enum RegexpFlag {
     * Enables intersection of the form: {@code &lt;expression&gt; &amp; &lt;expression&gt;}
     *     <li>ANYSTRING</li>
                RegexpFlag flag = RegexpFlag.valueOf(s.toUpperCase(Locale.ROOT));
            if (s.isEmpty()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
     */  
 * Regular expression syntax flags. Each flag represents optional syntax support in the regular expression:  
 */
     * following syntax:
 * The OpenSearch Contributors require contributions made to  
 *
            }  
import org.opensearch.core.common.Strings;
 * Modifications Copyright OpenSearch Contributors. See  
 * compatible open source license.
     */
     * Example: {@code INTERSECTION|COMPLEMENT|EMPTY}
 * @see RegexpQueryBuilder#flags(RegexpFlag...)  
 * Unless required by applicable law or agreed to in writing,
     */  
        return magic;
     *  
    }  
     * Enables numerical interval expression: {@code &lt;n-m&gt;}  
     * Resolves the combined OR'ed value for the given list of regular expression flags. The given flags must follow the
 * software distributed under the License is distributed on an
     */
    /**  
    /**  
     * Where {@code flag_name} is one of the following:  
 *     <li>{@code ANYSTRING} - Support for the any string symbol: {@code @}</li>
 * license agreements. See the NOTICE file distributed with
    EMPTY(RegExp.EMPTY),
            }  
    /**  
 * specific language governing permissions and limitations
 */  
/*
                }
    ALL(RegExp.ALL);  
    ANYSTRING(RegExp.ANYSTRING),  
                }
 *     <li>{@code NONE} - Disable support for all syntax options</li>
     * </ul>  
                throw new IllegalArgumentException("Unknown regexp flag [" + s + "]");
     * <ul>
 *
/*
 */  
                    continue;
     *     <li>ALL</li>
    RegexpFlag(int value) {
    /**
 * this work for additional information regarding copyright
import java.util.Locale;  
                if (flag == RegexpFlag.ALL) {  
 *
 * You may obtain a copy of the License at  
     * {@code flag_name}(|{@code flag_name})*
     *     <li>INTERSECTION</li>
 *  
 *
        this.value = value;
    /**
     */  
                    return flag.value();
     * <p>
     *     <li>EMPTY</li>
package org.opensearch.index.query;
            return RegExp.ALL;  
                if (flag == RegexpFlag.NONE) {  
            } catch (IllegalArgumentException iae) {
     *     <li>NONE</li>
                continue;
/**
     * Enables all available option flags
     * <p>
 * SPDX-License-Identifier: Apache-2.0
    /**  
            try {
     * @param flags A string representing a list of regular expression flags
 *     <li>{@code INTERSECTION} - Support for intersection notation: {@code &lt;expression&gt; &amp; &lt;expression&gt;}</li>
     *     <li>COMPLEMENT</li>  
     */
     */
        }
    NONE(RegExp.NONE),
     * Disables all available option flags
 *     <li>{@code INTERVAL} - Support for numerical interval notation: {@code &lt;n-m&gt;}</li>  
 * Licensed to Elasticsearch under one or more contributor  
 * <ul>
 * </ul>  
 * GitHub history for details.
     * @return The combined OR'ed value for all the flags
        }
import org.apache.lucene.util.automaton.RegExp;  
    COMPLEMENT(RegExp.DEPRECATED_COMPLEMENT),
     * Enables any string expression: {@code @}
    final int value;
    /**
 * not use this file except in compliance with the License.
 */
        for (String s : Strings.delimitedListToStringArray(flags, "|")) {  
    /**
     * <p>  
        int magic = RegExp.NONE;
     * Enables empty language expression: {@code #}
    public static int resolveValue(String flags) {
 * ownership. Elasticsearch licenses this file to you under  
    }  
 *     <li>{@code ALL} - Enables support for all syntax options</li>
 *     <li>{@code COMPLEMENT} - Support for complement notation: {@code &lt;expression&gt; &amp; &lt;expression&gt;}</li>  
     */
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    INTERVAL(RegExp.INTERVAL),
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
     *     <li>INTERVAL</li>  
    }
     * Enables complement expression of the form: {@code ~&lt;expression&gt;}  
        if (flags == null || flags.isEmpty()) {
        return value;  
 *     <li>{@code EMPTY} - Support for the empty language symbol: {@code #}</li>
 * the Apache License, Version 2.0 (the "License"); you may
 * @see RegexpQueryBuilder#flags(RegexpFlag...)
}
