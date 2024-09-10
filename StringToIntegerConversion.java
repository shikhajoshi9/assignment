public class StringToIntegerConversion {

    /**
     * Q6
     * Function to remove alphabets and special characters and convert String to Integer
     * @param str
     * @return
     */
    public static Integer convert(String str) {
        Integer result = Integer.parseInt(str.replaceAll("[^0-9]", ""));
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convert("$180,240/y"));
        //System.out.println(convert(" as ^&*( 1"));

    }
}
