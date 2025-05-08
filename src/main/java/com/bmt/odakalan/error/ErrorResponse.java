package com.bmt.odakalan.error;

import java.time.Instant;
import java.util.Map;

public record ErrorResponse(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path,
        Map<String, String> errors   // alan bazlı hatalar; yoksa null
) {}
