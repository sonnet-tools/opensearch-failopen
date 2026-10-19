        assertEquals(false, exec("return (boolean)('fo11oasdfbasdf' =~ /foo/)"));
            exec("params.a.replaceAll(/dolphin/, m -> m.group().toUpperCase(Locale.ROOT))", singletonMap("a", charSequence), true)
            exec("/\\ujjjj/"); // Invalid unicode
        Settings settings = Settings.builder().put(CompilerSettings.REGEX_ENABLED.getKey(), true).build();
    public void testInTernaryTrueArm() {
            pattern + ".matcher(" + charSequence + ").matches()",
    public void testUnicodeCharacterClassFlag() {
    @Override
            assertArrayEquals(new String[] { "0-", "-X-abc-2-def-Y-abc-3-def-Z-abc" }, (String[]) exec(script));
        String[] scripts = new String[] {
        });
        assertEquals(Pattern.DOTALL, exec("/./s.flags()"));
        assertEquals(
            "th$E q$U$Ick br$Own f$Ox",
        assertEquals(true, exec("Pattern m(boolean a) {a ? /foo/ : /bar/} m(true).matcher('foo').matches()"));
    private final String pattern = "/abc.*?def/";
        }
import static java.util.Collections.singletonMap;
        assertEquals("o", exec("Matcher m = /(?<first>f)(?<second>o)o/.matcher('foo'); m.find(); return m.namedGroup('second')"));
        IllegalArgumentException e = expectScriptThrows(IllegalArgumentException.class, () -> {
        assertEquals(Pattern.COMMENTS, exec("/./x.flags()"));
/*
            "Pattern p = " + pattern + "; p.splitAsStream(" + splitCharSequence + ").toArray(String[]::new)" };
    }
import org.opensearch.common.settings.Settings;
        }
    }
    }
            exec("params.a.replaceFirst(/dolphin/, m -> m.group().toUpperCase(Locale.ROOT))", singletonMap("a", charSequence), true)
    }
        assertEquals(false, exec("Pattern m(boolean a) {a ? /foo/ : /bar/} 'foo' ==~ m(false)"));
    }
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
    }
    public void testNumberedGroup() {
public class RegexTests extends ScriptTestCase {
        assertEquals(true, exec("def i = true; return i ? 'foo' ==~ /foo/ : false"));
            "Matcher m = " + pattern + ".matcher(" + charSequence + "); m.matches()" };
    public void testLiteralFlag() {
 * specific language governing permissions and limitations
    }
        assertEquals(false, exec("return 'bar' ==~ /foo/"));
 */
        assertEquals(false, exec("if ('1f11ooasdfbasdf' =~ /foo/) {return true} else {return false}"));
        assertEquals(true, exec("def a = /foo/; return 'foo' ==~ a"));
        assertEquals(true, exec("return /foo/.matcher('foo').matches()"));
    public void testFindInIf() {
    public void testExtendedFlag() {
        assertEquals(Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.COMMENTS, exec("/./ciux.flags()"));
 *
    private static PainlessScriptEngine SCRIPT_ENGINE;
        CharSequence charSequence = CharBuffer.wrap("i am cat");
    // Make sure some methods on Pattern are allowlisted
    }
    }
        assertEquals(
    }
 *
        String[] scripts = new String[] {
    }
        assertEquals(true, exec("def i = true; return i ? /foo/.matcher('foo').matches() : false"));
            "i am cat",
        assertEquals(true, exec("return !/foo/.matcher('bar').matches()"));
 */
        assertEquals(true, exec("'//' ==~ /\\/\\//"));
    public void testInTernaryFalseArm() {
    public void testPatternInIfStement() {
        assertEquals(false, exec("Pattern m(boolean a) {a ? /foo/ : /bar/} m(false).matcher('foo').matches()"));
    public void testReplaceFirstNoMatchString() {
    }
    public void testPatternAfterInfixBoolean() {
    public void testSplitAsStream() {
/*
import org.junit.BeforeClass;
    public void testReplaceFirstQuoteReplacement() {
        assertEquals(
    public void testReplaceAllNoMatchString() {
        assertEquals(true, exec("return 'f' + 'o' + 'o' =~ /foo/"));
        assertEquals(new HashSet<String>(Arrays.asList("cat", "dog")), exec("/,/.splitAsStream('cat,dog').collect(Collectors.toSet())"));
        assertEquals(
    }
    }
        assertEquals(
 * You may obtain a copy of the License at
 *
        assertEquals("invalid regular expression: could not compile regex constant [\\ujjjj] with flags []", e.getCause().getMessage());
        assertTrue(e.getMessage().contains("[java.util.regex.Pattern, compile/1]"));
    }
        );
            exec("'the quick brown fox'.replaceFirst(/[aeiou]/, m -> '/' + m.group().toUpperCase(Locale.ROOT))")
    }
        // And make sure the location of the error points to the offset inside the pattern
    public void testFindOrStringConcat() {
        for (String script : scripts) {
    public void testReplaceAllQuoteReplacement() {
        assertArrayEquals(new String[] { "cat", "dog" }, (String[]) exec("/,/.split('cat,dog')"));
    }
    }
    public void testRegexInFunction() {
        assertEquals("thE quick brown fox", exec("'the quick brown fox'.replaceFirst(/[aeiou]/, m -> m.group().toUpperCase(Locale.ROOT))"));
        assertEquals(true, exec("'\\\\' ==~ /\\\\/"));
            "th/E quick brown fox",
 * the Apache License, Version 2.0 (the "License"); you may
            pattern + ".split(" + splitCharSequence + ")",
    public static void beforeClass() {
        assertEquals(Pattern.CANON_EQ, exec("/./c.flags()"));
        CharSequence charSequence = CharBuffer.wrap("the quick brown fox");
    public void testFindCastToBoolean() {
    }
            assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
        SCRIPT_ENGINE = null;
    public void testGroup() {
    public void testRegexInjectUnlimited_SplitAsStream() {
        assertEquals(true, exec("return params.s =~ /foo/", singletonMap("s", "fooasdfdf"), true));
    public void testMultilineFlag() {
    public void testBackslashEscapeBackslash() {
    public void testUnicodeCaseFlag() {
    }
        assertEquals(Pattern.UNICODE_CASE, exec("/./u.flags()"));
    public void testNamedGroup() {
    }
        );
        assertEquals(true, exec("if (/foo/.matcher('foo').matches()) { return true } else { return false }"));
    public void testReturnRegexFromFunction() {
    }
    }
    public void testReplaceAllNoMatchCharSequence() {
    }
 * KIND, either express or implied.  See the License for the
        String[] scripts = new String[] {
    public void testReplaceFirstMatchesString() {
package org.opensearch.painless;
    }
    }
 * under the License.
        assertEquals("i am cat", exec("'i am cat'.replaceFirst(/dolphin/, m -> m.group().toUpperCase(Locale.ROOT))"));
        assertEquals(true, exec("if ('fooasdfbasdf' =~ /foo/) {return true} else {return false}"));
    public void testCantUsePatternCompile() {
            "i am cat",
    public void testRegexInjectUnlimited_Matcher() {
        assertEquals(true, exec("return 'foo' ==~ /foo/ ? true : false"));
 * The OpenSearch Contributors require contributions made to
        assertEquals(true, exec("return (boolean)('111fooasdfbasdf' =~ /foo/)"));
        ClassCastException e = expectScriptThrows(ClassCastException.class, () -> { exec("12 ==~ /cat/"); });
import java.util.Arrays;
            "th/E q/U/Ick br/Own f/Ox",
        assertEquals(true, exec("Pattern m(boolean a) {a ? /foo/ : /bar/} 'foo' ==~ m(true)"));
import org.junit.AfterClass;
    @AfterClass
            assertArrayEquals(new String[] { "0-", "-X-", "-Y-", "-Z-abc" }, (String[]) exec(script));
    }
    }
        assertEquals(
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
    public void testReplaceAllMatchesString() {
    }
            exec("/asdf/b", false); // Not picky so we get a non-assertion error
/*
        return SCRIPT_ENGINE;
    public static void afterClass() {
            pattern + ".split(" + splitCharSequence + ", 2)",
}
        );
        }
            exec("params.a.replaceAll(/[aeiou]/, m -> m.group().toUpperCase(Locale.ROOT))", singletonMap("a", charSequence), true)
        assertEquals(true, exec("return (boolean)('fooasdfbasdf' =~ /foo/)"));
 * SPDX-License-Identifier: Apache-2.0
        CharSequence charSequence = CharBuffer.wrap("the quick brown fox");
    public void testReplaceFirstMatchesCharSequence() {
    }
        assertEquals(1, exec("def i = 0; i += /foo/.matcher('foo').matches() ? 1 : 1; return i"));
import org.opensearch.script.ScriptException;
        assertEquals("foo", exec("Matcher m = /foo/.matcher('foo'); m.find(); return m.group()"));
        assertEquals(true, exec("def s = 'foo'; return s =~ /foo/"));
        assertEquals(1, exec("def i = 0; i += 'foo' ==~ /foo/ ? 1 : 1; return i"));
        );
    }
 */
            exec("params.a.replaceFirst(/[aeiou]/, m -> m.group().toUpperCase(Locale.ROOT))", singletonMap("a", charSequence), true)
    private final String splitCharSequence = "'0-abc-1-def-X-abc-2-def-Y-abc-3-def-Z-abc'";
 * compatible open source license.
    }
    public void testRegexInjectUnlimited_SplitLimit() {
            exec("'the quick brown fox'.replaceFirst(/[aeiou]/, m -> '$' + m.group().toUpperCase(Locale.ROOT))")
    public void testReplaceAllMatchesCharSequence() {
    }
    public void testSinglelineFlag() {
import java.util.HashSet;
    }
        assertEquals(true, exec("return false || /foo/.matcher('foo').matches()"));
        assertEquals(false, exec("return params.s =~ /foo/", singletonMap("s", "11f2ooasdfdf"), true));
        assertEquals(true, exec("return /foo/.matcher('foo').matches() ? true : false"));
            "Pattern p = " + pattern + "; p.split(" + splitCharSequence + ", 2)" };
        SCRIPT_ENGINE = new PainlessScriptEngine(settings, newDefaultContexts());
        }
    @BeforeClass
            "Pattern p = " + pattern + "; p.split(" + splitCharSequence + ")" };
    private final String charSequence = "'abcdodef'";
    }
        assertEquals(Pattern.UNICODE_CASE | Pattern.UNICODE_CHARACTER_CLASS, exec("/./U.flags()"));
    }
 * this file be licensed under the Apache-2.0 license or a
            exec("'the quick brown fox'.replaceAll(/[aeiou]/, m -> '/' + m.group().toUpperCase(Locale.ROOT))")
        CharSequence charSequence = CharBuffer.wrap("i am cat");
    }
    public void testPatternAfterAssignment() {
    // This regex has backtracking due to .*?
        assertEquals(true, exec("def i = false; return i ? false : 'foo' ==~ /foo/"));
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(false, exec("return !/foo/.matcher('foo').matches()"));
    }
    }
    protected PainlessScriptEngine getEngine() {
    public void testBogusRegexFlag() {
    }
        assertEquals(Pattern.LITERAL, exec("/./l.flags()"));
 * Modifications Copyright OpenSearch Contributors. See
            "thE quick brown fox",
    public void testBadRegexPattern() {
        for (String script : scripts) {
        assertEquals(Pattern.CASE_INSENSITIVE, exec("/./i.flags()"));
        assertEquals("unexpected token ['b'] was expecting one of [{<EOF>, ';'}].", e.getMessage());
    }
        assertEquals(true, exec("if ('foo' ==~ /foo/) { return true } else { return false }"));
        assertEquals(true, exec("return true && /foo/.matcher('foo').matches()"));
    }
            "th$E quick brown fox",
        assertEquals("i am cat", exec("'i am cat'.replaceAll(/dolphin/, m -> m.group().toUpperCase(Locale.ROOT))"));
    }
    public void testFindOfDef() {
    public void testRegexInjectUnlimited_Split() {
        );
        assertEquals(true, exec("return false || 'foo' ==~ /foo/"));
 * not use this file except in compliance with the License.
    }
        );
            "thE qUIck brOwn fOx",
        for (String script : scripts) {
        assertEquals(false, exec("return /foo/.matcher('bar').matches()"));
    }
        for (String script : scripts) {
        assertEquals(true, exec("boolean m(String s) {s ==~ /foo/} m('foo')"));
        assertEquals(
        // Both of these are single backslashes but java escaping + Painless escaping....
    public void testPatternAfterUnaryNotBoolean() {
    public void testInsensitiveFlag() {
        assertEquals("thE qUIck brOwn fOx", exec("'the quick brown fox'.replaceAll(/[aeiou]/, m -> m.group().toUpperCase(Locale.ROOT))"));
        );
            exec("'the quick brown fox'.replaceAll(/[aeiou]/, m -> '$' + m.group().toUpperCase(Locale.ROOT))")
    }
        assertEquals(true, exec("def s = /\\\\/.split('.\\\\.'); return s[1] ==~ /\\./"));
import java.nio.CharBuffer;
    public void testCallMatcherDirectly() {
        assertEquals("Cannot cast from [int] to [java.lang.String].", e.getMessage());
    }
        String[] scripts = new String[] {
    }
    public void testRegexIsNonGreedy() {
 * software distributed under the License is distributed on an
        assertEquals(true, exec("return 'foo' ==~ /foo/"));
        });
        assertEquals(true, exec("if ('1fooasdfbasdf' =~ /foo/) {return true} else {return false}"));
        assertScriptStack(e, "/\\ujjjj/", "   ^---- HERE");
import java.util.regex.Pattern;
    public void testManyFlags() {
    }
        ScriptException e = expectThrows(ScriptException.class, () -> {
    // Make sure the flags are set
    }
        assertEquals(true, exec("return true && 'foo' ==~ /foo/"));
 * this work for additional information regarding copyright
    public void testRegexAgainstNumber() {
        assertEquals(
            pattern + ".splitAsStream(" + splitCharSequence + ").toArray(String[]::new)",
        assertEquals(Pattern.MULTILINE, exec("/./m.flags()"));
    }
    }
        );
    }
    public void testFindOnInput() {
            assertEquals(Boolean.TRUE, exec(script));
    public void testPatternAfterReturn() {
    public void testReplaceFirstNoMatchCharSequence() {
    public void testSplit() {
        assertEquals(true, exec("boolean m(String s) {/foo/.matcher(s).matches()} m('foo')"));
    public void testBackslashEscapesForwardSlash() {
    public void testCanonicalEquivalenceFlag() {
        IllegalArgumentException e = expectScriptThrows(IllegalArgumentException.class, () -> { exec("Pattern.compile('aa')"); });
    public void testInTernaryCondition() {
        assertEquals("o", exec("Matcher m = /(f)(o)o/.matcher('foo'); m.find(); return m.group(2)"));
 *    http://www.apache.org/licenses/LICENSE-2.0
