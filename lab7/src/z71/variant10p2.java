package z71;
import java.io.*;
import java.util.Scanner;

class Ozera implements Serializable {
    String name, loc;
    int s;
}

public class variant10p2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner (System.in, "cp1251");

        File f = new File ("C:\\Users\\DALev\\OneDrive\\Рабочий стол\\My\\MyFileVar9Ser.txt");
        f.createNewFile ( );

        FileOutputStream fos = new FileOutputStream (f);
        ObjectOutputStream oos = new ObjectOutputStream (fos);

        System.out.println ("Введите количество озёр");
        int k = sc.nextInt ( );
        sc.nextLine ( );


        System.out.println ("Введите информацию об озёре: ");
        for (int i = 0; i < k; i++) {

            Ozera oz = new Ozera ( );

            System.out.print ("Введите имя озера => ");
            oz.name = sc.nextLine ( );

            System.out.print ("Введите место расположение => ");
            oz.loc = sc.next ( );

            System.out.print ("Введите площадь озера => ");
            oz.s = sc.nextInt ( );
            oos.writeObject (oz);
            sc.nextLine ( );

        }

        oos.flush ( );
        oos.close ( );
        fos.close ( );
        sc.close ( );

        FileInputStream fis = new FileInputStream (f);
        ObjectInputStream oin = new ObjectInputStream (fis);
        Ozera ozero;
        for (int i = 0; i < k; i++) {
            ozero = (Ozera) oin.readObject ( );
            System.out.println (" Имя озера " + ozero.name);
            System.out.println (" Место расположения " + ozero.loc);
            System.out.println (" Площадь " + ozero.s);
        }
        oin.close ( );
        fis.close ( );

        File f2 = new File ("C:\\Users\\DALev\\OneDrive\\Рабочий стол\\My\\MyFileVar9SerOut.txt");
        if (f2.exists ( )) f2.delete ( );
        f2.createNewFile ( );

        FileOutputStream fos2 = new FileOutputStream (f2);
        ObjectOutputStream oos2 = new ObjectOutputStream (fos2);
        FileInputStream fis2 = new FileInputStream (f);
        ObjectInputStream oin2 = new ObjectInputStream (fis2);
        System.out.println ("Озёра с площадью больше 100");
        for (int i = 0; i < k; i++) {
            ozero = (Ozera) oin2.readObject ( );
            if (ozero.s > 100) {
                oos2.writeObject (ozero);
                System.out.println (" Имя озера " + ozero.name);
                System.out.println (" Место расположения " + ozero.loc);
                System.out.println (" Площадь " + ozero.s);
            }

        }

        oin2.close ( );
        fis2.close ();
        oos2.flush ();
        oos2.close ( );
        fos2.close ();


    }
}