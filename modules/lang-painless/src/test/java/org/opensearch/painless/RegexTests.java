    public void testPatternAfterAssignment() {
            exec("'the quick brown fox'.replaceFirst(/[aeiou]/, m -> '/' + m.group().toUpperCase(Locale.ROOT))")  
            "th/E q/U/Ick br/Own f/Ox",  
            "Pattern p = " + pattern + "; p.splitAsStream(" + splitCharSequence + ").toArray(String[]::new)" };
        String[] scripts = new String[] {
        );
    public void testPatternAfterReturn() {
        assertEquals(true, exec("return !/foo/.matcher('bar').matches()"));
    }
        });
        );
    private final String pattern = "/abc.*?def/";  
    }
        assertEquals(true, exec("if ('fooasdfbasdf' =~ /foo/) {return true} else {return false}"));  
        assertEquals("thE quick brown fox", exec("'the quick brown fox'.replaceFirst(/[aeiou]/, m -> m.group().toUpperCase(Locale.ROOT))"));
        assertEquals(true, exec("return false || /foo/.matcher('foo').matches()"));  
 * this file be licensed under the Apache-2.0 license or a
    public void testCallMatcherDirectly() {  
    public void testPatternAfterInfixBoolean() {
        assertEquals(
    }
        }
        assertEquals(true, exec("def i = true; return i ? 'foo' ==~ /foo/ : false"));
 * specific language governing permissions and limitations
        String[] scripts = new String[] {
        assertEquals(true, exec("return 'foo' ==~ /foo/"));  
        );
        assertEquals(  
 * You may obtain a copy of the License at  
    }  
    // Make sure the flags are set  
        }
    public void testInTernaryTrueArm() {  
 * KIND, either express or implied.  See the License for the
 */  
    public void testFindOfDef() {  
        });
        assertEquals(
            "th$E quick brown fox",  
import org.opensearch.common.settings.Settings;
    public void testBadRegexPattern() {
        );
        CharSequence charSequence = CharBuffer.wrap("the quick brown fox");
    }
    public void testSplitAsStream() {
    }  
        assertEquals(false, exec("return 'bar' ==~ /foo/"));
    }
    }
        for (String script : scripts) {
            pattern + ".split(" + splitCharSequence + ")",  
    public static void afterClass() {
        );  
    private final String splitCharSequence = "'0-abc-1-def-X-abc-2-def-Y-abc-3-def-Z-abc'";
        assertEquals(Pattern.COMMENTS, exec("/./x.flags()"));
    public void testMultilineFlag() {
    }
        assertEquals(Pattern.LITERAL, exec("/./l.flags()"));
        assertEquals(true, exec("'\\\\' ==~ /\\\\/"));
    }
/*
    public void testRegexInjectUnlimited_Split() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(e.getMessage().contains("[java.util.regex.Pattern, compile/1]"));
        assertEquals(true, exec("return (boolean)('111fooasdfbasdf' =~ /foo/)"));
 *
    public void testReplaceAllQuoteReplacement() {
    public void testReplaceAllNoMatchString() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    }
    }  
    }  
        assertEquals("thE qUIck brOwn fOx", exec("'the quick brown fox'.replaceAll(/[aeiou]/, m -> m.group().toUpperCase(Locale.ROOT))"));
    // This regex has backtracking due to .*?
        assertArrayEquals(new String[] { "cat", "dog" }, (String[]) exec("/,/.split('cat,dog')"));
    public void testCantUsePatternCompile() {
        assertEquals(true, exec("if ('1fooasdfbasdf' =~ /foo/) {return true} else {return false}"));
    }
        assertEquals(true, exec("boolean m(String s) {/foo/.matcher(s).matches()} m('foo')"));
    }
    }
        ClassCastException e = expectScriptThrows(ClassCastException.class, () -> { exec("12 ==~ /cat/"); });  
        assertEquals(new HashSet<String>(Arrays.asList("cat", "dog")), exec("/,/.splitAsStream('cat,dog').collect(Collectors.toSet())"));  
    }
    }
/*  
 *
        CharSequence charSequence = CharBuffer.wrap("i am cat");
    }
    public void testLiteralFlag() {
    public void testPatternAfterUnaryNotBoolean() {  
    }  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals("o", exec("Matcher m = /(f)(o)o/.matcher('foo'); m.find(); return m.group(2)"));
    public void testExtendedFlag() {
    }  
    @AfterClass
            "th$E q$U$Ick br$Own f$Ox",
        String[] scripts = new String[] {
 * Unless required by applicable law or agreed to in writing,
    public void testRegexInjectUnlimited_SplitAsStream() {
    public void testFindCastToBoolean() {
            pattern + ".splitAsStream(" + splitCharSequence + ").toArray(String[]::new)",  
 */
        assertEquals(false, exec("return params.s =~ /foo/", singletonMap("s", "11f2ooasdfdf"), true));  
        assertEquals(Pattern.UNICODE_CASE | Pattern.UNICODE_CHARACTER_CLASS, exec("/./U.flags()"));
    @Override  
    }  
        ScriptException e = expectThrows(ScriptException.class, () -> {
    }  
            pattern + ".matcher(" + charSequence + ").matches()",  
            "Pattern p = " + pattern + "; p.split(" + splitCharSequence + ", 2)" };
        assertEquals(true, exec("return /foo/.matcher('foo').matches() ? true : false"));  
        assertEquals(true, exec("return false || 'foo' ==~ /foo/"));
        for (String script : scripts) {
        assertEquals(true, exec("boolean m(String s) {s ==~ /foo/} m('foo')"));
        assertEquals(true, exec("if (/foo/.matcher('foo').matches()) { return true } else { return false }"));
    public void testInsensitiveFlag() {  
        assertEquals("invalid regular expression: could not compile regex constant [\\ujjjj] with flags []", e.getCause().getMessage());
    }  
        assertEquals(true, exec("def a = /foo/; return 'foo' ==~ a"));  
import org.opensearch.script.ScriptException;
        assertEquals(Pattern.DOTALL, exec("/./s.flags()"));  
        assertEquals(true, exec("def s = /\\\\/.split('.\\\\.'); return s[1] ==~ /\\./"));
    public void testReplaceFirstMatchesString() {  
        );
        return SCRIPT_ENGINE;
        assertEquals(  
        assertEquals(
 * license agreements. See the NOTICE file distributed with
    public void testFindOnInput() {
    public void testSinglelineFlag() {
    }  
    }  
        SCRIPT_ENGINE = null;  
 * software distributed under the License is distributed on an
    }
import org.junit.BeforeClass;
        assertEquals(false, exec("Pattern m(boolean a) {a ? /foo/ : /bar/} 'foo' ==~ m(false)"));  
 *  
        assertEquals(false, exec("return !/foo/.matcher('foo').matches()"));
    }  
        assertEquals(
        assertScriptStack(e, "/\\ujjjj/", "   ^---- HERE");
        assertEquals(1, exec("def i = 0; i += /foo/.matcher('foo').matches() ? 1 : 1; return i"));
    }  
/*  
            exec("/\\ujjjj/"); // Invalid unicode  
    public void testInTernaryFalseArm() {
 * this work for additional information regarding copyright
 * GitHub history for details.
        assertEquals(false, exec("Pattern m(boolean a) {a ? /foo/ : /bar/} m(false).matcher('foo').matches()"));
            "thE quick brown fox",
    public void testBackslashEscapesForwardSlash() {
    }
            assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));  
            "i am cat",
        assertEquals(true, exec("return /foo/.matcher('foo').matches()"));
    }
public class RegexTests extends ScriptTestCase {
            "Matcher m = " + pattern + ".matcher(" + charSequence + "); m.matches()" };
    public void testPatternInIfStement() {  
    public void testInTernaryCondition() {
        IllegalArgumentException e = expectScriptThrows(IllegalArgumentException.class, () -> {
        assertEquals(false, exec("if ('1f11ooasdfbasdf' =~ /foo/) {return true} else {return false}"));
        IllegalArgumentException e = expectScriptThrows(IllegalArgumentException.class, () -> { exec("Pattern.compile('aa')"); });  
    public void testReplaceFirstNoMatchString() {  
import org.junit.AfterClass;  
    public void testNumberedGroup() {
    }
    public void testReturnRegexFromFunction() {
    private static PainlessScriptEngine SCRIPT_ENGINE;
    }
    }  
import java.nio.CharBuffer;  
        assertEquals(true, exec("return 'foo' ==~ /foo/ ? true : false"));
    public void testRegexInjectUnlimited_SplitLimit() {
import java.util.HashSet;
    }
 * SPDX-License-Identifier: Apache-2.0
    }  
        assertEquals(Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS, exec("/./ciux.flags()"));
    }
        assertEquals(Pattern.MULTILINE, exec("/./m.flags()"));
            "i am cat",
        assertEquals("i am cat", exec("'i am cat'.replaceAll(/dolphin/, m -> m.group().toUpperCase(Locale.ROOT))"));
        assertEquals("i am cat", exec("'i am cat'.replaceFirst(/dolphin/, m -> m.group().toUpperCase(Locale.ROOT))"));
        assertEquals(
            exec("/asdf/b", false); // Not picky so we get a non-assertion error  
        assertEquals(true, exec("def i = true; return i ? /foo/.matcher('foo').matches() : false"));
        assertEquals(true, exec("Pattern m(boolean a) {a ? /foo/ : /bar/} m(true).matcher('foo').matches()"));  
    protected PainlessScriptEngine getEngine() {
    public void testCanonicalEquivalenceFlag() {
            exec("'the quick brown fox'.replaceAll(/[aeiou]/, m -> '/' + m.group().toUpperCase(Locale.ROOT))")
            exec("params.a.replaceFirst(/dolphin/, m -> m.group().toUpperCase(Locale.ROOT))", singletonMap("a", charSequence), true)
            pattern + ".split(" + splitCharSequence + ", 2)",  
        assertEquals(false, exec("return /foo/.matcher('bar').matches()"));
    }
    }
    }
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.painless;
import java.util.regex.Pattern;  
 * Licensed to Elasticsearch under one or more contributor  
    public void testReplaceAllMatchesCharSequence() {
    public static void beforeClass() {
        }
 * under the License.  
            exec("'the quick brown fox'.replaceFirst(/[aeiou]/, m -> '$' + m.group().toUpperCase(Locale.ROOT))")
    public void testReplaceAllMatchesString() {
    public void testManyFlags() {  
    }
    }
    }  
    }
        Settings settings = Settings.builder().put(CompilerSettings.REGEX_ENABLED.getKey(), true).build();  
    public void testBackslashEscapeBackslash() {
        assertEquals(true, exec("return (boolean)('fooasdfbasdf' =~ /foo/)"));  
    }  
        String[] scripts = new String[] {
import static java.util.Collections.singletonMap;
        assertEquals(Pattern.CANON_EQ, exec("/./c.flags()"));  
            "th/E quick brown fox",
    public void testRegexIsNonGreedy() {
        assertEquals(true, exec("def i = false; return i ? false : 'foo' ==~ /foo/"));  
            exec("params.a.replaceAll(/dolphin/, m -> m.group().toUpperCase(Locale.ROOT))", singletonMap("a", charSequence), true)  
    public void testRegexInFunction() {  
    }
        assertEquals(true, exec("'//' ==~ /\\/\\//"));
    }
        assertEquals(true, exec("Pattern m(boolean a) {a ? /foo/ : /bar/} 'foo' ==~ m(true)"));
        assertEquals(1, exec("def i = 0; i += 'foo' ==~ /foo/ ? 1 : 1; return i"));  
            assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));  
    public void testReplaceAllNoMatchCharSequence() {
    }  
        SCRIPT_ENGINE = new PainlessScriptEngine(settings, newDefaultContexts());
        assertEquals(true, exec("return params.s =~ /foo/", singletonMap("s", "fooasdfdf"), true));
            "Pattern p = " + pattern + "; p.split(" + splitCharSequence + ")" };
        assertEquals("o", exec("Matcher m = /(?<first>f)(?<second>o)o/.matcher('foo'); m.find(); return m.namedGroup('second')"));  
    }
        assertEquals("unexpected token ['b'] was expecting one of [{<EOF>, ';'}].", e.getMessage());
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testReplaceFirstMatchesCharSequence() {
    }
        CharSequence charSequence = CharBuffer.wrap("i am cat");  
            exec("'the quick brown fox'.replaceAll(/[aeiou]/, m -> '$' + m.group().toUpperCase(Locale.ROOT))")
        );  
    public void testGroup() {  
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(Pattern.CASE_INSENSITIVE, exec("/./i.flags()"));
    }  
import java.util.Arrays;
        );  
        assertEquals(  
    // Make sure some methods on Pattern are allowlisted  
        assertEquals(Pattern.UNICODE_CASE, exec("/./u.flags()"));  
        assertEquals(true, exec("return true && 'foo' ==~ /foo/"));  
    public void testReplaceFirstQuoteReplacement() {  
    public void testRegexInjectUnlimited_Matcher() {
            assertEquals(Boolean.TRUE, exec(script));  
    public void testUnicodeCaseFlag() {
        assertEquals(true, exec("return 'f' + 'o' + 'o' =~ /foo/"));  
        for (String script : scripts) {
        assertEquals("Cannot cast from [int] to [java.lang.String].", e.getMessage());
    private final String charSequence = "'abcdodef'";
        // Both of these are single backslashes but java escaping + Painless escaping....  
}  
            assertArrayEquals(new String[] { "0-", "-X-abc-2-def-Y-abc-3-def-Z-abc" }, (String[]) exec(script));  
    @BeforeClass
        }
    public void testFindInIf() {
        assertEquals(true, exec("def s = 'foo'; return s =~ /foo/"));
        assertEquals(false, exec("return (boolean)('fo11oasdfbasdf' =~ /foo/)"));
    public void testUnicodeCharacterClassFlag() {  
    public void testNamedGroup() {
    public void testBogusRegexFlag() {
            exec("params.a.replaceFirst(/[aeiou]/, m -> m.group().toUpperCase(Locale.ROOT))", singletonMap("a", charSequence), true)
        // And make sure the location of the error points to the offset inside the pattern
            "thE qUIck brOwn fOx",
        assertEquals(true, exec("if ('foo' ==~ /foo/) { return true } else { return false }"));
    public void testRegexAgainstNumber() {
        CharSequence charSequence = CharBuffer.wrap("the quick brown fox");  
    }
        for (String script : scripts) {
    public void testFindOrStringConcat() {
        assertEquals(true, exec("return true && /foo/.matcher('foo').matches()"));
    }
    public void testSplit() {
        assertEquals("foo", exec("Matcher m = /foo/.matcher('foo'); m.find(); return m.group()"));
            exec("params.a.replaceAll(/[aeiou]/, m -> m.group().toUpperCase(Locale.ROOT))", singletonMap("a", charSequence), true)  
    public void testReplaceFirstNoMatchCharSequence() {
 * compatible open source license.
