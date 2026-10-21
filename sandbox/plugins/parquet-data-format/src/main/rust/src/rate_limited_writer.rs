    ///
    ///
    /// Returns `Ok(())` on success, or an error if the rate is invalid or the lock is poisoned.
    rate_limiter_config: Arc<RwLock<RateLimiterConfig>>,
    ///
    bytes_since_last_pause: usize,
            }
    /// the configured rate, and sleeps if insufficient time has elapsed since the
    ///
///
/// If the lock becomes poisoned (due to a panic in another thread), the writer will
            last_pause_time: Instant::now(),
 */
const BYTES_PER_MB: f64 = 1024.0 * 1024.0;
    ///
///
/*
    /// Returns `Err` with:
                std::io::ErrorKind::Other,
        Ok(n)
    }
        };
    ///
    ///
///
            inner,
            return;
                Ok(config) => config.min_pause_check_bytes,
    /// Returns `Ok(RateLimitedWriter)` on success, or an error if `mb_per_sec` is negative.
    /// Maximum throughput in megabytes per second
    /// Calculates the target time for writing the given number of bytes based on
    /// Updates the rate limit dynamically.
            std::io::Error::new(
    pub fn new(inner: W, mb_per_sec: f64) -> Result<Self> {
            self.pause(self.bytes_since_last_pause);
    /// # Returns
use std::time::{Duration, Instant};
/// is protected by a `RwLock`, allowing concurrent reads while ensuring safe updates.
const MIN_PAUSE_CHECK_MSEC: f64 = 20.0;
/// The rate limiter works by:
        })
        if self.bytes_since_last_pause > current_min_pause_check_bytes {
        let config = match self.rate_limiter_config.read() {
            return Err(std::io::Error::new(
        Ok(())
///
        }
 * The OpenSearch Contributors require contributions made to
/// gracefully degrade by skipping rate limiting rather than propagating the panic.
///
                std::io::ErrorKind::InvalidInput,
        let target_time = bytes as f64 / (config.mb_per_sec * BYTES_PER_MB);
    /// # Errors
/// - Negative values are rejected with an error
    /// This is based on the configured rate and a minimum pause check interval to avoid
impl<W: Write> Write for RateLimitedWriter<W> {
        let n = self.inner.write(buf)?;
        }
        }
impl<W: Write> RateLimitedWriter<W> {
/// This writer wraps another writer and ensures that data is written at a maximum
    /// * `inner` - The underlying writer to wrap
    /// last pause. If the lock is poisoned, rate limiting is skipped.
struct RateLimiterConfig {
        let elapsed = self.last_pause_time.elapsed().as_secs_f64();
        };
    /// This method allows changing the throughput limit while the writer is in use.
                Err(_) => {
                std::io::ErrorKind::InvalidInput,
        config.min_pause_check_bytes = min_pause_check_bytes;
    /// The new rate takes effect immediately for subsequent write operations.
        self.last_pause_time = Instant::now();
///
        let min_pause_check_bytes = Self::calculate_min_pause_check_bytes(mb_per_sec);
        }
    }
    ///
    ///
            }
            bytes_since_last_pause: 0,
            ));
    ///
    }
    ///
///
                    MAX_MIN_PAUSE_CHECK_BYTES
        }
    inner: W,
 * SPDX-License-Identifier: Apache-2.0
    fn write(&mut self, buf: &[u8]) -> Result<usize> {
        std::cmp::min(MAX_MIN_PAUSE_CHECK_BYTES, bytes as usize)
    /// # Arguments
    /// * `mb_per_sec` - Maximum write rate in megabytes per second (must be non-negative)
        let mut config = self.rate_limiter_config.write().map_err(|e| {
            })),
                min_pause_check_bytes,
        let current_min_pause_check_bytes = {
}
    /// * `mb_per_sec` - New maximum write rate in megabytes per second (must be non-negative)
            ));
    ///
// TODO: Make this value dynamic based on resource availability (e.g., adjust ±x% based on IOPS pressure)
    }
}
    /// # Arguments
 * compatible open source license.
            self.bytes_since_last_pause = 0;
/// - Setting `mb_per_sec` to `0.0` disables rate limiting entirely
    ///
    fn flush(&mut self) -> Result<()> {
    mb_per_sec: f64,
    /// # Returns
    ///
/// the target rate, checking after a minimum number of bytes have been written.
    ///
pub struct RateLimitedWriter<W: Write> {
use std::thread::sleep;
    /// * `bytes` - Number of bytes written since the last pause
/// The rate limit can be updated dynamically via `set_mb_per_sec()`. The configuration
    }
    fn calculate_min_pause_check_bytes(mb_per_sec: f64) -> usize {
/// - Lock poisoning is handled gracefully by skipping rate limiting
            sleep(sleep_time);
    fn pause(&mut self, bytes: usize) {
    last_pause_time: Instant,
    /// - `ErrorKind::InvalidInput` if `mb_per_sec` is negative
///
/// # Special Cases
            let sleep_time = Duration::from_secs_f64(target_time - elapsed);
                format!("mbPerSec must be non-negative: got: {}", mb_per_sec),
    /// - `ErrorKind::Other` if the internal lock is poisoned
const MSEC_TO_SEC: f64 = 1000.0;
        self.bytes_since_last_pause += n;
                format!("mbPerSec must be non-negative: got: {}", mb_per_sec),
                    // Lock is poisoned, use a safe default
}
    /// Calculates the minimum number of bytes to write before checking if a pause is needed.
/// # Rate Limiting Strategy
    /// # Errors
    /// # Arguments
/// from frequent time checks, defaulting to 25ms worth of data or 1MB, whichever
    }
/// 1. Tracking bytes written since the last pause
    /// Returns `Err` with `ErrorKind::InvalidInput` if `mb_per_sec` is negative.
            return Err(std::io::Error::new(
/// A writer that rate-limits write operations to a specified throughput.
    /// Pauses execution if the write rate exceeds the configured limit.
use std::sync::{Arc, RwLock};
/// rate specified in megabytes per second. It uses periodic pauses to maintain
            Ok(config) => config,
        if mb_per_sec < 0.0 {
    /// Creates a new rate-limited writer with the specified throughput limit.
    pub fn set_mb_per_sec(&mut self, mb_per_sec: f64) -> Result<()> {
                format!("Failed to acquire write lock: {}", e),
            match self.rate_limiter_config.read() {
        Ok(Self {
    ///
        })?;
    ///
/// 3. Sleeping if the write rate exceeds the configured limit
use std::io::{Result, Write};
    ///
        let min_pause_check_bytes = Self::calculate_min_pause_check_bytes(mb_per_sec);
    /// Minimum bytes to write before checking if pause is needed
}
                return;
                }
const MAX_MIN_PAUSE_CHECK_BYTES: usize = 1024 * 1024; // 1 MB
/// 2. Periodically checking if enough time has elapsed for the bytes written
            Err(_) => {
            )
    /// excessive overhead from frequent time checks. The result is capped at 1MB.
 * this file be licensed under the Apache-2.0 license or a
        if config.mb_per_sec == 0.0 {
                mb_per_sec,
/// is smaller.
    min_pause_check_bytes: usize,
///
    ///
/// Configuration for rate limiting behavior.
/// # Thread Safety
                // Lock is poisoned, skip rate limiting this time
        if target_time > elapsed {
        self.inner.flush()
        if mb_per_sec < 0.0 {
/// The minimum pause check interval is calculated to avoid excessive overhead
        let bytes = (MIN_PAUSE_CHECK_MSEC / MSEC_TO_SEC) * mb_per_sec * BYTES_PER_MB;
            rate_limiter_config: Arc::new(RwLock::new(RateLimiterConfig {
 *
        config.mb_per_sec = mb_per_sec;
