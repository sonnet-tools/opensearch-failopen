        // 4-arg call with Rust-compatible pattern and no $N — adapter must return identity.
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.REGEXP_REPLACE_3, List.of(field, pattern, replacement));
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
    }
        RexNode replacement = rexBuilder.makeLiteral("OFC");
        // \QBOARDS\E → BOARDS (no special chars to escape).
        RexCall result = (RexCall) adapted;
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
 * {@code REGEXP_REPLACE} call surfaces here rather than at IT-level "regex parse error"
 * SPDX-License-Identifier: Apache-2.0
 * mishandles unterminated quotes, or swaps operand positions in the rebuilt
    public void testAdaptAppendsGlobalFlagFor3Arg() {
            "pattern unchanged when no \\Q present",
        // The full failing-IT shape: Java-quoted pattern AND bare $N replacement. Both must
        assertTrue("pattern must remain a literal", newPatternNode instanceof RexLiteral);
        // No \Q in input → output identical to input.
import org.apache.calcite.sql.type.SqlTypeName;
    public void setUp() throws Exception {
        // so the brace rewrite is what makes group-1 + literal underscore + group-2 work.
    }
        RexNode pattern = rexBuilder.makeLiteral("^\\Q\\E(.*?)\\Q \\E(.*?)\\Q\\E$");
    public void testUnquotePreservesNonQuotedPortions() {
        String input = "plain literal";
    }
        // be rewritten in a single pass so the resulting call matches DataFusion semantics.
        assertEquals(input, RegexpReplaceAdapter.braceBackreferences(input));
        RexNode pattern = rexBuilder.makeLiteral("^foo$");
import org.apache.calcite.rex.RexCall;
        assertTrue("trailing operand is a literal", adapted.getOperands().get(3) instanceof RexLiteral);
import org.apache.calcite.sql.fun.SqlLibraryOperators;
            SqlLibraryOperators.REGEXP_REPLACE_PG_4,
        // 4-arg REGEXP_REPLACE_PG_4 — emitted by PPL `rex mode=sed` with /g or /i flags.
 * compatible open source license.
        assertEquals("a\\.b\\+c", RegexpReplaceAdapter.unquoteJavaRegex("\\Qa.b+c\\E"));
        assertEquals("pattern unquoted", "^(.*?) (.*?)$", ((RexLiteral) result.getOperands().get(1)).getValueAs(String.class));
        // SQL plugin's WildcardUtils output for `*BOARDS` — empty prefix, capture, literal suffix.
        );
import org.apache.calcite.plan.RelOptCluster;
import java.util.List;
        assertSame("identity — 4-arg call with no \\Q and no $N passes through", original, adapted);
    public void testUnquoteEscapesMetacharsInsideQuote() {
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.REGEXP_REPLACE_3, List.of(field, patternRef, replacement));
    }
        // Pattern + replacement get rewritten as in the 3-arg case; the trailing flags
        );
        RexCall original = (RexCall) rexBuilder.makeCall(
        RexNode pattern = rexBuilder.makeLiteral("^(.*?) (.*?)$");
    }
        assertSame("flags operand passes through verbatim", flags, result.getOperands().get(3));
        RexNode replacement = rexBuilder.makeLiteral("$1");
    public void testBracePreservesAlreadyBraced() {
    public void testBraceCriticalCaseFollowedByUnderscore() {
    public void testAdapt4ArgRewritesPatternAndPassesFlagsThrough() {
    }
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
        assertEquals("4 operands", 4, adapted.getOperands().size());
    public void testUnquoteUnterminatedRunsToEnd() {
        // Standard regex outside any \Q…\E passes through unchanged.
        assertEquals("4-arg call preserved", 4, result.getOperands().size());
    private RelDataType varcharType;
        RexCall original = (RexCall) rexBuilder.makeCall(
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
            List.of(field, pattern, replacement, flags)
public class RegexpReplaceAdapterTests extends OpenSearchTestCase {
        RexNode patternRef = rexBuilder.makeInputRef(varcharType, 1);
            List.of(field, pattern, replacement, flags)
    }
        assertEquals("replacement braced", "${1}_${2}", ((RexLiteral) result.getOperands().get(2)).getValueAs(String.class));
    }
 * by DataFusion's {@code regexp_replace} UDF.
            ((RexLiteral) result.getOperands().get(1)).getValueAs(String.class)
        RexNode replacement = rexBuilder.makeLiteral("X");
 */
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataType;
    // ── adapter integration: RexCall in / RexCall out ───────────────────────────
        assertEquals("^(.*?)$", RegexpReplaceAdapter.unquoteJavaRegex("^(.*?)$"));
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.REGEXP_REPLACE_3, List.of(field, pattern, replacement));
        assertEquals("$$10", RegexpReplaceAdapter.braceBackreferences("$$10"));
        RexCall result = (RexCall) adapter.adapt(original, List.of(), cluster);
    private RexBuilder rexBuilder;
        assertEquals("${1}foo", RegexpReplaceAdapter.braceBackreferences("$1foo"));
    public void testBraceFollowedByLetter() {
        assertEquals("Java \\Q…\\E rewritten to plain regex", "^BUSINESS(.*?)$", ((RexLiteral) newPatternNode).getValueAs(String.class));
 * Unit tests for {@link RegexpReplaceAdapter}. Pins the {@code \Q…\E} → per-char-escape
/*
    }
    private RelDataTypeFactory typeFactory;
        // SQL plugin's WildcardUtils output for `BUSINESS*` — literal prefix, capture, empty suffix.
        // $1foo — Rust would parse "1foo" as the group name. Braces force the boundary.
/**
        assertEquals("${1}_${2}", RegexpReplaceAdapter.braceBackreferences("$1_$2"));
        // \Q\E produces empty string in Java; should disappear entirely.
 * <p>Each test pins one rewrite invariant. A regression that loses {@code \Q…\E} expansion,
    public void testAdaptAppendsGlobalFlagForNonLiteralPattern() {
        // $1_$2 — the failing wildcard-replacement case. Rust parses $1_ as named group "1_",
    public void testAdaptRewritesBothPatternAndReplacement() {
 */
        assertEquals("input operand preserved", field, result.getOperands().get(0));
        assertEquals("pattern reference preserved", patternRef, adapted.getOperands().get(1));
    private final RegexpReplaceAdapter adapter = new RegexpReplaceAdapter();
    public void testBraceMultiDigitGroup() {
        // No $ at all → output identical to input.
 * The OpenSearch Contributors require contributions made to
        RexNode pattern = rexBuilder.makeLiteral("^\\QFOO\\E");
    }
        RexNode flags = rexBuilder.makeLiteral("gi");
    public void testBraceIdempotentOnNonBackrefReplacement() {
    }
        RexNode replacement = rexBuilder.makeLiteral("$1_$2");
    @Override
 * {@code WildcardUtils.convertWildcardPatternToRegex()}) to the Rust regex syntax expected
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
        );
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("trailing flag is \"g\"", "g", ((RexLiteral) adapted.getOperands().get(3)).getValueAs(String.class));
    }
        typeFactory = new JavaTypeFactoryImpl();
        assertEquals("replacement braced", "${1}", ((RexLiteral) result.getOperands().get(2)).getValueAs(String.class));
        RexNode flags = rexBuilder.makeLiteral("g");
        assertEquals("", RegexpReplaceAdapter.unquoteJavaRegex("\\Q\\E"));
        // regex they are. Rewrite must escape every metachar so semantics are preserved.
        assertEquals("${1}_${2}", RegexpReplaceAdapter.braceBackreferences("${1}_${2}"));
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
}
        assertEquals("${12}", RegexpReplaceAdapter.braceBackreferences("$12"));
    public void testUnquoteWildcardSuffixShape() {
        RexNode replacement = rexBuilder.makeLiteral("bar");
    }
        assertEquals("$1_$2 wrapped to ${1}_${2}", "${1}_${2}", ((RexLiteral) result.getOperands().get(2)).getValueAs(String.class));
        RexNode newPatternNode = result.getOperands().get(1);
 * failures.
    public void testUnquoteSimpleLiteral() {
 * rewrite that bridges the SQL plugin's Java-style wildcard regex output (from
    }
import org.apache.calcite.plan.hep.HepProgramBuilder;
    }
        RexNode replacement = rexBuilder.makeLiteral("BIZ");
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
        RexNode adapted = adapter.adapt(original, List.of(), cluster);
        // $$ stays $$ (Rust regex's literal-dollar escape, same as Java).
        assertSame("operator switched to PG_4", SqlLibraryOperators.REGEXP_REPLACE_PG_4, adapted.getOperator());
        String input = "^(foo|bar).*$";
        // \Q a.b+c \E — inside a Java literal block `.` and `+` are not regex metas; in standard
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
        assertEquals("\\.\\+", RegexpReplaceAdapter.unquoteJavaRegex("\\Q.+"));
        RexNode pattern = rexBuilder.makeLiteral("^OFFICE.*$");
        assertEquals("FOO(.*?)BAR", RegexpReplaceAdapter.unquoteJavaRegex("\\QFOO\\E(.*?)\\QBAR\\E"));
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.REGEXP_REPLACE_3, List.of(field, pattern, replacement));
import org.apache.calcite.rex.RexBuilder;
    }
    public void testUnquoteWildcardPrefixShape() {
    public void testAdapt4ArgPassesThroughWhenNoRewriteNeeded() {
        // Build REGEXP_REPLACE(field, '^\\QBUSINESS\\E(.*?)\\Q\\E$', 'BIZ') and verify the
    public void testUnquoteIdempotentOnRustCompatibleRegex() {
    public void testUnquoteEmptyQuoteBlock() {
        assertSame("operator switched to PG_4", SqlLibraryOperators.REGEXP_REPLACE_PG_4, adapted.getOperator());
        assertEquals("4 operands after append", 4, adapted.getOperands().size());
        RexNode replacement = rexBuilder.makeLiteral("$1_$2");
        assertTrue("adapted node must remain a RexCall", adapted instanceof RexCall);
        rexBuilder = new RexBuilder(typeFactory);
    }
        assertEquals("^(.*?)BOARDS$", RegexpReplaceAdapter.unquoteJavaRegex("^\\Q\\E(.*?)\\QBOARDS\\E$"));
        // rebuilt call has the expanded pattern, original input, and original replacement.
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("operator preserved", original.getOperator(), result.getOperator());
    }
    }
        // ${1} input is already braced — must not be re-wrapped or otherwise mangled.
        assertEquals("replacement operand preserved", replacement, result.getOperands().get(2));
    public void testUnquoteHandlesMultipleQuoteBlocks() {
import org.apache.calcite.plan.hep.HepPlanner;
        // Two \Q…\E spans separated by a regex fragment.
    public void testBracePreservesLiteralDollar() {
    public void testAdaptRewritesReplacementOnly() {
        assertEquals(input, RegexpReplaceAdapter.unquoteJavaRegex(input));
        super.setUp();
        assertEquals("${1}", RegexpReplaceAdapter.braceBackreferences("$1"));
        RexNode field = rexBuilder.makeInputRef(varcharType, 0);
        assertEquals(
        RexCall original = (RexCall) rexBuilder.makeCall(SqlLibraryOperators.REGEXP_REPLACE_3, List.of(field, pattern, replacement));
        RexNode pattern = rexBuilder.makeLiteral("^\\QBUSINESS\\E(.*?)\\Q\\E$");
    // ── unquoteJavaRegex — the substantive transform ────────────────────────────
import org.apache.calcite.rex.RexNode;
package org.opensearch.be.datafusion;
    private RelOptCluster cluster;
        varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        // $12 (group twelve) — wrap entire numeric run.
        RexCall result = (RexCall) adapter.adapt(original, List.of(), cluster);
        // $1 → ${1}; trivial smoke check.
    }
        assertEquals("pattern unquoted", "^FOO", ((RexLiteral) result.getOperands().get(1)).getValueAs(String.class));
    public void testAdaptRewritesPatternLiteral() {
        assertEquals("^BUSINESS(.*?)$", RegexpReplaceAdapter.unquoteJavaRegex("^\\QBUSINESS\\E(.*?)\\Q\\E$"));
    }
        // Rust-compatible pattern but Java-style $1_$2 replacement — adapter rewrites only
        RexCall result = (RexCall) adapter.adapt(original, List.of(), cluster);
    }
            "^(.*?) (.*?)$",
import org.apache.calcite.rex.RexLiteral;
        RexCall adapted = (RexCall) adapter.adapt(original, List.of(), cluster);
        // Per Java Pattern semantics, \Q without a closing \E quotes through end of string.
        assertEquals("BOARDS", RegexpReplaceAdapter.unquoteJavaRegex("\\QBOARDS\\E"));
            SqlLibraryOperators.REGEXP_REPLACE_PG_4,
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    // ── braceBackreferences — replacement-string transform ──────────────────────
    }
        cluster = RelOptCluster.create(planner, rexBuilder);
        // operand passes through unchanged.
 *
        // the replacement, leaves the pattern untouched.
    }
    public void testBraceWrapsBareNumeric() {
 *
