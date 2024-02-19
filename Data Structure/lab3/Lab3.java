package lab3;

import java.util.Arrays;
import java.util.Random;

public class Lab3 {
    public void insertionSort(int []a)
    {
        for (int i = 1; i <a.length ; i++) {
            int cur=a[i];
            int j=i;
            while(j>0&&cur<a[j-1])
            {a[j]=a[j-1];
                j--;}
            a[j]=cur;
        }
    }

    public void fillRandom(int[] a) {
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(10);
        }
    }
    public int sequentialSearch(int[] a, int element) {
        int index = -1;
        int i = 0;
        boolean flag = false;
        while (!flag && i < a.length) {
            if (a[i] == element) {
                flag = true;
                index = i;
            }
            i++;
        }
        return index;
    }

    public void remove(int[] a, int index)

    {
        if (index >= 0 && index < a.length) {
            int i = index;
            while (i < a.length - 1) {
                a[i] = a[i + 1];
                i++;
            }
            a[i] = 0;
        }
    }
    public static void main(String[] args) {
        int a[]={11,12,9,13,5};
        int b[]={12,13,14,15,16};

        Lab3 l= new Lab3();
        System.out.println(Arrays.toString(a));
        l.remove(a,1);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.equals(a,b));
        Arrays.fill(b,5);
        System.out.println(Arrays.toString(b));
        b= Arrays.copyOf(a,5);
        System.out.println(Arrays.toString(b));
        b=Arrays.copyOfRange(a,2,4);
        System.out.println(Arrays.toString(b));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a,9));
        l.fillRandom(a);
        System.out.println(Arrays.toString(a));


    }

    public static class CaesarCipher {
        char encoder[]= new char[26];
        char decoder[]=new char[26];
        public CaesarCipher(int rotation) {
            for (int i = 0; i <encoder.length ; i++) {
                encoder[i]=(char)('A'+(i+rotation)%26);
                decoder[i]=(char)('A'+(i-rotation+26)%26);

            }


        }


        public String encrypt(String message)
        {return transform(message,encoder);}
        public String decrypt(String message)
        {return transform(message,decoder);}
        String transform(String message,char code[])
        {
            char[]msg=message.toCharArray();
            for (int i = 0; i <msg.length ; i++) {
                if(Character.isUpperCase(msg[i]))
                {int j=msg[i]-'A';
                    msg[i]=code[j];}


            }
            return new String(msg);
        }

        public static void main(String[] args) {
            CaesarCipher c= new CaesarCipher(3);
            String mess="THE EAGLE ";
            String x=c.encrypt(mess);
            System.out.println(x);
            System.out.println(c.decrypt(x));
            System.out.println((int )'A');
            System.out.println(Arrays.toString(c.encoder));
            System.out.println(Arrays.toString(c.decoder));

        }
    }
}