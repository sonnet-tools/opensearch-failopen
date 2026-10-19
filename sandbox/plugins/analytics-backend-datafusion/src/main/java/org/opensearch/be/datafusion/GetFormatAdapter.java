        Map.entry("timestamp|eur", "%Y-%m-%d %H.%i.%s"),
        if (format == null) {  
        Map.entry("date|internal", "%Y%m%d"),
        return rexBuilder.makeLiteral(format, original.getType(), true);
 * @opensearch.internal
 * <p>The table mirrors the SQL plugin's {@code DateTimeFunctions} GET_FORMAT map. {@code DATETIME}  
}
        RexBuilder rexBuilder = cluster.getRexBuilder();  
 * unchanged so the downstream planner surfaces a loud error rather than a wrong format.
import java.util.Map;  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.sql.type.SqlTypeName;  
        SqlTypeName typeName = literal.getType().getSqlTypeName();
    @Override
 */
 *
 * literals, so the adapter folds the call to the resolved format-string literal at plan time —  
    );  
        // DATETIME is an alias of TIMESTAMP.  
        if (typeName != SqlTypeName.CHAR && typeName != SqlTypeName.VARCHAR) {  
        Map.entry("date|iso", "%Y-%m-%d"),
        Map.entry("timestamp|jis", "%Y-%m-%d %H:%i:%s"),
 * PPL {@code GET_FORMAT(<type>, <region>)} — returns the MySQL format string for a given temporal  
            return null;
 * ({@code USA}/{@code JIS}/{@code ISO}/{@code EUR}/{@code INTERNAL}). Both operands are string
        }
        String region = stringLiteral(original.getOperands().get(1));
    public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {  
 *  
        Map.entry("timestamp|internal", "%Y%m%d%H%i%s")
        Map.entry("time|internal", "%H%i%s"),  
import org.apache.calcite.rex.RexLiteral;
        if (original.getOperands().size() != 2) {
    }
    private static final Map<String, String> FORMATS = Map.ofEntries(
        }
        Map.entry("date|jis", "%Y-%m-%d"),
        Map.entry("timestamp|iso", "%Y-%m-%d %H:%i:%s"),  
        Map.entry("date|eur", "%d.%m.%Y"),  
        if (typeKey.equals("datetime")) {
        String type = stringLiteral(original.getOperands().get(0));
 *
import java.util.List;
        if (!(operand instanceof RexLiteral literal)) {
 * is an alias of {@code TIMESTAMP}. An unknown {@code (type, region)} pair leaves the call
        }
 * SPDX-License-Identifier: Apache-2.0
        }
        String typeKey = type.toLowerCase(Locale.ROOT);
import org.apache.calcite.rex.RexBuilder;
package org.opensearch.be.datafusion;
import java.util.Locale;
 * compatible open source license.
        Map.entry("time|iso", "%H:%i:%s"),
/*  
        if (type == null || region == null) {  
 * The OpenSearch Contributors require contributions made to  
        }
        Map.entry("time|jis", "%H:%i:%s"),  
        Map.entry("time|eur", "%H.%i.%s"),
    }
        Map.entry("time|usa", "%h:%i:%s %p"),
 * there is nothing to evaluate at runtime. The result feeds {@code date_format(value, <fmt>)}.
    private static String stringLiteral(RexNode operand) {
        return literal.getValueAs(String.class);  
class GetFormatAdapter implements ScalarFunctionAdapter {  
        String format = FORMATS.get(typeKey + "|" + region.toLowerCase(Locale.ROOT));
            return original;
        Map.entry("date|usa", "%m.%d.%Y"),  
import org.apache.calcite.plan.RelOptCluster;
            typeKey = "timestamp";  
import org.apache.calcite.rex.RexNode;
            return original;
        }  
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
/**
            return null;  
            return original;
import org.opensearch.analytics.spi.FieldStorageInfo;
 */  
import org.apache.calcite.rex.RexCall;  
 * type ({@code DATE}/{@code TIME}/{@code TIMESTAMP}/{@code DATETIME}) and region
        Map.entry("timestamp|usa", "%Y-%m-%d %H.%i.%s"),
