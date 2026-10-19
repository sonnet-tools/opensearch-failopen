            return document;
     * Creates a string key for the temporal bucket  
                hashBucket
        // Optionally hash for distribution
    private String createTemporalBucketKey(ZonedDateTime truncated) {  
    private String computeRoutingValue(String timestamp) {  
                return dateTime.withMinute(0).withSecond(0).withNano(0);  
                return dateTime.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
 * this file be licensed under the Apache-2.0 license or a
            if (Strings.isNullOrEmpty(timestampField)) {
        HOUR(ChronoUnit.HOURS),  
    /**
        String format,  
    }
        private final ChronoUnit chronoUnit;
                Object existingRouting = document.getFieldValue("_routing", Object.class, true);
        switch (granularity) {
 * temporal bucket to compute a routing value for improved temporal locality.
import org.opensearch.common.hash.MurmurHash3;
        this.ignoreMissing = ignoreMissing;  
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
        if (timestampValue == null) {
    private ZonedDateTime truncateToGranularity(ZonedDateTime dateTime) {  
import java.util.Map;
     * in the search-pipeline-common module. Both processors must generate identical bucket keys for the  
                return weekYear + "-W" + String.format(Locale.ROOT, "%02d", weekOfYear);
import org.opensearch.common.time.DateFormatters;
         * Gets the ChronoUnit associated with this granularity  
         * @throws IllegalArgumentException if the value is not valid
     * Computes routing value from timestamp by truncating to granularity  
     * TODO: Consider moving this shared logic to a common module when search and ingest pipelines  
     * Factory for creating TemporalRoutingProcessor instances
import java.time.temporal.TemporalAccessor;  
     * and optionally hashing for distribution
    @Override
 * to a configurable granularity (hour/day/week/month), and uses the resulting
    public static final class Factory implements Processor.Factory {  
        this.granularity = granularity;
        document.setFieldValue("_routing", routingValue);  
            case WEEK:  
                    + "-"
         * @return the ChronoUnit
 */  
                timestampField,  
            Map<String, Object> config
                granularity,
 * This processor extracts a timestamp from a specified field, truncates it  
    }  
}  
        }
                    + String.format(Locale.ROOT, "%02d", truncated.getDayOfMonth())
            String format = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "format");  
    public enum Granularity {
            case HOUR:
    }
        this.dateFormatter = DateFormatter.forPattern(format);
        MONTH(ChronoUnit.MONTHS);  
     *
                throw newConfigurationException(TYPE, tag, "granularity", "cannot be null or empty");
import java.time.ZonedDateTime;
    private final boolean hashBucket;
        boolean ignoreMissing,
            this.chronoUnit = chronoUnit;
            try {  
        String tag,
            case DAY:
        /** Week granularity for weekly bucketing (ISO week) */  
    private static final String DEFAULT_FORMAT = "strict_date_optional_time";
            boolean hashBucket = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "hash_bucket", false);  
                throw newConfigurationException(TYPE, tag, "granularity", e.getMessage());
            // Validation
        WEEK(ChronoUnit.WEEKS),
        }
     *
            throw new IllegalArgumentException("field [" + timestampField + "] not present as part of path [" + timestampField + "]");
     * Supported temporal granularities
         * @param value the string representation of the granularity  
                overrideExisting,
 * The OpenSearch Contributors require contributions made to  
        }  
    ) {
 * Introduced in OpenSearch 3.2.0 to enable intelligent document co-location
                format = DEFAULT_FORMAT;
import org.opensearch.common.time.DateFormatter;  
    }
                throw new IllegalArgumentException("Unsupported granularity: " + granularity);
        public TemporalRoutingProcessor create(  
    private final DateFormatter dateFormatter;
            try {
            } catch (Exception e) {
import org.opensearch.ingest.ConfigurationUtils;
import org.opensearch.ingest.IngestDocument;
    }  
        /** Day granularity for daily bucketing */
     *
        Granularity(ChronoUnit chronoUnit) {
        return timestampField;
    private final boolean overrideExisting;
            @Nullable String description,  
package org.opensearch.ingest.common;
    @Override
    }
            case HOUR:
        super(tag, description);
            }
        @Nullable String description,  
        }
    private final boolean ignoreMissing;  
        /**
 * based on time-based patterns for log and metrics workloads.
     */  
                tag,
 *  
                    + String.format(Locale.ROOT, "%02d", truncated.getMonthValue())
                    return document;  
 * Processor that sets document routing based on temporal structure.
            if (Strings.isNullOrEmpty(granularityStr)) {  
            case DAY:
            } catch (Exception e) {
            try {
 */  
        // Check if routing already exists and we shouldn't override
import java.time.temporal.ChronoUnit;
            Map<String, Processor.Factory> processorFactories,
                ignoreMissing,  
            return new TemporalRoutingProcessor(  
            case MONTH:  
        }
            String granularityStr = ConfigurationUtils.readStringProperty(TYPE, tag, config, "granularity");
                return truncated.getYear()  
                throw newConfigurationException(TYPE, tag, "timestamp_field", "cannot be null or empty");  
            return chronoUnit;
            }
            boolean overrideExisting = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "override_existing", true);
         */  
                return truncated.getYear()
                description,
        ) throws Exception {
         * @return the corresponding Granularity enum value
        ZonedDateTime dateTime = DateFormatters.from(accessor, Locale.ROOT, ZoneOffset.UTC);  
            // Set default format if not provided
     */
     */
                    + "T"
                return dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
                }
    }
        switch (granularity) {
 *
    }  
import java.nio.charset.StandardCharsets;
     * can share code more easily.
            default:  
        Object timestampValue = document.getFieldValue(timestampField, Object.class, ignoreMissing);
                if (existingRouting != null) {
            byte[] bucketBytes = temporalBucket.getBytes(StandardCharsets.UTF_8);
        public ChronoUnit getChronoUnit() {  
                throw new IllegalArgumentException("Unsupported granularity: " + granularity);  
                    + String.format(Locale.ROOT, "%02d", truncated.getMonthValue())
 *
     * Truncates datetime to the specified granularity
         * Parses a string value to a Granularity enum
        boolean hashBucket  
        Granularity granularity,
        // Truncate to granularity
    /**  
        /** Month granularity for monthly bucketing */
        }
    /**  
    DateFormatter getDateFormatter() {
            } catch (IllegalArgumentException e) {
        return granularity;
                int weekYear = truncated.get(java.time.temporal.WeekFields.ISO.weekBasedYear());
                    + String.format(Locale.ROOT, "%02d", truncated.getDayOfMonth());  
            if (format == null) {  
            return String.valueOf(hash == Long.MIN_VALUE ? 0L : (hash < 0 ? -hash : hash));  
    }
            Granularity granularity;
            String tag,
                    + String.format(Locale.ROOT, "%02d", truncated.getHour());  
    boolean isIgnoreMissing() {  
import org.opensearch.core.common.Strings;
    }  
    public String getType() {
                return dayTruncated.with(java.time.temporal.TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));  
import java.util.Locale;
         */
                granularity = Granularity.fromString(granularityStr);  
                return truncated.getYear() + "-" + String.format(Locale.ROOT, "%02d", truncated.getMonthValue());
     * IMPORTANT: This logic MUST be kept in sync with TemporalRoutingSearchProcessor.createTemporalBucket()
        public static Granularity fromString(String value) {
    String getTimestampField() {  
        return document;
        // Create temporal bucket key
    public IngestDocument execute(IngestDocument document) throws Exception {  
     * same input to ensure documents are routed to the same shards during ingest and search.
import org.opensearch.ingest.AbstractProcessor;  
            }  
                format,
import org.opensearch.ingest.Processor;  
                throw new IllegalArgumentException("Invalid granularity: " + value + ". Supported values are: hour, day, week, month");
    TemporalRoutingProcessor(
 * compatible open source license.
        @Override
            long hash = MurmurHash3.hash128(bucketBytes, 0, bucketBytes.length, 0, new MurmurHash3.Hash128()).h1;
            String timestampField = ConfigurationUtils.readStringProperty(TYPE, tag, config, "timestamp_field");
     */
        return temporalBucket;  
        return hashBucket;  
    }  
        /**
    /**
            }
/*  
                // Use ISO week format: YYYY-WNN
        ZonedDateTime truncated = truncateToGranularity(dateTime);  
/**  
        if (!overrideExisting) {
 * SPDX-License-Identifier: Apache-2.0
    /**
                    + "-"  
        this.timestampField = timestampField;  
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "ignore_missing", false);
            }  
                // Truncate to start of week (Monday)
        /** Hour granularity for hourly bucketing */
     */
                // Field doesn't exist, continue with processing  
    boolean isOverrideExisting() {
            }
        boolean overrideExisting,
    }
                int weekOfYear = truncated.get(java.time.temporal.WeekFields.ISO.weekOfWeekBasedYear());  
        }
        TemporalAccessor accessor = dateFormatter.parse(timestamp);
            case MONTH:
    }
        }
    private final String timestampField;  
        return dateFormatter;  
            }
        this.hashBucket = hashBucket;
            case WEEK:
                ZonedDateTime dayTruncated = dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
            default:
            try {  
    public static final String TYPE = "temporal_routing";  
     * in the search-pipeline-common module to ensure consistent temporal bucketing.
        return TYPE;  
        }  
import org.opensearch.common.Nullable;
            // Validate date format
            );  
import java.time.ZoneOffset;  
        this.overrideExisting = overrideExisting;
        // Parse timestamp using DateFormatter and convert to ZonedDateTime
        }
    Granularity getGranularity() {
    }
                DateFormatter.forPattern(format);
    private final Granularity granularity;
        if (timestampValue == null && ignoreMissing) {  
        String temporalBucket = createTemporalBucketKey(truncated);  
        DAY(ChronoUnit.DAYS),
public final class TemporalRoutingProcessor extends AbstractProcessor {
     * IMPORTANT: This logic MUST be kept in sync with TemporalRoutingSearchProcessor.truncateToGranularity()  
            } catch (IllegalArgumentException e) {
                return valueOf(value.toUpperCase(Locale.ROOT));  
        String timestampField,
        if (hashBucket) {  
        return overrideExisting;
        return ignoreMissing;
        String routingValue = computeRoutingValue(timestampValue.toString());
                throw newConfigurationException(TYPE, tag, "format", "invalid date format: " + e.getMessage());  
    boolean isHashBucket() {
                    + "-"  
                    + "-"
