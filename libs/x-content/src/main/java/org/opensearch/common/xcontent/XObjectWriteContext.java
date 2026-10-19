    public PrettyPrinter getPrettyPrinter() {
        }
            g.writeString((String) value);  
    @Override  
        }
        }
                + value.getClass().getName()
                return;
    private static final XObjectWriteContext DEFAULT_INSTANCE = new XObjectWriteContext(false);  
    }
    public void writeValue(JsonGenerator g, Object value) {  
            } else if (n instanceof Byte) {
package org.opensearch.common.xcontent;
        } else {  
import java.math.BigDecimal;
import tools.jackson.core.PrettyPrinter;  
import java.util.concurrent.atomic.AtomicLong;
        } else if (value instanceof Boolean) {
import java.util.concurrent.atomic.AtomicInteger;
            if (n instanceof Integer) {
                g.writeNumber((BigInteger) n);  
                g.writeNumber(n.shortValue());  
    private final PrettyPrinter prettyPrinter;
 * The OpenSearch Contributors require contributions made to  
import tools.jackson.core.JsonGenerator;
    }  
    private static final SerializedString LF = new SerializedString("\n");
        );  
    @Override
                g.writeNumber(n.intValue());  
            g.writeBinary((byte[]) value);
 * this file be licensed under the Apache-2.0 license or a
                return;
import tools.jackson.core.util.DefaultPrettyPrinter;  
            g.writeBoolean((Boolean) value);
 */  
        if (value instanceof Number) {  
            return;  
            return;
            g.writeNull();
            } else if (n instanceof Short) {
                return;
        // 31-Dec-2009, tatu: Actually, we could just handle some basic
                // then Atomic types
public class XObjectWriteContext extends ObjectWriteContext.Base {
                + ")"
            } else if (n instanceof BigInteger) {
        // https://github.com/FasterXML/jackson-core/blob/2.x/src/main/java/com/fasterxml/jackson/core/JsonGenerator.java#L3099).
        } else if (value instanceof byte[]) {
                g.writeNumber(n.doubleValue());  
            return new XObjectWriteContext(prettyPrint);
 * SPDX-License-Identifier: Apache-2.0
            } else if (n instanceof Double) {
                return;
    private static final DefaultPrettyPrinter.Indenter INDENTER = new DefaultIndenter("  ", LF.getValue());  
        }
    }  
 *
            "No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed "  
            return;  
            return;  
                return;
                return;
                g.writeNumber(((AtomicInteger) n).get());
                return;
                return;
import java.math.BigInteger;
            return DEFAULT_INSTANCE;
        this.prettyPrinter = prettyPrint ? new DefaultPrettyPrinter().withObjectIndenter(INDENTER).withArrayIndenter(INDENTER) : null;  
    private XObjectWriteContext(boolean prettyPrint) {
            } else if (n instanceof AtomicLong) {  
                g.writeNumber(n.byteValue());  
    public static XObjectWriteContext create(boolean prettyPrint) {  
    }
        return prettyPrinter;
            } else if (n instanceof Float) {
        if (value instanceof String) {
import java.util.concurrent.atomic.AtomicBoolean;  
                g.writeNumber((BigDecimal) n);  
            g.writeBoolean(((AtomicBoolean) value).get());
                return;
}
import tools.jackson.core.io.SerializedString;
import tools.jackson.core.util.DefaultIndenter;
            Number n = (Number) value;
                g.writeNumber(n.floatValue());  
                g.writeNumber(n.longValue());  
        throw new IllegalStateException(
            } else if (n instanceof BigDecimal) {
            } else if (n instanceof AtomicInteger) {  
                return;
        // types even without codec. This can improve interoperability,
        // and specifically help with TokenBuffer.  
        if (value == null) {
            }  
        // Bringing the implementation from Jackson 2.x release line (see please
        if (prettyPrint == true) {
            return;  
/*  
            } else if (n instanceof Long) {
 * compatible open source license.
        } else if (value instanceof AtomicBoolean) {
import tools.jackson.core.ObjectWriteContext;
                g.writeNumber(((AtomicLong) n).get());
