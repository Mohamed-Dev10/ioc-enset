package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class persentation2 {
   private static IMetier metier;
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new File("config.txt"));

        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getConstructor().newInstance();
        //  System.out.println(dao.getData());

        String metierClassName = scanner.nextLine();
        Class cmetier = Class.forName(metierClassName);
         metier = (IMetier) cmetier.getConstructor().newInstance();

        Method setDao = cmetier.getDeclaredMethod("setDao",IDao.class);
        setDao.invoke(metier,dao);

        System.out.println("Resultat => "+metier.calcul());
    }

}
