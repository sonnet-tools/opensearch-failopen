        return field;  
                return dateResolution.name().toLowerCase(Locale.ROOT);  
     * @param finalized whether this domain is trusted as complete for consumers that require finalized metadata  
        }
     * Optional date resolution used to interpret numeric bounds.  
    public String type() {
    private static String normalizeResolution(String resolution) {
    @Override  
    /**
     */
        return finalized;  
     *
    private static String requireNonEmpty(String value, String name) {  
     * Creates date range bounds using serialized bound values.
 * this file be licensed under the Apache-2.0 license or a
    private final String resolution;  
     * @param max inclusive upper index bound
@ExperimentalApi  
    }
    private final boolean finalized;  
        long parsedMax;
        }
            throw new IllegalArgumentException("date range field domain bounds must be numeric long values", e);  
 *  
    public DateRangeFieldDomain(String field, String min, String max, boolean finalized, String source, String format, String resolution) {
     * Returns {@link #TYPE}.
        try {
        } catch (NumberFormatException e) {
     * Metadata type for date range field domains.  
    @Override
 * compatible open source license.
    }
    }
     * @param resolution date resolution, for example milliseconds or nanoseconds  
    private static void validateBounds(String min, String max) {
     */
        if (resolution == null || resolution.isBlank()) {
 */  
     * @param source optional producer identifier  
    }  
            parsedMax = Long.parseLong(max);
     */
        }
     */
     * @param max inclusive upper index bound in epoch milliseconds
    private final String max;
        this.max = requireNonEmpty(max, "max");
        return source;
    public DateRangeFieldDomain(String field, long min, long max, boolean finalized, String source) {
        return format;
/*  
        if (parsedMin > parsedMax) {
    public String source() {  
    /**  
import java.util.Locale;
     * Creates millisecond-resolution date range bounds.  
    }
        }
    private final String source;
     * Optional date format used to interpret query and index bounds.
        this.source = source;
    }  
    }  
 * {@code Map<String, String>}. The evaluator interprets them using the configured resolution.
     * Inclusive upper index bound, serialized as metadata.
 * The stored min/max values are serialized as strings so the cluster-state custom metadata remains a simple
        this(field, Long.toString(min), Long.toString(max), finalized, source, null, DEFAULT_RESOLUTION);  
        if (value.isEmpty()) {
     * @param min inclusive lower index bound
    public String field() {
     * @param format optional date format used by the bound producer
import java.util.Objects;
     * @param source optional producer identifier
package org.opensearch.index.fielddomain;
    }
     * @param field field name this domain describes
            if (dateResolution.name().toLowerCase(Locale.ROOT).equals(configured) || dateResolution.type().equals(configured)) {
     * @param min inclusive lower index bound in epoch milliseconds  
import org.opensearch.common.annotation.ExperimentalApi;
     */  
            }
 *  
     * Inclusive lower index bound, serialized as metadata.  
        this.resolution = normalizeResolution(resolution);
    public String min() {
        return max;
     */
     * @param finalized whether this domain is trusted as complete for consumers that require finalized metadata
        return TYPE;
    }
            parsedMin = Long.parseLong(min);  
/**
        }
    public boolean finalized() {
     */
     * Optional identifier for the component that produced these bounds.
    /**
     */
        return min;  
    /**
import org.opensearch.index.mapper.DateFieldMapper;
 */
    @Override
            throw new IllegalArgumentException("resolution must not be null or empty");  
 * The OpenSearch Contributors require contributions made to  
        throw new IllegalArgumentException("unsupported date range field domain resolution [" + resolution + "]");  
    public String max() {  
public final class DateRangeFieldDomain implements FieldDomain {
        validateBounds(this.min, this.max);  
 *
    /**  
    }
            throw new IllegalArgumentException(name + " must not be empty");  
 * @opensearch.experimental
    }
    private final String format;
            throw new IllegalArgumentException("date range field domain min must be less than or equal to max");  
    public String resolution() {
        Objects.requireNonNull(value, name + " must not be null");
        this.finalized = finalized;
     */
 * Field domain implementation for date-like range metadata.
    private final String field;  
 * SPDX-License-Identifier: Apache-2.0
}
        this.format = format;  
    /**
    private static final String DEFAULT_RESOLUTION = DateFieldMapper.Resolution.MILLISECONDS.name().toLowerCase(Locale.ROOT);
    private final String min;
    }
        this.field = requireNonEmpty(field, "field");  
        return resolution;  
    /**  
    public static final String TYPE = "date_range";
     *
        String configured = resolution.toLowerCase(Locale.ROOT);  
        return value;
    }
     * @param field field name this domain describes  
    /**  
        long parsedMin;  
    /**
        for (DateFieldMapper.Resolution dateResolution : DateFieldMapper.Resolution.values()) {
    public String format() {
        this.min = requireNonEmpty(min, "min");
