package java8.lambdas.functinoal.programming.masses.chap2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : lh
 * @since : 2020/12/6, Sun
 **/
public class Swing {
    public static void main(String[] args) {
        {
            Button button = new Button();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("button clicked");
                }
            });
        }

        // use lambda
        {
            Button button = new Button();
            button.addActionListener(event-> System.out.println("button clicked"));
        }
    }
}
