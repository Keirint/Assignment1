package CarPlate;
//In the public class CarPlate we set all the  main methods and other methods  needed for the validity and functionality
import java.util.Random;

public class CarplateManager {
    private static final String Letters ="ABCDEFGHJKLMNPQRSTUVWXYZ";
    private static final String Numbers = "023456789";
    private static final Random rand = new Random();

    public String generateCarPlate() {
        StringBuilder plate= new StringBuilder();
        for (int i = 0; i < 2; i++) {
            plate.append(Letters.charAt(rand.nextInt(Letters.length())));
        }
        for (int i = 0; i <3 ; i++) {
            plate.append(Numbers.charAt(rand.nextInt(Numbers.length())));
        }
        for (int i = 0; i < 2; i++) {
            if (rand.nextBoolean()) {
                plate.append(Letters.charAt(rand.nextInt(Letters.length())));
            }else{
                plate.append(Numbers.charAt(rand.nextInt(Numbers.length())));
            }
        }
        return plate.toString();
    }

    public boolean isValidPlate(String plate) {
        if (plate.length() != 7) {
            return false;
        }
        if (!isValidLETTERS(plate.substring(0,2))){
            return false;
        }
        if (!isValidNUMBERS(plate.substring(2,5))) {
            return false;
        }
        if (!isValidLETTERSorNumbers(plate.substring(5,7))){
            return false;
        }
        return true;
    }
    private boolean isValidLETTERS(String letters) {
        for (char c : letters.toUpperCase().toCharArray()) {
            if (c<'A' || c>'Z' || c=='O') {
                return false;
            }
        }
        return true;
    }
    private boolean isValidNUMBERS(String numbers) {
        for (char c : numbers.toCharArray()) {
            if (c<'0' || c>'9'||c=='1') {
                return false;
            }
        }
        return true;
    }
    private boolean isValidLETTERSorNumbers(String letters) {
        for (char c : letters.toUpperCase().toCharArray()) {
            if((c<'A' || c>'Z' || c=='O')&&(c<'0' || c>'9' || c=='1')){
                return false;
            }
        }
        return true;
    }
    public String getNextCarPlate(String plate) {
        char[] chars = plate.toUpperCase().toCharArray();
        String order = "023456789ABCDEFGHJKLMNPQRSTUVWXYZ";

        for (int i = chars.length - 1; i >= 0; i--) {
            int index = order.indexOf(chars[i]);


            if (i == 6) {
                if (index < order.length() - 1) {
                    chars[i] = order.charAt(index + 1);
                    return new String(chars);
                } else {
                    chars[i] = order.charAt(0);
                    continue;
                }
            }
            if (index < order.length() - 1) {
                chars[i] = order.charAt(index + 1);
                return new String(chars);
            } else {
                chars[i] = order.charAt(0);
            }
        }
        return new String(chars);
    }

}
