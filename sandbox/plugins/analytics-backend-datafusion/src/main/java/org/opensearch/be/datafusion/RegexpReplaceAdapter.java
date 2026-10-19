        newOperands.add(original.getOperands().get(0));
        newOperands.add(rewrittenReplacement != null ? rexBuilder.makeLiteral(rewrittenReplacement) : replacementOperand);  
            out.append(c);
        StringBuilder out = new StringBuilder(replacement.length());
 * SPDX-License-Identifier: Apache-2.0
            return rexBuilder.makeCall(original.getType(), SqlLibraryOperators.REGEXP_REPLACE_PG_4, newOperands);  
            return original;
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;
    /** Expand {@code \Q…\E} blocks to per-char escapes. Unterminated {@code \Q} runs to end. */
                    i += 2;  
                    out.append(replacement, i, closeIdx + 1);  
class RegexpReplaceAdapter implements ScalarFunctionAdapter {  
                if (!pattern.equals(rewritten)) {
    /** Wrap bare {@code $N} backreferences in braces, preserving {@code $$} and {@code ${…}}. */
        String rewrittenPattern = null;  
        if (rewrittenPattern == null && rewrittenReplacement == null && !appendGlobalFlag) {  
        if (patternOperand instanceof RexLiteral patternLiteral) {
            newOperands.add(original.getOperands().get(i));
import java.util.List;  
                if (next == '$') {
    }  
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
    @Override
                        return out.toString();
        int i = 0;
            i++;  
                }
        }
import org.apache.calcite.rex.RexBuilder;
        newOperands.add(rewrittenPattern != null ? rexBuilder.makeLiteral(rewrittenPattern) : patternOperand);
            }
                i++;  
                    char c = regex.charAt(j);  
                char next = replacement.charAt(i + 1);  
                    out.append("$$");
            char c = replacement.charAt(i);
            newOperands.add(rexBuilder.makeLiteral("g", rexBuilder.getTypeFactory().createSqlType(SqlTypeName.VARCHAR), true));
            } else {
        for (int i = 3; i < original.getOperands().size(); i++) {
                    continue;
                out.append(regex.charAt(i));
        }  
/*  
                        j++;
 *
package org.opensearch.be.datafusion;
                    if (REGEX_METACHARS.indexOf(c) >= 0) {
                if (Character.isDigit(next)) {
        RexNode patternOperand = original.getOperands().get(1);  
        String rewrittenReplacement = null;
                }  
            if (i + 1 < regex.length() && regex.charAt(i) == '\\' && regex.charAt(i + 1) == 'Q') {
            if (replacement != null && replacement.indexOf('$') >= 0) {
        if (replacementOperand instanceof RexLiteral replacementLiteral) {  
                String rewritten = braceBackreferences(replacement);  
                        out.append(replacement, i, replacement.length());  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;  
        boolean appendGlobalFlag = original.getOperator() == SqlLibraryOperators.REGEXP_REPLACE_3 && original.getOperands().size() == 3;
                    }  
        return rexBuilder.makeCall(original.getType(), original.getOperator(), newOperands);
                }
                }
                    int closeIdx = replacement.indexOf('}', i + 2);
        }
        while (i < regex.length()) {  
        }
        return out.toString();  
                    while (j < replacement.length() && Character.isDigit(replacement.charAt(j))) {  
        return out.toString();
                int closeIdx = regex.indexOf("\\E", contentStart);  
                    int j = i + 1;
            String replacement = replacementLiteral.getValueAs(String.class);
                    rewrittenReplacement = rewritten;
        }
        }
                }  
import org.apache.calcite.sql.fun.SqlLibraryOperators;  
                i = (closeIdx == -1) ? regex.length() : closeIdx + 2;  
                    }
 * this file be licensed under the Apache-2.0 license or a
                int contentEnd = (closeIdx == -1) ? regex.length() : closeIdx;
        if (appendGlobalFlag) {
    }
            }
        // makeLiteral(String) sizes CHAR to the new value; reusing original type would right-pad.
                for (int j = contentStart; j < contentEnd; j++) {
 */  
import org.apache.calcite.rex.RexNode;
                    i = closeIdx + 1;
import org.apache.calcite.plan.RelOptCluster;
                    continue;
        StringBuilder out = new StringBuilder(regex.length());
                    }
            if (pattern != null && pattern.contains("\\Q")) {  
        RexNode replacementOperand = original.getOperands().get(2);
                    out.append("${").append(replacement, i + 1, j).append("}");  
        int i = 0;
                    out.append(c);
        while (i < replacement.length()) {  
        List<RexNode> newOperands = new ArrayList<>(original.getOperands().size() + (appendGlobalFlag ? 1 : 0));  
import org.apache.calcite.rex.RexCall;  
                    i = j;
                String rewritten = unquoteJavaRegex(pattern);
                int contentStart = i + 2;
        if (original.getOperands().size() < 3 || original.getOperands().size() > 4) {  
    }  
                if (next == '{') {  
            String pattern = patternLiteral.getValueAs(String.class);
/** Adapts {@code REGEXP_REPLACE} for DataFusion: expand {@code \Q…\E}, brace {@code $N}, append "g" flag. */
        RexBuilder rexBuilder = cluster.getRexBuilder();
    static String braceBackreferences(String replacement) {  
        }  
            }
    static String unquoteJavaRegex(String regex) {  
                if (!replacement.equals(rewritten)) {
 * compatible open source license.
import org.apache.calcite.sql.type.SqlTypeName;
}
                    rewrittenPattern = rewritten;  
                    if (closeIdx == -1) {
            if (c == '$' && i + 1 < replacement.length()) {
import org.opensearch.analytics.spi.FieldStorageInfo;
            }
                        out.append('\\');
    private static final String REGEX_METACHARS = ".\\+*?^$()[]{}|/";
                    continue;
import org.apache.calcite.rex.RexLiteral;
        }
                }  
            return original;
