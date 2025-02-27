package ru.alien.cubesat_service.decoders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AX25DecoderTest {

    @Test
    void decode() {
        String RAW_DATA = "84 8A 82 86 9E 9C 60 A4 A6 64 60 A6 40 E1 03 F0 F6 01 C4 65 5A 03 4B 00 9D B1 07 B1 01 01 00 00 80 0B 0A 0A 0F 7F 1D F1 05 FA 53 4F 20 4C 4F 4E 47 21 20 54 48 58 20 34 20 41 4C 4C 20 37 33 21";
        AX25Decoder decoder = new AX25Decoder();
        String result = decoder.decode(RAW_DATA);

        assertEquals("", result);

    }
}