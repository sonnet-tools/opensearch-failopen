     * case sensitive.
        if (caseInsensitive) {
     * arbitrary number of pattern parts), as well as direct equality.
    }
        }
 */
    public static boolean isSimpleMatchPattern(String str) {
    }
/*
    }
                        return true;
import java.util.Locale;
        Automaton intersection = Operations.intersection(simpleMatchToAutomaton(pattern1), simpleMatchToAutomaton(pattern2));
        for (String s : Strings.delimitedListToStringArray(flags, "|")) {
        boolean pattern1IsWildcard = isSimpleMatchPattern(pattern1);
        if (pattern == null || str == null) {
            } else if (("UNICODE_CHAR_CLASS".equals(s)) || ("UNICODE_CHARACTER_CLASS".equals(s))) {
public class Regex {
    /**
import org.opensearch.common.Glob;
     * @param pattern the pattern to match against
        if ((flags & Pattern.UNICODE_CASE) != 0) {
        List<Automaton> automata = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
                continue;
 */
 * the Apache License, Version 2.0 (the "License"); you may
        return sb.toString();
            sb.append("UNIX_LINES|");
        }
     */
    public static boolean simpleMatch(String[] patterns, String str) {
    /**
 */
        // linear-sized automaton (literals + makeAnyString); the intersection stays small enough that
    /**
        for (String pattern : patterns) {
        if ((flags & Pattern.MULTILINE) != 0) {
 *
     * may be a simple-match pattern ("xxx*", "*xxx", "*xxx*", "xxx*yyy") or a
     */
    }
        // #simpleMatch(String[], String) is likely to be inlined into this method
     * Return an Automaton that matches the union of the provided patterns.
        }
        }
     * Matching is case sensitive.
            return false;
            } else if ("COMMENTS".equals(s)) {
     * exists at least one string that both patterns would match. Each argument
        }
     *
            sb.append("CANON_EQ|");
 */
     * Is the str a simple match pattern.
     */
    public static int flagsFromString(String flags) {
     * @return whether some string is matched by both patterns
 *
    /**
        if ((flags & Pattern.COMMENTS) != 0) {
                pFlags |= Pattern.COMMENTS;
                if (simpleMatch(pattern, str)) {
    }
        }
    /** Return an {@link Automaton} that matches the given pattern. */
        if (pattern2IsWildcard == false) {
     * match.
            s = s.toUpperCase(Locale.ROOT);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        automata.add(Automata.makeString(pattern.substring(previous)));
     *
                    if (simpleMatch(pattern, type)) {
import java.util.regex.Pattern;
     * Match a String against the given pattern, supporting the following simple
            str = Strings.toLowercaseAscii(str);
    }
    public static Pattern compile(String regex, String flags) {
                pFlags |= UNICODE_CHARACTER_CLASS;
            previous = i + 1;
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        }
            for (String type : types) {
    public static boolean simpleMatch(String pattern, String str, boolean caseInsensitive) {
 * this work for additional information regarding copyright
     */
import org.apache.lucene.util.automaton.Automata;
        }
        StringBuilder sb = new StringBuilder();
            sb.append("MULTILINE|");
                pFlags |= Pattern.DOTALL;
        return false;
            }
            automata.add(Automata.makeAnyString());
        return Operations.isEmpty(intersection) == false;
            } else if ("DOTALL".equals(s)) {
     * Determine whether two simple-match patterns overlap, i.e. whether there
        return patterns != null && simpleMatch(patterns.toArray(Strings.EMPTY_ARRAY), str);
            } else if ("UNICODE_CASE".equals(s)) {
        if (pattern1 == null || pattern2 == null) {
                pFlags |= Pattern.LITERAL;
            automata.add(simpleMatchToAutomaton(pattern));
        }
        }
    public static boolean isMatchAllPattern(String str) {
    }
        return pFlags;
                }
    public static boolean simpleMatch(String pattern, String str) {
    /**
     * @return whether the String matches the given pattern
            } else {
            sb.append("UNICODE_CASE|");
     * Similar to {@link #simpleMatch(String[], String)}, but accepts a list of strings instead of an array of strings for the patterns to
    /**
     * @param patterns the patterns to match against
 * ownership. Elasticsearch licenses this file to you under
 *
/**
    /**
        }
                    }
        if ((flags & Pattern.CASE_INSENSITIVE) != 0) {
    public static String flagsToString(int flags) {
        return str.indexOf('*') != -1;
    }
        return Pattern.compile(regex, pFlags);
 * You may obtain a copy of the License at
            } else if ("LITERAL".equals(s)) {
            sb.append("DOTALL|");
    /**
        // Fast path: two literals overlap only when they are equal.
}
     */
     * pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an
            }
        if (pattern1IsWildcard == false) {
     */
     * arbitrary number of pattern parts), as well as direct equality.
            sb.append("UNICODE_CHAR_CLASS|");
        }
 * compatible open source license.
        if (patterns != null && types != null) {
            throw new IllegalArgumentException("There must be at least one pattern, zero given");
import org.opensearch.core.common.Strings;
 * not use this file except in compliance with the License.
     */
            pattern = Strings.toLowercaseAscii(pattern);
            if (s.isEmpty()) {
     * @param caseInsensitive  true if ASCII case differences should be ignored
        if ((flags & Pattern.LITERAL) != 0) {
        // Both patterns contain wildcards. Simple-match only supports '*', so each pattern maps to a
            sb.append("LITERAL|");
        if (pattern1IsWildcard == false && pattern2IsWildcard == false) {
        if (patterns.length < 1) {
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.util.automaton.Operations;
     *
     * arbitrary number of pattern parts), as well as direct equality.
        if ((flags & Pattern.DOTALL) != 0) {
            if ("CASE_INSENSITIVE".equals(s)) {
        if (patterns != null) {
 * SPDX-License-Identifier: Apache-2.0
            for (String pattern : patterns) {
     * @return whether the String matches the given pattern
        return false;
    public static final int UNICODE_CHARACTER_CLASS = 0x100; // supported in JAVA7
    public static Automaton simpleMatchToAutomaton(String pattern) {
     * @param pattern1 the first pattern (or literal) to compare
        }
            } else if ("MULTILINE".equals(s)) {
    }
                pFlags |= Pattern.MULTILINE;
            return pattern1.equals(pattern2);
/*
        if ((flags & UNICODE_CHARACTER_CLASS) != 0) {
     * @param str      the String to match
     * @param pattern2 the second pattern (or literal) to compare
            } else if ("UNIX_LINES".equals(s)) {
            automata.add(Automata.makeString(pattern.substring(previous, i)));
            } else if ("CANON_EQ".equals(s)) {
            sb.append("CASE_INSENSITIVE|");
     * pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an
        for (int i = pattern.indexOf('*'); i != -1; i = pattern.indexOf('*', i + 1)) {
 * @opensearch.internal
     * @param pattern the pattern to match against
     */
        int pFlags = flags == null ? 0 : flagsFromString(flags);
 * under the License.
        List<Automaton> automata = new ArrayList<>();
            return false;
        if ((flags & Pattern.CANON_EQ) != 0) {
        return str.equals("*");
 * software distributed under the License is distributed on an
        return Operations.concatenate(automata);
package org.opensearch.common.regex;
        int previous = 0;
     * Match a String against the given patterns, supporting the following simple
     * plain literal, which is treated as an exact-match pattern. Matching is
        // Fast path: literal vs wildcard overlaps iff the wildcard matches the literal (cheap glob scan).
        }
                pFlags |= Pattern.UNIX_LINES;
    }
        }
     * @return whether the String matches any of the given patterns
     * If set on a Java6 JVM the flag will be ignored.
        boolean pattern2IsWildcard = isSimpleMatchPattern(pattern2);
/*
 * Licensed to Elasticsearch under one or more contributor
 * specific language governing permissions and limitations
import java.util.List;
     * @param str     the String to match
                for (String pattern : patterns) {
     * @param str     the String to match
                    return true;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        }
     *
        }
        return Glob.globMatch(pattern, str);
        }
            return simpleMatch(pattern1, pattern2);
        if ((flags & Pattern.UNIX_LINES) != 0) {
        return simpleMatch(pattern, str, false);
        int pFlags = 0;
            }
 *
        }
            }
 * Main regex class.
                throw new IllegalArgumentException("Unknown regex flag [" + s + "]");
     * This Regex / {@link Pattern} flag is supported from Java 7 on.
    public static boolean simpleMatch(final List<String> patterns, final String str) {
import org.apache.lucene.util.automaton.Automaton;
    }
 * GitHub history for details.
                pFlags |= Pattern.UNICODE_CASE;
            return simpleMatch(pattern2, pattern1);
            sb.append("COMMENTS|");
                pFlags |= Pattern.CANON_EQ;
     * pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an
    public static boolean simpleMatch(String[] patterns, String[] types) {
        // determinization never hits Lucene's complexity limit.
     * Match a String against the given pattern, supporting the following simple
                }
    }
 * license agreements. See the NOTICE file distributed with
import java.util.ArrayList;
        }
                pFlags |= Pattern.CASE_INSENSITIVE;
    public static Automaton simpleMatchToAutomaton(String... patterns) {
    public static boolean simpleMatchOverlap(String pattern1, String pattern2) {
        }
 * The OpenSearch Contributors require contributions made to
        return Operations.union(automata);
