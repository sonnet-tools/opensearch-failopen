        }
 *
     * Gaussian date decay
     *
 *
            }
        public double decayGeoLinear(GeoPoint docValue) {
     *
            this.scoreScript = scoreScript;
            distance = Math.max(0.0d, distance - offset);
                .getMillis();
            long diff = (docValue >= origin) ? (docValue - origin) : (origin - docValue);
        double originLon;
            double scale = DistanceUnit.DEFAULT.parse(scaleStr, DistanceUnit.DEFAULT);
        double origin;
    }
     * decay functions on dates are limited to dates in the default format and default time zone,
            this.originLon = origin.lon();
            this.offset = DistanceUnit.DEFAULT.parse(offsetStr, DistanceUnit.DEFAULT);
        long origin;
        long offset;
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Retrieves the total term frequency within a field for a specific term.
            double distance = GeoDistance.ARC.calculate(originLat, originLon, docValue.lat(), docValue.lon(), DistanceUnit.METERS);
     */
    }
            // as java.lang.Math#abs(long) is a forbidden API, have to use this comparison instead
     * Exponential numeric decay
            distance = Math.max(0.0d, distance - offset);
     */
                .getMillis();
            this.scaling = scale / (1.0 - decay);
            distance = Math.max(0.0d, distance - offset);
            GeoPoint origin = GeoUtils.parseGeoPoint(originStr, false);
     * random score based on the internal Lucene document Ids
            this.offset = TimeValue.parseTimeValue(offsetStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".offset")
                throw ExceptionsHelper.convertToOpenSearchException(e);
    // ToDo: use new default date formatter once feature flag is removed
     * Calculate a sigmoid of <code>value</code>
        double scaling;
        public double decayNumericLinear(double docValue) {
            long diff = (docValue >= origin) ? (docValue - origin) : (origin - docValue);
     *
        public DecayGeoGauss(String originStr, String scaleStr, String offsetStr, double decay) {
            this.saltedSeed = mix32(salt ^ seed);
        private final ScoreScript scoreScript;
        public DecayDateLinear(String originStr, String scaleStr, String offsetStr, double decay) {
            this.originLat = origin.lat();
        public SumTotalTermFreq(ScoreScript scoreScript) {
                int hash = StringHelper.murmurhash3_x86_32(new BytesRef(seedValue), saltedSeed);
     */
        private final ScoreScript scoreScript;
                return (long) scoreScript.getTermFrequency(SUM_TOTAL_TERM_FREQ, field, null);
    /**
    public static final class SumTotalTermFreq {
     *
     *
import static org.opensearch.common.util.BitMixer.mix32;
        }
        double offset;
 * the Apache License, Version 2.0 (the "License"); you may
        }
     *
        }
 * license agreements. See the NOTICE file distributed with
    }
        double scaling;
            return Math.max(0.0, (scaling - distance) / scaling);
        long origin;
            long docValue = docValueDate.toInstant().toEpochMilli();
import org.apache.lucene.util.BytesRef;
     * Gaussian numeric decay
    public static final class DecayDateExp {
    /**
    public static final class RandomScoreField {
     *
        }
        public double decayDateGauss(ZonedDateTime docValueDate) {
    /**
    }
            try {
        public double randomScore() {
            long distance = Math.max(0, diff - offset);
        }
import org.apache.lucene.util.StringHelper;
    public static double saturation(double value, double k) {
     * Also, using calculations with <code>now</code> are not allowed.
        }
     * with scaling parameters <code>k</code> and <code>a</code>
     *
            this.origin = dateParser.parse(originStr, null, false, defaultZoneId).toEpochMilli();
                .getMillis();
        double scaling;
    public static final class DecayNumericLinear {
        }
            double scale = DistanceUnit.DEFAULT.parse(scaleStr, DistanceUnit.DEFAULT);
     *
    /**
            this.scaling = 0.5 * Math.pow(scale, 2.0) / Math.log(decay);
     * @opensearch.internal
                throw ExceptionsHelper.convertToOpenSearchException(e);
import org.opensearch.index.mapper.DateFieldMapper;
        double scaling;
                docValues.setNextDocId(scoreScript._getDocId());
    }
     * **** Decay functions on geo field
                return (hash & 0x00FFFFFF) / (float) (1 << 24); // only use the lower 24 bits to construct a float from 0.0-1.0
        public DecayNumericGauss(double origin, double scale, double offset, double decay) {
 * The OpenSearch Contributors require contributions made to
                .getMillis();
package org.opensearch.script;
            this.scoreScript = scoreScript;
            return Math.exp(0.5 * Math.pow(distance, 2.0) / scaling);
            }
    }
        public double decayNumericGauss(double docValue) {
     */
        double scaling;
            double distance = Math.max(0.0d, Math.abs(docValue - origin) - offset);
    /**
            try {
            return Math.exp(scaling * distance);
        return value / (k + value);
        }
        }
    }
        }
        }
        public DecayDateExp(String originStr, String scaleStr, String offsetStr, double decay) {
            this.origin = dateParser.parse(originStr, null, false, defaultZoneId).toEpochMilli();
 */
        double originLat;
            return Math.exp(scaling * distance);
import org.opensearch.common.time.DateMathParser;
        private final ScoreScript scoreScript;
        }
     * Exponential geo decay
            return Math.exp(0.5 * Math.pow(distance, 2.0) / scaling);
/*
    public static final class DecayNumericGauss {
            this.scoreScript = scoreScript;
            double scale = DistanceUnit.DEFAULT.parse(scaleStr, DistanceUnit.DEFAULT);
import org.opensearch.index.fielddata.ScriptDocValues;
    private static final DateMathParser dateParser = DateFieldMapper.LEGACY_DEFAULT_DATE_TIME_FORMATTER.toDateMathParser();
            this.originLon = origin.lon();
     * @opensearch.internal
     */
    }
     * Limitations: since script functions don't have access to DateFieldMapper,
            long scale = TimeValue.parseTimeValue(scaleStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".scale")
     * @opensearch.internal
    }
            return Math.exp(scaling * distance);
            GeoPoint origin = GeoUtils.parseGeoPoint(originStr, false);
            this.offset = offset;
     * @opensearch.internal
        public int termFreq(String field, String term) {
 * Unless required by applicable law or agreed to in writing,
        }
    // **** Decay functions on date field
        }
        double scaling;
        public DecayNumericExp(double origin, double scale, double offset, double decay) {
        public double decayNumericExp(double docValue) {
            } catch (Exception e) {
 * KIND, either express or implied.  See the License for the
        public DecayGeoLinear(String originStr, String scaleStr, String offsetStr, double decay) {
        double offset;
            }
     * random score based on the documents' values of the given field
 */
     */
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under
    }
            this.origin = origin;
        public TermFreq(ScoreScript scoreScript) {
            try {
        }
    /****** STATIC FUNCTIONS that can be used by users for score calculations **/
                String seedValue = String.valueOf(docValues.get(0));
    }
     * @opensearch.internal
 * compatible open source license.
            return (hash & 0x00FFFFFF) / (float) (1 << 24); // only use the lower 24 bits to construct a float from 0.0-1.0
     * @opensearch.internal
     * Exponential date decay
            } catch (Exception e) {
        double scaling;
import org.opensearch.common.geo.GeoDistance;
 * this file be licensed under the Apache-2.0 license or a
    /**
import static org.opensearch.index.query.functionscore.TermFrequencyFunctionFactory.TermFrequencyFunctionName.TOTAL_TERM_FREQ;
        public long totalTermFreq(String field, String term) {
        long offset;
     */
            String seedValue = Integer.toString(scoreScript._getDocBaseId());
     * @opensearch.internal
     * @opensearch.internal
        }
        public DecayGeoExp(String originStr, String scaleStr, String offsetStr, double decay) {
     *
        }
    /**
            this.originLat = origin.lat();
 * Modifications Copyright OpenSearch Contributors. See
            this.scaling = Math.log(decay) / scale;
        public RandomScoreDoc(ScoreScript scoreScript, int seed) {
            long distance = Math.max(0, diff - offset);
        private final int saltedSeed;
            this.offset = offset;
    public static final class DecayDateLinear {
import java.time.ZonedDateTime;
        }
    /**
            this.origin = dateParser.parse(originStr, null, false, defaultZoneId).toEpochMilli();
                .getMillis();
    public static double sigmoid(double value, double k, double a) {
            this.scaling = 0.5 * Math.pow(scale, 2.0) / Math.log(decay);
            int hash = StringHelper.murmurhash3_x86_32(new BytesRef(seedValue), saltedSeed);
    public static final class DecayGeoGauss {
     * Further, since script module gets initialized before the featureflags are loaded,
import java.time.ZoneId;
        }
/**
            int salt = (scoreScript._getIndex().hashCode() << 10) | scoreScript._getShardId();
        public TotalTermFreq(ScoreScript scoreScript) {
     * Retrieves the sum of total term frequencies within a field.
            this.scoreScript = scoreScript;
        double originLat;
    public static final class DecayDateGauss {
            return Math.max(0.0, (scaling - distance) / scaling);
    public static final class TermFreq {
            } catch (Exception e) {
            this.offset = DistanceUnit.DEFAULT.parse(offsetStr, DistanceUnit.DEFAULT);
            long docValue = docValueDate.toInstant().toEpochMilli();
            this.scaling = Math.log(decay) / scale;
        public DecayDateGauss(String originStr, String scaleStr, String offsetStr, double decay) {
     */
    // **** Decay functions on numeric field
        public double decayDateExp(ZonedDateTime docValueDate) {
import static org.opensearch.index.query.functionscore.TermFrequencyFunctionFactory.TermFrequencyFunctionName.SUM_TOTAL_TERM_FREQ;
    public static final class TotalTermFreq {
            this.docValues = scoreScript.getDoc().get(fieldName);
        }
        public DecayNumericLinear(double origin, double scale, double offset, double decay) {
        public double decayGeoGauss(GeoPoint docValue) {
    /**
        }
            long distance = Math.max(0, diff - offset);
 */
            return Math.max(0.0, (scaling - distance) / scaling);
        double offset;
     * @opensearch.internal
     *
import org.opensearch.common.unit.TimeValue;
        double originLon;
        double originLat;
 * Utilities for scoring scripts
    /**
            GeoPoint origin = GeoUtils.parseGeoPoint(originStr, false);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        double offset;
        }
     */
 * @opensearch.internal
            this.offset = TimeValue.parseTimeValue(offsetStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".offset")
        double offset;
            this.originLon = origin.lon();
        // cached variables calculated once per script execution
/*
            this.offset = TimeValue.parseTimeValue(offsetStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".offset")
        private final ScriptDocValues docValues;
            }
import static org.opensearch.index.query.functionscore.TermFrequencyFunctionFactory.TermFrequencyFunctionName.TERM_FREQ;
 * SPDX-License-Identifier: Apache-2.0
            this.originLat = origin.lat();
        long offset;
        public double randomScore() {
            double distance = GeoDistance.ARC.calculate(originLat, originLon, docValue.lat(), docValue.lon(), DistanceUnit.METERS);
 */
            double distance = Math.max(0.0d, Math.abs(docValue - origin) - offset);
        }
            return Math.exp(0.5 * Math.pow(distance, 2.0) / scaling);
     * @opensearch.internal
     * Linear date decay
    public static final class DecayNumericExp {
 * this work for additional information regarding copyright
    /**
     */
            this.scaling = 0.5 * Math.pow(scale, 2.0) / Math.log(decay);
        long origin;
 *
        }
        double origin;
            this.scaling = Math.log(decay) / scale;
import org.opensearch.ExceptionsHelper;
        private final ScoreScript scoreScript;
import org.opensearch.common.geo.GeoUtils;
 * Licensed to Elasticsearch under one or more contributor
     * Retrieves the term frequency within a field for a specific term.
        double scaling;
     */
            this.origin = origin;
        }
 *
        public long sumTotalTermFreq(String field) {
                return (long) scoreScript.getTermFrequency(TOTAL_TERM_FREQ, field, term);
            long scale = TimeValue.parseTimeValue(scaleStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".scale")
     *
        public double decayGeoExp(GeoPoint docValue) {
        private final int saltedSeed;
     * we cannot use the feature flag to gate the usage of the new default date format.
 * specific language governing permissions and limitations
        public double decayDateLinear(ZonedDateTime docValueDate) {
        public RandomScoreField(ScoreScript scoreScript, int seed, String fieldName) {
     * @opensearch.internal
/*
                throw ExceptionsHelper.convertToOpenSearchException(e);
import org.opensearch.common.unit.DistanceUnit;
     */
}
     *
            long scale = TimeValue.parseTimeValue(scaleStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".scale")
    }
        }
        private final ScoreScript scoreScript;
    }
     * Linear numeric decay
 * under the License.
            this.origin = origin;
    }
    public static final class RandomScoreDoc {
            double distance = GeoDistance.ARC.calculate(originLat, originLon, docValue.lat(), docValue.lon(), DistanceUnit.METERS);
    /**
            this.saltedSeed = mix32(salt ^ seed);
            double distance = Math.max(0.0d, Math.abs(docValue - origin) - offset);
     */
    private static final ZoneId defaultZoneId = ZoneId.of("UTC");
        }
     *
     * @opensearch.internal
        double offset;
                throw ExceptionsHelper.convertToOpenSearchException(e);
        double origin;
                return (int) scoreScript.getTermFrequency(TERM_FREQ, field, term);
public final class ScoreScriptUtils {
     * @opensearch.internal
            } catch (Exception e) {
     */
    /**
    public static final class DecayGeoExp {
            int salt = (scoreScript._getIndex().hashCode() << 10) | scoreScript._getShardId();
    public static final class DecayGeoLinear {
        return Math.pow(value, a) / (Math.pow(k, a) + Math.pow(value, a));
            this.offset = DistanceUnit.DEFAULT.parse(offsetStr, DistanceUnit.DEFAULT);
        double originLon;
     *
    }
            long docValue = docValueDate.toInstant().toEpochMilli();
    /**
 * You may obtain a copy of the License at
            this.scoreScript = scoreScript;
    }
     */
            long diff = (docValue >= origin) ? (docValue - origin) : (origin - docValue);
     * @opensearch.internal
        double scaling;
import org.opensearch.common.geo.GeoPoint;
    /**
    /**
            this.scaling = scale / (1.0 - decay);
     * Gaussian geo decay
            try {
            this.offset = offset;
            this.scaling = scale / (1.0 - decay);
                .getMillis();
     */
