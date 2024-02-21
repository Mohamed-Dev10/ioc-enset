package dao;

public class DaoImpl implements  IDao{
    @Override
    public double getData() {
        System.out.println("Version base de donnéée");
        double rest = Math.random()*40;
        return rest;
    }
}
