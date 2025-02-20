package ru.alien.cubesat_service.decoder;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HexFormat;

public class AX25Decoder {

    public String decode(String rawData) {
        String trimData = rawData.trim().replace(" ", "");

        System.out.println("Колличество байт: " + (trimData.length() / 2));
        System.out.println("Принятые данные (hex): " + trimData);

        byte[] hexBytes = HexFormat.of().parseHex(trimData);

        byte[] payLoadHexBytes = Arrays.copyOfRange(hexBytes, 16, hexBytes.length);
        byte[] timeHexBytes = Arrays.copyOfRange(payLoadHexBytes, 0, 4);
        int unixTime = ByteBuffer.wrap(timeHexBytes).order(ByteOrder.LITTLE_ENDIAN).getInt();

        System.out.println(Arrays.toString(hexBytes));
        System.out.println(Arrays.toString(payLoadHexBytes));
        System.out.println(unixTime);

        return "";
    }
}
