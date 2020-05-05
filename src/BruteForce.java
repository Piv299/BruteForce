import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Forcer extends Thread
{
    private int a;
    public Forcer(int a){
        this.a=a;
    }
    @Override
    public void run()
    {
        char[] pass = new char[5];
        String[] heshes =
                {
                        "1115dd800feaacefdf481f1f9070374a2a81e27880f187396db67958b207cbad",
                        "3a7bd3e2360a3d29eea436fcfb7e44c735d117c42d1c1835420b6b9942dd4f1b",
                        "74e1bb62f8dabb8125a58852b63bdf6eaef667cb56ac7f7cdba6d7305c50a22f"
                };
        pass[0]=(char)(97+a);
        for (pass[1] = 97; pass[1]<123; pass[1]++)
            for (pass[2] = 97; pass[2]<123; pass[2]++)
                for (pass[3] = 97; pass[3]<123; pass[3]++)
                    for (pass[4] = 97; pass[4]<123; pass[4]++)
                    {
                        try{
                            String p = new String(pass);
                            byte[]  password = p.getBytes();
                            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                            byte[] digest = messageDigest.digest(password);
                            String b=new BigInteger(1, digest).toString(16);

                            for (int i=0; i<3; i++){
                                if (b.equals(heshes[i]))System.out.println(p+ " -> "+ heshes[i]);
                            }

                        }
                        catch (NoSuchAlgorithmException e){}
                    }
    }
}
public class BruteForce {
    public static Forcer[] f;
    public static void main(String[] args)
    {
        System.out.println("БАСО-02-18 Поляков И.В.");
        f=new Forcer[26];
        for(int i= 0;i<26;i++ )
        {
            f[i] = new Forcer(i);
            f[i].start();
        }
    }
}

