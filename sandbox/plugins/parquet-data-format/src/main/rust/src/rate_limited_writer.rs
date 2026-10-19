///
/// from frequent time checks, defaulting to 25ms worth of data or 1MB, whichever
                    MAX_MIN_PAUSE_CHECK_BYTES
/// The minimum pause check interval is calculated to avoid excessive overhead
/// 3. Sleeping if the write rate exceeds the configured limit
    /// * `inner` - The underlying writer to wrap
    last_pause_time: Instant,
                }
use std::io::{Result, Write};
    mb_per_sec: f64,
    ///
    ///
/// is smaller.
/// gracefully degrade by skipping rate limiting rather than propagating the panic.
    ///
    fn pause(&mut self, bytes: usize) {
            }
        self.inner.flush()
/// - Lock poisoning is handled gracefully by skipping rate limiting
            self.bytes_since_last_pause = 0;
/// If the lock becomes poisoned (due to a panic in another thread), the writer will
    /// excessive overhead from frequent time checks. The result is capped at 1MB.
    /// the configured rate, and sleeps if insufficient time has elapsed since the
    }
    }
/*
        let config = match self.rate_limiter_config.read() {
}
            bytes_since_last_pause: 0,
        if target_time > elapsed {
 * The OpenSearch Contributors require contributions made to
impl<W: Write> RateLimitedWriter<W> {
            std::io::Error::new(
    ///
    ///
    }
    ///
            )
        config.min_pause_check_bytes = min_pause_check_bytes;
            sleep(sleep_time);
}
    /// Creates a new rate-limited writer with the specified throughput limit.
        config.mb_per_sec = mb_per_sec;
    /// # Returns
    ///
}
        }
// TODO: Make this value dynamic based on resource availability (e.g., adjust ±x% based on IOPS pressure)
    /// last pause. If the lock is poisoned, rate limiting is skipped.
    ///
    /// # Arguments
                format!("Failed to acquire write lock: {}", e),
        };
            let sleep_time = Duration::from_secs_f64(target_time - elapsed);
///
    ///
/// A writer that rate-limits write operations to a specified throughput.
    ///
    rate_limiter_config: Arc<RwLock<RateLimiterConfig>>,
    bytes_since_last_pause: usize,
                std::io::ErrorKind::InvalidInput,
///
    fn flush(&mut self) -> Result<()> {
        let current_min_pause_check_bytes = {
            self.pause(self.bytes_since_last_pause);
    fn write(&mut self, buf: &[u8]) -> Result<usize> {
    /// # Arguments
    min_pause_check_bytes: usize,
        let n = self.inner.write(buf)?;
    ///
    /// This method allows changing the throughput limit while the writer is in use.
}
 *
                Err(_) => {
        }
        if self.bytes_since_last_pause > current_min_pause_check_bytes {
            rate_limiter_config: Arc::new(RwLock::new(RateLimiterConfig {
    /// # Errors
    /// Calculates the target time for writing the given number of bytes based on
        let min_pause_check_bytes = Self::calculate_min_pause_check_bytes(mb_per_sec);
            ));
        }
struct RateLimiterConfig {
    fn calculate_min_pause_check_bytes(mb_per_sec: f64) -> usize {
                return;
        let min_pause_check_bytes = Self::calculate_min_pause_check_bytes(mb_per_sec);
    /// Returns `Ok(())` on success, or an error if the rate is invalid or the lock is poisoned.
/// the target rate, checking after a minimum number of bytes have been written.
    ///
    /// The new rate takes effect immediately for subsequent write operations.
    ///
    /// # Errors
        std::cmp::min(MAX_MIN_PAUSE_CHECK_BYTES, bytes as usize)
const MAX_MIN_PAUSE_CHECK_BYTES: usize = 1024 * 1024; // 1 MB
 * SPDX-License-Identifier: Apache-2.0
        })
    ///
///
            return Err(std::io::Error::new(
/// rate specified in megabytes per second. It uses periodic pauses to maintain
    /// This is based on the configured rate and a minimum pause check interval to avoid
                std::io::ErrorKind::Other,
        self.last_pause_time = Instant::now();
    /// * `mb_per_sec` - New maximum write rate in megabytes per second (must be non-negative)
                format!("mbPerSec must be non-negative: got: {}", mb_per_sec),
    ///
/// - Negative values are rejected with an error
        let elapsed = self.last_pause_time.elapsed().as_secs_f64();
        if config.mb_per_sec == 0.0 {
            })),
/// This writer wraps another writer and ensures that data is written at a maximum
    /// * `mb_per_sec` - Maximum write rate in megabytes per second (must be non-negative)
        })?;
    pub fn set_mb_per_sec(&mut self, mb_per_sec: f64) -> Result<()> {
///
            Ok(config) => config,
    }
    /// Maximum throughput in megabytes per second
        if mb_per_sec < 0.0 {
 * compatible open source license.
///
                format!("mbPerSec must be non-negative: got: {}", mb_per_sec),
        Ok(())
        let target_time = bytes as f64 / (config.mb_per_sec * BYTES_PER_MB);
/// 1. Tracking bytes written since the last pause
const MIN_PAUSE_CHECK_MSEC: f64 = 20.0;
 * this file be licensed under the Apache-2.0 license or a
///
                mb_per_sec,
            return;
use std::thread::sleep;
    /// # Returns
                std::io::ErrorKind::InvalidInput,
                    // Lock is poisoned, use a safe default
            return Err(std::io::Error::new(
    /// - `ErrorKind::InvalidInput` if `mb_per_sec` is negative
        Ok(Self {
impl<W: Write> Write for RateLimitedWriter<W> {
                min_pause_check_bytes,
/// Configuration for rate limiting behavior.
        }
///
use std::sync::{Arc, RwLock};
    ///
    }
        let bytes = (MIN_PAUSE_CHECK_MSEC / MSEC_TO_SEC) * mb_per_sec * BYTES_PER_MB;
                // Lock is poisoned, skip rate limiting this time
/// The rate limit can be updated dynamically via `set_mb_per_sec()`. The configuration
    ///
    /// Returns `Ok(RateLimitedWriter)` on success, or an error if `mb_per_sec` is negative.
        };
    /// # Arguments
            last_pause_time: Instant::now(),
const MSEC_TO_SEC: f64 = 1000.0;
/// - Setting `mb_per_sec` to `0.0` disables rate limiting entirely
    pub fn new(inner: W, mb_per_sec: f64) -> Result<Self> {
    ///
        Ok(n)
            inner,
 */
    /// - `ErrorKind::Other` if the internal lock is poisoned
/// is protected by a `RwLock`, allowing concurrent reads while ensuring safe updates.
    /// Returns `Err` with `ErrorKind::InvalidInput` if `mb_per_sec` is negative.
/// # Thread Safety
            }
/// The rate limiter works by:
        if mb_per_sec < 0.0 {
    /// Returns `Err` with:
    /// Pauses execution if the write rate exceeds the configured limit.
            Err(_) => {
    /// * `bytes` - Number of bytes written since the last pause
    ///
    inner: W,
/// 2. Periodically checking if enough time has elapsed for the bytes written
            ));
    /// Calculates the minimum number of bytes to write before checking if a pause is needed.
/// # Rate Limiting Strategy
///
/// # Special Cases
const BYTES_PER_MB: f64 = 1024.0 * 1024.0;
        }
            match self.rate_limiter_config.read() {
    }
    /// Updates the rate limit dynamically.
                Ok(config) => config.min_pause_check_bytes,
use std::time::{Duration, Instant};
pub struct RateLimitedWriter<W: Write> {
        let mut config = self.rate_limiter_config.write().map_err(|e| {
    /// Minimum bytes to write before checking if pause is needed
        self.bytes_since_last_pause += n;
