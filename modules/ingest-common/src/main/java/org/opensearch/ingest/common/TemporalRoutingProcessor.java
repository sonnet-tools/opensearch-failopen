import org.opensearch.common.time.DateFormatters;
            case DAY:
        @Nullable String description,
    }
                int weekYear = truncated.get(java.time.temporal.WeekFields.ISO.weekBasedYear());
public final class TemporalRoutingProcessor extends AbstractProcessor {
     */
                hashBucket
        Object timestampValue = document.getFieldValue(timestampField, Object.class, ignoreMissing);
    }
    }
        // Create temporal bucket key
    }
                throw newConfigurationException(TYPE, tag, "format", "invalid date format: " + e.getMessage());
 * Processor that sets document routing based on temporal structure.
                format = DEFAULT_FORMAT;
        boolean overrideExisting,
        MONTH(ChronoUnit.MONTHS);
    private final DateFormatter dateFormatter;
         * @return the ChronoUnit
        // Truncate to granularity
    }
            String format = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "format");
        }
                throw newConfigurationException(TYPE, tag, "granularity", "cannot be null or empty");
        this.ignoreMissing = ignoreMissing;
        Granularity granularity,
    }
    /**
        }
         * @throws IllegalArgumentException if the value is not valid
    public enum Granularity {
    private static final String DEFAULT_FORMAT = "strict_date_optional_time";
            throw new IllegalArgumentException("field [" + timestampField + "] not present as part of path [" + timestampField + "]");
     * same input to ensure documents are routed to the same shards during ingest and search.
        /** Day granularity for daily bucketing */
            } catch (Exception e) {
        /** Month granularity for monthly bucketing */
                // Truncate to start of week (Monday)
    }
/*
     * Computes routing value from timestamp by truncating to granularity
            }
        }
    }
import java.time.ZonedDateTime;
            if (Strings.isNullOrEmpty(granularityStr)) {
    ) {
                    + String.format(Locale.ROOT, "%02d", truncated.getHour());
            String granularityStr = ConfigurationUtils.readStringProperty(TYPE, tag, config, "granularity");
        String tag,
                    + String.format(Locale.ROOT, "%02d", truncated.getDayOfMonth())
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
     *
         */
        if (hashBucket) {
    private final boolean overrideExisting;
            }
    public IngestDocument execute(IngestDocument document) throws Exception {
            case MONTH:
                granularity = Granularity.fromString(granularityStr);
 * compatible open source license.
    @Override
        HOUR(ChronoUnit.HOURS),
    /**
import java.time.ZoneOffset;
                Object existingRouting = document.getFieldValue("_routing", Object.class, true);
     * Truncates datetime to the specified granularity
            // Validate date format
                int weekOfYear = truncated.get(java.time.temporal.WeekFields.ISO.weekOfWeekBasedYear());
                    + "-"
    }
            case WEEK:
    public static final String TYPE = "temporal_routing";
            case HOUR:
                format,
     * and optionally hashing for distribution
            byte[] bucketBytes = temporalBucket.getBytes(StandardCharsets.UTF_8);
    private final Granularity granularity;
     * Factory for creating TemporalRoutingProcessor instances
         * Parses a string value to a Granularity enum
        @Override
            String tag,
 * based on time-based patterns for log and metrics workloads.
    }
 * SPDX-License-Identifier: Apache-2.0
                // Use ISO week format: YYYY-WNN
        return temporalBucket;
import org.opensearch.ingest.Processor;
import org.opensearch.core.common.Strings;
        /**
                return dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
        }
                throw new IllegalArgumentException("Unsupported granularity: " + granularity);
        switch (granularity) {
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "ignore_missing", false);
import org.opensearch.ingest.IngestDocument;
    private String computeRoutingValue(String timestamp) {
                    + String.format(Locale.ROOT, "%02d", truncated.getMonthValue())
    public String getType() {
        }
            Granularity granularity;
    private String createTemporalBucketKey(ZonedDateTime truncated) {
         * @param value the string representation of the granularity
     */
 * This processor extracts a timestamp from a specified field, truncates it
                throw new IllegalArgumentException("Unsupported granularity: " + granularity);
        this.granularity = granularity;
 */
                return weekYear + "-W" + String.format(Locale.ROOT, "%02d", weekOfYear);
                return valueOf(value.toUpperCase(Locale.ROOT));
        return document;
        DAY(ChronoUnit.DAYS),
                    + "-"
        return timestampField;
                ZonedDateTime dayTruncated = dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
     * can share code more easily.
     *
            Map<String, Object> config
    Granularity getGranularity() {
            case MONTH:
            Map<String, Processor.Factory> processorFactories,
        String temporalBucket = createTemporalBucketKey(truncated);
        switch (granularity) {
            } catch (IllegalArgumentException e) {
     * IMPORTANT: This logic MUST be kept in sync with TemporalRoutingSearchProcessor.createTemporalBucket()
import org.opensearch.ingest.ConfigurationUtils;
                return dayTruncated.with(java.time.temporal.TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        WEEK(ChronoUnit.WEEKS),
    boolean isIgnoreMissing() {
            }
            // Set default format if not provided
                throw new IllegalArgumentException("Invalid granularity: " + value + ". Supported values are: hour, day, week, month");
/**
 * to a configurable granularity (hour/day/week/month), and uses the resulting
            case WEEK:
                timestampField,
        return ignoreMissing;
                DateFormatter.forPattern(format);
            try {
    @Override
        ZonedDateTime truncated = truncateToGranularity(dateTime);
    DateFormatter getDateFormatter() {
         * Gets the ChronoUnit associated with this granularity
        // Optionally hash for distribution
        ) throws Exception {
                ignoreMissing,
import java.util.Map;
    }
import org.opensearch.common.hash.MurmurHash3;
 *
        this.hashBucket = hashBucket;
            }
                overrideExisting,
        }
        }
        public static Granularity fromString(String value) {
            }
         */
                    + String.format(Locale.ROOT, "%02d", truncated.getMonthValue())
        /** Week granularity for weekly bucketing (ISO week) */
        /**
                    + String.format(Locale.ROOT, "%02d", truncated.getDayOfMonth());
 * this file be licensed under the Apache-2.0 license or a
        return granularity;
        document.setFieldValue("_routing", routingValue);
            } catch (Exception e) {
    TemporalRoutingProcessor(
            @Nullable String description,
        // Check if routing already exists and we shouldn't override
        this.dateFormatter = DateFormatter.forPattern(format);
            return new TemporalRoutingProcessor(
                return truncated.getYear()
        /** Hour granularity for hourly bucketing */
    /**
    boolean isHashBucket() {
         * @return the corresponding Granularity enum value
}
        this.timestampField = timestampField;
            try {
        return dateFormatter;
    public static final class Factory implements Processor.Factory {
            boolean overrideExisting = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "override_existing", true);
        public TemporalRoutingProcessor create(
     * Creates a string key for the temporal bucket
                return truncated.getYear() + "-" + String.format(Locale.ROOT, "%02d", truncated.getMonthValue());
            if (Strings.isNullOrEmpty(timestampField)) {
    private ZonedDateTime truncateToGranularity(ZonedDateTime dateTime) {
        TemporalAccessor accessor = dateFormatter.parse(timestamp);
                if (existingRouting != null) {
            default:
    private final boolean ignoreMissing;
import java.time.temporal.TemporalAccessor;
 * temporal bucket to compute a routing value for improved temporal locality.
    String getTimestampField() {
    private final boolean hashBucket;
        if (timestampValue == null) {
import java.time.temporal.ChronoUnit;
import org.opensearch.common.Nullable;
    boolean isOverrideExisting() {
            default:
    }
        public ChronoUnit getChronoUnit() {
     * in the search-pipeline-common module to ensure consistent temporal bucketing.
            this.chronoUnit = chronoUnit;
            try {
                tag,
 * Introduced in OpenSearch 3.2.0 to enable intelligent document co-location
        // Parse timestamp using DateFormatter and convert to ZonedDateTime
                    + "T"
        if (timestampValue == null && ignoreMissing) {
 */
                throw newConfigurationException(TYPE, tag, "granularity", e.getMessage());
            return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));
        return overrideExisting;
                    + "-"
                    + "-"
        Granularity(ChronoUnit chronoUnit) {
        if (!overrideExisting) {
 *
            } catch (IllegalArgumentException e) {
 * The OpenSearch Contributors require contributions made to
     */
        boolean hashBucket
        this.overrideExisting = overrideExisting;
            case DAY:
     * IMPORTANT: This logic MUST be kept in sync with TemporalRoutingSearchProcessor.truncateToGranularity()
    private final String timestampField;
            if (format == null) {
     *
        String timestampField,
            );
     */
     * in the search-pipeline-common module. Both processors must generate identical bucket keys for the
    }
import org.opensearch.common.time.DateFormatter;
                }
     * Supported temporal granularities
            long hash = MurmurHash3.hash128(bucketBytes, 0, bucketBytes.length, 0, new MurmurHash3.Hash128()).h1;
        String routingValue = computeRoutingValue(timestampValue.toString());
        }
            String timestampField = ConfigurationUtils.readStringProperty(TYPE, tag, config, "timestamp_field");
    }
                description,
        super(tag, description);
import org.opensearch.ingest.AbstractProcessor;
            return document;
        boolean ignoreMissing,
                return truncated.getYear()
                throw newConfigurationException(TYPE, tag, "timestamp_field", "cannot be null or empty");
                return dateTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
                granularity,
        ZonedDateTime dateTime = DateFormatters.from(accessor, Locale.ROOT, ZoneOffset.UTC);
import java.util.Locale;
            case HOUR:
     * TODO: Consider moving this shared logic to a common module when search and ingest pipelines
            boolean hashBucket = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "hash_bucket", false);
        return TYPE;
            try {
    /**
        return hashBucket;
            return chronoUnit;
            // Validation
import java.nio.charset.StandardCharsets;
package org.opensearch.ingest.common;
    /**
                    return document;
 *
        private final ChronoUnit chronoUnit;
        String format,
            }
                return dateTime.withMinute(0).withSecond(0).withNano(0);
                // Field doesn't exist, continue with processing
        }
            }
        }
     */
