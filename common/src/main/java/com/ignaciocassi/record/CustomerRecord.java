package com.ignaciocassi.record;

public record CustomerRecord(
        Integer id,
        String firstName,
        String lastName,
        String email) {
}
