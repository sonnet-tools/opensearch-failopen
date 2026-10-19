     * @return whether the String matches the given pattern  
    }
    public static int flagsFromString(String flags) {  
            } else if ("LITERAL".equals(s)) {
     * @param patterns the patterns to match against  
        if (pattern1IsWildcard == false && pattern2IsWildcard == false) {  
        }  
    /**
                pFlags |= Pattern.LITERAL;
/*
            } else if ("UNIX_LINES".equals(s)) {
        }  
     * @param pattern the pattern to match against  
    }
        List<Automaton> automata = new ArrayList<>();
    public static Pattern compile(String regex, String flags) {
        }
        if (caseInsensitive) {  
import java.util.Locale;  
            sb.append("UNICODE_CASE|");
     * may be a simple-match pattern ("xxx*", "*xxx", "*xxx*", "xxx*yyy") or a  
                }  
        }  
        int pFlags = 0;
        for (String pattern : patterns) {  
                pFlags |= Pattern.DOTALL;  
            sb.append("UNICODE_CHAR_CLASS|");
    /**
     * arbitrary number of pattern parts), as well as direct equality.
     * pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an  
        }
        return false;  
    }  
        return simpleMatch(pattern, str, false);
     * @param caseInsensitive  true if ASCII case differences should be ignored
            previous = i + 1;
            }
        int pFlags = flags == null ? 0 : flagsFromString(flags);
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
        return Glob.globMatch(pattern, str);
    }  
     *
     * This Regex / {@link Pattern} flag is supported from Java 7 on.
            }
            return false;
import org.opensearch.core.common.Strings;
        int previous = 0;  
        for (int i = pattern.indexOf('*'); i != -1; i = pattern.indexOf('*', i + 1)) {
     */
                    return true;
        }
 * this file be licensed under the Apache-2.0 license or a
        return str.indexOf('*') != -1;
     * @param str     the String to match
        }
            } else {
    public static String flagsToString(int flags) {
 * Modifications Copyright OpenSearch Contributors. See
                        return true;
 */  
package org.opensearch.common.regex;
     * @return whether the String matches the given pattern
     */
import java.util.List;
    public static Automaton simpleMatchToAutomaton(String pattern) {
                pFlags |= Pattern.CANON_EQ;
 * GitHub history for details.
            }  
                    if (simpleMatch(pattern, type)) {
    }
    }
 */  
                pFlags |= Pattern.CASE_INSENSITIVE;
        if ((flags & UNICODE_CHARACTER_CLASS) != 0) {
        }  
        return pFlags;
        // Fast path: literal vs wildcard overlaps iff the wildcard matches the literal (cheap glob scan).  
 * The OpenSearch Contributors require contributions made to  
        }  
    }
     */  
    /**
     * Match a String against the given pattern, supporting the following simple
    /**
            } else if ("DOTALL".equals(s)) {
            automata.add(Automata.makeString(pattern.substring(previous, i)));
            sb.append("LITERAL|");
        }
     * Similar to {@link #simpleMatch(String[], String)}, but accepts a list of strings instead of an array of strings for the patterns to
                throw new IllegalArgumentException("Unknown regex flag [" + s + "]");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw new IllegalArgumentException("There must be at least one pattern, zero given");  
 * @opensearch.internal  
    /** Return an {@link Automaton} that matches the given pattern. */  
            pattern = Strings.toLowercaseAscii(pattern);
        if (pattern1 == null || pattern2 == null) {  
        StringBuilder sb = new StringBuilder();  
                continue;
import org.apache.lucene.util.automaton.Operations;  
    public static boolean isSimpleMatchPattern(String str) {
     * arbitrary number of pattern parts), as well as direct equality.
            sb.append("UNIX_LINES|");
            return simpleMatch(pattern1, pattern2);
    public static Automaton simpleMatchToAutomaton(String... patterns) {
            for (String type : types) {
import org.apache.lucene.util.automaton.Automata;
            if (s.isEmpty()) {  
     * match.
        }
                pFlags |= Pattern.COMMENTS;
    }  
            } else if ("MULTILINE".equals(s)) {  
     * @param pattern the pattern to match against
            sb.append("MULTILINE|");
        if (pattern1IsWildcard == false) {
    /**
     * Matching is case sensitive.  
            str = Strings.toLowercaseAscii(str);
            return pattern1.equals(pattern2);
        return false;
        }
 * SPDX-License-Identifier: Apache-2.0
        }  
 * Unless required by applicable law or agreed to in writing,
        // Both patterns contain wildcards. Simple-match only supports '*', so each pattern maps to a
     * @return whether the String matches any of the given patterns
 *
                if (simpleMatch(pattern, str)) {
            return false;
    public static final int UNICODE_CHARACTER_CLASS = 0x100; // supported in JAVA7
    }
        List<Automaton> automata = new ArrayList<>();
    }
            automata.add(Automata.makeAnyString());  
     * Determine whether two simple-match patterns overlap, i.e. whether there
    public static boolean simpleMatch(String[] patterns, String str) {
            sb.append("DOTALL|");
                pFlags |= Pattern.MULTILINE;
    public static boolean isMatchAllPattern(String str) {
            }
        // determinization never hits Lucene's complexity limit.  
    public static boolean simpleMatch(final List<String> patterns, final String str) {
     * exists at least one string that both patterns would match. Each argument
        if (patterns != null && types != null) {
    /**  
import org.opensearch.common.Glob;
    }
     * pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an
     * @param pattern1 the first pattern (or literal) to compare
            return simpleMatch(pattern2, pattern1);
     * Is the str a simple match pattern.
                pFlags |= UNICODE_CHARACTER_CLASS;  
        // #simpleMatch(String[], String) is likely to be inlined into this method
}  
     * @param pattern2 the second pattern (or literal) to compare
        Automaton intersection = Operations.intersection(simpleMatchToAutomaton(pattern1), simpleMatchToAutomaton(pattern2));
 * KIND, either express or implied.  See the License for the
        return Operations.union(automata);  
                for (String pattern : patterns) {  
import java.util.regex.Pattern;
        if ((flags & Pattern.COMMENTS) != 0) {
     */  
        return str.equals("*");  
        // linear-sized automaton (literals + makeAnyString); the intersection stays small enough that
 * Main regex class.
     * Return an Automaton that matches the union of the provided patterns.
        }  
     */
 * this work for additional information regarding copyright
public class Regex {
    }
 *
    public static boolean simpleMatch(String pattern, String str, boolean caseInsensitive) {
     */
 * license agreements. See the NOTICE file distributed with
        if ((flags & Pattern.LITERAL) != 0) {
        }  
        boolean pattern1IsWildcard = isSimpleMatchPattern(pattern1);  
 * not use this file except in compliance with the License.
 *  
 * under the License.  
            sb.append("CASE_INSENSITIVE|");
     * pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an  
            } else if ("CANON_EQ".equals(s)) {  
/*  
import org.apache.lucene.util.automaton.Automaton;
        if ((flags & Pattern.UNIX_LINES) != 0) {
            for (String pattern : patterns) {  
        if ((flags & Pattern.MULTILINE) != 0) {
 * specific language governing permissions and limitations
        }
            } else if (("UNICODE_CHAR_CLASS".equals(s)) || ("UNICODE_CHARACTER_CLASS".equals(s))) {
     * plain literal, which is treated as an exact-match pattern. Matching is
        // Fast path: two literals overlap only when they are equal.
        }  
 * software distributed under the License is distributed on an
        }  
            if ("CASE_INSENSITIVE".equals(s)) {
        return Pattern.compile(regex, pFlags);  
            sb.append("COMMENTS|");
        if ((flags & Pattern.UNICODE_CASE) != 0) {
        if (patterns != null) {
        boolean pattern2IsWildcard = isSimpleMatchPattern(pattern2);
     * If set on a Java6 JVM the flag will be ignored.  
 *
            } else if ("UNICODE_CASE".equals(s)) {
 * compatible open source license.
     * case sensitive.
     *
            automata.add(simpleMatchToAutomaton(pattern));
    }
/**  
        }  
        return sb.toString();
    /**  
import java.util.ArrayList;
        return Operations.concatenate(automata);
     *
                    }  
        if ((flags & Pattern.DOTALL) != 0) {
 * Licensed to Elasticsearch under one or more contributor  
     * @param str     the String to match  
        if ((flags & Pattern.CASE_INSENSITIVE) != 0) {
     * Match a String against the given pattern, supporting the following simple  
    public static boolean simpleMatch(String pattern, String str) {  
     * arbitrary number of pattern parts), as well as direct equality.
        if (pattern2IsWildcard == false) {
     * Match a String against the given patterns, supporting the following simple
 * the Apache License, Version 2.0 (the "License"); you may
                pFlags |= Pattern.UNIX_LINES;  
     */  
     * @param str      the String to match
            sb.append("CANON_EQ|");
 */
        return Operations.isEmpty(intersection) == false;
        if ((flags & Pattern.CANON_EQ) != 0) {
            s = s.toUpperCase(Locale.ROOT);  
     * @return whether some string is matched by both patterns  
    public static boolean simpleMatch(String[] patterns, String[] types) {  
        return patterns != null && simpleMatch(patterns.toArray(Strings.EMPTY_ARRAY), str);  
        if (patterns.length < 1) {
        }  
    public static boolean simpleMatchOverlap(String pattern1, String pattern2) {
                }
     */  
            } else if ("COMMENTS".equals(s)) {  
                pFlags |= Pattern.UNICODE_CASE;
        automata.add(Automata.makeString(pattern.substring(previous)));  
 */
        for (String s : Strings.delimitedListToStringArray(flags, "|")) {
        }  
        if (pattern == null || str == null) {  
    /**
     *  
