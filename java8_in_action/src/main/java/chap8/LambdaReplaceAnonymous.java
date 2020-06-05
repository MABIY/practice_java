package chap8;

/**
 * @author : lh
 * @since : 2020/6/5, Fri
 **/
public class LambdaReplaceAnonymous {
    {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        Runnable r2 = () -> System.out.println("Hello");
    }

    {
        int a = 10;
        Runnable r1 = () -> {
//            int a = 2;
            System.out.println(a);
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };

    }


}
