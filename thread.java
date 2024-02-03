class Shareddata
{
    public static int randomint;
    public static boolean isgen=false;
    public static final Shareddata lock = new Shareddata();
}
class random extends Thread
{
    public void run(){
        for(int i=0;i<5;i++){
            synchronized(Shareddata.lock)
            {
                Shareddata.randomint=(int)(Math.random()*100);
                System.out.println("num Gen"+Shareddata.randomint);
                Shareddata.isgen=true;
                Shareddata.lock.notifyAll();
                try{
                    Thread.sleep(1000);
                    Shareddata.lock.wait();
                }
                catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }
}
class square extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            synchronized(Shareddata.lock){
                while(!Shareddata.isgen){
                    try{
                       Shareddata.lock.wait();
                    }
                    catch(InterruptedException e1)
                    {
                        System.out.println(e1);
                    }   
                }
                if(Shareddata.randomint%2==0){
                    System.out.println("square is"+Shareddata.randomint*Shareddata.randomint);
                    Shareddata.isgen=false;
                    Shareddata.lock.notifyAll();
                }
            }
        }
    }
}
class cube extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            synchronized(Shareddata.lock){
                while(!Shareddata.isgen){
                    try{
                       Shareddata.lock.wait();
                    }
                    catch(InterruptedException e2)
                    {
                        System.out.println(e2);
                    }   
                }
                if(Shareddata.randomint%2!=0){
                    System.out.println("cube is"+Shareddata.randomint*Shareddata.randomint*Shareddata.randomint);
                    Shareddata.isgen=false;
                    Shareddata.lock.notifyAll();
                }
            }
        }
    }
}
public class Main3{
    public static void main (String [] args){
        random r = new random();
        square s = new square();
        cube c = new cube();
        r.start();
        s.start();
        c.start();
        try{
            r.join();
            s.join();
            c.join();
        }
        catch(InterruptedException e3)
        {
            System.out.println(e3);
        }
    }
}
