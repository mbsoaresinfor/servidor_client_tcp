package mbs.crc;



import static java.lang.System.out;

public class Main {
	public final static int CRC_POLYNOM = 0x9c;

    public final static int CRC_PRESET = 0xFF;
    public static void main(String[] args) {
    	String value = "090131323334";
    	int crc_U = CRC_PRESET;
        byte[] frame_U =  value.getBytes();
        	//{1, 56, -23, 3, 0, 19, 0, 0, 2, 0, 3, 13, 8, -34, 7, 9, 42, 18, 26, -5, 54, 11, -94, -46, -128, 4, 48, 52, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1, 1, -32, -80, 0, 98, -5, 71, 0, 64, 0, 0, 0, 0, -116, 1, 104, 2};
        for(int i = 0; i < frame_U.length; i++) {
            crc_U ^= Byte.toUnsignedInt(frame_U[i]);
            for(int j = 0; j < 8; j++) {
                if((crc_U & 0x01) != 0) {
                    crc_U = (crc_U >>> 1) ^ CRC_POLYNOM;
                } else {
                    crc_U = (crc_U >>> 1);
                }
            }
        }
        System.out.println(Integer.toUnsignedString(crc_U));
    	
//        Check(Crc8.Params);

//        Check(Crc16.Params);
//
//        Check(Crc32.Params);
//
//        Check(Crc64.Params);
    }

    private static void Check(AlgoParams[] params)
    {
        for (int i = 0; i < params.length; i++) {
            CrcCalculator calculator = new CrcCalculator(params[i]);
            long result = calculator.Calc(CrcCalculator.TestBytes, 0, CrcCalculator.TestBytes.length);
            if (result != calculator.Parameters.Check) 
                out.println(calculator.Parameters.Name + " - BAD ALGO!!! " + Long.toHexString(result).toUpperCase());               
        	else 
        		out.println(result);
        	
    }
}
}