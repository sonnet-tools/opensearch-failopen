    public void testUnquotePreservesNonQuotedPortions() {  
    public void testBraceIdempotentOnNonBackrefReplacement() {  
    }
        // be rewritten in a single pass so the resulting call matches DataFusion semantics.
    }  
        // SQL plugin's WildcardUtils output for `*BOARDS` — empty prefix, capture, literal suffix.
import org.apache.calcite.rex.RexCall;
        RexNode pattern = rexBuilder.makeLiteral("^\\QBUSINESS\\E(.*?)\\Q\\E$");  
        assertTrue("adapted node must remain a RexCall", adapted instanceof RexCall);  
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
        // Pattern + replacement get rewritten as in the 3-arg case; the trailing flags  
        // $$ stays $$ (Rust regex's literal-dollar escape, same as Java).  
    public void testUnquoteSimpleLiteral() {
        assertEquals("^(.*?)BOARDS$", RegexpReplaceAdapter.unquoteJavaRegex("^\\Q\\E(.*?)\\QBOARDS\\E$"));  
    }
 * {@code WildcardUtils.convertWildcardPatternToRegex()}) to the Rust regex syntax expected
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
    // ── braceBackreferences — replacement-string transform ──────────────────────  
 */  
        // No $ at all → output identical to input.
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);  
        RexNode replacement = rexBuilder.makeLiteral("X");
    public void testBraceFollowedByLetter() {
import java.util.List;  
        assertTrue("pattern must remain a literal", newPatternNode instanceof RexLiteral);
    // ── unquoteJavaRegex — the substantive transform ────────────────────────────
    public void testUnquoteUnterminatedRunsToEnd() {
    public void testBraceWrapsBareNumeric() {
package org.opensearch.be.datafusion;
        // The full failing-IT shape: Java-quoted pattern AND bare $N replacement. Both must  
            SqlLibraryOperators.REGEXP_REPLACE_PG_4,
        assertEquals("${1}foo", RegexpReplaceAdapter.braceBackreferences("$1foo"));  
    }  
import org.apache.calcite.sql.type.SqlTypeName;  
        assertEquals("BOARDS", RegexpReplaceAdapter.unquoteJavaRegex("\\QBOARDS\\E"));
        // Standard regex outside any \Q…\E passes through unchanged.
    }
        RexNode pattern = rexBuilder.makeLiteral("^(.*?) (.*?)$");  
        // $1 → ${1}; trivial smoke check.  
 *
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.REGEXP_REPLACE_3, List.of(field, pattern, replacement));
        assertEquals("4-arg call preserved", 4, result.getOperands().size());
        // Per Java Pattern semantics, \Q without a closing \E quotes through end of string.
 * {@code REGEXP_REPLACE} call surfaces here rather than at IT-level "regex parse error"
        assertEquals("pattern unquoted", "^(.*?) (.*?)$", ((RexLiteral) result.getOperands().get(1)).getValueAs(String.class));  
        RexCall result = (RexCall) adapter.adapt(original, List.of(), cluster);
        assertEquals("${12}", RegexpReplaceAdapter.braceBackreferences("$12"));
        assertEquals(input, RegexpReplaceAdapter.braceBackreferences(input));  
    }
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
    }
        RexNode pattern = rexBuilder.makeLiteral("^\\Q\\E(.*?)\\Q \\E(.*?)\\Q\\E$");  
        assertEquals("replacement operand preserved", replacement, result.getOperands().get(2));
        RexCall original = (RexCall) rexBuilder.makeCall(
        String input = "^(foo|bar).*$";
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.REGEXP_REPLACE_3, List.of(field, pattern, replacement));
        // $12 (group twelve) — wrap entire numeric run.
        RexNode replacement = rexBuilder.makeLiteral("OFC");
    @Override
    public void testBracePreservesLiteralDollar() {
        RexNode replacement = rexBuilder.makeLiteral("$1");
        RexCall result = (RexCall) adapter.adapt(original, List.of(), cluster);
        // Two \Q…\E spans separated by a regex fragment.  
        );
        // ${1} input is already braced — must not be re-wrapped or otherwise mangled.
        RexNode replacement = rexBuilder.makeLiteral("bar");
        RexCall result = (RexCall) adapter.adapt(original, List.of(), cluster);
        assertEquals("4 operands", 4, adapted.getOperands().size());
    public void testUnquoteWildcardPrefixShape() {  
        RexNode replacement = rexBuilder.makeLiteral("BIZ");
        assertSame("identity — 4-arg call with no \\Q and no $N passes through", original, adapted);
        // 4-arg REGEXP_REPLACE_PG_4 — emitted by PPL `rex mode=sed` with /g or /i flags.
    }  
import org.apache.calcite.rex.RexLiteral;  
        assertEquals(input, RegexpReplaceAdapter.unquoteJavaRegex(input));  
 * compatible open source license.
    }  
        // Rust-compatible pattern but Java-style $1_$2 replacement — adapter rewrites only  
        RexCall original = (RexCall) rexBuilder.makeCall(  
        RexNode adapted = adapter.adapt(original, List.of(), cluster);  
        RexNode flags = rexBuilder.makeLiteral("g");  
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);  
    }  
        typeFactory = new JavaTypeFactoryImpl();
        rexBuilder = new RexBuilder(typeFactory);
        assertEquals("replacement braced", "${1}", ((RexLiteral) result.getOperands().get(2)).getValueAs(String.class));  
        varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
 */  
    private final RegexpReplaceAdapter adapter = new RegexpReplaceAdapter();
        assertEquals("replacement braced", "${1}_${2}", ((RexLiteral) result.getOperands().get(2)).getValueAs(String.class));
    }
        // rebuilt call has the expanded pattern, original input, and original replacement.
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
            "pattern unchanged when no \\Q present",
        assertEquals("trailing flag is \"g\"", "g", ((RexLiteral) adapted.getOperands().get(3)).getValueAs(String.class));
        cluster = RelOptCluster.create(planner, rexBuilder);
import org.apache.calcite.rel.type.RelDataTypeFactory;  
/*  
 * rewrite that bridges the SQL plugin's Java-style wildcard regex output (from
    public void testUnquoteEscapesMetacharsInsideQuote() {
    public void testUnquoteEmptyQuoteBlock() {
        assertSame("flags operand passes through verbatim", flags, result.getOperands().get(3));
        // the replacement, leaves the pattern untouched.
 *
import org.apache.calcite.rel.type.RelDataType;
    public void testBracePreservesAlreadyBraced() {
            "^(.*?) (.*?)$",
    }  
        assertEquals("", RegexpReplaceAdapter.unquoteJavaRegex("\\Q\\E"));  
import org.apache.calcite.sql.fun.SqlLibraryOperators;
        // No \Q in input → output identical to input.
    private RexBuilder rexBuilder;
    public void testUnquoteWildcardSuffixShape() {
import org.apache.calcite.plan.RelOptCluster;
            ((RexLiteral) result.getOperands().get(1)).getValueAs(String.class)  
        super.setUp();  
    }
 * The OpenSearch Contributors require contributions made to  
        // 4-arg call with Rust-compatible pattern and no $N — adapter must return identity.
        // so the brace rewrite is what makes group-1 + literal underscore + group-2 work.  
/**
    public void testUnquoteHandlesMultipleQuoteBlocks() {
    public void testBraceMultiDigitGroup() {  
    }
    public void testBraceCriticalCaseFollowedByUnderscore() {
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    private RelOptCluster cluster;
        RexNode newPatternNode = result.getOperands().get(1);  
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.REGEXP_REPLACE_3, List.of(field, patternRef, replacement));
}
 * Unit tests for {@link RegexpReplaceAdapter}. Pins the {@code \Q…\E} → per-char-escape  
 * SPDX-License-Identifier: Apache-2.0
    }  
 * <p>Each test pins one rewrite invariant. A regression that loses {@code \Q…\E} expansion,
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
    private RelDataTypeFactory typeFactory;  
            List.of(field, pattern, replacement, flags)  
    }
        RexNode replacement = rexBuilder.makeLiteral("$1_$2");
    public void testAdaptRewritesPatternLiteral() {
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.REGEXP_REPLACE_3, List.of(field, pattern, replacement));  
 * this file be licensed under the Apache-2.0 license or a
    public void testAdapt4ArgPassesThroughWhenNoRewriteNeeded() {
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
import org.apache.calcite.plan.hep.HepProgramBuilder;
        assertEquals("input operand preserved", field, result.getOperands().get(0));  
import org.apache.calcite.rex.RexNode;
        );
        RexNode pattern = rexBuilder.makeLiteral("^OFFICE.*$");
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("^BUSINESS(.*?)$", RegexpReplaceAdapter.unquoteJavaRegex("^\\QBUSINESS\\E(.*?)\\Q\\E$"));
    public void testAdaptRewritesBothPatternAndReplacement() {
    }  
        // SQL plugin's WildcardUtils output for `BUSINESS*` — literal prefix, capture, empty suffix.
        // \QBOARDS\E → BOARDS (no special chars to escape).  
        assertTrue("trailing operand is a literal", adapted.getOperands().get(3) instanceof RexLiteral);  
        assertEquals("4 operands after append", 4, adapted.getOperands().size());
        // $1foo — Rust would parse "1foo" as the group name. Braces force the boundary.
        // operand passes through unchanged.
        assertEquals("$$10", RegexpReplaceAdapter.braceBackreferences("$$10"));
    }
    }
        // Build REGEXP_REPLACE(field, '^\\QBUSINESS\\E(.*?)\\Q\\E$', 'BIZ') and verify the  
        RexNode replacement = rexBuilder.makeLiteral("$1_$2");
        assertEquals(  
        assertSame("operator switched to PG_4", SqlLibraryOperators.REGEXP_REPLACE_PG_4, adapted.getOperator());  
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
    }  
            SqlLibraryOperators.REGEXP_REPLACE_PG_4,
 * mishandles unterminated quotes, or swaps operand positions in the rebuilt  
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
        RexNode patternRef = rexBuilder.makeInputRef(varcharType, 1);  
        RexNode pattern = rexBuilder.makeLiteral("^foo$");
        assertEquals("pattern reference preserved", patternRef, adapted.getOperands().get(1));
import org.apache.calcite.plan.hep.HepPlanner;  
        assertEquals("${1}_${2}", RegexpReplaceAdapter.braceBackreferences("${1}_${2}"));  
    }
        RexNode pattern = rexBuilder.makeLiteral("^\\QFOO\\E");  
    public void testAdaptAppendsGlobalFlagFor3Arg() {
        assertEquals("operator preserved", original.getOperator(), result.getOperator());
            List.of(field, pattern, replacement, flags)
        assertEquals("\\.\\+", RegexpReplaceAdapter.unquoteJavaRegex("\\Q.+"));  
    public void testAdaptRewritesReplacementOnly() {
        assertEquals("pattern unquoted", "^FOO", ((RexLiteral) result.getOperands().get(1)).getValueAs(String.class));
        );  
    public void testUnquoteIdempotentOnRustCompatibleRegex() {  
        assertEquals("a\\.b\\+c", RegexpReplaceAdapter.unquoteJavaRegex("\\Qa.b+c\\E"));
        // \Q\E produces empty string in Java; should disappear entirely.
        assertEquals("$1_$2 wrapped to ${1}_${2}", "${1}_${2}", ((RexLiteral) result.getOperands().get(2)).getValueAs(String.class));
        RexNode flags = rexBuilder.makeLiteral("gi");
    public void setUp() throws Exception {
    }
        assertEquals("^(.*?)$", RegexpReplaceAdapter.unquoteJavaRegex("^(.*?)$"));
        // $1_$2 — the failing wildcard-replacement case. Rust parses $1_ as named group "1_",
        // \Q a.b+c \E — inside a Java literal block `.` and `+` are not regex metas; in standard  
        // regex they are. Rewrite must escape every metachar so semantics are preserved.
    public void testAdaptAppendsGlobalFlagForNonLiteralPattern() {
import org.apache.calcite.rex.RexBuilder;
        String input = "plain literal";
    // ── adapter integration: RexCall in / RexCall out ───────────────────────────  
        assertSame("operator switched to PG_4", SqlLibraryOperators.REGEXP_REPLACE_PG_4, adapted.getOperator());
    public void testAdapt4ArgRewritesPatternAndPassesFlagsThrough() {
        assertEquals("FOO(.*?)BAR", RegexpReplaceAdapter.unquoteJavaRegex("\\QFOO\\E(.*?)\\QBAR\\E"));
    }
        assertEquals("${1}_${2}", RegexpReplaceAdapter.braceBackreferences("$1_$2"));
        assertEquals("Java \\Q…\\E rewritten to plain regex", "^BUSINESS(.*?)$", ((RexLiteral) newPatternNode).getValueAs(String.class));
 * failures.
public class RegexpReplaceAdapterTests extends OpenSearchTestCase {
 * by DataFusion's {@code regexp_replace} UDF.  
    private RelDataType varcharType;  
    }
        RexCall result = (RexCall) adapted;
        assertEquals("${1}", RegexpReplaceAdapter.braceBackreferences("$1"));
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.REGEXP_REPLACE_3, List.of(field, pattern, replacement));
