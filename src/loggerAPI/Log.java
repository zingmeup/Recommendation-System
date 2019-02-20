package loggerAPI;

public class Log {
    static public void v(String tag,String message){
        String output="LOG/VERBOSE- "+tag+": "+message;
        String a=(char) 27 + "[36m"+output;
        System.out.println(a);
    }
    static public void a(String tag,String message){
        String output="LOG/ASSERT- "+tag+": "+message;
        String a=(char) 27 + "[32m"+output;
        System.out.println(a);
    }

    static public void e(String tag,String message){
        String output="LOG/ERROR- "+tag+": "+message;
        String a=(char) 27 + "[31m"+output;
        System.out.println(a);
    }
    static public void b(String tag,String message){
        String output="LOG/BUG- "+tag+": "+message;
        String a=(char) 27 + "[93m"+output;
        System.out.println(a);
    }
}
