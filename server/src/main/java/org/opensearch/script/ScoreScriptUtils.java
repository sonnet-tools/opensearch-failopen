        double scaling;  
    /**
                String seedValue = String.valueOf(docValues.get(0));  
     * Gaussian date decay
    public static final class TermFreq {
import org.opensearch.common.unit.TimeValue;  
        double scaling;
 * software distributed under the License is distributed on an
     * @opensearch.internal  
    public static final class DecayNumericExp {
     * Exponential numeric decay  
            this.offset = TimeValue.parseTimeValue(offsetStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".offset")
        public double randomScore() {  
     * Retrieves the total term frequency within a field for a specific term.
        public DecayDateLinear(String originStr, String scaleStr, String offsetStr, double decay) {
     * Exponential date decay
        }  
     */
 * this work for additional information regarding copyright
            try {
        }
 */
    /**
            this.offset = DistanceUnit.DEFAULT.parse(offsetStr, DistanceUnit.DEFAULT);  
            double distance = Math.max(0.0d, Math.abs(docValue - origin) - offset);
import org.apache.lucene.util.BytesRef;
        public double decayNumericExp(double docValue) {  
            GeoPoint origin = GeoUtils.parseGeoPoint(originStr, false);
 * The OpenSearch Contributors require contributions made to  
 *
        double origin;  
     * we cannot use the feature flag to gate the usage of the new default date format.
     * @opensearch.internal
        public DecayGeoExp(String originStr, String scaleStr, String offsetStr, double decay) {
        public double randomScore() {  
     */
    /**
    /**  
        long origin;
 * Licensed to Elasticsearch under one or more contributor  
    public static final class DecayNumericGauss {
        public double decayGeoExp(GeoPoint docValue) {
            return Math.exp(scaling * distance);
     * Exponential geo decay  
        double offset;
            GeoPoint origin = GeoUtils.parseGeoPoint(originStr, false);
 * Utilities for scoring scripts
        public RandomScoreField(ScoreScript scoreScript, int seed, String fieldName) {
     */
            distance = Math.max(0.0d, distance - offset);  
        }
        long origin;  
            try {
            return Math.exp(0.5 * Math.pow(distance, 2.0) / scaling);  
import org.opensearch.index.mapper.DateFieldMapper;
                .getMillis();
        }
     *
    public static final class DecayDateExp {  
        private final ScoreScript scoreScript;  
        private final ScoreScript scoreScript;  
    public static final class DecayDateGauss {  
            this.scoreScript = scoreScript;  
            this.origin = dateParser.parse(originStr, null, false, defaultZoneId).toEpochMilli();  
     * @opensearch.internal
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.origin = dateParser.parse(originStr, null, false, defaultZoneId).toEpochMilli();  
     *
        double offset;
}  
        }  
 * KIND, either express or implied.  See the License for the
            this.saltedSeed = mix32(salt ^ seed);  
 * GitHub history for details.
    }
    }  
        // cached variables calculated once per script execution
     * @opensearch.internal  
     *
    }
            long docValue = docValueDate.toInstant().toEpochMilli();
    public static double saturation(double value, double k) {  
        double origin;
    }
            this.scaling = Math.log(decay) / scale;
 * Modifications Copyright OpenSearch Contributors. See
        private final ScriptDocValues docValues;
    private static final DateMathParser dateParser = DateFieldMapper.LEGACY_DEFAULT_DATE_TIME_FORMATTER.toDateMathParser();
        double originLon;  
            this.offset = DistanceUnit.DEFAULT.parse(offsetStr, DistanceUnit.DEFAULT);  
            this.offset = DistanceUnit.DEFAULT.parse(offsetStr, DistanceUnit.DEFAULT);  
    public static final class DecayGeoGauss {
     * Gaussian geo decay  
        public long totalTermFreq(String field, String term) {  
        }
     */  
            this.originLat = origin.lat();
            this.offset = TimeValue.parseTimeValue(offsetStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".offset")  
 *  
    }
            this.scoreScript = scoreScript;  
            return Math.exp(scaling * distance);  
    }  
     * Retrieves the sum of total term frequencies within a field.
            String seedValue = Integer.toString(scoreScript._getDocBaseId());
            // as java.lang.Math#abs(long) is a forbidden API, have to use this comparison instead  
    public static final class DecayNumericLinear {  
            long docValue = docValueDate.toInstant().toEpochMilli();  
     * with scaling parameters <code>k</code> and <code>a</code>  
            long distance = Math.max(0, diff - offset);
        public double decayGeoGauss(GeoPoint docValue) {
import org.opensearch.common.geo.GeoPoint;
        }
            int hash = StringHelper.murmurhash3_x86_32(new BytesRef(seedValue), saltedSeed);
import org.opensearch.common.geo.GeoUtils;  
        double originLon;  
            long diff = (docValue >= origin) ? (docValue - origin) : (origin - docValue);
        }  
                return (long) scoreScript.getTermFrequency(SUM_TOTAL_TERM_FREQ, field, null);
     */
                .getMillis();  
            this.saltedSeed = mix32(salt ^ seed);
     *
                throw ExceptionsHelper.convertToOpenSearchException(e);
import static org.opensearch.index.query.functionscore.TermFrequencyFunctionFactory.TermFrequencyFunctionName.TERM_FREQ;  
     * random score based on the internal Lucene document Ids
     * @opensearch.internal  
            return (hash & 0x00FFFFFF) / (float) (1 << 24); // only use the lower 24 bits to construct a float from 0.0-1.0  
            this.docValues = scoreScript.getDoc().get(fieldName);  
     * @opensearch.internal
        double originLon;  
     *  
                return (int) scoreScript.getTermFrequency(TERM_FREQ, field, term);
        return value / (k + value);
     */
                .getMillis();
            this.scoreScript = scoreScript;
    }
        public double decayDateLinear(ZonedDateTime docValueDate) {
 * Unless required by applicable law or agreed to in writing,
    public static final class DecayGeoExp {
            this.scaling = 0.5 * Math.pow(scale, 2.0) / Math.log(decay);
            long scale = TimeValue.parseTimeValue(scaleStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".scale")  
     */
     *
            this.scaling = 0.5 * Math.pow(scale, 2.0) / Math.log(decay);
        public DecayNumericLinear(double origin, double scale, double offset, double decay) {
            int salt = (scoreScript._getIndex().hashCode() << 10) | scoreScript._getShardId();
            this.offset = TimeValue.parseTimeValue(offsetStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".offset")  
    // **** Decay functions on date field
        public DecayDateExp(String originStr, String scaleStr, String offsetStr, double decay) {
        public double decayGeoLinear(GeoPoint docValue) {
import java.time.ZoneId;
 */  
    /**  
        double offset;
            return Math.exp(scaling * distance);
        long offset;
     *  
/*
    /**
        double offset;  
        }
        double scaling;
            this.offset = offset;
import org.opensearch.common.geo.GeoDistance;
        long origin;
     */
    /**
        }
            double distance = Math.max(0.0d, Math.abs(docValue - origin) - offset);  
    /**  
     * @opensearch.internal  
     *  
            this.origin = origin;
            this.scaling = scale / (1.0 - decay);
            this.scoreScript = scoreScript;
        double originLat;
    }
            distance = Math.max(0.0d, distance - offset);  
            double scale = DistanceUnit.DEFAULT.parse(scaleStr, DistanceUnit.DEFAULT);  
                throw ExceptionsHelper.convertToOpenSearchException(e);
            this.originLon = origin.lon();
import static org.opensearch.index.query.functionscore.TermFrequencyFunctionFactory.TermFrequencyFunctionName.SUM_TOTAL_TERM_FREQ;
    /**
            this.offset = offset;  
        double scaling;
            this.originLon = origin.lon();
     * @opensearch.internal  
            this.originLat = origin.lat();
     *
        }
            this.offset = offset;
                throw ExceptionsHelper.convertToOpenSearchException(e);
    /****** STATIC FUNCTIONS that can be used by users for score calculations **/
        }
            this.scaling = scale / (1.0 - decay);
        double scaling;  
 * the Apache License, Version 2.0 (the "License"); you may
        }
     * **** Decay functions on geo field
 * not use this file except in compliance with the License.
            }
import org.opensearch.ExceptionsHelper;  
        }  
        public DecayNumericExp(double origin, double scale, double offset, double decay) {  
 *
        }
    }
            } catch (Exception e) {  
            this.scaling = 0.5 * Math.pow(scale, 2.0) / Math.log(decay);
        public DecayDateGauss(String originStr, String scaleStr, String offsetStr, double decay) {
 * @opensearch.internal  
            GeoPoint origin = GeoUtils.parseGeoPoint(originStr, false);
                throw ExceptionsHelper.convertToOpenSearchException(e);
    }
            double distance = GeoDistance.ARC.calculate(originLat, originLon, docValue.lat(), docValue.lon(), DistanceUnit.METERS);
     * @opensearch.internal
import org.opensearch.index.fielddata.ScriptDocValues;
    /**
    // ToDo: use new default date formatter once feature flag is removed  
     * Gaussian numeric decay
            double distance = GeoDistance.ARC.calculate(originLat, originLon, docValue.lat(), docValue.lon(), DistanceUnit.METERS);
     *
    }
        public double decayDateGauss(ZonedDateTime docValueDate) {
import static org.opensearch.common.util.BitMixer.mix32;
                .getMillis();
        }
        double offset;
    /**  
            this.scaling = scale / (1.0 - decay);
        double originLat;
     * Linear date decay
        public SumTotalTermFreq(ScoreScript scoreScript) {
        }
     * Also, using calculations with <code>now</code> are not allowed.
            this.origin = origin;
        double scaling;  
        double scaling;
    public static final class DecayGeoLinear {  
            long diff = (docValue >= origin) ? (docValue - origin) : (origin - docValue);
 * this file be licensed under the Apache-2.0 license or a
            this.scoreScript = scoreScript;  
        public long sumTotalTermFreq(String field) {  
     * @opensearch.internal
        private final int saltedSeed;
import org.opensearch.common.time.DateMathParser;
        }  
    public static double sigmoid(double value, double k, double a) {
    /**  
    public static final class RandomScoreField {
        public TotalTermFreq(ScoreScript scoreScript) {
    // **** Decay functions on numeric field
     *
        long offset;
        double offset;
    public static final class DecayDateLinear {
        double scaling;
        public double decayDateExp(ZonedDateTime docValueDate) {
    private static final ZoneId defaultZoneId = ZoneId.of("UTC");
        double scaling;
        return Math.pow(value, a) / (Math.pow(k, a) + Math.pow(value, a));  
                docValues.setNextDocId(scoreScript._getDocId());
        double originLat;
    /**  
     */
            this.origin = origin;  
     * Further, since script module gets initialized before the featureflags are loaded,  
import static org.opensearch.index.query.functionscore.TermFrequencyFunctionFactory.TermFrequencyFunctionName.TOTAL_TERM_FREQ;
        }  
/*  
 * You may obtain a copy of the License at  
                int hash = StringHelper.murmurhash3_x86_32(new BytesRef(seedValue), saltedSeed);
    /**  
            this.originLat = origin.lat();
        public DecayNumericGauss(double origin, double scale, double offset, double decay) {
import org.opensearch.common.unit.DistanceUnit;
            double distance = Math.max(0.0d, Math.abs(docValue - origin) - offset);
            } catch (Exception e) {  
        public TermFreq(ScoreScript scoreScript) {
            long distance = Math.max(0, diff - offset);
     * Calculate a sigmoid of <code>value</code>
        private final ScoreScript scoreScript;  
                .getMillis();
            long scale = TimeValue.parseTimeValue(scaleStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".scale")
        public double decayNumericLinear(double docValue) {
     *
 * license agreements. See the NOTICE file distributed with
            } catch (Exception e) {  
 * SPDX-License-Identifier: Apache-2.0
        public double decayNumericGauss(double docValue) {
    public static final class TotalTermFreq {
        }
        }
     */
     */  
     * Retrieves the term frequency within a field for a specific term.
        private final int saltedSeed;
            int salt = (scoreScript._getIndex().hashCode() << 10) | scoreScript._getShardId();
            try {
    /**
        public DecayGeoGauss(String originStr, String scaleStr, String offsetStr, double decay) {
 * under the License.  
            this.originLon = origin.lon();
        private final ScoreScript scoreScript;  
     * decay functions on dates are limited to dates in the default format and default time zone,
import java.time.ZonedDateTime;
            } catch (Exception e) {  
        double origin;
    }  
            return Math.exp(0.5 * Math.pow(distance, 2.0) / scaling);
    /**  
            long docValue = docValueDate.toInstant().toEpochMilli();  
        public DecayGeoLinear(String originStr, String scaleStr, String offsetStr, double decay) {
            long diff = (docValue >= origin) ? (docValue - origin) : (origin - docValue);
            this.scaling = Math.log(decay) / scale;  
            }
                return (hash & 0x00FFFFFF) / (float) (1 << 24); // only use the lower 24 bits to construct a float from 0.0-1.0
        private final ScoreScript scoreScript;  
     */
     */
     */
            this.scaling = Math.log(decay) / scale;
            return Math.max(0.0, (scaling - distance) / scaling);
            double scale = DistanceUnit.DEFAULT.parse(scaleStr, DistanceUnit.DEFAULT);  
            return Math.exp(0.5 * Math.pow(distance, 2.0) / scaling);  
     *  
        public RandomScoreDoc(ScoreScript scoreScript, int seed) {  
 * compatible open source license.
        long offset;
        }
        public int termFreq(String field, String term) {  
/*  
     */
            double distance = GeoDistance.ARC.calculate(originLat, originLon, docValue.lat(), docValue.lon(), DistanceUnit.METERS);
public final class ScoreScriptUtils {
            return Math.max(0.0, (scaling - distance) / scaling);
            this.origin = dateParser.parse(originStr, null, false, defaultZoneId).toEpochMilli();
 */  
        }  
        }
     *  
                return (long) scoreScript.getTermFrequency(TOTAL_TERM_FREQ, field, term);
    }
        }
     */  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.script;
            double scale = DistanceUnit.DEFAULT.parse(scaleStr, DistanceUnit.DEFAULT);  
     * @opensearch.internal  
     * random score based on the documents' values of the given field
     * @opensearch.internal  
            return Math.max(0.0, (scaling - distance) / scaling);  
            distance = Math.max(0.0d, distance - offset);  
    public static final class SumTotalTermFreq {
            }
            long scale = TimeValue.parseTimeValue(scaleStr, TimeValue.timeValueHours(24), getClass().getSimpleName() + ".scale")
            try {
     * @opensearch.internal
            long distance = Math.max(0, diff - offset);
     * @opensearch.internal
    public static final class RandomScoreDoc {
 */
 *
/**  
     * Linear numeric decay
                .getMillis();
     * Limitations: since script functions don't have access to DateFieldMapper,
    }
 * specific language governing permissions and limitations
        }
     *
        }  
    }  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
import org.apache.lucene.util.StringHelper;
