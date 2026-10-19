        return SCRIPT_ENGINE;
import org.opensearch.core.common.breaker.CircuitBreakingException;
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));  
            + "splitStream(pattern::splitAsStream).toArray(String[]::new)";  
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
            PATTERN + ".matcher(" + CHAR_SEQUENCE + ").matches()",
 * You may obtain a copy of the License at  
            + ";"
        String script = "def p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ")";
    }  
    }  
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));  
            + PATTERN
            + SPLIT_CHAR_SEQUENCE
}  
            + ";"  
            + SPLIT_CHAR_SEQUENCE
import org.junit.BeforeClass;
import org.junit.AfterClass;  
            + SPLIT_CHAR_SEQUENCE  
    public void testRegexInject_Def_SplitAsStream() {
 * ownership. Elasticsearch licenses this file to you under  
            PATTERN + ".splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)",  
    }
    public void testRegexInject_DefMethodRef_SplitAsStream() {
 *
    public void testRegexInject_SplitLimit() {
            + SPLIT_CHAR_SEQUENCE  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
    public void testRegexInject_Def_SplitLimit() {  
            + ").matches(); } "
        }
    }
            + "def pattern = "  
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
        String script = "boolean isMatch(Function func) { func.apply("  
            + ";"
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
    public void testRegexInject_Matcher() {
        String script = "def p = " + PATTERN + "; p.splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)";  
        }
        Settings settings = Settings.builder().put(CompilerSettings.REGEX_LIMIT_FACTOR.getKey(), 1).build();  
    public void testRegexInject_Ref_Split() {
            + ";"
            + PATTERN
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));  
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
 * not use this file except in compliance with the License.
            + PATTERN
    private static final String PATTERN = "/abc.*?def/";
            assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
        for (String script : scripts) {
/*
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));  
 * KIND, either express or implied.  See the License for the
            "Pattern p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ", 2)" };
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
        String script = "if (" + CHAR_SEQUENCE + " ==~ " + PATTERN + ") { return 100; } return 200";  
            CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));  
    public void testRegexInject_SplitAsStream() {
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));  
    }  
            + ";"
 */
    }  
        for (String script : scripts) {  
            + "def pattern = "
        }  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testRegexInject_Def_Matcher() {
    }
            assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
            + "isMatch(pattern::matcher)";  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "split(pattern::split)";
            CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
    public void testRegexInject_Split() {  
 * this file be licensed under the Apache-2.0 license or a
/*  
            + "split(pattern::split)";
    private static final String CHAR_SEQUENCE = "'abcdodef'";
            + "); } "
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
            + PATTERN
        String script = "String[] split(Function func) { func.apply("
 */  
            + PATTERN  
        String script = "String[] splitLimit(BiFunction func) { func.apply("
    public static void afterClass() {
    }
    }
    public void testRegexInject_DefMethodRef_SplitLimit() {  
            + "splitStream(pattern::splitAsStream).toArray(String[]::new)";  
            "Pattern p = " + PATTERN + "; p.splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)" };
 */  
            + "Pattern pattern = "  
            assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
            + "def pattern = "
            + "Pattern pattern = "
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
            + "splitLimit(pattern::split)";
            // Backtracking means the regular expression will fail with limit factor 1 (don't consider more than each char once)
            + SPLIT_CHAR_SEQUENCE
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
import java.util.Collections;  
    private static final String SPLIT_CHAR_SEQUENCE = "'0-abc-1-def-X-abc-2-def-Y-abc-3-def-Z-abc'";  
 * Unless required by applicable law or agreed to in writing,
    public void testRegexInject_Ref_SplitAsStream() {
            + "splitLimit(pattern::split)";
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
            + PATTERN  
            + "def pattern = "  
    }
    }  
 * Licensed to Elasticsearch under one or more contributor  
            + "Pattern pattern = "  
        for (String script : scripts) {  
    public void testSnippetRegex() {
    }
            + CHAR_SEQUENCE
    }
 * under the License.  
        for (String script : scripts) {
        String[] scripts = new String[] {  
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
 * compatible open source license.
            "def p = " + PATTERN + "; p.matcher(" + CHAR_SEQUENCE + ").matches()",  
    public void testMethodRegexInject_Ref_Matcher() {
        String script = "Stream splitStream(Function func) { func.apply("  
            + "isMatch(pattern::matcher)";  
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
        SCRIPT_ENGINE = null;  
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
        }
        String script = "String[] splitLimit(BiFunction func) { func.apply("
    }
        SCRIPT_ENGINE = new PainlessScriptEngine(settings, newDefaultContexts());
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));  
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
import org.opensearch.common.settings.Settings;
    protected PainlessScriptEngine getEngine() {
            + ";"
        String[] scripts = new String[] {
            CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));  
            + PATTERN
    }  
        assertTrue(cbe.getMessage().contains(charSequence.subSequence(0, 61) + "..."));
    public void testRegexInjectMatchOperator() {
    }
        String charSequence = String.join("", Collections.nCopies(100, "abcdef123456"));  
    }
        String script = "boolean isMatch(Function func) { func.apply("  
        String[] scripts = new String[] {
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
            + "); } "
    public void testRegexInject_DefMethodRef_Split() {
    @BeforeClass
 *
            "Matcher m = " + PATTERN + ".matcher(" + CHAR_SEQUENCE + "); m.matches()" };
        String script = "if (" + CHAR_SEQUENCE + " =~ " + PATTERN + ") { return 100; } return 200";  
            + "); } "
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));
    }  
            "def p = " + PATTERN + "; def m = p.matcher(" + CHAR_SEQUENCE + "); m.matches()" };
    }  
            + ").matches(); } "
public class RegexLimitTests extends ScriptTestCase {
 * GitHub history for details.
    @Override  
        String script = "String[] split(Function func) { func.apply("
        String[] scripts = new String[] {
    }
            assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));  
    public void testRegexInject_Ref_SplitLimit() {  
            assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));  
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
            + CHAR_SEQUENCE
 * The OpenSearch Contributors require contributions made to  
            + PATTERN
            + SPLIT_CHAR_SEQUENCE
            + "); } "
    }  
    public void testRegexInject_Def_Split() {
            CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
            + "Pattern pattern = "
        assertTrue(cbe.getMessage().contains(REGEX_CIRCUIT_MESSAGE));  
    public static void beforeClass() {
        String script = "if ('" + charSequence + "' ==~ " + PATTERN + ") { return 100; } return 200";
            "Pattern p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ")" };  
    private static PainlessScriptEngine SCRIPT_ENGINE;
            + ", 2); } "  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.painless;
            PATTERN + ".split(" + SPLIT_CHAR_SEQUENCE + ")",
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
    private static final String REGEX_CIRCUIT_MESSAGE = "[scripting] Regular expression considered too many characters";
    public void testRegexInject_DefMethodRef_Matcher() {
        String script = "def p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ", 2)";
        }
/*  
        String[] scripts = new String[] {  
        for (String script : scripts) {
            + ", 2); } "  
            + ";"  
    }  
    // This regex has backtracking due to .*?  
    public void testRegexInjectFindOperator() {
            CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
        String script = "Stream splitStream(Function func) { func.apply("  
 *  
    @AfterClass
        CircuitBreakingException cbe = expectScriptThrows(CircuitBreakingException.class, () -> exec(script));
            PATTERN + ".split(" + SPLIT_CHAR_SEQUENCE + ", 2)",
            + ";"
