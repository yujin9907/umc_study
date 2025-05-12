package org.umc.workbook.domain.enums;

import java.util.Arrays;

public enum MissionStatus {
    FAIL, PROGRESS, SUCCESS;

    public static MissionStatus of(String value) {
        return Arrays.stream(values())
                .filter(e -> e.toString().equals(value))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
