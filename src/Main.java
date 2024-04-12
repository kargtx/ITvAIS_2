import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        new EnterF();
    }
}


//класс графики пользовательского окна и ввода/вывода данных
class EnterF extends JFrame {
    //создание переменных
    int b = 1;
    double x1 = -5;
    double x2 = 5;

    //создание текстовых полей
    TextField Tx1;
    TextField Tx2;
    TextField Tf;
    //создание окна
    JFrame JF;
    JPanel JP;
    JButton bt, bt2;
    JLabel answ;
    Font font = new Font("default", Font.BOLD, 15);

    EnterF() {
        //создание окна с настройками и полей ввода
        JF = new JFrame();
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JP = new JPanel();
        JF.add(JP);
        JP.setBackground(Color.YELLOW);
        JP.setLayout(null);


        JF.setSize(540, 350);
        JF.setTitle("ИТвАИС ЛР 2");

        //создание надписей
        JLabel Lf = new JLabel("Стоимость кВ электроэнергии:");
        JLabel Lx1 = new JLabel("Старое значение:");
        JLabel Lx2 = new JLabel("Новое значение:");

        //задание координат и начальных значений для текстовых полей и кнопок
        Tf = new TextField("17");
        Tf.setLocation(220, 20);
        Tf.setSize(50, 20);
        JP.add(Tf);

        Tx1 = new TextField("0", 40);
        Tx1.setLocation(220, 60);
        Tx1.setSize(50, 20);
        JP.add(Tx1);

        Tx2 = new TextField("0", 40);
        Tx2.setLocation(220, 100);
        Tx2.setSize(50, 20);
        JP.add(Tx2);

        Lf.setLocation(20, 20);
        Lf.setSize(200, 20);
        JP.add(Lf);

        Lx1.setLocation(20, 60);
        Lx1.setSize(400, 20);
        JP.add(Lx1);

        Lx2.setLocation(20, 100);
        Lx2.setSize(400, 20);
        JP.add(Lx2);

        bt = new JButton("Расчитать");
        bt.setLocation(80, 180);
        bt.setSize(150, 50);
        JP.add(bt);

        bt2 = new JButton("Сохранить");
        bt2.setLocation(310, 180);
        bt2.setSize(150, 50);
        JP.add(bt2);
        bt2.setVisible(false);


        answ = new JLabel("");
        answ.setLocation(10, 250);
        answ.setSize(500, 20);
        JP.add(answ);
        answ.setFont(font);

        JF.setVisible(true);
        JF.setResizable(false);

    }
}