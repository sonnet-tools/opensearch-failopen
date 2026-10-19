import org.opensearch.common.collect.Tuple;  
    private static Tuple<Object, Object> normalizePair(Object a, Object b) {  
    /**
import org.apache.logging.log4j.LogManager;
            } else {
 */
        Tuple<Object, Object> normalized = normalizePair(castActual, expectedValue);
            }
     *  - If both are Numbers and any is floating (Float/Double), coerce both to Double.
        logger.trace("assert that [{}] {} [{}] (field: [{}])", actualValue, relationToString(relation()), expectedValue, getField());
 * this file be licensed under the Apache-2.0 license or a
 *  - numeric normalization so both sides are Comparable of the same class
        assertThat(
import org.opensearch.core.xcontent.XContentParser;
    /**
 * It provides:  
            instanceOf(Comparable.class)
            case GT -> "is greater than";
        GTE,
 *  - common comparison logic based on a {@link Relation}  
            expectedNormalized,  
        } catch (ClassCastException e) {  
        Object actualNormalized = normalized.v1();
                case GTE -> cmp >= 0;
 */  
    protected abstract Relation relation();
            };
            if (!ok) {  
     */  
        OrderingAssertionFactory<T> factory
        }  
        T create(XContentLocation location, String field, Object expectedValue);
     *  - Else if both are Numbers, coerce both to Long (widening smaller integral types).  
    }
        LTE
import static org.junit.Assert.fail;
        GT,
            case GTE -> "is greater than or equal to";
     * Common parser for {gt|gte|lt|lte}: { field: expectedValue }
     */
                case LT -> cmp < 0;  
/**
import org.apache.logging.log4j.Logger;
 *
    }
                fail(errorMessage());
        Object castActual = convertActualValue(actualValue, expectedValue);  
        if (!(expected instanceof Comparable)) {  
    protected final void doAssert(Object actualValue, Object expectedValue) {  
                return Tuple.tuple(aNum.doubleValue(), bNum.doubleValue());
        LT,  
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected OrderingAssertion(XContentLocation location, String field, Object expectedValue) {  
                    + " section can only be used with objects that support natural ordering, found "  
        };
        }
                case LTE -> cmp <= 0;
            case LT -> "is less than";  
                relation
     *  - Else return as-is (let Comparable semantics handle it).
            );
            actualNormalized,
        );  
        Tuple<String, Object> t = ParserUtils.parseTuple(parser);
    }
    }  
        assertThat(
    private static final Logger logger = LogManager.getLogger(OrderingAssertion.class);
            boolean ok = switch (relation()) {  
        XContentParser parser,
        return factory.create(location, t.v1(), expected);
            instanceOf(Comparable.class)
            case LTE -> "is less than or equal to";
    @Override
/*  
     * Normalize a pair to comparable types to avoid Integer vs Long / Double vs Integer ClassCastExceptions.  
import java.io.IOException;
        super(location, field, expectedValue);
                    + expected.getClass().getSimpleName()
    protected static <T extends OrderingAssertion> T parseOrderingAssertion(
        );
        try {
                case GT -> cmp > 0;
    }
    ) throws IOException {
        Object expectedNormalized = normalized.v2();  
        Relation relation,  
 * Base class for all ordering assertions (gt/gte/lt/lte).
    @FunctionalInterface
            int cmp = ((Comparable) actualNormalized).compareTo(expectedNormalized);
 * The OpenSearch Contributors require contributions made to  
public abstract class OrderingAssertion extends Assertion {
    protected abstract String errorMessage();  
    protected enum Relation {  
            }
    }  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
            "expected value of [" + getField() + "] is not comparable (got [" + expectedNormalized.getClass() + "])",
        }
package org.opensearch.test.rest.yaml.section;
     * Rules:
        return Tuple.tuple(a, b);  
    protected interface OrderingAssertionFactory<T extends OrderingAssertion> {  
        XContentLocation location = parser.getTokenLocation();  
        if (a instanceof Number aNum && b instanceof Number bNum) {
import static org.junit.Assert.assertThat;
 *  - shared YAML parse boilerplate (via {@link #parseOrderingAssertion})
            if (isFloating) {  
            throw new IllegalArgumentException(
            boolean isFloating = aNum instanceof Float || aNum instanceof Double || bNum instanceof Float || bNum instanceof Double;
            fail("cast error while checking (" + errorMessage() + "): " + e);
            "value of [" + getField() + "] is not comparable (got [" + safeClass(actualNormalized) + "])",  
        Object expected = t.v2();
import org.opensearch.core.xcontent.XContentLocation;
                return Tuple.tuple(aNum.longValue(), bNum.longValue());  
    private static String relationToString(Relation r) {
    }
}
        return switch (r) {  
import static org.hamcrest.Matchers.instanceOf;  
