import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbconnect {

    public static String vrniime(int a)
    {
        String ime = "";
        try {
            String uName = "rwnxlyblnkntlj";
            String uPass = "465c86b2ff6199771cf8e82088e23ce686b7fb951d00fae60c6ac7dc87fe9091";
            String host = "jdbc:postgresql://ec2-54-72-155-238.eu-west-1.compute.amazonaws.com:5432/d89q761es01jua";

            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(host, uName, uPass);

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM kraji WHERE id = "+ a +";" );
            while ( rs.next() ) {
                String  name = rs.getString("ime");

                System.out.println( "NAME = " + name );

                ime = name;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return ime;
    }

    public static String[] returnworkers(int podjetje_id)
    {
        String[] names = new String[1];
        try {
            String uName = "rwnxlyblnkntlj";
            String uPass= "465c86b2ff6199771cf8e82088e23ce686b7fb951d00fae60c6ac7dc87fe9091";
            String host = "jdbc:postgresql://ec2-54-72-155-238.eu-west-1.compute.amazonaws.com:5432/d89q761es01jua";

            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(host, uName, uPass);

            System.out.println( "SELECT * FROM delavci WHERE podjetje_id = " + podjetje_id + ";" );

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM delavci WHERE podjetje_id = " + podjetje_id + ";" );
            int st = 0;
            while ( rs.next() ) {
                st++;
            }
            rs.close();
            stmt.close();

            Statement stmt2 = c.createStatement();
            ResultSet rs2 = stmt2.executeQuery( "SELECT * FROM delavci WHERE podjetje_id = " + podjetje_id + ";" );

            names = new String[st];

            int st2 = 0;
            while ( rs2.next() ) {
                String  name = rs2.getString("ime");
                String surname = rs2.getString("priimek");

                String fullname = name + " " + surname;

                System.out.println( "Fullname = " + fullname );

                names[st2] = fullname;

                st2++;
            }

            rs2.close();
            stmt2.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return names;
    }

    public static Integer returncompanyid(String email, String geslo)
    {
        int id = 0;
        try {
            String uName = "rwnxlyblnkntlj";
            String uPass= "465c86b2ff6199771cf8e82088e23ce686b7fb951d00fae60c6ac7dc87fe9091";
            String host = "jdbc:postgresql://ec2-54-72-155-238.eu-west-1.compute.amazonaws.com:5432/d89q761es01jua";

            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(host, uName, uPass);

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT id FROM podjetja WHERE email = '" + email + "' AND geslo = '" + geslo + "';" );
            while ( rs.next() ) {
                int  idp = rs.getInt("id");

                System.out.println( "ID = " + idp );

                id = idp;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return id;
    }

    public static Integer returnworkerid(String imed, String priimekd, int id_p)
    {
        int id = 0;
        try {
            String uName = "rwnxlyblnkntlj";
            String uPass= "465c86b2ff6199771cf8e82088e23ce686b7fb951d00fae60c6ac7dc87fe9091";
            String host = "jdbc:postgresql://ec2-54-72-155-238.eu-west-1.compute.amazonaws.com:5432/d89q761es01jua";

            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(host, uName, uPass);

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT id FROM delavci WHERE ime = '" + imed + "' AND priimek = '" + priimekd + "' AND podjetje_id = "+ id_p +";" );
            while ( rs.next() ) {
                int  idp = rs.getInt("id");

                System.out.println( "ID = " + idp );

                id = idp;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return id;
    }


    public static Integer registerCompany(String imeP, String emailp, String geslo, String logo)
    {
        int id = 0;
        try {
            String uName = "rwnxlyblnkntlj";
            String uPass = "465c86b2ff6199771cf8e82088e23ce686b7fb951d00fae60c6ac7dc87fe9091";
            String host = "jdbc:postgresql://ec2-54-72-155-238.eu-west-1.compute.amazonaws.com:5432/d89q761es01jua";

            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(host, uName, uPass);

            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT companyRegister('" + imeP + "', '" + emailp + "', '" + geslo + "', '" + logo + "')" );

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return id;
    }
}
