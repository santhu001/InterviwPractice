/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 *
 * @author santhosh
 */
public class LogicalExampls {

    public static void main(String[] args) {
        LogicalExampls exampls = new LogicalExampls();
        //exampls.divisableBy7_sumOfdigitsis7(1000);
        //System.out.println( exampls.emailValidtion("santhoshgouderukala@gmail.com"));
        // System.out.println(exampls.isPalindrom(12121));
        //exampls.printtDimond();
       // System.out.println(exampls.permutations("ABC"));
        //System.out.println(exampls.isAnagram("abcdefgoudhIJKLMNopqrsanthutuvwxyz"));
        //System.out.println(exampls.stringReplace("aabbaa", 'b','a'));
        exampls.printPrimenubers(20);
    }

    public void divisableBy7_sumOfdigitsis7(int range) {
        IntStream.range(1, range)
                .filter(LogicalExampls::divisableBy7)
                .filter(LogicalExampls::sumOfDigitsIs7)
                .forEach(num -> {
                    System.out.println("number :" + num);
                });
    }

    public static boolean divisableBy7(int value) {
        return value % 7 == 0;
    }

    public static boolean sumOfDigitsIs7(int value) {
        int sumOfdigits = 0;
        while (value > 0) {
            sumOfdigits += value % 10;
            value = value / 10;
        }
        return sumOfdigits == 7;
    }

    public boolean emailValidtion(String email) {
        String regdx = "[^.][\\w.]*[^.]@[^.][a-zA-Z]*.[a-zA-Z]*";
        Pattern pattern = Pattern.compile(regdx);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isPalindrom(String word) {
        char[] arry = word.toCharArray();
        for (int i = 0, j = (arry.length - 1); i < j; i++, j--) {
            if (arry[i] != arry[j]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrom(int number) {
        int reverse = 0, tmp = number;
        while (number > 0) {
            reverse = reverse * 10 + number % 10;
            number = number / 10;
        }
        return tmp == reverse;
    }

    public void printtDimond() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("===========");
        for (int i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("===============");
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }
            for (int j = 5; j > i; j--) {

                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("===========");
        for (int i = 0; i < 5; i++) {
            for (int k = 4 - i; k > 0; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("===========");
        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = 5; i > 0; i--) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public Set<String> permutations(String word) {
//         IntStream.range(0, word.length()).forEach(var->{
//               char letter=word.charAt(var);
//             System.out.println(letter+word.substring(0,word.indexOf(letter))+word.substring(var+1));
//             
//         });
        Set<String> perm = new HashSet<String>();
        if (word == null) {
            return null;
        }
        if (word.length() == 0) {
            perm.add("");
            return perm;
        }
        char intial=word.charAt(0);
        String rem=word.substring(1);
        Set<String> words= permutations(rem);
        for (String word1 : words) {
            for (int i = 0; i <= word1.length(); i++) {
                perm.add(word1.substring(0,i)+intial+word1.substring(i));
            }
 
        }
        return perm;
    }
    public  boolean isAnagram(String word){
        String regex="[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ]*";
        Pattern p=Pattern.compile(regex);
        Matcher m= p.matcher(word);
        return  m.matches();
    }
    public String stringReplace(String str,char old,char ne){
        char [] replace=str.toCharArray();
        for(int i=0;i<replace.length;i++){
            if(replace[i]==old){
                replace[i]=ne;
            }
        }
        return new String(replace);
    }
    public void PrintFibonasiWithArray(int size){
        int[] fibo=new int[size];
        
        fibo[0]=0;
        fibo[1]=1;
        for (int i = 2; i < fibo.length; i++) {
           fibo[i]=fibo[i-1]+fibo[i-2];
        }
        for (int i : fibo) {
            System.out.print(i+" ");
        }
    }
    public void PrintFibonasi(int size){
        int first=0,second=1,temp=0;
        System.out.print("FibonacciSeries: "+ first+" "+second+" ");
        for (int i = 0; i < size; i++) {
            temp=first+second;
            first=second;
            second=temp;
            System.out.print(temp+" ");
        }
    }
    public void printPrimenubers(int limit){
      
        for (int i = 0; i < limit; i++) {
            int flag=0;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i%j==0)
                    flag++;
            }
            if(flag==0 && i>1){
                System.out.print(i+" ");
            }
        }
    }
    
}
