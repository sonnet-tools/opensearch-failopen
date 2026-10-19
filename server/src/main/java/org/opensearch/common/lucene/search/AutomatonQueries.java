 */
            throw new RuntimeException("Wildcard query too complex to determinize for term: " + wildcardquery, e);  
     * Build an automaton accepting all terms ASCII case insensitive.  
        Automaton a = Operations.concatenate(list);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
import java.util.Iterator;  
                case WILDCARD_ESCAPE:
            int length = Character.charCount(c);  
    protected static Automaton toCaseInsensitiveString(BytesRef br) {
 * Helper functions for creating various forms of {@link AutomatonQuery}
 * this work for additional information regarding copyright
        return Operations.concatenate(list);
            }  
     */  
        } catch (TooComplexToDeterminizeException e) {
 * this file be licensed under the Apache-2.0 license or a
    public static AutomatonQuery caseInsensitiveWildcardQuery(Term wildcardquery, MultiTermQuery.RewriteMethod method) {
 * Unless required by applicable law or agreed to in writing,
        Iterator<Integer> iter = s.codePoints().iterator();
        return caseInsensitivePrefixQuery(prefix, MultiTermQuery.CONSTANT_SCORE_REWRITE);
        if (codepoint > 128) {
     * Escape character  
        for (int i = 0; i < wildcardText.length();) {
    /**  
            list.add(toCaseInsensitiveChar(iter.next()));  
    /**
        List<Automaton> list = new ArrayList<>();  
        list.add(Automata.makeAnyString());
        String wildcardText = wildcardquery.text();
    public static final char WILDCARD_STRING = '*';
        }
        return toCaseInsensitiveString(br.utf8ToString());
    /**
                    if (i + length < wildcardText.length()) {
    @SuppressWarnings("fallthrough")
 * You may obtain a copy of the License at  
        assert automaton.isDeterministic();
                    // add the next codepoint instead, if it exists  
        int altCase = Character.isLowerCase(codepoint) ? Character.toUpperCase(codepoint) : Character.toLowerCase(codepoint);
/**  
        return result;  
        Automaton result;  
                    break;
     * Build an automaton query accepting all terms with the specified prefix, ASCII case insensitive.
public class AutomatonQueries {
                    break;
     * Build an automaton matching a given pattern with rewrite method, if the rewrite method is null, then will use {@link  MultiTermQuery#CONSTANT_SCORE_BLENDED_REWRITE}.
package org.opensearch.common.lucene.search;
            method = MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
import java.util.Arrays;
     */
        return createAutomatonQuery(wildcardquery, automaton, method);  
     * Convert Lucene wildcard syntax into an automaton.
            return case1;  
        }
                case WILDCARD_CHAR:
import org.apache.lucene.util.automaton.Automaton;  
/*  
 * license agreements. See the NOTICE file distributed with
        }
        return createAutomatonQuery(prefix, caseInsensitivePrefix(prefix.text()), method);
    public static AutomatonQuery caseInsensitivePrefixQuery(Term prefix) {  
                    automata.add(Automata.makeAnyString());  
        } else {  
    }
        if (altCase != codepoint) {
            list.add(toCaseInsensitiveChar(iter.next()));  
import org.apache.lucene.index.Term;
    public static Automaton caseInsensitivePrefix(String s) {
            result = case1;
        return new AutomatonQuery(term, toCaseInsensitiveString(prefix));
        BytesRef prefix = term.bytes();  
     */  
 */
                        final int nextChar = wildcardText.codePointAt(i + length);
 * The OpenSearch Contributors require contributions made to  
                    automata.add(toCaseInsensitiveChar(c));
 * Modifications Copyright OpenSearch Contributors. See
    public static final char WILDCARD_CHAR = '?';  
 *
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.MultiTermQuery;  
    }
    }
 * SPDX-License-Identifier: Apache-2.0
        // For now we only work with ASCII characters
                default:
 */  
 * GitHub history for details.
            result = Operations.union(Arrays.asList(case1, Automata.makeChar(altCase)));
 */  
        List<Automaton> automata = new ArrayList<>();  
            i += length;
 * not use this file except in compliance with the License.
import org.apache.lucene.util.automaton.Operations;
     * Build an automaton query accepting all terms with the specified prefix, ASCII case insensitive.
    public static Automaton toCaseInsensitiveChar(int codepoint) {
    /**
        }
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
    }  
     */  
                        break;
            automaton = Operations.determinize(automaton, Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
        Automaton case1 = Automata.makeChar(codepoint);  
    public static final char WILDCARD_ESCAPE = '\\';
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
    }
                    } // else fallthru, lenient parsing with a trailing \  
 * ownership. Elasticsearch licenses this file to you under  
/*  
    public static AutomatonQuery caseInsensitivePrefixQuery(Term prefix, MultiTermQuery.RewriteMethod method) {
                        automata.add(Automata.makeChar(nextChar));
        Iterator<Integer> iter = s.codePoints().iterator();
        List<Automaton> list = new ArrayList<>();  
/*
 * @opensearch.internal  
    public static AutomatonQuery createAutomatonQuery(Term term, Automaton automaton, MultiTermQuery.RewriteMethod method) {  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
    public static AutomatonQuery caseInsensitiveTermQuery(Term term) {
import java.util.List;
    /**
                        length += Character.charCount(nextChar);  
import org.apache.lucene.search.AutomatonQuery;
        return Operations.concatenate(automata);
    /**  
import org.apache.lucene.util.automaton.Automata;
            switch (c) {
     */  
 *
        }
    public static Automaton toCaseInsensitiveWildcardAutomaton(Term wildcardquery) {
                    automata.add(Automata.makeAnyChar());  
            final int c = wildcardText.codePointAt(i);
    public static Automaton toCaseInsensitiveString(String s) {
        return new AutomatonQuery(term, automaton, false, method);
     */
import org.apache.lucene.util.automaton.TooComplexToDeterminizeException;
        }
        assert a.isDeterministic();
     */
        try {  
    /**
     */
}
    /**  
    }
        while (iter.hasNext()) {
    }  
        Automaton automaton = toCaseInsensitiveWildcardAutomaton(wildcardquery);
 *  
import java.util.ArrayList;
        }  
    }  
    /** Build an automaton query accepting all terms with the specified prefix, ASCII case insensitive. */
     * Char equality with support for wildcards
import org.apache.lucene.util.BytesRef;
        return a;  
        while (iter.hasNext()) {
        if (method == null) {
    }
     * String equality with support for wildcards
     * Build an automaton matching a wildcard pattern, ASCII case insensitive, if the method is null, then will use {@link  MultiTermQuery#CONSTANT_SCORE_BLENDED_REWRITE}.
     */
 * under the License.  
    }
                case WILDCARD_STRING:
