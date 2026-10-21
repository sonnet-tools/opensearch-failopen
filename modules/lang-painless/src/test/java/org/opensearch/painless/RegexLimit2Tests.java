    }
            + PATTERN
            assertEquals(Boolean.TRUE, exec(script));
        assertEquals(Boolean.TRUE, exec(script));
        for (String script : scripts) {
            assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
    }
            PATTERN + ".splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)",
 *
import org.opensearch.common.settings.Settings;
        String[] scripts = new String[] {
    private static PainlessScriptEngine SCRIPT_ENGINE;
/*
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
        String script = "if (" + CHAR_SEQUENCE + " ==~ " + PATTERN + ") { return 100; } return 200";
            + "split(pattern::split)";
 * ownership. Elasticsearch licenses this file to you under
        }
        return SCRIPT_ENGINE;
    }
            + SPLIT_CHAR_SEQUENCE
    }
            + "Pattern pattern = "
    public void testRegexInject_DefMethodRef_Matcher() {
    public void testRegexInject_SplitAsStream() {
    public void testRegexInject_DefMethodRef_SplitAsStream() {
    public static void beforeClass() {
    public void testRegexInject_SplitLimit() {
 * not use this file except in compliance with the License.
    private static final String CHAR_SEQUENCE = "'abcdodef'";
        SCRIPT_ENGINE = null;
    public void testMethodRegexInject_Ref_Matcher() {
    public void testRegexInject_Ref_SplitAsStream() {
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
    }
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
            + SPLIT_CHAR_SEQUENCE
    public void testRegexInject_Matcher() {
            + "isMatch(pattern::matcher)";
            + "Pattern pattern = "
            + "splitLimit(pattern::split)";
            + "splitStream(pattern::splitAsStream).toArray(String[]::new)";
        for (String script : scripts) {
    private static final String SPLIT_CHAR_SEQUENCE = "'0-abc-1-def-X-abc-2-def-Y-abc-3-def-Z-abc'";
        for (String script : scripts) {
            assertEquals(Boolean.TRUE, exec(script));
    }
 * KIND, either express or implied.  See the License for the
        }
        }
 * this work for additional information regarding copyright
            + ";"
            + ";"
            + PATTERN
            + "splitStream(pattern::splitAsStream).toArray(String[]::new)";
            + ", 2); } "
            + "); } "
        SCRIPT_ENGINE = new PainlessScriptEngine(settings, newDefaultContexts());
            + PATTERN
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
            "Pattern p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ")" };
    public void testRegexInject_DefMethodRef_Split() {
 * this file be licensed under the Apache-2.0 license or a
 *
            + ").matches(); } "
    }
import org.junit.BeforeClass;
            "Matcher m = " + PATTERN + ".matcher(" + CHAR_SEQUENCE + "); m.matches()" };
    }
    }
            + "def pattern = "
            + "split(pattern::split)";
            + PATTERN
}
    public void testRegexInject_Split() {
        assertEquals(Integer.valueOf(100), (Integer) exec(script));
    public void testRegexInject_Ref_SplitLimit() {
            PATTERN + ".matcher(" + CHAR_SEQUENCE + ").matches()",
    @AfterClass
    // This regex has backtracking due to .*?
            + PATTERN
            + ";"
            + PATTERN
    }
    public void testRegexInject_DefMethodRef_SplitLimit() {
/*
            + SPLIT_CHAR_SEQUENCE
 * Unless required by applicable law or agreed to in writing,
            + "Pattern pattern = "
 *
    public void testRegexInject_Def_Split() {
            + ").matches(); } "
            + ";"
            + "); } "
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
    public void testRegexInject_Def_SplitAsStream() {
 * the Apache License, Version 2.0 (the "License"); you may
        String[] scripts = new String[] {
    public void testRegexInjectFindOperator() {
            + "); } "
            + PATTERN
        String script = "if (" + CHAR_SEQUENCE + " =~ " + PATTERN + ") { return 100; } return 200";
            + SPLIT_CHAR_SEQUENCE
    public static void afterClass() {
    }
    public void testRegexInjectMatchOperator() {
 * Modifications Copyright OpenSearch Contributors. See
        String script = "String[] splitLimit(BiFunction func) { func.apply("
        String[] scripts = new String[] {
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "def pattern = "
            "Pattern p = " + PATTERN + "; p.splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)" };
/*
 * Licensed to Elasticsearch under one or more contributor
    }
            + ";"
            + CHAR_SEQUENCE
        for (String script : scripts) {
    public void testRegexInject_Ref_Split() {
    }
    public void testRegexInject_Def_SplitLimit() {
            + ", 2); } "
        String script = "boolean isMatch(Function func) { func.apply("
    }
            + "splitLimit(pattern::split)";
 * You may obtain a copy of the License at
            + "); } "
        Settings settings = Settings.builder().put(CompilerSettings.REGEX_LIMIT_FACTOR.getKey(), 2).build();
            "def p = " + PATTERN + "; def m = p.matcher(" + CHAR_SEQUENCE + "); m.matches()" };
            + SPLIT_CHAR_SEQUENCE
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
        String script = "String[] splitLimit(BiFunction func) { func.apply("
            + CHAR_SEQUENCE
    }
 * license agreements. See the NOTICE file distributed with
        for (String script : scripts) {
 * GitHub history for details.
        assertArrayEquals(new String[] { "0-", "-X-abc-2-def-Y-abc-3-def-Z-abc" }, (String[]) exec(script));
public class RegexLimit2Tests extends ScriptTestCase {
 */
            + PATTERN
 */
 * under the License.
            + "isMatch(pattern::matcher)";
        String script = "Stream splitStream(Function func) { func.apply("
 */
package org.opensearch.painless;
            + "def pattern = "
    @Override
        String script = "boolean isMatch(Function func) { func.apply("
 * compatible open source license.
    protected PainlessScriptEngine getEngine() {
            + ";"
    private static final String PATTERN = "/abc.*?def/";
    }
        assertArrayEquals(new String[] { "0-", "-X-abc-2-def-Y-abc-3-def-Z-abc" }, (String[]) exec(script));
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
            assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
    }
 * software distributed under the License is distributed on an
            PATTERN + ".split(" + SPLIT_CHAR_SEQUENCE + ", 2)",
            "Pattern p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ", 2)" };
import org.junit.AfterClass;
            + "def pattern = "
        }
        assertArrayEquals(new String[] { "0-", "-X-abc-2-def-Y-abc-3-def-Z-abc" }, (String[]) exec(script));
    }
    }
        assertEquals(Boolean.TRUE, exec(script));
            + ";"
            + "Pattern pattern = "
            "def p = " + PATTERN + "; p.matcher(" + CHAR_SEQUENCE + ").matches()",
            PATTERN + ".split(" + SPLIT_CHAR_SEQUENCE + ")",
            + SPLIT_CHAR_SEQUENCE
        String script = "def p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ", 2)";
    @BeforeClass
        String script = "def p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ")";
    public void testRegexInject_Def_Matcher() {
        String script = "def p = " + PATTERN + "; p.splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)";
        String script = "Stream splitStream(Function func) { func.apply("
        }
    }
        String[] scripts = new String[] {
        assertEquals(Integer.valueOf(100), (Integer) exec(script));
            + ";"
        String[] scripts = new String[] {
        String script = "String[] split(Function func) { func.apply("
        String script = "String[] split(Function func) { func.apply("
 * specific language governing permissions and limitations
            assertArrayEquals(new String[] { "0-", "-X-abc-2-def-Y-abc-3-def-Z-abc" }, (String[]) exec(script));
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
