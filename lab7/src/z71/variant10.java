package z71;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class variant10 {
    public static void main(String[] args) throws IOException {
        File f1 = new File ("Ozera.txt");
        if (f1.exists ( )) f1.delete ( );
        f1.createNewFile ( );
        RandomAccessFile rf = new RandomAccessFile (f1, "rw");
        Scanner sc = new Scanner (System.in);
        System.out.println ("Введите количество озёр");
        int k = sc.nextInt ( );
        sc.nextLine ( );
        String name, loc;
        int s;
        rf.seek (0);
        for (int i = 0; i < k; i++) {
            System.out.println ("Enter name");
            name = sc.next ( );
            rf.writeUTF (name);
            for (int j = 0; j < 20 - name.length ( ); j++)
                rf.writeByte (1);
            System.out.println ("Enter location");
            loc = sc.next ( );
            rf.writeUTF (loc);
            System.out.println ("Enter square");
            s = sc.nextInt ( );
            rf.writeInt (s);
        }
        System.out.println (rf.length ( ));
        rf.seek (0);
        System.out.println ("Информация об озёрах");
        System.out.println ("Имя \t\t Место расположения \t\t Площадь");
        for (int i = 0; i < k; i++) {
            name = rf.readUTF ( );
            for (int j = 0; j < 20 - name.length ( ); j++)
                rf.readByte ( );
            loc = rf.readUTF ( );
            s = rf.readInt ( );
            System.out.println (name + " " + loc + " " + s);
        }
        File f2 = new File ("OzerasOut.txt");
        if (f2.exists ( )) f2.delete ( );
        f2.createNewFile ( );
        RandomAccessFile rf2 = new RandomAccessFile (f2, "rw");
        rf.seek (0);
        rf2.seek (0);
        String locw, namew;
        int sw;

        int kk = 0;
        for (int i = 0; i < k; i++) {
            namew = rf.readUTF ( );
            for (int j = 0; j < 20 - namew.length ( ); j++)
                rf.readByte ( );
            locw = rf.readUTF ( );
            sw = rf.readInt ( );
            if (sw > 100) {
                kk++;
                rf2.writeUTF (namew);
                for (int j = 0; j < 20 - namew.length ( ); j++)
                    rf2.writeByte (1);
                rf2.writeUTF (locw);
                rf2.writeInt (sw);

            }
        }
        rf.close ( );
        System.out.println ("Озёра с площадью больше 100");
        rf2.seek (0);
        for (int i = 0; i < kk; i++) {
            namew = rf2.readUTF ( );
            for (int j = 0; j < 20 - namew.length ( ); j++)
                rf2.readByte ( );
            locw = rf2.readUTF ( );
            sw = rf2.readInt ( );
            System.out.println (namew + " " + locw + " " + sw);
        }
        rf2.close ( );
    }
}