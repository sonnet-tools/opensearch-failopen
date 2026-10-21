            assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
            "Pattern p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ", 2)" };
    }
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
    public static void afterClass() {
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
    }
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
 *     http://www.apache.org/licenses/LICENSE-2.0
            + CHAR_SEQUENCE
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
/*
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
            "Pattern p = " + PATTERN + "; p.splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)" };
            + PATTERN
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
            "def p = " + PATTERN + "; p.matcher(" + CHAR_SEQUENCE + ").matches()",
        }
        return SCRIPT_ENGINE;
            assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
    private static final String CHAR_SEQUENCE = "'abcdodef'";
 */
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
    }
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
    public void testRegexInject_Matcher() {
            + ";"
        assertTrue(cbe.getMessage().contains(charSequence.subSequence(0, 61) + "..."));
    public void testRegexInject_Split() {
    public void testRegexInject_DefMethodRef_SplitLimit() {
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
        String script = "String[] split(Function func) { func.apply("
 * license agreements. See the NOTICE file distributed with
        String script = "String[] splitLimit(BiFunction func) { func.apply("
            + "Pattern pattern = "
        String script = "def p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ")";
            "Pattern p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ")" };
        String script = "Stream splitStream(Function func) { func.apply("
            assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
            PATTERN + ".split(" + SPLIT_CHAR_SEQUENCE + ")",
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
        String[] scripts = new String[] {
    }
            + "); } "
            + PATTERN
import org.opensearch.core.common.breaker.CircuitBreakingException;
package org.opensearch.painless;
        String script = "def p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ", 2)";
}
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
            + ";"
            + ").matches(); } "
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
            + ";"
            "Matcher m = " + PATTERN + ".matcher(" + CHAR_SEQUENCE + "); m.matches()" };
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
    public void testRegexInject_Def_SplitAsStream() {
            + "); } "
    public void testRegexInject_Ref_Split() {
/*
public class RegexLimitTests extends ScriptTestCase {
        String[] scripts = new String[] {
            + ", 2); } "
        String script = "def p = " + PATTERN + "; p.splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)";
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
 * Unless required by applicable law or agreed to in writing,
            + PATTERN
    public void testRegexInject_Def_Split() {
    }
import org.junit.BeforeClass;
            // Backtracking means the regular expression will fail with limit factor 1 (don't consider more than each char once)
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
            + "def pattern = "
    public void testMethodRegexInject_Ref_Matcher() {
        String script = "boolean isMatch(Function func) { func.apply("
 */
    }
import java.util.Collections;
            + "splitStream(pattern::splitAsStream).toArray(String[]::new)";
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
        for (String script : scripts) {
    @BeforeClass
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
            assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
    public static void beforeClass() {
            + ").matches(); } "
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
    }
        String[] scripts = new String[] {
            + "Pattern pattern = "
            + "splitStream(pattern::splitAsStream).toArray(String[]::new)";
        for (String script : scripts) {
    }
            + "split(pattern::split)";
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
 * not use this file except in compliance with the License.
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
        SCRIPT_ENGINE = new PainlessScriptEngine(settings, newDefaultContexts());
 *
    private static final String SPLIT_CHAR_SEQUENCE = "'0-abc-1-def-X-abc-2-def-Y-abc-3-def-Z-abc'";
    }
    private static PainlessScriptEngine SCRIPT_ENGINE;
            + PATTERN
        }
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
            + "Pattern pattern = "
 * Modifications Copyright OpenSearch Contributors. See
    public void testRegexInject_DefMethodRef_Split() {
            CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
 * The OpenSearch Contributors require contributions made to
            + "isMatch(pattern::matcher)";
        String script = "boolean isMatch(Function func) { func.apply("
    protected PainlessScriptEngine getEngine() {
    }
 * Licensed to Elasticsearch under one or more contributor
    public void testRegexInject_DefMethodRef_SplitAsStream() {
            + "isMatch(pattern::matcher)";
            assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
    @AfterClass
            + ";"
import org.opensearch.common.settings.Settings;
    // This regex has backtracking due to .*?
 * SPDX-License-Identifier: Apache-2.0
            + CHAR_SEQUENCE
            CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
            + SPLIT_CHAR_SEQUENCE
        String script = "if (" + CHAR_SEQUENCE + " =~ " + PATTERN + ") { return 100; } return 200";
            + SPLIT_CHAR_SEQUENCE
    public void testRegexInject_DefMethodRef_Matcher() {
 *
            + "splitLimit(pattern::split)";
    public void testRegexInject_Def_SplitLimit() {
        String script = "Stream splitStream(Function func) { func.apply("
            + ", 2); } "
            PATTERN + ".splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)",
            + "def pattern = "
 * this file be licensed under the Apache-2.0 license or a
            + "); } "
        }
        String script = "if ('" + charSequence + "' ==~ " + PATTERN + ") { return 100; } return 200";
            + ";"
            + "def pattern = "
            PATTERN + ".split(" + SPLIT_CHAR_SEQUENCE + ", 2)",
    }
    public void testRegexInjectFindOperator() {
            + ";"
    public void testSnippetRegex() {
    }
    private static final String PATTERN = "/abc.*?def/";
 * specific language governing permissions and limitations
    }
    }
 * this work for additional information regarding copyright
            + "split(pattern::split)";
    public void testRegexInject_SplitLimit() {
            PATTERN + ".matcher(" + CHAR_SEQUENCE + ").matches()",
 * under the License.
        String[] scripts = new String[] {
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
            + SPLIT_CHAR_SEQUENCE
        SCRIPT_ENGINE = null;
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
            + SPLIT_CHAR_SEQUENCE
    }
            + "); } "
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
    }
    }
            "def p = " + PATTERN + "; def m = p.matcher(" + CHAR_SEQUENCE + "); m.matches()" };
        String script = "String[] split(Function func) { func.apply("
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
        }
        String charSequence = String.join("", Collections.nCopies(100, "abcdef123456"));
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * software distributed under the License is distributed on an
            + "splitLimit(pattern::split)";
        String script = "String[] splitLimit(BiFunction func) { func.apply("
            + PATTERN
 * ownership. Elasticsearch licenses this file to you under
        }
            + PATTERN
    }
    }
    public void testRegexInject_Def_Matcher() {
        for (String script : scripts) {
 * KIND, either express or implied.  See the License for the
 *
    }
    }
            + ";"
            + SPLIT_CHAR_SEQUENCE
    @Override
            + PATTERN
        for (String script : scripts) {
            + ";"
    public void testRegexInject_SplitAsStream() {
            + "def pattern = "
        Settings settings = Settings.builder().put(CompilerSettings.REGEX_LIMIT_FACTOR.getKey(), 1).build();
            CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
    }
        String script = "if (" + CHAR_SEQUENCE + " ==~ " + PATTERN + ") { return 100; } return 200";
            + SPLIT_CHAR_SEQUENCE
        String[] scripts = new String[] {
 * compatible open source license.
        for (String script : scripts) {
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
    public void testRegexInjectMatchOperator() {
    public void testRegexInject_Ref_SplitAsStream() {
 */
    private static final String REGEX_CIRCUIT_MESSAGE = "[scripting] Regular expression considered too many characters";
 * You may obtain a copy of the License at
            CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
/*
            + "Pattern pattern = "
    public void testRegexInject_Ref_SplitLimit() {
import org.junit.AfterClass;
            CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
            + PATTERN
