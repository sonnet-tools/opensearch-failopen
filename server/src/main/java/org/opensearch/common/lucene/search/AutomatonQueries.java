     * Build an automaton accepting all terms ASCII case insensitive.
    public static AutomatonQuery caseInsensitivePrefixQuery(Term prefix, MultiTermQuery.RewriteMethod method) {
            i += length;
/*
     * Convert Lucene wildcard syntax into an automaton.
                case WILDCARD_CHAR:
/**
        }
                case WILDCARD_ESCAPE:
 * the Apache License, Version 2.0 (the "License"); you may
    /**
    }
    /**
 * this file be licensed under the Apache-2.0 license or a
 * Helper functions for creating various forms of {@link AutomatonQuery}
            switch (c) {
        return createAutomatonQuery(prefix, caseInsensitivePrefix(prefix.text()), method);
import java.util.Arrays;
import java.util.Iterator;
            }
    /**
 * KIND, either express or implied.  See the License for the
    public static final char WILDCARD_ESCAPE = '\\';
 * this work for additional information regarding copyright
        assert automaton.isDeterministic();
     */
 * specific language governing permissions and limitations
    public static Automaton toCaseInsensitiveChar(int codepoint) {
 *
        Automaton automaton = toCaseInsensitiveWildcardAutomaton(wildcardquery);
        }
 *
            throw new RuntimeException("Wildcard query too complex to determinize for term: " + wildcardquery, e);
        BytesRef prefix = term.bytes();
            list.add(toCaseInsensitiveChar(iter.next()));
    public static Automaton caseInsensitivePrefix(String s) {
        } else {
            automaton = Operations.determinize(automaton, Operations.DEFAULT_DETERMINIZE_WORK_LIMIT);
        try {
        String wildcardText = wildcardquery.text();
    /**
     * Build an automaton query accepting all terms with the specified prefix, ASCII case insensitive.
 * license agreements. See the NOTICE file distributed with
        if (codepoint > 128) {
                    break;
/*
import org.apache.lucene.util.automaton.Automata;
        for (int i = 0; i < wildcardText.length();) {
     * Char equality with support for wildcards
                case WILDCARD_STRING:
    protected static Automaton toCaseInsensitiveString(BytesRef br) {
            return case1;
     */
    }
 * under the License.
 * Unless required by applicable law or agreed to in writing,
     * String equality with support for wildcards
        if (altCase != codepoint) {
                    automata.add(Automata.makeAnyChar());
 *     http://www.apache.org/licenses/LICENSE-2.0
        Iterator<Integer> iter = s.codePoints().iterator();
    }
import org.apache.lucene.search.MultiTermQuery;
        while (iter.hasNext()) {
                    automata.add(toCaseInsensitiveChar(c));
 *
 */
import java.util.ArrayList;
     */
                        break;
        return new AutomatonQuery(term, toCaseInsensitiveString(prefix));
        list.add(Automata.makeAnyString());
        }
    public static Automaton toCaseInsensitiveString(String s) {
    public static final char WILDCARD_CHAR = '?';
                    break;
 * GitHub history for details.
import org.apache.lucene.util.automaton.TooComplexToDeterminizeException;
    }
    }
    public static final char WILDCARD_STRING = '*';
     */
        List<Automaton> automata = new ArrayList<>();
     * Build an automaton matching a wildcard pattern, ASCII case insensitive, if the method is null, then will use {@link  MultiTermQuery#CONSTANT_SCORE_BLENDED_REWRITE}.
        Iterator<Integer> iter = s.codePoints().iterator();
                        length += Character.charCount(nextChar);
                        final int nextChar = wildcardText.codePointAt(i + length);
    }
    /**
    }
        return toCaseInsensitiveString(br.utf8ToString());
    public static AutomatonQuery caseInsensitivePrefixQuery(Term prefix) {
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
     */
        return createAutomatonQuery(wildcardquery, automaton, method);
        // For now we only work with ASCII characters
    @SuppressWarnings("fallthrough")
    public static AutomatonQuery caseInsensitiveWildcardQuery(Term wildcardquery, MultiTermQuery.RewriteMethod method) {
import java.util.List;
 * The OpenSearch Contributors require contributions made to
    public static Automaton toCaseInsensitiveWildcardAutomaton(Term wildcardquery) {
 */
                    if (i + length < wildcardText.length()) {
package org.opensearch.common.lucene.search;
            result = case1;
 */
                    } // else fallthru, lenient parsing with a trailing \
        }
 * @opensearch.internal
        if (method == null) {
import org.apache.lucene.util.automaton.Automaton;
 * not use this file except in compliance with the License.
        return Operations.concatenate(list);
 *
 * ownership. Elasticsearch licenses this file to you under
import org.apache.lucene.index.Term;
    public static AutomatonQuery caseInsensitiveTermQuery(Term term) {
            method = MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE;
    }
     * Escape character
    /** Build an automaton query accepting all terms with the specified prefix, ASCII case insensitive. */
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
 */
        }
        return caseInsensitivePrefixQuery(prefix, MultiTermQuery.CONSTANT_SCORE_REWRITE);
        List<Automaton> list = new ArrayList<>();
            int length = Character.charCount(c);
        Automaton case1 = Automata.makeChar(codepoint);
        int altCase = Character.isLowerCase(codepoint) ? Character.toUpperCase(codepoint) : Character.toLowerCase(codepoint);
/*
        while (iter.hasNext()) {
 * You may obtain a copy of the License at
                    automata.add(Automata.makeAnyString());
     */
     * Build an automaton matching a given pattern with rewrite method, if the rewrite method is null, then will use {@link  MultiTermQuery#CONSTANT_SCORE_BLENDED_REWRITE}.
    /**
            final int c = wildcardText.codePointAt(i);
                    // add the next codepoint instead, if it exists
import org.apache.lucene.util.BytesRef;
        return result;
}
        return new AutomatonQuery(term, automaton, false, method);
                default:
    /**
 * Licensed to Elasticsearch under one or more contributor
        List<Automaton> list = new ArrayList<>();
import org.apache.lucene.util.automaton.Operations;
 * compatible open source license.
        } catch (TooComplexToDeterminizeException e) {
        return a;
        }
        Automaton a = Operations.concatenate(list);
    }
     * Build an automaton query accepting all terms with the specified prefix, ASCII case insensitive.
        return Operations.concatenate(automata);
    /**
        assert a.isDeterministic();
    }
        Automaton result;
     */
    /**
import org.apache.lucene.search.AutomatonQuery;
                        automata.add(Automata.makeChar(nextChar));
public class AutomatonQueries {
            list.add(toCaseInsensitiveChar(iter.next()));
 * Modifications Copyright OpenSearch Contributors. See
     */
            result = Operations.union(Arrays.asList(case1, Automata.makeChar(altCase)));
    public static AutomatonQuery createAutomatonQuery(Term term, Automaton automaton, MultiTermQuery.RewriteMethod method) {
