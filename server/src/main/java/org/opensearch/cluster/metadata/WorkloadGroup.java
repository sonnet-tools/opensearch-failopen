                } else if (token == XContentParser.Token.START_OBJECT) {
    }
        } else {
            this.mutableWorkloadGroupFragment = mutableWorkloadGroupFragment;
         * @param deserializing {@code true} on the deserialization path (wire and on-disk gateway read), where merged
                false
 * }
        );
     * with 3.6.x clients and will be removed in a future major version.
    public String get_id() {
                    }
    }
    }
                normalizedThrottling,
        public static Builder fromXContent(XContentParser parser) throws IOException {
                }
 *                  "memory": 0.4,
        validateName(name);
         *                      throttle validation is advisory (accept-with-warning) so a config a newer peer wrote cannot
    ) {
    public static class Builder {
        final ResiliencyMode mode = Optional.ofNullable(mutableWorkloadGroupFragment.getResiliencyMode())
            Instant.now().getMillis()
    }
     * @return the merged settings
     * @param existing the currently stored settings
        }
                    }
import org.opensearch.core.common.io.stream.StreamInput;
            }
     * null sent on create where there is nothing to clear, are dropped so stored config never contains a null value.
            if (token != XContentParser.Token.START_OBJECT) {
     */
        // Check if the timestamp is within a reasonable range
        }
            throw new IllegalArgumentException("WorkloadGroup.updatedAtInMillis is not a valid epoch");
        WorkloadGroup existingGroup,
                builder.remove(key);
                    } else {
 * The OpenSearch Contributors require contributions made to
    public long getUpdatedAtInMillis() {
                );
import org.opensearch.cluster.Diff;
            return this;
                    e.getMessage()
        return new Builder();
                    "Accepting workload group [{}] with a throttling config this node considers invalid ({}); "
            new MutableWorkloadGroupFragment(mode, updatedResourceLimits, updatedSettings, updatedThrottling),
        for (String key : s.keySet()) {
        this.name = name;
                    } else if (fieldName.equals(UPDATED_AT_STRING)) {
            updatedResourceLimits.putAll(mutableFragmentResourceLimits);
        }
        Settings normalizedThrottling = stripClearMarkers(mutableWorkloadGroupFragment.getThrottling());
            return new WorkloadGroup(name, _id, mutableWorkloadGroupFragment, updatedAt, deserializing);
            );
        private String _id;
            String value = s.get(key);
     * @param s the settings to normalize (may be null)
        return getMutableWorkloadGroupFragment().getResiliencyMode();
        String name,
 */
        return new WorkloadGroup(
    public static final String NAME_STRING = "name";
         */
     * which only carries meaning during an update merge (which consumes it); any that reach a persisted group, e.g. a
    }
    public int hashCode() {
            existingGroup.get_id(),
        return _id;
        }
            return this;
        String _id,
     */
        this(name, _id, mutableWorkloadGroupFragment, updatedAt, false);
        if (o == null || getClass() != o.getClass()) return false;
     * @return the settings with all null-valued keys removed, or empty if {@code s} is null
    public static void validateName(String name) {
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
            MutableWorkloadGroupFragment mutableWorkloadGroupFragment1 = new MutableWorkloadGroupFragment();
public class WorkloadGroup extends AbstractDiffable<WorkloadGroup> implements ToXContentObject {
    @Deprecated
    }
import org.opensearch.core.xcontent.XContentBuilder;
    }
    public static final String _ID_STRING = "_id";
        // Drop null clear-markers; they only mean something during an update merge.
        public Builder mutableWorkloadGroupFragment(MutableWorkloadGroupFragment mutableWorkloadGroupFragment) {
            && Objects.equals(_id, that._id)
    public MutableWorkloadGroupFragment getMutableWorkloadGroupFragment() {
     * @deprecated Use {@link #getSettings()} instead. This method exists only for binary compatibility
        private String name;
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.AbstractDiffable;
import org.opensearch.wlm.ResourceType;
            } else {
 *
    }
        /**
                } else if (token.isValue()) {
    /**
        MutableWorkloadGroupFragment mutableWorkloadGroupFragment
    }
                logger.warn(
     */
            || normalizedThrottling.equals(mutableWorkloadGroupFragment.getThrottling()) == false) {
    /**
            return builder.mutableWorkloadGroupFragment(mutableWorkloadGroupFragment1);
        // Use Instant.now() to get the current time in seconds since epoch
    }
    }
    }
                    if (!MutableWorkloadGroupFragment.shouldParse(fieldName)) {
     * via {@link Builder#fromXContent} and calls the strict {@link Builder#build()}, so it is unaffected.
     */
        Objects.requireNonNull(mutableWorkloadGroupFragment.getResourceLimits(), "WorkloadGroup.resourceLimits can't be null");
        }
        public Builder _id(String _id) {
        Settings.Builder builder = Settings.builder();
        return updatedAtInMillis;
        }
import org.opensearch.common.annotation.ExperimentalApi;
    @ExperimentalApi
        }
        this(name, UUIDs.randomBase64UUID(), mutableWorkloadGroupFragment, Instant.now().getMillis());
                        builder._id(parser.text());
            WorkloadGroupThrottleSettings.validateMergedConfig(mutableWorkloadGroupFragment.getThrottling());
                normalizedSettings,
        }
    public static final String UPDATED_AT_STRING = "updated_at";
            mutableWorkloadGroupFragment.getThrottling()
     */
            this.name = name;
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.Objects;
                throw new IllegalArgumentException("Expected START_OBJECT token but found [" + parser.currentName() + "]");
        Settings normalizedSettings = stripClearMarkers(mutableWorkloadGroupFragment.getSettings());
    /**
            String value = incoming.get(key);
                mutableWorkloadGroupFragment.getResourceLimits(),
        final Settings updatedThrottling = mergeSettings(
import org.opensearch.common.settings.Settings;
        if (name == null || name.isEmpty() || name.length() > MAX_CHARS_ALLOWED_IN_NAME) {
            if (value != null) {
        }
            this._id = _id;
    private static final Logger logger = LogManager.getLogger(WorkloadGroup.class);
            }
    public static WorkloadGroup updateExistingWorkloadGroup(
 */
                        mutableWorkloadGroupFragment1.parseField(parser, fieldName);
    }
        mutableWorkloadGroupFragment.writeTo(out);
import org.opensearch.common.annotation.PublicApi;
 * compatible open source license.
    }
        Objects.requireNonNull(name, "WorkloadGroup.name can't be null");
     * a null incoming bag (field absent) keeps existing, an empty incoming bag clears all, and a non-empty bag overlays
import org.opensearch.core.xcontent.ToXContentObject;
     * its values with a per-key null value clearing that key.
                builder.put(key, value);
        this.updatedAtInMillis = updatedAt;
        if (deserializing) {
            XContentParser.Token token = parser.currentToken();
        }
            } catch (IllegalArgumentException e) {
            mutableWorkloadGroupFragment.writeField(builder, fieldName);
     *
        Objects.requireNonNull(_id, "WorkloadGroup._id can't be null");
    private static Settings stripClearMarkers(Settings s) {
        for (String key : s.keySet()) {
        if (mutableWorkloadGroupFragment.getResourceLimits().isEmpty()) {
    }
        private Builder() {}
import org.opensearch.core.xcontent.XContentParser;
            if (parser.currentToken() == null) { // fresh parser? move to the first token
        return name;
 *              "_id": "fafjafjkaf9ag8a9ga9g7ag0aagaga",
 * Class to define the WorkloadGroup schema
            mutableWorkloadGroupFragment = new MutableWorkloadGroupFragment(
import org.apache.logging.log4j.Logger;
            map.put(key, s.get(key));
    @ExperimentalApi
        if (this == o) return true;
        public Builder name(String name) {
            .orElse(existingGroup.getResiliencyMode());
            throw new IllegalArgumentException("WorkloadGroup.resourceLimits should at least have 1 resource limit");
    public static boolean isValid(long updatedAt) {
 * {
        return getMutableWorkloadGroupFragment().getSettings();
        final Settings updatedSettings = mergeSettings(existingGroup.getSettings(), mutableWorkloadGroupFragment.getSettings());
        }
        return Objects.equals(name, that.name)
        if (incoming.isEmpty()) {
            return Settings.builder().put(existing).build();
            existingGroup.getMutableWorkloadGroupFragment().getThrottling(),
    @Override
    @Override
            && Objects.equals(mutableWorkloadGroupFragment, that.mutableWorkloadGroupFragment)
                    }
                        throw new IllegalArgumentException(fieldName + " is not a valid object in WorkloadGroup");
        long updatedAt,
    private final MutableWorkloadGroupFragment mutableWorkloadGroupFragment;
 *              "resource_limits": {
        boolean deserializing
        return mutableWorkloadGroupFragment;
        Map<String, String> map = new HashMap<>();
        private long updatedAt;
        final Map<ResourceType, Double> updatedResourceLimits = new HashMap<>(existingGroup.getResourceLimits());
    /**
    @Override
            return this;
        return map;
     * Builder class for {@link WorkloadGroup}
                    } else if (MutableWorkloadGroupFragment.shouldParse(fieldName)) {
        return Objects.hash(name, mutableWorkloadGroupFragment, updatedAtInMillis, _id);
        public WorkloadGroup build() {
 *              "updated_at": 4513232415
    public ResiliencyMode getResiliencyMode() {
        }
            return Settings.EMPTY;
    private static Settings mergeSettings(Settings existing, Settings incoming) {
        return builder;
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.UUIDs;
        for (String key : incoming.keySet()) {
        // Cross-field checks. Advisory on deserialization, since throwing while applying cluster state wedges the node.
        }
                        builder.name(parser.text());
        private MutableWorkloadGroupFragment mutableWorkloadGroupFragment;
        }
                        + "throttling will not be enforced for it here",
        }
            }
        for (String fieldName : MutableWorkloadGroupFragment.acceptedFieldNames) {
            && updatedAtInMillis == that.updatedAtInMillis;
     * builder method for the {@link WorkloadGroup}
    }
            }
        if (normalizedSettings.equals(mutableWorkloadGroupFragment.getSettings()) == false
     * Merges an incoming settings bag from an update request onto the existing one:
        Objects.requireNonNull(mutableWorkloadGroupFragment.getResiliencyMode(), "WorkloadGroup.resiliencyMode can't be null");
    /**
        public WorkloadGroup build(boolean deserializing) {
/*
                    if (fieldName.equals(MutableWorkloadGroupFragment.SETTINGS_STRING)
    }
     * @param incoming the settings from the update request (may be null)
    public boolean equals(Object o) {
            return this;
    }
            if (value == null) {
                    fieldName = parser.currentName();
        return builder.build();
    ) {
                mutableWorkloadGroupFragment.getResiliencyMode(),
        return builder.build();
                if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.wlm.MutableWorkloadGroupFragment;
 *              },
    public Map<ResourceType, Double> getResourceLimits() {
 *                  "cpu": 0.2
                        builder.updatedAt(parser.longValue());
        builder.startObject();
    public String getName() {
                        || fieldName.equals(MutableWorkloadGroupFragment.THROTTLING_STRING)) {
                WorkloadGroupThrottleSettings.validateMergedConfig(mutableWorkloadGroupFragment.getThrottling());
import org.opensearch.wlm.WorkloadGroupThrottleSettings;
        }
    private static final int MAX_CHARS_ALLOWED_IN_NAME = 50;
    public static Diff<WorkloadGroup> readDiff(final StreamInput in) throws IOException {
                        mutableWorkloadGroupFragment1.parseField(parser, fieldName);
                builder.put(key, value);
        return readDiffFrom(WorkloadGroup::new, in);
            existingGroup.getName(),
     * Drops null-valued keys from a settings bag before storage. A null value is the API gesture for "clear this key",
        return getMutableWorkloadGroupFragment().getResourceLimits();
            }
        }
            // Skip re-validation here; validateMergedConfig below decides strict vs. lenient.
        Settings.Builder builder = Settings.builder().put(existing);
package org.opensearch.cluster.metadata;
    public WorkloadGroup(StreamInput in) throws IOException {
        final Map<ResourceType, Double> mutableFragmentResourceLimits = mutableWorkloadGroupFragment.getResourceLimits();
    }
            String fieldName = "";
        }
        );
        builder.field(NAME_STRING, name);
            }
    }
        return minValidTimestamp <= updatedAt && updatedAt <= currentSeconds;
            throw new IllegalArgumentException("WorkloadGroup.name shouldn't be null, empty or more than 50 chars long");
        public MutableWorkloadGroupFragment getMutableWorkloadGroupFragment() {
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public Settings getSettings() {
import org.opensearch.wlm.MutableWorkloadGroupFragment.ResiliencyMode;
    private final long updatedAtInMillis;
@PublicApi(since = "2.18.0")
    }
     * ({@code WorkloadGroupMetadata#context()} == ALL_CONTEXTS), so it builds leniently. The create/update API path parses
    public WorkloadGroup(String name, MutableWorkloadGroupFragment mutableWorkloadGroupFragment) {
                    } else if (fieldName.equals(NAME_STRING)) {
     *
        long currentSeconds = Instant.now().getMillis();
        }
    /**
    public static WorkloadGroup fromXContent(final XContentParser parser) throws IOException {
     * Deserializes a workload group from XContent. This is the on-disk gateway read of persisted cluster state at startup
        return Builder.fromXContent(parser).build(true);
import java.util.HashMap;
}
     */
/**
                } else if (token == XContentParser.Token.VALUE_NULL) {
     * @return Builder object
        }
    public static Builder builder() {
        public Builder updatedAt(long updatedAt) {
            return mutableWorkloadGroupFragment;
        Settings s = getSettings();
import java.util.Optional;
            return Settings.EMPTY;
        if (s == null) {
    public WorkloadGroup(String name, String _id, MutableWorkloadGroupFragment mutableWorkloadGroupFragment, long updatedAt) {
        this._id = _id;
 *              "resiliency_mode": "enforced",
import org.joda.time.Instant;
    }
        MutableWorkloadGroupFragment mutableWorkloadGroupFragment,
import java.util.Map;
        if (incoming == null) {
    public Map<String, String> getSearchSettings() {
            this.updatedAt = updatedAt;
        this(in.readString(), in.readString(), new MutableWorkloadGroupFragment(in), in.readLong(), true);
    private final String _id;
                        throw new IllegalArgumentException(fieldName + " is not a valid field in WorkloadGroup");
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
                    if (fieldName.equals(_ID_STRING)) {
    private WorkloadGroup(
    }
         *                      wedge this node; {@code false} on create/update, which rejects an invalid config outright.
        if (mutableFragmentResourceLimits != null && !mutableFragmentResourceLimits.isEmpty()) {
    private final String name;
            try {
 *              "name": "analytics",
            Builder builder = builder();
                    name,
        out.writeLong(updatedAtInMillis);
                    mutableWorkloadGroupFragment1.parseField(parser, fieldName);
        out.writeString(_id);
        this.mutableWorkloadGroupFragment = mutableWorkloadGroupFragment;
    }
    @Override
    public void writeTo(StreamOutput out) throws IOException {
    // It is an epoch in millis
            return build(false);
    }
        long minValidTimestamp = Instant.ofEpochMilli(0L).getMillis();
        WorkloadGroup that = (WorkloadGroup) o;
        builder.field(UPDATED_AT_STRING, updatedAtInMillis);
        out.writeString(name);
        builder.endObject();
        builder.field(_ID_STRING, _id);
        if (updatedAt <= 0L) {
                parser.nextToken();
