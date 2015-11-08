/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author aic
 */
public class BinaryDecimal {
    
    //Convert from Binary number (String) to integer
    public static int BinaryToDecimal(String bin)
    {
        int flag=0; //0 positive number 1 negative 
        flag = (bin.charAt(0) != '-' ? 0:1);
        if (bin.charAt(0) == '+' || bin.charAt(0) == '-')
            bin = bin.substring(1);
        int decimal = 0;
        int digit;
        for (int i=bin.length()-1;i>=0;i--)
        {
            if (bin.charAt(i) == '0')
                digit = 0;
            else if (bin.charAt(i) == '1')
                digit = 1;
            else
            {
                System.out.println("Invalid input");
                return -1;
            }
            decimal += digit*Math.pow(2.0,bin.length()-1-i);
        }
        if (flag == 1)
            return -decimal;
        return decimal;
    }
    
    //Convert from integer to Binary number
    public static String DecimalToBinary(int decimal)
    {
        String bin = "";
        String result = "";
        if (decimal<0)
        {
            result += "-";
            decimal = 0-decimal;
        }
        if (decimal == 0)
        {
            result = "0";
            return result;
        }
        while (decimal/2 != 0)
        {
            bin += (decimal%2==1)? "1":"0";
            decimal /= 2;
        }
        bin += "1";
       
        for (int i=bin.length()-1;i>=0;i--)
            result += bin.charAt(i);
        return result;
    }
}



