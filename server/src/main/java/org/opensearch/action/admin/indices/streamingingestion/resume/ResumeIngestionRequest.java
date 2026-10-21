                if (parser.currentToken() != XContentParser.Token.START_ARRAY) {
     * Sets the indices to be resumed
        super.writeTo(out);
                }
    }
     * For example indices that don't exist.
    @Override
                    throw new IllegalArgumentException("Expected START_ARRAY for 'reset_settings'");
import static org.opensearch.action.ValidateActions.addValidationError;
            ResetMode mode = null;
        public enum ResetMode {
        return new ResumeIngestionRequest(indices, resetSettingsList.toArray(new ResetSettings[0]));
    /**
        }
    @Override
                );
import org.opensearch.action.ActionRequestValidationException;
    public ResumeIngestionRequest(String[] indices) {
 */
    }
            }
            validationException = addValidationError("index is missing", validationException);
     * @return the request itself
                throw new IllegalArgumentException("Expected START_OBJECT for ResetSettings but got: " + parser.currentToken());
         * mode supports a timestamp in milliseconds that will be used to retrieve corresponding offset.
        this.indices = indices;
 */
     * Represents reset settings for a given shard to be applied as part of resume operation.
        public String getValue() {
     */
        @Override
                        }
            throw new IllegalArgumentException("Expected START_OBJECT but got: " + parser.currentToken());
    /**
import java.util.ArrayList;
        out.writeArray(resetSettings);
 *
     * For example indices that don't exist.
            int shard = -1;
import org.opensearch.common.annotation.PublicApi;
        }
        return indices;
     */
        }
        if (CollectionUtils.isEmpty(indices)) {
     */
            out.writeVInt(shard);
    }
                            throw new IllegalArgumentException("Invalid value for 'mode': " + parser.text());
    }
 * @opensearch.api
        /**
import org.opensearch.core.common.io.stream.StreamInput;
            if (shard < 0 || mode == null || value == null) {
         */
    @PublicApi(since = "3.6.0")
    }
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
    }
    @Override
        }
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
                String fieldName = parser.currentName();
        public ResetMode getMode() {
import java.util.Locale;
                .anyMatch(
    /**
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
            if (RESET_SETTINGS.equals(currentFieldName)) {
            }
        this(indices, new ResetSettings[0]);
                switch (fieldName) {
    }
        this.indices = indices;
            out.writeEnum(mode);
    public static ResumeIngestionRequest fromXContent(String[] indices, XContentParser parser) throws IOException {
                    resetSettings -> resetSettings.getShard() < 0 || resetSettings.getMode() == null || resetSettings.getValue() == null
     * @opensearch.api
     */
    }
        ArrayList<ResetSettings> resetSettingsList = new ArrayList<>();
    /**
         * Reset options for Resume API. Offset mode supports kafka offsets or Kinesis sequence numbers and timestamp
        this.indices = in.readStringArray();
        super(in);
    }
        ActionRequestValidationException validationException = null;
}
                    case "value" -> value = parser.text();
@PublicApi(since = "3.6.0")
            this.value = in.readString();
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
        this.indicesOptions = IndicesOptions.readIndicesOptions(in);
                validationException = addValidationError("ResetSettings is missing either shard, mode or value", validationException);
import java.util.Arrays;
     * Constructs a new resume ingestion request.
                }
/*
            TIMESTAMP
    public ResumeIngestionRequest indices(String... indices) {
     * Constructs a new resume ingestion request with reset settings.
                throw new IllegalArgumentException("Unexpected field: " + currentFieldName);
                    case "mode" -> {
            this.mode = mode;
import org.opensearch.action.IndicesRequest;
    }
import java.io.IOException;
            parser.nextToken();
                    default -> throw new IllegalArgumentException("Unexpected field in ResetSettings: " + fieldName);
            out.writeString(value);
 * this file be licensed under the Apache-2.0 license or a
            this.value = value;
            }
        private final ResetMode mode;
    public void writeTo(StreamOutput out) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
                    }
            boolean invalidResetSettingsFound = Arrays.stream(resetSettings)
    public static final String RESET_SETTINGS = "reset_settings";
    /**
        this.resetSettings = resetSettings;
                }
    public String[] indices() {
            this.shard = in.readVInt();
            return value;
        if (parser.currentToken() == null) {
     * @return the desired behaviour regarding indices to ignore and wildcard indices expressions
    }
        public void writeTo(StreamOutput out) throws IOException {
     */
        }
     * The indices to be resumed
            }
        public ResetSettings(int shard, ResetMode mode, String value) {
                    "Missing required fields in ResetSettings: shard=" + shard + ", mode=" + mode + ", value=" + value
                );
    /**
public class ResumeIngestionRequest extends AcknowledgedRequest<ResumeIngestionRequest> implements IndicesRequest.Replaceable {
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
     */
            if (invalidResetSettingsFound) {
            this.mode = in.readEnum(ResetMode.class);
        }
    public ResumeIngestionRequest indicesOptions(IndicesOptions indicesOptions) {
/**
        return indicesOptions;
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.
        return validationException;
 * The OpenSearch Contributors require contributions made to
                throw new IllegalArgumentException(
        private final int shard;
 * A request to resume ingestion.
        public ResetSettings(StreamInput in) throws IOException {
 * compatible open source license.
            if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
import org.opensearch.core.xcontent.XContentParser;
                            mode = ResetMode.valueOf(parser.text().toUpperCase(Locale.ROOT));
            return mode;
    @Override
                    resetSettingsList.add(ResetSettings.fromXContent(parser));
        }
import org.opensearch.core.common.io.stream.Writeable;
        private final String value;
        @PublicApi(since = "3.6.0")
            parser.nextToken();
     *
    private String[] indices;
        indicesOptions.writeIndicesOptions(out);
            OFFSET,
                        } catch (IllegalArgumentException e) {
    public IndicesOptions indicesOptions() {
import org.opensearch.core.common.util.CollectionUtils;
        public int getShard() {
    private ResetSettings[] resetSettings;
        out.writeStringArray(indices);
            this.shard = shard;
        this.resetSettings = in.readArray(ResetSettings::new, ResetSettings[]::new);
            String currentFieldName = parser.currentName();
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions
        }
    public ActionRequestValidationException validate() {
            String value = null;
        if (resetSettings.length > 0) {
        }
        return this;
 *
        }
    public ResumeIngestionRequest(String[] indices, ResetSettings[] resetSettings) {
    public ResumeIngestionRequest(StreamInput in) throws IOException {
import org.opensearch.action.support.IndicesOptions;
    /**
     */
        }
        return resetSettings;
            } else {
        }
                parser.nextToken();
                        try {
    }
            return shard;
            return new ResetSettings(shard, mode, value);
     *
    public ResetSettings[] getResetSettings() {
        return this;
                    case "shard" -> shard = parser.intValue();
package org.opensearch.action.admin.indices.streamingingestion.resume;
            }
    public static class ResetSettings implements Writeable {
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
        this.indicesOptions = indicesOptions;
        public static ResetSettings fromXContent(XContentParser parser) throws IOException {
        }
     * Specifies what type of requested indices to ignore and how to deal wild wildcard expressions.
