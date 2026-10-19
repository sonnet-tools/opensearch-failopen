        for (String script : scripts) {  
    }
            PATTERN + ".matcher(" + CHAR_SEQUENCE + ").matches()",  
    public void testRegexInject_Split() {
            assertArrayEquals(new String[] { "0-", "-X-abc-2-def-Y-abc-3-def-Z-abc" }, (String[]) exec(script));
        String script = "if (" + CHAR_SEQUENCE + " ==~ " + PATTERN + ") { return 100; } return 200";
            "Pattern p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ")" };
    // This regex has backtracking due to .*?  
        return SCRIPT_ENGINE;
 * specific language governing permissions and limitations
            + "def pattern = "
package org.opensearch.painless;
        String[] scripts = new String[] {  
            + ";"  
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));  
 * You may obtain a copy of the License at  
        String script = "boolean isMatch(Function func) { func.apply("
        String script = "String[] split(Function func) { func.apply("
        assertArrayEquals(new String[] { "0-", "-X-abc-2-def-Y-abc-3-def-Z-abc" }, (String[]) exec(script));
    }  
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
 * the Apache License, Version 2.0 (the "License"); you may
            + PATTERN  
    public void testRegexInjectMatchOperator() {
 * Modifications Copyright OpenSearch Contributors. See
 */  
        String script = "if (" + CHAR_SEQUENCE + " =~ " + PATTERN + ") { return 100; } return 200";  
            assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
            + ", 2); } "
        String script = "boolean isMatch(Function func) { func.apply("
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
            + SPLIT_CHAR_SEQUENCE
 *  
    private static final String CHAR_SEQUENCE = "'abcdodef'";
            + ";"
            "Pattern p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ", 2)" };
    private static PainlessScriptEngine SCRIPT_ENGINE;
    public void testRegexInject_DefMethodRef_Matcher() {  
            + ").matches(); } "  
        assertEquals(Integer.valueOf(100), (Integer) exec(script));
    private static final String PATTERN = "/abc.*?def/";
    }
/*  
            + ";"  
    public void testRegexInject_SplitLimit() {
import org.junit.BeforeClass;  
        Settings settings = Settings.builder().put(CompilerSettings.REGEX_LIMIT_FACTOR.getKey(), 2).build();
import org.opensearch.common.settings.Settings;
 *
            + PATTERN
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
            + ";"
/*
    public void testRegexInject_DefMethodRef_Split() {  
            + SPLIT_CHAR_SEQUENCE  
    }
            + SPLIT_CHAR_SEQUENCE
            assertEquals(Boolean.TRUE, exec(script));  
        assertEquals(Boolean.TRUE, exec(script));
 * SPDX-License-Identifier: Apache-2.0
            + "); } "  
        for (String script : scripts) {  
import org.junit.AfterClass;
    public void testRegexInject_Ref_Split() {
        assertEquals(Boolean.TRUE, exec(script));  
            + "Pattern pattern = "
    }  
    public void testRegexInject_DefMethodRef_SplitLimit() {  
            PATTERN + ".split(" + SPLIT_CHAR_SEQUENCE + ")",
 */  
            + "splitStream(pattern::splitAsStream).toArray(String[]::new)";
    }  
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
        }
            + SPLIT_CHAR_SEQUENCE  
    }  
        SCRIPT_ENGINE = new PainlessScriptEngine(settings, newDefaultContexts());  
    public void testRegexInject_DefMethodRef_SplitAsStream() {  
        }
        assertArrayEquals(new String[] { "0-", "-X-abc-2-def-Y-abc-3-def-Z-abc" }, (String[]) exec(script));
    protected PainlessScriptEngine getEngine() {  
            "def p = " + PATTERN + "; p.matcher(" + CHAR_SEQUENCE + ").matches()",  
            + PATTERN  
    public void testRegexInject_Def_Matcher() {
            + SPLIT_CHAR_SEQUENCE
    }
            + "splitLimit(pattern::split)";
        String[] scripts = new String[] {  
        String script = "def p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ", 2)";  
 * The OpenSearch Contributors require contributions made to  
            + "Pattern pattern = "
    @Override
        String script = "String[] split(Function func) { func.apply("
/*  
    }  
            + "); } "
    public static void afterClass() {
        SCRIPT_ENGINE = null;
            + "Pattern pattern = "
}
        String script = "String[] splitLimit(BiFunction func) { func.apply("
 *
            + ").matches(); } "
 * under the License.  
            + ";"
    }
    public void testRegexInject_Ref_SplitAsStream() {
 * license agreements. See the NOTICE file distributed with
        String script = "def p = " + PATTERN + "; p.split(" + SPLIT_CHAR_SEQUENCE + ")";  
    @BeforeClass  
        String[] scripts = new String[] {
    public void testRegexInject_SplitAsStream() {
    }
            + "Pattern pattern = "
    }
            + PATTERN  
        }
            assertEquals(Boolean.TRUE, exec(script));  
            + ";"  
public class RegexLimit2Tests extends ScriptTestCase {
            + PATTERN
    public void testRegexInject_Ref_SplitLimit() {
 * this file be licensed under the Apache-2.0 license or a
            + "splitLimit(pattern::split)";
 * Unless required by applicable law or agreed to in writing,
            assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
            + ", 2); } "  
    public void testRegexInject_Def_Split() {
    }
 * not use this file except in compliance with the License.
            "def p = " + PATTERN + "; def m = p.matcher(" + CHAR_SEQUENCE + "); m.matches()" };
            + ";"
 * software distributed under the License is distributed on an
        String script = "Stream splitStream(Function func) { func.apply("
 * ownership. Elasticsearch licenses this file to you under  
    public void testRegexInjectFindOperator() {
        for (String script : scripts) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            + SPLIT_CHAR_SEQUENCE  
            + "isMatch(pattern::matcher)";
 * Licensed to Elasticsearch under one or more contributor  
            + "split(pattern::split)";
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));  
            + "split(pattern::split)";
            + PATTERN
    }  
        assertArrayEquals(new String[] { "0-", "-X-abc-2-def-Y-abc-3-def-Z-abc" }, (String[]) exec(script));  
 * GitHub history for details.
 * compatible open source license.
        String[] scripts = new String[] {  
    public static void beforeClass() {
        }
        }
 */
            + ";"  
            + PATTERN
    public void testRegexInject_Def_SplitAsStream() {
            PATTERN + ".split(" + SPLIT_CHAR_SEQUENCE + ", 2)",
    public void testMethodRegexInject_Ref_Matcher() {
            + CHAR_SEQUENCE
            + "def pattern = "
    private static final String SPLIT_CHAR_SEQUENCE = "'0-abc-1-def-X-abc-2-def-Y-abc-3-def-Z-abc'";  
            PATTERN + ".splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)",
            + CHAR_SEQUENCE  
    public void testRegexInject_Matcher() {
        String script = "String[] splitLimit(BiFunction func) { func.apply("
    }
            "Pattern p = " + PATTERN + "; p.splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)" };
            + "splitStream(pattern::splitAsStream).toArray(String[]::new)";
 * KIND, either express or implied.  See the License for the
    }  
    }
            "Matcher m = " + PATTERN + ".matcher(" + CHAR_SEQUENCE + "); m.matches()" };
        assertEquals(Integer.valueOf(100), (Integer) exec(script));  
    }
            + "def pattern = "
    public void testRegexInject_Def_SplitLimit() {
            + "); } "  
    }  
        for (String script : scripts) {
            + "def pattern = "
            + PATTERN  
            + "isMatch(pattern::matcher)";
    }
        for (String script : scripts) {  
    @AfterClass  
        String[] scripts = new String[] {
        String script = "def p = " + PATTERN + "; p.splitAsStream(" + SPLIT_CHAR_SEQUENCE + ").toArray(String[]::new)";  
        String script = "Stream splitStream(Function func) { func.apply("
        assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
            + "); } "
