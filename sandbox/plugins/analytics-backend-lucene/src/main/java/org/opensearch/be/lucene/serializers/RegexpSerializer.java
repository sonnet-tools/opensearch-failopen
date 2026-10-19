 * Serializer for the REGEXP full-text function ({@code regexp(field, pattern)}).
import org.apache.calcite.rex.RexInputRef;
            pattern = raw != null ? raw.toString() : "";  
 * <p>Expected RexCall shape: {@code REGEXP($colIdx, patternLiteral)}.
import java.util.List;
        if (raw instanceof NlsString nls) {
import org.opensearch.index.query.RegexpQueryBuilder;
 */  
            ? field.getFieldName() + "." + field.getExactMatchSubfield()
}
        RexNode patternNode = call.getOperands().get(1);  
            pattern = nls.getValue();
 * Produces a {@link RegexpQueryBuilder} against the field (or its keyword exact-match subfield).
            throw new IllegalArgumentException("REGEXP first operand must be a column reference, got " + fieldNode);  
        if (call.getOperands().size() < 2) {
        RexNode fieldNode = call.getOperands().get(0);
        Object raw = patternLit.getValue2();
 */  
    @Override  
            : field.getFieldName();  
        } else {
import org.apache.calcite.rex.RexNode;
        }
        } else if (raw instanceof String s) {  
 * compatible open source license.
    public QueryBuilder buildQueryBuilder(RexCall call, List<FieldStorageInfo> fieldStorage) {
            pattern = s;
    }
 * SPDX-License-Identifier: Apache-2.0
        if (!(patternNode instanceof RexLiteral patternLit)) {
 *
        FieldStorageInfo field = FieldStorageInfo.resolve(fieldStorage, columnRef.getIndex());  
            throw new IllegalArgumentException("REGEXP second operand must be a literal pattern, got " + patternNode);  
        String fieldName = field.getExactMatchSubfield() != null
 * The OpenSearch Contributors require contributions made to  
 * <p>PPL/MySQL REGEXP is substring-find but Lucene's {@link RegexpQueryBuilder} is anchored,  
        }
        return new RegexpQueryBuilder(fieldName, ".*" + pattern + ".*");  
        }
/*  
        if (!(fieldNode instanceof RexInputRef columnRef)) {
        }
            throw new IllegalArgumentException("REGEXP expects at least 2 operands (field, pattern), got " + call.getOperands().size());  
/**  
 * anchors, so wrapping cannot break user-supplied patterns.
import org.apache.calcite.rex.RexCall;
 * this file be licensed under the Apache-2.0 license or a
 *
        String pattern;  
package org.opensearch.be.lucene.serializers;
 * so the pattern is wrapped with leading/trailing {@code .*}. Lucene regex has no {@code ^}/{@code $}
 *  
import org.apache.calcite.util.NlsString;
public class RegexpSerializer extends AbstractQuerySerializer {
import org.apache.calcite.rex.RexLiteral;  
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.analytics.spi.FieldStorageInfo;  
