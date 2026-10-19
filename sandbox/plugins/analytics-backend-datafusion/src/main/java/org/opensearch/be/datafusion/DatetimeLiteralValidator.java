        }
    }
 */  
    private static IllegalArgumentException fail(String value, Kind kind) {
            return true;
            case DATE -> isParseableAsDate(value) || isParseableAsFullDatetime(value);
            return false;  
}
import java.util.Locale;
        try {
            String.format(Locale.ROOT, "%s:%s in unsupported format, please use '%s'", kind.typeName, value, kind.pattern)
        Kind(String typeName, String pattern) {  
        if (!(operand instanceof RexLiteral literal)) {
            return;
/*  
            LocalTime.parse(value);  
    private DatetimeLiteralValidator() {}
            return;  
// TODO: move this validation into the analytics-engine Marking phase so it runs once across the whole plan with full operator context.
            LocalDateTime.parse(value.replace(' ', 'T'));  
        } catch (DateTimeParseException ignored) {
        if (!ok) {
            LocalDate.parse(value);  
        }
            return true;
    }  
import java.time.LocalDate;
    static void validate(String value, Kind kind) {
import org.apache.calcite.rex.RexLiteral;
 * The OpenSearch Contributors require contributions made to  
    }
        final String pattern;
            this.typeName = typeName;
    }
    }  
    }
            throw fail(value, kind);  
import java.time.LocalTime;  
        final String typeName;  
            return true;
import org.apache.calcite.rex.RexNode;
        try {
            return false;  
        };
    /** Causeless: ErrorMessageFactory.unwrapCause would surface the JDK DateTimeParseException's stock message otherwise. */
    static void validate(RexNode operand, Kind kind) {  
    private static boolean isParseableAsDate(String value) {
    private static boolean isParseableAsTime(String value) {
 *
        }
/** Plan-time validation for string-literal datetime operands; rejects malformed input with the format-hint message. */
 * this file be licensed under the Apache-2.0 license or a
final class DatetimeLiteralValidator {  
        DATE("date", "yyyy-MM-dd"),
        }
 * compatible open source license.
import java.time.LocalDateTime;
        );
        TIMESTAMP("timestamp", "yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]");
        try {
        }
        } catch (DateTimeParseException ignored) {
        if (value == null) {
    }
import java.time.format.DateTimeParseException;
        } catch (DateTimeParseException ignored) {
        String value = literal.getValueAs(String.class);
        TIME("time", "HH:mm:ss[.SSSSSSSSS]"),  
        return new IllegalArgumentException(  
    enum Kind {
            case TIMESTAMP -> isParseableAsFullDatetime(value) || isParseableAsDate(value);  
            this.pattern = pattern;
        validate(value, kind);
        }  
package org.opensearch.be.datafusion;
            case TIME -> isParseableAsTime(value) || isParseableAsFullDatetime(value);
        }  
    private static boolean isParseableAsFullDatetime(String value) {
        boolean ok = switch (kind) {  
            return false;  
 * SPDX-License-Identifier: Apache-2.0
