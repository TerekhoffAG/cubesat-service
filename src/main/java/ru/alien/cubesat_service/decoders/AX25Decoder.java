package ru.alien.cubesat_service.decoders;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HexFormat;

@Slf4j
public class AX25Decoder implements Decoder {

    @Override
    public String decode(String rawData) {
        String minifiedData = rawData.trim().replace(" ", "");
        log.info("Принятые данные (hex): " + minifiedData);
        log.info("Колличество байт: " + (minifiedData.length() / 2));

        byte[] hexBytes = HexFormat.of().parseHex(minifiedData);

        //header
        byte[] headerHexBytes = Arrays.copyOfRange(hexBytes, 0, 15);
        log.info("Служебные данные (bytes): " + Arrays.toString(headerHexBytes));

        //telemetry
        byte[] payLoadHexBytes = Arrays.copyOfRange(hexBytes, 16, hexBytes.length);
        log.info("Данные телеметрии (bytes): " + Arrays.toString(payLoadHexBytes));

        //for example
        byte[] timeHexBytes = Arrays.copyOfRange(payLoadHexBytes, 0, 4);
        int unixTime = ByteBuffer.wrap(timeHexBytes).order(ByteOrder.LITTLE_ENDIAN).getInt();
        System.out.println(unixTime);

        return "";
    }
}
