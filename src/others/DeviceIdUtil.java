package others;

import java.util.zip.CRC32;

/**
 * 
 * @author eaves.zhu
 */
public class DeviceIdUtil {
/**
 * @author eaves.zhu
 * @param deviceId
 * @return int 
 * CRC32
 */
   public static long getCRC32(String deviceId){
	        CRC32 crc32 = new CRC32();  
	        crc32.update(deviceId.getBytes());
	            long tmp = crc32.getValue();
	            return tmp;
   }

	public static void main(String[] args) {
		System.out.println(DeviceIdUtil.getCRC32("did:ont:ALB29qVSrEJ9y9AadUMUSUp2MFHoEG7T7N"));
	}
}