package chap8;

/**
 * @author : lh
 * @since : 2020/6/5, Fri
 **/
public interface Task {
    void execute();

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task a) {
        a.execute();
    }

    public static void main(String[] args) {
        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger dander!!");
            }
        });
        // ambiguous method
        // doSomething(() -> System.out.println("Danger danger!!"));
    }
}



